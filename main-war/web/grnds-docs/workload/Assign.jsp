<%
//*  JSP Name:     Assign JSP
//*  Created by:   Bryon Jacob
//*  Date Created: 1/8/2003
//*
//*  Description:
//*  This page is used to assign a stage or unit of work from a user's workload
//*  to someone else in IMPACT.
//*
//** Change History:
//**  Date        User              Description
//**  --------    ----------------  ----------------------------------------------
//**  07/10/2003  DOUGLACS          SIR 18728 - hyperlink doesn't work if name
//**                                includes apostrophe
//**  08/07/2003  Todd Reser        Added Description.
//**  06/21/2004  wadesa            SIR 23695 - Added hidden field to JSP for CRSR
//**                                enhancement.
//**  07/24/05     Mike Werle        SIR 23728 - Moved constants for code reuse in MPS
//**  08/08/05    gerryc            SIR 22556 - increased size of Assignments section
//**                                from 20 rows to 100, since we will now always be
//**                                showing primary and secondary.


%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<% /* Import State Management classes - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<% /* Import PageMode and other utilities used on the page - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%/* Import needed for Messages */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup" %>
<%/* Import needed for Form Launch */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.AssignConversation"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<!-- Line 1 This is to see where this line is when opened from the browser -->
<%
// grab the page state and the lookup service output object
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
CCMN80SO ccmn80so = (CCMN80SO)state.getAttribute("CCMN80SO", request);
if ( ccmn80so == null )
{
  // Service can fail on MSG_CMN_ASSIGN_ON_CALL exception.
  ccmn80so = new CCMN80SO();
}

// get the arrays of available staff and current assignments to display
AvailStaffGroup_ARRAY availStaffGroup_array = ccmn80so.getAvailStaffGroup_ARRAY();
if ( availStaffGroup_array == null )
{
  // Service can fail on MSG_CMN_ASSIGN_ON_CALL exception.
  availStaffGroup_array = new AvailStaffGroup_ARRAY();
}
List assignments = (List)state.getAttribute(AssignConversation.ASSIGNMENTS_LIST, request);
if ( assignments == null )
{
  // Service can fail on MSG_CMN_ASSIGN_ON_CALL exception.
  assignments = new ArrayList();
}

// initialize the tabIndex to 0
int tabIndex = 1;

// get the on-call mode from the page state
Boolean onCallMode = ((Boolean)state.getAttribute(AssignConversation.ON_CALL, request));

// if it is null, set it to false
onCallMode = (onCallMode == null) ? Boolean.FALSE : onCallMode;

// get the selected county from the request
String selectedCounty = (String) state.getAttribute(AssignConversation.COUNTY_ATTR, request);
selectedCounty = "".equals(selectedCounty) ? "" : selectedCounty;

// get the name of the person whose phone information we are displaying
String phoneName = request.getParameter("txtPhonePerson");
if (phoneName == null)
{
  phoneName = GlobalData.getSzNmPersonFull(request);
}

String rbAvailableStaff = "";
if ( request.getAttribute( "rbAvailableStaff" ) != null )
{
  rbAvailableStaff = (String) request.getAttribute( "rbAvailableStaff" );
}


// get the dirty bit for assignments on this page
boolean assignDirty = state.getAttribute("assignDirty", request) != null;

// SIR 23695 - setup the hidden filed value used at bottom of page.  This filed is used to notify service
// if the intake is a CRSR APS case or a normal APS case. (if APS)
String tempDisposition = ContextHelper.getStringSafe(request, "hdnSzCdIncomingDisposition");
%>

<!-- Line 2 This is to see where this line is when opened from the browser -->
<impact:validateErrors/>

<script type="text/javascript" language="JavaScript1.2">
function phoneDetail(ulIdPerson, txtPhonePerson)
{
  disableValidation( "frmAssign" );
  submitValidateForm( "frmAssign" , "/workload/Assign/displayAssign?ulIdPerson=" + ulIdPerson + "&txtPhonePerson=" + txtPhonePerson);
}

function updatePrimary()
{
  <%/*SIR 22556 */%>
 document.frmAssign.hdnPrimaryInd.value = "Y";
}

function Primary()
{
     return confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CMN_CONFIRM_PRIMARY) %>');
}      
      


function setSaveFlag()
{
  document.frmAssign.bSave.value = 'true';
}


