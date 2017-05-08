<%/**--------------------------------------------------------------------------------
       *
       * JSP Name:     Safety Assessment
       * Created by:   Modeste Ngom
       * Date Created: 09/06/2006
       *
       * Description:
       * This JSP displays the details for a given Safety Assessment. Depending upon
       * the user's privileges, the user can use this page to view and update Safety Assessments.
      
       Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       11-09-06  abgoode           SIR 934 - Added a third hidden field eplTsLastUpdate so
                                   that attempts to delete the record in EventPersonLink work.
                                   Also cleaned up the code a little.
       11-21-06  abgoode           Removed the hidden field eplTsLastUpdate since data is no
                                   longer being saved to the EventPersonLink table.
       
       12-12-06  srollins        Added the forms drop-down and launch button so that when
                        the launch button is the click the Safety Assessment Form
                        will display in a separate  window.
                        
       7/10/08   cwells           Added a new method for the approval status button that saves the 
       							  page then upon a successful save navigates to the Approval status page  
       							  
       10/10/08  charden          STGAP00005341 - Added code to keep overall decision from dirtying page
       
       11/14/08  arege            STGAP00010758 - Modified code so that the SaveAndSubmit button is not displayed for the 
                                                  Supervisor in approval mode.  
                                                  
       05/04/09  cwells           STGAP00013413 - If we are in approval mode call save and then approval status display in the conversation.  But
       											  if we are not in approval mode then just display approval staus page.                                        
                                                                    
       */

      %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorsRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.DrugExposedNewBornRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ReasonableEffortsRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyAssessmentConversation"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO"%>

<%//*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************
      int tabIndex = 1;
      SafetyAssessmentRetrieveSO safetyAssessment = new SafetyAssessmentRetrieveSO();

      boolean bShowDeleteButton = false;
      boolean bShowDrugExposedNewborns = false;

      String tsLastUpdate = "";
      String saTsLastUpdate = "";
      String selOverallSafetyDecision= "";

      //***********************************
      //*** RETRIEVE HIDDEN STATE FIELD ***
      //***********************************
      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      //*********************
      //*** SET PAGE MODE ***
      //*********************
      String pageMode = PageModeConstants.VIEW;
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }
      boolean bShowSaveAndSubmitButton = true;
      if(GlobalData.isApprovalMode(request)){
      bShowSaveAndSubmitButton = false;
      }

      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************
      boolean approvalStatus = true;
      // Get the Safety Assessment bean from the request
      if (state.getAttribute("SafetyAssessmentRetrieveSO", request) != null) {
        safetyAssessment = (SafetyAssessmentRetrieveSO) state.getAttribute("SafetyAssessmentRetrieveSO", request);
        if (safetyAssessment.getROWCCMN45DO() != null) {
          tsLastUpdate = DateHelper.toISOString(safetyAssessment.getROWCCMN45DO().getTsLastUpdate());
          saTsLastUpdate = DateHelper.toISOString(safetyAssessment.getDtLastUpdate());
        }
        ROWCCMN45DO eventDetails = safetyAssessment.getROWCCMN45DO();
        if ((eventDetails == null)
            || pageMode.equals(PageModeConstants.NEW)
            || (!SafetyAssessmentConversation.EVENT_STATUS_PEND.equals(eventDetails.getSzCdEventStatus()) && !SafetyAssessmentConversation.EVENT_STATUS_APPROVED
                                                                                                                                                                .equals(eventDetails
                                                                                                                                                                                    .getSzCdEventStatus()))) {
          approvalStatus = false;
        }
      }

      //to do later - add in pending approval check
      if (safetyAssessment.getUlIdEvent() != 0) {
        bShowDeleteButton = true;
      }

      if (safetyAssessment.getIsDrugExposedNewBorn()) {
        bShowDrugExposedNewborns = true;
      }


   if( request.getParameter("selOverallSafetyDecision") != null )
    {
      selOverallSafetyDecision = request.getParameter("selOverallSafetyDecision");
    }else
    {
      selOverallSafetyDecision =safetyAssessment.getSzTxtOverallSafetyDecision();
    }

      // Check the request to see if the "pageSaved" indicator
      // has been passed to this page. If the indicator has been passed to
      // this page and is "true", this page needs to display the appropriate messages.

