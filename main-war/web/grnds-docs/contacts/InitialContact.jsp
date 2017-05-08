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

    // Create an array list of exclusions for the Type Select box
    //Set<String> excludeType = new HashSet<String>();

    // For MPS, always exclude everything except three codes; re-excluding below is not a problem.
    //noinspection ConstantConditions
    //-- **********************************************************************************************
    //-- !!! IF THIS LOGIC IS STILL NEEDED, IT SHOULD LIVE IN ContactSearchListDetailConversation.getTypeOptions !!!
    //if( PlatformConstants.MOBILE_IMPACT )
    //{
      //Collection categoryCodesCollection = Lookup.getCategoryCodesCollection( CodesTables.CCNTCTYP );
      //for( Iterator ccIt = categoryCodesCollection.iterator(); ccIt.hasNext(); )
      //{
      //  String code = (String)ccIt.next();
      //  if( !ContactSearchListDetailConversation.MOBILE_CONTACT_TYEPS.contains( code ) )
      //  {
          //excludeType.add( code );
      //  }
      //}
    //}
    //-- **********************************************************************************************

    // We have to hide A, B, C, D & E "Notifications" since they are only allowed
    // to be added by the System
    //excludeType.addAll( ContactSearchListDetailConversation.NOTIFICATION_CONTACT_TYPES );

    // We have to hide all the non-summary CPS FAD Contact Types except IREG
    //excludeType.addAll( ContactSearchListDetailConversation.NON_SUMMARY_CPS_FAD_CONTACT_TYPES );

    //SIR 23294 - exclude Capacity Screening Questions Contact Type from Initial
    //Contact Type page.
    //excludeType.add( CodesTables.CCNTCTYP_CCSQ );  //Capacity Screening Questions

    // SIR 18272 If the Superintendent checkbox on the Facility Investigation
    // Conclusion has not been checked we need to remove "Request for Review"
    // (EREV) from the list.
    //if( !ArchitectureConstants.Y.equals( csys08so.getCIndFacilSuperintNotif() ) )
    //{
      //excludeType.add( CodesTables.CCNTCTYP_EREV );  // Request for Review
    //}

    // SIR 18956 introduced a bug of displaying the Contact Purposes "24 Hour
    // Contact" and "Initial Face To Face" twice. The next two if statements
    // supress the extra listings from the select box.
    // SIR 22336 - Added AOC to if statement
    // Hide C24H & CFTF if it's a SVC or AOC Case
    //if( CodesTables.CSTAGES_SVC.equals( szCdStage ) ||
    //    CodesTables.CSTAGES_AOC.equals( szCdStage ) )
    //{
      //excludeType.add( CodesTables.CCNTCTYP_C24H ); // Hide C24H
      //excludeType.add( CodesTables.CCNTCTYP_CFTF ); // Hide CFTF
    //}
    // Hide C24N & CIFF if it's an INV stage
    //if( CodesTables.CSTAGES_INV.equals( szCdStage ) )
    //{
      //excludeType.add( CodesTables.CCNTCTYP_C24N ); // Hide C24N
      //excludeType.add( CodesTables.CCNTCTYP_CIFF ); // Hide CIFF
    //}

    // SIR 23272 - excluded ALIC from Contracts Type Dropdown, from CPS program and INV stages
    //if( CodesTables.CSTAGES_INV.equals( szCdStage ) &&
    //    CodesTables.CPGRMS_CPS.equals( SzCdStageProgram ) )
    //{
      //excludeType.add( CodesTables.CCNTCTYP_ALIC ); // Hide ALIC
    //}

    // SIR 18639 - If the pageMode is VIEW then the widgent Name has an _DISABLED
    // appended to it.
    String selSzCdContactTypeString = "selSzCdContactType";
    if( pageMode.equals( PageModeConstants.VIEW ) )
    {
      selSzCdContactTypeString = "selSzCdContactType_Disabled";
    }
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
