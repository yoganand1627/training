
<%//*  JSP Name:     ExternalDcmnttnDetail
      //*  Created by:   Rodrigo DeJuana
      //*  Date Created: 11/19/02
      //*
      //*  Description:
      //*   This page allows the user to create, modify, or delete
      //*   allegations during the Investigation stage of service.
      //*   Allegations may be created or deleted individually and
      //*   modified either individually or as a group.
      //*
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       03/25/03  Todd Reser        QA Sweep.
       04/16/03  Todd Reser        Switched to ServiceConstants.REQ_FUNC_CD_ADD, added
       Confirm Delete fuction.
       04/17/03  Todd Reser        Added Spell Check.
       04/22/03  Todd Reser        Added tabinxed to Spell Check.
       05/07/03  Todd Reser        Changed Confirm Delete message.
       06/16/03  Merle A Demo      Replaced old pageMode with newer GlobalData.getPageMode
       10/03/03  CORLEYAN        SIR 19951 This page should always be in modify mode regardless
       of the app mode
       11/28/04  Hadjimh           SIR#22839. Currently, the worker clicks the add button,
       selects one item and saves and this action takes user to
       Ext Doc List page and the actions are repeated
       for each item that is being documented. SaveAndStay
       button is added to make this task smoother.
       09/12/05  PISHARRK          SIR 23953 - MPS Phase III enhancement to display 
       Ext. Doc List/Details using EJB/DAO service(replacing existing DAMs)
       for both MPS and IMPACT  
       09/23/05  cooganpj          SIR 23966 - MPS Phase III Lockdown changes - updated to read in the page
       mode from the conversation.    
       11/05/09  pcoogan           SMS 39073 - Removed pagination tag in page causing various navigation and data loss errors
       01/30/12	 vcollooru		   STGAP00017827 MR-085 Modified to add new checkbox for marking ICPC Documents                                                        
       */%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Comparator"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.List"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  CINV23SO _cinv23so = (CINV23SO) state.getAttribute("CINV23SO", request);
  if (_cinv23so == null) {
    _cinv23so = new CINV23SO();
  }

  //Everything above this point should be in every page.
  int tabIndex = 1;
  String modifyDisabled = "false";

  ROWCINV23SOG00 ExtDocDetail2 = (ROWCINV23SOG00) request.getAttribute("ExtDocDetail");

  //Get Stage Closed Ind and Stage Closed Date
  boolean stageClosed = (Boolean) state.getAttribute("stageClosed", request);
  Date stageClosureDate = (Date) state.getAttribute("stageClosureDate", request);
  //Disabling Radio button for External Documents added prior to the stage closure.
  Date weekAfterStageClosed = (Date) state.getAttribute("weekAfterStageClosed", request);
  if (stageClosed && stageClosureDate != null) {
    weekAfterStageClosed = DateHelper.addToDate(stageClosureDate, 0, 0, 7);
  }

  // PAGE MODE LOGIC BEGIN
  String pageMode = PageModeConstants.EDIT;
  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }
  String cdDocType = "";
%>

<%
  CINV23SO ExtDocList = (CINV23SO) state.getAttribute("CINV23SO", request);
  if (ExtDocList == null) {
    ExtDocList = new CINV23SO();
  }
  ROWCINV23SOG00 ExtDocDetail = (ROWCINV23SOG00) request.getAttribute("ExtDocDetail");
  ROWCINV23SOG02 ExtDocPersonCheck = new ROWCINV23SOG02();

  String sFileName = ExtDocDetail.getSzTxtFileName();
  String hdnAUMode = (String) request.getAttribute("hdnAUMode");
  Date dtToday = new Date();
  boolean bSaveNStayButton = false;
  boolean bSaveButton = false;
  boolean bViewButton = sFileName != null && !sFileName.equalsIgnoreCase("");
  String displayViewButton = bViewButton ? "inline" : "none";

  //STGAP00017906: Default the Item Location to "Uploaded" if none present.
  String extDocLocation = ExtDocDetail.getSzTxtExtDocLocation();
  if (("").equals(extDocLocation) || extDocLocation == null) {
    extDocLocation = "UPL";
  }

  if (pageMode.equals(PageModeConstants.VIEW)) {
    bSaveNStayButton = true;
    bSaveButton = true;
  }
  
  String bDelete = ServiceConstants.REQ_FUNC_CD_ADD.equals(hdnAUMode) ? "true" : "false";

  Date weekAfterDocAdded = new Date();

  if (stageClosed && stageClosureDate != null) {
    weekAfterDocAdded = DateHelper.addToDate(DateHelper.toJavaDate(ExtDocDetail.getDtDtExtDocAdded()), 0, 0, 7);
    bDelete = "true";
    if (DateHelper.isBefore(new Date(), weekAfterDocAdded)) {
      bSaveNStayButton = false;
      bSaveButton = false;
    } else {
      bSaveNStayButton = true;
      bSaveButton = true;
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    }
  }
