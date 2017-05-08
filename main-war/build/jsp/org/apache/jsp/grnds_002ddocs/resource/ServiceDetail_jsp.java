package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;

public final class ServiceDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**
 * JSP Name:     ServiceDetail.jsp
 * Created by:   Donald Wilson
 * Date Created: 09/27/02
 *
 * Description:
 * This page allows a user to modif the Services by area information.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  09/05/03  dejuanr           SIR REG059 - Service detailhad it own populate
                              call the main impact one.
  08/04/05  reedlg            SIR 23741 - add new service category

  01/20/07  aodutayo        Change GA references to GA.Disbaled Program as indicated
              in design document.This value sDisabledIncomeAndProgram determined
              if the Program is disbaled.
  4/4/08	cjgerry			  STGAP00007358 - added 582 to the service arrays
  3/23/09   pcoogan           STGAP00013039 - added 515,617,618 to the service arrays
  11/10/09  vdevarak		  SMS #39513 - Added 619 and 620 to the service arrays
  09/19/11  htvo              STGAP00017019:ECEM 5.0: modified to forward action for Financial service 
                              to the new screen; removed unused code and exclude All Regions option 
                              which is only for Financial service.
  04/11/12  vcollooru 		  STGAP00018067: Modified to remove the codeArray tag referring to regions 16 and 17
  
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');
      gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00 rowcres05sog00 = null;
      synchronized (request) {
        rowcres05sog00 = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00) _jspx_page_context.getAttribute("rowcres05sog00", PageContext.REQUEST_SCOPE);
        if (rowcres05sog00 == null){
          rowcres05sog00 = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00();
          _jspx_page_context.setAttribute("rowcres05sog00", rowcres05sog00, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

//  BaseSessionStateManager state = (BaseSessionStateManager)
//    request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  String ulIdResourceService = "";
  String szCdRsrcSvcCategRsrc = "";
  String szCdRsrcSvcService = "";
  String szCdRsrcSvcState = "GA";
  String szCdRsrcSvcProgram = "";
  String szCdRsrcSvcRegion = "";
  String szScrRsrcSvcCntyCode = "";
  String checkedBIndRsrcSvcCntyPartial = "false";
  String checkedCIndRsrcSvcIncomeBsed = "false";
  String szCdRsrcServiceType = "";

  boolean bInActiveContract = false;
  boolean bIsRegionWide = false;
  String sDisabledIncomeAndProgram = "true";
  String sDisabledPartialCounties = "true";
  String sDisabledCounties        = "true";
  String sDisabledOtherFields     = "true";
  String sDisableProgramOnly = "true";
  boolean generalBoolean = true;
  boolean financialBoolean = false;

  List excludeOutOfStateOption = new ArrayList();

  //If service row object is not null, set variables
  //G  ets used in Modify Mode
  if( rowcres05sog00 != null &&
      !StringHelper.isTrue(ContextHelper.getStringSafe(request, "bSaveAttempted")) )
  {
    ulIdResourceService = Integer.toString( rowcres05sog00.getUlIdResourceService() );
    szCdRsrcSvcCategRsrc = rowcres05sog00.getSzCdRsrcSvcCategRsrc();
    szCdRsrcSvcService = rowcres05sog00.getSzCdRsrcSvcService();

    if (rowcres05sog00.getSzCdRsrcSvcServiceType() != null)
    {
         szCdRsrcServiceType = rowcres05sog00.getSzCdRsrcSvcServiceType();
         if("F".equalsIgnoreCase(szCdRsrcServiceType)){
           generalBoolean = false;
           financialBoolean = true;
         }
    }
    

    if (rowcres05sog00.getSzCdRsrcSvcState() != null)
    {
      szCdRsrcSvcState = rowcres05sog00.getSzCdRsrcSvcState();
    }

    szCdRsrcSvcProgram = rowcres05sog00.getSzCdRsrcSvcProgram();
    szCdRsrcSvcRegion = rowcres05sog00.getSzCdRsrcSvcRegion();

    if( rowcres05sog00.getSzScrRsrcSvcCntyCode() != null )
    {
      szScrRsrcSvcCntyCode = rowcres05sog00.getSzScrRsrcSvcCntyCode();
    }

    if( StringHelper.isTrue( rowcres05sog00.getBIndRsrcSvcCntyPartial() ))
    {
      checkedBIndRsrcSvcCntyPartial = "true";
    }

    if( StringHelper.isTrue( rowcres05sog00.getCIndRsrcSvcIncomeBsed() ) )
    {
      checkedCIndRsrcSvcIncomeBsed = "true";
    }

    bInActiveContract = (StringHelper.isTrue(rowcres05sog00.getCScrIndRsrcContracted()));
  }
  else // If there isn't a row in state, pull values from the request
  {

    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "txtUlIdResourceService")))
    {
      ulIdResourceService = ContextHelper.getStringSafe(request, "txtUlIdResourceService");
    }
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdRsrcSvcCategRsrc")))
    {
      szCdRsrcSvcCategRsrc = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcCategRsrc");
    }
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdRsrcSvcService")))
    {
      szCdRsrcSvcService = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcService");
    }
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdRsrcSvcState")))
    {
      szCdRsrcSvcState = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcState");
    }
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdRsrcSvcProgram")))
    {
      szCdRsrcSvcProgram = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcProgram");
    }
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdRsrcSvcRegion")))
    {
      szCdRsrcSvcRegion = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcRegion");
    }
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzScrRsrcSvcCntyCode")))
    {
      szScrRsrcSvcCntyCode = ContextHelper.getStringSafe(request, "selSzScrRsrcSvcCntyCode");
    }
    if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "cbxBIndRsrcSvcCntyPartial")))
    {
      checkedBIndRsrcSvcCntyPartial = "true";
    }
    if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "cbxCIndRsrcSvcIncomeBsed")))
    {
      checkedCIndRsrcSvcIncomeBsed = "true";
    }
  }

  String pageMode = GlobalData.getAppMode(request);
  boolean bInAddMode = false;

  // If we got called in view mode, we shouldn't be able to do anything.
  if (!StringHelper.checkForEquality(pageMode, PageModeConstants.VIEW))
  {
    if ("A".equalsIgnoreCase(ContextHelper.getStringSafe(request, "SzCdScrDataAction")) &&
        !StringHelper.isTrue(ContextHelper.getStringSafe(request, "originallyUpdateMode" )))
    {
      bInAddMode = true;
      pageMode = PageModeConstants.EDIT;

      sDisabledIncomeAndProgram = "false";
      sDisabledPartialCounties = "false";
      sDisabledOtherFields = "false";
      sDisabledCounties = "false";
    }
    else if( !bInActiveContract )   //  1) If service is in active contract, it is read only.
    {
      pageMode = PageModeConstants.EDIT;
      //  2) If service is not active, but is region-wide, you can change program and income based.
      sDisabledIncomeAndProgram = "false";
      sDisabledCounties = "false";

      if (!bIsRegionWide)
      {
        //  3) If service is a particular county, you can also change partial counties.
        sDisabledPartialCounties = "false";
      }
    }
  }

  if("F".equalsIgnoreCase(ContextHelper.getStringSafe(request, "SzCdServiceType"))){
  generalBoolean = false;
  financialBoolean = true;
    }


  //  4) Nothing else can be changed.  We don't have to propagate any params in case of validation
  //     errors because ALL fields can be changed on a new record, and existing record being
  //     modified will have a row in state.


  String selectedServiceIndex = ContextHelper.getStringSafe(request, "selectedServiceIndex" );

  boolean partCounty = StringHelper.isTrue( checkedBIndRsrcSvcCntyPartial );

  if (bInAddMode)
    excludeOutOfStateOption.add("99");
    excludeOutOfStateOption.add("95"); // ECEM 5.0: exclude new option 'All Regions' that's only for Financial service.

  int tabIndex = 1;

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  //Get county code/decode array with all data\r\n  ");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 01\r\n  ");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 02\r\n  ");
      if (_jspx_meth_impact_codeArray_2(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 03A\r\n  ");
      if (_jspx_meth_impact_codeArray_3(_jspx_page_context))
        return;
      out.write("  \r\n  //Get county code/decode array filtered for region 04\r\n  ");
      if (_jspx_meth_impact_codeArray_4(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 05\r\n  ");
      if (_jspx_meth_impact_codeArray_5(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 06\r\n  ");
      if (_jspx_meth_impact_codeArray_6(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 07\r\n  ");
      if (_jspx_meth_impact_codeArray_7(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 08\r\n  ");
      if (_jspx_meth_impact_codeArray_8(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 09\r\n  ");
      if (_jspx_meth_impact_codeArray_9(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 10\r\n  ");
      if (_jspx_meth_impact_codeArray_10(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 11\r\n  ");
      if (_jspx_meth_impact_codeArray_11(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 12\r\n  ");
      if (_jspx_meth_impact_codeArray_12(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 13\r\n  ");
      if (_jspx_meth_impact_codeArray_13(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 14\r\n  ");
      if (_jspx_meth_impact_codeArray_14(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 15\r\n  ");
      if (_jspx_meth_impact_codeArray_15(_jspx_page_context))
        return;
      out.write("  \r\n  //Get county code/decode array filtered for region 97\r\n  ");
      if (_jspx_meth_impact_codeArray_16(_jspx_page_context))
        return;
      out.write("  \r\n\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_17(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_18(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_19(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_20(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_21(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_22(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_23(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_24(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_25(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_26(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_27(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_28(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_29(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_30(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_31(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_32(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_33(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_34(_jspx_page_context))
        return;
      out.write("\r\n  //STGAP00013039 - Get service code/decode array for UAS 515 financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_35(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_36(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_37(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_38(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_39(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_40(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_41(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_42(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_43(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_44(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_45(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_46(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_47(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_48(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_49(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_50(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_51(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_52(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_53(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_54(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_55(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_56(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_57(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_58(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_59(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_60(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_61(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_62(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_63(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_64(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_65(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_66(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_67(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_68(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_69(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_70(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_71(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_72(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_73(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_74(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_75(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_76(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_77(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_78(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_79(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_80(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_81(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_82(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_83(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_84(_jspx_page_context))
        return;
      out.write("\r\n    //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_85(_jspx_page_context))
        return;
      out.write("\r\n    //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_86(_jspx_page_context))
        return;
      out.write("\r\n    //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_87(_jspx_page_context))
        return;
      out.write("\r\n  //STGAP00013039 - Get service code/decode array for UAS 617 financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_88(_jspx_page_context))
        return;
      out.write("\r\n  //STGAP00013039 - Get service code/decode array for UAS 618 financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_89(_jspx_page_context))
        return;
      out.write("\r\n    //SMS #39513 - Get service code/decode array for UAS 619 financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_90(_jspx_page_context))
        return;
      out.write("\r\n    //SMS #39513 - Get service code/decode array for UAS 620financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_91(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_92(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_93(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_94(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_95(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_96(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_97(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_98(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_99(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array for financial category\r\n  ");
      if (_jspx_meth_impact_codeArray_100(_jspx_page_context))
        return;
      out.write("\r\n\r\n  //Get service code/decode array for general\r\n  ");
      if (_jspx_meth_impact_codeArray_101(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 01\r\n  ");
      if (_jspx_meth_impact_codeArray_102(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 02\r\n  ");
      if (_jspx_meth_impact_codeArray_103(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 03\r\n  ");
      if (_jspx_meth_impact_codeArray_104(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 04\r\n  ");
      if (_jspx_meth_impact_codeArray_105(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 05\r\n  ");
      if (_jspx_meth_impact_codeArray_106(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 06\r\n  ");
      if (_jspx_meth_impact_codeArray_107(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 07\r\n  ");
      if (_jspx_meth_impact_codeArray_108(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 08\r\n  ");
      if (_jspx_meth_impact_codeArray_109(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 09\r\n  ");
      if (_jspx_meth_impact_codeArray_110(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 10\r\n  ");
      if (_jspx_meth_impact_codeArray_111(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 11\r\n  ");
      if (_jspx_meth_impact_codeArray_112(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 12\r\n  ");
      if (_jspx_meth_impact_codeArray_113(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 13\r\n  ");
      if (_jspx_meth_impact_codeArray_114(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 14\r\n  ");
      if (_jspx_meth_impact_codeArray_115(_jspx_page_context))
        return;
      out.write("\r\n  //Get service code/decode array filtered for general category 15\r\n  ");
      if (_jspx_meth_impact_codeArray_116(_jspx_page_context))
        return;
      out.write("  \r\n\r\n  //Get Region code/decode array\r\n  ");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_117 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_117.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_117.setParent(null);
      _jspx_th_impact_codeArray_117.setCodeName("CSVCRGNS");
      _jspx_th_impact_codeArray_117.setExcludeOptions(excludeOutOfStateOption);
      _jspx_th_impact_codeArray_117.setArrayName("facRegions");
      _jspx_th_impact_codeArray_117.setBlankValue("true");
      int _jspx_eval_impact_codeArray_117 = _jspx_th_impact_codeArray_117.doStartTag();
      if (_jspx_th_impact_codeArray_117.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  window.attachEvent('onbeforeunload', setDirty );\r\n  function setDirty()\r\n  {\r\n    IsDirty();\r\n  };\r\n\r\n  window.attachEvent('onload', setUpdMode );\r\n  function setUpdMode()\r\n  {\r\n    if ( frmServiceDetail.SzCdScrDataAction.value == 'U' || frmServiceDetail.SzCdScrDataAction.value == 'u' )\r\n    {\r\n       frmServiceDetail.originallyUpdateMode.value = 'TRUE';\r\n    }\r\n\r\n    ");
 if (StringHelper.isTrue(checkedCIndRsrcSvcIncomeBsed)) { 
      out.write("\r\n      document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.checked = true;\r\n      document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.defaultChecked = true;\r\n    ");
}
      out.write("\r\n\r\n    populateCounty();\r\n\r\n   // Set all default values.  It's the easiest thing.  Trust me.\r\n\r\n  ");
 if (StringHelper.isTrue(checkedBIndRsrcSvcCntyPartial)) { 
      out.write("\r\n\r\n    document.frmServiceDetail.partCounties.value = \"true\";\r\n\r\n  ");
if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledPartialCounties )) {
      out.write("\r\n\r\n    document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial_Disabled.checked = true;\r\n    document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial_Disabled.defaultChecked = true;\r\n    ");
} else { 
      out.write("\r\n\r\n    document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial.checked = true;\r\n    document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial.defaultChecked = true;\r\n   ");
}
      out.write("\r\n\r\n\r\n  ");
} else {
      out.write("\r\n    document.frmServiceDetail.partCounties.value = \"false\";\r\n  ");
}
      out.write("\r\n\r\n    populateService(\"");
      out.print(szCdRsrcSvcService);
      out.write("\")\r\n\r\n  ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n     document.frmServiceDetail.selSzCdRsrcSvcService_Disabled.defaultValue = document.frmServiceDetail.selSzCdRsrcSvcService_Disabled.value;\r\n\r\n  ");
 } else { 
      out.write("\r\n     document.frmServiceDetail.selSzCdRsrcSvcService.defaultValue = document.frmServiceDetail.selSzCdRsrcSvcService.value;\r\n\r\n  ");
 } 
      out.write("\r\n\r\n  ");
 if (bInAddMode && !StringHelper.checkForEquality(szCdRsrcSvcState, "GA")) { 
      out.write("\r\n    document.frmServiceDetail.selSzCdRsrcSvcRegion.length = 1\r\n    document.frmServiceDetail.selSzCdRsrcSvcRegion.options[0].value = \"99\";\r\n    document.frmServiceDetail.selSzCdRsrcSvcRegion.options[0].text = \"Out of State\";\r\n    document.frmServiceDetail.selSzCdRsrcSvcRegion.value = \"99\";\r\n  ");
}
      out.write("\r\n\r\n  };\r\n\r\n  function doCheckBoxes(pc)\r\n  {\r\n\r\n    var frm = document.frmServiceDetail;\r\n\r\n    var stateCode = getState();\r\n    var regionCode = getRegionCode();\r\n    var countyCode = getCountyCode();\r\n\r\n    var bInAddMode;\r\n\r\n    if (frmServiceDetail.inAddMode.value == 'true')\r\n      bInAddMode = true;\r\n    else\r\n      bInAddMode = false;\r\n\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledCounties )) {
      out.write("\r\n      var cbxAll = frm.cbxBIndRsrcSvcCntyAll_Disabled;\r\n    ");
 } else { 
      out.write("\r\n      var cbxAll = frm.cbxBIndRsrcSvcCntyAll;\r\n    ");
 } 
      out.write("\r\n\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledPartialCounties )) {
      out.write("\r\n      var cbxPart = frm.cbxBIndRsrcSvcCntyPartial_Disabled;\r\n    ");
 } else { 
      out.write("\r\n      var cbxPart = frm.cbxBIndRsrcSvcCntyPartial;\r\n    ");
 } 
      out.write("\r\n\r\n    var acHidden = frm.allCounties;\r\n    var pcHidden = frm.partCounties;\r\n\r\n    // Enabling the checkboxes here will make sure\r\n    // that they don't accidentally stay disabled.\r\n    // We will re-disable them later if necessary.\r\n    // Unless, of course, we're in browse mode, in which\r\n    // case we don't want to enable it. Is this making\r\n    // sense yet?\r\n\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledCounties )) {
      out.write("\r\n      cbxAll.disabled = true;\r\n      cbxPart.disabled = true;\r\n    ");
 } else { 
      out.write("\r\n      cbxAll.disabled = false;\r\n      cbxPart.disabled = false;\r\n    ");
 } 
      out.write("\r\n\r\n\r\n    if (pc == 1) // if they clicked the partial county box themselves\r\n    {\r\n      // clear and disable all counties checkbox\r\n      cbxAll.checked = false;\r\n\r\n      if (countyCode == '')\r\n      {\r\n        cbxPart.checked = false;\r\n      }\r\n      else\r\n      {\r\n        cbxPart.disabled = false;\r\n      }\r\n    }\r\n    else if (stateCode == 'GA') // First, make sure we're still in Georgia...\r\n    {\r\n\r\n\r\n      if ( !bInAddMode && pc == 2)\r\n      {\r\n\r\n        // TODO HERE\r\n        // UNSET THE PARTIAL COUNTIES BOX IF CHECKED\r\n\r\n        if (cbxAll.checked)\r\n        {\r\n          ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n            clearDropdown(\"selSzScrRsrcSvcCntyCode_Disabled\");\r\n            document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"\";\r\n          ");
 } else { 
      out.write("\r\n            clearDropdown(\"selSzScrRsrcSvcCntyCode\");\r\n            document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"\";\r\n          ");
 } 
      out.write("\r\n\r\n            cbxPart.checked = false;\r\n            cbxPart.disabled = true;\r\n        }\r\n        else\r\n        {\r\n        ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields ) ) {
      out.write("\r\n          populateDropdownLocal(\"selSzScrRsrcSvcCntyCode_Disabled\", \"");
      out.print(szScrRsrcSvcCntyCode);
      out.write("\", eval(\"facCounty\" + regionCode));\r\n        ");
 } else { 
      out.write("\r\n          populateDropdownLocal(\"selSzScrRsrcSvcCntyCode\", \"");
      out.print(szScrRsrcSvcCntyCode);
      out.write("\", eval(\"facCounty\" + regionCode));\r\n        ");
 } 
      out.write("\r\n          cbxPart.disabled = false;\r\n        }\r\n\r\n      }\r\n      // Are we in a statewide row?\r\n      else if (regionCode == '98')\r\n      {\r\n        // Set the \"all counties\" and clear \"partial county\" check boxes.\r\n        cbxAll.checked = true;\r\n        cbxPart.checked = false;\r\n\r\n        // You're not allowed to change them, either...\r\n        cbxAll.disabled = true;\r\n        cbxPart.disabled = true;\r\n      }\r\n      // How about a statewide intake or state office row?\r\n      else if (regionCode == '99')\r\n      {\r\n        // Clear the \"all counties\" and \"partial county\" check boxes.\r\n        cbxAll.checked = false;\r\n        cbxPart.checked = false;\r\n\r\n        // You're not allowed to change them, either...\r\n        cbxAll.disabled = true;\r\n        cbxPart.disabled = true;\r\n      }\r\n      else if (regionCode == '')  // no region?\r\n      {\r\n        cbxAll.checked = false;\r\n        cbxAll.disabled = true;\r\n\r\n        cbxPart.checked = false;\r\n        cbxPart.disabled = true;\r\n      }\r\n      else if (countyCode == '')\r\n");
      out.write("      {\r\n        cbxAll.checked = true;\r\n        cbxAll.disabled = true;\r\n\r\n        cbxPart.checked = false;\r\n        cbxPart.disabled = true;\r\n      }\r\n      else\r\n      {\r\n        cbxAll.checked = false;\r\n        cbxPart.checked = false;\r\n\r\n        ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) {
      out.write("\r\n          cbxPart.disabled = true;\r\n        ");
 } else { 
      out.write("\r\n          cbxPart.disabled = false;\r\n        ");
 } 
      out.write("\r\n      }\r\n    }\r\n    else\r\n    {\r\n      // I have a feeling we're not in Texas anymore...\r\n      // Uncheck all boxes and disable them.\r\n      cbxAll.checked = false;\r\n      cbxPart.checked = false;\r\n      cbxAll.disabled = true;\r\n      cbxPart.disabled = true;\r\n    }\r\n\r\n    //set the values of the checkboxes\r\n    if (cbxAll.checked)\r\n    {\r\n      cbxAll.value = 'true';\r\n      acHidden.value = 'true';\r\n    }\r\n    else\r\n    {\r\n      cbxAll.value = 'false';\r\n      acHidden.value = '';\r\n    }\r\n\r\n\r\n    if (cbxPart.checked)\r\n    {\r\n      cbxPart.value = 'true';\r\n      pcHidden.value = 'true';\r\n    }\r\n    else\r\n    {\r\n      cbxPart.value = 'false';\r\n      pcHidden.value = 'false';\r\n    }\r\n\r\n\r\n    // If we're in browse mode, re-disable the checkboxes in case we enabled them\r\n    // previously.\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledCounties )) {
      out.write("\r\n      cbxAll.disabled = true;\r\n    ");
 } 
      out.write("\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledPartialCounties )) {
      out.write("\r\n      cbxPart.disabled = true;\r\n    ");
 } 
      out.write("\r\n\r\n  }\r\n\r\n  function selectAllCounties()\r\n  {\r\n    document.frmServiceDetail.selSzScrRsrcSvcCntyCode.selectedIndex=0;\r\n\r\n    document.frmServiceDetail.changedToRegionWide.value = 'true';\r\n    if (frmServiceDetail.inAddMode.value == 'true')\r\n      doCheckBoxes(0);\r\n    else\r\n      doCheckBoxes(2);\r\n  }\r\n\r\n  /*\r\n  *This function clears drop down boxes of all options.\r\n  *@ param field: Name of drop down box to be cleard of all options\r\n  */\r\n  function clearDropdown(field)\r\n  {\r\n     //sets the values of all options to blank, and changes the number of options to 1\r\n     var fieldLength = eval(\"document.frmServiceDetail.\"+field+\".options.length\");\r\n\r\n     eval(\"document.frmServiceDetail.\"+field+\".value = \\\"\\\";\");\r\n     for (var b=0; b < fieldLength; b++)\r\n     {\r\n       //empties the facility type drop-down box\r\n       eval(\"document.frmServiceDetail.\"+field+\".options[b].value = \\\"\\\";\");\r\n       eval(\"document.frmServiceDetail.\"+field+\".options[b].text = \\\"\\\";\");\r\n     }\r\n\r\n     eval(\"document.frmServiceDetail.\"+field+\".options.length = 1\");\r\n");
      out.write("  }\r\n\r\n  /*\r\n  *This function populates drop down boxes with options.\r\n  * param field: Name of drop down box to be populated\r\n  * param val: Value of last selected option on dropdown box\r\n  * param cat: Array containing the values to populate drop down options\r\n  */\r\n  function populateDropdownLocal(field, val, cat)\r\n  {    \r\n     // we will clear the dropdown first.\r\n     // This prevents it from being doubly populated.\r\n     clearDropdown(field);\r\n\r\n     // SIR REG059 - dejuanr - Service detailhad it own populate dropdown method.\r\n     // I deleted it and had it call the main impact one.\r\n     populateDropdown( eval(\"document.frmServiceDetail.\"+field), val , cat );\r\n  }\r\n\r\n  function populateCounty()\r\n  {\r\n    // Check to see if we are still looking at GA...\r\n    if(getState() == 'GA')\r\n    {\r\n      // if so, populate the County with counties in the selected region\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n      var regionCode = document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.value;\r\n    ");
 } else { 
      out.write("\r\n      var regionCode = document.frmServiceDetail.selSzCdRsrcSvcRegion.options.value;\r\n    ");
 } 
      out.write("\r\n\r\n      if (regionCode == '00' || regionCode == '98' || regionCode == '99' || regionCode == '')\r\n      {\r\n        // 00 = Statewide Intake - 98 = Statewide - 99 = State Office\r\n\r\n        // Clear out the county boxes in these cases\r\n        ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n          clearDropdown(\"selSzScrRsrcSvcCntyCode_Disabled\");\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"\";\r\n        ");
 } else { 
      out.write("\r\n          clearDropdown(\"selSzScrRsrcSvcCntyCode\");\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"\";\r\n        ");
 } 
      out.write("\r\n      }\r\n      else\r\n      {\r\n      ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields ) ) {
      out.write("\r\n        populateDropdownLocal(\"selSzScrRsrcSvcCntyCode_Disabled\", \"");
      out.print(szScrRsrcSvcCntyCode);
      out.write("\", eval(\"facCounty\" + regionCode));\r\n      ");
 } else { 
      out.write("\r\n        populateDropdownLocal(\"selSzScrRsrcSvcCntyCode\", \"");
      out.print(szScrRsrcSvcCntyCode);
      out.write("\", eval(\"facCounty\" + regionCode));\r\n      ");
 } 
      out.write("\r\n\r\n      }\r\n    }\r\n    // and if not, we clear the County dropdown.\r\n    else\r\n    {\r\n        ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n          clearDropdown(\"selSzScrRsrcSvcCntyCode_Disabled\");\r\n\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.length = 1\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.options[0].text = \"Out of State\";\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.options[0].value = \"999\";\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.value = \"999\";\r\n\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"999\";\r\n        ");
 } else { 
      out.write("\r\n          clearDropdown(\"selSzScrRsrcSvcCntyCode\");\r\n\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.length = 1\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.options[0].value = \"999\";\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.options[0].text = \"Out of State\";\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"999\";\r\n        ");
 } 
      out.write("\r\n    }\r\n\r\n    doCheckBoxes(0);\r\n  }\r\n\r\n  function populateRegion()\r\n  {\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n          populateDropdownLocal(\"selSzCdRsrcSvcRegion_Disabled\", \"\", facRegions);\r\n        ");
 } else { 
      out.write("\r\n          populateDropdownLocal(\"selSzCdRsrcSvcRegion\", \"\", facRegions);\r\n        ");
 } 
      out.write("\r\n\r\n    doCheckBoxes(0);\r\n  }\r\n\r\n  function populateRegionAndCounty()\r\n  {\r\n    // See if we're looking at Texas\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n        if(document.frmServiceDetail.selSzCdRsrcSvcState_Disabled.value == 'GA')\r\n    ");
 } else { 
      out.write("\r\n      if(document.frmServiceDetail.selSzCdRsrcSvcState.options.value == 'GA')\r\n    ");
 } 
      out.write("\r\n    {\r\n      // if so, populate the Region and County dropdowns\r\n      populateRegion();\r\n      populateCounty();\r\n\r\n      // If we're in an updating all counties row, we have to force the region dropdown\r\n      // to the correct value. The county shall remain blank.\r\n      ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n        document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.value = \"");
      out.print(szCdRsrcSvcRegion);
      out.write("\";\r\n        document.frmServiceDetail.selSzCdRsrcSvcRegion.value = \"");
      out.print(szCdRsrcSvcRegion);
      out.write("\";\r\n      ");
}
      out.write("\r\n\r\n    }\r\n    // and if not, we clear them, then add the out of state codes\r\n    else\r\n    {\r\n        ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n          clearDropdown(\"selSzCdRsrcSvcRegion_Disabled\");\r\n          document.frmServiceDetail.selSzCdRsrcSvcRegion.value = \"\";\r\n        ");
 } else { 
      out.write("\r\n          clearDropdown(\"selSzCdRsrcSvcRegion\");\r\n        ");
 } 
      out.write("\r\n\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.length = 1\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.options[0].text = \"Out of State\";\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.options[0].value = \"99\";\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.value = \"99\";\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion.value = \"99\";\r\n    ");
 } else { 
      out.write("\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion.length = 1\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion.options[0].value = \"99\";\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion.options[0].text = \"Out of State\";\r\n      document.frmServiceDetail.selSzCdRsrcSvcRegion.value = \"99\";\r\n    ");
 } 
      out.write("\r\n\r\n        ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n          clearDropdown(\"selSzScrRsrcSvcCntyCode_Disabled\");\r\n          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"\";\r\n        ");
 } else { 
      out.write("\r\n          clearDropdown(\"selSzScrRsrcSvcCntyCode\");\r\n        ");
 } 
      out.write("\r\n\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.length = 1\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.options[0].text = \"Out of State\";\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.options[0].value = \"999\";\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.value = \"999\";\r\n\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"999\";\r\n    ");
 } else { 
      out.write("\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.length = 1\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.options[0].value = \"999\";\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.options[0].text = \"Out of State\";\r\n      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = \"999\";\r\n    ");
 } 
      out.write("\r\n    }\r\n\r\n    doCheckBoxes(0);\r\n  }\r\n\r\n  function populateService( Svc )\r\n  {\r\n    //serviceType is required to decipher which array of codes to use\r\n    var serviceType = Svc;\r\n    var serviceCategory = document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.value;\r\n    \r\n    if (Svc == 0)\r\n    {\r\n      Svc = \"\";\r\n    }\r\n\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n\r\n    if(document.frmServiceDetail.selSzCdRsrcSvcCategRsrc_Disabled.value == \"\")\r\n    {\r\n    \r\n      clearDropdown(\"selSzCdRsrcSvcService_Disabled\");\r\n      document.frmServiceDetail.selSzCdRsrcSvcService.value = \"\";\r\n    }\r\n    else\r\n    {\r\n   \r\n      //because certain codes for FAD (96D, 96J) are created with category 02,\r\n      //but they aren't listed in the codes tables (CATSVLNK)\r\n      //Since the page mode is view anyway, it can't hurt to populate the real value\r\n      //ade\r\n      //commented out next line; if in view it is unnecessary to populate the dropdown\r\n      //with all the values\r\n      ");
if(generalBoolean && (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields ))){
      out.write("\r\n       populateDropdownLocal(\"selSzCdRsrcSvcService_Disabled\", \"");
      out.print(szCdRsrcSvcService);
      out.write("\", genService);\r\n      ");
}else if(financialBoolean && (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields ))){
      out.write("\r\n       populateDropdownLocal(\"selSzCdRsrcSvcService_Disabled\", \"");
      out.print(szCdRsrcSvcService);
      out.write("\", finService);\r\n      ");
}
      out.write("\r\n      document.frmServiceDetail.selSzCdRsrcSvcService.value = \"");
      out.print(szCdRsrcSvcService);
      out.write("\";\r\n    }\r\n\r\n\r\n    ");
 } else { 
      out.write("\r\n\r\n    if(document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.options.value == \"\")\r\n    {\r\n     \r\n      clearDropdown(\"selSzCdRsrcSvcService\");\r\n    }\r\n    else\r\n    {//change this line to CGLSVCCD CPRGCODE\r\n       if( serviceType == 'F')\r\n           populateDropdownLocal(\"selSzCdRsrcSvcService\", '', eval(\"finService\" +serviceCategory));   \r\n        else\r\n           populateDropdownLocal(\"selSzCdRsrcSvcService\", '', eval(\"genService\"+serviceCategory));\r\n    }\r\n\r\n    ");
 } 
      out.write("\r\n  }\r\n\r\n  function getState()\r\n  {\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n      return document.frmServiceDetail.selSzCdRsrcSvcState_Disabled.value;\r\n    ");
 } else { 
      out.write("\r\n      return document.frmServiceDetail.selSzCdRsrcSvcState.value;\r\n    ");
 } 
      out.write("\r\n  }\r\n\r\n  function getRegionCode()\r\n  {\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n      return document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.value;\r\n    ");
 } else { 
      out.write("\r\n      return document.frmServiceDetail.selSzCdRsrcSvcRegion.value;\r\n    ");
 } 
      out.write("\r\n  }\r\n\r\n  function getCountyCode()\r\n  {\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n      return document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.value;\r\n    ");
 } else { 
      out.write("\r\n      return document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value;\r\n    ");
 } 
      out.write("\r\n  }\r\n\r\n  function getService()\r\n  {\r\n    ");
 if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {
      out.write("\r\n      return document.frmServiceDetail.selSzCdRsrcSvcService_Disabled.value;\r\n    ");
 } else { 
      out.write("\r\n      return document.frmServiceDetail.selSzCdRsrcSvcService.value;\r\n    ");
 } 
      out.write("\r\n  }\r\n\r\n  function deleteService()\r\n  {\r\n    var confirmMessage = \"\";\r\n\r\n    if ( (getState() == 'GA' && getRegionCode() == '98') || (! getState() == 'GA'))\r\n    {\r\n      confirmMessage = \"This will delete the Client Characteristics for the service within the state. Delete?\";\r\n    }\r\n    else\r\n    {\r\n      confirmMessage = \"This will delete the Client Characteristics for the service within the region. Delete?\";\r\n    }\r\n\r\n      if( confirm(confirmMessage) )\r\n      {\r\n        document.frmServiceDetail.SzCdScrDataAction.value='D';\r\n        window.onbeforeunload = null;\r\n        document.frmServiceDetail.validationOverride.value = 'true';\r\n        return true;\r\n      }\r\n      else\r\n      {\r\n        return false;\r\n      }\r\n  }\r\n\r\n  function saveService()\r\n  {\r\n    var confirmMessage = \"\";\r\n    var regionCode = getRegionCode();\r\n    var abandon = false;\r\n\r\n    var bInAddMode;\r\n\r\n    if (frmServiceDetail.inAddMode.value == 'true')\r\n      bInAddMode = true;\r\n    else\r\n      bInAddMode = false;\r\n\r\n    if ( !bInAddMode && frmServiceDetail.cbxBIndRsrcSvcCntyAll.checked && frmServiceDetail.changedToRegionWide.value == 'true')\r\n");
      out.write("    {\r\n\r\n      bInAddMode = true;\r\n      frmServiceDetail.SzCdScrDataAction.value = 'A';\r\n\r\n    }\r\n    else if (frmServiceDetail.originallyUpdateMode.value == 'TRUE')\r\n    {\r\n      bInAddMode = false;\r\n      frmServiceDetail.SzCdScrDataAction.value = 'U';\r\n    }\r\n\r\n    // See if we're trying to add a \"statewide\" row.\r\n    if (regionCode == '98')\r\n    {\r\n       // if so, we need to make sure they know what they're getting into...\r\n      confirmMessage = \"You are about to add a statewide row. This will delete \";\r\n      confirmMessage = confirmMessage + \"any already existing similar regionwide \";\r\n      confirmMessage = confirmMessage + \"rows, then add new ones. This will also \";\r\n      confirmMessage = confirmMessage + \"delete the client characterisitics for \";\r\n      confirmMessage = confirmMessage + \"those pre-existing rows. Are you sure you \";\r\n      confirmMessage = confirmMessage + \"want to do this?\";\r\n\r\n      if (!confirm(confirmMessage))\r\n      {\r\n        abandon = true;\r\n      }\r\n\r\n    } else\r\n\r\n    if ( bInAddMode && document.frmServiceDetail.cbxBIndRsrcSvcCntyAll.checked )\r\n");
      out.write("      // originally all counties and not anymore and update mode, or we're in add mode and all counties is checked.\r\n    {\r\n      // if so, we need to make sure they know what they're getting into...\r\n     confirmMessage = \"You are about to add a region row. This will delete \";\r\n     confirmMessage = confirmMessage + \"any already existing similar county \";\r\n     confirmMessage = confirmMessage + \"rows. This will also \";\r\n     confirmMessage = confirmMessage + \"delete the client characterisitics for \";\r\n     confirmMessage = confirmMessage + \"those pre-existing rows. Are you sure you \";\r\n     confirmMessage = confirmMessage + \"want to do this?\";\r\n\r\n     if (!confirm(confirmMessage))\r\n     {\r\n       abandon = true;\r\n     }\r\n    }\r\n\r\n    if (!abandon)\r\n    {\r\n     window.onbeforeunload = null;\r\n\r\n     enableValidation('frmServiceDetail');  // I hope this is a valid function.\r\n\r\n     if (document.frmServiceDetail.selectedServiceIndex.value == '')\r\n     {\r\n     \t// STGAP00017019:ECEM 5.0: update the url with the new name now that General and Financial services use\r\n");
      out.write("     \t// different screen for Add mode\r\n       document.frmServiceDetail.action = '/resource/ServicesByArea/addGenServiceDetail';\r\n     }\r\n     else\r\n     {\r\n       document.frmServiceDetail.action = '/resource/ServicesByArea/displayServiceDetail';\r\n     }\r\n\r\n     if(document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial.checked)\r\n     {\r\n       document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial.value = \"true\";\r\n     }\r\n\r\n     if(document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.checked)\r\n     {\r\n       document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.value = \"true\";\r\n     }\r\n\r\n     document.frmServiceDetail.bSaveAttempted.value = \"true\";\r\n    }\r\n\r\n    return !abandon;\r\n  }\r\n\r\n//sets the service type and submits the form for \r\n//redisplay. This only occurs if there is \r\n//a change in types when adding new service detail\r\n//information\r\nfunction setServiceType( item )\r\n{\r\n  document.frmServiceDetail.SzCdServiceType.value= item;\r\n  disableValidation('frmServiceDetail');\r\n\r\n  // STGAP00017019:ECEM 5.0: forward the page to the correct address based on the service type\r\n");
      out.write("  if (item == 'F')\r\n  { \r\n    document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.value= '';\r\n    document.frmServiceDetail.selSzCdRsrcSvcRegion.value= '';\r\n    document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.value= false;\r\n    \r\n  \tsubmitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addFinServiceDetail');\r\n  }\r\n  else\r\n  \tsubmitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addGenServiceDetail');\r\n}\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmServiceDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ServicesByArea/default");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.ServiceDetailValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<input type=\"hidden\"\r\n       name=\"");
          out.print( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
          out.write("\"\r\n       value=\"");
          out.print( pageMode );
          out.write("\"/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"txtUlIdResourceService\"\r\n       value=\"");
          out.print( ulIdResourceService );
          out.write("\"/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"SzCdScrDataAction\"\r\n       value='");
          out.print( ContextHelper.getStringSafe(request, "SzCdScrDataAction") );
          out.write("'/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"originallyUpdateMode\"\r\n       value='");
          out.print( ContextHelper.getStringSafe(request, "originallyUpdateMode") );
          out.write("'/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"changedToRegionWide\"\r\n       value=\"false\"/>\r\n       \r\n<input type=\"hidden\" \r\n       name=\"SzCdServiceType\" \r\n       value='");
          out.print( ContextHelper.getStringSafe(request, "SzCdServiceType") );
          out.write("'/>\r\n\r\n<input type=\"hidden\" name=\"inAddMode\" value=\"");
          out.print( bInAddMode );
          out.write("\"/>\r\n<input type=\"hidden\" name=\"bSaveAttempted\" value=\"false\"/>\r\n\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<!-- We need the following two fields to hold the value of the AllCounties\r\n     and PartialCounties checkboxes as they are occasionally disabled and\r\n     won't submit a value. -->\r\n");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnServiceType");
          _jspx_th_impact_validateInput_3.setValue( szCdRsrcServiceType );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<!-- We'll probably need this to keep track of where we came from on the list page. -->\r\n<input type=\"hidden\" name=\"selectedServiceIndex\" value=\"");
          out.print(selectedServiceIndex);
          out.write("\"/>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n      <tr>\r\n          <th colspan=\"4\">Services by Area Information</th>\r\n      </tr>\r\n      <tr colspan=\"4\">\r\n           <td>\r\n           ");
          if (_jspx_meth_impact_validateDisplayOnlyField_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateInput_4.setName("rbServiceType");
          _jspx_th_impact_validateInput_4.setValue("G");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setChecked( String.valueOf( generalBoolean ) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("General\r\n\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateInput_5.setName("rbServiceType");
          _jspx_th_impact_validateInput_5.setValue("F");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setChecked( String.valueOf( financialBoolean ) );
          _jspx_th_impact_validateInput_5.setOnClick("setServiceType('F');");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Financial\r\n           </td>\r\n      </tr>\r\n");
 if("".equalsIgnoreCase(ContextHelper.getStringSafe(request, "SzCdServiceType"))
      ||"G".equalsIgnoreCase(ContextHelper.getStringSafe(request, "SzCdServiceType"))){
          out.write("\r\n      <tr>\r\n          <th colspan=\"4\">General Services by Area</th>\r\n      </tr>\r\n      <tr>\r\n          <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateSelect_0.setName("selSzCdRsrcSvcCategRsrc");
          _jspx_th_impact_validateSelect_0.setLabel("Category");
          _jspx_th_impact_validateSelect_0.setCodesTable("CATOFSVC");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(szCdRsrcSvcCategRsrc));
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setOnChange("populateService('G')");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 180px");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateSelect_1.setName("selSzCdRsrcSvcService");
          _jspx_th_impact_validateSelect_1.setLabel("Service");
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 180px");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(szCdRsrcSvcService));
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n\r\n");

  }
  else
  {
  String svcCategory = Lookup.simpleDecodeSafe("CPRGCODE", szCdRsrcSvcCategRsrc);
  
          out.write("\r\n        <tr>\r\n            <th colspan=\"4\">Financial Services by Area</th>\r\n        </tr>\r\n        <tr>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateSelect_2.setName("selSzCdRsrcSvcCategRsrc");
          _jspx_th_impact_validateSelect_2.setLabel("Category");
          _jspx_th_impact_validateSelect_2.setCodesTable("CPRGCODE");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(szCdRsrcSvcCategRsrc));
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setOnChange("populateService('F')");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setStyle("WIDTH: 320px");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>\r\n        <tr>            \r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateSelect_3.setName("selSzCdRsrcSvcService");
          _jspx_th_impact_validateSelect_3.setLabel("Service");
          _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 320px");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(szCdRsrcSvcService));
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n  ");

  }

          out.write("\r\n      <tr>\r\n          <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateSelect_4.setName("selSzCdRsrcSvcState");
          _jspx_th_impact_validateSelect_4.setLabel("State");
          _jspx_th_impact_validateSelect_4.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(szCdRsrcSvcState));
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setOnChange("populateRegionAndCounty()");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setDisabled( sDisableProgramOnly );
          _jspx_th_impact_validateSelect_5.setName("selSzCdRsrcSvcProgram");
          _jspx_th_impact_validateSelect_5.setLabel("Program");
          _jspx_th_impact_validateSelect_5.setCodesTable("CRSCPROG");
          _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(szCdRsrcSvcProgram));
          _jspx_th_impact_validateSelect_5.setRequired("false");
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n      </tr>\r\n        <tr>\r\n          <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateSelect_6.setName("selSzCdRsrcSvcRegion");
          _jspx_th_impact_validateSelect_6.setCodesTable("CREGIONS");
          _jspx_th_impact_validateSelect_6.setExcludeOptions(excludeOutOfStateOption);
          _jspx_th_impact_validateSelect_6.setLabel("Region");
          _jspx_th_impact_validateSelect_6.setBlankValue("true");
          _jspx_th_impact_validateSelect_6.setValue(FormattingHelper.formatString(szCdRsrcSvcRegion));
          _jspx_th_impact_validateSelect_6.setRequired("true");
          _jspx_th_impact_validateSelect_6.setOnChange("populateCounty()");
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n         <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setDisabled(sDisabledOtherFields);
          _jspx_th_impact_validateSelect_7.setName("selSzScrRsrcSvcCntyCode");
          _jspx_th_impact_validateSelect_7.setLabel("County");
          _jspx_th_impact_validateSelect_7.setStyle("WIDTH: 140px");
          _jspx_th_impact_validateSelect_7.setValue(FormattingHelper.formatString(szScrRsrcSvcCntyCode));
          _jspx_th_impact_validateSelect_7.setOnChange("doCheckBoxes(0)");
          _jspx_th_impact_validateSelect_7.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n      </tr>\r\n      <tr>\r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setDisabled(sDisabledPartialCounties);
          _jspx_th_impact_validateInput_6.setName("cbxBIndRsrcSvcCntyPartial");
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setOnClick("doCheckBoxes(1)");
          _jspx_th_impact_validateInput_6.setLabel("Partial County");
          _jspx_th_impact_validateInput_6.setChecked(checkedBIndRsrcSvcCntyPartial);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setDisabled(sDisabledCounties);
          _jspx_th_impact_validateInput_7.setName("cbxBIndRsrcSvcCntyAll");
          _jspx_th_impact_validateInput_7.setType("checkbox");
          _jspx_th_impact_validateInput_7.setOnClick("selectAllCounties()");
          _jspx_th_impact_validateInput_7.setLabel("All Counties");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setDisabled(sDisabledIncomeAndProgram);
          _jspx_th_impact_validateInput_8.setName("cbxCIndRsrcSvcIncomeBsed");
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setLabel("Income Based");
          _jspx_th_impact_validateInput_8.setChecked(checkedCIndRsrcSvcIncomeBsed);
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n  </table>\r\n\r\n");
          out.write("\r\n\r\n");
 if (!bInActiveContract && !StringHelper.checkForEquality(pageMode, PageModeConstants.VIEW) ) { 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n  ");
 if (!bInAddMode) { 
          out.write("\r\n    <td align=\"left\">\r\n     ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteService();");
          _jspx_th_impact_ButtonTag_0.setForm("frmServiceDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ServicesByArea/deleteServiceDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  ");
}
          out.write("\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return saveService();");
          _jspx_th_impact_ButtonTag_1.setForm("frmServiceDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ServicesByArea/saveServiceDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
}
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CCOUNT");
    _jspx_th_impact_codeArray_0.setArrayName("facCounty");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CCOUNT01");
    _jspx_th_impact_codeArray_1.setArrayName("facCounty01");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_2.setParent(null);
    _jspx_th_impact_codeArray_2.setCodeName("CCOUNT02");
    _jspx_th_impact_codeArray_2.setArrayName("facCounty02");
    _jspx_th_impact_codeArray_2.setBlankValue("true");
    int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
    if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_3.setParent(null);
    _jspx_th_impact_codeArray_3.setCodeName("CCOUNT03");
    _jspx_th_impact_codeArray_3.setArrayName("facCounty03");
    _jspx_th_impact_codeArray_3.setBlankValue("true");
    int _jspx_eval_impact_codeArray_3 = _jspx_th_impact_codeArray_3.doStartTag();
    if (_jspx_th_impact_codeArray_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_4.setParent(null);
    _jspx_th_impact_codeArray_4.setCodeName("CCOUNT04");
    _jspx_th_impact_codeArray_4.setArrayName("facCounty04");
    _jspx_th_impact_codeArray_4.setBlankValue("true");
    int _jspx_eval_impact_codeArray_4 = _jspx_th_impact_codeArray_4.doStartTag();
    if (_jspx_th_impact_codeArray_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_5.setParent(null);
    _jspx_th_impact_codeArray_5.setCodeName("CCOUNT05");
    _jspx_th_impact_codeArray_5.setArrayName("facCounty05");
    _jspx_th_impact_codeArray_5.setBlankValue("true");
    int _jspx_eval_impact_codeArray_5 = _jspx_th_impact_codeArray_5.doStartTag();
    if (_jspx_th_impact_codeArray_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_6.setParent(null);
    _jspx_th_impact_codeArray_6.setCodeName("CCOUNT06");
    _jspx_th_impact_codeArray_6.setArrayName("facCounty06");
    _jspx_th_impact_codeArray_6.setBlankValue("true");
    int _jspx_eval_impact_codeArray_6 = _jspx_th_impact_codeArray_6.doStartTag();
    if (_jspx_th_impact_codeArray_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_7.setParent(null);
    _jspx_th_impact_codeArray_7.setCodeName("CCOUNT07");
    _jspx_th_impact_codeArray_7.setArrayName("facCounty07");
    _jspx_th_impact_codeArray_7.setBlankValue("true");
    int _jspx_eval_impact_codeArray_7 = _jspx_th_impact_codeArray_7.doStartTag();
    if (_jspx_th_impact_codeArray_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_8.setParent(null);
    _jspx_th_impact_codeArray_8.setCodeName("CCOUNT08");
    _jspx_th_impact_codeArray_8.setArrayName("facCounty08");
    _jspx_th_impact_codeArray_8.setBlankValue("true");
    int _jspx_eval_impact_codeArray_8 = _jspx_th_impact_codeArray_8.doStartTag();
    if (_jspx_th_impact_codeArray_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_9.setParent(null);
    _jspx_th_impact_codeArray_9.setCodeName("CCOUNT09");
    _jspx_th_impact_codeArray_9.setArrayName("facCounty09");
    _jspx_th_impact_codeArray_9.setBlankValue("true");
    int _jspx_eval_impact_codeArray_9 = _jspx_th_impact_codeArray_9.doStartTag();
    if (_jspx_th_impact_codeArray_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_10.setParent(null);
    _jspx_th_impact_codeArray_10.setCodeName("CCOUNT10");
    _jspx_th_impact_codeArray_10.setArrayName("facCounty10");
    _jspx_th_impact_codeArray_10.setBlankValue("true");
    int _jspx_eval_impact_codeArray_10 = _jspx_th_impact_codeArray_10.doStartTag();
    if (_jspx_th_impact_codeArray_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_11.setParent(null);
    _jspx_th_impact_codeArray_11.setCodeName("CCOUNT11");
    _jspx_th_impact_codeArray_11.setArrayName("facCounty11");
    _jspx_th_impact_codeArray_11.setBlankValue("true");
    int _jspx_eval_impact_codeArray_11 = _jspx_th_impact_codeArray_11.doStartTag();
    if (_jspx_th_impact_codeArray_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_12.setParent(null);
    _jspx_th_impact_codeArray_12.setCodeName("CCOUNT12");
    _jspx_th_impact_codeArray_12.setArrayName("facCounty12");
    _jspx_th_impact_codeArray_12.setBlankValue("true");
    int _jspx_eval_impact_codeArray_12 = _jspx_th_impact_codeArray_12.doStartTag();
    if (_jspx_th_impact_codeArray_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_13.setParent(null);
    _jspx_th_impact_codeArray_13.setCodeName("CCOUNT13");
    _jspx_th_impact_codeArray_13.setArrayName("facCounty13");
    _jspx_th_impact_codeArray_13.setBlankValue("true");
    int _jspx_eval_impact_codeArray_13 = _jspx_th_impact_codeArray_13.doStartTag();
    if (_jspx_th_impact_codeArray_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_14.setParent(null);
    _jspx_th_impact_codeArray_14.setCodeName("CCOUNT14");
    _jspx_th_impact_codeArray_14.setArrayName("facCounty14");
    _jspx_th_impact_codeArray_14.setBlankValue("true");
    int _jspx_eval_impact_codeArray_14 = _jspx_th_impact_codeArray_14.doStartTag();
    if (_jspx_th_impact_codeArray_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_15.setParent(null);
    _jspx_th_impact_codeArray_15.setCodeName("CCOUNT15");
    _jspx_th_impact_codeArray_15.setArrayName("facCounty15");
    _jspx_th_impact_codeArray_15.setBlankValue("true");
    int _jspx_eval_impact_codeArray_15 = _jspx_th_impact_codeArray_15.doStartTag();
    if (_jspx_th_impact_codeArray_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_16.setParent(null);
    _jspx_th_impact_codeArray_16.setCodeName("CCOUNT97");
    _jspx_th_impact_codeArray_16.setArrayName("facCounty97");
    _jspx_th_impact_codeArray_16.setBlankValue("true");
    int _jspx_eval_impact_codeArray_16 = _jspx_th_impact_codeArray_16.doStartTag();
    if (_jspx_th_impact_codeArray_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_17(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_17.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_17.setParent(null);
    _jspx_th_impact_codeArray_17.setCodeName("CSVCCODE");
    _jspx_th_impact_codeArray_17.setArrayName("finService");
    _jspx_th_impact_codeArray_17.setBlankValue("true");
    int _jspx_eval_impact_codeArray_17 = _jspx_th_impact_codeArray_17.doStartTag();
    if (_jspx_th_impact_codeArray_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_18(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_18.setParent(null);
    _jspx_th_impact_codeArray_18.setCodeName("CSVCCODE252");
    _jspx_th_impact_codeArray_18.setArrayName("finService252");
    _jspx_th_impact_codeArray_18.setBlankValue("true");
    int _jspx_eval_impact_codeArray_18 = _jspx_th_impact_codeArray_18.doStartTag();
    if (_jspx_th_impact_codeArray_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_19(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_19.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_19.setParent(null);
    _jspx_th_impact_codeArray_19.setCodeName("CSVCCODE253");
    _jspx_th_impact_codeArray_19.setArrayName("finService253");
    _jspx_th_impact_codeArray_19.setBlankValue("true");
    int _jspx_eval_impact_codeArray_19 = _jspx_th_impact_codeArray_19.doStartTag();
    if (_jspx_th_impact_codeArray_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_20(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_20.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_20.setParent(null);
    _jspx_th_impact_codeArray_20.setCodeName("CSVCCODE450");
    _jspx_th_impact_codeArray_20.setArrayName("finService450");
    _jspx_th_impact_codeArray_20.setBlankValue("true");
    int _jspx_eval_impact_codeArray_20 = _jspx_th_impact_codeArray_20.doStartTag();
    if (_jspx_th_impact_codeArray_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_21(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_21.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_21.setParent(null);
    _jspx_th_impact_codeArray_21.setCodeName("CSVCCODE460");
    _jspx_th_impact_codeArray_21.setArrayName("finService460");
    _jspx_th_impact_codeArray_21.setBlankValue("true");
    int _jspx_eval_impact_codeArray_21 = _jspx_th_impact_codeArray_21.doStartTag();
    if (_jspx_th_impact_codeArray_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_22(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_22.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_22.setParent(null);
    _jspx_th_impact_codeArray_22.setCodeName("CSVCCODE501");
    _jspx_th_impact_codeArray_22.setArrayName("finService501");
    _jspx_th_impact_codeArray_22.setBlankValue("true");
    int _jspx_eval_impact_codeArray_22 = _jspx_th_impact_codeArray_22.doStartTag();
    if (_jspx_th_impact_codeArray_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_23(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_23.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_23.setParent(null);
    _jspx_th_impact_codeArray_23.setCodeName("CSVCCODE502");
    _jspx_th_impact_codeArray_23.setArrayName("finService502");
    _jspx_th_impact_codeArray_23.setBlankValue("true");
    int _jspx_eval_impact_codeArray_23 = _jspx_th_impact_codeArray_23.doStartTag();
    if (_jspx_th_impact_codeArray_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_24(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_24.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_24.setParent(null);
    _jspx_th_impact_codeArray_24.setCodeName("CSVCCODE503");
    _jspx_th_impact_codeArray_24.setArrayName("finService503");
    _jspx_th_impact_codeArray_24.setBlankValue("true");
    int _jspx_eval_impact_codeArray_24 = _jspx_th_impact_codeArray_24.doStartTag();
    if (_jspx_th_impact_codeArray_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_25(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_25.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_25.setParent(null);
    _jspx_th_impact_codeArray_25.setCodeName("CSVCCODE504");
    _jspx_th_impact_codeArray_25.setArrayName("finService504");
    _jspx_th_impact_codeArray_25.setBlankValue("true");
    int _jspx_eval_impact_codeArray_25 = _jspx_th_impact_codeArray_25.doStartTag();
    if (_jspx_th_impact_codeArray_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_26(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_26.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_26.setParent(null);
    _jspx_th_impact_codeArray_26.setCodeName("CSVCCODE505");
    _jspx_th_impact_codeArray_26.setArrayName("finService505");
    _jspx_th_impact_codeArray_26.setBlankValue("true");
    int _jspx_eval_impact_codeArray_26 = _jspx_th_impact_codeArray_26.doStartTag();
    if (_jspx_th_impact_codeArray_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_27(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_27.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_27.setParent(null);
    _jspx_th_impact_codeArray_27.setCodeName("CSVCCODE506");
    _jspx_th_impact_codeArray_27.setArrayName("finService506");
    _jspx_th_impact_codeArray_27.setBlankValue("true");
    int _jspx_eval_impact_codeArray_27 = _jspx_th_impact_codeArray_27.doStartTag();
    if (_jspx_th_impact_codeArray_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_28(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_28.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_28.setParent(null);
    _jspx_th_impact_codeArray_28.setCodeName("CSVCCODE507");
    _jspx_th_impact_codeArray_28.setArrayName("finService507");
    _jspx_th_impact_codeArray_28.setBlankValue("true");
    int _jspx_eval_impact_codeArray_28 = _jspx_th_impact_codeArray_28.doStartTag();
    if (_jspx_th_impact_codeArray_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_29(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_29.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_29.setParent(null);
    _jspx_th_impact_codeArray_29.setCodeName("CSVCCODE508");
    _jspx_th_impact_codeArray_29.setArrayName("finService508");
    _jspx_th_impact_codeArray_29.setBlankValue("true");
    int _jspx_eval_impact_codeArray_29 = _jspx_th_impact_codeArray_29.doStartTag();
    if (_jspx_th_impact_codeArray_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_30(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_30.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_30.setParent(null);
    _jspx_th_impact_codeArray_30.setCodeName("CSVCCODE509");
    _jspx_th_impact_codeArray_30.setArrayName("finService509");
    _jspx_th_impact_codeArray_30.setBlankValue("true");
    int _jspx_eval_impact_codeArray_30 = _jspx_th_impact_codeArray_30.doStartTag();
    if (_jspx_th_impact_codeArray_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_31(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_31.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_31.setParent(null);
    _jspx_th_impact_codeArray_31.setCodeName("CSVCCODE510");
    _jspx_th_impact_codeArray_31.setArrayName("finService510");
    _jspx_th_impact_codeArray_31.setBlankValue("true");
    int _jspx_eval_impact_codeArray_31 = _jspx_th_impact_codeArray_31.doStartTag();
    if (_jspx_th_impact_codeArray_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_32(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_32.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_32.setParent(null);
    _jspx_th_impact_codeArray_32.setCodeName("CSVCCODE511");
    _jspx_th_impact_codeArray_32.setArrayName("finService511");
    _jspx_th_impact_codeArray_32.setBlankValue("true");
    int _jspx_eval_impact_codeArray_32 = _jspx_th_impact_codeArray_32.doStartTag();
    if (_jspx_th_impact_codeArray_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_33(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_33.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_33.setParent(null);
    _jspx_th_impact_codeArray_33.setCodeName("CSVCCODE512");
    _jspx_th_impact_codeArray_33.setArrayName("finService512");
    _jspx_th_impact_codeArray_33.setBlankValue("true");
    int _jspx_eval_impact_codeArray_33 = _jspx_th_impact_codeArray_33.doStartTag();
    if (_jspx_th_impact_codeArray_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_34(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_34.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_34.setParent(null);
    _jspx_th_impact_codeArray_34.setCodeName("CSVCCODE513");
    _jspx_th_impact_codeArray_34.setArrayName("finService513");
    _jspx_th_impact_codeArray_34.setBlankValue("true");
    int _jspx_eval_impact_codeArray_34 = _jspx_th_impact_codeArray_34.doStartTag();
    if (_jspx_th_impact_codeArray_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_35(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_35.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_35.setParent(null);
    _jspx_th_impact_codeArray_35.setCodeName("CSVCCODE515");
    _jspx_th_impact_codeArray_35.setArrayName("finService515");
    _jspx_th_impact_codeArray_35.setBlankValue("true");
    int _jspx_eval_impact_codeArray_35 = _jspx_th_impact_codeArray_35.doStartTag();
    if (_jspx_th_impact_codeArray_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_36(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_36.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_36.setParent(null);
    _jspx_th_impact_codeArray_36.setCodeName("CSVCCODE518");
    _jspx_th_impact_codeArray_36.setArrayName("finService518");
    _jspx_th_impact_codeArray_36.setBlankValue("true");
    int _jspx_eval_impact_codeArray_36 = _jspx_th_impact_codeArray_36.doStartTag();
    if (_jspx_th_impact_codeArray_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_37(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_37.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_37.setParent(null);
    _jspx_th_impact_codeArray_37.setCodeName("CSVCCODE520");
    _jspx_th_impact_codeArray_37.setArrayName("finService520");
    _jspx_th_impact_codeArray_37.setBlankValue("true");
    int _jspx_eval_impact_codeArray_37 = _jspx_th_impact_codeArray_37.doStartTag();
    if (_jspx_th_impact_codeArray_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_38(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_38.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_38.setParent(null);
    _jspx_th_impact_codeArray_38.setCodeName("CSVCCODE521");
    _jspx_th_impact_codeArray_38.setArrayName("finService521");
    _jspx_th_impact_codeArray_38.setBlankValue("true");
    int _jspx_eval_impact_codeArray_38 = _jspx_th_impact_codeArray_38.doStartTag();
    if (_jspx_th_impact_codeArray_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_39(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_39.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_39.setParent(null);
    _jspx_th_impact_codeArray_39.setCodeName("CSVCCODE522");
    _jspx_th_impact_codeArray_39.setArrayName("finService522");
    _jspx_th_impact_codeArray_39.setBlankValue("true");
    int _jspx_eval_impact_codeArray_39 = _jspx_th_impact_codeArray_39.doStartTag();
    if (_jspx_th_impact_codeArray_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_40(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_40.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_40.setParent(null);
    _jspx_th_impact_codeArray_40.setCodeName("CSVCCODE525");
    _jspx_th_impact_codeArray_40.setArrayName("finService525");
    _jspx_th_impact_codeArray_40.setBlankValue("true");
    int _jspx_eval_impact_codeArray_40 = _jspx_th_impact_codeArray_40.doStartTag();
    if (_jspx_th_impact_codeArray_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_41(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_41.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_41.setParent(null);
    _jspx_th_impact_codeArray_41.setCodeName("CSVCCODE529");
    _jspx_th_impact_codeArray_41.setArrayName("finService529");
    _jspx_th_impact_codeArray_41.setBlankValue("true");
    int _jspx_eval_impact_codeArray_41 = _jspx_th_impact_codeArray_41.doStartTag();
    if (_jspx_th_impact_codeArray_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_42(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_42.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_42.setParent(null);
    _jspx_th_impact_codeArray_42.setCodeName("CSVCCODE530");
    _jspx_th_impact_codeArray_42.setArrayName("finService530");
    _jspx_th_impact_codeArray_42.setBlankValue("true");
    int _jspx_eval_impact_codeArray_42 = _jspx_th_impact_codeArray_42.doStartTag();
    if (_jspx_th_impact_codeArray_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_43(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_43.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_43.setParent(null);
    _jspx_th_impact_codeArray_43.setCodeName("CSVCCODE531");
    _jspx_th_impact_codeArray_43.setArrayName("finService531");
    _jspx_th_impact_codeArray_43.setBlankValue("true");
    int _jspx_eval_impact_codeArray_43 = _jspx_th_impact_codeArray_43.doStartTag();
    if (_jspx_th_impact_codeArray_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_44(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_44.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_44.setParent(null);
    _jspx_th_impact_codeArray_44.setCodeName("CSVCCODE542");
    _jspx_th_impact_codeArray_44.setArrayName("finService542");
    _jspx_th_impact_codeArray_44.setBlankValue("true");
    int _jspx_eval_impact_codeArray_44 = _jspx_th_impact_codeArray_44.doStartTag();
    if (_jspx_th_impact_codeArray_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_45(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_45.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_45.setParent(null);
    _jspx_th_impact_codeArray_45.setCodeName("CSVCCODE547");
    _jspx_th_impact_codeArray_45.setArrayName("finService547");
    _jspx_th_impact_codeArray_45.setBlankValue("true");
    int _jspx_eval_impact_codeArray_45 = _jspx_th_impact_codeArray_45.doStartTag();
    if (_jspx_th_impact_codeArray_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_46(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_46.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_46.setParent(null);
    _jspx_th_impact_codeArray_46.setCodeName("CSVCCODE550");
    _jspx_th_impact_codeArray_46.setArrayName("finService550");
    _jspx_th_impact_codeArray_46.setBlankValue("true");
    int _jspx_eval_impact_codeArray_46 = _jspx_th_impact_codeArray_46.doStartTag();
    if (_jspx_th_impact_codeArray_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_47(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_47.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_47.setParent(null);
    _jspx_th_impact_codeArray_47.setCodeName("CSVCCODE551");
    _jspx_th_impact_codeArray_47.setArrayName("finService551");
    _jspx_th_impact_codeArray_47.setBlankValue("true");
    int _jspx_eval_impact_codeArray_47 = _jspx_th_impact_codeArray_47.doStartTag();
    if (_jspx_th_impact_codeArray_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_48(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_48.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_48.setParent(null);
    _jspx_th_impact_codeArray_48.setCodeName("CSVCCODE552");
    _jspx_th_impact_codeArray_48.setArrayName("finService552");
    _jspx_th_impact_codeArray_48.setBlankValue("true");
    int _jspx_eval_impact_codeArray_48 = _jspx_th_impact_codeArray_48.doStartTag();
    if (_jspx_th_impact_codeArray_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_49(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_49.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_49.setParent(null);
    _jspx_th_impact_codeArray_49.setCodeName("CSVCCODE553");
    _jspx_th_impact_codeArray_49.setArrayName("finService553");
    _jspx_th_impact_codeArray_49.setBlankValue("true");
    int _jspx_eval_impact_codeArray_49 = _jspx_th_impact_codeArray_49.doStartTag();
    if (_jspx_th_impact_codeArray_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_50(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_50.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_50.setParent(null);
    _jspx_th_impact_codeArray_50.setCodeName("CSVCCODE560");
    _jspx_th_impact_codeArray_50.setArrayName("finService560");
    _jspx_th_impact_codeArray_50.setBlankValue("true");
    int _jspx_eval_impact_codeArray_50 = _jspx_th_impact_codeArray_50.doStartTag();
    if (_jspx_th_impact_codeArray_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_51(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_51.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_51.setParent(null);
    _jspx_th_impact_codeArray_51.setCodeName("CSVCCODE561");
    _jspx_th_impact_codeArray_51.setArrayName("finService561");
    _jspx_th_impact_codeArray_51.setBlankValue("true");
    int _jspx_eval_impact_codeArray_51 = _jspx_th_impact_codeArray_51.doStartTag();
    if (_jspx_th_impact_codeArray_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_52(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_52.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_52.setParent(null);
    _jspx_th_impact_codeArray_52.setCodeName("CSVCCODE563");
    _jspx_th_impact_codeArray_52.setArrayName("finService563");
    _jspx_th_impact_codeArray_52.setBlankValue("true");
    int _jspx_eval_impact_codeArray_52 = _jspx_th_impact_codeArray_52.doStartTag();
    if (_jspx_th_impact_codeArray_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_53(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_53.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_53.setParent(null);
    _jspx_th_impact_codeArray_53.setCodeName("CSVCCODE564");
    _jspx_th_impact_codeArray_53.setArrayName("finService564");
    _jspx_th_impact_codeArray_53.setBlankValue("true");
    int _jspx_eval_impact_codeArray_53 = _jspx_th_impact_codeArray_53.doStartTag();
    if (_jspx_th_impact_codeArray_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_54(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_54.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_54.setParent(null);
    _jspx_th_impact_codeArray_54.setCodeName("CSVCCODE565");
    _jspx_th_impact_codeArray_54.setArrayName("finService565");
    _jspx_th_impact_codeArray_54.setBlankValue("true");
    int _jspx_eval_impact_codeArray_54 = _jspx_th_impact_codeArray_54.doStartTag();
    if (_jspx_th_impact_codeArray_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_55(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_55.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_55.setParent(null);
    _jspx_th_impact_codeArray_55.setCodeName("CSVCCODE571");
    _jspx_th_impact_codeArray_55.setArrayName("finService571");
    _jspx_th_impact_codeArray_55.setBlankValue("true");
    int _jspx_eval_impact_codeArray_55 = _jspx_th_impact_codeArray_55.doStartTag();
    if (_jspx_th_impact_codeArray_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_56(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_56.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_56.setParent(null);
    _jspx_th_impact_codeArray_56.setCodeName("CSVCCODE573");
    _jspx_th_impact_codeArray_56.setArrayName("finService573");
    _jspx_th_impact_codeArray_56.setBlankValue("true");
    int _jspx_eval_impact_codeArray_56 = _jspx_th_impact_codeArray_56.doStartTag();
    if (_jspx_th_impact_codeArray_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_57(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_57.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_57.setParent(null);
    _jspx_th_impact_codeArray_57.setCodeName("CSVCCODE574");
    _jspx_th_impact_codeArray_57.setArrayName("finService574");
    _jspx_th_impact_codeArray_57.setBlankValue("true");
    int _jspx_eval_impact_codeArray_57 = _jspx_th_impact_codeArray_57.doStartTag();
    if (_jspx_th_impact_codeArray_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_58(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_58.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_58.setParent(null);
    _jspx_th_impact_codeArray_58.setCodeName("CSVCCODE575");
    _jspx_th_impact_codeArray_58.setArrayName("finService575");
    _jspx_th_impact_codeArray_58.setBlankValue("true");
    int _jspx_eval_impact_codeArray_58 = _jspx_th_impact_codeArray_58.doStartTag();
    if (_jspx_th_impact_codeArray_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_59(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_59.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_59.setParent(null);
    _jspx_th_impact_codeArray_59.setCodeName("CSVCCODE576");
    _jspx_th_impact_codeArray_59.setArrayName("finService576");
    _jspx_th_impact_codeArray_59.setBlankValue("true");
    int _jspx_eval_impact_codeArray_59 = _jspx_th_impact_codeArray_59.doStartTag();
    if (_jspx_th_impact_codeArray_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_60(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_60.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_60.setParent(null);
    _jspx_th_impact_codeArray_60.setCodeName("CSVCCODE577");
    _jspx_th_impact_codeArray_60.setArrayName("finService577");
    _jspx_th_impact_codeArray_60.setBlankValue("true");
    int _jspx_eval_impact_codeArray_60 = _jspx_th_impact_codeArray_60.doStartTag();
    if (_jspx_th_impact_codeArray_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_61(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_61.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_61.setParent(null);
    _jspx_th_impact_codeArray_61.setCodeName("CSVCCODE578");
    _jspx_th_impact_codeArray_61.setArrayName("finService578");
    _jspx_th_impact_codeArray_61.setBlankValue("true");
    int _jspx_eval_impact_codeArray_61 = _jspx_th_impact_codeArray_61.doStartTag();
    if (_jspx_th_impact_codeArray_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_62(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_62.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_62.setParent(null);
    _jspx_th_impact_codeArray_62.setCodeName("CSVCCODE579");
    _jspx_th_impact_codeArray_62.setArrayName("finService579");
    _jspx_th_impact_codeArray_62.setBlankValue("true");
    int _jspx_eval_impact_codeArray_62 = _jspx_th_impact_codeArray_62.doStartTag();
    if (_jspx_th_impact_codeArray_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_63(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_63.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_63.setParent(null);
    _jspx_th_impact_codeArray_63.setCodeName("CSVCCODE582");
    _jspx_th_impact_codeArray_63.setArrayName("finService582");
    _jspx_th_impact_codeArray_63.setBlankValue("true");
    int _jspx_eval_impact_codeArray_63 = _jspx_th_impact_codeArray_63.doStartTag();
    if (_jspx_th_impact_codeArray_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_64(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_64 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_64.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_64.setParent(null);
    _jspx_th_impact_codeArray_64.setCodeName("CSVCCODE583");
    _jspx_th_impact_codeArray_64.setArrayName("finService583");
    _jspx_th_impact_codeArray_64.setBlankValue("true");
    int _jspx_eval_impact_codeArray_64 = _jspx_th_impact_codeArray_64.doStartTag();
    if (_jspx_th_impact_codeArray_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_65(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_65 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_65.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_65.setParent(null);
    _jspx_th_impact_codeArray_65.setCodeName("CSVCCODE584");
    _jspx_th_impact_codeArray_65.setArrayName("finService584");
    _jspx_th_impact_codeArray_65.setBlankValue("true");
    int _jspx_eval_impact_codeArray_65 = _jspx_th_impact_codeArray_65.doStartTag();
    if (_jspx_th_impact_codeArray_65.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_66(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_66 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_66.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_66.setParent(null);
    _jspx_th_impact_codeArray_66.setCodeName("CSVCCODE585");
    _jspx_th_impact_codeArray_66.setArrayName("finService585");
    _jspx_th_impact_codeArray_66.setBlankValue("true");
    int _jspx_eval_impact_codeArray_66 = _jspx_th_impact_codeArray_66.doStartTag();
    if (_jspx_th_impact_codeArray_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_67(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_67 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_67.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_67.setParent(null);
    _jspx_th_impact_codeArray_67.setCodeName("CSVCCODE586");
    _jspx_th_impact_codeArray_67.setArrayName("finService586");
    _jspx_th_impact_codeArray_67.setBlankValue("true");
    int _jspx_eval_impact_codeArray_67 = _jspx_th_impact_codeArray_67.doStartTag();
    if (_jspx_th_impact_codeArray_67.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_68(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_68 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_68.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_68.setParent(null);
    _jspx_th_impact_codeArray_68.setCodeName("CSVCCODE587");
    _jspx_th_impact_codeArray_68.setArrayName("finService587");
    _jspx_th_impact_codeArray_68.setBlankValue("true");
    int _jspx_eval_impact_codeArray_68 = _jspx_th_impact_codeArray_68.doStartTag();
    if (_jspx_th_impact_codeArray_68.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_69(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_69 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_69.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_69.setParent(null);
    _jspx_th_impact_codeArray_69.setCodeName("CSVCCODE588");
    _jspx_th_impact_codeArray_69.setArrayName("finService588");
    _jspx_th_impact_codeArray_69.setBlankValue("true");
    int _jspx_eval_impact_codeArray_69 = _jspx_th_impact_codeArray_69.doStartTag();
    if (_jspx_th_impact_codeArray_69.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_70(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_70 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_70.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_70.setParent(null);
    _jspx_th_impact_codeArray_70.setCodeName("CSVCCODE591");
    _jspx_th_impact_codeArray_70.setArrayName("finService591");
    _jspx_th_impact_codeArray_70.setBlankValue("true");
    int _jspx_eval_impact_codeArray_70 = _jspx_th_impact_codeArray_70.doStartTag();
    if (_jspx_th_impact_codeArray_70.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_71(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_71 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_71.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_71.setParent(null);
    _jspx_th_impact_codeArray_71.setCodeName("CSVCCODE595");
    _jspx_th_impact_codeArray_71.setArrayName("finService595");
    _jspx_th_impact_codeArray_71.setBlankValue("true");
    int _jspx_eval_impact_codeArray_71 = _jspx_th_impact_codeArray_71.doStartTag();
    if (_jspx_th_impact_codeArray_71.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_72(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_72 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_72.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_72.setParent(null);
    _jspx_th_impact_codeArray_72.setCodeName("CSVCCODE596");
    _jspx_th_impact_codeArray_72.setArrayName("finService596");
    _jspx_th_impact_codeArray_72.setBlankValue("true");
    int _jspx_eval_impact_codeArray_72 = _jspx_th_impact_codeArray_72.doStartTag();
    if (_jspx_th_impact_codeArray_72.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_73(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_73 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_73.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_73.setParent(null);
    _jspx_th_impact_codeArray_73.setCodeName("CSVCCODE597");
    _jspx_th_impact_codeArray_73.setArrayName("finService597");
    _jspx_th_impact_codeArray_73.setBlankValue("true");
    int _jspx_eval_impact_codeArray_73 = _jspx_th_impact_codeArray_73.doStartTag();
    if (_jspx_th_impact_codeArray_73.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_74(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_74 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_74.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_74.setParent(null);
    _jspx_th_impact_codeArray_74.setCodeName("CSVCCODE598");
    _jspx_th_impact_codeArray_74.setArrayName("finService598");
    _jspx_th_impact_codeArray_74.setBlankValue("true");
    int _jspx_eval_impact_codeArray_74 = _jspx_th_impact_codeArray_74.doStartTag();
    if (_jspx_th_impact_codeArray_74.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_75(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_75 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_75.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_75.setParent(null);
    _jspx_th_impact_codeArray_75.setCodeName("CSVCCODE604");
    _jspx_th_impact_codeArray_75.setArrayName("finService604");
    _jspx_th_impact_codeArray_75.setBlankValue("true");
    int _jspx_eval_impact_codeArray_75 = _jspx_th_impact_codeArray_75.doStartTag();
    if (_jspx_th_impact_codeArray_75.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_76(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_76 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_76.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_76.setParent(null);
    _jspx_th_impact_codeArray_76.setCodeName("CSVCCODE605");
    _jspx_th_impact_codeArray_76.setArrayName("finService605");
    _jspx_th_impact_codeArray_76.setBlankValue("true");
    int _jspx_eval_impact_codeArray_76 = _jspx_th_impact_codeArray_76.doStartTag();
    if (_jspx_th_impact_codeArray_76.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_77(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_77 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_77.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_77.setParent(null);
    _jspx_th_impact_codeArray_77.setCodeName("CSVCCODE606");
    _jspx_th_impact_codeArray_77.setArrayName("finService606");
    _jspx_th_impact_codeArray_77.setBlankValue("true");
    int _jspx_eval_impact_codeArray_77 = _jspx_th_impact_codeArray_77.doStartTag();
    if (_jspx_th_impact_codeArray_77.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_78(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_78 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_78.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_78.setParent(null);
    _jspx_th_impact_codeArray_78.setCodeName("CSVCCODE607");
    _jspx_th_impact_codeArray_78.setArrayName("finService607");
    _jspx_th_impact_codeArray_78.setBlankValue("true");
    int _jspx_eval_impact_codeArray_78 = _jspx_th_impact_codeArray_78.doStartTag();
    if (_jspx_th_impact_codeArray_78.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_79(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_79 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_79.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_79.setParent(null);
    _jspx_th_impact_codeArray_79.setCodeName("CSVCCODE608");
    _jspx_th_impact_codeArray_79.setArrayName("finService608");
    _jspx_th_impact_codeArray_79.setBlankValue("true");
    int _jspx_eval_impact_codeArray_79 = _jspx_th_impact_codeArray_79.doStartTag();
    if (_jspx_th_impact_codeArray_79.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_80(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_80 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_80.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_80.setParent(null);
    _jspx_th_impact_codeArray_80.setCodeName("CSVCCODE609");
    _jspx_th_impact_codeArray_80.setArrayName("finService609");
    _jspx_th_impact_codeArray_80.setBlankValue("true");
    int _jspx_eval_impact_codeArray_80 = _jspx_th_impact_codeArray_80.doStartTag();
    if (_jspx_th_impact_codeArray_80.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_81(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_81 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_81.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_81.setParent(null);
    _jspx_th_impact_codeArray_81.setCodeName("CSVCCODE610");
    _jspx_th_impact_codeArray_81.setArrayName("finService610");
    _jspx_th_impact_codeArray_81.setBlankValue("true");
    int _jspx_eval_impact_codeArray_81 = _jspx_th_impact_codeArray_81.doStartTag();
    if (_jspx_th_impact_codeArray_81.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_82(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_82 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_82.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_82.setParent(null);
    _jspx_th_impact_codeArray_82.setCodeName("CSVCCODE611");
    _jspx_th_impact_codeArray_82.setArrayName("finService611");
    _jspx_th_impact_codeArray_82.setBlankValue("true");
    int _jspx_eval_impact_codeArray_82 = _jspx_th_impact_codeArray_82.doStartTag();
    if (_jspx_th_impact_codeArray_82.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_83(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_83 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_83.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_83.setParent(null);
    _jspx_th_impact_codeArray_83.setCodeName("CSVCCODE612");
    _jspx_th_impact_codeArray_83.setArrayName("finService612");
    _jspx_th_impact_codeArray_83.setBlankValue("true");
    int _jspx_eval_impact_codeArray_83 = _jspx_th_impact_codeArray_83.doStartTag();
    if (_jspx_th_impact_codeArray_83.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_84(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_84 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_84.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_84.setParent(null);
    _jspx_th_impact_codeArray_84.setCodeName("CSVCCODE613");
    _jspx_th_impact_codeArray_84.setArrayName("finService613");
    _jspx_th_impact_codeArray_84.setBlankValue("true");
    int _jspx_eval_impact_codeArray_84 = _jspx_th_impact_codeArray_84.doStartTag();
    if (_jspx_th_impact_codeArray_84.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_85(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_85 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_85.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_85.setParent(null);
    _jspx_th_impact_codeArray_85.setCodeName("CSVCCODE614");
    _jspx_th_impact_codeArray_85.setArrayName("finService614");
    _jspx_th_impact_codeArray_85.setBlankValue("true");
    int _jspx_eval_impact_codeArray_85 = _jspx_th_impact_codeArray_85.doStartTag();
    if (_jspx_th_impact_codeArray_85.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_86(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_86 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_86.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_86.setParent(null);
    _jspx_th_impact_codeArray_86.setCodeName("CSVCCODE615");
    _jspx_th_impact_codeArray_86.setArrayName("finService615");
    _jspx_th_impact_codeArray_86.setBlankValue("true");
    int _jspx_eval_impact_codeArray_86 = _jspx_th_impact_codeArray_86.doStartTag();
    if (_jspx_th_impact_codeArray_86.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_87(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_87 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_87.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_87.setParent(null);
    _jspx_th_impact_codeArray_87.setCodeName("CSVCCODE616");
    _jspx_th_impact_codeArray_87.setArrayName("finService616");
    _jspx_th_impact_codeArray_87.setBlankValue("true");
    int _jspx_eval_impact_codeArray_87 = _jspx_th_impact_codeArray_87.doStartTag();
    if (_jspx_th_impact_codeArray_87.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_88(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_88 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_88.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_88.setParent(null);
    _jspx_th_impact_codeArray_88.setCodeName("CSVCCODE617");
    _jspx_th_impact_codeArray_88.setArrayName("finService617");
    _jspx_th_impact_codeArray_88.setBlankValue("true");
    int _jspx_eval_impact_codeArray_88 = _jspx_th_impact_codeArray_88.doStartTag();
    if (_jspx_th_impact_codeArray_88.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_89(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_89 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_89.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_89.setParent(null);
    _jspx_th_impact_codeArray_89.setCodeName("CSVCCODE618");
    _jspx_th_impact_codeArray_89.setArrayName("finService618");
    _jspx_th_impact_codeArray_89.setBlankValue("true");
    int _jspx_eval_impact_codeArray_89 = _jspx_th_impact_codeArray_89.doStartTag();
    if (_jspx_th_impact_codeArray_89.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_90(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_90 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_90.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_90.setParent(null);
    _jspx_th_impact_codeArray_90.setCodeName("CSVCCODE619");
    _jspx_th_impact_codeArray_90.setArrayName("finService619");
    _jspx_th_impact_codeArray_90.setBlankValue("true");
    int _jspx_eval_impact_codeArray_90 = _jspx_th_impact_codeArray_90.doStartTag();
    if (_jspx_th_impact_codeArray_90.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_91(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_91 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_91.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_91.setParent(null);
    _jspx_th_impact_codeArray_91.setCodeName("CSVCCODE620");
    _jspx_th_impact_codeArray_91.setArrayName("finService620");
    _jspx_th_impact_codeArray_91.setBlankValue("true");
    int _jspx_eval_impact_codeArray_91 = _jspx_th_impact_codeArray_91.doStartTag();
    if (_jspx_th_impact_codeArray_91.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_92(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_92 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_92.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_92.setParent(null);
    _jspx_th_impact_codeArray_92.setCodeName("CSVCCODE698");
    _jspx_th_impact_codeArray_92.setArrayName("finService698");
    _jspx_th_impact_codeArray_92.setBlankValue("true");
    int _jspx_eval_impact_codeArray_92 = _jspx_th_impact_codeArray_92.doStartTag();
    if (_jspx_th_impact_codeArray_92.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_93(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_93 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_93.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_93.setParent(null);
    _jspx_th_impact_codeArray_93.setCodeName("CSVCCODE773");
    _jspx_th_impact_codeArray_93.setArrayName("finService773");
    _jspx_th_impact_codeArray_93.setBlankValue("true");
    int _jspx_eval_impact_codeArray_93 = _jspx_th_impact_codeArray_93.doStartTag();
    if (_jspx_th_impact_codeArray_93.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_94(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_94 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_94.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_94.setParent(null);
    _jspx_th_impact_codeArray_94.setCodeName("CSVCCODE774");
    _jspx_th_impact_codeArray_94.setArrayName("finService774");
    _jspx_th_impact_codeArray_94.setBlankValue("true");
    int _jspx_eval_impact_codeArray_94 = _jspx_th_impact_codeArray_94.doStartTag();
    if (_jspx_th_impact_codeArray_94.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_95(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_95 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_95.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_95.setParent(null);
    _jspx_th_impact_codeArray_95.setCodeName("CSVCCODE783");
    _jspx_th_impact_codeArray_95.setArrayName("finService783");
    _jspx_th_impact_codeArray_95.setBlankValue("true");
    int _jspx_eval_impact_codeArray_95 = _jspx_th_impact_codeArray_95.doStartTag();
    if (_jspx_th_impact_codeArray_95.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_96(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_96 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_96.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_96.setParent(null);
    _jspx_th_impact_codeArray_96.setCodeName("CSVCCODE784");
    _jspx_th_impact_codeArray_96.setArrayName("finService784");
    _jspx_th_impact_codeArray_96.setBlankValue("true");
    int _jspx_eval_impact_codeArray_96 = _jspx_th_impact_codeArray_96.doStartTag();
    if (_jspx_th_impact_codeArray_96.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_97(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_97 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_97.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_97.setParent(null);
    _jspx_th_impact_codeArray_97.setCodeName("CSVCCODE873");
    _jspx_th_impact_codeArray_97.setArrayName("finService873");
    _jspx_th_impact_codeArray_97.setBlankValue("true");
    int _jspx_eval_impact_codeArray_97 = _jspx_th_impact_codeArray_97.doStartTag();
    if (_jspx_th_impact_codeArray_97.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_98(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_98 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_98.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_98.setParent(null);
    _jspx_th_impact_codeArray_98.setCodeName("CSVCCODE874");
    _jspx_th_impact_codeArray_98.setArrayName("finService874");
    _jspx_th_impact_codeArray_98.setBlankValue("true");
    int _jspx_eval_impact_codeArray_98 = _jspx_th_impact_codeArray_98.doStartTag();
    if (_jspx_th_impact_codeArray_98.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_99(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_99 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_99.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_99.setParent(null);
    _jspx_th_impact_codeArray_99.setCodeName("CSVCCODE883");
    _jspx_th_impact_codeArray_99.setArrayName("finService883");
    _jspx_th_impact_codeArray_99.setBlankValue("true");
    int _jspx_eval_impact_codeArray_99 = _jspx_th_impact_codeArray_99.doStartTag();
    if (_jspx_th_impact_codeArray_99.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_100(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_100 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_100.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_100.setParent(null);
    _jspx_th_impact_codeArray_100.setCodeName("CSVCCODE884");
    _jspx_th_impact_codeArray_100.setArrayName("finService884");
    _jspx_th_impact_codeArray_100.setBlankValue("true");
    int _jspx_eval_impact_codeArray_100 = _jspx_th_impact_codeArray_100.doStartTag();
    if (_jspx_th_impact_codeArray_100.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_101(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_101 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_101.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_101.setParent(null);
    _jspx_th_impact_codeArray_101.setCodeName("CGLSVCCD");
    _jspx_th_impact_codeArray_101.setArrayName("genService");
    _jspx_th_impact_codeArray_101.setBlankValue("true");
    int _jspx_eval_impact_codeArray_101 = _jspx_th_impact_codeArray_101.doStartTag();
    if (_jspx_th_impact_codeArray_101.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_102(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_102 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_102.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_102.setParent(null);
    _jspx_th_impact_codeArray_102.setCodeName("CGLSVCCD01");
    _jspx_th_impact_codeArray_102.setArrayName("genService01");
    _jspx_th_impact_codeArray_102.setBlankValue("true");
    int _jspx_eval_impact_codeArray_102 = _jspx_th_impact_codeArray_102.doStartTag();
    if (_jspx_th_impact_codeArray_102.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_103(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_103 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_103.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_103.setParent(null);
    _jspx_th_impact_codeArray_103.setCodeName("CGLSVCCD02");
    _jspx_th_impact_codeArray_103.setArrayName("genService02");
    _jspx_th_impact_codeArray_103.setBlankValue("true");
    int _jspx_eval_impact_codeArray_103 = _jspx_th_impact_codeArray_103.doStartTag();
    if (_jspx_th_impact_codeArray_103.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_104(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_104 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_104.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_104.setParent(null);
    _jspx_th_impact_codeArray_104.setCodeName("CGLSVCCD03");
    _jspx_th_impact_codeArray_104.setArrayName("genService03");
    _jspx_th_impact_codeArray_104.setBlankValue("true");
    int _jspx_eval_impact_codeArray_104 = _jspx_th_impact_codeArray_104.doStartTag();
    if (_jspx_th_impact_codeArray_104.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_105(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_105 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_105.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_105.setParent(null);
    _jspx_th_impact_codeArray_105.setCodeName("CGLSVCCD04");
    _jspx_th_impact_codeArray_105.setArrayName("genService04");
    _jspx_th_impact_codeArray_105.setBlankValue("true");
    int _jspx_eval_impact_codeArray_105 = _jspx_th_impact_codeArray_105.doStartTag();
    if (_jspx_th_impact_codeArray_105.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_106(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_106 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_106.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_106.setParent(null);
    _jspx_th_impact_codeArray_106.setCodeName("CGLSVCCD05");
    _jspx_th_impact_codeArray_106.setArrayName("genService05");
    _jspx_th_impact_codeArray_106.setBlankValue("true");
    int _jspx_eval_impact_codeArray_106 = _jspx_th_impact_codeArray_106.doStartTag();
    if (_jspx_th_impact_codeArray_106.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_107(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_107 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_107.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_107.setParent(null);
    _jspx_th_impact_codeArray_107.setCodeName("CGLSVCCD06");
    _jspx_th_impact_codeArray_107.setArrayName("genService06");
    _jspx_th_impact_codeArray_107.setBlankValue("true");
    int _jspx_eval_impact_codeArray_107 = _jspx_th_impact_codeArray_107.doStartTag();
    if (_jspx_th_impact_codeArray_107.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_108(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_108 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_108.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_108.setParent(null);
    _jspx_th_impact_codeArray_108.setCodeName("CGLSVCCD07");
    _jspx_th_impact_codeArray_108.setArrayName("genService07");
    _jspx_th_impact_codeArray_108.setBlankValue("true");
    int _jspx_eval_impact_codeArray_108 = _jspx_th_impact_codeArray_108.doStartTag();
    if (_jspx_th_impact_codeArray_108.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_109(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_109 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_109.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_109.setParent(null);
    _jspx_th_impact_codeArray_109.setCodeName("CGLSVCCD08");
    _jspx_th_impact_codeArray_109.setArrayName("genService08");
    _jspx_th_impact_codeArray_109.setBlankValue("true");
    int _jspx_eval_impact_codeArray_109 = _jspx_th_impact_codeArray_109.doStartTag();
    if (_jspx_th_impact_codeArray_109.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_110(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_110 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_110.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_110.setParent(null);
    _jspx_th_impact_codeArray_110.setCodeName("CGLSVCCD09");
    _jspx_th_impact_codeArray_110.setArrayName("genService09");
    _jspx_th_impact_codeArray_110.setBlankValue("true");
    int _jspx_eval_impact_codeArray_110 = _jspx_th_impact_codeArray_110.doStartTag();
    if (_jspx_th_impact_codeArray_110.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_111(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_111 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_111.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_111.setParent(null);
    _jspx_th_impact_codeArray_111.setCodeName("CGLSVCCD10");
    _jspx_th_impact_codeArray_111.setArrayName("genService10");
    _jspx_th_impact_codeArray_111.setBlankValue("true");
    int _jspx_eval_impact_codeArray_111 = _jspx_th_impact_codeArray_111.doStartTag();
    if (_jspx_th_impact_codeArray_111.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_112(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_112 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_112.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_112.setParent(null);
    _jspx_th_impact_codeArray_112.setCodeName("CGLSVCCD11");
    _jspx_th_impact_codeArray_112.setArrayName("genService11");
    _jspx_th_impact_codeArray_112.setBlankValue("true");
    int _jspx_eval_impact_codeArray_112 = _jspx_th_impact_codeArray_112.doStartTag();
    if (_jspx_th_impact_codeArray_112.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_113(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_113 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_113.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_113.setParent(null);
    _jspx_th_impact_codeArray_113.setCodeName("CGLSVCCD12");
    _jspx_th_impact_codeArray_113.setArrayName("genService12");
    _jspx_th_impact_codeArray_113.setBlankValue("true");
    int _jspx_eval_impact_codeArray_113 = _jspx_th_impact_codeArray_113.doStartTag();
    if (_jspx_th_impact_codeArray_113.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_114(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_114 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_114.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_114.setParent(null);
    _jspx_th_impact_codeArray_114.setCodeName("CGLSVCCD13");
    _jspx_th_impact_codeArray_114.setArrayName("genService13");
    _jspx_th_impact_codeArray_114.setBlankValue("true");
    int _jspx_eval_impact_codeArray_114 = _jspx_th_impact_codeArray_114.doStartTag();
    if (_jspx_th_impact_codeArray_114.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_115(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_115 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_115.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_115.setParent(null);
    _jspx_th_impact_codeArray_115.setCodeName("CGLSVCCD14");
    _jspx_th_impact_codeArray_115.setArrayName("genService14");
    _jspx_th_impact_codeArray_115.setBlankValue("true");
    int _jspx_eval_impact_codeArray_115 = _jspx_th_impact_codeArray_115.doStartTag();
    if (_jspx_th_impact_codeArray_115.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_116(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_116 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_116.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_116.setParent(null);
    _jspx_th_impact_codeArray_116.setCodeName("CGLSVCCD15");
    _jspx_th_impact_codeArray_116.setArrayName("genService15");
    _jspx_th_impact_codeArray_116.setBlankValue("true");
    int _jspx_eval_impact_codeArray_116 = _jspx_th_impact_codeArray_116.doStartTag();
    if (_jspx_th_impact_codeArray_116.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateErrors_0.setFormName("frmServiceDetail");
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
    _jspx_th_impact_validateInput_0.setName("validationOverride");
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
    _jspx_th_impact_validateInput_1.setName("allCounties");
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
    _jspx_th_impact_validateInput_2.setName("partCounties");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_0.setName("servicType");
    _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Service Type");
    int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
