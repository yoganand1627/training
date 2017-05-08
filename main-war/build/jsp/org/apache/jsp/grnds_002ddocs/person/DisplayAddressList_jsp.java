package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.exolab.castor.types.Date;
import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class DisplayAddressList_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/** JSP Name:     DisplayAddressList.jsp
 *  Created by:   ? (Habib maybe)
 *  Date Created: 02/05/03
 *
 *  General:
 *  ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE
 *  DisplayAddressList.jsp--Mobile FOR NECESSARY MOBILE CHANGES
 *
 *  Description:
 *  The Address List/Detail sub-module will provide an application-wide facility
 *  for users to store multiple addresses for persons (e.g., principles,
 *  collaterals, employees).  The information will be an expandable section on
 *  the including page and will display a list of the addresses for a given
 *  person with information on whether it is the primary address for the person,
 *  whether it is still valid, address type, the actual address, the Start Date,
 *  and the End Date.
 *  A row may be added by clicking the Add button at the bottom of the list.
 *  This will take the user to a blank address detail page to enter the desired
 *  information.  To Edit an address, the user will click the link in the
 *  Address Type column of the address list.  This will take the user to the
 *  Address Detail page with the information populated from the selected
 *  address.  This page allows a user to edit and delete the Phone Detail
 *  information.
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  06/20/03  Todd Reser        SIR 18345 - Had to remove ++ from all occurances
                              of tabIndex because you aren't supposed to
                              increment tabIndex in submodules.  The browser
                              will handle the tab order of all items having the
                              same tabIndex.
  08/06/03  Todd Reser        Added Flowerbox.
  08/26/05  floresrj          SIR 23936 Modified to reconcile both IMPACT and Mobile versions.
                              Implemented Mobile Phase II changes in IMPACT.  The Mobile
                              version of DisplayAddressList.jsp  is scheduled to no longer be used
                              in the future, since the problem with submodules has been
                              resolved. ***** But until such notice, any changes to either
                              version must be duplicated in the other DisplayAddressList.jsp file *****.
  08/29/05  anandv            Added MOBILE-IMPACT comments at the General section.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  /* Code to include this submodule:
  * impact:include page="/submodule/AddressListSubmodule/displayAddressList" callingPage=" " tabIndex="1" includingForm=" "
  * impact:attribute name="AddressListIncludePage" value=" WindowName "
  * impact:include
  * where WindowName can be set to a value of "STAFF_DETAIL_WINDOW"
  * or "ON_CALL_DETAIL_WINDOW"  or "" depending on which screen is including page
  */
  String TRACE_TAG = "displayAddressList.jsp";
  String tabindexString = (String)request.getAttribute( "tabIndex" );
  int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
  String szCReqFuncCd = "";
  String rowCss = "altColor";
  int MaxNumberOfAddress = 65;
  boolean bHideAddButton = false;
  boolean navAwayCk = StringHelper.isTrue( (String) request.getAttribute( ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME  ) );
  ROWCCMN42SOG00_ARRAY addressArray = null;

  // Since this is a submodule, it should use the page mode that
  // was passed to it from the including JSP.
  String pageMode = (String)state.getAttribute( AddressListConversation.PAGE_MODE_KEY, request );
  // Get the including page's form name and display command
  // and put them in state for redisplay
  String formName = (String)request.getAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY );
  if( formName != null )
  {
    state.setAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY, formName, request );
  }

  String includingPageDisplayURI = (String)request.getAttribute( IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY );
  if( includingPageDisplayURI != null )
  {
    state.setAttribute( IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, includingPageDisplayURI, request );
  }

  CCMN42SO ccmn42so = (CCMN42SO)state.getAttribute(AddressListConversation.ADDRESS_LIST, request);
  if (ccmn42so.getROWCCMN42SOG00_ARRAY()== null )
  {
    addressArray = new ROWCCMN42SOG00_ARRAY();
  }
  else
  {
    addressArray = ccmn42so.getROWCCMN42SOG00_ARRAY();
    //Defect STGAP00000220:No Address Subsection exists on the Intake Person Detail page
    //Resolution:Check the addressArray is null or not.
    if (addressArray!= null)
    {
      bHideAddButton = addressArray.getUlRowQty() >= MaxNumberOfAddress;
    }
  }

      out.write("\r\n\r\n<title>Address</title>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n/*\r\n*This function submits the form to bring up address detail page.\r\n*/\r\nfunction submitFormToAddressDetail( indexNum, cReqFuncCd)\r\n{\r\n  setupFormForAddressDetail( indexNum, cReqFuncCd);\r\n  submitValidateForm( \"");
      out.print(formName);
      out.write("\", \"/person/AddressDetail/addressDetail\" );\r\n}\r\n\r\n/*\r\n*  This function sets up the form information to be submitted.\r\n*/\r\nfunction setupFormForAddressDetail( indexNum, cReqFuncCd)\r\n{\r\n  var x = document.");
      out.print(formName);
      out.write(";\r\n  x.indexNum.value = indexNum;\r\n  x.cReqFuncCd.value = cReqFuncCd;\r\n  disableValidation( \"");
      out.print(formName);
      out.write("\" );\r\n}\r\n\r\n</script>\r\n\r\n");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setType("hidden");
      _jspx_th_impact_validateInput_0.setName("indexNum");
      _jspx_th_impact_validateInput_0.setEditableMode(EditableMode.EDIT);
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_1.setParent(null);
      _jspx_th_impact_validateInput_1.setType("hidden");
      _jspx_th_impact_validateInput_1.setName("cReqFuncCd");
      _jspx_th_impact_validateInput_1.setEditableMode(EditableMode.EDIT);
      _jspx_th_impact_validateInput_1.setValue(szCReqFuncCd);
      int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
      if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_2.setParent(null);
      _jspx_th_impact_validateInput_2.setType("hidden");
      _jspx_th_impact_validateInput_2.setName("txtUlIdPerson");
      _jspx_th_impact_validateInput_2.setValue("25046278");
      _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.EDIT);
      int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
      if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("AddressList");
      _jspx_th_impact_ExpandableSectionTag_0.setId("lbAddressList_Id");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Address");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex );
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n<div id=\"idAddressListScrollBar\" style=\"height:165px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n      <tr>\r\n      <th class=\"thList\">Primary</th>\r\n      <th class=\"thList\">Invalid</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Street</th>\r\n      <th class=\"thList\">City</th>\r\n      <th class=\"thList\">State</th>\r\n      <th class=\"thList\">Start Date</th>\r\n      <th class=\"thList\">End Date</th>\r\n      <!-- SIR 23936  -->\r\n    ");
          if (_jspx_meth_impact_ifServerImpact_0(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
            return;
          out.write("\r\n      ");
          if (_jspx_meth_impact_ifMobileImpact_0(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
            return;
          out.write("\r\n      </tr>\r\n  ");


      ROWCCMN42SOG00 addressRow = null;
      int iLoopCounter = 0;
      
    if( !FormValidation.pageHasErrorMessages( request ) )
    {
    //Defect STGAP00000220:No Address Subsection exists on the Intake Person Detail page
    //Resolution:Check the addressArray is null or not.
      if (addressArray == null || addressArray.getROWCCMN42SOG00Count() == 0  )
      {
          out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"9\">\r\n           ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n          </td>\r\n        </tr>\r\n      ");
}
      else
      {
        for (Enumeration e = addressArray.enumerateROWCCMN42SOG00(); e.hasMoreElements(); )
        {
          addressRow = (ROWCCMN42SOG00)e.nextElement();
  
          out.write("\r\n          <tr class=\"");
          out.print(FormattingHelper.getRowCss( iLoopCounter + 1 ));
          out.write("\" valign=\"top\">\r\n          <td align=\"center\">");
if( addressRow.getBIndPersAddrLinkPrimary().compareToIgnoreCase("Y") == 0 ){
          out.write("<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >");
}
          out.write("</td>\r\n          <td align=\"center\">");
if( addressRow.getBIndPersAddrLinkInvalid().compareToIgnoreCase("Y") == 0 ){
          out.write("<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >");
}
          out.write("</td>\r\n          <!-- SIR 23936  -->\r\n        ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          int _jspx_eval_impact_ifServerImpact_1 = _jspx_th_impact_ifServerImpact_1.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write('\r');
            out.write('\n');
 /* SIR 18345 - Had to add tabIndex to the a href */ 
            out.write("\r\n          <td><a href=\"javascript:submitFormToAddressDetail( '");
            out.print(iLoopCounter);
            out.write("','U')\"");
 if ( !navAwayCk ) { 
            out.write(" onClick=\"setIsDirtyCalled( true );\"");
 } 
            out.write(" tabIndex=\"");
            out.print( tabIndex );
            out.write('"');
            out.write('>');
            out.print(Lookup.simpleDecodeSafe("CADDRTYP", addressRow.getSzCdPersAddrLinkType() ));
            out.write("</a>&nbsp;</td>\r\n          ");
          }
          if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          //  impact:ifMobileImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
          _jspx_th_impact_ifMobileImpact_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifMobileImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          int _jspx_eval_impact_ifMobileImpact_1 = _jspx_th_impact_ifMobileImpact_1.doStartTag();
          if (_jspx_eval_impact_ifMobileImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n        <td>");
            out.print(Lookup.simpleDecodeSafe("CADDRTYP", addressRow.getSzCdPersAddrLinkType() ));
            out.write("&nbsp;</td>\r\n          ");
          }
          if (_jspx_th_impact_ifMobileImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          <td>");
          out.print(addressRow.getSzAddrPersAddrStLn1());
          out.write("\r\n          <td>");
          out.print(addressRow.getSzAddrCity());
          out.write("\r\n          <td>");
          out.print(addressRow.getSzCdAddrState());
          out.write("\r\n          <td>");
          out.print(FormattingHelper.formatDate(addressRow.getDtDtPersAddrLinkStart()));
          out.write("\r\n          <!-- SIR 23936  -->\r\n        ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          int _jspx_eval_impact_ifServerImpact_2 = _jspx_th_impact_ifServerImpact_2.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n          <td>");
            out.print(FormattingHelper.formatDate(addressRow.getDtDtPersAddrLinkEnd()));
            out.write("\r\n          <td align=\"center\">");
if( addressRow.getSzTxtPersAddrCmnts() != null && !"".equals(
                  addressRow.getSzTxtPersAddrCmnts()) ){
            out.write("<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >");
}
            out.write("</td>\r\n          ");
          }
          if (_jspx_th_impact_ifServerImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          //  impact:ifMobileImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
          _jspx_th_impact_ifMobileImpact_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifMobileImpact_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          int _jspx_eval_impact_ifMobileImpact_2 = _jspx_th_impact_ifMobileImpact_2.doStartTag();
          if (_jspx_eval_impact_ifMobileImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n          ");

            if ( addressRow.getDtDtPersAddrLinkEnd().toString().equals( DateHelper.MAX_CASTOR_DATE.toString() ) )
            {
          
            out.write("\r\n             <td>&nbsp;</td>\r\n         ");
 } else
              { 
            out.write("\r\n           <td>");
            out.print(FormattingHelper.formatDate(addressRow.getDtDtPersAddrLinkEnd()));
            out.write("\r\n            ");
}
            out.write("\r\n          <td>&nbsp;</td>\r\n          ");
          }
          if (_jspx_th_impact_ifMobileImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </tr>\r\n  ");

          iLoopCounter++;
        } // end for
      }// end if addressArray.getROWCCMN42SOG00Count() == 0
    } // end if !FormValidation.pageHasErrorMessages( request )
  
          out.write("\r\n\r\n  </table>\r\n</div>\r\n\r\n");

if ( !bHideAddButton && PageModeConstants.EDIT.equals( pageMode ) )
{
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\">\r\n          <!-- SIR 23936  -->\r\n        ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_3 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          int _jspx_eval_impact_ifServerImpact_3 = _jspx_th_impact_ifServerImpact_3.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n        ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_3);
            _jspx_th_impact_ButtonTag_0.setName("btnAdd");
            _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
            _jspx_th_impact_ButtonTag_0.setFunction("setupFormForAddressDetail('0', 'A');");
            _jspx_th_impact_ButtonTag_0.setForm(formName);
            _jspx_th_impact_ButtonTag_0.setAction("/person/AddressDetail/addressDetail");
            _jspx_th_impact_ButtonTag_0.setNavAwayCk(navAwayCk);
            _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex );
            int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
            if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n        ");
          }
          if (_jspx_th_impact_ifServerImpact_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_ifServerImpact_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n         <th class=\"thList\">Comments</th>\r\n    ");
    }
    if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n         <th class=\"thList\">&nbsp;</th>\r\n      ");
    }
    if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
