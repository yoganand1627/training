package org.apache.jsp.grnds_002ddocs.intake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class IncomingPersonDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Incoming Person Detail
//*  Created by:   Ochu Michael
//*  Date Created: 02/05/2003
//*
//*  Description:
//*  This JSP is used to display incoming person information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//** 04/07/2004 ochumd            sir 19775 - Added code to make sure that the address
//**                              is valid before display.  A blank object is now being
//**                              returned when primary address is not valid.
//** 05/09/2005  nallavs          SIR -23547 Removed System.out.println Statement.

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  String pageMode = PageModeConstants.VIEW;
  int loopCount = 0;
  int tabIndex = 1;
  String bIntakeIndicator = "Y";

  UserProfile user = UserProfileHelper.getUserProfile( request );

  CINT34SO cint34so = (CINT34SO) request.getAttribute("CINT34SO");
  if (cint34so == null)
  {
    cint34so = new CINT34SO();
  }


  ROWCINT51DO rowcint51do = cint34so.getROWCINT51DO();

  ROWCINT49DO_ARRAY rowcint49do_Array = null;
  ROWCINT48DO_ARRAY rowcint48do_Array = null;
  ROWCINT50DO_ARRAY rowcint50do_Array = null;
  ROWCINT52DO_ARRAY rowcint52do_Array = null;

  if (cint34so.getROWCINT48DO_ARRAY() == null)
  {
    rowcint48do_Array = new ROWCINT48DO_ARRAY();
  }
  else
  {
    rowcint48do_Array = cint34so.getROWCINT48DO_ARRAY();
  }

  ROWCINT48DO rowcint48doPrimary = new ROWCINT48DO();
  //ROWCINT48DO temp48doPrimary = new ROWCINT48DO();
  Enumeration e = rowcint48do_Array.enumerateROWCINT48DO();

 /* ochumd sir 19775 - Added code to make sure that the address is valid before
    display.  A blank object is now being returned when primary address is not
    valid.
*/
  while (e.hasMoreElements())
  {
    rowcint48doPrimary = (ROWCINT48DO)e.nextElement();

    if ("Y".equals(rowcint48doPrimary.getCIndIncmgAddrPrimary()))
    {
      if("Y".equals(rowcint48doPrimary.getCIndIncmgAddrInvalid()) )
      {
        rowcint48doPrimary = new ROWCINT48DO();
      }
      //else{
      //  rowcint48doPrimary = temp48doPrimary;
      //}
      break;
    }
  }
  e = rowcint48do_Array.enumerateROWCINT48DO();


  if (cint34so == null)
  {
    cint34so = new CINT34SO();
  }
  if (cint34so.getROWCINT51DO() == null)
  {
    rowcint51do = new ROWCINT51DO();
  }
  else
  {
    rowcint51do = cint34so.getROWCINT51DO();
  }

  if (cint34so.getROWCINT49DO_ARRAY() == null)
  {
    rowcint49do_Array = new ROWCINT49DO_ARRAY();
  }
  else
  {
    rowcint49do_Array = cint34so.getROWCINT49DO_ARRAY();
  }

  ROWCINT49DO rowcint49doPrimary = new ROWCINT49DO();
  Enumeration x = rowcint49do_Array.enumerateROWCINT49DO();
  while (x.hasMoreElements())
  {
    rowcint49doPrimary = (ROWCINT49DO)x.nextElement();
    if ("Y".equals(rowcint49doPrimary.getCIndIncmgNamePrimary()))
    {
      break;
    }
  }
  x = rowcint49do_Array.enumerateROWCINT49DO();


  //  process rowcint50do_Array
  if (cint34so.getROWCINT50DO_ARRAY() == null)
  {
    rowcint50do_Array = new ROWCINT50DO_ARRAY();
  }
  else
  {
    rowcint50do_Array = cint34so.getROWCINT50DO_ARRAY();
  }

  ROWCINT50DO rowcint50doPrimary = new ROWCINT50DO();
  Enumeration b = rowcint50do_Array.enumerateROWCINT50DO();
  while (b.hasMoreElements())
  {
    rowcint50doPrimary = (ROWCINT50DO)b.nextElement();
    if ("Y".equals(rowcint50doPrimary.getCIndIncmgPersonIDInv()))
    {
      break;
    }
  }
  b = rowcint50do_Array.enumerateROWCINT50DO();


  //  process rowcint52do_Array
  if (cint34so.getROWCINT52DO_ARRAY() == null)
  {
    rowcint52do_Array = new ROWCINT52DO_ARRAY();
  }
  else
  {
    rowcint52do_Array = cint34so.getROWCINT52DO_ARRAY();
  }


  ROWCINT52DO rowcint52doPrimary = new ROWCINT52DO();
  Enumeration c = rowcint52do_Array.enumerateROWCINT52DO();
  while (c.hasMoreElements())
  {
    rowcint52doPrimary = (ROWCINT52DO)c.nextElement();
    if ("Y".equals(rowcint52doPrimary.getCIndIncmgPhonePrimary()))
    {
      break;
    }
  }
  c = rowcint52do_Array.enumerateROWCINT52DO();

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n//!!! was onbeforeunload supposed to be here?\r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmIncomingPersonDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/intake/IncomingPersonDetail/displayIncomingPersonDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n     <td align=\"right\">\r\n       <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n       <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n     </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellSpacing=\"0\" cellPadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">Person Information</th>\r\n  </tr>\r\n  <tr>\r\n       <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzNmFirst");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString(rowcint51do.getSzNmIncmgPersFull()) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspSzNbrRsrcVid");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Suffix");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatString(rowcint49doPrimary.getSzCdIncmgNameSuffix()) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n    </tr>\r\n     <tr>\r\n     <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspSzAddrRsrcAddrStLn1");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Street");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatString(rowcint48doPrimary.getSzAddrIncmgAddrStLn1()) );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspcity");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("City");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( FormattingHelper.formatString(rowcint48doPrimary.getSzAddrIncmgAddrCity()) );
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n     </tr>\r\n     <tr>\r\n     <td>&nbsp;</td>\r\n     <td>\r\n");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_0.setTest( (StringHelper.isValid(rowcint48doPrimary.getSzAddrIncmgAddrStLn2())) );
          int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
          if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
              int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
              if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n   ");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_validateDisplayOnlyField_4.setName("dspSzAddrRsrcAddrStLn2");
                  _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatString(rowcint48doPrimary.getSzAddrIncmgAddrStLn2()) );
                  int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n  ");
                  int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
              if (_jspx_meth_impact_else_0(_jspx_th_impact_if_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dspSzAddrRsrcAddrState");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("State");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatString(rowcint48doPrimary.getSzCdIncmgAddrState()) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n      </tr>\r\n         <tr>\r\n       <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("dspSzAddrRsrcAddrZip");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Zipcode");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue( FormattingHelper.formatString(rowcint48doPrimary.getSzAddrIncmgAddrZip()) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n        <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("dspSzCdFacilityCounty");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("County");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(Lookup.simpleDecodeSafe("CCOUNT",   rowcint48doPrimary.getSzCdIncmgAddrCounty()));
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n            </tr>\r\n  <tr>\r\n      <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("dspSzAddrRsrcAddrZip");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Address Type");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue( FormattingHelper.formatString(rowcint48doPrimary.getSzCdIncmgAddrType()) );
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n          <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("txtPhone");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Phone");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue( FormattingHelper.formatPhone(rowcint52doPrimary.getSzNbrIncmgPhone()) );
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            Ext:\r\n             ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("Phoneex");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue( FormattingHelper.formatString(rowcint52doPrimary.getSzNbrIncmgPhoneExtension()) );
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n          </tr>\r\n  <tr>\r\n      <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_11.setName("dspSzPhoneType");
          _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Phone Type");
          _jspx_th_impact_validateDisplayOnlyField_11.setValue( FormattingHelper.formatString(rowcint52doPrimary.getSzCdIncmgPhoneType()) );
          int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n    </tr>\r\n     <th colspan=\"8\">Demographics</th>\r\n  <tr>\r\n       <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_12.setName("dspSzNmRes");
          _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Age");
          _jspx_th_impact_validateDisplayOnlyField_12.setValue( FormattingHelper.formatInt(rowcint51do.getUsNbrIncmgPersAge()) );
          int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_13.setName("dspSzNbrRsr");
          _jspx_th_impact_validateDisplayOnlyField_13.setLabel("DOB");
          _jspx_th_impact_validateDisplayOnlyField_13.setValue( FormattingHelper.formatDate(rowcint51do.getDtDtIncmgPersBirth()) );
          int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n    </tr>\r\n  <tr>\r\n       <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_14.setName("dspSzAddrRsr");
          _jspx_th_impact_validateDisplayOnlyField_14.setLabel("DOD");
          _jspx_th_impact_validateDisplayOnlyField_14.setValue( FormattingHelper.formatDate(rowcint51do.getDtDtIncmgPersDeath()) );
          int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_15.setName("dspReason");
          _jspx_th_impact_validateDisplayOnlyField_15.setLabel("Reason");
          _jspx_th_impact_validateDisplayOnlyField_15.setValue( FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersDeath()) );
          int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n </tr>\r\n  <tr>\r\n       <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_16.setName("dspSRes");
          _jspx_th_impact_validateDisplayOnlyField_16.setLabel("Marital");
          _jspx_th_impact_validateDisplayOnlyField_16.setValue( FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersMaritlStat()) );
          int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_17.setName("dspSzRsr");
          _jspx_th_impact_validateDisplayOnlyField_17.setLabel("Gender");
          _jspx_th_impact_validateDisplayOnlyField_17.setValue( FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersSex()) );
          int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     </tr>\r\n  <tr>\r\n       <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_18.setName("dspPersonSsn");
          _jspx_th_impact_validateDisplayOnlyField_18.setLabel("SSN");
          _jspx_th_impact_validateDisplayOnlyField_18.setValue( FormattingHelper.formatSSN(rowcint50doPrimary.getSzNbrIncmgPersIdNumber()) );
          int _jspx_eval_impact_validateDisplayOnlyField_18 = _jspx_th_impact_validateDisplayOnlyField_18.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_19.setName("dspLanguage");
          _jspx_th_impact_validateDisplayOnlyField_19.setLabel("Language");
          _jspx_th_impact_validateDisplayOnlyField_19.setValue( FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersLanguage()) );
          int _jspx_eval_impact_validateDisplayOnlyField_19 = _jspx_th_impact_validateDisplayOnlyField_19.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      </tr>\r\n  <tr>\r\n       <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_20.setName("dspEthnicity");
          _jspx_th_impact_validateDisplayOnlyField_20.setLabel("Ethnicity");
          _jspx_th_impact_validateDisplayOnlyField_20.setValue( FormattingHelper.formatString(rowcint51do.getSzCdIncmgPersEthnic()) );
          int _jspx_eval_impact_validateDisplayOnlyField_20 = _jspx_th_impact_validateDisplayOnlyField_20.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     </table>\r\n\r\n  <br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("PhoneExp");
          _jspx_th_impact_ExpandableSectionTag_0.setId("PhoneExp_id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Phone Detail");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <div id=\"phoneSubScrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableBorderList\">\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n  <th class=\"thList\">Primary</th>\r\n  <th class=\"thList\">Invalid</th>\r\n  <th class=\"thList\">Type</th>\r\n  <th class=\"thList\">Number</th>\r\n  <th class=\"thList\">Extension</th>\r\n  <th class=\"thList\">Start Date</th>\r\n  <th class=\"thList\">End Date</th>\r\n  </tr>\r\n");

  int i = -1;

  c = rowcint52do_Array.enumerateROWCINT52DO();

  if (c.hasMoreElements() == false)
  {

              out.write("\r\n  <tr>\r\n  <td colspan=\"7\" class=\"odd\">\r\n  ");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("\r\n  </td>\r\n  </tr>\r\n");

  }
  else
  {
    while (c.hasMoreElements())
    {
      ROWCINT52DO rowcint52do = (ROWCINT52DO) c.nextElement();

      i++;
      String trClass = "class=\"odd\"";
      if (i % 2 == 1)
      {
        trClass = "class=\"even\"";
      }
      String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img  alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
      String UNCHECKED = "&nbsp;";

              out.write("\r\n  <tr ");
              out.print( trClass );
              out.write(">\r\n  <td>");
              out.print( ArchitectureConstants.Y.equals(rowcint52do.getCIndIncmgPhonePrimary()) ? CHECKED : UNCHECKED );
              out.write("</td>\r\n  <td>");
              out.print( ArchitectureConstants.Y.equals(rowcint52do.getCIndIncmgPhoneInvalid()) ? CHECKED : UNCHECKED );
              out.write("</td>\r\n  <td>");
              out.print( Lookup.simpleDecodeSafe("CPHNTYP", rowcint52do.getSzCdIncmgPhoneType()) );
              out.write("</td>\r\n  <td>");
              out.print( FormattingHelper.formatPhone(rowcint52do.getSzNbrIncmgPhone()) );
              out.write("</td>\r\n  <td>");
              out.print( rowcint52do.getSzNbrIncmgPhoneExtension() );
              out.write("</td>\r\n  <td>");
              out.print( FormattingHelper.formatDate(rowcint52do.getDtDtIncmgPhoneStart()) );
              out.write("</td>\r\n  <td>");
              out.print( FormattingHelper.formatDate(rowcint52do.getDtDtIncmgPhoneEnd()) );
              out.write("</td>\r\n  </tr>\r\n");

       }
    }

              out.write("\r\n\r\n  </table>\r\n  </div>\r\n\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("NameHistory");
          _jspx_th_impact_ExpandableSectionTag_1.setId("nameHistoryItem_0");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Name History");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<div id=\"scrollBar\" style=\"height:165px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n<tr>\r\n <th class=\"thList\">Primary</th>\r\n <th class=\"thList\">Invalid</th>\r\n <th class=\"thList\">Name</th>\r\n <th class=\"thList\">Suffix</th>\r\n <th class=\"thList\">Start Date</th>\r\n <th class=\"thList\">End Date</th>\r\n</tr>\r\n\r\n");

  int i = -1;

  x = rowcint49do_Array.enumerateROWCINT49DO();

  if (x.hasMoreElements() == false)
  {

              out.write("\r\n  <tr>\r\n  <td colspan=\"7\" class=\"odd\">\r\n  ");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("\r\n  </td>\r\n  </tr>\r\n");

  }
  else
  {
    while (x.hasMoreElements())
    {
      ROWCINT49DO rowcint49do = (ROWCINT49DO) x.nextElement();

      i++;
      String trClass = "class=\"odd\"";
      if (i % 2 == 1)
      {
        trClass = "class=\"even\"";
      }
      String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img  alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
      String UNCHECKED = "&nbsp;";

              out.write("\r\n      </td>\r\n\r\n  ");


      String first = "";
      String middle = "";
      String last = "";
      if ( !"".equals(rowcint49do.getSzNmIncmgNameLast()) )
      {
        last = rowcint49do.getSzNmIncmgNameLast();
      }
      if ( !"".equals(rowcint49do.getSzNmIncmgNameFirst()) )
      {
        first = ", "+rowcint49do.getSzNmIncmgNameFirst();
      }
      if ( !"".equals(rowcint49do.getSzNmIncmgNameMiddle()) )
      {
        if ("".equals(first) )
        {
          middle = ", "+rowcint49do.getSzNmIncmgNameMiddle();
        }
        else
        {
          middle = " "+rowcint49do.getSzNmIncmgNameMiddle();
        }
      }

      String fullName = last + first + middle;
      String listItemId = "nameHistoryItem_" + loopCount; 
              out.write("\r\n<tr ");
              out.print( trClass );
              out.write(">\r\n      <td>");
              out.print( ArchitectureConstants.Y.equals(rowcint49do.getCIndIncmgNamePrimary()) ? CHECKED : UNCHECKED );
              out.write("</td>\r\n    <td>");
              out.print( ArchitectureConstants.Y.equals(rowcint49do.getCIndIncmgNameInvalid()) ? CHECKED : UNCHECKED );
              out.write("</td>\r\n      <td><id=\"");
              out.print( listItemId );
              out.write('"');
              out.write('>');
              out.print( fullName );
              out.write("\r\n      </td>\r\n      <td>");
              out.print( Lookup.simpleDecodeSafe( CodesTables.CSUFFIX, rowcint49do.getSzCdIncmgNameSuffix() ) );
              out.write("\r\n      </td>\r\n       <td>");
              out.print( FormattingHelper.formatDate( rowcint49do.getDtDtIncmgNameStart() ) );
              out.write("</td>\r\n      <td>");
              out.print( FormattingHelper.formatDate( rowcint49do.getDtDtIncmgNameEnd() ) );
              out.write("</td>\r\n      </tr>\r\n");

      loopCount++;
    } // end while enumeration has more elements
  } //end big else


              out.write("\r\n  </table>\r\n</div>\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("personIdentifiersSubmodule");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Person Identifiers");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex);
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n   <div id=\"personIdentifiersScrollBar\" style=\"height:100%; width:100%; overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n      <tr>\r\n        <th class=\"thList\">Invalid</th>\r\n        <th class=\"thList\">Type</th>\r\n        <th class=\"thList\">Number</th>\r\n        <th class=\"thList\">Start</th>\r\n        <th class=\"thList\">&nbsp;</th>\r\n        </tr>\r\n      ");

  int i = -1;

  b = rowcint50do_Array.enumerateROWCINT50DO();

  if (b.hasMoreElements() == false)
  {

              out.write("\r\n  <tr>\r\n  <td colspan=\"6\" class=\"odd\">\r\n  ");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("\r\n  </td>\r\n  </tr>\r\n");

  }
  else
  {
    while (b.hasMoreElements())
    {
      ROWCINT50DO rowcint50do = (ROWCINT50DO) b.nextElement();

      i++;
      String trClass = "class=\"odd\"";
      if (i % 2 == 1)
      {
        trClass = "class=\"even\"";
      }
      String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
      String UNCHECKED = "&nbsp;";
      String numberType = rowcint50do.getSzCdIncmgPersIdType();
   
              out.write("\r\n           <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\">\r\n             <td align=\"center\">\r\n               ");
              out.print( rowcint50do.getCIndIncmgPersonIDInv().equals( ServiceConstants.FND_YES ) ? CHECKED : UNCHECKED );
              out.write("\r\n             </td>\r\n             <td>\r\n                     ");
              out.print(rowcint50do.getUlIdIncmgPersonId());
              out.write("\r\n                     ");
              out.print(FormattingHelper.formatString( numberType ));
              out.write("\r\n             </td>\r\n             <td>\r\n               ");

                 if( numberType.equals( CodesTables.CNUMTYPE_SSN ) )
                 {
                   out.print(FormattingHelper.formatSSN(rowcint50do.getSzNbrIncmgPersIdNumber()));
                 }
                 else
                 {
                   out.print(FormattingHelper.formatString(rowcint50do.getSzNbrIncmgPersIdNumber()));
                 }
               
              out.write("\r\n             </td>\r\n             <td>\r\n               ");
              out.print(FormattingHelper.formatDate( rowcint50do.getDtDtIncmgPersIdStart() ));
              out.write("\r\n             </td>\r\n              <td>\r\n               ");
              out.print(FormattingHelper.formatString( rowcint50do.getSzDescIncmgPersonID() ));
              out.write("\r\n             </td>\r\n           </tr>\r\n           ");

           loopCount++;
         }
       }
      
              out.write("\r\n      </td>\r\n    </table>\r\n    </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("AddressList");
          _jspx_th_impact_ExpandableSectionTag_3.setId("lbAddressList_Id");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Address Detail");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<div id=\"idAddressListScrollBar\" style=\"height:165px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n      <tr>\r\n      <th class=\"thList\">Primary</th>\r\n      <th class=\"thList\">Invalid</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Street</th>\r\n      <th class=\"thList\">City</th>\r\n      <th class=\"thList\">State</th>\r\n      <th class=\"thList\">Start Date</th>\r\n      <th class=\"thList\">End Date</th>\r\n      <th class=\"thList\">Comments</th>\r\n      </tr>\r\n ");

   int i = -1;

     e = rowcint48do_Array.enumerateROWCINT48DO();

     if (e.hasMoreElements() == false)
     {
   
              out.write("\r\n     <tr>\r\n     <td colspan=\"7\" class=\"odd\">\r\n     ");
              out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("\r\n     </td>\r\n     </tr>\r\n   ");

     }
     else
     {
       while (e.hasMoreElements())
       {
         ROWCINT48DO rowcint48do = (ROWCINT48DO) e.nextElement();

         i++;
         String trClass = "class=\"odd\"";
         if (i % 2 == 1)
         {
           trClass = "class=\"even\"";
         }
         String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
         String UNCHECKED = "&nbsp;";
   
              out.write("\r\n     <tr ");
              out.print( trClass );
              out.write(">\r\n     <td>");
              out.print( ArchitectureConstants.Y.equals(rowcint48do.getCIndIncmgAddrPrimary()) ? CHECKED : UNCHECKED );
              out.write("</td>\r\n  <td>");
              out.print( ArchitectureConstants.Y.equals(rowcint48do.getCIndIncmgAddrInvalid()) ? CHECKED : UNCHECKED );
              out.write("</td>\r\n          <td>");
              out.print(Lookup.simpleDecodeSafe("CADDRTYP", rowcint48do.getSzCdIncmgAddrType()));
              out.write("\r\n          <td>");
              out.print(rowcint48do.getSzAddrIncmgAddrStLn1());
              out.write("\r\n          <td>");
              out.print(rowcint48do.getSzAddrIncmgAddrCity());
              out.write("\r\n          <td>");
              out.print(rowcint48do.getSzCdIncmgAddrState());
              out.write("\r\n          <td>");
              out.print(FormattingHelper.formatDate(rowcint48do.getDtDtIncmgAddrStart()));
              out.write("\r\n          <td>");
              out.print(FormattingHelper.formatDate(rowcint48do.getDtDtIncmgAddrEnd()));
              out.write("\r\n          <td align=\"center\">");
if( rowcint48do.getSzTxtIncmgAddrComments() != null && !"".equals(
             rowcint48do.getSzTxtIncmgAddrComments()) ){
              out.write("<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >");
}
              out.write("</td>\r\n          </tr>\r\n  ");


        } // end for
      }// end if addressArray.getROWCCMN42SOG00Count() == 0

  
              out.write("\r\n\r\n  </table>\r\n</div>\r\n\r\n ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_else_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:else
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
    _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
    int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
    if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n   &nbsp;\r\n  ");
        int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
