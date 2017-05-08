<%//*  JSP Name:     Person Characteristics
      //*  Created by:   Anna Grimshaw
      //*  Date Created: 11/15/2002
      //*
      //*  Description:
      //*  This JSP is used to maintain a Person's Characteristics
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  08/26/03  A.Corley          SIR 19533 Give the no chars app a value so that
      //**                              validation can handle it correctly.
      //**
      //**  03/13/07  N.Hegde           Added adoption section
      //**  07/30/09  bgehlot           STGAP00014806: Page is in view mode for the SAU_EXCHANGE
      //**  09/21/09  mxpatel           STGAP00015376: added code so that if the SAU_EXCHANGE has stage access then they can
      //**                              modify the person characteristics page. Also made sure there were no JavaScript errors on the page.
      //**  11/10/10  schoi 			SMS #81140: MR-074 Added two new fields for AFCARS Phase 1 Change
      //**  12/01/10  schoi 			SMS #81140: MR-074 Added JavaScript to enable dynamic radio button change
      //**  12/03/10  htvo              SMS #81140: MR-074 AFCARS: modified js to disable single parent adoption type when it is not single
      //**                              parent adoption.
      //**  12/04/10  htvo              SMS #81140: MR-074 AFCARS: added validation on No/Unknown on Previously Adopted to warn user that dependent 
      //**                              information will be cleared. Ok will clear data and disable fields. Cancel will set previous selection back.
      //**                              Make sure the field not already disabled before disable a field, to avoid js error on the page. When a fied is disabled, the name changed.
      //**  12/22/10 htvo               SMS #81140: MR-074 AFCARS: added Save confirmation: for existing data that has mismatch between 
      //**                              previously adoption indicator and previous adoption date, warn user that the previous adoption date will be cleared 
      //**  09/12/11  charden           STGAP00017058 - adding help icon to page
      //**  10/24/11 hnguyen            STGAP00017351:MR-092 IVE in prior adoption added Unknown radio.
      //**  11/07/11 hnguyen            STGAP00017351: MR-092 Updated javascript to disable new IVE in Prior Adoption Unknown radio.
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Chb" %>