<%
// if we have made any assignments on this page...
  if (assignDirty)
  {
%>
window.onbeforeunload = function ()
{
  // Since the page doesnt its own dirty checks, we dont call is dirty. But this
  // is essentially what isDirty returns.
  if (document.frmAssign.bSave.value != 'true')
  {
    event.returnValue = "Your unsaved data will be lost.";
    document.frmAssign.bSave.value = 'true';
  }
}
<%
  }
%>
</script>

<!-------------------------------------------------------------------------------------------------
 !- Form - frmAssign
 !-
 !- the main form for the page, containing all controls except for the phone expandable section
!------------------------------------------------------------------------------------------------>
<impact:validateForm name="frmAssign"
  method="post"
  action=""
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.AssignCustomValidation"
  schema="/WEB-INF/Constraints.xsd"
  pageMode="<%=PageModeConstants.EDIT%>" >

<!-------------------------------------------------------------------------------------------------
 !- Top Button Panel
 !-
 !- contains radio for selecting "full unit" or "on-call", drop-down for county, and "search"
 !- button for reloading the Available Staff table based on these selections.
!------------------------------------------------------------------------------------------------>
<table width="100%" class="tableBorder" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <th colspan="4">Search Parameters</th>
  </tr>
  <tr>
    <td colspan="4">
      <impact:validateInput type="radio" tabIndex="<%=tabIndex++%>" label="Full Unit (User's County Only)"
                            name="rbFullUnitOrOnCall"  cssClass="formInput" value="FULL_UNIT"
                            checked="<%=String.valueOf(!onCallMode)%>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="radio" tabIndex="<%=tabIndex++%>" label="On-call"
                            name="rbFullUnitOrOnCall"  cssClass="formInput" value="ON_CALL"
                            checked="<%=String.valueOf(onCallMode.booleanValue())%>"/>
    </td>
    <td align="right">
      <impact:validateSelect tabIndex="<%=tabIndex++%>" label="County"
                             codesTable="CCOUNT" name="selSzCdOnCallCounty" value="<%=selectedCounty%>"/>
    </td>
  </tr>
</table>
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td colspan="4" align="right">
      <impact:ButtonTag action="/workload/Assign/search" tabIndex="<%=tabIndex++%>"
                        form="frmAssign" img="btnSearch" name="btnSearch" function="document.frmAssign.bSave.value = 'true';"/>
    </td>
  </tr>
</table>
<br>
<!-------------------------------------------------------------------------------------------------
 !- Available Staff Table
 !-
 !- Displays the Available Staff for the view mode selected.  Clicking on a staff member's name
 !- populates the phone expandable section at the bottom of the page with the selected user's phone
 !- info.  Staff are selectable with the radio buttons on the left for assignment to stages.
    !------------------------------------------------------------------------------------------------>
<table width="100%" class="tableBorder" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <th>Available Staff</th>
  </tr>
  <tr>
    <td>

<div id="scrollBar2" style="height:152px;overflow:auto" class="tableBorderList">
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <th class="thList"></th>
<%
  if (onCallMode)
  {
%>
    <th class="thList">Staff Name</th>
    <th class="thList">Phone</th>
    <th class="thList">Ext</th>
    <th class="thList">On-Call Phone</th>
    <th class="thList">Ext</th>
    <th class="thList">Position</th>
    <th class="thList">Office Name</th>
<%
  }
  else
  {
%>
    <th class="thList">Unit</th>
    <th class="thList">Staff Name</th>
    <th class="thList">Last Assigned</th>
    <th class="thList">Time</th>
    <th class="thList">Office Name</th>
  </tr>
<%
  }
  int loopCount = 0;

  Boolean bIntakeAssign = ((String) state.getAttribute(AssignConversation.PREVIOUS_URL, request)).equals(
          AssignConversation.INTAKE_PAGE);
