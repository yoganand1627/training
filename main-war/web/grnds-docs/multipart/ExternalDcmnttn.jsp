<%
  //*  JSP Name:     Allegation List
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 11/19/02
//*
//*  Description:
//*   Displays a listing of all allegations for a given stage.
//*   Also calculates overall roles and the stage's overall
//*   disposition if all allegations in the stage have been
//*   addressed.
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  03/25/03  Todd Reser        QA Sweep.
  04/16/03  Todd Reser        Added Confirm Delete fuction, removed unused code.
  04/30/03  Todd Reser        Changed Confirm Delete message, added rbSelected
                              to determine if a rb was selected.
  05/29/03  Todd Reser        Added emailMessage parameter to report.
  10/03/03  CORLEYAN          SIR 19951 This page should always be in modify mode regardless
                              of the app mode
  09/12/05  PISHARRK          SIR 23953 - Starting MPS Phase III enhancement to display 
                              Ext. Doc List/Details using EJB/DAO service(replacing existing DAMs) 
                              for both MPS and IMPACT
  09/23/05  cooganpj          SIR 23966 - MPS Phase III Lockdown changes - updated to read in the page
                              mode from the conversation.
  09/10/09  ssubram           STGAP00015066: Added Search Capability and additional validation     
  09/15/09  ssubram           STGAP00015066: Sort Functionality has been added. Note: In order to make
  							  the SortableColumnHeader to work, USE a separate form from the search one.
  11/05/09  pcoogan           SMS 39107: Added sort key for document class		
  11/22/09  pcoogan           SMS 40847: Removed unncessary radio button index causing delete to fail.
  01/30/12	vcollooru		  STGAP00017827 MR-085 Modified to add new checkbox in search criteria for filtering the results for ICPC Document.
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.multipart.ExternalDcmnttnConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%

  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);

  int tabIndex = 1;
  int extDocCount = 0;
  // PAGE MODE LOGIC BEGIN
  String pageMode = PageModeConstants.VIEW;
  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }
%>

