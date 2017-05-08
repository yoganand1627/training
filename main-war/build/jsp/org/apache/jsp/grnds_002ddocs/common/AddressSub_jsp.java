package org.apache.jsp.grnds_002ddocs.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class AddressSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

      out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
      _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
      _jspx_th_impact_validateInput_0.setDisabled( String.valueOf( addressSubAddressDisabled ) );
      _jspx_th_impact_validateInput_0.setType("text");
      _jspx_th_impact_validateInput_0.setRequired( String.valueOf( addressSubStreetRequired ));
      _jspx_th_impact_validateInput_0.setOnChange( changeAddress );
      _jspx_th_impact_validateInput_0.setLabel("Street");
      _jspx_th_impact_validateInput_0.setWidth("45%");
      _jspx_th_impact_validateInput_0.setTabIndex( addressSubTabIndex );
      _jspx_th_impact_validateInput_0.setCssClass("formInput");
      _jspx_th_impact_validateInput_0.setConstraint("Address");
      _jspx_th_impact_validateInput_0.setSize("50");
      _jspx_th_impact_validateInput_0.setMaxLength("30");
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_1.setParent(null);
      _jspx_th_impact_validateInput_1.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
      _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
      _jspx_th_impact_validateInput_1.setDisabled( String.valueOf( addressSubAddressDisabled ) );
      _jspx_th_impact_validateInput_1.setType("text");
      _jspx_th_impact_validateInput_1.setTabIndex( addressSubTabIndex );
      _jspx_th_impact_validateInput_1.setOnChange( changeAddress );
      _jspx_th_impact_validateInput_1.setCssClass("formInput");
      _jspx_th_impact_validateInput_1.setConstraint("Address");
      _jspx_th_impact_validateInput_1.setSize("50");
      _jspx_th_impact_validateInput_1.setMaxLength("30");
      int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
      if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_2.setParent(null);
      _jspx_th_impact_validateInput_2.setName( addressBean.getAttributeName( AddressBean.CITY ) );
      _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString( addressBean.getCity() ));
      _jspx_th_impact_validateInput_2.setDisabled( String.valueOf( addressSubAddressDisabled ) );
      _jspx_th_impact_validateInput_2.setType("text");
      _jspx_th_impact_validateInput_2.setRequired( String.valueOf( addressSubAddressRequired ));
      _jspx_th_impact_validateInput_2.setTabIndex( addressSubTabIndex );
      _jspx_th_impact_validateInput_2.setOnChange( changeAddress );
      _jspx_th_impact_validateInput_2.setLabel("City");
      _jspx_th_impact_validateInput_2.setCssClass("formInput");
      _jspx_th_impact_validateInput_2.setConstraint("City");
      _jspx_th_impact_validateInput_2.setMaxLength("20");
      int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
      if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

      out.write("\r\n    <td>");
      //  impact:validateSelect
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
      _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateSelect_0.setParent(null);
      _jspx_th_impact_validateSelect_0.setName( addressBean.getAttributeName( AddressBean.STATE ));
      _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString( stateDefault ) );
      _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( addressSubAddressDisabled ) );
      _jspx_th_impact_validateSelect_0.setRequired( String.valueOf( addressSubAddressRequired ));
      _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CSTATE );
      _jspx_th_impact_validateSelect_0.setTabIndex( addressSubTabIndex );
      _jspx_th_impact_validateSelect_0.setOnChange( onChange );
      _jspx_th_impact_validateSelect_0.setLabel("State");
      int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
      if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_3.setParent(null);
      _jspx_th_impact_validateInput_3.setName( addressBean.getAttributeName( AddressBean.ZIP ));
      _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatString( addressBean.getZip() ));
      _jspx_th_impact_validateInput_3.setDisabled( String.valueOf( addressSubAddressDisabled ) );
      _jspx_th_impact_validateInput_3.setRequired( String.valueOf( addressSubZipRequired  ));
      _jspx_th_impact_validateInput_3.setType("text");
      _jspx_th_impact_validateInput_3.setTabIndex( addressSubTabIndex );
      _jspx_th_impact_validateInput_3.setOnChange( changeAddress );
      _jspx_th_impact_validateInput_3.setLabel("Zip");
      _jspx_th_impact_validateInput_3.setCssClass("formInput");
      _jspx_th_impact_validateInput_3.setConstraint("Zip");
      _jspx_th_impact_validateInput_3.setMaxLength("5");
      _jspx_th_impact_validateInput_3.setSize("5");
      int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
      if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n      -\r\n          ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_4.setParent(null);
      _jspx_th_impact_validateInput_4.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
      _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
      _jspx_th_impact_validateInput_4.setDisabled( String.valueOf( addressSubAddressDisabled ) );
      _jspx_th_impact_validateInput_4.setType("text");
      _jspx_th_impact_validateInput_4.setOnChange( changeAddress );
      _jspx_th_impact_validateInput_4.setTabIndex( addressSubTabIndex );
      _jspx_th_impact_validateInput_4.setCssClass("formInput");
      _jspx_th_impact_validateInput_4.setConstraint("ZipSuff");
      _jspx_th_impact_validateInput_4.setMaxLength("4");
      _jspx_th_impact_validateInput_4.setSize("4");
      int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
      if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n        </td>\r\n        <td>\r\n            ");
      //  impact:validateSelect
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
      _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateSelect_1.setParent(null);
      _jspx_th_impact_validateSelect_1.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
      _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
      _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf( addressSubAddressDisabled ) );
      _jspx_th_impact_validateSelect_1.setRequired( String.valueOf( addressSubAddressRequired ) );
      _jspx_th_impact_validateSelect_1.setTabIndex( addressSubTabIndex );
      _jspx_th_impact_validateSelect_1.setBlankValue("true");
      _jspx_th_impact_validateSelect_1.setLabel("County");
      _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
      _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
      _jspx_th_impact_validateSelect_1.setExcludeOptions(addressSubExcludeCounty);
      _jspx_th_impact_validateSelect_1.setOnChange( changeAddress );
      int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
      if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

      out.write("\r\n  <tr>\r\n   <td>");
      //  impact:validateTextArea
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
      _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateTextArea_0.setParent(null);
      _jspx_th_impact_validateTextArea_0.setLabel("Comments");
      _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
      _jspx_th_impact_validateTextArea_0.setRequired( String.valueOf( addressSubCommentsRequired ) );
      _jspx_th_impact_validateTextArea_0.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
      _jspx_th_impact_validateTextArea_0.setCols("125");
      _jspx_th_impact_validateTextArea_0.setRows("4");
      _jspx_th_impact_validateTextArea_0.setColspan("3");
      _jspx_th_impact_validateTextArea_0.setTabIndex( addressSubTabIndex );
      _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
      _jspx_th_impact_validateTextArea_0.setMaxLength(300);
      int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
      if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_impact_validateTextArea_0.doInitBody();
        }
        do {
          out.print( FormattingHelper.formatString(addressBean.getComments() ));
          int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

      out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

      out.write("\r\n    <td class=\"alignRight\">\r\n      ");
      //  impact:ButtonTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
      _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ButtonTag_0.setParent(null);
      _jspx_th_impact_ButtonTag_0.setName("btnvalidate");
      _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
      _jspx_th_impact_ButtonTag_0.setAction("#");
      _jspx_th_impact_ButtonTag_0.setFunction(onclick);
      _jspx_th_impact_ButtonTag_0.setForm(addressSubFormName);
      _jspx_th_impact_ButtonTag_0.setTabIndex(addressSubTabIndex);
      _jspx_th_impact_ButtonTag_0.setOnBlur("setIsDirtyCalled(false);");
      int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
      if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_5(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_6(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_7.setParent(null);
      _jspx_th_impact_validateInput_7.setType("hidden");
      _jspx_th_impact_validateInput_7.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
      _jspx_th_impact_validateInput_7.setValue("true");
      int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
      if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_8.setParent(null);
      _jspx_th_impact_validateInput_8.setType("hidden");
      _jspx_th_impact_validateInput_8.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
      _jspx_th_impact_validateInput_8.setValue("true");
      int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
      if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_9.setParent(null);
      _jspx_th_impact_validateInput_9.setType("hidden");
      _jspx_th_impact_validateInput_9.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
      _jspx_th_impact_validateInput_9.setValue("");
      int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
      if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_10.setParent(null);
      _jspx_th_impact_validateInput_10.setType("hidden");
      _jspx_th_impact_validateInput_10.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
      _jspx_th_impact_validateInput_10.setValue("");
      int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
      if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
      out.print( addressSubFormName );
      out.write("', '");
      out.print( addressSubAddressSubmoduleName );
      out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
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

  private boolean _jspx_meth_impact_validateInput_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent(null);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_5.setValue("0");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent(null);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_6.setValue("0");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
