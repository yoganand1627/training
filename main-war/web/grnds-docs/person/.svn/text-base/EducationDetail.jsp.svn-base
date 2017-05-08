<%
//*  JSP Name:     Education Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 11/14/2002
//*
//*  Description:
//*  This JSP is used to maintain a Person's Education information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  04/30/03  GRIMSHAN          SIR 17010 Added a javascript function so that when
//**                              the user has selected out of state, a message will
//**                              be displayed and the system will not navigate to
//**                              resource search
//**  05/07/03  GRIMSHAN          SIR 17285 Added a javascript function so that when
//**                              a user flips from out of state to in state radio buttons
//**                              the page will be submitted to a re-display function
//**                              This re-display function will enable/disable the appropriate
//**                              fields by using the instate/out of state indicator from
//**                              the radio button as put into rowccfc17sog00.  The inState
//**                              boolean was set as a disabled attribute for the School
//**                              name field, as well as the entire address/phone sub.
//**                              Also changed the In-State, Out of State radio buttons,
//**                              and the select resource pushbutton so that they are only
//**                              modifiable in New mode, since caps does not allow changes
//**                              to these fields on update.
//**  08/26/03  A.Corley          SIR 19537 call cancel validation when deleting  
//**  11/01/07  VVO               STGAP00005624 - Allow user to change education type of an existing 
//**                              education record and set page fields' visibility corresponding to the new  
//**                              type selected
//**                              - In that case, pop warning message stating that Education Information data
//**                              (radio btn and school/day care name will be cleared) and clear them if user 
//**                              agrees to
//**                              - Shows Select Resource btn only when type is School (In State), Head Start 
//**                              or Day Care
//** 06/16/2008 MC		          //STGAP00009116: fields moved from form to page
//**                              

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%
//Get the output object from the request
ROWCCFC17SOG00 rowccfc17sog00 = (ROWCCFC17SOG00) request.getAttribute("ROWCCFC17SOG00");
CRES03SO cres03so = (CRES03SO) request.getAttribute("cres03so");
List checkedValues = (List) request.getAttribute("checkedValues");
String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
ROWCRES03SOG00_ARRAY addressArray = null;
ROWCRES03SOG01_ARRAY phoneArray = null;

if (rowccfc17sog00 == null)
{
  rowccfc17sog00 = new ROWCCFC17SOG00();
}

boolean bInState = false;
boolean bOutofState = false;
boolean bLicensed = false;
boolean bUnlicensed = false;
//String btnSelectResourceVisibility = "block"; 



//Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

String schoolName = "";
String districtName = "";
AdminAddressPhoneBean addressPhoneBean = new AdminAddressPhoneBean();
String addressType = "";
String phoneType = "";
//SIR 18963 -- A variable for the Resource ID
int resourceId = 0;
String educationType = "";
String comments = "";
String cIndLicense = "";

// Initialize a variable to determine if the user has selected a
// Resource, or if the current record has already been saved.
boolean isResource = false;
// select resource performed
if (cres03so != null)
{
  //Pullback is cres03so
  isResource = true;
  schoolName = cres03so.getSzNmResource();
  resourceId = cres03so.getUlIdResource();
  districtName = cres03so.getSzTxtSchDistName();
  educationType = cres03so.getSzCdEdhistType();
  comments = cres03so.getSzEdHistComments();
  cIndLicense = cres03so.getSzIndEdhistLicense();
  addressArray = cres03so.getROWCRES03SOG00_ARRAY();
  ROWCRES03SOG00 addressRow = null;
  phoneArray = cres03so.getROWCRES03SOG01_ARRAY();
  ROWCRES03SOG01 phoneRow = null;
  boolean isPrimary = false;
  if (addressArray != null)
  {
   isPrimary = false;
    Enumeration addressEnumeration = addressArray.enumerateROWCRES03SOG00();
    while ( addressEnumeration.hasMoreElements() && !isPrimary )
    {
      addressRow = (ROWCRES03SOG00) addressEnumeration.nextElement();
      addressType = FormattingHelper.formatString(addressRow.getSzCdRsrcAddrType()) ;
      if ((addressType != null && !"".equals(addressType)) && "01".equals(addressType))
      {
        addressPhoneBean.setAddress1( addressRow.getSzAddrRsrcAddrStLn1() );
        addressPhoneBean.setAddress2( addressRow.getSzAddrRsrcAddrStLn2() );
        addressPhoneBean.setZipAndSuff( addressRow.getSzAddrRsrcAddrZip() );
        addressPhoneBean.setCity( addressRow.getSzAddrRsrcAddrCity() );
        addressPhoneBean.setState( addressRow.getSzCdFacilityState() );
        addressPhoneBean.setCounty( addressRow.getSzCdFacilityCounty() );
        addressPhoneBean.setComments( addressRow.getSzTxtRsrcAddrComments() );

        isPrimary = true;
      }
    }
  }
  if (phoneArray != null)
  {
    isPrimary = false;
    Enumeration phoneEnumeration = phoneArray.enumerateROWCRES03SOG01();
    while (phoneEnumeration != null && phoneEnumeration.hasMoreElements() && !isPrimary)
    {
      phoneRow = (ROWCRES03SOG01) phoneEnumeration.nextElement();
      phoneType = FormattingHelper.formatString(phoneRow.getSzCdFacilPhoneType());
      if (( phoneType != null && !"".equals(phoneType) ) && "01".equals(phoneType))
      {
        addressPhoneBean.setPhone( phoneRow.getLNbrFacilPhoneNumber() );
        addressPhoneBean.setPhoneExt( phoneRow.getLNbrFacilPhoneExtension() );
        isPrimary = true;
      }
    }
  }

} // End if cres03 is not null
// existing record pulled
else if (rowccfc17sog00 != null) //populate from rowccfc17sog00
{ // STGAP00005624 - added condition idResource > 0 since we allow Edu Type changed for existing record
  if (rowccfc17sog00.getSzNmEdhistSchool() != null  && rowccfc17sog00.getUlIdResource() > 0)
  {
     isResource = true;

  }
  schoolName = rowccfc17sog00.getSzNmEdhistSchool();
  resourceId = rowccfc17sog00.getUlIdResource();
  districtName = rowccfc17sog00.getSzNmEdhistSchDist();
  educationType = rowccfc17sog00.getSzCdEdhistType();
  cIndLicense = rowccfc17sog00.getSzIndEdhistLicense();
  comments = rowccfc17sog00.getSzEdHistComments();
  addressPhoneBean.setAddress1( rowccfc17sog00.getSzAddrEdhistStreetLn1() );
  addressPhoneBean.setAddress2( rowccfc17sog00.getSzAddrEdhistStreetLn2() );
  addressPhoneBean.setZipAndSuff( rowccfc17sog00.getSzAddrEdhistZip() );
  addressPhoneBean.setCity( rowccfc17sog00.getSzAddrEdhistCity() );
  addressPhoneBean.setState( rowccfc17sog00.getSzAddrEdhistState() );
  addressPhoneBean.setCounty( rowccfc17sog00.getSzAddrEdhistCnty() );
  addressPhoneBean.setComments( rowccfc17sog00.getSzTxtEdhistAddrCmnt() );
  addressPhoneBean.setPhone( rowccfc17sog00.getSzNbrEdhistPhone() );
  addressPhoneBean.setPhoneExt( rowccfc17sog00.getSzNbrEdhistPhoneExt() );

}

