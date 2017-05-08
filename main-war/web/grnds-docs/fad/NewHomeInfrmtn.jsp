<%
/*  JSP Name:     Add New Home
    Created by:   Heather Dean
    Date Created: 2/3/03

    Description:
              The F/A Home Demographics section will be used by
              developers to enter the demographic
              information about a foster or adoptive home.
              The Home Interest section will allow the user to enter information
              about a foster or adoptive home's interest in a child(ren).
              The section also allows the user to enter comments about the
              homes interests in a Comments field.  If a field is left
              blank, it means the home is not interested in that criteria.
              For example, if the Male Age Range is left blank, it means
              the home is not interested in fostering or adopting male
              children.


    Change History:
    Date      User              Description
    --------  ----------------  ------------------------------------------------
    2/3/03    Heather Dean      Initial jsp creation
    08/08/03  CASDORJM          The openValidateWindowB() javaScript function
                                was referencing selCdFacilityState instead of
                                selCdFacilityStateB.
    5/24/04   gerryc            SIR 16052 - removed checkbox and logic for a
                                non-prs home from this page.  Having this on the
                                page was resulting in not requiring the user to
                                enter important information for adoption asstiance
                                payments and AFCARS reporting.
    06/16/04  gerryc            SIR 16091 - Added VendorID constraint to Vendor
                                ID fields.  Vendor ID must be 14 characters,
                                starting with 11 numbers.
    9/2/2004   gerryc            SIR 23137 - Removed SIR 16091 due to issues with
                                the workers not having an vendor id on creation
                                of the resource/home/contract.
    9/27/2004 gerryc             SIR 23166 - added back in vendor id edits.
   11/02/2004  reedlg            SIR 22684 - Phone Type and Phone are no longer required on this page
                                which processes only FAD homes in Inquiry status.
   11/01/2006 aodutayo    SHINES related changes. Added a new section - Inquiry Information
           section to the page. Removed inquiry source (not needed in SHINES)
   05/28/2010 wcochran    MR-066: Added javascript to display a confirmation box when
                          a duplicate home name or home address is found
   11/12/2010 schoi		  SMS #81140: MR-074 Filter Marital Status dropdown to exclude 'Unmarried Couple'     
   10/14/2011 cwells      STGAP00017231: ECEM 5.0 - Updates made to characteristics section. 
   11/04/2011 hnguyen     STGAP00017290: ECEM 5.0 - Collapse categories on page load of new home information. 
                     
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.SortedMap" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>


<!--Start Main Content-->
<% BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );%>

<impact:validateErrors />

<%
//String reloadValue = "";
//if ( state.getAttribute( "isReload" , request ) != null )
//{
//  reloadValue = (String) state.getAttribute( "isReload" , request );
//}
//boolean isReload = false;
//if ("true".equals(reloadValue) )
//{
//  isReload = true;
//}

int tabIndex = 1;
boolean bHideSaveButton = false;
//boolean bHideDeleteButton = false;
boolean bDisableAllFields = false;
org.exolab.castor.types.Date today = DateHelper.toCastorDate( new java.util.Date() );
String pageMode = PageMode.getPageMode( request );
//String isAdd = "true";

//ROWCFAD07SOG04 info.
String legalName = "";
String homeName = null;
String categoryD =  null;
String statusD = HomeInfrmtnConversation.CODE_STATUS_INQUIRY;
String language = null;
String religion = null;
String annualIncome = null;
String respite = null;
String marriageStatus = null;
org.exolab.castor.types.Date marriageDate = today;
//boolean isIndividualStudy = false;

/* new additions to the page*/
String schoolDistrict = null;
//String elementary = null;
//String middle = null;
//String high = null;

legalName = ContextHelper.getStringSafe( request, "txtLegalName" );
homeName = ContextHelper.getStringSafe( request, "txtHomeName" );
categoryD = ContextHelper.getStringSafe( request, "selCategory" );
language =  ContextHelper.getStringSafe( request, "selLanguage" );
religion =  ContextHelper.getStringSafe( request, "selReligion" );
annualIncome =  ContextHelper.getStringSafe( request, "txtAnnualIncome" );
respite =  ContextHelper.getStringSafe( request, "selRespite" );
marriageStatus =  ContextHelper.getStringSafe( request, "selMaritalStatus" );
marriageDate = ContextHelper.getCastorDateSafe( request, "marriageDate" );
//if ( !"".equals(ContextHelper.getStringSafe(request, "chkIndCurrHomeStudyExists")) )
//{
//  isIndividualStudy = true;
//}

//ROWCFAD07SOG05 info.
int maleMinInterestInMonths = 0;
int maleMaxInterestInMonths = 0;
int femaleMinInterestInMonths = 0;
int femaleMaxInterestInMonths = 0;
//int numberOfChildren = 0;
boolean willTransport = false;
boolean emergencyPlacements = false;
String homeInterestComments = "";
String txtHmPrgInterest = "";

// SMS #81140: MR-074 Filter Marital Status dropdown to exclude 'Unmarried Couple'
List excludeFAMSTRC = new ArrayList();
excludeFAMSTRC.add(CodesTables.CFAMSTRC_19);

//Child Ethnicities, Child Races, Child Characteristics, Programs Of Interests
Collection ethnicities = Lookup.getCategoryCodesCollection(CodesTables.CINDETHN);
Iterator ethnicitiesIterator = ethnicities.iterator();

Collection races = Lookup.getCategoryCodesCollection(CodesTables.CADRACE);
Iterator racesIterator = races.iterator();

List<CodeAttributes> characteristics = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CLNCHAR2);
Iterator characteristicsIterator = characteristics.iterator();

Collection prgrmsOfInterestsCollection = Lookup.getCategoryCodesCollection(CodesTables.CPRGMINT);
Iterator prgrmsOfInterestsIter = prgrmsOfInterestsCollection.iterator();

//Home Interest Section
int minMaleYearInt = ContextHelper.getIntSafe( request, "selMaleMinYearInt" );
int minMaleMonthInt = ContextHelper.getIntSafe( request, "selMaleMinMonthInt" );
maleMinInterestInMonths = (minMaleYearInt*12)+minMaleMonthInt;
int maxMaleYearInt = ContextHelper.getIntSafe( request, "selMaleMaxYearInt" );
int maxMaleMonthInt = ContextHelper.getIntSafe( request, "selMaleMaxMonthInt" );
maleMaxInterestInMonths = (maxMaleYearInt*12)+maxMaleMonthInt;
int minFemaleYearInt = ContextHelper.getIntSafe( request, "selFemaleMinYearInt" );
int minFemaleMonthInt = ContextHelper.getIntSafe( request, "selFemaleMinMonthInt" );
femaleMinInterestInMonths = (minFemaleYearInt*12)+minFemaleMonthInt;
int maxFemaleYearInt = ContextHelper.getIntSafe( request, "selFemaleMaxYearInt" );
int maxFemaleMonthInt = ContextHelper.getIntSafe( request, "selFemaleMaxMonthInt" );
femaleMaxInterestInMonths = (maxFemaleYearInt*12)+maxFemaleMonthInt;
//numberOfChildren = ContextHelper.getIntSafe( request, "txtNumberChildren" );
if ( !"".equals(ContextHelper.getStringSafe(request, "ckWillTransport")) )
{
  willTransport = true;
}
if ( !"".equals(ContextHelper.getStringSafe(request, "ckEmergPlacement")) )
{
  emergencyPlacements = true;
}

homeInterestComments = ContextHelper.getStringSafe( request, "txtComments" );
txtHmPrgInterest = ContextHelper.getStringSafe( request, "txtHmPrgInterest" );

//UserProfile user = UserProfileHelper.getUserProfile( request );
//int userID = 0;
//if ( user != null )
//{
//  userID = user.getUserID();
//}


SortedMap years = (SortedMap) state.getAttribute( "years" , request );
SortedMap months = (SortedMap) state.getAttribute( "months" , request );

Collection yearOptions = new ArrayList();
Collection monthOptions = new ArrayList();

if ( years != null )
{
  yearOptions = years.values();
}
if ( months != null )
{
  monthOptions = months.values();
}

if ( pageMode == null )
{
  pageMode = PageModeConstants.MODIFY;
}

//Phone section variables
//String tmpLNbrFacilPhoneNumber = "";
//int iUlIdResource = 0;
String szCReqFuncCd = "A";
//int iUlIdRsrcPhone = 0;
//int iIndex = 0;
//Date dateTsLastUpdate = null;
String szLNbrFacilPhoneNumber = "";
String szLNbrFacilPhoneExtension = "";
String szSzTxtRsrcPhoneComments = "";
//String selSzCdFacilPhoneType = "";
String cbxCIndRsrcTransport = "0";
//String classResource = "false";
//String fadResource = "false";
//String phoneTypeDisabled = "false";
String phoneNumberDisabled = "false";
String phoneExtensionDisabled = "false";
String phoneCommentsDisabled = "false";
//boolean phoneSaveButtonHide = false;
//boolean phoneDeleteButtonHide = false;

