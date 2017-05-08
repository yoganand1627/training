
<%
//*  JSP Name:   AdoptionAsstnc
//*  Coded by:   Wes Thompson
//*  Date Created: 01/21/03
//*
//*  Description:
//*  This JSP serves to display the Adoption Assistance page
//*  to maintain adoption subsidy details.
/**
 * Change History:
 *
 *  Date        User              Description
 *  --------    ----------------  ----------------------------------------------
 *  06/24/2003  Eric Dickman      SIR 18490-- Changed the logic on how the Third
 *                                Party Checkbox gets saved.
 *  06/24/2003  Eric Dickman      SIR 18471--  The amount field will only throw
 *                                MSG_NO_AMOUNT_IN_ADOPT_SUB.  Not SSM_COMPLETE_REQUIRED
 *                                then MSG_NO_AMOUNT_IN_ADOPT_SUB.  If the type
 *                                drop down is:
 *                                SUBSIDY_TYPE_TITLE_IV_MEDICAID
 *                                SUBSIDY_TYPE_STATE_MEDICAID_ONLY
 *                                SUBSIDY_TYPE_STATE_MED_ASST_ONLY
 *                                SUBSIDY_TYPE_TITLE_IV_E_MEDICAID_ONLY(ICAMA)
 *                                SUBSIDY_TYPE_STATE_ADPT_ASST_MEDICAID_ONLY(ICAMA)
 *                                the user amount field will be disabled.  If the
 *                                type is different then listed above, the user
 *                                can save the amount field with any amount greater than
 *                                0.00.
 *  09/08/2003  thompswa          SIR 19742-- The adoption must be consummated for
 *                                a non-recurring subsidy to be approved.  Uses
 *                                "szCdLegalStatStatus", added as hidden field.
 *                                MSG_NO_AMOUNT_IN_ADOPT_SUB decode changed.
 *
 *  09/24/2003  brauchs           SIR 19814-- maxLengths
 *
 *  09/25/2003  thompswa          SIR 19884-- Closure Reason selection box expanded.
 *
 *  03/11/2004  thompswa          SIR 22731-- Batch closure code, "Adoption Assistance
 *                                Expired - Syst" (SS), is excluded from dropdown.
 *                                If closure reason is "SS", the End and Closure
 *                                Reason fields are disabled.
 *  08/27/2008	jcochran		  STGAP0001005: Added Adoption Assistance Agreement 
 *								  document definition to form drop-down menu.
 *  08/27/2008	mchillman		  STGAP00011042: AA Agreement Form is available for an AA Agreement in APRV status.
 *  01/18/2008	wjcochran		  STGAP00011629: Disabled javascript that overrides the amount requested/approved for assistance
 *	01/18/2008	wjcochran		  STGAP00011586: Added variable to keep track of current contracts
 *  01/27/2008  wjcochran		  STGAP00012085: Updated Yearly Renewal Dates section to Approval Period Dates section
 *  04/03/2009  hjbaptiste        STGAP00012933: Added the action to call the submitApproval_xa() method in the Conversation for the 
 *                                Approval Status button
 *  04/03/2009  hjbaptiste        STGAP00012961: Enabled the Change Reason comment box whenever the Payment Change Reason dropdown
 *                                               is enabled   
 *  05/11/2009  bgehlot           STGAP00013779:  MR-50 Changes     
 *  05/26/2009  bgehlot           STGAP00013923: Combined options to display in dropdown for basic rate and specialized rate  
 *  05/30/2009  bgehlot           STGAP00013960: Added code so that the page reloads with dates from table after saving      
 *  06/07/2009  bgehlot           STGAP00014114: When saving and completing the Adoption Assistance Agreement page, the 
 *                                Payment Method field should default to "Adoptive Parent Reimbursement" for standard 
 *                                monthly adoption assistance payments (IV-B Fin Asst Only, IV-B Fin Asst and Medicaid, 
 *                                IV-E Fin Asst Only, IV-E Fin Asst and Medicaid)          
 * 06/008/2009  bgehlot           STGAP00014113 : Type/Class of Assistance is a required field.      
 * 06/09/2009   bgehlot           STGAP00014155: Added code for deferred application also
 * 06/11/2009   bgehlot           STGAP00014208: The amount should be displayed as $0.00 when blank
 * 06/11/2009   bgehlot           STGAP00014203: For the conversion data for the agreement which does not have id_spec_needs the page 
 *                                displays code in the Type/Class Dropdown whether it should display decode   
 * 06/18/2009   bgehlot           STGAP00014355: None Applicable deffered application populates the dropdown.      
 * 07/13/2009   bgehlot           STGAP00014682 : display base rate in Money format              
 * 08/28/2009   bgehlot           STGAP00014599: Disable payment method for basic and specialized rates 
 * 01/08/2010   mxpatel           STGAP00015702:  removed Special Services Approval Period Dates section for MR-52 
 * 01/08/2010   mxpatel           STGAP00015702:  removed Special Services types from Type/Class of Assistance dropdown for MR-52  
 * 01/14/2010   mxpatel           SMS #43655: Removed Special Services Type, Special Services Approved Amount and If other Special Service Please specify fieds from the page.                                                                                                      
 * 01/15/2010   mxpatel           SMS #43659: added code to only add a valued to "options" if its not already there.
 * 01/15/2010   mxpatel           SMS #43656: added code to populate start date.
 * 02/17/2010   hjbaptiste        SMS#44783: MR-60 Changes, Use codestables for Special Needs Type and Approval  
 * 06/10/2010   arege             SMS#53458: Agreement Start date should be pulled from the database if it exists in the database
 * 03/07/2011   htvo              SMS#97845 MR-074-2 AFCARS: Removed old code that used childHasBeenInSubStage logic 
 *                                Used incident/non-incident indicator determined in the associated application to display Special Needs
 *                                Determination not available for non-incident child in PAD stage.
 *                                Remove message "Specialized Rate and Special Services not yet approved." b/c it is no longer applicable
 * 03/08/2011   htvo              SMS#97845 MR-074-2 AFCARS: remove checking for incident status for message 'Special Needs Determination not Available'
 *                                Display message when missing SSAU Confirmation due to linked application not found.
 *                                
 */
%>


<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.AdoptionAsstncConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.AdoptionAsstncCustomValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="java.util.Collection"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="java.util.Iterator"%>

<%

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int tabIndex = 1;
boolean showSaveButton = true;
String adoptionSubsidyDisabled = "false";
String paymentChangedDisabled = "false";
boolean adoassmemProtect = true;

