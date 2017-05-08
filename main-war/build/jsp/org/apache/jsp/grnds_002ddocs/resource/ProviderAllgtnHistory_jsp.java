package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cdisp;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cscnotrn;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cdispstn;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Ccrskfnd;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ProviderAllegation;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckPersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProviderAllegationHistorySO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

public final class ProviderAllgtnHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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


   /**
       * Provider Allegation History
       * Author: Corey Harden
       * Date: 06/06/2011
       * 
       * 					Change History
       *
       *   Date          User				              Description
       * --------  ----------------  --------------------------------------------------
       *
       *
       *
       *
   */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // get the state map
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  // retrieve the Service Out (SO) object from the request
  ProviderAllegationHistorySO providerAllegationHistorySO = (ProviderAllegationHistorySO) request.getAttribute("providerAllegationHistorySO");
  
  // get list of allegations on provider
  @SuppressWarnings("unchecked")
  List<ProviderAllegation> providerAllegationList = providerAllegationHistorySO.getProviderAllegList();

  // get the user profile for display rule logic
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // create date for auto population of date of request fields
  String today = DateHelper.toString(new Date(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING));

  // get the primary key of the stage
  int ulIdStage = GlobalData.getUlIdStage(request);

  // use stage id to determine whether the current user has access to the stage
  boolean hasStageAccess = CaseUtility.hasStageAccess(user.getUserID(), ulIdStage);

  // create page mode variable based on stage access
  String pageMode = hasStageAccess ? PageModeConstants.MODIFY : PageModeConstants.INQUIRE;

      out.write("\r\n\r\n\r\n\r\n<!-- JAVASCRIPT SECTION -->\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\t\r\n\t/**\r\n\t* This function adds data to hidden variables and submits the summary list form\r\n\t* @param personId - the id of the person\r\n\t* @param name - the name of the person\r\n\t*/\r\n\tfunction displayIntakeActions(idStage){\r\n\t\tdocument.getElementById('stageId').value = idStage;\r\n\t\tsubmitValidateForm('frmProviderAllgtnHistory', '/intake/IntakeActions/displayIntakeActions');\r\n\t}\r\n\t\r\n\t\r\n\tfunction displayCpsInvCnclsn(idStage, nmCase, idCase){\r\n\t\tdocument.getElementById('invStageId').value = idStage;\r\n\t\tdocument.getElementById('nmCase').value = nmCase;\r\n\t\tdocument.getElementById('idCase').value = idCase;\r\n\t\tsubmitValidateForm('frmProviderAllgtnHistory', '/resource/ProviderAllgtnHistory/displayCpsInvCnclsn');\r\n\t}\r\n\t\t\r\n\t\r\n</script>\r\n<!-- END JAVASCRIPT SECTION -->\r\n");
      out.write("\r\n\r\n\r\n<!-- ERROR DISPLAY AREA -->\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n<!-- END ERROR DISPLAY AREA -->\r\n\r\n\r\n\r\n\r\n<!-- ------------------------------------------------------BEGIN RECORDS CHECK SUMMARY VIEW---------------------------------------------- -->\r\n\r\n<!-- RECORDS CHECK LIST AREA -->\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmProviderAllgtnHistory");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ProviderAllgtnHistory/displayProviderAllgtnHistory");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.ProviderAllgnHistoryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode("");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  \r\n  \r\n\r\n    <div style=\"width: 100%; border-top: solid black 1px\">\r\n    \t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" style=\"width: 100%; height: 40px; position: relative; top: 20px\">\r\n    \t\t<tr>\r\n    \t\t\t<th class=\"thList\">\r\n\t\t\t\t\tIntake ID\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tIntake Date\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tIntake Disposition\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tScreen Out Reason\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tAlleged Maltreatment in Care?\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tInv Maltreatment Finding\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tOverall Risk Finding\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tInv Maltreatment in Care?\r\n\t\t\t\t</th>\r\n    \t\t</tr>\r\n    \t");

    	if(!providerAllegationHistorySO.isAllegationAvail()) {
    	
          out.write("\r\n    \t<tr>\r\n    \t\t<td colspan=\"8\"align=\"left\" >");
          out.print( MessageLookup.getMessageByNumber(Messages.MSG_INT_STAGE_NOT_FOUND) );
          out.write("</td>\r\n    \t</tr>\r\n    \t");

    	}else{
    	    //create counter to alternate row coloring
    	    int rowCount = 1;
    	    
    	    //loop thru list to write out allegation info
    	  	for (ProviderAllegation alleg : providerAllegationList) {
    	  		String strIntStage = alleg.getIdStage() == 0 ? "" : String.valueOf(alleg.getIdStage()); 
    	
          out.write("\r\n    \t<!-- DISPLAY ALL PROVIDER ALLEGATIONS -->\r\n    \t\t<tr class=");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write(">\r\n    \t\t\t<td><a href=\"javascript: displayIntakeActions('");
          out.print( alleg.getIdStage() );
          out.write("')\">");
          out.print( strIntStage );
          out.write("</a></td>\r\n    \t\t\t<td>");
          out.print( DateHelper.toString(alleg.getDateOfCall(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) );
          out.write("</td>\r\n    \t\t\t<td>");
          out.print( alleg.getDisposition() != null ? Lookup.simpleDecode(Cdisp.CDISP, alleg.getDisposition()) : "" );
          out.write("</td>\r\n    \t\t\t<td>");
          out.print( alleg.getScreenOut() != null ? Lookup.simpleDecode(Cscnotrn.CSCNOTRN, alleg.getScreenOut()) : "" );
          out.write("</td>\r\n    \t\t\t<td>");
          out.print( alleg.getIsMic() != null ? alleg.getIsMic() : "" );
          out.write("</td>\r\n    \t\t\t<td><a href=\"javascript: displayCpsInvCnclsn('");
          out.print( alleg.getInvIdStage() );
          out.write("', '");
          out.print( alleg.getNmCase() );
          out.write("', '");
          out.print( alleg.getIdCase() );
          out.write("')\">");
          out.print( alleg.getOverallInvDisposition() != null ? Lookup.simpleDecode(Cdispstn.CDISPSTN, alleg.getOverallInvDisposition()) : "" );
          out.write("</a></td>\r\n    \t\t\t<td>");
          out.print( alleg.getConclusionRiskFnd() != null ? Lookup.simpleDecode(Ccrskfnd.CCRSKFND, alleg.getConclusionRiskFnd()) : "" );
          out.write("</td>\r\n    \t\t\t<td>");
          out.print( alleg.getInvMaltreatment() != null ? alleg.getInvMaltreatment() : "" );
          out.write("</td>\r\n    \t\t</tr>\r\n    \t<!-- END DISPLAY ALL PROVIDER ALLEGATIONS -->\r\n    \t");

    			rowCount++;
    	      } 
    	 }
    	
          out.write("\r\n    \t</table>\r\n    </div>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setId("stageId");
    _jspx_th_impact_validateInput_0.setName("stageId");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setId("invStageId");
    _jspx_th_impact_validateInput_1.setName("invStageId");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_2.setId("nmCase");
    _jspx_th_impact_validateInput_2.setName("nmCase");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_3.setId("idCase");
    _jspx_th_impact_validateInput_3.setName("idCase");
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
    _jspx_th_impact_validateInput_4.setId("displayIntakeActionsFAHomeSearch");
    _jspx_th_impact_validateInput_4.setName("displayIntakeActionsFAHomeSearch");
    _jspx_th_impact_validateInput_4.setValue("Y");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
