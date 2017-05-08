<%
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  6/17/08   charden			  STGAP00008647: changed code around to catch null
//**							  b_personCitizenshipIdentitylRetrieveSO object
//**   1/2/08   charden           STGAP00010009: added added logic to null check of checkedUSCitizen
//**                              to correctly catch empty/null object. Key was being set as parameter
//**                              name which was causing null pointer in grnds architecture
//**  11/11/09  mxpatel           37462: removed changes made for STGAP00010009
//**
%>


<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes"%>

<%
{
  String _bgColor = "#FFFFFF";
  int NUMBER_OF_CITIZENSHIP_ROWS = 9;
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  boolean _evalConclusionChecked = false; 
  String _disableCitizenship = "" + (Boolean) request.getAttribute("disableCitizenship");
  FceEligibilityDB _fceEligibilityDB = (FceEligibilityDB) request.getAttribute("fceEligibilityDB");
  PersonCitizenshipIdentitylRetrieveSO _personCitizenshipIdentitylRetrieveSO = (PersonCitizenshipIdentitylRetrieveSO) request.getAttribute("personCitizenshipIdentitylRetrieveSO");    

  if (_personCitizenshipIdentitylRetrieveSO == null)
   {
     _personCitizenshipIdentitylRetrieveSO = new PersonCitizenshipIdentitylRetrieveSO();
   }
   //STGAP00008647 moved line below to after the if statement so that it would not be affected by null _personCitizenshipIdentitylRetrieveSO object
   PersonCitizenshipIdentityList _personCitizenshipIdentityBean = _personCitizenshipIdentitylRetrieveSO.getPersonCitizenshipIdentityBean();
   
   //Method of Citizenship Verification : US Citizen
        Map<String, String> methodUSCitizenVerificationList = new HashMap<String, String>();
        List<CodeAttributes> uSCitizenVerificationList = Lookup.getCategoryCollection(CodesTables.CCERTVER);
        Iterator<CodeAttributes> uSCitizenVerificationList_it = uSCitizenVerificationList.iterator();
        
        while (uSCitizenVerificationList_it.hasNext()){
          CodeAttributes attribute = uSCitizenVerificationList_it.next();
          String code = attribute.getCode();
          if ("CBC".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpBirthCrtfctUs");
          } else if ("RBH".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpHospitalCrtfct");
          } else if ("CID".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpUsIdCard");
          } else if ("FAD".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpFinalAdoptDecree");
          } else if ("RBA".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpBirthAbroad");
          } else if ("MRS".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpMiltryBirthRcrd");
          } else if ("EHR".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpUsHsptlBrthRcrd");
          } else if ("CBR".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpCensusBirthRcrd");
          } else if ("CRB".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpCertReportBirth");
          } else if ("NCF".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpNtrlztnCrtfct");
          } else if ("USP".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpPassport");
          } else if ("AIC".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpAmerIndianCrd");
          } else if ("CSE".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpCivilServiceEmp");
          } else if ("NMC".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpNorthMarianaId");
          } else if ("BVS".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpVitalBirthRcrd");
          } else if ("COB".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpConfrmBirth");
          } else if ("LHI".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpLifeInsBrthRcrd");
          } else if ("MRB".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpMedBirthRcrd");
          } else if ("ECN".equals(code)){
            methodUSCitizenVerificationList.put(code, "indCtznshpEvaluation");
          }
        }
        
        //Method of Citizenship Verification : Identity Verification (Adult)
        Map<String, String> methodIdentityAdultVerificationList = new HashMap<String, String>();
        List<CodeAttributes> identityAdultVerificationList = Lookup.getCategoryCollection(CodesTables.CIDENTAD);
        Iterator<CodeAttributes> identityAdultVerificationList_it = identityAdultVerificationList.iterator();
        while (identityAdultVerificationList_it.hasNext()){
          CodeAttributes attribute = identityAdultVerificationList_it.next();
          String code = attribute.getCode();
          if ("CDL".equals(code)){
            methodIdentityAdultVerificationList.put(code, "indCtznshpDriverLicOrId");
          } else if ("IDD".equals(code)){
            methodIdentityAdultVerificationList.put(code, "indCtznshpDocImmigNatAct");
          } else if ("CIB".equals(code)){
            methodIdentityAdultVerificationList.put(code, "indCtznshpCertIndBlood");
          }
        }
        
        //Method of Citizenship Verification : Identity Verification (Under 16 Only)
        Map<String, String> methodIdentityUnder16VerificationList = new HashMap<String, String>();
        List<CodeAttributes> identityUnder16VerificationList = Lookup.getCategoryCollection(CodesTables.CIDENTUN);
        Iterator<CodeAttributes> identityUnder16VerificationList_it = identityUnder16VerificationList.iterator();
        while (identityUnder16VerificationList_it.hasNext()){
          CodeAttributes attribute = identityUnder16VerificationList_it.next();
          String code = attribute.getCode();
          if ("SIP".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpSchoolIdPhoto");
          } else if ("SRD".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpSchoolRec");
          } else if ("DNS".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpDaycareNurseRcrd");
          } else if ("MID".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpMilitaryDepdntId");
          } else if ("CDH".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpClinicDocHosDoc");
          } else if ("ACI".equals(code)){
            methodIdentityUnder16VerificationList.put(code, "indCtznshpAffidavitSigned");
          }
        }  

        //Method of Citizenship Verification : Permanent Resident/Refugee
        Map<String, String> methodPermResidentRefugeeVerificationList = new HashMap<String, String>();
        List<CodeAttributes> permResidentRefugeeVerificationList = Lookup.getCategoryCollection(CodesTables.CPERMRES);
        Iterator<CodeAttributes> permResidentRefugeeVerificationList_it = permResidentRefugeeVerificationList.iterator();
        while (permResidentRefugeeVerificationList_it.hasNext()){
          CodeAttributes attribute = permResidentRefugeeVerificationList_it.next();
          String code = attribute.getCode();
          if ("ARR".equals(code)){
            methodPermResidentRefugeeVerificationList.put(code, "indCtznshpResidentCard");
          } else if ("REF".equals(code)){
            methodPermResidentRefugeeVerificationList.put(code, "indCtznshpRefugee");
          } 
        }
        
        //Method of Citizenship Verification : Other Qualified Alien
        Map<String, String> methodOtherQualifiedAlienVerificationList = new HashMap<String, String>();
        List<CodeAttributes> otherQualifiedAlienVerificationList = Lookup.getCategoryCollection(CodesTables.COTHRQUA);
        Iterator<CodeAttributes> otherQualifiedAlienVerificationList_it = otherQualifiedAlienVerificationList.iterator();
        while (otherQualifiedAlienVerificationList_it.hasNext()){
          CodeAttributes attribute = otherQualifiedAlienVerificationList_it.next();
          String code = attribute.getCode();
          if ("DRA".equals(code)){
            methodOtherQualifiedAlienVerificationList.put(code, "indCtznshpAttorneyReview");
          } else if ("STV".equals(code)){
            methodOtherQualifiedAlienVerificationList.put(code, "indCtznshpStudentVisa");
          } 
        }

        //Method of Citizenship Verification : Undetermined/Other Staus
        Map<String, String> methodUndeterminedOtherVerificationList = new HashMap<String, String>();
        List<CodeAttributes> undeterminedOtherVerificationList = Lookup.getCategoryCollection(CodesTables.CUDETALN);
        Iterator<CodeAttributes> undeterminedOtherVerificationList_it = undeterminedOtherVerificationList.iterator();
        while (undeterminedOtherVerificationList_it.hasNext()){
          CodeAttributes attribute = undeterminedOtherVerificationList_it.next();
          String code = attribute.getCode();
          if ("FBC".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpBirthCrtfctFor");
          } else if ("NDC".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpNoDocumentation");
          } else if ("CUS".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpChldFound");
          } else if ("UIM".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpUndocImmigrant");
          } else if ("FOS".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpForDocumentation");
          } else if ("LIS".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpLeglImmiStatExp");
          } else if ("UMC".equals(code)){
            methodUndeterminedOtherVerificationList.put(code, "indCtznshpUnaccMinorChild");
          }
        } 
        
   String[] checkedUSCitizen = null;
   String[] checkedIdentityVerificationAdult = null;
   String[] checkedIdentityVerificationUnder16Only = null;
   String[] checkedPermanentResRefugee = null;
   String[] checkedOtherQualifiedAlien = null;
   String[] checkedUndetermined = null; 
   
   if(_personCitizenshipIdentityBean != null){
   	  if(_personCitizenshipIdentityBean.getUSCitizenVerifications() != null)
      {
      	checkedUSCitizen = _personCitizenshipIdentityBean.getUSCitizenVerifications();
      }
      if(_personCitizenshipIdentityBean.getIdentityAdultVerifications() != null)
      {
        checkedIdentityVerificationAdult = _personCitizenshipIdentityBean.getIdentityAdultVerifications();
      }
      if(_personCitizenshipIdentityBean.getIdentityUnder16Verifications() != null)
      {
        checkedIdentityVerificationUnder16Only = _personCitizenshipIdentityBean.getIdentityUnder16Verifications();  
      }
      if(_personCitizenshipIdentityBean.getPermanentResidentRefugee() != null)
      {
        checkedPermanentResRefugee = _personCitizenshipIdentityBean.getPermanentResidentRefugee();
      }
      if(_personCitizenshipIdentityBean.getOtherQualifiedAlien() != null)
      {
        checkedOtherQualifiedAlien = _personCitizenshipIdentityBean.getOtherQualifiedAlien();
      }
      if(_personCitizenshipIdentityBean.getUndeterminedStatus() != null)
      {
        checkedUndetermined = _personCitizenshipIdentityBean.getUndeterminedStatus();
      }
   }
%>
        <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" bgcolor="<%= _bgColor %>">
     <tr>
          <th colspan="2"> US Citizen </th>
         </tr>
 <%
  if (checkedUSCitizen == null || checkedUSCitizen.length == 0){
%>
 <tr>
   <td colspan="2">N/A</td>
 </tr>
<%
  } else {
    for (int i = 1; i <= checkedUSCitizen.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){
%>
  <tr>
    <td width="50%"><%=Lookup.simpleDecodeSafe(CodesTables.CCERTVER, checkedUSCitizen[i-1])%></td>
<%
        if (i == checkedUSCitizen.length){
%>
  </tr>
<%
        }
      } else {
%>
    <td><%=Lookup.simpleDecodeSafe(CodesTables.CCERTVER, checkedUSCitizen[i-1])%></td>
  </tr>
<%
      }
%>    
      <impact:validateInput type="hidden" 
                      name="<%=  methodUSCitizenVerificationList.get(checkedUSCitizen[i-1]) %>" 
                      value="true"/>
<%  
      if ("ECN".equals(checkedUSCitizen[i-1])){
        _evalConclusionChecked = true;
      }   
    }
  }
