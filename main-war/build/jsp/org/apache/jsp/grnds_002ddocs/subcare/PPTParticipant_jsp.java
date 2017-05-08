package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB27SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public final class PPTParticipant_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*-----------------------------------------------------------------------------
//*  JSP Name:     PPT Participant Detail
//*  Created by:   Jason Rios
//*  Date Created: 03/13/03
//*
//*  Description:
//*  This JSP displays the PPT Participant Details.
//*
/*
Change History:
  Date        User              Description
  ----------  ----------------  ---------------------------------------------
  06/05/2003  Todd Reser        Modified onlineNotificationCheck() to have an
                                else that clears the Date and disables Send
                                Alert box.  Also added call to this function
                                when the page loads.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
ROWCSUB27SOG00 participant = null;
int selectedParticipantId = 0;
String hdnParticipantId = "";
String hdnParticipantDateLastUpdate = "";
String hdnPersonId = "";
String selParticipantType = "";
String txtParticipantName = "";
String txtRelationshipInterest = "";
String selNotificationType = "";
String txtNotifiedDate = "";
String txtParticipationDate = "";
String cbxSendAlert = "";
String txtTitle = "";
String txtAgency = "";
String txtMeetingType = "";
String txtMeetingDate = "";
String txtMeetingTime = "";
String cbxAccptdChnges = FormattingHelper.formatString("");
String signedWvrAh = FormattingHelper.formatString("");
String reqAh = FormattingHelper.formatString("");
Boolean agencyDisabled = false;
Boolean titleDisabled = false;
Iterator iter = null;


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
UserProfile user = UserProfileHelper.getUserProfile( request );

participant = ( ROWCSUB27SOG00 )state.getAttribute( "participant", request );

CSUB29SO csub29so = (CSUB29SO)state.getAttribute("CSUB29SO", request);

if ( participant != null )
{
  if ( participant.getSzCdPptPartType() != null )
  {
    selParticipantType = FormattingHelper.formatString( participant.getSzCdPptPartType() );
  }
  if ( participant.getSzNmPptPartFull() != null )
  {
    txtParticipantName = FormattingHelper.formatString( participant.getSzNmPptPartFull() );
  }
  if ( participant.getSzSdsPptPartRelationship() != null )
  {
    txtRelationshipInterest = FormattingHelper.formatString( participant.getSzSdsPptPartRelationship() );
  }
  if ( participant.getSzCdPptNotifType() != null )
  {
    selNotificationType = FormattingHelper.formatString( participant.getSzCdPptNotifType() );
  }
  if ( participant.getDtDtPptPartDateNotif() != null )
  {
    txtNotifiedDate = FormattingHelper.formatDate( participant.getDtDtPptPartDateNotif() );
  }
  if ( participant.getDtDtPptDate() != null )
  {
    txtParticipationDate = FormattingHelper.formatDate( participant.getDtDtPptDate() );
  }
  if ( participant.getUlIdPptPart() > 0 )
  {
    hdnParticipantId = FormattingHelper.formatInt( participant.getUlIdPptPart() );
  }
  if ( participant.getTsLastUpdate() != null )
  {
    hdnParticipantDateLastUpdate = DateHelper.toISOString( participant.getTsLastUpdate() );
  }
  if ( participant.getUlIdPerson() > 0 )
  {
    hdnPersonId = FormattingHelper.formatInt( participant.getUlIdPerson() );
  }
  if (participant.getIndAccptdChnges()!=null)
  {
    cbxAccptdChnges = FormattingHelper.formatString(participant.getIndAccptdChnges());
  }
  if (participant.getIndReqAh()!=null)
  {
    reqAh = FormattingHelper.formatString(participant.getIndReqAh());
  }
  if (participant.getIndSignedWvrAh()!=null)
  {
    signedWvrAh = FormattingHelper.formatString(participant.getIndSignedWvrAh());
  }
  if (participant.getTxtAgency()!=null)
  {
    txtAgency = FormattingHelper.formatString(participant.getTxtAgency());
  }
  if (participant.getTxtTitle()!=null)
  {
    txtTitle = FormattingHelper.formatString(participant.getTxtTitle());
  }
} // end if ( participant != null )

if (csub29so != null)
{
  if (csub29so.getCSUB29SOG00()!= null)
  {
    txtMeetingType = csub29so.getCSUB29SOG00().getSzMeetingType();
  }
  if (csub29so.getCSUB29SOG00().getDtDtPptDate() != null)
    {
      txtMeetingDate = FormattingHelper.formatDate(csub29so.getCSUB29SOG00().getDtDtPptDate());
    }

    if (csub29so.getCSUB29SOG00().getTmScrTmPptTime() != null)
    {
      txtMeetingTime = csub29so.getCSUB29SOG00().getTmScrTmPptTime();
    }
}

//*********************
//*** SET PAGE MODE ***
//*********************
String pageMode = PageMode.getPageMode( request );

      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction confirmDelete()\r\n{\r\n  return confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\" );\r\n}\r\n\r\n// Reloads the Family Plan Item Detail page when the user changes\r\n// the Participant Type.\r\nfunction reloadPPTParticipant()\r\n{\r\n  disableValidation('frmPPTParticipant');\r\n  setState('frmPPTParticipant');\r\n  setValidationUrl('frmPPTParticipant','/subcare/PPT/reloadPPTParticipant');\r\n  document.frmPPTParticipant.submit();\r\n}\r\n\r\n// This function will confirm that the user has entered and saved the\r\n// participant details needed to generate the PPT Letter.\r\nfunction checkPageData()\r\n{\r\n  ");

  if ( "".equals(hdnParticipantId) )
  {
      out.write("\r\n    alert(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_ARC_NO_FORM_DATA ) );
      out.write("\");\r\n    return false;\r\n  ");

  }
  else
  {
  
      out.write("\r\n    if ( isFormChanged( document.frmPPTParticipant ) )\r\n    {\r\n      alert(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) );
      out.write("\");\r\n      return false;\r\n    }\r\n  ");

  }
  
      out.write("\r\n}\r\n\r\n// When the user selects \"Online\" as the Notification Type for a PRS Staff\r\n// participant, this function will automatically check the 'Send Alert'\r\n// checkbox, enable the field and prefill the 'Notified Date' field with\r\n// today's date (assuming the field is empty).  If the Notification Type\r\n// is not \"Online\", this function will clear and disable 'Send Alert'.\r\nfunction onlineNotificationCheck()\r\n{\r\n  if ( document.frmPPTParticipant.selNotificationType.value == \"");
      out.print( CodesTables.CPPTNOST_ONL );
      out.write("\" )\r\n  {\r\n   document.frmPPTParticipant.cbxSendAlert.disabled = false;\r\n   document.frmPPTParticipant.cbxSendAlert.checked = true;\r\n    if ( document.frmPPTParticipant.txtNotifiedDate.value == \"\" )\r\n    {\r\n      var todaysDate = new Date();\r\n      var todaysDateAsString = (todaysDate.getMonth()+1) + \"/\" + todaysDate.getDate() + \"/\" + todaysDate.getYear();\r\n      document.frmPPTParticipant.txtNotifiedDate.value = todaysDateAsString;\r\n    }\r\n  }\r\n  else\r\n  {\r\n    document.frmPPTParticipant.cbxSendAlert.checked = false;\r\n    document.frmPPTParticipant.cbxSendAlert.defaultChecked = false;\r\n    document.frmPPTParticipant.cbxSendAlert.disabled = true;\r\n    document.frmPPTParticipant.txtNotifiedDate.value = \"\";\r\n  }\r\n}\r\n</script>\r\n\r\n");

//*************************
//*** VALIDATION ERRORS ***
//*************************

      out.write('\r');
      out.write('\n');
/* Include custom tag for displaying errors on the page */
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

