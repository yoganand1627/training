<%
//*--------------------------------------------------------------------------------
//*   JSP Name:    Stage Progression
//*  Created by:   Carolyn Douglass
//*  Date Created: 12/09/02
//*
//*  Description:
//*  This JSP displays the Stage Progression page.
//*
//*   Change History:
//*   Date      User              Description
//*
//* 5/26/05  DUNAWAKL           SIR 13544 - Added logic to check the age of person and
//*                            determine if they are the right age for the stage selected
//* 9/16/05  DOUGLACS          SIR 23781 - AOC stages will now go to the workload of
//*                            of the person who stage progresses.
//*--------  ----------------  --------------------------------------------------
//*
//*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.StageProgressionConversation"%>
<%@ page import="java.util.SortedMap"%>
<%
  BaseSessionStateManager state = StageProgressionConversation.getSessionStateManager(request);

  String pageMode = PageModeConstants.EDIT;
  String szCdStage = GlobalData.getSzCdStage( request );
  String nmPerson = (String) request.getAttribute("nmPerson");
  if (nmPerson == null) {
    nmPerson = "";
  }

  SortedMap stages = (SortedMap) state.getAttribute("stages", request);
  String newStage = (String) state.getAttribute("selNewStage", request);
  //If there is only 1 stage in the create new stage dropdown, default to that stage
  if ( stages.size() == 1) {
    newStage = stages.firstKey().toString();
  }

  /* Assign tab-index */
  int tabIndex = 1;
  String currStage = Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, szCdStage) +" - "+ Lookup.simpleDecodeSafe( "CSTAGES", szCdStage);
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  /*
   *This function is called before the page unloads. It creates the
   *"Are you sure you want to navigate away from this page..." pop-up message.
   */
  window.onbeforeunload = function () {
    IsDirty();
  }

  //This function checks to see if the stage should not have a person selected
  function checkPerson(bSaveButtonPressed) {
    var newStage = new String(document.frmStageProgression.selNewStage.value);
    
    if ( newStage != null && newStage != "") {
      var stageName = new String(document.frmStageProgression.nmPerson.value);
      var currStage = new String(document.frmStageProgression.szCdCurrStage.value);
      try {
        currStage = currStage.substr(0,3);
      } catch(e) {}
      
      if ( ((currStage == "<%=StageProgressionConversation.INT_STAGE%>" ||
            currStage == "<%=StageProgressionConversation.FPR_ONG_STAGE%>" ||
            currStage == "<%=StageProgressionConversation.FSU_FCF_STAGE%>") &&
            newStage != "<%=StageProgressionConversation.SUB_STAGE%>" &&
            newStage != "<%=StageProgressionConversation.ADO_STAGE%>" &&
            newStage != "<%=StageProgressionConversation.PAD_STAGE%>" &&
            newStage != "<%=StageProgressionConversation.PFC_STAGE%>")
           ||
           (currStage == "<%=StageProgressionConversation.SUB_FCC_STAGE%>" ||
            currStage == "<%=StageProgressionConversation.ADO_STAGE%>" ||
            currStage == "<%=StageProgressionConversation.PAD_STAGE%>" ||
            currStage == "<%=StageProgressionConversation.PFC_STAGE%>") ) {
        //-- cannot have person selected
        if(!bSaveButtonPressed) {
          alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_NO_PERSON_NEEDED ) %>" );
          return false;
        } else {
          //-- verify no person selected
          if(stageName != null && stageName != "") {
            alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_NO_PERSON_NEEDED ) %>" );
            return false;
          }
        }
      } else if(bSaveButtonPressed) {
        //-- must have person selected
        if(stageName == null || stageName == "") {
          alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_PERSON_NEEDED ) %>" );
          return false;
        }
      }
    } else {
      //-- must select new stage before selecting person or saving
      alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_STAGE ) %>" );
      return false;
    }
    return true; //-- no alerts displayed; continue person selection or save
  }

  //Begin SIR 13544
  // This function verifies that the age of the person selected is right
  // for the phase being moved into and if so calls the confirmStageProgress function
  function confirmStageAgeAndProgress() {
    var bCheckBday = <%= state.getAttribute(StageProgressionConversation.CHECK_BDAY, request) %>;
    
    if(bCheckBday != null && bCheckBday) {
      var strAge = <%= state.getAttribute(StageProgressionConversation.PERSON_AGE, request) %>;
      var strStage = new String(document.frmStageProgression.selNewStage.value);
      var strBirthday = <%= state.getAttribute(StageProgressionConversation.PERSON_BDAY, request) %>;
      
      if (strBirthday != null && (strAge == "" || strAge == null || strAge == 0)) {
        strAge = 1;
      }
          
      if ( strStage == "<%= StageProgressionConversation.SUB_STAGE %>" ||
           strStage == "<%= StageProgressionConversation.ADO_STAGE %>" ||
           strStage == "<%= StageProgressionConversation.PAD_STAGE %>" ||
           strStage == "<%= StageProgressionConversation.FSU_STAGE %>" ||
           strStage == "<%= StageProgressionConversation.PFC_STAGE %>" ||
           strStage == "<%= StageProgressionConversation.DIV_STAGE %>" ||
           strStage == "<%= StageProgressionConversation.FPR_STAGE %>" ) {
        if (strAge != "" && strAge != null ) {
          if (strAge < 26) {
            return confirmStageProgress();
          } else {
            alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_AGE_TOO_OLD)%>");
            return false;
          }
        } else {
          return confirm("<%= MessageLookup.getMessageByNumber(Messages.MSG_NO_BIRTHDAY)%>");
        }
      }
    }
    return confirmStageProgress();
  }
  //end SIR 13544

  //SIR 13558////////////////
  // This function gives the user a message to reassign the stage before saving
  // and to require a person be entered for certain stage progressions
  function confirmStageProgress() {
    var newStage = new String(document.frmStageProgression.selNewStage.value);
    
    if ( newStage != null && newStage != "") {
      var currStage = new String(document.frmStageProgression.szCdCurrStage.value);
      try {
        currStage = currStage.substr(0,3);
      } catch(e) {}
      
      //check to see if new stage requires a person
      if(!checkPerson(true)) {
        return false;
      }
      
      // Give the user a confirmation message that the new stage will need to be reassigned.
      bRetValue = confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_CMN_STAGE_PROGRESS ) %>" );
      if( bRetValue ) {
        disableValidation( "frmStageProgression" );
      } else {
        enableValidation( "frmStageProgression" );
      }
      return bRetValue;
    } else {
      //-- must select new stage before saving
      alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_STAGE ) %>" );
      return false;
    }
  }

