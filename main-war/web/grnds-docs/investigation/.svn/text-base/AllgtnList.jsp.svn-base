<%
//*  JSP Name:     Allegation List
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 11/19/02
//*
//*  Description:
//*   Displays a listing of all allegations for a given stage.
//*   Also calculates overall roles and the stage's overall
//*   disposition if all allegations in the stage have been
//*   addressed.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  06/30/05  floresrj          SIR 23729 Refactored class for Phase II implementation.
//**  08/31/05  floresrj          SIR 23956 Phase III Mobile implementation.
//**  10/17/05  floresrj        SIR 24049 Handle NULL value for Alleged Perpetrator id.
//**  09/08/2009  bgehlot       STGAP00015366: Removed the Alleged Maltreator. 
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnConversation" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence"%>
<%
  //Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
  //  to see how the page functions, but it should always be initialized to view mode.
  //String pageMode = PageMode.VIEW;
  String pageMode = PageModeConstants.EDIT;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request ) != null )
  {
    pageMode = (String)state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
  }

  int tabIndex = 1;
%>

<%
  CINV44SO cinv44so = (CINV44SO) request.getAttribute("CINV44SO");
  ROWCINV44SOG_ARRAY allgtnListArray = (ROWCINV44SOG_ARRAY) state.getAttribute( "allgtnListArray", request);
  Enumeration allgtnListEnumerator = null;

  if (cinv44so == null)
  {
    cinv44so = new CINV44SO();
  }
  if (allgtnListArray == null)
  {
    allgtnListArray = new ROWCINV44SOG_ARRAY();
  }
  if (allgtnListArray.enumerateROWCINV44SOG() != null)
  {
    allgtnListEnumerator = allgtnListArray.enumerateROWCINV44SOG();
  }
  String strFacility = "";
  //Facility Mode
  if ( GlobalData.getSzCdStageProgram( request ).equals( CodesTables.CPGRMSFM_AFC ) )
  {
    strFacility = "Facility";
  }

  boolean bDeleteButton = false;
  boolean bDetailButton = false;
  boolean bAddButton = false;

  if ( pageMode.equals( PageModeConstants.MODIFY ))
  {
    bDeleteButton = false;
    bDetailButton = false;
    bAddButton = false;
  }
  else if ( pageMode.equals( PageModeConstants.VIEW ) )
  {
    bDeleteButton = true;
    bDetailButton = true;
    bAddButton = true;
  }

  if (GlobalData.getSzCdStage( request ).equals( CodesTables.CSTAGES_ARI ) )
  {
    bDeleteButton = true;
    bDetailButton = false;
    bAddButton = true;
  }


  //Variable to hold the css class for the each row in the lists
  String rowCss = "odd";
  int allgtnCount = 0;
%>
<script type="text/javascript" language="JavaScript1.2">

function displayAllgtnDetail(idAllgtn)
{
  document.frmAllgtnList.hdnUlIdAllgtn.value = idAllgtn;
  submitValidateForm( "frmAllgtnList", "/investigation/Allegation/display<%= strFacility %>AllgtnDetail" );
}

function deleteConfirm()
{
  return confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>');
}

</script>

<impact:validateErrors/>

<impact:validateForm name="frmAllgtnList"
  method="post"
  action="/investigation/Allegation/displayAllgtnDetail"
  pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd">

<impact:pagination submitUrl="/investigation/Allegation/displayAllgtnList" saveState="false">

<!-- Hidden Fields -->
<impact:validateInput type="hidden" name="hdnOverallDisp" value="<%= cinv44so.getCdAllegDisposition() %>"/>

<impact:validateInput type="hidden" name="hdnValidationOverride" editableMode="<%=EditableMode.EDIT%>"/>
<impact:validateInput type="hidden" name="hdnUlIdAllgtn" value="0"/>
<impact:validateInput type="hidden" name="hdnDisplayMode" value=""/>