<%
  String modifyDisabled = "false";
  CINV23SO ExtDocList = (CINV23SO) state.getAttribute("CINV23SO", request);
  ROWCINV23SOG00_ARRAY ExtDocArray = new ROWCINV23SOG00_ARRAY();
  if (ExtDocList == null) {
    ExtDocList = new CINV23SO();
  }
  if (ExtDocList.getROWCINV23SOG00_ARRAY() != null) {
    ExtDocArray = ExtDocList.getROWCINV23SOG00_ARRAY();
  }
  Enumeration ExtDocEnum = ExtDocArray.enumerateROWCINV23SOG00();

  ROWCINV23SOG00 ExtDocDetail = (ROWCINV23SOG00) request.getAttribute("ExtDocDetail");
  boolean bDeleteButton;
  boolean bAddButton;
  if (pageMode.equals(PageModeConstants.VIEW)) {
    bDeleteButton = true;
    bAddButton = true;
  } else {
    bDeleteButton = false;
    bAddButton = false;
  }
  //Get Stage Closed Ind and Stage Closed Date
  boolean stageClosed = (Boolean)state.getAttribute("stageClosed", request);
  Date stageClosureDate = (Date)state.getAttribute("stageClosureDate", request);
  //Disabling Radio button for External Documents added prior to the stage closure.
  Date weekAfterStageClosed = null;
 
  if (stageClosed){
     bDeleteButton = true;
  }
  //Redisplay the search criteria while sorting
  CINV23SI cinv23si = (CINV23SI) state.getAttribute("CINV23SI", request);
  List<String> checkedAdoList = new ArrayList<String>();
  List<String> checkedCaseDataList = new ArrayList<String>();
  List<String> checkedCrtLegalList = new ArrayList<String>();
  List<String> checkedFstAdoHmList = new ArrayList<String>();
  List<String> checkedHlthList = new ArrayList<String>();
  List<String> checkedPrsnList = new ArrayList<String>();
  List<String> checkedOthList = new ArrayList<String>();
  String dtScrSearchDateFrom = "";
  String dtScrSearchDateTo = "";
  String txtSzCdExtDocSort = "";
  String txtSzTxtExtDocLocation = "";
  String cbxICPCDocument = "";
  //Check if the sort button is pressed so that the search parameters will be filled from state SI object
  if (cinv23si != null && ArchitectureConstants.Y.equals(cinv23si.getBIndSort())){
    dtScrSearchDateFrom = FormattingHelper.formatDate(cinv23si.getDtScrSearchDateFrom());
    dtScrSearchDateTo = FormattingHelper.formatDate(cinv23si.getDtScrSearchDateTo());
    txtSzCdExtDocSort = cinv23si.getSzCdExtDocSort();
    cbxICPCDocument = cinv23si.getBIndICPCDoc();
    txtSzTxtExtDocLocation = cinv23si.getSzTxtExtDocLocation();
    ROWCINV23SI01_ARRAY rowCinv23si01Array = cinv23si.getROWCINV23SI01_ARRAY();
    for (int i=0; i < rowCinv23si01Array.getUlRowQty(); i++){
	   	ROWCINV23SI01 rowCinv23si01 = rowCinv23si01Array.getROWCINV23SI01(i);
	   	if(CodesTables.CEXDOCLA_AI.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedAdoList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_CD.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedCaseDataList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_CI.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedCrtLegalList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_FA.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedFstAdoHmList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_HI.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedHlthList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_PI.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedPrsnList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_XX.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedOthList.add(rowCinv23si01.getSzCdExtDocType());
	   	}
    }
  }else {
	  //Declare Constants and initialize Page Variables
	  int loopCount = 0;
	  int ulIdStage = GlobalData.getUlIdStage( request );
	  dtScrSearchDateFrom = FormattingHelper.formatDate(
	          ContextHelper.getCastorDateSafe( request, "dtScrSearchDateFrom" ) );
	  dtScrSearchDateTo = FormattingHelper.formatDate(
	          ContextHelper.getCastorDateSafe( request, "dtScrSearchDateTo" ) );
	  txtSzCdExtDocSort = ContextHelper.getStringSafe( request, "txtSzCdExtDocSortInList" );
	  checkedAdoList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxAdoInfo"));
	  checkedCaseDataList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxCaseData"));
	  checkedCrtLegalList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxCrtLegalInfo"));
	  checkedFstAdoHmList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxFstAdoHmInfo"));
	  checkedHlthList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxHlthInfo"));
	  checkedPrsnList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxPrsnInfo"));
	  checkedOthList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxOth")); 
	  txtSzTxtExtDocLocation = ContextHelper.getStringSafe( request, "txtSzTxtExtDocLocation" );
	  cbxICPCDocument =  CheckboxHelper.getCheckboxValue( request, "cbxICPCDocument" );
  }
%>
<script type="text/javascript" language="JavaScript1.2">

  rbSelected = new Boolean(false);

  function displayExtDocDetail(idExtDoc) {
    document.frmExtDocListResults.hdnUlIdExtDoc.value = idExtDoc;
    submitValidateForm("frmExtDocListResults", "/multipart/ExternalDcmnttn/displayExtDocDetail");
  }

  function confirmDelete() {
    if (rbSelected) {
      //disableValidation("frmExtDocList");
      //submitValidateForm("frmExtDocList", "/multipart/ExternalDcmnttn/saveExtDocDetail");
      return confirm("<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>")
    } else {
      //return true so CustomValidation can handle that a row wasn't selected
      return true;
    }
  }
  function checkAll(field)
  {
    for (i = 0; i < field.length; i++)
	  field[i].checked = true ;
  }

  function uncheckAll(field)
  {
    for (i = 0; i < field.length; i++)
	  field[i].checked = false ;
  }
  
  checked=false;
  function checkedAll (FieldName) {
	var index = 1;
	var objCheckBoxes = document.getElementsByName(FieldName + index++);
	 if (checked == false)
          {
           checked = true
          }
        else
          {
          checked = false
          }
	while (objCheckBoxes.length > 0) {
		objCheckBoxes[0].checked = checked;
		objCheckBoxes = document.getElementsByName(FieldName + index++);
	}
  }

  function SetAllCheckBoxes(FieldName, CheckValue)
  {
	var inputElements=document.getElementsByTagName("input");
    for(var i = 0, inp; inp = inputElements[i]; i++){
      if(inp.type.toLowerCase() == 'checkbox' && inp.name.indexOf(FieldName) == 0){
         inp.checked = CheckValue;
      }
    }
  }
  
  function stayHere() {

  var vertScroll = document.body.scrollTop
  document.body.scrollTop = vertScroll;
  }

