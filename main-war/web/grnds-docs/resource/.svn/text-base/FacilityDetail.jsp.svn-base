  <%
/**
 * JSP Name:     FacilityDetail.jsp
 * Created by:   cawthocw
 * Date Created: 07/26/02
 *
 * Description:
 * This page displays the Facility Detail Information.
*
* Change History:
* Date      User              Description
* --------  ----------------  -----------------------------------------------
* 06/11/03  Todd Reser        18216 - added isExpanded="true" to
*                             ExpandableSectionTag : Level of Care History.
* 08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
* 12/01/03  CORLEYAN          LOC Enhancement - When displaying LOC list, also
*                             check for new codes for post 09/01/2003.  The add
*                             pushbutton also now goes to add level of care instead
*                             of modify.
* 02/18/04  Linda Reed        SIR 22625- added txtChildResourceId so Home ResourceId
*                             passed on to following pages.
* 09/16/05  berkime           SIR 23890 - changed the wording from level of care to
*                             service level.
* 01/06/09  hnguyen           STGAP00010697 - modified Other/Specialty Certification
*                             textfield maxlength and constraint to 50 characters.
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02SOG01_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>


  <%
    BaseSessionStateManager state = (BaseSessionStateManager)
            request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean)
            request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

    if (tuxPagination != null) {
      DatabaseResultDetails db = tuxPagination.getResultDetails();
    }

    String idResource = null;
    String facilityName = null;
    String facilityNumber = null;
    String contact = null;
    String resourceType = null;
    String facilityType = null;
    String certBy = "";
    String othSpclRsrcCert = "";
    String certificationDate = "";
    String closeDate = "";
    String availableAfterHours = "false";

    String codesTable = "CERTIFBY";
    CRES02SO cres02so = null;
    CRES09SO cres09so = null;
    ROWCRES07DO_ARRAY locArray = null;
    
    int capacity = 0;

    boolean facilitySaveButtonHide = false;
    //get the page mode
    String pageMode = PageMode.getPageMode(request);

    //get the input parameters from Global Data and state
    idResource = GlobalData.getUlIdResourceAsString(request);
    facilityName = GlobalData.getSzNmResource(request);
    facilityNumber = (String) state.getAttribute("lNbrRsrcFacilAcclaim", request);

    contact = (String) state.getAttribute("szNmRsrcContact", request);
    resourceType = (String) state.getAttribute(MetaphorTabs.RESOURCE_TYPE_ATTRIBUTE_NAME, request);
    facilityType = (String) state.getAttribute("szCdRsrcFacilType", request);
    //get the facility detail information
    cres09so = (CRES09SO) state.getAttribute("cres09so", request);
    //get the home list information
    cres02so = (CRES02SO) request.getAttribute("cres02so");
    //Get specific data from cres09so
    if (cres09so != null)
     {
      locArray = cres09so.getROWCRES07DO_ARRAY();
      capacity = cres09so.getUNbrRsrcFacilCapacity();

      if (StringHelper.isValid(cres09so.getSzCdRsrcCertBy())) 
      {
        certBy = cres09so.getSzCdRsrcCertBy();
      }
        
      if (StringHelper.isValid(cres09so.getTxtSpecCert()))
       {
        othSpclRsrcCert = cres09so.getTxtSpecCert();
       }
      //if there are certification and close dates, format them to the correct MM/DD/YYYY format
      if (cres09so.getDtDtRsrcCert() != null)
       {
        certificationDate = FormattingHelper.formatDate(cres09so.getDtDtRsrcCert());
       }
      if (cres09so.getDtDtRsrcClose() != null)
       {
        closeDate = FormattingHelper.formatDate(cres09so.getDtDtRsrcClose());
       }
       if(cres09so.getBIndAvailableAfterHrs() != null)
       {
         if(cres09so.getBIndAvailableAfterHrs().equals("Y"))
         {
         	availableAfterHours = "true";
         }
       }
    }
    
    ArrayList selLicensureTypesList = new ArrayList();
    if(cres09so != null)
    {
      SelectedLicensureTypesArray selectedLicensureTypesArray = cres09so.getSelectedLicensureTypesArray();
      if(selectedLicensureTypesArray != null)
      {
        for(Iterator it = selectedLicensureTypesArray.iterateSzPrgmLicensureType(); it.hasNext();)
        {
          String pgmLcnsreType = (String)it.next();
          selLicensureTypesList.add(pgmLcnsreType);
        }
      }
    }
    
    
    

    ROWCRES07DO locRow = null;
    //create new instance of the Home List array
    CRES02SOG01_ARRAY homeArray = new CRES02SOG01_ARRAY();
    CRES02SOG01 homeRow = null;
    if (cres02so != null) {
      homeArray = cres02so.getCRES02SOG01_ARRAY();
    }

    //check to see if the facility type supports Level of Care
    String levelOfCareSupported = null;
    if (facilityType != null) {
      levelOfCareSupported = Lookup.simpleDecodeSafe("CFACLOC", facilityType);
    }
      
    //If the page mode is Edit AND Resource Type is not Mhmr AND , show editable Cert date field
    String certificationDateMode = Integer.toString(EditableMode.EDIT);
    String certificationDateRequired = "true";
    String certificationDateDisabled = "false";
    String certifiedByDisabled = "false";
    if (pageMode.equals(PageModeConstants.VIEW)
        || (pageMode.equals(PageModeConstants.EDIT) && resourceType != null && "05".equals(resourceType))
        || StringHelper.isValid(facilityNumber)) {
      certificationDateMode = Integer.toString(EditableMode.NONE);
      certificationDateRequired = "false";
    }

    //Set Lic Capacity and Close Date to Protected if its a class facility (ie has fac #)
    int classFacilityTypeMode = EditableMode.EDIT;
    String closeDateDisabled = "false";
    if (StringHelper.isValid(facilityNumber) || pageMode.equals(PageModeConstants.VIEW)) {
      classFacilityTypeMode = EditableMode.NONE;
      certificationDateDisabled = "true";
      certifiedByDisabled = "true";
      closeDateDisabled = "true";
      facilitySaveButtonHide = true;
    }

    int tabIndex = 1;
  %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">
//Set Page to display confirmation message on leaving page if something has changed
  window.attachEvent('onbeforeunload', setDirty );
  function setDirty()
  {
    IsDirty();
  }

//Submit the form to the saveFacility command
function saveFacility()
{
  window.onbeforeunload = null;
  document.FacilityDetail.cReqFuncCd.value = "U";
  document.FacilityDetail.locDataAction.value = "A";
  submitValidateForm( "FacilityDetail", "/resource/Facility/saveFacility" );
}


function modifyLevelOfCare(active, hold, effective, end, rownum)
{
  document.modifyLOC.activeLOC.value = active;
  document.modifyLOC.holdLOC.value = hold;
  document.modifyLOC.effectiveDate.value = effective;
  document.modifyLOC.endDate.value = end;
  document.modifyLOC.rownum.value = rownum;
  document.modifyLOC.pageMode.value = "<%=pageMode%>";
  submitForm( "modifyLOC", "/resource/Facility/modifyLOC" );
}

function displayCaretakerInformation( idResource )
{
  document.FacilityDetail.txtChildResourceId.value = idResource;
  disableValidation('FacilityDetail');
  submitValidateForm( "FacilityDetail", "/resource/Caretaker/displayCaretakerInformation" );
}
</script>

<impact:validateErrors/>

<impact:validateForm name="FacilityDetail"
  method="post"
  action="/resource/Facility/saveFacility"
  schema="/WEB-INF/Constraints.xsd"
  pageMode="<%=pageMode%>">
<impact:validateInput type="hidden" name="txtLNbrRsrcFacilAcclaim" id="txtLNbrRsrcFacilAcclaim" value="<%=facilityNumber%>"/>
<impact:validateInput type="hidden" name="txtChildResourceId" id="txtChildResourceId" value=""/>
<impact:validateInput type="hidden" name="txtNmRsrcContact" id="txtNmRsrcContact" value="<%=contact%>"/>
<impact:validateInput type="hidden" name="cboCdRsrcType" id="cboCdRsrcType" value="<%=resourceType%>"/>
<impact:validateInput type="hidden" name="cboCdRsrcFacilType" id="cboCdRsrcFacilType" value="<%=facilityType%>"/>
<impact:validateInput type="hidden" name="locDataAction" id="locDataAction"/>
<impact:validateInput type="hidden" name="cReqFuncCd" id="cReqFuncCd"/>
<impact:validateInput type="hidden" name="<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME %>" value="<%=pageMode%>"/>
<impact:validateInput type="hidden" editableMode="<%=EditableMode.EDIT%>" name="validationOverride"/>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
  
   <tr><th colspan="8">Certification Information</th> </tr>
  
  <tr class="subDetail">
    <td>
     <impact:validateDisplayOnlyField
        name="txtPlacementName"
        label="Placement Provider Name"
        value="<%= FormattingHelper.formatString( StringHelper.getNonNullString(facilityName))%>" />
    </td>
    <td >
     <impact:validateDate name="certDate" disabled="false" label="Certification Date"  required="true"
             value="<%=certificationDate%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td class="formLabel" height="25">
      <impact:validateDisplayOnlyField
        name="txtContactName"
        label="Contact"
        value="<%= FormattingHelper.formatString( StringHelper.getNonNullString(contact))%>" />
    </td>
    <td>
      <impact:validateDate name="closeDate" disabled="false" label="Close Date"
                           value="<%=closeDate%>" size="8" constraint="Date" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>    
  <tr class="subDetail">
    <td>
      <impact:validateSelect label="Certification Type"
                 value="<%=certBy%>"
                 name="szCdRsrcCertBy"
                 codesTable="CERTIFBY"
                 blankValue="true" 
                 tabIndex="<%=tabIndex++%>" 
                 style="WIDTH: 340px"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td>
    <impact:validateInput label="Licensing Capacity"
               editableMode="<%=classFacilityTypeMode%>"
                maxLength="4"
                type="input"
                constraint="Numeric"
                name="uNbrRsrcFacilCapacity"
                size="4"
                value="<%=Integer.toString(capacity)%>"
                tabIndex="<%=tabIndex++%>"/>
   </td>
   <td>
   	<impact:validateInput
   	      name="ckAvailAfterHrs"
   	      checked="<%=availableAfterHours%>"
   	      type="checkbox"
   	      value="ON"
   	      cssClass="formInput"
   	      label="Available After Hours?"
              tabIndex="<%= tabIndex++ %>"/>
   </td>
  </tr>
  <tr class="subDetail">
    <td>
        <impact:validateInput tabIndex="<%=tabIndex++%>"
                              value="<%=othSpclRsrcCert%>"
                              type="text"
                              name="txtSpecCert"
                              label="Other/Specialty Certification"
                              cssClass="formInput"
                              size="30"
                              maxLength="50"
                              constraint="Paragraph50"/>
  </td>
</tr>     
</table>
<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
<tr><th colspan="6">Program Licensure Types</th></tr>
<tr class="subDetail">
   <%
      int prgmLicensureTypesLoopCount = 0;
      Collection prgmLicensureTypesCollection = Lookup.getCategoryCodesCollection(CodesTables.CPGLICTP);
      Iterator prgmLicensureTypesIter = prgmLicensureTypesCollection.iterator();
      while(prgmLicensureTypesIter.hasNext())
      {
          String prgmLicensureType = (String)prgmLicensureTypesIter.next();
          boolean checked = false;
          if(selLicensureTypesList.contains(prgmLicensureType))
          {
            checked = true;
          }
          prgmLicensureTypesLoopCount++;
          String chkbxName = "PrgmLicensureTypesCbx_" + prgmLicensureTypesLoopCount;
  %>
          <td>
      <impact:validateInput
            name="<%= chkbxName %>"
            checked="<%= String.valueOf(checked) %>"
            type="checkbox"
            value="<%= String.valueOf(prgmLicensureType) %>"
            cssClass="formInput"
            label="<%= Lookup.simpleDecodeSafe(CodesTables.CPGLICTP, prgmLicensureType)%>"
            disabled="false"
            tabIndex="<%= tabIndex++ %>"/>
    </td>
    <%if (prgmLicensureTypesLoopCount % 3 == 0)
       {%>
         </tr><tr class="subDetail">
           <%}

                 } //end while
             if (prgmLicensureTypesLoopCount % 3 == 2)
                { %>
                 <td colspan="2">&nbsp;</td>
              <%}%>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
    <td align="left" valign="top" colspan="2">
      &nbsp;
    </td>
    <td align="right" valign="top" colspan="2">
       <impact:ButtonTag name="btnSave"
                             img="btnSave"
                             align="right"
                             function="return saveFacility();"
                             form="FacilityDetail"
                             action="/resource/Facility/saveFacility" tabIndex="<%=tabIndex++%>"/>
    </td>
 </tr>
</table>
<br>
</impact:validateForm>

<!-- Begin LOC Table-->
<%--
<%
  if((levelOfCareSupported != null) && (resourceType != null))
  {   
%>

<impact:validateForm name="frmAddLOC"
  method="post"
  action="/resource/Facility/modifyLOC"
  schema="/WEB-INF/Constraints.xsd"
  pageMode="<%=pageMode%>" >
  <impact:validateInput type="hidden" name="txtNmResource" value="<%=facilityName%>"/>
  <impact:validateInput type="hidden" name="txtLNbrRsrcFacilAcclaim"  value="<%=facilityNumber%>"/>
  <impact:validateInput type="hidden" name="txtNmRsrcContact" value="<%=contact%>"/>
  <impact:validateInput type="hidden" name="cboCdRsrcType"  value="<%=resourceType%>"/>
  <impact:validateInput type="hidden" name="cboCdRsrcFacilType" value="<%=facilityType%>"/>
  <!-- the following tag is a holding place for session state data -->
  <impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<% /* 18216 - added isExpanded="true"
      SIR 23890 - changed wording to service level */ %>