//  if ( bAssignmentList )
//  {
  Enumeration enumeration = null;

  ROWCCMN50DO_ARRAY ccmn50do_array =
      (ROWCCMN50DO_ARRAY)state.getAttribute(StaffSearchInput.STAFF_PULL_BACK, request);

  if ((ccmn50do_array == null || ccmn50do_array.getROWCCMN50DO().length == 0) &&
      (availStaffGroup_array == null || availStaffGroup_array.getAvailStaffGroup().length == 0))
  {
    if ( request.getAttribute( AssignConversation.ERROR_MESSAGE ) == null )
    {
%>
  <tr class="odd">
    <td colspan="7">
         <%= MessageLookup.getMessageByNumber( Messages.MSG_CMN_NO_STAFF_IN_UNIT ) %>
    </td>
  </tr>
<%
    }
    else
    {
%>
  <tr class="odd">
    <td colspan="7">
         <%= (String) request.getAttribute( AssignConversation.ERROR_MESSAGE ) %>
    </td>
  </tr>
<%
    }
  }

  if (ccmn50do_array != null)
  {
    enumeration = ccmn50do_array.enumerateROWCCMN50DO();
    while (enumeration.hasMoreElements())
    {
      ROWCCMN50DO rowccmn50do = (ROWCCMN50DO)enumeration.nextElement();
%>
  <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>">
    <td>
      <impact:validateInput type="radio" name="rbAvailableStaff"
                            value="<%=String.valueOf(rowccmn50do.getUlIdPerson())%>"
                            checked='<%= ( rbAvailableStaff.equals( String.valueOf(rowccmn50do.getUlIdPerson()) ) ) ? "true" : "false" %>'
                            tabIndex="<%=tabIndex++%>" cssClass="formInput"/>
    </td>
<%
  //SIR 18728 - hyperlink doesn't work with names that include apostrophe
  StringBuffer strTemp = new StringBuffer();
  StringTokenizer split = new StringTokenizer(rowccmn50do.getSzNmPersonFull(), "'");
  strTemp.append(split.nextToken());
  while( split.hasMoreTokens() )
  {
    strTemp.append("\\'");
    strTemp.append(split.nextToken());
  }

  if (onCallMode)
  {
%>
    <td>
      <table>
        <tr>
          <td>
          <a href="javascript:phoneDetail( '<%=rowccmn50do.getUlIdPerson()%>', '<%=strTemp%>' );"
               onClick="window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );" tabIndex="<%= tabIndex++ %>">
               <%=rowccmn50do.getSzNmPersonFull()%>
          </a>
        </td>
          <% if( rowccmn50do.getBIndOverPolicyLimit() == true ){%>
          <td>*</td>
          <% } %>
         </tr>
      </table>
    </td>
    <td><%=FormattingHelper.formatPhone(rowccmn50do.getLSysNbrPersPhoneWork())%></td>
    <td><%=rowccmn50do.getLNbrPhoneExtension()%></td>
    <td><!--no on-call phone available for staff searched people...--></td>
    <td><!--no on-call ext available for staff searched people...--></td>
    <td><!--no on-call designation available for staff searched people...--></td>
    <td><%=rowccmn50do.getSzNmOfficeName()%></td>
<%
  }
  else
  {
%>
    <td><%=rowccmn50do.getSzNbrUnit()%></td>
    <td>
      <table>
        <tr>
          <td>
          <a href="javascript:phoneDetail( '<%=rowccmn50do.getUlIdPerson()%>', '<%=strTemp%>' );"
                onClick="window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );" tabIndex="<%= tabIndex++ %>">
                <%=rowccmn50do.getSzNmPersonFull()%>
          </a>
        </td>
          <% if( rowccmn50do.getBIndOverPolicyLimit() == true ){%>
          <td>*</td>
          <% } %>
         </tr>
      </table>
    </td>
    <td><%=FormattingHelper.formatDate(rowccmn50do.getDtDtEmpLastAssigned())%></td>
    <td><%=rowccmn50do.getTmScrTmEmpLastAssigned()%></td>
    <td><%=rowccmn50do.getSzNmOfficeName()%></td>
  </tr>
<%
  }
  loopCount++;
    }
  }
  enumeration = availStaffGroup_array.enumerateAvailStaffGroup();
  while (enumeration.hasMoreElements())
  {
    AvailStaffGroup availStaffGroup = (AvailStaffGroup)enumeration.nextElement();
%>
  <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>">
    <td><impact:validateInput type="radio" name="rbAvailableStaff"
                              value="<%=String.valueOf(availStaffGroup.getUlIdPerson())%>"
                              checked='<%= ( rbAvailableStaff.equals( String.valueOf(availStaffGroup.getUlIdPerson()) ) ) ? "true" : "false" %>'
                              tabIndex="<%=tabIndex++%>" cssClass="formInput"/>
    </td>
<%
    //SIR 18728 - hyperlink doesn't work with names that include apostrophe
    StringBuffer strTemp = new StringBuffer();
    StringTokenizer split = new StringTokenizer(availStaffGroup.getSzNmPersonFull(), "'");
    strTemp.append(split.nextToken());
    while( split.hasMoreTokens() )
    {
      strTemp.append("\\'");
      strTemp.append(split.nextToken());
    }

  if (onCallMode)
  {
%>
    <td>
      <table>
        <tr>
          <td>
          <a href="javascript:phoneDetail( '<%=availStaffGroup.getUlIdPerson()%>', '<%=strTemp%>' );"
              onClick="window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );" tabIndex="<%= tabIndex++ %>">
              <%=availStaffGroup.getSzNmPersonFull() != null ? availStaffGroup.getSzNmPersonFull() : "&nbsp;"%>
          </a>
        </td>
          <% if( availStaffGroup.getBIndOverPolicyLimit() == true ){%>
          <td>*</td>
          <% } %>
         </tr>
      </table>
    </td>
    
    <td><%=availStaffGroup.getLNbrPhone() != null ? FormattingHelper.formatPhone(availStaffGroup.getLNbrPhone()) : "&nbsp;"%></td>
    <td><%=availStaffGroup.getLNbrPhoneExtension() != null ? availStaffGroup.getLNbrPhoneExtension() : "&nbsp;"%></td>
    <td><%=availStaffGroup.getSzNbrEmpOnCallPhone1() != null ?
                FormattingHelper.formatPhone(availStaffGroup.getSzNbrEmpOnCallPhone1()) : "&nbsp;"%></td>
    <td><%=availStaffGroup.getLNbrEmpOnCallExt1() != null ? availStaffGroup.getLNbrEmpOnCallExt1() : "&nbsp;"%></td>
    <td><%=availStaffGroup.getSzCdEmpOnCallDesig() != null ? availStaffGroup.getSzCdEmpOnCallDesig() : "&nbsp;"%></td>
    <td><%=availStaffGroup.getSzNmOfficeName() != null ? availStaffGroup.getSzNmOfficeName() : "&nbsp;"%></td>
<%
  }
  else
  {
%>
    <td><%=availStaffGroup.getSzNbrUnit()%></td>
    <td>
      <table>
          <tr>
            <td>
            <a href="javascript:phoneDetail( '<%=availStaffGroup.getUlIdPerson()%>', '<%=strTemp%>' );"
                onClick="window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );" tabIndex="<%= tabIndex++ %>">
                <%=availStaffGroup.getSzNmPersonFull()%>
              </a>
          </td>
            <% if( availStaffGroup.getBIndOverPolicyLimit() == true ){%>
            <td>*</td>
            <% } %>
           </tr>
        </table>
      
    </td>
    <td><%=FormattingHelper.formatDate(availStaffGroup.getDtDtEmpLastAssigned())%></td>
    <td><%=availStaffGroup.getTmScrTmEmpLastAssigned()%></td>
    <td><%=availStaffGroup.getSzNmOfficeName()%></td>
  </tr>
<%
  }
  loopCount++;
  }