%>       
 <tr>
   <th colspan="2"> Identity Verification (Adult) </th>
 </tr>
 <%
  if (checkedIdentityVerificationAdult == null || checkedIdentityVerificationAdult.length == 0){
%>
 <tr>
   <td colspan="2">N/A</td>
 </tr>
<%
  } else {
    for (int i = 1; i <= checkedIdentityVerificationAdult.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){
%>
  <tr>
    <td width="50%"><%=Lookup.simpleDecodeSafe(CodesTables.CIDENTAD, checkedIdentityVerificationAdult[i-1])%></td>
<%
        if (i == checkedIdentityVerificationAdult.length){
%>
  </tr>
<%
        }
      } else {
%>
    <td><%=Lookup.simpleDecodeSafe(CodesTables.CIDENTAD, checkedIdentityVerificationAdult[i-1])%></td>
  </tr>
<%
      }
%>    
      <impact:validateInput type="hidden" 
                      name="<%=  methodIdentityAdultVerificationList.get(checkedIdentityVerificationAdult[i-1]) %>" 
                      value="true"/>
<%       
    }
  }
%> 
 <tr>
   <th colspan="2"> Identity Verification (Under 16 Only) </th>
 </tr>
<%
  if (checkedIdentityVerificationUnder16Only == null || checkedIdentityVerificationUnder16Only.length == 0){
%>
 <tr>
   <td colspan="2">N/A</td>
 </tr>
<%
  } else {
    for (int i = 1; i <= checkedIdentityVerificationUnder16Only.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){
%>
  <tr>
    <td width="50%"><%=Lookup.simpleDecodeSafe(CodesTables.CIDENTUN, checkedIdentityVerificationUnder16Only[i-1])%></td>
<%
        if (i == checkedIdentityVerificationUnder16Only.length){
%>
  </tr>
<%
        }
      } else {
%>
    <td><%=Lookup.simpleDecodeSafe(CodesTables.CIDENTUN, checkedIdentityVerificationUnder16Only[i-1])%></td>
  </tr>
<%
      }
%>    
      <impact:validateInput type="hidden" 
                      name="<%=  methodIdentityUnder16VerificationList.get(checkedIdentityVerificationUnder16Only[i-1]) %>" 
                      value="true"/>
<%                           
    }
  }