addressPhoneBean.addToRequest( request );
String pageModePassed = "";
String overallPageMode = PageModeConstants.EDIT;

if (request.getAttribute("pageMode") != null )
{
  pageModePassed = (String) request.getAttribute("pageMode");
  if (pageModePassed.equals(PageModeConstants.MODIFY))
  {
    overallPageMode = PageModeConstants.EDIT;
  }
  else if (pageModePassed.equals(PageModeConstants.NEW))
  {
    overallPageMode = PageModeConstants.NEW;
  }
  else if (pageModePassed.equals(PageModeConstants.VIEW))
  {
    overallPageMode = PageModeConstants.VIEW;
  }
  }

  //boolean bInState = false;
  //boolean bOutofState = false;
  //boolean bLicensed = false;
  //boolean bUnlicensed = false;
  
String IsIndSchoolRecs = "";
String IsIndRecsToBCounty = "";
String IsIndSchoolChange = "";
String IsIndSpecialEdNeeds = "";
String IsIndSpecialEdSvc = "";
String IsIndFosterParent = "";
String IsIndOther = "";
String IsIndLegalParent = "";
String IsIndChildServices = "";
String IsIndPrevChildSvc = "";
String SchoolrecordsOnFile_Yes = "false";
String  SchoolrecordsOnFile_No = "false";
String  SchoolrecordsOnFile_NA = "false";
String RecordsboardingCounty_Yes = "false";
String RecordsboardingCounty_No = "false";
String RecordsboardingCounty_NA = "false";
String SchoolChanged_Yes = "false";
String SchoolChanged_No = "false";
String SchoolChanged_NA = "false";
String  ChildEducationalNeeds_Yes = "false";
String  ChildEducationalNeeds_No = "false";
String ChildEducationalNeeds_NA = "false";
String SpecialEduServices_Yes = "false";
String SpecialEduServices_No = "false";
String SpecialEduServices_NA = "false";
String FosterParent_Yes = "false";
String Other_Yes = "false";
String LegalParent_Yes = "false";
String LegalParent_No = "false";
String InterventionServices_Yes = "false";
String InterventionServices_No = "false";
String PrevInterventionServices_Yes = "false";
String PrevInterventionServices_No = "false";
String rbCIndEdhistLevel_Yes = "false";
String rbCIndEdhistLevel_No = "false";
String isIndLevel = "";

