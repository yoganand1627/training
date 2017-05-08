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
  10/06/03  Matt McClaim      Reformatted new version split into 4 files.
  10/27/03  Todd Reser        SIR 22336 - Removed table start tag since it will
                              have been started in the Contact Detail Page.
  11/03/03  Todd Reser        Updated Comments.  When the JSP's were split into
                              4 pieces a Comment was erroneously put in
                              InitialContact when it should have been in
                              DetailContactSub.
  05/27/04  Todd Reser        SIR 22880 - Supress display of AFGC in CCNTPURP
                              for SVC & AOC Stages.
  07/21/04  Todd Reser        SIR 22880 - Forgot to suppress FGC when in a APS
                              INV so I added it to the if statement.
  10/15/04  gerryc            SIR 23164 - suppress AFGC for AFC
                              investigation stages.
  03/01/05  harallh           SIR 23410 - Added CLES and CLEV contract Type.
  07/01/05  berkime           SIR 23298 Added CAGR to contact type, and added
                              logic to disable logic to disable purpose, method,
                              location and others contact field logic to
                              disable purpose,method,location and others
                              contract field
  08/01/05  brauchs           Formatting changes
  08/12/05  werlem            SIR 23895: Fixed problem with display of missing
                              full names; renamed variables according to
                              coding style (camel-case); fixed dependence on
                              equality of string literals (changing variables
                              from String to boolean to reflect actual use).
  08/23/05  dunawakl          SIR 23835 - Added excludeOptions attribute to method
                              selection box toexclude Face to Face option when the
                              program is APS and the stage is Intake.
  10/19/05  brauchs           SIR 24025 - Removed closing table tag to preserve the display
                              of ContactDetail.
  03/13/07  abgoode           Added TCM Information section for TCM contacts only.
  06/19/09  arege             STGAP00014326 MR-024 Changes, Added Checkboxes to select
                              multiple Purpose type for a Contact. 
  07/30/09  arege             STGAP00014857 CaseWorkers with SAU Sealed Attribute should be able to add and modify
                              contacts
  09/07/09  arege             STGAP00015300 Added  conditionally required sign to Name of Agency field.
  10/02/09  mxpatel           STGAP00015282 - when copying, "Permission to cross county lines" also gets copied
  05/27/11  schoi             SMS #109398: MR-086 Added a new field 'Discussed/In Reference To'
                 
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListDetailConversation" %>
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

    String _selSzCdContactType = ContactSearchListDetailConversation.getSelSzCdContactType( request );


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

    //Create an array list of exclusions for the Purpose Select box
    //List<String> excludePurpose = new ArrayList<String>();
    // If the contact type is Request for Review, hide all of the contact
    // purposes for AFC INV except Methodolgy Review and Request for Review
    // Findings.
    //if( _selSzCdContactType.equals( CodesTables.CCNTCTYP_EREV ) &&
    //    GlobalData.getUlIdEvent( request ) == 0 )
    //{
      // hide the contact purpose Assessment-TCM (EAAMT)
      //excludePurpose.add( CodesTables.CCNTPURP_AAMT );

      // hide the contact purpose Case Planning-TCM (EAPLN)
      //excludePurpose.add( CodesTables.CCNTPURP_APLN );

      // hide the contact purpose Coord/Monitor-TCM (EAMON)
      //excludePurpose.add( CodesTables.CCNTPURP_AMON );

      // hide the contact purpose Notification (EANOT)
      //excludePurpose.add( CodesTables.CCNTPURP_ANOT );

      // hide the contact purpose Reassessment (EAREA)
      //excludePurpose.add( CodesTables.CCNTPURP_AREA );
      //System.out.println("******* exclude CCNTPURP_AAMT, CCNTPURP_APLN, CCNTPURP_AMON, CCNTPURP_ANOT, CCNTPURP_AREA");

    //}
    // hide certain codes only for AFC INV's with no Request for Review
    // contacts.
    //if( !_selSzCdContactType.equals( CodesTables.CCNTCTYP_EREV ) &&
    //    GlobalData.getUlIdEvent( request ) == 0 &&
    //    _szCdStage.equals( CodesTables.CSTAGES_INV ) &&
    //    _szCdStageProgram.equals( CodesTables.CPGRMS_AFC ) )
    //{
      // hide the contact purpose Methodology Review (EAMRV)
      //excludePurpose.add( CodesTables.CCNTPURP_AMRV );

      // hide the contact purpose Review of Findings (EARVF)
      //excludePurpose.add( CodesTables.CCNTPURP_ARVF );
    //     System.out.println("******* exclude CCNTPURP_AMRV, CCNTPURP_ARVF");
    //}

    // Hide Request for Review contact purposes for any program other than
    // AFC.
    //if( ( _szCdStage.equals( CodesTables.CSTAGES_INV ) &&
    //      _szCdStageProgram.equals( CodesTables.CPGRMSFM_APS ) ) ||
    //                                                             ( _szCdStage.equals( CodesTables.CSTAGES_SVC ) ||
    //                                                               _szCdStage.equals( CodesTables.CSTAGES_AOC ) ||
    //                                                               _szCdStage.equals( CodesTables.CSTAGES_FPR ) ) )
    //{
      // Hide the contact purpose, notification for APS INV, AOC, and SVC.

    //  if( ( _szCdStage.equals( CodesTables.CSTAGES_INV ) ||
    //        _szCdStage.equals( CodesTables.CSTAGES_SVC ) ||
    //        _szCdStage.equals( CodesTables.CSTAGES_AOC ) ) &&
    //                                                       _szCdStageProgram.equals( CodesTables.CPGRMSFM_APS ) )
    //  {
    //    if( "NOT".equals( _selSzCdContactPurpose ) == false )
    //    {
          // hide the contact purpose Notification. (EANOT)
          //excludePurpose.add( CodesTables.CCNTPURP_ANOT );
    //      System.out.println("******* exclude CCNTPURP_ANOT");
    //    }
    //  }

      // hide the contact purpose Methodology Review (EAMRV)
      //excludePurpose.add( CodesTables.CCNTPURP_AMRV );
    //      System.out.println("******* exclude CCNTPURP_AMRV");

      // hide the contact purpose Review of Findings (EARVF)
      //excludePurpose.add( CodesTables.CCNTPURP_ARVF );
     //     System.out.println("******* exclude CCNTPURP_ARVF");
    //}

    //if( ( !_selSzCdContactType.equals( CodesTables.CCNTCTYP_FCCA ) &&
    //      GlobalData.getUlIdEvent( request ) == 0 &&
    //      _szCdStageProgram.equals( CodesTables.CPGRMSFM_CPS ) &&
    //      _szCdStage.equals( CodesTables.CSTAGES_INV ) ) ||
    //                                                     _szCdStageProgram.equals( CodesTables.CPGRMSFM_CCL ) ||
    //                                                     _szCdStageProgram.equals( CodesTables.CPGRMSFM_RCL ) )
    //{
      // hide the contact purpose Role Info Removal (BRIR)
      //excludePurpose.add( CodesTables.CCNTPURP_BRIR );
     //    System.out.println("******* exclude CCNTPURP_BRIR");
    // }

    // We have to supress the display of BPCV when the Stage is a FPR
    //if( CodesTables.CSTAGES_FPR.equals( GlobalData.getSzCdStage( request ) ) )
    //{
      //excludePurpose.add( CodesTables.CCNTPURP_BPCV );
    //     System.out.println("******* exclude CCNTPURP_BPCV");
    //}

    // SIR 17943 - Suppress the display of BJNT when the Contact Type is not AREG
    //if( !CodesTables.CCNTCTYP_AREG.equals( _selSzCdContactType ) )
    //{
      //excludePurpose.add( CodesTables.CCNTPURP_BJNT );
    //     System.out.println("******* exclude CCNTPURP_BJNT");
    //}

    // SIR 19051 - Suppress display of BPCV when the Stage is not SUB or FSU
    //if( !_szCdStage.equals( CodesTables.CSTAGES_SUB ) ||
    //    !_szCdStage.equals( CodesTables.CSTAGES_FSU ) )
    //{
      //excludePurpose.add( CodesTables.CCNTPURP_BPCV );
    //      System.out.println("******* exclude CCNTPURP_BPCV");
    //}
    //SIR 22880 - Suppress display of AFGC for SVC, AOC Stages & APS INV
    //if( _szCdStage.equals( CodesTables.CSTAGES_SVC ) ||
    //    _szCdStage.equals( CodesTables.CSTAGES_AOC ) ||
    //    ( _szCdStage.equals( CodesTables.CSTAGES_INV ) &&
    //      _szCdStageProgram.equals( CodesTables.CPGRMSFM_APS ) ) )
    //{
      //excludePurpose.add( CodesTables.CCNTPURP_AFGC );
    //     System.out.println("******* exclude CCNTPURP_AFGC");
     //}

    //SIR 23164 - suppress display of AFGC for AFC INV
    //if( _szCdStage.equals( CodesTables.CSTAGES_INV ) &&
    //    _szCdStageProgram.equals( CodesTables.CPGRMSFM_AFC ) )
    //{
      //if they've already chosen a purpose, show what they've chosen
    //  if( !( CodesTables.CCNTPURP_AFGC ).equals( _selSzCdContactPurpose ) )
    //  {
        //excludePurpose.add( CodesTables.CCNTPURP_AFGC );
    //     System.out.println("******* exclude CCNTPURP_AFGC");
    //   }
    //}