<%
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                    .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      CINV24SO cinv24so = (CINV24SO) request.getAttribute("CINV24SO");
      List cpmValues = (List) request.getAttribute("cpmValues");
      List chbValues = (List) request.getAttribute("chbValues");
      List cmeValues = (List) request.getAttribute("cmeValues");
      List othValues = (List) request.getAttribute("othValues");
      List cctValues = (List) request.getAttribute("cctValues");
            
      int age = PersonDetailConversation.getAge(request);

      String cReqFuncCd = ContextHelper.getStringSafe(request, "cReqFuncCd");
      String PrevAdopt_Yes = ArchitectureConstants.FALSE;
      String PrevAdopt_No =  ArchitectureConstants.FALSE;
      String PrevAdopt_Un =  ArchitectureConstants.FALSE;
      String County = "";
      String State = "";
      String Country = "";
      String intAdopt = "";
      String privateAdopt = "";
      String publicAdopt = "";
      String adoptDislutn = "";
      String PrevAdopt = "";
      String PublicAdopt_P = ArchitectureConstants.FALSE;
      String PrivateAdopt_R = ArchitectureConstants.FALSE;
      String IntAdopt_I = ArchitectureConstants.FALSE;     
      //String txtPrevAdopt = FormattingHelper.formatDate(cinv24so.getTxtPrevAdopt() );      
      String txtPrevAdopt = "";
      String txtDissolutionDate = FormattingHelper.formatDate(cinv24so.getTxtDissolutionDate() );
      // SMS #81140: MR-074
      String TxtSinglePrAdo = "";
      String TxtSingleMomOrFar = "";
      String indIVEPriorAdoption = "";
      
      boolean bNoneDiagnosed = false;
      boolean bNotYetDiagnosed = false;
      String  bdispAdopt= "";
      String comments = cinv24so.getSzTxtCharCmnts();
      String agentName = cinv24so.getSzAgency();
      if(comments == null)
      {
        comments = "";
      }
      if(agentName == null)
      {
        agentName = "";
      }      
      County = cinv24so.getSzCdCounty();
      State = cinv24so.getSzCdState();
      Country = cinv24so.getSzCdCntry();


       if(cinv24so.getIndPublicAdoptn()!=null)
       {  
         publicAdopt = cinv24so.getIndPublicAdoptn();
       }  
       if(cinv24so.getIndAdoptnDislutn()!=null)
       {   
         adoptDislutn = cinv24so.getIndAdoptnDislutn();
       }  
       if(cinv24so.getIndPrevAdopt()!=null)
       { 
         PrevAdopt= cinv24so.getIndPrevAdopt();
       }  
      
         if (PrevAdopt != null)
        {
          if (PrevAdopt.equals("N")) {
         PrevAdopt_No = "true";
           } else if (PrevAdopt.equals("Y")){
         PrevAdopt_Yes = "true";
         }else if (PrevAdopt.equals("U")){
            PrevAdopt_Un = "true";
         } 
       } 
  
		// SMS #81140: MR-074
		if (cinv24so.getTxtPrevAdopt() != null)
       	{
       		txtPrevAdopt = FormattingHelper.formatDate(cinv24so.getTxtPrevAdopt() );
       	} 
       	if (cinv24so.getIndSingleParAdpt() != null)
       	{
       		TxtSinglePrAdo = cinv24so.getIndSingleParAdpt();
       	}   
       	if (cinv24so.getSzCdSngleMomOrFar() != null)
       	{
       		TxtSingleMomOrFar = cinv24so.getSzCdSngleMomOrFar();
       	}
       	if (cinv24so.getBIndIVEPriorAdoption() != null)
       	{
       		indIVEPriorAdoption = cinv24so.getBIndIVEPriorAdoption();
       	} 
       	
       
       // JDD change to make checkboxes to rado buttons
         if (publicAdopt != null)
        {
          if (publicAdopt.equals("P")) {
         PublicAdopt_P = "true";
           } else if (publicAdopt.equals("R")){
         PrivateAdopt_R = "true";
         }else if (publicAdopt.equals("I")){
            IntAdopt_I = "true";
         } 
       } 
            
      // If BCdPersonChar or BCdPersonCharNDiag are returned as true, set a variable so the no characteristics
      // checkbox will be checked.
      if ("2".equals(cinv24so.getBCdPersonChar())) {
        bNoneDiagnosed = true;
        bNotYetDiagnosed = false;
      } else if ("3".equals(cinv24so.getBCdPersonChar())) {
        bNotYetDiagnosed = true;
        bNoneDiagnosed = false;
      } else {
        bNoneDiagnosed = false;
        bNotYetDiagnosed = false;
      }

      if (cinv24so == null) {
        cinv24so = new CINV24SO();
        cinv24so.setSzTxtCharCmnts(ContextHelper.getStringSafe(request, "szTxtCharCmnts"));
      }

      //boolean displayAPS =
      //PersonDetailConversation.displayAPSCharacteristics(request);

      boolean displayParent = PersonDetailConversation.displayParentCharacteristics(request);

      //boolean displayChildPlacement =
      //PersonDetailConversation.displayChildPlacementCharacteristics(request);

      boolean displayChildInvest = PersonDetailConversation.displayChildInvestCharacteristics(request);
       if(displayChildInvest){
       bdispAdopt = "Y";
           }
      %>
<%/* Start Javascript Section */

      %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">

// SMS #81140: MR-074

<% String message = ""; %>
var actingOut = '<%= Lookup.simpleDecodeSafe(Chb.CHB, "70") %>';

// STGAP00017058 - creating function to bypass architectural constraints
function addQuestionMark(){
	// get all table cells in the document
	var cells = document.frmCharDetail.getElementsByTagName('td');

	// check each cell to add the help icon 
	for(var i = 0; i < cells.length; i++){
		var cell = cells[i];
		var inner = cell.innerHTML;
		if(actingOut == inner){
			cell.innerHTML = inner + '&nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayHelp()">?</a></strong>';
			break;
		}
	}
}

// STGAP00017058 - this function launches the help window
function displayHelp(){
  var descriptor = "";
  
  // describe the window properties
  descriptor += "width=450,";
  descriptor += "height=350,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=1,";
  descriptor += "fullscreen=0,";
  descriptor += "location=1,";
  descriptor += "menubar=0,";
  descriptor += "resizable=1,";
  descriptor += "scrollbars=1,";
  descriptor += "status=1,";
  descriptor += "toolbar=0";
  
  // open person characteristic help page
  return window.open('/person/PersonDetail/displayPersonCharacteristicsHelp', "", descriptor);
}
// clear and disable the Single Mother or Father adoption when it is not a Single Parent Adoption type
// no warning because there is no important data being cleared
function clearSingleParent() 
{ 
  var rbSingleAdoptGroup = eval("document.frmCharDetail." + "<%= PersonDetailConversation.RADIO_SINGLE_PAR_ADPT %>");    
  var rbSingleAdoptGroupValue = getSelectedRadioValue( rbSingleAdoptGroup );
  var rbSingleParentGroup = eval("document.frmCharDetail." + "<%= PersonDetailConversation.RADIO_SINGLE_MOM_OR_FAR %>");    
   if ( rbSingleAdoptGroupValue == "N" )
   { 
     rbSingleParentGroup.value = '';
     for( var i = 0; i < rbSingleParentGroup.length; i++ ){
        rbSingleParentGroup[i].checked = false;
        rbSingleParentGroup[i].disabled = true;
      }
   } else if ( rbSingleAdoptGroupValue == "Y" )
   { 
     for( var i = 0; i < rbSingleParentGroup.length; i++ ){
        rbSingleParentGroup[i].disabled = false;
      }
   }
} 

