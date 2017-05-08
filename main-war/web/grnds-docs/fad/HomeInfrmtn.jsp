<%
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

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.SortedMap" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.Collections" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="java.util.Comparator" %>


<!--Start Main Content-->
<%
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
 %>
<impact:validateErrors />


<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="Javascript1.2">
// Check for changes before navigating off
window.onbeforeunload = function ()
{
  IsDirty();
};

window.attachEvent('onload', expandMySectionOnLoad);
function expandMySectionOnLoad()
{
 expandCollapsed('expanded' + 'hmDemographics', 'collapsed' + 'hmDemographics')
}


function expandAllCategories()
{
expandCollapsed('expandedDED2','collapsedDED2' )
expandCollapsed('expandedEBD2','collapsedEBD2' )
expandCollapsed('expandedEXB2','collapsedEXB2' )
expandCollapsed('expandedFHI2','collapsedFHI2' )
expandCollapsed('expandedHVI2','collapsedHVI2' )
expandCollapsed('expandedMED2','collapsedMED2' )
expandCollapsed('expandedMER2','collapsedMER2' )
expandCollapsed('expandedOTH2','collapsedOTH2' )

}


function collapseAllCategories()
{
expandCollapsed('collapsedDED2','expandedDED2' )
expandCollapsed('collapsedEBD2','expandedEBD2' )
expandCollapsed('collapsedEXB2','expandedEXB2' )
expandCollapsed('collapsedFHI2','expandedFHI2' )
expandCollapsed('collapsedHVI2','expandedHVI2' )
expandCollapsed('collapsedMED2','expandedMED2' )
expandCollapsed('collapsedMER2','expandedMER2' )
expandCollapsed('collapsedOTH2','expandedOTH2' )

}


function checkAllBoxesInSection (FieldName) {
	var index = 0;
	var objCheckBoxes = document.getElementsByName(FieldName + index++);

	while (objCheckBoxes.length > 0) {
		alert(FieldName);
	}
  }






// SMS #81140: MR-074
function doNothing()
{
  // do nothing;
  return true;
}

function saveSelStatusOptions()
{
  var form = document.frmHomeInformation;
  var options = form.<%= selStatusName %>.options;
  if (options == null)
  {
    return;
  }
  var selStatusOptionsString = "";
  
  for (var i = 0; i < options.length; i++)
  {
    
    selStatusOptionsString += options[i].value + "|" + options[i].text + ";";
  }
 
  form.selStatusOptions.value = selStatusOptionsString;
}


//read hidden field and populate selStatus.options based on hidden field
function populateSelStatusOptions()
{
  var form = document.frmHomeInformation;
  var selStatusOptionsString = form.selStatusOptions.value;
  if ((selStatusOptionsString == null) ||
      (selStatusOptionsString == ""))
  {
    return;
  }
  var optionsArray = selStatusOptionsString.split(";");
  //SIR 16052 - populate with the status from the request or database
  //rather than with the form variable (which was always set to Inquiry - 010)
  var selectedOption = '<%=statusD%>';
  //remove last "element" from the array which is just a blank value
  optionsArray.length--;
  clearDropdown(form.<%= selStatusName %>);
  populateDropdown(form.<%= selStatusName %>, selectedOption, optionsArray);
}

//Called onLoad of the page.  Disables comments box if their corresponding checkbox is unchecked.
//SIR 16052 moved to bottom of page - window.attachEvent('onload', myOnLoadFunction);

var oOptionFullApproved = document.createElement("OPTION");
oOptionFullApproved.text="<%= Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE)%>";
oOptionFullApproved.value="<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE %>";

var oOptionSpecApproved = document.createElement("OPTION");
oOptionSpecApproved.text="<%= Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE)%>";
oOptionSpecApproved.value="<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE%>";

var oOptionFullApproved = document.createElement("OPTION");
oOptionFullApproved.text="<%= Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY)%>";
oOptionFullApproved.value="<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY %>";

var oOptionSpecApproved = document.createElement("OPTION");
oOptionSpecApproved.text="<%= Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY)%>";
oOptionSpecApproved.value="<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY %>";

var oOptionTempApproved = document.createElement("OPTION");
oOptionTempApproved.text="<%= Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE)%>";
oOptionTempApproved.value="<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE %>";

var oOptionInquiry = document.createElement("OPTION");
oOptionInquiry.text="<%= Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_INQUIRY)%>";
oOptionInquiry.value="<%= HomeInfrmtnConversation.CODE_STATUS_INQUIRY %>";

var oOptionApplicant = document.createElement("OPTION");
oOptionApplicant.text="<%= Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_APPLICANT)%>";
oOptionApplicant.value="<%= HomeInfrmtnConversation.CODE_STATUS_APPLICANT %>";

var oOptionClosed = document.createElement("OPTION");
oOptionClosed.text="<%= Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HomeInfrmtnConversation.CODE_STATUS_CLOSED)%>";
oOptionClosed.value="<%= HomeInfrmtnConversation.CODE_STATUS_CLOSED %>";

var faHomeStatus = '<%= statusD %>';
var category = '<%= categoryD %>';

  function myOnLoadFunction()
  {

    var x = document.frmHomeInformation;
    // SIR# 18826. added the validation condition to the if statement. if there is an error we don't
    // want to repopulate the status drop down
    if (<%= FormValidation.pageHasValidationMessages("frmHomeInformation", request) ||
            FormValidation.pageHasErrorMessages(request) %>)
    {
      populateSelStatusOptions();
    }
    else
    {
      if (x.<%= selStatusName %>.value == '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE %>' &&
        x.status.value != '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE %>')
      {
        clearDropdown(x.<%= selStatusName %>);
        x.<%= selStatusName %>.add(oOptionFullApproved);
        x.<%= selStatusName %>.options[1].selected = true;
        CleanSelect(x.<%= selStatusName %>);
      }
      if (x.<%= selStatusName %>.value == '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE %>' &&
        x.status.value != '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE %>')
      {
        clearDropdown(x.<%= selStatusName %>);
        x.<%= selStatusName %>.add(oOptionSpecApproved);
        x.<%= selStatusName %>.options[1].selected = true;
        CleanSelect(x.<%= selStatusName %>);
      }
      if (x.<%= selStatusName %>.value == '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY %>' &&
        x.status.value != '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY %>')
      {
        clearDropdown(x.<%= selStatusName %>);
        x.<%= selStatusName %>.add(oOptionFullApproved);
        x.<%= selStatusName %>.options[1].selected = true;
        CleanSelect(x.<%= selStatusName %>);
      }
      if (x.<%= selStatusName %>.value == '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY %>' &&
        x.status.value != '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY %>')
      {
        clearDropdown(x.<%= selStatusName %>);
        x.<%= selStatusName %>.add(oOptionSpecApproved);
        x.<%= selStatusName %>.options[1].selected = true;
        CleanSelect(x.<%= selStatusName %>);
      }
      if (x.<%= selStatusName %>.value == '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE %>' &&
        x.status.value != '<%= HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE %>')
      {
        clearDropdown(x.<%= selStatusName %>);
        x.<%= selStatusName %>.add(oOptionTempApproved);
        x.<%= selStatusName %>.options[1].selected = true;
        CleanSelect(x.<%= selStatusName %>);
      }      
      if (x.<%= selStatusName %>.value == '<%= HomeInfrmtnConversation.CODE_STATUS_INQUIRY %>' &&
        x.status.value != '<%= HomeInfrmtnConversation.CODE_STATUS_INQUIRY %>')
      {
        clearDropdown(x.<%= selStatusName %>);
        x.<%= selStatusName %>.add(oOptionInquiry);
        x.<%= selStatusName %>.options[1].selected = true;
        CleanSelect(x.<%= selStatusName %>);
      }
     
      if (x.<%= selStatusName %>.value == '<%= HomeInfrmtnConversation.CODE_STATUS_CLOSED %>' &&
        <%= cfad07so != null && cfad07so.getROWCFAD07SOG04()!=null && "Y".equals(cfad07so.getROWCFAD07SOG04().getCIndRshsNonDFCSHome()) %>)
        
      {
        clearDropdown(x.<%= selStatusName %>);
        x.<%= selStatusName %>.add(oOptionClosed);
    	x.<%= selStatusName %>.add(oOptionInquiry);
        x.<%= selStatusName %>.options[1].selected = true;
        CleanSelect(x.<%= selStatusName %>);
      }
      
    }

    var cbxName = document.getElementById("ckOnHold_id");
    var checked = cbxName.checked;
    if (checked && <%=!bDisableOnHold%>) {
      disableLicensingFields();        
    }
  /* SIR#23327. added the if statement */
  if (x.chkIndNonDFCSHome.checked == true)
  {
    x.visibleSzCertifyEntity.disabled = false;
  }
  else
  {
    x.visibleSzCertifyEntity.disabled = true;
    x.visibleSzCertifyEntity.value = "";
  }

<%
// When the user enters the Home Information page for the first time after
// the supervisor has rejected a pending closure, they will be alerted
// the home closure was not approved and inform them to select another status
// and resubmit if they don't want to continue to close the home.

// We only want to call the reloadReject() javaScript if there is a rejected Pending
// Closure.
// SIR 23122 - don't call this if pages is in view mode.  the user can't modify
// the page anyway.
if (approvalRejected && !("true".equals( rejectClosureCase ) ) && !pageMode.equals(PageModeConstants.VIEW) )  {%>
    <%--'SIR 23122 - call reloadReject after page has finished loading so that
        the hiddenFieldStateForm has been defined'--%>
    window.attachEvent('onload',reloadReject);
<%}%>
}


function setHiddenEntity(x)
{
  var sp = document.getElementById("txtSzCertifyEntity_id");
  sp.value=x.value;
}

