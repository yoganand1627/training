package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonCitizenshipIdentityConversation;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public final class PersonCitizenshipIdentity_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*-----------------------------------------------------------------------------
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"Javascript1.2\">\r\n// Check for changes before navigating off\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n</script>\r\n\r\n");


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

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPersonCitizenshipIdentity");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction(action);
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.CitizenshipIdentityCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />  \r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n      <th colspan=\"6\">Birth Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("US Birth State");
          _jspx_th_impact_validateSelect_0.setBlankValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_0.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_0.setName("selSzCdPersonBirthState");
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setDisabled("");
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(szCdPersonBirthState));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Birth County");
          _jspx_th_impact_validateSelect_1.setBlankValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setName("selSzCdPersonBirthCounty");
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setDisabled("");
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(birthCounty));
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>                   \r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("Birth City");
          _jspx_th_impact_validateInput_0.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setName("txtSzCdPersonBirthCity");
          _jspx_th_impact_validateInput_0.setSize("20");
          _jspx_th_impact_validateInput_0.setMaxLength("20");
          _jspx_th_impact_validateInput_0.setOnChange("");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatString(birthCity));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("Out of State County");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_1.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_1.setName("txtSzCdOutOfStateCounty");
          _jspx_th_impact_validateInput_1.setSize("20");
          _jspx_th_impact_validateInput_1.setMaxLength("20");
          _jspx_th_impact_validateInput_1.setOnChange("");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatString(outOfStateCounty));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>                  \r\n  </tr>   \r\n    <tr>    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Citizenship/Alien Status");
          _jspx_th_impact_validateSelect_2.setBlankValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_2.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_2.setCodesTable("CCTZNSTA");
          _jspx_th_impact_validateSelect_2.setExcludeOptions( excludeOptions );
          _jspx_th_impact_validateSelect_2.setRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_2.setName("selSzCdCitizenshipStatus");
          _jspx_th_impact_validateSelect_2.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setDisabled("");
          _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(szCdCitizenshipStatus));
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("        \r\n     </td>                   \r\n     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Birth Country");
          _jspx_th_impact_validateSelect_3.setBlankValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_3.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_3.setOrderBy("decode");
          _jspx_th_impact_validateSelect_3.setCodesTable("CCNTRY");
          _jspx_th_impact_validateSelect_3.setRequired( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateSelect_3.setName("selSzCdCntryOfOrigin");
          _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setDisabled("");
          _jspx_th_impact_validateSelect_3.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(szCdCntryOfOrigin));
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        &nbsp;&nbsp;                      \r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setChecked(FormattingHelper.formatString(indNonUSBorn));
          _jspx_th_impact_validateInput_2.setDisabled("");
          _jspx_th_impact_validateInput_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setName("cbxBIndUSCitizen");
          _jspx_th_impact_validateInput_2.setLabel("Non-US Born");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>                   \r\n  </tr>  \r\n    <tr>\r\n     <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtEntryUS");
          _jspx_th_impact_validateDate_0.setLabel("Entry Date into the US");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setOnBlur("");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setValue( dtEntryUS );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setOnChange("");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Mother Married at Child's Birth");
          _jspx_th_impact_validateSelect_4.setBlankValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_4.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_4.setCodesTable("CMOTHMAR");
          _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_4.setName("selSzCdMotherMarried");
          _jspx_th_impact_validateSelect_4.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setDisabled("");
          _jspx_th_impact_validateSelect_4.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(szCdMotherMarried));
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n    </tr>\r\n    <tr>\r\n    <td>DOB:</td>\r\n     <td>");
          out.print(dtBirth);
          out.write("</td>\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("dtBirth");
          _jspx_th_impact_validateInput_3.setValue(dtBirth);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     <td>Age:</td>\r\n    <td>");
          out.print(FormattingHelper.formatInt(age));
          out.write("</td>    \r\n    </tr>\r\n  </table> \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n        <th colspan=\"6\">Method of Age Verification</th>\r\n    </tr>\r\n    <tr>\r\n            <td>\r\n              ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_0.setCastorEnum( Collections.enumeration(methodOfCitizenshipVerificationList) );
          _jspx_th_impact_castorCheckbox_0.setName("chkMethodOfCitizenshipVerification");
          _jspx_th_impact_castorCheckbox_0.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_0.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_0.setCheckedValues( checkedMethodOfCitizenshipVerificationList );
          _jspx_th_impact_castorCheckbox_0.setColumns(2);
          _jspx_th_impact_castorCheckbox_0.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_0.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_0 = _jspx_th_impact_castorCheckbox_0.doStartTag();
          if (_jspx_th_impact_castorCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n    </tr>\r\n  </table>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"6\">Method of Citizenship Verification</th>\r\n    </tr>\r\n    <tr>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n        <tr>\r\n         <th colspan=\"6\">US Citizen</th>\r\n        </tr>\r\n        <tr>\r\n            <td>\r\n              ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_1.setCastorEnum( Collections.enumeration(usCitizenList) );
          _jspx_th_impact_castorCheckbox_1.setName("chkUSCitizen");
          _jspx_th_impact_castorCheckbox_1.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_1.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_1.setCheckedValues( checkedUSCitizenList );
          _jspx_th_impact_castorCheckbox_1.setColumns(2);
          _jspx_th_impact_castorCheckbox_1.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_1.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_1 = _jspx_th_impact_castorCheckbox_1.doStartTag();
          if (_jspx_th_impact_castorCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n         </tr>\r\n         <tr>\r\n           <th colspan=\"6\">Identity Verification (Adult)</th>\r\n         </tr>\r\n        <tr>\r\n            <td>\r\n              ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_2.setCastorEnum( Collections.enumeration(identityVerificationAdultList) );
          _jspx_th_impact_castorCheckbox_2.setName("chkIdentityVerificationAdult");
          _jspx_th_impact_castorCheckbox_2.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_2.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_2.setCheckedValues( checkedIdentityVerificationAdultList );
          _jspx_th_impact_castorCheckbox_2.setColumns(2);
          _jspx_th_impact_castorCheckbox_2.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_2.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_2 = _jspx_th_impact_castorCheckbox_2.doStartTag();
          if (_jspx_th_impact_castorCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n           <th colspan=\"6\">Identity Verification (Under 16 Only)</th>\r\n         </tr>\r\n        <tr>\r\n            <td>\r\n              ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_3.setCastorEnum( Collections.enumeration(identityVerificationUnder16OnlyList) );
          _jspx_th_impact_castorCheckbox_3.setName("chkIdentityVerificationUnder16Only");
          _jspx_th_impact_castorCheckbox_3.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_3.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_3.setCheckedValues( checkedIdentityVerificationUnder16OnlyList );
          _jspx_th_impact_castorCheckbox_3.setColumns(2);
          _jspx_th_impact_castorCheckbox_3.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_3.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_3 = _jspx_th_impact_castorCheckbox_3.doStartTag();
          if (_jspx_th_impact_castorCheckbox_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>        \r\n        <tr>\r\n           <th colspan=\"6\">Permanent Resident/Refugee</th>\r\n         </tr>\r\n        <tr>\r\n            <td>\r\n             ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_4.setCastorEnum( Collections.enumeration(permanentResRefugeeList) );
          _jspx_th_impact_castorCheckbox_4.setName("chkPermResRefugee");
          _jspx_th_impact_castorCheckbox_4.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_4.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_4.setCheckedValues( checkedPermanentResRefugeeList );
          _jspx_th_impact_castorCheckbox_4.setColumns(2);
          _jspx_th_impact_castorCheckbox_4.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_4.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_4 = _jspx_th_impact_castorCheckbox_4.doStartTag();
          if (_jspx_th_impact_castorCheckbox_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>   \r\n        <tr>\r\n           <th colspan=\"6\">Other Qualified Alien</th>\r\n         </tr>\r\n        <tr>\r\n            <td>\r\n              ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_5.setCastorEnum( Collections.enumeration(otherQualifiedAlienList) );
          _jspx_th_impact_castorCheckbox_5.setName("chkOtherQualifiedAlien");
          _jspx_th_impact_castorCheckbox_5.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_5.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_5.setCheckedValues( checkedOtherQualifiedAlienList );
          _jspx_th_impact_castorCheckbox_5.setColumns(2);
          _jspx_th_impact_castorCheckbox_5.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_5.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_5 = _jspx_th_impact_castorCheckbox_5.doStartTag();
          if (_jspx_th_impact_castorCheckbox_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>            \r\n        <tr>\r\n           <th colspan=\"6\">Undetermined/Other Status</th>\r\n         </tr>\r\n        <tr>\r\n            <td>\r\n              ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_6.setCastorEnum( Collections.enumeration(undeterminedList) );
          _jspx_th_impact_castorCheckbox_6.setName("chkUndetermined");
          _jspx_th_impact_castorCheckbox_6.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_6.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_6.setCheckedValues( checkedUndeterminedList );
          _jspx_th_impact_castorCheckbox_6.setColumns(2);
          _jspx_th_impact_castorCheckbox_6.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_6.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_6 = _jspx_th_impact_castorCheckbox_6.doStartTag();
          if (_jspx_th_impact_castorCheckbox_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>                                              \r\n      </table>\r\n    </tr>    \r\n  </table>\r\n  ");
 if(PageModeConstants.EDIT.equals(pageMode)){ 
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave1");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmPersonCitizenshipIdentity");
          _jspx_th_impact_ButtonTag_0.setFunction("setIsDirtyCalled(false);");
          _jspx_th_impact_ButtonTag_0.setAction(action);
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(false);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(false);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n ");
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
