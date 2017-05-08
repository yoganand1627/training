
<%
  /**
   * JSP Name:     Contact Detail
   * Created by:   Todd Reser (Split out by Matt McClain)
   * Date Created: 10/06/03
   *
   * Description:
   * This page displays the Detail version of the Contact page.
   *
   * Change History:
   * Date      User              Description
   * --------  ----------------  -----------------------------------------------
   * 10/06/03  Matt McClain      Reformatted new version split into 4 files.
   * 10/27/03  Todd Reser        SIR 22336 - Moved and include inside of a table to
   *                             remove a cell row border that shouldn't have been
   *                             visible between "Contact Date" and "Purpose".
   * 11/03/03  Todd Reser        Updated Comments.
   * 05/12/04  Todd Reser        SIR 22860.  Get hdnIntakeDate from CaseUtility
   *                             because csys08so.getDtDtIntStart() is always null.
   * 07/22/04  Todd Reser        CSYS08S now returns the correct intake start date.
   * 02/28/05  Hari Maralla      SIR 23410. Two new Contract Type added (CLES and CLEV).
   * 06/16/05  Mike Ochu         SIR 23686 - For APS cases, Monthly  Status APS,
   *                             Face to Face Contacts and 24 Hour Contacts,
   *                             display the Narrative push button if there is already
   *                             a narrative existing or stage type is C-REG or C-GUA.
   *                             Otherwise, the Narrative push button will not display.
   * 07/05/05  berkime           SIR 23298 Added CAGR as a contact type
   * 07/24/05  cooganpj          SIR 23728 - Hide Narrative button in MPS for  contacts that
   *                             cannot be modified in MPS.
   * 09/20/05  mkw               Phase III -- Enhancements for Facility and APS:
   *                             SIRs 23968, 23949, and 23950.
   * 09/25/08  arege             While testing for STGAP00006397 found that on Clicking
   *                             Save multiple times created duplicate Contact records, Added 
   *                             preventDoubleClick="true" to btnSave tag.
   * 03/12/09  arege             STGAP00011640 Added hidden variable to set time, 
   *                             this time is then compared with contact time in CustomValidation
   * 06/11/09  cwells            STGAP00013826 Allowing the user to add Contact forms to closed cases
   * 06/19/09  arege             STGAP00014326 MR-024 Changes, removed function call from btnSave
   * 07/09/09  arege             STGAP00014327 MR-024 Changes 
   * 07/30/09  arege             STGAP00014857 CaseWorkers with SAU Sealed Attribute should be able to add and modify
   *                             contacts
   * 09/07/09  arege             STGAP00015300 Added labels and conditionally required sign to Contacted By radio buttons. 
   * 09/13/09  arege             STGAP00015300 Modified code so that the Contacted By radio buttons and their respective 
   *                             text boxes and their labels are aligned correctly even when the page is view only.
   * 09/29/09  arege             STGAP00015281 Narrative is not being deleted with change of Narrative Type.
   *                                 
   */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>


<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Time"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>


