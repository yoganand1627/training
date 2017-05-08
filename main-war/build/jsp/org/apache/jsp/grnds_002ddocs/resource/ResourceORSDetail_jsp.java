package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSResourceDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSComplaintSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAdverseActionSO;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Ccount;

public final class ResourceORSDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


  /*
 * JSP Name:     ORSResourceDetail.jsp
 *
 * <pre>
 *                        Change History:
 *                        Date      User                            Description
 *                        --------  ----------------               --------------------------------------------------
 * </pre>                 07/30/2008 mchillman        STGAP00009801 different message will display for non-residential facilities compliants
 *                                                   
 */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Initialize all display variables for the page
  String rsrcLegalName = "";
  String rsrcFacilityID = "";
  String destinationUrl = "";
  
  int tabIndex = 1;
  int loopCount = 0;
  String rowCss = "altColor";
  
  
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  ORSResourceDetailSO orsDetail = (ORSResourceDetailSO) state.getAttribute(ORSResourceDetailConversation.ORS_DETAIL_ATTRIBUTE_NAME, request);
  List<ORSComplaintSO> complaintList = orsDetail.getComplaints();
  List<ORSAdverseActionSO> adverseActionList = orsDetail.getAdverseActions();
  
  String pageMode = PageMode.getPageMode(request);

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n\r\nwindow.attachEvent('onload', myOnLoadFunction );\r\n\r\nfunction myOnLoadFunction() {\r\n  \r\n}\r\n\r\n/*\r\n  *This function submits the form to bring up address complaint detail page.\r\n  */\r\nfunction submitFormComplaintDetail( compliantRowId ) {\r\n document.frmORSResourceDetail.txtCompliantRowId.value = compliantRowId\r\n disableValidation( \"frmORSResourceDetail\" );\r\n submitValidateForm( \"frmORSResourceDetail\", \"/resource/ResourceORSDetail/displayORSComplaintDetail\" );\r\n}\r\n\r\n/*\r\n  *This function submits the form to bring up address adverse action detail page.\r\n  */\r\nfunction submitFormAdverseActionDetail( adverseActionRowId ) {\r\n document.frmORSResourceDetail.txtAdverseActionRowId.value = adverseActionRowId\r\n disableValidation( \"frmORSResourceDetail\" );\r\n submitValidateForm( \"frmORSResourceDetail\", \"/resource/ResourceORSDetail/displayORSAdverseActionDetail\" );\r\n}\r\n\r\n\r\n/*\r\n  *This function submits the form to create a shines resoure from a ors resource.\r\n  */\r\nfunction submitFormAddToShines() {\r\n");
      out.write(" disableValidation( \"frmORSResourceDetail\" );\r\n}\r\n\r\n\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmORSResourceDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ORSResourceDetail/saveResourceDetail");
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.EDIT);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
/* Use descriptive IDs for your Table and Tag identifiers :
				   Javascript code would be better inside a function that is called from here,
				   but for ease of use I have put the code here */
				
          out.write("\r\n\t\t\t\t<a href=\"#\" onClick=\"expandAll();\">Expand All</a>&nbsp;\r\n\t\t\t\t<a href=\"#\" onClick=\"collapseAll();\">Collapse All</a>&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE1\">\r\n\t\r\n\t  <tr>\r\n\t        <th colspan=\"4\">ORS Resource Detail</th>\r\n\t </tr>\r\n        <tr>\r\n        \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtResourceName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("ORS Resource Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(orsDetail.getSzResourceName());
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtFacilityID");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("ORS Facility ID");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(orsDetail.getSzORSFacilityID());
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtLegalName");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Legal Name");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(orsDetail.getSzLegalName());
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("txtORSOperatingStatus");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("ORS Operating Status");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(orsDetail.getSzOperatingStatus());
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t\r\n        <tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("txtAddress");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Address");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(orsDetail.getSzAddress());
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t\r\n\t\t<tr>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("txtCity");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("City");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(orsDetail.getSzCity());
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("txtState");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("State");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(orsDetail.getSzState());
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("txtZip");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Zip");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(orsDetail.getSzZipCode());
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("txtCounty");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("County");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(orsDetail.getSzCounty());
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("txtLicenseNumber");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("License Number");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue(orsDetail.getSzORSLicenseNumber());
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("txtFacilityType");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Facility Type");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue(orsDetail.getSzORSFacilityType());
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t\r\n        <tr>\r\n        \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_11.setName("txtFacilityTypeOfervice");
          _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Facility Type of Service");
          _jspx_th_impact_validateDisplayOnlyField_11.setValue(orsDetail.getSzTypeOfService());
          int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_12.setName("txtAgesOfChildrenServed");
          _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Ages of Children Served");
          _jspx_th_impact_validateDisplayOnlyField_12.setValue(orsDetail.getSzAgesOfChildrenServed());
          int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_13.setName("txtCapacity");
          _jspx_th_impact_validateDisplayOnlyField_13.setLabel("Capacity");
          _jspx_th_impact_validateDisplayOnlyField_13.setValue(orsDetail.getSzCapacity());
          int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_14.setName("txtLicenseType");
          _jspx_th_impact_validateDisplayOnlyField_14.setLabel("License Type");
          _jspx_th_impact_validateDisplayOnlyField_14.setValue(orsDetail.getSzLicenseType());
          int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_15.setName("txtLicenseContinuationIndicator");
          _jspx_th_impact_validateDisplayOnlyField_15.setLabel("License Continuation Indicator");
          _jspx_th_impact_validateDisplayOnlyField_15.setValue(orsDetail.getIndLicenseContinuation());
          int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_16.setName("txtLicenseEffectiveDate");
          _jspx_th_impact_validateDisplayOnlyField_16.setLabel("License Effective Date");
          _jspx_th_impact_validateDisplayOnlyField_16.setValue(FormattingHelper.formatDate(orsDetail.getDtLicenseEffective()));
          int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_17.setName("txtDateLastUpdated");
          _jspx_th_impact_validateDisplayOnlyField_17.setLabel("Date Last Updated");
          _jspx_th_impact_validateDisplayOnlyField_17.setValue(FormattingHelper.formatDate(orsDetail.getDtLastUpdated()));
          int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n         <tr>\r\n        \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_18.setName("txtResourceID");
          _jspx_th_impact_validateDisplayOnlyField_18.setLabel("Resource ID");
          _jspx_th_impact_validateDisplayOnlyField_18.setValue(orsDetail.getSzShinesRsrsID());
          int _jspx_eval_impact_validateDisplayOnlyField_18 = _jspx_th_impact_validateDisplayOnlyField_18.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_19.setName("txtFacilityID");
          _jspx_th_impact_validateDisplayOnlyField_19.setLabel("Resource Name");
          _jspx_th_impact_validateDisplayOnlyField_19.setValue(orsDetail.getSzShinesRsrsName());
          int _jspx_eval_impact_validateDisplayOnlyField_19 = _jspx_th_impact_validateDisplayOnlyField_19.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t</tr>\r\n\r\n\t</table>\r\n\t\r\n\t\r\n\t<br>\r\n\t\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("complaintDetail");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("ORS Complaint List");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t");
              //  impact:pagination
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
              _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_pagination_0.setSaveState("true");
              _jspx_th_impact_pagination_0.setSubmitUrl("/resource/ResourceORSDetail/displayORSResourceDetail");
              int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
              if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t  <div id=\"ORSComplaintListScroll\" style=\"OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px\" class=\"tableBorder\">\r\n\t\t    \r\n\t\t    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t      <tr>\r\n\t\t        <th class=\"thList\">Intake Number</th>\r\n\t\t        <th class=\"thList\">Intake Date</th>\r\n\t\t        <th class=\"thList\">Type</th>\r\n\t\t        <th class=\"thList\">Status</th>\r\n\t\t        <th class=\"thList\">Priority</th>\r\n\t\t        <th class=\"thList\">Date Last Updated</th>\r\n\t\t     </tr>\r\n\t\t     \r\n\t\t    ");

        		loopCount = 0;
        		if (complaintList != null && complaintList.size() > 0) {
        			Iterator<ORSComplaintSO> itrComplaint = complaintList.iterator();
        			while(itrComplaint.hasNext()){
        				ORSComplaintSO complaint = itrComplaint.next();
        				rowCss = FormattingHelper.getRowCss(++loopCount);
        				
                  out.write("\r\n        \t\t\t\t\t<tr class=\"");
                  out.print(rowCss);
                  out.write("\" valign=\"top\">\r\n    \t\t\t\t\t");

    					
						// SIR 23730 Phase II Mobile Start
						if( PlatformConstants.MOBILE_IMPACT ) {   
						 
                  out.write("\r\n\t\t\t\t\t\t \t<td><nobr>");
                  out.print(complaint.getSzNmItake());
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t ");

						} else {
						 
                  out.write("\r\n\t\t\t\t\t\t \t<td><nobr><a tabIndex=\"");
                  out.print(tabIndex++);
                  out.write("\" href=\"javascript:submitFormComplaintDetail( '");
                  out.print(loopCount);
                  out.write("', 'U')\">");
                  out.print(complaint.getSzNmItake());
                  out.write(" </a></nobr></td>\r\n\t\t\t\t\t\t ");
        
						 }
						     // SIR 23730 Phase II Mobile End
						 
                  out.write("\r\n\t\t\t\t\t\t   <td><nobr>");
                  out.print(FormattingHelper.formatDate(complaint.getDtIntake()));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t   <td><nobr>");
                  out.print(complaint.getSzType());
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t   <td><nobr>");
                  out.print(complaint.getSzStatus());
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t   <td><nobr>");
                  out.print(complaint.getSzPriority().length() <= 40 ? complaint.getSzPriority() : complaint.getSzPriority().substring(0 ,40));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t   <td><nobr>");
                  out.print(FormattingHelper.formatDate(complaint.getDtLastUpdate()));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t  </tr>\r\n\t\t\t\t\t\t");
 
					}
        		}
        		else {
        		  String facType = orsDetail.getSzORSFacilityTypeCode();
        		  if(facType != null && facType.startsWith("4")) {
        		    
                  out.write("\r\n        \t\t\t   <tr class=\"odd\"><td colspan=\"6\">No Results Found</td></tr>\r\n        \t\t   ");

        		  } else {
        		  	 
                  out.write("\r\n        \t\t\t   <tr class=\"odd\"><td colspan=\"6\">Data not available through Shines, but available from ORS at 404-657-5550</td></tr>\r\n        \t\t   ");

        		  }
        		}
        	
                  out.write("\r\n\t\t    </table>\r\n\t\t    \r\n\t\t</div>\r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              out.write('	');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\r\n\t<br>\r\n\t\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("adverseActionDetail");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("ORS Adverse Action List");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\r\n\t\t  <div id=\"ORSAdverseActionListScroll\" style=\"OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px\" class=\"tableBorder\">\r\n\t\t    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t      <tr>\r\n\t\t\t      <th class=\"thList\">Survey Identifier</th>\r\n\t\t\t      <th class=\"thList\">Date Initiated</th>\r\n\t\t\t      <th class=\"thList\">Disposition</th>\r\n\t\t\t      <th class=\"thList\">Date Last Updated</th>\r\n\t\t      </tr>\r\n\t\t\t");

        		loopCount = 0;
        		if (adverseActionList != null && adverseActionList.size() > 0) {
        			Iterator<ORSAdverseActionSO> itrAction = adverseActionList.iterator();
        			while(itrAction.hasNext()){
        				ORSAdverseActionSO action = itrAction.next();
        				rowCss = FormattingHelper.getRowCss(++loopCount);
        				
              out.write("\r\n        \t\t\t\t\t<tr class=\"");
              out.print(rowCss);
              out.write("\" valign=\"top\">\r\n    \t\t\t\t\t");

    					
						// SIR 23730 Phase II Mobile Start
						if( PlatformConstants.MOBILE_IMPACT )
						    {   
						 
              out.write("\r\n\t\t\t\t\t\t \t<td><nobr>");
              out.print(action.getSzSurveyIdentifier());
              out.write("</nobr></td>\r\n\t\t\t\t\t\t ");

						} else {
						 
              out.write("\r\n\t\t\t\t\t\t \t<td><nobr><a tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" href=\"javascript:submitFormAdverseActionDetail( '");
              out.print(loopCount);
              out.write("', 'U')\">");
              out.print(action.getSzSurveyIdentifier());
              out.write(" </a></nobr></td>\r\n\t\t\t\t\t\t ");
        
						 }
						     // SIR 23730 Phase II Mobile End
						 
              out.write("\r\n\t\t\t\t\t\t   <td><nobr>");
              out.print(FormattingHelper.formatDate(action.getDtInitiated()));
              out.write("</nobr></td>\r\n\t\t\t\t\t\t   <td><nobr>");
              out.print(action.getSzDisposition());
              out.write("</nobr></td>\r\n\t\t\t\t\t\t   <td><nobr>");
              out.print(FormattingHelper.formatDate(action.getDtLastUpdate()));
              out.write("</nobr></td>\r\n\t\t\t\t\t\t  </tr>\r\n\t\t\t\t\t\t");
 
					}
        		}
        		else {
        		
              out.write("\r\n        \t\t\t<tr class=\"odd\"><td colspan=\"4\">No Results Found</td></tr>\r\n        \t\t");

        		}
        	
              out.write("\r\n\t\t    </table>\r\n\t\t</div>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\r\n\t");
 if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) ) { 
          out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t  <tr>\r\n\t\t    <td align=\"right\">\r\n\t\t      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnAddToSHINES");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("javascript:disableValidation('frmORSResourceDetail');");
          _jspx_th_impact_ButtonTag_0.setForm("frmORSResourceDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceORSDetail/addORSResourceToShines");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t</table>\r\n\t");
}
          out.write("\r\n\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"destinationUrl\" value=\"");
          out.print(destinationUrl);
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"txtCompliantRowId\"/>\r\n\t<input type=\"hidden\" name=\"txtAdverseActionRowId\"/>\r\n\t<!-- For the add page pass the prepop values in the request-->\r\n\t<input type=\"hidden\" name=\"txtNmResource\" value=\"");
          out.print((orsDetail.getSzResourceName().length() > 30) ? orsDetail.getSzResourceName().substring(0, 30) : orsDetail.getSzResourceName());
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"txtNmLegal\" value=\"");
          out.print(orsDetail.getSzLegalName());
          out.write("\" /> \r\n\t<input type=\"hidden\" name=\"");
          out.print(AddressBean.ADDRESS1);
          out.write("\" value=\"");
          out.print(orsDetail.getSzAddress());
          out.write("\" /> \r\n\t<input type=\"hidden\" name=\"");
          out.print(AddressBean.CITY);
          out.write("\" value=\"");
          out.print(orsDetail.getSzCity());
          out.write("\" /> \r\n\t<input type=\"hidden\" name=\"");
          out.print(AddressBean.COUNTY);
          out.write("\" value=\"");
          out.print(Lookup.simpleEncodeSafe(Ccount.CCOUNT, orsDetail.getSzCounty()));
          out.write("\" /> \r\n\t<input type=\"hidden\" name=\"");
          out.print(AddressBean.STATE);
          out.write("\" value=\"");
          out.print(orsDetail.getSzState());
          out.write("\" /> \r\n\t<input type=\"hidden\" name=\"");
          out.print(AddressBean.ZIP);
          out.write("\" value=\"");
          out.print(orsDetail.getSzZipCode());
          out.write("\" /> \r\n\t<input type=\"hidden\" name=\"");
          out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
          out.write("\" value=\"");
          out.print(orsDetail.getSzORSFacilityID());
          out.write("\" /> \r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmORSResourceDetail");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
