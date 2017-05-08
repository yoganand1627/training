<%
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
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.contacts.PortalContactDetailConversation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
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
%>

<%--
<script type="text/Javascript" language="JavaScript1.2">
var vics = 0;
var perps = 0;

<impact:codeArray codeName="CCNTPURP"
                  excludeOptions="<%= excludePurpose %>"
                  arrayName="CCNTPURP"
                  blankValue="true"
                  orderBy="decode"/>

<impact:codeArray codeName="COTHCNCT"
                  arrayName="COTHCNCT"
                  blankValue="true"
                  orderBy="decode"/>

<impact:codeArray codeName="CCNCTLOC"
                  arrayName="CCNCTLOC"
                  blankValue="true"
                  orderBy="decode"/>


function populatePurpose()
{
  String key = PortalContactDetailConversation.getPurposeKey(request);
  if (key != null)
  {
    out.println("  populateFilteredDropdown('" + key + "', frmContactDetail.selSzCdContactPurpose, CCNTPURP, true);");
    out.println("  frmContactDetail.selSzCdContactPurpose.value='" + _selSzCdContactPurpose + "';");
  }
}


function populateLocation()
{
  if( frmContactDetail.selSzCdContactMethod.value == "" ||
      frmContactDetail.selSzCdContactMethod.value == "<%= CodesTables.CCNTMETH_LRC %>" ||
      frmContactDetail.selSzCdContactMethod.value == "<%= CodesTables.CCNTMETH_LST %>" ||
      frmContactDetail.selSzCdContactMethod.value == "<%= CodesTables.CCNTMETH_TCF %>" ||
      frmContactDetail.selSzCdContactMethod.value == "<%= CodesTables.CCNTMETH_TCT %>" )
  {
    clearDropdown(frmContactDetail.selSzCdContactLocation);
  }
  else
  {
    populateDropdown(frmContactDetail.selSzCdContactLocation, "", CCNCTLOC);
  }
  frmContactDetail.selSzCdContactLocation.value = '<%= _selSzCdContactLocation %>';
}


function populateOthers()
{
<%
{
  String key = PortalContactDetailConversation.getOthersKey(request);
  // If none of the program/stage combinations match the expected results,
  // display an error message
  if (key != null)
  {
    out.println("  populateFilteredDropdown('" + key + "', frmContactDetail.selSzCdContactOthers, COTHCNCT, true);");
    out.println("  frmContactDetail.selSzCdContactOthers.value='" + _selSzCdContactOthers + "';");
  }
}
%>
}
--%>

<script type="text/Javascript" language="JavaScript1.2">
var vics = 0;
var perps = 0;

function checkPersRole( szCdPersRole, szCdStagePersRelInt, checked )
{
  //Check to see if the role is Alleged or Designated Perpertrator
  if( (szCdPersRole == "<%= CodesTables.CROLEALL_AP %>") ||
      (szCdPersRole == "<%= CodesTables.CROLEALL_DP %>") )
  {
    if( checked )
    {
      perps++;
    }
    else
    {
      perps--;
    }
    if( perps > 0 )
    {
      document.frmContactDetail.hdnBPerpSelected.value = "Y";
    }
    else
    {
      document.frmContactDetail.hdnBPerpSelected.value = "N";
    }
  }
  //SIR 18433 - A "No Role" and "Self" counts as a victim
  //Check to see if the role is Alleged or Designated Victim
  if( (szCdPersRole == "<%= CodesTables.CROLEALL_VC %>") ||
      (szCdPersRole == "<%= CodesTables.CROLEALL_DV %>") ||

      ((szCdStagePersRelInt == "<%= CodesTables.CRPTRINT_SL %>") &&
       ((szCdPersRole == "<%= CodesTables.CROLEALL_NO %>") ||
        (szCdPersRole == "<%= CodesTables.CROLEALL_UK %>"))) )
  {
    if( checked )
    {
      vics++;
    }
    else
    {
      vics--;
    }
  }
  if( vics > 0 )
  {
    document.frmContactDetail.hdnBVictimSelected.value = "Y";
  }
  else
  {
    document.frmContactDetail.hdnBVictimSelected.value = "N";
  }
}
</script>