//SIR 23835 if the stage is and intake and the program type is APS then do not display
//the face to face method
    //if( _szCdStage.equals( CodesTables.CSTAGES_INT ) &&
    //    _szCdStageProgram.equals( CodesTables.CPGRMSFM_APS ) )
    //{
    //  excludeOptions.add( CodesTables.CCNTMETH_FTF );
    //}
//END SIR 23835

    // SIR 23410. Added logic to disable Purpose,Method,Location and Others Contracted Field
    // for contract type CLES and CLEV and set default vales for all the above mentioned fields.
    // SIR 23298 use this logic as well to disable Purpose, Method, Location and Others Contacted Field
    // for contact type CAGR
    //if( ( _szCdStage.equals( CodesTables.CSTAGES_INV ) ||
    //      _szCdStage.equals( CodesTables.CSTAGES_SVC ) ||
    //      _szCdStage.equals( CodesTables.CSTAGES_AOC ) ) &&
    //                                                     _szCdStageProgram.equals( CodesTables.CPGRMSFM_APS ) )
    //{
    //  if( ( _selSzCdContactType.equals( CodesTables.CCNTCTYP_CLES ) ) ||
    //      ( _selSzCdContactType.equals( CodesTables.CCNTCTYP_CLEV ) ) )
    //  {
    //    purposeDisabled = true;
     //   methodDisabled = true;
    //    locationDisabled = true;
    //    otherDisabled = true;

    //    if( ( "".equals( _selSzCdContactPurpose ) ) || ( _selSzCdContactPurpose == null ) )
    //    {
    //      _selSzCdContactPurpose = CodesTables.CCNTPURP_AMON;
    //    }
    //    if( ( "".equals( _selSzCdContactMethod ) ) || ( _selSzCdContactMethod == null ) )
    //    {
    //      _selSzCdContactMethod = CodesTables.CCNTMETH_LST;
    //    }
    //    if( ( "".equals( _selSzCdContactOthers ) ) || ( _selSzCdContactOthers == null ) )
    //    {
    //      _selSzCdContactOthers = CodesTables.COTHCNCT_ALAW;
    //    }
    //  }
      //if( ( _selSzCdContactType.equals( CodesTables.CCNTCTYP_CAGR ) ) )
      //{
      //  purposeDisabled = true;
      //  methodDisabled = true;
      //  locationDisabled = true;
      //  otherDisabled = true;

      //  if( ( "".equals( _selSzCdContactPurpose ) ) || ( _selSzCdContactPurpose == null ) )
      //  {
      //    _selSzCdContactPurpose = CodesTables.CCNTPURP_AMON;
      //  }
      //  if( ( "".equals( _selSzCdContactMethod ) ) || ( _selSzCdContactMethod == null ) )
      //  {
      //    _selSzCdContactMethod = CodesTables.CCNTMETH_LST;
      //  }
      //  if( ( "".equals( _selSzCdContactOthers ) ) || ( _selSzCdContactOthers == null ) )
      //  {
      //    _selSzCdContactOthers = CodesTables.COTHCNCT_ADAD;
      //  }
      //}
    //}
    //SIR 18503 - Added orderby's to codeArray's

    // SIR 24037 -- It appears that Notification contacts store an invalid purpose in the database.  Because these
    //              types of contacts are ALWAYS editible in IMPACT (even in closed stages), this was not a problem
    //              because the page's javascript prevented the display of the invalid list.  On MPS, they are
    //              read-only, so the invalid purpose code is displayed.  A database search indicates that ONLY
    //              notification contacts have this problem, so just change invalid purposes to blank for read-only
    //              contacts on MPS.
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
  String key = ContactSearchListDetailConversation.getPurposeKey(request);
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
  String key = ContactSearchListDetailConversation.getOthersKey(request);
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
                           options="<%= ContactSearchListDetailConversation.getMethodOptions(request, true) %>"
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
</tr>

 <tr>
  
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
  </tr>

 <tr>
  <td>
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