//********************************************
//**** FORM (PPT INFORMATION) STARTS HERE ****
//********************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPPTParticipant");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/subcare/PPT/displayPPTParticipant");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");

// The user must begin by selecting a Participant Type.
if ("".equals(selParticipantType) )
{
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr><th colspan=\"2\">Team Meetings/Reviews Participant Detail</th></tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Participant Type");
          _jspx_th_impact_validateSelect_0.setName("selParticipantType");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CPARTYPE );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue( CodesTables.CPARTYPE_PIC );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td width=\"50%\">&nbsp;</td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnContinue");
          _jspx_th_impact_ButtonTag_0.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmPPTParticipant");
          _jspx_th_impact_ButtonTag_0.setAction("/subcare/PPT/reloadPPTParticipant");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

}
else
{
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnParticipantId");
          _jspx_th_impact_validateInput_0.setValue( hdnParticipantId );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnParticipantDateLastUpdate");
          _jspx_th_impact_validateInput_1.setValue( hdnParticipantDateLastUpdate );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnPersonId");
          _jspx_th_impact_validateInput_2.setValue( hdnPersonId );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n           <th colspan=\"4\">Team Meetings/Reviews Participant Detail</th>\r\n          </tr>\r\n          <tr>\r\n            ");

            //------------------------
            //--- Participant Type ---
            //------------------------
            // Once the participant record has been saved to the database,
            // the Participant Type cannot be changed.
            if ("".equals(hdnParticipantId) )
            {
          out.write("\r\n              <td width=\"20%\">\r\n                ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Participant Type");
          _jspx_th_impact_validateSelect_1.setName("selParticipantType");
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CPARTYPE );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( selParticipantType );
          _jspx_th_impact_validateSelect_1.setOnChange("reloadPPTParticipant()");
          _jspx_th_impact_validateSelect_1.setColspan("3");
          _jspx_th_impact_validateSelect_1.setDisabled("true");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td width=\"20%\">\r\n                ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Participant Type");
          _jspx_th_impact_validateSelect_2.setName("selParticipantType");
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CPARTYPE );
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setValue( selParticipantType );
          _jspx_th_impact_validateSelect_2.setDisabled("true");
          _jspx_th_impact_validateSelect_2.setColspan("3");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            
          out.write("\r\n          </tr>\r\n          <tr>\r\n            ");

            //------------------------
            //--- Participant Name ---
            //------------------------
            // If the Participant Type is "Person in Case" or "Staff", the
            // Participant Name field can only be modified by performing a
            // Person Search or Staff Search, accordingly.
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) ||
                 selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {
          out.write("\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Name");
          _jspx_th_impact_validateInput_3.setName("txtParticipantName");
          _jspx_th_impact_validateInput_3.setValue( txtParticipantName );
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setReadOnly("true");
          _jspx_th_impact_validateInput_3.setWidth("25%");
          _jspx_th_impact_validateInput_3.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Name");
          _jspx_th_impact_validateInput_4.setName("txtParticipantName");
          _jspx_th_impact_validateInput_4.setValue( txtParticipantName );
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setMaxLength("25");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            
          out.write("\r\n\r\n            ");

            //---------------------------
            //--- Person/Staff Button ---
            //---------------------------
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) )
            {
          out.write("\r\n              <td colspan=\"2\">\r\n                ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnPerson");
          _jspx_th_impact_ButtonTag_1.setImg("btnSelectPerson");
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setForm("frmPPTParticipant");
          _jspx_th_impact_ButtonTag_1.setAction("/subcare/PPT/performPersonListPullback");
          _jspx_th_impact_ButtonTag_1.setFunction("disableValidation('frmPPTParticipant')");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else if ( selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {
              txtAgency = "DFCS";
          out.write("\r\n              <td colspan=\"2\">\r\n                ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnStaff");
          _jspx_th_impact_ButtonTag_2.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_2.setAlign("left");
          _jspx_th_impact_ButtonTag_2.setForm("frmPPTParticipant");
          _jspx_th_impact_ButtonTag_2.setAction("/subcare/PPT/performStaffSearch");
          _jspx_th_impact_ButtonTag_2.setFunction("disableValidation('frmPPTParticipant')");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td colspan=\"2\">&nbsp;</td>\r\n            ");

            }
            
          out.write("\r\n          </tr>\r\n          <tr>\r\n            ");

            //-----------------------------
            //--- Relationship/Interest ---
            //-----------------------------
            // If the Participant Type is "Person in Case" or "Staff", the
            // Relationship/Interest field can only be modified by performing
            // a Person Search or Staff Search, accordingly.
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) ||
                 selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {
          out.write("\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Relationship/Interest");
          _jspx_th_impact_validateInput_5.setName("txtRelationshipInterest");
          _jspx_th_impact_validateInput_5.setMaxLength("20");
          _jspx_th_impact_validateInput_5.setValue( txtRelationshipInterest );
          _jspx_th_impact_validateInput_5.setRequired("true");
          _jspx_th_impact_validateInput_5.setReadOnly("true");
          _jspx_th_impact_validateInput_5.setCssClass("readonly");
          _jspx_th_impact_validateInput_5.setColspan("3");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            </tr>\r\n            <tr>\r\n              <td>\r\n                   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Title");
          _jspx_th_impact_validateInput_6.setName("txtTitle");
          _jspx_th_impact_validateInput_6.setMaxLength("20");
          _jspx_th_impact_validateInput_6.setValue( txtTitle );
          _jspx_th_impact_validateInput_6.setRequired("false");
          _jspx_th_impact_validateInput_6.setReadOnly("true");
          _jspx_th_impact_validateInput_6.setCssClass("readonly");
          _jspx_th_impact_validateInput_6.setColspan("3");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            </tr>\r\n            <tr>\r\n              <td>\r\n                 ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Agency");
          _jspx_th_impact_validateInput_7.setName("txtAgency");
          _jspx_th_impact_validateInput_7.setMaxLength("20");
          _jspx_th_impact_validateInput_7.setValue( txtAgency );
          _jspx_th_impact_validateInput_7.setRequired("false");
          _jspx_th_impact_validateInput_7.setReadOnly("true");
          _jspx_th_impact_validateInput_7.setCssClass("readonly");
          _jspx_th_impact_validateInput_7.setColspan("3");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setLabel("Relationship/Interest");
          _jspx_th_impact_validateInput_8.setName("txtRelationshipInterest");
          _jspx_th_impact_validateInput_8.setMaxLength("20");
          _jspx_th_impact_validateInput_8.setValue( txtRelationshipInterest );
          _jspx_th_impact_validateInput_8.setRequired("true");
          _jspx_th_impact_validateInput_8.setColspan("3");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            </tr>\r\n            <tr>\r\n              <td>\r\n                   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("Title");
          _jspx_th_impact_validateInput_9.setName("txtTitle");
          _jspx_th_impact_validateInput_9.setMaxLength("20");
          _jspx_th_impact_validateInput_9.setValue( txtTitle );
          _jspx_th_impact_validateInput_9.setRequired("false");
          _jspx_th_impact_validateInput_9.setColspan("3");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            </tr>\r\n            <tr>\r\n              <td>\r\n                 ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setLabel("Agency");
          _jspx_th_impact_validateInput_10.setName("txtAgency");
          _jspx_th_impact_validateInput_10.setMaxLength("20");
          _jspx_th_impact_validateInput_10.setValue( txtAgency );
          _jspx_th_impact_validateInput_10.setRequired("false");
          _jspx_th_impact_validateInput_10.setColspan("3");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            
          out.write("\r\n          </tr>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("txtMeetingDate");
          _jspx_th_impact_validateInput_11.setValue( txtMeetingDate );
          _jspx_th_impact_validateInput_11.setConstraint("Date");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("txtMeetingTime");
          _jspx_th_impact_validateInput_12.setValue( txtMeetingTime );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          <tr>\r\n            ");

            //-------------------------
            //--- Notification Type ---
            //-------------------------
            
          out.write("\r\n           <td>\r\n                ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Notification Type");
          _jspx_th_impact_validateSelect_3.setName("selNotificationType");
          _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CPPTNOST );
          _jspx_th_impact_validateSelect_3.setValue( selNotificationType );
          _jspx_th_impact_validateSelect_3.setOnChange("onlineNotificationCheck()");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            //---------------------
            //--- Notified Date ---
            //---------------------
            
          out.write("\r\n            <td  width=\"15%\">\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Notified Date");
          _jspx_th_impact_validateDate_0.setName("txtNotifiedDate");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue( txtNotifiedDate );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            ");

            //--------------------------
            //--- Participation Date ---
            //--------------------------
            
          out.write("\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Participation Date");
          _jspx_th_impact_validateDate_1.setName("txtParticipationDate");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue( txtParticipationDate );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          ");
if (txtMeetingType.equals("ADM")) { 
          out.write("\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setLabel("Accepted Changes to Case Plan");
          _jspx_th_impact_validateInput_13.setName("cbxAccptdChnges");
          _jspx_th_impact_validateInput_13.setRequired("false");
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_13.setChecked(FormattingHelper.formatString(cbxAccptdChnges));
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td colspan=\"2\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setLabel("Signed Waiver of Administrative Hearing");
          _jspx_th_impact_validateInput_14.setName("signedWvrAh");
          _jspx_th_impact_validateInput_14.setRequired("false");
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_14.setChecked(FormattingHelper.formatString(signedWvrAh));
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td colspan=\"2\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setLabel("Requested Administrative Hearing");
          _jspx_th_impact_validateInput_15.setName("reqAh");
          _jspx_th_impact_validateInput_15.setRequired("false");
          _jspx_th_impact_validateInput_15.setType("checkbox");
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_15.setChecked(FormattingHelper.formatString(reqAh));
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          ");
}//end section if meeting type is ADM
          out.write("\r\n        </table>\r\n\r\n  ");

  //*****************
  //**** BUTTONS ****
  //*****************
  
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      ");

      if ( !"".equals(hdnParticipantId) )
      {
          out.write("\r\n        <td>\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName( PPTConversation.DELETE_BUTTON_ON_PARTICIPANT_PAGE );
          _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_3.setAlign("left");
          _jspx_th_impact_ButtonTag_3.setForm("frmPPTParticipant");
          _jspx_th_impact_ButtonTag_3.setAction("/subcare/PPT/deletePPTParticipant");
          _jspx_th_impact_ButtonTag_3.setFunction("return confirmDelete()");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      ");

      }
      
          out.write("\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName( PPTConversation.SAVE_BUTTON_ON_PARTICIPANT_PAGE );
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmPPTParticipant");
          _jspx_th_impact_ButtonTag_4.setAction("/subcare/PPT/savePPTParticipant");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

}

          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
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

//******************************************
//**** FORM (PPT PARTICIPANT) ENDS HERE ****
//******************************************

      out.write("\r\n\r\n");

//***************
//**** FORMS ****
//***************

      out.write('\r');
      out.write('\n');
/*
// Forms should only be available if the participant record has been
// saved to the database.
if ( !"".equals(selParticipantType) )
{
      out.write("\r\n  <br>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr><th>Forms</th></tr>\r\n      <tr>\r\n      <td>\r\n        ");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode( pageMode );
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n          ");

          //----------------------------
          //--- PPT Letter (English) ---
          //----------------------------
          
          out.write("\r\n          ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("PPT Letter (English)");
          _jspx_th_impact_document_0.setDocType("csc06o00");
          _jspx_th_impact_document_0.setDocExists(false);
          _jspx_th_impact_document_0.setProtectDocument(false);
          _jspx_th_impact_document_0.setOnClick("checkPageData()");
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pPptPart");
              _jspx_th_impact_documentParameter_0.setValue( hdnParticipantId );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pPerson");
              _jspx_th_impact_documentParameter_1.setValue( hdnPersonId );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pPptEvent");
              _jspx_th_impact_documentParameter_2.setValue( String.valueOf( GlobalData.getUlIdEvent( request ) ) );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pStage");
              _jspx_th_impact_documentParameter_3.setValue( String.valueOf( GlobalData.getUlIdStage( request ) ) );
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");

          //----------------------------
          //--- PPT Letter (Spanish) ---
          //----------------------------
          
          out.write("\r\n          ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_1.setDisplayName("PPT Letter (Spanish)");
          _jspx_th_impact_document_1.setDocType("csc36o00");
          _jspx_th_impact_document_1.setDocExists(false);
          _jspx_th_impact_document_1.setProtectDocument(false);
          _jspx_th_impact_document_1.setOnClick("checkPageData()");
          int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
          if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_4.setName("pPptPart");
              _jspx_th_impact_documentParameter_4.setValue( hdnParticipantId );
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_5.setName("pPerson");
              _jspx_th_impact_documentParameter_5.setValue( hdnPersonId );
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_6 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_6.setName("pPptEvent");
              _jspx_th_impact_documentParameter_6.setValue( String.valueOf( GlobalData.getUlIdEvent( request ) ) );
              int _jspx_eval_impact_documentParameter_6 = _jspx_th_impact_documentParameter_6.doStartTag();
              if (_jspx_th_impact_documentParameter_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_7 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_7.setName("pStage");
              _jspx_th_impact_documentParameter_7.setValue( String.valueOf( GlobalData.getUlIdStage( request ) ) );
              int _jspx_eval_impact_documentParameter_7 = _jspx_th_impact_documentParameter_7.doStartTag();
              if (_jspx_th_impact_documentParameter_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n");

} */

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nif (document.frmPPTParticipant.cbxSendAlert != null)\r\n{\r\n  document.frmPPTParticipant.cbxSendAlert.disabled = true;\r\n}\r\n</script>\r\n\r\n");
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