%>   
  <tr>
    <th colspan="2">Permanent Resident</th>
  </tr>
 <%
  if (checkedPermanentResRefugee == null || checkedPermanentResRefugee.length == 0){
%>
 <tr>
   <td colspan="2">N/A</td>
 </tr>
<%
  } else {
    for (int i = 1; i <= checkedPermanentResRefugee.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){
%>
  <tr>
    <td width="50%"><%=Lookup.simpleDecodeSafe(CodesTables.CPERMRES, checkedPermanentResRefugee[i-1])%></td>
<%
        if (i == checkedPermanentResRefugee.length){
%>
  </tr>
<%
        }
      } else {
%>
    <td><%=Lookup.simpleDecodeSafe(CodesTables.CPERMRES, checkedPermanentResRefugee[i-1])%></td>
  </tr>
<%
      }
%>    
      <impact:validateInput type="hidden" 
                      name="<%=  methodPermResidentRefugeeVerificationList.get(checkedPermanentResRefugee[i-1]) %>" 
                      value="true"/>
<%         
    }
  }
%> 
  <tr>
    <th colspan="2">Other Qualified Alien</th>
  </tr>
 <%
  if (checkedOtherQualifiedAlien == null || checkedOtherQualifiedAlien.length == 0){
%>
 <tr>
   <td colspan="2">N/A</td>
 </tr>
<%
  } else {
    for (int i = 1; i <= checkedOtherQualifiedAlien.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){
%>
  <tr>
    <td width="50%"><%=Lookup.simpleDecodeSafe(CodesTables.COTHRQUA, checkedOtherQualifiedAlien[i-1])%></td>
<%
        if (i == checkedOtherQualifiedAlien.length){
%>
  </tr>
<%
        }
      } else {
%>
    <td><%=Lookup.simpleDecodeSafe(CodesTables.COTHRQUA, checkedOtherQualifiedAlien[i-1])%></td>
  </tr>
<%
      }
%>    
      <impact:validateInput type="hidden" 
                      name="<%=  methodOtherQualifiedAlienVerificationList.get(checkedOtherQualifiedAlien[i-1]) %>" 
                      value="true"/>
<%       
    }
  }