if(FormattingHelper.formatString(rowccfc17sog00.getRbSchoolRecs()) != null)
{
IsIndSchoolRecs = FormattingHelper.formatString(rowccfc17sog00.getRbSchoolRecs());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbRecsToBCounty()) != null)
{
IsIndRecsToBCounty = FormattingHelper.formatString(rowccfc17sog00.getRbRecsToBCounty());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbSchoolChange()) != null)
{
IsIndSchoolChange = FormattingHelper.formatString(rowccfc17sog00.getRbSchoolChange());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbSpecialEdNeeds()) != null)
{
IsIndSpecialEdNeeds = FormattingHelper.formatString(rowccfc17sog00.getRbSpecialEdNeeds());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbSpecialEdSvc()) != null)
{
IsIndSpecialEdSvc = FormattingHelper.formatString(rowccfc17sog00.getRbSpecialEdSvc());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbIndFosterParent()) != null)
{
IsIndFosterParent = FormattingHelper.formatString(rowccfc17sog00.getRbIndFosterParent());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbLegalParent()) != null)
{
IsIndLegalParent = FormattingHelper.formatString(rowccfc17sog00.getRbLegalParent());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbChildServices()) != null)
{
IsIndChildServices = FormattingHelper.formatString(rowccfc17sog00.getRbChildServices());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbPrevChildSvc()) != null)
{
IsIndPrevChildSvc = FormattingHelper.formatString(rowccfc17sog00.getRbPrevChildSvc());
}
if(FormattingHelper.formatString(rowccfc17sog00.getRbCIndEdhistLevel()) != null)
{
isIndLevel = FormattingHelper.formatString(rowccfc17sog00.getRbCIndEdhistLevel());
}


  
  if(IsIndSchoolRecs == null)
     {
        IsIndSchoolRecs = "";
      }
      if (IsIndSchoolRecs.equals(ArchitectureConstants.Y)) {
        SchoolrecordsOnFile_Yes = "true";
        SchoolrecordsOnFile_No = "false";
        SchoolrecordsOnFile_NA = "false";
      } else if (IsIndSchoolRecs.equals(ArchitectureConstants.N)) {
        SchoolrecordsOnFile_Yes = "false";
        SchoolrecordsOnFile_No = "true";
        SchoolrecordsOnFile_NA = "false";
      } else if (IsIndSchoolRecs.equals("A")) {
        SchoolrecordsOnFile_Yes = "false";
        SchoolrecordsOnFile_No = "false";
        SchoolrecordsOnFile_NA = "true";
        
      }
      if(IsIndRecsToBCounty == null)
     {
        IsIndRecsToBCounty = "";
      }
      if (IsIndRecsToBCounty.equals(ArchitectureConstants.Y)) {
        RecordsboardingCounty_Yes = "true";
        RecordsboardingCounty_No = "false";
        RecordsboardingCounty_NA = "false";
      } else if (IsIndRecsToBCounty.equals(ArchitectureConstants.N)) {
        RecordsboardingCounty_Yes = "false";
        RecordsboardingCounty_No = "true";
        RecordsboardingCounty_NA = "false";
      } else if (IsIndRecsToBCounty.equals("A")) {
        RecordsboardingCounty_Yes = "false";
        RecordsboardingCounty_No = "false";
        RecordsboardingCounty_NA = "true";
        
      }
    if(IsIndSchoolChange == null)
     {
        IsIndSchoolChange = "";
      }
      if (IsIndSchoolChange.equals(ArchitectureConstants.Y)) {
        SchoolChanged_Yes = "true";
        SchoolChanged_No = "false";
        SchoolChanged_NA = "false";
      } else if (IsIndSchoolChange.equals(ArchitectureConstants.N)) {
        SchoolChanged_Yes = "false";
        SchoolChanged_No = "true";
        SchoolChanged_NA = "false";
      } else if (IsIndSchoolChange.equals("A")) {
        SchoolChanged_Yes = "false";
        SchoolChanged_No = "false";
        SchoolChanged_NA = "true";
        
      }
      
      if(IsIndSpecialEdNeeds == null)
     {
        IsIndSpecialEdNeeds = "";
      }
      if (IsIndSpecialEdNeeds.equals(ArchitectureConstants.Y)) {
        ChildEducationalNeeds_Yes = "true";
        ChildEducationalNeeds_No = "false";
        ChildEducationalNeeds_NA = "false";
      } else if (IsIndSpecialEdNeeds.equals(ArchitectureConstants.N)) {
        ChildEducationalNeeds_Yes = "false";
        ChildEducationalNeeds_No = "true";
        ChildEducationalNeeds_NA = "false";
      } else if (IsIndSpecialEdNeeds.equals("A")) {
        ChildEducationalNeeds_Yes = "false";
        ChildEducationalNeeds_No = "false";
        ChildEducationalNeeds_NA = "true";
        
      }
        if(IsIndSpecialEdSvc == null)
     {
        IsIndSpecialEdSvc = "";
      }
      if (IsIndSpecialEdSvc.equals(ArchitectureConstants.Y)) {
        SpecialEduServices_Yes = "true";
        SpecialEduServices_No = "false";
        SpecialEduServices_NA = "false";
      } else if (IsIndSpecialEdSvc.equals(ArchitectureConstants.N)) {
        SpecialEduServices_Yes = "false";
        SpecialEduServices_No = "true";
        SpecialEduServices_NA = "false";
      } else if (IsIndSpecialEdSvc.equals("A")) {
        SpecialEduServices_Yes = "false";
        SpecialEduServices_No = "false";
        SpecialEduServices_NA = "true";
        
      }
      if(IsIndFosterParent == null)
     {
        IsIndFosterParent = "";
      }
      if (IsIndFosterParent.equals(ArchitectureConstants.Y)) {
        FosterParent_Yes = "true";
        Other_Yes = "false";        
      } else if (IsIndFosterParent.equals(ArchitectureConstants.N)) {
        FosterParent_Yes = "false";
       Other_Yes="true";
      } 
       if(IsIndLegalParent == null)
     {
        IsIndLegalParent = "";
      }
      if (IsIndLegalParent.equals(ArchitectureConstants.Y)) {
        LegalParent_Yes = "true";
        LegalParent_No = "false";
        
      } else if (IsIndLegalParent.equals(ArchitectureConstants.N)) {
        LegalParent_Yes = "false";
        LegalParent_No = "true";
       
      } 
      
        if(IsIndChildServices == null)
     {
        IsIndChildServices = "";
      }
      if (IsIndChildServices.equals(ArchitectureConstants.Y)) {
        InterventionServices_Yes = "true";
        InterventionServices_No = "false";
        
      } else if (IsIndChildServices.equals(ArchitectureConstants.N)) {
        InterventionServices_Yes = "false";
        InterventionServices_No = "true";
       
      } 
         if(IsIndPrevChildSvc == null)
     {
        IsIndPrevChildSvc = "";
      }
      if (IsIndPrevChildSvc.equals(ArchitectureConstants.Y)) {
        PrevInterventionServices_Yes = "true";
        PrevInterventionServices_No = "false";
        
      } else if (IsIndPrevChildSvc.equals(ArchitectureConstants.N)) {
        PrevInterventionServices_Yes = "false";
        PrevInterventionServices_No = "true";
       
      } 
        if(isIndLevel == null)
     {
        isIndLevel = "";
      }
      if (isIndLevel.equals("A")) {
        rbCIndEdhistLevel_Yes = "true";
        rbCIndEdhistLevel_No = "false";
        
      } else if (isIndLevel.equals("B")) {
        rbCIndEdhistLevel_Yes = "false";
        rbCIndEdhistLevel_No = "true";
       
      } 
  
  if ("I".equals(FormattingHelper.formatString(rowccfc17sog00.getCIndEdhistTeaSchool())) 
      && "SCH".equals(FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistType())) )
  {
    bInState = true;
    bOutofState = false;
  }
  else if ("O".equals(FormattingHelper.formatString(rowccfc17sog00.getCIndEdhistTeaSchool()))
            && "SCH".equals(FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistType())))
  {
    bInState = false;
    bOutofState = true;
  }
  if ("L".equals(FormattingHelper.formatString(cIndLicense))) 
  {
    bLicensed = true;
    bUnlicensed = false;
  } 
  else if ("U".equals(FormattingHelper.formatString(cIndLicense))) 
  {
    bLicensed = false;
    bUnlicensed = true;
  }
%>


<% // Start Javascript Section
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

window.attachEvent('onload', updateType);

function cancelValidation()
{
  disableValidation("frmEduDetail");
  return true;
}

function deleteRow()
{
  var bRow = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>');
  return bRow;
}

// SIR 17010 GRIMSHAN -- Added this javascript function so that if the second radio button
// (out of state) has been selected, a message will be displayed and the page will not
// go any where when select resource is clicked.
function isInState()
{
  var rbCIndEdhistTeaSchool_OutState = document.getElementById("rbCIndEdhistTeaSchool_Id2");
  if(frmEduDetail.szCdEdhistType.options.value == "NIS")
  {
  return false;
  }
  if (rbCIndEdhistTeaSchool_OutState.checked)
  {
   //alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_OUT_NO_RES ) %>');
   disableBtnSelectResource();
   return false;
  }
  else
  {
    return true;
  }
}
  /*
   * 
   */
