<%--
//*  JSP Name:     Adoption Information JSP
//*  Created by:   Jacob Vaidyan
//*  Date Created: 2/18/2007
//*
//*  Description:This Page is for the Adoption Information .
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//** 03/11/08  schoi             STGAP00007708: Modified a label in Adoption Information 
//** 
//** 03/13/08  schoi             STGAP00007709: Fixed error in County value by updating Java script 
//**                             in simpleDecodeSafe method. 
//**  
//** 03/20/08  schoi             STGAP00007841: Changed the order of the entries by moving Permission 
//**                             to File Letter right before Documents Sent to Attorney.
//**
//** 10/7/08	rphelps			 STGAP00010003: Made changes for adoptions enhancements
//** 
//** 02/17/09  arege             STGAP00012095: Modified function getExchChildPage to accept one
//**                             more parameter - nameChildPerson 
//**
//** 04/10/09  hjbaptiste        STGAP00012963: Added the word 'Placement' in front of the column header 'Group:'                
//** 05/24/11  hnguyen           SMS#109405: MR-083 Added new Actively Recruiting question for State Recruitment Activities section. Increased comments
//**                             for Family Considered section to 2000 characters and increased comment field for recruitment activities to 1000
//**                             characters. Turned on client-side validations. Also cleaned up code to be more dynamic.
//** 06/14/11  hnguyen           SMS#111995: MR-083 Modified read-only comments fields to be scrollable.
//** 09/23/11  hnguyen           STGAP00017011: MR-092 Added new Sibling with ADO in another case questions and dynacmic dropdowns.
//** 10/13/11  hgnuyen           STGAP00017148: Update label to be grammatically correct.
//**  
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%> 
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionResourceBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AdoInfoCbxSentStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildFamilyLinkBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupInformationSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingExternalLinkStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingPlacementGroupSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.AdoptionInformationConversation"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.StringTokenizer"%>
<%
  //*******************************
  //*** DECLARE LOCAL VARIABLES ***
  //*******************************
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UserProfile user = UserProfileHelper.getUserProfile(request);
  int tabIndex = 1;
  int loopCount = 0;
  int loopCount1 = 0;
  int arrayIndex = 0;
  int beanSize = 0;
  String EMPTY_STRING = "";
  String fieldName = EMPTY_STRING;
  String fieldName1 = EMPTY_STRING;
  String fieldName2 = EMPTY_STRING;
  String cdEventStatus = EMPTY_STRING;
  String dtFostParNotAgTPR = EMPTY_STRING;
  String dtPermStaffFostPar = EMPTY_STRING;
  String dtFostParNotAgDecAdpt = EMPTY_STRING;
  String dtChildLifeHistPres = EMPTY_STRING;
  String dtSelectionLetterSent = EMPTY_STRING;
  String dtStaffAdptFam = EMPTY_STRING;
  String dtAdptPlacAgmtSigned = EMPTY_STRING;
  String dtDocSentAttor = EMPTY_STRING;
  String dtDisruption = EMPTY_STRING;
  String dtPermFileLetterComp = EMPTY_STRING;
  String indOtherSiblingsAdopted = EMPTY_STRING;
  String indOutofTown = EMPTY_STRING;
  int nmFamConsidered = 0;
  int hdnResourceId = 0;
  String szCdReasonsFamNotSel = EMPTY_STRING;
  String szCdTypeAdptRsrcNeeded = EMPTY_STRING;
  String szCdChildLinked = EMPTY_STRING;
  String szCdComntsPrepAct = EMPTY_STRING;
  String szCdComntsBarRec = EMPTY_STRING;
  String szCdComntsRecActsState = EMPTY_STRING;
  String szCdComntsRecActsCounty = EMPTY_STRING;
  String szCdComntsBarPla = EMPTY_STRING;
  String szCdComntsBarTpr = EMPTY_STRING;
  String szCdReasonChildNonAvail = EMPTY_STRING;
  String txtSzNmAdpRes = EMPTY_STRING;
  String txtSzCounty = EMPTY_STRING;
  String txtSzHomeType = EMPTY_STRING;
  String txtSzICPCState = EMPTY_STRING;
  String txtSzNmPrAgency = EMPTY_STRING;
  String indIdentifiedAdopRes = EMPTY_STRING;
  String indAdoptOutcome = EMPTY_STRING;
  String szCdExchConsidered = EMPTY_STRING;
  String szCdCountyConsideredComments = EMPTY_STRING;
  List checkedPreperationActivities = new ArrayList();
  List checkedBarriersRecruitment = new ArrayList();
  boolean hasSiblings = false;
  boolean hasSiblingExternal = false;

  // MR-083
  String szCdStateActivelyRecruiting = EMPTY_STRING;
  Map<String, List<AdoInfoCbxSentStruct>> savedRecActivitiesDatesCounty = new HashMap<String, List<AdoInfoCbxSentStruct>>();
  Map<String, List<Date>> savedRecActivitiesDatesState = new HashMap<String, List<Date>>();

  List checkedBarriersPlacement = new ArrayList();
  List checkedBarriersTPR = new ArrayList();
  List<AdoptionResourceBean> resBeanList = new ArrayList();
  List<ExchangeChildFamilyLinkBean> childFamilyLinkList = new ArrayList();
  List<SiblingSO> siblingList = null;
  List<SiblingExternalLinkStruct> siblingExternalLinkList = new ArrayList<SiblingExternalLinkStruct>();
  Map<Integer, Integer> prnChildrenUnder18WithAnotherAdoCase = new HashMap<Integer, Integer>();
  int numOfSiblings = 0;
  Map<SiblingSO, SiblingPlacementGroupSO> siblingGroupings = null;
  SiblingGroupInformationSO siblingGroupInformation = null;
  List<SiblingPlacementGroupSO> siblingPlacementGroupList = null;
  List<Option> siblingExtCaseOptionList = new ArrayList<Option>();
  int numOfNewSiblingGroups = 0;
  int totalAvailableForAdoption = 0;

  String editableMode = PageMode.getPageMode(request);

  //Populating the checkboxes with reference to codes tables.    
  //Preparation Activities
  Collection preparationacts = Lookup.getCategoryCollection(CodesTables.CADCPAC);
  List preparationactsList = new ArrayList(preparationacts);
  //Recruitment Activities - State
  Collection recactsstate = Lookup.getCategoryCollection(CodesTables.CADRACS);
  List recactsstateList = new ArrayList(recactsstate);
  // Recruitment Activities - County
  Collection recactscounty = Lookup.getCategoryCollection(CodesTables.CADRACC);
  List activityCodesList = new ArrayList(recactscounty);
  // Barriers to Recruitment
  Collection barrtorecrmnt = Lookup.getCategoryCollection(CodesTables.CADBREC);
  List barrtorecrmntList = new ArrayList(barrtorecrmnt);
  // Barriers to Placement
  Collection barrtoplacmnt = Lookup.getCategoryCollection(CodesTables.CADBPLA);
  List barrtoplacmntList = new ArrayList(barrtoplacmnt);

  Collection barrtotpr = Lookup.getCategoryCollection(CodesTables.CADBTPR);
  List barrtotprList = new ArrayList(barrtotpr);

  AdoptionInformationRetrieveSO adoptioninformationret = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO", request);
  siblingExtCaseOptionList = (List<Option>) state.getAttribute("siblingOptionList", request);
  
  if(adoptioninformationret.getCdEventStatus() != null) {
    cdEventStatus = adoptioninformationret.getCdEventStatus();
  }
  if(adoptioninformationret.getDtFostParNotAgTPR() != null) {
    dtFostParNotAgTPR = FormattingHelper.formatDate(adoptioninformationret.getDtFostParNotAgTPR());
  }
  if(adoptioninformationret.getDtPermStaffFostPar() != null) {
    dtPermStaffFostPar = FormattingHelper.formatDate(adoptioninformationret.getDtPermStaffFostPar());
  }
  if(adoptioninformationret.getDtLetterSent() != null) {
    dtSelectionLetterSent = FormattingHelper.formatDate(adoptioninformationret.getDtLetterSent());
  }
  if(adoptioninformationret.getDtFostParNotAgDecAdpt() != null) {
    dtFostParNotAgDecAdpt = FormattingHelper.formatDate(adoptioninformationret.getDtFostParNotAgDecAdpt());
  }
  if(adoptioninformationret.getIndAdoptOutcome() != null) {
    indAdoptOutcome = adoptioninformationret.getIndAdoptOutcome();
  }
  if(adoptioninformationret.getSzCdExchConsidered() != null) {
    szCdExchConsidered = adoptioninformationret.getSzCdExchConsidered();
  }
  if(adoptioninformationret.getDtChildLifeHistPres() != null) {
    dtChildLifeHistPres = FormattingHelper.formatDate(adoptioninformationret.getDtChildLifeHistPres());
  }
  if(adoptioninformationret.getDtStaffAdptFam() != null) {
    dtStaffAdptFam = FormattingHelper.formatDate(adoptioninformationret.getDtStaffAdptFam());
  }
  if(adoptioninformationret.getSzCdCountyConsidered() != null) {
    szCdCountyConsideredComments = adoptioninformationret.getSzCdCountyConsidered();
  }
  if(adoptioninformationret.getDtAdptPlacAgmtSigned() != null) {
    dtAdptPlacAgmtSigned = FormattingHelper.formatDate(adoptioninformationret.getDtAdptPlacAgmtSigned());
  }
  if(adoptioninformationret.getDtDocSentAttor() != null) {
    dtDocSentAttor = FormattingHelper.formatDate(adoptioninformationret.getDtDocSentAttor());
  }
  if(adoptioninformationret.getDtDisruption() != null) {
    dtDisruption = FormattingHelper.formatDate(adoptioninformationret.getDtDisruption());
  }
  if(adoptioninformationret.getDtPermFileLetterComp() != null) {
    dtPermFileLetterComp = FormattingHelper.formatDate(adoptioninformationret.getDtPermFileLetterComp());
  }
  if(adoptioninformationret.getIndOutofTown() != null) {
    indOutofTown = adoptioninformationret.getIndOutofTown();
  }
  if(adoptioninformationret.getIndOtherSiblingsAdopted() != null) {
    indOtherSiblingsAdopted = adoptioninformationret.getIndOtherSiblingsAdopted();
  }
  nmFamConsidered = adoptioninformationret.getNmFamConsidered();
  if(adoptioninformationret.getSzCdReasonsFamNotSel() != null) {
    szCdReasonsFamNotSel = adoptioninformationret.getSzCdReasonsFamNotSel();
  }
  if(adoptioninformationret.getSzCdTypeAdptRsrcNeeded() != null) {
    szCdTypeAdptRsrcNeeded = adoptioninformationret.getSzCdTypeAdptRsrcNeeded();
  }
  if(adoptioninformationret.getSzCdComntsPrepAct() != null) {
    szCdComntsPrepAct = adoptioninformationret.getSzCdComntsPrepAct();
  }
  if(adoptioninformationret.getSzCdComntsBarRec() != null) {
    szCdComntsBarRec = adoptioninformationret.getSzCdComntsBarRec();
  }
  if(adoptioninformationret.getSzCdComntsRecActsState() != null) {
    szCdComntsRecActsState = adoptioninformationret.getSzCdComntsRecActsState();
  }
  if(adoptioninformationret.getSzCdComntsRecActsCounty() != null) {
    szCdComntsRecActsCounty = adoptioninformationret.getSzCdComntsRecActsCounty();
  }
  if(adoptioninformationret.getSzCdComntsBarPla() != null) {
    szCdComntsBarPla = adoptioninformationret.getSzCdComntsBarPla();
  }
  if(adoptioninformationret.getSzCdComntsBarTpr() != null) {
    szCdComntsBarTpr = adoptioninformationret.getSzCdComntsBarTpr();
  }
  if(adoptioninformationret.getSzCdReasonChildNonAvail() != null) {
    szCdReasonChildNonAvail = adoptioninformationret.getSzCdReasonChildNonAvail();
  }
  hdnResourceId = adoptioninformationret.getResourceIdForPullback();
  if(adoptioninformationret.getNMResource() != null) {
    txtSzNmAdpRes = adoptioninformationret.getNMResource();
  }
  if(adoptioninformationret.getSzCdCounty() != null) {
    txtSzCounty = adoptioninformationret.getSzCdCounty();
  }
  if(adoptioninformationret.getSzCdCategory() != null) {
    txtSzHomeType = adoptioninformationret.getSzCdCategory();
  }
  if(adoptioninformationret.getSzCdState() != null) {
    txtSzICPCState = adoptioninformationret.getSzCdState();
  }
  if(adoptioninformationret.getNMAgency() != null) {
    txtSzNmPrAgency = adoptioninformationret.getNMAgency();
  }
  if(adoptioninformationret.getIndIdentifiedAdopRes() != null) {
    indIdentifiedAdopRes = adoptioninformationret.getIndIdentifiedAdopRes();
  }
  if(adoptioninformationret.getSzCdChildLinked() != null) {
    szCdChildLinked = adoptioninformationret.getSzCdChildLinked();
  }
  if(adoptioninformationret.getIdenResList() != null) {
    resBeanList = adoptioninformationret.getIdenResList();
    beanSize = resBeanList.size();
  }
  if(adoptioninformationret.getChildFamilyLinkList() != null) {
    childFamilyLinkList = adoptioninformationret.getChildFamilyLinkList();
  }
  if(adoptioninformationret.getChkPreperationActivities() != null) {
    String[] checkedPrepActs = null;
    checkedPrepActs = adoptioninformationret.getChkPreperationActivities();
    for (int i = 0; i < checkedPrepActs.length; i++) {
      checkedPreperationActivities.add(checkedPrepActs[i]);
    }
  }
  if(adoptioninformationret.getChkBarriersRecruitment() != null) {
    String[] checkedBarRec = null;
    checkedBarRec = adoptioninformationret.getChkBarriersRecruitment();
    for (int i = 0; i < checkedBarRec.length; i++) {
      checkedBarriersRecruitment.add(checkedBarRec[i]);
    }
  }

  if(adoptioninformationret != null) {
    szCdStateActivelyRecruiting = adoptioninformationret.getSzCdStateActivelyRecruiting();
  }

  if(adoptioninformationret.getSavedRecActivitiesDatesCounty() != null) {
    savedRecActivitiesDatesCounty = adoptioninformationret.getSavedRecActivitiesDatesCounty();
  }

  if(adoptioninformationret.getSavedRecActivitiesDatesState() != null) {
    savedRecActivitiesDatesState = adoptioninformationret.getSavedRecActivitiesDatesState();
  }

  if(adoptioninformationret.getChkBarriersPlacement() != null) {
    String[] checkedBarPla = null;
    checkedBarPla = adoptioninformationret.getChkBarriersPlacement();
    for (int i = 0; i < checkedBarPla.length; i++) {
      checkedBarriersPlacement.add(checkedBarPla[i]);
    }
  }

  if(adoptioninformationret.getChkBarriersTPR() != null) {
    String[] checkedBarTPR = null;
    checkedBarTPR = adoptioninformationret.getChkBarriersTPR();
    for (int i = 0; i < checkedBarTPR.length; i++) {
      checkedBarriersTPR.add(checkedBarTPR[i]);
    }
  }
  
  //populate sibling group structures 
  if(adoptioninformationret.getSiblingGroupInformation() != null) {
    siblingGroupInformation = adoptioninformationret.getSiblingGroupInformation();
    siblingList = siblingGroupInformation.getAllSiblingsRetrievedSOList();
    siblingExternalLinkList = siblingGroupInformation.getSiblingExternalLinkStructList();

    //MR-092 getting principal children under 18 with open ADO stage in another case
    prnChildrenUnder18WithAnotherAdoCase = adoptioninformationret.getPrnChildrenUnder18WithAnotherAdoCase();

    hasSiblings = siblingList != null && siblingList.size() > 1;

    // MR-092 if primary child sibling group has saved sibling from another case OR if there are at least one principal child under 18
    // with no open FCC or ADO stage in the current case but has an open ADO in another case whom may POTENTIALLY be a sibling.
    hasSiblingExternal = (siblingExternalLinkList != null && siblingExternalLinkList
        .size() > 0) || prnChildrenUnder18WithAnotherAdoCase.size() > 0;

    siblingGroupings = siblingGroupInformation.getGroupings();
    siblingPlacementGroupList = siblingGroupInformation.getSiblingPlacementGroups();
    numOfNewSiblingGroups = siblingGroupInformation.getNumOfNewSiblingGroups();
    
	  if(siblingList != null){
	    numOfSiblings = siblingList.size();
	  }
	  
    //initialize total # of siblings available for adoption
    for (int i = 0; i < siblingList.size(); ++i) {
      SiblingSO siblingSO = (SiblingSO) siblingList.get(i);

      if(siblingSO.getIndAvailableToAdopt() == true) {
        //update # available for adoption    	totalAvailableForAdoption = totalAvailableForAdoption + 1;
      }
    }
  }

  request.setAttribute("cdEventStatus", cdEventStatus);
