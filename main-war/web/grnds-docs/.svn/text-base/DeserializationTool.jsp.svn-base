<%@ taglib uri="/WEB-INF/debug.tld" prefix="debug" %>

<%@ page import="java.util.*"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Base64"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<!--
Description: This is a Database Querying tool for IMPACT development.
Author: Brad Eilers
Date: 06/24/02
-->
<html>
<body>

  <form name="myData" action="DeserializationTool.jsp" method="post">
    Input the serialized/encoded data<br>
    <textarea name="serializedData" rows="20" cols="80"></textarea><br>
    Decode:
    <input type="radio" name="pageFunction" value="decode">
    &nbsp;&nbsp;Deserialize:
    <input type="radio" name="pageFunction" value="deserialize" checked>
    <br>
    <input type="submit" value="submit"/>
  </form>

<%
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
%>
  <debug:displayXmlValueBean xmlValueBean="<%=(XmlValueBean)myObject%>" />
<%
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
%>
   <debug:displayXmlValueBean xmlValueBean="<%=(XmlValueBean)myObjects%>" />
<%
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
%>

<%!
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
%>
</body>
</html>