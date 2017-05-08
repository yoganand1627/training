package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Chb;

public final class PersonCharDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*  JSP Name:     Person Characteristics
      //*  Created by:   Anna Grimshaw
      //*  Date Created: 11/15/2002
      //*
      //*  Description:
      //*  This JSP is used to maintain a Person's Characteristics
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  08/26/03  A.Corley          SIR 19533 Give the no chars app a value so that
      //**                              validation can handle it correctly.
      //**
      //**  03/13/07  N.Hegde           Added adoption section
      //**  07/30/09  bgehlot           STGAP00014806: Page is in view mode for the SAU_EXCHANGE
      //**  09/21/09  mxpatel           STGAP00015376: added code so that if the SAU_EXCHANGE has stage access then they can
      //**                              modify the person characteristics page. Also made sure there were no JavaScript errors on the page.
      //**  11/10/10  schoi 			SMS #81140: MR-074 Added two new fields for AFCARS Phase 1 Change
      //**  12/01/10  schoi 			SMS #81140: MR-074 Added JavaScript to enable dynamic radio button change
      //**  12/03/10  htvo              SMS #81140: MR-074 AFCARS: modified js to disable single parent adoption type when it is not single
      //**                              parent adoption.
      //**  12/04/10  htvo              SMS #81140: MR-074 AFCARS: added validation on No/Unknown on Previously Adopted to warn user that dependent 
      //**                              information will be cleared. Ok will clear data and disable fields. Cancel will set previous selection back.
      //**                              Make sure the field not already disabled before disable a field, to avoid js error on the page. When a fied is disabled, the name changed.
      //**  12/22/10 htvo               SMS #81140: MR-074 AFCARS: added Save confirmation: for existing data that has mismatch between 
      //**                              previously adoption indicator and previous adoption date, warn user that the previous adoption date will be cleared 
      //**  09/12/11  charden           STGAP00017058 - adding help icon to page
      //**  10/24/11 hnguyen            STGAP00017351:MR-092 IVE in prior adoption added Unknown radio.
      //**  11/07/11 hnguyen            STGAP00017351: MR-092 Updated javascript to disable new IVE in Prior Adoption Unknown radio.

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                    .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      CINV24SO cinv24so = (CINV24SO) request.getAttribute("CINV24SO");
      List cpmValues = (List) request.getAttribute("cpmValues");
      List chbValues = (List) request.getAttribute("chbValues");
      List cmeValues = (List) request.getAttribute("cmeValues");
      List othValues = (List) request.getAttribute("othValues");
      List cctValues = (List) request.getAttribute("cctValues");
            
      int age = PersonDetailConversation.getAge(request);

      String cReqFuncCd = ContextHelper.getStringSafe(request, "cReqFuncCd");
      String PrevAdopt_Yes = ArchitectureConstants.FALSE;
      String PrevAdopt_No =  ArchitectureConstants.FALSE;
      String PrevAdopt_Un =  ArchitectureConstants.FALSE;
      String County = "";
      String State = "";
      String Country = "";
      String intAdopt = "";
      String privateAdopt = "";
      String publicAdopt = "";
      String adoptDislutn = "";
      String PrevAdopt = "";
      String PublicAdopt_P = ArchitectureConstants.FALSE;
      String PrivateAdopt_R = ArchitectureConstants.FALSE;
      String IntAdopt_I = ArchitectureConstants.FALSE;     
      //String txtPrevAdopt = FormattingHelper.formatDate(cinv24so.getTxtPrevAdopt() );      
      String txtPrevAdopt = "";
      String txtDissolutionDate = FormattingHelper.formatDate(cinv24so.getTxtDissolutionDate() );
      // SMS #81140: MR-074
      String TxtSinglePrAdo = "";
      String TxtSingleMomOrFar = "";
      String indIVEPriorAdoption = "";
      
      boolean bNoneDiagnosed = false;
      boolean bNotYetDiagnosed = false;
      String  bdispAdopt= "";
      String comments = cinv24so.getSzTxtCharCmnts();
      String agentName = cinv24so.getSzAgency();
      if(comments == null)
      {
        comments = "";
      }
      if(agentName == null)
      {
        agentName = "";
      }      
      County = cinv24so.getSzCdCounty();
      State = cinv24so.getSzCdState();
      Country = cinv24so.getSzCdCntry();


       if(cinv24so.getIndPublicAdoptn()!=null)
       {  
         publicAdopt = cinv24so.getIndPublicAdoptn();
       }  
       if(cinv24so.getIndAdoptnDislutn()!=null)
       {   
         adoptDislutn = cinv24so.getIndAdoptnDislutn();
       }  
       if(cinv24so.getIndPrevAdopt()!=null)
       { 
         PrevAdopt= cinv24so.getIndPrevAdopt();
       }  
      
         if (PrevAdopt != null)
        {
          if (PrevAdopt.equals("N")) {
         PrevAdopt_No = "true";
           } else if (PrevAdopt.equals("Y")){
         PrevAdopt_Yes = "true";
         }else if (PrevAdopt.equals("U")){
            PrevAdopt_Un = "true";
         } 
       } 
  
		// SMS #81140: MR-074
		if (cinv24so.getTxtPrevAdopt() != null)
       	{
       		txtPrevAdopt = FormattingHelper.formatDate(cinv24so.getTxtPrevAdopt() );
       	} 
       	if (cinv24so.getIndSingleParAdpt() != null)
       	{
       		TxtSinglePrAdo = cinv24so.getIndSingleParAdpt();
       	}   
       	if (cinv24so.getSzCdSngleMomOrFar() != null)
       	{
       		TxtSingleMomOrFar = cinv24so.getSzCdSngleMomOrFar();
       	}
       	if (cinv24so.getBIndIVEPriorAdoption() != null)
       	{
       		indIVEPriorAdoption = cinv24so.getBIndIVEPriorAdoption();
       	} 
       	
       
       // JDD change to make checkboxes to rado buttons
         if (publicAdopt != null)
        {
          if (publicAdopt.equals("P")) {
         PublicAdopt_P = "true";
           } else if (publicAdopt.equals("R")){
         PrivateAdopt_R = "true";
         }else if (publicAdopt.equals("I")){
            IntAdopt_I = "true";
         } 
       } 
            
      // If BCdPersonChar or BCdPersonCharNDiag are returned as true, set a variable so the no characteristics
      // checkbox will be checked.
      if ("2".equals(cinv24so.getBCdPersonChar())) {
        bNoneDiagnosed = true;
        bNotYetDiagnosed = false;
      } else if ("3".equals(cinv24so.getBCdPersonChar())) {
        bNotYetDiagnosed = true;
        bNoneDiagnosed = false;
      } else {
        bNoneDiagnosed = false;
        bNotYetDiagnosed = false;
      }

      if (cinv24so == null) {
        cinv24so = new CINV24SO();
        cinv24so.setSzTxtCharCmnts(ContextHelper.getStringSafe(request, "szTxtCharCmnts"));
      }

      //boolean displayAPS =
      //PersonDetailConversation.displayAPSCharacteristics(request);

      boolean displayParent = PersonDetailConversation.displayParentCharacteristics(request);

      //boolean displayChildPlacement =
      //PersonDetailConversation.displayChildPlacementCharacteristics(request);

      boolean displayChildInvest = PersonDetailConversation.displayChildInvestCharacteristics(request);
       if(displayChildInvest){
       bdispAdopt = "Y";
           }
      
      out.write('\r');
      out.write('\n');
