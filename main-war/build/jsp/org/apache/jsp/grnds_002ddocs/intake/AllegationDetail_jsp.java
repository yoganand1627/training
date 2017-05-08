package org.apache.jsp.grnds_002ddocs.intake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Collection;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import java.util.List;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeActionsConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;

public final class AllegationDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:    Intake Allegation Detail JSP
//*  Created by:   Jenn Casdorph
//*  Date Created: 02/11/2003
//*
//*  Description:
//*  Allegation Detail - The user will enter allegations
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  03/29/04  resertg           SIR 22616 -- Grabbed Classification from state,
                              added items to Exclude array as necessary.
  03/30/04  resertg           Added comparison of Classification to Empty_String
                              and null.
  07/12/04  ochumd            Sir 22934 -- Replaced cint19d with cint76d.
  05/09/05  nallavs           Sir 23547 -- Removed System.out.println
  08/09/08  arege			  STGAP00005876  In Modify mode Called the function filterMaltreatmentCode()
                              to filter the MaltreatmentCode values according to the MaltreatmentType 
                              that was previously saved.
  09/08/2009  bgehlot         STGAP00015366:Removed the Alleged Maltreator and changed the label for Maltreator Relationship 
  09/17/2009  bgehlot         STGAP00015386: If INT stage is closed the Ralationship field on Allegation
                              Detail is not displayed.
  05/26/2010  hjbaptiste      SMS#51977-MR66-Maltreatment In Care: Added additional field to indicate that Maltreatment took
                              place while the child was/is in DFCS custody. Allow user to open popup html for help. User has
                              to confirm maltreatment in care
  07/08/2010  hjbaptiste      SMS#61470: MR66-Maltreatment In Care - Remapped the location of maltreatments to the DFCS Facility 
                              description pop-up anchors      
  07/11/2011  arege           SMS#114232: CAPTA 4.3 - Allegation Detail/Allegation Detail (Intake) - Relationship Drop-Down Not Wide Enough
                              Removed style="width:150px" attribute from the field Alleged Maltreatment Relationship                        
*/


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  // SIR 22616  Create and Exclude if the Classification type is Child Care
  // Licensing (LCC) or Residential Licensing (LRC)
  List excludeAlleg = new ArrayList();
  String Classification = (String)state.getAttribute("selSzCdStageClassification", request);

  if (!Classification.equals(CodesTables.CCLASS_LRC) &&
      !Classification.equals(CodesTables.CCLASS_LCC) &&
      !Classification.equals(StringHelper.EMPTY_STRING) &&
      !Classification.equals(null) )
  {
    excludeAlleg.add(CodesTables.CABALTYP_EXPC); // Hide Explotation (Lic Only)
  }

  int tabIndex = 1;
  int loopCount = 0;
  Date tempDate = new Date();
  
  String widgetRefresh = (String) request
  						.getAttribute(ServerSideValidationUtility.REFRESH_WIDGETS_FROM_REQUEST);
  				widgetRefresh = widgetRefresh == null ? "false"
						: widgetRefresh;
						
  String pageMode = PageMode.getPageMode(request);

  String warnMaltreatmentInCare = (String) state.getAttribute("warnMaltreatmentInCare", request);
  String indMaltreatInCare = (String) state.getAttribute("indMaltreatInCare", request);
  ROWCINT76DO allegListRow = (ROWCINT76DO) request.getAttribute("allegListRow");
if (allegListRow == null)
  {
    allegListRow = new ROWCINT76DO();
  }

