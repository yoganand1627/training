package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Collections;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import java.util.Comparator;

public final class HomeInfrmtn_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Home Information
//*  Created by:   Heather Dean
//*  Date Created: 1/23/03
//*
//*
//*  Description:
//*              The F/A Home Demographics section will be used by
//*              developers to enter, maintain, or view the demographic
//*              information about a foster or adoptive home.
//*              The Home Interest section will allow the user to enter information
//*              about a foster or adoptive home's interest in a child(ren).
//*              The section also allows the user to enter comments about the
//*              homes interests in a Comments field.  If a field is left
//*              blank, it means the home is not interested in that criteria.
//*              For example, if the Male Age Range is left blank, it means
//*              the home is not interested in fostering or adopting male
//*              children.
//*              The Foster/Adoptive Home Close/Re-open Home section allows
//*              the user to submit a home for closure or re-open a home.
//*              When closing a home the user will access the To-Do detail
//*              page to send the closure for approval.  When re-opening a
//*              home, the user will access the Assign page to assign the
//*              home to a worker on the system.  Data retrieval (cfad30s)
//*              and saving (cfad36s) services will be used for this section
//*              The F/A Home License section is used to record or view the
//*              licensing and status information for the home.
//*
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  01/23/03  Heather Dean      Initial jsp creation
  07/08/03  GRIMSHAN          Hide the save and submit button if we are in
                              approval mode
  07/09/03  Todd Reser        SIR 18710 - Added call to CategoryChange() on load
                              so the appropriate widgets will be enabled or
                              disabled.  Added logic to CategoryChange to
                              Disable widgets in the Foster Home Type Section if
                              the category is "A" - Adoptive.
  07/15/03  ochumd            sir #18717 - It was decided during the design
                              phase of FAD that the Home Re-open section would
                              not be needed because staff could just change the
                              Status of a closed home to Inquiry, Recruit or
                              Applicant (for PRS homes) or to Approved-Active if
                              the home was a Non-FPS Adoptive home and Save &
                              Assign this home with a new status.  In IMPACT,
                              all fields are protected, including the Status,
                              therefore one was unable to re-open a closed home.
                              The status field is now enabled when status of a
                              home is closed.
  07/18/03  Todd Reser        SIR 18710 - Pulled code out of CategoryChange to
                              create disableFHType().  Added call to
                              disableFHType in checkNonPrsHome().

  07/23/2003 Eric Dickman     SIR 19032 -- If the NAH checkbox is checked
                              and the selCategory is
                              Adoptive, the user can't save the page.
  07/23/2003 Eric Dickman     SIR 19050 -- The disableFHType should not be
                              called when the pageMode is View
  08/08/2003 CASDORJM         SIR 19404 - Corrected the fix for SIR 19050
                              and added in logic to clear the Foster Home
                              Type checkboxes before they were disabled.
  08/12/2003 CASDORJM         Removed blank value from select.
  03/06/04   RIOSJA           SIR 22555 - Removed if statement that set closureDate
                              only if event type was CCL because event type is
                              always HME, so closureDate was never being set and
                              was unable to Custom Validation class.
  7/09/2004   gerryc           SIR 16052 - changed page so it gets the home
                              status from the request first, then the service
                              output.
  10/19/2004 gerryc            SIR 23122 - fixed logic around pending closures
                              and pending approvals.  If the user navigates to
                              this page via a to do, and it's pending closure,
                              the status field is disabled. Also changed it so
                              reloadReject is attached to the onload event, to
                              avoid a hiddenFieldStateForm undefined error.
  4/18/05  Hadjimh         SIR#23327. Add a new field to the Home Information page. This new
                          field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
                          Adoptive Home checkbox is checked, staff will have to select a
                          'Certifying Entity'. to indicate the certifying agency
                           2) This will be a required field when the Non-FPS Adoptive Home
                           checkbox is checked for a home. 3) If a user is modifying an
                           existing Non-FPS Adoptive Home, this new field will be required,
                           unless the home status is also being changed to 'Pending Closure'
                           or 'Closed'.
  09/02/05  Hadjimh        SIR#23734: Non-FPS Adoptive Homes do not require approval to close,
                           although both a Save & Submit and a Save button are displayed. If the
                           user changes the status of the home to Closed and either fails to enter
                           a Reason for Closure OR clicks the Save & Submit pb, the correct
                           messages display, however the Save & Submit and Save pbs disappear
                           and are replaced with a Save & Assign pb. User must refresh the
                           page in order to get the Save pb to appear. The Save & Assign pb
                           must only display when adding a new home or when re-opening an
                           already closed home. The Save & Submit and Save pbs should continue
                           to appear, even if there are errors.
  11/01/06  aaodutayo      SHINES release 2 changes.Additional fields included by section are
           				   Home Info section - AD Exchge Status; Waiver Exists
           				   Home Demographics -
           				   Changed all references of NAH checkbox to chkIndNonDFCSHome.
           
 03/06/08  cwells          SIR #STGAP00004620  Added code to sort the elementry, middle, and high schools by 
 						   Alphabetic order when the district is selected  
 								 
 03/27/08  charden		   took out section of code that was calculating openSlots based on placement
 
 4/09/08   cwells          STGAP00007365 Checking the Status reason section to see if we are going to clear the 
 						   Status reason section 
 								 
 								 
 05/19/08  charden		   STGAP00006457 set code to calculate open slots based on placement and capacity	
 
 09/15/08  cwells          STGAP00007301 when the home has been closed then the fields are disabled.  But, 
 						   when the home is placed back into inquiry(reopened) then the fields should be 
 						   enabled again. 		
 							
9/22/08    cwells          STGAP00006748  When home is in pending closure and a application error is given 
						   Moving the home status back to approved and disabling the field to be modified  	
						   
 10/20/08   mxpatel        STGAP00010156: commented out disable functions which was disabling the validations
                            for the page when primary address and/or phone radio buttons were selected.
                            Also added code to disable validation when deleting an address or phone. 
1/05/09     hjbaptiste     STGAP00006457: Added a javascript alert box to inform and prevent user from setting
                           Capacity lower than Placements - function preventOverCapacity()     
2/15/09     vdevarak	   STGAP00012476: Added the new date field 'Date Applied' to the inquiry section of the page.   
05/25/2010  arege          SMS54783 Document button should be hidden for anybody who is not SAU_Sealed or who does not have stage access
06/08/2010  arege          SMS54783 Document should not be modifiable if the home is closed.
06/14/2010  arege          SMS#54783 SAU_SEALED person who is not assigned to FAD stage should not be able to modify the documents
11/12/2010  schoi		   SMS #81140: MR-074 Filter Marital Status dropdown to exclude 'Unmarried Couple'
12/04/2010  schoi 		   SMS #81140: MR-074 Added condition to enable the error validation 
						   after submitting the page to the supervisor
01/04/2011  schoi          SMS #81140: MR-074 Updated code per outstanding peer review item (minor) to call validation
						   only when supervisor (approver) clicks Approval Status button after the page submission
01/04/2011  schoi          SMS #81140: MR-074 Reverted code back to the same version as of 12/04/2010; 
						   Made necessary change in the HomeInfrmtnCustomValidation.java instead						   						   
03/20/2011  hnguyen        SMS#97850: MR-075 Updated page display logic to allow save in approval mode.
03/26/2011  hnguyen        SMS#97850: MR-075 Updated page display logic to handle Hold placement submission, rejection, and JS validation.
10/4/2011   charden		   STGAP00017058 - added code to make address detail page link available to FISC_OPS_MAINT users
10/07/2011  cwells         ECEM 5.0 Adding changes to allow all characteristics to be added for child interest  
04/11/2012  cminor		   STGAP00017883 Added alert to warn user that changing the home Category will 
						   require a home closure and thus effect future and current placements                                  					   							 
*/ 								      


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<!--Start Main Content-->\r\n");

BaseSessionStateManager state = (BaseSessionStateManager)
  request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  
String globalIdStage = String.valueOf(GlobalData.getUlIdStage(request));

int tabIndex = 1;
boolean isClosed = false;
boolean bHideSaveButton = false;
boolean bHideSaveSubmitButton = false;
boolean bHideDeleteButton = false;
boolean bHideApproveButton = true;
boolean bHideDocumentButton = false;
boolean bDisableAllFields = false;
boolean bDisableLicensing = false;
boolean bHideCloseHomeSection = false;
boolean bHideReopenHomeSection = true;
boolean bDisableStatusField = false;
boolean bDisableCategoryField = false;
boolean bDisableClosureFields = false;
boolean bHideAssignButton = true;
boolean bDisableOnHold = true;
boolean bAnnualMarital = false;
org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());
org.exolab.castor.types.Date marriageDate = null;
String tsLastUpdate = null;
String pageMode = PageMode.getPageMode(request);
    boolean bCommentsExist = false;
String isAdd = "";
int intResourceHistoryID = 0;
//ROWCFAD07SOG04 info.
String homeName = "";
String legalName = "";
int idResource = 0;
String categoryD =  null;
String statusD = HomeInfrmtnConversation.CODE_STATUS_INQUIRY;
//String ethnicity = null;
String language = null;
String religion = null;
String maritalStatus = null;
String annualIncome = null;
String inquirySource = null;
String respite = null;
String county = null;
String schoolDistrict = null;
String elementary = null;
String middle = null;
String high = null;
 
// SMS #81140: MR-074 Filter Marital Status dropdown to exclude 'Unmarried Couple'
List excludeFAMSTRC = new ArrayList();
excludeFAMSTRC.add(CodesTables.CFAMSTRC_19);

/* SIR#23327. added certifyEntity */
String certifyEntity = null;
boolean isNonDFCSHome = false;
/* changed isCurrHomeSdyExst to currHomeStud */
boolean isCurrHomeSdyExst = false;
boolean isPrevHomeStdy = false;
Date timestamp = new Date();
//ROWCFAD07SOG05 info.
int maleMinInterestInMonths = 0;
int maleMaxInterestInMonths = 0;
int femaleMinInterestInMonths = 0;
int femaleMaxInterestInMonths = 0;
int numberOfChildren = 0;
boolean willTransport = false;
boolean emergencyPlacements = false;
boolean specChildren = false;
String homeInterestComments = "";
String txtHmPrgInterest = "";
String newStatus = (String) request.getAttribute("newStatus");
boolean editPlusVendorId = request.getAttribute("editPlus") != null ? true : false;


//Child Ethnicities, Child Races, Child Characteristics, Programs Of Interest
Collection ethnicities = Lookup.getCategoryCodesCollection(CodesTables.CINDETHN);
Iterator ethnicitiesIterator = ethnicities.iterator();

Collection races = Lookup.getCategoryCodesCollection(CodesTables.CADRACE);
Iterator racesIterator = races.iterator();


Comparator<CodeAttributes> sortDecode = new Comparator<CodeAttributes>(){
  public int compare(CodeAttributes c1, CodeAttributes c2) {
    return c1.getDecode().compareTo(c2.getDecode());
  }
};






ROWCFAD07SOG03_ARRAY ethnicitiesArray = null;
ROWCFAD07SOG03 thisEthnicity = null;
HomeRaceSO thisRace = null;
HomeRaceSO_ARRAY racesArray = null;
ROWCFAD07SOG02_ARRAY characteristicsArray = null;
ROWCFAD07SOG02 thisCharacteristic = null;

//Address List, Phone List
ROWCFAD07SOG00_ARRAY phoneList = null;
Enumeration phoneEnumeration = null;
ROWCFAD07SOG00 phoneRow = null;
ROWCFAD07SOG01_ARRAY addressList = null;
Enumeration addressEnumeration = null;
ROWCFAD07SOG01 addressRow = null;

//Home License (cfad37s)
int licenseEventID = 0;
boolean isOnHold = false;
boolean bDocumentExists = false;
String licenseCategory = "";
String licenseStatus = "";
int capacity = 0;
int placements = 0;
int openSlots = 0;
int maleMaxAgeInMonths = 0;
int maleMinAgeInMonths = 0;
int femaleMaxAgeInMonths = 0;
int femaleMinAgeInMonths = 0;
String fosterHomeType = "";
String launchDoc = (String) state.getAttribute("launchDoc", request);
Date timestampLIC = new Date();
String cdExchangeStat = "";
boolean isWaiverExists = false;
Date dtApprovalBegin = null, dtApprovalEnd = null;
String iveReimbursable = "";
String resourceStatus = "";

//Home Applicant(homeApplicantRetrieve)
//inquiry info section
int idHomeApplicant = 0;
Date inquiryDate = null;
Date dtApplied = null;
String inqRecvdBy = null;
String infoPacktRequested = null;
Date infPacktSent = null;
int iRequestedNbrOfChildren = 0;
String childSpecInterest = null;
String inquiryComments = null;
   
 // orientation preservice section
Date dtOrientation1 = null;
Date dtOrientation2 = null;
Date dtOrientation3 = null;
String strOrientationStatus1 = null;
String strOrientationStatus2 = null;
String strOrientationStatus3 = null;
Date dtInvitation1 = null;
String strInvitationStatus1 = null;
String strLocation1 = null;
Date dtInvitation2 = null;
String strInvitationStatus2 = null;
String strLocation2 = null;
Date dtInvitation3 = null;
String strInvitationStatus3 = null;
String strLocation3 = null;
String orientationComments = null;
ROWCFAD07SOG07 thisPrgrmOfInterest = null;
ROWCFAD07SOG07_ARRAY prgrmOfInterestArray = null;
ROWCFAD07SOG07 sourceOfInquiry = null;
ROWCFAD07SOG07_ARRAY arraySourceOfInquiry = null;
ROWCFAD07SOG07 informationCovered = null;
ROWCFAD07SOG07_ARRAY arrayInformationCovered = null;

//Close Home (cfad30s)
String currentStatus = "";
String changeTo = "";
String closureReason = "";
String involuntaryClosure = "";
String recommendReopen = "";
String closureBlob = "";
org.exolab.castor.types.Date closureDate = null;
String statusRsnComments = "";

//Home Study Section
Date dtFosterParentManual = null;
Date dtFosterParentBill = null;

UserProfile user = UserProfileHelper.getUserProfile(request);
int userID = 0;
if (user != null)
{
  userID = user.getUserID();
}

SortedMap years = new TreeMap();
if (state.getAttribute("years", request) != null)
{
  years = (SortedMap) state.getAttribute("years", request);
}
SortedMap months = new TreeMap();
if (state.getAttribute("months", request) != null)
{
  months = (SortedMap) state.getAttribute("months", request);
}
SortedMap statuses = new TreeMap();
if (state.getAttribute("restrictedStatusOptions", request) != null)
{
  statuses = (SortedMap) state.getAttribute("restrictedStatusOptions", request);
}

Collection yearOptions = years.values();
Collection monthOptions = months.values();
Collection statusOptions = statuses.values();

/* SIR# 18826. if CODE_STATUS_PENDING_APPROVAL or CODE_STATUS_PENDING_CLOSURE
** is not in the drop down box, Save And Submit Button should be hidden (Ransier D).
*  The codes for pending statuses have changed as a result the above will hold for
* CODE_STATUS_PEND_FULL_APP, CODE_STATUS_PEND_SPEC_APP and CODE_STATUS_PEND_TEMP_APP
* (aaodutayo)
*/
Iterator it = statusOptions.iterator();
boolean bPendingExists = false;
while (it.hasNext())
{
  Option op = (Option)it.next();
  if (op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP) ||
      op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP) ||
      op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY) ||
      op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY) ||
      op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP) ||
      op.getCode().equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE))
  {
    bPendingExists = true;
  }
}
bHideSaveSubmitButton = !bPendingExists;
/*end SIR#18826 */

CFAD07SO cfad07so = (CFAD07SO) state.getAttribute(HomeInfrmtnConversation.STR_CFAD07SO, request);

if (cfad07so != null)
{
  //ROWCFAD07SOG04
  /* SIR#23327. added certifyEntity */
  certifyEntity = FormattingHelper.formatString( cfad07so.getROWCFAD07SOG04().getSzTxtNdfcsCertEntity() );
  marriageDate = cfad07so.getROWCFAD07SOG04().getDtDtRshsMarriage();
  maritalStatus = cfad07so.getROWCFAD07SOG04().getSzCdRshsMaritalStatus();
  homeName = cfad07so.getROWCFAD07SOG04().getSzNmRshsResource();
  legalName = cfad07so.getROWCFAD07SOG04().getSzNmLegal();
  idResource = cfad07so.getROWCFAD07SOG04().getUlIdResource();
  categoryD = FormattingHelper.formatString( cfad07so.getROWCFAD07SOG04().getSzCdRshsCategory() );
  /*
    SIR 16052 - the status is set to approved active by javascript when clicking
    on the Non-FPS Adoptive Home Checkbox.  If a further javascript error results
    on Save, get the home status from the request object, since it won't be in the
    database yet
  */
  if (request.getParameter("selStatus") != null)
  {
    statusD = request.getParameter("selStatus");
  }
  else
  {
    statusD = cfad07so.getROWCFAD07SOG04().getSzCdRshsFaHomeStatus();
  }
  county = cfad07so.getROWCFAD07SOG04().getSzCdRshsCnty();
  //ethnicity = cfad07so.getROWCFAD07SOG04().getSzCdRshsEthnicity();
  language = cfad07so.getROWCFAD07SOG04().getSzCdRshsLanguage();
  religion = cfad07so.getROWCFAD07SOG04().getSzCdRshsReligion();
  double inc = cfad07so.getROWCFAD07SOG04().getDNbrRshsAnnualIncome();
  if(cfad07so.getROWCFAD07SOG04().getDNbrRshsAnnualIncome() != 0){
  annualIncome = FormattingHelper.formatMoney(inc) ;
  }
  else{
  annualIncome = FormattingHelper.formatString(null) ;
  }
  
  
  inquirySource = cfad07so.getROWCFAD07SOG04().getSzCdRshsSourceInquiry();
  respite = cfad07so.getROWCFAD07SOG04().getSzCdRshsRespite();
  schoolDistrict = cfad07so.getROWCFAD07SOG04().getSzCdSchoolDistrict();
  elementary = cfad07so.getROWCFAD07SOG04().getSzCdElementary();
  middle = cfad07so.getROWCFAD07SOG04().getSzCdMiddle();
  high = cfad07so.getROWCFAD07SOG04().getSzCdHigh();
  if ("Y".equals(cfad07so.getROWCFAD07SOG04().getCIndRshsNonDFCSHome()))
  {
    isNonDFCSHome = true;
  }
  if ("Y".equals(cfad07so.getROWCFAD07SOG04().getCIndCurrHomeStudyExists()))
  {
    isCurrHomeSdyExst = true;
  }
  if("Y".equals( cfad07so.getROWCFAD07SOG04().getCIndPrevFamilyStudyReq() ) )
  {
     isPrevHomeStdy = true;
  }
  
  timestamp = cfad07so.getROWCFAD07SOG04().getTsLastUpdate();

  //ROWCFAD07SOG05
  maleMinInterestInMonths = cfad07so.getROWCFAD07SOG05().getUNbrRsrcIntMaAgeMin();
  maleMaxInterestInMonths = cfad07so.getROWCFAD07SOG05().getUNbrRsrcIntMaAgeMax();
  femaleMinInterestInMonths = cfad07so.getROWCFAD07SOG05().getUNbrRsrcIntFeAgeMin();
  femaleMaxInterestInMonths = cfad07so.getROWCFAD07SOG05().getUNbrRsrcIntFeAgeMax();
  numberOfChildren = cfad07so.getROWCFAD07SOG05().getUNbrRsrcIntChildren();
  if ("Y".equals(cfad07so.getROWCFAD07SOG05().getCIndRsrcTransport()))
  {
    willTransport = true;
  }
  if ("Y".equals(cfad07so.getROWCFAD07SOG05().getCIndRsrcEmergPlace()))
  {
    emergencyPlacements = true;
  }
  if ("Y".equals(cfad07so.getROWCFAD07SOG05().getCIndSpecificChild()))
  {
    specChildren = true;
  }  
  homeInterestComments = StringHelper.getNonNullString( cfad07so.getROWCFAD07SOG05().getSzTxtRsrcComments() );
  
  txtHmPrgInterest = StringHelper.getNonNullString( cfad07so.getROWCFAD07SOG05().getTxtHmPrgInterest() );

  //Child Ethnicities, Child Races, Child Characteristics, Programs Of Interst
  ethnicitiesArray = cfad07so.getROWCFAD07SOG03_ARRAY();
  racesArray = cfad07so.getHomeRaceSO_ARRAY();

  characteristicsArray = cfad07so.getROWCFAD07SOG02_ARRAY();


  //Address List, Phone List
  addressList = cfad07so.getROWCFAD07SOG01_ARRAY();
  addressEnumeration = addressList.enumerateROWCFAD07SOG01();
  phoneList = cfad07so.getROWCFAD07SOG00_ARRAY();
  phoneEnumeration = phoneList.enumerateROWCFAD07SOG00();
}
else
{
  cfad07so = new CFAD07SO();
}

