package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonMedicationList;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.person.MedicationSubmoduleConversation;
import java.util.Iterator;
import java.util.List;

public final class MedicationSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
BaseSessionStateManager state = (BaseSessionStateManager) request
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


      out.write("\r\n\r\n<!--<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>-->\r\n<!--<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>-->\r\n<!--<script type=\"text/javascript\" language=\"JavaScript1.2\">-->\r\n\r\n<script language=\"Javascript\">\r\nfunction launchMedicationDetail( index )\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".medicationIndex.value = index;\r\n  disableValidation( '");
      out.print( includingFormName );
      out.write("' );\r\n  submitValidateForm('");
      out.print( includingFormName );
      out.write("', '/person/MedicationDetail/displayMedicationDetail');\r\n}\r\n\r\n\r\nfunction addMedicationDetail()\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".isAddMedication.value = 'true';\r\n  return true;\r\n}\r\n</script>\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateInput_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_1(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("Medication");
      _jspx_th_impact_ExpandableSectionTag_0.setId("medicationItem_0");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Medication");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  <div id=\"scrollBar\" style=\"height:165px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n      <tr>\r\n        <th class=\"thList\">\r\n          Medication Name\r\n        </th>\r\n        <th class=\"thList\">\r\n          Frequency\r\n        </th>\r\n        <th class=\"thList\">\r\n          Reason\r\n        </th>\r\n        <th class=\"thList\">\r\n          Admin Person\r\n        </th>\r\n        <th class=\"thList\">\r\n          Start Date\r\n        </th>\r\n        <th class=\"thList\">\r\n          End Date\r\n        </th>\r\n        <th class=\"thList\">\r\n          Allergy Description\r\n        </th>\r\n        <th class=\"thList\">\r\n          Comments\r\n        </th>\r\n      </tr>\r\n      ");
if (!FormValidation.pageHasErrorMessages(request)) {
        if (size == 0) {

          out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"8\">\r\n          ");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
          out.write("\r\n        </td>\r\n      </tr>\r\n      ");
} else {

        for (Iterator<PersonMedicationList> it = medications.iterator(); it.hasNext();) {
          PersonMedicationList medRow = (PersonMedicationList) it.next();

      
          out.write("\r\n      <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1));
          out.write("\">\r\n        <td align=\"left\">\r\n\r\n          ");
String medName = "";
            medName = FormattingHelper.formatString(medRow.getLdNmMedctn());
            String listItemId = "medicationItem_" + loopCount;

            
          out.write("\r\n          <a href=\"javascript:launchMedicationDetail('");
          out.print( loopCount );
          out.write("');\" tabIndex=\"");
          out.print( tabIndex );
          out.write("\" id=\"");
          out.print( listItemId );
          out.write('"');
          out.write('>');
          out.print(medName);
          out.write("</a>\r\n        </td>\r\n        <td>\r\n          ");
          out.print(FormattingHelper.formatString(medRow.getLdCdMedctnDose()));
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          out.print(FormattingHelper.formatString(medRow.getLdTxtMedctnReason()));
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          out.print(FormattingHelper.formatString(medRow.getLdTxtMedctnAdminPerson()));
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          out.print(FormattingHelper.formatDate(medRow.getLdDtMedctnPresc()));
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          out.print(FormattingHelper.formatDate(medRow.getLdDtMedctnEndDate()));
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          out.print(FormattingHelper.formatString(medRow.getLdTxtMedctnDescrip()));
          out.write("\r\n        </td>\r\n        \r\n        ");
 
        	String comments = medRow.getLdTxtMedctnCmnts();
        	if(comments != null || "".equals(comments)){        
        
          out.write("\r\n        <td>\r\n        \t<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\">\r\n\t\t</td>\r\n\t\t");
}else{
          out.write("\r\n\t\t<td>\r\n\t\t\t&nbsp;\r\n\t\t</td>\r\n\t\t");
}
          out.write("\r\n\r\n      </tr>\r\n      ");
loopCount++;
          } // end while enumeration has more elements
        } //end big else
      } // end !FormValidation.pageHasErrorMessages

      
          out.write("\r\n    </table>\r\n  </div>\r\n\r\n  ");
if (!pageMode.equals(PageModeConstants.VIEW)) {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAddNewMedication");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm( includingFormName );
          _jspx_th_impact_ButtonTag_0.setFunction("return addMedicationDetail();");
          _jspx_th_impact_ButtonTag_0.setAction("/person/MedicationDetail/displayMedicationDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
}

    
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent(null);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("medicationIndex");
    _jspx_th_impact_validateInput_0.setValue("0");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent(null);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("isAddMedication");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
