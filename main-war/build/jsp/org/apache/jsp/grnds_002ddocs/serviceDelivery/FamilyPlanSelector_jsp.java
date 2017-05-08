package org.apache.jsp.grnds_002ddocs.serviceDelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class FamilyPlanSelector_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*--------------------------------------------------------------------------
//*  JSP Name:     Family Plan Selector
//*  Created by:   Jason Rios
//*  Date Created: 06/04/03
//*
//*  Description:
//*  This JSP displays the list of approved Family Plans.
//*
//*  Change History:
//*  Date      User         Description
//*  --------  -----------  -------------------------------------------------
//*  06/23/04  RIOSJA       SIR 19002 - If the worker attempts to create an
//*                         evaluation in an older stage for a family plan
//*                         created in a newer stage, display a confirmation
//*                         message and notify them.
//*--------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
ArrayList approvedFamilyPlans = null;
FamilyPlanValueBean familyPlanBean = null;
/* RIOSJA, SIR 19002 */
CaseUtility.Stage currentStage = null;

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

if ( state.getAttribute( "approvedFamilyPlans", request ) != null )
{
  approvedFamilyPlans = ( ArrayList )state.getAttribute( "approvedFamilyPlans", request );
}

/* RIOSJA, SIR 19002 */
if ( state.getAttribute( "currentStage", request ) != null )
{
  currentStage = (CaseUtility.Stage)state.getAttribute( "currentStage", request );
}

String pageMode = PageModeConstants.VIEW;
if ( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}

      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n/*\r\n** RIOSJA, SIR 19002 - If the worker attempts to create an evaluation\r\n** in an older stage for a family plan created in a newer stage, display\r\n** a confirmation message and notify them.\r\n*/\r\nfunction selectPlan( selectedFamilyPlanEventId, bPlanIsFromNewerStage )\r\n{\r\n  if( bPlanIsFromNewerStage )\r\n  {\r\n    if( confirm(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FP_IN_NEWER_STAGE ) );
      out.write("\") )\r\n    {\r\n      document.frmFamilyPlanList.selectedFamilyPlanEventId.value = selectedFamilyPlanEventId;\r\n      setState('frmFamilyPlanList');\r\n      setValidationUrl('frmFamilyPlanList', '/serviceDelivery/FamilyPlan/displayFamilyPlan');\r\n      document.frmFamilyPlanList.submit();\r\n    }\r\n    return;\r\n  }\r\n  else\r\n  {\r\n    document.frmFamilyPlanList.selectedFamilyPlanEventId.value = selectedFamilyPlanEventId;\r\n    setState('frmFamilyPlanList');\r\n    setValidationUrl('frmFamilyPlanList', '/serviceDelivery/FamilyPlan/displayFamilyPlan');\r\n    document.frmFamilyPlanList.submit();\r\n  }\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFamilyPlanList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/serviceDelivery/FamilyPlan/listFamilyPlansForEval");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr class=\"formInstruct\">\r\n    <td>\r\n      Select the plan you would like to evaluate.\r\n    </td>\r\n    <td>\r\n      <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information  --></div></div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<div id=\"scroll\" style=\"width:767px; height:250px; overflow:auto\" class=\"tableborderList\">\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"900\">\r\n    <tr class=\"thList\">\r\n      <td nowrap width=\"10%\">Date Entered</td>\r\n      <td nowrap width=\"8%\">Status</td>\r\n      <td nowrap width=\"10%\">Type</td>\r\n      <td nowrap width=\"35%\">Description</td>\r\n      <td nowrap width=\"20%\">Entered By</td>\r\n      <td nowrap width=\"10%\">Event ID</td>\r\n    </tr>\r\n    ");

    // If there are approved family plans for the stage, list them. Otherwise,
    // display a "No records found" message.
    if ( approvedFamilyPlans != null &&
         approvedFamilyPlans.size() > 0 )
    {
      Iterator iter = approvedFamilyPlans.iterator();
      while ( iter.hasNext() )
      {
        familyPlanBean = ( FamilyPlanValueBean )iter.next();
        EventValueBean eventBean = familyPlanBean.getFamilyPlanEvent();
        
          out.write("\r\n        <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCounter + 1 ) );
          out.write("\">\r\n          <td>");
          out.print( FormattingHelper.formatDate( eventBean.getDateEventOccurred() ) );
          out.write("</td>\r\n          <td>");
          out.print( eventBean.getEventStatusCode() );
          out.write("</td>\r\n          ");

          // RIOSJA, SIR 19002 - If the worker attempts to create an
          // evaluation in an older stage for a family plan created in a
          // newer stage, display a confirmation message and notify them.
          String bPlanIsFromNewerStage = "false";
          if( currentStage.getDtStart() != null &&
              familyPlanBean.getDateStageStarted() != null &&
              DateHelper.isBefore( currentStage.getDtStart(), familyPlanBean.getDateStageStarted() ) )
          {
            bPlanIsFromNewerStage = "true";
          }
          
          out.write("\r\n          <td><a href=\"JavaScript:selectPlan(");
          out.print( eventBean.getEventId() );
          out.write(',');
          out.write(' ');
          out.print(bPlanIsFromNewerStage);
          out.write(");\">Plan</a></td>\r\n          <td>");
          out.print( eventBean.getEventDescription() );
          out.write("</td>\r\n          <td>");
          out.print( eventBean.getCreatorsLastName() );
          out.write(",&nbsp;");
          out.print( eventBean.getCreatorsFirstName() );
          out.write("</td>\r\n          <td>");
          out.print( eventBean.getEventId() );
          out.write("</td>\r\n        </tr>\r\n      ");

      loopCounter++;
      } // end while ( iter.hasNext )
    }
    else
    {
          out.write("\r\n      <tr><td colspan=\"8\">");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("</td></tr>\r\n    ");

    } // end if ( approvedFamilyPlans != null &&...
    
          out.write("\r\n  </table>\r\n</div>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("selectedFamilyPlanEventId");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
