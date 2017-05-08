<%--
//* Name:     Principal Case History
//*  Created by:   Vijaya Anand
//*  Date Created: 04/07/05
//*
//* Description:
//* The Principal Case History page will be accessible from the Case Summary
//* page regardless of whether a stage has been selected.
//* The Principal Case History page will be a Search-List type of page.  The
//* Principal Case History page will display a list of cases for which one or
//* more principals in the current case are involved as a principal.  The user
//* will be able to access the associated case via the Case ID hyperlink.
//* The bottom section of the page will display the Principal List information
//* after a case has been selected from the case list.
//*
//** Change History:
//** Date         User        Description
//** --------    ----------- --------------------------------------------------
//*  04/08/2005   ANANDV      SIR 23522 - Principal Case History Information Page
//*  04/29/2005   Eric Dickman Added the reports.
//*  05/09/2005   ANANDV      SIR 23522 - Added condition to display Reports Section
//*  05/13/2005   ANANDV      SIR 23522 - Added condition to display Message if
                              more than 100 Principal List records displayed.
//*  05/18/2005   ANANDV      SIR 23522 - Added condition to display Radio Button
                              enable or disable if Sensitivie case is true/false.
     12/17/2008   arege       STGAP00010109 Modified code so that Principal List
                              section on Principal Case History page displays Georgia 
                              codes e.g FCC, FCF in the stage column 
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.workload.CaseInfoDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.workload.PrincipalListDB"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
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
%>


<impact:validateForm name="frmPrincipalCaseHistory" method="post"
  action="/workload/PrincipalCaseHistory/displayCaseList"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
  <impact:validateErrors formName="frmPrincipalCaseHistory"/>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<Script Language="JavaScript">

  // This Function called by CASE ID HyperLink - Each CASE ID listed will be
  // a link to the Case Summary Page for that Case.
  function submitCaseSearch(sCaseID, caseStage, caseName, program)
  {
    document.frmPrincipalCaseHistory.hdnUlIdCase.value = sCaseID;
    document.frmPrincipalCaseHistory.hdnSzCdStage.value = caseStage;
    document.frmPrincipalCaseHistory.hdnSzNmCase.value = caseName;
    document.frmPrincipalCaseHistory.hdnSzCdCaseProgram.value = program;
    submitValidateFormNoBypass( "frmPrincipalCaseHistory",
    "/workload/CaseSearch/displayCaseSummary" );
  }

  //This function called by Radio Button - to display the Principal List
  //based on the user Selection CASE ID.
  function fnShowList(rSelectedCase)
  {
    document.frmPrincipalCaseHistory.hdnRadioValue.value = rSelectedCase;
    submitValidateFormNoBypass( "frmPrincipalCaseHistory",
    "/workload/PrincipalCaseHistory/selectPrincipalList" );
  }

  // Called onUnload of page to remind user unsaved data will be lost
  window.onbeforeunload = function ()
  {
    IsDirty();
  }
</Script>

<% /* start pagination custom tag  -- closed after table */ %>
<%
  //This Case List section will display a list of cases for which one or more
  //principals in the current case are involved as a principal.
  //The Case List section will include the indicator for sensitive cases,
  //the Case ID, the checkbox for linking a case, an indicator for merge,
  //the program, the indicator to say if the case is UTC, the status of the case,
  //an indicator if it is eligible for purge, the case name, the stage that was
  //opened most recently, the date it was opened, the date it was closed, the
  //user who last modified the link checkbox, and the date the link was last
  //modified.