%>

<%//******************
      //*** JAVASCRIPT ***
      //******************

      %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">

var previousIndex =0;
var previousLength =0;
var msg=true;


// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
  IsDirty();
}

function documentAlert()
{
  alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_ARC_SAVE_PAGE) %>');
  return false;
}

window.onload = function() {
isSafetyFactorCheckedYes();
setTheDefaultValue();
}


function isSafetyFactorCheckedYes(){
var yesIsChecked = false;
var radionElement;
for (i=0;i<document.frmSafetyAssessment.elements.length;i++) {
    var elementType = document.frmSafetyAssessment.elements[i].type;
    if (elementType=='radio'){
      var checkBoxName = document.frmSafetyAssessment.elements[i].name;
      if (document.frmSafetyAssessment.elements[i].checked && checkBoxName.substring(0,4)=='rbSF' ) {
          var choice = document.frmSafetyAssessment.elements[i];
          if (choice.value=='Y'){
            yesIsChecked = true;
            break;
          }
      }
  }
  }
  if (yesIsChecked==true){
    resetSelOverallSafetyDecision('Y');
  }else{
    resetSelOverallSafetyDecision('N');
  }
}

function resetSelOverallSafetyDecision(choice)
{
    var listObj = document.frmSafetyAssessment.selOverallSafetyDecision;
    if (listObj!=null && listObj.selectedIndex!=null){
      previousIndex = listObj.selectedIndex;
      if (listObj.options!=null){
         previousLength = listObj.options.length;
      } else {
        previousLength = 4;
      }
    }else {
      previousIndex = 0;
    }
    
    msg = true;
    if (previousIndex==2 && previousLength==4 && choice=='Y') {
      msg =  confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_ASSMT_SA_CLEAR_OVRL_DECISION ) %>" );
      if (!msg) {
          return false;
      }
    }
    
    if (listObj!=null && listObj.options!=null){
      listObj.options.length=0;
        if (choice=='Y'){
      listObj.options[0] = new Option('','');
         listObj.options[1] = new Option('Conditionally Safe','CS');
        listObj.options[2] = new Option('Unsafe','US');
      } else if (choice=='N'){
         listObj.options[0] = new Option('','');
        listObj.options[1] = new Option('Conditionally Safe','CS');
        listObj.options[2] = new Option('Safe','SF');
        listObj.options[3] = new Option('Unsafe','US');
      } 
    }
     

}

function setCurrentValue(){

    if (msg){
    var listObj = document.frmSafetyAssessment.selOverallSafetyDecision;
    var currentLength=listObj.options.length;

      if (previousIndex==0){
       listObj.options[0].selected = true;
      }
      if (previousIndex==1){
       listObj.options[1].selected=true;
      }

      if (previousIndex==3){
          if (currentLength==3){
           listObj.options[2].selected = true;
          }else {
             if (currentLength==4){
                listObj.options[3].selected=true;
             }
          }
      }
            
      if (previousIndex==2){
        
        if (previousLength==3 && currentLength==4){
           listObj.options[3].selected = true;
        }else {
           if (previousLength==3 && currentLength==3){
             listObj.options[2].selected= true;
           } 
        }
      }
   }
   
   return msg;
}

function setTheDefaultValue(){
var selectedValue = '<%=FormattingHelper.formatString( selOverallSafetyDecision )%>';
var listObj = document.frmSafetyAssessment.selOverallSafetyDecision;
if (listObj!=null && listObj.options!=null){
for (i = 0 ; i < listObj.options.length ; i++){
        if (listObj.options[i].value==selectedValue){
          listObj.options[i].selected = true;
          listObj.options[i].defaultSelected = true;
        }
    }
    }
}

function checkTheOther(radioBtn,indexToCheck){
 var radioGroupSelected = document.getElementsByName(radioBtn.name);
 radioGroupSelected[indexToCheck].checked=true;
}

function radioBtnFunction(radioBtn,indexToCheck){

isSafetyFactorCheckedYes();
setCurrentValue(); 
if (!msg) {
  checkTheOther(radioBtn,indexToCheck);
}

}

</script>