%>
<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>

<script type="text/javascript" language="JavaScript1.2">
  window.onbeforeunload = function() {
    IsDirty();
  };
  
  window.onload = function ()
  {
   	updateForViewButton();
   	updateCodeType();
  };
  
  function confirmDelete() {
    disableValidation("frmExtDocDetail");
    return confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>")
  }

  function confirmUpload() {
  	if(fileSelected()){
  		if(testFileExtension('SAVE')){
  			if(<%=ExtDocDetail.getSzTxtFileName().length() > 0%>){
		    	return confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_EXT_DOC_UPLOAD_CONFIRM)%>");
		    }
		} 
		else {
		    return false;
		}
	 }
	 return true;
  }
  
  function fileSelected(){
  	var filename = document.frmExtDocDetail.txttSzTxtExtFile.value;
  	return filename.length>0;
  }
  

  function viewFile() {
  <%
     String ulIdExtDoc = URLHelper.encode(String.valueOf(ExtDocDetail.getUlIdExtSitInfo()));
     String fileName = URLHelper.encode(String.valueOf(ExtDocDetail.getSzTxtFileName()));
     String fileType = URLHelper.encode(String.valueOf(ExtDocDetail.getSzTxtFormatType()));
   %>
    window.open('/multipart/ExternalDcmnttn/viewExtDoc?UlIdExtDoc=<%=ulIdExtDoc%>&fileName=<%=fileName%>&fileType=<%=fileType%>', 'ViewFile', 'toolbar=no,location=no,scrollbars=auto,resizable=yes');
  }

  function testFileExtension(calledFrom) {
    var correctType = false;
    var filename = document.frmExtDocDetail.txttSzTxtExtFile.value;
    if (filename.length > 0) {
      var indexOf = filename.indexOf('.');
      var dotIndex = filename.length-4;
      if(indexOf != dotIndex){
      	indexOf = dotIndex;
      }
      if (indexOf != -1) {
        var start = indexOf + 1;
        var ext = filename.substr(start, filename.length);
        ext = ext.toLowerCase();
        if (calledFrom == "BROWSE"){
        	alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_EXT_DOC_UPLOAD_WARN)%>");
        }
       if ('jpg' == ext || 'pdf' == ext || 'jpeg' == ext) {
          correctType = true;
        }
        else {
          alert("Uploads can only be Pictures .jpg or Adobe PDFs .pdf files");
        }
      }
      else {
        alert("Uploads can only be Pictures .jpg or Adobe PDFs .pdf files");
      }
    }
    else {
      alert("Please enter a filename");
      correctType = false;
    }
