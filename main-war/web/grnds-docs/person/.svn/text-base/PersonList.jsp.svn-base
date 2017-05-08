<%
//*  JSP Name:     Person List JSP
//*  Created by:   Jenn Casdorph
//*  Date Created: 12/06/02
//*
//*  Description:
//*   The Person List page is a navigational tool used to
//*   allow the worker to select a person for which he/she
//*   is recording or viewing information. It provides a list
//*   of individuals associated with a case or stage which will
//*   include principals only, collaterals only, or all persons
//*   associated with a case or stage depending on the context
//*   in which the user calls the window. There are many
//*   different ways into Person List and they will be split
//*   into two seperate paths depending on whether or not
//*   the invoking window needs access to Person Detail,
//*   Person Search, or to select an ID Person to
//*   be returned to the invoking page.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/02/03  GRIMSHAN          SIR # 17067 Created a personListPageMode variable to
//**                              be passed into the pageMode piece of the form.
//**                              This variable is set to the App Mode in all cases except
//**                              when the page is in a pull back status.
//**                              When it is in pull back status, this variable
//**                              will always be set to Edit.  This was done because the
//**                              Person List page can be accessed for pulling back when
//**                              the stage is closed (app mode is view)
//**  08/12/03  dickmaec          SIR 19455 -- If there is a blank value in the SzNmPersonFull() field
//**                              a line will display for the user to click on.
//**  10/28/04  CORLEYAN          SIR 22566 - Make the width of the list box 100% to eliminate
//**                              scrolling if it is not needed.
//**  07/10/05  PINKSTBA          SIR 23727 MPS Phase II : Radio Buttons, Add Button, and
//**                              Search Button are hidden using <impact:ifServerImpact> tag.-
//**  07/24/05  brauchs            Adjusted tables for SIR 23639 - Use full screen width for MPS
//**  09/23/05  douglacs          SIR 23550 & 23982 - added indicators to show if person
//**                              characteristics and race/ethnicity are entered.
//**  12/04/08  arege             STGAP00010668 Modified code so that Special Rel field gets populated if 
//**                              there is an entry for Special Relationship field on the Person Detail page.

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonListCustomValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

/*  GET OBJECTS FROM REQUEST AND PERFORM NULL CATCH  */
  CINV01SO cinv01so = (CINV01SO)state.getAttribute("CINV01SO", request);

  ROWCINV01SOG00_ARRAY cinv01Array = new ROWCINV01SOG00_ARRAY();

  if ( cinv01so == null )
  {
    cinv01so = new CINV01SO();
  }
  if ( cinv01so.getROWCINV01SOG00_ARRAY() != null)
  {
   cinv01Array = cinv01so.getROWCINV01SOG00_ARRAY();
  }
  else
  {
    cinv01Array = new ROWCINV01SOG00_ARRAY();
  }
/**
 *  Page Mode Logic
 *
 *   This page will be passed one of four page modes:
 *   1.  SELECT (S)
 *   2.  CLLTRL_ONLY (C)
 *   3.  PRINC_ONLY (P)
 *   4.  ALLEG_PERP_ONLY (Z)
 *
 *   These page modes are used to determine what buttons should show up.
 *   Application mode will be used to determine overall page mode of the page.
 */

  String pageMode = PageModeConstants.EDIT;

  if (PageMode.getPageMode(request) != null )
  {
    pageMode = PageMode.getPageMode(request);
  }

  // SIR 17067 GRIMSHAN -- Initialize personListPageMode and set it to
  // App Mode
  String personListPageMode = GlobalData.getAppMode( request );

  /**
   *  If the page mode has been passed in as a "pullback" page mode, hide the
   *  Person Hyperlink and the Search and Add pushbuttons, otherwise hide the continue
   *  button
   */
  boolean disablePersonNameHL = false;
  String disableSearchAndAddPB = "false";
  String disableContinuePB = "false";
  String stage = "";
  if (GlobalData.getSzCdStage( request ) != null)
  {
    stage = GlobalData.getSzCdStage( request );
  }

  if ( pageMode.equals(PersonListConversation.PAGE_MODE_SELECT) ||
       pageMode.equals(PersonListConversation.PAGE_MODE_CLLTRL_ONLY) ||
       pageMode.equals(PersonListConversation.PAGE_MODE_PRINC_ONLY) ||
       pageMode.equals(PersonListConversation.PAGE_MODE_ALLEG_PERP_ONLY) )
  {
    // SIR 17067 GRIMSHAN -- set personListPageMode to Modify since it should
    // always be in modify when accessed as a pullback
    personListPageMode = PageModeConstants.MODIFY;
    disablePersonNameHL = true;
    disableSearchAndAddPB = "true";
  }
  else
  {
    disableContinuePB = "true";
  }

/* DECLARE VARIABLES AND ATTACH CODES TABLES */
  int tabIndex = 1;
  int loopCount = 0;
%>
<impact:validateErrors/>

<script type="text/javascript" language="JavaScript1.2">
//  This function is called when the user clicks a hyperlink in the list.
function personListHyperlink (index)
{
  frmPersonList.hdnPersonLoopCount.value = index;
}
</script>

<impact:validateForm name="frmPersonList"
  method="post"
  action="/person/PersonList/displayPersonList"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.PersonListCustomValidation"
  pageMode="<%= personListPageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<% /* Changed to 100% width for SIR 23639 */  %>