%>                 
  <tr>
    <th colspan="2">Undetermined Status</th>
  </tr>
 <%
  if (checkedUndetermined == null || checkedUndetermined.length == 0){
%>
 <tr>
   <td colspan="2">N/A</td>
 </tr>
<%
  } else {
    for (int i = 1; i <= checkedUndetermined.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){
%>
  <tr>
    <td width="50%"><%=Lookup.simpleDecodeSafe(CodesTables.CUDETALN, checkedUndetermined[i-1])%></td>
<%
        if (i == checkedUndetermined.length){
%>
  </tr>
<%
        }
      } else {
%>
    <td><%=Lookup.simpleDecodeSafe(CodesTables.CUDETALN, checkedUndetermined[i-1])%></td>
  </tr>
<%
      }
%>    
      <impact:validateInput type="hidden" 
                      name="<%=  methodUndeterminedOtherVerificationList.get(checkedUndetermined[i-1]) %>" 
                      value="true"/>
<%       
    }
  }
%>
  <tr>
   <th colspan="2">Verified by Eligibility Specialist</th>
 </tr>
 <tr>
    <td colspan="2">If any of the selections below are checked, Please ensure results are documented in Records Checked</td>
 </tr>
 <tr>
    <td width="50%">
               <impact:validateInput
               label="SUCCESS System"
               name="indCtznshpSuccessSystem"
               tabIndex="<%= (_tabIndex + NUMBER_OF_CITIZENSHIP_ROWS ) %>"
               value="true"
               checked="<%= _fceEligibilityDB.getIndCtznshpSuccessSystemString() %>"
               type="checkbox"
               disabled="false"
               cssClass="formInput" />
               
           </td>
            <td>
               <impact:validateInput
               label="SAVE System"
               name="indCtznshpSaveSystem"
               tabIndex="<%= (_tabIndex + NUMBER_OF_CITIZENSHIP_ROWS + 1) %>"
               value="true"
               checked="<%= _fceEligibilityDB.getIndCtznshpSaveSystemString() %>"
               type="checkbox"
               cssClass="formInput" />
           </td>
    </tr>

  </table>
<%
 _tabIndex += (NUMBER_OF_CITIZENSHIP_ROWS + 2);
 request.setAttribute("tabIndex", _tabIndex);
 request.setAttribute("evalConclusionCheckedCitizenship", _evalConclusionChecked);
}
%>
