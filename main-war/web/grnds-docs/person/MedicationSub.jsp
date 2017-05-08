<%--
//*  JSP Name: Medication Sub
//*  Created by:   Vishala Devarakonda
//*  Date Created: 09/10/2006
//*
//*  Description:
//*  The Medication List/Detail sub-module will provide an application-wide facility
//*  for users to store multiple medications for a given person. The information will be an expandable section on
//*  the including page and will display a list of the Medications for a given
//*  person.
//*
//*  Code to include this submodule:
//*     <impact:include page="/submodule/MedicationSubmoduleConversation/displayMedication" callingPage="/person/PersonDetail/displayPersonDetail"
//*     tabIndex="<%= tabIndex++ %>" includingForm="frmPersonDetail"> <impact:attribute name="intakeIndicator" value="N"/> 
//*     <impact:attribute name="<%= MedicationSubmoduleConversation.PAGE_MODE_KEY %>" value="<%= overallPageMode %>" />
//*     </impact:include>
//*
//*  where bIntakeIndicator has been set to a value of 'N' or 'Y'
//*
//*  Note: If the intakeIndicator attribute is not included, an error will be displayed.
//*
//*
//* Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>


<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.PersonMedicationList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.MedicationSubmoduleConversation"%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>


<%BaseSessionStateManager state = (BaseSessionStateManager) request
        .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  MedicationRetrieveSO medretso = (MedicationRetrieveSO) state.getAttribute("MedicationRetrieveSO", request);

  List<PersonMedicationList> medications = medretso.getPmBeanList();
  int size = medications.size();

  String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);

  // Get the page mode that was passed to the submodule by the including JSP.
  String pageMode = (String) state.getAttribute(MedicationSubmoduleConversation.PAGE_MODE_KEY, request);

  int loopCount = 0;

  String tabindexString = (String) request.getAttribute("tabIndex");
  int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);

%>

<!--<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>-->
<!--<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>-->
<!--<script type="text/javascript" language="JavaScript1.2">-->

<script language="Javascript">
function launchMedicationDetail( index )
{
  document.<%= includingFormName %>.medicationIndex.value = index;
  disableValidation( '<%= includingFormName %>' );
  submitValidateForm('<%= includingFormName %>', '/person/MedicationDetail/displayMedicationDetail');
}


function addMedicationDetail()
{
  document.<%= includingFormName %>.isAddMedication.value = 'true';
  return true;
}
</script>


<impact:validateInput type="hidden" name="medicationIndex" value="0" />
<impact:validateInput type="hidden" name="isAddMedication" value="" />

<impact:ExpandableSectionTag name="Medication" id="medicationItem_0" label="Medication" tabIndex="<%= tabIndex++ %>">

  <div id="scrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">

    <table width="100%" cellspacing="0" cellpadding="3" border="0">
      <tr>
        <th class="thList">
          Medication Name
        </th>
        <th class="thList">
          Frequency
        </th>
        <th class="thList">
          Reason
        </th>
        <th class="thList">
          Admin Person
        </th>
        <th class="thList">
          Start Date
        </th>
        <th class="thList">
          End Date
        </th>
        <th class="thList">
          Allergy Description
        </th>
        <th class="thList">
          Comments
        </th>
      </tr>
      <%if (!FormValidation.pageHasErrorMessages(request)) {
        if (size == 0) {
%>
      <tr class="odd">
        <td colspan="8">
          <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
        </td>
      </tr>
      <%} else {

        for (Iterator<PersonMedicationList> it = medications.iterator(); it.hasNext();) {
          PersonMedicationList medRow = (PersonMedicationList) it.next();

      %>
      <tr class="<%=FormattingHelper.getRowCss( loopCount + 1)%>">
        <td align="left">

          <%String medName = "";
            medName = FormattingHelper.formatString(medRow.getLdNmMedctn());
            String listItemId = "medicationItem_" + loopCount;

            %>
          <a href="javascript:launchMedicationDetail('<%= loopCount %>');" tabIndex="<%= tabIndex %>" id="<%= listItemId %>"><%=medName%></a>
        </td>
        <td>
          <%=FormattingHelper.formatString(medRow.getLdCdMedctnDose())%>
        </td>
        <td>
          <%=FormattingHelper.formatString(medRow.getLdTxtMedctnReason())%>
        </td>
        <td>
          <%=FormattingHelper.formatString(medRow.getLdTxtMedctnAdminPerson())%>
        </td>
        <td>
          <%=FormattingHelper.formatDate(medRow.getLdDtMedctnPresc())%>
        </td>
        <td>
          <%=FormattingHelper.formatDate(medRow.getLdDtMedctnEndDate())%>
        </td>
        <td>
          <%=FormattingHelper.formatString(medRow.getLdTxtMedctnDescrip())%>
        </td>
        
        <% 
        	String comments = medRow.getLdTxtMedctnCmnts();
        	if(comments != null || "".equals(comments)){        
        %>
        <td>
        	<img alt="checkmark" src="/grnds-docs/images/shared/checkMark_short.gif">
		</td>
		<%}else{%>
		<td>
			&nbsp;
		</td>
		<%}%>

      </tr>
      <%loopCount++;
          } // end while enumeration has more elements
        } //end big else
      } // end !FormValidation.pageHasErrorMessages

      %>
    </table>
  </div>

  <%if (!pageMode.equals(PageModeConstants.VIEW)) {%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td align="right">
        <impact:ButtonTag name="btnAddNewMedication" restrictRepost="true" navAwayCk="true" img="btnAdd" align="right" form="<%= includingFormName %>" function="return addMedicationDetail();" action="/person/MedicationDetail/displayMedicationDetail"
          tabIndex="<%= tabIndex %>" />
      </td>
    </tr>
  </table>
  <%}

    %>
</impact:ExpandableSectionTag>



