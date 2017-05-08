package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CaseInfoDB;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.PrincipalListDB;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class PrincipalCaseHistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Variable Declaration Section Starts here
  String pageMode = PageModeConstants.VIEW;
  int selectedIndex = -1;
  int rowIndex = 0;
  int personId = 0;
  int tabIndex = 1;
  int loopCount = 1;
  int sCaseID = 0;
  int globalCaseID = 0;
  int age=0;
  List caseInfoList = new ArrayList();
  List principalList = new ArrayList();
  CaseInfoDB caseInfoDB = null;
  PrincipalListDB principalListDB = null;
  String statusOpen = "OPN";
  String statusClosed = "CLD";
  String tempCheck = null;
  String caseSensitive = null;
  String linkCheck = null;
  int indMrg = 0;
  boolean sameRecord = true;
  String pageDisplay = null;
  String program = null;
  String caseUTC = null;
  int utcCaseId = 0 ;
  String caseName = null;
  String caseStage = null;
  String updatedBy = null;
  int  indPrgElg = 0;
  java.sql.Timestamp caseOpened = null;
  java.sql.Timestamp caseClosed = null;
  java.sql.Timestamp dtLinked = null;
  java.util.Date dob = null;
  boolean sensitive = false;
  boolean checked = false;
  boolean linkRow = true;
  boolean gCheck = false;
  String indNoCaseHistory = "false";
  // Variable Declaration Ending here

  UserProfile user = UserProfileHelper.getUserProfile( request );
  pageMode = PageMode.getPageMode(request);
  pageDisplay = PageMode.getPageMode(request);
  globalCaseID = GlobalData.getUlIdCase(request);
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute
  ( BaseSessionStateManager.STATE_MANAGER_KEY );

  //Getting CaseList Info Arraylist to populate Case List Section
  if (state.getAttribute("displayCaseList" , request) != null)
  {
  caseInfoList = (ArrayList) state.getAttribute("displayCaseList", request);
  }else {
  indNoCaseHistory = "true";
  }

      out.write("\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPrincipalCaseHistory");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/PrincipalCaseHistory/displayCaseList");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<Script Language=\"JavaScript\">\r\n\r\n  // This Function called by CASE ID HyperLink - Each CASE ID listed will be\r\n  // a link to the Case Summary Page for that Case.\r\n  function submitCaseSearch(sCaseID, caseStage, caseName, program)\r\n  {\r\n    document.frmPrincipalCaseHistory.hdnUlIdCase.value = sCaseID;\r\n    document.frmPrincipalCaseHistory.hdnSzCdStage.value = caseStage;\r\n    document.frmPrincipalCaseHistory.hdnSzNmCase.value = caseName;\r\n    document.frmPrincipalCaseHistory.hdnSzCdCaseProgram.value = program;\r\n    submitValidateFormNoBypass( \"frmPrincipalCaseHistory\",\r\n    \"/workload/CaseSearch/displayCaseSummary\" );\r\n  }\r\n\r\n  //This function called by Radio Button - to display the Principal List\r\n  //based on the user Selection CASE ID.\r\n  function fnShowList(rSelectedCase)\r\n  {\r\n    document.frmPrincipalCaseHistory.hdnRadioValue.value = rSelectedCase;\r\n    submitValidateFormNoBypass( \"frmPrincipalCaseHistory\",\r\n    \"/workload/PrincipalCaseHistory/selectPrincipalList\" );\r\n");
          out.write("  }\r\n\r\n  // Called onUnload of page to remind user unsaved data will be lost\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  }\r\n</Script>\r\n\r\n");
 /* start pagination custom tag  -- closed after table */ 
          out.write('\r');
          out.write('\n');

  //This Case List section will display a list of cases for which one or more
  //principals in the current case are involved as a principal.
  //The Case List section will include the indicator for sensitive cases,
  //the Case ID, the checkbox for linking a case, an indicator for merge,
  //the program, the indicator to say if the case is UTC, the status of the case,
  //an indicator if it is eligible for purge, the case name, the stage that was
  //opened most recently, the date it was opened, the date it was closed, the
  //user who last modified the link checkbox, and the date the link was last
  //modified.

          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/workload/PrincipalCaseHistory/displayCaseList");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\" >Case List </th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td colspan=\"4\">\r\n      <div id=\"noScrollResults\" style=\"height:210px;width:765px;overflow:auto\" class=\"tableborderList\">\r\n      <!-- Case List Section -->\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"850px\">\r\n        <tr>\r\n          <th class=\"thList\" nowrap>Show List</th>\r\n          <th class=\"thList\">!</th>\r\n          <th class=\"thList\">Case ID</th>\r\n          <th class=\"thList\">Link</th>\r\n          <th class=\"thList\">Mrg</th>\r\n          <th class=\"thList\">Program</th>\r\n          <th class=\"thList\">UTC</th>\r\n          <th class=\"thList\">Status</th>\r\n          <th class=\"thList\" nowrap>Prg Elg</th>\r\n          <th class=\"thList\">Case Name</th>\r\n          <th class=\"thList\">Stage</th>\r\n          <th class=\"thList\">Opened</th>\r\n          <th class=\"thList\">Closed</th>\r\n          <th class=\"thList\" nowrap >Updated By</th>\r\n           <th class=\"thList\" nowrap>Date Link</th>\r\n");
              out.write("        </tr>\r\n        <!--To display Case List Section Information based on the Global ID CASE-->\r\n        ");

        if(caseInfoList.size() > 0)
        {
          Iterator caseIter = caseInfoList.iterator();
          // Using Iterator get all the Case ids info from CaseInfoDB
          // and populate each fields on the page.

          while(caseIter.hasNext())
          {
            linkRow = true;
            caseInfoDB = (CaseInfoDB)caseIter.next();
            caseSensitive = caseInfoDB.getCaseSensitive();
            sCaseID = caseInfoDB.getCaseID();
            linkCheck = caseInfoDB.getIndCaseLink();
            indMrg = caseInfoDB.getIdCaseMerge();
            program = caseInfoDB.getProgram();
            utcCaseId = caseInfoDB.getUtcCaseID();
            indPrgElg = caseInfoDB.getDeleteCase();
            caseName = caseInfoDB.getCaseName();
            caseStage = caseInfoDB.getCaseStage();
            caseOpened = caseInfoDB.getCaseOpened();
            caseClosed = caseInfoDB.getCaseClosed();
            updatedBy = caseInfoDB.getPersonName();
            dtLinked = caseInfoDB.getDateCaseLink();

            // check if the case has been linked to a case on the list if
            // it present set the boolean to true else false.
            if(linkCheck != null && "Y".equals(linkCheck))
            {
              tempCheck = "true";
           gCheck  = true;
            }
            else
            {
              tempCheck = "false";

            }//end if

            //check if the case has an overall disposition of UTC or MOV, if it
            // present set it to Star  else blank.
            boolean bUTC = false;
            if(utcCaseId > 0)
            {
              bUTC = true;
            }
            //Get the user selected radio button value
            Integer retriveCaseID = (Integer) state.
                    getAttribute("selectedRadioValue", request);
            if( retriveCaseID == null  || "".equals(retriveCaseID) )
            {
              checked = false;
            }
            else
            {
              checked =  (sCaseID == retriveCaseID);
            }//end if

            caseName = FormattingHelper.formatStringSpecialChars(caseName, "'\"\\");

            //Check if the Users with the Sensitive Case Access security attribute
            //can view cases and principal lists that have been marked sensitive
            //from the Principal Case History page.
            if ("Y".equalsIgnoreCase(caseSensitive) &&
                !user.hasRight(user.SEC_SENSITIVE_CASE_ACCESS))
            {
                linkRow = false;
            } //end if

            // Users without the Sensitive Case Access security attribute cannot
            // view cases or the principal list for cases that have been marked
            // sensitive outside of the user\u2019s unit hierarchy.
            if ("FAD".equals(caseStage) && !user.hasRight(user.SEC_MTN_HOME))
            {
              linkRow = false;
            } //end if

            if(caseSensitive != null && "Y".equalsIgnoreCase(caseSensitive))
            {
                  sensitive = true;
            }
            else
            {
              sensitive = false;
            } //end if
        
              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount ++ ));
              out.write("\" valign=\"top\">\r\n        ");

          String radioId = "rbcontractPeriod_CLEAN" + loopCount;
          String onClickShowList = "javascript:fnShowList('" +
                  FormattingHelper.formatInt(sCaseID) +"')";
        
              out.write("\r\n        <td align=\"center\">\r\n\r\n  ");

       if(linkRow){
  
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_0.setType("radio");
              _jspx_th_impact_validateInput_0.setOnClick( onClickShowList );
              _jspx_th_impact_validateInput_0.setId( radioId );
              _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_0.setName("rbcontractPeriod_CLEAN");
              _jspx_th_impact_validateInput_0.setValue( String.valueOf( sCaseID ) );
              _jspx_th_impact_validateInput_0.setChecked(String.valueOf(checked));
              _jspx_th_impact_validateInput_0.setEditableMode( EditableMode.ALL );
              int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
              if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
}
    else
   { 
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_1.setType("radio");
              _jspx_th_impact_validateInput_1.setOnClick( onClickShowList );
              _jspx_th_impact_validateInput_1.setId( radioId );
              _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_1.setName("rbcontractPeriod_CLEAN");
              _jspx_th_impact_validateInput_1.setValue( String.valueOf( sCaseID ) );
              _jspx_th_impact_validateInput_1.setChecked(String.valueOf(checked));
              _jspx_th_impact_validateInput_1.setEditableMode( EditableMode.NONE );
              int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
              if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n  ");
}
              out.write("\r\n        </td>\r\n        <td>");