function updateType()
{ 
  if(frmEduDetail.szCdEdhistType.options.value == "SCH")
  { 
   enableEduInfo_TeaSchool();
   disableEduInfo_License(); 
   // retain btn visibility when coming back from (failing) custom validation (user just switched to In State, not saved to db yet)
   var rbCIndEdhistTeaSchool_OutState = document.getElementById("rbCIndEdhistTeaSchool_Id2");
   var rbCIndEdhistTeaSchool_InState = document.getElementById("rbCIndEdhistTeaSchool_Id1");
   if (rbCIndEdhistTeaSchool_OutState.checked) {
     disableBtnSelectResource();
     enableEduInfo_SchoolName();
   } else {
     enableBtnSelectResource();
   }
   if (rbCIndEdhistTeaSchool_InState.checked) { 
     disableEduInfo_SchoolName();
   }
  }
  else if(frmEduDetail.szCdEdhistType.options.value == "DCR")
  {
   disableEduInfo_TeaSchool();
   enableEduInfo_License();
   enableEduInfo_SchoolName();
   enableBtnSelectResource();
   
  }
  else if(frmEduDetail.szCdEdhistType.options.value == "NIS")
  {
   disableEduInfo();
   disableBtnSelectResource();
   frmEduDetail.txtDtDtEdhistEnrollDate.disabled = true; 
   frmEduDetail.selSzCdEdhistEnrollGrade.disabled = true; 
   frmEduDetail.rbCIndEdhistLevel[0].disabled = true; 
   frmEduDetail.rbCIndEdhistLevel[1].disabled = true; 
   frmEduDetail.selSzCEdhistAttendance.disabled = true; 
   frmEduDetail.selSzCEdhistCurrentGradeLevel.disabled = true; 
   frmEduDetail.txtDtDtEdhistWithdrawnDate.disabled = true; 
   frmEduDetail.selSzCdEdhistWithdrawnGrade.disabled = true; 
   }
  else if (frmEduDetail.szCdEdhistType.options.value == "HMS" || frmEduDetail.szCdEdhistType.options.value == "HST") // Head Start or Home School 
  {
   disableEduInfo_TeaSchool();
   disableEduInfo_License();
   enableEduInfo_SchoolName();
   if (frmEduDetail.szCdEdhistType.options.value != "HST") { // Do not hide Select Resource btn if Head Start
     disableBtnSelectResource();
   }
  }
  }
  /*
   * 
   */
  function disableBtnSelectResource() {
    var btnSelectResource_Btn = document.getElementById("BTN_SELECT_RESOURCE");
    var txtSzNmEdhistSchool_Name = document.getElementById("txtSzNmEdhistSchool_display_Id");
    if (btnSelectResource_Btn.style.display == 'block') {
      toggleVisibility('BTN_SELECT_RESOURCE', 'none');
    }
    // set boolean to false to indicate current selection is not a resource-typed one but do not clear idResource
    // until user finalize selection with a Save
    //document.frmEduDetail.hdnResourceID.value = '0'; // not a missing code - do not uncomment
    document.frmEduDetail.hdnIsResource.value = 'false';
  }
  /*
   * 
   */ 
  function enableBtnSelectResource() {
    var btnSelectResource_Btn = document.getElementById("BTN_SELECT_RESOURCE");
    if (btnSelectResource_Btn.style.display == 'none') {
      toggleVisibility('BTN_SELECT_RESOURCE', 'block');
    }
  }
  /*
   * 
   */ 
  function disableEduInfo_SchoolName() {
    var txtSzNmEdhistSchool_Name = document.getElementById("txtSzNmEdhistSchool_display_Id");
    if (txtSzNmEdhistSchool_Name.disabled == false) {
      txtSzNmEdhistSchool_Name.disabled = true;
    }
  }
  /*
   * 
   */ 
  function enableEduInfo_SchoolName() {
    var txtSzNmEdhistSchool_Name = document.getElementById("txtSzNmEdhistSchool_display_Id");
    if (txtSzNmEdhistSchool_Name.disabled == true) {
      txtSzNmEdhistSchool_Name.disabled = false;
    }
  }
  /*
   * 
   */ 
  function disableEduInfo_TeaSchool() {
    var rbCIndEdhistTeaSchool_InState = document.getElementById("rbCIndEdhistTeaSchool_Id1");
    var rbCIndEdhistTeaSchool_OutState = document.getElementById("rbCIndEdhistTeaSchool_Id2");
    
    if (rbCIndEdhistTeaSchool_InState.disabled == false) {
      rbCIndEdhistTeaSchool_InState.disabled = true;
    }
    if (rbCIndEdhistTeaSchool_OutState.disabled == false) {
      rbCIndEdhistTeaSchool_OutState.disabled = true;
    } 
  }
  /*
   * 
   */ 
  function disableEduInfo_License() {
    var szIndEdhistLicense_Licensed = document.getElementById("szIndEdhistLicense_Id3");
    var szIndEdhistLicense_UnLicensed = document.getElementById("szIndEdhistLicense_Id4");
    
    if (szIndEdhistLicense_Licensed.disabled == false) {
      szIndEdhistLicense_Licensed.disabled = true;
    }
    if (szIndEdhistLicense_UnLicensed.disabled == false) {
      szIndEdhistLicense_UnLicensed.disabled = true;
    }
  }
  /*
   * 
   */
  function disableEduInfo() {
    disableEduInfo_TeaSchool();
    disableEduInfo_License();
    disableEduInfo_SchoolName();
  }
  /*
   * 
   */ 
  function enableEduInfo_TeaSchool() {
    var rbCIndEdhistTeaSchool_InState = document.getElementById("rbCIndEdhistTeaSchool_Id1");
    var rbCIndEdhistTeaSchool_OutState = document.getElementById("rbCIndEdhistTeaSchool_Id2");
    if (rbCIndEdhistTeaSchool_InState.disabled == true) {
      rbCIndEdhistTeaSchool_InState.disabled = false;
    }
    if (rbCIndEdhistTeaSchool_OutState.disabled == true) {
      rbCIndEdhistTeaSchool_OutState.disabled = false;
    }
  }
  /*
   * 
   */ 
  function enableEduInfo_License() {
    var szIndEdhistLicense_Licensed = document.getElementById("szIndEdhistLicense_Id3");
    var szIndEdhistLicense_UnLicensed = document.getElementById("szIndEdhistLicense_Id4");
    
    if (szIndEdhistLicense_Licensed.disabled == true) {
      szIndEdhistLicense_Licensed.disabled = false;
    }
    if (szIndEdhistLicense_UnLicensed.disabled == true) {
      szIndEdhistLicense_UnLicensed.disabled = false;
    }
  }
  /*
   * 
   */ 
  function enableEduInfo() {
    enableEduInfo_TeaSchool();
    enableEduInfo_License();
    enableEduInfo_SchoolName();
  }
  /*
   * Called to clear old data when user changes Education Type of an existing record
   */ 
  function clearRbEduInfo() { 
    var rbCIndEdhistTeaSchool_InState = document.getElementById("rbCIndEdhistTeaSchool_Id1");
    var rbCIndEdhistTeaSchool_OutState = document.getElementById("rbCIndEdhistTeaSchool_Id2");
    var szIndEdhistLicense_Licensed = document.getElementById("szIndEdhistLicense_Id3");
    var szIndEdhistLicense_UnLicensed = document.getElementById("szIndEdhistLicense_Id4");
    var txtSzNmEdhistSchool_Name = document.getElementById("txtSzNmEdhistSchool_display_Id");

    if (rbCIndEdhistTeaSchool_InState.checked == true) {
      rbCIndEdhistTeaSchool_InState.checked = false; 
      enableEduInfo_SchoolName;
    } else if (rbCIndEdhistTeaSchool_OutState.checked == true) {
      rbCIndEdhistTeaSchool_OutState.checked = false;
    }
    if (szIndEdhistLicense_Licensed.checked == true) {
      szIndEdhistLicense_Licensed.checked = false;
    } else if (szIndEdhistLicense_UnLicensed.checked == true) {
      szIndEdhistLicense_UnLicensed.checked = false;
    }
    if (txtSzNmEdhistSchool_Name.value != "") { 
      txtSzNmEdhistSchool_Name.value = "";
      // set boolean to indicatte it is not resource-typed education any more (it was resource-typed education before)
      // if it was not resource-typed edu to start with, still okay since it should never be true then
      document.frmEduDetail.hdnIsResource.value = 'false'; 
      // School Name could be disabled on page load when it is in-state school, hence will have 
      // _Disabled attached to its name, the original name now is of type hidden so update its value with 
      // current value
      if (document.frmEduDetail.txtSzNmEdhistSchool.type == 'hidden') { 
        document.frmEduDetail.txtSzNmEdhistSchool.value = txtSzNmEdhistSchool_Name.value;
      }
    }
    
    
  }
  
  var changed = <%= StringHelper.isValid(rowccfc17sog00.getSzCdEdhistType()) %>;;
  /*
   * Called when user changes Education Type of an existing record
   */ 
  function updateEduTypeAndInfo() {
    // Calll reset only if this is existing record  
    if (changed) {
      resetEduInfo();
    } else {
      updateType();
    }
    
  }
  /* Called on change in Education Type of an existing record to warn user that changing
   * the Education type will clear out the Education Info section since that is data related
   * to the previous type and might not apply to the new type
   */
  function resetEduInfo()
{
  var newEduTypeValue = document.frmEduDetail.szCdEdhistType.value;
  var rbCIndEdhistTeaSchool_InState = document.getElementById("rbCIndEdhistTeaSchool_Id1");
  var rbCIndEdhistTeaSchool_OutState = document.getElementById("rbCIndEdhistTeaSchool_Id2");
  var szIndEdhistLicense_Licensed = document.getElementById("szIndEdhistLicense_Id3");
  var szIndEdhistLicense_UnLicensed = document.getElementById("szIndEdhistLicense_Id4");
  var txtSzNmEdhistSchool_Name = document.getElementById("txtSzNmEdhistSchool_display_Id");

  /* Don't prompt user if no value in Education Info section
   * If one of the fields in the Education Info section has data, tell the user that changing
   * the Education type will clear out the Education Info section.
   */
  if ((rbCIndEdhistTeaSchool_InState.checked == false) &&
      (rbCIndEdhistTeaSchool_OutState.checked == false) &&
      (szIndEdhistLicense_Licensed.checked == false) &&
      (szIndEdhistLicense_UnLicensed.checked == false ) &&
      (txtSzNmEdhistSchool_Name.value == ""))
  {
    changeIt = true;
  }
  else
  {
    changeIt = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_SUB_CLEAR_EDU_INFO) %>');
  }

  if (changeIt) 
  { 
    clearRbEduInfo(); // clear all radio btn in Edu Info section
    updateType();     // enable/disable page field in accordance with new edu type
    changed = true;  // set change indicator to true to avoid multiple reset, uneccessary
    document.frmEduDetail.hdnCurrentEduTypeCd.value = newEduTypeValue;
  } else { // put back the old Edu type since user cancels the action
    document.frmEduDetail.szCdEdhistType.value = document.frmEduDetail.hdnCurrentEduTypeCd.value;
  }
}
/*
 * Update the original name since if it was disabled on page load, it will be changed to aName_Disable
 * so update the original name's value with the current value because Conversation's populate method 
 * refers to the original name
 */