<%
  {
    int tabIndex = 1;

    String szCdStage = GlobalData.getSzCdStage(request);

    BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                     .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    CSYS08SO csys08so = (CSYS08SO) state.getAttribute("CSYS08SO", request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }

    String pageMode = PageMode.getPageMode(request);

    String selSzCdContactType = ContactSearchListDetailConversation.getSelSzCdContactType(request);

    //ADDED FOR MOBILITY
    String szCdPopulatedFrom = FormattingHelper.formatString(csys08so.getSzCdPopulatedFrom());
    String hdnAddMode = FormattingHelper.formatString((String) state.getAttribute("hdnAddMode", request));

    // SIR 22860 - The csys08SO object now returns the right Intake Start Date
    String hdnIntakeDate = FormattingHelper.formatDate(csys08so.getDtDtIntStart());
    // STGAP00011640 Will pass time also , ealier hdnIntakeDate was passing only
    //               the date.
    String hdnIntakeTime = FormattingHelper.formatTime(csys08so.getDtDtIntStart());
    //STGAP00007854 - never show the approval status button
    boolean approvalStatus = false;
    //if( PlatformConstants.SERVER_IMPACT &&
    //    CaseUtility.hasBeenSubmittedForApproval( GlobalData.getUlIdEvent( request ) ) )
    //{
    //  approvalStatus = true;
    //}

    String tsLastUpdate = FormattingHelper.formatDate(csys08so.getTsLastUpdate());
    String txtDtDtContactOccurred = FormattingHelper.formatDate(csys08so.getDtDTContactOccurred());
    //SIR 22389: reinserted from version 1.117
    // The user requested the contact date be null when the user enters the detail page for the first time.
    // We check to see if there is an event id and ALSO if we are coming from the Staff Search page.
    //if ((GlobalData.getUlIdEvent(request) == 0) && (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) == null)) {
    //  txtDtDtContactOccurred = "";
    //}

    TmScrTmCntct_ARRAY timeArray = csys08so.getTmScrTmCntct_ARRAY();
    if (timeArray == null) {
      timeArray = new TmScrTmCntct_ARRAY();
    }
    String txtTmScrTmCntct = FormattingHelper
                                             .formatString(timeArray.getTmScrTmCntctCount() > 0 ? timeArray
                                                                                                           .getTmScrTmCntct(0)
                                                                                               : null);

    String cbxBIndContactAttempted = FormattingHelper.formatString(csys08so.getBIndContactAttempted());
    String cbxBIndExtComment = FormattingHelper.formatString(csys08so.getIndExtDocAccepted());
    String szNmPersonFull = FormattingHelper.formatString(csys08so.getSzNmPersonFull()); //MR-024 this is populated on Entered by field
    if (csys08so.getSzNmPersonFull() == null) {
      szNmPersonFull = FormattingHelper.formatString(csys08so.getSzNmPortalUserFull());
    }
    String szNmContactedBy = FormattingHelper.formatString(csys08so.getSzNmContactedBy()); //MR-024
    String txtDtDtContactEntered = FormattingHelper.formatDate(csys08so.getDtDTContactEntered()); //MR-024
    String hdnEnteredOn = FormattingHelper.formatDate(csys08so.getDtDTContactEntered()); //MR-024

    boolean enableSaveButton = false;
    boolean timeDisabled = false;
    String dateDisabled = "false";
    String disableAttempted = "false";
    String disableNarrSelect = "false";

    // If it's a APS or AFC Case then you can enter a time.
    if (CodesTables.CPGRMSFM_APS.equals(GlobalData.getSzCdStageProgram(request))
        || CodesTables.CPGRMSFM_AFC.equals(GlobalData.getSzCdStageProgram(request))) {
      // SIR 23410. Prefil DataTime for CLES and CLEV
      // SIR 23298. Prefil Date and time for CAGR
      String[] prefillDateTime = { "EDOC", "EENV", "EEXR", "EFAC", "EPHY", "CLES", "CLEV", "CAGR" };

      // See if the Contact Type needs to prefill the Date and Time and lock them.
      for (int i = 0; i < prefillDateTime.length; i++) {
        if (selSzCdContactType.equals(prefillDateTime[i])) {
          timeDisabled = true;
          dateDisabled = "true";

          //only update the date/time fields if they haven't already been entered
          if (("".equals(txtDtDtContactOccurred)) && ("".equals(txtTmScrTmCntct))) {
            // SIR 18462 - The TimeArray wasn't working as expected so switched to
            // get and format the current time from the Time constructor.
            txtTmScrTmCntct = new Time().format(Time.SHORT_NUMERIC_MASK);

            // SIR 18505 - The Date field wasn't pre-filling, switched to new Date()

            // Lock and fill the date field
            txtDtDtContactOccurred = FormattingHelper.formatDate(new Date());
            break;
          }
        }
      }
    } else {
      timeDisabled = false;
    }

    //SIR 466 Page fields are disabled in Modify mode
    if (PageModeConstants.MODIFY.equals(pageMode)) {
      timeDisabled = true;
      dateDisabled = "true";
      disableAttempted = "true";
      disableNarrSelect = "true";
    }

    // SIR 23410. Disable Attempted CheckBox
    // SIR 23298 Disable Attempted CheckBox

    if (CodesTables.CPGRMSFM_APS.equals(GlobalData.getSzCdStageProgram(request))) {
      String[] prefillAttempted = { "CLEV", "CLES", "CAGR" };
      // See if the Contact Type needs to prefill the Attempted with blank and lock them.
      for (int i = 0; i < prefillAttempted.length; i++) {
        if (selSzCdContactType.equals(prefillAttempted[i])) {
          disableAttempted = "true";
        }
      }
    }
    String presentationMode = ContactSearchListDetailConversation.getPresentationMode(request);
    boolean detailMode = ContactSearchListDetailConversation.DETAIL_CONTACT.equals(presentationMode);
    boolean extComment = false;
    if (csys08so.getUlIdPortalUser() != 0 && csys08so.getSzNmPortalUserFull() != null) {
      extComment = true;
    }
    //MR- 024
    //STGAP00014326 MR-024
    //Contacted By radio buttons   
    String checkedContactedBy = StringHelper.EMPTY_STRING;
    if (request.getParameter("rbContactedBy") != null) {
      checkedContactedBy = request.getParameter("rbContactedBy");
    } else {
      if (StringHelper.isValid(csys08so.getSzCdContactedBy())) {
        checkedContactedBy = csys08so.getSzCdContactedBy();
      } else {
        checkedContactedBy = CodesTables.CCCONTBY_DFC;
      }
    }

    String contactedByStaff = "none";
    String contactedbyCCA = "none";
    String nameContactedbyCCA = "none";
    String nameContactedByStaff = "none";
    String contactedbyXXX = "none";
    String nameContactedbyXXX = "none";

    if (CodesTables.CCCONTBY_CCA.equals(checkedContactedBy)) {
      nameContactedByStaff = "block";
      contactedByStaff = "block";
    } else if (CodesTables.CCCONTBY_XXX.equals(checkedContactedBy)) {
      nameContactedbyXXX = "block";
      contactedbyXXX = "block";
    } else if (CodesTables.CCCONTBY_DFC.equals(checkedContactedBy)) {
      nameContactedbyCCA = "block";
      contactedbyCCA = "block";
    }

    String indSauSealedHomeAndWorker = (String) state.getAttribute("SAUSEALEDHOMEANDWORKER", request);
    String editAllowedSevenDays = (String) state.getAttribute("EDITALLOWEDFORSEVENDAYS", request);
    String editAllowed = (String) state.getAttribute("EDITALLOWED", request);
    String isContactBeforeStageClosure = (String) state.getAttribute("ISDATEBEFORESTAGECLOSE", request);
    request.setAttribute("ISDATEBEFORESTAGECLOSESUB", isContactBeforeStageClosure);
    request.setAttribute("EDITALLOWEDSUB", editAllowed);
    request.setAttribute("SAUSEALEDHOMEANDWORKERSUB", indSauSealedHomeAndWorker);
    request.setAttribute("EDITALLOWEDFORSEVENDAYSSUB", editAllowedSevenDays);
    if (("true".equals(editAllowed) && "false".equals(isContactBeforeStageClosure))
        || ("true".equals(indSauSealedHomeAndWorker) && "true".equals(editAllowedSevenDays) && "false"
                                                                                                      .equals(isContactBeforeStageClosure))) {
      timeDisabled = false;
      dateDisabled = "false";
      disableAttempted = "false";
    }

    //Narrative Type check boxes
    String checkedNarrativeType = StringHelper.EMPTY_STRING;
    if (csys08so.getSzCdContactNarr() != null) {
      checkedNarrativeType = csys08so.getSzCdContactNarr();
    } else if (CodesTables.CSTAGES_ADO.equals(szCdStage) || CodesTables.CSTAGES_FSU.equals(szCdStage)
               || CodesTables.CSTAGES_SUB.equals(szCdStage)) {
      checkedNarrativeType = CodesTables.CCONNARR_SPW;
    } else {
      checkedNarrativeType = CodesTables.CCONNARR_STD;
    }
    //END STGAP00014326 MR-024

    String modDisabled = "false";
    if (csys08so.getIndExtDocAccepted() == "Y") {
      modDisabled = "true";
    }
    enableSaveButton = !timeDisabled || extComment;
%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs"%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="JavaScript1.2">
  var isPageReload = false;
  window.onbeforeunload = function ()
  {      
   IsDirty();
   }
   
  window.onload = function()
  {
    isPageReload = checkReload();
    var pageMode = <%=pageMode%>;
    var NEW_USING = <%=PageModeConstants.NEW_USING%>;
    var NEW = <%=PageModeConstants.NEW%>;

    var varRbContactedBy = document.getElementsByName('rbContactedBy');
    if (varRbContactedBy.length > 1){
      if(document.frmContactDetail.rbContactedBy[0].checked)
      {
        toggleVisibility('nameContactedByStaff', 'block');
        toggleVisibility('contactedByStaff', 'block');
        toggleVisibility('contactedbyCCA', 'none');
        toggleVisibility('contactedbyXXX', 'none');
        toggleVisibility('nameContactedbyCCA', 'none');
        toggleVisibility('nameContactedbyXXX', 'none');
      } else if(document.frmContactDetail.rbContactedBy[1].checked){
        toggleVisibility('contactedbyCCA', 'block');
        toggleVisibility('nameContactedbyCCA', 'block');
        toggleVisibility('contactedByStaff', 'none');
        toggleVisibility('nameContactedByStaff', 'none');
        toggleVisibility('contactedbyXXX', 'none');
        toggleVisibility('nameContactedbyXXX', 'none');
      } else if(document.frmContactDetail.rbContactedBy[2].checked){
        toggleVisibility('contactedbyXXX', 'block');
        toggleVisibility('nameContactedbyXXX', 'block');
        toggleVisibility('contactedByStaff', 'none');
        toggleVisibility('nameContactedByStaff', 'none');
        toggleVisibility('contactedbyCCA', 'none');
        toggleVisibility('nameContactedbyCCA', 'none');
      }     
    }else{
      if(document.frmContactDetail.rbContactedBy_Disabled[0].checked)
      {
        toggleVisibility('nameContactedByStaff', 'block');
        toggleVisibility('contactedByStaff', 'block');
        toggleVisibility('contactedbyCCA', 'none');
        toggleVisibility('contactedbyXXX', 'none');
        toggleVisibility('nameContactedbyCCA', 'none');
        toggleVisibility('nameContactedbyXXX', 'none');
      } else if(document.frmContactDetail.rbContactedBy_Disabled[1].checked){
        toggleVisibility('contactedbyCCA', 'block');
        toggleVisibility('nameContactedbyCCA', 'block');
        toggleVisibility('contactedByStaff', 'none');
        toggleVisibility('nameContactedByStaff', 'none');
        toggleVisibility('contactedbyXXX', 'none');
        toggleVisibility('nameContactedbyXXX', 'none');
      } else if(document.frmContactDetail.rbContactedBy_Disabled[2].checked){
        toggleVisibility('contactedbyXXX', 'block');
        toggleVisibility('nameContactedbyXXX', 'block');
        toggleVisibility('contactedByStaff', 'none');
        toggleVisibility('nameContactedByStaff', 'none');
        toggleVisibility('contactedbyCCA', 'none');
        toggleVisibility('nameContactedbyCCA', 'none');
      }
    }
   
   //if (pageMode == NEW || pageMode == NEW_USING) {
   //  displayInfoMsgs('Please select narrative type before saving. Narrative types cannot be modified in mobile once saved.');
   //}
 }
  

  function checkReload() {
    var isReloaded = false;
	if (document.frmContactDetail.hdnVisited.value == "") {
	  document.frmContactDetail.hdnVisited.value = "Y";
	  isReloaded = false;
	} else {
	  isReloaded = true;
	  reloadNarrType(isReloaded);
	}
	
	return isReloaded;
  }
  
  function onClickOfDFC(){
     if(document.frmContactDetail.rbContactedBy[0].checked)
      {
      toggleVisibility('contactedByStaff', 'block');
      toggleVisibility('nameContactedByStaff', 'block');
      toggleVisibility('contactedbyCCA', 'none');
      toggleVisibility('contactedbyXXX', 'none');
      toggleVisibility('nameContactedbyCCA', 'none');
      toggleVisibility('nameContactedbyXXX', 'none');
      //updateDisplayOnlyField("frmContactDetail", "szNmContactedByStaff", "");
      document.frmContactDetail.szNmContactedByStaff.value = "";
      }
   }
  
   function onClickOfCCA(){
       if(document.frmContactDetail.rbContactedBy[1].checked){
       toggleVisibility('contactedbyCCA', 'block');
       toggleVisibility('nameContactedbyCCA', 'block');
       toggleVisibility('contactedByStaff', 'none');
       toggleVisibility('nameContactedByStaff', 'none');
       toggleVisibility('contactedbyXXX', 'none');
       toggleVisibility('nameContactedbyXXX', 'none');
       document.frmContactDetail.szNmContactedByCCA.value = "";              
       }  
    }
  
    function onClickOfXXX(){  
       if(document.frmContactDetail.rbContactedBy[2].checked ){
       toggleVisibility('contactedbyXXX', 'block');
       toggleVisibility('nameContactedbyXXX', 'block');
       toggleVisibility('contactedByStaff', 'none');
       toggleVisibility('nameContactedByStaff', 'none');
       toggleVisibility('contactedbyCCA', 'none');
       toggleVisibility('nameContactedbyCCA', 'none');
       document.frmContactDetail.szNmContactedByXXX.value = "";       
       }  
    } 
    
  function caseSummaryHyperlink()
  {
    disableValidation("frmContactDetail");
    submitValidateForm("frmContactDetail", "/workload/CaseSummary/displayCaseSummary");
  }
  
  function stageSummaryHyperlink()
  {
    disableValidation("frmContactDetail");
    submitValidateForm("frmContactDetail", "/workload/StageSummary/displayStage");
  }
  
  function contactHyperlink(stageId)
  {
    disableValidation("frmContactDetail");
    submitValidateForm("frmContactDetail", "/contacts/ContactSearchListDetail/displayContactSearchList");
  }
  


</script>


<impact:validateForm name="frmContactDetail" method="post"
	action="/contacts/ContactSearchListDetail/displayContact"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactDetailCustomValidation"
	pageMode="<%=pageMode%>" schema="/WEB-INF/Constraints.xsd">

	<impact:validateErrors />
	<impact:validateInput type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<%-- these 2  used by document framework for new using --%>
	<impact:validateInput type="hidden" name="nEvent"
		value='<%=(String) request.getAttribute("nEvent")%>' />
	<impact:validateInput type="hidden" name="nCase"
		value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>" />
	<impact:validateInput type="hidden" name="docType" value="" />
	<%-- this used by custom validation --%>
	<impact:validateInput type="hidden" name="hdnIntakeDate"
		value="<%=hdnIntakeDate%>" />
	<%--Added per STGAP00011640 hdnIntakeTime to use in CustomValidation  --%>
	<impact:validateInput type="hidden" name="hdnIntakeTime"
		value="<%=hdnIntakeTime%>" />
	<%-- other hidden inputs --%>
	<impact:validateInput type="hidden" name="hdnTsLastUpdate"
		value="<%=tsLastUpdate%>" />
	<impact:validateInput type="hidden" name="hdnUlIdPerson"
		value="<%=String.valueOf(csys08so.getUlIdPerson())%>" />
	<impact:validateInput type="hidden" name="hdnUlIdPortalUser"
		value="<%=String.valueOf(csys08so.getUlIdPortalUser())%>" />
	<impact:validateInput type="hidden" name="hdnEnteredOn"
		value="<%=hdnEnteredOn%>" />
	<%-- MR-024 --%>
	<impact:validateInput type="hidden" name="hdbDetailPage" value="Y" />
	<impact:validateInput type="hidden" name="hdnVisited" value="" />

	<div id="caseStageHeaderInfo"><span id="caseNameInfo">
	Case: <a href='<%="javascript:caseSummaryHyperlink();"%>'
		onClick="window.onBeforeUnload=null;" tabIndex="0"><%=GlobalData.getSzNmCase(request)%>
	</a> </span> <span id="stageNameInfo"> Stage: <a
		href='<%="javascript:stageSummaryHyperlink();"%>'
		onClick="window.onBeforeUnload=null;" tabIndex="0"> <%=GlobalData.getSzNmStage(request)%>,
	<%=Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage(request))%>
	</a> </span></div>

	<div id="pageNav">
	<ul>
		<li class="lvl2Nav tab"><a
			href='<%="javascript:contactHyperlink();"%>'
			onClick="window.onBeforeUnload=null;" tabIndex="0"> Contact
		Search </a></li>
		<li class="lvl2NavSelect tab">Contact Detail</li>
	</ul>
	</div>


	<impact:ifThen test="<%=approvalStatus%>">
		<table border="0" cellspacing="0" cellpadding="3" width="100%">
			<tr>
				<td><impact:ButtonTag name="btnApprovalStatusFinal"
					img="btnApprovalStatus" form="frmContactDetail"
					action="/workload/ApprovalStatus/displayStatus" navAwayCk="true"
					editableMode="<%=EditableMode.ALL%>" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
		</table>
		<br>
	</impact:ifThen>
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
		width="100%">
		<tr>
			<th colspan="4">Contact Information</th>
		</tr>
		<tr>
			<td width="15%"><impact:validateDisplayOnlyField
				name="selSzCdContactType" codesTable="<%=CodesTables.CCNTCTYP%>"
				label="Contact/Summary Type" value="<%=selSzCdContactType%>" />
			</td>
		</tr>

		<tr>
			<td><impact:validateDisplayOnlyField label="Entered By"
				name="szNmEnteredBy" value="<%=szNmPersonFull%>" /></td>
		</tr>

		<tr>
			<td><impact:ifThen test='<%=detailMode%>'>
				<impact:validateDisplayOnlyField label="Entered On"
					name="txtDtDtContactEntered" value="<%=txtDtDtContactEntered%>" />
			</impact:ifThen></td>
		</tr>
		<tr>
			<td><impact:ifThen
				test='<%=detailMode && csys08so.getSzCdJobTitle()!= null%>'>
				<impact:validateDisplayOnlyField label="Title" name="szCdJobTitle"
					value="<%=csys08so.getSzCdJobTitle()%>" codesTable="CEMPJBCL" />
			</impact:ifThen></td>
		</tr>
		<tr>
			<td><impact:ifThen
				test='<%=detailMode && csys08so.getSzCdJobTitle()== null%>'>
				<impact:validateDisplayOnlyField label="Title" name="szCdJobTitle"
					colspan="4" value="<%=csys08so.getSzTitlePortalUser()%>" />
			</impact:ifThen></td>
		</tr>
		<impact:ifThen test='<%=detailMode%>'>
			<tr>
				<td width="25%">Contacted By:</td>
			</tr>

			<tr>
				<td width="33%"><impact:validateInput
					checked="<%=CodesTables.CCCONTBY_DFC.equals(checkedContactedBy) ? "true" : "false"%>"
					tabIndex="<%=tabIndex++%>" value="<%=CodesTables.CCCONTBY_DFC%>"
					type="radio" name="rbContactedBy" label="DFCS Staff"
					cssClass="formInput" disabled="<%=disableAttempted%>"
					onClick="onClickOfDFC()" /></td>
			</tr>
			<tr>
				<td><impact:validateInput
					checked="<%=CodesTables.CCCONTBY_CCA.equals(checkedContactedBy) ? "true" : "false"%>"
					tabIndex="<%=tabIndex++%>" value="<%=CodesTables.CCCONTBY_CCA%>"
					type="radio" name="rbContactedBy"
					label="CPA/CCI Authorized Case Worker" cssClass="formInput"
					disabled="<%=disableAttempted%>" onClick="onClickOfCCA()" /></td>
			</tr>
			<tr>
				<td><impact:validateInput
					checked="<%=CodesTables.CCCONTBY_XXX.equals(checkedContactedBy) ? "true" : "false"%>"
					tabIndex="<%=tabIndex++%>" value="<%=CodesTables.CCCONTBY_XXX%>"
					type="radio" name="rbContactedBy" label="Other"
					cssClass="formInput" disabled="<%=disableAttempted%>"
					onClick="onClickOfXXX()" /></td>
			</tr>

			<tr>
				<td id="nameContactedByStaff" style="display: &lt;%="><impact:ifThen
					test='<%=detailMode%>'>
					<impact:validateDisplayOnlyField label="Name of Staff"
						conditionallyRequired="true" name="" value="" />
				</impact:ifThen></td>
			</tr>
			<tr>
				<td id="contactedByStaff" style="display: &lt;%="><impact:ifThen
					test='<%=detailMode%>'>
					<impact:validateInput label="" tabIndex="<%=tabIndex++%>"
						type="text" name="szNmContactedByStaff"
						disabled="<%=disableAttempted%>" value="<%=szNmContactedBy%>"
						maxLength="20" />
				</impact:ifThen></td>
			</tr>

			<tr>
				<td id="nameContactedbyCCA" style="display: &lt;%="><impact:ifThen
					test='<%=detailMode%>'>
					<impact:validateDisplayOnlyField label="Name of Designee"
						conditionallyRequired="true" name="" value="" />
				</impact:ifThen></td>
			</tr>
			<tr>
				<td id="contactedbyCCA" style="display: &lt;%="><impact:ifThen
					test='<%=detailMode%>'>
					<impact:validateInput label="" tabIndex="<%=tabIndex++%>"
						type="text" name="szNmContactedByCCA"
						disabled="<%=disableAttempted%>" value="<%=szNmContactedBy%>"
						maxLength="20" />
				</impact:ifThen></td>
			</tr>

			<tr>
				<td id="nameContactedbyXXX" width="25%" style="display: &lt;%=">
				<impact:ifThen test='<%=detailMode%>'>
					<impact:validateDisplayOnlyField label="Name    "
						conditionallyRequired="true" name="" value="" />
				</impact:ifThen></td>
			</tr>
			<tr>
				<td id="contactedbyXXX" style="display: &lt;%="><impact:ifThen
					test='<%=detailMode%>'>
					<impact:validateInput label="" tabIndex="<%=tabIndex++%>"
						type="text" name="szNmContactedByXXX"
						disabled="<%=disableAttempted%>" value="<%=szNmContactedBy%>"
						maxLength="20" />
				</impact:ifThen></td>
			</tr>
		</impact:ifThen>



		<tr>
			<td><!--      	<input type="date" id="txtDtDtContactOccurred_Id" value="" min="01/01/1905" max="12/31/2029"/>
       --> <impact:validateDate label="Contact Date" constraint="Date"
				name="txtDtDtContactOccurred" value="<%=txtDtDtContactOccurred%>"
				required="true" size="8" tabIndex="<%=tabIndex++%>"
				disabled="<%=dateDisabled%>" type="date" /></td>
		</tr>
		<tr>
			<td><impact:validateTime label="Time" name="txtTmScrTmCntct"
				value="<%=txtTmScrTmCntct%>"
				disabled="<%=String.valueOf(timeDisabled)%>" required="true"
				tabIndex="<%=tabIndex++%>" /></td>
		</tr>
		<tr>
			<td><impact:ifThen test='<%=detailMode%>'>
				<impact:validateInput label="Attempted"
					name="cbxBIndContactAttempted" type="checkbox"
					disabled="<%=disableAttempted%>"
					checked="<%=cbxBIndContactAttempted%>"
					value="<%=cbxBIndContactAttempted%>" tabIndex="<%=tabIndex++%>" />
			</impact:ifThen></td>
		</tr>
		<%
		  request.setAttribute("tabIndex", tabIndex);
		%>
		<impact:if test='<%=detailMode%>'>
			<impact:then>
				<%@ include file="/grnds-docs/contacts/DetailContactSub.jsp"%>
				<%-- jsp:include page="/grnds-docs/contacts/DetailContactSub.jsp" / --%>
			</impact:then>
			<impact:else>
				<%@ include file="/grnds-docs/contacts/SummaryContactSub.jsp"%>
			</impact:else>
		</impact:if>
		<%
		  tabIndex = (Integer) request.getAttribute("tabIndex");

		      // Moved table close tag down here.
		%>
	</table>

	<%
	  // All Contacts have a modifiable Date except the AFC Contacts EDOC, EENV,
	      // EEXR, EFAC, EPHY which all prefill with the current date and are locked.
	      //
	      // CPS cases do not have a Time.
	      //
	      // APS cases have a modifiable Time except the AFC Contacts EDOC, EENV, EEXR,
	      // EFAC , EPHY, CLEV, CLES (SIR 23410) which prefill with the currente time and are non-modifiable.
	      //
	      // Initial Presentation Mode:
	      // A Contact Type can be selected and the Continue Button is shown.
	      //
	      // Detail Presentation Mode:
	      // The Select Staff Button allows you to change Contacted By.
	      // The Attempted & Attempted checkbox, Purpose, Method, Location,
	      // Attempted and Principal Collaterals checkboxes are modifiable.
	      // The Purpose, Method, Location, and Others Contacted fields are modifiable
	      // for the programs except for CLES and CLEV (SIR 23410).
	      //
	      // Summary Presentation Mode:
	      // The Select Staff Button, Attempted checkbox, Purpose, Method, Location,
	      // Others fields and Principal/Collaterals checkboxes don't exist.
	      // The following Summary Contacts have a Summary Period: EEXR, BMTH, GMTH,
	      // HMTH, JMTH, IREZ, IATZ, IDVZ, IPHZ, IMAZ, IQUZ, IREE, ISEZ, IVAZ, IVIZ.
	      //
	      //
	      //SIR 23298 added AGR to  and submit
	      String[] Submit = { "EXR", "MTH", "AGR" };
	      String[] SubmitFAD = { "ATP", "ATZ", "CMP", "DVP", "DVZ", "FCL", "MAS", "MAZ", "PHS", "PHZ", "QUV", "QUZ",
	                            "REA", "REE", "REG", "REZ", "SEI", "SEZ", "STS", "VAR", "VAZ", "VIO", "VIZ" };

	      boolean display = true;
	      // SIR 18274 - For an Extension Request Hide the  Button if there is a
	      // UlIdEvent, if there is not, hide the  and Submit Button.
	      if (CodesTables.CCNTCTYP_EEXR.equals(selSzCdContactType) && GlobalData.getUlIdEvent(request) != 0) {
	        display = false;
	      }

	      // Grab charcters two to four of selSzCdContact Type for comparisons.  The
	      // first character is a key to determine the type of case and stage and we
	      // don't need to compare that.  Example:  AREG is a Contact for a CPS INV
	      // Case, and a BREG is a Contact for a CPS FPR Case.
	      //String contactType = selSzCdContactType.substring( 1, 4 );
	      String contactType = selSzCdContactType.substring(0, 3);

	      boolean displaySubmit = false;
	      // Set displaySubmit to true if AndSubmit button should be shown
	      for (int i = 0; i < Submit.length; i++) {
	        if (contactType.equals(Submit[i])) {
	          displaySubmit = true;
	        }
	      }

	      //Set true if it's a FAD Program and one of the types in the array
	      if (szCdStage.equals(CodesTables.CSTAGES_FAD)) {
	        for (int i = 0; i < SubmitFAD.length; i++) {
	          if (contactType.equals(SubmitFAD[i])) {
	            displaySubmit = true;
	          }
	        }
	      }

	      if (CodesTables.CCNTCTYP_EEXR.equals(selSzCdContactType) && GlobalData.getUlIdEvent(request) == 0) {
	        displaySubmit = false;
	      }

	      // SIR 17669 Do not display the  and submit pushbutton when the
	      // page is in approval mode either
	      if (GlobalData.isApprovalMode(request)) {
	        displaySubmit = false;
	      }
	%>

	<script type="text/JavaScript" language="javascript">
  
  function reloadNarrType(isReload) {
/*    var renderFormat = document.getElementsByName('renderFormat');
    var docExists = document.getElementsByName('docExists');
    for (i = 0; i < renderFormat.length; i++) {
    	if (renderFormat[i] != null) {
    		renderFormat[i].value = 'HTML_WITHOUT_SHELL';
    	}
    }
    for (i = 0; i < docExists.length; i++) {
    	if (docExists[i] != null) {
    		docExists[i].value = 'true';
    	}
    }
*/    
    //renderFormat[0].setAttribute('value','HTML_WITHOUT_SHELL');
    //docExists[0].setAttribute('value','true');
    
    //document.forms.frmDocument.renderFormat.value = "HTML_WITHOUT_SHELL";
    //document.forms.frmDocument.docExists.value = "true";

    //frmDocument.elements['renderFormat'].value = "HTML_WITHOUT_SHELL";
    //frmDocument.elements['docExists'].value = "true";
  	//document.frmDocument.renderFormat.value = "HTML_WITHOUT_SHELL";
  	//document.frmDocument.docExists.value = "true";
  	
/*  	if (frmDocument.elements != null) {
  		for (i=0; i < frmDocument.elements.length; i++) {
  			var theInput;
  			var inputName = frmDocument.elements[i].name;
  			
  			theInput = document.getElementById(inputName);
  			
  			alert(inputName);
  		}
  	}
*/  	
  }
  
 function onClickOfNarrType()
  {
    var rdButtonsLocked = <%= disableNarrSelect %>;
    if (rdButtonsLocked == "true") {
      return true;
    }
     
  var narrType = "<%= csys08so.getSzCdContactNarr() %>";
  var narrTypeSelected = "";
  var docTypeNarr = "";
  
  /* Added a check for isPageReload. If the page is reloaded,
     we need to reference the "desktop" version of the narrative
     due to triggers in the database. The user will be unable to
     edit the document once they click close on the narrative.*/
  if(document.frmContactDetail.rbNarrType[0].checked){
     narrTypeSelected = "STD";
     if (isPageReload) {
       docTypeNarr = "BLANKNAR";
     } else {
       docTypeNarr = "MOBILEBLANKNAR";
     }
  }else if(document.frmContactDetail.rbNarrType[1].checked){
     narrTypeSelected = "PCV";
     if (isPageReload) {
       docTypeNarr = "CVISITN";
     } else {
       docTypeNarr = "MOBILECVISITN";
     }
  }else {
     narrTypeSelected = "SPW";
     if (isPageReload) {
       docTypeNarr = "SPWBNARR";
     } else {
       docTypeNarr = "MOBILESPWBNARR";
     }
  }
  
  // If the same radio button is clicked that was selected when the page loaded then ignore.
  if (narrType == narrTypeSelected){
    return true;
  } else {
    document.frmDocument.promptSavePage.value = 'frmContactDetail';
  } 

  if (document.frmDocument.docExists.value == 'true' && (narrType != narrTypeSelected)){
      if (confirm('The existing narrative will be deleted and all the information will be lost if the narrative type is changed. Are you sure you want to change the narrative type?  Click OK to continue.'))
      {
      	frmDocument.elements['promptSavePage'].value = "frmContactDetail";
      	frmContactDetail.elements['hidDeleteDocument'].value = "true";
         //document.frmDocument.promptSavePage.value = "frmContactDetail";
         //document.frmContactDetail.hidDeleteDocument.value = "true";
      }
      else
      {
         //Set the radio button back
         if (narrType == "STD") {
           document.frmContactDetail.rbNarrType[0].checked = true;
         } else if (narrType == "PCV") {
           document.frmContactDetail.rbNarrType[1].checked = true;
         } else if (narrType == "SPW") {
           document.frmContactDetail.rbNarrType[2].checked = true;
         }
       }
  }   
}


