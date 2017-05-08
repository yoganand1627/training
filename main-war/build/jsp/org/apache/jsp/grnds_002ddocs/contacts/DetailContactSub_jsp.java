package org.apache.jsp.grnds_002ddocs.contacts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO;
import gov.georgia.dhr.dfcs.sacwis.web.contacts.PortalContactDetailConversation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class DetailContactSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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
   * JSP Name:     Detail Contact Sub
   * Created by:   Todd Reser (Split out by Matt McClaim)
   * Date Created: 10/06/03
   *
   * Description:
   * This page displays the Detail only portions version of the Contact page, and
   * is included in the Contact Detail page ony when needed.
   *
   **/
/* Change History:
  Date      User              Description
  --------  ----------------  -------------------------------------------------
  05/26/11  schoi             SMS #109398: MR-086 Added a new field 'Discussed/In Reference To'     
              
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    //SIR 23835 Instantiated new excludeOptions List
    //List<String> excludeOptions = new ArrayList<String>();
    //end SIR 23835

    int perps = 0;
    int vics = 0;

    // SIR 23410. Added logic to disable Purpose,Method,Location and Others Contracted Field
    // for contract type CLES and CLEV
    // SIR 23298 use this logic as well to disable Purpose, Method, Location and Others Contacted Field
    // for contact type CAGR
    boolean purposeDisabled = false;
    boolean methodDisabled = false;
    boolean locationDisabled = false;
    boolean otherDisabled = false;
    
    String modifyDisabled = "false";

    int _tabIndex = (Integer) request.getAttribute("tabIndex");
    String _pageMode = PageMode.getPageMode( request );

    //String _szCdStage = GlobalData.getSzCdStage( request );
    //String _szCdStageProgram = GlobalData.getSzCdStageProgram( request );

    BaseSessionStateManager _state = (BaseSessionStateManager)
            request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

    CSYS08SO _csys08so = (CSYS08SO)_state.getAttribute( "CSYS08SO", request );
    if( _csys08so == null )
    {
      _csys08so = new CSYS08SO();
    }

  if (PageModeConstants.MODIFY.equals( _pageMode )){
      purposeDisabled = true;
        methodDisabled = true;
        locationDisabled = true;
        otherDisabled = true;
     modifyDisabled = "true";
   }
   
   //STGAP00014326 MR-024 Allow contact to be modified for 7 days from date entered.
   String editAllow = (String) request.getAttribute("EDITALLOWEDSUB");
   String isContactBefStageClosure = (String) request.getAttribute("ISDATEBEFORESTAGECLOSESUB");
   String subSauSealedHomeAndWorker = (String) request.getAttribute("SAUSEALEDHOMEANDWORKERSUB");
   String subeditallowedforsevendays = (String) request.getAttribute("EDITALLOWEDFORSEVENDAYSSUB");
   
   if(("true".equals(editAllow) && "false".equals(isContactBefStageClosure))  || 
             ("true".equals(subSauSealedHomeAndWorker) && "true".equals(subeditallowedforsevendays) && "false".equals(isContactBefStageClosure))){
     purposeDisabled = false;
     methodDisabled = false;
     locationDisabled = false;
     otherDisabled = false;
     modifyDisabled = "false";  
     } 

    String _selSzCdContactMethod = FormattingHelper.formatString( _csys08so.getSzCdContactMethod() );

    String _selSzCdContactType = PortalContactDetailConversation.getSelSzCdContactType( request );


    String _selSzCdContactLocation = _csys08so.getSzCdContactLocation();
    String _selSzCdContactOthers = _csys08so.getSzCdContactOthers();
    String _selSzCdContactPurpose = FormattingHelper.formatString( _csys08so.getSzCdContactPurpose() );
    boolean _chkCrossCountyLines = false;
    if("on".equals(ContextHelper.getStringSafe(request, "chkCrossCountyLines")) ||
       (ArchitectureConstants.Y.equals(_csys08so.getBIndCrossCountyLines())) ) {
      _chkCrossCountyLines = true;
    }

    if( FormValidation.pageHasValidationMessages( "frmContactDetail", request ) )
    {
       _selSzCdContactPurpose = request.getParameter( "cbxContactPurpose" );
      _selSzCdContactLocation = request.getParameter( "selSzCdContactLocation" );
      _selSzCdContactOthers = request.getParameter( "selSzCdContactOthers" );
    }

       if( PlatformConstants.MOBILE_IMPACT &&
        PageModeConstants.VIEW.equals( _pageMode ) &&
        !Lookup.getCategoryCodesCollection( CodesTables.CCNTPURP ).contains( _selSzCdContactPurpose ) )
    {
      _selSzCdContactPurpose = "";
    }
    
      _state.setAttribute("savedPrivConversationArray", _csys08so.getROWPRIVCONVERSO_ARRAY(), request);
      
      // SMS #109398: MR-086
      _state.setAttribute("savedDiscussedArray", _csys08so.getROWDISCUSSEDSO_ARRAY(), request);

      out.write("\r\n\r\n");
      out.write("\r\n\r\n<script type=\"text/Javascript\" language=\"JavaScript1.2\">\r\nvar vics = 0;\r\nvar perps = 0;\r\n\r\nfunction checkPersRole( szCdPersRole, szCdStagePersRelInt, checked )\r\n{\r\n  //Check to see if the role is Alleged or Designated Perpertrator\r\n  if( (szCdPersRole == \"");
      out.print( CodesTables.CROLEALL_AP );
      out.write("\") ||\r\n      (szCdPersRole == \"");
      out.print( CodesTables.CROLEALL_DP );
      out.write("\") )\r\n  {\r\n    if( checked )\r\n    {\r\n      perps++;\r\n    }\r\n    else\r\n    {\r\n      perps--;\r\n    }\r\n    if( perps > 0 )\r\n    {\r\n      document.frmContactDetail.hdnBPerpSelected.value = \"Y\";\r\n    }\r\n    else\r\n    {\r\n      document.frmContactDetail.hdnBPerpSelected.value = \"N\";\r\n    }\r\n  }\r\n  //SIR 18433 - A \"No Role\" and \"Self\" counts as a victim\r\n  //Check to see if the role is Alleged or Designated Victim\r\n  if( (szCdPersRole == \"");
      out.print( CodesTables.CROLEALL_VC );
      out.write("\") ||\r\n      (szCdPersRole == \"");
      out.print( CodesTables.CROLEALL_DV );
      out.write("\") ||\r\n\r\n      ((szCdStagePersRelInt == \"");
      out.print( CodesTables.CRPTRINT_SL );
      out.write("\") &&\r\n       ((szCdPersRole == \"");
      out.print( CodesTables.CROLEALL_NO );
      out.write("\") ||\r\n        (szCdPersRole == \"");
      out.print( CodesTables.CROLEALL_UK );
      out.write("\"))) )\r\n  {\r\n    if( checked )\r\n    {\r\n      vics++;\r\n    }\r\n    else\r\n    {\r\n      vics--;\r\n    }\r\n  }\r\n  if( vics > 0 )\r\n  {\r\n    document.frmContactDetail.hdnBVictimSelected.value = \"Y\";\r\n  }\r\n  else\r\n  {\r\n    document.frmContactDetail.hdnBVictimSelected.value = \"N\";\r\n  }\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateInput_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_1(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n<tr>\r\n  <td width=\"20%\">\r\n    <!--SIR 23835 added exclude options -->\r\n    ");
      //  impact:validateSelect
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
      _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateSelect_0.setParent(null);
      _jspx_th_impact_validateSelect_0.setLabel("Method");
      _jspx_th_impact_validateSelect_0.setName("selSzCdContactMethod");
      _jspx_th_impact_validateSelect_0.setRequired("true");
      _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( methodDisabled ) );
      _jspx_th_impact_validateSelect_0.setColspan("4");
      _jspx_th_impact_validateSelect_0.setOptions( PortalContactDetailConversation.getMethodOptions(request, true) );
      _jspx_th_impact_validateSelect_0.setValue( _selSzCdContactMethod );
      _jspx_th_impact_validateSelect_0.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.DEFAULT );
      int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
      if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
      //  impact:validateSelect
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
      _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateSelect_1.setParent(null);
      _jspx_th_impact_validateSelect_1.setLabel("Location");
      _jspx_th_impact_validateSelect_1.setName("selSzCdContactLocation");
      _jspx_th_impact_validateSelect_1.setCodesTable("CCNCTLOC");
      _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf( locationDisabled ) );
      _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
      _jspx_th_impact_validateSelect_1.setValue( _selSzCdContactLocation );
      _jspx_th_impact_validateSelect_1.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.DEFAULT );
      int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
      if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  </td>\r\n  \r\n  \r\n  <td>\r\n    ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_2.setParent(null);
      _jspx_th_impact_validateInput_2.setLabel("Name of Agency");
      _jspx_th_impact_validateInput_2.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateInput_2.setType("text");
      _jspx_th_impact_validateInput_2.setName("szNmAgencyName");
      _jspx_th_impact_validateInput_2.setConstraint("Name20");
      _jspx_th_impact_validateInput_2.setDisabled( modifyDisabled );
      _jspx_th_impact_validateInput_2.setEditableMode( EditableMode.DEFAULT );
      _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
      _jspx_th_impact_validateInput_2.setValue( _csys08so.getSzNmAgencyName() );
      int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
      if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  </td>\r\n </tr> \r\n  \r\n <tr> \r\n  <td>\r\n    ");
      //  impact:validateSelect
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
      _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateSelect_2.setParent(null);
      _jspx_th_impact_validateSelect_2.setLabel("Others Contacted");
      _jspx_th_impact_validateSelect_2.setName("selSzCdContactOthers");
      _jspx_th_impact_validateSelect_2.setCodesTable("COTHCNCT");
      _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( otherDisabled ) );
      _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
      _jspx_th_impact_validateSelect_2.setValue( _selSzCdContactOthers );
      _jspx_th_impact_validateSelect_2.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.DEFAULT );
      int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
      if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  </td>\r\n  <td colspan=\"4\">\r\n    ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_3.setParent(null);
      _jspx_th_impact_validateInput_3.setName("chkCrossCountyLines");
      _jspx_th_impact_validateInput_3.setType("checkbox");
      _jspx_th_impact_validateInput_3.setLabel("Permission to cross county lines");
      _jspx_th_impact_validateInput_3.setDisabled( String.valueOf( otherDisabled ) );
      _jspx_th_impact_validateInput_3.setChecked( Boolean.toString(_chkCrossCountyLines) );
      _jspx_th_impact_validateInput_3.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
      if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  </td>\r\n</tr>\r\n\r\n\r\n\r\n<br>\r\n\r\n  ");

  //STGAP00014326 MR-024 Add Purpose Checkboxes.
    List<String> checkedPurposeList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxContactPurpose"));
  //MR -024 Retrieve Purpose check boxes
   ContactCbxDisplay_Array cbxArray = _csys08so.getContactCbxDisplay_Array();
    if(cbxArray != null && cbxArray.getUlRowQty() > 0) {
      checkedPurposeList = new ArrayList<String>();
      for(ContactCbxDisplay cbxDisplay : cbxArray.getContactCbxDisplay()) {
        String codeType = cbxDisplay.getSzCdCbxCodeType();
        if(CodesTables.CCNTPURP.equals(codeType)) {
          checkedPurposeList.add(cbxDisplay.getSzCdContactCbx());
        } 
      }
    }
    
      out.write("\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n\t<th>\r\n\t\t<span class=\"formRequiredText\">*</span>Purpose \r\n\t</th>\r\n</tr>\r\n<tr>\r\n   <td> ");
      //  impact:codesCheckbox
      gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
      _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codesCheckbox_0.setParent(null);
      _jspx_th_impact_codesCheckbox_0.setName("cbxContactPurpose");
      _jspx_th_impact_codesCheckbox_0.setColumns(3);
      _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CCNTPURP );
      _jspx_th_impact_codesCheckbox_0.setDisabled( String.valueOf( purposeDisabled ) );
      _jspx_th_impact_codesCheckbox_0.setDefaultCodes( checkedPurposeList );
      _jspx_th_impact_codesCheckbox_0.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
      if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  \r\n    </td>\r\n</tr>\r\n</table>\r\n\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"4\"> Principals/Collaterals Contacted</th>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"4\">");
      //  impact:pagination
      gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
      _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_pagination_0.setParent(null);
      _jspx_th_impact_pagination_0.setSubmitUrl("/contacts/PortalContactDetail/displayContact");
      _jspx_th_impact_pagination_0.setSaveState("false");
      int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
      if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" class=\"formlabel\">\r\n    <div id=\"scroll3\" style=\"width:100%; height:125px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\" width=\"20%\">Name</th>\r\n          <th class=\"thList\" width=\"20%\">Type</th>\r\n          <th class=\"thList\" width=\"20%\">Role</th>\r\n          <th class=\"thList\" width=\"20%\">Relation/Interest</th>\r\n          <th class=\"thList\" width=\"20%\">Private <br> Conversation</th>\r\n          <th class=\"thList\" width=\"20%\">Discussed/In Reference To</th>\r\n        </tr>\r\n        <tr>\r\n          ");

            ROWCSYS08SO_ARRAY rowcsys08soArray = _csys08so.getROWCSYS08SO_ARRAY();
            if( rowcsys08soArray == null )
            {
              rowcsys08soArray = new ROWCSYS08SO_ARRAY();
            }

            Enumeration csys08soEnumeration = rowcsys08soArray.enumerateROWCSYS08SO();

            if( !csys08soEnumeration.hasMoreElements() )
            {
          
          out.write("\r\n          <tr class=\"odd\">\r\n            <td colspan=\"4\">\r\n              ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n            </td>\r\n          </tr>\r\n     <tr>\r\n          ");

          }
          else
          {
            int i = 0;
            while( csys08soEnumeration.hasMoreElements() )
            {
              ROWCSYS08SO csys08soRow = (ROWCSYS08SO)csys08soEnumeration.nextElement();
              if( i % 2 == 0 )
              {
                out.println( "<tr class=\"subDetail\">" );
              }
              else
              {
                out.println( "<tr class=\"altcolor\">" );
              }
              String cbxName = "cbxUlIdPerson" + ( i + 1 );
              String _szCdStagePersRole = csys08soRow.getSzCdStagePersRole();
              //SIR 18433 - Have to pass in Relation/Interest to checkPersRole
              String _szCdStagePersRelInt = csys08soRow.getSzCdStagePersRelInt();
              String indContactOccurred = csys08soRow.getCSysIndContactOccurred();

              String clickCommand =
                      "checkPersRole('" + _szCdStagePersRole + "', " +
                      "              '" + _szCdStagePersRelInt + "', " +
                      "              document.frmContactDetail." + cbxName + ".checked)";

              // This section increments the vics and perps so they can be set
              // by Javascript properly at the time of page loading.
              if( ArchitectureConstants.Y.equals( csys08soRow.getCSysIndContactOccurred() ) )
              {
                if( ( CodesTables.CROLEALL_AP.equals( _szCdStagePersRole ) ) ||
                    ( CodesTables.CROLEALL_DP.equals( _szCdStagePersRole ) ) )
                {
                  perps++;
                }
                if( ( CodesTables.CROLEALL_VC.equals( _szCdStagePersRole ) ) ||
                    ( CodesTables.CROLEALL_DV.equals( _szCdStagePersRole ) ) ||

                    ( ( CodesTables.CRPTRINT_SL.equals( _szCdStagePersRelInt ) ) &&
                      ( ( CodesTables.CROLEALL_NO.equals( _szCdStagePersRole ) ) ||
                        ( CodesTables.CROLEALL_UK.equals( _szCdStagePersRole ) ) ) ) )
                {
                  vics++;
                }
              }
              // do not add a <tr> here plz they are genereated in the code above
          
          out.write("\r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
          _jspx_th_impact_validateInput_4.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setChecked( indContactOccurred );
          _jspx_th_impact_validateInput_4.setValue( String.valueOf(csys08soRow.getUlIdPerson()) );
          _jspx_th_impact_validateInput_4.setName( cbxName );
          _jspx_th_impact_validateInput_4.setDisabled( modifyDisabled );
          _jspx_th_impact_validateInput_4.setOnClick( clickCommand );
          _jspx_th_impact_validateInput_4.setEditableMode( EditableMode.DEFAULT );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n            ");
          out.print( FormattingHelper.formatString( csys08soRow.getSzNmPersonFull() ) );
          out.write("\r\n          </td>\r\n          <td>");
          out.print( Lookup.simpleDecodeSafe( "CPRSNTYP", csys08soRow.getSzCdStagePersType() ) );
          out.write("</td>\r\n          <td>");
          out.print( Lookup.simpleDecodeSafe( "CINVROLE", _szCdStagePersRole ) );
          out.write("</td>\r\n          <td>");
          out.print( Lookup.simpleDecodeSafe( "CRPTRINT", _szCdStagePersRelInt ) );
          out.write("</td>\r\n          \r\n        ");
String cbxNamePrivConver = "cbxPrivConver" + ( i + 1 );
          String szCheckedPrivConver = "false";
         
         ROWPRIVCONVERSO_ARRAY rowPrivConversoArray = _csys08so.getROWPRIVCONVERSO_ARRAY();
         if( rowPrivConversoArray == null )
           {
            rowPrivConversoArray = new ROWPRIVCONVERSO_ARRAY();
           }

            Enumeration<ROWPRIVCONVERSO> privConverEnumeration = rowPrivConversoArray.enumerateROWPRIVCONVERSO();
          
         
          while (privConverEnumeration.hasMoreElements()){
             ROWPRIVCONVERSO rowPrivConverso = (ROWPRIVCONVERSO)privConverEnumeration.nextElement();
             if (rowPrivConverso.getUlIdPerson() == csys08soRow.getUlIdPerson()){
                 szCheckedPrivConver = "true";
             }
          }           
         
          out.write("\r\n           \r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
          _jspx_th_impact_validateInput_5.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setName(cbxNamePrivConver);
          _jspx_th_impact_validateInput_5.setChecked( szCheckedPrivConver);
          _jspx_th_impact_validateInput_5.setDisabled( modifyDisabled );
          _jspx_th_impact_validateInput_5.setValue( String.valueOf(i) );
          _jspx_th_impact_validateInput_5.setEditableMode( EditableMode.DEFAULT );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n\r\n          ");
 // SMS #109398: MR-086
          String cbxDiscussed = "cbxDiscussed" + ( i + 1 );
          String szCheckedDiscussed = "false";    
          ROWDISCUSSEDSO_ARRAY rowDiscussedsoArray = _csys08so.getROWDISCUSSEDSO_ARRAY();
          if( rowDiscussedsoArray == null )
           {
            rowDiscussedsoArray = new ROWDISCUSSEDSO_ARRAY();
           }

            Enumeration<ROWDISCUSSEDSO> discussedEnumeration = rowDiscussedsoArray.enumerateROWDISCUSSEDSO();
          
         
          while (discussedEnumeration.hasMoreElements()){
             ROWDISCUSSEDSO rowDiscussedso = (ROWDISCUSSEDSO)discussedEnumeration.nextElement();
             if (rowDiscussedso.getUlIdPerson() == csys08soRow.getUlIdPerson()){
               szCheckedDiscussed = "true";
             }
          }        
         
          out.write("\r\n          \r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
          _jspx_th_impact_validateInput_6.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setName(cbxDiscussed);
          _jspx_th_impact_validateInput_6.setChecked( szCheckedDiscussed);
          _jspx_th_impact_validateInput_6.setDisabled( modifyDisabled );
          _jspx_th_impact_validateInput_6.setValue( String.valueOf(i) );
          _jspx_th_impact_validateInput_6.setEditableMode( EditableMode.DEFAULT );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          ");
          out.write("\r\n          \r\n     </tr>\r\n        ");

          i++;
           }
          }
        
          out.write("\r\n </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"4\">");
          int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n</tr>\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  //SIR 18433 - set Javascript vics and purps to correct values, if needed.\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( (vics > 0) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  document.frmContactDetail.hdnBVictimSelected.value = \"Y\";\r\n  vics = ");
          out.print( vics );
          out.write(";\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_1.setParent(null);
      _jspx_th_impact_ifThen_1.setTest( (perps > 0) );
      int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
      if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  document.frmContactDetail.hdnBPerpSelected.value = \"Y\";\r\n  perps = ");
          out.print( perps );
          out.write(";\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n</script>\r\n");

    request.setAttribute( "tabIndex", _tabIndex );
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

  private boolean _jspx_meth_impact_validateInput_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent(null);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnBVictimSelected");
    _jspx_th_impact_validateInput_0.setValue("N");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent(null);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnBPerpSelected");
    _jspx_th_impact_validateInput_1.setValue("N");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
