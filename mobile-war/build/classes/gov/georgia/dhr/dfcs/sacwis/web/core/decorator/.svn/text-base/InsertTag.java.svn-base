/*
* Accenture modified code originally found in the Java Petstore Application
*
* $Id: InsertTag.java,v 1.11.4.1 2001/03/15 00:40:08 brydon Exp $
* Copyright 2001 Sun Microsystems, Inc. All rights reserved.
*
*/

package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;

/** This tag is used to include screen parameters into the presentation template. */
public class InsertTag extends TagSupport {

  private static final String TRACE_TAG = "InsertTag";

  private boolean directInclude = false;
  private String parameter = null;
  private Parameter parameterRef = null;

  /** Set the parameter to be included */
  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    try {
      pageContext.getOut().flush();
    } catch (IOException e) {
      // Only throw if a SocketException is NOT found in the exception stack; this happens whenever the user stops
      //   loading the page by clicking somewhere else, closing the browser, or hitting "stop."  There is nothing
      //   that we can do about it, and it's not worth logging it.
      if (!ExceptionHandler.recurisiveCauseTypeCheck(e, SocketException.class, new HashSet<Throwable>())) {
        throw new JspException("Failure flusing page.", e);
      }
    }

    // Get the screen; if it's null, throw an exception; we cannot do anything else
    Screen screen = (Screen) pageContext.getRequest().getAttribute(ScreenDefinitionsXmlDao.SCREEN);
    if (screen == null) {
      throw new JspException("Decorator Exception: screenManager not found in request.");
    }
    GrndsTrace.msg(TRACE_TAG, 5, "Screen: " + screen);

    // Check to see if parameter is null; if it is, throw an exception.
    if (parameter == null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Decorator Exception: Screen parameter is null");
      throw new JspException("Decorator Exception: Screen screen parameter is null");
    }

    // Get the screen definition for the parameter; throw an exception if no screen parameter is found.
    parameterRef = screen.getParameter(parameter);
    if (parameterRef == null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Decorator Exception: Screen definition not found in request for: " + parameter);
      throw new JspException("Decorator Exception: Screen definition not found in request for: " + parameter);
    }
    // Do the include for the screen
    directInclude = parameterRef.isDirect();
    GrndsTrace.exitScope();
    return SKIP_BODY;
  }

  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doEndTag");
    try {
      if (this.directInclude && this.parameterRef != null) {
        pageContext.getOut().print(this.parameterRef.getValue());
      } else if (parameterRef != null) {
        if (this.parameterRef.getValue() != null) {
          ServletRequest request = pageContext.getRequest();
          ServletResponse response = pageContext.getResponse();
          String includeUrl = parameterRef.getValue();
          Monitor monitor = MonitorFactory.start(includeUrl);
          try {
            request.getRequestDispatcher(includeUrl).include(request, response);
          } catch (ServletException se) {
            // Only log if a SocketException is NOT found in the exception stack; this happens whenever the user stops
            //   loading the page by clicking somewhere else, closing the browser, or hitting "stop."  There is nothing
            //   that we can do about it, and it's not worth logging it.
            if (!ExceptionHandler.recurisiveCauseTypeCheck(se, SocketException.class, new HashSet<Throwable>())) {
              GrndsTrace.msg(TRACE_TAG, 7, "Decorator Exception: InsertTag:doEndTag caught:\n" +
                                           se.getClass() + "\n" + se.getMessage());
              Throwable rc = se.getRootCause();
              if (rc != null) {
                GrndsTrace.msg(TRACE_TAG, 7, "Decorator Exception: InsertTag:doEndTag rootCause:\n" +
                                             rc.getClass() + "\n" + rc.getMessage());
              }
            }
            // We still want to throw the exception up to cancel processing.
            throw new JspException("Decorator Exception: InsertTag:doEndTag caught: " + se.getMessage(), se);
          } finally {
            monitor.stop();
          }
        }
      }
    } catch (IOException e) {
      // Only log if a SocketException is NOT found in the exception stack; this happens whenever the user stops loading
      //   the page by clicking somewhere else, closing the browser, or hitting "stop."  There is nothing that we can
      //   do about it, and it's not worth logging it.
      if (!ExceptionHandler.recurisiveCauseTypeCheck(e, SocketException.class, new HashSet<Throwable>())) {
        GrndsTrace.msg(TRACE_TAG, 7, "Decorator Exception: InsertTag:doEndTag caught: " + e.getClass() + "\n" + e);
      }
      // We still want to throw the exception up to cancel processing.
      throw new JspException("Decorator Exception: InsertTag:doEndTag caught: " + e, e);
    }
    GrndsTrace.exitScope();
    return EVAL_PAGE;
  }
}