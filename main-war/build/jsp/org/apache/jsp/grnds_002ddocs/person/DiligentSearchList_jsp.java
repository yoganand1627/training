package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.List;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoList;
import org.apache.commons.lang.StringUtils;

public final class DiligentSearchList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

/*
       * JSP Name:     Diligent Search List
       * Created by:   Anand Kundrapu
       * Date Created: 12/18/06
       *
       * Description:
       * Diligent Search List Page
       *  */
      /* Change History:
       Date      User              Description
       --------  ----------------  -----------------------------------------------
       12/18/06  Anand Kundrapu        Initial page creation
       */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
  int size = 0;
  List<DiligentSearchInfoList> dsilist = new ArrayList<DiligentSearchInfoList>();
  int personIdSearch = 0;
  int personIdDetail = 0;
  String pageMode = null;
  String personIdForPullback =null;
  

//***********************************
 //*** RETRIEVE HIDDEN STATE FIELD ***
 //***********************************
 BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
                                                        
                                                        
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************                                                           

 DiligentSearchInfoRetrieveSO dsiretso = (DiligentSearchInfoRetrieveSO) state.getAttribute("DiligentSearchInfoRetrieveSO", request);
 if(dsiretso != null && dsiretso.getDsiBeanList()!=null)
 {
    dsilist = dsiretso.getDsiBeanList();
    size = dsilist.size();
  }
   personIdSearch = GlobalData.getUlIdPerson(request);
   personIdForPullback = StringUtils.defaultString(dsiretso.getPersonIdForPullback());

   int loopCount = 0;
   String tabindexString = (String) request.getAttribute("tabIndex");
   int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
   

  //*********************
  //*** SET PAGE MODE ***
  //*********************
   pageMode = PageModeConstants.EDIT;
   if (PageMode.getPageMode(request) != null) {
     pageMode = PageMode.getPageMode(request);
   }

  
      out.write("\r\n\r\n\r\n");
