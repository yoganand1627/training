<%
/**
 * JSP Name:     ResourceDetail.jsp
 * Created by:   Habib
 * Date Created: 07/30/02
 *
 * Description:
 * The Resource Detail page will display detailed information for the resource
 * selected on the Resource Search Results page. The page will be divided into
 * four sections: Resource Detail, Address List, Phone List, and Subcontractor
 * List. The last three sections are expandable and will be hidden until the
 * corresponding bar is clicked.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  08/29/03  Eric Dickman      Moved the Save Push Button to the bottom of the page
                              and added a HR.
  08/29/03  Eric Dickman      Added a MaxLength of 300 to the comments box and aligned
                              Type field in the Phone List and Address List.
  03/19/04  Linda Reed        SIR 22639 - added Resource LEGAL NAME field.
  07/01/05  piazzat           Changes to support MPS
  08/03/05  floresrj      SIR 23859 - added width 80 to phone comments header column;
                              Added a separate div tag to the expandable address list for 
                              impact, and changing the width to 764px
  08/12/05  floresrj          SIR 23808 Comments column in address and phone expandable
                              sections should not be visible.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceDetailConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  String RSRC_TYPE_SCHOOL = "04";
  String RSRC_TYPE_MHMR   = "05";
  String RSRC_TYPE_OTHER  = "06";

  //String FAC_TYPE_CPA = "60";
  String FAC_TYPE_FAH = "70";
  String FAC_TYPE_PAA = "71";

  //String TRACE_TAG = "ResourceDetail.jsp";
  String includingFormName = "frmResourceDetail";
  String classResource = "false";
  String fadResource = "false";
  //SR- String schoolResource = "false";

  //Page state variables
  String resourceNameDisabled = "false";
  String legalNameDisabled = "false";
  String statusDisabled = "false";
  String ownershipDisabled = "false";
  String campusTypeDisabled = "false";
  String maintainerDisabled = "false";
  String contactDisabled = "false";
  String facilityTypeDisabled = "false";
  String hubDisabled = "false";
  String mhmrDisabled = "false";
  String transportDisabled = "false";
  String nationalProviderNumberDisabled= "false";
  String emailAddressDisabled= "false";
  String webAddressDisabled="false";
  
  
  boolean facilityDetailButtonHide = false;
  boolean saveResourceButtonHide = false;
  boolean addAddressButtonHide = false;
  boolean deleteAddressButtonHide = false;
  boolean addPhoneButtonHide = false;
  boolean deletePhoneButtonHide = false;
  boolean addOrsFacButtonHide = true;
  boolean deleteOrsFacButtonHide = true;
  String transport = "false";
  String prime = "false";
  String sub = "false";
  ROWCRES03SOG00_ARRAY addressArray = null;
  ROWCRES03SOG01_ARRAY phoneArray = null;
  ROWCRES03SOG02_ARRAY orsFacArray = null;
 
BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );//SR-
CRES03SO cres03so = (CRES03SO) state.getAttribute( ResourceDetailConversation.CRES03SO_ATTRIBUTE_NAME, request);//SR-
if ( cres03so == null )
{
  cres03so = new CRES03SO();
}

    if( "1".equals( cres03so.getCIndRsrcTransport() ) )
    {
      transport = "true";
    }
    if( "Y".equals( cres03so.getCScrIndRsrcPrime() ) )
    {
      prime = "true";
    }
    if( "Y".equals( cres03so.getCScrIndRsrcSub() ) )
    {
      sub = "true";
    }
    addressArray = cres03so.getROWCRES03SOG00_ARRAY();
    phoneArray = cres03so.getROWCRES03SOG01_ARRAY();
    orsFacArray = cres03so.getROWCRES03SOG02_ARRAY();
    
  // Get the pageMode.	
  String pageMode = PageMode.getPageMode(request);

  if( PageModeConstants.VIEW.equals( pageMode ) )
  {
    saveResourceButtonHide = true;
    addAddressButtonHide = true;
    deleteAddressButtonHide = true;
    addPhoneButtonHide = true;
    deletePhoneButtonHide = true;
  }
  // If resource type is MHMR
  if( RSRC_TYPE_MHMR.equals( cres03so.getSzCdRsrcType() ) )
  {
    //SR- mhmrResource = "true";
    campusTypeDisabled = "true";
  }
  // If resource type is Other
  if( RSRC_TYPE_OTHER.equals( cres03so.getSzCdRsrcType() ) )
  {
    campusTypeDisabled = "true";
    mhmrDisabled = "true";
  }
  // If resource type is not Other or MHMR
  if( !RSRC_TYPE_OTHER.equals(cres03so.getSzCdRsrcType()) && !RSRC_TYPE_MHMR.equals(cres03so.getSzCdRsrcType()) )
  {
    campusTypeDisabled = "true";
    facilityTypeDisabled = "true";
    mhmrDisabled = "true";
    facilityDetailButtonHide = true;
  }

  // If resource type is school
  if( RSRC_TYPE_SCHOOL.equals( cres03so.getSzCdRsrcType() ) )
  {
    //SR- schoolResource = "true";
    campusTypeDisabled = "false";
  }

  // If facility type is PRS F/A Homes or Private Agency Adoptive
  String facilType = cres03so.getSzCdRsrcFacilType();
  if( FAC_TYPE_FAH.equals(facilType) || FAC_TYPE_PAA.equals(facilType) )
  {
    fadResource = "true";
    //pageMode = PageMode.VIEW;
    saveResourceButtonHide = true;
    addAddressButtonHide = true;
    deleteAddressButtonHide = true;
    addPhoneButtonHide = true;
    deletePhoneButtonHide = true;
  }

  // If it's a CLASS resource
  if( cres03so.getLNbrRsrcFacilAcclaim() != 0 )
  {
    classResource = "true";
    resourceNameDisabled = "true";
    statusDisabled = "true";
    ownershipDisabled = "true";
    campusTypeDisabled = "true";
    maintainerDisabled = "true";
    facilityTypeDisabled = "true";
    hubDisabled = "false";
    mhmrDisabled = "true";
    deleteAddressButtonHide = true;
    deletePhoneButtonHide = true;
  }
  
  if( "1".equals( cres03so.getBIndORSAssociateToShines()))
  {
  	addOrsFacButtonHide = false;
    deleteOrsFacButtonHide = false;
  }

   ArrayList excludeOutOfStateOption = new ArrayList();
   excludeOutOfStateOption.add(CodesTables.CREGIONS_97);

  // SPB SIR 19972 - Always exclude FPS FA/Home
  // & Private Agency Adoptive Home when in modify mode
   ArrayList excludeFacilityOptions = new ArrayList();
   if( PageModeConstants.EDIT.equals( pageMode ) )
   {
    excludeFacilityOptions.add( CodesTables.CFACTYP4_70 );
    excludeFacilityOptions.add( CodesTables.CFACTYP4_71 );
   }

  // Variable to hold the css class for the each row in the lists
  String rowCss = "altColor";

  int tabIndex = 1;
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="JavaScript1.2">

// Get faciltiy type code/decode array for Resource Type of MHMR
<impact:codeArray codeName="CFACTYP4" arrayName="facilitytype4" blankValue="true"/>

 /*
  *This function is called when the page unloads.
  */
  window.attachEvent('onload', checkTransport );
  function checkTransport()
  {
  <%if( request.getParameter( "cbxCIndRsrcTransport" ) != null &&
        "1".equals( request.getParameter( "cbxCIndRsrcTransport" ) ) )
    {%>
    document.frmResourceDetail.cbxCIndRsrcTransport.checked = true;
    document.frmResourceDetail.cbxCIndRsrcTransport.defaultChecked = true;
  <%}%>
  }

 /*
  *This function is called before the page unloads.
  */
  window.attachEvent('onbeforeunload', setDirty );
  function setDirty()
  {
    IsDirty();
  }
 /*
  *This function submits the form to bring up facility detail page.
  */
  function submitFacilityDetail()
  {
   disableValidation( "frmResourceDetail" );
   submitValidateForm( "frmResourceDetail", "/resource/ResourceDetail/addORSResource" );
  }

 /*
  *This function submits the form to bring up services by area page.
  */
  function submitServicesByArea()
  {
   disableValidation( "frmResourceDetail" );
   submitValidateForm( "frmResourceDetail", "/resource/ServicesByArea/" );
  }

 /*
  *This function submits the form to bring up phone detail page.
  */
