package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
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
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.PortalChildListConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats;

public final class PortalChildList_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**  JSP Name:     PortalChildList
  *  Created by:   Patrick Coogan
  *  Date Created: October 2009
  *
  *  Description:
  *  This JSP displays the Portal Child List for users logged into the SHINES Vendor 
  *  Portal implemented as a part of ECEM initiatives.  It will show all children in 
  *  all resources to which a user is assigned, or depending on the mode will show only
  *  children for a specific resource.
  *  This page is based off of the Placement Log page in SHINES.
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  11/12/09    Patrick Coogan    Updated comments for ECEM implementation. 
  */


      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //HttpServletRequest request = context.getRequest();
  //Set the page mode
  //String pageMode =  (String) request.getAttribute("pageMode" );//PageModeConstants.VIEW;
   String pageMode = PageMode.getPageMode(request);

     // create the output object
    CFAD31SO cfad31so = ( CFAD31SO ) request.getAttribute( "CFAD31SO" );
  
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

      out.write("\r\n<script language=\"JavaScript\">\r\nfunction displayPortalPersonDetail( idPerson, idStage, idCase, idPlcmtEvent )\r\n{\r\n  document.frmPortalChildList.hdnUlIdPerson.value = idPerson;\r\n  document.frmPortalChildList.hdnUlIdStage.value = idStage;\r\n  document.frmPortalChildList.hdnUlIdCase.value = idCase;\r\n  document.frmPortalChildList.hdnUlIdPlcmtEvent.value = idPlcmtEvent;\r\n  disableValidation('frmPortalChildList');\r\n  submitValidateForm( \"frmPortalChildList\", \"/person/PortalChildDetail/displayPortalChildDetail\" );\r\n}\r\n</script>\r\n\r\n  ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n  ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPortalChildList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/PortalChildList/displayChildList");
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

String submitUrl = "";

