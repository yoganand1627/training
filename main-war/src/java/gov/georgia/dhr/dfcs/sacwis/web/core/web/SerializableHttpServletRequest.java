package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import java.io.BufferedReader;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.security.Principal;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

@SuppressWarnings({"deprecation", "SerializableClassWithUnconstructableAncestor"})
public class SerializableHttpServletRequest extends HttpServletRequestWrapper implements Externalizable {

  private static final String UNSUPPORTED_OPERATION_MESSAGE =
          "This is just a mock object used to support Serialization of the SerializableHttpServletRequest; " +
          "call HttpServletRequestWrapper.setRequest( HttpServletRequest ) to replace this object " +
          "before attempting to use the SerializableHttpServletRequest object.";

  // The following fields MUST be of type LinkedHashMap, not just Map,
  //   as they have to be Clonable for correct enumeration support.
  private LinkedHashMap<String, Object> attributes;
  private LinkedHashMap<String, String[]> parameterMap;
  private String originalRequestURI;
  private String currentQueryString;

  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(attributes);
    out.writeObject(parameterMap);
    out.writeObject(originalRequestURI);
  }

  @SuppressWarnings({"unchecked"})
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    attributes = (LinkedHashMap<String, Object>) in.readObject();
    parameterMap = (LinkedHashMap<String, String[]>) in.readObject();
    originalRequestURI = (String) in.readObject();
    // Extend DummyHttpServletRequest to allow for basic operations.
    setRequest(new DummyHttpServletRequest() {

      public Enumeration getAttributeNames() {
        return Collections.enumeration(attributes.keySet());
      }

      public String getParameter(String string) {
        String[] values = parameterMap.get(string);
        return values != null && values.length != 0 ? values[0] : null;
      }

      public void removeAttribute(String string) {
        attributes.remove(string);
      }

      @SuppressWarnings({"unchecked"})
      public Map getParameterMap() {
        return (LinkedHashMap<String, String[]>) parameterMap.clone();
      }

      public void setAttribute(String string, Object object) {
        attributes.put(string, object);
      }

      public Enumeration getParameterNames() {
        return Collections.enumeration(parameterMap.keySet());
      }

      public String[] getParameterValues(String string) {
        return parameterMap.get(string);
      }

      public Object getAttribute(String string) {
        return attributes.get(string);
      }
    });
  }

  /** Only necessary for serialization. */
  public SerializableHttpServletRequest() {
    super(new DummyHttpServletRequest());
  }

  public SerializableHttpServletRequest(HttpServletRequest delegateRequest) {
    super(delegateRequest);
    parameterMap = new LinkedHashMap<String, String[]>();
    Enumeration parameterNameEnumeration = delegateRequest.getParameterNames();
    while (parameterNameEnumeration.hasMoreElements()) {
      String key = (String) parameterNameEnumeration.nextElement();
      String[] value = delegateRequest.getParameterValues(key);
      parameterMap.put(key, value);
    }
    attributes = RequestUtil.getSafeAttributeMap(delegateRequest);
    String queryString = delegateRequest.getQueryString();
    originalRequestURI =
            queryString == null ? delegateRequest.getRequestURI() : delegateRequest.getRequestURI() + "?" + queryString;
    // Need to make sure that we have all the parameters
    updateParameters();
  }

  public void setOriginalRequest(ServletRequest delegateRequest) {
    if (!(delegateRequest instanceof HttpServletRequest)) {
      throw new IllegalArgumentException("SerializableHttpServletRequest requires a " +
                                         HttpServletRequest.class.getName() + " object as a delegate.");
    }
    super.setRequest(delegateRequest);
    // Make sure that we have all the parameters.
    updateParameters();
    // Replace the attributes in the parent request
    RequestUtil.removeAllAttributesSafe(delegateRequest);
    Iterator attributeNameIt = attributes.keySet().iterator();
    while (attributeNameIt.hasNext()) {
      String name = (String) attributeNameIt.next();
      delegateRequest.setAttribute(name, attributes.get(name));
    }
  }

  public String getOriginalRequestURI() {
    return originalRequestURI;
  }

  public String getParameter(String string) {
    // Need to make sure that we have all the parameters
    updateParameters();
    String[] parameterValues = parameterMap.get(string);
    return parameterValues != null ? parameterValues[0] : null;
  }

  private void updateParameters() {
    String queryString = getQueryString();
    //noinspection InstanceVariableUsedBeforeInitialized,StringEquality
    if (currentQueryString != queryString) {
      currentQueryString = queryString;
      if (queryString != null) {
        Map<String, List<String>> queryParams = new HashMap<String, List<String>>();
        String key = null;
        int keyStart = 0;
        String value;
        int valueStart = 0;
        int queryStringLength = queryString.length();
        for (int i = 0; i < queryStringLength; i++) {
          char c = queryString.charAt(i);
          if (c == '=') // detect the end of keys
          {
            key = queryString.substring(keyStart, i);
            // The value must be 1 character later
            valueStart = i + 1;
          } else if (c == '&' || c == ';') // detect the end of values
          {
            value = queryString.substring(valueStart, i);
            // once we ahve a value, insert it in the temporary map
            List<String> valueList = queryParams.get(key);
            if (valueList == null) {
              valueList = new LinkedList<String>();
              queryParams.put(key, valueList);
            }
            valueList.add(value);
            // Indicate that we've saved the key value
            //noinspection AssignmentToNull
            key = null;
            // The next key (if it exists) must be 1 character later
            keyStart = i + 1;
          }
        }
        // Get the last value
        if (key != null && valueStart < queryStringLength) {
          value = queryString.substring(valueStart, queryStringLength);
          // once we ahve a value, insert it in the temporary map
          List<String> valueList = queryParams.get(key);
          if (valueList == null) {
            valueList = new LinkedList<String>();
            queryParams.put(key, valueList);
          }
          valueList.add(value);
        }
        // Add the parameters to the existing parameters
        for (Iterator iterator = queryParams.keySet().iterator(); iterator.hasNext();) {
          key = (String) iterator.next();
          List<String> newValueList = queryParams.get(key);
          String[] existingValues = parameterMap.get(key);
          int valueArraySize = newValueList.size();
          String[] newValues;
          if (existingValues != null) {
            int existingArraySize = existingValues.length;
            newValues = new String[valueArraySize + existingArraySize];
            System.arraycopy(existingValues, 0, newValues, valueArraySize, existingArraySize);
          } else {
            newValues = new String[valueArraySize];
          }
          newValues = newValueList.toArray(newValues);
          parameterMap.put(key, newValues);
        }
      }
    }
  }

  @SuppressWarnings({"unchecked"})
  public Map getParameterMap() {
    // Need to make sure that we have all the parameters
    updateParameters();
    return (LinkedHashMap<String, String[]>) parameterMap.clone();
  }

  @SuppressWarnings({"unchecked"})
  public Enumeration getParameterNames() {
    // Need to make sure that we have all the parameters
    updateParameters();
    return Collections.enumeration(((LinkedHashMap<String, String[]>) parameterMap.clone()).keySet());
  }

  public String[] getParameterValues(String string) {
    // Need to make sure that we have all the parameters
    updateParameters();
    return parameterMap.get(string);
  }

  private static class DummyHttpServletRequest implements HttpServletRequest {

    public Enumeration getAttributeNames() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getParameter(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public void removeAttribute(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Map getParameterMap() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public void setAttribute(String string, Object object) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Enumeration getParameterNames() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String[] getParameterValues(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Object getAttribute(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public RequestDispatcher getRequestDispatcher(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getMethod() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public void setCharacterEncoding(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getHeader(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public int getContentLength() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getRemoteHost() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public boolean isRequestedSessionIdFromCookie() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public boolean isRequestedSessionIdFromUrl() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getProtocol() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public StringBuffer getRequestURL() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getRemoteAddr() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getContextPath() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getQueryString() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Enumeration getHeaderNames() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getRealPath(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getPathInfo() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getScheme() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getCharacterEncoding() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public HttpSession getSession(boolean b) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getServerName() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public BufferedReader getReader() throws IOException {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Cookie[] getCookies() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public boolean isSecure() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public long getDateHeader(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public HttpSession getSession() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Locale getLocale() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getAuthType() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getServletPath() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public int getIntHeader(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public boolean isRequestedSessionIdFromURL() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getRemoteUser() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Enumeration getLocales() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getPathTranslated() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Principal getUserPrincipal() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public ServletInputStream getInputStream() throws IOException {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public int getServerPort() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getRequestedSessionId() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public boolean isUserInRole(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public boolean isRequestedSessionIdValid() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public Enumeration getHeaders(String string) {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getContentType() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getRequestURI() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public int getLocalPort() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public int getRemotePort() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getLocalName() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public String getLocalAddr() {
      throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }
  }
}