</script>

<impact:validateErrors/>

<impact:validateForm name="frmExtDocList"
                     method="post"
                     action="/multipart/ExternalDcmnttn/saveExtDocDetail"
                     pageMode="<%=PageMode.getPageMode(request)%>"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.multipart.ExternalDcmnttnCustomValidation"
                     schema="/WEB-INF/Constraints.xsd">

  <!-- Hidden Fields -->
  <impact:validateInput type="hidden" name="hdnPageName" value="ExtDocList"/>
  <impact:validateInput type="hidden" name="hdnUlIdExtDoc" value="-1"/>
  <impact:ExpandableSectionTag name="ExtDocSearch"
                             id="ctSearchOpen" label="External Documentation Search" tabIndex="<%=tabIndex++%>">

<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr class="subDetail">
    <th colspan="4">Search Parameters</th>
  </tr>
  <tr class="subDetail">
    <td class="formlabel">
      <impact:validateDate label="Date From"
                           constraint="Date"
                           name="dtScrSearchDateFrom"
                           disabled="false"
                           value="<%= dtScrSearchDateFrom %>"
                           conditionallyRequired="true"
                           size="8"
                           tabIndex="<%=tabIndex++%>"
                           editableMode="<%=EditableMode.ALL%>"/>
    </td>
    <td class="formlabel">
      <impact:validateDate label="Date To"
                           constraint="Date"
                           name="dtScrSearchDateTo"
                           disabled="false"
                           value="<%= dtScrSearchDateTo %>"
                           size="8"
                           tabIndex="<%=tabIndex++%>"
                           editableMode="<%=EditableMode.ALL%>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td class="formlabel">
        <impact:validateInput name="txtSzCdExtDocSortInList"
                              label="Sort Order"
                              value="<%= txtSzCdExtDocSort %>"
                              type="text"
                              cssClass="formInput"
                              size="2"
                              maxLength="2"
                              constraint="AlphaNumeric2"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%=EditableMode.ALL%>"/>
    </td>
    <td></td>
    <td></td>    
  </tr>
  <tr class="subDetail">
    <td class="formlabel">
      <impact:validateSelect name="txtSzTxtExtDocLocation"
                               label="Item Location"
                               value="<%=txtSzTxtExtDocLocation %>"
                               codesTable="CITEMLOC"
                               disabled="false"
                               tabIndex="<%= tabIndex++ %>"
                               editableMode="<%=EditableMode.ALL%>"/>
    </td>
    <td colspan="2">
      <impact:validateInput label="ICPC Document"
                            name="cbxICPCDocument"
                            type="checkbox"
                            editableMode="<%=EditableMode.ALL%>"
                            checked='<%= "Y".equals(cbxICPCDocument) ? "true" : "false" %>'
                            value='<%= cbxICPCDocument %>'
                            tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<table>
<tr>
    <th colspan="4">Document Type</th>
</tr>
<tr class="subDetail">
   <td colspan="3">
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
	      <tr>
	    	<th colspan="4">Adoption Information</th>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxAdoInfo', true);">Select All Adoption Information</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxAdoInfo', false);">Deselect All Adoption Information</a>
		    </td>
		  </tr>
	      <tr>
	       <td>
	      	  <impact:codesCheckbox 
	                name="cbxAdoInfo"
	                columns="3"
	                codesTableName="<%= CodesTables.CEXDOCAI %>"
	                disabled="false"     
	                tabIndex="<%=tabIndex++ %>" 
	                defaultCodes="<%= checkedAdoList %>"
	                editableMode="<%=EditableMode.ALL%>"
	       	  />
	       	</td>
	       </tr>
       </table>
    </td>
</tr>
<tr class="subDetail">
   <td colspan="3">
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
	      <tr>
	    	<th colspan="4">Case Data</th>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxCaseData', true);">Select All Case Data</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxCaseData', false);">Deselect All Case Data</a>
		    </td>
		  </tr>		  
	      <tr>
	       <td>
	      	  <impact:codesCheckbox 
	                name="cbxCaseData"
	                columns="3"
	                codesTableName="<%= CodesTables.CEXDOCCD %>"
	                disabled="false"     
	                tabIndex="<%=tabIndex++ %>"
	                defaultCodes="<%= checkedCaseDataList %>"
	                editableMode="<%=EditableMode.ALL%>" 
	       	  />
	       	</td>
	       </tr>
       </table>
    </td>