<impact:pagination submitUrl="/person/PersonList/displayPersonList">
       <div id="scrollBar2" style="height:210px;width:100%;overflow:auto" class="tableborderList">
           <table width="100%" cellspacing="0" cellpadding="3" border="0">
                    <tr>
                    <th class="thList">&nbsp;</th>
                    <th class="thList">Name</th>
                    <th class="thList">Merge</th>
                    <th class="thList">Search</th>
                    <th class="thList">Age</th>
                    <th class="thList">Gender</th>
                    <th class="thList">Type</th>
                    <th class="thList">Role</th>
                    <th class="thList">Rel/Int</th>
                    <th class="thList">Special Rel</th>
                    <th class="thList">Person ID</th>                    
                  </tr>
<%
                    loopCount = 0;
                    ROWCINV01SOG00 personListRow = null;
                    Enumeration personListEnum = cinv01Array.enumerateROWCINV01SOG00();
                    if ( personListEnum == null || !(personListEnum.hasMoreElements() ) )
                    {
%>
                      <tr class="odd">
                        <td colspan="14">
                           <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
                        </td>
                      </tr>
<%
                   }
                   else
                   {
                     while( personListEnum.hasMoreElements() )
                     {

                        personListRow = (ROWCINV01SOG00) personListEnum.nextElement();
                        String radioId = "rbPersonList_" + loopCount;
%>
                        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">

              <!-- radio button not needed for Mobile -->
               <impact:ifServerImpact>
                            <td><impact:validateInput type="radio" id="<%= radioId %>" tabIndex="<%= tabIndex++ %>" name="rbPersonList_CLEAN" value="<%= String.valueOf( loopCount ) %>"/></td>
                          </impact:ifServerImpact>
              <impact:ifMobileImpact>
              <td>&nbsp;</td>
              </impact:ifMobileImpact>

              <td><% if ( "Y".equals(personListRow.getBIndStagePersReporter()) ) { %><b>#</b>  <%}%>
                              <% if (disablePersonNameHL) {%>
                                    <%= personListRow.getSzNmPersonFull() %>
                                <%} else {%>
                                   <a href="javascript:personListHyperlink( '<%=loopCount%>' );   disableValidation( 'frmPersonList' ); submitValidateForm( 'frmPersonList' , '/person/PersonList/callPersonDetail' )" tabIndex="<%= tabIndex++ %>" >
                                <%
                                //SIR 19455 -- If there is a blank value in the SzNmPersonFull() field
                                //     a line will display for the user to click on.
                                   if(StringHelper.isValid(personListRow.getSzNmPersonFull()) == false)
                                   {
                                     out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                                               "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                                               "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                                   }
                                   else
                                   {
                                     out.print(FormattingHelper.formatString(personListRow.getSzNmPersonFull()));
                                   }
                %>
                                   </a>
                               <% }%>
                          </td>
                          <td><%= FormattingHelper.formatString( personListRow.getCWcdIndMerge() ) %></td>
                          <td><%= FormattingHelper.formatString( personListRow.getSzCdStagePersSearchInd() ) %></td>                          
                          <td><%= FormattingHelper.formatInt( personListRow.getLNbrPersonAge() ) %></td>
                          <td><%= FormattingHelper.formatString( personListRow.getCCdPersonSex() ) %></td>
                          <td><%= FormattingHelper.formatString( personListRow.getSzCdStagePersType() ) %></td>
                          <td><%= FormattingHelper.formatString( personListRow.getSzCdStagePersRole() ) %></td>
                          <% if("PRN".equals(personListRow.getSzCdStagePersType())){%>
                          <td><%= FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CRELVICT", personListRow.getSzCdStagePersRelInt()) )%></td>
                          <% }else if("COL".equals(personListRow.getSzCdStagePersType())){%>
                          <td><%= FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CSRCRPTR", personListRow.getSzCdStagePersRelInt()) )%></td>
                          <% }%>
                           <% if(StringHelper.isValid(personListRow.getSzTxtOtherRelationshipsCmnts())){%>
                          <td> !</td>
                          <% }else{%>
                          <td>&nbsp;</td>
                          <% }%>                     
                          <td><%= FormattingHelper.formatInt( personListRow.getUlIdPerson() )%></td>                                                    
                        </tr>
                         <%loopCount++;
                   }
                  }%>
                </table>
             </div>
</impact:pagination>



 <table border="0" cellspacing="0" cellpadding="3" width="100%">
   <tr>
     <td width="84%">&nbsp;</td>

     <!- Search and Add buttons not needed for Mobile ->
   <impact:ifServerImpact>
        <td class="alignRight" width="8%">
           <impact:ButtonTag name="btnSearch" img="btnSearch" align="right" form="frmPersonList" action="/person/PersonList/callPersonSearch" tabIndex="<%= tabIndex++ %>" disabled="<%= disableSearchAndAddPB %>" />
        </td>
        <td class="alignRight" width="8%">
           <impact:ButtonTag name="btnAdd" img="btnAdd" align="right" form="frmPersonList" action="/person/PersonList/callPersonSearch" tabIndex="<%= tabIndex++ %>" disabled="<%= disableSearchAndAddPB %>" />
        </td>
     </impact:ifServerImpact>
      <td class="alignRight" width="8%">
         <impact:ButtonTag name="btnContinue" img="btnContinue" align="right" form="frmPersonList" action="/person/PersonList/callContinue" tabIndex="<%= tabIndex++ %>" disabled="<%= disableContinuePB %>" />
      </td>
    </tr>
 </table>
  <impact:validateInput type="hidden" name="hdnPersonLoopCount" value=""/>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>