// confirm a No or Unknown selection will clear and diasble all Date of Previously Adopted and Single Parent fields
function confirmPrevAdopted() {
  var bConfirmClearPrevAdoption;
  var rbPrevAdoptGroup = eval("document.frmCharDetail.rbPrevAdopt"); 
  var rbPrevAdoptGroupValue = getSelectedRadioValue( rbPrevAdoptGroup );
  if (rbPrevAdoptGroupValue=="N" || rbPrevAdoptGroupValue=="U") {
  <%    
  message = "Selecting No or Unknown for Previously Adopted will clear and/or disable the Date of Previous Adoption and Single Parent adoption fields." ;
  %>
  bConfirmClearPrevAdoption = confirm("<%= message %>");
  if (bConfirmClearPrevAdoption == true) {
    // clear date of previously adopted and disable the field
    document.frmCharDetail.txtPrevAdopt.value = '';
    if (document.frmCharDetail.txtPrevAdopt) {
    document.frmCharDetail.txtPrevAdopt.disabled = true;
    }
    // clear Single Parent fields and disable the fields
    document.frmCharDetail.rbSinglePrAdo[0].checked = false;
    document.frmCharDetail.rbSinglePrAdo[1].checked = false;
    document.frmCharDetail.rbSingleMomOrFar[0].checked = false; 
    document.frmCharDetail.rbSingleMomOrFar[1].checked = false; 
    if (document.frmCharDetail.rbSinglePrAdo) {
    document.frmCharDetail.rbSinglePrAdo[0].disabled = true;
    document.frmCharDetail.rbSinglePrAdo[1].disabled = true;
    }
    if (document.frmCharDetail.rbSingleMomOrFar) {
    document.frmCharDetail.rbSingleMomOrFar[0].disabled = true;
    document.frmCharDetail.rbSingleMomOrFar[1].disabled = true;   
    }
    // clear IV-E Prior Adoption fields and disable the fields
    document.frmCharDetail.rbIVEPriorAdoption[0].checked = false;
    document.frmCharDetail.rbIVEPriorAdoption[1].checked = false;
    if (document.frmCharDetail.rbIVEPriorAdoption) {
    document.frmCharDetail.rbIVEPriorAdoption[0].disabled = true;
    document.frmCharDetail.rbIVEPriorAdoption[1].disabled = true;   
    } 
  } else {
    // @todo: this really needs clean up later to make it independent of radio option order and value
    var prev = document.frmCharDetail.hdnCbxPrevAdopt.value;
    if (prev=="Y") {
      document.frmCharDetail.rbPrevAdopt[0].checked = true; // set back to Yes
      document.frmCharDetail.rbPrevAdopt[1].checked = false; // clear No in case it is No selected and is being canceled
      document.frmCharDetail.rbPrevAdopt[2].checked = false; // clear Unknown 
    } else if (prev=="N") {
      document.frmCharDetail.rbPrevAdopt[1].checked = true; // 
      disableDatePreviouslyAdoptedAndSingleParent();
    } else if (prev=="U") {
      document.frmCharDetail.rbPrevAdopt[2].checked = true; // set back to Unknown 
      disableDatePreviouslyAdoptedAndSingleParent();
    }
  }
  // Enable the Date of Previous Adoption, Single Parent adoption and IV-E Prior Adoption 
  // fields if Previously Adoption is Yes
  } else {
    document.frmCharDetail.txtPrevAdopt.disabled = false;
    document.frmCharDetail.rbSinglePrAdo[0].disabled = false;
    document.frmCharDetail.rbSinglePrAdo[1].disabled = false;
    document.frmCharDetail.rbSingleMomOrFar[0].disabled = false;
    document.frmCharDetail.rbSingleMomOrFar[1].disabled = false;
    document.frmCharDetail.rbIVEPriorAdoption[0].disabled = false;
    document.frmCharDetail.rbIVEPriorAdoption[1].disabled = false;
  }
}
// disable the Date of Previous Adoption, Single Parent adoption and IV-E Prior Adoption 
// fields when Previously Adoption is No or Unknown
function disableDatePreviouslyAdoptedAndSingleParent() {
  var p = getSelectedRadioValue(document.frmCharDetail.rbPrevAdopt);
  if (p=="N" || p=="U") {
    if (document.frmCharDetail.txtPrevAdopt) { // make sure the field not already disable to avoid js error on the page
    document.frmCharDetail.txtPrevAdopt.disabled = true;
    }
    if (document.frmCharDetail.rbSinglePrAdo) {
    document.frmCharDetail.rbSinglePrAdo[0].disabled = true;
    document.frmCharDetail.rbSinglePrAdo[1].disabled = true;
    }
    if (document.frmCharDetail.rbSingleMomOrFar) {
    document.frmCharDetail.rbSingleMomOrFar[0].disabled = true;
    document.frmCharDetail.rbSingleMomOrFar[1].disabled = true;
    }
    if (document.frmCharDetail.rbIVEPriorAdoption) {
    document.frmCharDetail.rbIVEPriorAdoption[0].disabled = true;
    document.frmCharDetail.rbIVEPriorAdoption[1].disabled = true;   
    document.frmCharDetail.rbIVEPriorAdoption[2].disabled = true;   
    } 
  }
}
// set the current checkbox value before change
function setCurrentValue(value) {
  var hdnCbxPrevAdopt = document.frmCharDetail.hdnCbxPrevAdopt;
  hdnCbxPrevAdopt.value = value;
  eval(hdnCbxPrevAdopt);
}

