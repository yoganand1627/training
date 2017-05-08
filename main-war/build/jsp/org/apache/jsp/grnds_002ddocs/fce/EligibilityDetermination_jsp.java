package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDeterminationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;
import gov.georgia.dhr.dfcs.sacwis.web.fce.EligibilityDeterminationConversation;

public final class EligibilityDetermination_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**  JSP Name:     Domicile and Deprevation
 *   Created by:   Rodrigo DeJuana
 *   Date Created: 02/17/02
 *   Description:
 *   This page is used to accurately determine if the child meets the AFDC
 *   requirement for Deprivation and Domicile.
**/
/*
 Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Added Description to Flowerbox.
  12/27/10  hjbaptiste        SMS#88374; MR-053 fixed diplaying the gross earned income for
                              deeming responsible individuals and added link to income and expenditures
                              page for gross unearned income.
  12/28/10  hjbaptiste        SMS#89028; MR-053 Fixed Grossed earned income rounding                           
  12/29/10  hnguyen           SMS#89026; MR-053 Corrected IV-E Budget Resource and GIC test 
                              and Total Countable Income.
  01/05/10  hjbaptiste        SMS#86429; MR-053 Do not show deprivation and citizenship in the Requirements section
                              for NOC                                                          
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int tabIndex = 1;
  String pageMode = PageMode.getPageMode(request);

  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  EligibilityDeterminationDB eligibilityDB = (EligibilityDeterminationDB)
    request.getAttribute(EligibilityDeterminationConversation.ELIGIBILITYDB);
    
  String cdApplication = (String) request.getAttribute("cdApplication");
  List<FcePersonDB> aUMembersList = eligibilityDB.getAUMembers();
  List<FcePersonDB> nonAUMembersList = eligibilityDB.getNonAUMembers();
  List<FcePersonDB> principlesList = eligibilityDB.getPrincipals();

  Integer pendingStageClosureEventId = (Integer)request.getAttribute(EligibilityDeterminationConversation.STAGE_CLOSURE_EVENT_ID);
  if (pendingStageClosureEventId == null)
  {
    pendingStageClosureEventId = 0;
  }



      out.write("\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n\r\nfunction yes()\r\n{\r\n");

  if ( pendingStageClosureEventId > 0 )
  {

      out.write("\r\n  var MSG_CMN_INVLD_APRVL =\r\n      \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL) );
      out.write("\";\r\n  if ( !confirm(MSG_CMN_INVLD_APRVL) )\r\n  {\r\n    return false;\r\n  }\r\n");

  }

      out.write("\r\n  disableValidation('frmEDW');\r\n  return true;\r\n}\r\n\r\n\r\nfunction navigateTo(destination)\r\n{\r\n  disableValidation(\"frmEDW\");\r\n  submitValidateForm(\"frmEDW\", destination);\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmEDW");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fce/EligibilityDetermination/saveEligibilityDetermination");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.EligibilityDeterminationCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n<!-- Hidden Fields -->\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnPendingStageClosureEventId");
          _jspx_th_impact_validateInput_0.setValue( String.valueOf(pendingStageClosureEventId) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("idEvent");
          _jspx_th_impact_validateInput_1.setValue( eligibilityDB.getIdEventString() );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("idFceApplication");
          _jspx_th_impact_validateInput_2.setValue( eligibilityDB.getIdFceApplicationString() );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("idFceEligibility");
          _jspx_th_impact_validateInput_3.setValue( eligibilityDB.getIdFceEligibilityString() );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("idFcePerson");
          _jspx_th_impact_validateInput_4.setValue( eligibilityDB.getIdFcePersonString() );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("idLastUpdatePerson");
          _jspx_th_impact_validateInput_5.setValue( eligibilityDB.getIdLastUpdatePersonString() );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("idPerson");
          _jspx_th_impact_validateInput_6.setValue( eligibilityDB.getIdPersonString() );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("idStage");
          _jspx_th_impact_validateInput_7.setValue( eligibilityDB.getIdStageString() );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("fceEligibilityDtLastUpdateTime");
          _jspx_th_impact_validateInput_8.setValue( ""+ eligibilityDB.getFceEligibilityDtLastUpdateTime() );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<!--- Begin Detail Table --->\r\n\r\n");
 if (eligibilityDB.getIndEligibleObject() != null) { 
          out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" >\r\n  <tr>\r\n    <td class=\"ReasonsNotEligibileTitle\">Child is");
          out.print( eligibilityDB.getIndEligible() ? "" : " NOT" );
          out.write(" Eligible for Title IV-E");
          out.print( ("R".equals(cdApplication)) ? " Reimbursability" : "" );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n  ");
 if(eligibilityDB.getIndChildReceivingSSI()){
          out.write("\r\n    <td>Due to IV-E eligibility and SSI income, the recommended funding source is IV-B.</td>\r\n  ");
}
          out.write("\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <ul>\r\n");

List reasonList = eligibilityDB.getReasonsNotEligible();
Iterator reasonIt = reasonList.iterator();
while (reasonIt.hasNext())
{
  FceReasonNotEligibleDB reason = (FceReasonNotEligibleDB) reasonIt.next();

          out.write("\r\n        <li class=\"ReasonsNotEligibileReason\">");
          out.print( Lookup.simpleDecodeSafe(CodesTables.CFCERNE, reason.getCdReasonNotEligible()));
          out.write("</li>\r\n");
}
          out.write("\r\n      </ul>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } 
          out.write("\r\n\r\n");

int i = 1;
String budgetingProcess = (String) request.getAttribute(EligibilityDeterminationConversation.BUDGETING_PROCESS);
// Only show this section if we're doing an AFCD Budget
if (EligibilityDeterminationConversation.AFDC_BUDGETING.equals(budgetingProcess)) {

          out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"3\"> I. Deeming Budget</th>\r\n  </tr>\r\n  <tr>\r\n    <td>1.</td>\r\n    <td>\r\n\t    Number of responsible individual's children who live in the home but are not included in the AU\r\n\t</td>\r\n\t<td width=\"10%\"><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( eligibilityDB.getNbrDeemChildNotInAU() );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>2.</td>\r\n    <td>\r\n      Number of other dependents in the home who are claimed or could be claimed as tax dependents and are not included in the AU\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( eligibilityDB.getNbrDeemTaxDependNotInAU() );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>3.</td>\r\n    <td>\r\n      Number of Responsible Individuals\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( eligibilityDB.getNbrDeemResponseIndiv() );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>4.</td>\r\n    <td>\r\n      Total of 1, 2, 3 above\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( eligibilityDB.getNbrDeemPersonSONLookup() );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>5.</td>\r\n    <td>\r\n      Earned Income\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemGrossEarnedIncome()) );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>6.</td>\r\n    <td>\r\n      Earned Income Deduction (Only if the Responsible Individual has earning)\r\n    </td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemStdEarnedIncDeduct()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>7.</td>\r\n    <td>\r\n      Net Earned Income\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemNetEarnedIncome()) );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>8.</td>\r\n    <td>\r\n      Unearned Income\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemUnearnedIncome()) );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>9.</td>\r\n    <td>\r\n      Total Net Income\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemCntNetIncome()) );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>10.</td>\r\n    <td>\r\n      Standard of Need (From 4. above)\r\n    </td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemStdOfNeed()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>11.</td>\r\n    <td>\r\n      Amount paid to dependents outside the household who are claimed or could be claimed as tax dependents\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemTaxDependOutHh()) );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>12.</td>\r\n    <td>\r\n      Alimony and/or child support paid to person(s) outside of the household\r\n    </td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemAlimonyOutsideHh()) );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <td>13.</td>\r\n    <td><b>\r\n      ");
          out.print( Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdDeemSurplusOrDeficit()) );
          out.write("</b> (Line 9 minus the total of Line 10, 11 and 12)\r\n    </td>\r\n    <td><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemSurplusOrDeficit()) );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n    <td>14.</td>\r\n    <td>\r\n      <b>Total Deemed Amount </b> (If a surplus exists)\r\n    </td>\r\n    <td><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemTotal()) );
          out.write("</b></td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">II.  Allocation Budget</th>\r\n  </tr>\r\n  <tr>\r\n    <td><b>AU Member(s)</b></td>\r\n    <td width=\"25%\"><b>1. # of Persons to whom AU members' income can be allocated</b></td>\r\n    <td><b>2. Standard Of Need<br>for # of Persons</b></td>\r\n    <td><b>3. Gross income</b></td>\r\n    <td width=\"25%\"><b>4. Allocated Amount</b> (Either 2. or 3; Whichever is less)</td>\r\n  </tr>\r\n");

if (CodesTables.CALOCTYP_MUTP.equals(eligibilityDB.getCdAllocType()) || 
    CodesTables.CALOCTYP_MSGL.equals(eligibilityDB.getCdAllocType()) ||
    CodesTables.CALOCTYP_MMUL.equals(eligibilityDB.getCdAllocType())) { 
    String nmPersonAllocMutual1 = "";
    String nmPersonAllocMutual2 = "";
    if (aUMembersList != null && aUMembersList.size() > 0) {
       Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
        while (aUMembersList_it.hasNext()) {
          FcePersonDB aUMember = aUMembersList_it.next();
          if (eligibilityDB.getIdPersonAllocMutual1() == aUMember.getIdPerson()) {
            nmPersonAllocMutual1 = aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle();
          }
          if (eligibilityDB.getIdPersonAllocMutual2() == aUMember.getIdPerson()) {
            nmPersonAllocMutual2 = aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle();
          }
        }
    }

          out.write("\r\n  <tr>\r\n  \t<td rowspan=\"2\">");
          out.print( nmPersonAllocMutual1 );
          out.write("<br/>\r\n  \t                ");
          out.print( nmPersonAllocMutual2 );
          out.write("</td>\r\n  \t<td>");
          out.print( eligibilityDB.getNbrIneligPersonAllocMutual());
          out.write("</td>\r\n  \t<td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtStdOfNeedAllocMutual()) );
          out.write("</td>\r\n  \t<td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeAllocMutual()) );
          out.write("</a></td>\r\n  \t<td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowanceMutual()) );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n\t<td colspan=\"4\"></td>\r\n  </tr>\r\n");

}
if (CodesTables.CALOCTYP_SGLP.equals(eligibilityDB.getCdAllocType()) || 
    CodesTables.CALOCTYP_MULP.equals(eligibilityDB.getCdAllocType()) ||
    CodesTables.CALOCTYP_MSGL.equals(eligibilityDB.getCdAllocType()) ||
    CodesTables.CALOCTYP_MMUL.equals(eligibilityDB.getCdAllocType())) {
    String nmPersonAllocSngl1 = "";
    if (aUMembersList != null && aUMembersList.size() > 0) {
       Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
        while (aUMembersList_it.hasNext()) {
          FcePersonDB aUMember = aUMembersList_it.next();
          if (eligibilityDB.getIdPersonAllocSngl1() == aUMember.getIdPerson()) {
            nmPersonAllocSngl1 = aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle();
            break;
          }
        }
    } 

          out.write(" \r\n  <tr>\r\n  \t<td>");
          out.print( nmPersonAllocSngl1 );
          out.write("</td>\r\n  \t<td>");
          out.print( eligibilityDB.getNbrIneligPersonAllocSngl1() );
          out.write("</td>\r\n  \t<td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtStdOfNeedAllocSngl1()) );
          out.write("</td>\r\n  \t<td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeAllocSngl1()) );
          out.write("</a></td>\r\n  \t<td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowanceSngl1()) );
          out.write("</a></td>\r\n  </tr>\r\n");

}
if (CodesTables.CALOCTYP_MULP.equals(eligibilityDB.getCdAllocType()) || 
    CodesTables.CALOCTYP_MMUL.equals(eligibilityDB.getCdAllocType())) {
    String nmPersonAllocSngl2 = "";
    if (aUMembersList != null && aUMembersList.size() > 0) {
       Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
        while (aUMembersList_it.hasNext()) {
          FcePersonDB aUMember = aUMembersList_it.next();
          if (eligibilityDB.getIdPersonAllocSngl2() == aUMember.getIdPerson()) {
            nmPersonAllocSngl2 = aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle();
            break;
          }
        }
    } 

          out.write(" \r\n  <tr>\r\n  \t<td>");
          out.print( nmPersonAllocSngl2 );
          out.write("</td>\r\n  \t<td>");
          out.print( eligibilityDB.getNbrIneligPersonAllocSngl2() );
          out.write("</td>\r\n  \t<td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtStdOfNeedAllocSngl2()) );
          out.write("</td>\r\n  \t<td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeAllocSngl2()) );
          out.write("</a></td>\r\n  \t<td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowanceSngl2()) );
          out.write("</a></td>\r\n  </tr>\r\n");

}

          out.write("\r\n  <tr>\r\n      \t<td colspan=\"5\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    \t<td colspan=\"4\"><b>5. Total Allocated Amount</b></td>\r\n    \t<td colspan=\"1\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowance()) );
          out.write("</b></td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">III. AFDC Budget</th>\r\n  </tr>\r\n  <tr>\r\n    <td>Number of People in Assistance Unit</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/ApplicationAndBackground/displayAppAndBG\")'\r\n                                    tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( eligibilityDB.getNbrCertifiedGroup() );
          out.write("</a></td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"3\" width=\"42%\">Resource Test</th>\r\n    <th colspan=\"3\" width=\"58%\">Gross Income Ceiling Test</th>\r\n  </tr>\r\n  <tr>\r\n    <td>Total Nonexempt Resources</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtNonexmptRsrcCrtfdGrp()) );
          out.write("</a></td>\r\n    <td></td>\r\n    <td>Gross Income (Plus Deemed (Only Added if Surplus, from I. 14., above) less Allocated Income (from II. 5. above))</td>\r\n    <td>&nbsp;</td>\r\n    <td width=\"5%\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeCrtfdGrp()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>Resource Limit</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtResourceLimitCrtfdGrp()) );
          out.write("</td>\r\n    <td></td>\r\n    <td>Gross Income Ceiling</td>\r\n    <td>&nbsp;</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeCeiling()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td><b>Eligible Based on Resources?</b></td>\r\n    <td><b>");
          out.print( eligibilityDB.getIndEquity() ? ArchitectureConstants.NO : ArchitectureConstants.YES );
          out.write("</b></td>\r\n    <td></td>\r\n    <td><b>");
          out.print( Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdGicSurpDefctCrtfdGrp()) );
          out.write("</b></td>\r\n    <td>&nbsp;</td>\r\n    <td width=\"10%\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGicSurpDefctCrtfdGrp()) );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"3\"></td>\r\n    <td><b>Eligible Based on GIC Test?</b></td>\r\n    <td>&nbsp;</td>\r\n    <td><b>");
          out.print( eligibilityDB.getIndGrossIncCeilingElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"6\">Standard of Need Test</th>\r\n  </tr>\r\n  <tr>\r\n  <td colspan=\"6\">\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n    <tr>\r\n      <td><b>AU Member</b></td>\r\n      <td><b>Relationship</b></td>\r\n      <td><b>Earned Income</b></td>\r\n      <td><b>$90 Deduction</b></td>\r\n      <td><b>Sub Total</b></td>\r\n      <td></td>\r\n    </tr>\r\n");

if (aUMembersList != null && aUMembersList.size() > 0) {
  Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
  while (aUMembersList_it.hasNext()) {
    FcePersonDB aUMember = aUMembersList_it.next();
    String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", aUMember.getCdRelInt());
    if ("".equals(relationDecode)) {
     relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", aUMember.getCdRelInt());
    }

          out.write("\r\n    <tr>\r\n\t  <td>");
          out.print( aUMember.getNmPersonLast() + ", " +  aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle());
          out.write("</td>\r\n\t  <td>");
          out.print( relationDecode );
          out.write("</td>\r\n\t  <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(aUMember.getAmtGrossEarnedIncome()) );
          out.write("</a></td>\r\n\t  <td>");
          out.print( FormattingHelper.formatMoney(aUMember.getAmtStdEarnedIncomeDeduct()) );
          out.write("</td>\r\n\t  <td>");
          out.print( FormattingHelper.formatMoney(aUMember.getAmtCntblIncome()) );
          out.write("</td>\r\n\t  <td></td>\r\n    </tr>\r\n");

  }
} 

          out.write("    \r\n    <tr>\r\n\t\t  <td></td>\r\n\t\t  <td><b>Sub Total</b></td>\r\n\t\t  <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossEarnedCrtfdGrp()) );
          out.write("</td>\r\n\t\t  <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtStdEarnedIncomeDeduct()) );
          out.write("</td>\r\n\t\t  <td><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessStdDeduct()) );
          out.write("</b></td>\r\n    </tr>\r\n  </table>\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n  <td colspan=\"6\">--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td>\r\n  </tr>\r\n  <tr>\r\n  <td colspan=\"6\">\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n  <tr>\r\n      <td width=\"60%\"></td>\r\n      <td></td>\r\n      <td width=\"20%\" colspan=\"3\"><b>Sub Total</b></td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">Earned Income Less Standard Earned Income Deduction(s)(Sub Total from above)</td>\r\n    <td></td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessStdDeduct()) );
          out.write("</td> \r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">Less Child Care (Do not deduct $50 Child Support)</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDependentCareDeduc()) );
          out.write("</a></td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtLessDepCareStdNeed()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">Plus Unearned Income</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtCsupWithUnearnedIncome()) );
          out.write("</a></td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtPlusUnearnedStdNeed()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">Plus Deemed Income (Only Added if Surplus, from I. 14., above)</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemTotal()) );
          out.write("</td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtPlusDeemedStdNeed()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">Less Allocation (from II. 5., above)</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowance()) );
          out.write("</td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncomeStdNeed()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\"><b>Total</b></td>\r\n    <td></td>\r\n    <td width=\"20%\" colspan=\"3\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncomeStdNeed()) );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\"><b>SON</b></td>\r\n    <td></td>\r\n    <td width=\"20%\" colspan=\"3\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtStandardOfNeed()) );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\"><b>");
          out.print( Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdStdTestSurpDefct()) );
          out.write("</b></td>\r\n    <td></td>\r\n    <td width=\"20%\" colspan=\"3\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtSurpDefctStdNeed()) );
          out.write("</b></td>\r\n  </tr>\r\n    </table>\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"6\">Eligibility/Payment Budget</th>\r\n  </tr>\r\n\r\n  <tr>\r\n  <td colspan=\"6\">\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n      <tr>\r\n        <td><b>AU Member</b></td>\r\n        <td><b>1. Earned Income</b></td>\r\n        <td><b>2. Less $90 Deduction</b></td>\r\n        <td><b>3. Less $30</b></td>\r\n        <td><b>4. Less 1/3</b></td>\r\n      </tr>\r\n");

if (aUMembersList != null && aUMembersList.size() > 0) {
  Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
  while (aUMembersList_it.hasNext()) {
    FcePersonDB aUMember = aUMembersList_it.next();

          out.write("      \r\n      <tr>\r\n\t    <td>");
          out.print( aUMember.getNmPersonLast() + ", " +  aUMember.getNmPersonFirst() + " " + aUMember.getNmPersonMiddle());
          out.write("</td>\r\n\t    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(aUMember.getAmtGrossEarnedIncome()) );
          out.write("</a></td>\r\n\t    <td>");
          out.print( FormattingHelper.formatMoney(aUMember.getAmtCntblIncome()) );
          out.write("</td>\r\n\t    <td>");
          out.print( FormattingHelper.formatMoney(aUMember.getAmtCntblIncomeLess30()) );
          out.write("</td>\r\n\t    <td>");
          out.print( FormattingHelper.formatMoney(aUMember.getAmtCntblIncomeLessThird()) );
          out.write("</td>\r\n      </tr>\r\n");

  }
}  

          out.write("    \r\n      <tr>\r\n  \t\t<td><b>Sub Total</b></td>\r\n  \t\t<td></td>\r\n  \t\t<td colspan=\"2\" align=\"center\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessAllDeduct()) );
          out.write("</b></td>\r\n  \t\t<td></td>\r\n      </tr>\r\n  </table>\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n  <td align=\"center\" colspan=\"6\">--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td>\r\n  </tr>\r\n  <tr>\r\n  <td colspan=\"6\">\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n  <tr>\r\n    <td width=\"60%\"></td>\r\n    <td></td>\r\n    <td width=\"20%\" colspan=\"3\"><b>Sub Total</b></td>\r\n  </tr>\r\n  <tr>\r\n      <td width=\"60%\">5. Earned Income Less Earned Income Deduction(s)(Sub Total from above)</td>\r\n      <td></td>\r\n      <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessAllDeduct()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">6. Less Child Care</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDependentCareDeduc()) );
          out.write("</a></td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtLessDepCareElig()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">7. Net Earned Income</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtNetEarnedIncome()) );
          out.write("</td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtNetEarnedIncome()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">8. Plus Unearned Income</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossUnearnedCrtfdGrp()) );
          out.write("</a></td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtPlusUnearnedElig()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">9. Plus Child Support (Less $50)</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtChsupCrtfdGrp()) );
          out.write("</a></td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtPlusChsupCrtfdGrp()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">10. Plus Deemed Income (Only Added if Surplus,from I. 14., above)</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDeemTotal()) );
          out.write("</td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtPlusDeemedElig()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\">11. Less Allocation (from II. 5., above)</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtAllocAllowance()) );
          out.write("</td>\r\n    <td width=\"20%\" colspan=\"3\">");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtLessAllocElig()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\"><b>12. Total Countable Income</b></td>\r\n    <td></td>\r\n    <td width=\"20%\" colspan=\"3\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncome()) );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n      <td width=\"60%\"><b>13. SON</b></td>\r\n      <td></td>\r\n      <td width=\"20%\" colspan=\"3\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtStandardOfNeed()) );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"60%\"><b>14. ");
          out.print( Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdEligSurpDefctCrtfdGrp()) );
          out.write("</b> (line 12 less SON)</td>\r\n    <td></td>\r\n    <td width=\"20%\" colspan=\"3\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtSurpDefctEligCrtfdGrp()) );
          out.write("</b></td>\r\n  </tr>\r\n  </table>\r\n  </td>\r\n  </tr>\r\n</table>\r\n\r\n");

} 
// Only show this section if we're doing a IV-E Budget
else {
  long idChild = eligibilityDB.getIdFcePerson();
  FcePersonDB child = new FcePersonDB();
  if (aUMembersList != null && aUMembersList.size() > 0) {
    Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
    while (aUMembersList_it.hasNext()) {
      child = aUMembersList_it.next();
      if (idChild == child.getIdFcePerson()) {
        break;
      }
    }
  }
  i = 1;
  int j = 5;

          out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">IV-E Reimbursability Worksheet</th>\r\n  </tr>\r\n  <tr>\r\n    <td>Number of People in Assistance Unit</td>\r\n    <td>1</td>\r\n  </tr>\r\n      <tr>\r\n      <th colspan=\"3\" width=\"42%\">Resource Test</th>\r\n      <th colspan=\"3\" width=\"58%\">Gross Income Ceiling Test</th>\r\n    </tr>\r\n    <tr>\r\n      <td>Total Countable Resources for Child</td>\r\n      <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                                    tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtCtnblResourceChild()) );
          out.write("</a></td>\r\n      <td></td>\r\n      <td>Gross Income for Child</td>\r\n      <td>&nbsp;</td>\r\n      <td width=\"5%\"><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtTotalGrossIncomeChild()) );
          out.write("</a></td>\r\n    </tr>\r\n    <tr>\r\n      <td>Resource Limit</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtResourceLimitChild()) );
          out.write("</td>\r\n      <td></td>\r\n      <td>Gross Income Ceiling</td>\r\n      <td>&nbsp;</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossIncomeCeilingChild()) );
          out.write("</td>\r\n    </tr>\r\n    <tr>\r\n      <td><b>Eligible Based on Resources?</b></td>\r\n      <td><b>");
          out.print( eligibilityDB.getIndCtnblResChildElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO );
          out.write("</b></td>\r\n      <td></td>\r\n      <td><b>");
          out.print( Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdGicSurpDefctChild()) );
          out.write("</b></td>\r\n      <td>&nbsp;</td>\r\n      <td width=\"10%\"><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGicSurpDefctChild()) );
          out.write("</b></td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"3\"></td>\r\n      <td><b>Eligible Based on GIC Test?</b></td>\r\n      <td>&nbsp;</td>\r\n      <td><b>");
          out.print( eligibilityDB.getIndGrossIncChildElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"6\">Reimbursability/Payment Budget</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"6\"><table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n  <tr>\r\n    <td></td>\r\n    <td></td>\r\n    <td><b>Sub Total</b></td>\r\n  </tr>\r\n  <tr>\r\n    <td>1. Total Monthly Earned Income for Child</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossEarnedChild()) );
          out.write("</a></td>\r\n    <td></td>\r\n  </tr>\r\n  <tr>\r\n    <td>2. Less Standard Deduction $90</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtStdEarnedIncomeDeduct()) );
          out.write("</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtEarnedLessStdDeduct()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>3. Less $30</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(child.getAmtCntblIncome30()) );
          out.write("</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(child.getAmtCntblIncomeLess30()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>4. Less 1/3</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(child.getAmtCntblIncomeThird()) );
          out.write("</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(child.getAmtCntblIncomeLessThird()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n      <td>5. Less Dependent Care Deduction for Child</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtDepCareDeducChild()) );
          out.write("</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtLessDepCareElig()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>6. Net Earned Income</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtNetEarnedIncomeChild()) );
          out.write("\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtNetEarnedIncomeChild()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>7. Plus Unearned Income</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                                    tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtGrossUnEarnedChild()) );
          out.write("</a></td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtPlusUnearnedElig()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>8. Plus Child Support(Less $50)</td>\r\n    <td><a href='javascript:navigateTo(\"/fce/IncomeExpenditures/displayIncomeExpenditures\")'\r\n                         tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtChsupChild()) );
          out.write("</a></td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtPlusChsupChild()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td><b>9. Total Countable Income</b></td>\r\n    <td><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncome()) );
          out.write("</b></td>\r\n    <td><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtCountableIncome()) );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n      <td><b>10. SON</b></td>\r\n      <td><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtStdOfNeedChild()) );
          out.write("</b></td>\r\n      <td></td>\r\n  </tr>\r\n  <tr>\r\n    <td><b>11. ");
          out.print( Lookup.simpleDecodeSafe("CSPLSDEF", eligibilityDB.getCdEligSurpDefctChild()) );
          out.write("</b>(line 9 less SON)</td>\r\n    <td><b>");
          out.print( FormattingHelper.formatMoney(eligibilityDB.getAmtSurpDefctEligChild()) );
          out.write("</b></td>\r\n    <td></td>\r\n  </tr>\r\n  </table></td>\r\n  </tr>\r\n</table>\r\n");

}

          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("checklist");
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded(true);
          _jspx_th_impact_ExpandableSectionTag_0.setLabel( (CodesTables.CFCEAPRE_R.equals(cdApplication) ? "Reimbursability Checklist" : "Foster Care Eligibility Checklist") );
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th></th>\r\n    <th>");
              out.print( (CodesTables.CFCEAPRE_R.equals(cdApplication) ? "IV-E Reimbursability" : "AFDC") );
              out.write(" Requirements</th>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td><a href='javascript:navigateTo(\"/fce/AgeCitizenship/displayAgeCitizenship\")'\r\n           tabIndex=\"");
              out.print( tabIndex++ );
              out.write('"');
              out.write('>');
              out.print( (eligibilityDB.getIndChildUnder18()) ? "Yes" : "No" );
              out.write("</a></td>\r\n\r\n    <td>Was the child under age 18?</td>\r\n  </tr>\r\n");

if (EligibilityDeterminationConversation.AFDC_BUDGETING.equals(budgetingProcess)) {

              out.write("  \r\n  <tr class=\"odd\">\r\n    <td><a href='javascript:navigateTo(\"/fce/AgeCitizenship/displayAgeCitizenship\")'\r\n           tabIndex=\"");
              out.print( tabIndex++ );
              out.write('"');
              out.write('>');
              out.print( (eligibilityDB.getIndChildQualifiedCitizen()) ? "Yes" : "No" );
              out.write("</a></td>\r\n\r\n    <td>Was the child a U.S. Citizen, Permanent Resident/Refugee, Qualified Alien or was Evaluative Conclusion used to verify the child's Citizenship status?</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td><a href='javascript:navigateTo(\"/fce/DomicileDeprivation/displayDomicile\")'\r\n           tabIndex=\"");
              out.print( tabIndex++ );
              out.write('"');
              out.write('>');
              out.print( (eligibilityDB.getIndParentalDeprivation()) ? "Yes" : "No" );
              out.write("</a></td>\r\n\r\n    <td>Did Parental Deprivation exist in the removal home?</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td><a href='javascript:navigateTo(\"/fce/DomicileDeprivation/displayDomicile\")'\r\n           tabIndex=\"");
              out.print( tabIndex++ );
              out.write('"');
              out.write('>');
              out.print( (Boolean.FALSE.equals(eligibilityDB.getIndChildLivingPrnt6MnthsObject())) ? "No" : "Yes" );
              out.write("</a></td>\r\n\r\n    <td>Was the child physically removed by court order from a Parent OR did the child live with a Parent at any time during the six months before the court proceedings were initiated?</td>\r\n  </tr>\r\n");

}

              out.write("  \r\n</table>\r\n");

if (EligibilityDeterminationConversation.AFDC_BUDGETING.equals(budgetingProcess)) {

              out.write("\r\n<br>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">Judicial Requirements</th>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n");
 
if (eligibilityDB.getIndRemovalChildOrderedObject()) {

              out.write("  \r\n    <td>Date of First Judicial Determination containing the \"contrary to the welfare\" or \"best interest\" language</td>\r\n    <td>");
              out.print(  eligibilityDB.getDtRemovalChildOrderedString() );
              out.write("</td>\r\n");

} else { 
              out.write("  \r\n    <td colspan=\"2\">The first judicial determination removing the child from the home did not contain the \"contrary to the welfare\" or \"best interest\" language</td>\r\n");

} 
              out.write(" \r\n  </tr>  \r\n\r\n  <tr class=\"odd\">\r\n");
 
if (eligibilityDB.getIndRsnblEffortPrvtRemovalObject()) {

              out.write("   \r\n    <td>Date of Court Order of a judicial determination that \"reasonable efforts were made to prevent removal\" or that \"reasonable efforts were not required to prevent removal\" within 60 days of the child's court-ordered removal from the home</td>\r\n    <td>");
              out.print(  eligibilityDB.getDtRsnblEffortPreventRemString() );
              out.write("</td>\r\n");

} else { 
              out.write("\r\n    <td colspan=\"2\">There was not a judicial determination that \"reasonable efforts were made to prevent removal\" or that \"reasonable efforts were not required to prevent removal\" within 60 days of the child's court-ordered removal from the home</td>      \r\n");

} 
              out.write("   \r\n  </tr>\r\n  <tr class=\"odd\">\r\n");
 
if (eligibilityDB.getIndPrsManagingCvsObject()) {

              out.write("  \r\n     <td colspan=\"2\">A court order did give DFCS responsibility for the child's placement and care, or custody of the child</td>\r\n");

} else { 
              out.write("\r\n     <td colspan=\"2\">A court order did not give DFCS responsibility for the child's placement and care, or custody of the child</td>\r\n");

} 
              out.write("        \r\n  </tr>\r\n</table>\r\n");

}
 
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n<hr>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td align=\"right\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmEDW");
          _jspx_th_impact_ButtonTag_0.setAction("/fce/EligibilityDetermination/saveEligibilityDetermination");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnDetermineEligibility");
          _jspx_th_impact_ButtonTag_1.setImg("btnDetermineEligibility");
          _jspx_th_impact_ButtonTag_1.setForm("frmEDW");
          _jspx_th_impact_ButtonTag_1.setAction("/fce/EligibilityDetermination/determineEligibility");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n");
  
  if ("APRV".equals(eligibilityDB.getCdEventStatus()) == false)
{

          out.write("\r\n\r\n    <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnContinue");
          _jspx_th_impact_ButtonTag_2.setCssClass("md");
          _jspx_th_impact_ButtonTag_2.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_2.setAction("/fce/EligibilityDetermination/confirmYes");
          _jspx_th_impact_ButtonTag_2.setFunction("return yes()");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_2.setForm("frmEDW");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  \r\n");

}

          out.write("\r\n  </tr>\r\n</table>\r\n\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script language=\"javascript\">\r\nexpandCollapsed('expandedchecklist', 'collapsedchecklist');\r\n</script>\r\n");
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
