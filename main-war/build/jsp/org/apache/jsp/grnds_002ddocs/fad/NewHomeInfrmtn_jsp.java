package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.SortedMap;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;

public final class NewHomeInfrmtn_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<!--Start Main Content-->\r\n");
 BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

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

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n<script language=\"Javascript1.2\">\r\nwindow.attachEvent('onbeforeunload', myOnBeforeUnload );\r\nwindow.attachEvent('onload', expandMySectionOnLoad );\r\nwindow.attachEvent('onload', collapseAllCategories );\r\n\r\nwindow.onload = function ()\r\n{\r\n  checkNameAddress();\r\n}\r\n\r\nfunction expandMySectionOnLoad()\r\n{\r\n expandCollapsed( 'expanded' + 'hmDemographics', 'collapsed' + 'hmDemographics')\r\n}\r\n\r\n function selectAll(catCode, numOfCheckboxes, checkValue) {\r\n  var checkboxField;\r\n\r\n  for ( i = 1; i <= numOfCheckboxes; i++ )\r\n  {\r\n    checkboxField = eval('document.frmNewHomeInformation.CharCbx' + catCode + i);\r\n\tvar field = 'CharCbx' + catCode + i;\r\n\t\r\n\tif (checkValue && checkboxField.checked != checkValue)\r\n\t {\r\n\t checkboxField.click();\r\n\t }\r\n      else if (checkboxField.checked != checkValue)\r\n             {\r\n             checkboxField.click();\r\n");
      out.write("             }\r\n  }\r\n}\r\n\r\n\r\n\r\nfunction expandAllCategories()\r\n{\r\nexpandCollapsed('expandedDED2','collapsedDED2' )\r\nexpandCollapsed('expandedEBD2','collapsedEBD2' )\r\nexpandCollapsed('expandedEXB2','collapsedEXB2' )\r\nexpandCollapsed('expandedFHI2','collapsedFHI2' )\r\nexpandCollapsed('expandedHVI2','collapsedHVI2' )\r\nexpandCollapsed('expandedMED2','collapsedMED2' )\r\nexpandCollapsed('expandedMER2','collapsedMER2' )\r\nexpandCollapsed('expandedOTH2','collapsedOTH2' )\r\n\r\n}\r\n\r\n\r\nfunction collapseAllCategories()\r\n{\r\nexpandCollapsed('collapsedDED2','expandedDED2' )\r\nexpandCollapsed('collapsedEBD2','expandedEBD2' )\r\nexpandCollapsed('collapsedEXB2','expandedEXB2' )\r\nexpandCollapsed('collapsedFHI2','expandedFHI2' )\r\nexpandCollapsed('collapsedHVI2','expandedHVI2' )\r\nexpandCollapsed('collapsedMED2','expandedMED2' )\r\nexpandCollapsed('collapsedMER2','expandedMER2' )\r\nexpandCollapsed('collapsedOTH2','expandedOTH2' )\r\n\r\n}\r\n\r\n\r\n// Check for changes before navigating off\r\nfunction myOnBeforeUnload()\r\n{\r\n  IsDirty();\r\n}\r\n\r\n// Added for MR-066\r\n");
      out.write("function checkNameAddress()\r\n{\r\n  var errorCode = '");
      out.print( (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") );
      out.write("';\r\n  var bSaveIsPressed = '");
      out.print( (String) request.getAttribute("bSaveIsPressed") );
      out.write("';\r\n  if (errorCode == '");
      out.print( Messages.MSG_FAD_DUPLICATE_NOT_ALLOWED );
      out.write("')\r\n  {\r\n  \tif (confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_FAD_DUPLICATE_NOT_ALLOWED) );
      out.write("')) \r\n  \t{\r\n  \t  document.frmNewHomeInformation.hdnBSysIndPrfrmNameCheck.value = 'N';\r\n  \t  submitValidateForm(\"frmNewHomeInformation\",\"/fad/HomeInfrmtn/saveAssignHomeInformation\");\r\n  \t}\r\n  }\r\n\r\n}\r\n\r\nfunction unValidate()\r\n{\r\n  document.frmNewHomeInformation.");
      out.print( validatedName1 );
      out.write(".value=\"false\";\r\n}\r\n\r\nfunction unValidateB()\r\n{\r\n  document.frmNewHomeInformation.");
      out.print( validatedName2 );
      out.write(".value=\"false\";\r\n}\r\n\r\n\r\n\r\n//function openValidateWindowValidate()\r\n//{\r\n//  var x = document.frmNewHomeInformation;\r\n//  x.hdnSaveOrValidate.value = 'validate';\r\n//  openValidateWindow();\r\n//}\r\n\r\n//function openValidateWindowValidateB()\r\n//{\r\n//  var x = document.frmNewHomeInformation;\r\n//  x.hdnSaveOrValidateB.value = 'validate';\r\n//  openValidateWindowB();\r\n//}\r\n\r\n//function openValidateWindowSave()\r\n//{\r\n//  var x = document.frmNewHomeInformation;\r\n//  x.hdnSaveOrValidate.value = 'save';\r\n//  openValidateWindow();\r\n//}\r\n\r\n//function openValidateWindowSaveB()\r\n//{\r\n//  var x = document.frmNewHomeInformation;\r\n//  x.hdnSaveOrValidateB.value = 'save';\r\n//  openValidateWindowB();\r\n//}\r\n\r\n\r\n/*\r\n *This function opens the address validation window.\r\n */\r\nfunction openValidateWindow()\r\n{\r\n  launchAddressValidate('frmNewHomeInformation', 'validate', '");
      out.print( addressBean1.getAddressSubmoduleName() );
      out.write("');\r\n  document.frmNewHomeInformation.");
      out.print( validatedName1 );
      out.write(".value = \"true\";\r\n}\r\n\r\nfunction openValidateWindowB()\r\n{\r\n  launchAddressValidate('frmNewHomeInformation', 'validate', '");
      out.print( addressBean2.getAddressSubmoduleName() );
      out.write("');\r\n  document.frmNewHomeInformation.");
      out.print( validatedName2 );
      out.write(".value = \"true\";\r\n}\r\n\r\nfunction saveWithValidate()\r\n{\r\n  var x = document.frmNewHomeInformation;\r\n\r\n  if ( x.");
      out.print( validatedName2 );
      out.write(".value == \"false\" && x.");
      out.print( address1Name2 );
      out.write(".value != \"\" )\r\n  {\r\n    //x.hdnSaveOrValidate.value = 'save';\r\n    //valid = validateAddressOnSave('frmNewHomeInformation', '/fad/HomeInfrmtn/saveAssignHomeInformation', '");
      out.print( addressBean2.getAddressSubmoduleName() );
      out.write("');\r\n    //x.");
      out.print( validatedName2 );
      out.write(".value = \"\\\"\" + valid + \"\\\"\";\r\n    alert(\"Please validate the Business address before saving.\");\r\n    return false;\r\n  }\r\n  \r\n  if ( x.");
      out.print( validatedName1 );
      out.write(".value == \"false\") //-- unValidate explicitly called\r\n  {\r\n    if ( x.");
      out.print( address1Name1 );
      out.write(".value == '' || x.");
      out.print( cityName1 );
      out.write(".value == '' || x.");
      out.print( stateName1 );
      out.write(" == '' )\r\n    {\r\n      alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FAD_ADDR_PHONE_EXIST ) );
      out.write("');\r\n    } else {\r\n      x.hdnSaveOrValidate.value = 'save';\r\n      return validateAddressOnSave('frmNewHomeInformation', '/fad/HomeInfrmtn/saveAssignHomeInformation', '");
      out.print( addressBean1.getAddressSubmoduleName() );
      out.write("');\r\n    }\r\n  }\r\n  else\r\n  {\r\n      if ( x.selMaritalStatus.value != '");
      out.print( HomeInfrmtnConversation.CODE_MARRIED );
      out.write("' && x.marriageDate.value != '' )\r\n      {\r\n        alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FAD_STATUS_NOT_MARRIED ) );
      out.write("');\r\n          x.marriageDate.value = '';\r\n      }\r\n      x.action = \"/fad/HomeInfrmtn/displayNewHomeInformation\";\r\n     submitValidateForm( \"frmNewHomeInformation\", \"/fad/HomeInfrmtn/saveAssignHomeInformation\" );\r\n  }\r\n}\r\n\r\n//function saveNewHome()\r\n//{\r\n//  var x = document.frmNewHomeInformation;\r\n//  if ( x.selMaritalStatus.value != '");
      out.print( HomeInfrmtnConversation.CODE_MARRIED );
      out.write("' && x.marriageDate.value != '' )\r\n//  {\r\n//    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FAD_STATUS_NOT_MARRIED ) );
      out.write("');\r\n//     x.marriageDate.value = '';\r\n//  }\r\n//  x.action = \"/fad/HomeInfrmtn/displayNewHomeInformation\";\r\n//  submitValidateForm( \"frmNewHomeInformation\", \"/fad/HomeInfrmtn/saveAssignHomeInformation\" );\r\n//  return false;\r\n//}\r\n\r\n\r\nfunction categoryChange()\r\n{\r\n  var x = document.frmNewHomeInformation;\r\n  x.originalCategory.value = x.selCategory.value;\r\n}\r\n\r\n//changed the value property of selCdFacilityState\r\n// to GA from TX\r\nfunction checkState()\r\n{\r\n  var x = document.frmNewHomeInformation;\r\n  if (x.");
      out.print( stateName1 );
      out.write(".value != 'GA')\r\n  {\r\n    x.selSchoolDistrict.disabled = true;\r\n    x.selSchoolDistrict.value = '';\r\n    x.selSzCdElementary.disabled = true;\r\n    x.selSzCdElementary.value = '';\r\n    x.selSzCdMiddle.disabled = true;\r\n    x.selSzCdMiddle.value = '';\r\n    x.selSzCdHigh.disabled = true;\r\n    x.selSzCdHigh.value = '';\r\n  }\r\n  else\r\n  {\r\n    x.selSchoolDistrict.disabled = false;\r\n    x.selSchoolDistrict.value = '';\r\n    x.selSzCdElementary.disabled = false;\r\n    x.selSzCdElementary.value = '';\r\n    x.selSzCdMiddle.disabled = false;\r\n    x.selSzCdMiddle.value = '';\r\n    x.selSzCdHigh.disabled = false;\r\n    x.selSzCdHigh.value = '';\r\n  }\r\n}\r\n\r\n\r\n// This function sets the value of County Dropdown to 999 if State is otherthan GA.\r\nfunction checkCountyForState()\r\n{\r\n  if(window.document.frmNewHomeInformation.");
      out.print( stateName1 );
      out.write("[window.document.frmNewHomeInformation.");
      out.print( stateName1 );
      out.write(".selectedIndex].value != \"GA\")\r\n  {\r\n      for (var i=0, l=window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".options.length;i<l;i++)\r\n      {\r\n          if(window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".options[i].value != \"999\")\r\n          {\r\n              var optionName = new Option(window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".options[i].text, window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".options[i].value, false, false);\r\n              window.document.frmNewHomeInformation.hiddenAddressCounty.options[window.document.frmNewHomeInformation.hiddenAddressCounty.length] = optionName;\r\n              \r\n          }\r\n      }\r\n\t  window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".length = 0;\r\n\t  var optionName = new Option(\"Out of State\", \"999\", true, true);\r\n\t  window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".options[window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".length] = optionName;\r\n  }\r\n  else\r\n  {\r\n      window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".length = 0;\r\n     for (var i=0, l=window.document.frmNewHomeInformation.hiddenAddressCounty.options.length;i<l;i++)\r\n     {\r\n         var optionName = new Option(window.document.frmNewHomeInformation.hiddenAddressCounty.options[i].text, window.document.frmNewHomeInformation.hiddenAddressCounty.options[i].value, false, false);\r\n         window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".options[window.document.frmNewHomeInformation.");
      out.print( countyName1 );
      out.write(".length] = optionName;\r\n     }\r\n     window.document.frmNewHomeInformation.hiddenAddressCounty.length = 0;\r\n  }\r\n}\r\n\r\n// creating function to bypass architectural constraints\r\nfunction addQuestionMark(){\r\n\t// get the parent node of the input element\r\n\tvar labels = document.getElementsByTagName('input');\r\n\tvar SEXUALLY_ACTING_OUT = \"70\";\r\n\tfor(var i = 0; i < labels.length; i++){\r\n\t\tvar label = labels[i];\r\n\t\tvar inn = label.defaultValue;\r\n\t\tif(SEXUALLY_ACTING_OUT == inn){\r\n\t\t\t// get the cell that the label is in (it's parent node)\r\n\t\t\tvar cell = label.parentNode;\r\n\t\t\t\r\n\t\t\tcell = cell.nextSibling;\r\n\t\t\t\r\n\t\t\t// append html to the end of the node's inner html contents\r\n\t\t\tvar inner = cell.innerHTML;\r\n\t\t  cell.innerHTML = inner + '&nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayHelp()\">?</a></strong>';\r\n           break;\r\n\t\t}\r\n\t}\t\r\n}\r\n\r\n// This function sets the value of County Dropdown to 999 if State is otherthan GA.\r\nfunction checkCountyForStateB()\r\n{\r\n  if(window.document.frmNewHomeInformation.");
      out.print( stateName2 );
      out.write("[window.document.frmNewHomeInformation.");
      out.print( stateName2 );
      out.write(".selectedIndex].value != \"GA\")\r\n  {\r\n      for (var i=0, l=window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".options.length;i<l;i++)\r\n      {\r\n          if(window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".options[i].value != \"999\")\r\n          {\r\n              var optionName = new Option(window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".options[i].text, window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".options[i].value, false, false);\r\n              window.document.frmNewHomeInformation.hiddenAddressCountyB.options[window.document.frmNewHomeInformation.hiddenAddressCountyB.length] = optionName;\r\n              \r\n          }\r\n      }\r\n      window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".length = 0;\r\n      var optionName = new Option(\"Out of State\", \"999\", true, true);\r\n      window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".options[window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".length] = optionName;\r\n  }\r\n  else\r\n  {\r\n      window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".length = 0;\r\n     for (var i=0, l=window.document.frmNewHomeInformation.hiddenAddressCountyB.options.length;i<l;i++)\r\n     {\r\n         var optionName = new Option(window.document.frmNewHomeInformation.hiddenAddressCountyB.options[i].text, window.document.frmNewHomeInformation.hiddenAddressCountyB.options[i].value, false, false);\r\n         window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".options[window.document.frmNewHomeInformation.");
      out.print( countyName2 );
      out.write(".length] = optionName;\r\n     }\r\n     window.document.frmNewHomeInformation.hiddenAddressCountyB.length = 0;\r\n  }\r\n}\r\n\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName( CodesTables.CSCHELEM );
      _jspx_th_impact_codeArray_0.setArrayName( CodesTables.CSCHELEM );
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
      _jspx_th_impact_codeArray_1.setCodeName( CodesTables.CSCHMDDL );
      _jspx_th_impact_codeArray_1.setArrayName( CodesTables.CSCHMDDL );
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
      _jspx_th_impact_codeArray_2.setCodeName( CodesTables.CSCHHIGH );
      _jspx_th_impact_codeArray_2.setArrayName( CodesTables.CSCHHIGH );
      _jspx_th_impact_codeArray_2.setBlankValue("true");
      int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
      if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n/*\r\n * populates all the schools for the \r\n * selected school district\r\n */\r\n function populateSchools()\r\n {\r\n   var schoolDistrictCode = document.frmNewHomeInformation.selSchoolDistrict.value;\r\n\r\n   if ( schoolDistrictCode == \"\" )\r\n   {\r\n      clearDropdown( frmNewHomeInformation.selSzCdElementary );\r\n      clearDropdown( frmNewHomeInformation.selSzCdMiddle );\r\n      clearDropdown( frmNewHomeInformation.selSzCdHigh );\r\n   }\r\n   else\r\n   {\r\n      populateDropdownByLoopingThroughArray( \"frmNewHomeInformation\", \"selSzCdElementary\",");
      out.print( CodesTables.CSCHELEM );
      out.write(", schoolDistrictCode, 3, \"\" );\r\n      populateDropdownByLoopingThroughArray( \"frmNewHomeInformation\", \"selSzCdMiddle\",");
      out.print( CodesTables.CSCHMDDL );
      out.write(", schoolDistrictCode, 3, \"\" );\r\n      populateDropdownByLoopingThroughArray( \"frmNewHomeInformation\", \"selSzCdHigh\",");
      out.print( CodesTables.CSCHHIGH );
      out.write(", schoolDistrictCode, 3, \"\" );\r\n   }\r\n }\r\n \r\n function displayHelp(){\r\n  var descriptor = \"\";\r\n  \r\n  // describe the window properties\r\n  descriptor += \"width=450,\";\r\n  descriptor += \"height=350,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=1,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=1,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=1,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=1,\";\r\n  descriptor += \"toolbar=0\";\r\n  \r\n  // open person characteristic help page\r\n  return window.open('/person/PersonDetail/displayPersonCharacteristicsHelp', \"\", descriptor);\r\n}\r\n\r\n\r\n</script>\r\n\r\n\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n <tr>\r\n    <td align=\"right\">\r\n  <a tabIndex=\"");
      out.print( tabIndex++ );
      out.write("\" href=\"#\" onClick=\"javascript:expandAll();\">Expand All</a>&nbsp;\r\n  <a tabIndex=\"");
      out.print( tabIndex++ );
      out.write("\" href=\"#\" onClick=\"javascript:collapseAll();\">Collapse All</a>&nbsp;\r\n    </td>\r\n </tr>\r\n</table>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmNewHomeInformation");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fad/HomeInfrmtn/displayNewHomeInformation");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fad.NewHomeCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n    ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("cReqFuncCd");
          _jspx_th_impact_validateInput_1.setValue(szCReqFuncCd);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          out.write("\r\n    ");
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("vendorId");
          _jspx_th_impact_validateInput_3.setValue(vendorId);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("onLoadStatus");
          _jspx_th_impact_validateInput_8.setValue( statusD );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("selStatus");
          _jspx_th_impact_validateInput_9.setValue( statusD );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("originalCategory");
          _jspx_th_impact_validateInput_10.setValue( categoryD );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("cbxCIndRsrcTransport");
          _jspx_th_impact_validateInput_12.setValue(cbxCIndRsrcTransport);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("addressMultCounty");
          _jspx_th_impact_validateInput_13.setValue( ContextHelper.getStringSafe( request , "addressMultCounty") );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName( AddressBean.ADDRESS_SUBMODULE_NAME + "1" );
          _jspx_th_impact_validateInput_14.setValue( addressBean1.getAddressSubmoduleName() );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName( addressBean1.getAttributeName( AddressBean.IN_REQUEST ));
          _jspx_th_impact_validateInput_15.setValue("true");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName( validatedName1 );
          _jspx_th_impact_validateInput_16.setValue( validated );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName( addressBean1.getAttributeName( AddressBean.FORM_ACTION ));
          _jspx_th_impact_validateInput_17.setValue("");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName( addressBean1.getAttributeName( AddressBean.MULT_COUNTY ));
          _jspx_th_impact_validateInput_18.setValue("");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName( AddressBean.ADDRESS_SUBMODULE_NAME + "2" );
          _jspx_th_impact_validateInput_19.setValue( addressBean2.getAddressSubmoduleName() );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName( addressBean2.getAttributeName( AddressBean.IN_REQUEST ));
          _jspx_th_impact_validateInput_20.setValue("true");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName( validatedName2 );
          _jspx_th_impact_validateInput_21.setValue( validatedB );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName( addressBean2.getAttributeName( AddressBean.FORM_ACTION ));
          _jspx_th_impact_validateInput_22.setValue("");
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName( addressBean2.getAttributeName( AddressBean.MULT_COUNTY ));
          _jspx_th_impact_validateInput_23.setValue("");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("hmDemographics");
          _jspx_th_impact_ExpandableSectionTag_0.setId("txtHomeName_Id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Home Demographics");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_0.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table width=\"100%\" class=\"tableborder\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr class=\"subDetail\">\r\n    <td width=\"18%\">");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_24.setValue( homeName );
              _jspx_th_impact_validateInput_24.setType("text");
              _jspx_th_impact_validateInput_24.setName("txtHomeName");
              _jspx_th_impact_validateInput_24.setLabel("Home Name");
              _jspx_th_impact_validateInput_24.setRequired( String.valueOf( !bDisableAllFields ) );
              _jspx_th_impact_validateInput_24.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              _jspx_th_impact_validateInput_24.setSize("30");
              _jspx_th_impact_validateInput_24.setMaxLength("30");
              _jspx_th_impact_validateInput_24.setConstraint("Name30");
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td width=\"30%\">&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_25.setValue( legalName );
              _jspx_th_impact_validateInput_25.setType("text");
              _jspx_th_impact_validateInput_25.setName("txtLegalName");
              _jspx_th_impact_validateInput_25.setLabel("Legal Name");
              _jspx_th_impact_validateInput_25.setRequired("true");
              _jspx_th_impact_validateInput_25.setCssClass("formInput");
              _jspx_th_impact_validateInput_25.setColspan("2");
              _jspx_th_impact_validateInput_25.setSize("45");
              _jspx_th_impact_validateInput_25.setMaxLength("45");
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>      \r\n      <td>&nbsp;</td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n       <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_0.setValue( categoryD );
              _jspx_th_impact_validateSelect_0.setName("selCategory");
              _jspx_th_impact_validateSelect_0.setLabel("Category");
              _jspx_th_impact_validateSelect_0.setOnChange("categoryChange();");
              _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CFACATEG );
              _jspx_th_impact_validateSelect_0.setRequired( String.valueOf( !bDisableAllFields ) );
              _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n       <td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_0.setName("statusDisplayOnly");
              _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Status");
              _jspx_th_impact_validateDisplayOnlyField_0.setValue( Lookup.simpleDecodeSafe( CodesTables.CFAHMSTA, statusD ) );
              int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_1.setValue( religion );
              _jspx_th_impact_validateSelect_1.setName("selReligion");
              _jspx_th_impact_validateSelect_1.setLabel("Religion");
              _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CRELIGNS );
              _jspx_th_impact_validateSelect_1.setRequired("false");
              _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_2.setValue( language );
              _jspx_th_impact_validateSelect_2.setName("selLanguage");
              _jspx_th_impact_validateSelect_2.setLabel("Language");
              _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CLANG );
              _jspx_th_impact_validateSelect_2.setRequired("false");
              _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n  <tr class=\"subDetail\">\r\n   <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_3.setValue( respite );
              _jspx_th_impact_validateSelect_3.setName("selRespite");
              _jspx_th_impact_validateSelect_3.setLabel("Respite");
              _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CFARSPIT );
              _jspx_th_impact_validateSelect_3.setRequired("false");
              _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_26.setValue( annualIncome );
              _jspx_th_impact_validateInput_26.setType("text");
              _jspx_th_impact_validateInput_26.setName("txtAnnualIncome");
              _jspx_th_impact_validateInput_26.setLabel("Annual Income");
              _jspx_th_impact_validateInput_26.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_26.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateInput_26.setCssClass("formInput");
              _jspx_th_impact_validateInput_26.setSize("16");
              _jspx_th_impact_validateInput_26.setMaxLength("16");
              _jspx_th_impact_validateInput_26.setConstraint("Money");
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_4.setValue( marriageStatus );
              _jspx_th_impact_validateSelect_4.setName("selMaritalStatus");
              _jspx_th_impact_validateSelect_4.setLabel("Marital Status");
              _jspx_th_impact_validateSelect_4.setExcludeOptions( excludeFAMSTRC );
              _jspx_th_impact_validateSelect_4.setCodesTable( CodesTables.CFAMSTRC );
              _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_4.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_0.setSize("10");
              _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate( marriageDate ) );
              _jspx_th_impact_validateDate_0.setName("marriageDate");
              _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_0.setLabel("Marriage Date");
              _jspx_th_impact_validateDate_0.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n    <td colspan=\"2\">\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_27.setValue("");
              _jspx_th_impact_validateInput_27.setType("checkbox");
              _jspx_th_impact_validateInput_27.setChecked("");
              _jspx_th_impact_validateInput_27.setName("chkIndCurrHomeStudyExists");
              _jspx_th_impact_validateInput_27.setLabel("A Current Home Study Exists");
              _jspx_th_impact_validateInput_27.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("         \r\n     </td>\r\n     <td colspan=\"2\">\r\n       &nbsp;\r\n     </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_5.setValue( schoolDistrict );
              _jspx_th_impact_validateSelect_5.setName("selSchoolDistrict");
              _jspx_th_impact_validateSelect_5.setLabel("School District");
              _jspx_th_impact_validateSelect_5.setCodesTable( CodesTables.CSCHDSTR );
              _jspx_th_impact_validateSelect_5.setRequired("false");
              _jspx_th_impact_validateSelect_5.setOnChange("populateSchools()");
              _jspx_th_impact_validateSelect_5.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n     <td>\r\n           ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_6.setValue("");
              _jspx_th_impact_validateSelect_6.setName("selSzCdElementary");
              _jspx_th_impact_validateSelect_6.setLabel("Elementary");
              _jspx_th_impact_validateSelect_6.setStyle("WIDTH:200px");
              _jspx_th_impact_validateSelect_6.setRequired("false");
              _jspx_th_impact_validateSelect_6.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td colspan=\"2\">&nbsp;</td>\r\n        <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_7.setValue("");
              _jspx_th_impact_validateSelect_7.setName("selSzCdMiddle");
              _jspx_th_impact_validateSelect_7.setLabel("Middle");
              _jspx_th_impact_validateSelect_7.setStyle("WIDTH:200px");
              _jspx_th_impact_validateSelect_7.setRequired("false");
              _jspx_th_impact_validateSelect_7.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td colspan=\"2\">&nbsp;</td>\r\n        <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_8.setValue("");
              _jspx_th_impact_validateSelect_8.setName("selSzCdHigh");
              _jspx_th_impact_validateSelect_8.setLabel("High");
              _jspx_th_impact_validateSelect_8.setStyle("WIDTH:200px");
              _jspx_th_impact_validateSelect_8.setRequired("false");
              _jspx_th_impact_validateSelect_8.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>      \r\n      </tr>\r\n\r\n    </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("address");
          _jspx_th_impact_ExpandableSectionTag_1.setId("txtNbrRsrcAddrVid_Id");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Address");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_1.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tr><td class=\"subDetail\">\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n   <tr>\r\n     <td width=\"15%\">");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_9.setName("selCdRsrcAddrType");
              _jspx_th_impact_validateSelect_9.setLabel("Type");
              _jspx_th_impact_validateSelect_9.setRequired("true");
              _jspx_th_impact_validateSelect_9.setDisabled("true");
              _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_9.setCodesTable("CRSCADDR");
              _jspx_th_impact_validateSelect_9.setWidth("25%");
              _jspx_th_impact_validateSelect_9.setValue( txtSzCdRsrcAddrType );
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n     <td width=\"15%\">&nbsp;</td>\r\n     <td>&nbsp;</td>\r\n   </tr>\r\n   ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_28.setType("hidden");
              _jspx_th_impact_validateInput_28.setName("txtNbrRsrcAddrVid");
              _jspx_th_impact_validateInput_28.setValue(txtSzNbrRsrcAddrVid);
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n   <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_29.setType("text");
              _jspx_th_impact_validateInput_29.setName("txtNbrRsrcAddrVidDisplay");
              _jspx_th_impact_validateInput_29.setLabel("Vendor ID");
              _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              _jspx_th_impact_validateInput_29.setValue(txtSzNbrRsrcAddrVid);
              _jspx_th_impact_validateInput_29.setConstraint("VendorID");
              _jspx_th_impact_validateInput_29.setDisabled("true");
              _jspx_th_impact_validateInput_29.setMaxLength("8");
              _jspx_th_impact_validateInput_29.setSize("8");
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              out.write("\r\n    </td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_30.setType("text");
              _jspx_th_impact_validateInput_30.setName("txtSzAddrRsrcAddrAttn");
              _jspx_th_impact_validateInput_30.setLabel("Attention");
              _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setValue(txtSzAddrRsrcAddrAttn);
              _jspx_th_impact_validateInput_30.setConstraint("Name");
              _jspx_th_impact_validateInput_30.setDisabled(attentionDisabled);
              _jspx_th_impact_validateInput_30.setStyle("WIDTH: 120px");
              _jspx_th_impact_validateInput_30.setMaxLength("30");
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n   </tr>\r\n   <tr>\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_31.setType("text");
              _jspx_th_impact_validateInput_31.setRequired("true");
              _jspx_th_impact_validateInput_31.setName( address1Name1 );
              _jspx_th_impact_validateInput_31.setOnChange("javascript:unValidate();");
              _jspx_th_impact_validateInput_31.setLabel("Address Ln 1");
              _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_31.setCssClass("formInput");
              _jspx_th_impact_validateInput_31.setDisabled(streetLn1Disabled);
              _jspx_th_impact_validateInput_31.setConstraint("Address");
              _jspx_th_impact_validateInput_31.setValue( StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn1));
              _jspx_th_impact_validateInput_31.setStyle("WIDTH: 150px");
              _jspx_th_impact_validateInput_31.setMaxLength("30");
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n   </tr>\r\n   <tr>\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_32.setType("text");
              _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_32.setName( address2Name1 );
              _jspx_th_impact_validateInput_32.setOnChange("javascript:unValidate();");
              _jspx_th_impact_validateInput_32.setLabel("Address Ln 2");
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setDisabled(streetLn2Disabled);
              _jspx_th_impact_validateInput_32.setValue( StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn2));
              _jspx_th_impact_validateInput_32.setStyle("WIDTH: 150px");
              _jspx_th_impact_validateInput_32.setConstraint("Address");
              _jspx_th_impact_validateInput_32.setMaxLength("60");
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_33.setType("text");
              _jspx_th_impact_validateInput_33.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_33.setRequired("true");
              _jspx_th_impact_validateInput_33.setName( cityName1 );
              _jspx_th_impact_validateInput_33.setOnChange("javascript:unValidate();");
              _jspx_th_impact_validateInput_33.setLabel("City");
              _jspx_th_impact_validateInput_33.setCssClass("formInput");
              _jspx_th_impact_validateInput_33.setDisabled(cityDisabled);
              _jspx_th_impact_validateInput_33.setValue( txtSzAddrRsrcAddrCity);
              _jspx_th_impact_validateInput_33.setConstraint("City");
              _jspx_th_impact_validateInput_33.setStyle("WIDTH: 150px");
              _jspx_th_impact_validateInput_33.setMaxLength("20");
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n   </tr>\r\n   <tr>\r\n   ");

    List<String> excludeList = new ArrayList<String>();
    if(txtSzCdFacilityState != null && txtSzCdFacilityState.equals("GA"))
    {
        excludeList.add("999");
    }
    
              out.write("\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_10.setName( stateName1 );
              _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_10.setOnChange("javascript:unValidate(); checkCountyForState(); checkState();");
              _jspx_th_impact_validateSelect_10.setLabel("State");
              _jspx_th_impact_validateSelect_10.setCodesTable("CSTATE");
              _jspx_th_impact_validateSelect_10.setRequired("true");
              _jspx_th_impact_validateSelect_10.setDisabled(stateDisabled);
              _jspx_th_impact_validateSelect_10.setValue(txtSzCdFacilityState);
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_34.setType("text");
              _jspx_th_impact_validateInput_34.setName( zipName1 );
              _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_34.setOnChange("javascript:unValidate();");
              _jspx_th_impact_validateInput_34.setLabel("Zip");
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setRequired("true");
              _jspx_th_impact_validateInput_34.setDisabled(zipDisabled);
              _jspx_th_impact_validateInput_34.setValue(txtSzAddrRsrcAddrZip);
              _jspx_th_impact_validateInput_34.setConstraint("Digit5");
              _jspx_th_impact_validateInput_34.setMaxLength("5");
              _jspx_th_impact_validateInput_34.setSize("5");
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  -\r\n  ");
              out.write("\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_35.setType("text");
              _jspx_th_impact_validateInput_35.setName( zipSuffName1 );
              _jspx_th_impact_validateInput_35.setOnChange("javascript:unValidate();");
              _jspx_th_impact_validateInput_35.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_35.setCssClass("formInput");
              _jspx_th_impact_validateInput_35.setDisabled(zipDisabled);
              _jspx_th_impact_validateInput_35.setValue(txtSzAddrRsrcAddrZipSuff);
              _jspx_th_impact_validateInput_35.setConstraint("Digit4");
              _jspx_th_impact_validateInput_35.setMaxLength("4");
              _jspx_th_impact_validateInput_35.setSize("4");
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
if( !validateButtonHide ){ 
              out.write("\r\n    &nbsp;\r\n       ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_0.setName("btnValidateAddressRow");
              _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_0.setFunction("openValidateWindow(); return false;");
              _jspx_th_impact_ButtonTag_0.setForm("frmNewHomeInformation");
              _jspx_th_impact_ButtonTag_0.setAction("/fad/HomeInfrmtn/displayAddressDetail");
              _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
 } 
              out.write("\r\n    </td>\r\n   </tr>\r\n   <tr>\r\n     <td>\r\n     ");
              out.write("\r\n     ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_11.setName( countyName1 );
              _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_11.setLabel("County");
              _jspx_th_impact_validateSelect_11.setRequired("true");
              _jspx_th_impact_validateSelect_11.setBlankValue("true");
              _jspx_th_impact_validateSelect_11.setDisabled(countyDisabled);
              _jspx_th_impact_validateSelect_11.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_11.setExcludeOptions( excludeList );
              _jspx_th_impact_validateSelect_11.setOnChange("unValidate();");
              _jspx_th_impact_validateSelect_11.setValue( FormattingHelper.formatString( txtSzCdFacilityCounty ));
              int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
              if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          <select name=\"hiddenAddressCounty\" style=\"display:none;\"></select>\r\n     </td>\r\n     <td colspan=\"2\">&nbsp;</td>\r\n   </tr>\r\n   <tr>\r\n     <td class=\"formLabel\" colspan=\"1\" valign=\"top\">Comments:</td>\r\n     <td colspan=3>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateTextArea_0.setName("txtszTxtRsrcAddrComments");
              _jspx_th_impact_validateTextArea_0.setCols("80");
              _jspx_th_impact_validateTextArea_0.setRows("3");
              _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_0.setDisabled(addressCommentsDisabled);
              _jspx_th_impact_validateTextArea_0.setMaxLength(80);
              _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph80");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.write("\r\n                    ");
                  out.print(txtszTxtRsrcAddrComments);
                  out.write("\r\n                   ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n   </tr>\r\n</table>\r\n  ");
              if (_jspx_meth_impact_validateInput_36(_jspx_th_impact_ExpandableSectionTag_1, _jspx_page_context))
                return;
              out.write("\r\n  ");
              if (_jspx_meth_impact_validateInput_37(_jspx_th_impact_ExpandableSectionTag_1, _jspx_page_context))
                return;
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n   <tr>\r\n     <td width=\"15%\">");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_12.setName("selCdRsrcAddrTypeB");
              _jspx_th_impact_validateSelect_12.setLabel("Type");
              _jspx_th_impact_validateSelect_12.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_12.setDisabled("true");
              _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_12.setCodesTable("CRSCADDR");
              _jspx_th_impact_validateSelect_12.setWidth("25%");
              _jspx_th_impact_validateSelect_12.setValue( txtSzCdRsrcAddrTypeB );
              int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
              if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n     <td width=\"15%\">&nbsp;</td>\r\n     <td>&nbsp;</td>\r\n   </tr>\r\n   <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_38.setType("text");
              _jspx_th_impact_validateInput_38.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_38.setName("txtNbrRsrcAddrVidB");
              _jspx_th_impact_validateInput_38.setLabel("Vendor ID");
              _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_38.setCssClass("formInput");
              _jspx_th_impact_validateInput_38.setValue(txtSzNbrRsrcAddrVidB);
              _jspx_th_impact_validateInput_38.setConstraint("VendorID");
              _jspx_th_impact_validateInput_38.setDisabled("true");
              _jspx_th_impact_validateInput_38.setMaxLength("8");
              _jspx_th_impact_validateInput_38.setSize("8");
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
              out.write("\r\n    </td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_39.setType("text");
              _jspx_th_impact_validateInput_39.setName("txtSzAddrRsrcAddrAttnB");
              _jspx_th_impact_validateInput_39.setLabel("Attention");
              _jspx_th_impact_validateInput_39.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_39.setCssClass("formInput");
              _jspx_th_impact_validateInput_39.setValue(txtSzAddrRsrcAddrAttnB);
              _jspx_th_impact_validateInput_39.setConstraint("Name");
              _jspx_th_impact_validateInput_39.setDisabled(attentionDisabledB);
              _jspx_th_impact_validateInput_39.setStyle("WIDTH: 120px");
              _jspx_th_impact_validateInput_39.setMaxLength("30");
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n   </tr>\r\n   <tr>\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_40.setType("text");
              _jspx_th_impact_validateInput_40.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_40.setName( address1Name2 );
              _jspx_th_impact_validateInput_40.setOnChange("javascript:unValidateB();");
              _jspx_th_impact_validateInput_40.setLabel("Address Ln 1");
              _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              _jspx_th_impact_validateInput_40.setDisabled(streetLn1DisabledB);
              _jspx_th_impact_validateInput_40.setConstraint("Address");
              _jspx_th_impact_validateInput_40.setValue(txtSzAddrRsrcAddrStLn1B);
              _jspx_th_impact_validateInput_40.setStyle("WIDTH: 150px");
              _jspx_th_impact_validateInput_40.setMaxLength("30");
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n   </tr>\r\n   <tr>\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_41.setType("text");
              _jspx_th_impact_validateInput_41.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_41.setName( address2Name2 );
              _jspx_th_impact_validateInput_41.setOnChange("javascript:unValidateB();");
              _jspx_th_impact_validateInput_41.setLabel("Address Ln 2");
              _jspx_th_impact_validateInput_41.setCssClass("formInput");
              _jspx_th_impact_validateInput_41.setDisabled(streetLn2DisabledB);
              _jspx_th_impact_validateInput_41.setValue(txtSzAddrRsrcAddrStLn2B);
              _jspx_th_impact_validateInput_41.setStyle("WIDTH: 150px");
              _jspx_th_impact_validateInput_41.setConstraint("Address");
              _jspx_th_impact_validateInput_41.setMaxLength("30");
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_42.setType("text");
              _jspx_th_impact_validateInput_42.setName( cityName2 );
              _jspx_th_impact_validateInput_42.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_42.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_42.setOnChange("javascript:unValidateB();");
              _jspx_th_impact_validateInput_42.setLabel("City");
              _jspx_th_impact_validateInput_42.setCssClass("formInput");
              _jspx_th_impact_validateInput_42.setDisabled(cityDisabledB);
              _jspx_th_impact_validateInput_42.setValue(txtSzAddrRsrcAddrCityB);
              _jspx_th_impact_validateInput_42.setConstraint("City");
              _jspx_th_impact_validateInput_42.setStyle("WIDTH: 150px");
              _jspx_th_impact_validateInput_42.setMaxLength("20");
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n   </tr>\r\n   <tr>\r\n   ");

    List<String> excludeListB = new ArrayList<String>();
    if(txtSzCdFacilityStateB != null && txtSzCdFacilityStateB.equals("GA"))
    {
        excludeListB.add("999");
    }
    
              out.write("\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_13.setName( stateName2 );
              _jspx_th_impact_validateSelect_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_13.setOnChange("javascript:unValidateB(); checkCountyForStateB();");
              _jspx_th_impact_validateSelect_13.setLabel("State");
              _jspx_th_impact_validateSelect_13.setCodesTable("CSTATE");
              _jspx_th_impact_validateSelect_13.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_13.setDisabled(stateDisabledB);
              _jspx_th_impact_validateSelect_13.setValue(txtSzCdFacilityStateB);
              int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
              if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n    ");
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_43.setType("text");
              _jspx_th_impact_validateInput_43.setName( zipName2 );
              _jspx_th_impact_validateInput_43.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_43.setOnChange("javascript:unValidateB();");
              _jspx_th_impact_validateInput_43.setLabel("Zip");
              _jspx_th_impact_validateInput_43.setCssClass("formInput");
              _jspx_th_impact_validateInput_43.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_43.setDisabled(zipDisabledB);
              _jspx_th_impact_validateInput_43.setValue(txtSzAddrRsrcAddrZipB);
              _jspx_th_impact_validateInput_43.setConstraint("Digit5");
              _jspx_th_impact_validateInput_43.setMaxLength("5");
              _jspx_th_impact_validateInput_43.setSize("5");
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        -\r\n      ");
              out.write("\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_44.setType("text");
              _jspx_th_impact_validateInput_44.setName( zipSuffName2 );
              _jspx_th_impact_validateInput_44.setOnChange("javascript:unValidateB();");
              _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setDisabled(zipDisabledB);
              _jspx_th_impact_validateInput_44.setValue(txtSzAddrRsrcAddrZipSuffB);
              _jspx_th_impact_validateInput_44.setConstraint("Digit4");
              _jspx_th_impact_validateInput_44.setMaxLength("4");
              _jspx_th_impact_validateInput_44.setSize("4");
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
if( !validateButtonHide ){
              out.write("\r\n        &nbsp;\r\n          ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_1.setName("btnValidateAddressRowB");
              _jspx_th_impact_ButtonTag_1.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_1.setFunction("openValidateWindowB(); return false;");
              _jspx_th_impact_ButtonTag_1.setForm("frmNewHomeInformation");
              _jspx_th_impact_ButtonTag_1.setAction("/fad/HomeInfrmtn/displayAddressDetail");
              _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
}
              out.write("\r\n    </td>\r\n   </tr>\r\n   <tr>\r\n     <td>\r\n     ");
              out.write("\r\n     ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_14.setName( countyName2 );
              _jspx_th_impact_validateSelect_14.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_14.setLabel("County");
              _jspx_th_impact_validateSelect_14.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_14.setDisabled(countyDisabled);
              _jspx_th_impact_validateSelect_14.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_14.setExcludeOptions( excludeListB );
              _jspx_th_impact_validateSelect_14.setOnChange("unValidateB();");
              _jspx_th_impact_validateSelect_14.setValue(txtSzCdFacilityCountyB);
              int _jspx_eval_impact_validateSelect_14 = _jspx_th_impact_validateSelect_14.doStartTag();
              if (_jspx_th_impact_validateSelect_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        <select name=\"hiddenAddressCountyB\" style=\"display:none;\"></select>\r\n      </td>\r\n     <td>&nbsp;</td>\r\n   </tr>\r\n   <tr>\r\n     <td class=\"formLabel\" colspan=\"1\" valign=\"top\">Comments:</td>\r\n     <td colspan=3>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateTextArea_1.setName("txtszTxtRsrcAddrCommentsB");
              _jspx_th_impact_validateTextArea_1.setCols("80");
              _jspx_th_impact_validateTextArea_1.setRows("3");
              _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_1.setDisabled(addressCommentsDisabledB);
              _jspx_th_impact_validateTextArea_1.setMaxLength(80);
              _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph80");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n        ");
                  out.print(txtszTxtRsrcAddrCommentsB);
                  out.write("\r\n       ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n   </tr>\r\n</table>\r\n  ");
              if (_jspx_meth_impact_validateInput_45(_jspx_th_impact_ExpandableSectionTag_1, _jspx_page_context))
                return;
              out.write("\r\n  ");
              if (_jspx_meth_impact_validateInput_46(_jspx_th_impact_ExpandableSectionTag_1, _jspx_page_context))
                return;
              out.write("\r\n</td></tr></table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("phone");
          _jspx_th_impact_ExpandableSectionTag_2.setId("txtLNbrFacilPhoneNumber_Id");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Phone");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_2.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tr><td class=\"subDetail\">\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr align=left valign=top>\r\n    <td class=\"subDetail\" width=\"14%\">");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_15.setLabel("Type");
              _jspx_th_impact_validateSelect_15.setName("selSzCdFacilPhoneType");
              _jspx_th_impact_validateSelect_15.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_15.setCodesTable("CRSCPHON");
              _jspx_th_impact_validateSelect_15.setDisabled("true");
              _jspx_th_impact_validateSelect_15.setValue("01");
              int _jspx_eval_impact_validateSelect_15 = _jspx_th_impact_validateSelect_15.doStartTag();
              if (_jspx_th_impact_validateSelect_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"subDetail\">");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_47.setType("text");
              _jspx_th_impact_validateInput_47.setLabel("Phone");
              _jspx_th_impact_validateInput_47.setConstraint("Phone");
              _jspx_th_impact_validateInput_47.setName("txtLNbrFacilPhoneNumber");
              _jspx_th_impact_validateInput_47.setDisabled(phoneNumberDisabled);
              _jspx_th_impact_validateInput_47.setCssClass("formInput");
              _jspx_th_impact_validateInput_47.setValue(szLNbrFacilPhoneNumber);
              _jspx_th_impact_validateInput_47.setSize("14");
              _jspx_th_impact_validateInput_47.setRequired("true");
              _jspx_th_impact_validateInput_47.setMaxLength("14");
              _jspx_th_impact_validateInput_47.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
              if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n  </tr>\r\n  <tr  align=\"left\" valign=\"top\">\r\n    <td class=\"subDetail\">");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_48.setType("text");
              _jspx_th_impact_validateInput_48.setLabel("&nbsp;&nbsp;Ext");
              _jspx_th_impact_validateInput_48.setName("txtLNbrFacilPhoneExtension");
              _jspx_th_impact_validateInput_48.setDisabled(phoneExtensionDisabled);
              _jspx_th_impact_validateInput_48.setCssClass("formInput");
              _jspx_th_impact_validateInput_48.setValue(szLNbrFacilPhoneExtension);
              _jspx_th_impact_validateInput_48.setConstraint("PhoneExtension");
              _jspx_th_impact_validateInput_48.setSize("8");
              _jspx_th_impact_validateInput_48.setMaxLength("8");
              _jspx_th_impact_validateInput_48.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
              if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formLabel\" class=\"subDetail\" valign=\"top\">Comments:</td>\r\n    <td  class=\"subDetail\" colspan=3>\r\n      ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_2.setCols("50");
              _jspx_th_impact_validateTextArea_2.setRows("4");
              _jspx_th_impact_validateTextArea_2.setName("txtszTxtRsrcPhoneComments");
              _jspx_th_impact_validateTextArea_2.setDisabled(phoneCommentsDisabled);
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_2.setMaxLength(80);
              _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph80");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n        ");
                  out.print(szSzTxtRsrcPhoneComments);
                  out.write("\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n</td></tr></table>\r\n");
/* END Phone Section */
              out.write("\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <BR>\r\n");
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
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_1.setName("dtDtInquiryDate");
              _jspx_th_impact_validateDate_1.setLabel("Inquiry Date");
              _jspx_th_impact_validateDate_1.setSize("10");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate( inquiryDate ));
              _jspx_th_impact_validateDate_1.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_1.setRequired("true");
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_16.setLabel("Inquiry Received By");
              _jspx_th_impact_validateSelect_16.setName("txtSzCdInqryRcvdBy");
              _jspx_th_impact_validateSelect_16.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_16.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_16.setRequired("true");
              _jspx_th_impact_validateSelect_16.setCodesTable("CINQRCBY");
              _jspx_th_impact_validateSelect_16.setValue( inqRecvdBy );
              int _jspx_eval_impact_validateSelect_16 = _jspx_th_impact_validateSelect_16.doStartTag();
              if (_jspx_th_impact_validateSelect_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_17.setLabel("Information Packet Requested");
              _jspx_th_impact_validateSelect_17.setName("selCdInfoPcktRqstd");
              _jspx_th_impact_validateSelect_17.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_17.setCodesTable("CINFPKRQ");
              _jspx_th_impact_validateSelect_17.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_17.setValue( infoPacktRequested );
              int _jspx_eval_impact_validateSelect_17 = _jspx_th_impact_validateSelect_17.doStartTag();
              if (_jspx_th_impact_validateSelect_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
              _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate( infPacktSent ) );
              _jspx_th_impact_validateDate_2.setDisabled( String.valueOf( bDisableAllFields ) );
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_49.setType("text");
              _jspx_th_impact_validateInput_49.setLabel("Requested Number Of Children");
              _jspx_th_impact_validateInput_49.setName("txtNbrRqstdNbrOfChldrn");
              _jspx_th_impact_validateInput_49.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateInput_49.setCssClass("formInput");
              _jspx_th_impact_validateInput_49.setValue("");
              _jspx_th_impact_validateInput_49.setConstraint("Numeric");
              _jspx_th_impact_validateInput_49.setSize("3");
              _jspx_th_impact_validateInput_49.setMaxLength("3");
              _jspx_th_impact_validateInput_49.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
              if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_50.setType("text");
              _jspx_th_impact_validateInput_50.setLabel("Child Specific Interest");
              _jspx_th_impact_validateInput_50.setName("txtSzChldSpcfcInterest");
              _jspx_th_impact_validateInput_50.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateInput_50.setCssClass("formInput");
              _jspx_th_impact_validateInput_50.setValue( childSpecInterest);
              _jspx_th_impact_validateInput_50.setConstraint("Paragraph30");
              _jspx_th_impact_validateInput_50.setSize("30");
              _jspx_th_impact_validateInput_50.setMaxLength("30");
              _jspx_th_impact_validateInput_50.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td >\r\n           ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_3.setName("txtInquiryComments");
              _jspx_th_impact_validateTextArea_3.setColspan("3");
              _jspx_th_impact_validateTextArea_3.setLabel("Inquiry Comments");
              _jspx_th_impact_validateTextArea_3.setRows("4");
              _jspx_th_impact_validateTextArea_3.setCols("70");
              _jspx_th_impact_validateTextArea_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_3.setDisabled( String.valueOf( bDisableAllFields ) );
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
                  out.write("\r\n            ");
                  out.print( inquiryComments );
                  out.write("\r\n          ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n<tr>\r\n<th colspan=\"8\">Sources Of Inquiry</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n");
   int srcsOfInqLoopCount = 0;
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
        
              out.write("\r\n  <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_51.setName( srcOfInqChkbxName );
              _jspx_th_impact_validateInput_51.setChecked( String.valueOf(isSrcOfInqChecked) );
              _jspx_th_impact_validateInput_51.setType("checkbox");
              _jspx_th_impact_validateInput_51.setValue( srcOfInqCode );
              _jspx_th_impact_validateInput_51.setCssClass("formInput");
              _jspx_th_impact_validateInput_51.setLabel( Lookup.simpleDecodeSafe(CodesTables.CFASRCIN, srcOfInqCode));
              _jspx_th_impact_validateInput_51.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n       ");
if (srcsOfInqLoopCount % 3 == 0)
   {
              out.write("\r\n     </tr><tr class=\"subDetail\">\r\n       ");
}

   } //end while
   if (srcsOfInqLoopCount % 3 == 1)
   { 
              out.write("\r\n      <td colspan=\"2\">&nbsp;</td>\r\n   ");

   }
   else if (srcsOfInqLoopCount % 3 == 2)
   { 
              out.write("\r\n      <td>&nbsp;</td>\r\n   ");

   } 
   
              out.write("\r\n</tr>\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n<tr>\r\n<th colspan=\"8\">Information Covered</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n");
   int infoCoveredLoopCount = 0;
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
    
              out.write("\r\n  <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_52.setName( infoCovrdChkbxName );
              _jspx_th_impact_validateInput_52.setChecked( String.valueOf(isInfoCovrdChecked) );
              _jspx_th_impact_validateInput_52.setType("checkbox");
              _jspx_th_impact_validateInput_52.setValue( infoCovrdCode );
              _jspx_th_impact_validateInput_52.setCssClass("formInput");
              _jspx_th_impact_validateInput_52.setLabel( Lookup.simpleDecodeSafe(CodesTables.CINFCVRD, infoCovrdCode));
              _jspx_th_impact_validateInput_52.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
              if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n       ");
if (infoCoveredLoopCount % 3 == 0)
   {
              out.write("\r\n     </tr><tr class=\"subDetail\">\r\n       ");
}

   } //end while
     if (infoCoveredLoopCount % 3 == 2)
  { 
              out.write("\r\n      <td colspan=\"2\">&nbsp;</td>\r\n      ");
}
              out.write("\r\n</tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <BR>\r\n      \r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName("homeInterest");
          _jspx_th_impact_ExpandableSectionTag_4.setId("selMaleMinYearInt_Id");
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("Home Interest");
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_4.setAnchor("anchorName");
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n<tr>\r\n<th colspan=\"6\" id=\"programsOfInterests\">Programs Of Interest</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n            ");
 int prgrmOfInterestLoopCount = 0;
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
              
              out.write("<td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_53.setName( chkbxName );
              _jspx_th_impact_validateInput_53.setChecked( String.valueOf(isPrgrmsOfInterestChecked) );
              _jspx_th_impact_validateInput_53.setType("checkbox");
              _jspx_th_impact_validateInput_53.setValue( prgrmOfInterestCode );
              _jspx_th_impact_validateInput_53.setCssClass("formInput");
              _jspx_th_impact_validateInput_53.setLabel( Lookup.simpleDecodeSafe(CodesTables.CPRGMINT, prgrmOfInterestCode));
              _jspx_th_impact_validateInput_53.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
              if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n               ");
if (prgrmOfInterestLoopCount % 3 == 0)
                 {
              out.write("\r\n                   </tr><tr class=\"subDetail\">\r\n               ");
}
                 
                 } //end while
             if (prgrmOfInterestLoopCount % 3 == 2)
                { 
              out.write("\r\n                  <td colspan=\"2\">&nbsp;</td>\r\n              ");
}
              out.write("  \r\n</tr>\r\n <tr class=\"subDetail\">\r\n    <td colspan=\"2\">\r\n       <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"0\">\r\n          <tr>\r\n             <td>\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_54.setType("text");
              _jspx_th_impact_validateInput_54.setLabel("Other");
              _jspx_th_impact_validateInput_54.setName("txtHmPrgInterest");
              _jspx_th_impact_validateInput_54.setDisabled( String.valueOf(bDisableAllFields) );
              _jspx_th_impact_validateInput_54.setValue( txtHmPrgInterest );
              _jspx_th_impact_validateInput_54.setConstraint("Paragraph80");
              _jspx_th_impact_validateInput_54.setSize("80");
              _jspx_th_impact_validateInput_54.setMaxLength("80");
              _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
              if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </td>\r\n           </tr>\r\n         </table>\r\n      </td>\r\n      <td colspan=\"2\"></td>\r\n  </tr>\r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n");

String maleMinYear = String.valueOf( maleMinInterestInMonths/12 );
String maleMaxYear = String.valueOf( maleMaxInterestInMonths/12 );

              out.write("\r\n<tr>\r\n<th colspan=\"8\">Male Age Range Interests</th>\r\n</tr>\r\n    <tr class=\"subDetail\">\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_18.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_18.setValue( maleMinYear );
              _jspx_th_impact_validateSelect_18.setName("selMaleMinYearInt");
              _jspx_th_impact_validateSelect_18.setLabel("Min Year");
              _jspx_th_impact_validateSelect_18.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_18.setBlankValue("false");
              _jspx_th_impact_validateSelect_18.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_18.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_18 = _jspx_th_impact_validateSelect_18.doStartTag();
              if (_jspx_th_impact_validateSelect_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_19.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_19.setValue( String.valueOf( maleMinInterestInMonths%12 ) );
              _jspx_th_impact_validateSelect_19.setName("selMaleMinMonthInt");
              _jspx_th_impact_validateSelect_19.setLabel("Min Month");
              _jspx_th_impact_validateSelect_19.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_19.setBlankValue("false");
              _jspx_th_impact_validateSelect_19.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_19.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_19 = _jspx_th_impact_validateSelect_19.doStartTag();
              if (_jspx_th_impact_validateSelect_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_20.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_20.setValue( maleMaxYear );
              _jspx_th_impact_validateSelect_20.setName("selMaleMaxYearInt");
              _jspx_th_impact_validateSelect_20.setLabel("Max Year");
              _jspx_th_impact_validateSelect_20.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_20.setBlankValue("false");
              _jspx_th_impact_validateSelect_20.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_20.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_20 = _jspx_th_impact_validateSelect_20.doStartTag();
              if (_jspx_th_impact_validateSelect_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_21.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_21.setValue( String.valueOf( maleMaxInterestInMonths%12 ) );
              _jspx_th_impact_validateSelect_21.setName("selMaleMaxMonthInt");
              _jspx_th_impact_validateSelect_21.setLabel("Max Month");
              _jspx_th_impact_validateSelect_21.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_21.setBlankValue("false");
              _jspx_th_impact_validateSelect_21.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_21.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_21 = _jspx_th_impact_validateSelect_21.doStartTag();
              if (_jspx_th_impact_validateSelect_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </Table>\r\n  <br>\r\n");

String femaleMinYear = String.valueOf( femaleMinInterestInMonths/12 );
String femaleMaxYear = String.valueOf( femaleMaxInterestInMonths/12 );

              out.write("\r\n\r\n  <table width=\"100%\" class =\"tableborder\" cellspacing=\"0\" cellpadding=\"3\">\r\n    <tr>\r\n      <th colspan=\"8\">Female Age Range Interests</th>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_22.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_22.setValue( femaleMinYear );
              _jspx_th_impact_validateSelect_22.setName("selFemaleMinYearInt");
              _jspx_th_impact_validateSelect_22.setLabel("Min Year");
              _jspx_th_impact_validateSelect_22.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_22.setBlankValue("false");
              _jspx_th_impact_validateSelect_22.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_22.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_22 = _jspx_th_impact_validateSelect_22.doStartTag();
              if (_jspx_th_impact_validateSelect_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_23.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_23.setValue( String.valueOf( femaleMinInterestInMonths%12 ) );
              _jspx_th_impact_validateSelect_23.setName("selFemaleMinMonthInt");
              _jspx_th_impact_validateSelect_23.setLabel("Min Month");
              _jspx_th_impact_validateSelect_23.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_23.setBlankValue("false");
              _jspx_th_impact_validateSelect_23.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_23.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_23 = _jspx_th_impact_validateSelect_23.doStartTag();
              if (_jspx_th_impact_validateSelect_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_24.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_24.setValue( femaleMaxYear );
              _jspx_th_impact_validateSelect_24.setName("selFemaleMaxYearInt");
              _jspx_th_impact_validateSelect_24.setLabel("Max Year");
              _jspx_th_impact_validateSelect_24.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_24.setBlankValue("false");
              _jspx_th_impact_validateSelect_24.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_24.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_24 = _jspx_th_impact_validateSelect_24.doStartTag();
              if (_jspx_th_impact_validateSelect_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_25.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_25.setValue( String.valueOf( femaleMaxInterestInMonths%12 ) );
              _jspx_th_impact_validateSelect_25.setName("selFemaleMaxMonthInt");
              _jspx_th_impact_validateSelect_25.setLabel("Max Month");
              _jspx_th_impact_validateSelect_25.setOptions( monthOptions );
              _jspx_th_impact_validateSelect_25.setBlankValue("false");
              _jspx_th_impact_validateSelect_25.setDisabled( String.valueOf( bDisableAllFields ) );
              _jspx_th_impact_validateSelect_25.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
              int _jspx_eval_impact_validateSelect_25 = _jspx_th_impact_validateSelect_25.doStartTag();
              if (_jspx_th_impact_validateSelect_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n          </table>\r\n\t<br>\r\n    <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n    <tr>\r\n           <th colspan=\"4\">\r\n             <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" >\r\n               <tr>\r\n                <th>Child Races </th>\r\n               </tr>\r\n             </table>\r\n           </th>\r\n     </tr>\r\n     <tr class=\"subDetail\">\r\n    ");

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
     
              out.write("\r\n     <td width=\"3%\">\r\n     ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_55.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_55.setValue( raceCode  );
              _jspx_th_impact_validateInput_55.setType("checkbox");
              _jspx_th_impact_validateInput_55.setChecked( String.valueOf( isRacesChecked ) );
              _jspx_th_impact_validateInput_55.setName( cbName );
              _jspx_th_impact_validateInput_55.setLabel( Lookup.simpleDecodeSafe( CodesTables.CADRACE, raceCode ));
              _jspx_th_impact_validateInput_55.setCssClass("formInput");
              _jspx_th_impact_validateInput_55.setWidth("38%");
              int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
              if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n     ");

       if ( raceLoopCount % 2 == 0 )
     {
     
              out.write("\r\n     </tr>\r\n     <tr class=\"subDetail\">\r\n     ");

     }
     raceLoopCount++;
     } //end while
     if ( raceLoopCount % 2 == 0 )
     {
     
              out.write("\r\n     <td>&nbsp;</td>\r\n     ");
}
              out.write("\r\n     </tr>\r\n    </table>\r\n\r\n    \r\n    <br>\r\n    <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n    <tr>\r\n           <th colspan=\"4\">\r\n             <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" >\r\n               <tr>\r\n                <th>Child Ethnicities </th>\r\n               </tr>\r\n             </table>\r\n           </th>\r\n     </tr>\r\n     <tr class=\"subDetail\">\r\n    ");

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
     
              out.write("\r\n     <td width=\"3%\">\r\n     ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_56.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_56.setValue( ethCode  );
              _jspx_th_impact_validateInput_56.setType("checkbox");
              _jspx_th_impact_validateInput_56.setChecked( String.valueOf( isEthnicitiesChecked ) );
              _jspx_th_impact_validateInput_56.setName( cbName );
              _jspx_th_impact_validateInput_56.setLabel( Lookup.simpleDecodeSafe( CodesTables.CINDETHN, ethCode ));
              _jspx_th_impact_validateInput_56.setCssClass("formInput");
              _jspx_th_impact_validateInput_56.setWidth("38%");
              int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
              if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n     ");

       if ( loopCount % 2 == 0 )
     {
     
              out.write("\r\n     </tr>\r\n     <tr class=\"subDetail\">\r\n     ");

     }
     loopCount++;
     } //end while
     if ( loopCount % 2 == 0 )
     {
     
              out.write("\r\n     <td>&nbsp;</td>\r\n     ");
}
              out.write("\r\n     </tr>\r\n    </table>\r\n    <br>\r\n          <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n           <tr>\r\n\t\t   <th colspan=\"2\" id=\"childCharacteristics\">Child Characteristics</th>\r\n\t\t        <td align=\"right\">\r\n     <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:expandAllCategories()\">Expand All</a>&nbsp;\r\n     <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:collapseAllCategories()\">Collapse All</a>&nbsp;\r\n     </td>\r\n\t\t   </tr>\r\n\t\t   </table>\r\n\t\t  \r\n\t\t  \r\n          ");

// STGAP00017231: Looping through categories to display Expandable Sections 

		  List<CodeAttributes> characteristicsCategories = Lookup.getCategoryCollection(CodesTables.CCHRTCA2);
		Iterator characteristicsCategoryIterator = characteristicsCategories.iterator();

        while(characteristicsCategoryIterator.hasNext()){
        	CodeAttributes charCatCodeAtt = (CodeAttributes)characteristicsCategoryIterator.next();
            String catCode = charCatCodeAtt.getCode();
			String cbxName = "CharCbx" + catCode;
            String catDecode = charCatCodeAtt.getDecode();
			int catCodeSize =  Lookup.getCategoryCollection(catCode).size();


			
			
        
              out.write("\r\n        \t\t");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_ExpandableSectionTag_5.setName( catCode );
              _jspx_th_impact_ExpandableSectionTag_5.setId("");
              _jspx_th_impact_ExpandableSectionTag_5.setLabel( catDecode );
              _jspx_th_impact_ExpandableSectionTag_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n\t\t");
  

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
                  out.write("\" onClick=\"hrefDirtyBypass=true;\">Deselect All Child Characteristics</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t  <td colspan=\"2\" class=\"subDetail\">\r\n          ");
                  //  impact:codesCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                  _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
                  _jspx_th_impact_codesCheckbox_0.setName( cbxName );
                  _jspx_th_impact_codesCheckbox_0.setCodesTableName( catCode );
                  _jspx_th_impact_codesCheckbox_0.setColumns(3);
                  _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
                  _jspx_th_impact_codesCheckbox_0.setOrderBy("decode");
                  _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
                  int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
                  if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        </td>         \r\n           </tr>\r\n          </table>\r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t");

		}
		
              out.write("\r\n    <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n       <tr class=\"subDetail\">\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_57.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_57.setValue("test");
              _jspx_th_impact_validateInput_57.setType("checkbox");
              _jspx_th_impact_validateInput_57.setChecked( String.valueOf( willTransport ) );
              _jspx_th_impact_validateInput_57.setName("ckWillTransport");
              _jspx_th_impact_validateInput_57.setLabel("Will Transport Child[ren]");
              _jspx_th_impact_validateInput_57.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
              if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n       <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_58.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_58.setValue("test");
              _jspx_th_impact_validateInput_58.setType("checkbox");
              _jspx_th_impact_validateInput_58.setChecked( String.valueOf( emergencyPlacements ) );
              _jspx_th_impact_validateInput_58.setName("ckEmergPlacement");
              _jspx_th_impact_validateInput_58.setLabel("Emergency Placements");
              _jspx_th_impact_validateInput_58.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
              if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n       </tr><tr class=\"subDetail\">\r\n       <td>\r\n       ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateTextArea_4.setName("txtComments");
              _jspx_th_impact_validateTextArea_4.setColspan("3");
              _jspx_th_impact_validateTextArea_4.setLabel("Home Interest Comments");
              _jspx_th_impact_validateTextArea_4.setRows("4");
              _jspx_th_impact_validateTextArea_4.setCols("70");
              _jspx_th_impact_validateTextArea_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_4.setMaxLength(300);
              _jspx_th_impact_validateTextArea_4.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n        ");
                  out.print( homeInterestComments );
                  out.write("\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n<br>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"><tr><td>\r\n");
     if ( !bHideSaveButton )
    {
          out.write("\r\n\r\n        <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setForm("frmNewHomeInformation");
          _jspx_th_impact_ButtonTag_2.setFunction("return saveWithValidate();");
          _jspx_th_impact_ButtonTag_2.setAction("/fad/HomeInfrmtn/saveAssignHomeInformation");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      ");
}
          out.write("\r\n    </table>\r\n      <script>addQuestionMark();</script>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<br>");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("timestamp");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_2.setName("hdnBSysIndPrfrmNameCheck");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_4.setName("hdnSaveOrValidate");
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
    _jspx_th_impact_validateInput_5.setName("hdnSaveOrValidateB");
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
    _jspx_th_impact_validateInput_6.setName("frmWindowName");
    _jspx_th_impact_validateInput_6.setValue("frmNewHomeInformation");
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
    _jspx_th_impact_validateInput_7.setName("validationOverride");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_11.setName("prsChange");
    _jspx_th_impact_validateInput_11.setValue("");
    int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
    if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_36(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
    _jspx_th_impact_validateInput_36.setType("hidden");
    _jspx_th_impact_validateInput_36.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_36.setValue("0");
    int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
    if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_37(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
    _jspx_th_impact_validateInput_37.setType("hidden");
    _jspx_th_impact_validateInput_37.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_37.setValue("0");
    int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
    if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_45(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
    _jspx_th_impact_validateInput_45.setType("hidden");
    _jspx_th_impact_validateInput_45.setName("hdnNbrRsrcAddrLatB");
    _jspx_th_impact_validateInput_45.setValue("0");
    int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
    if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_46(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
    _jspx_th_impact_validateInput_46.setType("hidden");
    _jspx_th_impact_validateInput_46.setName("hdnNbrRsrcAddrLongB");
    _jspx_th_impact_validateInput_46.setValue("0");
    int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
    if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
