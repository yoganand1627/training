package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class SubcontractorDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 * JSP Name:     SubcontractorDetail.jsp
 * Created by:   lingamnr
 * Date Created: 08/22/02
 *
 * Description:
 * The Subcontractor Detail page will display detailed information for the
 * subcontractor selected on the Resource Detail page.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String TRACE_TAG = "DisplaySubcontractorDetail.jsp";
  String tmpSzNmResource = "";
  Date tmpTsLastUpdate = null;
  String tmpsubcontractorRowService = "";
  String idIndex = "0";
  String szCReqFuncCd = "";
  String tmpUIdRsrcLinkChild = "";
  String tmpUIdRsrcLink = "";
  String tmpcReqFuncCd = "";
  String txtuIdRsrcLinkParent = "";
  String txtUlIdResource = "";
  String classResource = "false";
  String fadResource = "false";
  String childPlacingAgency = "false";
  //String pageMode = PageMode.VIEW;

  String subContractorIdDisable = "false";
  String serviceDisable = "false";
  boolean validateButtonHide = false;
  boolean saveButtonHide = false;
  boolean deleteButtonHide = false;

  ROWCCON15SOG00_ARRAY subcontractorArray = null;
  ROWCCON15SOG01_ARRAY subcontractorServiceArray = null;
  ROWCCON15SOG00 subcontractorRow = null;
  ROWCCON15SOG01 subcontractorRowService = null;
  int isubcontractorServiceArraySize = 0;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  String pageMode = PageMode.getPageMode(request);

  if( request.getParameter( "cReqFuncCd" ) != null )
  {
    szCReqFuncCd = request.getParameter( "cReqFuncCd" );
  }

  CCON17SO ccon17so = (CCON17SO) request.getAttribute( "CCON17S_SubcontractorValidate" );
  if ( ccon17so == null )
  {
    ccon17so = new CCON17SO();
  }
  CCON15SO ccon15so = (CCON15SO) state.getAttribute( "CCON15S_resourceDetail", request );//SR-

  ROWCRES05SOG00_ARRAY servicesStruct = (ROWCRES05SOG00_ARRAY) request.getAttribute( "ROWCRES05SOG00_ARRAY_subcontractorDetail" );
  int serviceSize = 0;
  if( servicesStruct != null )
  {
    serviceSize = servicesStruct.getUlRowQty();
  }
  String[] servicesList = new String[serviceSize];
  if( servicesStruct != null )
  {
    //Loop through and get all services for the resource
    for(int i=0; i<servicesStruct.getUlRowQty(); i++ )
    {
      servicesList[i] = servicesStruct.getROWCRES05SOG00(i).getSzCdRsrcSvcService();
    }
  }


 if( request.getParameter("servicesArray") != null )
  {
    servicesList = (String[])SerializationHelper.deserializeObject(request.getParameter("servicesArray"));
  }

  if (ccon15so != null)
  {
    subcontractorArray = ccon15so.getROWCCON15SOG00_ARRAY();
    subcontractorServiceArray = ccon15so.getROWCCON15SOG01_ARRAY();
    if ("A".equalsIgnoreCase(szCReqFuncCd) )
    {
      tmpSzNmResource = "";
      tmpUIdRsrcLinkChild = null;
    }
    else
    {
      subcontractorRow = subcontractorArray.getROWCCON15SOG00( Integer.parseInt( idIndex ) );
      if( subcontractorRow.getSzCdRsrcLinkService() != null )
      {
        tmpsubcontractorRowService = subcontractorRow.getSzCdRsrcLinkService();
      }
      tmpSzNmResource = subcontractorRow.getSzNmResource();
      tmpUIdRsrcLinkChild = String.valueOf( subcontractorRow.getUIdRsrcLinkChild());
      tmpUIdRsrcLink = String.valueOf(subcontractorRow.getUIdRsrcLink());
      tmpTsLastUpdate = subcontractorRow.getTsLastUpdate();
    }
  }

  if (ccon17so != null)
  {
    if( ccon17so.getSzNmResource()!=null )
    {
      tmpSzNmResource = ccon17so.getSzNmResource();
    }
    tmpUIdRsrcLinkChild = request.getParameter("txtNewIdResource");
  }

  if("A".equalsIgnoreCase(szCReqFuncCd))
  {
    deleteButtonHide = true;
  }
  if("true".equalsIgnoreCase(childPlacingAgency) && "U".equalsIgnoreCase(szCReqFuncCd) )
  {
    subContractorIdDisable = "true";
    serviceDisable = "true";
    deleteButtonHide = true;
    validateButtonHide = true;
    saveButtonHide = true;
  } else if("false".equalsIgnoreCase(childPlacingAgency) && "U".equalsIgnoreCase(szCReqFuncCd) )
  {
    subContractorIdDisable = "true";
    validateButtonHide = true;
  }
  if( pageMode.equals(PageModeConstants.VIEW) )
  {
    validateButtonHide = true;
    deleteButtonHide = true;
    saveButtonHide = true;
  }

  if( request.getParameter("classResource") != null && "true".equalsIgnoreCase(request.getParameter("classResource")) )
  {
    classResource = "true";
    deleteButtonHide = true;
  }

  int tabIndex = 1;


      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<SCRIPT LANGUAGE=JavaScript>\r\nvar serviceCodesArray = new Array();\r\n");

