package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class LevelOfCare_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  //Get a Collection of LOCs from a StringTokenizer of comma separated values
  public static Collection getCollection( StringTokenizer statuses )
  {
    String token = null;
    Collection statusCollection = new ArrayList();

    while(statuses.hasMoreTokens())
    {
      token = statuses.nextToken();
      statusCollection.add( token );
    }
    return statusCollection;
  }

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


/**
 * JSP Name:     LevelOfCare.jsp
 * Created by:   cawthocw
 * Date Created: 07/26/02
 *
 * Description:
 * This page allows a user to view and edit the Level of Care information for
 * a Placement.
 *
 *
 *   Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 *  08/11/03  Todd Reser        Added/modified flowerbox comments and Changelog.
 *  06/10/03  lauramc           sir 17765 remove This action might generate a billing adjustment... message
*   12/01/03  corleyan          LOC Enhancement - If the effective date gotten from request (passed from
*                               either AddLevelOfCare or Facility Detail) is
*                               greater than 08/31/2003 use new codes to display the LOC to the user.
*   09/19/05  berkime           SIR 23890 - changed the wording from level of care to
*                               service level.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );



  //get the page mode from the request
  String pageMode = PageMode.getPageMode(request);
  String facilityName = GlobalData.getSzNmResource( request );
  String facilityNumber = request.getParameter("txtLNbrRsrcFacilAcclaim");
  String contact = request.getParameter("txtNmRsrcContact");
  String resourceType = request.getParameter("cboCdRsrcType");
  String facilityType = request.getParameter("cboCdRsrcFacilType");

  //get the parameters from the request
  String effectiveDateS = request.getParameter("effectiveDate");
  org.exolab.castor.types.Date effectiveDate = DateHelper.toCastorDateSafe(effectiveDateS);
  org.exolab.castor.types.Date changeDate = DateHelper.toCastorDateSafe("09/01/2003");
  String endDate = request.getParameter("endDate");
  String activeLOC = request.getParameter("activeLOC");
  String holdLOC = request.getParameter("holdLOC");
  String rownum = request.getParameter("rownum");
  String ulIDResource = GlobalData.getUlIdResourceAsString( request );

  //create collection of the active and hold Levels of Care
  // This collection is generated from a hidden field value from
  // facility detail.
  Collection actives = new ArrayList();
  Collection holds = new ArrayList();
  if(activeLOC != null)
  {
    StringTokenizer activeString = new StringTokenizer(activeLOC);
    actives = getCollection(activeString );
  }
  if(holdLOC != null){
    StringTokenizer holdString = new StringTokenizer(holdLOC);
    holds = getCollection(holdString);
  }


  int tabIndex = 1;

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n<!--Insert Java Script here\r\n\r\nfunction setDirty()\r\n{\r\n  IsDirty();\r\n}\r\n\r\nwindow.attachEvent('onbeforeunload', setDirty );\r\n\r\n\r\n//End Java Script-->\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmLOC");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/Facility/saveLOC");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("rownum");
          _jspx_th_impact_validateInput_1.setValue(rownum);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("txtLNbrRsrcFacilAcclaim");
          _jspx_th_impact_validateInput_2.setValue(facilityNumber);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("txtNmRsrcContact");
          _jspx_th_impact_validateInput_3.setValue(contact);
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
          _jspx_th_impact_validateInput_4.setName("cboCdRsrcType");
          _jspx_th_impact_validateInput_4.setValue(resourceType);
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
          _jspx_th_impact_validateInput_5.setName("cboCdRsrcFacilType");
          _jspx_th_impact_validateInput_5.setValue(facilityType);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
//SIR 23890  changed wording from level of care to service level 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"5\">Room, Board, and Watchful Oversight Detail</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n        <!-- LOC Enhancement - Use impact display only fields for the values of these fields so that on\r\n             Save they can be read in the conversation -->\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("rdatReceiveDate");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Effective Date");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatDate(effectiveDate));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td >\r\n    <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("endDate");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("End Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatString(endDate));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td  width=\"25%\">\r\n    <td width=\"50%\"></td>\r\n   </tr>\r\n  <tr>\r\n   <td  colspan=\"5\">\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorderList\">\r\n     <tr>\r\n    <th class=\"thList\">Levels: </th>\r\n    <th class=\"thList\">Active </th>\r\n    <th class=\"thList\">Hold </th>\r\n    <th class=\"thList\">N/A </th>\r\n  </tr>\r\n\r\n");

  Collection collection = null;
  // If the effective date is before the change date, use the old codes table to determine decodes to
  // be displayed.  Otherwise generate a static list of decodes to be displayed from the new codes table
  // The statis list is used b/c of program's need for the decodes to be displayed in a certain order.
//  if ( DateHelper.isBefore(  effectiveDate ,   changeDate ) && !DateHelper.NULL_CASTOR_DATE.equals(effectiveDate) )
// {
// Old Codes were updated with new data. so we dont have to use condition here.
  collection = Lookup.getCategoryCollection("CLVOFCRE");
// }
// else
// {
//  List list = new ArrayList(7);
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_210));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_220));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_230));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_240));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_090));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_100));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_110));
//  collection = list;
// }
  List clvofcre = (List)collection;

   CodeAttributes attribute = null;
   Iterator lvls = collection.iterator();

   if( lvls.hasNext() )
   {
     while(lvls.hasNext())
     {
       attribute = (CodeAttributes) lvls.next();

          out.write("\r\n    <tr>\r\n      <td align=\"center\">");
          out.print(attribute.getDecode());
          out.write("</td>\r\n      ");

        String disabled = "false";
        String radioName = "radio" + attribute.getDecode();
        String decode = attribute.getDecode();
        String active = "";
        String hold = "";
        String na = "";
        //get the active, hold and N/A levels of care
        if( !pageMode.equals(PageModeConstants.NEW) )
        {
          if(actives.contains(decode))
          {
            active = "true";
            disabled = "true";
          }else if(holds.contains(decode))
          {
            hold = "true";
            disabled = "true";
          }else
          {
            na = "true";
          }
        }else
        {
          na = "true";
        }
      
          out.write("\r\n      <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setName(radioName);
          _jspx_th_impact_validateInput_6.setChecked(active);
          _jspx_th_impact_validateInput_6.setValue("A");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setName(radioName);
          _jspx_th_impact_validateInput_7.setChecked(hold);
          _jspx_th_impact_validateInput_7.setValue("H");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setName(radioName);
          _jspx_th_impact_validateInput_8.setChecked(na);
          _jspx_th_impact_validateInput_8.setDisabled(disabled);
          _jspx_th_impact_validateInput_8.setValue("NA");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    </tr>\r\n");

      } //end for loop for caretakerArray
   }
   else
   {

          out.write("         <tr>\r\n          <td>\r\n              ");
          out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
          out.write("\r\n           </td>\r\n         </tr>\r\n");
 }

          out.write("\r\n   </table>\r\n   </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n <tr>\r\n  <td align=\"right\">\r\n     ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSaveLOC");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmLOC");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/Facility/saveLOC");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n </tr>\r\n</table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
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