%>


<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"> </script>
<script language="Javascript1.2">

window.attachEvent("onload", toggleSiblingExternalQuestions);

function submitAdoptionResourceDetail(idResource, nmResource ){
  document.frmAdoptionInfo.hdnIdResource.value = idResource;
  document.frmAdoptionInfo.hdnNmResource.value = nmResource;
  document.frmAdoptionInfo.txtResourceName.value = nmResource;
  submitValidateForm( "frmAdoptionInfo", "/resource/ResourceSearch/results" );
  }
window.onbeforeunload = function ()
{
  IsDirty();
};

function stepIndicator(idres,nmres)
  {
   var field1 =eval("document.getElementById(\""+idres+"_Id\")");
   var field2 =eval("document.getElementById(\""+nmres+"_Id\")");
   var value1 = field1.value;
   var value2 = field2.value;
   document.frmAdoptionInfo.hdnIdResourcetoDelete.value = value1;
   document.frmAdoptionInfo.hdnNmResourcetoDelete.value = value2;
   
  }

	
	
function DeleteResource()
  {
    var cont;
      
    if( checkForSelection('document.frmAdoptionInfo.rbAdoptionIndex'))
    {
         cont = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>');
    }
    else
    {
         alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)%>');
         cont = false;
    }
    return cont;
  }
  function checkForSelection( objName )
  {
    var buttonChecked = false;
    var obj = eval(objName);

    if (obj != null)
    {
      if (obj.length == null)
      {
        if (obj.checked != false)
          buttonChecked = true;
      }
      else
      {
        for (var i = 0; i < obj.length; ++i)
        {
          buttonChecked = buttonChecked || obj[i].checked;
        }
      }
    }

  return (buttonChecked);
}   

