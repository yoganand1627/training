package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.financials.AdoptionAsstncConversation;
import gov.georgia.dhr.dfcs.sacwis.web.financials.AdoptionAsstncCustomValidation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import java.util.Collection;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import java.util.Iterator;

public final class AdoptionAsstnc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


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


      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction showAlertMessageForAdd() {\r\n");

  if (PageModeConstants.NEW.equals( pageMode ) && ArchitectureConstants.Y.equals(cfad39sog00.getIndPriorEndedArgreement()))  {

      out.write("\r\n  alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_ADO_MAN_INV_ADOP_ASST ) );
      out.write("\" );\r\n");

  }

      out.write("\r\n}\r\n\r\n// This function affects fields \"txtDtDtAdptSubEffective\" (start) and \"selSzCdAdptSubDeterm\" (type)\r\nfunction openSubsidyMessage()\r\n{\r\n");

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

      out.write("\r\n  alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SUB_AFFECT_PYMT ) );
      out.write("\" );\r\n");

      }
  }


      out.write("\r\n}\r\n\r\n\r\n// It effects fields \"txtDtDtAdptSubEffective\" (start), \"selSzCdAdptSubDeterm\" (type),\r\n// \"txtDtDtAdptSubEnd\" (end), and \"txtSAmtAdptSub\" (amount)\r\nfunction closedSubsidyMessage()\r\n{\r\n");

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

      out.write("\r\n      alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SUB_AFFECT_PYMT ) );
      out.write("\" );\r\n");

    }
  }

      out.write("\r\n}\r\n\r\nfunction checkNonrecurMessage()\r\n{ \r\n  if(document.frmAdoptionAsstnc.txtSAmtAdptSub.value == \"\" || document.frmAdoptionAsstnc.txtSAmtAdptSub.value == 0.00 ||\r\n  \tdocument.frmAdoptionAsstnc.txtSAmtAdptSub.value == '$ 0.00')\r\n  {\r\n    if( !confirm(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_NO_AMOUNT_IN_ADOPT_SUB ) );
      out.write("\" ) )\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n  return true;\r\n}\r\n\r\n// effects \"selSzCdAdptSubDeterm\" (type) and \"txtDtDtAdptSubEnd\" (end)\r\n// displays a message if the type is 6 or 12\r\nfunction endDateMessage()\r\n{\r\n  var endDate18 = \"");
      out.print( endDate18 );
      out.write("\";\r\n  var endDate21 = \"");
      out.print( endDate21 );
      out.write("\";\r\n\r\n  if( (( document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value == ");
      out.print( CodesTables.CSUBTYPE_26 );
      out.write(") ||\r\n       ( document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value == ");
      out.print( CodesTables.CSUBTYPE_27 );
      out.write(") )\r\n      &&\r\n      ( betweenInclusive( endDate18,\r\n                          document.frmAdoptionAsstnc.txtDtDtAdptSubEnd.value,\r\n                          endDate21)\r\n      )\r\n    )\r\n  {\r\n    alert( \"");
      out.print(  MessageLookup.getMessageByNumber( Messages.SSM_MEDICAID_21 ) );
      out.write("\" );\r\n  }\r\n}\r\n\r\n\r\n\r\n\r\nfunction blankType()\r\n{\r\n  var blank = false;\r\n");
  if ( !PageModeConstants.NEW.equals( pageMode ))
  {
      out.write("\r\n\r\n  // Display the message MSG_FAD_SUB_TYPE_CHANGE to\r\n  // indicate to the user that by deleting the Sub. Type some of the\r\n  // detail fields will be altered.  In this case the Eff Date and\r\n  // Amount fields will be cleared. This IF should only be\r\n  // executed if the Adpt Sub Agree Returned Date is not present.\r\n\r\n  if ((document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value == \"\") )\r\n  {\r\n       blank = confirm(\"");
      out.print(  MessageLookup.getMessageByNumber( Messages.MSG_FAD_SUB_TYPE_CHANGE ) );
      out.write("\");\r\n\r\n  }\r\n \r\n  if ( blank == true )\r\n  {\r\n       document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value = \"\";\r\n       document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;\r\n  }\r\n  \r\n  if ((blank == false)\r\n      && (document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value == \"\" ))\r\n  {\r\n  // User chooses not to blank the Type.\r\n       document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value = \"");
      out.print(cfad39sog00.getSzCdAdptSubDeterm());
      out.write("\";\r\n  }\r\nblank = false;\r\n");
}
      out.write("\r\n}\r\n\r\n\r\nfunction changeType()\r\n{\r\n confirm(\"");
      out.print(  MessageLookup.getMessageByNumber( Messages.MSG_FAD_SUB_TYPE_CHANGE ) );
      out.write("\");\r\n}\r\n\r\nfunction betweenInclusive( startDateString, middleDateString, endDateString )\r\n{\r\n  if (\r\n        !validateDate( startDateString ) ||\r\n        !validateDate( middleDateString ) ||\r\n        !validateDate( endDateString )\r\n     )\r\n  {\r\n    return false;\r\n  }\r\n\r\n  startDate = new Date( Date.parse(startDateString) );\r\n  middleDate = new Date( Date.parse(middleDateString ) );\r\n  endDate = new Date( Date.parse(endDateString ) );\r\n\r\n  if ( ( startDate <= middleDate ) && ( middleDate <= endDate ) )\r\n  {\r\n    return true;\r\n  }\r\n  else\r\n  {\r\n    return false;\r\n  }\r\n}\r\n\r\n//STGAP00013779: Modified this function to match the Design Document\r\nfunction disableAmountField()\r\n{\r\n  var adoptType = document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value;\r\n  if((adoptType == '");
      out.print( CodesTables.CSUBTYPE_26 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_27 );
      out.write("' ))\r\n  {\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '$ 0.00';\r\n  }\r\n\r\n  if(('Y' == '");
      out.print(cfad39sog00.getBIndBasicRateReq());
      out.write("'\r\n         && 'Y' == '");
      out.print( cfad39sog00.getBIndSpcNeedsApproved());
      out.write("')\r\n         && ((adoptType == '");
      out.print( CodesTables.CSUBTYPE_01 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_03 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_07 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_09 );
      out.write("' )))\r\n  {\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '");
      out.print( baseRate );
      out.write("';\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;\r\n  }\r\n  \r\n   if(((adoptType == '");
      out.print( CodesTables.CSUBTYPE_01 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_03 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_07 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_09 );
      out.write("' )))\r\n  {\r\n  if (document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value == \"\" ){\r\n    document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value = '");
      out.print( FormattingHelper.formatDate(cfad39sog00.getDtDtPlcmtStart()) );
      out.write("';\r\n    }\r\n  }\r\n  \r\n  /*STGAP00014155: Added code for deferred application also*/\r\n  if(('Y' == '");
      out.print(cfad39sog00.getBIndBasicRateReq());
      out.write("'\r\n         && 'D' == '");
      out.print( cfad39sog00.getBIndSpcNeedsApproved());
      out.write("')\r\n         && ((adoptType == '");
      out.print( CodesTables.CSUBTYPE_01 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_03 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_07 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_09 );
      out.write("' )))\r\n  {\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '$ 0.00';\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;\r\n  }\r\n  \r\n    if(('Y' == '");
      out.print(cfad39sog00.getBIndSpecializedRateReq());
      out.write("'\r\n         && 'Y' == '");
      out.print(cfad39sog00.getBIndSpclRateAdoAppr());
      out.write("')\r\n         && ((adoptType == '");
      out.print( CodesTables.CSUBTYPE_01 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_03 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_07 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_09 );
      out.write("' )))\r\n  {\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '");
      out.print( FormattingHelper.formatMoney(cfad39sog00.getSzSpcRtAprvAmt()) );
      out.write("';\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;\r\n  }\r\n  \r\n  if(('Y' == '");
      out.print(cfad39sog00.getBIndNonRecRequested());
      out.write("'\r\n         && 'Y' == '");
      out.print(cfad39sog00.getBIndNonRecApproved());
      out.write("')\r\n         && ((adoptType == '");
      out.print( CodesTables.CSUBTYPE_23 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_24 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_25 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_22 );
      out.write("' )))\r\n  {\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = false;\r\n  }\r\n  \r\n   if(((adoptType == '");
      out.print( CodesTables.CSUBTYPE_23 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_24 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_25 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_22 );
      out.write("' )))\r\n  {\r\n    document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value = '");
      out.print( FormattingHelper.formatDate(DateHelper.getTodayCastorDate()) );
      out.write("';\r\n  }\r\n  \r\n  if(((adoptType == '");
      out.print( CodesTables.CSUBTYPE_26 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_27 );
      out.write("' ) ))\r\n  {\r\n    document.frmAdoptionAsstnc.txtDtDtAdptSubEffective.value = '");
      out.print( FormattingHelper.formatDate(cfad39sog00.getDtDtPlcmtStart()) );
      out.write("';\r\n  }\r\n  \r\n  if(('Y' == '");
      out.print(cfad39sog00.getBIndSpclServiceReq());
      out.write("'\r\n         && 'Y' == '");
      out.print(cfad39sog00.getBIndSpclReqApproved());
      out.write("')\r\n         && ((adoptType == '");
      out.print( CodesTables.CSUBTYPE_10 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_18 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_21 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_28 );
      out.write("' )\r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_29 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_30 );
      out.write("' )))\r\n  {\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '");
      out.print( FormattingHelper.formatMoney(cfad39sog00.getSzSpcSvcAprvAmt()) );
      out.write("';\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;\r\n  }\r\n  \r\n  /*STGAP00014355: None Applicable deffered application populates the dropdown.*/\r\n  if('N' == '");
      out.print(cfad39sog00.getBIndReasonSpecialRequest());
      out.write("' && ('D' == '");
      out.print( cfad39sog00.getBIndSpcNeedsApproved());
      out.write("'\r\n         || 'Y' == '");
      out.print( cfad39sog00.getBIndSpcNeedsApproved());
      out.write("')\r\n      && ((adoptType == '");
      out.print( CodesTables.CSUBTYPE_01 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_03 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_07 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_09 );
      out.write("' )))\r\n  {\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = true;\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '$ 0.00';\r\n  }\r\n  \r\n  if((adoptType == \"\" )){\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.disabled = false;\r\n    document.frmAdoptionAsstnc.txtSAmtAdptSub.value = '';\r\n    document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value = '';\r\n  }\r\n}\r\n\r\n//STGAP00013779: Added this function to disable enable the payment method \r\nfunction disableEnablePaymentOfMethod(){\r\n  var adoptType = document.frmAdoptionAsstnc.selSzCdAdptSubDeterm.value;\r\n  if((adoptType == '");
      out.print( CodesTables.CSUBTYPE_10 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_18 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_21 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_28 );
      out.write("' )\r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_29 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_30 );
      out.write("' ))\r\n  {\r\n    document.frmAdoptionAsstnc.txtSzCdPaymentMethod.disabled = false;\r\n    document.frmAdoptionAsstnc.txtSzCdPaymentMethod.value = '");
      out.print( FormattingHelper.formatString(cfad39sog00.getSzCdPaymentMethodApp()));
      out.write("';\r\n  }else if((adoptType == '");
      out.print( CodesTables.CSUBTYPE_23 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_24 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_25 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_22 );
      out.write("' )){\r\n      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.disabled = false;\r\n  }else if((adoptType == '");
      out.print( CodesTables.CSUBTYPE_01 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_03 );
      out.write("' )  \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_07 );
      out.write("' ) \r\n         ||(adoptType == '");
      out.print( CodesTables.CSUBTYPE_09 );
      out.write("' )){\r\n      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.value = '");
      out.print( FormattingHelper.formatString(CodesTables.CPAYMTHD_PAR));
      out.write("'; \r\n      //STGAP00014599: Disable payment method for basic and specialized rates  \r\n      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.disabled = true; // STGAP00014114 \r\n  }else{\r\n      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.disabled = true;\r\n      document.frmAdoptionAsstnc.txtSzCdPaymentMethod.value = '';\r\n  }\r\n  \r\n}\r\n\r\nwindow.onload = function ()\r\n  {\r\n  \t   disableAmountField();\r\n  \t   disableEnablePaymentOfMethod();\r\n }\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAdoptionAsstnc");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/AdoptionAsstnc/displayAdoptionAsstnc");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.AdoptionAsstncCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_0.setValue( DateHelper.toISOStringSafe( cfad39sog00.getTsLastUpdate() ) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnUlIdEvent");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(cfad39so.getROWCCMN01UIG00().getUlIdEvent()) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("szCdEventStatus");
          _jspx_th_impact_validateInput_2.setValue( cfad39so.getROWCCMN01UIG00().getSzCdEventStatus() );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("szCdLegalStatStatus");
          _jspx_th_impact_validateInput_3.setValue( cfad39so.getSzCdLegalStatStatus() );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("bSysIndGeneric");
          _jspx_th_impact_validateInput_4.setValue( cfad39so.getCFAD39SOG00().getBSysIndGeneric() );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnDtDtCnperStart");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatDate( cfad39so.getDtDtCnperStart()) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("pageName");
          _jspx_th_impact_validateInput_6.setValue( AdoptionAsstncConversation.ADOPTION_ASSTNC_PAGE );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnUlIdPerson");
          _jspx_th_impact_validateInput_7.setValue(String.valueOf(cfad39so.getUlIdPerson()));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnDtDtPersonBirth");
          _jspx_th_impact_validateInput_8.setValue( dtDtPersonBirth );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnSpecialNeedsEvent");
          _jspx_th_impact_validateInput_9.setValue( String.valueOf(cfad39so.getCFAD39SOG00().getUlIdSpecialNeedsEvent()) );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnBaseRate");
          _jspx_th_impact_validateInput_10.setValue( String.valueOf(cfad39sog00.getSAmtAdptBaseRate()) );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("cSysIndServiceAuthCurrent");
          _jspx_th_impact_validateInput_11.setValue( String.valueOf(cfad39so.getCSysIndServiceAuthCurrent()) );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnDtDtCnperTerm");
          _jspx_th_impact_validateInput_12.setValue( FormattingHelper.formatDate( cfad39so.getDtDtCnperTerm()) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnBIndStageOpen");
          _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatString(cfad39so.getBIndStageOpen()) );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n   \r\n  ");
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n  \r\n    ");
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        SAU Confirmation\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      ");

  //SIR 18490-- Changed the logic on how the Third Party Checkbox gets saved.

          out.write("\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setLabel("Special Needs Determination is Complete?");
          _jspx_th_impact_validateInput_14.setName("cIndSauConf");
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setChecked( String.valueOf(ArchitectureConstants.Y.equals(cfad39sog00.getCIndSauConf() )) );
          _jspx_th_impact_validateInput_14.setValue("Y");
          _jspx_th_impact_validateInput_14.setDisabled("true");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
 if(ArchitectureConstants.Y.equals(cfad39sog00.getCIndSauConf())){ 
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspDtDtSndAprv");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Date Special Needs Determination Approved by SAU");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatDate(cfad39sog00.getDtDtLatestSndAprv()) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n      ");
 String fundingType = Lookup.simpleDecodeSafe(CodesTables.CAAFDTYP,FormattingHelper.formatString(cfad39sog00.getSzSndFndType()));
      
          out.write("\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspSzSndFndType");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Funding Type");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( fundingType );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n     </tr>\r\n     <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspSzSndAprvType");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Special Needs Approval Type");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( approvalType );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspSzNonRecAprvAmt");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Non-Recurring Approved Amount");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( FormattingHelper.formatMoney(cfad39sog00.getSzNonRecAprvAmt()) );
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dspSzSpcRtAprvAmt");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Total Specialized Rate Approved Amount");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatMoney(cfad39sog00.getSzSpcRtAprvAmt()) );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
}else{ 
    // SMS#97845 MR-074-2 AFCARS: 
    // Remove inapplicable logic as of the current business.
    // Simple condition: if a linked application not found then display message
    // Also added PAD stage checking since this message should only appear in PAD per design; 
    
          out.write(" \r\n    <tr>\r\n    ");
if(CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request))) { 
          out.write("\r\n    <td>\r\n      Special Needs Information Not Available.\r\n    </td>\r\n    ");
}
          out.write("\r\n    </tr>\r\n    ");
}
          out.write("\r\n    </table>\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Payee\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dspSzNmResource");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatString(cfad39sog01.getSzNmResource()) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("dspSzNbrRsrcVid");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("VID");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue( FormattingHelper.formatString(cfad39sog01.getSzNbrRsrcVid()) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("dspSzAddrRsrcAddrStLn1");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Street");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue( FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrStLn1()) );
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
 if ( StringHelper.isValid(cfad39sog01.getSzAddrRsrcAddrStLn2())) { 
          out.write("\r\n    <tr>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("dspSzAddrRsrcAddrStLn2");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue( FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrStLn2()) );
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
}
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("dspSzAddrRsrcAddrCity");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("City");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue( FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrCity()) );
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("dspSzAddrRsrcAddrState");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("State");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue( FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrState()));
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_11.setName("dspSzCdFacilityCounty");
          _jspx_th_impact_validateDisplayOnlyField_11.setLabel("County");
          _jspx_th_impact_validateDisplayOnlyField_11.setValue(Lookup.simpleDecodeSafe( "CCOUNT",cfad39sog01.getSzCdFacilityCounty()));
          int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_12.setName("dspSzAddrRsrcAddrZip");
          _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Zip");
          _jspx_th_impact_validateDisplayOnlyField_12.setValue(FormattingHelper.formatString(cfad39sog01.getSzAddrRsrcAddrZip() ));
          int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    </table>\r\n    \r\n    \r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=4>\r\n        Adoption Assistance Agreement Detail\r\n      </th>\r\n    </tr>\r\n\t    ");
 if (!StringHelper.EMPTY_STRING.equals(cdAdptSubDeterm)){
	       szCdAdptSubDeterm = cdAdptSubDeterm;
	     }
	     
	    if (StringHelper.EMPTY_STRING.equals(szCdAdptSubDeterm) || szCdAdptSubDeterm == null){
	       szCdAdptSubDeterm = ContextHelper.getStringSafe(request, "selSzCdAdptSubDeterm");
	     } 
          out.write("\r\n\t <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type/Class of Assistance");
          _jspx_th_impact_validateSelect_0.setOnChange("endDateMessage();changeType();blankType();disableAmountField();disableEnablePaymentOfMethod();");
          _jspx_th_impact_validateSelect_0.setName("selSzCdAdptSubDeterm");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CSUBTYPE);
          _jspx_th_impact_validateSelect_0.setValue(szCdAdptSubDeterm);
          _jspx_th_impact_validateSelect_0.setDisabled( adoptionSubsidyDisabled );
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setOptions( options );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n        ");

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
	     }
          out.write("\r\n     <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("txtDtDtAdptSubApprvd");
          _jspx_th_impact_validateDate_0.setLabel("Approved");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setValue(dtDtAdptSubApprvd);
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setDisabled( adoptionSubsidyDisabled );
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setName("txtSAmtAdptSub");
          _jspx_th_impact_validateInput_15.setLabel("Amount");
          _jspx_th_impact_validateInput_15.setConstraint("Money");
          _jspx_th_impact_validateInput_15.setDisabled("false");
          _jspx_th_impact_validateInput_15.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setValue(txtSAmtAdptSub);
          _jspx_th_impact_validateInput_15.setSize("10");
          _jspx_th_impact_validateInput_15.setMaxLength("10");
          _jspx_th_impact_validateInput_15.setDisabled( adoptionSubsidyDisabled );
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\t");
 if (!StringHelper.EMPTY_STRING.equals(adptSubEffective)){
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
	    
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setName("txtDtDtAdptSubEffective");
          _jspx_th_impact_validateDate_1.setLabel("Agreement Start");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue(dtDtAdptSubEffective);
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setDisabled( adoptionSubsidyDisabled );
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setName("txtDtDtAdptSubTerminated");
          _jspx_th_impact_validateDate_2.setLabel("Agreement Terminated");
          _jspx_th_impact_validateDate_2.setOnChange("openSubsidyMessage();closedSubsidyMessage();");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setValue(dtDtAdptSubTerminated);
          _jspx_th_impact_validateDate_2.setSize("8");
          _jspx_th_impact_validateDate_2.setDisabled( paymentChangedDisabled );
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n  </tr>\r\n     ");

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
     
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setName("txtDtDtAdptSubEnd");
          _jspx_th_impact_validateDate_3.setLabel("Agreement End");
          _jspx_th_impact_validateDate_3.setOnChange("endDateMessage();");
          _jspx_th_impact_validateDate_3.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setDisabled( bAscr );
          _jspx_th_impact_validateDate_3.setValue(endDateValue);
          _jspx_th_impact_validateDate_3.setSize("8");
          _jspx_th_impact_validateDate_3.setDisabled( adoptionSubsidyDisabled );
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n   </tr>\r\n   <tr>\r\n      <td >\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Payment Method");
          _jspx_th_impact_validateSelect_1.setName("txtSzCdPaymentMethod");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CPAYMTHD");
          _jspx_th_impact_validateSelect_1.setDisabled( adoptionSubsidyDisabled );
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setValue(paymentMethod);
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");

 	   if(cfad39sog00.getSzCdAdptSubCloseRsn() != null){
           txtSzCdAdptSubCloseRsn =  FormattingHelper.formatString( cfad39sog00.getSzCdAdptSubCloseRsn() ) ;
	   }
     
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Payment Change");
          _jspx_th_impact_validateSelect_2.setName("txtSzCdAdptSubCloseRsn");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable("CSUBCLOS");
          _jspx_th_impact_validateSelect_2.setDisabled( bAscr );
          _jspx_th_impact_validateSelect_2.setExcludeOptions( exOptions );
          _jspx_th_impact_validateSelect_2.setValue(txtSzCdAdptSubCloseRsn);
          _jspx_th_impact_validateSelect_2.setDisabled( paymentChangedDisabled );
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setOnChange("openSubsidyMessage();closedSubsidyMessage();");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n     ");

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
     
          out.write("\r\n    <tr>\r\n      ");
 //SIR 18490-- Changed the logic on how the Third Party Checkbox gets saved
          out.write("\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setLabel("Third-Party Insurance");
          _jspx_th_impact_validateInput_16.setName("cbxCIndAdptSubThirdParty");
          _jspx_th_impact_validateInput_16.setType("checkbox");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setChecked( String.valueOf(ArchitectureConstants.Y.equals(indAdptSubThirdParty)) );
          _jspx_th_impact_validateInput_16.setValue("Y");
          _jspx_th_impact_validateInput_16.setDisabled( adoptionSubsidyDisabled );
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=2>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setLabel("Full Time School Enrollment Verified");
          _jspx_th_impact_validateInput_17.setName("cbxCIndAdptSchoolVerified");
          _jspx_th_impact_validateInput_17.setColspan("4");
          _jspx_th_impact_validateInput_17.setType("checkbox");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setChecked( String.valueOf(ArchitectureConstants.Y.equals(indAdptSchoolVerified)) );
          _jspx_th_impact_validateInput_17.setValue("Y");
          _jspx_th_impact_validateInput_17.setDisabled( adoptionSubsidyDisabled );
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n     ");

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
     
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtAdptSubRsn");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("110");
          _jspx_th_impact_validateTextArea_0.setColspan("4");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setDisabled( paymentChangedDisabled );
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(txtAdptSubRsn);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n   </table>     \r\n   \r\n  \r\n    <table width=\"100%\">\r\n      <tr>\r\n\r\n");

//*****************
//**** BUTTONS ****
//*****************
// Display the save button if the user has Adoption Assistance skill
// privileges and the PageMode is not VIEW and the assistance is open. But
// also if closed and PageMode is not VIEW, user has maintainer and skill.
if (showSaveButton == true) {

          out.write("\r\n     <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnCompletionCheck");
          _jspx_th_impact_ButtonTag_0.setImg("btnCompleteQ");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmAdoptionAsstnc");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/AdoptionAsstnc/completeAdoptionAsstnc");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n\t<td class=\"alignRight\" width=\"5%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmAdoptionAsstnc");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setFunction("javascript:return checkNonrecurMessage()");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/AdoptionAsstnc/saveAdoptionAsstnc");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");
} 
          out.write("\r\n    </tr>\r\n  </table>\r\n   \r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<!--");
      out.write("-->\r\n");
 
 if (StringHelper.EMPTY_STRING.equals(eventStatus)) {

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n    window.attachEvent(\"onload\", showAlertMessageForAdd);\r\n  </script>\r\n");

  }

      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t");
 /* begin Forms and Reports  */ 
      out.write("\r\n  \t<tr>\r\n    \t<th colspan=\"2\">Forms</th>\r\n  \t</tr>\r\n  \t<tr>\r\n    \t<td>\r\n    \t");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode("edit");
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    \t");

    		// only show forms if event is COMP
    		if(eventStatus.equals(CodesTables.CEVTSTAT_COMP)) {
    	
          out.write("\r\n\t\t\t  ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Adoption Assistance Agreement");
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setDocType("adoassistagrmnt");
          _jspx_th_impact_document_0.setPreFillAlways(true);
          _jspx_th_impact_document_0.setDocExists(true);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pPerson");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(cfad39so.getUlIdPerson()) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pCase");
              _jspx_th_impact_documentParameter_2.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pEvent");
              _jspx_th_impact_documentParameter_3.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t  ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_1.setDisplayName("Adoption Assistance Memorandum");
          _jspx_th_impact_document_1.setProtectDocument( adoassmemProtect );
          _jspx_th_impact_document_1.setDocType("adoassmem");
          _jspx_th_impact_document_1.setPreFillAlways(true);
          _jspx_th_impact_document_1.setDocExists(true);
          int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
          if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_4.setName("pIdAdoptSub");
              _jspx_th_impact_documentParameter_4.setValue( idAdptSub );
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_5.setName("pStage");
              _jspx_th_impact_documentParameter_5.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_6 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_6.setName("pCase");
              _jspx_th_impact_documentParameter_6.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_6 = _jspx_th_impact_documentParameter_6.doStartTag();
              if (_jspx_th_impact_documentParameter_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_7 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_7.setName("pEvent");
              _jspx_th_impact_documentParameter_7.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_7 = _jspx_th_impact_documentParameter_7.doStartTag();
              if (_jspx_th_impact_documentParameter_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  ");
              int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t    ");

	   	     }
	    
          out.write("\r\n\t\r\n\t\t\t");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t    </td>\r\n\t    <td style=\"color:#0000C7\">Effective March 18, 2012, the system logic was changed to allow SSAU to select the agreement type (Initial/Amended) on the approval of the Adoption Assistance Application. For Applications approved prior to March 18, 2012, validate that the correct agreement type (Initial/Amended) displays on the launched Adoption Assistance Agreement. If the agreement type displays incorrectly, contact SSAU prior to signing the launched agreement.</td>\r\n  \t</tr>\r\n");
 /* end Forms and Reports */ 
      out.write("\r\n</table>\r\n\r\n\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
