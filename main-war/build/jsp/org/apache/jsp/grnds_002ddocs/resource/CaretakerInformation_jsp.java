package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.resource.CaretakerConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

public final class CaretakerInformation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
   * JSP Name:     CaretakerInformation.jsp
   * Created by:   Brad Eiliers
   * Date Created: 09/30/02
   *
   * Description:
   * This page is accessed from a hyperlink on the Facility Detail Page.  It
   * allows users to view, add and delete Caretaker Information.
   **/
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/11/03  Todd Reser        Added flowerbox, description and Change log.
  02/18/04  Linda Reed        SIR 22625- added txtChildResourceId so Home ResourceId
                              passed on to following pages.
  09/01/05  Linda Reed        SIR 23777 - split Race out of Ethnicity.
  01/02/09  Abraham Williams  STGAP00010681 - Updated CPA Resource ID and Home ID.
                              CPA Resource ID and Home ID are updated with the values from
                              the Caretaker Information output structure (CRES18SO).
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String caretakerName = "";
  String idResource = "";
  String ulHmResourceId = "";
  String cpaResourceId = "";
  String homeId = "";
  String maritalStatus = "";
  int iLoopCount = 0;
  String txtChildResourceId = "";
  String endDate = null;
  int activeCaretakerCount = 0;
  
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  
  //get the CRES18SO object from state.
  CRES18SO caretakerInfo = (CRES18SO) state.getAttribute(CaretakerConversation.CRES18SO_ATTR_NAME, request);
  ROWCRES55DO_ARRAY caretakerArray = null;
  
  if (caretakerInfo != null) {
    caretakerArray = caretakerInfo.getROWCRES55DO_ARRAY();
    caretakerName = caretakerInfo.getSzCpaName();
    idResource = Integer.toString(caretakerInfo.getUlIdResource());
    ulHmResourceId = Integer.toString(caretakerInfo.getUlHmResourceId());
    
    // STGAP00010681 - This defect innvalidates the following comment for Home ID
    // as per Bryant suggestion- defect number STGAP00002542, setting the caretaker name as the resource name,
    // cparesourceid to the resourceid, homeId to Blank.
    //caretakerName = resourceName;
    //idResource = uidResource;
    //homeId = "";
    
    // STGAP00010681 - Set correct values for Home ID and CPA Resource ID
    if (idResource.equals("0")) {
      cpaResourceId = "";
    } else {
      cpaResourceId = idResource;
    }
    if (ulHmResourceId.equals("0")) {
      homeId = "";
    } else {
      homeId = ulHmResourceId;
    }    
    
    // Get home marital status
    if (caretakerArray != null) {
      ROWCRES55DO caretakerDetail = caretakerArray.getROWCRES55DO(0);

      if (caretakerDetail != null) {
        maritalStatus = Lookup.simpleDecodeSafe("CFAMSTRC", caretakerDetail.getCd_Home_Marital_Status());
        endDate = FormattingHelper.formatDate(caretakerDetail.getDtEnd());
      }
    }
  }
  
  if (caretakerArray == null) {
    caretakerArray = new ROWCRES55DO_ARRAY();
  }

  String pageMode = PageMode.getPageMode(request);

  int tabIndex = 1;

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  <!--Insert Java Script here\r\n\r\n//Go to caretaker detail\r\nfunction submitCaretakerForm( index )\r\n{\r\n  document.frmCaretakerDetail.caretakerIndex.value = index;\r\n  document.frmCaretakerDetail.cReqFuncCd.value = 'U';\r\n  //document.frmCaretakerDetail.");
      out.print(PageMode.PAGE_MODE_ATTRIBUTE_NAME);
      out.write(".value = \"");
      out.print(PageModeConstants.EDIT);
      out.write("\";\r\n  disableValidation('frmCaretakerDetail');\r\n  submitValidateForm( 'frmCaretakerDetail', '/resource/Caretaker/displayCaretakerDetail' );\r\n}\r\n\r\n//Go to caretaker detail with a blank page\r\nfunction addCaretaker()\r\n{\r\n  var x = document.frmCaretakerDetail;\r\n  var careTakerLength = 0;\r\n  var activeCaretakerLength = 0;\r\n  careTakerLength = x.activeCaretakerCount.value;\r\n    \r\n  if ( careTakerLength == 2 )\r\n  {\r\n    alert( '");
      out.print( MessageLookup.getMessageByName( "MSG_MAX_CARETAKER_ROW") );
      out.write("' );\r\n    return false;\r\n  }else\r\n  {\r\n    document.frmCaretakerDetail.cReqFuncCd.value = 'A';\r\n    document.frmCaretakerDetail.");
      out.print(PageMode.PAGE_MODE_ATTRIBUTE_NAME);
      out.write(".value = \"");
      out.print(PageModeConstants.EDIT);
      out.write("\";\r\n    return true;\r\n\r\n  }\r\n}\r\n\r\nfunction checkForSelection( objName )\r\n{\r\n  var buttonChecked = false;\r\n  var obj = eval(objName);\r\n\r\n  if (obj != null)\r\n  {\r\n    if (obj.length == null)\r\n    {\r\n      if (obj.checked != false)\r\n        buttonChecked = true;\r\n    }\r\n    else\r\n    {\r\n      for (var i = 0; i < obj.length; ++i)\r\n      {\r\n        buttonChecked = buttonChecked || obj[i].checked;\r\n      }\r\n    }\r\n  }\r\n\r\n  return (buttonChecked);\r\n}\r\n\r\n//submit form to delete the caretaker\r\nfunction deleteCaretaker()\r\n{\r\n  var x = document.frmCaretakerDetail;\r\n  var rowSelected = false;\r\n  //Alert user if they click a Delete button without selecting an item to delete\r\n\r\n  rowSelected = checkForSelection(\"document.frmCaretakerDetail.rbSelectedCaretaker\");\r\n\r\n  if( !rowSelected )\r\n  {\r\n    setInformationalMessage(\"");
      out.print( MessageLookup.getMessageByName( "MSG_SELECT_ROW_ACTION" ));
      out.write("\" );\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    var cnfrm = window.confirm( '");
      out.print( MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") );
      out.write("' )\r\n    if(cnfrm)\r\n    {\r\n      document.frmCaretakerDetail.cReqFuncCd.value = 'D';\r\n      disableValidation('frmCaretakerDetail');\r\n      //submitForm( 'frmCaretakerDetail', '/resource/Caretaker/deleteCaretaker' );\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n}\r\n//End Java Script-->\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaretakerDetail");
      _jspx_th_impact_validateForm_0.setAction("/resource/Caretaker/displayCaretakerDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Caretaker Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formLabel\"> Name: </td>\r\n    <td>");
          out.print(caretakerName);
          out.write("</td>\r\n    <td class=\"formLabel\">CPA Resource ID: </td>\r\n    <td width=250>");
          out.print(cpaResourceId);
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formLabel\">Home ID:</td>\r\n    <td>");
          out.print(homeId);
          out.write("</td>\r\n    <td class=\"formLabel\">Home Marital Status: </td>\r\n    <td>");
          out.print(maritalStatus);
          out.write("</td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th>Caretakers</th>\r\n</tr>\r\n<tr>\r\n<td>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorderList\">\r\n  <tr>\r\n    <th class=\"thList\">Name</th>\r\n    <th class=\"thList\">Date of Birth</th>\r\n    <th class=\"thList\">Ethnicity</th>\r\n    <th class=\"thList\">Gender</th>\r\n    <th class=\"thList\">End Date</th>\r\n   </tr>\r\n  ");

    ROWCRES55DO caretakerDetail;
    Enumeration caretakers = caretakerArray.enumerateROWCRES55DO();
    iLoopCount = 0;
    if (caretakers.hasMoreElements()) {
      while (caretakers.hasMoreElements()) {
        caretakerDetail = (ROWCRES55DO) caretakers.nextElement();
        if(caretakerDetail.getDtEnd() == null || "".equals(caretakerDetail.getDtEnd()) || caretakerDetail.getDtEnd() == null || DateHelper.isAfterToday(caretakerDetail.getDtEnd()) )  {
        	activeCaretakerCount++;
        }
  
          out.write("\r\n  <tr>\r\n    <td class=\"formInput\"><a href=\"#\" onClick=\"javascript:submitCaretakerForm( ");
          out.print(iLoopCount);
          out.write(" )\"\r\n                                tabIndex=\"");
          out.print(tabIndex++);
          out.write('"');
          out.write('>');
          out.print(caretakerDetail.getSzNmCaretkrLname());
          out.write(',');
          out.write(' ');
          out.print(caretakerDetail.getSzNmCaretkrFname());
          out.write(' ');
          out.print(caretakerDetail.getSzNmCaretkrMname());
          out.write("</a></td>\r\n    <td class=\"formInput\">");

      if (caretakerDetail.getDtCaretkrBirth() != null) {
        out.println(FormattingHelper.formatDate(caretakerDetail.getDtCaretkrBirth()));
      }
    
          out.write("</td>\r\n    <td class=\"formInput\">");
          out.print(Lookup.simpleDecodeSafe("CETHNIC", caretakerDetail.getCdCaretkrEthnic()));
          out.write("</td>\r\n    <td class=\"formInput\">");
          out.print(Lookup.simpleDecodeSafe("CSEX", caretakerDetail.getCdCaretkrSex()));
          out.write("</td>\r\n    <td class=\"formInput\">");
          out.print(FormattingHelper.formatDate(caretakerDetail.getDtEnd()) );
          out.write("\r\n  </tr>\r\n  ");

      ++iLoopCount;
    } //end for loop for caretakerArray
  } else {
  
          out.write(" <tr>\r\n  <td>\r\n    ");
          out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
          out.write("\r\n  </td>\r\n</tr>\r\n  ");
 }
  
          out.write("\r\n</table>\r\n");

  if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) {

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAddCareTaker");
          _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("return addCaretaker();");
          _jspx_th_impact_ButtonTag_0.setForm("frmCaretakerDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/Caretaker/addCaretakerDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

} else if (StringHelper.checkForEquality(pageMode, PageModeConstants.CREATE)) {

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAddCareTaker");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return addCaretaker();");
          _jspx_th_impact_ButtonTag_1.setForm("frmCaretakerDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/Caretaker/addCaretakerDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

  }

          out.write("\r\n\r\n</td>\r\n</tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"caretakerCount\" value=\"");
          out.print(iLoopCount);
          out.write("\"/>\r\n<input type=\"hidden\" name=\"activeCaretakerCount\" value=\"");
          out.print(activeCaretakerCount);
          out.write("\"/>\r\n<input type=\"hidden\" name=\"txtChildResourceId\" value=\"");
          out.print(txtChildResourceId);
          out.write("\"/>\r\n<input type=\"hidden\" name=\"cReqFuncCd\"/>\r\n<input type=\"hidden\" name=\"caretakerIndex\"/>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n<input type=\"hidden\" name=\"");
          out.print(PageMode.PAGE_MODE_ATTRIBUTE_NAME);
          out.write("\" value=\"");
          out.print(pageMode);
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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