<impact:validateInput type="hidden" name="hdnBVictimSelected" value="N"/>
<impact:validateInput type="hidden" name="hdnBPerpSelected" value="N"/>

<%-- /* Do not add a table tag here, the including file will already have one */ --%>
<%-- This attribute removed from Purpose, Method, Location, Others Contacted {style="width: 150px"} --%>
<%-- <table> --%>
<tr>
  <td width="20%">
    <!--SIR 23835 added exclude options -->
    <impact:validateSelect label="Method"
                           name="selSzCdContactMethod"
                           required="true"
                           disabled="<%= String.valueOf( methodDisabled ) %>"
                           colspan="4"
                           options="<%= PortalContactDetailConversation.getMethodOptions(request, true) %>"
                           value="<%= _selSzCdContactMethod %>"
                           tabIndex="<%= _tabIndex++ %>"
                           editableMode="<%= EditableMode.DEFAULT %>"/>
  </td>
</tr>
<tr>
  <td>
    <impact:validateSelect label="Location"
                           name="selSzCdContactLocation"
                           codesTable="CCNCTLOC"
                           disabled="<%= String.valueOf( locationDisabled ) %>"
                           conditionallyRequired="true"
                           value="<%= _selSzCdContactLocation %>"
                           tabIndex="<%= _tabIndex++ %>"
                           editableMode="<%= EditableMode.DEFAULT %>"/>
  </td>
  
  
  <td>
    <impact:validateInput label="Name of Agency"
                          tabIndex="<%= _tabIndex++ %>"
                          type="text"
                          name="szNmAgencyName"
                          constraint="Name20"
                          disabled="<%= modifyDisabled %>"
                          editableMode="<%= EditableMode.DEFAULT %>"
                          conditionallyRequired="true"
                          value="<%= _csys08so.getSzNmAgencyName() %>" />
  </td>
 </tr> 
  
 <tr> 
  <td>
    <impact:validateSelect label="Others Contacted"
                           name="selSzCdContactOthers"
                           codesTable="COTHCNCT"
                           disabled="<%= String.valueOf( otherDisabled ) %>"
                           conditionallyRequired="true"
                           value="<%= _selSzCdContactOthers %>"
                           tabIndex="<%= _tabIndex++ %>"
                           editableMode="<%= EditableMode.DEFAULT %>"/>
  </td>
  <td colspan="4">
    <impact:validateInput
      name="chkCrossCountyLines"
      type="checkbox"
      label="Permission to cross county lines"
      disabled="<%= String.valueOf( otherDisabled ) %>"
      checked="<%= Boolean.toString(_chkCrossCountyLines) %>"
      tabIndex="<%= _tabIndex++ %>"
    />
  </td>
</tr>



<br>

  <%
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
    %>
<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
	<th>
		<span class="formRequiredText">*</span>Purpose 
	</th>
</tr>
<tr>
   <td> <impact:codesCheckbox 
                name="cbxContactPurpose"
                columns="3"
                codesTableName="<%= CodesTables.CCNTPURP %>"
                disabled="<%= String.valueOf( purposeDisabled ) %>"          
                defaultCodes="<%= checkedPurposeList %>"   
                tabIndex="<%= _tabIndex++ %>"
                />
  
    </td>
</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th colspan="4"> Principals/Collaterals Contacted</th>
</tr>
<tr>
  <td colspan="4"><impact:pagination
          submitUrl="/contacts/PortalContactDetail/displayContact"
          saveState="false">
  </td>
