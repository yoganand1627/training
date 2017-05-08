<%/**--------------------------------------------------------------------------------
       *
       * JSP Name:     Safety Plan
       * Created by:   Amit Patel
       * Date Created: 03/02/2007
       *
       * Description:
       * This JSP displays the details for a given Safety Plan. Depending upon
       * the user's privileges, the user can use this page to view and update Safety Pla
   
    
      /* Change History:
       * DATE		NAME		CHANGES
       * 11/4/08    charden		STGAP00010129 - do not show save and submit button when in approval status 
       *
       *
      */
%>

<%@taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO.RowCasePersonResponsible"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorSO"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyPlanConversation"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@page import="java.util.Iterator"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersonResonsibleSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>

<%BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      //Set the page mode to the mode that is passed in
      String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }

      boolean approvalStatus = true;
      SafetyPlanRetrieveSO safetyPlanRetrieveSO = (SafetyPlanRetrieveSO) request.getAttribute("SafetyPlanRetrieveSO");

      ROWCCMN45DO eventDetails = safetyPlanRetrieveSO.getRowccmn45do();
      if ((eventDetails == null)
          || pageMode.equals(PageModeConstants.NEW)
          || (!SafetyPlanConversation.EVENT_STATUS_PEND.equals(eventDetails.getSzCdEventStatus()) && !SafetyPlanConversation.EVENT_STATUS_APRV
                                                                                                                                              .equals(eventDetails
                                                                                                                                                                  .getSzCdEventStatus()))) {
        approvalStatus = false;
      }

      //Initialize the display variables for the page
      int tabIndex = 1;
      int idSftyFctr = 0;

      String txtSafetyFactor = "";
      String txtChangetoMitigateSafetyFactor = "";
      String firstName = "";
      String middleName = "";
      String lastName = "";
      String fieldsToBeSpellChecked = "";
      String append = "";
      Date dtToBeCompletedBy = null;

      Date dtTsSafetyPlanLastUpdate = safetyPlanRetrieveSO.getDtLastUpdate();

      Date dtTsEventLastUpdate = null;
      if (safetyPlanRetrieveSO.getRowccmn45do() != null) {
        dtTsEventLastUpdate = safetyPlanRetrieveSO.getRowccmn45do().getTsLastUpdate();
      }
      Date dtTsSafetyFactorLastUpdate = null;

      boolean saveAndSubmit = true;
      boolean isApproval = GlobalData.isApprovalMode(request);
      //STGAP00010129 - do not show save and submit button when in approval status 
      if(isApproval){
        saveAndSubmit = false;
      }
      boolean save = true;
      boolean bShowReportDropDown = true;
      
      boolean bRowClose  = false;
      
      String careTakerAgree_Yes = "true";
      String careTakerAgree_No = "false";

      String txtActions = "";
      String txtComments = "";
      Date dtDiscWithCrtkr = safetyPlanRetrieveSO.getDtDiscWithCrtkr();

      careTakerAgree_Yes = "true";
      careTakerAgree_No = "false";

      String ind_careTaker = safetyPlanRetrieveSO.getIndCrtkrAgreesSp();
      if (ArchitectureConstants.N.equals(ind_careTaker)) {
        careTakerAgree_No = "true";
      } else {
        careTakerAgree_Yes = "true";
      }

      int factorRow = 0;
      int row = 0;

      %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">



//-- Called by Save button (function attribute)
//-- Called by Save and Submit button (onClick attribute)

function deleteThisSection(index)
{
  var bUserResponse ='true';
    disableValidation("frmSafetyPlan");
    frmSafetyPlan.deleteFactorArrayIndex.value = index;
  return bUserResponse;
}



window.onbeforeunload = function ()
{
  IsDirty();
}
</script>

<impact:validateErrors />


