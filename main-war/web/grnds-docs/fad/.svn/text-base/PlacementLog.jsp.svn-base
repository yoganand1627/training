<%
/**  JSP Name:     PlacementLog
  *  Created by:   katy Laura
  *  Date Created: 02/20/03
  *
  *  Description:
  *  This JSP displays the placement history of a facility.
  *  The page displays using multiple sort values.  The initial sort shows current placements
  *  ( those having  open end dates  ) ordered by most recent start date ( start dates in descending
  *  order ); followed by past placements ( those having non null, non 12/31/4712 end dates ) in
  *  descending order ( most recent placement);
  *  Additional sort fields are name, start date ( most recent first ), end date ( most recent first ),
  *  and removal reason.
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------    --------------------------------------------------
  *  6/29/04    gerryc            SIR 19651 - added column for a check mark to
  *                               indicate if the person's most recent legal status
  *                               is adoption consummated.  Also changed the results
  *                               to show 100 per page instead of 10.
  *  7/14/08	wjcochran         STGAP00009512 - Removed the column that indicates if
  *                               the person's most recent legal status is 
  *                               adoption consumated.
  *  4/08/09    wjcochran         STGAP00012984 - Added a null check on the CurrPlacementStats
  *                               object to prevent a NullPointerException
  *  11/12/09   pcoogan           ECEM: Moved pagination outside of div for better form factor
                                  and expanded width of div for better look and feel
     09/12/11   charden           STGAP00017058 - added code to display characteristics grouping section
  */

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementLogSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.PlacementLogConversation" %>
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
    PlacementLogSO placementLogSO = (PlacementLogSO) request.getAttribute("placementLogSO");

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
  
  // get objects for child characteristics
  int delinquency = placementLogSO.getNumChildrenDelinquent();
  int numChildren = placementLogSO.getNumChildrenInHome();
  List<String> characteristicGroupList = placementLogSO.getCharacteristicGroupList();
  Map<String, Map<String, Integer>> characteristicsGroupMap = placementLogSO.getCharacteristicsGroupMap();
%>
<script language="JavaScript">
function displayPersonDetail( idPerson )
{
  document.frmPlacementLog.hdnUlIdPerson.value = idPerson;
  disableValidation('frmPlacementLog');
  submitValidateForm( "frmPlacementLog", "/person/PersonSearch/displayPersonDetail" );
}
</script>

  <impact:validateErrors/>
  <impact:validateForm
       name="frmPlacementLog"
       method="post"
       action="/fad/PlacementLog/displayPlacementLog"
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
//SIR 19651 - set url based on if it is in resource or search context.  This
//will allow for the correct screen definitions to be loaded.  Case context
//should show Case Name, Resource context should show Resource Name
String submitUrl = "";
if (GlobalData.getSzNmCase(request) != null && !"".equals(GlobalData.getSzNmCase(request).trim()) )
{
  submitUrl="/fad/PlacementLog/displayPlacementLog";
}
else
{
  submitUrl="/resource/PlacementLog/displayPlacementLog";
}

%>
<input type="hidden" name="hdnUlIdPerson" value="" />
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
  
<%--  <tr><td class="formLabel" height="25"># Children Receiving LOC Funding:<%=cldrnRecvingLocFund%></td></tr> --%>
</table> 
<br>
<impact:pagination submitUrl="<%=submitUrl%>">
<div class="alignRight">
  <div class="formInstruct">Scroll for more information --></div>
</div>
<div id="scrollBar2" style="height:210px;width:763px;overflow:auto" class="tableborderList">


       <%-- establish the table used to display the data returned from the service --%>
       <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="150%" >
         <tr>
             <th class="thList">Person</th>
             <th class="thList"></th>
             <th class="thList">Case</th>
             <th class="thList"></th>
             <th class="thList"></th>
             <th class="thList"></th>
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
              <impact:sortableColumnHeader orderBy="<%= PlacementLogConversation.SORT_C %>"/>
             </th>
             <th class="thList">ID</th>
             <th class="thList">Gender</th>
             <th class="thList">DOB</th>
             <th class="thList">Age</th>
             <th class="thList">Date&nbsp;
              <impact:sortableColumnHeader orderBy="<%= PlacementLogConversation.SORT_P %>"/>
             </th>
             <th class="thList">Date&nbsp;
              <impact:sortableColumnHeader orderBy="<%= PlacementLogConversation.SORT_E %>"/>
             </th>
             <th class="thList">Rsn.&nbsp;
              <impact:sortableColumnHeader orderBy="<%= PlacementLogConversation.SORT_R %>"/>
             </th>
             <th class="thList">Type</th>
             <th class="thList">Placmnt.</th>
             <th class="thList">County</th>
             <th class="thList">Program</th>
             <th class="thList">Rate</th>
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
                <td><a href="javascript:displayPersonDetail('<%=FormattingHelper.formatString(String.valueOf(placementRow.getUlIdPerson()))%>');">
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

 <!-- STGAP00017058 - creating characteristics grouping section -->
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
  <tr>
    <th colspan="4">Child Characteristics Currently in the Home</th>
  </tr>
  <% 
  if(delinquency != 0){
  %>
    <tr>
    	<td>&nbsp;&nbsp;&nbsp;&nbsp;History of Juvenile Delinquency&nbsp;(<%= delinquency %>)</td>
    </tr>
  <% 
  }
  
  // write out message if there are no characteristics in the home
  if(numChildren > 0 && characteristicGroupList.isEmpty() && delinquency == 0){
  %>
  	<tr>
  		<td>There are no characteristics exhibited by the children currently placed in the home.</td>
  	</tr>
  <%
  }
  
  // sort and write out categories
  if(characteristicGroupList != null){
  	Collections.sort(characteristicGroupList);
  }
  for(String category : characteristicGroupList){
  	Map<String, Integer> characteristicsMap = characteristicsGroupMap.get(category);
  %>
  	<tr>
  		<th colspan="4" style="border-top: solid #c8c699 1px;">&nbsp;&nbsp;&nbsp;<%= Lookup.simpleDecodeSafe("CCHRTCA1", category) %></th>
  	</tr>
  <% 
    // write out characteristics
    int i = 0;
    List<String> charList = new ArrayList<String>();
    Set<String> charSet = characteristicsMap.keySet() != null ? characteristicsMap.keySet() : new HashSet<String>();
    charList.addAll(charSet);
    Collections.sort(charList);
    for(String characteristic : charList){
    	if(i % 2 == 0){
  %>
  			<tr><td width="50%" align="left"><%= characteristic %>&nbsp;(<%= characteristicsMap.get(characteristic) %>)</td>
  <% 
  		}else{
  %>
  			<td width="50%" align="left"><%= characteristic %>&nbsp;(<%= characteristicsMap.get(characteristic) %>)</td></tr>
  <%
  		}
  		i++;
  	}
  	
  	// close row if number of items in cateogry is an odd number
  	if(i % 2 != 0){
  %>
 			</tr>
  <%
  	}
  }
  %>
 </table>
 <!-- End STGAP00017058 -->
     <impact:validateInput type="hidden" name="ulIdResource" value='<%= ContextHelper.getStringSafe( request, "ulIdResource" )%>' />
     <impact:validateInput type="hidden" name="ulIdStage" value="<%= String.valueOf( GlobalData.getUlIdStage( request) )%>"/>
    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>