<%-- Add TCM Information here --%>
<impact:ifThen test="<%= _selSzCdContactType.endsWith("TCM") %>">
<%
  boolean tcmDisabled = otherDisabled;
  String guarantorPC = ContextHelper.getStringSafe(request, "selGuarantorPC");
  String eligible = ContextHelper.getStringSafe(request, "selEligible");
  List<String> eligProgsList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxEligProgs_"));
  String medSvcs = ContextHelper.getStringSafe(request, "selMedSvcs");
  List<String> svcsProvidedList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxSvcsProvided_"));  
  
  List<Option> guarantorPCOptions = ContactSearchListDetailConversation.getGuarantorPCOptions(request);
  Boolean disableGuarantorPC = (Boolean) request.getAttribute(ContactSearchListDetailConversation.DISABLE_TCM_GUARANTOR_PC_NAME);
  disableGuarantorPC = disableGuarantorPC == null ? false : disableGuarantorPC;
  if(disableGuarantorPC) {
    guarantorPC = (guarantorPCOptions.size() > 0 && guarantorPCOptions.get(0) != null) ? guarantorPCOptions.get(0).getCode() : guarantorPC;
  }
  if(tcmDisabled) {
    disableGuarantorPC = true;
  }
  
  //-- see if retrieve struct contains TCM fields
  if(_csys08so.getUlIdTCMClient() > 0 && !PageModeConstants.NEW_USING.equals(_pageMode)) {
    //-- dropdown boxes
    guarantorPC = String.valueOf(_csys08so.getUlIdTCMClient());
    eligible = _csys08so.getSzCdTCMEligible();
    medSvcs = _csys08so.getSzCdTCMMedSvcs();
    
    //-- checkboxes
    ContactCbxDisplay_Array cbxArray = _csys08so.getContactCbxDisplay_Array();
    if(cbxArray != null && cbxArray.getUlRowQty() > 0) {
      eligProgsList = new ArrayList<String>();
      svcsProvidedList = new ArrayList<String>();
      for(ContactCbxDisplay cbxDisplay : cbxArray.getContactCbxDisplay()) {
        String codeType = cbxDisplay.getSzCdCbxCodeType();
        if(CodesTables.CTCMPROG.equals(codeType)) {
          eligProgsList.add(cbxDisplay.getSzCdContactCbx());
        } else if(CodesTables.CTCMSVCS.equals(codeType)) {
          svcsProvidedList.add(cbxDisplay.getSzCdContactCbx());
        }
      }
    }
  }
  
  //-- use this anonymous Comparator to reverse a list of CodeAttributes based on decode value
  Comparator<CodeAttributes> reverseDecodeOrder = new Comparator<CodeAttributes>(){
    public int compare(CodeAttributes c1, CodeAttributes c2) {
      return c2.getDecode().compareTo(c1.getDecode());
    }
  };
  List<CodeAttributes> eligibleOptions = Lookup.getCategoryCollection(CodesTables.CINFPKRQ);
  List<CodeAttributes> medSvcsOptions = Lookup.getCategoryCollection(CodesTables.CINVACAN);
  Collections.sort(eligibleOptions, reverseDecodeOrder);
  Collections.sort(medSvcsOptions, reverseDecodeOrder);
