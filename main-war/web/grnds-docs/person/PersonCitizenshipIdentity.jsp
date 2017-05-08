<%//*-----------------------------------------------------------------------------
      //*  JSP Name:     Citizenship and Identity
      //*  Created by:   Barak Pinkston
      //*  Date Created: 03/19/2007
      //*
      //*  Description:
      //*  The Citizenship and Identity page is accessed only through the third level tab via the Person Detail.
      //*  This page will contain more person detail related to citizenship and identity.
      //*  Sections:
      //*  Birth Information
      //*  Method of Age Verification
      //*  Method of Citizenship Verification
      //*  Identity Verification (Adult)
      //*  Identity Verification (Under 16 Only)
      //*  Permanent Resident Refugee
      //*  Undetermined/Other Status
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  -------------     -------------
      //**  11/25/2008 arege            STGAP00009538 Set the correct pageMode, User navigates to the 
      //**                              Citizenship and Identity page from within a case they are assigned to,
      //**                              and that page should be editable. 
      //**                      
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonCitizenshipIdentityConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays" %>


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

   BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
   UserProfile user = UserProfileHelper.getUserProfile( request );
   String action = "/person/PersonCitizenshipIdentity/savePersonCitizenshipIdentity";
     List excludeOptions = new ArrayList();
     excludeOptions.add(CodesTables.CCTZNSTA_VES);

   //Get the output object from the request
   PersonCitizenshipIdentitylRetrieveSO personCitizenshipIdentitylRetrieveSO = 
                            (PersonCitizenshipIdentitylRetrieveSO) state.getAttribute("PersonCitizenshipIdentitylRetrieveSO", request);
                            
   PersonCitizenshipIdentityList personCitizenshipIdentityBean = personCitizenshipIdentitylRetrieveSO.getPersonCitizenshipIdentityBean();                            
                            
   if (personCitizenshipIdentitylRetrieveSO == null)
   {
     personCitizenshipIdentitylRetrieveSO = new PersonCitizenshipIdentitylRetrieveSO();
   }                            


   int tabIndex = 1;   
  // String pageMode = (String) state.getAttribute(PersonCitizenshipIdentityConversation.PAGE_MODE_KEY, request);
  // STGAP00009538 commented out above line and added the line below.
   String pageMode = PageMode.getPageMode(request); 
   String szCdPersonBirthState = StringHelper.EMPTY_STRING;
   String birthCounty = StringHelper.EMPTY_STRING;
   String indNonUSBorn = StringHelper.EMPTY_STRING;
   String birthCity = StringHelper.EMPTY_STRING;
   //String szCdCntryOfOrigin = StringHelper.EMPTY_STRING;
   // set default value as United States
   String szCdCntryOfOrigin = CodesTables.CCNTRY_USA;
   String szCdCitizenshipStatus = StringHelper.EMPTY_STRING;  
   String dtEntryUS = StringHelper.EMPTY_STRING;     
   String dtBirth = StringHelper.EMPTY_STRING;
   int age = 0;
   String szCdMotherMarried = StringHelper.EMPTY_STRING;
   String outOfStateCounty = StringHelper.EMPTY_STRING;
   
   //Method of Age Verification   
   List methodOfCitizenshipVerificationList = null;
   List checkedMethodOfCitizenshipVerificationList = null;   
   
   //Method of Citizenship Verification : US Citizen   
   List usCitizenList = null;
   List checkedUSCitizenList = null; 
   
   //Method of Citizenship Verification : Identity Verification (Adult)   
   List identityVerificationAdultList = null;
   List checkedIdentityVerificationAdultList = null;   
   
   //Method of Citizenship Verification : Identity Verification (Under 16 Only)   
   List identityVerificationUnder16OnlyList = null;
   List checkedIdentityVerificationUnder16OnlyList = null;    
   
   //Method of Citizenship Verification : Permanent Resident/Refugee   
   List permanentResRefugeeList = null;
   List checkedPermanentResRefugeeList = null;
   
   //Method of Citizenship Verification : Other Qualified Alien   
   List otherQualifiedAlienList = null;
   List checkedOtherQualifiedAlienList = null;   
   
   //Method of Citizenship Verification : Undetermined/Other Staus   
   List undeterminedList = null;
   List checkedUndeterminedList = null;               
      
   
   if(personCitizenshipIdentityBean != null){
      szCdPersonBirthState = personCitizenshipIdentityBean.getSzCdPersonBirthState();      
      birthCity = personCitizenshipIdentityBean.getSzCdBirthCity();
      outOfStateCounty = personCitizenshipIdentityBean.getOutOfStateCounty();
      szCdCitizenshipStatus = personCitizenshipIdentityBean.getSzCdCitizenshipStatus();
      // only write over if there is data so default value (United States) stays
      if (StringHelper.isValid(personCitizenshipIdentityBean.getSzCdCntryOfOrigin())) {
        szCdCntryOfOrigin = personCitizenshipIdentityBean.getSzCdCntryOfOrigin();
      }
      //szCdCntryOfOrigin = personCitizenshipIdentityBean.getSzCdCntryOfOrigin();
      indNonUSBorn = personCitizenshipIdentityBean.getIndNonUSBorn();
      dtEntryUS = FormattingHelper.formatDate(personCitizenshipIdentityBean.getDtEntryUS());
      szCdMotherMarried = personCitizenshipIdentityBean.getSzCdMotherMarried();
      dtBirth = FormattingHelper.formatDate(personCitizenshipIdentityBean.getBirthDate());
      
      // if birthdate is not null, get age from birthdate
      if (personCitizenshipIdentityBean.getBirthDate() != null && personCitizenshipIdentityBean.getBirthDate() != null )
      {
          age = DateHelper.getAge(personCitizenshipIdentityBean.getBirthDate());
      }
                     
      birthCounty = personCitizenshipIdentityBean.getSzCdBirthCounty();
      outOfStateCounty = personCitizenshipIdentityBean.getOutOfStateCounty();                    
      
      
      //Method of Age Verification      
      methodOfCitizenshipVerificationList = new ArrayList(Lookup.getCategoryCollection(CodesTables.CAGEVERF));
      checkedMethodOfCitizenshipVerificationList = new ArrayList();      
      
      if(personCitizenshipIdentityBean.getMethodAgeVerifications() != null)
      {        
        checkedMethodOfCitizenshipVerificationList = Arrays.asList(personCitizenshipIdentityBean.getMethodAgeVerifications());         
      }
      
      //Method of Citizenship Verification : US Citizen      
      usCitizenList = new ArrayList(Lookup.getCategoryCollection(CodesTables.CCERTVER));
      checkedUSCitizenList = new ArrayList();      
      
      if(personCitizenshipIdentityBean.getUSCitizenVerifications() != null)
      {        
        checkedUSCitizenList = Arrays.asList(personCitizenshipIdentityBean.getUSCitizenVerifications());        
      }      
      
      //Method of Citizenship Verification : Identity Verification (Adult)      
      identityVerificationAdultList = new ArrayList(Lookup.getCategoryCollection(CodesTables.CIDENTAD));
      checkedIdentityVerificationAdultList = new ArrayList();     
      
      if(personCitizenshipIdentityBean.getIdentityAdultVerifications() != null)
      {       
        checkedIdentityVerificationAdultList = Arrays.asList(personCitizenshipIdentityBean.getIdentityAdultVerifications());       
      }           
      
      
      //Method of Citizenship Verification : Identity Verification (Under 16 Only)      
      identityVerificationUnder16OnlyList = new ArrayList(Lookup.getCategoryCollection(CodesTables.CIDENTUN));
      checkedIdentityVerificationUnder16OnlyList = new ArrayList();   
      
      if(personCitizenshipIdentityBean.getIdentityUnder16Verifications() != null)
      {        
        checkedIdentityVerificationUnder16OnlyList = Arrays.asList(personCitizenshipIdentityBean.getIdentityUnder16Verifications());        
      }             
    
      //Method of Citizenship Verification : Permanent Resident/Refugee      
      permanentResRefugeeList = new ArrayList(Lookup.getCategoryCollection(CodesTables.CPERMRES));
      checkedPermanentResRefugeeList = new ArrayList();         
    
      if(personCitizenshipIdentityBean.getPermanentResidentRefugee() != null)
      {        
        checkedPermanentResRefugeeList = Arrays.asList(personCitizenshipIdentityBean.getPermanentResidentRefugee());        
      }       
    
      //Method of Citizenship Verification : Other Qualified Alien      
      otherQualifiedAlienList = new ArrayList(Lookup.getCategoryCollection(CodesTables.COTHRQUA));
      checkedOtherQualifiedAlienList = new ArrayList();            
    
      if(personCitizenshipIdentityBean.getOtherQualifiedAlien() != null)
      {        
        checkedOtherQualifiedAlienList = Arrays.asList(personCitizenshipIdentityBean.getOtherQualifiedAlien());        
      }          
      
      //Method of Citizenship Verification : Undetermined/Other Staus      
      undeterminedList = new ArrayList(Lookup.getCategoryCollection(CodesTables.CUDETALN));
      checkedUndeterminedList = new ArrayList(); 
      
      if(personCitizenshipIdentityBean.getUndeterminedStatus() != null)
      {        
        checkedUndeterminedList = Arrays.asList(personCitizenshipIdentityBean.getUndeterminedStatus());        
      }                 
      
   }  