function updateSchoolName() { 
    var txtSzNmEdhistSchool_Name = document.getElementById("txtSzNmEdhistSchool_display_Id");
    if (document.frmEduDetail.txtSzNmEdhistSchool.type == 'hidden') { 
      document.frmEduDetail.txtSzNmEdhistSchool.value = txtSzNmEdhistSchool_Name.value;
    }
}
/*
 * This method differs from updateSchoolName in that it brings back the resource name (exists when the page loads).
 * id resource is not zero means there existed resource when page loads.
 * This allows user to to start off with In State, flip back and forth between In and Out state but then decides 
 * to stick with the original In State selection, that way user does not have to select resource again
 */
function updateResourceName() {
  var txtSzNmEdhistSchool_Name = document.getElementById("txtSzNmEdhistSchool_display_Id");
  if (document.frmEduDetail.hdnResourceID.value != '' && txtSzNmEdhistSchool_Name.value != document.frmEduDetail.hdnTxtSchoolName.value) {
    txtSzNmEdhistSchool_Name.value = document.frmEduDetail.hdnTxtSchoolName.value;
    // this is the name populate() used to get request value so update it with new value if not already updated
    updateSchoolName();
    // reverted to original resource so set isResource to indicate resource has been selected for In State 
    document.frmEduDetail.hdnIsResource.value = 'true';
  }
}