/* Start Javascript Section */

      
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n// SMS #81140: MR-074\r\n\r\n");
 String message = ""; 
      out.write("\r\nvar actingOut = '");
      out.print( Lookup.simpleDecodeSafe(Chb.CHB, "70") );
      out.write("';\r\n\r\n// STGAP00017058 - creating function to bypass architectural constraints\r\nfunction addQuestionMark(){\r\n\t// get all table cells in the document\r\n\tvar cells = document.frmCharDetail.getElementsByTagName('td');\r\n\r\n\t// check each cell to add the help icon \r\n\tfor(var i = 0; i < cells.length; i++){\r\n\t\tvar cell = cells[i];\r\n\t\tvar inner = cell.innerHTML;\r\n\t\tif(actingOut == inner){\r\n\t\t\tcell.innerHTML = inner + '&nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayHelp()\">?</a></strong>';\r\n\t\t\tbreak;\r\n\t\t}\r\n\t}\r\n}\r\n\r\n// STGAP00017058 - this function launches the help window\r\nfunction displayHelp(){\r\n  var descriptor = \"\";\r\n  \r\n  // describe the window properties\r\n  descriptor += \"width=450,\";\r\n  descriptor += \"height=350,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=1,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=1,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=1,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=1,\";\r\n");
      out.write("  descriptor += \"toolbar=0\";\r\n  \r\n  // open person characteristic help page\r\n  return window.open('/person/PersonDetail/displayPersonCharacteristicsHelp', \"\", descriptor);\r\n}\r\n// clear and disable the Single Mother or Father adoption when it is not a Single Parent Adoption type\r\n// no warning because there is no important data being cleared\r\nfunction clearSingleParent() \r\n{ \r\n  var rbSingleAdoptGroup = eval(\"document.frmCharDetail.\" + \"");
      out.print( PersonDetailConversation.RADIO_SINGLE_PAR_ADPT );
      out.write("\");    \r\n  var rbSingleAdoptGroupValue = getSelectedRadioValue( rbSingleAdoptGroup );\r\n  var rbSingleParentGroup = eval(\"document.frmCharDetail.\" + \"");
      out.print( PersonDetailConversation.RADIO_SINGLE_MOM_OR_FAR );
      out.write("\");    \r\n   if ( rbSingleAdoptGroupValue == \"N\" )\r\n   { \r\n     rbSingleParentGroup.value = '';\r\n     for( var i = 0; i < rbSingleParentGroup.length; i++ ){\r\n        rbSingleParentGroup[i].checked = false;\r\n        rbSingleParentGroup[i].disabled = true;\r\n      }\r\n   } else if ( rbSingleAdoptGroupValue == \"Y\" )\r\n   { \r\n     for( var i = 0; i < rbSingleParentGroup.length; i++ ){\r\n        rbSingleParentGroup[i].disabled = false;\r\n      }\r\n   }\r\n} \r\n\r\n// confirm a No or Unknown selection will clear and diasble all Date of Previously Adopted and Single Parent fields\r\nfunction confirmPrevAdopted() {\r\n  var bConfirmClearPrevAdoption;\r\n  var rbPrevAdoptGroup = eval(\"document.frmCharDetail.rbPrevAdopt\"); \r\n  var rbPrevAdoptGroupValue = getSelectedRadioValue( rbPrevAdoptGroup );\r\n  if (rbPrevAdoptGroupValue==\"N\" || rbPrevAdoptGroupValue==\"U\") {\r\n  ");
    
  message = "Selecting No or Unknown for Previously Adopted will clear and/or disable the Date of Previous Adoption and Single Parent adoption fields." ;
  
      out.write("\r\n  bConfirmClearPrevAdoption = confirm(\"");
      out.print( message );
      out.write("\");\r\n  if (bConfirmClearPrevAdoption == true) {\r\n    // clear date of previously adopted and disable the field\r\n    document.frmCharDetail.txtPrevAdopt.value = '';\r\n    if (document.frmCharDetail.txtPrevAdopt) {\r\n    document.frmCharDetail.txtPrevAdopt.disabled = true;\r\n    }\r\n    // clear Single Parent fields and disable the fields\r\n    document.frmCharDetail.rbSinglePrAdo[0].checked = false;\r\n    document.frmCharDetail.rbSinglePrAdo[1].checked = false;\r\n    document.frmCharDetail.rbSingleMomOrFar[0].checked = false; \r\n    document.frmCharDetail.rbSingleMomOrFar[1].checked = false; \r\n    if (document.frmCharDetail.rbSinglePrAdo) {\r\n    document.frmCharDetail.rbSinglePrAdo[0].disabled = true;\r\n    document.frmCharDetail.rbSinglePrAdo[1].disabled = true;\r\n    }\r\n    if (document.frmCharDetail.rbSingleMomOrFar) {\r\n    document.frmCharDetail.rbSingleMomOrFar[0].disabled = true;\r\n    document.frmCharDetail.rbSingleMomOrFar[1].disabled = true;   \r\n    }\r\n    // clear IV-E Prior Adoption fields and disable the fields\r\n");
      out.write("    document.frmCharDetail.rbIVEPriorAdoption[0].checked = false;\r\n    document.frmCharDetail.rbIVEPriorAdoption[1].checked = false;\r\n    if (document.frmCharDetail.rbIVEPriorAdoption) {\r\n    document.frmCharDetail.rbIVEPriorAdoption[0].disabled = true;\r\n    document.frmCharDetail.rbIVEPriorAdoption[1].disabled = true;   \r\n    } \r\n  } else {\r\n    // @todo: this really needs clean up later to make it independent of radio option order and value\r\n    var prev = document.frmCharDetail.hdnCbxPrevAdopt.value;\r\n    if (prev==\"Y\") {\r\n      document.frmCharDetail.rbPrevAdopt[0].checked = true; // set back to Yes\r\n      document.frmCharDetail.rbPrevAdopt[1].checked = false; // clear No in case it is No selected and is being canceled\r\n      document.frmCharDetail.rbPrevAdopt[2].checked = false; // clear Unknown \r\n    } else if (prev==\"N\") {\r\n      document.frmCharDetail.rbPrevAdopt[1].checked = true; // \r\n      disableDatePreviouslyAdoptedAndSingleParent();\r\n    } else if (prev==\"U\") {\r\n      document.frmCharDetail.rbPrevAdopt[2].checked = true; // set back to Unknown \r\n");
      out.write("      disableDatePreviouslyAdoptedAndSingleParent();\r\n    }\r\n  }\r\n  // Enable the Date of Previous Adoption, Single Parent adoption and IV-E Prior Adoption \r\n  // fields if Previously Adoption is Yes\r\n  } else {\r\n    document.frmCharDetail.txtPrevAdopt.disabled = false;\r\n    document.frmCharDetail.rbSinglePrAdo[0].disabled = false;\r\n    document.frmCharDetail.rbSinglePrAdo[1].disabled = false;\r\n    document.frmCharDetail.rbSingleMomOrFar[0].disabled = false;\r\n    document.frmCharDetail.rbSingleMomOrFar[1].disabled = false;\r\n    document.frmCharDetail.rbIVEPriorAdoption[0].disabled = false;\r\n    document.frmCharDetail.rbIVEPriorAdoption[1].disabled = false;\r\n  }\r\n}\r\n// disable the Date of Previous Adoption, Single Parent adoption and IV-E Prior Adoption \r\n// fields when Previously Adoption is No or Unknown\r\nfunction disableDatePreviouslyAdoptedAndSingleParent() {\r\n  var p = getSelectedRadioValue(document.frmCharDetail.rbPrevAdopt);\r\n  if (p==\"N\" || p==\"U\") {\r\n    if (document.frmCharDetail.txtPrevAdopt) { // make sure the field not already disable to avoid js error on the page\r\n");
      out.write("    document.frmCharDetail.txtPrevAdopt.disabled = true;\r\n    }\r\n    if (document.frmCharDetail.rbSinglePrAdo) {\r\n    document.frmCharDetail.rbSinglePrAdo[0].disabled = true;\r\n    document.frmCharDetail.rbSinglePrAdo[1].disabled = true;\r\n    }\r\n    if (document.frmCharDetail.rbSingleMomOrFar) {\r\n    document.frmCharDetail.rbSingleMomOrFar[0].disabled = true;\r\n    document.frmCharDetail.rbSingleMomOrFar[1].disabled = true;\r\n    }\r\n    if (document.frmCharDetail.rbIVEPriorAdoption) {\r\n    document.frmCharDetail.rbIVEPriorAdoption[0].disabled = true;\r\n    document.frmCharDetail.rbIVEPriorAdoption[1].disabled = true;   \r\n    document.frmCharDetail.rbIVEPriorAdoption[2].disabled = true;   \r\n    } \r\n  }\r\n}\r\n// set the current checkbox value before change\r\nfunction setCurrentValue(value) {\r\n  var hdnCbxPrevAdopt = document.frmCharDetail.hdnCbxPrevAdopt;\r\n  hdnCbxPrevAdopt.value = value;\r\n  eval(hdnCbxPrevAdopt);\r\n}\r\n\r\nfunction confirmSave() {\r\n  var bConfirmClearPrevAdoption;\r\n  var rbPrevAdoptGroup = eval(\"document.frmCharDetail.rbPrevAdopt\"); \r\n");
      out.write("  var rbPrevAdoptGroupValue = getSelectedRadioValue( rbPrevAdoptGroup );\r\n  \r\n  var dtPrevAdoptValue = document.frmCharDetail.txtPrevAdopt.value; \r\n  var rbSingleAdopt = eval(\"document.frmCharDetail.rbSinglePrAdo\"); \r\n  var rbSingleAdoptValue = getSelectedRadioValue( rbSingleAdopt );\r\n  var rbSingleAdoptType = eval(\"document.frmCharDetail.rbSingleMomOrFar\"); \r\n  var rbSingleAdoptTypeValue = getSelectedRadioValue( rbSingleAdoptType );\r\n  \r\n  // Only show warning when there is values in the dependent fields that causes conflict\r\n  if ((rbPrevAdoptGroupValue==\"N\" || rbPrevAdoptGroupValue==\"U\") && \r\n  (dtPrevAdoptValue != \"\" || rbSingleAdoptValue != \"\" || rbSingleAdoptTypeValue != \"\")) {\r\n  ");
    
  message = "Selecting No or Unknown for Previously Adopted will clear the Date of Previous Adoption and/or Single Parent adoption fields." ;
  
      out.write("\r\n  return confirm(\"");
      out.print( message );
      out.write("\");\r\n  }\r\n  else {\r\n    return true;\r\n  }\r\n}\r\n// End MR-074 AFCARS\r\n \r\n// This javascript disables and de-checks all characteristic checkboxes if\r\n// the \"no characteristics\" or \"not yet diagonized checkbox have been selected.  It enables all check\r\n// boxes if the \"no characteristics\" or \"not yet diagonized checkbox have been de-selected.\r\nfunction setNoChar()\r\n{\r\n  if (frmCharDetail.cbxBCdPersonChar.checked == true) \r\n  {\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( displayChildInvest );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    disableCheckboxes(\"frmCharDetail.cbxCPM\", '");
          out.print( Lookup.getCategoryCollection("CPM").size() );
          out.write("');\r\n    disableCheckboxes(\"frmCharDetail.cbxCHB\", '");
          out.print( Lookup.getCategoryCollection("CHB").size() );
          out.write("');\r\n    disableCheckboxes(\"frmCharDetail.cbxCME\", '");
          out.print( Lookup.getCategoryCollection("CME").size() );
          out.write("');\r\n    disableCheckboxes(\"frmCharDetail.cbxOTH\", '");
          out.print( Lookup.getCategoryCollection("OTH").size() );
          out.write("');\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_1.setParent(null);
      _jspx_th_impact_ifThen_1.setTest( displayParent );
      int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
      if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    disableCheckboxes(\"frmCharDetail.cbxCCT\", '");
          out.print( Lookup.getCategoryCollection("CCT").size() );
          out.write("');\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  frmCharDetail.cbxBCdPersonCharNDiog.disabled = true;\r\n  }\r\n  else if(frmCharDetail.cbxBCdPersonCharNDiog.checked == true) \r\n  {\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_2.setParent(null);
      _jspx_th_impact_ifThen_2.setTest( displayChildInvest );
      int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
      if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    disableCheckboxes(\"frmCharDetail.cbxCPM\", '");
          out.print( Lookup.getCategoryCollection("CPM").size() );
          out.write("');\r\n    disableCheckboxes(\"frmCharDetail.cbxCHB\", '");
          out.print( Lookup.getCategoryCollection("CHB").size() );
          out.write("');\r\n    disableCheckboxes(\"frmCharDetail.cbxCME\", '");
          out.print( Lookup.getCategoryCollection("CME").size() );
          out.write("');\r\n    disableCheckboxes(\"frmCharDetail.cbxOTH\", '");
          out.print( Lookup.getCategoryCollection("OTH").size() );
          out.write("');\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_3.setParent(null);
      _jspx_th_impact_ifThen_3.setTest( displayParent );
      int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
      if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    disableCheckboxes(\"frmCharDetail.cbxCCT\", '");
          out.print( Lookup.getCategoryCollection("CCT").size() );
          out.write("');\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  frmCharDetail.cbxBCdPersonChar.disabled = true;\r\n  }\r\n  else\r\n  {\r\n      //frmCharDetail.aged.value = \"N\";\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_4.setParent(null);
      _jspx_th_impact_ifThen_4.setTest( displayChildInvest );
      int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
      if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    enableCheckboxes(\"frmCharDetail.cbxCPM\", '");
          out.print( Lookup.getCategoryCollection("CPM").size() );
          out.write("');\r\n    enableCheckboxes(\"frmCharDetail.cbxCHB\", '");
          out.print( Lookup.getCategoryCollection("CHB").size() );
          out.write("');\r\n    enableCheckboxes(\"frmCharDetail.cbxCME\", '");
          out.print( Lookup.getCategoryCollection("CME").size() );
          out.write("');\r\n    enableCheckboxes(\"frmCharDetail.cbxOTH\", '");
          out.print( Lookup.getCategoryCollection("OTH").size() );
          out.write("');\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_5.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_5.setParent(null);
      _jspx_th_impact_ifThen_5.setTest( displayParent );
      int _jspx_eval_impact_ifThen_5 = _jspx_th_impact_ifThen_5.doStartTag();
      if (_jspx_eval_impact_ifThen_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    enableCheckboxes(\"frmCharDetail.cbxCCT\", '");
          out.print( Lookup.getCategoryCollection("CCT").size() );
          out.write("');\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\nfrmCharDetail.cbxBCdPersonCharNDiog.disabled = false;\r\nfrmCharDetail.cbxBCdPersonChar.disabled = false;\r\n\r\n  }\r\n}\r\n\r\n\r\nfunction disableCheckboxes(prefix, size)\r\n{\r\n  for (i = 1; i <= size; i++)\r\n  {\r\n    var checkboxName = prefix + i;\r\n    eval(checkboxName + \".disabled = true\");\r\n    eval(checkboxName + \".checked = false\");\r\n  }\r\n}\r\n\r\n\r\nfunction enableCheckboxes(prefix, size)\r\n{\r\n");

 if (!(user.hasRight(UserProfile.SEC_SAU_EXCHANGE) && !(GlobalData.hasStageAccess(request)))){
        
      out.write("\r\n      \r\n  for (i = 1; i <= size; i++)\r\n  {\r\n    var checkboxName = prefix + i;\r\n    eval(checkboxName + \".disabled = false\");\r\n  }\r\n");

  }

      out.write("\r\n}\r\n\r\nfunction confirmNoChar()\r\n{\r\n  if ((frmCharDetail.cbxBCdPersonChar.checked == true)||(frmCharDetail.cbxBCdPersonCharNDiog.checked == true))\r\n  {\r\n    var bNoChar;\r\n    ");

        //String message;
    
      out.write("\r\n    if (frmCharDetail.cbxBCdPersonChar.checked == true) {\r\n    ");
    
        message = "";
        message = MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_NO_CHARS) ;
        message = MessageLookup.addMessageParameter( message, "None Diagnosed" ); 
    
      out.write("\r\n        bNoChar = confirm(\"");
      out.print( message );
      out.write("\");\r\n    } else {\r\n    ");
    
        message = "";
        message = MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_NO_CHARS) ;
        message = MessageLookup.addMessageParameter( message, "Not Yet Diagnosed" ); 
    
      out.write("\r\n        bNoChar = confirm(\"");
      out.print( message );
      out.write("\");\r\n    }\r\n    \r\n    if (bNoChar == true)\r\n    {\r\n      setNoChar();\r\n    }  else\r\n    {\r\n      frmCharDetail.cbxBCdPersonChar.checked = false;\r\n      frmCharDetail.cbxBCdPersonCharNDiog.checked = false;\r\n      \r\n    }\r\n  }\r\n  else\r\n  {\r\n    setNoChar();\r\n   }\r\n  }\r\n\r\n\r\n  \r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n//End Java Script\r\n</script>\r\n\r\n\r\n");
int tabIndex = 1;

      /**
       *  Page Mode Logic
       *
       *   1.  VIEW - Will have the following sets:
       *       a.  If the person has Maintain Person, or Merge Person
       *           Security attributes
       *   2.  EDIT -- Will have the following sets:
       *       a.  If the Person is the Primary worker, or in the Primary
       *           Hierarchy
       *
       * All of the Person Detail page modes other than View will be treated as Edit.
       *
       */

      String pageModePassed = "";
      String overallPageMode = PageModeConstants.EDIT;
      if (request.getAttribute("pageMode") != null) {
        pageModePassed = (String) request.getAttribute("pageMode");
        if (pageModePassed.equals(PageModeConstants.EDIT)) {
          overallPageMode = PageModeConstants.EDIT;
        } else if (pageModePassed.equals(PageModeConstants.VIEW)) {
          overallPageMode = PageModeConstants.VIEW;
        }
      }
      
      //STGAP00014806: Page is in view mode for the SAU_EXCHANGE
      if (user.hasRight(UserProfile.SEC_SAU_EXCHANGE) && !(GlobalData.hasStageAccess(request))){
        overallPageMode = PageModeConstants.VIEW;
      }

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCharDetail");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonDetail/savePersonChar");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.PersonCharCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_0.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnLNbrPersonAge");
          _jspx_th_impact_validateInput_1.setValue( "" + age );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdndisplayChildInvest");
          _jspx_th_impact_validateInput_3.setValue( bdispAdopt );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCbxPrevAdopt");
          _jspx_th_impact_validateInput_4.setValue(PrevAdopt );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\">\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:expandAll()\">Expand All</a>&nbsp; <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:collapseAll()\">Collapse All</a>&nbsp;\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  \r\n ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_6.setTest( displayChildInvest );
          int _jspx_eval_impact_ifThen_6 = _jspx_th_impact_ifThen_6.doStartTag();
          if (_jspx_eval_impact_ifThen_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_6);
              _jspx_th_impact_ExpandableSectionTag_0.setName("ChildPM");
              _jspx_th_impact_ExpandableSectionTag_0.setLabel( Lookup.simpleDecodeSafe("CCHRTCAT", "CPM"));
              _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n      <tr>\r\n        <td> \r\n          ");
                  //  impact:codesCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                  _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                  _jspx_th_impact_codesCheckbox_0.setDefaultCodes(cpmValues);
                  _jspx_th_impact_codesCheckbox_0.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_codesCheckbox_0.setName("cbxCPM");
                  _jspx_th_impact_codesCheckbox_0.setCodesTableName("CPM");
                  _jspx_th_impact_codesCheckbox_0.setColumns(2);
                  _jspx_th_impact_codesCheckbox_0.setTabIndex(1);
                  int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
                  if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        </td>\r\n      </tr>\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <br>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_7.setTest( displayParent );
          int _jspx_eval_impact_ifThen_7 = _jspx_th_impact_ifThen_7.doStartTag();
          if (_jspx_eval_impact_ifThen_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_7);
              _jspx_th_impact_ExpandableSectionTag_1.setName("Parent");
              _jspx_th_impact_ExpandableSectionTag_1.setLabel( Lookup.simpleDecodeSafe("CCHRTCAT", "CCT"));
              _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n      <tr>\r\n        <td>\r\n          ");
                  //  impact:codesCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                  _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
                  _jspx_th_impact_codesCheckbox_1.setDefaultCodes(cctValues);
                  _jspx_th_impact_codesCheckbox_1.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_codesCheckbox_1.setName("cbxCCT");
                  _jspx_th_impact_codesCheckbox_1.setCodesTableName("CCT");
                  _jspx_th_impact_codesCheckbox_1.setColumns(2);
                  _jspx_th_impact_codesCheckbox_1.setTabIndex(2);
                  int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
                  if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        </td>\r\n      </tr>\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <br>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n \r\n\r\n  \r\n  ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_8.setTest( displayChildInvest );
          int _jspx_eval_impact_ifThen_8 = _jspx_th_impact_ifThen_8.doStartTag();
          if (_jspx_eval_impact_ifThen_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_8);
              _jspx_th_impact_ExpandableSectionTag_2.setName("ChildHB");
              _jspx_th_impact_ExpandableSectionTag_2.setLabel( Lookup.simpleDecodeSafe("CCHRTCAT", "CHB"));
              _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n      <tr>\r\n        <td>\r\n          ");
                  //  impact:codesCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                  _jspx_th_impact_codesCheckbox_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_codesCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_codesCheckbox_2.setDefaultCodes(chbValues);
                  _jspx_th_impact_codesCheckbox_2.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_codesCheckbox_2.setName("cbxCHB");
                  _jspx_th_impact_codesCheckbox_2.setCodesTableName("CHB");
                  _jspx_th_impact_codesCheckbox_2.setColumns(2);
                  _jspx_th_impact_codesCheckbox_2.setTabIndex(3);
                  int _jspx_eval_impact_codesCheckbox_2 = _jspx_th_impact_codesCheckbox_2.doStartTag();
                  if (_jspx_th_impact_codesCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        </td>\r\n      </tr>\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <br>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_8.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\r\n  ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_9.setTest( displayChildInvest );
          int _jspx_eval_impact_ifThen_9 = _jspx_th_impact_ifThen_9.doStartTag();
          if (_jspx_eval_impact_ifThen_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_9);
              _jspx_th_impact_ExpandableSectionTag_3.setName("ChildME");
              _jspx_th_impact_ExpandableSectionTag_3.setLabel( Lookup.simpleDecodeSafe("CCHRTCAT", "CME"));
              _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n      <tr>\r\n        <td>\r\n          ");
                  //  impact:codesCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                  _jspx_th_impact_codesCheckbox_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_codesCheckbox_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_codesCheckbox_3.setDefaultCodes(cmeValues);
                  _jspx_th_impact_codesCheckbox_3.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_codesCheckbox_3.setName("cbxCME");
                  _jspx_th_impact_codesCheckbox_3.setCodesTableName("CME");
                  _jspx_th_impact_codesCheckbox_3.setColumns(2);
                  _jspx_th_impact_codesCheckbox_3.setTabIndex(4);
                  int _jspx_eval_impact_codesCheckbox_3 = _jspx_th_impact_codesCheckbox_3.doStartTag();
                  if (_jspx_th_impact_codesCheckbox_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        </td>\r\n      </tr>\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <br>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_9.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\r\n  ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_10.setTest( displayChildInvest );
          int _jspx_eval_impact_ifThen_10 = _jspx_th_impact_ifThen_10.doStartTag();
          if (_jspx_eval_impact_ifThen_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_10);
              _jspx_th_impact_ExpandableSectionTag_4.setName("ChildOTH");
              _jspx_th_impact_ExpandableSectionTag_4.setLabel( Lookup.simpleDecodeSafe("CCHRTCAT", "OTH"));
              _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n      <tr>\r\n        <td>\r\n          ");
                  //  impact:codesCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                  _jspx_th_impact_codesCheckbox_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_codesCheckbox_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
                  _jspx_th_impact_codesCheckbox_4.setDefaultCodes(othValues);
                  _jspx_th_impact_codesCheckbox_4.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_codesCheckbox_4.setName("cbxOTH");
                  _jspx_th_impact_codesCheckbox_4.setCodesTableName("OTH");
                  _jspx_th_impact_codesCheckbox_4.setColumns(2);
                  _jspx_th_impact_codesCheckbox_4.setTabIndex(5);
                  int _jspx_eval_impact_codesCheckbox_4 = _jspx_th_impact_codesCheckbox_4.doStartTag();
                  if (_jspx_th_impact_codesCheckbox_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        </td>\r\n      </tr>\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <br>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_10.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_5.setName("NoChar");
          _jspx_th_impact_ExpandableSectionTag_5.setLabel("None Diagnosed");
          _jspx_th_impact_ExpandableSectionTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <tr>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_6.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_validateInput_6.setChecked( String.valueOf(bNoneDiagnosed) );
              _jspx_th_impact_validateInput_6.setOnClick("confirmNoChar();");
              _jspx_th_impact_validateInput_6.setType("checkbox");
              _jspx_th_impact_validateInput_6.setName("cbxBCdPersonChar");
              _jspx_th_impact_validateInput_6.setLabel("None Diagnosed");
              _jspx_th_impact_validateInput_6.setValue("Y");
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n\r\n    </tr>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <br>\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_6.setName("NotYetDiag");
          _jspx_th_impact_ExpandableSectionTag_6.setLabel("Not Yet Diagnosed");
          _jspx_th_impact_ExpandableSectionTag_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_6 = _jspx_th_impact_ExpandableSectionTag_6.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <tr>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_6);
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_7.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_validateInput_7.setChecked( String.valueOf(bNotYetDiagnosed) );
              _jspx_th_impact_validateInput_7.setOnClick("confirmNoChar();");
              _jspx_th_impact_validateInput_7.setType("checkbox");
              _jspx_th_impact_validateInput_7.setName("cbxBCdPersonCharNDiog");
              _jspx_th_impact_validateInput_7.setLabel("Not Yet Diagnosed");
              _jspx_th_impact_validateInput_7.setValue("Y");
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <br>\r\n   ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n <br>\r\n\r\n ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_11.setTest( displayChildInvest );
          int _jspx_eval_impact_ifThen_11 = _jspx_th_impact_ifThen_11.doStartTag();
          if (_jspx_eval_impact_ifThen_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_11);
              _jspx_th_impact_ExpandableSectionTag_7.setName("Adoption");
              _jspx_th_impact_ExpandableSectionTag_7.setLabel("Adoption");
              _jspx_th_impact_ExpandableSectionTag_7.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ExpandableSectionTag_7 = _jspx_th_impact_ExpandableSectionTag_7.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n   <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width = \"100%\" class=\"subDetail\">\r\n   <tr>\r\n     <td> <span class=\"formRequiredText\">*</span> Previously Adopted </td>\r\n     <td colspan = \"4\">\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_8.setType("radio");
                  _jspx_th_impact_validateInput_8.setLabel("Yes");
                  _jspx_th_impact_validateInput_8.setId("PrevAdopt_Yes");
                  _jspx_th_impact_validateInput_8.setName("rbPrevAdopt");
                  _jspx_th_impact_validateInput_8.setValue("Y");
                  _jspx_th_impact_validateInput_8.setCssClass("formInput");
                  _jspx_th_impact_validateInput_8.setChecked( PrevAdopt_Yes );
                  _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateInput_8.setOnClick("confirmPrevAdopted();");
                  _jspx_th_impact_validateInput_8.setOnChange("setCurrentValue(this.value);");
                  int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
                  if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("&nbsp;&nbsp;&nbsp;\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_9.setType("radio");
                  _jspx_th_impact_validateInput_9.setLabel("No");
                  _jspx_th_impact_validateInput_9.setId("PrevAdopt_No");
                  _jspx_th_impact_validateInput_9.setName("rbPrevAdopt");
                  _jspx_th_impact_validateInput_9.setValue("N");
                  _jspx_th_impact_validateInput_9.setCssClass("formInput");
                  _jspx_th_impact_validateInput_9.setChecked( PrevAdopt_No );
                  _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateInput_9.setOnClick("confirmPrevAdopted();");
                  _jspx_th_impact_validateInput_9.setOnChange("setCurrentValue(this.value);");
                  int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
                  if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" &nbsp;&nbsp;&nbsp;\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_10.setType("radio");
                  _jspx_th_impact_validateInput_10.setLabel("Unknown");
                  _jspx_th_impact_validateInput_10.setId("PrevAdopt_Un");
                  _jspx_th_impact_validateInput_10.setName("rbPrevAdopt");
                  _jspx_th_impact_validateInput_10.setValue("U");
                  _jspx_th_impact_validateInput_10.setCssClass("formInput");
                  _jspx_th_impact_validateInput_10.setChecked( PrevAdopt_Un );
                  _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateInput_10.setOnClick("confirmPrevAdopted();");
                  _jspx_th_impact_validateInput_10.setOnChange("setCurrentValue(this.value);");
                  int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
                  if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" &nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n        \r\n      </td>\r\n      \r\n    </tr>\r\n    <tr>\r\n        <td>\r\n        \r\n            ");
                  //  impact:validateDate
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                  _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateDate_0.setName("txtPrevAdopt");
                  _jspx_th_impact_validateDate_0.setLabel("Date of Previous Adoption");
                  _jspx_th_impact_validateDate_0.setConstraint("Date");
                  _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
                  _jspx_th_impact_validateDate_0.setValue( txtPrevAdopt );
                  _jspx_th_impact_validateDate_0.setSize("10");
                  int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
                  if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("             \r\n       </td>\r\n    </tr>\r\n    <!-- SMS #81140: MR-074 Change -->     \r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Was this a single parent adoption? </td>\r\n\t\t<td colspan = \"4\">\r\n\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_11.setType("radio");
                  _jspx_th_impact_validateInput_11.setLabel("Yes");
                  _jspx_th_impact_validateInput_11.setName( PersonDetailConversation.RADIO_SINGLE_PAR_ADPT );
                  _jspx_th_impact_validateInput_11.setCssClass("formInput");
                  _jspx_th_impact_validateInput_11.setChecked(String.valueOf(ArchitectureConstants.Y.equals(TxtSinglePrAdo)) );
                  _jspx_th_impact_validateInput_11.setValue( ArchitectureConstants.Y );
                  _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_11.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateInput_11.setOnClick("clearSingleParent();");
                  int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
                  if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("                \r\n\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_12.setType("radio");
                  _jspx_th_impact_validateInput_12.setLabel("No");
                  _jspx_th_impact_validateInput_12.setName( PersonDetailConversation.RADIO_SINGLE_PAR_ADPT );
                  _jspx_th_impact_validateInput_12.setCssClass("formInput");
                  _jspx_th_impact_validateInput_12.setChecked(String.valueOf(ArchitectureConstants.N.equals(TxtSinglePrAdo)) );
                  _jspx_th_impact_validateInput_12.setValue( ArchitectureConstants.N );
                  _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_12.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateInput_12.setOnClick("clearSingleParent();");
                  int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
                  if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("          \t\r\n\t\t</td>\t                          \t\t      \t\t\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>If Yes, select one (Single Mother, Single Father) </td>\r\n\t\t<td colspan = \"4\">\r\n\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_13.setType("radio");
                  _jspx_th_impact_validateInput_13.setLabel("Single Mother");
                  _jspx_th_impact_validateInput_13.setName( PersonDetailConversation.RADIO_SINGLE_MOM_OR_FAR );
                  _jspx_th_impact_validateInput_13.setCssClass("formInput");
                  _jspx_th_impact_validateInput_13.setChecked(String.valueOf(CodesTables.CSPATYPE_SM.equals(FormattingHelper.formatString(TxtSingleMomOrFar))));
                  _jspx_th_impact_validateInput_13.setValue(CodesTables.CSPATYPE_SM);
                  _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_13.setEditableMode( EditableMode.EDIT );
                  int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
                  if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_14.setType("radio");
                  _jspx_th_impact_validateInput_14.setLabel("Single Father");
                  _jspx_th_impact_validateInput_14.setName( PersonDetailConversation.RADIO_SINGLE_MOM_OR_FAR );
                  _jspx_th_impact_validateInput_14.setCssClass("formInput");
                  _jspx_th_impact_validateInput_14.setChecked(String.valueOf(CodesTables.CSPATYPE_SF.equals(FormattingHelper.formatString(TxtSingleMomOrFar))));
                  _jspx_th_impact_validateInput_14.setValue(CodesTables.CSPATYPE_SF);
                  _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_14.setEditableMode( EditableMode.EDIT );
                  int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
                  if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t</td>\t                          \t\t      \t\t\r\n\t</tr>\t\t\t\t\t              \t\t\t\t\t\t   \t\t    \r\n    <!-- End of SMS #81140: MR-074 AFCARS Change --> \r\n    <!-- MR-092: Fostering Connections Add on -->\r\n    <tr>\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Was child determined to be eligible for Title IV-E in prior adoption? </td>\r\n\t\t<td colspan = \"4\">\r\n\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_15.setType("radio");
                  _jspx_th_impact_validateInput_15.setLabel("Yes");
                  _jspx_th_impact_validateInput_15.setName( PersonDetailConversation.RADIO_IVE_PRIOR_ADOPTION );
                  _jspx_th_impact_validateInput_15.setCssClass("formInput");
                  _jspx_th_impact_validateInput_15.setChecked(String.valueOf(ArchitectureConstants.Y.equals(indIVEPriorAdoption)) );
                  _jspx_th_impact_validateInput_15.setValue( ArchitectureConstants.Y );
                  _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_15.setEditableMode( EditableMode.EDIT );
                  int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
                  if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("                \r\n\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_16.setType("radio");
                  _jspx_th_impact_validateInput_16.setLabel("No");
                  _jspx_th_impact_validateInput_16.setName( PersonDetailConversation.RADIO_IVE_PRIOR_ADOPTION );
                  _jspx_th_impact_validateInput_16.setCssClass("formInput");
                  _jspx_th_impact_validateInput_16.setChecked(String.valueOf(ArchitectureConstants.N.equals(indIVEPriorAdoption)) );
                  _jspx_th_impact_validateInput_16.setValue( ArchitectureConstants.N );
                  _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_16.setEditableMode( EditableMode.EDIT );
                  int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
                  if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("          \t\r\n      ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_17.setType("radio");
                  _jspx_th_impact_validateInput_17.setLabel("Unknown");
                  _jspx_th_impact_validateInput_17.setName( PersonDetailConversation.RADIO_IVE_PRIOR_ADOPTION );
                  _jspx_th_impact_validateInput_17.setCssClass("formInput");
                  _jspx_th_impact_validateInput_17.setChecked(String.valueOf(ArchitectureConstants.U.equals(indIVEPriorAdoption)) );
                  _jspx_th_impact_validateInput_17.setValue( ArchitectureConstants.U );
                  _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_17.setEditableMode( EditableMode.EDIT );
                  int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
                  if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("           \r\n\t\t</td>\t                          \t\t      \t\t\r\n\t</tr>\r\n    <tr>\r\n    <td colspan=\"4\">\r\n      ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_18.setType("checkbox");
                  _jspx_th_impact_validateInput_18.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateInput_18.setCssClass("formInput");
                  _jspx_th_impact_validateInput_18.setLabel("Adoption Dissolution");
                  _jspx_th_impact_validateInput_18.setChecked( (("".equals(adoptDislutn)) || (ArchitectureConstants.N.equals(adoptDislutn))) ? ArchitectureConstants.FALSE : ArchitectureConstants.TRUE );
                  _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_18.setValue("Y");
                  _jspx_th_impact_validateInput_18.setName("chkAdoptDislutn");
                  _jspx_th_impact_validateInput_18.setCssClass("formInput");
                  int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
                  if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n             </td>\r\n             <td>\r\n                ");
                  //  impact:validateDate
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                  _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateDate_1.setName("txtDissolutionDate");
                  _jspx_th_impact_validateDate_1.setLabel("Dissolution Date");
                  _jspx_th_impact_validateDate_1.setConstraint("Date");
                  _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
                  _jspx_th_impact_validateDate_1.setValue( txtDissolutionDate );
                  _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateDate_1.setSize("10");
                  int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
                  if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("     \r\n              </td>\r\n              <td>&nbsp;</td><td>&nbsp;</td>\r\n    </tr>\r\n   <tr>\r\n     <td> <span class=\"formCondRequiredText\"\"></span> Adoption Type </td>\r\n     <td colspan = \"4\">\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_19.setType("radio");
                  _jspx_th_impact_validateInput_19.setLabel("Public");
                  _jspx_th_impact_validateInput_19.setId("PublicAdopt_P");
                  _jspx_th_impact_validateInput_19.setName("rbAdoptType");
                  _jspx_th_impact_validateInput_19.setValue("P");
                  _jspx_th_impact_validateInput_19.setCssClass("formInput");
                  _jspx_th_impact_validateInput_19.setChecked( PublicAdopt_P );
                  _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_19.setEditableMode( EditableMode.EDIT );
                  int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
                  if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("&nbsp;&nbsp;&nbsp;\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_20.setType("radio");
                  _jspx_th_impact_validateInput_20.setLabel("Private");
                  _jspx_th_impact_validateInput_20.setId("PrivateAdopt_R");
                  _jspx_th_impact_validateInput_20.setName("rbAdoptType");
                  _jspx_th_impact_validateInput_20.setValue("R");
                  _jspx_th_impact_validateInput_20.setCssClass("formInput");
                  _jspx_th_impact_validateInput_20.setChecked( PrivateAdopt_R );
                  _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_20.setEditableMode( EditableMode.EDIT );
                  int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
                  if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" &nbsp;&nbsp;&nbsp;\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_21.setType("radio");
                  _jspx_th_impact_validateInput_21.setLabel("International");
                  _jspx_th_impact_validateInput_21.setId("IntAdopt_I");
                  _jspx_th_impact_validateInput_21.setName("rbAdoptType");
                  _jspx_th_impact_validateInput_21.setValue("I");
                  _jspx_th_impact_validateInput_21.setCssClass("formInput");
                  _jspx_th_impact_validateInput_21.setChecked( IntAdopt_I );
                  _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_21.setEditableMode( EditableMode.EDIT );
                  int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
                  if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" &nbsp;&nbsp;&nbsp;\r\n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n      </td>     \r\n    </tr>\r\n   \r\n    <tr>\r\n\r\n       <td colspan = \"1\">  \r\n       ");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateSelect_0.setBlankValue("true");
                  _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
                  _jspx_th_impact_validateSelect_0.setLabel("State");
                  _jspx_th_impact_validateSelect_0.setName("cdState");
                  _jspx_th_impact_validateSelect_0.setCodesTable("CSTATE");
                  _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateSelect_0.setValue( State );
                  int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
                  if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n       </td><td>&nbsp;</td><td>&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n       <td colspan = \"1\">  \r\n       ");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateSelect_1.setBlankValue("true");
                  _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
                  _jspx_th_impact_validateSelect_1.setLabel("County");
                  _jspx_th_impact_validateSelect_1.setName("cdCounty");
                  _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
                  _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateSelect_1.setValue( County );
                  int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
                  if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n      </td><td>&nbsp;</td><td>&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n    <td colspan = \"1\">\r\n      ");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateSelect_2.setBlankValue("true");
                  _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
                  _jspx_th_impact_validateSelect_2.setLabel("Country");
                  _jspx_th_impact_validateSelect_2.setName("cdCountry");
                  _jspx_th_impact_validateSelect_2.setCodesTable("CCNTRY");
                  _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateSelect_2.setValue( Country );
                  int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
                  if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("    \r\n      </td><td>&nbsp;</td><td>&nbsp;</td>\r\n    </tr> \r\n        <tr>\r\n      <td colspan = \"1\">\r\n\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_7);
                  _jspx_th_impact_validateInput_22.setType("text");
                  _jspx_th_impact_validateInput_22.setEditableMode( EditableMode.EDIT );
                  _jspx_th_impact_validateInput_22.setLabel("Name Of Agency");
                  _jspx_th_impact_validateInput_22.setName("szAgency");
                  _jspx_th_impact_validateInput_22.setCssClass("formInput");
                  _jspx_th_impact_validateInput_22.setValue( agentName );
                  _jspx_th_impact_validateInput_22.setSize("60");
                  _jspx_th_impact_validateInput_22.setMaxLength("80");
                  _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
                  int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
                  if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n      </td>\r\n    </tr>\r\n   </table> \r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n   <br>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_11.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    \r\n  <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szTxtCharCmnts");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("120");
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
              out.write("\r\n          ");
              out.print(comments);
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
          out.write("\r\n      </td>\r\n    </tr>\r\n   </table>\r\n    <br>\r\n    <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n      <tr>\r\n        <td class=\"alignRight\">\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmCharDetail");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setAction("/person/PersonDetail/savePersonChar");
          _jspx_th_impact_ButtonTag_0.setFunction("return confirmSave()");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n\r\n\r\n    <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\"/>\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n    <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n// STGAP00017058\r\naddQuestionMark();\r\nsetNoChar();\r\nclearSingleParent();\r\ndisableDatePreviouslyAdoptedAndSingleParent();\r\n</script>");
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
    _jspx_th_impact_validateInput_2.setName("aged");
    _jspx_th_impact_validateInput_2.setValue("N");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_5.setName("hdnCbxPrevAdoptName");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
