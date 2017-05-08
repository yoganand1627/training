package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public final class LegalStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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
       * JSP Name:     LegalStatus.jsp
       * Created by:   Jennifer Casdorph
       * Date Created: 02/19/03
       *
       * Description:
       * the user will be able to enter, modify, and browse legal status information.
       * A user with the appropriate security will be able to enter the web page after
       * the case/stage is closed and modify the Legal Status page.
       **/
      /*
       Change History:
       Date      User              Description
       --------  ----------------  -----------------------------------------------
       08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
       08/28/03  Carolyn Douglass  Changed maxlength of cause # to 10.
       7/3/2004  Carolyn Douglass  SIR 22563 - Remind user to enter Legal Actions when changing Legal Status
       9/29/04   Carolyn Douglass  SIR 22768 - Prevent modification of LS type w/o Legal Status security
                                   SIR 22888 - batch entered records can only be deleted by legal status maintainers
       06/11/08  Stephen Roberts   SIR STGAP00009080
       06/22/08  Stephen Roberts   SIR STGAP00009247 - Excluded 'None' for County drop down box
       14/01/08  Mital Patel       STGAP00009848: Arranged the "legal status" drop down menu alphabetically by "Decode"       
       09/24/09  Bhavna Gehlot     STGAP00015351:Changing MSG_MISSING_PARENT_TPR message from an error message to a confirmational pop up message
       06/29/10  Joel Cochran      SMS #60156: Make Court Ordered Expiration Date conditionally required.
       08/12/10  hjbaptiste        SMS#65423: MR-71 Changes
       08/18/10  hjbaptiste        SMS#65423: Set Task Code of Custody from which ever stage that it was created instead of hard-coding INV Task Code
                                   as a Custody can be created from multiple stages
       11/23/10  htvo              SMS#81140 - MR-074 AFCARS: disable warning message for saving NAF by removing function call to saveConfirmMessage() 
                                   on Save button. This warning is changed into an error and handled in Save service.
       03/17/11  htvo              SMS#97845 MR-074-2 AFCARS: confirm that user wants to mofiy an Adoption Finalized legal status for a child whose
                                   adoption was previously reported to AFCARS. Removed unused code.
                                   
       */

      
      out.write("\r\n\r\n \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n\r\n");
/* Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
       to see how the page functions, but it should always be initialized to view mode.
       */
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      String pageMode = PageModeConstants.VIEW;

      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      //Set up the exclude array.
      ArrayList excludeOptions = new ArrayList();
      //Exclude -None-.  All legal status must have a county or out of state
      excludeOptions.add(CodesTables.CCOUNT_XXX);
      
      // MR-071 Filter out certain Legal Statuses 
      ArrayList<String> excludeLegalStatusTypes = (ArrayList<String>) state.getAttribute("excludeLegalStatusTypes", request);
      if (excludeLegalStatusTypes == null) {
        excludeLegalStatusTypes = new ArrayList<String>();
      }

      Boolean creatingFromCustody = null;
      creatingFromCustody = (Boolean) state.getAttribute("creatingFromCustody", request);
      org.exolab.castor.types.Date custodyDate = null;
      int idSUBStage = 0;
      String custodyCdTask = "";
      String custodyDateString = new String();
      if (creatingFromCustody != null && creatingFromCustody) {
        custodyDate = (org.exolab.castor.types.Date) state.getAttribute("custodyDate", request);
        idSUBStage = ((Integer) state.getAttribute("idSUBStage", request) != null) ? (Integer) state.getAttribute("idSUBStage", request) : 0;
        custodyCdTask = (String) state.getAttribute("custodyCdTask", request);
        custodyDateString = FormattingHelper.formatDate(custodyDate);
      }

      CSUB45SO csub45so = null;
      String legalStatus = ContextHelper.getStringSafe(request, "selLegalStat");
      String effDate = ContextHelper.getStringSafe(request, "txtDtEffLegalStat");
      // MR-71: If creating Legal Status from Custody, set the Status Effective Date to the Custody Date
      if (creatingFromCustody != null && creatingFromCustody) {
        effDate = custodyDateString;
      }
      String legalCounty = ContextHelper.getStringSafe(request, "selCdLegalStatCnty");
      // Do not show -None- in the county pick list
      if (legalCounty.equals("") && !CodesTables.CCOUNT_XXX.equals(userProfile.getUserCounty())) {
        legalCounty = userProfile.getUserCounty();
      }
      String yIsChecked = "false";
      String nIsChecked = "false";
      String rbChecked = ContextHelper.getStringSafe(request, "rbLegalRisk");
      if ("Y".equalsIgnoreCase(rbChecked)) {
        yIsChecked = "true";
        }else if("N".equalsIgnoreCase(rbChecked)){
        yIsChecked = "false";
        nIsChecked = "true";
        }else{
        yIsChecked = "false";
        nIsChecked = "false";
        }
      String CrtOrdExpDate = ContextHelper.getStringSafe(request, "txtDtCtOrExp");
      String CustExpDate = ContextHelper.getStringSafe(request, "txtDtCustodyExp");
      String PMDueDate = ContextHelper.getStringSafe(request, "txtDtPtMtDue");
      java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat("MM/dd/yyyy");
      java.util.Date tempDate = null;
      String bIndPrevAfcars = ""; //SMS#98745 MR-074 AFCARS

      csub45so = (CSUB45SO) state.getAttribute("CSUB45SO", request);
      if (csub45so != null) {
        legalStatus = csub45so.getROWCSUB45SOG01().getSzCdLegalStatStatus();
        if (csub45so.getROWCSUB45SOG01().getDtDtLegalStatStatusDt() != null) {
          tempDate = csub45so.getROWCSUB45SOG01().getDtDtLegalStatStatusDt().toDate();
          effDate = dateFormatter.format(tempDate);
        }

        String tempCounty = csub45so.getROWCSUB45SOG01().getSzCdLegalStatCnty();
        if (tempCounty != null && !"".equals(tempCounty)) {
          legalCounty = tempCounty;
        }
        if (csub45so.getROWCSUB45SOG01().getDtDtLegalStatCrtOrdExpDt() != null) {
          tempDate = csub45so.getROWCSUB45SOG01().getDtDtLegalStatCrtOrdExpDt().toDate();
          CrtOrdExpDate = dateFormatter.format(tempDate);
        }
        if (csub45so.getROWCSUB45SOG01().getDtDtLegalStatCustExpDt() != null) {
          tempDate = csub45so.getROWCSUB45SOG01().getDtDtLegalStatCustExpDt().toDate();
          CustExpDate = dateFormatter.format(tempDate);
        }
        if (csub45so.getROWCSUB45SOG01().getDtDtLegalStatPMDueDt() != null) {
          tempDate = csub45so.getROWCSUB45SOG01().getDtDtLegalStatPMDueDt().toDate();
          PMDueDate = dateFormatter.format(tempDate);
        }

        if ("Y".equals(csub45so.getROWCSUB45SOG01().getBIndLegalStatRisk())) {
          yIsChecked = "true";
        } else if ("N".equals(csub45so.getROWCSUB45SOG01().getBIndLegalStatRisk())) {
          nIsChecked = "true";
        }
        
        //SMS#98745 MR-074 AFCARS: Get the bIndPrevAfcars from the csub45so 
        bIndPrevAfcars = csub45so.getBIndPrevAfcars();
      }

      //SIR 22768 - Prevent modification of LS type w/o Legal Status security
      //UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      boolean haveLegalStatSecurity = userProfile.hasRight(UserProfile.SEC_MNTN_LEGAL_STAT);
      boolean disableLegalStatus = false;
      boolean bSaveButtonHide = false;
      
      // SWR 06/11/08 STGAP00009080 - Modified to if to support overrides
      if (pageMode.equals(PageModeConstants.VIEW) || (!haveLegalStatSecurity && pageMode.equals(PageModeConstants.MODIFY))) {
        disableLegalStatus = true;
        bSaveButtonHide = true;
      }

      /* Assign tab-index */
      int tabIndex = 1;
      
      out.write('\r');
      out.write('\n');
