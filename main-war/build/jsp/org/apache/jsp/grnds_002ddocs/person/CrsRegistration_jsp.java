package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.text.SimpleDateFormat;
import org.exolab.castor.types.Date;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsScreeningSO;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;

public final class CrsRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/person/RaceEthnicitySub.jsp");
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

      out.write('\r');
      out.write('\n');

       /** JSP Name:     CrsRegistration.jsp
       *  Created by:   Kapil Aggarwal
       *  Date Created: 02/26/07
       *
       *  Description:
       *  This page allows the user to register the client in SHINES with the CRS
       *  system and obtain back a CRS ID that serves as a reference to all the 
       *  other external system.
       **/

      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

      //  Declare variables
      int tabIndex = 1;
      String radioId = "";
      String lastNm = StringHelper.EMPTY_STRING;
      String firstNm = StringHelper.EMPTY_STRING;
      String middleNm = StringHelper.EMPTY_STRING;
      String suffix = StringHelper.EMPTY_STRING;
      String gender = StringHelper.EMPTY_STRING;
      String cdDOBVer = StringHelper.EMPTY_STRING;
      String cdSSNVer = StringHelper.EMPTY_STRING;
      String ssn = StringHelper.EMPTY_STRING;
      Date dob = null;
      String county = StringHelper.EMPTY_STRING;
      String afAmer = StringHelper.EMPTY_STRING;
      String ntvAmer = StringHelper.EMPTY_STRING;
      String white = StringHelper.EMPTY_STRING;
      String pcCislander = StringHelper.EMPTY_STRING;
      String asian = StringHelper.EMPTY_STRING;
      int idPerson = 0;
      
      String screened = StringHelper.EMPTY_STRING;
      boolean blnScreened = false;
      List<CrsScreeningSO.ReturnItem> results = null;
      String hdnWebServiceError = StringHelper.EMPTY_STRING;
      boolean showWsError = false;


      // To perform screening valid input fields must be present
      boolean recordsFound = false;

      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      String pageMode = PageModeConstants.VIEW;
      CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);

      // Has Screening been performed once
      screened = (String)state.getAttribute("hdnScreened", request);
      blnScreened = (screened!=null) && Boolean.valueOf(screened).booleanValue();
	  hdnWebServiceError = (String)state.getAttribute("hdnWebServiceError", request);
	  showWsError = hdnWebServiceError != null;
      results = (List<CrsScreeningSO.ReturnItem>) state.getAttribute("crsScreeningResults", request);
      recordsFound = (null != results);
      county = Lookup.simpleDecodeSafe("CCOUNT", (String) request.getAttribute("cboSzCdAddrCounty"));
      
      // Use notNew to determine if we can assume that cint14wlb will be non-null
      int ulIdPersonId = ContextHelper.getIntSafe(request, "hdnUlIdPersonId");
      CINT14WLB cint14wlb = (CINT14WLB) state.getAttribute("cint14wlb", request);
      boolean notNew = ulIdPersonId > 0 && cint14wlb != null;
      org.exolab.castor.types.Date endDate = notNew ? cint14wlb.getDtPersonIDEnd() : null;
      // Use hasEndDate to disable editing when there is an end date saved
      boolean hasEndDate = endDate != null ? true : false;
      
      
      
      
      if (cinv04so != null) {
        lastNm = FormattingHelper.formatString(cinv04so.getSzNmNameLast());
        firstNm = FormattingHelper.formatString(cinv04so.getSzNmNameFirst());
        middleNm = cinv04so.getSzNmNameMiddle();
        suffix = cinv04so.getSzCdNameSuffix();
        dob = cinv04so.getDtDtPersonBirth();
        gender = cinv04so.getCCdPersonSex();
        cdDOBVer = (String) request.getAttribute("txtDOBVer");
        cdSSNVer = (String) request.getAttribute("txtSSNVer");
        ssn = (String) request.getAttribute("txtSzSysTxtGenericSSN");
        idPerson = cinv04so.getUlIdPerson();
      }


      out.write("\r\n\r\n  \r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCrsRegistration");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonIdentifiers/performCrsRegistration");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.CrsCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  \r\n\r\n  <!--- Begin Detail Table --->\r\n  ");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" style=\"\">\r\n    <tr>\r\n      <th colspan=\"7\">\r\n        Person Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setName("txtSzNmNameLast");
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setLabel("Last");
          _jspx_th_impact_validateInput_0.setConstraint("Name20");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setRequired("true");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatString(lastNm));
          _jspx_th_impact_validateInput_0.setSize("20");
          _jspx_th_impact_validateInput_0.setMaxLength("20");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setName("txtSzNmNameFirst");
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setRequired("true");
          _jspx_th_impact_validateInput_1.setLabel("First");
          _jspx_th_impact_validateInput_1.setConstraint("Name12");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatString(firstNm));
          _jspx_th_impact_validateInput_1.setSize("15");
          _jspx_th_impact_validateInput_1.setMaxLength("15");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setName("txtSzNmNameMiddle");
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setLabel("Middle");
          _jspx_th_impact_validateInput_2.setConstraint("Name12");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString(middleNm));
          _jspx_th_impact_validateInput_2.setSize("12");
          _jspx_th_impact_validateInput_2.setMaxLength("12");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("cboCcdPersonSuffix");
          _jspx_th_impact_validateSelect_0.setLabel("Suffix");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSUFFIX");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(suffix));
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("cboCcdPersonSex");
          _jspx_th_impact_validateSelect_1.setLabel("Gender");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setCodesTable("CSEX");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(gender));
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("cboSzCdAddrCounty");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setLabel("County");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(county));
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setName("txtSzSysTxtGenericSSN");
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_3.setLabel("SSN");
          _jspx_th_impact_validateInput_3.setConstraint("SocialSecurityNumber");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatString(ssn));
          _jspx_th_impact_validateInput_3.setSize("11");
          _jspx_th_impact_validateInput_3.setMaxLength("11");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("txtSSNVer");
          _jspx_th_impact_validateSelect_3.setLabel("Verification Code");
          _jspx_th_impact_validateSelect_3.setCodesTable("CSEX");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(cdSSNVer));
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n    </tr>\r\n    <tr>\r\n     <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtPersonBirth");
          _jspx_th_impact_validateDate_0.setLabel("Date of Birth");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(dob));
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("txtDOBVer");
          _jspx_th_impact_validateSelect_4.setLabel("Verification Code");
          _jspx_th_impact_validateSelect_4.setCodesTable("CSEX");
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(cdDOBVer));
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n   </tr>\r\n  </table>\r\n  ");

        RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
        raceEthnicitySubDB.setTabIndex(tabIndex);
        raceEthnicitySubDB.setIsExpanded(true);
        RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);
  
          out.write("\r\n  ");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    boolean isExpanded = false;
    RaceEthnicitySubDB raceEthnicitySubRaceEthnicitySubDB = RaceEthnicitySubDB.getFromRequest( request );
    int raceEthnicitySubDBTabIndex = raceEthnicitySubRaceEthnicitySubDB.getTabIndex();
    isExpanded = raceEthnicitySubRaceEthnicitySubDB.getIsExpanded();

    RaceEthnicityBean reBean = null;
    if ( RaceEthnicityHelper.isInRequest( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else if ( RaceEthnicityHelper.isInState( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else
    {
      reBean = new RaceEthnicityBean();
    }

    RaceEthnicityBean.Races races = reBean.getRaces();
    List raceValues = null;
    if ( races != null )
    {
      raceValues = races.getStringVector();
    }
    else
    {
      raceValues = new ArrayList();
    }
    String personEthnicity = reBean.getEthnicity();

    Collection ethnicities = Lookup.getCategoryCollection( CodesTables.CINDETHN );

          out.write("\r\n\r\n<script language=\"javascript\">\r\n// make sure at least one race checkbox is checked\r\nfunction isRaceChecked()\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n  var cbxGroupName = \"");
          out.print(RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\";\r\n  var bRace = areAnyChecked( cbxGroupName, raceLen );\r\n  return bRace;\r\n}\r\n\r\n// make sure that a radiobutton from the ethnicity radio button group is checked\r\nfunction isEthnicityChecked()\r\n{\r\n  var ethLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CINDETHN ).size() );
          out.write(";\r\n  var bEth = false;\r\n  var ethnicityRb = document.getElementsByName(\"");
          out.print( RaceEthnicityHelper.ETHNICITY_RB_NAME );
          out.write("\");\r\n  for ( i = 0; i < ethLen ; i++ )\r\n  {\r\n    bEth = ethnicityRb[i].checked;\r\n    if ( bEth )\r\n    {\r\n      break;\r\n    }\r\n  }\r\n  return bEth;\r\n}\r\n\r\n// make sure at least one race checkbox is checked or\r\n// a radiobutton from the ethnicity radio button group is checked\r\nfunction isRaceOrEthnicityChecked()\r\n{\r\n  var bRaceOrEth = false;\r\n  bRaceOrEth = ( isEthnicityChecked() || isRaceChecked() );\r\n  return bRaceOrEth;\r\n}\r\n// make sure that the race checkboxes are cleared if the undecided checkbox is checked\r\nfunction clearRaces( paramCbx )\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n\r\n  if ( paramCbx.checked == true )\r\n  {\r\n    // if you checked the Unable to Determine checkbox, make sure that all the others\r\n    // are unchecked\r\n    if ( paramCbx.value == \"");
          out.print( CodesTables.CRACE_UD  );
          out.write("\" )\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value != \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          currentCbx.checked = false;\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n    // else, if you checked any others, make sure Unable to Determine is unchecked\r\n    else\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value == \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.checked = false;\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n  }\r\n}\r\n</script>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("RaceEthnicity");
          _jspx_th_impact_ExpandableSectionTag_0.setId( RaceEthnicityHelper.RACE_CB_NAME + "1_Id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Race/Ethnicity Detail");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( raceEthnicitySubDBTabIndex );
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded(Boolean.valueOf(isExpanded).booleanValue());
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n   <span class=\"formInstruct\">Race/Ethnicity should never be determined by DFCS staff. Whenever possible, this information must come from the person, if a child, from a parent.</span>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n   <th>Race</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes(raceValues);
              _jspx_th_impact_codesCheckbox_0.setName( RaceEthnicityHelper.RACE_CB_NAME );
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_0.setOnClick("clearRaces(this)");
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setTabIndex( raceEthnicitySubDBTabIndex );
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <th>Ethnicity</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      <table width=\"100%\">\r\n        <tr>\r\n");

    for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
    {
      Mapping ethnicity = (Mapping) ethIterator.next();

              out.write("\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setValue( ethnicity.getKey() );
              _jspx_th_impact_validateInput_4.setTabIndex( raceEthnicitySubDBTabIndex );
              _jspx_th_impact_validateInput_4.setName( RaceEthnicityHelper.ETHNICITY_RB_NAME );
              _jspx_th_impact_validateInput_4.setType("radio");
              _jspx_th_impact_validateInput_4.setChecked( String.valueOf( ethnicity.getKey().equals( personEthnicity ) ) );
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              out.print( ethnicity.getValue() );
              out.write("\r\n          </td>\r\n");

    }

              out.write("\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setType("hidden");
              _jspx_th_impact_validateInput_5.setName( RaceEthnicityHelper.OLD_ETHNICITY_NAME );
              _jspx_th_impact_validateInput_5.setValue( personEthnicity );
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    raceEthnicitySubRaceEthnicitySubDB.setTabIndex( raceEthnicitySubDBTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write("\r\n  ");

        tabIndex = raceEthnicitySubDB.getTabIndex();
        RaceEthnicitySubDB.removeFromRequest(request);
  
          out.write("\r\n\r\n ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("NameSSNResults");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Name/SSN Results");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_1.setIsExpanded(Boolean.valueOf(recordsFound));
          _jspx_th_impact_ExpandableSectionTag_1.setId("btnInquire_Id");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');
              out.write('	');
              //  impact:pagination
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
              _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_pagination_0.setSaveState("false");
              _jspx_th_impact_pagination_0.setSubmitUrl("/person/PersonIdentifiers/performCrsScreening");
              int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
              if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n  <div id=\"scrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableborderList\">\r\n   <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n       \t<tr>\r\n           \t <th class=\"thList\">&nbsp;</th>\r\n             <th class=\"thList\">Client ID&nbsp;</th>\r\n             <th class=\"thList\">Name&nbsp;</th>\r\n             <th class=\"thList\">DOB&nbsp;</th>\r\n             <th class=\"thList\">Gender&nbsp;</th>\r\n             <th class=\"thList\">Race&nbsp;</th>\r\n             <th class=\"thList\">Ethnicity&nbsp;</th>\r\n             <th class=\"thList\">SSN&nbsp;</th>\r\n           </tr> \r\n  ");

   if (results != null) {
   
                  out.write("             \r\n   ");

                        int loopCount = 0;
                        CrsScreeningSO.ReturnItem rowCrsscreeningSO = null;
                        Iterator<CrsScreeningSO.ReturnItem> iterator = results.iterator();

                        if (results.size() == 0) {
                
                  out.write("\r\n        \r\n              <tr class=\"odd\">\r\n                <td colspan=\"10\">\r\n                  ");
                  out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
                  out.write("\r\n                </td>\r\n              </tr>\r\n              ");

                        } else {
                        while (iterator.hasNext()) {
                          rowCrsscreeningSO = (CrsScreeningSO.ReturnItem) iterator.next();
              
                  out.write("\r\n\t\t\t<tr class=\"");
                  out.print(FormattingHelper.getRowCss(loopCount + 1));
                  out.write("\" valign=\"top\">\r\n\t\t\t\t");

				            radioId = "rbCrsRegistration_CLEAN" + loopCount;
				            boolean checked = false;
				
                  out.write("\r\n\t\t\t\t");

				String onClick = "javascript:onClickRB( '" + loopCount + "' )";
				
                  out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateInput_6.setType("radio");
                  _jspx_th_impact_validateInput_6.setId(radioId);
                  _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateInput_6.setName("rbCrsRegistration_CLEAN");
                  _jspx_th_impact_validateInput_6.setValue(String.valueOf(loopCount));
                  _jspx_th_impact_validateInput_6.setChecked(String.valueOf(checked));
                  _jspx_th_impact_validateInput_6.setEditableMode(EditableMode.ALL);
                  _jspx_th_impact_validateInput_6.setOnClick(onClick);
                  int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
                  if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t\r\n\t\t\t\t\t\t\t\t<td> ");
                  out.write("\r\n\t\t\t\t\t");
                  out.print(rowCrsscreeningSO.getLnIrnClientId());
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");

				            String firstName = StringHelper.getSafeString(rowCrsscreeningSO.getSzFName());
				            String middleName = StringHelper.getSafeString(rowCrsscreeningSO.getSzMName());
				            String lastName = StringHelper.getSafeString(rowCrsscreeningSO.getSzLName());
				            String fullName = FormattingHelper.formatFullName(firstName, middleName, lastName);
				
                  out.write("\t\t\t\t\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  out.print(fullName);
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t\t");

						SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
						java.util.Date DOB = null;
						try {
							DOB = format.parse(rowCrsscreeningSO.getUlDob() + StringHelper.EMPTY_STRING);
						}
						catch(Exception e) {
							//date values from the gta webservice may have zeros in them so just show nothing if it fails to parse
						}
					
                  out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  out.print(FormattingHelper.formatDate(DOB));
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  out.print(rowCrsscreeningSO.getSzSexCode());
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");

		  		String races= "";
				     if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnAfAmerican())) {
                        afAmer = RaceEthnicityHelper.RACE_BLACK;
                     }
                    if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnNtvAmerican())) {
                          ntvAmer = RaceEthnicityHelper.RACE_AMERIND;
                    }
                    if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnWhite())) {
                          white = RaceEthnicityHelper.RACE_WHITE;
                    }
                   if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnPcfcislander())) {
                     pcCislander = RaceEthnicityHelper.RACE_HAWAIIAN;
                   }
                   if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnAsian())) {
                        asian = RaceEthnicityHelper.RACE_ASIAN;
                      }
				   races = (afAmer + " " + ntvAmer + " " + white + " " + pcCislander + " " + asian + " ");
				
                  out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  out.print(races);
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  out.print(rowCrsscreeningSO.getSzEthnCode());
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");

				            String ssnDisplay = StringHelper.EMPTY_STRING;
				            if (rowCrsscreeningSO.getUlSsn() != 0) {
				              ssnDisplay = FormattingHelper.formatSSN(FormattingHelper.formatLong(rowCrsscreeningSO.getUlSsn()));
				            }
				
                  out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  out.print(ssnDisplay);
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>   ");
                  out.write("         \r\n\r\n              ");

                                 loopCount++;
                                 } // end while
                               }
                             } else {
                       
                  out.write("\r\n       <tr><td>&nbsp;</td></tr>\r\n       ");

       }
       
                  out.write("\t \r\n        </table>\r\n      </div>\r\n      ");
                  int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n   ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   \r\n  \r\n  <Table align=\"right\">\r\n    <Tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnScreenCrs");
          _jspx_th_impact_ButtonTag_0.setImg("btnScreening");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmCrsRegistration");
          _jspx_th_impact_ButtonTag_0.setFunction("return onClickScreening();");
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setAction("/person/PersonIdentifiers/performCrsScreening");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSelectCrsId");
          _jspx_th_impact_ButtonTag_1.setImg("btnSelect");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setDisabled(String.valueOf(!recordsFound));
          _jspx_th_impact_ButtonTag_1.setForm("frmCrsRegistration");
          _jspx_th_impact_ButtonTag_1.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_1.setFunction("return onClickSelect(); disableValidation('frmCrsRegistration');");
          _jspx_th_impact_ButtonTag_1.setAction("/person/PersonIdentifiers/selectCrsId");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnCrsRegister");
          _jspx_th_impact_ButtonTag_2.setImg("btnAddToCRS");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_2.setDisabled(String.valueOf(!blnScreened));
          _jspx_th_impact_ButtonTag_2.setForm("frmCrsRegistration");
          _jspx_th_impact_ButtonTag_2.setFunction("return confirmAddToCRS(false);");
          _jspx_th_impact_ButtonTag_2.setAction("/person/PersonIdentifiers/performCrsRegistration");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </Tr>\r\n  </Table>\r\n\r\n  ");
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnWebServiceError\" value=\"\">\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnScreened");
          _jspx_th_impact_validateInput_7.setValue(screened);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <input type=\"hidden\" name=\"hdnLoopCount\" >\r\n  <input type=\"hidden\" name=\"hdnInqPressed\" >\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnIncludingPageDisplayCommand");
          _jspx_th_impact_validateInput_8.setValue((String) request.getAttribute("includingPageDisplayCommand"));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnUlIdPerson");
          _jspx_th_impact_validateInput_10.setValue(FormattingHelper.formatInt(idPerson));
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  window.onload = function ()\r\n  {\r\n    if(");
      out.print(showWsError);
      out.write(" == true){\r\n   \t\talert('");
      out.print(hdnWebServiceError);
      out.write("');\r\n  \t}\r\n  };\r\n\r\n function onClickRB( loopCount )\r\n  {\r\n  \tdocument.frmCrsRegistration.hdnLoopCount.value = loopCount;\r\n  }\r\n  \r\n  function onClickScreening()\r\n  {\r\n  \tdocument.frmCrsRegistration.hdnLoopCount.value = -1;\r\n  \tdocument.frmCrsRegistration.hdnInqPressed.value = true;\r\n  \treturn true;\r\n  }\r\n  \r\n  function onClickSelect() {\r\n    if(document.frmCrsRegistration.hdnLoopCount.value < 0 || document.frmCrsRegistration.hdnLoopCount.value==\"\"){\r\n    \talert(\"Please select a row from the \\\"Name/SSN Results\\\" before clicking the \\\"Select\\\" button\");\r\n    \treturn false;\r\n    }\r\n    else {\r\n   \t   return true;\r\n    }\r\n  }\r\n  \r\n function confirmAddToCRS(bHasEnddate)\r\n  {\r\n    var returnedValue = true;\r\n    var type = '");
      out.print(CodesTables.CNUMTYPE_CRS_IDNUMBER);
      out.write("';\r\n\r\n\t");
      out.write("\r\n    var existingTypes = new Array( ");
      out.print((String) request.getAttribute("existingTypes"));
      out.write(" );\r\n    for( var i = 0; i < existingTypes.length; i++ )\r\n    {\r\n      if( existingTypes[ i ] == type && !bHasEnddate)\r\n      {\r\n        ");
      out.write("\r\n        returnedValue = confirm('There is already an active identifier of type CRS ID#. Clicking OK will end date the old identifier.')\r\n        if(returnedValue==true){\r\n        \tif( type == '");
      out.print(CodesTables.CNUMTYPE_CRS_IDNUMBER);
      out.write("'){\r\n        \t\treturnedValue = confirm('This will create a duplicate or another CRS ID in the CRS System for the same person!  Are you sure ?');\r\n        \t}\r\n        }\r\n      }\r\n      if(existingTypes[ i ] == type) {\r\n      \tbreak;\r\n      }\r\n    }\r\n    \r\n    return returnedValue;\r\n  }\r\n  \r\n</script>");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmCrsRegistration");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnUlIdPersonId");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_11.setType("hidden");
    _jspx_th_impact_validateInput_11.setName("hdnIsNew");
    _jspx_th_impact_validateInput_11.setValue("true");
    int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
    if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