function disableLicensingFields()
{
  var x = document.frmHomeInformation;

  x.licenseDisabled.value = 'true';
  x.apprvlBeginDt.disabled = true;
  x.apprvlEndDt.disabled = true;
  x.txtCapacity.disabled = true;
  x.selMaleMinYear.disabled = true;
  var subInput4 = document.createElement("input");
  subInput4.name = 'selMaleMinYear';
  subInput4.value = x.selMaleMinYear.value;
  subInput4.type = 'hidden';
  x.selMaleMinMonth.disabled = true;
  var subInput5 = document.createElement("input");
  subInput5.name = 'selMaleMinMonth';
  subInput5.value = x.selMaleMinMonth.value;
  x.selMaleMaxYear.disabled = true;
  var subInput6 = document.createElement("input");
  subInput6.name = 'selMaleMaxYear';
  subInput6.value = x.selMaleMaxYear.value;
  x.selMaleMaxMonth.disabled = true;
  var subInput7 = document.createElement("input");
  subInput7.name = 'selMaleMaxMonth';
  subInput7.value = x.selMaleMaxMonth.value;
  x.selFemaleMinYear.disabled = true;
  var subInput8 = document.createElement("input");
  subInput8.name = 'selFemaleMinYear';
  subInput8.value = x.selFemaleMinYear.value;
  x.selFemaleMinMonth.disabled = true;
  var subInput9 = document.createElement("input");
  subInput9.name = 'selFemaleMinMonth';
  subInput9.value = x.selFemaleMinMonth.value;
  x.selFemaleMaxYear.disabled = true;
  var subInput10 = document.createElement("input");
  subInput10.name = 'selFemaleMaxYear';
  subInput10.value = x.selFemaleMaxYear.value;
  x.selFemaleMaxMonth.disabled = true;
  var subInput11 = document.createElement("input");
  subInput11.name = 'selFemaleMaxMonth';
  subInput11.value = x.selFemaleMaxMonth.value;


  disableFamTypes();
}

function launchDetailAddress(index, id, countyCD)
{
  frmHomeInformation.addressArrayIndex.value = index;
  frmHomeInformation.selCdFacilityCounty.value = countyCD;
  frmHomeInformation.szCReqFuncCd.value = '<%= ServiceConstants.REQ_FUNC_CD_UPDATE %>';
  document.frmHomeInformation.addressID.value = id;
  disableValidation('frmHomeInformation');
  submitValidateForm('frmHomeInformation', '/fad/HomeInfrmtn/displayAddressDetail');
}

function launchDetailPhone(index, id)
{
  frmHomeInformation.phoneArrayIndex.value = index;
  frmHomeInformation.szCReqFuncCd.value = '<%= ServiceConstants.REQ_FUNC_CD_UPDATE %>';
  document.frmHomeInformation.phoneID.value = id;
  disableValidation('frmHomeInformation');
  submitValidateForm('frmHomeInformation', '/fad/HomeInfrmtn/displayPhoneDetail');
}

function setAddressDeleteParms(vendorID, addressType, addressID, index)
{
  // disableValidation('frmHomeInformation'); //mxpatel commented this out for defect #10156
  document.frmHomeInformation.addressSelected.value = 'true';
  document.frmHomeInformation.addrVendorID.value = vendorID;
  document.frmHomeInformation.addressType.value = addressType;
  document.frmHomeInformation.addressID.value = addressID;
  document.frmHomeInformation.addressArrayIndex.value = index;
}

function setPhoneDeleteParms(phoneType, phoneID, index)
{
 // disableValidation('frmHomeInformation'); //mxpatel commented this out for defect #10156
  document.frmHomeInformation.phoneSelected.value = 'true';
  document.frmHomeInformation.phoneID.value = phoneID;
  document.frmHomeInformation.phoneType.value = phoneType;
  document.frmHomeInformation.phoneArrayIndex.value = index;
}

function checkSelectedStatusAddress()
{
  if (!(document.frmHomeInformation.addressSelected.value == 'true'))
  {
    alert ('<%=MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)%>');
    return false;
  }
  else
  {
    document.frmHomeInformation.FormValidateCancel = 'true';
    return true;
  }
}

function checkSelectedStatusPhone()
{
  if (!(document.frmHomeInformation.phoneSelected.value == 'true'))
  {
    alert ('<%=MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)%>');
    return false;
  }
  else
  {
    document.frmHomeInformation.FormValidateCancel = 'true';
    return true;
  }
}

function deleteAddressRow()
{

  var bRetValue = false;
  disableValidation('frmHomeInformation');//mxpatel added this for defect #10156
  if (checkSelectedStatusAddress())
  {
    
    if (document.frmHomeInformation.addressType.value == '<%= HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY %>')
    {
      alert ('<%=MessageLookup.getMessageByNumber(Messages.MSG_CMN_PRIMARY_ADDRESS_NO_DELETE)%>');
      bRetValue = false;
    }
    else if (document.frmHomeInformation.addrVendorID.value != '')
    {
      alert ('<%=MessageLookup.getMessageByNumber(Messages.MSG_RES_VID_ADDR)%>');
      bRetValue = false;
    }
    else
    {
      bRetValue = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>')
      if (bRetValue)
      {
        document.frmHomeInformation.addressDelete.value = 'true';
      }
    }
    return bRetValue;
  }
  else
  {
    return false;
  }
}

function deletePhoneRow()
{
  var bRetValue = false;
  disableValidation('frmHomeInformation'); //mxpatel added this for defect #10156
  if (checkSelectedStatusPhone())
  {
    if (document.frmHomeInformation.phoneType.value == '<%= HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY %>')
    {
      alert ('<%=MessageLookup.getMessageByNumber(Messages.MSG_CMN_PRIMARY_PHONE_NO_DELETE)%>');
      bRetValue = false;
    }
    else
    {
      bRetValue = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>')
      if (bRetValue)
      {
        document.frmHomeInformation.phoneDelete.value = 'true';
      }
    }
    return bRetValue;
  }
  else
  {
    return false;
  }
}

function setAdd()
{
  document.frmHomeInformation.szCReqFuncCd.value = '<%= ServiceConstants.REQ_FUNC_CD_ADD %>';
  disableValidation('frmHomeInformation');
}

function disableValidate()
{
 disableValidation('frmHomeInformation');
}

function saveSubmit()
{

  var x = document.frmHomeInformation;
  if (x.<%= selStatusName %>.value == '<%= HomeInfrmtnConversation.CODE_STATUS_PENDING_CLOSURE %>' &&
      x.closureBlob.value == '<%= HomeInfrmtnConversation.IND_NO %>')
  {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_FAD_CREATE_CLOSING) %>');
  }
  x.submitted.value = 'true';

}

function saveAssign()
{
  var x = document.frmHomeInformation;
 // x.selClosureReason.value = '';
}

function checkMaritalStatus()
{

  enableValidation( 'frmHomeInformation');
  var x = document.frmHomeInformation;
  if (x.selMaritalStatus.value != '<%= HomeInfrmtnConversation.CODE_MARRIED %>' &&
       x.marriageDate.value != '')
  {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_FAD_STATUS_NOT_MARRIED) %>');
    x.marriageDate.value = '';
  }

//  SIR 19032 -- If the NAH checkbox is checked
//               and the selCategory is
//               Adoptive, the user can't save the page.
  if(document.frmHomeInformation.chkIndNonDFCSHome.checked && document.frmHomeInformation.selCategory.value != '<%=HomeInfrmtnConversation.CODE_ADOPTIVE%>')
  {
    //alert ('<%=MessageLookup.getMessageByNumber(Messages.MSG_CATEGORY_ADO_NAH)%>');
    return true;
  }
  else
  {
    return true;
  }
}

function checkNonPrsHome(isChecked, originalStatus, originalCategory)
{
  var x = document.frmHomeInformation;
  if (x.chkIndNonDFCSHome.checked)
  {
    x.prsChange.value = 'true';
    //clearDropdown(x.<%= selStatusName %>);
    //x.<%= selStatusName %>.add(oOptionFullApproved);
    //x.<%= selStatusName %>.add(oOptionSpecApproved);
    //x.<%= selStatusName %>.add(oOptionTempApproved);
    //x.<%= selStatusName %>.options[1].selected = true;
    //x.selCategory.value = '<%= HomeInfrmtnConversation.CODE_ADOPTIVE %>';
  }
  else
  {
    if (isChecked) //has this record been saved already as a non-prs(dfcs) home?
    {
      var bRetValue = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_FAD_NONPRS_DESEL) %>');
      if (bRetValue)
      {
        x.prsChange.value = 'true';
        //clearDropdown(x.<%= selStatusName %>);
        //x.<%= selStatusName %>.add(oOptionInquiry);
        //x.<%= selStatusName %>.options[1].selected = true;
        //x.selCategory.value = originalCategory;
      //  x.selCategory.disabled = true;

      }
      else //cancel on confirm
      {
        x.prsChange.value = '';
        x.chkIndNonDFCSHome.checked = true;
      }
    }
    else //has NOT already been saved as non-prs home
    {
      x.prsChange.value = '';
      //clearDropdown(x.<%= selStatusName %>);
      //x.<%= selStatusName %>.add(oOptionInquiry);
      //x.<%= selStatusName %>.options[1].selected = true;
      //x.selCategory.value = originalCategory;
    }
  }

  /* SIR#23327. added the if statement */
  if (x.chkIndNonDFCSHome.checked)
  {
    x.visibleSzCertifyEntity.disabled = false;
  }
  else
  {
    x.visibleSzCertifyEntity.disabled = true;
    x.visibleSzCertifyEntity.value = "";
  }

  <% /* SIR 18710 - Since this function changes the value of the Category we
      have to call disableFHType to make sure the widgets are en/disabled */ %>
  //disableFHType();
}

function checkDocValidation()
{
  var x = document.frmHomeInformation;
  if (x.selMaritalStatus.value == '' || x.txtCapacity.value == '' ||
       x.txtCapacity.value == '0' || x.txtAnnualIncome.value == '' || x.txtAnnualIncome.value == '$ 0.00')
  {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_DOC_INVALID) %>');
    return false;
  }
  else if (x.selMaritalStatus.value == '<%= HomeInfrmtnConversation.CODE_MARRIED %>' &&
           x.marriageDate.value == '')
  {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_FAD_NO_MARRIAGE) %>');
    return false;
  }
  else
  {
    return true;
  }
}

function setMarriageDateDisable()
{
  var x = document.frmHomeInformation;
  if (x.selMaritalStatus.value != '<%= HomeInfrmtnConversation.CODE_MARRIED %>')
  {
    x.marriageDate.disabled = true;
  }
  else
  {
    x.marriageDate.disabled = false;
  }
}

