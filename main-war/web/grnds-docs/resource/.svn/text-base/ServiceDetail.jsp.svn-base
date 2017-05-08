<%
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
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>

<%--Get the service row object from the request --%>
<jsp:useBean id="rowcres05sog00" class="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00" scope="request"/>
<%
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
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  //Get county code/decode array with all data
  <impact:codeArray codeName="CCOUNT" arrayName="facCounty" blankValue="true"/>
  //Get county code/decode array filtered for region 01
  <impact:codeArray codeName="CCOUNT01" arrayName="facCounty01" blankValue="true"/>
  //Get county code/decode array filtered for region 02
  <impact:codeArray codeName="CCOUNT02" arrayName="facCounty02" blankValue="true"/>
  //Get county code/decode array filtered for region 03A
  <impact:codeArray codeName="CCOUNT03" arrayName="facCounty03" blankValue="true"/>  
  //Get county code/decode array filtered for region 04
  <impact:codeArray codeName="CCOUNT04" arrayName="facCounty04" blankValue="true"/>
  //Get county code/decode array filtered for region 05
  <impact:codeArray codeName="CCOUNT05" arrayName="facCounty05" blankValue="true"/>
  //Get county code/decode array filtered for region 06
  <impact:codeArray codeName="CCOUNT06" arrayName="facCounty06" blankValue="true"/>
  //Get county code/decode array filtered for region 07
  <impact:codeArray codeName="CCOUNT07" arrayName="facCounty07" blankValue="true"/>
  //Get county code/decode array filtered for region 08
  <impact:codeArray codeName="CCOUNT08" arrayName="facCounty08" blankValue="true"/>
  //Get county code/decode array filtered for region 09
  <impact:codeArray codeName="CCOUNT09" arrayName="facCounty09" blankValue="true"/>
  //Get county code/decode array filtered for region 10
  <impact:codeArray codeName="CCOUNT10" arrayName="facCounty10" blankValue="true"/>
  //Get county code/decode array filtered for region 11
  <impact:codeArray codeName="CCOUNT11" arrayName="facCounty11" blankValue="true"/>
  //Get county code/decode array filtered for region 12
  <impact:codeArray codeName="CCOUNT12" arrayName="facCounty12" blankValue="true"/>
  //Get county code/decode array filtered for region 13
  <impact:codeArray codeName="CCOUNT13" arrayName="facCounty13" blankValue="true"/>
  //Get county code/decode array filtered for region 14
  <impact:codeArray codeName="CCOUNT14" arrayName="facCounty14" blankValue="true"/>
  //Get county code/decode array filtered for region 15
  <impact:codeArray codeName="CCOUNT15" arrayName="facCounty15" blankValue="true"/>  
  //Get county code/decode array filtered for region 97
  <impact:codeArray codeName="CCOUNT97" arrayName="facCounty97" blankValue="true"/>  

  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE" arrayName="finService" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE252" arrayName="finService252" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE253" arrayName="finService253" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE450" arrayName="finService450" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE460" arrayName="finService460" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE501" arrayName="finService501" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE502" arrayName="finService502" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE503" arrayName="finService503" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE504" arrayName="finService504" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE505" arrayName="finService505" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE506" arrayName="finService506" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE507" arrayName="finService507" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE508" arrayName="finService508" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE509" arrayName="finService509" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE510" arrayName="finService510" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE511" arrayName="finService511" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE512" arrayName="finService512" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE513" arrayName="finService513" blankValue="true"/>
  //STGAP00013039 - Get service code/decode array for UAS 515 financial category
  <impact:codeArray codeName="CSVCCODE515" arrayName="finService515" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE518" arrayName="finService518" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE520" arrayName="finService520" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE521" arrayName="finService521" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE522" arrayName="finService522" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE525" arrayName="finService525" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE529" arrayName="finService529" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE530" arrayName="finService530" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE531" arrayName="finService531" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE542" arrayName="finService542" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE547" arrayName="finService547" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE550" arrayName="finService550" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE551" arrayName="finService551" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE552" arrayName="finService552" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE553" arrayName="finService553" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE560" arrayName="finService560" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE561" arrayName="finService561" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE563" arrayName="finService563" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE564" arrayName="finService564" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE565" arrayName="finService565" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE571" arrayName="finService571" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE573" arrayName="finService573" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE574" arrayName="finService574" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE575" arrayName="finService575" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE576" arrayName="finService576" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE577" arrayName="finService577" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE578" arrayName="finService578" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE579" arrayName="finService579" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE582" arrayName="finService582" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE583" arrayName="finService583" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE584" arrayName="finService584" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE585" arrayName="finService585" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE586" arrayName="finService586" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE587" arrayName="finService587" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE588" arrayName="finService588" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE591" arrayName="finService591" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE595" arrayName="finService595" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE596" arrayName="finService596" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE597" arrayName="finService597" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE598" arrayName="finService598" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE604" arrayName="finService604" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE605" arrayName="finService605" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE606" arrayName="finService606" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE607" arrayName="finService607" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE608" arrayName="finService608" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE609" arrayName="finService609" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE610" arrayName="finService610" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE611" arrayName="finService611" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE612" arrayName="finService612" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE613" arrayName="finService613" blankValue="true"/>
    //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE614" arrayName="finService614" blankValue="true"/>
    //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE615" arrayName="finService615" blankValue="true"/>
    //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE616" arrayName="finService616" blankValue="true"/>
  //STGAP00013039 - Get service code/decode array for UAS 617 financial category
  <impact:codeArray codeName="CSVCCODE617" arrayName="finService617" blankValue="true"/>
  //STGAP00013039 - Get service code/decode array for UAS 618 financial category
  <impact:codeArray codeName="CSVCCODE618" arrayName="finService618" blankValue="true"/>
    //SMS #39513 - Get service code/decode array for UAS 619 financial category
  <impact:codeArray codeName="CSVCCODE619" arrayName="finService619" blankValue="true"/>
    //SMS #39513 - Get service code/decode array for UAS 620financial category
  <impact:codeArray codeName="CSVCCODE620" arrayName="finService620" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE698" arrayName="finService698" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE773" arrayName="finService773" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE774" arrayName="finService774" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE783" arrayName="finService783" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE784" arrayName="finService784" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE873" arrayName="finService873" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE874" arrayName="finService874" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE883" arrayName="finService883" blankValue="true"/>
  //Get service code/decode array for financial category
  <impact:codeArray codeName="CSVCCODE884" arrayName="finService884" blankValue="true"/>

  //Get service code/decode array for general
  <impact:codeArray codeName="CGLSVCCD" arrayName="genService" blankValue="true"/>
  //Get service code/decode array filtered for general category 01
  <impact:codeArray codeName="CGLSVCCD01" arrayName="genService01" blankValue="true"/>
  //Get service code/decode array filtered for general category 02
  <impact:codeArray codeName="CGLSVCCD02" arrayName="genService02" blankValue="true"/>
  //Get service code/decode array filtered for general category 03
  <impact:codeArray codeName="CGLSVCCD03" arrayName="genService03" blankValue="true"/>
  //Get service code/decode array filtered for general category 04
  <impact:codeArray codeName="CGLSVCCD04" arrayName="genService04" blankValue="true"/>
  //Get service code/decode array filtered for general category 05
  <impact:codeArray codeName="CGLSVCCD05" arrayName="genService05" blankValue="true"/>
  //Get service code/decode array filtered for general category 06
  <impact:codeArray codeName="CGLSVCCD06" arrayName="genService06" blankValue="true"/>
  //Get service code/decode array filtered for general category 07
  <impact:codeArray codeName="CGLSVCCD07" arrayName="genService07" blankValue="true"/>
  //Get service code/decode array filtered for general category 08
  <impact:codeArray codeName="CGLSVCCD08" arrayName="genService08" blankValue="true"/>
  //Get service code/decode array filtered for general category 09
  <impact:codeArray codeName="CGLSVCCD09" arrayName="genService09" blankValue="true"/>
  //Get service code/decode array filtered for general category 10
  <impact:codeArray codeName="CGLSVCCD10" arrayName="genService10" blankValue="true"/>
  //Get service code/decode array filtered for general category 11
  <impact:codeArray codeName="CGLSVCCD11" arrayName="genService11" blankValue="true"/>
  //Get service code/decode array filtered for general category 12
  <impact:codeArray codeName="CGLSVCCD12" arrayName="genService12" blankValue="true"/>
  //Get service code/decode array filtered for general category 13
  <impact:codeArray codeName="CGLSVCCD13" arrayName="genService13" blankValue="true"/>
  //Get service code/decode array filtered for general category 14
  <impact:codeArray codeName="CGLSVCCD14" arrayName="genService14" blankValue="true"/>
  //Get service code/decode array filtered for general category 15
  <impact:codeArray codeName="CGLSVCCD15" arrayName="genService15" blankValue="true"/>  

  //Get Region code/decode array
  <impact:codeArray codeName="CSVCRGNS" excludeOptions="<%=excludeOutOfStateOption%>" arrayName="facRegions" blankValue="true"/>

  window.attachEvent('onbeforeunload', setDirty );
  function setDirty()
  {
    IsDirty();
  };

  window.attachEvent('onload', setUpdMode );
  function setUpdMode()
  {
    if ( frmServiceDetail.SzCdScrDataAction.value == 'U' || frmServiceDetail.SzCdScrDataAction.value == 'u' )
    {
       frmServiceDetail.originallyUpdateMode.value = 'TRUE';
    }

    <% if (StringHelper.isTrue(checkedCIndRsrcSvcIncomeBsed)) { %>
      document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.checked = true;
      document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.defaultChecked = true;
    <%}%>

    populateCounty();

   // Set all default values.  It's the easiest thing.  Trust me.

  <% if (StringHelper.isTrue(checkedBIndRsrcSvcCntyPartial)) { %>

    document.frmServiceDetail.partCounties.value = "true";

  <%if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledPartialCounties )) {%>

    document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial_Disabled.checked = true;
    document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial_Disabled.defaultChecked = true;
    <%} else { %>

    document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial.checked = true;
    document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial.defaultChecked = true;
   <%}%>


  <%} else {%>
    document.frmServiceDetail.partCounties.value = "false";
  <%}%>

    populateService("<%=szCdRsrcSvcService%>")

  <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
     document.frmServiceDetail.selSzCdRsrcSvcService_Disabled.defaultValue = document.frmServiceDetail.selSzCdRsrcSvcService_Disabled.value;

  <% } else { %>
     document.frmServiceDetail.selSzCdRsrcSvcService.defaultValue = document.frmServiceDetail.selSzCdRsrcSvcService.value;

  <% } %>

  <% if (bInAddMode && !StringHelper.checkForEquality(szCdRsrcSvcState, "GA")) { %>
    document.frmServiceDetail.selSzCdRsrcSvcRegion.length = 1
    document.frmServiceDetail.selSzCdRsrcSvcRegion.options[0].value = "99";
    document.frmServiceDetail.selSzCdRsrcSvcRegion.options[0].text = "Out of State";
    document.frmServiceDetail.selSzCdRsrcSvcRegion.value = "99";
  <%}%>

  };

  function doCheckBoxes(pc)
  {

    var frm = document.frmServiceDetail;

    var stateCode = getState();
    var regionCode = getRegionCode();
    var countyCode = getCountyCode();

    var bInAddMode;

    if (frmServiceDetail.inAddMode.value == 'true')
      bInAddMode = true;
    else
      bInAddMode = false;

    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledCounties )) {%>
      var cbxAll = frm.cbxBIndRsrcSvcCntyAll_Disabled;
    <% } else { %>
      var cbxAll = frm.cbxBIndRsrcSvcCntyAll;
    <% } %>

    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledPartialCounties )) {%>
      var cbxPart = frm.cbxBIndRsrcSvcCntyPartial_Disabled;
    <% } else { %>
      var cbxPart = frm.cbxBIndRsrcSvcCntyPartial;
    <% } %>

    var acHidden = frm.allCounties;
    var pcHidden = frm.partCounties;

    // Enabling the checkboxes here will make sure
    // that they don't accidentally stay disabled.
    // We will re-disable them later if necessary.
    // Unless, of course, we're in browse mode, in which
    // case we don't want to enable it. Is this making
    // sense yet?

    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledCounties )) {%>
      cbxAll.disabled = true;
      cbxPart.disabled = true;
    <% } else { %>
      cbxAll.disabled = false;
      cbxPart.disabled = false;
    <% } %>


    if (pc == 1) // if they clicked the partial county box themselves
    {
      // clear and disable all counties checkbox
      cbxAll.checked = false;

      if (countyCode == '')
      {
        cbxPart.checked = false;
      }
      else
      {
        cbxPart.disabled = false;
      }
    }
    else if (stateCode == 'GA') // First, make sure we're still in Georgia...
    {


      if ( !bInAddMode && pc == 2)
      {

        // TODO HERE
        // UNSET THE PARTIAL COUNTIES BOX IF CHECKED

        if (cbxAll.checked)
        {
          <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
            clearDropdown("selSzScrRsrcSvcCntyCode_Disabled");
            document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "";
          <% } else { %>
            clearDropdown("selSzScrRsrcSvcCntyCode");
            document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "";
          <% } %>

            cbxPart.checked = false;
            cbxPart.disabled = true;
        }
        else
        {
        <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields ) ) {%>
          populateDropdownLocal("selSzScrRsrcSvcCntyCode_Disabled", "<%=szScrRsrcSvcCntyCode%>", eval("facCounty" + regionCode));
        <% } else { %>
          populateDropdownLocal("selSzScrRsrcSvcCntyCode", "<%=szScrRsrcSvcCntyCode%>", eval("facCounty" + regionCode));
        <% } %>
          cbxPart.disabled = false;
        }

      }
      // Are we in a statewide row?
      else if (regionCode == '98')
      {
        // Set the "all counties" and clear "partial county" check boxes.
        cbxAll.checked = true;
        cbxPart.checked = false;

        // You're not allowed to change them, either...
        cbxAll.disabled = true;
        cbxPart.disabled = true;
      }
      // How about a statewide intake or state office row?
      else if (regionCode == '99')
      {
        // Clear the "all counties" and "partial county" check boxes.
        cbxAll.checked = false;
        cbxPart.checked = false;

        // You're not allowed to change them, either...
        cbxAll.disabled = true;
        cbxPart.disabled = true;
      }
      else if (regionCode == '')  // no region?
      {
        cbxAll.checked = false;
        cbxAll.disabled = true;

        cbxPart.checked = false;
        cbxPart.disabled = true;
      }
      else if (countyCode == '')
      {
        cbxAll.checked = true;
        cbxAll.disabled = true;

        cbxPart.checked = false;
        cbxPart.disabled = true;
      }
      else
      {
        cbxAll.checked = false;
        cbxPart.checked = false;

        <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) {%>
          cbxPart.disabled = true;
        <% } else { %>
          cbxPart.disabled = false;
        <% } %>
      }
    }
    else
    {
      // I have a feeling we're not in Texas anymore...
      // Uncheck all boxes and disable them.
      cbxAll.checked = false;
      cbxPart.checked = false;
      cbxAll.disabled = true;
      cbxPart.disabled = true;
    }

    //set the values of the checkboxes
    if (cbxAll.checked)
    {
      cbxAll.value = 'true';
      acHidden.value = 'true';
    }
    else
    {
      cbxAll.value = 'false';
      acHidden.value = '';
    }


    if (cbxPart.checked)
    {
      cbxPart.value = 'true';
      pcHidden.value = 'true';
    }
    else
    {
      cbxPart.value = 'false';
      pcHidden.value = 'false';
    }


    // If we're in browse mode, re-disable the checkboxes in case we enabled them
    // previously.
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledCounties )) {%>
      cbxAll.disabled = true;
    <% } %>
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledPartialCounties )) {%>
      cbxPart.disabled = true;
    <% } %>

  }

  function selectAllCounties()
  {
    document.frmServiceDetail.selSzScrRsrcSvcCntyCode.selectedIndex=0;

    document.frmServiceDetail.changedToRegionWide.value = 'true';
    if (frmServiceDetail.inAddMode.value == 'true')
      doCheckBoxes(0);
    else
      doCheckBoxes(2);
  }

  /*
  *This function clears drop down boxes of all options.
  *@ param field: Name of drop down box to be cleard of all options
  */
  function clearDropdown(field)
  {
     //sets the values of all options to blank, and changes the number of options to 1
     var fieldLength = eval("document.frmServiceDetail."+field+".options.length");

     eval("document.frmServiceDetail."+field+".value = \"\";");
     for (var b=0; b < fieldLength; b++)
     {
       //empties the facility type drop-down box
       eval("document.frmServiceDetail."+field+".options[b].value = \"\";");
       eval("document.frmServiceDetail."+field+".options[b].text = \"\";");
     }

     eval("document.frmServiceDetail."+field+".options.length = 1");
  }

  /*
  *This function populates drop down boxes with options.
  * param field: Name of drop down box to be populated
  * param val: Value of last selected option on dropdown box
  * param cat: Array containing the values to populate drop down options
  */
  function populateDropdownLocal(field, val, cat)
  {    
     // we will clear the dropdown first.
     // This prevents it from being doubly populated.
     clearDropdown(field);

     // SIR REG059 - dejuanr - Service detailhad it own populate dropdown method.
     // I deleted it and had it call the main impact one.
     populateDropdown( eval("document.frmServiceDetail."+field), val , cat );
  }

  function populateCounty()
  {
    // Check to see if we are still looking at GA...
    if(getState() == 'GA')
    {
      // if so, populate the County with counties in the selected region
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
      var regionCode = document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.value;
    <% } else { %>
      var regionCode = document.frmServiceDetail.selSzCdRsrcSvcRegion.options.value;
    <% } %>

      if (regionCode == '00' || regionCode == '98' || regionCode == '99' || regionCode == '')
      {
        // 00 = Statewide Intake - 98 = Statewide - 99 = State Office

        // Clear out the county boxes in these cases
        <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
          clearDropdown("selSzScrRsrcSvcCntyCode_Disabled");
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "";
        <% } else { %>
          clearDropdown("selSzScrRsrcSvcCntyCode");
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "";
        <% } %>
      }
      else
      {
      <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields ) ) {%>
        populateDropdownLocal("selSzScrRsrcSvcCntyCode_Disabled", "<%=szScrRsrcSvcCntyCode%>", eval("facCounty" + regionCode));
      <% } else { %>
        populateDropdownLocal("selSzScrRsrcSvcCntyCode", "<%=szScrRsrcSvcCntyCode%>", eval("facCounty" + regionCode));
      <% } %>

      }
    }
    // and if not, we clear the County dropdown.
    else
    {
        <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
          clearDropdown("selSzScrRsrcSvcCntyCode_Disabled");

          document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.length = 1
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.options[0].text = "Out of State";
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.options[0].value = "999";
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.value = "999";

          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "999";
        <% } else { %>
          clearDropdown("selSzScrRsrcSvcCntyCode");

          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.length = 1
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.options[0].value = "999";
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.options[0].text = "Out of State";
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "999";
        <% } %>
    }

    doCheckBoxes(0);
  }

  function populateRegion()
  {
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
          populateDropdownLocal("selSzCdRsrcSvcRegion_Disabled", "", facRegions);
        <% } else { %>
          populateDropdownLocal("selSzCdRsrcSvcRegion", "", facRegions);
        <% } %>

    doCheckBoxes(0);
  }

  function populateRegionAndCounty()
  {
    // See if we're looking at Texas
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
        if(document.frmServiceDetail.selSzCdRsrcSvcState_Disabled.value == 'GA')
    <% } else { %>
      if(document.frmServiceDetail.selSzCdRsrcSvcState.options.value == 'GA')
    <% } %>
    {
      // if so, populate the Region and County dropdowns
      populateRegion();
      populateCounty();

      // If we're in an updating all counties row, we have to force the region dropdown
      // to the correct value. The county shall remain blank.
      <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
        document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.value = "<%=szCdRsrcSvcRegion%>";
        document.frmServiceDetail.selSzCdRsrcSvcRegion.value = "<%=szCdRsrcSvcRegion%>";
      <%}%>

    }
    // and if not, we clear them, then add the out of state codes
    else
    {
        <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
          clearDropdown("selSzCdRsrcSvcRegion_Disabled");
          document.frmServiceDetail.selSzCdRsrcSvcRegion.value = "";
        <% } else { %>
          clearDropdown("selSzCdRsrcSvcRegion");
        <% } %>

    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
      document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.length = 1
      document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.options[0].text = "Out of State";
      document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.options[0].value = "99";
      document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.value = "99";
      document.frmServiceDetail.selSzCdRsrcSvcRegion.value = "99";
    <% } else { %>
      document.frmServiceDetail.selSzCdRsrcSvcRegion.length = 1
      document.frmServiceDetail.selSzCdRsrcSvcRegion.options[0].value = "99";
      document.frmServiceDetail.selSzCdRsrcSvcRegion.options[0].text = "Out of State";
      document.frmServiceDetail.selSzCdRsrcSvcRegion.value = "99";
    <% } %>

        <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
          clearDropdown("selSzScrRsrcSvcCntyCode_Disabled");
          document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "";
        <% } else { %>
          clearDropdown("selSzScrRsrcSvcCntyCode");
        <% } %>

    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
      document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.length = 1
      document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.options[0].text = "Out of State";
      document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.options[0].value = "999";
      document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.value = "999";

      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "999";
    <% } else { %>
      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.length = 1
      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.options[0].value = "999";
      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.options[0].text = "Out of State";
      document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value = "999";
    <% } %>
    }

    doCheckBoxes(0);
  }

  function populateService( Svc )
  {
    //serviceType is required to decipher which array of codes to use
    var serviceType = Svc;
    var serviceCategory = document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.value;
    
    if (Svc == 0)
    {
      Svc = "";
    }

    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>

    if(document.frmServiceDetail.selSzCdRsrcSvcCategRsrc_Disabled.value == "")
    {
    
      clearDropdown("selSzCdRsrcSvcService_Disabled");
      document.frmServiceDetail.selSzCdRsrcSvcService.value = "";
    }
    else
    {
   
      //because certain codes for FAD (96D, 96J) are created with category 02,
      //but they aren't listed in the codes tables (CATSVLNK)
      //Since the page mode is view anyway, it can't hurt to populate the real value
      //ade
      //commented out next line; if in view it is unnecessary to populate the dropdown
      //with all the values
      <%if(generalBoolean && (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields ))){%>
       populateDropdownLocal("selSzCdRsrcSvcService_Disabled", "<%=szCdRsrcSvcService%>", genService);
      <%}else if(financialBoolean && (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields ))){%>
       populateDropdownLocal("selSzCdRsrcSvcService_Disabled", "<%=szCdRsrcSvcService%>", finService);
      <%}%>
      document.frmServiceDetail.selSzCdRsrcSvcService.value = "<%=szCdRsrcSvcService%>";
    }


    <% } else { %>

    if(document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.options.value == "")
    {
     
      clearDropdown("selSzCdRsrcSvcService");
    }
    else
    {//change this line to CGLSVCCD CPRGCODE
       if( serviceType == 'F')
           populateDropdownLocal("selSzCdRsrcSvcService", '', eval("finService" +serviceCategory));   
        else
           populateDropdownLocal("selSzCdRsrcSvcService", '', eval("genService"+serviceCategory));
    }

    <% } %>
  }

  function getState()
  {
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
      return document.frmServiceDetail.selSzCdRsrcSvcState_Disabled.value;
    <% } else { %>
      return document.frmServiceDetail.selSzCdRsrcSvcState.value;
    <% } %>
  }

  function getRegionCode()
  {
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
      return document.frmServiceDetail.selSzCdRsrcSvcRegion_Disabled.value;
    <% } else { %>
      return document.frmServiceDetail.selSzCdRsrcSvcRegion.value;
    <% } %>
  }

  function getCountyCode()
  {
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
      return document.frmServiceDetail.selSzScrRsrcSvcCntyCode_Disabled.value;
    <% } else { %>
      return document.frmServiceDetail.selSzScrRsrcSvcCntyCode.value;
    <% } %>
  }

  function getService()
  {
    <% if (!StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {%>
      return document.frmServiceDetail.selSzCdRsrcSvcService_Disabled.value;
    <% } else { %>
      return document.frmServiceDetail.selSzCdRsrcSvcService.value;
    <% } %>
  }

  function deleteService()
  {
    var confirmMessage = "";

    if ( (getState() == 'GA' && getRegionCode() == '98') || (! getState() == 'GA'))
    {
      confirmMessage = "This will delete the Client Characteristics for the service within the state. Delete?";
    }
    else
    {
      confirmMessage = "This will delete the Client Characteristics for the service within the region. Delete?";
    }

      if( confirm(confirmMessage) )
      {
        document.frmServiceDetail.SzCdScrDataAction.value='D';
        window.onbeforeunload = null;
        document.frmServiceDetail.validationOverride.value = 'true';
        return true;
      }
      else
      {
        return false;
      }
  }

  function saveService()
  {
    var confirmMessage = "";
    var regionCode = getRegionCode();
    var abandon = false;

    var bInAddMode;

    if (frmServiceDetail.inAddMode.value == 'true')
      bInAddMode = true;
    else
      bInAddMode = false;

    if ( !bInAddMode && frmServiceDetail.cbxBIndRsrcSvcCntyAll.checked && frmServiceDetail.changedToRegionWide.value == 'true')
    {

      bInAddMode = true;
      frmServiceDetail.SzCdScrDataAction.value = 'A';

    }
    else if (frmServiceDetail.originallyUpdateMode.value == 'TRUE')
    {
      bInAddMode = false;
      frmServiceDetail.SzCdScrDataAction.value = 'U';
    }

    // See if we're trying to add a "statewide" row.
    if (regionCode == '98')
    {
       // if so, we need to make sure they know what they're getting into...
      confirmMessage = "You are about to add a statewide row. This will delete ";
      confirmMessage = confirmMessage + "any already existing similar regionwide ";
      confirmMessage = confirmMessage + "rows, then add new ones. This will also ";
      confirmMessage = confirmMessage + "delete the client characterisitics for ";
      confirmMessage = confirmMessage + "those pre-existing rows. Are you sure you ";
      confirmMessage = confirmMessage + "want to do this?";

      if (!confirm(confirmMessage))
      {
        abandon = true;
      }

    } else

    if ( bInAddMode && document.frmServiceDetail.cbxBIndRsrcSvcCntyAll.checked )
      // originally all counties and not anymore and update mode, or we're in add mode and all counties is checked.
    {
      // if so, we need to make sure they know what they're getting into...
     confirmMessage = "You are about to add a region row. This will delete ";
     confirmMessage = confirmMessage + "any already existing similar county ";
     confirmMessage = confirmMessage + "rows. This will also ";
     confirmMessage = confirmMessage + "delete the client characterisitics for ";
     confirmMessage = confirmMessage + "those pre-existing rows. Are you sure you ";
     confirmMessage = confirmMessage + "want to do this?";

     if (!confirm(confirmMessage))
     {
       abandon = true;
     }
    }

    if (!abandon)
    {
     window.onbeforeunload = null;

     enableValidation('frmServiceDetail');  // I hope this is a valid function.

     if (document.frmServiceDetail.selectedServiceIndex.value == '')
     {
     	// STGAP00017019:ECEM 5.0: update the url with the new name now that General and Financial services use
     	// different screen for Add mode
       document.frmServiceDetail.action = '/resource/ServicesByArea/addGenServiceDetail';
     }
     else
     {
       document.frmServiceDetail.action = '/resource/ServicesByArea/displayServiceDetail';
     }

     if(document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial.checked)
     {
       document.frmServiceDetail.cbxBIndRsrcSvcCntyPartial.value = "true";
     }

     if(document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.checked)
     {
       document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.value = "true";
     }

     document.frmServiceDetail.bSaveAttempted.value = "true";
    }

    return !abandon;
  }

//sets the service type and submits the form for 
//redisplay. This only occurs if there is 
//a change in types when adding new service detail
//information
function setServiceType( item )
{
  document.frmServiceDetail.SzCdServiceType.value= item;
  disableValidation('frmServiceDetail');

  // STGAP00017019:ECEM 5.0: forward the page to the correct address based on the service type
  if (item == 'F')
  { 
    document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.value= '';
    document.frmServiceDetail.selSzCdRsrcSvcRegion.value= '';
    document.frmServiceDetail.cbxCIndRsrcSvcIncomeBsed.value= false;
    
  	submitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addFinServiceDetail');
  }
  else
  	submitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addGenServiceDetail');
}
</script>

<impact:validateForm
  name="frmServiceDetail"
  method="post"
  action="/resource/ServicesByArea/default"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.ServiceDetailValidation"
  schema="/WEB-INF/Constraints.xsd"
  pageMode="<%= pageMode %>"
>

<impact:validateErrors formName="frmServiceDetail"/>

<input type="hidden"
       name="<%= PageMode.PAGE_MODE_ATTRIBUTE_NAME %>"
       value="<%= pageMode %>"/>

<input type="hidden"
       name="txtUlIdResourceService"
       value="<%= ulIdResourceService %>"/>

<input type="hidden"
       name="SzCdScrDataAction"
       value='<%= ContextHelper.getStringSafe(request, "SzCdScrDataAction") %>'/>

<input type="hidden"
       name="originallyUpdateMode"
       value='<%= ContextHelper.getStringSafe(request, "originallyUpdateMode") %>'/>

<input type="hidden"
       name="changedToRegionWide"
       value="false"/>
       
<input type="hidden" 
       name="SzCdServiceType" 
       value='<%= ContextHelper.getStringSafe(request, "SzCdServiceType") %>'/>

<input type="hidden" name="inAddMode" value="<%= bInAddMode %>"/>
<input type="hidden" name="bSaveAttempted" value="false"/>

<impact:validateInput type="hidden" name="validationOverride"/>

<!-- We need the following two fields to hold the value of the AllCounties
     and PartialCounties checkboxes as they are occasionally disabled and
     won't submit a value. -->
<impact:validateInput type="hidden" name="allCounties" value=""/>
<impact:validateInput type="hidden" name="partCounties" value=""/>
<impact:validateInput type="hidden" name="hdnServiceType" value="<%= szCdRsrcServiceType %>"/>

<!-- We'll probably need this to keep track of where we came from on the list page. -->
<input type="hidden" name="selectedServiceIndex" value="<%=selectedServiceIndex%>"/>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
      <tr>
          <th colspan="4">Services by Area Information</th>
      </tr>
      <tr colspan="4">
           <td>
           <impact:validateDisplayOnlyField name="servicType" label="Service Type"/>
           <impact:validateInput tabIndex="<%=tabIndex++%>"
                                 type="radio"
                                 disabled="<%=sDisabledOtherFields%>"
                                 name="rbServiceType"
                                 value="G"
                                 cssClass="formInput"
                                 checked="<%= String.valueOf( generalBoolean ) %>"
                                 />General

           <impact:validateInput tabIndex="<%=tabIndex++%>"
                                 type="radio"
                                 disabled="<%=sDisabledOtherFields%>"
                                 name="rbServiceType"
                                 value="F"
                                 cssClass="formInput"
                                 checked="<%= String.valueOf( financialBoolean ) %>"
                                 onClick="setServiceType('F');"/>Financial
           </td>
      </tr>
<% if("".equalsIgnoreCase(ContextHelper.getStringSafe(request, "SzCdServiceType"))
      ||"G".equalsIgnoreCase(ContextHelper.getStringSafe(request, "SzCdServiceType"))){%>
      <tr>
          <th colspan="4">General Services by Area</th>
      </tr>
      <tr>
          <td><impact:validateSelect disabled="<%=sDisabledOtherFields%>"
                                     name="selSzCdRsrcSvcCategRsrc"
                                     label="Category"
                                     codesTable="CATOFSVC"
                                     value="<%=FormattingHelper.formatString(szCdRsrcSvcCategRsrc)%>"
                                     required="true"
                                     onChange="populateService('G')"
                                     tabIndex="<%=tabIndex++%>"
                                     style="WIDTH: 180px"/>
          </td>
        </tr>
        <tr>
          <td><impact:validateSelect disabled="<%=sDisabledOtherFields%>"
                                     name="selSzCdRsrcSvcService"
                                     label="Service"
                                     style="WIDTH: 180px"
                                     value="<%=FormattingHelper.formatString(szCdRsrcSvcService)%>"
                                     required="true"
                                     tabIndex="<%=tabIndex++%>" />
          </td>
        </tr>

<%
  }
  else
  {
  String svcCategory = Lookup.simpleDecodeSafe("CPRGCODE", szCdRsrcSvcCategRsrc);
  %>
        <tr>
            <th colspan="4">Financial Services by Area</th>
        </tr>
        <tr>
            <td><impact:validateSelect disabled="<%=sDisabledOtherFields%>"
                                       name="selSzCdRsrcSvcCategRsrc"
                                       label="Category"
                                       codesTable="CPRGCODE"
                                       value="<%=FormattingHelper.formatString(szCdRsrcSvcCategRsrc)%>"
                                       required="true"
                                       onChange="populateService('F')"
                                       tabIndex="<%=tabIndex++%>"
                                       style="WIDTH: 320px"/>
            </td>
        </tr>
        <tr>            
            <td><impact:validateSelect disabled="<%=sDisabledOtherFields%>"
                                       name="selSzCdRsrcSvcService"
                                       label="Service"
                                       style="WIDTH: 320px"
                                       value="<%=FormattingHelper.formatString(szCdRsrcSvcService)%>"
                                       required="true"
                                       tabIndex="<%=tabIndex++%>" />
            </td>
          </tr>
  <%
  }
%>
      <tr>
          <td><impact:validateSelect disabled="<%=sDisabledOtherFields%>"
                                     name="selSzCdRsrcSvcState"
                                     label="State"
                                     codesTable="CSTATE"
                                     value="<%=FormattingHelper.formatString(szCdRsrcSvcState)%>"
                                     required="true"
                                     tabIndex="<%=tabIndex++%>"
                                     onChange="populateRegionAndCounty()"/>
          </td>
          <td><impact:validateSelect disabled="<%= sDisableProgramOnly %>"
                                     name="selSzCdRsrcSvcProgram"
                                     label="Program"
                                     codesTable="CRSCPROG"
                                     value="<%=FormattingHelper.formatString(szCdRsrcSvcProgram)%>"
                                     required="false"
                                     tabIndex="<%=tabIndex++%>"/>
          </td>
      </tr>
        <tr>
          <td><impact:validateSelect disabled="<%=sDisabledOtherFields%>"
                                     name="selSzCdRsrcSvcRegion"
                                     codesTable="CREGIONS"
                                     excludeOptions="<%=excludeOutOfStateOption%>"
                                     label="Region"
                                     blankValue="true"
                                     value="<%=FormattingHelper.formatString(szCdRsrcSvcRegion)%>"
                                     required="true"
                                     onChange="populateCounty()"
                                     tabIndex="<%=tabIndex++%>"/>
          </td>
         <td><impact:validateSelect disabled="<%=sDisabledOtherFields%>"
                                     name="selSzScrRsrcSvcCntyCode"
                                     label="County"
                                     style="WIDTH: 140px"
                                     value="<%=FormattingHelper.formatString(szScrRsrcSvcCntyCode)%>"
                                     onChange="doCheckBoxes(0)"
                                     conditionallyRequired="true"
                                     tabIndex="<%=tabIndex++%>"/>
          </td>
      </tr>
      <tr>
          <td><impact:validateInput disabled="<%=sDisabledPartialCounties%>"
                                     name="cbxBIndRsrcSvcCntyPartial"
                                     type="checkbox"
                                     onClick="doCheckBoxes(1)"
                                     label="Partial County"
                                     checked="<%=checkedBIndRsrcSvcCntyPartial%>"
                                     tabIndex="<%=tabIndex++%>"/></td>
          <td><impact:validateInput disabled="<%=sDisabledCounties%>"
                                     name="cbxBIndRsrcSvcCntyAll"
                                     type="checkbox"
                                     onClick="selectAllCounties()"
                                     label="All Counties"
                                     tabIndex="<%=tabIndex++%>"/></td>
          <td><impact:validateInput disabled="<%=sDisabledIncomeAndProgram%>"
                                     name="cbxCIndRsrcSvcIncomeBsed"
                                     type="checkbox"
                                     label="Income Based"
                                     checked="<%=checkedCIndRsrcSvcIncomeBsed%>"
                                     tabIndex="<%=tabIndex++%>"/></td>
      </tr>
  </table>

<%-- if (!!StringHelper.checkForEquality(pageMode, PageMode.EDIT) || StringHelper.isTrue( sDisabledOtherFields )) {--%>

<% if (!bInActiveContract && !StringHelper.checkForEquality(pageMode, PageModeConstants.VIEW) ) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
  <% if (!bInAddMode) { %>
    <td align="left">
     <impact:ButtonTag name="btnDelete"
                                     img="btnDelete"
                                     editableMode="<%= EditableMode.EDIT %>"
                                     function="return deleteService();"
                                     form="frmServiceDetail"
                                     action="/resource/ServicesByArea/deleteServiceDetail"
                                     tabIndex="<%=tabIndex++%>"/>
    </td>
  <%}%>
    <td align="right">
      <impact:ButtonTag name="btnSave"
                                     img="btnSave"
                                     align="right"
                                     editableMode="<%= EditableMode.EDIT %>"
                                     function="return saveService();"
                                     form="frmServiceDetail"
                                     action="/resource/ServicesByArea/saveServiceDetail"
                   restrictRepost="true"
                                     tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<%}%>
<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
</impact:validateForm>

