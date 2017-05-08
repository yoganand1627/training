package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersSubmoduleConversation;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Date;

public final class PersonIdentifiersListSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/** JSP Name:     PersonIdentifiersListSub.jsp
 *  Created by:   Michael K. Werle
 *  Date Created: 12/09/02
 *
 *  Description:
 *  Person Identifiers is a sub-module that will appear as an expandable section
 *  on the including page.  Expanding the Person Identifiers section will
 *  display a list box containing all of the current identifier rows for a
 *  person in IMPACT.  An Add push button navigates to a Person Identifiers
 *  Detail page to add a new row.  Hyperlinks on the Type fields will navigate
 *  to the Person Identifiers Detail page for editing or viewing an individual
 *  row.
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.

  08/26/03  thompswa          SIR 19542 Changed table div id="person-
                              IdentifiersScrollBar" to a set height to match
                              other submodules so that it doesn't get too long.
                              Also added class="subDetail" to "no rows" message.
  07/11/05  Merle A Demo      Added IndValidateByInterface for Sir23446, It shows
                           when and SSN was validated by the interface.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String localPageMode = (String) state.getAttribute(PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY, request);

  // Get tabIndex out of the request
  String tabindexString = (String)request.getAttribute( "tabIndex" );
  int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);


  // Get the including page's display commmand out of state
  String includingDisplayCommand = (String)state.getAttribute( IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request );

  // Get the form name out of the request
  String includingFormName = (String)request.getAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY );

  // Get cint14wlb_array out of the request
  CINT14WLB_ARRAY cint14wlb_array = (CINT14WLB_ARRAY)request.getAttribute( PersonIdentifiersConversation.CINT14WLB_ARRAY_KEY );

  UserProfile user = UserProfileHelper.getUserProfile( request );

      out.write("\r\n\r\n<script language=\"Javascript\">\r\n  function showPersonIDDetail( idPersonId )\r\n  {\r\n    ");
      out.print(includingFormName);
      out.write(".hdnUlIdPersonId.value = idPersonId;\r\n    disableValidation('");
      out.print(includingFormName);
      out.write("');\r\n  }\r\n</script>\r\n\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("personIdentifiersSubmodule");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Person Identifiers");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex);
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnIncludingPageDisplayCommand");
          _jspx_th_impact_validateInput_0.setValue(includingDisplayCommand);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          out.write("\r\n  <div id=\"personIdentifiersScrollBar\" style=\"height:165; width:100%; overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n      <tr>\r\n        <th class=\"thList\">Invalid</th>\r\n        <th class=\"thList\">Type</th>\r\n        <th class=\"thList\">Number</th>\r\n        <th class=\"thList\">Start</th>\r\n        <th class=\"thList\">End</th>\r\n  <!--<th class=\"thList\">V</th>\r\n        --><th class=\"thList\">Comments</th>\r\n      </tr>\r\n      ");

        if( cint14wlb_array != null && cint14wlb_array.getCINT14WLBCount() > 0 )
        {
          int loopCount = 0;
          Enumeration cint14wlbEnum = cint14wlb_array.enumerateCINT14WLB();
          while( cint14wlbEnum.hasMoreElements() )
          {
            CINT14WLB cint14wlb = (CINT14WLB)cint14wlbEnum.nextElement();
            String numberType = cint14wlb.getSzCdPersonIdType();
            
          out.write("\r\n            <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\">\r\n              <td align=\"center\">\r\n                ");
          out.print( ServiceConstants.FND_YES.equals( cint14wlb.getBIndPersonIDInvalid() ) ? "<image alt=\"checkmark\" src='/grnds-docs/images/shared/checkMark_short.gif'>" : "&nbsp;");
          out.write("\r\n              </td>\r\n              <td>\r\n                      <a href=\"javascript:showPersonIDDetail(");
          out.print(cint14wlb.getUlIdPersonId());
          out.write(");submitValidateForm('");
          out.print(includingFormName);
          out.write("','/person/PersonIdentifiers/displayPersonIdDetail');\"\r\n                         tabIndex=\"");
          out.print(tabIndex);
          out.write("\">\r\n                        ");
          out.print(FormattingHelper.formatString( numberType ));
          out.write("\r\n                      </a>\r\n              </td>\r\n              <td>\r\n                ");

                  if( CodesTables.CNUMTYPE_SSN.equals( numberType ) )
                  {
                    
          out.write("\r\n                    ");
          out.print(FormattingHelper.formatSSN( cint14wlb.getSzNbrPersonIdNumber() ));
          out.write("\r\n                    ");

                  }
                  else
                  {
                    
          out.write("\r\n                      ");
          out.print(FormattingHelper.formatString( cint14wlb.getSzNbrPersonIdNumber() ));
          out.write("\r\n                    ");

                  }
                
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
          out.print(FormattingHelper.formatDate( cint14wlb.getDtPersonIDStart() ));
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
          out.print(FormattingHelper.formatDate( cint14wlb.getDtPersonIDEnd() ));
          out.write("\r\n              </td>\r\n         <!--<td align=\"center\">\r\n                ");
          out.print( ServiceConstants.FND_YES.equals(cint14wlb.getBIndValidateByInterface() ) ? "<image alt=\"checkmark\" src='/grnds-docs/images/shared/checkMark_short.gif'>" : "&nbsp;");
          out.write("\r\n              </td>\r\n              --><td>\r\n                ");
          out.print(FormattingHelper.formatString( cint14wlb.getSzDescPersonID() ));
          out.write("\r\n              </td>\r\n            </tr>\r\n            ");

            loopCount++;
          }
        }
        else
        {
          
          out.write("\r\n            <tr><td class=\"subDetail\" colspan=\"6\">");
          out.print(MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ));
          out.write("</td></tr>\r\n          ");

        }
      
          out.write("\r\n    </table>\r\n    </div>\r\n\r\n");


  if(!PageModeConstants.VIEW.equals(localPageMode))
  {

          out.write("\r\n\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n       <tr>\r\n          <td align=\"right\">\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAddFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          _jspx_th_impact_ButtonTag_0.setFunction("javascript:showPersonIDDetail( 0 )");
          _jspx_th_impact_ButtonTag_0.setForm(includingFormName);
          _jspx_th_impact_ButtonTag_0.setAction("/person/PersonIdentifiers/addPersonIdDetail");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n       </tr>\r\n    </table>\r\n\r\n\r\n");

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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnUlIdPersonId");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
