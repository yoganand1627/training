package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.person.AddressValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class AddressListPullBack_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/** JSP Name:     AddressListPullBack.jsp
 *  Created by:   ?
 *  Date Created: ??
 *
 *  Description:
 *  The Address Pullback List portion of the Address List/Detail Sub-module
 *  exists in the modify mode only.  It will provide a facility for users to
 *  copy addresses for persons sharing an address, such as the multiple members
 *  of families involved together in an IMPACT stage context.  The information
 *  list will be a child page of the Address Detail page.  This page is a
 *  replacement for the existing copy/paste utility in CAPS.
 *  The Address Pullback List will display the active phone numbers of all
 *  persons in the stage of the current person.  Each Pullback List row displays
 *  the Full Name of a person in the stage and will contain a checkmark
 *  indicator if it is the Primary address for the person, address Type, Street,
 *  and City.  Selecting a row and clicking the Continue pushbutton will return
 *  the user to the Address Detail page with the details of the selected row
 *  populating the appropriate fields.
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Added Flowerbox and Change Log.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String TRACE_TAG = "displayAddressListPullBack.jsp";
  int tabIndex = 1;
//  String szCReqFuncCd = "";
  String pageMode = PageModeConstants.EDIT;
//  String rowCss = "altColor";
  String txtSzAddrPersAddrAttn = "";
  String txtSzCdPersAddrLinkType = "";
  String txtDtDtPersAddrLinkStart = "";
  String txtDtDtPersAddrLinkEnd = "";
  String bIndPersAddrLinkPrimary = "";
  String bIndPersAddrLinkInvalid = "";

  GrndsTrace.msg(TRACE_TAG, 10, "inside AddressListPullBack.jsp \n" );

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  List addressList = (List)state.getAttribute(AddressDetailConversation.ADDRESS_LIST_PULLBACK, request);
  //pageMode = PageMode.getPageMode(request);
  pageMode = GlobalData.getAppMode(request);
  GrndsTrace.msg( TRACE_TAG, 10,  "AddressPullBack.jsp_PageMode :\n" + pageMode );

  GrndsTrace.msg( TRACE_TAG, 10,  "request.getParameter(txtSzAddrPersAddrAttn) is: " + request.getParameter("txtSzAddrPersAddrAttn") );

  if( request.getParameter("txtSzAddrPersAddrAttn") != null )
  {
    txtSzAddrPersAddrAttn = request.getParameter("txtSzAddrPersAddrAttn");
  }
  if( request.getParameter("selSzCdPersAddrLinkType") != null )
  {
    txtSzCdPersAddrLinkType = request.getParameter("selSzCdPersAddrLinkType");
  }
  if( request.getParameter("txtDtDtPersAddrLinkStart") != null )
  {
    txtDtDtPersAddrLinkStart = request.getParameter("txtDtDtPersAddrLinkStart");
  }
  if( request.getParameter("txtDtDtPersAddrLinkEnd") != null )
  {
    txtDtDtPersAddrLinkEnd = request.getParameter("txtDtDtPersAddrLinkEnd");
  }
  if( request.getParameter("cbxBIndPersAddrLinkPrimary") != null )
  {
    bIndPersAddrLinkPrimary = request.getParameter("cbxBIndPersAddrLinkPrimary");
  }
  if( request.getParameter("cbxBIndPersAddrLinkInvalid") != null )
  {
    bIndPersAddrLinkInvalid = request.getParameter("cbxBIndPersAddrLinkInvalid");
  }


      out.write("\r\n\r\n<title>Address PullBack List</title>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n/*\r\n*This function submits the form to bring up address detail page.\r\n*/\r\nfunction submitFormToAddressDetail()\r\n{\r\n  var x = document.frmAddressListPullBack;\r\n  x.cReqFuncCd.value = \"C\";\r\n  enableValidation( \"frmAddressListPullBack\" );\r\n  return true;\r\n}\r\n\r\nfunction setRow( type , attn )\r\n{\r\n  var x = document.frmAddressListPullBack;\r\n  x.txtSzAddrPersAddrAttn.value = attn;\r\n  x.selSzCdPersAddrLinkType.value = type;\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAddressListPullBack");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.AddressListPullBackCustomValidation");
      _jspx_th_impact_validateForm_0.setAction("/person/AddressDetail/addressDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
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
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("cReqFuncCd");
          _jspx_th_impact_validateInput_1.setEditableMode(EditableMode.EDIT);
          _jspx_th_impact_validateInput_1.setValue("C");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("txtDtDtPersAddrLinkStart");
          _jspx_th_impact_validateInput_2.setValue(txtDtDtPersAddrLinkStart);
          _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("txtDtDtPersAddrLinkEnd");
          _jspx_th_impact_validateInput_3.setValue(txtDtDtPersAddrLinkEnd);
          _jspx_th_impact_validateInput_3.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("txtSzAddrPersAddrAttn");
          _jspx_th_impact_validateInput_4.setValue("");
          _jspx_th_impact_validateInput_4.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("cbxBIndPersAddrLinkPrimary");
          _jspx_th_impact_validateInput_5.setValue(bIndPersAddrLinkPrimary);
          _jspx_th_impact_validateInput_5.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("cbxBIndPersAddrLinkInvalid");
          _jspx_th_impact_validateInput_6.setValue(bIndPersAddrLinkInvalid);
          _jspx_th_impact_validateInput_6.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("selSzCdPersAddrLinkType");
          _jspx_th_impact_validateInput_7.setValue("");
          _jspx_th_impact_validateInput_7.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"750\" class=\"tableBorder\">\r\n\r\n      <tr>\r\n      <th class=\"thList\">Full Name</th>\r\n      <th class=\"thList\">Primary</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Street</th>\r\n      <th class=\"thList\">City</th>\r\n      <th class=\"thList\">State</th>\r\n      </tr>\r\n  ");

    GrndsTrace.msg( TRACE_TAG, 10,  "AddressPullBack.jsp_before_addressRow :\n" );

      AddressValueBean addressRow = null;
      int iLoopCounter = 0;
        GrndsTrace.msg( TRACE_TAG, 10,  "AddressPullBack.jsp_inside_if :\n" );
        if ( addressList == null)
        {
          out.write("\r\n          <tr class=\"odd\">\r\n            <td colspan=\"9\">\r\n            ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n            </td>\r\n          </tr>\r\n       ");
}
        else
        {
          for (iLoopCounter = 0; iLoopCounter < addressList.size(); iLoopCounter++)
          {
            addressRow = (AddressValueBean) addressList.get(iLoopCounter);
          
          out.write("\r\n           <tr class=\"");
          out.print(FormattingHelper.getRowCss( iLoopCounter + 1 ));
          out.write("\" valign=\"top\">\r\n           ");

           String setRow = "setRow('" + addressRow.getAddressType() + "' , '" + FormattingHelper.formatString( addressRow.getAttention() ) + "');";
           
          out.write("\r\n           <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setName("rbAddressRadioIndex");
          _jspx_th_impact_validateInput_8.setValue( String.valueOf( iLoopCounter ) );
          _jspx_th_impact_validateInput_8.setOnClick(setRow  );
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.print(addressRow.getPeronFullName());
          out.write("</td>\r\n           <td align=\"center\">");
if( addressRow.getPrimary().compareToIgnoreCase("Y") == 0 ){
          out.write("<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >");
}
          out.write("</td>\r\n           <td>");
          out.print(Lookup.simpleDecodeSafe("CADDRTYP", addressRow.getAddressType() ));
          out.write("&nbsp;</td>\r\n           <td>");
          out.print(addressRow.getStreetLn1());
          out.write("\r\n           <td>");
          out.print(addressRow.getCity());
          out.write("\r\n           <td>");
          out.print(addressRow.getState());
          out.write("\r\n           </tr>\r\n          ");

          } // end for
        }// end else

  
          out.write("\r\n\r\n  </table>\r\n   <table width=\"760\">\r\n       <td align=\"right\">\r\n       ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnContinue");
          _jspx_th_impact_ButtonTag_0.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_0.setFunction("return submitFormToAddressDetail();");
          _jspx_th_impact_ButtonTag_0.setForm("frmAddressListPullBack");
          _jspx_th_impact_ButtonTag_0.setAction("/person/AddressDetail/addressDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n   </table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
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
}