</tr>
<tr class="subDetail">
   <td colspan="3">
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
	      <tr>
	    	<th colspan="4">Court/Legal Information</th>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxCrtLegalInfo', true);">Select All Court/Legal Information</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxCrtLegalInfo', false);">Deselect All Court/Legal Information</a>
		    </td>
		  </tr>		  
	      <tr>
	       <td>
	      	  <impact:codesCheckbox 
	                name="cbxCrtLegalInfo"
	                columns="3"
	                codesTableName="<%= CodesTables.CEXDOCCL %>"
	                disabled="false"     
	                tabIndex="<%=tabIndex++ %>"
	                defaultCodes="<%= checkedCrtLegalList %>"
	                editableMode="<%=EditableMode.ALL%>" 
	       	  />
	       	</td>
	       </tr>
       </table>
    </td>
</tr>

<tr class="subDetail">
   <td colspan="3">
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
	      <tr>
	    	<th colspan="4">Foster/Adoptive Home Information</th>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxFstAdoHmInfo', true);">Select All Foster/Adoptive Home Information</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxFstAdoHmInfo', false);">Deselect All Foster/Adoptive Home Information</a>
		    </td>
		  </tr>		  
	      <tr>
	       <td>
	      	  <impact:codesCheckbox 
	                name="cbxFstAdoHmInfo"
	                columns="3"
	                codesTableName="<%= CodesTables.CEXDOCFA %>"
	                disabled="false"     
	                tabIndex="<%=tabIndex++ %>"
	                defaultCodes="<%= checkedFstAdoHmList %>"
	                editableMode="<%=EditableMode.ALL%>" 
	       	  />
	       	</td>
	       </tr>
       </table>
    </td>
</tr>

<tr class="subDetail">
   <td colspan="3">
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
	      <tr>
	    	<th colspan="4">Health Information</th>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxHlthInfo', true);">Select All Health Information</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxHlthInfo', false);">Deselect All Health Information</a>
		    </td>
		  </tr>		  
	      <tr>
	       <td>
	      	  <impact:codesCheckbox 
	                name="cbxHlthInfo"
	                columns="3"
	                codesTableName="<%= CodesTables.CEXDOCHI %>"
	                disabled="false"     
	                tabIndex="<%=tabIndex++ %>" 
	                defaultCodes="<%= checkedHlthList %>"
	                editableMode="<%=EditableMode.ALL%>"
	       	  />
	       	</td>
	       </tr>
       </table>
    </td>
</tr>

<tr class="subDetail">
   <td colspan="3">
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
	      <tr>
	    	<th colspan="4">Person Information</th>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxPrsnInfo', true);">Select All Person Information</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxPrsnInfo', false);">Deselect All Person Information</a>
		    </td>
		  </tr>		  
	      <tr>
	       <td>
	      	  <impact:codesCheckbox 
	                name="cbxPrsnInfo"
	                columns="3"
	                codesTableName="<%= CodesTables.CEXDOCPI %>"
	                disabled="false"     
	                tabIndex="<%=tabIndex++ %>"
	                defaultCodes="<%= checkedPrsnList %>"
	                editableMode="<%=EditableMode.ALL%>" 
	       	  />
	       	</td>
	       </tr>
       </table>
    </td>
</tr>

<tr class="subDetail">
   <td colspan="3">
      <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
	      <tr>
	    	<th colspan="4">Other</th>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxOth', true);">Select All Other Information</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a href="javascript:stayHere()" tabIndex="<%=tabIndex++%>" onClick="SetAllCheckBoxes('cbxOth', false);">Deselect All Other Information</a>
		    </td>
		  </tr>		  
	      <tr>
	       <td>
	      	  <impact:codesCheckbox 
	                name="cbxOth"
	                columns="3"
	                codesTableName="<%= CodesTables.CEXDOCXX %>"
	                disabled="false"     
	                tabIndex="<%=tabIndex++ %>" 
	                defaultCodes="<%= checkedOthList %>"
	                editableMode="<%=EditableMode.ALL%>"
	       	  />
	       	</td>
	       </tr>
       </table>
    </td>