function setOpenSlots()
{
  var x = document.frmHomeInformation;
  x.licenseChanged.value = 'true';
  var capacity = x.txtCapacity.value;
  var placements = x.txtPlacements.value;
  var openSlots = capacity - placements;
  if ((preventOverCapacity(capacity, placements)) == 'true'){
    openSlots = <%=capacity%> - placements;
    return false;
  }
  if (openSlots < 0)
  {
    openSlots = 0;
  }
  updateDisplayOnlyField('frmHomeInformation', 'txtOpenSlots', openSlots);
}

function preventOverCapacity(capacity, placements){
  if (parseInt(capacity) < parseInt(placements))
  {
    alert('Capacity can not be less than the number of Placements');
    return 'true';
  } else {
    return 'false';
  }
}

function setLicenseChange()
{
  var x = document.frmHomeInformation;  
  var i = x.numberHomeTypes.value;
  var j = 1;
  var changed = 'false';
  
  while (j <= i)
  {
    var checkbox = eval('document.frmHomeInformation.famTypes'+j+'_changed');
    if (checkbox != null)
    {
       if(checkbox.value.substring(0,1) != ' '){
          changed = 'true';
       }
    }
    j++;
  }
  if( !(x.txtCapacity.value == <%= cfad37so.getUNbrRsrcFacilCapacity() %> &&
      x.selMaleMinYear.value == <%= (cfad37so.getUNbrRsrcMlAgeMin()/12) %> &&
      x.selMaleMinMonth.value == <%= (cfad37so.getUNbrRsrcMlAgeMin()%12) %> &&
      x.selMaleMaxYear.value == <%= (cfad37so.getUNbrRsrcIntMaAgeMax()/12) %> &&
      x.selMaleMaxMonth.value == <%= (cfad37so.getUNbrRsrcIntMaAgeMax()%12) %> &&
      x.selFemaleMinYear.value == <%= (cfad37so.getUNbrRsrcFMAgeMin()/12) %> &&
      x.selFemaleMinMonth.value == <%= (cfad37so.getUNbrRsrcFMAgeMin()%12) %> &&
      x.selFemaleMaxYear.value == <%= (cfad37so.getUNbrRsrcFMAgeMax()/12) %> &&
      x.selFemaleMaxMonth.value == <%= (cfad37so.getUNbrRsrcFMAgeMax()%12) %> &&
      x.apprvlBeginDt.value == '<%= FormattingHelper.formatDate( dtApprovalBegin ) %>' &&
      x.apprvlEndDt.value == '<%= FormattingHelper.formatDate( dtApprovalEnd ) %>')){
    changed = 'true';
  }
    x.licenseChanged.value = changed;
}

function setFosterTypeChange()
{
  var x = document.frmHomeInformation;
  x.fosterTypeChanged.value = 'false';
  var i = x.numberHomeTypes.value;
  var j = 1;
  while (j <= i)
  {
    var checkbox = eval('document.frmHomeInformation.famTypes'+j+'_changed');
    if (checkbox != null)
    {
       if(checkbox.value.substring(0,1) != ' '){
          x.fosterTypeChanged.value = 'true';
       }
    }
    j++;
  }
  setLicenseChange();
}

function setOnHold()
{
  var x = document.frmHomeInformation;
  var checkbox = eval('document.frmHomeInformation.ckOnHold_changed');
  if (checkbox != null)
  {
     if(checkbox.value.substring(0,1) != ' '){
       x.holdChanged.value = 'true';
     }
  }
  if (x.licenseChanged.value == 'true')
  {
    alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_FAD_APRV_BEFORE_ON_HOLD) %>');
	if (checkbox != null)
    {
      if(checkbox.value.substring(1,1) == 'Y'){
        x.ckOnHold.checked = true;
      }else{
        x.ckOnHold.checked = false;
      }
    }
  }
  else
  {
    if (x.ckOnHold.checked && <%= !bDisableOnHold %>)
    {
      alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_FAD_UNCHECK_ON_HOLD) %>');
      x.licenseDisabled.value = 'true';
      x.txtCapacity.disabled = true;
      disableLicensingFields();
    }
    else
    {
      x.licenseDisabled.value = 'false';
	  x.apprvlBeginDt.disabled = false;
	  x.apprvlEndDt.disabled = false;
      x.txtCapacity.disabled = false;
      x.selMaleMinYear.disabled = false;
      x.selMaleMinMonth.disabled = false;
      x.selMaleMaxYear.disabled = false;
      x.selMaleMaxMonth.disabled = false;
      x.selFemaleMinYear.disabled = false;
      x.selFemaleMinMonth.disabled = false;
      x.selFemaleMaxYear.disabled = false;
      x.selFemaleMaxMonth.disabled = false;

<% 
	  /*
	  This really is a disable/enable function in case category
	  is Adoptive we dont want to enable Foster Home type section.
	  */
 %>
      disableFHType();
    }
  }
}

function disableFHType()
{
  <% /* SIR 18710 - We have to disable and clear the widgets in the Foster Home
   Type Section if the category is "A" - Adoptive */ %>
   if (document.frmHomeInformation.selCategory.value == "<%= HomeInfrmtnConversation.CODE_ADOPTIVE%>")
   {
     disableFamTypes();
   }
   else
   {
     enableFamTypes();
   }
}

function categoryChange()
{
  //STGAP00017883 Added alert to warn user that changing the home Category will
  //require a home closure and thus effect future and current placements
  if (<%= String.valueOf(idResource) %> != 0) {
    alert("Before the home category can be changed, the home must be closed, and reopened with a status of Inquiry for the purpose of reassessment. Changing this home category can jeopardize future placements and payments for this home.");
    }
  var x = document.frmHomeInformation;

  // if the checkbox is disabled and unchecked, there will be no field named
  // ckOnHold. If the checkbox is disabled and checked, there will be a field
  // named ckOnHold, but it will be a hidden field. In either of these cases,
  // we do not want to run anything that attempts to set ckOnHold.disabled or
  // ckOnHold.checked.
  if ((document.getElementsByName("ckOnHold")[0] != null) &&
      (x.ckOnHold.type == "checkbox"))
   {
    if (x.ckOnHold.checked == true)
    {
      alert("Category cannot be changed while \"Placement Hold\" is checked in Home Approval.");
      x.selCategory.value = category;
      return;
    }
   }
  category = x.selCategory.value;
  
  x.categoryChanged.value = 'true';
  
  disableFHType();
}

function statusChange()
{
  var x = document.frmHomeInformation;

  // if the checkbox is disabled and unchecked, there will be no field named
  // ckOnHold. If the checkbox is disabled and checked, there will be a field
  // named ckOnHold, but it will be a hidden field. In either of these cases,
  // we do not want to run anything that attempts to set ckOnHold.disabled or
  // ckOnHold.checked.
  if ((document.getElementsByName("ckOnHold")[0] != null) &&
      (x.ckOnHold.type == "checkbox"))
  {
    if (x.ckOnHold.checked == true)
    {

      alert("Status cannot be changed while \"Placement Hold\" is checked in Home Approval.");
      x.<%= selStatusName %>.value = faHomeStatus;
      return false;
    }
    if(x.<%= selStatusName %>.value == '<%=HomeInfrmtnConversation.CODE_STATUS_APPROVED_FULL_ACTIVE%>' ||
       x.<%= selStatusName %>.value == '<%=HomeInfrmtnConversation.CODE_STATUS_APPROVED_SPEC_ACTIVE%>' ||
       x.<%= selStatusName %>.value == '<%=HomeInfrmtnConversation.CODE_STATUS_APPROVED_TEMP_ACTIVE%>')
    {
      x.ckOnHold.disabled = false;
    }
    else
    {
      x.ckOnHold.disabled = true;
    }
  }
  faHomeStatus = x.<%= selStatusName %>.value;
}

function disableFamTypes()
{
  if (<%= bDisableLicensing %> && <%= bDisableOnHold %>)
  {
    return;
  }

  var x = document.frmHomeInformation;
  var i = x.numberHomeTypes.value;
  var j = 1;
  while (j <= i)
  {

    var checkbox = eval('document.frmHomeInformation.famTypes'+j);
    if (checkbox == null)
    {
       return;
    }    
    checkbox.disabled = true;
    var subInput3 = document.createElement("input");
    subInput3.name = checkbox.name;
    if (checkbox.checked)
    {
      subInput3.value = checkbox.value;
    }
    subInput3.type = 'hidden';
    j++;
  }

}


function enableFamTypes()
{
  var x = document.frmHomeInformation;
  var i = x.numberHomeTypes.value;
  var j = 1;
  while (j <= i)
  {
    var checkbox = eval('document.frmHomeInformation.famTypes'+j);
    if (checkbox == null)
    {
       return;
    }
    checkbox.disabled = false;
    j++;
  }

}

<impact:codeArray orderBy="decode" codeName="<%= CodesTables.CSCHELEM %>" arrayName="elementaryArray" blankValue="true"/>
<impact:codeArray orderBy="decode" codeName="<%= CodesTables.CSCHMDDL %>" arrayName="middleArray" blankValue="true"/>
<impact:codeArray orderBy="decode" codeName="<%= CodesTables.CSCHHIGH %>" arrayName="highArray" blankValue="true"/>
/*
 * populates all the schools for the 
 * selected school district
 */
 window.attachEvent('onload', populateSchools);
 

// creating function to bypass architectural constraints
function addQuestionMark(){
	// get the parent node of the input element
	var labels = document.getElementsByTagName('label');
	var SEXUALLY_ACTING_OUT = document.getElementById('chbDecode').value;
	for(var i = 0; i < labels.length; i++){
		var label = labels[i];
		var inn = label.innerHTML;
		if(SEXUALLY_ACTING_OUT == inn){
			// get the cell that the label is in (it's parent node)
			var cell = label.parentNode;
			// append html to the end of the node's inner html contents
			var inner = cell.innerHTML;
			cell.innerHTML = inner + '&nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayHelp()">?</a></strong>';
			break;
		}
	}	
}