if (!("".equals(GlobalData.getUlIdParentRsrcAsString(request)))&&!("0".equals(GlobalData.getUlIdParentRsrcAsString(request)))){
submitUrl="/workload/PortalChildList/displayChildList";
} else {
submitUrl= "/workload/PortalChildList/displayChildListAll";
}

          out.write("\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest( (!("".equals(GlobalData.getUlIdParentRsrcAsString(request))||"0".equals(GlobalData.getUlIdParentRsrcAsString(request)))));
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n  <tr>\r\n    <th colspan=\"4\">Current Placement Statistics</th>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formLabel\" height=\"25\">Children Under Age 3: ");
              out.print(cldrnUnderAge3);
              out.write("</td>\r\n    <td class=\"formLabel\" height=\"25\">Children Over Age 16: ");
              out.print(cldrnOverAge16);
              out.write("</td>\r\n  </tr>\r\n  \r\n  <tr>\r\n    <td class=\"formLabel\" height=\"25\"># Males In Home: ");
              out.print(malesInHome);
              out.write("</td>\r\n    <td class=\"formLabel\" height=\"25\"># Females In Home: ");
              out.print(femalesInHome);
              out.write("</td>\r\n  </tr>\r\n \r\n</table> \r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl(submitUrl);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div class=\"alignRight\">\r\n  <div class=\"formInstruct\">Scroll for more information --></div>\r\n</div>\r\n<div id=\"scrollBar2\" style=\"height:300px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n\r\n\r\n       ");
              out.write("\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width = \"200%\">\r\n         <tr>\r\n             <th class=\"thList\">Person</th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\">Case</th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\">Resource</th>\r\n             <th class=\"thList\">Resource</th>\r\n             <th class=\"thList\">Placement</th>\r\n             <th class=\"thList\">End</th>\r\n             <th class=\"thList\">Removal</th>\r\n             <th class=\"thList\">Placement</th>\r\n             <th class=\"thList\">Sibling</th>\r\n             <th class=\"thList\">Legal</th>\r\n             <th class=\"thList\">RBWO</th>\r\n             <th class=\"thList\">RBWO</th>\r\n             <th class=\"thList\">Waiver</th>\r\n         </tr>\r\n         <tr>\r\n            <th class=\"thList\">ID</th>\r\n             <th class=\"thList\">Name&nbsp;\r\n              ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy( PortalChildListConversation.SORT_C );
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\">ID</th>\r\n             <th class=\"thList\">Gender</th>\r\n             <th class=\"thList\">DOB</th>\r\n             <th class=\"thList\">Age</th>\r\n             <th class=\"thList\">Name</th>\r\n             <th class=\"thList\">ID</th>\r\n             <th class=\"thList\">Date&nbsp;\r\n              ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy( PortalChildListConversation.SORT_P );
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\">Date&nbsp;\r\n              ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy( PortalChildListConversation.SORT_E );
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\">Rsn.&nbsp;\r\n              ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_3.setOrderBy( PortalChildListConversation.SORT_R );
              int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\">Type</th>\r\n             <th class=\"thList\">Placmnt.</th>\r\n             <th class=\"thList\">County</th>\r\n             <th class=\"thList\">Program</th>\r\n             <th class=\"thList\">Per Diem</th>\r\n             <th class=\"thList\">Rate</th>\r\n         </tr> \r\n              \r\n                  ");
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
              out.write("\r\n                </td>\r\n                <td><a href=\"javascript:displayPortalPersonDetail('");
              out.print(FormattingHelper.formatString(String.valueOf(placementRow.getUlIdPerson())));
              out.write('\'');
              out.write(',');
              out.write('\'');
              out.print(FormattingHelper.formatString(String.valueOf(placementRow.getUlIdStage())));
              out.write('\'');
              out.write(',');
              out.write('\'');
              out.print(FormattingHelper.formatString(String.valueOf(placementRow.getUlIdCase())));
              out.write('\'');
              out.write(',');
              out.write('\'');
              out.print(FormattingHelper.formatString(String.valueOf(placementRow.getUlIdPlcmtEvent())));
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
              out.print( FormattingHelper.formatString( placementRow.getNmPlcmtFacil() ));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatLong( placementRow.getUlIdRsrcFacil() ));
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
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_1.setTest( ("Y".equals(placementRow.getSzIndCci())||"N".equals(placementRow.getSzIndCci())));
              int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
              if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                <td>\r\n                ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
                  _jspx_th_impact_ifThen_2.setTest( ("Y".equals(placementRow.getSzIndCci())));
                  int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
                  if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                ");
                      out.print( FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CRBPROGI", placementRow.getSzCdRbwoProg() ) ));
                      out.write("\r\n                ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
                  _jspx_th_impact_ifThen_3.setTest( ("N".equals(placementRow.getSzIndCci())));
                  int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
                  if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                ");
                      out.print( FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CRBPROGA", placementRow.getSzCdRbwoProg() ) ));
                      out.write("\r\n                ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                </td>\r\n                 <td>\r\n                ");
                  out.print( FormattingHelper.formatMoney(placementRow.getDPerDiem()));
                  out.write("\r\n                </td>\r\n                 <td>\r\n                ");
                  out.print( FormattingHelper.formatMoney(placementRow.getDWaiverRate()));
                  out.write("\r\n                </td>\r\n                ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_4.setTest( ("".equals(placementRow.getSzIndCci())||placementRow.getSzIndCci()==null));
              int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
              if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                <td>\r\n                &nbsp;\r\n                </td>\r\n                 <td>\r\n                &nbsp;\r\n                </td>\r\n                 <td>\r\n                &nbsp;\r\n                </td>\r\n                ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </tr>\r\n         ");
// increment the loop counter
               loopCount++;
             } // end while
           } //end else, end if
          
              out.write("\r\n\r\n        </table>\r\n    </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n         ");
          out.write("\r\n<br/>\r\n\r\n     ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnUlIdCase");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnUlIdStage");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnUlIdPerson");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnUlIdPlcmtEvent");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
