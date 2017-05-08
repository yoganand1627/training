package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact;
import gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListCustomValidation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class PersonList_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Person List JSP
//*  Created by:   Jenn Casdorph
//*  Date Created: 12/06/02
//*
//*  Description:
//*   The Person List page is a navigational tool used to
//*   allow the worker to select a person for which he/she
//*   is recording or viewing information. It provides a list
//*   of individuals associated with a case or stage which will
//*   include principals only, collaterals only, or all persons
//*   associated with a case or stage depending on the context
//*   in which the user calls the window. There are many
//*   different ways into Person List and they will be split
//*   into two seperate paths depending on whether or not
//*   the invoking window needs access to Person Detail,
//*   Person Search, or to select an ID Person to
//*   be returned to the invoking page.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/02/03  GRIMSHAN          SIR # 17067 Created a personListPageMode variable to
//**                              be passed into the pageMode piece of the form.
//**                              This variable is set to the App Mode in all cases except
//**                              when the page is in a pull back status.
//**                              When it is in pull back status, this variable
//**                              will always be set to Edit.  This was done because the
//**                              Person List page can be accessed for pulling back when
//**                              the stage is closed (app mode is view)
//**  08/12/03  dickmaec          SIR 19455 -- If there is a blank value in the SzNmPersonFull() field
//**                              a line will display for the user to click on.
//**  10/28/04  CORLEYAN          SIR 22566 - Make the width of the list box 100% to eliminate
//**                              scrolling if it is not needed.
//**  07/10/05  PINKSTBA          SIR 23727 MPS Phase II : Radio Buttons, Add Button, and
//**                              Search Button are hidden using <impact:ifServerImpact> tag.-
//**  07/24/05  brauchs            Adjusted tables for SIR 23639 - Use full screen width for MPS
//**  09/23/05  douglacs          SIR 23550 & 23982 - added indicators to show if person
//**                              characteristics and race/ethnicity are entered.
//**  12/04/08  arege             STGAP00010668 Modified code so that Special Rel field gets populated if 
//**                              there is an entry for Special Relationship field on the Person Detail page.


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

/*  GET OBJECTS FROM REQUEST AND PERFORM NULL CATCH  */
  CINV01SO cinv01so = (CINV01SO)state.getAttribute("CINV01SO", request);

  ROWCINV01SOG00_ARRAY cinv01Array = new ROWCINV01SOG00_ARRAY();

  if ( cinv01so == null )
  {
    cinv01so = new CINV01SO();
  }
  if ( cinv01so.getROWCINV01SOG00_ARRAY() != null)
  {
   cinv01Array = cinv01so.getROWCINV01SOG00_ARRAY();
  }
  else
  {
    cinv01Array = new ROWCINV01SOG00_ARRAY();
  }
/**
 *  Page Mode Logic
 *
 *   This page will be passed one of four page modes:
 *   1.  SELECT (S)
 *   2.  CLLTRL_ONLY (C)
 *   3.  PRINC_ONLY (P)
 *   4.  ALLEG_PERP_ONLY (Z)
 *
 *   These page modes are used to determine what buttons should show up.
 *   Application mode will be used to determine overall page mode of the page.
 */

  String pageMode = PageModeConstants.EDIT;

  if (PageMode.getPageMode(request) != null )
  {
    pageMode = PageMode.getPageMode(request);
  }

  // SIR 17067 GRIMSHAN -- Initialize personListPageMode and set it to
  // App Mode
  String personListPageMode = GlobalData.getAppMode( request );

  /**
   *  If the page mode has been passed in as a "pullback" page mode, hide the
   *  Person Hyperlink and the Search and Add pushbuttons, otherwise hide the continue
   *  button
   */
  boolean disablePersonNameHL = false;
  String disableSearchAndAddPB = "false";
  String disableContinuePB = "false";
  String stage = "";
  if (GlobalData.getSzCdStage( request ) != null)
  {
    stage = GlobalData.getSzCdStage( request );
  }

  if ( pageMode.equals(PersonListConversation.PAGE_MODE_SELECT) ||
       pageMode.equals(PersonListConversation.PAGE_MODE_CLLTRL_ONLY) ||
       pageMode.equals(PersonListConversation.PAGE_MODE_PRINC_ONLY) ||
       pageMode.equals(PersonListConversation.PAGE_MODE_ALLEG_PERP_ONLY) )
  {
    // SIR 17067 GRIMSHAN -- set personListPageMode to Modify since it should
    // always be in modify when accessed as a pullback
    personListPageMode = PageModeConstants.MODIFY;
    disablePersonNameHL = true;
    disableSearchAndAddPB = "true";
  }
  else
  {
    disableContinuePB = "true";
  }