function displayHelp(){
  var descriptor = "";
  
  // describe the window properties
  descriptor += "width=450,";
  descriptor += "height=350,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=1,";
  descriptor += "fullscreen=0,";
  descriptor += "location=1,";
  descriptor += "menubar=0,";
  descriptor += "resizable=1,";
  descriptor += "scrollbars=1,";
  descriptor += "status=1,";
  descriptor += "toolbar=0";
  
  // open person characteristic help page
  return window.open('/person/PersonDetail/displayPersonCharacteristicsHelp', "", descriptor);
}

 function populateSchools()
 {
   var schoolDistrictCode = document.frmHomeInformation.selSchoolDistrict.value;

   if ( schoolDistrictCode == "" )
   {
      clearDropdown( frmHomeInformation.selSzCdElementary );
      clearDropdown( frmHomeInformation.selSzCdMiddle );
      clearDropdown( frmHomeInformation.selSzCdHigh );
   }
   else
   {
      populateDropdownByLoopingThroughArray( "frmHomeInformation", "selSzCdElementary",elementaryArray, schoolDistrictCode, 3, "<%=FormattingHelper.formatString(elementary)%>" );
      populateDropdownByLoopingThroughArray( "frmHomeInformation", "selSzCdMiddle",middleArray, schoolDistrictCode, 3, "<%=FormattingHelper.formatString(middle)%>" );
      populateDropdownByLoopingThroughArray( "frmHomeInformation", "selSzCdHigh",highArray, schoolDistrictCode, 3, "<%=FormattingHelper.formatString(high)%>" );
   }
 }
 
 function selectAll(catCode, numOfCheckboxes, checkValue) {
  var checkboxField;

  for ( i = 1; i <= numOfCheckboxes; i++ )
  {
    checkboxField = eval('document.frmHomeInformation.CharCbx' + catCode + i);
	var field = 'CharCbx' + catCode + i;
	
	if (checkValue && checkboxField.checked != checkValue)
	 {
	 checkboxField.click();
	 }
      else if (checkboxField.checked != checkValue)
             {
             checkboxField.click();
             }
  }
}
 
 
</script>


<impact:validateForm name="frmHomeInformation"
          method="post"
          action="/fad/HomeInfrmtn/displayHomeInformation"
          validationClass="gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnCustomValidation"
          pageMode="<%= pageMode %>"
          schema="/WEB-INF/Constraints.xsd">

<impact:validateInput type="hidden" name="pageMode" value="<%= pageMode %>"/>
<impact:validateInput type="hidden" id="chbDecode" name="chbDecode" value="<%= Lookup.simpleDecodeSafe("CHB", "70") %>"/>
<impact:validateInput type="hidden" name="phoneID" value=""/>
<impact:validateInput type="hidden" name="selStatusOptions" value=""/>
<impact:validateInput type="hidden" name="submitted" value=""/>
<impact:validateInput type="hidden" name="addressID" value=""/>
<impact:validateInput type="hidden" name="addrVendorID" value=""/>
<impact:validateInput type="hidden" name="addressType" value=""/>
<impact:validateInput type="hidden" name="phoneType" value=""/>
<impact:validateInput type="hidden" name="addressSelected" value=""/>
<impact:validateInput type="hidden" name="phoneSelected" value=""/>
<impact:validateInput type="hidden" name="phoneDelete" value=""/>
<impact:validateInput type="hidden" name="addressDelete" value=""/>
<impact:validateInput type="hidden" name="addressArrayIndex" value=""/>
<impact:validateInput type="hidden" name="phoneArrayIndex" value=""/>
<impact:validateInput type="hidden" name="selCdFacilityCounty" value=""/>
<impact:validateInput type="hidden" name="hdnCdFacilityCounty" value="<%= county %>"/>
<impact:validateInput type="hidden" name="documentExists" value="<%= String.valueOf(bDocumentExists) %>"/>
<impact:validateInput type="hidden" name="closureBlob" value="<%= closureBlob %>"/>
<impact:validateInput type="hidden" name="closureDate" value="<%= String.valueOf(closureDate) %>"/>
<impact:validateInput type="hidden" name="szCReqFuncCd" value=""/>
<impact:validateInput type="hidden" name="onLoadStatus" value="<%= statusD %>"/>
<impact:validateInput type="hidden" name="fieldsDisabled" value="<%= String.valueOf(bDisableAllFields) %>"/>
<impact:validateInput type="hidden" name="licenseDisabled" value="<%= String.valueOf(bDisableLicensing) %>"/>
<impact:validateInput type="hidden" name="holdChanged" value=""/>
<impact:validateInput type="hidden" name="status" value="<%= statusD %>"/>
<impact:validateInput type="hidden" name="prsChange" value=""/>
<impact:validateInput type="hidden" name="categoryChanged" value=""/>
<impact:validateInput type="hidden" name="licenseChanged" value=""/>
<impact:validateInput type="hidden" name="fosterTypeChanged" value=""/>
<impact:validateInput type="hidden" name="timestamp" value="<%= String.valueOf(timestamp) %>"/>
<impact:validateInput type="hidden" name="timestampLIC" value="<%= String.valueOf(timestampLIC) %>"/>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>

<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr><td align="left">

<%
 if (!bHideApproveButton)
{%>
       <impact:ButtonTag
       name="btnApprvlStatus"
       img="btnApprovalStatus"
       form="frmHomeInformation"
       navAwayCk="true"
       editableMode="<%= EditableMode.ALL %>"
       function="<%=strFunction%>"
       action="<%=ApprovalStatusConversation.DISPLAY_URI%>"
       tabIndex="<%= tabIndex++ %>"/>
<%}%>

</td>

<td align="right">
        <a tabIndex="<%= tabIndex++ %>" href="#" onClick="javascript:expandAll();">Expand All</a>&nbsp;
        <a tabIndex="<%= tabIndex++ %>" href="#" onClick="javascript:collapseAll();">Collapse All</a>&nbsp;
</td>
 </tr>
</table>

<table width="100%" class="tableborder" border="0" cellspacing="0" cellpadding="3">
<th colspan="4">Home Information</th>
<tr class="subDetail">
  <td>
  <impact:validateInput
        tabIndex="<%= tabIndex++ %>"
        name="txtHomeName"
        label="Home Name"
        type="text"
        value="<%= homeName %>"
        required="<%= String.valueOf( !bDisableAllFields ) %>"
        disabled="<%= String.valueOf(bDisableAllFields) %>"
        cssClass="formInput"
        size="30"
        maxLength="30"
        constraint="Name30" />
  </td>
  <td><impact:validateDisplayOnlyField
        name="resourceIDDisplayOnly"
        label="Resource ID"
        value="<%= String.valueOf(idResource) %>" />
  </td>
</tr>
<tr class="subDetail">
  <td>
     <impact:validateInput
      tabIndex="<%= tabIndex++ %>"
      value="<%= legalName %>"
      type="text"
      name="txtLegalName"
      label="Legal Name"
      required="<%= String.valueOf( !bDisableAllFields ) %>"
      cssClass="formInput"
      colspan="2"
      size="45"
      disabled="<%= String.valueOf(bDisableAllFields) %>"
      maxLength="45"/>
  </td>      
</tr>
  <tr class="subDetail">
     <td><impact:validateSelect
        tabIndex="<%= tabIndex++ %>"
        value="<%= categoryD %>"
        name="selCategory"
        label="Category"
        onChange="categoryChange()"
        codesTable="<%= CodesTables.CFACATEG %>"
        required="<%= String.valueOf(!bDisableCategoryField && !bDisableAllFields) %>"
        disabled="<%= String.valueOf(bDisableCategoryField || bDisableAllFields) %>"/>
        </td>
     <td><impact:validateSelect
        tabIndex="<%= tabIndex++ %>"
        value="<%= statusD %>"
        name="selStatus"
        label="Status"
        blankValue="false"
        onChange="statusChange();"
        options="<%= statusOptions %>"
        overrideDisplayBadCodes="true"
        disabled="<%= String.valueOf(bDisableStatusField) %>"
        style="WIDTH: 200px" />
     </td>
</tr>
  <tr class="subDetail">
     <td><impact:validateSelect
        tabIndex="<%= tabIndex++ %>"
        value="<%= FormattingHelper.formatString( cdExchangeStat ) %>"
        name="selAdExchStatus"
        label="AD Exchg. Status"
        codesTable="<%= CodesTables.CADEXCHG %>"
        disabled="<%= String.valueOf(bDisableAllFields) %>"/>
        </td>
     <td><impact:validateInput
              tabIndex="<%= tabIndex++ %>"
              value="ON"
              type="checkbox"
              checked="<%= String.valueOf(isWaiverExists) %>"
              name="chkWaiverExists"
              disabled="<%= String.valueOf(bDisableAllFields) %>"
              label="Waiver Exists"
              cssClass="formInput" />
     </td>
</tr>
</table>
<br>
<impact:ExpandableSectionTag
name="hmDemographics"
id="selEthnicity_Id"
label="Home Demographics"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">