<%//**************************
      //**** FORM STARTS HERE ****
      //**************************

      %>

<impact:validateErrors />
<impact:validateForm name="frmSafetyAssessment" method="post" action="/investigation/SafetyAssessment/displaySafetyAssessment" pageMode="<%= pageMode %>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyAssessmentCustomValidation"
  schema="/WEB-INF/Constraints.xsd">

  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <%if (approvalStatus) {
        String action = ApprovalStatusConversation.DISPLAY_URI;
        if (GlobalData.isApprovalMode(request)) {
	        action = "/investigation/SafetyAssessment/submitApproval";
	      }
        %>
      <td class="alignLeft" width="85%">
        <impact:ButtonTag name="btnApprovalStatus" tabIndex="<%= tabIndex++ %>" img="btnApprovalStatus" editableMode="<%=EditableMode.ALL%>" form="frmSafetyAssessment" action="<%=action%>" />
      </td>
      <%} else { %>
      <td class="alignLeft" width="85%">
        &nbsp;
      </td>
      <% } %>

      <td align="right">
        <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp; <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
      </td>

    </tr>
  </table>
  <br>
  <impact:ExpandableSectionTag name="SafetyFactorsTable" id="Safety_Factor" label="Safety Factors" tabIndex="<%= tabIndex++ %>">
    <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">

      <%Map<String, Collection<SafetyFactorsRetrieveSO>> map = safetyAssessment.getSafetyFactors();
      
      //-- null check
      if(map == null){
        map = new HashMap<String, Collection<SafetyFactorsRetrieveSO>>();
      }
      
      Iterator<String> mapIterator = map.keySet().iterator();

      List<String> keyList = new ArrayList<String>();

      while (mapIterator.hasNext()) {
        String nextItem = mapIterator.next();
        keyList.add(nextItem);
      }

      //sort the keys and add to a collections item

      Collections.sort(keyList);

      Iterator<String> listIter = keyList.iterator();

      while (listIter.hasNext()) {

        String code = listIter.next();
        
        if (!SafetyAssessmentConversation.OTHER_QUESTION.equals(code)) {

          %>
      <tr class="altColor">
        <td colspan="4">
          <%=Lookup.simpleDecodeSafe(SafetyAssessmentConversation.SAFETY_FACTORS_CODES_TABLES, code)%>
        </td>
      </tr>

      <tr class="altColor">
        <td>
          <b>Caretaker</b>
        </td>
        <td>
          <b>Child</b>
        </td>
        <td>
          <b>Yes</b>
        </td>
        <td>
          <b>No</b>
        </td>
      </tr>
      <%Collection<SafetyFactorsRetrieveSO> coll = map.get(code);
          
          //-- null check
          if(coll == null){
            coll = new ArrayList<SafetyFactorsRetrieveSO>();
          }
          
          Iterator<SafetyFactorsRetrieveSO> safetyFactorIterator = coll.iterator();
          while (safetyFactorIterator.hasNext()) {
            SafetyFactorsRetrieveSO sa = safetyFactorIterator.next();
            String rbFieldName = "rbSF" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
            String idFieldName = "id" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
            String dtFieldName = "dt" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
            String yIsChecked = "false";
            String nIsChecked = "true";
            if ("Y".equals(sa.getSzCdSafetyFactorResponse())) {
              yIsChecked = "true";
              nIsChecked = "false";
            }

            %>
      <tr class="odd">
        <td>
          <%=sa.getTxtCaretaker()%>
        </td>
        <td>
          <%=sa.getTxtChild()%>
        </td>
        <td>
          <impact:validateInput type="radio" onClick="radioBtnFunction(this,1);" checked="<%=yIsChecked%>" tabIndex="<%= tabIndex++ %>" value="Y" name="<%=rbFieldName%>" cssClass="formInput" />
        </td>
        <td>
          <impact:validateInput type="radio" onClick="radioBtnFunction(this,0);" checked="<%=nIsChecked%>" tabIndex="<%= tabIndex++ %>" value="N" name="<%=rbFieldName%>" cssClass="formInput" />
        </td>
        <input type="hidden" name="<%=idFieldName%>" value="<%=sa.getUlIdSafetyFactor()%>">
        <input type="hidden" name="<%=dtFieldName%>" value="<%=DateHelper.toISOString(sa.getDtDtLastUpdateDt())%>">
      </tr>
      <%} // end of SafetyFactorsCollection

        %>
      <%} // end of if Other

      } %>

      <tr class="altColor">
        <td colspan="4">
          Other(specify):
          <impact:validateInput type="text" label="" width="60" constraint="Paragraph80" name="txtOtherSafetyFactor" cssClass="formInput" value="<%=safetyAssessment.getSzTxtOtherSafetyFactor()%>" size="90" maxLength="80" tabIndex="<%=tabIndex++ %>" />
        </td>
      </tr>
      <tr class="altColor">
        <td>
          <b>Caretaker</b>
        </td>
        <td>
          <b>Child</b>
        </td>
        <td>
          <b>Yes</b>
        </td>
        <td>
          <b>No</b>
        </td>
      </tr>
      <%String code = SafetyAssessmentConversation.OTHER_QUESTION;
      Collection<SafetyFactorsRetrieveSO> coll = map.get(code);
      
      //-- null check
      if(coll == null){
        coll = new ArrayList<SafetyFactorsRetrieveSO>();
      }
      
      Iterator<SafetyFactorsRetrieveSO> safetyFactorIterator = coll.iterator();
      while (safetyFactorIterator.hasNext()) {
        SafetyFactorsRetrieveSO sa = safetyFactorIterator.next();
        String rbFieldName = "rbSF" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
        String idFieldName = "id" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
        String dtFieldName = "dt" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
        String yIsChecked = "false";
        String nIsChecked = "true";
        if ("Y".equals(sa.getSzCdSafetyFactorResponse())) {
          yIsChecked = "true";
          nIsChecked = "false";
        }

        %>
      <tr class="odd">
        <td>
          <%=sa.getTxtCaretaker()%>
        </td>
        <td>
          <%=sa.getTxtChild()%>
        </td>
        <td>
          <impact:validateInput type="radio" onClick="radioBtnFunction(this,1);" checked="<%=yIsChecked%>" tabIndex="<%= tabIndex++ %>" value="Y" name="<%=rbFieldName%>" cssClass="formInput" />
        </td>
        <td>
          <impact:validateInput type="radio" onClick="radioBtnFunction(this,0);" checked="<%=nIsChecked%>" tabIndex="<%= tabIndex++ %>" value="N" name="<%=rbFieldName%>" cssClass="formInput" />
        </td>
        <input type="hidden" name="<%=idFieldName%>" value="<%=sa.getUlIdSafetyFactor()%>">
        <input type="hidden" name="<%=dtFieldName%>" value="<%=DateHelper.toISOString(sa.getDtDtLastUpdateDt())%>">
      </tr>
      <% } %>
      <tr class="altColor">
        <td colspan="4">
          Additional Comments:
        </td>
      </tr>
      <tr class="altColor">
        <td valign="top" colspan="4">
          <impact:validateTextArea name="txtAddtnlCommnts" colspan="4" label="" rows="4" cols="100" tabIndex="<%= tabIndex++ %>" constraint="Comments">
            <%=FormattingHelper.formatString(safetyAssessment.getSzTxtAddtnlCommnts())%>
          </impact:validateTextArea>
        </td>
      </tr>

    </table>
  </impact:ExpandableSectionTag>
  <br>
  <%if (bShowDrugExposedNewborns) { %>
  <impact:ExpandableSectionTag name="DrugExposedNewbornTable" id="Drug_Exposed" label="Drug Exposed Newborn" tabIndex="<%= tabIndex++ %>">
    <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">

      <%Iterator<DrugExposedNewBornRetrieveSO> iteratorDEN = safetyAssessment.getDrugExposedNewborn().iterator();
        while (iteratorDEN.hasNext()) {
          DrugExposedNewBornRetrieveSO dEN = iteratorDEN.next();
          String codeDEN = dEN.getSzCdDrugExpNb();
          String fieldNameDEN = "rb" + codeDEN;
          String hdnDENId = "id" + codeDEN;
          String hdbDtLastUpdate = "dt" + codeDEN;
          String yIsCheckedDEN = "false";
          String nIsCheckedDEN = "false";
          if ("Y".equals(dEN.getSzCdDrugExpNbRps())) {
            yIsCheckedDEN = "true";
          } else if ("N".equals(dEN.getSzCdDrugExpNbRps())) {
            nIsCheckedDEN = "true";
          }

          %>
      <tr class="odd">
        <td>
          <%=Lookup.simpleDecodeSafe(SafetyAssessmentConversation.DRUG_EXPOSED_NEW_BORNS, codeDEN)%>
        </td>
        <td>
          <impact:validateInput type="radio" checked="<%=yIsCheckedDEN%>" tabIndex="<%= tabIndex++ %>" value="Y" name="<%=fieldNameDEN%>" cssClass="formInput" />
          Yes
        </td>
        <td>
          <impact:validateInput type="radio" checked="<%=nIsCheckedDEN%>" tabIndex="<%= tabIndex++ %>" value="N" name="<%=fieldNameDEN%>" cssClass="formInput" />
          No
        </td>
        <input type="hidden" value="<%=dEN.getUIdDrugExposedNewborn()%>" name="<%=hdnDENId%>">
        <input type="hidden" value="<%=DateHelper.toISOString(dEN.getDtLastUpdateDt())%>" name="<%=hdbDtLastUpdate%>">
      </tr>
      <%}%>
    </table>
  </impact:ExpandableSectionTag>
  <br>
  <% } %>

  <impact:ExpandableSectionTag name="ReasonableEfforts" id="Reasonable_Efforts" label="Reasonable Efforts" tabIndex="<%= tabIndex++ %>">
    <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">

      <%Map<String, Collection<ReasonableEffortsRetrieveSO>> mapRE = safetyAssessment.getReasonableEfforts();
      Iterator<String> iteratorRE = mapRE.keySet().iterator();
      while (iteratorRE.hasNext()) {
        String codeRE = iteratorRE.next();
        Collection<ReasonableEffortsRetrieveSO> collRE = mapRE.get(codeRE);

        %>
      <tr class="altColor">
        <td colspan="4">
          <%=Lookup.simpleDecodeSafe(SafetyAssessmentConversation.REASONABLE_EFFORTS, codeRE)%>
        </td>
      </tr>
      <tr class="altColor">
        <td>
          <b>Child</b>
        </td>
        <td>
          <b>Yes</b>
        </td>
        <td>
          <b>No</b>
        </td>
        <td>
          <b>Comments</b>
        </td>
      </tr>
      <%Iterator<ReasonableEffortsRetrieveSO> iteratorCollRE = collRE.iterator();
        while (iteratorCollRE.hasNext()) {
          ReasonableEffortsRetrieveSO rE = iteratorCollRE.next();
          String rbFieldNameRE = "rb" + rE.getSzCdReasonableEfforts() + "_" + rE.getIdChild();
          String txtFieldNameRE = "txt" + rE.getSzCdReasonableEfforts() + "_" + rE.getIdChild();
          String idFieldNameRE = "id" + rE.getSzCdReasonableEfforts() + "_" + rE.getIdChild();
          String dtFieldNameRE = "dt" + rE.getSzCdReasonableEfforts() + "_" + rE.getIdChild();
          String yIsCheckedRE = "false";
          String nIsCheckedRE = "false";
          if ("Y".equals(rE.getSzCdReasonableEffortsResponse())) {
            yIsCheckedRE = "true";
          } else if ("N".equals(rE.getSzCdReasonableEffortsResponse())) {
            nIsCheckedRE = "true";
          }

          %>
      <tr class="odd">
        <td>
          <%=rE.getSzTxtChild()%>
        </td>
        <td>
          <impact:validateInput type="radio" checked="<%=yIsCheckedRE%>" tabIndex="<%= tabIndex++ %>" value="Y" name="<%=rbFieldNameRE%>" cssClass="formInput" />
        </td>
        <td>
          <impact:validateInput type="radio" checked="<%=nIsCheckedRE%>" tabIndex="<%= tabIndex++ %>" value="N" name="<%=rbFieldNameRE%>" cssClass="formInput" />
        </td>
        <td>
          <impact:validateTextArea name="<%= txtFieldNameRE %>" tabIndex="<%= tabIndex++ %>" constraint="Paragraph80" maxLength="80" cols="80" rows="2">
            <%=rE.getSzTxtComments()%>
          </impact:validateTextArea>
        </td>
        <input type="hidden" name="<%=idFieldNameRE%>" value="<%=rE.getUlIdReasonableEfforts()%>">
        <input type="hidden" name="<%=dtFieldNameRE%>" value="<%=DateHelper.toISOString(rE.getDtDtLastUpdateDt())%>">
      </tr>
      <%} // end of iteratorCollRE

      %>
      <%}%>
      <tr class="altColor">
        <td colspan="4">
          Why responses 1-5 could not be used to keep children safe:
        </td>
      </tr>
      <tr class="altColor">
        <td valign="top" colspan="4">
          <impact:validateTextArea name="txtResponse" colspan="4" label="" rows="4" cols="100" tabIndex="<%= tabIndex++ %>" constraint="Comments">
            <%=FormattingHelper.formatString(safetyAssessment.getSzTxtWhyResponses())%>
          </impact:validateTextArea>
        </td>
      </tr>
    </table>
  </impact:ExpandableSectionTag>
  <br>
  <impact:ExpandableSectionTag name="SafetyDecision" id="Safety_Decision" label="Safety Decision" tabIndex="<%= tabIndex++ %>">
    <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">

      <tr class="odd">
        <td>
          <impact:validateSelect label="Overall Safety Decision" name="selOverallSafetyDecision" tabIndex="<%= tabIndex++ %>" codesTable="COVSFDSN" value="<%= FormattingHelper.formatString( selOverallSafetyDecision ) %>" />
        </td>
      </tr>
    </table>
  </impact:ExpandableSectionTag>


  <%//*****************
      //**** BUTTONS ****
      //*****************
      // Display the Save and Submit and Save buttons unless the page mode is VIEW. 
      if (!pageMode.equals(PageModeConstants.VIEW)) {%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td colspan="4">
        <br>
        <hr>
      </td>
    </tr>
    <tr>
      <%if (bShowDeleteButton) {%>
      <td width="85%" class="alignLeft">
        <impact:ButtonTag name="btnDelete" img="btnDelete" align="left" form="frmSafetyAssessment" action="/investigation/SafetyAssessment/deleteSafetyAssessment" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
      <%} else {%>
      <td class="alignLeft" width="85%">
        &nbsp;
      </td>
      <%}%>
      <%if(bShowSaveAndSubmitButton){%>
      <td class="alignRight">
        <impact:ButtonTag name="btnSaveSubmit" img="btnSaveAndSubmit" align="right" form="frmSafetyAssessment" action="/investigation/SafetyAssessment/saveAndSubmitSafetyAssessment" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
      <%}
       %>
      <td class="alignRight">
        <impact:ButtonTag name="btnSave" img="btnSave" align="right" form="frmSafetyAssessment" action="/investigation/SafetyAssessment/saveSafetyAssessment" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>
  <%}
%>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  <impact:validateInput type="hidden" name="tsLastUpdate" value="<%= tsLastUpdate %>" />
  <impact:validateInput type="hidden" name="saTsLastUpdate" value="<%= saTsLastUpdate %>" />
</impact:validateForm>

<%-- Safety Assessment Form Launch --%>
<br>
<% if (bShowDeleteButton) { %>
<impact:ifServerImpact>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="4">
        Forms Launch
      </th>
    </tr>
    <tr>
      <td>
        <impact:documentList pageMode="2" tabIndex="<%= tabIndex++ %>">
          <impact:document displayName="Safety Assessment" protectDocument="true" checkForNewMode="false" docType="FAS01O00" docExists="false">
            <impact:documentParameter name="pCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request) ) %>" />
            <impact:documentParameter name="pStage" value="<%=String.valueOf(GlobalData.getUlIdStage(request) )%>" />
            <impact:documentParameter name="pEvent" value="<%=String.valueOf(GlobalData.getUlIdEvent(request) )%>" />
          </impact:document>
        </impact:documentList>
      </td>
    </tr>
  </table>

  <br>
  <% /* end Forms */ %>

</impact:ifServerImpact>
<% } %>