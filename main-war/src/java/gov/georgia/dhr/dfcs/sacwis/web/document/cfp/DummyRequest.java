package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Adapter object which implements HttpServletRequest. Only supports Attribute functions and getSession. Used to pass
 * data to different document functions.
 */
@SuppressWarnings({"deprecation"})
public class DummyRequest implements HttpServletRequest {

  protected DummySession dummySession = new DummySession();
  protected Map<String, Object> map = new HashMap<String, Object>();

  public void setAttribute(String name, Object value) {
    if (value == null) {
      return;
    }
    map.put(name, value);
  }

  public Object getAttribute(String name) {
    return map.get(name);
  }

  public void removeAttribute(String name) {
    map.remove(name);
  }

  public Enumeration getAttributeNames() {
    return Collections.enumeration(map.keySet());
  }

  public HttpSession getSession(boolean create) {
    return dummySession;
  }

  public HttpSession getSession() {
    return dummySession;
  }

  public String getAuthType() {
    throw new IllegalStateException("not supported");
  }

  public Cookie[] getCookies() {
    throw new IllegalStateException("not supported");
  }

  public long getDateHeader(String string) {
    throw new IllegalStateException("not supported");
  }

  public String getHeader(String string) {
    throw new IllegalStateException("not supported");
  }

  public Enumeration getHeaders(String string) {
    throw new IllegalStateException("not supported");
  }

  public Enumeration getHeaderNames() {
    throw new IllegalStateException("not supported");
  }

  public int getIntHeader(String string) {
    throw new IllegalStateException("not supported");
  }

  public String getMethod() {
    throw new IllegalStateException("not supported");
  }

  public String getPathInfo() {
    throw new IllegalStateException("not supported");
  }

  public String getPathTranslated() {
    throw new IllegalStateException("not supported");
  }

  public String getContextPath() {
    throw new IllegalStateException("not supported");
  }

  public String getQueryString() {
    throw new IllegalStateException("not supported");
  }

  public String getRemoteUser() {
    throw new IllegalStateException("not supported");
  }

  public boolean isUserInRole(String string) {
    throw new IllegalStateException("not supported");
  }

  public Principal getUserPrincipal() {
    throw new IllegalStateException("not supported");
  }

  public String getRequestedSessionId() {
    throw new IllegalStateException("not supported");
  }

  public String getRequestURI() {
    throw new IllegalStateException("not supported");
  }

  public StringBuffer getRequestURL() {
    throw new IllegalStateException("not supported");
  }

  public String getServletPath() {
    throw new IllegalStateException("not supported");
  }

  public boolean isRequestedSessionIdValid() {
    throw new IllegalStateException("not supported");
  }

  public boolean isRequestedSessionIdFromCookie() {
    throw new IllegalStateException("not supported");
  }

  public boolean isRequestedSessionIdFromURL() {
    throw new IllegalStateException("not supported");
  }

  public boolean isRequestedSessionIdFromUrl() {
    throw new IllegalStateException("not supported");
  }

  public String getCharacterEncoding() {
    throw new IllegalStateException("not supported");
  }

  public void setCharacterEncoding(String string)
          throws UnsupportedEncodingException {
    throw new IllegalStateException("not supported");
  }

  public int getContentLength() {
    throw new IllegalStateException("not supported");
  }

  public int getLocalPort() {
    throw new IllegalStateException("not supported");
  }

  public int getRemotePort() {
    throw new IllegalStateException("not supported");
  }

  public String getContentType() {
    throw new IllegalStateException("not supported");
  }

  public String getLocalAddr() {
    throw new IllegalStateException("not supported");
  }

  public String getLocalName() {
    throw new IllegalStateException("not supported");
  }

  public ServletInputStream getInputStream()
          throws IOException {
    throw new IllegalStateException("not supported");
  }

  public String getParameter(String string) {
    throw new IllegalStateException("not supported");
  }

  public Enumeration getParameterNames() {
    throw new IllegalStateException("not supported");
  }

  public String[] getParameterValues(String string) {
    throw new IllegalStateException("not supported");
  }

  public Map getParameterMap() {
    throw new IllegalStateException("not supported");
  }

  public String getProtocol() {
    throw new IllegalStateException("not supported");
  }

  public String getScheme() {
    throw new IllegalStateException("not supported");
  }

  public String getServerName() {
    throw new IllegalStateException("not supported");
  }

  public int getServerPort() {
    throw new IllegalStateException("not supported");
  }

  public BufferedReader getReader()
          throws IOException {
    throw new IllegalStateException("not supported");
  }

  public String getRemoteAddr() {
    throw new IllegalStateException("not supported");
  }

  public String getRemoteHost() {
    throw new IllegalStateException("not supported");
  }

  public Locale getLocale() {
    throw new IllegalStateException("not supported");
  }

  public Enumeration getLocales() {
    throw new IllegalStateException("not supported");
  }

  public boolean isSecure() {
    throw new IllegalStateException("not supported");
  }

  public RequestDispatcher getRequestDispatcher(String string) {
    throw new IllegalStateException("not supported");
  }

  public String getRealPath(String string) {
    throw new IllegalStateException("not supported");
  }
}