function checkSave()
{	
  if (isPageChanged())  {
    alert('<%=MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEF_CONT )%>');
    return false;
  }
  disableValidation('frmAdoptionInfo');
  return true;
} 

function checkSaveBeforeAddingGroup()
{	
  if (isPageChanged())  {
    alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_SAVE_PAGE_B4_ADD_GROUP)%>');
    return false;
  }
  disableValidation('frmAdoptionInfo');
  return true;
} 

// Per STGAP000102095 modified the following method to accept one more parameter - nameChildPerson
function getExchChildPage(idChildEvent, idChildPerson, nameChildPerson)
{ 
  document.frmAdoptionInfo.hdnIdChildEventFromAdoInfo.value = "";
  document.frmAdoptionInfo.hdnIdChildPersonFromAdoInfo.value = "";
  document.frmAdoptionInfo.hdnNameChildPersonFromAdoInfo.value = "";
  
  document.frmAdoptionInfo.hdnIdChildEventFromAdoInfo.value = idChildEvent;
  document.frmAdoptionInfo.hdnIdChildPersonFromAdoInfo.value = idChildPerson;
  document.frmAdoptionInfo.hdnNameChildPersonFromAdoInfo.value = nameChildPerson;
  submitValidateForm( "frmAdoptionInfo", "/subcare/AdoptionInformation/displayChildDetail" );
}

//begin check all siblings
	function checkAllSiblingsPlaced(){
		var numOfChildren = <%=numOfSiblings%>;
		var numOfNewSiblingGroups = <%=numOfNewSiblingGroups%>;
		if(numOfChildren == 1){
			return true;//only one child in sibling group no need to specify placement
		}
		//checkForMultipleSiblingGroups();
		for(var s = 0; s < numOfChildren; ++s) {
			var siblingCbxName = 'cbx_sibling_'+s;
			var foundCheck = false;
			var newSiblingCbxName = 'cbx_New_PG_'+s;
			
  			for (i=0; i < document.frmAdoptionInfo.elements.length; i++)
			{
				var formElement = document.frmAdoptionInfo.elements(i);
				
				//is existing check box checked???
				if( formElement.name.substring(0,13) == siblingCbxName && formElement.checked){
					//alert('found check for -->'+formElement.name);
					foundCheck=true;
					break;
				}
				
				//is new checkbox checked???
				if(numOfNewSiblingGroups > 0) {
					if( formElement.name.substring(0,12) == newSiblingCbxName && formElement.checked){
						//alert('***NEW****found check for -->'+formElement.name);
						foundCheck=true;
						break;
					}
				}
			}
			
			if(foundCheck == false) {
				//alert('no checks were found for '+siblingCbxName);
				var answer = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CHLD_NO_SUB_GROUP)%>');
				if(answer) {
					return true;
				} else {
					return false;
				}	
			}
		}
		return true;		
	}
//end check all siblings

