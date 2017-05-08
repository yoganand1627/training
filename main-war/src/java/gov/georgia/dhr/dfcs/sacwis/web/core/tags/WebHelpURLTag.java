/**
 * Created on Apr 12, 2007 at 3:20:02 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.tags;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Parameter;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenDefinitionsXmlDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

public class WebHelpURLTag extends TagSupport {
  private static final String TRACE_TAG = TagSupport.class.getSimpleName();
  private static final String HELP_PROPERTIES_NAME = "BSSCDefault.properties";
  private static final String WEB_HELP =
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "webHelp");

  // Cache the properties
  private static final Map<Parameter, String> WEB_HELP_MAP = new HashMap<Parameter, String>();

  static {
    try {
      Properties helpProps = new Properties();
      InputStream inStream = WebHelpURLTag.class.getClassLoader().getResourceAsStream(HELP_PROPERTIES_NAME);
      if (inStream != null) {
        helpProps.load(inStream);
      }
      for (Iterator<Object> it = helpProps.keySet().iterator(); it.hasNext();) {
        String key = (String) it.next();
        // Create two parameters, one for direct and one for not direct, to account for screen def problems.
        WEB_HELP_MAP.put(new Parameter("WebHelpKey", key, true), helpProps.getProperty(key));
        WEB_HELP_MAP.put(new Parameter("WebHelpKey", key, false), helpProps.getProperty(key));
      }
    } catch (IOException e) {
      // Just log this; it means that the help is not included in the deployment, which is typical of development.
      GrndsTrace.msg(TRACE_TAG, 3, "Web help not found.");
    }
  }

  public int doEndTag() throws JspException {
    JspWriter out = pageContext.getOut();
    try {
      String id = "0";
        // Get the screen; if it's null, throw an exception; we cannot do anything else
        Screen screen = (Screen) pageContext.getRequest().getAttribute(ScreenDefinitionsXmlDao.SCREEN);
        if (screen == null) {
          throw new JspException("Decorator Exception: screenManager not found in request.");
        }
        Parameter keyParam = screen.getParameter("WebHelpKey");
        if (WEB_HELP_MAP.containsKey(keyParam)) {
          id = WEB_HELP_MAP.get(keyParam);
        }
      out.print(id);
    } catch (IOException e) {
      // This would only happen if the conneciton was broken somehow, or the page already flushed;
      //   log it at a very low level.
      GrndsTrace.msg(TRACE_TAG, 10, "Failed to output web help url with exception: " + e.getMessage());
    }
    return EVAL_PAGE;
  }
}
