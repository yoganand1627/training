package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;

public final class IncomeListSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  boolean _disableNoIncome =
          Boolean.valueOf((String) request.getAttribute("disableNoIncome"));

  List _incomeList = (List) request.getAttribute("incomeList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");

      out.write("\r\n<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <th class=\"thList\">Name</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Amount</th>\r\n      <th class=\"thList\">Source</th>\r\n      <th class=\"thList\">No&nbsp;Income</th>\r\n      <th class=\"thList\">Earned/Unearned</th>\r\n      <th class=\"thList\">Countable/Exempt</th>\r\n    </tr>\r\n");

  Iterator _iterator = _incomeList.iterator();
  int _loopCount = 0;
  while (_iterator.hasNext())
  {
    FceIncomeDB _fceIncomeDB = (FceIncomeDB) _iterator.next();
    boolean incomeZero = (_fceIncomeDB.getAmtIncome() == 0.0);
    boolean disableIncome = _disableNoIncome || (incomeZero == false);

    String nameSuffix = _baseNameSuffix + _loopCount;

      out.write("\r\n    <tr class=\"");
      out.print( FormattingHelper.getRowCss(_loopCount + 1) );
      out.write("\">\r\n      <td>\r\n        <a href=\"javascript:navigateToPersonDetail(");
      out.print( _fceIncomeDB.getIdPerson() );
      out.write(")\" \r\n           onclick=\"setIsDirtyCalled(true)\" \r\n           tabIndex=\"");
      out.print( _tabIndex++ );
      out.write("\">\r\n          ");
      out.print(_fceIncomeDB.getNmPersonFull());
      out.write("\r\n        </a>\r\n      </td>\r\n      <td>\r\n        ");
      out.print( Lookup.simpleDecodeSafe(CodesTables.CINC, _fceIncomeDB.getCdType()) );
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      out.print( FormattingHelper.formatMoney(_fceIncomeDB.getAmtIncome()) );
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      out.print( _fceIncomeDB.getTxtSource() );
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setType("checkbox");
      _jspx_th_impact_validateInput_0.setName( FceIncomeDB.IND_NONE + nameSuffix );
      _jspx_th_impact_validateInput_0.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateInput_0.setChecked( _fceIncomeDB.getIndNoneString() );
      _jspx_th_impact_validateInput_0.setDisabled( String.valueOf(disableIncome) );
      _jspx_th_impact_validateInput_0.setValue( ArchitectureConstants.TRUE );
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_1.setParent(null);
      _jspx_th_impact_validateInput_1.setType("radio");
      _jspx_th_impact_validateInput_1.setLabel("Earned");
      _jspx_th_impact_validateInput_1.setName( FceIncomeDB.IND_EARNED + nameSuffix );
      _jspx_th_impact_validateInput_1.setValue( ArchitectureConstants.TRUE );
      _jspx_th_impact_validateInput_1.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateInput_1.setDisabled( _disableRadios );
      _jspx_th_impact_validateInput_1.setChecked( "" + _fceIncomeDB.getIndEarned() );
      int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
      if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n        <br/>\r\n        ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_2.setParent(null);
      _jspx_th_impact_validateInput_2.setType("radio");
      _jspx_th_impact_validateInput_2.setLabel("Unearned");
      _jspx_th_impact_validateInput_2.setName( FceIncomeDB.IND_EARNED + nameSuffix );
      _jspx_th_impact_validateInput_2.setValue( ArchitectureConstants.FALSE );
      _jspx_th_impact_validateInput_2.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateInput_2.setDisabled( _disableRadios );
      _jspx_th_impact_validateInput_2.setChecked( "" + Boolean.FALSE.equals(_fceIncomeDB.getIndEarnedObject()) );
      int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
      if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n      </td>\r\n      <td>\r\n        ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_3.setParent(null);
      _jspx_th_impact_validateInput_3.setType("radio");
      _jspx_th_impact_validateInput_3.setLabel("Countable");
      _jspx_th_impact_validateInput_3.setName( FceIncomeDB.IND_COUNTABLE + nameSuffix );
      _jspx_th_impact_validateInput_3.setValue( ArchitectureConstants.TRUE );
      _jspx_th_impact_validateInput_3.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateInput_3.setDisabled( _disableRadios );
      _jspx_th_impact_validateInput_3.setChecked( "" + Boolean.TRUE.equals(_fceIncomeDB.getIndCountableObject()) );
      int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
      if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n        <br/>\r\n        ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_4.setParent(null);
      _jspx_th_impact_validateInput_4.setType("radio");
      _jspx_th_impact_validateInput_4.setLabel("Exempt");
      _jspx_th_impact_validateInput_4.setName( FceIncomeDB.IND_COUNTABLE + nameSuffix );
      _jspx_th_impact_validateInput_4.setValue( ArchitectureConstants.FALSE );
      _jspx_th_impact_validateInput_4.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateInput_4.setDisabled( _disableRadios );
      _jspx_th_impact_validateInput_4.setChecked( "" + Boolean.FALSE.equals(_fceIncomeDB.getIndCountableObject()) );
      int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
      if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n      </td>\r\n    </tr>\r\n");

    _loopCount++;
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
