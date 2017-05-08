package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.person.NameHistoryConversation;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class NameHistorySub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

CINV25SO cinv25so = (CINV25SO) state.getAttribute( "CINV25SO", request );

ROWCINV25SOG00_ARRAY rowArray = cinv25so.getROWCINV25SOG00_ARRAY();

Enumeration nameEnumeration1 = rowArray.enumerateROWCINV25SOG00();

String includingFormName = (String) request.getAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY );

// Get the page mode that was passed to the submodule by the including JSP.
String pageMode = (String)state.getAttribute( NameHistorySubmoduleConversation.PAGE_MODE_KEY, request );

int loopCount = 0;

String tabindexString = (String) request.getAttribute( "tabIndex" );
int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nwindow.onload = function ()\r\n{\r\n  ");
      out.print( includingFormName );
      out.write(".isAdd.value = \"\";\r\n};\r\n\r\nfunction launchDetail( index )\r\n{\r\n  ");
      out.print( includingFormName );
      out.write(".arrayIndex.value = index;\r\n  // to prevent isAdd=true carried over when user first clicked Add then Back then clicks on a Name hyperlink\r\n  // causong blank page to display;\r\n  // found when fixing STGAP00004856\r\n  ");
      out.print( includingFormName );
      out.write(".isAdd.value = \"\";\r\n  // end STGAP00004856\r\n  disableValidation( '");
      out.print( includingFormName );
      out.write("' );\r\n  submitValidateForm('");
      out.print( includingFormName );
      out.write("', '/person/NameHistory/displayNameHistoryDetail');\r\n}\r\n\r\nfunction addDetail()\r\n{\r\n  ");
      out.print( includingFormName );
      out.write(".isAdd.value = \"true\";\r\n  return true;\r\n}\r\n</script>\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateInput_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_1(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("NameHistory");
      _jspx_th_impact_ExpandableSectionTag_0.setId("nameHistoryItem_0");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Name History");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<div id=\"scrollBar\" style=\"height:165px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n<tr>\r\n <th class=\"thList\">Primary</th>\r\n <th class=\"thList\">Invalid</th>\r\n <th class=\"thList\">Name</th>\r\n <th class=\"thList\">Suffix</th>\r\n <th class=\"thList\">Start Date</th>\r\n <th class=\"thList\">End Date</th>\r\n</tr>\r\n");


ROWCINV25SOG00 nameRow = null;
if( !FormValidation.pageHasErrorMessages( request ))
{
  if ( !nameEnumeration1.hasMoreElements() )
  {

          out.write("\r\n    <tr class=\"odd\">\r\n      <td colspan=\"7\">\r\n       ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n      </td>\r\n    </tr>\r\n");

  }
  else
  {
    while( nameEnumeration1.hasMoreElements() )
    {
      nameRow = (ROWCINV25SOG00) nameEnumeration1.nextElement();

          out.write("\r\n      <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1));
          out.write("\">\r\n      <td align=\"center\">\r\n");

      if("Y".equals(nameRow.getBIndNamePrimary()) )
      {

          out.write("\r\n        <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\" >\r\n");
    }

          out.write("\r\n      </td>\r\n\r\n      <td align=\"center\">\r\n");
      if("Y".equals(nameRow.getBIndNameInvalid()) )
        {

          out.write("\r\n           <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\" >\r\n");
      }

          out.write("\r\n      </td>\r\n");
    String first = "";
      String middle = "";
      String last = "";
      if ( !"".equals(nameRow.getSzNmNameLast()) )
      {
        last = nameRow.getSzNmNameLast();
      }
      if ( !"".equals(nameRow.getSzNmNameFirst()) )
      {
        first = ", "+nameRow.getSzNmNameFirst();
      }
      if ( !"".equals(nameRow.getSzNmNameMiddle()) )
      {
        if ("".equals(first) )
        {
          middle = ", "+nameRow.getSzNmNameMiddle();
        }
        else
        {
          middle = " "+nameRow.getSzNmNameMiddle();
        }
      }
      String fullName = last + first + middle;
      String listItemId = "nameHistoryItem_" + loopCount; 
          out.write("\r\n      <td><a href=\"javascript:launchDetail(");
          out.print( loopCount );
          out.write(")\"\r\n         tabIndex=\"");
          out.print( tabIndex );
          out.write("\" id=\"");
          out.print( listItemId );
          out.write('"');
          out.write('>');
          out.print( fullName );
          out.write("</a>\r\n      </td>\r\n      <td>");
          out.print( Lookup.simpleDecodeSafe( CodesTables.CSUFFIX, nameRow.getSzCdNameSuffix() ) );
          out.write("\r\n      </td>\r\n      <td>");
          out.print( FormattingHelper.formatDate( nameRow.getDtDtNameStartDate() ) );
          out.write("</td>\r\n      <td>");
          out.print( FormattingHelper.formatDate( nameRow.getDtDtNameEndDate() ) );
          out.write("</td>\r\n      </tr>\r\n");

      loopCount++;
    } // end while enumeration has more elements
  } //end big else
} // end !FormValidation.pageHasErrorMessages

          out.write("\r\n  </table>\r\n</div>\r\n\r\n");

if ( !pageMode.equals( PageModeConstants.VIEW ) )
{
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAddNewName");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm( includingFormName );
          _jspx_th_impact_ButtonTag_0.setFunction("return addDetail();");
          _jspx_th_impact_ButtonTag_0.setAction("/person/NameHistory/addName");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

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
      out.write("\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent(null);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("arrayIndex");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent(null);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("isAdd");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