<table width="100%" class="tableborder" border="0" cellspacing="0" cellpadding="3">
<tr class="subDetail">
          <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= religion %>"
               name="selReligion"
               label="Religion"
               codesTable="<%= CodesTables.CRELIGNS %>"
               required="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"/>
          </td>
          <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= language %>"
               name="selLanguage"
               label="Language"
               codesTable="<%= CodesTables.CLANG %>"
               required="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"/>
          </td>
        </tr>
        <tr class="subDetail">
          <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= respite %>"
               name="selRespite"
               label="Respite"
               codesTable="<%= CodesTables.CFARSPIT %>"
               required="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"/>
         </td>
          <td><impact:validateInput
               tabIndex="<%= tabIndex++ %>"
               value="<%= annualIncome %>"
               type="text"
               name="txtAnnualIncome"
               label="Annual Income"
               required="<%= String.valueOf(bAnnualMarital) %>" 
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               cssClass="formInput"
               size="12"
               maxLength="12"
               constraint="Money"/>
          </td>
         </tr>
         <tr class="subDetail">
          <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= maritalStatus %>"
               name="selMaritalStatus"
               label="Marital Status"
               excludeOptions="<%= excludeFAMSTRC %>"
               codesTable="<%= CodesTables.CFAMSTRC %>"
               onChange="setMarriageDateDisable();"
               required="<%= String.valueOf(bAnnualMarital) %>" 
               disabled="<%= String.valueOf(bDisableAllFields) %>"/>
         </td>
         <td><impact:validateDate
               size="10"
               value="<%= FormattingHelper.formatDate(marriageDate) %>"
               name="marriageDate"
               tabIndex="<%= tabIndex++ %>"
               label="Marriage Date"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               colspan="2"
               constraint="Date"/>
          </td>
         </tr>
         <%-- SIR 22492 PRS --> FPS onClick="<%= javascriptString %>"--%>
        <% String javascriptString = "javascript:checkNonPrsHome("+isNonDFCSHome+", '"+statusD+"', '"+categoryD+"');";  %>         
         <tr class="subDetail">
         <td colspan="2">
    <table>
           <tr>
          <td><impact:validateInput
              tabIndex="<%= tabIndex++ %>"
              value="on"
              type="checkbox"
              checked="<%= String.valueOf(isNonDFCSHome) %>"
              colspan="2"
              name="chkIndNonDFCSHome"
              onClick="<%= javascriptString %>"
              label="Non-DFCS Home"
              disabled="<%= String.valueOf(bDisableAllFields) %>"
              cssClass="formInput" />
         </td>
         <td>&nbsp;</td>
     </tr>
     <impact:validateInput type="hidden" name="txtSzCertifyEntity" value="<%= certifyEntity %>"/>
         </table>
         </td>
          <td>
          <impact:validateInput
             type="text"
             label="Non-DFCS Certifying Entity"
             name="visibleSzCertifyEntity"
             disabled="<%= String.valueOf(bDisableAllFields) %>"
             cssClass="formInput"
             value="<%= certifyEntity %>"
             constraint="Paragraph30"
             onChange="setHiddenEntity(this)"
             size="30"
             maxLength ="30"
             tabIndex="<%=tabIndex++%>"/>
         </td>
        </tr>         
        <tr class="subDetail">
         <td colspan="4">
         <table>
           <tr>
           <td><impact:validateInput
              tabIndex="<%= tabIndex++ %>"
              type="checkbox"
              checked="<%= String.valueOf(isCurrHomeSdyExst) %>"
              colspan="2"
              name="chkIndCurrHomeStudyExists"
              label="A Current Home Study Exists"
              disabled="<%= String.valueOf(bDisableAllFields) %>"
              cssClass="formInput" />
         </td>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
          <td>&nbsp;</td>
     </tr>
         </table>
         </td>
        </tr>
        <tr class="subDetail">
         <td colspan="4">
         <table>
           <tr>
           <td><impact:validateInput
              tabIndex="<%= tabIndex++ %>"
              type="checkbox"
              checked="<%= String.valueOf(isPrevHomeStdy) %>"
              name="chkIndPrevHomeStudy"
              disabled="<%= String.valueOf(bDisableAllFields) %>"
              label="Previous Home Study"
              cssClass="formInput" />
            </td>
        
         <td>&nbsp;</td>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
     </tr>
         </table>
         </td>
        </tr>        
      <tr class="subDetail">
        <td>
          <impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            value="<%= FormattingHelper.formatString( schoolDistrict ) %>"
            name="selSchoolDistrict"
            label="School District"
            codesTable="<%= CodesTables.CSCHDSTR %>"
            required="false"
            onChange="populateSchools()"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
        </td>
     <td>
           <impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            value="<%= elementary %>"
            name="selSzCdElementary"
            label="Elementary"
            codesTable="<%= CodesTables.CSCHELEM%>"
            style="WIDTH:200px"
            required="false"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
     </td>
      </tr>
      <tr class="subDetail">
        <td colspan="2">&nbsp;</td>
        <td><impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            value="<%= middle %>"
            name="selSzCdMiddle"
            label="Middle"
            codesTable="<%= CodesTables.CSCHMDDL%>"
            style="WIDTH:200px"
            required="false"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
         </td>
      </tr>
      <tr class="subDetail">
        <td colspan="2">&nbsp;</td>
        <td><impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            value="<%= high %>"
            name="selSzCdHigh"
            label="High"
            codesTable="<%= CodesTables.CSCHHIGH%>"
            style="WIDTH:200px"
            required="false"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
         </td>      
      </tr>
    </table>
</impact:ExpandableSectionTag>
      <BR>

<impact:ExpandableSectionTag
name="address"
id="addressItemSelect_CLEAN_Id"
label="Address List"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">
<table width="100%" cellspacing="0" cellpadding="3" class="tableborder">
<th class="thList">&nbsp;</th>
<th class="thList">Type</th>
<th class="thList">Vendor ID</th>
<th class="thList">Attention</th>
<th class="thList">Address</th>
<th class="thList">County</th>
<th class="thList">Comments</th>
<%
int loopCount = 0;
if (addressEnumeration != null)
{
if (!addressEnumeration.hasMoreElements())
{
%>
 <tr class="odd">
  <td colspan="7">
   <a href="#" id="addressItemSelect_CLEAN_Id"><%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %></a>
  </td>
</tr>
<%
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
 %>
   <tr class="<%=FormattingHelper.getRowCss(loopCount+1)%>">
 <td><% if (!pageMode.equals(PageModeConstants.VIEW) && !bDisableAllFields) {%>
  <impact:validateInput
   tabIndex="<%= tabIndex++ %>"
   value=""
   onClick="<%= onClickString %>"
   type="radio"
   name="rbAddressItemSelect_CLEAN"
   cssClass="formInput"/>
  <%}%>
 </td>
 <td>
<%
    String launchAddressString = "javascript:launchDetailAddress("+loopCount+", "+addressID+", '"+addressCountyCode+"')";
    if ((!pageMode.equals(PageModeConstants.VIEW) && !bDisableAllFields) || editPlusVendorId) {%>
 <a href="<%=launchAddressString%>"><%= addressType %></a>
<%
    }
    else
    {
%>
  <%= addressType %>
<%
    }
%>
 </td><% String vid = addressRow.getSzNbrRsrcAddrVid();
    if (!"".equals(vid) && "02".equals(addrTypeCD))
    {
%>
  <impact:validateInput type="hidden" name="vid" value="<%= vid %>"/>
<%
    }
%>
 <td><%= FormattingHelper.formatString( vid ) %></td>
 <td><%= FormattingHelper.formatString( addressRow.getSzAddrRsrcAddrAttn() ) %></td>
 <td><%= fullAddress %></td>
 <td><%= Lookup.simpleDecodeSafe(CodesTables.CCOUNT, addressRow.getSzCdFacilityCounty()) %></td>
 <td align="center">
<%
   if( addressRow.getSzTxtRsrcAddrComments() != null && !StringHelper.EMPTY_STRING.equals(addressRow.getSzTxtRsrcAddrComments()))
   {
%>
  <img alt="checkmark" src="/grnds-docs/images/shared/checkMark_short.gif"> 
<%
   }
   else
   {
%>
     &nbsp;
<%
   }
%>
</td>
<%
   loopCount++;
  } //end while
}
} //end if address enumeration not null
else
{
%>
     <tr class="odd">
       <td colspan="7">
        <a href="#" id="addressItemSelect_CLEAN_Id"><%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %></a>
       </td>
     </tr>
<%
}
%>
</table>
<table width="100%"><tr>
        <td>
        <impact:ButtonTag
             name="btnDeleteAddress"
             img="btnDelete"
             form="frmHomeInformation"
             navAwayCk="true"
             restrictRepost="true"
             disabled='<%= "" + bDisableAllFields %>'
             function="return deleteAddressRow();"
             action="/fad/HomeInfrmtn/deleteAddressRow"
             tabIndex="<%= tabIndex++ %>"/>
        </td>
        <td align="right">
        <impact:ButtonTag
             name="btnAddAddress"
             img="btnAdd"
             form="frmHomeInformation"
             navAwayCk="true"
             restrictRepost="true"
             function="setAdd();"
             disabled='<%= "" + bDisableAllFields %>'
             action="/fad/HomeInfrmtn/addAddress"
             tabIndex="<%= tabIndex++ %>"/>
        </td>
    </table>

</impact:ExpandableSectionTag>
<br>

<impact:ExpandableSectionTag
    name="phone"
    id="rbPhoneItemSelect_CLEAN_Id"
    label="Phone List"
    tabIndex="<%= tabIndex++ %>"
    anchor="anchorName">

<table width="100%" cellspacing="0" cellpadding="3" class="tableborder">
<th class="thList">&nbsp;</th>
<th class="thList">Type</th>
<th class="thList">Phone</th>
<th class="thList">Ext</th>
<th class="thList">Comments</th>
<%
int loopCount1 = 0;
if (phoneEnumeration != null)
{
  if (!phoneEnumeration.hasMoreElements())
  {
%>
 <tr class="odd">
  <td colspan="7">
   <a href="#" id="rbPhoneItemSelect_CLEAN_Id"><%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %></a>
  </td>
</tr>
<%
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
 %>
   <tr class="<%=FormattingHelper.getRowCss(loopCount1+1)%>">
 <td><%
      if (!pageMode.equals(PageModeConstants.VIEW) && !bDisableAllFields) {
%>
  <impact:validateInput
   tabIndex="<%= tabIndex++ %>"
   value=""
   onClick="<%= onClickString1 %>"
   type="radio"
   name="rbPhoneItemSelect_CLEAN"
   cssClass="formInput"/>
<%
     }
%>
 </td>
 <td>
 <% if (!pageMode.equals(PageModeConstants.VIEW) && !bDisableAllFields) {%>
 <a href="javascript:launchDetailPhone(<%= loopCount1 %>, <%= phoneID %>)"><%= phoneType %></a>
<%
}
else
{
%>
  <%= phoneType %>
<%
}
%>
 </td>
 <td><%= FormattingHelper.formatPhone(phoneRow.getLNbrFacilPhoneNumber()) %></td>
 <td><%= FormattingHelper.formatString( phoneRow.getLNbrFacilPhoneExtension() ) %></td>
 <td><%
 if(phoneRow.getSzTxtRsrcPhoneComments() != null && !StringHelper.EMPTY_STRING.equals(phoneRow.getSzTxtRsrcPhoneComments()))
   {
%>
     <img alt="checkmark" src="/grnds-docs/images/shared/checkMark_short.gif">
<%
}
else
{
%>
     &nbsp;
<%
}
%>
</td>
<%  loopCount1++;
  } //end while
}
} //end if phone enumeration not null
else
{
  %>
 <tr class="odd">
  <td colspan="7">
   <a href="#" id="addressItem_0"><%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %></a>
  </td>
</tr>
<%
}
%>
</table>
<table cellspacing="0" cellpadding="3" width="100%"><tr>
    <% if (!bDisableAllFields)
    {%>
        <td>
        <impact:ButtonTag
             name="btnDeletePhone"
             img="btnDelete"
             form="frmHomeInformation"
             navAwayCk="true"
             restrictRepost="true"
             function="return deletePhoneRow();"
             action="/fad/HomeInfrmtn/deletePhoneRow"
             tabIndex="<%= tabIndex++ %>"/>
        </td>
    <%}
      if (!bDisableAllFields)
    {%>

        <td align="right">
        <impact:ButtonTag
             name="btnAddPhone"
             img="btnAdd"
             navAwayCk="true"
             form="frmHomeInformation"
             restrictRepost="true"
             function="setAdd();"
             action="/fad/HomeInfrmtn/addPhone"
             tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%}%>
    </table>

