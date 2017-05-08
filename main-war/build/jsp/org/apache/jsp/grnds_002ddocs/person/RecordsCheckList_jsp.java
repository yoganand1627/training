package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

public final class RecordsCheckList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*  JSP Name:     RecordsCheckList
      //*  Created by:   Katy Laura
      //*  Date Created: 11/18/02
      //*
      //*  Description:
      //*  This JSP is the initial page of the RecordsCheck Conversation
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       08/06/03  Todd Reser        Added Changelog.
       10/14/04  CORLEYAN          SIR 23210 - Two new Records Check Types,
       DPS Direct Check, and FBI Exigent Check cannot be deleted.
       1/14/2005 gerryc            SIR 23242 - pass the records check id to the records
       check detail page and the criminal history detail
       page.  This records check id is used instead of the
       index to get the details out of state.
       11/08/2010                  SMS#79230: Removed Delete button  and the check boxes 
       */

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      // The mode was set in state in the display activity method
      String pageMode = (String) state.getAttribute("pageMode", request);
      if (pageMode == null) {
        pageMode = PageModeConstants.VIEW;
      }
      // display the Results hyperlink if pageMode is Modify
      boolean bResultsDisabled = true;
      if (pageMode.equals(PageModeConstants.MODIFY)) {
        bResultsDisabled = false;
      } else {
        bResultsDisabled = true;
      }
      // display the delete button if there are rows to delete - (loopCount - count of rows which can not be deleted > 0)
      boolean bDisplayDelete = false;
      CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
      ROWCCFC26SOG00_ARRAY recordsCheckListArray = null;

      if (ccfc26so == null) {
        ccfc26so = new CCFC26SO();
      }
      //null catch for row objects, if not null, get rows
      if (ccfc26so.getROWCCFC26SOG00_ARRAY() != null) {
        recordsCheckListArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
      } else {
        recordsCheckListArray = new ROWCCFC26SOG00_ARRAY();
      }

      int tabIndex = 1;

      // prepare for creating a new RC row, from the central registry launch
      String showDocumentParameter = null;

      if (request.getParameter("docType") != null) {
        showDocumentParameter = "frmDocumentTag";
      }

      UserProfile user = UserProfileHelper.getUserProfile(request);

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n    // begin javascript portion of central registry new row and launch\r\n    // get the date in mm/dd/yyyy format for the new RC row from the central registry launch\r\n  function setDates()\r\n  {\r\n   var today2 = new Date();\r\n   yy = today2.getYear();\r\n   year = (yy < 1000) ? yy + 1900 : yy;\r\n   var dt = today2.getMonth()+1 + \"/\" + today2.getDate() + \"/\" + year;\r\n   // set the hidden fields for pass to saveRCdetail_xa\r\n   document.all.frmDocumentTag.selDtCompleted.value = dt;\r\n   document.all.frmDocumentTag.selDtRequest.value = dt;\r\n   return true;\r\n  }  //end javascript portion of central registry new row and launch\r\n\r\n\r\n// tell the Criminal History jsp which index of the records check rows is the dps value the user wants to see\r\n// SIR 23242 - added the record check id to the parameters\r\nfunction passFieldsToCrmnlHstry( index, dtReq, dtComp, type, id )\r\n{\r\n  frmRecordsCheckList.hdnIndex.value = index;\r\n  frmRecordsCheckList.hdnType.value = type;\r\n  frmRecordsCheckList.hdnDtReq.value = dtReq;\r\n");
      out.write("  frmRecordsCheckList.hdnDtComp.value = dtComp;\r\n  frmRecordsCheckList.hdnUlIdRecCheck.value = id;\r\n  submitValidateForm('frmRecordsCheckList', '/person/RecordsCheck/displayCriminalHistory');\r\n}\r\n\r\n// tell the Records Check Detail page which index of the records check rows is the dps row the user wants to see\r\n// SIR 23242 - added the record check id to the parameters\r\n  function passFieldsToRcrdChckDtl( index, type, dtReq, dtComp, id )\r\n{\r\n  frmRecordsCheckList.hdnIndex.value = index;\r\n  frmRecordsCheckList.hdnType.value = type;\r\n  frmRecordsCheckList.hdnDtReq.value = dtReq;\r\n  frmRecordsCheckList.hdnDtComp.value = dtComp;\r\n  frmRecordsCheckList.hdnUlIdRecCheck.value = id;\r\n  submitValidateForm('frmRecordsCheckList', '/person/RecordsCheck/displayRecordsCheckDetail');\r\n}\r\n\r\n\r\nfunction addRecordsCheckList()\r\n{\r\n  frmRecordsCheckList.hdnPageMode.value = ");
      out.print(PageModeConstants.NEW);
      out.write(";\r\n  return true;\r\n}\r\n\r\n\r\nfunction cnfrmDelete()\r\n{\r\n return confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\" );\r\n}\r\n\r\n</script>\r\n\r\n\r\n");
