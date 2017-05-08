<%
/**
 * JSP Name:     LevelOfCare.jsp
 * Created by:   cawthocw
 * Date Created: 07/26/02
 *
 * Description:
 * This page allows a user to view and edit the Level of Care information for
 * a Placement.
 *
 *
 *   Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 *  08/11/03  Todd Reser        Added/modified flowerbox comments and Changelog.
 *  06/10/03  lauramc           sir 17765 remove This action might generate a billing adjustment... message
*   12/01/03  corleyan          LOC Enhancement - If the effective date gotten from request (passed from
*                               either AddLevelOfCare or Facility Detail) is
*                               greater than 08/31/2003 use new codes to display the LOC to the user.
*   09/19/05  berkime           SIR 23890 - changed the wording from level of care to
*                               service level.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<%
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );



  //get the page mode from the request
  String pageMode = PageMode.getPageMode(request);
  String facilityName = GlobalData.getSzNmResource( request );
  String facilityNumber = request.getParameter("txtLNbrRsrcFacilAcclaim");
  String contact = request.getParameter("txtNmRsrcContact");
  String resourceType = request.getParameter("cboCdRsrcType");
  String facilityType = request.getParameter("cboCdRsrcFacilType");

  //get the parameters from the request
  String effectiveDateS = request.getParameter("effectiveDate");
  org.exolab.castor.types.Date effectiveDate = DateHelper.toCastorDateSafe(effectiveDateS);
  org.exolab.castor.types.Date changeDate = DateHelper.toCastorDateSafe("09/01/2003");
  String endDate = request.getParameter("endDate");
  String activeLOC = request.getParameter("activeLOC");
  String holdLOC = request.getParameter("holdLOC");
  String rownum = request.getParameter("rownum");
  String ulIDResource = GlobalData.getUlIdResourceAsString( request );

  //create collection of the active and hold Levels of Care
  // This collection is generated from a hidden field value from
  // facility detail.
  Collection actives = new ArrayList();
  Collection holds = new ArrayList();
  if(activeLOC != null)
  {
    StringTokenizer activeString = new StringTokenizer(activeLOC);
    actives = getCollection(activeString );
  }
  if(holdLOC != null){
    StringTokenizer holdString = new StringTokenizer(holdLOC);
    holds = getCollection(holdString);
  }


  int tabIndex = 1;
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
<!--Insert Java Script here

function setDirty()
{
  IsDirty();
}

window.attachEvent('onbeforeunload', setDirty );


//End Java Script-->
</script>
<impact:validateErrors />

<impact:validateForm name="frmLOC"
  method="post"
  action="/resource/Facility/saveLOC"
  schema="/WEB-INF/Constraints.xsd"
  pageMode="<%=pageMode%>">
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="rownum" value="<%=rownum%>" />
<impact:validateInput type="hidden" name="txtLNbrRsrcFacilAcclaim" value="<%=facilityNumber%>"/>
<impact:validateInput type="hidden" name="txtNmRsrcContact" value="<%=contact%>"/>
<impact:validateInput type="hidden" name="cboCdRsrcType" value="<%=resourceType%>"/>
<impact:validateInput type="hidden" name="cboCdRsrcFacilType" value="<%=facilityType%>"/>
<%//SIR 23890  changed wording from level of care to service level %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="5">Room, Board, and Watchful Oversight Detail</th>
  </tr>
  <tr>
    <td width="25%">
        <!-- LOC Enhancement - Use impact display only fields for the values of these fields so that on
             Save they can be read in the conversation -->
        <impact:validateDisplayOnlyField name="rdatReceiveDate"
                              label="Effective Date"
                              value="<%=FormattingHelper.formatDate(effectiveDate)%>" />
    </td >
    <td>
        <impact:validateDisplayOnlyField name="endDate"
                              label="End Date"
                              value="<%=FormattingHelper.formatString(endDate)%>" />
    </td  width="25%">
    <td width="50%"></td>
   </tr>
  <tr>
   <td  colspan="5">
    <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorderList">
     <tr>
    <th class="thList">Levels: </th>
    <th class="thList">Active </th>
    <th class="thList">Hold </th>
    <th class="thList">N/A </th>
  </tr>

<%
  Collection collection = null;
  // If the effective date is before the change date, use the old codes table to determine decodes to
  // be displayed.  Otherwise generate a static list of decodes to be displayed from the new codes table
  // The statis list is used b/c of program's need for the decodes to be displayed in a certain order.
//  if ( DateHelper.isBefore(  effectiveDate ,   changeDate ) && !DateHelper.NULL_CASTOR_DATE.equals(effectiveDate) )
// {
// Old Codes were updated with new data. so we dont have to use condition here.
  collection = Lookup.getCategoryCollection("CLVOFCRE");
// }
// else
// {
//  List list = new ArrayList(7);
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_210));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_220));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_230));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_240));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_090));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_100));
//  list.add(Lookup.decode(CodesTables.CLVOFCR3, CodesTables.CLVOFCR3_110));
//  collection = list;
// }
  List clvofcre = (List)collection;

   CodeAttributes attribute = null;
   Iterator lvls = collection.iterator();

   if( lvls.hasNext() )
   {
     while(lvls.hasNext())
     {
       attribute = (CodeAttributes) lvls.next();
%>
    <tr>
      <td align="center"><%=attribute.getDecode()%></td>
      <%
        String disabled = "false";
        String radioName = "radio" + attribute.getDecode();
        String decode = attribute.getDecode();
        String active = "";
        String hold = "";
        String na = "";
        //get the active, hold and N/A levels of care
        if( !pageMode.equals(PageModeConstants.NEW) )
        {
          if(actives.contains(decode))
          {
            active = "true";
            disabled = "true";
          }else if(holds.contains(decode))
          {
            hold = "true";
            disabled = "true";
          }else
          {
            na = "true";
          }
        }else
        {
          na = "true";
        }
      %>
      <td><impact:validateInput type="radio" cssClass="formInput"  name="<%=radioName%>" checked="<%=active%>" value="A" tabIndex="<%=tabIndex++%>"/></td>
      <td><impact:validateInput type="radio" cssClass="formInput"  name="<%=radioName%>" checked="<%=hold%>" value="H" tabIndex="<%=tabIndex++%>"/></td>
      <td><impact:validateInput type="radio" cssClass="formInput"  name="<%=radioName%>" checked="<%=na%>" disabled="<%=disabled%>" value="NA" tabIndex="<%=tabIndex++%>"/></td>
    </tr>
<%
      } //end for loop for caretakerArray
   }
   else
   {
%>         <tr>
          <td>
              <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
           </td>
         </tr>
<% }
%>
   </table>
   </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
 <tr>
  <td align="right">
     <impact:ButtonTag name="btnSaveLOC"
                     img="btnSave"
                           restrictRepost="true"
         align="right"
         form="frmLOC"
         action="/resource/Facility/saveLOC"
         tabIndex="<%=tabIndex++%>"/>
  </td>
 </tr>
</table>
</impact:validateForm>

<%!
  //Get a Collection of LOCs from a StringTokenizer of comma separated values
  public static Collection getCollection( StringTokenizer statuses )
  {
    String token = null;
    Collection statusCollection = new ArrayList();

    while(statuses.hasMoreTokens())
    {
      token = statuses.nextToken();
      statusCollection.add( token );
    }
    return statusCollection;
  }
%>
