package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PageModeStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC18SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC30SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC30SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_MOTHER_RELATIONSHIP;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_MOTHER_RELATIONSHIP_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_OTHER_RELATIONSHIP;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_OTHER_RELATIONSHIP_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildPlanDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to maintain persons in the system. <p/> October 8, 2002 Anna N. Grimshaw <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   04/22/03  GRIMSHAN  SIR #16912 Put code into Save Merge Split so that
 *                       the forward person ID entered will be set into
 *                       global data after the saves are successful.
 *   04/28/03  GRIMSHAN  SIR #16918 Changed the setPersonCharPageSet method
 *                       so that all of the Characteristics divisions will
 *                       be displayed if we are not in a case context
 *   04/28/03  GRIMSHAN  SIR #16995 Added addtional Page set, and changed
 *                       condition for Set C so insure that the stage is not
 *                       INV.  This was done so that The reporter checkbox
 *                       will be disabled for all stages except INV
 *   04/30/03  GRIMSHAN  SIR #17108 Removed View requirement from person
 *                       merge page set when the user has the maintain person
 *                       or merge person security attribute
 *   05/06/03  websted   SIRs 16675, 16868 changed to only add one ethnicity,
 *                       not add the new one and delete the old.
 *   05/07/03 GRIMSHAN   SIR 17285 Added reDisplayEducation_xa so the page would
 *                       be re-displayed with the appropriate fields enabled
 *                       and disabled
 *   05/10/2003  KRD     SIR 17233 - Code changes applied to support
 *                       &quot;Approver Mode&quot; providing supervisors the ability to
 *                       modify data without invalidating the pending
 *                       approval.  Required changes to populateCINV05SI_AU()
 *                       and populateCINV05SI_D().
 *   05/18/03 GRIMSHAN   SIR 17553 - Re-set BIndactive status that has been passed
 *                       from Person Search and person list indicating if the page
 *                       needs to be in employee mode
 *   05/20/03 GRIMSHAN   SIR 16774 - in Person Detail Page Set check Y.equals
 *                       so it will not cause a null pointer exception
 *   05/22/03 GRIMSHAN   SIR 17607 - In Person Detail Page set, reset the page
 *                       mode to view if the page mode is maintain person,
 *                       and the person that is being viewed is an employee.
 *                       Even users with MIP security attribute should not be
 *                       able to update an employees information via person search
 *   05/30/03 GRIMSHAN   SIR 17896 - When setting the name of the person for saving
 *                       person detail, we need to set page size number, not page number
 *   07/10/03 GRIMSHAN   SIR 18786 - Set whether or not the user can be deleted according
 *                       to the events involved in for this stage.
 *   07/21/03 dickmaec   SIR 18963 - The Resource ID was not be being set populateCCFC18SI_AU.
 *                       Add hidden field is passed from the Education Detail page to Person
 *                       Detail page.
 *   07/21/03 dickmaec   SIR 19072 -- Checks the path the user entered the person detail page
 *                       from the person search page.  Added btnRelate.
 *   08/13/03 GRIMSHAN   SIR 19230 - If the window  mode is relate, and relate was not the last
 *                       button pushed, change the window mode to update.
 *   08/18/03 GRIMSHAN   SIR 19549 - CINV05S can throw MSG_NO_ROWS_RETURNED so have the save catch it
 *   08/20/03 GRIMSHAN   SIR 19581 - If person is a former employee don't display the information
 *   08/26/03 A.Corley   SIR 19525 - set a variable into person helper if the person is being related
 *                       this will be cleared on save of the page, so that if the user makes
 *                       changes to detail sections of the page it will still re-display after save.
 *   04/30/04 CORLEYAN   SIR 14516 - Set UlIdcase into person detail retrieve so correct home removal
 *                       rows will be retrieved.
 *   07/21/04 CORLEYAN   SIR 22890 - Since CINV02SOG02 is now 1500 rows long, having it in state is a
 *                       bad idea.  Moved the exclude views loop to the conversation, and set
 *                       the array into request.
 *   08/18/04 CORLEYAN   SIR 22935 - Set person type into person helper for records check
 *   12/17/04 CORLEYAN   SIR 23271 - Added static string &quot;INV&quot;
 *   01/05/05 CORLEYAN   TPR Enhancement - If the user has the restrict event and service level
 *                       review attributes, allow them to only see the LOC and Placement event
 *                       options in the View Options dropdown.  This is done via excludeViews
 *   01/14/05  Hadjimh    SIR 23362. Copy over the phone &amp; addresses from person
 *                        closed to person forward.
 *   07/19/05  PINKSTBA   SIR 23727. MPS PHASE II - Refactored to put common methods into
 *                        PersonDetailBaseConversation and methods with different implementations
 *                        into thier respective (impact/mps) classes.  Also, replaced
 *                        WtcException/WtcHelper references with
 *                        ServiceException/ServiceHelper references.
 *   07/01/05  PINKSTBA   SIR 23727 MPS Phase II.  Created a base class for PersonDetailConversation.
 *                        This class should contain all common methods to MPS and Impact that
 *                        have the same implementation.
 *   07/24/05  cooganpj   SIR 23726 - Rolled in changes to show messages when the user navigates
 *                        to the Merge/Split detail page for a checked out stage.
 *   09/26/05  malpans    SIR 24002 - Disaster Relief Indicator added on Person Detail Page.
 *   03/02/07  hegdens    Modified to add alerts in Income and Resource Detail.
 *   03/09/07  hegdens    Modified to add adoption section in person characterstics detail page.
 *   03/07/08  aroberts   Added method to give ability to view case list for FAD cases
 *   06/15/08  mchillman  STGAP00009116: fields moved from form to page
 *   07/07/08  charden    STGAP00009230 - created and initialized pageModeStruct object and set it into the cinv05si object 
 *                        in populateCinv05si_D method
 *                        
 *   09/11/08  arege      PerSTGAP00004635  Modified populateCINV05SI_AU method so that Person_Category records
 *                        don't get created twice for the same person for a given category, e.g.if a person
 *                        has Category of CAS we should not create one more row in Person_Category with 
 *                        the same category. 
 *  06/24/2009  bgehlot  STGAP00014329: MR-20 updates, New checkbox 'Primary Caretaker Household Member' added to the person detail page
 *  09/30/2009  bgehlot  STGAP00015485: MR-56 Get the mothers, fathers and secondary care givers 
 *                       and change the field 'Member of Primary Caretaker's household'from checkbox to dropdown
 *  02/05/2010  wcochran SMS #43758 - Adds variable indUseStageCode to the request for use by case list.
 *  02/08/2010  mxpatel  CAPTA: Added validations for CAPTA for relationships of CASA/GAL or Atty/Gua Ad Litem to save dtAssigned and UnAssigned
 *  02/10/2010  mxpatel  STGAP00015775:  added new message MSG_ASSIGN_UNASSIGN_DATE_FUTURE .  
 *  02/11/2010  mxpatel  STGAP00015782: added validations to display new message MSG_CHILD_FIRST_INFO.   
 *  02/25/2010  mxpatel  SMS #46411: added validation so that message only displays for children of age between 3 and 18 (Inclusive).            
 *  06/04/2010  mxpatel  MR-066.1:  added code to capture and store SSN number when adding a new person. 
 *  06/10/2010 bgehlot   SMS 56827: Person Detail page saving now after getting Duplicate message    
 *  08/18/2010 bgehlot   SMS 66380 MR-072 Navigate to Records Check list under conditions and add new field Memeber of [Case Name's] Household
 *  08/29/2010 htvo	     MR-067: new field person email to Person Detail page - update populateCINV05SI_AU() method 
 *  09/22/2010  schoi    SMS #71419: Added '?taskCD=NULL' inside of the forward statement to display Records Check tab
 *  11/20/2010  schoi    SMS #81140: MR-074 Added code to populateCINV34SI_AU method
 *                       for new fields on the Person Characteristics page
 *  01/06/2011 htvo      SMS#89914: fixed JSP NPE by resetting the landing page for information message                     
 *  03/20/2011 hnguyen   SMS#97850: MR-075 Added logic to sync FA Person Detail info on save.
 *  08/24/2011 schoi     STGAP00017013: MR-095 Updated addPersonDetail_xa method to add code to retrieve 
 *                       a new section 'Add Person to Active Stages' when a person is added to the system
 *  09/21/2011 schoi     STGAP00017013: MR-095 Restored the following line that was commented out by mistake:
 *                       state.removeAttribute("CINV24SO", request);
 * </pre>
 */
public class PersonDetailConversation extends BaseHiddenFieldStateConversation {
  public static final String AUNT_UNCLE = "AU";

  public static final String CASE_LIST_CALLED = "/workload/CaseSearch/searchCase";

  public static final String CD_CATEGORY_CASE = "CAS";

  public static final String CD_RELATE = "R";

  public static final String CD_STATUS_ACTIVE = "A";

  public static final String CD_VIEWED = "V";

  public static final String CHARACTERISTICS = "CHARACTERISTICS";

  public static final String CLOSED = "0";

  public static final String CPS = "CPS";

  public static final String DISPLAY_FA_HOME = "/person/PersonDetail/displayFAHome";

  public static final String DISPLAY_PERSON_DETAIL = "/person/PersonDetail/displayPersonDetail";
  
  public static final String FAD = "FAD";

  public static final String FORWARD = "1";

  public static final String FOSTER_PARENT = "FP";

  public static final String GODPARENT = "GG";

  public static final String GUARDIAN = "GU";

  public static final String HCS_STAFF = "HC";

  public static final String IND_ACTIVE_STATUS = "bIndActiveStatus";

  public static final String IND_PRIMARY_WORKER = "cSysIndPrimaryWorker";

  public static final String INST_CONT = "IC";

  public static final String INST_PERS = "IP";

  public static final String INT = "INT";

  public static final String INV = "INV";
  
  public static final String FPR = "FPR";

  public static final String MED_FAC_STAFF = "MF";

  public static final String NO_DATA = "0";

  public static final String CHARS_CHECKED = "1";

  public static final String NO_CHARS = "2";

  public static final String NOT_Yet_DIAG = "3";

  public static final String PAGE_MODE = "pageMode";

  public static final String PARENT = "PA";

  public static final String PARENT_BIRTH = "PB";

  public static final String PARENT_LEGAL = "PD";

  public static final String PARENT_PARAMOUR = "PP";

  public static final String PERSON_PASSED_IN = "cWcdPersonPassedIn";

  public static final String PERSON_SEARCH_CALLED = "/person/PersonSearch/searchPersonSearch";

  public static final String PERS_CATEGORY_FA_HOME = "FAH";

  public static final String POT_GUARDIAN = "GV";

  public static final String REQ_FUNC_CD = "cReqFuncCd";

  public static final String STEP_PARENT = "ST";

  public static final String SWITCH = "S";

  public static final String VALIDATE = "V";

  public static final String VIEW_CASE_LIST = "VCL";

  public static final String VIEW_PERSON_EVENTS = "VPE";

  public static final String WINDOW_MODE_MNTN_PERSON = PageModeConstants.PersonDetail.WINDOW_MODE_MNTN_PERSON;

  public static final String WINDOW_MODE_PERSON = PageModeConstants.PersonDetail.WINDOW_MODE_PERSON;

  // WINDOW_MODE_RELATE was window mode lower in caps, so define it as "L"
  public static final String WINDOW_MODE_RELATE = PageModeConstants.PersonDetail.WINDOW_MODE_RELATE;

  public static final int FIFTY = 50;

  public static final int ONE = 1;

  public static final int SIXTY_FIVE = 65;

  public static final int THREE_HUNDRED = 300;

  public static final int TWO_HUNDRED = 200;

  public static final String PLCMT_EVENT = "PLA";

  public static final String LOC_EVENT = "LOC";

  public static final String PREVIOUS_URI_PERSON_DETAIL = "/person/PersonDetail/displayPersonDetail";

  public static final String PREVIOUS_URI_PARAM_NAME = "hdnPreviousURI";

  public static final String U = "U";

  public static final String UNKNOWN = "unknown";

  public static final String YES = "yes";

  public static final String NO = "no";
  
//Interface related variables
  
  public static final String INTERFACE_STATUS = "NEW";
  
  public static final String  CD_TARGET_SYSTEM= "SUC";
  
  public static final String CD_REQ_IDENT = "INQ";
  
  // SMS #81140: MR-074
  public static final String RADIO_SINGLE_PAR_ADPT = "rbSinglePrAdo";
  
  public static final String RADIO_SINGLE_MOM_OR_FAR = "rbSingleMomOrFar";
  //MR-092: Fostering Connections
  public static final String RADIO_IVE_PRIOR_ADOPTION = "rbIVEPriorAdoption";
  
  public static final String CHAR_FORM_NAME = "frmCharDetail";
  
  // End of SMS #81140: MR-074
  
  // STGAP00017013: MR-095
  // yes, no, and N/A indicator codes
  public static final String IND_NA = "NA";
  public static final String IND_NO = "N";
  public static final String IND_YES = "Y";
  // End STGAP00017013: MR-095

  private Person person;

  private Common common;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setPerson(Person person) {
    this.person = person;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  /**
   * Display Person Char <p/> This method is used to display the Person Characteristics Detail Page. It retrieves the
   * Person Characteristics object out of state, and places it back into request. It also retrieves the person's age and
   * Rel/Int from the person detail page so that that information can be relayed to the Person Char page for display and
   * saving information. It then calls the setPersonCharPageSet helper method to determine what page set the Person Char
   * page should currently be in. It then creates 4 array lists from the Person Char Object so that checkbox helper
   * display the correct checkboxes as they are checked.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayPersonChar_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonChar_xa()");
    performanceTrace.enterScope();

    // Retrieve cinv24so from state, remove all other objects, and then re-set
    // cinv24so back into state
    CINV24SO cinv24so = (CINV24SO) state.getAttribute("CINV24SO", request);
    Object cinv04so = state.getAttribute("CINV04SO", request);
    clearState(context);
    state.setAttribute("CINV24SO", cinv24so, request);
    state.setAttribute("CINV04SO", cinv04so, request);

    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
    request.setAttribute("CINV24SO", cinv24so);
    String lNbrPersonAge = ContextHelper.getStringSafe(request, "txtLNbrPersonAge");
    String szCdStagePersRelInt = ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt");
    request.setAttribute("lNbrPersonAge", lNbrPersonAge);
    request.setAttribute("szCdStagePersRelInt", szCdStagePersRelInt);

    
    int age = getAge(request);
    String cdStage = GlobalData.getSzCdStage(request);
    if(CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_ADO.equals(cdStage)){
      if(age >= 3 && age <= 18){
    	  // SMS#89914: corrected the landing page for information message
        setInformationalMessage(Messages.MSG_CHILD_FIRST_INFO, "/person/PersonDetail/displayPersonChar", request);
      }
    }    
    
    // Initialize the vectors for checking the correct checkboxes in Person
    // Characteristics
    List<String> cpmValues = new ArrayList<String>(50);
    List<String> chbValues = new ArrayList<String>(50);
    List<String> cmeValues = new ArrayList<String>(50);
    List<String> cctValues = new ArrayList<String>(50);
    List<String> othValues = new ArrayList<String>(50);

    // String comments = cinv24so.getSzTxtCharCmnts();
    ROWCINV24SOG_ARRAY charArray = cinv24so.getROWCINV24SOG_ARRAY();
    ROWCINV24SOG charRow;
    Enumeration charEnumeration = charArray.enumerateROWCINV24SOG();

    while (charEnumeration.hasMoreElements()) {
      charRow = (ROWCINV24SOG) charEnumeration.nextElement();
      if ("CPM".equals(charRow.getSzCdCharCategory())) {
        cpmValues.add(charRow.getCdCharacteristic());
      } else if ("CHB".equals(charRow.getSzCdCharCategory())) {
        chbValues.add(charRow.getCdCharacteristic());
      } else if ("CME".equals(charRow.getSzCdCharCategory())) {
        cmeValues.add(charRow.getCdCharacteristic());
      } else if ("CCT".equals(charRow.getSzCdCharCategory())) {
        cctValues.add(charRow.getCdCharacteristic());
      } else if ("OTH".equals(charRow.getSzCdCharCategory())) {
        othValues.add(charRow.getCdCharacteristic());
      }

    }
    // request.setAttribute("comments", comments);
    request.setAttribute("cpmValues", cpmValues);
    request.setAttribute("chbValues", chbValues);
    request.setAttribute("cmeValues", cmeValues);
    request.setAttribute("cctValues", cctValues);
    request.setAttribute("othValues", othValues);

    performanceTrace.exitScope();
  }

  /**
   * Display Merge Split <p/> This Method is used to display the Person Merge Split page. It retrieves the ccfc13so
   * object from state, and sets individual important fields into request from that object. It then calls the
   * setMergeSplitPageSet helper method to determine what page set the merge split page should currently be in.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayMergeSplit_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayMergeSplit_xa()");
    performanceTrace.enterScope();

    // Get Index of selected MergeSplit row
    int index = ContextHelper.getIntSafe(request, "hdnMergeLoopCount");

    // Retrieve ccfc13so from state, remove all other objects, and then re-set
    // ccfc13so back into state
    CCFC13SO ccfc13so = (CCFC13SO) state.getAttribute("CCFC13SO", request);
    clearState(context);
    state.setAttribute("CCFC13SO", ccfc13so, request);

    // Put only necessary data on request for use by jsp
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
    request.setAttribute(IND_ACTIVE_STATUS, ccfc13so.getBIndActiveStatus());
    request.setAttribute(IND_PRIMARY_WORKER, ccfc13so.getCSysIndPrimaryWorker());
    request.setAttribute("ROWCCFC13SOG00", ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(index));

    // Set the page mode set for the jsp
    setMergeSplitPageSet(user, context, ccfc13so.getCSysIndPrimaryWorker());

    // SIR 23726 - Show case checkedout message when accessed from a stage checked out to MPS
    if (CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request))
        && !PageModeConstants.VIEW.equals(PersonHelper.getPersonDetailPageMode(request))
        && !GlobalData.isApprovalMode(request)) {
      setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, request);
    }

    performanceTrace.exitScope();
  }

  /**
   * Set Person Detail Page Set <p/> This method is used to determine the current set for the Person Merge Split page
   * 
   * @param user
   *          User Profile Object
   * @param context
   *          The GrndsExchangeContext Object
   * @param primaryWorker
   *          Indicates if the worker logged in is the primary worker
   */
  public void setMergeSplitPageSet(UserProfile user, GrndsExchangeContext context, String primaryWorker) {
    HttpServletRequest request = context.getRequest();
    // The fields on the Merge/Split page act the same based these two
    // conditions
    //
    // SIR 17108 GRIMSHAN -- Removed the View mode requirement if the user has
    // the security attributes
    // the set will be set A regardless
    // If the the user has Maintain Person or Merge Person
    // Security attributes
    if (user.hasRight(UserProfile.SEC_MNTN_PERSON) || user.hasRight(UserProfile.SEC_MERGE_PERSON)){
      Sets.setPageSet(Sets.A, request);
    }
  }

  /**
   * Display FA Home <p/> This method is used to display the FA Home detail page. It retrieves the FA Home Object out of
   * state, and places the individual row that has been selected in the person detail page into request. It also sets a
   * page mode variable into request so that the pageMode in Person Helper does not get overwritten with the individual
   * page mode for this detail page.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayFAHome_xa(GrndsExchangeContext context) {
    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFAHome_xa()");
      performanceTrace.enterScope();

      // Get index for selected FAHome row
      int index = ContextHelper.getIntSafe(request, "hdnFALoopCount");

      // Retrieve cfad32so from state, remove all other objects, and then re-set
      // cfad32so back into state
      CFAD32SO cfad32so = (CFAD32SO) state.getAttribute("CFAD32SO", request);
      clearState(context);
      state.setAttribute("CFAD32SO", cfad32so, request);

      // Set selected row object and func code into state for use on jsp.
      request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
      state.setAttribute("CFAD32SOG00", cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(index), request);

      // Set a page mode variable into the request based on what the
      // PersonHelper page mode is, this is so that
      // the state page mode will not be changed when navigating to a detail
      // page
      String globalPageMode = PersonHelper.getPersonDetailPageMode(request);
      String pageMode = StringHelper.EMPTY_STRING;

      if (PageModeConstants.MODIFY.equals(globalPageMode) || WINDOW_MODE_RELATE.equals(globalPageMode)
          || WINDOW_MODE_MNTN_PERSON.equals(globalPageMode) || PageModeConstants.NEW.equals(globalPageMode)) {
        pageMode = PageModeConstants.MODIFY;
      } else if (PageModeConstants.VIEW.equals(globalPageMode)) {
        pageMode = PageModeConstants.VIEW;
      }
      request.setAttribute(PAGE_MODE, pageMode);

      performanceTrace.exitScope();
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }

  /**
   * Select Resource <p/> This method is used to call the Resource Search Conversation. It forwards all of the search
   * information to Resource Search, but also sets all of the Detail fields that may have already been entered on the
   * page into state so that they can be retrieved and re-set upon return to the Education Detail page.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void selectResource_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".selectResource_xa()");
    performanceTrace.enterScope();

    // request.setAttribute("destinationUrl", "/person/PersonDetail/addEducation");
    // Set detail fields that are not populated by the pull back into the
    // education display
    // SO object so that they can be redisplayed after the pull back is complete
    ROWCCFC17SOG00 rowccfc17sog00 = new ROWCCFC17SOG00();
    rowccfc17sog00.setUlIdEdhist(ContextHelper.getIntSafe(request, "hdnUlIdEdhist"));
    rowccfc17sog00
                  .setTsLastUpdate(DateHelper
                                             .toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsEduLastUpdate")));
    rowccfc17sog00.setSzCdEdhistType(ContextHelper.getStringSafe(request, "szCdEdhistType"));
    rowccfc17sog00.setSzIndEdhistLicense(ContextHelper.getStringSafe(request, "szIndEdhistLicense"));
    rowccfc17sog00.setSzEdHistComments(ContextHelper.getStringSafe(request, "szTxtEdhistCmnts"));

    rowccfc17sog00.setCIndEdhistTeaSchool(ContextHelper.getStringSafe(request, "rbCIndEdhistTeaSchool"));
    rowccfc17sog00.setSzCdEdhistEnrollGrade(ContextHelper.getStringSafe(request, "selSzCdEdhistEnrollGrade"));
    rowccfc17sog00.setSzCdEdhistWithdrawnGrade(ContextHelper.getStringSafe(request, "selSzCdEdhistWithdrawnGrade"));

    // Only set the dates into the object if they are not null. If they are null
    // they come back as NULL_CASTOR_DATE on redisplay
    if (ContextHelper.getStringSafe(request, "txtDtDtEdhistEnrollDate") != null) {
      rowccfc17sog00
                    .setDtDtEdhistEnrollDate(DateHelper
                                                       .toCastorDateSafe(ContextHelper
                                                                                      .getStringSafe(request,
                                                                                                     "txtDtDtEdhistEnrollDate")));
    }
    if (ContextHelper.getStringSafe(request, "txtDtDtEdhistWithdrawnDate") != null) {
      rowccfc17sog00
                    .setDtDtEdhistWithdrawnDate(DateHelper
                                                          .toCastorDateSafe(ContextHelper
                                                                                         .getStringSafe(request,
                                                                                                        "txtDtDtEdhistWithdrawnDate")));
    }
    // Each one of the checkboxes has its own set method, check to see if they
    // are checked,
    // if they are set the set method to the value of that checkbox (which will
    // be the code
    // from the codes table.
    String cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds1");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds1(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds2");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds2(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds3");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds3(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds4");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds4(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds5");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds5(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds6");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds6(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds7");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds7(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds8");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds8(cbxSzCdEdhistNeeds);
    }
    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds9");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds9(cbxSzCdEdhistNeeds);
    }
    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds10");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc17sog00.setSzCdEdhistNeeds10(cbxSzCdEdhistNeeds);
    }
    rowccfc17sog00.setRbSchoolRecs(ContextHelper.getStringSafe(request, "rbSchoolRecs"));
    rowccfc17sog00.setRbRecsToBCounty(ContextHelper.getStringSafe(request, "rbRecsToBCounty"));
    rowccfc17sog00.setRbSchoolChange(ContextHelper.getStringSafe(request, "rbSchoolChange"));
    rowccfc17sog00.setSzTxtBehaveDisc(ContextHelper.getStringSafe(request, "szTxtBehaveDisc"));
    rowccfc17sog00.setRbSpecialEdNeeds(ContextHelper.getStringSafe(request, "rbSpecialEdNeeds"));
    rowccfc17sog00.setRbSpecialEdSvc(ContextHelper.getStringSafe(request, "rbSpecialEdSvc"));
    rowccfc17sog00.setSzTxtSpecialEdCmnts(ContextHelper.getStringSafe(request, "szTxtSpecialEdCmnts"));
    rowccfc17sog00.setSzDtStSupTeamRef(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                             "szDtStSupTeamRef")));
    rowccfc17sog00.setSzDtRbEdDate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "szDtRbEdDate")));
    rowccfc17sog00.setTxtSurrogateParent(ContextHelper.getStringSafe(request, "txtSurrogateParent"));
    rowccfc17sog00.setRbIndFosterParent(ContextHelper.getStringSafe(request, "rbIndFosterParent"));
    rowccfc17sog00.setRbLegalParent(ContextHelper.getStringSafe(request, "rbLegalParent"));
    rowccfc17sog00.setSzTxtSstIepCmnts(ContextHelper.getStringSafe(request, "szTxtSstIepCmnts"));
    rowccfc17sog00.setRbChildServices(ContextHelper.getStringSafe(request, "rbChildServices"));
    rowccfc17sog00.setRbPrevChildSvc(ContextHelper.getStringSafe(request, "rbPrevChildSvc"));
    rowccfc17sog00.setSzTxtChildSvcComments(ContextHelper.getStringSafe(request, "szTxtChildSvcComments"));
    rowccfc17sog00.setRbCIndEdhistLevel(ContextHelper.getStringSafe(request, "rbCIndEdhistLevel"));
    rowccfc17sog00.setSzCEdhistCurrentGradeLevel(ContextHelper.getStringSafe(request, "selSzCEdhistCurrentGradeLevel"));
    rowccfc17sog00.setSzCEdhistAttendance(ContextHelper.getStringSafe(request, "selSzCEdhistAttendance"));
    //STGAP00009116: fields moved from form to page
    rowccfc17sog00.setSzTxtSchoolChangeCmnts(ContextHelper.getStringSafe(request, "txtSchoolChangeComment"));
    rowccfc17sog00.setSzTxtSchoolRecordsCmnts(ContextHelper.getStringSafe(request, "txSchoolRecordsComment"));

    String PageName;
    if (state.getAttribute("pageName", request) == null) {
      PageName = ContextHelper.getStringSafe(request, "pageName");
    } else {
      PageName = (String) state.getAttribute("pageName", request);
    }
    if ("ChildPlan".equals(PageName)) {
      ChildPlanDetailRetrieveSO childPlanDetailRetrieveSO = (ChildPlanDetailRetrieveSO) state
                                                                                             .getAttribute(
                                                                                                           "ChildPlanDetailRetrieveSO",
                                                                                                           request);
      state.setAttribute("ChildPlanDetailRetrieveSO", childPlanDetailRetrieveSO, request);
      request.setAttribute("pageName", "ChildPlanEdu");
      PageName = "ChildPlanEdu";
      state.setAttribute("pageName", PageName, request);
    }

    state.setAttribute("rowccfc17sog00", rowccfc17sog00, request);
    request.setAttribute("destinationUrl", "/person/PersonDetail/addEducation");
    performanceTrace.exitScope();
  }

  // public static boolean displayAPSCharacteristics(HttpServletRequest request) {
  // return ((isAFC(request)) || (isAPS(request)) || (isNonStageContext(request)));
  // }

  public static boolean displayChildInvestCharacteristics(HttpServletRequest request) {
    // return (isAPS(request) == false);
    int age = getAge(request);
    return (age <= 17);
  }

  // If it is not in Set if (there is a valid Program Type, then the Parent
  // Caretaker
  // category is only displayed if the Program is CPS and the person is an
  // adult. Or if the Program is CPS and the person is a minor but has the
  // Rel/Int
  // of Guardian, Potential Guardian, Parent (Birth), Parent (Legal Only),
  // Step Parent, Aunt, Uncle, God Parent or Parent Paramour. Or if the Program
  // is RCL and the Rel/Int is Foster Parent. Or if the Program is AFC, and the
  // Rel/Int is HCS Staff, Medical Facility Staff, Institution, Contracted,
  // or institution Personnel.
  public static boolean displayParentCharacteristics(HttpServletRequest request) {
    // BaseSessionStateManager state = getSessionStateManager(request);
    // CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);

    // String relInt = FormattingHelper.formatString(cinv04so.getSzCdStagePersRelInt());

    int age = getAge(request);

    // !!! relInts for CPS don't match up with design state Anna gave me
    /*
     * return (((isCPS(request)) && ((age > 17) || (relInt.equals(AUNT_UNCLE)) || (relInt.equals(PARENT)) ||
     * (relInt.equals(GODPARENT)) || (relInt.equals(GUARDIAN)) || (relInt.equals( POT_GUARDIAN)) ||
     * (relInt.equals(PARENT_BIRTH)) || (relInt.equals(PARENT_PARAMOUR)) || (relInt.equals(STEP_PARENT)))) ||
     * 
     * ((isRCL(request)) && (relInt.equals(FOSTER_PARENT))) ||
     * 
     * ((isAFC(request)) && ((relInt.equals(HCS_STAFF)) || (relInt.equals(MED_FAC_STAFF)) || (relInt.equals(INST_CONT)) ||
     * (relInt.equals(INST_PERS)))) ||
     * 
     * (isNonStageContext( request)));
     */
    return (age > 17);
  }

  /**
   * Display FA Home List <p/> This helper method is used to call CFAD32S for retrieving the list information for FA
   * Home List It calls the populateCFAD32SI helper method to populate the input object for retrieving.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @throws org.exolab.castor.xml.MarshalException
   * 
   * @throws org.exolab.castor.xml.MarshalException
   *           Thrown if there are problems with castor
   */

  public void displayFAHomeList(GrndsExchangeContext context) throws ServiceException, MarshalException,
                                                             ValidationException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CFAD32SI cfad32si = populateCFAD32SI_Retrieve(context);
    // String outputXml5 = ServiceHelper.callService("CFAD32S",cfad32si);
    // CFAD32SO cfad32so = CFAD32SO.unmarshal(new StringReader(outputXml5));
    CFAD32SO cfad32so = common.retrieveFAHomeMemberTraining(cfad32si);
    state.setAttribute("CFAD32SO", cfad32so, request);
  }// End FA Home }

  /**
   * Save Merge Split <p/> This method is used to save the either a Merge or Split from the Merge Split detail page. It
   * calls the populateCCFC14SI_AU helper method to populate the input object for the service CCFC14S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void saveMergeSplit_xa(GrndsExchangeContext context) {

    // Saves either a merge or a split(s) depending upon what
    // happened on the page. This save service cannot be
    // called unless the user previously did a validate to
    // make sure the save would be valid. The save 'process'
    // is broken up into two service calls. The first save
    // performs all of the checks that the validate service does
    // and updates all appropriate tables except for the address
    // and phone information. If the first save service is
    // successful, the second save service is called to update
    // the person address and phone if the primaries were different
    // and sends out ToDo's to all all of the appropriate workers.
    // The return code of the second service is essentially ignored
    // since the first service was successful.

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveMergeSplit_xa()");
    performanceTrace.enterScope();

    // SIR 23726 - If either the forward or closed person is a part of a stage checked out to MPS,
    // do not call the merge/split service and display error message.

    if (CaseUtility.getCheckedOutPersonStatus(ContextHelper.getIntSafe(request, "txtUlIdPersMergeForward"),
                                              ContextHelper.getIntSafe(request, "txtUlIdPersMergeClosed"))) {
      this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      setErrorMessage(Messages.MSG_MPS_PERSON_MERGE_VAL, request);
    } else {
      try {
        // SIR 16912 GRIMSHAN -- Get the ulIdPerson Forward from the field and
        // set it into
        // state. If the save is sucsessful, this ID will be placed into global
        // data
        // for re-display of the forward person detail page

        // 09/03/2003, THIS SHOULD !!NOT!! BE TRANSACTIONAL

        String ulIdPersonS = ContextHelper.getStringSafe(request, "txtUlIdPersMergeForward");
        state.setAttribute("ulIdPersonS", ulIdPersonS, request);

        CCFC14SI ccfc14si = populateCCFC14SI_AU(context);

        /*
         * String outputXml = ServiceHelper.callService("CCFC14S", ccfc14si); CCFC14SO ccfc14so = CCFC14SO.unmarshal(new
         * StringReader(outputXml));
         */
        CCFC14SO ccfc14so = person.savePersonMerge(ccfc14si);
        request.setAttribute("CCFC14SO", ccfc14so);
        // sir 23362. ccfc50s does not exist any more. the logic & code
        // has been rewritten in ccfc14s
        // CCFC50SI ccfc50si = populateCCFC50SI_AU( context );
        // WtcHelper.callService( "CCFC50S", ccfc50si.toString());

        // SIR 16912 GRIMSHAN -- If the saves were successful, put the
        // ulIdPerson forward into
        // global data for redisplay of the Person Detail page.

        int ulIdPerson = Integer.parseInt((String) state.getAttribute("ulIdPersonS", request));
        GlobalData.setUlIdPerson(ulIdPerson, request);
      } catch (ServiceException we) {
        int errorCode = we.getErrorCode();
        switch (errorCode) {
        case Messages.SQL_NOT_FOUND:
          errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;

        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        case Messages.MSG_DUPLICATE_RECORD:
        case Messages.MSG_SECOND_MERGE_ERROR:
          this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage(errorCode, context.getRequest());
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
        }
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    }
    performanceTrace.exitScope();
  }

  /**
   * Validate Merge <p/> This method is used to Validate the two person IDs entered in the Person Merge Split. It first
   * retrieves the detail fields entered so that they can be re-populated upon return from this method. It then calls
   * the populateCCFC23SI_V helper method to populate the input object for the CCFC23S service Upon return, if there are
   * error messages from the service, it forwards them to the error list conversation. Finally it re-sets the previously
   * retrieved information into the request, and sets the reqFuncCd to "V" so that the jsp can determine where to get
   * the detail field information from.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void validateMerge_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateMerge_xa()");
    performanceTrace.enterScope();
    try {
      // Set The page information into state so that they can be repopulated
      // after the validate
      String ulIdPersMergeForward = (ContextHelper.getStringSafe(request, "txtUlIdPersMergeForward"));
      String ulIdPersMergeClosed = (ContextHelper.getStringSafe(request, "txtUlIdPersMergeClosed"));
      String szScrNmPersMergeForward = (ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeForward"));
      String SzScrNmPersMergeClosed = (ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeClosed"));
      String cWcdPersonPassedIn = (ContextHelper.getStringSafe(request, "hdnCWcdPersonPassedIn"));
      String bIndActiveStatus = (ContextHelper.getStringSafe(request, "hdnBIndActiveStatus"));
      String cSysIndPrimaryWorker = (ContextHelper.getStringSafe(request, "hdnCSysIndPrimaryWorker"));

      CCFC23SI ccfc23si = populateCCFC23SI_V(context);
      /*
       * String outputXml = ServiceHelper.callService("CCFC23S", ccfc23si); CCFC23SO ccfc23so = CCFC23SO.unmarshal(new
       * StringReader(outputXml));
       */
      CCFC23SO ccfc23so = person.personMergeValidation(ccfc23si);
      if (ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY() != null) {
        // Get the array of errors out of the output object
        SzCdUerrorMsgNbr_ARRAY errorList = ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY();

        // Create an int array using the getSzCdUerrorMsgNbr which returns an
        // int[]
        int[] errorArray = errorList.getSzCdUerrorMsgNbr();

        if (errorArray.length > 0) {
          ErrorList.setErrors(errorArray, request);
        }
      }

      // Set the ReqFuncCd to Validate so the jsp will know where to get the
      // information for
      // its fields from, as well all of the other detail fields
      request.setAttribute(REQ_FUNC_CD, VALIDATE);
      request.setAttribute(PERSON_PASSED_IN, cWcdPersonPassedIn);
      request.setAttribute(IND_ACTIVE_STATUS, bIndActiveStatus);
      request.setAttribute(IND_PRIMARY_WORKER, cSysIndPrimaryWorker);
      request.setAttribute("txtUlIdPersMergeForward", ulIdPersMergeForward);
      request.setAttribute("txtUlIdPersMergeClosed", ulIdPersMergeClosed);
      request.setAttribute("dspSzScrNmPersMergeForward", szScrNmPersMergeForward);
      request.setAttribute("dspSzScrNmPersMergeClosed", SzScrNmPersMergeClosed);
      request.setAttribute("bIndValidate", ArchitectureConstants.Y);
      request.setAttribute("CCFC23SO", ccfc23so);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * populateCCFC18SI_AU <p/> This populate method is used when an Education row is added or saved It populates the
   * input object for CCFC18S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc18si
   */
  public CCFC18SI populateCCFC18SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    ROWCCFC18SIG00 rowccfc18sig00 = new ROWCCFC18SIG00();
    CCFC18SI ccfc18si = new CCFC18SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCFC18SIG00_ARRAY rowccfc18sig00_array = new ROWCCFC18SIG00_ARRAY();
    int personID = GlobalData.getUlIdPerson(request);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    // Only one row is ever saved or deleted, so statically set the page size
    // number to 1
    input.setUlPageSizeNbr(ONE);
    input.setSzUserId(user.getUserLogonID());
    ccfc18si.setUlIdPerson(personID);

    AdminAddressPhoneBean aapBean = (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest(request);

    rowccfc18sig00.setSzNbrEdhistPhone(aapBean.getPhone());
    rowccfc18sig00.setSzNbrEdhistPhoneExt(aapBean.getPhoneExt());

    rowccfc18sig00.setSzAddrEdhistStreetLn1(aapBean.getAddress1());
    rowccfc18sig00.setSzAddrEdhistStreetLn2(aapBean.getAddress2());
    rowccfc18sig00.setSzAddrEdhistCity(aapBean.getCity());
    rowccfc18sig00.setSzAddrEdhistState(aapBean.getState());
    rowccfc18sig00.setSzAddrEdhistZip(aapBean.getZipAndSuff());
    rowccfc18sig00.setSzAddrEdhistCnty(aapBean.getCounty());
    rowccfc18sig00.setSzTxtEdhistAddrCmnt(aapBean.getComments());

    rowccfc18sig00.setUlIdEdhist(ContextHelper.getIntSafe(request, "hdnUlIdEdhist"));
    rowccfc18sig00
                  .setTsLastUpdate(DateHelper
                                             .toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsEduLastUpdate")));
    rowccfc18sig00.setSzCdScrDataAction(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    rowccfc18sig00.setCIndEdhistTeaSchool(ContextHelper.getStringSafe(request, "rbCIndEdhistTeaSchool"));
    rowccfc18sig00.setSzNmEdhistSchool(ContextHelper.getStringSafe(request, "txtSzNmEdhistSchool"));
    rowccfc18sig00
                  .setDtDtEdhistEnrollDate(DateHelper
                                                     .toCastorDateSafe(ContextHelper
                                                                                    .getStringSafe(request,
                                                                                                   "txtDtDtEdhistEnrollDate")));
    rowccfc18sig00.setSzCdEdhistEnrollGrade(ContextHelper.getStringSafe(request, "selSzCdEdhistEnrollGrade"));
    rowccfc18sig00
                  .setDtDtEdhistWithdrawnDate(DateHelper
                                                        .toCastorDateSafe(ContextHelper
                                                                                       .getStringSafe(request,
                                                                                                      "txtDtDtEdhistWithdrawnDate")));
    rowccfc18sig00.setSzCdEdhistWithdrawnGrade(ContextHelper.getStringSafe(request, "selSzCdEdhistWithdrawnGrade"));
    rowccfc18sig00.setSzNmEdhistSchDist(ContextHelper.getStringSafe(request, "dspSzNmEdhistSchDist"));
    rowccfc18sig00.setSzCdEdhistType(ContextHelper.getStringSafe(request, "szCdEdhistType"));
    rowccfc18sig00.setSzIndEdhistLicense(ContextHelper.getStringSafe(request, "szIndEdhistLicense"));
    rowccfc18sig00.setSzEdHistComments(ContextHelper.getStringSafe(request, "szTxtEdhistCmnts"));

    // STGAP00005624 - it is a resource when isResource or might be one if neither In State or Out of State selected
    // isResource changed when flipping between In/Out State or changing Edu Type, controlled by jscript, but 
    // idResource stays until another select resource performed
    String isResource = ContextHelper.getStringSafe(request, "hdnIsResource");
    String inOutState = ContextHelper.getStringSafe(request, "rbCIndEdhistTeaSchool");
    if (StringHelper.isTrue(isResource) || !StringHelper.isValid(inOutState)) {
    // SIR 18963 -- Resource Id needs to be set.
    rowccfc18sig00.setUlIdResource(ContextHelper.getIntSafe(request, "hdnResourceID"));
    } else {
      rowccfc18sig00.setUlIdResource(0);
    }

    // Each one of the checkboxes has its own set method, check to see if they
    // are checked,
    // if they are set the set method to the value of that checkbox (which will
    // be the code
    // from the codes table.
    String cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds1");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds1(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds2");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds2(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds3");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds3(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds4");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds4(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds5");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds5(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds6");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds6(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds7");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds7(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds8");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds8(cbxSzCdEdhistNeeds);
    }
    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds9");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds9(cbxSzCdEdhistNeeds);
    }
    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds10");
    if (cbxSzCdEdhistNeeds != null) {
      rowccfc18sig00.setSzCdEdhistNeeds10(cbxSzCdEdhistNeeds);
    }
    // New Fields R2

    rowccfc18sig00.setRbSchoolRecs(ContextHelper.getStringSafe(request, "rbSchoolRecs"));
    rowccfc18sig00.setRbRecsToBCounty(ContextHelper.getStringSafe(request, "rbRecsToBCounty"));
    rowccfc18sig00.setRbSchoolChange(ContextHelper.getStringSafe(request, "rbSchoolChange"));
    rowccfc18sig00.setSzTxtBehaveDisc(ContextHelper.getStringSafe(request, "szTxtBehaveDisc"));
    rowccfc18sig00.setRbSpecialEdNeeds(ContextHelper.getStringSafe(request, "rbSpecialEdNeeds"));
    rowccfc18sig00.setRbSpecialEdSvc(ContextHelper.getStringSafe(request, "rbSpecialEdSvc"));
    rowccfc18sig00.setSzTxtSpecialEdCmnts(ContextHelper.getStringSafe(request, "szTxtSpecialEdCmnts"));
    rowccfc18sig00.setSzDtStSupTeamRef(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                             "szDtStSupTeamRef")));
    rowccfc18sig00.setSzDtRbEdDate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "szDtRbEdDate")));
    rowccfc18sig00.setTxtSurrogateParent(ContextHelper.getStringSafe(request, "txtSurrogateParent"));
    rowccfc18sig00.setRbIndFosterParent(ContextHelper.getStringSafe(request, "rbIndFosterParent"));
    rowccfc18sig00.setRbLegalParent(ContextHelper.getStringSafe(request, "rbLegalParent"));
    rowccfc18sig00.setSzTxtSstIepCmnts(ContextHelper.getStringSafe(request, "szTxtSstIepCmnts"));
    rowccfc18sig00.setRbChildServices(ContextHelper.getStringSafe(request, "rbChildServices"));
    rowccfc18sig00.setRbPrevChildSvc(ContextHelper.getStringSafe(request, "rbPrevChildSvc"));
    rowccfc18sig00.setSzTxtChildSvcComments(ContextHelper.getStringSafe(request, "szTxtChildSvcComments"));
    rowccfc18sig00.setRbCIndEdhistLevel(ContextHelper.getStringSafe(request, "rbCIndEdhistLevel"));
    rowccfc18sig00.setSzCEdhistCurrentGradeLevel(ContextHelper.getStringSafe(request, "selSzCEdhistCurrentGradeLevel"));
    rowccfc18sig00.setSzCEdhistAttendance(ContextHelper.getStringSafe(request, "selSzCEdhistAttendance"));
    rowccfc18sig00.setSzTxtSchoolChangeCmnts(ContextHelper.getStringSafe(request, "txtSchoolChangeComment"));
    rowccfc18sig00.setSzTxtSchoolRecordsCmnts(ContextHelper.getStringSafe(request, "txSchoolRecordsComment"));
    // Add the struct to the array
    rowccfc18sig00_array.addROWCCFC18SIG00(rowccfc18sig00);
    // Set the array into the parent struct
    ccfc18si.setROWCCFC18SIG00_ARRAY(rowccfc18sig00_array);
    return ccfc18si;
  }

  /**
   * populateCINV05SI_AU <p/> This method is used to populatethe CINV05S input object for saving the Person Detail
   * Detail Information. It also saves the Race/Ethnicity information on the page.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cinv05si
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException
   *           This is thrown when a bad page mode is passed to the method
   */
  public CINV05SI populateCINV05SI_AU(GrndsExchangeContext context) throws PopulationException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CINV05SI cinv05si = new CINV05SI();

    // Declare variables to be used in this method
    boolean bIndFAH = false;
    boolean bIndCase = false;
    boolean bIndSsnCheck = "Y".equals(ContextHelper.getStringSafe(context, "hdnBIndSsnCheck"));
    ArchInputStruct input = new ArchInputStruct();
    // Populate the input object sub-structures from the request,
    input.setBPerfInd(ArchitectureConstants.Y);
    input.setBDataAcsInd(ArchitectureConstants.Y);
    // Create a Variable to check the Required Funciton Code, set that Function
    // code into the input for the CINV05S
    String cReqFuncCd;
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    // Items coming out of GlobalData
    cinv05si.setBIndSsnCheck(bIndSsnCheck);
    cinv05si.setUlIdStage(GlobalData.getUlIdStage(request));
    cinv05si.setSzCdTask(GlobalData.getSzCdTask(request));
    cinv05si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    cinv05si.setUlIdCase(GlobalData.getUlIdCase(request));
    cinv05si.setSzNmPersonFull(GlobalData.getSzNmPersonFull(request));
    cinv05si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    // SIR 18936 set the ulidpersonid as the users id so that alert todos will
    // be
    // created only when necessary.
    cinv05si.setUlIdPersonId(user.getUserID());
    // Set a variable for pageMode and stage it will be used for business logic,
    // later in the
    // population method
    PageModeStruct pageModeStruct = new PageModeStruct();
    String szCdStage = GlobalData.getSzCdStage(request);
    String pageMode = PersonHelper.getPersonDetailPageMode(request);
    pageModeStruct.setPageModeType(pageMode);
    cinv05si.setPageModeStruct(pageModeStruct);
    
    // Populate the User ID for saving from the User Profile information

    // begin: populate race/ethnicity
    RaceEthnicityBean reBean = RaceEthnicityHelper.getFromRequest(request);
    ROWCINV05SIG01_ARRAY raceArray = new ROWCINV05SIG01_ARRAY();
    ROWCINV05SIG02_ARRAY ethArray = new ROWCINV05SIG02_ARRAY();

    String ethnicity = reBean.getEthnicity();
    RaceEthnicityBean.Races races = reBean.getRaces();

    while (races.hasNext()) {
      RaceEthnicityBean.Race race = races.next();
      ROWCINV05SIG01 raceRow = new ROWCINV05SIG01();
      raceRow.setSzCdPersonRace(race.getValue());
      raceRow.setSzCdScrDataAction(race.getActionCode());
      raceArray.addROWCINV05SIG01(raceRow);
    }

    // If the old ethnicity is equivalant to the new ethnicity no need to
    // resave the information. If they are not equal, Add the new Eth.
    // The DAM automatically deletes the old eth.
    // if( !ethnicity.equals( reBean.getOldEthnicity() ) )
    // {
    ROWCINV05SIG02 ethRow = new ROWCINV05SIG02();
    ethRow.setSzCdPersonEthnicity(ethnicity);
    // STGAP00002754 
    if (0 == GlobalData.getUlIdPerson(request)) {
      ethRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      ethRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    // end STGAP00002754 
    ethArray.addROWCINV05SIG02(ethRow);

    // ** DWW: 05/06/2003
    // ** SIRs 16675, 16868
    // ** changed to only add one ethnicity, not add the new one and delete the
    // old.

    // ethRow = new ROWCINV05SIG02();
    // ethRow.setSzCdPersonEthnicity( reBean.getOldEthnicity() );
    // ethRow.setSzCdScrDataAction( WtcHelper.REQ_FUNC_CD_DELETE );
    // ethArray.addROWCINV05SIG02( ethRow );
    // }

    cinv05si.setROWCINV05SIG01_ARRAY(raceArray);
    cinv05si.setROWCINV05SIG02_ARRAY(ethArray);
    cinv05si.setSzCdPersonEthnicGroup(RaceEthnicityHelper.getRaceEthnicityGroup(reBean, request));
    // end: populate race/ethnicity

    // All of the regular Inputs will be done first, then the business logic.
    // This is so that the Business Logic can overwrite the input message
    // information
    // if needed

    // Get First Middle and Last name in order to make szNmPersonFull, this will
    // also be used later
    // if the window mode is new
    String nameFirst = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameFirst"));
    String nameLast = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameLast"));
    String nameMiddle = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameMiddle"));

    String nameFull = FormattingHelper.formatFullName(nameFirst, nameMiddle, nameLast);
    if ((StringHelper.EMPTY_STRING.equals(nameFirst)) && (StringHelper.EMPTY_STRING.equals(nameMiddle))
        && (StringHelper.EMPTY_STRING.equals(nameLast))) {
      nameFull = GlobalData.getSzNmPersonFull(request);

      if (StringHelper.EMPTY_STRING.equals(nameFull)) {
        nameFull = "Unknown " + GlobalData.getUlIdPerson(request);
      }
    }

    String DOB = ContextHelper.getStringSafe(request, "txtDateDtPersonBirth");
    String dtAssigned = ContextHelper.getStringSafe(request, "txtDateDtLegRepAssigned");
    String dtUnassigned = ContextHelper.getStringSafe(request, "txtDateDtLegRepUnassigned");
    int age = ContextHelper.getIntSafe(request, "txtLNbrPersonAge");

    // Always calculate the age from DOB when saving. Need a different variable
    // for this since DOB is caluclated from the age on the page in new mode
    int ageS;
    ageS = DateHelper.getAge(DateHelper.toCastorDateSafe(DOB));

    cinv05si.setSzNmPersonFull(nameFull);

    // Demographics
    cinv05si.setCCdPersonSex(ContextHelper.getStringSafe(request, "selCdPersonSex"));
    cinv05si.setSzCdDisasterRlf(ContextHelper.getStringSafe(request, "selSzCdDisasterRlf"));
    cinv05si.setSzCdPersonLanguage(ContextHelper.getStringSafe(request, "selSzCdPersonLanguage"));
    cinv05si.setSzCdPersonMaritalStatus(ContextHelper.getStringSafe(request, "selSzCdPersonMaritalStatus"));
    cinv05si.setSzCdTitle(ContextHelper.getStringSafe(request, "selSzCdTitle"));
    cinv05si.setSzTxtMaidenName(ContextHelper.getStringSafe(request, "txtSzTxtMaidenName"));
    cinv05si.setBIndPersonDobApprox(CheckboxHelper.getCheckboxValue(request, "cbxBIndPersonDobApprox"));
    cinv05si.setSzTxtOccupation(ContextHelper.getStringSafe(request, "txtSzTxtOccupation"));
    cinv05si.setSzCdPersonReligion(ContextHelper.getStringSafe(request, "selSzCdPersonReligion"));
    cinv05si.setLNbrPersonAge(ageS);
    cinv05si.setBCdPersonChar(ContextHelper.getStringSafe(request, "hdnBCdPersonChar"));
    // cinv05si.setBCdPersNotYetDiag(ContextHelper.getStringSafe(request, "hdnBCdPersNotYetDiag"));
    cinv05si.setDtDtPersonBirth(DateHelper.toCastorDateSafe(DOB));
    cinv05si.setDtDtLegRepAssigned(DateHelper.toCastorDateSafe(dtAssigned));
    cinv05si.setDtDtLegRepUnassigned(DateHelper.toCastorDateSafe(dtUnassigned));
    cinv05si
            .setDtDtPersonDeath(DateHelper
                                          .toCastorDateSafe(ContextHelper
                                                                         .getStringSafe(request, "txtDateDtPersonDeath")));
    cinv05si.setSzNbrPersonSSN(ContextHelper.getSSNSafe(request, "txtSzNbrPersonSSNNumber"));
    cinv05si.setSzCdPersonDeath(ContextHelper.getStringSafe(request, "selSzCdPersonDeath"));
    cinv05si.setSzCdPersonLivArr(ContextHelper.getStringSafe(request, "selSzCdPersonLivArr"));
    cinv05si.setCdPersonStatus(ContextHelper.getStringSafe(request, "hdnCdPersonStatus"));
    cinv05si.setSzTxtAddlCmnts(ContextHelper.getStringSafe(request, "szTxtAddlCmnts"));
    cinv05si.setSzTxtEmail(ContextHelper.getStringSafe(request, "txtSzTxtEmail"));

    // Current Stage
    cinv05si.setUlIdStagePerson(ContextHelper.getIntSafe(request, "hdnUlIdStagePerson"));
    cinv05si.setSzCdStagePersType(ContextHelper.getStringSafe(request, "selSzCdStagePersType"));
    cinv05si.setSzCdStagePersRole(ContextHelper.getStringSafe(request, "dspSzCdStagePersRole"));
    cinv05si.setSzCdStagePersRelInt(ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt"));
    cinv05si.setBIndStagePersInLaw(CheckboxHelper.getCheckboxValue(request, "cbxBIndStagePersInLaw"));
    cinv05si.setBIndStagePersReporter(CheckboxHelper.getCheckboxValue(request, "cbxBIndStagePersReporter"));
    cinv05si.setBIndLegalCust(CheckboxHelper.getCheckboxValue(request, "cbxBIndLegalCustodian"));
    cinv05si.setBIndSafetyRsrc(CheckboxHelper.getCheckboxValue(request, "cbxBIndSafetyResource"));
    cinv05si.setBIndRsrcHouseholdMember(CheckboxHelper.getCheckboxValue(request, "cbxBIndRsrcHouseholdMember"));
    //STGAP00014329: New Checkbox added
    //STGAP00015485: changed the checkbox to dropdown
    cinv05si.setCdPKHouseholdMember(ContextHelper.getStringSafe(request, "selCdStagePersMbrPrimCareHhl"));
    cinv05si.setBIndPaternityEst(CheckboxHelper.getCheckboxValue(request, "cbxBIndPaternityEstablished"));
    cinv05si.setBIndVerified(CheckboxHelper.getCheckboxValue(request, "cbxBIndVerified"));
    cinv05si.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));
    cinv05si.setTsSysTsLastUpdate2(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                         "hdnTsSysTsLastUpdate2")));

    cinv05si.setBSysIndGeneric(ArchitectureConstants.N);

    // Birth Information
    cinv05si.setSzCdPersonBirthState(ContextHelper.getStringSafe(request, "selSzCdPersonBirthState"));
    cinv05si.setSzCdPersonBirthCounty(ContextHelper.getStringSafe(request, "selSzCdPersonBirthCounty"));
    cinv05si.setSzCdPersonBirthCity(ContextHelper.getStringSafe(request, "txtSzCdPersonBirthCity"));
    cinv05si.setSzCdCntryOfOrigin(ContextHelper.getStringSafe(request, "selSzCdCntryOfOrigin"));

    if (StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "cbxBIndUSCitizen"))) {
      cinv05si.setBIndUSCitizen(ArchitectureConstants.N);
    } else {
      cinv05si.setBIndUSCitizen(ArchitectureConstants.Y);
    }

    cinv05si.setSzCdImmigrationStatus(ContextHelper.getStringSafe(request, "selSzCdImmigrationStatus"));
    cinv05si.setSzCdMotherMarried(ContextHelper.getStringSafe(request, "selSzCdMotherMarried"));
    cinv05si.setSzCdProofCitizen(ContextHelper.getStringSafe(request, "selSzCdProofCitizen"));
    cinv05si.setDtDtEntryUS(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "txtDtDtEntryUS")));

    // other relationship information
    cinv05si.setUlIdSecondaryCareGiver(ContextHelper.getIntSafe(request, "selSzCSeCarGiver"));
    cinv05si.setUlIdPutativeFather(ContextHelper.getIntSafe(request, "selSzPutativeFather"));
    cinv05si.setUlIdLegalFather(ContextHelper.getIntSafe(request, "selSzLegalFather"));
    cinv05si.setUlIdBioFather(ContextHelper.getIntSafe(request, "selSzBioFather"));
    //STGAP00015485: Adding legal mother and Bio Mother
    cinv05si.setUlIdLegalMother(ContextHelper.getIntSafe(request, "selSzLegalMother"));
    cinv05si.setUlIdBioMother(ContextHelper.getIntSafe(request, "selSzBioMother"));
    cinv05si.setSzCdSideOfFamily(ContextHelper.getStringSafe(request, "selSzSideOfFamily"));
    cinv05si.setSzTxtOtherRelationshipsCmnts(ContextHelper.getStringSafe(request, "szTxtOtherRelationshipsCmnts"));

    // Tribal: Percent Heritage, Tribal Name, and Registry Number
    cinv05si.setSzTxtPercentHeritage(ContextHelper.getStringSafe(request, "szTxtPercentHeritage"));
    cinv05si.setSzTxtTribalName(ContextHelper.getStringSafe(request, "szTxtTribalName"));
    cinv05si.setSzTxtTribalRegistryNumber(ContextHelper.getStringSafe(request, "szTxtTribalRegistryNumber"));

    // Tribal : Registered with Tribe?
    String indRegisteredWithTribe = ContextHelper.getStringSafe(request, "rbScrIndRegisteredWithTribe");
    if (NO.equals(indRegisteredWithTribe)) {
      cinv05si.setBScrIndRegisteredWithTribe(ArchitectureConstants.N);
    } else if (YES.equals(indRegisteredWithTribe)) {
      cinv05si.setBScrIndRegisteredWithTribe(ArchitectureConstants.Y);
    } else if (UNKNOWN.equals(indRegisteredWithTribe)) {
      cinv05si.setBScrIndRegisteredWithTribe(U);
    }

    // Tribal : Tribal Member?
    String indTribalMember = ContextHelper.getStringSafe(request, "rbScrIndTribalMember");
    if (NO.equals(indTribalMember)) {
      cinv05si.setBScrIndTribalMember(ArchitectureConstants.N);
    } else if (YES.equals(indTribalMember)) {
      cinv05si.setBScrIndTribalMember(ArchitectureConstants.Y);
    } else if (UNKNOWN.equals(indTribalMember)) {
      cinv05si.setBScrIndTribalMember(U);
    }

    // Tribal : Physical Description
    if (!StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "szTxtWeight"))
        && ContextHelper.getStringSafe(request, "szTxtWeight") != null) {
      cinv05si.setLQtyPersonWeight(Integer.parseInt(ContextHelper.getStringSafe(request, "szTxtWeight")));
    }

    if (!StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "szTxtHeightFt"))
        && ContextHelper.getStringSafe(request, "szTxtHeightFt") != null) {
      cinv05si.setSQtyPersonHeightFeet(Integer.parseInt(ContextHelper.getStringSafe(request, "szTxtHeightFt")));
    }

    if (!StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "szTxtHeightIn"))
        && ContextHelper.getStringSafe(request, "szTxtHeightIn") != null) {
      cinv05si.setSQtyPersonHeightInches(Integer.parseInt(ContextHelper.getStringSafe(request, "szTxtHeightIn")));
    }

    cinv05si.setSzCdPersonEyeColor(ContextHelper.getStringSafe(request, "selSzCdPersonEyeColor"));
    cinv05si.setSzCdPersonHairColor(ContextHelper.getStringSafe(request, "selSzCdPersonHairColor"));
    cinv05si.setSzCdPersonHighestEduc(ContextHelper.getStringSafe(request, "selSzCdPersonHighestEduc"));

    // Person Characteristics: SSI related question for child under 18
    cinv05si.setCIndSsiAppSubmitted(ContextHelper.getStringSafe(request, "rbSsiAppSubmitted"));
    cinv05si.setCIndSsiMedDsbltyReqMet(ContextHelper.getStringSafe(request, "rbSsiMedDsbltyReqMet"));
    cinv05si.setCIndSsiRecipient(ContextHelper.getStringSafe(request, "rbSsiRecipient"));
    cinv05si.setCIndSsiDfcsPayee(ContextHelper.getStringSafe(request, "rbSsiDfcsPayee"));
    
    // STGAP00017013: MR-095
    // Set up the CINV05SI_ADD_PERSON_TO_STAGES_ARRAY array
    CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);
    CINV05SI_ADD_PERSON_TO_STAGES_ARRAY cinv05si_add_person_to_stages_array = createAddPersonToStagesArray(request, cinv04so);
    cinv05si.setCINV05SI_ADD_PERSON_TO_STAGES_ARRAY(cinv05si_add_person_to_stages_array);  
    // End STGAP00017013: MR-095
       
    // If a person has the maintain person security attribute the pageMode will
    // be maintain
    // person, set the generic indicator to "Y"
    if (WINDOW_MODE_MNTN_PERSON.equals(pageMode)) {
      cinv05si.setBSysIndGeneric(ArchitectureConstants.Y);
    }

    // Update Requested Function Code
    // Person Search indicator will always go to Viewed, if they
    // are new, or Related when the are related
    if (PageModeConstants.NEW.equals(pageMode)) {
      // Window mode is new, so ReqFuncCd should be Add, Person Search IND
      // should be Viewed (since new mode comes only from Person Search
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      //cinv05si.setBCdPersonChar(NO_DATA);
      cinv05si.setSzCdStagePersSearchInd(CD_VIEWED);
      //MR-072 If the person is added navigate to records check list
      cinv05si.setBIndRecordsCheckNav(ArchitectureConstants.Y);
    } else if (PageModeConstants.MODIFY.equals(pageMode)) {
      // Window mode is modify, so the ReqFuncCd should be Updated, and the
      // Person Search Indicator should remain as what was selected from the
      // page
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      cinv05si.setSzCdStagePersSearchInd(ContextHelper.getStringSafe(request, "hdnSzCdStagePersSearchInd"));
    } else if (WINDOW_MODE_RELATE.equals(pageMode)) {
      // Window mode is relate, so ReqFuncCd should be relate as well,
      // Person Status should be set to active since the person is being
      // re-activated
      // in a new case. Person Search Indicator should be set to Relate.
      cReqFuncCd = WINDOW_MODE_RELATE;
      cinv05si.setCdPersonStatus(CD_STATUS_ACTIVE);
      cinv05si.setSzCdStagePersSearchInd(CD_RELATE);
    //MR-072 If the person is related to the case navigate to records check list
      cinv05si.setBIndRecordsCheckNav(ArchitectureConstants.Y);
    } else if (WINDOW_MODE_MNTN_PERSON.equals(pageMode)) {
      cReqFuncCd = WINDOW_MODE_PERSON;
      cinv05si.setSzCdStagePersSearchInd(ContextHelper.getStringSafe(request, "hdnSzCdStagePersSearchInd"));
    } else {
      throw new PopulationException("MSG_ERR_BAD_FUNC_CD");
    }

    input.setCReqFuncCd(cReqFuncCd);

    // If a person in a case is in more
    // than one open stage and a change is made to the person's demographic
    // information, a ToDo will be created for the primary workers of the
    // open stages. A ToDo will not be created for the worker making the
    // change to the demographic information. Therefore, the first condition
    // of the IF statement below will check if the number of active stages
    // is greater than 1 because if there is only one active
    // stage, then that is the stage being modified and a ToDo does not need
    // to be generated.
    //
    // If a person that is being RELATED
    // is in exactly 1 active stage, and if the person's demographic
    // information is being changed by the worker relating that person,
    // a ToDo must be created for the primary worker of the other open stage
    // that the person is in.
    //
    // If the page is in modify or relate mode check to see if a todo is needed
    // otherwise a todo is not needed.
    if (PageModeConstants.MODIFY.equals(pageMode) || WINDOW_MODE_RELATE.equals(pageMode)) {
      // CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);
      CINV04SG01_ARRAY cinv04sg01Array = cinv04so.getCINV04SG01_ARRAY();
      CINV05SIG cinv05sig;
      CINV05SIG_ARRAY cinv05sigArray = new CINV05SIG_ARRAY();
      CINV04SG01 cinv04sg01Row;
      Enumeration cinv04sg01Enumeration = cinv04sg01Array.enumerateCINV04SG01();
      // int cinv04UlRowQty = cinv04so.getArchOutputStruct().getUlRowQty();
      int cinv04UlRowQty = cinv04sg01Array.getCINV04SG01().length;

      // If the person is in more than one case, and certain items have been
      // changed on the page,
      // set ToDo indicator to true.
      // test change
      if ((cinv04UlRowQty >= 1)
          && (PageModeConstants.MODIFY.equals(pageMode))
          && ("True".equals(ContextHelper.getStringSafe(request, "hdnBSysIndCreateToDo")))
          || ((cinv04UlRowQty > 0) && (WINDOW_MODE_RELATE.equals(pageMode)) && ("True"
                                                                                      .equals(ContextHelper
                                                                                                           .getStringSafe(
                                                                                                                          request,
                                                                                                                          "hdnBSysIndCreateToDo"))))) {
        // Set Indicator so that a ToDo will be created.
        cinv05si.setBSysIndCreateToDo(ArchitectureConstants.Y);
        // Populate ulIdStage and Case so that the to do can be created.
        // copy cinv04 output to cinv05 input

        while (cinv04sg01Enumeration.hasMoreElements()) {
          cinv04sg01Row = (CINV04SG01) cinv04sg01Enumeration.nextElement();
          cinv05sig = new CINV05SIG();
          // Do the copy of each data element
          cinv05sig.setUlIdCase(cinv04sg01Row.getUlIdCase());
          cinv05sig.setUlIdStage(cinv04sg01Row.getUlIdStage());
          cinv05sigArray.addCINV05SIG(cinv05sig);
          // cinv05si.setCINV05SIG_ARRAY(cinv05sigArray);
        }
        cinv05si.setCINV05SIG_ARRAY(cinv05sigArray);
      } // end if
      else {
        // No Todo is needed
        cinv05si.setBSysIndCreateToDo(ArchitectureConstants.N);
      }
    } else {
      cinv05si.setBSysIndCreateToDo(ArchitectureConstants.N);
    }

    // Since the window mode is new, a new person name needs to be added to the
    // Name Table, Populate that information.
    if (PageModeConstants.NEW.equals(pageMode)) {
      // If user entered an age, but no DOB, calculate DOB and check the
      // approximate
      // checkbox

      if (age != 0 && ("".equals(DOB) || DOB == null)) {
        org.exolab.castor.types.Date DOBD;
        DOBD = DateHelper.getCastorDateFromAge(age);
        cinv05si.setDtDtPersonBirth(DOBD);
        cinv05si.setBIndPersonDobApprox(ArchitectureConstants.Y);
      }

      // create name variables to check for null
      String firstName = (ContextHelper.getStringSafe(request, "txtSzNmNameFirst"));
      String middleName = (ContextHelper.getStringSafe(request, "txtSzNmNameMiddle"));
      String lastName = (ContextHelper.getStringSafe(request, "txtSzNmNameLast"));
      if (("".equals(firstName)) && ("".equals(middleName)) && ("".equals(lastName))) {
        cinv05si.setSzNmPersonFull("Unknown");
        // SIR 17896 set page size number, not page number
        input.setUlPageSizeNbr(0);
      } else {
        // SIR 17896 set page size number, not page number
        input.setUlPageSizeNbr(ONE);
        ROWCINV26SIG00_ARRAY rowcinv26sig00_array = new ROWCINV26SIG00_ARRAY();
        ROWCINV26SIG00 rowcinv26sig00 = new ROWCINV26SIG00();
        org.exolab.castor.types.Date StartDate = new org.exolab.castor.types.Date();

        rowcinv26sig00.setSzCdNameSuffix(ContextHelper.getStringSafe(request, "selSzCdNameSuffix"));
        rowcinv26sig00.setSzNmNameFirst(nameFirst);
        rowcinv26sig00.setSzNmNameLast(nameLast);
        rowcinv26sig00.setSzNmNameMiddle(nameMiddle);

        // This is a new person, so the name is valid, is primary, and the start
        // date is the system Date
        rowcinv26sig00.setBIndNameInvalid(ArchitectureConstants.N);
        rowcinv26sig00.setBIndNamePrimary(ArchitectureConstants.Y);
        rowcinv26sig00.setDtDtNameStartDate(StartDate);
        // There is no End Date for a new person, set it to null
        rowcinv26sig00.setDtDtNameEndDate(null);
        // Set the Data Action to "Add" since this is a new Person, and a Name
        // row is being added
        rowcinv26sig00.setSzCdScrDataAction("A");
        input.setUlPageSizeNbr(ONE);

        rowcinv26sig00_array.addROWCINV26SIG00(rowcinv26sig00);

        cinv05si.setROWCINV26SIG00_ARRAY(rowcinv26sig00_array);
      }
      // Inside window mode = new if Stage is a FAD stage, then the Person
      // category field
      // should be saved as FAH, and the Category of the case. Else save it as
      // just the
      // category of the case.
      if (FAD.equals(szCdStage)) {
        SzCdCategoryCategory_ARRAY szCdCategoryCategoryArray = new SzCdCategoryCategory_ARRAY();
        szCdCategoryCategoryArray.addSzCdCategoryCategory(PERS_CATEGORY_FA_HOME);
        szCdCategoryCategoryArray.addSzCdCategoryCategory(CD_CATEGORY_CASE);
        cinv05si.setSzCdCategoryCategory_ARRAY(szCdCategoryCategoryArray);
        bIndFAH = true; //arege added PerSTGAP00004635        
      } else {
        SzCdCategoryCategory_ARRAY szCdCategoryCategoryArray = new SzCdCategoryCategory_ARRAY();
        szCdCategoryCategoryArray.addSzCdCategoryCategory(CD_CATEGORY_CASE);
        cinv05si.setSzCdCategoryCategory_ARRAY(szCdCategoryCategoryArray);
      }

    } // End if Window mode is new

    // If mode is relate check to make sure that the person isn't
    // already related to a case (i.e. Case is already in their
    // category array)
    // Loop through the category array and set a flag if CASE is
    // checked. If so leave Category as blank. This will indicate to
    // the service not to write to the stage person link table,
    // just the category table.
    if (WINDOW_MODE_RELATE.equals(pageMode)) {
      // CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);
      CINV04SOGOO_ARRAY cinv04sogooArray = cinv04so.getCINV04SOGOO_ARRAY();
      if (cinv04sogooArray != null) {
        CINV04SOGOO cinv04sogooRow;
        Enumeration cinv04sogooEnumeration = cinv04sogooArray.enumerateCINV04SOGOO();
        while (cinv04sogooEnumeration.hasMoreElements()) {
          cinv04sogooRow = (CINV04SOGOO) cinv04sogooEnumeration.nextElement();
          String cat = cinv04sogooRow.getSzCdCategoryCategory();
          if (cat != null && cat.equals(CD_CATEGORY_CASE)) {
            bIndCase = true;
          }
          if (cat != null && cat.equals(PERS_CATEGORY_FA_HOME)) {
            bIndFAH = true;
          }
        }
      }

      // If person is being related to case and has stage
      // of FAD, should save category of FAHome, if the person
      // does not already have that category.
      // PERSON_CATEGORY table will also be updated with case
      // in addition to FA/Home. Will put this information into
      // the second position in the szCdCategoryCategory array,
      // which should not be used by any other logic.
      if ((FAD.equals(szCdStage)) && (!bIndFAH)) {
        SzCdCategoryCategory_ARRAY szCdCategoryCategoryArray = new SzCdCategoryCategory_ARRAY();
        szCdCategoryCategoryArray.addSzCdCategoryCategory(PERS_CATEGORY_FA_HOME);
        szCdCategoryCategoryArray.addSzCdCategoryCategory(CD_CATEGORY_CASE);
        cinv05si.setSzCdCategoryCategory_ARRAY(szCdCategoryCategoryArray);
        bIndFAH = true; //arege added PerSTGAP00004635
      } else if (!bIndCase) {
        SzCdCategoryCategory_ARRAY szCdCategoryCategoryArray = new SzCdCategoryCategory_ARRAY();
        szCdCategoryCategoryArray.addSzCdCategoryCategory(CD_CATEGORY_CASE);
        cinv05si.setSzCdCategoryCategory_ARRAY(szCdCategoryCategoryArray);
      }
    } // End if Window Mode is Relate

    // Set indicator in service if there was an FAH category on the category
    // table
    if (bIndFAH) {
      cinv05si.setBIndChkd(ArchitectureConstants.Y);
    }

    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    cinv05si.setArchInputStruct(input);
    return cinv05si;
  }

  /**
   * populateCINV05SI_D <p/> This populate method is used when the user is removing a person from the stage, or if the
   * person is not in any other case, they are deleting the person from the system It populates the input object for
   * CINV05S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cinv05si
   */
  public CINV05SI populateCINV05SI_D(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CINV05SI cinv05si = new CINV05SI();
    
    //STGAP00009230 - created and initialized pageModeStruct object and set it into the cinv05si object 
    PageModeStruct pageModeStruct = new PageModeStruct();
    String pageMode;
    pageMode = PageMode.getPageMode( request );
    pageModeStruct.setPageModeType(pageMode);
    
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());
    // Create a Variable to check the Required Funciton Code, set that Function
    // code into the input for the CINV05S
    input.setCReqFuncCd((ServiceConstants.REQ_FUNC_CD_DELETE));

    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    cinv05si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    String cdPersonStatus = (ContextHelper.getStringSafe(request, "hdnCdPersonStatus"));
    cinv05si.setSzCdStagePersRelInt(ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt"));
    String dtAssigned = ContextHelper.getStringSafe(request, "txtDateDtLegRepAssigned");
    cinv05si.setDtDtLegRepAssigned(DateHelper.toCastorDateSafe(dtAssigned));
    String dtUnassigned = ContextHelper.getStringSafe(request, "txtDateDtLegRepUnassigned");
    cinv05si.setDtDtLegRepUnassigned(DateHelper.toCastorDateSafe(dtUnassigned));
    

    CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);
    int cinv04UlRowQty = cinv04so.getArchOutputStruct().getUlRowQty();

    if ((cinv04UlRowQty <= 1) && "A".equals(cdPersonStatus)) {
      cinv05si.setCdPersonStatus("I");
    } else {
      cinv05si.setCdPersonStatus(cdPersonStatus);
    }

    cinv05si.setUlIdStagePerson(ContextHelper.getIntSafe(request, "hdnUlIdStagePerson"));
    cinv05si.setUlIdStage(GlobalData.getUlIdStage(request));
    cinv05si.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));
    cinv05si.setTsSysTsLastUpdate2(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                         "hdnTsSysTsLastUpdate2")));
    cinv05si.setSzCdTask(GlobalData.getSzCdTask(request));
    // Set Date of Death and Date of Birth to null date to prevent errors
    // returning from the service

    cinv05si.setDtDtPersonBirth(null);
    cinv05si.setDtDtPersonDeath(null);
    cinv05si.setBSysIndCreateToDo(ArchitectureConstants.N);
    cinv05si.setPageModeStruct(pageModeStruct);

    cinv05si.setArchInputStruct(input);
    return cinv05si;
  }

  /**
   * populateCCFC50SI_AU <p/> This populate method is used when a person merge row is being added or updated, it updates
   * the phone and address information for the persons merged It populates the input object for CCFC50S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc50si
   */
  public CCFC50SI populateCCFC50SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    ROWCCFC14SIG00 rowccfc14sig00 = new ROWCCFC14SIG00();
    CCFC50SI ccfc50si = new CCFC50SI();

    ROWCCFC14SIG00_ARRAY rowccfc14sig00_array = new ROWCCFC14SIG00_ARRAY();

    // Retrieve user information for saving to the database
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int userID = user.getUserID();
    String userName = user.getUserFullName();

    String cReqFuncCD = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(cReqFuncCD);
    // Only one row is ever saved or deleted, so statically set the page size
    // number to 1
    input.setUlPageSizeNbr(ONE);
    input.setSzUserId(user.getUserLogonID());

    ccfc50si.setUlIdPersonRequestor(userID);

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCD)) {

      rowccfc14sig00.setSzScrNmPersMergeClosed(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeClosed"));
      rowccfc14sig00.setSzScrNmPersMergeForward(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeForward"));
      rowccfc14sig00.setSzScrNmPersMergeWrkr(userName);

      rowccfc14sig00.setUlIdPersMergeClosed(Integer.parseInt(ContextHelper.getStringSafe(request,
                                                                                         "txtUlIdPersMergeClosed")));
      rowccfc14sig00.setUlIdPersMergeWrkr(userID);
      rowccfc14sig00.setUlIdPersMergeForward(Integer.parseInt(ContextHelper.getStringSafe(request,
                                                                                          "txtUlIdPersMergeForward")));
      Date date = new Date();
      rowccfc14sig00.setDtDtPersMerge(DateHelper.toCastorDate(date));
      rowccfc14sig00.setDtDtPersMergeSplit(null);
      rowccfc14sig00.setCIndPersMergeInvalid(ArchitectureConstants.N);
      rowccfc14sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_ADD);

    }
    // If the row is not to be added, it is to be updated
    else {

      rowccfc14sig00.setSzScrNmPersMergeClosed(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeClosed"));
      rowccfc14sig00.setSzScrNmPersMergeForward(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeForward"));
      rowccfc14sig00.setSzScrNmPersMergeWrkr(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeWrkr"));
      rowccfc14sig00.setSzScrNmPersMrgSpltWrkr(userName);
      rowccfc14sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                           "hdnTsMergeLastUpdate")));
      rowccfc14sig00.setUlIdPersMergeClosed(Integer.parseInt(ContextHelper.getStringSafe(request,
                                                                                         "txtUlIdPersMergeClosed")));
      rowccfc14sig00.setUlIdPersMergeWrkr(ContextHelper.getIntSafe(request, "hdnUlIdPersMergeWrkr"));
      rowccfc14sig00.setUlIdPersMergeSplitWrkr(userID);
      rowccfc14sig00.setUlIdPersonMerge(ContextHelper.getIntSafe(request, "hdnUlIdPersonMerge"));
      rowccfc14sig00.setUlIdPersMergeForward(Integer.parseInt(ContextHelper.getStringSafe(request,
                                                                                          "txtUlIdPersMergeForward")));
      rowccfc14sig00.setDtDtPersMerge(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                                              "dspDtDtPersMerge")));
      Date date = new Date();
      rowccfc14sig00.setDtDtPersMergeSplit(DateHelper.toCastorDate(date));
      rowccfc14sig00.setCIndPersMergeInvalid(ArchitectureConstants.Y);
      rowccfc14sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_UPDATE);

    }
    ccfc50si.setArchInputStruct(input);

    // Add the struct to the array
    rowccfc14sig00_array.addROWCCFC14SIG00(rowccfc14sig00);
    // Set the array into the parent struct
    ccfc50si.setROWCCFC14SIG00_ARRAY(rowccfc14sig00_array);
    return ccfc50si;
  }

  /**
   * populateCINV24SI_Retrieve <p/> This method is used to populate the input structure for retrieving the Person
   * Characteristics information
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cinv24si
   */
  public CINV24SI populateCINV24SI_Retrieve(GrndsExchangeContext context) {
    CINV24SI cinv24si = new CINV24SI();
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(100);
    cinv24si.setArchInputStruct(input);
    cinv24si.setDtScrDtCharEffDate(null);
    cinv24si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    cinv24si.setSzCdStage(GlobalData.getSzCdStage(request));
    return cinv24si;
  }

  /**
   * populateCCFC17SI_Retrieve <p/> This method is used for populating the input structure used to retieve the Education
   * information
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc17si
   */
  public CCFC17SI populateCCFC17SI_Retrieve(GrndsExchangeContext context) {
    CCFC17SI ccfc17si = new CCFC17SI();
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(FIFTY);
    ccfc17si.setArchInputStruct(input);
    ccfc17si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    return ccfc17si;
  }

  /**
   * populateCFAD32SI_Retrieve <p/> This method is used to populate the input structure for retieving FA home
   * information.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cfad32si
   */
  public CFAD32SI populateCFAD32SI_Retrieve(GrndsExchangeContext context) {
    ArchInputStruct input = new ArchInputStruct();
    HttpServletRequest request = context.getRequest();
    CFAD32SI cfad32si = new CFAD32SI();
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(TWO_HUNDRED);
    cfad32si.setArchInputStruct(input);
    cfad32si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    return cfad32si;
  }

  /**
   * populateCCFC29SI_Retrieve <p/> This method is used to populate the input structure used for retrieving Income and
   * Resources Information
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc29si
   */
  public CCFC29SI populateCCFC29SI_Retrieve(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();
    CCFC29SI ccfc29si = new CCFC29SI();
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(TWO_HUNDRED);
    ccfc29si.setArchInputStruct(input);
    ccfc29si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    return ccfc29si;
  }

  /**
   * populateCCFC13SI_Retrieve <p/> This method is used to populate the input structure for retieving the Person Merge
   * Information
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc13si
   */
  public CCFC13SI populateCCFC13SI_Retrieve(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int userID = user.getUserID();
    CCFC13SI ccfc13si = new CCFC13SI();
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(THREE_HUNDRED);
    ccfc13si.setArchInputStruct(input);
    ccfc13si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    ccfc13si.setUlIdStage(GlobalData.getUlIdStage(request));
    ccfc13si.setUlIdPersonRequestor(userID);
    return ccfc13si;
  }

  /**
   * populateCINV04SI_Retrieve <p/> This method is used to populate the input structure for retrieving person detail
   * information.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cinv04si
   */
  public CINV04SI populateCINV04SI_Retrieve(GrndsExchangeContext context) {
    CINV04SI cinv04si = new CINV04SI();
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(10);

    cinv04si.setArchInputStruct(input);
    cinv04si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    cinv04si.setSzSysCdWinMode(PersonHelper.getPersonDetailPageMode(request));
    cinv04si.setUlIdStage(GlobalData.getUlIdStage(request));
    cinv04si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    // SIR 14516
    cinv04si.setUlIdCase(GlobalData.getUlIdCase(request));
    return cinv04si;
  }

  /**
   * Display Merge Split List <p/> This helper method is used to call CCFC13S for retrieving the list information for
   * Person Merge Split. It calls the populateCCFC13SI helper method to populate the input object for retrieving.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @throws MarshalException
   * @throws MarshalException
   *           Thrown if there are problems with castor
   */
  public void displayMergeSplitList(GrndsExchangeContext context) throws ServiceException, MarshalException,
                                                                 ValidationException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCFC13SI ccfc13si = populateCCFC13SI_Retrieve(context);
    /*
     * String outputXml2 = ServiceHelper.callService("CCFC13S", ccfc13si); CCFC13SO ccfc13so = CCFC13SO.unmarshal(new
     * StringReader(outputXml2));
     */
    CCFC13SO ccfc13so = person.retrievePersonMerge(ccfc13si);
    state.setAttribute("CCFC13SO", ccfc13so, request);
    // End Person Merge
  }

  /**
   * Add Education <p/> This method is used to display the Education Detail page for adding a new Education Row to the
   * list on Person Detail. It is called when clicking the add pushbutton from the Person Detail Education List. When
   * this happens, it simply removes the Education Object from state, and sets a page mode variable into request so that
   * the pageMode in PersonHelper will not get overwritten. However, this method is also called upon return from the
   * Resource Conversation pullback. When this occurs, it not only does the above processing, but it also re-instates
   * inforamtion and variables entered on the original page. This is done so that if the user has entered any
   * information before performing the resource search that information will reappear when they return to the page.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void addEducation_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addEducation_xa()");
    performanceTrace.enterScope();

    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);

    // Set a pageMode variable so that the page mode in Person Helper will not
    // have to be over written
    request.setAttribute(PAGE_MODE, PageModeConstants.NEW);

    request.setAttribute("indInState", "true");

    // If there is a pullback attribute in the request, go into Resource
    // Pullback mode.
    if ((request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST)) != null) {
      CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);
        request.setAttribute("cres03so", cres03so);
        ROWCCFC17SOG00 rowccfc17sog00 = (ROWCCFC17SOG00) state.getAttribute("rowccfc17sog00", request);
        request.setAttribute("ROWCCFC17SOG00", rowccfc17sog00);

        // Set a pageMode variable so that the Person Helper page mode will not
        // have to be over written
        request.setAttribute(PAGE_MODE, PageModeConstants.NEW);

        state.removeAttribute("rowccfc17sog00", request);
        List<String> checkedValues = new ArrayList<String>(10);

        if (rowccfc17sog00.getSzCdEdhistNeeds1() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds1());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds2() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds2());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds3() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds3());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds4() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds4());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds5() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds5());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds6() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds6());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds9() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds9());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds10() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds10());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds7() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds7());
        }
        if (rowccfc17sog00.getSzCdEdhistNeeds8() != null) {
          checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds8());
        }
        request.setAttribute("checkedValues", checkedValues);
        if (!"04".equals(cres03so.getSzCdRsrcType())) {
        // STGAP00007106: Changed the message into an informational message as per the design
        setInformationalMessage(Messages.MSG_CMN_RESOURCE_SCHOOL, request);
      }
    }
    String pageName;
    if (state.getAttribute("pageName", request) == null) {
      pageName = ContextHelper.getStringSafe(request, "pageName");
    } else {
      pageName = (String) state.getAttribute("pageName", request);
    }
    if ("ChildPlan".equals(pageName)) {
      // STGAP00005609 - Child Plan SO will still be visible here; plus, it is mistake to populate it from request since  
      // it will generate an all-null-field object because Child Plan page fields are not visible here; 
      /*ChildPlanDetailRetrieveSO childPlanDetailRetrieveSO = (ChildPlanDetailRetrieveSO) state
                                                                                             .getAttribute(
                                                                                                           "ChildPlanDetailRetrieveSO",
                                                                                                           request);
      //if (childPlanDetailRetrieveSO == null) {
        
      childPlanDetailRetrieveSO = populateInfo(request, childPlanDetailRetrieveSO);
      //}
      state.setAttribute("ChildPlanDetailRetrieveSO", childPlanDetailRetrieveSO, request);*/
      // end STGAP00005609
      request.setAttribute("pageName", "ChildPlan");
      state.setAttribute("pageName", pageName, request);
    }else if("ChildPlanEdu".equals(pageName)){
      ChildPlanDetailRetrieveSO childPlanDetailRetrieveSO = (ChildPlanDetailRetrieveSO) state
      .getAttribute(
                    "ChildPlanDetailRetrieveSO",
                    request);

state.setAttribute("ChildPlanDetailRetrieveSO", childPlanDetailRetrieveSO, request);
request.setAttribute("pageName", "ChildPlan");
pageName = "ChildPlan";
state.setAttribute("pageName", pageName, request);
      
      
    }
    else {
      clearState(context);
    }
    performanceTrace.exitScope();
  }

  /**
   * populateInfo <p/> This method is used to populate the input structure for holding the ChildPlan page if the source
   * for this page is ChildPlan.
   * 
   * @param request
   *          The HttpServletRequest Object The ChildPlanDetailRetrieveSO object.
   */

  protected static ChildPlanDetailRetrieveSO populateInfo(HttpServletRequest request,
                                                          ChildPlanDetailRetrieveSO childplandetailRetrieveSO) {

    try {
      ChildPlanDetailList cpdBean = new ChildPlanDetailList();
      if (request.getParameter("szTxtSvcOffProvidedDesc") != null
          && !"".equals(request.getParameter("szTxtSvcOffProvidedDesc"))) {
        cpdBean.setLdTxtSvcOffProvidedDesc(ContextHelper.getStringSafe(request, "szTxtSvcOffProvidedDesc"));
      }
      if (request.getParameter("szDtCompDate") != null && !"".equals(request.getParameter("szDtCompDate"))) {
        cpdBean.setLdDtCompDate(DateHelper.toJavaDate(ContextHelper.getStringSafe(request, "szDtCompDate")));
      }
      if (request.getParameter("rbInddilSearchComp") != null && !"".equals(request.getParameter("rbInddilSearchComp"))) {
        cpdBean.setLdInddilSearchComp(ContextHelper.getStringSafe(request, "rbInddilSearchComp"));
      }
      if (request.getParameter("rbIndChildAdjInCare") != null
          && !"".equals(request.getParameter("rbIndChildAdjInCare"))) {
        cpdBean.setLdIndChildAdjInCare(ContextHelper.getStringSafe(request, "rbIndChildAdjInCare"));
      }
      if (request.getParameter("szTxtExpChildAdjInCare") != null
          && !"".equals(request.getParameter("szTxtExpChildAdjInCare"))) {
        cpdBean.setLdTxtExpChildAdjInCare(ContextHelper.getStringSafe(request, "szTxtExpChildAdjInCare"));
      }
      if (request.getParameter("szTxtParentalRightsCmnts") != null
          && !"".equals(request.getParameter("szTxtParentalRightsCmnts"))) {
        cpdBean.setLdTxtparentalRightsCmnts(ContextHelper.getStringSafe(request, "szTxtParentalRightsCmnts"));
      }

      if (request.getParameter("rbIndFilePetition") != null && !"".equals(request.getParameter("rbIndFilePetition"))) {
        cpdBean.setLdIndFilePetition(ContextHelper.getStringSafe(request, "rbIndFilePetition"));
      }
      if (request.getParameter("szDtfilePetitionDate") != null
          && !"".equals(request.getParameter("szDtfilePetitionDate"))) {
        cpdBean.setLdDtfilePetitionDate(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                          "szDtfilePetitionDate")));
      }
      if (request.getParameter("szTxtfilePetitionCmnts") != null
          && !"".equals(request.getParameter("szTxtfilePetitionCmnts"))) {
        cpdBean.setLdTxtfilePetitionCmnts(ContextHelper.getStringSafe(request, "szTxtfilePetitionCmnts"));
      }
      if (request.getParameter("szTxtfinalPermPlacementSteps") != null
          && !"".equals(request.getParameter("szTxtfinalPermPlacementSteps"))) {
        cpdBean.setLdTxtfinalPermPlacementSteps(ContextHelper.getStringSafe(request, "szTxtfinalPermPlacementSteps"));
      }

      if (request.getParameter("chkIndPermPlan") != null && !"".equals(request.getParameter("chkIndPermPlan"))) {
        cpdBean.setLdIndPermPlan(ContextHelper.getStringSafe(request, "chkIndPermPlan"));
      }
      if (request.getParameter("szTxtadditionalInfo") != null
          && !"".equals(request.getParameter("szTxtadditionalInfo"))) {
        cpdBean.setLdTxtadditionalInfo(ContextHelper.getStringSafe(request, "szTxtadditionalInfo"));
      }
      if (request.getParameter("rbIndImmunization") != null && !"".equals(request.getParameter("rbIndImmunization"))) {
        cpdBean.setLdIndImmunization(ContextHelper.getStringSafe(request, "rbIndImmunization"));
      }
      if (request.getParameter("szTxtImmunizationCmnts") != null
          && !"".equals(request.getParameter("szTxtImmunizationCmnts"))) {
        cpdBean.setLdTxtImmunizationCmnts(ContextHelper.getStringSafe(request, "szTxtImmunizationCmnts"));
      }
      if (request.getParameter("rbIndImmunizationOnFile") != null
          && !"".equals(request.getParameter("rbIndImmunizationOnFile"))) {
        cpdBean.setLdIndImmunizationOnFile(ContextHelper.getStringSafe(request, "rbIndImmunizationOnFile"));
      }
      if (request.getParameter("szTxtImmunizationFileComments") != null
          && !"".equals(request.getParameter("szTxtImmunizationFileComments"))) {
        cpdBean.setLdTxtImmunizationFileComments(ContextHelper.getStringSafe(request, "szTxtImmunizationFileComments"));
      }
      if (request.getParameter("rbIndMedPsychProblems") != null
          && !"".equals(request.getParameter("rbIndMedPsychProblems"))) {
        cpdBean.setLdIndMedPsychProblems(ContextHelper.getStringSafe(request, "rbIndMedPsychProblems"));
      }
      if (request.getParameter("szTxtMedPsychProblemsCmnts") != null
          && !"".equals(request.getParameter("szTxtMedPsychProblemsCmnts"))) {
        cpdBean.setLdTxtMedPsychProblemsCmnts(ContextHelper.getStringSafe(request, "szTxtMedPsychProblemsCmnts"));
      }

      if (request.getParameter("rbIndMedRecFile") != null && !"".equals(request.getParameter("rbIndMedRecFile"))) {
        cpdBean.setLdIndMedRecFile(ContextHelper.getStringSafe(request, "rbIndMedRecFile"));
      }
      if (request.getParameter("szTxtMedRecFileCmnts") != null
          && !"".equals(request.getParameter("szTxtMedRecFileCmnts"))) {
        cpdBean.setLdTxtMedRecFileCmnts(ContextHelper.getStringSafe(request, "szTxtMedRecFileCmnts"));
      }
      if (request.getParameter("rbIndPsychRecFile") != null && !"".equals(request.getParameter("rbIndPsychRecFile"))) {
        cpdBean.setLdIndPsychRecFile(ContextHelper.getStringSafe(request, "rbIndPsychRecFile"));
      }
      if (request.getParameter("szTxtPsychRecFileCmnts") != null
          && !"".equals(request.getParameter("szTxtPsychRecFileCmnts"))) {
        cpdBean.setLdTxtPsychRecFileCmnts(ContextHelper.getStringSafe(request, "szTxtPsychRecFileCmnts"));
      }

      if (request.getParameter("rbIndMedPsychTrmnt") != null && !"".equals(request.getParameter("rbIndMedPsychTrmnt"))) {
        cpdBean.setLdIndMedPsychTrmnt(ContextHelper.getStringSafe(request, "rbIndMedPsychTrmnt"));
      }
      if (request.getParameter("rbIndMedPsychDocRecord") != null
          && !"".equals(request.getParameter("rbIndMedPsychDocRecord"))) {
        cpdBean.setLdIndMedPsychDocRecord(ContextHelper.getStringSafe(request, "rbIndMedPsychDocRecord"));
      }
      if (request.getParameter("szTxtMedPsychDocRecordCmnts") != null
          && !"".equals(request.getParameter("szTxtMedPsychDocRecordCmnts"))) {
        cpdBean.setLdTxtMedPsychDocRecordCmnts(ContextHelper.getStringSafe(request, "szTxtMedPsychDocRecordCmnts"));
      }
      if (request.getParameter("szTxtOtherMedPsychDocRecordCmnts") != null
          && !"".equals(request.getParameter("szTxtOtherMedPsychDocRecordCmnts"))) {
        cpdBean.setLdTxtOtherMedPsychDocRecordCmnts(ContextHelper.getStringSafe(request,
                                                                                "szTxtOtherMedPsychDocRecordCmnts"));
      }
      String[] checkedASFAExstConds = CheckboxHelper.getCheckedValues(request, "chkAsfaExistingConditions");
      if (checkedASFAExstConds.length != 0) {
        cpdBean.setasfaExistingConditions(checkedASFAExstConds);
      }

      String[] checkedParentalRtsTerms = CheckboxHelper.getCheckedValues(request, "chkParentalRtsTerms");
      if (checkedASFAExstConds.length != 0) {
        cpdBean.setparentalRtsTerm(checkedParentalRtsTerms);

      }

      String[] checkedNonReunificConditions = CheckboxHelper.getCheckedValues(request, "chknonReunificConditions");
      if (checkedASFAExstConds.length != 0) {
        cpdBean.setnonReunificConditions(checkedNonReunificConditions);
      }
      childplandetailRetrieveSO.setcpdList(cpdBean);
      request.setAttribute("ChildPlanDetailRetrieveSO", childplandetailRetrieveSO);
      request.setAttribute("pageName", "ChildPlan");

    } catch (Exception e) {
      e.getMessage();
    }
    return childplandetailRetrieveSO;
  }

  /**
   * Add FA Home <p/> This method is used to add a row to the FA Home list in Person Detail. It sets a page mode
   * variable into request so that the PersonHelper pageMode will not be overwritten. It als removes the FA home object
   * from state.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void addFAHome_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addFAHome_xa()");
    performanceTrace.enterScope();

    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);

    // Set a pageMode variable so that the page mode in Person Helper will not
    // have to be over written
    request.setAttribute(PAGE_MODE, PageModeConstants.NEW);

    // Objects in state are no longer needed, they will be re set on re-display
    // of person detail
    clearState(context);

    performanceTrace.exitScope();
  }

  /**
   * populateCCFC30SI_D <p/> This populate method is used when an Income and Resources row is being deleted It populates
   * the input object for CCFC30S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc30si
   */
  public CCFC30SI populateCCFC30SI_D(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    ROWCCFC30SIG00 rowccfc30sig00 = new ROWCCFC30SIG00();
    CCFC30SI ccfc30si = new CCFC30SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCFC30SIG00_ARRAY rowccfc30sig00_array = new ROWCCFC30SIG00_ARRAY();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    // Only one row is ever saved or deleted, so statically set the page size
    // number to 1
    input.setUlPageSizeNbr(ONE);
    rowccfc30sig00.setUlIdIncRsrc(ContextHelper.getIntSafe(request, "hdnUlIdIncRsrc"));
    rowccfc30sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                         "hdnTsIncomeLastUpdate")));
    rowccfc30sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);

    ccfc30si.setArchInputStruct(input);
    // Add the struct to the array
    rowccfc30sig00_array.addROWCCFC30SIG00(rowccfc30sig00);
    // Set the array into the parent struct
    ccfc30si.setROWCCFC30SIG00_ARRAY(rowccfc30sig00_array);
    return ccfc30si;
  }

  /**
   * populateCCFC30SI_AU <p/> This populate method is used when an Income and Resources row is being added or saved It
   * populates the input object for CCFC30S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc30si
   */
  public CCFC30SI populateCCFC30SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    ROWCCFC30SIG00 rowccfc30sig00 = new ROWCCFC30SIG00();
    CCFC30SI ccfc30si = new CCFC30SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCFC30SIG00_ARRAY rowccfc30sig00_array = new ROWCCFC30SIG00_ARRAY();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int userID = user.getUserID();
    int personID = GlobalData.getUlIdPerson(request);
    int stageID = GlobalData.getUlIdStage(request);
    int caseID = GlobalData.getUlIdCase(request);
    String personName = GlobalData.getSzNmPersonFull(request);
    String cdTask = GlobalData.getSzCdTask(request);
    input.setSzUserId(user.getUserLogonID());

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    // Only one row is ever saved or deleted, so statically set the page size
    // number to 1
    input.setUlPageSizeNbr(ONE);

    AdminAddressPhoneBean aapBean = (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest(request);

    rowccfc30sig00.setSzTxtIncRsrcSrcPhoneNum(aapBean.getPhone());
    rowccfc30sig00.setSzTxtIncRsrcSrcPhoneExt(aapBean.getPhoneExt());

    rowccfc30sig00.setSzTxtIncRsrcSrcAddrStLn1(aapBean.getAddress1());
    rowccfc30sig00.setSzTxtIncRsrcSrcAddrStLn2(aapBean.getAddress2());
    rowccfc30sig00.setSzTxtIncRsrcSrcAddrCity(aapBean.getCity());
    rowccfc30sig00.setSzTxtIncRsrcSrcAddrState(aapBean.getState());
    rowccfc30sig00.setSzTxtIncRsrcSrcAddrZip(aapBean.getZipAndSuff());
    rowccfc30sig00.setSzCdIncRsrcSrcAddrCounty(aapBean.getCounty());
    rowccfc30sig00.setSzTxtIncRsrcSrcAddrCmnts(aapBean.getComments());

    rowccfc30sig00.setLAmtIncRsrc(ContextHelper.getMoneyAsDoubleSafe(request, "txtLAmtIncRsrc"));
    rowccfc30sig00.setSzCdIncRsrcIncome(ContextHelper.getStringSafe(request, "rbSzCdIncRsrcIncome"));
    rowccfc30sig00.setSzCdIncRsrcType(ContextHelper.getStringSafe(request, "selSzCdIncRsrcType"));
    rowccfc30sig00.setDtDtIncRsrcFrom(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                                              "txtDtDtIncRsrcFrom")));
    rowccfc30sig00.setUlIdIncRsrc(ContextHelper.getIntSafe(request, "hdnUlIdIncRsrc"));
    rowccfc30sig00.setUlIdIncRsrcWorker(userID);
    rowccfc30sig00.setUlIdPerson(personID);
    rowccfc30sig00.setUlIdStage(stageID);
    rowccfc30sig00.setSzCdTask(cdTask);
    rowccfc30sig00.setUlIdCase(caseID);
    rowccfc30sig00.setSzNmPersonFull(personName);
    rowccfc30sig00.setCIndIncRsrcNotAccess(CheckboxHelper.getCheckboxValue(request, "cbxCIndIncRsrcNotAccess"));
    rowccfc30sig00.setSzCdScrDataAction(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    rowccfc30sig00.setSzSdsIncRsrcVerfMethod(ContextHelper.getStringSafe(request, "txtSzSdsIncRsrcVerfMethod"));
    rowccfc30sig00.setSzSdsIncRrcsSource(ContextHelper.getStringSafe(request, "txtSzSdsIncRrcsSource"));
    rowccfc30sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                         "hdnTsIncomeLastUpdate")));
    rowccfc30sig00.setSzTxtIncRsrcDesc(ContextHelper.getStringSafe(request, "txtSzTxtIncRsrcDesc"));

    rowccfc30sig00.setSzCdIncRsrcFreqType(ContextHelper.getStringSafe(request, "selSzCdFrequency"));
    rowccfc30sig00.setDtDtIncRsrcModified(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                                                  "txtDtDtModified")));

    if (ContextHelper.getCastorDateSafe(request, "txtDtDtIncRsrcTo") == null) {
      rowccfc30sig00.setDtDtIncRsrcTo(DateHelper.MAX_CASTOR_DATE);
    } else {
      rowccfc30sig00.setDtDtIncRsrcTo(ContextHelper.getCastorDateSafe(request, "txtDtDtIncRsrcTo"));
    }
    ccfc30si.setArchInputStruct(input);
    // Add the struct to the array
    rowccfc30sig00_array.addROWCCFC30SIG00(rowccfc30sig00);
    // Set the array into the parent struct
    ccfc30si.setROWCCFC30SIG00_ARRAY(rowccfc30sig00_array);
    return ccfc30si;
  }

  /**
   * populateCCFC18SI_D <p/> This populate method is used when an Education row is being deleted It populates the input
   * object for CCFC18S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc18si
   */
  public CCFC18SI populateCCFC18SI_D(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    ROWCCFC18SIG00 rowccfc18sig00 = new ROWCCFC18SIG00();
    CCFC18SI ccfc18si = new CCFC18SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCFC18SIG00_ARRAY rowccfc18sig00_array = new ROWCCFC18SIG00_ARRAY();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    // Only one row is ever saved or deleted, so statically set the page size
    // number to 1
    input.setUlPageSizeNbr(ONE);

    rowccfc18sig00.setUlIdEdhist(ContextHelper.getIntSafe(request, "hdnUlIdEdhist"));
    rowccfc18sig00
                  .setTsLastUpdate(DateHelper
                                             .toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsEduLastUpdate")));
    rowccfc18sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);

    ccfc18si.setArchInputStruct(input);
    // Add the struct to the array
    rowccfc18sig00_array.addROWCCFC18SIG00(rowccfc18sig00);
    // Set the array into the parent struct
    ccfc18si.setROWCCFC18SIG00_ARRAY(rowccfc18sig00_array);
    return ccfc18si;
  }

  /**
   * populateCFAD33SI_D <p/> This populate method is used when a F/A Home row is being deleted It populates the input
   * object for CFAD33S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cfad33si
   */
  public CFAD33SI populateCFAD33SI_D(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    CFAD33SIG00 cfad33sig00 = new CFAD33SIG00();
    CFAD33SI cfad33si = new CFAD33SI();
    ArchInputStruct input = new ArchInputStruct();
    CFAD33SIG00_ARRAY cfad33sig00_array = new CFAD33SIG00_ARRAY();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    // Only one row is ever saved or deleted, so statically set the page size
    // number to 1
    input.setUlPageSizeNbr(ONE);

    cfad33sig00.setUlIdIndivTraining(ContextHelper.getIntSafe(request, "hdnUlIdIndivTraining"));
    cfad33sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsFALastUpdate")));
    cfad33sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_DELETE);

    cfad33si.setArchInputStruct(input);

    // Add the struct to the array
    cfad33sig00_array.addCFAD33SIG00(cfad33sig00);
    // Set the array into the parent struct
    cfad33si.setCFAD33SIG00_ARRAY(cfad33sig00_array);
    return cfad33si;
  }

  /**
   * populateCFAD33SI_AU <p/> This populate method is used when a F/A Home row is being added or updated It populates
   * the input object for CFAD33S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cfad33si
   */
  public CFAD33SI populateCFAD33SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    CFAD33SIG00 cfad33sig00 = new CFAD33SIG00();
    CFAD33SI cfad33si = new CFAD33SI();
    ArchInputStruct input = new ArchInputStruct();
    CFAD33SIG00_ARRAY cfad33sig00_array = new CFAD33SIG00_ARRAY();

    int personID = GlobalData.getUlIdPerson(request);
    int stageID = GlobalData.getUlIdStage(request);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    // Only one row is ever saved or deleted, so statically set the page size
    // number to 1
    input.setUlPageSizeNbr(ONE);

    cfad33si.setUlIdPerson(personID);
    cfad33si.setUlIdStage(stageID);
    cfad33sig00.setUlIdIndivTraining(ContextHelper.getIntSafe(request, "hdnUlIdIndivTraining"));
    cfad33sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsFALastUpdate")));
    cfad33sig00.setSzCdSysDataActionOutcome(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    cfad33sig00.setSzCdIndivTrnType(ContextHelper.getStringSafe(request, "selSzCdIncRsrcType"));
    cfad33sig00.setDtDtIndivTrn(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "txtDtDtIndivTrn")));
    cfad33sig00.setCIndIndivTrnEc(CheckboxHelper.getCheckboxValue(request, "cbxCIndIndivTrnEc"));
    cfad33sig00.setLdNbrIndivTrnHrs(ContextHelper.getDoubleSafe(request, "txtLdNbrIndivTrnHrs"));
    cfad33sig00.setSNbrIndivTrnSession(ContextHelper.getIntSafe(request, "txtSNbrIndivTrnSession"));
    cfad33sig00.setSzTxtIndivTrnTitle(ContextHelper.getStringSafe(request, "txtSzTxtIndivTrnTitle"));

    cfad33sig00.setLdNmTrain1(ContextHelper.getStringSafe(request, "txtldNmTrain1"));
    cfad33sig00.setLdNmTrain2(ContextHelper.getStringSafe(request, "txtldNmTrain2"));
    cfad33sig00.setLdNmTrain3(ContextHelper.getStringSafe(request, "txtldNmTrain3"));
    cfad33sig00.setLdNmTrain4(ContextHelper.getStringSafe(request, "txtldNmTrain4"));

    cfad33sig00.setLdCdTrain1Role(ContextHelper.getStringSafe(request, "selldCdTrain1Role"));
    cfad33sig00.setLdCdTrain2Role(ContextHelper.getStringSafe(request, "selldCdTrain2Role"));
    cfad33sig00.setLdCdTrain3Role(ContextHelper.getStringSafe(request, "selldCdTrain3Role"));
    cfad33sig00.setLdCdTrain4Role(ContextHelper.getStringSafe(request, "selldCdTrain4Role"));

    cfad33sig00.setLdIndCoTrain(CheckboxHelper.getCheckboxValue(request, "cbxLdIndCoTrain"));
    cfad33sig00.setNmAgency(ContextHelper.getStringSafe(request, "txtNmAgency"));

    cfad33si.setArchInputStruct(input);

    // Add the struct to the array
    cfad33sig00_array.addCFAD33SIG00(cfad33sig00);
    // Set the array into the parent struct
    cfad33si.setCFAD33SIG00_ARRAY(cfad33sig00_array);
    return cfad33si;
  }

  /**
   * populateCINV34SI_AU <p/> This populate method is used when Person Characteristics is being updated It populates the
   * input object for CINV34S It uses checkbox helper to determine three things. 1. If "No Characteristics" or "None
   * Diagnosed have been checked. If this is true, then all other charactersitics that previously were checked will be
   * end-dated in the database. 2. What characteristics have been checked. It adds a row for each characteristic
   * checked. 3. What charactersitics have been de-selected. It end-dates each row for a check box that has been
   * de-selected.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cinv34si
   * @throws gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException
   *           Thrown when there is an error with checkbox helper
   */
  public CINV34SI populateCINV34SI_AU(GrndsExchangeContext context) throws CheckboxHelperException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CINV24SO cinv24so = (CINV24SO) state.getAttribute("CINV24SO", request);
    ROWCINV24SOG_ARRAY charArray = cinv24so.getROWCINV24SOG_ARRAY();
    CINV34SI cinv34si = new CINV34SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCINV34SIG_ARRAY rowcinv34sig_array = new ROWCINV34SIG_ARRAY();
    int personID = GlobalData.getUlIdPerson(request);
    Date date = new Date();
    int stageID = GlobalData.getUlIdStage(request);
    int caseID = GlobalData.getUlIdCase(request);
    String task = GlobalData.getSzCdTask(request);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    int userID = user.getUserID();
    input.setSzUserId(user.getUserLogonID());

    input.setCReqFuncCd("P");
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(SIXTY_FIVE);

    cinv34si.setSzCdPersonDeath(cinv24so.getSzCdPersonDeath());
    cinv34si.setSzCdPersonEthnicGroup(cinv24so.getSzCdPersonEthnicGroup());
    cinv34si.setSzCdPersonLanguage(cinv24so.getSzCdPersonLanguage());
    cinv34si.setSzCdPersonLivArr(cinv24so.getSzCdPersonLivArr());
    cinv34si.setSzCdPersonMaritalStatus(cinv24so.getSzCdPersonMaritalStatus());
    cinv34si.setSzCdPersonRelationship(cinv24so.getSzCdPersonRelationship());
    cinv34si.setSzCdPersonReligion(cinv24so.getSzCdPersonReligion());
    cinv34si.setCCdPersonSex(cinv24so.getCCdPersonSex());
    cinv34si.setCdPersonStatus(cinv24so.getCdPersonStatus());
    cinv34si.setDtDtPersonBirth(cinv24so.getDtDtPersonBirth());
    cinv34si.setDtDtPersonDeath(cinv24so.getDtDtPersonDeath());
    cinv34si.setSzNmPersonFull(cinv24so.getSzNmPersonFull());
    cinv34si.setBIndPersonDobApprox(cinv24so.getBIndPersonDobApprox());
    cinv34si.setSzTxtOccupation(cinv24so.getSzTxtOccupation());
    cinv34si.setTsLastUpdate(cinv24so.getTsLastUpdate());
    cinv34si.setUlIdPerson(personID);
    cinv34si.setUlIdIncRsrcWorker(userID);
    cinv34si.setUlIdStage(stageID);
    cinv34si.setUlIdCase(caseID);
    cinv34si.setSzCdTask(task);
    cinv34si.setSzTxtCharCmnts(ContextHelper.getStringSafe(request, "szTxtCharCmnts"));
    cinv34si.setIndPrevAdopt(ContextHelper.getStringSafe(request, "rbPrevAdopt"));
    cinv34si.setIndPrevAdoptPre(cinv24so.getIndPrevAdopt());
    cinv34si.setIndAdoptnDislutn(ContextHelper.getStringSafe(request, "chkAdoptDislutn"));
    cinv34si.setIndAdoptnDislutnPre(cinv24so.getIndAdoptnDislutn());
    // these three added for adam
    cinv34si.setSzAgency(ContextHelper.getStringSafe(request, "szAgency"));
    cinv34si.setTxtDissolutionDate(ContextHelper.getCastorDateSafe(request, "txtDissolutionDate"));
    cinv34si.setTxtPrevAdopt(ContextHelper.getCastorDateSafe(request, "txtPrevAdopt"));
    // 
    
    // SMS #81140: MR-074     
    cinv34si.setIndSingleParAdpt(ContextHelper.getStringSafe(request, RADIO_SINGLE_PAR_ADPT));
    cinv34si.setSzCdSngleMomOrFar(ContextHelper.getStringSafe(request, RADIO_SINGLE_MOM_OR_FAR));
    // MR-092: Fostering Connection. Used to prepopulate indicator on AA Funding Summary page
    cinv34si.setBIndIVEPriorAdoption(ContextHelper.getStringSafe(request, RADIO_IVE_PRIOR_ADOPTION));
     
    cinv34si.setIndPublicAdoptn(ContextHelper.getStringSafe(request, "rbAdoptType"));
    cinv34si.setIndIntlAdoptn(ContextHelper.getStringSafe(request, "chkIntlAdopt"));
    cinv34si.setSzCdCounty(ContextHelper.getStringSafe(request, "cdCounty"));
    cinv34si.setSzCdState(ContextHelper.getStringSafe(request, "cdState"));
    cinv34si.setSzCdCntry(ContextHelper.getStringSafe(request, "cdCountry"));

    // If "No Characteristics" is checked, set BCdPersonChar to "2", and end
    // date any
    // Characteristics that were previously valid
    boolean x = StringHelper.isTrue(CheckboxHelper.getCheckboxValue(request, "cbxBCdPersonChar"));
    boolean y = StringHelper.isTrue(CheckboxHelper.getCheckboxValue(request, "cbxBCdPersonCharNDiog"));
    if (x || y) {
      if (x) {
        cinv34si.setBCdPersonChar(NO_CHARS);
      }
      if (y) {
        cinv34si.setBCdPersonChar(NOT_Yet_DIAG);
      }

      ROWCINV24SOG charRow;
      Enumeration charEnumeration = charArray.enumerateROWCINV24SOG();

      while (charEnumeration.hasMoreElements()) {
        charRow = (ROWCINV24SOG) charEnumeration.nextElement();
        ROWCINV34SIG rowcinv34sig = new ROWCINV34SIG();
        rowcinv34sig.setUlIdCharacteristics(charRow.getUlIdCharacteristics());
        rowcinv34sig.setCdCharacteristic(charRow.getCdCharacteristic());
        rowcinv34sig.setSzCdCharCategory(charRow.getSzCdCharCategory());
        rowcinv34sig.setDtDtCharStart(charRow.getDtDtCharStart());
        rowcinv34sig.setSysLastUpdate((charRow.getTsLastUpdate()));
        rowcinv34sig.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
        rowcinv34sig.setDtDtCharEnd(DateHelper.toCastorDate(date));
        rowcinv34sig_array.addROWCINV34SIG(rowcinv34sig);
      }
    } else {
      // If "No Characteristics" is not checked, loop through all checkboxes that have
      // been changed (either selected or de-selected). Depending on the action,
      // either insert or update the row.
      String[] cpmValues = CheckboxHelper.getCheckedValues(request, "cbxCPM");
      String[] cctValues = CheckboxHelper.getCheckedValues(request, "cbxCCT");
      String[] chbValues = CheckboxHelper.getCheckedValues(request, "cbxCHB");
      String[] cmeValues = CheckboxHelper.getCheckedValues(request, "cbxCME");
      String[] othValues = CheckboxHelper.getCheckedValues(request, "cbxOTH");

      if (cpmValues.length != 0 || cctValues.length != 0 || chbValues.length != 0 || cmeValues.length != 0
          || othValues.length != 0) {
        cinv34si.setBCdPersonChar(CHARS_CHECKED);
        cinv34si.setBCdPersNotYetDiag(CHARS_CHECKED);
      } else {
        cinv34si.setBCdPersonChar(NO_DATA);
      }

      Collection changedValues;
      changedValues = CheckboxHelper.getChangedValues(request, "cbxCPM", charArray, ROWCINV24SOG.class,
                                                      "CdCharacteristic");

      populateChars(changedValues, "CPM", cinv34si, rowcinv34sig_array);

      changedValues = CheckboxHelper.getChangedValues(request, "cbxCCT", charArray, ROWCINV24SOG.class,
                                                      "CdCharacteristic");
      populateChars(changedValues, "CCT", cinv34si, rowcinv34sig_array);

      changedValues = CheckboxHelper.getChangedValues(request, "cbxCHB", charArray, ROWCINV24SOG.class,
                                                      "CdCharacteristic");
      populateChars(changedValues, "CHB", cinv34si, rowcinv34sig_array);

      changedValues = CheckboxHelper.getChangedValues(request, "cbxCME", charArray, ROWCINV24SOG.class,
                                                      "CdCharacteristic");
      populateChars(changedValues, "CME", cinv34si, rowcinv34sig_array);

      changedValues = CheckboxHelper.getChangedValues(request, "cbxOTH", charArray, ROWCINV24SOG.class,
                                                      "CdCharacteristic");
      populateChars(changedValues, "OTH", cinv34si, rowcinv34sig_array);

    }// End Else

    // This logic will save the count as a short
    cinv34si.setSListRowsQty(Short.parseShort("" + rowcinv34sig_array.getROWCINV34SIGCount()));
    cinv34si.setArchInputStruct(input);
    cinv34si.setROWCINV34SIG_ARRAY(rowcinv34sig_array);
    // set security attribute value to recognize Medicaid Eligibility Specialist
    cinv34si.setSzCdAttrRegFamIndStf(UserProfile.SEC_REG_FAM_INDP_STF);
    cinv34si.setSzCdAttrRegFamIndMgmt(UserProfile.SEC_REG_FAM_INDP_MGMNT_STF);
    cinv34si.setSzCdAttrRegSsStf(UserProfile.SEC_REGIONAL_SS_STF);
    return cinv34si;

  }

  /**
   * populate Chars <p/> This method is used to populate the input structure for charactersitics that have been selected
   * or de-selected in the person characteristics page
   * 
   * @param changedValues
   *          Collection of the changed chars on the page
   * @param charCode
   *          The code for the current chars being put into the input object
   * @param cinv34si
   *          The input object for CINV34S
   * @param rowcinv34sig_array
   *          The array to be placed in the input object
   */
  public void populateChars(Collection changedValues, String charCode, CINV34SI cinv34si,
                            ROWCINV34SIG_ARRAY rowcinv34sig_array) {
    Date date = new Date();
    Iterator i = changedValues.iterator();
    // If changed values has items, set the person char indicator to
    // indicate that things have been changed
    if (i.hasNext()) {
      cinv34si.setBCdPersonChar(CHARS_CHECKED);
      cinv34si.setBCdPersNotYetDiag(CHARS_CHECKED);
    }
    // while the iterator of changed values has items, loop through the items
    // and determine if
    // the characteristic is newly selected (add) or de-selected (update)
    while (i.hasNext()) {
      CheckboxHelper.ObjectActionCodePair value = (CheckboxHelper.ObjectActionCodePair) i.next();
      String capIndicator = value.getActionCode();
      ROWCINV24SOG obj = (ROWCINV24SOG) value.getObject();
      ROWCINV34SIG rowcinv34sig = new ROWCINV34SIG();
      // If the characteristic is newly selected (add) set the reqfunc code to
      // add, and set the
      // end date to max date
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(capIndicator)) {
        rowcinv34sig.setCdCharacteristic(obj.getCdCharacteristic());
        rowcinv34sig.setSzCdCharCategory(charCode);
        rowcinv34sig.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
        rowcinv34sig.setDtDtCharStart(DateHelper.toCastorDate(date));
        rowcinv34sig.setDtDtCharEnd(DateHelper.MAX_CASTOR_DATE);
      }
      // Otherwise, the characteristic has been de-selected so set the reqFuncCd
      // to update and the
      // end date for this particular characteristic to today's date
      else {
        rowcinv34sig.setUlIdCharacteristics(obj.getUlIdCharacteristics());
        rowcinv34sig.setCdCharacteristic(obj.getCdCharacteristic());
        rowcinv34sig.setSzCdCharCategory(obj.getSzCdCharCategory());
        rowcinv34sig.setDtDtCharStart(obj.getDtDtCharStart());
        rowcinv34sig.setSysLastUpdate((obj.getTsLastUpdate()));
        rowcinv34sig.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
        rowcinv34sig.setDtDtCharEnd(DateHelper.toCastorDate(date));
      }
      rowcinv34sig_array.addROWCINV34SIG(rowcinv34sig);
    }

  }

  /**
   * populateCCFC23SI_V <p/> This method is used to populate the input structure for the Validate Method for Person
   * Merge
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc23si
   */
  public CCFC23SI populateCCFC23SI_V(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    CCFC23SI ccfc23si = new CCFC23SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(SIXTY_FIVE);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccfc23si.setUlIdPersMergeClosed(ContextHelper.getIntSafe(request, "txtUlIdPersMergeClosed"));
    ccfc23si.setUlIdPersMergeForward(ContextHelper.getIntSafe(request, "txtUlIdPersMergeForward"));
    ccfc23si.setCWcdPersonPassedIn(ContextHelper.getStringSafe(request, "hdnCWcdPersonPassedIn"));

    ccfc23si.setArchInputStruct(input);

    return ccfc23si;
  }

  /**
   * populateCCFC14SI_AU <p/> This populate method is used when a Person Merge row is being added or updated It
   * populates the input object for CCFC14S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return ccfc14si
   */
  public CCFC14SI populateCCFC14SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures

    ROWCCFC14SIG00 rowccfc14sig00 = new ROWCCFC14SIG00();
    CCFC14SI ccfc14si = new CCFC14SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCFC14SIG00_ARRAY rowccfc14sig00_array = new ROWCCFC14SIG00_ARRAY();

    // Retrieve user information for saving to the database
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int userID = user.getUserID();
    String userName = user.getUserFullName();
    Date date = new Date();

    String cReqFuncCD = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(cReqFuncCD);
    // Only one row is ever saved or deleted, so statically set the page size
    // number to 1
    input.setUlPageSizeNbr(ONE);
    input.setSzUserId(user.getUserLogonID());

    ccfc14si.setUlIdPersonRequestor(userID);

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCD)) {

      rowccfc14sig00.setSzScrNmPersMergeClosed(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeClosed"));
      rowccfc14sig00.setSzScrNmPersMergeForward(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeForward"));
      rowccfc14sig00.setSzScrNmPersMergeWrkr(userName);

      rowccfc14sig00.setUlIdPersMergeClosed(ContextHelper.getIntSafe(request, "txtUlIdPersMergeClosed"));
      rowccfc14sig00.setUlIdPersMergeWrkr(userID);
      rowccfc14sig00.setUlIdPersMergeForward(ContextHelper.getIntSafe(request, "txtUlIdPersMergeForward"));
      rowccfc14sig00.setDtDtPersMerge(DateHelper.toCastorDate(date));
      rowccfc14sig00.setDtDtPersMergeSplit(null);
      rowccfc14sig00.setCIndPersMergeInvalid(ArchitectureConstants.N);
      rowccfc14sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_ADD);

    }
    // If the row is not to be added, it is to be updated and therefore split
    else {

      rowccfc14sig00.setSzScrNmPersMergeClosed(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeClosed"));
      rowccfc14sig00.setSzScrNmPersMergeForward(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeForward"));
      rowccfc14sig00.setSzScrNmPersMergeWrkr(ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeWrkr"));
      rowccfc14sig00.setSzScrNmPersMrgSpltWrkr(userName);
      rowccfc14sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                           "hdnTsMergeLastUpdate")));
      rowccfc14sig00.setUlIdPersMergeClosed(Integer.parseInt(ContextHelper.getStringSafe(request,
                                                                                         "txtUlIdPersMergeClosed")));
      rowccfc14sig00.setUlIdPersMergeWrkr(ContextHelper.getIntSafe(request, "hdnUlIdPersMergeWrkr"));
      rowccfc14sig00.setUlIdPersMergeSplitWrkr(userID);
      rowccfc14sig00.setUlIdPersonMerge(ContextHelper.getIntSafe(request, "hdnUlIdPersonMerge"));
      rowccfc14sig00.setUlIdPersMergeForward(Integer.parseInt(ContextHelper.getStringSafe(request,
                                                                                          "txtUlIdPersMergeForward")));
      rowccfc14sig00.setDtDtPersMerge(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                                              "dspDtDtPersMerge")));
      rowccfc14sig00.setDtDtPersMergeSplit(DateHelper.toCastorDate(date));
      rowccfc14sig00.setCIndPersMergeInvalid(ArchitectureConstants.Y);
      rowccfc14sig00.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_UPDATE);

    }

    ccfc14si.setArchInputStruct(input);

    // Add the struct to the array
    rowccfc14sig00_array.addROWCCFC14SIG00(rowccfc14sig00);
    // Set the array into the parent struct
    ccfc14si.setROWCCFC14SIG00_ARRAY(rowccfc14sig00_array);
    return ccfc14si;
  }

  /**
   * Switch Merge <p/> This method is used to flip-flop the forward and closed person in the merge split page.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void switchMerge_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addMergeSplit_xa()");
    performanceTrace.enterScope();

    String ulIdPersMergeForward = (ContextHelper.getStringSafe(request, "txtUlIdPersMergeForward"));
    String ulIdPersMergeClosed = (ContextHelper.getStringSafe(request, "txtUlIdPersMergeClosed"));
    String szScrNmPersMergeForward = (ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeForward"));
    String SzScrNmPersMergeClosed = (ContextHelper.getStringSafe(request, "dspSzScrNmPersMergeClosed"));
    String cWcdPersonPassedIn = (ContextHelper.getStringSafe(request, "hdnCWcdPersonPassedIn"));
    String bIndActiveStatus = (ContextHelper.getStringSafe(request, "hdnBIndActiveStatus"));
    String cSysIndPrimaryWorker = (ContextHelper.getStringSafe(request, "hdnCSysIndPrimaryWorker"));

    // Get Person Passed in from the request to determine if the current
    // position
    // is forward or closed.
    if (FORWARD.equals(cWcdPersonPassedIn)) {
      request.setAttribute(PERSON_PASSED_IN, CLOSED);
    } else {
      request.setAttribute(PERSON_PASSED_IN, FORWARD);
    }
    // Set the ReqFuncCd to Switch so the jsp will know where to get the
    // information for
    // its fields from
    request.setAttribute(REQ_FUNC_CD, SWITCH);
    request.setAttribute(IND_ACTIVE_STATUS, bIndActiveStatus);
    request.setAttribute(IND_PRIMARY_WORKER, cSysIndPrimaryWorker);
    request.setAttribute("txtUlIdPersMergeForward", ulIdPersMergeForward);
    request.setAttribute("txtUlIdPersMergeClosed", ulIdPersMergeClosed);
    request.setAttribute("dspSzScrNmPersMergeForward", szScrNmPersMergeForward);
    request.setAttribute("dspSzScrNmPersMergeClosed", SzScrNmPersMergeClosed);

    performanceTrace.exitScope();
  }

  /**
   * Add Income and Resources <p/> This method is used to display the Income and Resources Detail page so that a new row
   * can be added to the Income and Resources List on the Person Detail page. It first retrieves the Income and
   * Resources object from state, and then re-sets Monthly income into request so that it can be displayed on the Income
   * and Resources page. It also sets a page mode variable as "new" into request so that the pageMode in Person Helper
   * will not be over-written.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void addIncRsrc_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addIncRsrc_xa()");
    performanceTrace.enterScope();

    CCFC29SO ccfc29so = (CCFC29SO) state.getAttribute("CCFC29SO", request);
    // Objects in state are no longer needed, they will be re set on re-display
    // of person detail
    clearState(context);

    // Pass in the Monthly income variable from the ccfc29so object, as well as
    // the specific row needed
    request.setAttribute("lAmtIncRsrcMonth", FormattingHelper.formatMoney(ccfc29so.getLAmtIncRsrc()));

    // Set pageMode so that the page mode in state will not have to be over
    // written
    request.setAttribute(PAGE_MODE, PageModeConstants.NEW);
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);

    performanceTrace.exitScope();
  }

  /**
   * Add Merge Split <p/> This method is used to display the Merge Split Detail page for adding a new merge row to the
   * Merge Split List on Person Detail. It first retrieves the Merge Split object from state, and then puts important
   * data from that object back into request. It then determines if the Person Detail page is for an Employee. If the
   * Person Detail page is for an employee, it places the person information into the forward fields, such that an
   * employee cannot become a merged person.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void addMergeSplit_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addMergeSplit_xa()");
    performanceTrace.enterScope();

    CCFC13SO ccfc13so = (CCFC13SO) state.getAttribute("CCFC13SO", request);
    clearState(context);
    state.setAttribute("CCFC13SO", ccfc13so, request);
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);
    request.setAttribute(IND_ACTIVE_STATUS, ccfc13so.getBIndActiveStatus());
    request.setAttribute(IND_PRIMARY_WORKER, ccfc13so.getBIndActiveStatus());
    request.setAttribute("bIndValidate", ArchitectureConstants.N);
    String szNmPersonFull = (ContextHelper.getStringSafe(request, "hdnSzNmPersonFull"));
    request.setAttribute("szNmPersonFull", szNmPersonFull);

    setMergeSplitPageSet(user, context, ccfc13so.getCSysIndPrimaryWorker());

    // Set pageMode so that the page mode in state will not have to be over
    // written
    request.setAttribute(PAGE_MODE, PageModeConstants.EDIT);

    // If the Person passed in is an employee, set their information to be
    // placed in the forward division, otherwise it shoudl be placed in the
    // closed information.
    if (StringHelper.isTrue(ccfc13so.getBIndActiveStatus())) {
      request.setAttribute(PERSON_PASSED_IN, FORWARD);
    } else {
      request.setAttribute(PERSON_PASSED_IN, CLOSED);
    }

    // SIR 23726 - Show case checkedout message when accessed from a stage checked out to MPS
    if (CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request))
        && !PageModeConstants.VIEW.equals(PersonHelper.getPersonDetailPageMode(request))
        && !GlobalData.isApprovalMode(request)) {
      setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, request);
    }

    performanceTrace.exitScope();
  }

  /**
   * Display Education <p/> This method is used to display the Education Detail page. It retrieves the Education Object
   * out of state, and places the individual row that has been selected in the person detail page into request. It also
   * sets a page mode variable into request so that the pageMode in Person Helper does not get overwritten with the
   * individual page mode for this detail page. The last thing it does is create an array of checked values for the
   * checkboxes on the page
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void reDisplayEducation_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayEducation_xa()");
    performanceTrace.enterScope();

    // Set detail fields that are not populated by the pull back into the
    // education display
    // SO object so that they can be redisplayed after the pull back is complete
    List<String> checkedValues = new ArrayList<String>(10);
    ROWCCFC17SOG00 rowccfc17sog00 = new ROWCCFC17SOG00();
    rowccfc17sog00.setUlIdEdhist(ContextHelper.getIntSafe(request, "hdnUlIdEdhist"));
    rowccfc17sog00
                  .setTsLastUpdate(DateHelper
                                             .toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsEduLastUpdate")));
    rowccfc17sog00.setCIndEdhistTeaSchool(ContextHelper.getStringSafe(request, "rbCIndEdhistTeaSchool"));
    rowccfc17sog00.setSzCdEdhistEnrollGrade(ContextHelper.getStringSafe(request, "selSzCdEdhistEnrollGrade"));
    rowccfc17sog00.setSzCdEdhistWithdrawnGrade(ContextHelper.getStringSafe(request, "selSzCdEdhistWithdrawnGrade"));

    // Only set the dates into the object if they are not null. If they are null
    // they come back as NULL_CASTOR_DATE on redisplay
    if (ContextHelper.getStringSafe(request, "txtDtDtEdhistEnrollDate") != null) {
      rowccfc17sog00
                    .setDtDtEdhistEnrollDate(DateHelper
                                                       .toCastorDateSafe(ContextHelper
                                                                                      .getStringSafe(request,
                                                                                                     "txtDtDtEdhistEnrollDate")));
    }
    if (ContextHelper.getStringSafe(request, "txtDtDtEdhistWithdrawnDate") != null) {
      rowccfc17sog00
                    .setDtDtEdhistWithdrawnDate(DateHelper
                                                          .toCastorDateSafe(ContextHelper
                                                                                         .getStringSafe(request,
                                                                                                        "txtDtDtEdhistWithdrawnDate")));
    }
    // Each one of the checkboxes has its own set method, check to see if they
    // are checked,
    // if they are set the set method to the value of that checkbox (which will
    // be the code
    // from the codes table.
    String cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds1");
    if (cbxSzCdEdhistNeeds != null) {
      checkedValues.add(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds2");
    if (cbxSzCdEdhistNeeds != null) {
      checkedValues.add(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds3");
    if (cbxSzCdEdhistNeeds != null) {
      checkedValues.add(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds4");
    if (cbxSzCdEdhistNeeds != null) {
      checkedValues.add(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds5");
    if (cbxSzCdEdhistNeeds != null) {
      checkedValues.add(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds6");
    if (cbxSzCdEdhistNeeds != null) {
      checkedValues.add(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds7");
    if (cbxSzCdEdhistNeeds != null) {
      checkedValues.add(cbxSzCdEdhistNeeds);
    }

    cbxSzCdEdhistNeeds = ContextHelper.getString(request, "cbxSzCdEdhistNeeds8");
    if (cbxSzCdEdhistNeeds != null) {
      checkedValues.add(cbxSzCdEdhistNeeds);
    }

    rowccfc17sog00.setRbCIndEdhistLevel(ContextHelper.getStringSafe(request, "rbCIndEdhistLevel"));
    rowccfc17sog00.setSzCEdhistCurrentGradeLevel(ContextHelper.getStringSafe(request, "selSzCEdhistCurrentGradeLevel"));
    rowccfc17sog00.setSzCEdhistAttendance(ContextHelper.getStringSafe(request, "selSzCEdhistAttendance"));

    rowccfc17sog00.setRbSchoolRecs(ContextHelper.getStringSafe(request, "rbSchoolRecs"));
    rowccfc17sog00.setRbRecsToBCounty(ContextHelper.getStringSafe(request, "rbRecsToBCounty"));
    rowccfc17sog00.setRbSchoolChange(ContextHelper.getStringSafe(request, "rbSchoolChange"));
    rowccfc17sog00.setSzTxtBehaveDisc(ContextHelper.getStringSafe(request, "szTxtBehaveDisc"));
    rowccfc17sog00.setRbSpecialEdNeeds(ContextHelper.getStringSafe(request, "rbSpecialEdNeeds"));
    rowccfc17sog00.setRbSpecialEdSvc(ContextHelper.getStringSafe(request, "rbSpecialEdSvc"));
    rowccfc17sog00.setSzTxtSpecialEdCmnts(ContextHelper.getStringSafe(request, "szTxtSpecialEdCmnts"));
    rowccfc17sog00.setSzDtStSupTeamRef(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                             "szDtStSupTeamRef")));
    rowccfc17sog00.setSzDtRbEdDate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "szDtRbEdDate")));
    rowccfc17sog00.setTxtSurrogateParent(ContextHelper.getStringSafe(request, "txtSurrogateParent"));
    rowccfc17sog00.setRbIndFosterParent(ContextHelper.getStringSafe(request, "rbIndFosterParent"));
    rowccfc17sog00.setRbLegalParent(ContextHelper.getStringSafe(request, "rbLegalParent"));
    rowccfc17sog00.setSzTxtSstIepCmnts(ContextHelper.getStringSafe(request, "szTxtSstIepCmnts"));
    rowccfc17sog00.setRbChildServices(ContextHelper.getStringSafe(request, "rbChildServices"));
    rowccfc17sog00.setRbPrevChildSvc(ContextHelper.getStringSafe(request, "rbPrevChildSvc"));
    rowccfc17sog00.setSzTxtChildSvcComments(ContextHelper.getStringSafe(request, "szTxtChildSvcComments"));

    request.setAttribute("ROWCCFC17SOG00", rowccfc17sog00);
    request.setAttribute("checkedValues", checkedValues);
    String reqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
    request.setAttribute("cReqFuncCd", reqFuncCd);

    String pageName;
    if (state.getAttribute("pageName", request) == null) {
      pageName = ContextHelper.getStringSafe(request, "pageName");

    } else {
      pageName = (String) state.getAttribute("pageName", request);

    }
    if ("ChildPlan".equals(pageName))

    {
      ChildPlanDetailRetrieveSO childPlanDetailRetrieveSO = (ChildPlanDetailRetrieveSO) state
                                                                                             .getAttribute(
                                                                                                           "ChildPlanDetailRetrieveSO",
                                                                                                           request);
      state.setAttribute("ChildPlanDetailRetrieveSO", childPlanDetailRetrieveSO, request);
      request.setAttribute("pageName", "ChildPlan");
      state.setAttribute("pageName", pageName, request);

    }

    // Set a pageMode variable to New since this method can only be called when
    // the page is in new mode.
    request.setAttribute(PAGE_MODE, PageModeConstants.NEW);

    performanceTrace.exitScope();
  }

  /**
   * Display Education <p/> This method is used to display the Education Detail page. It retrieves the Education Object
   * out of state, and places the individual row that has been selected in the person detail page into request. It also
   * sets a page mode variable into request so that the pageMode in Person Helper does not get overwritten with the
   * individual page mode for this detail page. The last thing it does is create an array of checked values for the
   * checkboxes on the page
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayEducation_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayEducation_xa()");
    performanceTrace.enterScope();

    int index = ContextHelper.getIntSafe(request, "hdnEduLoopCount");
    String IndChildPlan = ContextHelper.getStringSafe(request, "hdnIndChildPage");

    // Retrieve ccfc17so from state, remove all other objects, and then re-set
    // ccfc17so back into state
    CCFC17SO ccfc17so = (CCFC17SO) state.getAttribute("CCFC17SO", request);
    // if("N".equals(IndChildPlan))
    // {
    // clearState(context);
    // }
    // clearState(context);
    state.setAttribute("CCFC17SO", ccfc17so, request);

    ROWCCFC17SOG00 rowccfc17sog00 = ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(index);
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
    request.setAttribute("ROWCCFC17SOG00", ccfc17so.getROWCCFC17SOG00_ARRAY().getROWCCFC17SOG00(index));

    // Set a page mode variable into the request based on what the state page
    // mode is, this is so that
    // the PersonHelper page mode will not be changed when navigating to a
    // detail page

    String globalPageMode;
    if ("Y".equals(IndChildPlan)) {
      globalPageMode = "MODIFY";
      // STGAP00005609 - Child Plan SO will still be visible here; plus, it is mistake to populate it from request since  
      // it will generate an all-null-field object because Child Plan page fields are not visible here; 
      /*ChildPlanDetailRetrieveSO childPlanDetailRetrieveSO = new ChildPlanDetailRetrieveSO();
      childPlanDetailRetrieveSO = populateInfo(request, childPlanDetailRetrieveSO);
      state.setAttribute("ChildPlanDetailRetrieveSO", childPlanDetailRetrieveSO, request);*/
      // end STGAP00005609
      state.setAttribute("pageName", "ChildPlan", request);
      request.setAttribute("pageName", "ChildPlan");
    } else {
      globalPageMode = PersonHelper.getPersonDetailPageMode(request);
    }
    String pageMode = "";

    if (PageModeConstants.MODIFY.equals(globalPageMode) || WINDOW_MODE_RELATE.equals(globalPageMode)
        || WINDOW_MODE_MNTN_PERSON.equals(globalPageMode) || PageModeConstants.NEW.equals(globalPageMode)) {
      pageMode = PageModeConstants.MODIFY;
    } else if (PageModeConstants.VIEW.equals(globalPageMode)) {
      pageMode = PageModeConstants.VIEW;
    }
    request.setAttribute(PAGE_MODE, pageMode);

    List<String> checkedValues = new ArrayList<String>(12);

    if (rowccfc17sog00.getSzCdEdhistNeeds1() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds1());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds2() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds2());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds3() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds3());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds4() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds4());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds5() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds5());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds6() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds6());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds7() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds7());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds8() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds8());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds9() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds9());
    }
    if (rowccfc17sog00.getSzCdEdhistNeeds10() != null) {
      checkedValues.add(rowccfc17sog00.getSzCdEdhistNeeds10());
    }
    request.setAttribute("checkedValues", checkedValues);

    performanceTrace.exitScope();
  }

  /**
   * Display Income and Resources <p/> This method is used to display the Income and Resources page. It retrieves the
   * Income and Resources Object out of state, and places the individual row that has been selected in the person detail
   * page into request. It also sets a page mode variable into request so that the pageMode in Person Helper does not
   * get overwritten with the individual page mode for this detail page.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayIncRsrc_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayIncRsrc_xa()");
    performanceTrace.enterScope();

    int index = ContextHelper.getIntSafe(request, "hdnIncLoopCount");

    // Retrieve ccfc29so from state, remove all other objects, and then re-set
    // ccfc29so back into state
    CCFC29SO ccfc29so = (CCFC29SO) state.getAttribute("CCFC29SO", request);
    clearState(context);
    state.setAttribute("CCFC29SO", ccfc29so, request);

    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
    // Pass in the Monthly income variable from the ccfc29so object, as well as
    // the specific row needed
    request.setAttribute("lAmtIncRsrcMonth", FormattingHelper.formatMoney(ccfc29so.getLAmtIncRsrc()));
    request.setAttribute("ROWCCFC29SOG00", ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(index));

    // Set a page mode variable into the request based on what the PersonHelper
    // page mode is, this is so that
    // the Person Helper page mode will not be changed when navigating to a
    // detail Page
    String globalPageMode = PersonHelper.getPersonDetailPageMode(request);
    String pageMode = "";

    if (PageModeConstants.MODIFY.equals(globalPageMode) || WINDOW_MODE_RELATE.equals(globalPageMode)
        || WINDOW_MODE_MNTN_PERSON.equals(globalPageMode) || PageModeConstants.NEW.equals(globalPageMode)) {
      pageMode = PageModeConstants.MODIFY;
    } else if (PageModeConstants.VIEW.equals(globalPageMode)) {
      pageMode = PageModeConstants.VIEW;
    }
    request.setAttribute(PAGE_MODE, pageMode);

    performanceTrace.exitScope();
  }

  /**
   * Set Person Detail Page Set <p/> This method is used to determine the page set that person detail should be in.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  protected void setPersonDetailPageSet(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String pageMode = PersonHelper.getPersonDetailPageMode(request);

    // SIR 23727 - The first thing we want to check is if we are in the Mobile
    // environment. If we are, then there is a special page set (F) that will
    // allow for the display only mode that Mobile needs. If we are in Mobile
    // then NONE of the other sets will apply. Also, if we are in Mobile
    // the page mode will always be view, this takes care of a majority of the
    // fields on the page.
    if (PlatformConstants.MOBILE_IMPACT) {
      Sets.setPageSet(Sets.F, request);
      PersonHelper.setPersonDetailPageMode(request, PageModeConstants.VIEW);
    } else if (WINDOW_MODE_RELATE.equals(pageMode)) {
      Sets.setPageSet(Sets.A, request);
    }
    // SIR 16995 GRIMSHAN -- Added condition to the Set C to ensure that the
    // stage is not
    // INV, Added Set D for modify mode AND stage is INV
    else if (PageModeConstants.MODIFY.equals(pageMode) && !"INV".equals(GlobalData.getSzCdStage(request))) {
      Sets.setPageSet(Sets.C, request);
    } else if (PageModeConstants.MODIFY.equals(pageMode) && "INV".equals(GlobalData.getSzCdStage(request))) {
      Sets.setPageSet(Sets.D, request);
    }
    // SIR 16774 GRIMSHAN -- Check Y.equals so it won't cause a null pointer
    // exception
    // SIR 17607 GRIMSHAN -- If the page mode is view or maintain person, set
    // the page
    // mode to view, since even users with maintain person security attribute
    // should not
    // be able to change info via person detail for employees.
    // SIR 19581 If BSysIndViewPersonInfo is N, set the page into employee mode
    else if ((PageModeConstants.VIEW.equals(pageMode) || WINDOW_MODE_MNTN_PERSON.equals(pageMode))
             && ArchitectureConstants.Y.equals(PersonHelper.getBIndActiveStatus(request))
             || "N".equals(PersonHelper.getBSysIndViewPersonInfo(request))) {
      PersonHelper.setPersonDetailPageMode(request, PageModeConstants.VIEW);
      Sets.setPageSet(Sets.E, request);
    } else if (WINDOW_MODE_MNTN_PERSON.equals(pageMode)) {
      Sets.setPageSet(Sets.B, request);
    }

  }

  /**
   * Add Person Detail <p/> This method is used to display the Person Detail page in Add mode. It calls the
   * setPersonDetailPageSet method to put the page in the right page set, and diplays a message informing the user that
   * the list information will be available for adding after the page has been saved.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void addPersonDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addPersonDetail_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      // STGAP00017013: MR-095
      // Call the person retrieve to display a new section 'Add Person to Active Stages' when a person is added to the system
      // This would be the only retrieve for the new person add
      CINV04SI cinv04si = populateCINV04SI_Retrieve(context);
      CINV04SO cinv04so = person.retrievePersonDetail(cinv04si);
      state.setAttribute("CINV04SO", cinv04so, request);
      
      // state.removeAttribute("CINV04SO", request);
      // End STGAP00017013: MR-095
      state.removeAttribute("CINV24SO", request);
      state.removeAttribute("CCFC17SO", request);
      state.removeAttribute("CFAD32SO", request);
      state.removeAttribute("CCFC29SO", request);
      state.removeAttribute("CCFC13SO", request);

      GlobalData.setSzNmPersonFull("", request);
      setPersonDetailPageSet(context);
      setInformationalMessage(Messages.MSG_LIST_INFORMATION, request);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Display Event Case <p/> This method is used to Display either the Event List or Case List pages depending on what
   * the user has selected in the Options dropdown. If the user has chosed to view case list for the person, the method
   * forwards the system to the Case List Conversation. Otherwise, if they have chosen to View person Events, it re-sets
   * the ID Person into Global Data, and forwards to the Event List conversation. Otherwise, it passes the type of
   * events the user has selected to view and forwards to the Event List conversation
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayEventCase_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayEventCase_xa()");
    performanceTrace.enterScope();

    try {
      String eventCode = ContextHelper.getStringSafe(request, "selOption_CLEAN");

      // If the event code retrieved is for Viewing case list, forward to the
      // Case List conversation
      // if (eventCode.equals(VIEW_CASE_LIST)) {
      if (VIEW_CASE_LIST.equals(eventCode)) {
        GlobalData.setUlIdPerson(GlobalData.getUlIdPerson(request), request);
        GrndsTrace.msg(TRACE_TAG, 9, "forward url: " + CASE_LIST_CALLED);
        request.setAttribute("indUseStageCode", ArchitectureConstants.Y);
        forward(CASE_LIST_CALLED, request, context.getResponse());
      }
      // Else forward to the Event List convesration
      else {
        GlobalData.setUlIdPerson(GlobalData.getUlIdPerson(request), request);

        Map<String, String> map = new HashMap<String, String>();
        // If the event code retrieved is not for viewing all person events,
        // pass
        // that code into the event list conversation. If we want to view all
        // person
        // events then no event code is passed.
        if (VIEW_PERSON_EVENTS.equals(eventCode) == false) {
          map.put("eventTypeCode", eventCode);
        }
        map.put(EventSearchConversation.CALLER, EventSearchConversation.CALLER_PERSON_DETAIL);

        String url = getUrl(EventSearchConversation.EVENT_LIST, map);
        GrndsTrace.msg(TRACE_TAG, 9, "forward url: " + url);
        forward(url, context.getRequest(), context.getResponse());
      }
    } catch (ServletException ex) {
      processSevereException(context, ex);
    }

    performanceTrace.exitScope();
  }

  /**
   * Display Inc Rsrc List <p/> This helper method is used to call CCFC29S for retrieving the list information for
   * Income and Resources. It calls the populateCCFC29SI helper method to populate the input object for retrieving.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @throws MarshalException
   *           Thrown if there are problems with castor
   * @throws ValidationException
   *           Thrown if there are problems with castor
   * @throws ServiceException
   *           Thrown if there are poblems with the service
   */

  public void displayIncRsrcList(GrndsExchangeContext context) throws MarshalException, ValidationException,
                                                              ServiceException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCFC29SI ccfc29si = populateCCFC29SI_Retrieve(context);
    /*
     * String outputXml3 = ServiceHelper.callService("CCFC29S", ccfc29si); CCFC29SO ccfc29so = CCFC29SO.unmarshal(new
     * StringReader(outputXml3));
     */
    CCFC29SO ccfc29so = person.retrieveIncomeAndResources(ccfc29si);
    state.setAttribute("CCFC29SO", ccfc29so, request);
    // End Income and Resources
  }

  /**
   * Display Education List <p/> This helper method is used to call CCFC17S for retrieving the list information for
   * Education List It calls the populateCCFC17SI helper method to populate the input object for retrieving.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @throws MarshalException
   *           Thrown if there are problems with castor
   * @throws ValidationException
   *           Thrown if there are problems with castor
   * @throws ServiceException
   *           Thrown if there are poblems with the service
   */

  public void displayEducationList(GrndsExchangeContext context) throws MarshalException, ValidationException,
                                                                ServiceException

  {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCFC17SI ccfc17si = populateCCFC17SI_Retrieve(context);

    /*
     * String outputXml4 = ServiceHelper.callService("CCFC17S", ccfc17si); CCFC17SO ccfc17so = CCFC17SO.unmarshal(new
     * StringReader(outputXml4));
     */
    CCFC17SO ccfc17so = person.retrieveEducationalHistory(ccfc17si);
    state.setAttribute("CCFC17SO", ccfc17so, request);
    // End Education
  }

  /**
   * Display Char List <p/> This helper method is used to call CINV24S for retrieving the list information for Char List
   * It calls the populateCINV24SI helper method to populate the input object for retrieving.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @throws MarshalException
   *           Thrown if there are problems with castor
   * @throws ValidationException
   *           Thrown if there are problems with castor
   * @throws ServiceException
   *           Thrown if there are poblems with the service
   */
  public void displayCharList(GrndsExchangeContext context) throws MarshalException, ValidationException,
                                                           ServiceException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    Date updateDate = null;
    CINV24SI cinv24si = populateCINV24SI_Retrieve(context);

    /*
     * String outputXml5 = ServiceHelper.callService("CINV24S", cinv24si); CINV24SO cinv24so = CINV24SO.unmarshal(new
     * StringReader(outputXml5));
     */
    CINV24SO cinv24so = person.retrievePerson(cinv24si);
    state.setAttribute("CINV24SO", cinv24so, request);

    boolean displayParent = displayParentCharacteristics(request);
    boolean displayChildInvest = displayChildInvestCharacteristics(request);

    ROWCINV24SOG[] characteristics = cinv24so.getROWCINV24SOG_ARRAY().getROWCINV24SOG();
    List<ROWCINV24SOG> list = new ArrayList<ROWCINV24SOG>(characteristics.length);

    for (int i = 0; i < characteristics.length; i++) {
      ROWCINV24SOG characteristic = characteristics[i];
      String category = characteristic.getSzCdCharCategory();
      updateDate = characteristic.getTsLastUpdate();

      /*
       * if (displayAPS && CodesTables.CCHRTCAT_CAP.equals(category)) { list.add(characteristic); }
       */
      if (displayChildInvest && CodesTables.CCHRTCAT_CPM.equals(category)) {
        list.add(characteristic);
      }
      if (displayChildInvest && CodesTables.CCHRTCAT_CHB.equals(category)) {
        list.add(characteristic);
      }
      if (displayChildInvest && CodesTables.CCHRTCAT_CME.equals(category)) {
        list.add(characteristic);
      }
      if (displayChildInvest && CodesTables.CCHRTCAT_OTH.equals(category)) {
        list.add(characteristic);
      }
      if (displayParent && CodesTables.CCHRTCAT_CCT.equals(category)) {
        list.add(characteristic);
      }
      /*
       * if (displayChildPlacement && CodesTables.CCHRTCAT_CPL.equals(category)) { list.add(characteristic); }
       */
    }

    state.setAttribute(CHARACTERISTICS, list, request);
    request.setAttribute("updateDate", updateDate);
  }

  /**
   * Save Person Detail <p/> This method is used for saving the Detail information on the Person Detail page. It calls
   * the populateCINV05SI helper method to populate the input object for the call to service CINV05S. After the save is
   * finished it re-sets the ID person into Global Data.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void savePersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePersonDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    PersonHelper.setBIndRelate(request, ArchitectureConstants.N);
    CINV05SO cinv05so = new CINV05SO();
    try {
      CINV05SI cinv05si = populateCINV05SI_AU(context);
      /*
       * String outputXml = ServiceHelper.callService("CINV05S", cinv05si); CINV05SO cinv05so = CINV05SO.unmarshal(new
       * StringReader(outputXml));
       */
      
      // STGAP00017013: MR-095
      // Indicator to be sent to JSP for indicating a sucessful save was made or not
      String isSaveSuccessful = "false";
      // End STGAP00017013: MR-095
      
      cinv05so = person.savePersonDetail(cinv05si);
      
      // MR-075 Sync FA Person Detail data if person had been related or added 
      // or that CM had modified Resource HH Member checkbox
      common.syncFaPersonDetailHealthDetail(cinv05si.getUlIdPerson());
      common.syncFaPersonDetailRecordsCheck(cinv05si.getUlIdPerson());
      
      request.setAttribute("CINV05SO", cinv05so);
      GlobalData.setUlIdPerson(cinv05so.getUlIdPerson(), request);
      //SMS 56827 MR-066 If the indicator is Y then set the errorcode and return from the conversation
      if(ArchitectureConstants.Y.equals(cinv05so.getBIndDuplicatePerson())){
        setPresentationBranch("stay", context);
        request.setAttribute("errorCode", Messages.MSG_DUPLICATE_NOT_ALLOWED);
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        return;
      }
            
      // STGAP00017013: MR-095
      // Set indicator isSaveSuccessful to true after the save
      isSaveSuccessful = "true";
      request.setAttribute("isSaveSuccessful", isSaveSuccessful);
      // End STGAP00017013: MR-095
      
      //MR-072 If a person is added or related to the case via stage context then navigate to the Records Check List page
      if(ArchitectureConstants.Y.equals(cinv05si.getBIndRecordsCheckNav()) && GlobalData.getUlIdStage(request) != 0 
         && (((CodesTables.CSTAGES_INV.equals(cinv05so.getSzCdStage()) || CodesTables.CSTAGES_DIV.equals(cinv05so.getSzCdStage()) || 
                         CodesTables.CSTAGES_FPR.equals(cinv05so.getSzCdStage()) || CodesTables.CSTAGES_SUB.equals(cinv05so.getSzCdStage()) ||
                         CodesTables.CSTAGES_FSU.equals(cinv05so.getSzCdStage())) &&(( CodesTables.CPRSNTYP_PRN.equals(cinv05si.getSzCdStagePersType())) || 
                   (cinv05si.getCdPKHouseholdMember() != null && CodesTables.CMBRPCHH_Y.equals(cinv05si.getCdPKHouseholdMember())))) ||
                   (CodesTables.CSTAGES_FAD.equals(cinv05so.getSzCdStage())&& (CodesTables.CPRSNTYP_PRN.equals(cinv05si.getSzCdStagePersType()) ||
                    (cinv05si.getBIndRsrcHouseholdMember() != null && ArchitectureConstants.Y.equals(cinv05si.getBIndRsrcHouseholdMember()))))                      
            )
         ){
        forward("/person/RecordsCheck/displayRecordsCheckList?taskCD=NULL", request, context.getResponse());
      }
      
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
        errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;

      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_CASA_GAL_ASSIGN_DATE_REQ:
      case Messages.MSG_CASA_GAL_INC_DATES:
      case Messages.MSG_CASA_GAL_DATE_ASSIGNED_UNASSIGNED:
      case Messages.MSG_ASSIGN_UNASSIGN_DATE_FUTURE:          
      // STGAP00017013: MR-095
      case Messages.MSG_ERR_TYPE_AND_REL_REQ:  
      // SIR 19549 This message is thrown by the service but wasn't being caught
      case Messages.MSG_NO_ROWS_RETURNED:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      // STGAP00017013: MR-095
      case Messages.MSG_INT_PK_EXIST:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break; 

      case Messages.MSG_RELATHIONSHIP_SELF_EXIST:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;
      // End STGAP00017013: MR-095
        
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (PopulationException pe) {
      this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      String errorMessage = MessageLookup.getMessageByName("MSG_ERR_BAD_FUNC_CD");
      setErrorMessage(errorMessage, DISPLAY_PERSON_DETAIL, context.getRequest());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Delete Person Detail <p/> This Method is used for deleting the person information either A. from the stage or B.
   * from the system if the person does not exist in any other Stage or Case in the system. It calls the
   * populateCINV05SI_D helper method for populating the input object for CINV05S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void deletePersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deletePersonDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    try {
      CINV05SI cinv05si = populateCINV05SI_D(context);
      // String outputXml = ServiceHelper.callService("CINV05S", cinv05si);
      // CINV05SO cinv05so = CINV05SO.unmarshal(new StringReader(outputXml));

      CINV05SO cinv05so = person.savePersonDetail(cinv05si);
      request.setAttribute("CINV05SO", cinv05so);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.SQL_NOT_FOUND:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, context.getRequest());
        break;
      case Messages.MSG_CASA_GAL_ASSIGN_DATE_DELETE:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Delete Income and Resources <p/> This method is used to Delete an Income and Resource Row from the List on Person
   * Detail. It can be called from either the Person Detail page, or from an Income and Resources Detail page. It calls
   * the populateCCFC30SI_D helper method to populate the Input Structure for the call to CCFC30S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void deleteIncRsrc_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteIncRsrcList_xa()");
    performanceTrace.enterScope();
    try {
      // Populates CCFC30SI for deleting the income and resource row
      CCFC30SI ccfc30si = populateCCFC30SI_D(context);
      // Call the Income and Resources Save Service
      /*
       * String outputXml = ServiceHelper.callService("CCFC30S", ccfc30si); CCFC30SO ccfc30so = CCFC30SO.unmarshal(new
       * StringReader(outputXml));
       */
      CCFC30SO ccfc30so = person.saveIncomeAndResources(ccfc30si);
      // Put Information from the save service into the request
      request.setAttribute("CCFC30SO", ccfc30so);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
        errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;

      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CFC_SAME_TYPE_INC:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Delete Education <p/> This method is used to Delete an Education Row from the List on Person Detail. It can be
   * called from either the Person Detail page, or from an Education Detail page. It calls the populateCCFC18SI_D helper
   * method to populate the Input Structure for the call to CCFC18S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void deleteEducation_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteEducationList_xa()");
    performanceTrace.enterScope();

    try {
      CCFC18SI ccfc18si = populateCCFC18SI_D(context);
      /*
       * String outputXml = ServiceHelper.callService("CCFC18S", ccfc18si); CCFC18SO ccfc18so = CCFC18SO.unmarshal(new
       * StringReader(outputXml));
       */
      CCFC18SO ccfc18so = person.audEducationalHistory(ccfc18si);
      request.setAttribute("CCFC18SO", ccfc18so);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
        errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;

      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Save FA Home <p/> This method is used to save the detail information entered on the FA Home page. It calls the
   * populateCFAD33SI_AU helper method to populate the input object for the service CFAD33S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void saveFAHome_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFAHome_xa()");
    performanceTrace.enterScope();
    try {
      CFAD33SI cfad33si = populateCFAD33SI_AU(context);
      // Call savePreservice service for Release 2.
      person.savePreservice(cfad33si);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
        errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;

      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Save Education <p/> This method is used to save the detail information entered on the Education page. It calls the
   * populateCCFC18SI_AU helper method to populate the input object for the service CCFC18S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void saveEducation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveEducation_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {

      String pageName;
      if (state.getAttribute("pageName", request) == null) {
        pageName = ContextHelper.getStringSafe(request, "pageName");
      } else {
        pageName = (String) state.getAttribute("pageName", request);
      }

      // state.setAttribute("pageName", "ChildPlan", request);

      CCFC18SI ccfc18si = populateCCFC18SI_AU(context);
      person.audEducationalHistory(ccfc18si);
      if ("ChildPlan".equals(pageName)) {
        state.setAttribute("resultPageName", "EducationDetail", request);
        setPresentationBranch("CHILD_PLAN_DETAIL", context);
        // STGAP00005609 - Child Plan SO needs to be set back to state before control transferred to Save service
        // It may not neccessary 
        ChildPlanDetailRetrieveSO childPlanDetailRetrieveSO = (ChildPlanDetailRetrieveSO) state
                                                                                               .getAttribute(
                                                                                                             "ChildPlanDetailRetrieveSO",
                                                                                                             request);
        state.setAttribute("ChildPlanDetailRetrieveSO", childPlanDetailRetrieveSO, request);
        // end STGAP00005609
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
        errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;

      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Save Income and Resources <p/> This method is used to save the detail information entered on the Income and
   * Resources page. It calls the populateCCFC30SI_AU helper method to populate the input object for the service
   * CCFC30S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void saveIncRsrc_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveIncRsrc_xa()");
    performanceTrace.enterScope();
    try {
      CCFC30SI ccfc30si = populateCCFC30SI_AU(context);
      person.saveIncomeAndResources(ccfc30si);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
        errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CFC_SAME_TYPE_INC:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Delete FA HOme <p/> This method is used to Delete a FA Home Row from the List on Person Detail. It can be called
   * from either the Person Detail page, or from an FA Home Detail page. It calls the populateCFAD33SI_D helper method
   * to populate the Input Structure for the call to CFAD33S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void deleteFAHome_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteFAHome_xa()");
    performanceTrace.enterScope();

    try {
      CFAD33SI cfad33si = populateCFAD33SI_D(context);
      // String outputXml = ServiceHelper.callService("CFAD33S", cfad33si);
      // CFAD33SO cfad33so = CFAD33SO.unmarshal(new StringReader(outputXml));
      CFAD33SO cfad33so = person.savePreservice(cfad33si);

      request.setAttribute("CFAD33SO", cfad33so);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
        errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;

      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Save Person Char <p/> This method is used to save the detail information entered on the Person Characteristics
   * page. It calls the populateCINV34SI_AU helper method to populate the input object for the service CINV34S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void savePersonChar_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePersonChar_xa()");
    performanceTrace.enterScope();

    try {
      CINV34SI cinv34si = populateCINV34SI_AU(context);
      person.savePersonCharacteristics(cinv34si);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
        errorCode = Messages.MSG_CMN_TMSTAMP_MISMATCH;

      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_MULT_INST:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  public static boolean displayChildPlacementCharacteristics(HttpServletRequest request) {
    return ((isCPS(request)) || (isNonStageContext(request)));
  }

  protected static boolean isCPS(HttpServletRequest request) {
    return "CPS".equals(GlobalData.getSzCdStageProgram(request));
  }

  protected static boolean isRCL(HttpServletRequest request) {
    return "RCL".equals(GlobalData.getSzCdStageProgram(request));
  }

  protected static boolean isCCL(HttpServletRequest request) {
    return "CCL".equals(GlobalData.getSzCdStageProgram(request));
  }

  protected static boolean isAFC(HttpServletRequest request) {
    return "AFC".equals(GlobalData.getSzCdStageProgram(request));
  }

  protected static boolean isAPS(HttpServletRequest request) {
    return "APS".equals(GlobalData.getSzCdStageProgram(request));
  }

  protected static boolean isNonStageContext(HttpServletRequest request) {
    // SIR 16918 Changed check of Calling page being person search to if
    // ulIdStage is 0,
    // if ulIdStage is 0 we are definitely not in a Case Context.
    // Else if the ulIDStage is 0, and the page mode is view or maintain person
    // set a page set
    return ((GlobalData.getUlIdStage(request) == 0) && ((PageModeConstants.VIEW
                                                                                                      .equals(PersonHelper.getPersonDetailPageMode(request))) || (WINDOW_MODE_MNTN_PERSON
                                                                                                                                                                                        .equals(PersonHelper.getPersonDetailPageMode(request)))));
  }

  public static int getAge(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);

    // Matthew McClain, I hate duplicating this code from person detail.jsp
    // But I can't think of another way ...
    // (The custom validation handling doesn't play nicely with logic in the
    // conversation)
    int age = cinv04so.getLNbrPersonAge();
    org.exolab.castor.types.Date birth = cinv04so.getDtDtPersonBirth();
    if (birth != null) {
      age = DateHelper.getAge(birth);
    }
    return age;
  }

  /**
   * Display Person Detail <p/> This method is used to display the entire person detail page. First, it calls the
   * setPersonDetailPage helper method to determine the current set of the Person Detail page. It then calls the
   * populateCINV04SI Helper method to retrieve the detail information on the Person Detail page. It then proceeds to
   * call the following helper methods for displaying the lists on the page: <p/> 1. displayMergeSplitList 2.
   * displayIncRsrcList 3. displayEducationList 4. displayFAHomeList 5. displayCharList
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  @SuppressWarnings( { "unchecked" })
  public void displayPersonDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonDetail_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      UserProfile user = UserProfileHelper.getUserProfile(request);

      // Clear State and then reset the Person Helper pagemode
      clearState(context);

      boolean btnRelate = ContextHelper.getIntSafe(request, "btnRelateToCase.x") != 0;

      PersonHelper.setPersonDetailPageMode(request, PersonHelper.getPersonDetailPageMode(request));

      // If the employee indicators are set, re-set them here
      PersonHelper.setBIndActiveStatus(request, PersonHelper.getBIndActiveStatus(request));
      PersonHelper.setBSysIndViewPersonInfo(request, PersonHelper.getBSysIndViewPersonInfo(request));

      // If the page mode is New, reset it to Modify for re-displaying the page.
      if (PageModeConstants.NEW.equals(PersonHelper.getPersonDetailPageMode(request))) {
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.MODIFY);
      }

      // SIR 19525 If btnRelate is in the request, set the indicator that we are
      // relating
      // to "Y", this indicator will not be cleared until the person detail page
      // is saved
      // so that when the user navigates to other areas/adds detail information
      // and then
      // tries to save the person detail page, the page mode will not be changed
      if (btnRelate) {
        PersonHelper.setBIndRelate(request, ArchitectureConstants.Y);
      }

      // SIR 19230 if the page mode is relate, and the relate pushbutton was not
      // the last one to be pushed
      // change the mode to modify.
      if (ArchitectureConstants.N.equals(PersonHelper.getBIndRelate(request))
          && WINDOW_MODE_RELATE.equals(PersonHelper.getPersonDetailPageMode(request))) {
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.MODIFY);
      }

      // Set the Page Mode set for this page
      setPersonDetailPageSet(context);

      // temp - needs to be removed
      // Sets.setPageSet(Sets.A, request);

      if (Sets.isInSet(Sets.E, request)) {
        setInformationalMessage(Messages.MSG_SEARCH_EMPLOYEE, request);
      }

      CINV04SI cinv04si = populateCINV04SI_Retrieve(context);
      CINV04SO cinv04so = person.retrievePersonDetail(cinv04si);

      // SIR 19420 - Check the IndBLOBExistsInDatabase_ARRAY to verify the Child Death
      // report exists. The Child Death report exists at the first row in the array (0).
      // Then pass initChildDeathIndex through the request to the JSP.
      String initChildDeathIndex = cinv04so.getBIndBLOBExistsInDatabase_ARRAY().getBIndBLOBExistsInDatabase(0);

      request.setAttribute("initChildDeathIndex", initChildDeathIndex);

      // SIR 19420 - Check the IndBLOBExistsInDatabase_ARRAY to verify the Child Death Committe
      // report exists. The Child Death Committe report exists at the second row in the array (1).
      // Then pass childDeathCommitteIndex through the request to the JSP.
      String childDeathCommitteIndex = cinv04so.getBIndBLOBExistsInDatabase_ARRAY().getBIndBLOBExistsInDatabase(1);

      request.setAttribute("childDeathCommitteIndex", childDeathCommitteIndex);

      // SIR 19072--On the Person Search a user can enter the Person Detail page one
      // of two ways. The first method being to select a radio button and then click ont the relate push
      // button. The MSG_INV_IN_STAGE message should be thrown when a user attempts to
      // enter the person detail via the radio button. The second way to enter the
      // person detail page is the match name hyperlink. The MSG_INV_IN_STAGE message should
      // NOT be thrown when a user attempts to enter the page via the match hyperlink. Added the
      // btnRelate boolean to the if statement.

      // If we are coming from person search,
      // check to see if anything is returned from the service in the stage
      // person link. If the bSysIndInStage is true, that means the
      // person is already related to the stage.
      if (PERSON_SEARCH_CALLED.equals(ContextHelper.getPreviousUrl(context))
          && (ArchitectureConstants.Y.equals(cinv04so.getBSysIndInStage())) && btnRelate) {

        String errorMessage;
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_IN_STAGE);
        displayMessagePage(errorMessage, context);
      }

      // Create Race Ethnicity Bean and put on request for use by submodule.
      RaceEthnicityBean reBean = new RaceEthnicityBean();
      XmlValueBean raceList = cinv04so.getCINV04SOG03_ARRAY();
      XmlValueBean ethnicityList = cinv04so.getCINV04SOG04_ARRAY();
      reBean.setEthnicity(ethnicityList);
      reBean.setRaces(raceList);
      RaceEthnicityHelper.addToRequest(reBean, request);

      // This will set relationship information into a List for displaying on the jsp.
      List relationshipList = new ArrayList();
      CINV04SO_OTHER_RELATIONSHIP_ARRAY otherRelatonshipAray = cinv04so.getCINV04SO_OTHER_RELATIONSHIP_ARRAY();
      CINV04SO_OTHER_RELATIONSHIP rowOtherRelationship;

      // ?bug
      if (otherRelatonshipAray != null) {
        Enumeration rowEnumerationOtherRelationship = otherRelatonshipAray.enumerateCINV04SO_OTHER_RELATIONSHIP();
        while (rowEnumerationOtherRelationship.hasMoreElements()) {
          rowOtherRelationship = (CINV04SO_OTHER_RELATIONSHIP) rowEnumerationOtherRelationship.nextElement();
          if (rowOtherRelationship.getSzCdStagePersRelInt() != null) {
             relationshipList.add(new Option(String.valueOf(rowOtherRelationship.getUlIdPerson()),
                                          rowOtherRelationship.getSzNmPersonFull() + " - " + 
                                          Lookup.simpleDecodeSafe(CodesTables.CRELVICT,rowOtherRelationship.getSzCdStagePersRelInt())));
          }else{
            relationshipList.add(new Option(String.valueOf(rowOtherRelationship.getUlIdPerson()),
                                            rowOtherRelationship.getSzNmPersonFull()));           
          }
        }
      }
      
      //STGAP00015485:  This will set relationship information into a List of Mothers.
      List motherRelationshipList = new ArrayList();
      CINV04SO_MOTHER_RELATIONSHIP_ARRAY motherRelationshipArray = cinv04so.getCINV04SO_MOTHER_RELATIONSHIP_ARRAY();
      CINV04SO_MOTHER_RELATIONSHIP rowMotherRelationship;

      // ?bug
      if (motherRelationshipArray != null) {
        Enumeration rowEnumerationMotherRelationship = motherRelationshipArray.enumerateCINV04SO_MOTHER_RELATIONSHIP();
        while (rowEnumerationMotherRelationship.hasMoreElements()) {
          rowMotherRelationship = (CINV04SO_MOTHER_RELATIONSHIP) rowEnumerationMotherRelationship.nextElement();
          if (rowMotherRelationship.getSzCdStagePersRelInt() != null){
            motherRelationshipList.add(new Option(String.valueOf(rowMotherRelationship.getUlIdPerson()),
                                                rowMotherRelationship.getSzNmPersonFull() + " - " + 
                                                Lookup.simpleDecodeSafe(CodesTables.CRELVICT,rowMotherRelationship.getSzCdStagePersRelInt())));
          }else{
            motherRelationshipList.add(new Option(String.valueOf(rowMotherRelationship.getUlIdPerson()),
                                                  rowMotherRelationship.getSzNmPersonFull()));            
          }
        }
      }
      
      //STGAP00015485:  This will set relationship information into a List of Fathers.
      List fatherRelationshipList = new ArrayList();
      CINV04SO_FATHER_RELATIONSHIP_ARRAY fatherRelationshipArray = cinv04so.getCINV04SO_FATHER_RELATIONSHIP_ARRAY();
      CINV04SO_FATHER_RELATIONSHIP rowFatherRelationship;

      // ?bug
      if (fatherRelationshipArray != null) {
        Enumeration rowEnumerationFatherRelationship = fatherRelationshipArray.enumerateCINV04SO_FATHER_RELATIONSHIP();
        while (rowEnumerationFatherRelationship.hasMoreElements()) {
          rowFatherRelationship = (CINV04SO_FATHER_RELATIONSHIP) rowEnumerationFatherRelationship.nextElement();
          if (rowFatherRelationship.getSzCdStagePersRelInt() != null){
            fatherRelationshipList.add(new Option(String.valueOf(rowFatherRelationship.getUlIdPerson()),
                                                rowFatherRelationship.getSzNmPersonFull() + " - " + 
                                                Lookup.simpleDecodeSafe(CodesTables.CRELVICT,rowFatherRelationship.getSzCdStagePersRelInt())));
          }else{
            fatherRelationshipList.add(new Option(String.valueOf(rowFatherRelationship.getUlIdPerson()),
                                                  rowFatherRelationship.getSzNmPersonFull()));        
          }
        }
      }

      state.setAttribute("relationshipList", relationshipList, request);
      state.setAttribute("motherRelationshipList", motherRelationshipList, request);
      state.setAttribute("fatherRelationshipList", fatherRelationshipList, request);
      state.setAttribute("CINV04SO", cinv04so, request);

      // SIR 18786 GRIMSHAN The events DAM brings back all the events associated
      // with the person
      // across all stages. This list of events will be used to determine if a
      // person
      // can be deleted from the stage, or if their type can be changed.
      // IF the Stage is Investigation, a person cannot be deleted
      // if they have ANY events for the stage we are currently in. For all
      // others stages,
      // a person cannot be deleted if they have any events with a status
      // of approved.

      String bIndActiveEvent = ArchitectureConstants.N;
      Set excludeViews = new HashSet(Lookup.getCategoryCodesCollection(CodesTables.CPERVIEW));
      CINV04SG02_ARRAY rowArray = cinv04so.getCINV04SG02_ARRAY();
      if (rowArray != null) { // van's test
        CINV04SG02 row;
        Enumeration rowEnumeration = rowArray.enumerateCINV04SG02();
        // SIR 22890 - Exclude Views excludes things to display in the Options
        // Drop down. It is initialized
        // to all items in the codes table. If the user is not restricted from
        // viewing case events,
        // Remove "View Person Events" from the exclude
        // Set excludeViews = new HashSet(Lookup.getCategoryCodesCollection(CodesTables.CPERVIEW));
        if (!user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
          excludeViews.remove(CodesTables.CPERVIEW_VPE);
        }
//STGAP00007002 - AR Fix for ability to view case list for unrestricted viewers
        // Similarly Exclude Views excludes things to display in the Options
        // Drop down. It is initialized
        // to all items in the codes table. To do that we must
        // remove "View Case List" from the exclude Views in order to show it as an option.
        // Set excludeViews = new HashSet(Lookup.getCategoryCodesCollection(CodesTables.CPERVIEW));
        if (!user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
          excludeViews.remove(CodesTables.CPERVIEW_VCL);
        }

        while (rowEnumeration.hasMoreElements()) {
          row = (CINV04SG02) rowEnumeration.nextElement();
          if ("INV".equals(GlobalData.getSzCdStage(request))) {
            if (row.getUlIdStage() == GlobalData.getUlIdStage(request)) {
              bIndActiveEvent = ArchitectureConstants.Y;
            }
          } else if (row.getUlIdStage() == GlobalData.getUlIdStage(request) && "APRV".equals(row.getSzCdEventStatus())) {
            bIndActiveEvent = ArchitectureConstants.Y;
          }

          // The Remove statement removes items from the exclude views (thus they
          // will be displayed) If
          // the person has the SEC_RESTRICT_CASE_EVENT security attribute, we
          // want to exclude
          // all of the Event options, so don't remove any options. If the event
          // view exists in the array, we want to remove
          // it from the exclude options so it will be displayed in the view
          // options drop down on the JSP.
          if (!user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
            String szCdEventType = row.getSzCdEventType();
            if (excludeViews.contains(szCdEventType)) {
              excludeViews.remove(szCdEventType);
            }
          }
        }
      } // van's test
      // Set exlude views into state for Person Detail outside of the loop so
      // that
      // even if there are no rows in the array from the service it will not be
      // null
      request.setAttribute("excludeViews", excludeViews);
      state.setAttribute("bIndActiveEvent", bIndActiveEvent, request);

      CINV04SG02_ARRAY blankArray = new CINV04SG02_ARRAY();

      cinv04so.setCINV04SG02_ARRAY(blankArray);

      request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);

      // Set szNmPersonFull into global data so it can be displayed in the
      // information box
      GlobalData.setSzNmPersonFull(cinv04so.getSzNmPersonFull(), request);
      // Set Stage Person Role into Person Helper so that if the user clicks on
      // CVS/FA Home tab
      // it will be available.
      PersonHelper.setSzCdStagePersRole(request, cinv04so.getSzCdStagePersRole());
      // SIR 22935 Set Stage Person Type into Person Helper so that the Records
      // Check page will know
      // the type
      PersonHelper.setSzCdStagePersType(request, cinv04so.getSzCdStagePersType());
      
      //STGAP00004037 - Set the Attribute to false if there is a relationship
      if(cinv04so.getSzCdStagePersRelInt() != null){
        state.setAttribute("updateRelationship", "false", request);
      }

      displayMergeSplitList(context);

      displayIncRsrcList(context);

      displayEducationList(context);

      displayFAHomeList(context);

      displayCharList(context);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  /**
   * Added by Srinivas for adding a record into Income_resource_outbound table
   * when User select the request success data button
   * @param context
   */
  public void getIncRsrcDtl_xa(GrndsExchangeContext context) {
    
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getIncRsrcDtl_xa");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    
    
    try {
      
       Date dtLastUpdate= new Date();
       UserProfile userProfile = UserProfileHelper.getUserProfile(request);
       int userId = userProfile.getUserID();
       Date dtMedRequested = new Date();
       int idPerson = GlobalData.getUlIdPerson(request);
       
       IncomeResourceOutboundSI incomeResourceOutboundSI = new IncomeResourceOutboundSI();
       incomeResourceOutboundSI.setDtLastUpdate(dtLastUpdate);
       incomeResourceOutboundSI.setInterfaceStatus(INTERFACE_STATUS);
       incomeResourceOutboundSI.setUserId(userId);
       incomeResourceOutboundSI.setDtMedRequested(dtMedRequested);
       incomeResourceOutboundSI.setCdTargetSystem(CD_TARGET_SYSTEM);
       incomeResourceOutboundSI.setIdInitiator(userId);
       incomeResourceOutboundSI.setIdPerson(idPerson);
       incomeResourceOutboundSI.setCdReqIdent(CD_REQ_IDENT);
       
       int id = person.saveIncomeResourceOutbound(incomeResourceOutboundSI);
       if(id != 0)
          setPopUpMessage("Request Submitted ", context.getRequest());
                
       forward(PREVIOUS_URI_PERSON_DETAIL, context.getRequest(), context.getResponse());
      }catch (ServiceException we) {
        int errorCode = we.getErrorCode();
        switch (errorCode) {
         case Messages.MSG_CRS_ID_NOT_FND:
              setErrorMessage(errorCode, context.getRequest());
              break;
         default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
    
  }

  // STGAP00017013: MR-095
  /**
   * Setup the CINV05SI_ADD_PERSON_TO_STAGES_ARRAY object for the CINV05SI input object
   * 
   * @param request: the page request
   * @param cinv04so: the output from the CINV05SI service
   * @return the newly constructed array object
   */
  private CINV05SI_ADD_PERSON_TO_STAGES_ARRAY createAddPersonToStagesArray(HttpServletRequest request, CINV04SO cinv04so) {
    // Allocate the new array
    CINV05SI_ADD_PERSON_TO_STAGES_ARRAY cinv05si_add_person_to_stages_array = new CINV05SI_ADD_PERSON_TO_STAGES_ARRAY();

    // Get the CINV05SI_ADD_PERSON_TO_STAGES_ARRAY returned from CINV04SO
    CINV04SO_ADD_PERSON_TO_STAGES_ARRAY cinv04so_add_person_to_stages_array = cinv04so.getCINV04SO_ADD_PERSON_TO_STAGES_ARRAY();
    int rowCount = 0;
    int i = 0;

    if (cinv04so_add_person_to_stages_array != null) {
      Enumeration cinv04so_add_person_to_stagesEnumeration = cinv04so_add_person_to_stages_array.enumerateCINV04SO_ADD_PERSON_TO_STAGES();
      while (cinv04so_add_person_to_stagesEnumeration.hasMoreElements()) {
        CINV04SO_ADD_PERSON_TO_STAGES cinv04so_add_person_to_stages;        
        cinv04so_add_person_to_stages = (CINV04SO_ADD_PERSON_TO_STAGES) cinv04so_add_person_to_stagesEnumeration.nextElement();
        
        boolean stageChecked = IND_YES.equals(
                CheckboxHelper.getCheckboxValue(request, "cbxName_" + ( i + 1 )));
        String selSzCdStagePersTypeAddPerson = ContextHelper.getStringSafe(request, "selSzCdStagePersTypeAddPerson_" + ( i + 1 ));
        String selSzCdStagePersRelIntHistory = ContextHelper.getStringSafe(request, "selSzCdStagePersRelIntHistory_" + ( i + 1 ));

        Boolean indicator = (stageChecked
                             && (selSzCdStagePersTypeAddPerson != null && !"".equals(selSzCdStagePersTypeAddPerson)) && (selSzCdStagePersRelIntHistory != null && !""
                                                                                                                                                                     .equals(selSzCdStagePersRelIntHistory))) ? true
                                                                                                                                                                                                             : false;

        // if we have selected the checkbox for that person, create a save action in the ROWCSUB49SOG00_ARRAY
        if (indicator) {
          rowCount++;
          CINV05SI_ADD_PERSON_TO_STAGES cinv05si_add_person_to_stages = new CINV05SI_ADD_PERSON_TO_STAGES();
          cinv05si_add_person_to_stages.setUlIdStage(cinv04so_add_person_to_stages.getUlIdStage());
          cinv05si_add_person_to_stages.setSzCdStagePersType(selSzCdStagePersTypeAddPerson);
          cinv05si_add_person_to_stages.setSzCdStagePersRelInt(selSzCdStagePersRelIntHistory);
          // Set dtAdded as the system date when the person is added to the stage
          cinv05si_add_person_to_stages.setDtDtAdded(DateHelper.getTodayCastorDate());
          cinv05si_add_person_to_stages_array.addCINV05SI_ADD_PERSON_TO_STAGES(cinv05si_add_person_to_stages);
        }
        i++;
      }
    }

    // set the size of the array to the row count
    cinv05si_add_person_to_stages_array.setUlRowQty(rowCount);

    // return the new array object
    return cinv05si_add_person_to_stages_array;
  }  
}
