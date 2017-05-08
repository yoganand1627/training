<%
//*  JSP Name:     ChngStgTyp.jsp
//*  Created by:   Merle Demo
//*  Date Created: 12/16/2002
//*
//*  Description:  This page combines parts of the CAPS ccmn62w.win and ccmn74w.win.
//*                Allows an authorized user to display the current stage type
//*                for FPR and FRE stages. This page will allow user to select
//*                a new stage type for FPR and FRE stages.  The user is able to
//*                change stage type for FPR and FRE stages only.  Also no CRSR
//*                type changes even for FRP and FRE stages.
//*
//**  Change History:
//**  Date       User              Description
//**  --------   ----------------  --------------------------------------------------
//**  04/09/2003 thompswa          QA Sweep edits.
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ChngStgTypConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  String pageMode = PageMode.getPageMode(request);

  int tabIndex = 1;
  String  dspSzCdStageType = "";

  CSUB63SO csub63so = (CSUB63SO)
    state.getAttribute( ChngStgTypConversation.STAGETYPE_INFO, request);

  if ( csub63so == null )
  {
    csub63so = new CSUB63SO();
  }

  dspSzCdStageType = Lookup.simpleDecodeSafe(CodesTables.CSTGTCHG,csub63so.getCSUB63SOG00().getSzCdStageType());
%>


<% /* Needed for Form Launch Custom tag */ %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
}
</script>


<impact:validateErrors/>

<impact:validateForm name="frmChngStgTyp"
  action="/workload/ChngStgTyp/displayChngStgTyp"
  defaultButton="true"
  method="post"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
      <th colspan="4">Change Stage Type</th>
  </tr>
  <tr>
    <td>
         <impact:validateDisplayOnlyField
           name="txtDecodeStageType"
           label="From"
           width="30%"
           value="<%=dspSzCdStageType%>" />
    </td>
     <td>
         <impact:validateSelect
           name="selCdStageType"
           codesTable="CSTGTCHG"
           required="true"
           label="To"
           width="30%"
           tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<br>
         <impact:ButtonTag
           action="/workload/ChngStgTyp/saveChngStgTyp"
           align="right"
           form="frmChngStgTyp"
           restrictRepost="true"
           preventDoubleClick="true"
           img="btnSave"
           name="btnSave"
           tabIndex="<%= tabIndex++ %>"/>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
</impact:validateForm>