<!--    if(correctType){-->
<!--	}-->

    return correctType;
  }
  
  function updateForViewButton()
  {
  	var displayView = '<%=displayViewButton%>';
  	btnViewSpanId.style.display=displayView;
  }
  
 
  //Get county code/decode array filtered for Adoptions Information
  <impact:codeArray codeName="CEXDOCAI" arrayName="CEXDOCAI" blankValue="true"/>
  //Get county code/decode array filtered for Case Data
  <impact:codeArray codeName="CEXDOCCD" arrayName="CEXDOCCD" blankValue="true"/>
  //Get county code/decode array filtered for Court/Legal Information
  <impact:codeArray codeName="CEXDOCCL" arrayName="CEXDOCCL" blankValue="true"/>  
  //Get county code/decode array filtered for Foster/Adoptive Home Information
  <impact:codeArray codeName="CEXDOCFA" arrayName="CEXDOCFA" blankValue="true"/>
  //Get county code/decode array filtered for Home Information
  <impact:codeArray codeName="CEXDOCHI" arrayName="CEXDOCHI" blankValue="true"/>
  //Get county code/decode array filtered for Person Information
  <impact:codeArray codeName="CEXDOCPI" arrayName="CEXDOCPI" blankValue="true"/>
  //Get county code/decode array filtered for Other
  <impact:codeArray codeName="CEXDOCXX" arrayName="CEXDOCXX" blankValue="true"/>
  //Get county code/decode array filtered for Other
  <impact:codeArray codeName="CEXDORST" arrayName="CEXDORST" blankValue="true"/>
  <impact:codeArray codeName="CEXDORST" arrayName="CEXDOTYP" blankValue="true"/>
  
  function filterDocumentType()
  {
    var DocClassFilter = document.frmExtDocDetail.selSzcdDocClass.value;
   if ( DocClassFilter == "" )
   {
      clearDropdown( frmExtDocDetail.selSzCdExtDocType );
   }
   else
    {
     if(frmExtDocDetail.selSzcdDocClass.value == "AI")
     {
     populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCAI);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "CD")
    {
     populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCCD);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "CI")
    {
     populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCCL);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "FA")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCFA);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "HI")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCHI);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "PI")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCPI);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "XX")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCXX);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "CH")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDORST);
    }
 }
 }
 
 function updateCodeType()
{
var DocClass = frmExtDocDetail.selSzcdDocClass.value;
var DocType = frmExtDocDetail.selSzCdExtDocType.value;
if(DocType==""){
//New mode so do not need to filter the document type dropdown
populateDropdown( frmExtDocDetail.selSzCdExtDocType , "", CEXDOTYP );
}else
    {
     if(frmExtDocDetail.selSzcdDocClass.value == "AI")
     {
     populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCAI);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "CD")
    {
     populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCCD);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "CI")
    {
     populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCCL);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "FA")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCFA);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "HI")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCHI);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "PI")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCPI);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "XX")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDOCXX);
    }else if(frmExtDocDetail.selSzcdDocClass.value == "CH")
    {
    populateDropdown(frmExtDocDetail.selSzCdExtDocType , "", CEXDORST);
    }
    document.frmExtDocDetail.selSzCdExtDocType.value=DocType;
 }
}

 
</script>

<impact:validateErrors />