<impact:validateInput type="hidden" name="hdnPageMode" value="<%=pageMode%>" />
   <div id="noScrollResults" style="height:100%; width:100%; overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3">
      <tr class="thList">
        <th>&nbsp;</th>
        <th>Maltreatment Code</th>
        <th>Alleged Maltreated Child</th>
        <th>Disposition</th>
        <th>Evidence Code</th>
        <th>Stage</th>
        <th>Child ID</th>
      </tr>
      <%
      if ( request.getAttribute( "noRowsReturned" ) != null )
      {%>
      <tr class="odd">
        <td colspan="9"><%= MessageLookup.getMessageByNumber( Messages.MSG_NO_ROWS_RETURNED ) %></td>
      </tr>
    <%}
      else
      {
        while( allgtnListEnumerator.hasMoreElements() )
        {
          ROWCINV44SOG allgtnListDetail = (ROWCINV44SOG) allgtnListEnumerator.nextElement();
          rowCss = FormattingHelper.getRowCss( allgtnCount++ + 1 );

          String nmAllgtn = "cbxAllgtn_" + Integer.toString(allgtnListDetail.getUlIdAllegation());
          String nmTS = "hdnTs_" + Integer.toString(allgtnListDetail.getUlIdAllegation());
          String nmTS4 = "hdnTs4_" + Integer.toString(allgtnListDetail.getUlIdAllegation());
          String nmVic = "hdnVic_" + Integer.toString(allgtnListDetail.getUlIdAllegation());
                     
          String evidenceCode = "";
          int allegEvidenceCount = allgtnListDetail.getAllegEvidence_ARRAY().getUlRowQty();
          for (int t = 0; t < allegEvidenceCount; t++) {
            AllegationEvidence allegEvidence = allgtnListDetail.getAllegEvidence_ARRAY().getAllegationEvidence(t);
            evidenceCode =  evidenceCode + allegEvidence.getSzCdEvidenceCode() + " ";
          }
      %>
      <!-- Allegation Timestamp -->
      <impact:validateInput type="hidden" name="<%= nmTS %>" value="<%= allgtnListDetail.getTsLastUpdate().toString() %>"/>
      
      <!-- Facility Allegation Timestamp -->
      <impact:ifMobileImpact>
          <impact:validateInput type="hidden" name="<%= nmTS4 %>" value="<%= DateHelper.toISOString(allgtnListDetail.getTsSysTsLastUpdate2()) %>"/>
      </impact:ifMobileImpact>
       <impact:ifServerImpact>
            <impact:validateInput type="hidden" name="<%= nmTS4 %>" value="<%= allgtnListDetail.getTsSysTsLastUpdate2().toString() %>"/>
       </impact:ifServerImpact>

      <tr class="<%=rowCss%>">
      <impact:ifMobileImpact>
      <td>&nbsp;</td>
     </impact:ifMobileImpact>
    <impact:ifServerImpact>
            <td width="5%"><impact:validateInput type="checkbox" name="<%=nmAllgtn%>" value="<%= FormattingHelper.formatInt( allgtnListDetail.getUlIdAllegation() ) %>" tabIndex="<%= tabIndex++ %>"/></td>
    </impact:ifServerImpact>

        <impact:ifServerImpact>
          <td><a href="#" tabIndex="<%=tabIndex++%>" onClick="displayAllgtnDetail(<%= allgtnListDetail.getUlIdAllegation()%>);"><%= allgtnListDetail.getSzCdAllegType() %></a></td>
        </impact:ifServerImpact>

        <td><%= allgtnListDetail.getSzScrPersVictim() %></td>
        <impact:ifServerImpact>
          <td><%= allgtnListDetail.getCdAllegDisposition() %></td>
        </impact:ifServerImpact>
    <td><%=evidenceCode %></td>
        <td><%= allgtnListDetail.getSzCdAllegIncidentStage() %></td>
        <td><%= allgtnListDetail.getUlIdVictim() %><impact:validateInput type="hidden" name="<%=nmVic%>" value="<%= FormattingHelper.formatInt( allgtnListDetail.getUlIdVictim() )%>"/></td>
      </tr>
      <% }
       } %>
    </table>
    </div>
</impact:pagination>
<table cellspacing="0" cellPadding="3" width="100%" border="0">
  <tr>
    <td class="alignLeft">
      <%
        String deleteAction = "/investigation/Allegation/delete" + strFacility + "AllgtnList";
      %>
    <!--  // SIR 23729 Start -->
    <impact:ifServerImpact>
          <impact:ButtonTag name="btnDelete" img="btnDelete" disabled="<%= String.valueOf( bDeleteButton ) %>" restrictRepost="true" form="frmAllgtnList" function="return deleteConfirm();" action="<%= deleteAction %>" tabIndex="<%= tabIndex++ %>"/>
    </impact:ifServerImpact>
    <!-- // SIR 23729 end -->
    </td>
    <td class="alignRight">
      <% String displayAction = "/investigation/Allegation/display" + strFacility + "AllgtnDetail"; %>
      <!--  // SIR 23729 Start -->
    <impact:ifServerImpact>
        <impact:ButtonTag name="btnDetail" img="btnDetail" disabled="<%= String.valueOf( bDetailButton ) %>" form="frmAllgtnList" action="<%= displayAction %>" tabIndex="<%= tabIndex++ %>"/>
          <impact:ButtonTag name="btnNewUsing" img="btnNewUsing" disabled="<%= String.valueOf( bAddButton ) %>" form="frmAllgtnList" action="<%= displayAction %>" tabIndex="<%= tabIndex++ %>"/>
          <impact:ButtonTag name="btnAdd" img="btnAdd" disabled="<%= String.valueOf( bAddButton ) %>" form="frmAllgtnList" action="<%= displayAction %>" tabIndex="<%= tabIndex++ %>"/>
    </impact:ifServerImpact>
    <!-- // SIR 23729 end -->
    </td>
  </tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