</impact:ExpandableSectionTag>
<br>
<%-- New section that is required for shines Inquiry Information --%>
<impact:ExpandableSectionTag
name="inquiryInformation"
id="idInquiryInformation"
label="Inquiry Information"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="subDetail">
  <tr>
    <td>
        <impact:validateDisplayOnlyField name="dtDtInquiryDate" label="Inquiry Date" value="<%= FormattingHelper.formatDate( inquiryDate ) %>" />
    </td>
<td>
    <impact:validateDate label="Date Applied" name="dtDtAppliedDate" tabIndex="<%=tabIndex++%>"
                               size="10" constraint="Date" value="<%= FormattingHelper.formatDate( dtApplied ) %>"
                                disabled="<%= String.valueOf(bDisableAllFields) %>"/>

    </td>
  </tr>
  <tr>
    <td>
    <impact:validateSelect label="Information Packet Requested" name="selCdInfoPcktRqstd" tabIndex="<%=tabIndex++%>"
                               codesTable="CINFPKRQ" disabled="<%= String.valueOf(bDisableAllFields) %>" value="<%= infoPacktRequested %>"/>
    </td>
    <td>
    <impact:validateDate label="Information Packet Sent" name="dtDtInfoPcktSent" tabIndex="<%=tabIndex++%>"
                               size="10" constraint="Date" value="<%= FormattingHelper.formatDate( infPacktSent ) %>"
                                disabled="<%= String.valueOf(bDisableAllFields) %>"/>

    </td>
  </tr>
  <tr>
    <td>
    <impact:validateInput type="text" label="Requested Number Of Children" name="txtNbrRqstdNbrOfChldrn"
            disabled="<%= String.valueOf(bDisableAllFields) %>" cssClass="formInput" value="<%= FormattingHelper.formatInt( iRequestedNbrOfChildren ) %>" constraint="Numeric" size="3" maxLength ="3" tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
      <impact:validateInput
         type="text"
         label="Child Specific Interest"
         name="txtSzChldSpcfcInterest"
         disabled="<%= String.valueOf(bDisableAllFields) %>"
         cssClass="formInput"
         value="<%= childSpecInterest %>"
         constraint="Paragraph30"
         size="30"
         maxLength ="30"
                           tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
     <tr>
      <td>
    <impact:validateSelect label="Inquiry Received By" name="txtSzCdInqryRcvdBy"
        tabIndex="<%=tabIndex++%>" disabled="<%= String.valueOf(bDisableAllFields) %>"
              codesTable="CINQRCBY" value="<%= inqRecvdBy %>"/>
    </td>
    </tr>
  <tr colspan="4">
    <td >
           <impact:validateTextArea
            name="txtInquiryComments"
            colspan="3"
            label="Inquiry Comments"
            rows="4"
            cols="70"
            tabIndex="<%= tabIndex++ %>"
            maxLength="300"
            disabled="<%= String.valueOf(bDisableAllFields) %>"
            constraint="Comments">
            <%= FormattingHelper.formatString( inquiryComments ) %>
          </impact:validateTextArea>
    </td>
  </tr>
</table>
<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
<th colspan="8">Sources Of Inquiry</th>
<tr class="subDetail">
     <% int srcOfInqLoopCount = 0;
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
        %>
  <td>
      <impact:validateInput
        name="<%= chkbxSrcName %>"
        checked="<%= String.valueOf(srcOfInqChecked) %>"
        type="checkbox"
        value="<%= srcOfInqCode %>"
        cssClass="formInput"
        label="<%= Lookup.simpleDecodeSafe(CodesTables.CFASRCIN, srcOfInqCode)%>"
        disabled="<%= String.valueOf(bDisableAllFields) %>"
        tabIndex="<%= tabIndex++ %>"/>
  </td>
        <%if (srcOfInqLoopCount % 3 == 0)
    {%>
       </tr><tr class="subDetail">
    <%}
     } //end while
     if (srcOfInqLoopCount % 3 == 1)
      { %>
           <td colspan="4">&nbsp;</td>
          <%}
           else if(srcOfInqLoopCount % 3 == 2)
           { %>
          <td colspan="2">&nbsp;</td>
          <%}%>
</tr>
</table>
<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
<th colspan="8">Information Covered</th>
<tr class="subDetail">
     <% int infoCoveredLoopCount = 0;
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
        %>
  <td>
      <impact:validateInput
        name="<%= chkbxInfoName %>"
        checked="<%= String.valueOf(infoCoveredChecked) %>"
        type="checkbox"
        value="<%= infoCoveredCode %>"
        cssClass="formInput"
        label="<%= Lookup.simpleDecodeSafe(CodesTables.CINFCVRD, infoCoveredCode)%>"
        disabled="<%= String.valueOf(bDisableAllFields) %>"
        tabIndex="<%= tabIndex++ %>"/>
  </td>
        <%if (infoCoveredLoopCount % 3 == 0)
    {%>
       </tr><tr class="subDetail">
    <%}
     } //end while
     if (infoCoveredLoopCount % 3 == 1)
      { %>
           <td colspan="4">&nbsp;</td>
          <%}
           else if(infoCoveredLoopCount % 3 == 2)
           { %>
          <td colspan="2">&nbsp;</td>
          <%}%>
</tr>
</table>
</impact:ExpandableSectionTag>
      <BR>
<%-- END INQUIRY INFORMATION --%>
<%-- BEGIN OREINTATION/PRE-SERVICE TRN SCHEDUL --%>
<%-- New section that is required for shines Inquiry Information --%>
<impact:ExpandableSectionTag
name="orientationPreServiceTrn"
id="idOrientationPreServiceTrn"
label="Orientation/Pre-Service Training Scheduling"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="subDetail">
  <tr>
    <td>
        <impact:validateDate name="dtDtOrientation1" label="Orientation 1" size="10" constraint="Date"
               value="<%= FormattingHelper.formatDate( dtOrientation1 ) %>" tabIndex="<%=tabIndex++%>" disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateSelect label="Status" name="selOrientationStatus1" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" codesTable="CORNTNST" value="<%= strOrientationStatus1 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
  </tr>
  <tr>
    <td>
        <impact:validateDate name="dtDtOrientation2" label="Orientation 2" size="10" constraint="Date" value="<%= FormattingHelper.formatDate( dtOrientation2 ) %>" tabIndex="<%=tabIndex++%>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateSelect label="Status" name="selOrientationStatus2" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" codesTable="CORNTNST" value="<%= strOrientationStatus2 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
  </tr>
  <tr>
    <td>
        <impact:validateDate name="dtDtOrientation3" label="Orientation 3" size="10" constraint="Date" value="<%= FormattingHelper.formatDate( dtOrientation3 ) %>" tabIndex="<%=tabIndex++%>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateSelect label="Status" name="selOrientationStatus3" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" codesTable="CORNTNST" value="<%= strOrientationStatus3 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
  </tr>
</table>
<table cellspacing="0" cellpadding="3" width="100%" class="subDetail" >
<th colspan="8">Pre-Service Training</th>
  <tr>
    <td>
        <impact:validateDate name="dtDtInvitation1" label="Invitation 1" size="10" constraint="Date" value="<%= FormattingHelper.formatDate( dtInvitation1 ) %>" tabIndex="<%=tabIndex++%>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateSelect label="Status" name="selInvitationStatus1" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" codesTable="CPRSVCTR" value="<%= strInvitationStatus1 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateInput label="Location" type="text" name="szInvitation1Location" tabIndex="<%=tabIndex++%>" constraint="Paragraph30" size="30" maxLength ="30" value="<%= strLocation1 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
  </tr>
  <tr>
    <td>
        <impact:validateDate name="dtDtInvitation2" label="Invitation 2" size="10" constraint="Date" value="<%= FormattingHelper.formatDate( dtInvitation2 ) %>" tabIndex="<%=tabIndex++%>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateSelect label="Status" name="selInvitationStatus2" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" codesTable="CPRSVCTR" value="<%= strInvitationStatus2 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateInput label="Location" type="text" name="szInvitation2Location" tabIndex="<%=tabIndex++%>" constraint="Paragraph30" size="30" maxLength ="30" value="<%= strLocation2 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
  </tr>
  <tr>
    <td>
        <impact:validateDate name="dtDtInvitation3" label="Invitation 3" size="10" constraint="Date" value="<%= FormattingHelper.formatDate( dtInvitation3 ) %>" tabIndex="<%=tabIndex++%>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateSelect label="Status" name="selInvitationStatus3" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" codesTable="CPRSVCTR" value="<%= strInvitationStatus3 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
    <td>
        <impact:validateInput label="Location" type="text" name="szInvitation3Location" tabIndex="<%=tabIndex++%>" constraint="Paragraph30" size="30" maxLength ="30" value="<%= strLocation3 %>"
         disabled="<%= String.valueOf(bDisableAllFields) %>"/>
    </td>
  </tr>
</table>
<table cellspacing="0" cellpadding="3" width="100%" class="subDetail" >
<tr colspan="6">
    <td >
           <impact:validateTextArea
            name="txtSzOrientationComments"
            colspan="3"
            label="Orientation/Pre-Service Training Comments"
            rows="4"
            cols="70"
            tabIndex="<%= tabIndex++ %>"
            maxLength="300"
            constraint="Comments"
            disabled="<%= String.valueOf(bDisableAllFields) %>">
            <%= FormattingHelper.formatString( orientationComments ) %>
          </impact:validateTextArea>
    </td>
</tr>
</table>
</impact:ExpandableSectionTag>
<%-- END OREINTATION/PRE-SERVICE TRN SCHEDUL --%>
      <BR>      