</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
  <tr>
     <th colspan="4">Search By Persons Associated to External Documentation</th>
  </tr>
  <tr class="subDetail">
  <tr> 
    <th colspan ="4" class="thList" width="20%">Names</th>
  </tr>
  <tr>
  <td width="100%" class="formlabel">
    <div id="scroll3" style="width:100%; height:125px; overflow:auto" class="tableBorder">
     <table width="100%" border="0" cellspacing="0" cellpadding="3">
  
      <tr>
          <%
            ROWCINV23SOG01_ARRAY rowcin23soArray = ExtDocList.getROWCINV23SOG01_ARRAY();
            if( rowcin23soArray == null )
            {
              rowcin23soArray = new ROWCINV23SOG01_ARRAY();
            }

            Enumeration cinv23soEnumeration = rowcin23soArray.enumerateROWCINV23SOG01();

            if( !cinv23soEnumeration.hasMoreElements() )
            {
          %>
          <tr class="odd">
            <td colspan="4">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
          </tr>
      <tr>
          <%
          }
          else
          {
            String checkedVal = "false";
            int i = 0;
            while( cinv23soEnumeration.hasMoreElements() )
            {
              ROWCINV23SOG01 cinv23soRow = (ROWCINV23SOG01)cinv23soEnumeration.nextElement();
              checkedVal = cinv23soRow.getCSysIndNameChecked() != null ? (cinv23soRow.getCSysIndNameChecked() == "Y" ? "true":"false"):"false";
              if( i % 2 == 0 )
              {
                out.println( "<tr class=\"subDetail\">" );
              }
              else
              {
                out.println( "<tr class=\"altcolor\">" );
              }
              
              // do not add a <tr> here plz they are genereated in the code above
              state.setAttribute("savedExtDocPerson", ExtDocList.getROWCINV23SOG01_ARRAY(), request);
          %>
         <%String cbxName = "cbxUlIdPersons" + ( i + 1 );
          String indPersonChecked = "false";
         %> 	 	
          <td><impact:validateInput
                  tabIndex="<%= tabIndex++ %>"
                  type="checkbox"
                  value='<%= String.valueOf(cinv23soRow.getUlIdPerson()) %>'
                  name="<%= cbxName %>"
                  disabled="<%= modifyDisabled %>"
                  editableMode="<%= EditableMode.ALL %>"
                  checked = "<%= checkedVal %>" />
				  
            <%= FormattingHelper.formatString( cinv23soRow.getSzNmPersonFull() ) %>
          </td>
     </tr>
        <%
          i++;
           }
          }
        %>
     </table>
    </div>
  </td>
 </tr>
 <tr>
 </tr>
</table>

<table width="100%" cellpadding="3" border="0" cellspacing="0">
      <tr>
        <td>
			<impact:ButtonTag name="btnSearch"
                  img="btnSearch"
                  form="frmExtDocList"
                  action="/multipart/ExternalDcmnttn/displayExtDocList"
                  align="right"
                  editableMode="<%= EditableMode.ALL %>"
                  tabIndex="<%= tabIndex++ %>"/>
		</td>
      </tr>