// SIR 17285 GRIMSHAN this function is called on change of the radio buttons
// to determine what should be enabled and disabled on the page.
function submitRadioSelection()
{
  cancelValidation();
  submitValidateForm( "frmEduDetail", "/person/PersonDetail/reDisplayEducation" );

}

//  Called onUnload of page to remind user unsaved data will be lost
window.onbeforeunload = function ()
{
  IsDirty();
}
</script>


<impact:validateErrors/>
<impact:validateForm name="frmEduDetail"
  method="post"
  action="/person/PersonDetail/saveEducation"
  pageMode="<%= overallPageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.EducationCustomValidation"
  schema="/WEB-INF/Constraints.xsd">
<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page.
  --%>
  <impact:validateInput type="hidden" name="hdnTsEduLastUpdate" value="<%= DateHelper.toISOString(rowccfc17sog00.getTsLastUpdate()) %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdEdhist" value="<%= FormattingHelper.formatInt(rowccfc17sog00.getUlIdEdhist())%>"/>
  <impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>
  <impact:validateInput type="hidden" name="hdnIsResource" value="<%= String.valueOf(isResource) %>"/>
  <impact:validateInput type="hidden" name="hdnResourceID" value="<%= String.valueOf(resourceId) %>"/>
  <impact:validateInput type="hidden" name="hdnCurrentEduTypeCd" value="<%= FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistType()) %>"/>
  <impact:validateInput type="hidden" name="hdnTxtSchoolName" value="<%= schoolName %>"/>
    <impact:validateInput type="hidden" name="txtSzNmEdhistSchool" value="<%= schoolName %>"/>
<% /* Begin Detail */ %>

  <table border="0" cellpadding="0" cellspacing="0" width="100%" class="tableBorder">
  <tr>
  <th colspan="4">Education Type</th>
  </tr>
  <tr>
  <td><impact:validateSelect label="Education Type"
                               name="szCdEdhistType"
                               required="true"
                               onChange="updateEduTypeAndInfo();"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               codesTable="CEDTYPE"
                               value="<%=FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistType())%>"/>
    </td>
  </tr>
  <tr>
  <th colspan="4">Education Information</th>
  </tr>
  <tr>
    <td>
    <!-- TODO we will change back van don't worry!disableEduInfo_SchoolName();-->
    <impact:validateInput checked="<%= String.valueOf( bInState ) %>"
                          tabIndex="<%= tabIndex++ %>"
                          value="I"
                          type="radio"
                          onClick="enableBtnSelectResource();"
                          disabled="false"
                          editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                          name="rbCIndEdhistTeaSchool"
                          label="In State"
                          cssClass="formInput" />
    </td>
    <td>
    <impact:validateInput checked="<%= String.valueOf( bOutofState ) %>"
                          tabIndex="<%= tabIndex++ %>"
                          value="O"
                          type="radio"
                          onClick="enableEduInfo_SchoolName();disableBtnSelectResource();"
                          disabled="false"
                          editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                          name="rbCIndEdhistTeaSchool"
                          label="Out of State"
                          cssClass="formInput" />
    </td>
  </tr>
   <tr>
    <td>
    <impact:validateInput checked="<%= String.valueOf( bLicensed ) %>"
                          tabIndex="<%= tabIndex++ %>"
                          value="L"
                          type="radio"
                          disabled="false"
                          editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                          name="szIndEdhistLicense"
                          label="Licensed"
                          cssClass="formInput" />
    </td>
    <td><impact:validateInput checked="<%= String.valueOf( bUnlicensed ) %>"
                          tabIndex="<%= tabIndex++ %>"
                          value="U"
                          type="radio"
                          disabled="false"
                          editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                          name="szIndEdhistLicense"
                          label="Unlicensed"
                          cssClass="formInput" />
    </td>
  </tr>
  <tr>
    <td width="15%">
      <impact:validateDisplayOnlyField name="dspSzNmEdhistSchDist"
                                     label="School District"
                                     colspan="3"
                                     value="<%=FormattingHelper.formatString(districtName)%>" />
    </td>
  </tr>
  <tr>
    <td><impact:validateInput type="text"
                              label="School/Day Care Name"
                              constraint="Paragraph"
                              conditionallyRequired="true"
                              name="txtSzNmEdhistSchool_display"
                              onChange="updateSchoolName();"
                              cssClass="formInput"
                              disabled="false"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(schoolName)%>"
                              size="30"
                              maxLength="30"
                              width="25%"
                              tabIndex="<%= tabIndex++ %>"/>
    </td>
    <% /* SIR 17010 GRIMSHAN Added a call to the isInState function */ %>
    <td colspan="2">
    <span id="BTN_SELECT_RESOURCE" style="display: block">
    <impact:ButtonTag name="btnSelectResource"
                          img="btnSelectResource"
                          function="return isInState()"
                          editableMode="<%= EditableMode.NEW + EditableMode.MODIFY %>"
                          form="frmEduDetail"
                          function="disableValidation('frmEduDetail'); return isInState()"
                          action="/person/PersonDetail/selectResource"
                          tabIndex="<%= tabIndex++ %>"/>
    </span>
    </td>
  </tr>
  <th colspan="4">Enrollment</th>
  <tr>
    <td colspan="1"><impact:validateDate type="text"
                             name="txtDtDtEdhistEnrollDate"
                             label="Enrolled"
                             constraint="Date"
                             editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                             value="<%= FormattingHelper.formatDate(rowccfc17sog00.getDtDtEdhistEnrollDate()) %>"
                             size="10"
                             tabIndex="<%= tabIndex++ %>"/></td>
         <td colspan="1"><impact:validateSelect label="Grade"
                               name="selSzCdEdhistEnrollGrade"
                               conditionallyRequired="true"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               codesTable="CSCHGRAD"
                               value="<%=FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistEnrollGrade())%>"/>
       </td>
  </tr>
  <% /* New fields R2 */ %>
  <tr>
    <td valign="top" colspan="1">Current Grade Level :
    </td>
    <td>
    <impact:validateInput type="radio" label="At Level" id="rbCIndEdhistLevel_Yes" name="rbCIndEdhistLevel" value="A"  checked="<%= rbCIndEdhistLevel_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="Below Level"  id="rbCIndEdhistLevel_No"  name="rbCIndEdhistLevel" value="B"  checked="<%= rbCIndEdhistLevel_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
