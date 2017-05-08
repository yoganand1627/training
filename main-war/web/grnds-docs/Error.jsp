<%--
  JSP Name:     IMPACT Error page
  Created by:   Brad Eilers
  Date Created: 19 July 2002

  Description:
  IMPACT's version of the "Data Access Error" message.

  Change History:
   Date          User        Description
   ----------    ----------  --------------------------------------------
   07/19/2002    EILERSBE    Initial creation.

   06/10/2003        KRD     Corrected the message text to match the
                             existing message in CAPS.
   07/24/2005   MWERLE SIR 23728 - Updated to handle ServiceException
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="java.util.Date"%>
<%@ page import="org.grnds.facility.config.GrndsConfiguration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.exception.PrsException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.PrsExceptionHandler"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.SpecificExceptionHandler"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLogRecord"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLoggingUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>


<html>
  <head>
    <title>ERROR Page</title>
    <SCRIPT type="text/javascript" src="/grnds-docs/js/shared/impact.js"></script>
    <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
  </head>

  <body bgcolor="#FFFFFF" text="#996666" link="#FF0000" alink="#FF9999" vlink="#663333">
    <%PrsException e = (PrsException) request.getAttribute(SpecificExceptionHandler.EXCEPTION_REQUEST_LOOKUP);
    String systemError = MessageLookup.getMessageByNumber( Messages.MSG_HELP_DESK_NO ); 
%>
    <table class="tableBorder" width="780" border="0" cellspacing="0" cellpadding="3" bgcolor="#FFFFFF">
      <tr>
        <td class="SecondLevel" height="35">
          <div align="center" class="errorTitle">
            SYSTEM ERROR
          </div>
        </td>
      </tr>
      <tr>
        <td class="formErrorText">
          <%=systemError%>
          <%--A system error has occurred in Georgia SHINES.  Please contact the DFCS Help Desk at 1 (800) 764-1017 and provide them with the following information:--%> 
        </td>
      </tr>
      <tr>
        <td class="formInfoText">
          UniqueID:
          <%=e.getUniqueId()%>
          <br>
          <br>
          Exception:
          <%=e.getClass().getName()%>
          <br>
          <br>
          Message:
          <%=e.getMessage()%>
          <br>
          <br>
        </td>
      </tr>
      <tr>
        <td class="formErrorText">
          The error occured at the following time:
        </td>
      </tr>
      <tr>
        <td class="formInfoText">
          <%=new Date()%>
        </td>
      </tr>
      <tr>
        <td>
          <br>
          <br>
        </td>
      </tr>
    </table>
    <br>
    <br>

    <table border="0" width="780" cellSpacing="0" cellPadding="3" class="tableBorder">
      <tr>
        <td>
          <impact:ExpandableSectionTag name="Error" id="errorDetail" label="Click for Stack Trace" tabIndex="1">
            <%if (DEBUG && ImpactExceptionLoggingUtility.ERROR_LOGGING_ENABLED) {
        String idErrorString = (String) request
                                               .getAttribute(PrsExceptionHandler.BASE_PRS_EXCEPTION_LOG_RECORD_INDEX_KEY);
        ImpactExceptionLogRecord record = null;
        int idError;
        try {
          idError = Integer.parseInt(idErrorString);
        } catch (NumberFormatException nfe) {
          idError = -1;
          record = (ImpactExceptionLogRecord) request
                                                     .getAttribute(PrsExceptionHandler.BASE_PRS_EXCEPTION_LOG_RECORD_KEY);
        }
        if (idError >= 0) {

          %>
            <SCRIPT type="text/javascript" LANGUAGE="javascript">
    function openDetails(id)
    {
      var descriptor = "";
      descriptor += "width=800,";
      descriptor += "height=600,";
      descriptor += "channelmode=0,";
      descriptor += "dependent=0,";
      descriptor += "directories=0,";
      descriptor += "fullscreen=0,";
      descriptor += "location=0,";
      descriptor += "menubar=0,";
      descriptor += "resizable=1,";
      descriptor += "scrollbars=1,";
      descriptor += "status=0,";
      descriptor += "toolbar=0";
      var newWindow = window.open('/grnds-docs/ErrorDetails.jsp?ID_ERROR=' + id, '_blank', descriptor);
      newWindow.document.title.innerHTML = 'Error Details for ID_ERROR=' + id;
    }
  </SCRIPT>

            <div>
              <a href='javascript:openDetails( <%=idError%> );'>Open System State Report</a>
            </div>
            <br>
            <br>
            <%} else if (null != record) {
          if (session != null) {
            session.setAttribute(PrsExceptionHandler.BASE_PRS_EXCEPTION_LOG_RECORD_KEY, record);

          %>
            <SCRIPT type="text/javascript" LANGUAGE="javascript">
    function openDetails()
    {
      var descriptor = "";
      descriptor += "width=800,";
      descriptor += "height=600,";
      descriptor += "channelmode=0,";
      descriptor += "dependent=0,";
      descriptor += "directories=0,";
      descriptor += "fullscreen=0,";
      descriptor += "location=0,";
      descriptor += "menubar=0,";
      descriptor += "resizable=1,";
      descriptor += "scrollbars=1,";
      descriptor += "status=0,";
      descriptor += "toolbar=0";
      var newWindow = window.open('/grnds-docs/ErrorDetails.jsp?useSession=true', '_blank', descriptor);
      newWindow.document.title.innerHTML = 'Error Details for error information stored in session.';
    }
  </SCRIPT>

            <div style="font-family: Arial, Helvetica, Verdana, sans-serif; font-size: 9pt;font-weight: bold;color: #FF0000">
              WARNING: Error information stored in session; information will be lost if the session is invalidated.
            </div>
            <br>
            <br>

            <div>
              <a href='javascript:openDetails();'>Open System State Report</a>
            </div>
            <br>
            <br>
            <%}
        }
      }
      if (e instanceof ServiceException) {
        ServiceException se = (ServiceException) e;

        %>
  Error Message Text : <%=se.getErrorMessage()%>
            <br>
            <br>
  Error Code: <%=se.getErrorCode()%> [<%=MessageLookup.getMessageByNumber(se.getErrorCode())%>] <br>
            <br>
            <%}
      Throwable t = (Throwable) e;

      %>
  Stack Trace: <%=ExceptionHandler.getStackTraceHTML(t)%>
            <br>
            <br>

          </impact:ExpandableSectionTag>
        </td>
      </tr>
    </table>
    <%//Remove the exception b/c some exceptions cannot be encoded and it is not needed any longer.
      request.removeAttribute(SpecificExceptionHandler.EXCEPTION_REQUEST_LOOKUP);

    %>
  </body>
</html>
<%!private static final boolean DEBUG = "true"
        .equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "debugJSP"));

%>
