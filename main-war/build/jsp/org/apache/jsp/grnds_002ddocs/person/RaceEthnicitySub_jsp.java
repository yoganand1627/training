package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

public final class RaceEthnicitySub_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateInput_0.setValue( ethnicity.getKey() );
          _jspx_th_impact_validateInput_0.setTabIndex( raceEthnicitySubDBTabIndex );
          _jspx_th_impact_validateInput_0.setName( RaceEthnicityHelper.ETHNICITY_RB_NAME );
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setChecked( String.valueOf( ethnicity.getKey().equals( personEthnicity ) ) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              ");
          out.print( ethnicity.getValue() );
          out.write("\r\n          </td>\r\n");

    }

          out.write("\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName( RaceEthnicityHelper.OLD_ETHNICITY_NAME );
          _jspx_th_impact_validateInput_1.setValue( personEthnicity );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