%>
<impact:pagination submitUrl="/workload/PrincipalCaseHistory/displayCaseList">
<table width="99%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
  <tr>
    <th colspan="4" >Case List </th>
  </tr>
  <tr class="subDetail">
    <td colspan="4">
      <div id="noScrollResults" style="height:210px;width:765px;overflow:auto" class="tableborderList">
      <!-- Case List Section -->
       <table border="0" cellspacing="0" cellpadding="3" width="850px">
        <tr>
          <th class="thList" nowrap>Show List</th>
          <th class="thList">!</th>
          <th class="thList">Case ID</th>
          <th class="thList">Link</th>
          <th class="thList">Mrg</th>
          <th class="thList">Program</th>
          <th class="thList">UTC</th>
          <th class="thList">Status</th>
          <th class="thList" nowrap>Prg Elg</th>
          <th class="thList">Case Name</th>
          <th class="thList">Stage</th>
          <th class="thList">Opened</th>
          <th class="thList">Closed</th>
          <th class="thList" nowrap >Updated By</th>
           <th class="thList" nowrap>Date Link</th>
        </tr>
        <!--To display Case List Section Information based on the Global ID CASE-->
        <%
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
        %>
        <tr class="<%=FormattingHelper.getRowCss( loopCount ++ )%>" valign="top">
        <%
          String radioId = "rbcontractPeriod_CLEAN" + loopCount;
          String onClickShowList = "javascript:fnShowList('" +
                  FormattingHelper.formatInt(sCaseID) +"')";
        %>
        <td align="center">

  <%
       if(linkRow){
  %>
          <impact:validateInput type="radio"  onClick="<%= onClickShowList %>"
                  id="<%= radioId %>"
                  tabIndex="<%= tabIndex++ %>"
                  name="rbcontractPeriod_CLEAN"
                  value="<%= String.valueOf( sCaseID ) %>"
                  checked="<%=String.valueOf(checked)%>"
                  editableMode="<%= EditableMode.ALL %>" />
  <%}
    else
   { %>
          <impact:validateInput type="radio"  onClick="<%= onClickShowList %>"
                  id="<%= radioId %>"
                  tabIndex="<%= tabIndex++ %>"
                  name="rbcontractPeriod_CLEAN"
                  value="<%= String.valueOf( sCaseID ) %>"
                  checked="<%=String.valueOf(checked)%>"
                  editableMode="<%= EditableMode.NONE %>" />

  <%}%>
        </td>
        <td><%if(sensitive){%>!<%}else{%>&nbsp;<%}%>
        </td>
        <td>
        <%
          //Users can view the associated case via the hyperlink.  If the case is
          //marked sensitive and the user does not have the proper security attribute,
          // the Case ID will display as text without a hyperlink.
          if ( linkRow )
          {
        %>
            <script type="text/javascript" language="JavaScript1.2">
                var caseName<%=loopCount%> = '<%=caseName%>';
            </script>
            <a href="javascript:submitCaseSearch('<%=sCaseID%>',
                  '<%=caseStage%>', caseName<%=loopCount%>,
                  '<%=program%>')"
                  tabIndex='<%=tabIndex++%>'>
                  <%= sCaseID %> </a>
        <%
          }
          else
          {
        %>  <%= sCaseID %>
        <% } //end if  %>
        </td>
        <td>
        <%
        // pageDisplay 4 - will check whether the User has a stage access
        // based on the Stage Id and user profile has a SEC_MERGE_CASES
        // will be able to Modify.
        if("4".equals(pageDisplay))
        {
        %>
            <input type="checkbox"
                  value="<%=tempCheck%>"
                  <% if("true".equalsIgnoreCase(tempCheck)){%> checked <%}%>
                  tabIndex="<%=tabIndex++%>"
                  id="<%=String.valueOf(sCaseID)%>"
                  name="<%=String.valueOf(sCaseID)%>"/>
        <%
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
        %>
          <input type="checkbox"
                value="<%=tempCheck%>"
                <% if("true".equalsIgnoreCase(tempCheck)){%> checked <%}%>
                tabIndex="<%=tabIndex++%>"
                id="<%=String.valueOf(sCaseID)%>"
                name="<%=String.valueOf(sCaseID)%>"
                disabled="true"/>
        <%
        } //end if
        %>
        </td>
        <td align="left">
        <%
          // check indMrg - this will tell you whether the case has been merged or not.
          // if it is merged then check mark will apply else blank.
          if(indMrg > 0 )
          {
        %>
            <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif">
        <%
           }
           else
           {
              %>&nbsp;<%
            }
        %>
        </td>
        <%
        // program - will tell you like APS or CPS
        %>
        <td align="left"><%=program%></td>
        <td align="left">
          <%=bUTC ? "<img alt='UTC' src='/grnds-docs/images/shared/stopLight.gif'>" : "&nbsp;" %>
        </td>
        <td align="left">
        <%
          // statusclosed - will tell you the Case Status has been Opened or Closed.
          if ( caseInfoDB.getCaseClosed() != null)
          {
        %>
        <%= statusClosed %>
        <%
          }
          else
          {
        %>
            <%= statusOpen%>
       <% } %>
       </td>
       <td align="left">
       <%
         // indPrgElig - will check a purge eligibility indicator informing the user
        //  that the case has passed its case destruction date.
        if(indPrgElg > 0)
        {
       %>
         <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif">
       <%
        }
        else
        {
           %>&nbsp;
        <%
         }
        %>
        </td>
        <%
        // It will display all the CaseName, CaseStage , CaseOpened, CaseClosed,
        // updatedBy - case updated , dtLinked - was last modified.
       %>
       <td align="left" nowrap><%=FormattingHelper.formatString(caseName)%></td>
       <td align="left"><%=FormattingHelper.formatString (Lookup.simpleDecodeSafe("CTXTOGA",caseStage))%></td>
       <td align="left"><%=FormattingHelper.formatDate(caseOpened)%></td>
       <td align="left"><%=FormattingHelper.formatDate(caseClosed)%></td>
       <td align="left" nowrap><%=FormattingHelper.formatString(updatedBy)%>
       </td>
       <td align="left"><%=FormattingHelper.formatDate(dtLinked)%></td>
       <%

        }//  while loop ending
      }
      else
      {
         // If the case id is not found for the principals then display the below
         // message
      %>
        </tr>
        <tr class="odd">
          <td colspan="4">
            <%= MessageLookup.getMessageByNumber(Messages.MSG_PCH_CASE_NOT_FOUND) %>
          </td>
      <%
        } //Ending Case List Section
      %>
  </tr>
  </table>
   </div><% /* end div ScrollResults */ %>
   </td>
  </tr>