<impact:ExpandableSectionTag
name="locTable"
label="Room, Board and Watchful Oversight History"
isExpanded="true"
tabIndex="<%=tabIndex++%>">

        <div id="facilityDtlScroll" style="OVERFLOW: auto; WIDTH:763; HEIGHT:110px" class="tableBorder">
          <table border="0" cellspacing="0" cellpadding="3" width="100%">
            <tr>
              <th class="thList">Effective Date</th>
              <th class="thList">End Date</th>
              <th class="thList">Active</th>
              <th class="thList">Hold</th>
            </tr>
            <%
             Enumeration eLocArray= locArray.enumerateROWCRES07DO();
            if(!eLocArray.hasMoreElements())
            {
              %>
        <tr>
          <td colspan="4" class="subDetail"><%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %></td>
        </tr>
              <%
            }
            else
            {
              int loopCount = 0;
          while (eLocArray.hasMoreElements())
            {
              
                locRow=(ROWCRES07DO)eLocArray.nextElement();
                String activeLevelOfCare = getActiveLevelOfCare(locRow);
                String holdLevelOfCare = getHoldLevelOfCare(locRow);
              %>
                <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>">
                  <td><a href="javascript:modifyLevelOfCare('<%=activeLevelOfCare.substring(1)%>',
                                                            '<%=holdLevelOfCare.substring(1)%>',
                                                            '<%=FormattingHelper.formatDate(locRow.getDtDtFlocEffect())%>',
                                                            '<%if(locRow.getDtDtFlocEnd() != null){out.print(FormattingHelper.formatDate(locRow.getDtDtFlocEnd()));}%>',
                                                             <%=loopCount%>);">
                                                            <%=FormattingHelper.formatDate(locRow.getDtDtFlocEffect())%></a></td>
                  <td>
                <%
                  if(locRow.getDtDtFlocEnd() != null)
                  {
                    out.print(FormattingHelper.formatDate(locRow.getDtDtFlocEnd()));
                  }
                %></td>
                <%
                if(activeLevelOfCare.startsWith("A"))
                {
            %>
               <td><%=activeLevelOfCare.substring(1)%></td>
            <%
                } else
                {
            %>
              <td>&nbsp;</td>
            <%
                }
                if(holdLevelOfCare.startsWith("H"))
                {
            %>
               <td><%=holdLevelOfCare.substring(1)%></td>
            <%
                } else
                {
            %>
              <td>&nbsp;</td>
            <%
                }
            %>
              </tr>
            <%
              loopCount=loopCount+1;
                }//End While loop on LOCs
            }//End If cres09so != null
            %>
          </tr>
          </table>
       </div>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
     <td align="right" valign="top">
      <impact:ButtonTag name="btnAddLOC"
                        img="btnAdd"
                        align="right"
                        navAwayCk="true"
                        form="frmAddLOC"
                        action="/resource/Facility/addLOC"
                        tabIndex="<%=tabIndex++%>"/>
     </td>
    </tr>
  </table>