function toggleSiblingExternalQuestions()
{
  if(document.frmAdoptionInfo.rbHasSiblingExtCase){
    var bHasSiblingExtCase = getSelectedRadioValue(document.frmAdoptionInfo.rbHasSiblingExtCase);

    if(bHasSiblingExtCase != null && bHasSiblingExtCase != "Y"){
      resetCheckboxRadio(document.frmAdoptionInfo.rbSiblingGrpExtCase);
      disableCheckboxRadio(document.frmAdoptionInfo.rbSiblingGrpExtCase);
    }else{
      enableCheckboxRadio(document.frmAdoptionInfo.rbSiblingGrpExtCase);
    }

    var bSiblingGrpExtCase = getSelectedRadioValue(document.frmAdoptionInfo.rbSiblingGrpExtCase);
    if(bSiblingGrpExtCase != null && bSiblingGrpExtCase != "Y"){
        toggleVisibility("div_lblSiblingGrpExtCase", "none");
        toggleVisibility("div_selSiblingGrpExtCase", "none");
    }else{
        toggleVisibility("div_lblSiblingGrpExtCase", "block");
        toggleVisibility("div_selSiblingGrpExtCase", "block");
    }

<%
  int siblingOptionCtr = 0;
  for(Iterator<Option> optIter = siblingExtCaseOptionList.iterator(); optIter.hasNext();){
    Option option = optIter.next();
    if(option.getKey() != ""){
%>
    if(document.frmAdoptionInfo.selSiblingsExtCase_<%= siblingOptionCtr %> != undefined && document.frmAdoptionInfo.selSiblingsExtCase_<%= siblingOptionCtr %>.options != undefined){
      if (bSiblingGrpExtCase != null && bSiblingGrpExtCase != "Y" ){
        for(var i = 0; i < document.frmAdoptionInfo.selSiblingsExtCase_<%= siblingOptionCtr %>.options.length; i++){
        //clear and disable sibling dropdowns
          document.frmAdoptionInfo.selSiblingsExtCase_<%= siblingOptionCtr %>.options[i].selected = false;
        }
        document.frmAdoptionInfo.selSiblingsExtCase_<%= siblingOptionCtr %>.selectedIndex = 0;
        document.frmAdoptionInfo.selSiblingsExtCase_<%= siblingOptionCtr %>.disabled = true;
      }else{
        //enable sibling dropdowns
        document.frmAdoptionInfo.selSiblingsExtCase_<%= siblingOptionCtr %>.disabled = false;
      }
    }    
<%
      siblingOptionCtr++;
    }
  }
%>
  }
}
</script>

