package org.apache.jsp.grnds_002ddocs.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
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

public final class SubcontractorSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*--------------------------------------------------------------------------------
//*  JSP Name:     Subcontractor Detail
//*  Created by:   Donald Wilson
//*  Date Created: 04/02/03
//*
//*  Description:
//*  This JSP displays the Subcontractor Details.
//*
//*  Change History:
//*  Date      User         Description
//*  --------  -----------  -------------------------------------------------------
//*  07/08/03  JRIOS        Added code to populate the 'Service' drop-down list with
//*                         the services provided by the Prime Resource because those
//*                         are the only ones that should be provided by the sub-
//*                         contractor.
//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String SubcontractorSubvtmpSzNmResource = "";
  java.util.Date SubcontractorSubvtmpTsLastUpdate = null;
  String SubcontractorSubvtmpsubcontractorRowService = "";
  String SubcontractorSubvidIndex = "0";
  String SubcontractorSubvszCReqFuncCd = "";
  String SubcontractorSubvtmpUIdRsrcLinkChild = "";
  String SubcontractorSubvtmpUIdRsrcLink = "";
  String SubcontractorSubvtxtUIdRsrcLinkParent = "";
  String SubcontractorSubvtxtUlIdResource = "";
  String SubcontractorSubvclassResource = "false";
  String SubcontractorSubvfadResource = "false";
  String SubcontractorSubvchildPlacingAgency = "false";
  String SubcontractorSubvsubContractorIdDisable = "false";
  String SubcontractorSubvserviceDisable = "false";
  boolean SubcontractorSubvvalidateButtonHide = false;
  boolean SubcontractorSubvsaveButtonHide = false;
  boolean SubcontractorSubvdeleteButtonHide = false;
  ROWCCON15SOG01_ARRAY primeResourceSvcsArray = null;

  ROWCCON15SOG00_ARRAY SubcontractorSubvsubcontractorArray = null;
  ROWCCON15SOG00 SubcontractorSubvsubcontractorRow = null;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String SubcontractorSubvpageMode = PageMode.getPageMode(request);

  if( StringHelper.isValid(request.getParameter( "SubcontractorSubvtxtUIdRsrcLinkParent" ) ) )
  {
    SubcontractorSubvtxtUIdRsrcLinkParent =  request.getParameter( "SubcontractorSubvtxtUIdRsrcLinkParent" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvselCdRsrcSvcService" ) ) )
  {
    SubcontractorSubvtmpsubcontractorRowService = request.getParameter( "SubcontractorSubvselCdRsrcSvcService" );
  }
  if( StringHelper.isValid(request.getParameter( "SubcontractorSubvindexNum" ) ) )
  {
    SubcontractorSubvidIndex = request.getParameter( "SubcontractorSubvindexNum" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvcReqFuncCd" ) ) )
  {
    SubcontractorSubvszCReqFuncCd = request.getParameter( "SubcontractorSubvcReqFuncCd" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvtxtUlIdResource" ) ) )
  {
    SubcontractorSubvtxtUlIdResource = request.getParameter( "SubcontractorSubvtxtUlIdResource" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvtxtNewIdResource" ) ) )
  {
    SubcontractorSubvtmpUIdRsrcLinkChild = request.getParameter( "SubcontractorSubvtxtNewIdResource" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvchildPlacingAgency" )) && StringHelper.isTrue(request.getParameter( "SubcontractorSubvchildPlacingAgency" )))
  {
    SubcontractorSubvchildPlacingAgency = "true";
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvtmpSzNmResource" ))  )
  {
    SubcontractorSubvtmpSzNmResource = request.getParameter( "SubcontractorSubvtmpSzNmResource" );
  }

  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvtxtTsLastUpdate" ))  )
  {
    if (SerializationHelper.deserializeObject(request.getParameter( "SubcontractorSubvtxtTsLastUpdate" )) != null)
    {
      SubcontractorSubvtmpTsLastUpdate = (java.util.Date) SerializationHelper.deserializeObject(request.getParameter( "SubcontractorSubvtxtTsLastUpdate" ));
    }
  }

  CCON17SO ccon17so_SubcontractorSub = (CCON17SO) request.getAttribute( "CCON17S_SubcontractorValidate" );
  request.removeAttribute( "CCON17S_SubcontractorValidate" );


  ROWCRES05SOG00_ARRAY SubcontractorSubvservicesStruct = (ROWCRES05SOG00_ARRAY) request.getAttribute( "ROWCRES05SOG00_ARRAY_subcontractorDetail" );
  int SubcontractorSubvserviceSize = 0;
  if( SubcontractorSubvservicesStruct != null )
  {
    SubcontractorSubvserviceSize = SubcontractorSubvservicesStruct.getROWCRES05SOG00Count();
  }
  String[] SubcontractorSubvservicesList = new String[SubcontractorSubvserviceSize];
  if( SubcontractorSubvservicesStruct != null )
  {
    //Loop through and get all services for the resource
    for(int i=0; i<SubcontractorSubvservicesStruct.getROWCRES05SOG00Count(); i++ )
    {
      SubcontractorSubvservicesList[i] = SubcontractorSubvservicesStruct.getROWCRES05SOG00(i).getSzCdRsrcSvcService();
    }
  }

  if( request.getParameter("SubcontractorSubvservicesArray") != null )
  {
    SubcontractorSubvservicesList = (String[])SerializationHelper.deserializeObject(request.getParameter("SubcontractorSubvservicesArray"));
  }

  CCON15SO ccon15so = (CCON15SO)state.getAttribute( "CCON15S", request );
  if (ccon15so != null)
  {
    SubcontractorSubvsubcontractorArray = ccon15so.getROWCCON15SOG00_ARRAY();

    if ("A".equalsIgnoreCase(SubcontractorSubvszCReqFuncCd))
    {
      SubcontractorSubvtmpSzNmResource = "";
      SubcontractorSubvtmpUIdRsrcLinkChild = null;
    }
    else
    {
      SubcontractorSubvsubcontractorRow = SubcontractorSubvsubcontractorArray.getROWCCON15SOG00(Integer.parseInt(SubcontractorSubvidIndex));

      if( SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService() != null )
      {
        SubcontractorSubvtmpsubcontractorRowService = SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService();
      }
      SubcontractorSubvtmpSzNmResource = SubcontractorSubvsubcontractorRow.getSzNmResource();
      SubcontractorSubvtmpUIdRsrcLinkChild = String.valueOf( SubcontractorSubvsubcontractorRow.getUIdRsrcLinkChild());
      SubcontractorSubvtmpUIdRsrcLink = String.valueOf(SubcontractorSubvsubcontractorRow.getUIdRsrcLink());
      SubcontractorSubvtmpTsLastUpdate =  SubcontractorSubvsubcontractorRow.getTsLastUpdate();
    }

    // SIR 18632, JRIOS - Retrieve the list of services provided
    // by the Prime Resource.
    if ( ccon15so.getROWCCON15SOG01_ARRAY() != null )
    {
      primeResourceSvcsArray = ccon15so.getROWCCON15SOG01_ARRAY();
    }
  }

  if (ccon17so_SubcontractorSub != null)
  {
    if( ccon17so_SubcontractorSub.getSzNmResource()!=null )
    {
      SubcontractorSubvtmpSzNmResource = ccon17so_SubcontractorSub.getSzNmResource();
    }
    SubcontractorSubvtmpUIdRsrcLinkChild = request.getParameter("SubcontractorSubvtxtNewIdResource");
  }

  if("A".equalsIgnoreCase(SubcontractorSubvszCReqFuncCd))
  {
    SubcontractorSubvdeleteButtonHide = true;
  }

  if( StringHelper.isTrue(SubcontractorSubvchildPlacingAgency) && "U".equalsIgnoreCase(SubcontractorSubvszCReqFuncCd) )
  {
    SubcontractorSubvsubContractorIdDisable = "true";
    SubcontractorSubvserviceDisable = "true";
    SubcontractorSubvdeleteButtonHide = true;
    SubcontractorSubvvalidateButtonHide = true;
    SubcontractorSubvsaveButtonHide = true;
  }
  else if("false".equalsIgnoreCase(SubcontractorSubvchildPlacingAgency) && "U".equalsIgnoreCase(
          SubcontractorSubvszCReqFuncCd) )
  {
    SubcontractorSubvsubContractorIdDisable = "true";
    SubcontractorSubvvalidateButtonHide = true;
  }

  if( SubcontractorSubvpageMode.equals(PageModeConstants.VIEW) )
  {
    SubcontractorSubvvalidateButtonHide = true;
    SubcontractorSubvdeleteButtonHide = true;
    SubcontractorSubvsaveButtonHide = true;
  }

  if( request.getParameter("SubcontractorSubvclassResource") != null && "true".equalsIgnoreCase(request.getParameter(
          "SubcontractorSubvclassResource")) )
  {
    SubcontractorSubvclassResource = "true";
    SubcontractorSubvdeleteButtonHide = true;
  }

  // Get tabIndex out of the request
  String tabindexString = (String)request.getAttribute( "tabIndex" );
  int SubcontractorSubvtabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);

      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n// This function is called when the page loads.\r\nwindow.onload = function ()\r\n{\r\n  SubcontractorSubvpopulateServiceDropDown();\r\n}\r\n\r\n// This function is called before the page unloads.\r\nwindow.onbeforeunload = function ()\r\n{\r\n    IsDirty();\r\n}\r\n\r\n");

// SIR 18632, JRIOS - Added this JavaScript to create an array of
// the services provided by the Prime Resource. This array is used
// to populate the 'Service' drop-down list.
if( primeResourceSvcsArray != null )
{
      out.write("\r\n  var SubcontractorSubvserviceCodesArray = new Array();\r\n  ");

  int i = 0;
  Enumeration enumeration = primeResourceSvcsArray.enumerateROWCCON15SOG01();
  while( enumeration.hasMoreElements() )
  {
    ROWCCON15SOG01 service = (ROWCCON15SOG01)enumeration.nextElement();
    if("G".equalsIgnoreCase(service.getSzCdRsrcSvcServiceType())){
    
      out.write("\r\n    SubcontractorSubvserviceCodesArray[");
      out.print(i);
      out.write("] = \"");
      out.print( service.getSzCdRsrcSvcService() );
      out.write("\" + \"|\" + \"");
      out.print( Lookup.simpleDecodeSafe( CodesTables.CGLSVCCD, service.getSzCdRsrcSvcService() ) );
      out.write("\";\r\n    ");

    }
    i++;
  }
}

      out.write("\r\n\r\n// This function is used to populate the 'Services' drop-down list.\r\nfunction SubcontractorSubvpopulateServiceDropDown()\r\n{\r\n  var fieldName = \"SubcontractorSubvselCdRsrcSvcService\";\r\n  if( document.SubcontractorSubvfrmSubcontractorDetail.SubcontractorSubvselCdRsrcSvcService.type != \"select-one\" )\r\n  {\r\n    fieldName = \"SubcontractorSub_selCdRsrcSvcService_Disabled\";\r\n  }\r\n\r\n  if( SubcontractorSubvserviceCodesArray != null )\r\n  {\r\n    eval(\"document.SubcontractorSubvfrmSubcontractorDetail.\"+fieldName+\".options.length = SubcontractorSubvserviceCodesArray.length + 1;\");\r\n    for( var j=0; j < SubcontractorSubvserviceCodesArray.length; j++)\r\n    {\r\n      // Populates the drop-down list with the values from the serviceCodesArray.\r\n      eval(\"document.SubcontractorSubvfrmSubcontractorDetail.\"+fieldName+\".options[j].value = SubcontractorSubvserviceCodesArray[j].substring(0,SubcontractorSubvserviceCodesArray[j].indexOf(\\\"|\\\"));\");\r\n      eval(\"document.SubcontractorSubvfrmSubcontractorDetail.\"+fieldName+\".options[j].defaultSelected = false\");\r\n");
      out.write("      eval(\"document.SubcontractorSubvfrmSubcontractorDetail.\"+fieldName+\".options[j].text = SubcontractorSubvserviceCodesArray[j].substring(SubcontractorSubvserviceCodesArray[j].indexOf(\\\"|\\\")+1,SubcontractorSubvserviceCodesArray[j].length);\");\r\n    }\r\n\r\n    eval(\"document.SubcontractorSubvfrmSubcontractorDetail.\"+fieldName+\".value = \\\"");
      out.print(SubcontractorSubvtmpsubcontractorRowService);
      out.write("\\\"\");\r\n    if( eval(\"document.SubcontractorSubvfrmSubcontractorDetail.\"+fieldName+\".selectedIndex != -1\") )\r\n    {\r\n      eval(\"document.SubcontractorSubvfrmSubcontractorDetail.\"+fieldName+\".options[document.SubcontractorSubvfrmSubcontractorDetail.\"+fieldName+\".selectedIndex].defaultSelected = true\");\r\n    }\r\n  }\r\n}\r\n\r\n// This function is used to save subcontractor detail.\r\nfunction SubcontractorSubvsubmitSubcontractorDetail()\r\n{\r\n  var doSave = false;\r\n\r\n   window.onbeforeunload = null;\r\n   var x = document.SubcontractorSubvfrmSubcontractorDetail;\r\n   if( x.SubcontractorSubvtmpSzNmResource.value != null &&\r\n       x.SubcontractorSubvtmpSzNmResource.value != \"\" &&\r\n       x.SubcontractorSubvtxtUIdRsrcLinkChild.value != \"\" )\r\n   {\r\n     x.SubcontractorSubvtxtNewIdResource.value = x.SubcontractorSubvtxtUIdRsrcLinkChild.value;\r\n     doSave = true;\r\n   }\r\n   else\r\n   {\r\n      if ( x.SubcontractorSubvtxtUIdRsrcLinkChild.value != \"\" )\r\n      {\r\n        setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("SSM_VALIDATE_SUBCONTRACTOR"));
      out.write("\");\r\n      }else\r\n      {\r\n        setInformationalMessage(\"Please enter a Subcontractor Id and validate.\");\r\n      }\r\n   }\r\n\r\n   return doSave;\r\n}\r\n\r\n// This function is used to submit the form to validate the subcontractor id.\r\nfunction SubcontractorSubvvalidateSubContractor()\r\n{\r\n  window.onbeforeunload = null;\r\n  var x = document.SubcontractorSubvfrmSubcontractorDetail;\r\n  disableValidation('SubcontractorSubvfrmSubcontractorDetail');\r\n  x.SubcontractorSubvtxtNewIdResource.value = x.SubcontractorSubvtxtUIdRsrcLinkChild.value;\r\n  return true;\r\n}\r\n\r\n// This function is used to submit the form to delete a subcontractor record.\r\nfunction SubcontractorSubvdeleteSubcontractorRow()\r\n{\r\n  var doDelete = false;\r\n\r\n  window.onbeforeunload = null;\r\n  var cnfrm = window.confirm(\"");
      out.print(MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE"));
      out.write("\");\r\n  if(cnfrm)\r\n  {\r\n    document.SubcontractorSubvfrmSubcontractorDetail.SubcontractorSubvcReqFuncCd.value = 'D';\r\n    disableValidation('SubcontractorSubvfrmSubcontractorDetail');\r\n    doDelete = true;\r\n  }\r\n\r\n  return doDelete;\r\n}\r\n//End Java Script-->\r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("SubcontractorSubvfrmSubcontractorDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceDetail/saveSubcontractorDetail");
      _jspx_th_impact_validateForm_0.setPageMode(SubcontractorSubvpageMode);
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
          _jspx_th_impact_validateInput_0.setName("SubcontractorSubvtxtUIdRsrcLinkParent");
          _jspx_th_impact_validateInput_0.setValue(SubcontractorSubvtxtUIdRsrcLinkParent);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("SubcontractorSubvtxtUIdRsrcLink");
          _jspx_th_impact_validateInput_1.setValue(SubcontractorSubvtmpUIdRsrcLink);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("SubcontractorSubvtxtUlIdResource");
          _jspx_th_impact_validateInput_2.setValue(SubcontractorSubvtxtUlIdResource);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("SubcontractorSubvindexNum");
          _jspx_th_impact_validateInput_3.setValue(SubcontractorSubvidIndex);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("SubcontractorSubvrbSubcontractorCheckboxIndex");
          _jspx_th_impact_validateInput_4.setValue(SubcontractorSubvidIndex);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("SubcontractorSubvtxtTsLastUpdate");
          _jspx_th_impact_validateInput_5.setValue(SerializationHelper.serializeObject(SubcontractorSubvtmpTsLastUpdate));
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
          _jspx_th_impact_validateInput_7.setName("SubcontractorSubvcReqFuncCd");
          _jspx_th_impact_validateInput_7.setValue(SubcontractorSubvszCReqFuncCd);
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
          _jspx_th_impact_validateInput_9.setName("SubcontractorSubvclassResource");
          _jspx_th_impact_validateInput_9.setValue(SubcontractorSubvclassResource);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("SubcontractorSubvfadResource");
          _jspx_th_impact_validateInput_10.setValue(SubcontractorSubvfadResource);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("SubcontractorSubvchildPlacingAgency");
          _jspx_th_impact_validateInput_11.setValue(SubcontractorSubvchildPlacingAgency);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("SubcontractorSubvservicesArray");
          _jspx_th_impact_validateInput_12.setValue(SerializationHelper.serializeObject(SubcontractorSubvservicesList));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n  ");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  <table width=\"100%\" class=\"tableborder\" cellSpacing=\"0\" cellPadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <th colspan=\"2\">Service Site/Subcontractor Detail</th></tr>\r\n      <tr>\r\n        <td width=\"20%\">\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setLabel("Resource ID");
          _jspx_th_impact_validateInput_13.setSize("10");
          _jspx_th_impact_validateInput_13.setMaxLength("10");
          _jspx_th_impact_validateInput_13.setName("SubcontractorSubvtxtUIdRsrcLinkChild");
          _jspx_th_impact_validateInput_13.setId("SubcontractorSub_txtUIdRsrcLinkChild_Id");
          _jspx_th_impact_validateInput_13.setRequired("true");
          _jspx_th_impact_validateInput_13.setDisabled(SubcontractorSubvsubContractorIdDisable);
          _jspx_th_impact_validateInput_13.setValue(SubcontractorSubvtmpUIdRsrcLinkChild);
          _jspx_th_impact_validateInput_13.setConstraint("ID");
          _jspx_th_impact_validateInput_13.setTabIndex(SubcontractorSubvtabIndex);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");

          if ( !SubcontractorSubvvalidateButtonHide )
          {
          out.write("\r\n            &nbsp;&nbsp;\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("SubcontractorSubvbtnValidateSubcontractorRow");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("return SubcontractorSubvvalidateSubContractor();");
          _jspx_th_impact_ButtonTag_0.setForm("SubcontractorSubvfrmSubcontractorDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/SubcontractorSub/validateSubcontractorId");
          _jspx_th_impact_ButtonTag_0.setTabIndex(SubcontractorSubvtabIndex);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
}
          out.write("\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td>\r\n          ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Resource Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setName("SubcontractorSubvtmpSzNmResource");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(SubcontractorSubvtmpSzNmResource);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td>\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("SubcontractorSubvselCdRsrcSvcService");
          _jspx_th_impact_validateSelect_0.setLabel("Service");
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setId("SubcontractorSub_selCdRsrcSvcService_Id");
          _jspx_th_impact_validateSelect_0.setDisabled(SubcontractorSubvserviceDisable);
          _jspx_th_impact_validateSelect_0.setTabIndex(SubcontractorSubvtabIndex);
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 180px");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <table width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <td align=\"left\">\r\n        ");
if( !SubcontractorSubvdeleteButtonHide ){
          out.write("\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("SubcontractorSubvbtnDeleteSubcontractorRow");
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return SubcontractorSubvdeleteSubcontractorRow();");
          _jspx_th_impact_ButtonTag_1.setForm("SubcontractorSubvfrmSubcontractorDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/SubcontractorSub/deleteSubcontractorDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex(SubcontractorSubvtabIndex);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
} else {
          out.write("\r\n          &nbsp;\r\n        ");
}
          out.write("\r\n      </td>\r\n      <td align=\"right\">\r\n        ");
 if( !SubcontractorSubvsaveButtonHide ){
          out.write("\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("SubcontractorSubvbtnSaveSubcontractorRow");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setFunction("return SubcontractorSubvsubmitSubcontractorDetail();");
          _jspx_th_impact_ButtonTag_2.setForm("SubcontractorSubvfrmSubcontractorDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/resource/SubcontractorSub/saveSubcontractorDetail");
          _jspx_th_impact_ButtonTag_2.setTabIndex(SubcontractorSubvtabIndex);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
} else {
          out.write("\r\n          &nbsp;\r\n        ");
}
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n<input type=\"hidden\" name=\"");
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

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("SubcontractorSubvtxtNewIdResource");
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
    _jspx_th_impact_validateInput_8.setName("SubcontractorSubvvalidationOverride");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateErrors_0.setFormName("SubcontractorSubvfrmSubcontractorDetail");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