</impact:ExpandableSectionTag>
</impact:validateForm>
<br>
<%
    //} // end inner if
  } // end outer if
%>


<!--End <Main Content-->
<p></p>


<impact:validateForm name="modifyLOC"
  method="post"
  action="/resource/Facility/modifyLOC"
  schema="/WEB-INF/Constraints.xsd"
  pageMode="<%=pageMode%>" >

  <impact:validateInput type="hidden" name="activeLOC" id="activeLOC" />
  <impact:validateInput type="hidden" name="holdLOC" id="holdLOC" />
  <impact:validateInput type="hidden" name="pageMode" id="pageMode" />
  <impact:validateInput type="hidden" name="effectiveDate" id="effectiveDate" />
  <impact:validateInput type="hidden" name="endDate" id="endDate" />
  <impact:validateInput type="hidden" name="rownum" id="rownum" />
  <impact:validateInput type="hidden" name="txtNmResource" id="txtNmResource" value="<%=facilityName%>"/>
  <impact:validateInput type="hidden" name="txtLNbrRsrcFacilAcclaim" id="txtLNbrRsrcFacilAcclaim" value="<%=facilityNumber%>"/>
  <impact:validateInput type="hidden" name="txtNmRsrcContact" id="txtNmRsrcContact" value="<%=contact%>"/>
  <impact:validateInput type="hidden" name="cboCdRsrcType" id="cboCdRsrcType" value="<%=resourceType%>"/>
  <impact:validateInput type="hidden" name="cboCdRsrcFacilType" id="cboCdRsrcFacilType" value="<%=facilityType%>"/>
  <impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>


