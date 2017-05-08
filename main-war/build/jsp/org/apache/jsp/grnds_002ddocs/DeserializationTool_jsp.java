package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

public final class DeserializationTool_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  private void printFormValidation( javax.servlet.jsp.JspWriter out, FormValidation fv ) throws java.io.IOException
  {
    out.println("<br>Form Validation - Inputs: <br>");
    Map map = fv.getInstanceInputMap();
    for ( java.util.Iterator i = map.keySet().iterator(); i.hasNext() ; )
    {
      String key = (String) i.next();
      InputValidation myObject = (InputValidation)map.get( key );
      out.println( key + " = Name:" +
                   myObject.getName() + "; Value:" +
                   myObject.getValue() + "; Constraint:" +
                   myObject.getConstraint() + "; Required:" +
                   myObject.isRequired() + "; Valid:" +
                   myObject.isValid() + "; ErrMsg:" +
                   myObject.getErrorMessage() + "<br>"  );
    }
    out.println("<br>Input Constraints: <br>");
    map = fv.getInputConstraints();
    for ( java.util.Iterator i = map.keySet().iterator(); i.hasNext() ; )
    {
      String key = (String) i.next();
      Object myObject = map.get( key );
      out.println( key + " = " + myObject );
    }
  }

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/debug.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n\n\n\n\n\n\n\n\n\n\n<!--\nDescription: This is a Database Querying tool for IMPACT development.\nAuthor: Brad Eilers\nDate: 06/24/02\n-->\n<html>\n<body>\n\n  <form name=\"myData\" action=\"DeserializationTool.jsp\" method=\"post\">\n    Input the serialized/encoded data<br>\n    <textarea name=\"serializedData\" rows=\"20\" cols=\"80\"></textarea><br>\n    Decode:\n    <input type=\"radio\" name=\"pageFunction\" value=\"decode\">\n    &nbsp;&nbsp;Deserialize:\n    <input type=\"radio\" name=\"pageFunction\" value=\"deserialize\" checked>\n    <br>\n    <input type=\"submit\" value=\"submit\"/>\n  </form>\n\n");

  String pageFunction = request.getParameter("pageFunction");
  String data = request.getParameter("serializedData");

  if ("decode".equals(pageFunction))
  {
    byte[] decodedByteArray = Base64.decode(data);
    String decodedString = new String(decodedByteArray, ArchitectureConstants.CHARACTER_ENCODING);
    out.println(decodedString);
  }
  else if ("deserialize".equals(pageFunction))
  {
       if ( data != null )
       {
           Object myObjects = SerializationHelper.deserializeObject( data );
           if( myObjects instanceof HashMap )
           {
               HashMap map = (HashMap) myObjects;
               for ( java.util.Iterator i = map.keySet().iterator(); i.hasNext() ; )
               {
                    String key = (String) i.next();
                    Object myObject = map.get( key );
                    if( myObject instanceof FormValidation )
                    {
                         FormValidation fv = (FormValidation) myObject;
                         printFormValidation( out, fv );
                         out.println("<br><br>");
                    }
                    else if (myObject instanceof XmlValueBean )
                    {
                          out.println( key + ":");

      out.write('\n');
      out.write(' ');
      out.write(' ');
      //  debug:displayXmlValueBean
      gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag _jspx_th_debug_displayXmlValueBean_0 = new gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag();
      _jspx_th_debug_displayXmlValueBean_0.setPageContext(_jspx_page_context);
      _jspx_th_debug_displayXmlValueBean_0.setParent(null);
      _jspx_th_debug_displayXmlValueBean_0.setXmlValueBean((XmlValueBean)myObject);
      int _jspx_eval_debug_displayXmlValueBean_0 = _jspx_th_debug_displayXmlValueBean_0.doStartTag();
      if (_jspx_th_debug_displayXmlValueBean_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\n');

                          out.println("<br>");
                    }
                    else
                    {
                          out.println( key + " = " + myObject + "<br>");
                    }
               }
          }
          else if( myObjects instanceof FormValidation )
          {
               FormValidation fv = (FormValidation) myObjects;
               printFormValidation( out, fv );
          }
          else if (myObjects instanceof XmlValueBean )
          {

      out.write("\n   ");
      //  debug:displayXmlValueBean
      gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag _jspx_th_debug_displayXmlValueBean_1 = new gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag();
      _jspx_th_debug_displayXmlValueBean_1.setPageContext(_jspx_page_context);
      _jspx_th_debug_displayXmlValueBean_1.setParent(null);
      _jspx_th_debug_displayXmlValueBean_1.setXmlValueBean((XmlValueBean)myObjects);
      int _jspx_eval_debug_displayXmlValueBean_1 = _jspx_th_debug_displayXmlValueBean_1.doStartTag();
      if (_jspx_th_debug_displayXmlValueBean_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\n');

          }
          else
          {
               out.println(myObjects);
          }
      }
      else
      {
          out.println("<br>No Data has been specified or Data is null;");
      }
  }

      out.write('\n');
      out.write('\n');
      out.write("\n</body>\n</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