<impact:validateErrors />
<impact:validateForm name="frmAdoptionInfo"
	action="/subcare/AdoptionInformation/displayAdoption"
	pageMode="<%=editableMode%>" schema="/WEB-INF/Constraints.xsd"
	method="post" clientValidation="true"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.AdoptionInformationCustomValidation">


	<impact:validateInput type="hidden" name="hdnIdResource" />
	<impact:validateInput type="hidden" name="hdnNmResource" />
	<impact:validateInput type="hidden" name="txtResourceName" />


	<impact:validateInput type="hidden" name="hdnNmResourcetoDelete" />
	<impact:validateInput type="hidden" name="hdnIdResourcetoDelete" />
	<impact:validateInput type="hidden" name="hdnReqPullBack" value="" />

	<impact:validateInput type="hidden" name="hdnResourceId" value="<%=FormattingHelper.formatInt(hdnResourceId)%>" />

	<impact:validateInput type="hidden" name="hdnIdChildEventFromAdoInfo" />
	<impact:validateInput type="hidden" name="hdnIdChildPersonFromAdoInfo" />
	<impact:validateInput type="hidden" name="hdnNameChildPersonFromAdoInfo" />

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
				<a tabindex="<%=tabIndex++%>" href="#" onClick="expandAll()">Expand	All</a>&nbsp;
				<a tabindex="<%=tabIndex++%>" href="#" onClick="collapseAll()">Collapse	All</a>&nbsp;
			</td>
		</tr>
	</table>
	<br>
	<%
	  if((siblingList != null && siblingList.size() != 0) || hasSiblingExternal) {
	%>
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th colspan="4">
				Sibling Group Information
			</th>
		</tr>
		<tr>
			<td>
				<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="E2E1C3">
					<tr>
						<td>
							<div class="alignRight">
								<div>
									# available for adoption: <%=totalAvailableForAdoption%>
								</div>
							</div>
							<div class="alignRight">
								<div class="formInstruct">
									Scroll for more information --&gt;
								</div>
							</div>

							<%
							  if(hasSiblings) {
							%>
							<div id="scrollBar2"
								style="height: 210px; width: 763px; overflow: auto"
								class="tableborderList">
								<%
								  } else {
								%>
								<div id="scrollBar2"
									style="height: 100px; width: 763px; overflow: auto"
									class="tableborderList">

									<%
									  }
									%>
									<table width="1500" cellspacing="0" cellpadding="3" border="0">



										<tr>
								      <th class="locked" width="200">Name</th>
								      <th class="locked" width="200">Legal status</th>
								      <th class="locked" width="100">Non-Avail Status</th>
											<%
											  for (int i = 0; i < siblingPlacementGroupList.size(); ++i) {
											        //create columns for sibling placementt groups
											        SiblingPlacementGroupSO sg = (SiblingPlacementGroupSO) siblingPlacementGroupList.get(i);
											%>
											<th class="thList">Placement Group:&nbsp;<%=FormattingHelper.formatInt(sg.getIdSiblingGroup())%></th>
											<%
											  }
											      //create columns for new sibling groups if they exist.
											      //if(newSiblingPlacementGroupList != null){
											      for (int i = 0; i < numOfNewSiblingGroups; ++i) {
											        //create columns for sibling placementt groups
											        //SiblingPlacementGroupSO sg = (SiblingPlacementGroupSO)newSiblingPlacementGroupList.get(i);
											%>
		                  <th class="thList">Placement Group:&nbsp;<%="New ("+i+")"%></th>
											<%
											  }
											      //	}
											%>

                      <th class="thList">&nbsp;</th>
										</tr>
										<%
										  loopCount = 1;
										      for (int i = 0; i < siblingList.size(); ++i) {
										        SiblingSO sibling = (SiblingSO) siblingList.get(i);
										        int idPerson = sibling.getIdPerson();

    	                      String legalActionList = (sibling.getLegalActionsList().length()==0) ? "&nbsp;": sibling.getLegalActionsList();
										%>
                    <tr class="<%=FormattingHelper.getRowCss(loopCount++)%>" valign="top">

											<%
	  	                      if(sibling.getIdChildRegEvent() == 0 || user.hasRight(UserProfile.SEC_SAU_EXCHANGE) == false) {
											%>
											<td class="locked" width="200">
	  		                 <impact:validateDisplayOnlyField name="<%="sibName_"+ idPerson%>" label="" value="<%=sibling.getChildName()%>"/>
											</td>
											<%
											  } else {
											%>
											<td class="locked" width="200">
	  			              <a href="javascript:getExchChildPage('<%=sibling.getIdChildRegEvent()%>', '<%=sibling.getIdPerson()%>','<%=sibling.getChildName()%>' )" 
													onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++%>">
				                  <%=sibling.getChildName()%>
		                    </a>
											</td>
											<%
											  }
											%>

											<td class="locked" width="200">
												<table border="0" cellspacing="0" cellpadding="0">
													<%
													  StringTokenizer st = new StringTokenizer(legalActionList, ";");
													        while (st.hasMoreTokens()) {
													%>
													<tr>
														<td>
															<%=st.nextToken()%>
														</td>
													</tr>
													<%
													  }
													%>
												</table>
											</td>
	                    <td class="locked" width="100"><%=(sibling.getNonAvailStatus()!= null)? Lookup.simpleDecodeSafe("CANONAV", sibling.getNonAvailStatus()): "N/A"%></td>
											<%
											  for (int p = 0; p < siblingPlacementGroupList.size(); ++p) {
                          SiblingPlacementGroupSO sg = (SiblingPlacementGroupSO)siblingPlacementGroupList.get(p);
											%>
											<td>
												<%
												  boolean checked = false;
												          Integer personIdInteger = new Integer(idPerson);

												          if(siblingGroupings.get(sibling) != null) {
                      		SiblingPlacementGroupSO selectedPlacementGroup = (SiblingPlacementGroupSO)siblingGroupings.get(sibling);	
                      		if(sg.getIdSiblingGroup() == selectedPlacementGroup.getIdSiblingGroup()){
												              checked = true;
												            }
												          }
												%>
                        <impact:validateInput type="checkbox" label="" tabIndex="<%=tabIndex++%>" 
													checked="<%=(checked) ? "true" : "false"%>"
													name="<%="cbx_sibling_" + i + "_" + sg.getIdSiblingGroup()%>"
													noCheckboxChange="true"
													value="<%="_"+sg.getIdSiblingGroup() + "_"+sibling.getIdPerson()%>"
													cssClass="formInput" />
											</td>
											<%
											  }
											%>

											<%
											  for (int p = 0; p < numOfNewSiblingGroups; ++p) {
											%>
											<td>
                        <impact:validateInput type="checkbox" label="" noCheckboxChange="true" tabIndex="<%=tabIndex++%>" 
          	              name="<%="cbx_New_PG_" + i + "_"+ p%>" value="<%="_"+ p + "_"+sibling.getIdPerson()%>"  
													cssClass="formInput" />
											</td>
											<%
											  }
											%>

										</tr>
										<%
										  }
										%>
									</table>

								</div>
						</td>
					</tr>
				</table>

				<table border="0" cellpadding="3" cellspacing="0" width="100%">
					<tr>
						<th colspan="6">
							<%
							  if(hasSiblings) {
							%>
							<table width="100%" cellpadding="3" cellspacing="0">
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
									<td align="right">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<impact:ButtonTag form="frmAdoptionInfo" img="btnAddGroup"
											name="btnAddSiblingGroup"
											action="/subcare/AdoptionInformation/addSiblingGroup"
											preventDoubleClick="true"
											function="return checkSaveBeforeAddingGroup();"
											tabIndex="<%=tabIndex++%>" />

									</td>
								</tr>
							</table>
							<%
							  }
							%>
						</th>
					</tr>
					<tr>
						<td colspan="2">
							<table border="0" cellpadding="3" cellspacing="0" width="100%"
								class="tableBorder" bgcolor="white">
								<tr class="odd">
									<td>
										<span class="formRequiredText">*</span><impact:validateDisplayOnlyField name="lblHasSiblingExtCase"
                      label="Does this child have any sibling(s) in a different case with an open ADO?" />
									</td>
									<td>
										<impact:validateInput type="radio" label="Yes"
											id="rbHasSiblingExtCase_Yes" name="rbHasSiblingExtCase"
											value="Y" cssClass="formInput"
											onClick="toggleSiblingExternalQuestions();"
											checked="<%= String.valueOf(ArchitectureConstants.Y.equals(adoptioninformationret.getIndHasSiblingExtCase())) %>"
											tabIndex="<%= tabIndex++ %>" />
										<impact:validateInput type="radio" label="No"
											id="rbHasSiblingExtCase_No" name="rbHasSiblingExtCase"
											value="N" cssClass="formInput"
                      onClick="toggleSiblingExternalQuestions();"
											checked="<%= String.valueOf(ArchitectureConstants.N.equals(adoptioninformationret.getIndHasSiblingExtCase())) %>"
											tabIndex="<%= tabIndex++ %>" />
									</td>
								</tr>
								<tr class="odd">
									<td>
										<impact:validateDisplayOnlyField conditionallyRequired="true"
											name="lblSiblingGrpExtCase"
											label="If yes, is the plan for these siblings to be placed in the same adoptive home?" />
									</td>
									<td>
										<impact:validateInput type="radio" label="Yes"
											id="rbSiblingGrpExtCase_Yes" name="rbSiblingGrpExtCase"
											value="Y" cssClass="formInput"
                      onClick="toggleSiblingExternalQuestions();"
											checked="<%= String.valueOf(ArchitectureConstants.Y.equals(adoptioninformationret.getIndSiblingGrpExtCase())) %>"
											tabIndex="<%= tabIndex++ %>" />
										<impact:validateInput type="radio" label="No"
											id="rbSiblingGrpExtCase_No" name="rbSiblingGrpExtCase"
											value="N" cssClass="formInput"
                      onClick="toggleSiblingExternalQuestions();"
											checked="<%= String.valueOf(ArchitectureConstants.N.equals(adoptioninformationret.getIndSiblingGrpExtCase())) %>"
											tabIndex="<%= tabIndex++ %>" />
									</td>
								</tr>
								<tr class="odd">
                  <td colspan="2">
                  <div id="div_lblSiblingGrpExtCase">
                    <impact:validateDisplayOnlyField conditionallyRequired="true"
                      name="lblSiblingGrpExtCase"
                      label="Select sibling(s) to be placed in same Placement Group as the Primary Child" />
                  </div>
                  </td>
                </tr>
                <tr class="odd">
                  <td colspan="2">
                  <div id="div_selSiblingGrpExtCase">
<%
                // get list of the previously saved sibling with open ADO in another case
                List<String> siblingExtLnkPersonIdList = new ArrayList<String>();
                Iterator<SiblingExternalLinkStruct> selIter = siblingExternalLinkList.iterator();
                while(selIter.hasNext()){
                  SiblingExternalLinkStruct sel = selIter.next();
                  siblingExtLnkPersonIdList.add(String.valueOf(sel.getIdPerson()));
                }
                
                int i = 0;
                
                for(Iterator<Option> optIter = siblingExtCaseOptionList.iterator(); optIter.hasNext();){
                  String selName = "selSiblingsExtCase_" + i;
                  Option option = optIter.next();
                  if(StringHelper.isNotEmptyOrNull(option.getKey()) && option.getKey() != "0"){
                    String optRequest = ContextHelper.getStringSafe(request, selName);

                    // no value from request then set to value if one of the previously saved sibling
                    if(StringHelper.isEmptyOrNull(optRequest) && siblingExtLnkPersonIdList.contains(option.getKey())){
%>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <impact:validateSelect style="WIDTH: 160px"
                      name="<%= selName %>"
                      blankValue="false"
                      value="<%= option.getKey() %>"
                      tabIndex="<%=tabIndex++%>" 
                      options="<%= siblingExtCaseOptionList %>" />
                    <br>
<%
                    }else{
%>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <impact:validateSelect style="WIDTH: 160px"
                      name="<%= selName %>"
                      blankValue="false"
                      value="<%= optRequest %>"
                      tabIndex="<%=tabIndex++%>" 
                      options="<%= siblingExtCaseOptionList %>" />
                    <br>
<%
                    }
                    i++;
                  }
                }
%>											
                  </div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<%
	  }
	%>

	<br>
	<impact:ExpandableSectionTag name="ResourceIdentificationSection"
		label="Identified Resources" tabIndex="<%=tabIndex++%>">
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">
			<tr>
				<td colspan="2">
					<impact:validateInput type="checkbox"
						label="Child Has An Identified Adoptive Resource"
						tabIndex="<%=tabIndex++%>"
						checked="<%=(("".equals(indIdentifiedAdopRes)) || (ArchitectureConstants.N.equals(indIdentifiedAdopRes))) ? "false" : "true"%>"
						value="Y" name="indIdentifiedAdopRes" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td valign="top" colspan="1">
					Child is linked:
				</td>
				<td colspan="2">
					<impact:validateTextArea name="szCdChildLinked" cols="92" rows="3"
						maxLength="300" constraint="Comments" tabIndex="<%=tabIndex++%>">
						<%=szCdChildLinked%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDisplayOnlyField name="txtSzNmAdpRes"
						label="Adoptive Resource Name" value="<%=txtSzNmAdpRes%>"
						conditionallyRequired="false" cssClass="formInput" />

					<span style="vertical-align: right;"><impact:ButtonTag
							name="btnSelectResourceIdResource" img="btnSelectResource"
							form="frmAdoptionInfo" function="return checkSave();"
							action="/subcare/AdoptionInformation/retrieveAdoResource"
							tabIndex="<%=tabIndex++%>" /> </span>
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDisplayOnlyField name="txtSzHomeType"
						label="Home Type"
						value="<%=FormattingHelper.initCaps(Lookup.simpleDecodeSafe(CodesTables.CFACATEG, txtSzHomeType))%>"
						conditionallyRequired="false" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDisplayOnlyField name="txtSzCounty" label="County"
						codesTable="CCOUNT"
						value="<%=StringHelper.getNonNullString(txtSzCounty)%>"
						conditionallyRequired="false" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDisplayOnlyField name="txtSzNmPrAgency"
						label="Private Agency Name" value="<%=txtSzNmPrAgency%>"
						conditionallyRequired="false" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDisplayOnlyField name="txtSzICPCState"
						label="ICPC State" value="<%=txtSzICPCState%>"
						conditionallyRequired="false" cssClass="formInput" />
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<br>
	<impact:ExpandableSectionTag name="FamiliesConsideredSection"
		label="Families Considered - Adoption Exchange Referral"
		tabIndex="<%=tabIndex++%>">
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">

			<tr>
				<td valign="top">
					Comments:
				</td>

				<td colspan="2">
					<div style="width: 100%; height: 50px; overflow: auto;"><%=szCdExchConsidered%></div>
				</td>
			</tr>
		</table>

		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">

			<tr>
				<th class="thList">
					Date Considered
				</th>
				<th class="thList">
					Resource ID
				</th>
				<th class="thList">
					Name
				</th>
				<th class="thList" colspan="2">
					Non-Selection Reason
				</th>

				<th class="thList">
					&nbsp;
				</th>
				<th class="thList">
					&nbsp;
				</th>
			</tr>
			<%
			  if(childFamilyLinkList == null || childFamilyLinkList.isEmpty()) {
			          //NO Rows rEturned.
			%>
			<tr class="odd">
				<td colspan="5">
					<%=MessageLookup
                  .getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
				</td>
			</tr>

			<%
			  } else {
			          loopCount = 1;
			          for (int i = 0; i < childFamilyLinkList.size(); ++i) {
			            ExchangeChildFamilyLinkBean childFamilyLink = (ExchangeChildFamilyLinkBean) childFamilyLinkList
			                .get(i);
			%>
			<tr class="<%=FormattingHelper.getRowCss(loopCount++)%>" valign="top">

				<td><%=childFamilyLink.getDtOut()%>&nbsp;
				</td>
				<td><%=childFamilyLink.getIdResource()%>&nbsp;
				</td>
				<td><%=childFamilyLink.getResourceName()%></td>

				<td><%=(childFamilyLink.getCdNonSelectionReason() != null) ? Lookup
                    .simpleDecodeSafe("CADNSLCT",
                        childFamilyLink.getCdNonSelectionReason()) : ""%></td>
			</tr>

			<%
			  }
			        }
			%>
		</table>
	</impact:ExpandableSectionTag>

	<br>

	<impact:ExpandableSectionTag name="adoptivefam"
		label="County/Regional Considered Families" tabIndex="<%=tabIndex++%>">
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">
			<tr>
				<td valign="top" colspan="1">
					<impact:validateInput type="text" name="nmFamConsidered"
						label="Number of Families Considered" cssClass="formInput"
						size="5" maxLength="5" tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatInt(nmFamConsidered)%>" />
				</td>
			</tr>

			<tr>
				<td valign="top" colspan="1">
					Comments:
				</td>
				<td colspan="2">
					<impact:validateTextArea name="szCdCountyConsideredComments"
						cols="92" rows="3" maxLength="2000" constraint="Paragraph2000"
						tabIndex="<%=tabIndex++%>">
						<%=szCdCountyConsideredComments%>
					</impact:validateTextArea>
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<impact:validateInput type="checkbox"
						label="An Out of Town Inquiry Home Study Has Been requested"
						tabIndex="<%=tabIndex++%>"
						checked="<%=(("".equals(indOutofTown)) || (ArchitectureConstants.N.equals(indOutofTown))) ? "false" : "true"%>"
						value="Y" name="indOutofTown" cssClass="formInput" />
				</td>

			</tr>
		</table>
	</impact:ExpandableSectionTag>


	<br>

	<impact:ExpandableSectionTag name="PreperationActivitiesSection"
		label="Preparation Activities" tabIndex="<%=tabIndex++%>">
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">
			<tr>
				<td colspan="2">
					<impact:castorCheckbox
						castorEnum="<%=Collections.enumeration(preparationactsList)%>"
						name="chkPreperationActivities" labelPropertyName="Code"
						valuePropertyName="Decode"
						checkedValues="<%=checkedPreperationActivities%>" columns="2"
						isRuled="false" isHorizontal="false" tabIndex="<%=tabIndex++%>"
						onClick="" />
				</td>
			</tr>
			<tr>
				<td valign="top" colspan="1">
					Comments:
				</td>
				<td colspan="2">
					<impact:validateTextArea name="szCdComntsPrepAct" cols="92"
						rows="3" maxLength="300" constraint="Comments"
						tabIndex="<%=tabIndex++%>">
						<%=szCdComntsPrepAct%>
					</impact:validateTextArea>

				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>

	<br>

	<impact:ExpandableSectionTag name="BarriersRecruitmentSection"
		label="Barriers to Recruitment" tabIndex="<%=tabIndex++%>">
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">
			<tr>
				<td colspan="2">
					<impact:castorCheckbox
						castorEnum="<%=Collections.enumeration(barrtorecrmntList)%>"
						name="chkBarriersRecruitment" labelPropertyName="Code"
						valuePropertyName="Decode"
						checkedValues="<%=checkedBarriersRecruitment%>" columns="2"
						isRuled="false" isHorizontal="false" tabIndex="<%=tabIndex++%>"
						onClick="" />
				</td>
			</tr>
			<tr>
				<td valign="top" colspan="1">
					Comments:
				</td>
				<td colspan="2">
					<impact:validateTextArea name="szCdComntsBarRec" cols="92" rows="3"
						maxLength="300" constraint="Comments" tabIndex="<%=tabIndex++%>">
						<%=szCdComntsBarRec%>
					</impact:validateTextArea>

				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>

	<br>

	<impact:ExpandableSectionTag name="RecruitmentActsSection"
		label="Recruitment Activities" tabIndex="<%=tabIndex++%>">
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">
			<tr>
				<td valign="top" colspan="1">
					State
					<table cellpadding="3" cellspacing="0" width="100%"
						class="tableBorder" bgcolor="white">
						<tr>
							<td width="46%" colspan="2">
								Actively Recruiting?
								<impact:validateInput type="radio" cssClass="formInput"
									id="rbStateActRecruiting_Yes" name="rbStateActRecruiting"
									label="Yes" value="Y" disabled="true"
									tabIndex="<%=tabIndex++%>"
									checked="<%=String.valueOf(CodesTables.CYESNONA_Y.equals(szCdStateActivelyRecruiting))%>" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<impact:validateInput type="radio" cssClass="formInput"
									id="rbStateActRecruiting_No" name="rbStateActRecruiting"
									label="No" value="N" disabled="true" tabIndex="<%=tabIndex++%>"
									checked="<%=String.valueOf(CodesTables.CYESNONA_N.equals(szCdStateActivelyRecruiting))%>" />
								<impact:validateInput type="radio" cssClass="formInput"
									id="rbStateActRecruiting_NA" name="rbStateActRecruiting"
									label="N/A" value="A" disabled="true"
									tabIndex="<%=tabIndex++%>"
									checked="<%=String.valueOf(CodesTables.CYESNONA_A.equals(szCdStateActivelyRecruiting) || StringHelper.isEmptyOrNull(szCdStateActivelyRecruiting))%>" />
							</td>
							<td colspan="5"></td>
						</tr>
						<%
						  int iLoopCounter = 0;

						        for (int i = 0; i < recactsstateList.size(); ++i) {
						          CodeAttributes att = (CodeAttributes) recactsstateList.get(i);

						          List<Date> datesToDisplay = savedRecActivitiesDatesState.get(att
						              .getCode());

						          int sizeOfDateList = 0;

						          if(datesToDisplay != null) {
						            sizeOfDateList = datesToDisplay.size();
						          }
						%>

						<tr class="<%=FormattingHelper.getRowCss(iLoopCounter)%>">
							<td align="left" width="46%">
								<impact:validateDisplayOnlyField label="<%=att.getDecode()%>"
									name="<%=att.getDecode()%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date0"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 0) ) ? FormattingHelper.formatDate((Date)datesToDisplay.get(0)): ""%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date1"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 1) ) ? FormattingHelper.formatDate((Date)datesToDisplay.get(1)): ""%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date2"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 2)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(2)): ""%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date3"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 3)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(3)): ""%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date4"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 4)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(4)): ""%>" />
							</td>

						</tr>
						<tr class="<%=FormattingHelper.getRowCss(iLoopCounter++)%>">
							<td colspan="2"></td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date5"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 5) ) ? FormattingHelper.formatDate((Date)datesToDisplay.get(5)): ""%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date6"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 6) ) ? FormattingHelper.formatDate((Date)datesToDisplay.get(6)): ""%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date7"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 7)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(7)): ""%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date8"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 8)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(8)): ""%>" />
							</td>
							<td>
								<impact:validateInput type="text"
									name="<%=att.getCode() + "Date9"%>" cssClass="formInput"
									maxLength="7" size="8" disabled="true"
									value="<%=((sizeOfDateList > 9)) ? FormattingHelper.formatDate((Date)datesToDisplay.get(9)): ""%>" />
							</td>

						</tr>
						<%
						  }
						%>

					</table>

					<table cellpadding="3" cellspacing="0" width="100%"
						class="tableBorder" bgcolor="white">
						<tr>
							<td valign="top" colspan="1">
								Comments:
							</td>
							<td colspan="2">
								<div style="width: 100%; height: 50px; overflow: auto;"><%=szCdComntsRecActsState%></div>
							</td>
						</tr>
					</table>
				</td>
			</tr>

		</table>

		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">
			<tr>
				<td valign="top" colspan="1">
					County
					<table cellpadding="3" cellspacing="0" width="100%"
						class="tableBorder" bgcolor="white">
						<%
						  iLoopCounter = 0;

						        for (int i = 0; i < activityCodesList.size(); ++i) {
						          CodeAttributes att = (CodeAttributes) activityCodesList.get(i);

						          List<AdoInfoCbxSentStruct> recActDatesToDisplay = null;

						          if(savedRecActivitiesDatesCounty != null) {
						            recActDatesToDisplay = savedRecActivitiesDatesCounty.get(att
						                .getCode());
						          }

						          int sizeOfDateList = 0;

						          if(recActDatesToDisplay != null) {
						            sizeOfDateList = recActDatesToDisplay.size();
						          }
						%>
						<tr class="<%=FormattingHelper.getRowCss(iLoopCounter)%>">
							<td width="25%" colspan="2">
								<impact:validateDate label="<%=att.getDecode()%>" size="10"
									value="" tabIndex="<%=tabIndex++%>"
									name="<%="dtRecActCounty" + att.getCode()%>"
									tabIndex="<%=tabIndex++%>" cssClass="formInput"
									constraint="Date" />
							</td>
							<td>

								<impact:validateInput constraint="Date" type="text"
									name="<%="Date0_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 0)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(0).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date0_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 0)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(0).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>
							<td>
								<impact:validateInput constraint="Date" type="text"
									name="<%="Date1_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 1)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(1).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date1_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 1)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(1).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>
							<td>
								<impact:validateInput constraint="Date" type="text"
									name="<%="Date2_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 2)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(2).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date2_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 2)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(2).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>
							<td>
								<impact:validateInput constraint="Date" type="text"
									name="<%="Date3_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 3)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(3).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date3_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 3)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(3).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>
							<td>
								<impact:validateInput constraint="Date" type="text"
									name="<%="Date4_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 4)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(4).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date4_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 4)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(4).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>

						</tr>
						<tr class="<%=FormattingHelper.getRowCss(iLoopCounter++)%>">
							<td colspan="3"></td>
							<td>

								<impact:validateInput constraint="Date" type="text"
									name="<%="Date5_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 5)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(5).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date5_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 5)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(5).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>
							<td>
								<impact:validateInput constraint="Date" type="text"
									name="<%="Date6_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 6)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(6).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date6_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 6)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(6).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>
							<td>
								<impact:validateInput constraint="Date" type="text"
									name="<%="Date7_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 7)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(7).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date7_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 7)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(7).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>
							<td>
								<impact:validateInput constraint="Date" type="text"
									name="<%="Date8_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 8)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(8).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date8_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 8)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(8).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>
							<td>
								<impact:validateInput constraint="Date" type="text"
									name="<%="Date9_dtRecActCounty" + att.getCode()%>"
									cssClass="formInput" size="8"
									value="<%=((sizeOfDateList > 9)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(9).getDtAdoInfoCbxSent()) : ""%>"
									tabIndex="<%=tabIndex++%>" />
								<impact:validateInput type="hidden"
									name="<%="Date9_idAdoInfoCbxSent" + att.getCode()%>"
									value="<%= ((sizeOfDateList > 9)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(9).getIdAdoInfoCbxSent()) : "0"%>" />
							</td>

						</tr>
						<%
						  }
						%>
					</table>
					<table cellpadding="3" cellspacing="0" width="100%"
						class="tableBorder" bgcolor="white">
						<tr>
							<td valign="top" colspan="1">
								Comments:
							</td>
							<td colspan="2">
								<impact:validateTextArea name="szCdComntsRecActsCounty"
									cols="92" rows="3" maxLength="1000" constraint="Paragraph1000"
									tabIndex="<%=tabIndex++%>">
									<%=szCdComntsRecActsCounty%>
								</impact:validateTextArea>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>

	<br>

	<impact:ExpandableSectionTag name="BarriersPlacementSection"
		label="Barriers to Placement" tabIndex="<%= tabIndex++ %>">
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">
			<tr>
				<td colspan="2">
					<impact:castorCheckbox
						castorEnum="<%= Collections.enumeration(barrtoplacmntList) %>"
						name="chkBarriersPlacement" labelPropertyName="Code"
						valuePropertyName="Decode"
						checkedValues="<%= checkedBarriersPlacement%>" columns="2"
						isRuled="false" isHorizontal="false" tabIndex="<%= tabIndex++ %>"
						onClick="" />
				</td>
			<tr>
				<td valign="top" colspan="1">
					Comments:
				</td>
				<td colspan="2">
					<impact:validateTextArea name="szCdComntsBarPla" cols="92" rows="3"
						maxLength="300" constraint="Comments" tabIndex="<%=tabIndex++%>">
						<%=szCdComntsBarPla%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>

	<br>
	<impact:ExpandableSectionTag name="BarriersTPRSection"
		label="Barriers to TPR" tabIndex="<%= tabIndex++ %>">
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorder" bgcolor="white">
			<tr>
				<td colspan="2">
					<impact:castorCheckbox
						castorEnum="<%= Collections.enumeration(barrtotprList) %>"
						name="chkBarriersTPR" labelPropertyName="Code"
						valuePropertyName="Decode"
						checkedValues="<%= checkedBarriersTPR%>" columns="2"
						isRuled="false" isHorizontal="false" tabIndex="<%= tabIndex++ %>"
						onClick="" />
				</td>
			<tr>
				<td valign="top" colspan="1">
					Comments:
				</td>
				<td colspan="2">
					<impact:validateTextArea name="szCdComntsBarTpr" cols="92" rows="3"
						maxLength="300" constraint="Comments" tabIndex="<%=tabIndex++%>">
						<%=szCdComntsBarTpr%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<br>

	<table border="0" cellpadding="0" cellspacing="0" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="4">
				Adoption Information
			</th>
		</tr>

		<table border="0" cellpadding="0" cellspacing="0" width="100%"
			class="tableBorder">
			<tr>
				<td>
					<impact:validateDate
						label="Foster Parents Notified of Agency intent to TPR"
						type="text" size="10" value="<%= dtFostParNotAgTPR%>"
						name="dtFostParNotAgTPR" tabIndex="<%= tabIndex++ %>"
						cssClass="formInput" constraint="Date" />
				</td>
				<td>
					<impact:validateDate
						label="Permanency Staffing with Foster Parents" type="text"
						size="10" value="<%= dtPermStaffFostPar%>"
						name="dtPermStaffFostPar" tabIndex="<%= tabIndex++ %>"
						cssClass="formInput" constraint="Date" />
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDate
						label="Foster Parents Notified Agency of Decision to Adopt"
						type="text" size="10" value="<%= dtFostParNotAgDecAdpt%>"
						name="dtFostParNotAgDecAdpt" tabIndex="<%= tabIndex++ %>"
						cssClass="formInput" constraint="Date" />

				</td>
				<td>
					Decision Outcome:
					<impact:validateInput type="radio" id="rbAdoptYes"
						tabIndex="<%= tabIndex++ %>" name="indAdoptOutcome" label="Yes"
						value="Y"
						checked="<%= (("".equals(indAdoptOutcome)) || (ArchitectureConstants.N.equals(indAdoptOutcome))) ? "false" : "true" %>" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<impact:validateInput type="radio" id="rbAdoptNo"
						tabIndex="<%= tabIndex++ %>" name="indAdoptOutcome" label="No"
						value="N"
						checked="<%= (("".equals(indAdoptOutcome)) || (ArchitectureConstants.Y.equals(indAdoptOutcome))) ? "false" : "true" %>" />
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDate label="Selection Letter Sent" type="text"
						size="10" value="<%= dtSelectionLetterSent %>"
						name="dtSelectionLetterSent" tabIndex="<%= tabIndex++ %>"
						cssClass="formInput" constraint="Date" />
				</td>
				<td>
					<impact:validateDate label="Child Life History Presentation"
						type="text" size="10" value="<%= dtChildLifeHistPres%>"
						name="dtChildLifeHistPres" tabIndex="<%= tabIndex++ %>"
						cssClass="formInput" constraint="Date" />
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDate label="Staffing with Adoptive Family"
						type="text" size="10" value="<%= dtStaffAdptFam%>"
						name="dtStaffAdptFam" tabIndex="<%= tabIndex++ %>"
						cssClass="formInput" constraint="Date" />
				</td>
				<td>
					<impact:validateDate label="Adoptive Placement Agreement Signed"
						type="text" size="10" value="<%= dtAdptPlacAgmtSigned%>"
						name="dtAdptPlacAgmtSigned" tabIndex="<%= tabIndex++ %>"
						cssClass="formInput" constraint="Date" />
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDate label="Permission to File" type="text"
						size="10" value="<%= dtPermFileLetterComp%>"
						name="dtPermFileLetterComp" tabIndex="<%= tabIndex++ %>"
						cssClass="formInput" constraint="Date" />
				</td>
				<td>
					<impact:validateDate label="Documents Sent" type="text" size="10"
						value="<%= dtDocSentAttor%>" name="dtDocSentAttor"
						tabIndex="<%= tabIndex++ %>" cssClass="formInput"
						constraint="Date" />
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateDisplayOnlyField label="Disruption Date"
						name="dtDisruption" value="<%=dtDisruption%>" />
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
	</table>

	<br>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td align="right">
				<impact:ButtonTag name="btnComplete" img="btnCompleteQ"
					form="frmAdoptionInfo"
					action="/subcare/AdoptionInformation/saveAdoption"
					preventDoubleClick="true" restrictRepost="true" disabled="false"
					function="return checkAllSiblingsPlaced();"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<td align="right">
				<impact:ButtonTag name="btnSave" img="btnSave"
					form="frmAdoptionInfo"
					action="/subcare/AdoptionInformation/saveAdoption"
					preventDoubleClick="true" restrictRepost="true" disabled="false"
					function="return checkAllSiblingsPlaced();"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<impact:validateInput type="hidden" name="numOfResources"
		value="<%= String.valueOf(beanSize) %>" />
	<impact:validateInput type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>