package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.DomicileDeprivationDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.fce.DomicileDeprivationConversation;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.DomicileDeprivationDB;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FosterCareReviewConversation;
import gov.georgia.dhr.dfcs.sacwis.web.fce.DomicileDeprivationConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;

public final class DomicileDeprivation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/fce/DeprivationBothSub.jsp");
    _jspx_dependants.add("/grnds-docs/fce/DeprivationOneSub.jsp");
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


  //*  JSP Name:     Domicile and Deprevation
  //*  Created by:   Rodrigo DeJuana
  //*  Date Created: 02/17/02
  //*
  //*  Description:
  //*  When we first started looking at this page, we thought the javascript was
  //*  going to be nightmare.  We tried to reuse the code for each section, but
  //*  that jsut became a pain, but we did like the secitoned off code.  So before
  //*  you start to tear you hair out trying to figure out what i did, let me tell
  //*  you.  The whole page is written as blocks with place holders.  Each section
  //*  is its own div tag.  The is javascript that control what gets displayed.
  //*  The javascript basically does a lot of innerHtml moves.  For exmaple there is a
  //*  table cell right below it the Both parents radio button that is empty but named.
  //*  And there is a div section named Both.  When i click on the Both parents radio button,
  //*  the javascript will move the html within the Both div section into the
  //*  empty placeholder.  If i select another radio button, the html is moved
  //*  back to the div section.  Here's the cool part, if i reselect the Both
  //*  radio button, it remebers what was selected in that session (ie, it will
  //*  only save what is visible).  Now go an play with it, it really is kind of cool. :)
  //*
  /* Change History:
   Date      User              Description
   --------  ----------------  --------------------------------------------------
   06/11/03  Todd Reser        SIR 18232 - Fixed mispelling of irregularly
   11/09/10  Hai Nguyen        SMS#81144: MR-053 Added new questions to determine deprivation.
                               Remove Confirmation section and associated fields and buttons.
                               Remove Date of Deprivation Change section and associated fields.
                               Remove Month and Year field and change to Removal Date.
                               Replace PE radio buttons to dropdown to select actual PE.
                               Removed Edit button and added Continue button.
   12/07/10                    SMS#81144: MR-053 Added logic to display old deprivation
                               determination that was overrided by ES.
   12/14/10                    SMS#86169: MR-053 Update button mode to display for CM to
                               save system determination and navigate to next page for NOC
   01/20/11                    SMS#81144: Added message to complete NOTA section when relative 
                               does not meet criteria for specified relative.
   */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String fceApplicationPageMode = (String) request
                                                  .getAttribute(DomicileDeprivationConversation.FCE_APPLICATION_PAGE_MODE);

  String pageMode = PageMode.getPageMode(request);

  int tabIndex = 1;
  String formName = "frmDomicile";

  DomicileDeprivationDB domicileDB = (DomicileDeprivationDB) request
                                                                    .getAttribute(DomicileDeprivationConversation.DOMICILEDB);

  // This sets the color of the subsections.
  String bgColor = "#F0FFFF";

      out.write("\r\n\r\n\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n\r\nwindow.onload = function()\r\n{\r\n  ");
 if (pageMode.equals(PageModeConstants.EDIT)) { 
      out.write("\r\n  ");
   if ("R".equals(domicileDB.getCdApplication())) { 
      out.write("\r\n    setupPageInquire();\r\n  ");
   }else{ 
      out.write("\r\n    setupPageEdit();\r\n  ");
   }
     } else { 
      out.write("\r\n    setupPageInquire();\r\n  ");
}
      out.write("\r\n}\r\n\r\n\r\nfunction resetTargets()\r\n{\r\n  var obBoth       = document.getElementById(\"both\");\r\n  var obBothEmpty  = document.getElementById(\"bothEmpty\");\r\n  var obOne        = document.getElementById(\"one\");\r\n  var obOneEmpty   = document.getElementById(\"oneEmpty\");\r\n  var obOther      = document.getElementById(\"other\");\r\n  var obOtherEmpty = document.getElementById(\"otherEmpty\");\r\n  var obNone       = document.getElementById(\"none\");\r\n  var obNoneEmpty  = document.getElementById(\"noneEmpty\");\r\n  if (obBoth.innerHTML.length == 0)\r\n  {\r\n    swap(\"bothEmpty\", \"both\");\r\n  }\r\n  if (obOne.innerHTML.length == 0)\r\n  {\r\n    swap(\"oneEmpty\", \"one\");\r\n  }\r\n  if (obOther.innerHTML.length == 0)\r\n  {\r\n    swap(\"otherEmpty\", \"other\");\r\n  }\r\n  if (obNone.innerHTML.length == 0)\r\n  {\r\n    swap(\"noneEmpty\", \"none\");\r\n  }\r\n}\r\n\r\n\r\nfunction reset6MnthTargets()\r\n{\r\n  var obBoth       = document.getElementById(\"both\");\r\n  var obBothEmpty  = document.getElementById(\"6MnthBothEmpty\");\r\n  var obOne        = document.getElementById(\"one\");\r\n");
      out.write("  var obOneEmpty   = document.getElementById(\"6MnthOneEmpty\");\r\n  var obOther      = document.getElementById(\"6MnthOther\");\r\n  var obOtherEmpty = document.getElementById(\"6MnthOtherEmpty\");\r\n  if (obBoth.innerHTML.length == 0)\r\n  {\r\n    swap(\"6MnthBothEmpty\", \"both\");\r\n  }\r\n  if (obOne.innerHTML.length == 0)\r\n  {\r\n    swap(\"6MnthOneEmpty\", \"one\");\r\n  }\r\n  if (obOther.innerHTML.length == 0)\r\n  {\r\n    swap(\"6MnthOtherEmpty\", \"6MnthOther\");\r\n  }\r\n}\r\n\r\n\r\nfunction setNoneOfTheAbove(value)\r\n{\r\n  if (value == 'yes')\r\n  {\r\n    swap(\"6Mnth\", \"6MnthEmpty\");\r\n  }\r\n  else\r\n  {\r\n    var ob6MnthEmpty = document.getElementById(\"6MnthEmpty\");\r\n    if (ob6MnthEmpty.innerHTML.length != 0)\r\n    {\r\n      swap(\"6MnthEmpty\", \"6Mnth\");\r\n    }\r\n  }\r\n}\r\n\r\n\r\nfunction set6MnthSubsection(source, target)\r\n{\r\n  reset6MnthTargets();\r\n  swap(source, target);\r\n}\r\n\r\n\r\nfunction setSubsection(source, target)\r\n{\r\n  resetTargets();\r\n  swap(source, target);\r\n}\r\n\r\n\r\nfunction clearNota()\r\n{\r\n  reset6MnthTargets();\r\n\r\n  var form = document.");
      out.print(formName);
      out.write(";\r\n  setNoneOfTheAbove('no');\r\n  form.indChildLivingPrnt6Mnths[0].checked = false;\r\n  form.indChildLivingPrnt6Mnths[1].checked = false;\r\n  form.txtMonthsLivingRelCust.value = \"\";\r\n  form.cdNotaMostRecent[0].checked = false;\r\n  form.cdNotaMostRecent[1].checked = false;\r\n  form.cdNotaMostRecent[2].checked = false;\r\n}\r\n\r\n\r\nfunction swap(source, target)\r\n{\r\n  var obSource = document.getElementById(source);\r\n  var obTarget = document.getElementById(target);\r\n  obTarget.innerHTML = obSource.innerHTML;\r\n  obSource.innerHTML = \"\";\r\n}\r\n\r\n\r\nfunction setupPageEdit()\r\n{\r\n  if (document.");
      out.print(formName);
      out.write(".cdLivingMonthRemoval[0].checked)\r\n  {\r\n    setSubsection('both', 'bothEmpty');\r\n  }\r\n  if (document.");
      out.print(formName);
      out.write(".cdLivingMonthRemoval[1].checked)\r\n  {\r\n    setSubsection('one', 'oneEmpty');\r\n  }\r\n  if (document.");
      out.print(formName);
      out.write(".cdLivingMonthRemoval[2].checked)\r\n  {\r\n    setSubsection('other', 'otherEmpty');\r\n  }\r\n  if (document.");
      out.print(formName);
      out.write(".cdLivingMonthRemoval[3].checked)\r\n  {\r\n    setSubsection('none', 'noneEmpty');\r\n    if (document.");
      out.print(formName);
      out.write(".indChildLivingPrnt6Mnths[0].checked)\r\n    {\r\n      setNoneOfTheAbove('yes');\r\n      if (document.");
      out.print(formName);
      out.write(".cdNotaMostRecent[0].checked)\r\n      {\r\n        set6MnthSubsection('both', '6MnthBothEmpty');\r\n      }\r\n      if (document.");
      out.print(formName);
      out.write(".cdNotaMostRecent[1].checked)\r\n      {\r\n        set6MnthSubsection('one', '6MnthOneEmpty');\r\n      }\r\n      if (document.");
      out.print(formName);
      out.write(".cdNotaMostRecent[2].checked)\r\n      {\r\n        set6MnthSubsection('6MnthOther', '6MnthOtherEmpty');\r\n      }\r\n    }\r\n  }\r\n}\r\n\r\n\r\nfunction setupPageInquire()\r\n{\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest(CodesTables.CFCELIV_B.equals(domicileDB.getCdLivingMonthRemoval()));
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n         setSubsection('both', 'bothEmpty');\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_1.setParent(null);
      _jspx_th_impact_ifThen_1.setTest(CodesTables.CFCELIV_O.equals(domicileDB.getCdLivingMonthRemoval()));
      int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
      if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n         setSubsection('one', 'oneEmpty');\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_2.setParent(null);
      _jspx_th_impact_ifThen_2.setTest(CodesTables.CFCELIV_R.equals(domicileDB.getCdLivingMonthRemoval()));
      int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
      if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n         setSubsection('other', 'otherEmpty');\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_3.setParent(null);
      _jspx_th_impact_ifThen_3.setTest(CodesTables.CFCELIV_N.equals(domicileDB.getCdLivingMonthRemoval()));
      int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
      if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n         setSubsection('none', 'noneEmpty');\r\n\r\n    ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
          _jspx_th_impact_ifThen_4.setTest(domicileDB.getIndChildLivingPrnt6Mnths());
          int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
          if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n         setNoneOfTheAbove('yes');\r\n      ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
              _jspx_th_impact_ifThen_5.setTest(CodesTables.CFCELIV6_B.equals(domicileDB.getCdNotaMostRecent()));
              int _jspx_eval_impact_ifThen_5 = _jspx_th_impact_ifThen_5.doStartTag();
              if (_jspx_eval_impact_ifThen_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n         set6MnthSubsection('both', '6MnthBothEmpty');\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
              _jspx_th_impact_ifThen_6.setTest(CodesTables.CFCELIV6_O.equals(domicileDB.getCdNotaMostRecent()));
              int _jspx_eval_impact_ifThen_6 = _jspx_th_impact_ifThen_6.doStartTag();
              if (_jspx_eval_impact_ifThen_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n         set6MnthSubsection('one', '6MnthOneEmpty');\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
              _jspx_th_impact_ifThen_7.setTest(CodesTables.CFCELIV6_R.equals(domicileDB.getCdNotaMostRecent()));
              int _jspx_eval_impact_ifThen_7 = _jspx_th_impact_ifThen_7.doStartTag();
              if (_jspx_eval_impact_ifThen_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n         set6MnthSubsection('6MnthOther', '6MnthOtherEmpty');\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n}\r\n\r\n\r\nfunction edit()\r\n{\r\n  disableValidation('");
      out.print(formName);
      out.write("');\r\n}\r\n\r\nfunction showNotSpecifiedRelative()\r\n{\r\n  var section = document.getElementById('notSpecifiedRelative');\r\n  section.style.display = 'block';    \r\n}\r\n\r\nfunction hideNotSpecifiedRelative()\r\n{\r\n  var section = document.getElementById('notSpecifiedRelative');\r\n  section.style.display = 'none';    \r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName(formName);
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fcElig/DomicileDeprivation/saveDomicile");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.DomicileDeprivationCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n\t<!-- Hidden Fields -->\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("idFceApplication");
          _jspx_th_impact_validateInput_0.setValue(domicileDB.getIdFceApplicationString());
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("idFceEligibility");
          _jspx_th_impact_validateInput_1.setValue(domicileDB.getIdFceEligibilityString());
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("idEvent");
          _jspx_th_impact_validateInput_2.setValue(domicileDB.getIdEventString());
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("idStage");
          _jspx_th_impact_validateInput_3.setValue(domicileDB.getIdStageString());
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("fceApplicationDtLastUpdateTime");
          _jspx_th_impact_validateInput_4.setValue("" + domicileDB.getFceApplicationDtLastUpdateTime());
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("fceEligibilityDtLastUpdateTime");
          _jspx_th_impact_validateInput_5.setValue("" + domicileDB.getFceEligibilityDtLastUpdateTime());
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("idLastUpdatePerson");
          _jspx_th_impact_validateInput_6.setValue("" + BasePrsConversation.getUserID(request));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("indMeetsDpOrNotSystem");
          _jspx_th_impact_validateInput_7.setValue(domicileDB.getIndMeetsDpOrNotSystemString());
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("cdApplication");
          _jspx_th_impact_validateInput_8.setValue(domicileDB.getCdApplication());
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("currentLivingArrangements");
          _jspx_th_impact_validateInput_9.setValue(domicileDB.getCdLivingMonthRemoval());
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("currentNota");
          _jspx_th_impact_validateInput_10.setValue(domicileDB.getCdNotaMostRecent());
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("cdEventStatus");
          _jspx_th_impact_validateInput_11.setValue(domicileDB.getCdEventStatus());
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<!--- Begin Detail Table --->\r\n\t");

	  UserProfile user = UserProfileHelper.getUserProfile(request);

	    String bDisabled = "" + PageModeConstants.VIEW.equals(fceApplicationPageMode);
	    if ((pageMode.equals(PageModeConstants.VIEW) || pageMode.equals(PageModeConstants.EDIT))
	        && ((EventHelper.APPROVED_EVENT.equals(domicileDB.getCdEventStatus())) || ((user
	                                                                                        .hasRight(UserProfile.SEC_ELIGIBILITY)) && ((EventHelper.PENDING_EVENT
	                                                                                                                                                              .equals(domicileDB
	                                                                                                                                                                                .getCdEventStatus())) || (EventHelper.COMPLETE_EVENT
	                                                                                                                                                                                                                                    .equals(domicileDB
	                                                                                                                                                                                                                                                      .getCdEventStatus())))))) {
	
          out.write("\r\n\t<br>\r\n\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t<tr>\r\n");

    // MR-053 This is to handle old deprivation determination that were overriden by ES
    if( EventHelper.APPROVED_EVENT.equals(domicileDB.getCdEventStatus()) && domicileDB.getIndMeetsDpOrNotEsObject() != null ) {

          out.write("\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\tEligibility Specialist has determined that the child\r\n\t\t\t\t<b>");
          out.print(domicileDB.getIndMeetsDpOrNotEs() ? "meets" : "does not meet");
          out.write("</b>\r\n\t\t\t\tTitle IV-E Requirements for Deprivation.\r\n\t\t\t</td>\r\n");

    } else {

          out.write("\r\n            <td colspan=\"2\">\r\n                The system has determined that the child\r\n                <b>");
          out.print(domicileDB.getIndMeetsDpOrNotSystem() ? "meets" : "does not meet");
          out.write("</b>\r\n                Title IV-E Requirements for Deprivation.\r\n            </td>\r\n");

    }

          out.write("\r\n\t\t</tr>\r\n\t</table>\r\n    <br>\r\n\t");

	  }
	
          out.write("\r\n\r\n\t<div id=\"main\" style=\"display: block\">\r\n\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\"\r\n\t\t\tclass=\"tableBorder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th>\r\n\t\t\t\t\tDetermination of Removal Household and Deprivation of Parental\r\n\t\t\t\t\tSupport\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>Removal Date: ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dtRemovalDate");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(domicileDB.getDtRemovalDateString());
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\tSpecify the child's living arrangement at the time of removal.\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setName("cdLivingMonthRemoval");
          _jspx_th_impact_validateInput_12.setLabel("Living with Both Legal or Biological Parents");
          _jspx_th_impact_validateInput_12.setChecked("" + (DomicileDeprivationConversation.LIV_ARR_BOTH.equals(domicileDB.getCdLivingMonthRemoval())));
          _jspx_th_impact_validateInput_12.setValue("B");
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setId("1");
          _jspx_th_impact_validateInput_12.setOnClick("clearNota(); setSubsection('both', 'bothEmpty')");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td id=\"bothEmpty\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setName("cdLivingMonthRemoval");
          _jspx_th_impact_validateInput_13.setLabel("Living With One Legal or Biological Parent");
          _jspx_th_impact_validateInput_13.setChecked("" + (DomicileDeprivationConversation.LIV_ARR_ONE.equals(domicileDB.getCdLivingMonthRemoval())));
          _jspx_th_impact_validateInput_13.setValue("O");
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setId("2");
          _jspx_th_impact_validateInput_13.setOnClick("clearNota(); setSubsection('one', 'oneEmpty')");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td id=\"oneEmpty\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setName("cdLivingMonthRemoval");
          _jspx_th_impact_validateInput_14.setLabel("");
          _jspx_th_impact_validateInput_14.setChecked(""
                  + (DomicileDeprivationConversation.LIV_ARR_OTHER.equals(domicileDB.getCdLivingMonthRemoval())));
          _jspx_th_impact_validateInput_14.setValue("R");
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setId("3");
          _jspx_th_impact_validateInput_14.setOnClick("clearNota(); setSubsection('other', 'otherEmpty')");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\tLiving With <span ><a href=\"javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')\">Specified Relative</a></span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td id=\"otherEmpty\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setName("cdLivingMonthRemoval");
          _jspx_th_impact_validateInput_15.setLabel("None of the Above");
          _jspx_th_impact_validateInput_15.setChecked("" + (DomicileDeprivationConversation.LIV_ARR_NONE.equals(domicileDB.getCdLivingMonthRemoval())));
          _jspx_th_impact_validateInput_15.setValue("N");
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setId("4");
          _jspx_th_impact_validateInput_15.setOnClick("setSubsection('none', 'noneEmpty')");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td id=\"noneEmpty\"></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t</div>\r\n\r\n\r\n\r\n\t<div id=\"both\" style=\"display: none\">\r\n\t\t");

		  request.setAttribute("tabIndex", tabIndex);
		    request.setAttribute("disableDeprivation", false);
		    request.setAttribute("fceEligibilityDB", domicileDB.getFceEligibility());
		
          out.write("\r\n\t\t");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  10/18/04  Todd Reser        SIR 23056 - Added many JavaScript functions,
                              onClick commands added to certain fields, and
                              added additional comments & change log.
  10/22/04  Todd Reser        Had to add null checks to JavaScript functions
                              and call Show functions depending on values in
                              other fields because initial page display wasn't
                              functioning if the page was not in editable mode.
                              Also added ** comment to display on page.
  11/09/04  Todd Reser        Added null check for indParentDisabled to stop a
                              JS error when checking it's values upon page load.
  04/29/05  wadesa            SIR 23304 - Modified wordage is Question: "Was the
                              PE unemployed during the month of removal?" to
                              "Is the PE currently unemployed?"
  11/16/10  Hai Nguyen        SMS#81144: MR-053 Added additional questions
                              Added dropdown for selection of Principal Earner.
  11/30/10  Hai Nguyen        SMS#81144: Corrected some page display issues with
                              javascript.
  12/12/10  Hai Nguyen        SMS#86169: Updated wording for question.
                              
*/

{
  String _bgColor = "#F0FFFF";
  // SIR 23056 - We need to see which page is calling this sub so we use the
  // right form name
  String localFormName = "";
  if ("DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION".equals(request.getAttribute("level3Tab")))
  {
    localFormName = "frmDomicile";
  }
  if ("FC_REVIEW_APPLICATION_FOSTERCAREDETAIL".equals(request.getAttribute("level3Tab")) ||
      "FC_REVIEW_APPLICATION_FOSTERCAREREVIEW".equals(request.getAttribute("level3Tab")) )
  {
    localFormName = "frmReview";
  }
  String localPageMode = PageMode.getPageMode(request);
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableDeprivation = "" + (Boolean) request.getAttribute("disableDeprivation");
  FceEligibilityDB _fceEligibilityDB = (FceEligibilityDB) request.getAttribute("fceEligibilityDB");
  DomicileDeprivationDB domicileDepDB = (DomicileDeprivationDB) request.getAttribute(DomicileDeprivationConversation.DOMICILEDB);

  //SIR 23056 - We have to see if the data is prior to the re-wording, contains
  //an N/A answer and not editable
  boolean lockedNA = false;
  if ( ( localPageMode.equals(PageModeConstants.INQUIRE) || localPageMode.equals(PageModeConstants.VIEW) ) &&
       ( FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) ||
         FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweIrregularUnder100())  ) )
  {
    lockedNA = true;
  }

  //Default amtPweIncomeString to nothing if there wasn't a value > 1 and not lockedNA.
  String amtPweIncomeString = "";
  if (_fceEligibilityDB.getAmtPweIncome()  >= 1 || lockedNA)
  {
    amtPweIncomeString = FormattingHelper.formatMoney(_fceEligibilityDB.getAmtPweIncome());
  }

  // SIR 23056 - The following Javascript functions show or hide the appropriate
  // sections.

          out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction showWasNotDisabled()\r\n{\r\n  var section = document.getElementById('wasNotDisabledSource');\r\n  section.style.display = 'block';\r\n  \r\n  if ( ( document.");
          out.print( localFormName );
          out.write(".cdPweSteadyUnder100[0] != null &&\r\n         document.");
          out.print( localFormName );
          out.write(".cdPweSteadyUnder100[0].checked == true ) ||\r\n       ( document.");
          out.print( localFormName );
          out.write(".cdPweSteadyUnder100 != null &&\r\n         document.");
          out.print( localFormName );
          out.write(".cdPweSteadyUnder100.value == 'Y' ) )\r\n  {\r\n    showWasNotEmployed();\r\n  }\r\n  else if ( ( document.");
          out.print( localFormName );
          out.write(".cdPweSteadyUnder100[1] != null &&\r\n         document.");
          out.print( localFormName );
          out.write(".cdPweSteadyUnder100[1].checked == true ) ||\r\n       ( document.");
          out.print( localFormName );
          out.write(".cdPweSteadyUnder100 != null &&\r\n         document.");
          out.print( localFormName );
          out.write(".cdPweSteadyUnder100.value == 'N' ) )\r\n  {\r\n    showWasEmployed();\r\n  }\r\n}\r\n\r\nfunction hideWasNotDisabled()\r\n{\r\n  hideWasNotEmployed();\r\n  hideWasEmployed();\r\n\r\n  var section = document.getElementById('wasNotDisabledSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWasDisabled()\r\n{\r\n  var section = document.getElementById('wasDisabledSource');\r\n  section.style.display = 'block';\r\n  \r\n  var e = document.getElementsByName('cdVerifMethod');\r\n  var v = getRadioButtonGroupValue('cdVerifMethod');\r\n\r\n  if( e != null && v == '");
          out.print( CodesTables.CVERMETH_D );
          out.write("' )\r\n  {\r\n    showVerifDocType();\r\n  } else if ( e != null && v == '");
          out.print( CodesTables.CVERMETH_M );
          out.write("' )\r\n  {\r\n    showMedicalEvidence();\r\n  }\r\n}\r\n\r\nfunction hideWasDisabled()\r\n{\r\n  var e = document.getElementsByName('cdVerifMethod');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideVerifDocType();\r\n  hideMedicalEvidence();\r\n\r\n  var section = document.getElementById('wasDisabledSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showMedicalEvidence()\r\n{\r\n  var section = document.getElementById('medicalEvidence');\r\n  section.style.display = 'block';\r\n}\r\n\r\nfunction hideMedicalEvidence()\r\n{\r\n  var section = document.getElementById('medicalEvidence');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showVerifDocType()\r\n{\r\n  var section = document.getElementById('verifDocType');\r\n  section.style.display = 'block';\r\n  \r\n  var e = document.getElementsByName('cdVerifDocType');\r\n  var v = getRadioButtonGroupValue('cdVerifDocType');\r\n  \r\n  if( e != null && (v == '");
          out.print( CodesTables.CDOCTYPE_RR );
          out.write("' ||\r\n                    v == '");
          out.print( CodesTables.CDOCTYPE_RS );
          out.write("' ))\r\n  {\r\n    showRecvRrRsdi();\r\n  } else if ( e != null && v == '");
          out.print( CodesTables.CDOCTYPE_VA );
          out.write("' )\r\n  {\r\n    showRecv100PctVa();\r\n  }\r\n}\r\n\r\nfunction hideVerifDocType()\r\n{\r\n  var e = document.getElementsByName('cdVerifDocType');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideRecvRrRsdi();\r\n  hideRecv100PctVa();\r\n\r\n  var section = document.getElementById('verifDocType');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showRecvRrRsdi()\r\n{\r\n  var section = document.getElementById('recvRrRsdi');\r\n  section.style.display = 'block';\r\n}\r\n\r\nfunction hideRecvRrRsdi()\r\n{\r\n  var e = document.getElementsByName('indRecvRrRsdi');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  var section = document.getElementById('recvRrRsdi');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showRecv100PctVa()\r\n{\r\n  var section = document.getElementById('recv100PctVa');\r\n  recv100PctVa.style.display = 'block';\r\n}\r\n\r\nfunction hideRecv100PctVa()\r\n{\r\n  var e = document.getElementsByName('indRecv100PctVa');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n");
          out.write("    e[i].checked = false;\r\n  }\r\n  var section = document.getElementById('recv100PctVa');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWasNotEmployed()\r\n{\r\n  var section = document.getElementById('wasNotEmployedSource');\r\n  section.style.display = 'block';\r\n  \r\n  var e = document.getElementsByName('indPeRecvUnemp');\r\n  var v = getRadioButtonGroupValue('indPeRecvUnemp');\r\n\r\n  if ( e != null && v == 'true' )\r\n  {\r\n    showEduTrnRejected();\r\n  }\r\n  else if ( e != null && v == 'false' )\r\n  {\r\n    showEduTrn();\r\n  }\r\n}\r\n\r\nfunction hideWasNotEmployed()\r\n{\r\n  var e = document.getElementsByName('indPeRecvUnemp');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideEduTrn();\r\n  hideEduTrnRejected();\r\n\r\n  var section = document.getElementById('wasNotEmployedSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWasEmployed()\r\n{\r\n  var section = document.getElementById('wasEmployedSource');\r\n  section.style.display = 'block';\r\n\r\n  if ( ( document.");
          out.print( localFormName );
          out.write(".cdPweIrregularUnder100[0] != null &&\r\n         document.");
          out.print( localFormName );
          out.write(".cdPweIrregularUnder100[0].checked == true ) ||\r\n       ( document.");
          out.print( localFormName );
          out.write(".cdPweIrregularUnder100 != null  &&\r\n         document.");
          out.print( localFormName );
          out.write(".cdPweIrregularUnder100.value == 'Y' ) ){\r\n      showWorksUnder100();\r\n  } else if ( ( document.");
          out.print( localFormName );
          out.write(".cdPweIrregularUnder100[1] != null &&\r\n         document.");
          out.print( localFormName );
          out.write(".cdPweIrregularUnder100[1].checked == true ) ||\r\n       ( document.");
          out.print( localFormName );
          out.write(".cdPweIrregularUnder100 != null  &&\r\n         document.");
          out.print( localFormName );
          out.write(".cdPweIrregularUnder100.value == 'N' ) ){\r\n      showWorksOver100();\r\n  }\r\n}\r\n\r\nfunction hideWasEmployed()\r\n{\r\n  var e = document.getElementsByName('indPeRecvUnemp');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideEduTrnRejected();\r\n\r\n  var section = document.getElementById('wasEmployedSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWorksOver100()\r\n{\r\n  var section = document.getElementById('worksOver100Source');\r\n  section.style.display = 'block';\r\n  hideWorksUnder100();\r\n}\r\n\r\nfunction hideWorksOver100()\r\n{\r\n  var e = document.getElementsByName('cdPweSteadyOver100');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n\r\n  var section = document.getElementById('worksOver100Source');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWorksUnder100()\r\n{\r\n  var section = document.getElementById('worksUnder100Source');\r\n  section.style.display = 'block';\r\n  hideWorksOver100();\r\n}\r\n\r\nfunction hideWorksUnder100()\r\n{\r\n  hideEduTrnRejected();\r\n");
          out.write("\r\n  var section = document.getElementById('worksUnder100Source');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showEduTrn()\r\n{\r\n  var section = document.getElementById('eduTrn');\r\n  section.style.display = 'block';\r\n\r\n  var e = document.getElementsByName('indPeWrkEngEduTrn');\r\n  var v = getRadioButtonGroupValue('indPeWrkEngEduTrn');\r\n  \r\n  if ( e != null && v == 'true' )\r\n  {\r\n    showEduTrnRejected();\r\n  }\r\n}\r\n\r\nfunction hideEduTrn()\r\n{\r\n  var e = document.getElementsByName('indPeWrkEngEduTrn');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideEduTrnRejected();\r\n\r\n  var section = document.getElementById('eduTrn');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showEduTrnRejected()\r\n{\r\n  var section = document.getElementById('eduTrnRejected');\r\n  section.style.display = 'block';\r\n}\r\n\r\nfunction hideEduTrnRejected()\r\n{\r\n  var e = document.getElementsByName('indPeNotAcptEmpTrn');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n");
          out.write("\r\n  var section = document.getElementById('eduTrnRejected');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction getRadioButtonGroupValue( rboGroup )\r\n{\r\n  var e = document.getElementsByName(rboGroup);\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    if( e[i].checked == true )\r\n    {\r\n      return e[i].value;\r\n    }\r\n  }\r\n  return null;\r\n}\r\n\r\n</script>\r\n\r\n");

  // SIR 23056 - We have added onClicks to many of the fields so they will call
  // the hide or show functions when appropriate.

          out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n  <tr>\r\n    <td width=\"25\"></td>\r\n    <td>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\" bgcolor=\"");
          out.print( _bgColor );
          out.write("\">\r\n  <tr>\r\n    <td width=\"80%\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is either parent disabled or incapacitated?</td>\r\n    <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setName("indParentDisabled");
          _jspx_th_impact_validateInput_16.setLabel("Yes");
          _jspx_th_impact_validateInput_16.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndParentDisabledString())) );
          _jspx_th_impact_validateInput_16.setValue("true");
          _jspx_th_impact_validateInput_16.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setId("1");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setOnClick("showWasDisabled();hideWasNotDisabled();");
          _jspx_th_impact_validateInput_16.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setName("indParentDisabled");
          _jspx_th_impact_validateInput_17.setLabel("No");
          _jspx_th_impact_validateInput_17.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndParentDisabledString())) );
          _jspx_th_impact_validateInput_17.setValue("false");
          _jspx_th_impact_validateInput_17.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setId("2");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setOnClick("hideWasDisabled();showWasNotDisabled();");
          _jspx_th_impact_validateInput_17.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"3\">\r\n      <div id=\"wasDisabledSource\" style=\"display: none\">\r\n        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n          <tr>\r\n            <td width=\"80%\" colspan=\"3\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;List the months in which deprivation occurred due to disability or incapacity.</td>\r\n            <td width= \"20%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_18.setName("txtMonthsDepDisabled");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setValue( _fceEligibilityDB.getTxtMonthsDepDisabled() );
          _jspx_th_impact_validateInput_18.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_18.setSize("20");
          _jspx_th_impact_validateInput_18.setMaxLength("80");
          _jspx_th_impact_validateInput_18.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n          <tr>\r\n            <td width=\"50%\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Select the appropriate option to specify how you verified it.</td>\r\n            <td width= \"15%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setName("cdVerifMethod");
          _jspx_th_impact_validateInput_19.setLabel("Documentation");
          _jspx_th_impact_validateInput_19.setChecked( Boolean.toString(CodesTables.CVERMETH_D.equals(_fceEligibilityDB.getCdVerifMethod())) );
          _jspx_th_impact_validateInput_19.setValue( CodesTables.CVERMETH_D );
          _jspx_th_impact_validateInput_19.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setOnClick("showVerifDocType();hideMedicalEvidence();");
          _jspx_th_impact_validateInput_19.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td width=\"15%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setName("cdVerifMethod");
          _jspx_th_impact_validateInput_20.setLabel("Observation");
          _jspx_th_impact_validateInput_20.setChecked( Boolean.toString(CodesTables.CVERMETH_O.equals(_fceEligibilityDB.getCdVerifMethod())) );
          _jspx_th_impact_validateInput_20.setValue( CodesTables.CVERMETH_O );
          _jspx_th_impact_validateInput_20.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          _jspx_th_impact_validateInput_20.setOnClick("hideVerifDocType();hideMedicalEvidence();");
          _jspx_th_impact_validateInput_20.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td width=\"20%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setName("cdVerifMethod");
          _jspx_th_impact_validateInput_21.setLabel("Medical Evidence*");
          _jspx_th_impact_validateInput_21.setChecked( Boolean.toString(CodesTables.CVERMETH_M.equals(_fceEligibilityDB.getCdVerifMethod())) );
          _jspx_th_impact_validateInput_21.setValue( CodesTables.CVERMETH_M );
          _jspx_th_impact_validateInput_21.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          _jspx_th_impact_validateInput_21.setOnClick("hideVerifDocType();showMedicalEvidence();");
          _jspx_th_impact_validateInput_21.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n        </table>\r\n\t      <div id=\"medicalEvidence\" style=\"display: none\">\r\n\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t          <tr>\r\n\t            <td colspan=\"4\" align=\"right\"><span style=\"font-style: italic; font-size:xx-small\">* A Doctor's Letter must verify the disability and inability of the parent to work for at least 30 days.</span></td>\r\n\t          </tr>\r\n\t        </table>\r\n\t      </div>\r\n\t      <div id=\"verifDocType\" style=\"display: none\">\r\n\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Select the appropriate documentation type and provide award letter to Eligibility Specialist.</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setName("cdVerifDocType");
          _jspx_th_impact_validateInput_22.setLabel("Railroad Retirement");
          _jspx_th_impact_validateInput_22.setChecked( Boolean.toString(CodesTables.CDOCTYPE_RR.equals(_fceEligibilityDB.getCdVerifDocType())) );
          _jspx_th_impact_validateInput_22.setValue( CodesTables.CDOCTYPE_RR );
          _jspx_th_impact_validateInput_22.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setOnClick("showRecvRrRsdi();hideRecv100PctVa();");
          _jspx_th_impact_validateInput_22.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setName("cdVerifDocType");
          _jspx_th_impact_validateInput_23.setLabel("RSDI");
          _jspx_th_impact_validateInput_23.setChecked( Boolean.toString(CodesTables.CDOCTYPE_RS.equals(_fceEligibilityDB.getCdVerifDocType())) );
          _jspx_th_impact_validateInput_23.setValue( CodesTables.CDOCTYPE_RS );
          _jspx_th_impact_validateInput_23.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setOnClick("showRecvRrRsdi();hideRecv100PctVa();");
          _jspx_th_impact_validateInput_23.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setName("cdVerifDocType");
          _jspx_th_impact_validateInput_24.setLabel("SSI");
          _jspx_th_impact_validateInput_24.setChecked( Boolean.toString(CodesTables.CDOCTYPE_SS.equals(_fceEligibilityDB.getCdVerifDocType())) );
          _jspx_th_impact_validateInput_24.setValue( CodesTables.CDOCTYPE_SS );
          _jspx_th_impact_validateInput_24.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          _jspx_th_impact_validateInput_24.setOnClick("hideRecvRrRsdi();hideRecv100PctVa();");
          _jspx_th_impact_validateInput_24.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setName("cdVerifDocType");
          _jspx_th_impact_validateInput_25.setLabel("Veteran's Disability");
          _jspx_th_impact_validateInput_25.setChecked( Boolean.toString(CodesTables.CDOCTYPE_VA.equals(_fceEligibilityDB.getCdVerifDocType())) );
          _jspx_th_impact_validateInput_25.setValue( CodesTables.CDOCTYPE_VA );
          _jspx_th_impact_validateInput_25.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setOnClick("hideRecvRrRsdi();showRecv100PctVa();");
          _jspx_th_impact_validateInput_25.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setName("cdVerifDocType");
          _jspx_th_impact_validateInput_26.setLabel("Worker Compensation");
          _jspx_th_impact_validateInput_26.setChecked( Boolean.toString(CodesTables.CDOCTYPE_WC.equals(_fceEligibilityDB.getCdVerifDocType())) );
          _jspx_th_impact_validateInput_26.setValue( CodesTables.CDOCTYPE_WC );
          _jspx_th_impact_validateInput_26.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setOnClick("hideRecvRrRsdi();hideRecv100PctVa();");
          _jspx_th_impact_validateInput_26.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>\r\n\t\t\t      <div id=\"recvRrRsdi\" style=\"display: none\">\r\n\t\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t          <tr>\r\n\t\t\t            <td width=\"80%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is the disabled or incapacitated parent receiving RR or RSDI due to a disability?</td>\r\n\t\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setName("indRecvRrRsdi");
          _jspx_th_impact_validateInput_27.setLabel("Yes");
          _jspx_th_impact_validateInput_27.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndRecvRrRsdiString())) );
          _jspx_th_impact_validateInput_27.setValue("true");
          _jspx_th_impact_validateInput_27.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setName("indRecvRrRsdi");
          _jspx_th_impact_validateInput_28.setLabel("No");
          _jspx_th_impact_validateInput_28.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndRecvRrRsdiString())) );
          _jspx_th_impact_validateInput_28.setValue("false");
          _jspx_th_impact_validateInput_28.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t          </tr>\r\n\t\t\t        </table>\r\n\t\t\t      </div>\r\n\t\t\t      <div id=\"recv100PctVa\" style=\"display: none\">\r\n\t\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t          <tr>\r\n\t\t\t            <td width=\"80%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is the disabled or incapacitated parent receiving 100% VA?</td>\r\n\t\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setName("indRecv100PctVa");
          _jspx_th_impact_validateInput_29.setLabel("Yes");
          _jspx_th_impact_validateInput_29.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndRecv100PctVaString())) );
          _jspx_th_impact_validateInput_29.setValue("true");
          _jspx_th_impact_validateInput_29.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          _jspx_th_impact_validateInput_29.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setName("indRecv100PctVa");
          _jspx_th_impact_validateInput_30.setLabel("No");
          _jspx_th_impact_validateInput_30.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndRecv100PctVaString())) );
          _jspx_th_impact_validateInput_30.setValue("false");
          _jspx_th_impact_validateInput_30.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_30.setType("radio");
          _jspx_th_impact_validateInput_30.setCssClass("formInput");
          _jspx_th_impact_validateInput_30.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t          </tr>\r\n\t\t\t        </table>\r\n\t\t\t      </div>\r\n\t            </td>\r\n\t          </tr>\r\n\t        </table>\r\n\t      </div>\r\n      </div>\r\n    ");

      List exOptions = new ArrayList();
        exOptions.add(_fceEligibilityDB.getIdFcePersonString());
    
          out.write("\r\n      <div id=\"wasNotDisabledSource\" style=\"display: none\">\r\n        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n          <tr>\r\n            <td width=\"80%\" colspan=\"2\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Who is the Principal Earner* (PE) in the home of removal?</td>\r\n            <td width=\"20%\" colspan=\"2\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("idPrnEarner");
          _jspx_th_impact_validateSelect_0.setLabel("");
          _jspx_th_impact_validateSelect_0.setValue( _fceEligibilityDB.getIdPrnEarnerString());
          _jspx_th_impact_validateSelect_0.setOptions( FceUtility.getOptionsFromPrinciples(domicileDepDB.getPrinciples()));
          _jspx_th_impact_validateSelect_0.setExcludeOptions(exOptions);
          _jspx_th_impact_validateSelect_0.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"4\" align=\"right\"><span style=\"font-style: italic; font-size:xx-small\">* Principal Earner is defined as the parent who has earned the most income in the last two years.</span></td>\r\n          </tr>\r\n          <tr>\r\n            ");
 //SIR 23056 - We have to display the legacy questions if it's old data.
            if (lockedNA) { 
          out.write("\r\n              <td width=\"70%\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;If the PE has <b>steady</b> employment, does the PE work less than 100 hours per month?</td>\r\n            ");
 } else { 
          out.write("\r\n            ");
// SIR 23304 - Modified wordage in question below. 
          out.write("\r\n              <td width=\"80%\" colspan=\"2\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Has the PE been <b>unemployed</b> for 30 consecutive days prior to the date of removal?</td>\r\n            ");
 } 
          out.write("\r\n            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setName("cdPweSteadyUnder100");
          _jspx_th_impact_validateInput_31.setLabel("Yes");
          _jspx_th_impact_validateInput_31.setChecked( "" + FosterCareReviewConversation.YES.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) );
          _jspx_th_impact_validateInput_31.setValue("Y");
          _jspx_th_impact_validateInput_31.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_31.setType("radio");
          _jspx_th_impact_validateInput_31.setId("1");
          _jspx_th_impact_validateInput_31.setCssClass("formInput");
          _jspx_th_impact_validateInput_31.setOnClick("hideWasEmployed();showWasNotEmployed();");
          _jspx_th_impact_validateInput_31.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setName("cdPweSteadyUnder100");
          _jspx_th_impact_validateInput_32.setLabel("No");
          _jspx_th_impact_validateInput_32.setChecked( "" + FosterCareReviewConversation.NO.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) );
          _jspx_th_impact_validateInput_32.setValue("N");
          _jspx_th_impact_validateInput_32.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_32.setType("radio");
          _jspx_th_impact_validateInput_32.setId("2");
          _jspx_th_impact_validateInput_32.setCssClass("formInput");
          _jspx_th_impact_validateInput_32.setOnClick("hideWasNotEmployed();showWasEmployed();");
          _jspx_th_impact_validateInput_32.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            ");
 //SIR 23056 - We have to display the legacy questions if it's old data.
            if (lockedNA) { 
          out.write("\r\n            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setName("cdPweSteadyUnder100");
          _jspx_th_impact_validateInput_33.setLabel("N/A");
          _jspx_th_impact_validateInput_33.setChecked( "" + FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) );
          _jspx_th_impact_validateInput_33.setValue("A");
          _jspx_th_impact_validateInput_33.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_33.setType("radio");
          _jspx_th_impact_validateInput_33.setId("3");
          _jspx_th_impact_validateInput_33.setCssClass("formInput");
          _jspx_th_impact_validateInput_33.setOnClick("showWasEmployed();hideWasNotEmployed();");
          _jspx_th_impact_validateInput_33.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            ");
 } 
          out.write("\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"4\">\r\n\t\t      <div id=\"wasNotEmployedSource\" style=\"display: none\">\r\n\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t          <tr>\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;List the months in which deprivation occurred due to unemployment.</td>\r\n\t\t            <td width=\"20%\" colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("text");
          _jspx_th_impact_validateInput_34.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_34.setName("txtMonthsDepUnemp");
          _jspx_th_impact_validateInput_34.setCssClass("formInput");
          _jspx_th_impact_validateInput_34.setValue( _fceEligibilityDB.getTxtMonthsDepUnemp() );
          _jspx_th_impact_validateInput_34.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_34.setSize("20");
          _jspx_th_impact_validateInput_34.setMaxLength("80");
          _jspx_th_impact_validateInput_34.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t          </tr>\r\n\t\t          <tr>\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Does the PE now or has the PE within the last 12 months received Unemployment Compensation benefits?</td>\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setName("indPeRecvUnemp");
          _jspx_th_impact_validateInput_35.setLabel("Yes");
          _jspx_th_impact_validateInput_35.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndPeRecvUnempString())) );
          _jspx_th_impact_validateInput_35.setValue("true");
          _jspx_th_impact_validateInput_35.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_35.setType("radio");
          _jspx_th_impact_validateInput_35.setId("1");
          _jspx_th_impact_validateInput_35.setCssClass("formInput");
          _jspx_th_impact_validateInput_35.setOnClick("hideEduTrn();showEduTrnRejected();");
          _jspx_th_impact_validateInput_35.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setName("indPeRecvUnemp");
          _jspx_th_impact_validateInput_36.setLabel("No");
          _jspx_th_impact_validateInput_36.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndPeRecvUnempString())) );
          _jspx_th_impact_validateInput_36.setValue("false");
          _jspx_th_impact_validateInput_36.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_36.setType("radio");
          _jspx_th_impact_validateInput_36.setId("2");
          _jspx_th_impact_validateInput_36.setCssClass("formInput");
          _jspx_th_impact_validateInput_36.setOnClick("showEduTrn();hideEduTrnRejected();");
          _jspx_th_impact_validateInput_36.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t          </tr>\r\n\t\t        </table>\r\n\t\t      </div>\r\n\t\t      <div id=\"eduTrn\" style=\"display: none\">\r\n\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t          <tr>\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Has the PE worked or been engaged in Education training activities within the last 12 months?</td>\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setName("indPeWrkEngEduTrn");
          _jspx_th_impact_validateInput_37.setLabel("Yes");
          _jspx_th_impact_validateInput_37.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndPeWrkEngEduTrnString())) );
          _jspx_th_impact_validateInput_37.setValue("true");
          _jspx_th_impact_validateInput_37.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_37.setType("radio");
          _jspx_th_impact_validateInput_37.setId("1");
          _jspx_th_impact_validateInput_37.setCssClass("formInput");
          _jspx_th_impact_validateInput_37.setOnClick("showEduTrnRejected();");
          _jspx_th_impact_validateInput_37.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setName("indPeWrkEngEduTrn");
          _jspx_th_impact_validateInput_38.setLabel("No");
          _jspx_th_impact_validateInput_38.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndPeWrkEngEduTrnString())) );
          _jspx_th_impact_validateInput_38.setValue("false");
          _jspx_th_impact_validateInput_38.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_38.setType("radio");
          _jspx_th_impact_validateInput_38.setId("2");
          _jspx_th_impact_validateInput_38.setCssClass("formInput");
          _jspx_th_impact_validateInput_38.setOnClick("hideEduTrnRejected();");
          _jspx_th_impact_validateInput_38.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t          </tr>\r\n\t\t        </table>\r\n\t\t      </div>\r\n\t\t      <div id=\"eduTrnRejected\" style=\"display: none\">\r\n\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t          <tr>\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Has the PE failed to accept an offer of employment or training for employment within 30 consecutive days prior to removal?</td>\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setName("indPeNotAcptEmpTrn");
          _jspx_th_impact_validateInput_39.setLabel("Yes");
          _jspx_th_impact_validateInput_39.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndPeNotAcptEmpTrnString())) );
          _jspx_th_impact_validateInput_39.setValue("true");
          _jspx_th_impact_validateInput_39.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_39.setType("radio");
          _jspx_th_impact_validateInput_39.setId("1");
          _jspx_th_impact_validateInput_39.setCssClass("formInput");
          _jspx_th_impact_validateInput_39.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_40.setName("indPeNotAcptEmpTrn");
          _jspx_th_impact_validateInput_40.setLabel("No");
          _jspx_th_impact_validateInput_40.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndPeNotAcptEmpTrnString())) );
          _jspx_th_impact_validateInput_40.setValue("false");
          _jspx_th_impact_validateInput_40.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_40.setType("radio");
          _jspx_th_impact_validateInput_40.setId("2");
          _jspx_th_impact_validateInput_40.setCssClass("formInput");
          _jspx_th_impact_validateInput_40.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t          </tr>\r\n\t\t        </table>\r\n\t\t      </div>\r\n\t\t      <div id=\"wasEmployedSource\" style=\"display: none\">\r\n\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t          <tr>\r\n\t\t          ");
 //SIR 23056 - We have to display the legacy questions if it's old data.
		          if (lockedNA) { 
          out.write("\r\n\t\t            <td width=\"70%\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;If the PE works <b>irregularly</b>, does the PE work less than 100 hours per month on average?</td>\r\n\t\t          ");
 } else { 
          out.write("\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Has the PE worked less than 100 hours (underemployed) in 30 consecutive days prior to the date of removal and continues to work <b>less</b> than 100 hours?</td>\r\n\t\t          ");
 } 
          out.write("\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setName("cdPweIrregularUnder100");
          _jspx_th_impact_validateInput_41.setLabel("Yes");
          _jspx_th_impact_validateInput_41.setChecked( "" + FosterCareReviewConversation.YES.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) );
          _jspx_th_impact_validateInput_41.setValue("Y");
          _jspx_th_impact_validateInput_41.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_41.setType("radio");
          _jspx_th_impact_validateInput_41.setId("1");
          _jspx_th_impact_validateInput_41.setCssClass("formInput");
          _jspx_th_impact_validateInput_41.setOnClick("showWorksUnder100();");
          _jspx_th_impact_validateInput_41.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setName("cdPweIrregularUnder100");
          _jspx_th_impact_validateInput_42.setLabel("No");
          _jspx_th_impact_validateInput_42.setChecked( "" + FosterCareReviewConversation.NO.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) );
          _jspx_th_impact_validateInput_42.setValue("N");
          _jspx_th_impact_validateInput_42.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_42.setType("radio");
          _jspx_th_impact_validateInput_42.setId("2");
          _jspx_th_impact_validateInput_42.setCssClass("formInput");
          _jspx_th_impact_validateInput_42.setOnClick("hideWorksUnder100();");
          _jspx_th_impact_validateInput_42.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t            ");
 //SIR 23056 - We have to display the legacy questions if it's old data.
		            if (lockedNA) { 
          out.write("\r\n\t\t            <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setName("cdPweIrregularUnder100");
          _jspx_th_impact_validateInput_43.setLabel("N/A");
          _jspx_th_impact_validateInput_43.setChecked( "" + FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) );
          _jspx_th_impact_validateInput_43.setValue("A");
          _jspx_th_impact_validateInput_43.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_43.setType("radio");
          _jspx_th_impact_validateInput_43.setId("3");
          _jspx_th_impact_validateInput_43.setCssClass("formInput");
          _jspx_th_impact_validateInput_43.setOnClick("showWorksOver100();");
          _jspx_th_impact_validateInput_43.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t            ");
 } 
          out.write("\r\n\t\t          </tr>\r\n\t\t          <tr>\r\n\t\t\t        <td colspan=\"4\">\r\n\t\t\t          <div id=\"worksUnder100Source\" style=\"display: none\">\r\n\t\t\t            <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t              <tr>\r\n\t\t\t                <td width=\"80%\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;List the months in which deprivation occurred due to underemployment.</td>\r\n\t\t\t                <td width= \"20%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setType("text");
          _jspx_th_impact_validateInput_44.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_44.setName("txtMonthsDepUnderEmpl");
          _jspx_th_impact_validateInput_44.setCssClass("formInput");
          _jspx_th_impact_validateInput_44.setValue( _fceEligibilityDB.getTxtMonthsDepUnderEmpl() );
          _jspx_th_impact_validateInput_44.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_44.setSize("20");
          _jspx_th_impact_validateInput_44.setMaxLength("80");
          _jspx_th_impact_validateInput_44.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
          if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t              </tr>\r\n\t\t\t            </table>\r\n\t\t\t          </div>\r\n\t\t\t        </td>\r\n\t\t\t      </tr>\r\n\t\t        </table>\r\n\t\t      </div>\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </div>\r\n    </td>\r\n  </tr>\r\n");
 //SIR 23056 - We have to display the legacy questions if it's old data.
if (lockedNA) { 
          out.write("\r\n  <tr>\r\n    <td colspan=\"3\">\r\n      <div id=\"worksOver100Source\" style=\"display: none\">\r\n        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n          <tr>\r\n            <td width=\"70%\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;What is his/her gross monthly earned income?</td>\r\n            <td width=\"30%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_45.setName("amtPweIncomeMoney");
          _jspx_th_impact_validateInput_45.setValue( amtPweIncomeString );
          _jspx_th_impact_validateInput_45.setDisabled( _disableDeprivation );
          _jspx_th_impact_validateInput_45.setType("text");
          _jspx_th_impact_validateInput_45.setCssClass("formInput");
          _jspx_th_impact_validateInput_45.setSize("13");
          _jspx_th_impact_validateInput_45.setConstraint("Money11");
          _jspx_th_impact_validateInput_45.setMaxLength("13");
          _jspx_th_impact_validateInput_45.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
          if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n        </table>\r\n      </div>\r\n    </td>\r\n  </tr>\r\n");
 } 
          out.write("\r\n</table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 //  Sir 23056 - Since the form fields are now generated and the browser has
   // populated them we can now call the appropriate Show fuction

          out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nif ( ( document.");
          out.print( localFormName );
          out.write(".indParentDisabled != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indParentDisabled[0] != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indParentDisabled[0].checked == true ) ||\r\n     ( document.");
          out.print( localFormName );
          out.write(".indParentDisabled != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indParentDisabled.value == 'true') )\r\n{\r\n  showWasDisabled();\r\n}\r\n\r\nif ( ( document.");
          out.print( localFormName );
          out.write(".indParentDisabled != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indParentDisabled[1] != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indParentDisabled[1].checked == true ) ||\r\n     ( document.");
          out.print( localFormName );
          out.write(".indParentDisabled != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indParentDisabled.value == 'false') )\r\n{\r\n  showWasNotDisabled();\r\n}\r\n</script>\r\n");

 request.setAttribute("tabIndex", _tabIndex);
}

          out.write('\r');
          out.write('\n');
          out.write("\r\n\t\t");

		  tabIndex = (Integer) request.getAttribute("tabIndex");
		
          out.write("\r\n\t</div>\r\n\r\n\r\n\t<div id=\"one\" style=\"display: none\">\r\n\t\t");

		  request.setAttribute("tabIndex", tabIndex);
		    request.setAttribute("disableDeprivation", false);
		    request.setAttribute("fceEligibilityDB", domicileDB.getFceEligibility());
		
          out.write("\r\n\t\t");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  04/01/05  Todd Reser        SIR 23310 - Added _showWorkRelated, Javascript
                              functions, onClick commands, div sections and
                              re-worded questions.
  04/25/05  wadesa        SIR 23141 - Fixed the radio button for which parent
                              the child was living with.  This was resolved by
                              switching the getter methods for the indAbsentMother
                              field(radioButton).
  11/16/10  Hai Nguyen        SMS#81144: MR-053 Updated labels.
  11/30/10  Hai Nguyen        SMS#81144: Corrected some page display issue with js.
*/

{
  String _bgColor = "#F0FFFF";
  // SIR 23310 - We need to see which page is calling this sub so we use the
  // right form name
  String localFormName = "";
  if ("DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION".equals(request.getAttribute("level3Tab")))
  {
    localFormName = "frmDomicile";
  }
  if ("FC_REVIEW_APPLICATION_FOSTERCAREDETAIL".equals(request.getAttribute("level3Tab")) ||
      "FC_REVIEW_APPLICATION_FOSTERCAREREVIEW".equals(request.getAttribute("level3Tab")) )
  {
    localFormName = "frmReview";
  }

  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  boolean _disableDeprivation = (Boolean) request.getAttribute("disableDeprivation");
  FceEligibilityDB _fceEligibilityDB = (FceEligibilityDB) request.getAttribute("fceEligibilityDB");
  // SIR 23310 Added _showWorkRelated so we can show the option if it's checked
  // compensating for legacy data.
  boolean _showWorkRelated = _fceEligibilityDB.getIndAbsentWorkRelated();

  //SIR 23310 - Added four Javascript Functions

          out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction showAbsentReasons()\r\n{\r\n  var section = document.getElementById('wasAbsentSource');\r\n  section.style.display = 'block';\r\n}\r\n\r\nfunction showNotAbsent()\r\n{\r\n  var section = document.getElementById('wasNotAbsentSource');\r\n  section.style.display = 'block';\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentDied != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentDied.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentDeported != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentDeported.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentDeserted != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentDeserted.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentDivorced != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentDivorced.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentHospitalized != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentHospitalized.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentIncarcerated != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentIncarcerated.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentNeverCohabitated != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentNeverCohabitated.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentAltrntCustody != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentAltrntCustody.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentSeparated != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentSeparated.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentWorkRelated != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentWorkRelated.checked = false;\r\n  }\r\n  if (document.");
          out.print( localFormName );
          out.write(".indAbsentTprVolRelinq != null)\r\n  {\r\n    document.");
          out.print( localFormName );
          out.write(".indAbsentTprVolRelinq.checked = false;\r\n  }\r\n}\r\n\r\nfunction hideAbsentReasons()\r\n{\r\n  var section = document.getElementById('wasAbsentSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction hideNotAbsent()\r\n{\r\n  var section = document.getElementById('wasNotAbsentSource');\r\n  wasNotAbsentSource.style.display = 'none';\r\n}\r\n</script>\r\n\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n  <tr>\r\n    <td width=\"25\"></td>\r\n    <td>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\" bgcolor=\"");
          out.print( _bgColor );
          out.write("\">\r\n  <tr>");
          out.write("\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Which Parent?</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_46.setName("indAbsentMother");
          _jspx_th_impact_validateInput_46.setLabel("Mother");
          _jspx_th_impact_validateInput_46.setChecked( _fceEligibilityDB.getIndAbsentFatherString() );
          _jspx_th_impact_validateInput_46.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_46.setValue("true");
          _jspx_th_impact_validateInput_46.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_46.setType("radio");
          _jspx_th_impact_validateInput_46.setId("1");
          _jspx_th_impact_validateInput_46.setCssClass("formInput");
          _jspx_th_impact_validateInput_46.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
          if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_47.setName("indAbsentMother");
          _jspx_th_impact_validateInput_47.setLabel("Father");
          _jspx_th_impact_validateInput_47.setChecked( _fceEligibilityDB.getIndAbsentMotherString() );
          _jspx_th_impact_validateInput_47.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_47.setValue("false");
          _jspx_th_impact_validateInput_47.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_47.setType("radio");
          _jspx_th_impact_validateInput_47.setId("2");
          _jspx_th_impact_validateInput_47.setCssClass("formInput");
          _jspx_th_impact_validateInput_47.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
          if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n");
 //SIR 23310 Reworded absence question 
          out.write("\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is the other\r\n          parent's absence because of employment outside the community or active\r\n          military duty?</td>\r\n");
 // SIR 23310 - Added onclick command 
          out.write("\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_48.setName("indAbsentMilitaryWork");
          _jspx_th_impact_validateInput_48.setLabel("Yes");
          _jspx_th_impact_validateInput_48.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentMilitaryWorkString())) );
          _jspx_th_impact_validateInput_48.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_48.setValue("true");
          _jspx_th_impact_validateInput_48.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_48.setType("radio");
          _jspx_th_impact_validateInput_48.setId("1");
          _jspx_th_impact_validateInput_48.setCssClass("formInput");
          _jspx_th_impact_validateInput_48.setOnClick("hideAbsentReasons();showNotAbsent();");
          _jspx_th_impact_validateInput_48.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
          if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n");
 // SIR 23310 - Added onclick command 
          out.write("\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_49.setName("indAbsentMilitaryWork");
          _jspx_th_impact_validateInput_49.setLabel("No");
          _jspx_th_impact_validateInput_49.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndAbsentMilitaryWorkString())) );
          _jspx_th_impact_validateInput_49.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_49.setValue("false");
          _jspx_th_impact_validateInput_49.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_49.setType("radio");
          _jspx_th_impact_validateInput_49.setId("2");
          _jspx_th_impact_validateInput_49.setCssClass("formInput");
          _jspx_th_impact_validateInput_49.setOnClick("showAbsentReasons();hideNotAbsent();");
          _jspx_th_impact_validateInput_49.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
          if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"3\">\r\n");
 // SIR 23310 - Added div sections wasNotAbsentSource and wasAbsentSource 
          out.write("\r\n    <div id=\"wasNotAbsentSource\" style=\"display: none\">\r\n    <B>In this situation, complete the section for Living with Both Parents by\r\n    selecting the above radio button.</B>\r\n    </div>\r\n    <div id=\"wasAbsentSource\" style=\"display: none\">\r\n    <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" bgcolor=\"");
          out.print( _bgColor );
          out.write("\">\r\n      <tr>\r\n        <td colspan=\"3\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;What is the reason for the parent's continued absence from the home?</td>\r\n      </tr>\r\n      <tr>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_50.setName("indAbsentDied");
          _jspx_th_impact_validateInput_50.setLabel("Death");
          _jspx_th_impact_validateInput_50.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDiedString())) );
          _jspx_th_impact_validateInput_50.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_50.setValue("true");
          _jspx_th_impact_validateInput_50.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_50.setType("checkbox");
          _jspx_th_impact_validateInput_50.setCssClass("formInput");
          _jspx_th_impact_validateInput_50.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
          if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_51.setName("indAbsentDeported");
          _jspx_th_impact_validateInput_51.setLabel("Deportation");
          _jspx_th_impact_validateInput_51.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDeportedString())) );
          _jspx_th_impact_validateInput_51.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_51.setValue("true");
          _jspx_th_impact_validateInput_51.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_51.setType("checkbox");
          _jspx_th_impact_validateInput_51.setCssClass("formInput");
          _jspx_th_impact_validateInput_51.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
          if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_52.setName("indAbsentDeserted");
          _jspx_th_impact_validateInput_52.setLabel("Desertion");
          _jspx_th_impact_validateInput_52.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDesertedString())) );
          _jspx_th_impact_validateInput_52.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_52.setValue("true");
          _jspx_th_impact_validateInput_52.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_52.setType("checkbox");
          _jspx_th_impact_validateInput_52.setCssClass("formInput");
          _jspx_th_impact_validateInput_52.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
          if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n");
 //SIR 23310 Reworded absence question 
          out.write("\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_53.setName("indAbsentDivorced");
          _jspx_th_impact_validateInput_53.setLabel("Divorce");
          _jspx_th_impact_validateInput_53.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDivorcedString())) );
          _jspx_th_impact_validateInput_53.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_53.setValue("true");
          _jspx_th_impact_validateInput_53.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_53.setType("checkbox");
          _jspx_th_impact_validateInput_53.setCssClass("formInput");
          _jspx_th_impact_validateInput_53.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
          if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n");
 //SIR 23310 Reworded absence question 
          out.write("\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_54.setName("indAbsentHospitalized");
          _jspx_th_impact_validateInput_54.setLabel("Hospitalized");
          _jspx_th_impact_validateInput_54.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentHospitalizedString())) );
          _jspx_th_impact_validateInput_54.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_54.setValue("true");
          _jspx_th_impact_validateInput_54.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_54.setType("checkbox");
          _jspx_th_impact_validateInput_54.setCssClass("formInput");
          _jspx_th_impact_validateInput_54.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
          if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n");
 //SIR 23310 Reworded absence question 
          out.write("\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_55.setName("indAbsentIncarcerated");
          _jspx_th_impact_validateInput_55.setLabel("Incarcerated");
          _jspx_th_impact_validateInput_55.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentIncarceratedString())) );
          _jspx_th_impact_validateInput_55.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_55.setValue("true");
          _jspx_th_impact_validateInput_55.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_55.setType("checkbox");
          _jspx_th_impact_validateInput_55.setCssClass("formInput");
          _jspx_th_impact_validateInput_55.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
          if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_56.setName("indAbsentNeverCohabitated");
          _jspx_th_impact_validateInput_56.setLabel("Never lived in the home");
          _jspx_th_impact_validateInput_56.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentNeverCohabitatedString())) );
          _jspx_th_impact_validateInput_56.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_56.setValue("true");
          _jspx_th_impact_validateInput_56.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_56.setType("checkbox");
          _jspx_th_impact_validateInput_56.setCssClass("formInput");
          _jspx_th_impact_validateInput_56.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
          if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_57.setName("indAbsentSeparated");
          _jspx_th_impact_validateInput_57.setLabel("Separated");
          _jspx_th_impact_validateInput_57.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentSeparatedString())) );
          _jspx_th_impact_validateInput_57.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_57.setValue("true");
          _jspx_th_impact_validateInput_57.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_57.setType("checkbox");
          _jspx_th_impact_validateInput_57.setCssClass("formInput");
          _jspx_th_impact_validateInput_57.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
          if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_58.setName("indAbsentTprVolRelinq");
          _jspx_th_impact_validateInput_58.setLabel("TPR/Voluntary Relinquishment");
          _jspx_th_impact_validateInput_58.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentTprVolRelinqString())) );
          _jspx_th_impact_validateInput_58.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_58.setValue("true");
          _jspx_th_impact_validateInput_58.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_58.setType("checkbox");
          _jspx_th_impact_validateInput_58.setCssClass("formInput");
          _jspx_th_impact_validateInput_58.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
          if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n");
 if (_showWorkRelated) { 
          out.write("\r\n      <tr>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_59.setName("indAbsentWorkRelated");
          _jspx_th_impact_validateInput_59.setLabel("Work Related");
          _jspx_th_impact_validateInput_59.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentWorkRelatedString())) );
          _jspx_th_impact_validateInput_59.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_59.setValue("true");
          _jspx_th_impact_validateInput_59.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_59.setType("checkbox");
          _jspx_th_impact_validateInput_59.setCssClass("formInput");
          _jspx_th_impact_validateInput_59.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
          if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_60.setName("indAbsentAltrntCustody");
          _jspx_th_impact_validateInput_60.setLabel("Separated with alternative custody");
          _jspx_th_impact_validateInput_60.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentAltrntCustodyString())) );
          _jspx_th_impact_validateInput_60.setNoCheckboxChange(true);
          _jspx_th_impact_validateInput_60.setValue("true");
          _jspx_th_impact_validateInput_60.setDisabled( "" + _disableDeprivation );
          _jspx_th_impact_validateInput_60.setType("checkbox");
          _jspx_th_impact_validateInput_60.setCssClass("formInput");
          _jspx_th_impact_validateInput_60.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
          if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        <td>&nbsp;</td>\r\n      </tr>\r\n");
 } 
          out.write("\r\n        </table>\r\n        </div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 //  Sir 23310 - Since the form fields are now generated and the browser has
   // populated them we can now call the appropriate Show fuction

          out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nif ( ( document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork[0] != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork[0].checked == true ) ||\r\n     ( document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork.value == 'true') )\r\n{\r\n  showNotAbsent();\r\n}\r\n\r\nif ( ( document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork[1] != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork[1].checked == true ) ||\r\n     ( document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork != null &&\r\n       document.");
          out.print( localFormName );
          out.write(".indAbsentMilitaryWork.value == 'false') )\r\n{\r\n  showAbsentReasons();\r\n}\r\n</script>\r\n");

 request.setAttribute("tabIndex", _tabIndex);
}

          out.write('\r');
          out.write('\n');
          out.write("\r\n\t\t");

		  tabIndex = (Integer) request.getAttribute("tabIndex");
		
          out.write("\r\n\t</div>\r\n\r\n\r\n\t");

	  List<String> exOptions = new ArrayList<String>();
	    exOptions.add(domicileDB.getIdFcePersonString());
	
          out.write("\r\n\t<div id=\"other\" style=\"display: none\">\r\n\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"25\"></td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\"\r\n\t\t\t\t\t\tclass=\"tableBorder\" bgcolor=\"");
          out.print(bgColor);
          out.write("\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td width=\"80%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("idOtherRelativePerson");
          _jspx_th_impact_validateSelect_1.setLabel("Name of Relative");
          _jspx_th_impact_validateSelect_1.setValue( domicileDB.getIdOtherRelativePersonString());
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setOptions(FceUtility.getOptionsFromPrinciples(domicileDB.getPrinciples()));
          _jspx_th_impact_validateSelect_1.setExcludeOptions(exOptions);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setColspan("2");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t\t\t</tr>\r\n                        <tr>\r\n                          <td width=\"80%\"><span class=\"formCondRequiredText\">&#135;</span>Does the relative meet criteria as a <span ><a href=\"javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')\">specified relative</a></span>?</td>\r\n                          <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_61.setName("indSpecifiedRelative");
          _jspx_th_impact_validateInput_61.setLabel("Yes");
          _jspx_th_impact_validateInput_61.setChecked( Boolean.toString("true".equals(domicileDB.getIndSpecifiedRelativeString())) );
          _jspx_th_impact_validateInput_61.setValue("true");
          _jspx_th_impact_validateInput_61.setType("radio");
          _jspx_th_impact_validateInput_61.setId("1");
          _jspx_th_impact_validateInput_61.setCssClass("formInput");
          _jspx_th_impact_validateInput_61.setOnClick("hideNotSpecifiedRelative();");
          _jspx_th_impact_validateInput_61.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
          if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                          <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_62.setName("indSpecifiedRelative");
          _jspx_th_impact_validateInput_62.setLabel("No");
          _jspx_th_impact_validateInput_62.setChecked( Boolean.toString("false".equals(domicileDB.getIndSpecifiedRelativeString())) );
          _jspx_th_impact_validateInput_62.setValue("false");
          _jspx_th_impact_validateInput_62.setType("radio");
          _jspx_th_impact_validateInput_62.setId("2");
          _jspx_th_impact_validateInput_62.setCssClass("formInput");
          _jspx_th_impact_validateInput_62.setOnClick("showNotSpecifiedRelative();");
          _jspx_th_impact_validateInput_62.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
          if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td>\r\n\t\t\t\t\t\t\t    <div id=\"notSpecifiedRelative\" style=\"display: none\">\r\n\t\t\t\t\t\t\t        <table width=\"100%\">\r\n\t\t\t\t\t\t\t            <tr>\r\n\t\t\t\t\t\t\t                <td>\r\n\t\t\t\t\t\t\t                    <b>In this situation, complete the section for None of the\r\n\t\t\t\t\t\t\t                        Above by selecting the radio button below.</b>\r\n\t\t\t\t\t\t\t                </td>\r\n\t\t\t\t\t\t\t            </tr>\r\n\t\t\t\t\t\t\t        </table>\r\n\t\t\t\t\t\t\t    </div>\r\n                            </td>\r\n                        </tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\r\n\r\n\t<div id=\"6MnthOther\" style=\"display: none\">\r\n\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"25\"></td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\"\r\n\t\t\t\t\t\tclass=\"tableBorder\" bgcolor=\"");
          out.print(bgColor);
          out.write("\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td width=\"80%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("idMngngCvsPerson");
          _jspx_th_impact_validateSelect_2.setLabel("Name of Relative");
          _jspx_th_impact_validateSelect_2.setValue(domicileDB.getIdMngngCvsPersonString());
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setOptions(FceUtility.getOptionsFromPrinciples(domicileDB.getPrinciples()));
          _jspx_th_impact_validateSelect_2.setExcludeOptions(exOptions);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setColspan("2");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t  <td width=\"80%\"><span class=\"formCondRequiredText\">&#135;</span>Does the relative meet criteria as a <span ><a href=\"javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')\">specified relative</a></span>?</td>\r\n\t\t\t\t\t\t  <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_63.setName("indSpecifiedRelative");
          _jspx_th_impact_validateInput_63.setLabel("Yes");
          _jspx_th_impact_validateInput_63.setChecked( Boolean.toString("true".equals(domicileDB.getIndSpecifiedRelativeString()) && CodesTables.CFCELIV_N.equals(domicileDB.getCdLivingMonthRemoval()) ) );
          _jspx_th_impact_validateInput_63.setValue("true");
          _jspx_th_impact_validateInput_63.setType("radio");
          _jspx_th_impact_validateInput_63.setId("3");
          _jspx_th_impact_validateInput_63.setCssClass("formInput");
          _jspx_th_impact_validateInput_63.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
          if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                          <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_64 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_64.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_64.setName("indSpecifiedRelative");
          _jspx_th_impact_validateInput_64.setLabel("No");
          _jspx_th_impact_validateInput_64.setChecked( Boolean.toString("false".equals(domicileDB.getIndSpecifiedRelativeString()) && CodesTables.CFCELIV_N.equals(domicileDB.getCdLivingMonthRemoval()) ) );
          _jspx_th_impact_validateInput_64.setValue("false");
          _jspx_th_impact_validateInput_64.setType("radio");
          _jspx_th_impact_validateInput_64.setId("4");
          _jspx_th_impact_validateInput_64.setCssClass("formInput");
          _jspx_th_impact_validateInput_64.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_64 = _jspx_th_impact_validateInput_64.doStartTag();
          if (_jspx_th_impact_validateInput_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\r\n\t<div id=\"none\" style=\"display: none\">\r\n\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"25\"></td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\"\r\n\t\t\t\t\t\tclass=\"tableBorder\" bgcolor=\"");
          out.print(bgColor);
          out.write("\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td width=\"80%\">\r\n\t\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>&nbsp;At any\r\n\t\t\t\t\t\t\t\ttime during the six months before removal, did the child live\r\n\t\t\t\t\t\t\t\twith a parent or <span ><a href=\"javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')\">specified relative</a></span>?\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td width=\"10%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_65 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_65.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_65.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_65.setName("indChildLivingPrnt6Mnths");
          _jspx_th_impact_validateInput_65.setLabel("Yes");
          _jspx_th_impact_validateInput_65.setChecked( Boolean.toString("true".equals(domicileDB.getIndChildLivingPrnt6MnthsString())) );
          _jspx_th_impact_validateInput_65.setValue("true");
          _jspx_th_impact_validateInput_65.setType("radio");
          _jspx_th_impact_validateInput_65.setId("1");
          _jspx_th_impact_validateInput_65.setOnClick("setNoneOfTheAbove('yes')");
          _jspx_th_impact_validateInput_65.setCssClass("formInput");
          _jspx_th_impact_validateInput_65.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_65 = _jspx_th_impact_validateInput_65.doStartTag();
          if (_jspx_th_impact_validateInput_65.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td width=\"10%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_66 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_66.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_66.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_66.setName("indChildLivingPrnt6Mnths");
          _jspx_th_impact_validateInput_66.setLabel("No");
          _jspx_th_impact_validateInput_66.setChecked( Boolean.toString("false".equals(domicileDB.getIndChildLivingPrnt6MnthsString())));
          _jspx_th_impact_validateInput_66.setValue("false");
          _jspx_th_impact_validateInput_66.setType("radio");
          _jspx_th_impact_validateInput_66.setId("2");
          _jspx_th_impact_validateInput_66.setOnClick("setNoneOfTheAbove('no')");
          _jspx_th_impact_validateInput_66.setCssClass("formInput");
          _jspx_th_impact_validateInput_66.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_66 = _jspx_th_impact_validateInput_66.doStartTag();
          if (_jspx_th_impact_validateInput_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td id=\"6MnthEmpty\" colspan=\"3\"></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\r\n\r\n\t<div id=\"6Mnth\" style=\"display: none\">\r\n\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\"\r\n\t\t\tclass=\"tableBorder\" bgcolor=\"#FFFFFF\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"70%\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>&nbsp;List the\r\n\t\t\t\t\tmonths the child was living with a parent or <span ><a href=\"javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')\">specified relative</a></span>.\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"30%\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_67 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_67.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_67.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_67.setType("text");
          _jspx_th_impact_validateInput_67.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_67.setName("txtMonthsLivingRelCust");
          _jspx_th_impact_validateInput_67.setCssClass("formInput");
          _jspx_th_impact_validateInput_67.setValue(domicileDB.getTxtMonthsLivingRelCust());
          _jspx_th_impact_validateInput_67.setSize("40");
          _jspx_th_impact_validateInput_67.setMaxLength("80");
          _jspx_th_impact_validateInput_67.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_67 = _jspx_th_impact_validateInput_67.doStartTag();
          if (_jspx_th_impact_validateInput_67.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Select the\r\n\t\t\t\t\tmost recent situation that applies:\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_68 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_68.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_68.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_68.setName("cdNotaMostRecent");
          _jspx_th_impact_validateInput_68.setLabel("Living with Both Parents");
          _jspx_th_impact_validateInput_68.setChecked("" + (DomicileDeprivationConversation.LIV_ARR_BOTH.equals(domicileDB.getCdNotaMostRecent())));
          _jspx_th_impact_validateInput_68.setValue("B");
          _jspx_th_impact_validateInput_68.setType("radio");
          _jspx_th_impact_validateInput_68.setId("1");
          _jspx_th_impact_validateInput_68.setOnClick("set6MnthSubsection('both', '6MnthBothEmpty')");
          _jspx_th_impact_validateInput_68.setCssClass("formInput");
          _jspx_th_impact_validateInput_68.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_68 = _jspx_th_impact_validateInput_68.doStartTag();
          if (_jspx_th_impact_validateInput_68.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td id=\"6MnthBothEmpty\" colspan=\"2\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_69 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_69.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_69.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_69.setName("cdNotaMostRecent");
          _jspx_th_impact_validateInput_69.setLabel("Living With One Legal or Biological Parent");
          _jspx_th_impact_validateInput_69.setChecked("" + (DomicileDeprivationConversation.LIV_ARR_ONE.equals(domicileDB.getCdNotaMostRecent())));
          _jspx_th_impact_validateInput_69.setValue("O");
          _jspx_th_impact_validateInput_69.setType("radio");
          _jspx_th_impact_validateInput_69.setId("2");
          _jspx_th_impact_validateInput_69.setOnClick("set6MnthSubsection('one', '6MnthOneEmpty')");
          _jspx_th_impact_validateInput_69.setCssClass("formInput");
          _jspx_th_impact_validateInput_69.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_69 = _jspx_th_impact_validateInput_69.doStartTag();
          if (_jspx_th_impact_validateInput_69.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td id=\"6MnthOneEmpty\" colspan=\"2\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_70 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_70.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_70.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_70.setName("cdNotaMostRecent");
          _jspx_th_impact_validateInput_70.setLabel("");
          _jspx_th_impact_validateInput_70.setChecked("" + (DomicileDeprivationConversation.LIV_ARR_OTHER.equals(domicileDB.getCdNotaMostRecent())));
          _jspx_th_impact_validateInput_70.setValue("R");
          _jspx_th_impact_validateInput_70.setType("radio");
          _jspx_th_impact_validateInput_70.setId("3");
          _jspx_th_impact_validateInput_70.setOnClick("set6MnthSubsection('6MnthOther', '6MnthOtherEmpty')");
          _jspx_th_impact_validateInput_70.setCssClass("formInput");
          _jspx_th_impact_validateInput_70.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_70 = _jspx_th_impact_validateInput_70.doStartTag();
          if (_jspx_th_impact_validateInput_70.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\tLiving With <span ><a href=\"javascript:void window.open ('/document/DocumentConversation/displaySpecifiedRelativeHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')\">Specified Relative</a></span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td id=\"6MnthOtherEmpty\" colspan=\"2\"></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\t<br>\r\n        ");

          boolean bSave = ((EventHelper.NEW_EVENT.equals(domicileDB.getCdEventStatus())
                                    || EventHelper.PROCESS_EVENT.equals(domicileDB.getCdEventStatus()))
                                    && CaseUtility.hasStageAccess(user.getUserID(), (int) domicileDB.getIdStage()))
                          || ((EventHelper.PENDING_EVENT.equals(domicileDB.getCdEventStatus())
                                    || EventHelper.COMPLETE_EVENT.equals(domicileDB.getCdEventStatus()))
                              && FceUtility.isEligibilitySpecialist(request));

          boolean bContinue = (EventHelper.PENDING_EVENT.equals(domicileDB.getCdEventStatus())
                                    || EventHelper.COMPLETE_EVENT.equals(domicileDB.getCdEventStatus()))
                              && FceUtility.isEligibilitySpecialist(request);
        
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm(formName);
          _jspx_th_impact_ButtonTag_0.setAction("/fce/DomicileDeprivation/saveDomicile");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setDisabled(String.valueOf(!bSave));
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnContinue");
          _jspx_th_impact_ButtonTag_1.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_1.setForm(formName);
          _jspx_th_impact_ButtonTag_1.setAction("/fce/DomicileDeprivation/saveDomicile");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setDisabled(String.valueOf(!bContinue));
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
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
