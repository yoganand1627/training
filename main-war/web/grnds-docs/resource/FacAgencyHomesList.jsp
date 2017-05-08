<%
/**  JSP Name:     Facility/Agency - Homes List
  *  Created by:   Patrick Coogan   
  *  Date Created: Octoberish 2009
  *
  *  Description:
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  11/09/09    Patrick Coogan    Updated comments.
  */

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.FacAgencyHomesListConversation" %>


<%
  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String pageMode = PageMode.getPageMode(request);

     // create the output object
    RetrieveFacAgencyHomesListSO retrieveFacAgencyHomesListSO = ( RetrieveFacAgencyHomesListSO ) request.getAttribute( "retrieveFacAgencyHomesListSO" );
  
     //initialize the array
    List<RetrieveFacAgencyHomesListBean> retrieveFacAgencyHomesList = new ArrayList<RetrieveFacAgencyHomesListBean>();
     //null catch
    if ( retrieveFacAgencyHomesListSO == null )
    {
      retrieveFacAgencyHomesListSO = new RetrieveFacAgencyHomesListSO() ;
    }
     //null catch for row objects, if not null, get rows
    if ( retrieveFacAgencyHomesListSO.getFacilityAgencyList() != null )
    {
      retrieveFacAgencyHomesList = retrieveFacAgencyHomesListSO.getFacilityAgencyList();
    } 

  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  UserProfile user = UserProfileHelper.getUserProfile ( request );
%>
<script language="JavaScript">
function displayChildList( idResource )
{
  if ((document.frmFacAgencyHomesList.hdnUlIdRsrcParent.value == "")||(document.frmFacAgencyHomesList.hdnUlIdRsrcParent.value == "0")) {
     document.frmFacAgencyHomesList.hdnUlIdRsrcParent.value = idResource;
  } else {
     document.frmFacAgencyHomesList.hdnUlIdRsrcChild.value = idResource;
  }
  
  disableValidation('frmFacAgencyHomesList');
  submitValidateForm( "frmFacAgencyHomesList", "/workload/PortalChildList/displayChildList" );
}
</script>

  <impact:validateErrors/>
  <impact:validateForm
       name="frmFacAgencyHomesList"
       method="post"
       action="/resource/FacAgencyHomesList/displayFacAgencyHomesList"
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
    db.setResultsPerPage(20); 
    db.setRequestedPage(1);
    tuxPagination.setResultDetails(db);
    request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
  }
  
%>

<%

String submitUrl = "";

if (!("".equals(GlobalData.getUlIdParentRsrcAsString(request)))&&!("0".equals(GlobalData.getUlIdParentRsrcAsString(request)))){
submitUrl="/resource/FacAgencyHomesList/displayHomesList";
} else {
submitUrl= "/resource/FacAgencyHomesList/displayFacAgencyList";
}
%>
<input type="hidden" name="hdnUlIdResource" value="" />
<impact:pagination submitUrl="<%=submitUrl%>">
<div class="alignRight">
  <div class="formInstruct">Scroll for more information --></div>
</div>
<div id="scrollBar2" style="height:210px;width:763px;overflow:auto" class="tableborderList">

       <%-- establish the table used to display the data returned from the service --%>
       <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="150%" >
         <tr>
             <th class="thList">Resource Name&nbsp;<impact:sortableColumnHeader orderBy="<%= FacAgencyHomesListConversation.SORT_NAME %>"/></th>
             <th class="thList">Resource ID</th>
             <th class="thList">Status</th>
             <th class="thList">Resource Type&nbsp;<impact:sortableColumnHeader orderBy="<%= FacAgencyHomesListConversation.SORT_TYPE %>"/></th>
             <th class="thList">Type</th>
             <th class="thList">Address</th>
             <th class="thList">City&nbsp;<impact:sortableColumnHeader orderBy="<%= FacAgencyHomesListConversation.SORT_CITY%>"/></th>
             <th class="thList">County&nbsp;<impact:sortableColumnHeader orderBy="<%= FacAgencyHomesListConversation.SORT_COUNTY %>"/></th>
             <th class="thList">Phone</th>
             <th class="thList">Ext</th>             
         </tr>
              
<% // within the table, display the data
     
     if (retrieveFacAgencyHomesList.isEmpty()){
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
   for (Iterator<RetrieveFacAgencyHomesListBean> it = retrieveFacAgencyHomesList.iterator(); it.hasNext();) {               
        RetrieveFacAgencyHomesListBean resource = it.next();

%>
         <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="center">
         
           <td><a href="javascript:displayChildList('<%=FormattingHelper.formatString(String.valueOf(resource.getUlIdRsrc()))%>');">
                                                            <%=FormattingHelper.formatString(resource.getNmResource())%></a></td>
                   
                <td>
                <%= FormattingHelper.formatLong(resource.getUlIdRsrc())%>
                </td>
                <td>
                <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRSCSTAT",resource.getCdStatus()))%>
                </td>
                <td>
                <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRSCTYPE",resource.getCdrscType()))%>
                </td>
                <td>
                <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CFACTYP4",resource.getSzCdIncRsrcType()))%>
                </td>
                <td>
                <%= FormattingHelper.formatString(resource.getCdAddress())%>
                </td>
                <td>
                <%= FormattingHelper.formatString(resource.getSzAddrCity())%>
                </td>
                <td>
                <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCOUNT",resource.getCdCounty()))%>
                </td>
                <td>
                <%= FormattingHelper.formatPhone(resource.get1NbrFacilPhoneNumber())%>
                </td>
                <td>
                <%= FormattingHelper.formatString(resource.getlNbrPhoneExtension())%>
                </td>
                
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

     <impact:validateInput type="hidden" name="hdnUlIdRsrcParent" value="<%=GlobalData.getUlIdParentRsrcAsString(request)%>" />
     <impact:validateInput type="hidden" name="hdnUlIdRsrcChild" value="0"/>
     <impact:validateInput type="hidden" name="ulIdResource" value='<%= ContextHelper.getStringSafe( request, "ulIdResource" )%>' />
     <impact:validateInput type="hidden" name="ulIdStage" value="<%= String.valueOf( GlobalData.getUlIdStage( request) )%>"/>
    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>




