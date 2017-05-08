<%//*-----------------------------------------------------------------------------
      //*  JSP Name:     Medication Detail
      //*  Created by:   Vishala Devarakonda
      //*  Date Created: 09/10/2006
      //*
      //*  Description:
      //*  The Medication Detail page, accessed only through the sub-module, will provide a
      //*  facility for users to capture and document information associated with a person's
      //*  prescribed medication or known allergies in IMPACT.  The Medication Detail page 
      //*  will add or contain the medication information like medication name, dosage, reason, 
      //*  administering person, date prescribed, end date, and the allergies information.
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //** 

      %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.PersonMedicationList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.MedicationSubmoduleConversation"%>


<!--Start Main Content-->
<%BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);%>

<impact:validateErrors />

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="Javascript1.2">
// Check for changes before navigating off
window.onbeforeunload = function ()
{
  IsDirty();
};

</script>

<%
  int tabIndex = 1;
  //view mode
  boolean disableMedName = false;
  boolean disableDosage = false;
  boolean disableReason = false;
  boolean disableAdminPerson = false;
  boolean disablePrescDate = false;
  boolean disableEndDate = false;
  boolean disablePrescribingPerson = false;
  boolean disableAllergies = false;
  boolean disableAllergyDisc = false;
  boolean disableComments = false;
  boolean disableSaveButton = false;
  boolean allergyPresent = true;
  boolean allergyAbsent = false;
  boolean disablePharmacyInfo = false;

  String EMPTY_STRING = "";
  String medName = EMPTY_STRING;
  String dosage = EMPTY_STRING;
  String reason = EMPTY_STRING;
  String adminPerson = EMPTY_STRING;
  String prescribingPerson = EMPTY_STRING;
  String allergies = EMPTY_STRING;
  String allergyDesc = EMPTY_STRING;
  String comments = EMPTY_STRING;
  String prescDate = EMPTY_STRING;
  String endDate = EMPTY_STRING;
  String pageMode = null;
  String isAdd = EMPTY_STRING;
  
  String nmPharmacy = EMPTY_STRING;
  String phoneNumber = EMPTY_STRING;
  String addLine1  = EMPTY_STRING;
  String city = EMPTY_STRING;
  String addLine2 = EMPTY_STRING;
  String state1 = EMPTY_STRING;
  String zip = EMPTY_STRING;
  String txtAddrZip5 = EMPTY_STRING;
  String txtAddrZip4 = EMPTY_STRING;
  
  int arrayIndex = ContextHelper.getIntSafe(request, "medicationIndex");

  // Get the page mode that was passed to the Medication
  // submodule by the including JSP.
  pageMode = (String) state.getAttribute(MedicationSubmoduleConversation.PAGE_MODE_KEY, request);

  PersonMedicationList selectedMedication = (PersonMedicationList) state.getAttribute("PersonMedicationList",
                                                                                      request);
                                                                          
  if (selectedMedication != null) {
    if (request.getParameter("medicationIndex") != null) {
      isAdd = request.getParameter("isAddMedication");
    }
    if (!"true".equals(isAdd)) {
      medName = FormattingHelper.formatString(selectedMedication.getLdNmMedctn());
      dosage = selectedMedication.getLdCdMedctnDose();
      reason = FormattingHelper.formatString(selectedMedication.getLdTxtMedctnReason());
      adminPerson = FormattingHelper.formatString(selectedMedication.getLdTxtMedctnAdminPerson());
      prescribingPerson = FormattingHelper.formatString(selectedMedication.getSzTxtPrescribingPerson());
      prescDate = selectedMedication.getLdDtMedctnPresc().toString();

      if(selectedMedication.getLdDtMedctnEndDate()!= null)
      {
        endDate = selectedMedication.getLdDtMedctnEndDate().toString();
      }
      allergies = selectedMedication.getLdIndMedctnAllergies();
      allergyDesc = FormattingHelper.formatString(selectedMedication.getLdTxtMedctnDescrip());
      comments = FormattingHelper.formatString(selectedMedication.getLdTxtMedctnCmnts());
      if(allergies == null)
      {
         allergies="";
      }
      if (allergies.equals(ArchitectureConstants.Y)) {
        allergyPresent = true;
        allergyAbsent = false;
      } else if (allergies.equals(ArchitectureConstants.N)) {
        allergyPresent = false;
        allergyAbsent = true;
      } else {
        allergyPresent = true;//default
        allergyAbsent = false;
      }
      if(selectedMedication.getLdDtMedctnEndDate()!=null)
      {
      if (DateHelper.isBeforeToday(selectedMedication.getLdDtMedctnEndDate())){
        disableMedName = true;
        disableDosage = true;
        disableReason = true;
        disableAdminPerson = true;
        disablePrescDate = true;
        disableEndDate = true;
        disableAllergies = true;
        disableAllergyDisc = false;
        disablePharmacyInfo = true;
     }
     }
     nmPharmacy = FormattingHelper.formatString(selectedMedication.getLdPharmacy());
     phoneNumber = FormattingHelper.formatString(selectedMedication.getLdPhoneNumber());
     addLine1  = FormattingHelper.formatString(selectedMedication.getLdAddLine1());
     city = FormattingHelper.formatString(selectedMedication.getLdCity());
     addLine2 = FormattingHelper.formatString(selectedMedication.getLdAddLine2());
     state1 = FormattingHelper.formatString(selectedMedication.getLdState1());
     zip = FormattingHelper.formatString(selectedMedication.getLdZip());
     if (!EMPTY_STRING.equals(zip) ){
       int len = zip.length();
       if (len>=5){
          txtAddrZip5 = zip.substring(0,5);
         }
         if (len>5){
           txtAddrZip4 = zip.substring(5,len);
         }
     }
    }
  } //end if medretso not null
