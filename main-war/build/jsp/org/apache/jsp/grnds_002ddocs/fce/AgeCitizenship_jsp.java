package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.AgeCitizenshipDB;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;

public final class AgeCitizenship_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/fce/CitizenshipSub.jsp");
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


//*  JSP Name:     Age And Citizenship
//*  Created by:   Michael Ochu
//*  Date Created: 10/05/2002
//*
//*  Description:
//*  This JSP is used to verify age and citizenship information
//*  of a given child.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  6/17/08   charden			  STGAP00008647: wrote if statement to check if ageCitizenshipDB is null and
//**							  if it is null, to create a new ageCitizenshipDB object


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  boolean evalConcApprvdCheckButtonHide = false;
  String evalConcApprvdDisabled = "false";

  int tabIndex = 1;

  UserProfile user = UserProfileHelper.getUserProfile(request);

  String pageMode = PageMode.getPageMode(request);
	
  AgeCitizenshipDB ageCitizenshipDB = (AgeCitizenshipDB)
    request.getAttribute("AgeCitizenship");
    
  //STGAP00008647 creates new ageCitizenshipDB object if it is null to guard against JSP Error
  if (ageCitizenshipDB == null){
     ageCitizenshipDB = new AgeCitizenshipDB();
    }

  PersonCitizenshipIdentitylRetrieveSO personCitizenshipIdentitylRetrieveSO = (PersonCitizenshipIdentitylRetrieveSO) request.getAttribute("personCitizenshipIdentitylRetrieveSO");
  if (personCitizenshipIdentitylRetrieveSO == null)
   {
     personCitizenshipIdentitylRetrieveSO = new PersonCitizenshipIdentitylRetrieveSO();
   } 
   
  PersonCitizenshipIdentityList personCitizenshipIdentityBean = personCitizenshipIdentitylRetrieveSO.getPersonCitizenshipIdentityBean(); 
  
  boolean evalConclusionCheckedAge = false;
     
  
   //Method of Age Verification
        Map<String, String> methodAgeVerificationList = new HashMap<String, String>();
        List<CodeAttributes> ageVerificationList = Lookup.getCategoryCollection(CodesTables.CAGEVERF);
        Iterator<CodeAttributes> ageVerificationList_it = ageVerificationList.iterator();
        while (ageVerificationList_it.hasNext()){
          CodeAttributes attribute = ageVerificationList_it.next();
          String code = attribute.getCode();
          if ("ABC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdUsBirthCert");
          } else if ("ABP".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdBaptismCert");
          } else if ("ACF".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdForeignCert");
          } else if ("AEC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeJustifiedEval");
          } else if ("AHC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdHospitalCert");
          } else if ("ANC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdNtrlztnCert");
          } else if ("ARC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdResidentCard");
          } else if ("AUS".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdPassport");
          }
        }
        
        
   String[] checkedMethodOfAgeVerification = null;  
   
   if(personCitizenshipIdentityBean != null){
     if(personCitizenshipIdentityBean.getMethodAgeVerifications() != null)
      {
        checkedMethodOfAgeVerification = personCitizenshipIdentityBean.getMethodAgeVerifications();
      }
   }
  // 

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n\r\n/* Child found in U.S under age five, parents unknown, display an alert to inform\r\n** the user to refer the case to a Regional Attorney immediately.\r\n*/\r\nfunction displayAlert()\r\n{\r\n  var x = document.frmAgeCitizenship;\r\n  if ( x.indCtznshpChldFound.value == \"true\")\r\n  {\r\n    //!!! MessageLookup?\r\n    alert(\" Refer the case immediately to a Regional Attorney.  Unless the child applies for a citizenship certificate or, if not eligible, for Special Juvenile Immigrant Status, the child will have no proof of status.\");\r\n    return true;\r\n  }\r\n}\r\n/* If the application is in COMP status, have the user confirm they want to \r\n** open the narrative in edit mode (or create it, if no narrative exists).\r\n** checkCreateNarrativeConfirm()\r\n*/\r\nfunction checkCreateNarrativeConfirm()\r\n{\r\n");

if ("COMP".equals(ageCitizenshipDB.getCdEventStatus()) && PageModeConstants.EDIT.equals(pageMode))
{
  if (ageCitizenshipDB.getIndEvaluationConclusion())
  {

      out.write("\r\n  var userDecision = confirm('If you wish to demote the FCE Application\\'s event status to PEND and\\n' +\r\n                             'open the Evaluative Conclusion Narrative in Edit mode, click \\'OK\\'.\\n\\n' +\r\n                             'Otherwise, click \\'Cancel\\' to open in View mode.');\r\n  if (userDecision)\r\n  {\r\n    document.frmAgeCitizenship.userConfirmNarrative.value = userDecision;  \r\n    submitValidateForm(\"frmAgeCitizenship\", \"/fce/AgeCitizenship/saveAndStayAgeCitizenship\");\r\n    return false;\r\n  }\r\n  return true;\r\n");

  }
  else
  {

      out.write("\r\n  var userDecision = confirm('No Evaluative Conclusion Narrative exists for this application.\\n\\n' + \r\n                             'If you wish to demote the FCE Application\\'s event status to PEND\\n' +\r\n                             'and create a new Evaluative Conclusion Narrative, click \\'OK\\'.\\n\\n' +\r\n                             'Otherwise, click \\'Cancel\\'.');\r\n  if (userDecision)\r\n  {\r\n    document.frmAgeCitizenship.userConfirmNarrative.value = userDecision;  \r\n    submitValidateForm(\"frmAgeCitizenship\", \"/fce/AgeCitizenship/saveAndStayAgeCitizenship\");\r\n    return false;\r\n  }\r\n  return false;\r\n");

  }
}
else
{

      out.write("\r\n  return true;\r\n");

}

      out.write("\r\n}\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAgeCitizenship");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fce/AgeCitizenship/displayAgeCitizenship");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.AgeCitizenshipValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr>\r\n    <th colspan=\"3\">Child's Age</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"15%\">\r\n      <label cssClass=\"formInput\">Age</label>\r\n    </td>\r\n    <td width=\"10%\" >\r\n      ");
          out.print( ageCitizenshipDB.getNbrAge() );
          out.write("\r\n    </td>\r\n    <td width=\"75%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <label cssClass=\"formInput\">Date of Birth</label>\r\n    </td>\r\n    <td >\r\n      ");
          out.print( ageCitizenshipDB.getDtBirthString() );
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setOnClick("javascript:disableValidation('frmAgeCitizenship')");
          _jspx_th_impact_ButtonTag_0.setName("btnDetailFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnDetail");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setForm("frmAgeCitizenship");
          _jspx_th_impact_ButtonTag_0.setAction("/fce/AgeCitizenship/callPersonDetail");
          _jspx_th_impact_ButtonTag_0.setFunction("disableValidation('frmAgeCitizenship')");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   </tr>\r\n  <tr>\r\n <td>Approximate?</td>\r\n <td colspan=\"2\">\r\n   ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest( (ageCitizenshipDB.getIndDobApprox()) );
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n     <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\"/>\r\n   ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n </td>\r\n</tr>\r\n </table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\"> \r\n  <tr>\r\n   <th colspan=\"4\">Method of Verification</th>\r\n </tr>\r\n ");

  if (checkedMethodOfAgeVerification == null || checkedMethodOfAgeVerification.length == 0){
 
          out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n ");

  } else {
    for (int i = 1; i <= checkedMethodOfAgeVerification.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){
 
          out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CAGEVERF, checkedMethodOfAgeVerification[i-1]));
          out.write("</td>\r\n");

        if (i == checkedMethodOfAgeVerification.length){

          out.write("\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n");

        }
      } else {

          out.write("\r\n    <td>");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CAGEVERF, checkedMethodOfAgeVerification[i-1]));
          out.write("</td>\r\n  </tr>\r\n");

      }

          out.write("    \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName(  methodAgeVerificationList.get(checkedMethodOfAgeVerification[i-1]) );
          _jspx_th_impact_validateInput_0.setValue("true");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
    
      if ("AEC".equals(checkedMethodOfAgeVerification[i-1])){
        evalConclusionCheckedAge = true;
      }                  
    }
  }
 

          out.write("             \r\n </table>             \r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\"> \r\n  <tr>\r\n   <th colspan=\"4\">Verified by Eligibility Specialist</th>\r\n </tr>\r\n <tr>\r\n    <td colspan=\"2\">If any of the selections below are checked, Please ensure results are documented in Records Checked</td>\r\n </tr>\r\n <tr>\r\n    <td width=\"50%\">\r\n               ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setLabel("SUCCESS System");
          _jspx_th_impact_validateInput_1.setName("indAgeVrfdSuccessSystem");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setValue("true");
          _jspx_th_impact_validateInput_1.setChecked( ageCitizenshipDB.getIndAgeVrfdSuccessSystemString() );
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setDisabled("false");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n            <td>\r\n               ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setLabel("SAVE System");
          _jspx_th_impact_validateInput_2.setName("indAgeVrfdSaveSystem");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setValue("true");
          _jspx_th_impact_validateInput_2.setChecked( ageCitizenshipDB.getIndAgeVrfdSaveSystemString() );
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n    </tr>\r\n </table>\r\n <br>\r\n   ");
 /*begin  Expandable section */ 
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("ageCitizenship");
          _jspx_th_impact_ExpandableSectionTag_0.setId("AgeCitizenship_id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("If birth verification document is not being sent to worker, complete this section.");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table border=\"0\" cellSpacing=\"0\" cellPadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr class=\"subDetail\">\r\n     <td>\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n     <tr>\r\n     <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_3.setType("text");
              _jspx_th_impact_validateInput_3.setName("nmHospital");
              _jspx_th_impact_validateInput_3.setLabel("Hospital Name");
              _jspx_th_impact_validateInput_3.setValue( ageCitizenshipDB.getNmHospital() );
              _jspx_th_impact_validateInput_3.setSize("50");
              _jspx_th_impact_validateInput_3.setMaxLength("50");
              _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n     </tr>\r\n     <tr>\r\n       <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setType("text");
              _jspx_th_impact_validateInput_4.setName("nmMotherMaiden");
              _jspx_th_impact_validateInput_4.setLabel("Mother's Maiden Name");
              _jspx_th_impact_validateInput_4.setValue( ageCitizenshipDB.getNmMotherMaiden() );
              _jspx_th_impact_validateInput_4.setSize("22");
              _jspx_th_impact_validateInput_4.setMaxLength("22");
              _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n       <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setType("text");
              _jspx_th_impact_validateInput_5.setLabel("City");
              _jspx_th_impact_validateInput_5.setConstraint("Name20");
              _jspx_th_impact_validateInput_5.setName("nmHospitalCity");
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              _jspx_th_impact_validateInput_5.setValue( ageCitizenshipDB.getNmHospitalCity() );
              _jspx_th_impact_validateInput_5.setSize("20");
              _jspx_th_impact_validateInput_5.setMaxLength("20");
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n   </tr>\r\n   <tr>\r\n    <td> ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_0.setLabel("State");
              _jspx_th_impact_validateSelect_0.setName("cdState");
              _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_0.setCodesTable("CSTATE");
              _jspx_th_impact_validateSelect_0.setValue( ageCitizenshipDB.getCdState() );
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td> ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_1.setLabel("County");
              _jspx_th_impact_validateSelect_1.setName("cdCountyHospital");
              _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_1.setValue( ageCitizenshipDB.getCdCountyHospital() );
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n   </tr>\r\n   </table>\r\n </td>\r\n </tr>\r\n </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr>\r\n   <th colspan=\"4\">Child's Citizenship/Alien Status</th>\r\n  </tr>\r\n  <tr>\r\n  <td width=\"20%\">\r\n    <label class=\"formInput\">Citizenship/Alien Status</label>\r\n  </td>\r\n  <td width=\"10%\" align=\"right\">\r\n    <nobr>");
          out.print( Lookup.simpleDecodeSafe("CCTZNSTA",
                                      ageCitizenshipDB.getFceEligibilityCdPersonCitizenship()) );
          out.write("</nobr>\r\n  </td>\r\n  <td width=\"70%\">           \r\n     ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnDetailFinal");
          _jspx_th_impact_ButtonTag_1.setImg("btnDetail");
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setForm("frmAgeCitizenship");
          _jspx_th_impact_ButtonTag_1.setAction("/fce/AgeCitizenship/callPersonCitizenshipIdentity");
          _jspx_th_impact_ButtonTag_1.setFunction("disableValidation('frmAgeCitizenship')");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n </td>\r\n </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n <tr>\r\n  <th colspan=\"2\">Method of Verification</th>\r\n </tr>\r\n <tr>\r\n  <td>\r\n");

 request.setAttribute("tabIndex", tabIndex);
 request.setAttribute("fceEligibilityDB", ageCitizenshipDB.getFceEligibility());

          out.write('\r');
          out.write('\n');

