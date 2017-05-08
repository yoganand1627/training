package org.apache.jsp.grnds_002ddocs.contacts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;

public final class SummaryContactSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  07/24/05 Mike Werle    SIR 23728 - Moved constants for code reuse in MPS
//**
//**
//**

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");

  BaseSessionStateManager _state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);


  CSYS08SO _csys08so = (CSYS08SO) _state.getAttribute("CSYS08SO", request);
  if (_csys08so == null) 
  { 
    _csys08so = new CSYS08SO(); 
  }

  String _selSzCdContactType =  ContactSearchListDetailConversation.getSelSzCdContactType(request);


  // SIR 18273 has decreed that from this day forth EXR's will no longer have a
  // Summary Period! :-) (so I removed EXR from the needsSummaryDates array)
  // We drop the first letter from the codes below because all MTH's have
  // Summary Dates and the rest of the list is all I's
  String[] needsSummaryDates = {"ATZ", "DVZ", "MAZ", "MTH", "PHZ", "QUZ", "REE", "REZ", "SEZ", "VAZ", "VIZ"};


  String disableSummaryDates = "true";
  boolean usesSummaryDates = false;
  
  //if the Contact Type needs summary dates set usesSummaryDates to true.
  for (int i = 0; i < needsSummaryDates.length; i++)
  {
    //!!!
    if (_selSzCdContactType.substring(1, 4).equals(needsSummaryDates[i]))
    {
      // SIR 19275 - If it's a Monthly Summary and Pending don't allow the
      // From and To dates to be modified.
      if (_csys08so.getROWCCMN45DO() != null && 
          CodesTables.CEVTSTAT_PEND.equals(_csys08so.getROWCCMN45DO().getSzCdEventStatus()) &&
          "MTH".equals( _selSzCdContactType.substring( 1, 4 ) ) )
      {
        disableSummaryDates = "true";
      } 
      else 
      {
        disableSummaryDates = "false";
      }
      usesSummaryDates = true;
      break;
    }
  }
  // If the dates aren't used then blank them for the display.
  String txtDtDtMonthlySummBegin = FormattingHelper.formatDate(_csys08so.getDtDtMonthlySummBegin());
  String txtDtDtMonthlySummEnd = FormattingHelper.formatDate(_csys08so.getDtDtMonthlySummEnd());
  if (!usesSummaryDates)
  {
    txtDtDtMonthlySummBegin = "";
    txtDtDtMonthlySummEnd = "";
  }

      out.write("\r\n</table>\r\n<br>\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setType("hidden");
      _jspx_th_impact_validateInput_0.setName("usesSummaryDates");
      _jspx_th_impact_validateInput_0.setValue( String.valueOf(usesSummaryDates) );
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( usesSummaryDates );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"TableBorder\">\r\n      <tr class=\"subDetail\">\r\n        <th colspan=\"4\">Contact Summary Period</th>\r\n      </tr>\r\n      <tr>\r\n        <td width=\"15%\">\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
          _jspx_th_impact_validateDate_0.setLabel("From");
          _jspx_th_impact_validateDate_0.setWidth("34%");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setName("txtDtDtMonthlySummBegin");
          _jspx_th_impact_validateDate_0.setDisabled( disableSummaryDates );
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setValue( txtDtDtMonthlySummBegin );
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td width=\"15%\">\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
          _jspx_th_impact_validateDate_1.setLabel("To");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setName("txtDtDtMonthlySummEnd");
          _jspx_th_impact_validateDate_1.setDisabled( disableSummaryDates );
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setValue( txtDtDtMonthlySummEnd );
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setTabIndex( _tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  request.setAttribute("tabIndex", _tabIndex);
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