/* Start the RecordsCheckList form*/

      try {// java script with window.onbefore used to confirm data will be lost if user exits before saving


      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nwindow.onload = function ()\r\n{\r\n  frmRecordsCheckList.hdnPageMode.value = \"\";\r\n}\r\n\r\n// set data to be used by the saveRCdetail_xa to write a new PRS History row to the records check table, part of launch report\r\nfunction addPRSRecordsCheck()\r\n{\r\n  // if the report launched is the PRS History Check (the first option)\r\n  // then add a PRS History Check row to the RecordsCheck List\r\n   if ( Reports.report_CLEAN.options[1].value == Reports.report_CLEAN.value )\r\n   {\r\n    thisForm = document.frmRecordsCheckList;\r\n\r\n    // get the date in mm/dd/yyyy format\r\n    var today = new Date();\r\n    yy = today.getYear();\r\n    year = (yy < 1000) ? yy + 1900 : yy;\r\n    var dt = today.getMonth()+1 + \"/\" + today.getDate() + \"/\" + year;\r\n\r\n    // set the hidden fields\r\n    thisForm.selCdSearchType.value= \"");
      out.print( CodesTables.CCHKTYPE_20 );
      out.write("\";\r\n    thisForm.selDtCompleted.value = dt;\r\n    thisForm.selDtRequest.value = dt;\r\n    thisForm.hdnCalledFromJavascript.value = \"true\";\r\n\r\n    // submit the forms\r\n    window.onbeforeunload=null;\r\n    submitValidateForm( \"frmRecordsCheckList\", \"/person/RecordsCheck/saveRecordsCheckDetail\");\r\n  }\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmRecordsCheckList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/RecordsCheck/displayRecordsCheckList");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckListCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
/* SPB SIR 22349 - Need to propagate szCdRecCheckStatus from List through Criminal History */

        
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");
// begin pagination
    TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean) request
            .getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

    if (tuxPagination != null) {
      DatabaseResultDetails db = tuxPagination.getResultDetails();
    } else {
      tuxPagination = new TuxedoPaginationValueBean();
      DatabaseResultDetails db = new DatabaseResultDetails();
      db.setNumberOfResults(0);
      db.setResultsPerPage(10);
      db.setRequestedPage(1);
      tuxPagination.setResultDetails(db);
      request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
    }

  
          out.write("\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/person/RecordsCheck/displayRecordsCheckList");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              out.write("\r\n    ");
              out.write("\r\n    <div id=\"scroll\" style=\"height:210px;width:100%;overflow:auto\" class=\"tableBorderList\">\r\n      ");
              out.write("\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n        <tr>\r\n          <th class=\"thList\">\r\n          </th>\r\n          <th class=\"thList\">\r\n            Search Type\r\n          </th>\r\n          <th class=\"thList\">\r\n            Date of Request\r\n          </th>\r\n          <th class=\"thList\">\r\n            Date Completed\r\n          </th>\r\n          <th class=\"thList\">\r\n            Requested By\r\n          </th>\r\n          <th class=\"thList\">\r\n            History\r\n          </th>\r\n        </tr>\r\n\r\n        ");