String originalStatus = Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, statusD);
String originalCategory = Lookup.simpleDecodeSafe(CodesTables.CFACATEG, categoryD);


CFAD37SO cfad37so = (CFAD37SO) state.getAttribute("CFAD37SO", request);
if (cfad37so != null)
{
  // If status and category are supposed to be blank, they'll be the same in both places.
  // If historical cfad07s was called, they'll be blank there but not in cfad37so.
  if (statusD == null || "".equals(statusD))
  {
    statusD = cfad37so.getSzCdRsrcFaHomeStatus();
  }
  if (categoryD == null || "".equals(categoryD))
  {
    categoryD = cfad37so.getSzCdRsrcCategory();
  }
  timestampLIC = cfad37so.getTsLastUpdate();
  licenseCategory = cfad37so.getSzCdRsrcCategory();
  licenseStatus = cfad37so.getSzCdRsrcFaHomeStatus();
  placements = cfad37so.getUlSysNbrGenericCntr();
  capacity = cfad37so.getUNbrRsrcFacilCapacity();
  openSlots = capacity - placements;
  iveReimbursable = StringHelper.getNonNullString(cfad37so.getBIndHomeIveReimbursable());
  if(ArchitectureConstants.Y.equals(iveReimbursable)){
    iveReimbursable = "Yes";
  }else if(ArchitectureConstants.N.equals(iveReimbursable)){
    iveReimbursable = "No";
  }
  fosterHomeType = cfad37so.getCCdRsrcFaHomeType1_CFAD37SO();
  maleMaxAgeInMonths = cfad37so.getUNbrRsrcMlAgeMax();
  maleMinAgeInMonths = cfad37so.getUNbrRsrcMlAgeMin();
  femaleMaxAgeInMonths = cfad37so.getUNbrRsrcFMAgeMax();
  femaleMinAgeInMonths = cfad37so.getUNbrRsrcFMAgeMin();
  cdExchangeStat = cfad37so.getSzCdAdExchangeStat();
  dtApprovalBegin = cfad37so.getDtDtApprvlBegin();
  dtApprovalEnd = cfad37so.getDtDtApprvlEnd();
  dtFosterParentManual = cfad37so.getDtFosterParentManual();
  dtFosterParentBill = cfad37so.getDtFosterParentBill();
  String faHomeStatus = cfad37so.getSzCdRsrcFaHomeStatus();
  resourceStatus = cfad37so.getSzCdRsrcStatus();

  if (ArchitectureConstants.Y.equals(cfad37so.getBIndBLOBExistsInDatabase()))
  {
    bDocumentExists = true;
  }

  if (HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE.equals(statusD))
  {
    if (!bDocumentExists)
    {
      bHideDocumentButton = true;
    }
  }
  if(ArchitectureConstants.Y.equals(cfad37so.getBIndWaiver()))
  {
     isWaiverExists = true;
  }  
  
  if(ArchitectureConstants.Y.equals(cfad37so.getBIndHoldPlacements()))
  {
     isOnHold = true;
  }  
  
  licenseEventID = cfad37so.getROWCCMN01UIG00().getUlIdEvent();
}
else
{
  cfad37so = new CFAD37SO();
}

HomeApplicantRetrieveSO homeapplicantretrieveso = null;

if (state.getAttribute(HomeInfrmtnConversation.STR_HOMEAPPLICANTRETRIEVESO, request) != null)
{
  homeapplicantretrieveso = (HomeApplicantRetrieveSO) state.getAttribute(HomeInfrmtnConversation.STR_HOMEAPPLICANTRETRIEVESO, request);
}
if (homeapplicantretrieveso != null)
{
 idHomeApplicant = homeapplicantretrieveso.getIdHomeApplicant();
 inquiryDate = homeapplicantretrieveso.getInquiryDate();
 dtApplied = homeapplicantretrieveso.getDtApplied();
 inqRecvdBy = StringHelper.getNonNullString( homeapplicantretrieveso.getInqRecvdBy() );
 infoPacktRequested = StringHelper.getNonNullString( homeapplicantretrieveso.getInfoPacktRequested() );
 infPacktSent = homeapplicantretrieveso.getInfPacktSent();
 iRequestedNbrOfChildren = homeapplicantretrieveso.getIRequestedNbrOfChildren();
 childSpecInterest = homeapplicantretrieveso.getChildSpecInterest();
 inquiryComments = StringHelper.getNonNullString( homeapplicantretrieveso.getInquiryComments() );
   
 // orientation preservice section
 dtOrientation1 = homeapplicantretrieveso.getDtOrientation1();
 dtOrientation2 = homeapplicantretrieveso.getDtOrientation2();
 dtOrientation3 = homeapplicantretrieveso.getDtOrientation3();
 strOrientationStatus1 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrOrientationStatus1() );
 strOrientationStatus2 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrOrientationStatus2() );
 strOrientationStatus3 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrOrientationStatus3() );
 dtInvitation1 = homeapplicantretrieveso.getDtInvitation1();
 strInvitationStatus1 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrInvitationStatus1() );
 strLocation1 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrLocation1() );
 dtInvitation2 = homeapplicantretrieveso.getDtInvitation2();
 strInvitationStatus2 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrInvitationStatus2() );
 strLocation2 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrLocation2() );
 dtInvitation3 = homeapplicantretrieveso.getDtInvitation3();
 strInvitationStatus3 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrInvitationStatus3() );
 strLocation3 = StringHelper.getNonNullString( homeapplicantretrieveso.getStrLocation3() );
 orientationComments = StringHelper.getNonNullString( homeapplicantretrieveso.getOrientationComments() );
 prgrmOfInterestArray = homeapplicantretrieveso.getArrayProgramsOfInterest();
 arraySourceOfInquiry = homeapplicantretrieveso.getArraySourceOfInquiry();
 arrayInformationCovered = homeapplicantretrieveso.getArrayInformationCovered();
}
else
{
   homeapplicantretrieveso = new HomeApplicantRetrieveSO();
}


if (!bDocumentExists && pageMode.equals(PageModeConstants.VIEW))
{
  bHideDocumentButton = true;
}

CFAD30SO cfad30so = null;

if (state.getAttribute("CFAD30SO", request) != null)
{
  cfad30so = (CFAD30SO) state.getAttribute("CFAD30SO", request);
}
 	
if (cfad30so != null)
{
  closureReason = cfad30so.getSzCdRsrcClosureRsn();
  involuntaryClosure = cfad30so.getSzCdRsrcInvolClosure();
  recommendReopen = cfad30so.getSzCdRsrcRecmndReopen();
  closureBlob = cfad30so.getBIndBLOBExistsInDatabase();
  // RIOSJA, SIR 22555 - Removed if statement that set closureDate
  // only if event type was CCL because event type is always HME,
  // so closureDate was never being set and was unable to Custom
  // Validation class.
  closureDate = cfad30so.getROWCCMN01UIG00().getDtDtEventOccurred();
  statusRsnComments = StringHelper.getNonNullString( cfad30so.getSzTxtStatusRsnComments() );
}

if(closureReason == null || involuntaryClosure == null ||
recommendReopen == null || closureDate == null || statusRsnComments == null)
{
  cfad30so = new CFAD30SO();
  statusD = cfad07so.getROWCFAD07SOG04().getSzCdRshsFaHomeStatus();
  bDisableStatusField = false;
}

// EVENT INFORMATION

// We set the task code based on what was originally retrieved for
// the status.
String taskCode = HomeInfrmtnConversation.TASK_MNTN_LIC;
if (HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE.equals(statusD))
{
  taskCode = HomeInfrmtnConversation.TASK_CLOSE_HOME;
}
String eventStatus =
  CaseUtility.getSzCdEventStatus(GlobalData.getUlIdEvent(request));

boolean hasBeenSubmitted = false;
if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request)))
{
  bHideApproveButton = false;
  hasBeenSubmitted = true;
}
//Set values according to Home Status
//SIR# 23734. added !closureReason.equals( StringHelper.EMPTY_STRING) to
// the if statement. there must be a closure reason if status is closed.
if (HomeInfrmtnConversation.CODE_STATUS_CLOSED.equals(statusD) &&
    !StringHelper.EMPTY_STRING.equals(closureReason))
{
  isClosed = true;
  bDisableAllFields = true;
  bDisableLicensing = true;
  bHideAssignButton = false;
  bDisableCategoryField = true;
  bDisableClosureFields = true;
  bDisableStatusField = false;
  bHideSaveButton = true;
  bHideSaveSubmitButton = true;
  if (!bDocumentExists)
  {
    bHideDocumentButton = true;
  }
}
else if (statusD.equals(HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE) )
{
  bDisableAllFields = false;
  bDisableLicensing = false;
  bDisableClosureFields = false;
  bHideAssignButton = true;
  bDisableCategoryField = false;
  bHideSaveButton = true;
  bDisableStatusField = false;
  bHideSaveSubmitButton = false;
    
  if( GlobalData.isApprovalMode(request) ){
    bDisableStatusField = true;
    bHideSaveButton = false;
    bHideSaveSubmitButton = true;
  }
  
  if (!bDocumentExists)
  {
    bHideDocumentButton = true;
  }
}
else if (HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP.equals(statusD) ||
	 HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP.equals(statusD) ||
     HomeInfrmtnConversation.CODE_STATUS_PEND_FULL_APP_30_DAY.equals(statusD) ||
     HomeInfrmtnConversation.CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(statusD) ||
     HomeInfrmtnConversation.CODE_STATUS_PEND_UNAPPROVE.equals(statusD) ||
	 HomeInfrmtnConversation.CODE_STATUS_PEND_TEMP_APP.equals(statusD))
{
    bDisableAllFields = false;
    bDisableLicensing = false;
    bDisableClosureFields = false;
    bHideAssignButton = true;
    bDisableCategoryField = false;
    bDisableStatusField = false;
    bHideSaveButton = true;
    bHideSaveSubmitButton = false;
   // this indicator used to require the annual income and the marital status fields
   bAnnualMarital = true;  

   if( GlobalData.isApprovalMode(request) ){
     bDisableStatusField = true;
     bHideSaveButton = false;
     bHideSaveSubmitButton = true;
   }
    
}
else if (HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE.equals(statusD) ||
	 HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(statusD) ||
     HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY.equals(statusD) ||
     HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY.equals(statusD) ||
     HomeInfrmtnConversation.CODE_STATUS_UNAPPROVED.equals(statusD) ||
	 HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE.equals(statusD))
{
  bDisableAllFields = false;
  bDisableLicensing = false;
  bDisableOnHold = false;
  bDisableClosureFields = false;
  bHideSaveButton = false;
  bHideSaveSubmitButton = false;
  bHideAssignButton = true;
  bDisableCategoryField = false;
  
  // MR-075 While pending approval for Hold Placement change and accessed by approver,
  // disable all fields except Hold Placement checkbox
  // Supervisor must reject to make changes.
  if( GlobalData.isApprovalMode(request)){
    bDisableAllFields = true;
    bDisableCategoryField = true;
    bDisableLicensing = true;
    bDisableClosureFields = true;
    bDisableStatusField = true;
    bHideSaveButton = false;
    bHideSaveSubmitButton = true;
  }else if(!GlobalData.isApprovalMode(request) && HomeInfrmtnConversation.EVENT_STATUS_PEND.equals(eventStatus)){
    // MR-075 While pending approval for Hold Placement change and accessed by CM,
    // disable all fields except Hold Placement checkbox and submit button
    bDisableAllFields = true;
    bDisableCategoryField = true;
    bDisableLicensing = true;
    bDisableClosureFields = true;
    bDisableStatusField = true;
    bHideSaveButton = false;
    bHideSaveSubmitButton = true;
  }else if(!GlobalData.isApprovalMode(request) &&
         !HomeInfrmtnConversation.EVENT_STATUS_PEND.equals(eventStatus) &&
         ((HomeInfrmtnConversation.RSRC_STAT_ACTIVE.equals(resourceStatus) && isOnHold) ||
         (!HomeInfrmtnConversation.RSRC_STAT_ACTIVE.equals(resourceStatus) && !isOnHold))){
    // MR-075 Approval for Hold Placement change was invalidated and accessed by CM/Supervisor,
    // disable all fields except Hold Placement checkbox and submit button
    bDisableAllFields = true;
    bDisableCategoryField = true;
    bDisableLicensing = true;
    bDisableClosureFields = true;
    bDisableStatusField = true;
    bHideSaveButton = false;
    bHideSaveSubmitButton = false;
  }

  if(HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY.equals(statusD) ||
     HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY.equals(statusD) ||
     HomeInfrmtnConversation.CODE_STATUS_UNAPPROVED.equals(statusD)){
    bDisableOnHold = true;
  }
 }


//Set values according to page mode
if (pageMode.equals(PageModeConstants.VIEW))
{
  bDisableAllFields = true;
  bDisableLicensing = true;
  bDisableClosureFields = true;
  bHideSaveButton = true;
  bHideAssignButton = true;
  bHideSaveSubmitButton = true;
  bDisableStatusField = true;
  bDisableCategoryField = true;
  bDisableOnHold = true;
  if (!bDocumentExists)
  {
    bHideDocumentButton = true;
  }
}

if (HomeInfrmtnConversation.CODE_STATUS_INQUIRY.equals(request.getAttribute("selStatus")) &&
    !HomeInfrmtnConversation.CODE_STATUS_INQUIRY.equals(statusD))
{
  Option anOption1 = new Option(HomeInfrmtnConversation.CODE_STATUS_INQUIRY,
                                Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA,
                                                        HomeInfrmtnConversation.CODE_STATUS_INQUIRY));
  statusOptions.add(anOption1);
}

// SMS #81140: MR-074
String strFunction = "";

if (GlobalData.isApprovalMode(request)) {
  strFunction = "doNothing();";
} else {
  strFunction = "disableValidation('frmHomeInformation');";
}

  boolean hasMessage = false;
if (FormValidation.pageHasValidationMessages("frmHomeInformation", request) ||
    FormValidation.pageHasErrorMessages(request))
{
  hasMessage = true;
}
// MR-075 When the user enters the page and the home has a pending
// closure event that has been rejected, they are alerted as to whether they
// want to change the status and resubmit. At this point the only thing the 
// user should be able to do is modify the status and submit.
String rejectClosureCase = (String)request.getAttribute( "rejectClosureCase" );;
if ( "true".equals( rejectClosureCase ) )
{
  // MR-075 We no longer enable the save button for pending statuses so
  // after rejection RD need to resubmit the home in another status
  // and they could modify all fields. Field modifiability has already been
  // taken care of by code above.
  closureReason = "";
  recommendReopen = "";
  involuntaryClosure = "";
  statusRsnComments = "";
  request.setAttribute("rejectClosureCase", "false");
}


String selStatusName = "selStatus";
if (bDisableStatusField)
{
  selStatusName = "selStatus_Disabled";
}


// TODO - RE-EVALUATE THIS AND SEE IF WE CAN COMBINE IT WITH MAJOR IF - ELSE IF STATEMENTS
// JMC - SIR 19450 - If the closure event is not pending approval or approved, we do not
// want to display the data retrieved for the Close/Home section.
// STGAP00007365 checking the actual Status dropdown for any approved or pendings 
// if we do have one of these statuses then we dont want to clear the change of
// status reason section. 

HashMap<String, String> pendOrCloseAprv = new HashMap<String, String>();
pendOrCloseAprv.put(CodesTables.CFAHMSTA_PFA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PFA) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_PSA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PSA) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_PFG, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PFG) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_PSG, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PSG) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_PTA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PTA) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_AFA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_AFA) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_ASA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_ASA) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_FLG, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_FLG) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_FSG, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_FSG) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_ATA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_ATA) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_PCL, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PCL) );
pendOrCloseAprv.put(CodesTables.CFAHMSTA_CSD, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_CSD) );



String closureAppStatus = "";
int closureEventId = CaseUtility.getEvent( GlobalData.getUlIdStage( request ), HomeInfrmtnConversation.TASK_APPROVE_HOME_CLOSURE ).getIdEvent();
closureAppStatus = CaseUtility.getApproversStatus( closureEventId  );

// STGAP00007365 Checking Status type to see if the 
// Closure Reason Section should be cleared
if (!pendOrCloseAprv.containsKey(statusD) )
{
  closureReason = "";
  recommendReopen = "";
  involuntaryClosure = "";
  statusRsnComments = "";
}

// JMC -  The approvalRejected boolean will be set to true only if the last status
// was Pending Closure and the Pending Closure Approval Event Status is COMP.
boolean approvalRejected = false;
if ( ( HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE.equals( statusD ) ) &&
     ( HomeInfrmtnConversation.EVENT_STATUS_PROC.equals(eventStatus) ) &&
       hasBeenSubmitted )
{
  approvalRejected = true;
}

