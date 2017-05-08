package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class ServicesByAreaList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


/**
 * GetFormattedAge  using the string parameters in order to get
 * age converted from months to years and months
 * @return String
 * @param months The number of months for the age
 */
  public String getFormattedAge(int months)
  {
    int years = 0;
    if (months < 12)
    {
      return (" 0 Yr " + months + " Mo");
    }
    else
    {
      years = months / 12;
      months = months % 12;
      return ( years + " Yr " + months + " Mo ");
    }
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

      out.write('\r');
      out.write('\n');

/**
 * JSP Name:     ServicesByAreaList.jsp
 * Created by:   Donald Wilson
 * Date Created: 09/27/02
 *
 * Description:
 * This page displays the results of a Services by Area Search, and allows the
 * user to Add or Delete Services by Area Detail.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  01/30/07  Ade Odutayo       Modifications to the page based on the SHINES designs
  11/30/07  Ernest Imomio     STGAP00005831: Services By Area pagination implement
  01/06/09  Mital Patel       STGAP00005460: Added code to display horizontal scroll bar.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int checkpoint = 0;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  //Set the selectedServiceIndex.  It will be 0 unless a different service is
  //selected on the page
  int selectedServiceIndex = 0;
  int loopCount = 0;

  if (((!StringHelper.checkForEquality(ContextHelper.getStringSafe(request, "SzCdScrDataAction"), "D")) ||
       (StringHelper.isValid(ContextHelper.getStringSafe(request, "selectedCharacteristicIndex")))) &&
                                                                                                    (StringHelper.isValid(ContextHelper.getStringSafe(request, "selectedServiceIndex"))))

  {
    selectedServiceIndex = ContextHelper.getIntSafe(request, "selectedServiceIndex");
  }

  // get current page, if any

  int currPage = 1;
  if (StringHelper.isValid(ContextHelper.getStringSafe(request, "page")))
  {
    currPage = ContextHelper.getIntSafe(request, "page");
  }

  if (StringHelper.isValid((String) request.getAttribute("tmpPageNum")))
  {
    currPage = Integer.parseInt((String) request.getAttribute("tmpPageNum"));
    request.removeAttribute("tmpPageNum");
  }

  //Get the services data for the page
  CRES05SO cres05so = (CRES05SO)request.getAttribute("CRES05SO");
  ROWCRES05SOG00_ARRAY servicesArray = null;
  ROWCRES05SOG00 selectedService = null;

  String serviceId = "";
  String serviceCode = "";
  String serviceCategory = "";
  Enumeration services = null;
  boolean currServiceIsContracted = false;
  String selectedServiceName = "";
  String selectedServiceType = "";
  if (cres05so != null)
  {
    servicesArray = cres05so.getROWCRES05SOG00_ARRAY();
    request.setAttribute("CRES05SO", cres05so);
    //check to see if array is empty
    if( servicesArray.getROWCRES05SOG00Count() > 0 ){
      ROWCRES05SOG00 serviceRow1 = servicesArray.getROWCRES05SOG00(0);
      serviceId = String.valueOf(serviceRow1.getUlIdResourceService());
    }    
  }
  if (StringHelper.isValid(ContextHelper.getStringSafe(request, "servicesList")))
  {
    serviceId = ContextHelper.getStringSafe(request, "servicesList");
  }
  if (servicesArray != null && servicesArray.getROWCRES05SOG00Count() > 0 )
  {
    if (selectedServiceIndex >= servicesArray.getROWCRES05SOG00Count())
    {
      selectedServiceIndex = 0;
    }

    selectedServiceType = servicesArray.getROWCRES05SOG00(selectedServiceIndex).getSzCdRsrcSvcServiceType();
    selectedServiceName = servicesArray.getROWCRES05SOG00(selectedServiceIndex).getSzCdRsrcSvcService();
  }
  else
  {
    servicesArray = new ROWCRES05SOG00_ARRAY();
  }

  
  services = servicesArray.enumerateROWCRES05SOG00();
  String ResourceID = GlobalData.getUlIdResourceAsString( request );
  String ResourceName = GlobalData.getSzNmResource(request);

  Boolean  servicesRecordFound =services.hasMoreElements();

  //Get the characteristics data for the page
  CRES07SO cres07so = (CRES07SO)request.getAttribute("CRES07SO");
  ROWCRES07SOG_ARRAY characteristicsArray = null;
  Enumeration characteristics = null;
  int characteristicsCount = 0;

  if (cres07so != null)
  {
    characteristicsArray = cres07so.getROWCRES07SOG_ARRAY();

  }
  if (characteristicsArray == null)
  {
    characteristicsArray = new ROWCRES07SOG_ARRAY();
  }

  characteristics = characteristicsArray.enumerateROWCRES07SOG();
  
   Boolean  characteristicsRecourdFound =characteristics.hasMoreElements();

  String pageMode = GlobalData.getAppMode(request);

  //Variable to hold the css class for the each row in the lists
  String rowCss = "altColor";



      out.write("\r\n\r\n\r\n<!-- Begin Population List-->\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n//Submit Services form to redisplay this page with the characteristics for the\r\n//newly selected service\r\n\r\nwindow.onload = function ()\r\n{\r\n  if (document.pagination != null)\r\n  {\r\n    document.frmServices.orderBy.value = document.pagination.orderBy.value;\r\n    document.frmServices.orderByDirection.value = document.pagination.orderByDirection.value;\r\n  }\r\n\r\n  if (document.frmServices.page != null && document.frmServices.lastPage.value != document.frmServices.page.value)\r\n  {\r\n    document.frmServices.selectedServiceIndex.value = \"0\";\r\n  }\r\n\r\n  // This scrolls to the approximate location of the service radio button that was clicked.\r\n  if (document.frmServices.rbServicesList != null &&\r\n      document.frmServices.rbServicesList.length != null &&\r\n      ");
      out.print(selectedServiceIndex);
      out.write(" > 0)\r\n  {\r\n    // this is the div!\r\n    document.frmServices.rbServicesList[");
      out.print(selectedServiceIndex);
      out.write("].parentNode.parentNode.scrollIntoView();\r\n\r\n  }\r\n\r\n};\r\n\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  if (document.frmServices.page != null)\r\n  {\r\n    document.frmServices.lastPage.value = document.frmServices.page.value;\r\n  }\r\n\r\n  if (document.pagination != null)\r\n  {\r\n    if (document.pagination.selectedServiceIndex != null)\r\n    {\r\n      document.pagination.selectedServiceIndex.value = \"0\";\r\n    }\r\n  }\r\n};\r\n\r\n\r\nfunction getState()\r\n{\r\n  return document.frmServices.State.value;\r\n}\r\n\r\nfunction getRegionCode()\r\n{\r\n  return document.frmServices.RegionCode.value;\r\n}\r\n\r\nfunction getCounty()\r\n{\r\n  return document.frmServices.County.value;\r\n}\r\n\r\nfunction checkForSelection(objName)\r\n{\r\n  var buttonChecked = false;\r\n  var obj = eval(objName);\r\n\r\n  if (obj != null)\r\n  {\r\n    if (obj.length == null)\r\n    {\r\n      if (obj.checked != false)\r\n        buttonChecked = true;\r\n    }\r\n    else\r\n    {\r\n      for (var i = 0; i < obj.length; ++i)\r\n      {\r\n        buttonChecked = buttonChecked || obj[i].checked;\r\n      }\r\n    }\r\n");
      out.write("  }\r\n\r\n  return (buttonChecked);\r\n}\r\n\r\nfunction whichButtonChecked(objName)\r\n{\r\n  var whichChecked = -1;\r\n  var obj = eval(objName);\r\n\r\n  if (obj != null)\r\n  {\r\n    if (obj.length == null)\r\n    {\r\n      if (obj.checked != false)\r\n        whichChecked = 0;\r\n    }\r\n    else\r\n    {\r\n      for (var i = 0; i < obj.length; ++i)\r\n      {\r\n        if (obj[i].checked)\r\n          whichChecked = i;\r\n      }\r\n    }\r\n  }\r\n\r\n  return (whichChecked);\r\n}\r\n\r\nfunction serviceIsContracted()\r\n{\r\n  var contracted = false;\r\n\r\n  if (document.frmServices.isContracted.value == 'true')\r\n  {\r\n    contracted = true;\r\n  }\r\n\r\n  return contracted;\r\n}\r\n\r\nfunction updateSelectedService(index)\r\n{\r\n  document.frmServices.selectedServiceIndex.value = index;\r\n  disableValidation('frmServices');\r\n  submitValidateForm('frmServices', '/resource/ServicesByArea/refreshCharacteristicList');\r\n}\r\n\r\nfunction updateSelectedCharacteristic(index)\r\n{\r\n  document.frmCharacteristics.selectedCharacteristicIndex.value = index;\r\n}\r\n\r\n//submit Services form to go to the services detail page\r\n");
      out.write("function goToServicesDetail(index)\r\n{\r\n  document.frmServices.selectedServiceIndex.value = index;\r\n  document.frmServices.SzCdScrDataAction.value='U';\r\n  disableValidation('frmServices');\r\n  window.onbeforeunload = null;\r\n  submitValidateForm('frmServices', '/resource/ServicesByArea/displayServiceDetail');\r\n}\r\n\r\n//submit Services form to go to the services detail page in add mode\r\nfunction addService()\r\n{\r\n  document.frmServices.selectedServiceIndex.value = '';\r\n  document.frmServices.SzCdScrDataAction.value='A';\r\n  disableValidation('frmServices');\r\n  return true;\r\n}\r\n\r\n//submit Services form to go to the services detail page in delete mode\r\nfunction deleteService()\r\n{\r\n  var confirmMessage = \"\";\r\n\r\n  if ((getState() == 'Georgia' && getRegionCode() == '98') || (getState() != 'Georgia'))\r\n  {\r\n    confirmMessage = \"This will delete the Client Characteristics for the service within the state. Delete?\";\r\n  }\r\n  else\r\n  {\r\n    confirmMessage = \"This will delete the Client Characteristics for the service within the region. Delete?\";\r\n");
      out.write("  }\r\n\r\n  if (checkForSelection('document.frmServices.rbServicesList'))\r\n  {\r\n    document.frmServices.selectedServiceIndex.value = whichButtonChecked('document.frmServices.rbServicesList');\r\n    if (! serviceIsContracted())\r\n    {\r\n      if (confirm(confirmMessage))\r\n      {\r\n        document.frmServices.SzCdScrDataAction.value='D';\r\n        disableValidation('frmServices');\r\n        return true;\r\n      }\r\n      else\r\n      {\r\n        return false;\r\n      }\r\n    }\r\n    else\r\n    {\r\n      alert(\"Service is in an active contract. Deletion is not allowed.\");\r\n      return false;\r\n    }\r\n  }\r\n  else\r\n  {\r\n    setInformationalMessage(\"");
      out.print( MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("\");\r\n    return false;\r\n  }\r\n}\r\n\r\nfunction goToClientCharacteristicsDetail(rownum)\r\n{\r\n  document.frmCharacteristics.selectedCharacteristicIndex.value = rownum;\r\n  document.frmCharacteristics.SzCdScrDataAction.value='U';\r\n  disableValidation('frmCharacteristics');\r\n  submitValidateForm('frmCharacteristics', '/resource/ServicesByArea/displayClientCharacteristicDetail');\r\n}\r\n\r\nfunction addClientCharacteristicsDetail()\r\n{\r\n  document.frmCharacteristics.SzCdScrDataAction.value='A';\r\n  disableValidation('frmCharacteristics');\r\n  return true;\r\n}\r\n\r\n//submit Services form to go to the services detail page in delete mode\r\nfunction deleteClientCharacteristicsDetail()\r\n{\r\n  if (checkForSelection('document.frmCharacteristics.rbCharacteristics'))\r\n  {\r\n    if (confirm(\"Are you sure you want to delete this record?\"))\r\n    {\r\n      document.frmCharacteristics.SzCdScrDataAction.value='D';\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n  else\r\n  {\r\n    document.frmCharacteristics.SzCdScrDataAction.value='D';\r\n");
      out.write("    setInformationalMessage(\"");
      out.print( MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("\");\r\n    return false;\r\n  }\r\n}\r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmServices");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ServicesByArea/default");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          out.write("\r\n<input type=\"hidden\" name=\"lastPage\" value=\"\"/>\r\n<input type=\"hidden\" name=\"");
          out.print(PageMode.PAGE_MODE_ATTRIBUTE_NAME);
          out.write("\" value=\"");
          out.print(pageMode);
          out.write("\"/>\r\n<input type=\"hidden\" name=\"selectedServiceIndex\" value=\"");
          out.print(selectedServiceIndex);
          out.write("\"/>\r\n<input type=\"hidden\" name=\"txtNmResource\" value=\"");
          out.print(ResourceName);
          out.write("\"/>\r\n<input type=\"hidden\" name=\"SzCdScrDataAction\" value=\"\"/>\r\n<input type=\"hidden\" name=\"txtUlIdResource\" value=\"");
          out.print(ResourceID);
          out.write("\"/>\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSaveState("false");
          _jspx_th_impact_pagination_0.setSubmitUrl("/resource/ServicesByArea/default");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table width=\"100%\" cellpading=\"0\" cellspacing=\"0\" border=\"0\">\r\n <tr><td class=\"alignRight\">\r\n<div class=\"formInstruct\">Scroll for more information  --></div>\r\n  </td>\r\n</tr>\r\n</table>\r\n  \r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n <th>Services by Area - ");
              out.print(ResourceName);
              out.write("</th>\r\n  <tr>\r\n   <td>\r\n    <div name=\"thediv\" id=\"scroll2\" style=\"HEIGHT:200px;WIDTH:763px;OVERFLOW:auto\"class=\"tableborderList\">\r\n   <div name=\"thediv\" id=\"scroll2\" style=\"OVERFLOW:auto; WIDTH:763px\">\r\n    <table name=\"thetable\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorderList\">\r\n    <tr>\r\n     <th class=\"thList\">&nbsp;</th>\r\n     <th class=\"thList\">Category</th>\r\n     <th class=\"thList\">Service</th>\r\n     <th class=\"thList\">C</th>\r\n     <th class=\"thList\">Program</th>\r\n     <th class=\"thList\">Region</th>\r\n     <th class=\"thList\">County</th>\r\n     <th class=\"thList\">Partial County</th>\r\n     <th class=\"thList\">Income Based</th>\r\n     <th class=\"thList\">State</th>\r\n    </tr>\r\n\r\n");

   ROWCRES05SOG00 service = null;
   loopCount = 0;

   if (!services.hasMoreElements())
   {

              out.write("\r\n       <tr class=\"odd\">\r\n         <td colspan=\"7\">\r\n            ");
              out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
              out.write("\r\n         </td>\r\n       </tr>\r\n");

   }
     else
   {
     while (services.hasMoreElements())
     {
       service = (ROWCRES05SOG00) services.nextElement();

              out.write("\r\n    <tr name=\"therow\" class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\" valign=\"top\">\r\n     <td name=\"theelement\">\r\n     <input type=\"radio\"\r\n            ");
if (loopCount == selectedServiceIndex) {
              out.write("checked=\"true\"");
}
              out.write("\r\n            name=\"rbServicesList\"\r\n            value=\"");
              out.print(service.getUlIdResourceService());
              out.write("\"\r\n            tabIndex=\"");
              out.print(loopCount);
              out.write("\"\r\n            onClick=\"javascript:updateSelectedService(");
              out.print(loopCount);
              out.write(");\">\r\n\r\n     ");
if (loopCount == selectedServiceIndex)
       {
         currServiceIsContracted = (StringHelper.isTrue(service.getCScrIndRsrcContracted()));
       
              out.write("\r\n          <input type=\"hidden\"\r\n                 name=\"State\"\r\n                 value='");
              out.print( Lookup.simpleDecodeSafe("CSTATE", service.getSzCdRsrcSvcState()) );
              out.write("'/>\r\n\r\n          <input type=\"hidden\"\r\n                 name=\"RegionCode\"\r\n                 value=\"");
              out.print( service.getSzCdRsrcSvcRegion() );
              out.write("\"/>\r\n\r\n          <input type=\"hidden\"\r\n                 name=\"County\" value='");
              out.print( Lookup.simpleDecodeSafe("CCOUNT", service.getSzScrRsrcSvcCntyCode()) );
              out.write("'/>\r\n\r\n          <input type=\"hidden\"\r\n                 name=\"isContracted\"\r\n                 value='");
              out.print( "" + StringHelper.isTrue(service.getCScrIndRsrcContracted()) );
              out.write("'/>\r\n\r\n          <input type=\"hidden\"\r\n                 name=\"txtUlIdResourceService\"\r\n                 value=\"");
              out.print( service.getUlIdResourceService() );
              out.write("\"/>\r\n     ");
}
              out.write("\r\n\r\n     </td>\r\n     ");
 
        if( "G".equalsIgnoreCase( service.getSzCdRsrcSvcServiceType() ) ){
           serviceCode = Lookup.simpleDecodeSafe(CodesTables.CGLSVCCD, service.getSzCdRsrcSvcService());
           serviceCategory = Lookup.simpleDecodeSafe(CodesTables.CATOFSVC, service.getSzCdRsrcSvcCategRsrc());
        }
        else if( "F".equalsIgnoreCase( service.getSzCdRsrcSvcServiceType() ) ){
           serviceCode = Lookup.simpleDecodeSafe(CodesTables.CSVCCODE, service.getSzCdRsrcSvcService());
           serviceCategory = Lookup.simpleDecodeSafe(CodesTables.CPRGCODE, service.getSzCdRsrcSvcCategRsrc());        
        }
        
        int begin = 0, end = 29, strLen = 30;
        if(!"".equals(serviceCode) & serviceCode.length() > strLen){
           serviceCode = serviceCode.substring(begin,end);
        }
        if(!"".equals(serviceCategory) & serviceCategory.length() > strLen){
         serviceCategory = serviceCategory.substring(begin,end);
        }
     
              out.write("\r\n     <td><nobr>");
              out.print( serviceCategory );
              out.write("</td>\r\n     <td><nobr><A href=\"javascript:goToServicesDetail(");
              out.print(loopCount);
              out.write(");\">");
              out.print( serviceCode );
              out.write("</A></td>\r\n     <td><nobr>");
if (StringHelper.isTrue(service.getCScrIndRsrcContracted())){
              out.write("<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >");
}
              out.write("</td>\r\n     <td><nobr>");
              out.print(Lookup.simpleDecodeSafe("CRSCPROG", service.getSzCdRsrcSvcProgram()));
              out.write("</td>\r\n     <td><nobr>");
              out.print(Lookup.simpleDecodeSafe("CREGIONS", service.getSzCdRsrcSvcRegion()));
              out.write("</td>\r\n     <td><nobr>");
              out.print(Lookup.simpleDecodeSafe("CCOUNT", service.getSzScrRsrcSvcCntyCode()));
              out.write("</td>\r\n     <td><nobr>");
              out.print(service.getBIndRsrcSvcCntyPartial());
              out.write("</td>\r\n     <td><nobr>");
              out.print(service.getCIndRsrcSvcIncomeBsed());
              out.write("</td>\r\n     <td><nobr>");
              out.print(Lookup.simpleDecodeSafe("CSTATE", service.getSzCdRsrcSvcState()));
              out.write("</td>\r\n    </tr>\r\n");

      loopCount++;
     } // end while
   }

              out.write("\r\n\r\n    </table>\r\n  </div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <input type=\"hidden\" name=\"frmCount\" value=\"");
          out.print(loopCount+1);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
 if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) {
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"  >\r\n <tr>\r\n    <td align=\"left\">\r\n    ");
if (!currServiceIsContracted && servicesArray.getROWCRES05SOG00Count() > 0) {
          out.write("\r\n     ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDeleteSrv");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteService();");
          _jspx_th_impact_ButtonTag_0.setForm("frmServices");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ServicesByArea/deleteServiceDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(loopCount++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
}
          out.write("\r\n    </td>\r\n    <td align=\"right\" >\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAddSrv");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return addService();");
          _jspx_th_impact_ButtonTag_1.setForm("frmServices");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ServicesByArea/addFinServiceDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex(loopCount++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n </tr>\r\n</table>\r\n");
}
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n<!--End Service Area List-->\r\n<BR>\r\n");
 if (services != null) { 
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmCharacteristics");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/resource/ServicesByArea/default");
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<input type=\"hidden\"\r\n       name=\"servicesList\"\r\n       value=\"");
          out.print(serviceId);
          out.write("\"/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"");
          out.print(PageMode.PAGE_MODE_ATTRIBUTE_NAME );
          out.write("\"\r\n       value=\"");
          out.print(pageMode);
          out.write("\"/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"txtUlIdResourceService\"\r\n       value='");
          out.print( ContextHelper.getStringSafe(request, "txtUlIdResourceService") );
          out.write("'/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"txtNmResource\"\r\n       value=\"");
          out.print(ResourceName);
          out.write("\"/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"txtUlIdResource\"\r\n       value=\"");
          out.print(ResourceID);
          out.write("\"/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"SzCdScrDataAction\"\r\n       value=\"\"/>\r\n\r\n<input type=\"hidden\"\r\n       name=\"selectedServiceIndex\"\r\n       value=\"");
          out.print(selectedServiceIndex);
          out.write("\"/>\r\n\r\n");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("page");
          _jspx_th_impact_validateInput_2.setValue(Integer.toString(currPage));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\"  >\r\n  ");
 String serviceDecode = "";
     if( "G".equalsIgnoreCase(selectedServiceType) ){
     	serviceDecode = Lookup.simpleDecodeSafe(CodesTables.CGLSVCCD, selectedServiceName);
     }
     if( "F".equalsIgnoreCase(selectedServiceType) ){
         serviceDecode = Lookup.simpleDecodeSafe(CodesTables.CSVCCODE, selectedServiceName);
     }
  
          out.write("\r\n  <th>Client Characteristics - ");
          out.print(serviceDecode);
          out.write("</th>\r\n    <tr>\r\n      <td>\r\n        <div id=\"scroll3\" style=\"OVERFLOW: auto; WIDTH: 760px; HEIGHT: 150px\">\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorderList\">\r\n          <tr>\r\n            <th class=\"thList\">&nbsp;</th>\r\n            <th class=\"thList\">Characteristics</th>\r\n            <th class=\"thList\">Male Min Age</th>\r\n            <th class=\"thList\">Male Max Age</th>\r\n            <th class=\"thList\">Female Min Age</th>\r\n            <th class=\"thList\">Female Max Age</th>\r\n          </tr>\r\n\r\n");

   ROWCRES07SOG characteristic = null;
   int characteristicsLoopCount = 0;

   if (!characteristics.hasMoreElements())
   {

          out.write("\r\n       <tr class=\"odd\">\r\n         <td colspan=\"7\">\r\n            ");
          out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
          out.write("\r\n         </td>\r\n       </tr>\r\n");

   }
     else
   {
     while (characteristics.hasMoreElements())
     {
       characteristic = (ROWCRES07SOG) characteristics.nextElement();

          out.write("\r\n    <tr class=\"");
          out.print(FormattingHelper.getRowCss(characteristicsLoopCount + 1));
          out.write("\" valign=\"top\">\r\n      <td>\r\n       <input type=\"radio\"\r\n              name=\"rbCharacteristics\"\r\n              value=\"");
          out.print(characteristicsLoopCount);
          out.write("\"\r\n              tabIndex=\"");
          out.print(characteristicsLoopCount);
          out.write("\"\r\n              onClick=\"javascript:updateSelectedCharacteristic(");
          out.print(characteristicsLoopCount);
          out.write(");\">\r\n      </td>\r\n      <td><nobr><A href=\"javascript:goToClientCharacteristicsDetail('");
          out.print(characteristicsLoopCount);
          out.write("');\">");
          out.print(Lookup.simpleDecodeSafe("CLNCHAR2", characteristic.getSzCdRsrcCharChrctr()));
          out.write("</A></td>\r\n      <td><nobr>");
          out.print(getFormattedAge(characteristic.getUNbrRsrcCharMinMAge()));
          out.write("</td>\r\n      <td><nobr>");
          out.print(getFormattedAge(characteristic.getUNbrRsrcCharMaxMAge()));
          out.write("</td>\r\n      <td><nobr>");
          out.print(getFormattedAge(characteristic.getUNbrRsrcCharMinFAge()));
          out.write("</td>\r\n      <td><nobr>");
          out.print(getFormattedAge(characteristic.getUNbrRsrcCharMaxFAge()));
          out.write("</td>\r\n    </tr>\r\n");

      characteristicsLoopCount++;
     } // end while
   }

          out.write("\r\n    </table>\r\n</div>\r\n    </td>\r\n    </tr>\r\n</table>\r\n\r\n  <input type=\"hidden\" name=\"frmCount\" value=\"");
          out.print( characteristicsLoopCount + 1 );
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n\r\n\r\n");
 if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) { 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"  >\r\n  <tr>\r\n    <td align=\"left\">\r\n      ");
if (characteristicsRecourdFound) { 
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("btnDeleteChar");
          _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setFunction("return deleteClientCharacteristicsDetail();");
          _jspx_th_impact_ButtonTag_2.setForm("frmCharacteristics");
          _jspx_th_impact_ButtonTag_2.setAction("/resource/ServicesByArea/deleteClientCharacteristicDetail");
          _jspx_th_impact_ButtonTag_2.setTabIndex(characteristicsLoopCount++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
}
          out.write("\r\n    </td>\r\n    <td align=\"right\" >\r\n      ");
 if (servicesRecordFound) { 
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_3.setName("btnAddChar");
          _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_3.setFunction("return addClientCharacteristicsDetail();");
          _jspx_th_impact_ButtonTag_3.setForm("frmCharacteristics");
          _jspx_th_impact_ButtonTag_3.setAction("/resource/ServicesByArea/addClientCharacteristicDetail");
          _jspx_th_impact_ButtonTag_3.setTabIndex(characteristicsLoopCount++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
}
          out.write("\r\n    </td>\r\n  </tr>\r\n </table>\r\n\r\n ");
}
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
}
      out.write("\r\n\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmServices");
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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("selectedCharacteristicIndex");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("orderBy");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("orderByDirection");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("validationOverride");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