function submitFormToPhoneDetailWindow( indexNum, cReqFuncCd)
{
  var x = document.frmResourceDetail;
  x.indexNum.value = indexNum;
  x.cReqFuncCd.value = cReqFuncCd;
 
  if( x.cbxCIndRsrcTransport.checked )
  {
    x.cbxCIndRsrcTransport.value = "1";
  }

  disableValidation( "frmResourceDetail" );

  if (cReqFuncCd == 'A')
  {
    return true;
  }
  else
  {
    submitValidateForm( "frmResourceDetail", "/resource/ResourceDetail/displayPhoneDetail" );
  }
}

 /*
  *This function submits the form to bring up address detail page.
  */
function submitFormAddressDetail( indexNum, creqFunc, contracted)
{
  var x = document.frmResourceDetail;
  <%if( PageModeConstants.EDIT.equals(pageMode) ){%>
  if( contracted == "Y")
  {
    //MSG - You are Modifying a Resource Address that is linked to a Contract.
    alert("<%=MessageLookup.getMessageByName("MSG_RSRC_ADDR_CONTRACTED")%>");
  }
  <%}%>
  x.indexNum.value=indexNum;
  x.cReqFuncCd.value = creqFunc;
  

  if( x.cbxCIndRsrcTransport.checked )
  {
    x.cbxCIndRsrcTransport.value = "1";
  }

  disableValidation( "frmResourceDetail" );

  if (creqFunc == 'A')
  {
    return true;
  }
  else
  {
    submitValidateForm( "frmResourceDetail", "/resource/ResourceDetail/displayAddressDetail" );
  }
}

 /*
  *This function submits the form to bring up ors facilityId detail page.
  */
function submitResourceORSDetail(facilityId)
{
  document.frmResourceDetail.<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>.value = "";
  document.frmResourceDetail.<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>.value = facilityId;
  
  disableValidation("frmResourceDetail");
  submitValidateForm("frmResourceDetail", "/resource/ResourceORSDetail/displayORSResourceDetail");
}
 /*
  *This function submits the form to save resource detail.
  */
function saveResourceDetailWindow( creqFunc )
{
  window.onbeforeunload = null;
  var x = document.frmResourceDetail;
  var save = false;
  
    //Set checkbox values
    if( x.cbxCIndRsrcTransport.checked )
    {
       x.cbxCIndRsrcTransport.value = "1";
    }
    if( x.cbxCScrIndRsrcPrime.checked )
    {
       x.cbxCScrIndRsrcPrime.value = "Y";
    }
    if( x.cbxCScrIndRsrcSub.checked )
    {
       x.cbxCScrIndRsrcSub.value = "Y";
    }
    x.cReqFuncCd.value = creqFunc;
    x.validationOverride.value = 'false';
    x.action = "/resource/ResourceDetail/displayResourceDetail";
    save = true;
 // }
  return save;
}

 /*
  *This function iterates through an array of radio buttons or checkmarks to see if any have been selected.
  */