function confirmSave() {
  var bConfirmClearPrevAdoption;
  var rbPrevAdoptGroup = eval("document.frmCharDetail.rbPrevAdopt"); 
  var rbPrevAdoptGroupValue = getSelectedRadioValue( rbPrevAdoptGroup );
  
  var dtPrevAdoptValue = document.frmCharDetail.txtPrevAdopt.value; 
  var rbSingleAdopt = eval("document.frmCharDetail.rbSinglePrAdo"); 
  var rbSingleAdoptValue = getSelectedRadioValue( rbSingleAdopt );
  var rbSingleAdoptType = eval("document.frmCharDetail.rbSingleMomOrFar"); 
  var rbSingleAdoptTypeValue = getSelectedRadioValue( rbSingleAdoptType );
  
  // Only show warning when there is values in the dependent fields that causes conflict
  if ((rbPrevAdoptGroupValue=="N" || rbPrevAdoptGroupValue=="U") && 
  (dtPrevAdoptValue != "" || rbSingleAdoptValue != "" || rbSingleAdoptTypeValue != "")) {
  <%    
  message = "Selecting No or Unknown for Previously Adopted will clear the Date of Previous Adoption and/or Single Parent adoption fields." ;
  %>
  return confirm("<%= message %>");
  }
  else {
    return true;
  }
}
// End MR-074 AFCARS
 
// This javascript disables and de-checks all characteristic checkboxes if
// the "no characteristics" or "not yet diagonized checkbox have been selected.  It enables all check
// boxes if the "no characteristics" or "not yet diagonized checkbox have been de-selected.
function setNoChar()
{
  if (frmCharDetail.cbxBCdPersonChar.checked == true) 
  {
<impact:ifThen test="<%= displayChildInvest %>">
    disableCheckboxes("frmCharDetail.cbxCPM", '<%= Lookup.getCategoryCollection("CPM").size() %>');
    disableCheckboxes("frmCharDetail.cbxCHB", '<%= Lookup.getCategoryCollection("CHB").size() %>');
    disableCheckboxes("frmCharDetail.cbxCME", '<%= Lookup.getCategoryCollection("CME").size() %>');
    disableCheckboxes("frmCharDetail.cbxOTH", '<%= Lookup.getCategoryCollection("OTH").size() %>');
</impact:ifThen>
<impact:ifThen test="<%= displayParent %>">
    disableCheckboxes("frmCharDetail.cbxCCT", '<%= Lookup.getCategoryCollection("CCT").size() %>');
</impact:ifThen>
  frmCharDetail.cbxBCdPersonCharNDiog.disabled = true;
  }
  else if(frmCharDetail.cbxBCdPersonCharNDiog.checked == true) 
  {
<impact:ifThen test="<%= displayChildInvest %>">
    disableCheckboxes("frmCharDetail.cbxCPM", '<%= Lookup.getCategoryCollection("CPM").size() %>');
    disableCheckboxes("frmCharDetail.cbxCHB", '<%= Lookup.getCategoryCollection("CHB").size() %>');
    disableCheckboxes("frmCharDetail.cbxCME", '<%= Lookup.getCategoryCollection("CME").size() %>');
    disableCheckboxes("frmCharDetail.cbxOTH", '<%= Lookup.getCategoryCollection("OTH").size() %>');
</impact:ifThen>
<impact:ifThen test="<%= displayParent %>">
    disableCheckboxes("frmCharDetail.cbxCCT", '<%= Lookup.getCategoryCollection("CCT").size() %>');
</impact:ifThen>
  frmCharDetail.cbxBCdPersonChar.disabled = true;
  }
  else
  {
      //frmCharDetail.aged.value = "N";
<impact:ifThen test="<%= displayChildInvest %>">
    enableCheckboxes("frmCharDetail.cbxCPM", '<%= Lookup.getCategoryCollection("CPM").size() %>');
    enableCheckboxes("frmCharDetail.cbxCHB", '<%= Lookup.getCategoryCollection("CHB").size() %>');
    enableCheckboxes("frmCharDetail.cbxCME", '<%= Lookup.getCategoryCollection("CME").size() %>');
    enableCheckboxes("frmCharDetail.cbxOTH", '<%= Lookup.getCategoryCollection("OTH").size() %>');
</impact:ifThen>
<impact:ifThen test="<%= displayParent %>">
    enableCheckboxes("frmCharDetail.cbxCCT", '<%= Lookup.getCategoryCollection("CCT").size() %>');
</impact:ifThen>
frmCharDetail.cbxBCdPersonCharNDiog.disabled = false;
frmCharDetail.cbxBCdPersonChar.disabled = false;

  }
}


