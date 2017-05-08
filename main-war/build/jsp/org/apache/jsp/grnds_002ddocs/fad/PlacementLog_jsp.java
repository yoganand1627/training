package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementLogSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.fad.PlacementLogConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats;

public final class PlacementLog_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**  JSP Name:     PlacementLog
  *  Created by:   katy Laura
  *  Date Created: 02/20/03
  *
  *  Description:
  *  This JSP displays the placement history of a facility.
  *  The page displays using multiple sort values.  The initial sort shows current placements
  *  ( those having  open end dates  ) ordered by most recent start date ( start dates in descending
  *  order ); followed by past placements ( those having non null, non 12/31/4712 end dates ) in
  *  descending order ( most recent placement);
  *  Additional sort fields are name, start date ( most recent first ), end date ( most recent first ),
  *  and removal reason.
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------    --------------------------------------------------
  *  6/29/04    gerryc            SIR 19651 - added column for a check mark to
  *                               indicate if the person's most recent legal status
  *                               is adoption consummated.  Also changed the results
  *                               to show 100 per page instead of 10.
  *  7/14/08	wjcochran         STGAP00009512 - Removed the column that indicates if
  *                               the person's most recent legal status is 
  *                               adoption consumated.
  *  4/08/09    wjcochran         STGAP00012984 - Added a null check on the CurrPlacementStats
  *                               object to prevent a NullPointerException
  *  11/12/09   pcoogan           ECEM: Moved pagination outside of div for better form factor
                                  and expanded width of div for better look and feel
     09/12/11   charden           STGAP00017058 - added code to display characteristics grouping section
  */


      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //HttpServletRequest request = context.getRequest();
  //Set the page mode
  //String pageMode =  (String) request.getAttribute("pageMode" );//PageModeConstants.VIEW;
   String pageMode = PageMode.getPageMode(request);

     // create the output object
    CFAD31SO cfad31so = ( CFAD31SO ) request.getAttribute( "CFAD31SO" );
    PlacementLogSO placementLogSO = (PlacementLogSO) request.getAttribute("placementLogSO");

     //initialize the array
    CFAD31SOG00_ARRAY placementLogArray = null;
     //null catch
    if ( cfad31so == null )
    {
      cfad31so = new CFAD31SO() ;
    }
     //null catch for row objects, if not null, get rows
    if ( cfad31so.getCFAD31SOG00_ARRAY() != null )
    {
      placementLogArray = cfad31so.getCFAD31SOG00_ARRAY();
    }  else
    {
      placementLogArray = new CFAD31SOG00_ARRAY();
    }

  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  // used to hide the reports section if no results returned
  boolean bResults = true;
  UserProfile user = UserProfileHelper.getUserProfile ( request );
  
  // get objects for child characteristics
  int delinquency = placementLogSO.getNumChildrenDelinquent();
  int numChildren = placementLogSO.getNumChildrenInHome();
  List<String> characteristicGroupList = placementLogSO.getCharacteristicGroupList();
  Map<String, Map<String, Integer>> characteristicsGroupMap = placementLogSO.getCharacteristicsGroupMap();

      out.write("\r\n<script language=\"JavaScript\">\r\nfunction displayPersonDetail( idPerson )\r\n{\r\n  document.frmPlacementLog.hdnUlIdPerson.value = idPerson;\r\n  disableValidation('frmPlacementLog');\r\n  submitValidateForm( \"frmPlacementLog\", \"/person/PersonSearch/displayPersonDetail\" );\r\n}\r\n</script>\r\n\r\n  ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n  ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPlacementLog");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fad/PlacementLog/displayPlacementLog");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
 // begin pagination

  TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean) request.getAttribute(
          PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

  if (tuxPagination != null) {
    DatabaseResultDetails db = tuxPagination.getResultDetails();
  } else {
    tuxPagination = new TuxedoPaginationValueBean();
    DatabaseResultDetails db = new DatabaseResultDetails();
    db.setNumberOfResults(0);
    db.setResultsPerPage(100); //SIR 19651 changed from 10 to 100
    db.setRequestedPage(1);
    tuxPagination.setResultDetails(db);
    request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
  }
  CurrPlacementStats currPlacementStats = cfad31so.getCurrPlacementStats();
  if (currPlacementStats == null) {
  	currPlacementStats = new CurrPlacementStats();
  }
  String cldrnUnderAge3 = String.valueOf(currPlacementStats.getNbrChldrnUnder3());
  String cldrnOverAge16 = String.valueOf(currPlacementStats.getNbrChldrnOver16());
  String malesInHome = String.valueOf(currPlacementStats.getNbrMalesInHome());
  String femalesInHome = String.valueOf(currPlacementStats.getNbrFemalesInHome());
  String cldrnRecvingLocFund = String.valueOf(currPlacementStats.getNbrChldrnWithLOCFllng());

          out.write("\r\n\r\n");

//SIR 19651 - set url based on if it is in resource or search context.  This
//will allow for the correct screen definitions to be loaded.  Case context
//should show Case Name, Resource context should show Resource Name
String submitUrl = "";
if (GlobalData.getSzNmCase(request) != null && !"".equals(GlobalData.getSzNmCase(request).trim()) )
{
  submitUrl="/fad/PlacementLog/displayPlacementLog";
}
else
{
  submitUrl="/resource/PlacementLog/displayPlacementLog";
}


          out.write("\r\n<input type=\"hidden\" name=\"hdnUlIdPerson\" value=\"\" />\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n  <tr>\r\n    <th colspan=\"4\">Current Placement Statistics</th>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formLabel\" height=\"25\">Children Under Age 3: ");
          out.print(cldrnUnderAge3);
          out.write("</td>\r\n    <td class=\"formLabel\" height=\"25\">Children Over Age 16: ");
          out.print(cldrnOverAge16);
          out.write("</td>\r\n  </tr>\r\n  \r\n  <tr>\r\n    <td class=\"formLabel\" height=\"25\"># Males In Home: ");
          out.print(malesInHome);
          out.write("</td>\r\n    <td class=\"formLabel\" height=\"25\"># Females In Home: ");
          out.print(femalesInHome);
          out.write("</td>\r\n  </tr>\r\n  \r\n");
          out.write("\r\n</table> \r\n<br>\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl(submitUrl);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div class=\"alignRight\">\r\n  <div class=\"formInstruct\">Scroll for more information --></div>\r\n</div>\r\n<div id=\"scrollBar2\" style=\"height:210px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n\r\n\r\n       ");
              out.write("\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"150%\" >\r\n         <tr>\r\n             <th class=\"thList\">Person</th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\">Case</th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\">Placement</th>\r\n             <th class=\"thList\">End</th>\r\n             <th class=\"thList\">Removal</th>\r\n             <th class=\"thList\">Placement</th>\r\n             <th class=\"thList\">Sibling</th>\r\n             <th class=\"thList\">Legal</th>\r\n             <th class=\"thList\">RBWO</th>\r\n             <th class=\"thList\">RBWO</th>\r\n             <th class=\"thList\">Waiver</th>\r\n         </tr>\r\n         <tr>\r\n            <th class=\"thList\">ID</th>\r\n             <th class=\"thList\">Name&nbsp;\r\n              ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy( PlacementLogConversation.SORT_C );
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\">ID</th>\r\n             <th class=\"thList\">Gender</th>\r\n             <th class=\"thList\">DOB</th>\r\n             <th class=\"thList\">Age</th>\r\n             <th class=\"thList\">Date&nbsp;\r\n              ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy( PlacementLogConversation.SORT_P );
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\">Date&nbsp;\r\n              ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy( PlacementLogConversation.SORT_E );
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\">Rsn.&nbsp;\r\n              ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_3.setOrderBy( PlacementLogConversation.SORT_R );
              int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\">Type</th>\r\n             <th class=\"thList\">Placmnt.</th>\r\n             <th class=\"thList\">County</th>\r\n             <th class=\"thList\">Program</th>\r\n             <th class=\"thList\">Rate</th>\r\n             <th class=\"thList\">Rate</th>\r\n         </tr> \r\n              \r\n                  ");
 // within the table, display the data
                    //Enumerate the placement rows
              Enumeration placementLogEnum = placementLogArray.enumerateCFAD31SOG00();


            //If the enumeration is empty return NO Rows returned message
          if ( !placementLogEnum.hasMoreElements() )
             {
             bResults = false;

              out.write("\r\n              <tr class=\"odd\">\r\n                 <td colspan=\"7\">\r\n                  ");
              out.print(  MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("\r\n                 </td>\r\n              </tr>\r\n               ");

             }  // else there is a least one row.  While there are more rows, create a new rows and display the data
          else
             {
               while( placementLogEnum.hasMoreElements() )
                  {     // get the next element
                     CFAD31SOG00 placementRow = ( CFAD31SOG00 ) placementLogEnum.nextElement();
                        // create the cells and place the elements in them
                 
              out.write("\r\n         <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"center\">\r\n             <td>\r\n                ");
              out.print( FormattingHelper.formatLong( placementRow.getUlIdPerson() ));
              out.write("\r\n                </td>\r\n                <td><a href=\"javascript:displayPersonDetail('");
              out.print(FormattingHelper.formatString(String.valueOf(placementRow.getUlIdPerson())));
              out.write("');\">\r\n                                                            ");
              out.print(FormattingHelper.formatString(placementRow.getSzNmPersonFull()));
              out.write("</a></td>\r\n                \r\n                \r\n             ");
              out.write("\r\n                \r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatLong( placementRow.getUlIdCase()));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString( placementRow.getCdPersonSex()));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatDate( placementRow.getDtDtPersonBirth() ));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatLong( placementRow.getNbrPersonAge() ));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatDate( placementRow.getDtDtPlcmtStart() ));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatDate( placementRow.getDtDtPlcmtEnd() ));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CRMRSNAC", placementRow.getSzCdPlcmtRemovalRsn() ) ));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString( 
                	  Lookup.simpleDecodeSafe("CPLMNTYP",placementRow.getCdPlcmtType())));
              out.write("\r\n                </td>\r\n               \r\n                <td align=\"center\">\r\n                  ");
if("Y".equalsIgnoreCase(placementRow.getSzSblngPlcmt()) ){
              out.write("\r\n                    <!-- <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >  -->\r\n                    <FONT size=\"3\"><B>Y</B></FONT>\r\n                  ");
}else{
              out.write("\r\n                    &nbsp;\r\n                  ");
}
              out.write("\r\n                </td>\r\n                \r\n                ");
              out.write("\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CCOUNT", placementRow.getCdLegalStatCnty() ) ));
              out.write("\r\n                </td>\r\n                \r\n                ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_0.setTest( ("Y".equals(placementRow.getSzIndCci())||"N".equals(placementRow.getSzIndCci())));
              int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
              if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                <td>\r\n                ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
                  _jspx_th_impact_ifThen_1.setTest( ("Y".equals(placementRow.getSzIndCci())));
                  int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
                  if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                ");
                      out.print( FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CRBPROGI", placementRow.getSzCdRbwoProg() ) ));
                      out.write("\r\n                ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
                  _jspx_th_impact_ifThen_2.setTest( ("N".equals(placementRow.getSzIndCci())));
                  int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
                  if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                ");
                      out.print( FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CRBPROGA", placementRow.getSzCdRbwoProg() ) ));
                      out.write("\r\n                ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                </td>\r\n                 <td>\r\n                ");
                  out.print( FormattingHelper.formatMoney(placementRow.getDPerDiem()));
                  out.write("\r\n                </td>\r\n                 <td>\r\n                ");
                  out.print( FormattingHelper.formatMoney(placementRow.getDWaiverRate()));
                  out.write("\r\n                </td>\r\n                ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_3.setTest( ("".equals(placementRow.getSzIndCci())||placementRow.getSzIndCci()==null));
              int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
              if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                <td>\r\n                &nbsp;\r\n                </td>\r\n                 <td>\r\n                &nbsp;\r\n                </td>\r\n                 <td>\r\n                &nbsp;\r\n                </td>\r\n                ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </tr>\r\n         ");
// increment the loop counter
               loopCount++;
             } // end while
           } //end else, end if
          
              out.write("\r\n\r\n        </table>\r\n   \r\n </div>\r\n ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         ");
          out.write("\r\n<br/>\r\n\r\n <!-- STGAP00017058 - creating characteristics grouping section -->\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n  <tr>\r\n    <th colspan=\"4\">Child Characteristics Currently in the Home</th>\r\n  </tr>\r\n  ");
 
  if(delinquency != 0){
  
          out.write("\r\n    <tr>\r\n    \t<td>&nbsp;&nbsp;&nbsp;&nbsp;History of Juvenile Delinquency&nbsp;(");
          out.print( delinquency );
          out.write(")</td>\r\n    </tr>\r\n  ");
 
  }
  
  // write out message if there are no characteristics in the home
  if(numChildren > 0 && characteristicGroupList.isEmpty() && delinquency == 0){
  
          out.write("\r\n  \t<tr>\r\n  \t\t<td>There are no characteristics exhibited by the children currently placed in the home.</td>\r\n  \t</tr>\r\n  ");

  }
  
  // sort and write out categories
  if(characteristicGroupList != null){
  	Collections.sort(characteristicGroupList);
  }
  for(String category : characteristicGroupList){
  	Map<String, Integer> characteristicsMap = characteristicsGroupMap.get(category);
  
          out.write("\r\n  \t<tr>\r\n  \t\t<th colspan=\"4\" style=\"border-top: solid #c8c699 1px;\">&nbsp;&nbsp;&nbsp;");
          out.print( Lookup.simpleDecodeSafe("CCHRTCA1", category) );
          out.write("</th>\r\n  \t</tr>\r\n  ");
 
    // write out characteristics
    int i = 0;
    List<String> charList = new ArrayList<String>();
    Set<String> charSet = characteristicsMap.keySet() != null ? characteristicsMap.keySet() : new HashSet<String>();
    charList.addAll(charSet);
    Collections.sort(charList);
    for(String characteristic : charList){
    	if(i % 2 == 0){
  
          out.write("\r\n  \t\t\t<tr><td width=\"50%\" align=\"left\">");
          out.print( characteristic );
          out.write("&nbsp;(");
          out.print( characteristicsMap.get(characteristic) );
          out.write(")</td>\r\n  ");
 
  		}else{
  
          out.write("\r\n  \t\t\t<td width=\"50%\" align=\"left\">");
          out.print( characteristic );
          out.write("&nbsp;(");
          out.print( characteristicsMap.get(characteristic) );
          out.write(")</td></tr>\r\n  ");

  		}
  		i++;
  	}
  	
  	// close row if number of items in cateogry is an odd number
  	if(i % 2 != 0){
  
          out.write("\r\n \t\t\t</tr>\r\n  ");

  	}
  }
  
          out.write("\r\n </table>\r\n <!-- End STGAP00017058 -->\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("ulIdResource");
          _jspx_th_impact_validateInput_0.setValue( ContextHelper.getStringSafe( request, "ulIdResource" ));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("ulIdStage");
          _jspx_th_impact_validateInput_1.setValue( String.valueOf( GlobalData.getUlIdStage( request) ));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n\r\n\r\n");
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