//code for ado sealing licenseCategory
//SMS54783 Document button should be hidden for anybody who is not SAU_Sealed or who does not have stage access
       CaseUtility.Stage stage = CaseUtility.getStage(globalIdStage);
  		List<String> categories  = new ArrayList<String>();
    	categories.add(CodesTables.CFACATEG_A); //Adoptive
    	categories.add(CodesTables.CFACATEG_D); //Relative Adopt
    	categories.add(CodesTables.CFACATEG_L); //Foster/Adoptive
    	categories.add(CodesTables.CFACATEG_J); //ICPC Adopt
    	categories.add(CodesTables.CFACATEG_F); //Foster, as the Stage is Sealed it can be assumed that home has Foster Home Conversion event and a child has been placed
    	categories.add(CodesTables.CFACATEG_O); //Relative Foster
    	categories.add(CodesTables.CFACATEG_I); //ICPC Foster  
    	
   if (ArchitectureConstants.Y.equals(stage.getIndSealed()) && categories.contains(licenseCategory)) {
    if (user.hasRight(UserProfile.SEC_SAU_SEALED) == false && !GlobalData.hasStageAccess(request)) {
       bHideDocumentButton = true;
    } else if (user.hasRight(UserProfile.SEC_SAU_SEALED) == true
               && HomeInfrmtnConversation.CODE_STATUS_CLOSED.equals(statusD)) { //home is closed no document button for anybody except SAU_SEaled
      bHideDocumentButton = false;
    } else if (HomeInfrmtnConversation.CODE_STATUS_CLOSED.equals(statusD) && user.hasRight(UserProfile.SEC_SAU_SEALED) == false){
       bHideDocumentButton = true;
    }
  } 
 
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"Javascript1.2\">\r\n// Check for changes before navigating off\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nwindow.attachEvent('onload', expandMySectionOnLoad);\r\nfunction expandMySectionOnLoad()\r\n{\r\n expandCollapsed('expanded' + 'hmDemographics', 'collapsed' + 'hmDemographics')\r\n}\r\n\r\n\r\nfunction expandAllCategories()\r\n{\r\nexpandCollapsed('expandedDED2','collapsedDED2' )\r\nexpandCollapsed('expandedEBD2','collapsedEBD2' )\r\nexpandCollapsed('expandedEXB2','collapsedEXB2' )\r\nexpandCollapsed('expandedFHI2','collapsedFHI2' )\r\nexpandCollapsed('expandedHVI2','collapsedHVI2' )\r\nexpandCollapsed('expandedMED2','collapsedMED2' )\r\nexpandCollapsed('expandedMER2','collapsedMER2' )\r\nexpandCollapsed('expandedOTH2','collapsedOTH2' )\r\n\r\n}\r\n\r\n\r\nfunction collapseAllCategories()\r\n{\r\nexpandCollapsed('collapsedDED2','expandedDED2' )\r\nexpandCollapsed('collapsedEBD2','expandedEBD2' )\r\nexpandCollapsed('collapsedEXB2','expandedEXB2' )\r\n");
      out.write("expandCollapsed('collapsedFHI2','expandedFHI2' )\r\nexpandCollapsed('collapsedHVI2','expandedHVI2' )\r\nexpandCollapsed('collapsedMED2','expandedMED2' )\r\nexpandCollapsed('collapsedMER2','expandedMER2' )\r\nexpandCollapsed('collapsedOTH2','expandedOTH2' )\r\n\r\n}\r\n\r\n\r\nfunction checkAllBoxesInSection (FieldName) {\r\n\tvar index = 0;\r\n\tvar objCheckBoxes = document.getElementsByName(FieldName + index++);\r\n\r\n\twhile (objCheckBoxes.length > 0) {\r\n\t\talert(FieldName);\r\n\t}\r\n  }\r\n\r\n\r\n\r\n\r\n\r\n\r\n// SMS #81140: MR-074\r\nfunction doNothing()\r\n{\r\n  // do nothing;\r\n  return true;\r\n}\r\n\r\nfunction saveSelStatusOptions()\r\n{\r\n  var form = document.frmHomeInformation;\r\n  var options = form.");
      out.print( selStatusName );
      out.write(".options;\r\n  if (options == null)\r\n  {\r\n    return;\r\n  }\r\n  var selStatusOptionsString = \"\";\r\n  \r\n  for (var i = 0; i < options.length; i++)\r\n  {\r\n    \r\n    selStatusOptionsString += options[i].value + \"|\" + options[i].text + \";\";\r\n  }\r\n \r\n  form.selStatusOptions.value = selStatusOptionsString;\r\n}\r\n\r\n\r\n//read hidden field and populate selStatus.options based on hidden field\r\nfunction populateSelStatusOptions()\r\n{\r\n  var form = document.frmHomeInformation;\r\n  var selStatusOptionsString = form.selStatusOptions.value;\r\n  if ((selStatusOptionsString == null) ||\r\n      (selStatusOptionsString == \"\"))\r\n  {\r\n    return;\r\n  }\r\n  var optionsArray = selStatusOptionsString.split(\";\");\r\n  //SIR 16052 - populate with the status from the request or database\r\n  //rather than with the form variable (which was always set to Inquiry - 010)\r\n  var selectedOption = '");
      out.print(statusD);
      out.write("';\r\n  //remove last \"element\" from the array which is just a blank value\r\n  optionsArray.length--;\r\n  clearDropdown(form.");
      out.print( selStatusName );
      out.write(");\r\n  populateDropdown(form.");
      out.print( selStatusName );
      out.write(", selectedOption, optionsArray);\r\n}\r\n\r\n//Called onLoad of the page.  Disables comments box if their corresponding checkbox is unchecked.\r\n//SIR 16052 moved to bottom of page - window.attachEvent('onload', myOnLoadFunction);\r\n\r\nvar oOptionFullApproved = document.createElement(\"OPTION\");\r\noOptionFullApproved.text=\"");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE));
      out.write("\";\r\noOptionFullApproved.value=\"");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE );
      out.write("\";\r\n\r\nvar oOptionSpecApproved = document.createElement(\"OPTION\");\r\noOptionSpecApproved.text=\"");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE));
      out.write("\";\r\noOptionSpecApproved.value=\"");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE);
      out.write("\";\r\n\r\nvar oOptionFullApproved = document.createElement(\"OPTION\");\r\noOptionFullApproved.text=\"");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY));
      out.write("\";\r\noOptionFullApproved.value=\"");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY );
      out.write("\";\r\n\r\nvar oOptionSpecApproved = document.createElement(\"OPTION\");\r\noOptionSpecApproved.text=\"");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY));
      out.write("\";\r\noOptionSpecApproved.value=\"");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY );
      out.write("\";\r\n\r\nvar oOptionTempApproved = document.createElement(\"OPTION\");\r\noOptionTempApproved.text=\"");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE));
      out.write("\";\r\noOptionTempApproved.value=\"");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE );
      out.write("\";\r\n\r\nvar oOptionInquiry = document.createElement(\"OPTION\");\r\noOptionInquiry.text=\"");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_INQUIRY));
      out.write("\";\r\noOptionInquiry.value=\"");
      out.print( HomeInfrmtnConversation.CODE_STATUS_INQUIRY );
      out.write("\";\r\n\r\nvar oOptionApplicant = document.createElement(\"OPTION\");\r\noOptionApplicant.text=\"");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPLICANT));
      out.write("\";\r\noOptionApplicant.value=\"");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPLICANT );
      out.write("\";\r\n\r\nvar oOptionClosed = document.createElement(\"OPTION\");\r\noOptionClosed.text=\"");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_CLOSED));
      out.write("\";\r\noOptionClosed.value=\"");
      out.print( HomeInfrmtnConversation.CODE_STATUS_CLOSED );
      out.write("\";\r\n\r\nvar faHomeStatus = '");
      out.print( statusD );
      out.write("';\r\nvar category = '");
      out.print( categoryD );
      out.write("';\r\n\r\n  function myOnLoadFunction()\r\n  {\r\n\r\n    var x = document.frmHomeInformation;\r\n    // SIR# 18826. added the validation condition to the if statement. if there is an error we don't\r\n    // want to repopulate the status drop down\r\n    if (");
      out.print( FormValidation.pageHasValidationMessages("frmHomeInformation", request) ||
            FormValidation.pageHasErrorMessages(request) );
      out.write(")\r\n    {\r\n      populateSelStatusOptions();\r\n    }\r\n    else\r\n    {\r\n      if (x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE );
      out.write("' &&\r\n        x.status.value != '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE );
      out.write("')\r\n      {\r\n        clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n        x.");
      out.print( selStatusName );
      out.write(".add(oOptionFullApproved);\r\n        x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n        CleanSelect(x.");
      out.print( selStatusName );
      out.write(");\r\n      }\r\n      if (x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE );
      out.write("' &&\r\n        x.status.value != '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE );
      out.write("')\r\n      {\r\n        clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n        x.");
      out.print( selStatusName );
      out.write(".add(oOptionSpecApproved);\r\n        x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n        CleanSelect(x.");
      out.print( selStatusName );
      out.write(");\r\n      }\r\n      if (x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY );
      out.write("' &&\r\n        x.status.value != '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY );
      out.write("')\r\n      {\r\n        clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n        x.");
      out.print( selStatusName );
      out.write(".add(oOptionFullApproved);\r\n        x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n        CleanSelect(x.");
      out.print( selStatusName );
      out.write(");\r\n      }\r\n      if (x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY );
      out.write("' &&\r\n        x.status.value != '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY );
      out.write("')\r\n      {\r\n        clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n        x.");
      out.print( selStatusName );
      out.write(".add(oOptionSpecApproved);\r\n        x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n        CleanSelect(x.");
      out.print( selStatusName );
      out.write(");\r\n      }\r\n      if (x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE );
      out.write("' &&\r\n        x.status.value != '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE );
      out.write("')\r\n      {\r\n        clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n        x.");
      out.print( selStatusName );
      out.write(".add(oOptionTempApproved);\r\n        x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n        CleanSelect(x.");
      out.print( selStatusName );
      out.write(");\r\n      }      \r\n      if (x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_INQUIRY );
      out.write("' &&\r\n        x.status.value != '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_INQUIRY );
      out.write("')\r\n      {\r\n        clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n        x.");
      out.print( selStatusName );
      out.write(".add(oOptionInquiry);\r\n        x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n        CleanSelect(x.");
      out.print( selStatusName );
      out.write(");\r\n      }\r\n     \r\n      if (x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_CLOSED );
      out.write("' &&\r\n        ");
      out.print( cfad07so != null && cfad07so.getROWCFAD07SOG04()!=null && "Y".equals(cfad07so.getROWCFAD07SOG04().getCIndRshsNonDFCSHome()) );
      out.write(")\r\n        \r\n      {\r\n        clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n        x.");
      out.print( selStatusName );
      out.write(".add(oOptionClosed);\r\n    \tx.");
      out.print( selStatusName );
      out.write(".add(oOptionInquiry);\r\n        x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n        CleanSelect(x.");
      out.print( selStatusName );
      out.write(");\r\n      }\r\n      \r\n    }\r\n\r\n    var cbxName = document.getElementById(\"ckOnHold_id\");\r\n    var checked = cbxName.checked;\r\n    if (checked && ");
      out.print(!bDisableOnHold);
      out.write(") {\r\n      disableLicensingFields();        \r\n    }\r\n  /* SIR#23327. added the if statement */\r\n  if (x.chkIndNonDFCSHome.checked == true)\r\n  {\r\n    x.visibleSzCertifyEntity.disabled = false;\r\n  }\r\n  else\r\n  {\r\n    x.visibleSzCertifyEntity.disabled = true;\r\n    x.visibleSzCertifyEntity.value = \"\";\r\n  }\r\n\r\n");

// When the user enters the Home Information page for the first time after
// the supervisor has rejected a pending closure, they will be alerted
// the home closure was not approved and inform them to select another status
// and resubmit if they don't want to continue to close the home.

// We only want to call the reloadReject() javaScript if there is a rejected Pending
// Closure.
// SIR 23122 - don't call this if pages is in view mode.  the user can't modify
// the page anyway.
if (approvalRejected && !("true".equals( rejectClosureCase ) ) && !pageMode.equals(PageModeConstants.VIEW) )  {
      out.write("\r\n    ");
      out.write("\r\n    window.attachEvent('onload',reloadReject);\r\n");
}
      out.write("\r\n}\r\n\r\n\r\nfunction setHiddenEntity(x)\r\n{\r\n  var sp = document.getElementById(\"txtSzCertifyEntity_id\");\r\n  sp.value=x.value;\r\n}\r\n\r\nfunction disableLicensingFields()\r\n{\r\n  var x = document.frmHomeInformation;\r\n\r\n  x.licenseDisabled.value = 'true';\r\n  x.apprvlBeginDt.disabled = true;\r\n  x.apprvlEndDt.disabled = true;\r\n  x.txtCapacity.disabled = true;\r\n  x.selMaleMinYear.disabled = true;\r\n  var subInput4 = document.createElement(\"input\");\r\n  subInput4.name = 'selMaleMinYear';\r\n  subInput4.value = x.selMaleMinYear.value;\r\n  subInput4.type = 'hidden';\r\n  x.selMaleMinMonth.disabled = true;\r\n  var subInput5 = document.createElement(\"input\");\r\n  subInput5.name = 'selMaleMinMonth';\r\n  subInput5.value = x.selMaleMinMonth.value;\r\n  x.selMaleMaxYear.disabled = true;\r\n  var subInput6 = document.createElement(\"input\");\r\n  subInput6.name = 'selMaleMaxYear';\r\n  subInput6.value = x.selMaleMaxYear.value;\r\n  x.selMaleMaxMonth.disabled = true;\r\n  var subInput7 = document.createElement(\"input\");\r\n  subInput7.name = 'selMaleMaxMonth';\r\n");
      out.write("  subInput7.value = x.selMaleMaxMonth.value;\r\n  x.selFemaleMinYear.disabled = true;\r\n  var subInput8 = document.createElement(\"input\");\r\n  subInput8.name = 'selFemaleMinYear';\r\n  subInput8.value = x.selFemaleMinYear.value;\r\n  x.selFemaleMinMonth.disabled = true;\r\n  var subInput9 = document.createElement(\"input\");\r\n  subInput9.name = 'selFemaleMinMonth';\r\n  subInput9.value = x.selFemaleMinMonth.value;\r\n  x.selFemaleMaxYear.disabled = true;\r\n  var subInput10 = document.createElement(\"input\");\r\n  subInput10.name = 'selFemaleMaxYear';\r\n  subInput10.value = x.selFemaleMaxYear.value;\r\n  x.selFemaleMaxMonth.disabled = true;\r\n  var subInput11 = document.createElement(\"input\");\r\n  subInput11.name = 'selFemaleMaxMonth';\r\n  subInput11.value = x.selFemaleMaxMonth.value;\r\n\r\n\r\n  disableFamTypes();\r\n}\r\n\r\nfunction launchDetailAddress(index, id, countyCD)\r\n{\r\n  frmHomeInformation.addressArrayIndex.value = index;\r\n  frmHomeInformation.selCdFacilityCounty.value = countyCD;\r\n  frmHomeInformation.szCReqFuncCd.value = '");
      out.print( ServiceConstants.REQ_FUNC_CD_UPDATE );
      out.write("';\r\n  document.frmHomeInformation.addressID.value = id;\r\n  disableValidation('frmHomeInformation');\r\n  submitValidateForm('frmHomeInformation', '/fad/HomeInfrmtn/displayAddressDetail');\r\n}\r\n\r\nfunction launchDetailPhone(index, id)\r\n{\r\n  frmHomeInformation.phoneArrayIndex.value = index;\r\n  frmHomeInformation.szCReqFuncCd.value = '");
      out.print( ServiceConstants.REQ_FUNC_CD_UPDATE );
      out.write("';\r\n  document.frmHomeInformation.phoneID.value = id;\r\n  disableValidation('frmHomeInformation');\r\n  submitValidateForm('frmHomeInformation', '/fad/HomeInfrmtn/displayPhoneDetail');\r\n}\r\n\r\nfunction setAddressDeleteParms(vendorID, addressType, addressID, index)\r\n{\r\n  // disableValidation('frmHomeInformation'); //mxpatel commented this out for defect #10156\r\n  document.frmHomeInformation.addressSelected.value = 'true';\r\n  document.frmHomeInformation.addrVendorID.value = vendorID;\r\n  document.frmHomeInformation.addressType.value = addressType;\r\n  document.frmHomeInformation.addressID.value = addressID;\r\n  document.frmHomeInformation.addressArrayIndex.value = index;\r\n}\r\n\r\nfunction setPhoneDeleteParms(phoneType, phoneID, index)\r\n{\r\n // disableValidation('frmHomeInformation'); //mxpatel commented this out for defect #10156\r\n  document.frmHomeInformation.phoneSelected.value = 'true';\r\n  document.frmHomeInformation.phoneID.value = phoneID;\r\n  document.frmHomeInformation.phoneType.value = phoneType;\r\n  document.frmHomeInformation.phoneArrayIndex.value = index;\r\n");
      out.write("}\r\n\r\nfunction checkSelectedStatusAddress()\r\n{\r\n  if (!(document.frmHomeInformation.addressSelected.value == 'true'))\r\n  {\r\n    alert ('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
      out.write("');\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    document.frmHomeInformation.FormValidateCancel = 'true';\r\n    return true;\r\n  }\r\n}\r\n\r\nfunction checkSelectedStatusPhone()\r\n{\r\n  if (!(document.frmHomeInformation.phoneSelected.value == 'true'))\r\n  {\r\n    alert ('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
      out.write("');\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    document.frmHomeInformation.FormValidateCancel = 'true';\r\n    return true;\r\n  }\r\n}\r\n\r\nfunction deleteAddressRow()\r\n{\r\n\r\n  var bRetValue = false;\r\n  disableValidation('frmHomeInformation');//mxpatel added this for defect #10156\r\n  if (checkSelectedStatusAddress())\r\n  {\r\n    \r\n    if (document.frmHomeInformation.addressType.value == '");
      out.print( HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY );
      out.write("')\r\n    {\r\n      alert ('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CMN_PRIMARY_ADDRESS_NO_DELETE));
      out.write("');\r\n      bRetValue = false;\r\n    }\r\n    else if (document.frmHomeInformation.addrVendorID.value != '')\r\n    {\r\n      alert ('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_RES_VID_ADDR));
      out.write("');\r\n      bRetValue = false;\r\n    }\r\n    else\r\n    {\r\n      bRetValue = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("')\r\n      if (bRetValue)\r\n      {\r\n        document.frmHomeInformation.addressDelete.value = 'true';\r\n      }\r\n    }\r\n    return bRetValue;\r\n  }\r\n  else\r\n  {\r\n    return false;\r\n  }\r\n}\r\n\r\nfunction deletePhoneRow()\r\n{\r\n  var bRetValue = false;\r\n  disableValidation('frmHomeInformation'); //mxpatel added this for defect #10156\r\n  if (checkSelectedStatusPhone())\r\n  {\r\n    if (document.frmHomeInformation.phoneType.value == '");
      out.print( HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY );
      out.write("')\r\n    {\r\n      alert ('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CMN_PRIMARY_PHONE_NO_DELETE));
      out.write("');\r\n      bRetValue = false;\r\n    }\r\n    else\r\n    {\r\n      bRetValue = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("')\r\n      if (bRetValue)\r\n      {\r\n        document.frmHomeInformation.phoneDelete.value = 'true';\r\n      }\r\n    }\r\n    return bRetValue;\r\n  }\r\n  else\r\n  {\r\n    return false;\r\n  }\r\n}\r\n\r\nfunction setAdd()\r\n{\r\n  document.frmHomeInformation.szCReqFuncCd.value = '");
      out.print( ServiceConstants.REQ_FUNC_CD_ADD );
      out.write("';\r\n  disableValidation('frmHomeInformation');\r\n}\r\n\r\nfunction disableValidate()\r\n{\r\n disableValidation('frmHomeInformation');\r\n}\r\n\r\nfunction saveSubmit()\r\n{\r\n\r\n  var x = document.frmHomeInformation;\r\n  if (x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print( HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE );
      out.write("' &&\r\n      x.closureBlob.value == '");
      out.print( HomeInfrmtnConversation.IND_NO );
      out.write("')\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_FAD_CREATE_CLOSING) );
      out.write("');\r\n  }\r\n  x.submitted.value = 'true';\r\n\r\n}\r\n\r\nfunction saveAssign()\r\n{\r\n  var x = document.frmHomeInformation;\r\n // x.selClosureReason.value = '';\r\n}\r\n\r\nfunction checkMaritalStatus()\r\n{\r\n\r\n  enableValidation( 'frmHomeInformation');\r\n  var x = document.frmHomeInformation;\r\n  if (x.selMaritalStatus.value != '");
      out.print( HomeInfrmtnConversation.CODE_MARRIED );
      out.write("' &&\r\n       x.marriageDate.value != '')\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_FAD_STATUS_NOT_MARRIED) );
      out.write("');\r\n    x.marriageDate.value = '';\r\n  }\r\n\r\n//  SIR 19032 -- If the NAH checkbox is checked\r\n//               and the selCategory is\r\n//               Adoptive, the user can't save the page.\r\n  if(document.frmHomeInformation.chkIndNonDFCSHome.checked && document.frmHomeInformation.selCategory.value != '");
      out.print(HomeInfrmtnConversation.CODE_ADOPTIVE);
      out.write("')\r\n  {\r\n    //alert ('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CATEGORY_ADO_NAH));
      out.write("');\r\n    return true;\r\n  }\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n}\r\n\r\nfunction checkNonPrsHome(isChecked, originalStatus, originalCategory)\r\n{\r\n  var x = document.frmHomeInformation;\r\n  if (x.chkIndNonDFCSHome.checked)\r\n  {\r\n    x.prsChange.value = 'true';\r\n    //clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n    //x.");
      out.print( selStatusName );
      out.write(".add(oOptionFullApproved);\r\n    //x.");
      out.print( selStatusName );
      out.write(".add(oOptionSpecApproved);\r\n    //x.");
      out.print( selStatusName );
      out.write(".add(oOptionTempApproved);\r\n    //x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n    //x.selCategory.value = '");
      out.print( HomeInfrmtnConversation.CODE_ADOPTIVE );
      out.write("';\r\n  }\r\n  else\r\n  {\r\n    if (isChecked) //has this record been saved already as a non-prs(dfcs) home?\r\n    {\r\n      var bRetValue = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_FAD_NONPRS_DESEL) );
      out.write("');\r\n      if (bRetValue)\r\n      {\r\n        x.prsChange.value = 'true';\r\n        //clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n        //x.");
      out.print( selStatusName );
      out.write(".add(oOptionInquiry);\r\n        //x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n        //x.selCategory.value = originalCategory;\r\n      //  x.selCategory.disabled = true;\r\n\r\n      }\r\n      else //cancel on confirm\r\n      {\r\n        x.prsChange.value = '';\r\n        x.chkIndNonDFCSHome.checked = true;\r\n      }\r\n    }\r\n    else //has NOT already been saved as non-prs home\r\n    {\r\n      x.prsChange.value = '';\r\n      //clearDropdown(x.");
      out.print( selStatusName );
      out.write(");\r\n      //x.");
      out.print( selStatusName );
      out.write(".add(oOptionInquiry);\r\n      //x.");
      out.print( selStatusName );
      out.write(".options[1].selected = true;\r\n      //x.selCategory.value = originalCategory;\r\n    }\r\n  }\r\n\r\n  /* SIR#23327. added the if statement */\r\n  if (x.chkIndNonDFCSHome.checked)\r\n  {\r\n    x.visibleSzCertifyEntity.disabled = false;\r\n  }\r\n  else\r\n  {\r\n    x.visibleSzCertifyEntity.disabled = true;\r\n    x.visibleSzCertifyEntity.value = \"\";\r\n  }\r\n\r\n  ");
 /* SIR 18710 - Since this function changes the value of the Category we
      have to call disableFHType to make sure the widgets are en/disabled */ 
      out.write("\r\n  //disableFHType();\r\n}\r\n\r\nfunction checkDocValidation()\r\n{\r\n  var x = document.frmHomeInformation;\r\n  if (x.selMaritalStatus.value == '' || x.txtCapacity.value == '' ||\r\n       x.txtCapacity.value == '0' || x.txtAnnualIncome.value == '' || x.txtAnnualIncome.value == '$ 0.00')\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_DOC_INVALID) );
      out.write("');\r\n    return false;\r\n  }\r\n  else if (x.selMaritalStatus.value == '");
      out.print( HomeInfrmtnConversation.CODE_MARRIED );
      out.write("' &&\r\n           x.marriageDate.value == '')\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_FAD_NO_MARRIAGE) );
      out.write("');\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n}\r\n\r\nfunction setMarriageDateDisable()\r\n{\r\n  var x = document.frmHomeInformation;\r\n  if (x.selMaritalStatus.value != '");
      out.print( HomeInfrmtnConversation.CODE_MARRIED );
      out.write("')\r\n  {\r\n    x.marriageDate.disabled = true;\r\n  }\r\n  else\r\n  {\r\n    x.marriageDate.disabled = false;\r\n  }\r\n}\r\n\r\nfunction setOpenSlots()\r\n{\r\n  var x = document.frmHomeInformation;\r\n  x.licenseChanged.value = 'true';\r\n  var capacity = x.txtCapacity.value;\r\n  var placements = x.txtPlacements.value;\r\n  var openSlots = capacity - placements;\r\n  if ((preventOverCapacity(capacity, placements)) == 'true'){\r\n    openSlots = ");
      out.print(capacity);
      out.write(" - placements;\r\n    return false;\r\n  }\r\n  if (openSlots < 0)\r\n  {\r\n    openSlots = 0;\r\n  }\r\n  updateDisplayOnlyField('frmHomeInformation', 'txtOpenSlots', openSlots);\r\n}\r\n\r\nfunction preventOverCapacity(capacity, placements){\r\n  if (parseInt(capacity) < parseInt(placements))\r\n  {\r\n    alert('Capacity can not be less than the number of Placements');\r\n    return 'true';\r\n  } else {\r\n    return 'false';\r\n  }\r\n}\r\n\r\nfunction setLicenseChange()\r\n{\r\n  var x = document.frmHomeInformation;  \r\n  var i = x.numberHomeTypes.value;\r\n  var j = 1;\r\n  var changed = 'false';\r\n  \r\n  while (j <= i)\r\n  {\r\n    var checkbox = eval('document.frmHomeInformation.famTypes'+j+'_changed');\r\n    if (checkbox != null)\r\n    {\r\n       if(checkbox.value.substring(0,1) != ' '){\r\n          changed = 'true';\r\n       }\r\n    }\r\n    j++;\r\n  }\r\n  if( !(x.txtCapacity.value == ");
      out.print( cfad37so.getUNbrRsrcFacilCapacity() );
      out.write(" &&\r\n      x.selMaleMinYear.value == ");
      out.print( (cfad37so.getUNbrRsrcMlAgeMin()/12) );
      out.write(" &&\r\n      x.selMaleMinMonth.value == ");
      out.print( (cfad37so.getUNbrRsrcMlAgeMin()%12) );
      out.write(" &&\r\n      x.selMaleMaxYear.value == ");
      out.print( (cfad37so.getUNbrRsrcIntMaAgeMax()/12) );
      out.write(" &&\r\n      x.selMaleMaxMonth.value == ");
      out.print( (cfad37so.getUNbrRsrcIntMaAgeMax()%12) );
      out.write(" &&\r\n      x.selFemaleMinYear.value == ");
      out.print( (cfad37so.getUNbrRsrcFMAgeMin()/12) );
      out.write(" &&\r\n      x.selFemaleMinMonth.value == ");
      out.print( (cfad37so.getUNbrRsrcFMAgeMin()%12) );
      out.write(" &&\r\n      x.selFemaleMaxYear.value == ");
      out.print( (cfad37so.getUNbrRsrcFMAgeMax()/12) );
      out.write(" &&\r\n      x.selFemaleMaxMonth.value == ");
      out.print( (cfad37so.getUNbrRsrcFMAgeMax()%12) );
      out.write(" &&\r\n      x.apprvlBeginDt.value == '");
      out.print( FormattingHelper.formatDate( dtApprovalBegin ) );
      out.write("' &&\r\n      x.apprvlEndDt.value == '");
      out.print( FormattingHelper.formatDate( dtApprovalEnd ) );
      out.write("')){\r\n    changed = 'true';\r\n  }\r\n    x.licenseChanged.value = changed;\r\n}\r\n\r\nfunction setFosterTypeChange()\r\n{\r\n  var x = document.frmHomeInformation;\r\n  x.fosterTypeChanged.value = 'false';\r\n  var i = x.numberHomeTypes.value;\r\n  var j = 1;\r\n  while (j <= i)\r\n  {\r\n    var checkbox = eval('document.frmHomeInformation.famTypes'+j+'_changed');\r\n    if (checkbox != null)\r\n    {\r\n       if(checkbox.value.substring(0,1) != ' '){\r\n          x.fosterTypeChanged.value = 'true';\r\n       }\r\n    }\r\n    j++;\r\n  }\r\n  setLicenseChange();\r\n}\r\n\r\nfunction setOnHold()\r\n{\r\n  var x = document.frmHomeInformation;\r\n  var checkbox = eval('document.frmHomeInformation.ckOnHold_changed');\r\n  if (checkbox != null)\r\n  {\r\n     if(checkbox.value.substring(0,1) != ' '){\r\n       x.holdChanged.value = 'true';\r\n     }\r\n  }\r\n  if (x.licenseChanged.value == 'true')\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_FAD_APRV_BEFORE_ON_HOLD) );
      out.write("');\r\n\tif (checkbox != null)\r\n    {\r\n      if(checkbox.value.substring(1,1) == 'Y'){\r\n        x.ckOnHold.checked = true;\r\n      }else{\r\n        x.ckOnHold.checked = false;\r\n      }\r\n    }\r\n  }\r\n  else\r\n  {\r\n    if (x.ckOnHold.checked && ");
      out.print( !bDisableOnHold );
      out.write(")\r\n    {\r\n      alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_FAD_UNCHECK_ON_HOLD) );
      out.write("');\r\n      x.licenseDisabled.value = 'true';\r\n      x.txtCapacity.disabled = true;\r\n      disableLicensingFields();\r\n    }\r\n    else\r\n    {\r\n      x.licenseDisabled.value = 'false';\r\n\t  x.apprvlBeginDt.disabled = false;\r\n\t  x.apprvlEndDt.disabled = false;\r\n      x.txtCapacity.disabled = false;\r\n      x.selMaleMinYear.disabled = false;\r\n      x.selMaleMinMonth.disabled = false;\r\n      x.selMaleMaxYear.disabled = false;\r\n      x.selMaleMaxMonth.disabled = false;\r\n      x.selFemaleMinYear.disabled = false;\r\n      x.selFemaleMinMonth.disabled = false;\r\n      x.selFemaleMaxYear.disabled = false;\r\n      x.selFemaleMaxMonth.disabled = false;\r\n\r\n");
 
	  /*
	  This really is a disable/enable function in case category
	  is Adoptive we dont want to enable Foster Home type section.
	  */
 
      out.write("\r\n      disableFHType();\r\n    }\r\n  }\r\n}\r\n\r\nfunction disableFHType()\r\n{\r\n  ");
 /* SIR 18710 - We have to disable and clear the widgets in the Foster Home
   Type Section if the category is "A" - Adoptive */ 
      out.write("\r\n   if (document.frmHomeInformation.selCategory.value == \"");
      out.print( HomeInfrmtnConversation.CODE_ADOPTIVE);
      out.write("\")\r\n   {\r\n     disableFamTypes();\r\n   }\r\n   else\r\n   {\r\n     enableFamTypes();\r\n   }\r\n}\r\n\r\nfunction categoryChange()\r\n{\r\n  //STGAP00017883 Added alert to warn user that changing the home Category will\r\n  //require a home closure and thus effect future and current placements\r\n  if (");
      out.print( String.valueOf(idResource) );
      out.write(" != 0) {\r\n    alert(\"Before the home category can be changed, the home must be closed, and reopened with a status of Inquiry for the purpose of reassessment. Changing this home category can jeopardize future placements and payments for this home.\");\r\n    }\r\n  var x = document.frmHomeInformation;\r\n\r\n  // if the checkbox is disabled and unchecked, there will be no field named\r\n  // ckOnHold. If the checkbox is disabled and checked, there will be a field\r\n  // named ckOnHold, but it will be a hidden field. In either of these cases,\r\n  // we do not want to run anything that attempts to set ckOnHold.disabled or\r\n  // ckOnHold.checked.\r\n  if ((document.getElementsByName(\"ckOnHold\")[0] != null) &&\r\n      (x.ckOnHold.type == \"checkbox\"))\r\n   {\r\n    if (x.ckOnHold.checked == true)\r\n    {\r\n      alert(\"Category cannot be changed while \\\"Placement Hold\\\" is checked in Home Approval.\");\r\n      x.selCategory.value = category;\r\n      return;\r\n    }\r\n   }\r\n  category = x.selCategory.value;\r\n  \r\n  x.categoryChanged.value = 'true';\r\n");
      out.write("  \r\n  disableFHType();\r\n}\r\n\r\nfunction statusChange()\r\n{\r\n  var x = document.frmHomeInformation;\r\n\r\n  // if the checkbox is disabled and unchecked, there will be no field named\r\n  // ckOnHold. If the checkbox is disabled and checked, there will be a field\r\n  // named ckOnHold, but it will be a hidden field. In either of these cases,\r\n  // we do not want to run anything that attempts to set ckOnHold.disabled or\r\n  // ckOnHold.checked.\r\n  if ((document.getElementsByName(\"ckOnHold\")[0] != null) &&\r\n      (x.ckOnHold.type == \"checkbox\"))\r\n  {\r\n    if (x.ckOnHold.checked == true)\r\n    {\r\n\r\n      alert(\"Status cannot be changed while \\\"Placement Hold\\\" is checked in Home Approval.\");\r\n      x.");
      out.print( selStatusName );
      out.write(".value = faHomeStatus;\r\n      return false;\r\n    }\r\n    if(x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print(HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE);
      out.write("' ||\r\n       x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print(HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE);
      out.write("' ||\r\n       x.");
      out.print( selStatusName );
      out.write(".value == '");
      out.print(HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE);
      out.write("')\r\n    {\r\n      x.ckOnHold.disabled = false;\r\n    }\r\n    else\r\n    {\r\n      x.ckOnHold.disabled = true;\r\n    }\r\n  }\r\n  faHomeStatus = x.");
      out.print( selStatusName );
      out.write(".value;\r\n}\r\n\r\nfunction disableFamTypes()\r\n{\r\n  if (");
      out.print( bDisableLicensing );
      out.write(" && ");
      out.print( bDisableOnHold );
      out.write(")\r\n  {\r\n    return;\r\n  }\r\n\r\n  var x = document.frmHomeInformation;\r\n  var i = x.numberHomeTypes.value;\r\n  var j = 1;\r\n  while (j <= i)\r\n  {\r\n\r\n    var checkbox = eval('document.frmHomeInformation.famTypes'+j);\r\n    if (checkbox == null)\r\n    {\r\n       return;\r\n    }    \r\n    checkbox.disabled = true;\r\n    var subInput3 = document.createElement(\"input\");\r\n    subInput3.name = checkbox.name;\r\n    if (checkbox.checked)\r\n    {\r\n      subInput3.value = checkbox.value;\r\n    }\r\n    subInput3.type = 'hidden';\r\n    j++;\r\n  }\r\n\r\n}\r\n\r\n\r\nfunction enableFamTypes()\r\n{\r\n  var x = document.frmHomeInformation;\r\n  var i = x.numberHomeTypes.value;\r\n  var j = 1;\r\n  while (j <= i)\r\n  {\r\n    var checkbox = eval('document.frmHomeInformation.famTypes'+j);\r\n    if (checkbox == null)\r\n    {\r\n       return;\r\n    }\r\n    checkbox.disabled = false;\r\n    j++;\r\n  }\r\n\r\n}\r\n\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setOrderBy("decode");
      _jspx_th_impact_codeArray_0.setCodeName( CodesTables.CSCHELEM );
      _jspx_th_impact_codeArray_0.setArrayName("elementaryArray");
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_1.setParent(null);
      _jspx_th_impact_codeArray_1.setOrderBy("decode");
      _jspx_th_impact_codeArray_1.setCodeName( CodesTables.CSCHMDDL );
      _jspx_th_impact_codeArray_1.setArrayName("middleArray");
      _jspx_th_impact_codeArray_1.setBlankValue("true");
      int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
      if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_2.setParent(null);
      _jspx_th_impact_codeArray_2.setOrderBy("decode");
      _jspx_th_impact_codeArray_2.setCodeName( CodesTables.CSCHHIGH );
      _jspx_th_impact_codeArray_2.setArrayName("highArray");
      _jspx_th_impact_codeArray_2.setBlankValue("true");
      int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
      if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n/*\r\n * populates all the schools for the \r\n * selected school district\r\n */\r\n window.attachEvent('onload', populateSchools);\r\n \r\n\r\n// creating function to bypass architectural constraints\r\nfunction addQuestionMark(){\r\n\t// get the parent node of the input element\r\n\tvar labels = document.getElementsByTagName('label');\r\n\tvar SEXUALLY_ACTING_OUT = document.getElementById('chbDecode').value;\r\n\tfor(var i = 0; i < labels.length; i++){\r\n\t\tvar label = labels[i];\r\n\t\tvar inn = label.innerHTML;\r\n\t\tif(SEXUALLY_ACTING_OUT == inn){\r\n\t\t\t// get the cell that the label is in (it's parent node)\r\n\t\t\tvar cell = label.parentNode;\r\n\t\t\t// append html to the end of the node's inner html contents\r\n\t\t\tvar inner = cell.innerHTML;\r\n\t\t\tcell.innerHTML = inner + '&nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayHelp()\">?</a></strong>';\r\n\t\t\tbreak;\r\n\t\t}\r\n\t}\t\r\n}\r\n\r\n\r\nfunction displayHelp(){\r\n  var descriptor = \"\";\r\n  \r\n  // describe the window properties\r\n  descriptor += \"width=450,\";\r\n  descriptor += \"height=350,\";\r\n  descriptor += \"channelmode=0,\";\r\n");
      out.write("  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=1,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=1,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=1,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=1,\";\r\n  descriptor += \"toolbar=0\";\r\n  \r\n  // open person characteristic help page\r\n  return window.open('/person/PersonDetail/displayPersonCharacteristicsHelp', \"\", descriptor);\r\n}\r\n\r\n function populateSchools()\r\n {\r\n   var schoolDistrictCode = document.frmHomeInformation.selSchoolDistrict.value;\r\n\r\n   if ( schoolDistrictCode == \"\" )\r\n   {\r\n      clearDropdown( frmHomeInformation.selSzCdElementary );\r\n      clearDropdown( frmHomeInformation.selSzCdMiddle );\r\n      clearDropdown( frmHomeInformation.selSzCdHigh );\r\n   }\r\n   else\r\n   {\r\n      populateDropdownByLoopingThroughArray( \"frmHomeInformation\", \"selSzCdElementary\",elementaryArray, schoolDistrictCode, 3, \"");
      out.print(FormattingHelper.formatString(elementary));
      out.write("\" );\r\n      populateDropdownByLoopingThroughArray( \"frmHomeInformation\", \"selSzCdMiddle\",middleArray, schoolDistrictCode, 3, \"");
      out.print(FormattingHelper.formatString(middle));
      out.write("\" );\r\n      populateDropdownByLoopingThroughArray( \"frmHomeInformation\", \"selSzCdHigh\",highArray, schoolDistrictCode, 3, \"");
      out.print(FormattingHelper.formatString(high));
      out.write("\" );\r\n   }\r\n }\r\n \r\n function selectAll(catCode, numOfCheckboxes, checkValue) {\r\n  var checkboxField;\r\n\r\n  for ( i = 1; i <= numOfCheckboxes; i++ )\r\n  {\r\n    checkboxField = eval('document.frmHomeInformation.CharCbx' + catCode + i);\r\n\tvar field = 'CharCbx' + catCode + i;\r\n\t\r\n\tif (checkValue && checkboxField.checked != checkValue)\r\n\t {\r\n\t checkboxField.click();\r\n\t }\r\n      else if (checkboxField.checked != checkValue)\r\n             {\r\n             checkboxField.click();\r\n             }\r\n  }\r\n}\r\n \r\n \r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmHomeInformation");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fad/HomeInfrmtn/displayHomeInformation");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("pageMode");
          _jspx_th_impact_validateInput_0.setValue( pageMode );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setId("chbDecode");
          _jspx_th_impact_validateInput_1.setName("chbDecode");
          _jspx_th_impact_validateInput_1.setValue( Lookup.simpleDecodeSafe("CHB", "70") );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_13(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_14(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_15(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("hdnCdFacilityCounty");
          _jspx_th_impact_validateInput_16.setValue( county );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("documentExists");
          _jspx_th_impact_validateInput_17.setValue( String.valueOf(bDocumentExists) );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("closureBlob");
          _jspx_th_impact_validateInput_18.setValue( closureBlob );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("closureDate");
          _jspx_th_impact_validateInput_19.setValue( String.valueOf(closureDate) );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_20(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("onLoadStatus");
          _jspx_th_impact_validateInput_21.setValue( statusD );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("fieldsDisabled");
          _jspx_th_impact_validateInput_22.setValue( String.valueOf(bDisableAllFields) );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName("licenseDisabled");
          _jspx_th_impact_validateInput_23.setValue( String.valueOf(bDisableLicensing) );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_24(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("status");
          _jspx_th_impact_validateInput_25.setValue( statusD );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_26(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_27(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_28(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_29(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("hidden");
          _jspx_th_impact_validateInput_30.setName("timestamp");
          _jspx_th_impact_validateInput_30.setValue( String.valueOf(timestamp) );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("hidden");
          _jspx_th_impact_validateInput_31.setName("timestampLIC");
          _jspx_th_impact_validateInput_31.setValue( String.valueOf(timestampLIC) );
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr><td align=\"left\">\r\n\r\n");

 if (!bHideApproveButton)
{
          out.write("\r\n       ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprvlStatus");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmHomeInformation");
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setFunction(strFunction);
          _jspx_th_impact_ButtonTag_0.setAction(ApprovalStatusConversation.DISPLAY_URI);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
}
          out.write("\r\n\r\n</td>\r\n\r\n<td align=\"right\">\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"javascript:expandAll();\">Expand All</a>&nbsp;\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"javascript:collapseAll();\">Collapse All</a>&nbsp;\r\n</td>\r\n </tr>\r\n</table>\r\n\r\n<table width=\"100%\" class=\"tableborder\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n<th colspan=\"4\">Home Information</th>\r\n<tr class=\"subDetail\">\r\n  <td>\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_32.setName("txtHomeName");
          _jspx_th_impact_validateInput_32.setLabel("Home Name");
          _jspx_th_impact_validateInput_32.setType("text");
          _jspx_th_impact_validateInput_32.setValue( homeName );
          _jspx_th_impact_validateInput_32.setRequired( String.valueOf( !bDisableAllFields ) );
          _jspx_th_impact_validateInput_32.setDisabled( String.valueOf(bDisableAllFields) );
          _jspx_th_impact_validateInput_32.setCssClass("formInput");
          _jspx_th_impact_validateInput_32.setSize("30");
          _jspx_th_impact_validateInput_32.setMaxLength("30");
          _jspx_th_impact_validateInput_32.setConstraint("Name30");
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("resourceIDDisplayOnly");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Resource ID");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( String.valueOf(idResource) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td>\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_33.setValue( legalName );
          _jspx_th_impact_validateInput_33.setType("text");
          _jspx_th_impact_validateInput_33.setName("txtLegalName");
          _jspx_th_impact_validateInput_33.setLabel("Legal Name");
          _jspx_th_impact_validateInput_33.setRequired( String.valueOf( !bDisableAllFields ) );
          _jspx_th_impact_validateInput_33.setCssClass("formInput");
          _jspx_th_impact_validateInput_33.setColspan("2");
          _jspx_th_impact_validateInput_33.setSize("45");
          _jspx_th_impact_validateInput_33.setDisabled( String.valueOf(bDisableAllFields) );
          _jspx_th_impact_validateInput_33.setMaxLength("45");
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>      \r\n</tr>\r\n  <tr class=\"subDetail\">\r\n     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setValue( categoryD );
          _jspx_th_impact_validateSelect_0.setName("selCategory");
          _jspx_th_impact_validateSelect_0.setLabel("Category");
          _jspx_th_impact_validateSelect_0.setOnChange("categoryChange()");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CFACATEG );
          _jspx_th_impact_validateSelect_0.setRequired( String.valueOf(!bDisableCategoryField && !bDisableAllFields) );
          _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf(bDisableCategoryField || bDisableAllFields) );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setValue( statusD );
          _jspx_th_impact_validateSelect_1.setName("selStatus");
          _jspx_th_impact_validateSelect_1.setLabel("Status");
          _jspx_th_impact_validateSelect_1.setBlankValue("false");
          _jspx_th_impact_validateSelect_1.setOnChange("statusChange();");
          _jspx_th_impact_validateSelect_1.setOptions( statusOptions );
          _jspx_th_impact_validateSelect_1.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf(bDisableStatusField) );
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 200px");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n</tr>\r\n  <tr class=\"subDetail\">\r\n     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString( cdExchangeStat ) );
          _jspx_th_impact_validateSelect_2.setName("selAdExchStatus");
          _jspx_th_impact_validateSelect_2.setLabel("AD Exchg. Status");
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CADEXCHG );
          _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf(bDisableAllFields) );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_34.setValue("ON");
          _jspx_th_impact_validateInput_34.setType("checkbox");
          _jspx_th_impact_validateInput_34.setChecked( String.valueOf(isWaiverExists) );
          _jspx_th_impact_validateInput_34.setName("chkWaiverExists");
          _jspx_th_impact_validateInput_34.setDisabled( String.valueOf(bDisableAllFields) );
          _jspx_th_impact_validateInput_34.setLabel("Waiver Exists");
          _jspx_th_impact_validateInput_34.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n</tr>\r\n</table>\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("hmDemographics");
          _jspx_th_impact_ExpandableSectionTag_0.setId("selEthnicity_Id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Home Demographics");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_0.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table width=\"100%\" class=\"tableborder\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr class=\"subDetail\">\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_3.setValue( religion );
              _jspx_th_impact_validateSelect_3.setName("selReligion");
              _jspx_th_impact_validateSelect_3.setLabel("Religion");
              _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CRELIGNS );
              _jspx_th_impact_validateSelect_3.setRequired("false");
              _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_4.setValue( language );
              _jspx_th_impact_validateSelect_4.setName("selLanguage");
              _jspx_th_impact_validateSelect_4.setLabel("Language");
              _jspx_th_impact_validateSelect_4.setCodesTable( CodesTables.CLANG );
              _jspx_th_impact_validateSelect_4.setRequired("false");
              _jspx_th_impact_validateSelect_4.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_5.setValue( respite );
              _jspx_th_impact_validateSelect_5.setName("selRespite");
              _jspx_th_impact_validateSelect_5.setLabel("Respite");
              _jspx_th_impact_validateSelect_5.setCodesTable( CodesTables.CFARSPIT );
              _jspx_th_impact_validateSelect_5.setRequired("false");
              _jspx_th_impact_validateSelect_5.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_35.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_35.setValue( annualIncome );
              _jspx_th_impact_validateInput_35.setType("text");
              _jspx_th_impact_validateInput_35.setName("txtAnnualIncome");
              _jspx_th_impact_validateInput_35.setLabel("Annual Income");
              _jspx_th_impact_validateInput_35.setRequired( String.valueOf(bAnnualMarital) );
              _jspx_th_impact_validateInput_35.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_35.setCssClass("formInput");
              _jspx_th_impact_validateInput_35.setSize("12");
              _jspx_th_impact_validateInput_35.setMaxLength("12");
              _jspx_th_impact_validateInput_35.setConstraint("Money");
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n         </tr>\r\n         <tr class=\"subDetail\">\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_6.setValue( maritalStatus );
              _jspx_th_impact_validateSelect_6.setName("selMaritalStatus");
              _jspx_th_impact_validateSelect_6.setLabel("Marital Status");
              _jspx_th_impact_validateSelect_6.setExcludeOptions( excludeFAMSTRC );
              _jspx_th_impact_validateSelect_6.setCodesTable( CodesTables.CFAMSTRC );
              _jspx_th_impact_validateSelect_6.setOnChange("setMarriageDateDisable();");
              _jspx_th_impact_validateSelect_6.setRequired( String.valueOf(bAnnualMarital) );
              _jspx_th_impact_validateSelect_6.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n         <td>");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_0.setSize("10");
              _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(marriageDate) );
              _jspx_th_impact_validateDate_0.setName("marriageDate");
              _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_0.setLabel("Marriage Date");
              _jspx_th_impact_validateDate_0.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              _jspx_th_impact_validateDate_0.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateDate_0.setColspan("2");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n         </tr>\r\n         ");
              out.write("\r\n        ");
 String javascriptString = "javascript:checkNonPrsHome("+isNonDFCSHome+", '"+statusD+"', '"+categoryD+"');";  
              out.write("         \r\n         <tr class=\"subDetail\">\r\n         <td colspan=\"2\">\r\n    <table>\r\n           <tr>\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_36.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_36.setValue("on");
              _jspx_th_impact_validateInput_36.setType("checkbox");
              _jspx_th_impact_validateInput_36.setChecked( String.valueOf(isNonDFCSHome) );
              _jspx_th_impact_validateInput_36.setColspan("2");
              _jspx_th_impact_validateInput_36.setName("chkIndNonDFCSHome");
              _jspx_th_impact_validateInput_36.setOnClick( javascriptString );
              _jspx_th_impact_validateInput_36.setLabel("Non-DFCS Home");
              _jspx_th_impact_validateInput_36.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_36.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n         <td>&nbsp;</td>\r\n     </tr>\r\n     ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_37.setType("hidden");
              _jspx_th_impact_validateInput_37.setName("txtSzCertifyEntity");
              _jspx_th_impact_validateInput_37.setValue( certifyEntity );
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </table>\r\n         </td>\r\n          <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_38.setType("text");
              _jspx_th_impact_validateInput_38.setLabel("Non-DFCS Certifying Entity");
              _jspx_th_impact_validateInput_38.setName("visibleSzCertifyEntity");
              _jspx_th_impact_validateInput_38.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_38.setCssClass("formInput");
              _jspx_th_impact_validateInput_38.setValue( certifyEntity );
              _jspx_th_impact_validateInput_38.setConstraint("Paragraph30");
              _jspx_th_impact_validateInput_38.setOnChange("setHiddenEntity(this)");
              _jspx_th_impact_validateInput_38.setSize("30");
              _jspx_th_impact_validateInput_38.setMaxLength("30");
              _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n        </tr>         \r\n        <tr class=\"subDetail\">\r\n         <td colspan=\"4\">\r\n         <table>\r\n           <tr>\r\n           <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_39.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_39.setType("checkbox");
              _jspx_th_impact_validateInput_39.setChecked( String.valueOf(isCurrHomeSdyExst) );
              _jspx_th_impact_validateInput_39.setColspan("2");
              _jspx_th_impact_validateInput_39.setName("chkIndCurrHomeStudyExists");
              _jspx_th_impact_validateInput_39.setLabel("A Current Home Study Exists");
              _jspx_th_impact_validateInput_39.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_39.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n         <td>&nbsp;</td>\r\n         <td>&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n     </tr>\r\n         </table>\r\n         </td>\r\n        </tr>\r\n        <tr class=\"subDetail\">\r\n         <td colspan=\"4\">\r\n         <table>\r\n           <tr>\r\n           <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_40.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_40.setType("checkbox");
              _jspx_th_impact_validateInput_40.setChecked( String.valueOf(isPrevHomeStdy) );
              _jspx_th_impact_validateInput_40.setName("chkIndPrevHomeStudy");
              _jspx_th_impact_validateInput_40.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_40.setLabel("Previous Home Study");
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n        \r\n         <td>&nbsp;</td>\r\n         <td>&nbsp;</td>\r\n         <td>&nbsp;</td>\r\n     </tr>\r\n         </table>\r\n         </td>\r\n        </tr>        \r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_7.setValue( FormattingHelper.formatString( schoolDistrict ) );
              _jspx_th_impact_validateSelect_7.setName("selSchoolDistrict");
              _jspx_th_impact_validateSelect_7.setLabel("School District");
              _jspx_th_impact_validateSelect_7.setCodesTable( CodesTables.CSCHDSTR );
              _jspx_th_impact_validateSelect_7.setRequired("false");
              _jspx_th_impact_validateSelect_7.setOnChange("populateSchools()");
              _jspx_th_impact_validateSelect_7.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n     <td>\r\n           ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_8.setValue( elementary );
              _jspx_th_impact_validateSelect_8.setName("selSzCdElementary");
              _jspx_th_impact_validateSelect_8.setLabel("Elementary");
              _jspx_th_impact_validateSelect_8.setCodesTable( CodesTables.CSCHELEM);
              _jspx_th_impact_validateSelect_8.setStyle("WIDTH:200px");
              _jspx_th_impact_validateSelect_8.setRequired("false");
              _jspx_th_impact_validateSelect_8.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td colspan=\"2\">&nbsp;</td>\r\n        <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_9.setValue( middle );
              _jspx_th_impact_validateSelect_9.setName("selSzCdMiddle");
              _jspx_th_impact_validateSelect_9.setLabel("Middle");
              _jspx_th_impact_validateSelect_9.setCodesTable( CodesTables.CSCHMDDL);
              _jspx_th_impact_validateSelect_9.setStyle("WIDTH:200px");
              _jspx_th_impact_validateSelect_9.setRequired("false");
              _jspx_th_impact_validateSelect_9.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td colspan=\"2\">&nbsp;</td>\r\n        <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_10.setValue( high );
              _jspx_th_impact_validateSelect_10.setName("selSzCdHigh");
              _jspx_th_impact_validateSelect_10.setLabel("High");
              _jspx_th_impact_validateSelect_10.setCodesTable( CodesTables.CSCHHIGH);
              _jspx_th_impact_validateSelect_10.setStyle("WIDTH:200px");
              _jspx_th_impact_validateSelect_10.setRequired("false");
              _jspx_th_impact_validateSelect_10.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>      \r\n      </tr>\r\n    </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <BR>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("address");
          _jspx_th_impact_ExpandableSectionTag_1.setId("addressItemSelect_CLEAN_Id");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Address List");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_1.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n<th class=\"thList\">&nbsp;</th>\r\n<th class=\"thList\">Type</th>\r\n<th class=\"thList\">Vendor ID</th>\r\n<th class=\"thList\">Attention</th>\r\n<th class=\"thList\">Address</th>\r\n<th class=\"thList\">County</th>\r\n<th class=\"thList\">Comments</th>\r\n");

int loopCount = 0;
if (addressEnumeration != null)
{
if (!addressEnumeration.hasMoreElements())
{

              out.write("\r\n <tr class=\"odd\">\r\n  <td colspan=\"7\">\r\n   <a href=\"#\" id=\"addressItemSelect_CLEAN_Id\">");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("</a>\r\n  </td>\r\n</tr>\r\n");

}
else
{
  while (addressEnumeration.hasMoreElements())
  {
    addressRow = (ROWCFAD07SOG01) addressEnumeration.nextElement();
    int addressID = addressRow.getUlIdRsrcAddress();
    String addrTypeCD = addressRow.getSzCdRsrcAddrType();
    String addressType = Lookup.simpleDecodeSafe(CodesTables.CRSCADDR, addressRow.getSzCdRsrcAddrType());
    String addressLines1and2 = addressRow.getSzAddrRsrcAddrStLn1() + " " + FormattingHelper.formatString( addressRow.getSzAddrRsrcAddrStLn2() )+ "\n";
    String fullAddress = addressLines1and2 + addressRow.getSzAddrRsrcAddrCity() + "," + addressRow.getSzCdFacilityState() +
      " " + addressRow.getSzAddrRsrcAddrZip();
      String addressComments = "";
    if(addressRow.getSzTxtRsrcAddrComments() != null){
    addressComments = addressRow.getSzTxtRsrcAddrComments();
    }
    String addressCountyCode = addressRow.getSzCdFacilityCounty();
    if ("".equals(addressCountyCode))
    {
      addressCountyCode = "000";
    }
    String vendorID = addressRow.getSzNbrRsrcAddrVid() != null? addressRow.getSzNbrRsrcAddrVid() : "";
    if (!"".equals(addressComments) || addressComments != null)
    {
      bCommentsExist = true;
    }
    String onClickString = "setAddressDeleteParms('"+vendorID+"', '"+addrTypeCD+"', '"+addressID+"', '"+loopCount+"')";
 
              out.write("\r\n   <tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount+1));
              out.write("\">\r\n <td>");
 if (!pageMode.equals(PageModeConstants.VIEW) && !bDisableAllFields) {
              out.write("\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_41.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_41.setValue("");
              _jspx_th_impact_validateInput_41.setOnClick( onClickString );
              _jspx_th_impact_validateInput_41.setType("radio");
              _jspx_th_impact_validateInput_41.setName("rbAddressItemSelect_CLEAN");
              _jspx_th_impact_validateInput_41.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
}
              out.write("\r\n </td>\r\n <td>\r\n");

    String launchAddressString = "javascript:launchDetailAddress("+loopCount+", "+addressID+", '"+addressCountyCode+"')";
    if ((!pageMode.equals(PageModeConstants.VIEW) && !bDisableAllFields) || editPlusVendorId) {
              out.write("\r\n <a href=\"");
              out.print(launchAddressString);
              out.write('"');
              out.write('>');
              out.print( addressType );
              out.write("</a>\r\n");

    }
    else
    {

              out.write("\r\n  ");
              out.print( addressType );
              out.write('\r');
              out.write('\n');

    }

              out.write("\r\n </td>");
 String vid = addressRow.getSzNbrRsrcAddrVid();
    if (!"".equals(vid) && "02".equals(addrTypeCD))
    {

              out.write("\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_42.setType("hidden");
              _jspx_th_impact_validateInput_42.setName("vid");
              _jspx_th_impact_validateInput_42.setValue( vid );
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');

    }

              out.write("\r\n <td>");
              out.print( FormattingHelper.formatString( vid ) );
              out.write("</td>\r\n <td>");
              out.print( FormattingHelper.formatString( addressRow.getSzAddrRsrcAddrAttn() ) );
              out.write("</td>\r\n <td>");
              out.print( fullAddress );
              out.write("</td>\r\n <td>");
              out.print( Lookup.simpleDecodeSafe(CodesTables.CCOUNT, addressRow.getSzCdFacilityCounty()) );
              out.write("</td>\r\n <td align=\"center\">\r\n");

   if( addressRow.getSzTxtRsrcAddrComments() != null && !StringHelper.EMPTY_STRING.equals(addressRow.getSzTxtRsrcAddrComments()))
   {

              out.write("\r\n  <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"> \r\n");

   }
   else
   {

              out.write("\r\n     &nbsp;\r\n");

   }

              out.write("\r\n</td>\r\n");

   loopCount++;
  } //end while
}
} //end if address enumeration not null
else
{

              out.write("\r\n     <tr class=\"odd\">\r\n       <td colspan=\"7\">\r\n        <a href=\"#\" id=\"addressItemSelect_CLEAN_Id\">");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("</a>\r\n       </td>\r\n     </tr>\r\n");

}

              out.write("\r\n</table>\r\n<table width=\"100%\"><tr>\r\n        <td>\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_1.setName("btnDeleteAddress");
              _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_1.setForm("frmHomeInformation");
              _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_1.setDisabled( "" + bDisableAllFields );
              _jspx_th_impact_ButtonTag_1.setFunction("return deleteAddressRow();");
              _jspx_th_impact_ButtonTag_1.setAction("/fad/HomeInfrmtn/deleteAddressRow");
              _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td align=\"right\">\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_2.setName("btnAddAddress");
              _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_2.setForm("frmHomeInformation");
              _jspx_th_impact_ButtonTag_2.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_2.setFunction("setAdd();");
              _jspx_th_impact_ButtonTag_2.setDisabled( "" + bDisableAllFields );
              _jspx_th_impact_ButtonTag_2.setAction("/fad/HomeInfrmtn/addAddress");
              _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n    </table>\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("phone");
          _jspx_th_impact_ExpandableSectionTag_2.setId("rbPhoneItemSelect_CLEAN_Id");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Phone List");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_2.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n<th class=\"thList\">&nbsp;</th>\r\n<th class=\"thList\">Type</th>\r\n<th class=\"thList\">Phone</th>\r\n<th class=\"thList\">Ext</th>\r\n<th class=\"thList\">Comments</th>\r\n");

int loopCount1 = 0;
if (phoneEnumeration != null)
{
  if (!phoneEnumeration.hasMoreElements())
  {

              out.write("\r\n <tr class=\"odd\">\r\n  <td colspan=\"7\">\r\n   <a href=\"#\" id=\"rbPhoneItemSelect_CLEAN_Id\">");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("</a>\r\n  </td>\r\n</tr>\r\n");

  }
  else
  {
    while (phoneEnumeration.hasMoreElements())
    {
      phoneRow = (ROWCFAD07SOG00) phoneEnumeration.nextElement();
      int phoneID = phoneRow.getUlIdRsrcPhone();
      String phoneTypeCD = phoneRow.getSzCdFacilPhoneType();
      String phoneType = Lookup.simpleDecodeSafe(CodesTables.CRSCPHON, phoneRow.getSzCdFacilPhoneType());
      boolean bCommentsExist1 = false;
      String phoneComments = "";
      
      if(phoneRow.getSzTxtRsrcPhoneComments() != null){
      phoneComments = phoneRow.getSzTxtRsrcPhoneComments();
      }
      if (!"".equals(phoneComments) || phoneComments != null)
      {
        bCommentsExist1 = true;
      }
      String onClickString1 = "setPhoneDeleteParms('"+phoneTypeCD+"', '"+phoneID+"', '"+loopCount1+"')";
 
              out.write("\r\n   <tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount1+1));
              out.write("\">\r\n <td>");

      if (!pageMode.equals(PageModeConstants.VIEW) && !bDisableAllFields) {

              out.write("\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_43.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_43.setValue("");
              _jspx_th_impact_validateInput_43.setOnClick( onClickString1 );
              _jspx_th_impact_validateInput_43.setType("radio");
              _jspx_th_impact_validateInput_43.setName("rbPhoneItemSelect_CLEAN");
              _jspx_th_impact_validateInput_43.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');

     }

              out.write("\r\n </td>\r\n <td>\r\n ");
 if (!pageMode.equals(PageModeConstants.VIEW) && !bDisableAllFields) {
              out.write("\r\n <a href=\"javascript:launchDetailPhone(");
              out.print( loopCount1 );
              out.write(',');
              out.write(' ');
              out.print( phoneID );
              out.write(')');
              out.write('"');
              out.write('>');
              out.print( phoneType );
              out.write("</a>\r\n");

}
else
{

              out.write("\r\n  ");
              out.print( phoneType );
              out.write('\r');
              out.write('\n');

}

              out.write("\r\n </td>\r\n <td>");
              out.print( FormattingHelper.formatPhone(phoneRow.getLNbrFacilPhoneNumber()) );
              out.write("</td>\r\n <td>");
              out.print( FormattingHelper.formatString( phoneRow.getLNbrFacilPhoneExtension() ) );
              out.write("</td>\r\n <td>");

 if(phoneRow.getSzTxtRsrcPhoneComments() != null && !StringHelper.EMPTY_STRING.equals(phoneRow.getSzTxtRsrcPhoneComments()))
   {

              out.write("\r\n     <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\">\r\n");

}
else
{

              out.write("\r\n     &nbsp;\r\n");

}

              out.write("\r\n</td>\r\n");
  loopCount1++;
  } //end while
}
} //end if phone enumeration not null
else
{
  
              out.write("\r\n <tr class=\"odd\">\r\n  <td colspan=\"7\">\r\n   <a href=\"#\" id=\"addressItem_0\">");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("</a>\r\n  </td>\r\n</tr>\r\n");

}

              out.write("\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"><tr>\r\n    ");
 if (!bDisableAllFields)
    {
              out.write("\r\n        <td>\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_3.setName("btnDeletePhone");
              _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_3.setForm("frmHomeInformation");
              _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_3.setFunction("return deletePhoneRow();");
              _jspx_th_impact_ButtonTag_3.setAction("/fad/HomeInfrmtn/deletePhoneRow");
              _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n    ");
}
      if (!bDisableAllFields)
    {
              out.write("\r\n\r\n        <td align=\"right\">\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_4.setName("btnAddPhone");
              _jspx_th_impact_ButtonTag_4.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_4.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_4.setForm("frmHomeInformation");
              _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_4.setFunction("setAdd();");
              _jspx_th_impact_ButtonTag_4.setAction("/fad/HomeInfrmtn/addPhone");
              _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      ");
}
              out.write("\r\n    </table>\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("inquiryInformation");
          _jspx_th_impact_ExpandableSectionTag_3.setId("idInquiryInformation");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Inquiry Information");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_3.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"subDetail\">\r\n  <tr>\r\n    <td>\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_1.setName("dtDtInquiryDate");
              _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Inquiry Date");
              _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatDate( inquiryDate ) );
              int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n<td>\r\n    ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_1.setLabel("Date Applied");
              _jspx_th_impact_validateDate_1.setName("dtDtAppliedDate");
              _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_1.setSize("10");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate( dtApplied ) );
              _jspx_th_impact_validateDate_1.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_11.setLabel("Information Packet Requested");
              _jspx_th_impact_validateSelect_11.setName("selCdInfoPcktRqstd");
              _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_11.setCodesTable("CINFPKRQ");
              _jspx_th_impact_validateSelect_11.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_11.setValue( infoPacktRequested );
              int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
              if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n    ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_2.setLabel("Information Packet Sent");
              _jspx_th_impact_validateDate_2.setName("dtDtInfoPcktSent");
              _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_2.setSize("10");
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              _jspx_th_impact_validateDate_2.setValue( FormattingHelper.formatDate( infPacktSent ) );
              _jspx_th_impact_validateDate_2.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_44.setType("text");
              _jspx_th_impact_validateInput_44.setLabel("Requested Number Of Children");
              _jspx_th_impact_validateInput_44.setName("txtNbrRqstdNbrOfChldrn");
              _jspx_th_impact_validateInput_44.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setValue( FormattingHelper.formatInt( iRequestedNbrOfChildren ) );
              _jspx_th_impact_validateInput_44.setConstraint("Numeric");
              _jspx_th_impact_validateInput_44.setSize("3");
              _jspx_th_impact_validateInput_44.setMaxLength("3");
              _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_45.setType("text");
              _jspx_th_impact_validateInput_45.setLabel("Child Specific Interest");
              _jspx_th_impact_validateInput_45.setName("txtSzChldSpcfcInterest");
              _jspx_th_impact_validateInput_45.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_45.setCssClass("formInput");
              _jspx_th_impact_validateInput_45.setValue( childSpecInterest );
              _jspx_th_impact_validateInput_45.setConstraint("Paragraph30");
              _jspx_th_impact_validateInput_45.setSize("30");
              _jspx_th_impact_validateInput_45.setMaxLength("30");
              _jspx_th_impact_validateInput_45.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
              if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n     <tr>\r\n      <td>\r\n    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_12.setLabel("Inquiry Received By");
              _jspx_th_impact_validateSelect_12.setName("txtSzCdInqryRcvdBy");
              _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_12.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_12.setCodesTable("CINQRCBY");
              _jspx_th_impact_validateSelect_12.setValue( inqRecvdBy );
              int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
              if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    </tr>\r\n  <tr colspan=\"4\">\r\n    <td >\r\n           ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_0.setName("txtInquiryComments");
              _jspx_th_impact_validateTextArea_0.setColspan("3");
              _jspx_th_impact_validateTextArea_0.setLabel("Inquiry Comments");
              _jspx_th_impact_validateTextArea_0.setRows("4");
              _jspx_th_impact_validateTextArea_0.setCols("70");
              _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_0.setMaxLength(300);
              _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.write("\r\n            ");
                  out.print( FormattingHelper.formatString( inquiryComments ) );
                  out.write("\r\n          ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n<th colspan=\"8\">Sources Of Inquiry</th>\r\n<tr class=\"subDetail\">\r\n     ");
 int srcOfInqLoopCount = 0;
  Collection srcsOfInqCollection = Lookup.getCategoryCodesCollection(CodesTables.CFASRCIN);
  Iterator srcsOfInqIter = srcsOfInqCollection.iterator();
  Map srcOfInquiryHash = (Map) state.getAttribute("srcOfInquiryHash", request);
  if (srcOfInquiryHash == null)
  {
    srcOfInquiryHash = new HashMap();
  }
  while (srcsOfInqIter.hasNext())
  {
     String srcOfInqCode = (String) srcsOfInqIter.next();
     boolean srcOfInqChecked = false;

     if( srcOfInquiryHash.containsKey(srcOfInqCode) )
       {
        sourceOfInquiry = (ROWCFAD07SOG07) srcOfInquiryHash.get(srcOfInqCode);
        srcOfInqChecked = true;
       } //end if
     srcOfInqLoopCount++;
     String chkbxSrcName = "SrcsOfInquiryCbx_" + srcOfInqLoopCount;
        
              out.write("\r\n  <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_46.setName( chkbxSrcName );
              _jspx_th_impact_validateInput_46.setChecked( String.valueOf(srcOfInqChecked) );
              _jspx_th_impact_validateInput_46.setType("checkbox");
              _jspx_th_impact_validateInput_46.setValue( srcOfInqCode );
              _jspx_th_impact_validateInput_46.setCssClass("formInput");
              _jspx_th_impact_validateInput_46.setLabel( Lookup.simpleDecodeSafe(CodesTables.CFASRCIN, srcOfInqCode));
              _jspx_th_impact_validateInput_46.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_46.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
              if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n        ");
if (srcOfInqLoopCount % 3 == 0)
    {
              out.write("\r\n       </tr><tr class=\"subDetail\">\r\n    ");
}
     } //end while
     if (srcOfInqLoopCount % 3 == 1)
      { 
              out.write("\r\n           <td colspan=\"4\">&nbsp;</td>\r\n          ");
}
           else if(srcOfInqLoopCount % 3 == 2)
           { 
              out.write("\r\n          <td colspan=\"2\">&nbsp;</td>\r\n          ");
}
              out.write("\r\n</tr>\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n<th colspan=\"8\">Information Covered</th>\r\n<tr class=\"subDetail\">\r\n     ");
 int infoCoveredLoopCount = 0;
  Collection infoCoveredCollection = Lookup.getCategoryCodesCollection(CodesTables.CINFCVRD);
  Iterator infoCoveredIter = infoCoveredCollection.iterator();
  Map infoCoveredHash = (Map) state.getAttribute("infoCoveredHash", request);
  if (infoCoveredHash == null)
  {
    infoCoveredHash = new HashMap();
  }
  while (infoCoveredIter.hasNext())
  {
     String infoCoveredCode = (String) infoCoveredIter.next();
     boolean infoCoveredChecked = false;

     if( infoCoveredHash.containsKey(infoCoveredCode) )
       {
        informationCovered = (ROWCFAD07SOG07) infoCoveredHash.get(infoCoveredCode);
        infoCoveredChecked = true;
       } //end if
     infoCoveredLoopCount++;
     String chkbxInfoName = "InfoCoveredCbx_" + infoCoveredLoopCount;
        
              out.write("\r\n  <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_47.setName( chkbxInfoName );
              _jspx_th_impact_validateInput_47.setChecked( String.valueOf(infoCoveredChecked) );
              _jspx_th_impact_validateInput_47.setType("checkbox");
              _jspx_th_impact_validateInput_47.setValue( infoCoveredCode );
              _jspx_th_impact_validateInput_47.setCssClass("formInput");
              _jspx_th_impact_validateInput_47.setLabel( Lookup.simpleDecodeSafe(CodesTables.CINFCVRD, infoCoveredCode));
              _jspx_th_impact_validateInput_47.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_47.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
              if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n        ");
if (infoCoveredLoopCount % 3 == 0)
    {
              out.write("\r\n       </tr><tr class=\"subDetail\">\r\n    ");
}
     } //end while
     if (infoCoveredLoopCount % 3 == 1)
      { 
              out.write("\r\n           <td colspan=\"4\">&nbsp;</td>\r\n          ");
}
           else if(infoCoveredLoopCount % 3 == 2)
           { 
              out.write("\r\n          <td colspan=\"2\">&nbsp;</td>\r\n          ");
}
              out.write("\r\n</tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <BR>\r\n");
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName("orientationPreServiceTrn");
          _jspx_th_impact_ExpandableSectionTag_4.setId("idOrientationPreServiceTrn");
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("Orientation/Pre-Service Training Scheduling");
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_4.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"subDetail\">\r\n  <tr>\r\n    <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDate_3.setName("dtDtOrientation1");
              _jspx_th_impact_validateDate_3.setLabel("Orientation 1");
              _jspx_th_impact_validateDate_3.setSize("10");
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              _jspx_th_impact_validateDate_3.setValue( FormattingHelper.formatDate( dtOrientation1 ) );
              _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_3.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_13.setLabel("Status");
              _jspx_th_impact_validateSelect_13.setName("selOrientationStatus1");
              _jspx_th_impact_validateSelect_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_13.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_13.setCodesTable("CORNTNST");
              _jspx_th_impact_validateSelect_13.setValue( strOrientationStatus1 );
              _jspx_th_impact_validateSelect_13.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
              if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDate_4.setName("dtDtOrientation2");
              _jspx_th_impact_validateDate_4.setLabel("Orientation 2");
              _jspx_th_impact_validateDate_4.setSize("10");
              _jspx_th_impact_validateDate_4.setConstraint("Date");
              _jspx_th_impact_validateDate_4.setValue( FormattingHelper.formatDate( dtOrientation2 ) );
              _jspx_th_impact_validateDate_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_4.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
              if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_14.setLabel("Status");
              _jspx_th_impact_validateSelect_14.setName("selOrientationStatus2");
              _jspx_th_impact_validateSelect_14.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_14.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_14.setCodesTable("CORNTNST");
              _jspx_th_impact_validateSelect_14.setValue( strOrientationStatus2 );
              _jspx_th_impact_validateSelect_14.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_14 = _jspx_th_impact_validateSelect_14.doStartTag();
              if (_jspx_th_impact_validateSelect_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDate_5.setName("dtDtOrientation3");
              _jspx_th_impact_validateDate_5.setLabel("Orientation 3");
              _jspx_th_impact_validateDate_5.setSize("10");
              _jspx_th_impact_validateDate_5.setConstraint("Date");
              _jspx_th_impact_validateDate_5.setValue( FormattingHelper.formatDate( dtOrientation3 ) );
              _jspx_th_impact_validateDate_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_5.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
              if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_15.setLabel("Status");
              _jspx_th_impact_validateSelect_15.setName("selOrientationStatus3");
              _jspx_th_impact_validateSelect_15.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_15.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_15.setCodesTable("CORNTNST");
              _jspx_th_impact_validateSelect_15.setValue( strOrientationStatus3 );
              _jspx_th_impact_validateSelect_15.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_15 = _jspx_th_impact_validateSelect_15.doStartTag();
              if (_jspx_th_impact_validateSelect_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"subDetail\" >\r\n<th colspan=\"8\">Pre-Service Training</th>\r\n  <tr>\r\n    <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDate_6.setName("dtDtInvitation1");
              _jspx_th_impact_validateDate_6.setLabel("Invitation 1");
              _jspx_th_impact_validateDate_6.setSize("10");
              _jspx_th_impact_validateDate_6.setConstraint("Date");
              _jspx_th_impact_validateDate_6.setValue( FormattingHelper.formatDate( dtInvitation1 ) );
              _jspx_th_impact_validateDate_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_6.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
              if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_16.setLabel("Status");
              _jspx_th_impact_validateSelect_16.setName("selInvitationStatus1");
              _jspx_th_impact_validateSelect_16.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_16.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_16.setCodesTable("CPRSVCTR");
              _jspx_th_impact_validateSelect_16.setValue( strInvitationStatus1 );
              _jspx_th_impact_validateSelect_16.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_16 = _jspx_th_impact_validateSelect_16.doStartTag();
              if (_jspx_th_impact_validateSelect_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_48.setLabel("Location");
              _jspx_th_impact_validateInput_48.setType("text");
              _jspx_th_impact_validateInput_48.setName("szInvitation1Location");
              _jspx_th_impact_validateInput_48.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_48.setConstraint("Paragraph30");
              _jspx_th_impact_validateInput_48.setSize("30");
              _jspx_th_impact_validateInput_48.setMaxLength("30");
              _jspx_th_impact_validateInput_48.setValue( strLocation1 );
              _jspx_th_impact_validateInput_48.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
              if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDate_7.setName("dtDtInvitation2");
              _jspx_th_impact_validateDate_7.setLabel("Invitation 2");
              _jspx_th_impact_validateDate_7.setSize("10");
              _jspx_th_impact_validateDate_7.setConstraint("Date");
              _jspx_th_impact_validateDate_7.setValue( FormattingHelper.formatDate( dtInvitation2 ) );
              _jspx_th_impact_validateDate_7.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_7.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateDate_7 = _jspx_th_impact_validateDate_7.doStartTag();
              if (_jspx_th_impact_validateDate_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_17.setLabel("Status");
              _jspx_th_impact_validateSelect_17.setName("selInvitationStatus2");
              _jspx_th_impact_validateSelect_17.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_17.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_17.setCodesTable("CPRSVCTR");
              _jspx_th_impact_validateSelect_17.setValue( strInvitationStatus2 );
              _jspx_th_impact_validateSelect_17.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_17 = _jspx_th_impact_validateSelect_17.doStartTag();
              if (_jspx_th_impact_validateSelect_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_49.setLabel("Location");
              _jspx_th_impact_validateInput_49.setType("text");
              _jspx_th_impact_validateInput_49.setName("szInvitation2Location");
              _jspx_th_impact_validateInput_49.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_49.setConstraint("Paragraph30");
              _jspx_th_impact_validateInput_49.setSize("30");
              _jspx_th_impact_validateInput_49.setMaxLength("30");
              _jspx_th_impact_validateInput_49.setValue( strLocation2 );
              _jspx_th_impact_validateInput_49.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
              if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDate_8.setName("dtDtInvitation3");
              _jspx_th_impact_validateDate_8.setLabel("Invitation 3");
              _jspx_th_impact_validateDate_8.setSize("10");
              _jspx_th_impact_validateDate_8.setConstraint("Date");
              _jspx_th_impact_validateDate_8.setValue( FormattingHelper.formatDate( dtInvitation3 ) );
              _jspx_th_impact_validateDate_8.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_8.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateDate_8 = _jspx_th_impact_validateDate_8.doStartTag();
              if (_jspx_th_impact_validateDate_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_18.setLabel("Status");
              _jspx_th_impact_validateSelect_18.setName("selInvitationStatus3");
              _jspx_th_impact_validateSelect_18.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_18.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_18.setCodesTable("CPRSVCTR");
              _jspx_th_impact_validateSelect_18.setValue( strInvitationStatus3 );
              _jspx_th_impact_validateSelect_18.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_18 = _jspx_th_impact_validateSelect_18.doStartTag();
              if (_jspx_th_impact_validateSelect_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_50.setLabel("Location");
              _jspx_th_impact_validateInput_50.setType("text");
              _jspx_th_impact_validateInput_50.setName("szInvitation3Location");
              _jspx_th_impact_validateInput_50.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_50.setConstraint("Paragraph30");
              _jspx_th_impact_validateInput_50.setSize("30");
              _jspx_th_impact_validateInput_50.setMaxLength("30");
              _jspx_th_impact_validateInput_50.setValue( strLocation3 );
              _jspx_th_impact_validateInput_50.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"subDetail\" >\r\n<tr colspan=\"6\">\r\n    <td >\r\n           ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateTextArea_1.setName("txtSzOrientationComments");
              _jspx_th_impact_validateTextArea_1.setColspan("3");
              _jspx_th_impact_validateTextArea_1.setLabel("Orientation/Pre-Service Training Comments");
              _jspx_th_impact_validateTextArea_1.setRows("4");
              _jspx_th_impact_validateTextArea_1.setCols("70");
              _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_1.setMaxLength(300);
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_1.setDisabled( String.valueOf(bDisableAllFields) );
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n            ");
                  out.print( FormattingHelper.formatString( orientationComments ) );
                  out.write("\r\n          ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n</tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n      <BR>      \r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_5.setName("selMaleMinYearInt_Id");
          _jspx_th_impact_ExpandableSectionTag_5.setId("txtField_Id4");
          _jspx_th_impact_ExpandableSectionTag_5.setLabel("Home Interest");
          _jspx_th_impact_ExpandableSectionTag_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_5.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<th colspan=\"6\">Programs Of Interest</th>\r\n<tr class=\"subDetail\">\r\n            ");
 int prgrmOfInterestLoopCount = 0;
                Collection prgrmsOfInterestsCollection = Lookup.getCategoryCodesCollection(CodesTables.CPRGMINT);
    Iterator prgrmsOfInterestsIter = prgrmsOfInterestsCollection.iterator();
                Map prgrmOfInterestHash = (Map) state.getAttribute("prgrmOfInterestHash", request);
                if (prgrmOfInterestHash == null)
                {
                  prgrmOfInterestHash = new HashMap();
                }
                while (prgrmsOfInterestsIter.hasNext())
                {
       String prgrmOfInterestCode = (String) prgrmsOfInterestsIter.next();
       boolean checked = false;

       if( prgrmOfInterestHash.containsKey(prgrmOfInterestCode) )
         {
          thisPrgrmOfInterest = (ROWCFAD07SOG07) prgrmOfInterestHash.get(prgrmOfInterestCode);
          checked = true;
         } //end if
       prgrmOfInterestLoopCount++;
       String chkbxName = "PrgmsOfInterestCbx_" + prgrmOfInterestLoopCount;
          
              out.write("<td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_51.setName( chkbxName );
              _jspx_th_impact_validateInput_51.setChecked( String.valueOf(checked) );
              _jspx_th_impact_validateInput_51.setType("checkbox");
              _jspx_th_impact_validateInput_51.setValue( String.valueOf( prgrmOfInterestCode ) );
              _jspx_th_impact_validateInput_51.setCssClass("formInput");
              _jspx_th_impact_validateInput_51.setLabel( Lookup.simpleDecodeSafe(CodesTables.CPRGMINT, prgrmOfInterestCode));
              _jspx_th_impact_validateInput_51.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_51.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n           ");
if (prgrmOfInterestLoopCount % 3 == 0)
         {
              out.write("\r\n         </tr><tr class=\"subDetail\">\r\n         ");
}

} //end while
   if (prgrmOfInterestLoopCount % 3 == 1)
   { 
              out.write("\r\n      <td colspan=\"2\">&nbsp;</td>\r\n   ");

   }    
   else if (prgrmOfInterestLoopCount % 3 == 2)
    { 
              out.write("\r\n    <td>&nbsp;</td>\r\n   ");
}
              out.write("\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td colspan=\"2\">\r\n       <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"0\">\r\n          <tr>\r\n             <td>\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_52.setType("text");
              _jspx_th_impact_validateInput_52.setLabel("Other");
              _jspx_th_impact_validateInput_52.setName("txtHmPrgInterest");
              _jspx_th_impact_validateInput_52.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_52.setValue( txtHmPrgInterest );
              _jspx_th_impact_validateInput_52.setConstraint("Paragraph80");
              _jspx_th_impact_validateInput_52.setSize("80");
              _jspx_th_impact_validateInput_52.setMaxLength("80");
              _jspx_th_impact_validateInput_52.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
              if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </td>\r\n           </tr>\r\n         </table>\r\n      </td>\r\n      <td colspan=\"2\"></td>\r\n  </tr>\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n  <tr>\r\n    <th colspan=\"8\">Male Age Range Interests</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_19.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_19.setValue( String.valueOf(maleMinInterestInMonths/12) );
              _jspx_th_impact_validateSelect_19.setName("selMaleMinYearInt");
              _jspx_th_impact_validateSelect_19.setLabel("Min Year");
              _jspx_th_impact_validateSelect_19.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_19.setBlankValue("false");
              _jspx_th_impact_validateSelect_19.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_19.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_19 = _jspx_th_impact_validateSelect_19.doStartTag();
              if (_jspx_th_impact_validateSelect_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_20.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_20.setValue( String.valueOf(maleMinInterestInMonths%12) );
              _jspx_th_impact_validateSelect_20.setName("selMaleMinMonthInt");
              _jspx_th_impact_validateSelect_20.setLabel("Min Month");
              _jspx_th_impact_validateSelect_20.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_20.setBlankValue("false");
              _jspx_th_impact_validateSelect_20.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_20.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_20 = _jspx_th_impact_validateSelect_20.doStartTag();
              if (_jspx_th_impact_validateSelect_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_21.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_21.setValue( String.valueOf(maleMaxInterestInMonths/12) );
              _jspx_th_impact_validateSelect_21.setName("selMaleMaxYearInt");
              _jspx_th_impact_validateSelect_21.setLabel("Max Year");
              _jspx_th_impact_validateSelect_21.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_21.setBlankValue("false");
              _jspx_th_impact_validateSelect_21.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_21.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_21 = _jspx_th_impact_validateSelect_21.doStartTag();
              if (_jspx_th_impact_validateSelect_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_22.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_22.setValue( String.valueOf(maleMaxInterestInMonths%12) );
              _jspx_th_impact_validateSelect_22.setName("selMaleMaxMonthInt");
              _jspx_th_impact_validateSelect_22.setLabel("Max Month");
              _jspx_th_impact_validateSelect_22.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_22.setBlankValue("false");
              _jspx_th_impact_validateSelect_22.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_22.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_22 = _jspx_th_impact_validateSelect_22.doStartTag();
              if (_jspx_th_impact_validateSelect_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n        <table width=\"100%\" class =\"tableborder\" cellspacing=\"0\" cellpadding=\"3\">\r\n          <th colspan=\"8\">Female Age Range Interests</th>\r\n          <tr class=\"subDetail\">\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_23.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_23.setValue( String.valueOf(femaleMinInterestInMonths/12) );
              _jspx_th_impact_validateSelect_23.setName("selFemaleMinYearInt");
              _jspx_th_impact_validateSelect_23.setLabel("Min Year");
              _jspx_th_impact_validateSelect_23.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_23.setBlankValue("false");
              _jspx_th_impact_validateSelect_23.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_23.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_23 = _jspx_th_impact_validateSelect_23.doStartTag();
              if (_jspx_th_impact_validateSelect_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_24.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_24.setValue( String.valueOf(femaleMinInterestInMonths%12) );
              _jspx_th_impact_validateSelect_24.setName("selFemaleMinMonthInt");
              _jspx_th_impact_validateSelect_24.setLabel("Min Month");
              _jspx_th_impact_validateSelect_24.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_24.setBlankValue("false");
              _jspx_th_impact_validateSelect_24.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_24.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_24 = _jspx_th_impact_validateSelect_24.doStartTag();
              if (_jspx_th_impact_validateSelect_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_25.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_25.setValue( String.valueOf(femaleMaxInterestInMonths/12) );
              _jspx_th_impact_validateSelect_25.setName("selFemaleMaxYearInt");
              _jspx_th_impact_validateSelect_25.setLabel("Max Year");
              _jspx_th_impact_validateSelect_25.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_25.setBlankValue("false");
              _jspx_th_impact_validateSelect_25.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_25.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_25 = _jspx_th_impact_validateSelect_25.doStartTag();
              if (_jspx_th_impact_validateSelect_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_26.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_26.setValue( String.valueOf(femaleMaxInterestInMonths%12) );
              _jspx_th_impact_validateSelect_26.setName("selFemaleMaxMonthInt");
              _jspx_th_impact_validateSelect_26.setLabel("Max Month");
              _jspx_th_impact_validateSelect_26.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_26.setBlankValue("false");
              _jspx_th_impact_validateSelect_26.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateSelect_26.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              int _jspx_eval_impact_validateSelect_26 = _jspx_th_impact_validateSelect_26.doStartTag();
              if (_jspx_th_impact_validateSelect_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n          </table>\r\n           <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n\t\t   <th colspan=\"4\" id=\"childRaces\">Child Races</th>\r\n           <tr class=\"subDetail\">\r\n             ");
 int raceLoopCount = 1;
                //String thisRaceCode = "";
                Map raceHash = (Map) state.getAttribute("raceHash", request);
                if (raceHash == null)
                {
                  raceHash = new HashMap();
                }
                while (racesIterator.hasNext())
                {
                 String raceCode = (String) racesIterator.next();
                 boolean isChecked = false;
                 String date = "";
                 if (raceHash.containsKey(raceCode))
                 {
                   thisRace = (HomeRaceSO) raceHash.get(raceCode);
                   isChecked = true;
                   date = FormattingHelper.formatDate(thisRace.getDtScrDtFaHomeDtRaceAdd());
                 } //end if
                 String cbName = "RaceCbx" + raceLoopCount;
                 String hiddenDateFieldName = "raceDate_" + raceLoopCount;
              
              out.write("<td>\r\n                 ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_53.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_53.setValue( raceCode );
              _jspx_th_impact_validateInput_53.setType("checkbox");
              _jspx_th_impact_validateInput_53.setChecked( String.valueOf(isChecked) );
              _jspx_th_impact_validateInput_53.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_53.setName( cbName );
              _jspx_th_impact_validateInput_53.setLabel( Lookup.simpleDecodeSafe(CodesTables.CADRACE, raceCode));
              _jspx_th_impact_validateInput_53.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
              if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_54.setType("hidden");
              _jspx_th_impact_validateInput_54.setName( hiddenDateFieldName );
              _jspx_th_impact_validateInput_54.setValue( date );
              int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
              if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              out.print( date );
              out.write("\r\n                </td>\r\n               ");
if (raceLoopCount % 2 == 0)
                 {
              out.write("\r\n                   </tr><tr class=\"subDetail\">\r\n               ");
}
                 raceLoopCount++;
                 } //end while
             if (raceLoopCount % 2 == 0)
                { 
              out.write("\r\n            <td>&nbsp;</td><td>&nbsp;</td>\r\n              ");
}
              out.write("\r\n           </tr>\r\n\t\t   </table>\r\n          \r\n           <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n           <th colspan=\"4\" id=\"childEthnicities\">Child Ethnicities</th>\r\n           <tr class=\"subDetail\">\r\n             ");
 int loopCount = 1;
                String thisCode = "";
                Map ethHash = (Map) state.getAttribute("ethHash", request);
                if (ethHash == null)
                {
                  ethHash = new HashMap();
                }
                while (ethnicitiesIterator.hasNext())
                {
                 String ethCode = (String) ethnicitiesIterator.next();
                 boolean isChecked = false;
                 String date = "";
                 if (ethHash.containsKey(ethCode))
                 {
                   thisEthnicity = (ROWCFAD07SOG03) ethHash.get(ethCode);
                   isChecked = true;
                   date = FormattingHelper.formatDate(thisEthnicity.getDtScrDtFaHomeEthnicAdd());
                 } //end if
                 String cbName = "EthCbx" + loopCount;
                 String hiddenDateFieldName = "ethDate_" + loopCount;
              
              out.write("<td>\r\n                 ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_55.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_55.setValue( ethCode );
              _jspx_th_impact_validateInput_55.setType("checkbox");
              _jspx_th_impact_validateInput_55.setChecked( String.valueOf(isChecked) );
              _jspx_th_impact_validateInput_55.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_55.setName( cbName );
              _jspx_th_impact_validateInput_55.setLabel( Lookup.simpleDecodeSafe(CodesTables.CINDETHN, ethCode));
              _jspx_th_impact_validateInput_55.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
              if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_56.setType("hidden");
              _jspx_th_impact_validateInput_56.setName( hiddenDateFieldName );
              _jspx_th_impact_validateInput_56.setValue( date );
              int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
              if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              out.print( date );
              out.write("\r\n                </td>\r\n               ");
if (loopCount % 2 == 0)
                 {
              out.write("\r\n                   </tr><tr class=\"subDetail\">\r\n               ");
}
                 loopCount++;
                 } //end while
             if (loopCount % 2 == 0)
                { 
              out.write("\r\n            <td>&nbsp;</td><td>&nbsp;</td>\r\n              ");
}
              out.write("\r\n           </tr>\r\n          </table>\r\n             <!-- test -->\r\n\t\t    <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n           <tr>\r\n\t\t   <th colspan=\"2\" id=\"childCharacteristics\">Child Characteristics</th>\r\n\t\t        <td align=\"right\">\r\n     <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:expandAllCategories()\">Expand All</a>&nbsp;\r\n     <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:collapseAllCategories()\">Collapse All</a>&nbsp;\r\n     </td>\r\n\t\t   </tr>\r\n\t\t   </table>\r\n\t\t  \r\n\t\t  \r\n          ");

        List<CodeAttributes> characteristicsCategories = Lookup.getCategoryCollection(CodesTables.CCHRTCA2);
		Iterator characteristicsCategoryIterator = characteristicsCategories.iterator();
        String thisCode1 = "";
        Map charHash = (Map<String, String>) state.getAttribute("charHash", request);
        if (charHash == null){
        	charHash = new HashMap();
        }
			//int loopCount3 = 1;
        while(characteristicsCategoryIterator.hasNext()){
        	CodeAttributes charCatCodeAtt = (CodeAttributes)characteristicsCategoryIterator.next();
            String catCode = charCatCodeAtt.getCode();
            String catDecode = charCatCodeAtt.getDecode();
        
              out.write("\r\n        \t\t");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_ExpandableSectionTag_6.setName( catCode );
              _jspx_th_impact_ExpandableSectionTag_6.setId("");
              _jspx_th_impact_ExpandableSectionTag_6.setLabel( catDecode );
              _jspx_th_impact_ExpandableSectionTag_6.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ExpandableSectionTag_6 = _jspx_th_impact_ExpandableSectionTag_6.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n\t\t");
  
            List<CodeAttributes> characteristics = Lookup.getCategoryCollection(catCode);
Collections.sort(characteristics, sortDecode);

		int catCodeSize = characteristics.size();
		int loopCount3 = 1; 
		String onClickSelectAll = "javascript:setIsDirtyCalled(true); selectAll(" + "'" + catCode + "'" 
							    															+ "," 
							    															+ catCodeSize 
							    															+ "," 
							    															+ "true" 
							    															+ ");";
																							
																							
		
																		
		String onClickDeSelectAll = "javascript:setIsDirtyCalled(true); selectAll(" + "'" + catCode + "'" 
							    															+ "," 
							    															+ catCodeSize 
							    															+ "," 
							    															+ "false" 
							    															+ ");";

                  out.write("\r\n\r\n\t\t \t\t\t<tr>\r\n\t\t \t\t\t\r\n\t\t    <td><a href=\"");
                  out.print( onClickSelectAll );
                  out.write("\" tabIndex=\"");
                  out.print(tabIndex++);
                  out.write("\" onClick=\"hrefDirtyBypass=true;\"> Select All Child Characteristics</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a  href=\"");
                  out.print( onClickDeSelectAll );
                  out.write("\" tabIndex=\"");
                  out.print(tabIndex++);
                  out.write("\" onClick=\"hrefDirtyBypass=true;\">Deselect All Child Characteristics</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t");
  
           // List<CodeAttributes> characteristics = Lookup.getCategoryCollection(catCode);
//Collections.sort(characteristics, sortDecode);
 
Iterator characteristicsIterator = characteristics.iterator();
            List<CodeAttributes> characteristicsCategory = Lookup.getCategoryCollection(catCode);
            while(characteristicsIterator.hasNext()){
                 CodeAttributes charCodeAtt = (CodeAttributes)characteristicsIterator.next();
                 String charCode = charCodeAtt.getCode();
                 boolean isChecked1 = false;
                 String date = "";
                 if (charHash.containsKey(charCode)){
                    thisCharacteristic = (ROWCFAD07SOG02) charHash.get(charCode);
                    isChecked1 = true;
                    date = FormattingHelper.formatDate(thisCharacteristic.getDtDtRsrcCharDateAdded());
                   } //end if
                 String cbName1 = "CharCbx" + catCode + loopCount3; 
                 
        
                  out.write("\r\n        \t\t<td>\r\n\t\t\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
                  _jspx_th_impact_validateInput_57.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_57.setValue( charCode  );
                  _jspx_th_impact_validateInput_57.setType("checkbox");
                  _jspx_th_impact_validateInput_57.setChecked( String.valueOf(isChecked1) );
                  _jspx_th_impact_validateInput_57.setDisabled( String.valueOf(bDisableAllFields) );
                  _jspx_th_impact_validateInput_57.setName( cbName1 );
                  _jspx_th_impact_validateInput_57.setLabel( Lookup.simpleDecodeSafe(catCode, charCode));
                  _jspx_th_impact_validateInput_57.setCssClass("formInput");
                  int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
                  if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  out.print( date );
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t");

			if(loopCount3 % 2 == 0){
        
                  out.write("\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\">\r\n\t\t   ");
}
                 loopCount3++;
                 } //end while
             if (loopCount3 % 2 == 0)
                { 
                  out.write("\r\n            <td>&nbsp;</td><td>&nbsp;</td>\r\n              ");
}
                  out.write("\r\n           </tr>\r\n          </table>\r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t");

		}
		
              out.write("\r\n          \r\n          <!-- end test -->\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n    <th colspan=\"4\">Child Placement Information</th>\r\n      <tr class=\"subDetail\">\r\n       <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_58.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_58.setValue("WT");
              _jspx_th_impact_validateInput_58.setType("checkbox");
              _jspx_th_impact_validateInput_58.setChecked( String.valueOf(willTransport) );
              _jspx_th_impact_validateInput_58.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_58.setName("ckWillTransport");
              _jspx_th_impact_validateInput_58.setLabel("Will Transport Child[ren]");
              _jspx_th_impact_validateInput_58.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
              if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_59.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_59.setValue("EMP");
              _jspx_th_impact_validateInput_59.setType("checkbox");
              _jspx_th_impact_validateInput_59.setChecked( String.valueOf(emergencyPlacements) );
              _jspx_th_impact_validateInput_59.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_59.setName("ckEmergPlacement");
              _jspx_th_impact_validateInput_59.setLabel("Emergency Placements");
              _jspx_th_impact_validateInput_59.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
              if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n     <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_60.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_60.setValue("SPECCHILD");
              _jspx_th_impact_validateInput_60.setType("checkbox");
              _jspx_th_impact_validateInput_60.setName("chkSpecChildren");
              _jspx_th_impact_validateInput_60.setChecked( String.valueOf(specChildren) );
              _jspx_th_impact_validateInput_60.setLabel("Specific Child(ren) Identified");
              _jspx_th_impact_validateInput_60.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_60.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
              if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n     <td>\r\n       ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateTextArea_2.setName("txtComments");
              _jspx_th_impact_validateTextArea_2.setColspan("3");
              _jspx_th_impact_validateTextArea_2.setLabel("Comments");
              _jspx_th_impact_validateTextArea_2.setRows("3");
              _jspx_th_impact_validateTextArea_2.setCols("110");
              _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_2.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateTextArea_2.setMaxLength(300);
              _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n           ");
                  out.print( homeInterestComments );
                  out.write("\r\n       ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_7.setName("homeLicense");
          _jspx_th_impact_ExpandableSectionTag_7.setId("txtCapacity_Id");
          _jspx_th_impact_ExpandableSectionTag_7.setLabel("Home Approval");
          _jspx_th_impact_ExpandableSectionTag_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_7.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_7 = _jspx_th_impact_ExpandableSectionTag_7.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n          <th colspan=\"8\">Approval Period</th>\r\n          <tr class=\"subDetail\">\r\n     <td>");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateDate_9.setSize("10");
              _jspx_th_impact_validateDate_9.setValue( FormattingHelper.formatDate( dtApprovalBegin ) );
              _jspx_th_impact_validateDate_9.setName("apprvlBeginDt");
              _jspx_th_impact_validateDate_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_9.setLabel("Approval Begin Date");
              _jspx_th_impact_validateDate_9.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              _jspx_th_impact_validateDate_9.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateDate_9.setConstraint("Date");
              int _jspx_eval_impact_validateDate_9 = _jspx_th_impact_validateDate_9.doStartTag();
              if (_jspx_th_impact_validateDate_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n     <td>");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateDate_10.setSize("10");
              _jspx_th_impact_validateDate_10.setValue( FormattingHelper.formatDate( dtApprovalEnd ) );
              _jspx_th_impact_validateDate_10.setName("apprvlEndDt");
              _jspx_th_impact_validateDate_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_10.setLabel("Approval End Date");
              _jspx_th_impact_validateDate_10.setConditionallyRequired( String.valueOf(!bDisableAllFields) );
              _jspx_th_impact_validateDate_10.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateDate_10.setConstraint("Date");
              int _jspx_eval_impact_validateDate_10 = _jspx_th_impact_validateDate_10.doStartTag();
              if (_jspx_th_impact_validateDate_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n          </tr>\r\n      </table>\r\n      <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n          <th colspan=\"8\">Placement Information</th>\r\n          <tr class=\"subDetail\">\r\n           <td width=\"20%\">");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateInput_61.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_61.setValue( String.valueOf(capacity) );
              _jspx_th_impact_validateInput_61.setType("text");
              _jspx_th_impact_validateInput_61.setName("txtCapacity");
              _jspx_th_impact_validateInput_61.setLabel("Capacity");
              _jspx_th_impact_validateInput_61.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              _jspx_th_impact_validateInput_61.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateInput_61.setOnChange("setOpenSlots();");
              _jspx_th_impact_validateInput_61.setCssClass("formInput");
              _jspx_th_impact_validateInput_61.setSize("4");
              _jspx_th_impact_validateInput_61.setMaxLength("4");
              _jspx_th_impact_validateInput_61.setConstraint("Numeric");
              int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
              if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n           <td width=\"20%\">");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateDisplayOnlyField_2.setValue( String.valueOf(placements) );
              _jspx_th_impact_validateDisplayOnlyField_2.setName("txtPlacements");
              _jspx_th_impact_validateDisplayOnlyField_2.setLabel("# Placements");
              int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n          </tr>\r\n          <tr class=\"subDetail\">\r\n           <td width=\"20%\">");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateDisplayOnlyField_3.setValue( String.valueOf(openSlots) );
              _jspx_th_impact_validateDisplayOnlyField_3.setName("txtOpenSlots");
              _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Open Slots");
              int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n           <td width=\"20%\">");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateInput_62.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_62.setValue("on");
              _jspx_th_impact_validateInput_62.setType("checkbox");
              _jspx_th_impact_validateInput_62.setChecked( String.valueOf(isOnHold) );
              _jspx_th_impact_validateInput_62.setOnClick("setOnHold();");
              _jspx_th_impact_validateInput_62.setName("ckOnHold");
              _jspx_th_impact_validateInput_62.setDisabled( String.valueOf(bDisableOnHold) );
              _jspx_th_impact_validateInput_62.setLabel("Hold Placements");
              _jspx_th_impact_validateInput_62.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
              if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td><td>&nbsp;</td>\r\n           <tr class=\"subDetail\">\r\n           <td width=\"20%\">");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateDisplayOnlyField_4.setValue( StringHelper.getNonNullString(iveReimbursable) );
              _jspx_th_impact_validateDisplayOnlyField_4.setName("txtIveReimbursable");
              _jspx_th_impact_validateDisplayOnlyField_4.setLabel("IV-E Reimbursable");
              int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n           <td>&nbsp;</td>\r\n           <td>&nbsp;</td>\r\n           </tr>\r\n        </table>\r\n\r\n        <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n          <th colspan=\"8\">Male Age Range Approved</th>\r\n          <tr class=\"subDetail\">\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_27.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_27.setValue( String.valueOf(maleMinAgeInMonths/12) );
              _jspx_th_impact_validateSelect_27.setName("selMaleMinYear");
              _jspx_th_impact_validateSelect_27.setLabel("Min Year");
              _jspx_th_impact_validateSelect_27.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_27.setOnChange("setLicenseChange();");
              _jspx_th_impact_validateSelect_27.setBlankValue("false");
              _jspx_th_impact_validateSelect_27.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateSelect_27.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              int _jspx_eval_impact_validateSelect_27 = _jspx_th_impact_validateSelect_27.doStartTag();
              if (_jspx_th_impact_validateSelect_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_28.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_28.setValue( String.valueOf(maleMinAgeInMonths%12) );
              _jspx_th_impact_validateSelect_28.setName("selMaleMinMonth");
              _jspx_th_impact_validateSelect_28.setLabel("Min Month");
              _jspx_th_impact_validateSelect_28.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_28.setOnChange("setLicenseChange();");
              _jspx_th_impact_validateSelect_28.setBlankValue("false");
              _jspx_th_impact_validateSelect_28.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateSelect_28.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              int _jspx_eval_impact_validateSelect_28 = _jspx_th_impact_validateSelect_28.doStartTag();
              if (_jspx_th_impact_validateSelect_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_29.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_29.setValue( String.valueOf(maleMaxAgeInMonths/12) );
              _jspx_th_impact_validateSelect_29.setName("selMaleMaxYear");
              _jspx_th_impact_validateSelect_29.setLabel("Max Year");
              _jspx_th_impact_validateSelect_29.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_29.setOnChange("setLicenseChange();");
              _jspx_th_impact_validateSelect_29.setBlankValue("false");
              _jspx_th_impact_validateSelect_29.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateSelect_29.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              int _jspx_eval_impact_validateSelect_29 = _jspx_th_impact_validateSelect_29.doStartTag();
              if (_jspx_th_impact_validateSelect_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_30.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_30.setValue( String.valueOf(maleMaxAgeInMonths%12) );
              _jspx_th_impact_validateSelect_30.setName("selMaleMaxMonth");
              _jspx_th_impact_validateSelect_30.setLabel("Max Month");
              _jspx_th_impact_validateSelect_30.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_30.setOnChange("setLicenseChange();");
              _jspx_th_impact_validateSelect_30.setBlankValue("false");
              _jspx_th_impact_validateSelect_30.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateSelect_30.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              int _jspx_eval_impact_validateSelect_30 = _jspx_th_impact_validateSelect_30.doStartTag();
              if (_jspx_th_impact_validateSelect_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n        </Table>\r\n\r\n        <table width=\"100%\" class =\"tableborder\" cellspacing=\"0\" cellpadding=\"3\">\r\n          <th colspan=\"8\">Female Age Range Approved</th>\r\n          <tr class=\"subDetail\">\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_31.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_31.setValue( String.valueOf(femaleMinAgeInMonths/12) );
              _jspx_th_impact_validateSelect_31.setName("selFemaleMinYear");
              _jspx_th_impact_validateSelect_31.setLabel("Min Year");
              _jspx_th_impact_validateSelect_31.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_31.setOnChange("setLicenseChange();");
              _jspx_th_impact_validateSelect_31.setBlankValue("false");
              _jspx_th_impact_validateSelect_31.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateSelect_31.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              int _jspx_eval_impact_validateSelect_31 = _jspx_th_impact_validateSelect_31.doStartTag();
              if (_jspx_th_impact_validateSelect_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_32.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_32.setValue( String.valueOf(femaleMinAgeInMonths%12) );
              _jspx_th_impact_validateSelect_32.setName("selFemaleMinMonth");
              _jspx_th_impact_validateSelect_32.setLabel("Min Month");
              _jspx_th_impact_validateSelect_32.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_32.setOnChange("setLicenseChange();");
              _jspx_th_impact_validateSelect_32.setBlankValue("false");
              _jspx_th_impact_validateSelect_32.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateSelect_32.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              int _jspx_eval_impact_validateSelect_32 = _jspx_th_impact_validateSelect_32.doStartTag();
              if (_jspx_th_impact_validateSelect_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_33.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_33.setValue( String.valueOf(femaleMaxAgeInMonths/12) );
              _jspx_th_impact_validateSelect_33.setName("selFemaleMaxYear");
              _jspx_th_impact_validateSelect_33.setLabel("Max Year");
              _jspx_th_impact_validateSelect_33.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_33.setOnChange("setLicenseChange();");
              _jspx_th_impact_validateSelect_33.setBlankValue("false");
              _jspx_th_impact_validateSelect_33.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateSelect_33.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              int _jspx_eval_impact_validateSelect_33 = _jspx_th_impact_validateSelect_33.doStartTag();
              if (_jspx_th_impact_validateSelect_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateSelect_34.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_34.setValue( String.valueOf(femaleMaxAgeInMonths%12) );
              _jspx_th_impact_validateSelect_34.setName("selFemaleMaxMonth");
              _jspx_th_impact_validateSelect_34.setLabel("Max Month");
              _jspx_th_impact_validateSelect_34.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_34.setOnChange("setLicenseChange();");
              _jspx_th_impact_validateSelect_34.setBlankValue("false");
              _jspx_th_impact_validateSelect_34.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_validateSelect_34.setConditionallyRequired( String.valueOf(!bDisableLicensing) );
              int _jspx_eval_impact_validateSelect_34 = _jspx_th_impact_validateSelect_34.doStartTag();
              if (_jspx_th_impact_validateSelect_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n          </table>\r\n\r\n   ");
int numFosterHomeTypes = CodesTables.CFAHMTYP.length(); //!!!
     int numFosterHomeTypeSaved = fosterHomeType.trim().length()/3;
     List checkedHomeTypes = new ArrayList(numFosterHomeTypeSaved);
     int index = 0;
     int beginIndex = 0, endIndex = 3, increments = 3;
     while (index < numFosterHomeTypeSaved )
     { 
       String code = StringHelper.getNonNullString(fosterHomeType.substring(beginIndex,endIndex));
       checkedHomeTypes.add(code);
       beginIndex += increments;
       endIndex += increments;
       index++;
     }

              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_validateInput_63.setType("hidden");
              _jspx_th_impact_validateInput_63.setName("numberHomeTypes");
              _jspx_th_impact_validateInput_63.setValue( String.valueOf(numFosterHomeTypes) );
              int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
              if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n    <tr><th colspan = \"8\"> Home Type </th></tr>\r\n     <tr class=\"subDetail\">\r\n     <td>\r\n      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
              _jspx_th_impact_codesCheckbox_0.setName("famTypes");
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes(checkedHomeTypes);
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CFAHMTYP );
              _jspx_th_impact_codesCheckbox_0.setColumns(2);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setOnClick("setFosterTypeChange();");
              _jspx_th_impact_codesCheckbox_0.setDisabled( String.valueOf(bDisableLicensing) );
              _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n     </tr>\r\n  </table>\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
 if (!bHideCloseHomeSection)
  {
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_8.setName("statusReason");
          _jspx_th_impact_ExpandableSectionTag_8.setId("selStatusReason_Id");
          _jspx_th_impact_ExpandableSectionTag_8.setLabel("Change Of Status Reason");
          _jspx_th_impact_ExpandableSectionTag_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_8.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_8 = _jspx_th_impact_ExpandableSectionTag_8.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n   <tr class=\"subDetail\">\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateSelect_35.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_35.setValue( closureReason );
              _jspx_th_impact_validateSelect_35.setName("selClosureReason");
              _jspx_th_impact_validateSelect_35.setLabel("Change Reason");
              _jspx_th_impact_validateSelect_35.setCodesTable(CodesTables.CFACLOSE);
              _jspx_th_impact_validateSelect_35.setDisabled( String.valueOf(bDisableClosureFields) );
              _jspx_th_impact_validateSelect_35.setStyle("WIDTH: 400px");
              int _jspx_eval_impact_validateSelect_35 = _jspx_th_impact_validateSelect_35.doStartTag();
              if (_jspx_th_impact_validateSelect_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateSelect_36.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_36.setValue( recommendReopen );
              _jspx_th_impact_validateSelect_36.setName("selRecReopen");
              _jspx_th_impact_validateSelect_36.setLabel("Recommend Re-opening");
              _jspx_th_impact_validateSelect_36.setDisabled( String.valueOf(bDisableClosureFields) );
              _jspx_th_impact_validateSelect_36.setCodesTable( CodesTables.CFARCMND );
              int _jspx_eval_impact_validateSelect_36 = _jspx_th_impact_validateSelect_36.doStartTag();
              if (_jspx_th_impact_validateSelect_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateSelect_37.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_37.setValue( involuntaryClosure );
              _jspx_th_impact_validateSelect_37.setName("selInvolClosure");
              _jspx_th_impact_validateSelect_37.setLabel("Closure Type");
              _jspx_th_impact_validateSelect_37.setDisabled( String.valueOf(bDisableClosureFields) );
              _jspx_th_impact_validateSelect_37.setCodesTable( CodesTables.CFACLSTP );
              int _jspx_eval_impact_validateSelect_37 = _jspx_th_impact_validateSelect_37.doStartTag();
              if (_jspx_th_impact_validateSelect_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td> \r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n     <td>\r\n       ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_8);
              _jspx_th_impact_validateTextArea_3.setName("txtStatusRsnComments");
              _jspx_th_impact_validateTextArea_3.setColspan("3");
              _jspx_th_impact_validateTextArea_3.setLabel("Comments");
              _jspx_th_impact_validateTextArea_3.setRows("3");
              _jspx_th_impact_validateTextArea_3.setCols("110");
              _jspx_th_impact_validateTextArea_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_3.setDisabled( String.valueOf(bDisableClosureFields) );
              _jspx_th_impact_validateTextArea_3.setMaxLength(300);
              _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.write("\r\n               ");
                  out.print( statusRsnComments );
                  out.write("\r\n       ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>  \r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_8.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n ");
 } //end if not hide close home section

          out.write("\r\n<table width=\"100%\" class=\"tableborder\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n<th colspan=\"4\">Home Study</th>\r\n<tr class=\"subDetail\">\r\n  \t\t <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_11.setSize("10");
          _jspx_th_impact_validateDate_11.setValue( FormattingHelper.formatDate( dtFosterParentManual ) );
          _jspx_th_impact_validateDate_11.setName("dtFosterParentManual");
          _jspx_th_impact_validateDate_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_11.setLabel("Foster Parent Manual Date");
          _jspx_th_impact_validateDate_11.setDisabled( String.valueOf(bDisableLicensing) );
          _jspx_th_impact_validateDate_11.setConstraint("Date");
          int _jspx_eval_impact_validateDate_11 = _jspx_th_impact_validateDate_11.doStartTag();
          if (_jspx_th_impact_validateDate_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t\t  </td>\r\n  \t\t <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_12.setSize("10");
          _jspx_th_impact_validateDate_12.setValue( FormattingHelper.formatDate( dtFosterParentBill ) );
          _jspx_th_impact_validateDate_12.setName("dtFosterParentBill");
          _jspx_th_impact_validateDate_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_12.setLabel("Foster Parents Bill Of Rights Date");
          _jspx_th_impact_validateDate_12.setDisabled( String.valueOf(bDisableLicensing) );
          _jspx_th_impact_validateDate_12.setConstraint("Date");
          int _jspx_eval_impact_validateDate_12 = _jspx_th_impact_validateDate_12.doStartTag();
          if (_jspx_th_impact_validateDate_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t\t  </td>          \r\n    </tr>\r\n</table>\r\n<br>\r\n<hr>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"><tr><td align=\"right\">\r\n    ");
 if (!bHideAssignButton)
    {
// SPB - Added preventDoubleClick="true" to fix SIR 19939

          out.write("\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnAssign");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setForm("frmHomeInformation");
          _jspx_th_impact_ButtonTag_5.setFunction("saveSelStatusOptions(); saveAssign()");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_5.setAction("/fad/HomeInfrmtn/reopenAssignHomeInformation");
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    ");
}
       if (!bHideSaveSubmitButton)
    {
          out.write("\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_6.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_6.setForm("frmHomeInformation");
          _jspx_th_impact_ButtonTag_6.setFunction("saveSelStatusOptions(); saveSubmit();");
          _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_6.setAction("/fad/HomeInfrmtn/saveSubmitHomeInformation");
          _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    ");
}
      if (!bHideSaveButton)
    {
          out.write("\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_7.setName("btnSave1");
          _jspx_th_impact_ButtonTag_7.setImg("btnSave");
          _jspx_th_impact_ButtonTag_7.setForm("frmHomeInformation");
          _jspx_th_impact_ButtonTag_7.setFunction("saveSelStatusOptions(); return checkMaritalStatus();");
          _jspx_th_impact_ButtonTag_7.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_7.setAction("/fad/HomeInfrmtn/saveHomeInformation");
          _jspx_th_impact_ButtonTag_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
          if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
}
          out.write("\r\n       </td>\r\n    </table>\r\n     <script>addQuestionMark();</script>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<br>\r\n");

  if (!bHideDocumentButton) {

  // JMC - SIR 19454
  // If the user does not have the maintain home security attribute
  // they should not be able to modify the document.
  // SMS#54783 Person assigned to stage should be able to modify the document
  boolean protectDoc = true;
  if ( ( user != null ) &&
       ( user.hasRight( UserProfile.SEC_MTN_HOME ) || GlobalData.hasStageAccess(request)) )
  {
    protectDoc = false;
  }  
  // SMS#54783 SAU_SEALED person who is not assigned to FAD stage should not be able to modify the documents
  if(user.hasRight( UserProfile.SEC_SAU_SEALED ) && !GlobalData.hasStageAccess(request)){
  protectDoc = true;
  }
  if (statusD.equals(HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE) ||
	 statusD.equals(HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE) ||
     statusD.equals(HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY) ||
     statusD.equals(HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY) ||
	 statusD.equals(HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE) ||
	 statusD.equals(HomeInfrmtnConversation.CODE_STATUS_CLOSED))
  {
    protectDoc = true;
  }
  if(pageMode.equals(PageModeConstants.VIEW))
  {
  protectDoc = true;
  }
  

      out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <th>Family Home Evaluation</th>\r\n    <tr>\r\n    <td>\r\n    ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnDocument.gif");
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n          ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("");
          _jspx_th_impact_document_0.setName("frmDocumentTag");
          _jspx_th_impact_document_0.setProtectDocument( protectDoc );
          _jspx_th_impact_document_0.setDocType("FRD03O00");
          _jspx_th_impact_document_0.setPostInSameWindow(false);
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setDocExists( bDocumentExists );
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pStage");
              _jspx_th_impact_documentParameter_0.setValue( globalIdStage );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("newStatus");
              _jspx_th_impact_documentParameter_1.setValue( newStatus );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n       </td>\r\n  </tr>\r\n</table>\r\n");
}
      out.write("\r\n<br>\r\n\r\n<script language=\"Javascript1.2\">\r\nfunction reloadReject()\r\n{\r\n    alert('Closure of home was not approved. If you no longer wish to close the home, select a new status for the home and resubmit the page.');\r\n}\r\n</script>\r\n");

 // SIR 18710 - We have to Call disableFHType() so the appropriate widgets will
 // be enabled or disabled in the Foster Home Type Section upon page load.

      out.write("\r\n\r\n<script language=\"Javascript1.2\">\r\n  ");

  //SIR 19050 -- The disableFHType should not be called when the pageMode is View
  // JMC - SIR 19404 - Replaced the following logic with the correct ! logic.
  //if((pageMode.equals(PageMode.VIEW)))
  if(!(pageMode.equals(PageModeConstants.VIEW)))
  {
  
      out.write("\r\n    disableFHType();\r\n  ");

  }
  
      out.write("\r\n  //SIR 16052 - call this at the bottom to allow the page to load\r\n  myOnLoadFunction();\r\n</script>\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("phoneID");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("selStatusOptions");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("submitted");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("addressID");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("addrVendorID");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("addressType");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("phoneType");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("addressSelected");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("phoneSelected");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_11.setType("hidden");
    _jspx_th_impact_validateInput_11.setName("phoneDelete");
    _jspx_th_impact_validateInput_11.setValue("");
    int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
    if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_12.setType("hidden");
    _jspx_th_impact_validateInput_12.setName("addressDelete");
    _jspx_th_impact_validateInput_12.setValue("");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_13.setType("hidden");
    _jspx_th_impact_validateInput_13.setName("addressArrayIndex");
    _jspx_th_impact_validateInput_13.setValue("");
    int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
    if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_14.setType("hidden");
    _jspx_th_impact_validateInput_14.setName("phoneArrayIndex");
    _jspx_th_impact_validateInput_14.setValue("");
    int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
    if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_15.setType("hidden");
    _jspx_th_impact_validateInput_15.setName("selCdFacilityCounty");
    _jspx_th_impact_validateInput_15.setValue("");
    int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
    if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_20(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_20.setType("hidden");
    _jspx_th_impact_validateInput_20.setName("szCReqFuncCd");
    _jspx_th_impact_validateInput_20.setValue("");
    int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
    if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_24(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_24.setType("hidden");
    _jspx_th_impact_validateInput_24.setName("holdChanged");
    _jspx_th_impact_validateInput_24.setValue("");
    int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
    if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_26(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_26.setType("hidden");
    _jspx_th_impact_validateInput_26.setName("prsChange");
    _jspx_th_impact_validateInput_26.setValue("");
    int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
    if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_27(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_27.setType("hidden");
    _jspx_th_impact_validateInput_27.setName("categoryChanged");
    _jspx_th_impact_validateInput_27.setValue("");
    int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
    if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_28(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_28.setType("hidden");
    _jspx_th_impact_validateInput_28.setName("licenseChanged");
    _jspx_th_impact_validateInput_28.setValue("");
    int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
    if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_29(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_29.setType("hidden");
    _jspx_th_impact_validateInput_29.setName("fosterTypeChanged");
    _jspx_th_impact_validateInput_29.setValue("");
    int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
    if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
