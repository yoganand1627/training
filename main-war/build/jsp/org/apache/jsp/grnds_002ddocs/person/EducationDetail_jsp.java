package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY;
import java.util.Enumeration;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class EducationDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/admin/AdminAddressPhoneSub.jsp");
    _jspx_dependants.add("/grnds-docs/common/AddressSub.jsp");
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


      out.write("\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      out.write("\r\n\r\n\r\n");
 // Start Javascript Section

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nwindow.attachEvent('onload', updateType);\r\n\r\nfunction cancelValidation()\r\n{\r\n  disableValidation(\"frmEduDetail\");\r\n  return true;\r\n}\r\n\r\nfunction deleteRow()\r\n{\r\n  var bRow = confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("');\r\n  return bRow;\r\n}\r\n\r\n// SIR 17010 GRIMSHAN -- Added this javascript function so that if the second radio button\r\n// (out of state) has been selected, a message will be displayed and the page will not\r\n// go any where when select resource is clicked.\r\nfunction isInState()\r\n{\r\n  var rbCIndEdhistTeaSchool_OutState = document.getElementById(\"rbCIndEdhistTeaSchool_Id2\");\r\n  if(frmEduDetail.szCdEdhistType.options.value == \"NIS\")\r\n  {\r\n  return false;\r\n  }\r\n  if (rbCIndEdhistTeaSchool_OutState.checked)\r\n  {\r\n   //alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_OUT_NO_RES ) );
      out.write("');\r\n   disableBtnSelectResource();\r\n   return false;\r\n  }\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n}\r\n  /*\r\n   * \r\n   */\r\nfunction updateType()\r\n{ \r\n  if(frmEduDetail.szCdEdhistType.options.value == \"SCH\")\r\n  { \r\n   enableEduInfo_TeaSchool();\r\n   disableEduInfo_License(); \r\n   // retain btn visibility when coming back from (failing) custom validation (user just switched to In State, not saved to db yet)\r\n   var rbCIndEdhistTeaSchool_OutState = document.getElementById(\"rbCIndEdhistTeaSchool_Id2\");\r\n   var rbCIndEdhistTeaSchool_InState = document.getElementById(\"rbCIndEdhistTeaSchool_Id1\");\r\n   if (rbCIndEdhistTeaSchool_OutState.checked) {\r\n     disableBtnSelectResource();\r\n     enableEduInfo_SchoolName();\r\n   } else {\r\n     enableBtnSelectResource();\r\n   }\r\n   if (rbCIndEdhistTeaSchool_InState.checked) { \r\n     disableEduInfo_SchoolName();\r\n   }\r\n  }\r\n  else if(frmEduDetail.szCdEdhistType.options.value == \"DCR\")\r\n  {\r\n   disableEduInfo_TeaSchool();\r\n   enableEduInfo_License();\r\n   enableEduInfo_SchoolName();\r\n   enableBtnSelectResource();\r\n");
      out.write("   \r\n  }\r\n  else if(frmEduDetail.szCdEdhistType.options.value == \"NIS\")\r\n  {\r\n   disableEduInfo();\r\n   disableBtnSelectResource();\r\n   frmEduDetail.txtDtDtEdhistEnrollDate.disabled = true; \r\n   frmEduDetail.selSzCdEdhistEnrollGrade.disabled = true; \r\n   frmEduDetail.rbCIndEdhistLevel[0].disabled = true; \r\n   frmEduDetail.rbCIndEdhistLevel[1].disabled = true; \r\n   frmEduDetail.selSzCEdhistAttendance.disabled = true; \r\n   frmEduDetail.selSzCEdhistCurrentGradeLevel.disabled = true; \r\n   frmEduDetail.txtDtDtEdhistWithdrawnDate.disabled = true; \r\n   frmEduDetail.selSzCdEdhistWithdrawnGrade.disabled = true; \r\n   }\r\n  else if (frmEduDetail.szCdEdhistType.options.value == \"HMS\" || frmEduDetail.szCdEdhistType.options.value == \"HST\") // Head Start or Home School \r\n  {\r\n   disableEduInfo_TeaSchool();\r\n   disableEduInfo_License();\r\n   enableEduInfo_SchoolName();\r\n   if (frmEduDetail.szCdEdhistType.options.value != \"HST\") { // Do not hide Select Resource btn if Head Start\r\n     disableBtnSelectResource();\r\n   }\r\n  }\r\n  }\r\n");
      out.write("  /*\r\n   * \r\n   */\r\n  function disableBtnSelectResource() {\r\n    var btnSelectResource_Btn = document.getElementById(\"BTN_SELECT_RESOURCE\");\r\n    var txtSzNmEdhistSchool_Name = document.getElementById(\"txtSzNmEdhistSchool_display_Id\");\r\n    if (btnSelectResource_Btn.style.display == 'block') {\r\n      toggleVisibility('BTN_SELECT_RESOURCE', 'none');\r\n    }\r\n    // set boolean to false to indicate current selection is not a resource-typed one but do not clear idResource\r\n    // until user finalize selection with a Save\r\n    //document.frmEduDetail.hdnResourceID.value = '0'; // not a missing code - do not uncomment\r\n    document.frmEduDetail.hdnIsResource.value = 'false';\r\n  }\r\n  /*\r\n   * \r\n   */ \r\n  function enableBtnSelectResource() {\r\n    var btnSelectResource_Btn = document.getElementById(\"BTN_SELECT_RESOURCE\");\r\n    if (btnSelectResource_Btn.style.display == 'none') {\r\n      toggleVisibility('BTN_SELECT_RESOURCE', 'block');\r\n    }\r\n  }\r\n  /*\r\n   * \r\n   */ \r\n  function disableEduInfo_SchoolName() {\r\n    var txtSzNmEdhistSchool_Name = document.getElementById(\"txtSzNmEdhistSchool_display_Id\");\r\n");
      out.write("    if (txtSzNmEdhistSchool_Name.disabled == false) {\r\n      txtSzNmEdhistSchool_Name.disabled = true;\r\n    }\r\n  }\r\n  /*\r\n   * \r\n   */ \r\n  function enableEduInfo_SchoolName() {\r\n    var txtSzNmEdhistSchool_Name = document.getElementById(\"txtSzNmEdhistSchool_display_Id\");\r\n    if (txtSzNmEdhistSchool_Name.disabled == true) {\r\n      txtSzNmEdhistSchool_Name.disabled = false;\r\n    }\r\n  }\r\n  /*\r\n   * \r\n   */ \r\n  function disableEduInfo_TeaSchool() {\r\n    var rbCIndEdhistTeaSchool_InState = document.getElementById(\"rbCIndEdhistTeaSchool_Id1\");\r\n    var rbCIndEdhistTeaSchool_OutState = document.getElementById(\"rbCIndEdhistTeaSchool_Id2\");\r\n    \r\n    if (rbCIndEdhistTeaSchool_InState.disabled == false) {\r\n      rbCIndEdhistTeaSchool_InState.disabled = true;\r\n    }\r\n    if (rbCIndEdhistTeaSchool_OutState.disabled == false) {\r\n      rbCIndEdhistTeaSchool_OutState.disabled = true;\r\n    } \r\n  }\r\n  /*\r\n   * \r\n   */ \r\n  function disableEduInfo_License() {\r\n    var szIndEdhistLicense_Licensed = document.getElementById(\"szIndEdhistLicense_Id3\");\r\n");
      out.write("    var szIndEdhistLicense_UnLicensed = document.getElementById(\"szIndEdhistLicense_Id4\");\r\n    \r\n    if (szIndEdhistLicense_Licensed.disabled == false) {\r\n      szIndEdhistLicense_Licensed.disabled = true;\r\n    }\r\n    if (szIndEdhistLicense_UnLicensed.disabled == false) {\r\n      szIndEdhistLicense_UnLicensed.disabled = true;\r\n    }\r\n  }\r\n  /*\r\n   * \r\n   */\r\n  function disableEduInfo() {\r\n    disableEduInfo_TeaSchool();\r\n    disableEduInfo_License();\r\n    disableEduInfo_SchoolName();\r\n  }\r\n  /*\r\n   * \r\n   */ \r\n  function enableEduInfo_TeaSchool() {\r\n    var rbCIndEdhistTeaSchool_InState = document.getElementById(\"rbCIndEdhistTeaSchool_Id1\");\r\n    var rbCIndEdhistTeaSchool_OutState = document.getElementById(\"rbCIndEdhistTeaSchool_Id2\");\r\n    if (rbCIndEdhistTeaSchool_InState.disabled == true) {\r\n      rbCIndEdhistTeaSchool_InState.disabled = false;\r\n    }\r\n    if (rbCIndEdhistTeaSchool_OutState.disabled == true) {\r\n      rbCIndEdhistTeaSchool_OutState.disabled = false;\r\n    }\r\n  }\r\n  /*\r\n   * \r\n   */ \r\n  function enableEduInfo_License() {\r\n");
      out.write("    var szIndEdhistLicense_Licensed = document.getElementById(\"szIndEdhistLicense_Id3\");\r\n    var szIndEdhistLicense_UnLicensed = document.getElementById(\"szIndEdhistLicense_Id4\");\r\n    \r\n    if (szIndEdhistLicense_Licensed.disabled == true) {\r\n      szIndEdhistLicense_Licensed.disabled = false;\r\n    }\r\n    if (szIndEdhistLicense_UnLicensed.disabled == true) {\r\n      szIndEdhistLicense_UnLicensed.disabled = false;\r\n    }\r\n  }\r\n  /*\r\n   * \r\n   */ \r\n  function enableEduInfo() {\r\n    enableEduInfo_TeaSchool();\r\n    enableEduInfo_License();\r\n    enableEduInfo_SchoolName();\r\n  }\r\n  /*\r\n   * Called to clear old data when user changes Education Type of an existing record\r\n   */ \r\n  function clearRbEduInfo() { \r\n    var rbCIndEdhistTeaSchool_InState = document.getElementById(\"rbCIndEdhistTeaSchool_Id1\");\r\n    var rbCIndEdhistTeaSchool_OutState = document.getElementById(\"rbCIndEdhistTeaSchool_Id2\");\r\n    var szIndEdhistLicense_Licensed = document.getElementById(\"szIndEdhistLicense_Id3\");\r\n    var szIndEdhistLicense_UnLicensed = document.getElementById(\"szIndEdhistLicense_Id4\");\r\n");
      out.write("    var txtSzNmEdhistSchool_Name = document.getElementById(\"txtSzNmEdhistSchool_display_Id\");\r\n\r\n    if (rbCIndEdhistTeaSchool_InState.checked == true) {\r\n      rbCIndEdhistTeaSchool_InState.checked = false; \r\n      enableEduInfo_SchoolName;\r\n    } else if (rbCIndEdhistTeaSchool_OutState.checked == true) {\r\n      rbCIndEdhistTeaSchool_OutState.checked = false;\r\n    }\r\n    if (szIndEdhistLicense_Licensed.checked == true) {\r\n      szIndEdhistLicense_Licensed.checked = false;\r\n    } else if (szIndEdhistLicense_UnLicensed.checked == true) {\r\n      szIndEdhistLicense_UnLicensed.checked = false;\r\n    }\r\n    if (txtSzNmEdhistSchool_Name.value != \"\") { \r\n      txtSzNmEdhistSchool_Name.value = \"\";\r\n      // set boolean to indicatte it is not resource-typed education any more (it was resource-typed education before)\r\n      // if it was not resource-typed edu to start with, still okay since it should never be true then\r\n      document.frmEduDetail.hdnIsResource.value = 'false'; \r\n      // School Name could be disabled on page load when it is in-state school, hence will have \r\n");
      out.write("      // _Disabled attached to its name, the original name now is of type hidden so update its value with \r\n      // current value\r\n      if (document.frmEduDetail.txtSzNmEdhistSchool.type == 'hidden') { \r\n        document.frmEduDetail.txtSzNmEdhistSchool.value = txtSzNmEdhistSchool_Name.value;\r\n      }\r\n    }\r\n    \r\n    \r\n  }\r\n  \r\n  var changed = ");
      out.print( StringHelper.isValid(rowccfc17sog00.getSzCdEdhistType()) );
      out.write(";;\r\n  /*\r\n   * Called when user changes Education Type of an existing record\r\n   */ \r\n  function updateEduTypeAndInfo() {\r\n    // Calll reset only if this is existing record  \r\n    if (changed) {\r\n      resetEduInfo();\r\n    } else {\r\n      updateType();\r\n    }\r\n    \r\n  }\r\n  /* Called on change in Education Type of an existing record to warn user that changing\r\n   * the Education type will clear out the Education Info section since that is data related\r\n   * to the previous type and might not apply to the new type\r\n   */\r\n  function resetEduInfo()\r\n{\r\n  var newEduTypeValue = document.frmEduDetail.szCdEdhistType.value;\r\n  var rbCIndEdhistTeaSchool_InState = document.getElementById(\"rbCIndEdhistTeaSchool_Id1\");\r\n  var rbCIndEdhistTeaSchool_OutState = document.getElementById(\"rbCIndEdhistTeaSchool_Id2\");\r\n  var szIndEdhistLicense_Licensed = document.getElementById(\"szIndEdhistLicense_Id3\");\r\n  var szIndEdhistLicense_UnLicensed = document.getElementById(\"szIndEdhistLicense_Id4\");\r\n  var txtSzNmEdhistSchool_Name = document.getElementById(\"txtSzNmEdhistSchool_display_Id\");\r\n");
      out.write("\r\n  /* Don't prompt user if no value in Education Info section\r\n   * If one of the fields in the Education Info section has data, tell the user that changing\r\n   * the Education type will clear out the Education Info section.\r\n   */\r\n  if ((rbCIndEdhistTeaSchool_InState.checked == false) &&\r\n      (rbCIndEdhistTeaSchool_OutState.checked == false) &&\r\n      (szIndEdhistLicense_Licensed.checked == false) &&\r\n      (szIndEdhistLicense_UnLicensed.checked == false ) &&\r\n      (txtSzNmEdhistSchool_Name.value == \"\"))\r\n  {\r\n    changeIt = true;\r\n  }\r\n  else\r\n  {\r\n    changeIt = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SUB_CLEAR_EDU_INFO) );
      out.write("');\r\n  }\r\n\r\n  if (changeIt) \r\n  { \r\n    clearRbEduInfo(); // clear all radio btn in Edu Info section\r\n    updateType();     // enable/disable page field in accordance with new edu type\r\n    changed = true;  // set change indicator to true to avoid multiple reset, uneccessary\r\n    document.frmEduDetail.hdnCurrentEduTypeCd.value = newEduTypeValue;\r\n  } else { // put back the old Edu type since user cancels the action\r\n    document.frmEduDetail.szCdEdhistType.value = document.frmEduDetail.hdnCurrentEduTypeCd.value;\r\n  }\r\n}\r\n/*\r\n * Update the original name since if it was disabled on page load, it will be changed to aName_Disable\r\n * so update the original name's value with the current value because Conversation's populate method \r\n * refers to the original name\r\n */\r\nfunction updateSchoolName() { \r\n    var txtSzNmEdhistSchool_Name = document.getElementById(\"txtSzNmEdhistSchool_display_Id\");\r\n    if (document.frmEduDetail.txtSzNmEdhistSchool.type == 'hidden') { \r\n      document.frmEduDetail.txtSzNmEdhistSchool.value = txtSzNmEdhistSchool_Name.value;\r\n");
      out.write("    }\r\n}\r\n/*\r\n * This method differs from updateSchoolName in that it brings back the resource name (exists when the page loads).\r\n * id resource is not zero means there existed resource when page loads.\r\n * This allows user to to start off with In State, flip back and forth between In and Out state but then decides \r\n * to stick with the original In State selection, that way user does not have to select resource again\r\n */\r\nfunction updateResourceName() {\r\n  var txtSzNmEdhistSchool_Name = document.getElementById(\"txtSzNmEdhistSchool_display_Id\");\r\n  if (document.frmEduDetail.hdnResourceID.value != '' && txtSzNmEdhistSchool_Name.value != document.frmEduDetail.hdnTxtSchoolName.value) {\r\n    txtSzNmEdhistSchool_Name.value = document.frmEduDetail.hdnTxtSchoolName.value;\r\n    // this is the name populate() used to get request value so update it with new value if not already updated\r\n    updateSchoolName();\r\n    // reverted to original resource so set isResource to indicate resource has been selected for In State \r\n");
      out.write("    document.frmEduDetail.hdnIsResource.value = 'true';\r\n  }\r\n}\r\n\r\n// SIR 17285 GRIMSHAN this function is called on change of the radio buttons\r\n// to determine what should be enabled and disabled on the page.\r\nfunction submitRadioSelection()\r\n{\r\n  cancelValidation();\r\n  submitValidateForm( \"frmEduDetail\", \"/person/PersonDetail/reDisplayEducation\" );\r\n\r\n}\r\n\r\n//  Called onUnload of page to remind user unsaved data will be lost\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n</script>\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmEduDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonDetail/saveEducation");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.EducationCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnTsEduLastUpdate");
          _jspx_th_impact_validateInput_0.setValue( DateHelper.toISOString(rowccfc17sog00.getTsLastUpdate()) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnUlIdEdhist");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(rowccfc17sog00.getUlIdEdhist()));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_2.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnIsResource");
          _jspx_th_impact_validateInput_3.setValue( String.valueOf(isResource) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnResourceID");
          _jspx_th_impact_validateInput_4.setValue( String.valueOf(resourceId) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnCurrentEduTypeCd");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistType()) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnTxtSchoolName");
          _jspx_th_impact_validateInput_6.setValue( schoolName );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("txtSzNmEdhistSchool");
          _jspx_th_impact_validateInput_7.setValue( schoolName );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 /* Begin Detail */ 
          out.write("\r\n\r\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"4\">Education Type</th>\r\n  </tr>\r\n  <tr>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Education Type");
          _jspx_th_impact_validateSelect_0.setName("szCdEdhistType");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setOnChange("updateEduTypeAndInfo();");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_0.setCodesTable("CEDTYPE");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistType()));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n  <th colspan=\"4\">Education Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    <!-- TODO we will change back van don't worry!disableEduInfo_SchoolName();-->\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setChecked( String.valueOf( bInState ) );
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setValue("I");
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setOnClick("enableBtnSelectResource();");
          _jspx_th_impact_validateInput_8.setDisabled("false");
          _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_8.setName("rbCIndEdhistTeaSchool");
          _jspx_th_impact_validateInput_8.setLabel("In State");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setChecked( String.valueOf( bOutofState ) );
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setValue("O");
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setOnClick("enableEduInfo_SchoolName();disableBtnSelectResource();");
          _jspx_th_impact_validateInput_9.setDisabled("false");
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_9.setName("rbCIndEdhistTeaSchool");
          _jspx_th_impact_validateInput_9.setLabel("Out of State");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n   <tr>\r\n    <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setChecked( String.valueOf( bLicensed ) );
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setValue("L");
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setDisabled("false");
          _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_10.setName("szIndEdhistLicense");
          _jspx_th_impact_validateInput_10.setLabel("Licensed");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setChecked( String.valueOf( bUnlicensed ) );
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_11.setValue("U");
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setDisabled("false");
          _jspx_th_impact_validateInput_11.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_11.setName("szIndEdhistLicense");
          _jspx_th_impact_validateInput_11.setLabel("Unlicensed");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"15%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzNmEdhistSchDist");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("School District");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(districtName));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setLabel("School/Day Care Name");
          _jspx_th_impact_validateInput_12.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_12.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_12.setName("txtSzNmEdhistSchool_display");
          _jspx_th_impact_validateInput_12.setOnChange("updateSchoolName();");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setDisabled("false");
          _jspx_th_impact_validateInput_12.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatString(schoolName));
          _jspx_th_impact_validateInput_12.setSize("30");
          _jspx_th_impact_validateInput_12.setMaxLength("30");
          _jspx_th_impact_validateInput_12.setWidth("25%");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
 /* SIR 17010 GRIMSHAN Added a call to the isInState function */ 
          out.write("\r\n    <td colspan=\"2\">\r\n    <span id=\"BTN_SELECT_RESOURCE\" style=\"display: block\">\r\n    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSelectResource");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_0.setFunction("return isInState()");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.NEW + EditableMode.MODIFY );
          _jspx_th_impact_ButtonTag_0.setForm("frmEduDetail");
          _jspx_th_impact_ButtonTag_0.setFunction("disableValidation('frmEduDetail'); return isInState()");
          _jspx_th_impact_ButtonTag_0.setAction("/person/PersonDetail/selectResource");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </span>\r\n    </td>\r\n  </tr>\r\n  <th colspan=\"4\">Enrollment</th>\r\n  <tr>\r\n    <td colspan=\"1\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("txtDtDtEdhistEnrollDate");
          _jspx_th_impact_validateDate_0.setLabel("Enrolled");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(rowccfc17sog00.getDtDtEdhistEnrollDate()) );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n         <td colspan=\"1\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Grade");
          _jspx_th_impact_validateSelect_1.setName("selSzCdEdhistEnrollGrade");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_1.setCodesTable("CSCHGRAD");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistEnrollGrade()));
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n  </tr>\r\n  ");
 /* New fields R2 */ 
          out.write("\r\n  <tr>\r\n    <td valign=\"top\" colspan=\"1\">Current Grade Level :\r\n    </td>\r\n    <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setLabel("At Level");
          _jspx_th_impact_validateInput_13.setId("rbCIndEdhistLevel_Yes");
          _jspx_th_impact_validateInput_13.setName("rbCIndEdhistLevel");
          _jspx_th_impact_validateInput_13.setValue("A");
          _jspx_th_impact_validateInput_13.setChecked( rbCIndEdhistLevel_Yes );
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setLabel("Below Level");
          _jspx_th_impact_validateInput_14.setId("rbCIndEdhistLevel_No");
          _jspx_th_impact_validateInput_14.setName("rbCIndEdhistLevel");
          _jspx_th_impact_validateInput_14.setValue("B");
          _jspx_th_impact_validateInput_14.setChecked( rbCIndEdhistLevel_No );
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</td>\r\n<td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Grade");
          _jspx_th_impact_validateSelect_2.setName("selSzCEdhistCurrentGradeLevel");
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_2.setCodesTable("CSCHGRAD");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(rowccfc17sog00.getSzCEdhistCurrentGradeLevel()));
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n  <td>\r\n  ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Attendance");
          _jspx_th_impact_validateSelect_3.setName("selSzCEdhistAttendance");
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_3.setCodesTable("CATNDNCE");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(rowccfc17sog00.getSzCEdhistAttendance()));
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \r\n  </td>\r\n  </tr>\r\n  <tr>\r\n      <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setName("txtDtDtEdhistWithdrawnDate");
          _jspx_th_impact_validateDate_1.setLabel("Withdrawn");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate(rowccfc17sog00.getDtDtEdhistWithdrawnDate()) );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Grade");
          _jspx_th_impact_validateSelect_4.setName("selSzCdEdhistWithdrawnGrade");
          _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_4.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setCodesTable("CSCHGRAD");
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(rowccfc17sog00.getSzCdEdhistWithdrawnGrade()));
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"4\">Education Programs</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"4\">\r\n  ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(checkedValues);
          _jspx_th_impact_codesCheckbox_0.setName("cbxSzCdEdhistNeeds");
          _jspx_th_impact_codesCheckbox_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_codesCheckbox_0.setCodesTableName("CEDUCNED");
          _jspx_th_impact_codesCheckbox_0.setColumns(3);
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szTxtEdhistCmnts");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("85");
          _jspx_th_impact_validateTextArea_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph300");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n                                 ");
              out.print(FormattingHelper.formatString(rowccfc17sog00.getSzEdHistComments()));
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
          out.write("\r\n    </td>\r\n  </tr>\r\n  </table>\r\n  </br>\r\n  ");
 /* Begin Foster Care Case Plan Information */ 
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("FosterCareCasePlan");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Foster Care Case Plan Information");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    \r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" bgcolor=\"white\">\r\n <tr>\r\n    <td valign=\"top\" colspan=\"1\"> <b>Education </b>\r\n          <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n              Are school records in the child's file? :\r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_15.setType("radio");
              _jspx_th_impact_validateInput_15.setLabel("Yes");
              _jspx_th_impact_validateInput_15.setId("SchoolrecordsOnFile_Yes");
              _jspx_th_impact_validateInput_15.setName("rbSchoolRecs");
              _jspx_th_impact_validateInput_15.setValue("Y");
              _jspx_th_impact_validateInput_15.setChecked( SchoolrecordsOnFile_Yes );
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setType("radio");
              _jspx_th_impact_validateInput_16.setLabel("No");
              _jspx_th_impact_validateInput_16.setId("SchoolrecordsOnFile_No");
              _jspx_th_impact_validateInput_16.setName("rbSchoolRecs");
              _jspx_th_impact_validateInput_16.setValue("N");
              _jspx_th_impact_validateInput_16.setChecked( SchoolrecordsOnFile_No );
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setType("radio");
              _jspx_th_impact_validateInput_17.setLabel("N/A");
              _jspx_th_impact_validateInput_17.setId("SchoolrecordsOnFile_NA");
              _jspx_th_impact_validateInput_17.setName("rbSchoolRecs");
              _jspx_th_impact_validateInput_17.setValue("A");
              _jspx_th_impact_validateInput_17.setChecked( SchoolrecordsOnFile_NA );
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n      </tr>\r\n      \r\n      <tr>\r\n\t    <td valign=\"top\" colspan=\"1\">\r\n\t      <span class=\"formCondRequiredText\">&#8225;</span>If no, explain:\r\n\t    </td>\r\n\t    <td colspan=\"2\">\r\n\t      ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_1.setName("txSchoolRecordsComment");
              _jspx_th_impact_validateTextArea_1.setCols("92");
              _jspx_th_impact_validateTextArea_1.setRows("3");
              _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_1.setMaxLength(500);
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n\t        ");
                  out.print( FormattingHelper.formatString(rowccfc17sog00.getSzTxtSchoolRecordsCmnts()) );
                  out.write("\r\n\t      ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t    </td>\r\n      </tr>\r\n      \r\n\r\n      <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n              Records provided to boarding county? :\r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_18.setType("radio");
              _jspx_th_impact_validateInput_18.setLabel("Yes");
              _jspx_th_impact_validateInput_18.setId("RecordsboardingCounty_Yes");
              _jspx_th_impact_validateInput_18.setName("rbRecsToBCounty");
              _jspx_th_impact_validateInput_18.setValue("Y");
              _jspx_th_impact_validateInput_18.setChecked( RecordsboardingCounty_Yes );
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_19.setType("radio");
              _jspx_th_impact_validateInput_19.setLabel("No");
              _jspx_th_impact_validateInput_19.setId("RecordsboardingCounty_No");
              _jspx_th_impact_validateInput_19.setName("rbRecsToBCounty");
              _jspx_th_impact_validateInput_19.setValue("N");
              _jspx_th_impact_validateInput_19.setChecked( RecordsboardingCounty_No );
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_20.setType("radio");
              _jspx_th_impact_validateInput_20.setLabel("N/A");
              _jspx_th_impact_validateInput_20.setId("RecordsboardingCounty_NA");
              _jspx_th_impact_validateInput_20.setName("rbRecsToBCounty");
              _jspx_th_impact_validateInput_20.setValue("A");
              _jspx_th_impact_validateInput_20.setChecked( RecordsboardingCounty_NA );
              _jspx_th_impact_validateInput_20.setCssClass("formInput");
              _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n       </tr>\r\n\r\n           <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n              School changed due to removal? :<br> (Removal includes any change in placement) : \r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_21.setType("radio");
              _jspx_th_impact_validateInput_21.setLabel("Yes");
              _jspx_th_impact_validateInput_21.setId("SchoolChanged_Yes");
              _jspx_th_impact_validateInput_21.setName("rbSchoolChange");
              _jspx_th_impact_validateInput_21.setValue("Y");
              _jspx_th_impact_validateInput_21.setChecked( SchoolChanged_Yes );
              _jspx_th_impact_validateInput_21.setCssClass("formInput");
              _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
              if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_22.setType("radio");
              _jspx_th_impact_validateInput_22.setLabel("No");
              _jspx_th_impact_validateInput_22.setId("SchoolChanged_No");
              _jspx_th_impact_validateInput_22.setName("rbSchoolChange");
              _jspx_th_impact_validateInput_22.setValue("N");
              _jspx_th_impact_validateInput_22.setChecked( SchoolChanged_No );
              _jspx_th_impact_validateInput_22.setCssClass("formInput");
              _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_23.setType("radio");
              _jspx_th_impact_validateInput_23.setLabel("N/A");
              _jspx_th_impact_validateInput_23.setId("SchoolChanged_NA");
              _jspx_th_impact_validateInput_23.setName("rbSchoolChange");
              _jspx_th_impact_validateInput_23.setValue("A");
              _jspx_th_impact_validateInput_23.setChecked( SchoolChanged_NA );
              _jspx_th_impact_validateInput_23.setCssClass("formInput");
              _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n      </tr>\r\n            \r\n      <tr>\r\n\t    <td valign=\"top\" colspan=\"1\">\r\n\t      <span class=\"formCondRequiredText\">&#8225;</span>If yes, explain:\r\n\t    </td>\r\n\t    <td colspan=\"2\">\r\n\t      ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_2.setName("txtSchoolChangeComment");
              _jspx_th_impact_validateTextArea_2.setCols("92");
              _jspx_th_impact_validateTextArea_2.setRows("3");
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_2.setMaxLength(500);
              _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n\t        ");
                  out.print( FormattingHelper.formatString(rowccfc17sog00.getSzTxtSchoolChangeCmnts()) );
                  out.write("\r\n\t      ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t    </td>\r\n      </tr>\r\n      \r\n      \r\n      <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n               Comments on Behavioral/Discipline Record\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_3.setName("szTxtBehaveDisc");
              _jspx_th_impact_validateTextArea_3.setCols("92");
              _jspx_th_impact_validateTextArea_3.setRows("3");
              _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
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
                  out.write("\r\n        ");
                  out.print( FormattingHelper.formatString(rowccfc17sog00.getSzTxtBehaveDisc()) );
                  out.write("\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    </tr>\r\n           <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n              Does the child have special educational needs? :\r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_24.setType("radio");
              _jspx_th_impact_validateInput_24.setLabel("Yes");
              _jspx_th_impact_validateInput_24.setId("ChildEducationalNeeds_Yes");
              _jspx_th_impact_validateInput_24.setName("rbSpecialEdNeeds");
              _jspx_th_impact_validateInput_24.setValue("Y");
              _jspx_th_impact_validateInput_24.setChecked( ChildEducationalNeeds_Yes );
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_25.setType("radio");
              _jspx_th_impact_validateInput_25.setLabel("No");
              _jspx_th_impact_validateInput_25.setId("ChildEducationalNeeds_No");
              _jspx_th_impact_validateInput_25.setName("rbSpecialEdNeeds");
              _jspx_th_impact_validateInput_25.setValue("N");
              _jspx_th_impact_validateInput_25.setChecked( ChildEducationalNeeds_No );
              _jspx_th_impact_validateInput_25.setCssClass("formInput");
              _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_26.setType("radio");
              _jspx_th_impact_validateInput_26.setLabel("N/A");
              _jspx_th_impact_validateInput_26.setId("ChildEducationalNeeds_NA");
              _jspx_th_impact_validateInput_26.setName("rbSpecialEdNeeds");
              _jspx_th_impact_validateInput_26.setValue("A");
              _jspx_th_impact_validateInput_26.setChecked( ChildEducationalNeeds_NA );
              _jspx_th_impact_validateInput_26.setCssClass("formInput");
              _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n       </tr>\r\n            <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n              Did the child previously have special educational services? :\r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_27.setType("radio");
              _jspx_th_impact_validateInput_27.setLabel("Yes");
              _jspx_th_impact_validateInput_27.setId("SpecialEduServices_Yes");
              _jspx_th_impact_validateInput_27.setName("rbSpecialEdSvc");
              _jspx_th_impact_validateInput_27.setValue("Y");
              _jspx_th_impact_validateInput_27.setChecked( SpecialEduServices_Yes );
              _jspx_th_impact_validateInput_27.setCssClass("formInput");
              _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_28.setType("radio");
              _jspx_th_impact_validateInput_28.setLabel("No");
              _jspx_th_impact_validateInput_28.setId("SpecialEduServices_No");
              _jspx_th_impact_validateInput_28.setName("rbSpecialEdSvc");
              _jspx_th_impact_validateInput_28.setValue("N");
              _jspx_th_impact_validateInput_28.setChecked( SpecialEduServices_No );
              _jspx_th_impact_validateInput_28.setCssClass("formInput");
              _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_29.setType("radio");
              _jspx_th_impact_validateInput_29.setLabel("N/A");
              _jspx_th_impact_validateInput_29.setId("SpecialEduServices_NA");
              _jspx_th_impact_validateInput_29.setName("rbSpecialEdSvc");
              _jspx_th_impact_validateInput_29.setValue("A");
              _jspx_th_impact_validateInput_29.setChecked( SpecialEduServices_NA );
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n       </tr>\r\n       <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n               <span class=\"formCondRequiredText\">&#8225;</span>If yes to either, explain:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_4.setName("szTxtSpecialEdCmnts");
              _jspx_th_impact_validateTextArea_4.setCols("92");
              _jspx_th_impact_validateTextArea_4.setRows("3");
              _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
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
                  out.print( FormattingHelper.formatString(rowccfc17sog00.getSzTxtSpecialEdCmnts()) );
                  out.write("\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    </tr>\r\n    <tr>\r\n     <td valign=\"top\" colspan=\"1\">\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_2.setLabel("Date of Student Support Team Referral");
              _jspx_th_impact_validateDate_2.setType("text");
              _jspx_th_impact_validateDate_2.setSize("10");
              _jspx_th_impact_validateDate_2.setValue( FormattingHelper.formatDate(rowccfc17sog00.getSzDtStSupTeamRef()) );
              _jspx_th_impact_validateDate_2.setName("szDtStSupTeamRef");
              _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_2.setCssClass("formInput");
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n     </tr>\r\n  <tr>\r\n     <td valign=\"top\" colspan=\"1\">\r\n         ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_3.setLabel("Date of Individualized Education Plan:");
              _jspx_th_impact_validateDate_3.setType("text");
              _jspx_th_impact_validateDate_3.setSize("10");
              _jspx_th_impact_validateDate_3.setValue( FormattingHelper.formatDate(rowccfc17sog00.getSzDtRbEdDate()) );
              _jspx_th_impact_validateDate_3.setName("szDtRbEdDate");
              _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_3.setCssClass("formInput");
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n     </tr>\r\n      <tr>\r\n       <td>\r\n       ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_30.setType("text");
              _jspx_th_impact_validateInput_30.setLabel("Surrogate Parent:");
              _jspx_th_impact_validateInput_30.setConstraint("Paragraph");
              _jspx_th_impact_validateInput_30.setName("txtSurrogateParent");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setDisabled("");
              _jspx_th_impact_validateInput_30.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
              _jspx_th_impact_validateInput_30.setValue( FormattingHelper.formatString(rowccfc17sog00.getTxtSurrogateParent()) );
              _jspx_th_impact_validateInput_30.setSize("30");
              _jspx_th_impact_validateInput_30.setMaxLength("30");
              _jspx_th_impact_validateInput_30.setWidth("25%");
              _jspx_th_impact_validateInput_30.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n       <td>                       \r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_31.setType("radio");
              _jspx_th_impact_validateInput_31.setLabel("Foster Parent");
              _jspx_th_impact_validateInput_31.setId("FosterParent_Yes");
              _jspx_th_impact_validateInput_31.setName("rbIndFosterParent");
              _jspx_th_impact_validateInput_31.setValue("Y");
              _jspx_th_impact_validateInput_31.setChecked( FosterParent_Yes );
              _jspx_th_impact_validateInput_31.setCssClass("formInput");
              _jspx_th_impact_validateInput_31.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_32.setType("radio");
              _jspx_th_impact_validateInput_32.setLabel("Other");
              _jspx_th_impact_validateInput_32.setId("Other_Yes");
              _jspx_th_impact_validateInput_32.setName("rbIndFosterParent");
              _jspx_th_impact_validateInput_32.setValue("N");
              _jspx_th_impact_validateInput_32.setChecked( Other_Yes );
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n       </td> \r\n       </tr>\r\n<tr>\r\n     <td valign=\"top\" colspan=\"1\">\r\n              Legal Parent Involved? :\r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_33.setType("radio");
              _jspx_th_impact_validateInput_33.setLabel("Yes");
              _jspx_th_impact_validateInput_33.setId("LegalParent_Yes");
              _jspx_th_impact_validateInput_33.setName("rbLegalParent");
              _jspx_th_impact_validateInput_33.setValue("Y");
              _jspx_th_impact_validateInput_33.setChecked( LegalParent_Yes );
              _jspx_th_impact_validateInput_33.setCssClass("formInput");
              _jspx_th_impact_validateInput_33.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_34.setType("radio");
              _jspx_th_impact_validateInput_34.setLabel("No");
              _jspx_th_impact_validateInput_34.setId("LegalParent_No");
              _jspx_th_impact_validateInput_34.setName("rbLegalParent");
              _jspx_th_impact_validateInput_34.setValue("N");
              _jspx_th_impact_validateInput_34.setChecked( LegalParent_No );
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n       </td> \r\n       </tr>\r\n<tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n               Comments on SST or IEP\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_5.setName("szTxtSstIepCmnts");
              _jspx_th_impact_validateTextArea_5.setCols("92");
              _jspx_th_impact_validateTextArea_5.setRows("3");
              _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_5.setMaxLength(300);
              _jspx_th_impact_validateTextArea_5.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
              if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_5.doInitBody();
                }
                do {
                  out.write("         \r\n        ");
                  out.print( FormattingHelper.formatString(rowccfc17sog00.getSzTxtSstIepCmnts()) );
                  out.write("\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    </tr>\r\n    <tr>\r\n     <td valign=\"top\" colspan=\"1\">\r\n              Is the child receiving early intervention services? :\r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_35.setType("radio");
              _jspx_th_impact_validateInput_35.setLabel("Yes");
              _jspx_th_impact_validateInput_35.setId("InterventionServices_Yes");
              _jspx_th_impact_validateInput_35.setName("rbChildServices");
              _jspx_th_impact_validateInput_35.setValue("Y");
              _jspx_th_impact_validateInput_35.setChecked( InterventionServices_Yes );
              _jspx_th_impact_validateInput_35.setCssClass("formInput");
              _jspx_th_impact_validateInput_35.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_36.setType("radio");
              _jspx_th_impact_validateInput_36.setLabel("No");
              _jspx_th_impact_validateInput_36.setId("InterventionServices_No");
              _jspx_th_impact_validateInput_36.setName("rbChildServices");
              _jspx_th_impact_validateInput_36.setValue("N");
              _jspx_th_impact_validateInput_36.setChecked( InterventionServices_No );
              _jspx_th_impact_validateInput_36.setCssClass("formInput");
              _jspx_th_impact_validateInput_36.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n       </td> \r\n       </tr>\r\n<tr>\r\n     <td valign=\"top\" colspan=\"1\">\r\n              Was the child previously receiving early intervention services? :\r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_37.setType("radio");
              _jspx_th_impact_validateInput_37.setLabel("Yes");
              _jspx_th_impact_validateInput_37.setId("PrevInterventionServices_Yes");
              _jspx_th_impact_validateInput_37.setName("rbPrevChildSvc");
              _jspx_th_impact_validateInput_37.setValue("Y");
              _jspx_th_impact_validateInput_37.setChecked( PrevInterventionServices_Yes );
              _jspx_th_impact_validateInput_37.setCssClass("formInput");
              _jspx_th_impact_validateInput_37.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_38.setType("radio");
              _jspx_th_impact_validateInput_38.setLabel("No");
              _jspx_th_impact_validateInput_38.setId("PrevInterventionServices_No");
              _jspx_th_impact_validateInput_38.setName("rbPrevChildSvc");
              _jspx_th_impact_validateInput_38.setValue("N");
              _jspx_th_impact_validateInput_38.setChecked( PrevInterventionServices_No );
              _jspx_th_impact_validateInput_38.setCssClass("formInput");
              _jspx_th_impact_validateInput_38.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n       </td> \r\n       </tr>\r\n\r\n     <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n      <span class=\"formCondRequiredText\">&#8225;</span>If yes, explain:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_6.setName("szTxtChildSvcComments");
              _jspx_th_impact_validateTextArea_6.setCols("92");
              _jspx_th_impact_validateTextArea_6.setRows("3");
              _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_6.setMaxLength(300);
              _jspx_th_impact_validateTextArea_6.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
              if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_6.doInitBody();
                }
                do {
                  out.write("\r\n        ");
                  out.print( FormattingHelper.formatString(rowccfc17sog00.getSzTxtChildSvcComments()) );
                  out.write("\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    </tr>\r\n       </table>\r\n      </tr>\r\n      </table>\r\n    \r\n    ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \r\n  ");
/* BEGIN Admin Address Phone Submodule */
          out.write('\r');
          out.write('\n');

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

          out.write('\r');
          out.write('\n');
// SIR 18981 GRIMSHAN added these instructions so that if the user pulls back an address
  // that is incomplete they will know what to do

          out.write("\r\n<table>\r\n<tr>\r\n<td class=\"formInstruct\">\r\nIf the page will not save due to a bad address, please contact your resource maintainer.\r\n</td>\r\n</tr>\r\n</table>\r\n");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    AdminAddressPhoneSubDB adminAddressPhoneSubAdminAddressPhoneSubDB = AdminAddressPhoneSubDB.getFromRequest( request );
    String adminAddressPhoneSubFormName = adminAddressPhoneSubAdminAddressPhoneSubDB.getFormName();
    String adminAddressPhoneSubPageMode = adminAddressPhoneSubAdminAddressPhoneSubDB.getPageMode();
    String adminAddressPhoneSubAddressPhoneSectionHeader = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressPhoneSectionHeader();
    boolean adminAddressPhoneSubAddressRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressRequired();
    boolean adminAddressPhoneSubAddressDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressDisabled();
    boolean adminAddressPhoneSubCommentsVisible = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsVisible();
    boolean adminAddressPhoneSubCommentsRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsRequired();
    boolean adminAddressPhoneSubCommentsDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsDisabled();
    boolean adminAddressPhoneSubPhoneRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneRequired();
    boolean adminAddressPhoneSubPhoneDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneDisabled();
    String adminAddressPhoneSubAddressSubmoduleName = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressSubmoduleName();
    String expandableSectionName = adminAddressPhoneSubAddressSubmoduleName + "addPhone";
    int adminAddressPhoneSubTabIndex = adminAddressPhoneSubAdminAddressPhoneSubDB.getTabIndex();

//  boolean commentsVisible = true;

    AdminAddressPhoneBean aapBean = null;
    if ( AdminAddressPhoneBean.isInRequest( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromRequest( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else if ( AdminAddressPhoneBean.isInState( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromState( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else
    {
      aapBean = new AdminAddressPhoneBean();
    }

          out.write("\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName( expandableSectionName );
          _jspx_th_impact_ExpandableSectionTag_1.setId(AdminAddressPhoneBean.PHONE + "_Id" );
          _jspx_th_impact_ExpandableSectionTag_1.setLabel( adminAddressPhoneSubAddressPhoneSectionHeader );
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( adminAddressPhoneSubTabIndex );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" class=\"tableBorder\">\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n      <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n        <tr>\r\n          <td width=\"10%\">\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_39.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE ) );
              _jspx_th_impact_validateInput_39.setValue( FormattingHelper.formatPhone( aapBean.getPhone() ) );
              _jspx_th_impact_validateInput_39.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_39.setType("text");
              _jspx_th_impact_validateInput_39.setRequired( String.valueOf( adminAddressPhoneSubPhoneRequired ));
              _jspx_th_impact_validateInput_39.setLabel("Phone");
              _jspx_th_impact_validateInput_39.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_39.setCssClass("formInput");
              _jspx_th_impact_validateInput_39.setConstraint("Phone");
              _jspx_th_impact_validateInput_39.setWidth("45%");
              _jspx_th_impact_validateInput_39.setSize("14");
              _jspx_th_impact_validateInput_39.setMaxLength("14");
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td width=\"15%\">\r\n             ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_40.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE_EXT ) );
              _jspx_th_impact_validateInput_40.setValue( aapBean.getPhoneExt() );
              _jspx_th_impact_validateInput_40.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_40.setType("text");
              _jspx_th_impact_validateInput_40.setLabel("Extension");
              _jspx_th_impact_validateInput_40.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              _jspx_th_impact_validateInput_40.setConstraint("PhoneExtension");
              _jspx_th_impact_validateInput_40.setWidth("30%");
              _jspx_th_impact_validateInput_40.setSize("8");
              _jspx_th_impact_validateInput_40.setMaxLength("8");
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n        </tr>\r\n      </table>\r\n     </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n");
/* BEGIN Address Submodule */
              out.write('\r');
              out.write('\n');

    AddressSubDB adminAddressPhoneAddressSubDB = new AddressSubDB();
    adminAddressPhoneAddressSubDB.setFormName( adminAddressPhoneSubFormName );
    adminAddressPhoneAddressSubDB.setPageMode( adminAddressPhoneSubPageMode );
    adminAddressPhoneAddressSubDB.setAddressSubmoduleName( adminAddressPhoneSubAddressSubmoduleName );
    adminAddressPhoneAddressSubDB.setCommentsVisible( adminAddressPhoneSubCommentsVisible );
    adminAddressPhoneAddressSubDB.setCommentsRequired( adminAddressPhoneSubCommentsRequired );
    adminAddressPhoneAddressSubDB.setCommentsDisabled( adminAddressPhoneSubCommentsDisabled );
    adminAddressPhoneAddressSubDB.setAddressRequired( adminAddressPhoneSubAddressRequired );
    adminAddressPhoneAddressSubDB.setAddressDisabled( adminAddressPhoneSubAddressDisabled );
    adminAddressPhoneAddressSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
    AddressSubDB.setIntoRequest( adminAddressPhoneAddressSubDB, request );

              out.write("\r\n        ");
              out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_41.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_41.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_41.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_41.setType("text");
              _jspx_th_impact_validateInput_41.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_41.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_41.setLabel("Street");
              _jspx_th_impact_validateInput_41.setWidth("45%");
              _jspx_th_impact_validateInput_41.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_41.setCssClass("formInput");
              _jspx_th_impact_validateInput_41.setConstraint("Address");
              _jspx_th_impact_validateInput_41.setSize("50");
              _jspx_th_impact_validateInput_41.setMaxLength("30");
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_42.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_42.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_42.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_42.setType("text");
              _jspx_th_impact_validateInput_42.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_42.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_42.setCssClass("formInput");
              _jspx_th_impact_validateInput_42.setConstraint("Address");
              _jspx_th_impact_validateInput_42.setSize("50");
              _jspx_th_impact_validateInput_42.setMaxLength("30");
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_43.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_43.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_43.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_43.setType("text");
              _jspx_th_impact_validateInput_43.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_43.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_43.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_43.setLabel("City");
              _jspx_th_impact_validateInput_43.setCssClass("formInput");
              _jspx_th_impact_validateInput_43.setConstraint("City");
              _jspx_th_impact_validateInput_43.setMaxLength("20");
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_5.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_5.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_5.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_5.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_5.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_5.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_5.setOnChange( onChange );
              _jspx_th_impact_validateSelect_5.setLabel("State");
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_44.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_44.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_44.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_44.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_44.setType("text");
              _jspx_th_impact_validateInput_44.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_44.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_44.setLabel("Zip");
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setConstraint("Zip");
              _jspx_th_impact_validateInput_44.setMaxLength("5");
              _jspx_th_impact_validateInput_44.setSize("5");
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_45.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_45.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_45.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_45.setType("text");
              _jspx_th_impact_validateInput_45.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_45.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_45.setCssClass("formInput");
              _jspx_th_impact_validateInput_45.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_45.setMaxLength("4");
              _jspx_th_impact_validateInput_45.setSize("4");
              int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
              if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_6.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_6.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_6.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_6.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_6.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_6.setBlankValue("true");
              _jspx_th_impact_validateSelect_6.setLabel("County");
              _jspx_th_impact_validateSelect_6.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_6.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_6.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_6.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateTextArea_7.setLabel("Comments");
              _jspx_th_impact_validateTextArea_7.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
              _jspx_th_impact_validateTextArea_7.setRequired( String.valueOf( addressSubCommentsRequired ) );
              _jspx_th_impact_validateTextArea_7.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
              _jspx_th_impact_validateTextArea_7.setCols("125");
              _jspx_th_impact_validateTextArea_7.setRows("4");
              _jspx_th_impact_validateTextArea_7.setColspan("3");
              _jspx_th_impact_validateTextArea_7.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateTextArea_7.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_7.setMaxLength(300);
              int _jspx_eval_impact_validateTextArea_7 = _jspx_th_impact_validateTextArea_7.doStartTag();
              if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_7.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(addressBean.getComments() ));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

              out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

              out.write("\r\n    <td class=\"alignRight\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_1.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_1.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_1.setAction("#");
              _jspx_th_impact_ButtonTag_1.setFunction(onclick);
              _jspx_th_impact_ButtonTag_1.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_1.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_1.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_46(_jspx_th_impact_ExpandableSectionTag_1, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_47(_jspx_th_impact_ExpandableSectionTag_1, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_48.setType("hidden");
              _jspx_th_impact_validateInput_48.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_48.setValue("true");
              int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
              if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_49.setType("hidden");
              _jspx_th_impact_validateInput_49.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_49.setValue("true");
              int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
              if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_50.setType("hidden");
              _jspx_th_impact_validateInput_50.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_50.setValue("");
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_51.setType("hidden");
              _jspx_th_impact_validateInput_51.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_51.setValue("");
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
              out.print( addressSubFormName );
              out.write("', '");
              out.print( addressSubAddressSubmoduleName );
              out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }

              out.write('\r');
              out.write('\n');
              out.write('\r');
              out.write('\n');

    adminAddressPhoneSubTabIndex = adminAddressPhoneAddressSubDB.getTabIndex();
    AddressSubDB.removeFromRequest( request );

              out.write('\r');
              out.write('\n');
/* END Address Submodule */
              out.write("\r\n     </td>\r\n   </tr>\r\n </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    adminAddressPhoneSubAdminAddressPhoneSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');

  tabIndex = adminAddressPhoneSubDB.getTabIndex();
  AdminAddressPhoneSubDB.removeFromRequest( request );

          out.write('\r');
          out.write('\n');
/* END Admin Address Phone Submodule */
          out.write("\r\n<br>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setForm("frmEduDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/person/PersonDetail/saveEducation");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   </tr>\r\n</table>\r\n\r\n\r\n\r\n\r\n");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
      out.write("\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_46(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
    _jspx_th_impact_validateInput_46.setType("hidden");
    _jspx_th_impact_validateInput_46.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_46.setValue("0");
    int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
    if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_47(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
    _jspx_th_impact_validateInput_47.setType("hidden");
    _jspx_th_impact_validateInput_47.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_47.setValue("0");
    int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
    if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
