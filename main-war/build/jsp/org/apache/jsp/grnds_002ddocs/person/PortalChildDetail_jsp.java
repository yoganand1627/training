package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PortalChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCharacteristicsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PortalContactBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PortalChildDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;

public final class PortalChildDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**  JSP Name:     Portal Child Detail
  *  Created by:   Patrick Coogan
  *  Date Created: 10/18/2009
  *
  *  Description:
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  10/18/09    pcoogan           Created new JSP to support SHINES Portal 
  */


      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  UserProfile user = UserProfileHelper.getUserProfile ( request );
  String pageMode = PageMode.getPageMode(request);

  // create the output object
  PortalChildRetrieveSO portalChildRetrieveSO = ( PortalChildRetrieveSO ) request.getAttribute( "portalChildRetrieveSO" );
  
  List<PersonCharacteristicsBean> childCharacteristics = null;
  List<PortalContactBean> contactList = null;

  if (portalChildRetrieveSO != null) {  
  	childCharacteristics = portalChildRetrieveSO.getChildCharacteristicsList();
  }
  
  if (portalChildRetrieveSO != null) {  
  	contactList = portalChildRetrieveSO.getContactsList();
  }
  
  if (portalChildRetrieveSO == null) {
    portalChildRetrieveSO = new PortalChildRetrieveSO();
  }
      
  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  String submitUrl="/person/PortalChildDetail/displayPortalChildDetail";
  

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"JavaScript\">\r\nfunction displayChildList()\r\n{\r\n  disableValidation('frmPortalChildDetail');\r\n  submitValidateForm( \"frmPortalChildDetail\", \"/workload/PortalChildList/displayChildList\" );\r\n}\r\n\r\nfunction cancelValidation()\r\n{\r\n  disableValidation('frmPortalChildDetail');\r\n}\r\nfunction displayContactDetail( idEvent )\r\n{\r\n  document.frmPortalChildDetail.hdnUlIdEvent.value = idEvent;\r\n  disableValidation('frmPortalChildDetail');\r\n  submitValidateForm( \"frmPortalChildDetail\", \"/contacts/PortalContactDetail/displayContact\" );\r\n}\r\n\r\n</script>\r\n\r\n\r\n  ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n  ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPortalChildDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PortalChildDetail/displayPortalChildDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

   TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean) request.getAttribute(
          PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

  if (tuxPagination != null) {
    DatabaseResultDetails db = tuxPagination.getResultDetails();
  } else {
    tuxPagination = new TuxedoPaginationValueBean();
    DatabaseResultDetails db = new DatabaseResultDetails();
    db.setNumberOfResults(0);
    db.setResultsPerPage(100); //SIR 19651 changed from 10 to 100
    db.setRequestedPage(1);
    tuxPagination.setResultDetails(db);
    request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
  }


          out.write("\r\n<table width=\"100%\"><tr><td>\r\n<a href=\"javascript:displayChildList()\">Back to Child List</a>\r\n</td></tr></table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"6\">Person Demographics</th>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("test");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Person ID");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdPerson()) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_1.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("First Name");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatString(portalChildRetrieveSO.getNmPersonFirst()) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_2.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Middle Name");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatString(portalChildRetrieveSO.getNmPersonMiddle()) );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_3.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Last Name");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( FormattingHelper.formatString(portalChildRetrieveSO.getNmPersonLast()) );
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_4.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Case ID");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdCase()) );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_5.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Gender");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CSEX", portalChildRetrieveSO.getCdGender() ) ) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_6.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("DOB");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue( FormattingHelper.formatDate(portalChildRetrieveSO.getDtChildBirth()) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_7.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Age");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue( FormattingHelper.formatLong(portalChildRetrieveSO.getUlChildAge()) );
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n\r\n</table>\r\n<br/>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"4\">Current Placement</th>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_8.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Resource Name");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue( FormattingHelper.formatString(portalChildRetrieveSO.getSzNmRsrcFacil()) );
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_9.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Resource ID");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue( FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdResource()) );
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_10.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Placement Start Date");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue( FormattingHelper.formatDate(portalChildRetrieveSO.getDtPlcmtStart()) );
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_11.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_11.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_11.setLabel("End Date");
          _jspx_th_impact_validateDisplayOnlyField_11.setValue( FormattingHelper.formatDate(portalChildRetrieveSO.getDtPlcmtEnd()) );
          int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_12.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_12.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Removal Reason");
          _jspx_th_impact_validateDisplayOnlyField_12.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRMRSNAC",portalChildRetrieveSO.getCdRemovalRsn())) );
          int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_13.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_13.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_13.setLabel("Placement Type");
          _jspx_th_impact_validateDisplayOnlyField_13.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CPLMNTYP",portalChildRetrieveSO.getCdPlcmtType())) );
          int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_14.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_14.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_14.setLabel("Sibling Placement");
          _jspx_th_impact_validateDisplayOnlyField_14.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CINVACAN",portalChildRetrieveSO.getCdSiblingPlcmt())) );
          int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_15.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_15.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_15.setLabel("Legal County");
          _jspx_th_impact_validateDisplayOnlyField_15.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCOUNT", portalChildRetrieveSO.getCdLegalCnty())) );
          int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest( (ArchitectureConstants.Y.equals(portalChildRetrieveSO.getCdIndCci())));
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_validateDisplayOnlyField_16.setName("displayOnlyInput");
              _jspx_th_impact_validateDisplayOnlyField_16.setColspan("1");
              _jspx_th_impact_validateDisplayOnlyField_16.setLabel("RBWO Program");
              _jspx_th_impact_validateDisplayOnlyField_16.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRBPROGI",portalChildRetrieveSO.getCdRbwoProg())) );
              int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest( (ArchitectureConstants.N.equals(portalChildRetrieveSO.getCdIndCci())));
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateDisplayOnlyField_17.setName("displayOnlyInput");
              _jspx_th_impact_validateDisplayOnlyField_17.setColspan("1");
              _jspx_th_impact_validateDisplayOnlyField_17.setLabel("RBWO Program");
              _jspx_th_impact_validateDisplayOnlyField_17.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRBPROGA",portalChildRetrieveSO.getCdRbwoProg())) );
              int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_2.setTest( ("".equals(portalChildRetrieveSO.getCdIndCci())));
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateDisplayOnlyField_18.setName("displayOnlyInput");
              _jspx_th_impact_validateDisplayOnlyField_18.setColspan("1");
              _jspx_th_impact_validateDisplayOnlyField_18.setLabel("RBWO Program");
              _jspx_th_impact_validateDisplayOnlyField_18.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRBPROGI",portalChildRetrieveSO.getCdRbwoProg())) );
              int _jspx_eval_impact_validateDisplayOnlyField_18 = _jspx_th_impact_validateDisplayOnlyField_18.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</td>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_19.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_19.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_19.setLabel("RBWO Per Diem");
          _jspx_th_impact_validateDisplayOnlyField_19.setValue( FormattingHelper.formatMoney(portalChildRetrieveSO.getDPerDiem()) );
          int _jspx_eval_impact_validateDisplayOnlyField_19 = _jspx_th_impact_validateDisplayOnlyField_19.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_20.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_20.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_20.setLabel("Waiver Rate");
          _jspx_th_impact_validateDisplayOnlyField_20.setValue( FormattingHelper.formatMoney(portalChildRetrieveSO.getDWaiverRate()) );
          int _jspx_eval_impact_validateDisplayOnlyField_20 = _jspx_th_impact_validateDisplayOnlyField_20.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n\r\n</table>\r\n<br/>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"4\">Case Manager/Supervisor Data</th>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_21.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_21.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_21.setLabel("Primary Case Manager Name");
          _jspx_th_impact_validateDisplayOnlyField_21.setValue( FormattingHelper.formatString(portalChildRetrieveSO.getNmCaseManager()) );
          int _jspx_eval_impact_validateDisplayOnlyField_21 = _jspx_th_impact_validateDisplayOnlyField_21.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_22.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_22.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_22.setLabel("Title");
          _jspx_th_impact_validateDisplayOnlyField_22.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CEMPJBCL",portalChildRetrieveSO.getCdCaseManagerJobTitle())) );
          int _jspx_eval_impact_validateDisplayOnlyField_22 = _jspx_th_impact_validateDisplayOnlyField_22.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_23.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_23.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_23.setLabel("Phone");
          _jspx_th_impact_validateDisplayOnlyField_23.setValue( FormattingHelper.formatPhone(portalChildRetrieveSO.getSzCaseManagerPhone()) );
          int _jspx_eval_impact_validateDisplayOnlyField_23 = _jspx_th_impact_validateDisplayOnlyField_23.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_24.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_24.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_24.setLabel("Office Location");
          _jspx_th_impact_validateDisplayOnlyField_24.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("COFCNM",portalChildRetrieveSO.getCdCaseManagerOfficeLoc())) );
          int _jspx_eval_impact_validateDisplayOnlyField_24 = _jspx_th_impact_validateDisplayOnlyField_24.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_25.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_25.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_25.setLabel("Supervisor Name");
          _jspx_th_impact_validateDisplayOnlyField_25.setValue( FormattingHelper.formatString(portalChildRetrieveSO.getNmSupervisor()) );
          int _jspx_eval_impact_validateDisplayOnlyField_25 = _jspx_th_impact_validateDisplayOnlyField_25.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_26.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_26.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_26.setLabel("Title");
          _jspx_th_impact_validateDisplayOnlyField_26.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CEMPJBCL",portalChildRetrieveSO.getCdSupervisorJobTitle())) );
          int _jspx_eval_impact_validateDisplayOnlyField_26 = _jspx_th_impact_validateDisplayOnlyField_26.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_27.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_27.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_27.setLabel("Phone");
          _jspx_th_impact_validateDisplayOnlyField_27.setValue( FormattingHelper.formatPhone(portalChildRetrieveSO.getSzSupervisorPhone()) );
          int _jspx_eval_impact_validateDisplayOnlyField_27 = _jspx_th_impact_validateDisplayOnlyField_27.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_28.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_28.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_28.setLabel("Office Location");
          _jspx_th_impact_validateDisplayOnlyField_28.setValue( FormattingHelper.formatString(Lookup.simpleDecodeSafe("COFCNM",portalChildRetrieveSO.getCdSupervisorOfficeLoc())) );
          int _jspx_eval_impact_validateDisplayOnlyField_28 = _jspx_th_impact_validateDisplayOnlyField_28.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n</tr>\r\n\r\n\r\n</table>\r\n<br/>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("PersonChar");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Person Characteristics");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_0.setId("btnAdd_Id");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      <div id=\"scrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableborderList\">\r\n                 <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n                           <tr>\r\n                           <th class=\"thList\">Category</th>\r\n                           <th class=\"thList\">Characteristic</th>\r\n                           <th class=\"thList\">&nbsp;</th>\r\n                        </tr>\r\n");