<impact:ExpandableSectionTag
name="selMaleMinYearInt_Id"
id="txtField_Id4"
label="Home Interest"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">
<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<th colspan="6">Programs Of Interest</th>
<tr class="subDetail">
            <% int prgrmOfInterestLoopCount = 0;
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
          %><td>
          <impact:validateInput
            name="<%= chkbxName %>"
            checked="<%= String.valueOf(checked) %>"
            type="checkbox"
            value="<%= String.valueOf( prgrmOfInterestCode ) %>"
            cssClass="formInput"
            label="<%= Lookup.simpleDecodeSafe(CodesTables.CPRGMINT, prgrmOfInterestCode)%>"
            disabled="<%= String.valueOf(bDisableAllFields) %>"
            tabIndex="<%= tabIndex++ %>"/>
      </td>
           <%if (prgrmOfInterestLoopCount % 3 == 0)
         {%>
         </tr><tr class="subDetail">
         <%}

} //end while
   if (prgrmOfInterestLoopCount % 3 == 1)
   { %>
      <td colspan="2">&nbsp;</td>
   <%
   }    
   else if (prgrmOfInterestLoopCount % 3 == 2)
    { %>
    <td>&nbsp;</td>
   <%}%>
  </tr>
  <tr class="subDetail">
    <td colspan="2">
       <table cellspacing="0" cellpadding="3" width="100%" border="0">
          <tr>
             <td>
                <impact:validateInput
                        type="text"
                        label="Other"
                        name="txtHmPrgInterest"
                        disabled="<%= String.valueOf(bDisableAllFields) %>"
                        value="<%= txtHmPrgInterest %>"
                        constraint="Paragraph80"
                        size="80"
                        maxLength ="80"
                        tabIndex="<%=tabIndex++%>"/>
             </td>
           </tr>
         </table>
      </td>
      <td colspan="2"></td>
  </tr>
</table>
<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
  <tr>
    <th colspan="8">Male Age Range Interests</th>
  </tr>
  <tr class="subDetail">
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(maleMinInterestInMonths/12) %>"
               name="selMaleMinYearInt"
               label="Min Year"
               options="<%= yearOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(maleMinInterestInMonths%12) %>"
               name="selMaleMinMonthInt"
               label="Min Month"
               options="<%= monthOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(maleMaxInterestInMonths/12) %>"
               name="selMaleMaxYearInt"
               label="Max Year"
               options="<%= yearOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(maleMaxInterestInMonths%12) %>"
               name="selMaleMaxMonthInt"
               label="Max Month"
               options="<%= monthOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"/>
            </td>
          </tr>
        </table>
        <table width="100%" class ="tableborder" cellspacing="0" cellpadding="3">
          <th colspan="8">Female Age Range Interests</th>
          <tr class="subDetail">
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(femaleMinInterestInMonths/12) %>"
               name="selFemaleMinYearInt"
               label="Min Year"
               options="<%= yearOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(femaleMinInterestInMonths%12) %>"
               name="selFemaleMinMonthInt"
               label="Min Month"
               options="<%= monthOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(femaleMaxInterestInMonths/12) %>"
               name="selFemaleMaxYearInt"
               label="Max Year"
               options="<%= yearOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(femaleMaxInterestInMonths%12) %>"
               name="selFemaleMaxMonthInt"
               label="Max Month"
               options="<%= monthOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"/>
            </td>
          </tr>
          </table>
           <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
		   <th colspan="4" id="childRaces">Child Races</th>
           <tr class="subDetail">
             <% int raceLoopCount = 1;
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
              %><td>
                 <impact:validateInput
                  tabIndex="<%= tabIndex++ %>"
                  value="<%= raceCode %>"
                  type="checkbox"
                  checked="<%= String.valueOf(isChecked) %>"
                  disabled="<%= String.valueOf(bDisableAllFields) %>"
                  name="<%= cbName %>"
                  label="<%= Lookup.simpleDecodeSafe(CodesTables.CADRACE, raceCode)%>"
                  cssClass="formInput" />
                </td>
                <td>
                <impact:validateInput type="hidden" name="<%= hiddenDateFieldName %>" value="<%= date %>"/>
                <%= date %>
                </td>
               <%if (raceLoopCount % 2 == 0)
                 {%>
                   </tr><tr class="subDetail">
               <%}
                 raceLoopCount++;
                 } //end while
             if (raceLoopCount % 2 == 0)
                { %>
            <td>&nbsp;</td><td>&nbsp;</td>
              <%}%>
           </tr>
		   </table>
          
           <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
           <th colspan="4" id="childEthnicities">Child Ethnicities</th>
           <tr class="subDetail">
             <% int loopCount = 1;
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
              %><td>
                 <impact:validateInput
                  tabIndex="<%= tabIndex++ %>"
                  value="<%= ethCode %>"
                  type="checkbox"
                  checked="<%= String.valueOf(isChecked) %>"
                  disabled="<%= String.valueOf(bDisableAllFields) %>"
                  name="<%= cbName %>"
                  label="<%= Lookup.simpleDecodeSafe(CodesTables.CINDETHN, ethCode)%>"
                  cssClass="formInput" />
                </td>
                <td>
                <impact:validateInput type="hidden" name="<%= hiddenDateFieldName %>" value="<%= date %>"/>
                <%= date %>
                </td>
               <%if (loopCount % 2 == 0)
                 {%>
                   </tr><tr class="subDetail">
               <%}
                 loopCount++;
                 } //end while
             if (loopCount % 2 == 0)
                { %>
            <td>&nbsp;</td><td>&nbsp;</td>
              <%}%>
           </tr>
          </table>
             <!-- test -->
		    <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
           <tr>
		   <th colspan="2" id="childCharacteristics">Child Characteristics</th>
		        <td align="right">
     <a tabIndex="<%= tabIndex++ %>" onClick="hrefDirtyBypass=true;" href="javascript:expandAllCategories()">Expand All</a>&nbsp;
     <a tabIndex="<%= tabIndex++ %>" onClick="hrefDirtyBypass=true;" href="javascript:collapseAllCategories()">Collapse All</a>&nbsp;
     </td>
		   </tr>
		   </table>
		  
		  
          <%
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
        %>
        		<impact:ExpandableSectionTag name="<%= catCode %>" id="" label="<%= catDecode %>" tabIndex="<%=tabIndex++%>">
				<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
		<%  
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
%>

		 			<tr>
		 			
		    <td><a href="<%= onClickSelectAll %>" tabIndex="<%=tabIndex++%>" onClick="hrefDirtyBypass=true;"> Select All Child Characteristics</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a  href="<%= onClickDeSelectAll %>" tabIndex="<%=tabIndex++%>" onClick="hrefDirtyBypass=true;">Deselect All Child Characteristics</a>
		    </td>
		  </tr>
		  <tr class="subDetail">
		<%  
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
                 
        %>
        		<td>
					<impact:validateInput tabIndex="<%= tabIndex++ %>"
						value="<%= charCode  %>" type="checkbox"
						checked="<%= String.valueOf(isChecked1) %>"
						disabled="<%= String.valueOf(bDisableAllFields) %>"
						name="<%= cbName1 %>"
						label="<%= Lookup.simpleDecodeSafe(catCode, charCode)%>"
						cssClass="formInput" />
				</td>
				<td>
					<%= date %>
				</td>
		<%
			if(loopCount3 % 2 == 0){
        %>
				</tr>
				<tr class="subDetail">
		   <%}
                 loopCount3++;
                 } //end while
             if (loopCount3 % 2 == 0)
                { %>
            <td>&nbsp;</td><td>&nbsp;</td>
              <%}%>
           </tr>
          </table>
		</impact:ExpandableSectionTag>
		<%
		}
		%>
          
          <!-- end test -->
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
    <th colspan="4">Child Placement Information</th>
      <tr class="subDetail">
       <td><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="WT"
                 type="checkbox"
                 checked="<%= String.valueOf(willTransport) %>"
                 disabled="<%= String.valueOf(bDisableAllFields) %>"
                 name="ckWillTransport"
                 label="Will Transport Child[ren]"
                 cssClass="formInput" />
      </td>
      <td><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="EMP"
                 type="checkbox"
                 checked="<%= String.valueOf(emergencyPlacements) %>"
                 disabled="<%= String.valueOf(bDisableAllFields) %>"
                 name="ckEmergPlacement"
                 label="Emergency Placements"
                 cssClass="formInput" />
     </td>
     <td><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="SPECCHILD"
                 type="checkbox"
                 name="chkSpecChildren"
                 checked="<%= String.valueOf(specChildren) %>"
                 label="Specific Child(ren) Identified"
                 disabled="<%= String.valueOf(bDisableAllFields) %>"
                 cssClass="formInput"/>
       </td>
  </tr>
  <tr class="subDetail">
     <td>
       <impact:validateTextArea
               name="txtComments"
               colspan="3"
               label="Comments"
               rows="3"
               cols="110"
               tabIndex="<%= tabIndex++ %>"
               disabled="<%= String.valueOf(bDisableAllFields) %>"
               maxLength="300"
               constraint="Comments">
           <%= homeInterestComments %>
       </impact:validateTextArea>
    </td>
  </tr>
</table>
</impact:ExpandableSectionTag>
<br>