//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  6/17/08   charden			  STGAP00008647: changed code around to catch null
//**							  b_personCitizenshipIdentitylRetrieveSO object
//**   1/2/08   charden           STGAP00010009: added added logic to null check of checkedUSCitizen
//**                              to correctly catch empty/null object. Key was being set as parameter
//**                              name which was causing null pointer in grnds architecture
//**  11/11/09  mxpatel           37462: removed changes made for STGAP00010009
//**

          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  String _bgColor = "#FFFFFF";
  int NUMBER_OF_CITIZENSHIP_ROWS = 9;
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  boolean _evalConclusionChecked = false; 
  String _disableCitizenship = "" + (Boolean) request.getAttribute("disableCitizenship");
  FceEligibilityDB _fceEligibilityDB = (FceEligibilityDB) request.getAttribute("fceEligibilityDB");
  PersonCitizenshipIdentitylRetrieveSO _personCitizenshipIdentitylRetrieveSO = (PersonCitizenshipIdentitylRetrieveSO) request.getAttribute("personCitizenshipIdentitylRetrieveSO");    

  if (_personCitizenshipIdentitylRetrieveSO == null)
   {
     _personCitizenshipIdentitylRetrieveSO = new PersonCitizenshipIdentitylRetrieveSO();
   }
   //STGAP00008647 moved line below to after the if statement so that it would not be affected by null _personCitizenshipIdentitylRetrieveSO object
   PersonCitizenshipIdentityList _personCitizenshipIdentityBean = _personCitizenshipIdentitylRetrieveSO.getPersonCitizenshipIdentityBean();
   
   //Method of Citizenship Verification : US Citizen
        Map<String, String> methodUSCitizenVerificationList = new HashMap<String, String>();
        List<CodeAttributes> uSCitizenVerificationList = Lookup.getCategoryCollection(CodesTables.CCERTVER);
        Iterator<CodeAttributes> uSCitizenVerificationList_it = uSCitizenVerificationList.iterator();
        
        while (uSCitizenVerificationList_it.hasNext()){
          CodeAttributes attribute = uSCitizenVerificationList_it.next();
          String code = attribute.getCode();
          if ("CBC".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpBirthCrtfctUs");
          } else if ("RBH".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpHospitalCrtfct");
          } else if ("CID".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpUsIdCard");
          } else if ("FAD".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpFinalAdoptDecree");
          } else if ("RBA".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpBirthAbroad");
          } else if ("MRS".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpMiltryBirthRcrd");
          } else if ("EHR".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpUsHsptlBrthRcrd");
          } else if ("CBR".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpCensusBirthRcrd");
          } else if ("CRB".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpCertReportBirth");
          } else if ("NCF".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpNtrlztnCrtfct");
          } else if ("USP".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpPassport");
          } else if ("AIC".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpAmerIndianCrd");
          } else if ("CSE".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpCivilServiceEmp");
          } else if ("NMC".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpNorthMarianaId");
          } else if ("BVS".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpVitalBirthRcrd");
          } else if ("COB".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpConfrmBirth");
          } else if ("LHI".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpLifeInsBrthRcrd");
          } else if ("MRB".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpMedBirthRcrd");
          } else if ("ECN".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpEvaluation");
          }
        }
        
        //Method of Citizenship Verification : Identity Verification (Adult)
        Map<String, String> methodIdentityAdultVerificationList = new HashMap<String, String>();
        List<CodeAttributes> identityAdultVerificationList = Lookup.getCategoryCollection(CodesTables.CIDENTAD);
        Iterator<CodeAttributes> identityAdultVerificationList_it = identityAdultVerificationList.iterator();
        while (identityAdultVerificationList_it.hasNext()){
          CodeAttributes attribute = identityAdultVerificationList_it.next();
          String code = attribute.getCode();
          if ("CDL".equals(code)){
            methodIdentityAdultVerificationList.put(code, "indCtznshpDriverLicOrId");
          } else if ("IDD".equals(code)){
            methodIdentityAdultVerificationList.put(code, "indCtznshpDocImmigNatAct");
          } else if ("CIB".equals(code)){
            methodIdentityAdultVerificationList.put(code, "indCtznshpCertIndBlood");
          }
        }
        
        //Method of Citizenship Verification : Identity Verification (Under 16 Only)
        Map<String, String> methodIdentityUnder16VerificationList = new HashMap<String, String>();
        List<CodeAttributes> identityUnder16VerificationList = Lookup.getCategoryCollection(CodesTables.CIDENTUN);
        Iterator<CodeAttributes> identityUnder16VerificationList_it = identityUnder16VerificationList.iterator();
        while (identityUnder16VerificationList_it.hasNext()){
          CodeAttributes attribute = identityUnder16VerificationList_it.next();
          String code = attribute.getCode();
          if ("SIP".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpSchoolIdPhoto");
          } else if ("SRD".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpSchoolRec");
          } else if ("DNS".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpDaycareNurseRcrd");
          } else if ("MID".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpMilitaryDepdntId");
          } else if ("CDH".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpClinicDocHosDoc");
          } else if ("ACI".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpAffidavitSigned");
          }
        }  

        //Method of Citizenship Verification : Permanent Resident/Refugee
        Map<String, String> methodPermResidentRefugeeVerificationList = new HashMap<String, String>();
        List<CodeAttributes> permResidentRefugeeVerificationList = Lookup.getCategoryCollection(CodesTables.CPERMRES);
        Iterator<CodeAttributes> permResidentRefugeeVerificationList_it = permResidentRefugeeVerificationList.iterator();
        while (permResidentRefugeeVerificationList_it.hasNext()){
          CodeAttributes attribute = permResidentRefugeeVerificationList_it.next();
          String code = attribute.getCode();
          if ("ARR".equals(code)){
            methodPermResidentRefugeeVerificationList.put(code, "indCtznshpResidentCard");
          } else if ("REF".equals(code)){
            methodPermResidentRefugeeVerificationList.put(code, "indCtznshpRefugee");
          } 
        }
        
        //Method of Citizenship Verification : Other Qualified Alien
        Map<String, String> methodOtherQualifiedAlienVerificationList = new HashMap<String, String>();
        List<CodeAttributes> otherQualifiedAlienVerificationList = Lookup.getCategoryCollection(CodesTables.COTHRQUA);
        Iterator<CodeAttributes> otherQualifiedAlienVerificationList_it = otherQualifiedAlienVerificationList.iterator();
        while (otherQualifiedAlienVerificationList_it.hasNext()){
          CodeAttributes attribute = otherQualifiedAlienVerificationList_it.next();
          String code = attribute.getCode();
          if ("DRA".equals(code)){
            methodOtherQualifiedAlienVerificationList.put(code, "indCtznshpAttorneyReview");
          } else if ("STV".equals(code)){
            methodOtherQualifiedAlienVerificationList.put(code, "indCtznshpStudentVisa");
          } 
        }

        //Method of Citizenship Verification : Undetermined/Other Staus
        Map<String, String> methodUndeterminedOtherVerificationList = new HashMap<String, String>();
        List<CodeAttributes> undeterminedOtherVerificationList = Lookup.getCategoryCollection(CodesTables.CUDETALN);
        Iterator<CodeAttributes> undeterminedOtherVerificationList_it = undeterminedOtherVerificationList.iterator();
        while (undeterminedOtherVerificationList_it.hasNext()){
          CodeAttributes attribute = undeterminedOtherVerificationList_it.next();
          String code = attribute.getCode();
          if ("FBC".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpBirthCrtfctFor");
          } else if ("NDC".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpNoDocumentation");
          } else if ("CUS".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpChldFound");
          } else if ("UIM".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpUndocImmigrant");
          } else if ("FOS".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpForDocumentation");
          } else if ("LIS".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpLeglImmiStatExp");
          } else if ("UMC".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpUnaccMinorChild");
          }
        } 
        
   String[] checkedUSCitizen = null;
   String[] checkedIdentityVerificationAdult = null;
   String[] checkedIdentityVerificationUnder16Only = null;
   String[] checkedPermanentResRefugee = null;
   String[] checkedOtherQualifiedAlien = null;
   String[] checkedUndetermined = null; 
   
   if(_personCitizenshipIdentityBean != null){
   	  if(_personCitizenshipIdentityBean.getUSCitizenVerifications() != null)
      {
      	checkedUSCitizen = _personCitizenshipIdentityBean.getUSCitizenVerifications();
      }
      if(_personCitizenshipIdentityBean.getIdentityAdultVerifications() != null)
      {
        checkedIdentityVerificationAdult = _personCitizenshipIdentityBean.getIdentityAdultVerifications();
      }
      if(_personCitizenshipIdentityBean.getIdentityUnder16Verifications() != null)
      {
        checkedIdentityVerificationUnder16Only = _personCitizenshipIdentityBean.getIdentityUnder16Verifications();  
      }
      if(_personCitizenshipIdentityBean.getPermanentResidentRefugee() != null)
      {
        checkedPermanentResRefugee = _personCitizenshipIdentityBean.getPermanentResidentRefugee();
      }
      if(_personCitizenshipIdentityBean.getOtherQualifiedAlien() != null)
      {
        checkedOtherQualifiedAlien = _personCitizenshipIdentityBean.getOtherQualifiedAlien();
      }
      if(_personCitizenshipIdentityBean.getUndeterminedStatus() != null)
      {
        checkedUndetermined = _personCitizenshipIdentityBean.getUndeterminedStatus();
      }
   }

          out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" bgcolor=\"");
          out.print( _bgColor );
          out.write("\">\r\n     <tr>\r\n          <th colspan=\"2\"> US Citizen </th>\r\n         </tr>\r\n ");

  if (checkedUSCitizen == null || checkedUSCitizen.length == 0){

          out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedUSCitizen.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

          out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CCERTVER, checkedUSCitizen[i-1]));
          out.write("</td>\r\n");

        if (i == checkedUSCitizen.length){

          out.write("\r\n  </tr>\r\n");

        }
      } else {

          out.write("\r\n    <td>");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CCERTVER, checkedUSCitizen[i-1]));
          out.write("</td>\r\n  </tr>\r\n");

      }

          out.write("    \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName(  methodUSCitizenVerificationList.get(checkedUSCitizen[i-1]) );
          _jspx_th_impact_validateInput_6.setValue("true");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
  
      if ("ECN".equals(checkedUSCitizen[i-1])){
        _evalConclusionChecked = true;
      }   
    }
  }

          out.write("       \r\n <tr>\r\n   <th colspan=\"2\"> Identity Verification (Adult) </th>\r\n </tr>\r\n ");

  if (checkedIdentityVerificationAdult == null || checkedIdentityVerificationAdult.length == 0){

          out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedIdentityVerificationAdult.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

          out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CIDENTAD, checkedIdentityVerificationAdult[i-1]));
          out.write("</td>\r\n");

        if (i == checkedIdentityVerificationAdult.length){

          out.write("\r\n  </tr>\r\n");

        }
      } else {

          out.write("\r\n    <td>");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CIDENTAD, checkedIdentityVerificationAdult[i-1]));
          out.write("</td>\r\n  </tr>\r\n");

      }

          out.write("    \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName(  methodIdentityAdultVerificationList.get(checkedIdentityVerificationAdult[i-1]) );
          _jspx_th_impact_validateInput_7.setValue("true");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
       
    }
  }

          out.write(" \r\n <tr>\r\n   <th colspan=\"2\"> Identity Verification (Under 16 Only) </th>\r\n </tr>\r\n");

  if (checkedIdentityVerificationUnder16Only == null || checkedIdentityVerificationUnder16Only.length == 0){

          out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedIdentityVerificationUnder16Only.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

          out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CIDENTUN, checkedIdentityVerificationUnder16Only[i-1]));
          out.write("</td>\r\n");

        if (i == checkedIdentityVerificationUnder16Only.length){

          out.write("\r\n  </tr>\r\n");

        }
      } else {

          out.write("\r\n    <td>");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CIDENTUN, checkedIdentityVerificationUnder16Only[i-1]));
          out.write("</td>\r\n  </tr>\r\n");

      }

          out.write("    \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName(  methodIdentityUnder16VerificationList.get(checkedIdentityVerificationUnder16Only[i-1]) );
          _jspx_th_impact_validateInput_8.setValue("true");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
                           
    }
  }

          out.write("   \r\n  <tr>\r\n    <th colspan=\"2\">Permanent Resident</th>\r\n  </tr>\r\n ");

  if (checkedPermanentResRefugee == null || checkedPermanentResRefugee.length == 0){

          out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedPermanentResRefugee.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

          out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CPERMRES, checkedPermanentResRefugee[i-1]));
          out.write("</td>\r\n");

        if (i == checkedPermanentResRefugee.length){

          out.write("\r\n  </tr>\r\n");

        }
      } else {

          out.write("\r\n    <td>");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CPERMRES, checkedPermanentResRefugee[i-1]));
          out.write("</td>\r\n  </tr>\r\n");

      }

          out.write("    \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName(  methodPermResidentRefugeeVerificationList.get(checkedPermanentResRefugee[i-1]) );
          _jspx_th_impact_validateInput_9.setValue("true");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
         
    }
  }

          out.write(" \r\n  <tr>\r\n    <th colspan=\"2\">Other Qualified Alien</th>\r\n  </tr>\r\n ");

  if (checkedOtherQualifiedAlien == null || checkedOtherQualifiedAlien.length == 0){

          out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedOtherQualifiedAlien.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

          out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
          out.print(Lookup.simpleDecodeSafe(CodesTables.COTHRQUA, checkedOtherQualifiedAlien[i-1]));
          out.write("</td>\r\n");

        if (i == checkedOtherQualifiedAlien.length){

          out.write("\r\n  </tr>\r\n");

        }
      } else {

          out.write("\r\n    <td>");
          out.print(Lookup.simpleDecodeSafe(CodesTables.COTHRQUA, checkedOtherQualifiedAlien[i-1]));
          out.write("</td>\r\n  </tr>\r\n");

      }

          out.write("    \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName(  methodOtherQualifiedAlienVerificationList.get(checkedOtherQualifiedAlien[i-1]) );
          _jspx_th_impact_validateInput_10.setValue("true");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
       
    }
  }

          out.write("                 \r\n  <tr>\r\n    <th colspan=\"2\">Undetermined Status</th>\r\n  </tr>\r\n ");

  if (checkedUndetermined == null || checkedUndetermined.length == 0){

          out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedUndetermined.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

          out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CUDETALN, checkedUndetermined[i-1]));
          out.write("</td>\r\n");

        if (i == checkedUndetermined.length){

          out.write("\r\n  </tr>\r\n");

        }
      } else {

          out.write("\r\n    <td>");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CUDETALN, checkedUndetermined[i-1]));
          out.write("</td>\r\n  </tr>\r\n");

      }

          out.write("    \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName(  methodUndeterminedOtherVerificationList.get(checkedUndetermined[i-1]) );
          _jspx_th_impact_validateInput_11.setValue("true");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
       
    }
  }

          out.write("\r\n  <tr>\r\n   <th colspan=\"2\">Verified by Eligibility Specialist</th>\r\n </tr>\r\n <tr>\r\n    <td colspan=\"2\">If any of the selections below are checked, Please ensure results are documented in Records Checked</td>\r\n </tr>\r\n <tr>\r\n    <td width=\"50%\">\r\n               ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setLabel("SUCCESS System");
          _jspx_th_impact_validateInput_12.setName("indCtznshpSuccessSystem");
          _jspx_th_impact_validateInput_12.setTabIndex( (_tabIndex + NUMBER_OF_CITIZENSHIP_ROWS ) );
          _jspx_th_impact_validateInput_12.setValue("true");
          _jspx_th_impact_validateInput_12.setChecked( _fceEligibilityDB.getIndCtznshpSuccessSystemString() );
          _jspx_th_impact_validateInput_12.setType("checkbox");
          _jspx_th_impact_validateInput_12.setDisabled("false");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n               \r\n           </td>\r\n            <td>\r\n               ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setLabel("SAVE System");
          _jspx_th_impact_validateInput_13.setName("indCtznshpSaveSystem");
          _jspx_th_impact_validateInput_13.setTabIndex( (_tabIndex + NUMBER_OF_CITIZENSHIP_ROWS + 1) );
          _jspx_th_impact_validateInput_13.setValue("true");
          _jspx_th_impact_validateInput_13.setChecked( _fceEligibilityDB.getIndCtznshpSaveSystemString() );
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n    </tr>\r\n\r\n  </table>\r\n");

 _tabIndex += (NUMBER_OF_CITIZENSHIP_ROWS + 2);
 request.setAttribute("tabIndex", _tabIndex);
 request.setAttribute("evalConclusionCheckedCitizenship", _evalConclusionChecked);
}

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');

 tabIndex = (Integer) request.getAttribute("tabIndex");
 boolean evalConclusionCheckedCitizenship = (Boolean) request.getAttribute("evalConclusionCheckedCitizenship");
 
 // The Evaluative Conclusion Approved checkbox should not appear on the page
 // until the Application is in PEND mode, there is an Evaluative Conclusion,
 //  and the user has the SEC_ELIGIBILITY security attribute.
 if (("NEW".equalsIgnoreCase(ageCitizenshipDB.getCdEventStatus())) ||
     ("PROC".equalsIgnoreCase(ageCitizenshipDB.getCdEventStatus())) ||
     (!evalConclusionCheckedAge && !evalConclusionCheckedCitizenship))
 {
   evalConcApprvdCheckButtonHide = true;
 }

 if ("PEND".equalsIgnoreCase(ageCitizenshipDB.getCdEventStatus()) &&
     (user.hasRight(UserProfile.SEC_ELIGIBILITY)))
 {
   evalConcApprvdDisabled = "false";
 }
 else
 {
   evalConcApprvdDisabled = "true";
 }

          out.write("\r\n </td>\r\n</tr>\r\n</table>\r\n <br>\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n    <tr>\r\n     <th colspan=\"3\">Evaluative Conclusion</th>\r\n</tr>\r\n <tr>\r\n <td>If the child's age or U.S citizenship cannot be verified by one of the above verification methods,\r\n     check if the child meets the criteria for evaluative conclusion (see Narrative).</td>\r\n </tr>\r\n <tr>\r\n\r\n  <td>\r\n    ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest( !evalConcApprvdCheckButtonHide );
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateInput_14.setLabel("Evaluative Conclusion Approved");
              _jspx_th_impact_validateInput_14.setName("indNarrativeApproved");
              _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_14.setValue("true");
              _jspx_th_impact_validateInput_14.setDisabled(evalConcApprvdDisabled);
              _jspx_th_impact_validateInput_14.setChecked( ageCitizenshipDB.getIndNarrativeApprovedString() );
              _jspx_th_impact_validateInput_14.setType("checkbox");
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("      \r\n  </td>\r\n\r\n  </tr>\r\n </table>\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n<tr>\r\n\r\n  <td class=\"alignRight\">\r\n ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmAgeCitizenship");
          _jspx_th_impact_ButtonTag_2.setAction("/fce/AgeCitizenship/saveAgeCitizenship");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</td>\r\n </tr>\r\n</table>\r\n</table>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("idFceApplication");
          _jspx_th_impact_validateInput_15.setValue(  ageCitizenshipDB.getIdFceApplicationString() );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("idFceEligibility");
          _jspx_th_impact_validateInput_16.setValue( ageCitizenshipDB.getIdFceEligibilityString() );
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
          _jspx_th_impact_validateInput_17.setName("idPerson");
          _jspx_th_impact_validateInput_17.setValue( ageCitizenshipDB.getIdPersonString() );
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
          _jspx_th_impact_validateInput_18.setName("idEvent");
          _jspx_th_impact_validateInput_18.setValue( ageCitizenshipDB.getIdEventString() );
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
          _jspx_th_impact_validateInput_19.setName("idStage");
          _jspx_th_impact_validateInput_19.setValue( ageCitizenshipDB.getIdStageString() );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("fceEligibilityCdPersonCitizenship");
          _jspx_th_impact_validateInput_20.setValue( ageCitizenshipDB.getFceEligibilityCdPersonCitizenship() );
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
          _jspx_th_impact_validateInput_21.setName("fceApplicationDtLastUpdateTime");
          _jspx_th_impact_validateInput_21.setValue( FormattingHelper.formatLong(ageCitizenshipDB.getFceApplicationDtLastUpdateTime()) );
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
          _jspx_th_impact_validateInput_22.setName("fceEligibilityDtLastUpdateTime");
          _jspx_th_impact_validateInput_22.setValue( FormattingHelper.formatLong(ageCitizenshipDB.getFceEligibilityDtLastUpdateTime()) );
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
          _jspx_th_impact_validateInput_23.setName("idLastUpdatePerson");
          _jspx_th_impact_validateInput_23.setValue( FormattingHelper.formatInt(BasePrsConversation.getUserID(request)));
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("dtBirth");
          _jspx_th_impact_validateInput_24.setValue( ageCitizenshipDB.getDtBirthString() );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_25(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName("indCtznshpChldFound");
          _jspx_th_impact_validateInput_26.setValue( "" + ageCitizenshipDB.getIndCtznshpChldFound() );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("                      \r\n\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");

//****************************
//**** REPORTS START HERE ****
//****************************

      out.write('\r');
      out.write('\n');
/* BEGIN: Forms and Reports */
      out.write('\r');
      out.write('\n');

/* Narrative should be protected if the page is in VIEW mode, OR
** if the event status is COMP.  If the application is in COMP and
** the user confirms they want to edit the narrative and reset status
** to PEND, the page is submitted for saving and the status is reset to
** PEND before redisplaying, so the logic here is simple. 
*/
boolean protectDoc = (PageModeConstants.VIEW.equals(pageMode)) || (("COMP".equals(ageCitizenshipDB.getCdEventStatus()) && ageCitizenshipDB.getIndEvaluationConclusion()));

      out.write("\r\n<br>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n<td>\r\n");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("Age and Citizenship");
          _jspx_th_impact_document_0.setName("frmDocumentTag");
          _jspx_th_impact_document_0.setProtectDocument( protectDoc );
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setCheckStage( GlobalData.getUlIdStage(request) );
          _jspx_th_impact_document_0.setDocType("EVALCNCL");
          _jspx_th_impact_document_0.setOnClick("checkCreateNarrativeConfirm()");
          _jspx_th_impact_document_0.setAction("/fce/AgeCitizenship/launchEvaluativeConclusionNarrative");
          _jspx_th_impact_document_0.setDocExists( ageCitizenshipDB.getIndEvaluationConclusion() );
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sEvent");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("sStage");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n</td>\r\n</tr>\r\n</table>\r\n\r\n");

String userConfirmNarrative = request.getParameter("userConfirmNarrative");
if (userConfirmNarrative != null && "true".equals(userConfirmNarrative) && !FormValidation.pageHasValidationMessages("frmAgeCitizenship", request) && !FormValidation.pageHasErrorMessages(request))
{

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction launchNarrative()\r\n{\r\n  document.getElementById('btnSubmit').click();\r\n}\r\nwindow.attachEvent( 'onload', launchNarrative );\r\n</script>\r\n");

}

      out.write("\r\n\r\n");

}

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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateErrors_0.setFormName("frmAgeCitizenship");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_25(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_25.setType("hidden");
    _jspx_th_impact_validateInput_25.setName("userConfirmNarrative");
    _jspx_th_impact_validateInput_25.setValue("false");
    int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
    if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