/* DECLARE VARIABLES AND ATTACH CODES TABLES */
  int tabIndex = 1;
  int loopCount = 0;

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n//  This function is called when the user clicks a hyperlink in the list.\r\nfunction personListHyperlink (index)\r\n{\r\n  frmPersonList.hdnPersonLoopCount.value = index;\r\n}\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPersonList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonList/displayPersonList");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.PersonListCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( personListPageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
 /* Changed to 100% width for SIR 23639 */  
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/person/PersonList/displayPersonList");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n       <div id=\"scrollBar2\" style=\"height:210px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n           <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n                    <tr>\r\n                    <th class=\"thList\">&nbsp;</th>\r\n                    <th class=\"thList\">Name</th>\r\n                    <th class=\"thList\">Merge</th>\r\n                    <th class=\"thList\">Search</th>\r\n                    <th class=\"thList\">Age</th>\r\n                    <th class=\"thList\">Gender</th>\r\n                    <th class=\"thList\">Type</th>\r\n                    <th class=\"thList\">Role</th>\r\n                    <th class=\"thList\">Rel/Int</th>\r\n                    <th class=\"thList\">Special Rel</th>\r\n                    <th class=\"thList\">Person ID</th>                    \r\n                  </tr>\r\n");

                    loopCount = 0;
                    ROWCINV01SOG00 personListRow = null;
                    Enumeration personListEnum = cinv01Array.enumerateROWCINV01SOG00();
                    if ( personListEnum == null || !(personListEnum.hasMoreElements() ) )
                    {

              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"14\">\r\n                           ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");

                   }
                   else
                   {
                     while( personListEnum.hasMoreElements() )
                     {

                        personListRow = (ROWCINV01SOG00) personListEnum.nextElement();
                        String radioId = "rbPersonList_" + loopCount;

              out.write("\r\n                        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n\r\n              <!-- radio button not needed for Mobile -->\r\n               ");
              //  impact:ifServerImpact
              gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
              _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifServerImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
              if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\r\n                            <td>");
                //  impact:validateInput
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_0);
                _jspx_th_impact_validateInput_0.setType("radio");
                _jspx_th_impact_validateInput_0.setId( radioId );
                _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
                _jspx_th_impact_validateInput_0.setName("rbPersonList_CLEAN");
                _jspx_th_impact_validateInput_0.setValue( String.valueOf( loopCount ) );
                int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
                if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("</td>\r\n                          ");
              }
              if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              if (_jspx_meth_impact_ifMobileImpact_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n\r\n              <td>");
 if ( "Y".equals(personListRow.getBIndStagePersReporter()) ) { 
              out.write("<b>#</b>  ");
}
              out.write("\r\n                              ");
 if (disablePersonNameHL) {
              out.write("\r\n                                    ");
              out.print( personListRow.getSzNmPersonFull() );
              out.write("\r\n                                ");
} else {
              out.write("\r\n                                   <a href=\"javascript:personListHyperlink( '");
              out.print(loopCount);
              out.write("' );   disableValidation( 'frmPersonList' ); submitValidateForm( 'frmPersonList' , '/person/PersonList/callPersonDetail' )\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" >\r\n                                ");

                                //SIR 19455 -- If there is a blank value in the SzNmPersonFull() field
                                //     a line will display for the user to click on.
                                   if(StringHelper.isValid(personListRow.getSzNmPersonFull()) == false)
                                   {
                                     out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                                               "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                                               "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                   }
                                   else
                                   {
                                     out.print(FormattingHelper.formatString(personListRow.getSzNmPersonFull()));
                                   }
                
              out.write("\r\n                                   </a>\r\n                               ");
 }
              out.write("\r\n                          </td>\r\n                          <td>");
              out.print( FormattingHelper.formatString( personListRow.getCWcdIndMerge() ) );
              out.write("</td>\r\n                          <td>");
              out.print( FormattingHelper.formatString( personListRow.getSzCdStagePersSearchInd() ) );
              out.write("</td>                          \r\n                          <td>");
              out.print( FormattingHelper.formatInt( personListRow.getLNbrPersonAge() ) );
              out.write("</td>\r\n                          <td>");
              out.print( FormattingHelper.formatString( personListRow.getCCdPersonSex() ) );
              out.write("</td>\r\n                          <td>");
              out.print( FormattingHelper.formatString( personListRow.getSzCdStagePersType() ) );
              out.write("</td>\r\n                          <td>");
              out.print( FormattingHelper.formatString( personListRow.getSzCdStagePersRole() ) );
              out.write("</td>\r\n                          ");
 if("PRN".equals(personListRow.getSzCdStagePersType())){
              out.write("\r\n                          <td>");
              out.print( FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CRELVICT", personListRow.getSzCdStagePersRelInt()) ));
              out.write("</td>\r\n                          ");
 }else if("COL".equals(personListRow.getSzCdStagePersType())){
              out.write("\r\n                          <td>");
              out.print( FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CSRCRPTR", personListRow.getSzCdStagePersRelInt()) ));
              out.write("</td>\r\n                          ");
 }
              out.write("\r\n                           ");
 if(StringHelper.isValid(personListRow.getSzTxtOtherRelationshipsCmnts())){
              out.write("\r\n                          <td> !</td>\r\n                          ");
 }else{
              out.write("\r\n                          <td>&nbsp;</td>\r\n                          ");
 }
              out.write("                     \r\n                          <td>");
              out.print( FormattingHelper.formatInt( personListRow.getUlIdPerson() ));
              out.write("</td>                                                    \r\n                        </tr>\r\n                         ");
loopCount++;
                   }
                  }
              out.write("\r\n                </table>\r\n             </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n   <tr>\r\n     <td width=\"84%\">&nbsp;</td>\r\n\r\n     <!- Search and Add buttons not needed for Mobile ->\r\n   ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifServerImpact_1 = _jspx_th_impact_ifServerImpact_1.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n        <td class=\"alignRight\" width=\"8%\">\r\n           ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_1);
            _jspx_th_impact_ButtonTag_0.setName("btnSearch");
            _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
            _jspx_th_impact_ButtonTag_0.setAlign("right");
            _jspx_th_impact_ButtonTag_0.setForm("frmPersonList");
            _jspx_th_impact_ButtonTag_0.setAction("/person/PersonList/callPersonSearch");
            _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
            _jspx_th_impact_ButtonTag_0.setDisabled( disableSearchAndAddPB );
            int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
            if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n        </td>\r\n        <td class=\"alignRight\" width=\"8%\">\r\n           ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_1);
            _jspx_th_impact_ButtonTag_1.setName("btnAdd");
            _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
            _jspx_th_impact_ButtonTag_1.setAlign("right");
            _jspx_th_impact_ButtonTag_1.setForm("frmPersonList");
            _jspx_th_impact_ButtonTag_1.setAction("/person/PersonList/callPersonSearch");
            _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
            _jspx_th_impact_ButtonTag_1.setDisabled( disableSearchAndAddPB );
            int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
            if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n        </td>\r\n     ");
          }
          if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <td class=\"alignRight\" width=\"8%\">\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnContinue");
          _jspx_th_impact_ButtonTag_2.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmPersonList");
          _jspx_th_impact_ButtonTag_2.setAction("/person/PersonList/callContinue");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setDisabled( disableContinuePB );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n </table>\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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

  private boolean _jspx_meth_impact_ifMobileImpact_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n              <td>&nbsp;</td>\r\n              ");
    }
    if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_1.setName("hdnPersonLoopCount");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