/* Needed for Form Launch Custom tag */

      
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n");
/* Start Javascript Section */

      
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\r\n  /*\r\n  *This function is called before the page unloads. It creates the\r\n  *\"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n\r\n\r\nvar MONTH_NAMES=new Array('January','February','March','April','May','June','July','August','September','October','November','December','Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec');\r\nfunction LZ(x) {return(x<0||x>9?\"\":\"0\")+x}\r\n\r\n// ------------------------------------------------------------------\r\n// formatDate (date_object, format)\r\n// Returns a date in the output format specified.\r\n// The format string uses the same abbreviations as in getDateFromFormat()\r\n// ------------------------------------------------------------------\r\nfunction formatDate(date,format) {\r\n        format=format+\"\";\r\n        var result=\"\";\r\n        var i_format=0;\r\n        var c=\"\";\r\n        var token=\"\";\r\n        var y=date.getYear()+\"\";\r\n");
      out.write("        var M=date.getMonth()+1;\r\n        var d=date.getDate();\r\n        var H=date.getHours();\r\n        var m=date.getMinutes();\r\n        var s=date.getSeconds();\r\n        var yyyy,yy,MMM,MM,dd,hh,h,mm,ss,ampm,HH,H,KK,K,kk,k;\r\n        // Convert real date parts into formatted versions\r\n        var value=new Object();\r\n        if (y.length < 4) {y=\"\"+(y-0+1900);}\r\n        value[\"y\"]=\"\"+y;\r\n        value[\"yyyy\"]=y;\r\n        value[\"yy\"]=y.substring(2,4);\r\n        value[\"M\"]=M;\r\n        value[\"MM\"]=LZ(M);\r\n        value[\"MMM\"]=MONTH_NAMES[M-1];\r\n        value[\"d\"]=d;\r\n        value[\"dd\"]=LZ(d);\r\n        value[\"H\"]=H;\r\n        value[\"HH\"]=LZ(H);\r\n        if (H==0){value[\"h\"]=12;}\r\n        else if (H>12){value[\"h\"]=H-12;}\r\n        else {value[\"h\"]=H;}\r\n        value[\"hh\"]=LZ(value[\"h\"]);\r\n        if (H>11){value[\"K\"]=H-12;} else {value[\"K\"]=H;}\r\n        value[\"k\"]=H+1;\r\n        value[\"KK\"]=LZ(value[\"K\"]);\r\n        value[\"kk\"]=LZ(value[\"k\"]);\r\n        if (H > 11) { value[\"a\"]=\"PM\"; }\r\n        else { value[\"a\"]=\"AM\"; }\r\n");
      out.write("        value[\"m\"]=m;\r\n        value[\"mm\"]=LZ(m);\r\n        value[\"s\"]=s;\r\n        value[\"ss\"]=LZ(s);\r\n        while (i_format < format.length) {\r\n                c=format.charAt(i_format);\r\n                token=\"\";\r\n                while ((format.charAt(i_format)==c) && (i_format < format.length)) {\r\n                        token += format.charAt(i_format++);\r\n                        }\r\n                if (value[token] != null) { result=result + value[token]; }\r\n                else { result=result + token; }\r\n                }\r\n        return result;\r\n  }\r\n\r\n /*SMS#97845 MR-074-2 AFCARS: display warning message when user modify an Adoption Finalized Legal Status*/\r\n function saveConfirmMessage()\r\n  {\r\n    var bIndPrevAfcars = document.frmLegalStatus.hdnBIndPrevAfcars.value;\r\n    var selLegalStat = document.frmLegalStatus.selLegalStat.value;\r\n    if ( selLegalStat == \"NAF\" && bIndPrevAfcars == \"Y\" && ");
      out.print( (!PageModeConstants.NEW.equals(pageMode) && !PageModeConstants.NEW_USING.equals(pageMode)) );
      out.write(" )\r\n    {\r\n      if( confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_LEG_STAT_AFCARS_MODIFY_WARN ) );
      out.write("') == true){\r\n        return true;\r\n      }else{\r\n        return false;\r\n     }\r\n    }\r\n    return true;\r\n  }\r\n  \r\n//End Java Script\r\n</script>\r\n\r\n");
/* Include custom tag for displaying errors on the page */

      
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
/* Start the form - See the Form Validation Cookbook or Custom Tag list for details
       on the attributes of the validateForm tag */

      
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmLegalStatus");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/subcare/LegalStatus/displayLegalStatus");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.LegalStatusCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnBIndPrevAfcars");
          _jspx_th_impact_validateInput_0.setValue( bIndPrevAfcars );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnIdSUBStage");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(idSUBStage) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnCustodyCdTask");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatString(custodyCdTask) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("  \r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnCreatingFromCustody");
          _jspx_th_impact_validateInput_3.setValue( (creatingFromCustody != null && creatingFromCustody) ? "true" : "false" );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n    \t<th colspan=4>\r\n      \tLegal Status Detail\r\n    \t</th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Legal Status");
          _jspx_th_impact_validateSelect_0.setName("selLegalStat");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex );
          _jspx_th_impact_validateSelect_0.setDisabled( Boolean.toString( disableLegalStatus));
          _jspx_th_impact_validateSelect_0.setOrderBy("decode");
          _jspx_th_impact_validateSelect_0.setCodesTable("CLEGSTAT");
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeLegalStatusTypes);
          _jspx_th_impact_validateSelect_0.setValue(legalStatus );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Legal County");
          _jspx_th_impact_validateSelect_1.setName("selCdLegalStatCnty");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex + 1 );
          _jspx_th_impact_validateSelect_1.setDisabled( Boolean.toString( disableLegalStatus ));
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setExcludeOptions(excludeOptions);
          _jspx_th_impact_validateSelect_1.setValue(legalCounty );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtEffLegalStat");
          _jspx_th_impact_validateDate_0.setDisabled( Boolean.toString( disableLegalStatus ));
          _jspx_th_impact_validateDate_0.setLabel("Status Effective");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue(effDate );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex + 2 );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("txtDtPtMtDue");
          _jspx_th_impact_validateDate_1.setDisabled( Boolean.toString( disableLegalStatus ));
          _jspx_th_impact_validateDate_1.setLabel("Petition/Motion Due Date");
          _jspx_th_impact_validateDate_1.setRequired("false");
          _jspx_th_impact_validateDate_1.setValue(PMDueDate );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex + 3 );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("txtDtCtOrExp");
          _jspx_th_impact_validateDate_2.setDisabled( Boolean.toString( disableLegalStatus ));
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setLabel("Court Order Expiration Date");
          _jspx_th_impact_validateDate_2.setRequired("false");
          _jspx_th_impact_validateDate_2.setValue(CrtOrdExpDate );
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex + 4 );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setName("txtDtCustodyExp");
          _jspx_th_impact_validateDate_3.setDisabled( Boolean.toString( disableLegalStatus ));
          _jspx_th_impact_validateDate_3.setLabel("Custody Expiration Date");
          _jspx_th_impact_validateDate_3.setRequired("false");
          _jspx_th_impact_validateDate_3.setValue(CustExpDate );
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex + 5 );
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    <tr>\r\n      <td>\r\n        Legal Risk\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setName("rbLegalRisk");
          _jspx_th_impact_validateInput_4.setDisabled( Boolean.toString( disableLegalStatus ));
          _jspx_th_impact_validateInput_4.setLabel("Yes");
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setValue("Y");
          _jspx_th_impact_validateInput_4.setChecked(yIsChecked);
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex + 6 );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setName("rbLegalRisk");
          _jspx_th_impact_validateInput_5.setDisabled( Boolean.toString( disableLegalStatus ));
          _jspx_th_impact_validateInput_5.setLabel("No");
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setValue("N");
          _jspx_th_impact_validateInput_5.setChecked(nIsChecked);
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex + 7 );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n  </table>\r\n  ");
/* Include buttons for performing actions on the page */

      
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      ");
/* TDs are needed here otherwise the Save button would not align vertically */

      
          out.write("\r\n      <td>\r\n        ");
if (!bSaveButtonHide) {
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setFunction("return saveConfirmMessage();");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setForm("frmLegalStatus");
          _jspx_th_impact_ButtonTag_0.setAction("/subcare/LegalStatus/saveLegalStatus");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex + 8);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
} else {
          out.write("\r\n        &nbsp;\r\n        ");
}
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
/*  Always include this hidden field in your form */

      
          out.write("\r\n  <input type=\"hidden\" name=\"");
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
/* Close Validate Form Custom Tag */

    
      out.write("\r\n\r\n\r\n");
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