//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
BaseSessionStateManager state =(BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

//***************************************************************************
//*** RETRIEVE OBJECTS AND PAGE DATA FROM REQUEST AND PERFORM NULL CATCH  ***
//***************************************************************************

UserProfile user = UserProfileHelper.getUserProfile( request );

// Definition for Record CFAD39SO - ADOPTION ASSISTANCE RETREIVE
CFAD39SO cfad39so = ( CFAD39SO ) state.getAttribute( "CFAD39SO", request );
cfad39so = cfad39so != null ? cfad39so : new CFAD39SO();

String dtDtPersonBirth = FormattingHelper.formatDate(cfad39so.getDtDtPersonBirth());
String bIndBLOBExistsInDatabaseString = cfad39so.getBIndBLOBExistsInDatabase();
String endDate18 = FormattingHelper.formatDate( AdoptionAsstncCustomValidation.getEndDate( DateHelper.toCastorDateSafe( dtDtPersonBirth ), 18 ) );
String endDate21 = FormattingHelper.formatDate( AdoptionAsstncCustomValidation.getEndDate( DateHelper.toCastorDateSafe( dtDtPersonBirth ), 21 ) );
//STGAP00013779
String endDateValue = endDate18;

// Definition for Record Group CFAD39SOG00 - ADOPTION ASSISTANCE (HEADER) RETREIVE
CFAD39SOG00 cfad39sog00 = cfad39so.getCFAD39SOG00();
cfad39sog00 = cfad39sog00 != null ? cfad39sog00 : new CFAD39SOG00();

//STGAP00013779: Approved date would be the date that the SAU approved the Associated Application
String adptSubApprvd = FormattingHelper.formatDate(cfad39sog00.getDtDtSndAprv());
String szCdPaymentMethod = FormattingHelper.formatString(cfad39sog00.getSzCdPlaymentMthd());
String txtSpclAsstCmnts = FormattingHelper.formatString(cfad39sog00.getSzTxtSpclAsstCmnts());
String txtAdptSubRsn = FormattingHelper.formatString(cfad39sog00.getSzTxtAdptSubRsn());
String cbxCIndAdptSubThirdParty = cfad39sog00.getCIndAdptSubThirdParty();
String cbxCIndAdptSchoolVerified = cfad39sog00.getCIndSchoolVerified();
String cdAdptSubDeterm = cfad39sog00.getSzCdAdptSubDeterm();
String paymentMethod = StringHelper.EMPTY_STRING;
String dtDtAdptSubEffective = StringHelper.EMPTY_STRING;
String dtDtAdptSubApprvd = StringHelper.EMPTY_STRING;
String szTxtAdptSubRsn = StringHelper.EMPTY_STRING;
String szTxtSpclAsstCmnts = StringHelper.EMPTY_STRING;
String indAdptSubThirdParty = StringHelper.EMPTY_STRING;
String indAdptSchoolVerified = StringHelper.EMPTY_STRING;
String szCdAdptSubDeterm = StringHelper.EMPTY_STRING;

String txtSzCdAdptSubCloseRsn = ContextHelper.getStringSafe(request, "txtSzCdAdptSubCloseRsn");
String dtDtAdptSubTerminated = ContextHelper.getStringSafe(request, "txtDtDtAdptSubTerminated");

String adptSubEffective = FormattingHelper.formatDate(cfad39sog00.getDtDtAdptSubEffective());
String dtDtAdptSubEnd = FormattingHelper.formatDate(cfad39sog00.getDtDtAdptSubEnd());
String dtDtDtRenwlEffBegin = FormattingHelper.formatDate(cfad39sog00.getDtDtRenwlEffBegin());
String dtDtDtRenwlEffEnd = FormattingHelper.formatDate(cfad39sog00.getDtDtRenwlEffEnd());
//Added for Adoption Assistance Memorandum Form
String idAdptSub = FormattingHelper.formatString(String.valueOf(cfad39sog00.getUlIdAdptSub()));
// Definition for Record Group CFAD39SOG01 - ADOPTION ASSISTANCE (PAYEE) RETREIVE
CFAD39SOG01 cfad39sog01 = cfad39so.getCFAD39SOG01();
cfad39sog01 = cfad39sog01 != null ? cfad39sog01 : new CFAD39SOG01();

//STGAP00014682 : display base rate as Money format
String baseRate = FormattingHelper.formatMoney(cfad39sog00.getSAmtAdptBaseRate());

// Definition for Record ROWCCMN01UIG00 - ADOPTION ASSISTANCE (EVENT) RETREIVE
ROWCCMN01UIG00 rowccmn01uig00 = cfad39so.getROWCCMN01UIG00();
rowccmn01uig00 = rowccmn01uig00 != null ? rowccmn01uig00 : new ROWCCMN01UIG00();
cfad39so.setROWCCMN01UIG00(rowccmn01uig00);

// Definition for Record ROWCCMN01UIG01_ARRAY
if(cfad39so.getROWCCMN01UIG00() != null){
 ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = cfad39so.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY();
 rowccmn01uig01_array = rowccmn01uig01_array != null ? rowccmn01uig01_array : new ROWCCMN01UIG01_ARRAY();
 cfad39so.getROWCCMN01UIG00().setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
}else{
 ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
 cfad39so.getROWCCMN01UIG00().setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
}

String approvalType = "";
approvalType = Lookup.simpleDecodeSafe("CSPCLTYP", FormattingHelper.formatString(cfad39sog00.getSzSndAprvType()));

//SIR 22731 Add disable test string, bAscr, and exclude options for CSUBCLOS_SS.
String AdptSubCloseRsn = FormattingHelper.formatString( cfad39sog00.getSzCdAdptSubCloseRsn() );
String bAscr = AdptSubCloseRsn.equals(CodesTables.CSUBCLOS_SS) ? "true" : "false" ;
List exOptions = new ArrayList();
if ( bAscr == "false" )
{
  exOptions.add(CodesTables.CSUBCLOS_SS);
}//SIR 22731 End.

//STGAP00013779: Create -Type/Class- drop down.
//Set up the option array  

    List<CodeAttributes> options = new ArrayList<CodeAttributes>();
    String codeCategory = CodesTables.CSUBTYPE;
    List<CodeAttributes> allOptions = null;
    String type = "";
    allOptions = Lookup.getCategoryCollection(codeCategory);

    if (allOptions != null) {
      //STGAP00014203: Added this check
      if(cfad39sog00.getUlIdSpecialNeedsEvent() != 0){
	      for (Iterator<CodeAttributes> it = allOptions.iterator(); it.hasNext();) {
	        CodeAttributes ca = it.next();
	        //Basic Rate or Specialized Rate (IV-B)
	        //STGAP00014155: Added code for deferred application also
	        if((ArchitectureConstants.Y.equals(cfad39sog00.getBIndBasicRateReq()) 
	          && (ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpcNeedsApproved()) || "D".equals(cfad39sog00.getBIndSpcNeedsApproved()))
	          && CodesTables.CAAFDTYP_PST.equals(cfad39sog00.getSzSndFndType())) || 
	          (ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpecializedRateReq()) 
			   && ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpclRateAdoAppr())
			   && CodesTables.CAAFDTYP_PST.equals(cfad39sog00.getSzSndFndType()))){
	          if (CodesTables.CSUBTYPE_09.equals(ca.getCode()) || CodesTables.CSUBTYPE_07.equals(ca.getCode()) || CodesTables.CSUBTYPE_27.equals(ca.getCode())) {
	             if(!options.contains(ca)){
	             options.add(ca);
	             }
	          }
	        }
	       //Basic Rate or Specialized Rate (IV-E)
	       //STGAP00014155: Added code for deferred application also
			if((ArchitectureConstants.Y.equals(cfad39sog00.getBIndBasicRateReq()) 
			   && (ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpcNeedsApproved()) || "D".equals(cfad39sog00.getBIndSpcNeedsApproved()))
			   && CodesTables.CAAFDTYP_IVE.equals(cfad39sog00.getSzSndFndType())) ||
			   (ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpecializedRateReq()) 
			   && ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpclRateAdoAppr())
			   && CodesTables.CAAFDTYP_IVE.equals(cfad39sog00.getSzSndFndType()))){
			   if (CodesTables.CSUBTYPE_01.equals(ca.getCode()) || CodesTables.CSUBTYPE_03.equals(ca.getCode()) || CodesTables.CSUBTYPE_26.equals(ca.getCode())) {
	             if(!options.contains(ca)){
	             options.add(ca);
	             }
	          }
			}
			
			//Non Recurring
			if(ArchitectureConstants.Y.equals(cfad39sog00.getBIndNonRecRequested()) 
			   && ArchitectureConstants.Y.equals(cfad39sog00.getBIndNonRecApproved())){
			   if (CodesTables.CSUBTYPE_22.equals(ca.getCode()) 
			       || CodesTables.CSUBTYPE_24.equals(ca.getCode()) 
			       || CodesTables.CSUBTYPE_25.equals(ca.getCode())
			       || CodesTables.CSUBTYPE_23.equals(ca.getCode())) {
			             if(!options.contains(ca)){
			             options.add(ca);
			             }
			          }
			}
	
	        //STGAP00014355: None Applicable deffered application populates the dropdown.
	        if(("N".equals(cfad39sog00.getBIndReasonSpecialRequest()) 
	          && (ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpcNeedsApproved()) || "D".equals(cfad39sog00.getBIndSpcNeedsApproved()))
	          && CodesTables.CAAFDTYP_PST.equals(cfad39sog00.getSzSndFndType()))){
	          if (CodesTables.CSUBTYPE_09.equals(ca.getCode()) || CodesTables.CSUBTYPE_07.equals(ca.getCode()) || CodesTables.CSUBTYPE_27.equals(ca.getCode())) {
	             if(!options.contains(ca)){
	             options.add(ca);
	             }
	          }
	        }
	        
	        //STGAP00014355: None Applicable deffered application populates the dropdown.
	        if(("N".equals(cfad39sog00.getBIndReasonSpecialRequest()) 
	          && (ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpcNeedsApproved()) || "D".equals(cfad39sog00.getBIndSpcNeedsApproved()))
	          && CodesTables.CAAFDTYP_IVE.equals(cfad39sog00.getSzSndFndType()))){
			   if (CodesTables.CSUBTYPE_01.equals(ca.getCode()) || CodesTables.CSUBTYPE_03.equals(ca.getCode()) || CodesTables.CSUBTYPE_26.equals(ca.getCode())) {
	             if(!options.contains(ca)){
	             options.add(ca);
	             }
	          }
	        }
		}
  }else{
    options.addAll(allOptions);
  }
}

    //STGAP00013779: Non Recurring Approved Date is Current date
	if(ArchitectureConstants.Y.equals(cfad39sog00.getBIndNonRecRequested()) 
	   && ArchitectureConstants.Y.equals(cfad39sog00.getBIndNonRecApproved())){
	        dtDtAdptSubApprvd = FormattingHelper.formatDate(DateHelper.getTodayCastorDate());
	}
	
   
