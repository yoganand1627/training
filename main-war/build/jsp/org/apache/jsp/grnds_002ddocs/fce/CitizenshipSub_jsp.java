package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;

public final class CitizenshipSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" bgcolor=\"");
      out.print( _bgColor );
      out.write("\">\r\n     <tr>\r\n          <th colspan=\"2\"> US Citizen </th>\r\n         </tr>\r\n ");

  if (checkedUSCitizen == null || checkedUSCitizen.length == 0){

      out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedUSCitizen.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

      out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CCERTVER, checkedUSCitizen[i-1]));
      out.write("</td>\r\n");

        if (i == checkedUSCitizen.length){

      out.write("\r\n  </tr>\r\n");

        }
      } else {

      out.write("\r\n    <td>");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CCERTVER, checkedUSCitizen[i-1]));
      out.write("</td>\r\n  </tr>\r\n");

      }

      out.write("    \r\n      ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setType("hidden");
      _jspx_th_impact_validateInput_0.setName(  methodUSCitizenVerificationList.get(checkedUSCitizen[i-1]) );
      _jspx_th_impact_validateInput_0.setValue("true");
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
  
      if ("ECN".equals(checkedUSCitizen[i-1])){
        _evalConclusionChecked = true;
      }   
    }
  }

      out.write("       \r\n <tr>\r\n   <th colspan=\"2\"> Identity Verification (Adult) </th>\r\n </tr>\r\n ");

  if (checkedIdentityVerificationAdult == null || checkedIdentityVerificationAdult.length == 0){

      out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedIdentityVerificationAdult.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

      out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CIDENTAD, checkedIdentityVerificationAdult[i-1]));
      out.write("</td>\r\n");

        if (i == checkedIdentityVerificationAdult.length){

      out.write("\r\n  </tr>\r\n");

        }
      } else {

      out.write("\r\n    <td>");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CIDENTAD, checkedIdentityVerificationAdult[i-1]));
      out.write("</td>\r\n  </tr>\r\n");

      }

      out.write("    \r\n      ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_1.setParent(null);
      _jspx_th_impact_validateInput_1.setType("hidden");
      _jspx_th_impact_validateInput_1.setName(  methodIdentityAdultVerificationList.get(checkedIdentityVerificationAdult[i-1]) );
      _jspx_th_impact_validateInput_1.setValue("true");
      int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
      if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
       
    }
  }

      out.write(" \r\n <tr>\r\n   <th colspan=\"2\"> Identity Verification (Under 16 Only) </th>\r\n </tr>\r\n");

  if (checkedIdentityVerificationUnder16Only == null || checkedIdentityVerificationUnder16Only.length == 0){

      out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedIdentityVerificationUnder16Only.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

      out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CIDENTUN, checkedIdentityVerificationUnder16Only[i-1]));
      out.write("</td>\r\n");

        if (i == checkedIdentityVerificationUnder16Only.length){

      out.write("\r\n  </tr>\r\n");

        }
      } else {

      out.write("\r\n    <td>");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CIDENTUN, checkedIdentityVerificationUnder16Only[i-1]));
      out.write("</td>\r\n  </tr>\r\n");

      }

      out.write("    \r\n      ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_2.setParent(null);
      _jspx_th_impact_validateInput_2.setType("hidden");
      _jspx_th_impact_validateInput_2.setName(  methodIdentityUnder16VerificationList.get(checkedIdentityVerificationUnder16Only[i-1]) );
      _jspx_th_impact_validateInput_2.setValue("true");
      int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
      if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
                           
    }
  }

      out.write("   \r\n  <tr>\r\n    <th colspan=\"2\">Permanent Resident</th>\r\n  </tr>\r\n ");

  if (checkedPermanentResRefugee == null || checkedPermanentResRefugee.length == 0){

      out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedPermanentResRefugee.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

      out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CPERMRES, checkedPermanentResRefugee[i-1]));
      out.write("</td>\r\n");

        if (i == checkedPermanentResRefugee.length){

      out.write("\r\n  </tr>\r\n");

        }
      } else {

      out.write("\r\n    <td>");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CPERMRES, checkedPermanentResRefugee[i-1]));
      out.write("</td>\r\n  </tr>\r\n");

      }

      out.write("    \r\n      ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_3.setParent(null);
      _jspx_th_impact_validateInput_3.setType("hidden");
      _jspx_th_impact_validateInput_3.setName(  methodPermResidentRefugeeVerificationList.get(checkedPermanentResRefugee[i-1]) );
      _jspx_th_impact_validateInput_3.setValue("true");
      int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
      if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
         
    }
  }

      out.write(" \r\n  <tr>\r\n    <th colspan=\"2\">Other Qualified Alien</th>\r\n  </tr>\r\n ");

  if (checkedOtherQualifiedAlien == null || checkedOtherQualifiedAlien.length == 0){

      out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedOtherQualifiedAlien.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

      out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
      out.print(Lookup.simpleDecodeSafe(CodesTables.COTHRQUA, checkedOtherQualifiedAlien[i-1]));
      out.write("</td>\r\n");

        if (i == checkedOtherQualifiedAlien.length){

      out.write("\r\n  </tr>\r\n");

        }
      } else {

      out.write("\r\n    <td>");
      out.print(Lookup.simpleDecodeSafe(CodesTables.COTHRQUA, checkedOtherQualifiedAlien[i-1]));
      out.write("</td>\r\n  </tr>\r\n");

      }

      out.write("    \r\n      ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_4.setParent(null);
      _jspx_th_impact_validateInput_4.setType("hidden");
      _jspx_th_impact_validateInput_4.setName(  methodOtherQualifiedAlienVerificationList.get(checkedOtherQualifiedAlien[i-1]) );
      _jspx_th_impact_validateInput_4.setValue("true");
      int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
      if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
       
    }
  }

      out.write("                 \r\n  <tr>\r\n    <th colspan=\"2\">Undetermined Status</th>\r\n  </tr>\r\n ");

  if (checkedUndetermined == null || checkedUndetermined.length == 0){

      out.write("\r\n <tr>\r\n   <td colspan=\"2\">N/A</td>\r\n </tr>\r\n");

  } else {
    for (int i = 1; i <= checkedUndetermined.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){

      out.write("\r\n  <tr>\r\n    <td width=\"50%\">");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CUDETALN, checkedUndetermined[i-1]));
      out.write("</td>\r\n");

        if (i == checkedUndetermined.length){

      out.write("\r\n  </tr>\r\n");

        }
      } else {

      out.write("\r\n    <td>");
      out.print(Lookup.simpleDecodeSafe(CodesTables.CUDETALN, checkedUndetermined[i-1]));
      out.write("</td>\r\n  </tr>\r\n");

      }

      out.write("    \r\n      ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_5.setParent(null);
      _jspx_th_impact_validateInput_5.setType("hidden");
      _jspx_th_impact_validateInput_5.setName(  methodUndeterminedOtherVerificationList.get(checkedUndetermined[i-1]) );
      _jspx_th_impact_validateInput_5.setValue("true");
      int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
      if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
       
    }
  }

      out.write("\r\n  <tr>\r\n   <th colspan=\"2\">Verified by Eligibility Specialist</th>\r\n </tr>\r\n <tr>\r\n    <td colspan=\"2\">If any of the selections below are checked, Please ensure results are documented in Records Checked</td>\r\n </tr>\r\n <tr>\r\n    <td width=\"50%\">\r\n               ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_6.setParent(null);
      _jspx_th_impact_validateInput_6.setLabel("SUCCESS System");
      _jspx_th_impact_validateInput_6.setName("indCtznshpSuccessSystem");
      _jspx_th_impact_validateInput_6.setTabIndex( (_tabIndex + NUMBER_OF_CITIZENSHIP_ROWS ) );
      _jspx_th_impact_validateInput_6.setValue("true");
      _jspx_th_impact_validateInput_6.setChecked( _fceEligibilityDB.getIndCtznshpSuccessSystemString() );
      _jspx_th_impact_validateInput_6.setType("checkbox");
      _jspx_th_impact_validateInput_6.setDisabled("false");
      _jspx_th_impact_validateInput_6.setCssClass("formInput");
      int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
      if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n               \r\n           </td>\r\n            <td>\r\n               ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_7.setParent(null);
      _jspx_th_impact_validateInput_7.setLabel("SAVE System");
      _jspx_th_impact_validateInput_7.setName("indCtznshpSaveSystem");
      _jspx_th_impact_validateInput_7.setTabIndex( (_tabIndex + NUMBER_OF_CITIZENSHIP_ROWS + 1) );
      _jspx_th_impact_validateInput_7.setValue("true");
      _jspx_th_impact_validateInput_7.setChecked( _fceEligibilityDB.getIndCtznshpSaveSystemString() );
      _jspx_th_impact_validateInput_7.setType("checkbox");
      _jspx_th_impact_validateInput_7.setCssClass("formInput");
      int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
      if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n           </td>\r\n    </tr>\r\n\r\n  </table>\r\n");

 _tabIndex += (NUMBER_OF_CITIZENSHIP_ROWS + 2);
 request.setAttribute("tabIndex", _tabIndex);
 request.setAttribute("evalConclusionCheckedCitizenship", _evalConclusionChecked);
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
}
