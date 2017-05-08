<%/**
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

      %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="java.util.ArrayList"%> 
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%> 
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>

<%/* Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
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
      %>
<%/* Needed for Form Launch Custom tag */

      %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<%/* Start Javascript Section */

      %>

<script type="text/javascript" language="JavaScript1.2">


  /*
  *This function is called before the page unloads. It creates the
  *"Are you sure you want to navigate away from this page..." pop-up message.
  */
window.onbeforeunload = function ()
{
  IsDirty();
}


var MONTH_NAMES=new Array('January','February','March','April','May','June','July','August','September','October','November','December','Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec');
function LZ(x) {return(x<0||x>9?"":"0")+x}

// ------------------------------------------------------------------
// formatDate (date_object, format)
// Returns a date in the output format specified.
// The format string uses the same abbreviations as in getDateFromFormat()
// ------------------------------------------------------------------
function formatDate(date,format) {
        format=format+"";
        var result="";
        var i_format=0;
        var c="";
        var token="";
        var y=date.getYear()+"";
        var M=date.getMonth()+1;
        var d=date.getDate();
        var H=date.getHours();
        var m=date.getMinutes();
        var s=date.getSeconds();
        var yyyy,yy,MMM,MM,dd,hh,h,mm,ss,ampm,HH,H,KK,K,kk,k;
        // Convert real date parts into formatted versions
        var value=new Object();
        if (y.length < 4) {y=""+(y-0+1900);}
        value["y"]=""+y;
        value["yyyy"]=y;
        value["yy"]=y.substring(2,4);
        value["M"]=M;
        value["MM"]=LZ(M);
        value["MMM"]=MONTH_NAMES[M-1];
        value["d"]=d;
        value["dd"]=LZ(d);
        value["H"]=H;
        value["HH"]=LZ(H);
        if (H==0){value["h"]=12;}
        else if (H>12){value["h"]=H-12;}
        else {value["h"]=H;}
        value["hh"]=LZ(value["h"]);
        if (H>11){value["K"]=H-12;} else {value["K"]=H;}
        value["k"]=H+1;
        value["KK"]=LZ(value["K"]);
        value["kk"]=LZ(value["k"]);
        if (H > 11) { value["a"]="PM"; }
        else { value["a"]="AM"; }
        value["m"]=m;
        value["mm"]=LZ(m);
        value["s"]=s;
        value["ss"]=LZ(s);
        while (i_format < format.length) {
                c=format.charAt(i_format);
                token="";
                while ((format.charAt(i_format)==c) && (i_format < format.length)) {
                        token += format.charAt(i_format++);
                        }
                if (value[token] != null) { result=result + value[token]; }
                else { result=result + token; }
                }
        return result;
  }

 /*SMS#97845 MR-074-2 AFCARS: display warning message when user modify an Adoption Finalized Legal Status*/
 function saveConfirmMessage()
  {
    var bIndPrevAfcars = document.frmLegalStatus.hdnBIndPrevAfcars.value;
    var selLegalStat = document.frmLegalStatus.selLegalStat.value;
    if ( selLegalStat == "NAF" && bIndPrevAfcars == "Y" && <%= (!PageModeConstants.NEW.equals(pageMode) && !PageModeConstants.NEW_USING.equals(pageMode)) %> )
    {
      if( confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_LEG_STAT_AFCARS_MODIFY_WARN ) %>') == true){
        return true;
      }else{
        return false;
     }
    }
    return true;
  }
  
//End Java Script
</script>

<%/* Include custom tag for displaying errors on the page */

      %>
<impact:validateErrors />
<%/* Start the form - See the Form Validation Cookbook or Custom Tag list for details
       on the attributes of the validateForm tag */

      %>
<impact:validateForm name="frmLegalStatus" method="post" action="/subcare/LegalStatus/displayLegalStatus" validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.LegalStatusCustomValidation" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">

