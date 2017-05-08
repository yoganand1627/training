<%
/**
 * JSP Name:     Initial Contact
 * Created by:   Todd Reser (Split out by Matt McClaim)
 * Date Created: 10/06/03
 *
 * Description:
 * This page displays the Initial Contact page for adding a new contact.
 *
 * Change History:
 * Date      User              Description
 * --------  ----------------  -----------------------------------------------
 * 10/06/03  Matt McClaim      Reformatted new version split into 4 files.
 * 10/27/03  Todd Reser        SIR 11336 - 24H amd FTF were erroneously showing
 *                             twice.  Added AOC to an If statement to supress
 *                             extra versions with wrong templates.
 * 11/03/03  Todd Reser        Updated Comments.  When the JSP's were split into
 *                             4 pieces a Comment was erroneously put in
 *                             InitialContact when it should have been in
 *                             DetailContactSub.
 * 01/03/05  Eric Dickman      I have excluded the Contact Type of Capacity
 *                             Screening Questions.  The search drop down menu
 *                             will allow users to still search for Contact Types of
 *                             Capacity Screening Questions that where in the db
 *                             previous to the 02/27/2005 roll-out.
 * 02/03/05  Hari Maralla      SIR 23272 - excluded ALIC (Licensing Investigation Report)
 *                             Contracts Type (DropDown) for CPS Program and INV Stage.
 * 07/24/05  Mike Werle        SIR 23728 Added fix for Adding 24Hour contact
 *                             in INV stage for APS on MPS.
 * 09/14/05  Mike Werle        SIR 23968 Adding AFC contact types to MPS.
 * 09/20/05  mkw               Phase III -- Enhancements for Facility and APS:
 *                             SIRs 23968, 23949, and 23950.
 * 03/22/07  abgoode           Removed CCNTCTYP manipulation in Javascript, logic centralized
 *                             in ContactSearchListDetailConversation
 * 05/27/11  schoi             SMS #109398: MR-086 Filter Contact/Summary Type dropdown to exclude 'Transfer Summary'
 */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%-- @ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" --%>
<%-- @ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants" --%>
<%-- @ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" --%>
<%-- @ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%-- @ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%-- @ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListDetailConversation" %>
<%-- @ page import="java.util.Collection" --%>
<%-- @ page import="java.util.HashSet" --%>
<%-- @ page import="java.util.Iterator" --%>
<%-- @ page import="java.util.Set" --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>

<%
  //noinspection UnnecessaryCodeBlock
  {
    int tabIndex = 1;
    String pageMode = PageMode.getPageMode( request );
    //String szCdStage = GlobalData.getSzCdStage( request );
    // SIR 23272 - Get Program Type from Global Data
    //String SzCdStageProgram = GlobalData.getSzCdStageProgram( request );

    BaseSessionStateManager state =
            (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

    CSYS08SO csys08so = (CSYS08SO)state.getAttribute( "CSYS08SO", request );
    if( csys08so == null )
    {
      csys08so = new CSYS08SO();
    }

    String typeKey = ContactSearchListDetailConversation.getTypeKey( request );
    String selSzCdContactType = ContactSearchListDetailConversation.getSelSzCdContactType( request );

    // SIR 18639 - If the pageMode is VIEW then the widgent Name has an _DISABLED
    // appended to it.
    String selSzCdContactTypeString = "selSzCdContactType";
    if( pageMode.equals( PageModeConstants.VIEW ) )
    {
      selSzCdContactTypeString = "selSzCdContactType_Disabled";
    }
    
    // SMS #109398: MR-086 Filter Contact/Summary Type dropdown to exclude 'Transfer Summary'
	List excludeCCNTCTYP = new ArrayList();
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_OTRN);
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_ATRN);	
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_ITRN);
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_PTRN);
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_QTRN);
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_MTRN);	
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_NTRN);	
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_LTRN);	
	excludeCCNTCTYP.add(CodesTables.CCNTCTYP_HTRN);
%>

<%--
<script type="text/javascript" language="JavaScript1.2">
  <impact:codeArray codeName="<%= CodesTables.CCNTCTYP %>"
  excludeOptions="<%= excludeType %>"
  arrayName="<%= CodesTables.CCNTCTYP %>"
  blankValue="true"
  orderBy="decode"/>

  function populateType()
  {
  <%
      if (typeKey != null)
      {
        if ((PageModeConstants.VIEW.equals(pageMode)) &&
            ((csys08so.getDtDtStageClose() == null) ||
             (DateHelper.NULL_CASTOR_DATE.equals(csys08so.getDtDtStageClose()))))
        {
          out.println("  clearDropdown(frmInitialContact." + selSzCdContactTypeString + ");");
        }
        else
        {
          out.println("  populateFilteredDropdown('" + typeKey + "', frmInitialContact." + selSzCdContactTypeString + ", CCNTCTYP, true);");
          out.println("  frmInitialContact." + selSzCdContactTypeString + ".value='" + selSzCdContactType + "';");
        }
      }
  %>
  }
--%>

<script type="text/javascript" language="JavaScript1.2">
  function submitOnEnter()
  {
    // In the onload event, we attach this function to the onkeydown handler
    // for the Form.  When a key is pressed anywhere in the form, it now calls
    // this function before getting sent to the main event handler.
    var we = window.event
    if( we.keyCode == '13' &&
        !( we.shiftKey ||
           we.shiftRight ||
           we.ctrlKey ||
           we.ctrlRight ||
           we.altKey ||
           we.altRight) )
    {
      we.returnValue = false;
      submitValidateForm("frmInitialContact", "/contacts/ContactSearchListDetail/continueType");
    }
  }
</script>


<impact:validateForm name="frmInitialContact"
                     method="post"
                     action="/contacts/ContactSearchListDetail/displayContact"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.contacts.InitialContactCustomValidation"
                     pageMode="<%= pageMode %>"
                     schema="/WEB-INF/Constraints.xsd">

  <impact:validateErrors/>

  <impact:validateInput type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>

  <table border="0"
         cellspacing="0"
         cellpadding="3"
         class="tableBorder"
         width="100%">
    <tr>
    <th colspan="3">Contact/Summary Type</th>
    <tr>
      <td width="15%" class="formlabel">
        <impact:validateSelect label="Type"
                               required="true"
                               name="selSzCdContactType"
                               excludeOptions="<%= excludeCCNTCTYP %>"
                               disabled="false"
                               width="35%"
                               options="<%= ContactSearchListDetailConversation.getTypeOptions(request) %>"
                               value="<%= selSzCdContactType %>"
                               tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:ButtonTag name="btnContinue"
                          img="btnContinue"
                          form="frmInitialContact"
                          action="/contacts/ContactSearchListDetail/continueType"
                          align="left"
                          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>

</impact:validateForm>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  window.onbeforeunload = function ()
  {
    IsDirty();
  };

  document.frmInitialContact.attachEvent("onkeydown", submitOnEnter);
  //populateType();
  //CleanSelect(frmInitialContact.<%= selSzCdContactTypeString %>);

  <impact:ifThen test="<%= PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request)) %>">
  // SIR 18788 - If New Using and the Contact type is *REG make sure we have the
  // right first letter because the descriptions can be different.
  //If it = *REG set it to the correct value incase the first char was wrong
  if( frmInitialContact.<%= selSzCdContactTypeString %>.value.substring(1, 4) == "REG" )
  {
    frmInitialContact.<%= selSzCdContactTypeString %>.value = "<%= typeKey %>REG";
  }
          </impact:ifThen>
</script>

<%
  }
%>
