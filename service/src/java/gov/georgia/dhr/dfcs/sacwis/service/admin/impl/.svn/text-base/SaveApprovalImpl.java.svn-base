package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   07/16/2008  charden           STGAP00007507: wrote code to check if home is a nonDFCS home and if so, not to
 *                                 send a registration to SMILE
 *
 *   08/27/08    mxpatel           STGAP00008853:  Todo was being created with too long a description.
 *                                 Inserted if to trunkate the todo descriptions (short todo to 76)
 *                                 and added "..." at the end, if the description is too long.
 *
 *   09/8/2008   cwells            STGAP00009856: When the county has been changed for a resource...upon approval we are now
 *                                 updating Resource Address, Resource Service, Contract Service,
 *                                 and Contract Version tables.
 *
 *   09/19/2008  charden           STGAP00008024 - changed code to set the home approval date as the period start date
 *
 *   09/22/2008  ssubram           STGAP00010231 - Added code for Adoption enhancement
 *
 *   09/23/2008  charden           STGAP00006650 - created new method addRegionToRsrcServices() to save the region
 *                                 of a newly-created resource to the resourceServices table
 *  
 *   10/1/2008   sroberts          STGAP00010462 - Added new method generateSpecialNeedsEventDescription() to update the
 *                                 event description of Adoption Assistance Applications when approved/rejected.
 *                                 
 *   10/2/2008   cwells            STGAP00008188 - Added code to update the Case Budget Limit when the Policy Waiver is being 
 *                                 Approved. 
 *   10/1/2008   mchillman         STGAP00010833 - corrected null pointer exception and also changed description to match page
 *   10/08/2008  vdevarak          STGAP00010749 - Added code to call SaveAdoFinalized service when the event being approved is
 *                                 an Adoption stage closure event with reason Adoption FInalized
 *   11/17/2008  vdevarak          STGAP00010878  - Modified code to generate a new Contract with Adoptive home services for the 
 *                                 foster home, for which the approval for Foster Home Conversion is being saved
 *   11/26/2008  wjcochran         STGAP00011370 - Modified code to send an alert to the SAU when a re-evaluation for a Foster 
 *                                 Home Conversion has been approved.
 *   12/11/2008    mxpatel          STGAP00010716:  commented out the IF loops added for defect #8853. Instead inserted the in the
 *                                 todoDAO.java.
 *   01/12/2008  wjcochran         STGAP00011869 - Added Case & Stage information for Child History Checklist Alert
 *   01/16/2009  mchillman         STGAP00011976: added code to update client outbound for adoption assistance agreements
 *   01/30/2009  wjcochran         STGAP00012200 - Added logic to change app status of a foster home conversion to 'approved' and
 *                                 update the approval date
 *   01/30/2009  hnnguyen          STGAP00011866: Modified code to fix IndexOutOfBoundsException due to an attempt to iterate through 
 *                                                a contract services list based on the total number of items in the foster or adoptive 
 *                                                services codes table instead of the number of services actually on the contract.
 *   02/06/2009  mchillman         STGAP00010462 - Added code to update the event description of Adoption Assistance Applications 
 *                                 for non recurring
 *                                  
 *   02/10/2009  bgehlot           STGAP00012313 - Added code to display Closed Records info on the Exchange Home Detail Page after  
 *                                 entering and saving and approving a closure on the Home Information page. 
 *   03/23/2009  arege             STGAP00012363 - Modified code to set correct Home Status after a Pending Full Approval, 
 *                                 Pending Temporary Approval, Pending Special Approval or Pending Closure event is 
 *                                 rejected. 
 *   05/21/2009  mchillman         MR-50 update alert to be sent SAU adoption assistance consultants
 *   06/07/2009  bgehlot           STGAP00014037 - Added this code to prevent Constraint Violated Exception. Loop through the old county and
 *                                 if it's not null then update the resource service.
 *   06/23/2009  bgehlot           STGAP00014329 - Adding Alerts for the Safety Resource Page
 *   07/22/2009  hjbaptiste        STGAP00014781 - Modified sendAlertsforApprovedFCCPFamily() to include list of all principal children's name
 *                                 in a family plan that has an ADO stage. 
 *                                 - Moved the Alert (Child's permanency plan has changed) from SaveFCCPFamilyDetailImpl.java to here and 
 *                                 send the Alert only to Regional Adoption Exchange Consultants and the RACs.
 *                                 - Added code to notify Regional Adoption Exchange Consultants and RACs when a Foster Home Conversion has been approved.
 *                                 - Modified sendAlertsToSauOnChLifeHstChkListApproval()to send alert to Regional Adoption Exchange Consultants and RACs
 *                                 - Modified sendAlertsforApprovedAdoptiveHome() to send the alert to the Regional Adoption Exchange Consultants and RACs
 *                                 - Modified sendAlertsforClosedAdoptiveHome(), remove alert indicating home has been denied since alert is no longer 
 *                                 being sent to SAU and send Home closed with no placement alert only to Regional Adoption Exchange Consultants
 *                                 - Added new method sendAlertClosedHomeAdoptionFinalReceivingSubsidies() to send alert when home is that's receiving
 *                                 subsidies is closed due to Adoption Finalized
 *  07/30/2009  hjbaptiste         STGAP00014954 - Calling CountApprvPrimPermPlanGoalByCaseAndCdPrimPermPlan() to see if approved Adoption Permanency
 *                                 Plan exist for a principal that is selected on the Plan that is being approved. Using this condition to send alert to SAU     
 *  08/03/2009  cwells             STGAP00014642: Adding Resource Service to the table if we dont have an entry at the point of approval.
 *  08/04/2009  hjbaptiste         STGAP00014928 - Moved calling sendAlertClosedHomeAdoptionFinalReceivingSubsidies() to after the calling of 
 *                                 closeStageCase service 
 *  08/27/2009  bgehlot            STGAP00013590: If Foster Home Conversion check to see if the contract exists for the resource
 *  09/23/2009  arege              STGAP00012363 - Modified code so that when a Pending Closure is rejected the home status is set back to the previous
 *                                 home status that is not one of the Pending Statuses.
 *  01/06/2010  arege              STGAP00015696 MR-52 Modified the Event Description as per Adoption Assistance Application Detailed Design      
 *  01/13/2010  arege              SMS#43556 MR-52 When Adoption Assistance Application is singularly approved for Special Needs Only the description should display 
 *                                 Special Needs instead of Sp Nds   
 *  01/14/2010  arege              SMS#43647 Fixed event description for rejected Adoption Assistance Applications 
 *  02/23/2010  bgehlot            SMS#45718 MR-062 Added method saveContactStandardsEffectiveDates 
 *  02/23/2010  hjbaptiste         SMS#45718 MR-062 Remove Checking to see if the supervisory approval exists for the contact standards being approved
 *                                 and moved it to the ApprovalStatusConversation.ApproveStatus_xa()   
 *  05/24/2010  bgehlot            SMS#51977 MR-066 Changes             
 *  06/02/2010  arege              SMS#54782 While closing an Intake with screen out for Child Death by natural cause check to see if there exists 
 *                                 an approved child death event.       
 *  06/22/2010  bgehlot            SMS 59029 Shortened the Alert Text  CPS_INVESTIGATION_ALERT_FOR_SPECIAL_INV
 *  12/27/2010  htvo               SMS#88838: Reorder to place alert code before the close case/stage code so we can retrieve secondary worker.
 *                                 because SE data will be deleted from workload and stage person link after stage closed   
 *  03/21/2011  htvo               SMS#97845 MR-074-2 AFCARS: send alert to CM and supervisor when special needs determination Adoption Assistance 
 *                                 Application (Basic Rate) for non-incident child is approved                                   
 *  06/22/2010   bgehlot           SMS 59029 Shortened the Alert Text  CPS_INVESTIGATION_ALERT_FOR_SPECIAL_INV
 *  12/27/2010   htvo              SMS#88838: Reorder to place alert code before the close case/stage code so we can retrieve secondary worker.
 *                                 because SE data will be deleted from workload and stage person link after stage closed     
 *  03/22/2011 cwells              SMS#101883: updating the Intake Summary Status to closed when closing the Intake                                                                 
 *  03/21/2011  hanguyen           SMS#97850: MR-075 Updated FAD HME/CCL event rejection logic, and approval logic to handle new home statuses.
 *  03/21/2011  htvo               SMS#97845 MR-074-2 AFCARS: send alert to CM and supervisor when special needs determination Adoption Assistance 
 *                                 Application (Basic Rate) for non-incident child is approved     
 *  03/22/2011  hjbaptiste         SMS#97850: MR-75 Foster Home Batch To Dos. Fixed an NPE (Null Pointer Exception)
 *                                 whenever the Event is being updated. changed event.getPerson().getIdPerson() to
 *                                 event.getPerson() != null ? event.getPerson().getIdPerson() : 0. This prevents the NPE
 *                                 whenever the Person object was returned null.                            
 *  03/22/2011  hanguyen           SMS#97850: MR-075 Corrected approval logic that set resource status while home status is Approved,
 *                                 at any other time resource status should be inactive, not the other way around which old code was doing.
 *  03/22/2011  hanguyen           SMS#97850: MR-075 Updated home approval to update hold placement explicitly if status is approved for a non-full approval status.
 *  04/20/2011  hanguyen           SMS#106562: MR-075 Corrected some production issues with the order of home type discovered after enhancement changes to home approval.
 *  05/26/2011  hanguyen           SMS#109407: MR-087 Added new method to send alerts on approval of payment of care event.
 *  06/10/2011  hjbaptiste         SMS#109631: CAPTA 4.3: Special Investigation - Send alerts when policy unit approves Special Investigation and 
 *                                 removed the hold on resource if it's a home. Also, send alert for CPS Investigation Conclusion when there's no
 *                                 Maltreatment in Care but is a Policy Violation. Sending alert for approving Intake when there's Maltreatment In
 *                                 Care
 *  06/17/2011  llokhand           SMS#109631: CAPTA 4.3 Modified alert text.
 *  06/22/2011  charden            SMS#109631: CAPTA 4.3: removed resource name truncation, modified alert message and added long description to todo
 *  06/22/2011  hjbaptiste         SMS#112737: CAPTA 4.3 Approval Status - Shortened and updated the short description as well as updated the
 *                                 long description of alerts
 *  06/23/2011  hjbaptiste         SMS#109631: CAPTA 4.3: Special Investigation - Setting the date the Special Investigation is sent to the Policy
 *                                 Unit and when they approve it
 *  06/29/2011  hjbaptiste         SMS#112737: CAPTA 4.3: Special Investigation - Adding the OPUOM_SPLCST_DRCTR profile to send alerts to those 
 *                                 belonging in that unit and the director of the unit 
 *  07/01/2011  hjbaptiste         SMS#109631: CAPTA 4.3: Special Investigation - Sending alerts to everyone with the DEPUTY_DIRECTOR profile instead
 *                                 of the first person in the list
 *                                 SMS#114045: CAPTA 4.3: Setting the facility type to what is in the resource table 
 *  07/06/2011  charden            CO-CAPTA4.3-5.3.16: CPS Investigation Conclusion - removing hold from hold when allegations of Maltreatment in Care
 *                                 made during the intake are not substantiated. Also sending alerts to the case manager and their supervisor, the
 *                                 resource development case manager and their supervisor, and the case manager of each child currently placed in the home
 *  07/07/2011  htvo               SMS#114235: specify on the event description if it is the non-recurring only application being approved 
 *  07/08/2011  arege              SMS#109422: Records check required message needs to be thrown when approving Screen Out intakes.    
 *  07/09/2011  hjbaptiste         SMS#114045: CAPTA 4.3: Special Investigation - Modified logic to find case manager of chil's SUB stage for
 *                                 generated alerts
 *  07/12/2011  hjbaptiste         SMS#114045: CAPTA 4.3: Special Investigation - Fixed certain people not receiving alerts        
 *  10/31/2011  arege              STGAP00016924: Create  "2270" Task Todo  for CaseManager after a substantiated INV conclusion  is approved.
 *  11/16/2011  arege              STGAP00016924 and STGAP00017681: Create above task only if the answer to questions Is this a Policy Violation?   and Is this Maltreatment in Care? is 'Y'
 *  01/26/2012  habraham           STGAP00017829 - MR-097 - Modified the code to change the conditions to add UnsubstantiatedMICindicator for the task and alert
 *                                 which are sending to the SSCM for doing a  Special Investigation 
 *  02/23/2012  vcollooru          STGAP00017922: Modified to set the users with CDNFSI_ALERT profile to receive the Child Death, Near Fatality or Serious Injury alerts.
 *  03/07/2012  schoi              STGAP00017979 Per design, Policy Specialist is removed from the alert 
 *                                 'Special Investigation, MIC, or Policy Violation approved for a provider.'
 *  
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cstages;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalRejectionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactStandardsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvPerLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvestigationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TaskDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.Approval;
import gov.georgia.dhr.dfcs.sacwis.db.ApprovalRejection;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriodId;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.ContractVersion;
import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingFacility;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistoryAudit;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Task;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseOpenStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveAdoFinalized;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveAutoAdoStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveStageClosureAlerts;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveStageProgression;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveTodo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSpecializedUnitPersonnel;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePlacementAlerts;
import gov.georgia.dhr.dfcs.sacwis.service.common.DetermineWhichApprover;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCaseBudgetLimitList;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveVendorOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveSpclInvestigation;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN61DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpclInvestigationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TodoAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VendorOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN35SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB68SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvHmeWaiverChildHistBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationRetrieveSO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SaveApprovalImpl extends BaseServiceImpl implements SaveApproval {
	
  private static final String SEC_STATE_OFFICE_CONSULTANT = "78";

  private static final String INDICATOR_YES = ArchitectureConstants.Y;

  private static final String INDICATOR_NO = ArchitectureConstants.N;

  private static final String NO_LIMIT = CodesTables.CBJNTCNT_N;
  
  
  // private static final int ZERO = 0;

  private static final int ONE = 1;

  // private static final int TWO = 2;

  // private static final String STARS = "S";

  // private static final String STARS_IMPACT = "B";

  // private static final String IMPACT = "C";

  private static final String PERSON_TYPE_WORKER = "STF";

  private static final String PERSON_STAGE_ROLE_PRIMARY = "PR";

  private static final String RSRC_PRIM_ADDR = CodesTables.CRSCADDR_01;

  private static final String COUNTY_CD_OUT_OF_STATE = CodesTables.CCOUNT_999;

  private static final String UNIT_MEMBER_IN_ASSIGNED = "IN";

  private static final int ADOPTIVE = 2;

  private static final int FOSTER = 1;

  private static final String STAGE_CD_FAD = CodesTables.CCONFUNC_FAD;

  private static final String FA_PROGRAM = CodesTables.CCONPROG_CPS;

  private static final String PROVIDER_ENROLL = CodesTables.CCONPROC_PEN;

  private static final String SCREEN_OUT_NO_MALTREATMENT_CODE = "SNM";

  // private static final int NBR_OF_HOME_TYPE = 6;

  private static final String INTAKE = CodesTables.CSTAGES_INT;
  
  private static final String DEPUTY_DIRECTOR_PROFILE = "DEPUTY_DIRECTOR";
  
  private static final String POLICY_UNIT = "Policy Unit";
   
  public static final String COUNTY_DIRECTOR = "County Director";
  
  public static final String SPECIAL_INVESTIGATION = "Special Investigation";
  
  public static final String VACANT_PERSON = "Vacant";
  
  private static final String NBR_UNIT_COUNTY_DIRECTOR = "18";
  
  private static final String NBR_UNIT_PERMANENCY_DIRECTOR = "R2";
  
  private static final String NBR_UNIT_SPCL_INVESTIGATION = "R2";
  
  private static final String STATE_OFFICE_REGION = "099";

  // private static final String PERSON_ROLE_PRINCIPAL = "PRN";

  // Child Plan -- Plan Types
  // private static final String INIT_PLAN = "IPN";

  // private static final String INIT_PLAN_PAL = "IPL";

  // private static final String REVIEW = "RVW";

  // private static final String REVIEW_PAL = "RVL";

  // private static final String FAC_REVIEW = "FRV";

  // private static final String FAC_REVIEW_PAL = "FRP";

  // private static final String ADOPT_PLAN = "ADP";

  // private static final String INIT_PLAN_THER = "IPT";

  // private static final String INIT_PAL_THER = "IPP";

  // private static final String REVIEW_THER = "RVT";

  // private static final String REVIEW_PAL_THER = "RVP";

  // Task Codes
  private static final String RE_EVALUATE = "8090";

  private static final String FA_HOME_HME = "8200";
  
  private static final String FA_HOME_HME_EVAL = "8020"; //STGAP00012363: Code for Approve Home Evaluation
  
  private static final String FA_HOME_RVF = "8220";
  
  // private static final String CHILD_PLAN = "3160";

  // private static final String ADOPTION_PLAN = "8660";

  private static final String PW_INV_POL_WAIV = "2321";

  private static final String PW_FAD_POL_WAIV = "8093";

  private static final String SA_CPS_FAM_PRES = "7100";

  private static final String SA_CPS_INVEST = "2310";

  private static final String SA_CPS_ADOPT = "8530";

  private static final String SA_CPS_POST_ADOPT = "9020";

  private static final String SA_CPS_SUBCARE = "3020";

  private static final String SA_CPS_FSU = "4190";

  private static final String SA_CPS_PFC = "2000";

  private static final String SA_CPS_DIV = "6000";

  private static final String PLCMT_SUB1 = "3090";

  private static final String PLCMT_SUB2 = "3080";

  private static final String PLCMT_ADO1 = "8600";

  private static final String PLCMT_ADO2 = "8590";

  private static final String PLCMT_PAD1 = "9080";

  private static final String PLCMT_PAD2 = "9090";

  private static final String PLCMT_PFC1 = "9085";

  private static final String PLCMT_PFC2 = "9086";

  private static final String TASK_CLOSE_HOME = "8170";

  public static final String ADO_ASSIST_APP_TASK = "8610"; 
  
  public static final String PAD_ADO_ASSIST_APP_TASK = "9100"; // SMS#97845 MR-074-2 AFCARS
  
  // The Todo Codes
  private static final String TODO_FA_HOME = "FAD043";

  // private static final String TODO_SUB_DUE_6MOS = "SUB015";

  // private static final String TODO_ADO_DUE_6MOS = "ADO015";

  // private static final String TODO_SUB_DUE_3MOS = "SUB016";

  // private static final String TODO_SVC_AUTH_CPS = "CON001";

  private static final String TODO_UPDATE_STATUS = "FAD039";

  // FAD Task Codes
  private static final String TASK_MNTN_LIC = "8020";

  private static final String EVENT_TYPE_HOME = CodesTables.CEVNTTYP_HME;

  private static final String CONTRACT_STATUS_ACTIVE = CodesTables.CCONSTAT_ACT;

  private static final String CONTRACT_STATUS_CLOSED = CodesTables.CCONSTAT_CLS;

  private static final String CONTRACT_STATUS_SERVICE_HOLD = CodesTables.CCONSTAT_SVH;

  // Resource Statuses (for CdRsrcStatus)
  private static final String RSRC_STAT_ACTIVE = CodesTables.CRSCSTAT_01;

  private static final String RSRC_STAT_INACTIVE = CodesTables.CRSCSTAT_02;

  // Status of FA Homes
  private static final String HOME_STATUS_APVD_FULL_ACT = CodesTables.CFAHMSTA_AFA;

  private static final String HOME_STATUS_APVD_TEMP_ACT = CodesTables.CFAHMSTA_ATA;

  private static final String HOME_STATUS_APVD_SPEC_ACT = CodesTables.CFAHMSTA_ASA;

  private static final String HOME_STATUS_CLOSED = CodesTables.CFAHMSTA_CSD;

  private static final String FA_CATG_FOST = CodesTables.CFACATEG_F;
  
  private static final String FA_CATG_ADOPT = CodesTables.CFACATEG_A;

  private static final String FA_CATG_FOST_ADO_LEG_RISK = CodesTables.CFACATEG_L;

  private static final String FA_CATG_ICPC_FOSTER = CodesTables.CFACATEG_I;

  private static final String FA_CATG_ICPC_ADOPT = CodesTables.CFACATEG_J;
  
  private static final String FA_CATG_REL_ADOPT = CodesTables.CFACATEG_D;

  private static final String FA_CATG_REL_FOST = CodesTables.CFACATEG_O;

  // Status of Events
  private static final String EVENT_STATUS_APRV = CodesTables.CEVTSTAT_APRV;

  // Service Macro Definitions

  private static final String WIN_INVALID = "INV";

  private static final String WIN_APPROVE = "APR";

  private static final String WIN_REJECT = "REJ";

  private static final String WIN_COMPAPRV = "COM";

  private static final String TODO_ALERT = "A";

  private static final String SP_MANUAL = "W";

  private static final String SP_AUTOMATIC = "P";

  private static final String ADOPTION_STAGE = "ADO";

  private static final String ADO_CMTD = "010";

  private static final String UNAB_COMP = "20";

  private static final String REQ_WITH = "30";

  private static final String SVC_COMP = "10";

  private static final String SP_CASECLOSE = "C";

  // Program Types
  // private static final String PROGRAM_AFC = CodesTables.CSRPGTYP_AFC;

  // private static final String SERVICES = CodesTables.CSVCCODE;

  // private static final int THIRTY_DAYS = 30;

  // Division/Region Conversion values
  private static final String CAPS_UNIT_STATE_OFFICE = "99";

  // The ToDo Alert Descriptions
  private static final String APR_WORKER = "New approval determination logged. Outstanding requests exist.";

  private static final String APR_DESIGNEE = "Designee Logged Approval. Outstanding requests exist.";

  private static final String REJ_WORKER = "Rejection determination logged. Other approval requests invalidated.";

  private static final String REJ_DESIGNEE = "Designee Logged Rejection. Other requests invalidated.";

  private static final String COM_WORKER = "Approval Complete! Events have been frozen.";

  // private static final String COM_CASE_MAN = "An Intake report has been received on an approved foster home";

  private static final String COM_SUPERVISOR = " is involved in Intake ";

  private static final String COM_DESIGNEE = "Designee Logged Approval. Events have been frozen.";

  private static final String APR_CHILD_DEATH = "An Intake regarding a child death has been reviewed and approved.";

  private static final String APR_SERIOUS_INJURY = "An Intake regarding a serious injury has been reviewed and approved.";
  
  private static final String APR_NEAR_FATALITY = "An Intake regarding a near fatality has been reviewed and approved.";
  
  //CAPTA 4.3 MIC and Policy Violation alerts.
  //Alert for Maltreatment In Care.
  private static final String ALERT_MIC_TEXT = "Maltreatment in Care has been alleged on an Intake.";
  //Alert for Policy Violation
  private static final String ALERT_POLICY_VIOLATION_TEXT = "A Policy Violation has been alleged on an Intake.";
  //Alert for Placement On Hold
  private static final String ALERT_PLACEMENT_ON_HOLD = "A home has been placed on hold.";
  //Alerts for Special Investigation State Office Concurrence.
  private static final String ALERT_SPCL_INV_CONCUR_START = "State Office " ;
  private static final String ALERT_SPCL_INV_CONCUR_END = " with the assessment disposition." ;
  

  // private static final String APR_CPS_INVESTIGATION =
  // "Submit a review packet to the Social Services Director within 10 working days.";

  private static final String APPROVE_CALL_CD_TASK_CHILD_DEATH = "1041";

  private static final String APPROVE_CALL_CD_TASK_SERIOUS_INJURY = "1042";  
  
  private static final String APPROVE_CALL_SPECIAL_REQUEST = "1044";
  
  private static final String APPROVE_CALL_CD_TASK_NEAR_FATALITY = "1045";


  // private static final String CDISP_IC = "IC";

  // private static final String CDISP_PA = "PA";

  // private static final String CDISP_PF = "PF";

  // private static final String CDISP_NI = "NI";

  private static final String APPROVE_CPS_INVESTIGATION = "2340";
  
  private static final String APPROVE_FCCP_FAMILY = "4320";

  private static final String APPROVE_CPS_INTAKE = "1040";
  
  private static final String APPROVE_INTAKE_CLOSURE = "1100"; //SMS#109422

  private static final String EVT_COMP = CodesTables.CEVTSTAT_COMP;
  
  private static final String ADOPTION_ASSISTANCE_AGREEMENT = "Approve Adoption Assistance Agreement";

  private static final String APPROVE_SERVICE_AUTHORIZATION = "Approve Service Authorization";

  private static final String APPROVE_PAYMENT_OF_CARE = "Approve Payment of Care";

  private static final String APPROVE_LEGAL_ACTION = "Approve Legal Action";
  
  private static final String APPROVE_HOME_CONVERSION = "Approve Home Conversion";
  
  private static final String APPROVE_ADO_STAGE_CLOSURE = "Approve Adoption Closure";

  public static final String APPRV_TASK_SUB_PLCMNT = "3320";

  public static final String APPRV_TASK_ADO_PLCMNT = "8830";
  
  private static final String FOST_HOME_CONV_TASK = "9997";
  
  public static final String IND_ADOPTION_FINALIZED = "indAdoptionFinalized";
  
  public static final String SPCL_INV_APPROVAL_TASK = "2265";
  
  public static final String WHICH_SPCL_INV_APPROVER = "whichSpclInvApprover";
  
  private static final String TASK_CLOSE_ADO_STAGE = "8910";
  
  private static final String TASK_CLOSE_SUB_STAGE = "3420";
  
  private static final String TASK_CLOSE_PAD_STAGE = "9400";
  
  private static final String APPROVE_CHILD_LIFE_HISTORY_CHECK_LIST = "8900";
  
  private static final String APPROVE_CONTACT_STANDARDS = "Approve Contact Standards";
  
  //STGAP00014329: Safety Resource Approve codes
  public static final String SAFETY_RESOURCE_INV_TASK_CODE = "2277";
  public static final String SAFETY_RESOURCE_ONG_TASK_CODE = "7331"; 
  
  //SMS#51977 MR-066 
  
  public static final String PRU_DIRECTOR_SECURITY_CLASS_NAME = "OPUOM_SPC_DRCTR";
 //CAPTA 4.3
  public static final String OFFICE_PROVIDER_MAINTENANCE = "ORS_PRU_MAINT";
  
  public static final String PRU_STAFF_SECURITY_CLASS_NAME = "STATE_CONC";

  public static final String CDNFSI_ALERT_PROFILE = "CDNFSI_ALERT";

  private SaveCaseBudgetLimitList saveCaseBudgetLimitList = null;
  
  private RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel = null;

  private SavePlacementAlerts savePlacementAlerts = null;

  private SaveVendorOutbound saveVendorOutbound = null;

  private ApproversDAO approversDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private ApprovalRejectionDAO approvalRejectionDAO = null;

  private CapsCaseDAO capsCaseDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private CloseStageCase closeStageCase = null;

  private CloseOpenStage closeOpenStage = null;

  private ComplexCapsResourceDAO complexCapsResourceDAO = null;

  private ComplexEventDAO complexEventDAO = null;

  private ContractDAO contractDAO = null;

  private ContractPeriodDAO contractPeriodDAO = null;

  private ContractVersionDAO contractVersionDAO = null;

  private ContractServiceDAO contractServiceDAO = null;

  private ContractCountyDAO contractCountyDAO = null;
  
  private DetermineWhichApprover determineWhichApprover = null;

  private EmployeeDAO employeeDAO = null;
  
  private EmpTempAssignDAO empTempAssignDAO = null;

  private EventDAO eventDAO = null;
  
  private PaymentOfCareDAO paymentOfCareDAO = null;

  private PersonDAO personDAO = null;

  private PostEvent postEvent = null;

  private ResourceAddressDAO resourceAddressDAO = null;

  private ResourceHistoryDAO resourceHistoryDAO = null;

  private ResourceHistoryAuditDAO resourceHistoryAuditDAO = null;

  private ResourceServiceDAO resourceServiceDAO = null;

  private SaveAutoAdoStage saveAutoAdoStage = null;

  private SaveClientOutbound saveClientOutbound = null;

  private SaveStageProgression saveStageProgression = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private StageDAO stageDAO = null;

  // private StageLinkDAO stageLinkDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private TaskDAO taskDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private TodoDAO todoDAO = null;

  private ComplexTodoDAO complexTodoDAO = null;
  
  private UnitDAO unitDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private PlacementDAO placementDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private LegalActionDAO legalActionDAO = null;

  private LegalActionOutcomeDAO legalActionOutcomeDAO = null;

  private CountyBudgetLimitDAO countyBudgetLimitDAO = null;

  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private SaveAdoFinalized saveAdoFinalized = null;
  
  private SpclInvestigationDAO spclInvestigationDAO = null;
  
  private FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO = null;
  
  private FosterHomeConvDAO fosterHomeConvDAO = null;
  
  private AdoInfoDAO adoInfoDAO = null;
  
  private RsrcLinkDAO rsrcLinkDAO = null;

  private ExchangeHomeDAO exchangeHomeDAO = null;
  
  private AdptSubEventLinkDAO adptSubEventLinkDAO = null;
  
  private RetrieveSpclInvestigation retrieveSpclInvestigation = null;
  
  private SaveStageClosureAlerts saveStageClosureAlerts = null;
  
  private SafetyResourceDAO safetyResourceDAO = null;
  
  private FCCPFamilyDAO fccpFamilyDAO = null;
  
  private ContactStandardsDAO contactStandardsDAO = null;
  
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  
  private IncomingFacilityDAO incomingFacilityDAO = null;
  
  private SaveTodo saveTodo; // SMS#97845 MR-074-2 AFCARS
  
  public void setSaveTodo(SaveTodo saveTodo) {
    this.saveTodo = saveTodo;
  }

  public void setSaveAdoFinalized(SaveAdoFinalized saveAdoFinalized) {
    this.saveAdoFinalized = saveAdoFinalized;
  }

  public void setRetrieveSpecializedUnitPersonnel(RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel){
	  this.retrieveSpecializedUnitPersonnel = retrieveSpecializedUnitPersonnel;
  }

  public void setCountyBudgetLimitDAO(CountyBudgetLimitDAO countyBudgetLimitDAO) {
    this.countyBudgetLimitDAO = countyBudgetLimitDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApprovalRejectionDAO(ApprovalRejectionDAO approvalRejectionDAO) {
    this.approvalRejectionDAO = approvalRejectionDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  public void setCloseOpenStage(CloseOpenStage closeOpenStage) {
    this.closeOpenStage = closeOpenStage;
  }

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }

  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public void setContractVersionDAO(ContractVersionDAO contractVersionDAO) {
    this.contractVersionDAO = contractVersionDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setDetermineWhichApprover(DetermineWhichApprover determineWhichApprover) {
    this.determineWhichApprover = determineWhichApprover;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
    this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public void setResourceHistoryAuditDAO(ResourceHistoryAuditDAO resourceHistoryAuditDAO) {
    this.resourceHistoryAuditDAO = resourceHistoryAuditDAO;
  }

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public void setSaveAutoAdoStage(SaveAutoAdoStage saveAutoAdoStage) {
    this.saveAutoAdoStage = saveAutoAdoStage;
  }

  public void setSaveClientOutbound(SaveClientOutbound saveClientOutbound) {
    this.saveClientOutbound = saveClientOutbound;
  }

  public void setSaveStageProgression(SaveStageProgression saveStageProgression) {
    this.saveStageProgression = saveStageProgression;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setTaskDAO(TaskDAO taskDAO) {
    this.taskDAO = taskDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
  
  public void setSaveCaseBudgetLimitList(SaveCaseBudgetLimitList saveCaseBudgetLimitList) {
    this.saveCaseBudgetLimitList = saveCaseBudgetLimitList;
  }

  public void setSavePlacementAlerts(SavePlacementAlerts savePlacementAlerts) {
    this.savePlacementAlerts = savePlacementAlerts;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setSpclInvestigationDAO(SpclInvestigationDAO spclInvestigationDAO) {
    this.spclInvestigationDAO = spclInvestigationDAO;
  }

  public void setSaveVendorOutbound(SaveVendorOutbound saveVendorOutbound) {
    this.saveVendorOutbound = saveVendorOutbound;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }
  
  public void setFosterHomeConvPerLinkDAO(FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO) {
    this.fosterHomeConvPerLinkDAO = fosterHomeConvPerLinkDAO;
  }

  public void setFosterHomeConvDAO(FosterHomeConvDAO fosterHomeConvDAO) {
    this.fosterHomeConvDAO = fosterHomeConvDAO;
  }
  
  public void setAdoInfoDAO(AdoInfoDAO adoInfoDAO) {
    this.adoInfoDAO = adoInfoDAO;
  }
  
  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }

  public void setExchangeHomeDAO(ExchangeHomeDAO exchangeHomeDAO) {
    this.exchangeHomeDAO = exchangeHomeDAO;
  }
  
  public void setAdptSubEventLinkDAO(AdptSubEventLinkDAO adptSubEventLinkDAO) {
    this.adptSubEventLinkDAO = adptSubEventLinkDAO;
  }
    
  public void setRetrieveSpclInvestigation(RetrieveSpclInvestigation retrieveSpclInvestigation) {
    this.retrieveSpclInvestigation = retrieveSpclInvestigation;
  }

  public void setSafetyResourceDAO(SafetyResourceDAO safetyResourceDAO) {
    this.safetyResourceDAO = safetyResourceDAO;
  }
  
  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }
  
  public void setContactStandardsDAO(ContactStandardsDAO contactStandardsDAO) {
    this.contactStandardsDAO = contactStandardsDAO;
  } 
  
  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }
  
  public void setIncomingFacilityDAO(IncomingFacilityDAO incomingFacilityDAO) {
    this.incomingFacilityDAO = incomingFacilityDAO;
  }
  
  private static final Set<String> SPCL_INV_RSRC_TYPE_ONE = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CFACTYP4_70,
                                             CodesTables.CFACTYP4_RC,
                                             CodesTables.CFACTYP4_RE,
                                             CodesTables.CFACTYP4_RN,
                                             CodesTables.CFACTYP4_RT}));
  
  private static final Set<String> SPCL_INV_RSRC_TYPE_TWO = new HashSet<String>(
                  Arrays.asList(new String[]{CodesTables.CFACTYP4_CC,
                                             CodesTables.CFACTYP4_SH,
                                             CodesTables.CFACTYP4_71,
                                             CodesTables.CFACTYP4_CP,
                                             CodesTables.CFACTYP4_MH,
                                             CodesTables.CFACTYP4_OT}));
  
  

  @SuppressWarnings( { "unchecked" })
  public CCMN35SO saveApproval(CCMN35SI ccmn35si) throws ServiceException {
    CCMN35SO ccmn35so = new CCMN35SO();

    String cReqFuncCd = ccmn35si.getArchInputStruct().getCReqFuncCd();

    int idApproval_ccmn35si = ccmn35si.getUlIdApproval();
    int idTodo_ccmn35si = ccmn35si.getLdIdTodo();
    int idStage_ccmn35si = ccmn35si.getUlIdStage();
    String cdStage_ccmn35si = ccmn35si.getSzCdStage();
    int idCntrctWkr = ccmn35si.getUlIdCntrctWkr();
    int idResource_csec38d = 0;
    int idEvent_ccmn01uo = 0;
    int idCase_ccmn35si = ccmn35si.getUlIdCase();
    int idPerson_ccmn35si = ccmn35si.getUlIdPerson();

    // int nbrRowsDeleted;
    int nbrRowsUpdated;
    int tempSvcRowQty1 = 0;
    int idResourceCapsResource = 0;
    // int createContract = 0;
    int intUpdateContract = 0;
    // int intAdoptOrFoster = 0;
    // String adoptiveOrFoster = null;
    // List<String> adoptiveOrFosterList = null;
    String tempCdCntrctRegion = null;

    // boolean bEA_12Months = false;
    //boolean bAdoptive = true;
    //boolean bFoster = true;
    // boolean bChange = true;
    boolean indFosterContractExists = false;
    boolean indUpdateFosterContract = false;
    boolean indAdoptContractExists = false;
    boolean indUpdateAdoptContract = false;
    String indRsrcNonDfcs = "N";
    CapsResource capsResource_cses41d = null;
    Todo todo;

    // ccmn35si.getSzCdTask()is null here because ApprovalStatusConversation remove szCdTask from global data in order
    // to get tabs to show up
    // right, To get the cdTask we need to get cdTask from idTodo
    todo = todoDAO.findTodoByIdTodo(ccmn35si.getLdIdTodo());
    if (todo == null) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }

    String cdDisposition = null;

    if (todo.getStage() != null) {
      if (todo.getStage().getIncomingDetail() != null) {
        cdDisposition = todo.getStage().getIncomingDetail().getCdIncomingDisposition();
      }
    }
    ccmn35si.setSzCdTask(todo.getCdTodoTask());
    String cdTask_ccmn35si = ccmn35si.getSzCdTask();

    // INVALIDATED ALREADY SCENARIO
    if (WIN_INVALID.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
      Date dtLastUpdate = DateHelper.MAX_JAVA_DATE;
      // CallCCMN43D - Delete the Todo
      todoDAO.deleteTodoByIdTodoAndDtLastUpdate(idTodo_ccmn35si, dtLastUpdate);
    } // SAVE APPROVAL DETERMINATION SCENERIO
    else if (WIN_APPROVE.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
      // CallCCMN46D - Update the Event Status
      ROWCCMN01UIG00 rowccmn01uig00 = ccmn35si.getROWCCMN01UIG00();
      audEvent(rowccmn01uig00, cReqFuncCd);

      // CAPTA 4.3: If Special Investigation is being approved, then SzWcdCdAprvlWinaction will be set to WIN_APPROVE
      // until the last approver.
      if (SPCL_INV_APPROVAL_TASK.equals(cdTask_ccmn35si)) {
        int idEvent = ccmn35si.getUlIdEvent();
        // If the County Director is approving the Special Investigation, save the date it is being sent the Policy Unit
        if (COUNTY_DIRECTOR.equals(determineWhichApprover.determineWhichApprover(idApproval_ccmn35si, SPECIAL_INVESTIGATION))) {
          spclInvestigationDAO.updateSpclInvDateSent(new Date(), idEvent);
          // If the County Director is approving the Special Investigation, send alert to Policy Unit informing
          // that the Investigation Concurrence Memo is due
          sendAlertsForSpclInvConcurrenceDue(idPerson_ccmn35si, idStage_ccmn35si, idCase_ccmn35si, cdTask_ccmn35si);
        }
        // If the Policy Unit is approving the Special Investigation, save the date the Policy Unit perform the approval
        if (POLICY_UNIT.equals(determineWhichApprover.determineWhichApprover(idApproval_ccmn35si, SPECIAL_INVESTIGATION))) {
          spclInvestigationDAO.updateSpclInvDateApproved(new Date(), idEvent);
        }
      }
      
      ROWCCMN61DI rowccmn61di = ccmn35si.getROWCCMN61DI();
      // CallCCMN61D - Save the Approval Determination
      audApprovers(rowccmn61di, cReqFuncCd);

      Date tsMaxTimeStamp = DateHelper.MAX_JAVA_DATE;
      
      // CallCCMN43D - delete todo
      todoDAO.deleteTodoByIdTodoAndDtLastUpdate(idTodo_ccmn35si, tsMaxTimeStamp);

      // -- set idTodo in Approvers to 0
      approversDAO.updateIdTodoByIdTodo(idTodo_ccmn35si, 0);

      todo = createTodo(idPerson_ccmn35si, idStage_ccmn35si, idCase_ccmn35si, cdTask_ccmn35si);
      // todo.setTxtTodoDesc(APR_WORKER);
      // CallCCMN43D - save todo (Send Notification to Worker)
      // todoDAO.saveTodo(todo);

      // Check if Supervisor Notification Necessary
      if (INDICATOR_YES.equals(ccmn35si.getBIndDesigneeAprvl())) {
        // -- first set appropriate description and notify worker
        todo.setTxtTodoDesc(APR_DESIGNEE);
        todoDAO.saveTodo(todo);

        // -- next notify supervisor
        todo = createTodo(idPerson_ccmn35si, idStage_ccmn35si, idCase_ccmn35si, cdTask_ccmn35si);
        todo.setPersonByIdTodoPersAssigned(retrieveUnitSupervisorByCaseManagerId(ccmn35si.getUlIdPerson()));
        todo.setTxtTodoDesc(APR_DESIGNEE);
        // CallCCMN43D - save todo (Send Notification to Supervisor)
        todoDAO.saveTodo(todo);
      } else {
        // -- set appropriate description and notify worker
        todo.setTxtTodoDesc(APR_WORKER);
        todoDAO.saveTodo(todo);
      }
      
    } // SAVE REJECTION DETERMINATION SCENARIO
    else if (WIN_REJECT.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
      ROWCCMNI2DI rowccmni2di = ccmn35si.getROWCCMNI2DI();
      // CallCCMNI2D
      // saveApprovalRejection(rowccmni2di, cReqFuncCd);
      saveApprovalRejection(rowccmni2di, ccmn35si.getUlIdApproval());

      // CallCCMN46D - Update the Event Status (Intervening Update Strategy)
      ROWCCMN01UIG00 rowccmn01uig00 = ccmn35si.getROWCCMN01UIG00();
      audEvent(rowccmn01uig00, cReqFuncCd);

      ROWCCMN61DI rowccmn61di = ccmn35si.getROWCCMN61DI();
      // CallCCMN61D - Save the Approval Determination
      audApprovers(rowccmn61di, cReqFuncCd);

      // CallCCMN88D - Invalidate all other Approvers
      updateApproversStatus(idApproval_ccmn35si, cReqFuncCd);

      // CallCCMN57D - Get list of related Events
      List<Map> approvalEventLinkList = findRelatedEvents(idApproval_ccmn35si);
      // We have to filter for SQL Not Found, because approvalEventLinkList is used
      // in the next (CCMN62D) preceding call.
      if (approvalEventLinkList == null || approvalEventLinkList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      String wcdCdAprvlWinaction = ccmn35si.getSzWcdCdAprvlWinaction();
      // CallCCMN62D - Demote related Events
      updateEvent(approvalEventLinkList, cReqFuncCd, wcdCdAprvlWinaction);

      // CallCCMN43D - Delete todo
      todoDAO.deleteTodoByIdTodoAndDtLastUpdate(idTodo_ccmn35si, DateHelper.MAX_JAVA_DATE);
      // STGAP00005977 - mark idTodo 0 in Approvers for the rejection record so that when the page event needs to be
      // deleted in other transaction, we know that these todos have already been deleted as part of rejection progress
      // (see CallCCMN43D - Delete todo above) and don't call delete on those todo again to avoid ObjectNotFound
      // exception
      // More efficient way is to modify approversDAO.updateApproversByIdApproversAndDtLastUpdate() in as audApprovers()
      // to mark this field 0. However, decided to put it here to make flow of action clear: only after approval todo is
      // deleted
      // should we mark its id in approvers table 0 to indicate that todo is no longer valid or exists, not before todo
      // is
      // deleted
      approversDAO.updateIdTodoByIdApprovers(rowccmn61di.getUlIdApprovers(), 0);

      todo = createTodo(idPerson_ccmn35si, idStage_ccmn35si, idCase_ccmn35si, cdTask_ccmn35si);
      // todo.setTxtTodoDesc(REJ_WORKER);
      // CallCCMN43D - save todo (Send Notification to Worker)
      // todoDAO.saveTodo(todo);

      // Check if Supervisor Notification Necessary
      if (INDICATOR_YES.equals(ccmn35si.getBIndDesigneeAprvl())) {
        // -- first set appropriate description and notify worker
        todo.setTxtTodoDesc(REJ_DESIGNEE);
        todoDAO.saveTodo(todo);

        // -- next notify supervisor
        todo = createTodo(idPerson_ccmn35si, idStage_ccmn35si, idCase_ccmn35si, cdTask_ccmn35si);
        todo.setPersonByIdTodoPersAssigned(retrieveUnitSupervisorByCaseManagerId(ccmn35si.getUlIdPerson()));
        todo.setTxtTodoDesc(REJ_DESIGNEE);
        // CallCCMN43D - save todo (Send Notification to Supervisor )
        todoDAO.saveTodo(todo);
      } else {
        // -- set appropriate description and notify worker
        todo.setTxtTodoDesc(REJ_WORKER);
        todoDAO.saveTodo(todo);
      }

      for (Iterator<Map> it = approvalEventLinkList.iterator(); it.hasNext();) {
        Map approvalEventLinkMap = it.next();
        int idEvent = (Integer) approvalEventLinkMap.get("idEvent");
        String cdTask = (String) approvalEventLinkMap.get("cdTask");
        // For each Event in this list, check the Task Code to see if it is an FA Home event.
        // MR-075 Rejection of FAD HME or FAD CCL event are now the same logic.
     if (FA_HOME_HME.equals(cdTask) || TASK_CLOSE_HOME.equals(cdTask)) {
          CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage_ccmn35si);

          if (capsResource == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          // CallCSEC38D - Retrieve Home status
          // MR-075 Keeping same status upon rejection
          String cdRsrcFaHomeStatus = capsResource.getCdRsrcFaHomeStatus();

          // MR-075 Not sure the why the follow lines are commented out
          // will leave alone just in case.
          
          // adoptiveOrFoster = getAdoptiveOrFoster(capsResource);
          // adoptiveOrFosterList = getAdoptiveOrFosterList(capsResource);

          // CallCAUD52D
          updateCapsResource(capsResource, cdRsrcFaHomeStatus, cReqFuncCd);
          // Added another else if condition to Update CaseBudgetLimit table when the service auth is in pending status
          // and the svcauthdetail is modified.
          // begin
      } else if ((SA_CPS_FAM_PRES.equals(cdTask) || SA_CPS_INVEST.equals(cdTask) || SA_CPS_ADOPT.equals(cdTask)
                    || SA_CPS_POST_ADOPT.equals(cdTask) || SA_CPS_SUBCARE.equals(cdTask) || SA_CPS_PFC.equals(cdTask)
                    || SA_CPS_DIV.equals(cdTask) || SA_CPS_FSU.equals(cdTask))
                   && !SP_CASECLOSE.equals(ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode())) {

          int idCase = ccmn35si.getUlIdCase();
          CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
          csBdgtSaveSI.setUlIdCase(idCase);
          csBdgtSaveSI.setUlIdEvent(idEvent);
          csBdgtSaveSI.setModeIndicator(CodesTables.CAPPDESG_REJT);
          saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
        }// end
      }
    } else if (WIN_COMPAPRV.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
      ROWCCMN01UIG00 rowccmn01uig00 = ccmn35si.getROWCCMN01UIG00();
      int idClosureEvent = rowccmn01uig00==null ? 0 : rowccmn01uig00.getUlIdEvent();
      // CallCCMN46D
      audEvent(rowccmn01uig00, cReqFuncCd);

      ROWCCMN61DI rowccmn61di = ccmn35si.getROWCCMN61DI();
      // CallCCMN61D
      audApprovers(rowccmn61di, cReqFuncCd);
      
      
      // Fix for defect in ClientOutbound. 
      Task task = taskDAO.findTaskByCdTask(ccmn35si.getSzCdTask());
      if (null != task.getTxtTaskDecode()
          && (APPROVE_SERVICE_AUTHORIZATION.equalsIgnoreCase(task.getTxtTaskDecode()) || 
              APPROVE_PAYMENT_OF_CARE .equalsIgnoreCase(task.getTxtTaskDecode()) ||
              ADOPTION_ASSISTANCE_AGREEMENT .equalsIgnoreCase(task.getTxtTaskDecode()))) {
        ClientOutboundSaveSI clientOutboundSaveSI = setClientOutboundSaveSI(ccmn35si);
        saveClientOutbound.saveClientOutbound(clientOutboundSaveSI);

        // MR-087 Send alerts for Approved Payment of Care
        if (APPROVE_PAYMENT_OF_CARE .equalsIgnoreCase(task.getTxtTaskDecode())){
          sendAlertsForApprovedPaymentOfCare(ccmn35si);
        }
      }
      /*
       * STGAP00010231 - Adoption Enhancement: Create an ADO stage for certain legal actions for a child that has an FCC
       * Stage. If the legal action is either a voluntary surrender or parental rights (VS) or a termination of parental
       * rights (TPR) then an ADO stage will be automatically created. If the ADO stage has already been manually
       * opened, then an ADO stage should not be automatically created. This ADO Stage creation process should be
       * triggered on the following two occasions: 1. If the Complete Check box is checked and clicked save button.
       * Please see the code in LegalActionsConversation.java for this first scenario. Note: search using the defect #
       * STGAP00010231 in that code 2. If submitted for Approval, then it should be triggered in this Approval Process.
       */
      if (null != task.getTxtTaskDecode() && (APPROVE_LEGAL_ACTION.equalsIgnoreCase(task.getTxtTaskDecode()))) {
        // This entire save process is triggered from LegalActionsConversation.java as well during the
        // Legal Action save process when complete checkbox checked.
        // Call the Auto ADO Stage save process for either FCC/ADO/PAD stage
        // Based on either the FCC stage (i.e. SUB)/ADO/PAD stage, the logic is handled in the service
        if (CodesTables.CSTAGES_SUB.equals(cdStage_ccmn35si) || CodesTables.CSTAGES_ADO.equals(cdStage_ccmn35si)
            || CodesTables.CSTAGES_PAD.equals(cdStage_ccmn35si)) {
          // 1. The date of the Legal action also becomes the Date Notified for the Exchange
          // child Detail Page.
          // 2. Create the Exchange Child Detail event.
          // 3. The system should check to see if all people marked as 'Adoptive Parents' have had
          // legal actions on them with either VS or TPR. If they have, then the system should
          // update the new child's person characteristics page to indicate there has been an
          // adoption dissolution and the date of the dissolution.
          // TODO 4. Add alerts for SAU and allow access to the Exchange Child page
          saveAutoAdoStage.saveAutoAdoStage(ccmn35si);
        }
      }
      /*
       * STGAP00010749: ADAM Enhancement - When an approval of the closure event for an Adoption stage with reason
       * Adoption Finalized, is being saved, an automation process needs to be called to: 1. Create new person record
       * for the child with new name and corresponding Race, Ethnicity, Characteristics,Income and Resources, and  Medication
       * records. 2. Mark the ADO stage and the corresponding FCC stage as sealed. 3. Mark any other open stages in the case 
       * as sensitive. 3. Create a new case and a PAD stage in it for the child and mark the case as sensitive. 4. Copy 
       * the current Placement, Adoption Assistance and Adoption Assistance Agreement records to the new PAD stage with the 
       * new person Id. 5.End date or close all the current Placement, Adoption Assistance and Adoption Assistance Agreement records
       * in the ADO stage. 6. Copy the Eligibility Summary records from the FCC stage to PAD stage. 7. Close all the active
       * Eligibility Summary records in the FCC stage. 8. The FAD stage of the Adoptive Resource is marked SAU Sealed. The
       * Service called below will perform all the above tasks.
       */
        
      if (null != task.getTxtTaskDecode() && (APPROVE_ADO_STAGE_CLOSURE.equalsIgnoreCase(task.getTxtTaskDecode()))) {
        int idCurrentApprover = rowccmn61di.getUlIdApprovers();
        List<Approvers> lstApprovers = approversDAO.findApproverByIdApprovalByCdStatus(idApproval_ccmn35si, idCurrentApprover);
        if(ArchitectureConstants.Y.equals(ccmn35si.getBIndAdoptionFinalized()) && (lstApprovers==null || lstApprovers.size()==0)){
          CSUB68SI csub68si = new CSUB68SI();
          ROWCSUB68SIG01 rowcsub68sig01 = new ROWCSUB68SIG01();
          rowcsub68sig01.setUlIdCase(idCase_ccmn35si);
          rowcsub68sig01.setUlIdStage(idStage_ccmn35si);
          csub68si.setROWCSUB68SIG01(rowcsub68sig01);
          CSUB68SO csub68so = saveAdoFinalized.saveAdoFinalized(csub68si);
        }
      }

      if (null != task.getTxtTaskDecode() && (APPROVE_HOME_CONVERSION.equalsIgnoreCase(task.getTxtTaskDecode()))) {
        // lookup all foster home person link records for this foster home conversion
        List<Integer> personList = fosterHomeConvPerLinkDAO.findPersonsByIdFosterHomeConvEvent(ccmn35si.getUlIdEvent());

        if (personList != null && !personList.isEmpty()) {
          Iterator personListIt = personList.iterator();
          // for each person, look up the latest associated ado_info record to see if an
          // identified resource is selected.
          while (personListIt.hasNext()) {
            int idPerson = (Integer) personListIt.next();
            AdoInfo adoInfo = adoInfoDAO.findCurrentAdoptionInformationByIdPerson(idPerson);
            if (adoInfo != null && adoInfo.getCapsResource() == null) {
              CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage_ccmn35si);
              int idResource = capsResource.getIdResource();

              String nmPrivAgency = "";
              int idResParent = 0;
              Integer capsResourceLink = rsrcLinkDAO.findCapsResourceParentIdRsrcLink(idResource);
              if (capsResourceLink != null) {
                idResParent = capsResourceLink.intValue();
              }
              if (idResParent != 0) {
                nmPrivAgency = capsResourceDAO.findNmByIdResourceOnly(idResParent);
              }
              ResourceAddress addressDetail = resourceAddressDAO.findRsrcAddressByAddressTypeOnly(idResource);

              adoInfo.setCapsResource(capsResource);
              adoInfo.setIndIdenAdo("Y");
              adoInfo.setCdRsrcCnty(addressDetail.getCdRsrcAddrCounty());
              adoInfo.setCdState(addressDetail.getCdRsrcAddrState());
              adoInfo.setNmPrivAgency(nmPrivAgency);
              adoInfoDAO.saveAdoInfoDetail(adoInfo);
            }
          }
        }
        // Notify Regional Adoption Exchange Consultants and RACs when a Foster Home Conversion has been approved
        int idEvent = ccmn35si.getUlIdEvent();
        FosterHomeConv FosterHomeConv = fosterHomeConvDAO.findFosterHomeConvDetailsByIdEvent(idEvent);
        String cdConvApprovStatus = FosterHomeConv.getCdConvAppStatus();
        if(CodesTables.CFHCSTTS_PAP.equals(cdConvApprovStatus)) {
          int idCase = ccmn35si.getUlIdCase();
          int idStage = ccmn35si.getUlIdStage();
          CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
          String cdCaseRegion = "0" + capsCase.getCdCaseRegion();
          List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdCaseRegion);
          List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdCaseRegion);
          List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
          if (listIsValid(adoExchangeConsultants)) {
            racAndAuthorizedSauList.addAll(adoExchangeConsultants);
          }
          if (listIsValid(racList)) {
            racAndAuthorizedSauList.addAll(racList);
          }
          if (listIsValid(racAndAuthorizedSauList)) {
            Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
            List<Todo> todoList = new ArrayList<Todo>();
            while (itrRacAndAuthorizedSauList.hasNext()) {
              int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
              Todo todo5 = new Todo();
              String cdTask = "";
              Date dateCreated = new Date();
              Date todoDueDate = new Date();
              String todoDesc = "FH Conversion has been approved";
              todo5.setEvent(getPersistentObject(Event.class, idEvent));
              todo5.setTxtTodoDesc(todoDesc);
              todo5.setCdTodoTask(cdTask);
              todo5.setCdTodoType(CodesTables.CTODOTYP_A);
              todo5.setDtTodoDue(todoDueDate);
              todo5.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
              todo5.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, ccmn35si.getUlIdPerson()));
              todo5.setDtTodoCreated(dateCreated);
              todo5.setCapsCase(capsCase);
              todo5.setStage(getPersistentObject(Stage.class, idStage));
              todoList.add(todo5);
            }
            complexTodoDAO.saveTodo(todoList);
          }
        }
      }
      
      //MR-062 Call saveContactStandardsEffectiveDates to set dt_effective_start and dt_effective_end of Contact Standards
      if(null != task.getTxtTaskDecode() && (APPROVE_CONTACT_STANDARDS.equalsIgnoreCase(task.getTxtTaskDecode()))){
        saveContactStandardsEffectiveDates( ccmn35si.getUlIdStage(), ccmn35si.getUlIdEvent());
      }
      
      // CallCCMN57D
      List<Map> approvalEventLinkList = findRelatedEvents(idApproval_ccmn35si);
      // We have to filter for SQL Not Found, because approvalEventLinkList is used
      // in the next (CCMN62D) preceding call.
      if (approvalEventLinkList == null || approvalEventLinkList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      String wcdCdAprvlWinaction = ccmn35si.getSzWcdCdAprvlWinaction();
      // CallCCMN62D - Demote related Events
      updateEvent(approvalEventLinkList, cReqFuncCd, wcdCdAprvlWinaction);

      // CallCCMN43D - Delete todo
      todoDAO.deleteTodoByIdTodoAndDtLastUpdate(idTodo_ccmn35si, DateHelper.MAX_JAVA_DATE);

      // STGAP00006420- mark idTodo 0 in Approvers for the approved record so that when the page event needs to be
      // deleted in other transaction, we know that these todos have already been deleted as part of rejection progress
      // (see CallCCMN43D - Delete todo above) and don't call delete on those todo again to avoid ObjectNotFound
      // exception
      // More efficient way is to modify approversDAO.updateApproversByIdApproversAndDtLastUpdate() in as audApprovers()
      // to mark this field 0. However, decided to put it here to make flow of action clear: only after approval todo is
      // deleted
      // should we mark its id in approvers table 0 to indicate that todo is no longer valid or exists, not before todo
      // is
      // deleted
      approversDAO.updateIdTodoByIdApprovers(rowccmn61di.getUlIdApprovers(), 0);

      todo = createTodo(idPerson_ccmn35si, idStage_ccmn35si, idCase_ccmn35si, cdTask_ccmn35si);
      // todo.setTxtTodoDesc(COM_WORKER);
      String descSuffix = "";
      // String name = "";
      // String caseid = "";
      // String stageid = "";

      if (todo.getCapsCase().getIdCase() > 0) {
        // CallCCMNC5D
        CapsCase capsCase = findCapsCase(todo);
        String cdCaseName = capsCase.getNmCase();
        int idCase = ccmn35si.getUlIdCase();
        // int idStage = ccmn35si.getUlIdStage();
        // int idPerson = ccmn35si.getUlIdPerson();
        // todo.setTxtTodoDesc(COM_WORKER + "(" + cdCaseName + "," + idCase + ")");
        descSuffix = "(" + cdCaseName + "," + idCase + ")";
        // name = "" + idPerson + " ";
        // stageid = " " + idStage + "";
      }
      // CallCCMN43D - save todo (Send Notification to Worker)
      // todoDAO.saveTodo(todo);

      // Check if Supervisor Notification Necessary
      if (INDICATOR_YES.equals(ccmn35si.getBIndDesigneeAprvl())) {
        // -- first set appropriate description and notify worker
        todo.setTxtTodoDesc(COM_DESIGNEE + descSuffix);
        todoDAO.saveTodo(todo);

        // -- next notify supervisor
        todo = createTodo(idPerson_ccmn35si, idStage_ccmn35si, idCase_ccmn35si, cdTask_ccmn35si);
        todo.setPersonByIdTodoPersAssigned(retrieveUnitSupervisorByCaseManagerId(ccmn35si.getUlIdPerson()));
        todo.setTxtTodoDesc(COM_DESIGNEE);
        // CallCCMN43D - save todo (Send Notification to Supervisor)
        todoDAO.saveTodo(todo);
      } else {
        // -- set appropriate description and notify worker

        //mxpatel commented this out for defect #10716
        /*
        String shortTodo = COM_WORKER + descSuffix;// mxpatel added this for defect #8853
        if (shortTodo != null && shortTodo.length() > 80) { // mxpatel added this for defect #8853
          shortTodo = shortTodo.substring(0, 76) + "...";// mxpatel added this for defect #8853
        }
        todo.setTxtTodoDesc(shortTodo);// mxpatel added this for defect #8853
        */

        todo.setTxtTodoDesc(COM_WORKER + descSuffix);

        todoDAO.saveTodo(todo);

        // If we're approving an Intake, Check to see if any of the Principals are involved in these Stages:
        // - FPR(ONG)
        // - Any other Stages go here
        // - If so, We need to notify the Case Manager and the Supervisor of that Stage of the Principal's
        // involvement in this Intake
        if (APPROVE_CPS_INTAKE.equals(ccmn35si.getSzCdTask())) {
          // Find all the Principals for the approving Intake
          List<StagePersonLink> principles = stagePersonLinkDAO
                                                               .findAllPrincipalsLinkedToStage(idStage_ccmn35si,
                                                                                               CodesTables.CPRSNTYP_PRN);
          Iterator<StagePersonLink> principles_it = principles.iterator();
          while (principles_it.hasNext()) {
            StagePersonLink link = principles_it.next();
            List<String> stageTypeList = new ArrayList<String>();
            stageTypeList.add(CodesTables.CSTAGES_FPR); // ONG stage
            stageTypeList.add(CodesTables.CSTAGES_SUB); // FCC stage
            // Count the number of FPR(ONG) & FCC Stages that the Principal is involved in
            long ongCount = stagePersonLinkDAO
                                              .countOpenStagesByIdPersonAndIdStageqAndPersType(link.getPerson().getIdPerson(),
                                                                                               CodesTables.CPRSNTYP_PRN,
                                                                                               stageTypeList);
            if (ongCount > 0) {
              // Get the FPR(ONG) & FCC records, iterate thru them and create the Todo
              List<StagePersonLink> openOngLinks = stagePersonLinkDAO.findAllOpenStagesByIdPersonPersTypeAndCdStage(link.getPerson().getIdPerson(),
                                                                                                                    CodesTables.CPRSNTYP_PRN,
                                                                                                                    stageTypeList);
              Iterator<StagePersonLink> openOngLinks_it = openOngLinks.iterator();
              while (openOngLinks_it.hasNext()) {

                StagePersonLink ongLink = openOngLinks_it.next();
                Stage ongStage = (Stage) getPersistentObject(Stage.class, ongLink.getStage().getIdStage());
                Stage intakeStage = (Stage) getPersistentObject(Stage.class, idStage_ccmn35si);
                String personName = personDAO.findNmFullByIdPerson(ongLink.getPerson().getIdPerson());
                int idOngCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(ongStage.getIdStage());
                Person ongCaseManager = personDAO.findPersonByIdPerson(idOngCaseManager);

                // Create Todo to notify FPR(ONG) Case Manager
                           
                 Todo alertCaseManager = createTodo(idPerson_ccmn35si, ongStage.getIdStage(), ongStage.getCapsCase().getIdCase(), 
                                                                                                               cdTask_ccmn35si);
                 
                alertCaseManager.setPersonByIdTodoPersAssigned(ongCaseManager);
                alertCaseManager.setPersonByIdTodoPersWorker(ongCaseManager);
                alertCaseManager.setTxtTodoDesc(personName + COM_SUPERVISOR + intakeStage.getNmStage());
                todoDAO.saveTodo(alertCaseManager);

                // Create Todo to notify FPR(ONG) Supervisor
                
                 Todo alertSupervisor = createTodo(idPerson_ccmn35si, ongStage.getIdStage(), ongStage.getCapsCase()
                                                                                                    .getIdCase(),
                                                  cdTask_ccmn35si);
                 
                alertSupervisor.setPersonByIdTodoPersWorker(ongCaseManager);
                alertSupervisor
                               .setPersonByIdTodoPersAssigned(retrieveUnitSupervisorByCaseManagerId(ongCaseManager
                                                                                                                  .getIdPerson()));
                alertSupervisor.setTxtTodoDesc(personName + COM_SUPERVISOR + intakeStage.getNmStage());
                todoDAO.saveTodo(alertSupervisor);
              }
            }
            
            }
          // Remaining alerts go here
          // This value is not being used anywhere and hence commented out
          /*
           * long fadCount = stagePersonLinkDAO.countOpenStagesByIdPersonAndIdStageqAndPersType(
           * link.getPerson().getIdPerson(), CodesTables.CPRSNTYP_PRN, CodesTables.CSTAGES_FAD);
           */
          //CAPTA 4.3 MIC - Send Maltreatment In Care alert,Policy Violation alert
          //and Placement not on hold alert.
          //If Maltreatement In Care is yes and Placement info is found for that child send Maltreatement In care alert.
          IncomingDetail intake = incomingDetailDAO.findIncomingDetailByIdStage(idStage_ccmn35si);
          if (intake != null) {
            if (ServiceConstants.FND_YES.equals(intake.getIndIncmgMaltreatInCare()))  {
              sendToDoforIntakeMaltreatmentInCareAndSetHoldPlacements(ccmn35si, intake);
            }
          }
        }
      }
      // STGAP00008188 updating case budget limit when policy waiver is being approved
      if (PW_INV_POL_WAIV.equals(cdTask_ccmn35si)) {
        CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
        csBdgtSaveSI.setUlIdCase(ccmn35si.getUlIdCase());
        csBdgtSaveSI.setModeIndicator(CodesTables.CEVTSTAT_PEND);
        csBdgtSaveSI.setUlIdEvent(ccmn35si.getUlIdEvent());

        saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
      }
      //STGAP00017922: Included Near Fatality Intake in the if condition
      if (APPROVE_CALL_CD_TASK_CHILD_DEATH.equals(ccmn35si.getSzCdTask())
          || APPROVE_CALL_CD_TASK_SERIOUS_INJURY.equals(ccmn35si.getSzCdTask())
          || APPROVE_CALL_CD_TASK_NEAR_FATALITY.equals(ccmn35si.getSzCdTask())) { //
        Person person = getPersistentObject(Person.class, ccmn35si.getUlIdPerson());
        // STGAP00007159: Added null check and passed the case manager's county to the
        // sendToDoforChildDeathAndSeriousInjury method.
        if (person != null && person.getEmployee() != null) {
          String cdCounty = "";
          if (person.getEmployee().getUnit() != null) {
            cdCounty = person.getEmployee().getUnit().getCdCounty();
          }
          sendToDoforChildDeathAndSeriousInjury(person.getEmployee().getCdEmpUnitRegion(), cdCounty, ccmn35si);
        }
      }

      if (APPROVE_CPS_INVESTIGATION.equals(ccmn35si.getSzCdTask())) {
        String personByIdTodoPersWorkerCdCounty = todo.getPersonByIdTodoPersWorker().getEmployee().getUnit().getCdCounty();
        //if maltreatment in care || is this policy violation
        CpsInvstDetail cpsInvstDtl = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage_ccmn35si); 
        String indMaltreatmentInCare =  "";
        String indPolicyViolation = "";
        String indUnSubMaltreatInCare = "";
        if(cpsInvstDtl != null){    
        indMaltreatmentInCare = cpsInvstDtl.getIndInvMaltreatInCare();
        indUnSubMaltreatInCare = cpsInvstDtl.getIndUnSubMaltreatInCare();
        indPolicyViolation = cpsInvstDtl.getIndPolicyViolation();    
        }   
        //Special Investigation task and alert should be generated only if the answers to any one of the questions is this maltreatment in care
        // is this policy voilation is Yes.
        if(ArchitectureConstants.Y.equals(indMaltreatmentInCare) || ArchitectureConstants.Y.equals(indPolicyViolation) || ArchitectureConstants.Y.equals(indUnSubMaltreatInCare)){
          sendAlertforInvestigationConclusion(personByIdTodoPersWorkerCdCounty, ccmn35si); //Included under this condition for issue list #981 
          sendTaskforSpecialInvestigation(idStage_ccmn35si, ccmn35si);        
        }
        // SMS#51977 MR-066 Adding Alert 'A Special Investigation on a Placement/Non-Placement provider has been
        // reviewed and approved.'
        Person person = getPersistentObject(Person.class, ccmn35si.getUlIdPerson());
        if (person != null && person.getEmployee() != null) {
          String cdCounty = "";
          if (person.getEmployee().getUnit() != null) {
            cdCounty = person.getEmployee().getUnit().getCdCounty();
          }
          sendToDoforSpecialInvestigation(person.getEmployee().getCdEmpUnitRegion(), cdCounty, ccmn35si);
        }
        sendToDoforInvestigationCorrectiveActionPlanAndPolicyViolation(ccmn35si);
    

         // Corey 7/6/2011 CO-CAPTA4.3-5.3.16 - if intake MIC allegations are unsubstantiated, remove the hold from the home and send out alerts
         int idEvent = ccmn35si.getUlIdEvent();
         // check to see if event is valid
         if (idEvent != 0) {
           // get the CPS Investigation Conclusion record
           CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdEvent(idEvent);         
           // make sure record is valid
           if(cpsInvstDetail != null){
             // make sure stage record is present
             if(cpsInvstDetail.getStage() != null){
               // find the intake information
               IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailFromINVIdStage(cpsInvstDetail.getStage().getIdStage());
               // check to see if maltreatment in care was selected during the intake
               if(incomingDetail != null && ArchitectureConstants.Y.equals(incomingDetail.getIndIncmgMaltreatInCare())){
                 // if there is no substantiated allegation of maltreatment in care or a policy violation, remove hold from home
                 if(!ArchitectureConstants.Y.equals(cpsInvstDetail.getIndInvMaltreatInCare()) && !ArchitectureConstants.Y.equals(cpsInvstDetail.getIndPolicyViolation())){
                   // initialize variable to hold intake stage information
                   CaseUtility.Stage intakeStage = new CaseUtility.Stage();
                   // get the stage prior to this investigation
                   CaseUtility.Stage tempStage = CaseUtility.getPriorStage(ccmn35si.getUlIdStage());
                   // since the prior stage could be a diversion or ongoing stage, check stage code to find intake
                   while(!Cstages.CSTAGES_INT.equals(tempStage.getCdStage())){
                     tempStage = CaseUtility.getPriorStage(tempStage.getIdStage());
                   }
                   // set the intake stage
                   intakeStage = tempStage;
                   IncomingFacility facil = incomingFacilityDAO.findIncomingFacilityByIdStage(intakeStage.getIdStage());
                   // check to see if resource is a home
                   if(facil.getCapsResource() != null && facil.getCapsResource().getStage() != null){
                     // remove hold from home
                     capsResourceDAO.updateCapsResourceIndHoldPlacements(facil.getCapsResource().getIdResource(), ServiceConstants.FND_NO);
                     // send alerts int idPerson, String cdTask, int idCpsInvCclsnCase, String nmResource, int idCpsInvCclsnStage, int idResource, int idHomeStage) {
                     sendAlertsForCpsInvCnclsnToRemoveHoldFromHold(ccmn35si.getUlIdPerson(), ccmn35si.getSzCdTask(), cpsInvstDetail.getCapsCase().getIdCase(), facil.getCapsResource().getNmResource(), cpsInvstDetail.getStage().getIdStage(), facil.getCapsResource().getIdResource(), facil.getCapsResource().getStage().getIdStage());
                   }
                 }
               }
             }
           }
         }
       }
      

      if (SPCL_INV_APPROVAL_TASK.equals(cdTask_ccmn35si)) {
        int idEvent = ccmn35si.getUlIdEvent();
        SpclInvestigationRetrieveSI spclInvestigationRetrieveSI = new SpclInvestigationRetrieveSI();
        spclInvestigationRetrieveSI.setIdEvent(idEvent);
        spclInvestigationRetrieveSI.setIdCase(idCase_ccmn35si);
        spclInvestigationRetrieveSI.setIdStage(idStage_ccmn35si);
        String cdRsrcFacilType = "";
        int idResource = 0;
        SpclInvestigationRetrieveSO spclInvestigationRetrieveSO = retrieveSpclInvestigation
                                                                                           .retrieveSpclInvestigation(spclInvestigationRetrieveSI);
        if (spclInvestigationRetrieveSO != null) {
          idResource = spclInvestigationRetrieveSO.getIdResource();
          cdRsrcFacilType = spclInvestigationRetrieveSO.getCdRsrcFacilType();
          int idCpsInvCclsnStage = spclInvestigationRetrieveSO.getIdStage();
          int idCpsInvCclsnCase = spclInvestigationRetrieveSO.getIdCase();
          String decision = (ServiceConstants.FND_YES.equals(spclInvestigationRetrieveSO.getIndConcurAssmntDisp())) ? "concurs" : "does not concur";
          sendAlertsForSpclInvConcurrenceDecision(idPerson_ccmn35si, idCpsInvCclsnStage, idCpsInvCclsnCase,
                                                    idResource, cdTask_ccmn35si, decision);
          String recommend = (ServiceConstants.FND_YES.equals(spclInvestigationRetrieveSO.getIndConcurActionRecmnd())) ? "concurs" : "does not concur";
          sendAlertsForSpclInvActionRecmnd(idPerson_ccmn35si, idCpsInvCclsnStage, idCpsInvCclsnCase,
                                           idResource, cdTask_ccmn35si, recommend);
          sendAlertsForSpclInvStateOfficeConcursAndRemoveHoldOnHome(idPerson_ccmn35si, cdTask_ccmn35si, spclInvestigationRetrieveSO);

        }
      }

      if(APPROVE_FCCP_FAMILY.equals(ccmn35si.getSzCdTask())){    	  
          sendAlertsforApprovedFCCPFamily(ccmn35si);
      }
      
      // String chktask = ccmn35si.getSzCdTask();
      // Stage Progression / CaseStage Closure. Due to a completed approval and if stage progression
      // mode indicates an applicable code, either progress the stage or close the case based on the
      // mode and other AprvlStageProg structure information
      boolean openDivOrFccStage = false;
      openDivOrFccStage = (SCREEN_OUT_NO_MALTREATMENT_CODE.equals(ccmn35si.getAprvlStageProg()
                                                                          .getSzCdStageReasonClosed()) || CodesTables.CDISP_DIV
                                                                                                                               .equals(cdDisposition));
      //SMS#88838: Move the code up before the close case/stage code so we can retrieve secondary worker from workload/stage person link
      //STGAP00011258: Implemented Stage Closure alerts
      if (TASK_CLOSE_ADO_STAGE.equals(ccmn35si.getSzCdTask()) || TASK_CLOSE_PAD_STAGE.equals(ccmn35si.getSzCdTask())
              || TASK_CLOSE_SUB_STAGE.equals(ccmn35si.getSzCdTask())) {
            saveStageClosureAlerts.saveStageClosureAlerts(ccmn35si);
      }

      // Manual or Auto Stage Progression
      if ((SP_MANUAL.equals(ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode()))
          || (SP_AUTOMATIC.equals(ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode()))) {

        CCMN03UI ccmn03ui = new CCMN03UI();

        ccmn03ui.setUlIdStage(idStage_ccmn35si);
        ccmn03ui.setSzCdStage(cdStage_ccmn35si);
        ccmn03ui.setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
        ccmn03ui.setSzCdStageOpen(ccmn35si.getAprvlStageProg().getSzCdStageOpen());
        ccmn03ui.setSzCdStageReasonClosed(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed());
        // Pass Id of the user who requested the authorization
        ccmn03ui.setUlIdPerson(ccmn35si.getUlIdPerson());
        // Call close stage case for CRSR Reasons Closed as well as Adoption Disruption for ADO stages.
        if (ADOPTION_STAGE.equals(cdStage_ccmn35si)
            && (ADO_CMTD.equals(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed())
                || UNAB_COMP.equals(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed())
                || REQ_WITH.equals(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()) || SVC_COMP
                                                                                                       .equals(ccmn35si
                                                                                                                       .getAprvlStageProg()
                                                                                                                       .getSzCdStageReasonClosed()))) {
          ccmn03ui.setCSysIndSStgOpenOnly(INDICATOR_YES);
        }
        // call CloseOpenStage Service
        closeOpenStage.closeOpenStage(ccmn03ui);
      } else if (SP_CASECLOSE.equals(ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode())) {

        CCMN02UI ccmn02ui = new CCMN02UI();
        CCMN02UIG00 ccmn02uigoo = new CCMN02UIG00();
        ccmn02ui.setCCMN02UIG00(ccmn02uigoo);
        ccmn02ui.getCCMN02UIG00().setUlIdStage(idStage_ccmn35si);
        ccmn02ui.getCCMN02UIG00().setSzCdStage(cdStage_ccmn35si);
        ccmn02ui.getCCMN02UIG00().setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
        ccmn02ui.getCCMN02UIG00().setSzCdStageReasonClosed(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed());
        ccmn02ui.getCCMN02UIG00().setUlIdPerson(idCntrctWkr);
        // Call CloseStageCase
        closeStageCase.closeStageCase(ccmn02ui);
      }// If Dispositon is not DIV , ACA or stage's reason closed code is not SNM, close the Intake.
      else if (!openDivOrFccStage && INTAKE.equals(ccmn35si.getSzCdStage())) {

        // -- only close the case if Screen Out was selected as the disposition
        // STGAP00008389: Need to close the case if the disposition is CodesTables.CDISP_OIE(Opened in Error)
        if (CodesTables.CDISP_SCO.equals(cdDisposition) || CodesTables.CDISP_SCR.equals(cdDisposition)
            || CodesTables.CDISP_OIE.equals(cdDisposition)) {
          //Before calling closeStageCase check if there exists DOD on person detail and if CNS event (Child death report has 
          //been created and approved for each child)
          //SMS#54782 : Loop through all principal to see if there exists an approved ChildDeath Report for all children on intake report that 
          //have Date of Death entered on their Person Detail page
          if (!CodesTables.CDISP_OIE.equals(cdDisposition)) { //If OIE i.e intake opened in error do not do this , directly close the stage case
            //SMS#109422
            //STGAP00017922: Included Near Fatality task code
            if(APPROVE_CALL_CD_TASK_NEAR_FATALITY.equals(cdTask_ccmn35si)|| APPROVE_CALL_CD_TASK_CHILD_DEATH.equals(cdTask_ccmn35si) || APPROVE_CPS_INTAKE.equals(cdTask_ccmn35si) || APPROVE_INTAKE_CLOSURE.equals(cdTask_ccmn35si)
                            || APPROVE_CALL_CD_TASK_SERIOUS_INJURY.equals(cdTask_ccmn35si) || APPROVE_CALL_SPECIAL_REQUEST.equals(cdTask_ccmn35si)){
            List<BigDecimal> PersonList = stagePersonLinkDAO.findPrincipalByStageIdWithDODAndAgeLT18(idStage_ccmn35si);
            if (PersonList != null) {
                List<String> cdEventStatuses = new ArrayList<String>();
                cdEventStatuses.add(EVENT_STATUS_APRV);
                // loop through all the Principal children and find if there exists an approved child death report
                for (Iterator it = PersonList.iterator(); it.hasNext();) {
                  BigDecimal idPersonBig = (BigDecimal) it.next();
                  int idPerson = idPersonBig.intValue();
                  List<Event> CNSEventList = eventDAO.findAprvChildDeathReportByIdPersonIdStage(idPerson,
                                                                                                idStage_ccmn35si,
                                                                                                cdEventStatuses);
                  if (CNSEventList == null || CNSEventList.isEmpty()) {
                    throw new ServiceException(Messages.MSG_CNS_REQD_IF_DOD);
                  }
                }
              }
            }
            //SMS#109422
          //STGAP00017922: Included Near Fatality task code
            if(APPROVE_CALL_CD_TASK_NEAR_FATALITY.equals(cdTask_ccmn35si)||APPROVE_CALL_CD_TASK_CHILD_DEATH.equals(cdTask_ccmn35si) || APPROVE_CPS_INTAKE.equals(cdTask_ccmn35si) || APPROVE_INTAKE_CLOSURE.equals(cdTask_ccmn35si)
                            || APPROVE_CALL_CD_TASK_SERIOUS_INJURY.equals(cdTask_ccmn35si) || APPROVE_CALL_SPECIAL_REQUEST.equals(cdTask_ccmn35si)){
            // SMS#42496:Find if there are any events in PEND status, throw exception if any
            List<Event> pendingEvents = eventDAO.findEventByIdStageAndCdEventStatus(idStage_ccmn35si,
                                                                                    CodesTables.CEVTSTAT_PEND);
            if (pendingEvents != null && !pendingEvents.isEmpty()) {
              for (Iterator it = pendingEvents.iterator(); it.hasNext();) {
                Event pendingEvent = (Event) it.next();
                String eventType = pendingEvent.getCdEventType();
                if (!CodesTables.CEVNTTYP_CCL.equals(eventType)) { // Need to check for if it is not CCL event type 
                  //throw error message as you cannot close a stage with events in Pending Status
                  throw new ServiceException(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE);
                }
              }

            }
          }
            
          
          //SMS#109422
          //STGAP00017922: Included Near Fatality task code
            if(APPROVE_CALL_CD_TASK_NEAR_FATALITY.equals(cdTask_ccmn35si)||APPROVE_CALL_CD_TASK_CHILD_DEATH.equals(cdTask_ccmn35si) || APPROVE_CPS_INTAKE.equals(cdTask_ccmn35si) || APPROVE_INTAKE_CLOSURE.equals(cdTask_ccmn35si)
                            || APPROVE_CALL_CD_TASK_SERIOUS_INJURY.equals(cdTask_ccmn35si) || APPROVE_CALL_SPECIAL_REQUEST.equals(cdTask_ccmn35si)){
          CCMN02UI ccmn02ui = new CCMN02UI();
          ccmn02ui.setCCMN02UIG00(new CCMN02UIG00());
          ccmn02ui.getCCMN02UIG00().setUlIdStage(idStage_ccmn35si);
          ccmn02ui.getCCMN02UIG00().setSzCdStage(cdStage_ccmn35si);
          ccmn02ui.getCCMN02UIG00().setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
          ccmn02ui.getCCMN02UIG00().setSzCdStageReasonClosed(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed());
          ccmn02ui.getCCMN02UIG00().setUlIdPerson(idCntrctWkr);
          //101883 : updating the Intake Summary Status to closed when closing the intake 
          incomingDetailDAO.updateIncomingDetailStatus(CodesTables.CINCMGST_CLD, idStage_ccmn35si);
          // Call CloseStageCase
          closeStageCase.closeStageCase(ccmn02ui);
          ccmn35so.setBAssignPageForward(ArchitectureConstants.N);
            }
          
          } else if(CodesTables.CDISP_OIE.equals(cdDisposition)){
            CCMN02UI ccmn02ui = new CCMN02UI();
            ccmn02ui.setCCMN02UIG00(new CCMN02UIG00());
            ccmn02ui.getCCMN02UIG00().setUlIdStage(idStage_ccmn35si);
            ccmn02ui.getCCMN02UIG00().setSzCdStage(cdStage_ccmn35si);
            ccmn02ui.getCCMN02UIG00().setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
            ccmn02ui.getCCMN02UIG00().setSzCdStageReasonClosed(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed());
            ccmn02ui.getCCMN02UIG00().setUlIdPerson(idCntrctWkr);
            //101883 : updating the Intake Summary Status to closed when closing the intake 
            incomingDetailDAO.updateIncomingDetailStatus(CodesTables.CINCMGST_CLD, idStage_ccmn35si);
            // Call CloseStageCase
            closeStageCase.closeStageCase(ccmn02ui);
            ccmn35so.setBAssignPageForward(ArchitectureConstants.N);
          }
        }

        // -- uncomment the following line to prevent saving the approval of a non-incident
        // -- intake from forwarding to the Assign page
        // ccmn35so.setBAssignPageForward(ArchitectureConstants.N);
      }

      if (SP_AUTOMATIC.equals(ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode())
          && ADOPTION_STAGE.equals(cdStage_ccmn35si)
          && (ADO_CMTD.equals(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed())
              || UNAB_COMP.equals(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed())
              || REQ_WITH.equals(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()) || SVC_COMP
                                                                                                     .equals(ccmn35si
                                                                                                                     .getAprvlStageProg()
                                                                                                                     .getSzCdStageReasonClosed()))) {
        CCMN02UI ccmn02ui = new CCMN02UI();
        CCMN02UIG00 ccmn02uig00 = new CCMN02UIG00();
        ccmn02uig00.setUlIdStage(idStage_ccmn35si);
        ccmn02uig00.setSzCdStage(cdStage_ccmn35si);
        ccmn02uig00.setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
        ccmn02uig00.setSzCdStageReasonClosed(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed());
        ccmn02ui.setCCMN02UIG00(ccmn02uig00);
        // Call CloseStageCase
        closeStageCase.closeStageCase(ccmn02ui);
      }
      
      //STGAP00011258: Implemented Stage Closure alerts
      /*if (TASK_CLOSE_ADO_STAGE.equals(ccmn35si.getSzCdTask()) || TASK_CLOSE_PAD_STAGE.equals(ccmn35si.getSzCdTask())
          || TASK_CLOSE_SUB_STAGE.equals(ccmn35si.getSzCdTask())) {
        saveStageClosureAlerts.saveStageClosureAlerts(ccmn35si);
      }*/
      // STGAP00011372: Generate alert on Child Life History Check List Approval
      if (APPROVE_CHILD_LIFE_HISTORY_CHECK_LIST.equals(ccmn35si.getSzCdTask())) {
        sendAlertsToSauOnChLifeHstChkListApproval(ccmn35si.getUlIdCase(), ccmn35si.getUlIdStage(), ccmn35si.getUlIdPerson());
      }
      // For approval of Subcare, Service Authorization or FA Home,
      // a standard set of To_Dos must be created for the worker. Do not
      // generate a Todo if the Case is going to close.
      // start of approvaleventlinklist
      for (Iterator<Map> it = approvalEventLinkList.iterator(); it.hasNext();) {
        Map approvalEventLinkMap = it.next();
        int idEvent = (Integer) approvalEventLinkMap.get("idEvent");
        String cdTask = (String) approvalEventLinkMap.get("cdTask");
        // For each Event in this list, the Task Code must be checked to
        // see if it maps to a Child Plan, Service Authorization or FA Home Event.
        // Check for Adoption Plan Task Code.
        /*
         * if ((CHILD_PLAN.equals(cdTask)) || (ADOPTION_PLAN.equals(cdTask)) &&
         * !(SP_CASECLOSE.equals(ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode()))) { // Retrieve a functional
         * record from the Child Plan table // using IdEvent, in order to create ToDos for Child Plan events. //
         * CallCSES19D ChildPlan childPlan = childPlanDAO.findChildPlan(idEvent); if (childPlan == null) { throw new
         * ServiceException(Messages.SQL_NOT_FOUND); } CSUB40UI csub40ui = new CSUB40UI(); CSUB40UIG00 csub40uig00 = new
         * CSUB40UIG00(); String cdCspPlanType = childPlan.getCdCspPlanType(); if (INIT_PLAN.equals(cdCspPlanType) ||
         * INIT_PLAN_PAL.equals(cdCspPlanType) || REVIEW.equals(cdCspPlanType) || REVIEW_PAL.equals(cdCspPlanType) ||
         * FAC_REVIEW.equals(cdCspPlanType) || FAC_REVIEW_PAL.equals(cdCspPlanType)) {
         * csub40uig00.setSzSysCdTodoCf(TODO_SUB_DUE_6MOS); } // Creates the new Adoption Plan Todo* else if
         * (ADOPT_PLAN.equals(cdCspPlanType)) { csub40uig00.setSzSysCdTodoCf(TODO_ADO_DUE_6MOS); } else if
         * (INIT_PLAN_THER.equals(cdCspPlanType) || INIT_PAL_THER.equals(cdCspPlanType) ||
         * REVIEW_THER.equals(cdCspPlanType) || REVIEW_PAL_THER.equals(cdCspPlanType)) {
         * csub40uig00.setSzSysCdTodoCf(TODO_SUB_DUE_3MOS); } // Since 'Next Review Date' field is displayed on the
         * Child Plan Detail page, so pass this date // to the TodoCommonFunction for create the todo for the next
         * review. The todo date will not be // calculated from SYSDATE.
         * csub40uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(childPlan.getDtCspNextReview()));
         * csub40uig00.setUlSysIdTodoCfPersAssgn(0);
         * csub40uig00.setUlSysIdTodoCfPersCrea(ccmn35si.getROWCCMN61DI().getUlIdPerson()); // Pass 0 as EventId
         * csub40uig00.setUlSysIdTodoCfEvent(0); csub40uig00.setUlSysIdTodoCfStage(ccmn35si.getUlIdStage());
         * csub40uig00.setUlSysIdTodoCfPersWkr(0); csub40ui.setCSUB40UIG00(csub40uig00);
         * 
         * CSUB40UO csub40uo = todoCommonFunction.audTodo(csub40ui); Date dtTodoDue =
         * DateHelper.toJavaDate(csub40uo.getDtDtTodoDue()); // CallCAUD25D - Udate the Child Plan for the given
         * idEvent. updateChildPlan(childPlan, idEvent, dtTodoDue); } else
         */
        // Creating alerts for Placement on Approval defect - STGAP00002213
        if (PLCMT_SUB1.equals(cdTask) || PLCMT_SUB2.equals(cdTask) || PLCMT_ADO1.equals(cdTask)
            || PLCMT_ADO2.equals(cdTask) || PLCMT_PAD1.equals(cdTask) || PLCMT_PAD2.equals(cdTask)
            || PLCMT_PFC1.equals(cdTask) || PLCMT_PFC2.equals(cdTask)) {
          String secAttribute = ccmn35si.getSzCdAttrRegSsStf();
          savePlacementAlerts.savePlacementAlerts(idEvent, secAttribute);
        }
        if ((SA_CPS_FAM_PRES.equals(cdTask) || SA_CPS_INVEST.equals(cdTask) || SA_CPS_ADOPT.equals(cdTask)
             || SA_CPS_POST_ADOPT.equals(cdTask) || SA_CPS_SUBCARE.equals(cdTask) || SA_CPS_PFC.equals(cdTask)
             || SA_CPS_DIV.equals(cdTask) || SA_CPS_FSU.equals(cdTask))
            && !SP_CASECLOSE.equals(ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode())) {
          // Updating CaseBudgetLimit table when the service auth is in pending status and the svcauthdetail is
          // modified.
          // Begin Case Budget Limit
          int idCase = ccmn35si.getUlIdCase();
          CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
          csBdgtSaveSI.setUlIdCase(idCase);
          csBdgtSaveSI.setUlIdEvent(idEvent);
          csBdgtSaveSI.setModeIndicator(CodesTables.CAPPDESG_APRV);
          saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
          // end Case Budget Limit
          // Update the county Budget Limit Table if for the prog code, effective date and the county combination
          // there is a corresponding row in county budget limit table.
          // Begin County Budget update
          ServiceAuthorization serviceAuthorization = serviceAuthorizationDAO.findServiceAuthEventLink(idEvent);
          if (serviceAuthorization == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          int idSvcAuth = serviceAuthorization.getIdSvcAuth();
          String county = serviceAuthorization.getCdPayCnty();
          String program = serviceAuthorization.getCdSvcAuthCategory();
          Date effectivedate = serviceAuthorization.getDtSvcAuthEff();
          int month = DateHelper.getMonth(effectivedate);
          int year = DateHelper.getYear(effectivedate);
          if (month > 6) {
            year = year + 1;
          }
          CountyBudgetLimit cntyBdgtlmt = countyBudgetLimitDAO.findCountyBudgetLimitByProgramAndFiscalYear(county,
                                                                                                           program,
                                                                                                           year);
          if (cntyBdgtlmt != null) {
            List<String> svcCodeList = new ArrayList<String>();
            svcCodeList = svcAuthDetailDAO.findDistinctSvcCodes(idSvcAuth);
            double totalAmtReq = 0.0;
            for (Iterator itSvc = svcCodeList.iterator(); itSvc.hasNext();) {
              String servCode = (String) itSvc.next();

              List<SvcAuthDetail> svcAuthDtlList = svcAuthDetailDAO.findSvcAuthDetailByIdSvcAuthBySvcCode(idSvcAuth,
                                                                                                          servCode);
              if (svcAuthDtlList != null) {
                // loop through all the service auth detail records for the current combination of service auth and
                // service code and add the amount requested.
                for (Iterator itSvcAuth = svcAuthDtlList.iterator(); itSvcAuth.hasNext();) {
                  SvcAuthDetail svcAuthDetail = (SvcAuthDetail) itSvcAuth.next();
                  double amountReq = 0.0;
                  amountReq = amountReq + svcAuthDetail.getAmtSvcAuthDtlAmtReq();
                  totalAmtReq = totalAmtReq + amountReq;
                }
              }
            }
            cntyBdgtlmt.setAmtObg(cntyBdgtlmt.getAmtObg() + totalAmtReq);
            cntyBdgtlmt.setAmtBalance(cntyBdgtlmt.getAmtBalance() - totalAmtReq);
            countyBudgetLimitDAO.saveOrUpdateCountyBudgetLimit(cntyBdgtlmt);

          }
          // end County Budget update
          // The code that creates a To Do to warn the expiry of the service auth in 30 days is removed
          // to fix defect STGAP00002624.
        }// STGAP00010878: Added or condition to else if so that when a foster home conversion is being approved
         // then a new contract can be generated for the Foster home with Adoptive services 
        else if (TASK_MNTN_LIC.equals(cdTask) || FOST_HOME_CONV_TASK.equals(cdTask)) {
          List<Map<String, Object>> contractsRecord = new ArrayList<Map<String, Object>>();
          //STGAP00010878: This boolean is set to true when a Foster Home Conversion is being 
          // approved. This boolean is used to by-pass some lines of code that do not apply for
          // foster home conversion.
          boolean indFosterHmConv = false;
          //STGAP00013590
          boolean indAdoptContractExistsForFAHomeConv = false;
          CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage_ccmn35si);
          if(capsResource!=null){
          idResourceCapsResource = capsResource.getIdResource();
          }else{
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          Set contractTypesToGenerate = new HashSet();
          if(FOST_HOME_CONV_TASK.equals(cdTask)){
            indFosterHmConv = true;
            contractTypesToGenerate.add("F");
          }
          
        //STGAP00013590: If Foster Home Conversion check to see if the contract exists for the resource
          if (indFosterHmConv) {
            List<Contract> contractList = contractDAO.findContractByIdResource(idResourceCapsResource);
            if (contractList != null && !contractList.isEmpty()) {
              // Retrieve Contract Period, Contract Version, Contract Service
              for (Iterator<Contract> itContract = contractList.iterator(); itContract.hasNext();) {
                Contract contract = itContract.next();
                Map<String, Object> contractRecord = new HashMap<String, Object>();
                contractRecord.put("contract", contract);
                int idContract = contract.getIdContract();

                // Call CSES80D - Retrieve Contract Period
                ContractPeriod contractPeriod = contractPeriodDAO.findContractPeriodByIdContract(idContract);

                if (contractPeriod != null) {
                  contractRecord.put("contractPeriod", contractPeriod);
                  processContractPeriodDate(contractPeriod, contractRecord);
                  contractsRecord.add(contractRecord);
                }
              }

              // Loop through all contract rows returned from the previous DAMs
              for (Iterator<Map<String, Object>> it_contractRecords = contractsRecord.iterator(); it_contractRecords
              .hasNext();) {
                Map<String, Object> contractRecord = it_contractRecords.next();
                if (StringHelper.toBooleanSafe((String) contractRecord.get("indContractCurrent"))) {
                  Contract contract = (Contract) contractRecord.get("contract");
                  int idContract = contract.getIdContract();
                  ContractPeriod contractPeriod = (ContractPeriod) contractRecord.get("contractPeriod");
                  // Contract Version retrieve for an idContract , contract period number,
                  // and version end date that is greater than the current date.
                  // Call CSES81D - Contract Version retrieve
                  ContractVersion contractVersion = contractVersionDAO
                  .findCurrentContractVersion(
                                              idContract,
                                              contractPeriod
                                              .getId()
                                              .getNbrCnperPeriod());

                  if (contractVersion == null) {
                    break;
                  }
                  contractRecord.put("contractVersion", contractVersion);
                  // Call CLSS13D
                  List<ContractService> contractServices = contractServiceDAO
                  .findConSvcByIdConAndNbrCnsvcPeriodMaxAndNbrCnsvcVersionMax(idContract);

                  // int tempSvcRowQty = 0;

                  if (contractServices != null && !contractServices.isEmpty()) {
                    contractRecord.put("contractServices", contractServices);
                    tempSvcRowQty1 = contractServices.size();
                    for (Iterator<ContractService> cs_it = contractServices.iterator(); cs_it.hasNext();) {
                      ContractService contractService = cs_it.next();
                      if (doesServiceExist(contractService.getCdCnsvcService(), CodesTables.CADOSVCD)) {
                        indAdoptContractExistsForFAHomeConv = true;
                      }
                    }
                  }
                }
              }
            }

          }
          else if (!indFosterHmConv) {
            if (WIN_COMPAPRV.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
              // Call cmsc46d - retrieve RESOURCE_HISTORY
              Long numHomeResourceHistory = resourceHistoryDAO
                                                              .countResourceHistoryByIdStageAndCdHomeStatus(idStage_ccmn35si);

              // If there are no rows returned
              if (numHomeResourceHistory == 0) {
                // Create Todo
                CSUB40UI csub40ui = new CSUB40UI();
                CSUB40UIG00 csub40uig00 = new CSUB40UIG00();
                csub40ui.setArchInputStruct(ccmn35si.getArchInputStruct());
                csub40uig00.setSzSysCdTodoCf(TODO_FA_HOME);
                csub40uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(new Date()));
                csub40uig00.setUlSysIdTodoCfPersCrea(ccmn35si.getUlIdPerson());
                csub40uig00.setUlSysIdTodoCfEvent(0);
                csub40uig00.setUlSysIdTodoCfStage(ccmn35si.getUlIdStage());
                csub40ui.setCSUB40UIG00(csub40uig00);
                todoCommonFunction.audTodo(csub40ui);
              }
              // MR-075 Added this to correct set new event description to display correct status approval.
              String eventDesc = "Changed home status to ";
              if (CodesTables.CFAHMSTA_PFA.equals(capsResource.getCdRsrcFaHomeStatus())) {
                eventDesc = eventDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HOME_STATUS_APVD_FULL_ACT);
              } else if (CodesTables.CFAHMSTA_PSA.equals(capsResource.getCdRsrcFaHomeStatus())) {
                eventDesc = eventDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HOME_STATUS_APVD_SPEC_ACT);
              } else if (CodesTables.CFAHMSTA_PTA.equals(capsResource.getCdRsrcFaHomeStatus())) {
                eventDesc = eventDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, HOME_STATUS_APVD_TEMP_ACT);
              } else if (CodesTables.CFAHMSTA_PFG.equals(capsResource.getCdRsrcFaHomeStatus())) {
                eventDesc = eventDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_FLG);
              } else if (CodesTables.CFAHMSTA_PSG.equals(capsResource.getCdRsrcFaHomeStatus())) {
                eventDesc = eventDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_FSG);
              } else if (CodesTables.CFAHMSTA_PUN.equals(capsResource.getCdRsrcFaHomeStatus())) {
                eventDesc = eventDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_AUN);
              } else {
                eventDesc = eventDesc + Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, capsResource.getCdRsrcFaHomeStatus());