loopCount = 0;
        //If cinv04 is not null, then check to see if BCdPersonChar is equal to "2", if it is, then
        //No characteristics applicable is checked on the Person Char page, set hidden field equal to
        
        String persChar = portalChildRetrieveSO.getCdPersonChar();
        if ("2".equals(persChar)) {

        
              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">None Diagnosed\r\n                        ");
              if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");
}

        else if ("3".equals(persChar)) {

        
              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">Not Yet Diagnosed \r\n                        ");
              if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write("\r\n                        </td>\r\n                      </tr> \r\n");
}
        //If the Characteristics array has no elemnts, then no characteristics have been selected
        //set hidden field equal to "N" for custom Validation
        else if ((childCharacteristics== null)||(childCharacteristics.isEmpty())) {

              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">\r\n                           ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n                           ");
              if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");
}
        //If Charactaristics have been selected, set the hidden field to "Y" for custom Validation
        else {
          Iterator<PersonCharacteristicsBean> iterator = childCharacteristics.iterator();
          while (iterator.hasNext()) {
            PersonCharacteristicsBean charRow = iterator.next();

              out.write("\r\n                        <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\" valign=\"top\">\r\n                            <td>");
              out.print(Lookup.simpleDecodeSafe("CCHRTCAT", charRow.getCdCharCategory()));
              out.write("</td>\r\n                            <td>\r\n                                ");
              out.print(Lookup.simpleDecodeSafe(charRow.getCdCharCategory(), charRow.getCdCharacteristic()));
              out.write("\r\n                            <td>\r\n                        </tr>\r\n");
loopCount++;
          }
        }

              out.write("\r\n           </table>\r\n       </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br/>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("ContactList");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Contacts");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_1.setId("btnAdd_Id");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');
              //  impact:pagination
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
              _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_pagination_0.setSubmitUrl(submitUrl);
              int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
              if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<div id=\"scrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableborderList\">\r\n <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n                           <tr>\r\n                           <th class=\"thList\">Date</th>\r\n                           <th class=\"thList\">Method</th>\r\n                           <th class=\"thList\">Purpose</th>\r\n                           <th class=\"thList\">Name</th>\r\n                           <th class=\"thList\">Contacted By</th>\r\n                           <th class=\"thList\">Agency</th>\r\n                        </tr>\r\n");