%>

<impact:validateForm name="frmPersonCitizenshipIdentity" 
                     method="post" 
                     action="<%=action%>" 
                     pageMode="<%= pageMode %>" 
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.CitizenshipIdentityCustomValidation" 
                     schema="/WEB-INF/Constraints.xsd">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />  
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
      <th colspan="6">Birth Information</th>
  </tr>
  <tr>
    <td><impact:validateSelect label="US Birth State"
                              blankValue="<%= ArchitectureConstants.TRUE %>"
                              conditionallyRequired="true"
                              overrideDisplayBadCodes="true"
                              codesTable="CSTATE"                              
                              name="selSzCdPersonBirthState"
                              style="WIDTH: 160px"
                              tabIndex="<%= tabIndex++ %>"
                              disabled=""
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szCdPersonBirthState)%>"/>
    </td>
    <td><impact:validateSelect label="Birth County"
                              blankValue="<%= ArchitectureConstants.TRUE %>"
                              conditionallyRequired="true"
                              overrideDisplayBadCodes="true"
                              codesTable="CCOUNT"                              
                              name="selSzCdPersonBirthCounty"
                              style="WIDTH: 160px"
                              tabIndex="<%= tabIndex++ %>"
                              disabled=""
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(birthCounty)%>"/>
     </td>                   
  </tr>
  <tr>
    <td><impact:validateInput type="text"
                              label="Birth City"
                              constraint="Paragraph"
                              conditionallyRequired="true"
                              name="txtSzCdPersonBirthCity"
                              size="20"
                              maxLength="20"
                              onChange=""
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(birthCity)%>"/>
    </td>
    <td><impact:validateInput type="text"
                              label="Out of State County"
                              conditionallyRequired="true"
                              constraint="Paragraph"
                              name="txtSzCdOutOfStateCounty"
                              size="20"
                              maxLength="20"
                              onChange=""
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(outOfStateCounty)%>"/>
    </td>                  
  </tr>   
    <tr>    
    <td><impact:validateSelect label="Citizenship/Alien Status"
                              blankValue="<%= ArchitectureConstants.TRUE %>"
                              overrideDisplayBadCodes="true"
                              codesTable="CCTZNSTA"
                              excludeOptions="<%= excludeOptions %>"
                              required="<%= ArchitectureConstants.TRUE %>"
                              name="selSzCdCitizenshipStatus"
                              style="WIDTH: 160px"
                              tabIndex="<%= tabIndex++ %>"
                              disabled=""
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szCdCitizenshipStatus)%>"/>        
     </td>                   
     <td><impact:validateSelect label="Birth Country"
                              blankValue="<%= ArchitectureConstants.TRUE %>"
                              overrideDisplayBadCodes="true"
                              orderBy="decode"
                              codesTable="CCNTRY"
                              required="<%= ArchitectureConstants.FALSE %>"
                              name="selSzCdCntryOfOrigin"
                              style="WIDTH: 160px"
                              tabIndex="<%= tabIndex++ %>"
                              disabled=""
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szCdCntryOfOrigin)%>"/>
        &nbsp;&nbsp;                      
        <impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%=FormattingHelper.formatString(indNonUSBorn)%>"
                              disabled=""
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              type="checkbox"
                              name="cbxBIndUSCitizen"
                              label="Non-US Born"
                              cssClass="formInput" />
     </td>                   
  </tr>  
    <tr>
     <td><impact:validateDate name="txtDtDtEntryUS"
                              label="Entry Date into the US"
                              conditionallyRequired="true"
                              constraint="Date"
                              onBlur=""
                              conditionallyRequired="true"
                              value="<%= dtEntryUS %>"
                              size="10"
                              onChange=""
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" />
     </td>
     <td><impact:validateSelect label="Mother Married at Child's Birth"
                              blankValue="<%= ArchitectureConstants.TRUE %>"
                              overrideDisplayBadCodes="true"
                              codesTable="CMOTHMAR"
                              conditionallyRequired="true"
                              name="selSzCdMotherMarried"
                              style="WIDTH: 160px"
                              tabIndex="<%= tabIndex++ %>"
                              disabled=""
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szCdMotherMarried)%>"/>
     </td>
    </tr>
    <tr>
    <td>DOB:</td>
     <td><%=dtBirth%></td>
     <impact:validateInput type="hidden" name="dtBirth" value="<%=dtBirth%>"/>
     <td>Age:</td>
    <td><%=FormattingHelper.formatInt(age)%></td>    
    </tr>
  </table> 
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
        <th colspan="6">Method of Age Verification</th>
    </tr>
    <tr>
            <td>
              <impact:castorCheckbox
                castorEnum="<%= Collections.enumeration(methodOfCitizenshipVerificationList) %>"
                name="chkMethodOfCitizenshipVerification"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%= checkedMethodOfCitizenshipVerificationList %>"
                columns="2"
                isRuled="false"
                isHorizontal="false"                
                tabIndex="<%= tabIndex++ %>"/>
            </td>
    </tr>
  </table>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="6">Method of Citizenship Verification</th>
    </tr>
    <tr>
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
        <tr>
         <th colspan="6">US Citizen</th>
        </tr>
        <tr>
            <td>
              <impact:castorCheckbox
                castorEnum="<%= Collections.enumeration(usCitizenList) %>"
                name="chkUSCitizen"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%= checkedUSCitizenList %>"
                columns="2"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%= tabIndex++ %>"/>
            </td>
         </tr>
         <tr>
           <th colspan="6">Identity Verification (Adult)</th>
         </tr>
        <tr>
            <td>
              <impact:castorCheckbox
                castorEnum="<%= Collections.enumeration(identityVerificationAdultList) %>"
                name="chkIdentityVerificationAdult"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%= checkedIdentityVerificationAdultList %>"
                columns="2"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%= tabIndex++ %>"/>
            </td>
        </tr>
        <tr>
           <th colspan="6">Identity Verification (Under 16 Only)</th>
         </tr>
        <tr>
            <td>
              <impact:castorCheckbox
                castorEnum="<%= Collections.enumeration(identityVerificationUnder16OnlyList) %>"
                name="chkIdentityVerificationUnder16Only"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%= checkedIdentityVerificationUnder16OnlyList %>"
                columns="2"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%= tabIndex++ %>"/>
            </td>
        </tr>        
        <tr>
           <th colspan="6">Permanent Resident/Refugee</th>
         </tr>
        <tr>
            <td>
             <impact:castorCheckbox
                castorEnum="<%= Collections.enumeration(permanentResRefugeeList) %>"
                name="chkPermResRefugee"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%= checkedPermanentResRefugeeList %>"
                columns="2"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%= tabIndex++ %>"/>
            </td>
        </tr>   
        <tr>
           <th colspan="6">Other Qualified Alien</th>
         </tr>
        <tr>
            <td>
              <impact:castorCheckbox
                castorEnum="<%= Collections.enumeration(otherQualifiedAlienList) %>"
                name="chkOtherQualifiedAlien"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%= checkedOtherQualifiedAlienList %>"
                columns="2"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%= tabIndex++ %>"/>
            </td>
        </tr>            
        <tr>
           <th colspan="6">Undetermined/Other Status</th>
         </tr>
        <tr>
            <td>
              <impact:castorCheckbox
                castorEnum="<%= Collections.enumeration(undeterminedList) %>"
                name="chkUndetermined"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%= checkedUndeterminedList %>"
                columns="2"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%= tabIndex++ %>"/>
            </td>
        </tr>                                              
      </table>
    </tr>    
  </table>
  <% if(PageModeConstants.EDIT.equals(pageMode)){ %>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td align="right">
        <impact:ButtonTag name="btnSave1" 
                          img="btnSave" 
                          form="frmPersonCitizenshipIdentity"                            
                          function ="setIsDirtyCalled(false);" 
                          action="<%=action%>" 
                          restrictRepost="false" 
                          preventDoubleClick="false" 
                          tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>
 <%}%>
</impact:validateForm>