//                eventDesc = eventDesc + "Approved- Active";
              }

              // The following code will only be executed if the previous call was successful
              // that is no exceptions were thrown.
              CCMN01UI ccmn01ui = new CCMN01UI();
              ROWCCMN01UIG00 rowccmn01uig00_event = new ROWCCMN01UIG00();
              ccmn01ui.setArchInputStruct(ccmn35si.getArchInputStruct());
              rowccmn01uig00_event.setSzCdTask(TASK_MNTN_LIC);
              rowccmn01uig00_event.setTsLastUpdate(null);
              rowccmn01uig00_event.setSzCdEventStatus(EVENT_STATUS_APRV);
              rowccmn01uig00_event.setSzCdEventType(EVENT_TYPE_HOME);
              rowccmn01uig00_event.setUlIdEvent(0);
              rowccmn01uig00_event.setUlIdStage(idStage_ccmn35si);
              rowccmn01uig00_event.setUlIdPerson(ccmn35si.getUlIdPerson());
              rowccmn01uig00_event.setSzTxtEventDescr(eventDesc);
              rowccmn01uig00_event.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
              ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
              ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00_event);

              // Call PostEvent
              CCMN01UO ccm01uo = postEvent.postEvent(ccmn01ui);
              idEvent_ccmn01uo = ccm01uo.getUlIdEvent();

              /*
               * Code added by Srinivas for sending Information to VendorOutbound Table If new Approval is F/A Home that
               * information need to be send.
               */
              String winResult = ccmn35si.getSzWcdCdAprvlWinaction();

              // STGAP00007507 - check to see if home is non-DFCS home and if so, do not send registration to SMILE
              indRsrcNonDfcs = capsResource.getIndRsrcNonDfcs();
              String adoptiveHome = "A";
              String legalRiskAdoptiveHome = "L";
              if ("APRV".equals(rowccmn61di.getSzCdApproversStatus()) && "COM".equals(winResult)) {
                if (!(ArchitectureConstants.Y.equals(indRsrcNonDfcs))
                    || (ArchitectureConstants.Y.equals(indRsrcNonDfcs))
                    && (adoptiveHome.equals(capsResource.getCdRsrcCategory()) || legalRiskAdoptiveHome
                                                                                                      .equals(capsResource
                                                                                                                          .getCdRsrcCategory()))

                ) {

                  Date dtRsrcUpdated = new Date();
                  // int ulIdEvent = idEvent_ccmn01uo;
                  int idStage = idStage_ccmn35si;
                  int idCase = ccmn35si.getUlIdCase();

                  VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
                  vendorOutboundSI.setDtRsrcUpdated(dtRsrcUpdated);
                  vendorOutboundSI.setUserId(ccmn35si.getUlIdPerson());
                  vendorOutboundSI.setIdCase(idCase);
                  vendorOutboundSI.setIdStage(idStage);
                  vendorOutboundSI.setIdEvent(idEvent);
                  saveVendorOutbound.saveNewVendor(vendorOutboundSI);
                }

              }            
              ccmn35so.setUlIdEvent(idEvent_ccmn01uo);
              // Call ccmn91d - CREATE AN APPROVAL LINK
              int nbrRowsAdded = approvalEventLinkDAO.insertApprovalEventLink(idEvent_ccmn01uo, idApproval_ccmn35si);
              if (nbrRowsAdded == 0) {
                throw new ServiceException(Messages.MSG_DUPLICATE_RECORD);
              }
              String cdRsrcFaHomeStatus = "";// HOME_STATUS_APVD_ACT;
              String cdRsrcStatus = RSRC_STAT_INACTIVE;
              int idRsrcFaHomeEvent = ccm01uo.getUlIdEvent();
              int idRsrcFaHomeStage = idStage_ccmn35si;
              String indHoldPlacements = capsResource.getIndHoldPlacements();

              // find cuurent status of the home. In IMPACT you had only
              // one type of active- and pending- approval but in
              // SHINES there 6 types.
              // CapsResource resource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idRsrcFaHomeStage);
              // MR-075 Resource status should be active when the FaHomeStatus is APVD_ACTIVE & the
              // OnHold checkbox is NOT checked. 
              // All other times the resource status should be inactive.
              if ((HOME_STATUS_APVD_FULL_ACT.equals(capsResource.getCdRsrcFaHomeStatus())
                   || HOME_STATUS_APVD_SPEC_ACT.equals(capsResource.getCdRsrcFaHomeStatus()) 
                   || HOME_STATUS_APVD_TEMP_ACT.equals(capsResource.getCdRsrcFaHomeStatus()))
                  && !ServiceConstants.FND_YES.equals(indHoldPlacements)) {
                cdRsrcStatus = RSRC_STAT_ACTIVE;
                indHoldPlacements = ServiceConstants.FND_NO;
              }
              // MR-075 Approval for pending to Approved - Active status,
              // should reset resource status to active
              // and uncheck the hold placement checkbox.
              if (CodesTables.CFAHMSTA_PFA.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = HOME_STATUS_APVD_FULL_ACT;
                cdRsrcStatus = RSRC_STAT_ACTIVE;
                indHoldPlacements = ServiceConstants.FND_NO;
              } else if (CodesTables.CFAHMSTA_PSA.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = HOME_STATUS_APVD_SPEC_ACT;
                cdRsrcStatus = RSRC_STAT_ACTIVE;
                indHoldPlacements = ServiceConstants.FND_NO;
              } else if (CodesTables.CFAHMSTA_PTA.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = HOME_STATUS_APVD_TEMP_ACT;
                cdRsrcStatus = RSRC_STAT_ACTIVE;
                indHoldPlacements = ServiceConstants.FND_NO;
              } else if (HOME_STATUS_APVD_FULL_ACT.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = HOME_STATUS_APVD_FULL_ACT;
              } else if (HOME_STATUS_APVD_SPEC_ACT.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = HOME_STATUS_APVD_SPEC_ACT;
              } else if (CodesTables.CFAHMSTA_FLG.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = CodesTables.CFAHMSTA_FLG;
                indHoldPlacements = ServiceConstants.FND_YES;
              } else if (CodesTables.CFAHMSTA_FSG.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = CodesTables.CFAHMSTA_FSG;
                indHoldPlacements = ServiceConstants.FND_YES;
              } else if (HOME_STATUS_APVD_TEMP_ACT.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = HOME_STATUS_APVD_TEMP_ACT;
              } else if (CodesTables.CFAHMSTA_PFG.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = CodesTables.CFAHMSTA_FLG;
                indHoldPlacements = ServiceConstants.FND_YES;
              } else if (CodesTables.CFAHMSTA_PSG.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = CodesTables.CFAHMSTA_FSG;
                indHoldPlacements = ServiceConstants.FND_YES;
              } else if (CodesTables.CFAHMSTA_AUN.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = CodesTables.CFAHMSTA_AUN;
                indHoldPlacements = ServiceConstants.FND_YES;
              } else if (CodesTables.CFAHMSTA_PUN.equals(capsResource.getCdRsrcFaHomeStatus())) {
                cdRsrcFaHomeStatus = CodesTables.CFAHMSTA_AUN;
                indHoldPlacements = ServiceConstants.FND_YES;
              }

              // This write history indicator must be set to yes in order to write the record to the
              // resource history table
              String indRsrcWriteHist = INDICATOR_YES;
              // Date dtApproversDetermination = DateHelper.toJavaDate(ccmn35si.getROWCCMN61DI()
              // .getDtDtApproversDetermination());

              // Call caudb3d - to update CAPS_RESOURCE to APPROVED_ACTIVE
              nbrRowsUpdated = complexCapsResourceDAO.updateCapsResource(idRsrcFaHomeStage, idApproval_ccmn35si,
                                                                         cdRsrcFaHomeStatus, cdRsrcStatus,
                                                                         idRsrcFaHomeEvent, indRsrcWriteHist,
                                                                         indHoldPlacements);
              if (nbrRowsUpdated == 0) {
                // ******* Not sure if it should be Messages.MSG_FAD_NO_CARETAKER *******
                throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
              }
              // home approval alerts here
              sendAlertsforApprovedAdoptiveHome(capsResource, ccmn35si);

              // STGAP00011732: Adding Legal risk to both because we will need to generate both
              // foster and adoptive contracts for legal risk category
              // Set bAdoptive or bFoster based on category FA_CATG_FOST_ADO_LEG_RISK
              if (FA_CATG_FOST.equals(capsResource.getCdRsrcCategory())
                  || FA_CATG_ICPC_FOSTER.equals(capsResource.getCdRsrcCategory())
                  || FA_CATG_REL_FOST.equals(capsResource.getCdRsrcCategory())
                  || FA_CATG_FOST_ADO_LEG_RISK.equals(capsResource.getCdRsrcCategory())) {
                contractTypesToGenerate.add("F");// add foster contracts
              }

              if (FA_CATG_ADOPT.equals(capsResource.getCdRsrcCategory())
                  || FA_CATG_REL_ADOPT.equals(capsResource.getCdRsrcCategory())
                  || FA_CATG_FOST_ADO_LEG_RISK.equals(capsResource.getCdRsrcCategory())) {
                contractTypesToGenerate.add("A");
              }
            }

            // CallCRES04D
            // CapsResource capsResource = findCapsResource(idResourceCapsResource);
            // Whenever CRES04D is called, getAdoptiveOrFoster needs to be called passing CapsResource
            // as the parameter to build the value of the string 'adoptiveOrFoster'
            // replace getAdoptiveOrFoster with getAdoptiveOrFosterList
            // adoptiveOrFosterList = getAdoptiveOrFosterList(capsResource);
            // call clss67d
            List<Contract> contractList = contractDAO.findContractByIdResource(idResourceCapsResource);
            if (contractList != null && !contractList.isEmpty()) {
              // Retrieve Contract Period, Contract Version, Contract Service
              for (Iterator<Contract> itContract = contractList.iterator(); itContract.hasNext();) {
                Contract contract = itContract.next();
                Map<String, Object> contractRecord = new HashMap<String, Object>();
                contractRecord.put("contract", contract);
                int idContract = contract.getIdContract();

                // Call CSES80D - Retrieve Contract Period
                ContractPeriod contractPeriod = contractPeriodDAO.findContractPeriodByIdContract(idContract);

                if (contractPeriod != null) {
                  contractRecord.put("contractPeriod", contractPeriod);
                  processContractPeriodDate(contractPeriod, contractRecord);
                  contractsRecord.add(contractRecord);
                }
              }

              // Loop through all contract rows returned from the previous DAMs
              for (Iterator<Map<String, Object>> it_contractRecords = contractsRecord.iterator(); it_contractRecords
                                                                                                                    .hasNext();) {
                Map<String, Object> contractRecord = it_contractRecords.next();
                if (StringHelper.toBooleanSafe((String) contractRecord.get("indContractCurrent"))) {
                  Contract contract = (Contract) contractRecord.get("contract");
                  int idContract = contract.getIdContract();
                  ContractPeriod contractPeriod = (ContractPeriod) contractRecord.get("contractPeriod");
                  // Contract Version retrieve for an idContract , contract period number,
                  // and version end date that is greater than the current date.
                  // Call CSES81D - Contract Version retrieve
                  ContractVersion contractVersion = contractVersionDAO
                                                                      .findCurrentContractVersion(
                                                                                                  idContract,
                                                                                                  contractPeriod
                                                                                                                .getId()
                                                                                                                .getNbrCnperPeriod());

                  if (contractVersion == null) {
                    break;
                  }
                  contractRecord.put("contractVersion", contractVersion);
                  // Call CLSS13D
                  List<ContractService> contractServices = contractServiceDAO
                                                                             .findConSvcByIdConAndNbrCnsvcPeriodMaxAndNbrCnsvcVersionMax(idContract);

                  // int tempSvcRowQty = 0;

                  if (contractServices != null && !contractServices.isEmpty()) {
                    contractRecord.put("contractServices", contractServices);
                    tempSvcRowQty1 = contractServices.size();
                    for (Iterator<ContractService> cs_it = contractServices.iterator(); cs_it.hasNext();) {
                      ContractService contractService = cs_it.next();
                      // Compare against F/A home codes if service code is a foster code
                      if (doesServiceExist(contractService.getCdCnsvcService(), CodesTables.CFOSSVCD)) {
                        indFosterContractExists = true;
                        indUpdateFosterContract = true;
                      }
                      if (doesServiceExist(contractService.getCdCnsvcService(), CodesTables.CADOSVCD)) {
                        indAdoptContractExists = true;
                        indUpdateAdoptContract = true;
                      }
                      // Retrieve contract service codes for the contract, period, and version passed to the DAO
                      // Call CLSS68D
                      List<ContractCounty> contractCounties = contractCountyDAO
                                                                               .findContractCountyByIdContactVersionAndPeriod(
                                                                                                                              idContract,
                                                                                                                              contractPeriod
                                                                                                                                            .getId()
                                                                                                                                            .getNbrCnperPeriod(),
                                                                                                                              contractVersion
                                                                                                                                             .getNbrCnverVersion());

                      if (contractCounties != null && !contractCounties.isEmpty()) {
                        contractRecord.put("contractCounties", contractCounties);
                        // tempSvcRowQty = contractCounties.size();
                        contractRecord.put("nbrGenericCntr", contractCounties.size());
                      }
                    }
                  }
                }
              }
            }
          }
          // Call CINT20D - Retrieve Primary Worker from Stage Person Link.
          StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                              .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                                     idStage_ccmn35si,
                                                                                                                     PERSON_STAGE_ROLE_PRIMARY,
                                                                                                                     PERSON_TYPE_WORKER);
          if (stagePersonLink == null) {
            throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
          }
          Map<String, Object> contractRecord = null;
          Contract contract = null;
          if (!contractsRecord.isEmpty() || contractsRecord.size() > 0) {
            contractRecord = contractsRecord.get(0);
            contract = (Contract) contractRecord.get("contract");
          } else {
            contract = new Contract();
          }
          contract.setPersonByIdCntrctManager(stagePersonLink.getPerson());

          // CALL CRES13D - Retrieve Resource Address
          int idRsrc = 0;
          if(capsResource!=null){
            idRsrc = capsResource.getIdResource(); 
          }else{
            throw new ServiceException(Messages.SQL_NOT_FOUND);
           }
          List<ResourceAddress> resourceAddresses = resourceAddressDAO
                                                                      .findResourceAddressByIdResource(idRsrc);
          if (resourceAddresses == null || resourceAddresses.isEmpty()) {
            throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
          }

          // Set fields in CFAD07SOG01 to fields in CRES13DO
          int tempResourceAddress = 0;
          for (Iterator<ResourceAddress> resourceAddress_it = resourceAddresses.iterator(); resourceAddress_it
                                                                                                              .hasNext();) {
            ResourceAddress resourceAddress = resourceAddress_it.next();
            // Copy idResourceAddress if the address type if "buisness" and has a valid VID.
            // (There can be more than one business address but only one with a VID.)
            if (RSRC_PRIM_ADDR.equals(resourceAddress.getCdRsrcAddrType())) {
              // Per patrirck disable vendor id validation and ensure that
              // address is of type "primary"
              // && resourceAddress.getNbrRsrcAddrVid() != null) {
              tempResourceAddress = resourceAddress.getIdRsrcAddress();
              break;
            }
          }

          capsResource_cses41d = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage_ccmn35si);
          if (capsResource_cses41d == null) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
          String tempCdRsrcCnty = capsResource_cses41d.getCdRsrcCnty();
          if (COUNTY_CD_OUT_OF_STATE.equals(capsResource_cses41d.getCdRsrcCnty())) {
            // Call CCMN39D
            UnitEmpLink unitEmpLink = unitEmpLinkDAO
                                                    .findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(
                                                                                                               contract
                                                                                                                       .getPersonByIdCntrctManager()
                                                                                                                       .getIdPerson(),
                                                                                                               UNIT_MEMBER_IN_ASSIGNED);
            if (unitEmpLink == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            String cdUnitRegion = unitEmpLink.getUnit().getCdUnitRegion();

            // checking to see if someone with a division number is trying to save. If not,
            // then delete the leading zero in the region number
            if ("0".equals(cdUnitRegion.charAt(0))) {
              tempCdCntrctRegion = "" + cdUnitRegion.charAt(1) + cdUnitRegion.charAt(2);
            } else {
              // If someone with a division number is trying to save then it will be
              // defaulted to state office.
              tempCdCntrctRegion = CAPS_UNIT_STATE_OFFICE;
            }
          } else {
            // CSES82D - Region retrieval from Region/County table
            tempCdCntrctRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, tempCdRsrcCnty);
            if (tempCdCntrctRegion.length() == 3 & tempCdCntrctRegion.startsWith("0")) {
              tempCdCntrctRegion = tempCdCntrctRegion.substring(1);
            }
          }
          CapsResource capsResource_saveContract = getPersistentObject(CapsResource.class, idResourceCapsResource);
          ResourceAddress resourceAddress_saveContract = getPersistentObject(ResourceAddress.class, tempResourceAddress);
          Person contractManager = getPersistentObject(Person.class, contract.getPersonByIdCntrctManager()
                                                                             .getIdPerson());
          Person contractWorker = getPersistentObject(Person.class, idCntrctWkr);
          // Only create new contracts if one doesnt exist.
          // Create adoption contract only if category is of type ADOPTION or RELATIVE ADOPT
          // Create foster contract if category is of type FOSTER, FOSTER_ADOPT_LEGAL_RISK,
          // RELATIVE_ADOPT or ICPC
          indRsrcNonDfcs = capsResource.getIndRsrcNonDfcs();
          String adoptiveHome = "A";
          String legalRiskAdoptiveHome="L";
          //STGAP00010878: Need to add a new contract in case of foster home conversion.
          Iterator contractTypesIterator = contractTypesToGenerate.iterator();
	  while (contractTypesIterator.hasNext()) {// STGAP00011732 begin contract generation logic
            String contractType = (String) contractTypesIterator.next();

            boolean bAdoptive;
            boolean bFoster;
            if (contractType.equals("F")) {
              bFoster = true;
              bAdoptive = false;
            } else {
              bFoster = false;
              bAdoptive = true;
            }
            if ((((!indAdoptContractExists && bAdoptive) || (!indFosterContractExists && bFoster)) && (!indRsrcNonDfcs
                                                                                                                      .equals("Y")))
                || (indRsrcNonDfcs.equals("Y") && (adoptiveHome.equals(capsResource.getCdRsrcCategory()) || legalRiskAdoptiveHome
                                                                                                                                 .equals(capsResource
                                                                                                                                                     .getCdRsrcCategory())))
                || indFosterHmConv) {
              //STGAP00013590: If indAdoptContractExistsForFAHomeConv = false then add the contract
              // indAdoptContractExistsForFAHomeConv is set to true if the contract with adoption Asssistance services 
              // exists for a resource when approving foster home conversion.
              if(!indAdoptContractExistsForFAHomeConv){
                Contract addContract = new Contract();
                addContract.setCapsResource(capsResource_saveContract);
                addContract.setCdCntrctFuncType(STAGE_CD_FAD);
                addContract.setCdCntrctProgramType(FA_PROGRAM);
                addContract.setCdCntrctProcureType(PROVIDER_ENROLL);
                addContract.setCdCntrctRegion(tempCdCntrctRegion);
                addContract.setIndCntrctBudgLimit(NO_LIMIT);
                addContract.setResourceAddress(resourceAddress_saveContract);
                addContract.setPersonByIdCntrctManager(contractManager);
                addContract.setPersonByIdCntrctWkr(contractWorker);
                // Hibernate will handle any Exception that this call generates
                contractDAO.saveContract(addContract);
                int idContract_addContract = addContract.getIdContract();

                // CAUD20D - SAVE CONTRACT PERIOD
                ContractPeriod addContractPeriod = new ContractPeriod();
                addContractPeriod.setContract(addContract);
                // Get the logged on users id
                addContractPeriod.setPerson(contractWorker);
                ContractPeriodId contractPeriodId = new ContractPeriodId();
                contractPeriodId.setIdContract(idContract_addContract);
                contractPeriodId.setNbrCnperPeriod(ONE);
                addContractPeriod.setId(contractPeriodId);

                // Get today's date
                Date currentDate = new Date();
                // Add 100 years to today's date
                Date futureDate = DateHelper.addToDate(currentDate, 100, 0, 0);
                addContractPeriod.setDtCnperClosure(futureDate);
                addContractPeriod.setDtCnperTerm(futureDate);
                // STGAP00008024 - changed code to set the home approval date as the period start date
                if (capsResource.getDtLicBegin() != null) {
                  addContractPeriod.setDtCnperStart(capsResource.getDtLicBegin());
                } else {
                  addContractPeriod.setDtCnperStart(currentDate);
                }
                addContractPeriod.setCdCnperStatus(CONTRACT_STATUS_ACTIVE);
                addContractPeriod.setIndCnperRenewal(INDICATOR_NO);
                addContractPeriod.setIndCnperSigned(INDICATOR_YES);
                // Hibernate will handle any Exception that this call generates
                contractPeriodDAO.saveContractPeriod(addContractPeriod);
                ContractVersion addContractVersion = new ContractVersion();
                addContractVersion.setContractPeriod(addContractPeriod);
                // Get the logged on users id
                addContractVersion.setPerson(contractWorker);
                addContractVersion.setNbrCnverVersion(ONE);
                addContractVersion.setDtCnverCreate(currentDate);
                if (capsResource.getDtLicBegin() != null) {
                  addContractVersion.setDtCnverEffective(capsResource.getDtLicBegin());
                } else {
                  addContractVersion.setDtCnverEffective(currentDate);
                }
                // When creating a new contract, dtCnverEnd should be the current date plus 100 years
                addContractVersion.setDtCnverEnd(futureDate);
                addContractVersion.setIndCnverVerLock(INDICATOR_YES);
                contractVersionDAO.saveContractVersion(addContractVersion);

                if (!bFoster || indFosterHmConv) {
                  // save adoption services to the contract service table
                  if (capsResource.getDtLicBegin() != null) {

                    // STGAP00009856 If the Resource County has been changed then the CAPS_RESOURCE table has been udpated
                    // but
                    // we have not updated RESOURCE_SERVICE yet which causes problems futher in the code

                    /* Remove code per STGAP00014260 causing ContraintViolationException since county and resource have duplicate services 
                     * in different counties.  Logic updates all resource services to resource home county and region, hence 
                     * the error due to duplicates created.

                   List<ResourceService> resourceServices = resourceServiceDAO
                                                                             .findResourceServiceAll(idResourceCapsResource);
                  //STGAP00014037: Added this code to prevent Constraint Violated Exception. Loop through the old county and
                  // if it's not null then update the resource service.

                  if (resourceServices != null & !resourceServices.isEmpty()) {
                    Iterator iter = resourceServices.iterator();
                    while(iter.hasNext()){
                      ResourceService resourceservice = (ResourceService)iter.next();
                      String oldCounty = resourceservice.getCdRsrcSvcCnty();
                      if(oldCounty != null){
                        if (tempCdRsrcCnty != oldCounty) {
                          resourceServiceDAO.updateResourceServiceCounty(idResourceCapsResource, tempCdRsrcCnty);
                        }
                      }
                    }
                  }
                     */
                    saveContractsService(CodesTables.CADOSVCD, addContract, ONE, ONE, capsResource.getDtLicBegin(),
                                         futureDate);
                    // STGAP00006650 - created new method addRegionToRsrcServices() to save the region of the resource to
                    // the resourceServices table
                    addRegionToRsrcServices(capsResource, tempCdCntrctRegion, CodesTables.CADOSVCD);
                  } else {
                    saveContractsService(CodesTables.CADOSVCD, addContract, ONE, ONE, currentDate, futureDate);
                    addRegionToRsrcServices(capsResource, tempCdCntrctRegion, CodesTables.CADOSVCD);
                  }
                } else {
                  // save foster services to the contract service table
                  if (capsResource.getDtLicBegin() != null) {
                    saveContractsService(CodesTables.CFOSSVCD, addContract, ONE, ONE, capsResource.getDtLicBegin(),
                                         futureDate);
                    addRegionToRsrcServices(capsResource, tempCdCntrctRegion, CodesTables.CFOSSVCD);
                  } else {
                    saveContractsService(CodesTables.CFOSSVCD, addContract, ONE, ONE, currentDate, futureDate);
                    addRegionToRsrcServices(capsResource, tempCdCntrctRegion, CodesTables.CFOSSVCD);
                  }
                }
              } 
            }  // STGAP00009856 If the contract exists and it is Adoptive or Foster then
            // Then check to see if the county has been chaged if so then add a new version.
            else if (((indAdoptContractExists && bAdoptive) || (indFosterContractExists && bFoster))
                     && (!indRsrcNonDfcs.equals("Y"))) {
              String oldResourceCounty = "";
              String currentResourceCounty = "";
              ContractCounty oldContractCounty = null;
              Date dtResourceAddress = null;
              Date currentDate = new Date();
              int idResource = capsResource_cses41d.getIdResource();
              for (Iterator<ResourceAddress> resourceAddress_it = resourceAddresses.iterator(); resourceAddress_it
                                                                                                                  .hasNext();) {

                ResourceAddress resourceAddress = resourceAddress_it.next();

                if (RSRC_PRIM_ADDR.equals(resourceAddress.getCdRsrcAddrType())) {
                  currentResourceCounty = resourceAddress.getCdRsrcAddrCounty();
                  dtResourceAddress = resourceAddress.getDtLastUpdate();
                  break;
                }
              }
              if (currentResourceCounty != null) {
                List<ContractCounty> contractCounties = (List<ContractCounty>) contractRecord.get("contractCounties");
                ContractPeriod contractPeriod = (ContractPeriod) contractRecord.get("contractPeriod");
                Contract addContract = (Contract) contractRecord.get("contract");

                // Only need the first entry since all the counties will be the same
                oldContractCounty = contractCounties.get(0);
                oldResourceCounty = oldContractCounty.getCdCncntyCounty();
                Integer idContract = oldContractCounty.getContract().getIdContract();
                Date futureDate = DateHelper.addToDate(currentDate, 100, 0, 0);

                // adding new contract version since the county has been changed
//                if (!oldResourceCounty.equals(currentResourceCounty)) {
//                  ContractVersion latestVersion = contractVersionDAO
//                                                                    .findLatestContractVersion(
//                                                                                               idContract,
//                                                                                               contractPeriod
//                                                                                                             .getId()
//                                                                                                             .getNbrCnperPeriod());
//                  ContractVersion addContractVersion = new ContractVersion();
//                  // Get the logged on users id
//                  addContractVersion.setPerson(contractWorker);
//                  addContractVersion.setContractPeriod(contractPeriod);
//                  addContractVersion.setNbrCnverVersion(latestVersion.getNbrCnverVersion() + 1);
//                  addContractVersion.setDtCnverCreate(currentDate);
//                  addContractVersion.setDtCnverEffective(dtResourceAddress);
//                  // When creating a new contract, dtCnverEnd should be the current date plus 100 years
//                  addContractVersion.setDtCnverEnd(futureDate);
//                  addContractVersion.setIndCnverVerLock(INDICATOR_YES);
//
//                  contractVersionDAO.saveContractVersion(addContractVersion);
//                  if (!bFoster) {
//                    // save adoption services to the contract service table
//                    saveContractsService(CodesTables.CADOSVCD, addContract, ONE,
//                                         latestVersion.getNbrCnverVersion() + 1, currentDate, futureDate);
//                    addRsrcServices(idResource, CodesTables.CADOSVCD);
//                  } else {
//                    // save foster services to the contract service table
//                    saveContractsService(CodesTables.CFOSSVCD, addContract, ONE,
//                                         latestVersion.getNbrCnverVersion() + 1, currentDate, futureDate);
//                    addRsrcServices(idResource, CodesTables.CFOSSVCD);
//                  }
//
//                }

              }
            }

            if ((indAdoptContractExists || indFosterContractExists) && (indRsrcNonDfcs.equals("Y"))) {

              // Contract modification process if the contract already exists and a change
              // has been made to the home's status
              Iterator<Map<String, Object>> contractRecords_it = contractsRecord.iterator();
              while (contractRecords_it.hasNext() && (indAdoptContractExists || indFosterContractExists)) {
                Map contractRecord_modification = contractRecords_it.next();

                ContractPeriod activeContract = (ContractPeriod) contractRecord_modification.get("contractPeriod");
                boolean indContractCurrent = false;
                if (activeContract != null && !CONTRACT_STATUS_CLOSED.equals(activeContract.getCdCnperStatus())) {
                  indContractCurrent = true;
                }

                if (indContractCurrent) {
                  if (indAdoptContractExists) {
                    indAdoptContractExists = false;
                    // createContract = ADOPTIVE;
                  } else if (indFosterContractExists) {
                    indFosterContractExists = false;
                    // createContract = FOSTER;
                  }

                  // CAUD20D CONTRACT PERIOD
                  Contract updateContract = (Contract) contractRecord_modification.get("contract");
                  ContractPeriod updateContractPeriod = (ContractPeriod) contractRecord_modification
                                                                                                    .get("contractPeriod");
                  List<ContractService> contractServices_modification = (List<ContractService>) contractRecord_modification
                                                                                                                           .get("contractServices");
                  // Run loop four times to guarantee all contract services will be checked.
                  for (int j = 0; j < contractServices_modification.size(); j++) {

                    ContractService contractService_mod = contractServices_modification.get(j);

                    // Get today's date
                    Date currentDate = new Date();
                    // If service codes are for a foster contract do foster processing
                    if ((indUpdateFosterContract && (doesServiceExist(contractService_mod.getCdCnsvcService(),
                                                                      CodesTables.CFOSSVCD)))
                        || (indUpdateAdoptContract && (doesServiceExist(contractService_mod.getCdCnsvcService(),
                                                                        CodesTables.CADOSVCD)))) {
                      updateContractPeriod.setCdCnperStatus(CONTRACT_STATUS_CLOSED);

                      // Compare today's date with Period Start date
                      if (DateHelper.isToday(updateContractPeriod.getDtCnperStart())) {
                        // The dates are the same and we need to add one day to current date before setting
                        // Term and Closure date to it. This will avoid an error on the window regarding
                        // start date can not equal term or closure date
                        currentDate = DateHelper.addToDate(currentDate, 0, 0, 1);
                        updateContractPeriod.setDtCnperTerm(currentDate);
                        updateContractPeriod.setDtCnperClosure(currentDate);
                      } else {
                        updateContractPeriod.setDtCnperTerm(currentDate);
                        updateContractPeriod.setDtCnperClosure(currentDate);
                      }
                      if (doesServiceExist(contractService_mod.getCdCnsvcService(), CodesTables.CADOSVCD)) {
                        updateContractPeriod.setCdCnperStatus(CONTRACT_STATUS_SERVICE_HOLD);
                      }
                    }
                  }
                  updateContractPeriod.setIndCnperRenewal(INDICATOR_NO);
                  updateContractPeriod.setIndCnperSigned(INDICATOR_NO);
                  // Hibernate will handle all exceptions thrown while processing this call
                  contractPeriodDAO.saveContractPeriod(updateContractPeriod);

                  // CAUD15D - CONTRACT VERSION AUD
                  ContractVersion updateContractVersion = (ContractVersion) contractRecord_modification
                                                                                                       .get("contractVersion");

                  // The lastest period and version for the contract needs to be updated. We cannot
                  // assume that there is only one period and one version for a FA Home contract.
                  updateContractVersion.setContractPeriod(updateContractPeriod);
                  updateContractVersion.setIndCnverVerLock(INDICATOR_YES);

                  // Run loop four times to guarantee all contract services will be checked.
                  for (int j = 0; j < contractServices_modification.size(); j++) {
                    ContractService contractService_mod = contractServices_modification.get(j);
                    // If service codes are for a foster contract do foster processing
                    if (doesServiceExist(contractService_mod.getCdCnsvcService(), CodesTables.CFOSSVCD)) {
                      // Get today's date
                      Date currentDate = new Date();
                      updateContractVersion.setDtCnverEnd(currentDate);

                    }
                    // If service codes are for an adoptive contract, there's no need to do adoptive processing
                    // since dtCnverEnd for the contract version will not change
                  }

                  // Hibernate will handle all exceptions thrown while processing this call
                  contractVersionDAO.saveContractVersion(updateContractVersion);

                  // CAUD08D - CONTRACT COUNTY update. This is added because the contract county
                  // end date needs to be upated simulatneously with the contract_period and
                  // contract_county tables.
                  // Run loop four times to guarantee all contract county services will be checked.
                  int tempSvcRowQty2 = getSizeOfCodeCategory(CodesTables.CFOSSVCD);
                  List<ContractCounty> contractCounties_modification = (List<ContractCounty>) contractRecord_modification
                                                                                                                         .get("contractCounties");
                  ContractCounty contractCounty_mod = contractCounties_modification.get(0);
                  if (doesServiceExist(contractCounty_mod.getCdCncntyService(), CodesTables.CADOSVCD)) {
                    tempSvcRowQty2 = getSizeOfCodeCategory(CodesTables.CADOSVCD);
                  }
                  // moved this line of code out of the for loop because it needs to make the
                  // call only once because it is the same object
                  CapsResource updateResource = getPersistentObject(CapsResource.class, idResourceCapsResource);
                  for (int j = 0; j < contractCounties_modification.size(); j++) {
                    ContractCounty updateContractCounty = contractCounties_modification.get(j);
                    updateContractCounty.setContract(updateContract);
                    updateContractCounty.setCapsResource(updateResource);
                    // If service codes are for a foster contract do foster processing
                    if (doesServiceExist(contractCounty_mod.getCdCncntyService(), CodesTables.CFOSSVCD)
                        || doesServiceExist(contractCounty_mod.getCdCncntyService(), CodesTables.CADOSVCD)) {
                      // Get today's date
                      Date currentDate = new Date();
                      updateContractCounty.setDtCncntyEnd(currentDate);
                    }
                    // If county service codes are for an adoptive contract, there's no need to do adoptive processing
                    // since dtCncntyEnd for the contract county will not change
                    // Hibernate will handle all exceptions thrown while processing this call
                    contractCountyDAO.saveContractCounty(updateContractCounty);
                  }
                }
              }
            }

            Iterator<Map<String, Object>> contractsRecord_it = contractsRecord.iterator();
            while (contractsRecord_it.hasNext() && (indUpdateAdoptContract || indUpdateFosterContract)
                   && !(indRsrcNonDfcs.equals("Y"))) {
              Map contractRecord_modification = contractsRecord_it.next();
              boolean indContractCurrent = StringHelper
                                                       .toBooleanSafe((String) contractRecord_modification
                                                                                                          .get("indContractCurrent"));
              if (indContractCurrent) {
                List<ContractService> contractServices_modification = (List<ContractService>) contractRecord_modification
                                                                                                                         .get("contractServices");
                ContractService contractService_mod = contractServices_modification.get(0);

                if (indUpdateAdoptContract
                    && (doesServiceExist(contractService_mod.getCdCnsvcService(), CodesTables.CADOSVCD))) {
                  indUpdateAdoptContract = false;
                  intUpdateContract = ADOPTIVE;
                } else if (indUpdateFosterContract
                           && (doesServiceExist(contractService_mod.getCdCnsvcService(), CodesTables.CFOSSVCD))) {
                  indUpdateFosterContract = false;
                  intUpdateContract = FOSTER;
                }

                // Update the contract table when approving the home. This is necessary if a prs home has been
                // reopened and the region has changed before the home has been re-approved.

                // CAUD01D CONTRACT AUD
                Contract updateContract = (Contract) contractRecord_modification.get("contract");
                // May have to first put this object in a persistent state in order for
                // Hibernate to update it.
                updateContract.setCapsResource(capsResource_saveContract);
                updateContract.setCdCntrctFuncType(CodesTables.CSTAGES_FAD);
                updateContract.setCdCntrctProgramType(FA_PROGRAM);
                updateContract.setCdCntrctProcureType(PROVIDER_ENROLL);
                updateContract.setCdCntrctRegion(tempCdCntrctRegion);
                updateContract.setIndCntrctBudgLimit(NO_LIMIT);
                updateContract.setResourceAddress(resourceAddress_saveContract);
                updateContract.setPersonByIdCntrctManager(contractManager);
                updateContract.setPersonByIdCntrctWkr(contractWorker);
                contractDAO.saveContract(updateContract);

                // CAUD20D - UPDATE CONTRACT PERIOD
                ContractPeriod updateContractPeriod = (ContractPeriod) contractRecord_modification
                                                                                                  .get("contractPeriod");
                // Get the logged on users id
                updateContractPeriod.setPerson(contractWorker);
                updateContractPeriod.getId().setNbrCnperPeriod(ONE);
                updateContractPeriod.setCdCnperStatus(CONTRACT_STATUS_ACTIVE);
                updateContractPeriod.setIndCnperRenewal(INDICATOR_NO);
                updateContractPeriod.setIndCnperSigned(INDICATOR_YES);
                // May have to first put this object in a persistent state in order for
                // Hibernate to update it.
                // Call CAUD20D. The Contract Period ELB DAM receives IdContract and
                // performs an AUD on the indicated row.
                // Delete: a stored procedure is called to perform a cascade delete
                // for Contract Version, Contract Service and Contract County.
                // Add: Performs a full row insert into Contract Period Table
                // Modify: Performs a full row update into Contract Period Table.
                // Hibernate will handle any Exception that this call generates
                contractPeriodDAO.saveContractPeriod(updateContractPeriod);

                // We only want to create new version if Category and/or home type is changed
                boolean categoryHomeType = checkCatHomeType(ccmn35si, idResourceCapsResource);
                if (indContractCurrent && intUpdateContract == FOSTER && !categoryHomeType) {
                  contractVerSerCnty(ccmn35si, updateContract.getIdContract(),
                                     updateContractPeriod.getId().getNbrCnperPeriod(), idResourceCapsResource);
                }
              }
            }
          }//STGAP00011732  end contract generation logic
        }

        // Create a Todo, when the task is re-evaluate and Approved
        else if (RE_EVALUATE.equals(cdTask) && WIN_COMPAPRV.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
          // Create Todo
          CSUB40UI csub40ui = new CSUB40UI();
          csub40ui.setArchInputStruct(ccmn35si.getArchInputStruct());
          CSUB40UIG00 csub40uig00 = new CSUB40UIG00();
          csub40uig00.setSzSysCdTodoCf(TODO_FA_HOME);
          csub40uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(new Date()));
          csub40uig00.setUlSysIdTodoCfPersCrea(ccmn35si.getUlIdPerson());
          csub40uig00.setUlSysIdTodoCfEvent(0);
          csub40uig00.setUlSysIdTodoCfStage(idStage_ccmn35si);
          csub40ui.setCSUB40UIG00(csub40uig00);
          todoCommonFunction.audTodo(csub40ui);

          // STGAP00011370: sending Home Re-Evaluation notice to SAU
          // these local variables were created to prevent
          // interferrence with other code
          boolean isAdoptive = true;
          boolean isFoster = true;
          boolean isFosterAdoptive = false;
          boolean hasAprvFHConv = false;
          boolean homeRegisteredWithExchange = false;
          
          Event homeRegEvent = eventDAO.findEventByStageTypeAndStatus(idStage_ccmn35si,CodesTables.CEVNTTYP_EXH,CodesTables.CEVTSTAT_PROC);   

          if(homeRegEvent != null) {
            homeRegisteredWithExchange = true;
          }

          CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage_ccmn35si);
          if (capsResource != null) {
            FosterHomeConv fhc = fosterHomeConvDAO.findFosterHomeConvByIdResource(capsResource.getIdResource());
            hasAprvFHConv = (fhc == null ? false : true);
          }

          // Set is Foster/Adoptive (Legal Risk)
          if (FA_CATG_FOST_ADO_LEG_RISK.equals(capsResource.getCdRsrcCategory())) {
            isFosterAdoptive = true;
          }

          if (hasAprvFHConv || (isFosterAdoptive && homeRegisteredWithExchange)) {
            sendAlertsForHomeReEvaluation(ccmn35si);
          }
        }//*****************************************
        if (TASK_CLOSE_HOME.equals(cdTask)) {// -TODO
          // CdTask is set to null rather than Close Home if the Closure is being approved.
          // This will prevent the user from returning to the window from the Task or
          // Event List by clicking the Detail Pushbutton.
          if (WIN_COMPAPRV.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
            // Create an Event
            CCMN01UI ccmn01ui = new CCMN01UI();
            ccmn01ui.setArchInputStruct(ccmn35si.getArchInputStruct());
            ROWCCMN01UIG00 rowccmn01uig00_closure = new ROWCCMN01UIG00();
            rowccmn01uig00_closure.setSzCdTask("");
            rowccmn01uig00_closure.setTsLastUpdate(null);
            rowccmn01uig00_closure.setSzCdEventStatus(EVENT_STATUS_APRV);
            rowccmn01uig00_closure.setSzCdEventType(EVENT_TYPE_HOME);
            rowccmn01uig00_closure.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
            rowccmn01uig00_closure.setUlIdEvent(0);
            rowccmn01uig00_closure.setUlIdStage(ccmn35si.getUlIdStage());
            rowccmn01uig00_closure.setUlIdPerson(ccmn35si.getUlIdPerson());
            rowccmn01uig00_closure.setSzTxtEventDescr("Home Closed.");
            ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
            ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00_closure);
            CCMN01UO ccm01uo_closure = postEvent.postEvent(ccmn01ui);

            // CREATE AN APPROVAL LINK
            // Call CCMN91D
            int nbrRowsAdded = approvalEventLinkDAO.insertApprovalEventLink(ccm01uo_closure.getUlIdEvent(),
                                                                            ccmn35si.getUlIdApproval());
            if (nbrRowsAdded == 0) {
              throw new ServiceException(Messages.MSG_DUPLICATE_RECORD);
            }

            // Call CAUDB3D
            // MR-075 Approval for closure,
            // should set resource status to inactive
            // and check the hold placement checkbox (setting it to "Y").
            nbrRowsUpdated = complexCapsResourceDAO.updateCapsResource(ccmn35si.getUlIdStage(),
                                                                       ccmn35si.getUlIdApproval(), HOME_STATUS_CLOSED,
                                                                       RSRC_STAT_INACTIVE,
                                                                       ccm01uo_closure.getUlIdEvent(), INDICATOR_YES,
                                                                       INDICATOR_YES);
          // STGAP00014709 properly evaluating the minute difference between the date a home is approved 
          // till the date we are trying to close the home.  Positive numbers will result in updating the 
          // status to closed while negative numbers will display MSG_FAD_INVAL_CLOSE_DT 
            if (nbrRowsUpdated == 0) {
              throw new ServiceException(Messages.MSG_FAD_INVAL_CLOSE_DT);
            }

            capsResource_cses41d = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage_ccmn35si);
            if (capsResource_cses41d == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            //send alerts for closure
            sendAlertsforClosedAdoptiveHome(capsResource_cses41d, ccmn35si);
            
            List<Map<String, Object>> contractsRecord = new ArrayList<Map<String, Object>>();
            // call clss67d
            List<Contract> contractList = contractDAO.findContractByIdResource(capsResource_cses41d.getIdResource());
            if (contractList != null && !contractList.isEmpty()) {
              // Retrieve Contract Period, Contract Version, Contract Service
              for (Iterator<Contract> itContract = contractList.iterator(); itContract.hasNext();) {
                Contract contract = itContract.next();
                Map<String, Object> contractRecord = new HashMap<String, Object>();
                contractRecord.put("contract", contract);
                int idContract = contract.getIdContract();

                // Call CSES80D - Retrieve Contract Period
                ContractPeriod contractPeriod = contractPeriodDAO.findContractPeriodByIdContract(idContract);

                if (contractPeriod != null) {
                  contractRecord.put("contractPeriod", contractPeriod);
                  processContractPeriodDate(contractPeriod, contractRecord);
                  contractsRecord.add(contractRecord);
                }
              }

              // Loop through all contract rows returned from the previous DAMs
              for (Iterator<Map<String, Object>> it_contractRecords = contractsRecord.iterator(); it_contractRecords
                                                                                                                    .hasNext();) {
                Map<String, Object> contractRecord = it_contractRecords.next();
                if (StringHelper.toBooleanSafe((String) contractRecord.get("indContractCurrent"))) {
                  Contract contract = (Contract) contractRecord.get("contract");
                  int idContract = contract.getIdContract();
                  ContractPeriod contractPeriod = (ContractPeriod) contractRecord.get("contractPeriod");
                  // Contract Version retrieve for an idContract , contract period number,
                  // and version end date that is greater than the current date.
                  // Call CSES81D - Contract Version retrieve
                  ContractVersion contractVersion = contractVersionDAO
                                                                      .findCurrentContractVersion(
                                                                                                  idContract,
                                                                                                  contractPeriod
                                                                                                                .getId()
                                                                                                                .getNbrCnperPeriod());

                  if (contractVersion == null) {
                    break;
                  }
                  contractRecord.put("contractVersion", contractVersion);
                  // Call CLSS13D
                  List<ContractService> contractServices = contractServiceDAO
                                                                             .findConSvcByIdConAndNbrCnsvcPeriodMaxAndNbrCnsvcVersionMax(idContract);

                  // int tempSvcRowQty = 0;

                  if (contractServices != null && !contractServices.isEmpty()) {
                    contractRecord.put("contractServices", contractServices);
                    tempSvcRowQty1 = contractServices.size();
                    for (Iterator<ContractService> cs_it = contractServices.iterator(); cs_it.hasNext();) {
                      ContractService contractService = cs_it.next();
                      // Compare against F/A home codes if service code is a foster code
                      if (doesServiceExist(contractService.getCdCnsvcService(), CodesTables.CFOSSVCD)) {
                        indFosterContractExists = true;
                        indUpdateFosterContract = true;
                      }
                      if (doesServiceExist(contractService.getCdCnsvcService(), CodesTables.CADOSVCD)) {
                        indAdoptContractExists = true;
                        String cdRsrcClosureReason = capsResource_cses41d.getCdRsrcClosureRsn();
                        if(cdRsrcClosureReason.equals(CodesTables.CFACLOSE_AFS)){
                        	//do not close adoptive contract if finalized with subsidies
                        	indUpdateAdoptContract = false;
                        } else {
                        	indUpdateAdoptContract = true;
                        }
                      }
                      // Retrieve contract service codes for the contract, period, and version passed to the DAO
                      // Call CLSS68D
                      List<ContractCounty> contractCounties = contractCountyDAO
                                                                               .findContractCountyByIdContactVersionAndPeriod(
                                                                                                                              idContract,
                                                                                                                              contractPeriod
                                                                                                                                            .getId()
                                                                                                                                            .getNbrCnperPeriod(),
                                                                                                                              contractVersion
                                                                                                                                             .getNbrCnverVersion());

                      if (contractCounties != null && !contractCounties.isEmpty()) {
                        contractRecord.put("contractCounties", contractCounties);
                        // tempSvcRowQty = contractCounties.size();
                        contractRecord.put("nbrGenericCntr", contractCounties.size());
                      }
                    }
                  }
                }
              }
              

              // --TODO
              // Contract modification process if the contract already exists and a change
              // has been made to the home's status
              Iterator<Map<String, Object>> contractRecords_it = contractsRecord.iterator();
              while (contractRecords_it.hasNext() && (indAdoptContractExists || indFosterContractExists)) {
                Map contractRecord_modification = contractRecords_it.next();
                ContractPeriod activeContract = (ContractPeriod) contractRecord_modification.get("contractPeriod");
                boolean indContractCurrent = false;
                if (activeContract != null && DateHelper.isAfterToday(activeContract.getDtCnperClosure())
                    && DateHelper.isAfterToday(activeContract.getDtCnperTerm())) {
                  indContractCurrent = true;
                }
                if (indContractCurrent) {
                  if (indAdoptContractExists) {
                    indAdoptContractExists = false;
                    // createContract = ADOPTIVE;
                                     
                    if(indUpdateAdoptContract == false){
                    	//exit loop leave contract untouched
                    	break;
                    }
                  } else if (indFosterContractExists) {
                    indFosterContractExists = false;
                    // createContract = FOSTER;
                  }
                  
                  // CAUD20D CONTRACT PERIOD
                  Contract updateContract = (Contract) contractRecord_modification.get("contract");
                  ContractPeriod updateContractPeriod = (ContractPeriod) contractRecord_modification
                                                                                                    .get("contractPeriod");
                  List<ContractService> contractServices_modification = (List<ContractService>) contractRecord_modification
                                                                                                                           .get("contractServices");
                  // Run loop four times to guarantee all contract services will be checked.
                  for (int j = 0; j < contractServices_modification.size(); j++) {

                    ContractService contractService_mod = contractServices_modification.get(j);

                    // Get today's date
                    Date currentDate = new Date();
                    // If service codes are for a foster contract do foster processing
                    if ((indUpdateFosterContract && (doesServiceExist(contractService_mod.getCdCnsvcService(),
                                                                      CodesTables.CFOSSVCD)))
                        || (indUpdateAdoptContract && (doesServiceExist(contractService_mod.getCdCnsvcService(),
                                                                        CodesTables.CADOSVCD)))) {
                      updateContractPeriod.setCdCnperStatus(CONTRACT_STATUS_CLOSED);

                      // Compare today's date with Period Start date
                      if (DateHelper.isToday(updateContractPeriod.getDtCnperStart())) {
                        // The dates are the same and we need to add one day to current date before setting
                        // Term and Closure date to it. This will avoid an error on the window regarding
                        // start date can not equal term or closure date
                        currentDate = DateHelper.addToDate(currentDate, 0, 0, 1);
                        updateContractPeriod.setDtCnperTerm(currentDate);
                        updateContractPeriod.setDtCnperClosure(currentDate);
                      } else {
                        updateContractPeriod.setDtCnperTerm(currentDate);
                        updateContractPeriod.setDtCnperClosure(currentDate);
                      }

                    }
                    // If service codes are for an adoptive contract do adoptive processing
                    if (doesServiceExist(contractService_mod.getCdCnsvcService(), CodesTables.CADOSVCD)) {
                      updateContractPeriod.setCdCnperStatus(CONTRACT_STATUS_SERVICE_HOLD);
                    }
                  }
                  updateContractPeriod.setIndCnperRenewal(INDICATOR_NO);
                  updateContractPeriod.setIndCnperSigned(INDICATOR_NO);
                  // Hibernate will handle all exceptions thrown while processing this call
                  contractPeriodDAO.saveContractPeriod(updateContractPeriod);

                  // CAUD15D - CONTRACT VERSION AUD
                  ContractVersion updateContractVersion = (ContractVersion) contractRecord_modification
                                                                                                       .get("contractVersion");

                  // The lastest period and version for the contract needs to be updated. We cannot
                  // assume that there is only one period and one version for a FA Home contract.
                  updateContractVersion.setContractPeriod(updateContractPeriod);
                  updateContractVersion.setIndCnverVerLock(INDICATOR_YES);

                  // Run loop four times to guarantee all contract services will be checked.
                  for (int j = 0; j < contractServices_modification.size(); j++) {
                    ContractService contractService_mod = contractServices_modification.get(j);
                    // If service codes are for a foster contract do foster processing
                    if (doesServiceExist(contractService_mod.getCdCnsvcService(), CodesTables.CFOSSVCD)) {
                      // Get today's date
                      Date currentDate = new Date();
                      updateContractVersion.setDtCnverEnd(currentDate);

                    }
                    // If service codes are for an adoptive contract, there's no need to do adoptive processing
                    // since dtCnverEnd for the contract version will not change
                  }

                  // Hibernate will handle all exceptions thrown while processing this call
                  contractVersionDAO.saveContractVersion(updateContractVersion);

                  // CAUD08D - CONTRACT COUNTY update. This is added because the contract county
                  // end date needs to be upated simulatneously with the contract_period and
                  // contract_county tables.
                  // Run loop four times to guarantee all contract county services will be checked.
                  int tempSvcRowQty2 = getSizeOfCodeCategory(CodesTables.CFOSSVCD);
                  List<ContractCounty> contractCounties_modification = (List<ContractCounty>) contractRecord_modification
                                                                                                                         .get("contractCounties");
                  ContractCounty contractCounty_mod = contractCounties_modification.get(0);
                  if (doesServiceExist(contractCounty_mod.getCdCncntyService(), CodesTables.CADOSVCD)) {
                    tempSvcRowQty2 = getSizeOfCodeCategory(CodesTables.CADOSVCD);
                  }
                  // moved this line of code out of the for loop because it needs to make the
                  // call only once because it is the same object
                  CapsResource updateResource = getPersistentObject(CapsResource.class,
                                                                    capsResource_cses41d.getIdResource());
                  for (int j = 0; j < contractCounties_modification.size(); j++) {
                    ContractCounty updateContractCounty = contractCounties_modification.get(j);
                    updateContractCounty.setContract(updateContract);
                    updateContractCounty.setCapsResource(updateResource);
                    // If service codes are for a foster contract do foster processing
                    if (doesServiceExist(contractCounty_mod.getCdCncntyService(), CodesTables.CFOSSVCD)
                        || doesServiceExist(contractCounty_mod.getCdCncntyService(), CodesTables.CADOSVCD)) {
                      // Get today's date
                      Date currentDate = new Date();
                      updateContractCounty.setDtCncntyEnd(currentDate);
                    }
                    // If county service codes are for an adoptive contract, there's no need to do adoptive processing
                    // since dtCncntyEnd for the contract county will not change
                    // Hibernate will handle all exceptions thrown while processing this call
                    contractCountyDAO.saveContractCounty(updateContractCounty);
                  }
                }
              }
            }
            
            //STGAP00012313: - Update ExchangeHomeDetail with the closure reason on Home info and date home closed.
            String cdRsrcClosureReason = capsResource_cses41d.getCdRsrcClosureRsn();
              
            List<String> reasonCloseList1 = new ArrayList<String>();
            List<String> reasonCloseList2 = new ArrayList<String>();
            List<String> reasonCloseList3 = new ArrayList<String>();

            // 'Withdrawn' Closure Reason on EHD page correspond to all of the below Home Closure reason on Home info page
            reasonCloseList1.add(CodesTables.CFACLOSE_NPR);
            reasonCloseList1.add(CodesTables.CFACLOSE_RTT);
            reasonCloseList1.add(CodesTables.CFACLOSE_PFO);
            reasonCloseList1.add(CodesTables.CFACLOSE_BOT);
            reasonCloseList1.add(CodesTables.CFACLOSE_NRY);
            reasonCloseList1.add(CodesTables.CFACLOSE_HDD);
            reasonCloseList1.add(CodesTables.CFACLOSE_FRC);
            reasonCloseList1.add(CodesTables.CFACLOSE_DNW);

            // 'Denied' Closure Reason on EHD page correspond to all of the below Home Closure reason on Home info page
            reasonCloseList2.add(CodesTables.CFACLOSE_DEN);
            reasonCloseList2.add(CodesTables.CFACLOSE_MTR);
            reasonCloseList2.add(CodesTables.CFACLOSE_FNA);
            reasonCloseList2.add(CodesTables.CFACLOSE_FHP);

            // 'Other' Closure Reason on EHD page correspond to all of the below Home Closure reason on Home info page
            reasonCloseList3.add(CodesTables.CFACLOSE_ARR);
            reasonCloseList3.add(CodesTables.CFACLOSE_CTH);
            reasonCloseList3.add(CodesTables.CFACLOSE_MRC);
            reasonCloseList3.add(CodesTables.CFACLOSE_OTR);
            
            Event homeRegEvent = eventDAO.findEventByStageTypeAndStatus(capsResource_cses41d.getStage().getIdStage(),
                                                                        CodesTables.CEVNTTYP_EXH,CodesTables.CEVTSTAT_PROC); 

            if(homeRegEvent != null){
              ExchangeHome exchangeHome = exchangeHomeDAO.findExchangeHomeByEventId(homeRegEvent.getIdEvent());
              if(exchangeHome != null){
                boolean bReasonFound = false;
                if(reasonCloseList1.contains(cdRsrcClosureReason)){
                  exchangeHome.setCdReasonClosed(CodesTables.CADEXCLD_02);
                  bReasonFound = true;
                }else if(reasonCloseList2.contains(cdRsrcClosureReason)){
                  exchangeHome.setCdReasonClosed(CodesTables.CADEXCLD_03);
                  bReasonFound = true;
                } else if(reasonCloseList3.contains(cdRsrcClosureReason)){
                  exchangeHome.setCdReasonClosed(CodesTables.CADEXCLD_04);
                  bReasonFound = true;
                }
                if (bReasonFound == true) {
                  exchangeHome.setDtClose(new Date());
                  exchangeHomeDAO.saveUpdatExchangeHome(exchangeHome);
                }
              }
            }
          }
                  
          CCMN02UI ccmn02ui = new CCMN02UI();
          ccmn02ui.setArchInputStruct(ccmn35si.getArchInputStruct());
          ccmn02ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
          CCMN02UIG00 ccmn02uig00 = new CCMN02UIG00();
          ccmn02uig00.setUlIdStage(idStage_ccmn35si);

          ccmn02uig00.setSzCdStage(cdStage_ccmn35si);
          ccmn02uig00.setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
          ccmn02uig00.setSzCdStageReasonClosed(capsResource_cses41d.getCdRsrcClosureRsn());
          ccmn02ui.setCCMN02UIG00(ccmn02uig00);
          // Call CloseStageCase
          closeStageCase.closeStageCase(ccmn02ui);
          // STGAP00014928: Send the alert to the SAU after the call to close the stage/case
          // so that it doesn't get deleted
          if (WIN_COMPAPRV.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
            // Send alert to Regional Adoption Assistance Consultants when a home with a status of 'Closed' 
            // and a Change Reason of 'Adoption Finalized With Subsidies' has been saved
            if (CodesTables.CFACLOSE_AFS.equals(capsResource_cses41d.getCdRsrcClosureRsn())){
              sendAlertClosedHomeAdoptionFinalReceivingSubsidies(idCase_ccmn35si, idStage_ccmn35si);
            }
          }
        }

        //STGAP00012200: This logic updates the app status to approved
        // and sets the approved date to the current date
        if (FOST_HOME_CONV_TASK.equals(cdTask)) {
          fosterHomeConvDAO.updateFosterHomeConv(idEvent, CodesTables.CFHCSTTS_APR, new Date());
        }
        
        if (FA_HOME_RVF.equals(cdTask)) {
          if (WIN_APPROVE.equals(ccmn35si.getSzWcdCdAprvlWinaction())) {
            // Generate a Todo by calling CSUB40U
            CSUB40UI csub40ui = new CSUB40UI();
            csub40ui.setArchInputStruct(ccmn35si.getArchInputStruct());
            CSUB40UIG00 csub40uig00 = new CSUB40UIG00();
            // Set CSUB40UI CdTodoCf to TODO_UPDATE_STATUS
            csub40uig00.setSzSysCdTodoCf(TODO_UPDATE_STATUS);
            // Set CSUB40UI DtTodoCfDueFrom to NULL_DATE
            csub40uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(new Date()));
            // Set IdTodoCfPersCreator to CCCMN35SI IdPerson
            csub40uig00.setUlSysIdTodoCfPersCrea(ccmn35si.getUlIdPerson());
            // Set IdTodoCfEvent to CCMN01U IdEvent
            csub40uig00.setUlSysIdTodoCfEvent(idEvent_ccmn01uo);
            // Set IdTodoCfStage to CFAD35SI IdStage
            csub40uig00.setUlSysIdTodoCfStage(idStage_ccmn35si);
            csub40ui.setCSUB40UIG00(csub40uig00);
            todoCommonFunction.audTodo(csub40ui);
          }
        }
        
        //send alerts if adoption assistance application approved
        //check on approval code
        // SMS#97845 MR-074-2 AFCARS: add PAD stage validation
        if(ADO_ASSIST_APP_TASK.equals(cdTask) || PAD_ADO_ASSIST_APP_TASK.equals(cdTask)) {
        	SpecialNeedsDetermination spd = specialNeedsDeterminationDAO.findSpecialNeedsDeterminationByIdEvent(idEvent);
        	if(spd.getIndSpcNeedsApproved()!= null && spd.getIndSpcNeedsApproved().equals("Y")){
        	// SMS#97845 MR-074-2 AFCARS: add parameter spd and cdTask to determine whether the application being approved is for
        	// non-incident PAD and send alert to remind CM and supervisor to complete the Non-Incident AFCARS Information 
        		sendAlertsforApprovedAdoptAssistanceApplication(ccmn35si, spd, cdTask);
        	}
        }
        
        //STGAP00014329: Sends the alert to the primary case worker and the unit supervisor when Safety resource is approved.
        if(SAFETY_RESOURCE_INV_TASK_CODE.equals(cdTask) || SAFETY_RESOURCE_ONG_TASK_CODE.equals(cdTask)) {
          sendAlertsforApprovedSafetyResource(ccmn35si, idEvent);
        }
        
      }
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    return ccmn35so;
  }

  private void processContractPeriodDate(ContractPeriod contractPeriod, Map<String, Object> contractRecord) {
    // Get the current date
    Calendar currentDate = Calendar.getInstance();
    currentDate.setTime(new Date());
    Calendar cnperTermDate = Calendar.getInstance();
    cnperTermDate.setTime(contractPeriod.getDtCnperTerm());
    boolean testBool = false;
    // Determine which stage we are coming from and if it is INVestigation or Family PReservation,
    // then we need to see if there is a Conclusion or Closure event and what the status is

    // If year is greater
    if (cnperTermDate.get(Calendar.YEAR) > currentDate.get(Calendar.YEAR)) {
      testBool = true;
    }
    // If years are equal and month is greater
    else if ((cnperTermDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR))
             && (cnperTermDate.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))) {
      testBool = true;
    }
    // If years and months are equal and day is greater
    else if ((cnperTermDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR))
             && (cnperTermDate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH))
             && (cnperTermDate.get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH))) {
      testBool = true;
    }
    // If year, month and day are equal
    else if ((cnperTermDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR))
             && (cnperTermDate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH))
             && (cnperTermDate.get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH))) {
      testBool = true;
    } else {
      testBool = false;
    }
    if (testBool) {
      if (!CONTRACT_STATUS_CLOSED.equals(contractPeriod.getCdCnperStatus())) {
        contractRecord.put("indContractCurrent", INDICATOR_YES);
      } else {
        contractRecord.put("indContractCurrent", INDICATOR_NO);
      }
    } else {
      contractRecord.put("indContractCurrent", INDICATOR_NO);
    }
  }

  private void contractVerSerCnty(CCMN35SI ccmn35si, int idContract, int nbrCnperPeriod, int idResource)
                                                                                                        throws ServiceException {
    // int localAdoptOrFoster = 0;
    double localNumberOfDays = 0;
    boolean deleteInsertContractCounty = true;
    boolean isFoster = true;
    String tmpContractCounty = null;
    // String adoptiveOrFoster = null;
    // boolean isGroupHome = false;
    // Get current date
    Date currentDate = new Date();
    // Subtract one day from today's date
    Date minusOneDay = DateHelper.addToDate(currentDate, 0, 0, -1);

    // Call CSES01D - Contract Version retrieve for an idContract
    ContractVersion latestVersion = contractVersionDAO.findLatestContractVersion(idContract, nbrCnperPeriod);
    if (latestVersion == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Date oldDtCnverEnd = latestVersion.getDtCnverEnd();
    latestVersion.setDtCnverEnd(minusOneDay);
    localNumberOfDays = DateHelper.minutesDifference(currentDate, latestVersion.getDtCnverEffective());
    // if current date is only 2 days different from Eff date, then don't update contract_version
    // and contract-county tables There are 1440 Minutes in One Day
    if ((localNumberOfDays / 1440) <= 2) {
      deleteInsertContractCounty = false;
    }

    ContractVersion newContractVersion = new ContractVersion();
    // i=0 for Update, i=1 for Add function
    for (int i = 0; i < 2 && deleteInsertContractCounty; i++) {
      if (i == 1) {
        // SMS#106562: Instantiate new reference object instead of reuse previous
        // reference to latest version which causes hibernate exception due
        // to change to existing record primary key.
        newContractVersion.setIndCnverVerLock(INDICATOR_YES);
        newContractVersion.setDtCnverEnd(oldDtCnverEnd);
        newContractVersion.setDtCnverEffective(currentDate);
        newContractVersion.setDtLastUpdate(currentDate);
        newContractVersion.setTxtCnverComment("");
        newContractVersion.setNbrCnverVersion(latestVersion.getNbrCnverVersion() + 1);
        newContractVersion.setPerson(latestVersion.getPerson());
        newContractVersion.setContractPeriod(latestVersion.getContractPeriod());
        newContractVersion.setDtCnverCreate(currentDate);
        newContractVersion.setIdCnver(0);
        contractVersionDAO.saveContractVersion(newContractVersion);
      }else{
        // Call CAUD15D
        contractVersionDAO.saveContractVersion(latestVersion);
      }
    }
    List<ContractService> contractServices = null;
    if (deleteInsertContractCounty) {
      // Call CLSS13D
      contractServices = contractServiceDAO.findConSvcByIdConAndNbrCnsvcPeriodMaxAndNbrCnsvcVersionMax(idContract);
      if (contractServices == null || contractServices.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      List<CodeAttributes> codeAttributesList;
      ContractService first_contractService = contractServices.get(0);
      ContractService addContractService = new ContractService();
      try {
        int iCount = 0;
        double unitRate = 0.0;
        codeAttributesList = Lookup.getCategoryCollection(CodesTables.CFOSSVCD);
        // loop through to save services using the service type passed in
        for (Iterator<CodeAttributes> servicesIter = codeAttributesList.iterator(); servicesIter.hasNext();) {
          CodeAttributes codeAttributes = servicesIter.next();
          addContractService.setContract(first_contractService.getContract());
          addContractService.setNbrCnsvcVersion(first_contractService.getNbrCnsvcVersion() + 1);
          addContractService.setNbrCnsvcPeriod(first_contractService.getNbrCnsvcPeriod());
          addContractService.setNbrCnsvcLineItem(iCount + 1);
          addContractService.setCdCnsvcService(Lookup.simpleDecodeSafe(CodesTables.CFOSSVCD, codeAttributes.getCode()));
          unitRate = Double.parseDouble(Lookup.simpleDecodeSafe(CodesTables.CFOSUTRT, codeAttributes.getCode()));
          addContractService.setNbrCnsvcUnitRate(unitRate);
          addContractService.setCdCnsvcPaymentType(first_contractService.getCdCnsvcPaymentType());
          addContractService.setIndCnsvcNewRow(first_contractService.getIndCnsvcNewRow());
          addContractService.setCdCnsvcUnitType(first_contractService.getCdCnsvcUnitType());
          addContractService.setNbrCnsvcFedMatch(first_contractService.getNbrCnsvcFedMatch());
          addContractService.setNbrCnsvcLocalMatch(first_contractService.getNbrCnsvcLocalMatch());
          addContractService.setAmtCnsvcAdminAllUsed(first_contractService.getAmtCnsvcAdminAllUsed());
          addContractService.setAmtCnsvcEquip(first_contractService.getAmtCnsvcEquip());
          addContractService.setAmtCnsvcEquipUsed(first_contractService.getAmtCnsvcEquipUsed());
          addContractService.setAmtCnsvcFrgBenft(first_contractService.getAmtCnsvcFrgBenft());
          addContractService.setAmtCnsvcFrgBenftUsed(first_contractService.getAmtCnsvcFrgBenftUsed());
          addContractService.setAmtCnsvcOffItemUsed(first_contractService.getAmtCnsvcOffItemUsed());
          addContractService.setAmtCnsvcOther(first_contractService.getAmtCnsvcOther());
          addContractService.setAmtCnsvcOtherUsed(first_contractService.getAmtCnsvcOtherUsed());
          addContractService.setAmtCnsvcSalary(first_contractService.getAmtCnsvcSalary());
          addContractService.setAmtCnsvcSalaryUsed(first_contractService.getAmtCnsvcSalaryUsed());
          addContractService.setAmtCnsvcSupply(first_contractService.getAmtCnsvcSupply());
          addContractService.setAmtCnsvcSupplyUsed(first_contractService.getAmtCnsvcSupplyUsed());
          addContractService.setAmtCnsvcTravel(first_contractService.getAmtCnsvcTravel());
          addContractService.setAmtCnsvcTravelUsed(first_contractService.getAmtCnsvcTravelUsed());
          addContractService.setAmtCnsvcUnitRate(first_contractService.getAmtCnsvcUnitRate());
          addContractService.setAmtCnsvcUnitRateUsed(first_contractService.getAmtCnsvcUnitRateUsed());
          addContractService.setDtLastUpdate(currentDate);
          addContractService.setPerson(first_contractService.getPerson());
          // The Contract Service AUD performs a full row insert to the Contract Service table.
          // Hibernate will handle any exception thrown during processing
          // Call CAUD17D. The Contract Service AUD performs a full row insert to the Contract Service table.
          contractServiceDAO.saveContractService(addContractService);
          // increment counter
          iCount++;
        }
      } catch (LookupException e) {
        // In an ideal world, this would not be the exception thrown, but to match the existing service, use it.
        throw new ServiceException(Messages.SQL_NOT_FOUND, e);
      }
    }
    // Call CRES04D
    CapsResource resource_cres04d = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    // localAdoptOrFoster = 0;
    if (resource_cres04d == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    if (!(FA_CATG_ADOPT.equals(resource_cres04d.getCdRsrcCategory()) || FA_CATG_REL_ADOPT
                                                                                         .equals(resource_cres04d
                                                                                                                 .getCdRsrcCategory()))) {
      isFoster = false;
    }

    tmpContractCounty = resource_cres04d.getCdRsrcCnty();

    // Call CLSS68D
    List<ContractCounty> contractCounties = contractCountyDAO
                                                             .findContractCountyByIdContactVersionAndPeriod(
                                                                                                            idContract,
                                                                                                            nbrCnperPeriod,
                                                                                                            latestVersion
                                                                                                                         .getNbrCnverVersion());
    // Update the selected records from previous DAO
    if ((!deleteInsertContractCounty) && (contractCounties != null && !contractCounties.isEmpty())) {
      for (Iterator<ContractCounty> contractCounties_it = contractCounties.iterator(); contractCounties_it.hasNext();) {
        ContractCounty deleteContractCounty = contractCounties_it.next();
        // Call CAUD08D
        int numRowsDeleted = contractCountyDAO.deleteContractCounty(deleteContractCounty.getDtLastUpdate(),
                                                                    deleteContractCounty.getIdCncnty());
        if (numRowsDeleted == 0) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
    } else {
      for (Iterator<ContractCounty> contractCounties_it = contractCounties.iterator(); contractCounties_it.hasNext();) {
        ContractCounty updateContractCounty = contractCounties_it.next();
        // Every field stays the same except the End Date is being set to today's date
        updateContractCounty.setDtCncntyEnd(currentDate);
        // Hibernate will handle any exception thrown during the processing of this call
        contractCountyDAO.saveContractCounty(updateContractCounty);
      }
    }
    // Insert new records into Contract_County
    if (isFoster) {

      List<CodeAttributes> codeAttributesList;
      try {
        int rowCounter = 0;
        codeAttributesList = Lookup.getCategoryCollection(CodesTables.CFOSSVCD);
        // loop through to save services using the service type passed in
        for (Iterator<CodeAttributes> servicesIter = codeAttributesList.iterator(); servicesIter.hasNext();) {
          CodeAttributes codeAttributes = servicesIter.next();

          ContractCounty addContractCounty = new ContractCounty();
          if (!deleteInsertContractCounty) {
            addContractCounty.setNbrCncntyVersion(latestVersion.getNbrCnverVersion());
          } else {
            addContractCounty.setNbrCncntyVersion(latestVersion.getNbrCnverVersion() + 1);
          }
          addContractCounty.setCdCncntyCounty(tmpContractCounty);
          addContractCounty.setDtLastUpdate(latestVersion.getDtLastUpdate());
          Contract contract = getPersistentObject(Contract.class, idContract);
          addContractCounty.setContract(contract);
          addContractCounty.setCapsResource(resource_cres04d);
          // Do not see these fields in the Contract Version object
          // addContractCounty.setTmScrTmGeneric1(latestVersion.get TmScrTmGeneric1());
          // addContractCounty.setTmScrTmGeneric2(latestVersion.getTmScrTmGeneric2());
          addContractCounty.setDtCncntyEffective(currentDate);
          addContractCounty.setDtCncntyEnd(latestVersion.getDtCnverEnd());
          addContractCounty.setNbrCncntyLineItem(rowCounter + 1);
          addContractCounty.setCdCncntyService(Lookup.simpleDecodeSafe(CodesTables.CFOSSVCD, codeAttributes.getCode()));
          contractCountyDAO.saveContractCounty(addContractCounty);
          // increment row counter
          rowCounter++;
        }
      } catch (LookupException e) {
        // In an ideal world, this would not be the exception thrown, but to match the existing service, use it.
        throw new ServiceException(Messages.SQL_NOT_FOUND, e);
      }
    }
  }

  private boolean checkCatHomeType(CCMN35SI ccmn35si, int idResource) throws ServiceException {

    boolean catHome = false;

    // Call CRES04D
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    if (capsResource == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // SMS#?: There is no guarantee of the order in which home type is retrieved
    // best to check if both collections contains all elements of each other.
    List<String> capsResourceFaHomeTypes = new ArrayList<String>();
    
    if( capsResource.getCdRsrcFaHomeType1() != null )
      capsResourceFaHomeTypes.add(capsResource.getCdRsrcFaHomeType1());
    if( capsResource.getCdRsrcFaHomeType2() != null )
      capsResourceFaHomeTypes.add(capsResource.getCdRsrcFaHomeType2());
    if( capsResource.getCdRsrcFaHomeType3() != null )
      capsResourceFaHomeTypes.add(capsResource.getCdRsrcFaHomeType3());
    if( capsResource.getCdRsrcFaHomeType4() != null )
      capsResourceFaHomeTypes.add(capsResource.getCdRsrcFaHomeType4());
    if( capsResource.getCdRsrcFaHomeType5() != null )
      capsResourceFaHomeTypes.add(capsResource.getCdRsrcFaHomeType5());
    if( capsResource.getCdRsrcFaHomeType6() != null )
      capsResourceFaHomeTypes.add(capsResource.getCdRsrcFaHomeType6());
    if( capsResource.getCdRsrcFaHomeType7() != null )
      capsResourceFaHomeTypes.add(capsResource.getCdRsrcFaHomeType7());
    
    String categoryHomeType1 = capsResource.getCdRsrcCategory();

    // Call CLSS82D
    List<ResourceHistoryAudit> resourceHistoryAudits = resourceHistoryAuditDAO
                                                                              .findResourceHistoryAuditByIdResource(idResource);
    if (resourceHistoryAudits == null || resourceHistoryAudits.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    List<String> rsrcHistoryAudFaHomeTypes = new ArrayList<String>();
    
    if( resourceHistoryAudits.get(0).getCdRshsAudFaHomeType1() != null )
      rsrcHistoryAudFaHomeTypes.add(resourceHistoryAudits.get(0).getCdRshsAudFaHomeType1());
    if( resourceHistoryAudits.get(0).getCdRshsAudFaHomeType2() != null )
      rsrcHistoryAudFaHomeTypes.add(resourceHistoryAudits.get(0).getCdRshsAudFaHomeType2());
    if( resourceHistoryAudits.get(0).getCdRshsAudFaHomeType3() != null )
      rsrcHistoryAudFaHomeTypes.add(resourceHistoryAudits.get(0).getCdRshsAudFaHomeType3());
    if( resourceHistoryAudits.get(0).getCdRshsAudFaHomeType4() != null )
      rsrcHistoryAudFaHomeTypes.add(resourceHistoryAudits.get(0).getCdRshsAudFaHomeType4());
    if( resourceHistoryAudits.get(0).getCdRshsAudFaHomeType5() != null )
      rsrcHistoryAudFaHomeTypes.add(resourceHistoryAudits.get(0).getCdRshsAudFaHomeType5());
    if( resourceHistoryAudits.get(0).getCdRshsAudFaHomeType6() != null )
      rsrcHistoryAudFaHomeTypes.add(resourceHistoryAudits.get(0).getCdRshsAudFaHomeType6());
    if( resourceHistoryAudits.get(0).getCdRshsAudFaHomeType7() != null )
      rsrcHistoryAudFaHomeTypes.add(resourceHistoryAudits.get(0).getCdRshsAudFaHomeType7());
    
    String categoryHomeType2 = resourceHistoryAudits.get(0).getCdRshsAudCategory();

    if (categoryHomeType2.equals(categoryHomeType1)
                    && capsResourceFaHomeTypes.containsAll(rsrcHistoryAudFaHomeTypes)
                    && rsrcHistoryAudFaHomeTypes.containsAll(capsResourceFaHomeTypes)) {
      catHome = true;
    }
    return catHome;
  }

  private Todo createTodo(int idPerson, int idStage, int idCase, String cdTask) {

    Todo todo = new Todo();
    Person person = getPersistentObject(Person.class, idPerson);
    Stage stage = getPersistentObject(Stage.class, idStage);
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    todo.setCdTodoType(TODO_ALERT);
    todo.setDtTodoCreated(new Date());
    todo.setDtTodoCompleted(new Date());
    todo.setDtTodoDue(new Date());
    todo.setDtTodoTaskDue(null);
    todo.setCapsCase(capsCase);
    todo.setPersonByIdTodoPersAssigned(person);
    todo.setPersonByIdTodoPersWorker(person);
    todo.setStage(stage);
    todo.setCdTodoTask(cdTask);
    return todo;
  }

  private void audEvent(ROWCCMN01UIG00 rowccmn01uig00, String cReqFuncCd) throws ServiceException {
    int idEvent = rowccmn01uig00.getUlIdEvent();
    int idPerson = rowccmn01uig00.getUlIdPerson();
    int idStage = rowccmn01uig00.getUlIdStage();
    Date dtEventOccurred = DateHelper.toJavaDate(rowccmn01uig00.getDtDtEventOccurred());
    Date dtLastUpdate = rowccmn01uig00.getTsLastUpdate();
    String cdEventStatus = rowccmn01uig00.getSzCdEventStatus();
    String cdTask = rowccmn01uig00.getSzCdTask();
    String cdEventType = rowccmn01uig00.getSzCdEventType();
    String txtEventDescr = rowccmn01uig00.getSzTxtEventDescr();

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // ccmn46d
      complexEventDAO
                     .insertEvent(cdEventStatus, cdEventType, dtEventOccurred, idPerson, idStage, txtEventDescr, cdTask);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // call CCMN46D
      int nbrRowsUpdated = complexEventDAO.updateEventByIdEventDtLastUpdate(cdEventStatus, cdEventType,
                                                                            dtEventOccurred, idPerson, idStage,
                                                                            txtEventDescr, cdTask, idEvent,
                                                                            dtLastUpdate);
      if (nbrRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // ccmn46d
      eventDAO.deleteEvent(idEvent, dtLastUpdate);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  private void audApprovers(ROWCCMN61DI rowccmn61di, String cReqFuncCd) throws ServiceException {
    Date dtApproversDetermination = new Date();
    String tmScrTmApprovalTime = rowccmn61di.getTmScrTmApprovalTime();
    try {
      dtApproversDetermination = DateHelper
                                           .toJavaDate(rowccmn61di.getDtDtApproversDetermination(), tmScrTmApprovalTime);
    } catch (ParseException e) {
      // do nothing
    }
    int idPerson = rowccmn61di.getUlIdPerson();
    String cdApproversStatus = rowccmn61di.getSzCdApproversStatus();
    String txtApproversComments = rowccmn61di.getSzTxtApproversComments();
    int idApprovers = rowccmn61di.getUlIdApprovers();
    Date dtLastUpdate = rowccmn61di.getTsLastUpdate();

    // call ccmn61d
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // do nothing
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // Call CCMN61D
      int nbrRowsUpdated = approversDAO.updateApproversByIdApproversAndDtLastUpdate(idPerson, cdApproversStatus,
                                                                                    txtApproversComments, idApprovers,
                                                                                    dtApproversDetermination,
                                                                                    dtLastUpdate);
      if (nbrRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // do nothing
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  private void saveApprovalRejection(ROWCCMNI2DI rowccmni2di, int ulIdApproval) {

    ApprovalRejection approvalRejection = new ApprovalRejection();
    // Approval approval = new Approval();
    CapsCase capsCase = getPersistentObject(CapsCase.class, rowccmni2di.getUlIdCase());
    Stage stage = getPersistentObject(Stage.class, rowccmni2di.getUlIdStage());
    Person person = getPersistentObject(Person.class, rowccmni2di.getUlIdRejector());
    Date dtRejection = DateHelper.toJavaDate(rowccmni2di.getDtDtRejection());
    Approval approval = getPersistentObject(Approval.class, ulIdApproval);
    approvalRejection.setPerson(person);
    approvalRejection.setApproval(approval);
    approvalRejection.setCapsCase(capsCase);
    approvalRejection.setStage(stage);
    approvalRejection.setDtRejection(dtRejection);
    approvalRejection.setIndApsEffort(rowccmni2di.getBIndApsEffort());
    // FYI BIndCareEntered not used in DAO.
    // approvalRejection.set indCareEntered = rowccmni2di.getBIndCareEntered();
    approvalRejection.setIndEvidence(rowccmni2di.getBIndEvidence());
    approvalRejection.setIndMissingEvidRptr(rowccmni2di.getBIndMissingEvidRptr());
    approvalRejection.setIndMissingEvidAp(rowccmni2di.getBIndMissingEvidAp());
    approvalRejection.setIndMissingEvidMp(rowccmni2di.getBIndMissingEvidMp());
    approvalRejection.setIndMissingEvidCol(rowccmni2di.getBIndMissingEvidCl());
    approvalRejection.setIndMissingEvidPhotos(rowccmni2di.getBIndMissingEvidPhoto());

    // Function Prototypes
    approvalRejection.setIndMissingEvidDe(rowccmni2di.getBIndMissingEvidDe());
    approvalRejection.setIndMissingEvidOth(rowccmni2di.getBIndMissingEvidOther());
    approvalRejection.setIndDiscretionary(rowccmni2di.getBIndDiscretionaryReason());
    // FYI SzNMRejector not used in DAM.
    // approvalRejection.set nMRejector = rowccmni2di.getSzNMRejector();
    approvalRejection.setTxtApproversCmnts(rowccmni2di.getSzTxtApproversComments());

    // ccmn12d
    approvalRejectionDAO.saveApprovalRejection(approvalRejection);
    // STGAP00007443: This will display the IntakeSummary Status field to Open for rejected Intake
    if (INTAKE.equals(stage.getCdStage())) {
      incomingDetailDAO.updateIncomingDetail(CodesTables.CINCMGST_OPN, stage.getIdStage(), stage.getDtLastUpdate());
    }
  }

  private void updateApproversStatus(int idApproval, String cReqFuncCd) throws ServiceException {

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // do nothing
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // CallCCMN88D
      approversDAO.updateCdApproversStatusByIdApproval(idApproval);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // do nothing
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  private void updateEvent(List<Map> approvalEventLinkList, String cReqFuncCd, String wcdCdAprvlWinaction)
                                                                                                          throws ServiceException {

    String cdEventStatus;
    if (WIN_COMPAPRV.equals(wcdCdAprvlWinaction)) {
      cdEventStatus = EVENT_STATUS_APRV;
    } else if (WIN_REJECT.equals(wcdCdAprvlWinaction)) {
      cdEventStatus = CodesTables.CEVTSTAT_PROC;
    } else {
      cdEventStatus = EVT_COMP;
    }

    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // Loop through the returned list of ID EVENTS from
      // CCMN57D executing the CCMN62D AUD type DAM to update
      // the event status for each to either Completed or
      // Approved based upon what was accomplished on the window.
      for (Iterator<Map> it = approvalEventLinkList.iterator(); it.hasNext();) {
        Map approvalEventLinkMap = it.next();
        int idEvent = (Integer) approvalEventLinkMap.get("idEvent");

        Event event = eventDAO.findEventByIdEvent(idEvent);
        String cdEventType = event.getCdEventType();
        String txtDescription = event.getTxtEventDescr();

        /*
         * The following set of conditions look at event type and may update the event in a special way.
         */

        // Special Needs Determination/Adoption Assistance Application
        if ((EVENT_STATUS_APRV.equals(cdEventStatus) || CodesTables.CEVTSTAT_PROC.equals(cdEventStatus))
            && CodesTables.CEVNTTYP_SND.equals(cdEventType)) {
          txtDescription = generateSpecialNeedsEventDescription(idEvent, cdEventStatus);
        }
        
        // Adoption Assistance Agreement
        if ((EVENT_STATUS_APRV.equals(cdEventStatus) || CodesTables.CEVTSTAT_PROC.equals(cdEventStatus))
                        && CodesTables.CEVNTTYP_ADP.equals(cdEventType)) {
                      txtDescription = generateAdopAssitanceEventDescription(idEvent, cdEventStatus);
         }

        // Contact Standards
        if ((EVENT_STATUS_APRV.equals(cdEventStatus) || CodesTables.CEVTSTAT_PROC.equals(cdEventStatus))
                        && CodesTables.CEVNTTYP_CSS.equals(cdEventType)) {
                      txtDescription = generateContactStandardsEventDescription(idEvent, cdEventStatus);
         }
        
        // Special Investigation
        if ((EVENT_STATUS_APRV.equals(cdEventStatus) || CodesTables.CEVTSTAT_PROC.equals(cdEventStatus))
                        && CodesTables.CEVNTTYP_SPI.equals(cdEventType)) {
                      txtDescription = generateSpclInvestigationEventDescription(idEvent, cdEventStatus);
         } 
        
        
        if (CodesTables.CEVNTTYP_PLA.equals(cdEventType) && WIN_REJECT.equals(wcdCdAprvlWinaction)) {
          cdEventStatus = EVT_COMP;
        }
        int nbrRowsUpdated = eventDAO.updateEvent(cdEventStatus, cdEventType, event.getPerson() != null ? event.getPerson().getIdPerson() : 0,
                                                  event.getStage().getIdStage(), txtDescription, event.getCdTask(),
                                                  idEvent, event.getDtLastUpdate());
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      }
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  private List<Map> findRelatedEvents(int idApproval) throws ServiceException {
    // CallCCMN57D
    List<Map> approvalEventLinkList = approvalEventLinkDAO.findRelatedFunctionalEventsForGivenApproval(idApproval);

    if (approvalEventLinkList == null || approvalEventLinkList.size() == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return approvalEventLinkList;
  }

  private CapsResource findCapsResource(int idResource) throws ServiceException {

    // call CRES04D
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    if (capsResource == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return capsResource;

  }

  /*
   * private String getAdoptiveOrFoster(CapsResource capsResource) { // String adoptiveOrFoster = ""; StringBuffer
   * tempHomeType = new StringBuffer();
   * 
   * tempHomeType.append(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType1()));
   * tempHomeType.append(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType2()));
   * tempHomeType.append(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType3()));
   * tempHomeType.append(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType4()));
   * tempHomeType.append(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType5()));
   * tempHomeType.append(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType6())); //
   * tempHomeType.append(capsResource.getCdRsrcFaHomeType7()); return tempHomeType.toString(); }
   * 
   * private List getAdoptiveOrFosterList(CapsResource capsResource) { List<String> homeTypeList = new ArrayList<String>();
   * homeTypeList.add(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType1()));
   * homeTypeList.add(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType2()));
   * homeTypeList.add(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType3()));
   * homeTypeList.add(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType4()));
   * homeTypeList.add(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType5()));
   * homeTypeList.add(StringHelper.getNonNullString(capsResource.getCdRsrcFaHomeType6()));
   * 
   * return homeTypeList; }
   */

  private void updateCapsResource(CapsResource capsResource, String cdRsrcFaHomeStatus, String cReqFuncCd)
                                                                                                          throws ServiceException {

    // CAUD52D
    int nbrRowsUpdated = capsResourceDAO.updateCapsResource(capsResource.getIdResource(), cdRsrcFaHomeStatus,
                                                            capsResource.getCdRsrcStatus(),
                                                            capsResource.getDtLastUpdate());
    if (nbrRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

  private CapsCase findCapsCase(Todo todo) throws ServiceException {

    int idCase = todo.getCapsCase().getIdCase();
    // Call CallCCMNC5D retrieve the Case Name
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    if (capsCase == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    return capsCase;
  }

  /*
   * private void updateChildPlan(ChildPlan childPlan, int idEvent, Date dtTodoDue) throws ServiceException {
   * 
   * Date dtLastUpdate = childPlan.getDtLastUpdate(); int idPerson = childPlan.getPerson().getIdPerson(); String
   * cdCspPlanPermGoal = childPlan.getCdCspPlanPermGoal(); String cdCspPlanType = childPlan.getCdCspPlanType(); Date
   * dtCspPermGoalTarget = childPlan.getDtCspPermGoalTarget(); // String tmScrTmGeneric1 =
   * FormattingHelper.formatTime(childPlan.getDtCspPermGoalTarget()); // String tmScrTmGeneric2 =
   * FormattingHelper.formatTime(dtTodoDue); String txtCspLengthOfStay = childPlan.getTxtCspLengthOfStay(); String
   * txtCspLosDiscrepancy = childPlan.getTxtCspLosDiscrepancy(); String txtCspParticipComment =
   * childPlan.getTxtCspParticipComment(); Date dtCspPlanCompleted = childPlan.getDtCspPlanCompleted(); // caud25d int
   * nbrRowsUpdated = childPlanDAO.updateChildPlan(idEvent, idPerson, cdCspPlanPermGoal, cdCspPlanType,
   * dtCspPermGoalTarget, dtTodoDue, txtCspLengthOfStay, txtCspLosDiscrepancy, txtCspParticipComment,
   * dtCspPlanCompleted, dtLastUpdate); if (nbrRowsUpdated == 0) { throw new
   * ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH); } }
   */
  // STGAP00007159: changed the signature of the method - added case manger's county as another parameter.
  private void sendToDoforChildDeathAndSeriousInjury(String cdRegion, String cdCounty, CCMN35SI ccmn35si) {
    List<String> cdEmployeeClassList = new ArrayList<String>();
    // STGAP00007159 - Modified code to add new profiles to send the alerts to, and changed the SQL to look up
    // for data in appropriate tables.
    // cdEmployeeClassList.add(CodesTables.CEMPJBCL_G1022);// Deputy Director Program Planning and Policy Development
    cdEmployeeClassList.add(CodesTables.CEMPJBCL_G1006);// Regional Director
    // STGAP00017922: Added CodesTables.CEMPJBCL_14074 to the list to send the alert to the Field Program Specialist
    cdEmployeeClassList.add(CodesTables.CEMPJBCL_14074);// Field Program Specialist
    List<Integer> employeeList = employeeDAO.findIdPersonByCdRegionAndCdEmpClass(cdRegion, cdEmployeeClassList);
    cdEmployeeClassList = new ArrayList<String>();
    cdEmployeeClassList.add(CodesTables.CEMPJBCL_14037);// County Director
    cdEmployeeClassList.add(CodesTables.CEMPJBCL_14202);// Social Services Administrator
    List<Integer> cntyEmpIdList = employeeDAO.findIdPersonBycdCountyAndCdEmpClass(cdCounty, cdEmployeeClassList);
    if (cntyEmpIdList != null && cntyEmpIdList.size() != 0) {
      if (employeeList == null) {
        employeeList = new ArrayList<Integer>();
      }
      employeeList.addAll(cntyEmpIdList);
    }
    // STGAP00007525: Added this SQL call to send the alert to the Deputy Director Program Planning and Policy
    // Development
    // irrespective of region
    // CodesTables.CEMPJBCL_G1022 - Deputy Director Program Planning and Policy Development
    List<Integer> depDirectorList = employeeDAO.findIdPersonByAndCdEmpClass(CodesTables.CEMPJBCL_G1022);
    if (depDirectorList != null && depDirectorList.size() != 0) {
      employeeList.addAll(depDirectorList);
    }
    // STGAP00017922: Added this SQL call to send the alert to all the staff with the profile CDNFSI_ALERT
    List<Integer> cdnfsiAlertRecepientsList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(CDNFSI_ALERT_PROFILE);
    if (listIsValid(cdnfsiAlertRecepientsList)) {
      employeeList.addAll(cdnfsiAlertRecepientsList);
    }
    Set<Integer> set = new HashSet<Integer>(employeeList);
    List<Integer> uniqueEmployeeList = new ArrayList<Integer>(set);

    for (Iterator it = uniqueEmployeeList.iterator(); it.hasNext();) {
      Integer idEmployee = (Integer) it.next();
      if (idEmployee != null) {
        Todo todo = createTodo(ccmn35si.getUlIdPerson(), ccmn35si.getUlIdStage(), ccmn35si.getUlIdCase(),
                               ccmn35si.getSzCdTask());
        if (APPROVE_CALL_CD_TASK_CHILD_DEATH.equals(todo.getCdTodoTask())) {
          todo.setTxtTodoDesc(APR_CHILD_DEATH);
        } else if (APPROVE_CALL_CD_TASK_SERIOUS_INJURY.equals(todo.getCdTodoTask())) {
          todo.setTxtTodoDesc(APR_SERIOUS_INJURY);
        } else if (APPROVE_CALL_CD_TASK_NEAR_FATALITY.equals(todo.getCdTodoTask())){ //STGAP00017922: Alert needs to go for Near Fatality Intake
          todo.setTxtTodoDesc(APR_NEAR_FATALITY);
        }
        todo.setCdTodoTask("");
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
        todoDAO.saveTodo(todo);
      }
    }
  }

  private void sendAlertforInvestigationConclusion(String cdCounty, CCMN35SI ccmn35si) {

    ArrayList<String> jobList = new ArrayList<String>();
    // modified code to pull back list of County Directors
    jobList.add(CodesTables.CEMPJBCL_14037);// County Director
    List<Integer> countyDirectorsList = employeeDAO.findIdPersonBycdCountyAndCdEmpClass(cdCounty, jobList);
    for (Iterator it = countyDirectorsList.iterator(); it.hasNext();) {
      Integer idCountyDirectors = (Integer) it.next();
      Todo todoCountyDirectors = createTodo(ccmn35si.getUlIdPerson(), ccmn35si.getUlIdStage(), ccmn35si.getUlIdCase(),
                                            ccmn35si.getSzCdTask());
      todoCountyDirectors.setCdTodoTask("");
      todoCountyDirectors.setCdTodoType(CodesTables.CTODOTYP_A);

      Integer idCase = null;
      CapsCase capsCase = todoCountyDirectors.getCapsCase();
      if (capsCase != null) {
        idCase = capsCase.getIdCase();
      }

      // Corey 6/22/2011 Capta 4.3 Realease - modified alert text
      String strAprCpsInvestLong = "Submit Case " + idCase + " review packet and/or Special Investigation page to Social Svcs Director in 10 days.";
      String strAprCpsInvest = "Submit Case review packet/Special Investigation in 10 days.";
      todoCountyDirectors.setTxtTodoDesc(strAprCpsInvest);
      todoCountyDirectors.setTxtTodoLongDesc(strAprCpsInvestLong);
      // Unrelated alert with case because when case is closed all alerts related to case are deleted; you don't want to
      // delete this alert even after the case is close
      todoCountyDirectors.setCapsCase(null);
      todoCountyDirectors.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idCountyDirectors));
      todoDAO.saveTodo(todoCountyDirectors);
    }

  }
  
  private void sendTaskforSpecialInvestigation(int idStage, CCMN35SI ccmn35si) { 
    
    Integer idCaseManagerObj = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_PR);
    
    Todo todo = new Todo();
    Person person = getPersistentObject(Person.class, idCaseManagerObj);
    Stage stage = getPersistentObject(Stage.class, idStage);
    CapsCase capsCase = getPersistentObject(CapsCase.class, ccmn35si.getUlIdCase());
    String caseName = capsCase.getNmCase();
    todo.setCdTodoType(CodesTables.CTODOTYP_T);
    todo.setDtTodoCreated(new Date());
    todo.setDtTodoDue(new Date());
    todo.setDtTodoTaskDue(null);
    todo.setCapsCase(capsCase);
    todo.setPersonByIdTodoPersAssigned(person);
    todo.setPersonByIdTodoPersWorker(person);
    todo.setStage(stage);
    todo.setCdTodoTask("2270");       

      String strAprCpsInvestLong = "Submit the county recommendation for (" + caseName + ") Special Investigation.";
      String strAprCpsInvest = "Submit the county recommendation for Special Investigation.";
      todo.setTxtTodoDesc(strAprCpsInvest);
      todo.setTxtTodoLongDesc(strAprCpsInvestLong);
      //todoTaskForCaseManager.setDtTodoCreated(dtTodoCreated);
      todoDAO.saveTodo(todo);
  }
  
  /**SMS#51977 MR-066 Send alert for special investigation in INV stage when CPS investigation Conclusion is approved
   * 
   * @param cdRegion
   * @param cdCounty
   * @param ccmn35si
   */

  private void sendToDoforSpecialInvestigation(String cdRegion, String cdCounty, CCMN35SI ccmn35si) {
    CpsInvstDetail cpsInvstDetail = new CpsInvstDetail();
    CapsResource capsResource = new CapsResource();
    int idEvent = ccmn35si.getUlIdEvent();
    if (idEvent != 0) {
      cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdEvent(idEvent);
    }
    Integer idResourceObj = null;
    int idResource = 0;
    int idStage = 0;
    int idHomeStage = 0;
    String cdRsrcFacilType = "";
    int idFADCaseManager = 0;
    int unitSupervisorFAD = 0;
    if (ServiceConstants.FND_YES.equals(cpsInvstDetail.getIndInvMaltreatInCare())
                    || ServiceConstants.FND_YES.equals(cpsInvstDetail.getIndPolicyViolation())
                    || ServiceConstants.FND_YES.equals(cpsInvstDetail.getIndSpeInvstPlaceProv())) {
    if(cpsInvstDetail.getStage() != null){
      idStage = cpsInvstDetail.getStage().getIdStage();
      IncomingFacility incomingFacility = incomingFacilityDAO.findIncomingFacilityByIdStage(idStage);
      if(incomingFacility != null){
        idResourceObj = incomingFacility.getCapsResource() != null ? incomingFacility.getCapsResource().getIdResource() : 0;
      }
    }
    
    if(idResourceObj == null){
      idResource = 0;
    }else{
      idResource = idResourceObj;
    }
    
    if(idResource != 0){
      capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);
      String nmResource = capsResource.getNmResource();
      if(capsResource.getStage() != null){
        idHomeStage = capsResource.getStage().getIdStage();
      }
      cdRsrcFacilType = capsResource.getCdRsrcFacilType();

      List<Integer> employeeList = new ArrayList<Integer>();

      if(idHomeStage != 0){
        //Get the primary case worker assigned to the FAD stage.
        idFADCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idHomeStage);

        //Get the unit supervisor of the primary case manager assigned to the FAD stage.
        Integer unitSupervisorObj = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idFADCaseManager);
        unitSupervisorFAD = unitSupervisorObj != null ? unitSupervisorObj : 0;
      }
      //Get the Case Managers of the Children placed in the Home
      List<Integer> caseManagersOfChildrenPlacedInResourceList = stagePersonLinkDAO.findStagePersonLinkByIdResource(idResource);
      List<Integer> supervisorOfCMOfChildrenPlacedInResourceList = new ArrayList<Integer>();
      if (caseManagersOfChildrenPlacedInResourceList != null && caseManagersOfChildrenPlacedInResourceList.size() != 0) {
        Iterator<Integer> iterCM = caseManagersOfChildrenPlacedInResourceList.iterator();
        while (iterCM.hasNext()) {
          Integer idCM = (Integer) iterCM.next();
          //Get the unit supervisor of the primary case manager assigned to the child's stage.
          Integer unitSupervisorCMChild = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCM);
          supervisorOfCMOfChildrenPlacedInResourceList.add(unitSupervisorCMChild);
        }

      }

      //County Director
      List<String> cdEmployeeClassList = new ArrayList<String>();
      cdEmployeeClassList.add(CodesTables.CEMPJBCL_14037);// County Director
      List<Integer> cntyEmpIdList = employeeDAO.findIdPersonBycdCountyAndCdEmpClass(cdCounty, cdEmployeeClassList);
      //PRU director
      List<Integer> pruDirectorList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(PRU_DIRECTOR_SECURITY_CLASS_NAME);

      /*If the Home is DFCS home then send the alert to the 
       1. Primary Case Manager of the FAD stage.
       2. Supervisor of the Case Manager of the FAD stage.
       3. Primary Case Managers of the Children placed in the Home.
       4. Supervisor of the Case Managers of the Children placed in the Home.
       5. County Director.
       6. Policy Specialist // STGAP00017979 Per design, Policy Specialist is removed from the alert
       */
      if( CodesTables.CFACTYP4_70.equals(cdRsrcFacilType)){
        if(idHomeStage != 0){
          employeeList.add(idFADCaseManager);     
          employeeList.add(unitSupervisorFAD); 
        }
        if(caseManagersOfChildrenPlacedInResourceList != null && caseManagersOfChildrenPlacedInResourceList.size() != 0 &&
                        supervisorOfCMOfChildrenPlacedInResourceList != null && supervisorOfCMOfChildrenPlacedInResourceList.size() != 0){
          employeeList.addAll(caseManagersOfChildrenPlacedInResourceList);
          employeeList.addAll(supervisorOfCMOfChildrenPlacedInResourceList);
        }
        if (cntyEmpIdList != null && cntyEmpIdList.size() != 0) {
          employeeList.addAll(cntyEmpIdList);
        }
      }
      /*If the Home is Non-DFCS home then send the alert to the 
       1. Primary Case Manager ofe  the FAD stage.
       2. Supervisor of thCase Manager of the FAD stage.
       3. Primary Case Managers of the Children placed in the Home.
       4. Supervisor of the Case Managers of the Children placed in the Home.
       5. County Director.
       6. PRU Director.
       7. Policy Specialist // STGAP00017979 Per design, Policy Specialist is removed from the alert
       */
      else if(CodesTables.CFACTYP4_71.equals(cdRsrcFacilType)){
        if(idHomeStage != 0){
          employeeList.add(idFADCaseManager);     
          employeeList.add(unitSupervisorFAD);
        }
        if(caseManagersOfChildrenPlacedInResourceList != null && caseManagersOfChildrenPlacedInResourceList.size() != 0 &&
                        supervisorOfCMOfChildrenPlacedInResourceList != null && supervisorOfCMOfChildrenPlacedInResourceList.size() != 0){
          employeeList.addAll(caseManagersOfChildrenPlacedInResourceList);
          employeeList.addAll(supervisorOfCMOfChildrenPlacedInResourceList);
        }
        if (cntyEmpIdList != null && cntyEmpIdList.size() != 0) {
          employeeList.addAll(cntyEmpIdList);
        }
        if (pruDirectorList != null && pruDirectorList.size() != 0) {
          employeeList.addAll(pruDirectorList);
        }
      }
      /*If the Home is CCI,Specialty Hospital, Maternity Home, Outdoor Therapeutic then send the alert to the 
        1. Primary Case Managers of the Children placed in the facility.
        2. Supervisor of the Case Managers of the Children placed in the facility.
        3. County Director.
        4. PRU Director.
        5. Policy Specialist // STGAP00017979 Per design, Policy Specialist is removed from the alert
       */
      else if(CodesTables.CFACTYP4_CC.equals(cdRsrcFacilType) ||
                      CodesTables.CFACTYP4_SH.equals(cdRsrcFacilType) ||CodesTables.CFACTYP4_MH.equals(cdRsrcFacilType)  ||
                      CodesTables.CFACTYP4_OT.equals(cdRsrcFacilType)){
        if(caseManagersOfChildrenPlacedInResourceList != null && caseManagersOfChildrenPlacedInResourceList.size() != 0 &&
                        supervisorOfCMOfChildrenPlacedInResourceList != null && supervisorOfCMOfChildrenPlacedInResourceList.size() != 0){
          employeeList.addAll(caseManagersOfChildrenPlacedInResourceList);
          employeeList.addAll(supervisorOfCMOfChildrenPlacedInResourceList);
        }
        if (cntyEmpIdList != null && cntyEmpIdList.size() != 0) {
          employeeList.addAll(cntyEmpIdList);
        }
        if (pruDirectorList != null && pruDirectorList.size() != 0) {
          employeeList.addAll(pruDirectorList);
        }
      }

      // Corey 6/22/2011 Capta 4.3 Release - removed resource truncation, modify alert message and added long description to todo
      // SMS 59029 Shortened the Alert Text  CPS_INVESTIGATION_ALERT_FOR_SPECIAL_INV
      //nmResource = (nmResource.length() > 27) ? nmResource.substring(0, 26) : nmResource;
      String alertText = "Special Investigation, MIC, or Policy Violation approved for a provider.";
      for (Iterator<Integer> it = employeeList.iterator(); it.hasNext();) {
        Integer idEmployee = (Integer) it.next();
        if (idEmployee != null) {
          Todo todo = createTodo(ccmn35si.getUlIdPerson(), ccmn35si.getUlIdStage(), ccmn35si.getUlIdCase(),
                                 ccmn35si.getSzCdTask());
          if (APPROVE_CPS_INVESTIGATION.equals(todo.getCdTodoTask()) && idResource != 0) {
            todo.setTxtTodoDesc(alertText);
          } 
          todo.setCdTodoTask("");
          todo.setCdTodoType(CodesTables.CTODOTYP_A);
          todo.setTxtTodoLongDesc("A Special Investigation, Maltreatment in Care, or Policy Violation on a Placement/Non-Placement provider has been reviewed and approved.");
          todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
          todoDAO.saveTodo(todo);
        }
      }
    }
  }
  }
  
  private void sendToDoforInvestigationCorrectiveActionPlanAndPolicyViolation(CCMN35SI ccmn35si) {
    CpsInvstDetail cpsInvstDetail = new CpsInvstDetail();
    CapsResource capsResource = new CapsResource();
    int idEvent = ccmn35si.getUlIdEvent();
    if (idEvent != 0) {
      cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdEvent(idEvent);
    }
    Integer idResourceObj = null;
    int idResource = 0;
    int idStage = 0;
    int idHomeStage = 0;
    int idFADCaseManager = 0;
    int idCaseManager = 0;
    if (ServiceConstants.FND_NO.equals(cpsInvstDetail.getIndInvMaltreatInCare())
        && ServiceConstants.FND_YES.equals(cpsInvstDetail.getIndPolicyViolation())) {
      List<Integer> employeeList = new ArrayList<Integer>();
      if (cpsInvstDetail.getStage() != null) {
        idStage = cpsInvstDetail.getStage().getIdStage();
        IncomingFacility incomingFacility = incomingFacilityDAO.findIncomingFacilityByIdStage(idStage);
        if (incomingFacility != null) {
          idResourceObj = incomingFacility.getCapsResource() != null ? incomingFacility.getCapsResource().getIdResource() : 0;
        }
        
        // Find the Primary Case Manager and add it to the list of persons that need to get the alert
        Integer idCaseManagerObj = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_PR);
        
        if(idCaseManagerObj != null){
          idCaseManager = idCaseManagerObj;
          employeeList.add(idCaseManager);
        }
        
        // Office of Provider Relations/State Resource Developer
        List<Integer> offcProvdrMaintList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(OFFICE_PROVIDER_MAINTENANCE);
        if (listIsValid(offcProvdrMaintList)) {
          employeeList.addAll(offcProvdrMaintList);
        }
        //PRU director
        List<Integer> pruDirectorList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(PRU_DIRECTOR_SECURITY_CLASS_NAME);
        if (listIsValid(pruDirectorList)) {
          employeeList.addAll(pruDirectorList);
        }
      }

      if (idResourceObj == null) {
        idResource = 0;
      } else {
        idResource = idResourceObj;
      }

      if (idResource != 0) {      
        capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);
        String nmResource = capsResource.getNmResource();
        
        // get the stage of the resource
        if(capsResource.getStage() != null){
          idHomeStage = capsResource.getStage().getIdStage();
        }
        if (idHomeStage != 0) {
          // Get the primary case worker assigned to the FAD stage.
          idFADCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idHomeStage);
          employeeList.add(idFADCaseManager);
        }
        if (listIsValid(employeeList)) {
          nmResource = (nmResource.length() > 27) ? nmResource.substring(0, 26) : nmResource;
          String shortDesc = "Please complete a Corrective Action Plan (CAP) and Policy Violation";
          String longDesc = "Please complete a Corrective Action Plan (CAP) and Policy Violation for " + nmResource + ".";
          for (Iterator<Integer> it = employeeList.iterator(); it.hasNext();) {
            Integer idEmployee = (Integer) it.next();
            if (idEmployee != null) {
              Todo todo = createTodo(ccmn35si.getUlIdPerson(), ccmn35si.getUlIdStage(), ccmn35si.getUlIdCase(), ccmn35si.getSzCdTask());
              todo.setTxtTodoDesc(shortDesc);
              todo.setTxtTodoLongDesc(longDesc);
              todo.setCdTodoTask("");
              todo.setCdTodoType(CodesTables.CTODOTYP_A);
              todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
              todoDAO.saveTodo(todo);
            }
          }
        }
      }
    }
  }

  private Person retrieveUnitSupervisorByCaseManagerId(int idPerson) {
    // CallCCMN60D
    // -- FIXME: this retrieve finds the unit supervisor's id, but this is not necessarily the assigned approver
    Map resultMap = unitEmpLinkDAO.findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(idPerson);
    Integer idSupervisor = null;
    boolean throwError = false;
    if (resultMap != null || resultMap.size() > 0) {
      idSupervisor = (Integer) resultMap.get("idPerson");
      if (idSupervisor == null) {
        throwError = true;
      }
    } else {
      throwError = true;
    }

    if (throwError) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return getPersistentObject(Person.class, idSupervisor.intValue());
  }

  private ClientOutboundSaveSI setClientOutboundSaveSI(CCMN35SI ccmn35si) {
    ClientOutboundSaveSI clientOutboundSaveSI = new ClientOutboundSaveSI();
    clientOutboundSaveSI.setIdEvent(ccmn35si.getUlIdEvent());
    clientOutboundSaveSI.setIdStage(ccmn35si.getUlIdStage());
    clientOutboundSaveSI.setIdInitiator(ccmn35si.getUlIdPerson());
    return clientOutboundSaveSI;
  }

  /**
   * Checks to see if a service (foster/adoptive) record exists.
   * 
   * @return boolean value that indicates a foster service record exists
   */
  private boolean doesServiceExist(String service, String serviceCategory) {

    boolean serviceExists = false;
    List<CodeAttributes> codeAttributesList;
    try {
      codeAttributesList = Lookup.getCategoryCollection(serviceCategory);
      // Scan through the codes to see if a foster service code exists
      for (Iterator<CodeAttributes> fosterServicesIter = codeAttributesList.iterator(); fosterServicesIter.hasNext();) {
        CodeAttributes codeAttributes = fosterServicesIter.next();
        if (codeAttributes.getCode().equals(service)) {
          serviceExists = true;
          break;
        }
      }

    } catch (LookupException e) {
      // In an ideal world, this would not be the exception thrown, but to match the existing service, use it.
      throw new ServiceException(Messages.SQL_NOT_FOUND, e);
    }
    return serviceExists;
  }

  private List<Integer> addRsrcServices(int idResource, String serviceType) throws ServiceException {
    String serviceCatagory = "";
    int iCounter = 0;
    List<Integer> idResourceServices = new ArrayList<Integer>();
    // load resource into state
    CapsResource capsResource = getPersistentObject(CapsResource.class, idResource);
    String cdRsrcCategory = capsResource.getCdRsrcCategory();
    if(FA_CATG_FOST_ADO_LEG_RISK.equals(cdRsrcCategory)) {
      //for Legal Risk the service category may be either foster or adoptive
      serviceCatagory = serviceType;
    } else if (FA_CATG_ADOPT.equals(cdRsrcCategory) || FA_CATG_REL_ADOPT.equals(cdRsrcCategory)) {
      serviceCatagory = CodesTables.CADOSVCD;
    } else if (FA_CATG_FOST.equals(cdRsrcCategory)
               || FA_CATG_REL_FOST.equals(cdRsrcCategory) || FA_CATG_ICPC_FOSTER.equals(cdRsrcCategory)) {
      serviceCatagory = CodesTables.CFOSSVCD;
    }
    // and then Add then add the entire package. It may seem inefficient but it is perhaps
    // the most optimal solution that handles all the possibilities.
    List<CodeAttributes> codeAttributesList;
    try {
      codeAttributesList = Lookup.getCategoryCollection(serviceCatagory);
      // Scan for codes for the specified category of service codes
      for (Iterator<CodeAttributes> it = codeAttributesList.iterator(); it.hasNext();) {
        CodeAttributes codeAttributes = it.next();
        // the category is the 1st 3 characters of the service code
        String svcCategory = codeAttributes.getDecode().substring(0, 3);

        ResourceService resourceService = new ResourceService();
        resourceService.setIndRsrcSvcShowRow(ArchitectureConstants.Y);
        resourceService.setCdRsrcSvcCnty(capsResource.getCdRsrcCnty());
        resourceService.setCdRsrcSvcServiceType("F");
        resourceService.setCdRsrcSvcRegion(capsResource.getCdRsrcRegion());
        resourceService.setCdRsrcSvcCategRsrc(svcCategory);
        resourceService.setCapsResource(capsResource);
        resourceService.setIndRsrcSvcCntyPartial(ArchitectureConstants.N);
        resourceService.setIndRsrcSvcIncomeBsed(ArchitectureConstants.N);
        resourceService.setCdRsrcSvcService(codeAttributes.getDecode());
        resourceService.setCdRsrcSvcState(capsResource.getCdRsrcState());

        resourceServiceDAO.saveResourceService(resourceService);
        idResourceServices.add(iCounter, resourceService.getIdResourceService());
        iCounter++;
      }
      if (codeAttributesList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } catch (LookupException e) {
      throw new ServiceException(Messages.SQL_NOT_FOUND, e);
    }
    return idResourceServices;
  }

  /**
   * Saves contract service and contract county data using the service codes and contract object
   * 
   * @param serviceType
   * @param contract
   * @param period
   * @param version
   * @param currentDate
   * @param futureDate
   */
  private void saveContractsService(String serviceType, Contract contract, int period, int version, Date currentDate,
                                    Date futureDate) {
    List<CodeAttributes> codeAttributesList;
    int counterP = 0;
    String unitType;
    String paymentType;
    double unitRate = 0.0;
    boolean bFoster = false;

    if (CodesTables.CFOSSVCD.equals(serviceType)) {
      bFoster = true;
    }

    try {
      codeAttributesList = Lookup.getCategoryCollection(serviceType);
      // loop through to save services using the service type passed in
      for (Iterator<CodeAttributes> servicesIter = codeAttributesList.iterator(); servicesIter.hasNext();) {
        CodeAttributes codeAttributes = servicesIter.next();
        if (bFoster) {
          unitType = Lookup.simpleDecodeSafe(CodesTables.CFOSUTYP, codeAttributes.getCode());
          paymentType = Lookup.simpleDecodeSafe(CodesTables.CFOSPTYP, codeAttributes.getCode());
          unitRate = Double.parseDouble(Lookup.simpleDecodeSafe(CodesTables.CFOSUTRT, codeAttributes.getCode()));
        } else {
          unitType = Lookup.simpleDecodeSafe(CodesTables.CADOUTYP, codeAttributes.getCode());
          paymentType = Lookup.simpleDecodeSafe(CodesTables.CADOPTYP, codeAttributes.getCode());
          unitRate = Double.parseDouble(Lookup.simpleDecodeSafe(CodesTables.CADOUTRT, codeAttributes.getCode()));
        }
        counterP++;
        // contract service
        ContractService addContractService = new ContractService();
        addContractService.setContract(contract);
        addContractService.setPerson(contract.getPersonByIdCntrctWkr());
        addContractService.setNbrCnsvcPeriod(period);
        addContractService.setNbrCnsvcVersion(version);
        addContractService.setNbrCnsvcLineItem(counterP);
        addContractService.setCdCnsvcService(codeAttributes.getDecode());
        addContractService.setCdCnsvcUnitType(unitType);
        addContractService.setCdCnsvcPaymentType(paymentType);
        addContractService.setIndCnsvcNewRow(ArchitectureConstants.N);
        addContractService.setNbrCnsvcUnitRate(unitRate);
        contractServiceDAO.saveContractService(addContractService);
        // contract county
        ContractCounty addContractCounty = new ContractCounty();
        addContractCounty.setContract(contract);
        addContractCounty.setPerson(contract.getPersonByIdCntrctWkr());
        addContractCounty.setNbrCncntyPeriod(period);
        addContractCounty.setNbrCncntyVersion(version);
        addContractCounty.setNbrCncntyLineItem(counterP);
        addContractCounty.setCdCncntyService(codeAttributes.getDecode());
        addContractCounty.setDtCncntyEnd(futureDate);
        addContractCounty.setCapsResource(contract.getCapsResource());
        addContractCounty.setCdCncntyCounty(contract.getCapsResource().getCdRsrcCnty());
        addContractCounty.setDtCncntyEffective(currentDate);
        // Call CAUD08D
        contractCountyDAO.saveContractCounty(addContractCounty);
      }
    } catch (LookupException e) {
      // In an ideal world, this would not be the exception thrown, but to match the existing service, use it.
      throw new ServiceException(Messages.SQL_NOT_FOUND, e);
    }
  }

  /** Returns the size of the code category */
  public int getSizeOfCodeCategory(String codeCategory) {
    int size = 0;
    List<CodeAttributes> codeAttributesList;
    try {
      codeAttributesList = Lookup.getCategoryCollection(codeCategory);
      size = codeAttributesList.size();
    } catch (LookupException e) {
      throw new ServiceException(Messages.SQL_NOT_FOUND, e);
    }
    return size;
  }

  /**
   * STGAP00010231 - Adoption Enhancement: Create an ADO stage for certain legal actions for a child that has an FCC
   * Stage. If the legal action is either a voluntary surrender or parental rights (VS) or a termination of parental
   * rights (TPR) then an ADO stage will be automatically created. If the ADO stage has already been manually opened,
   * then an ADO stage should not be automatically created.
   */
  /*
   * public void createAutoADOStageForLegalActionsOnFCCStage(CCMN35SI ccmn35si) throws ServiceException { boolean
   * adoStagePresent = false; Integer idEvent = ccmn35si.getUlIdEvent(); Integer idCase = ccmn35si.getUlIdCase(); //Find
   * the legal action for the event ID LegalAction legalAction =
   * legalActionDAO.findLegalActionByIdLegalActEvent(idEvent); //Get the legal action code String action =
   * legalAction.getCdLegalActAction(); //Get all the legal action outcome records List<LegalActionOutcome>
   * legalActionOutcomeList = legalActionOutcomeDAO.findLegalActionOutcomeList(idEvent); List<String> outcomes = new
   * ArrayList<String>(); Iterator<LegalActionOutcome> legalActItr = legalActionOutcomeList.iterator(); //Get the
   * outcomes while (legalActItr.hasNext()){ LegalActionOutcome legalActionOutcome = legalActItr.next();
   * outcomes.add(legalActionOutcome.getCdOutcome()); } if ((CodesTables.CLEGCPS_VLM.equals(action) ||
   * CodesTables.CLEGCPS_VLF.equals(action) || CodesTables.CLEGCPS_VAM.equals(action) ||
   * CodesTables.CLEGCPS_VAF.equals(action)) ||((CodesTables.CLHECOT_TPM.equals(action) ||
   * CodesTables.CLHECOT_TPF.equals(action) || CodesTables.CLHECOT_TPA.equals(action) ||
   * CodesTables.CLHECOT_TFA.equals(action)) && ((outcomes.contains(CodesTables.CLEGLOUT_TPG) &&
   * (outcomes.contains(CodesTables.CLEGLOUT_TPC) || outcomes.contains(CodesTables.CLEGLOUT_TPS) ||
   * outcomes.contains(CodesTables.CLEGLOUT_TPT))) || outcomes.contains(CodesTables.CLEGLOUT_DPC)))) { //Check for an
   * existing ADO stage for the case List<Stage> stageList = stageDAO.findStageByIdCase(idCase); Iterator<Stage>
   * stageItr = stageList.iterator(); while (stageItr.hasNext()){ Stage stage = stageItr.next(); if
   * (CodesTables.CSTAGES_ADO.equals(stage.getCdStage())){ adoStagePresent = true; } } //If no ADO stage present, create
   * a new ADO stage if(!adoStagePresent){ CCMN88SI ccmn88si = populateCCMN88SI_StageProgress(ccmn35si);
   * saveStageProgression.saveStageProgression(ccmn88si); } } }
   */

  /**
   * This method will set the inputs into the CCMN88S service to stage progress.
   * 
   * @param context
   *          data to pass to the save service
   */
  /*
   * private CCMN88SI populateCCMN88SI_StageProgress(CCMN35SI ccmn35si) { int idPerson = ccmn35si.getUlIdPerson();
   * CCMN88SI ccmn88si = new CCMN88SI(); ArchInputStruct input = new ArchInputStruct(); String setSzCdStageOpen =
   * CodesTables.CSTAGES_ADO; input.setSzUserId(ccmn35si.getArchInputStruct().getSzUserId());
   * ccmn88si.setArchInputStruct(input); ccmn88si.setUlIdStage(ccmn35si.getUlIdStage());
   * ccmn88si.setUlIdPerson(ccmn35si.getUlIdCntrctWkr()); ccmn88si.setSzCdStage(CodesTables.CSTAGES_SUB);
   * ccmn88si.setSzCdStageOpen(setSzCdStageOpen); ccmn88si.setSzCdStageReasonClosed(CodesTables.CSTAGES_SUB);
   * ccmn88si.setSzCdStageProgram(CodesTables.CPGRMS_CPS); Person person = personDAO.findPersonByIdPerson(idPerson);
   * ccmn88si.setSzNmPersonFull(person.getNmPersonFull()); ccmn88si.setUlScrIdPrimChild(idPerson);
   * ccmn88si.setCSysIndSStgOpenOnly(INDICATOR_YES);
   * 
   * return ccmn88si; }
   */

  // STGAP00006650 - created new method addRegionToRsrcServices() to save the region of the resource to the
  // resourceServices table
  public void addRegionToRsrcServices(CapsResource capsResource, String cdCntrctRegion, String cdServiceType) {
    int nbrRowsUpdated = resourceServiceDAO.updateResourceServiceRegion(capsResource.getIdResource().intValue(),
                                                                        cdCntrctRegion, capsResource.getCdRsrcCnty());
 // STGAP00014642 If there is nothing to update then the resource services need to be added here
    if (nbrRowsUpdated == 0) {
      List<Integer> resourceServicesIds = addRsrcServices(capsResource.getIdResource().intValue(), cdServiceType);
      if(resourceServicesIds.isEmpty() || resourceServicesIds == null){
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
  }

  /**
   * Builds the event description for the event being approved based on whether it has been rejected or approved.
   * 
   * @param idEvent
   * @param cdEventStatus
   * @return Event Description
   */
  private String generateSpecialNeedsEventDescription(int idEvent, String cdEventStatus) {
    String txtEventDescription = "";
    String status = "";
    int idPerson = 0;

    try {
      SpecialNeedsDetermination spd = specialNeedsDeterminationDAO.findSpecialNeedsDeterminationByIdEvent(idEvent);
      String cdSpclSerType = spd.getCdSpclSerType();
      
      // Adoption Assistance Application is <status (approved, denied, deferred)> for child <person id>
      // Get the Person ID of the child. There should only be 1
      List<EventPersonLink> personList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idEvent);
      for (Iterator<EventPersonLink> it = personList.iterator(); it.hasNext();) {
        EventPersonLink eventPerson = it.next();
        idPerson = eventPerson.getPerson().getIdPerson();
      }
      // Look to see if the Basic Rate is being used. If not lookup status on
      // Special Rate indicator
      // MR-52 Per STGAP00015696 Modified the Event Description as per Adoption Assistance Application Detailed Design
      if (CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)) {
        if (ArchitectureConstants.Y.equals(spd.getIndSpcNeedsApproved())
            || ArchitectureConstants.Y.equals(spd.getIndSpclReqApproved())
            || ArchitectureConstants.Y.equals(spd.getIndSpclRateAdoAppr())
            || ArchitectureConstants.Y.equals(spd.getIndNonRecApproved())) {
          status = Lookup.simpleDecode(CodesTables.CAPPSTS, CodesTables.CAPPSTS_Y).toLowerCase();

          if (ArchitectureConstants.Y.equals(spd.getIndSpcNeedsApproved()) && spd.getIndReasonSpecialRequest() != null) {
            txtEventDescription = "Sp Nds";
          }

          if (ArchitectureConstants.Y.equals(spd.getIndBasicRateReqChild())
              && ArchitectureConstants.Y.equals(spd.getIndSpcNeedsApproved())) {
            if (StringHelper.isEmptyOrNull(txtEventDescription)) {
              txtEventDescription = "Bsc Rt";
            } else {
              txtEventDescription = txtEventDescription + ", Bsc Rt";
            }
          }

          if (ArchitectureConstants.Y.equals(spd.getIndSpclRateAdoAppr())) {
            if (StringHelper.isEmptyOrNull(txtEventDescription)) {
              txtEventDescription = "Splzd Rt";
            } else {
              txtEventDescription = txtEventDescription + ", Splzd Rt";
            }
          }
          if (ArchitectureConstants.Y.equals(spd.getIndNonRecApproved())) {
            if (StringHelper.isEmptyOrNull(txtEventDescription)) {
              txtEventDescription = "Non Recur";
            } else {
              txtEventDescription = txtEventDescription + ", Non Recur";
            }
            //SMS#114235: specify on the event description if it is the non-recurring only application being approved
            if (ArchitectureConstants.Y.equals(spd.getIndNonRecOnly())) {
              txtEventDescription = txtEventDescription + " Only";
            }
          }
          if (ArchitectureConstants.Y.equals(spd.getIndSpclReqApproved())) {
            if (StringHelper.isEmptyOrNull(txtEventDescription)) {
              txtEventDescription = "Sp Svc";
            } else {
              txtEventDescription = txtEventDescription + ", Sp Svc ";
            }
          }

          if (ArchitectureConstants.Y.equals(spd.getIndSpclReqApproved())) {
            String beginDate = DateHelper.toString(spd.getDtApprvDate(), DateHelper.SLASH_FORMAT);
            String endDate = DateHelper.toString(spd.getDtExpirationDate(), DateHelper.SLASH_FORMAT);
            String spService = "";
            if (CodesTables.CSPLSERV_DCR.equals(cdSpclSerType)) {
              spService = "Child Care";
            } else if (CodesTables.CSPLSERV_ORT.equals(cdSpclSerType)) {
              spService = "Dent/Ortho";
            } else if (CodesTables.CSPLSERV_MED.equals(cdSpclSerType)) {
              spService = "Med";
            } else if (CodesTables.CSPLSERV_XXX.equals(cdSpclSerType)) {
              spService = "Other";
            } else if (CodesTables.CSPLSERV_RES.equals(cdSpclSerType)) {
              spService = "Resp";
            } else if (CodesTables.CSPLSERV_TCS.equals(cdSpclSerType)) {
              spService = "Ther/Couns";
            }
            txtEventDescription = txtEventDescription + " " + beginDate + " - " + endDate + " " + spService;
          }
         if ("Sp Nds".equals(txtEventDescription)) {
            txtEventDescription = "Special Needs"+ " " + status + " for child " + idPerson;;
          } else {
            txtEventDescription = txtEventDescription + " " + status + " for child " + idPerson;
          }
          if (txtEventDescription.length() > 100) {
            txtEventDescription = txtEventDescription.substring(0, 99);
          }
        } else if (CodesTables.CAPPSTS_D.equals(spd.getIndSpcNeedsApproved())) {
          status = Lookup.simpleDecode(CodesTables.CAPPSTS, CodesTables.CAPPSTS_D).toLowerCase();
          txtEventDescription = "Special Needs " + " " + status + " for child " + idPerson;
        } else {
          status = Lookup.simpleDecode(CodesTables.CAPPSTS, CodesTables.CAPPSTS_N).toLowerCase();
          txtEventDescription = "Adoption Assistance Appplication is " + status + " for child " + idPerson;
        }
      } else if (CodesTables.CEVTSTAT_PROC.equals(cdEventStatus)) {
        txtEventDescription = "Adoption Assistance Appplication in process for child " + idPerson;
      }
    } catch (LookupException e) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return txtEventDescription;
  }
  
  
  /**
   * Builds the event description for the event being approved based on whether it has been rejected or approved.
   * 
   * @param idEvent
   * @param cdEventStatus
   * @return Event Description
   */
  private String generateAdopAssitanceEventDescription(int idEvent, String cdEventStatus) {
    
    StringBuffer tmpSzTxtEventDescr = new StringBuffer();
    Map adptSubEventLinkInfo = adptSubEventLinkDAO.findAdptSubEventLink(idEvent);
    if (adptSubEventLinkInfo != null || adptSubEventLinkInfo.size() > 0) {
      String tmpSzCdAdptSubDeterm = (String) adptSubEventLinkInfo.get("cdAdptSubDeterm");
      tmpSzCdAdptSubDeterm = (tmpSzCdAdptSubDeterm != null) ? tmpSzCdAdptSubDeterm : "";
      String tmpDtDtAdptSubEffective = DateHelper.toString((Date) adptSubEventLinkInfo.get("dtAdptSubEffective"), DateHelper.SLASH_FORMAT);
      String tmpDtDtAdptSubEnd =  DateHelper.toString((Date) adptSubEventLinkInfo.get("dtAdptSubEnd"), DateHelper.SLASH_FORMAT);      
      int idPerson = (Integer) adptSubEventLinkInfo.get("idPerson") != null ? (Integer) adptSubEventLinkInfo.get("idPerson") : 0;
      
      if ((CodesTables.CSUBTYPE_10).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_18).equals(tmpSzCdAdptSubDeterm) || 
                      (CodesTables.CSUBTYPE_19).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_20).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_21).equals(tmpSzCdAdptSubDeterm)) {
        tmpSzTxtEventDescr.append("The Special Service Assistance has been processed for child " + idPerson);
      }else if (CodesTables.CSUBTYPE_17.equals(tmpSzCdAdptSubDeterm)) {
        tmpSzTxtEventDescr.append("The Non-Recurring Assistance has been processed for child " + idPerson);
      }else
        {
        if("".equals(tmpSzCdAdptSubDeterm)) {
          tmpSzTxtEventDescr.append("Adoption ");
        } else {
          tmpSzTxtEventDescr.append(Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, tmpSzCdAdptSubDeterm));
        }
                
        tmpSzTxtEventDescr.append(" Assistance Start ");
        tmpSzTxtEventDescr.append(tmpDtDtAdptSubEffective);
        tmpSzTxtEventDescr.append(" End ");
        tmpSzTxtEventDescr.append(tmpDtDtAdptSubEnd);
        tmpSzTxtEventDescr.append(" processed  ");
        tmpSzTxtEventDescr.append(" for child " + idPerson);
      } 
      if(CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)) {
        tmpSzTxtEventDescr.append(" is approved");
      }      
    }
   
    String eventDescr = tmpSzTxtEventDescr.toString();
    return (eventDescr.length() > 100 ? eventDescr.substring(0, 100) : eventDescr); 
  }
  
  /**
   * Builds the event description for the event being approved based on whether it has been rejected or approved.
   * 
   * @param idEvent
   * @param cdEventStatus
   * @return Event Description
   */
  private String generateContactStandardsEventDescription(int idEvent, String cdEventStatus) {
    
    StringBuffer tmpSzTxtEventDescr = new StringBuffer("");
    if(CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)) {
      tmpSzTxtEventDescr.append("Contact Standards has been approved.");
    } else if (CodesTables.CEVTSTAT_PROC.equals(cdEventStatus)) {
      tmpSzTxtEventDescr.append("Contact Standards has been saved but has not been submitted for Approval.");
    }
    String eventDescr = tmpSzTxtEventDescr.toString();
    return (eventDescr.length() > 100 ? eventDescr.substring(0, 100) : eventDescr); 
  }
  
  /**
   * Builds the event description for the event being approved based on whether it has been rejected or approved.
   * 
   * @param idEvent
   * @param cdEventStatus
   * @return Event Description
   */
  private String generateSpclInvestigationEventDescription(int idEvent, String cdEventStatus) {
    
    StringBuffer tmpSzTxtEventDescr = new StringBuffer("");
    if(CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)) {
      tmpSzTxtEventDescr.append("Special Investigation has been approved");
    } else if (CodesTables.CEVTSTAT_PROC.equals(cdEventStatus)) {
      tmpSzTxtEventDescr.append("Special Investigation has been saved but has not been submitted for Approval.");
    }
    String eventDescr = tmpSzTxtEventDescr.toString();
    return (eventDescr.length() > 100 ? eventDescr.substring(0, 100) : eventDescr); 
  }
  
  
  private void sendAlertsforApprovedFCCPFamily(CCMN35SI ccmn35si) {
    Person caseWorker = getPersistentObject(Person.class, ccmn35si.getUlIdPerson());
    int idCase = ccmn35si.getUlIdCase();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    int idStage = ccmn35si.getUlIdStage();
    boolean caseHasAdoptionStage = false;

    List<Map> adoptionStageMap = stageDAO.findOpenStagesByIdCaseCdStage(idCase, CodesTables.CSTAGES_ADO);

    if (adoptionStageMap != null && !adoptionStageMap.isEmpty()) {
      caseHasAdoptionStage = true;
    }

    if (caseHasAdoptionStage) {
      // alert case worker to copy a new adoption information
      Todo todo = new Todo();
      String cdTask = "";
      todo.setPersonByIdTodoPersAssigned(caseWorker);
      todo.setTxtTodoDesc("Family Plan has been approved; Please copy a new " + " Adoption Information page.");
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(new Date());
      todo.setPersonByIdTodoPersWorker(caseWorker);
      todo.setDtTodoCreated(new Date());
      todo.setCapsCase(capsCase);
      todo.setStage(getPersistentObject(Stage.class, idStage));
      complexTodoDAO.insertTodo(todo);
    }

    if (caseHasAdoptionStage) {
      // alert Regional Adoption Exchange Consultants when the case plan is approved with a child that has an ADO stage
      StringBuffer bfrListOfChildrenNames = new StringBuffer();
      int idEvent = ccmn35si.getUlIdEvent();
      // retrieve all persons relate to the plan
      List<Map> eventPrincipalsList = eventPersonLinkDAO.findPersonsByIdEvent(idEvent);
      List<Integer> childPrincipalList = new ArrayList<Integer>();
      if (listIsValid(eventPrincipalsList)) {
        Iterator itr = eventPrincipalsList.iterator();
        int count = 0;
        while (itr.hasNext()) {
          Map prn = (Map) (itr.next());
          int idPrincipal =(Integer) prn.get("ID_PERSON");
          String nmPrincipallFull = (String) prn.get("NM_PERSON_FULL");
          // If principal has an ADO stage then it's a child and we need to add their name in the list of names
          // to be included in the alert
          int numOpenAdoStage = (int) stageDAO.countOpenAdoStageByIdPersonIdCase(idPrincipal, idCase);
          if (numOpenAdoStage > 0) {
            // Principal has an ADO stage. Add them to the list of selected children on the Plan
            childPrincipalList.add(idPrincipal);
            // Append their name to the buffer
            bfrListOfChildrenNames.append(nmPrincipallFull);
            count++;
            if (itr.hasNext() && count > 1) {
              bfrListOfChildrenNames.append(" - ");
            }
          } 
        }
      }
      String listOfChildrenNames = bfrListOfChildrenNames.toString();
      String cdCounty = capsCase.getCdCaseCounty();
      if(cdCounty != null){
        if(cdCounty.length() == 1 ){
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2){
          cdCounty = "0" + cdCounty;
        }
      }
      // Get the region of the county
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
      List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
      if (listIsValid(adoExchangeConsultants)) {
        Iterator<Integer> itrAdoExchangeConsultants = adoExchangeConsultants.iterator();
        List<Todo> todoList3 = new ArrayList<Todo>();
        while (itrAdoExchangeConsultants.hasNext()) {
          int idAssigned = (Integer) itrAdoExchangeConsultants.next();
          Todo todo3 = new Todo();
          String cdTask = "";
          todo3.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          String todoLongDesc = listOfChildrenNames + " case plan has been updated";
          listOfChildrenNames = (listOfChildrenNames.indexOf(" -") < 0) ? listOfChildrenNames : "More than one child's";
          String todoDesc = listOfChildrenNames + " case plan has been updated";
          todo3.setTxtTodoDesc(todoDesc);
          todo3.setTxtTodoLongDesc(todoLongDesc); 
          todo3.setCdTodoTask(cdTask);
          todo3.setCdTodoType(CodesTables.CTODOTYP_A);
          todo3.setDtTodoDue(new Date());
          todo3.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, ccmn35si.getUlIdPerson()));
          todo3.setDtTodoCreated(new Date());
          todo3.setCapsCase(capsCase);
          todo3.setStage(getPersistentObject(Stage.class, idStage));
          todoList3.add(todo3);
        }
        complexTodoDAO.saveTodo(todoList3);
      }
      
      // Alert when a child in case has been adopted and the permanency goal has been changed since last approved
      // Find the Family plan that's being approved
      FccpFamily currentFccpFam = fccpFamilyDAO.findFCCPFamilyByIdEvent(idEvent);
      // If the Permanency Plan is not Adoption then see if an approved Adoption Permanency Plan exist
      if (currentFccpFam != null && !CodesTables.CPERMPLN_ADA.equals(currentFccpFam.getCdPrimPermPlan())) {
        if (listIsValid(childPrincipalList)) {
          Integer numApprovedPrimGoals = fccpFamilyDAO.CountApprvPrimPermPlanGoalByCaseAndCdPrimPermPlan(idCase,
                                                                                              CodesTables.CPERMPLN_ADA,
                                                                                              childPrincipalList);
          // if an Adoption Permanency plan exists for a principal that is selected on the Plan that is being approved,
          // Send alert to Regional Adoption Exchange Consultants and RACs
          if (numApprovedPrimGoals > 0) {
            List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
            List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
            if (listIsValid(adoExchangeConsultants)) {
              racAndAuthorizedSauList.addAll(adoExchangeConsultants);
            }
            if (listIsValid(racList)) {
              racAndAuthorizedSauList.addAll(racList);
            }
            if (listIsValid(racAndAuthorizedSauList)) {
              Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
              List<Todo> todoList4 = new ArrayList<Todo>();
              while (itrRacAndAuthorizedSauList.hasNext()) {
                int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
                Todo todo4 = new Todo();
                String cdTask = "";
                Date dateCreated = new Date();
                Date todoDueDate = new Date();
                String todoDesc = "Child's permanency plan has changed.";
                todo4.setEvent(getPersistentObject(Event.class, idEvent));
                todo4.setTxtTodoDesc(todoDesc);
                todo4.setCdTodoTask(cdTask);
                todo4.setCdTodoType(CodesTables.CTODOTYP_A);
                todo4.setDtTodoDue(todoDueDate);
                todo4.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
                todo4.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, ccmn35si.getUlIdPerson()));
                todo4.setDtTodoCreated(dateCreated);
                todo4.setCapsCase(capsCase);
                todo4.setStage(getPersistentObject(Stage.class, idStage));
                todoList4.add(todo4);
              }
              complexTodoDAO.saveTodo(todoList4);
            }
          }
        }
      }

    }
  }	  

  private void sendAlertsforApprovedAdoptiveHome(CapsResource capsResource, CCMN35SI ccmn35si) {

    if (FA_CATG_ADOPT.equals(capsResource.getCdRsrcCategory())
        || FA_CATG_REL_ADOPT.equals(capsResource.getCdRsrcCategory())
        || FA_CATG_ICPC_ADOPT.equals(capsResource.getCdRsrcCategory())
        || FA_CATG_FOST_ADO_LEG_RISK.equals(capsResource.getCdRsrcCategory())) {
      Person caseWorker = getPersistentObject(Person.class, ccmn35si.getUlIdPerson());
      int idCase = ccmn35si.getUlIdCase();
      int idStage = ccmn35si.getUlIdStage();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, idCase);
      Date todaysDate = new Date();

      String cdCounty = capsCase.getCdCaseCounty();
      if(cdCounty != null){
        if(cdCounty.length() == 1 ){
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2){
          cdCounty = "0" + cdCounty;
        }
      }
      // Get the region of the county
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
      // Get the Regional Adoption Exchange Consultants list
      List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
      List<Integer> authorizedSauList = new ArrayList<Integer>();
      // Get the RACs list
      List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
      if (listIsValid(racList)) {
        authorizedSauList.addAll(racList);
      }
      if (listIsValid(adoExchangeList)) {
        authorizedSauList.addAll(adoExchangeList);
      }

      // alert Regional Adoption Exchange Consultants and RACs that home has been approved
      if (authorizedSauList != null && !authorizedSauList.isEmpty()) {
        Iterator<Integer> itrAuthorizedSauList = authorizedSauList.iterator();
        List<Todo> todoList3 = new ArrayList<Todo>();
        while (itrAuthorizedSauList.hasNext()) {
          int idAssigned = (Integer) itrAuthorizedSauList.next();
          Todo todo3 = new Todo();
          String cdTask = "";
          todo3.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo3.setTxtTodoDesc("Adoptive or Foster/Adoptive home has been approved.");
          todo3.setCdTodoTask(cdTask);
          todo3.setCdTodoType(CodesTables.CTODOTYP_A);
          todo3.setDtTodoDue(new Date());
          todo3.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, ccmn35si.getUlIdPerson()));
          todo3.setDtTodoCreated(new Date());
          todo3.setCapsCase(capsCase);
          todo3.setStage(getPersistentObject(Stage.class, idStage));
          todoList3.add(todo3);
        }
        complexTodoDAO.saveTodo(todoList3);
      }

      // alert case worker Ongoing training is required within 30 days
      Todo todo = new Todo();
      String cdTask = "";
      todo.setPersonByIdTodoPersAssigned(caseWorker);
      todo.setTxtTodoDesc("Ongoing training is required within 30 days.");
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(new Date());
      todo.setPersonByIdTodoPersWorker(caseWorker);
      todo.setDtTodoCreated(DateHelper.addToDate(todaysDate, 0, 0, 30));
      todo.setCapsCase(capsCase);
      todo.setStage(getPersistentObject(Stage.class, idStage));
      complexTodoDAO.insertTodo(todo);
    }
  }
  
  private void sendAlertsforClosedAdoptiveHome(CapsResource capsResource, CCMN35SI ccmn35si) {
    String closureReason = capsResource.getCdRsrcClosureRsn();

    if (FA_CATG_ADOPT.equals(capsResource.getCdRsrcCategory())
        || FA_CATG_REL_ADOPT.equals(capsResource.getCdRsrcCategory())
        || FA_CATG_ICPC_ADOPT.equals(capsResource.getCdRsrcCategory())
        || FA_CATG_FOST_ADO_LEG_RISK.equals(capsResource.getCdRsrcCategory())) {

      Person caseWorker = getPersistentObject(Person.class, ccmn35si.getUlIdPerson());
      int idCase = ccmn35si.getUlIdCase();
      int idStage = ccmn35si.getUlIdStage();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, idCase);
      Date todaysDate = new Date();
      boolean childrenPlacedInHome = false;
      boolean homeRegisteredWithExchange = false;

      // check to see if home has a placement and check to see if home is registered
      List<Map> placementList = placementDAO
                                            .findPersonByIdPlcmtChildByCapsResourceByIdRsrcFacil(
                                                                                                 new Date(),
                                                                                                 capsResource
                                                                                                             .getIdResource());

      if (placementList != null && !placementList.isEmpty()) {
        childrenPlacedInHome = true;
      }

      Event homeRegEvent = eventDAO.findEventByStageTypeAndStatus(idStage, CodesTables.CEVNTTYP_EXH,
                                                                  CodesTables.CEVTSTAT_PROC);

      if (homeRegEvent != null) {
        homeRegisteredWithExchange = true;
      }

      String cdCounty = capsCase.getCdCaseCounty();
      if(cdCounty != null){
        if(cdCounty.length() == 1 ){
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2){
          cdCounty = "0" + cdCounty;
        }
      }
      // Get the region of the county
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
      List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

      // Alert Regional Adoption Exchange Consultants that Registered Home has been closed with no placement
      if ((homeRegisteredWithExchange && !childrenPlacedInHome) && adoExchangeList != null
          && !adoExchangeList.isEmpty()) {
        Iterator<Integer> itrAdoExchangeList = adoExchangeList.iterator();
        List<Todo> todoList3 = new ArrayList<Todo>();

        while (itrAdoExchangeList.hasNext()) {
          int idAssigned = (Integer) itrAdoExchangeList.next();
          Todo todo3 = new Todo();
          String cdTask = "";
          todo3.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo3.setTxtTodoDesc("Registered Home (id " + capsResource.getIdResource()
                               + ") has been closed with no placement");
          todo3.setTxtTodoLongDesc("Registered Home (id:" + capsResource.getIdResource() + " Name:"
                                   + capsResource.getNmResource() + ") has been closed with no placement");

          todo3.setCdTodoTask(cdTask);
          todo3.setCdTodoType(CodesTables.CTODOTYP_A);
          todo3.setDtTodoDue(new Date());
          todo3.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, ccmn35si.getUlIdPerson()));
          todo3.setDtTodoCreated(new Date());
          //STGAP00010951 Not setting case or stage to avoid removing alert on closure;
          //todo3.setCapsCase(capsCase);
          //todo3.setStage(getPersistentObject(Stage.class, idStage));
          todoList3.add(todo3);
        }

        complexTodoDAO.saveTodo(todoList3);
      }
    }
  }

  private void sendAlertClosedHomeAdoptionFinalReceivingSubsidies (int idCase, int idStage) {
    Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    String cdTask = "";
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdCounty = capsCase.getCdCaseCounty();
    if(cdCounty != null){
      if(cdCounty.length() == 1 ){
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2){
        cdCounty = "0" + cdCounty;
      }
    }
    //Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    List<Integer> adoAssistanceConsultants = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
    if (listIsValid(adoAssistanceConsultants)) {
      Iterator<Integer> itrAdoAssistanceConsultants = adoAssistanceConsultants.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrAdoAssistanceConsultants.hasNext()) {
        Integer idAssigned = (Integer) itrAdoAssistanceConsultants.next();
        String todoDesc = "Information has been updated on a home with a finalized adoption that is receiving subsidies";
        Todo todo = new Todo();
        todo.setPersonByIdTodoPersAssigned(personDAO.findPersonByIdPerson(idAssigned));
        todo.setTxtTodoDesc(todoDesc);
        todo.setTxtTodoLongDesc(todoDesc);
        todo.setCdTodoTask(cdTask);
        todo.setDtTodoDue(dtToday);
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setCapsCase(capsCase);
        todo.setDtTodoCreated(dtToday);
        todo.setStage(getPersistentObject(Stage.class, idStage));
        todoList.add(todo);
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }
  
  private void sendAlertsToSauOnChLifeHstChkListApproval(int idCase, int idStage, int idWorker) {
    Stage stage = stageDAO.findStageAndCapsCase(idStage);
    String cdCounty = "";
    if(stage!=null && stage.getCapsCase()!=null){
      cdCounty = stage.getCapsCase().getCdCaseCounty();
    }
    if(cdCounty != null){
      if(cdCounty.length() == 1 ){
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2){
        cdCounty = "0" + cdCounty;
      }
    }
    // Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Alert the Regional Adoption Assistance Consultants and the RAC of the approval of the event
    String cdTask = "";
    String todoDesc = "Child Life History has been submitted and approved by county";
    List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
    List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
    List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
    if (listIsValid(adoExchangeConsultants)) {
      racAndAuthorizedSauList.addAll(adoExchangeConsultants);
    }
    if (listIsValid(racList)) {
      racAndAuthorizedSauList.addAll(racList);
    }
    if (listIsValid(racAndAuthorizedSauList)) {
      Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrRacAndAuthorizedSauList.hasNext()) {
        int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
        Todo todo = new Todo();
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
        todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idWorker));
        todo.setCdTodoTask(cdTask);
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setDtTodoDue(new Date());
        todo.setTxtTodoDesc(todoDesc);
        todo.setDtTodoCreated(new Date());
        // STGAP00011869 -- Associate Stage & Case objects with Todo so that
        // this information will be available to the user
        todo.setStage(getPersistentObject(Stage.class,idStage));
        todo.setCapsCase(getPersistentObject(CapsCase.class,idCase));
        todoList.add(todo);
      }

      complexTodoDAO.saveTodo(todoList);
    }

  }
  /**
   * This method sends alerts for
   * 1. Maltreatement In Care
   * 2. Policy Violation
   * 3. Placement Not On hold.
   * CAPTA 4.3 
   * @param ccmn35si
   */
  private void sendToDoforIntakeMaltreatmentInCareAndSetHoldPlacements(CCMN35SI ccmn35si, IncomingDetail intake) {
    CapsResource capsResource = new CapsResource();
    Integer idResourceObj = null;
    int idResource = 0;
    int idStage = 0;
    int idHomeStage = 0;
    String cdRsrcFacilType = "";
    int idFADCaseManager = 0;
    int unitSupervisorFAD = 0;
    List<Integer> stateOfficeResourceDeveloperList = new ArrayList<Integer>();
    
    //MR-097  Ading the logic to find the county     
    int idCase = ccmn35si.getUlIdCase();
  
    CapsCase capsCase;
    capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdCounty = capsCase.getCdCaseCounty();
    if (cdCounty != null) {
        if (cdCounty.length() == 1) {
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2) {
          cdCounty = "0" + cdCounty;
        }
    }
    // Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Getting the list of Field Program Specialists
    List<Integer> regionalPersonList = unitEmpLinkDAO.findFieldProgramSpecialistByIdRegion(cdRegion);
   
    List<Integer> employeeList = new ArrayList<Integer>();
    // Copying the Field Program Specialists to the list of recepient to whom the alerts needs to be send    
    employeeList.addAll(regionalPersonList);   
    
    IncomingFacility incomingFacility = incomingFacilityDAO.findIncomingFacilityByIdStage(ccmn35si.getUlIdStage());
    if(incomingFacility != null){
      idResourceObj = incomingFacility.getCapsResource() != null ? incomingFacility.getCapsResource().getIdResource() : 0;
    }
    
    if(idResourceObj == null){
      idResource = 0;
    }else{
      idResource = idResourceObj;
    }
    
    if(idResource != 0){
      capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);
      String nmResource = capsResource.getNmResource();
      if(capsResource.getStage() != null){
        idHomeStage = capsResource.getStage().getIdStage();
      }
      cdRsrcFacilType = capsResource.getCdRsrcFacilType();

     
      if(idHomeStage != 0){
        //Get the primary case worker assigned to the FAD stage.
        idFADCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idHomeStage);

        //Get the unit supervisor of the primary case manager assigned to the FAD stage.
        Integer unitSupervisorObj = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idFADCaseManager);
        unitSupervisorFAD = unitSupervisorObj != null ? unitSupervisorObj : 0;
      }

      /*If the Home is DFCS home then send the alert to the 
       1. Primary Case Manager of the FAD stage.
       */
      if( CodesTables.CFACTYP4_70.equals(cdRsrcFacilType)){
        if(idHomeStage != 0){
          employeeList.add(idFADCaseManager);     
        }
      }
      /*If the Home is CCI, Non-DFCS, Specialty Hospital, Maternity Home, Outdoor Therapeutic
       * or Child Placing Agency then send the alert to the 
        1. State Office Resource Developer
       */
      else if(CodesTables.CFACTYP4_CC.equals(cdRsrcFacilType) || CodesTables.CFACTYP4_71.equals(cdRsrcFacilType) ||
                      CodesTables.CFACTYP4_SH.equals(cdRsrcFacilType) ||CodesTables.CFACTYP4_MH.equals(cdRsrcFacilType)  ||
                      CodesTables.CFACTYP4_OT.equals(cdRsrcFacilType) || CodesTables.CFACTYP4_CP.equals(cdRsrcFacilType)){
        stateOfficeResourceDeveloperList = this.getStateOfficeResourceDeveloperList();
        if (stateOfficeResourceDeveloperList != null && !stateOfficeResourceDeveloperList.isEmpty()) {
          for (Iterator <Integer> it = stateOfficeResourceDeveloperList.iterator(); it.hasNext();) {
            employeeList.add(it.next().intValue());
          }
        }
        
      }

      // SMS 59029 Shortened the Alert Text  CPS_INVESTIGATION_ALERT_FOR_SPECIAL_INV
      //CAPTA 4.3 - sending alerts for MIC and Policy violation.
      nmResource = (nmResource.length() > 27) ? nmResource.substring(0, 26) : nmResource;
      for (Iterator<Integer> it = employeeList.iterator(); it.hasNext();) {
        Integer idEmployee = (Integer) it.next();
        if (idEmployee != null) {
           //send Maltreatement In Care Alert
          if(ServiceConstants.FND_YES.equals(intake.getIndIncmgMaltreatInCare()) && 
                          idResource != 0 && 
                          APPROVE_CPS_INTAKE.equals(ccmn35si.getSzCdTask()) ) {
            String longDesc = "Maltreatment in Care has been alleged on an Intake for " + nmResource +".";
            sendAlert(ccmn35si,idEmployee, ALERT_MIC_TEXT, longDesc);
          } 
          //send policy violation Alert.
          if(ServiceConstants.FND_YES.equals(intake.getIndPolicyViolation()) && 
                          idResource != 0 && 
                          APPROVE_CPS_INTAKE.equals(ccmn35si.getSzCdTask()) ) {
            String longDesc = "A Policy Violation has been alleged on an Intake for " + nmResource +".";
            sendAlert(ccmn35si,idEmployee, ALERT_POLICY_VIOLATION_TEXT, longDesc);
          }
        }
      }
      if(idHomeStage != 0){
        capsResourceDAO.updateCapsResourceIndHoldPlacements(idResource, ServiceConstants.FND_YES);
        List<Integer> personList = new ArrayList<Integer>();
        personList.add(idFADCaseManager);     
        personList.add(unitSupervisorFAD);
        //Get the Case Managers of the Children placed in the Home
        List<Integer> caseManagersOfChildrenPlacedInResourceList = stagePersonLinkDAO.findStagePersonLinkByIdResource(idResource);
        List<Integer> supervisorOfCMOfChildrenPlacedInResourceList = new ArrayList<Integer>();
        if (listIsValid(caseManagersOfChildrenPlacedInResourceList)) {
          personList.addAll(caseManagersOfChildrenPlacedInResourceList);
          Iterator<Integer> iterCM = caseManagersOfChildrenPlacedInResourceList.iterator();
          while (iterCM.hasNext()) {
            Integer idCM = (Integer) iterCM.next();
            // Get the unit supervisor of the primary case manager assigned to the child's stage.
            Integer unitSupervisorCMChild = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCM);
            supervisorOfCMOfChildrenPlacedInResourceList.add(unitSupervisorCMChild);
          }
          if (listIsValid(supervisorOfCMOfChildrenPlacedInResourceList)) {
            personList.addAll(supervisorOfCMOfChildrenPlacedInResourceList);
          }
        }
        if (listIsValid(personList)) {
          String longDesc = nmResource + " has been placed on hold for placements.";
          //send alert for Placement no longer on hold.
          for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
            Integer idEmployee = (Integer) it.next();
            if (idEmployee != null) {              
              sendAlert(ccmn35si,idEmployee, ALERT_PLACEMENT_ON_HOLD,  longDesc);
            }
          }
        }
      }
    }
  }
  
  /**
   * CAPTA 4.3
   * This method Creates Todo object and sends alerts to the employee with the given alert text.
   * @param ccmn35si
   */
  private void sendAlert(CCMN35SI ccmn35si, int idEmployee, String shortDesc, String longDesc) {
    Todo todo = createTodo(ccmn35si.getUlIdPerson(), ccmn35si.getUlIdStage(), ccmn35si.getUlIdCase(),
                           ccmn35si.getSzCdTask());
    todo.setCdTodoTask("");
    todo.setTxtTodoDesc(shortDesc);
    todo.setTxtTodoLongDesc(longDesc);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    if(idEmployee >0 ){
     todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
     todoDAO.saveTodo(todo);
    }
    
  }
  
  private void sendAlertsForSpclInvConcurrenceDue(int idPerson, int idStage, int idCase, String cdTask) {
    List<Integer> personList = new ArrayList<Integer>();
    Stage stage = getPersistentObject(Stage.class, idStage);
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);

    // Policy Specialist
    List<Integer> policySpecialistList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(PRU_STAFF_SECURITY_CLASS_NAME);
    if (listIsValid(policySpecialistList)) {
      personList.addAll(policySpecialistList);
    }
    for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
      Integer idEmployee = (Integer) it.next();
      if (idEmployee != null) {
        Todo todo = createTodo(idPerson, idStage, idCase, cdTask);
        todo.setDtTodoDue(DateHelper.addToDate(new Date(), 0, 0, 45));
        todo.setTxtTodoDesc("Investigation Concurrence Memo is due for " + capsCase.getNmCase() + ".");
        todo.setCdTodoTask("");
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
        todoDAO.saveTodo(todo);
      }
    }
  }
  
  private void sendAlertsForSpclInvConcurrenceDecision(int idPerson, int idStage, int idCase, int idResource, String cdTask, String decision) {
     List<Integer> personList = new ArrayList<Integer>();
     Stage stage = getPersistentObject(Stage.class, idStage);
     // Find the Primary Case Manager and add it to the list of persons that need to get the alert
     int idCaseManager = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_HP);
     
     // Find the Unit Supervisor and add it to the list of persons that need to get the alert
     int idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCaseManager);
     personList.add(idCaseManager);
     personList.add(idSupervisor);
     // Policy Specialist
     List<Integer> policySpecialistList = unitEmpLinkDAO
                                                        .findEmployeeByCdSecurityClassName(PRU_STAFF_SECURITY_CLASS_NAME);
     if (listIsValid(policySpecialistList)) {
       personList.addAll(policySpecialistList);
     }
     // Deputy Director
     List<Integer> deputyDirector = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(DEPUTY_DIRECTOR_PROFILE);
     if (listIsValid(deputyDirector)) {
       personList.addAll(deputyDirector);
     }
     
     int countyDirector = retrieveCountyDirector(stage.getCdStageCnty());
     if (countyDirector != 0) {
       personList.add(countyDirector);
     }
     int regionalDirector = retrieveRegionalDirector(stage.getCdStageCnty(), idStage);
     if (regionalDirector != 0) {
       personList.add(regionalDirector);
     }

     String cdRsrcFacilType = "";
     int idHomeStage = 0;
     int idFADCaseManager = 0;
     int unitSupervisorFAD = 0;
     CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);
     cdRsrcFacilType = capsResource.getCdRsrcFacilType();
     String nmResource = capsResource.getNmResource();
     if(capsResource.getStage() != null){
       idHomeStage = capsResource.getStage().getIdStage();
     }

     if(idHomeStage != 0){
       //Get the primary case worker assigned to the FAD stage.
       idFADCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idHomeStage); 
       
       //Get the unit supervisor of the primary case manager assigned to the FAD stage.
       Integer unitSupervisorObj = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idFADCaseManager);
       unitSupervisorFAD = unitSupervisorObj != null ? unitSupervisorObj : 0;
     }
     
     if (SPCL_INV_RSRC_TYPE_ONE.contains(cdRsrcFacilType)) {
       if (idFADCaseManager > 0) {
         personList.add(idFADCaseManager);
       }
       if (unitSupervisorFAD > 0) {
         personList.add(unitSupervisorFAD);
       }
    } else if (SPCL_INV_RSRC_TYPE_TWO.contains(cdRsrcFacilType)) {
      // Office of Provider Relations/State Resource Developer
      List<Integer> offcProvdrMaintList = unitEmpLinkDAO
                                                    .findEmployeeByCdSecurityClassName(OFFICE_PROVIDER_MAINTENANCE);
      if (listIsValid(offcProvdrMaintList)) {
        personList.addAll(offcProvdrMaintList);
      }
      
      // Send alert to Office of Provider Specialist and PRU director 
      List<Integer> pruDirectorList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(PRU_DIRECTOR_SECURITY_CLASS_NAME);
      if (listIsValid(pruDirectorList)) {
        personList.addAll(pruDirectorList);
      }
      
      // Special Investigations Unit
      Unit si = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(CodesTables.CCOUNT_XXX, STATE_OFFICE_REGION,
                                                                     NBR_UNIT_SPCL_INVESTIGATION);
      if (si != null) {
        personList.add(si.getPerson().getIdPerson());
      }
    }
     
    for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
      Integer idEmployee = (Integer) it.next();
      if (idEmployee != null) {
        Todo todo = createTodo(idPerson, idStage, idCase, cdTask);
        todo.setTxtTodoDesc(ALERT_SPCL_INV_CONCUR_START + decision + ALERT_SPCL_INV_CONCUR_END);
        todo.setTxtTodoLongDesc(ALERT_SPCL_INV_CONCUR_START + decision + " with the assessment disposition for " + nmResource);
        todo.setCdTodoTask("");
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
        todoDAO.saveTodo(todo);
      }
    }
  }
  
  private void sendAlertsForSpclInvActionRecmnd(int idPerson, int idStage, int idCase, int idResource, String cdTask, String recommend) {
    List<Integer> personList = new ArrayList<Integer>();
    Stage stage = getPersistentObject(Stage.class, idStage);
    // Find the Primary Case Manager and add it to the list of persons that need to get the alert
    int idCaseManager = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_HP);
    
    // Find the Unit Supervisor and add it to the list of persons that need to get the alert
    int idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCaseManager);
    personList.add(idCaseManager);
    personList.add(idSupervisor);
    
    // Policy Specialist
    List<Integer> policySpecialistList = unitEmpLinkDAO
                                                       .findEmployeeByCdSecurityClassName(PRU_STAFF_SECURITY_CLASS_NAME);
    if (listIsValid(policySpecialistList)) {
      personList.addAll(policySpecialistList);
    }
    // Deputy Director
    List<Integer> deputyDirector = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(DEPUTY_DIRECTOR_PROFILE);
    if (listIsValid(deputyDirector)) {
      personList.addAll(deputyDirector);
    }
    int countyDirector = retrieveCountyDirector(stage.getCdStageCnty());
    if (countyDirector != 0) {
      personList.add(countyDirector);
    }
    int regionalDirector = retrieveRegionalDirector(stage.getCdStageCnty(), idStage);
    if (regionalDirector != 0) {
      personList.add(regionalDirector);
    } 
    
    int idHomeStage = 0;
    String cdRsrcFacilType = "";
    int idFADCaseManager = 0;
    int unitSupervisorFAD = 0;
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);
    cdRsrcFacilType = capsResource.getCdRsrcFacilType();
    String nmResource = capsResource.getNmResource();
    if(capsResource.getStage() != null){
      idHomeStage = capsResource.getStage().getIdStage();
    }

    if(idHomeStage != 0){
      //Get the primary case worker assigned to the FAD stage.
      idFADCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idHomeStage);

      //Get the unit supervisor of the primary case manager assigned to the FAD stage.
      Integer unitSupervisorObj = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idFADCaseManager);
      unitSupervisorFAD = unitSupervisorObj != null ? unitSupervisorObj : 0;
      
    }
    
    if (SPCL_INV_RSRC_TYPE_ONE.contains(cdRsrcFacilType)) {
      if (idFADCaseManager > 0) {
        personList.add(idFADCaseManager);
      }
      if (unitSupervisorFAD > 0) {
        personList.add(unitSupervisorFAD);
      }
    } else if (SPCL_INV_RSRC_TYPE_TWO.contains(cdRsrcFacilType)) {
     // Office of Provider Relations/State Resource Developer
     List<Integer> offcProvdrMaintList = unitEmpLinkDAO
                                                   .findEmployeeByCdSecurityClassName(OFFICE_PROVIDER_MAINTENANCE);
     if (listIsValid(offcProvdrMaintList)) {
       personList.addAll(offcProvdrMaintList);
     }

     // Send alert to Office of Provider Specialist and PRU director 
     List<Integer> pruDirectorList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(PRU_DIRECTOR_SECURITY_CLASS_NAME);
     if (listIsValid(pruDirectorList)) {
       personList.addAll(pruDirectorList);
     }
     
     // Special Investigations Unit
     Unit si = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(CodesTables.CCOUNT_XXX, STATE_OFFICE_REGION,
                                                                    NBR_UNIT_SPCL_INVESTIGATION);
     if (si != null) {
       personList.add(si.getPerson().getIdPerson());
     }
   }
    
   String alertText = "State Office " + recommend + " with the action that the county has recommended.";
   for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
     Integer idEmployee = (Integer) it.next();
     if (idEmployee != null) {
       Todo todo = createTodo(idPerson, idStage, idCase, cdTask);
       todo.setTxtTodoDesc(alertText);
       todo.setTxtTodoLongDesc(alertText);
       todo.setCdTodoTask("");
       todo.setCdTodoType(CodesTables.CTODOTYP_A);
       todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
       todoDAO.saveTodo(todo);
     }
   }
 }
  
  // Corey CO-CAPTA4.3-5.3.16 - alert relevant persons that home is no longer on hold
  private void sendAlertsForCpsInvCnclsnToRemoveHoldFromHold(int idPerson, String cdTask, int idCpsInvCclsnCase, String nmResource, int idCpsInvCclsnStage, int idResource, int idHomeStage) {
    // create variables for method
    int idFADCaseManager = 0;
    int unitSupervisorFAD = 0;
    boolean rsrcHasFADStage = true;
    List<Integer> personList = new ArrayList<Integer>();
    String shortDesc = "A home is no longer on hold.";
    String longDesc = nmResource + " is no longer on hold.";
    
    // Find the Primary Case Manager and add it to the list of persons that need to get the alert
    int idCaseManager = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idCpsInvCclsnStage, CodesTables.CROLEALL_PR);
    // Find the Unit Supervisor and add it to the list of persons that need to get the alert
    int idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCaseManager);
   
    if (idHomeStage != 0) {
      // Get the primary case worker assigned to the FAD stage.
      idFADCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idHomeStage);

      // Get the unit supervisor of the primary case manager assigned to the FAD stage.
      Integer unitSupervisorObj = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idFADCaseManager);
      unitSupervisorFAD = unitSupervisorObj != null ? unitSupervisorObj : 0;
    } else {
      rsrcHasFADStage = false;
    }

    // Take the home off of hold
    if (rsrcHasFADStage) {
      personList.add(idCaseManager);
      personList.add(idSupervisor);
      if (idFADCaseManager > 0) {
        personList.add(idFADCaseManager);
      }
      if (unitSupervisorFAD > 0) {
        personList.add(unitSupervisorFAD);
      }

      // Get the Case Managers of the Children placed in the Home
      List<Integer> caseManagersOfChildrenPlacedInResourceList = stagePersonLinkDAO.findStagePersonLinkByIdResource(idResource);
      List<Integer> supervisorOfCMOfChildrenPlacedInResourceList = new ArrayList<Integer>();
      if (listIsValid(caseManagersOfChildrenPlacedInResourceList)) {
        personList.addAll(caseManagersOfChildrenPlacedInResourceList);
        Iterator<Integer> iterCM = caseManagersOfChildrenPlacedInResourceList.iterator();
        while (iterCM.hasNext()) {
          Integer idCM = (Integer) iterCM.next();
          // Get the unit supervisor of the primary case manager assigned to the child's stage.
          Integer unitSupervisorCMChild = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCM);
          supervisorOfCMOfChildrenPlacedInResourceList.add(unitSupervisorCMChild);
        }
        if (listIsValid(supervisorOfCMOfChildrenPlacedInResourceList)) {
          personList.addAll(supervisorOfCMOfChildrenPlacedInResourceList);
        }
      }
      
      for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
        Integer idEmployee = (Integer) it.next();
        if (idEmployee != null) {
          Todo todo = createTodo(idPerson, idCpsInvCclsnStage, idCpsInvCclsnCase, cdTask);
          todo.setTxtTodoDesc(shortDesc);
          todo.setTxtTodoLongDesc(longDesc);
          todo.setCdTodoTask("");
          todo.setCdTodoType(CodesTables.CTODOTYP_A);
          todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
          todoDAO.saveTodo(todo);
        }
      }
    }
  }
  
  private void sendAlertsForSpclInvStateOfficeConcursAndRemoveHoldOnHome(int idPerson, String cdTask, SpclInvestigationRetrieveSO spclInvestigationRetrieveSO) {
    List<Integer> personList = new ArrayList<Integer>();
    int idCpsInvCclsnStage = spclInvestigationRetrieveSO.getIdStage();
    int idCpsInvCclsnCase = spclInvestigationRetrieveSO.getIdCase();
    int idResource = spclInvestigationRetrieveSO.getIdResource();
    Stage stage = getPersistentObject(Stage.class, idCpsInvCclsnStage);
    // Find the Primary Case Manager and add it to the list of persons that need to get the alert
    int idCaseManager = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idCpsInvCclsnStage, CodesTables.CROLEALL_HP);

    // Find the Unit Supervisor and add it to the list of persons that need to get the alert
    int idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCaseManager);
    
    int idHomeStage = 0;
    int idFADCaseManager = 0;
    int unitSupervisorFAD = 0;
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);
    String nmResource = capsResource.getNmResource();
    if(capsResource.getStage() != null){
      idHomeStage = capsResource.getStage().getIdStage();
    }
    boolean rsrcHasFADStage = true;
    if(idHomeStage != 0){
      //Get the primary case worker assigned to the FAD stage.
      idFADCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idHomeStage);

      //Get the unit supervisor of the primary case manager assigned to the FAD stage.
      Integer unitSupervisorObj = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idFADCaseManager);
      unitSupervisorFAD = unitSupervisorObj != null ? unitSupervisorObj : 0;
      
    } else {
      rsrcHasFADStage = false;
    }
    
    int countyDirector = retrieveCountyDirector(stage.getCdStageCnty());
    

    // Policy Specialist
    List<Integer> policySpecialistList = unitEmpLinkDAO
                                                       .findEmployeeByCdSecurityClassName(PRU_STAFF_SECURITY_CLASS_NAME);
    // Deputy Director
    List<Integer> deputyDirector = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(DEPUTY_DIRECTOR_PROFILE);
    
    // Office of Provider Relations/State Resource Developer
    List<Integer> offcProvdrMaintList = unitEmpLinkDAO
                                                  .findEmployeeByCdSecurityClassName(OFFICE_PROVIDER_MAINTENANCE);
    
    List<SpclInvHmeWaiverChildHistBean> waiverChildren = spclInvestigationRetrieveSO.getSpclInvHmeWaiverChildHistBeans();
    List<Integer> childrenWithWaiver = new ArrayList<Integer>();
    List<Integer> childrenWithoutWaiver = new ArrayList<Integer>();
    if (ServiceConstants.FND_YES.equals(spclInvestigationRetrieveSO.getIndConcurAssmntDisp()) 
                    && ServiceConstants.FND_YES.equals(spclInvestigationRetrieveSO.getIndInvMaltreatInCare())) {
      if (listIsValid(waiverChildren)) {
        for (SpclInvHmeWaiverChildHistBean w : waiverChildren) {
          if (ServiceConstants.FND_YES.equals(w.getIndRemainInHome())) {
            childrenWithWaiver.add(w.getIdChild());
          } else {
            childrenWithoutWaiver.add(w.getIdChild());
          }
        }
        if (listIsValid(childrenWithWaiver)) {
          if (idFADCaseManager > 0) {
            personList.add(idFADCaseManager);
          }
          if (unitSupervisorFAD > 0) {
            personList.add(unitSupervisorFAD);
          }
          personList.add(idCaseManager);
          personList.add(idSupervisor);
          if (countyDirector != 0) {
            personList.add(countyDirector);
          }
          if (listIsValid(policySpecialistList)) {
            personList.addAll(policySpecialistList);
          }
          // Send alert to Office of Provider Maintenance
          if (listIsValid(offcProvdrMaintList)) {
            personList.addAll(offcProvdrMaintList);
          }
          
          if (listIsValid(deputyDirector)) {
            personList.addAll(deputyDirector);
          }
          // Get the Case Managers of the Children with a waiver that's placed in the Home
          List<Integer> caseManagersOfChildrenWithWaiver = new ArrayList<Integer>();
          List<Integer> supervisorOfCMOfChildrenWithWaiver = new ArrayList<Integer>();
          for (int i = 0; i < childrenWithWaiver.size(); i++) {
            Integer id = childrenWithWaiver.get(i);
            Integer idSUBCaseManager = stagePersonLinkDAO.findSUBCaseManagerByIdChild(id);
            if (idSUBCaseManager != null && idSUBCaseManager > 0) {
              caseManagersOfChildrenWithWaiver.add(idSUBCaseManager);
            }
          }
          if (listIsValid(caseManagersOfChildrenWithWaiver)) {
            personList.addAll(caseManagersOfChildrenWithWaiver);
            Iterator<Integer> iterCM = caseManagersOfChildrenWithWaiver.iterator();
            while (iterCM.hasNext()) {
              Integer idCM = (Integer) iterCM.next();
              // Get the unit supervisor of the primary case manager assigned to the child's stage.
              Integer unitSupervisorCMChild = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCM);
              supervisorOfCMOfChildrenWithWaiver.add(unitSupervisorCMChild);
            }
            if (listIsValid(supervisorOfCMOfChildrenWithWaiver)) {
              personList.addAll(supervisorOfCMOfChildrenWithWaiver);
            }
          }
          String shortDesc = "State Office concurs with MIC and a child is identified on the Home Waiver.";
          for (Integer i : childrenWithWaiver) {
            String longDesc = "State Office concurs with substantiated Maltreatment in Care and "
                               + personDAO.findNmFullByIdPerson(i) + " has been identified on the Home Waiver for "
                               + nmResource + ".";
            for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
              Integer idEmployee = (Integer) it.next();
              if (idEmployee != null) {
                Todo todo = createTodo(idPerson, idCpsInvCclsnStage, idCpsInvCclsnCase, cdTask);
                todo.setTxtTodoDesc(shortDesc);
                todo.setTxtTodoLongDesc(longDesc);
                todo.setCdTodoTask("");
                todo.setCdTodoType(CodesTables.CTODOTYP_A);
                todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
                todoDAO.saveTodo(todo);
              }
            }
          }
        }
        // Clear the list of persons receiving the previous alert
        personList.clear();
        if (listIsValid(childrenWithoutWaiver)) {
          personList.add(idCaseManager);
          personList.add(idSupervisor);
          if (idFADCaseManager > 0) {
            personList.add(idFADCaseManager);
          }
          if (unitSupervisorFAD > 0) {
            personList.add(unitSupervisorFAD);
          }
          if (countyDirector != 0) {
            personList.add(countyDirector);
          }
          
          // Get the Case Managers of the Children without a waiver that's placed in the Home
          List<Integer> caseManagersOfChildrenWithoutWaiver = new ArrayList<Integer>();
          List<Integer> supervisorOfCMOfChildrenWithoutWaiver = new ArrayList<Integer>();
          for (int i = 0; i < childrenWithoutWaiver.size(); i++) {
            Integer id = childrenWithoutWaiver.get(i);
            Integer idSUBCaseManager = stagePersonLinkDAO.findSUBCaseManagerByIdChild(id);
            if (idSUBCaseManager != null && idSUBCaseManager > 0) {
              caseManagersOfChildrenWithoutWaiver.add(idSUBCaseManager);
            }
          }
          if (listIsValid(caseManagersOfChildrenWithoutWaiver)) {
            personList.addAll(caseManagersOfChildrenWithoutWaiver);
            Iterator<Integer> iterCM = caseManagersOfChildrenWithoutWaiver.iterator();
            while (iterCM.hasNext()) {
              Integer idCM = (Integer) iterCM.next();
              // Get the unit supervisor of the primary case manager assigned to the child's stage.
              Integer unitSupervisorCMChild = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCM);
              supervisorOfCMOfChildrenWithoutWaiver.add(unitSupervisorCMChild);
            }
            if (listIsValid(supervisorOfCMOfChildrenWithoutWaiver)) {
              personList.addAll(supervisorOfCMOfChildrenWithoutWaiver);
            }

          }
          String shortDesc = "State Office concurs with MIC - remove children not listed on the Home Waiver.";
          String longDesc = "State Office concurs with substantiated Maltreatment in Care at " + nmResource
                             + " - remove all children not listed on the Home Waiver.";
          for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
            Integer idEmployee = (Integer) it.next();
            if (idEmployee != null) {
              Todo todo = createTodo(idPerson, idCpsInvCclsnStage, idCpsInvCclsnCase, cdTask);
              todo.setTxtTodoDesc(shortDesc);
              todo.setTxtTodoLongDesc(longDesc);
              todo.setCdTodoTask("");
              todo.setCdTodoType(CodesTables.CTODOTYP_A);
              todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
              todoDAO.saveTodo(todo);
            }
          }
        }
      } else {
        String shortDesc = "State Office concurs with substantiated Maltreatment in Care - close the home.";
        String longDesc = "State Office concurs with substantiated Maltreatment in Care at " + nmResource + " - close the home.";
        if (idFADCaseManager > 0) {
          personList.add(idFADCaseManager);
        }
        if (unitSupervisorFAD > 0) {
          personList.add(unitSupervisorFAD);
        }
        personList.add(idCaseManager);
        personList.add(idSupervisor);
        if (countyDirector != 0) {
          personList.add(countyDirector);
        }
        if (listIsValid(policySpecialistList)) {
          personList.addAll(policySpecialistList);
        }
        // Send the alert to the Deputy Director
        if (listIsValid(deputyDirector)) {
          personList.addAll(deputyDirector);
        }
        for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
          Integer idEmployee = (Integer) it.next();
          if (idEmployee != null) {
            Todo todo = createTodo(idPerson, idCpsInvCclsnStage, idCpsInvCclsnCase, cdTask);
            todo.setTxtTodoDesc(shortDesc);
            todo.setTxtTodoLongDesc(longDesc);
            todo.setCdTodoTask("");
            todo.setCdTodoType(CodesTables.CTODOTYP_A);
            todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
            todoDAO.saveTodo(todo);
          }
        }
      }
    } 
    // Take the home off of hold
    else {
      if (rsrcHasFADStage) {
        capsResourceDAO.updateCapsResourceIndHoldPlacements(idResource, ServiceConstants.FND_NO);
        if (idFADCaseManager > 0) {
          personList.add(idFADCaseManager);
        }
        if (unitSupervisorFAD > 0) {
          personList.add(unitSupervisorFAD);
        }
        personList.add(idCaseManager);
        personList.add(idSupervisor);
        if (countyDirector != 0) {
          personList.add(countyDirector);
        }
        if (listIsValid(policySpecialistList)) {
          personList.addAll(policySpecialistList);
        }
        // Send the alert to the Deputy Director
        if (listIsValid(deputyDirector)) {
          personList.addAll(deputyDirector);
        }
        //Get the Case Managers of the Children placed in the Home
        List<Integer> caseManagersOfChildrenPlacedInResourceList = stagePersonLinkDAO.findStagePersonLinkByIdResource(idResource);
        List<Integer> supervisorOfCMOfChildrenPlacedInResourceList = new ArrayList<Integer>();
        if (listIsValid(caseManagersOfChildrenPlacedInResourceList)) {
          personList.addAll(caseManagersOfChildrenPlacedInResourceList);
          Iterator<Integer> iterCM = caseManagersOfChildrenPlacedInResourceList.iterator();
          while (iterCM.hasNext()) {
            Integer idCM = (Integer) iterCM.next();
            //Get the unit supervisor of the primary case manager assigned to the child's stage.
            Integer unitSupervisorCMChild = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCM);
            supervisorOfCMOfChildrenPlacedInResourceList.add(unitSupervisorCMChild);
          }
          if (listIsValid(supervisorOfCMOfChildrenPlacedInResourceList)) {
            personList.addAll(supervisorOfCMOfChildrenPlacedInResourceList);
          }
        }
        String shortDesc = "A home is no longer on hold.";
        String longDesc = nmResource + " is no longer on hold.";
        for (Iterator<Integer> it = personList.iterator(); it.hasNext();) {
          Integer idEmployee = (Integer) it.next();
          if (idEmployee != null) {
            Todo todo = createTodo(idPerson, idCpsInvCclsnStage, idCpsInvCclsnCase, cdTask);
            todo.setTxtTodoDesc(shortDesc);
            todo.setTxtTodoLongDesc(longDesc);
            todo.setCdTodoTask("");
            todo.setCdTodoType(CodesTables.CTODOTYP_A);
            todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
            todoDAO.saveTodo(todo);
          }
        }
      }
    }
 }
  
  private void sendAlertsforApprovedAdoptAssistanceApplication(CCMN35SI ccmn35si, SpecialNeedsDetermination spd, String cdAppTask) {	  
    int idCase = ccmn35si.getUlIdCase();
    int idStage = ccmn35si.getUlIdStage();
    CapsCase capsCase;
    capsCase = getPersistentObject(CapsCase.class, idCase);

    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    String stageName = stage.getNmStage();

    if (ADO_ASSIST_APP_TASK.equals(cdAppTask)) {
      String cdCounty = capsCase.getCdCaseCounty();
      if (cdCounty != null) {
        if (cdCounty.length() == 1) {
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2) {
          cdCounty = "0" + cdCounty;
        }
      }
      // Get the region of the county
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
      List<Integer> regionalPersonList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);

      // alert Special needs determination has been completed
      if (regionalPersonList != null && !regionalPersonList.isEmpty()) {
        Iterator<Integer> itrSauList = regionalPersonList.iterator();
        List<Todo> todoList3 = new ArrayList<Todo>();
        while (itrSauList.hasNext()) {
          int idAssigned = (Integer) itrSauList.next();
          Todo todo3 = new Todo();
          String cdTask = "";
          todo3.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          String todoDesc = stageName + " Adoption Assistance Application has been completed";
          todoDesc = (todoDesc.length() > 80) ? todoDesc.substring(0, 80) : todoDesc;
          todo3.setTxtTodoDesc(todoDesc);
          todo3.setCdTodoTask(cdTask);
          todo3.setCdTodoType(CodesTables.CTODOTYP_A);
          todo3.setDtTodoDue(new Date());
          todo3.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, ccmn35si.getUlIdPerson()));
          todo3.setDtTodoCreated(new Date());
          todo3.setStage(getPersistentObject(Stage.class, idStage));
          todoList3.add(todo3);
        }
        complexTodoDAO.saveTodo(todoList3);
      }
    }
    // SMS#97845 MR-074-2 AFCARS: send alert to CM and supervisor if application is approved for non-incident child in
    // PAD
    else if (PAD_ADO_ASSIST_APP_TASK.equals(cdAppTask) && ArchitectureConstants.N.equals(spd.getIndIncidentChild())) {
      // Populate saveSI object, this is system created alert so no need to set idPersonCreator
      TodoAlertSaveSI todoAlertSaveSI = new TodoAlertSaveSI();
      String desc = "Please ensure the Non-Incident AFCARS Information page for " + stageName + " has been completed.";
      Person personSup = retrieveUnitSupervisorByCaseManagerId(ccmn35si.getUlIdPerson());
      List<Integer> idTodoPersAssignedList = new ArrayList<Integer>();
      idTodoPersAssignedList.add(ccmn35si.getUlIdPerson());
      if (personSup != null) {
        idTodoPersAssignedList.add(personSup.getIdPerson());
      }
      todoAlertSaveSI.setDueDate(new Date());
      todoAlertSaveSI.setIdStage(idStage);
      todoAlertSaveSI.setTxtTodoShortDesc(desc);
      todoAlertSaveSI.setTxtTodoLongDesc(desc);
      todoAlertSaveSI.setIdTodoPersAssignedList(idTodoPersAssignedList);
      // Call the saveTodo service
      saveTodo.saveTodoAlert(todoAlertSaveSI);
    }
  }

  private void sendAlertsForHomeReEvaluation(CCMN35SI ccmn35si){
    // Alert needs to go to the Regional Adoption Exchange Consultants
    int idCase = ccmn35si.getUlIdCase();
    int idStage = ccmn35si.getUlIdStage();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    // Only send the alert to the Regional Adoption Exchange Consultants
    String cdCounty = capsCase.getCdCaseCounty();
    if(cdCounty != null){
      if(cdCounty.length() == 1 ){
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2){
        cdCounty = "0" + cdCounty;
      }
    }
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

    if (listIsValid(adoExchangeConsultants)) {
      Iterator<Integer> itrAdoExchangeConsultants = adoExchangeConsultants.iterator();
      List<Todo> todoList3 = new ArrayList<Todo>();
      while (itrAdoExchangeConsultants.hasNext()) {
        int idAssigned = (Integer) itrAdoExchangeConsultants.next();
        Todo todo3 = new Todo();
        String cdTask = "";
        todo3.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
        todo3.setTxtTodoDesc("Home re-evaluation has been approved by the county");
        todo3.setCdTodoTask(cdTask);
        todo3.setCdTodoType(CodesTables.CTODOTYP_A);
        todo3.setDtTodoDue(new Date());
        todo3.setPersonByIdTodoPersWorker(getPersistentObject(
                        Person.class, ccmn35si.getUlIdPerson()));
        todo3.setDtTodoCreated(new Date());
        todo3.setStage(getPersistentObject(Stage.class,idStage));
        todoList3.add(todo3);
      }

      complexTodoDAO.saveTodo(todoList3);
      
    }

  }

  public void setSaveStageClosureAlerts(SaveStageClosureAlerts saveStageClosureAlerts) {
    this.saveStageClosureAlerts = saveStageClosureAlerts;
  }
  
  //STGAP00014329: Sending alerts for approved safety resources
  private void sendAlertsforApprovedSafetyResource(CCMN35SI ccmn35si, int idEvent) {       
    int idStage = ccmn35si.getUlIdStage();

    //Get the primary case worker assigned to the stage where the safety resource record is documented.
    Integer idPrimaryCaseWorkerObj = stagePersonLinkDAO.findIdCaseWorkerByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_PR);
    int idPrimaryCaseWorker = idPrimaryCaseWorkerObj != null ? idPrimaryCaseWorkerObj : 0;

    //Get the unit supervisor of the primary case manager assigned to the stage where the safety resource record is documented.
    Integer unitSupervisorObj = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idPrimaryCaseWorker);
    int unitSupervisor = unitSupervisorObj != null ? unitSupervisorObj : 0;

    //Get the Primary Safety Resource Name
    int idPrimary = 0;
    String nmPrimary = "";
    SafetyResource  safetyResource = safetyResourceDAO.findSafetyResourceByIdEvent(idEvent);
    if(safetyResource != null){
      idPrimary = safetyResource.getIdPrimary() != null ? safetyResource.getIdPrimary() : 0;
      nmPrimary = personDAO.findNmFullByIdPerson(idPrimary);
    }

    Date today = new Date();
    
    List<Todo> todoList = new ArrayList<Todo>();
    
    //Alert for Primary Case Worker
    Todo todo = new Todo();
    String cdTask = "";
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPrimaryCaseWorker));
    String todoDesc = "Safety resource approval for " + nmPrimary + " expires in 15 days.";
    todoDesc = (todoDesc.length() > 80) ? todoDesc.substring(0, 80) : todoDesc;
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(DateHelper.addToDate(today, 0, 0, 30));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, ccmn35si.getUlIdPerson()));
    todo.setDtTodoCreated(new Date());
    todo.setStage(getPersistentObject(Stage.class,idStage));
    todoList.add(todo);
    
    //Alert for Unit Supervisor of Primary Case Worker
    Todo todo1 = new Todo();
    todo1.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, unitSupervisor));
    todoDesc = (todoDesc.length() > 80) ? todoDesc.substring(0, 80) : todoDesc;
    todo1.setTxtTodoDesc(todoDesc);
    todo1.setCdTodoTask(cdTask);
    todo1.setCdTodoType(CodesTables.CTODOTYP_A);
    todo1.setDtTodoDue(DateHelper.addToDate(today, 0, 0, 30));
    todo1.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, ccmn35si.getUlIdPerson()));
    todo1.setDtTodoCreated(new Date());
    todo1.setStage(getPersistentObject(Stage.class,idStage));
    todoList.add(todo1);
    
    complexTodoDAO.saveTodo(todoList);
  }
  
  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }
  
  @SuppressWarnings({"unchecked"})
  private Integer retrieveCountyDirector(String cdCounty) {
    Map map = new HashMap();
    Integer idStaff = null;
    String cdStageRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Find the County Director for the stage's county and add the person to the list of
    // those to receive the alert
    Unit cd = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(cdCounty, cdStageRegion, NBR_UNIT_COUNTY_DIRECTOR);
    if (cd != null) {
      String nmPerson = personDAO.findNmFullByIdPerson(cd.getPerson().getIdPerson());
      idStaff  = cd.getPerson().getIdPerson();
      // Some counties do not have a county director; rather they have a vacant person and an actual
      // employee is designated to perform the work for the vacant person. In this situation,
      // find the designee and assign the alert to them.
      if (nmPerson.indexOf(VACANT_PERSON) >= 0) {
        List<EmpTempAssign> temps = empTempAssignDAO.findIdsemp(cd.getPerson().getIdPerson());
        if (listIsValid(temps)) {
          EmpTempAssign temp = temps.get(0);
          idStaff = temp.getPersonByIdPersonDesignee().getIdPerson();
        }
      }
    }
    if(idStaff == null) {
      idStaff = 0;
    } 
    return idStaff; 
  }
  
  @SuppressWarnings({"unchecked"})
  private Integer retrieveRegionalDirector(String cdCounty, int idStage) {
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    Map map = new HashMap();
    Integer idStaff = null;
    String cdStageRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Find the County Director for the stage's county and add the person to the list of
    // those to receive the alert
    Unit cd = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(CodesTables.CCOUNT_XXX, cdStageRegion, stage.getCdStageRegion());
    if (cd != null) {
      String nmPerson = personDAO.findNmFullByIdPerson(cd.getPerson().getIdPerson());
      idStaff  = cd.getPerson().getIdPerson();
      // Some counties do not have a county director; rather they have a vacant person and an actual
      // employee is designated to perform the work for the vacant person. In this situation,
      // find the designee and assign the alert to them.
      if (nmPerson.indexOf(VACANT_PERSON) >= 0) {
        List<EmpTempAssign> temps = empTempAssignDAO.findIdsemp(cd.getPerson().getIdPerson());
        if (listIsValid(temps)) {
          EmpTempAssign temp = temps.get(0);
          idStaff = temp.getPersonByIdPersonDesignee().getIdPerson();
        }
      }
    }
    if(idStaff == null) {
      idStaff = 0;
    } 
    return idStaff; 
  }
  
  /**
   * MR-062 This method saves the dtEfectiveStart and dtEffectiveEnd to the ContactStandards
   * @param idStage
   * @param idEvent
   */
  private void saveContactStandardsEffectiveDates(int idStage, int idEvent){
    ContactStandards contactStandards = contactStandardsDAO.findContactStandardsByIdEvent(idEvent);
    Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    //Get the first day of next month from today
    Date dtEffectiveStart = DateHelper.getFirstDayOfTheMonth(DateHelper.addToDate(dtToday, 0, 1, 0));
    if(contactStandards != null){
      //Save the first day of next month from today to the Contact Standards being approved
      contactStandards.setDtEffectiveStart(dtEffectiveStart);
      contactStandardsDAO.saveContactStandards(contactStandards);

      List<ContactStandards> contactStandardsList = contactStandardsDAO.findApprovedContactStandards(idStage);

      if(contactStandardsList != null && !contactStandardsList.isEmpty()){
        Iterator<ContactStandards> iterR = contactStandardsList.iterator();
        while (iterR.hasNext()) {
          ContactStandards contactStandardsApproved = (ContactStandards) iterR.next();
          Date dtEffectiveStartApproved  = contactStandardsApproved.getDtEffectiveStart();
          //If the Approved Contact Standards has same date effective start as the current one then put null 
          //for date effective start in the Approved one ELSE put effective End date in the Approved Contact Standard
          if(dtEffectiveStartApproved.compareTo(dtEffectiveStart) == 0){
            contactStandardsApproved.setDtEffectiveStart(null);
          }else{
            contactStandardsApproved.setDtEffectiveEnd(DateHelper.getLastDayOfTheMonth(dtToday));
          }
          contactStandardsDAO.saveContactStandards(contactStandardsApproved);
        }
      }
    }
  }
  
  /**
   * MR-087 This method send any alerts needed on Approval of Payment of Care
   * @param CCMN35SI
   */
  private void sendAlertsForApprovedPaymentOfCare(CCMN35SI ccmn35si) {
    PaymentOfCare poc = paymentOfCareDAO.findPOC(ccmn35si.getUlIdEvent());
    
    // MR-087 Only send Court Review Due alert for Relative Care Subsidy and Enhanced Relative Care Subsidies
    // And only send alert if court review due by date exists
    if (null != poc && (null != poc.getDtCourt()
                    && (CodesTables.CPOCTYPE_RCS.equals(poc.getCdPocType()) 
                                    || CodesTables.CPOCTYPE_ERS.equals(poc.getCdPocType())))) {
      
      Integer idPersonObj = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(ccmn35si.getUlIdStage(), CodesTables.CROLEALL_PR);
      Person cm = getPersistentObject(Person.class, (idPersonObj != null ? idPersonObj.intValue() : 0));
      String cdTask = "";
      
      // Get the greater of current date or 60 days prior to court review due by date
      Date todoDueDate = DateHelper.addToDate(poc.getDtCourt(), 0, 0, -60);
      if( DateHelper.isAfter(new Date(), todoDueDate)){
        todoDueDate = new Date();
      }

      Todo todo = new Todo();
      String todoDesc = "Court review due for relative custody.";
      todo.setEvent(poc.getEvent());
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(todoDueDate);
      todo.setPersonByIdTodoPersAssigned(cm);
      todo.setPersonByIdTodoPersWorker(cm);
      todo.setDtTodoCreated(new Date());
      todo.setCapsCase(poc.getEvent().getCapsCase());
      todo.setStage(poc.getEvent().getStage());
      todoDAO.saveTodo(todo);
    }
  }
  
  /**
   * CAPTA 4.3 
   * This method gets the list of employee ids for a perticular Security profile.
   * @param securityClassName
   * @return
   */
  private List<Integer> getEmployeeListBySecurityClass(String securityClassName){
    List<Integer> empList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(securityClassName);
    return empList;
  }
  
  private List<Integer> getStateOfficeResourceDeveloperList() {
    List<Integer> empList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(OFFICE_PROVIDER_MAINTENANCE);
    return empList;
    
  }

}