//*************************************
//*** SET PAGE MODE and SAVE BUTTON ***
//*************************************

boolean bAdoptionSpec = user.hasRight( UserProfile.SEC_ADOPT_ASSIST_SPEC ) || user.hasRight(UserProfile.SEC_MTN_ADPT_SUB);

// PageMode can be MODIFY only if the user has adoption or maintainer or SAU privileges.
String pageMode = PageMode.getPageMode( request );
if (bAdoptionSpec)
{
   showSaveButton = true;
   adoassmemProtect = true;   
   adoptionSubsidyDisabled = "false";
   paymentChangedDisabled = "false"; 
}
else
{
     showSaveButton = false;
     adoptionSubsidyDisabled = "true";
     paymentChangedDisabled = "true";     
     pageMode = PageModeConstants.VIEW;
     adoassmemProtect = true;
}

 if ( pageMode.equals( PageModeConstants.VIEW ) )
{
     adoptionSubsidyDisabled = "true";
     paymentChangedDisabled = "true";  
     showSaveButton = false;
     adoassmemProtect = true;
}

String eventStatus = (cfad39sog00.getSzCdEventStatus() != null) ? cfad39sog00.getSzCdEventStatus() : "";

if(CodesTables.CEVTSTAT_COMP.equals(eventStatus)){
   if(cfad39sog00.getDtDtAdptSubTerm() != null && cfad39sog00.getSzCdAdptSubCloseRsn() != null){
       showSaveButton = false;
	   adoassmemProtect = true;
	   adoptionSubsidyDisabled = "true";
	   paymentChangedDisabled = "true"; 
   }else{
	   showSaveButton = true;
	   adoassmemProtect = true;
	   adoptionSubsidyDisabled = "true";
	   paymentChangedDisabled = "false"; 
   }
}