function checkForSelection( radioObj )
{
  var buttonChecked = false;
  for (var i = 0; i < radioObj.length; ++i)
  {
    buttonChecked = buttonChecked || radioObj[i].checked;
  }
  return buttonChecked;
}

 /*
  *This function submits the form to delete a phone, address, or multiple subcontractor records.
  */
function submitFormToDelete( action )
{
  var doDelete = false;
  var x = document.frmResourceDetail;
  var rowSelected = false;

  switch (action)
  {
      case "/resource/ResourceDetail/deleteSubcontractorDetail":
        rowSelected = true;
        break;

      case "/resource/ResourceDetail/deletePhoneDetail":
        if( x.rbPhoneRadioIndex != null && x.rbPhoneRadioIndex.length >1 ){
          var buttonChecked = false;
          var buttonIndex = 0;
          for (var i = 0; i < x.rbPhoneRadioIndex.length; ++i)
          {
            buttonChecked = buttonChecked || x.rbPhoneRadioIndex[i].checked;
            if(buttonChecked)
            {
              buttonIndex = i;
              rowSelected = true;
              break;
            }
          }
          for (var i = 0; i < x.rbPhoneRadioIndex.length; ++i)
          {
            x.rbPhoneRadioIndex[i].defaultChecked = x.rbPhoneRadioIndex[i].checked;
          }
          x.rbPhoneRadioIndex.value = buttonIndex;
        }else if( x.rbPhoneRadioIndex != null && x.rbPhoneRadioIndex.value != null && x.rbPhoneRadioIndex.checked )
        {
          rowSelected =  x.rbPhoneRadioIndex.value;
          x.rbPhoneRadioIndex.defaultChecked = x.rbPhoneRadioIndex.checked;
        }
        break;

      case "/resource/ResourceDetail/deleteAddressDetail":
        if( x.rbAddressRadioIndex != null && x.rbAddressRadioIndex.length >1 )
        {
          var buttonChecked = false;
          var buttonIndex = 0;
          for (var i = 0; i < x.rbAddressRadioIndex.length; ++i)
          {
            buttonChecked = buttonChecked || x.rbAddressRadioIndex[i].checked;
            if(buttonChecked)
            {
              buttonIndex = i;
              rowSelected = true;
              break;
            }
          }
          for (var i = 0; i < x.rbAddressRadioIndex.length; ++i)
          {
            x.rbAddressRadioIndex[i].defaultChecked = x.rbAddressRadioIndex[i].checked;
          }
          x.rbAddressRadioIndex.value = buttonIndex;

        }else if( x.rbAddressRadioIndex != null && x.rbAddressRadioIndex.value != null && x.rbAddressRadioIndex.checked )
        {
          rowSelected = x.rbAddressRadioIndex.value;
          x.rbAddressRadioIndex.defaultChecked = x.rbAddressRadioIndex.checked;
        }
        break;
        
      case "/resource/ResourceDetail/deleteOrsFacility":
        if( x.rbORSRadioIndex != null && x.rbORSRadioIndex.length >1 )
        {
          var buttonChecked = false;
          var buttonIndex = 0;
          for (var i = 0; i < x.rbORSRadioIndex.length; ++i)
          {
            buttonChecked = buttonChecked || x.rbORSRadioIndex[i].checked;
            if(buttonChecked)
            {
              buttonIndex = i;
              rowSelected = true;
              break;
            }
          }
          for (var i = 0; i < x.rbORSRadioIndex.length; ++i)
          {
            x.rbORSRadioIndex[i].defaultChecked = x.rbORSRadioIndex[i].checked;
          }
          x.rbORSRadioIndex.value = buttonIndex;

        }else if( x.rbORSRadioIndex != null && x.rbORSRadioIndex.value != null && x.rbORSRadioIndex.checked )
        {
          rowSelected = x.rbORSRadioIndex.value;
          x.rbORSRadioIndex.defaultChecked = x.rbORSRadioIndex.checked;
        }
        break;
  }

  // Alert user if they click a Delete button without selecting an item to delete
  if( !rowSelected )
  {
    //MSG - Please select at least one row to perform this action.
    setInformationalMessage("<%=MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION")%>");
  }
  else
  {
    var cnfrm = window.confirm("<%=MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE")%>")
    if(cnfrm)
    {
      x.cReqFuncCd.value = 'D';
      disableValidation( "frmResourceDetail" );
      doDelete = true;
    }
  }

  return doDelete;
}

 /*
  *This function pupulates the contact number display.
  */
function populateContactPhone( phoneNumber )
{
  document.all.contactNumber_id.innerHTML = phoneNumber;
}

</script>

<impact:validateForm name="frmResourceDetail"
     method="post"
     action="/resource/ResourceDetail/saveResourceDetail"
     schema="/WEB-INF/Constraints.xsd"
     pageMode="<%=pageMode%>">