<impact:validateForm name="frmExtDocDetail" method="post"
	action="/multipart/ExternalDcmnttn/saveExtDocDetail"
	pageMode="<%=PageMode.getPageMode(request)%>"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.multipart.ExternalDcmnttnCustomValidation"
	schema="/WEB-INF/Constraints.xsd" encType="multipart/form-data">


	<!-- Hidden Fields -->
	<impact:validateInput type="hidden" name="hdnPageName"
		value="ExtDocDetail" />
	<impact:validateInput type="hidden" name="hdnUlIdExtSitInfo"
		value="<%=String.valueOf(ExtDocDetail.getUlIdExtSitInfo())%>" />
	<impact:validateInput type="hidden" name="hdnSzTxtFileName"
		value="Winter.jpg" />
	<impact:validateInput type="hidden" name="hdnDtDtCaseOpened"
		value="<%=FormattingHelper.formatDate(ExtDocList.getDtDtCaseOpened())%>" />
    <impact:validateInput type="hidden" name="hdnDtDtExtDocAdded"
		value="<%=FormattingHelper.formatDate(ExtDocDetail.getDtDtExtDocAdded())%>" />
	<impact:validateInput type="hidden" name="hdnAUMode"
		value="<%=hdnAUMode%>" />

	<!--- Begin Detail Table --->
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="6">
				&nbsp;
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="txtDtDtExtDocObtained"
					label="Date Obtained" constraint="Date"
					value="<%=FormattingHelper.formatDate(ExtDocDetail.getDtDtExtDocObtained())%>"
					required="true" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateInput name="txtSzCdExtDocSort" label="Sort Order"
					value="<%=ExtDocDetail.getSzCdExtDocSort() != null ? ExtDocDetail.getSzCdExtDocSort() : ""%>"
					type="text" cssClass="formInput" size="2" maxLength="2"
					constraint="AlphaNumeric2" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect name="selSzcdDocClass" label="Document Class"
					required="true" blankValue="true"
					value="<%=ExtDocDetail.getSzCdDocClass()%>"
					codesTable="<%=CodesTables.CEXDOCLA%>"
					onChange="filterDocumentType();" tabIndex="<%=tabIndex++%>" />
			</td>

			<td>
				<impact:validateDisplayOnlyField name="txtDtDtExtDocUploaded"
					label="Upload Date"
					value="<%=FormattingHelper.formatDate(ExtDocDetail.getDtExtDocUploaded())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect name="selSzCdExtDocType" label="Type"
					required="true" value="<%=ExtDocDetail.getSzCdExtDocType()%>"
					valueType="<%=SelectTag.CODES%>"
					contentType="<%=SelectTag.DECODES%>"
					onChange="updateCodeType();"
					codesTable="<%=CodesTables.CEXDOTYP%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<!-- STGAP00017827: Added the checkbox for marking ICPC Document -->
			<td>
				<impact:validateInput name="selIndICPCDoc" label="ICPC Document"
					tabIndex="<%=tabIndex++%>" value="N"
					checked="<%="Y".equals(ExtDocDetail.getBIndICPCDoc()) ? "true" : "false"%>"
					type="checkbox" cssClass="formInput" />
			</td>
		</tr>
		<tr>

			<td>
				<impact:validateSelect name="txttSzTxtExtDocLocation"
					label="Item Location"
					value="<%=extDocLocation%>" required="true"
					codesTable="CITEMLOC" tabIndex="<%=tabIndex++%>"
					blankValue="<%=Lookup.simpleDecodeSafe("CITEMLOC", "CAS")%>" />
			</td>
			<td>
				<impact:validateInput name="selIndSigned" label="Signed?"
					tabIndex="<%=tabIndex++%>" value="N"
					checked="<%="Y".equals(ExtDocDetail.getBIndExtDocSigned()) ? "true" : "false"%>"
					type="checkbox" cssClass="formInput" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea name="txtaSzTxtExtDocDetails"
					label="Details" conditionallyRequired="true" colspan="3"
					maxLength="300" rows="4" cols="80" tabIndex="<%=tabIndex++%>">
					<%=FormattingHelper.formatString(ExtDocDetail.getSzTxtExtDocDetails())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="txtSzAttachFile"
					label="Attach File" />
				<input name="txttSzTxtExtFile" type="file" size="30"
					onchange="testFileExtension('BROWSE');" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="txtDtDtExtDocFileName"
					label="File Name"
					value="<%=FormattingHelper.formatString(ExtDocDetail.getSzTxtFileName())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="txtDtDtExtDocFileType"
					label="File Type"
					value="<%=FormattingHelper.formatString((String) state.getAttribute("txtFileType", request))%>" />
			</td>
		</tr>
	</table>


	<table width="100%" border="0" cellspacing="0" cellpadding="3"
		class="tableBorder">
		<tr>
			<th colspan="4">
				<font class='formRequiredText'> *</font>Persons
			</th>
		</tr>
		<tr>
			<th colspan="4" class="thList" width="20%">
				Names
			</th>
		</tr>
		<tr>
		<td width="100%" class="formlabel">
			<div id="scroll3" style="width: 100%; height: 125px; overflow: auto"
				class="tableBorder">
				<table width="100%" border="0" cellspacing="0" cellpadding="3">

					<tr>
						<td>
							<impact:validateInput name="selIndNaChecked" label="N/A"
								tabIndex="<%=tabIndex++%>" value="N"
								checked="<%="Y".equals(ExtDocDetail.getBIndNaChecked()) ? "true" : "false"%>"
								type="checkbox" cssClass="formInput" />
						</td>
						<%
            ROWCINV23SOG01_ARRAY rowcin23soArray = ExtDocList.getROWCINV23SOG01_ARRAY();
              if (rowcin23soArray == null) {
                rowcin23soArray = new ROWCINV23SOG01_ARRAY();
              }

              Enumeration<ROWCINV23SOG01> cinv23soEnumeration = rowcin23soArray.enumerateROWCINV23SOG01();

              if (!cinv23soEnumeration.hasMoreElements()) {
          %>
					
					<tr class="odd">
						<td colspan="4">
							<%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
						</td>
					</tr>
					<tr>
						<%
            } else {
                int i = 0;
                while (cinv23soEnumeration.hasMoreElements()) {
                  ROWCINV23SOG01 cinv23soRow = (ROWCINV23SOG01) cinv23soEnumeration.nextElement();
                  if (i % 2 == 0) {
                    out.println("<tr class=\"altcolor\">");
                  } else {
                    out.println("<tr class=\"subDetail\">");
                  }

                  // do not add a <tr> here plz they are genereated in the code above
                  state.setAttribute("savedExtDocPerson", _cinv23so.getROWCINV23SOG01_ARRAY(), request);
          %>
						<%
             String cbxName = "cbxUlIdPerson" + (i + 1);
                   String indPersonChecked = "false";

                   ROWCINV23SOG02_ARRAY rowPerCheckArray = ExtDocDetail.getROWCINV23SOG02_ARRAY();
                   if (rowPerCheckArray == null) {
                     rowPerCheckArray = new ROWCINV23SOG02_ARRAY();
                   }

                   Enumeration<ROWCINV23SOG02> perCheckEnumeration = rowPerCheckArray.enumerateROWCINV23SOG02();

                   while (perCheckEnumeration.hasMoreElements()) {
                     ROWCINV23SOG02 rowPerCheckso = (ROWCINV23SOG02) perCheckEnumeration.nextElement();
                     if (rowPerCheckso.getUlIdPerson() == cinv23soRow.getUlIdPerson()) {
                       indPersonChecked = "true";
                     }
                   }
           %>
						<td>
							<impact:validateInput tabIndex="<%=tabIndex++%>" type="checkbox"
								checked="<%=indPersonChecked%>" value='<%=String.valueOf(i)%>'
								name="<%=cbxName%>" disabled="<%=modifyDisabled%>"
								editableMode="<%=EditableMode.DEFAULT%>" />

							<%=FormattingHelper.formatString(cinv23soRow.getSzNmPersonFull())%>
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
	<br>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td width="85%">
				<impact:ButtonTag name="btnDelete" img="btnDelete"
					function="return confirmDelete()" form="frmExtDocDetail"
					action="/multipart/ExternalDcmnttn/saveExtDocDetail"
					restrictRepost="true" disabled="<%=bDelete%>"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<td align="right">
				<span id="btnViewSpanId" style='display: "'> <impact:ButtonTag
						name="btnView" img="btnView"
						disabled="<%=String.valueOf(!bViewButton)%>"
						action="/multipart/ExternalDcmnttn/displayExtDocDetail"
						form="frmExtDocDetail" function="viewFile();"
						restrictRepost="true" editableMode="<%=EditableMode.ALL%>"
						tabIndex="<%=tabIndex++%>" />
				</span>
			</td>


			<td>
				<!--- SIR#22839 --->
				<impact:ButtonTag name="btnSaveAndStay" img="btnSaveAndStay"
					disabled="<%=String.valueOf(bSaveNStayButton)%>"
					form="frmExtDocDetail"
					action="/multipart/ExternalDcmnttn/saveExtDocDetail"
					restrictRepost="true" tabIndex="<%=tabIndex++%>" />
			</td>

			<td align="right" width="10%">
				<%
        if (!pageMode.equals(PageModeConstants.VIEW)) {
      %>
				<impact:spellCheck formToSpellCheck="frmExtDocDetail"
					fieldsToSpellCheck="txtaSzTxtExtDocDetails"
					tabIndex="<%=tabIndex++%>" />
				<%
        }
      %>
			</td>
			<td align="right" width="5%">
				<impact:ButtonTag name="btnSave" img="btnSave"
					disabled="<%=String.valueOf(bSaveButton)%>" form="frmExtDocDetail"
					function="return confirmUpload();"
					action="/multipart/ExternalDcmnttn/saveExtDocDetail"
					restrictRepost="true" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<!--- End Detail Table --->

	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

