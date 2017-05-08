package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;

public final class ResourceListSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  List _resourcesList = (List) request.getAttribute("resourcesList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");

      out.write("\r\n<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <th class=\"thList\">Name</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Amount</th>\r\n      <th class=\"thList\">Source</th>\r\n      <th class=\"thList\">Verification Method</th>\r\n      <th class=\"thList\">Accessible?</th>\r\n      <th class=\"thList\">Countable/Exempt</th>\r\n    </tr>\r\n");
  
  if (_resourcesList == null)
  {

      out.write("\r\n    <tr class=\"odd\">\r\n      <td colspan=\"7\">\r\n        ");
      out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
      out.write("\r\n      </td>\r\n    </tr>\r\n");

  }
  else
  {
    int _loopCount = 0;
    Iterator _iterator = _resourcesList.iterator();
    while(_iterator.hasNext())
    {
      FceIncomeDB fceIncomeDB = (FceIncomeDB)_iterator.next();
      String nameSuffix = _baseNameSuffix + _loopCount;

      out.write("\r\n    <tr class=\"");
      out.print( FormattingHelper.getRowCss(_loopCount + 1) );
      out.write("\">\r\n      <td>\r\n        <a tabIndex=\"");
      out.print(_tabIndex++);
      out.write("\" \r\n           href=\"javascript:navigateToPersonDetail(");
      out.print(fceIncomeDB.getIdPerson() );
      out.write(")\"\r\n           onclick=\"setIsDirtyCalled(true)\">\r\n          ");
      out.print( fceIncomeDB.getNmPersonFull() );
      out.write("\r\n        </a>\r\n      </td>\r\n      <td>\r\n        ");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CRSRC, fceIncomeDB.getCdType()) );
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      out.print( FormattingHelper.formatMoney(fceIncomeDB.getAmtIncome()) );
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      out.print( fceIncomeDB.getTxtSource() );
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      out.print( fceIncomeDB.getTxtVerificationMethod() );
      out.write("\r\n      </td>\r\n      ");
 // STGAP00004122 - change col label from Inaccessible (above) to Accessible and modify display logic accordingly 
      out.write("\r\n      <td>\r\n        ");
      out.print( fceIncomeDB.getIndNotAccessible() ? "No" : "Yes" );
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setType("radio");
      _jspx_th_impact_validateInput_0.setLabel("Countable");
      _jspx_th_impact_validateInput_0.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix );
      _jspx_th_impact_validateInput_0.setDisabled( _disableRadios );
      _jspx_th_impact_validateInput_0.setValue(ArchitectureConstants.TRUE);
      _jspx_th_impact_validateInput_0.setTabIndex(_tabIndex++);
      _jspx_th_impact_validateInput_0.setChecked( "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndCountableString()) );
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n        <br/>\r\n        ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_1.setParent(null);
      _jspx_th_impact_validateInput_1.setType("radio");
      _jspx_th_impact_validateInput_1.setLabel("Exempt");
      _jspx_th_impact_validateInput_1.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix );
      _jspx_th_impact_validateInput_1.setDisabled( _disableRadios );
      _jspx_th_impact_validateInput_1.setValue(ArchitectureConstants.FALSE);
      _jspx_th_impact_validateInput_1.setTabIndex(_tabIndex++);
      _jspx_th_impact_validateInput_1.setChecked( "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndCountableString()) );
      int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
      if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n      </td>\r\n    </tr>\r\n");

      _loopCount++;
    }
  }

      out.write("\r\n  </table>\r\n</div>\r\n");

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