</td>
<td>
        <impact:validateSelect label="Grade"
                               name="selSzCEdhistCurrentGradeLevel"
                               conditionallyRequired="true"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               codesTable="CSCHGRAD"
                               value="<%=FormattingHelper.formatString(rowccfc17sog00.getSzCEdhistCurrentGradeLevel())%>"/>

    </td>
  </tr>
  <tr>
  <td>
  <impact:validateSelect label="Attendance"
                               name="selSzCEdhistAttendance"
                               conditionallyRequired="true"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               codesTable="CATNDNCE"
                               value="<%=FormattingHelper.formatString(rowccfc17sog00.getSzCEdhistAttendance())%>"/>
  
  </td>
  </tr>
  <tr>
      <td><impact:validateDate type="text"
                             name="txtDtDtEdhistWithdrawnDate"
                             label="Withdrawn"
                             constraint="Date"
                             editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                             value="<%= FormattingHelper.formatDate(rowccfc17sog00.getDtDtEdhistWithdrawnDate()) %>"
                             size="10"
                             tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td><impact:validateSelect label="Grade"
                               name="selSzCdEdhistWithdrawnGrade"
                               conditionallyRequired="true"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="CSCHGRAD"
                               value="<%=FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistWithdrawnGrade())%>"/>
    </td>
  </tr>
  <tr>
    <th colspan="4">Education Programs</th>
  </tr>
  <tr>
    <td colspan="4">
  <impact:codesCheckbox defaultCodes="<%=checkedValues%>"
                        name="cbxSzCdEdhistNeeds"
                        editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                        codesTableName="CEDUCNED"
                        columns="3"
                        tabIndex="<%= tabIndex++ %>"/>
  </td>
  </tr>
  <tr>
    <td><impact:validateTextArea name="szTxtEdhistCmnts"
                                 label="Comments"
                                 rows="4"
                                 cols="85"
                                 editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                                 tabIndex="<%= tabIndex++ %>"
                                 maxLength="300"
                                 constraint="Paragraph300">
                                 <%=FormattingHelper.formatString(rowccfc17sog00.getSzEdHistComments())%>
        </impact:validateTextArea>
    </td>
  </tr>
  </table>
  </br>
  <% /* Begin Foster Care Case Plan Information */ %>
  <impact:ExpandableSectionTag
    name="FosterCareCasePlan"
    label="Foster Care Case Plan Information"
    tabIndex="<%= tabIndex++ %>">
    
    <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder" bgcolor="white">
 <tr>
    <td valign="top" colspan="1"> <b>Education </b>
          <table cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
          <tr>
      <td valign="top" colspan="1">
              Are school records in the child's file? :
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="SchoolrecordsOnFile_Yes" name="rbSchoolRecs" value="Y"  checked="<%= SchoolrecordsOnFile_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="SchoolrecordsOnFile_No"  name="rbSchoolRecs" value="N"  checked="<%= SchoolrecordsOnFile_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
        <impact:validateInput type="radio" label="N/A"  id="SchoolrecordsOnFile_NA"  name="rbSchoolRecs" value="A"  checked="<%= SchoolrecordsOnFile_NA %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
      </tr>
      
      <tr>
	    <td valign="top" colspan="1">
	      <span class="formCondRequiredText">&#8225;</span>If no, explain:
	    </td>
	    <td colspan="2">
	      <impact:validateTextArea
	        name="txSchoolRecordsComment"
	        cols="92"
	        rows="3"
	        tabIndex="<%=tabIndex++%>"
	        maxLength="500"
	        constraint="Comments">
	        <%= FormattingHelper.formatString(rowccfc17sog00.getSzTxtSchoolRecordsCmnts()) %>
	      </impact:validateTextArea>
	    </td>
      </tr>
      

      <tr>
      <td valign="top" colspan="1">
              Records provided to boarding county? :
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="RecordsboardingCounty_Yes" name="rbRecsToBCounty" value="Y"  checked="<%= RecordsboardingCounty_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="RecordsboardingCounty_No"  name="rbRecsToBCounty" value="N"  checked="<%= RecordsboardingCounty_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
        <impact:validateInput type="radio" label="N/A"  id="RecordsboardingCounty_NA"  name="rbRecsToBCounty" value="A"  checked="<%= RecordsboardingCounty_NA %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
       </tr>

           <tr>
      <td valign="top" colspan="1">
              School changed due to removal? :<br> (Removal includes any change in placement) : 
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="SchoolChanged_Yes" name="rbSchoolChange" value="Y"  checked="<%= SchoolChanged_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="SchoolChanged_No"  name="rbSchoolChange" value="N"  checked="<%= SchoolChanged_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
        <impact:validateInput type="radio" label="N/A"  id="SchoolChanged_NA"  name="rbSchoolChange" value="A"  checked="<%= SchoolChanged_NA %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
      </tr>
            
      <tr>
	    <td valign="top" colspan="1">
	      <span class="formCondRequiredText">&#8225;</span>If yes, explain:
	    </td>
	    <td colspan="2">
	      <impact:validateTextArea
	        name="txtSchoolChangeComment"
	        cols="92"
	        rows="3"
	        tabIndex="<%=tabIndex++%>"
	        maxLength="500"
	        constraint="Comments">
	        <%= FormattingHelper.formatString(rowccfc17sog00.getSzTxtSchoolChangeCmnts()) %>
	      </impact:validateTextArea>
	    </td>
      </tr>
      
      
      <tr>
      <td valign="top" colspan="1">
               Comments on Behavioral/Discipline Record
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtBehaveDisc"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="300"
        constraint="Comments">
        <%= FormattingHelper.formatString(rowccfc17sog00.getSzTxtBehaveDisc()) %>
      </impact:validateTextArea>
    </td>
    </tr>
           <tr>
      <td valign="top" colspan="1">
              Does the child have special educational needs? :
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="ChildEducationalNeeds_Yes" name="rbSpecialEdNeeds" value="Y"  checked="<%= ChildEducationalNeeds_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="ChildEducationalNeeds_No"  name="rbSpecialEdNeeds" value="N"  checked="<%= ChildEducationalNeeds_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
        <impact:validateInput type="radio" label="N/A"  id="ChildEducationalNeeds_NA"  name="rbSpecialEdNeeds" value="A"  checked="<%= ChildEducationalNeeds_NA %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
       </tr>
            <tr>
      <td valign="top" colspan="1">
              Did the child previously have special educational services? :
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="SpecialEduServices_Yes" name="rbSpecialEdSvc" value="Y"  checked="<%= SpecialEduServices_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="SpecialEduServices_No"  name="rbSpecialEdSvc" value="N"  checked="<%= SpecialEduServices_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
        <impact:validateInput type="radio" label="N/A"  id="SpecialEduServices_NA"  name="rbSpecialEdSvc" value="A"  checked="<%= SpecialEduServices_NA %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
       </tr>
       <tr>
      <td valign="top" colspan="1">
               <span class="formCondRequiredText">&#8225;</span>If yes to either, explain:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtSpecialEdCmnts"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="300"
        constraint="Comments">
        <%= FormattingHelper.formatString(rowccfc17sog00.getSzTxtSpecialEdCmnts()) %>
      </impact:validateTextArea>
    </td>
    </tr>
    <tr>
     <td valign="top" colspan="1">
        <impact:validateDate
           label="Date of Student Support Team Referral"
           type="text"
           size="10"
           value="<%= FormattingHelper.formatDate(rowccfc17sog00.getSzDtStSupTeamRef()) %>"
           name="szDtStSupTeamRef"
           tabIndex="<%= tabIndex++ %>"
           cssClass="formInput"
           constraint="Date"/>
      </td>
     </tr>
  <tr>
     <td valign="top" colspan="1">
         <impact:validateDate
           label="Date of Individualized Education Plan:"
           type="text"
           size="10"
           value="<%= FormattingHelper.formatDate(rowccfc17sog00.getSzDtRbEdDate()) %>"
           name="szDtRbEdDate"
           tabIndex="<%= tabIndex++ %>"
           cssClass="formInput"
           constraint="Date"/>
      </td>
     </tr>
      <tr>
       <td>
       <impact:validateInput type="text"
                              label="Surrogate Parent:"
                              constraint="Paragraph"
                              name="txtSurrogateParent"
                              cssClass="formInput"
                              disabled=""
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%= FormattingHelper.formatString(rowccfc17sog00.getTxtSurrogateParent()) %>"
                              size="30"
                              maxLength="30"
                              width="25%"
                              tabIndex="<%= tabIndex++ %>"/>
       </td>
       <td>                       
        <impact:validateInput type="radio" label="Foster Parent" id="FosterParent_Yes" name="rbIndFosterParent" value="Y"  checked="<%= FosterParent_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="Other"  id="Other_Yes"  name="rbIndFosterParent" value="N"  checked="<%= Other_Yes %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
       </td> 
       </tr>
