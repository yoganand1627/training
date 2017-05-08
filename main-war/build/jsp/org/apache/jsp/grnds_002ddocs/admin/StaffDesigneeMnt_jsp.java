package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.admin.MntainDesigneeConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class StaffDesigneeMnt_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*   JSP Name:     Staff Designee Mnt.jsp
//*   Created by:   Eric Dickman
//*   Date Created: 12/10/02
//*
//*   This window allows supervisors and above to view a list of
//*   all employees who currently are designated to act as them.
//*   In addition, the user can add new assignments and modify or
//*   delete existing assignments.
//*
//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/10/02  Eric Dickman      Created initial docuement.
//**  07/24/05 Mike Werle    SIR 23728 - Moved constants for code reuse in MPS
//**


      out.write("\r\n\r\n\r\n");
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int tabIndex = 1;

  // variables used for the Hor. Row
  boolean hrNoDesignee = false;
  boolean hrPullback = false;

  boolean hideHr = false;

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  //Sets page mode to Edit
  String pageMode = PageMode.getPageMode(request);

  if (!PageModeConstants.VIEW.equals(pageMode))
  {
    hrNoDesignee = true;
  }
  else
  {
    hideHr = true;
  }

  //Sets CARC16SO to State
  CARC16SO carc16so = (CARC16SO)state.getAttribute( MntainDesigneeConversation.DESIGNEE_INFO, request);
  int numRows = 0;

  if(carc16so != null)
  {
    numRows = carc16so.getArchOutputStruct().getUlRowQty();
  }

  //Ensures carc16so in not null
  if (carc16so == null)
  {
    carc16so = new CARC16SO();
  }

   //Checks to ensure that ROWCARC14SOG00_ARRAY is not null and creates a new object.
  ROWCARC14SOG00_ARRAY rowcarc14sog00Array = null;
  if ( carc16so.getROWCARC14SOG00_ARRAY() == null )
  {
    rowcarc14sog00Array = new ROWCARC14SOG00_ARRAY();
  }
  else
  {
    rowcarc14sog00Array = carc16so.getROWCARC14SOG00_ARRAY();
  }

  //Disables only widgets that need to be hidden or disabled until the user saves the Designee Pullback section
  String pullBack = null;

  if(request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null)
  {
    pullBack  =  "true";
    hrPullback = true;
    hideHr = true;
  }
  else
  {
    pullBack = "false";
  }

  //Disables Save and Delete on the load of the page and if no Designee are chosen a message is displayed.
  String noDesignee = null;
  if((request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null) || (rowcarc14sog00Array.getUlRowQty() == 0))
  {
    noDesignee  =  "true";
    hideHr = true;
  }
  else
  {
    noDesignee = "false";
  }

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n  //Sets variables to hidden fields when the user clicks on the radio button on Staff Designee Mnt .jsp\r\n  function setHiddenFields(DtAssignExpiration, UlIdEmpTempAssign , UlIdPersonDesignee, TsLastUpdate)\r\n    {\r\n        document.frmStaffDesigneeMnt.hdnDtAssignExpiration.value = DtAssignExpiration;\r\n        document.frmStaffDesigneeMnt.hdnUlIdEmpTempAssign.value = UlIdEmpTempAssign;\r\n        document.frmStaffDesigneeMnt.hdnUlIdPersonDesignee.value = UlIdPersonDesignee;\r\n        document.frmStaffDesigneeMnt.hdnTsLastUpdate.value = TsLastUpdate;\r\n    }\r\n\r\n  //Confirm on Exit Message\r\n window.onbeforeunload = function ()\r\n {\r\n           IsDirty();\r\n };\r\n\r\n//Cancels Validation if the Designee totals more than five and throws a message\r\n  function cancelValidation ()\r\n  {\r\n");

    if( numRows > 4 )
    {

      out.write("\r\n      this.setInformationalMessage('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SEC_TOO_MANY_DESIGNEES));
      out.write("');\r\n      return false;\r\n");

    }
    else
    {

      out.write("\r\n      document.frmStaffDesigneeMnt.FormValidationCancel.value=\"true\";\r\n      return true;\r\n");

    }

      out.write("\r\n  }\r\n\r\n  //Message for when a user wants to delete a Designee and gives the user an alert, the if the\r\n  //radio button was not selected by the user.\r\n  function Delete()\r\n  {\r\n    var cont;\r\n    if( checkForSelection('document.frmStaffDesigneeMnt.rdnemployeeName'))\r\n    {\r\n         cont = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("');\r\n    }\r\n    else\r\n    {\r\n         alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) );
      out.write("');\r\n         cont = false;\r\n    }\r\n    return cont;\r\n  }\r\n\r\n//Message for when a user wants to delete a Designee and gives the user an alert, the if the\r\n  //radio button was not selected by the user.\r\n  function deleteTemp()\r\n  {\r\n     if ( confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("') )\r\n    {\r\n      document.frmStaffDesigneeMntTemp.FormValidationCancel.value='true';\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n\r\n  //Allows for the employeeName to be selected out of the radio button\r\n  function checkForSelection( objName )\r\n  {\r\n    var buttonChecked = false;\r\n    var obj = eval(objName);\r\n\r\n    if (obj != null)\r\n    {\r\n      if (obj.length == null)\r\n      {\r\n        if (obj.checked != false)\r\n          buttonChecked = true;\r\n      }\r\n      else\r\n      {\r\n        for (var i = 0; i < obj.length; ++i)\r\n        {\r\n          buttonChecked = buttonChecked || obj[i].checked;\r\n        }\r\n      }\r\n    }\r\n\r\n  return (buttonChecked);\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<input type=\"hidden\" name=\"");
      out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
      out.write("\">\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n    <td>\r\n");

      //  Null check the object in the request
      if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null)
      {
        //  Create an instance of the array to use on your page
        ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);
        Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
        while ( e.hasMoreElements() )
        {
          ROWCCMN50DO staff = (ROWCCMN50DO)e.nextElement();

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmStaffDesigneeMntTemp");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/MntainDesignee/displayStaffDesigneeMnt");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.MntainDesigneeCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n   <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n      <tr>\r\n        <th width=\"3%\">&nbsp;</th>\r\n        <th width=\"37%\">Employee Name</th>\r\n        <th width=\"60%\">Expiration</th>\r\n        ");
          out.write("\r\n      </tr>\r\n      <tr>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setName("rdnTempDesignee");
          _jspx_th_impact_validateInput_0.setChecked("true");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("StaffSzNmPersonFull");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString(staff.getSzNmPersonFull()) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnIdPersonDesignee");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(staff.getUlIdPerson()));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue("");
          _jspx_th_impact_validateDate_0.setName("tempDate");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("false");
          _jspx_th_impact_validateDate_0.setTitle("Pullback Expiration");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n      <tr>\r\n        <td>\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDeleteTemp");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteTemp()");
          _jspx_th_impact_ButtonTag_0.setForm("frmStaffDesigneeMntTemp");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/MntainDesignee/deleteTempDesigneeOf");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveTemp");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmStaffDesigneeMntTemp");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/MntainDesignee/saveTempDesigneeOf");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n       </tr>\r\n     </table>\r\n    <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n     ");

          } //end of for finding the number of designee
       }
     
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmStaffDesigneeMnt");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/admin/MntainDesignee/displayStaffDesigneeMnt");
      _jspx_th_impact_validateForm_1.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.MntainDesigneeCustomValidation");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    </td>\r\n  </tr>\r\n   ");
          out.write("\r\n   <tr>\r\n     <td colspan=\"4\">\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n         <tr>\r\n           <th width=\"3%\">&nbsp</th>\r\n           <th width=\"37%\">Employee Name</th>\r\n           <th width=\"60%\">Expiration</th>\r\n        </tr>\r\n");

           //Variables for the display page, uses CARC16SO
           int loopCount = 0;
           String UlIdEmpTempAssign = "";
           String UlIdPerson2 = "";
           String UlIdPersonDesignee = "";
           String SzNmPersonFull = "";
           String DtAssignExpiration = "";
           String TsLastUpdate = "";

           int messageCounter = rowcarc14sog00Array.getROWCARC14SOG00Count();

           //If the message counter is equal to zero, then return No Rows Returned Message
           if(messageCounter == 0)
           {

          out.write("\r\n       <tr class=\"odd\">\r\n         <td colspan=\"4\">\r\n         ");
          out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
          out.write("\r\n         </td>\r\n         </tr>\r\n");

           }
           //Enumerations over rowcarc14sog00Array to get the Designees
           Enumeration sog00enum = rowcarc14sog00Array.enumerateROWCARC14SOG00();
           while ( sog00enum.hasMoreElements() )
           {
             String DesigneeOfValue = Integer.toString(loopCount);
             ROWCARC14SOG00 sog00 = ( ROWCARC14SOG00 ) sog00enum.nextElement();

             UlIdEmpTempAssign = FormattingHelper.formatInt(sog00.getUlIdEmpTempAssign());
             UlIdPerson2 = FormattingHelper.formatInt(GlobalData.getUlIdPerson(request));
             UlIdPersonDesignee = FormattingHelper.formatInt(sog00.getUlIdPersonDesignee());
             SzNmPersonFull = sog00.getSzNmPersonFull();
             DtAssignExpiration = FormattingHelper.formatDate(sog00.getDtDtAssignExpiration());
             TsLastUpdate = DateHelper.toISOString(sog00.getTsLastUpdate());
        
          out.write("\r\n       <tr class = \"");
          out.print(FormattingHelper.getRowCss( loopCount + 1));
          out.write("\">\r\n         <td>\r\n         ");

           String textName = "txtExpiration" + loopCount;
           //When the user selects the radio button, the following fields get populated to the setHiddenFields JavaScript function
           String IncOnClick = "setHiddenFields( '" + DtAssignExpiration + "', '" + UlIdEmpTempAssign  + "', '" + UlIdPersonDesignee  + "', '" + TsLastUpdate + "');";
         
          out.write("\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setId("rdnemployeeName");
          _jspx_th_impact_validateInput_2.setOnClick(IncOnClick);
          _jspx_th_impact_validateInput_2.setName("rdnemployeeName");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setChecked("false");
          _jspx_th_impact_validateInput_2.setDisabled(pullBack);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         </td>\r\n         <td>\r\n           ");
          out.print( SzNmPersonFull );
          out.write("\r\n         </td>\r\n         <td>\r\n         ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue( DtAssignExpiration );
          _jspx_th_impact_validateDate_1.setTitle("Expiration");
          _jspx_th_impact_validateDate_1.setName( textName );
          _jspx_th_impact_validateDate_1.setCssClass("formInput");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("false");
          _jspx_th_impact_validateDate_1.setDisabled(pullBack);
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         </td>\r\n       </tr>\r\n       ");

          loopCount++;
         }
       //2 lines below -- Sets hidden fields
       
          out.write("\r\n       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnNbrExpDate");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatInt(loopCount));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n       <!--impact:validateInput type=\"hidden\" name=\"hdnUlIdPerson\" value=\"\"/-->\r\n       ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n       ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n       ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n       </table>\r\n     </td>\r\n   </tr>\r\n   <tr>\r\n     <td>\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n         <tr>\r\n            <td>\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("btnDelete");
          _jspx_th_impact_ButtonTag_2.setFunction("return Delete()");
          _jspx_th_impact_ButtonTag_2.setAction("/admin/MntainDesignee/deleteDesigneeOf");
          _jspx_th_impact_ButtonTag_2.setForm("frmStaffDesigneeMnt");
          _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_2.setAlign("left");
          _jspx_th_impact_ButtonTag_2.setDisabled(noDesignee);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_3.setName("btnAdd");
          _jspx_th_impact_ButtonTag_3.setAction("/admin/MntainDesignee/addDesigneeOf");
          _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setFunction("return cancelValidation()");
          _jspx_th_impact_ButtonTag_3.setForm("frmStaffDesigneeMnt");
          _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setDisabled(pullBack);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n         </tr>\r\n");

         //Hide the HR if the page returns from Staff Search or
         if(!hideHr)
         {

          out.write("\r\n        <tr>\r\n         <td colspan=\"4\">\r\n           <hr width=\"100%\">\r\n         </td>\r\n        </tr>\r\n");

        }
        //end of if for the hr = true

          out.write("\r\n         <tr>\r\n           <td colspan=\"2\">\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_4.setName("btnSave");
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmStaffDesigneeMnt");
          _jspx_th_impact_ButtonTag_4.setAction("/admin/MntainDesignee/saveMntainDesignee");
          _jspx_th_impact_ButtonTag_4.setDisabled(noDesignee);
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n         </tr>\r\n       </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    _jspx_th_impact_validateErrors_0.setFormName("frmStaffDesigneeMnt");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_4.setName("hdnUlIdEmpTempAssign");
    _jspx_th_impact_validateInput_4.setValue("");
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
    _jspx_th_impact_validateInput_5.setName("hdnUlIdPersonDesignee");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnDtAssignExpiration");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("hdnTsLastUpdate");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
