package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckConversation;
import java.util.Hashtable;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class RecordsCheckDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
       * JSP Name:     RecordsCheckDetail
       * Created by:   Katy Laura
       * Date Created: 11/27/02
       * Description:
       * This JSP called from the Records Check List page using the Add button or
       * the Search Type hyperlink.  The Search Type hyperlink prefills the page
       * with data, the Add button presents an empty form.
       *
       **/
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       SPB               SIR 19056 - Remove Automatic population of Complete date
       This is incorrect, as there was no record returned from the DPS batch.
       If the completed date is filled, the user may think that
       the row in the results listbox (no records exist/no hit returned)
       means that no history was found.
       08/06/03  Todd Reser        Added Changelog.
       08/29/03  Todd Reser        SIR 19550 - Added cnfrmDelete(), added delete
       button code.
       10/15/04  CORLEYAN          SIR 23210 - Two new Check Types have been added,
       FBI Exigent Check, and DPS Direct Check.  These
       rows are not deletable, and require that type be
       disabled after initial save.
       1/14/2005 gerryc            SIR 23242 - added a narrative for the EBC background
       check types (see SIR 23210).  This narrative button
       will only display for those with the correct security
       and for those EBC types.  The page needs to be saved
       before the button displays.  The records check id
       is now used to retrieve the record from state instead
       of the array index, because this page reloads after
       saving the two EBC types, and the index was not
       matching after that.  After saving this page for
       an EBC type, the page reloads.
       08/16/2005 Nallavs          SIR 23379 -- Added code for setting indicator
       to display check mark besides narrative button if
       narrative exists for given id_record_check.
       08/30/2010  bgehlot     SMS 66380 Added Help link which opens Policy Help Page
       */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");

      //*******************************
      //*** SET NARRATIVE INDICATOR ***
      //*******************************
      // SIR 23379 -- Setting Record Check Narrative checkmark for display or not.
      boolean indicator = false;
      if (ArchitectureConstants.TRUE.equals(request.getAttribute(RecordsCheckConversation.DOCEXISTS))) {
        indicator = true;
      }

      
      out.write("\r\n\r\n");
BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      String pageMode = PageModeConstants.VIEW;
      //If the mode was set in the activity method, get it
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      if (request.getParameter("hdnPageMode") != null && !"".equals(request.getParameter("hdnPageMode"))) {
        pageMode = request.getParameter("hdnPageMode");
        state.setAttribute("pageMode", pageMode, request);
      } else {
        pageMode = (String) state.getAttribute("pageMode", request);
      }

      int tabIndex = 1;
      ROWCCFC26SOG00 recordsCheckRow = new ROWCCFC26SOG00();
      if (pageMode.equals(PageModeConstants.NEW)) {
        // prefill values for adding a new row in the save method
        // when adding records, the user id becomes the jsp's requested by: and id_rec_check_requestor
        recordsCheckRow.setSzScrNmRequestedBy(userProfile.getUserFullName());
        recordsCheckRow.setUlIdRecCheckRequestor(userProfile.getUserID());
      } else {
        CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
        //int index = ContextHelper.getIntSafe(request, "hdnIndex");

        //SIR 23242 - instead of using the index to get the records check row, use
        //the id of the records check.  This solves the problems of the page
        //re-displaying for EBC types.
        int ulIdRecCheck = 0;
        if (request.getAttribute("txtUlIdRecCheck") != null) {
          //this is set into the attributes in the conversation after saving an EBC
          //Records Check Detail page.
          ulIdRecCheck = Integer.parseInt((String) request.getAttribute("txtUlIdRecCheck"));
        } else if (request.getParameter("hdnUlIdRecCheck") != null
                   && !"".equals(request.getParameter("hdnUlIdRecCheck"))) {
          //this is passed from the Records Check List page, or reloaded from
          //this page in case of a validation error.
          ulIdRecCheck = ContextHelper.getIntSafe(request, "hdnUlIdRecCheck");
        }
        //end SIR 23242

        if (ccfc26so == null) {
          ccfc26so = new CCFC26SO();
        }
        ROWCCFC26SOG00_ARRAY listArray = new ROWCCFC26SOG00_ARRAY();
        if (ccfc26so.getROWCCFC26SOG00_ARRAY() != null) {
          listArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
        }

        for (Enumeration listArrayEnum = listArray.enumerateROWCCFC26SOG00(); listArrayEnum.hasMoreElements();) {
          ROWCCFC26SOG00 rowccfc26sog00 = (ROWCCFC26SOG00) listArrayEnum.nextElement();
          if (ulIdRecCheck == rowccfc26sog00.getUlIdRecCheck()) {
            recordsCheckRow = rowccfc26sog00;
            break;
          }
        }

        //end SIR 23242

        if (recordsCheckRow == null) {
          recordsCheckRow = new ROWCCFC26SOG00();
        }
      }
      boolean bDisabled = false;
      //boolean bDisableDate = false;
      boolean bDeletable = true;
      //boolean bResultsDisabled = true;
      //boolean bDisableType = false;
      boolean bEBCNarrativeDisabled = true; //23242

      String recCheckId = FormattingHelper.formatInt(recordsCheckRow.getUlIdRecCheck());
      String dtRequest = FormattingHelper.formatDate(recordsCheckRow.getDtDtRecCheckRequest());
      if (dtRequest == "") {
        dtRequest = FormattingHelper.formatDate(DateHelper.getTodayCastorDate());
      }
      String history_Yes = "false";
      String history_No = "false";
      String dtCompleted = FormattingHelper.formatDate(recordsCheckRow.getDtDtRecCheckCompleted());
      String ind_history = recordsCheckRow.getCIndRecCheckHistory();
      if ("N".equals(ind_history)) {
        history_No = "true";
      } else {
        history_Yes = "true";
      }

      String userName = StringHelper.getNonNullString(recordsCheckRow.getSzScrNmRequestedBy());
      String txtCdSearchType = StringHelper.getNonNullString(recordsCheckRow.getSzCdRecCheckCheckType());
      String txtOfComments = StringHelper.getNonNullString(recordsCheckRow.getSzTxtRecCheckComments());
      
      String selDtFingerprintCardGiven = FormattingHelper.formatDate(recordsCheckRow.getSelDtFingerprintCardGiven());
      String selDtFingerprintCardReturn = FormattingHelper.formatDate(recordsCheckRow.getSelDtFingerprintCardReturn());
      String selDtCriminalReleaseReceived = FormattingHelper.formatDate(recordsCheckRow.getSelDtCriminalReleaseReceived());
      String selDtLiveScanPerformed = FormattingHelper.formatDate(recordsCheckRow.getSelDtLiveScanPerformed());
      String selDtLiveScanResultReceived = FormattingHelper.formatDate(recordsCheckRow.getSelDtLiveScanResultReceived());
      
      String refusedForInvestigation_yes = "false";
      String refusedForInvestigation_no = "false";
      String rb_refuseSignCriminalInvestigationClearance = recordsCheckRow.getRbRefuseSignInvestigationClearance();
      if("N".equals(rb_refuseSignCriminalInvestigationClearance)){
        refusedForInvestigation_no = "true";
      } else {
        refusedForInvestigation_yes = "true";
      }
      
      String fpOutcome_positive = "false";
      String fpOutcome_negative = "false";
      String rb_FingerPrintCkResult = recordsCheckRow.getRbFingerPrintCkResult();
      if("N".equals(rb_FingerPrintCkResult)){
        fpOutcome_negative = "true";
      } else {
        fpOutcome_positive = "true";
      }
      
      String recm_approved = "false";
      String recm_disapproved = "false";
      String recm_conditional = "false";
      String rb_Recommendation = recordsCheckRow.getRbRecommendation();
      if("A".equals(rb_Recommendation)){
        recm_approved = "true";
      }
      else if("D".equals(rb_Recommendation)){
        recm_disapproved = "true";
      } 
      else
      {
        recm_conditional = "true";
      }
      
      String obtainedByFpCard = "";
      String cb_FingerprintCard = recordsCheckRow.getCbFingerprintCard();
      if("Y".equals(cb_FingerprintCard)){
        obtainedByFpCard = "Y";
      }
      String obtainedByLiveScan = "";
      String cb_LiveScan = recordsCheckRow.getCbLiveScan();
      if("Y".equals(cb_LiveScan)){
        obtainedByLiveScan = "Y";
      }
      
      if (("10".equals(txtCdSearchType)) || ("20".equals(txtCdSearchType)) || ("85".equals(txtCdSearchType))) {
        // if dps, central registry or FPS History type, only the comments should be enabled; disable the search type field
        //bDisableDate = true;
      }
      // SIR 23210 - If DPS Criminal History/10, Central Registry/85, FPS History Check/20,
      // DPS Direct Check/25, or FBI Exigent Check/15 type, do not allow the record to be deleted
      // or the type to be changed
      if ("10".equals(txtCdSearchType) || "20".equals(txtCdSearchType) || "85".equals(txtCdSearchType)
          || "25".equals(txtCdSearchType) || "15".equals(txtCdSearchType)) {
        bDeletable = false;
        //bDisableType = true;
      }

      if ("10".equals(txtCdSearchType) && StringHelper.isValid(recordsCheckRow.getSzCdRecCheckStatus())) { // only DPS records check have Results.  Show results if type = 10, show the Results btn
        // also have to check that there is a status - SIR 22349
        //bResultsDisabled = false;
      }

      //SIR 23242 - only show the narrative button if the pagemode isn't new or view
      //and if it's an EBC type (FBI Exigent or DPS Direct)
      if (!pageMode.equals(PageModeConstants.NEW) && !pageMode.equals(PageModeConstants.VIEW)
          && (txtCdSearchType.equals(CodesTables.CCHKTYPE_15) || txtCdSearchType.equals(CodesTables.CCHKTYPE_25))) {
        bEBCNarrativeDisabled = false;
      }

      if (pageMode.equals(PageModeConstants.VIEW)) {
        //bResultsDisabled = true;
      }

      
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n// if the user is adding a new dps request, the dtCompleted must be set to null\r\n function rePopulateDtCompleted()\r\n        {\r\n           //Check to see if the search type is dps, value 10\r\n           if(frmRecordsCheckDetail.selCdSearchType.options.value == '10')\r\n           {\r\n              //Clear the selDtCompleted - Call the populateDropdown method (from impact.js) to attach the codes table.\r\n              frmRecordsCheckDetail.selDtCompleted.value='' ;\r\n           }\r\n          else\r\n          {\r\n        frmRecordsCheckDetail.selDtCompleted.value='");
      out.print( FormattingHelper.formatDate( DateHelper.getTodayCastorDate() ) );
      out.write("';\r\n          }\r\n   }\r\n\r\n\r\n//  Called onUnload of page to remind user unsaved data will be lost\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n\r\n");
 /* SIR 19550 - Added function to confirm delete */ 
      out.write("\r\nfunction cnfrmDelete()\r\n{\r\n return confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\" );\r\n}\r\n\r\nfunction openSecondWindow(url, name, w, h)\r\n{\r\n  // Fudge factors for window decoration space.\r\n  // In my tests these work well on all platforms & browsers.\r\n  w += 32;\r\n  h += 96;\r\n  wleft = (screen.width - w) / 2;\r\n  wtop = (screen.height - h) / 2;\r\n  var win;\r\n  try {\r\n    win = window.open(url,\r\n      name,\r\n      'width=' + w + ', height=' + h + ', ' +\r\n      'left=' + wleft + ', top=' + wtop + ', ' +\r\n      'location=no, menubar=no, ' +\r\n      'status=no, toolbar=no, scrollbars=yes, resizable=yes');\r\n  } catch(e1) {\r\n    //alert(\"Opening URL:\\n\"+e1.message);\r\n  }\r\n  \r\n  try {\r\n    // Just in case width and height are ignored\r\n    win.resizeTo(w, h);\r\n  } catch(e2) {\r\n    //alert(\"Resizing window:\\n\"+e2.message);\r\n  }\r\n  \r\n  try {\r\n    // Just in case left and top are ignored\r\n    win.moveTo(wleft, wtop);\r\n  } catch(e3) {\r\n    //alert(\"Moving window:\\n\"+e3.message);\r\n  }\r\n  \r\n  try {\r\n    win.focus();\r\n  } catch(e4) {\r\n    //alert(\"Setting focus:\\n\"+e4.message);\r\n  }\r\n}\r\n\r\nfunction displayRecordsCheckPolicy() {\r\n");
      out.write("  var descriptor = \"\";\r\n  descriptor += \"width=500,\";\r\n  descriptor += \"height=800,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=0,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=0,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=0,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=0,\";\r\n  descriptor += \"toolbar=0,\";\r\n  descriptor += \"left=725,\";\r\n  descriptor += \"top=0\"; \r\n  return window.open('/person/RecordsCheck/displayRecordsCheckHelp', \"DFCS_FACILITY_DESC\", descriptor);\r\n }\r\n\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmRecordsCheckDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/RecordsCheck/saveRecordsCheckDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("txtUlIdRecCheck");
          _jspx_th_impact_validateInput_0.setValue( recCheckId );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnUlIdRecCheck");
          _jspx_th_impact_validateInput_1.setValue( recCheckId );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Records Check Detail\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      ");
// ExcludeOptions for NEW ( added )prs history check and central registry request.
      //  These rows can only be added when the user launches a new report on the Records Check
      //  List page.
      Hashtable<String, String> excludeList = new Hashtable<String, String>();
      if (pageMode.equals(PageModeConstants.NEW)) {
        excludeList.put("FPS History Check", "20");
        excludeList.put("Central Registry", "85");
      }
      // If the pagemode is modify and the type is deletable, do not allow the user to change from a
      //  deletable type to a Non deletable type, exclude those options from the dropdown.
      if (pageMode.equals(PageModeConstants.MODIFY) && bDeletable) {
        excludeList.put("DPS Criminal History", "10");
        excludeList.put("FPS History Check", "20");
        excludeList.put("Central Registry", "85");
        excludeList.put("DPS Direct Check", "25");
        excludeList.put("FBI Exigent Check", "15");
      }

      
          out.write("\r\n      <td width=\"15%\">\r\n      ");
 if (pageMode.equals(PageModeConstants.NEW)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }
          out.write("\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( bDisabled ));
          _jspx_th_impact_validateSelect_0.setExcludeOptions( excludeList.values() );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setName("selCdSearchType");
          _jspx_th_impact_validateSelect_0.setLabel("Search Type");
          _jspx_th_impact_validateSelect_0.setCodesTable("CCHKTYPE");
          _jspx_th_impact_validateSelect_0.setWidth("25%");
          _jspx_th_impact_validateSelect_0.setValue(  txtCdSearchType );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          &nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"displayRecordsCheckPolicy()\">?</a></strong>\r\n      </td>\r\n      <td colspan=\"3\" width=\"25%\" class=\"formLabel\">\r\n        History&nbsp;&nbsp;\r\n      ");
 if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setLabel("Yes");
          _jspx_th_impact_validateInput_2.setId("History_Yes");
          _jspx_th_impact_validateInput_2.setName("rbHistory");
          _jspx_th_impact_validateInput_2.setDisabled( String.valueOf( bDisabled ));
          _jspx_th_impact_validateInput_2.setValue("Y");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setChecked( history_Yes );
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setLabel("No");
          _jspx_th_impact_validateInput_3.setId("History_No");
          _jspx_th_impact_validateInput_3.setName("rbHistory");
          _jspx_th_impact_validateInput_3.setDisabled( String.valueOf( bDisabled ));
          _jspx_th_impact_validateInput_3.setValue("N");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setChecked( history_No );
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n\r\n      <td>\r\n      ");
 if (pageMode.equals(PageModeConstants.NEW)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }
          out.write("\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setDisabled( String.valueOf( bDisabled ) );
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue( dtRequest );
          _jspx_th_impact_validateDate_0.setName("selDtRequest");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setLabel("Date of Request");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n      <td>\r\n      ");
 if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }
          out.write("\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setDisabled( String.valueOf( bDisabled ) );
          _jspx_th_impact_validateDate_1.setValue( dtCompleted );
          _jspx_th_impact_validateDate_1.setName("selDtCompleted");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setLabel("Date Completed");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("selRequestorName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Requested By");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( userName );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
          out.write("\r\n    <tr>\r\n      <td>\r\n      ");
 if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) {
            bDisabled = false;            
      } else {
          bDisabled = true;
      }
          out.write("\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("selComments");
          _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf( bDisabled ));
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setColspan("3");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("75");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(500);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(txtOfComments);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    </table>\r\n");

    boolean showFingerPrint = false;
    if(!pageMode.equals(PageModeConstants.NEW)&& (txtCdSearchType.equals(CodesTables.CCHKTYPE_GC) || txtCdSearchType.equals(CodesTables.CCHKTYPE_NC)))
    {
        showFingerPrint = true;
    }

          out.write("      \r\n");
  if(showFingerPrint)
    {

          out.write("    \r\n    <br/>\r\n    ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("FingerprintCheck");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Fingerprint Check");
          _jspx_th_impact_ExpandableSectionTag_0.setId("ctSearchOpen");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_2.setName("selDtCriminalReleaseReceived");
              _jspx_th_impact_validateDate_2.setValue( selDtCriminalReleaseReceived );
              _jspx_th_impact_validateDate_2.setLabel("Date Criminal Release Received");
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              _jspx_th_impact_validateDate_2.setConditionallyRequired("false");
              _jspx_th_impact_validateDate_2.setSize("10");
              _jspx_th_impact_validateDate_2.setColspan("3");
              _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td colspan=\"4\" class=\"formLabel\">How were fingerprints obtained?&nbsp;&nbsp;\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_4.setChecked( obtainedByFpCard );
              _jspx_th_impact_validateInput_4.setValue("Y");
              _jspx_th_impact_validateInput_4.setType("checkbox");
              _jspx_th_impact_validateInput_4.setName("cbFingerprintCard");
              _jspx_th_impact_validateInput_4.setLabel("Fingerprint Card");
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_5.setChecked( obtainedByLiveScan );
              _jspx_th_impact_validateInput_5.setValue("Y");
              _jspx_th_impact_validateInput_5.setType("checkbox");
              _jspx_th_impact_validateInput_5.setName("cbLiveScan");
              _jspx_th_impact_validateInput_5.setLabel("Live Scan");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_3.setSize("10");
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              _jspx_th_impact_validateDate_3.setRequired("false");
              _jspx_th_impact_validateDate_3.setWidth("20%");
              _jspx_th_impact_validateDate_3.setValue( selDtFingerprintCardGiven );
              _jspx_th_impact_validateDate_3.setName("selDtFingerprintCardGiven");
              _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_3.setLabel("Date fingerprint cards were given to the household member");
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_4.setSize("10");
              _jspx_th_impact_validateDate_4.setConstraint("Date");
              _jspx_th_impact_validateDate_4.setRequired("false");
              _jspx_th_impact_validateDate_4.setWidth("20%");
              _jspx_th_impact_validateDate_4.setValue( selDtLiveScanPerformed );
              _jspx_th_impact_validateDate_4.setName("selDtLiveScanPerformed");
              _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_4.setLabel("Date live scan was performed for household member");
              int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
              if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_5.setSize("10");
              _jspx_th_impact_validateDate_5.setConstraint("Date");
              _jspx_th_impact_validateDate_5.setRequired("false");
              _jspx_th_impact_validateDate_5.setValue( selDtFingerprintCardReturn );
              _jspx_th_impact_validateDate_5.setName("selDtFingerprintCardReturn");
              _jspx_th_impact_validateDate_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_5.setLabel("Date fingerprint cards were returned");
              int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
              if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_6.setSize("10");
              _jspx_th_impact_validateDate_6.setConstraint("Date");
              _jspx_th_impact_validateDate_6.setRequired("false");
              _jspx_th_impact_validateDate_6.setValue( selDtLiveScanResultReceived );
              _jspx_th_impact_validateDate_6.setName("selDtLiveScanResultReceived");
              _jspx_th_impact_validateDate_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_6.setLabel("Date results of the live scan was received");
              int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
              if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td colspan=\"4\" class=\"formLabel\">Did the client refuse to sign the criminal investigation clearance?&nbsp;&nbsp;\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setType("radio");
              _jspx_th_impact_validateInput_6.setLabel("Yes");
              _jspx_th_impact_validateInput_6.setName("rbRefuseSignInvestigationClearance");
              _jspx_th_impact_validateInput_6.setValue("Y");
              _jspx_th_impact_validateInput_6.setChecked( refusedForInvestigation_yes );
              _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setType("radio");
              _jspx_th_impact_validateInput_7.setLabel("No");
              _jspx_th_impact_validateInput_7.setName("rbRefuseSignInvestigationClearance");
              _jspx_th_impact_validateInput_7.setValue("N");
              _jspx_th_impact_validateInput_7.setChecked( refusedForInvestigation_no );
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td colspan=\"4\" class=\"formLabel\">What was the outcome of the fingerprint check?&nbsp;&nbsp;\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_8.setType("radio");
              _jspx_th_impact_validateInput_8.setLabel("Negative");
              _jspx_th_impact_validateInput_8.setName("rbFingerPrintCkResult");
              _jspx_th_impact_validateInput_8.setValue("N");
              _jspx_th_impact_validateInput_8.setChecked( fpOutcome_negative );
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_9.setType("radio");
              _jspx_th_impact_validateInput_9.setLabel("Positive");
              _jspx_th_impact_validateInput_9.setName("rbFingerPrintCkResult");
              _jspx_th_impact_validateInput_9.setValue("P");
              _jspx_th_impact_validateInput_9.setChecked( fpOutcome_positive );
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td colspan=\"4\" class=\"formLabel\">Recommendation:&nbsp;&nbsp;\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setType("radio");
              _jspx_th_impact_validateInput_10.setLabel("Approved");
              _jspx_th_impact_validateInput_10.setName("rbRecommendation");
              _jspx_th_impact_validateInput_10.setValue("A");
              _jspx_th_impact_validateInput_10.setChecked( recm_approved );
              _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_11.setType("radio");
              _jspx_th_impact_validateInput_11.setLabel("Disapproved");
              _jspx_th_impact_validateInput_11.setName("rbRecommendation");
              _jspx_th_impact_validateInput_11.setValue("D");
              _jspx_th_impact_validateInput_11.setChecked( recm_disapproved );
              _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_12.setType("radio");
              _jspx_th_impact_validateInput_12.setLabel("Conditional");
              _jspx_th_impact_validateInput_12.setName("rbRecommendation");
              _jspx_th_impact_validateInput_12.setValue("C");
              _jspx_th_impact_validateInput_12.setChecked( recm_conditional );
              _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      </table>\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    }

          out.write("\r\n  <br>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n    <tr>\r\n\r\n      <th colspan=\"3\">\r\n        External Records Checks\r\n      </th>\r\n\r\n    </tr>\r\n    <tr>\r\n    ");
 if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) { 
          out.write("   \r\n      <td width=\"33%\" >\r\n        <a href=\"http://services.georgia.gov/gbi/gbisor/SORSearch.jsp\" target=\"windowName\"\r\n           tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\"\r\n           onclick=\"openSecondWindow('http://services.georgia.gov/gbi/gbisor/SORSearch.jsp',\r\n                                     'windowName', 800, 600); return false;\">GBI Sex Offender Registry</a>\r\n      </td>\r\n      <td width=\"33%\">\r\n        <a href=\"http://www.pap.state.ga.us/opencms/opencms/home/parolee_datbase\" target=\"windowName\"\r\n           tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\"\r\n           onclick=\"openSecondWindow('http://www.pap.state.ga.us/opencms/opencms/home/parolee_datbase',\r\n                                     'windowName', 800, 600); return false;\">Board of Pardons and Parole</a>\r\n      </td>\r\n      <td width=\"33%\">\r\n        <a href=\"http://www.dcor.state.ga.us/GDC/OffenderQuery/jsp/OffQryForm.jsp\" target=\"windowName\"\r\n           tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\"\r\n           onclick=\"openSecondWindow('http://www.dcor.state.ga.us/GDC/OffenderQuery/jsp/OffQryForm.jsp',\r\n                                     'windowName', 800, 450); return false;\">Department of Corrections Offender Query</a>\r\n      </td>\r\n      ");
}
          out.write("\r\n    </tr>\r\n\r\n  </table>\r\n  <br />\r\n  <br />\r\n  ");
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td width=\"80%\">\r\n        \r\n      </td>\r\n      <td class=\"alignRight\" width=\"10%\">\r\n      </td>\r\n      \r\n      ");
 if (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.MODIFY)) { 
          out.write(" \r\n      <td class=\"alignRight\" width=\"10%s\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setForm("frmRecordsCheckDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/person/RecordsCheck/saveRecordsCheckDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
}
          out.write("\r\n    </tr>\r\n\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnIndex");
          _jspx_th_impact_validateInput_13.setValue( request.getParameter ("hdnIndex"));
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
/* SPB SIR 22349 - Need to propagate szCdRecCheckStatus from List through Criminal History */

      
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnCdCheckType");
          _jspx_th_impact_validateInput_14.setValue( request.getParameter ("hdnCdCheckType"));
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("hdnDtRequest");
          _jspx_th_impact_validateInput_15.setValue( request.getParameter ("hdnDtRequest"));
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("hdnDtCompleted");
          _jspx_th_impact_validateInput_16.setValue( request.getParameter ("hdnDtCompleted"));
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("hdnComments");
          _jspx_th_impact_validateInput_17.setValue( request.getParameter ("hdnComments"));
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("txtSubjectName");
          _jspx_th_impact_validateInput_18.setValue( request.getParameter ("txtSubjectName"));
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("dtExactDOB");
          _jspx_th_impact_validateInput_19.setValue( request.getParameter("dtExactDOB"));
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("txtGender");
          _jspx_th_impact_validateInput_20.setValue( request.getParameter("txtGender"));
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("txtRaceEthnicity");
          _jspx_th_impact_validateInput_21.setValue( request.getParameter("txtRaceEthnicity"));
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n    ");
      out.write("\r\n    ");
if (!bEBCNarrativeDisabled) {
      out.write("\r\n    <tr>\r\n      <td>\r\n        ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n          ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("EBC Narrative");
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setName("frmDocument");
          _jspx_th_impact_document_0.setCheckStage( GlobalData.getUlIdStage( request )  );
          _jspx_th_impact_document_0.setProtectDocument(false);
          _jspx_th_impact_document_0.setDocType("EBC");
          _jspx_th_impact_document_0.setDocExists(indicator );
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sIdRecCheck");
              _jspx_th_impact_documentParameter_0.setValue( recCheckId );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    ");
}

    
      out.write("\r\n  </table>");
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