//ArrayList excludePrimaryOption = new ArrayList();

szCReqFuncCd = ContextHelper.getStringSafe( request, "cReqFuncCd");

 //iUlIdRsrcPhone = 0;
 //iIndex = 0;
 //dateTsLastUpdate = null;
 szLNbrFacilPhoneNumber = "";
 szLNbrFacilPhoneExtension = "";
 szSzTxtRsrcPhoneComments = "";
 //selSzCdFacilPhoneType = "";
 //phoneDeleteButtonHide = true;



szSzTxtRsrcPhoneComments = ContextHelper.getStringSafe( request, "txtszTxtRsrcPhoneComments" );
szLNbrFacilPhoneExtension = ContextHelper.getStringSafe( request, "txtLNbrFacilPhoneExtension" );
szLNbrFacilPhoneNumber =  ContextHelper.getStringSafe( request, "txtLNbrFacilPhoneNumber" );
//selSzCdFacilPhoneType = ContextHelper.getStringSafe( request, "selSzCdFacilPhoneType" );
//tmpLNbrFacilPhoneNumber = ContextHelper.getStringSafe( request, "selSzCdFacilPhoneType" );
//iUlIdResource =  ContextHelper.getIntSafe( request, "txtUlIdResource" );
//iUlIdRsrcPhone =  ContextHelper.getIntSafe( request, "IdResourcePhone" );
//dateTsLastUpdate = ContextHelper.getJavaDateSafe( request, "txtTsLastUpdate");

//Primary Address Section variables
//int iUlIdRsrcAddress = 0;
String txtSzAddrRsrcAddrAttn = null;
String txtSzAddrRsrcAddrStLn1 = null;
String txtSzAddrRsrcAddrStLn2 = null;
String txtSzAddrRsrcAddrZip = null;
String txtSzAddrRsrcAddrZipSuff = null;
String txtSzAddrRsrcAddrCity = null;
String txtSzCdFacilityState = "GA";
String txtSzCdFacilityCounty = "";
//String txtSzCdRsrcAddrSchDist = "";
//String onPageLoadVid = "";
String txtSzNbrRsrcAddrVid = "";
String txtszTxtRsrcAddrComments = "";
String txtSzCdRsrcAddrType = HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY;
//String schoolResource = "false";
String vendorId = "";
//String limitedEdit = "false";
//String addressTypeDisabled = "true";
String vendorIdDisabled = "false";
String attentionDisabled = "false";
String streetLn1Disabled = "false";
String streetLn2Disabled = "false";
String cityDisabled = "false";
String stateDisabled = "false";
String zipDisabled = "false";
String countyDisabled = "false";
//String schoolDistrictDisabled = "false";
String addressCommentsDisabled = "false";
String validated = "";
boolean validateButtonHide = false;
//boolean saveButtonHide = false;
//boolean deleteButtonHide = false;

//Business Address Section variables
//int iUlIdRsrcAddressB = 0;
String txtSzAddrRsrcAddrAttnB = "";
String txtSzAddrRsrcAddrStLn1B = "";
String txtSzAddrRsrcAddrStLn2B = "";
String txtSzAddrRsrcAddrZipB = "";
String txtSzAddrRsrcAddrZipSuffB = "";
String txtSzAddrRsrcAddrCityB = "";
String txtSzCdFacilityStateB = "GA";
String txtSzCdFacilityCountyB = "";
//String onPageLoadVidB = "";
String txtSzNbrRsrcAddrVidB = "";
String txtszTxtRsrcAddrCommentsB = "";
String txtSzCdRsrcAddrTypeB = HomeInfrmtnConversation.CODE_ADDR_TYPE_BUS;
//String vendorIdB = "";
//String limitedEditB = "false";
String vendorIdDisabledB = "false";
String attentionDisabledB = "false";
String streetLn1DisabledB = "false";
String streetLn2DisabledB = "false";
String cityDisabledB = "false";
String stateDisabledB = "false";
String zipDisabledB = "false";
//String countyDisabledB = "false";
String addressCommentsDisabledB = "false";
String validatedB = "";
//boolean validateButtonHideB = false;
//boolean saveButtonHideB = false;
//boolean deleteButtonHideB = false;

  String addressSubmoduleName1 = "";
  AddressBean addressBean1 = new AddressBean(addressSubmoduleName1);
  String address1Name1 = addressBean1.getAttributeName( AddressBean.ADDRESS1 );
  String address2Name1 = addressBean1.getAttributeName( AddressBean.ADDRESS2 );
  String cityName1 = addressBean1.getAttributeName( AddressBean.CITY );
  String stateName1 = addressBean1.getAttributeName( AddressBean.STATE );
  String zipName1 = addressBean1.getAttributeName( AddressBean.ZIP );
  String zipSuffName1 = addressBean1.getAttributeName( AddressBean.ZIP_SUFF );
  String countyName1 = addressBean1.getAttributeName( AddressBean.COUNTY );
  String validatedName1 = addressBean1.getAttributeName( AddressBean.IS_VALID );
  
  String addressSubmoduleName2 = "NEW_HOME2_";
  AddressBean addressBean2 = new AddressBean(addressSubmoduleName2);
  String address1Name2 = addressBean2.getAttributeName( AddressBean.ADDRESS1 );
  String address2Name2 = addressBean2.getAttributeName( AddressBean.ADDRESS2 );
  String cityName2 = addressBean2.getAttributeName( AddressBean.CITY );
  String stateName2 = addressBean2.getAttributeName( AddressBean.STATE );
  String zipName2 = addressBean2.getAttributeName( AddressBean.ZIP );
  String zipSuffName2 = addressBean2.getAttributeName( AddressBean.ZIP_SUFF );
  String countyName2 = addressBean2.getAttributeName( AddressBean.COUNTY );
  String validatedName2 = addressBean2.getAttributeName( AddressBean.IS_VALID );


// Get fields from request in case of error being returned to page or page reloading to populate school district

  txtSzAddrRsrcAddrAttn = ContextHelper.getStringSafe( request, "txtSzAddrRsrcAddrAttn");
  txtSzAddrRsrcAddrStLn1 = ContextHelper.getStringSafe( request, address1Name1);
  txtSzAddrRsrcAddrStLn2 = ContextHelper.getStringSafe( request, address2Name1);
  txtSzAddrRsrcAddrZip = ContextHelper.getStringSafe( request, zipName1);
  txtSzAddrRsrcAddrZipSuff = ContextHelper.getStringSafe( request, zipSuffName1);
  txtSzAddrRsrcAddrCity = ContextHelper.getStringSafe( request, cityName1);
  if ( !"".equals(ContextHelper.getStringSafe(request, stateName1)) )
  {
    txtSzCdFacilityState = ContextHelper.getStringSafe( request, stateName1);
  }
  txtSzCdFacilityCounty = ContextHelper.getStringSafe( request, countyName1);
  txtSzNbrRsrcAddrVid = ContextHelper.getStringSafe( request, "txtNbrRsrcAddrVid");
  txtszTxtRsrcAddrComments = ContextHelper.getStringSafe( request, "txtszTxtRsrcAddrComments");

  txtSzAddrRsrcAddrAttnB = ContextHelper.getStringSafe( request, "txtSzAddrRsrcAddrAttnB");
  txtSzAddrRsrcAddrStLn1B = ContextHelper.getStringSafe( request, address1Name2);
  txtSzAddrRsrcAddrStLn2B = ContextHelper.getStringSafe( request, address2Name2);
  txtSzAddrRsrcAddrZipB = ContextHelper.getStringSafe( request, zipName2);
  txtSzAddrRsrcAddrZipSuffB = ContextHelper.getStringSafe( request, zipSuffName2);
  txtSzAddrRsrcAddrCityB = ContextHelper.getStringSafe( request, cityName2);
  if ( !"".equals(ContextHelper.getStringSafe(request, stateName2)) )
  {
  txtSzCdFacilityStateB = ContextHelper.getStringSafe( request, stateName2);
  }
  txtSzCdFacilityCountyB = ContextHelper.getStringSafe( request, countyName2);
  txtSzNbrRsrcAddrVidB = ContextHelper.getStringSafe( request, "txtNbrRsrcAddrVidB");
  txtszTxtRsrcAddrCommentsB = ContextHelper.getStringSafe( request, "txtszTxtRsrcAddrCommentsB");