</script>


	<% if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.NEW_USING)) {%>
	<div class="formInfoText">
		<span class="formLabelInfo">Attention: </span>
		Select narrative type before saving. Narrative types cannot be modified in mobile once saved.
	</div>
	<% } %>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td colspan="8"></td>
			<td align="right" width="10%"><impact:ifThen
				test="<%=enableSaveButton%>">
				<impact:ButtonTag name="btnSave" img="btnSave"
					action="/contacts/ContactSearchListDetail/saveContact"
					form="frmContactDetail" align="right"
					restrictRepost="true"
					preventDoubleClick="true" tabIndex="<%=tabIndex++%>" />
			</impact:ifThen></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<td>Narrative Type:
			</td>
		</tr>
		<tr>
			<td><impact:validateInput
				checked="<%=CodesTables.CCONNARR_STD.equals(checkedNarrativeType) ? "true" : "false"%>"
				tabIndex="<%=tabIndex++%>" value="STD" type="radio"
				name="rbNarrType" label="Standard" cssClass="formInput"
				onClick="return onClickOfNarrType();"
				disabled="<%=disableNarrSelect%>" /></td>
			<td><impact:validateInput
				checked="<%=CodesTables.CCONNARR_PCV.equals(checkedNarrativeType) ? "true" : "false"%>"
				tabIndex="<%=tabIndex++%>" value="PCV" type="radio"
				name="rbNarrType" label="Parent/Child Visitation"
				cssClass="formInput" onClick="return onClickOfNarrType();"
				disabled="<%=disableNarrSelect%>" /></td>
			<td><impact:validateInput
				checked="<%=CodesTables.CCONNARR_SPW.equals(checkedNarrativeType) ? "true" : "false"%>"
				tabIndex="<%=tabIndex++%>" value="SPW" type="radio"
				name="rbNarrType" label="Safety, Permanency and Wellbeing"
				cssClass="formInput" onClick="return onClickOfNarrType();"
				disabled="<%=disableNarrSelect%>" /></td>
		</tr>
	</table>
	<impact:ifThen test="<%=extComment%>">
		<table border="0" cellspacing="0" cellpadding="3" align="right"
			width="100%" class="tableBorder">
			<tr>
				<td><impact:validateInput checked="<%=cbxBIndExtComment%>"
					value="<%=cbxBIndExtComment%>" type="checkbox"
					label="External  User Comments Accepted" name="cbxBIndExtComment"
					cssClass="formInput" disabled="<%=modDisabled%>" /></td>
			</tr>
			<tr>
				<td width="20%">Checking this box indicates that the
				documentation has been received by the case manager and that the
				documentation is complete.</td>
			</tr>
		</table>
	</impact:ifThen>
	<impact:validateInput name="hidDeleteDocument" type="hidden"
		value="false" />
	<impact:validateInput type="hidden" name="hdnDocExists" value="false" />
	<%-- MR-024 --%>


