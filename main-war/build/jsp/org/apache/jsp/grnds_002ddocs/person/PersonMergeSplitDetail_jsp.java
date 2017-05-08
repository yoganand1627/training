package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation;

public final class PersonMergeSplitDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Person Merge/Split Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 11/10/2002
//*
//*  Description:
//*  This JSP is used to Merge and Split people
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------


      out.write("\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  final String FORWARD = "1";
  final String CLOSED = "0";

  //Get the output object from the request
  ROWCCFC13SOG00 rowccfc13sog00 = (ROWCCFC13SOG00) request.getAttribute("ROWCCFC13SOG00");
  CCFC23SO ccfc23so = (CCFC23SO) request.getAttribute("CCFC23SO");
  String bIndActiveStatus = (String) request.getAttribute("bIndActiveStatus");
  String cSysIndPrimaryWorker = (String) request.getAttribute("cSysIndPrimaryWorker");
  String cWcdPersonPassedIn = (String) request.getAttribute("cWcdPersonPassedIn");
  String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
  String ulIdPersonClosed = "";
  String ulIdPersonForward = "";
  String szNmPersonFullForward = "";
  String szNmPersonFullClosed = "";
  String bIndValidate = "";
  int ulIdPerson = 0;
  String cSysIndError = "";
  // Initialize the booleans for enabling and disabling
  // the ID Person Forward and ID Person closed text fields
  String disableIDPersonClosed = "false";
  String disableIDPersonForward = "false";

  if (request.getAttribute("bIndValidate") != null)
  {
    bIndValidate = (String)request.getAttribute("bIndValidate");
  }

  if (GlobalData.getUlIdPerson( request ) != 0)
  {
    ulIdPerson = GlobalData.getUlIdPerson( request );
  }

  if (ccfc23so != null)
  {
    cSysIndError = ccfc23so.getCSysIndError();
  }
  if (rowccfc13sog00 == null) {
    rowccfc13sog00 = new ROWCCFC13SOG00();
  }

  //If the ReqFuncCd is equal to Update, place all of the correct infomation into the
  //Correct place from the row
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE))
  {
    ulIdPersonForward = FormattingHelper.formatString(String.valueOf(rowccfc13sog00.getUlIdPersMergeForward()));
    ulIdPersonClosed = FormattingHelper.formatString(String.valueOf(rowccfc13sog00.getUlIdPersMergeClosed()) );
    szNmPersonFullForward =  FormattingHelper.formatString(rowccfc13sog00.getSzScrNmPersMergeForward());
    szNmPersonFullClosed =FormattingHelper.formatString(rowccfc13sog00.getSzScrNmPersMergeClosed());
    disableIDPersonClosed = "true";
    disableIDPersonForward = "true";
  }

  //If the ReqFucCd is equal to Add, place the person passed in information in the correct
  //place, depending on if the person passed in is an employee or not.  Else, set the
  //information to what is returned from rowccfc13sog00
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD))
  {
    //If the Person passed is going to be the forward person
    //place it in the forward division and the Forward ID Person
    //Input field will be disabled
    if (cWcdPersonPassedIn.equals(FORWARD))
    {
      if (ulIdPerson != 0)
      {

        ulIdPersonForward = String.valueOf(ulIdPerson);
        disableIDPersonClosed = "false";
        disableIDPersonForward = "true";
      }

      String szNmPersonFull = (String) request.getAttribute("szNmPersonFull");
      if (szNmPersonFull != null)
      {
        szNmPersonFullForward = szNmPersonFull;
      }
      ulIdPersonClosed = "";
      szNmPersonFullClosed = "";
    }
    // Else put the information in the closed Person ID block, and disable the
    // closed Person ID input field
    else
    {
      if (ulIdPerson != 0)
      {
        ulIdPersonClosed = String.valueOf(ulIdPerson);
        disableIDPersonClosed = "true";
        disableIDPersonForward = "false";
      }
      String szNmPersonFull = (String) request.getAttribute("szNmPersonFull");
      if (szNmPersonFull != null)
      {
        szNmPersonFullClosed = szNmPersonFull;
      }
      ulIdPersonForward = "";
      szNmPersonFullForward = "";
    }
  }
  else if (cReqFuncCd.equals(PersonDetailConversation.VALIDATE))
  {
    //If the ReqFuncCd is "V", we are returning from the validate method,
    //the IDs and Names need to be gotten from the request, and the
    //reqFuncCd needs to be re-set to Add.
    cReqFuncCd = (ServiceConstants.REQ_FUNC_CD_ADD);
    // If the Person being validated is the Closed Person (I.E. the person forward already has
    // the name associated with him/her), the szNmPersonFull returned
    // from the service is the person name for the closed person, so populate the closed
    // person name from the service output
    if (cWcdPersonPassedIn.equals(FORWARD))
    {

      String ulIdPersonF = (String) request.getAttribute("txtUlIdPersMergeForward");
      if (ulIdPersonF != null)
      {
        ulIdPersonForward = ulIdPersonF;
        disableIDPersonClosed = "false";
        disableIDPersonForward = "true";
      }

      String szNmPersonFullF = (String) request.getAttribute("dspSzScrNmPersMergeForward");
      if (szNmPersonFullF != null)
      {
        szNmPersonFullForward = szNmPersonFullF;
      }
      String ulIdPersonC = (String) request.getAttribute("txtUlIdPersMergeClosed");
      if (ulIdPersonC != null)
      {
        ulIdPersonClosed = ulIdPersonC;
      }
      String szNmPersonFullC = FormattingHelper.formatString(ccfc23so.getSzNmPersonFull());
      if (szNmPersonFullC != null)
      {
        szNmPersonFullClosed = szNmPersonFullC;
      }
    }
    // Else, the Person passed in is the closed person, and the person forward is the
    // person being validated, so put the forward full name as the service output
    else
    {

      String ulIdPersonF = (String) request.getAttribute("txtUlIdPersMergeForward");
      if (ulIdPersonF != null)
      {
        ulIdPersonForward = ulIdPersonF;
        disableIDPersonClosed = "true";
        disableIDPersonForward = "false";
      }

      String szNmPersonFullF = FormattingHelper.formatString(ccfc23so.getSzNmPersonFull());
      if (szNmPersonFullF != null)
      {
        szNmPersonFullForward = szNmPersonFullF;
      }
      String ulIdPersonC = (String) request.getAttribute("txtUlIdPersMergeClosed");
      if (ulIdPersonC != null)
      {
        ulIdPersonClosed = ulIdPersonC;
      }
      String szNmPersonFullC = (String) request.getAttribute("dspSzScrNmPersMergeClosed");
      if (szNmPersonFullC != null)
      {
        szNmPersonFullClosed = szNmPersonFullC;
      }
    }
  }
  else if (cReqFuncCd.equals(PersonDetailConversation.SWITCH))
  {

    //If the ReqFuncCd is "S", it has been set in the Switch Method to this,
    // so the reqFuncCd needs to be changed back to add, and the id persons, and names
    // need to be switched.
    cReqFuncCd = (ServiceConstants.REQ_FUNC_CD_ADD);
    if (cWcdPersonPassedIn.equals(FORWARD))
    {
      String ulIdPersonF = (String) request.getAttribute("txtUlIdPersMergeClosed");
      if (ulIdPersonF != null)
      {
        ulIdPersonForward = ulIdPersonF;
        disableIDPersonClosed = "false";
        disableIDPersonForward = "true";
      }

      String szNmPersonFullF = (String) request.getAttribute("dspSzScrNmPersMergeClosed");
      if (szNmPersonFullF != null)
      {
        szNmPersonFullForward = szNmPersonFullF;
      }
      String ulIdPersonC = (String) request.getAttribute("txtUlIdPersMergeForward");
      if (ulIdPersonC != null)
      {
        ulIdPersonClosed = ulIdPersonC;
      }
      szNmPersonFullClosed = "";
    }
    else
    {

      String ulIdPersonF = (String) request.getAttribute("txtUlIdPersMergeClosed");
      if (ulIdPersonF != null)
      {
        ulIdPersonForward = ulIdPersonF;
        disableIDPersonClosed = "true";
        disableIDPersonForward = "false";
      }

      szNmPersonFullForward = "";

      String ulIdPersonC = (String) request.getAttribute("txtUlIdPersMergeForward");
      if (ulIdPersonC != null)
      {
        ulIdPersonClosed = ulIdPersonC;
      }
      String szNmPersonFullC = (String) request.getAttribute("dspSzScrNmPersMergeForward");
      if (szNmPersonFullC != null)
      {
        szNmPersonFullClosed = szNmPersonFullC;
      }
    }
  }//End if reqfunccd = "S" (switch)