<tr>
     <td valign="top" colspan="1">
              Legal Parent Involved? :
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="LegalParent_Yes" name="rbLegalParent" value="Y"  checked="<%= LegalParent_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="LegalParent_No"  name="rbLegalParent" value="N"  checked="<%= LegalParent_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
       </td> 
       </tr>
<tr>
      <td valign="top" colspan="1">
               Comments on SST or IEP
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtSstIepCmnts"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="300"
        constraint="Comments">         
        <%= FormattingHelper.formatString(rowccfc17sog00.getSzTxtSstIepCmnts()) %>
      </impact:validateTextArea>
    </td>
    </tr>
    <tr>
     <td valign="top" colspan="1">
              Is the child receiving early intervention services? :
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="InterventionServices_Yes" name="rbChildServices" value="Y"  checked="<%= InterventionServices_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="InterventionServices_No"  name="rbChildServices" value="N"  checked="<%= InterventionServices_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
       </td> 
       </tr>
<tr>
     <td valign="top" colspan="1">
              Was the child previously receiving early intervention services? :
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="PrevInterventionServices_Yes" name="rbPrevChildSvc" value="Y"  checked="<%= PrevInterventionServices_Yes %>" cssClass="formInput"  tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="PrevInterventionServices_No"  name="rbPrevChildSvc" value="N"  checked="<%= PrevInterventionServices_No %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" /> 
       </td> 
       </tr>

     <tr>
      <td valign="top" colspan="1">
      <span class="formCondRequiredText">&#8225;</span>If yes, explain:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtChildSvcComments"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="300"
        constraint="Comments">
        <%= FormattingHelper.formatString(rowccfc17sog00.getSzTxtChildSvcComments()) %>
      </impact:validateTextArea>
    </td>
    </tr>
       </table>
      </tr>
      </table>
    
    </impact:ExpandableSectionTag>
  
  <%/* BEGIN Admin Address Phone Submodule */%>
<%
  AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
  adminAddressPhoneSubDB.setFormName( "frmEduDetail" );
  adminAddressPhoneSubDB.setPageMode( overallPageMode );
  adminAddressPhoneSubDB.setAddressPhoneSectionHeader( "Address and Phone Information" );
  adminAddressPhoneSubDB.setAddressRequired( false );
  adminAddressPhoneSubDB.setAddressDisabled( false );
  adminAddressPhoneSubDB.setCommentsVisible( true );
  adminAddressPhoneSubDB.setCommentsRequired( false );
  adminAddressPhoneSubDB.setCommentsDisabled( false );
  adminAddressPhoneSubDB.setPhoneRequired( false );
  adminAddressPhoneSubDB.setPhoneDisabled( false );
  adminAddressPhoneSubDB.setAddressSubmoduleName( "" );
  adminAddressPhoneSubDB.setTabIndex( tabIndex );
  AdminAddressPhoneSubDB.setIntoRequest( adminAddressPhoneSubDB, request );
%>
<%// SIR 18981 GRIMSHAN added these instructions so that if the user pulls back an address
  // that is incomplete they will know what to do
%>
<table>
<tr>
<td class="formInstruct">
If the page will not save due to a bad address, please contact your resource maintainer.
</td>
</tr>
</table>
<%@ include file="/grnds-docs/admin/AdminAddressPhoneSub.jsp" %>
<%
  tabIndex = adminAddressPhoneSubDB.getTabIndex();
  AdminAddressPhoneSubDB.removeFromRequest( request );
%>
<%/* END Admin Address Phone Submodule */%>
<br>
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td class="alignRight">
         <impact:ButtonTag name="btnSave"
                           img="btnSave"
                           restrictRepost="true"
                           form="frmEduDetail"
                           action="/person/PersonDetail/saveEducation"
                           editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                           tabIndex="<%= tabIndex++ %>"/>
    </td>
   </tr>
</table>




<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>

