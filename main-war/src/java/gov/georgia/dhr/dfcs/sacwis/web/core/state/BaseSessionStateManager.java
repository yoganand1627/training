package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * Based on the Grnds Session State Management facility, this class defines the base methods of a session state
 * management strategy.  Subclasses will define the actual implementation of the add, get, remove attribute methods and
 * the getAttributeNames methods.
 * <p/>
 * This class should be general enough to function within either a server side or client side session-state management
 * strategy.
 */
public abstract class BaseSessionStateManager implements Serializable {
  public static final String STATE_MANAGER_KEY = "gov.georgia.dhr.dfcs.sacwis.web.core.state.manager";
  public static final String STATE_MANAGEMENT_ATTRIBUTES_KEY = "gov.georgia.dhr.dfcs.sacwis.web.core.state.attributes";
  public static final String CONTEXT_MANAGEMENT_KEY = "gov.georgia.dhr.dfcs.sacwis.web.core.state.context";
  private static final String TRACE_TAG = "BaseSessionStateManager";
  private static final long serialVersionUID = -1402308420577134108L;
  private ServletConfig configuration;

  abstract Map<String, Serializable> getContextParametersMap(HttpServletRequest request);

  abstract Map<String, Serializable> getAttributesMap(HttpServletRequest request);

  /**
   * Returns the servlet configuration that this strategy operates within.
   *
   * @return the servlet configuration that this strategy operates within
   */
  public final ServletConfig getServletConfiguration() {
    return configuration;
  }

  /**
   * Returns the servlet context that this strategy operates within. This utility function is the same as
   * getServletConfig().getServletContext().
   *
   * @return shortcut for getServletConfig().getServletContext() method
   */
  public final ServletContext getServletContext() {
    return getServletConfiguration().getServletContext();
  }

  /**
   * Set the servlet configuration
   *
   * @param configuration the servlet configuration
   */
  public final void setServletConfig(ServletConfig configuration) {
    this.configuration = configuration;
  }

  /**
   * Set the specified attribute to be stored by the session state manager
   *
   * @param name    the name of the attribute
   * @param value   the value of the attribute
   * @param request the incoming HttpServletRequest
   */
  public void setAttribute(String name, Object value, HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".setAttribute");
    Map<String, Serializable> attributesMap = getAttributesMap(request);
    attributesMap.put(name, (Serializable) value);
    GrndsTrace.exitScope();
  }

  /**
   * Remove the specified attribute from the session state manager
   *
   * @param name    the attribute to be removed
   * @param request - the incoming HttpServletRequest
   */
  public void removeAttribute(String name, HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".removeAttribute");
    Map attributesMap = getAttributesMap(request);
    attributesMap.remove(name);
    GrndsTrace.exitScope();
  }

  /**
   * Remove all attributes from the session state manager
   *
   * @param request - the incoming HttpServletRequest
   */
  public void removeAllAttributes(HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".removeAllAttributes");
    Map attributesMap = getAttributesMap(request);
    attributesMap.clear();
    GrndsTrace.exitScope();
  }

  /**
   * Retrieve an attribute object from the session state manager
   *
   * @param name    - the name of the attribute
   * @param request - the incoming HttpServletRequest
   * @return the request attribute
   */
  public Object getAttribute(String name, HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".getAttribute");
    Map attributesMap = getAttributesMap(request);
    GrndsTrace.exitScope();
    return attributesMap.get(name);
  }

  /**
   * Retrieve all the attribute names from the session state manager
   *
   * @param request - the incoming HttpServletRequest
   * @return the names of all attributes stored in the session state manager
   */
  public Iterator<String> getAttributeNames(HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".getAttributeNames");
    Map<String, Serializable> attributesMap = getAttributesMap(request);
    GrndsTrace.exitScope();
    return attributesMap.keySet().iterator();
  }

  /**
   * Retrieve an context parameter from the session state manager
   *
   * @param name    - the name of the context parameter
   * @param request - the incoming HttpServletRequest
   * @return the requested context parameter
   */
  public Serializable getContextParameter(String name, HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".getContextParameter");
    Map<String, Serializable> contextParametersMap = getContextParametersMap(request);
    GrndsTrace.exitScope();
    return contextParametersMap.get(name);

  }

  /**
   * Retrieve all the context parameter names from the session state manager
   *
   * @param request - the incoming HttpServletRequest
   * @return the names of all context parameters stored in the session state manager
   */
  public Iterator<String> getContextParameterNames(HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".getContextParameterNames");
    Map<String, Serializable> contextParametersMap = getContextParametersMap(request);
    GrndsTrace.exitScope();
    return contextParametersMap.keySet().iterator();
  }

  /**
   * Remove the specified context parameter from the session state manager
   *
   * @param name    the context parameter to be removed
   * @param request - the incoming HttpServletRequest
   */
  public void removeContextParameter(String name, HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".removeContextParameter");
    Map<String, Serializable> contextParametersMap = getContextParametersMap(request);
    contextParametersMap.remove(name);
    GrndsTrace.exitScope();
  }

  /**
   * Remove all context parameters from the session state manager
   *
   * @param request - the incoming HttpServletRequest
   */
  public void removeAllContextParameters(HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".removeAllContextParameters");
    Map<String, Serializable> contextParametersMap = getContextParametersMap(request);
    contextParametersMap.clear();
    GrndsTrace.exitScope();
  }

  /**
   * Set the specified context parameter to be stored by the session state manager
   *
   * @param name    the name of the context parameter
   * @param value   the value of the context parameter
   * @param request the incoming HttpServletRequest
   */
  public void setContextParameter(String name, Serializable value, HttpServletRequest request) {
    GrndsTrace.enterScope(BaseSessionStateManager.TRACE_TAG + ".setContextParameter");
    Map<String, Serializable> contextParametersMap = getContextParametersMap(request);
    contextParametersMap.put(name, value);
    GrndsTrace.exitScope();
  }

  /**
   * Clears all attributes and parameters.
   *
   * @param request
   */
  public void clearAll(HttpServletRequest request) {
    removeAllAttributes(request);
    removeAllContextParameters(request);
  }

  @SuppressWarnings({"NonFinalFieldReferenceInEquals"})
  public boolean equals(Object rhs) {
    boolean result = super.equals(rhs);
    if (result && rhs instanceof BaseSessionStateManager) {
      BaseSessionStateManager RHS = (BaseSessionStateManager) rhs;
      result = (configuration == RHS.getServletConfiguration());
    }
    return result;
  }

  @SuppressWarnings({"NonFinalFieldReferencedInHashCode"})
  public int hashCode() {
    int result = super.hashCode();
    if (configuration != null) {
      result ^= configuration.hashCode();
    }
    return result;
  }

  /**
   * method which can be overriden to specify an initialization behavior for a paricular session state management
   * strategy
   *
   * @param context the GrndsExchangeContext for the current exchange
   */
  public void doPreExchange(GrndsExchangeContext context) {
  }

  protected final String getEnvironmentAttribute(String name) {
    String result = getServletConfiguration().getInitParameter(name);
    if (result == null) {
      result = (String) getServletContext().getAttribute(name);
    }
    return result;
  }

  protected String doToString() {
    return "servlet-config=" + configuration;
  }
}