// ochumd - sir 22934 get the sel value id and name
String victSel= allegListRow.getSzScrPersVictim()  + "|" + String.valueOf(allegListRow.getUlIdVictim());

  List allegedVictimVector = (List)state.getAttribute("allegedVictimVector", request);
  if (allegedVictimVector == null)
  {
    allegedVictimVector = new ArrayList();
  }

  // If this is a new allegation and there is only one row in the Alleged Victim Vector,
  // the Alleged Victim field should prefill.
  if ((allegListRow.getUlIdAllegation() == 0) &&
      (allegedVictimVector.size() == 1))
  {
    Option op = (Option)allegedVictimVector.get(0);
 /**   int i = 0;
    try
    {

      i = Integer.parseInt(op.getCode());
    }
    catch (Exception e)
    {
      i = 0;
    }*/
    //allegListRow.setUlIdVictim(i);
     victSel = op.getCode();
  }

  // Maltreator Relationship should be pulled from CRPTRINT, but exclude the following values:
  List excludeRelationship = new ArrayList();
  excludeRelationship.add(CodesTables.CRPTRINT_AA); // Case Reading
  excludeRelationship.add(CodesTables.CRPTRINT_AG); // Community Agency
  excludeRelationship.add(CodesTables.CRPTRINT_CT); // Court
  excludeRelationship.add(CodesTables.CRPTRINT_FV); // Family Viol. Shelter
  excludeRelationship.add(CodesTables.CRPTRINT_FI); // Financial Institute
  excludeRelationship.add(CodesTables.CRPTRINT_HC); // Hospital / Clinic
  excludeRelationship.add(CodesTables.CRPTRINT_IC); // Institut. Contracted
  excludeRelationship.add(CodesTables.CRPTRINT_IP); // Institut. Pers/vol.
  excludeRelationship.add(CodesTables.CRPTRINT_IN); // Institution
  excludeRelationship.add(CodesTables.CRPTRINT_NS); // Non-Parent Spouse
  excludeRelationship.add(CodesTables.CRPTRINT_NM); // Other Non-Mandated
  excludeRelationship.add(CodesTables.CRPTRINT_OS); // Other Shelter
  excludeRelationship.add(CodesTables.CRPTRINT_SA); // Other St. Agency
  excludeRelationship.add(CodesTables.CRPTRINT_PK); // Primary Caretaker
  excludeRelationship.add(CodesTables.CRPTRINT_SC); // Secondary Caretaker
  excludeRelationship.add(CodesTables.CRPTRINT_SL); // Self
  excludeRelationship.add(CodesTables.CRPTRINT_SP); // Spouse
  excludeRelationship.add(CodesTables.CRPTRINT_SR); // Step-Child
  excludeRelationship.add(CodesTables.CRPTRINT_TN); // TANF(Sanction Related)
  excludeRelationship.add(CodesTables.CRPTRINT_UF); // Unreg. Fam. Hom
  excludeRelationship.add(CodesTables.CRPTRINT_VC); // Victim


      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nfunction confirmMaltreatmentInCare()\r\n{ \r\n    if ('true' == saveAndAddButtonClicked || 'true' == saveAndContClicked) { \r\n      if(confirm('");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_ALLEG_DT_MALTREAT_IN_CARE ));
      out.write("' ) )\r\n      {\r\n        document.frmAllegationDetail.hdnIndIncmgMaltreatInCare.value = 'Y';\r\n        document.frmAllegationDetail.hdnUpdateMaltreatInCare.value = 'Y';\r\n        if ('true' == saveAndAddButtonClicked) {\r\n          submitValidateForm('frmAllegationDetail', '/intake/IntakeActions/saveAndAddAllegation');\r\n        } else if ('true' == saveAndContClicked) {\r\n          submitValidateForm('frmAllegationDetail', '/intake/IntakeActions/saveAndContinueAllegation');\r\n        }\r\n      }\r\n    }\r\n}\r\n\r\nfunction deleteAllegationConfirm()\r\n{\r\n  return confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("');\r\n}\r\n\r\n  //Assign the corrective action codes table CMALCODE to the static variable maltreatmentCodeCodesTable\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName( CodesTables.CMALCODE );
      _jspx_th_impact_codeArray_0.setArrayName( CodesTables.CMALCODE );
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
      _jspx_th_impact_codeArray_1.setCodeName( CodesTables.CABALTYP );
      _jspx_th_impact_codeArray_1.setArrayName( CodesTables.CABALTYP );
      _jspx_th_impact_codeArray_1.setBlankValue("true");
      int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
      if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n function resetAllegMalCode()\r\n {\r\n   if ( document.frmAllegationDetail.selSzCdIntakeAllegType.value != null)\r\n   {\r\n     var malCode = document.frmAllegationDetail.selSzCdIntakeAllegType.value;\r\n     \r\n     if ( document.frmAllegationDetail.maltreatmentType.value != \"\" )\r\n     {\r\n       malCode = document.frmAllegationDetail.maltreatmentType.value;\r\n     }\r\n       \r\n     var codeArray1 = ");
      out.print( CodesTables.CMALCODE );
      out.write(";       \r\n     var codeArray2 = ");
      out.print( CodesTables.CABALTYP );
      out.write(";\r\n     \r\n     for (var q=0; q < codeArray1.length; q++)\r\n     {\r\n      var code = codeArray1[q].substring(0,codeArray1[q].indexOf(\"|\"));\r\n      var decode = codeArray1[q].substring( codeArray1[q].indexOf(\"|\")+1, codeArray1[q].length);\r\n         if ( code ==  malCode )\r\n          {\r\n            document.frmAllegationDetail.selSzCdIntakeAllegMalCode.value = code;\r\n            \r\n           \r\n          }\r\n     } \r\n          \r\n     //populateDropdown( frmAllegationDetail.selSzCdIntakeAllegType , \"\", ");
      out.print( CodesTables.CABALTYP );
      out.write(" );\r\n     populateDropdownDecode(frmAllegationDetail.selSzCdIntakeAllegType, ");
      out.print( request.getParameter("selSzCdIntakeAllegType"));
      out.write(" ,  ");
      out.print( CodesTables.CABALTYP );
      out.write(", true);\r\n          \r\n     for (var q=0; q < codeArray2.length; q++)\r\n     {\r\n      var code = codeArray2[q].substring(0,codeArray2[q].indexOf(\"|\"));\r\n      var decode = codeArray2[q].substring( codeArray2[q].indexOf(\"|\")+1, codeArray2[q].length);\r\n         if ( code.a( 0, 1 ) ==  malCode.substring( 0, 1 ) )\r\n          {\r\n            document.frmAllegationDetail.selSzCdIntakeAllegType.value = code;\r\n           \r\n          }\r\n      }\r\n    }  \r\n } \r\n\r\n function filterMaltreatmentCode()\r\n {  \r\n \r\n   var maltreatmentTypeFilter = document.frmAllegationDetail.selSzCdIntakeAllegType.value;\r\n   \r\n   if ( maltreatmentTypeFilter == \"\" )\r\n   {\r\n      clearDropdown( frmAllegationDetail.selSzCdAllegMalCode );\r\n   }\r\n   else\r\n    {\r\n     //populateDropdown( frmAllegationDetail.selSzCdIntakeAllegMalCode , \"\", ");
      out.print( CodesTables.CMALCODE );
      out.write(" );\r\n       \r\n       populateDropdownDecode(frmAllegationDetail.selSzCdIntakeAllegMalCode, \"\" ,  ");
      out.print( CodesTables.CMALCODE );
      out.write(", true);     \r\n       \r\n     var codeArray = ");
      out.print( CodesTables.CMALCODE );
      out.write(";\r\n     var count = 1;\r\n     \r\n     for (var q=0; q < codeArray.length; q++)\r\n     {\r\n       //  Get the code from the codeArray we are filtering\r\n      var code = codeArray[q].substring(0,codeArray[q].indexOf(\"|\"));\r\n      //  Get the decode from the codeArray we are filtering\r\n      var decode = codeArray[q].substring( codeArray[q].indexOf(\"|\")+1, codeArray[q].length);\r\n      //  If the code contains the filter key and the key is not empty string\r\n      //  add the code to the filtered list\r\n         if ( code.substring( 0, 1 ) ==  maltreatmentTypeFilter.substring( 0, 1 ) )\r\n          {\r\n           //  Add the code and decode to the filtered list\r\n            document.frmAllegationDetail.selSzCdIntakeAllegMalCode.options[count].value = code;\r\n            document.frmAllegationDetail.selSzCdIntakeAllegMalCode.options[count].text  = code+ \" \" +decode;\r\n            //document.frmAllegationDetail.selSzCdIntakeAllegMalCode.options[count].value=codeArray[q];\r\n            count++;\r\n          }\r\n     }\r\n         document.frmAllegationDetail.selSzCdIntakeAllegMalCode.options.length = count;\r\n");
      out.write("         \r\n    }\r\n    \r\n }\r\n \r\n function setUpdateMaltreatInCare() {\r\n   document.frmAllegationDetail.hdnUpdateMaltreatInCare.value = 'N';\r\n   return true;\r\n }\r\n \r\n function displayODISPolicy() {\r\n  var descriptor = \"\";\r\n  descriptor += \"width=700,\";\r\n  descriptor += \"height=475,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=0,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=0,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=0,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=0,\";\r\n  descriptor += \"toolbar=0\";\r\n  if (document.frmAllegationDetail.hdnLocationAnchor.value != \"\") {\r\n    return window.open('/intake/IntakeActions/displayLocOfMalHelp'+'#'+document.frmAllegationDetail.hdnLocationAnchor.value, \"DFCS_FACILITY_DESC\", descriptor);\r\n  }\r\n }\r\n \r\n function setAnchor() {\r\n   var anchorPoint = \"\";\r\n   var malLocation = document.frmAllegationDetail.selSzCdAllegedMalLocation.value;\r\n   if (malLocation == '011' || malLocation == '020') {\r\n");
      out.write("     anchorPoint = 'resFacilities';\r\n   } else if (malLocation == '007' || malLocation == '010' || malLocation == '012' || malLocation == '014' \r\n                                   || malLocation == '016' || malLocation == '018') {\r\n     anchorPoint = 'dfcsHomes';\r\n   } else if (malLocation == '008' || malLocation == '019') {\r\n     anchorPoint = 'nonDfcsHomes';\r\n   } else if (malLocation == '009') {\r\n     anchorPoint = 'schools';\r\n   } else if (malLocation == '013') {\r\n     anchorPoint = 'nonResFacilities';\r\n   } else{\r\n   \t anchorPoint = 'dfcsHomes';\r\n   }\r\n   document.frmAllegationDetail.hdnLocationAnchor.value = anchorPoint;\r\n }\r\n ");

// STGAP00005876 : 
// If we are in Modify mode,  onload of the Page should call the filterMaltreatmentCode()
// to filter the MaltreatmentCode values according to the MaltreatmentType 
// that was previously saved.
  if (pageMode.equals(PageModeConstants.MODIFY))
{
 

      out.write("\r\n   window.onload = function ()\r\n{\r\nvar maltreatmentCode = document.frmAllegationDetail.selSzCdIntakeAllegMalCode.value;\r\nfilterMaltreatmentCode();\r\nfrmAllegationDetail.selSzCdIntakeAllegMalCode.value = maltreatmentCode;\r\n}   \r\n");

}

      out.write("\r\n \r\n</script>\r\n\r\n");
 if (!"Y".equals(warnMaltreatmentInCare)) { 
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
} 
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAllegationDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/intake/IntakeActions/displayAllegationDetail");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.intake.AllegationDetailCustomValidation");
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
          _jspx_th_impact_validateInput_0.setName("hdnCTxtIntakeAllegDuration");
          _jspx_th_impact_validateInput_0.setValue( FormattingHelper.formatString( allegListRow.getCTxtIntakeAllegDuration() ));
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
          _jspx_th_impact_validateInput_1.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatDate( allegListRow.getTsLastUpdate() ) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnUlIdAllegation");
          _jspx_th_impact_validateInput_2.setValue( String.valueOf( allegListRow.getUlIdAllegation() ) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnIndIncmgMaltreatInCare");
          _jspx_th_impact_validateInput_5.setValue( allegListRow.getCIndIncmgMaltreatInCare() );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
/* The hidden value incomingStatus is used on the Allegation Detail page.  If the user enters the intake
     in approval mode and they are NOT the approver, if the user saves the Allegation Detail page, we should
     invalidate the pending approval.  The allegation_AUD() method uses the value for hdnIncomingStatus
     to determine whether we should invalidate the pending approval or not.  This value is passed from
     a hidden field on the Intake Actions page. */
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnIncomingStatus");
          _jspx_th_impact_validateInput_6.setValue( request.getParameter("hdnIncomingStatus") );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

//*******************************************************************************
//******************************** ALLEGATION  DETAIL ***************************
//*******************************************************************************

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr class=\"subDetail\">\r\n    <th colspan=\"4\">Allegation Detail</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td width=\"23%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setStyle("width:150px");
          _jspx_th_impact_validateSelect_0.setLabel("Alleged Maltreated Child");
          _jspx_th_impact_validateSelect_0.setName("selUlIdVictim");
          _jspx_th_impact_validateSelect_0.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue( victSel );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setOptions(allegedVictimVector);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("&nbsp;&nbsp;&nbsp;&nbsp;Date of Alleged Incident");
          _jspx_th_impact_validateDate_0.setName("selDtDtAllegedIncident");
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(allegListRow.getDtDtAllegedIncident()) );
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n                              ");
          out.write("\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n");
 /* SIR 22616 -- Added ExcludeOptions */ 
          out.write("\r\n    <td width=\"23%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setStyle("width:180px");
          _jspx_th_impact_validateSelect_1.setExcludeOptions( excludeAlleg );
          _jspx_th_impact_validateSelect_1.setLabel("Maltreatment Type");
          _jspx_th_impact_validateSelect_1.setName("selSzCdIntakeAllegType");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( allegListRow.getSzCdIntakeAllegType() );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CABALTYP );
          _jspx_th_impact_validateSelect_1.setContentType( SelectTag.CODES_DECODES);
          _jspx_th_impact_validateSelect_1.setOnChange("filterMaltreatmentCode();");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>                                   \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setStyle("width:220px");
          _jspx_th_impact_validateSelect_2.setLabel("Maltreatment Code");
          _jspx_th_impact_validateSelect_2.setName("selSzCdIntakeAllegMalCode");
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setContentType( SelectTag.CODES_DECODES);
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CMALCODE );
          _jspx_th_impact_validateSelect_2.setValue( allegListRow.getSzCdIntakeAllegMalCode());
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n                          ");
          out.write("\r\n  </tr>\r\n  ");
boolean hideRelationship = false;
  if(request.getAttribute("INTStageClosed") !=  null && StringHelper.isTrue((String)request.getAttribute("INTStageClosed"))){
     hideRelationship = true;
   }
   
          out.write("\r\n  <tr class=\"subDetail\">\r\n  ");
if(!hideRelationship){  
          out.write("\r\n    <td width=\"23%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setExcludeOptions( excludeRelationship );
          _jspx_th_impact_validateSelect_3.setLabel("&nbsp;&nbsp;&nbsp;&nbsp;Alleged Maltreator Relationship");
          _jspx_th_impact_validateSelect_3.setName("selSzCdMaltreatorRel");
          _jspx_th_impact_validateSelect_3.setValue( allegListRow.getSzCdMaltreatorRel() );
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CRPTRINT );
          _jspx_th_impact_validateSelect_3.setContentType( SelectTag.CODES_DECODES);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   <td colspan=\"2\">&nbsp;</td>\r\n   ");
} 
          out.write("\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n   <td colspan=\"4\">\r\n   <table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\">\r\n     <tr>\r\n       <td width=\"23%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Where did the Maltreatment occur?");
          _jspx_th_impact_validateSelect_4.setName("selSzCdAllegedMalLocation");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setValue( allegListRow.getSzCdAllegedMalLocation() );
          _jspx_th_impact_validateSelect_4.setOnChange("setAnchor()");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setOrderBy( SelectTag.DECODE_ORDERBY );
          _jspx_th_impact_validateSelect_4.setCodesTable( CodesTables.CLOCMAL );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                               \r\n      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayODISPolicy()\">?</a></strong>                               \r\n      </td>                            \r\n    </tr>\r\n  </table>\r\n  </td>\r\n</tr>\r\n</table>\r\n                        \r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n");

String newAlleg = "false";
if (allegListRow.getUlIdAllegation() == 0)
{
  newAlleg = "true";
}

          out.write("\r\n    <td width=\"85%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDeleteFromDetail");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setForm("frmAllegationDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/intake/IntakeActions/deleteAllegationFromDetail");
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteAllegationConfirm();");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setDisabled( newAlleg );
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"5%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setForm("frmAllegationDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/intake/IntakeActions/saveAndAddAllegation");
          _jspx_th_impact_ButtonTag_1.setFunction("return setUpdateMaltreatInCare();");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"10%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnContinue");
          _jspx_th_impact_ButtonTag_2.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_2.setAlign("left");
          _jspx_th_impact_ButtonTag_2.setForm("frmAllegationDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/intake/IntakeActions/saveAndContinueAllegation");
          _jspx_th_impact_ButtonTag_2.setFunction("return setUpdateMaltreatInCare();");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(false);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n\r\n<input type=\"hidden\" name=\"maltreatmentType\" value=\"");
          out.print( allegListRow.getSzCdIntakeAllegType() );
          out.write("\">\r\n\r\n");
          out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n   \r\n   //filterMaltreatmentCode();\r\n   //resetAllegMalCode(); \r\nvar saveAndAddButtonClicked;\r\nvar saveAndContClicked;\r\nwindow.onload = function ()\r\n{\r\n  setAnchor();\r\n  ");

  String previousURL = (String) request.getParameter("FormValidationPrevUrl");
  if ("Y".equals(warnMaltreatmentInCare) && (!"/intake/IntakeActions/displayIntakeActions".equals(previousURL))) {
  
          out.write("\r\n    document.frmAllegationDetail.hdnIndIncmgMaltreatInCare.value = '");
          out.print( indMaltreatInCare );
          out.write("';\r\n    saveAndAddButtonClicked = '");
          out.print( StringHelper.isValid(request.getParameter("btnAdd" + ".x")));
          out.write("';\r\n    saveAndContClicked = '");
          out.print( StringHelper.isValid(request.getParameter("btnContinue" + ".x")));
          out.write("';\r\n    confirmMaltreatmentInCare();\r\n  ");

  }
  
          out.write("\r\n}\r\n</script>\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");

}

      out.write("\r\n\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnUpdateMaltreatInCare");
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
    _jspx_th_impact_validateInput_4.setName("hdnLocationAnchor");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