<impact:validateErrors/>

  <impact:validateInput type="hidden" name="indexNum"/>
  <impact:validateInput type="hidden" name="cReqFuncCd"/>
  <impact:validateInput type="hidden" name="WindowName" value="ResourceDetail"/>
  <impact:validateInput type="hidden" name="txtuIdRsrcLinkParent"/>
  <impact:validateInput type="hidden" name="txtUlIdResource" value="<%=FormattingHelper.formatInt( cres03so.getUlIdResource() )%>"/>
  <impact:validateInput type="hidden" name="classResource" value="<%=classResource%>"/>
  <impact:validateInput type="hidden" name="fadResource" value="<%=fadResource%>"/>
  <impact:validateInput type="hidden" name="<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME%>" value="<%=pageMode%>"/>
  <impact:validateInput type="hidden" name="validationOverride"/>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
     <td align="right">
         <% /* Use descriptive IDs for your Table and Tag identifiers :
         Javascript code would be better inside a function that is called from here,
         but for ease of use I have put the code here */ %>
            <a href="#" onClick="expandAll();">Expand All</a>&nbsp;
            <a href="#" onClick="collapseAll();">Collapse All</a>&nbsp;
     </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">

<impact:validateInput type="hidden" name="resName" value="<%=cres03so.getSzNmLegal()%>" />
<impact:validateInput type="hidden" name="contactName" value="<%=cres03so.getSzNmRsrcContact()%>" />

  <tr>
            <th colspan="4">Resource Detail</th>
  </tr>
        <tr>
            <td>
              <impact:validateInput type="text" value="<%=cres03so.getSzNmResource()%>" name="txtNmResource" disabled="<%=resourceNameDisabled%>" label="Resource Name" required="true" tabIndex="<%=tabIndex++%>" maxLength="30" size="30" /></td>
            <td class="formLabel" > Resource ID: </td>
            <td> <%=FormattingHelper.formatInt( cres03so.getUlIdResource() )%></td>
             <impact:validateInput type="hidden" editableMode="<%=EditableMode.EDIT%>" name="resourceId" value="<%=FormattingHelper.formatInt(cres03so.getUlIdResource())%>"/>
        </tr>

        <tr>
            <!--SIR 22639 Add LEGAL NAME -->
            <td >
              <impact:validateInput colspan="3" type="text"  value="<%=cres03so.getSzNmLegal()%>" name="txtNmLegal" disabled="<%=legalNameDisabled%>" required="true" label="Legal Name" tabIndex="<%=tabIndex++%>" maxLength="45" size="45"/>
           </td>
        </tr>

        <tr>
            <td class="formLabel" > Resource Type: </td>
            <td>
              <%=Lookup.simpleDecodeSafe("CRSCTYPE", cres03so.getSzCdRsrcType() )%>
              <impact:validateInput type="hidden" editableMode="<%=EditableMode.EDIT%>" name="selCdRsrcType" value="<%=cres03so.getSzCdRsrcType()%>"/>
            </td>
        	<!-- Per defect STGAP00002641, removed exclusion of Statewide option -->
        	<%-- Defect STGAP00006948 - exclude out of state --%>
            <td><impact:validateSelect name="selCdRsrcMaintainer" codesTable="CREGIONS" excludeOptions="<%=excludeOutOfStateOption%>" value="<%=cres03so.getSzCdRsrcMaintainer()%>" disabled="<%=maintainerDisabled%>" label="Maintainer" required="true" tabIndex="<%=tabIndex++%>"/></td>
        </tr>
        <tr>
            <td><impact:validateSelect name="selCdRsrcStatus" value="<%=cres03so.getSzCdRsrcStatus()%>" codesTable="CRSCSTAT" disabled="<%=statusDisabled%>" label="Status" tabIndex="<%=tabIndex++%>"/></td>
            <td >
              <impact:validateInput type="text" value="<%=cres03so.getSzNmRsrcContact()%>" disabled="<%=contactDisabled%>" name="txtNmRsrcContact" label="Contact Name" tabIndex="<%=tabIndex++%>" maxLength="25" size="25" constraint="Name25"/>
      </td>
        </tr>

      <tr>
            <td><impact:validateSelect name="selCdRsrcOwnership" codesTable="COWNSHIP" disabled="<%=ownershipDisabled%>" blankValue="true" label="Ownership" value="<%=cres03so.getSzCdRsrcOwnership()%>" tabIndex="<%=tabIndex++%>"/></td>
            
             <td >
              <impact:validateInput type="text" value="<%=cres03so.getSzNmRsrcContactTitle()%>" disabled="<%=contactDisabled%>" name="txtNmRsrcContactTitle" label="Contact Title" tabIndex="<%=tabIndex++%>" maxLength="30" size="30" constraint="Name30"/>
          </td>
            
          
        </tr>
        
          <tr>
            <td>
               <impact:validateSelect name="selCdRsrcFacilType"
                                         label="Facility Type"
                                         codesTable="CFACTYP4"
                                         excludeOptions="<%=excludeFacilityOptions%>"
                                         disabled="<%=facilityTypeDisabled%>"
                                         value="<%=FormattingHelper.formatString(cres03so.getSzCdRsrcFacilType())%>"
                                         tabIndex="<%=tabIndex++%>"
                                         style="WIDTH: 180px"
                                         blankValue="true"/>
              </td>
                   
            <td class="formLabel">Contact Phone:</td>
            <td id="contactNumber_id"> </td>
        </tr>
        
         <tr>
            <td >
              <impact:validateInput type="text" value="<%=cres03so.getSzNbrRsrcNtnlProvider()%>" disabled="<%=nationalProviderNumberDisabled%>" name="txtNationalProviderNumber" label="National Provider Number" tabIndex="<%=tabIndex++%>" maxLength="20" size="20" constraint="AlphaNumeric"/>
          </td>
             <td >
              <impact:validateInput type="text" value="<%=cres03so.getSzAddrRsrcEmail()%>" disabled="<%=emailAddressDisabled%>" name="txtEmailAddress" label="Email Address" tabIndex="<%=tabIndex++%>" maxLength="50" size="50" constraint="Email"/>
          </td>
        </tr>
        
        <tr>
           <td>
              <impact:validateInput  colspan="3" type="text" value="<%=cres03so.getSzAddrRsrcWebsite()%>" disabled="<%=webAddressDisabled%>" name="txtWebAddress" label="Web Address" tabIndex="<%=tabIndex++%>" maxLength="100" size="100" constraint="URL"/>
           </td>
             
        </tr>
        <tr>
            <td><impact:validateSelect name="selCdSchoolType" codesTable="CSCHTYPE" value="<%=FormattingHelper.formatString(cres03so.getSzCdSchoolType())%>"  label="School Type" tabIndex="<%=tabIndex++%>" blankValue="true"/></td>
            <td><impact:validateSelect name="selCdSchoolDist" codesTable="CSCHDSTR" value="<%=FormattingHelper.formatString(cres03so.getSzCdSchoolDistrict())%>"  label="School District" tabIndex="<%=tabIndex++%>" blankValue="true"/></td>
            
        </tr>
        <tr>
            <td><impact:validateSelect name="selPaymentDelivery" codesTable="CPAYDELI" value="<%=FormattingHelper.formatString(cres03so.getSzCdPaymentDelivery())%>"  label="Payment Method" tabIndex="<%=tabIndex++%>" blankValue="true"/></td>
            <td></td>
            
        </tr>
       
     <tr>
      <td class="formLabel" colspan="2" >
              <impact:validateInput type="checkbox" name="cbxCIndRsrcTransport" checked="<%=transport%>" value="0" tabIndex="<%=tabIndex++%>"/>
              Transportation Provided
            </td>
       
            <td class="formLabel" >
              <impact:validateInput type="checkbox" name="cbxCScrIndRsrcPrime" checked="<%=prime%>" disabled="true" value="N" />
              Prime
            </td>
            <td class="formLabel" >
              <impact:validateInput type="checkbox" name="cbxCScrIndRsrcSub" checked="<%=sub%>" disabled="true" value="N" />
              Sub
            </td>
        </tr>
        <tr>
            <td class="formLabel">Last Updated On:</td>
            <td><%=FormattingHelper.formatDate( cres03so.getTsLastUpdate() )%><impact:validateInput type="hidden" name="txtLastUpdate" value="<%=SerializationHelper.serializeObject( cres03so.getTsLastUpdate() )%>"/></td>
            <td class="formLabel">Last Updated By:</td>
            <td><%=cres03so.getSzNmRsrcLastUpdate()%><impact:validateInput type="hidden" name="txtNmRsrcLastUpdate" value="<%=cres03so.getSzNmRsrcLastUpdate()%>"/></td>
        </tr>

        <tr>
            <td class="formLabel">Comments:</td>
            <td colspan="3">
              <impact:validateTextArea name="txtTxtRsrcComments"
                                       rows="4"
                                       cols="120"
                                       tabIndex="<%=tabIndex++%>"
                                       constraint="Comments"
                                       maxLength="300">
                 <%=cres03so.getSzTxtRsrcComments()!= null?FormattingHelper.formatString(cres03so.getSzTxtRsrcComments()):StringHelper.EMPTY_STRING%>
              </impact:validateTextArea></td>
        </tr>
    </table>