<impact:validateInput type="hidden" name="hdnBIndPrevAfcars" value="<%= bIndPrevAfcars %>" />
<impact:validateInput type="hidden" name="hdnIdSUBStage" value="<%= FormattingHelper.formatInt(idSUBStage) %>" />
<impact:validateInput type="hidden" name="hdnCustodyCdTask" value="<%= FormattingHelper.formatString(custodyCdTask) %>" />  
<impact:validateInput type="hidden" name="hdnCreatingFromCustody" value="<%= (creatingFromCustody != null && creatingFromCustody) ? "true" : "false" %>" />

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
    	<th colspan=4>
      	Legal Status Detail
    	</th>
    </tr>
    <tr>
      <td>
        <impact:validateSelect label="Legal Status" name="selLegalStat" tabIndex="<%= tabIndex %>" disabled='<%= Boolean.toString( disableLegalStatus)%>'orderBy="decode" codesTable="CLEGSTAT" excludeOptions="<%=excludeLegalStatusTypes%>" value="<%=legalStatus %>" required="true" />
      </td>
      <td>
        <impact:validateSelect label="Legal County" name="selCdLegalStatCnty" tabIndex="<%= tabIndex + 1 %>" disabled='<%= Boolean.toString( disableLegalStatus )%>' codesTable="CCOUNT" excludeOptions="<%=excludeOptions%>" value="<%=legalCounty %>" required="true" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate name="txtDtEffLegalStat" disabled='<%= Boolean.toString( disableLegalStatus )%>' label="Status Effective" required="true" value="<%=effDate %>" size="10" constraint="Date" tabIndex="<%= tabIndex + 2 %>" />
      </td>
      <td>
        <impact:validateDate name="txtDtPtMtDue" disabled='<%= Boolean.toString( disableLegalStatus )%>' label="Petition/Motion Due Date" required="false" value="<%=PMDueDate %>" size="10" constraint="Date" tabIndex="<%= tabIndex + 3 %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate name="txtDtCtOrExp" disabled='<%= Boolean.toString( disableLegalStatus )%>' conditionallyRequired="true" label="Court Order Expiration Date" required="false" value="<%=CrtOrdExpDate %>" size="10" constraint="Date" tabIndex="<%= tabIndex + 4 %>" />
      </td>
      <td>
        <impact:validateDate name="txtDtCustodyExp" disabled='<%= Boolean.toString( disableLegalStatus )%>' label="Custody Expiration Date" required="false" value="<%=CustExpDate %>" size="10" constraint="Date" tabIndex="<%= tabIndex + 5 %>" />
      </td>
    <tr>
      <td>
        Legal Risk
      </td>
      <td>
        <impact:validateInput name="rbLegalRisk" disabled='<%= Boolean.toString( disableLegalStatus )%>' label="Yes" type="radio" value="Y" checked="<%=yIsChecked%>" cssClass="formInput" tabIndex="<%= tabIndex + 6 %>" />
        <impact:validateInput name="rbLegalRisk" disabled='<%= Boolean.toString( disableLegalStatus )%>' label="No" type="radio" value="N" checked="<%=nIsChecked%>" cssClass="formInput" tabIndex="<%= tabIndex + 7 %>" />
      </td>
    </tr>

  </table>
  <%/* Include buttons for performing actions on the page */

      %>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td>
        &nbsp;
      </td>
      <%/* TDs are needed here otherwise the Save button would not align vertically */

      %>
      <td>
        <%if (!bSaveButtonHide) {%>
        <impact:ButtonTag name="btnSave" img="btnSave"  function="return saveConfirmMessage();" align="right" restrictRepost="true" form="frmLegalStatus" action="/subcare/LegalStatus/saveLegalStatus" tabIndex="<%= tabIndex + 8%>"/>
        <%} else {%>
        &nbsp;
        <%}%>
      </td>
    </tr>
  </table>
  <%/*  Always include this hidden field in your form */

      %>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%/* Close Validate Form Custom Tag */

    %>