<impact:validateForm name="frmSafetyPlan" method="post" action="/investigation/SafetyPlan/saveSafetyPlan" pageMode="<%=pageMode%>" schema="/WEB-INF/Constraints.xsd">
  <impact:validateInput type="hidden" name="deleteFactorArrayIndex" value="" />
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <%if (approvalStatus) {

        %>
      <td class="alignLeft" width="85%">
        <impact:ButtonTag name="btnApprovalStatus" tabIndex="<%= tabIndex++ %>" img="btnApprovalStatus" editableMode="<%=EditableMode.ALL%>" form="frmSafetyPlan" action="/workload/ApprovalStatus/displayStatus" />
      </td>
      <%} else {

      %>
      <td class="alignLeft" width="85%">
        &nbsp;
      </td>
      <%}

      %>
    </tr>
  </table>

 <!--  <br>-->
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
    <tr>
      <th colspan="4">
        Safety Plan
      </th>
    </tr>
     
    
  <%List<SafetyFactorSO> safetyFactorList = null;
      safetyFactorList = safetyPlanRetrieveSO.getSafetyFactorList();

      if (safetyFactorList == null || safetyFactorList.size() == 0) {
        safetyFactorList = new ArrayList<SafetyFactorSO>();
        safetyFactorList.add(new SafetyFactorSO());
        safetyPlanRetrieveSO.setSafetyFactorList(safetyFactorList);
         bShowReportDropDown= false;
      }
      factorRow = 0;
      if (safetyPlanRetrieveSO.getSafetyFactorList() != null) {
        Iterator safetyFactorListIt = safetyFactorList.iterator();
        while (safetyFactorListIt.hasNext()) {
          factorRow++;
         
          SafetyFactorSO safetyFactorSO = (SafetyFactorSO) safetyFactorListIt.next();
          idSftyFctr = safetyFactorSO.getIdSftyFctr();
          txtSafetyFactor = safetyFactorSO.getSzTxtSftyFctrDesc();
          txtChangetoMitigateSafetyFactor = safetyFactorSO.getSzTxtSftyFctrMitigate();
          firstName = safetyFactorSO.getNmFirstOthrResp();
          middleName = safetyFactorSO.getNmMiddleOthrResp();
          lastName = safetyFactorSO.getNmLastOthrResp();
          dtToBeCompletedBy = safetyFactorSO.getDtCompltdBy();
          txtActions = safetyFactorSO.getSzTxtDescActions();
          txtComments = safetyFactorSO.getSzTxtSftyFctrComments();
          dtTsSafetyFactorLastUpdate = safetyFactorSO.getDtLastUpdate();

          %>
  <impact:validateInput type="hidden" name="<%="idSftyFctr" + factorRow %>" value="<%= FormattingHelper.formatInt(idSftyFctr) %>" />
  <impact:validateInput type="hidden" name="<%="dtTsSafetyFactorLastUpdate" + factorRow %>" value="<%= DateHelper.toISOString(dtTsSafetyFactorLastUpdate) %>" />

	<tr> 
    <td>
    <table border="0"  cellspacing="0" cellpadding="3" width="100%" > 
      <tr>
        <td colspan="3" style="background-color: #C0C0C0">
          Safety Factor:
        </td>
      </tr>

      <tr>
        <%if ("".equals(fieldsToBeSpellChecked)) {
            fieldsToBeSpellChecked = "txtSafetyFactor" + factorRow + append;
          } else {
            fieldsToBeSpellChecked = fieldsToBeSpellChecked +", "+ "txtSafetyFactor" + factorRow + append  ;
          }

          %>
        <td>
          <impact:validateInput tabIndex="<%= tabIndex++ %>" value="<%= txtSafetyFactor %>" type="text" name="<%="txtSafetyFactor" + factorRow  %>" cssClass="formInput" size="100" maxLength="80" constraint="Comments" />
        </td>

      </tr>

      <tr>
        <td colspan="3">
          Change to mitigate safety factor:
        </td>
      </tr>
      <tr>
        <%fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", "+ "txtChangetoMitigateSafetyFactor" + factorRow + append;

          %>
        <td>
          <impact:validateTextArea name="<%="txtChangetoMitigateSafetyFactor" + factorRow %>" rows="3" cols="100" tabIndex="<%= tabIndex++ %>" maxLength="300" constraint="Comments" conditionallyRequired="false">
            <%=FormattingHelper.formatString(txtChangetoMitigateSafetyFactor)%>
          </impact:validateTextArea>
        </td>
      </tr>
    </table>
    </td>
    </tr>
    <tr>
     <td> 
     <table  cellspacing="0" cellpadding="4" width="100%" >
      <tr>
        <td colspan="4" style="background-color: #C0C0C0">
          Person(s) Responsible:
        </td>
      </tr>
      
      <%List casePersonResponsibleList = safetyPlanRetrieveSO.getCasePersonResponsibleList();
          row = 0;
          
          if (casePersonResponsibleList != null) {
            Iterator casePersonResponsibleListIt = casePersonResponsibleList.iterator();
            RowCasePersonResponsible rowCasePersonResponsible = null;
            while (casePersonResponsibleListIt.hasNext()) {
              String personSelected = ArchitectureConstants.FALSE;
              rowCasePersonResponsible = (RowCasePersonResponsible) casePersonResponsibleListIt.next();
              row++;
              List<PersonResonsibleSO> personResonsibleList = safetyFactorSO.getPersonResonsibleList();
              if (personResonsibleList != null) {
                Iterator personResonsibleListIt = personResonsibleList.iterator();
                while (personResonsibleListIt.hasNext()) {
                  PersonResonsibleSO personResonsibleSO = (PersonResonsibleSO) personResonsibleListIt.next();
                  if (personResonsibleSO.getIdPerson() == rowCasePersonResponsible.getIdPerson()) {
                    personSelected = ArchitectureConstants.TRUE;
                  }
                }
              }

              %>


      <%if (((row-1) % 2 == 0)) {
     		 bRowClose=true;

              %>
      <tr>
        <%}

	              %>
        <td>
          <impact:validateInput label="<%=rowCasePersonResponsible.getName()%>" type="checkbox" value="<%=FormattingHelper.formatInt(rowCasePersonResponsible.getIdPerson())  %>" checked="<%=personSelected%>" name="<%="chkRespPerson" + factorRow +row %>"
            tabIndex="<%= tabIndex++ %>" />
        </td>
        <%if (((row-1) % 2 != 0)) {
				bRowClose=false;
              %>
      		</tr>
    	<%
      		}
         %>
      <%
       }
      
       if (bRowClose) {
     		 bRowClose=false;

              %>
      		</tr>
        <%
          }
       	 
         }  
          %>
    
      <impact:validateInput type="hidden" name="<%="personRow" + factorRow %>" value="<%=FormattingHelper.formatInt(row)%>" />
    </table>
    </td> 
    </tr>
    <!-- <br>-->
    <tr>
    <td> 
        <table border="0" cellspacing="0" cellpadding="3" width="100%">

      <tr class="subDetail">
        <td>
          Other:
        </td>
      </tr>

      <tr class="subDetail">
        <td>
          <impact:validateInput tabIndex="<%= tabIndex++ %>" value="<%= firstName %>" type="text" name="<%="txtFirst"+ factorRow %>" label="First" cssClass="formInput" size="12" maxLength="12" constraint="Name12" />
        </td>
        <td>
          <impact:validateInput tabIndex="<%= tabIndex++ %>" value="<%= middleName  %>" type="text" name="<%="txtMiddle" + factorRow%>" label="Middle" cssClass="formInput" size="12" maxLength="12" constraint="Name12" />
        </td>


        <td>
          <impact:validateInput tabIndex="<%= tabIndex++ %>" value="<%= lastName  %>" type="text" name="<%="txtLast" +factorRow%>" label="Last" cssClass="formInput" size="22" maxLength="22" constraint="Name22" />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateDate colspan="3" label="To be completed by" name="<%="dtToBeCompletedBy" +factorRow%>" value="<%= FormattingHelper.formatDate(dtToBeCompletedBy) %>" type="text" required="false" constraint="Date" size="8" tabIndex="<%= tabIndex++ %>" />

        </td>
      </tr>
    </table>
    </td>
    </tr>
    <!-- <br>-->
    <tr>
    <td>
    <table border="0" cellspacing="0" cellpadding="3" width="100%">


      <tr>
        <td colspan="3">
          Description of Actions:
        </td>
      </tr>
      <tr>
        <td>

          <%fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", "+  "txtActions" + factorRow + append;

          %>
          <impact:validateTextArea name="<%="txtActions"+ factorRow%>" rows="3" cols="100" tabIndex="<%= tabIndex++ %>" maxLength="300" constraint="Comments" conditionallyRequired="false">
            <%=FormattingHelper.formatString(txtActions)%>
          </impact:validateTextArea>
        </td>
      </tr>

      <tr>

        <td colspan="3">
          Comments:
        </td>
      </tr>
      <tr>
        <td>

          <%fieldsToBeSpellChecked = fieldsToBeSpellChecked +  ", "+ "txtComments" + factorRow + append;

          %>
          <impact:validateTextArea name="<%="txtComments" +factorRow%>" rows="3" cols="100" tabIndex="<%= tabIndex++ %>" maxLength="300" constraint="Comments" conditionallyRequired="false">
            <%=FormattingHelper.formatString(txtComments)%>
          </impact:validateTextArea>
        </td>
      </tr>
    </table>
    </td>
    </tr>
    
    <tr>
    <td>
      <table border="0" cellpadding="3" cellspacing="0" width="100%">
       <tr> 
        <td align="right">

          <%if (safetyFactorList.size() == factorRow) {

            %>
          <impact:ButtonTag name="<%="btnAdd" + factorRow %>" img="btnAddFactor" form="frmSafetyPlan" action="/investigation/SafetyPlan/addSafetyFactor" tabIndex="<%= tabIndex++ %>" accessKey="N" />
          <%}
          if ((safetyFactorList.size() != factorRow) || ((safetyFactorList.size() == factorRow) && (idSftyFctr != 0))) {

            %>
          <impact:ButtonTag name="<%="btnDelete" + factorRow %>" img="btnDeleteFactor" form="frmSafetyPlan" action="/investigation/SafetyPlan/deleteSafetyFactor" tabIndex="<%= tabIndex++ %>" function="<%="return deleteThisSection('"+factorRow+"');"%>" />
          <%}

        %>

        </td>
       </tr> 

      </table>
    </td>  
    </tr>  
	
      <%}
      }

      %>

      <impact:validateInput type="hidden" name="factorRowsCount" value="<%=FormattingHelper.formatInt(factorRow)%>" />
      <!-- <hr> -->
      <tr>
      <td>
      <table border="0" cellspacing="0" cellpadding="3" width="100%"  >
        <tr>
          <td colspan="3" width="40%">
            <impact:validateDate label="Date Safety Plan was discussed with caretaker" name="dtDiscWithCrtkr" value="<%= FormattingHelper.formatDate(dtDiscWithCrtkr) %>" type="text" required="false" constraint="Date" size="8" tabIndex="<%= tabIndex++ %>" />

          </td>
        <tr>
        <tr>

          <td colspan="3" width="25%">
            Caretaker agree with plan
            <impact:validateInput type="radio" label="Yes" id="CareTakerAgree_Yes" name="rbCareTaker" value="Y" cssClass="formInput" checked="<%= careTakerAgree_Yes %>" tabIndex="<%= tabIndex++ %>" />
            <impact:validateInput type="radio" label="No" id="CareTakerAgree_No" name="rbCareTaker" value="N" cssClass="formInput" checked="<%= careTakerAgree_No %>" tabIndex="<%= tabIndex++ %>" />
          </td>

        </tr>


      </table>
      </td>
      </tr>

      
      
      
      <tr>
      <td>  
       <table width="100%" border="0" cellspacing="0" cellpadding="3" >

        <tr>
		 <hr>
		 <% if (GlobalData.getUlIdEvent(request) > 0) { %>
		 <td align="left" width="5%">
            <impact:ButtonTag name="btnDeleteSafetyPlan" img="btnDelete" form="frmSafetyPlan" action="/investigation/SafetyPlan/deleteSafetyPlan" restrictRepost="true" tabIndex="<%= tabIndex++ %>" />
         </td>
         <% } %>
          <td width="80%" align="right">
            <impact:spellCheck formToSpellCheck="frmSafetyPlan" fieldsToSpellCheck="<%= fieldsToBeSpellChecked %>" tabIndex="<%=tabIndex++%>" />
          </td>
          <td align="right" width="10%">
            <%if (saveAndSubmit) {

        %>
            <impact:ButtonTag name="btnSaveSubmit" img="btnSaveAndSubmit" form="frmSafetyPlan" action="/investigation/SafetyPlan/saveAndSubmitSafetyPlan" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />

          </td>
          <%}
      if (save) {

        %>
          <td align="right" width="5%">
            <impact:ButtonTag name="btnSave" img="btnSave" form="frmSafetyPlan" action="/investigation/SafetyPlan/saveSafetyPlan" restrictRepost="true" tabIndex="<%= tabIndex++ %>" />
          </td>
          <%}

      %>
        </tr>
      </table>
      
      </tr>
     </table> 
	  
      <INPUT type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
      <impact:validateInput type="hidden" name="dtTsSafetyPlanLastUpdate" value="<%=DateHelper.toISOString(dtTsSafetyPlanLastUpdate)  %>" />
      <impact:validateInput type="hidden" name="dtTsEventLastUpdate" value="<%=DateHelper.toISOString(dtTsEventLastUpdate) %>" />

      </impact:validateForm>
  
 
<br>
<br>
 
 <% if (bShowReportDropDown) { %> 
 
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Forms Launch</th>
  </tr>
  <tr>
    <td>
    <td>
      <impact:documentList pageMode="2" tabIndex="<%= tabIndex++ %>">
        <impact:document displayName="Safety Plan"
                         protectDocument="true"
                         checkForNewMode="false"
                         docType="FAS03O00"
                         docExists="false">
         <impact:documentParameter name="pStage" value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
         <impact:documentParameter name="pEvent" value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>
        </impact:document>
  	</impact:documentList>
  </tr>
</table>
<% } %>

<% /* end Forms and Reports */ %>
      <script language="JavaScript" type="text/javascript">
   
</script>