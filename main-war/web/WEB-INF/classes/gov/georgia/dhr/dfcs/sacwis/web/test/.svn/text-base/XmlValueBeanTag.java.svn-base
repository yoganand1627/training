package gov.georgia.dhr.dfcs.sacwis.web.test;

import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;

/** User: mkw Date: Jan 15, 2003 Time: 3:58:53 PM */
public class XmlValueBeanTag extends TagSupport {
  public XmlValueBean getXmlValueBean() {
    return (XmlValueBean) getValue(XML_VALUE_BEAN_KEY);
  }

  public void setXmlValueBean(XmlValueBean xmlValueBean) {
    setValue(XML_VALUE_BEAN_KEY, xmlValueBean);
  }

  public int doStartTag() throws JspException {
    HttpSession session = pageContext.getSession();

    // check to see if this is the first time that we've been called during this request;
    // if so, nuke all existing xml value beans in the session
    ServletRequest request = pageContext.getRequest();
    if (request.getAttribute(XML_VALUE_BEAN_KEY) == null) {
      Enumeration sessionEnumeration = session.getAttributeNames();
      while (sessionEnumeration.hasMoreElements()) {
        String name = (String) sessionEnumeration.nextElement();
        if (name.startsWith(XML_VALUE_BEAN_PREFIX)) {
          session.removeAttribute(name);
        }
      }
      // put the attribute in the request so we don't get called again
      request.setAttribute(XML_VALUE_BEAN_KEY, new Object());
    }

    try {
      XmlValueBean xmlValueBean = getXmlValueBean();
      String beanName = xmlValueBean.getClass().getName();
      Random random = new Random(System.currentTimeMillis());
      String functionName = beanName.substring(beanName.lastIndexOf('.') + 1, beanName.length()) + "_"
                            + String.valueOf(Math.abs(random.nextInt()));
      String keyName = XML_VALUE_BEAN_PREFIX + "_"
                       + beanName.substring(beanName.lastIndexOf('.') + 1, beanName.length()) + "_"
                       + String.valueOf(Math.abs(random.nextInt()));
      pageContext.getSession().setAttribute(keyName, xmlValueBean);
      String url = "/DisplayXMLValueBean/" + beanName + ".xml?" + DisplayXMLValueBeanServlet.XML_VALUE_BEAN_KEY + "=" +
                   keyName;

      JspWriter out = pageContext.getOut();
      out.write("\n");
      out.write("<SCRIPT LANGUAGE=\"javascript\">\n");
      out.write("  function " + functionName + "()\n");
      out.write("  {\n");
      out.write("    var descriptor = \"\";\n");
      out.write("    descriptor += \"width=450,\";\n");
      out.write("    descriptor += \"height=600,\";\n");
      out.write("    descriptor += \"channelmode=0,\";\n");
      out.write("    descriptor += \"dependent=0,\";\n");
      out.write("    descriptor += \"directories=0,\";\n");
      out.write("    descriptor += \"fullscreen=0,\";\n");
      out.write("    descriptor += \"location=0,\";\n");
      out.write("    descriptor += \"menubar=0,\";\n");
      out.write("    descriptor += \"resizable=1,\";\n");
      out.write("    descriptor += \"scrollbars=1,\";\n");
      out.write("    descriptor += \"status=0,\";\n");
      out.write("    descriptor += \"toolbar=0\";\n");
      out.write("    var newWindow = window.open( '" + url + "', '_blank', descriptor );\n");
      out.write("    newWindow.document.title.innerHTML = '" + beanName + ".xml';\n");
      out.write("  }\n");
      out.write("</SCRIPT>\n");
      out.write("<a href='javascript:" + functionName + "();'>" + beanName + "</a>\n");
    }
    catch (Exception e) {
      throw new JspException("Failure writing XmlValueBean link.", e);
    }
    return SKIP_BODY;
  }

  public static String XML_VALUE_BEAN_KEY = "XML_VALUE_BEAN_KEY";
  public static String XML_VALUE_BEAN_PREFIX = "XmlValueBean";
}