//  }
%>
</table>
</div>

    </td>
  </tr>
</table>

<!-------------------------------------------------------------------------------------------------
 !- Center Button Panel
 !-
 !- Contains buttons for assigning the currently selected Staff member as the Primary or Secondary
 !- asignee to the current stage(s), and a "Staff" button for searching for staff members by search
 !- criteria.
    !------------------------------------------------------------------------------------------------>
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td align="right">
      <impact:ButtonTag action="/workload/Assign/assignPrimary" restrictRepost="true" tabIndex="<%=tabIndex++%>"
                        form="frmAssign" img="btnPrimary" name="btnPrimary" function="updatePrimary(); return Primary(); document.frmAssign.bSave.value = 'true'; "   />
      <impact:ButtonTag action="/workload/Assign/assignSecondary" restrictRepost="true" tabIndex="<%=tabIndex++%>"
                        form="frmAssign" img="btnSecondary" disabled="<%= bIntakeAssign.toString() %>" function="document.frmAssign.bSave.value = 'true';" name="btnSecondary"/>
    </td>
  </tr>
  <tr>
    <td align="right">
      <impact:ButtonTag action="/workload/Assign/staff" tabIndex="<%=tabIndex++%>"
                        form="frmAssign" img="btnSelectStaff" name="btnStaff" function="document.frmAssign.bSave.value = 'true';"/>
    </td>
  </tr>
</table>
<br>
<!-------------------------------------------------------------------------------------------------
 !- Assignments Table
 !-
 !- Shows the assignments for the current stage(s).  This view represents the current local state,
 !- including any unsaved changes the user has made to the assignments.
