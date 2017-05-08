<%
/**  JSP Name:     PortalChildList
  *  Created by:   Patrick Coogan
  *  Date Created: October 2009
  *
  *  Description:
  *  This JSP displays the Portal Child List for users logged into the SHINES Vendor 
  *  Portal implemented as a part of ECEM initiatives.  It will show all children in 
  *  all resources to which a user is assigned, or depending on the mode will show only
  *  children for a specific resource.
  *  This page is based off of the Placement Log page in SHINES.
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  11/12/09    Patrick Coogan    Updated comments for ECEM implementation. 
  */

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.PortalChildListConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats" %>


<%
  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //HttpServletRequest request = context.getRequest();
  //Set the page mode
  //String pageMode =  (String) request.getAttribute("pageMode" );//PageModeConstants.VIEW;
   String pageMode = PageMode.getPageMode(request);

     // create the output object
    CFAD31SO cfad31so = ( CFAD31SO ) request.getAttribute( "CFAD31SO" );
  
     //initialize the array
    CFAD31SOG00_ARRAY placementLogArray = null;
     //null catch
    if ( cfad31so == null )
    {
      cfad31so = new CFAD31SO() ;
    }
     //null catch for row objects, if not null, get rows
    if ( cfad31so.getCFAD31SOG00_ARRAY() != null )
    {
      placementLogArray = cfad31so.getCFAD31SOG00_ARRAY();
    }  else
    {
      placementLogArray = new CFAD31SOG00_ARRAY();
    }

  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  // used to hide the reports section if no results returned
  boolean bResults = true;
  UserProfile user = UserProfileHelper.getUserProfile ( request );
%>
<script language="JavaScript">
function displayPortalPersonDetail( idPerson, idStage, idCase, idPlcmtEvent )
{
  document.frmPortalChildList.hdnUlIdPerson.value = idPerson;
  document.frmPortalChildList.hdnUlIdStage.value = idStage;
  document.frmPortalChildList.hdnUlIdCase.value = idCase;
  document.frmPortalChildList.hdnUlIdPlcmtEvent.value = idPlcmtEvent;
  disableValidation('frmPortalChildList');
  submitValidateForm( "frmPortalChildList", "/person/PortalChildDetail/displayPortalChildDetail" );
}
</script>

  <impact:validateErrors/>
  <impact:validateForm
       name="frmPortalChildList"
       method="post"
       action="/workload/PortalChildList/displayChildList"
       validationClass="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"
       pageMode="<%=pageMode%>"
       schema="/WEB-INF/Constraints.xsd">