//******************
  //*** JAVASCRIPT ***
  //******************
 
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\r\n //Message for when a user wants to delete a needs outcomes and gives the user an alert, the if the\r\n  //radio button was not selected by the user.\r\n  function Copy()\r\n  {\r\n    var cont;\r\n    if( checkForSelection('document.frmDiligentSearchList.rbDiligentList'))\r\n     {\r\n        cont = true;\r\n     }else{\r\n         alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) );
      out.write("');\r\n         cont = false;\r\n    }\r\n    return cont;\r\n  }\r\n\r\n  \r\n //Allows for the needs outcomes to be selected out of the radio button\r\n  function checkForSelection( objName )\r\n  {\r\n    var buttonChecked = false;\r\n    var obj = eval(objName);\r\n\r\n    if (obj != null)\r\n    {\r\n      if (obj.length == null)\r\n      {\r\n        if (obj.checked != false)\r\n          buttonChecked = true;\r\n      }\r\n      else\r\n      {\r\n        for (var i = 0; i < obj.length; ++i)\r\n        {\r\n          buttonChecked = buttonChecked || obj[i].checked;\r\n        }\r\n      }\r\n    }\r\n\r\n  return (buttonChecked);\r\n} \r\n    \r\n  \r\n    function submitDiligentSearch(idDiligentSearch)\r\n    {\r\n    document.frmDiligentSearchList.hdnIdDiligentSearch.value = idDiligentSearch;\r\n    submitValidateForm( \"frmDiligentSearchList\", \"/person/DiligentSearch/displayDiligentSearchInfo\" );\r\n  }\r\n    \r\n  </script>\r\n\r\n\r\n\r\n");
  //**************************
    //**** FORM STARTS HERE ****
    //**************************

 
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmDiligentSearchList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/DiligentSearch/displayDiligentSearchList");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n  <input type=\"hidden\" name=\"hdnPersonIdForPullback\" value=\"");
          out.print(personIdForPullback);
          out.write("\" />\r\n  <input type=\"hidden\" name=\"hdnPersonIdSearch\" value=\"");
          out.print(personIdSearch);
          out.write("\" />\r\n  <input type=\"hidden\" name=\"hdnPersonIdDetail\" value=\"");
          out.print(personIdDetail);
          out.write("\" />\r\n  <input type=\"hidden\" name=\"hdnIdDiligentSearch\">\r\n\r\n\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/person/DiligentSearch/displayDiligentSearchList");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <table id=\"results1\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\r\n      <tr>\r\n        <td>\r\n          <div id=\"scroll3\" style=\"width:100%; height:220; overflow:auto\" class=\"tableBorderList\">\r\n            <table id=\"results\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n              <tr>\r\n                ");
 if(pageMode.equals(PageModeConstants.NEW_USING))
        { 
              out.write("\r\n                <th class=\"thList\"></th>\r\n                ");
 }
              out.write("\r\n\r\n                <th class=\"thList\">\r\n                  Name\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Child\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Caretaker\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Contacted\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Visitation\r\n                </th>\r\n                <th class=\"thList\">\r\n                  Placement\r\n                </th>\r\n              </tr>\r\n              ");
 if (size == 0) {
                          
              out.write("\r\n              <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n                <td colspan=\"10\">\r\n                  ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n                </td>\r\n              </tr>\r\n              ");
} else {

         for (Iterator<DiligentSearchInfoList> it = dsilist.iterator(); it.hasNext();) {
           DiligentSearchInfoList dsiRow = (DiligentSearchInfoList) it.next();
           String idDiligentSearch = String.valueOf( dsiRow.getIdDiligentSearchInfo());
           personIdDetail = dsiRow.getUlIdPersonDetail();  
           String nmPerson = dsiRow.getPersonName(); 
           String personSearchName = dsiRow.getPersonNameSearch();

      
              out.write("\r\n              <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1));
              out.write("\">\r\n                ");
 if(pageMode.equals(PageModeConstants.NEW_USING))
      { 
              out.write("\r\n                <td>\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_0.setType("radio");
              _jspx_th_impact_validateInput_0.setName("rbDiligentList");
              _jspx_th_impact_validateInput_0.setValue( idDiligentSearch);
              _jspx_th_impact_validateInput_0.setEditableMode( EditableMode.ALL );
              _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
              if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatString(nmPerson));
              out.write("\r\n                </td>\r\n                ");
 } else {
              out.write("\r\n                <td>\r\n                  <a href=\"javascript:submitDiligentSearch('");
              out.print( idDiligentSearch );
              out.write("')\">");
              out.print(nmPerson);
              out.write("</a>\r\n                </td>\r\n                ");
}
              out.write("\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatString(personSearchName));
              out.write("\r\n                </td>\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatString( dsiRow.getIndCaretakerPriorRemoval()));
              out.write("\r\n                </td>\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatString( dsiRow.getIndSuccContacted()));
              out.write("\r\n                </td>\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatString( dsiRow.getIndVisitationRsrc()));
              out.write("\r\n                </td>\r\n                <td>\r\n                  ");
              out.print(FormattingHelper.formatString( dsiRow.getIndPlcmtRsrc()));
              out.write("\r\n                </td>\r\n\r\n              </tr>\r\n              ");
loopCount++;
          } // end while enumeration has more elements
        } //end big else
    

      
              out.write("\r\n            </table>\r\n          </div>\r\n        </td>\r\n      </tr>\r\n    </table>\r\n\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td width=\"70%\">\r\n        &nbsp;\r\n      </td>\r\n      ");
  if ((!pageMode.equals(PageModeConstants.VIEW)) && (!pageMode.equals(PageModeConstants.NEW_USING))) { 
          out.write("\r\n      \r\n        ");
          out.write("\r\n          <td>\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnCopy");
          _jspx_th_impact_ButtonTag_0.setImg("btnCopy");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmDiligentSearchList");
          _jspx_th_impact_ButtonTag_0.setAction("/person/DiligentSearch/copyDiligentInfo");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        ");
          out.write(" \r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmDiligentSearchList");
          _jspx_th_impact_ButtonTag_1.setAction("/person/DiligentSearch/retrievePerson");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
} else if(pageMode.equals(PageModeConstants.NEW_USING)) {
             if (size > 0) {
      
          out.write("\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnContinue");
          _jspx_th_impact_ButtonTag_2.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmDiligentSearchList");
          _jspx_th_impact_ButtonTag_2.setAction("/person/DiligentSearch/displayDiligentSearchInfo");
          _jspx_th_impact_ButtonTag_2.setFunction("return Copy()");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n      ");

             } 
      }
      
          out.write("\r\n    </tr>\r\n  </table>\r\n\r\n  <br>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">\r\n      Forms\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode("2");
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Diligent Search Report Form");
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("fcm03o00");
          _jspx_th_impact_document_0.setDocExists(true);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n           ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pCase");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pPerson");
              _jspx_th_impact_documentParameter_2.setValue( String.valueOf(GlobalData.getUlIdPerson(request)) );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
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
