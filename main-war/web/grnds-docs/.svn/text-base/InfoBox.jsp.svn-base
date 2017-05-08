<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.io.IOException" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<impact:setAttribute parameter="Info1"/>
<impact:setAttribute parameter="Info2"/>
<impact:setAttribute parameter="Info3"/>
<%--
JSP Name:     Info Box
Created by:   Stephan Brauchli
Date Created: 11/04/02

Description:
This JSP is used to case on the info-box attributes set in a JSP's
ScreenDefinitions xml file to determine what data to display.

--Values Supported:
--User Name
--CaseID
--Stage Name
--Person Name
--Case Name
--Case or Stage Name
--Staff Name
--Resource Name
--Resource ID
--Person Reviewed
--Service
--Full Name of Principal
--Full Person Name
--Account Number
--Invoice ID
--Invoice Phase
--Contract ID
--Period
--Version
--Stage Code
--Stage ID
--Person ID
--User ID
--Waiver ID
--County
--CRS ID
--%>
<table width="100%" cellspacing="0" cellpadding="0" border="0" class="infoBox">
<%
  String info1 = (String) request.getAttribute("Info1");
  String info2 = (String) request.getAttribute("Info2");
  String info3 = (String) request.getAttribute("Info3");
  for (int i = 0; i < 3; i++) {
    String info = info1;
    if (i == 1) {
      info = info2;
    } else if (i == 2) {
      info = info3;
    }
    if (info == null) {
      info = "";
%>
<tr>
  <td width="40%">&nbsp;</td>
  <td width="60%">&nbsp;</td>
</tr>
<%
    }
    //mdm: I could have made this a hashtable lookup based on info,
    // but I didn't know if the INFO STRING will ever be DIFFERENT THAN the DISPLAY STRING
    if ("User Name".equals(info)) {
      UserProfile infoBoxUser = UserProfileHelper.getUserProfile(request);
      infoBoxRow(out, "User Name", infoBoxUser.getUserFullName());
    } else if ("User ID".equals(info)) {
      UserProfile infoBoxUser = UserProfileHelper.getUserProfile(request);
      infoBoxRow(out, "User ID", infoBoxUser.getUserID());
    } else if ("CaseID".equals(info)) {
      infoBoxRow(out, "Case ID", GlobalData.getUlIdCase(request));
    } else if ("Stage Name".equals(info)) {
      infoBoxRow(out, "Stage Name", GlobalData.getSzNmStage(request));
    } else if ("Person Name".equals(info)) {
      infoBoxRow(out, "Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Case Name".equals(info)) {
      infoBoxRow(out, "Case Name", GlobalData.getSzNmCase(request));
    } else if ("Case or Stage Name".equals(info)) {
      infoBoxRow(out, "Case Name", GlobalData.getSzNmCase(request));
      infoBoxRow(out, "Stage Name", GlobalData.getSzNmStage(request));
    } else if ("Staff Name".equals(info)) {
      infoBoxRow(out, "Staff Name", GlobalData.getSzNmStaff(request));
    } else if ("Person Reviewed".equals(info)) {
      infoBoxRow(out, "Person Reviewed", GlobalData.getSzNmPersonFull(request));
    } else if ("Service".equals(info)) {
      infoBoxRow(out, "Service", GlobalData.getSzServiceDecode(request));
    } else if ("Resource Name".equals(info)) {
      infoBoxRow(out, "Resource Name", GlobalData.getSzNmResource(request));
    } else if ("Resource ID".equals(info)) {
      infoBoxRow(out, "Resource ID", GlobalData.getUlIdResource(request));
    } else if ("Full Name of Principal".equals(info)) {
      infoBoxRow(out, "Principal Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Full Person Name".equals(info)) {
      infoBoxRow(out, "Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Account Number".equals(info)) {
      infoBoxRow(out, "Account Number", GlobalData.getSzNbrFinAccount(request));
    } else if ("Invoice ID".equals(info)) {
      infoBoxRow(out, "Invoice ID", GlobalData.getUlIdInvoice(request));
    } else if ("Invoice Phase".equals(info)) {
      infoBoxRow(out, "Invoice Phase", GlobalData.getSzCdInvoPhase(request));
    } else if ("Contract ID".equals(info)) {
      infoBoxRow(out, "Contract ID", GlobalData.getUlIdContract(request));
    } else if ("Period".equals(info)) {
      infoBoxRow(out, "Period", GlobalData.getUlNbrCnperPeriod(request));
    } else if ("Version".equals(info)) {
      infoBoxRow(out, "Version", GlobalData.getUlNbrCnverVersion(request));
    } else if ("Stage Code".equals(info)) {
      infoBoxRow(out, "Stage Code", Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage(request)));
    } else if ("Stage ID".equals(info)) {
      infoBoxRow(out, "Stage ID", GlobalData.getUlIdStage(request));
    } else if ("Person ID".equals(info)) {
      infoBoxRow(out, "Person ID", GlobalData.getUlIdPerson(request));
    } else if ("Call ID".equals(info)) {
      infoBoxRow(out, "Call ID", GlobalData.getUlIdStage(request));
    } else if ("Waiver ID".equals(info)) {
      infoBoxRow(out, "Waiver ID", GlobalData.getUlIdEvent(request));
    } else if ("County".equals(info)) {
      infoBoxRow(out, "County", Lookup.simpleDecodeSafe(CodesTables.CCOUNT, GlobalData.getSzCdCounty(request)));
    } else if ("CRS ID".equals(info)) {
      infoBoxRow(out, "CRS ID", GlobalData.getUlIdCrs(request));
    }
  }
%>
</table>
<%!
  protected void infoBoxRow(JspWriter out, String name, int value) throws IOException {
    String valueString = null;
    if (value != 0) {
      valueString = "" + value;
    }
    infoBoxRow(out, name, valueString);
  }

  protected void infoBoxRow(JspWriter out, String name, String value) throws IOException {
    out.println("    <tr>");
    out.println("        <td class=\"infoBox\" width=\"40%\">" + name + ":&nbsp;</td>");
    out.println("        <td class=\"infoBox\" width=\"60%\">");
    if ((value != null) && ("".equals(value) == false)) {
      out.println(value);
    } else {
      out.println("&nbsp;");
    }
    out.println("                </td>");
    out.println("    </tr>");
  }
%>