/**-HIDDEN FIELDS-*/
  szCReqFuncCd = ContextHelper.getStringSafe( request, "cReqFuncCd");

  validated = ContextHelper.getStringSafe( request, validatedName1);
  validatedB = "true"; //ContextHelper.getStringSafe( request, validatedName2);

  //iUlIdRsrcAddress = ContextHelper.getIntSafe( request, "iUlIdRsrcAddress" );
  //dateTsLastUpdate = ContextHelper.getJavaDateSafe( request, "txtTsLastUpdate" );

  vendorId = ContextHelper.getStringSafe( request, "vendorId" );
  //vendorIdB = ContextHelper.getStringSafe( request, "vendorIdB" );


//deleteButtonHide = true;

//Hide buttons if in view mode
if( pageMode.equals(PageModeConstants.VIEW) )
{
  bHideSaveButton = true;
  validateButtonHide = true;
  //validateButtonHideB = true;
}

//inquiry information
Date inquiryDate = null;
String inqRecvdBy = "";
String infoPacktRequested = "";
Date infPacktSent = null;
//int iRequestedNbrOfChildren = 0;
String childSpecInterest = "";
String inquiryComments = "";
Collection srcsOfInqCollection = Lookup.getCategoryCodesCollection(CodesTables.CFASRCIN);
Iterator srcsOfInqIter = srcsOfInqCollection.iterator();
Collection infoCovrdCollection = Lookup.getCategoryCodesCollection(CodesTables.CINFCVRD);
Iterator infoCovrdIter = infoCovrdCollection.iterator();

 inquiryDate = ContextHelper.getJavaDateSafe( request, "dtDtInquiryDate" );
 infPacktSent = ContextHelper.getJavaDateSafe( request, "dtDtInfoPcktSent" );
 inqRecvdBy = ContextHelper.getStringSafe(request, "txtSzCdInqryRcvdBy");
 infoPacktRequested = ContextHelper.getStringSafe(request, "selCdInfoPcktRqstd");
 //iRequestedNbrOfChildren = ContextHelper.getIntSafe(request, "txtNbrRqstdNbrOfChldrn");
 childSpecInterest = ContextHelper.getStringSafe( request, "txtSzChldSpcfcInterest");
 inquiryComments = ContextHelper.getStringSafe( request, "txtInquiryComments" );
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/addressValidation.js"></script>
<script language="Javascript1.2">
window.attachEvent('onbeforeunload', myOnBeforeUnload );
window.attachEvent('onload', expandMySectionOnLoad );
window.attachEvent('onload', collapseAllCategories );

window.onload = function ()
{
  checkNameAddress();
}

function expandMySectionOnLoad()
{
 expandCollapsed( 'expanded' + 'hmDemographics', 'collapsed' + 'hmDemographics')
}

 function selectAll(catCode, numOfCheckboxes, checkValue) {
  var checkboxField;

  for ( i = 1; i <= numOfCheckboxes; i++ )
  {
    checkboxField = eval('document.frmNewHomeInformation.CharCbx' + catCode + i);
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


// Check for changes before navigating off
function myOnBeforeUnload()
{
  IsDirty();
}

// Added for MR-066
function checkNameAddress()
{
  var errorCode = '<%= (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") %>';
  var bSaveIsPressed = '<%= (String) request.getAttribute("bSaveIsPressed") %>';
  if (errorCode == '<%= Messages.MSG_FAD_DUPLICATE_NOT_ALLOWED %>')
  {
  	if (confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_FAD_DUPLICATE_NOT_ALLOWED) %>')) 
  	{
  	  document.frmNewHomeInformation.hdnBSysIndPrfrmNameCheck.value = 'N';
  	  submitValidateForm("frmNewHomeInformation","/fad/HomeInfrmtn/saveAssignHomeInformation");
  	}
  }

}

function unValidate()
{
  document.frmNewHomeInformation.<%= validatedName1 %>.value="false";
}

function unValidateB()
{
  document.frmNewHomeInformation.<%= validatedName2 %>.value="false";
}



//function openValidateWindowValidate()
//{
//  var x = document.frmNewHomeInformation;
//  x.hdnSaveOrValidate.value = 'validate';
//  openValidateWindow();
//}

//function openValidateWindowValidateB()
//{
//  var x = document.frmNewHomeInformation;
//  x.hdnSaveOrValidateB.value = 'validate';
//  openValidateWindowB();
//}

//function openValidateWindowSave()
//{
//  var x = document.frmNewHomeInformation;
//  x.hdnSaveOrValidate.value = 'save';
//  openValidateWindow();
//}

//function openValidateWindowSaveB()
//{
//  var x = document.frmNewHomeInformation;
//  x.hdnSaveOrValidateB.value = 'save';
//  openValidateWindowB();
//}


/*
 *This function opens the address validation window.
 */
function openValidateWindow()
{
  launchAddressValidate('frmNewHomeInformation', 'validate', '<%= addressBean1.getAddressSubmoduleName() %>');
  document.frmNewHomeInformation.<%= validatedName1 %>.value = "true";
}

function openValidateWindowB()
{
  launchAddressValidate('frmNewHomeInformation', 'validate', '<%= addressBean2.getAddressSubmoduleName() %>');
  document.frmNewHomeInformation.<%= validatedName2 %>.value = "true";
}

function saveWithValidate()
{
  var x = document.frmNewHomeInformation;

  if ( x.<%= validatedName2 %>.value == "false" && x.<%= address1Name2 %>.value != "" )
  {
    //x.hdnSaveOrValidate.value = 'save';
    //valid = validateAddressOnSave('frmNewHomeInformation', '/fad/HomeInfrmtn/saveAssignHomeInformation', '<%= addressBean2.getAddressSubmoduleName() %>');
    //x.<%= validatedName2 %>.value = "\"" + valid + "\"";
    alert("Please validate the Business address before saving.");
    return false;
  }
  
  if ( x.<%= validatedName1 %>.value == "false") //-- unValidate explicitly called
  {
    if ( x.<%= address1Name1 %>.value == '' || x.<%= cityName1 %>.value == '' || x.<%= stateName1 %> == '' )
    {
      alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_FAD_ADDR_PHONE_EXIST ) %>');
    } else {
      x.hdnSaveOrValidate.value = 'save';
      return validateAddressOnSave('frmNewHomeInformation', '/fad/HomeInfrmtn/saveAssignHomeInformation', '<%= addressBean1.getAddressSubmoduleName() %>');
    }
  }
  else
  {
      if ( x.selMaritalStatus.value != '<%= HomeInfrmtnConversation.CODE_MARRIED %>' && x.marriageDate.value != '' )
      {
        alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_FAD_STATUS_NOT_MARRIED ) %>');
          x.marriageDate.value = '';
      }
      x.action = "/fad/HomeInfrmtn/displayNewHomeInformation";
     submitValidateForm( "frmNewHomeInformation", "/fad/HomeInfrmtn/saveAssignHomeInformation" );
  }
}

//function saveNewHome()
//{
//  var x = document.frmNewHomeInformation;
//  if ( x.selMaritalStatus.value != '<%= HomeInfrmtnConversation.CODE_MARRIED %>' && x.marriageDate.value != '' )
//  {
//    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_FAD_STATUS_NOT_MARRIED ) %>');
//     x.marriageDate.value = '';
//  }
//  x.action = "/fad/HomeInfrmtn/displayNewHomeInformation";
//  submitValidateForm( "frmNewHomeInformation", "/fad/HomeInfrmtn/saveAssignHomeInformation" );
//  return false;
//}


function categoryChange()
{
  var x = document.frmNewHomeInformation;
  x.originalCategory.value = x.selCategory.value;
}

//changed the value property of selCdFacilityState
// to GA from TX
function checkState()
{
  var x = document.frmNewHomeInformation;
  if (x.<%= stateName1 %>.value != 'GA')
  {
    x.selSchoolDistrict.disabled = true;
    x.selSchoolDistrict.value = '';
    x.selSzCdElementary.disabled = true;
    x.selSzCdElementary.value = '';
    x.selSzCdMiddle.disabled = true;
    x.selSzCdMiddle.value = '';
    x.selSzCdHigh.disabled = true;
    x.selSzCdHigh.value = '';
  }
  else
  {
    x.selSchoolDistrict.disabled = false;
    x.selSchoolDistrict.value = '';
    x.selSzCdElementary.disabled = false;
    x.selSzCdElementary.value = '';
    x.selSzCdMiddle.disabled = false;
    x.selSzCdMiddle.value = '';
    x.selSzCdHigh.disabled = false;
    x.selSzCdHigh.value = '';
  }
}


