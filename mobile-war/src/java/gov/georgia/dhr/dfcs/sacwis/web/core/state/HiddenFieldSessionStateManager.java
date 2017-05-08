package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 *
 */
public class HiddenFieldSessionStateManager extends BaseSessionStateManager {

  /** Default constructor */
  public HiddenFieldSessionStateManager() {
  }

  /**
   * Creates a new CivHiddenFieldSessionManagement instance by taking an incoming request and decoding the hidden field
   * value into a HashMap which can be used to store and work with session data
   */
  public HiddenFieldSessionStateManager(HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    decodeHiddenField(request);
    GrndsTrace.exitScope();
  }

  /**
   * Prior to each exchange, this method tries to decode the hidden field sumitted as part of the HttpServletRequest
   *
   * @param context the exchange context for the current request
   */
  public void doPreExchange(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    decodeHiddenField(context.getRequest());
    GrndsTrace.exitScope();
  }

  /**
   * This method looks for the hidden field which contains an encoded, serialized attribute map, and decodes and
   * deserializes it if possible.
   *
   * @param request the incoming HttpServletRequest
   */
  void decodeHiddenField(HttpServletRequest request) {
    GrndsTrace.enterScope(HiddenFieldSessionStateManager.TRACE_TAG + ".decodeHiddenField");
    // Check to see if the attributes are already there -- e.g. in the case of a forwarded request;
    //   note that this is the STATE_MANAGER_KEY, and NOT the STATE_MANAGEMENT_ATTRIBUTES_KEY because
    //   the getAttributesMap() handles the case in which the value STATE_MANAGEMENT_ATTRIBUTES_KEY
    //   stored with STATE_MANAGEMENT_ATTRIBUTES_KEY is null after the first call to this method.
    //   If this method has executed and the value stored with STATE_MANAGEMENT_ATTRIBUTES_KEY is
    //   null, it means that either there was no hidden field state parameter in the request (or
    //   it was empty, as is the case with top level tabs), or decoding it failled.
    if (request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY) == null) {
      // Set this object onto the request first so it doesn't decode state
      //   more than once per request, even if the deserialization fails.
      request.setAttribute(BaseSessionStateManager.STATE_MANAGER_KEY, this);

      String incomingParameter = request.getParameter(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
      Map attributesMap;
      if (StringHelper.isValid(incomingParameter)) {
        byte[] serializedBytes = Base64.decode(incomingParameter);
        ObjectInputStream objectIn = null;
        try {
          ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(serializedBytes);
          objectIn = new ObjectInputStream(byteArrayIn);
          attributesMap = (Map) objectIn.readObject();
          request.setAttribute(BaseSessionStateManager.STATE_MANAGEMENT_ATTRIBUTES_KEY, attributesMap);
        } catch (Exception e) {
          throw new StateException(MessageLookup.getMessageByNumber(Messages.MSG_NETWORK_ERROR), e,
                                   StateException.WARNING_PRIORITY);
        } finally {
          if (objectIn != null) {
            try {
              objectIn.close();
            } catch (IOException e) {
              // Ignore this.
            }
          }
        }
      }
    }
    GrndsTrace.exitScope();
  }

  /**
   * Following a request, this method serializes and encodes the attribute map so that it can be transmitted to the
   * client, allowing session state to be maintained on the client side.
   *
   * @param request the incoming HttpServletRequest
   * @return Serialized and encoded attribute map
   */
  public String encodeAttributesMap(HttpServletRequest request) {
    GrndsTrace.enterScope(HiddenFieldSessionStateManager.TRACE_TAG + ".encodeAttributesMap");
    String encodedMap = "";
    Map attributesMap = this.getAttributesMap(request);

    if (attributesMap != null && attributesMap.size() > 0) {
      ObjectOutputStream objectOut = null;
      try {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        objectOut = new ObjectOutputStream(byteOut);
        objectOut.writeObject(attributesMap);
        byte[] byteArray = byteOut.toByteArray();
        encodedMap = Base64.encode(byteArray);
      } catch (IOException e) {
        throw new StateException("Sesssion state manager encountered problems serializing the attributes map",
                                 e, StateException.WARNING_PRIORITY);
      } finally {
        try {
          if(objectOut != null) {
            objectOut.close();
          }
        } catch (IOException e) {
          // Ignore this
        }
      }
    }
    GrndsTrace.exitScope( /*encodedMap*/);
    return encodedMap;
  }

  @SuppressWarnings({"unchecked"})
  Map<String, Serializable> getAttributesMap(HttpServletRequest request) {
    Map<String, Serializable> attributesMap =
            (Map<String, Serializable>) request.getAttribute(BaseSessionStateManager.STATE_MANAGEMENT_ATTRIBUTES_KEY);
    if (attributesMap == null) {
      attributesMap = new HashMap<String, Serializable>();
      request.setAttribute(BaseSessionStateManager.STATE_MANAGEMENT_ATTRIBUTES_KEY, attributesMap);
    }
    return attributesMap;
  }

  /**
   * @param request
   * @return A HashMap because the returned value must be Serializable.
   */
  @SuppressWarnings({"unchecked"})
  HashMap<String, Serializable> getContextParametersMap(HttpServletRequest request) {
    Map<String, Serializable> attributesMap = this.getAttributesMap(request);
    HashMap<String, Serializable> contextParametersMap =
            (HashMap<String, Serializable>) attributesMap.get(BaseSessionStateManager.CONTEXT_MANAGEMENT_KEY);
    if (contextParametersMap == null) {
      contextParametersMap = new HashMap<String, Serializable>();
      attributesMap.put(BaseSessionStateManager.CONTEXT_MANAGEMENT_KEY, contextParametersMap);
    }
    return contextParametersMap;
  }

  /**
   * Remove all attributes from the session state manager
   *
   * @param request - the incoming HttpServletRequest
   */
  public void removeAllAttributes(HttpServletRequest request) {
    GrndsTrace.enterScope(HiddenFieldSessionStateManager.TRACE_TAG + ".removeAllAttributes");
    Map<String, Serializable> attributesMap = this.getAttributesMap(request);
    HashMap<String, Serializable> contextParameters = getContextParametersMap(request);
    attributesMap.clear();
    attributesMap.put(CONTEXT_MANAGEMENT_KEY, contextParameters);
    GrndsTrace.exitScope();
  }

  /**
   * Remove everything from global data and state
   *
   * @param request - the incoming HttpServletRequest
   */
  public void clearAll(HttpServletRequest request) {
    //GlobalData is in State; replacing state's hashMap, we remove it all
    request.setAttribute(BaseSessionStateManager.STATE_MANAGEMENT_ATTRIBUTES_KEY, new HashMap());
  }

  public static final String HIDDEN_FIELD_KEY = "hiddenField";
  private static final String TRACE_TAG = "HiddenFieldSessionStateManager";
}
