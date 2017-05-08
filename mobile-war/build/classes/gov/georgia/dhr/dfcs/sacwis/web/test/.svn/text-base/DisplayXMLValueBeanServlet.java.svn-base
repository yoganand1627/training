package gov.georgia.dhr.dfcs.sacwis.web.test;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;

/** User: mkw Date: Jan 16, 2003 Time: 3:08:49 PM */
public class DisplayXMLValueBeanServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    displayXMLValueBean(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    displayXMLValueBean(request, response);
  }

  private void displayXMLValueBean(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String xmlValueBeanKey = request.getParameter(XML_VALUE_BEAN_KEY);
    XmlValueBean xmlValueBean = (XmlValueBean) request.getSession().getAttribute(xmlValueBeanKey);
    response.setContentType("text/xml; charset=\"" + ArchitectureConstants.CHARACTER_ENCODING + "\"");
    Writer out = response.getWriter();
    out.write(xmlValueBean.toString());
    out.flush();
  }

  public static final String XML_VALUE_BEAN_KEY = "XML_VALUE_BEAN_KEY";
}