%>
  <table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
    <tr>
      <th colspan="2">TCM Information</th>
    </tr>
    <tr>
      <td width="50%">
        <table width="100%" border="0" cellspacing="0" cellpadding="3">
          <tr>
            <td width="45%">
              <impact:validateSelect
                name="selGuarantorPC"
                label="Guarantor/Primary Child"
                required="true"
                blankValue="false"
                disabled="<%= disableGuarantorPC.toString() %>"
                value="<%= guarantorPC %>"
                options="<%= guarantorPCOptions %>"
                tabIndex="<%= _tabIndex++ %>"
              />
            </td>
          </tr>
        </table>
      </td>
      <td width="50%"/>
    </tr>
    <tr>
      <td>
        <table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
          <tr>
            <td>
              <table width="100%" border="0" cellspacing="0" cellpadding="3">
                <tr>
                  <td width="40%">
                    <impact:validateSelect
                      name="selEligible"
                      label="Eligible (ONG Only)"
                      conditionallyRequired="true"
                      style="width: 100px"
                      disabled="<%= disableGuarantorPC.toString() %>"
                      options="<%= eligibleOptions %>"
                      value="<%= eligible %>"
                      tabIndex="<%= _tabIndex++ %>"
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>
              <div class="formLabel"><span class="formCondRequiredText">&#135;</span>&nbsp;Eligible Programs (Select all that apply):</div>
            </td>
          </tr>
          <tr>
            <td>
              <impact:codesCheckbox
                name="cbxEligProgs_"
                columns="1"
                codesTableName="<%= CodesTables.CTCMPROG %>"
                disabled="<%= disableGuarantorPC.toString() %>"
                defaultCodes="<%= eligProgsList %>"
                tabIndex="<%= _tabIndex++ %>"
              />
            </td>
          </tr>
        </table>
      </td>
      <td>
        <table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
          <tr>
            <td>
              <table width="100%" border="0" cellspacing="0" cellpadding="3">
                <tr>
                  <td>
                    <impact:validateSelect
                      name="selMedSvcs"
                      label="Medical Services (TCM Billable)"
                      required="true"
                      style="width: 100px"
                      disabled="<%= String.valueOf(tcmDisabled) %>"
                      options="<%= medSvcsOptions %>"
                      value="<%= medSvcs %>"
                      tabIndex="<%= _tabIndex++ %>"
                    />
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td>
              <div class="formLabel">
                <span class="formCondRequiredText">&#135;</span>&nbsp;Services Provided (Select all that apply):
              </div>
            </td>
          </tr>
          <tr>
            <td>
              <impact:codesCheckbox
                name="cbxSvcsProvided_"
                columns="1"
                codesTableName="<%= CodesTables.CTCMSVCS %>"
                disabled="<%= String.valueOf(tcmDisabled) %>"
                defaultCodes="<%= svcsProvidedList %>"
                tabIndex="<%= _tabIndex++ %>"
              />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <br>
</impact:ifThen>
<%-- End TCM Information --%>
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
<table width="100%">
<tr>
	<th width="100%">
		<span class="formRequiredText">*</span>Purpose 
	</th>
</tr>
<tr>
   <td> <impact:codesCheckbox 
                name="cbxContactPurpose"
                columns="1"
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
          submitUrl="/contacts/ContactSearchListDetail/displayContact"
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
