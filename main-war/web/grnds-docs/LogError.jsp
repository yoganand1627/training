<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.Date"%>
<%@ page import="org.grnds.facility.config.GrndsConfiguration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.exception.PrsException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%
//*  JSP Name:     IMPACT Error page
//*  Created by:   Brad Eilers
//*  Date Created: 19 July 2002
//*
//*
//*  Description:
//*  IMPACT's version of the "Data Access Error" message.
//*
//*
//** Change History:
//**  Date          User        Description
//**  ----------    ----------  --------------------------------------------
//**  07/19/2002    EILERSBE    Initial creation.
//**
//**  06/10/2003        KRD     Corrected the message text to match the
//**                            existing message in CAPS.
//**  0724/2005  MWERLE  SIR 23728 - Updated to handle ServiceException
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<html>
<head>
  <title>ERROR Page</title>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/shared/impact.js"></script>
  <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
</head>
<%
  PrsException e = ( PrsException )request.getAttribute( "exception.display" );
%>
<body bgcolor="#FFFFFF" text="#996666" link="#FF0000" alink="#FF9999" vlink="#663333">
  <impact:validateForm name="frmLogError"
                       method="post"
                       action="/common/Error/displayError"
                       pageMode="<%=PageModeConstants.EDIT%>"
                       schema="/WEB-INF/Constraints.xsd">
    <table width="780" border="0" cellspacing="0" cellpadding="0" background="/grnds-docs/images/bg.gif">
      <tr>
        <td class="SecondLevelSides" height="35" width="2">&nbsp;</td>
        <td class="SecondLevel" height="35" width="776">
          <div align="center" class="errorTitle">IMPACT ERROR</div>
        </td>
        <td class="SecondLevelSides" height="35" width="2">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3">
          <%--<br><br>--%>
          <table class="tableBorder" align="center" border="0" cellpadding="5" cellspacing="0" width="760">
            <tr>
              <th colspan="2" height="20">The system has generated an error.</th>
            </tr>
            <tr>
              <td colspan="2" class="formErrorText">
                An error has occurred in IMPACT.
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <ul>
                  <li>
                    To go back and try again, please click <a href="javascript:history.back(1)">here</a>
                    or use the "Back" button.
                  </li>
                  <li>
                    To reset your Impact session and return to your Assigned Workload, please click
                    <a href="/common/Error/displayAssignedWorkload">here</a>.
                  </li>
                  <li>
                    If you would like assistance with this error, please contact the Customer Service Center
                    at (877) 642-4777 and provide them with the following information:
                    <br>
                    <table border="0" cellspacing="0" cellpadding="3">
                      <tr valign="top">
                        <td class="formInfoText">UniqueID:</td>
                        <td><%=e.getUniqueId()%></td>
                      </tr>
                      <tr valign="top">
                        <td class="formInfoText">Exception:</td>
                        <td><%=e.getClass().getName()%></td>
                      </tr>
                      <tr valign="top">
                        <td class="formInfoText">Message:</td>
                        <td><%=e.getMessage()%></td>
                      </tr>
                      <tr valign="top">
                        <td class="formInfoText">Time:</td>
                        <td><%=new Date()%></td>
                      </tr>
                      <tr>
                        <td colspan="2" class="formInfoText">
                          If the Customer Service Center is unable to resolve this error, please request
                          the Customer Service Center Ticket ID and enter it in the field below.  Then,
                          press the submit button to record details of the error for the Impact
                          Development Team.
                        </td>
                      </tr>
                      <tr>
                        <td colspan="2" align="right">
                          <table cellpadding="3" cellspacing="0" border="0">
                            <tr>
                              <td><impact:validateInput name="txtProblemID" type="text" required="true" tabIndex="1"
                                                        label="Ticket ID"/></td>
                              <td><impact:ButtonTag name="btnSubmitFinal" img="btnSubmit" tabIndex="2"
                                                    form="frmLogError" action="/error/Error/logError"/></td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </li>
                </ul>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <table width="780" cellpadding="0" cellspacing="0" border="0"
           background="/grnds-docs/images/metaphor/SACWIS_Footer.jpg">
      <tr><td>&nbsp;</td></tr>
    </table>
  </impact:validateForm>
<%
  if( DEBUG )
  {
%>
  <br><br>
  <impact:ExpandableSectionTag name="Error" id="errorDetail" label="Error Details" tabIndex="1">
<%
    if ( e instanceof ServiceException )
    {
      ServiceException se = (ServiceException) e;
%>
    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableborder">
      <tr>
        <td>Error Message Text:</td>
        <td><%=  se.getErrorMessage() %></td>
      </tr>
      <tr>
        <td>Error Code:</td>
        <td><%=  se.getErrorCode() %> [<%= MessageLookup.getMessageByNumber( se.getErrorCode() ) %>]</td>
      </tr>
    </table>
<%
    }
%>
    <pre>
<%
  ((Throwable) e).printStackTrace( new PrintWriter( out ) );
  ((Throwable) e).printStackTrace();
%>
    </pre>
    <br>
    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableborder">
      <tr>
        <th>Debugging Information:</th>
      </tr>
      <tr>
        <td>
          <%@ include file="/grnds-docs/test/Debug.jsp" %>
        </td>
      </tr>
    </table>
  </impact:ExpandableSectionTag>
<%
  }
  //Remove the exception b/c some exceptions cannot be encoded and it is not needed any longer.
  request.removeAttribute("exception.display");
%>
</body>
</html>
<%!
  private static final boolean DEBUG
          = "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "debugJSP"));
%>