//STGAP00011192: getting the stage close indicator from state in order to prevent the
//Form to be edited for closed stage
String indStageClose = ( String ) state.getAttribute("IND_STAGE_CLOSE", request );
if (ArchitectureConstants.Y.equals(indStageClose)){
	adoassmemProtect = true;
}
// SMS#97845 MR-074-2 AFCARS: replaced childHasBeenInSubStage logic with Incident Status indicator from associated AAApplication  
String indIncidentChild = cfad39sog00.getCIndIncidentChildInPad();

%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
  IsDirty();
};

function showAlertMessageForAdd() {
<%
  if (PageModeConstants.NEW.equals( pageMode ) && ArchitectureConstants.Y.equals(cfad39sog00.getIndPriorEndedArgreement()))  {
%>
  alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_ADO_MAN_INV_ADOP_ASST ) %>" );
<%
  }
%>
}

// This function affects fields "txtDtDtAdptSubEffective" (start) and "selSzCdAdptSubDeterm" (type)
function openSubsidyMessage()
{
<%
// This function only prints an alert if the subsidy is open
// (meaning the subsidy has no closure reason and an the end date
// is after today.
  if ( !PageModeConstants.NEW.equals( pageMode ) )
  {

    // open adoption assistance =
    // no closed reason AND the end date is not null and after today
    if (
       ( "".equals(FormattingHelper.formatString( cfad39sog00.getSzCdAdptSubCloseRsn()) ) )
       &&
       ( cfad39sog00.getDtDtAdptSubEnd() != null && DateHelper.isAfterToday( cfad39sog00.getDtDtAdptSubEnd()  ) )
       )
      {
%>
  alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_SUB_AFFECT_PYMT ) %>" );
<%
      }
  }

%>
}


// It effects fields "txtDtDtAdptSubEffective" (start), "selSzCdAdptSubDeterm" (type),
// "txtDtDtAdptSubEnd" (end), and "txtSAmtAdptSub" (amount)
function closedSubsidyMessage()
{
<%
  // This function only prints an alert if the subsidy is closed,
  // meaning that a closure reason exists OR the end date is before today
  if ( !PageModeConstants.NEW.equals( pageMode ) )
  {

  // closed adoption assistance =
  // closed reason has a value in it OR end date is not null and before today
  if (
       ( !"".equals(FormattingHelper.formatString( cfad39sog00.getSzCdAdptSubCloseRsn()) ) )
       ||
       ( cfad39sog00.getDtDtAdptSubEnd() != null && DateHelper.isBeforeToday( cfad39sog00.getDtDtAdptSubEnd()  )     )
     )
    {
%>
      alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_SUB_AFFECT_PYMT ) %>" );
<%
    }
  }
%>
}

function checkNonrecurMessage()
{ 
  if(document.frmAdoptionAsstnc.txtSAmtAdptSub.value == "" || document.frmAdoptionAsstnc.txtSAmtAdptSub.value == 0.00 ||
  	document.frmAdoptionAsstnc.txtSAmtAdptSub.value == '$ 0.00')
  {
    if( !confirm("<%= MessageLookup.getMessageByNumber( Messages.MSG_NO_AMOUNT_IN_ADOPT_SUB ) %>" ) )
    {
      return false;
    }
  }
  return true;
}

// effects "selSzCdAdptSubDeterm" (type) and "txtDtDtAdptSubEnd" (end)
// displays a message if the type is 6 or 12
function endDateMessage()
{
  var endDate18 = "<%= endDate18 %>";
  var endDate21 = "<%= endDate21 %>";

  if( (( document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value == <%= CodesTables.CSUBTYPE_26 %>) ||
       ( document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value == <%= CodesTables.CSUBTYPE_27 %>) )
      &&
      ( betweenInclusive( endDate18,
                          document.frmAdoptionAsstnc.txtDtDtAdptSubEnd.value,
                          endDate21)
      )
    )
  {
    alert( "<%=  MessageLookup.getMessageByNumber( Messages.SSM_MEDICAID_21 ) %>" );
  }
}




function blankType()
{
  var blank = false;
<%  if ( !PageModeConstants.NEW.equals( pageMode ))
  {%>

  // Display the message MSG_FAD_SUB_TYPE_CHANGE to
  // indicate to the user that by deleting the Sub. Type some of the
  // detail fields will be altered.  In this case the Eff Date and
  // Amount fields will be cleared. This IF should only be
  // executed if the Adpt Sub Agree Returned Date is not present.

  if ((document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value == "") )
  {
       blank = confirm("<%=  MessageLookup.getMessageByNumber( Messages.MSG_FAD_SUB_TYPE_CHANGE ) %>");

  }
 
  if ( blank == true )
  {
       document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value = "";
       document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;
  }
  
  if ((blank == false)
      && (document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value == "" ))
  {
  // User chooses not to blank the Type.
       document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value = "<%=cfad39sog00.getSzCdAdptSubDeterm()%>";
  }
blank = false;
<%}%>
}


function changeType()
{
 confirm("<%=  MessageLookup.getMessageByNumber( Messages.MSG_FAD_SUB_TYPE_CHANGE ) %>");
}

function betweenInclusive( startDateString, middleDateString, endDateString )
{
  if (
        !validateDate( startDateString ) ||
        !validateDate( middleDateString ) ||
        !validateDate( endDateString )
     )
  {
    return false;
  }

  startDate = new Date( Date.parse(startDateString) );
  middleDate = new Date( Date.parse(middleDateString ) );
  endDate = new Date( Date.parse(endDateString ) );

  if ( ( startDate <= middleDate ) && ( middleDate <= endDate ) )
  {
    return true;
  }
  else
  {
    return false;
  }
}