</tr>
<tr class="subDetail">
  <td width="100%" class="formlabel">
    <div id="scroll3" style="width:100%; height:125px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList" width="20%">Name</th>
          <th class="thList" width="20%">Type</th>
          <th class="thList" width="20%">Role</th>
          <th class="thList" width="20%">Relation/Interest</th>
          <th class="thList" width="20%">Private <br> Conversation</th>
          <th class="thList" width="20%">Discussed/In Reference To</th>
        </tr>
        <tr>
          <%
            ROWCSYS08SO_ARRAY rowcsys08soArray = _csys08so.getROWCSYS08SO_ARRAY();
            if( rowcsys08soArray == null )
            {
              rowcsys08soArray = new ROWCSYS08SO_ARRAY();
            }

            Enumeration csys08soEnumeration = rowcsys08soArray.enumerateROWCSYS08SO();

            if( !csys08soEnumeration.hasMoreElements() )
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
          %>
          <td><impact:validateInput
                  tabIndex="<%= _tabIndex++ %>"
                  type="checkbox"
                  checked="<%= indContactOccurred %>"
                  value='<%= String.valueOf(csys08soRow.getUlIdPerson()) %>'
                  name="<%= cbxName %>"
                  disabled="<%= modifyDisabled %>"
                  onClick="<%= clickCommand %>"
                  editableMode="<%= EditableMode.DEFAULT %>"/>

            <%= FormattingHelper.formatString( csys08soRow.getSzNmPersonFull() ) %>
          </td>
          <td><%= Lookup.simpleDecodeSafe( "CPRSNTYP", csys08soRow.getSzCdStagePersType() ) %></td>
          <td><%= Lookup.simpleDecodeSafe( "CINVROLE", _szCdStagePersRole ) %></td>
          <td><%= Lookup.simpleDecodeSafe( "CRPTRINT", _szCdStagePersRelInt ) %></td>
          
        <%String cbxNamePrivConver = "cbxPrivConver" + ( i + 1 );
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
         %>
           
          <td><impact:validateInput
                  tabIndex="<%= _tabIndex++ %>"
                  type="checkbox" name= "<%=cbxNamePrivConver%>" checked="<%= szCheckedPrivConver%>"
                  disabled="<%= modifyDisabled %>"
                  value='<%= String.valueOf(i) %>'
                  editableMode="<%= EditableMode.DEFAULT %>"/>
          </td>

          <% // SMS #109398: MR-086
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
         %>
          
          <td><impact:validateInput
                  tabIndex="<%= _tabIndex++ %>"
                  type="checkbox" name= "<%=cbxDiscussed%>" checked="<%= szCheckedDiscussed%>"
                  disabled="<%= modifyDisabled %>"
                  value='<%= String.valueOf(i) %>'
                  editableMode="<%= EditableMode.DEFAULT %>"/>
          </td>
          <%-- End SMS #109398: MR-086 --%>
          
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
  <td colspan="4"></impact:pagination></td>
</tr>
<%-- SIR 24025 - Removed closing table tag as this JSP is included in ContactDetail and closing the table here will cause the page to display wrong. --%>

<%-- Removed Javascript
  // SIR 19020 - Added _pageMode != VIEW to if statement to prevent a JS error
  // because if the page is in view mode you can't populate or clear dropdowns.
  // SIR 23410 - For CLES and CLEV Contract Type don't filter/populate/Clear dropdown
  // because the fields are disabled.
<impact:ifThen test="<%= !_pageMode.equals(PageModeConstants.VIEW) %>">
  <%
  if (!purposeDisabled)
  {
  %>
  populatePurpose();
  CleanSelect(frmContactDetail.selSzCdContactPurpose);
  <%
  }
  if (!otherDisabled)
  {
  %>
  populateOthers();
  CleanSelect(frmContactDetail.selSzCdContactOthers);
  <%
  }
  if (!locationDisabled)
  {
  %>
  populateLocation();
  CleanSelect(frmContactDetail.selSzCdContactLocation);
  <%
  }
  %>
  </impact:ifThen>
--%>

<script type="text/javascript" language="JavaScript1.2">
  //SIR 18433 - set Javascript vics and purps to correct values, if needed.
  <impact:ifThen test="<%= (vics > 0) %>">
  document.frmContactDetail.hdnBVictimSelected.value = "Y";
  vics = <%= vics %>;
  </impact:ifThen>
  <impact:ifThen test="<%= (perps > 0) %>">
  document.frmContactDetail.hdnBPerpSelected.value = "Y";
  perps = <%= perps %>;
  </impact:ifThen>
</script>
<%
    request.setAttribute( "tabIndex", _tabIndex );
  }
%>