</table>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="hdnUlIdCase"/>
<impact:validateInput type="hidden" name="hdnSzCdStage"/>
<impact:validateInput type="hidden" name="hdnSzNmCase"/>
<impact:validateInput type="hidden" name="hdnSzCdCaseProgram"/>
<impact:validateInput type="hidden" name="hdnRadioValue" />
<impact:validateInput type="hidden" name="hdnSameRecord" />
<% /* close pagination custom tag */ %>
</impact:pagination>

<%if (indNoCaseHistory.equals("false")) {%>
<% /* Begin Save pushbutton  */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
      <impact:ButtonTag
          img="btnSave"
          name="btnSave"
          form="frmPrincipalCaseHistory"
          action="/workload/PrincipalCaseHistory/saveCaseInfo"
          tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<% } %>
<br>
<% /* End Save pushbutton  */ %>

<%
// Principal Case List will populate based on the Case List exist.
// Principal Case List section should not populate.
if(caseInfoList.size() > 0)
{
  // hidePrincipalList check - The Principal List section will be populated
  // when the radio button for a case is selected.
  if( ( request.getAttribute("hidePrincipalList") == null ) ||
        !("true".equals(request.getAttribute("hidePrincipalList"))))
  {
%>
    <%--  Begin Principal List Section --%>
    <%
      // The Principal List section will include the Stage Id, Stage Type and
      // Overall Disposition for the INV stage and all of the principals in the
      // stage.  For each principal, the Name, Person ID, Age, DOB, Gender, Role,
      // and Rel/Int will be displayed.  The Principal List section will be grouped
      // by Stage ID, and then sorted in the Person List default order.
    %>
    <impact:pagination
                submitUrl="/workload/PrincipalCaseHistory/selectPrincipalList">
    <table width="99%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
    <tr>
     <th colspan="4" >Principal List </th>
    </tr>
    <tr class="subDetail">
      <td colspan="4">
    <div id="noScrollResults" style="height:210px;width:765px;overflow:auto" class="tableborderList">
      <table width="850px" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList">Stage ID</th>
          <th class="thList">Stage</th>
          <th class="thList">Ov Dsp</th>
          <th class="thList">Name</th>
          <th class="thList">Person ID</th>
          <th class="thList">Age</th>
          <th class="thList">DOB</th>
          <th class="thList">Gender</th>
          <th class="thList">Role</th>
          <th class="thList">Rel/Int</th>
        </tr>
  <%
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
    %>
          <tr class="<%=FormattingHelper.getRowCss( loopCount ++ ) %>" valign="top">
          <%-- Displaying Principal List Section values Part --%>
          <td><%=stageID%></td>
          <td align="left">          
            <%=FormattingHelper.formatString (Lookup.simpleDecodeSafe("CTXTOGA",principalCaseStage))%>
          </td>
          <td align="left"><%=FormattingHelper.formatString(overDisp)%></td>
          <td><%=FormattingHelper.formatString(personName)%></td>
          <td><%=personID%></td>
          <td align="left"><%=age%></td>
          <td><%=FormattingHelper.formatDate(dob)%></td>
          <td align="left"><%=FormattingHelper.formatString(gender)%></td>
          <td align="left"><%=FormattingHelper.formatString(role)%></td>
          <td align="left"><%=FormattingHelper.formatString(relation)%></td>
      </tr>
  <%
  count++;
  if(count == 100)
  {
%>
      <tr class="odd">
            <td colspan="4">
              <%= MessageLookup.getMessageByNumber(Messages.MSG_PCH_MORE_THAN_100_PRN)%>
          </td> </tr>
<%
      break;
    } // end if count
   } //ending while loop
  } // end iff Principallist size
 } // ending else part of PrincipalList size > 100
  // endig if loop displayPrincipalListInfo != null
%>
    </table>
    </div>
    </td>
  </tr>
  </table>
  </impact:pagination>
<%
   } // Hiding Principal List if loop ending
 } // Ending Principal List Section
%>
<%-- Ending Principal List Section --%>

<%-- Always include this hidden field in your form --%>
<br/>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<Script Language="JavaScript">
</Script>

<%-- end RLD --%>