!------------------------------------------------------------------------------------------------>
<table width="100%" class="tableBorder" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <th>
    Assignments
    </th>
  </tr>
  <tr>
    <td>
<%--SIR 22556 - added overflow:auto to style so that there would be a scroll bar--%>
<div id="scrollBar2" style="height:152px;overflow:auto" class="tableBorder">
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <th class="thList"></th>
    <th class="thList">Stage Name</th>
    <th class="thList">Name</th>
    <th class="thList">Primary/Secondary</th>
  </tr>
<%
  Iterator it = assignments.iterator();

    loopCount = 0;
    while (it.hasNext())
    {
      AssignmentGroup assignmentGroup = (AssignmentGroup)it.next();
      //SIR 18728 - hyperlink doesn't work with names that include apostrophe
      StringBuffer strTemp = new StringBuffer();
      StringTokenizer split = new StringTokenizer( assignmentGroup.getSzNmPersonFull(), "'");
      strTemp.append(split.nextToken());
      while( split.hasMoreTokens() )
      {
        strTemp.append("\\'");
        strTemp.append(split.nextToken());
      }
%>
  <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>">
    <td>
<%
  if (!"PR".equals(assignmentGroup.getSzCdStagePersRole()))
  {
%>
      <impact:validateInput type="radio" name="rbAssignments"
                            value="<%=String.valueOf(loopCount)%>"
                            tabIndex="<%=tabIndex++%>" cssClass="formInput"/>
<%
  }
%>
    </td>
    <td><%=assignmentGroup.getSzNmStage()%></td>
    <td>
      <a href="javascript:phoneDetail( '<%=assignmentGroup.getUlIdPerson()%>', '<%=strTemp%>' );"
         onClick="window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );" tabIndex="<%= tabIndex++ %>">
         <%=assignmentGroup.getSzNmPersonFull()%>
      </a>
    </td>
    <td><%="PR".equals(assignmentGroup.getSzCdStagePersRole()) ? "Primary" : "Secondary"%></td>
  </tr>
<%
  loopCount++;
    }
%>
</table>
</div>

    </td>
  </tr>
</table>

<!-------------------------------------------------------------------------------------------------
 !- Bottom Button Panel
 !-
 !- Contains a button to Un-Assign the selected Secondary assignee, and a "Save" button to commit
 !- the current set of changes to the DB.
 !------------------------------------------------------------------------------------------------>
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td align="right">
      <impact:ButtonTag action="/workload/Assign/unAssign" restrictRepost="true" tabIndex="<%=tabIndex++%>"
                        form="frmAssign" img="btnUnAssign" disabled="<%= bIntakeAssign.toString() %>" name="btnUnassign" function="document.frmAssign.bSave.value = 'true';"/>
      <impact:ButtonTag action="/workload/Assign/save" function="setSaveFlag()" restrictRepost="true" tabIndex="<%=tabIndex++%>"
                        form="frmAssign" img="btnSave" name="btnSave"/>
    </td>
  </tr>
</table>
<br>
<!-------------------------------------------------------------------------------------------------
 !- Phone Expandable Section
 !-
 !- Display the Phone Sub-Module with the currently selected staff member's phone details.
 !------------------------------------------------------------------------------------------------>

  <impact:include page='<%= PhoneSubmoduleConversation.getUrl("PhoneSub", null) %>'
                  callingPage="/workload/Assign/displayAssign"
                  tabIndex="<%=tabIndex++%>"
                  includingForm="frmAssign">
    <impact:attribute name="<%= PhoneSubmoduleConversation.PHONE_EXPANDABLE_SECTION_LABEL %>"
                      value='<%= "".equals(phoneName.trim()) ? "Phone" : "Phone for " + phoneName%>'/>
    <impact:attribute name="<%= PhoneSubmoduleConversation.PAGE_MODE %>"
                      value='<%= PageModeConstants.VIEW %>'/>  
    
</impact:include>


<!-------------------------------------------------------------------------------------------------
 !- Hidden fields to persist state
 !- hdnSzCdIncomingDisposition:  SIR 23695 - used for flag to distinguish a APS CRSR intake
 !------------------------------------------------------------------------------------------------>
<impact:validateInput type="hidden" name="txtPhonePerson" value="<%= phoneName %>"/>
<impact:validateInput type="hidden" name="hdnSzCdIncomingDisposition" value="<%= tempDisposition %>"/>
<impact:validateInput type="hidden" name="bSave" value="false"/>
<input type="hidden"  name="hdnPrimaryInd">
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">

</impact:validateForm>