// within the table, display the data
        //declare and initialize loop counter
        int loopCount = 0;
        int canNotDeleteCount = 0;
        //Enumerate the records check rows
        Enumeration recordsCheckListEnum = recordsCheckListArray.enumerateROWCCFC26SOG00();
        //If the enumeration is empty return NO Rows returned message
        if (!recordsCheckListEnum.hasMoreElements()) {

          
              out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"7\">\r\n            ");
              out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");
} // else there is a least one row.  While there are more rows,
        // create a new rows and display the data

        else {
          while (recordsCheckListEnum.hasMoreElements()) { // get the next element
            ROWCCFC26SOG00 recordsCheckListRow = (ROWCCFC26SOG00) recordsCheckListEnum.nextElement();

            // create the cells and place the elements in them

            
              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n\r\n          <td>\r\n            ");
// write an if to show the check box or radio button only if the type of row is other than DPS, Central Registry or PRS History
            // define a boolean to protect DPS, Central Registry and PRS History rows from deletion
            boolean bTheRowCanBeDeleted = true;
            bTheRowCanBeDeleted = false; //SMS79230 Do not need to display the check boxes at all as the delete button has been removed
            // set theRowCanBeDeleted to false if the row type is DPS/10 or Central Registry/85 or PRS HISTORY CHECK/20
            // SIR 23210 Two new records check types, FBI Exigent Check/15 and DPS Direct Check/25 cannot be deleted.
             if ( "10".equals(recordsCheckListRow.getSzCdRecCheckCheckType())
                || "20".equals(recordsCheckListRow.getSzCdRecCheckCheckType())
                || "85".equals(recordsCheckListRow.getSzCdRecCheckCheckType())
                || "15".equals(recordsCheckListRow.getSzCdRecCheckCheckType())
                || "25".equals(recordsCheckListRow.getSzCdRecCheckCheckType())) {
              bTheRowCanBeDeleted = false;
              canNotDeleteCount = canNotDeleteCount + 1;
            }

            if (bTheRowCanBeDeleted)

            { // if the row can be deleted place a checkbox on the screen- ktl ckbox name _CLEAN prevents previous and next message when a check box has been selected
              String chckBoxName = "ckName_CLEAN" + loopCount;

              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_11.setValue( String.valueOf(loopCount));
              _jspx_th_impact_validateInput_11.setType("checkbox");
              _jspx_th_impact_validateInput_11.setChecked("false");
              _jspx_th_impact_validateInput_11.setName( chckBoxName );
              _jspx_th_impact_validateInput_11.setLabel("");
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
;
            }

            
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
/* SPB SIR 22349 - Need to propagate szCdRecCheckStatus from List through Criminal History */

            
              out.write("\r\n            <a\r\n              href=\"javascript: passFieldsToRcrdChckDtl('");
              out.print( loopCount );
              out.write('\'');
              out.write(',');
              out.write('\'');
              out.print( FormattingHelper.formatString( recordsCheckListRow.getSzCdRecCheckStatus() ) );
              out.write("', '");
              out.print( FormattingHelper.formatDate(recordsCheckListRow.getDtDtRecCheckRequest())  );
              out.write("', '");
              out.print( FormattingHelper.formatDate(recordsCheckListRow.getDtDtRecCheckCompleted()) );
              out.write('\'');
              out.write(',');
              out.write('\'');
              out.print(FormattingHelper.formatInt(recordsCheckListRow.getUlIdRecCheck()));
              out.write("' )\">\r\n              ");
              out.print(Lookup.simpleDecodeSafe("CCHKTYPE", recordsCheckListRow.getSzCdRecCheckCheckType()));
              out.write(" </a>\r\n          </td>\r\n          <td>\r\n            ");
              out.print(FormattingHelper.formatDate(recordsCheckListRow.getDtDtRecCheckRequest()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(FormattingHelper.formatDate(recordsCheckListRow.getDtDtRecCheckCompleted()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(FormattingHelper.formatString(recordsCheckListRow.getSzScrNmRequestedBy()));
              out.write("\r\n          </td>\r\n\r\n          <td align=\"center\">\r\n            ");
              out.print(recordsCheckListRow.getCIndRecCheckHistory().equals(ArchitectureConstants.Y) ? "<image alt=\"checkmark\" src='/grnds-docs/images/shared/checkMark_short.gif'>"
                                                                                                       : "&nbsp;");
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");
// increment the loop counter
            loopCount++;
          } // end while
        }
        // If the loopCount is 0 or all of the rows can not be deleted, do not display the delete button
        if (loopCount - canNotDeleteCount > 0) {
          bDisplayDelete = true;
        }
        bDisplayDelete = false; //SMS#79230
        
              out.write("\r\n      </table>\r\n    </div>\r\n    ");
/* this is where the "scrollBar" div tag ends */

        
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td class=\"alignLeft\">\r\n        ");
if (bDisplayDelete) {

          
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setForm("frmRecordsCheckList");
          _jspx_th_impact_ButtonTag_0.setFunction("return cnfrmDelete( )");
          _jspx_th_impact_ButtonTag_0.setAction("/person/RecordsCheck/deleteRecordsCheckList");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
}

        
          out.write("\r\n      </td>\r\n\r\n\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmRecordsCheckList");
          _jspx_th_impact_ButtonTag_1.setFunction("return addRecordsCheckList()");
          _jspx_th_impact_ButtonTag_1.setAction("/person/RecordsCheck/addRecordsCheckList");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n\r\n    </tr>\r\n  </table>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<br />\r\n\r\n");

      } catch (Exception e) {
        e.printStackTrace();
        out.println(e.getMessage());
      }

    
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
    _jspx_th_impact_validateInput_0.setName("hdnIndex");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_1.setName("hdnType");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnDtReq");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnDtComp");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("hdnUlIdRecCheck");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnMaxLoopCount");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("selCdSearchType");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("selDtCompleted");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("selDtRequest");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnCalledFromJavascript");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("hdnPageMode");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
