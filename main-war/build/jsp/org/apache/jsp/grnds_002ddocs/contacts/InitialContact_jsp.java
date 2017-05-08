package org.apache.jsp.grnds_002ddocs.contacts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class InitialContact_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 * JSP Name:     Initial Contact
 * Created by:   Todd Reser (Split out by Matt McClaim)
 * Date Created: 10/06/03
 *
 * Description:
 * This page displays the Initial Contact page for adding a new contact.
 *
 * Change History:
 * Date      User              Description
 * --------  ----------------  -----------------------------------------------
 * 10/06/03  Matt McClaim      Reformatted new version split into 4 files.
 * 10/27/03  Todd Reser        SIR 11336 - 24H amd FTF were erroneously showing
 *                             twice.  Added AOC to an If statement to supress
 *                             extra versions with wrong templates.
 * 11/03/03  Todd Reser        Updated Comments.  When the JSP's were split into
 *                             4 pieces a Comment was erroneously put in
 *                             InitialContact when it should have been in
 *                             DetailContactSub.
 * 01/03/05  Eric Dickman      I have excluded the Contact Type of Capacity
 *                             Screening Questions.  The search drop down menu
 *                             will allow users to still search for Contact Types of
 *                             Capacity Screening Questions that where in the db
 *                             previous to the 02/27/2005 roll-out.
 * 02/03/05  Hari Maralla      SIR 23272 - excluded ALIC (Licensing Investigation Report)
 *                             Contracts Type (DropDown) for CPS Program and INV Stage.
 * 07/24/05  Mike Werle        SIR 23728 Added fix for Adding 24Hour contact
 *                             in INV stage for APS on MPS.
 * 09/14/05  Mike Werle        SIR 23968 Adding AFC contact types to MPS.
 * 09/20/05  mkw               Phase III -- Enhancements for Facility and APS:
 *                             SIRs 23968, 23949, and 23950.
 * 03/22/07  abgoode           Removed CCNTCTYP manipulation in Javascript, logic centralized
 *                             in ContactSearchListDetailConversation
 */

      out.write("\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n\r\n");

  //noinspection UnnecessaryCodeBlock
  {
    int tabIndex = 1;
    String pageMode = PageMode.getPageMode( request );
    //String szCdStage = GlobalData.getSzCdStage( request );
    // SIR 23272 - Get Program Type from Global Data
    //String SzCdStageProgram = GlobalData.getSzCdStageProgram( request );

    BaseSessionStateManager state =
            (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

    CSYS08SO csys08so = (CSYS08SO)state.getAttribute( "CSYS08SO", request );
    if( csys08so == null )
    {
      csys08so = new CSYS08SO();
    }

    String typeKey = ContactSearchListDetailConversation.getTypeKey( request );
    String selSzCdContactType = ContactSearchListDetailConversation.getSelSzCdContactType( request );

    // Create an array list of exclusions for the Type Select box
    //Set<String> excludeType = new HashSet<String>();

    // For MPS, always exclude everything except three codes; re-excluding below is not a problem.
    //noinspection ConstantConditions
    //-- **********************************************************************************************
    //-- !!! IF THIS LOGIC IS STILL NEEDED, IT SHOULD LIVE IN ContactSearchListDetailConversation.getTypeOptions !!!
    //if( PlatformConstants.MOBILE_IMPACT )
    //{
      //Collection categoryCodesCollection = Lookup.getCategoryCodesCollection( CodesTables.CCNTCTYP );
      //for( Iterator ccIt = categoryCodesCollection.iterator(); ccIt.hasNext(); )
      //{
      //  String code = (String)ccIt.next();
      //  if( !ContactSearchListDetailConversation.MOBILE_CONTACT_TYEPS.contains( code ) )
      //  {
          //excludeType.add( code );
      //  }
      //}
    //}
    //-- **********************************************************************************************

    // We have to hide A, B, C, D & E "Notifications" since they are only allowed
    // to be added by the System
    //excludeType.addAll( ContactSearchListDetailConversation.NOTIFICATION_CONTACT_TYPES );

    // We have to hide all the non-summary CPS FAD Contact Types except IREG
    //excludeType.addAll( ContactSearchListDetailConversation.NON_SUMMARY_CPS_FAD_CONTACT_TYPES );

    //SIR 23294 - exclude Capacity Screening Questions Contact Type from Initial
    //Contact Type page.
    //excludeType.add( CodesTables.CCNTCTYP_CCSQ );  //Capacity Screening Questions

    // SIR 18272 If the Superintendent checkbox on the Facility Investigation
    // Conclusion has not been checked we need to remove "Request for Review"
    // (EREV) from the list.
    //if( !ArchitectureConstants.Y.equals( csys08so.getCIndFacilSuperintNotif() ) )
    //{
      //excludeType.add( CodesTables.CCNTCTYP_EREV );  // Request for Review
    //}

    // SIR 18956 introduced a bug of displaying the Contact Purposes "24 Hour
    // Contact" and "Initial Face To Face" twice. The next two if statements
    // supress the extra listings from the select box.
    // SIR 22336 - Added AOC to if statement
    // Hide C24H & CFTF if it's a SVC or AOC Case
    //if( CodesTables.CSTAGES_SVC.equals( szCdStage ) ||
    //    CodesTables.CSTAGES_AOC.equals( szCdStage ) )
    //{
      //excludeType.add( CodesTables.CCNTCTYP_C24H ); // Hide C24H
      //excludeType.add( CodesTables.CCNTCTYP_CFTF ); // Hide CFTF
    //}
    // Hide C24N & CIFF if it's an INV stage
    //if( CodesTables.CSTAGES_INV.equals( szCdStage ) )
    //{
      //excludeType.add( CodesTables.CCNTCTYP_C24N ); // Hide C24N
      //excludeType.add( CodesTables.CCNTCTYP_CIFF ); // Hide CIFF
    //}

    // SIR 23272 - excluded ALIC from Contracts Type Dropdown, from CPS program and INV stages
    //if( CodesTables.CSTAGES_INV.equals( szCdStage ) &&
    //    CodesTables.CPGRMS_CPS.equals( SzCdStageProgram ) )
    //{
      //excludeType.add( CodesTables.CCNTCTYP_ALIC ); // Hide ALIC
    //}

    // SIR 18639 - If the pageMode is VIEW then the widgent Name has an _DISABLED
    // appended to it.
    String selSzCdContactTypeString = "selSzCdContactType";
    if( pageMode.equals( PageModeConstants.VIEW ) )
    {
      selSzCdContactTypeString = "selSzCdContactType_Disabled";
    }

      out.write("\r\n\r\n");
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  function submitOnEnter()\r\n  {\r\n    // In the onload event, we attach this function to the onkeydown handler\r\n    // for the Form.  When a key is pressed anywhere in the form, it now calls\r\n    // this function before getting sent to the main event handler.\r\n    var we = window.event\r\n    if( we.keyCode == '13' &&\r\n        !( we.shiftKey ||\r\n           we.shiftRight ||\r\n           we.ctrlKey ||\r\n           we.ctrlRight ||\r\n           we.altKey ||\r\n           we.altRight) )\r\n    {\r\n      we.returnValue = false;\r\n      submitValidateForm(\"frmInitialContact\", \"/contacts/ContactSearchListDetail/continueType\");\r\n    }\r\n  }\r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmInitialContact");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/contacts/ContactSearchListDetail/displayContact");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.contacts.InitialContactCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table border=\"0\"\r\n         cellspacing=\"0\"\r\n         cellpadding=\"3\"\r\n         class=\"tableBorder\"\r\n         width=\"100%\">\r\n    <tr>\r\n    <th colspan=\"3\">Contact/Summary Type</th>\r\n    <tr>\r\n      <td width=\"15%\" class=\"formlabel\">\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setName("selSzCdContactType");
          _jspx_th_impact_validateSelect_0.setDisabled("false");
          _jspx_th_impact_validateSelect_0.setWidth("35%");
          _jspx_th_impact_validateSelect_0.setOptions( ContactSearchListDetailConversation.getTypeOptions(request) );
          _jspx_th_impact_validateSelect_0.setValue( selSzCdContactType );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnContinue");
          _jspx_th_impact_ButtonTag_0.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_0.setForm("frmInitialContact");
          _jspx_th_impact_ButtonTag_0.setAction("/contacts/ContactSearchListDetail/continueType");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n\r\n  document.frmInitialContact.attachEvent(\"onkeydown\", submitOnEnter);\r\n  //populateType();\r\n  //CleanSelect(frmInitialContact.");
      out.print( selSzCdContactTypeString );
      out.write(");\r\n\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request)) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  // SIR 18788 - If New Using and the Contact type is *REG make sure we have the\r\n  // right first letter because the descriptions can be different.\r\n  //If it = *REG set it to the correct value incase the first char was wrong\r\n  if( frmInitialContact.");
          out.print( selSzCdContactTypeString );
          out.write(".value.substring(1, 4) == \"REG\" )\r\n  {\r\n    frmInitialContact.");
          out.print( selSzCdContactTypeString );
          out.write(".value = \"");
          out.print( typeKey );
          out.write("REG\";\r\n  }\r\n          ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n</script>\r\n\r\n");

  }

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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