// This function sets the value of County Dropdown to 999 if State is otherthan GA.
function checkCountyForState()
{
  if(window.document.frmNewHomeInformation.<%= stateName1 %>[window.document.frmNewHomeInformation.<%= stateName1 %>.selectedIndex].value != "GA")
  {
      for (var i=0, l=window.document.frmNewHomeInformation.<%= countyName1 %>.options.length;i<l;i++)
      {
          if(window.document.frmNewHomeInformation.<%= countyName1 %>.options[i].value != "999")
          {
              var optionName = new Option(window.document.frmNewHomeInformation.<%= countyName1 %>.options[i].text, window.document.frmNewHomeInformation.<%= countyName1 %>.options[i].value, false, false);
              window.document.frmNewHomeInformation.hiddenAddressCounty.options[window.document.frmNewHomeInformation.hiddenAddressCounty.length] = optionName;
              
          }
      }
	  window.document.frmNewHomeInformation.<%= countyName1 %>.length = 0;
	  var optionName = new Option("Out of State", "999", true, true);
	  window.document.frmNewHomeInformation.<%= countyName1 %>.options[window.document.frmNewHomeInformation.<%= countyName1 %>.length] = optionName;
  }
  else
  {
      window.document.frmNewHomeInformation.<%= countyName1 %>.length = 0;
     for (var i=0, l=window.document.frmNewHomeInformation.hiddenAddressCounty.options.length;i<l;i++)
     {
         var optionName = new Option(window.document.frmNewHomeInformation.hiddenAddressCounty.options[i].text, window.document.frmNewHomeInformation.hiddenAddressCounty.options[i].value, false, false);
         window.document.frmNewHomeInformation.<%= countyName1 %>.options[window.document.frmNewHomeInformation.<%= countyName1 %>.length] = optionName;
     }
     window.document.frmNewHomeInformation.hiddenAddressCounty.length = 0;
  }
}

// creating function to bypass architectural constraints
function addQuestionMark(){
	// get the parent node of the input element
	var labels = document.getElementsByTagName('input');
	var SEXUALLY_ACTING_OUT = "70";
	for(var i = 0; i < labels.length; i++){
		var label = labels[i];
		var inn = label.defaultValue;
		if(SEXUALLY_ACTING_OUT == inn){
			// get the cell that the label is in (it's parent node)
			var cell = label.parentNode;
			
			cell = cell.nextSibling;
			
			// append html to the end of the node's inner html contents
			var inner = cell.innerHTML;
		  cell.innerHTML = inner + '&nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayHelp()">?</a></strong>';
           break;
		}
	}	
}

// This function sets the value of County Dropdown to 999 if State is otherthan GA.
function checkCountyForStateB()
{
  if(window.document.frmNewHomeInformation.<%= stateName2 %>[window.document.frmNewHomeInformation.<%= stateName2 %>.selectedIndex].value != "GA")
  {
      for (var i=0, l=window.document.frmNewHomeInformation.<%= countyName2 %>.options.length;i<l;i++)
      {
          if(window.document.frmNewHomeInformation.<%= countyName2 %>.options[i].value != "999")
          {
              var optionName = new Option(window.document.frmNewHomeInformation.<%= countyName2 %>.options[i].text, window.document.frmNewHomeInformation.<%= countyName2 %>.options[i].value, false, false);
              window.document.frmNewHomeInformation.hiddenAddressCountyB.options[window.document.frmNewHomeInformation.hiddenAddressCountyB.length] = optionName;
              
          }
      }
      window.document.frmNewHomeInformation.<%= countyName2 %>.length = 0;
      var optionName = new Option("Out of State", "999", true, true);
      window.document.frmNewHomeInformation.<%= countyName2 %>.options[window.document.frmNewHomeInformation.<%= countyName2 %>.length] = optionName;
  }
  else
  {
      window.document.frmNewHomeInformation.<%= countyName2 %>.length = 0;
     for (var i=0, l=window.document.frmNewHomeInformation.hiddenAddressCountyB.options.length;i<l;i++)
     {
         var optionName = new Option(window.document.frmNewHomeInformation.hiddenAddressCountyB.options[i].text, window.document.frmNewHomeInformation.hiddenAddressCountyB.options[i].value, false, false);
         window.document.frmNewHomeInformation.<%= countyName2 %>.options[window.document.frmNewHomeInformation.<%= countyName2 %>.length] = optionName;
     }
     window.document.frmNewHomeInformation.hiddenAddressCountyB.length = 0;
  }
}

