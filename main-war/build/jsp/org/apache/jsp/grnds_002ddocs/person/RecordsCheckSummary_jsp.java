package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Croleall;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Crelvict;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cchktype;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckPersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecordsCheckSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

public final class RecordsCheckSummary_jsp extends org.apache.jasper.runtime.HttpJspBase
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
       * Records Check Summary (Summary View, Add-By-Person View, Add-By-Type View)
       * Author: Corey Harden
       * Date: 06/03/2011
       * 
       * 					Change History
       *
       *   Date          User				              Description
       * --------  ----------------  --------------------------------------------------
       * 06/29/11  cwells			  113723 Added logic to display 10 checks for children with no DOB
       * 07/07/11  hnguyen           SMS#113889: Fixed issue with selected History checkbox not persisting after validation error.
       * 07/07/11  hnguyen           SMS#114348: Removed Requested By maxlength constraint to fix name truncation.
       *
       *
       *
   */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // get the state map
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  // retrieve the Service Out (SO) object from the request
  RecordsCheckSummarySO recordsCheckSummarySO = (RecordsCheckSummarySO) request.getAttribute("recordsCheckSummarySO");

  // get list of person data for each principle on the stage
  @SuppressWarnings("unchecked")
  List<RecordsCheckPersonBean> personList = recordsCheckSummarySO.getPersonList();

  // get list of Records Check types required for each age group
  Map<String, List<String>> ageTypeMap = recordsCheckSummarySO.getAgeTypeMap();

  // this map is of type Map<Integer, Map<String, RecordsCheckBean>>
  @SuppressWarnings("unchecked")
  Map<Integer, Map> filteredListsMap = recordsCheckSummarySO.getFilteredListsMap();

  // list of person id's
  List<Integer> personIdList = recordsCheckSummarySO.getPersonIdList();

  // get the user profile for display rule logic
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // get map containing list of missing types and a map of persons missing those types
  @SuppressWarnings("unchecked")
  Map missingMap = recordsCheckSummarySO.getMissingTypesMap();
  
  // get map used to determine if a person has history
  Map<Integer, Map<String, Boolean>> historyMap = recordsCheckSummarySO.getHistoryMap();

  // get list of missing types
  @SuppressWarnings("unchecked")
  List<String> missingTypesList = (List<String>) missingMap.get(recordsCheckSummarySO.getMissingTypesList());

  // get map of missing types to persons
  @SuppressWarnings("unchecked")
  Map<String, Map<Integer, RecordsCheckBean>> missingTypesMap = (Map<String, Map<Integer, RecordsCheckBean>>) missingMap.get(recordsCheckSummarySO.getMissingTypesToPerson());
  
  // get the add-by type from the request
  String addType = (String) request.getAttribute("addType");

  // get map of Records Check website url's
  Map<String, String> rcSiteMap = recordsCheckSummarySO.getRcSiteMap();

  // create date for auto population of date of request fields
  String today = DateHelper.toString(new Date(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING));

  // get the primary key of the stage
  int ulIdStage = GlobalData.getUlIdStage(request);

  // use stage id to determine whether the current user has access to the stage
  boolean hasStageAccess = CaseUtility.hasStageAccess(user.getUserID(), ulIdStage);

  // create page mode variable based on stage access
  String pageMode = hasStageAccess ? PageModeConstants.MODIFY : PageModeConstants.INQUIRE;

  // get the current person
  RecordsCheckPersonBean addPerson = new RecordsCheckPersonBean();

  // loop thru list to match person
  for (RecordsCheckPersonBean tempPerson : personList) {
    // match the person id's
    if ((GlobalData.getUlIdPerson(request)) == (tempPerson.getPersonId())) {
      // set the current person and break outta loop
      addPerson = tempPerson;
      break;
    }
  }

      out.write("\r\n\r\n\r\n\r\n<!-- JAVASCRIPT SECTION -->\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\t/**\r\n\t* This function pre-populates the Request date of the passed-in element when triggered\r\n\t* @param elem - the element whose value to update with the current date\r\n\t*/\r\n\tfunction prePopulateRequestDate(id){\r\n\t\tvar val = document.getElementById(id).value;\r\n\t\tif('' == val){\r\n\t\t\tdocument.getElementById(id).value = document.getElementById('hdnDate').value;\r\n\t\t}\r\n\t}\r\n\t\r\n\t/**\r\n\t* This function sets the number of rows into a hidden variable for later retrieval\r\n\t* @param count - the number of rows\r\n\t*/\r\n\tfunction setTrackCount(count){\r\n\t\tdocument.getElementById('hdnRowCount').value = count;\r\n\t}\r\n\t\r\n\t/**\r\n\t* This function is responsible for writing out an informational message to the user\r\n\t* when there are no missing records checks to display.\r\n\t* @param count - the number of rows displayed on the page\r\n");
      out.write("\t*/\r\n\tfunction isInformationalNeeded(count){\r\n\t\tif(count == 1){\r\n\t\t\tvar message = '");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_REC_ALL_COMPLETED));
      out.write("';\r\n\t\t\tvar inform = '<table width=\"100%\" style=\"background-color: #FFFF7E; height: 60px\"><tr><td align=\"center\"><b><font color=\"blue\" size=\"2\">' + message + '</font></b></td></tr></table>';\r\n\t\t\tdocument.getElementById('informational').innerHTML = inform;\r\n\t\t\tdocument.getElementById('btnSave_Id').style.visibility = 'hidden';\r\n\t\t\tdocument.getElementById('headerRow').style.visibility = 'hidden';\r\n\t\t}\r\n\t}\r\n\t\r\n\t/**\r\n\t* This function sets data into hidden fields and submits the form to display\r\n\t* the Reoords Check detail page\r\n\t* @param index - the index of the Record Check\r\n\t* @param type - the type of the Records Check\r\n\t* @param dtReq - the date of Request of the Records Check\r\n\t* @param dtComp - the date of Completion of the Records Check\r\n\t* @param id - the primary key of the Records Check\r\n\t* @param personId - the primary key of the person\r\n\t* @param name - the full name of the person\r\n\t*/\r\n   function passFieldsToRcrdChckDtl( index, type, dtReq, dtComp, id, personId, name) {\r\n  \t\tdocument.getElementById('hdnIndex').value = index;\r\n");
      out.write("  \t\tdocument.getElementById('hdnType').value = type;\r\n  \t\tdocument.getElementById('hdnDtReq').value = dtReq;\r\n  \t\tdocument.getElementById('hdnDtComp').value = dtComp;\r\n  \t\tdocument.getElementById('hdnUlIdRecCheck').value = id;\r\n  \t\tdocument.getElementById('hdnIdPerson').value = personId;\r\n\t\tdocument.getElementById('hdnNmPerson').value = name;\r\n  \t\tsubmitValidateForm('frmRecordsCheckSummaryList', '/person/RecordsCheckSummary/displayRecordsCheckDetail');\r\n\t}\r\n\t\r\n\t/**\r\n\t* This function adds data to hidden variables and submits the summary list form\r\n\t* @param personId - the id of the person\r\n\t* @param name - the name of the person\r\n\t*/\r\n\tfunction displayRecordsCheckList(personId, name){\r\n\t\tdocument.getElementById('hdnIdPerson').value = personId;\r\n\t\tdocument.getElementById('hdnNmPerson').value = name;\r\n\t\tsubmitValidateForm('frmRecordsCheckSummaryList', '/person/RecordsCheckSummary/displayRecordsCheckList');\r\n\t}\r\n\t\r\n\tfunction disableDropdown(radioBtn){\r\n\t\tvar elem = document.getElementById('selPersonByIdRecCheckPerson_id');\r\n");
      out.write("\t\tif('addBySearchType' == radioBtn){\r\n\t\t\telem.disabled = true;\r\n\t\t}else{\r\n\t\t\telem.disabled = false;\r\n\t\t}\r\n\t}\r\n\t\t\r\n\t\r\n</script>\r\n<!-- END JAVASCRIPT SECTION -->\r\n\r\n\r\n\r\n<!-- ERROR DISPLAY AREA -->\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n<!-- END ERROR DISPLAY AREA -->\r\n\r\n\r\n<!-- INFORMATIONAL MESSAGE AREA -->\r\n<div id=\"informational\"></div>\r\n<!-- END INFORMATIONAL MESSAGE AREA -->\r\n\r\n\r\n\r\n\r\n<!-- ------------------------------------------------------BEGIN RECORDS CHECK SUMMARY VIEW---------------------------------------------- -->\r\n");

  if (addType == null) {

      out.write("\r\n<!-- ADD RECORDS CHECK BY TYPE AREA -->\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmRecordsCheckSummaryAdd");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/RecordsCheckSummary/addRequiredRecordsCheck");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckSummaryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode("pageMode");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setId("hdnIdStage");
          _jspx_th_impact_validateInput_0.setName("hdnIdStage");
          _jspx_th_impact_validateInput_0.setValue( GlobalData.getUlIdStageAsString(request) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setId("hdnIdCase");
          _jspx_th_impact_validateInput_1.setName("hdnIdCase");
          _jspx_th_impact_validateInput_1.setValue( GlobalData.getUlIdCaseAsString(request) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

  if (PageModeConstants.MODIFY.equals(pageMode) && !personList.isEmpty()) {

          out.write("\r\n\t<div style=\"border: solid black 1px; width: 100%\">\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tAdd Records Check\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"odd\" valign=\"top\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table cellspacing=\"10\" cellpadding=\"3\">\r\n\t\t\t\t\t\t<tr style=\"border-bottom: solid black 1px;\">\r\n\t\t\t\t\t\t\t<!-- this is the radio button section to select the add type -->\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<input id=\"addByPerson\" type=\"radio\" tabIndex=\"1\" value=\"addByPerson\" onclick=\"disableDropdown('addByPerson')\" name=\"add_type\">\r\n\t\t\t\t\t\t\t\tAdd By Person\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<input id=\"addBySearchType\" checked type=\"radio\" tabIndex=\"1\" value=\"addBySearchType\" onclick=\"disableDropdown('addBySearchType')\" name=\"add_type\">\r\n\t\t\t\t\t\t\t\tAdd By Search Type\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr style=\"border-top: solid black 1px\">\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<!-- create dropdown list of persons to Add by -->\r\n\t\t\t\t\t\t\t\t<select title=\"Program Area\" tabindex=\"12\" disabled id=\"selPersonByIdRecCheckPerson_id\" name=\"selPersonByIdRecCheckPerson\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option value=\"\"></option>\r\n\t\t\t\t\t\t\t\t\t<!-- create a java loop here to loop thru the list of persons and add each person to the dropdown  -->\r\n\t\t\t\t\t\t\t\t\t");

									  for (RecordsCheckPersonBean person : personList) {
									
          out.write("\r\n\t\t\t\t\t\t\t\t\t<option value=\"");
          out.print(person.getPersonId());
          out.write("\">\r\n\t\t\t\t\t\t\t\t\t\t");
          out.print(person.getDisplayNameFull());
          out.write("\r\n\t\t\t\t\t\t\t\t\t</option>\r\n\t\t\t\t\t\t\t\t\t");

									  }
									
          out.write("\r\n\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<!-- create add button -->\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<input border=\"0\" type=\"image\" onclick=\"\" alt=\"Add\" name=\"btnAdd\" src=\"/grnds-docs/images/shared/btnAdd.gif\" id=\"btnAdd_Id\" tabindex=\"8\" class=\"md\">\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\t<p>&nbsp</p>\r\n");

  }

          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<!-- END ADD RECORDS CHECK BY TYPE AREA -->\r\n\r\n\r\n\r\n\r\n\r\n<!-- RECORDS CHECK LIST AREA -->\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmRecordsCheckSummaryList");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/person/RecordsCheckSummary/displayRecordsCheckList");
      _jspx_th_impact_validateForm_1.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckSummaryCustomValidation");
      _jspx_th_impact_validateForm_1.setPageMode("");
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');

  for (RecordsCheckPersonBean person : personList) {

          out.write("\r\n    <div style=\"width: 100%;\">\r\n    \t<table style=\"width: 100%; position: relative; top: 20px\">\r\n    \t\t<tr style=\" background-color: white; height: 30px\">\r\n    \t\t\t<td>\r\n    \t\t\t\t<span>\r\n    \t\t\t\t\t<b>Name: ");
          out.print(person.getDisplayNameFull());
          out.write(" | Person ID: ");
          out.print(person.getPersonId());
          out.write(' ');
          out.write('|');
          out.write(' ');
          out.print(person.getCdStagePersonType());
          out.write(' ');
          out.write('|');
          out.write(' ');
          out.print(Lookup.simpleDecodeSafe(Crelvict.CRELVICT, person.getCdStagePersRelInt()));
          out.write(' ');
          out.write('|');
          out.write(' ');
          out.print(person.getAge());
          out.write(' ');
          out.write('|');
          out.write(' ');
          out.print(Lookup.simpleDecode(Croleall.CROLEALL, person.getCdStagePersonRole()));
          out.write("</b>\r\n    \t\t\t\t</span>\t\r\n    \t\t\t</td>\r\n    \t\t\t<td width=\"70px\"></td>\r\n    \t\t\t<td>\r\n    \t\t\t\t<a href=\"javascript: displayRecordsCheckList('");
          out.print( person.getPersonId() );
          out.write("', '");
          out.print( person.getDisplayNameFull() );
          out.write("')\">view all</a>\r\n    \t\t\t</td>\r\n    \t\t</tr>\r\n    \t</table>\r\n    \t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" style=\"width: 100%; height: 40px; position: relative; top: 20px\">\r\n    \t\t<tr>\r\n    \t\t\t<th class=\"thList\">\r\n\t\t\t\t\tSearch Type\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tDate of Request\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tDate Completed\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tRequested By\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tHistory\r\n\t\t\t\t</th>\r\n    \t\t</tr>\r\n    \t");

    	  //determine required Records Check types by person age
    	  // SMS 113723 If the Person does not have an age then we are checking for 10 records 
    	  
    	      List<String> tempTypeListByAge = person.getAge() < 17 && person.getDateOfBirth() != null ? ageTypeMap.get(recordsCheckSummarySO.getLtSeventeen()) : ageTypeMap.get(recordsCheckSummarySO.getGtSeventeen());

    	      //get map of Records Checks for person
    	      @SuppressWarnings("unchecked")
    	      Map<String, RecordsCheckBean> recordsCheckMap = filteredListsMap.get(person.getPersonId());

    	      //create counter to alternate row coloring
    	      int rowCount = 1;

    	      //check for existence of Records Check types for each person
    	      if (recordsCheckMap.isEmpty()) {
    	        //loop thru list to write out missing Records Checks
    	        for (String str : tempTypeListByAge) {
    	
          out.write("\r\n    \t<!-- DISPLAY ALL REQUIRED RECORDS CHECKS AS MISSING -->\r\n    \t\t<tr class=");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write(" style=\"position: relative; top: 20px\">\r\n    \t\t\t<td style=\"color: red\">");
          out.print(Lookup.simpleDecode(Cchktype.CCHKTYPE, str));
          out.write("</td>\r\n    \t\t\t<td></td>\r\n    \t\t\t<td></td>\r\n    \t\t\t<td></td>\r\n    \t\t\t<td></td>\r\n    \t\t</tr>\r\n    \t<!-- END DISPLAY ALL REQUIRED RECORDS CHECKS AS MISSING -->\r\n    \t");

    	  rowCount++;
    	        }
    	        rowCount = 1;
    	      } else {
    	        //loop thru list to pull out each Records Check required type to write out missing checks
    	        for (String str : tempTypeListByAge) {
    	          //check for existence of Records Check
    	          if (!recordsCheckMap.containsKey(str)) {
    	
          out.write("\r\n    \t<!-- DISPLAY MISSING RECORDS CHECKS IN ROWS -->\r\n    \t\t<tr class=");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write(" style=\"position: relative; top: 20px\">\r\n    \t\t\t<td style=\"color: red\">");
          out.print(Lookup.simpleDecode(Cchktype.CCHKTYPE, str));
          out.write("</td>\r\n    \t\t\t<td></td>\r\n    \t\t\t<td></td>\r\n    \t\t\t<td></td>\r\n    \t\t\t<td></td>\r\n    \t\t</tr>\r\n\t\t");

					rowCount++;
				}else if(recordsCheckMap.get(str).getDtRecCheckCompleted() == null){
					//retrieve Records Check record from map
    	            RecordsCheckBean rcBean = recordsCheckMap.get(str);
		
          out.write("\r\n    \t\t<tr class=");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write(" style=\"position: relative; top: 20px\">\r\n    \t\t\t<td style=\"color: red\">");
          out.print(Lookup.simpleDecode(Cchktype.CCHKTYPE, str));
          out.write("</td>\r\n    \t\t\t<td>");
          out.print(DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)));
          out.write("</td>\r\n    \t\t\t<td>");
          out.print(DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)));
          out.write("</td>\r\n    \t\t\t<td>");
          out.print(rcBean.getPersonByIdRecCheckRequestor());
          out.write("</td>\r\n    \t");

    	  if (ArchitectureConstants.Y.equals(rcBean.getIndReccheckHistory())) {
    	
          out.write("\r\n    \t\t\t<td align=\"center\"><img src=\"/grnds-docs/images/shared/checkMark.gif\" /></td>\r\n    \t");

    	  } else {
    	
          out.write("\r\n    \t \t\t<td></td>\r\n    \t");

    	  }
    	
          out.write("\r\n    \t\t</tr>\r\n    \t<!-- END DISPLAY MISSING RECORDS CHECKS IN ROWS -->\r\n    \t");

    	  rowCount++;
    	          }
    	        }
    	        //loop thru list again to pull out each Records Check required type to write out completed checks
    	        for (String str : tempTypeListByAge) {
    	          //check for existence of Records Check
    	          if (recordsCheckMap.containsKey(str) && recordsCheckMap.get(str).getDtRecCheckCompleted() != null) {
    	            //retrieve Records Check record from map
    	            RecordsCheckBean rcBean = recordsCheckMap.get(str);
    	
          out.write("\r\n    \t<!-- POPULATE COMPLETED RECORDS CHECK ROWS -->\r\n    \t\t<tr class=");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write(" style=\"position: relative; top: 20px\">\r\n    \t\t\t<td><a href=\"javascript: passFieldsToRcrdChckDtl( '");
          out.print( rowCount );
          out.write("', '");
          out.print( str );
          out.write("', '");
          out.print(DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)));
          out.write("', '");
          out.print(DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)));
          out.write("', '");
          out.print( rcBean.getIdRecCheck() );
          out.write("', '");
          out.print( person.getPersonId() );
          out.write("', '");
          out.print( person.getDisplayNameFull() );
          out.write("' )\">");
          out.print(Lookup.simpleDecode(Cchktype.CCHKTYPE, str));
          out.write("</a></td>\r\n    \t\t\t<td>");
          out.print(DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)));
          out.write("</td>\r\n    \t\t\t<td>");
          out.print(DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)));
          out.write("</td>\r\n    \t\t\t<td>");
          out.print(rcBean.getPersonByIdRecCheckRequestor());
          out.write("</td>\r\n    \t");

    	  if (ArchitectureConstants.Y.equals(rcBean.getIndReccheckHistory())) {
    	
          out.write("\r\n    \t\t\t<td align=\"center\"><img src=\"/grnds-docs/images/shared/checkMark.gif\" /></td>\r\n    \t");

    	  } else {
    	
          out.write("\r\n    \t \t\t<td></td>\r\n    \t");

    	  }
    	
          out.write("\r\n    \t\t</tr>\r\n    \t<!-- END POPULATE COMPLETED RECORDS CHECK ROWS -->\r\n    \t");

    	  rowCount++;
    	          }
    	        }
    	      }
    	
          out.write("\r\n    \t</table>\r\n    </div>\r\n    <p>&nbsp</p><p>&nbsp</p><p>&nbsp</p>\r\n");

  }

          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<!-- END RECORDS CHECK LIST AREA -->\r\n");

  }

  // -- ------------------------------------------------------END RECORDS CHECK SUMMARY VIEW------------------------------------------------







  // ------------------------------------------------------BEGIN RECORDS CHECK SUMMARY ADD BY TYPE VIEW-------------------------------------

  else if ("addBySearchType".equals(addType)) {

      out.write("\r\n<div style=\"border-top: solid 2px gray; width: 100%;\"></div>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_2.setParent(null);
      _jspx_th_impact_validateForm_2.setName("frmRecordsCheckSummaryAddByType");
      _jspx_th_impact_validateForm_2.setMethod("post");
      _jspx_th_impact_validateForm_2.setAction("/person/RecordsCheckSummary/saveRecordsCheckSummary");
      _jspx_th_impact_validateForm_2.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckSummaryCustomValidation");
      _jspx_th_impact_validateForm_2.setPageMode( pageMode );
      _jspx_th_impact_validateForm_2.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_2 = _jspx_th_impact_validateForm_2.doStartTag();
      if (_jspx_eval_impact_validateForm_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_9.setId("hdnDate");
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnDate");
          _jspx_th_impact_validateInput_9.setValue( today );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_2, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_11.setId("hdnType");
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnType");
          _jspx_th_impact_validateInput_11.setValue( addType );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  //create counters to alternate row coloring and track records
      int rowCount = 0;
      int trackCount = 1;

      // loop thru the missing types to build a table for each
      for (String type : missingTypesList) {
        //reset counter
        rowCount = 1;

        // get map of persons to Records Check records
        Map<Integer, RecordsCheckBean> recordsMap = missingTypesMap.get(type);

          out.write("\r\n    <div style=\"width: 100%;\">\r\n    \t<table style=\"width: 80%; position: relative; top: 20px\">\r\n    \t\t<tr style=\" background-color: white; height: 30px\">\r\n    \t\t\t<td>\r\n    \t\t\t\t<span>\r\n    \t\t\t\t\t<b>Name: ");
          out.print(Lookup.simpleDecode(Cchktype.CCHKTYPE, type));
          out.write('\r');
          out.write('\n');

  // if there is a url for this type, write out a link to the type's website
  if (rcSiteMap.containsKey(type)) {

          out.write("\r\n\t\t\t\t\t\t\t| <a href=\"");
          out.print(rcSiteMap.get(type));
          out.write("\" target=\"_blank\">link to website</a>\r\n");

  }

          out.write("    \t\t\t\r\n\t\t\t\t\t\t</b>\r\n    \t\t\t\t</span>\t\r\n    \t\t\t</td>\r\n    \t\t</tr>\r\n    \t</table>\r\n    \t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" style=\"width: 100%; position: relative; top: 20px\">\r\n    \t\t<tr id=\"headerRow\" style=\"background-color: #E2E1C3;\">\r\n    \t\t\t<th class=\"thList\">\r\n\t\t\t\t\tPerson\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tDate of Request\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tDate Completed\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tRequested By\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tHistory\r\n\t\t\t\t</th>\r\n    \t\t</tr>\r\n    \t");

    	  //loop thru list of persons to determine if they are missing the current type
    	        for (RecordsCheckPersonBean person : personList) {
    	          //get Records Check bean
    	          RecordsCheckBean rcBean = recordsMap.get(person.getPersonId());

				  // all saved Records Checks must have a date of request, so check date 
				  // of request to determine if this is a new or old Records Check
    	          if (rcBean != null && rcBean.getDtRecCheckRequest() == null) {
    	
          out.write("\r\n\t\t\t<tr class=\"");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write("\">\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_12.setId("hdnMetaData");
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName( "hdnMetaData" + trackCount );
          _jspx_th_impact_validateInput_12.setValue( type + "=" + trackCount + "&person=" + person.getPersonId() + "&requestor=" + user.getUserID() + "&idRecCheck=0" + "&personName=" + person.getDisplayNameFull() );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.print(person.getDisplayNameFull());
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setId("dtRecCheckRequest" + trackCount);
          _jspx_th_impact_validateInput_13.setOnFocus("prePopulateRequestDate(this.id)");
          _jspx_th_impact_validateInput_13.setName( "dtRecCheckRequest" + trackCount );
          _jspx_th_impact_validateInput_13.setValue("");
          _jspx_th_impact_validateInput_13.setMaxLength("10");
          _jspx_th_impact_validateInput_13.setSize("10");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setName( "dtRecCheckCompleted" + trackCount );
          _jspx_th_impact_validateInput_14.setValue("");
          _jspx_th_impact_validateInput_14.setMaxLength("10");
          _jspx_th_impact_validateInput_14.setSize("10");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_15.setId( "" + user.getUserID() );
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setName( "requestByFullName" + trackCount );
          _jspx_th_impact_validateInput_15.setValue( user.getUserFullName() );
          _jspx_th_impact_validateInput_15.setDisabled("true");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t        <td align=\"left\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_16.setType("checkbox");
          _jspx_th_impact_validateInput_16.setChecked("false");
          _jspx_th_impact_validateInput_16.setName( "indReccheckHistory" + trackCount );
          _jspx_th_impact_validateInput_16.setValue("Y");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write("\">\r\n\t\t\t\t<td colspan=\"4\">Comments: ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateTextArea_0.setMaxLength(500);
          _jspx_th_impact_validateTextArea_0.setCols("60");
          _jspx_th_impact_validateTextArea_0.setRows("2");
          _jspx_th_impact_validateTextArea_0.setName( "txtRecCheckComments" + trackCount );
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>&nbsp;</td>\r\n\t\t\t</tr>\r\n\t\t");

		  //increment counters
		            rowCount++;
		            trackCount++;
		          } else if (rcBean != null && rcBean.getDtRecCheckRequest() != null) {
		
          out.write("\r\n\t\t\t<tr class=\"");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write("\">\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_17.setId("hdnMetaData");
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName( "hdnMetaData" + trackCount );
          _jspx_th_impact_validateInput_17.setValue( type + "=" + trackCount + "&person=" + person.getPersonId() + "&requestor=" + rcBean.getPersonByIdRecCheckRequestor() + "&idRecCheck=" + rcBean.getIdRecCheck() + "&personName=" + person.getDisplayNameFull() );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.print(person.getDisplayNameFull());
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setId("dtRecCheckRequest" + trackCount);
          _jspx_th_impact_validateInput_18.setOnFocus("prePopulateRequestDate(this.id)");
          _jspx_th_impact_validateInput_18.setName( "dtRecCheckRequest" + trackCount );
          _jspx_th_impact_validateInput_18.setValue( rcBean.getDtRecCheckRequest() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) );
          _jspx_th_impact_validateInput_18.setMaxLength("10");
          _jspx_th_impact_validateInput_18.setSize("10");
          _jspx_th_impact_validateInput_18.setDisabled("true");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setName( "dtRecCheckCompleted" + trackCount );
          _jspx_th_impact_validateInput_19.setValue( rcBean.getDtRecCheckCompleted() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) );
          _jspx_th_impact_validateInput_19.setMaxLength("10");
          _jspx_th_impact_validateInput_19.setSize("10");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_20.setType("text");
          _jspx_th_impact_validateInput_20.setName( "requestByFullName" + trackCount );
          _jspx_th_impact_validateInput_20.setValue( rcBean.getRequestByFullName() );
          _jspx_th_impact_validateInput_20.setDisabled("true");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t");

		  // check to see if the person has any history in the Shines/DFCS  system
		  if (ArchitectureConstants.Y.equals(rcBean.getIndReccheckHistory())) {
		
          out.write("\r\n\t\t\t\t<td align=\"left\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_21.setType("checkbox");
          _jspx_th_impact_validateInput_21.setChecked("true");
          _jspx_th_impact_validateInput_21.setName( "indReccheckHistory" + trackCount );
          _jspx_th_impact_validateInput_21.setValue("Y");
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t");

		  } else {
		
          out.write("\r\n\t\t\t\t<td align=\"left\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateInput_22.setType("checkbox");
          _jspx_th_impact_validateInput_22.setChecked("false");
          _jspx_th_impact_validateInput_22.setName( "indReccheckHistory" + trackCount );
          _jspx_th_impact_validateInput_22.setValue("Y");
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t");

		  }
		
          out.write("\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write("\">\r\n\t\t\t\t<td colspan=\"4\">Comments: ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
          _jspx_th_impact_validateTextArea_1.setMaxLength(500);
          _jspx_th_impact_validateTextArea_1.setCols("60");
          _jspx_th_impact_validateTextArea_1.setRows("2");
          _jspx_th_impact_validateTextArea_1.setName( "txtRecCheckComments" + trackCount );
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write(' ');
              out.print(rcBean.getTxtRecCheckComments() == null ? "" : rcBean.getTxtRecCheckComments());
              out.write(' ');
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>&nbsp;</td>\r\n\t\t\t</tr>\r\n\t\t");

		            //increment counters
		            rowCount++;
		            trackCount++;
		          }
		        }
		
          out.write("\t\t\r\n\t\t\t<tr class=\"odd\">\r\n\t\t\t\t<td align=\"right\" colspan=\"6\">\r\n\t\t\t\t\t<input border=\"0\" type=\"image\" onclick=\"\" alt=\"Save\" name=\"btnSave\" src=\"/grnds-docs/images/shared/btnSave.gif\" id=\"btnSave_Id\" tabindex=\"8\" class=\"md\">\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\t\t\t\r\n    \t</table>\r\n    </div>\r\n    <p>&nbsp</p>\r\n");

  }

          out.write("\r\n\r\n<script>\r\nsetTrackCount('");
          out.print(String.valueOf(trackCount));
          out.write("');\r\nisInformationalNeeded(");
          out.print(trackCount);
          out.write(");\r\n</script>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<!-- END MISSING RECORDS CHECK LIST AREA -->\r\n\r\n");

  }

  //-- ---------------------------------------------------END RECORDS CHECK SUMMARY ADD BY TYPE VIEW---------------------------------------- 







  //-- ---------------------------------------------------BEGIN RECORDS CHECK SUMMARY ADD BY PERSON VIEW------------------------------------
  else if ("addByPerson".equals(addType)) {

      out.write("\r\n\r\n\r\n<!-- ADD RECORDS CHECK BY TYPE AREA -->\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_3.setParent(null);
      _jspx_th_impact_validateForm_3.setName("frmRecordsCheckSummaryAddByPerson");
      _jspx_th_impact_validateForm_3.setMethod("post");
      _jspx_th_impact_validateForm_3.setAction("/person/RecordsCheckSummary/saveRecordsCheckSummary");
      _jspx_th_impact_validateForm_3.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckSummaryCustomValidation");
      _jspx_th_impact_validateForm_3.setPageMode( pageMode );
      _jspx_th_impact_validateForm_3.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_3 = _jspx_th_impact_validateForm_3.doStartTag();
      if (_jspx_eval_impact_validateForm_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n  ");
          if (_jspx_meth_impact_validateInput_23(_jspx_th_impact_validateForm_3, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("hdnIdCase");
          _jspx_th_impact_validateInput_24.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("hdnIdStage");
          _jspx_th_impact_validateInput_25.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_26.setId("hdnDate");
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName("hdnDate");
          _jspx_th_impact_validateInput_26.setValue( today );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_27(_jspx_th_impact_validateForm_3, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_28.setType("hidden");
          _jspx_th_impact_validateInput_28.setId("hdnType");
          _jspx_th_impact_validateInput_28.setName("hdnType");
          _jspx_th_impact_validateInput_28.setValue( addType );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n");

  int trackCount = 1;

          out.write("\r\n    <div style=\"width: 100%; height: 100%\">\r\n    \t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" style=\"width: 100%; height: 40px; \">\r\n    \t\t<tr id=\"headerRow\" style=\"background-color: #E2E1C3;\">\r\n    \t\t\t<th class=\"thList\">\r\n\t\t\t\t\tSearch Type\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tDate of Request\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tDate Completed\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tRequested By\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tHistory\r\n\t\t\t\t</th>\r\n    \t\t</tr>\r\n    \t");

    	  //determine required Records Check types by person age
    	  // SMS 113723 If the Person does not have an age then we are checking for 10 records 
    	      List<String> tempTypeListByAge = addPerson.getAge() < 17 && addPerson.getDateOfBirth() != null ? ageTypeMap.get(recordsCheckSummarySO.getLtSeventeen()) : ageTypeMap.get(recordsCheckSummarySO.getGtSeventeen());

    	      //get map of Records Checks for person
    	      @SuppressWarnings("unchecked")
    	      Map<String, RecordsCheckBean> recordsCheckMap = filteredListsMap.get(addPerson.getPersonId());

    	      //create counter to alternate row coloring
    	      int rowCount = 1;

    	      //check for existence of Records Check types for each person
    	      if (recordsCheckMap.isEmpty()) {
    	        //loop thru list to write out missing Records Checks
    	        for (String str : tempTypeListByAge) {
    	
          out.write("\r\n    \t<!-- DISPLAY ALL REQUIRED RECORDS CHECKS AS MISSING -->\r\n    \t\t<tr class=\"");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write("\">\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_29.setId("hdnMetaData");
          _jspx_th_impact_validateInput_29.setType("hidden");
          _jspx_th_impact_validateInput_29.setName( "hdnMetaData" + trackCount );
          _jspx_th_impact_validateInput_29.setValue( str + "=" + trackCount + "&person=" + addPerson.getPersonId() + "&requestor=" + user.getUserID() + "&idRecCheck=0" + "&personName=" + addPerson.getDisplayNameFull() );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(' ');
          out.print(Lookup.simpleDecode(Cchktype.CCHKTYPE, str));
          out.write("\r\n\t\t\t\t");

				  if (rcSiteMap.containsKey(str)) {
				
          out.write("\r\n\t\t\t\t\t\t\t| <a href=\"");
          out.print(rcSiteMap.get(str));
          out.write("\" target=\"_blank\">link to website</a>\r\n\t\t");

		  }
		
          out.write("    \r\n\t\t\t\t</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_30.setType("text");
          _jspx_th_impact_validateInput_30.setName( "dtRecCheckRequest" + trackCount );
          _jspx_th_impact_validateInput_30.setValue("");
          _jspx_th_impact_validateInput_30.setMaxLength("10");
          _jspx_th_impact_validateInput_30.setSize("10");
          _jspx_th_impact_validateInput_30.setOnFocus("prePopulateRequestDate(this.id)");
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_31.setType("text");
          _jspx_th_impact_validateInput_31.setName( "dtRecCheckCompleted" + trackCount );
          _jspx_th_impact_validateInput_31.setValue("");
          _jspx_th_impact_validateInput_31.setMaxLength("10");
          _jspx_th_impact_validateInput_31.setSize("10");
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_32.setId( "" + user.getUserID() );
          _jspx_th_impact_validateInput_32.setType("text");
          _jspx_th_impact_validateInput_32.setName( "requestByFullName" + trackCount );
          _jspx_th_impact_validateInput_32.setValue( user.getUserFullName() );
          _jspx_th_impact_validateInput_32.setDisabled("true");
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td align=\"center\"><input type=\"checkbox\" name=\"");
          out.print("indReccheckHistory" + trackCount);
          out.write("\" value=\"Y\" /></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write("\">\r\n\t\t\t\t<td colspan=\"4\">Comments: ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateTextArea_2.setCols("60");
          _jspx_th_impact_validateTextArea_2.setRows("2");
          _jspx_th_impact_validateTextArea_2.setMaxLength(500);
          _jspx_th_impact_validateTextArea_2.setName( "txtRecCheckComments" + trackCount );
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>&nbsp;</td>\r\n\t\t\t</tr>\r\n    \t<!-- END DISPLAY ALL REQUIRED RECORDS CHECKS AS MISSING -->\r\n    \t");

    	  rowCount++;
    	          trackCount++;
    	        }
    	        rowCount = 1;
    	      } else {
    	        //loop thru list to pull out each Records Check required type to write out incomplete checks
    	        for (String str : tempTypeListByAge) {
    	          //check for existence of Records Check
    	          if (!recordsCheckMap.containsKey(str) || recordsCheckMap.get(str).getDtRecCheckCompleted() == null) {
    	            // get Records Check bean
    	            RecordsCheckBean rcBean = recordsCheckMap.get(str) != null ? recordsCheckMap.get(str)
    	                                                                      : new RecordsCheckBean();
    	
          out.write("\r\n    \t<!-- DISPLAY MISSING RECORDS CHECKS IN ROWS -->\r\n    \t\t<tr class=\"");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write("\">\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_33.setId("hdnMetaData");
          _jspx_th_impact_validateInput_33.setType("hidden");
          _jspx_th_impact_validateInput_33.setName( "hdnMetaData" + trackCount );
          _jspx_th_impact_validateInput_33.setValue( str + "=" + trackCount + "&person=" + addPerson.getPersonId() + "&requestor=" + (rcBean.getPersonByIdRecCheckRequestor() == 0 ? user.getUserID() : rcBean.getPersonByIdRecCheckRequestor()) + "&idRecCheck=" + (rcBean.getIdRecCheck() == null ? "0" : rcBean.getIdRecCheck()) + "&personName=" + addPerson.getDisplayNameFull() );
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(' ');
          out.print(Lookup.simpleDecode(Cchktype.CCHKTYPE, str));
          out.write("\r\n\t\t");

			if (rcSiteMap.containsKey(str)) {
		
          out.write("\r\n\t\t\t\t| <a href=\"");
          out.print(rcSiteMap.get(str));
          out.write("\" target=\"_blank\">link to website</a>\r\n\t\t");

		  }
		
          out.write("    \r\n\t\t\t\t</td>\r\n\t\t");

		  if (rcBean.getDtRecCheckRequest() == null) {
		
          out.write("\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_34.setType("text");
          _jspx_th_impact_validateInput_34.setName( "dtRecCheckRequest" + trackCount );
          _jspx_th_impact_validateInput_34.setValue( rcBean.getDtRecCheckRequest() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) );
          _jspx_th_impact_validateInput_34.setMaxLength("10");
          _jspx_th_impact_validateInput_34.setSize("10");
          _jspx_th_impact_validateInput_34.setOnFocus("prePopulateRequestDate(this.id)");
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t");

		  } else {
		
          out.write("\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_35.setType("text");
          _jspx_th_impact_validateInput_35.setName( "dtRecCheckRequest" + trackCount );
          _jspx_th_impact_validateInput_35.setDisabled("true");
          _jspx_th_impact_validateInput_35.setValue( rcBean.getDtRecCheckRequest() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) );
          _jspx_th_impact_validateInput_35.setMaxLength("10");
          _jspx_th_impact_validateInput_35.setSize("10");
          _jspx_th_impact_validateInput_35.setOnFocus("prePopulateRequestDate(this.id)");
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t");

		  }
		
          out.write("\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_36.setType("text");
          _jspx_th_impact_validateInput_36.setName( "dtRecCheckCompleted" + trackCount );
          _jspx_th_impact_validateInput_36.setValue( rcBean.getDtRecCheckCompleted() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) );
          _jspx_th_impact_validateInput_36.setMaxLength("10");
          _jspx_th_impact_validateInput_36.setSize("10");
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_37.setType("text");
          _jspx_th_impact_validateInput_37.setName( "requestByFullName" + trackCount );
          _jspx_th_impact_validateInput_37.setValue( rcBean.getRequestByFullName() == null ? user.getUserFullName() : rcBean.getRequestByFullName() );
          _jspx_th_impact_validateInput_37.setDisabled("true");
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t");

		  if (ArchitectureConstants.Y.equals(rcBean.getIndReccheckHistory())){
		
          out.write("\r\n\t\t\t\t<td align=\"center\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_38.setType("checkbox");
          _jspx_th_impact_validateInput_38.setChecked("true");
          _jspx_th_impact_validateInput_38.setName( "indReccheckHistory" + trackCount );
          _jspx_th_impact_validateInput_38.setValue("Y");
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t");

		  } else {
		
          out.write("\r\n\t\t\t\t<td align=\"center\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateInput_39.setType("checkbox");
          _jspx_th_impact_validateInput_39.setChecked("false");
          _jspx_th_impact_validateInput_39.setName( "indReccheckHistory" + trackCount );
          _jspx_th_impact_validateInput_39.setValue("Y");
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t");

		  }
		
          out.write("\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"");
          out.print(rowCount % 2 == 0 ? "even" : "odd");
          out.write("\">\r\n\t\t\t\t<td colspan=\"4\">Comments: ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
          _jspx_th_impact_validateTextArea_3.setMaxLength(500);
          _jspx_th_impact_validateTextArea_3.setCols("60");
          _jspx_th_impact_validateTextArea_3.setRows("2");
          _jspx_th_impact_validateTextArea_3.setName( "txtRecCheckComments" + trackCount );
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write(' ');
              out.print(rcBean.getTxtRecCheckComments() == null ? "" : rcBean.getTxtRecCheckComments());
              out.write(' ');
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t<td>&nbsp;</td>\r\n\t\t\t</tr>\r\n    \t<!-- END DISPLAY MISSING RECORDS CHECKS IN ROWS -->\r\n    \t");

    	  rowCount++;
    	            trackCount++;
    	          }
    	        }
    	      }
    	
          out.write("\r\n    \t\t<tr class=\"odd\">\r\n\t\t\t\t<td align=\"right\" colspan=\"6\">\r\n\t\t\t\t\t<input border=\"0\" type=\"image\" onclick=\"\" alt=\"Save\" name=\"btnSave\" src=\"/grnds-docs/images/shared/btnSave.gif\" id=\"btnSave_Id\" tabindex=\"8\" class=\"md\">\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n    \t</table>\r\n    </div>\r\n    <p>&nbsp</p>\r\n<script>\r\nsetTrackCount('");
          out.print(String.valueOf(trackCount));
          out.write("');\r\nisInformationalNeeded(");
          out.print(trackCount);
          out.write(");\r\n</script>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<!-- END ADD RECORDS CHECK BY TYPE AREA -->\r\n\r\n");

  }
  //-- --------------------------------------------------END RECORDS CHECK SUMMARY ADD BY PERSON VIEW---------------------------------------

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

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setId("hdnIdPerson");
    _jspx_th_impact_validateInput_2.setName("hdnIdPerson");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setId("hdnNmPerson");
    _jspx_th_impact_validateInput_3.setName("hdnNmPerson");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setId("hdnIndex");
    _jspx_th_impact_validateInput_4.setName("hdnIndex");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setId("hdnType");
    _jspx_th_impact_validateInput_5.setName("hdnType");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setId("hdnDtReq");
    _jspx_th_impact_validateInput_6.setName("hdnDtReq");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setId("hdnDtComp");
    _jspx_th_impact_validateInput_7.setName("hdnDtComp");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setId("hdnUlIdRecCheck");
    _jspx_th_impact_validateInput_8.setName("hdnUlIdRecCheck");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_2);
    _jspx_th_impact_validateInput_10.setId("hdnRowCount");
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("hdnRowCount");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_23(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
    _jspx_th_impact_validateInput_23.setType("hidden");
    _jspx_th_impact_validateInput_23.setName("hdnIndex");
    _jspx_th_impact_validateInput_23.setValue("");
    int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
    if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_27(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_3);
    _jspx_th_impact_validateInput_27.setId("hdnRowCount");
    _jspx_th_impact_validateInput_27.setType("hidden");
    _jspx_th_impact_validateInput_27.setName("hdnRowCount");
    _jspx_th_impact_validateInput_27.setValue("");
    int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
    if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
