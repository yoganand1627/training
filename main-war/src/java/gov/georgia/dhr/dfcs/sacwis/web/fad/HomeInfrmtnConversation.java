package gov.georgia.dhr.dfcs.sacwis.web.fad;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
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
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateAndPostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.AdoExchange;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.common.EventUtility;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.InvalidateApprovalSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG05;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG06;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveFAHomeSupervisorSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD36SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper.ObjectActionCodePair;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.AssignConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

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
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to view and maintain the Home Information for an F/A Home
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  01/03/03    DEANH     Initial Development
 *  05/10/2003  KRD       SIR 17233 - Code changes applied to support
 *                        &quot;Approver Mode&quot; providing supervisors the ability to
 *                        modify data without invalidating the pending
 *                        approval.  Required changes to populateCFAD36SI_U().
 *  06/02/2003  DEANH     SIR  17901 - Added a call to SchoolDistrictList to handle
 *                        population of school district dropdown on display of page.
 *  06/06/03    GRIMSHAN  SIR 16979 - Retrieve page mode from event search conversation
 *                        if the page mode does not need to be changed, it will not be
 *  07/21/03    Dickmaec  SIR 19033 -- Saves txtHomeName to upper case.
 *  08/12/03    CASDORJM  SIR 19309 et al - Modified conversation to set event status
 *                        correctly.  Also updated conversation for maintainability.
 *  03/25/2004  ochumd    Sir 22800 - Code changes applied to support county change. Users
 *                        can now change counties in any order of choice.
 *  04/22/2004  gerryc    SIR 14700 - set indicator to write history record if the
 *                        status, category, marital status or license info was changed.
 *  08/02/2004  reedlg    SIR 22972 - Modified parameter for IndRsrcPrsChg to evaluate correctly
 *                        in dam caud58d.
 *  10/19/2004  gerryc    SIR 23122 - in displayHomeInformation, added check for
 *                        event status = pending when showing MSG_FAD_CLOSE_PENDING
 *                        message.  if approval event was rejected (status =
 *                        complete), then don't show the message.
 *  11/18/04    reedlg    SIR 22684 - Phone not required for INQUIRY/CLOSED status.
 *                        Modify not to create phone unless phone number is populated.
 *                        Also fixing a problem found testing this SIR on delete phone
 *                        where current phone needs to be blanked out upon delete.
 *   03/18/05  Hadjimh    SIR#23327. Add a new field to the Home Information page. This new
 *                        field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
 *                        Adoptive Home checkbox is checked, staff will have to select a
 *                        'Certifying Entity'. to indicate the certifying agency
 *                        2) This will be a required field when the Non-FPS Adoptive Home
 *                        checkbox is checked for a home. 3) If a user is modifying an
 *                        existing Non-FPS Adoptive Home, this new field will be required,
 *                        unless the home status is also being changed to 'Pending Closure'
 *                        or 'Closed'.
 *  07/24/05    werlem     SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *  09/15/05    Hadjimh    SIR 23778 - add an edit that will only allow one Business.
 *  04/09/08    Cwells     STGAP00007365 Made changes to allow the save button to be used when the supervisor is apporving 	
 * 	                   a House that is pending closure
 * 
 * 
 *  7/7/08      Cwells     STGAP00006198 When Invalidating an approval. I have created a service to do the 
 *                         do the invalidation as well as the post event so if the post event fails then both 
 *                          will be rolled back.  This way the event statuses will be in synch. 
 *  07/03/08    mchillman Added a code to display exchange home detail tab
 *  11/18/08    wjcochran  STGAP00011220 Added a method to display foster home conversion tab
 *  11/26/08    alwillims  STGAP00009881: Use the pending event to invalidate the approval instead of the current event. 
 *                         The current event is in Global Data. The pending event is in the CFAD07SO structure.
 *  02/15/09    vdevarak   STGAP00012476: Made necessary code changes to retrieve and save the new date field 'Date Applied'
 *                         added to the inquiry section on the Home Info page.   
 *                                           
 *  06/25/2009  hjbaptiste STGAP00013543: If the Home Name changes, update the Stage and Case Name to the updated name     
 *  
 *  07/24/2009  cwells     STGAP00013771: Displaying error message if user tries to close a home with open placements. 
 *  09/24/2009  arege      STGAP00012363: Added new options in getRestrictedStatusListFor() so that the Status dropdown 
 *                         on home information has the values of PSA, PTA, PFA and PCL. 
 * 10/30/2009   cwells     37312 - Added service to check to see if home has active placements before allowing the home to 
 *                         to be closed.   
 * 11/05/2009   cwells     37273 - When coming from the event list page of a fad stage we are displaying the current 
 *                         FA home status when clicking on the hyperlink.           
 * 05/24/2010   arege      SMS#42496: Added code to handle service exception MSG_CONFIRM_STAGE_EVENTS_DELETE
 * 05/27/2010   wcochran   MR-066: Added check to see if a home exists with the same name or address as the 
 *                         home that is being saved.
 * 11/22/2010   schoi      SMS #81140: MR-074 Added code to validate Marital Status, Relationship and Gender 
 *                         in the Person Detail information with the F/A Home’s Marital Status on submission for approval 
 * 12/04/2010   schoi      SMS #81140: MR-074 Updated code to check Marital Status match with Person Detail record
 *                         when the Home Information is submitted and supervisor clicks Approval Status button  
 * 01/04/2010   schoi      SMS #81140: MR-074 Updated return value in checkIfMaritalStatusInconsistent method 
 *                         per outstanding peer review item (minor) and removed unnecessary import statement                                                                   
 * 02/23/2011   hnguyen    SMS #97850: MR-075 Added new Home statuses. And removed Temporary status options.                                                                   
 * 03/20/2011   hnguyen    SMS#97850: MR-075 Updated logic to allow save in approval mode.
 * 03/21/2011   hnguyen    SMS#97850: MR-075 Corrected coded to write history on every submit.
 * 03/22/2011   hnguyen    SMS#97850: MR-075 Removed code that sets resource status on save or submit.
 * 04/11/2011   hnguyen    SMS#105126: MR-075 Updated xa for save/delete phone and address to set new event id in GlobalData
 *                         if call to saveHomeDemographic invalidates current pending event and new event is created.
 * 04/12/2011   hnguyen    SMS#97850: MR-075 Updated approval event description to better clarify which home status approval.
 * 04/14/2011   hnguyen    SMS#97850: MR-075 Updated CFAD08SI indicator for approval mode to correctly invalidate event when appropriate.
 * 04/26/2011   hnguyen    SMS#97850: MR-075 Fixed production defect that affect enhancement changes.
 *                         Change in Approval dates are considered a license change, therefore should triggered as so.
 * 08/24/2011   hnguyen    STGAP00017009: Corrected logic that determines license change due to Approval Date 
 *                         change to allow save of approval end date consequently calculating NCIC and GCIC records
 *                         checks due date correctly.
 * 09/12/2011   charden    STGAP00017058 - adding code to make address detail page editable for fiscal ops users
 * </pre>
 */