// Used disableIDPersonClosed and disableIDPersonForward to disable the ID text boxes
// in the appropriate manner in the above ifs.  However, if we are not in set A, we want
// to disable them regardless.

  if (!Sets.isInSet(Sets.A, request))
  {
    disableIDPersonClosed = "true";
    disableIDPersonForward = "true";
  }

  /**
  *  Page Mode Logic
  *
  *   1.  VIEW - Will have the following sets:
  *       a.  If the person has Maintain Person, or Merge Person
  *           Security attributes
  *   2.  EDIT -- Will have the following sets:
  *       a.  If the Person is the Primary worker, or in the Primary
  *           Hierarchy
  *
  * All of the Person Detail page modes other than View will be treated as Edit.
  *
  */

  String pageModePassed = "";
  String overallPageMode = PageModeConstants.EDIT;

   if (request.getAttribute("pageMode") != null )
   {
     pageModePassed = (String) request.getAttribute("pageMode");
     if (pageModePassed.equals(PageModeConstants.MODIFY))
     {
       overallPageMode = PageModeConstants.EDIT;
     }
     else if (pageModePassed.equals(PageModeConstants.VIEW))
     {
       overallPageMode = PageModeConstants.VIEW;
     }
 }


      out.write('\r');
      out.write('\n');
 // Start Javascript Section
 
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");

      int ulIdPersonC = 0;
      int ulIdPersonF = 0;
      if ( StringHelper.isValid(ulIdPersonClosed))
      {
        ulIdPersonC = Integer.parseInt(ulIdPersonClosed);
      }
      if ( StringHelper.isValid(ulIdPersonForward))
      {
        ulIdPersonF = Integer.parseInt(ulIdPersonForward);
      }


      out.write("\r\n\r\n  function mergePerson()\r\n  {\r\n      if (frmMergeSplitDetail.hdnBIndValidate.value == \"Y\")\r\n      {\r\n        ");

        String message = "";
        message = MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_MERGE) ;
        message = MessageLookup.addMessageParameter( message, ulIdPersonC );
        message = MessageLookup.addMessageParameter( message, ulIdPersonF );
        
      out.write("\r\n        bMerge = confirm(\"");
      out.print( message );
      out.write(" \")\r\n        return bMerge;\r\n      }\r\n      else\r\n      {\r\n        alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_VAL_MERGE) );
      out.write("');\r\n        return false;\r\n      }\r\n    }\r\n    function splitPerson()\r\n    {\r\n        ");

        message = "";
        message = MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_SPLIT) ;
        message = MessageLookup.addMessageParameter( message, ulIdPersonC );
        message = MessageLookup.addMessageParameter( message, ulIdPersonF );
        
      out.write("\r\n        bMerge = confirm(\"");
      out.print( message );
      out.write(" \")\r\n        return bMerge;\r\n    }\r\n    function notValid()\r\n    {\r\n      frmMergeSplitDetail.hdnBIndValidate.value=\"N\";\r\n    }\r\n\r\n    //  Called onUnload of page to remind user unsaved data will be lost\r\n    window.onbeforeunload = function ()\r\n    {\r\n       IsDirty();\r\n    }\r\n\r\n</script>\r\n\r\n\r\n");

  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmMergeSplitDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonDetail/saveMergeSplit");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.MergeSplitCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnBIndActiveStatus");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatString(bIndActiveStatus)  );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnCSysIndPrimaryWorker");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatString(cSysIndPrimaryWorker));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_2.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnCWcdPersonPassedIn");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatString(cWcdPersonPassedIn)  );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnTsMergeLastUpdate");
          _jspx_th_impact_validateInput_4.setValue( DateHelper.toISOStringSafe(rowccfc13sog00.getTsLastUpdate())  );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnUlIdPersMergeWrkr");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatInt(rowccfc13sog00.getUlIdPersMergeWrkr()) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnUlIdPersonMerge");
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatInt(rowccfc13sog00.getUlIdPersonMerge()));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnBIndValidate");
          _jspx_th_impact_validateInput_7.setValue( FormattingHelper.formatString(bIndValidate)  );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnCSysIndError");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatString(cSysIndError));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \r\n \r\n ");
 /* Begin Detail */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"4\">Forward</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("Person ID");
          _jspx_th_impact_validateInput_9.setConstraint("ID");
          _jspx_th_impact_validateInput_9.setName("txtUlIdPersMergeForward");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setDisabled(disableIDPersonForward);
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatString(ulIdPersonForward)  );
          _jspx_th_impact_validateInput_9.setSize("10");
          _jspx_th_impact_validateInput_9.setMaxLength("10");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzScrNmPersMergeForward");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString(szNmPersonFullForward)  );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <th colspan=\"4\">Closed</th>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setLabel("Person ID");
          _jspx_th_impact_validateInput_10.setConstraint("ID");
          _jspx_th_impact_validateInput_10.setName("txtUlIdPersMergeClosed");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setDisabled(disableIDPersonClosed );
          _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatString(ulIdPersonClosed)  );
          _jspx_th_impact_validateInput_10.setSize("10");
          _jspx_th_impact_validateInput_10.setMaxLength("10");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspSzScrNmPersMergeClosed");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatString(szNmPersonFullClosed)  );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <th colspan=\"4\">Merge Information</th>\r\n  <tr>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspSzScrNmPersMergeWrkr");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Staff Name Merge");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatString(rowccfc13sog00.getSzScrNmPersMergeWrkr()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspDtDtPersMerge");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Date Merge");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate(rowccfc13sog00.getDtDtPersMerge()));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <th colspan=\"4\">Split Information</th>\r\n  <tr>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dspSzScrNmPersMrgSpltWrkr");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Staff Name Split");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatString(rowccfc13sog00.getSzScrNmPersMrgSpltWrkr()));
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dspDtDtPersMergeSplit");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Date Split");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatDate(rowccfc13sog00.getDtDtPersMergeSplit()));
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n\r\n\r\n</table>\r\n");

   //Only display Validate, Switch and Merge if the user is adding a row.  Else,
   //only display the split button if we are updating a row, and the row has not been
   //previously split, also only display any of these pushbuttons if we are in set A

          out.write("\r\n      <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n          <tr>\r\n          <td width=\"80%\"></td>\r\n          ");
 if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD))
            { 
          out.write("\r\n          <td>\r\n               <div class=\"alignRight\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnValidate");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setDisabled( Sets.isNotInSetStr(Sets.A, request) );
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_ButtonTag_0.setForm("frmMergeSplitDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/person/PersonDetail/validateMerge");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</div>\r\n           </td>\r\n           <td>\r\n              <div class=\"alignRight\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSwitch");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setImg("btnSwitch");
          _jspx_th_impact_ButtonTag_1.setDisabled( Sets.isNotInSetStr(Sets.A, request) );
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_ButtonTag_1.setForm("frmMergeSplitDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/person/PersonDetail/switchMerge");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</div>\r\n           </td>\r\n           <td>\r\n              <div class=\"alignRight\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnMerge");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setImg("btnMerge");
          _jspx_th_impact_ButtonTag_2.setDisabled( Sets.isNotInSetStr(Sets.A, request) );
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_ButtonTag_2.setFunction("return mergePerson()");
          _jspx_th_impact_ButtonTag_2.setForm("frmMergeSplitDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/person/PersonDetail/saveMergeSplit");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</div>\r\n           </td>\r\n           ");
 } else if ( cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE) && rowccfc13sog00.getUlIdPersMergeSplitWrkr() == 0 ) { 
          out.write("\r\n             <td>\r\n              <div class=\"alignRight\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSplit");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setImg("btnSplit");
          _jspx_th_impact_ButtonTag_3.setDisabled( Sets.isNotInSetStr(Sets.A, request) );
          _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT + EditableMode.VIEW );
          _jspx_th_impact_ButtonTag_3.setFunction("return splitPerson()");
          _jspx_th_impact_ButtonTag_3.setForm("frmMergeSplitDetail");
          _jspx_th_impact_ButtonTag_3.setAction("/person/PersonDetail/saveMergeSplit");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</div>\r\n           </td>\r\n           ");
 } 
          out.write("\r\n      </tr>\r\n      </table>\r\n");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
      out.write("\r\n\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n</script>\r\n\r\n");
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