</impact:validateForm>
<%
  boolean docExists = false;
    boolean bProtect = true;
    boolean stageIsOpen = false;
    boolean commentMode = false;
    if (ArchitectureConstants.TRUE.equals(request.getAttribute(ContactSearchListDetailConversation.DOCEXISTS))) {
      docExists = true;
    }

    // SIR 18384 - Had to set bProtect to false if in Approval mode
    String sDate = FormattingHelper.formatTimestamp(csys08so.getTsLastUpdate());
    if (csys08so.getDtDtStageClose() == null) {
      stageIsOpen = true;
    }

    if ((ContactSearchListDetailConversation.CD_POP_FROM_MOBILE.equals(szCdPopulatedFrom) && ArchitectureConstants.TRUE
                                                                                                                       .equals(hdnAddMode))
        || (ArchitectureConstants.TRUE.equals(hdnAddMode))) {
      bProtect = false;
      commentMode = true;
    } else {
      bProtect = true;
      commentMode = false;
    }

    // SIR 18956 - We have to moneky around with the Narrative that will be
    // displayed because CIFF use to be able to be either a FACTOFAC or NORMAL,
    // and C24H could have been 24HOUR or NORMAL, so we added C24N (NORMAL) and
    // CFTF (FACTOFAC).  All of this has to do with APS SVC vs APS INV stages.
    String docType = selSzCdContactType;
    String docTypeNarr = "MOBILEBLANKNAR";

    //docType will be set to "CIFF" by default, change it to "CFTF" if needed
    if (CodesTables.CCNTCTYP_CIFF.equals(docType) && CodesTables.CSTAGES_INV.equals(szCdStage)) {
      docType = CodesTables.CCNTCTYP_CFTF;
    }

    if ("PVC".equals(docType.substring(1, 4)) || CodesTables.CCONNARR_PCV.equals(checkedNarrativeType)) {
      docTypeNarr = "MOBILECVISITN";
    }

    if (CodesTables.CCONNARR_STD.equals(checkedNarrativeType)) {
      docTypeNarr = "MOBILEBLANKNAR";
    }

    if (CodesTables.CCONNARR_SPW.equals(checkedNarrativeType)) {
      docTypeNarr = "MOBILESPWBNARR";
    }

    //docType will be set to "C24H" by default, change it to "C24N" if needed
    if (CodesTables.CCNTCTYP_C24H.equals(docType) && CodesTables.CSTAGES_SVC.equals(szCdStage)) {
      docType = CodesTables.CCNTCTYP_C24N;
    }

    String szCdStageType = GlobalData.getSzCdStageType(request);
    boolean displayNarrativeButton = true;
    // SIR 18974 - There is no narrative button for PAL Notifications (JNOT)
    // If logic was erroneously comparing JNOT to Stage instead of Contact Type
    // Sir 23686 - For APS, when contact Types are C24N,CMST and CIFF display narrative
    // button only if documemt already exist or stage type is C-REG or C-GUA.

    if ((CodesTables.CCNTCTYP_JNOT.equals(selSzCdContactType))
        || (CodesTables.CPGRMSFM_APS.equals(GlobalData.getSzCdStageProgram(request)) && ((!CodesTables.CSTGTYPE_CGUA
                                                                                                                    .equals(szCdStageType) && !CodesTables.CSTGTYPE_CREG
                                                                                                                                                                        .equals(szCdStageType))
                                                                                         && (CodesTables.CCNTCTYP_C24N
                                                                                                                      .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_C24H
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_CMST
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_EIFF
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_CFTF
                                                                                                                         .equals(docType) || CodesTables.CCNTCTYP_CIFF
                                                                                                                                                                      .equals(docType)) && !docExists))) {
      displayNarrativeButton = false;
    }

    // You always show the Narrative button for a Closed Stage Addendum but you
    // shouldn't pass in checkStage.  This way anyone can edit a FCCA Narrative.
    int checkStage = GlobalData.getUlIdStage(request);
    if (CodesTables.CCNTCTYP_FCCA.equals(selSzCdContactType)) {
      checkStage = 0;
    }

    if (CodesTables.CCNTCTYP_FCCA.equals(selSzCdContactType) || displayNarrativeButton) {
    
      String strAction = "/document/DocumentConversation/showDocument?taskCD="
                       + String.valueOf(GlobalData.getSzCdTask(request))
                       + "&idStage=" + String.valueOf(GlobalData.getUlIdStage(request))
      				   + "&idCase=" + String.valueOf(GlobalData.getUlIdCase(request))
      				   + "&idEvent=" + String.valueOf(GlobalData.getUlIdEvent(request))
      				   + "&cdStage=" + String.valueOf(GlobalData.getSzCdStage(request))
      				   + "&cdContactType=" + String.valueOf(selSzCdContactType)
      				   + "&level3Tab=" + String.valueOf(request.getParameter(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME));
%>

<tr>
	<td><br>
	<impact:documentButton pageMode="<%=pageMode%>"
		tabIndex="<%=tabIndex++%>">
		<impact:document displayName="Document" checkForNewMode="true"
			name="frmDocument" checkStage="<%=checkStage%>"
			action="<%=strAction%>"
			protectDocument="<%=bProtect%>" commentMode="<%=commentMode %>"
			deleteDocument="false" docType="<%=docTypeNarr%>"
			docExists="<%=docExists%>" postInSameWindow="true">

			<impact:documentParameter name="sEvent"
				value="<%=String.valueOf(GlobalData.getUlIdEvent(request))%>" />
			<impact:documentParameter name="sCase"
				value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>" />
			<impact:documentParameter name="sTimestamp" value="<%= sDate %>" />
			<impact:documentParameter name="pCase"
				value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>" />
			<impact:documentParameter name="pStage"
				value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
			<impact:documentParameter name="pCdStage"
				value="<%=String.valueOf(GlobalData.getSzCdStage(request))%>"></impact:documentParameter>
		</impact:document>
	</impact:documentButton></td>
</tr>

<script type="text/JavaScript" language="javascript">

  document.frmContactDetail.hdnDocExists.value = '<%=docExists%>';

  function setDocTypeParam() {
    document.frmContactDetail.docType.value = '<%=docTypeNarr%>';
  }
  window.attachEvent('onload', setDocTypeParam);
</script>
<%
  }
%>
<%
  }
%>