<!-- End Resource Detail --><!-- BEGIN THE ADDRESS/PHONE DETAIL NOW -->
<br>

<impact:ExpandableSectionTag
name="addressDetail"
label="Address List"
tabIndex="<%=tabIndex++%>">

  <!-- SIR 23859 Impact needs to have a width in px mobile % -->
  <impact:ifServerImpact>
  <div id="ResourceDtlAddressScroll" style="OVERFLOW:auto;  WIDTH:764px; HEIGHT:100px" class="tableBorder">
  </impact:ifServerImpact>
  <impact:ifMobileImpact>
  <div id="ResourceDtlAddressScroll" style="OVERFLOW:auto;  WIDTH:100%; HEIGHT:100px" class="tableBorder">
  </impact:ifMobileImpact>
    <table border="0" cellspacing="0" cellpadding="3" width="100%">
      <tr>
        <th class="thList" width="5%">&nbsp;</th>
        <th class="thList">Type</th>
        <th class="thList">Vendor ID</th>
        <th class="thList">Attention</th>
        <th class="thList">Address</th>
        <th class="thList">County</th>
   <%
    // SIR 23730 Phase II Mobile Start
        if( !PlatformConstants.MOBILE_IMPACT )
        {
     %>
        <th class="thList" width="80">Comments</th>
     <%
    } else {
     %>
        <th class="thList" width="80"></th>
     <%
    }
         // SIR 23730 Phase II Mobile End
     %>
      </tr>

      <%
        int loopCount = 0;
        ROWCRES03SOG00 addressRow = null;
        // String primaryExists = "false";

        Enumeration eAddresses = addressArray.enumerateROWCRES03SOG00();
        if (eAddresses.hasMoreElements())
        {
          while (eAddresses.hasMoreElements())
          {
            addressRow = (ROWCRES03SOG00) eAddresses.nextElement();
            rowCss = FormattingHelper.getRowCss( loopCount + 1 );
      %>

      <tr class="<%=rowCss%>" valign="top">
    <%// SIR 23730 Phase II Mobile
        if( PlatformConstants.MOBILE_IMPACT )
        {
        %> 
          <td><impact:validateInput type="radio" name="rbAddressRadioIndex" value="<%= String.valueOf( loopCount ) %>" tabIndex="<%= tabIndex %>" disabled="true"/></td>
    <%
        } else {
        %>
        <td><impact:validateInput type="radio" name="rbAddressRadioIndex" value="<%= String.valueOf( loopCount ) %>" tabIndex="<%= tabIndex %>"/></td>
        <%     } %>
   <%
        if( PlatformConstants.MOBILE_IMPACT )
        {
     %>
          <td><nobr><%=Lookup.simpleDecodeSafe("CRSCADDR", addressRow.getSzCdRsrcAddrType() )%>&nbsp;&nbsp;</nobr></td>
     <%
    } else {
     %>
           <td><nobr><a tabindex=<%=tabIndex++%> href="javascript:submitFormAddressDetail( '<%=loopCount%>','U', '<%=addressRow.getCScrIndRsrcContracted()%>')"><%=Lookup.simpleDecodeSafe("CRSCADDR", addressRow.getSzCdRsrcAddrType() )%></a>&nbsp;&nbsp;</nobr></td>   
     <%
                }
         // SIR 23730 Phase II Mobile End
     %>
        <td><nobr><%=addressRow.getSzNbrRsrcAddrVid()!= null?addressRow.getSzNbrRsrcAddrVid():StringHelper.EMPTY_STRING %>&nbsp;&nbsp;</td>
        <td><nobr><%=addressRow.getSzAddrRsrcAddrAttn()!= null?addressRow.getSzAddrRsrcAddrAttn():StringHelper.EMPTY_STRING %>&nbsp;&nbsp;</td>
        <td><nobr><%=addressRow.getSzAddrRsrcAddrStLn1()!= null?addressRow.getSzAddrRsrcAddrStLn1():StringHelper.EMPTY_STRING %>
                  <%=addressRow.getSzAddrRsrcAddrStLn2()!= null?addressRow.getSzAddrRsrcAddrStLn2():StringHelper.EMPTY_STRING%>,
                  <%=addressRow.getSzAddrRsrcAddrCity()!= null?addressRow.getSzAddrRsrcAddrCity():StringHelper.EMPTY_STRING%>,
                  <%=addressRow.getSzCdFacilityState()!= null?addressRow.getSzCdFacilityState():StringHelper.EMPTY_STRING%>
                  <%=addressRow.getSzAddrRsrcAddrZip()!=null?addressRow.getSzAddrRsrcAddrZip():StringHelper.EMPTY_STRING%>&nbsp;&nbsp;</td>
        <td><nobr><%=Lookup.simpleDecodeSafe("CCOUNT", addressRow.getSzCdFacilityCounty())%>&nbsp;&nbsp;</td>
   <%
    // SIR 23808 Phase II
        if( !PlatformConstants.MOBILE_IMPACT )
        {
     %>
        <td align="center"><%if( addressRow.getSzTxtRsrcAddrComments() != null && !StringHelper.EMPTY_STRING.equals(addressRow.getSzTxtRsrcAddrComments()) ){%><img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" ><%}%></td>
     <% } else 
          {  %>
             <td>&nbsp;</td>
        <%} %>   
      </tr>
      <%
            loopCount++;
          } // end while
        } // end if
      %>
     
    </table>
  </div>

  <table width="100%">
    <tr>
        <td align="left" colspan="2">
        <%
    // SIR 23730 Phase II Mobile
        if( !PlatformConstants.MOBILE_IMPACT )
      {
      if( !deleteAddressButtonHide ){%>
            <impact:ButtonTag name="btnDeleteAddressDetail" img="btnDelete" navAwayCk="true" restrictRepost="true" editableMode="<%= EditableMode.EDIT %>" function="return submitFormToDelete( '/resource/ResourceDetail/deleteAddressDetail' );" form="frmResourceDetail" action="/resource/ResourceDetail/deleteAddressDetail" tabIndex="<%=tabIndex++%>"/>
        <%  }
      }
      %>
        </td>
        <td align="right" colspan="3">
        <%
    // SIR 23730 Phase II Mobile
        if( !PlatformConstants.MOBILE_IMPACT )
      {
      if( !addAddressButtonHide ){%>
            <impact:ButtonTag name="btnAddAddressDetail" img="btnAdd" navAwayCk="true" restrictRepost="true" align="right" editableMode="<%= EditableMode.EDIT %>" function="return submitFormAddressDetail('0' , 'A', 'N');" form="frmResourceDetail" action="/resource/ResourceDetail/displayAddressDetail" tabIndex="<%=tabIndex++%>"/>
        <%   }
      }
      %>
        </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>

<br>


<impact:ExpandableSectionTag
name="phoneDetail"
label="Phone List"
tabIndex="<%=tabIndex++%>">

  <div id="ResourceDtlPhoneScroll" style="OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px" class="tableBorder">
    <table border="0" cellspacing="0" cellpadding="3" width="100%">
      <tr>
        <th class="thList" width="5%">&nbsp;</th>
        <th class="thList">Type</th>
        <th class="thList">Phone</th>
        <th class="thList">Ext</th>
  <%
    // SIR 23730 Phase II Mobile Start
        if( !PlatformConstants.MOBILE_IMPACT )
        {
    %>
            <!-- SIR 23859 - added width 80 in order for checkmarks to be centered correctly  -->
          <th class="thList" width="80">Comments</th>
     <%
    } else {
         // SIR 23730 Phase II Mobile End
     %>
      <!-- SIR 23859 - added width 80 for consistencey -->
             <th class="thList" width="80"></th>
     <%
    }
     %>
      </tr>

  <%
    int phoneLoopCount = 0;
    Enumeration ephoneArray =phoneArray.enumerateROWCRES03SOG01();
    if (ephoneArray.hasMoreElements())
    {
      ROWCRES03SOG01 phoneRow = null;
       while (ephoneArray.hasMoreElements())
       {
       
        phoneRow = (ROWCRES03SOG01) ephoneArray.nextElement();
       rowCss = FormattingHelper.getRowCss( phoneLoopCount+1 );
        String formatedPhone = "";
        if( phoneRow.getLNbrFacilPhoneNumber().length() == 10 )
        {
          formatedPhone = FormattingHelper.formatPhone(phoneRow.getLNbrFacilPhoneNumber());
        }
        else
        {
          formatedPhone = phoneRow.getLNbrFacilPhoneNumber();
        }
        //  If contact phone has been populated display it
        //  in the Resource Detail section of the page
        //
        if( "15".equals( phoneRow.getSzCdFacilPhoneType() ) )
        {
          %>
          <SCRIPT LANGUAGE=JavaScript>
      populateContactPhone("<%=formatedPhone%>");
    </SCRIPT>
    <%
        }
  %>
      <tr class="<%=rowCss%>" valign="top">
    <% // SIR 23729 Phase II Mobile
        if( PlatformConstants.MOBILE_IMPACT )
        {
        %> 
          <td><impact:validateInput type="radio" name="rbPhoneRadioIndex" value="<%= String.valueOf(phoneLoopCount) %>" tabIndex="<%=tabIndex %>" disabled="true"/></td>
    <%
        } else {
        %>
        <td><impact:validateInput type="radio" name="rbPhoneRadioIndex" value="<%= String.valueOf( phoneLoopCount) %>" tabIndex="<%=tabIndex %>"/></td>
      <%     } %>
  <%
    // SIR 23730 Phase II Mobile Start
        if( PlatformConstants.MOBILE_IMPACT )
        {   
     %>
           <td><nobr><%=Lookup.simpleDecodeSafe("CRSCPHON", phoneRow.getSzCdFacilPhoneType() )%></nobr></td>
     <%
    } else {
     %>
             <td><nobr><a tabIndex="<%=tabIndex++%>" href="javascript:submitFormToPhoneDetailWindow( '<%=phoneLoopCount%>', 'U')"><%=Lookup.simpleDecodeSafe("CRSCPHON", phoneRow.getSzCdFacilPhoneType() )%> </a></td>
     <%        }
         // SIR 23730 Phase II Mobile End
     %>
       <td><nobr><%=formatedPhone%></td>
        <td><nobr><%=phoneRow.getLNbrFacilPhoneExtension()!= null? phoneRow.getLNbrFacilPhoneExtension():StringHelper.EMPTY_STRING %></td>
   <%
     // SIR 23808 - Comments column should not be visible on Mobile
         if( !PlatformConstants.MOBILE_IMPACT )
       {
     %>
     <td align="center"><nobr><%if( phoneRow.getSzTxtRsrcPhoneComments()!=null && !StringHelper.EMPTY_STRING.equals( phoneRow.getSzTxtRsrcPhoneComments() ) ){%><img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" ><%}%></td>
  <%    } else
          { %>
             <td>&nbsp;</td>
  <%      } %>
      </tr>
  <% 
   phoneLoopCount ++;
   }
   
  }
  else
  {
  %>
      <tr class="odd"><td colspan="4">No Results Found</td></tr>
<%}%>
 
    </table>
  </div>

  <table width="100%" cellspacing="0" cellpadding="3" border="0">
    <tr>
        <td align="left" colspan="2">
        <% 
    // SIR 23730 Phase II Mobile Start
        if( !PlatformConstants.MOBILE_IMPACT )
      {
      if( !deletePhoneButtonHide ){%>
              <impact:ButtonTag name="btnDeletePhoneDetail" img="btnDelete" navAwayCk="true" restrictRepost="true" editableMode="<%= EditableMode.EDIT %>" function="return submitFormToDelete( '/resource/ResourceDetail/deletePhoneDetail' );" form="frmResourceDetail" action="/resource/ResourceDetail/deletePhoneDetail" tabIndex="<%=tabIndex++%>"/>
        <%  }
      }// Phase II Mobile End
    %>
        </td>
        <td align="right" colspan="3">
        <%
    // SIR 23730 Phase II Mobile Start
         if( !PlatformConstants.MOBILE_IMPACT )
      {
          if( !addPhoneButtonHide  ){%>
              <impact:ButtonTag name="btnAddPhoneDetail" img="btnAdd" navAwayCk="true" restrictRepost="true" align="right" editableMode="<%= EditableMode.EDIT %>" function="return submitFormToPhoneDetailWindow( '0' , 'A');" form="frmResourceDetail" action="/resource/ResourceDetail/displayPhoneDetail" tabIndex="<%=tabIndex++%>"/>
        <%  }
      }// SIR 23730 Phase II Mobile End
    %>
        </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>

<br>
<% // SIR 23730 Phase II Mobile Start  
  if( !PlatformConstants.MOBILE_IMPACT )
  {
%>
     <impact:include page="/submodule/SubcontractorSub/displaySubcontractorList"
                  callingPage="/resource/ResourceDetail/displayResourceDetail"
                  includingForm="frmResourceDetail"
                  tabIndex="<%=tabIndex++%>" >

       <impact:attribute name="SubcontractorSubvidResource" value="<%=FormattingHelper.formatInt( cres03so.getUlIdResource() )%>" />
       <impact:attribute name="SubcontractorSubvpredisplay" value="true" />
       <impact:attribute name="SubcontractorSubvviewOnly" value="false" />
       <impact:attribute name="SubcontractorSubvfacilityType" value="<%=cres03so.getSzCdRsrcFacilType()%>" />
       <impact:attribute name="SubcontractorSubvfacilityNumber" value="<%=FormattingHelper.formatInt( cres03so.getLNbrRsrcFacilAcclaim() )%>" />
     </impact:include>
<%  }  // SIR 23730 Phase II Mobile End %>

<br>

<impact:ExpandableSectionTag
name="orsFacList"
label="ORS Facility List"
tabIndex="<%=tabIndex++%>">

  <div id="ResourceDtlOrsFacScroll" style="OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px" class="tableBorder">
    <table border="0" cellspacing="0" cellpadding="3" width="100%">
      <tr>
        <th class="thList" width="5%">&nbsp;</th>
        <th class="thList">ORS Facility Name</th>
        <th class="thList">ORS Facility ID</th>
        <th class="thList">ORS Facility Status</th>
      </tr>

  <%
    int orsFacLoopCount = 0;
    if (orsFacArray != null && orsFacArray.enumerateROWCRES03SOG02().hasMoreElements())
    {
      Enumeration eOrsFacArray =orsFacArray.enumerateROWCRES03SOG02();
      ROWCRES03SOG02 orsFacRow = null;
       while (eOrsFacArray.hasMoreElements())
       {
       
	        orsFacRow = (ROWCRES03SOG02) eOrsFacArray.nextElement();
	        rowCss = FormattingHelper.getRowCss(orsFacLoopCount + 1);
	        String orsFacName = orsFacRow.getSzNmOrsFacilName();
  %>
	      <tr class="<%=rowCss%>" valign="top">
	        <% // SIR 23729 Phase II Mobile
	        if( PlatformConstants.MOBILE_IMPACT )
	        {
	        %> 
	          <td><impact:validateInput type="radio" name="rbORSRadioIndex" value="<%= String.valueOf(orsFacLoopCount) %>" tabIndex="<%=tabIndex %>" disabled="true"/></td>
	        <%
	        } else {
	        %>
	        <td><impact:validateInput type="radio" name="rbORSRadioIndex" value="<%= String.valueOf(orsFacLoopCount) %>" tabIndex="<%=tabIndex %>"/></td>
	      <%     } %>
	      <%
	      // SIR 23730 Phase II Mobile Start
	        if( PlatformConstants.MOBILE_IMPACT )
	        {   
	      %>
	          <td><nobr><%=orsFacName%></nobr></td>
	      <%
	        } else {
	      %>
	          <td><nobr><a tabIndex="<%=tabIndex++%>" href="javascript:submitResourceORSDetail( '<%=orsFacRow.getSzNbrOrsRsrcId()%>')"><%=orsFacName%> </a></td>
	     <%        }
	         // SIR 23730 Phase II Mobile End
	     %>
	          <td><nobr><%=orsFacRow.getSzNbrOrsRsrcId()!= null ? orsFacRow.getSzNbrOrsRsrcId():StringHelper.EMPTY_STRING %></td>
	          <td><nobr><%=orsFacRow.getSzTxtOrsFacStatus()!=null ? orsFacRow.getSzTxtOrsFacStatus() : "&nbsp;"%></td>
	    </tr>
	    <% 
	     orsFacLoopCount ++;
       }
   
    }
    else
    {
      %>
      <tr class="odd"><td colspan="4">No Results Found</td></tr>
  <%}%>
   </table>
 </div>

  <table width="100%" cellspacing="0" cellpadding="3" border="0">
    <tr>
        <td align="left" colspan="2">
        <% 
    // SIR 23730 Phase II Mobile Start
        if( !PlatformConstants.MOBILE_IMPACT )
      {
      if( !deleteOrsFacButtonHide ){%>
					<impact:ButtonTag name="btnDeleteOrsFacility" img="btnDelete"
						navAwayCk="true" restrictRepost="true"
						editableMode="<%= EditableMode.EDIT %>"
						function="return submitFormToDelete( '/resource/ResourceDetail/deleteOrsFacility' );"
						form="frmResourceDetail"
						action="/resource/ResourceDetail/deleteOrsFacility"
						tabIndex="<%=tabIndex++%>" />
					<%  }
      }// Phase II Mobile End
    %>
        </td>
        <td align="right" colspan="3">
        <%
    // SIR 23730 Phase II Mobile Start
         if( !PlatformConstants.MOBILE_IMPACT )
      {
          if( !addOrsFacButtonHide  ){%>
              <impact:ButtonTag name="btnAddOrsFacility" img="btnAdd" navAwayCk="true" restrictRepost="true" align="right" editableMode="<%= EditableMode.EDIT %>" function="return submitFacilityDetail();" form="frmResourceDetail" action="/resource/ResourceDetail/addORSResource" tabIndex="<%=tabIndex++%>"/>
        <%  }
      }// SIR 23730 Phase II Mobile End
    %>
        </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>
<%-- REG058 -- The Save button was moved to after the expandable section and a HR
     was added. --%>
<%if( !saveResourceButtonHide ){%>
  <table width="100%">
    <tr>
      <td>
        <hr>
      </td>
    </tr>
    <tr>
      <td align="right" colspan="11">
        <impact:ButtonTag name="btnSaveResourceDetail"
                          img="btnSave"
                          restrictRepost="true"
                          align="right"
                          editableMode="<%= EditableMode.EDIT %>"
                          function="return saveResourceDetailWindow('U');"
                          form="frmResourceDetail"
                          action="/resource/ResourceDetail/saveResourceDetail"
                          tabIndex="<%=tabIndex++%>"/>

      </td>
    </tr>
  </table>
<%}%>


     <!--EndMain Content-->
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
<input type="hidden" name="<%=ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME%>"/>
</impact:validateForm>