<% // begin pagination

  TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean) request.getAttribute(
          PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

  if (tuxPagination != null) {
    DatabaseResultDetails db = tuxPagination.getResultDetails();
  } else {
    tuxPagination = new TuxedoPaginationValueBean();
    DatabaseResultDetails db = new DatabaseResultDetails();
    db.setNumberOfResults(0);
    db.setResultsPerPage(100); //SIR 19651 changed from 10 to 100
    db.setRequestedPage(1);
    tuxPagination.setResultDetails(db);
    request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
  }
  CurrPlacementStats currPlacementStats = cfad31so.getCurrPlacementStats();
  if (currPlacementStats == null) {
  	currPlacementStats = new CurrPlacementStats();
  }
  String cldrnUnderAge3 = String.valueOf(currPlacementStats.getNbrChldrnUnder3());
  String cldrnOverAge16 = String.valueOf(currPlacementStats.getNbrChldrnOver16());
  String malesInHome = String.valueOf(currPlacementStats.getNbrMalesInHome());
  String femalesInHome = String.valueOf(currPlacementStats.getNbrFemalesInHome());
  String cldrnRecvingLocFund = String.valueOf(currPlacementStats.getNbrChldrnWithLOCFllng());
%>

<%
String submitUrl = "";

if (!("".equals(GlobalData.getUlIdParentRsrcAsString(request)))&&!("0".equals(GlobalData.getUlIdParentRsrcAsString(request)))){
submitUrl="/workload/PortalChildList/displayChildList";
} else {
submitUrl= "/workload/PortalChildList/displayChildListAll";
}
%>

<impact:ifThen test='<%= (!("".equals(GlobalData.getUlIdParentRsrcAsString(request))||"0".equals(GlobalData.getUlIdParentRsrcAsString(request))))%>'>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
  <tr>
    <th colspan="4">Current Placement Statistics</th>
  </tr>
  <tr>
    <td class="formLabel" height="25">Children Under Age 3: <%=cldrnUnderAge3%></td>
    <td class="formLabel" height="25">Children Over Age 16: <%=cldrnOverAge16%></td>
  </tr>
  
  <tr>
    <td class="formLabel" height="25"># Males In Home: <%=malesInHome%></td>
    <td class="formLabel" height="25"># Females In Home: <%=femalesInHome%></td>
  </tr>
 
</table> 
</impact:ifThen>
<impact:pagination submitUrl="<%=submitUrl%>">
<div class="alignRight">
  <div class="formInstruct">Scroll for more information --></div>
</div>
<div id="scrollBar2" style="height:300px;width:763px;overflow:auto" class="tableborderList">


       <%-- establish the table used to display the data returned from the service --%>
       <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width = "200%">
         <tr>
             <th class="thList">Person</th>
             <th class="thList"></th>
             <th class="thList">Case</th>
             <th class="thList"></th>
             <th class="thList"></th>
             <th class="thList"></th>
             <th class="thList">Resource</th>
             <th class="thList">Resource</th>
             <th class="thList">Placement</th>
             <th class="thList">End</th>
             <th class="thList">Removal</th>
             <th class="thList">Placement</th>
             <th class="thList">Sibling</th>
             <th class="thList">Legal</th>
             <th class="thList">RBWO</th>
             <th class="thList">RBWO</th>
             <th class="thList">Waiver</th>
         </tr>
         <tr>
            <th class="thList">ID</th>
             <th class="thList">Name&nbsp;
              <impact:sortableColumnHeader orderBy="<%= PortalChildListConversation.SORT_C %>"/>
             </th>
             <th class="thList">ID</th>
             <th class="thList">Gender</th>
             <th class="thList">DOB</th>
             <th class="thList">Age</th>
             <th class="thList">Name</th>
             <th class="thList">ID</th>
             <th class="thList">Date&nbsp;
              <impact:sortableColumnHeader orderBy="<%= PortalChildListConversation.SORT_P %>"/>
             </th>
             <th class="thList">Date&nbsp;
              <impact:sortableColumnHeader orderBy="<%= PortalChildListConversation.SORT_E %>"/>
             </th>
             <th class="thList">Rsn.&nbsp;
              <impact:sortableColumnHeader orderBy="<%= PortalChildListConversation.SORT_R %>"/>
             </th>
             <th class="thList">Type</th>
             <th class="thList">Placmnt.</th>
             <th class="thList">County</th>
             <th class="thList">Program</th>
             <th class="thList">Per Diem</th>
             <th class="thList">Rate</th>
         </tr> 
              
                  <% // within the table, display the data
                    //Enumerate the placement rows
              Enumeration placementLogEnum = placementLogArray.enumerateCFAD31SOG00();


            //If the enumeration is empty return NO Rows returned message
          if ( !placementLogEnum.hasMoreElements() )
             {
             bResults = false;
%>
              <tr class="odd">
                 <td colspan="7">
                  <%=  MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %>
                 </td>
              </tr>
               <%
             }  // else there is a least one row.  While there are more rows, create a new rows and display the data
          else
             {
               while( placementLogEnum.hasMoreElements() )
                  {     // get the next element
                     CFAD31SOG00 placementRow = ( CFAD31SOG00 ) placementLogEnum.nextElement();
                        // create the cells and place the elements in them
                 %>
         <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="center">
             <td>
                <%= FormattingHelper.formatLong( placementRow.getUlIdPerson() )%>
                </td>
                <td><a href="javascript:displayPortalPersonDetail('<%=FormattingHelper.formatString(String.valueOf(placementRow.getUlIdPerson()))%>','<%=FormattingHelper.formatString(String.valueOf(placementRow.getUlIdStage()))%>','<%=FormattingHelper.formatString(String.valueOf(placementRow.getUlIdCase()))%>','<%=FormattingHelper.formatString(String.valueOf(placementRow.getUlIdPlcmtEvent()))%>');">
                                                            <%=FormattingHelper.formatString(placementRow.getSzNmPersonFull())%></a></td>
                
                
             <%-- <td><%=FormattingHelper.formatString(placementRow.getSzNmPersonFull())%></td> --%>
                
                <td>
                <%= FormattingHelper.formatLong( placementRow.getUlIdCase())%>
                </td>
                <td>
                <%= FormattingHelper.formatString( placementRow.getCdPersonSex())%>
                </td>
                <td>
                <%= FormattingHelper.formatDate( placementRow.getDtDtPersonBirth() )%>
                </td>
                <td>
                <%= FormattingHelper.formatLong( placementRow.getNbrPersonAge() )%>
                </td>
                <td>
                <%= FormattingHelper.formatString( placementRow.getNmPlcmtFacil() )%>
                </td>
                <td>
                <%= FormattingHelper.formatLong( placementRow.getUlIdRsrcFacil() )%>
                </td>
                <td>
                <%= FormattingHelper.formatDate( placementRow.getDtDtPlcmtStart() )%>
                </td>
                <td>
                <%= FormattingHelper.formatDate( placementRow.getDtDtPlcmtEnd() )%>
                </td>
                <td>
                <%= FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CRMRSNAC", placementRow.getSzCdPlcmtRemovalRsn() ) )%>
                </td>
                <td>
                <%= FormattingHelper.formatString( 
                	  Lookup.simpleDecodeSafe("CPLMNTYP",placementRow.getCdPlcmtType()))%>
                </td>
               
                <td align="center">
                  <%if("Y".equalsIgnoreCase(placementRow.getSzSblngPlcmt()) ){%>
                    <!-- <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" >  -->
                    <FONT size="3"><B>Y</B></FONT>
                  <%}else{%>
                    &nbsp;
                  <%}%>
                </td>
                
                <%--<td><%= FormattingHelper.formatString( placementRow.getSzSblngPlcmt())%></td> --%>
                <td>
                <%= FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CCOUNT", placementRow.getCdLegalStatCnty() ) )%>
                </td>
                
                <impact:ifThen test='<%= ("Y".equals(placementRow.getSzIndCci())||"N".equals(placementRow.getSzIndCci()))%>'>
                <td>
                <impact:ifThen test='<%= ("Y".equals(placementRow.getSzIndCci()))%>'>
                <%= FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CRBPROGI", placementRow.getSzCdRbwoProg() ) )%>
                </impact:ifThen>
                <impact:ifThen test='<%= ("N".equals(placementRow.getSzIndCci()))%>'>
                <%= FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CRBPROGA", placementRow.getSzCdRbwoProg() ) )%>
                </impact:ifThen>
                </td>
                 <td>
                <%= FormattingHelper.formatMoney(placementRow.getDPerDiem())%>
                </td>
                 <td>
                <%= FormattingHelper.formatMoney(placementRow.getDWaiverRate())%>
                </td>
                </impact:ifThen>
                <impact:ifThen test='<%= ("".equals(placementRow.getSzIndCci())||placementRow.getSzIndCci()==null)%>'>
                <td>
                &nbsp;
                </td>
                 <td>
                &nbsp;
                </td>
                 <td>
                &nbsp;
                </td>
                </impact:ifThen>
         </tr>
         <%// increment the loop counter
               loopCount++;
             } // end while
           } //end else, end if
          %>

        </table>
    </div>
</impact:pagination>

         <%-- end of pagination and the table used to display the data returned from the service --%>
<br/>

     <impact:validateInput type="hidden" name="hdnUlIdCase" value="" />
     <impact:validateInput type="hidden" name="hdnUlIdStage" value=""/>
     <impact:validateInput type="hidden" name="hdnUlIdPerson" value=""/>
     <impact:validateInput type="hidden" name="hdnUlIdPlcmtEvent" value=""/>
    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>