loopCount = 0;
if ((contactList== null)||(contactList.isEmpty())) {

                  out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"6\">\r\n                           ");
                  out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
                  out.write("\r\n                          \r\n                        </td>\r\n                      </tr>\r\n");
}
        
        else {
          Iterator<PortalContactBean> iterator = contactList.iterator();
          while (iterator.hasNext()) {
            PortalContactBean contact = iterator.next();

                  out.write("\r\n                        <tr class=\"");
                  out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
                  out.write("\" valign=\"top\">\r\n                            <td>");
                  out.print(FormattingHelper.formatDate(contact.getDtContactDate()));
                  out.write("</td>\r\n                            ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ifThen_3.setTest( ("Y".equals(contact.getSzIndAccess())));
                  int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
                  if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                            <td><a href=\"javascript:displayContactDetail('");
                      out.print(FormattingHelper.formatInt(contact.getIdContactEvent()));
                      out.write("')\">");
                      out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCNTMETH", contact.getCdCntctMethod())));
                      out.write("</a></td>\r\n                            ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                            ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ifThen_4.setTest( ("N".equals(contact.getSzIndAccess())));
                  int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
                  if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                            <td>");
                      out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCNTMETH", contact.getCdCntctMethod())));
                      out.write("</td>\r\n                            ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                            <td>");
                  out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCNTPURP", contact.getCdCntctPurpose())));
                  out.write("</td>\r\n                            <td>");
                  out.print(FormattingHelper.formatFullName(portalChildRetrieveSO.getNmPersonFirst(),portalChildRetrieveSO.getNmPersonMiddle(),portalChildRetrieveSO.getNmPersonLast()));
                  out.write("</td>\r\n                            <td>");
                  out.print(FormattingHelper.formatString(contact.getSzContactedBy()));
                  out.write("</td>\r\n                            <td>");
                  out.print(FormattingHelper.formatString(contact.getSzContactAgency()));
                  out.write("</td>\r\n                            \r\n                        </tr>\r\n");
loopCount++;
          }
        }

                  out.write("\r\n</table>\r\n</div>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n          <tr>\r\n            <td class=\"tableBG\">\r\n            <div class=\"alignRight\">");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_0.setName("btnAdd");
              _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_0.setNavAwayCk(false);
              _jspx_th_impact_ButtonTag_0.setFunction("cancelValidation()");
              _jspx_th_impact_ButtonTag_0.setForm("frmPortalChildDetail");
              _jspx_th_impact_ButtonTag_0.setAction("/contacts/PortalContactDetail/addContact");
              _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW + EditableMode.VIEW);
              _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</div>\r\n            </td>\r\n          </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnUlIdCase");
          _jspx_th_impact_validateInput_3.setValue( GlobalData.getUlIdCaseAsString(request));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnUlIdStage");
          _jspx_th_impact_validateInput_4.setValue( GlobalData.getUlIdStageAsString(request));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnUlIdPerson");
          _jspx_th_impact_validateInput_5.setValue( GlobalData.getUlIdPersonAsString(request));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnUlIdPlcmtEvent");
          _jspx_th_impact_validateInput_6.setValue( GlobalData.getUlIdPlcmtEventAsString(request));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnUlIdRsrcParent");
          _jspx_th_impact_validateInput_7.setValue( GlobalData.getUlIdParentRsrcAsString(request));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnUlIdRsrcChild");
          _jspx_th_impact_validateInput_8.setValue( GlobalData.getUlIdResourceAsString(request));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnUlIdPlcmtFacil");
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdResource()));
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnUlIdPlcmtAgency");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdRsrcAgency()));
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnBIndChar");
    _jspx_th_impact_validateInput_0.setValue("N");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnBIndChar");
    _jspx_th_impact_validateInput_1.setValue("N");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnBIndChar");
    _jspx_th_impact_validateInput_2.setValue("N");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_9.setName("hdnUlIdEvent");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