function disableCheckboxes(prefix, size)
{
  for (i = 1; i <= size; i++)
  {
    var checkboxName = prefix + i;
    eval(checkboxName + ".disabled = true");
    eval(checkboxName + ".checked = false");
  }
}


function enableCheckboxes(prefix, size)
{
<%
 if (!(user.hasRight(UserProfile.SEC_SAU_EXCHANGE) && !(GlobalData.hasStageAccess(request)))){
        %>
      
  for (i = 1; i <= size; i++)
  {
    var checkboxName = prefix + i;
    eval(checkboxName + ".disabled = false");
  }
<%
  }
%>
}

function confirmNoChar()
{
  if ((frmCharDetail.cbxBCdPersonChar.checked == true)||(frmCharDetail.cbxBCdPersonCharNDiog.checked == true))
  {
    var bNoChar;
    <%
        //String message;
    %>
    if (frmCharDetail.cbxBCdPersonChar.checked == true) {
    <%    
        message = "";
        message = MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_NO_CHARS) ;
        message = MessageLookup.addMessageParameter( message, "None Diagnosed" ); 
    %>
        bNoChar = confirm("<%= message %>");
    } else {
    <%    
        message = "";
        message = MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_NO_CHARS) ;
        message = MessageLookup.addMessageParameter( message, "Not Yet Diagnosed" ); 
    %>
        bNoChar = confirm("<%= message %>");
    }
    
    if (bNoChar == true)
    {
      setNoChar();
    }  else
    {
      frmCharDetail.cbxBCdPersonChar.checked = false;
      frmCharDetail.cbxBCdPersonCharNDiog.checked = false;
      
    }
  }
  else
  {
    setNoChar();
   }
  }


  
window.onbeforeunload = function ()
{
  IsDirty();
}
//End Java Script
</script>


<%int tabIndex = 1;

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
      if (request.getAttribute("pageMode") != null) {
        pageModePassed = (String) request.getAttribute("pageMode");
        if (pageModePassed.equals(PageModeConstants.EDIT)) {
          overallPageMode = PageModeConstants.EDIT;
        } else if (pageModePassed.equals(PageModeConstants.VIEW)) {
          overallPageMode = PageModeConstants.VIEW;
        }
      }
      
      //STGAP00014806: Page is in view mode for the SAU_EXCHANGE
      if (user.hasRight(UserProfile.SEC_SAU_EXCHANGE) && !(GlobalData.hasStageAccess(request))){
        overallPageMode = PageModeConstants.VIEW;
      }
%>

<impact:validateErrors />