<%!
  public static String getActiveLevelOfCare( ROWCRES07DO locRow)
  {
    StringBuffer sbLOC = new StringBuffer();
    String decodedLOC = new String();
    String locDecodes = new String();
    org.exolab.castor.types.Date effectiveDate = locRow.getDtDtFlocEffect();
    locDecodes = null;
    boolean hasB = false;
    boolean hasM = false;

    if("A".equals(locRow.getCCdFlocStatus1()) )
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "01");
      sbLOC.append(" ").append(decodedLOC);
    }
    
    if("A".equals(locRow.getCCdFlocStatus2()))
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "02");
      sbLOC.append(" ").append(decodedLOC);
    }
    
    if("A".equals(locRow.getCCdFlocStatus3()))
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "03");
      sbLOC.append(" ").append(decodedLOC);
    }
    
    if("A".equals(locRow.getCCdFlocStatus4()))
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "04");
      sbLOC.append(" ").append(decodedLOC);
    }
    
    if("A".equals(locRow.getCCdFlocStatus5()))
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "05");
      sbLOC.append(" ").append(decodedLOC);
    }
    
    if("A".equals(locRow.getCCdFlocStatus6()))
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "06");
      sbLOC.append(" ").append(decodedLOC);
    }
    
    if("A".equals(locRow.getCCdFlocStatus7()))
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "0A");
      sbLOC.append(" ").append(decodedLOC);
    }

    if("A".equals(locRow.getCCdFlocStatus8()))
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "100");
      sbLOC.append(" ").append(decodedLOC);
    }

    if("A".equals(locRow.getCCdFlocStatus9()))
    {
      decodedLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "110");
      sbLOC.append(" ").append(decodedLOC);
    }


    locDecodes = sbLOC.toString();
    if(!(locDecodes.equals(null)))
    {
      locDecodes = "A"+locDecodes;
    }
    return locDecodes;
  }

  public String getHoldLevelOfCare( ROWCRES07DO locRow)
  {
    StringBuffer sbHoldLOC = new StringBuffer();
    String decodedHoldLOC = new String();
    String locHoldDecodes = new String();
    org.exolab.castor.types.Date effectiveDate = locRow.getDtDtFlocEffect();
    locHoldDecodes = null;
    boolean hasB = false;
    boolean hasM = false;

    if("H".equals(locRow.getCCdFlocStatus1()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "01");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }
    
    if("H".equals(locRow.getCCdFlocStatus2()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "02");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }
    
    if("H".equals(locRow.getCCdFlocStatus3()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "03");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }
    
    if("H".equals(locRow.getCCdFlocStatus4()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "04");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }
    
    if("H".equals(locRow.getCCdFlocStatus5()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "05");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }
    
    if("H".equals(locRow.getCCdFlocStatus6()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "06");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }
    
    if("H".equals(locRow.getCCdFlocStatus7()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "0A");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }

    if("H".equals(locRow.getCCdFlocStatus8()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "100");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }

    if("H".equals(locRow.getCCdFlocStatus9()))
    {
      decodedHoldLOC = Lookup.simpleDecodeSafe("CLVOFCRE", "110");
      sbHoldLOC.append(" ").append(decodedHoldLOC);
    }

    locHoldDecodes = sbHoldLOC.toString();
    if(!(locHoldDecodes.equals(null)))
    {
      locHoldDecodes = "H"+locHoldDecodes;
    }
    return locHoldDecodes;
  }

  public static String getHomeLevelOfCare( CRES02SOG01 homeRow)
  {
    StringBuffer sbLOC2 = new StringBuffer();
    String decodedLOC2 = new String();
    String locDecodes2 = new String();
    org.exolab.castor.types.Date effectiveDate = homeRow.getDtDtFlocEffect();
    locDecodes2 = null;
    boolean hasB = false;
    boolean hasM = false;

    if("A".equals(homeRow.getCCdFlocStatus1()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "010");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    
    if("A".equals(homeRow.getCCdFlocStatus2()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "020");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    
    if("A".equals(homeRow.getCCdFlocStatus3()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "030");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    
    if("A".equals(homeRow.getCCdFlocStatus4()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "040");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    
    if("A".equals(homeRow.getCCdFlocStatus5()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "050");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    
    if("A".equals(homeRow.getCCdFlocStatus6()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "060");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    
    if("A".equals(homeRow.getCCdFlocStatus7()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "090");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    if("A".equals(homeRow.getCCdFlocStatus8()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "100");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    if("A".equals(homeRow.getCCdFlocStatus9()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "110");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    if("A".equals(homeRow.getCCdFlocStatus10()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "010");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    if("A".equals(homeRow.getCCdFlocStatus11()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "011");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    if("A".equals(homeRow.getCCdFlocStatus12()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "012");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    if("A".equals(homeRow.getCCdFlocStatus13()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "013");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    if("A".equals(homeRow.getCCdFlocStatus14()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "014");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    if("A".equals(homeRow.getCCdFlocStatus15()))
    {
      decodedLOC2 = Lookup.simpleDecodeSafe("CLVOFCRE", "015");
      sbLOC2.append(" ").append(decodedLOC2);
    }
    locDecodes2 = sbLOC2.toString();
    return locDecodes2;
  }
%> --%>