//STGAP00013779: Modified this function to match the Design Document
function disableAmountField()
{
  var adoptType = document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value;
  if((adoptType == '<%= CodesTables.CSUBTYPE_26 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_27 %>' ))
  {
    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;
    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '$ 0.00';
  }

  if(('Y' == '<%=cfad39sog00.getBIndBasicRateReq()%>'
         && 'Y' == '<%= cfad39sog00.getBIndSpcNeedsApproved()%>')
         && ((adoptType == '<%= CodesTables.CSUBTYPE_01 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_03 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_07 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_09 %>' )))
  {
    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '<%= baseRate %>';
    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;
  }
  
   if(((adoptType == '<%= CodesTables.CSUBTYPE_01 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_03 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_07 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_09 %>' )))
  {
  if (document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value == "" ){
    document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value = '<%= FormattingHelper.formatDate(cfad39sog00.getDtDtPlcmtStart()) %>';
    }
  }
  
  /*STGAP00014155: Added code for deferred application also*/
  if(('Y' == '<%=cfad39sog00.getBIndBasicRateReq()%>'
         && 'D' == '<%= cfad39sog00.getBIndSpcNeedsApproved()%>')
         && ((adoptType == '<%= CodesTables.CSUBTYPE_01 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_03 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_07 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_09 %>' )))
  {
    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '$ 0.00';
    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;
  }
  
    if(('Y' == '<%=cfad39sog00.getBIndSpecializedRateReq()%>'
         && 'Y' == '<%=cfad39sog00.getBIndSpclRateAdoAppr()%>')
         && ((adoptType == '<%= CodesTables.CSUBTYPE_01 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_03 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_07 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_09 %>' )))
  {
    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '<%= FormattingHelper.formatMoney(cfad39sog00.getSzSpcRtAprvAmt()) %>';
    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;
  }
  
  if(('Y' == '<%=cfad39sog00.getBIndNonRecRequested()%>'
         && 'Y' == '<%=cfad39sog00.getBIndNonRecApproved()%>')
         && ((adoptType == '<%= CodesTables.CSUBTYPE_23 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_24 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_25 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_22 %>' )))
  {
    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = false;
  }
  
   if(((adoptType == '<%= CodesTables.CSUBTYPE_23 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_24 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_25 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_22 %>' )))
  {
    document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value = '<%= FormattingHelper.formatDate(DateHelper.getTodayCastorDate()) %>';
  }
  
  if(((adoptType == '<%= CodesTables.CSUBTYPE_26 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_27 %>' ) ))
  {
    document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value = '<%= FormattingHelper.formatDate(cfad39sog00.getDtDtPlcmtStart()) %>';
  }
  
  if(('Y' == '<%=cfad39sog00.getBIndSpclServiceReq()%>'
         && 'Y' == '<%=cfad39sog00.getBIndSpclReqApproved()%>')
         && ((adoptType == '<%= CodesTables.CSUBTYPE_10 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_18 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_21 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_28 %>' )
         ||(adoptType == '<%= CodesTables.CSUBTYPE_29 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_30 %>' )))
  {
    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '<%= FormattingHelper.formatMoney(cfad39sog00.getSzSpcSvcAprvAmt()) %>';
    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;
  }
  
  /*STGAP00014355: None Applicable deffered application populates the dropdown.*/
  if('N' == '<%=cfad39sog00.getBIndReasonSpecialRequest()%>' && ('D' == '<%= cfad39sog00.getBIndSpcNeedsApproved()%>'
         || 'Y' == '<%= cfad39sog00.getBIndSpcNeedsApproved()%>')
      && ((adoptType == '<%= CodesTables.CSUBTYPE_01 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_03 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_07 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_09 %>' )))
  {
    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;
    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '$ 0.00';
  }
  
  if((adoptType == "" )){
    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = false;
    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '';
    document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value = '';
  }
}

//STGAP00013779: Added this function to disable enable the payment method 
function disableEnablePaymentOfMethod(){
  var adoptType = document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value;
  if((adoptType == '<%= CodesTables.CSUBTYPE_10 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_18 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_21 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_28 %>' )
         ||(adoptType == '<%= CodesTables.CSUBTYPE_29 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_30 %>' ))
  {
    document.frmAdoptionAsstnc.txtSzCdPaymentMethod.disabled = false;
    document.frmAdoptionAsstnc.txtSzCdPaymentMethod.value = '<%= FormattingHelper.formatString(cfad39sog00.getSzCdPaymentMethodApp())%>';
  }else if((adoptType == '<%= CodesTables.CSUBTYPE_23 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_24 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_25 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_22 %>' )){
      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.disabled = false;
  }else if((adoptType == '<%= CodesTables.CSUBTYPE_01 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_03 %>' )  
         ||(adoptType == '<%= CodesTables.CSUBTYPE_07 %>' ) 
         ||(adoptType == '<%= CodesTables.CSUBTYPE_09 %>' )){
      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.value = '<%= FormattingHelper.formatString(CodesTables.CPAYMTHD_PAR)%>'; 
      //STGAP00014599: Disable payment method for basic and specialized rates  
      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.disabled = true; // STGAP00014114 
  }else{
      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.disabled = true;
      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.value = '';
  }
  
}

window.onload = function ()
  {
  	   disableAmountField();
  	   disableEnablePaymentOfMethod();
 }
</script>

<impact:validateErrors />
<impact:validateForm name="frmAdoptionAsstnc" method="post" action="/financials/AdoptionAsstnc/displayAdoptionAsstnc" validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.AdoptionAsstncCustomValidation"
  pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">


  <impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= DateHelper.toISOStringSafe( cfad39sog00.getTsLastUpdate() ) %>" />
  <impact:validateInput type="hidden" name="hdnUlIdEvent" value="<%= FormattingHelper.formatInt(cfad39so.getROWCCMN01UIG00().getUlIdEvent()) %>" />
  <impact:validateInput type="hidden" name="szCdEventStatus" value="<%= cfad39so.getROWCCMN01UIG00().getSzCdEventStatus() %>" />
  <impact:validateInput type="hidden" name="szCdLegalStatStatus" value="<%= cfad39so.getSzCdLegalStatStatus() %>" />
  <impact:validateInput type="hidden" name="bSysIndGeneric" value="<%= cfad39so.getCFAD39SOG00().getBSysIndGeneric() %>" />
  <impact:validateInput type="hidden" name="hdnDtDtCnperStart" value="<%= FormattingHelper.formatDate( cfad39so.getDtDtCnperStart()) %>" />
  <impact:validateInput type="hidden" name="pageName" value="<%= AdoptionAsstncConversation.ADOPTION_ASSTNC_PAGE %>" />
  <impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%=String.valueOf(cfad39so.getUlIdPerson())%>" />
  <impact:validateInput type="hidden" name="hdnDtDtPersonBirth" value="<%= dtDtPersonBirth %>" />
  <impact:validateInput type="hidden" name="hdnSpecialNeedsEvent" value="<%= String.valueOf(cfad39so.getCFAD39SOG00().getUlIdSpecialNeedsEvent()) %>" />
  <impact:validateInput type="hidden" name="hdnBaseRate" value="<%= String.valueOf(cfad39sog00.getSAmtAdptBaseRate()) %>" />
  <impact:validateInput type="hidden" name="cSysIndServiceAuthCurrent" value="<%= String.valueOf(cfad39so.getCSysIndServiceAuthCurrent()) %>" />
  <impact:validateInput type="hidden" name="hdnDtDtCnperTerm" value="<%= FormattingHelper.formatDate( cfad39so.getDtDtCnperTerm()) %>" />
  <impact:validateInput type="hidden" name="hdnBIndStageOpen" value="<%= FormattingHelper.formatString(cfad39so.getBIndStageOpen()) %>" />

   
  <%-- /*  Always include this hidden field in your form */ --%>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  
    <%-- /* Start the HTML for the page */ --%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="4">
        SAU Confirmation
      </th>
    </tr>
    <tr>
      <%
  //SIR 18490-- Changed the logic on how the Third Party Checkbox gets saved.
