package org.apache.jsp.grnds_002ddocs.serviceDelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class FamilyPlanItemGoals_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*--------------------------------------------------------------------------------
//*  JSP Name:     Family Plan Item Goals
//*  Created by:   Jason Rios
//*  Date Created: 02/05/03
//*
//*  Description:
//*  This JSP displays the Family Plan Item Goals for each area of concern.
//*
//*  Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*
//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
FamilyPlanValueBean familyPlanBean = null;
FamilyPlanItemValueBean familyPlanItemBean = null;
Map goalsToAreaOfConcernLookup = null;

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

familyPlanBean = ( FamilyPlanValueBean )state.getAttribute( "familyPlanBean", request );
familyPlanItemBean = ( FamilyPlanItemValueBean )state.getAttribute( "familyPlanItemBean", request );

goalsToAreaOfConcernLookup = ( Map )state.getAttribute( "goalsToAreaOfConcernLookup", request );

//*********************
//*** SET PAGE MODE ***
//*********************
String pageMode = PageModeConstants.VIEW;
if ( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}

      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n</script>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      <a tabindex=\"");
      out.print( tabIndex++ );
      out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n      <a tabindex=\"");
      out.print( tabIndex++ );
      out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");

//**********************************************
//**** FORM (FAMILY PLAN GOALS) STARTS HERE ****
//**********************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFamilyPlanGoals");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/serviceDelivery/FamilyPlan/displayFamilyPlanGoals");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  ");

  // Iterate through the family plan items in the family plan bean to get
  // each area of concern. For each area of concern, display the area of
  // concern description, then display the each of the goals that apply.
  loopCounter = 0;
  Collection familyPlanItems = familyPlanBean.getFamilyPlanItemList();
  Iterator itemsIter = familyPlanItems.iterator();
  while ( itemsIter.hasNext() )
  {
    FamilyPlanItemValueBean itemBean = ( FamilyPlanItemValueBean )itemsIter.next();
    
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName( itemBean.getAreaOfConcernCode() );
          _jspx_th_impact_ExpandableSectionTag_0.setLabel( itemBean.getAreaOfConcernText() );
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n          <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"subDetail\">\r\n          ");

          // Display each goal.
          List goalsVector = ( List )goalsToAreaOfConcernLookup.get( itemBean.getAreaOfConcernCode() );
          Iterator goalsIter = goalsVector.iterator();
          while ( goalsIter.hasNext() )
          {
            String goalCode = ( String )goalsIter.next();
            String fieldName = "cbxGoals_" + loopCounter;
            String fieldValue = Lookup.simpleDecodeSafe( "CSPGOLLD", goalCode );
            
              out.write("\r\n            <tr>\r\n              <td valign=\"top\">\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_0.setLabel("");
              _jspx_th_impact_validateInput_0.setName( fieldName );
              _jspx_th_impact_validateInput_0.setType("checkbox");
              _jspx_th_impact_validateInput_0.setValue( fieldValue );
              _jspx_th_impact_validateInput_0.setCssClass("formInput");
              _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
              if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              </td>\r\n              <td valign=\"top\">\r\n                ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_0.setName("txtGoal");
              _jspx_th_impact_validateDisplayOnlyField_0.setLabel("");
              _jspx_th_impact_validateDisplayOnlyField_0.setValue( fieldValue );
              int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              </td>\r\n            </tr>\r\n            ");

            loopCounter++;
          } // end while ( goalsIter.hasNext() )
          
              out.write("\r\n          </table>\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  ");

  } // end while ( areaOfConcernIter.hasNext() )
  
          out.write("\r\n</table>\r\n\r\n");

//*****************
//**** BUTTONS ****
//*****************

          out.write("\r\n<hr>\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnContinue");
          _jspx_th_impact_ButtonTag_0.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmFamilyPlanGoals");
          _jspx_th_impact_ButtonTag_0.setAction("/serviceDelivery/FamilyPlan/appendFamilyPlanGoals");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
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

//********************************************
//**** FORM (FAMILY PLAN GOALS) ENDS HERE ****
//********************************************

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
}