</script>

<impact:validateErrors/>
<impact:validateForm
  name="frmStageProgression"
  method="post"
  action="/workload/StageProgression/displayStageProgression"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd"
>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan=3>Stage Progression</th>
    </tr>
    <tr>
      <td width="20%">
        <impact:validateDisplayOnlyField
          name="szCdCurrStage"
          label="Current Stage"
          value="<%=currStage%>"
        />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect
          label="Create New Stage"
          name="selNewStage"
          value="<%=newStage%>"
          options="<%=stages.values()%>"
          style="width:200"
          tabIndex="<%= tabIndex++ %>"
          required="true"
        />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField
          name="nmPerson"
          label="Stage Name"
          value="<%=nmPerson%>"
          conditionallyRequired="true"
        />
      </td>
      <td>
        <impact:ButtonTag
          name="btnPerson"
          img="btnSelectPerson"
          function="return checkPerson(false)"
          align="right"
          form="frmStageProgression"
          action="/workload/StageProgression/createPersonList"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
    </tr>
  </table>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" >
    <tr>
      <td>
        <impact:ButtonTag
          name="btnSave"
          img="btnSave"
          restrictRepost="true"
          function="return confirmStageAgeAndProgress();"
          align="right"
          form="frmStageProgression"
          action="/workload/StageProgression/saveStageProgression"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
    </tr>
  </table>
  <% /*  Always include this hidden field in your form */ %>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>