if(sensitive){
              out.write('!');
}else{
              out.write("&nbsp;");
}
              out.write("\r\n        </td>\r\n        <td>\r\n        ");

          //Users can view the associated case via the hyperlink.  If the case is
          //marked sensitive and the user does not have the proper security attribute,
          // the Case ID will display as text without a hyperlink.
          if ( linkRow )
          {
        
              out.write("\r\n            <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n                var caseName");
              out.print(loopCount);
              out.write(" = '");
              out.print(caseName);
              out.write("';\r\n            </script>\r\n            <a href=\"javascript:submitCaseSearch('");
              out.print(sCaseID);
              out.write("',\r\n                  '");
              out.print(caseStage);
              out.write("', caseName");
              out.print(loopCount);
              out.write(",\r\n                  '");
              out.print(program);
              out.write("')\"\r\n                  tabIndex='");
              out.print(tabIndex++);
              out.write("'>\r\n                  ");
              out.print( sCaseID );
              out.write(" </a>\r\n        ");

          }
          else
          {
        
              out.write(' ');
              out.write(' ');
              out.print( sCaseID );
              out.write("\r\n        ");
 } //end if  
              out.write("\r\n        </td>\r\n        <td>\r\n        ");

        // pageDisplay 4 - will check whether the User has a stage access
        // based on the Stage Id and user profile has a SEC_MERGE_CASES
        // will be able to Modify.
        if("4".equals(pageDisplay))
        {
        
              out.write("\r\n            <input type=\"checkbox\"\r\n                  value=\"");
              out.print(tempCheck);
              out.write("\"\r\n                  ");
 if("true".equalsIgnoreCase(tempCheck)){
              out.write(" checked ");
}
              out.write("\r\n                  tabIndex=\"");
              out.print(tabIndex++);
              out.write("\"\r\n                  id=\"");
              out.print(String.valueOf(sCaseID));
              out.write("\"\r\n                  name=\"");
              out.print(String.valueOf(sCaseID));
              out.write("\"/>\r\n        ");

        }
        // pageDisplay 3 - will check whether the user has a stage access based on
        // the Stage Id and user profile has not SEC_MERGE_CASES will be able to VIEW.
        // In View mode, the Save push button will be disabled on the
        // Principal Case History page. The radio buttons and hyperlinks will still
        // be available, since those don\u2019t change any data. The Link checkboxes will
        // be grayed out in View mode, but the user will still be able to see  the
        // checkmark if it is present.
        else if("3".equals(pageDisplay))
        {
        
              out.write("\r\n          <input type=\"checkbox\"\r\n                value=\"");
              out.print(tempCheck);
              out.write("\"\r\n                ");
 if("true".equalsIgnoreCase(tempCheck)){
              out.write(" checked ");
}
              out.write("\r\n                tabIndex=\"");
              out.print(tabIndex++);
              out.write("\"\r\n                id=\"");
              out.print(String.valueOf(sCaseID));
              out.write("\"\r\n                name=\"");
              out.print(String.valueOf(sCaseID));
              out.write("\"\r\n                disabled=\"true\"/>\r\n        ");

        } //end if
        
              out.write("\r\n        </td>\r\n        <td align=\"left\">\r\n        ");

          // check indMrg - this will tell you whether the case has been merged or not.
          // if it is merged then check mark will apply else blank.
          if(indMrg > 0 )
          {
        
              out.write("\r\n            <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n        ");

           }
           else
           {
              
              out.write("&nbsp;");

            }
        
              out.write("\r\n        </td>\r\n        ");

        // program - will tell you like APS or CPS
        
              out.write("\r\n        <td align=\"left\">");
              out.print(program);
              out.write("</td>\r\n        <td align=\"left\">\r\n          ");
              out.print(bUTC ? "<img alt='UTC' src='/grnds-docs/images/shared/stopLight.gif'>" : "&nbsp;" );
              out.write("\r\n        </td>\r\n        <td align=\"left\">\r\n        ");

          // statusclosed - will tell you the Case Status has been Opened or Closed.
          if ( caseInfoDB.getCaseClosed() != null)
          {
        
              out.write("\r\n        ");
              out.print( statusClosed );
              out.write("\r\n        ");

          }
          else
          {
        
              out.write("\r\n            ");
              out.print( statusOpen);
              out.write("\r\n       ");
 } 
              out.write("\r\n       </td>\r\n       <td align=\"left\">\r\n       ");

         // indPrgElig - will check a purge eligibility indicator informing the user
        //  that the case has passed its case destruction date.
        if(indPrgElg > 0)
        {
       
              out.write("\r\n         <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n       ");

        }
        else
        {
           
              out.write("&nbsp;\r\n        ");

         }
        
              out.write("\r\n        </td>\r\n        ");

        // It will display all the CaseName, CaseStage , CaseOpened, CaseClosed,
        // updatedBy - case updated , dtLinked - was last modified.
       
              out.write("\r\n       <td align=\"left\" nowrap>");
              out.print(FormattingHelper.formatString(caseName));
              out.write("</td>\r\n       <td align=\"left\">");
              out.print(FormattingHelper.formatString (Lookup.simpleDecodeSafe("CTXTOGA",caseStage)));
              out.write("</td>\r\n       <td align=\"left\">");
              out.print(FormattingHelper.formatDate(caseOpened));
              out.write("</td>\r\n       <td align=\"left\">");
              out.print(FormattingHelper.formatDate(caseClosed));
              out.write("</td>\r\n       <td align=\"left\" nowrap>");
              out.print(FormattingHelper.formatString(updatedBy));
              out.write("\r\n       </td>\r\n       <td align=\"left\">");
              out.print(FormattingHelper.formatDate(dtLinked));
              out.write("</td>\r\n       ");


        }//  while loop ending
      }
      else
      {
         // If the case id is not found for the principals then display the below
         // message
      
              out.write("\r\n        </tr>\r\n        <tr class=\"odd\">\r\n          <td colspan=\"4\">\r\n            ");
              out.print( MessageLookup.getMessageByNumber(Messages.MSG_PCH_CASE_NOT_FOUND) );
              out.write("\r\n          </td>\r\n      ");

        } //Ending Case List Section
      
              out.write("\r\n  </tr>\r\n  </table>\r\n   </div>");
 /* end div ScrollResults */ 
              out.write("\r\n   </td>\r\n  </tr>\r\n</table>\r\n\r\n");
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
 /* close pagination custom tag */ 
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
if (indNoCaseHistory.equals("false")) {
          out.write('\r');
          out.write('\n');
 /* Begin Save pushbutton  */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmPrincipalCaseHistory");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/PrincipalCaseHistory/saveCaseInfo");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } 
          out.write("\r\n<br>\r\n");
 /* End Save pushbutton  */ 
          out.write("\r\n\r\n");