if( servicesList != null && servicesList.length > 0 )
{
  servicesList = StringHelper.removeDuplicates( servicesList );
  for( int i = 0; i < servicesList.length; i++ )
  {
    
      out.write("\r\n    serviceCodesArray[");
      out.print(i);
      out.write("] = '");
      out.print(servicesList[i]);
      out.write("'+'|'+ '");
      out.print(Lookup.simpleDecodeSafe("CSVCCODE", servicesList[i] ));
      out.write("';\r\n    ");

  }
}
else{

      out.write("\r\n  serviceCodesArray = null;\r\n");
}
      out.write("\r\n\r\n /*\r\n  * This function is called when the page loads.\r\n  */\r\n  window.attachEvent('onload', populateDD );\r\n  function populateDD()\r\n  {\r\n    populateServiceDropDown();\r\n  }\r\n\r\n /*\r\n  * This function is called before the page unloads.\r\n  */\r\n  window.attachEvent('onbeforeunload', populateDD );\r\n  function setDirty()\r\n  {\r\n    IsDirty();\r\n  }\r\n\r\n\r\n /*\r\n  *This function is used to populate the services drop down.\r\n  */\r\nfunction populateServiceDropDown()\r\n{\r\n  var fieldName = \"selCdRsrcSvcService\";\r\n  if( document.frmSubcontractorDetail.selCdRsrcSvcService.type != \"select-one\" )\r\n  {\r\n    fieldName = \"selCdRsrcSvcService_Disabled\";\r\n  }\r\n  if( serviceCodesArray != null )\r\n  {\r\n    eval(\"document.frmSubcontractorDetail.\"+fieldName+\".options.length = serviceCodesArray.length +1;\");\r\n    for( var j=0; j < serviceCodesArray.length; j++){\r\n      //populates the drop-down box with the values from the serviceCodesArray\r\n      alert(serviceCodesArray[j]);\r\n      eval(\"document.frmSubcontractorDetail.\"+fieldName+\".options[j].value = serviceCodesArray[j].substring(0,serviceCodesArray[j].indexOf(\\\"|\\\"));\");\r\n");
      out.write("      eval(\"document.frmSubcontractorDetail.\"+fieldName+\".options[j].defaultSelected = false\");\r\n      eval(\"document.frmSubcontractorDetail.\"+fieldName+\".options[j].text = serviceCodesArray[j].substring(serviceCodesArray[j].indexOf(\\\"|\\\")+1,serviceCodesArray[j].length);\");\r\n    }\r\n\r\n    eval(\"document.frmSubcontractorDetail.\"+fieldName+\".value = \\\"");
      out.print(tmpsubcontractorRowService);
      out.write("\\\"\");\r\n\r\n    if(  eval(\"document.frmSubcontractorDetail.\"+fieldName+\".selectedIndex != -1\"))\r\n    {\r\n      eval(\"document.frmSubcontractorDetail.\"+fieldName+\".options[document.frmSubcontractorDetail.\"+fieldName+\".selectedIndex].defaultSelected = true\");\r\n    }\r\n  }\r\n\r\n}\r\n\r\n /*\r\n  *This function is used to save subcontractor detail.\r\n  */\r\nfunction submitSubcontractorDetail()\r\n{\r\n  var doSave = false;\r\n\r\n   window.onbeforeunload = null;\r\n   var x = document.frmSubcontractorDetail;\r\n   if( x.tmpSzNmResource.value != null && x.tmpSzNmResource.value != \"\" )\r\n   {\r\n     x.txtNewIdResource.value = x.txtuIdRsrcLinkChild.value;\r\n     doSave = true;\r\n   }\r\n   else\r\n   {\r\n      setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("SSM_VALIDATE_SUBCONTRACTOR"));
      out.write("\");\r\n   }\r\n\r\n   return doSave;\r\n}\r\n\r\n /*\r\n  *This function is used to submit the form to validate the subcontractor id.\r\n  */\r\nfunction validateSubContractor()\r\n{\r\n  window.onbeforeunload = null;\r\n  var x = document.frmSubcontractorDetail;\r\n  disableValidation('frmSubcontractorDetail');\r\n  x.txtNewIdResource.value = x.txtuIdRsrcLinkChild.value;\r\n  return true;\r\n}\r\n\r\n /*\r\n  *This function is used to submit the form to delete a subcontractor record.\r\n  */\r\nfunction deleteSubcontractorRow()\r\n{\r\n  var doDelete = false;\r\n\r\n  window.onbeforeunload = null;\r\n  var cnfrm = window.confirm(\"");
      out.print(MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE"));
      out.write("\")\r\n  if(cnfrm)\r\n  {\r\n    document.frmSubcontractorDetail.cReqFuncCd.value = 'D';\r\n    disableValidation('frmSubcontractorDetail');\r\n    doDelete = true;\r\n  }\r\n\r\n  return doDelete;\r\n}\r\n\r\n//End Java Script-->\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSubcontractorDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceDetail/saveSubcontractorDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("txtuIdRsrcLinkParent");
          _jspx_th_impact_validateInput_0.setValue(txtuIdRsrcLinkParent);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("txtuIdRsrcLink");
          _jspx_th_impact_validateInput_1.setValue(tmpUIdRsrcLink);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("txtUlIdResource");
          _jspx_th_impact_validateInput_2.setValue(txtUlIdResource);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("indexNum");
          _jspx_th_impact_validateInput_3.setValue(idIndex);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("rbSubcontractorCheckboxIndex");
          _jspx_th_impact_validateInput_4.setValue(idIndex);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("txtTsLastUpdate");
          _jspx_th_impact_validateInput_5.setValue(SerializationHelper.serializeObject( tmpTsLastUpdate ));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("cReqFuncCd");
          _jspx_th_impact_validateInput_7.setValue(szCReqFuncCd);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("classResource");
          _jspx_th_impact_validateInput_9.setValue(classResource);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("fadResource");
          _jspx_th_impact_validateInput_10.setValue(fadResource);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("childPlacingAgency");
          _jspx_th_impact_validateInput_11.setValue(childPlacingAgency);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("servicesArray");
          _jspx_th_impact_validateInput_12.setValue(SerializationHelper.serializeObject(servicesList));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n   <table width=\"100%\" class=\"tableborder\" cellSpacing=\"0\" cellPadding=\"3\" border=\"0\">\r\n     <tr>\r\n             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setLabel("Resource ID");
          _jspx_th_impact_validateInput_13.setName("txtuIdRsrcLinkChild");
          _jspx_th_impact_validateInput_13.setId("txtuIdRsrcLinkChild_Id");
          _jspx_th_impact_validateInput_13.setRequired("true");
          _jspx_th_impact_validateInput_13.setDisabled(subContractorIdDisable);
          _jspx_th_impact_validateInput_13.setValue(tmpUIdRsrcLinkChild);
          _jspx_th_impact_validateInput_13.setConstraint("Numeric");
          _jspx_th_impact_validateInput_13.setTabIndex(1);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                       ");
if( !validateButtonHide ){
          out.write("\r\n                            &nbsp;&nbsp;");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnValidateSubcontractorRow");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("return validateSubContractor();");
          _jspx_th_impact_ButtonTag_0.setForm("frmSubcontractorDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceDetail/validateSubcontractorId");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n                       ");
}
          out.write("\r\n     </tr>\r\n     <tr>\r\n             <td class=\"FormLabel\" name=\"txtszNmResource\" width=\"150\">Resource Name:</td>\r\n             <td>");
          out.print(tmpSzNmResource);
          out.write("</td>\r\n                  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("tmpSzNmResource");
          _jspx_th_impact_validateInput_14.setValue(tmpSzNmResource);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </tr>\r\n     <tr>\r\n             <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selCdRsrcSvcService");
          _jspx_th_impact_validateSelect_0.setLabel("Service");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSVCCODE");
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 200px");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setId("selCdRsrcSvcService");
          _jspx_th_impact_validateSelect_0.setDisabled(serviceDisable);
          _jspx_th_impact_validateSelect_0.setTabIndex(3);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     </tr>\r\n    </table>\r\n\r\n    <table width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" border=\"0\">\r\n      <tr>\r\n          <td align=\"left\">\r\n                        ");
if( !deleteButtonHide ){
          out.write("\r\n                            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnDeleteSubcontractorRow");
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return deleteSubcontractorRow();");
          _jspx_th_impact_ButtonTag_1.setForm("frmSubcontractorDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ResourceDetail/deleteSubcontractorDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                        ");
} else{
          out.write("\r\n                &nbsp;\r\n                        ");
}
          out.write("\r\n                      </td>\r\n                      <td align=\"right\">\r\n             ");
if( !saveButtonHide ){
          out.write("\r\n                            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveSubcontractorRow");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setFunction("return submitSubcontractorDetail();");
          _jspx_th_impact_ButtonTag_2.setForm("frmSubcontractorDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/resource/ResourceDetail/saveSubcontractorDetail");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
} else{
          out.write("\r\n                            &nbsp;\r\n            ");
}
          out.write("\r\n              </td>\r\n      </tr>\r\n     </table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
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

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("txtNewIdResource");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("validationOverride");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
