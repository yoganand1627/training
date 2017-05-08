package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.foundation.util.GrndsQName;
import org.grnds.structural.web.GrndsBasicHttpConversation;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;

/**
 * This class is used by the Web Page From Validation Framework to maintain the state of objects when a Form is
 * Redisplayed when there are invalid fields on a web page. The RequestAttributes object will collect all serializeable
 * objects stored to the request and put them in a hidden field on the page.
 *
 * @author Phillip T. Bernard
 */
public class RequestAttributes {
  public static final String TRACE_TAG = "RequestAttributes";
  public static final String FORM_ATTRIBUTES_REQUEST_PARAM = "FormValidationRequestAttributes";

  private Map<String, Object> attributes = new HashMap<String, Object>();

  @SuppressWarnings({"CloneableClassWithoutClone"})
  private static Set<String> excludeAttributes = new HashSet<String>() {
    {
      add(HiddenFieldSessionStateManager.STATE_MANAGER_KEY);
      add(ServerSideValidationUtility.REFRESH_WIDGETS_FROM_REQUEST);
      add(GrndsExchangeContext.COMAMAND_REQ_ATTRIB);
      add(GrndsExchangeContext.CONVERSATION_REQ_ATTRIB);
      add(GrndsExchangeContext.SERVLET_MAPPING_REQ_ATTRIB);
      add(GrndsBasicHttpConversation.COMMAND_BRANCH_ATTRIBUTE);
      add(BasePrsConversation.ERROR_MESSAGES);
      add(BasePrsConversation.INFO_MESSAGES);
      add(BasePrsConversation.POPUP_MESSAGES);
      add(HiddenFieldSessionStateManager.STATE_MANAGEMENT_ATTRIBUTES_KEY);
    }
  };

  /**
   * This method takes any serializeable objects that have been stored to the request and populates the
   * RequestAttributes object with them.
   *
   * @param request The request containing the attributes
   */
  public void setRequestAttributesFromRequest(HttpServletRequest request) {
    GrndsTrace.enterScope(RequestAttributes.TRACE_TAG + ".setRequestAttributesFromRequest()");
    Enumeration attributeNames = request.getAttributeNames();
    while (attributeNames.hasMoreElements()) {
      String attributeName = (String) attributeNames.nextElement();
      Object attribute = request.getAttribute(attributeName);
      if (attribute instanceof Serializable &&
          !(attribute instanceof FormValidation) &&
          !(attribute instanceof Screen) &&
          !(attribute instanceof GrndsExchangeContext) &&
          !(attribute instanceof GrndsQName) &&
          !(excludeAttributes.contains(attributeName))) {
        GrndsTrace.msg(RequestAttributes.TRACE_TAG, 7, attributeName + " added to RequestAttributes Object");
        this.attributes.put(attributeName, attribute);
      }
    }
    GrndsTrace.exitScope();
  }

  /**
   * This method takes the key value pairs that are contained within the RequestAttributes object and sets them back to
   * the request.
   *
   * @param request The request to hold the attributes
   */
  public void restoreRequestAttributesToRequest(HttpServletRequest request) {
    Iterator iterator = this.attributes.keySet().iterator();
    while (iterator.hasNext()) {
      String attributeName = (String) iterator.next();
      Object attribute = this.attributes.get(attributeName);

      request.setAttribute(attributeName, attribute);
    }
  }

  /**
   * This method encodes the data that is stored in the RequestAttributes object so that it can be printed to the page
   * as a hidden field.
   *
   * @return - This FromAttributes object as an encoded String.
   */
  public String encodeRequestAttributes() throws JspException {
    GrndsTrace.enterScope(RequestAttributes.TRACE_TAG + ".encodeRequestAttributes()");

    String encodedRequestAttributes;
    try {
      ObjectOutputStream objectOut = null;
      try {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        objectOut = new ObjectOutputStream(byteOut);
        objectOut.writeObject(this.attributes);
        byte[] byteArray = byteOut.toByteArray();
        encodedRequestAttributes = Base64.encode(byteArray);
      } finally {
        if (objectOut != null) {
          objectOut.close();
        }
      }
    } catch (IOException ioe) {
      throw new JspException("unable to encode the request attributes", ioe);
    }

    GrndsTrace.exitScope();
    return encodedRequestAttributes;
  }

  /**
   * This method takes an encoded RequestAttributes string and decodes it.
   *
   * @param encodedRequestAttributes The encoded RequestAttributes object as a String
   * @throws ServletException if anything goes wrong
   */
  @SuppressWarnings({"unchecked"})
  public void decodeRequestAttributes(String encodedRequestAttributes) throws ServletException {
    GrndsTrace.enterScope(RequestAttributes.TRACE_TAG + ".decodeRequestAttributes()");
    try {
      ObjectInputStream objectIn = null;
      try {
        byte[] serializedBytes = Base64.decode(encodedRequestAttributes);
        ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(serializedBytes);
        objectIn = new ObjectInputStream(byteArrayIn);
        this.attributes = (Map) objectIn.readObject();
      } finally {
        if (objectIn != null) {
          objectIn.close();
        }
      }
    }
    catch (IOException ioe) {
      throw new ServletException("unable to decode the request attributes", ioe);
    }
    catch (ClassNotFoundException cnfe) {
      throw new ServletException("unable to decode the request attributes", cnfe);
    }
    GrndsTrace.exitScope();
  }

  /**
   * Get the attributes for this FormAttriubtes object
   *
   * @return Map - a Map containing the attriubtes from the request
   */
  public Map getAttributes() {
    return this.attributes;
  }

  /**
   * Sets the attributes for this RequestAttributes object
   *
   * @param attributes the request attributes
   */
  public void setAttributes(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  public String toString() {
    StringBuffer buffer = new StringBuffer();
    Iterator<String> keys = this.attributes.keySet().iterator();
    while (keys.hasNext()) {
      String key = keys.next();
      Object value = this.attributes.get(key);
      buffer.append("Key: [").append(key).append("]\nValue: [").append(value).append("]\n");
    }
    return buffer.toString();
  }
}