<impact:validateForm name="frmCharDetail" defaultButton="true" method="post" action="/person/PersonDetail/savePersonChar" pageMode="<%= overallPageMode %>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.PersonCharCustomValidation"
  schema="/WEB-INF/Constraints.xsd">

  <impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>" />
  <impact:validateInput type="hidden" name="hdnLNbrPersonAge" value='<%= "" + age %>' />
  <impact:validateInput type="hidden" name="aged" value="N" />
  <impact:validateInput type="hidden" name="hdndisplayChildInvest" value="<%= bdispAdopt %>" />
  <impact:validateInput type="hidden" name="hdnCbxPrevAdopt" value="<%=PrevAdopt %>" />
  <impact:validateInput type="hidden" name="hdnCbxPrevAdoptName" value="" />

  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td align="right">
        <a tabIndex="<%= tabIndex++ %>" onClick="hrefDirtyBypass=true;" href="javascript:expandAll()">Expand All</a>&nbsp; <a tabIndex="<%= tabIndex++ %>" onClick="hrefDirtyBypass=true;" href="javascript:collapseAll()">Collapse All</a>&nbsp;
      </td>
    </tr>
  </table>
  
 <impact:ifThen test="<%= displayChildInvest %>">
    <impact:ExpandableSectionTag name="ChildPM" label='<%= Lookup.simpleDecodeSafe("CCHRTCAT", "CPM")%>' tabIndex="<%= tabIndex++ %>">
      <tr>
        <td> 
          <impact:codesCheckbox defaultCodes="<%=cpmValues%>" editableMode="<%= EditableMode.EDIT %>" name="cbxCPM" codesTableName="CPM" columns="2" tabIndex="1" />
        </td>
      </tr>
    </impact:ExpandableSectionTag>
    <br>
  </impact:ifThen>

 <impact:ifThen test="<%= displayParent %>">
    <impact:ExpandableSectionTag name="Parent" label='<%= Lookup.simpleDecodeSafe("CCHRTCAT", "CCT")%>' tabIndex="<%= tabIndex++ %>">
      <tr>
        <td>
          <impact:codesCheckbox defaultCodes="<%=cctValues%>" editableMode="<%= EditableMode.EDIT %>" name="cbxCCT" codesTableName="CCT" columns="2" tabIndex="2" />
        </td>
      </tr>
    </impact:ExpandableSectionTag>
    <br>
  </impact:ifThen>

 

  
  <impact:ifThen test="<%= displayChildInvest %>">
    <impact:ExpandableSectionTag name="ChildHB" label='<%= Lookup.simpleDecodeSafe("CCHRTCAT", "CHB")%>' tabIndex="<%= tabIndex++ %>">
      <tr>
        <td>
          <impact:codesCheckbox defaultCodes="<%=chbValues%>" editableMode="<%= EditableMode.EDIT %>" name="cbxCHB" codesTableName="CHB" columns="2" tabIndex="3" />
        </td>
      </tr>
    </impact:ExpandableSectionTag>
    <br>
  </impact:ifThen>



  <impact:ifThen test="<%= displayChildInvest %>">
    <impact:ExpandableSectionTag name="ChildME" label='<%= Lookup.simpleDecodeSafe("CCHRTCAT", "CME")%>' tabIndex="<%= tabIndex++ %>">
      <tr>
        <td>
          <impact:codesCheckbox defaultCodes="<%=cmeValues%>" editableMode="<%= EditableMode.EDIT %>" name="cbxCME" codesTableName="CME" columns="2" tabIndex="4" />
        </td>
      </tr>
    </impact:ExpandableSectionTag>
    <br>
  </impact:ifThen>



  <impact:ifThen test="<%= displayChildInvest %>">
    <impact:ExpandableSectionTag name="ChildOTH" label='<%= Lookup.simpleDecodeSafe("CCHRTCAT", "OTH")%>' tabIndex="<%= tabIndex++ %>">
      <tr>
        <td>
          <impact:codesCheckbox defaultCodes="<%=othValues%>" editableMode="<%= EditableMode.EDIT %>" name="cbxOTH" codesTableName="OTH" columns="2" tabIndex="5" />
        </td>
      </tr>
    </impact:ExpandableSectionTag>
    <br>
  </impact:ifThen>



  <impact:ExpandableSectionTag name="NoChar" label="None Diagnosed" tabIndex="<%= tabIndex++ %>">
    <tr>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT %>" checked="<%= String.valueOf(bNoneDiagnosed) %>" onClick="confirmNoChar();" type="checkbox" name="cbxBCdPersonChar" label="None Diagnosed" value="Y"
          cssClass="formInput" />
      </td>

    </tr>
  </impact:ExpandableSectionTag>
  <br>
  <impact:ExpandableSectionTag name="NotYetDiag" label="Not Yet Diagnosed" tabIndex="<%= tabIndex++ %>">
    <tr>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT %>" checked="<%= String.valueOf(bNotYetDiagnosed) %>" onClick="confirmNoChar();" type="checkbox" name="cbxBCdPersonCharNDiog" label="Not Yet Diagnosed" value="Y"
          cssClass="formInput" />
      </td>
    </tr>
    <br>
   </impact:ExpandableSectionTag>
 <br>

 <impact:ifThen test="<%= displayChildInvest %>">
  <impact:ExpandableSectionTag name="Adoption" label="Adoption" tabIndex="<%= tabIndex++ %>">
   <table border="0" cellpadding="3" cellspacing="0" width = "100%" class="subDetail">
   <tr>
     <td> <span class="formRequiredText">*</span> Previously Adopted </td>
     <td colspan = "4">
        <impact:validateInput type="radio" label="Yes" id="PrevAdopt_Yes" name="rbPrevAdopt" value="Y" cssClass="formInput" checked="<%= PrevAdopt_Yes %>" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT %>" 
                              onClick="confirmPrevAdopted();" 
                              onChange="setCurrentValue(this.value);" />&nbsp;&nbsp;&nbsp;
        <impact:validateInput type="radio" label="No"  id="PrevAdopt_No" name="rbPrevAdopt" value="N" cssClass="formInput" checked="<%= PrevAdopt_No %>" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT %>" 
                              onClick="confirmPrevAdopted();" 
                              onChange="setCurrentValue(this.value);" /> &nbsp;&nbsp;&nbsp;
        <impact:validateInput type="radio" label="Unknown"  id="PrevAdopt_Un" name="rbPrevAdopt" value="U" cssClass="formInput" checked="<%= PrevAdopt_Un %>" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT %>" 
                              onClick="confirmPrevAdopted();" 
                              onChange="setCurrentValue(this.value);" /> &nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
      </td>
      
    </tr>
    <tr>
        <td>
        
            <impact:validateDate name="txtPrevAdopt"
                                 label="Date of Previous Adoption"
                                 constraint="Date"
                                 tabIndex="<%= tabIndex++ %>"
                                 conditionallyRequired="true"
                                 value="<%= txtPrevAdopt %>"
                                 size="10" />             
       </td>
    </tr>
    <!-- SMS #81140: MR-074 Change -->     
	<tr>
		<td>
			<span class="formCondRequiredText">&#8225;</span>Was this a single parent adoption? </td>
		<td colspan = "4">
			<impact:validateInput type="radio" label="Yes" name="<%= PersonDetailConversation.RADIO_SINGLE_PAR_ADPT %>" cssClass="formInput"
				checked="<%=String.valueOf(ArchitectureConstants.Y.equals(TxtSinglePrAdo)) %>" 
                value="<%= ArchitectureConstants.Y %>" tabIndex="<%= tabIndex++ %>"
                editableMode="<%= EditableMode.EDIT %>"
                onClick="clearSingleParent();"/>                
			<impact:validateInput type="radio" label="No" name="<%= PersonDetailConversation.RADIO_SINGLE_PAR_ADPT %>" cssClass="formInput"
				checked="<%=String.valueOf(ArchitectureConstants.N.equals(TxtSinglePrAdo)) %>" 
            	value="<%= ArchitectureConstants.N %>" tabIndex="<%= tabIndex++ %>"
            	editableMode="<%= EditableMode.EDIT %>"
            	onClick="clearSingleParent();"/>          	
		</td>	                          		      		
	</tr>
	<tr>
		<td>
			<span class="formCondRequiredText">&#8225;</span>If Yes, select one (Single Mother, Single Father) </td>
		<td colspan = "4">
			<impact:validateInput type="radio" label="Single Mother" name="<%= PersonDetailConversation.RADIO_SINGLE_MOM_OR_FAR %>" cssClass="formInput"
                checked="<%=String.valueOf(CodesTables.CSPATYPE_SM.equals(FormattingHelper.formatString(TxtSingleMomOrFar)))%>"
				value="<%=CodesTables.CSPATYPE_SM%>" tabIndex="<%= tabIndex++ %>"
				editableMode="<%= EditableMode.EDIT %>"/>
			<impact:validateInput type="radio" label="Single Father" name="<%= PersonDetailConversation.RADIO_SINGLE_MOM_OR_FAR %>" cssClass="formInput"
            	checked="<%=String.valueOf(CodesTables.CSPATYPE_SF.equals(FormattingHelper.formatString(TxtSingleMomOrFar)))%>"
				value="<%=CodesTables.CSPATYPE_SF%>" tabIndex="<%= tabIndex++ %>"
            	editableMode="<%= EditableMode.EDIT %>"/>
		</td>	                          		      		
	</tr>					              						   		    
    <!-- End of SMS #81140: MR-074 AFCARS Change --> 
    <!-- MR-092: Fostering Connections Add on -->
    <tr>
		<td>
			<span class="formCondRequiredText">&#8225;</span>Was child determined to be eligible for Title IV-E in prior adoption? </td>
		<td colspan = "4">
			<impact:validateInput type="radio" label="Yes" name="<%= PersonDetailConversation.RADIO_IVE_PRIOR_ADOPTION %>" cssClass="formInput"
				checked="<%=String.valueOf(ArchitectureConstants.Y.equals(indIVEPriorAdoption)) %>" 
                value="<%= ArchitectureConstants.Y %>" tabIndex="<%= tabIndex++ %>"
                editableMode="<%= EditableMode.EDIT %>"/>                
			<impact:validateInput type="radio" label="No" name="<%= PersonDetailConversation.RADIO_IVE_PRIOR_ADOPTION %>" cssClass="formInput"
				checked="<%=String.valueOf(ArchitectureConstants.N.equals(indIVEPriorAdoption)) %>" 
            	value="<%= ArchitectureConstants.N %>" tabIndex="<%= tabIndex++ %>"
            	editableMode="<%= EditableMode.EDIT %>"/>          	
      <impact:validateInput type="radio" label="Unknown" name="<%= PersonDetailConversation.RADIO_IVE_PRIOR_ADOPTION %>" cssClass="formInput"
        checked="<%=String.valueOf(ArchitectureConstants.U.equals(indIVEPriorAdoption)) %>" 
              value="<%= ArchitectureConstants.U %>" tabIndex="<%= tabIndex++ %>"
              editableMode="<%= EditableMode.EDIT %>"/>           
		</td>	                          		      		
	</tr>
    <tr>
    <td colspan="4">
      <impact:validateInput type="checkbox" editableMode="<%= EditableMode.EDIT %>" cssClass="formInput" label="Adoption Dissolution" checked="<%= (("".equals(adoptDislutn)) || (ArchitectureConstants.N.equals(adoptDislutn))) ? ArchitectureConstants.FALSE : ArchitectureConstants.TRUE %>" tabIndex="<%= tabIndex++ %>" value="Y" name="chkAdoptDislutn"
          cssClass="formInput" />
             </td>
             <td>
                <impact:validateDate name="txtDissolutionDate"
                              label="Dissolution Date"
                              constraint="Date"
                              conditionallyRequired="true"                    
                              value= "<%= txtDissolutionDate %>"
                              tabIndex="<%= tabIndex++ %>"                            
                              size="10"/>     
              </td>
              <td>&nbsp;</td><td>&nbsp;</td>
    </tr>
   <tr>
     <td> <span class="formCondRequiredText""></span> Adoption Type </td>
     <td colspan = "4">
        <impact:validateInput type="radio" label="Public" id="PublicAdopt_P" name="rbAdoptType" value="P" cssClass="formInput" checked="<%= PublicAdopt_P %>" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT %>" />&nbsp;&nbsp;&nbsp;
        <impact:validateInput type="radio" label="Private"  id="PrivateAdopt_R" name="rbAdoptType" value="R" cssClass="formInput" checked="<%= PrivateAdopt_R %>" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT %>" /> &nbsp;&nbsp;&nbsp;
        <impact:validateInput type="radio" label="International"  id="IntAdopt_I" name="rbAdoptType" value="I" cssClass="formInput" checked="<%= IntAdopt_I %>" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT %>" /> &nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </td>     
    </tr>
   
    <tr>

       <td colspan = "1">  
       <impact:validateSelect blankValue="true" editableMode="<%= EditableMode.EDIT %>" conditionallyRequired="true" label="State" name="cdState" codesTable="CSTATE"  tabIndex="<%= tabIndex++ %>" value="<%= State %>"/> 
       </td><td>&nbsp;</td><td>&nbsp;</td>
    </tr>
    <tr>
       <td colspan = "1">  
       <impact:validateSelect blankValue="true" editableMode="<%= EditableMode.EDIT %>" conditionallyRequired="true" label="County" name="cdCounty" codesTable="CCOUNT"  tabIndex="<%= tabIndex++ %>" value="<%= County %>"/> 
      </td><td>&nbsp;</td><td>&nbsp;</td>
    </tr>
    <tr>
    <td colspan = "1">
      <impact:validateSelect blankValue="true" editableMode="<%= EditableMode.EDIT %>" conditionallyRequired="true" label="Country" name="cdCountry" codesTable="CCNTRY"  tabIndex="<%= tabIndex++ %>" value="<%= Country %>"/>    
      </td><td>&nbsp;</td><td>&nbsp;</td>
    </tr> 
        <tr>
      <td colspan = "1">

        <impact:validateInput type="text"
                                editableMode="<%= EditableMode.EDIT %>"
                                label="Name Of Agency" 
                                name="szAgency"
                                cssClass="formInput"
                                value="<%= agentName %>"
                                size="60"
                                maxLength="80"
                                tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
   </table> 
    </impact:ExpandableSectionTag>
   <br>
  </impact:ifThen>
    
  <table width="100%" cellpadding="3" cellspacing="0" border="0">
    <tr>
      <td>
        <impact:validateTextArea name="szTxtCharCmnts" label="Comments" rows="4" cols="120" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>" maxLength="300" constraint="Paragraph300">
          <%=comments%>
        </impact:validateTextArea>
      </td>
    </tr>
   </table>
    <br>
    <table width="100%" cellpadding="3" cellspacing="0" border="0">
      <tr>
        <td class="alignRight">
          <impact:ButtonTag name="btnSave" img="btnSave" form="frmCharDetail" editableMode="<%= EditableMode.EDIT %>" action="/person/PersonDetail/savePersonChar" function="return confirmSave()" tabIndex="<%= tabIndex++ %>" />
        </td>
      </tr>
    </table>


    <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
    </impact:validateForm>

    <script type="text/javascript" language="JavaScript1.2">
// STGAP00017058
addQuestionMark();
setNoChar();
clearSingleParent();
disableDatePreviouslyAdoptedAndSingleParent();
</script>