<impact:ExpandableSectionTag
name="homeLicense"
id="txtCapacity_Id"
label="Home Approval"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">
      <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
          <th colspan="8">Approval Period</th>
          <tr class="subDetail">
     <td><impact:validateDate
           size="10"
           value="<%= FormattingHelper.formatDate( dtApprovalBegin ) %>"
           name="apprvlBeginDt"
           tabIndex="<%= tabIndex++ %>"
           label="Approval Begin Date"
           conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"
           disabled="<%= String.valueOf(bDisableAllFields) %>"

           constraint="Date"/>
      </td>
     <td><impact:validateDate
           size="10"
           value="<%= FormattingHelper.formatDate( dtApprovalEnd ) %>"
           name="apprvlEndDt"
           tabIndex="<%= tabIndex++ %>"
           label="Approval End Date"
           conditionallyRequired="<%= String.valueOf(!bDisableAllFields) %>"
           disabled="<%= String.valueOf(bDisableAllFields) %>"

           constraint="Date"/>
      </td>
          </tr>
      </table>
      <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
          <th colspan="8">Placement Information</th>
          <tr class="subDetail">
           <td width="20%"><impact:validateInput
                tabIndex="<%= tabIndex++ %>"
                value="<%= String.valueOf(capacity) %>"
                type="text"
                name="txtCapacity"
                label="Capacity"
                conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"
                disabled="<%= String.valueOf(bDisableLicensing) %>"
                onChange="setOpenSlots();"
                cssClass="formInput"
                size="4"
                maxLength="4"
                constraint="Numeric"/>
           </td>
           <td width="20%"><impact:validateDisplayOnlyField
                value="<%= String.valueOf(placements) %>"
                name="txtPlacements"
                label="# Placements" />
           </td>
          </tr>
          <tr class="subDetail">
           <td width="20%"><impact:validateDisplayOnlyField
                value="<%= String.valueOf(openSlots) %>"
                name="txtOpenSlots"
                label="Open Slots" />
           </td>
           <td width="20%"><impact:validateInput
                tabIndex="<%= tabIndex++ %>"
                value="on"
                type="checkbox"
                checked="<%= String.valueOf(isOnHold) %>"
                onClick="setOnHold();"
                name="ckOnHold"
		        disabled="<%= String.valueOf(bDisableOnHold) %>"                
                label="Hold Placements"
                cssClass="formInput" />
           </td><td>&nbsp;</td>
           <tr class="subDetail">
           <td width="20%"><impact:validateDisplayOnlyField
                value="<%= StringHelper.getNonNullString(iveReimbursable) %>"
                name="txtIveReimbursable"
                label="IV-E Reimbursable" />
           </td>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
           </tr>
        </table>

        <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
          <th colspan="8">Male Age Range Approved</th>
          <tr class="subDetail">
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(maleMinAgeInMonths/12) %>"
               name="selMaleMinYear"
               label="Min Year"
               options="<%= yearOptions %>"
               onChange="setLicenseChange();"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableLicensing) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(maleMinAgeInMonths%12) %>"
               name="selMaleMinMonth"
               label="Min Month"
               options="<%= monthOptions %>"
               onChange="setLicenseChange();"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableLicensing) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(maleMaxAgeInMonths/12) %>"
               name="selMaleMaxYear"
               label="Max Year"
               options="<%= yearOptions %>"
               onChange="setLicenseChange();"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableLicensing) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(maleMaxAgeInMonths%12) %>"
               name="selMaleMaxMonth"
               label="Max Month"
               options="<%= monthOptions %>"
               onChange="setLicenseChange();"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableLicensing) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"/>
            </td>
          </tr>
        </Table>

        <table width="100%" class ="tableborder" cellspacing="0" cellpadding="3">
          <th colspan="8">Female Age Range Approved</th>
          <tr class="subDetail">
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(femaleMinAgeInMonths/12) %>"
               name="selFemaleMinYear"
               label="Min Year"
               options="<%= yearOptions %>"
               onChange="setLicenseChange();"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableLicensing) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(femaleMinAgeInMonths%12) %>"
               name="selFemaleMinMonth"
               label="Min Month"
               options="<%= monthOptions %>"
               onChange="setLicenseChange();"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableLicensing) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(femaleMaxAgeInMonths/12) %>"
               name="selFemaleMaxYear"
               label="Max Year"
               options="<%= yearOptions %>"
               onChange="setLicenseChange();"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableLicensing) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf(femaleMaxAgeInMonths%12) %>"
               name="selFemaleMaxMonth"
               label="Max Month"
               options="<%= monthOptions %>"
               onChange="setLicenseChange();"
               blankValue="false"
               disabled="<%= String.valueOf(bDisableLicensing) %>"
               conditionallyRequired="<%= String.valueOf(!bDisableLicensing) %>"/>
            </td>
          </tr>
          </table>

   <%int numFosterHomeTypes = CodesTables.CFAHMTYP.length(); //!!!
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
%>
<impact:validateInput type="hidden" name="numberHomeTypes" value="<%= String.valueOf(numFosterHomeTypes) %>"/>

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
    <tr><th colspan = "8"> Home Type </th></tr>
     <tr class="subDetail">
     <td>
      <impact:codesCheckbox
        name="famTypes"
        defaultCodes="<%=checkedHomeTypes%>"
        codesTableName="<%= CodesTables.CFAHMTYP %>"
        columns="2"
        isHorizontal="true"
        onClick="setFosterTypeChange();"
        disabled="<%= String.valueOf(bDisableLicensing) %>"
        tabIndex="<%= tabIndex++ %>"/>
     </td>
     </tr>
  </table>

</impact:ExpandableSectionTag>
<br>
<% if (!bHideCloseHomeSection)
  {%>
<impact:ExpandableSectionTag
name="statusReason"
id="selStatusReason_Id"
label="Change Of Status Reason"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">

 <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
   <tr class="subDetail">
    <td><impact:validateSelect
       tabIndex="<%= tabIndex++ %>"
       value="<%= closureReason %>"
       name="selClosureReason"
       label="Change Reason"
       codesTable="<%=CodesTables.CFACLOSE%>"
       disabled="<%= String.valueOf(bDisableClosureFields) %>"
       style="WIDTH: 400px" />
    </td>
   </tr>
   <tr class="subDetail">
    <td><impact:validateSelect
       tabIndex="<%= tabIndex++ %>"
       value="<%= recommendReopen %>"
       name="selRecReopen"
       label="Recommend Re-opening"
       disabled="<%= String.valueOf(bDisableClosureFields) %>"
       codesTable="<%= CodesTables.CFARCMND %>"/>
    </td>
   </tr>
   <tr class="subDetail">
    <td><impact:validateSelect
       tabIndex="<%= tabIndex++ %>"
       value="<%= involuntaryClosure %>"
       name="selInvolClosure"
       label="Closure Type"
       disabled="<%= String.valueOf(bDisableClosureFields) %>"
       codesTable="<%= CodesTables.CFACLSTP %>"/>
    </td> 
  </tr>
  <tr class="subDetail">
     <td>
       <impact:validateTextArea
               name="txtStatusRsnComments"
               colspan="3"
               label="Comments"
               rows="3"
               cols="110"
               tabIndex="<%= tabIndex++ %>"
               disabled="<%= String.valueOf(bDisableClosureFields) %>"
               maxLength="300"
               constraint="Comments">
               <%= statusRsnComments %>
       </impact:validateTextArea>
    </td>
  </tr>  
</table>
</impact:ExpandableSectionTag>
<br>
 <% } //end if not hide close home section
%>
<table width="100%" class="tableborder" border="0" cellspacing="0" cellpadding="3">
<th colspan="4">Home Study</th>
<tr class="subDetail">
  		 <td><impact:validateDate
  		       size="10"
  		       value="<%= FormattingHelper.formatDate( dtFosterParentManual ) %>"
  		       name="dtFosterParentManual"
  		       tabIndex="<%= tabIndex++ %>"
  		       label="Foster Parent Manual Date"
  		       disabled="<%= String.valueOf(bDisableLicensing) %>"
  		       constraint="Date"/>
  		  </td>
  		 <td><impact:validateDate
  		       size="10"
  		       value="<%= FormattingHelper.formatDate( dtFosterParentBill ) %>"
  		       name="dtFosterParentBill"
  		       tabIndex="<%= tabIndex++ %>"
  		       label="Foster Parents Bill Of Rights Date"
  		       disabled="<%= String.valueOf(bDisableLicensing) %>"
  		       constraint="Date"/>
  		  </td>          
    </tr>
</table>
<br>
<hr>
<table cellspacing="0" cellpadding="3" width="100%"><tr><td align="right">
    <% if (!bHideAssignButton)
    {
// SPB - Added preventDoubleClick="true" to fix SIR 19939
%>
             <impact:ButtonTag
             name="btnAssign"
             img="btnSave"
             form="frmHomeInformation"
             function="saveSelStatusOptions(); saveAssign()"
             restrictRepost="true"
             preventDoubleClick="true"
             action="/fad/HomeInfrmtn/reopenAssignHomeInformation"
             tabIndex="<%= tabIndex++ %>"/>

    <%}
       if (!bHideSaveSubmitButton)
    {%>
             <impact:ButtonTag
             name="btnSaveSubmit"
             img="btnSaveAndSubmit"
             form="frmHomeInformation"
             function="saveSelStatusOptions(); saveSubmit();"
             restrictRepost="true"
             action="/fad/HomeInfrmtn/saveSubmitHomeInformation"
             tabIndex="<%= tabIndex++ %>"/>

    <%}
      if (!bHideSaveButton)
    {%>
             <impact:ButtonTag
             name="btnSave1"
             img="btnSave"
             form="frmHomeInformation"
             function="saveSelStatusOptions(); return checkMaritalStatus();"
             restrictRepost="true"
             action="/fad/HomeInfrmtn/saveHomeInformation"
             tabIndex="<%= tabIndex++ %>"/>
      <%}%>
       </td>
    </table>
     <script>addQuestionMark();</script>
</impact:validateForm>
<br>
<%
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
  
%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <th>Family Home Evaluation</th>
    <tr>
    <td>
    <impact:documentButton pageMode="<%= pageMode %>" tabIndex="<%= tabIndex++ %>"
           buttonUrl="/grnds-docs/images/shared/btnDocument.gif" >
          <impact:document displayName=""
            name = "frmDocumentTag"
            protectDocument="<%= protectDoc %>"
            docType="FRD03O00"
            postInSameWindow="false"
            checkForNewMode="true"
            docExists="<%= bDocumentExists %>">
            <impact:documentParameter name="pStage" value="<%= globalIdStage %>"/>
            <impact:documentParameter name="newStatus" value="<%= newStatus %>"/>
          </impact:document>
       </impact:documentButton>
       </td>
  </tr>
</table>
<%}%>
<br>

<script language="Javascript1.2">
function reloadReject()
{
    alert('Closure of home was not approved. If you no longer wish to close the home, select a new status for the home and resubmit the page.');
}
</script>
<%
 // SIR 18710 - We have to Call disableFHType() so the appropriate widgets will
 // be enabled or disabled in the Foster Home Type Section upon page load.
%>

<script language="Javascript1.2">
  <%
  //SIR 19050 -- The disableFHType should not be called when the pageMode is View
  // JMC - SIR 19404 - Replaced the following logic with the correct ! logic.
  //if((pageMode.equals(PageMode.VIEW)))
  if(!(pageMode.equals(PageModeConstants.VIEW)))
  {
  %>
    disableFHType();
  <%
  }
  %>
  //SIR 16052 - call this at the bottom to allow the page to load
  myOnLoadFunction();
</script>