<impact:codeArray codeName="<%= CodesTables.CSCHELEM %>" arrayName="<%= CodesTables.CSCHELEM %>" blankValue="true"/>
<impact:codeArray codeName="<%= CodesTables.CSCHMDDL %>" arrayName="<%= CodesTables.CSCHMDDL %>" blankValue="true"/>
<impact:codeArray codeName="<%= CodesTables.CSCHHIGH %>" arrayName="<%= CodesTables.CSCHHIGH %>" blankValue="true"/>
/*
 * populates all the schools for the 
 * selected school district
 */
 function populateSchools()
 {
   var schoolDistrictCode = document.frmNewHomeInformation.selSchoolDistrict.value;

   if ( schoolDistrictCode == "" )
   {
      clearDropdown( frmNewHomeInformation.selSzCdElementary );
      clearDropdown( frmNewHomeInformation.selSzCdMiddle );
      clearDropdown( frmNewHomeInformation.selSzCdHigh );
   }
   else
   {
      populateDropdownByLoopingThroughArray( "frmNewHomeInformation", "selSzCdElementary",<%= CodesTables.CSCHELEM %>, schoolDistrictCode, 3, "" );
      populateDropdownByLoopingThroughArray( "frmNewHomeInformation", "selSzCdMiddle",<%= CodesTables.CSCHMDDL %>, schoolDistrictCode, 3, "" );
      populateDropdownByLoopingThroughArray( "frmNewHomeInformation", "selSzCdHigh",<%= CodesTables.CSCHHIGH %>, schoolDistrictCode, 3, "" );
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


</script>



<table border="0" cellspacing="0" cellpadding="3" width="100%">
 <tr>
    <td align="right">
  <a tabIndex="<%= tabIndex++ %>" href="#" onClick="javascript:expandAll();">Expand All</a>&nbsp;
  <a tabIndex="<%= tabIndex++ %>" href="#" onClick="javascript:collapseAll();">Collapse All</a>&nbsp;
    </td>
 </tr>
</table>

<impact:validateForm name="frmNewHomeInformation"
          method="post"
          action="/fad/HomeInfrmtn/displayNewHomeInformation"
          validationClass="gov.georgia.dhr.dfcs.sacwis.web.fad.NewHomeCustomValidation"
          pageMode="<%= pageMode %>"
          schema="/WEB-INF/Constraints.xsd">

    <impact:validateInput type="hidden" name="timestamp" value=""/>
    <impact:validateInput type="hidden" name="cReqFuncCd" value="<%=szCReqFuncCd%>"/>
    <%-- impact:validateInput type="hidden" name="validated" value="<%= validated %>" / --%>
    <%-- impact:validateInput type="hidden" name="validatedB" value="<%= validatedB %>" / --%>
    <impact:validateInput type="hidden" name="hdnBSysIndPrfrmNameCheck" value=""/>
    <impact:validateInput type="hidden" name="vendorId" value="<%=vendorId%>"/>
    <impact:validateInput type="hidden" name="hdnSaveOrValidate" value="" />
    <impact:validateInput type="hidden" name="hdnSaveOrValidateB" value="" />
    <impact:validateInput type="hidden" name="frmWindowName" value="frmNewHomeInformation"/>
    <impact:validateInput type="hidden" name="validationOverride" />
    <impact:validateInput type="hidden" name="onLoadStatus" value="<%= statusD %>"/>
    <impact:validateInput type="hidden" name="selStatus" value="<%= statusD %>"/>
    <impact:validateInput type="hidden" name="originalCategory" value="<%= categoryD %>"/>
    <impact:validateInput type="hidden" name="prsChange" value=""/>
    <impact:validateInput type="hidden" name="cbxCIndRsrcTransport" value="<%=cbxCIndRsrcTransport%>"/>
    <impact:validateInput type="hidden" name="addressMultCounty" value='<%= ContextHelper.getStringSafe( request , "addressMultCounty") %>'/>
    <%-- Mimicked from AddResource.jsp --%>
    <impact:validateInput type="hidden" name="<%= AddressBean.ADDRESS_SUBMODULE_NAME + "1" %>" value="<%= addressBean1.getAddressSubmoduleName() %>"/>
    <impact:validateInput type="hidden" name="<%= addressBean1.getAttributeName( AddressBean.IN_REQUEST )%>" value="true"/>
    <impact:validateInput type="hidden" name="<%= validatedName1 %>" value="<%= validated %>"/>
    <impact:validateInput type="hidden" name="<%= addressBean1.getAttributeName( AddressBean.FORM_ACTION )%>" value=""/>
    <impact:validateInput type="hidden" name="<%= addressBean1.getAttributeName( AddressBean.MULT_COUNTY )%>" value=""/>
    <impact:validateInput type="hidden" name="<%= AddressBean.ADDRESS_SUBMODULE_NAME + "2" %>" value="<%= addressBean2.getAddressSubmoduleName() %>"/>
    <impact:validateInput type="hidden" name="<%= addressBean2.getAttributeName( AddressBean.IN_REQUEST )%>" value="true"/>
    <impact:validateInput type="hidden" name="<%= validatedName2 %>" value="<%= validatedB %>"/>
    <impact:validateInput type="hidden" name="<%= addressBean2.getAttributeName( AddressBean.FORM_ACTION )%>" value=""/>
    <impact:validateInput type="hidden" name="<%= addressBean2.getAttributeName( AddressBean.MULT_COUNTY )%>" value=""/>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>

<impact:ExpandableSectionTag
name="hmDemographics"
id="txtHomeName_Id"
label="Home Demographics"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">

<table width="100%" class="tableborder" border="0" cellspacing="0" cellpadding="3">
<tr class="subDetail">
    <td width="18%"><impact:validateInput
         tabIndex="<%= tabIndex++ %>"
         value="<%= homeName %>"
         type="text"
         name="txtHomeName"
         label="Home Name"
         required="<%= String.valueOf( !bDisableAllFields ) %>"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         cssClass="formInput"
         size="30"
         maxLength="30"
               constraint="Name30"/>
          </td>
          <td width="30%">&nbsp;</td>
          <td>&nbsp;</td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput
         tabIndex="<%= tabIndex++ %>"
         value="<%= legalName %>"
         type="text"
         name="txtLegalName"
         label="Legal Name"
         required="true"
         cssClass="formInput"
         colspan="2"
         size="45"
         maxLength="45"/>
      </td>      
      <td>&nbsp;</td>
    </tr>
    <tr class="subDetail">
       <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= categoryD %>"
         name="selCategory"
         label="Category"
         onChange="categoryChange();"
         codesTable="<%= CodesTables.CFACATEG %>"
         required="<%= String.valueOf( !bDisableAllFields ) %>"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
       </td>
       <td><impact:validateDisplayOnlyField
         name="statusDisplayOnly"

         label="Status"
         value="<%= Lookup.simpleDecodeSafe( CodesTables.CFAHMSTA, statusD ) %>" />
       </td>
    </tr>
    <tr class="subDetail">
          <td><impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            value="<%= religion %>"
            name="selReligion"
            label="Religion"
            codesTable="<%= CodesTables.CRELIGNS %>"
            required="false"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
          </td>
          <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
         value="<%= language %>"
         name="selLanguage"
         label="Language"
         codesTable="<%= CodesTables.CLANG %>"
         required="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
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
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
    </td>
          <td><impact:validateInput
         tabIndex="<%= tabIndex++ %>"
         value="<%= annualIncome %>"
         type="text"
         name="txtAnnualIncome"
         label="Annual Income"
         conditionallyRequired="true"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         cssClass="formInput"
         size="16"
         maxLength="16"
         constraint="Money"/>
          </td>
   </tr>
   <tr class="subDetail">
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= marriageStatus %>"
         name="selMaritalStatus"
         label="Marital Status"
         excludeOptions="<%= excludeFAMSTRC %>"
         codesTable="<%= CodesTables.CFAMSTRC %>"
         conditionallyRequired="true"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
      </td>
      <td><impact:validateDate
         size="10"
         value="<%= FormattingHelper.formatDate( marriageDate ) %>"
         name="marriageDate"
         tabIndex="<%= tabIndex++ %>"
         label="Marriage Date"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"
         constraint="Date"/>
      </td>
   </tr>
   <tr class="subDetail">
    <td colspan="2">
  <impact:validateInput
        tabIndex="<%= tabIndex++ %>"
        value=""
        type="checkbox"
        checked=""
        name="chkIndCurrHomeStudyExists"
        label="A Current Home Study Exists"
        cssClass="formInput" />         
     </td>
     <td colspan="2">
       &nbsp;
     </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            value="<%= schoolDistrict %>"
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
            value=""
            name="selSzCdElementary"
            label="Elementary"
            style="WIDTH:200px"
            required="false"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
     </td>
      </tr>
      <tr class="subDetail">
        <td colspan="2">&nbsp;</td>
        <td><impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            value=""
            name="selSzCdMiddle"
            label="Middle"
            style="WIDTH:200px"
            required="false"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
         </td>
      </tr>
      <tr class="subDetail">
        <td colspan="2">&nbsp;</td>
        <td><impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            value=""
            name="selSzCdHigh"
            label="High"
            style="WIDTH:200px"
            required="false"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
         </td>      
      </tr>

    </table>
</impact:ExpandableSectionTag>
<br>
<impact:ExpandableSectionTag
name="address"
id="txtNbrRsrcAddrVid_Id"
label="Address"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">
<table cellspacing="0" cellpadding="0" width="100%"><tr><td class="subDetail">
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
   <tr>
     <td width="15%"><impact:validateSelect
          name="selCdRsrcAddrType"
          label="Type"
          required="true"
          disabled="true"
          tabIndex="<%=tabIndex++%>"
          codesTable="CRSCADDR"
          width="25%"
          value="<%= txtSzCdRsrcAddrType %>"/></td>
     <td width="15%">&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
   <impact:validateInput type="hidden" name="txtNbrRsrcAddrVid" value="<%=txtSzNbrRsrcAddrVid%>" />
   <tr>
    <td><impact:validateInput
          type="text"
          name="txtNbrRsrcAddrVidDisplay"
          label="Vendor ID"
          tabIndex="<%=tabIndex++%>"
          cssClass="formInput"
          value="<%=txtSzNbrRsrcAddrVid%>"
          constraint="VendorID"
          disabled="true"
          maxLength="8"
          size="8"/>
          <%-- SIR 16091/23166 - added constraint for VendorID --%>
    </td>
    <td><impact:validateInput
          type="text"
          name="txtSzAddrRsrcAddrAttn"
          label="Attention"
          tabIndex="<%=tabIndex++%>"
          cssClass="formInput"
          value="<%=txtSzAddrRsrcAddrAttn%>"
          constraint="Name"
          disabled="<%=attentionDisabled%>"
          style="WIDTH: 120px"
          maxLength ="30"/></td>
   </tr>
   <tr>
    <td>
    <%-- txtSzAddrRsrcAddrStLn1 --%>
    <impact:validateInput
          type="text"
          required="true"
          name="<%= address1Name1 %>"
          onChange="javascript:unValidate();"
          label="Address Ln 1"
          tabIndex="<%=tabIndex++%>"
          cssClass="formInput"
          disabled="<%=streetLn1Disabled%>"
          constraint="Address"
          value="<%= StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn1)%>"
          style="WIDTH: 150px"
          maxLength ="30"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   </tr>
   <tr>
    <td>
    <%-- txtSzAddrRsrcAddrStLn2 --%>
    <impact:validateInput
          type="text"
          tabIndex="<%=tabIndex++%>"
          name="<%= address2Name1 %>"
          onChange="javascript:unValidate();"
          label="Address Ln 2"
          cssClass="formInput"
          disabled="<%=streetLn2Disabled%>"
          value="<%= StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn2)%>"
          style="WIDTH: 150px"
          constraint="Address"
          maxLength ="60"/></td>
    <td>
    <%-- txtSzAddrRsrcAddrCity --%>
    <impact:validateInput
          type="text"
          tabIndex="<%=tabIndex++%>"
          required="true"
          name="<%= cityName1 %>"
          onChange="javascript:unValidate();"
          label="City"
          cssClass="formInput"
          disabled="<%=cityDisabled%>"
          value="<%= txtSzAddrRsrcAddrCity%>"
          constraint="City"
          style="WIDTH: 150px"
          maxLength ="20"/></td>
   </tr>
   <tr>
   <%
    List<String> excludeList = new ArrayList<String>();
    if(txtSzCdFacilityState != null && txtSzCdFacilityState.equals("GA"))
    {
        excludeList.add("999");
    }
    %>
    <td>
    <%-- selCdFacilityState --%>
    <impact:validateSelect
          name="<%= stateName1 %>"
          tabIndex="<%=tabIndex++%>"
          onChange="javascript:unValidate(); checkCountyForState(); checkState();"
          label="State"
          codesTable="CSTATE"
          required="true"
          disabled="<%=stateDisabled%>"
          value="<%=txtSzCdFacilityState%>"/></td>
    <td>
    <%-- txtSzAddrRsrcAddrZip --%>
    <impact:validateInput type="text"
          name="<%= zipName1 %>"
          tabIndex="<%=tabIndex++%>"
          onChange="javascript:unValidate();"
          label="Zip"
          cssClass="formInput"
          required="true"
          disabled="<%=zipDisabled%>"
          value="<%=txtSzAddrRsrcAddrZip%>"
    constraint="Digit5"
    maxLength ="5" size="5"/>
  -
  <%-- txtSzAddrRsrcAddrZipSuff --%>
  <impact:validateInput
          type="text"
          name="<%= zipSuffName1 %>"
          onChange="javascript:unValidate();"
          tabIndex="<%=tabIndex++%>"
          cssClass="formInput"
          disabled="<%=zipDisabled%>"
          value="<%=txtSzAddrRsrcAddrZipSuff%>"
    constraint="Digit4"
    maxLength ="4" size="4"/>
  <%if( !validateButtonHide ){ %>
    &nbsp;
       <impact:ButtonTag
          name="btnValidateAddressRow"
          img="btnValidate"
          navAwayCk="true"
          function="openValidateWindow(); return false;"
          form="frmNewHomeInformation"
          action="/fad/HomeInfrmtn/displayAddressDetail"
          tabIndex="<%=tabIndex++%>"/>
  <% } %>
    </td>
   </tr>
   <tr>
     <td>
     <%-- selCdFacilityCounty --%>
     <impact:validateSelect
          name="<%= countyName1 %>"
          tabIndex="<%=tabIndex++%>"
          label="County"
          required="true"
          blankValue="true"
          disabled="<%=countyDisabled%>"
          codesTable="CCOUNT"
          excludeOptions="<%= excludeList %>"
          onChange="unValidate();"
          value="<%= FormattingHelper.formatString( txtSzCdFacilityCounty )%>"/>
          <select name="hiddenAddressCounty" style="display:none;"></select>
     </td>
     <td colspan="2">&nbsp;</td>
   </tr>
   <tr>
     <td class="formLabel" colspan="1" valign="top">Comments:</td>
     <td colspan=3><impact:validateTextArea
                    name="txtszTxtRsrcAddrComments"
                    cols="80" rows="3"
                    tabIndex="<%=tabIndex++%>"
                    disabled="<%=addressCommentsDisabled%>"
                    maxLength="80"
                    constraint="Paragraph80">
                    <%=txtszTxtRsrcAddrComments%>
                   </impact:validateTextArea></td>
   </tr>
</table>
  <impact:validateInput type="hidden" name="hdnNbrRsrcAddrLat" value="0"/>
  <impact:validateInput type="hidden" name="hdnNbrRsrcAddrLong" value="0"/>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
   <tr>
     <td width="15%"><impact:validateSelect
        name="selCdRsrcAddrTypeB"
        label="Type"
        conditionallyRequired="true"
        disabled="true"
        tabIndex="<%=tabIndex++%>"
        codesTable="CRSCADDR"
        width="25%"
        value="<%= txtSzCdRsrcAddrTypeB %>"/>
     </td>
     <td width="15%">&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
   <tr>
    <td><impact:validateInput
        type="text"
        conditionallyRequired="true"
        name="txtNbrRsrcAddrVidB"
        label="Vendor ID"
        tabIndex="<%=tabIndex++%>"
        cssClass="formInput"
        value="<%=txtSzNbrRsrcAddrVidB%>"
        constraint="VendorID"
        disabled="true"
        maxLength="8"
        size="8"/>
    <%-- SIR 16091/23166 - added constraint for VendorID --%>
    </td>
    <td><impact:validateInput
        type="text"
        name="txtSzAddrRsrcAddrAttnB"
        label="Attention"
        tabIndex="<%=tabIndex++%>"
        cssClass="formInput"
        value="<%=txtSzAddrRsrcAddrAttnB%>"
        constraint="Name"
        disabled="<%=attentionDisabledB%>"
        style="WIDTH: 120px"
        maxLength ="30"/>
    </td>
   </tr>
   <tr>
    <td>
    <%-- txtSzAddrRsrcAddrStLn1B --%>
    <impact:validateInput
        type="text"
        conditionallyRequired="true"
        name="<%= address1Name2 %>"
        onChange="javascript:unValidateB();"
        label="Address Ln 1"
        tabIndex="<%=tabIndex++%>"
        cssClass="formInput"
        disabled="<%=streetLn1DisabledB%>"
        constraint="Address"
        value="<%=txtSzAddrRsrcAddrStLn1B%>"
        style="WIDTH: 150px"
        maxLength ="30"/>
    </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   </tr>
   <tr>
    <td>
    <%-- txtSzAddrRsrcAddrStLn2B --%>
    <impact:validateInput
        type="text"
        tabIndex="<%=tabIndex++%>"
        name="<%= address2Name2 %>"
        onChange="javascript:unValidateB();"
        label="Address Ln 2"
        cssClass="formInput"
        disabled="<%=streetLn2DisabledB%>"
        value="<%=txtSzAddrRsrcAddrStLn2B%>"
        style="WIDTH: 150px"
        constraint="Address"
        maxLength ="30"/>
    </td>
    <td>
    <%-- txtSzAddrRsrcAddrCityB --%>
    <impact:validateInput type="text"
        name="<%= cityName2 %>"
        tabIndex="<%=tabIndex++%>"
        conditionallyRequired="true"
        onChange="javascript:unValidateB();"
        label="City"
        cssClass="formInput"
        disabled="<%=cityDisabledB%>"
        value="<%=txtSzAddrRsrcAddrCityB%>"
        constraint="City"
        style="WIDTH: 150px"
        maxLength ="20"/>
    </td>
   </tr>
   <tr>
   <%
    List<String> excludeListB = new ArrayList<String>();
    if(txtSzCdFacilityStateB != null && txtSzCdFacilityStateB.equals("GA"))
    {
        excludeListB.add("999");
    }
    %>
    <td>
    <%-- selCdFacilityStateB --%>
    <impact:validateSelect
        name="<%= stateName2 %>"
        tabIndex="<%=tabIndex++%>"
        onChange="javascript:unValidateB(); checkCountyForStateB();"
        label="State"
        codesTable="CSTATE"
        conditionallyRequired="true"
        disabled="<%=stateDisabledB%>"
        value="<%=txtSzCdFacilityStateB%>"/>
    </td>
    <td>
    <%-- txtSzAddrRsrcAddrZipB --%>
    <impact:validateInput type="text"
        name="<%= zipName2 %>"
        tabIndex="<%=tabIndex++%>"
        onChange="javascript:unValidateB();"
        label="Zip"
        cssClass="formInput"
        conditionallyRequired="true"
        disabled="<%=zipDisabledB%>"
        value="<%=txtSzAddrRsrcAddrZipB%>"
        constraint="Digit5"
        maxLength ="5" size="5"/>
        -
      <%-- txtSzAddrRsrcAddrZipSuffB --%>
      <impact:validateInput
        type="text"
        name="<%= zipSuffName2 %>"
        onChange="javascript:unValidateB();"
        tabIndex="<%=tabIndex++%>"
        cssClass="formInput"
        disabled="<%=zipDisabledB%>"
        value="<%=txtSzAddrRsrcAddrZipSuffB%>"
        constraint="Digit4"
        maxLength ="4" size="4"/>
      <%if( !validateButtonHide ){%>
        &nbsp;
          <impact:ButtonTag
            name="btnValidateAddressRowB"
            img="btnValidate"
            navAwayCk="true"
            function="openValidateWindowB(); return false;"
            form="frmNewHomeInformation"
            action="/fad/HomeInfrmtn/displayAddressDetail"
            tabIndex="<%=tabIndex++%>"/>
      <%}%>
    </td>
   </tr>
   <tr>
     <td>
     <%-- selCdFacilityCountyB --%>
     <impact:validateSelect
        name="<%= countyName2 %>"
        tabIndex="<%=tabIndex++%>"
        label="County"
        conditionallyRequired="true"
        disabled="<%=countyDisabled%>"
        codesTable="CCOUNT"
        excludeOptions="<%= excludeListB %>"
        onChange="unValidateB();"
        value="<%=txtSzCdFacilityCountyB%>"/>
        <select name="hiddenAddressCountyB" style="display:none;"></select>
      </td>
     <td>&nbsp;</td>
   </tr>
   <tr>
     <td class="formLabel" colspan="1" valign="top">Comments:</td>
     <td colspan=3><impact:validateTextArea
        name="txtszTxtRsrcAddrCommentsB"
        cols="80" rows="3"
        tabIndex="<%=tabIndex++%>"
        disabled="<%=addressCommentsDisabledB%>"
                    maxLength="80"
        constraint="Paragraph80">
        <%=txtszTxtRsrcAddrCommentsB%>
       </impact:validateTextArea></td>
   </tr>
</table>
  <impact:validateInput type="hidden" name="hdnNbrRsrcAddrLatB" value="0"/>
  <impact:validateInput type="hidden" name="hdnNbrRsrcAddrLongB" value="0"/>
</td></tr></table>
</impact:ExpandableSectionTag>
<br>

<%--SIR 22684 - Phone Type and Phone Number no longer required since this page processes only FAD Inquiries.--%>
<impact:ExpandableSectionTag
name="phone"
id="txtLNbrFacilPhoneNumber_Id"
label="Phone"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">
<table cellspacing="0" cellpadding="0" width="100%"><tr><td class="subDetail">
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr align=left valign=top>
    <td class="subDetail" width="14%"><impact:validateSelect
                           label="Type"
                           name="selSzCdFacilPhoneType"
                           tabIndex="<%=tabIndex++%>"
                           codesTable="CRSCPHON"
                           disabled="true"
                           value="01"/></td>
  </tr>
  <tr>
    <td class="subDetail"><impact:validateInput
                           type="text"
                           label="Phone"
                           constraint="Phone"
                           name="txtLNbrFacilPhoneNumber"
                           disabled="<%=phoneNumberDisabled%>"
                           cssClass="formInput"
                           value="<%=szLNbrFacilPhoneNumber%>"
                           size="14"
                           required="true"
                           maxLength ="14"
                           tabIndex="<%=tabIndex++%>"/></td>
  </tr>
  <tr  align="left" valign="top">
    <td class="subDetail"><impact:validateInput
                           type="text"
                           label="&nbsp;&nbsp;Ext"
                           name="txtLNbrFacilPhoneExtension"
                           disabled="<%=phoneExtensionDisabled%>"
                           cssClass="formInput"
                           value="<%=szLNbrFacilPhoneExtension%>"
                           constraint="PhoneExtension"
                           size="8"
                           maxLength ="8"
                           tabIndex="<%=tabIndex++%>"/></td>
  </tr>
  <tr>
    <td class="formLabel" class="subDetail" valign="top">Comments:</td>
    <td  class="subDetail" colspan=3>
      <impact:validateTextArea
        cols="50"
        rows="4"
        name="txtszTxtRsrcPhoneComments"
        disabled="<%=phoneCommentsDisabled%>"
        tabIndex="<%=tabIndex++%>"
        maxLength="80"
        constraint="Paragraph80">
        <%=szSzTxtRsrcPhoneComments%>
      </impact:validateTextArea>
    </td>
  </tr>
</table>
</td></tr></table>
<%/* END Phone Section */%>

</impact:ExpandableSectionTag>
      <BR>
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
        <impact:validateDate name="dtDtInquiryDate" label="Inquiry Date" size="10" constraint="Date" value="<%=FormattingHelper.formatDate( inquiryDate )%>"
         disabled="<%= String.valueOf( bDisableAllFields ) %>" tabIndex="<%=tabIndex++%>" required="true"/>
    </td>
    <td>
    <impact:validateSelect label="Inquiry Received By" name="txtSzCdInqryRcvdBy" tabIndex="<%=tabIndex++%>"
     disabled="<%= String.valueOf( bDisableAllFields ) %>"  required="true" codesTable="CINQRCBY"
     value="<%= inqRecvdBy %>"/>
    </td>
  </tr>
  <tr>
    <td>
    <impact:validateSelect label="Information Packet Requested" name="selCdInfoPcktRqstd" tabIndex="<%=tabIndex++%>"
            codesTable="CINFPKRQ" disabled="<%= String.valueOf( bDisableAllFields ) %>" value="<%= infoPacktRequested %>"/>
    </td>
    <td>
    <impact:validateDate label="Information Packet Sent" name="dtDtInfoPcktSent" tabIndex="<%=tabIndex++%>"
            size="10" constraint="Date" value="<%=FormattingHelper.formatDate( infPacktSent ) %>" disabled="<%= String.valueOf( bDisableAllFields ) %>"/>

    </td>
  </tr>
  <tr>
    <td>
    <impact:validateInput type="text" label="Requested Number Of Children" name="txtNbrRqstdNbrOfChldrn"
            disabled="<%= String.valueOf( bDisableAllFields ) %>" cssClass="formInput" value="<%=""%>"
            constraint="Numeric" size="3" maxLength ="3" tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
      <impact:validateInput
         type="text"
         label="Child Specific Interest"
         name="txtSzChldSpcfcInterest"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         cssClass="formInput"
         value="<%= childSpecInterest%>"
         constraint="Paragraph30"
         size="30"
         maxLength ="30"
                           tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  <tr>
    <td >
           <impact:validateTextArea
            name="txtInquiryComments"
            colspan="3"
            label="Inquiry Comments"
            rows="4"
            cols="70"
            tabIndex="<%= tabIndex++ %>"
            disabled="<%= String.valueOf( bDisableAllFields ) %>"
            maxLength="300"
            constraint="Comments">
            <%= inquiryComments %>
          </impact:validateTextArea>
    </td>
  </tr>
</table>
<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
<tr>
<th colspan="8">Sources Of Inquiry</th>
</tr>
<tr class="subDetail">
<%   int srcsOfInqLoopCount = 0;
  while (srcsOfInqIter.hasNext())
  {
   String srcOfInqCode = (String) srcsOfInqIter.next();
   boolean isSrcOfInqChecked = false;
   srcsOfInqLoopCount++;
   String srcOfInqChkbxName = "SrcsOfInquiryCbx_" + srcsOfInqLoopCount;
   if ( !"".equals(ContextHelper.getStringSafe(request, srcOfInqChkbxName)) )
   {
     isSrcOfInqChecked = true;
   }
        %>
  <td>
      <impact:validateInput
        name="<%= srcOfInqChkbxName %>"
        checked="<%= String.valueOf(isSrcOfInqChecked) %>"
        type="checkbox"
        value="<%= srcOfInqCode %>"
        cssClass="formInput"
        label="<%= Lookup.simpleDecodeSafe(CodesTables.CFASRCIN, srcOfInqCode)%>"
        tabIndex="<%= tabIndex++ %>"/>
  </td>
       <%if (srcsOfInqLoopCount % 3 == 0)
   {%>
     </tr><tr class="subDetail">
       <%}

   } //end while
   if (srcsOfInqLoopCount % 3 == 1)
   { %>
      <td colspan="2">&nbsp;</td>
   <%
   }
   else if (srcsOfInqLoopCount % 3 == 2)
   { %>
      <td>&nbsp;</td>
   <%
   } 
   %>
</tr>
</table>
<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
<tr>
<th colspan="8">Information Covered</th>
</tr>
<tr class="subDetail">
<%   int infoCoveredLoopCount = 0;
  while (infoCovrdIter.hasNext())
  {
   String infoCovrdCode = (String) infoCovrdIter.next();
   boolean isInfoCovrdChecked = false;
   infoCoveredLoopCount++;
   String infoCovrdChkbxName = "InfoCoveredCbx_" + infoCoveredLoopCount;
   if ( !"".equals(ContextHelper.getStringSafe(request, infoCovrdChkbxName)) )
   {
     isInfoCovrdChecked = true;
   }
    %>
  <td>
      <impact:validateInput
        name="<%= infoCovrdChkbxName %>"
        checked="<%= String.valueOf(isInfoCovrdChecked) %>"
        type="checkbox"
        value="<%= infoCovrdCode %>"
        cssClass="formInput"
        label="<%= Lookup.simpleDecodeSafe(CodesTables.CINFCVRD, infoCovrdCode)%>"
        tabIndex="<%= tabIndex++ %>"/>
  </td>
       <%if (infoCoveredLoopCount % 3 == 0)
   {%>
     </tr><tr class="subDetail">
       <%}

   } //end while
     if (infoCoveredLoopCount % 3 == 2)
  { %>
      <td colspan="2">&nbsp;</td>
      <%}%>
</tr>
</table>
</impact:ExpandableSectionTag>
      <BR>
      
<impact:ExpandableSectionTag
name="homeInterest"
id="selMaleMinYearInt_Id"
label="Home Interest"
tabIndex="<%= tabIndex++ %>"
anchor="anchorName">

<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
<tr>
<th colspan="6" id="programsOfInterests">Programs Of Interest</th>
</tr>
<tr class="subDetail">
            <% int prgrmOfInterestLoopCount = 0;
                while (prgrmsOfInterestsIter.hasNext())
                {
                 String prgrmOfInterestCode = (String) prgrmsOfInterestsIter.next();
                 boolean isPrgrmsOfInterestChecked = false;
                 prgrmOfInterestLoopCount++;
                 String chkbxName = "PrgmsOfInterestCbx_" + prgrmOfInterestLoopCount;
          if ( !"".equals(ContextHelper.getStringSafe(request, chkbxName)) )
          {
            isPrgrmsOfInterestChecked = true;
          }
              %><td>
        <impact:validateInput
          name="<%= chkbxName %>"
          checked="<%= String.valueOf(isPrgrmsOfInterestChecked) %>"
          type="checkbox"
          value="<%= prgrmOfInterestCode %>"
          cssClass="formInput"
          label="<%= Lookup.simpleDecodeSafe(CodesTables.CPRGMINT, prgrmOfInterestCode)%>"
          tabIndex="<%= tabIndex++ %>"/>
    </td>
               <%if (prgrmOfInterestLoopCount % 3 == 0)
                 {%>
                   </tr><tr class="subDetail">
               <%}
                 
                 } //end while
             if (prgrmOfInterestLoopCount % 3 == 2)
                { %>
                  <td colspan="2">&nbsp;</td>
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
<%
String maleMinYear = String.valueOf( maleMinInterestInMonths/12 );
String maleMaxYear = String.valueOf( maleMaxInterestInMonths/12 );
%>
<tr>
<th colspan="8">Male Age Range Interests</th>
</tr>
    <tr class="subDetail">
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= maleMinYear %>"
         name="selMaleMinYearInt"
         label="Min Year"
         options="<%= yearOptions %>"
         blankValue="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
      </td>
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= String.valueOf( maleMinInterestInMonths%12 ) %>"
         name="selMaleMinMonthInt"
         label="Min Month"
         options="<%= monthOptions %>"
         blankValue="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
      </td>
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= maleMaxYear %>"
         name="selMaleMaxYearInt"
         label="Max Year"
         options="<%= yearOptions %>"
         blankValue="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
      </td>
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= String.valueOf( maleMaxInterestInMonths%12 ) %>"
         name="selMaleMaxMonthInt"
         label="Max Month"
         options="<%= monthOptions %>"
         blankValue="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
      </td>
    </tr>
  </Table>
  <br>
<%
String femaleMinYear = String.valueOf( femaleMinInterestInMonths/12 );
String femaleMaxYear = String.valueOf( femaleMaxInterestInMonths/12 );
%>

  <table width="100%" class ="tableborder" cellspacing="0" cellpadding="3">
    <tr>
      <th colspan="8">Female Age Range Interests</th>
    </tr>
    <tr class="subDetail">
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= femaleMinYear %>"
         name="selFemaleMinYearInt"
         label="Min Year"
         options="<%= yearOptions %>"
         blankValue="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
      </td>
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= String.valueOf( femaleMinInterestInMonths%12 ) %>"
         name="selFemaleMinMonthInt"
         label="Min Month"
         options="<%= monthOptions %>"
         blankValue="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
      </td>
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= femaleMaxYear %>"
         name="selFemaleMaxYearInt"
         label="Max Year"
         options="<%= yearOptions %>"
         blankValue="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
      </td>
      <td><impact:validateSelect
         tabIndex="<%= tabIndex++ %>"
         value="<%= String.valueOf( femaleMaxInterestInMonths%12 ) %>"
         name="selFemaleMaxMonthInt"
         label="Max Month"
         options="<%= monthOptions %>"
         blankValue="false"
         disabled="<%= String.valueOf( bDisableAllFields ) %>"
         conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
      </td>
    </tr>
          </table>
	<br>
    <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
    <tr>
           <th colspan="4">
             <table cellspacing="0" cellpadding="0" width="100%" >
               <tr>
                <th>Child Races </th>
               </tr>
             </table>
           </th>
     </tr>
     <tr class="subDetail">
    <%
     int raceLoopCount = 1;
     while ( racesIterator.hasNext() )
    {
     String raceCode = (String) racesIterator.next();
     String cbName = "RaceCbx"+ raceLoopCount;
     boolean isRacesChecked = false;
     if ( !"".equals(ContextHelper.getStringSafe(request, cbName)) )
     {
       isRacesChecked = true;
     }
     %>
     <td width="3%">
     <impact:validateInput
             tabIndex="<%= tabIndex++ %>"
             value="<%= raceCode  %>"
             type="checkbox"
             checked="<%= String.valueOf( isRacesChecked ) %>"
             name="<%= cbName %>"
             label="<%= Lookup.simpleDecodeSafe( CodesTables.CADRACE, raceCode )%>"
             cssClass="formInput"
             width="38%" />
     </td>
     <%
       if ( raceLoopCount % 2 == 0 )
     {
     %>
     </tr>
     <tr class="subDetail">
     <%
     }
     raceLoopCount++;
     } //end while
     if ( raceLoopCount % 2 == 0 )
     {
     %>
     <td>&nbsp;</td>
     <%}%>
     </tr>
    </table>

    
    <br>
    <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
    <tr>
           <th colspan="4">
             <table cellspacing="0" cellpadding="0" width="100%" >
               <tr>
                <th>Child Ethnicities </th>
               </tr>
             </table>
           </th>
     </tr>
     <tr class="subDetail">
    <%
     int loopCount = 1;
     while ( ethnicitiesIterator.hasNext() )
    {
     String ethCode = (String) ethnicitiesIterator.next();
     String cbName = "EthCbx"+ loopCount;
     boolean isEthnicitiesChecked = false;
     if ( !"".equals(ContextHelper.getStringSafe(request, cbName)) )
     {
       isEthnicitiesChecked = true;
     }
     %>
     <td width="3%">
     <impact:validateInput
             tabIndex="<%= tabIndex++ %>"
             value="<%= ethCode  %>"
             type="checkbox"
             checked="<%= String.valueOf( isEthnicitiesChecked ) %>"
             name="<%= cbName %>"
             label="<%= Lookup.simpleDecodeSafe( CodesTables.CINDETHN, ethCode )%>"
             cssClass="formInput"
             width="38%" />
     </td>
     <%
       if ( loopCount % 2 == 0 )
     {
     %>
     </tr>
     <tr class="subDetail">
     <%
     }
     loopCount++;
     } //end while
     if ( loopCount % 2 == 0 )
     {
     %>
     <td>&nbsp;</td>
     <%}%>
     </tr>
    </table>
    <br>
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
// STGAP00017231: Looping through categories to display Expandable Sections 

		  List<CodeAttributes> characteristicsCategories = Lookup.getCategoryCollection(CodesTables.CCHRTCA2);
		Iterator characteristicsCategoryIterator = characteristicsCategories.iterator();

        while(characteristicsCategoryIterator.hasNext()){
        	CodeAttributes charCatCodeAtt = (CodeAttributes)characteristicsCategoryIterator.next();
            String catCode = charCatCodeAtt.getCode();
			String cbxName = "CharCbx" + catCode;
            String catDecode = charCatCodeAtt.getDecode();
			int catCodeSize =  Lookup.getCategoryCollection(catCode).size();


			
			
        %>
        		<impact:ExpandableSectionTag name="<%= catCode %>" id="" label="<%= catDecode %>" tabIndex="<%=tabIndex++%>">
				<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
		<%  

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
		  <td colspan="2" class="subDetail">
          <impact:codesCheckbox  name="<%= cbxName %>" codesTableName="<%= catCode %>" columns="3" isHorizontal="true" orderBy="decode" tabIndex="<%= tabIndex++ %>" />
        </td>         
           </tr>
          </table>
		</impact:ExpandableSectionTag>
		<%
		}
		%>
    <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
       <tr class="subDetail">
    <td><impact:validateInput
        tabIndex="<%= tabIndex++ %>"
        value="test"
        type="checkbox"
        checked="<%= String.valueOf( willTransport ) %>"
        name="ckWillTransport"
        label="Will Transport Child[ren]"
        cssClass="formInput" />
       </td>
       <td><impact:validateInput
        tabIndex="<%= tabIndex++ %>"
        value="test"
        type="checkbox"
        checked="<%= String.valueOf( emergencyPlacements ) %>"
        name="ckEmergPlacement"
        label="Emergency Placements"
        cssClass="formInput" />
       </td>
       </tr><tr class="subDetail">
       <td>
       <impact:validateTextArea
        name="txtComments"
        colspan="3"
        label="Home Interest Comments"
        rows="4"
        cols="70"
        tabIndex="<%= tabIndex++ %>"
        maxLength="300"
        constraint="Comments">
        <%= homeInterestComments %>
    </impact:validateTextArea>
      </td>
    </tr>
    </table>
</impact:ExpandableSectionTag>
<br>
<br>
<table cellspacing="0" cellpadding="3" width="100%"><tr><td>
<%     if ( !bHideSaveButton )
    {%>

        <td align="right">
        <impact:ButtonTag
             name="btnSave"
             img="btnSave"
             form="frmNewHomeInformation"
             function="return saveWithValidate();"
             action="/fad/HomeInfrmtn/saveAssignHomeInformation"
             restrictRepost="true"
             preventDoubleClick="true"
             tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%}%>
    </table>
      <script>addQuestionMark();</script>
</impact:validateForm>
<br>