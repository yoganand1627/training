package org.apache.jsp.grnds_002ddocs.serviceDelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class FamilyPlanLegacyDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
//*   JSP Name:     Family Plan Legacy Detail
//*  Created by:   Jason Rios
//*  Date Created: 02/05/03
//*
//*  Description:
//*  This JSP displays the Family Plan Details.
//*
//*   Change History:
//*   Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*
//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
Iterator iter = null;
boolean bLegacyData = false;
List legacyEventsVector = null;

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
legacyEventsVector = ( List )state.getAttribute( "legacyEventsVector", request );

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

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

//***************
//**** FORMS ****
//***************

      out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><th colspan=\"3\">Family Plan Detail</th></tr>\r\n  <tr>\r\n    <td>\r\n      ");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FP_LEGACY_DATA ) );
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><th>Forms</th></tr>\r\n  <tr>  \r\n    <td>\r\n      ");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n      ");

      // Display the documents associated with each of the legacy events
      // that were queried from the database.
      //
      // NOTE: The document architecture creates a separate form for each
      // document in the list. Since some documents in the list are of the
      // same docType, and since every form on the page should have a unique
      // name, the value for the "docType" attribute is created as a
      // concatenation of the actual docType of the document, then an
      // underscore (_), then the loopCounter.
      if ( legacyEventsVector != null )
      {
        iter = legacyEventsVector.iterator();
        while ( iter.hasNext() )
        {
          EventValueBean eventBean = ( EventValueBean )iter.next();
          String documentDisplayName = eventBean.getEventDescription() + " - " + FormattingHelper.formatDate( eventBean.getDateEventOccurred() );
          String documentType = null;
          String documentFormName = null;

          if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_FAMILY_ASSMT ) ||
               eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_FAMILY_ASSMT ) ||
               eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FSU_FAMILY_ASSMT ) )
          {
            documentType = "cfsd0100";
            documentFormName = "cfsd0100_" + loopCounter++;
          }
          else if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_3_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_6_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_SPEC_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_3_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_6_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_SPEC_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FSU_6_MONTH_EVAL ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FSU_SPEC_MONTH_EVAL ) )
          {
            documentType = "cfsd0400";
            documentFormName = "cfsd0400_" + loopCounter++;
          }
          else if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.CD_TASK_FRE_FAM_PLAN ) ||
                    eventBean.getEventTaskCode().equals( FamilyPlanValueBean.CD_TASK_FSU_FAM_PLAN ) )
          {
            documentType = "cfsd0500";
            documentFormName = "cfsd0500_" + loopCounter++;
          }
          
          out.write("\r\n          ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName( documentDisplayName );
          _jspx_th_impact_document_0.setDocType( documentType );
          _jspx_th_impact_document_0.setDocExists(true);
          _jspx_th_impact_document_0.setName( documentFormName );
          _jspx_th_impact_document_0.setProtectDocument(true);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pEvent");
              _jspx_th_impact_documentParameter_0.setValue( FormattingHelper.formatInt( eventBean.getEventId() ) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( FormattingHelper.formatInt( eventBean.getStageId() ) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");

          // The Family Assessment Analysis document is available only if the
          // task code is for a "Family Assessment".
          if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_FAMILY_ASSMT ) ||
               eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FRE_FAMILY_ASSMT ) ||
               eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FSU_FAMILY_ASSMT ) )
          {
            documentDisplayName = eventBean.getEventDescription() + " Analysis - " + FormattingHelper.formatDate( eventBean.getDateEventOccurred() );
            documentType = "analysis";
            documentFormName = "analysis_" + loopCounter++;
            
          out.write("\r\n            ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_1.setDisplayName( documentDisplayName );
          _jspx_th_impact_document_1.setDocType( documentType );
          _jspx_th_impact_document_1.setDocExists(true);
          _jspx_th_impact_document_1.setProtectDocument(true);
          _jspx_th_impact_document_1.setName( documentFormName );
          int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
          if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n              ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_2.setName("sEvent");
              _jspx_th_impact_documentParameter_2.setValue( FormattingHelper.formatInt( eventBean.getEventId() ) );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n              ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_3.setName("sCase");
              _jspx_th_impact_documentParameter_3.setValue( FormattingHelper.formatInt( eventBean.getCaseId() ) );
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n              ");
              if (_jspx_meth_impact_documentParameter_4(_jspx_th_impact_document_1, _jspx_page_context))
                return;
              out.write("\r\n            ");
              int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");

          } // end if ( eventBean.getEventTaskCode().equals( FamilyPlanValueBean.LEGACY_CD_TASK_FPR_FAMILY_ASSMT ) ||...
        } // end while ( iter.hasNext() )
      } // end if ( legacyEventsVector != null )
      
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>");
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

  private boolean _jspx_meth_impact_documentParameter_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_document_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:documentParameter
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
    _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
    _jspx_th_impact_documentParameter_4.setName("sTimestamp");
    _jspx_th_impact_documentParameter_4.setValue("");
    int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
    if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