</table>
</impact:ExpandableSectionTag>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
<br>
<impact:validateForm name="frmExtDocListResults"
                     method="post"
                     action="/multipart/ExternalDcmnttn/displayExtDocList"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.multipart.ExternalDcmnttnCustomValidation"
                     pageMode="<%=PageMode.getPageMode(request)%>"
                     schema="/WEB-INF/Constraints.xsd">

  <impact:pagination submitUrl="/multipart/ExternalDcmnttn/displayExtDocList" saveState="false">
  <!-- Hidden Fields -->
  <impact:validateInput type="hidden" name="hdnPageName" value="ExtDocList"/>
  <impact:validateInput type="hidden" name="hdnUlIdExtDoc" value="-1"/>
  <div id="noScrollResults" style="height:190px; width:100%; overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3">
      <tr>
        <th class="thList">&nbsp;</th>
        <th class="thList">Sort</th>
        <th class="thList">Date Obtained &nbsp;
        	<impact:sortableColumnHeader orderBy="<%=ExternalDcmnttnConversation.SORT_BY_DATE_OBTAINED%>" />
        </th>
        <th class="thList">Document Class &nbsp;
        <impact:sortableColumnHeader orderBy="<%=ExternalDcmnttnConversation.SORT_BY_DOC_CLASS%>" />
        </th>
        <th class="thList">Document Type &nbsp;
        	<impact:sortableColumnHeader orderBy="<%=ExternalDcmnttnConversation.SORT_BY_DOC_TYPE%>" />
        </th>
        <th class="thList">Item Location
        </th>
        <th class="thList" width="10%">Comments</th>
      </tr>
      <%
      
         if( !ExtDocEnum.hasMoreElements() )
            {
      %>
          <tr class="odd">
            <td colspan="4">
              <%= MessageLookup.getMessageByNumber( Messages.MSG_SVC_NO_EXT_DOC_MATCH ) %>
            </td>
          </tr>
      	<tr>
          <%
      		} else {
		        while (ExtDocEnum.hasMoreElements()) {
		          ExtDocDetail = (ROWCINV23SOG00) ExtDocEnum.nextElement();
		          String rowCss = FormattingHelper.getRowCss(extDocCount + 1);
		          String CommentSubstring = "";
                  String Comment = FormattingHelper.formatString(ExtDocDetail.getSzTxtExtDocDetails());
              if(Comment.length() > 35 )  {
               CommentSubstring = Comment.substring( 0, 35 );
              }
              else{
              CommentSubstring = Comment;
              }
      %>
      <tr class="<%=rowCss%>">
        <td width="5%">
          <% if (pageMode.equals(PageModeConstants.VIEW)) {
          %>
          <impact:validateInput
                  type="radio"
                  name="rbExtDoc"
                  value="<%= String.valueOf( ExtDocDetail.getUlIdExtSitInfo() ) %>"
                  onClick="javascript:rbSelected=true;"
                  disabled="true"
                  tabIndex="<%= tabIndex++ %>"/>
          <%} else {%>
          <impact:validateInput
                  type="radio"
                  name="rbExtDoc"
                  value="<%= String.valueOf( ExtDocDetail.getUlIdExtSitInfo() ) %>"
                  onClick="javascript:rbSelected=true;"
                  tabIndex="<%= tabIndex++ %>"/>
          <%
            }
          %></td>
        <td><%= FormattingHelper.formatString(ExtDocDetail.getSzCdExtDocSort()) %>
        </td>
        <td><%= FormattingHelper.formatDate(ExtDocDetail.getDtDtExtDocObtained()) %>
        </td>
        <td><%= ExtDocDetail.getSzCdDocClass() != null ?
                Lookup.simpleDecodeSafe("CEXDOCLA", ExtDocDetail.getSzCdDocClass()) : "&nbsp;" %>
        </td>
        <td><a href="#" tabIndex="<%=tabIndex++%>" onClick="displayExtDocDetail(<%= extDocCount++ %>);"><%=
        Lookup.simpleDecodeSafe("CEXDOTYP", ExtDocDetail.getSzCdExtDocType()) %>
        </a></td>
        <td><%= ExtDocDetail.getSzTxtExtDocLocation() != null ?
                Lookup.simpleDecodeSafe("CITEMLOC", ExtDocDetail.getSzTxtExtDocLocation()) : "&nbsp;" %>
        </td>
      <td><%= CommentSubstring %></td>
      </tr>
      <%}
        }%>
    </table>
  </div>
</impact:pagination>

<br>
<table cellspacing="0" cellPadding="3" width="100%" border="0">
  <tr>
    <td class="alignLeft">
      <% if (extDocCount > 0) { %>
      <impact:ButtonTag
              name="btnDelete"
              img="btnDelete"
              disabled="<%= String.valueOf( bDeleteButton ) %>"
              form="frmExtDocListResults"
              action="/multipart/ExternalDcmnttn/saveExtDocDetail"
              function="return confirmDelete()"
              restrictRepost="true"
              tabIndex="<%= tabIndex++ %>"
              />
      <% } else { %>
      &nbsp;
      <% } %>
    </td>
    <%
      //SIR 19201 -- If the mode is not equal to approval, the add push button will
      //be hidden.
      if (!GlobalData.isApprovalMode(request)) {
    %>
    <td class="alignRight">
      <impact:ButtonTag
              name="btnAdd"
              img="btnAdd"
              disabled="<%= String.valueOf( bAddButton ) %>"
              form="frmExtDocListResults"
              action="/multipart/ExternalDcmnttn/displayExtDocDetail"
              tabIndex="<%= tabIndex++ %>"
              />
    </td>
    <%
      }
    %>
  </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>