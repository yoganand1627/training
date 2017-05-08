/**
 * User: mkw
 * Date: Nov 11, 2002
 * Time: 3:22:51 PM
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.foundation.util.GrndsQName;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.RepostCheckUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.BaseFormElementTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.BaseHtmlTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.RequestUtil;
import com.jamonapi.MonitorFactory;
import com.jamonapi.Monitor;

public class IncludeTag extends BodyTagSupport {

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    GrndsTrace.exitScope();

    try {
      pageContext.getOut().flush();
    } catch (IOException e) {
      throw new JspException("Error flushing output buffer.", e);
    }

    attributeMap = new HashMap<String, Object>();
    parameterMap = new HashMap<String, String>();
    returnSet = new HashSet<String>();

    // put tabindex in the attribute map
    attributeMap.put("tabIndex", String.valueOf(tabIndex));

    return Tag.EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doendTag");

    // make sure that we have a page attribute
    if (this.page == null || this.page.length() == 0) {
      throw new JspException("The page attribute must be set.");
    }

    // get the request and response objects
    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

    // remove and save existing attributes that do not start with "javax." or "org.apache."
    Map<String, Object> oldAttributes = new HashMap<String, Object>();
    Enumeration enumeration = request.getAttributeNames();
    while (enumeration.hasMoreElements()) {
      String name = (String) enumeration.nextElement();
      Object value = request.getAttribute(name);
      if (!unchangedAttributes.contains(name) &&
          !name.startsWith(RequestUtil.JAVAX_PACKAGE) && !name.startsWith(RequestUtil.APACHE_PACKAGE)) {
        oldAttributes.put(name, value);
        request.removeAttribute(name);
      }
    }

    // set the calling page  and the display into the state so that they can be used by IncludePresentation and activity methods
    BaseSessionStateManager state =
            (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    state.setAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, this.callingPage, request);
    state.setAttribute(IncludeTag.SUBMODULE_DISPLAY_COMMAND_KEY, this.page, request);

    // set user attributes into the request object
    Iterator it = attributeMap.keySet().iterator();
    while (it.hasNext()) {
      String name = (String) it.next();
      request.setAttribute(name, attributeMap.get(name));
    }

    // set magic grnds attributes into the request object
    request.setAttribute("originalReqeust", page);
    request.setAttribute(GrndsExchangeContext.COMAMAND_REQ_ATTRIB, commandName);
    request.setAttribute(GrndsExchangeContext.CONVERSATION_REQ_ATTRIB, servletName + "/" + conversationName);
    request.setAttribute(ServerSideValidationUtility.FORM_VALIDATION_FORCE_VALID_FLAG, ArchitectureConstants.TRUE);
    request.setAttribute(GrndsExchangeContext.SERVLET_MAPPING_REQ_ATTRIB, servletName);

    // fake the qname by creating it manually instead of using a factory
    GrndsQName qname = new GrndsQName(servletName + "/" + conversationName, commandName);
    request.setAttribute("grnds.request.qname", qname);

    // encode parameters into the request object
    String includeUrl = this.page;
    StringBuffer sb = new StringBuffer();
    it = parameterMap.keySet().iterator();
    while (it.hasNext()) {
      String name = (String) it.next();
      String value = request.getParameter(name);
      sb.append(name).append("=").append(value).append("&");
    }
    if (sb.length() > 0) {
      includeUrl = response.encodeURL(includeUrl + "?" + sb.substring(0, sb.length() - 1));
    } else {
      includeUrl = response.encodeURL(includeUrl);
    }

    // put the including form name into the request
    request.setAttribute(INCLUDING_FORM_NAME_KEY, this.includingForm);

    // put the parent form object in the request, if applicable; do NOT use BaseTag.getParentFormTag() becuase this is what sets that
    FormTag parent = (FormTag) findAncestorWithClass(this, FormTag.class);
    if (parent != null) {
      request.setAttribute(BaseHtmlTag.INCLUDING_PAGE_FORM_KEY, parent);
    }
    // do the include
    RequestDispatcher rd = request.getRequestDispatcher(includeUrl);
    Monitor monitor = MonitorFactory.start(includeUrl);
    try {
      rd.include(request, response);
    } catch (ServletException se) {
      GrndsTrace.msg(TRACE_TAG, 7,
                     "Submodule Include Exception: IncludeTag:doEndTag caught: " + se.getClass() + "\n" +
                     se.getMessage());
      Throwable rc = se.getRootCause();
      if (rc != null) {
        GrndsTrace.msg(TRACE_TAG, 7,
                       "Submodule Include Exception: IncludeTag:doEndTag rootCause: " + rc.getClass() + "\n" +
                       rc.getMessage());
      }
      throw new JspException("Submodule Include Exception: IncludeTag:doEndTag caught: " + se.getMessage(), se);
    } catch (IOException e) {
      GrndsTrace.msg(TRACE_TAG, 7,
                     "Submodule Include Exception: IncludetTag:doEndTag caught: " + e.getClass() + "\n" + e);
      throw new JspException("Submodule Include Exception: IncludetTag:doEndTag caught: " + e, e);
    } finally {
      monitor.stop();
    }

    // remove the form tag attribute
    request.removeAttribute(BaseHtmlTag.INCLUDING_PAGE_FORM_KEY);

    // remove the form name attribute
    request.removeAttribute(INCLUDING_FORM_NAME_KEY);

    // remove attributes that were added unless they are return values, unchanged attributes or javax.* attributes
    enumeration = request.getAttributeNames();
    while (enumeration.hasMoreElements()) {
      String name = (String) enumeration.nextElement();
      if (!returnSet.contains(name) && !unchangedAttributes.contains(name) &&
          !name.startsWith(RequestUtil.JAVAX_PACKAGE) && !name.startsWith(RequestUtil.APACHE_PACKAGE)) {
        request.removeAttribute(name);
      }
    }

    // put the old attributes back in, making sure not to write over the return valuse
    it = oldAttributes.keySet().iterator();
    while (it.hasNext()) {
      String name = (String) it.next();
      if (!returnSet.contains(name)) {
        request.setAttribute(name, oldAttributes.get(name));
      }
    }

    GrndsTrace.exitScope();
    return Tag.EVAL_PAGE;
  }

  public void addAttribute(String name, Object value) {
    attributeMap.put(name, value);
  }

  public void addParameter(String name, String value) {
    parameterMap.put(name, value);
  }

  public void addReturn(String name) {
    returnSet.add(name);
  }

  public void setPage(String page) throws JspException {
    this.page = page;
    // parse the page out into its parts
    StringTokenizer st = new StringTokenizer(page, "/");
    if (st.hasMoreTokens()) {
      servletName = st.nextToken();
      if (st.hasMoreTokens()) {
        conversationName = st.nextToken();
        if (st.hasMoreTokens()) {
          commandName = st.nextToken();
        }
      }
    }
    if (st.hasMoreTokens() || servletName == null || conversationName == null || commandName == null) {
      throw new JspException(
              "The include tag requires that the page parameterString be in the form \"/servlet/conversation/action\".");
    }
  }

  public void setCallingPage(String callingPage) {
    this.callingPage = callingPage;
  }

  public void setIncludingForm(String includingForm) {
    this.includingForm = includingForm;
  }

  public void setTabIndex(int tabIndex) {
    // Adds tabIndex to the parameter list; ensure that there is only one no matter how many times it's set
    this.tabIndex = tabIndex;
  }

  private String page = null;
  private String servletName = null;
  private String conversationName = null;
  private String commandName = null;
  private String callingPage = null;
  private String includingForm = null;

  private Map<String, Object> attributeMap = null;
  private Map<String, String> parameterMap = null;
  private Set<String> returnSet = null;

  private int tabIndex = -1;

  private static final Set<String> unchangedAttributes = new HashSet<String>();

  {
    unchangedAttributes.add("grnds_configuration_domain");
    unchangedAttributes.add(BaseSessionStateManager.STATE_MANAGER_KEY);
    unchangedAttributes.add(BaseSessionStateManager.STATE_MANAGEMENT_ATTRIBUTES_KEY);
    unchangedAttributes.add(BaseSessionStateManager.CONTEXT_MANAGEMENT_KEY);
    unchangedAttributes.add(BaseFormElementTag.INCLUDING_PAGE_FORM_KEY);
    unchangedAttributes.add("XML_VALUE_BEAN_KEY");  // todo: remove this; it's only for debugging purposes
    unchangedAttributes.add(RepostCheckUtility.REPOST_CODES_ATTRIBUTE_NAME);
  }

  public static final String INCLUDING_PAGE_DISPLAY_COMMAND_KEY = "IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY";
  public static final String SUBMODULE_DISPLAY_COMMAND_KEY = "IncludeTag.SUBMODULE_DISPLAY_COMMAND_KEY";
  public static final String INCLUDING_FORM_NAME_KEY = "IncludeTag.INCLUDING_FORM_NAME_KEY";

  private static final String TRACE_TAG = "IncludeTag";
}