%>

<script type="text/javascript" language="JavaScript1.2">
function setHdnEndDate()
{
<%   if(!"true".equals(isAdd))
%>
   frmMedicationDetail.hdnMedEndDate.value = selectedMedication.getLdDtMedctnEndDate();
}
//End Java Script
</script>



<impact:validateForm name="frmMedicationDetail" method="post" action="/person/MedicationDetail/saveMedicationDetail" pageMode="<%= pageMode %>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.MedicationCustomValidation" schema="/WEB-INF/Constraints.xsd">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
  <impact:validateInput type="hidden" name="hdnMedEndDate" value="12/31/3500"/>
  <impact:validateInput type="hidden" name="isAddMedication" value="<%= isAdd %>" />
  <impact:validateInput type="hidden" name="medicationIndex" value="<%= FormattingHelper.formatInt(arrayIndex) %>" />

  <table width="100%" class="tableborder" cellpadding="3" cellspacing="0">
    <tr>
      <th colspan="8">
        Medication Information
      </th>
    <tr>
      <td width="50%">
        <impact:validateInput tabIndex="<%= tabIndex++ %>" disabled="<%= "" + disableMedName %>" type="text" label="Medication Name" id="szNmMedctn" name="szNmMedctn" size="20" maxLength="80" constraint="Paragraph80" required="true" value="<%=medName %>"
          cssClass="formInput" />
      </td>
      <td>
      	 &nbsp;
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" disabled="<%= "" + disableDosage %>" label="Frequency" id="szCdMedctnDose" name="szCdMedctnDose" width="20%" value="<%=dosage%>" required="true" codesTable="CMDDOSE" />
      </td>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" disabled="<%= "" + disableReason %>" type="text" label="Reason" id="szTxtMedctnReason" name="szTxtMedctnReason" size="20" maxLength="80" constraint="Paragraph80" value="<%= reason%>"
          cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" disabled="<%= "" + disableAdminPerson %>" type="text" label="Administering Person" id="szTxtMedctnAdminPerson" name="szTxtMedctnAdminPerson" size="20" maxLength="80" constraint="Paragraph80"
          value="<%= adminPerson %>" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate type="text" name="szDtMedctnPresc" disabled="<%= "" + disablePrescDate %>" label="Start Date" constraint="Date" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" value="<%= prescDate %>" size="10" required="true"
          tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateDate type="text" name="szDtMedctnEndDate" disabled="<%= "" + disableEndDate %>" label="End Date" constraint="Date" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" value="<%= endDate %>" size="10" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" disabled="<%= "" + disablePrescribingPerson %>" type="text" label="Prescribing Person" id="szTxtPrescribingPerson" name="szTxtPrescribingPerson" size="20" maxLength="80" constraint="Paragraph80"
          value="<%= prescribingPerson %>" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <th colspan="8">
        Pharmacy Information
      </th>
    <tr>
    <tr>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" type="text" disabled="<%= "" + disablePharmacyInfo %>" label="Pharmacy" id="szNmPharamacy" name="szNmPharamacy" size="20" maxLength="80" constraint="Paragraph80" value="<%=nmPharmacy %>"
          cssClass="formInput" />
      </td>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" type="text" disabled="<%= "" + disablePharmacyInfo %>" label="Phone Number" id="szPhoneNumber" name="szPhoneNumber" size="14" maxLength="14" constraint="Phone" value="<%=FormattingHelper.formatPhone(phoneNumber)%>"
          cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" type="text" disabled="<%= "" + disablePharmacyInfo %>" label="Address Line 1" id="szAddLine1" name="szAddLine1" size="20" maxLength="80" constraint="Paragraph80" value="<%=addLine1 %>"
          cssClass="formInput" />
      </td>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" type="text" disabled="<%= "" + disablePharmacyInfo %>" label="City" id="szCity" name="szCity" size="20" maxLength="80" constraint="Paragraph80" value="<%=city%>"
          cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" type="text" disabled="<%= "" + disablePharmacyInfo %>" label="Address Line 2" id="szAddLine2" name="szAddLine2" size="20" maxLength="80" constraint="Paragraph80" value="<%=addLine2 %>"
          cssClass="formInput" />
      </td>
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>"  label="State" disabled="<%= "" + disablePharmacyInfo %>" id="szState" name="szState" width="20%" value="<%=state1%>" codesTable="CSTATE" />
      </td>
    </tr>
    <tr>
      <td>
        &nbsp;
      </td>
      <td>
        &nbsp;
      </td>
      <td>
        <impact:validateInput type="text" name="txtZip5" label="Zip" cssClass="formInput" value="<%=txtAddrZip5%>" maxLength="5" size="5" tabIndex="<%=tabIndex++%>" constraint="Digit5" />
    -
      <impact:validateInput type="text" name="txtZip4"  tabIndex="<%=tabIndex++%>" cssClass="formInput" value="<%=txtAddrZip4%>" constraint="Digit4" maxLength="4" size="4" />
      </td>
    </tr>
    <tr>
      <th colspan="8">
        Allergy Information 
      </th>
    <tr>
    <tr>
      <td>
        <span class="formCondRequiredText">&#8225;</span>Allergies:
      </td>

      <td>
        <impact:validateInput checked="<%= String.valueOf( allergyAbsent ) %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" disabled="<%= "" + disableAllergies %>" tabIndex="<%= tabIndex++ %>" value="N" type="radio" name="szIndMedctnAllergies" label="No"
          cssClass="formInput" />

        <impact:validateInput checked="<%= String.valueOf( allergyPresent ) %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" disabled="<%= "" + disableAllergies %>" tabIndex="<%= tabIndex++ %>" value="Y" type="radio" name="szIndMedctnAllergies" label="Yes"
          cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateTextArea tabIndex="<%= tabIndex++ %>" disabled="<%= "" + disableAllergyDisc %>" cols="80" rows="4" maxLength="300" constraint="Paragraph300" conditionallyRequired="true" label="Allergy Description" name="szTxtMedctnDescrip">
          <%=allergyDesc%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td >
        <impact:validateTextArea tabIndex="<%= tabIndex++ %>" disabled="<%= "" + disableComments %>" cols="80" rows="4" maxLength="300" label="Comments" constraint="Paragraph300" name="szTxtMedctnCmnts">
          <%=comments%>
        </impact:validateTextArea>
      </td>
    </tr>
  </table>
  <%if (!disableSaveButton) {%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td align="right">
        <impact:ButtonTag name="btnSave1" img="btnSave" form="frmMedicationDetail" function="setHdnEndDate(selectedMedication.getLdDtMedctnEndDate());"  function ="setIsDirtyCalled(false);" action="/person/MedicationDetail/saveMedicationDetail" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>
  <%}%>
</impact:validateForm>