@SuppressWarnings("serial")
public class HomeInfrmtnConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "HomeInfrmtnConversation";

  public static final String CODE_MARRIED = CodesTables.CFAMSTRC_01;

  public static final String CODE_BASIC = CodesTables.CFAHMTYP_BAS;

  public static final String CODE_EMERGENCY = CodesTables.CFAHMTYP_EMG;

  public static final String CODE_MEDICALLY_FRAGILE = CodesTables.CFAHMTYP_MED;

  public static final String CODE_RESPITE = CodesTables.CFAHMTYP_RES;

  public static final String CODE_SPEC_FOST_CARE = CodesTables.CFAHMTYP_SFC;

  public static final String CODE_THERAPEUTIC = CodesTables.CFAHMTYP_THR;

  public static final String CODE_HABILITATIVE = CodesTables.CFAHMTYP_H;

  public static final String CODE_PMN = CodesTables.CFAHMTYP_R;

  public static final String CODE_GROUP = CodesTables.CFAHMTYP_U;

  public static final String CODE_KIN_GP = CodesTables.CFAHMTYP_X;

  public static final String CODE_KIN_AU = CodesTables.CFAHMTYP_Y;

  public static final String CODE_KIN_OF = CodesTables.CFAHMTYP_Z;

  public static final String CODE_STATUS_INQUIRY = CodesTables.CFAHMSTA_INQ;

  public static final String CODE_STATUS_WAITLIST = CodesTables.CFAHMSTA_WTL;

  public static final String CODE_STATUS_APPLICANT = CodesTables.CFAHMSTA_APP;

  public static final String CODE_STATUS_PEND_FULL_APP = CodesTables.CFAHMSTA_PFA;

  public static final String CODE_STATUS_PEND_SPEC_APP = CodesTables.CFAHMSTA_PSA;

  public static final String CODE_STATUS_PEND_TEMP_APP = CodesTables.CFAHMSTA_PTA;

  public static final String CODE_STATUS_APPROVED_FULL_ACTIVE = CodesTables.CFAHMSTA_AFA;

  public static final String CODE_STATUS_APPROVED_SPEC_ACTIVE = CodesTables.CFAHMSTA_ASA;

  public static final String CODE_STATUS_APPROVED_TEMP_ACTIVE = CodesTables.CFAHMSTA_ATA;

  public static final String CODE_STATUS_CLOSED = CodesTables.CFAHMSTA_CSD;

  public static final String CODE_STATUS_PENDING_CLOSURE = CodesTables.CFAHMSTA_PCL;

  public static final String CODE_STATUS_PEND_FULL_APP_30_DAY = CodesTables.CFAHMSTA_PFG;

  public static final String CODE_STATUS_PEND_SPEC_APP_30_DAY = CodesTables.CFAHMSTA_PSG;

  public static final String CODE_STATUS_PEND_UNAPPROVE = CodesTables.CFAHMSTA_PUN;

  public static final String CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY = CodesTables.CFAHMSTA_FLG;

  public static final String CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY = CodesTables.CFAHMSTA_FSG;

  public static final String CODE_STATUS_UNAPPROVED = CodesTables.CFAHMSTA_AUN;

  public static final String CODE_ADOPTIVE = CodesTables.CFACATEG_A;

  public static final String CODE_FOSTER = CodesTables.CFACATEG_F;

  public static final String CODE_MRTL_STATUS_MARRIED = CodesTables.CFAMSTRC_01;

  public static final String CODE_ADDR_TYPE_PRIMARY = CodesTables.CRSCADDR_01;

  public static final String CODE_ADDR_TYPE_BUS = CodesTables.CRSCADDR_02;

  public static final String CODE_PHONE_TYPE_PRIMARY = CodesTables.CRSCPHON_01;

  public static final String MSG_DOC_INVALID = "Please SAVE the following before launching Home Study: Annual Income, Respite, Marital Status, Home Capacity";

  public static final String C_REQ_FUNC_CD_RETRIEVE = "R";

  public static final String C_REQ_FUNC_CD_RETRIEVE_HISTORICAL = "H";

  public static final String C_REQ_FUNC_CD_LIC_NEW = "1";

  // changed value to 4 from 2 to match mode
  // page mode constants in the PageModeConstants.java
  public static final String C_REQ_FUNC_CD_LIC_MODIFY = "4";

  public static final String C_REQ_FUNC_CD_LIC_HISTORY = "3";

  public static final int NUM_ROWS_PER_PAGE = 40;

  public static final int FAD_MAX_AGE_YR = 19;

  public static final int FAD_MIN_AGE_YR = 0;

  public static final int FAD_MAX_AGE_MO = 11;

  public static final int FAD_MIN_AGE_MO = 0;

  public static final String EVENT_DESCR_TEXT = "Non-Licensing Change Made";

  public static final String NEW_EVENT_DESCR_TEXT = "New Home Created.";

  public static final String TASK_APPROVE_HOME_CLOSURE = "8210";

  public static final String TASK_APPROVE_HOME_LICENSE = "8200";

  public static final String TASK_CLOSE_HOME = "8170";

  public static final String TASK_CHANGE_HOLD_PLACEMENTS = "8280";

  public static final String TASK_MNTN_LIC = "8020";

  public static final String TASK_MNTN_NON_LIC = "8010";

  public static final String TASK_REOPEN_HOME = "8030";

  public static final String EVENT_DESCR_HOME_CLOSED = "Home closed";

  public static final String EVENT_DESCR_HOME_PENDING_CLOSE = "Home submitted for closure";

  public static final String EVENT_DESCR_HOME_REOPEN = "Home re-opened with a status of ";

  public static final String LC_EVENT_DESCR_TEXT = "Licensing Change Made";

  public static final String STAT_CHG_EVENT_DESCR_TEXT_1 = "Changed home status to ";

  public static final String STAT_CHG_EVENT_DESCR_TEXT_2 = " & maintained licensing information.";

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;

  public static final String EVENT_STATUS_APRV = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_TYPE_HME = CodesTables.CEVNTTYP_HME;

  public static final String EVENT_TYPE_CLOSE = "CCL";

  public static final String IND_WRITE_HIST = ArchitectureConstants.Y;

  public static final String STATUS_ACTIVE = CodesTables.CRSCSTAT_01;

  public static final String STATUS_INACTIVE = CodesTables.CRSCSTAT_02;

  public static final String OUT_OF_STATE = "999";

  public static final String CAPS_UNIT_STATE_OFFICE = "99";

  public static final String FAD_DEFAULT_TIME = "12:00 AM";

  public static final String HIST_LITERAL_DATE = "date.";

  public static final String IND_YES = ArchitectureConstants.Y;

  public static final String IND_NO = ArchitectureConstants.N;

  public static final String RSRC_STAT_ACTIVE = CodesTables.CRSCSTAT_01;

  public static final String RSRC_STAT_INACTIVE = CodesTables.CRSCSTAT_02;

  public static final int NEXT = 1;

  public static final int CURRENT = 0;

  public static final String DISPLAY_URL = "/fad/HomeInfrmtn/displayInitHomeInformation";

  public static final String TXT_TS_LAST_UPDATE = "txtTsLastUpdate";

  public static final String IS_SUBMIT = "isSubmit";

  public static final String STR_CFAD08S = "CFAD08S";

  public static final String STR_CFAD07SO = "CFAD07SO";

  public static final String STR_CFAD30SO = "CFAD30SO";

  public static final String STR_HOMEAPPLICANTRETRIEVESO = "HomeApplicantRetrieveSO";

  public static final String STR_CFAD37SO = "CFAD37SO";

  public static final String CURRENT_PHONE = "currentPhone";

  public static final String CURRENT_ADDRESS = "currentAddress";

  public static final String ADDRESS_ARRAY_INDEX = "addressArrayIndex";

  public static final String STATUS_DROPDOWN = "selStatus";
  
  public static final String CLOSURE_RSN = "selClosureReason";

  public static final String STR_MSG_HOME_STUDY = MessageLookup.getMessageByNumber(Messages.MSG_FAD_HOME_STUDY_REQ);

  public static final String MSG_SAVE_BEFORE_CLOSE = MessageLookup.getMessageByNumber(Messages.MSG_SAVE_BEFORE_CLOSE);

  public static final String ADD_HOME_FLAG = "isAddHome";

  public static final String FAD = "FAD";

  public static final String CPS = "CPS";
  
  public static final String FISC_OPS_MAINT = "FISC_OPS_MAINT";
  
  public static final String IS_SAVE_NEW_HOME = "isSaveNewHome";

  private AdoExchange adoExchange;

  private EventUtility eventUtility;

  private InvalidateAndPostEvent invalidateAndPostEvent = null;

  private InvalidateApproval invalidateApproval = null;

  private PostEvent postEvent = null;

  private Resource resource;
  
  private Common common;
  
  public void setEventUtility(EventUtility eventUtility) {
    this.eventUtility = eventUtility;
  }
  
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setInvalidateAndPostEvent(InvalidateAndPostEvent invalidateAndPostEvent) {
    this.invalidateAndPostEvent = invalidateAndPostEvent;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }
  
  public void setAdoExchange(AdoExchange adoExchange) {
    this.adoExchange = adoExchange;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }

  /**
   * This method is called by GRNDS to clear state and initially display Home Info page an outer Initial display method
   * to handle clearing of state upon entering the conversation
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayInitHomeInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayInitHomeInformation_xa");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      state.removeAllAttributes(request);

      int stageId = GlobalData.getUlIdStage(request);
      int eventId = GlobalData.getUlIdEvent(request);

      // SIR 18961
      // If there is a todo override or it's in approval mode,
      // set page mode to true and insure with a wildcard that
      // any future checks on this stage (until the override is cleared)
      // that this will continue to be EDIT
      // BTW, Approve TodoOverrides shouldn't be created, but I'm
      // being defensive (incase someone decides to use that instead
      // of approval mode)
      if ((ToDoHelper.hasPageModeEditOverride(request, TASK_MNTN_NON_LIC, stageId, eventId))
          || (ToDoHelper.hasPageModeEditOverride(request, TASK_MNTN_LIC, stageId, eventId))
          || (ToDoHelper.hasPageModeEditOverride(request, TASK_REOPEN_HOME, stageId, eventId))
          || (ToDoHelper.hasPageModeEditOverride(request, TASK_CLOSE_HOME, stageId, eventId))
          || (ToDoHelper.hasPageModeEditOverride(request, TASK_APPROVE_HOME_LICENSE, stageId, eventId))
          || (ToDoHelper.hasPageModeEditOverride(request, TASK_APPROVE_HOME_CLOSURE, stageId, eventId))
          || (GlobalData.isApprovalMode(request))) {
        // 0 is wildcard for events
        ToDoHelper.setPageModeEditOverride(request, TASK_MNTN_NON_LIC, GlobalData.getUlIdStage(request), 0);

        PageMode.setPageMode(PageModeConstants.EDIT, request);
      } else {
        PageMode.setPageMode(GlobalData.getAppMode(request), request);
      }

      displayHomeInformation(context);
    } catch (Exception e) {
      handleException(e, context, "displayInitHomeInformation_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by GRNDS to clear state and initially display Home Info page an outer Initial display method
   * to handle clearing of state upon entering the conversation
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayHomeInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayHomeInformation_xa");
    performanceTrace.enterScope();

    try {
      displayHomeInformation(context);
    } catch (Exception e) {
      handleException(e, context, "displayHomeInformation_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by other methods to perform display logic and functionality
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void displayHomeInformation(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayHomeInformation");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      request.removeAttribute("launchDoc");
      boolean historical = false;
      int stageId = GlobalData.getUlIdStage(request);

      // If navigating from an event, automatically set page mode to VIEW?
      if (request.getParameter("actionEventStatusCode") != null) {
        // STGAP00005199 - uncommented since it should be view only
        // revert STGAP00003087
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        // end STGAP00005199

        // SMS# 37273 view only display is the only change needed the home should display as its
        // current status to prevent errors from trying to display resource history
        // that does not exists (non Licensing and Licensing changes).  There will be a future
        // MR that will track the history of the home see.  See STGAP14485
        // historical = true;
      } else {
        // MR-075 This may cause a problem since home could be linked to another event CCL
//        int eventId = CaseUtility.getEvent(stageId, TASK_MNTN_LIC).getIdEvent();

//        GlobalData.setUlIdEvent(eventId, request);
      }

      // SIR 18961 - Check hasStageAccess, since navigation path can be
      // SaveAssign to self, then back to HomeInformation without traversing
      // case summary.
      if (stageId > 0) {
        GlobalData.setStageAccess(CaseUtility.hasStageAccess(getUserProfile(request).getUserID(), stageId), request);
      }
      
      //STGAP00017058 - set mode to editPlus so that Fiscal Ops can access addressDetail page without needing stage access
      UserProfile user = UserProfileHelper.getUserProfile(context);
      if(common.hasSecurityClass(user.getUserID(), FISC_OPS_MAINT)){
        // set page mode to edit and add attribute to state to signify that we are in edit plus mode
        request.setAttribute("editPlus", true);
      }

      CFAD07SI cfad07si = populateCFAD07SI_Retrieve(context);
      // Historical will be true if we are navigating from an event.
      if (historical) {
        cfad07si.getArchInputStruct().setCReqFuncCd(C_REQ_FUNC_CD_RETRIEVE_HISTORICAL);
      }

      CFAD07SO cfad07so = resource.retrieveHomeDemographics(cfad07si);
      state.setAttribute(STR_CFAD07SO, cfad07so, request);
      // SIR 18098
      GlobalData.setUlIdResource(cfad07so.getUlIdResource(), request);
      
      if(cfad07so != null && cfad07so.getROWCFAD07SOG06() != null){
        GlobalData.setUlIdEvent(cfad07so.getROWCFAD07SOG06().getUlIdEvent(), request);
      }

      // This method is EventSearchConversation.getEventPageDetailMode incompatible

      // This submethod will set the page mode to view if the user does not have
      // the appropriate security
      checkPageModeForSecurity(context, cfad07so.getROWCFAD07SOG04().getSzCdRshsFaHomeStatus());

      // MR-075 This may cause a problem since home could be linked to another event
      // SIR 18334
//      if (CODE_STATUS_PENDING_CLOSURE.equals(cfad07so.getROWCFAD07SOG04().getSzCdRshsFaHomeStatus())) {
//        int eventId = CaseUtility.getEvent(GlobalData.getUlIdStage(request), TASK_CLOSE_HOME).getIdEvent();
//        GlobalData.setUlIdEvent(eventId, request);
//      }
      String currentStatus = StringHelper.EMPTY_STRING;
      String isNonPrs = StringHelper.EMPTY_STRING;
      if (cfad07so.getROWCFAD07SOG04() != null) {
        currentStatus = cfad07so.getROWCFAD07SOG04().getSzCdRshsFaHomeStatus();
        isNonPrs = StringHelper.getNonNullString(cfad07so.getROWCFAD07SOG04().getCIndRshsNonDFCSHome());
      }
      makeMaleFemaleMaxMinAgeDropdowns(context);

      // Create a hashmap of the checkbox values for Child Ethnicities
      Enumeration ethEnumeration = cfad07so.getROWCFAD07SOG03_ARRAY().enumerateROWCFAD07SOG03();
      setEthnicitiesHash(context, ethEnumeration);

      // Create a hashmap of the checkbox values for Child Races
      Enumeration raceEnumeration = cfad07so.getHomeRaceSO_ARRAY().enumerateHomeRaceSO();
      setRacesHash(context, raceEnumeration);
      
      // Create a hashmap of the checkbox values for Child Characteristics
      Enumeration charEnumeration = cfad07so.getROWCFAD07SOG02_ARRAY().enumerateROWCFAD07SOG02();
      setCharacteristicsHash(context, charEnumeration);

      // Home License Section
      CFAD37SI cfad37si = populateCFAD37SI_Retrieve(context);
      CFAD37SO cfad37so = resource.retrieveHomeLicenseInformation(cfad37si);

      if (cfad37so != null) {
        state.setAttribute(STR_CFAD37SO, cfad37so, request);

        if (PageModeConstants.MODIFY.equals(PageMode.getPageMode(request))
            && TASK_REOPEN_HOME.equals(GlobalData.getSzCdTask(request))
            && !CODE_STATUS_CLOSED.equals(cfad37so.getSzCdRsrcFaHomeStatus())) {
          setInformationalMessage(Messages.MSG_FAD_HOME_REOPENED, request);
        }

        // Historical cfad07s call returns empty status and category.
        if (!StringHelper.isValid(currentStatus)) {
          currentStatus = cfad37so.getSzCdRsrcFaHomeStatus();
        }

        makeRestrictedStatusDropdown(context, currentStatus, isNonPrs);

        // Inquiry and Orientation/Preservice Sections
        HomeApplicantRetrieveSI homeApplicantretrievesi = populateHomeApplicantRetrieveSI_Retrieve(context);
        HomeApplicantRetrieveSO homeApplicantretrieveso = resource.retrieveHomeApplicantInfo(homeApplicantretrievesi);
        state.setAttribute(STR_HOMEAPPLICANTRETRIEVESO, homeApplicantretrieveso, request);

        // Create a hashmap of the checkbox values for Programs Of Interest
        Enumeration programOfInterestEnumeration = homeApplicantretrieveso.getArrayProgramsOfInterest()
                                                                          .enumerateROWCFAD07SOG07();
        setROWCFAD07SOG07Hash(context, programOfInterestEnumeration, "prgrmOfInterestHash");

        // Create a hashmap of the checkbox values for Sources Of Inquiry
        Enumeration srcsOfInquiryEnumeration = homeApplicantretrieveso.getArraySourceOfInquiry()
                                                                      .enumerateROWCFAD07SOG07();
        setROWCFAD07SOG07Hash(context, srcsOfInquiryEnumeration, "srcOfInquiryHash");

        // Create a hashmap of the checkbox values for Sources Of Inquiry
        Enumeration infoCoveredEnumeration = homeApplicantretrieveso.getArrayInformationCovered()
                                                                    .enumerateROWCFAD07SOG07();
        setROWCFAD07SOG07Hash(context, infoCoveredEnumeration, "infoCoveredHash");

        // Close Home Section
        CFAD30SI cfad30si = populateCFAD30SI_Retrieve(context);

        CFAD30SO cfad30so = resource.retrieveNeccessaryInformation(cfad30si);
        state.setAttribute(STR_CFAD30SO, cfad30so, request);
        
        //determine if exchange home detail should be displayed
        checkExchangeHomeTabDisplay(context, cfad37so); 
        
        //STGAP00011220: determine if Foster Home Conversion should be displayed
        checkFHConvTabDisplay(context, cfad37so);

        // SIR 23122 - added check for event status = pending. if approval event was
        // rejected(status = complete), then don't show the message that the closure
        // is pending approval still. Don't show message if in view mode.
        if (CODE_STATUS_PENDING_CLOSURE.equals(cfad30so.getSzCdRsrcFaHomeStatus())
            && !GlobalData.isApprovalMode(request) && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))
            && EVENT_STATUS_PEND.equals(cfad30so.getROWCCMN01UIG00().getSzCdEventStatus())) {
          setInformationalMessage(Messages.MSG_FAD_CLOSE_PENDING, request);
        }
        // If pending supervisor approval, and we are not the supervisor approving,
        // display info. message. Don't show message if in view mode.
        else if (EVENT_STATUS_PEND.equals(cfad37so.getROWCCMN01UIG00().getSzCdEventStatus())
                 && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))
                 && !GlobalData.isApprovalMode(request)) {
          setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
      }
    } catch (Exception e) {
      handleException(e, context, "displayHomeInformation");
    }

    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by the displayHomeInformation to populate the input object for the cfad07s retrieve
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private CFAD07SI populateCFAD07SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD07SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CFAD07SI cfad07si = new CFAD07SI();

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(C_REQ_FUNC_CD_RETRIEVE);
    input.setSzUserId(getUserLogonID(request));

    cfad07si.setArchInputStruct(input);
    cfad07si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    cfad07si.setUlIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.exitScope();
    return cfad07si;
  }

  /**
   * This helper method is called by the displayHomeInformation to populate the input object for the HomeApplicant
   * retrieve service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private HomeApplicantRetrieveSI populateHomeApplicantRetrieveSI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateHomeApplicantRetrieveSI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    HomeApplicantRetrieveSI homeapplicantretrievesi = new HomeApplicantRetrieveSI();

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(C_REQ_FUNC_CD_RETRIEVE);

    homeapplicantretrievesi.setArchInputStruct(input);
    homeapplicantretrievesi.setIdResource(GlobalData.getUlIdResource(request));

    performanceTrace.exitScope();
    return homeapplicantretrievesi;

  }

  /**
   * This helper method is called by the displayHomeInformation to populate the input object for the cfad30s retrieve
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private CFAD30SI populateCFAD30SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD30SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CFAD30SI cfad30si = new CFAD30SI();

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(C_REQ_FUNC_CD_RETRIEVE);
    input.setSzUserId(getUserLogonID(request));

    cfad30si.setArchInputStruct(input);
    // ##SIR 17235 -- Sending event id on this retrieval causes the event id in the output to be zero.
    // Removed setting of event id so that the correct event id will be returned.
    // cfad30si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    cfad30si.setUlIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.exitScope();
    return cfad30si;
  }

  /**
   * This helper method is called by the saveHomeInformation_xa to populate the input object for the cfad36s
   * (Close/Reopen Home) save service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private CFAD36SI populateCFAD36SI_U(GrndsExchangeContext context, String currentStatus, boolean isReopen) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD36SI_U");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get today's date
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new Date());
    Date tsToday = new Date();

    UserProfile user = UserProfileHelper.getUserProfile(context);
    int userID = getUserID(request);

    boolean pageSubmitted = false;
    if (!StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(context, "submitted"))) {
      pageSubmitted = true;
    }

    String newStatus = ContextHelper.getStringSafe(context, STATUS_DROPDOWN);
    request.setAttribute("newStatus", newStatus);
    boolean isClosure = false;
    if (CODE_STATUS_CLOSED.equals(newStatus) || CODE_STATUS_PENDING_CLOSURE.equals(newStatus)) {
      isClosure = true;
    }

    String closureReason = ContextHelper.getStringSafe(context, "selClosureReason");
    String involuntaryClosure = ContextHelper.getStringSafe(context, "selInvolClosure");
    String recReopen = ContextHelper.getStringSafe(context, "selRecReopen");
    String statusRsnComments = ContextHelper.getStringSafe(context, "txtStatusRsnComments");

    CFAD30SO cfad30so = (CFAD30SO) state.getAttribute(STR_CFAD30SO, request);

    CFAD36SI cfad36si = new CFAD36SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 current = new ROWCCMN01UIG00();
    ROWCCMN01UIG00 next = new ROWCCMN01UIG00();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    ROWCCMN01UIG00_ARRAY rowccmn01uig00_array = new ROWCCMN01UIG00_ARRAY();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    TsLastUpdate_ARRAY timestampArray = new TsLastUpdate_ARRAY();
    SzCdRsrcFaHomeStatus_ARRAY homeStatusArray = new SzCdRsrcFaHomeStatus_ARRAY();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    cfad36si.setArchInputStruct(input);
    cfad36si.setBIndRsrcNonPrs(cfad30so.getBIndRsrcNonPrs());
    cfad36si.setSzCdRsrcRegion(StringHelper.EMPTY_STRING);
    cfad36si.setSzCdCntrctRegion(StringHelper.EMPTY_STRING);
    //STGAP00017058 - set last updated by field
    cfad36si.setTxtLastUpdatedBy(user.getUserFullName());
    if (!isReopen) {
      cfad36si.setSzCdRsrcClosureRsn(closureReason);
      cfad36si.setSzCdRsrcInvolClosure(involuntaryClosure);
      cfad36si.setSzCdRsrcRecmndReopen(recReopen);
      cfad36si.setSzTxtStatusRsnComments(statusRsnComments);
    }
    homeStatusArray.addSzCdRsrcFaHomeStatus(currentStatus);
    homeStatusArray.addSzCdRsrcFaHomeStatus(newStatus);
    cfad36si.setSzCdRsrcFaHomeStatus_ARRAY(homeStatusArray);
    cfad36si.setSzCdRsrcStatus(cfad30so.getSzCdRsrcStatus());
    cfad36si.setSzCdRsrcFacilType(cfad30so.getSzCdRsrcFacilType());
    cfad36si.setUlIdResource(cfad30so.getUlIdResource());
    timestampArray.addTsLastUpdate(CURRENT, cfad30so.getTsLastUpdate_ARRAY().getTsLastUpdate(CURRENT));
    timestampArray.addTsLastUpdate(NEXT, cfad30so.getTsLastUpdate_ARRAY().getTsLastUpdate(NEXT));
    cfad36si.setTsLastUpdate_ARRAY(timestampArray);
    cfad36si.setUlIdCntrctWkr(userID);
    cfad36si.setUlIdPerson(userID);
    cfad36si.setSzCdRsrcCnty(StringHelper.EMPTY_STRING);
    cfad36si.setUlIdCase(cfad30so.getUlIdCase());
    cfad36si.setUlIdSituation(cfad30so.getUlIdSituation());

    String eventStatus = cfad30so.getROWCCMN01UIG00().getSzCdEventStatus();
    // CURRENT Event row
    if (EVENT_STATUS_PEND.equals(eventStatus) || EVENT_STATUS_PROC.equals(eventStatus)) {
      current.setSzCdTask(cfad30so.getROWCCMN01UIG00().getSzCdTask());
      current.setTsLastUpdate(cfad30so.getROWCCMN01UIG00().getTsLastUpdate());
      current.setSzCdEventStatus(cfad30so.getROWCCMN01UIG00().getSzCdEventStatus());
      current.setSzCdEventType(cfad30so.getROWCCMN01UIG00().getSzCdEventType());
      current.setDtDtEventOccurred(cfad30so.getROWCCMN01UIG00().getDtDtEventOccurred());
      current.setUlIdEvent(cfad30so.getROWCCMN01UIG00().getUlIdEvent());
      current.setUlIdStage(cfad30so.getROWCCMN01UIG00().getUlIdStage());
      current.setUlIdPerson(cfad30so.getROWCCMN01UIG00().getUlIdPerson());
      current.setSzTxtEventDescr(cfad30so.getROWCCMN01UIG00().getSzTxtEventDescr());
    } else {
      current.setUlIdEvent(cfad30so.getROWCCMN01UIG00().getUlIdEvent());
    }
    rowccmn01uig00_array.addROWCCMN01UIG00(current);

    // NEXT Event row
    if (isClosure) {
      next.setSzCdTask(TASK_CLOSE_HOME);
      next.setSzCdEventType(EVENT_TYPE_CLOSE);
      if (CODE_STATUS_PENDING_CLOSURE.equals(newStatus)) {
        next.setSzTxtEventDescr(EVENT_DESCR_HOME_PENDING_CLOSE);
      } else {
        next.setSzTxtEventDescr(EVENT_DESCR_HOME_CLOSED);
      }
    } else {
      next.setSzCdTask(TASK_REOPEN_HOME);
      next.setSzCdEventType(EVENT_TYPE_HME);
      String reopenEventDescription = EVENT_DESCR_HOME_REOPEN
                                      + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, newStatus);
      next.setSzTxtEventDescr(reopenEventDescription);
    }

    // JMC - SIR 19309 - If we are just saving the page we want
    // to set the event status to PROC. It is only when we are
    // saving and submitting that the event status should be set
    // to COMP.
    if (CODE_STATUS_CLOSED.equals(newStatus)) {
      next.setSzCdEventStatus(EVENT_STATUS_COMP);
    } else if (!pageSubmitted) {
      next.setSzCdEventStatus(EVENT_STATUS_PROC);
    } else {
      next.setSzCdEventStatus(EVENT_STATUS_COMP);
    }

    next.setUlIdEvent(0);
    next.setUlIdStage(GlobalData.getUlIdStage(request));
    next.setUlIdPerson(userID);
    next.setTsLastUpdate(tsToday);
    next.setDtDtEventOccurred(today);

    rowccmn01uig00_array.addROWCCMN01UIG00(next);

    rowccmn01uig01.setUlIdPerson(0);
    rowccmn01uig01.setSzCdScrDataAction(StringHelper.EMPTY_STRING);
    Date d3 = new Date();
    rowccmn01uig01.setTsLastUpdate(d3);

    // Set the array into the parent struct
    cfad36si.setROWCCMN01UIG00_ARRAY(rowccmn01uig00_array);

    // Add the struct to the array
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    // Set the array into the parent struct
    current.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    next.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    performanceTrace.exitScope();
    return cfad36si;
  }

  /**
   * This helper method is called by the displayHomeInformation to populate the input object for the
   * saveFAHomeSupervisor service.
   * 
   * @param context
   *          The GrndeExchangeContext
   * 
   */

  private SaveFAHomeSupervisorSI populateSaveFAHomeSupervisor(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD36SI_U");
    performanceTrace.enterScope();
    SaveFAHomeSupervisorSI saveFAHomeSupervisorsi = new SaveFAHomeSupervisorSI();
    int idResource = GlobalData.getUlIdResource(context.getRequest());
    String cdRsrcClosureRsn = ContextHelper.getStringSafe(context, "selClosureReason");
    String cdRsrcInvolClosure = ContextHelper.getStringSafe(context, "selInvolClosure");
    String cdRsrcRecmndReopen = ContextHelper.getStringSafe(context, "selRecReopen");
    String txtClosureComm = ContextHelper.getStringSafe(context, "txtStatusRsnComments");
    String txtLegalNm = ContextHelper.getStringSafe(context, "txtLegalName");
    saveFAHomeSupervisorsi.setIdResource(idResource);
    saveFAHomeSupervisorsi.setCdRsrcClosureRsn(cdRsrcClosureRsn);
    saveFAHomeSupervisorsi.setCdRsrcInvolClosure(cdRsrcInvolClosure);
    saveFAHomeSupervisorsi.setCdRsrcRecmndReopen(cdRsrcRecmndReopen);
    saveFAHomeSupervisorsi.setTxtClosureComm(txtClosureComm);
    saveFAHomeSupervisorsi.setTxtLegalNm(txtLegalNm);
    return saveFAHomeSupervisorsi;
  }

  /**
   * This helper method is called by the displayHomeInformation to populate the input object for the cfad37s retrieve
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private CFAD37SI populateCFAD37SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD37SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    CFAD37SI cfad37si = new CFAD37SI();

    // Set the values for the ArchInputStruct
    if (PageModeConstants.MODIFY.equals(PageMode.getPageMode(request))) {
      input.setCReqFuncCd(C_REQ_FUNC_CD_LIC_MODIFY);
    } else if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
      input.setCReqFuncCd(C_REQ_FUNC_CD_LIC_NEW);
    } else {
      // SPB SIR 22397: Changed Req func code since the capacity is only calculated
      // in cfad37s.src when req func code is C_REQ_FUNC_CD_LIC_MODIFY:
      // previously: input.setCReqFuncCd(C_REQ_FUNC_CD_LIC_HISTORY);
      input.setCReqFuncCd(C_REQ_FUNC_CD_LIC_MODIFY);
    }

    input.setSzUserId(getUserLogonID(request));

    cfad37si.setArchInputStruct(input);
    cfad37si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    cfad37si.setUlIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.exitScope();
    return cfad37si;
  }

  /**
   * This method is called by the GRNDS controller when a user opens the Add Home page (always in NEW mode)
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayNewHomeInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayNewHomeInformation_xa");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      state.removeAllAttributes(request);

      makeMaleFemaleMaxMinAgeDropdowns(context);

      PageMode.setPageMode(GlobalData.getAppMode(request), request);

      // get the id of the logged on user
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      if (userProfile != null) {
        if (!userProfile.hasRight(UserProfile.SEC_MTN_HOME)) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
        GlobalData.setUlIdPerson(userProfile.getUserID(), request);
      }
    } catch (Exception e) {
      handleException(e, context, "displayNewHomeInformation_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by display methods when the Home Information page is loaded. Creates the Male and Female Age
   * Range dropdown options.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void makeMaleFemaleMaxMinAgeDropdowns(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "makeMaleFemaleMaxMinAgeDropdowns");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      SortedMap<Integer, Option> years = new TreeMap<Integer, Option>();
      SortedMap<Integer, Option> months = new TreeMap<Integer, Option>();
      int yearCount = FAHomeHistoryConversation.FAD_MIN_AGE_YR;
      int monthCount = FAHomeHistoryConversation.FAD_MIN_AGE_MO;
      Option anOption;

      while (yearCount <= FAHomeHistoryConversation.FAD_MAX_AGE_YR) {
        anOption = new Option(String.valueOf(yearCount), String.valueOf(yearCount));
        years.put(yearCount++, anOption);
      }

      state.setAttribute("years", years, request);

      while (monthCount <= FAHomeHistoryConversation.FAD_MAX_AGE_MO) {
        anOption = new Option(String.valueOf(monthCount), String.valueOf(monthCount));
        months.put(monthCount++, anOption);
      }
      state.setAttribute("months", months, request);
    } catch (Exception e) {
      handleException(e, context, "makeMaleFemaleMaxMinAgeDropdowns");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by other method which display the Home Information page. Creates Status field dropdown
   * options depending upon the current status of the Home.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void makeRestrictedStatusDropdown(GrndsExchangeContext context, String currentStatus, String isNonPrs) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    SortedMap<Integer, Option> restrictedStatusList = getRestrictedStatusListFor(currentStatus);

    List<String> faHmStatuses = new ArrayList<String>();
    faHmStatuses.add(CODE_STATUS_PEND_FULL_APP);
    faHmStatuses.add(CODE_STATUS_PEND_SPEC_APP);
    faHmStatuses.add(CODE_STATUS_PEND_FULL_APP_30_DAY);
    faHmStatuses.add(CODE_STATUS_PEND_SPEC_APP_30_DAY);
    faHmStatuses.add(CODE_STATUS_PEND_TEMP_APP);
    faHmStatuses.add(CODE_STATUS_PEND_UNAPPROVE);
    
    // MR-075 Remove PCL as an option if the current home status is one of the pending statuses and
    // page is in Approval mode.
    // This is to avoid system error when supervisor changes home status to pending closure before
    // rejecting the previous pending approval. System would throw an exception due to no home Conclusion
    // event existing resulting in a stuck Home in Pending Closure.
    if( GlobalData.isApprovalMode(request) && faHmStatuses.contains(currentStatus)){
      Set<Integer> keySet = restrictedStatusList.keySet();
      Iterator<Integer> it = keySet.iterator();
      
      while(it.hasNext()){
        Integer key = it.next();
        Option op = restrictedStatusList.get(key);
        
        if(op != null && CODE_STATUS_PENDING_CLOSURE.equals(op.getKey())){
          restrictedStatusList.remove(key);
          break;
        }
      }
    }

    state.setAttribute("restrictedStatusOptions", restrictedStatusList, request);
  }

  private SortedMap<Integer, Option> getRestrictedStatusListFor(String status) {
    SortedMap<Integer, Option> restrictedStatusList = new TreeMap<Integer, Option>();

    if (StringHelper.EMPTY_STRING.equals(status)) {
      addOption(restrictedStatusList, CODE_STATUS_INQUIRY);
      addOption(restrictedStatusList, CODE_STATUS_APPLICANT);
    } else {
      // if current status is inquiry
      if (CODE_STATUS_INQUIRY.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_INQUIRY);
        addOption(restrictedStatusList, CODE_STATUS_APPLICANT);
        addOption(restrictedStatusList, CODE_STATUS_WAITLIST);
        addOption(restrictedStatusList, CODE_STATUS_CLOSED);
      } else if (CODE_STATUS_WAITLIST.equals(status)) { // if waitlist
        addOption(restrictedStatusList, CODE_STATUS_WAITLIST);
        addOption(restrictedStatusList, CODE_STATUS_INQUIRY);
      } else if (CODE_STATUS_CLOSED.equals(status)) { // if closed
        addOption(restrictedStatusList, CODE_STATUS_INQUIRY);
        addOption(restrictedStatusList, CODE_STATUS_CLOSED);
      } else if (CODE_STATUS_APPLICANT.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_APPLICANT);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_WAITLIST);
        addOption(restrictedStatusList, CODE_STATUS_CLOSED);
      } else if (CODE_STATUS_APPROVED_FULL_ACTIVE.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_APPROVED_FULL_ACTIVE);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP_30_DAY);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_APPROVED_SPEC_ACTIVE);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP_30_DAY);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_APPROVED_TEMP_ACTIVE.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_APPROVED_TEMP_ACTIVE);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_PEND_FULL_APP.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_PEND_SPEC_APP.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_PEND_TEMP_APP.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_PEND_TEMP_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_PEND_FULL_APP_30_DAY.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP_30_DAY);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_PEND_SPEC_APP_30_DAY.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP_30_DAY);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_PEND_UNAPPROVE.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_PEND_UNAPPROVE);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_UNAPPROVED.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_UNAPPROVED);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_APPROVED_FULL_ACTIVE_30_DAY);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_APPROVED_SPEC_ACTIVE_30_DAY);
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      } else if (CODE_STATUS_PENDING_CLOSURE.equals(status)) {
        addOption(restrictedStatusList, CODE_STATUS_PEND_FULL_APP);
        addOption(restrictedStatusList, CODE_STATUS_PEND_SPEC_APP);
        addOption(restrictedStatusList, CODE_STATUS_PENDING_CLOSURE);
      }
    }
    return restrictedStatusList;
  }

  /**
   * This method is called by the GRNDS controller when a user selects an address to view/modify
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayAddressDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayAddressDetail_xa");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      CFAD07SO cfad07so = (CFAD07SO) state.getAttribute(STR_CFAD07SO, request);
      if (cfad07so != null) {
        ROWCFAD07SOG01_ARRAY addressArray = cfad07so.getROWCFAD07SOG01_ARRAY();
        int arrayIndex = ContextHelper.getIntSafe(request, ADDRESS_ARRAY_INDEX);
        ROWCFAD07SOG01 addressRow = addressArray.getROWCFAD07SOG01(arrayIndex);
        state.setAttribute(CURRENT_ADDRESS, addressRow, request);
      }
      
      // STGAP00017058 - check to see if user is ficscal ops
      UserProfile user = UserProfileHelper.getUserProfile(request);
      // check to see if user is the Fiscal Operations State Office Maintainer
      if(common.hasSecurityClass(user.getUserID(), FISC_OPS_MAINT)){
        // set page mode to edit and add attribute to state to signify that we are in edit plus mode
        request.setAttribute("editPlus", true);
      }
    } catch (Exception e) {
      handleException(e, context, "displayAddressDetail_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user selects a phone to view/modify
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayPhoneDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayPhoneDetail_xa");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      CFAD07SO cfad07so = (CFAD07SO) state.getAttribute(STR_CFAD07SO, request);
      if (cfad07so != null) {
        ROWCFAD07SOG00_ARRAY phoneArray = cfad07so.getROWCFAD07SOG00_ARRAY();
        int arrayIndex = ContextHelper.getIntSafe(request, "phoneArrayIndex");
        ROWCFAD07SOG00 phoneRow = phoneArray.getROWCFAD07SOG00(arrayIndex);
        state.setAttribute(CURRENT_PHONE, phoneRow, request);
      }

    } catch (Exception e) {
      handleException(e, context, "displayPhoneDetail_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user decides not to continue closing a home once the pending
   * closure has been rejected.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void reloadRejectedHome_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "reloadRejectedHome_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Pagination not necessary but creating object in order to reuse the service
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(5);

    CFAD12SI cfad12si = populateCFAD12SI_Retrieve(context, tuxPagination);

    CFAD12SO cfad12so = resource.retrieveFAHomeHistory(cfad12si);
    String currentStatus = cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00()[0].getSzCdRshsFaHomeStatus();
    String previousStatus = null;

    Enumeration historyEnumeration1 = cfad12so.getROWCFAD12SOG00_ARRAY().enumerateROWCFAD12SOG00();

    while (historyEnumeration1.hasMoreElements()) {
      String historyStatus = ((ROWCFAD12SOG00) historyEnumeration1.nextElement()).getSzCdRshsFaHomeStatus();

      if (!historyStatus.equals(currentStatus)) {
        previousStatus = historyStatus;
        break;
      }
    }

    // STGAP00006435 using previous status from history to populate the rejected home's status
    SortedMap<Integer, Option> restrictedStatusList = getRestrictedStatusListFor(previousStatus);
    state.setAttribute("restrictedStatusOptions", restrictedStatusList, request);
    request.setAttribute("rejectClosureCase", "true");
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the Delete button on the Home Information page,
   * under the phone list
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deletePhoneRow_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deletePhoneRow_xa");
    performanceTrace.enterScope();

    // SIR 22684 - need to blank out phone info upon delete.
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      CFAD08SI cfad08si = populateCFAD08SI_Phone(context, ServiceConstants.REQ_FUNC_CD_DELETE);
      CFAD08SO cfad08so = resource.saveHomeDemographics(cfad08si);
      if(cfad08so.getUlIdEvent() > 0){
        GlobalData.setUlIdEvent(cfad08so.getUlIdEvent(), request);
      }

      // SIR 22684 - need to blank out phone info upon delete so it doesn't re-display upon add.
      state.removeAttribute(CURRENT_PHONE, request);

    } catch (Exception e) {
      handleException(e, context, "deletePhoneRow_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the Delete button on the Home Information page,
   * under the address list
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteAddressRow_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteAddressRow_xa");
    performanceTrace.enterScope();

    try {
      CFAD08SI cfad08si = populateCFAD08SI_Address(context, ServiceConstants.REQ_FUNC_CD_DELETE);
      CFAD08SO cfad08so = resource.saveHomeDemographics(cfad08si);
      if(cfad08so.getUlIdEvent() > 0){
        GlobalData.setUlIdEvent(cfad08so.getUlIdEvent(), context.getRequest());
      }
    } catch (Exception e) {
      handleException(e, context, "deleteAddressRow_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save' button on F/A Home Information Detail
   * page. It is also called by saveAssignHomeInformation_xa, saveSubmitHomeInformation_xa
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveHomeInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveHomeInformation_xa");
    performanceTrace.enterScope();

    try {
      save(context);

      performanceTrace.exitScope();
    } catch (Exception e) {
      handleException(e, context, "saveHomeInformation_xa");
    }
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save' button on New Home Information Detail
   * page.
   * 
   * @deprecated
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveNewHomeInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveHomeInformation_xa");
    performanceTrace.enterScope();

    try {

      save(context);

      // return to the F/A Home Search Page
      forward("/resource/FAHomeSearch/displayHomeSearch", context.getRequest(), context.getResponse());
      performanceTrace.exitScope();
    } catch (Exception e) {
      handleException(e, context, "saveHomeInformation_xa");
    }
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save' button on F/A Home Information Detail
   * page. It is also called by saveAssignHomeInformation_xa, saveSubmitHomeInformation_xa.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "save");
    performanceTrace.enterScope();
    int userID = UserProfileHelper.getUserProfile(context).getUserID();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      
      // SMS #81140: MR-074 Check for approval mode
      boolean isApprovalModeFromGlobalData = GlobalData.isApprovalMode(request);

      // begin transaction
      String eventStatus = EVENT_STATUS_COMP;
      // boolean isSubmit = false;
      if (state.getAttribute(IS_SUBMIT, request) != null) {
        // isSubmit = true;
        eventStatus = EVENT_STATUS_PEND;
      }

      CFAD07SO cfad07so = (CFAD07SO) state.getAttribute(STR_CFAD07SO, request);
      String currentStatus = cfad07so.getROWCFAD07SOG04().getSzCdRshsFaHomeStatus();
      String newStatus = ContextHelper.getStringSafe(context, STATUS_DROPDOWN);
            
      // SMS #81140: MR-074 Move this line from the if clause below 
      // (if (!CODE_STATUS_CLOSED.equals(currentStatus) && !CODE_STATUS_PENDING_CLOSURE.equals(currentStatus))) 
      // to here
      CFAD08SI cfad08si = populateCFAD08SI_AU(context, ServiceConstants.REQ_FUNC_CD_UPDATE, eventStatus);
      
      // SMS #81140: MR-074 Check Marital Status mismatch upon 'save and submit' and supervisor's 'save'
      boolean isMaritalStatusMismatch = false;
      if ((state.getAttribute(IS_SUBMIT, request) != null) || (isApprovalModeFromGlobalData)) {
        isMaritalStatusMismatch = resource.checkInconsistentMaritalStatus(cfad08si);
        if (isMaritalStatusMismatch) {
          throw new ServiceException(Messages.MSG_FAD_MARITAL_NOT_MATCH_PERSON);
        }
      }
      
      // If status is currently closed, nothing can be saved on the page except a new status (re-open)
      // therefore we don't want to call the demographics save at all.
      if (!CODE_STATUS_CLOSED.equals(currentStatus)) {
        CFAD37SI cfad37si = populateCFAD37SI_Retrieve(context);

        CFAD37SO beforeTransactionCfad37so = resource.retrieveHomeLicenseInformation(cfad37si);

        // CFAD08SI cfad08si = populateCFAD08SI_AU(context, ServiceConstants.REQ_FUNC_CD_UPDATE, eventStatus);
        // cfad08s originally called from cfad03w.win
        boolean callSaveDemographic = isDemoChanged(cfad07so, cfad08si, context);
        boolean isApprovalMode = false;
                
        if (CodesTables.CEVTSTAT_PEND.equals(cfad07so.getROWCFAD07SOG06().getSzCdEventStatus())
            && (!GlobalData.isApprovalMode(request))) {
          // STGAP00009881: Use the pending event to invalidate the approval instead of the current event. The current event
          //                is in Global Data. The pending event is in the CFAD07SO structure
          CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(cfad07so.getROWCFAD07SOG06().getUlIdEvent());

          CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent(cfad07so, userID);
          
          InvalidateApprovalSI invalidateApprovalsi = populateInvalidateApprovalSI_InvalidateAndPostEvent(ccmn01ui,
                                                                                                          ccmn05ui);

          // STGAP00006198 This Service Will invalidate the Approval and call Post event to update the event and
          // event_person_link table if the post event fails then both
          // will be rolled back. This way the transaction will be rolled back
          // and event statuses will keep in synch.
          invalidateAndPostEvent.invalidateAndPostEvent(invalidateApprovalsi);

          isApprovalMode = false;
        } else if (CodesTables.CEVTSTAT_PEND.equals(cfad07so.getROWCFAD07SOG06().getSzCdEventStatus())
                   && GlobalData.isApprovalMode(request)) {
          isApprovalMode = true;
        } else {
          isApprovalMode = false;
        }
        cfad08si.setIsApprovalMode(isApprovalMode);
        
        String cdClosureRsn = ContextHelper.getStringSafe(context, CLOSURE_RSN);
        
        // 37312 Checking to see if the house has active placements if so we want to prevent the 
        // user from being able to save the page. 
        
        if (CODE_STATUS_PENDING_CLOSURE.equals(newStatus)) {
          boolean hasActivePlacements = resource.checkIfHomeHasActivePlacements(cfad08si.getUlIdResource(),
                                                                                cdClosureRsn);
          if (hasActivePlacements) {
            throw new ServiceException(Messages.MSG_FAD_HOME_WITH_PLACEMENTS);
          }
        }
                
        if (callSaveDemographic) {
          //STGAP00013543 Update the Home's name if the Resource name has been updated/changed
          ROWCFAD08SIG04 inDemo = cfad08si.getROWCFAD08SIG04();
          ROWCFAD07SOG04 outDemo = cfad07so.getROWCFAD07SOG04();
          if(inDemo.getSzNmRshsResource()!= null && outDemo.getSzNmRshsResource() != null){
             if(!objectEqualsSafe(inDemo.getSzNmRshsResource(), outDemo.getSzNmRshsResource())){
               cfad08si.setCSysIndRsrcNameChg(ArchitectureConstants.Y);
               cfad08si.getROWCFAD08SIG04().setSzNmRshsResource(inDemo.getSzNmRshsResource());
             }
          }
          CFAD08SO cfad08so = resource.saveHomeDemographics(cfad08si);
          if(cfad08so.getUlIdEvent() > 0){
            GlobalData.setUlIdEvent(cfad08so.getUlIdEvent(), request);
          }
        }

        // RE-Retrieve the Home License object to refresh timestamp and to check for document
        cfad37si = populateCFAD37SI_Retrieve(context);
        CFAD37SO cfad37so = resource.retrieveHomeLicenseInformation(cfad37si);

        state.setAttribute(STR_CFAD37SO, cfad37so, request);

        // cfad38s originally called from cfad06w.win
        CFAD38SI cfad38si = populateCFAD38SI_AU(context, beforeTransactionCfad37so.getSzCdRsrcFaHomeStatus());
        cfad38si.setIsApprovalMode(isApprovalMode);

        // 14700 - if the license info is changed, (includes category), the
        // home status is changed, or the marital status is changed,
        // set the indicator to write to the history table
        if ((isLicensingChanged(beforeTransactionCfad37so, cfad38si, context)
             || (currentStatus != null && !currentStatus.equals(newStatus))
             || isMarStatChanged(cfad07so, cfad08si, context)
             // this to write to history every time page is submitted
             || (state.getAttribute(IS_SUBMIT, request) != null))
             // this prevents duplicate history records when cfad36 is called
             && !CODE_STATUS_CLOSED.equals(newStatus)
             && !CODE_STATUS_PENDING_CLOSURE.equals(newStatus)) {
          cfad38si.setCIndRshsWriteHist(IND_YES);
        } else {
          cfad38si.setCIndRshsWriteHist(IND_NO);
        }                
        // 19596 (2nd time I fixed it), Matthew McClain
        // For some reason when status is going to be saved as
        // closed we force the user to click Save if any data changes
        // If we are saving any non-close status, we don't want to be
        // careful, because Service Codes change periodically
        // independently of FADs; we want to create new contracts with
        // the new codes as soon as we save/reopen an existing FAD
        if ((CODE_STATUS_CLOSED.equals(newStatus))
            && (isLicensingChanged(beforeTransactionCfad37so, cfad38si, context))) {
          // changed this to service exceptions as opposed to runtime exception
          throw new ServiceException(Messages.MSG_SAVE_BEFORE_CLOSE);
        } else if((isLicensingChanged(beforeTransactionCfad37so, cfad38si, context)
            // this is to create new event on every submit
            || (state.getAttribute(IS_SUBMIT, request) != null))
            // this is to prevent duplication event creation for pending closure
            && !CODE_STATUS_PENDING_CLOSURE.equals(newStatus)){
          cfad38si.setCSysIndFosterTypeChange(IND_YES);
          cfad38si.setCSysIndLocChange(IND_YES);
          cfad38si.setCSysIndCategoryChange(IND_YES);
          cfad38si.setCSysIndMaAgeChange(IND_YES);
          cfad38si.setCSysIndFeAgeChange(IND_YES);
          CFAD38SO cfad38so = resource.saveHomeLicense(cfad38si);
          // Need to sync records check for FAD Resource Household member if approval end date changed.
          resource.syncResourceHhMbrsFaPersonDtl(GlobalData.getUlIdResource(request));
          if(cfad38so.getUlIdEvent() > 0){
            GlobalData.setUlIdEvent(cfad38so.getUlIdEvent(), request);
          }
        }

        // RE-Retrieve the Home License object to refresh timestamp and to check for document
        cfad37si = populateCFAD37SI_Retrieve(context);
        cfad37so = resource.retrieveHomeLicenseInformation(cfad37si);

        state.setAttribute(STR_CFAD37SO, cfad37so, request);

        // retrieve homeApplicantRetrieveSO
        HomeApplicantRetrieveSI homeApplicantRetrieveSI = populateHomeApplicantRetrieveSI_Retrieve(context);
        HomeApplicantRetrieveSO homeApplicantRetrieveSO = resource.retrieveHomeApplicantInfo(homeApplicantRetrieveSI);
        // save inquiry information and orientation preservice subsection
        HomeApplicantSaveSI homeApplicantSaveSI = populateHomeApplicantSaveSI_AU(
                                                                                 context,
                                                                                 ServiceConstants.REQ_FUNC_CD_UPDATE,
                                                                                 GlobalData
                                                                                           .getUlIdResource(context
                                                                                                                   .getRequest()));
        boolean callHomeApplicantSaveSI = isHomeApplicantChanged(homeApplicantRetrieveSO, homeApplicantSaveSI, context);
        if (callHomeApplicantSaveSI) {
          resource.saveHomeApplicantInfo(homeApplicantSaveSI);
        }

      } // end if current status is not closed

      // The cfad36s service is associated with Closing/Reopening the home.
      // We will only call this service in the following three situations:
      // 1. The status was closed and has been changed.
      // 2. The new status is Closed.
      // 3. The new status is Pending Closure.
      boolean closeHome = false;
      boolean reopenHome = false;
      if (CODE_STATUS_CLOSED.equals(currentStatus) && !CODE_STATUS_CLOSED.equals(newStatus)) {
        reopenHome = true;
      } else if (CODE_STATUS_CLOSED.equals(newStatus) || CODE_STATUS_PENDING_CLOSURE.equals(newStatus)) {
        closeHome = true;
      }

      if (closeHome || reopenHome) {
        // Close Home Section Re-Retrieve to get new timestamp
        CFAD30SI cfad30si = populateCFAD30SI_Retrieve(context);
        CFAD30SO cfad30so = resource.retrieveNeccessaryInformation(cfad30si);

        state.setAttribute(STR_CFAD30SO, cfad30so, request);
        
        // cfad36s originally called from cfad05w.win
        // Call the CFAD36S Close/Reopen Home Service
        CFAD36SI cfad36si = populateCFAD36SI_U(context, currentStatus, reopenHome);

        // STGAP00007365 Checking to see if this is the supervisor during pending closure pressing the save button
        // if so then we need to call a service to just save the closure information
        SaveFAHomeSupervisorSI saveFAHomeSupervisorsi = populateSaveFAHomeSupervisor(context);

        String cfad36siCdRsrcFaHomeStatusNext = cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(NEXT);
        ArchInputStruct cfad36siArchInputStruct = cfad36si.getArchInputStruct();

        if (CODE_STATUS_PENDING_CLOSURE.equals(cfad36siCdRsrcFaHomeStatusNext)
            && ArchitectureConstants.Y.equals(cfad36siArchInputStruct.getUlSysNbrReserved1())) {
          resource.saveFAHomeSupervisor(saveFAHomeSupervisorsi);
        }else {
          CFAD36SO cfad36so = resource.saveFAHomeCloseReopen(cfad36si);
          
          if(cfad36so.getUlIdEvent() > 0){
            GlobalData.setUlIdEvent(cfad36so.getUlIdEvent(), request);
          }
        }
      }

      state.removeAttribute(IS_SUBMIT, request);
      state.removeAttribute(STR_CFAD07SO, request);
      state.removeAttribute(STR_CFAD30SO, request);
      state.removeAttribute(STR_CFAD37SO, request);
    } catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_FAD_HOME_STUDY_REQ:
      case Messages.ARC_ERR_BAD_FUNC_CD:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        // setPresentationBranch("error", context);
        // setInformationalMessage(Messages.MSG_FAD_HOME_STUDY_REQ,
        // "/fad/HomeInfrmtn/saveSubmitHomeInformation",
        // context.getRequest());
        break;
      case Messages.MSG_SAVE_BEFORE_CLOSE:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        // setPresentationBranch("error", context);
        // setInformationalMessage(Messages.MSG_SAVE_BEFORE_CLOSE,
        // "/fad/HomeInfrmtn/saveSubmitHomeInformation",
        // context.getRequest());
        break;
        // STGAP00013771 Displaying message if user is trying to close home with open placements
      case Messages.MSG_FAD_HOME_WITH_PLACEMENTS:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        break;        
        //SMS#42496
      case Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        break;
      // STGAP00006198 Catching SQL not found execption thrown in Invalidate
      // Approval
      case Messages.SQL_NOT_FOUND:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        break;
      // SMS #81140: MR-074
      case Messages.MSG_FAD_MARITAL_NOT_MATCH_PERSON:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, context.getRequest());
        break;  
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
        processSevereException(context, e);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "save:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is used to determine if the demographics section of the page was changed by the user. If not, the
   * demographics save service should not be called.
   * 
   * @param cfad07so -
   *          the database retrieval service output object
   * @param cfad08si -
   *          the save service input object populated from user input
   * @return - true if the variables on the two objects are different
   */
  private boolean isDemoChanged(CFAD07SO cfad07so, CFAD08SI cfad08si, GrndsExchangeContext context)
                                                                                                   throws CheckboxHelperException {
    // Compare all the editable variables between the objects. A single
    // change requires a save, so short-circuit further processing if found.

    // Adding a new home is an automatic true
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cfad08si.getArchInputStruct().getCReqFuncCd())) {
      return true;
    }

    // Check the top-level object values
    if (StringHelper.isTrue(cfad08si.getCSysIndRsrcPrsChg())) {
      return true;
    }

    // Check demographics row
    ROWCFAD08SIG04 inDemo = cfad08si.getROWCFAD08SIG04();
    ROWCFAD07SOG04 outDemo = cfad07so.getROWCFAD07SOG04();
    /* SIR# 23327. added CertifyEntity to if condition */
    // STGAP00005493: AD Exchg. Status Fields Not Saving or Not Requiring Supervisor Approval on Updates
    if (!objectEqualsSafe(inDemo.getSzCdRshsEthnicity(), outDemo.getSzCdRshsEthnicity())	
        || !objectEqualsSafe(inDemo.getSzNmRshsResource(), outDemo.getSzNmRshsResource())
        || !objectEqualsSafe(inDemo.getSzNmLegal(), outDemo.getSzNmLegal())
        || !objectEqualsSafe(inDemo.getSzCdRshsLanguage(), outDemo.getSzCdRshsLanguage())
        || !objectEqualsSafe(inDemo.getSzCdRshsReligion(), outDemo.getSzCdRshsReligion())
        || inDemo.getDNbrRshsAnnualIncome() != outDemo.getDNbrRshsAnnualIncome()
        || !objectEqualsSafe(inDemo.getSzCdRshsMaritalStatus(), outDemo.getSzCdRshsMaritalStatus())
        || !objectEqualsSafe(inDemo.getDtDtRshsMarriage(), outDemo.getDtDtRshsMarriage())
        || !objectEqualsSafe(inDemo.getCIndRshsNonDFCSHome(), outDemo.getCIndRshsNonDFCSHome())
        || !objectEqualsSafe(inDemo.getSzTxtNdfcsCertEntity(), outDemo.getSzTxtNdfcsCertEntity())
        || !objectEqualsSafe(inDemo.getCIndCurrHomeStudyExists(), outDemo.getCIndCurrHomeStudyExists())
        || !objectEqualsSafe(inDemo.getSzCdRshsRespite(), outDemo.getSzCdRshsRespite())
        || !objectEqualsSafe(inDemo.getCIndPrevFamilyStudyReq(), outDemo.getCIndPrevFamilyStudyReq())
        || !objectEqualsSafe(inDemo.getSzCdSchoolDistrict(), outDemo.getSzCdSchoolDistrict())
        || !objectEqualsSafe(inDemo.getSzCdElementary(), outDemo.getSzCdElementary())
        || !objectEqualsSafe(inDemo.getSzCdMiddle(), outDemo.getSzCdMiddle())
        || !objectEqualsSafe(inDemo.getSzCdHigh(), outDemo.getSzCdHigh())
        || !objectEqualsSafe(inDemo.getSzCdAdExchangeStatus(), outDemo.getSzCdAdExchangeStatus())) {
      return true;
    }

    // Check Home Interest
    ROWCFAD08SIG05 inHI = cfad08si.getROWCFAD08SIG05();
    ROWCFAD07SOG05 outHI = cfad07so.getROWCFAD07SOG05();
    if (!objectEqualsSafe(inHI.getCIndRsrcEmergPlace(), outHI.getCIndRsrcEmergPlace())
        || !objectEqualsSafe(inHI.getCIndRsrcTransport(), outHI.getCIndRsrcTransport())
        || !objectEqualsSafe(inHI.getSzTxtRsrcComments(), outHI.getSzTxtRsrcComments())
        || !objectEqualsSafe(inHI.getTxtHmPrgInterest(), outHI.getTxtHmPrgInterest())
        || inHI.getUNbrRsrcIntFeAgeMax() != outHI.getUNbrRsrcIntFeAgeMax()
        || inHI.getUNbrRsrcIntFeAgeMin() != outHI.getUNbrRsrcIntFeAgeMin()
        || inHI.getUNbrRsrcIntMaAgeMax() != outHI.getUNbrRsrcIntMaAgeMax()
        || inHI.getUNbrRsrcIntMaAgeMin() != outHI.getUNbrRsrcIntMaAgeMin()
        || !inHI.getCIndSpecificChild().equals(outHI.getCIndSpecificChild())) {
      return true;
    }

    // Check for changed checkboxes

    // Programs Of Interest checkboxes
    ROWCFAD07SOG07_ARRAY prgrmsOfInterestArray = new ROWCFAD07SOG07_ARRAY();

    if (cfad07so.getROWCFAD07SOG07_ARRAY() != null) {
      prgrmsOfInterestArray = cfad07so.getROWCFAD07SOG07_ARRAY();
    }

    Collection changedInterestsValues = CheckboxHelper.getChangedValues(context.getRequest(), "PrgmsOfInterestCbx",
                                                                        prgrmsOfInterestArray, ROWCFAD07SOG07.class,
                                                                        "szCdHmApplcntCbx");

    if (changedInterestsValues != null && changedInterestsValues.size() > 0) {
      return true;
    }

    // Child Ethnicities checkboxes
    ROWCFAD07SOG03_ARRAY ethnicitiesArray = new ROWCFAD07SOG03_ARRAY();

    if (cfad07so.getROWCFAD07SOG03_ARRAY() != null) {
      ethnicitiesArray = cfad07so.getROWCFAD07SOG03_ARRAY();
    }

    Collection changedValues = CheckboxHelper.getChangedValues(context.getRequest(), "EthCbx", ethnicitiesArray,
                                                               ROWCFAD07SOG03.class, "szCdFaHomeIntEthnicity");

    if (changedValues != null && changedValues.size() > 0) {
      return true;
    }
   
    //Child Race checkboxes
    HomeRaceSO_ARRAY homeRaceArray = new HomeRaceSO_ARRAY();

    if (cfad07so.getHomeRaceSO_ARRAY() != null) {
      homeRaceArray = cfad07so.getHomeRaceSO_ARRAY();
    }

     Collection changedRaceValues = CheckboxHelper.getChangedValues(context.getRequest(), "RaceCbx", homeRaceArray,
                                                               HomeRaceSO.class, "szCdFaHomeIntRace");

    if (changedRaceValues != null && changedRaceValues.size() > 0) {
      return true;
    }
 
    // Characteristics checkboxes already have a change indicator
    if (StringHelper.isTrue(cfad08si.getCSysIndRsrcCharChg())) {
      return true;
    }
    return false;
  }

  private boolean isHomeApplicantChanged(HomeApplicantRetrieveSO homeApplicantRetrieveSO,
                                         HomeApplicantSaveSI homeApplicantSaveSI, GrndsExchangeContext context)
                                                                                                               throws CheckboxHelperException {

    // Compare all the editable variables between the objects. A single
    // change requires a save, so short-circuit further processing if found.

    // Adding a new home is an automatic true
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(homeApplicantSaveSI.getArchInputStruct().getCReqFuncCd())) {
      return true;
    }

    // Check inquiry information section
    // no need to check on inquiryDate and inquiryRecvdBy
    if (!objectEqualsSafe(homeApplicantSaveSI.getInfoPacktRequested(), homeApplicantRetrieveSO.getInfoPacktRequested())
        || !objectEqualsSafe(homeApplicantSaveSI.getDateApplied(), homeApplicantRetrieveSO.getDtApplied())
        || !objectEqualsSafe(homeApplicantSaveSI.getInfPacktSent(), homeApplicantRetrieveSO.getInfPacktSent())
        || homeApplicantSaveSI.getIRequestedNbrOfChildren() != homeApplicantRetrieveSO.getIRequestedNbrOfChildren()
        || !objectEqualsSafe(homeApplicantSaveSI.getChildSpecInterest(), homeApplicantRetrieveSO.getChildSpecInterest())
        || !objectEqualsSafe(homeApplicantSaveSI.getInquiryComments(), homeApplicantRetrieveSO.getInquiryComments())) {
      return true;
    }

    // Orientation/Preservice section
    if (!objectEqualsSafe(homeApplicantSaveSI.getDtOrientation1(), homeApplicantRetrieveSO.getDtOrientation1())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrOrientationStatus1(),
                             homeApplicantRetrieveSO.getStrOrientationStatus1())
        || !objectEqualsSafe(homeApplicantSaveSI.getDtOrientation2(), homeApplicantRetrieveSO.getDtOrientation2())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrOrientationStatus2(),
                             homeApplicantRetrieveSO.getStrOrientationStatus2())
        || !objectEqualsSafe(homeApplicantSaveSI.getDtOrientation3(), homeApplicantRetrieveSO.getDtOrientation3())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrOrientationStatus3(),
                             homeApplicantRetrieveSO.getStrOrientationStatus3())
        || !objectEqualsSafe(homeApplicantSaveSI.getDtInvitation1(), homeApplicantRetrieveSO.getDtInvitation1())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrInvitationStatus1(),
                             homeApplicantRetrieveSO.getStrInvitationStatus1())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrLocation1(), homeApplicantRetrieveSO.getStrLocation1())
        || !objectEqualsSafe(homeApplicantSaveSI.getDtInvitation2(), homeApplicantRetrieveSO.getDtInvitation2())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrInvitationStatus2(),
                             homeApplicantRetrieveSO.getStrInvitationStatus2())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrLocation2(), homeApplicantRetrieveSO.getStrLocation2())
        || !objectEqualsSafe(homeApplicantSaveSI.getDtInvitation3(), homeApplicantRetrieveSO.getDtInvitation3())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrInvitationStatus3(),
                             homeApplicantRetrieveSO.getStrInvitationStatus3())
        || !objectEqualsSafe(homeApplicantSaveSI.getStrLocation3(), homeApplicantRetrieveSO.getStrLocation3())
        || !objectEqualsSafe(homeApplicantSaveSI.getOrientationComments(),
                             homeApplicantRetrieveSO.getOrientationComments())) {
      return true;
    }

    // Check for changed checkboxes

    // Sources of Inquiry checkboxes
    // ROWCFAD07SOG07_ARRAY srcsOfInquiryArray = new ROWCFAD07SOG07_ARRAY();
    //
    // if (homeApplicantRetrieveSO.getArraySourceOfInquiry() != null) {
    // srcsOfInquiryArray = homeApplicantRetrieveSO.getArraySourceOfInquiry();
    // }
    //
    // Collection changedSrcsOfInqValues = CheckboxHelper.getChangedValues(context.getRequest(), "SrcsOfInquiryCbx",
    // srcsOfInquiryArray, ROWCFAD07SOG07.class,
    // "szCdHmApplcntCbx");
    //
    // if (changedSrcsOfInqValues != null && changedSrcsOfInqValues.size() > 0) {
    // return true;
    // }

    // -- if there are any changes to checkboxes, they have already been determined and populated
    // -- into the save input object by the populateHomeApplicantSaveSI_AU method
    if (homeApplicantSaveSI.getArraySourceOfInquiry().getROWCFAD08SIG07Count() > 0) {
      return true;
    }

    if (homeApplicantSaveSI.getArrayProgramsOfInterest().getROWCFAD08SIG07Count() > 0) {
      return true;
    }

    if (homeApplicantSaveSI.getArrayInformationCovered().getROWCFAD08SIG07Count() > 0) {
      return true;
    }

    return false;

  }

  /**
   * This method is used to determine if the marital status was changed. If it was, then set the indicator to write a
   * history row.
   * 
   * @param cfad07so -
   *          the database retrieval service output object
   * @param cfad08si -
   *          the save service input object populated from user input
   * @return - true if the variables on the two objects are different
   */
  private boolean isMarStatChanged(CFAD07SO cfad07so, CFAD08SI cfad08si, GrndsExchangeContext context) {
    // Check demographics row
    ROWCFAD08SIG04 inDemo = cfad08si.getROWCFAD08SIG04();
    ROWCFAD07SOG04 outDemo = cfad07so.getROWCFAD07SOG04();
    if (!objectEqualsSafe(inDemo.getSzCdRshsMaritalStatus(), outDemo.getSzCdRshsMaritalStatus())) {
      return true;
    }
    return false;
  }

  /**
   * This method is used to determine if the licensing section of the page was changed by the user. If not, the
   * licensing save service should not be called.
   * 
   * @param cfad37so -
   *          the database retrieval service output object
   * @param cfad38si -
   *          the save service input object populated from user input
   * @return - true if the variables on the two objects are different
   */
  private boolean isLicensingChanged(CFAD37SO cfad37so, CFAD38SI cfad38si, GrndsExchangeContext context) {
    // Compare all the editable variables between the objects. A single
    // change requires a save, so short-circuit further processing if found.

    // because the strings aren't guaranteed to be in the same order
    Set oldFosterTypes = getFosterTypeSet(cfad37so.getCCdRsrcFaHomeType1_CFAD37SO());
    Set newFosterTypes = getFosterTypeSet(cfad38si.getCCdRsrcFaHomeType1());
    if (oldFosterTypes != null && (oldFosterTypes.equals(newFosterTypes) == false)) {
      return true;
    }

    boolean wasHabilitative = oldFosterTypes.contains(CODE_HABILITATIVE);
    boolean wasTherapeutic = oldFosterTypes.contains(CODE_THERAPEUTIC);
    boolean wasHTP = wasHabilitative || wasTherapeutic;

    boolean isHabilitative = newFosterTypes.contains(CODE_HABILITATIVE);
    boolean isTherapeutic = newFosterTypes.contains(CODE_THERAPEUTIC);
    boolean isHTP = isHabilitative || isTherapeutic;

    // If Foster Home was previously a basic/group and now contain at least one of the
    // following: habilitative, therapeutic or medical needs OR previously contained one
    // of the aforementioned three types and is now only a basic or group home, set
    // sysIndLocChange to true
    if ((oldFosterTypes.contains(CODE_BASIC)) && (wasHTP == false) && (isHTP)) {
      return true;
    }
    if ((wasHTP) && (!isHTP)) {
      return true;
    }

    String oldCategory = cfad37so.getSzCdRsrcCategory();
    String newCategory = cfad38si.getSzCdRsrcCategory();
    if (oldCategory != null && (!oldCategory.equals(newCategory))) {
      return true;
    }

    int oldMaleMinAge = cfad37so.getUNbrRsrcMlAgeMin();
    int newMaleMinAge = cfad38si.getUNbrRsrcMlAgeMin();
    int oldMaleMaxAge = cfad37so.getUNbrRsrcMlAgeMax();
    int newMaleMaxAge = cfad38si.getUNbrRsrcMlAgeMax();
    if ((oldMaleMinAge != newMaleMinAge) || (oldMaleMaxAge != newMaleMaxAge)) {
      return true;
    }

    int oldFemaleMinAge = cfad37so.getUNbrRsrcFMAgeMin();
    int newFemaleMinAge = cfad38si.getUNbrRsrcFMAgeMin();
    int oldFemaleMaxAge = cfad37so.getUNbrRsrcFMAgeMax();
    int newFemaleMaxAge = cfad38si.getUNbrRsrcFMAgeMax();

    if ((oldFemaleMinAge != newFemaleMinAge) || (oldFemaleMaxAge != newFemaleMaxAge)) {
      return true;
    }

    // If there are any input differences, catch 'em here
    if (cfad37so.getUNbrRsrcFacilCapacity() != cfad38si.getUNbrRsrcFacilCapacity()
        || !objectEqualsSafe(cfad37so.getSzCdRsrcCategory(), cfad38si.getSzCdRsrcCategory())) {
      return true;
    }

    // Logic for "On Hold" checkbox: if the user changed the checkbox, the first
    // character in this hidden param won't be " ".
    String ckOnHold_changed = context.getRequest().getParameter("ckOnHold_changed");
    if (ckOnHold_changed != null && !ckOnHold_changed.startsWith(" ")) {
      return true;
    }

    // HD 6/18/2003 -- If the only licensing change was that the status was moved to close,
    // return false.
    if (!objectEqualsSafe(cfad37so.getSzCdRsrcFaHomeStatus(), cfad38si.getSzCdRsrcFaHomeStatus())
        && !CODE_STATUS_CLOSED.equals(cfad38si.getSzCdRsrcFaHomeStatus())) {
      return true;
    }
    
    // MR-075 Fixed production defect that affect enhancement changes. Change in Approval
    // dates are considered a license change.
    Date dtApprovalBegin = cfad38si.getDtDtApprvlBegin();
    Date dtApprovalEnd = cfad38si.getDtDtApprvlEnd();

    // request value coming in is not null then check if persisted value is the same, if not then license change
    if ((dtApprovalBegin != null && !dtApprovalBegin.equals(cfad37so.getDtDtApprvlBegin()))
                    || (dtApprovalEnd != null && !dtApprovalEnd.equals(cfad37so.getDtDtApprvlEnd()))) {
      return true;
    }           

    return false;
  }

  private boolean objectEqualsSafe(Object first, Object second) {
    if (first == null || StringHelper.EMPTY_STRING.equals(first)) {
      // for the purposes of this comparison, consider null and empty string same
      if (second == null || StringHelper.EMPTY_STRING.equals(second)) {
        return true;
      }
      return false;
    }
    if (first.equals(second)) {
      return true;
    }
    return false;
  }

  public void reloadHomeInfo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".reloadPOC_xa()");
    performanceTrace.enterScope();

    // HttpServletRequest request = context.getRequest();
    // BaseSessionStateManager state = getSessionStateManager(context);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save and Submit' button on F/A Home
   * Information Detail page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveSubmitHomeInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveSubmitHomeInformation_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      state.setAttribute(IS_SUBMIT, "true", request);

      // check to see if the Hold Placements checkbox has been changed.
      CFAD37SO cfad37so = (CFAD37SO) state.getAttribute("CFAD37SO", request);

      String homeStatus = ContextHelper.getStringSafe(context, STATUS_DROPDOWN);
      boolean changeHold = false;
      // -TODO add check for home evaluation document
      boolean evalDocExists = resource.checkEvalDocExists(GlobalData.getUlIdStage(request));
      
      //STGAP00007414 When entering a home in the system the user is forced to launch the form when 
      // going from Applicant to one of the 3 Pending Status.  We should only ask them then so if we
      // have a conversion home in anything past Applicant we will be able to proceed.  
      if (!evalDocExists && CODE_STATUS_APPLICANT.equals(cfad37so.getSzCdRsrcFaHomeStatus())) {
        setPresentationBranch("HOME_INFRMTN", context);
        // retrieveSO = populateSelects(context, retrieveSO);
        // state.setAttribute("pocRetrieve", retrieveSO, request);
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_FAD_HOME_STUDY_REQ), request);
      }
      else{
        save(context);

        // MR-075 Should not set the GlobalData.UIdEvent, this is pulling wrong event id after rejected closure and resubmit.
        // HD 6/4/2003 -- SIR 17673
//        int eventID = CaseUtility.getEvent(GlobalData.getUlIdStage(request), HomeInfrmtnConversation.TASK_MNTN_LIC)
//                                 .getIdEvent();
//
//        GlobalData.setUlIdEvent(eventID, request);

        EventIdStruct_ARRAY eventArray = new EventIdStruct_ARRAY();
        EventIdStruct event = new EventIdStruct();

        event.setUlIdEvent(GlobalData.getUlIdEvent(request));
        eventArray.addEventIdStruct(event);

        String holdPlacementsCurrent = ContextHelper.getStringSafe(request, "ckOnHold");
        String holdPlacementsPrev = "";

        if (ArchitectureConstants.Y.equals(cfad37so.getBIndHoldPlacements())) {
          holdPlacementsPrev = "on";
        }

        if (holdPlacementsCurrent != null && (!holdPlacementsCurrent.equals(holdPlacementsPrev))) {
          changeHold = true;
        }

        String taskCode = TASK_APPROVE_HOME_LICENSE;

        if (CODE_STATUS_PENDING_CLOSURE.equals(homeStatus)) {
          taskCode = TASK_APPROVE_HOME_CLOSURE;
          // MR-075 Should not set the GlobalData.UIdEvent, this is pulling wrong event id after rejected closure and resubmit.
//          // SIR 18623 If we are closing the home, get the event for closing the home to sumbit
//          GlobalData.setUlIdEvent(CaseUtility.getEvent(GlobalData.getUlIdStage(request), TASK_CLOSE_HOME).getIdEvent(),
//                                  request);
        }
        // if Hold Placements has changed and Status hasn't Task needs to be TASK_CHANGE_HOLD_PLACEMENTS
        if (changeHold
            && (CODE_STATUS_APPROVED_FULL_ACTIVE.equals(homeStatus)
                || CODE_STATUS_APPROVED_SPEC_ACTIVE.equals(homeStatus) 
                || CODE_STATUS_APPROVED_TEMP_ACTIVE.equals(homeStatus))) {
          taskCode = TASK_CHANGE_HOLD_PLACEMENTS;
        }
        
        // JMC - 08/12/2003 - SIR 19309. In CAPs the To Do Detail page set the Conclusion
        // event status to pend. In IMPACT the To Do Detail page will not be able to do this,
        // therefore we set the event status to PEND before forwarding onto the ToDoConversation.
        
        // 11/04/2008  STGAP00009881 In Georgia Shines The event status is being updated in the ToDoConversation.  Doing it here 
        // is causing problems when a error is thrown.  
        //        eventUtility.updateEventStatus(Arrays.asList(new CaseUtility.Event(GlobalData.getUlIdEvent(request),
        //                                                                           CodesTables.CEVTSTAT_PEND)));
        // JMC

        // Set data for ToDo Detail page
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                     GlobalData.getUlIdStage(request), taskCode);
        
        // MR-075 Need to properly change Approval description based on current home status
        if(TASK_APPROVE_HOME_LICENSE.equals(taskCode)){
          String szTxtTodoDesc = "Approve Home Status change to ";

          if (CodesTables.CFAHMSTA_PFA.equals(homeStatus)) {
            szTxtTodoDesc = szTxtTodoDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_AFA);
          } else if (CodesTables.CFAHMSTA_PSA.equals(homeStatus)) {
            szTxtTodoDesc = szTxtTodoDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_ASA);
          } else if (CodesTables.CFAHMSTA_PTA.equals(homeStatus)) {
            szTxtTodoDesc = szTxtTodoDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_ATA);
          } else if (CodesTables.CFAHMSTA_PFG.equals(homeStatus)) {
            szTxtTodoDesc = szTxtTodoDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_FLG);
          } else if (CodesTables.CFAHMSTA_PSG.equals(homeStatus)) {
            szTxtTodoDesc = szTxtTodoDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_FSG);
          } else if (CodesTables.CFAHMSTA_PUN.equals(homeStatus)) {
            szTxtTodoDesc = szTxtTodoDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_AUN);
          } else {
            // if none of the above stick with default 'Approve Home Evalation'
            szTxtTodoDesc = toDoDetailDB.getSzTxtTodoDesc();
          }

          toDoDetailDB.setSzTxtTodoDesc(szTxtTodoDesc);
        }
        
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

        /*
         * SIR 18803 - When the page has errors the redisplay wasn't displaying the Address or Phone information because
         * we erroneously had cleared the objects from State.
         */
      }
      state.removeAttribute(IS_SUBMIT, request);
      /*
       * state.removeAttribute(STR_CFAD07SO, request); state.removeAttribute(STR_CFAD30SO, request);
       * state.removeAttribute(STR_CFAD37SO, request);
       */
    } catch (Exception e) {
      handleException(e, context, "saveSubmitHomeInformation_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save and Assign' button on Add Home page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveAssignHomeInformation_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveAssignHomeInformation_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CFAD08SI cfad08si = populateCFAD08SI_AU(context, ServiceConstants.REQ_FUNC_CD_ADD, EVENT_STATUS_COMP);
      /* MR-066 - Check to see if an existing home has the name or address
       * of a home being saved. Perform check only when the indicator is not set to 'N'
       */
      String indReturnFromNameCheck = ContextHelper.getStringSafe(context, "hdnBSysIndPrfrmNameCheck");
      if (!ArchitectureConstants.N.equals(indReturnFromNameCheck)) {
        checkDuplicateHomeNameAddress(context, cfad08si);
      }
      CFAD08SO cfad08so = resource.saveHomeDemographics(cfad08si);

      GlobalData.setUlIdStage(cfad08so.getUlIdStage(), request);
      GlobalData.setUlIdEvent(cfad08so.getUlIdEvent(), request);
      // HD 6/18/2003 -- SIR Request
      GlobalData.setUlIdCase(CaseUtility.getStage(GlobalData.getUlIdStage(request)).getIdCase(), request);
      GlobalData.setSzCdStage(FAD, request);
      GlobalData.setSzCdStageProgram(CPS, request);

      int[] stageIdArray = { GlobalData.getUlIdStage(request) };
      request.setAttribute(AssignConversation.STAGE_ID_ARRAY, stageIdArray);

      // save inquiry information and orientation preservice subsection
      HomeApplicantSaveSI homeApplicantSaveSI = populateHomeApplicantSaveSI_AU(context,
                                                                               ServiceConstants.REQ_FUNC_CD_ADD,
                                                                               cfad08so.getUlIdResource());
      resource.saveHomeApplicantInfo(homeApplicantSaveSI);

      state.removeAttribute(IS_SUBMIT, request);
      state.removeAttribute(STR_CFAD07SO, request);
      state.removeAttribute(STR_CFAD30SO, request);
      state.removeAttribute(STR_CFAD37SO, request);
    } catch (Exception e) {
      handleException(e, context, "saveAssignHomeInformation_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save and Assign' button on Home Information
   * page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void reopenAssignHomeInformation_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "reopenAssignHomeInformation_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // 08/28/2003, Matthew McClain
      // found this was a problem treated as a process severe exception
      // when you try to "save and assign" a Closed stage
      // (which is essentially already closed)
      String newStatus = ContextHelper.getStringSafe(context, STATUS_DROPDOWN);
      if (CODE_STATUS_CLOSED.equals(newStatus)) {
        throw new ServiceException(Messages.MSG_CMN_STAGE_CLOSED);
      }
      save(context);

      // Format data for reopen home and forward to assign window
      int[] stageIdArray = { GlobalData.getUlIdStage(request) };
      request.setAttribute(AssignConversation.STAGE_ID_ARRAY, stageIdArray);

      state.removeAttribute(IS_SUBMIT, request);
      state.removeAttribute(STR_CFAD07SO, request);
      state.removeAttribute(STR_CFAD30SO, request);
      state.removeAttribute(STR_CFAD37SO, request);

      // so AssignConversation knows we're coming from FAD and knows to go back to display
      state.setAttribute(AssignConversation.PREVIOUS_URL, DISPLAY_URL, request);
    } catch (Exception e) {
      handleException(e, context, "reopenAssignHomeInformation_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save' button on Phone Detail page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void savePhoneDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "savePhoneDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      String funcCode = ServiceConstants.REQ_FUNC_CD_ADD;
      if (state.getAttribute(CURRENT_PHONE, request) != null) {
        funcCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
      }

      CFAD08SI cfad08si = populateCFAD08SI_Phone(context, funcCode);
      CFAD08SO cfad08so = resource.saveHomeDemographics(cfad08si);
      if(cfad08so.getUlIdEvent() > 0){
        GlobalData.setUlIdEvent(cfad08so.getUlIdEvent(), request);
      }

      state.removeAttribute(CURRENT_PHONE, request);
    } catch (Exception e) {
      handleException(e, context, "savePhoneDetail_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save' button on Address Detail page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveAddressDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveAddressDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      String funcCode = ServiceConstants.REQ_FUNC_CD_ADD;
      if (state.getAttribute(CURRENT_ADDRESS, request) != null) {
        funcCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
      }

      CFAD08SI cfad08si = populateCFAD08SI_Address(context, funcCode);

      // SPB - SIR 19424 - Handling validation of duplicate address and vendor id
      if (cfad08si == null) {
        // set error branch such that error displays on Address Detail
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        return;
      }

      CFAD08SO cfad08so = resource.saveHomeDemographics(cfad08si);
      if(cfad08so.getUlIdEvent() > 0){
        GlobalData.setUlIdEvent(cfad08so.getUlIdEvent(), request);
      }

      state.removeAttribute(CURRENT_ADDRESS, request);
    } catch (Exception e) {
      handleException(e, context, "saveAddressDetail_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Add' button on Phone List section of Home
   * Information page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addPhone_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addPhone_xa");
    performanceTrace.enterScope();

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Add' button on Address List section of Home
   * Information page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addAddress_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addAddress_xa");
    performanceTrace.enterScope();
    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by the saveHomeInformation_xa to populate the input object for the cfad08s save
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private CFAD08SI populateCFAD08SI_AU(GrndsExchangeContext context, String funcCode, String nextStatus)
                                                                                                        throws CheckboxHelperException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD08SI_AU");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get today's date
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new Date());
    Date tsToday = new Date();

    CFAD07SO cfad07so = (CFAD07SO) state.getAttribute(STR_CFAD07SO, request);
    if (cfad07so == null) {
      cfad07so = new CFAD07SO();
    }

    Date timestamp = tsToday;
    if (StringHelper.isValid(ContextHelper.getString(context, "timestamp"))) {
      timestamp = ContextHelper.getJavaDateSafe(context, "timestamp");
    }

    ROWCFAD08SIG04 demographics = new ROWCFAD08SIG04();
    ROWCFAD08SIG05 homeInterest = new ROWCFAD08SIG05();
    CFAD08SI cfad08si = new CFAD08SI();
    ROWCFAD08SIG06 rowcfad08sig06 = new ROWCFAD08SIG06();
    ArchInputStruct input = new ArchInputStruct();
    ROWCFAD08SIG00 rowcfad08sig00 = new ROWCFAD08SIG00();
    ROWCFAD08SIG01 primary = new ROWCFAD08SIG01();
    ROWCFAD08SIG01 business = new ROWCFAD08SIG01();
    ROWCFAD08SIG00_ARRAY rowcfad08sig00_array = new ROWCFAD08SIG00_ARRAY();
    ROWCFAD08SIG01_ARRAY rowcfad08sig01_array = new ROWCFAD08SIG01_ARRAY();
    ROWCFAD08SIG03_ARRAY ethArray = new ROWCFAD08SIG03_ARRAY();
    HomeRaceSI_ARRAY raceSIArray = new HomeRaceSI_ARRAY();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(funcCode);
    // HD 6/5/2003 -- Approval Status SIR 17673
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    input.setSzUserId(getUserLogonID(request));

    cfad08si.setArchInputStruct(input);

    // -- use AddressBean
    String addressSubmoduleName1 = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME + "1");
    AddressBean addressBean1 = AddressBean.getFromRequest(addressSubmoduleName1, request);
    if (addressBean1 == null) {
      addressBean1 = new AddressBean();
    }

    // String countyName1 = "NEW_HOME1_"+AddressBean.COUNTY; //-- see variable of same name in NewHomeInfrmtn.jsp
    String countyName1 = addressBean1.getAttributeName(AddressBean.COUNTY);
    String region = getRegionFromCounty(request, ContextHelper.getStringSafe(request, countyName1));
    cfad08si.setSzCdCntrctRegion(region);
    cfad08si.setBIndEndDateMod(cfad07so.getBIndEndDateMod());
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)) {
      cfad08si.setUlIdResource(cfad07so.getUlIdResource());
    } else {
      cfad08si.setUlIdResource(0);
    }

    cfad08si.setUlIdCntrctWkr(getUserID(request));

    // changed to/from NON-DFCS Adoptive home
    String prsChanged = StringHelper.EMPTY_STRING;
    String didPrsChange = ContextHelper.getStringSafe(context, "prsChange");
    if (!StringHelper.EMPTY_STRING.equals(didPrsChange)) {
      prsChanged = IND_YES;
    } else
      prsChanged = IND_NO;
    String didCategoryChange = ContextHelper.getStringSafe(context, "categoryChanged");
    String categoryChanged = StringHelper.EMPTY_STRING;
    if (!StringHelper.EMPTY_STRING.equals(didCategoryChange)) {
      categoryChanged = IND_YES;
    } else
      categoryChanged = IND_NO;

    String didFosterTypesChange = ContextHelper.getStringSafe(context, "categoryChanged");
    String fosterTypesChanged = StringHelper.EMPTY_STRING;
    if (!StringHelper.EMPTY_STRING.equals(didFosterTypesChange)) {
      fosterTypesChanged = IND_YES;
    } else
      fosterTypesChanged = IND_NO;

    cfad08si.setCSysIndRsrcPrsChg(prsChanged);
    cfad08si.setCSysIndCategoryChange(categoryChanged);
    cfad08si.setCSysIndFosterTypeChange(fosterTypesChanged);
    cfad08si.setDtSysDtGenericSysdate(today);
    // set this to No for now. It will be changed if
    // approved age changed when setting values for home interest below
    cfad08si.setBSysIndAgeChange(ArchitectureConstants.N);

    SzCdEventStatus_ARRAY statusArray = new SzCdEventStatus_ARRAY();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)) {
      if (GlobalData.getUlIdStage(request) != 0) {
        statusArray.addSzCdEventStatus(EVENT_STATUS_COMP);
      } else {
        statusArray.addSzCdEventStatus(StringHelper.EMPTY_STRING);
      }
    } else {
      statusArray.addSzCdEventStatus(cfad07so.getROWCFAD07SOG06().getSzCdEventStatus());
    }
    statusArray.addSzCdEventStatus(NEXT, nextStatus);
    cfad08si.setSzCdEventStatus_ARRAY(statusArray);

    // This is set to blank in CAPS...
    SzCdRsrcStatus_ARRAY resourceStatusArray = new SzCdRsrcStatus_ARRAY();
    resourceStatusArray.addSzCdRsrcStatus(StringHelper.EMPTY_STRING);
    resourceStatusArray.addSzCdRsrcStatus(StringHelper.EMPTY_STRING);
    cfad08si.setSzCdRsrcStatus_ARRAY(resourceStatusArray);

    // Home Demographics Section
    // SIR 19033 -- Saves the txtHomeName to upper case.
    String homeName = FormattingHelper.changeCase(ContextHelper.getStringSafe(context, "txtHomeName"));
    // truncating to 25 chars if string > 25chars
    if (!StringHelper.EMPTY_STRING.equals(homeName) && homeName.length() > 25) {
      homeName = homeName.substring(0, 25);
    }
    String legalName = ContextHelper.getStringSafe(context, "txtLegalName");
    String category = ContextHelper.getStringSafe(context, "selCategory");
    String language = ContextHelper.getStringSafe(context, "selLanguage");
    String religion = ContextHelper.getStringSafe(context, "selReligion");
    String adExchangeStatus = ContextHelper.getStringSafe(context, "selAdExchStatus");
    String schoolDistrict = ContextHelper.getStringSafe(context, "selSchoolDistrict");
    String elementary = ContextHelper.getStringSafe(context, "selSzCdElementary");
    String middle = ContextHelper.getStringSafe(context, "selSzCdMiddle");
    String high = ContextHelper.getStringSafe(context, "selSzCdHigh");
    double annualIncome = ContextHelper.getMoneyAsDoubleSafe(context, "txtAnnualIncome");
    String maritalStatus = ContextHelper.getStringSafe(context, "selMaritalStatus");
    /* SIR# 23327. added CertifyEntity */
    String certifyEntity = ContextHelper.getStringSafe(context, "txtSzCertifyEntity");
    String dtMarriage = ContextHelper.getStringSafe(request, "marriageDate");
    org.exolab.castor.types.Date marriageDate = null;
    if (!StringHelper.EMPTY_STRING.equals(dtMarriage)) {
      marriageDate = DateHelper.toCastorDateSafe(dtMarriage);
    }

    String status = ContextHelper.getStringSafe(context, STATUS_DROPDOWN);
    String respite = ContextHelper.getStringSafe(context, "selRespite");
    // Add to input object
    demographics.setSzNmRshsResource(homeName);
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)) {
      demographics.setSzCdRshsCategory(category);
    } else {
      demographics.setSzCdRshsCategory(cfad07so.getROWCFAD07SOG04().getSzCdRshsCategory());
    }
    demographics.setSzCdRshsFaHomeStatus(status);
    demographics.setSzCdRshsLanguage(language);
    demographics.setSzCdRshsReligion(religion);
    demographics.setSzNmLegal(legalName);
    demographics.setSzCdRshsRegion(region);
    demographics.setDNbrRshsAnnualIncome(annualIncome);
    demographics.setSzCdRshsMaritalStatus(maritalStatus);
    demographics.setDtDtRshsMarriage(marriageDate);
    demographics.setSzCdAdExchangeStatus(adExchangeStatus);
    demographics.setSzCdSchoolDistrict(schoolDistrict);
    demographics.setSzCdElementary(elementary);
    demographics.setSzCdMiddle(middle);
    demographics.setSzCdHigh(high);
    demographics.setSzCdRshsRespite(respite);
    demographics.setCIndRshsCareProv(IND_NO);
    demographics.setCIndWaiver(CheckboxHelper.getCheckboxValue(request, "chkWaiverExists"));
    demographics.setCIndCurrHomeStudyExists(CheckboxHelper.getCheckboxValue(request, "chkIndCurrHomeStudyExists"));
    demographics.setCIndRshsNonDFCSHome(CheckboxHelper.getCheckboxValue(request, "chkIndNonDFCSHome"));
    /* SIR# 23327. added CertifyEntity */
    demographics.setSzTxtNdfcsCertEntity(certifyEntity);
    demographics.setTsLastUpdate(timestamp);
    demographics.setCIndPrevFamilyStudyReq(CheckboxHelper.getCheckboxValue(request, "chkIndPrevHomeStudy"));

    // Home Interest Section
    int minMaleYearInt = ContextHelper.getIntSafe(context, "selMaleMinYearInt");
    int minMaleMonthInt = ContextHelper.getIntSafe(context, "selMaleMinMonthInt");
    int maleMinimumAgeInMonths = (minMaleYearInt * 12) + minMaleMonthInt;
    int maxMaleYearInt = ContextHelper.getIntSafe(context, "selMaleMaxYearInt");
    int maxMaleMonthInt = ContextHelper.getIntSafe(context, "selMaleMaxMonthInt");
    int maleMaximumAgeInMonths = (maxMaleYearInt * 12) + maxMaleMonthInt;
    int minFemaleYearInt = ContextHelper.getIntSafe(context, "selFemaleMinYearInt");
    int minFemaleMonthInt = ContextHelper.getIntSafe(context, "selFemaleMinMonthInt");
    int femaleMinimumAgeInMonths = (minFemaleYearInt * 12) + minFemaleMonthInt;
    int maxFemaleYearInt = ContextHelper.getIntSafe(context, "selFemaleMaxYearInt");
    int maxFemaleMonthInt = ContextHelper.getIntSafe(context, "selFemaleMaxMonthInt");
    int femaleMaximumAgeInMonths = (maxFemaleYearInt * 12) + maxFemaleMonthInt;
    String willTransport = "N";
    if (!StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(context, "ckWillTransport"))) {
      willTransport = ArchitectureConstants.Y;
    }
    String emergencyPlacement = "N";
    if (!StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(context, "ckEmergPlacement"))) {
      emergencyPlacement = ArchitectureConstants.Y;
    }
    String comments = ContextHelper.getStringSafe(context, "txtComments");
    String txtHmPrgInterest = ContextHelper.getStringSafe(context, "txtHmPrgInterest");
    String specificChildren = ArchitectureConstants.N;
    if (!StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(context, "chkSpecChildren"))) {
      specificChildren = ArchitectureConstants.Y;
    }
    homeInterest.setCIndSpecificChild(specificChildren);
    homeInterest.setUNbrRsrcIntFeAgeMax(femaleMaximumAgeInMonths);
    homeInterest.setUNbrRsrcIntFeAgeMin(femaleMinimumAgeInMonths);
    homeInterest.setUNbrRsrcIntMaAgeMax(maleMaximumAgeInMonths);
    homeInterest.setUNbrRsrcIntMaAgeMin(maleMinimumAgeInMonths);
    homeInterest.setCIndRsrcTransport(willTransport);
    homeInterest.setCIndRsrcEmergPlace(emergencyPlacement);
    homeInterest.setSzTxtRsrcComments(comments);
    homeInterest.setTxtHmPrgInterest(txtHmPrgInterest);
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)) {
      homeInterest.setUNbrRsrcFMAgeMax(0);
      homeInterest.setUNbrRsrcFMAgeMin(0);
      homeInterest.setUNbrRsrcMlAgeMin(0);
      homeInterest.setUNbrRsrcMlAgeMax(0);
    } else {
      // check if age changed before setting approved age ranges
      int minMaleYear = ContextHelper.getIntSafe(context, "selMaleMinYear");
      int minMaleMonth = ContextHelper.getIntSafe(context, "selMaleMinMonth");
      int iApprvdMlAgeMin = (minMaleYear * 12) + minMaleMonth;
      int maxMaleYear = ContextHelper.getIntSafe(context, "selMaleMaxYear");
      int maxMaleMonth = ContextHelper.getIntSafe(context, "selMaleMaxMonth");
      int iApprvdMlAgeMax = (maxMaleYear * 12) + maxMaleMonth;
      int minFemaleYear = ContextHelper.getIntSafe(context, "selFemaleMinYear");
      int minFemaleMonth = ContextHelper.getIntSafe(context, "selFemaleMinMonth");
      int iApprvdFmAgeMin = (minFemaleYear * 12) + minFemaleMonth;
      int maxFemaleYear = ContextHelper.getIntSafe(context, "selFemaleMaxYear");
      int maxFemaleMonth = ContextHelper.getIntSafe(context, "selFemaleMaxMonth");
      int iApprvdFmAgeMax = (maxFemaleYear * 12) + maxFemaleMonth;

      if (iApprvdMlAgeMin != cfad07so.getROWCFAD07SOG05().getUNbrRsrcMlAgeMin()
          || iApprvdMlAgeMax != cfad07so.getROWCFAD07SOG05().getUNbrRsrcMlAgeMax()
          || iApprvdFmAgeMin != cfad07so.getROWCFAD07SOG05().getUNbrRsrcFMAgeMin()
          || iApprvdFmAgeMax != cfad07so.getROWCFAD07SOG05().getUNbrRsrcMlAgeMax()) {
        cfad08si.setBSysIndAgeChange(ArchitectureConstants.Y);
      }
      homeInterest.setUNbrRsrcFMAgeMax(cfad07so.getROWCFAD07SOG05().getUNbrRsrcFMAgeMax());
      homeInterest.setUNbrRsrcFMAgeMin(cfad07so.getROWCFAD07SOG05().getUNbrRsrcFMAgeMin());
      homeInterest.setUNbrRsrcMlAgeMin(cfad07so.getROWCFAD07SOG05().getUNbrRsrcMlAgeMin());
      homeInterest.setUNbrRsrcMlAgeMax(cfad07so.getROWCFAD07SOG05().getUNbrRsrcMlAgeMax());
    }

    // Child Ethnicities checkboxes
    ROWCFAD07SOG03_ARRAY ethnicitiesArray = new ROWCFAD07SOG03_ARRAY();

    if (cfad07so.getROWCFAD07SOG03_ARRAY() != null) {
      ethnicitiesArray = cfad07so.getROWCFAD07SOG03_ARRAY();
    }
    Collection<ObjectActionCodePair> changedValues = CheckboxHelper.getChangedValues(request, "EthCbx", ethnicitiesArray,
            ROWCFAD07SOG03.class, "szCdFaHomeIntEthnicity");

   
    Iterator<ObjectActionCodePair> i = changedValues.iterator();

    while (i.hasNext()) {
      ObjectActionCodePair pair = i.next();
      ROWCFAD07SOG03 ethnicityRow = (ROWCFAD07SOG03) pair.getObject();
      ROWCFAD08SIG03 anEthnicity = new ROWCFAD08SIG03();

      anEthnicity.setSzCdFaHomeIntEthnicity(ethnicityRow.getSzCdFaHomeIntEthnicity());
      anEthnicity.setSzCdSysDataActionOutcome(pair.getActionCode());
      anEthnicity.setTsLastUpdate(ethnicityRow.getTsLastUpdate());

      ethArray.addROWCFAD08SIG03(anEthnicity);
    }
    // Set the array into the parent struct
    cfad08si.setROWCFAD08SIG03_ARRAY(ethArray);

    // Child Race checkboxes
    HomeRaceSO_ARRAY racesArray = new HomeRaceSO_ARRAY();
    if (cfad07so.getHomeRaceSO_ARRAY() != null) {
      racesArray = cfad07so.getHomeRaceSO_ARRAY();
    }
    
    Collection<ObjectActionCodePair> changedRaceValues = CheckboxHelper.getChangedValues(request, "RaceCbx", racesArray,
                                                                                       HomeRaceSO.class, "szCdFaHomeIntRace");

    Iterator<ObjectActionCodePair> r = changedRaceValues.iterator();

    while (r.hasNext()) {
      ObjectActionCodePair pair = r.next();
      HomeRaceSO raceRow = (HomeRaceSO) pair.getObject();
      HomeRaceSI aRace = new HomeRaceSI();

      aRace.setSzCdFaHomeIntRace(raceRow.getSzCdFaHomeIntRace());
      aRace.setSzCdSysDataActionOutcome(pair.getActionCode());
      aRace.setTsLastUpdate(raceRow.getTsLastUpdate());

      raceSIArray.addHomeRaceSI(aRace);
    }
    // Set the array into the parent struct
    cfad08si.setHomeRaceSI_ARRAY(raceSIArray);
    
    
    // Child Characteristics checkboxes
    ROWCFAD08SIG02_ARRAY charInputArray = new ROWCFAD08SIG02_ARRAY();
    ROWCFAD07SOG02_ARRAY characteristicsArray = new ROWCFAD07SOG02_ARRAY();
    if (cfad07so.getROWCFAD07SOG02_ARRAY() != null) {
      characteristicsArray = cfad07so.getROWCFAD07SOG02_ARRAY();
    }

    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "CharCbx");

    Collection<ObjectActionCodePair> changedValues1 = CheckboxHelper.getChangedValues(request, "CharCbx", characteristicsArray,
                                                                ROWCFAD07SOG02.class, "szCdRsrcCharChrctr");

    // Have characteristics changed?
    String charChanged = StringHelper.EMPTY_STRING;
    if (changedValues1.size() > 0) {
      charChanged = ArchitectureConstants.Y;
    }
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)) {
      cfad08si.setCSysIndRsrcCharChg(charChanged);
    } else {
      cfad08si.setCSysIndRsrcCharChgNoSvc(charChanged);
    }

    Map charHash = (Map) state.getAttribute("charHash", request);

    int arrayLength = checkedValues.length;
    int count = 0;
    String charCode;
    while (count < arrayLength) {
      ROWCFAD08SIG02 aCharacteristic = new ROWCFAD08SIG02();
      charCode = checkedValues[count];
      aCharacteristic.setSzCdRsrcCharChrctr(charCode);
      org.exolab.castor.types.Date dateAdded = today;
      if (charHash != null) {
        if (charHash.containsKey(charCode)) {
          ROWCFAD07SOG02 outputCharacteristic = (ROWCFAD07SOG02) charHash.get(charCode);
          dateAdded = outputCharacteristic.getDtDtRsrcCharDateAdded();
        }
      }
      aCharacteristic.setDtDtRsrcCharDateAdded(dateAdded);
      charInputArray.addROWCFAD08SIG02(aCharacteristic);
      count++;
    }
    // Set the array into the parent struct
    cfad08si.setROWCFAD08SIG02_ARRAY(charInputArray);

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)) {
      // Primary Address section
      String addressType;
      int addressID;
      String addrAttn;
      String addressLine1;
      String addressLine2;
      String countyCD;
      String addressState;
      String zip;
      String suffix;
      String zipAndSuffix;
      String addrCity;
      String addressComment;
      // String schoolAddrDistrict;
      String vendorID;
      double nbrRsrcAddrLat;
      double nbrRsrcAddrLong;
      addressType = ContextHelper.getStringSafe(request, "selCdRsrcAddrType");
      vendorID = ContextHelper.getStringSafe(request, "txtNbrRsrcAddrVid");
      addrAttn = ContextHelper.getStringSafe(request, "txtSzAddrRsrcAddrAttn");

      // -- use AddressBean
      // String addressSubmoduleName1 = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME+"1");
      // AddressBean addressBean1 = AddressBean.getFromRequest(addressSubmoduleName1, request);

      addressLine1 = addressBean1.getAddress1();
      addressLine2 = addressBean1.getAddress2();
      addrCity = addressBean1.getCity();
      addressState = addressBean1.getState();
      zip = addressBean1.getZip();
      suffix = addressBean1.getZipSuff();
      if (StringHelper.isValid(suffix)) {
        zipAndSuffix = zip + "-" + suffix;
      } else {
        zipAndSuffix = zip;
      }
      countyCD = addressBean1.getCounty();
      addressComment = ContextHelper.getStringSafe(request, "txtszTxtRsrcAddrComments");
      addressID = ContextHelper.getIntSafe(request, "iUlIdRsrcAddress");
      nbrRsrcAddrLat = ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLat");
      nbrRsrcAddrLong = ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLong");

      // Add to input object
      primary.setSzAddrRsrcAddrAttn(addrAttn);
      primary.setSzAddrRsrcAddrCity(addrCity);
      primary.setSzAddrRsrcAddrStLn1(addressLine1);
      primary.setSzAddrRsrcAddrStLn2(addressLine2);
      primary.setSzAddrRsrcAddrZip(zipAndSuffix);
      primary.setSzCdFacilityCounty(countyCD);
      primary.setSzCdFacilityState(addressState);
      primary.setSzCdRsrcAddrType(addressType);
      primary.setUlIdRsrcAddress(addressID);
      primary.setSzNbrRsrcAddrVid(vendorID);
      primary.setSzTxtRsrcAddrComments(addressComment);
      primary.setTsLastUpdate(tsToday);
      primary.setSzCdSysDataActionOutcome(funcCode);
      primary.setNbrRsrcAddrLat(nbrRsrcAddrLat);
      primary.setNbrRsrcAddrLong(nbrRsrcAddrLong);

      // Add the struct to the array
      rowcfad08sig01_array.addROWCFAD08SIG01(primary);

      // -- use AddressBean
      String addressSubmoduleName2 = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME + "2");
      AddressBean addressBean2 = AddressBean.getFromRequest(addressSubmoduleName2, request);
      if (addressBean2 == null) {
        // -- should never happen; possibly throw error
        addressBean2 = new AddressBean();
      }

      String addressLine1B = addressBean2.getAddress1();

      if (StringHelper.isValid(addressLine1B)) {
        // Business Address section
        String addressTypeB;
        int addressIDB;
        String addrAttnB;
        String addressLine2B;
        String countyCDB;
        String addressStateB;
        String zipB;
        String suffixB;
        String zipAndSuffixB;
        String addrCityB;
        String addressCommentB;
        String vendorIDB;
        double nbrRsrcAddrLatB;
        double nbrRsrcAddrLongB;

        addrAttnB = ContextHelper.getStringSafe(request, "txtSzAddrRsrcAddrAttnB");
        addressLine2B = addressBean2.getAddress2();
        zipB = addressBean2.getZip();
        suffixB = addressBean2.getZipSuff();
        if (StringHelper.isValid(suffixB)) {
          zipAndSuffixB = zipB + "-" + suffixB;
        } else {
          zipAndSuffixB = zipB;
        }
        addrCityB = addressBean2.getCity();
        addressStateB = addressBean2.getState();
        countyCDB = addressBean2.getCounty();
        vendorIDB = ContextHelper.getStringSafe(request, "txtNbrRsrcAddrVidB");
        addressCommentB = ContextHelper.getStringSafe(request, "txtszTxtRsrcAddrCommentsB");
        addressTypeB = ContextHelper.getStringSafe(request, "selCdRsrcAddrTypeB");
        addressIDB = ContextHelper.getIntSafe(request, "iUlIdRsrcAddressB");
        nbrRsrcAddrLatB = ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLatB");
        nbrRsrcAddrLongB = ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLongB");

        business.setSzAddrRsrcAddrAttn(addrAttnB);
        business.setSzAddrRsrcAddrCity(addrCityB);
        business.setSzAddrRsrcAddrStLn1(addressLine1B);
        business.setSzAddrRsrcAddrStLn2(addressLine2B);
        business.setSzAddrRsrcAddrZip(zipAndSuffixB);
        business.setSzCdFacilityCounty(countyCDB);
        business.setSzCdFacilityState(addressStateB);
        business.setSzCdRsrcAddrType(addressTypeB);
        business.setUlIdRsrcAddress(addressIDB);
        business.setSzNbrRsrcAddrVid(vendorIDB);
        business.setSzTxtRsrcAddrComments(addressCommentB);
        business.setTsLastUpdate(tsToday);
        business.setSzCdSysDataActionOutcome(funcCode);
        business.setNbrRsrcAddrLat(nbrRsrcAddrLatB);
        business.setNbrRsrcAddrLong(nbrRsrcAddrLongB);

        rowcfad08sig01_array.addROWCFAD08SIG01(business);
      } // end if business address line 1 is not blank

      // Set the array into the parent struct
      cfad08si.setROWCFAD08SIG01_ARRAY(rowcfad08sig01_array);

      // Phone Section
      String phoneType;
      int phoneID;
      String phoneNumber;
      String extension;
      String phoneComment;

      phoneType = ContextHelper.getStringSafe(request, "selSzCdFacilPhoneType");
      timestamp = ContextHelper.getJavaDateSafe(request, TXT_TS_LAST_UPDATE);
      phoneID = ContextHelper.getIntSafe(request, "IdResourcePhone");
      phoneNumber = ContextHelper.getPhone(request, "txtLNbrFacilPhoneNumber");
      extension = ContextHelper.getStringSafe(request, "txtLNbrFacilPhoneExtension");
      phoneComment = ContextHelper.getStringSafe(request, "txtszTxtRsrcPhoneComments");

      // Add to input object
      // SIR 22684 - Since phone no longer required on INQUIRY status, do not create phone row unless
      // phone number exists.
      if (!StringHelper.EMPTY_STRING.equals(phoneNumber)) {
        rowcfad08sig00.setSzCdFacilPhoneType(phoneType);
        rowcfad08sig00.setUlIdRsrcPhone(phoneID);
        rowcfad08sig00.setLNbrFacilPhoneNumber(phoneNumber);
        rowcfad08sig00.setLNbrFacilPhoneExtension(extension);
        rowcfad08sig00.setSzTxtRsrcPhoneComments(phoneComment);
        rowcfad08sig00.setTsLastUpdate(timestamp);
        rowcfad08sig00.setSzCdSysDataActionOutcome(funcCode);

        // Add phone row to the array
        rowcfad08sig00_array.addROWCFAD08SIG00(rowcfad08sig00);

        // Set the array into the parent struct
        cfad08si.setROWCFAD08SIG00_ARRAY(rowcfad08sig00_array);
      }// end if - end SIR 22684

      // Set resource county and state
      cfad08si.setSzCdRsrcCnty(countyCD);
      cfad08si.setSzCdRsrcState(addressState);

    } // end if func code is ADD

    else {
      cfad08si.setSzCdRsrcCnty(cfad07so.getROWCFAD07SOG04().getSzCdRshsCnty());
      cfad08si.setSzCdRsrcState(cfad07so.getROWCFAD07SOG04().getSzCdRshsState());
    }

    // Event Information
    // MR-075 Adding new event for each demographic change
    rowcfad08sig06.setUlIdEvent(0);
    rowcfad08sig06.setSzCdTask(TASK_MNTN_NON_LIC);
    rowcfad08sig06.setSzTxtEventDescr(EVENT_DESCR_TEXT);
    rowcfad08sig06.setSzCdEventType(EVENT_TYPE_HME);
    rowcfad08sig06.setDtDtEventOccurred(today);
    rowcfad08sig06.setTsLastUpdate(tsToday);
    rowcfad08sig06.setSzCdEventStatus(EVENT_STATUS_COMP);
    rowcfad08sig06.setUlIdStage(GlobalData.getUlIdStage(request));
    rowcfad08sig06.setUlIdPerson(getUserID(request));
    
    if(ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)){
      // This is to handle newly added home
      // event description is different on home creation.
      rowcfad08sig06.setSzTxtEventDescr(NEW_EVENT_DESCR_TEXT);
    }

    cfad08si.setROWCFAD08SIG04(demographics);
    cfad08si.setROWCFAD08SIG05(homeInterest);
    cfad08si.setROWCFAD08SIG06(rowcfad08sig06);
    cfad08si.setIsApprovalMode(GlobalData.isApprovalMode(request));

    performanceTrace.exitScope();

    return cfad08si;
  }

  /**
   * This helper method is called by the saveHomeInformation_xa to populate the input object for the cfad38s (Home
   * License) save service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private CFAD38SI populateCFAD38SI_AU(GrndsExchangeContext context, String beforeTransactionFaHomeStatus) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD38SI_AU");
    performanceTrace.enterScope();
    // Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get today's date
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new Date());
    Date tsToday = new Date();

    // get the id of the logged on user
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    String loginName = StringHelper.EMPTY_STRING;
    String userFullName = StringHelper.EMPTY_STRING;
    int userID = 0;
    if (userProfile != null) {
      loginName = userProfile.getUserLogonID();
      userID = userProfile.getUserID();
      userFullName = userProfile.getUserFullName();
    }
    CFAD37SO cfad37so = (CFAD37SO) state.getAttribute(STR_CFAD37SO, request);
    CFAD07SO cfad07so = (CFAD07SO) state.getAttribute(STR_CFAD07SO, request);

    boolean isNonPrsSaved = false;
    if (cfad07so.getROWCFAD07SOG04() != null) {
      if (ArchitectureConstants.Y.equals(cfad07so.getROWCFAD07SOG04().getCIndRshsNonDFCSHome())) {
        isNonPrsSaved = true;
      }
    }

    Date timestamp = cfad37so.getTsLastUpdate();
    String onHold = CheckboxHelper.getCheckboxValue(request, "ckOnHold");
    String status = ContextHelper.getStringSafe(context, STATUS_DROPDOWN);
    String category = ContextHelper.getStringSafe(context, "selCategory");

    // Home License fields
    String indGeneric = IND_YES;

    int capacity = cfad37so.getUNbrRsrcFacilCapacity();
    int openSlots = cfad37so.getSNbrRsrcOpenSlots();
    int maleMinimumAgeInMonths = cfad37so.getUNbrRsrcMlAgeMin();
    int maleMaximumAgeInMonths = cfad37so.getUNbrRsrcMlAgeMax();
    int femaleMinimumAgeInMonths = cfad37so.getUNbrRsrcFMAgeMin();
    int femaleMaximumAgeInMonths = cfad37so.getUNbrRsrcFMAgeMax();
    Date dtApprovalBegin = cfad37so.getDtDtApprvlBegin();
    Date dtApprovalEnd = cfad37so.getDtDtApprvlEnd();
    Date dtFosterParentManual = cfad37so.getDtFosterParentManual();
    Date dtFosterParentBill = cfad37so.getDtFosterParentBill();
    String statusRsnComments = cfad37so.getSzTxtStatusRsnComments();

    // HD 6/30/2003 -- SIR 18606
    boolean licensingDisabled = ContextHelper.getBooleanSafe(request, "licenseDisabled");
    String fosterTypes = cfad37so.getCCdRsrcFaHomeType1_CFAD37SO();
    if (!licensingDisabled) // /HD 6/30/2003 -- SIR 18606
    {
      String[] checkedBoxes = CheckboxHelper.getCheckedValues(request, "famTypes");
      StringBuffer strbuff = new StringBuffer();

      // if (!isOnHoldChecked) {
      for (int i = checkedBoxes.length - 1; i >= 0; i--) {
        strbuff.append(checkedBoxes[i]);
      }
      fosterTypes = strbuff.toString();
      // } //HD 6/30/2003 SIR 18606
      capacity = ContextHelper.getIntSafe(context, "txtCapacity");
      openSlots = ContextHelper.getIntSafe(context, "txtOpenSlots");

      int minMaleYear = ContextHelper.getIntSafe(context, "selMaleMinYear");
      int minMaleMonth = ContextHelper.getIntSafe(context, "selMaleMinMonth");
      maleMinimumAgeInMonths = (minMaleYear * 12) + minMaleMonth;
      int maxMaleYear = ContextHelper.getIntSafe(context, "selMaleMaxYear");
      int maxMaleMonth = ContextHelper.getIntSafe(context, "selMaleMaxMonth");
      maleMaximumAgeInMonths = (maxMaleYear * 12) + maxMaleMonth;

      int minFemaleYear = ContextHelper.getIntSafe(context, "selFemaleMinYear");
      int minFemaleMonth = ContextHelper.getIntSafe(context, "selFemaleMinMonth");
      femaleMinimumAgeInMonths = (minFemaleYear * 12) + minFemaleMonth;
      int maxFemaleYear = ContextHelper.getIntSafe(context, "selFemaleMaxYear");
      int maxFemaleMonth = ContextHelper.getIntSafe(context, "selFemaleMaxMonth");
      femaleMaximumAgeInMonths = (maxFemaleYear * 12) + maxFemaleMonth;

      statusRsnComments = ContextHelper.getStringSafe(context, "txtStatusRsnComments");
      String strApprovalBeginDate = ContextHelper.getStringSafe(context, "apprvlBeginDt");
      String strApprovalEndDate = ContextHelper.getStringSafe(context, "apprvlEndDt");
      if (!StringHelper.EMPTY_STRING.equals(strApprovalBeginDate)) {
        dtApprovalBegin = DateHelper.toJavaDateSafe(strApprovalBeginDate);
      }
      if (!StringHelper.EMPTY_STRING.equals(strApprovalEndDate)) {
        dtApprovalEnd = DateHelper.toJavaDateSafe(strApprovalEndDate);
      }
      String strFosterParentManualDate = ContextHelper.getStringSafe(context, "dtFosterParentManual");
      String strFosterParentBillDate = ContextHelper.getStringSafe(context, "dtFosterParentBill");
      if (!StringHelper.EMPTY_STRING.equals(strFosterParentManualDate)) {
        dtFosterParentManual = DateHelper.toJavaDateSafe(strFosterParentManualDate);
      }
      if (!StringHelper.EMPTY_STRING.equals(strFosterParentBillDate)) {
        dtFosterParentBill = DateHelper.toJavaDateSafe(strFosterParentBillDate);
      }
    } // **********end if on hold unchecked***************

    if (state.getAttribute(IS_SUBMIT, request) != null) {
      if (isNonPrsSaved) {
        indGeneric = StringHelper.EMPTY_STRING;
      }
    }

    boolean statusChanged = !StringHelper.checkForEquality(status, beforeTransactionFaHomeStatus);

    String nextEventDescription = LC_EVENT_DESCR_TEXT;
    if (statusChanged || state.getAttribute(IS_SUBMIT, request) != null) {
      nextEventDescription = STAT_CHG_EVENT_DESCR_TEXT_1 + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, status)
                             + STAT_CHG_EVENT_DESCR_TEXT_2;
    }

    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 current = new ROWCCMN01UIG00();
    ROWCCMN01UIG00 next = new ROWCCMN01UIG00();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    CFAD38SI cfad38si = new CFAD38SI();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    ROWCCMN01UIG00_ARRAY rowccmn01uig00_array = new ROWCCMN01UIG00_ARRAY();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    // HD 6/5/2003 -- Approval Status SIR 17673
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    input.setSzUserId(loginName);

    /*
     * * If current Event Status is Pending, copy * current Event information to service input. * This is necessary to
     * update the Event table for * Invalidate Approval save processing
     */
    if (EVENT_STATUS_PEND.equals(cfad37so.getROWCCMN01UIG00().getSzCdEventStatus())) {
      current.setSzCdTask(cfad37so.getROWCCMN01UIG00().getSzCdTask());
      current.setTsLastUpdate(cfad37so.getROWCCMN01UIG00().getTsLastUpdate());
      current.setSzCdEventStatus(cfad37so.getROWCCMN01UIG00().getSzCdEventStatus());
      current.setSzCdEventType(cfad37so.getROWCCMN01UIG00().getSzCdEventType());
      current.setDtDtEventOccurred(cfad37so.getROWCCMN01UIG00().getDtDtEventOccurred());
      current.setUlIdEvent(cfad37so.getROWCCMN01UIG00().getUlIdEvent());
      current.setUlIdStage(cfad37so.getROWCCMN01UIG00().getUlIdStage());
      current.setUlIdPerson(cfad37so.getROWCCMN01UIG00().getUlIdPerson());
      current.setSzTxtEventDescr(cfad37so.getROWCCMN01UIG00().getSzTxtEventDescr());
    }

    rowccmn01uig00_array.addROWCCMN01UIG00(CURRENT, current);

    // MR-075 New license change event is created
    // either during INQ, APP, or on submission of one of the PEND statuses
    next.setSzCdTask(TASK_MNTN_LIC);
    next.setTsLastUpdate(tsToday);
    next.setSzCdEventStatus(EVENT_STATUS_COMP);
    next.setSzCdEventType(EVENT_TYPE_HME);
    next.setDtDtEventOccurred(today);
    next.setUlIdEvent(0);
    next.setUlIdStage(GlobalData.getUlIdStage(request));
    next.setUlIdPerson(userID);
    next.setSzTxtEventDescr(nextEventDescription);

    rowccmn01uig00_array.addROWCCMN01UIG00(NEXT, next);

    cfad38si.setArchInputStruct(input);
    cfad38si.setTsLastUpdate(timestamp);

    String appStatusChanged = IND_NO;
    if ((CODE_STATUS_APPLICANT.equals(status)) && (!(CODE_STATUS_APPLICANT.equals(beforeTransactionFaHomeStatus)))) {
      appStatusChanged = IND_YES;
    }
    cfad38si.setCSysIndAppStatusChange(appStatusChanged);

    cfad38si.setUlIdResource(cfad37so.getUlIdResource());
    cfad38si.setSzNmResource(cfad07so.getROWCFAD07SOG04().getSzNmRshsResource());
    cfad38si.setSzCdRsrcCategory(category);
    cfad38si.setSzCdRsrcFaHomeStatus(status);
    cfad38si.setUNbrRsrcMlAgeMin(maleMinimumAgeInMonths);
    cfad38si.setUNbrRsrcMlAgeMax(maleMaximumAgeInMonths);
    cfad38si.setUNbrRsrcFMAgeMin(femaleMinimumAgeInMonths);
    cfad38si.setUNbrRsrcFMAgeMax(femaleMaximumAgeInMonths);
    cfad38si.setUNbrRsrcFacilCapacity(capacity);
    cfad38si.setCCdRsrcFaHomeType1(fosterTypes);
    cfad38si.setSNbrRsrcOpenSlots(openSlots);
    // MR-075 keeping old resource status, this should only change on approval
    // based on indHoldPlacements and home status.
    cfad38si.setSzCdRsrcStatus(cfad37so.getSzCdRsrcStatus());
    cfad38si.setBIndHoldPlacements(onHold);

    // All FLOC processing now done Server-side
    cfad38si.setCCdFlocStatus1(StringHelper.EMPTY_STRING);
    cfad38si.setCCdFlocStatus2(StringHelper.EMPTY_STRING);
    cfad38si.setCCdFlocStatus3(StringHelper.EMPTY_STRING);
    cfad38si.setCCdFlocStatus4(StringHelper.EMPTY_STRING);
    // .......................................
    cfad38si.setCIndRshsNonDFCSHome(cfad37so.getBIndRsrcNonPrs());
    cfad38si.setSzTxtNdfcsCertEntity(cfad37so.getSzTxtNdfcsCertEntity());
    cfad38si.setBSysIndGeneric(indGeneric);
    cfad38si.setSzNmRsrcLastUpdate(userFullName);
    cfad38si.setSzCdRshsRegion(cfad07so.getROWCFAD07SOG04().getSzCdRshsRegion());
    cfad38si.setSzCdRsrcCnty(cfad37so.getSzCdRsrcCnty());
    cfad38si.setUlIdCntrctWkr(userID);

    // Add the struct to the array
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);

    // Set the array into the parent struct
    cfad38si.setROWCCMN01UIG00_ARRAY(rowccmn01uig00_array);

    // HD 6/26/2003 -- SIR 18334 -- Added closure reason fields to save service

    String closureReason = ContextHelper.getStringSafe(context, "selClosureReason");
    String recReopen = ContextHelper.getStringSafe(context, "selRecReopen");
    String involClsr = ContextHelper.getStringSafe(context, "selInvolClosure");

    cfad38si.setSzCdRsrcClosureRsn(closureReason);
    cfad38si.setSzCdRsrcInvolClosure(involClsr);
    cfad38si.setSzCdRsrcRecmndReopen(recReopen);
    // adding new fields
    cfad38si.setDtDtApprvlBegin(dtApprovalBegin);
    cfad38si.setDtDtApprvlEnd(dtApprovalEnd);
    cfad38si.setSzTxtStatusRsnComments(statusRsnComments);
    cfad38si.setDtFosterParentManual(dtFosterParentManual);
    cfad38si.setDtFosterParentBill(dtFosterParentBill);

    performanceTrace.exitScope();
    return cfad38si;
  }

  /**
   * because the foster type string isn't guaranteed to always be in the same order and we need to be able to compare
   * before to after, I wrote this to turn the string into a set
   */
  private Set getFosterTypeSet(String fosterTypes) {
    Set<String> set = new HashSet<String>();
    if (fosterTypes == null) {
      return set;
    }

    char[] array = fosterTypes.toCharArray();
    for (int i = 0; i < array.length; i++) {
      set.add(StringHelper.EMPTY_STRING + array[i]);
    }
    return set;
  }

  /**
   * This helper method is called by the savePhoneDetail_xa, deletePhoneRow_xa methods to populate the input object for
   * the cfad08s (Home Demographics, Home Interest) save service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private CFAD08SI populateCFAD08SI_Phone(GrndsExchangeContext context, String funcCode) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD08SI_Phone");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get today's date
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new Date());
    Date tsToday = new Date();

    String userName = getUserLogonID(request);
    int userID = getUserID(request);

    CFAD07SO cfad07so = (CFAD07SO) state.getAttribute(STR_CFAD07SO, request);

    Date timestamp = null;
    String phoneType = null;
    int phoneID = 0;
    String phoneNumber = null;
    String extension = null;
    String phoneComment = null;
    ROWCFAD07SOG00 phoneRow = null;

    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(funcCode)) {
      if ("true".equals(ContextHelper.getStringSafe(request, "phoneDelete"))) {
        // User clicked delete button on Home Information page, so get current row
        if (cfad07so != null) {
          ROWCFAD07SOG00_ARRAY phoneArray = cfad07so.getROWCFAD07SOG00_ARRAY();
          int arrayIndex = ContextHelper.getIntSafe(request, "phoneArrayIndex");
          phoneRow = phoneArray.getROWCFAD07SOG00(arrayIndex);
        }
      } else {
        // User clicked delete from Phone Detail page
        phoneRow = (ROWCFAD07SOG00) state.getAttribute(CURRENT_PHONE, request);
      }
      if (phoneRow != null) {
        phoneType = phoneRow.getSzCdFacilPhoneType();
        timestamp = phoneRow.getTsLastUpdate();
        phoneID = phoneRow.getUlIdRsrcPhone();
        phoneNumber = phoneRow.getLNbrFacilPhoneNumber();
        extension = phoneRow.getLNbrFacilPhoneExtension();
        phoneComment = phoneRow.getSzTxtRsrcPhoneComments();
      }
    } else { // it's an add or update so get info. from request
      phoneType = ContextHelper.getStringSafe(request, "selSzCdFacilPhoneType");
      timestamp = ContextHelper.getJavaDateSafe(request, TXT_TS_LAST_UPDATE);
      phoneID = ContextHelper.getIntSafe(request, "IdResourcePhone");
      phoneNumber = ContextHelper.getPhone(request, "txtLNbrFacilPhoneNumber");
      extension = ContextHelper.getStringSafe(request, "txtLNbrFacilPhoneExtension");
      phoneComment = ContextHelper.getStringSafe(request, "txtszTxtRsrcPhoneComments");

    }

    // Allocate the input structures
    ROWCFAD08SIG02 rowcfad08sig02 = new ROWCFAD08SIG02();
    ROWCFAD08SIG04 rowcfad08sig04 = new ROWCFAD08SIG04();
    ROWCFAD08SIG05 rowcfad08sig05 = new ROWCFAD08SIG05();
    CFAD08SI cfad08si = new CFAD08SI();
    ROWCFAD08SIG06 rowcfad08sig06 = new ROWCFAD08SIG06();
    ArchInputStruct input = new ArchInputStruct();
    ROWCFAD08SIG00 rowcfad08sig00 = new ROWCFAD08SIG00();
    ROWCFAD08SIG01 rowcfad08sig01 = new ROWCFAD08SIG01();
    ROWCFAD08SIG00_ARRAY rowcfad08sig00_array = new ROWCFAD08SIG00_ARRAY();
    ROWCFAD08SIG01_ARRAY rowcfad08sig01_array = new ROWCFAD08SIG01_ARRAY();
    ROWCFAD08SIG02_ARRAY rowcfad08sig02_array = new ROWCFAD08SIG02_ARRAY();
    ROWCFAD08SIG03_ARRAY rowcfad08sig03_array = new ROWCFAD08SIG03_ARRAY();

    // Allocate the output structures
    ROWCFAD07SOG02 aCharacteristic;
    ROWCFAD07SOG04 demographics;
    ROWCFAD07SOG05 homeInterest;

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    // HD 6/5/2003 -- Approval Status SIR 17673
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    input.setSzUserId(userName);

    // One Row for Each Characteristic checked, and date added (today for adds)
    if (cfad07so != null) {
      Enumeration characteristicEnumeration = cfad07so.getROWCFAD07SOG02_ARRAY().enumerateROWCFAD07SOG02();
      while (characteristicEnumeration.hasMoreElements()) {
        aCharacteristic = (ROWCFAD07SOG02) characteristicEnumeration.nextElement();
        rowcfad08sig02.setSzCdRsrcCharChrctr(aCharacteristic.getSzCdRsrcCharChrctr());
        rowcfad08sig02.setDtDtRsrcCharDateAdded(aCharacteristic.getDtDtRsrcCharDateAdded());
      }

      // Home Demographics section info.
      demographics = cfad07so.getROWCFAD07SOG04();
      rowcfad08sig04.setSzCdRshsCategory(demographics.getSzCdRshsCategory());
      // rowcfad08sig04.setSzCdRshsEthnicity(demographics.getSzCdRshsEthnicity());
      rowcfad08sig04.setSzCdRshsFaHomeStatus(demographics.getSzCdRshsFaHomeStatus());
      rowcfad08sig04.setSzCdRshsLanguage(demographics.getSzCdRshsLanguage());
      rowcfad08sig04.setSzCdRshsMaritalStatus(demographics.getSzCdRshsMaritalStatus());
      rowcfad08sig04.setSzCdRshsRegion(demographics.getSzCdRshsRegion());
      rowcfad08sig04.setSzCdRshsReligion(demographics.getSzCdRshsReligion());
      rowcfad08sig04.setSzCdRshsRespite(demographics.getSzCdRshsRespite());
      // rowcfad08sig04.setSzCdRshsSourceInquiry(demographics.getSzCdRshsSourceInquiry());
      rowcfad08sig04.setDtDtRshsMarriage(demographics.getDtDtRshsMarriage());
      rowcfad08sig04.setCIndRshsCareProv(demographics.getCIndRshsCareProv());
      rowcfad08sig04.setCIndCurrHomeStudyExists(demographics.getCIndCurrHomeStudyExists());
      rowcfad08sig04.setCIndPrevFamilyStudyReq(demographics.getCIndPrevFamilyStudyReq());
      rowcfad08sig04.setCIndRshsNonDFCSHome(demographics.getCIndRshsNonDFCSHome());
      rowcfad08sig04.setCIndWaiver(demographics.getCIndWaiver());
      rowcfad08sig04.setSzCdAdExchangeStatus(demographics.getSzCdAdExchangeStatus());
      rowcfad08sig04.setSzCdSchoolDistrict(demographics.getSzCdSchoolDistrict());
      rowcfad08sig04.setSzCdElementary(demographics.getSzCdElementary());
      rowcfad08sig04.setSzCdMiddle(demographics.getSzCdMiddle());
      rowcfad08sig04.setSzCdHigh(demographics.getSzCdHigh());
      rowcfad08sig04.setSzTxtNdfcsCertEntity(demographics.getSzTxtNdfcsCertEntity());
      rowcfad08sig04.setDNbrRshsAnnualIncome(demographics.getDNbrRshsAnnualIncome());
      rowcfad08sig04.setSzNmRshsResource(demographics.getSzNmRshsResource());
      rowcfad08sig04.setTsLastUpdate(demographics.getTsLastUpdate());
      rowcfad08sig04.setSzNmLegal(demographics.getSzNmLegal());

      cfad08si.setArchInputStruct(input);
      cfad08si.setCSysRsrcCntyChg(IND_NO);
      cfad08si.setDtSysDtGenericSysdate(cfad07so.getDtSysDtGenericSysdate());
      cfad08si.setBIndEndDateMod(IND_NO);
      cfad08si.setCSysRsrcStateChg(IND_NO);
      cfad08si.setCSysIndRsrcCharChg(IND_NO);
      // SIR 22972 - replace parameter IND_NO to evaluate correctly in dam caud58d.
      cfad08si.setCSysIndRsrcPrsChg(StringHelper.EMPTY_STRING);
      cfad08si.setUlIdResource(cfad07so.getUlIdResource());
      SzCdEventStatus_ARRAY statusArray = new SzCdEventStatus_ARRAY();
      // MR-075 need to set current status to later invalidate event
      statusArray.addSzCdEventStatus(cfad07so.getROWCFAD07SOG06().getSzCdEventStatus());
      cfad08si.setSzCdEventStatus_ARRAY(statusArray);
      SzCdRsrcStatus_ARRAY resourceStatusArray = new SzCdRsrcStatus_ARRAY();
      resourceStatusArray.addSzCdRsrcStatus(StringHelper.EMPTY_STRING);
      cfad08si.setSzCdRsrcStatus_ARRAY(resourceStatusArray);
      cfad08si.setSzCdRsrcState(demographics.getSzCdRshsState());
      cfad08si.setSzCdRsrcCnty(demographics.getSzCdRshsCnty());
      cfad08si.setSzCdCntrctRegion(demographics.getSzCdRshsRegion());
      cfad08si.setUlIdCntrctWkr(userID);

      cfad08si.setROWCFAD08SIG04(rowcfad08sig04);
      cfad08si.setROWCFAD08SIG05(rowcfad08sig05);
      cfad08si.setROWCFAD08SIG06(rowcfad08sig06);

      // Home Interest
      homeInterest = cfad07so.getROWCFAD07SOG05();
      rowcfad08sig05.setCIndSpecificChild(homeInterest.getCIndSpecificChild());
      rowcfad08sig05.setUNbrRsrcIntFeAgeMax(homeInterest.getUNbrRsrcIntFeAgeMax());
      rowcfad08sig05.setUNbrRsrcIntFeAgeMin(homeInterest.getUNbrRsrcIntFeAgeMin());
      rowcfad08sig05.setUNbrRsrcIntMaAgeMax(homeInterest.getUNbrRsrcIntMaAgeMax());
      rowcfad08sig05.setUNbrRsrcIntMaAgeMin(homeInterest.getUNbrRsrcIntMaAgeMin());
      rowcfad08sig05.setCIndRsrcEmergPlace(homeInterest.getCIndRsrcEmergPlace());
      rowcfad08sig05.setCIndRsrcTransport(homeInterest.getCIndRsrcTransport());
      rowcfad08sig05.setSzTxtRsrcComments(homeInterest.getSzTxtRsrcComments());
      rowcfad08sig05.setUNbrRsrcFMAgeMax(homeInterest.getUNbrRsrcFMAgeMax());
      rowcfad08sig05.setUNbrRsrcFMAgeMin(homeInterest.getUNbrRsrcFMAgeMin());
      rowcfad08sig05.setUNbrRsrcMlAgeMin(homeInterest.getUNbrRsrcMlAgeMin());
      rowcfad08sig05.setUNbrRsrcMlAgeMax(homeInterest.getUNbrRsrcMlAgeMax());
      rowcfad08sig05.setTxtHmPrgInterest(homeInterest.getTxtHmPrgInterest());

      // Event Information
      rowcfad08sig06.setSzCdTask(TASK_MNTN_LIC);
      rowcfad08sig06.setTsLastUpdate(tsToday);
      rowcfad08sig06.setSzCdEventStatus(EVENT_STATUS_COMP);
      rowcfad08sig06.setSzCdEventType(EVENT_TYPE_HME);
      rowcfad08sig06.setDtDtEventOccurred(today);
      rowcfad08sig06.setUlIdEvent(0);
      rowcfad08sig06.setUlIdStage(GlobalData.getUlIdStage(request));
      rowcfad08sig06.setUlIdPerson(userID);
      rowcfad08sig06.setSzTxtEventDescr(EVENT_DESCR_TEXT);

      // Phone Row
      rowcfad08sig00.setSzCdFacilPhoneType(phoneType);
      rowcfad08sig00.setUlIdRsrcPhone(phoneID);
      rowcfad08sig00.setLNbrFacilPhoneNumber(phoneNumber);
      rowcfad08sig00.setLNbrFacilPhoneExtension(extension);
      rowcfad08sig00.setSzTxtRsrcPhoneComments(phoneComment);
      // Date d4 = new Date();
      rowcfad08sig00.setTsLastUpdate(timestamp);
      rowcfad08sig00.setSzCdSysDataActionOutcome(funcCode);

      // Address Row
      rowcfad08sig01.setSzAddrRsrcAddrAttn(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzAddrRsrcAddrCity(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzAddrRsrcAddrStLn1(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzAddrRsrcAddrStLn2(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzAddrRsrcAddrZip(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzCdFacilityCounty(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzCdRsrcAddrSchDist(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzCdFacilityState(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzCdRsrcAddrType(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setUlIdRsrcAddress(0);
      rowcfad08sig01.setSzNbrRsrcAddrVid(StringHelper.EMPTY_STRING);
      rowcfad08sig01.setSzTxtRsrcAddrComments(StringHelper.EMPTY_STRING);
      Date d5 = new Date();
      rowcfad08sig01.setTsLastUpdate(d5);
      rowcfad08sig01.setSzCdSysDataActionOutcome(StringHelper.EMPTY_STRING);

      rowcfad08sig00_array.addROWCFAD08SIG00(rowcfad08sig00);
      cfad08si.setROWCFAD08SIG00_ARRAY(rowcfad08sig00_array);

      rowcfad08sig01_array.addROWCFAD08SIG01(rowcfad08sig01);
      cfad08si.setROWCFAD08SIG01_ARRAY(rowcfad08sig01_array);

      rowcfad08sig02_array.addROWCFAD08SIG02(rowcfad08sig02);
      cfad08si.setROWCFAD08SIG02_ARRAY(rowcfad08sig02_array);

      cfad08si.setROWCFAD08SIG03_ARRAY(rowcfad08sig03_array);
      
      cfad08si.setIsApprovalMode(GlobalData.isApprovalMode(request));
    }
    performanceTrace.exitScope();
    return cfad08si;
  }

  /**
   * This helper method is called by the saveAddressDetail_xa, deleteAddressRow_xa methods to populate the input object
   * for the cfad08s save service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private CFAD08SI populateCFAD08SI_Address(GrndsExchangeContext context, String funcCode) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD08SI_Address");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get today's date
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new Date());
    Date tsToday = new Date();

    String userName = getUserLogonID(request);
    int userID = getUserID(request);

    CFAD07SO cfad07so = (CFAD07SO) state.getAttribute(STR_CFAD07SO, request);

    Date timestamp = ContextHelper.getJavaDateSafe(context, TXT_TS_LAST_UPDATE);
    String addressType = StringHelper.EMPTY_STRING;
    int addressID = 0;
    double nbrRsrcAddrLat = 0.0;
    double nbrRsrcAddrLong = 0.0;
    String addrAttn = StringHelper.EMPTY_STRING;
    String addressLine1 = StringHelper.EMPTY_STRING;
    String addressLine2 = StringHelper.EMPTY_STRING;
    String countyCD = StringHelper.EMPTY_STRING;
    String addressState = StringHelper.EMPTY_STRING;
    String zipAndSuffix = StringHelper.EMPTY_STRING;
    String addrCity = StringHelper.EMPTY_STRING;
    String addressComment = StringHelper.EMPTY_STRING;
    String vendorID = StringHelper.EMPTY_STRING;
    int arrayIndex;
    String endDateMod = IND_NO;
    ROWCFAD07SOG01 addressRow = null;
    boolean vidChanged = request.getParameter("vidChanged") != null ? true : false;

    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(funcCode)) {
      if ("true".equals(ContextHelper.getStringSafe(request, "addressDelete"))) {
        // User clicked delete button on Home Information page, so get current row
        if (cfad07so != null) {
          ROWCFAD07SOG01_ARRAY addressArray = cfad07so.getROWCFAD07SOG01_ARRAY();
          arrayIndex = ContextHelper.getIntSafe(request, ADDRESS_ARRAY_INDEX);
          addressRow = addressArray.getROWCFAD07SOG01(arrayIndex);
          endDateMod = cfad07so.getBIndEndDateMod();
        }
      } else {
        // User clicked delete from ADDRESS Detail page
        addressRow = (ROWCFAD07SOG01) state.getAttribute(CURRENT_ADDRESS, request);
      }
      if (addressRow != null) {
        addressType = addressRow.getSzCdRsrcAddrType();
        timestamp = addressRow.getTsLastUpdate();
        addressID = addressRow.getUlIdRsrcAddress();
        addressLine1 = addressRow.getSzAddrRsrcAddrStLn1();
        addressLine2 = addressRow.getSzAddrRsrcAddrStLn2();
        addrAttn = addressRow.getSzAddrRsrcAddrAttn();
        countyCD = addressRow.getSzCdFacilityCounty();
        addressState = addressRow.getSzCdFacilityState();
        zipAndSuffix = addressRow.getSzAddrRsrcAddrZip();
        addrCity = addressRow.getSzAddrRsrcAddrCity();
        addressComment = addressRow.getSzTxtRsrcAddrComments();
      }
    } else { // it's an add or update so get info. from request
      // -- Retrieve values via the AddressBean in the request
      String addressSubmoduleName = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME);
      AddressBean addressBean = AddressBean.getFromRequest(addressSubmoduleName, request);
      if (addressBean == null) {
        // -- This should never happen since the resource/AddressDetail.jsp page always uses standardized
        // -- AddressBean request parameter names, allowing the AddressBean to be initialized and populated
        // -- via the getFromRequest static method.
        addressBean = new AddressBean(addressSubmoduleName);
      }

      addressLine1 = addressBean.getAddress1() != null ? addressBean.getAddress1() : StringHelper.EMPTY_STRING;
      addressLine2 = addressBean.getAddress2() != null ? addressBean.getAddress2() : StringHelper.EMPTY_STRING;
      addrCity = addressBean.getCity() != null ? addressBean.getCity() : StringHelper.EMPTY_STRING;
      addressState = addressBean.getState() != null ? addressBean.getState() : StringHelper.EMPTY_STRING;
      zipAndSuffix = addressBean.getZipAndSuff() != null ? addressBean.getZipAndSuff() : StringHelper.EMPTY_STRING;

      addrAttn = ContextHelper.getStringSafe(request, "txtSzAddrRsrcAddrAttn");
      countyCD = addressBean.getCounty() != null ? addressBean.getCounty() : StringHelper.EMPTY_STRING;
      vendorID = ContextHelper.getStringSafe(request, "txtNbrRsrcAddrVid");
      addressComment = ContextHelper.getStringSafe(request, "txtszTxtRsrcAddrComments");
      addressType = ContextHelper.getStringSafe(request, "selCdRsrcAddrType");
      addressID = ContextHelper.getIntSafe(request, "iUlIdRsrcAddress");
      nbrRsrcAddrLat = ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLat");
      nbrRsrcAddrLong = ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLong");
    }
    boolean bBusinessAddrExists = false; // SIR#23778
    // * SPB - SIR 19424
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(funcCode)) {
      ROWCFAD07SOG01_ARRAY addressArray = cfad07so.getROWCFAD07SOG01_ARRAY();
      for (int i = 0; i < addressArray.getUlRowQty(); i++) {
        ROWCFAD07SOG01 addressDetail = addressArray.getROWCFAD07SOG01(i);
        // SIR#23778
        if (CodesTables.CRSCADDR_02.equals(addressDetail.getSzCdRsrcAddrType())) {
          bBusinessAddrExists = true;
        }

        // Check to see if address entered is duplicate; lefthand sides are not null (retrieved using getXxxSafe() or
        // had null check done above
        if ((addressID != addressDetail.getUlIdRsrcAddress())
            && (addressType.equals(addressDetail.getSzCdRsrcAddrType()))
            && (addressLine1.equals(addressDetail.getSzAddrRsrcAddrStLn1()))
            && (addressLine2.equals(addressDetail.getSzAddrRsrcAddrStLn2()))
            && (addrCity.equals(addressDetail.getSzAddrRsrcAddrCity()))
            && (addressState.equals(addressDetail.getSzCdFacilityState()))
            && (zipAndSuffix.equals(addressDetail.getSzAddrRsrcAddrZip()))) {
          addErrorMessage(MessageLookup.getMessageByName("MSG_NO_DUP_LB_ROW"), request);
          return null;
        }
        // check to see that vendor id is not already used
        else if ((addressID != addressDetail.getUlIdRsrcAddress()) && (vendorID != null)
                 && (!StringHelper.EMPTY_STRING.equals(vendorID))
                 && (vendorID.equals(addressDetail.getSzNbrRsrcAddrVid()))) {
          addErrorMessage(MessageLookup.getMessageByName("MSG_RES_UNIQUE_VID"), request);
          return null;
        }

        // begin SIR#23778:
        if (bBusinessAddrExists && ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)
            && addressType.compareTo(CodesTables.CRSCADDR_02) == 0) {
          addErrorMessage(MessageLookup.getMessageByName("MSG_BUSINESS_ADDR_EXIST"), request);
          return null;
        }
        ROWCFAD07SOG01 addressDetail2 = (ROWCFAD07SOG01) state.getAttribute(CURRENT_ADDRESS, request);
        if (bBusinessAddrExists && ServiceConstants.REQ_FUNC_CD_UPDATE.equals(funcCode)) {
          // user selects a non-business address, navigates to address detail page and then
          // tries to save it as business address while there is already a business address
          if (addressDetail2.getSzCdRsrcAddrType().compareTo(CodesTables.CRSCADDR_02) != 0
              && addressType.compareTo(CodesTables.CRSCADDR_02) == 0) {
            addErrorMessage(MessageLookup.getMessageByName("MSG_BUSINESS_ADDR_EXIST"), request);
            return null;
          }
          // user selects a business address, navigates to address detail page and then tries
          // to save it as non- business address.
          else if (addressDetail2.getSzCdRsrcAddrType().compareTo(CodesTables.CRSCADDR_02) == 0
                   && addressType.compareTo(CodesTables.CRSCADDR_02) != 0) {
            addErrorMessage(MessageLookup.getMessageByName("MSG_BUSINESS_ADDR_TYPE"), request);
            return null;
          }
        }
        // end SIR#23778:
      }
    }

    // Allocate the input structures
    ROWCFAD08SIG02 rowcfad08sig02 = new ROWCFAD08SIG02();
    ROWCFAD08SIG04 rowcfad08sig04 = new ROWCFAD08SIG04();
    ROWCFAD08SIG05 rowcfad08sig05 = new ROWCFAD08SIG05();
    CFAD08SI cfad08si = new CFAD08SI();
    ROWCFAD08SIG06 rowcfad08sig06 = new ROWCFAD08SIG06();
    ArchInputStruct input = new ArchInputStruct();
    ROWCFAD08SIG00 rowcfad08sig00 = new ROWCFAD08SIG00();
    ROWCFAD08SIG01 rowcfad08sig01 = new ROWCFAD08SIG01();
    ROWCFAD08SIG00_ARRAY rowcfad08sig00_array = new ROWCFAD08SIG00_ARRAY();
    ROWCFAD08SIG01_ARRAY rowcfad08sig01_array = new ROWCFAD08SIG01_ARRAY();
    ROWCFAD08SIG02_ARRAY rowcfad08sig02_array = new ROWCFAD08SIG02_ARRAY();
    ROWCFAD08SIG03_ARRAY rowcfad08sig03_array = new ROWCFAD08SIG03_ARRAY();

    // Allocate the output structures
    ROWCFAD07SOG02 aCharacteristic;
    ROWCFAD07SOG04 demographics;
    ROWCFAD07SOG05 homeInterest;

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    // Matthew McClain, 07/25/2003, uninitialized variable problem in service
    input.setUlPageSizeNbr(1);
    input.setUsPageNbr(1);
    // HD 6/5/2003 -- Approval Status SIR 17673
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    input.setSzUserId(userName);

    // One Row for Each Characteristic checked, and date added (today for adds)
    if (cfad07so != null) {
      Enumeration characteristicEnumeration = cfad07so.getROWCFAD07SOG02_ARRAY().enumerateROWCFAD07SOG02();
      while (characteristicEnumeration.hasMoreElements()) {
        aCharacteristic = (ROWCFAD07SOG02) characteristicEnumeration.nextElement();
        rowcfad08sig02.setSzCdRsrcCharChrctr(aCharacteristic.getSzCdRsrcCharChrctr());
        rowcfad08sig02.setDtDtRsrcCharDateAdded(aCharacteristic.getDtDtRsrcCharDateAdded());
      }

      // Home Demographics section info.
      demographics = cfad07so.getROWCFAD07SOG04();
      String oldRegion = demographics.getSzCdRshsRegion();

      if (CodesTables.CRSCADDR_01.equals(addressType)) {
        demographics.setSzCdRshsCnty(countyCD);
        demographics.setSzCdRshsState(addressState);
        demographics.setSzCdRshsRegion(getRegion(request));
      }

      rowcfad08sig04.setSzCdRshsCategory(demographics.getSzCdRshsCategory());
      rowcfad08sig04.setSzCdRshsFaHomeStatus(demographics.getSzCdRshsFaHomeStatus());
      rowcfad08sig04.setSzCdRshsLanguage(demographics.getSzCdRshsLanguage());
      rowcfad08sig04.setSzCdRshsMaritalStatus(demographics.getSzCdRshsMaritalStatus());
      rowcfad08sig04.setSzCdRshsRegion(demographics.getSzCdRshsRegion());
      rowcfad08sig04.setSzCdRshsReligion(demographics.getSzCdRshsReligion());
      rowcfad08sig04.setSzCdRshsRespite(demographics.getSzCdRshsRespite());
      rowcfad08sig04.setDtDtRshsMarriage(demographics.getDtDtRshsMarriage());
      rowcfad08sig04.setCIndRshsCareProv(demographics.getCIndRshsCareProv());
      rowcfad08sig04.setCIndCurrHomeStudyExists(demographics.getCIndCurrHomeStudyExists());
      rowcfad08sig04.setCIndPrevFamilyStudyReq(demographics.getCIndPrevFamilyStudyReq());
      rowcfad08sig04.setCIndRshsNonDFCSHome(demographics.getCIndRshsNonDFCSHome());
      rowcfad08sig04.setCIndWaiver(demographics.getCIndWaiver());
      rowcfad08sig04.setSzCdAdExchangeStatus(demographics.getSzCdAdExchangeStatus());
      rowcfad08sig04.setSzCdSchoolDistrict(demographics.getSzCdSchoolDistrict());
      rowcfad08sig04.setSzCdElementary(demographics.getSzCdElementary());
      rowcfad08sig04.setSzCdMiddle(demographics.getSzCdMiddle());
      rowcfad08sig04.setSzCdHigh(demographics.getSzCdHigh());
      rowcfad08sig04.setSzTxtNdfcsCertEntity(demographics.getSzTxtNdfcsCertEntity());
      rowcfad08sig04.setDNbrRshsAnnualIncome(demographics.getDNbrRshsAnnualIncome());
      rowcfad08sig04.setSzNmRshsResource(demographics.getSzNmRshsResource());
      rowcfad08sig04.setTsLastUpdate(demographics.getTsLastUpdate());
      rowcfad08sig04.setSzNmLegal(demographics.getSzNmLegal());

      // Determine whether state, county have changed on the primary address
      /*
       * * ochumd Sir 22800 changed the code to accomodate the fact that addresses * created in caps did not follow the
       * same order as those created in * impact.
       */
      String oldCountyCD = StringHelper.EMPTY_STRING;
      String oldState = StringHelper.EMPTY_STRING;
      boolean countyChanged = false;
      if ("01".equals(addressType)) {
        ROWCFAD07SOG01_ARRAY rowArray = cfad07so.getROWCFAD07SOG01_ARRAY();
        for (int i = 0; i < rowArray.getUlRowQty(); i++) {
          if ("01".equals(rowArray.getROWCFAD07SOG01(i).getSzCdRsrcAddrType())) {
            oldCountyCD = cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i).getSzCdFacilityCounty();
            oldState = cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i).getSzCdFacilityState();
            break;
          }
        }

        if (oldCountyCD != null && (!oldCountyCD.equals(countyCD))) {
          cfad08si.setCSysRsrcCntyChg(IND_YES);
          countyChanged = true;
        }

        if (oldState != null && (!oldState.equals(addressState))) {
          cfad08si.setCSysRsrcStateChg(IND_YES);
        }
      }

      cfad08si.setArchInputStruct(input);
      cfad08si.setDtSysDtGenericSysdate(cfad07so.getDtSysDtGenericSysdate());
      if (IND_YES.equals(endDateMod) && countyChanged) {
        cfad08si.setBIndEndDateMod(IND_NO);
      } else {
        cfad08si.setBIndEndDateMod(IND_YES);
      }
      
      // STGAP00017058 - set indicator so that new vendor id can be saved in service
      if(vidChanged){
        cfad08si.setBIndReview(ArchitectureConstants.Y);
      }else{
        cfad08si.setBIndReview(ArchitectureConstants.N);
      }
      cfad08si.setCSysIndRsrcCharChg(IND_NO);
      // SIR 22972 - replace parameter IND_NO to evaluate correctly in dam caud58d.
      cfad08si.setCSysIndRsrcPrsChg(StringHelper.EMPTY_STRING);
      cfad08si.setUlIdResource(cfad07so.getUlIdResource());
      SzCdEventStatus_ARRAY statusArray = new SzCdEventStatus_ARRAY();
      // MR-075 need to set current status to later invalidate event
      statusArray.addSzCdEventStatus(cfad07so.getROWCFAD07SOG06().getSzCdEventStatus());
      cfad08si.setSzCdEventStatus_ARRAY(statusArray);
      SzCdRsrcStatus_ARRAY resourceStatusArray = new SzCdRsrcStatus_ARRAY();
      resourceStatusArray.addSzCdRsrcStatus(StringHelper.EMPTY_STRING);
      cfad08si.setSzCdRsrcStatus_ARRAY(resourceStatusArray);
      cfad08si.setSzCdRsrcState(demographics.getSzCdRshsState());
      cfad08si.setSzCdRsrcCnty(demographics.getSzCdRshsCnty());
      cfad08si.setSzCdCntrctRegion(oldRegion);
      cfad08si.setUlIdCntrctWkr(userID);

      cfad08si.setROWCFAD08SIG04(rowcfad08sig04);
      cfad08si.setROWCFAD08SIG05(rowcfad08sig05);
      cfad08si.setROWCFAD08SIG06(rowcfad08sig06);

      // Home Interest
      homeInterest = cfad07so.getROWCFAD07SOG05();
      rowcfad08sig05.setCIndSpecificChild(homeInterest.getCIndSpecificChild());
      rowcfad08sig05.setUNbrRsrcIntFeAgeMax(homeInterest.getUNbrRsrcIntFeAgeMax());
      rowcfad08sig05.setUNbrRsrcIntFeAgeMin(homeInterest.getUNbrRsrcIntFeAgeMin());
      rowcfad08sig05.setUNbrRsrcIntMaAgeMax(homeInterest.getUNbrRsrcIntMaAgeMax());
      rowcfad08sig05.setUNbrRsrcIntMaAgeMin(homeInterest.getUNbrRsrcIntMaAgeMin());
      rowcfad08sig05.setCIndRsrcEmergPlace(homeInterest.getCIndRsrcEmergPlace());
      rowcfad08sig05.setCIndRsrcTransport(homeInterest.getCIndRsrcTransport());
      rowcfad08sig05.setSzTxtRsrcComments(homeInterest.getSzTxtRsrcComments());
      rowcfad08sig05.setUNbrRsrcFMAgeMax(homeInterest.getUNbrRsrcFMAgeMax());
      rowcfad08sig05.setUNbrRsrcFMAgeMin(homeInterest.getUNbrRsrcFMAgeMin());
      rowcfad08sig05.setUNbrRsrcMlAgeMin(homeInterest.getUNbrRsrcMlAgeMin());
      rowcfad08sig05.setUNbrRsrcMlAgeMax(homeInterest.getUNbrRsrcMlAgeMax());
      rowcfad08sig05.setTxtHmPrgInterest(homeInterest.getTxtHmPrgInterest());

      // Event Information
      rowcfad08sig06.setSzCdTask(TASK_MNTN_LIC);
      rowcfad08sig06.setTsLastUpdate(tsToday);
      rowcfad08sig06.setSzCdEventStatus(EVENT_STATUS_COMP);
      rowcfad08sig06.setSzCdEventType(EVENT_TYPE_HME);
      rowcfad08sig06.setDtDtEventOccurred(today);
      rowcfad08sig06.setUlIdEvent(0);
      rowcfad08sig06.setUlIdStage(GlobalData.getUlIdStage(request));
      rowcfad08sig06.setUlIdPerson(userID);
      rowcfad08sig06.setSzTxtEventDescr(EVENT_DESCR_TEXT);

      // Phone Row
      rowcfad08sig00.setSzCdFacilPhoneType(StringHelper.EMPTY_STRING);
      rowcfad08sig00.setUlIdRsrcPhone(0);
      rowcfad08sig00.setLNbrFacilPhoneNumber(StringHelper.EMPTY_STRING);
      rowcfad08sig00.setLNbrFacilPhoneExtension(StringHelper.EMPTY_STRING);
      rowcfad08sig00.setSzTxtRsrcPhoneComments(StringHelper.EMPTY_STRING);
      Date d4 = new Date();
      rowcfad08sig00.setTsLastUpdate(d4);
      rowcfad08sig00.setSzCdSysDataActionOutcome(StringHelper.EMPTY_STRING);

      // Address Row
      rowcfad08sig01.setNbrRsrcAddrLat(nbrRsrcAddrLat);
      rowcfad08sig01.setNbrRsrcAddrLong(nbrRsrcAddrLong);
      rowcfad08sig01.setSzAddrRsrcAddrAttn(addrAttn);
      rowcfad08sig01.setSzAddrRsrcAddrCity(addrCity);
      rowcfad08sig01.setSzAddrRsrcAddrStLn1(addressLine1);
      rowcfad08sig01.setSzAddrRsrcAddrStLn2(addressLine2);
      rowcfad08sig01.setSzAddrRsrcAddrZip(zipAndSuffix);
      rowcfad08sig01.setSzCdFacilityCounty(countyCD);
      rowcfad08sig01.setSzCdFacilityState(addressState);
      rowcfad08sig01.setSzCdRsrcAddrType(addressType);
      rowcfad08sig01.setUlIdRsrcAddress(addressID);
      rowcfad08sig01.setSzNbrRsrcAddrVid(vendorID);
      rowcfad08sig01.setSzTxtRsrcAddrComments(addressComment);
      rowcfad08sig01.setTsLastUpdate(timestamp);
      rowcfad08sig01.setSzCdSysDataActionOutcome(funcCode);

      cfad08si.setROWCFAD08SIG00_ARRAY(rowcfad08sig00_array);

      rowcfad08sig01_array.addROWCFAD08SIG01(rowcfad08sig01);
      cfad08si.setROWCFAD08SIG01_ARRAY(rowcfad08sig01_array);

      rowcfad08sig02_array.addROWCFAD08SIG02(rowcfad08sig02);
      cfad08si.setROWCFAD08SIG02_ARRAY(rowcfad08sig02_array);

      cfad08si.setROWCFAD08SIG03_ARRAY(rowcfad08sig03_array);
      
      cfad08si.setIsApprovalMode(GlobalData.isApprovalMode(request));
    }
    performanceTrace.exitScope();
    return cfad08si;
  }

  private HomeApplicantSaveSI populateHomeApplicantSaveSI_AU(GrndsExchangeContext context, String funcCode,
                                                             int idResource) throws CheckboxHelperException {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateHomeApplicantSaveSI_AU");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    HomeApplicantRetrieveSO homeApplicantRetrieveSO = (HomeApplicantRetrieveSO) state
                                                                                     .getAttribute(
                                                                                                   STR_HOMEAPPLICANTRETRIEVESO,
                                                                                                   request);
    if (homeApplicantRetrieveSO == null) {
      homeApplicantRetrieveSO = new HomeApplicantRetrieveSO();
    }

    HomeApplicantSaveSI homeApplicantSaveSI = new HomeApplicantSaveSI();
    ArchInputStruct input = new ArchInputStruct();

    if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
      funcCode = ServiceConstants.REQ_FUNC_CD_ADD;
    }

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(funcCode);

    homeApplicantSaveSI.setArchInputStruct(input);

    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)) {
      homeApplicantSaveSI.setIdHomeApplicant(homeApplicantRetrieveSO.getIdHomeApplicant());
      homeApplicantSaveSI.setIdResource(homeApplicantRetrieveSO.getIdResource());
    } else {
      homeApplicantSaveSI.setIdHomeApplicant(0);
      homeApplicantSaveSI.setIdResource(idResource);
    }
    // Inquiry Information Section
    homeApplicantSaveSI.setInquiryDate(ContextHelper.getJavaDateSafe(context, "dtDtInquiryDate"));
    homeApplicantSaveSI.setDateApplied(ContextHelper.getJavaDateSafe(context, "dtDtAppliedDate"));
    homeApplicantSaveSI.setInquiryRecvdBy(ContextHelper.getStringSafe(context, "txtSzCdInqryRcvdBy"));
    homeApplicantSaveSI.setInfoPacktRequested(ContextHelper.getStringSafe(context, "selCdInfoPcktRqstd"));
    homeApplicantSaveSI.setInfPacktSent(ContextHelper.getJavaDateSafe(context, "dtDtInfoPcktSent"));
    homeApplicantSaveSI.setIRequestedNbrOfChildren(ContextHelper.getIntSafe(context, "txtNbrRqstdNbrOfChldrn"));
    homeApplicantSaveSI.setChildSpecInterest(ContextHelper.getStringSafe(context, "txtSzChldSpcfcInterest"));
    homeApplicantSaveSI.setInquiryComments(ContextHelper.getStringSafe(context, "txtInquiryComments"));

    // Orientation/Preservice subsection
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(funcCode)) {

      homeApplicantSaveSI.setDtOrientation1(ContextHelper.getJavaDateSafe(context, "dtDtOrientation1"));
      homeApplicantSaveSI.setStrOrientationStatus1(ContextHelper.getStringSafe(context, "selOrientationStatus1"));

      homeApplicantSaveSI.setDtOrientation2(ContextHelper.getJavaDateSafe(context, "dtDtOrientation2"));
      homeApplicantSaveSI.setStrOrientationStatus2(ContextHelper.getStringSafe(context, "selOrientationStatus2"));

      homeApplicantSaveSI.setDtOrientation3(ContextHelper.getJavaDateSafe(context, "dtDtOrientation3"));
      homeApplicantSaveSI.setStrOrientationStatus3(ContextHelper.getStringSafe(context, "selOrientationStatus3"));

      homeApplicantSaveSI.setDtInvitation1(ContextHelper.getJavaDateSafe(context, "dtDtInvitation1"));
      homeApplicantSaveSI.setStrInvitationStatus1(ContextHelper.getStringSafe(context, "selInvitationStatus1"));
      homeApplicantSaveSI.setStrLocation1(ContextHelper.getStringSafe(context, "szInvitation1Location"));

      homeApplicantSaveSI.setDtInvitation2(ContextHelper.getJavaDateSafe(context, "dtDtInvitation2"));
      homeApplicantSaveSI.setStrInvitationStatus2(ContextHelper.getStringSafe(context, "selInvitationStatus2"));
      homeApplicantSaveSI.setStrLocation2(ContextHelper.getStringSafe(context, "szInvitation2Location"));

      homeApplicantSaveSI.setDtInvitation3(ContextHelper.getJavaDateSafe(context, "dtDtInvitation3"));
      homeApplicantSaveSI.setStrInvitationStatus3(ContextHelper.getStringSafe(context, "selInvitationStatus3"));
      homeApplicantSaveSI.setStrLocation3(ContextHelper.getStringSafe(context, "szInvitation3Location"));

      homeApplicantSaveSI.setOrientationComments(ContextHelper.getStringSafe(context, "txtSzOrientationComments"));
    }

    // Programs Of Interest checkboxes
    ROWCFAD08SIG07_ARRAY prgrmOfInterestInput_array = new ROWCFAD08SIG07_ARRAY();
    ROWCFAD07SOG07_ARRAY prgrmsOfInterestOutput_array = new ROWCFAD07SOG07_ARRAY();

    if (homeApplicantRetrieveSO.getArrayProgramsOfInterest() != null) {
      prgrmsOfInterestOutput_array = homeApplicantRetrieveSO.getArrayProgramsOfInterest();
    }

    Collection changedPrgmsOfInterestValues = CheckboxHelper.getChangedValues(request, "PrgmsOfInterestCbx_",
                                                                              prgrmsOfInterestOutput_array,
                                                                              ROWCFAD07SOG07.class, "szCdHmApplcntCbx");

    Iterator prgmsOfInterestIter = changedPrgmsOfInterestValues.iterator();

    while (prgmsOfInterestIter.hasNext()) {
      ObjectActionCodePair pair = (ObjectActionCodePair) prgmsOfInterestIter.next();
      ROWCFAD07SOG07 interestRow = (ROWCFAD07SOG07) pair.getObject();
      ROWCFAD08SIG07 anInterest = new ROWCFAD08SIG07();

      anInterest.setSzCdHmApplcntCbx(interestRow.getSzCdHmApplcntCbx());
      anInterest.setSzCdHmApplcntCbxType(CodesTables.CPRGMINT);
      anInterest.setSzCdSysDataActionOutcome(pair.getActionCode());
      anInterest.setTsLastUpdate(interestRow.getTsLastUpdate());

      prgrmOfInterestInput_array.addROWCFAD08SIG07(anInterest);
    }

    // Set the array into the parent struct
    homeApplicantSaveSI.setArrayProgramsOfInterest(prgrmOfInterestInput_array);

    // Sources Of Inquiry checkboxes
    ROWCFAD08SIG07_ARRAY srcsOfInquiryInput_array = new ROWCFAD08SIG07_ARRAY();
    ROWCFAD07SOG07_ARRAY srcsOfInquiryOutput_array = new ROWCFAD07SOG07_ARRAY();

    if (homeApplicantRetrieveSO.getArraySourceOfInquiry() != null) {
      srcsOfInquiryOutput_array = homeApplicantRetrieveSO.getArraySourceOfInquiry();
    }

    Collection changedSrcsOfInqValues = CheckboxHelper.getChangedValues(request, "SrcsOfInquiryCbx_",
                                                                        srcsOfInquiryOutput_array,
                                                                        ROWCFAD07SOG07.class, "szCdHmApplcntCbx");

    Iterator srcOfInqIter = changedSrcsOfInqValues.iterator();

    while (srcOfInqIter.hasNext()) {
      ObjectActionCodePair pair = (ObjectActionCodePair) srcOfInqIter.next();
      ROWCFAD07SOG07 aSrcOfInq = (ROWCFAD07SOG07) pair.getObject();
      ROWCFAD08SIG07 srcOfInqInput = new ROWCFAD08SIG07();

      srcOfInqInput.setSzCdHmApplcntCbx(aSrcOfInq.getSzCdHmApplcntCbx());
      srcOfInqInput.setSzCdHmApplcntCbxType(CodesTables.CFASRCIN);
      srcOfInqInput.setSzCdSysDataActionOutcome(pair.getActionCode());
      srcOfInqInput.setTsLastUpdate(aSrcOfInq.getTsLastUpdate());

      srcsOfInquiryInput_array.addROWCFAD08SIG07(srcOfInqInput);
    }
    // Set the array into the parent struct
    homeApplicantSaveSI.setArraySourceOfInquiry(srcsOfInquiryInput_array);

    // Information Covered checkboxes
    ROWCFAD08SIG07_ARRAY infoCvrdInput_array = new ROWCFAD08SIG07_ARRAY();
    ROWCFAD07SOG07_ARRAY infoCvrdOutput_array = new ROWCFAD07SOG07_ARRAY();

    if (homeApplicantRetrieveSO.getArrayInformationCovered() != null) {
      infoCvrdOutput_array = homeApplicantRetrieveSO.getArrayInformationCovered();
    }

    Collection changedInfoCvrdValues = CheckboxHelper.getChangedValues(request, "InfoCoveredCbx_",
                                                                       infoCvrdOutput_array, ROWCFAD07SOG07.class,
                                                                       "szCdHmApplcntCbx");

    Iterator infoCvrdIter = changedInfoCvrdValues.iterator();

    while (infoCvrdIter.hasNext()) {
      ObjectActionCodePair pair = (ObjectActionCodePair) infoCvrdIter.next();
      ROWCFAD07SOG07 anInfoCvrd = (ROWCFAD07SOG07) pair.getObject();
      ROWCFAD08SIG07 infCoveredInput = new ROWCFAD08SIG07();

      infCoveredInput.setSzCdHmApplcntCbx(anInfoCvrd.getSzCdHmApplcntCbx());
      infCoveredInput.setSzCdHmApplcntCbxType(CodesTables.CINFCVRD);
      infCoveredInput.setSzCdSysDataActionOutcome(pair.getActionCode());
      infCoveredInput.setTsLastUpdate(anInfoCvrd.getTsLastUpdate());

      infoCvrdInput_array.addROWCFAD08SIG07(infCoveredInput);
    }
    // Set the array into the parent struct
    homeApplicantSaveSI.setArrayInformationCovered(infoCvrdInput_array);

    performanceTrace.exitScope();

    return homeApplicantSaveSI;

  }

  /**
   * This method is called by the other methods when an exception is caught.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param e
   *          The Exception
   * @param methodName
   *          A String containing the method which threw the exception
   */
  protected void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    String stackTrace = BasePrsException.getStackTrace(e);

    HttpServletRequest request = context.getRequest();

    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "WtcException " + we.getClass() + " " + we.getMessage());
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_FAD_STAGE_CLOSED:
      case Messages.MSG_FAD_HISTORY_DELETED:
      case Messages.MSG_DATABASE_SAVE_FAIL:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CODE_NOT_FOUND:
      case Messages.MSG_RES_UNIQUE_VID:
      case Messages.MSG_CMN_STAGE_CLOSED:
      case Messages.ARC_ERR_BAD_FUNC_CD:
      case Messages.MSG_VNDR_PEND:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;
      case Messages.SQL_NOT_FOUND:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, context.getRequest());
        break;
      case Messages.MSG_FAD_DUPLICATE_NOT_ALLOWED:
        request.setAttribute("errorCode", Messages.MSG_FAD_DUPLICATE_NOT_ALLOWED);
        //data wasn't saved; refresh what was on the page
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } else {
      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "General Exception " + e.getClass() + " " + e.getMessage()
                                                      + stackTrace);

      if (STR_MSG_HOME_STUDY.equals(e.getMessage())) {
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(e.getMessage(), context.getRequest());
      } else if (MSG_SAVE_BEFORE_CLOSE.equals(e.getMessage())) {
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(e.getMessage(), context.getRequest());
      } else {
        GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "General Exception " + e.getClass() + " " + e.getMessage()
                                                        + stackTrace);
        processSevereException(context, e);
      }
    }
    performanceTrace.exitScope();
  }

  protected static void addOption(SortedMap<Integer, Option> restrictedStatusList, String optionCode) {
    String optionValue = Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, optionCode);
    Option option = new Option(optionCode, optionValue);
    int size = restrictedStatusList.size();
    restrictedStatusList.put(size, option);
  }

  protected static String getRegion(HttpServletRequest request) {
    // This is the correct name on both the Address Detail and Home Information
    String county = ContextHelper.getStringSafe(request, "hdnCdFacilityCounty");
    if (!StringHelper.isValid(county)) {
      county = ContextHelper.getStringSafe(request, "selCdFacilityCounty");
    }
    if (!StringHelper.isValid(county)) {
      String addressSubmoduleName = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME);
      AddressBean addressBean = AddressBean.getFromRequest(addressSubmoduleName, request);
      if (addressBean != null) {
        county = addressBean.getCounty() != null ? addressBean.getCounty() : StringHelper.EMPTY_STRING;
      }
    }
    return getRegionFromCounty(request, county);
  }

  private static String getRegionFromCounty(HttpServletRequest request, String county) {
    if (!StringHelper.isValid(county)) {
      // throw new IllegalStateException("bad county code: " + county);
      return "";
    }

    String region;

    if (OUT_OF_STATE.equals(county)) {
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      try {
        region = FormattingHelper.convertRegionCode(userProfile.getUserRegion());
      } catch (DataFormatException dfe) {
        region = CAPS_UNIT_STATE_OFFICE;
      }
    } else {
      region = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, county);
    }
    if (!StringHelper.isValid(region)) {
      throw new IllegalStateException("bad region code: " + region);
    }
    return region;
  }

  /**
   * sets the enumeration into the context. This is very generic method used by all the checkboxes needed to be
   * displayed on the jsp
   * 
   * @param context
   * @param rowcfad07sog07Enumeration
   * @param name
   */
  private void setROWCFAD07SOG07Hash(GrndsExchangeContext context, Enumeration rowcfad07sog07Enumeration, String name) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    Map<String, ROWCFAD07SOG07> rowcfad07sog07Hash = new HashMap<String, ROWCFAD07SOG07>();
    while (rowcfad07sog07Enumeration.hasMoreElements()) {
      ROWCFAD07SOG07 rowcfad07sog07 = (ROWCFAD07SOG07) rowcfad07sog07Enumeration.nextElement();
      rowcfad07sog07Hash.put(rowcfad07sog07.getSzCdHmApplcntCbx(), rowcfad07sog07);
    }
    state.setAttribute(name, rowcfad07sog07Hash, request);
  }

  private void setEthnicitiesHash(GrndsExchangeContext context, Enumeration ethEnumeration) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    Map<String, ROWCFAD07SOG03> ethnicitiesHash = new HashMap<String, ROWCFAD07SOG03>();
    while (ethEnumeration.hasMoreElements()) {
      ROWCFAD07SOG03 anEthnicity = (ROWCFAD07SOG03) ethEnumeration.nextElement();
      ethnicitiesHash.put(anEthnicity.getSzCdFaHomeIntEthnicity(), anEthnicity);
    }
    state.setAttribute("ethHash", ethnicitiesHash, request);

  }
  private void setRacesHash(GrndsExchangeContext context, Enumeration raceEnumeration) {
	    HttpServletRequest request = context.getRequest();
	    BaseSessionStateManager state = getSessionStateManager(context);

	    Map<String, HomeRaceSO> racesHash = new HashMap<String, HomeRaceSO>();
	    while (raceEnumeration.hasMoreElements()) {
	    	HomeRaceSO aRace = (HomeRaceSO) raceEnumeration.nextElement();
	      racesHash.put(aRace.getSzCdFaHomeIntRace(), aRace);
	    }
	    state.setAttribute("raceHash", racesHash, request);

  }

  private void setCharacteristicsHash(GrndsExchangeContext context, Enumeration charEnumeration) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    Map<String, ROWCFAD07SOG02> charHash = new HashMap<String, ROWCFAD07SOG02>();
    while (charEnumeration.hasMoreElements()) {
      ROWCFAD07SOG02 aCharacteristic = (ROWCFAD07SOG02) charEnumeration.nextElement();
      charHash.put(aCharacteristic.getSzCdRsrcCharChrctr(), aCharacteristic);
    }
    state.setAttribute("charHash", charHash, request);
  }

  private CCMN05UI populateCCMN05UI_InvalidateApproval(int idEvent) {

    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    ccmn05ui.setUlIdEvent(idEvent);
    ccmn05ui.setArchInputStruct(input);

    return ccmn05ui;
  }

  private CCMN01UI populateCCMN01UI_PostEvent(CFAD07SO cfad07so, int userId) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN01UI_PostEvent");

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 rowccmn01uig00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();

    input.setSzUserId(String.valueOf(userId));

    rowccmn01uig00.setUlIdEvent(cfad07so.getROWCFAD07SOG06().getUlIdEvent());
    rowccmn01uig00.setSzCdEventType(cfad07so.getROWCFAD07SOG06().getSzCdEventType());
    rowccmn01uig00.setSzCdTask(cfad07so.getROWCFAD07SOG06().getSzCdTask());
    rowccmn01uig00.setUlIdPerson(cfad07so.getROWCFAD07SOG06().getUlIdPerson());
    rowccmn01uig00.setUlIdStage(cfad07so.getROWCFAD07SOG06().getUlIdStage());
    rowccmn01uig00.setSzTxtEventDescr(cfad07so.getROWCFAD07SOG06().getSzTxtEventDescr());
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    rowccmn01uig00.setDtDtEventOccurred(cfad07so.getROWCFAD07SOG06().getDtDtEventOccurred());
    rowccmn01uig00.setTsLastUpdate(cfad07so.getROWCFAD07SOG06().getTsLastUpdate());

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

    ccmn01ui.setArchInputStruct(input);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    GrndsTrace.exitScope();

    return ccmn01ui;
  }

  private InvalidateApprovalSI populateInvalidateApprovalSI_InvalidateAndPostEvent(CCMN01UI ccmn01ui, CCMN05UI ccmn05ui) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateCCMN01UI_PostEvent");

    InvalidateApprovalSI invalidateApprovalsi = new InvalidateApprovalSI();
    invalidateApprovalsi.setCCMN01UI(ccmn01ui);
    invalidateApprovalsi.setCCMN05UI(ccmn05ui);

    GrndsTrace.exitScope();

    return invalidateApprovalsi;
  }

  /**
   * This helper method will get the user's profile and set the page mode to VIEW if the user does not have the
   * appropriate security attribute
   * 
   * @param context
   */
  private void checkPageModeForSecurity(GrndsExchangeContext context, String status) {
    HttpServletRequest request = context.getRequest();

    // Find out if the user has the SEC_MTN_HOME security attribute
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    boolean userHasRight = false;
    if (userProfile != null && userProfile.hasRight(UserProfile.SEC_MTN_HOME)) {
      userHasRight = true;
    }

    // SIR 18961
    // wildcard todo check as above
    boolean hasTodoOverride = ToDoHelper.hasPageModeEditOverride(request, TASK_MNTN_NON_LIC,
                                                                 GlobalData.getUlIdStage(request), 0);

    // Page security: if user does not the security attribute OR
    // (home is not closed AND doesn't have stage access AND has not been given a navigable todo),
    // restrict access to browse only
    if (!(userHasRight)
        || (!(CODE_STATUS_CLOSED.equals(status)) && !GlobalData.hasStageAccess(request) && !hasTodoOverride)) {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    } else {
      // STGAP00005199 - do not reset page mode if navigating from Event List; see display for more info on if condition
      // modify STGAP00002794
      if (request.getParameter("actionEventStatusCode") == null) {
        // end STGAP00005199
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      }
    }
  }

  private void checkExchangeHomeTabDisplay(GrndsExchangeContext context,  CFAD37SO cfad37so) {
    //test code
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    int idResource = cfad37so.getUlIdResource();
    // if user is Adoption Exchange Consultant or has the Adoption View Access attribute
    // they can access the Exchagne pages
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    boolean canAccessExchangeHome = userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE) || userProfile.hasRight(UserProfile.SEC_ADO_VIEW);
    
    List<String> categories  = new ArrayList<String>();
    categories.add(CodesTables.CFACATEG_A); //Adoptive
    categories.add(CodesTables.CFACATEG_D); //Relative Adopt
    categories.add(CodesTables.CFACATEG_L); //Foster/Adoptive
    boolean showExchangeHome = false;
    if(categories.contains(cfad37so.getSzCdRsrcCategory()) && canAccessExchangeHome) {
      showExchangeHome = true;
      //if type is foster and has aprv foster home conversion show tab
    } else if (CodesTables.CFACATEG_F.equals(cfad37so.getSzCdRsrcCategory())){
      showExchangeHome = adoExchange.hasAprvFosterHomeConversion(cfad37so.getUlIdResource()) && canAccessExchangeHome;
    }
    
    if(showExchangeHome == true) {
      state.setContextParameter("_exchangeHomeDetailAvailable" + idResource, ArchitectureConstants.Y, request);
    } else {
      state.removeContextParameter("_exchangeHomeDetailAvailable" + idResource, request);
    }
  }

  private void checkFHConvTabDisplay(GrndsExchangeContext context,  CFAD37SO cfad37so) {
    //test code
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    int idResource = cfad37so.getUlIdResource();
    
    List<String> categories  = new ArrayList<String>();
    categories.add(CodesTables.CFACATEG_O); //Relative Foster
    categories.add(CodesTables.CFACATEG_F); //Foster
    categories.add(CodesTables.CFACATEG_I); //ICPC Foster
    if(categories.contains(cfad37so.getSzCdRsrcCategory())) {
      state.setContextParameter("_FHConversionAvailable" + idResource, ArchitectureConstants.Y, request);
    } else {
      state.removeContextParameter("_FHConversionAvailable" + idResource, request);
    }
  }

  /**
   * Added for MR-066. This will call a service to see if an existing home
   * has the same home name or address as the one currently being saved.
   * @param context
   * @param cfad08si
   */
  private void checkDuplicateHomeNameAddress(GrndsExchangeContext context, CFAD08SI cfad08si) {
    
    Boolean doesHomeOrAddressExist = resource.checkHomeNameAddressExists(cfad08si);

    if (doesHomeOrAddressExist) {
      throw new ServiceException(Messages.MSG_FAD_DUPLICATE_NOT_ALLOWED);
    }

  }
  
  private CFAD12SI populateCFAD12SI_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD12SI_Retrieve");
    performanceTrace.enterScope();
    // Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();

    // get the id of the logged on user
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    String user = "";
    if (userProfile != null) {
      user = userProfile.getUserLogonID();
    }

    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CFAD12SI cfad12si = new CFAD12SI();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
    input.setSzUserId(user);
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(NUM_ROWS_PER_PAGE);

    cfad12si.setArchInputStruct(input);
    cfad12si.setUlIdStage(GlobalData.getUlIdStage(request));

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cfad12si;
  }
  
  /**
   * This method checks to see if Marital Status match with Person Detail record
   * when the Home Information is submitted and supervisor clicks Approval Status button                               
   * 
   * @param idStage
   * @param cdHomeMaritalStatus
   * @param resource
   * @return
   */
   
  public static boolean checkIfMaritalStatusInconsistent(int idStage, String cdHomeMaritalStatus, Resource resource) {

    CFAD08SI cfad08si = new CFAD08SI();
    ROWCFAD08SIG06 rowcfad08sig06 = new ROWCFAD08SIG06();
    ROWCFAD08SIG04 rowcfad08sig04 = new ROWCFAD08SIG04();

    rowcfad08sig06.setUlIdStage(idStage);
    rowcfad08sig04.setSzCdRshsMaritalStatus(cdHomeMaritalStatus);

    cfad08si.setROWCFAD08SIG06(rowcfad08sig06);
    cfad08si.setROWCFAD08SIG04(rowcfad08sig04);

    return resource.checkInconsistentMaritalStatus(cfad08si);
  }
}
