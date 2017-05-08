package org.apache.jsp.grnds_002ddocs.contacts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Time;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO;
import gov.georgia.dhr.dfcs.sacwis.web.contacts.PortalContactDetailConversation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class ContactDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/contacts/DetailContactSub.jsp");
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


/**
 * JSP Name:     Portal Contact Detail
 * Created by:   Patrick Coogan 
 * Date Created: 10/06/03
 *
 * Description:
 * This page displays the Detail version of the Contact page.
 *
 * Change History:
 * Date      User              Description
 * --------  ----------------  -----------------------------------------------
 * 10/27/09  Patrick Coogan	   Created file as a copy of main-war ContactDetail
 *                             and made changes as necessary to support the SHINES
 *                             portal initial release (ECEM).
 * 01/17/12  vcollooru         STGAP00017830: Enhancement Request - MR-101 Portal Contacts
 *                                 
 */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    int tabIndex = 1;

    String szCdStage = GlobalData.getSzCdStage(request);

    BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                     .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    CSYS08SO csys08so = (CSYS08SO) state.getAttribute("CSYS08SO", request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }

    String pageMode = PageMode.getPageMode(request);

    String selSzCdContactType = PortalContactDetailConversation.getSelSzCdContactType(request);

    // SIR 22860 - The csys08SO object now returns the right Intake Start Date
    String hdnIntakeDate = FormattingHelper.formatDate(csys08so.getDtDtIntStart());
    // STGAP00011640 Will pass time also , ealier hdnIntakeDate was passing only
    //               the date.
    String hdnIntakeTime = FormattingHelper.formatTime(csys08so.getDtDtIntStart());
    //STGAP00007854 - never show the approval status button, not applicable
    boolean approvalStatus = false;
    

    String tsLastUpdate = FormattingHelper.formatDate(csys08so.getTsLastUpdate());
    String txtDtDtContactOccurred = FormattingHelper.formatDate(csys08so.getDtDTContactOccurred());
 
    if ((GlobalData.getUlIdEvent(request) == 0) ) {
      txtDtDtContactOccurred = "";
    }

    TmScrTmCntct_ARRAY timeArray = csys08so.getTmScrTmCntct_ARRAY();
    if (timeArray == null) {
      timeArray = new TmScrTmCntct_ARRAY();
    }
    String txtTmScrTmCntct = FormattingHelper
                                             .formatString(timeArray.getTmScrTmCntctCount() > 0 ? timeArray
                                                                                                           .getTmScrTmCntct(0)
                                                                                               : null);

    String cbxBIndContactAttempted = FormattingHelper.formatString(csys08so.getBIndContactAttempted());
    String cbxBIndExtComment = FormattingHelper.formatString(csys08so.getIndExtDocAccepted());
    if ("".equals(cbxBIndExtComment)) {
      cbxBIndExtComment = "N";
    }
    
    String szNmPersonFull = FormattingHelper.formatString(csys08so.getSzNmPersonFull()); //MR-024 this is populated on Entered by field
    if ((csys08so.getSzNmPersonFull() == null)||"".equals(csys08so.getSzNmPersonFull())){
    szNmPersonFull = FormattingHelper.formatString(csys08so.getSzNmPortalUserFull());
    }
    String szNmContactedBy = FormattingHelper.formatString(csys08so.getSzNmContactedBy()); //MR-024
    String txtDtDtContactEntered = FormattingHelper.formatDate(csys08so.getDtDTContactEntered()); //MR-024
    String hdnEnteredOn = FormattingHelper.formatDate(csys08so.getDtDTContactEntered()); //MR-024
    
    boolean timeDisabled = false;
    String dateDisabled = "false";
    String disableAttempted = "false";
 
    String presentationMode = PortalContactDetailConversation.getPresentationMode(request);
    boolean detailMode = PortalContactDetailConversation.DETAIL_CONTACT.equals(presentationMode);
    boolean extComment = true;
    
    String checkedContactedBy = StringHelper.EMPTY_STRING;
    if (request.getParameter("rbContactedBy")!= null) {
        checkedContactedBy = request.getParameter("rbContactedBy");
      } else {
        if (StringHelper.isValid(csys08so.getSzCdContactedBy())) {
          checkedContactedBy = csys08so.getSzCdContactedBy();
        } else {
          checkedContactedBy = CodesTables.CCCONTBY_DFC;
        }
      }
    
  String contactedbystaff = "none";
  String contactedbyCCA = "none";
  String nameContactedbyCCA = "none";
  String contactedbystaffbutton = "none";
  String contactedbyXXX = "none";
  String nameContactedbyXXX = "none";
  
  Integer hdnUlIdPlcmtFacil = ContextHelper.getIntSafe(request,"hdnUlIdPlcmtFacil");
  Integer hdnUlIdPlcmtAgency = ContextHelper.getIntSafe(request,"hdnUlIdPlcmtAgency");
  
  
  if(CodesTables.CCCONTBY_CCA.equals(checkedContactedBy) ||CodesTables.CCCONTBY_XXX.equals(checkedContactedBy)){
  contactedbystaffbutton = "block";
  contactedbystaff = "block";  
  }
  
  if(CodesTables.CCCONTBY_DFC.equals(checkedContactedBy)){
 contactedbyCCA = "block";
  }
   
    String indSauSealedHomeAndWorker = (String) state.getAttribute("SAUSEALEDHOMEANDWORKER", request);  
    String editAllowedSevenDays = (String) state.getAttribute("EDITALLOWEDFORSEVENDAYS",request);
    String editAllowed = (String) state.getAttribute("EDITALLOWED", request);
    String isContactBeforeStageClosure = (String) state.getAttribute("ISDATEBEFORESTAGECLOSE", request);
    request.setAttribute("ISDATEBEFORESTAGECLOSESUB", isContactBeforeStageClosure);
    request.setAttribute("EDITALLOWEDSUB", editAllowed); 
    request.setAttribute("SAUSEALEDHOMEANDWORKERSUB", indSauSealedHomeAndWorker); 
    request.setAttribute("EDITALLOWEDFORSEVENDAYSSUB", editAllowedSevenDays);  
      if ( ("true".equals(editAllowed) && "false".equals(isContactBeforeStageClosure)) || 
              ("true".equals(indSauSealedHomeAndWorker) && "true".equals(editAllowedSevenDays) && "false".equals(isContactBeforeStageClosure))) {
      timeDisabled = false;
      dateDisabled = "false";
      disableAttempted = "false";
    }
	
    //Narrative Type check boxes
    String checkedNarrativeType = StringHelper.EMPTY_STRING;
    if (csys08so.getSzCdContactNarr() != null) {
       checkedNarrativeType = csys08so.getSzCdContactNarr();
    } else if(CodesTables.CSTAGES_ADO.equals(szCdStage) || CodesTables.CSTAGES_FSU.equals(szCdStage)
               || CodesTables.CSTAGES_SUB.equals(szCdStage)) {
       checkedNarrativeType = CodesTables.CCONNARR_SPW;
    } else {
       checkedNarrativeType = CodesTables.CCONNARR_STD;
    }

     String modDisabled = "false";
      if (ArchitectureConstants.Y.equals(csys08so.getIndExtDocAccepted())){
     modDisabled = "true";
   }

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" language=\"JavaScript1.2\">\r\n  window.onbeforeunload = function ()\r\n  {      \r\n   IsDirty();\r\n   }\r\n   \r\n  window.onload = function()\r\n{\r\n var varRbContactedBy = document.getElementsByName('rbContactedBy');\r\nif (varRbContactedBy.length > 1){\r\n if(document.frmContactDetail.rbContactedBy[0].checked)\r\n     {\r\n      toggleVisibility('contactedbystaffbutton', 'block');\r\n      toggleVisibility('contactedbystaff', 'block');\r\n      toggleVisibility('contactedbyCCA', 'none');\r\n      toggleVisibility('contactedbyXXX', 'none');\r\n      toggleVisibility('nameContactedbyCCA', 'none');\r\n      toggleVisibility('nameContactedbyXXX', 'none');\r\n     } else if(document.frmContactDetail.rbContactedBy[1].checked){\r\n      toggleVisibility('contactedbyCCA', 'block');\r\n      toggleVisibility('nameContactedbyCCA', 'block');\r\n      toggleVisibility('contactedbystaff', 'none');\r\n      toggleVisibility('contactedbystaffbutton', 'none');\r\n");
      out.write("      toggleVisibility('contactedbyXXX', 'none');\r\n      toggleVisibility('nameContactedbyXXX', 'none');\r\n      } else if(document.frmContactDetail.rbContactedBy[2].checked){\r\n      toggleVisibility('contactedbyXXX', 'block');\r\n      toggleVisibility('nameContactedbyXXX', 'block');\r\n      toggleVisibility('contactedbystaff', 'none');\r\n      toggleVisibility('contactedbystaffbutton', 'none');\r\n      toggleVisibility('contactedbyCCA', 'none');\r\n      toggleVisibility('nameContactedbyCCA', 'none');\r\n      }     \r\n   }else{\r\n    if(document.frmContactDetail.rbContactedBy_Disabled[0].checked)\r\n     {\r\n      toggleVisibility('contactedbystaffbutton', 'block');\r\n      toggleVisibility('contactedbystaff', 'block');\r\n      toggleVisibility('contactedbyCCA', 'none');\r\n      toggleVisibility('contactedbyXXX', 'none');\r\n      toggleVisibility('nameContactedbyCCA', 'none');\r\n      toggleVisibility('nameContactedbyXXX', 'none');\r\n     } else if(document.frmContactDetail.rbContactedBy_Disabled[1].checked){\r\n      toggleVisibility('contactedbyCCA', 'block');\r\n");
      out.write("      toggleVisibility('nameContactedbyCCA', 'block');\r\n      toggleVisibility('contactedbystaff', 'none');\r\n      toggleVisibility('contactedbystaffbutton', 'none');\r\n      toggleVisibility('contactedbyXXX', 'none');\r\n      toggleVisibility('nameContactedbyXXX', 'none');\r\n      } else if(document.frmContactDetail.rbContactedBy_Disabled[2].checked){\r\n      toggleVisibility('contactedbyXXX', 'block');\r\n      toggleVisibility('nameContactedbyXXX', 'block');\r\n      toggleVisibility('contactedbystaff', 'none');\r\n      toggleVisibility('contactedbystaffbutton', 'none');\r\n      toggleVisibility('contactedbyCCA', 'none');\r\n      toggleVisibility('nameContactedbyCCA', 'none');\r\n      }\r\n   }\r\n }\r\n  \r\n  function onClickOfDFC(){\r\n     if(document.frmContactDetail.rbContactedBy[0].checked)\r\n      {\r\n      toggleVisibility('contactedbystaff', 'block');\r\n      toggleVisibility('contactedbystaffbutton', 'block');\r\n      toggleVisibility('contactedbyCCA', 'none');\r\n      toggleVisibility('contactedbyXXX', 'none');\r\n      toggleVisibility('nameContactedbyCCA', 'none');\r\n");
      out.write("      toggleVisibility('nameContactedbyXXX', 'none');\r\n      updateDisplayOnlyField(\"frmContactDetail\", \"szNmContactedByStaff\", \"\");\r\n      }\r\n   }\r\n  \r\n   function onClickOfCCA(){\r\n       if(document.frmContactDetail.rbContactedBy[1].checked){\r\n       toggleVisibility('contactedbyCCA', 'block');\r\n       toggleVisibility('nameContactedbyCCA', 'block');\r\n       toggleVisibility('contactedbystaff', 'none');\r\n       toggleVisibility('contactedbystaffbutton', 'none');\r\n       toggleVisibility('contactedbyXXX', 'none');\r\n       toggleVisibility('nameContactedbyXXX', 'none');\r\n       document.frmContactDetail.szNmContactedByCCA.value = \"\";              \r\n       }  \r\n    }\r\n  \r\n    function onClickOfXXX(){  \r\n       if(document.frmContactDetail.rbContactedBy[2].checked ){\r\n       toggleVisibility('contactedbyXXX', 'block');\r\n       toggleVisibility('nameContactedbyXXX', 'block');\r\n       toggleVisibility('contactedbystaff', 'none');\r\n       toggleVisibility('contactedbystaffbutton', 'none');\r\n       toggleVisibility('contactedbyCCA', 'none');\r\n");
      out.write("       toggleVisibility('nameContactedbyCCA', 'none');\r\n       document.frmContactDetail.szNmContactedByXXX.value = \"\";       \r\n       }  \r\n    } \r\n\r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmContactDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/contacts/PortalContactDetail/displayContact");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.contacts.PortalContactDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr>\r\n    <th colspan=\"8\">Contact Information</th>\r\n  </tr>\r\n  <tr>\r\n     <td width=\"15%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("selSzCdContactType");
          _jspx_th_impact_validateDisplayOnlyField_0.setCodesTable(CodesTables.CCNTCTYP);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Contact/Summary Type");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(selSzCdContactType);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  \r\n <tr>\r\n  <td>\r\n   \r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Entered By");
          _jspx_th_impact_validateDisplayOnlyField_1.setName("szNmEnteredBy");
          _jspx_th_impact_validateDisplayOnlyField_1.setWidth("30%");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(szNmPersonFull);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   \r\n   </td>\r\n  <td>\r\n    ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest(detailMode);
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Entered On");
              _jspx_th_impact_validateDisplayOnlyField_2.setWidth("30%");
              _jspx_th_impact_validateDisplayOnlyField_2.setName("txtDtDtContactEntered");
              _jspx_th_impact_validateDisplayOnlyField_2.setValue(txtDtDtContactEntered);
              int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>    \r\n   </tr>\r\n<tr>\r\n    <td>\r\n      ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest(detailMode && ((csys08so.getSzCdJobTitle()!= null)&&!("".equals(csys08so.getSzCdJobTitle()))));
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Title");
              _jspx_th_impact_validateDisplayOnlyField_3.setName("szCdJobTitle");
              _jspx_th_impact_validateDisplayOnlyField_3.setColspan("4");
              _jspx_th_impact_validateDisplayOnlyField_3.setValue(csys08so.getSzCdJobTitle());
              _jspx_th_impact_validateDisplayOnlyField_3.setCodesTable("CEMPJBCL");
              int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr> \r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_2.setTest(detailMode && ((csys08so.getSzCdJobTitle()== null)||"".equals(csys08so.getSzCdJobTitle())));
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Title");
              _jspx_th_impact_validateDisplayOnlyField_4.setName("szCdJobTitle");
              _jspx_th_impact_validateDisplayOnlyField_4.setColspan("4");
              _jspx_th_impact_validateDisplayOnlyField_4.setValue(csys08so.getSzTitlePortalUser());
              int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr> \r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_3.setTest(detailMode);
          int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
          if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <tr> \r\n    <td width=\"25%\"> Contacted By: \r\n     </td>\r\n\t <td width=\"33%\">\t\r\n\t  \t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_validateInput_0.setChecked(CodesTables.CCCONTBY_DFC.equals(checkedContactedBy) ? "true" : "false");
              _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_0.setValue(CodesTables.CCCONTBY_DFC);
              _jspx_th_impact_validateInput_0.setType("radio");
              _jspx_th_impact_validateInput_0.setName("rbContactedBy");
              _jspx_th_impact_validateInput_0.setLabel("DFCS Staff");
              _jspx_th_impact_validateInput_0.setCssClass("formInput");
              _jspx_th_impact_validateInput_0.setDisabled("true");
              _jspx_th_impact_validateInput_0.setOnClick("onClickOfDFC()");
              int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
              if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t </td>\r\n\t \r\n <td width=\"25%\" id=\"contactedbystaff\" style=\"display: ");
              out.print( contactedbystaff );
              out.write("\">\r\n &nbsp;\r\n </td>\r\n \r\n <td width =\"12%\" id=\"contactedbystaffbutton\" style=\"display: ");
              out.print( contactedbystaffbutton );
              out.write("\">\r\n          &nbsp;\r\n  </td>\t \r\n </tr>\r\n  \r\n  <tr>\r\n\t <td width=\"25%\"> </td> <td width=\"33%\">\r\n\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_validateInput_1.setChecked(CodesTables.CCCONTBY_CCA.equals(checkedContactedBy) ? "true" : "false");
              _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_1.setValue(CodesTables.CCCONTBY_CCA);
              _jspx_th_impact_validateInput_1.setType("radio");
              _jspx_th_impact_validateInput_1.setName("rbContactedBy");
              _jspx_th_impact_validateInput_1.setLabel("CPA/CCI Authorized Case Worker");
              _jspx_th_impact_validateInput_1.setCssClass("formInput");
              _jspx_th_impact_validateInput_1.setDisabled("true");
              _jspx_th_impact_validateInput_1.setOnClick("onClickOfCCA()");
              int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
              if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t </td>\r\n\t\t \r\n\t <td> \t \r\n\t\t ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_4.setTest(detailMode);
              int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
              if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t   ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
                  _jspx_th_impact_validateInput_2.setLabel("Name of Worker");
                  _jspx_th_impact_validateInput_2.setType("text");
                  _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
                  _jspx_th_impact_validateInput_2.setName("szNmContactedByCCA");
                  _jspx_th_impact_validateInput_2.setValue(szNmContactedBy);
                  int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
                  if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("   \r\n\t     ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n\t \r\n </tr>\r\n\r\n <tr>\r\n\t <td width=\"25%\"> </td> <td width=\"33%\">\r\n\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_validateInput_3.setChecked(CodesTables.CCCONTBY_XXX.equals(checkedContactedBy) ? "true" : "false");
              _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_3.setValue(CodesTables.CCCONTBY_XXX);
              _jspx_th_impact_validateInput_3.setType("radio");
              _jspx_th_impact_validateInput_3.setName("rbContactedBy");
              _jspx_th_impact_validateInput_3.setLabel("Other");
              _jspx_th_impact_validateInput_3.setCssClass("formInput");
              _jspx_th_impact_validateInput_3.setDisabled("true");
              _jspx_th_impact_validateInput_3.setOnClick("onClickOfXXX()");
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t</td>\r\n\t<td id=\"nameContactedbyXXX\" width=\"25%\" style=\"display: ");
              out.print( nameContactedbyXXX );
              out.write("\"> \t \r\n\t  ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_5.setTest(detailMode);
              int _jspx_eval_impact_ifThen_5 = _jspx_th_impact_ifThen_5.doStartTag();
              if (_jspx_eval_impact_ifThen_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t     ");
                  if (_jspx_meth_impact_validateDisplayOnlyField_5(_jspx_th_impact_ifThen_5, _jspx_page_context))
                    return;
                  out.write("   \r\n\t  ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n\t\r\n    <td id=\"contactedbyXXX\" width=\"12%\" style=\"display: ");
              out.print( contactedbyXXX );
              out.write("\"> \r\n      ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_6.setTest(detailMode);
              int _jspx_eval_impact_ifThen_6 = _jspx_th_impact_ifThen_6.doStartTag();
              if (_jspx_eval_impact_ifThen_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_6);
                  _jspx_th_impact_validateInput_4.setLabel("");
                  _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateInput_4.setType("text");
                  _jspx_th_impact_validateInput_4.setName("szNmContactedByXXX");
                  _jspx_th_impact_validateInput_4.setDisabled(disableAttempted);
                  _jspx_th_impact_validateInput_4.setValue(szNmContactedBy);
                  int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
                  if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("   \r\n     ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n</tr>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Contact Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setName("txtDtDtContactOccurred");
          _jspx_th_impact_validateDate_0.setValue(txtDtDtContactOccurred);
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setDisabled(dateDisabled);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setLabel("Time");
          _jspx_th_impact_validateTime_0.setName("txtTmScrTmCntct");
          _jspx_th_impact_validateTime_0.setValue(txtTmScrTmCntct);
          _jspx_th_impact_validateTime_0.setDisabled(String.valueOf(timeDisabled));
          _jspx_th_impact_validateTime_0.setRequired("true");
          _jspx_th_impact_validateTime_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_7.setTest(detailMode);
          int _jspx_eval_impact_ifThen_7 = _jspx_th_impact_ifThen_7.doStartTag();
          if (_jspx_eval_impact_ifThen_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_7);
              _jspx_th_impact_validateInput_5.setLabel("Attempted");
              _jspx_th_impact_validateInput_5.setName("cbxBIndContactAttempted");
              _jspx_th_impact_validateInput_5.setType("checkbox");
              _jspx_th_impact_validateInput_5.setDisabled(disableAttempted);
              _jspx_th_impact_validateInput_5.setChecked(cbxBIndContactAttempted);
              _jspx_th_impact_validateInput_5.setValue(cbxBIndContactAttempted);
              _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  ");

    request.setAttribute("tabIndex", tabIndex);
  
          out.write("\r\n  ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_0.setTest(detailMode);
          int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
          if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
              int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
              if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n      ");

  /**
   * JSP Name:     Detail Contact Sub
   * Created by:   Todd Reser (Split out by Matt McClaim)
   * Date Created: 10/06/03
   *
   * Description:
   * This page displays the Detail only portions version of the Contact page, and
   * is included in the Contact Detail page ony when needed.
   *
   **/
/* Change History:
  Date      User              Description
  --------  ----------------  -------------------------------------------------
  05/26/11  schoi             SMS #109398: MR-086 Added a new field 'Discussed/In Reference To'     
              
*/

                  out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    //SIR 23835 Instantiated new excludeOptions List
    //List<String> excludeOptions = new ArrayList<String>();
    //end SIR 23835

    int perps = 0;
    int vics = 0;

    // SIR 23410. Added logic to disable Purpose,Method,Location and Others Contracted Field
    // for contract type CLES and CLEV
    // SIR 23298 use this logic as well to disable Purpose, Method, Location and Others Contacted Field
    // for contact type CAGR
    boolean purposeDisabled = false;
    boolean methodDisabled = false;
    boolean locationDisabled = false;
    boolean otherDisabled = false;
    
    String modifyDisabled = "false";

    int _tabIndex = (Integer) request.getAttribute("tabIndex");
    String _pageMode = PageMode.getPageMode( request );

    //String _szCdStage = GlobalData.getSzCdStage( request );
    //String _szCdStageProgram = GlobalData.getSzCdStageProgram( request );

    BaseSessionStateManager _state = (BaseSessionStateManager)
            request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

    CSYS08SO _csys08so = (CSYS08SO)_state.getAttribute( "CSYS08SO", request );
    if( _csys08so == null )
    {
      _csys08so = new CSYS08SO();
    }

  if (PageModeConstants.MODIFY.equals( _pageMode )){
      purposeDisabled = true;
        methodDisabled = true;
        locationDisabled = true;
        otherDisabled = true;
     modifyDisabled = "true";
   }
   
   //STGAP00014326 MR-024 Allow contact to be modified for 7 days from date entered.
   String editAllow = (String) request.getAttribute("EDITALLOWEDSUB");
   String isContactBefStageClosure = (String) request.getAttribute("ISDATEBEFORESTAGECLOSESUB");
   String subSauSealedHomeAndWorker = (String) request.getAttribute("SAUSEALEDHOMEANDWORKERSUB");
   String subeditallowedforsevendays = (String) request.getAttribute("EDITALLOWEDFORSEVENDAYSSUB");
   
   if(("true".equals(editAllow) && "false".equals(isContactBefStageClosure))  || 
             ("true".equals(subSauSealedHomeAndWorker) && "true".equals(subeditallowedforsevendays) && "false".equals(isContactBefStageClosure))){
     purposeDisabled = false;
     methodDisabled = false;
     locationDisabled = false;
     otherDisabled = false;
     modifyDisabled = "false";  
     } 

    String _selSzCdContactMethod = FormattingHelper.formatString( _csys08so.getSzCdContactMethod() );

    String _selSzCdContactType = PortalContactDetailConversation.getSelSzCdContactType( request );


    String _selSzCdContactLocation = _csys08so.getSzCdContactLocation();
    String _selSzCdContactOthers = _csys08so.getSzCdContactOthers();
    String _selSzCdContactPurpose = FormattingHelper.formatString( _csys08so.getSzCdContactPurpose() );
    boolean _chkCrossCountyLines = false;
    if("on".equals(ContextHelper.getStringSafe(request, "chkCrossCountyLines")) ||
       (ArchitectureConstants.Y.equals(_csys08so.getBIndCrossCountyLines())) ) {
      _chkCrossCountyLines = true;
    }

    if( FormValidation.pageHasValidationMessages( "frmContactDetail", request ) )
    {
       _selSzCdContactPurpose = request.getParameter( "cbxContactPurpose" );
      _selSzCdContactLocation = request.getParameter( "selSzCdContactLocation" );
      _selSzCdContactOthers = request.getParameter( "selSzCdContactOthers" );
    }

       if( PlatformConstants.MOBILE_IMPACT &&
        PageModeConstants.VIEW.equals( _pageMode ) &&
        !Lookup.getCategoryCodesCollection( CodesTables.CCNTPURP ).contains( _selSzCdContactPurpose ) )
    {
      _selSzCdContactPurpose = "";
    }
    
      _state.setAttribute("savedPrivConversationArray", _csys08so.getROWPRIVCONVERSO_ARRAY(), request);
      
      // SMS #109398: MR-086
      _state.setAttribute("savedDiscussedArray", _csys08so.getROWDISCUSSEDSO_ARRAY(), request);

                  out.write("\r\n\r\n");
                  out.write("\r\n\r\n<script type=\"text/Javascript\" language=\"JavaScript1.2\">\r\nvar vics = 0;\r\nvar perps = 0;\r\n\r\nfunction checkPersRole( szCdPersRole, szCdStagePersRelInt, checked )\r\n{\r\n  //Check to see if the role is Alleged or Designated Perpertrator\r\n  if( (szCdPersRole == \"");
                  out.print( CodesTables.CROLEALL_AP );
                  out.write("\") ||\r\n      (szCdPersRole == \"");
                  out.print( CodesTables.CROLEALL_DP );
                  out.write("\") )\r\n  {\r\n    if( checked )\r\n    {\r\n      perps++;\r\n    }\r\n    else\r\n    {\r\n      perps--;\r\n    }\r\n    if( perps > 0 )\r\n    {\r\n      document.frmContactDetail.hdnBPerpSelected.value = \"Y\";\r\n    }\r\n    else\r\n    {\r\n      document.frmContactDetail.hdnBPerpSelected.value = \"N\";\r\n    }\r\n  }\r\n  //SIR 18433 - A \"No Role\" and \"Self\" counts as a victim\r\n  //Check to see if the role is Alleged or Designated Victim\r\n  if( (szCdPersRole == \"");
                  out.print( CodesTables.CROLEALL_VC );
                  out.write("\") ||\r\n      (szCdPersRole == \"");
                  out.print( CodesTables.CROLEALL_DV );
                  out.write("\") ||\r\n\r\n      ((szCdStagePersRelInt == \"");
                  out.print( CodesTables.CRPTRINT_SL );
                  out.write("\") &&\r\n       ((szCdPersRole == \"");
                  out.print( CodesTables.CROLEALL_NO );
                  out.write("\") ||\r\n        (szCdPersRole == \"");
                  out.print( CodesTables.CROLEALL_UK );
                  out.write("\"))) )\r\n  {\r\n    if( checked )\r\n    {\r\n      vics++;\r\n    }\r\n    else\r\n    {\r\n      vics--;\r\n    }\r\n  }\r\n  if( vics > 0 )\r\n  {\r\n    document.frmContactDetail.hdnBVictimSelected.value = \"Y\";\r\n  }\r\n  else\r\n  {\r\n    document.frmContactDetail.hdnBVictimSelected.value = \"N\";\r\n  }\r\n}\r\n</script>\r\n\r\n");
                  if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_then_0, _jspx_page_context))
                    return;
                  out.write('\r');
                  out.write('\n');
                  if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_then_0, _jspx_page_context))
                    return;
                  out.write("\r\n\r\n");
                  out.write('\r');
                  out.write('\n');
                  out.write('\r');
                  out.write('\n');
                  out.write("\r\n<tr>\r\n  <td width=\"20%\">\r\n    <!--SIR 23835 added exclude options -->\r\n    ");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_validateSelect_0.setLabel("Method");
                  _jspx_th_impact_validateSelect_0.setName("selSzCdContactMethod");
                  _jspx_th_impact_validateSelect_0.setRequired("true");
                  _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( methodDisabled ) );
                  _jspx_th_impact_validateSelect_0.setColspan("4");
                  _jspx_th_impact_validateSelect_0.setOptions( PortalContactDetailConversation.getMethodOptions(request, true) );
                  _jspx_th_impact_validateSelect_0.setValue( _selSzCdContactMethod );
                  _jspx_th_impact_validateSelect_0.setTabIndex( _tabIndex++ );
                  _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.DEFAULT );
                  int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
                  if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_validateSelect_1.setLabel("Location");
                  _jspx_th_impact_validateSelect_1.setName("selSzCdContactLocation");
                  _jspx_th_impact_validateSelect_1.setCodesTable("CCNCTLOC");
                  _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf( locationDisabled ) );
                  _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
                  _jspx_th_impact_validateSelect_1.setValue( _selSzCdContactLocation );
                  _jspx_th_impact_validateSelect_1.setTabIndex( _tabIndex++ );
                  _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.DEFAULT );
                  int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
                  if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n  </td>\r\n  \r\n  \r\n  <td>\r\n    ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_validateInput_8.setLabel("Name of Agency");
                  _jspx_th_impact_validateInput_8.setTabIndex( _tabIndex++ );
                  _jspx_th_impact_validateInput_8.setType("text");
                  _jspx_th_impact_validateInput_8.setName("szNmAgencyName");
                  _jspx_th_impact_validateInput_8.setConstraint("Name20");
                  _jspx_th_impact_validateInput_8.setDisabled( modifyDisabled );
                  _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.DEFAULT );
                  _jspx_th_impact_validateInput_8.setConditionallyRequired("true");
                  _jspx_th_impact_validateInput_8.setValue( _csys08so.getSzNmAgencyName() );
                  int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
                  if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n  </td>\r\n </tr> \r\n  \r\n <tr> \r\n  <td>\r\n    ");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_validateSelect_2.setLabel("Others Contacted");
                  _jspx_th_impact_validateSelect_2.setName("selSzCdContactOthers");
                  _jspx_th_impact_validateSelect_2.setCodesTable("COTHCNCT");
                  _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( otherDisabled ) );
                  _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
                  _jspx_th_impact_validateSelect_2.setValue( _selSzCdContactOthers );
                  _jspx_th_impact_validateSelect_2.setTabIndex( _tabIndex++ );
                  _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.DEFAULT );
                  int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
                  if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n  </td>\r\n  <td colspan=\"4\">\r\n    ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_validateInput_9.setName("chkCrossCountyLines");
                  _jspx_th_impact_validateInput_9.setType("checkbox");
                  _jspx_th_impact_validateInput_9.setLabel("Permission to cross county lines");
                  _jspx_th_impact_validateInput_9.setDisabled( String.valueOf( otherDisabled ) );
                  _jspx_th_impact_validateInput_9.setChecked( Boolean.toString(_chkCrossCountyLines) );
                  _jspx_th_impact_validateInput_9.setTabIndex( _tabIndex++ );
                  int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
                  if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n  </td>\r\n</tr>\r\n\r\n\r\n\r\n<br>\r\n\r\n  ");

  //STGAP00014326 MR-024 Add Purpose Checkboxes.
    List<String> checkedPurposeList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxContactPurpose"));
  //MR -024 Retrieve Purpose check boxes
   ContactCbxDisplay_Array cbxArray = _csys08so.getContactCbxDisplay_Array();
    if(cbxArray != null && cbxArray.getUlRowQty() > 0) {
      checkedPurposeList = new ArrayList<String>();
      for(ContactCbxDisplay cbxDisplay : cbxArray.getContactCbxDisplay()) {
        String codeType = cbxDisplay.getSzCdCbxCodeType();
        if(CodesTables.CCNTPURP.equals(codeType)) {
          checkedPurposeList.add(cbxDisplay.getSzCdContactCbx());
        } 
      }
    }
    
                  out.write("\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n\t<th>\r\n\t\t<span class=\"formRequiredText\">*</span>Purpose \r\n\t</th>\r\n</tr>\r\n<tr>\r\n   <td> ");
                  //  impact:codesCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                  _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_codesCheckbox_0.setName("cbxContactPurpose");
                  _jspx_th_impact_codesCheckbox_0.setColumns(3);
                  _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CCNTPURP );
                  _jspx_th_impact_codesCheckbox_0.setDisabled( String.valueOf( purposeDisabled ) );
                  _jspx_th_impact_codesCheckbox_0.setDefaultCodes( checkedPurposeList );
                  _jspx_th_impact_codesCheckbox_0.setTabIndex( _tabIndex++ );
                  int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
                  if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n  \r\n    </td>\r\n</tr>\r\n</table>\r\n\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"4\"> Principals/Collaterals Contacted</th>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"4\">");
                  //  impact:pagination
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
                  _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_pagination_0.setSubmitUrl("/contacts/PortalContactDetail/displayContact");
                  _jspx_th_impact_pagination_0.setSaveState("false");
                  int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
                  if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" class=\"formlabel\">\r\n    <div id=\"scroll3\" style=\"width:100%; height:125px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\" width=\"20%\">Name</th>\r\n          <th class=\"thList\" width=\"20%\">Type</th>\r\n          <th class=\"thList\" width=\"20%\">Role</th>\r\n          <th class=\"thList\" width=\"20%\">Relation/Interest</th>\r\n          <th class=\"thList\" width=\"20%\">Private <br> Conversation</th>\r\n          <th class=\"thList\" width=\"20%\">Discussed/In Reference To</th>\r\n        </tr>\r\n        <tr>\r\n          ");

            ROWCSYS08SO_ARRAY rowcsys08soArray = _csys08so.getROWCSYS08SO_ARRAY();
            if( rowcsys08soArray == null )
            {
              rowcsys08soArray = new ROWCSYS08SO_ARRAY();
            }

            Enumeration csys08soEnumeration = rowcsys08soArray.enumerateROWCSYS08SO();

            if( !csys08soEnumeration.hasMoreElements() )
            {
          
                      out.write("\r\n          <tr class=\"odd\">\r\n            <td colspan=\"4\">\r\n              ");
                      out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
                      out.write("\r\n            </td>\r\n          </tr>\r\n     <tr>\r\n          ");

          }
          else
          {
            int i = 0;
            while( csys08soEnumeration.hasMoreElements() )
            {
              ROWCSYS08SO csys08soRow = (ROWCSYS08SO)csys08soEnumeration.nextElement();
              if( i % 2 == 0 )
              {
                out.println( "<tr class=\"subDetail\">" );
              }
              else
              {
                out.println( "<tr class=\"altcolor\">" );
              }
              String cbxName = "cbxUlIdPerson" + ( i + 1 );
              String _szCdStagePersRole = csys08soRow.getSzCdStagePersRole();
              //SIR 18433 - Have to pass in Relation/Interest to checkPersRole
              String _szCdStagePersRelInt = csys08soRow.getSzCdStagePersRelInt();
              String indContactOccurred = csys08soRow.getCSysIndContactOccurred();

              String clickCommand =
                      "checkPersRole('" + _szCdStagePersRole + "', " +
                      "              '" + _szCdStagePersRelInt + "', " +
                      "              document.frmContactDetail." + cbxName + ".checked)";

              // This section increments the vics and perps so they can be set
              // by Javascript properly at the time of page loading.
              if( ArchitectureConstants.Y.equals( csys08soRow.getCSysIndContactOccurred() ) )
              {
                if( ( CodesTables.CROLEALL_AP.equals( _szCdStagePersRole ) ) ||
                    ( CodesTables.CROLEALL_DP.equals( _szCdStagePersRole ) ) )
                {
                  perps++;
                }
                if( ( CodesTables.CROLEALL_VC.equals( _szCdStagePersRole ) ) ||
                    ( CodesTables.CROLEALL_DV.equals( _szCdStagePersRole ) ) ||

                    ( ( CodesTables.CRPTRINT_SL.equals( _szCdStagePersRelInt ) ) &&
                      ( ( CodesTables.CROLEALL_NO.equals( _szCdStagePersRole ) ) ||
                        ( CodesTables.CROLEALL_UK.equals( _szCdStagePersRole ) ) ) ) )
                {
                  vics++;
                }
              }
              // do not add a <tr> here plz they are genereated in the code above
          
                      out.write("\r\n          <td>");
                      //  impact:validateInput
                      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                      _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
                      _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                      _jspx_th_impact_validateInput_10.setTabIndex( _tabIndex++ );
                      _jspx_th_impact_validateInput_10.setType("checkbox");
                      _jspx_th_impact_validateInput_10.setChecked( indContactOccurred );
                      _jspx_th_impact_validateInput_10.setValue( String.valueOf(csys08soRow.getUlIdPerson()) );
                      _jspx_th_impact_validateInput_10.setName( cbxName );
                      _jspx_th_impact_validateInput_10.setDisabled( modifyDisabled );
                      _jspx_th_impact_validateInput_10.setOnClick( clickCommand );
                      _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.DEFAULT );
                      int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
                      if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n\r\n            ");
                      out.print( FormattingHelper.formatString( csys08soRow.getSzNmPersonFull() ) );
                      out.write("\r\n          </td>\r\n          <td>");
                      out.print( Lookup.simpleDecodeSafe( "CPRSNTYP", csys08soRow.getSzCdStagePersType() ) );
                      out.write("</td>\r\n          <td>");
                      out.print( Lookup.simpleDecodeSafe( "CINVROLE", _szCdStagePersRole ) );
                      out.write("</td>\r\n          <td>");
                      out.print( Lookup.simpleDecodeSafe( "CRPTRINT", _szCdStagePersRelInt ) );
                      out.write("</td>\r\n          \r\n        ");
String cbxNamePrivConver = "cbxPrivConver" + ( i + 1 );
          String szCheckedPrivConver = "false";
         
         ROWPRIVCONVERSO_ARRAY rowPrivConversoArray = _csys08so.getROWPRIVCONVERSO_ARRAY();
         if( rowPrivConversoArray == null )
           {
            rowPrivConversoArray = new ROWPRIVCONVERSO_ARRAY();
           }

            Enumeration<ROWPRIVCONVERSO> privConverEnumeration = rowPrivConversoArray.enumerateROWPRIVCONVERSO();
          
         
          while (privConverEnumeration.hasMoreElements()){
             ROWPRIVCONVERSO rowPrivConverso = (ROWPRIVCONVERSO)privConverEnumeration.nextElement();
             if (rowPrivConverso.getUlIdPerson() == csys08soRow.getUlIdPerson()){
                 szCheckedPrivConver = "true";
             }
          }           
         
                      out.write("\r\n           \r\n          <td>");
                      //  impact:validateInput
                      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                      _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
                      _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                      _jspx_th_impact_validateInput_11.setTabIndex( _tabIndex++ );
                      _jspx_th_impact_validateInput_11.setType("checkbox");
                      _jspx_th_impact_validateInput_11.setName(cbxNamePrivConver);
                      _jspx_th_impact_validateInput_11.setChecked( szCheckedPrivConver);
                      _jspx_th_impact_validateInput_11.setDisabled( modifyDisabled );
                      _jspx_th_impact_validateInput_11.setValue( String.valueOf(i) );
                      _jspx_th_impact_validateInput_11.setEditableMode( EditableMode.DEFAULT );
                      int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
                      if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n          </td>\r\n\r\n          ");
 // SMS #109398: MR-086
          String cbxDiscussed = "cbxDiscussed" + ( i + 1 );
          String szCheckedDiscussed = "false";    
          ROWDISCUSSEDSO_ARRAY rowDiscussedsoArray = _csys08so.getROWDISCUSSEDSO_ARRAY();
          if( rowDiscussedsoArray == null )
           {
            rowDiscussedsoArray = new ROWDISCUSSEDSO_ARRAY();
           }

            Enumeration<ROWDISCUSSEDSO> discussedEnumeration = rowDiscussedsoArray.enumerateROWDISCUSSEDSO();
          
         
          while (discussedEnumeration.hasMoreElements()){
             ROWDISCUSSEDSO rowDiscussedso = (ROWDISCUSSEDSO)discussedEnumeration.nextElement();
             if (rowDiscussedso.getUlIdPerson() == csys08soRow.getUlIdPerson()){
               szCheckedDiscussed = "true";
             }
          }        
         
                      out.write("\r\n          \r\n          <td>");
                      //  impact:validateInput
                      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                      _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
                      _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                      _jspx_th_impact_validateInput_12.setTabIndex( _tabIndex++ );
                      _jspx_th_impact_validateInput_12.setType("checkbox");
                      _jspx_th_impact_validateInput_12.setName(cbxDiscussed);
                      _jspx_th_impact_validateInput_12.setChecked( szCheckedDiscussed);
                      _jspx_th_impact_validateInput_12.setDisabled( modifyDisabled );
                      _jspx_th_impact_validateInput_12.setValue( String.valueOf(i) );
                      _jspx_th_impact_validateInput_12.setEditableMode( EditableMode.DEFAULT );
                      int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
                      if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n          </td>\r\n          ");
                      out.write("\r\n          \r\n     </tr>\r\n        ");

          i++;
           }
          }
        
                      out.write("\r\n </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"4\">");
                      int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</td>\r\n</tr>\r\n");
                  out.write("\r\n\r\n");
                  out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  //SIR 18433 - set Javascript vics and purps to correct values, if needed.\r\n  ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_8.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_ifThen_8.setTest( (vics > 0) );
                  int _jspx_eval_impact_ifThen_8 = _jspx_th_impact_ifThen_8.doStartTag();
                  if (_jspx_eval_impact_ifThen_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n  document.frmContactDetail.hdnBVictimSelected.value = \"Y\";\r\n  vics = ");
                      out.print( vics );
                      out.write(";\r\n  ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_8.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n  ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_9.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_ifThen_9.setTest( (perps > 0) );
                  int _jspx_eval_impact_ifThen_9 = _jspx_th_impact_ifThen_9.doStartTag();
                  if (_jspx_eval_impact_ifThen_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n  document.frmContactDetail.hdnBPerpSelected.value = \"Y\";\r\n  perps = ");
                      out.print( perps );
                      out.write(";\r\n  ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_9.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n</script>\r\n");

    request.setAttribute( "tabIndex", _tabIndex );
  }

                  out.write('\r');
                  out.write('\n');
                  out.write("\r\n      ");
                  out.write("\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

    tabIndex = (Integer) request.getAttribute("tabIndex");

        // Moved table close tag down here.
  
          out.write("\r\n</table>\r\n\r\n");

  // All Contacts have a modifiable Date except the AFC Contacts EDOC, EENV,
      // EEXR, EFAC, EPHY which all prefill with the current date and are locked.
      //
      // CPS cases do not have a Time.
      //
      // APS cases have a modifiable Time except the AFC Contacts EDOC, EENV, EEXR,
      // EFAC , EPHY, CLEV, CLES (SIR 23410) which prefill with the currente time and are non-modifiable.
      //
      // Initial Presentation Mode:
      // A Contact Type can be selected and the Continue Button is shown.
      //
      // Detail Presentation Mode:
      // The Select Staff Button allows you to change Contacted By.
      // The Attempted & Attempted checkbox, Purpose, Method, Location,
      // Attempted and Principal Collaterals checkboxes are modifiable.
      // The Purpose, Method, Location, and Others Contacted fields are modifiable
      // for the programs except for CLES and CLEV (SIR 23410).
      //
      // Summary Presentation Mode:
      // The Select Staff Button, Attempted checkbox, Purpose, Method, Location,
      // Others fields and Principal/Collaterals checkboxes don't exist.
      // The following Summary Contacts have a Summary Period: EEXR, BMTH, GMTH,
      // HMTH, JMTH, IREZ, IATZ, IDVZ, IPHZ, IMAZ, IQUZ, IREE, ISEZ, IVAZ, IVIZ.
      //
      //
      //SIR 23298 added AGR to  and submit
      String[] Submit = { "EXR", "MTH", "AGR" };
      String[] SubmitFAD = { "ATP", "ATZ", "CMP", "DVP", "DVZ", "FCL", "MAS", "MAZ", "PHS", "PHZ", "QUV", "QUZ",
                            "REA", "REE", "REG", "REZ", "SEI", "SEZ", "STS", "VAR", "VAZ", "VIO", "VIZ" };

      boolean display = true;
      // SIR 18274 - For an Extension Request Hide the  Button if there is a
      // UlIdEvent, if there is not, hide the  and Submit Button.
      if (CodesTables.CCNTCTYP_EEXR.equals(selSzCdContactType) && GlobalData.getUlIdEvent(request) != 0) {
        display = false;
      }

      // Grab charcters two to four of selSzCdContact Type for comparisons.  The
      // first character is a key to determine the type of case and stage and we
      // don't need to compare that.  Example:  AREG is a Contact for a CPS INV
      // Case, and a BREG is a Contact for a CPS FPR Case.
      //String contactType = selSzCdContactType.substring( 1, 4 );
      String contactType = selSzCdContactType.substring(0, 3);

      boolean displaySubmit = false;
      // Set displaySubmit to true if AndSubmit button should be shown
      for (int i = 0; i < Submit.length; i++) {
        if (contactType.equals(Submit[i])) {
          displaySubmit = true;
        }
      }

      //Set true if it's a FAD Program and one of the types in the array
      if (szCdStage.equals(CodesTables.CSTAGES_FAD)) {
        for (int i = 0; i < SubmitFAD.length; i++) {
          if (contactType.equals(SubmitFAD[i])) {
            displaySubmit = true;
          }
        }
      }

      if (CodesTables.CCNTCTYP_EEXR.equals(selSzCdContactType) && GlobalData.getUlIdEvent(request) == 0) {
        displaySubmit = false;
      }

      // SIR 17669 Do not display the  and submit pushbutton when the
      // page is in approval mode either
      if (GlobalData.isApprovalMode(request)) {
        displaySubmit = false;
      }

          out.write("\r\n\r\n<script type=\"text/JavaScript\" language=\"javascript\">\r\n  ");
          out.write("\r\n  \r\n function onClickOfNarrType()\r\n  { \r\n  var narrType = \"");
          out.print( csys08so.getSzCdContactNarr() );
          out.write("\";\r\n  var narrTypeSelected = \"\";\r\n  var docTypeNarr = \"\";\r\n  \r\n  if(document.frmContactDetail.rbNarrType[0].checked){\r\n     narrTypeSelected = \"STD\";\r\n     docTypeNarr = \"BLANKNAR\";\r\n  }else if(document.frmContactDetail.rbNarrType[1].checked){\r\n     narrTypeSelected = \"PCV\";\r\n     docTypeNarr = \"cvisitn\";\r\n  }else {\r\n    narrTypeSelected = \"SPW\";\r\n    docTypeNarr = \"spwbnarr\";\r\n  }\r\n  \r\n  // If the same radio button is clicked that was selected when the page loaded then ignore.\r\n  if (narrType == narrTypeSelected){\r\n    return true;\r\n  } else {\r\n    document.frmDocument.promptSavePage.value = 'frmContactDetail';\r\n  } \r\n\r\n  if (document.frmDocument.docExists.value == 'true' && (narrType != narrTypeSelected)){\r\n      if (confirm('The existing narrative will be deleted and all the information will be lost if the narrative type is changed. Are you sure you want to change the narrative type?  Click OK to continue.'))\r\n      {\r\n         document.frmDocument.promptSavePage.value = 'frmContactDetail';\r\n         document.frmContactDetail.hidDeleteDocument.value = 'true';\r\n");
          out.write("      }\r\n      else\r\n      {\r\n         //Set the radio button back\r\n         if (narrType == \"STD\") {\r\n           document.frmContactDetail.rbNarrType[0].checked = true;\r\n         } else if (narrType == \"PCV\") {\r\n           document.frmContactDetail.rbNarrType[1].checked = true;\r\n         } else if (narrType == \"SPW\") {\r\n           document.frmContactDetail.rbNarrType[2].checked = true;\r\n         }\r\n       }\r\n  }   \r\n}\r\n    \r\n  \r\n</script>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n<tr>\r\n   \r\n  \r\n </td>\r\n <td align=\"right\" width=\"10%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAction("/contacts/PortalContactDetail/saveContact");
          _jspx_th_impact_ButtonTag_0.setForm("frmContactDetail");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n </td>\r\n</tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width= \"100%\" class=\"tableBorder\" >\r\n  \t  <tr> \r\n         <td width=\"20%\">Narrative Type: \r\n        </td> \r\n  \t\t  \t<td></td><td width=\"20%\">\t   \r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setChecked(CodesTables.CCONNARR_STD.equals(checkedNarrativeType) ? "true" : "false");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setValue("STD");
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setName("rbNarrType");
          _jspx_th_impact_validateInput_13.setLabel("Standard");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setOnClick("return onClickOfNarrType();");
          _jspx_th_impact_validateInput_13.setDisabled(disableAttempted);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t    <td></td><td width=\"25%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setChecked(CodesTables.CCONNARR_PCV.equals(checkedNarrativeType) ? "true" : "false");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setValue("PCV");
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setName("rbNarrType");
          _jspx_th_impact_validateInput_14.setLabel("Parent/Child Visitation");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setOnClick("return onClickOfNarrType();");
          _jspx_th_impact_validateInput_14.setDisabled(disableAttempted);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td><td width=\"35%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setChecked(CodesTables.CCONNARR_SPW.equals(checkedNarrativeType) ? "true" : "false");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setValue("SPW");
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setName("rbNarrType");
          _jspx_th_impact_validateInput_15.setLabel("Safety, Permanency and Wellbeing");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setOnClick("return onClickOfNarrType();");
          _jspx_th_impact_validateInput_15.setDisabled(disableAttempted);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td><td></td>\r\n\t\t</tr>\r\n</table>\r\n<br/>\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_10.setTest(extComment);
          int _jspx_eval_impact_ifThen_10 = _jspx_th_impact_ifThen_10.doStartTag();
          if (_jspx_eval_impact_ifThen_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" align=\"right\" width= \"100%\" class=\"tableBorder\" >\r\n  \t\t\t<tr>\r\n  \t\t\t<td> \r\n\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_10);
              _jspx_th_impact_validateInput_16.setChecked(cbxBIndExtComment);
              _jspx_th_impact_validateInput_16.setValue(cbxBIndExtComment);
              _jspx_th_impact_validateInput_16.setType("checkbox");
              _jspx_th_impact_validateInput_16.setLabel("External  User Comments Accepted");
              _jspx_th_impact_validateInput_16.setName("cbxBIndExtComment");
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setDisabled("true");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t<td width=\"20%\">Checking this box indicates that the documentation has been received by the case manager and that the documentation is complete.\r\n\t\t\t</td>\r\n\t\t\t</tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_10.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_17(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_18(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write(' ');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("nEvent");
          _jspx_th_impact_validateInput_20.setValue((String) request.getAttribute("nEvent"));
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("nCase");
          _jspx_th_impact_validateInput_21.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_22(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName("IntakeDate");
          _jspx_th_impact_validateInput_23.setValue(hdnIntakeDate);
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("hdnIntakeTime");
          _jspx_th_impact_validateInput_24.setValue(hdnIntakeTime);
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_25.setValue(tsLastUpdate);
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName("hdnUlIdPerson");
          _jspx_th_impact_validateInput_26.setValue(String.valueOf(GlobalData.getUlIdPerson(request)));
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("hidden");
          _jspx_th_impact_validateInput_27.setName("hdnEnteredOn");
          _jspx_th_impact_validateInput_27.setValue(hdnEnteredOn);
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(' ');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("hidden");
          _jspx_th_impact_validateInput_28.setName("hdnUlIdPlcmtFacil");
          _jspx_th_impact_validateInput_28.setValue( FormattingHelper.formatLong(hdnUlIdPlcmtFacil));
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("hidden");
          _jspx_th_impact_validateInput_29.setName("hdnUlIdPlcmtAgency");
          _jspx_th_impact_validateInput_29.setValue( FormattingHelper.formatLong(hdnUlIdPlcmtAgency));
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

    boolean docExists = false;
    boolean bProtect = true;
    boolean stageIsOpen = false;
    boolean commentMode = false;
    if (ArchitectureConstants.TRUE.equals(request.getAttribute(PortalContactDetailConversation.DOCEXISTS))) {
      docExists = true;
    }
    
    // SIR 18384 - Had to set bProtect to false if in Approval mode
    String sDate = FormattingHelper.formatTimestamp(csys08so.getTsLastUpdate());
    if (csys08so.getDtDtStageClose() == null) {
      stageIsOpen = true;
    }    
    
    // editAllowed = If it is within 7 days, the user is the original author, not TCM billed.
    // i.e stage was still open while contact was updated
    //ISDATEBEFORESTAGECLOSE will take into account if the stage was closed or open and if the stage was closed
    //check if the contact was entered before or after stage closure.
    if(ArchitectureConstants.TRUE.equals(editAllowed)  &&  ArchitectureConstants.FALSE.equals(state.getAttribute("ISDATEBEFORESTAGECLOSE", request))
    || ("true".equals(indSauSealedHomeAndWorker) && "true".equals(editAllowedSevenDays) && "false".equals(isContactBeforeStageClosure))){
      bProtect = false;
      commentMode = true;
    }     
      
    if (GlobalData.isApprovalMode(request)) {
      bProtect = false;
      commentMode = true;    
    }
    
    // If it is NOT within 7 days, the user is the original author,has stage access and has ever been assigned.
    if(ArchitectureConstants.FALSE.equals(editAllowed) || ArchitectureConstants.TRUE.equals(state.getAttribute("ISDATEBEFORESTAGECLOSE", request))  ){ // If it is NOT  (within 7 days && the user is the original author and not TCM billed) 
     if (ArchitectureConstants.TRUE.equals(state.getAttribute("FORMCOMMENTSACCESS", request)) || "true".equals(indSauSealedHomeAndWorker) ){
      bProtect = true;
      commentMode = true;
    }
    }
    
    
        
    
   
    // SIR 18956 - We have to moneky around with the Narrative that will be
    // displayed because CIFF use to be able to be either a FACTOFAC or NORMAL,
    // and C24H could have been 24HOUR or NORMAL, so we added C24N (NORMAL) and
    // CFTF (FACTOFAC).  All of this has to do with APS SVC vs APS INV stages.
    String docType = selSzCdContactType;
    String docTypeNarr = "BLANKNAR";
    //docType will be set to "CIFF" by default, change it to "CFTF" if needed
    if (CodesTables.CCNTCTYP_CIFF.equals(docType) && CodesTables.CSTAGES_INV.equals(szCdStage)) {
      docType = CodesTables.CCNTCTYP_CFTF;
    }

    if ("PVC".equals(docType.substring(1, 4)) || CodesTables.CCONNARR_PCV.equals(checkedNarrativeType)) {
      docTypeNarr = "cvisitn";
    }
    
    if(CodesTables.CCONNARR_STD.equals(checkedNarrativeType)){
      docTypeNarr = "BLANKNAR";
    }
    
    if(CodesTables.CCONNARR_SPW.equals(checkedNarrativeType)){
      docTypeNarr = "spwbnarr";
    }

    //  MR - 024 SafetyResourceAssessment narrative has been removed from this page.
    //if ("SRA".equals(docType.substring(1, 4))) {
    //  docTypeNarr = "fas05o00";
    //  }
    
    
    //docType will be set to "C24H" by default, change it to "C24N" if needed
    if (CodesTables.CCNTCTYP_C24H.equals(docType) && CodesTables.CSTAGES_SVC.equals(szCdStage)) {
      docType = CodesTables.CCNTCTYP_C24N;
    }

    String szCdStageType = GlobalData.getSzCdStageType(request);
    boolean displayNarrativeButton = true;
    // SIR 18974 - There is no narrative button for PAL Notifications (JNOT)
    // If logic was erroneously comparing JNOT to Stage instead of Contact Type
    // Sir 23686 - For APS, when contact Types are C24N,CMST and CIFF display narrative
    // button only if documemt already exist or stage type is C-REG or C-GUA.

    if ((CodesTables.CCNTCTYP_JNOT.equals(selSzCdContactType))
        || (CodesTables.CPGRMSFM_APS.equals(GlobalData.getSzCdStageProgram(request)) && ((!CodesTables.CSTGTYPE_CGUA
                                                                                                                    .equals(szCdStageType) && !CodesTables.CSTGTYPE_CREG
                                                                                                                                                                        .equals(szCdStageType))
                                                                                         && (CodesTables.CCNTCTYP_C24N
                                                                                                                      .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_C24H
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_CMST
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_EIFF
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_CFTF
                                                                                                                         .equals(docType) || CodesTables.CCNTCTYP_CIFF
                                                                                                                                                                      .equals(docType)) && !docExists))) {
      displayNarrativeButton = false;
    }

    // You always show the Narrative button for a Closed Stage Addendum but you
    // shouldn't pass in checkStage.  This way anyone can edit a FCCA Narrative.
    int checkStage = GlobalData.getUlIdStage(request);
    if (CodesTables.CCNTCTYP_FCCA.equals(selSzCdContactType)) {
      checkStage = 0;
    }

    if (CodesTables.CCNTCTYP_FCCA.equals(selSzCdContactType) || displayNarrativeButton) {

      out.write("\r\n<tr>\r\n  <td>\r\n    <br>\r\n    ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode(pageMode);
      _jspx_th_impact_documentButton_0.setTabIndex(tabIndex++);
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n      ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("Document");
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setName("frmDocument");
          _jspx_th_impact_document_0.setCheckStage(checkStage);
          _jspx_th_impact_document_0.setProtectDocument(bProtect);
          _jspx_th_impact_document_0.setCommentMode(commentMode);
          _jspx_th_impact_document_0.setDeleteDocument(false);
          _jspx_th_impact_document_0.setDocType(docTypeNarr);
          _jspx_th_impact_document_0.setDocExists(docExists);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n        ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sEvent");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(GlobalData.getUlIdEvent(request)));
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("sCase");
              _jspx_th_impact_documentParameter_1.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("sTimestamp");
              _jspx_th_impact_documentParameter_2.setValue( sDate );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pCase");
              _jspx_th_impact_documentParameter_3.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_4.setName("pStage");
              _jspx_th_impact_documentParameter_4.setValue(String.valueOf(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_5.setName("pCdStage");
              _jspx_th_impact_documentParameter_5.setValue(String.valueOf(GlobalData.getSzCdStage(request)));
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  </td> \r\n</tr>\r\n</table>\r\n<script type=\"text/JavaScript\" language=\"javascript\">\r\n\r\n  document.frmContactDetail.hdnDocExists.value = '");
      out.print(docExists);
      out.write("';\r\n\r\n  function setDocTypeParam() {\r\n    document.frmContactDetail.docType.value = '");
      out.print(docTypeNarr);
      out.write("';\r\n  }\r\n  window.attachEvent('onload', setDocTypeParam);\r\n</script>\r\n");

  }

      out.write('\r');
      out.write('\n');

  }

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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
    _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Name    ");
    _jspx_th_impact_validateDisplayOnlyField_5.setConditionallyRequired("true");
    _jspx_th_impact_validateDisplayOnlyField_5.setName("");
    _jspx_th_impact_validateDisplayOnlyField_5.setValue("");
    int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_then_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnBVictimSelected");
    _jspx_th_impact_validateInput_6.setValue("N");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_then_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("hdnBPerpSelected");
    _jspx_th_impact_validateInput_7.setValue("N");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_17(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_17.setName("hidDeleteDocument");
    _jspx_th_impact_validateInput_17.setType("hidden");
    _jspx_th_impact_validateInput_17.setValue("false");
    int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
    if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_18(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_18.setType("hidden");
    _jspx_th_impact_validateInput_18.setName("hdnDocExists");
    _jspx_th_impact_validateInput_18.setValue("false");
    int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
    if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_22(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_22.setType("hidden");
    _jspx_th_impact_validateInput_22.setName("docType");
    _jspx_th_impact_validateInput_22.setValue("");
    int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
    if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