%>
      <td>
        <impact:validateInput label="Special Needs Determination is Complete?" name="cIndSauConf" type="checkbox" cssClass="formInput"
          checked="<%= String.valueOf(ArchitectureConstants.Y.equals(cfad39sog00.getCIndSauConf() )) %>" value="Y" disabled="true" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <% if(ArchitectureConstants.Y.equals(cfad39sog00.getCIndSauConf())){ %>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspDtDtSndAprv" label="Date Special Needs Determination Approved by SAU" value="<%= FormattingHelper.formatDate(cfad39sog00.getDtDtLatestSndAprv()) %>" />
      </td>
    </tr>
    <tr>
      <td>
      <% String fundingType = Lookup.simpleDecodeSafe(CodesTables.CAAFDTYP,FormattingHelper.formatString(cfad39sog00.getSzSndFndType()));
      %>
        <impact:validateDisplayOnlyField name="dspSzSndFndType" label="Funding Type" value="<%= fundingType %>" />
      </td>
     </tr>
     <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspSzSndAprvType" label="Special Needs Approval Type" value="<%= approvalType %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspSzNonRecAprvAmt" label="Non-Recurring Approved Amount" value="<%= FormattingHelper.formatMoney(cfad39sog00.getSzNonRecAprvAmt()) %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspSzSpcRtAprvAmt" label="Total Specialized Rate Approved Amount" value="<%= FormattingHelper.formatMoney(cfad39sog00.getSzSpcRtAprvAmt()) %>" />
      </td>
    </tr>
    <%}else{ 
    // SMS#97845 MR-074-2 AFCARS: 
    // Remove inapplicable logic as of the current business.
    // Simple condition: if a linked application not found then display message
    // Also added PAD stage checking since this message should only appear in PAD per design; 
    %> 
    <tr>
    <%if(CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request))) { %>
    <td>
      Special Needs Information Not Available.
    </td>
    <%}%>
    </tr>
    <%}%>
    </table>
    <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="4">
        Payee
      </th>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspSzNmResource" label="Name" value="<%= FormattingHelper.formatString(cfad39sog01.getSzNmResource()) %>" />
      </td>
      <td>
        <impact:validateDisplayOnlyField name="dspSzNbrRsrcVid" label="VID" value="<%= FormattingHelper.formatString(cfad39sog01.getSzNbrRsrcVid()) %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspSzAddrRsrcAddrStLn1" label="Street" value="<%= FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrStLn1()) %>" />
      </td>
    </tr>
    <% if ( StringHelper.isValid(cfad39sog01.getSzAddrRsrcAddrStLn2())) { %>
    <tr>
      <td>
        &nbsp;
      </td>
      <td>
        <impact:validateDisplayOnlyField name="dspSzAddrRsrcAddrStLn2" value="<%= FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrStLn2()) %>" />
      </td>
    </tr>
    <%}%>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspSzAddrRsrcAddrCity" label="City" value="<%= FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrCity()) %>" />
      </td>
      <td>
        <impact:validateDisplayOnlyField name="dspSzAddrRsrcAddrState" label="State" value="<%= FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrState())%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspSzCdFacilityCounty" label="County" value='<%=Lookup.simpleDecodeSafe( "CCOUNT",cfad39sog01.getSzCdFacilityCounty())%>' />
      </td>
      <td>
        <impact:validateDisplayOnlyField name="dspSzAddrRsrcAddrZip" label="Zip" value="<%=FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrZip() )%>" />
      </td>
    </tr>
    </table>
    
    
    <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan=4>
        Adoption Assistance Agreement Detail
      </th>
    </tr>
	    <% if (!StringHelper.EMPTY_STRING.equals(cdAdptSubDeterm)){
	       szCdAdptSubDeterm = cdAdptSubDeterm;
	     }
	     
	    if (StringHelper.EMPTY_STRING.equals(szCdAdptSubDeterm) || szCdAdptSubDeterm == null){
	       szCdAdptSubDeterm = ContextHelper.getStringSafe(request, "selSzCdAdptSubDeterm");
	     } %>
	 <tr>
      <td>
        <impact:validateSelect label="Type/Class of Assistance" onChange="endDateMessage();changeType();blankType();disableAmountField();disableEnablePaymentOfMethod();" name="selSzCdAdptSubDeterm" tabIndex="<%= tabIndex++ %>"
          codesTable="<%=CodesTables.CSUBTYPE%>" value="<%=szCdAdptSubDeterm%>" disabled="<%= adoptionSubsidyDisabled %>" blankValue="true"  required="true"
          options="<%= options %>"/>
      </td>
    </tr>
        <%
         if (!StringHelper.EMPTY_STRING.equals(adptSubApprvd)){
	       dtDtAdptSubApprvd = adptSubApprvd;
	     }
	     
	     if (StringHelper.EMPTY_STRING.equals(dtDtAdptSubApprvd) || dtDtAdptSubApprvd == null){
	       dtDtAdptSubApprvd = ContextHelper.getStringSafe(request, "txtDtDtAdptSubApprvd");
	     } 
	     
	     //STGAP00013960: Added code so that the page reloads with dates from table after saving
	     if(cfad39sog00.getDtDtAdptSubApprvd() == null){
	        if(ContextHelper.getString(request, ("btnCompletionCheck"+ ".x")) != null ||
		        ContextHelper.getString(request, ("btnSave"+ ".x")) != null){
		        dtDtAdptSubApprvd = ContextHelper.getStringSafe(request, "txtDtDtAdptSubApprvd");
	        }
	      }else{
	        dtDtAdptSubApprvd = FormattingHelper.formatDate(cfad39sog00.getDtDtAdptSubApprvd());
	      }
	     
	     String txtSAmtAdptSub = StringHelper.EMPTY_STRING;
	     if (cfad39sog00.getSAmtAdptSub() != 0.0){
	       txtSAmtAdptSub =  FormattingHelper.formatMoney( cfad39sog00.getSAmtAdptSub());
	     }else{
	       txtSAmtAdptSub = ContextHelper.getStringSafe(request, "txtSAmtAdptSub");
	       //STGAP00014208: The amount should be displayed as $0.00 when blank
	       if(StringHelper.EMPTY_STRING.equals(txtSAmtAdptSub)){
	         txtSAmtAdptSub = "$0.00";
	       }
	     }%>
     <tr>
      <td>
        <impact:validateDate type="text" name="txtDtDtAdptSubApprvd" label="Approved" constraint="Date" conditionallyRequired="true" value="<%=dtDtAdptSubApprvd%>" size="8" disabled="<%= adoptionSubsidyDisabled %>" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateInput type="text" name="txtSAmtAdptSub" label="Amount" constraint="Money" disabled="false" conditionallyRequired="true" cssClass="formInput"
          value="<%=txtSAmtAdptSub%>" size="10" maxLength="10" disabled="<%= adoptionSubsidyDisabled %>" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
	<% if (!StringHelper.EMPTY_STRING.equals(adptSubEffective)){
	       dtDtAdptSubEffective = adptSubEffective;
	     }
	     
	    if (StringHelper.EMPTY_STRING.equals(dtDtAdptSubEffective) || dtDtAdptSubEffective == null){
	       dtDtAdptSubEffective = ContextHelper.getStringSafe(request, "txtDtDtAdptSubEffective");
	     } 
	     
	     //STGAP00013960: Added code so that the page reloads with dates from table after saving
        if(cfad39sog00.getDtDtAdptSubEffective() == null){
	        if(ContextHelper.getString(request, ("btnCompletionCheck"+ ".x")) != null ||
		        ContextHelper.getString(request, ("btnSave"+ ".x")) != null){
		        dtDtAdptSubEffective = ContextHelper.getStringSafe(request, "txtDtDtAdptSubEffective");
	        }
	      }else{
	        dtDtAdptSubEffective = FormattingHelper.formatDate(cfad39sog00.getDtDtAdptSubEffective());
	   }
	   
	   if(cfad39sog00.getDtDtAdptSubTerm() != null){
           dtDtAdptSubTerminated = FormattingHelper.formatDate(cfad39sog00.getDtDtAdptSubTerm());
	   }
	    %>
    <tr>
      <td>
        <impact:validateDate type="text" name="txtDtDtAdptSubEffective" label="Agreement Start" conditionallyRequired="true" constraint="Date" value="<%=dtDtAdptSubEffective%>"
          size="8" disabled="<%= adoptionSubsidyDisabled %>" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:validateDate type="text" name="txtDtDtAdptSubTerminated" label="Agreement Terminated" onChange="openSubsidyMessage();closedSubsidyMessage();" conditionallyRequired="true" constraint="Date" value="<%=dtDtAdptSubTerminated%>"
         size="8" disabled="<%= paymentChangedDisabled %>" tabIndex="<%= tabIndex++ %>" />
      </td>
  </tr>
     <%
     //STGAP00013779:
     if (!StringHelper.EMPTY_STRING.equals(dtDtAdptSubEnd)){
       endDateValue = dtDtAdptSubEnd;
     }
     
     //STGAP00013960: Added code so that the page reloads with dates from table after saving
     if(cfad39sog00.getDtDtAdptSubEnd() == null){
	    if(ContextHelper.getString(request, ("btnCompletionCheck"+ ".x")) != null ||
		        ContextHelper.getString(request, ("btnSave"+ ".x")) != null){
		        endDateValue = ContextHelper.getStringSafe(request, "txtDtDtAdptSubEnd");
	        }
	    }else{
	        endDateValue = FormattingHelper.formatDate(cfad39sog00.getDtDtAdptSubEnd());
	 }
     
     if (!StringHelper.EMPTY_STRING.equals(szCdPaymentMethod)){
       paymentMethod = szCdPaymentMethod;
     }
     
    if (StringHelper.EMPTY_STRING.equals(paymentMethod) || paymentMethod == null){
       paymentMethod = ContextHelper.getStringSafe(request, "txtSzCdPaymentMethod");
     }
     %>
    <tr>
      <td>
        <impact:validateDate type="text" name="txtDtDtAdptSubEnd" label="Agreement End" onChange="endDateMessage();" conditionallyRequired="true" constraint="Date" disabled="<%= bAscr %>"
          value="<%=endDateValue%>" size="8" disabled="<%= adoptionSubsidyDisabled %>" tabIndex="<%= tabIndex++ %>" />
      </td>
   </tr>
   <tr>
      <td >
        <impact:validateSelect label="Payment Method" name="txtSzCdPaymentMethod" tabIndex="<%= tabIndex++ %>" codesTable="CPAYMTHD" disabled="<%= adoptionSubsidyDisabled %>" conditionallyRequired="true"
          value="<%=paymentMethod%>" blankValue="true" />
      </td>
    </tr>
    <%
 	   if(cfad39sog00.getSzCdAdptSubCloseRsn() != null){
           txtSzCdAdptSubCloseRsn =  FormattingHelper.formatString( cfad39sog00.getSzCdAdptSubCloseRsn() ) ;
	   }
     %>
    <tr>
      <td>
        <impact:validateSelect label="Payment Change" name="txtSzCdAdptSubCloseRsn" tabIndex="<%= tabIndex++ %>" codesTable="CSUBCLOS" disabled="<%= bAscr %>" excludeOptions="<%= exOptions %>"
          value="<%=txtSzCdAdptSubCloseRsn%>" disabled="<%= paymentChangedDisabled %>" blankValue="true" 
          onChange="openSubsidyMessage();closedSubsidyMessage();"/>
      </td>
    </tr>
     <%
     //STGAP00013779:  
     if (!StringHelper.EMPTY_STRING.equals(cbxCIndAdptSubThirdParty)){
       indAdptSubThirdParty = cbxCIndAdptSubThirdParty;
     }
     
    if (StringHelper.EMPTY_STRING.equals(indAdptSubThirdParty) || indAdptSubThirdParty == null ){
       indAdptSubThirdParty = ContextHelper.getStringSafe(request, "cbxCIndAdptSubThirdParty");
       if(ArchitectureConstants.TRUE.equals(indAdptSubThirdParty)){
         indAdptSubThirdParty = ArchitectureConstants.Y;
       }
     }
     
     if (!StringHelper.EMPTY_STRING.equals(cbxCIndAdptSchoolVerified)){
       indAdptSchoolVerified = cbxCIndAdptSchoolVerified;
     }
     
    if (StringHelper.EMPTY_STRING.equals(indAdptSchoolVerified) || indAdptSchoolVerified == null){
       indAdptSchoolVerified = ContextHelper.getStringSafe(request, "cbxCIndAdptSchoolVerified");
       if(ArchitectureConstants.TRUE.equals(indAdptSchoolVerified)){
         indAdptSchoolVerified = ArchitectureConstants.Y;
       }
     }
     %>
    <tr>
      <% //SIR 18490-- Changed the logic on how the Third Party Checkbox gets saved%>
      <td>
        <impact:validateInput label="Third-Party Insurance" name="cbxCIndAdptSubThirdParty" type="checkbox" cssClass="formInput" checked="<%= String.valueOf(ArchitectureConstants.Y.equals(indAdptSubThirdParty)) %>" value="Y"
          disabled="<%= adoptionSubsidyDisabled %>" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td colspan=2>
        <impact:validateInput label="Full Time School Enrollment Verified" name="cbxCIndAdptSchoolVerified"  colspan="4" type="checkbox" cssClass="formInput" checked="<%= String.valueOf(ArchitectureConstants.Y.equals(indAdptSchoolVerified)) %>" value="Y"
          disabled="<%= adoptionSubsidyDisabled %>" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
     <%
     //STGAP00013779:
     if (!StringHelper.EMPTY_STRING.equals(szTxtAdptSubRsn)){
       txtAdptSubRsn = szTxtAdptSubRsn;
     }
     
     if (StringHelper.EMPTY_STRING.equals(txtAdptSubRsn) ||txtAdptSubRsn == null ){
       txtAdptSubRsn = ContextHelper.getStringSafe(request, "txtSzTxtAdptSubRsn");
     }
     
     if (!StringHelper.EMPTY_STRING.equals(szTxtSpclAsstCmnts)){
       txtSpclAsstCmnts = szTxtSpclAsstCmnts;
     }
     %>
    <tr>
      <td>
        <impact:validateTextArea name="txtSzTxtAdptSubRsn" label="Comments" rows="4" cols="110" colspan="4" tabIndex="<%= tabIndex++ %>" maxLength="1000" disabled="<%= paymentChangedDisabled %>" constraint="Comments">
          <%=txtAdptSubRsn%>
        </impact:validateTextArea>
      </td>
    </tr>
   </table>     
   
  
    <table width="100%">
      <tr>

