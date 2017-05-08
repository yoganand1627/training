<%
/**  JSP Name:     Vendor Staff List
  *  Created by:   Patrick Coogan
  *  Date Created: 11/10/2009
  *
  *  Description:
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  11/10/09    Patrick Coogan    Created page to support administrative functions of the
  *                                SHINES Vendor Portal.  
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffListSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffListBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.VendorStaffListConversation" %>


<%
  String PORTAL_STAFF_LIST = "portalActive";
  String PORTAL_PENDING_STAFF_LIST = "portalPending";
  //Note: the following are only used in SHINES
  String SHINES_STAFF_LIST = "shinesActive";
  String SHINES_PENDING_STAFF_LIST = "shinesPending";
  String SHINES_PENDING_ADMIN_LIST = "shinesPendingAdmin";
  
  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //HttpServletRequest request = context.getRequest();
  //Set the page mode
  //String pageMode =  (String) request.getAttribute("pageMode" );//PageModeConstants.VIEW;
   String pageMode = PageMode.getPageMode(request);
  
     // create the output object
    RetrieveVendorStaffListSO retrieveVendorStaffListSO = ( RetrieveVendorStaffListSO ) request.getAttribute( "retrieveVendorStaffListSO" );
  
     //initialize the array
    List<RetrieveVendorStaffListBean> retrieveVendorStaffList = new ArrayList<RetrieveVendorStaffListBean>();
     //null catch
    if ( retrieveVendorStaffListSO == null )
    {
      retrieveVendorStaffListSO = new RetrieveVendorStaffListSO() ;
    }
     //null catch for row objects, if not null, get rows
    if ( retrieveVendorStaffListSO.getVendorStaffList() != null )
    {
      retrieveVendorStaffList = retrieveVendorStaffListSO.getVendorStaffList();
    }
    
    String screenName = (String) request.getAttribute( "screenName" );

  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  UserProfile user = UserProfileHelper.getUserProfile ( request );
  
%>
<script type="text/javascript" language="JavaScript1.2">
  function displayVendorStaffDetail(idUser) {
    document.frmVendorStaffListList.hdnUlIdUser.value = idUser;
    submitValidateForm("frmVendorStaffListList", "/resource/VendorStaffDetail/displayVendorStaffDetail");
  }
  function displayPendingVendorStaffDetail(idUser) {
    document.frmVendorStaffListList.hdnUlIdUser.value = idUser;
    submitValidateForm("frmVendorStaffListList", "/resource/VendorStaffDetail/displayPendingVendorStaffDetail");
  } 
  function displayPendingPortalAdminDetail(idUser) {
    document.frmVendorStaffListList.hdnUlIdUser.value = idUser;
    submitValidateForm("frmVendorStaffListList", "/resource/VendorStaffDetail/displayPendingPortalAdminDetail");
  }   
</script>
  
  <impact:validateErrors/>
  <impact:validateForm
       name="frmVendorStaffListList"
       method="post"
       action="/resource/VendorStaffList/displayVendorStaffList"
       validationClass="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"
       pageMode="<%=pageMode%>"
       schema="/WEB-INF/Constraints.xsd">
  <impact:validateInput type="hidden" name="hdnUlIdUser" value="-1"/>
  <impact:validateInput type="hidden" name="hdnScrNm" value="<%=screenName%>"/>
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
//SIR 19651 - set url based on if it is in resource or search context.  This
//will allow for the correct screen definitions to be loaded.  Case context
//should show Case Name, Resource context should show Resource Name
String submitUrl = "";

if (SHINES_STAFF_LIST.equals(screenName)){
submitUrl="/resource/VendorStaffList/displayVendorStaffList";
} else if (SHINES_PENDING_STAFF_LIST.equals(screenName)){
submitUrl="/resource/VendorStaffList/displayPendingVendorStaffList";
} else if (SHINES_PENDING_ADMIN_LIST.equals(screenName)){
submitUrl="resource/VendorStaffList/displayPendingPortalAdminList";
}
%>

<impact:pagination submitUrl="<%=submitUrl%>">
<div class="alignRight">
<div class="formInstruct">Scroll for more information --></div>
</div>
<div id="scrollBar2" style="height:210px;width:763px;overflow:auto" class="tableborderList">

       <%-- establish the table used to display the data returned from the service --%>
       <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="150%" >
         <tr>
             <th class="thList">Name</th>
             <th class="thList">User Type</th>
             <th class="thList">Resource Name</th>
             <th class="thList">Resource ID</th>
             <th class="thList">Status</th>
             <th class="thList">Start</th>
             <th class="thList">End</th>
             <th class="thList">E-mail</th>
             <th class="thList">Phone</th>        
         </tr>
              
<% // within the table, display the data
     
     if (retrieveVendorStaffList.isEmpty()){
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
   for (Iterator<RetrieveVendorStaffListBean> it = retrieveVendorStaffList.iterator(); it.hasNext();) {               
        RetrieveVendorStaffListBean resource = it.next();

%>
         <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="center">
         
           <td>
	           <impact:ifThen test='<%=(screenName.equals(SHINES_STAFF_LIST)) %>'>
	           <a href="javascript:displayVendorStaffDetail('<%=FormattingHelper.formatString(String.valueOf(resource.getUlIdUser()))%>')"><%=FormattingHelper.formatString(resource.getSzStaffName())%></a>
	           </impact:ifThen>
	           <impact:ifThen test='<%=(screenName.equals(SHINES_PENDING_STAFF_LIST)) %>'>
	           <a href="javascript:displayPendingVendorStaffDetail('<%=FormattingHelper.formatString(String.valueOf(resource.getUlIdUser()))%>')"><%=FormattingHelper.formatString(resource.getSzStaffName())%></a>
	           </impact:ifThen>
	           <impact:ifThen test='<%=(screenName.equals(SHINES_PENDING_ADMIN_LIST)) %>'>
	           <a href="javascript:displayPendingPortalAdminDetail('<%=FormattingHelper.formatString(String.valueOf(resource.getUlIdUser()))%>')"><%=FormattingHelper.formatString(resource.getSzStaffName())%></a>
	           </impact:ifThen>		           	           
           </td>
                   
                <td>
                <%=Lookup.simpleDecodeSafe("CUSRTYP", FormattingHelper.formatString(resource.getCdUserType()))%>
                </td>
                <td>
                <%=FormattingHelper.formatString(resource.getSzNmResource())%>
                </td>
                <impact:ifThen test='<%= (resource.getUlIdResource()!=null)%>'>
                <td>
                <%=FormattingHelper.formatLong(resource.getUlIdResource())%>
                </td>
                </impact:ifThen>
                <impact:ifThen test='<%=(resource.getUlIdResource()==null) %>'>
                <td>
                &nbsp;
                </td>
                </impact:ifThen>
                 <td> <%=Lookup.simpleDecodeSafe("CUSRSTAT", FormattingHelper.formatString(resource.getCdStatus()))%>
                </td>
                <impact:ifThen test='<%= (resource.getDtStart()!=null)%>'>
                <td>
                <%=FormattingHelper.formatDate(resource.getDtStart())%>
                </td>
                </impact:ifThen>
                <impact:ifThen test='<%=(resource.getDtStart()==null) %>'>
                <td>
                &nbsp;
                </td>
                </impact:ifThen>
                 <impact:ifThen test='<%= (resource.getDtEnd()!=null)%>'>
                <td>
                <%=FormattingHelper.formatDate(resource.getDtEnd())%>
                </td>
                </impact:ifThen>
                <impact:ifThen test='<%=(resource.getDtEnd()==null) %>'>
                <td>
                &nbsp;
                </td>
                </impact:ifThen>
                <td>
                <%=FormattingHelper.formatString(resource.getSzStaffEmail() != null ? resource.getSzStaffEmail() : "")%>
                </td>
                <td>
                <%=FormattingHelper.formatPhone(resource.getNbrStaffPhone() != null ? resource.getNbrStaffPhone(): "")%>
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

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>




