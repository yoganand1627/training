package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

public final class SafetyResourceChild_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************

     BaseSessionStateManager state = 
           (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      //Set the page mode to the mode that is passed in
      String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) 
      {
        pageMode = PageMode.getPageMode(request);
      }

      String szDisabled = "false";
      String szDeleteDisabled = "true";
      String szSecondaryDisabled = "false";
      
      if (pageMode.equals(PageModeConstants.VIEW)) 
      {
          szDisabled = "true";
          szSecondaryDisabled = "true";
      }
      
      //Initialize the display variables for the page
      int tabIndex = 1;
      SafetyResourceChildRetrieveSO safetyResourceChildRetrieveSO = 
        (SafetyResourceChildRetrieveSO) state.getAttribute("SafetyResourceChildRetrieveSO",request);
      List<SafetyResourcePersonBean> safetyResourceChildList = 
                                     safetyResourceChildRetrieveSO.getSafetyResourceChildList();
      
      String szDtStart = "";
      String szDtEnd = "";
      String szNmPrimRel = "";
      String szNmSecRel = "";
      String selPrimaryRelationship = "";
      String selSecondaryRelationship = "";
      int ulIdEvent = safetyResourceChildRetrieveSO.getUlIdEvent();
      int ulIdSrChild = safetyResourceChildRetrieveSO.getUlIdSrChild();
      String szChecked = "";
      
      if (ulIdSrChild != 0) 
      {
         szChecked = "true";
         
         if (szDisabled.equals("false")){
           szDeleteDisabled = "false";
         }
      }
      
      if (safetyResourceChildRetrieveSO.getDtStart()!=null) 
      {
         szDtStart = FormattingHelper.formatDate(safetyResourceChildRetrieveSO.getDtStart());
      }
      
      if (safetyResourceChildRetrieveSO.getDtEnd() != null) 
      {
         szDtEnd = FormattingHelper.formatDate(safetyResourceChildRetrieveSO.getDtEnd());
      }
      
      if (safetyResourceChildRetrieveSO.getNmPrimarySafetyResource() != null) 
      {
         szNmPrimRel = FormattingHelper.formatString(safetyResourceChildRetrieveSO.getNmPrimarySafetyResource());
      }
      
      if (safetyResourceChildRetrieveSO.getNmSecondarySafetyResource() != null) 
      {
         szNmSecRel = FormattingHelper.formatString(safetyResourceChildRetrieveSO.getNmSecondarySafetyResource());
      }
      
      if (safetyResourceChildRetrieveSO.getCdRelationshipPrimary() != null) 
      {
         selPrimaryRelationship = FormattingHelper.formatString(safetyResourceChildRetrieveSO.getCdRelationshipPrimary());
      }
      
      if (safetyResourceChildRetrieveSO.getCdRelationshipSecondary() != null) 
      {
         selSecondaryRelationship = FormattingHelper.formatString(safetyResourceChildRetrieveSO.getCdRelationshipSecondary());
      }
      
      if ("".equals(szNmSecRel) && "false".equals(szSecondaryDisabled)){
      
         szSecondaryDisabled = "true";
      
      }
      

      out.write("\r\n\r\n");
      out.write("\r\n\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n</script>\r\n\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write(' ');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSafetyResourceChild");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/SafetyResource/displaySafetyResourceChild");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyResourceChildCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n \r\n\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Safety Resource Child Detail\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n    <td>\r\n    \r\n    </td>\r\n    </tr>\r\n       <tr>\r\n     <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Start Date of Safety Resource Placement");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue(szDtStart);
          _jspx_th_impact_validateDate_0.setName("txtDtStart");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setDisabled( szDisabled );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("  \r\n     </td>\r\n   </tr>\r\n      <tr>\r\n       <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("PrimSafetyResource_DISPLAY_ONLY");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Primary Safety Resource");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(szNmPrimRel);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>  \r\n    <tr> \r\n     <td>\r\n     ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Primary Safety Resource Relationship to Children");
          _jspx_th_impact_validateSelect_0.setName("selPrimaryRelationship");
          _jspx_th_impact_validateSelect_0.setCodesTable("CRPTRINT");
          _jspx_th_impact_validateSelect_0.setValue(selPrimaryRelationship);
          _jspx_th_impact_validateSelect_0.setDisabled( szDisabled );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     \r\n   </tr> \r\n   <tr>\r\n       <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("SecSafetyResource_DISPLAY_ONLY");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Secondary Safety Resource");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(szNmSecRel);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>  \r\n       <tr> \r\n     <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Secondary Safety Resource Relationship to Children");
          _jspx_th_impact_validateSelect_1.setName("selSecondaryRelationship");
          _jspx_th_impact_validateSelect_1.setCodesTable("CRPTRINT");
          _jspx_th_impact_validateSelect_1.setValue(selSecondaryRelationship);
          _jspx_th_impact_validateSelect_1.setDisabled( szSecondaryDisabled );
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n   </tr>   \r\n       <tr>\r\n     <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("End Date of Safety Resource Placement");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue(szDtEnd);
          _jspx_th_impact_validateDate_1.setName("txtDtEnd");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setDisabled( szDisabled );
          _jspx_th_impact_validateDate_1.setRequired("false");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("  \r\n     </td>\r\n   </tr>\r\n  </table>  \r\n  <br>\r\n  <br>\r\n    <tr>\r\n    <td colspan=\"2\">\r\n<div id=\"scrollBar\" style=\"height:100;width:762px;overflow:auto\" class=\"tableborderList\">\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"tableborder\">\r\n  <tr class=\"subDetail\">\r\n    <th colspan = \"2\"><span class=\"formRequiredText\">*</span>Children Placed</th>\r\n  </tr>\r\n   \r\n");