// Principal Case List will populate based on the Case List exist.
// Principal Case List section should not populate.
if(caseInfoList.size() > 0)
{
  // hidePrincipalList check - The Principal List section will be populated
  // when the radio button for a case is selected.
  if( ( request.getAttribute("hidePrincipalList") == null ) ||
        !("true".equals(request.getAttribute("hidePrincipalList"))))
  {

          out.write("\r\n    ");
          out.write("\r\n    ");

      // The Principal List section will include the Stage Id, Stage Type and
      // Overall Disposition for the INV stage and all of the principals in the
      // stage.  For each principal, the Name, Person ID, Age, DOB, Gender, Role,
      // and Rel/Int will be displayed.  The Principal List section will be grouped
      // by Stage ID, and then sorted in the Person List default order.
    
          out.write("\r\n    ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_1.setSubmitUrl("/workload/PrincipalCaseHistory/selectPrincipalList");
          int _jspx_eval_impact_pagination_1 = _jspx_th_impact_pagination_1.doStartTag();
          if (_jspx_eval_impact_pagination_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n    <tr>\r\n     <th colspan=\"4\" >Principal List </th>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td colspan=\"4\">\r\n    <div id=\"noScrollResults\" style=\"height:210px;width:765px;overflow:auto\" class=\"tableborderList\">\r\n      <table width=\"850px\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\">Stage ID</th>\r\n          <th class=\"thList\">Stage</th>\r\n          <th class=\"thList\">Ov Dsp</th>\r\n          <th class=\"thList\">Name</th>\r\n          <th class=\"thList\">Person ID</th>\r\n          <th class=\"thList\">Age</th>\r\n          <th class=\"thList\">DOB</th>\r\n          <th class=\"thList\">Gender</th>\r\n          <th class=\"thList\">Role</th>\r\n          <th class=\"thList\">Rel/Int</th>\r\n        </tr>\r\n  ");

    //Getting displayPrincipalListInfo Arraylist to display Principal List Section.
    if (state.getAttribute("displayPrincipalListInfo" , request) != null)
    {
        principalList = (ArrayList)( state.getAttribute("displayPrincipalListInfo", request));

  //If the Principal List size more than 100 display the list as well as
  // populate the message.
  int count = 0;
  if ( principalList.size() > 0 )
  {
      Iterator prnIter = principalList.iterator();
      while(prnIter.hasNext())
      {
          principalListDB = (PrincipalListDB) prnIter.next();
          int stageID = principalListDB.getStageId();
          String principalCaseStage = principalListDB.getStage();
          String overDisp = principalListDB.getOvrDisposition();
          String personName =  principalListDB.getPersonName();
          int personID =principalListDB.getPersonID();

          // age - calculated based on the Date Of Birth
          if(principalListDB.getDateOfBirth() != null)
          {
            age = DateHelper.getAge(principalListDB.getDateOfBirth());
          }
          if(principalListDB.getDateOfBirth() != null)
          {
            dob =  principalListDB.getDateOfBirth();
          }
          String gender=principalListDB.getGender();
          String role=principalListDB.getRole();
          String relation = principalListDB.getRelation();
    
              out.write("\r\n          <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount ++ ) );
              out.write("\" valign=\"top\">\r\n          ");
              out.write("\r\n          <td>");
              out.print(stageID);
              out.write("</td>\r\n          <td align=\"left\">          \r\n            ");
              out.print(FormattingHelper.formatString (Lookup.simpleDecodeSafe("CTXTOGA",principalCaseStage)));
              out.write("\r\n          </td>\r\n          <td align=\"left\">");
              out.print(FormattingHelper.formatString(overDisp));
              out.write("</td>\r\n          <td>");
              out.print(FormattingHelper.formatString(personName));
              out.write("</td>\r\n          <td>");
              out.print(personID);
              out.write("</td>\r\n          <td align=\"left\">");
              out.print(age);
              out.write("</td>\r\n          <td>");
              out.print(FormattingHelper.formatDate(dob));
              out.write("</td>\r\n          <td align=\"left\">");
              out.print(FormattingHelper.formatString(gender));
              out.write("</td>\r\n          <td align=\"left\">");
              out.print(FormattingHelper.formatString(role));
              out.write("</td>\r\n          <td align=\"left\">");
              out.print(FormattingHelper.formatString(relation));
              out.write("</td>\r\n      </tr>\r\n  ");

  count++;
  if(count == 100)
  {

              out.write("\r\n      <tr class=\"odd\">\r\n            <td colspan=\"4\">\r\n              ");
              out.print( MessageLookup.getMessageByNumber(Messages.MSG_PCH_MORE_THAN_100_PRN));
              out.write("\r\n          </td> </tr>\r\n");

      break;
    } // end if count
   } //ending while loop
  } // end iff Principallist size
 } // ending else part of PrincipalList size > 100
  // endig if loop displayPrincipalListInfo != null

              out.write("\r\n    </table>\r\n    </div>\r\n    </td>\r\n  </tr>\r\n  </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_pagination_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

   } // Hiding Principal List if loop ending
 } // Ending Principal List Section

          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n");
          out.write("\r\n<br/>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<Script Language=\"JavaScript\">\r\n</Script>\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmPrincipalCaseHistory");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnUlIdCase");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnSzCdStage");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("hdnSzNmCase");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnSzCdCaseProgram");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnRadioValue");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("hdnSameRecord");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