<%
//*****************
//**** BUTTONS ****
//*****************
// Display the save button if the user has Adoption Assistance skill
// privileges and the PageMode is not VIEW and the assistance is open. But
// also if closed and PageMode is not VIEW, user has maintainer and skill.
if (showSaveButton == true) {
%>
     <td align="right">
        <impact:ButtonTag
            name="btnCompletionCheck"
            img="btnCompleteQ"
            align="right"
            form="frmAdoptionAsstnc"
            action="/financials/AdoptionAsstnc/completeAdoptionAsstnc"
            restrictRepost="true"
            preventDoubleClick="true"
            tabIndex="<%= tabIndex++ %>"/>
     </td>
	<td class="alignRight" width="5%">
        <impact:ButtonTag name="btnSave" 
            img="btnSave" align="right" 
            form="frmAdoptionAsstnc" 
            restrictRepost="true" 
            preventDoubleClick="true" 
            function="javascript:return checkNonrecurMessage()" 
            action="/financials/AdoptionAsstnc/saveAdoptionAsstnc"
            tabIndex="<%= tabIndex++ %>" />
    </td>
<%} %>
    </tr>
  </table>
   
</impact:validateForm>

<!--<%-->
//**********************************************
//**** ADOPTION ASSISTANCE ELIGIBILITY FORM ****
//**********************************************
<!--%>-->
<% 
 if (StringHelper.EMPTY_STRING.equals(eventStatus)) {
%>
<script type="text/javascript" language="JavaScript1.2">
    window.attachEvent("onload", showAlertMessageForAdd);
  </script>
<%
  }
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
	<% /* begin Forms and Reports  */ %>
  	<tr>
    	<th colspan="2">Forms</th>
  	</tr>
  	<tr>
    	<td>
    	<impact:documentList pageMode="edit" tabIndex="<%= tabIndex++ %>">
    	<%
    		// only show forms if event is COMP
    		if(eventStatus.equals(CodesTables.CEVTSTAT_COMP)) {
    	%>
			  <impact:document displayName="Adoption Assistance Agreement"
			  				   protectDocument="true" 
			  				   docType="adoassistagrmnt"
			  				   preFillAlways="true" 
			  				   docExists="true">
				<impact:documentParameter name="pPerson"
									value="<%= String.valueOf(cfad39so.getUlIdPerson()) %>"/>
			    <impact:documentParameter name="pStage"
			                        value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
			    <impact:documentParameter name="pCase"
			                        value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>
			    <impact:documentParameter name="pEvent"
			                        value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>
			  </impact:document>
			  <impact:document displayName="Adoption Assistance Memorandum"
			                        protectDocument="<%= adoassmemProtect %>"
			                        docType="adoassmem"
			                        preFillAlways="true"
			                        docExists="true"
			                        >
				<impact:documentParameter name="pIdAdoptSub"
									value="<%= idAdptSub %>"/>
			    <impact:documentParameter name="pStage"
			                        value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
			    <impact:documentParameter name="pCase"
			                        value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>
			    <impact:documentParameter name="pEvent"
			                        value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>
			  </impact:document>
	    <%
	   	     }
	    %>
	
			</impact:documentList>
	    </td>
	    <td style="color:#0000C7">Effective March 18, 2012, the system logic was changed to allow SSAU to select the agreement type (Initial/Amended) on the approval of the Adoption Assistance Application. For Applications approved prior to March 18, 2012, validate that the correct agreement type (Initial/Amended) displays on the launched Adoption Assistance Agreement. If the agreement type displays incorrectly, contact SSAU prior to signing the launched agreement.</td>
  	</tr>
<% /* end Forms and Reports */ %>
</table>