if (safetyResourceChildList.isEmpty() || safetyResourceChildList == null) {
  //if there are no children in the case, display cleanly

          out.write("        \r\n\t<tr class=\"odd\">\r\n\t\t<td colspan=\"10\">\r\n\t\t");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
          out.write("\r\n\t\t</td>\r\n   </tr>\r\n\r\n");
 } else {
    //iterate through the children returned to populate selections.  Will be 1 if this is display of
    //existing, or will be all principals under 18 for new 
    int loopCount = 0;
   
    for (Iterator <SafetyResourcePersonBean> it = safetyResourceChildList.iterator(); it.hasNext();) {      

            SafetyResourcePersonBean safetyResourceChildBean = it.next();
           

          out.write("\r\n            <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\" valign=\"top\">\r\n\t\t    ");

		       String checkId = "cbx_" + loopCount;
            
          out.write("\r\n\t\t\t<td>\r\n\t\t\t   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("checkbox");
          _jspx_th_impact_validateInput_0.setValue( String.valueOf(loopCount) );
          _jspx_th_impact_validateInput_0.setName( checkId );
          _jspx_th_impact_validateInput_0.setDisabled( szChecked );
          _jspx_th_impact_validateInput_0.setChecked( szChecked );
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          out.print(FormattingHelper.formatString(safetyResourceChildBean.getNmChildFull()));
          out.write("\r\n\t\t\t</td>\t\t\t\t\t\t\r\n\t\t\t</tr>\r\n\t\t\t");
loopCount++;
          }  // close iterator
        }  
          out.write("\r\n     \r\n</table></td></tr>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n<tr> \r\n<td width=\"20%\" align=\"left\">\r\n");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setForm("frmSafetyResourceChild");
          _jspx_th_impact_ButtonTag_0.setAction("/investigation/SafetyResource/deleteSafetyResourceChild");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setAccessKey("S");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setDisabled( szDeleteDisabled );
          _jspx_th_impact_ButtonTag_0.setFunction("");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<td width=\"80%\" align=\"right\">\r\n\r\n");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmSafetyResourceChild");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/SafetyResource/saveSafetyResourceChild");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setAccessKey("S");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setDisabled( szDisabled );
          _jspx_th_impact_ButtonTag_1.setFunction("");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n   </td>\r\n   </tr>\r\n</table>\r\n\r\n");
          out.write("\r\n  \r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnUlIdEvent");
          _jspx_th_impact_validateInput_1.setValue(Integer.toString(ulIdEvent));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnUlIdSrChild");
          _jspx_th_impact_validateInput_2.setValue(Integer.toString(ulIdSrChild));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \t  \r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\r\n");
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  \r\n");
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
