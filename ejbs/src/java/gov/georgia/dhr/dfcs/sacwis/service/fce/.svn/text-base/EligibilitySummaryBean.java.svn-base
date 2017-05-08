package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CfpDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveChildSupportReferralOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSupRefOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;

import org.grnds.facility.log.GrndsTrace;

/**
 * <p>Title: EligibilitySummaryBean</p> <p>Copyright: Copyright (c) 2007</p> <p>Company: GA DHR</p>
 * <p/>
 * <p/>
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 08/19/04  Todd Reser        SIR 23012 - Have to know the age to override the
 *                             Review Date as necessary
 * 08/20/04  Todd Reser        SIR 23012 - Had to move the if segment of code
 *                             and convert to use the object eventStatus
 * 12/06/04  Todd Reser        SIR 23274 Changed the YEAR to their age because
 *                             it erroneously had a +1 causing the review date
 *                             to default to the 8th day of the month 1 year
 *                             after their birthday.
 * 12/13/04  Todd Reser        SIR 23031 - If the UlIdPerson is 0 use the "Last
 *                             person updated" so that System will no longer
 *                             appear on generated Eligibility Summaries
 * 02/28/05  Todd Reser        SIR 23274 - Changed age to the age of the child
 *                             as of the Eligibility Summary Start Date, changed
 *                             a line of code to calculate review date if >= 17
 *                             instead of > 16.
 * 03/23/05  Todd Reser        SIR 23274 Had to calculate age of the child at
 *                             the time the review will be due to fix children
 *                             who are 17 at that time so they will have the
 *                             right review date
 * 04/29/05  wadesa            SIR 23313 - Added condition to check value of Start
 *                             and End Dates as well as the event status.  If
 *                             condition is true then the Review date will be saved
 *                             as null.
 * 12/18/08  wjcochran         STGAP00011595 - added a check for the ADO and PAD stages
 *                             when looking for a placement, otherwise the placement
 *                             will never be found.
 * 01/17/11  hjbaptiste        SMS#81144: Update the Eligibility table to indicate Reimbursability has not been created                            
 * </pre>
 */
@SuppressWarnings("serial")
public class EligibilitySummaryBean extends BaseFceSessionBean implements EligibilitySummary{
  public static final String TRACE_TAG = "EligibilitySummaryBean";

  public static final String TITLE_IV_E = FceConstants.TITLE_IV_E;
  public static final String STATE_PAID = FceConstants.STATE_PAID;
  public static final String MEDICAID_ASSISTANCE_ONLY = FceConstants.MEDICAID_ASSISTANCE_ONLY;
  public static final String NOT_ELIGIBLE = FceConstants.NOT_ELIGIBLE;
  public static final String NOT_ELIGIBLE_COUNTY_PAID = FceConstants.NOT_ELIGIBLE_COUNTY_PAID;

  public static final String TRANS_TYPE_ADD = CodesTables.CMEDUPTR_ADD;
  public static final String TRANS_TYPE_DENY = CodesTables.CMEDUPTR_DEN;
  public static final String TRANS_TYPE_SUSTAIN = CodesTables.CMEDUPTR_SUS;
  public static final String TRANS_TYPE_TRANSFER = CodesTables.CMEDUPTR_TRA;
  public static final String TRANS_TYPE_OPENCLOSE = CodesTables.CMEDUPTR_OPC;

  private SaveEligibility saveEligibility = null;
  private PostEvent postEvent = null;
  private SaveChildSupportReferralOutbound saveChildSupportReferralOutbound = null;
  private SaveAgencyCustodialParents saveAgencyCustodialParents = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    saveEligibility = getService(SaveEligibility.class);
    postEvent = getService(PostEvent.class);
    saveChildSupportReferralOutbound = getService(SaveChildSupportReferralOutbound.class);
    saveAgencyCustodialParents = getService(SaveAgencyCustodialParents.class);
  }

  public EligibilitySummaryDB read(long idStage, long idCase, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    try {
      connection = getConnection();

      return executeRead(connection, idStage, idCase, idEvent, idLastUpdatePerson);
    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return null;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public void save(EligibilitySummaryDB eligibilitySummaryDB, Set ignoreMessages)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    CSUB19SO csub19so = null;
    try {
      connection = getConnection();
      csub19so = executeSave(connection, eligibilitySummaryDB, ignoreMessages);
    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return ;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public void saveChildSupReferralOutbound(CSupRefOutboundSI cSupRefOutboundSI) {
    saveChildSupportReferralOutbound.saveChildSupportReferralOutbound(cSupRefOutboundSI);
  }

  public void delete(EligibilitySummaryDB eligibilitySummaryDB)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".delete");
    Connection connection = null;
    try {
      connection = getConnection();

      executeDelete(connection, eligibilitySummaryDB);
    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  protected EligibilitySummaryDB executeRead(Connection connection, long idStage, long idCase, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException, RemoteException, NamingException, FinderException, SQLException {
    
    FceContext fceContext = lookupEjb(FceInitialize.class).initializeFceEligibility(idStage, idEvent, idLastUpdatePerson);

    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    long idFceEligibility = fceContext.getIdFceEligibility();
    if (idFceEligibility != 0){
      fceEligibilityDB = fceContext.getFceEligibilityDB(lookupEjb(Fce.class));
    }
    EligibilityDB eligibilityDB = fceContext.getEligibilityDB(connection);

    EligibilitySummaryDB eligibilitySummaryDB = new EligibilitySummaryDB();
    eligibilitySummaryDB.setFceEligibility(fceEligibilityDB);

    //initializeFceEligibility doesn't create one
    if (eligibilityDB != null) {
      eligibilitySummaryDB.setEligibility(eligibilityDB);
    }
    eligibilitySummaryDB.setCdEventStatus(fceContext.getCdEventStatus(connection));
    // if ADO or PAD, set to fceContext.getIdEvent()
    String stageType = EventHelper.checkStageType(connection, idStage);
    if (EventHelper.STAGE_ADO.equals(stageType) || EventHelper.STAGE_PAD.equals(stageType)) {
      eligibilitySummaryDB.setIdEligibilityEvent(fceContext.getIdEvent());
      eligibilitySummaryDB.setIdStage(idStage);
      eligibilitySummaryDB.setIdCase(idCase);
    } else {
      eligibilitySummaryDB.setIdEligibilityEvent(idEvent);
    }
    
    long idFcePerson = fceContext.getIdFcePerson();
    if (idFcePerson != 0){
      eligibilitySummaryDB.setDtChildBirth(fceContext.getFcePersonDB(lookupEjb(Fce.class)).getDtBirth());
    }

    idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    
    List reasonsNotEligible = null;
    if (idFceEligibility != 0){
      reasonsNotEligible = ReasonNotEligibleHelper.findReasonsNotEligible(connection, idFceEligibility);
    }
    
    eligibilitySummaryDB.setReasonsNotEligible(reasonsNotEligible);

    long idFceApplication = fceContext.getIdFceApplication();
    if (idFceApplication != 0){
     eligibilitySummaryDB.setCdApplication(fceContext.getFceApplicationDB(lookupEjb(Fce.class)).getCdApplication());
    }

    eligibilitySummaryDB.setIndNoActivePlacement(true);
    eligibilitySummaryDB.setIndNonPrsPaidPlacement((Boolean) null);

    // STGAP00011595 - need to add a check for ADO or PAD stage since
    // these stages do not rely on fce information. Without this check,
    // the child will never appear to be in a placement on the eligibility summary page
    if (idFcePerson != 0 || 
        (EventHelper.STAGE_ADO.equals(stageType) || EventHelper.STAGE_PAD.equals(stageType))){
      Map activePlacement =
        PlacementHelper.findActivePlacement(connection, fceContext.getIdPerson());
      if (activePlacement != null) {
        eligibilitySummaryDB.setIndNoActivePlacement(false);
        
        String cdPlcmtType = (String) activePlacement.get("CD_PLCMT_TYPE");
        String cdPlcmtLivArr = (String) activePlacement.get("CD_PLCMT_LIV_ARR");
        
        eligibilitySummaryDB.setIndNonPrsPaidPlacement
        (PlacementHelper.isPlacementPrsPaid(cdPlcmtType, cdPlcmtLivArr) == false);
      }
    }
    
    Map medAssistance = lookupEjb(Fce.class).retrieveSuccessMedAssistance(idCase, idStage);
    if (medAssistance != null){
      eligibilitySummaryDB.setCdSuccessClassAssistance((String) medAssistance.get("cdSuccessClassAssistance"));
      eligibilitySummaryDB.setDtSuccClassAssistance((Date) medAssistance.get("dtSuccClassAssistance"));
    }
    return eligibilitySummaryDB;
  }

  protected CSUB19SO executeSave(Connection connection, EligibilitySummaryDB eligibilitySummaryDB, Set ignoreMessages)
          throws EjbValidationException, SQLException, NamingException, FinderException {
    //!!! this belongs in the conversation
    if (eligibilitySummaryDB.hasIndChildSupportOrdered() == false) {
      eligibilitySummaryDB.setIndChildSupportOrdered(false);
    }
    if (eligibilitySummaryDB.getDtEligStart() == null) {
      throw new IllegalStateException
              ("eligibilitySummaryDB.getDtEligStart() should not be null");
    }

    // Have to know the age to override the Review Date as necessary
    Date startDate = eligibilitySummaryDB.getDtEligStart();
    // Change age to the age of the child as of the Eligibility
    // Summary Start Date
    int age = DateHelper.getAge(eligibilitySummaryDB.getDtChildBirth(), startDate);
    Date startDatePlus6Months = DateHelper.addToDate(startDate, 0, 6, 0);
    Date reviewDate = startDatePlus6Months;
    Calendar cal = Calendar.getInstance();

    if (eligibilitySummaryDB.getDtEligReview() == null) {
      //csub19s will throw an obscure bug if review date is null
      //it's caused by todo end date being null
      //only debugging information you will have is an rc value of 13511
      //in the vtuxlog

      eligibilitySummaryDB.setDtEligReview(startDatePlus6Months);
    }

    FceHelper.verifyCanSave(connection, eligibilitySummaryDB);

    EligibilityDB eligibilityDB = eligibilitySummaryDB.getEligibility();

    FceEligibilityDB fceEligibilityDB = eligibilitySummaryDB.getFceEligibility();
    
    // STGAP00011166
    // idEligibilityEvent, eventStatus, dtEventOccurred, dtLastUpdate
    // have been initialized here to move them out of the null-check fce elig. if statement
    long idEligibilityEvent = eligibilitySummaryDB.getIdEligibilityEvent();
    
    String eventStatus = eligibilitySummaryDB.getCdEventStatus();
    
    Date dtEventOccurred = null;
    
    Date dtLastUpdate = null;
    
    if (fceEligibilityDB.getIdFceEligibility() != 0) {
      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);
      fceEligibilityDB = lookupEjb(Fce.class).retrieveFceEligibility(fceEligibilityDB.getIdFceEligibility());
  
      idEligibilityEvent = fceEligibilityDB.getIdEligibilityEvent();
      FceHelper.verifyNonZero("idEligibilityEvent", idEligibilityEvent);
  
      EventDB eventDB = EventHelper.findEvent(connection, idEligibilityEvent);
  
      //validate BLOC/SSI with Title IV-E
      //!!! This either needs to go below the sync or inside the custom validation
      FceHelper.syncFceEligibilityStatus(connection, fceEligibilityDB, lookupEjb(Fce.class));
  
      String selectedEligibility = eligibilityDB.getCdEligSelected();
      Double amtSsiDouble = fceEligibilityDB.getAmtSsi();
      //SIR 19384 - This check should only be done when saving a new summary.
      eventStatus = eventDB.getCdEventStatus();
  
      dtEventOccurred = eventDB.getDtEventOccurred();
      dtLastUpdate = eventDB.getDtLastUpdate();
      
      // SIR 23012 - If the child is over 16 we need to calculate the 8th day of
      // the month after their birthday
      if (age >= 17 && EventHelper.NEW_EVENT.equals(eventStatus)) {
        // Calculate the 8th day of the month after the child's next birthday
        //Set the Calendar object to their birthdate.
        cal.setTime(eligibilitySummaryDB.getDtChildBirth());
  
        //Set the day to the 8th
        cal.set(Calendar.DAY_OF_MONTH, 8);
  
        //Set the month to their birthmonth + 1
        cal.add(Calendar.MONTH, 1);
  
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + age);
  
        // At this point the reviewDate is equal to the 8th day of the month
        // following their next birthday
        reviewDate = cal.getTime();
  
        //Check if the review Date is before the Start date, and if so add 6 monnths.
        if (reviewDate.before(startDate)) {
          reviewDate = DateHelper.addToDate(reviewDate, 0, 6, 0);
        }
  
        // SIR 23274 Had to calculate age of the child at the time the review will
        // be due to fix children who are 17 at that time so they will have the
        // right review date
        int reviewAge = DateHelper.getAge(eligibilitySummaryDB.getDtChildBirth(), reviewDate);
  
        // SIR 23012 - Set the Review date to the Start Date + 6 months, or the
        // 8th day of the month after their birthday, whichever is sooner if the
        // child is under 18
        if (reviewAge < 18 || DateHelper.isBefore(startDatePlus6Months, reviewDate) && age < 18) {
          eligibilitySummaryDB.setDtEligReview(startDatePlus6Months);
        } else {
          // This else also catches if the child is over 17.
          // Set the review date to the 8th day of the month after their
          // birthday
          eligibilitySummaryDB.setDtEligReview(reviewDate);
        }
      }
  
      // Added check for following parameters-values:
      //           - dtEligStart = not null
      //           - dtEligEnd = not null
      //           - eventStatus == "NEW"
      if ("NEW".equals(
              eventStatus) && (eligibilityDB.getDtEligEnd() != null) && (eligibilityDB.getDtEligStart() != null)) {
        eligibilitySummaryDB.setDtEligReview(null);
      }
  
      if ((EventHelper.NEW_EVENT.equals(eventStatus)) &&
          (TITLE_IV_E.equals(selectedEligibility)) &&
          (CodesTables.CBILPLOC_010.equals(fceEligibilityDB.getCdBlocChild())) &&
          (amtSsiDouble != null) &&
          (amtSsiDouble > 0)) {
        throw new EjbValidationException(Messages.MSG_BLOC_EQUAL1_AND_SSI, BasePrsException.WARNING_PRIORITY);
      }
    } else {
      // if there is no FCE Eligibility, then this is in
      // the ADO or PAD stage.
      FceHelper.verifyNonZero("idEligibilityEvent", idEligibilityEvent);
      EventDB eventDB = EventHelper.findEvent(connection, idEligibilityEvent);
      dtLastUpdate = eventDB.getDtLastUpdate();
    }
  
      String eventDescription =
              Lookup.simpleDecodeSafe(CodesTables.CELIGIBI, eligibilityDB.getCdEligSelected()) +
              " Start " + eligibilityDB.getDtEligStartString();
  
      String newEventStatus = EventHelper.APPROVED_EVENT;

      long idStage = eligibilitySummaryDB.getIdStage();
      String stageType = EventHelper.checkStageType(connection, idStage);
      String taskCode = EventHelper.FCE_ELIGIBILITY_TASK_CODE;
      if (EventHelper.STAGE_ADO.equals(stageType)) {
        taskCode = EventHelper.ELIG_DETERM_ADO;
      } else if (EventHelper.STAGE_PAD.equals(stageType)) {
        taskCode = EventHelper.ELIG_DETERM_PAD;
      }

  
      if (eligibilityDB.getDtEligEnd() != null) {
        if (!(EventHelper.ELIG_DETERM_ADO.equals(taskCode) || EventHelper.ELIG_DETERM_PAD.equals(taskCode))) {
          //updates Bloc/SSI
          FceHelper.syncFceEligibilityStatus(connection, fceEligibilityDB, lookupEjb(Fce.class));
        }
  
        eventDescription += " End " + eligibilityDB.getDtEligEndString();
        newEventStatus = EventHelper.APPROVED_EVENT;
      }
        
      EligibilityDB oldEligibilityDB =
              EligibilityHelper.findLegacyEligibility(connection, idEligibilityEvent);
  
      String createOrUpdate = ServiceConstants.REQ_FUNC_CD_UPDATE;
      if (oldEligibilityDB == null) {
        createOrUpdate = ServiceConstants.REQ_FUNC_CD_ADD;
      }

    CSUB19SI csub19si = new CSUB19SI();

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(createOrUpdate);
    csub19si.setArchInputStruct(archInputStruct);

    ROWCSUB19SIG00 rowcsub19sig00 = new ROWCSUB19SIG00();
    rowcsub19sig00.setSzCdEligActual(eligibilitySummaryDB.getCdEligActual());
    rowcsub19sig00.setSzCdEligSelected(eligibilitySummaryDB.getCdEligSelected());
    rowcsub19sig00.setDtDtEligReview(DateHelper.toCastorDate(eligibilitySummaryDB.getDtEligReview()));
    rowcsub19sig00.setDtDtEligStart(DateHelper.toCastorDate(eligibilitySummaryDB.getDtEligStart()));
    rowcsub19sig00.setDtDtEligCsupReferral(DateHelper.toCastorDate(eligibilitySummaryDB.getDtEligCsupReferral()));

    Date endDate = eligibilitySummaryDB.getDtEligEnd();
    if (endDate == null) {
      rowcsub19sig00.setDtDtEligEnd(null);
    } else {
      rowcsub19sig00.setDtDtEligEnd(DateHelper.toCastorDate(endDate));
    }

    rowcsub19sig00.setUlIdEligibilityEvent((int) idEligibilityEvent);
    rowcsub19sig00.setUlIdPerson((int) eligibilitySummaryDB.getIdPerson());
    rowcsub19sig00.setUlIdPersonUpdate((int) eligibilitySummaryDB.getIdLastUpdatePerson());
    rowcsub19sig00.setSzTxtChildSuppRefComment(eligibilitySummaryDB.getTxtChildSuppRefComment());
    rowcsub19sig00.setSzTxtEligComment(eligibilitySummaryDB.getTxtEligComment());
    rowcsub19sig00.setSzCdEligMedEligGroup(eligibilitySummaryDB.getCdEligMedEligGroup());
    rowcsub19sig00.setSzCdFceEligReason(eligibilitySummaryDB.getCdFceEligReason());
    rowcsub19sig00.setCIndEligWriteHistory(EligibilityDB.toCharIndicator(eligibilityDB.getIndEligWriteHistory()));
    rowcsub19sig00.setCIndEligCsupSend(EligibilityDB.toCharIndicator(eligibilityDB.getIndEligCsupSend()));
    // Only the BatchAlerts SpringBatch job can set this (indReviewCreated) to 'Y'.
    // Do not overwrite it if it has been set to 'Y'
    if (!ArchitectureConstants.Y.equals(eligibilitySummaryDB.getIndReviewCreated())) {
      rowcsub19sig00.setCIndReviewCreated(ArchitectureConstants.N);
    }
    rowcsub19sig00.setDtDtEligCsupReferral(DateHelper.toCastorDate(eligibilityDB.getDtEligCsupReferral()));

    if (oldEligibilityDB != null) {
      rowcsub19sig00.setTsLastUpdate(oldEligibilityDB.getDtLastUpdate());
    } else {
      rowcsub19sig00.setTsLastUpdate(dtLastUpdate);
    }

    csub19si.setROWCSUB19SIG00(rowcsub19sig00);

    ROWCSUB19SIG01 rowcsub19sig01 = new ROWCSUB19SIG01();

    SzCdEventStatus_ARRAY szCdEventStatus_ARRAY = new SzCdEventStatus_ARRAY();
    //old status
    szCdEventStatus_ARRAY.addSzCdEventStatus(eventStatus);
    //new status
    szCdEventStatus_ARRAY.addSzCdEventStatus(newEventStatus);
    szCdEventStatus_ARRAY.setUlRowQty(2);
    rowcsub19sig01.setSzCdEventStatus_ARRAY(szCdEventStatus_ARRAY);

    //For new events, set NULL_DATE.  Otherwise, copy in EventOccurred date
    if (dtEventOccurred == null) {
      rowcsub19sig01.setDtDtEventOccurred(null);
    } else { // is this needed?
      rowcsub19sig01.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    }
    
    // taskCode is set above
    rowcsub19sig01.setSzCdTask(taskCode);

    String stageName = getStageName(connection, eligibilitySummaryDB.getIdCase(), eligibilitySummaryDB.getIdStage());

    rowcsub19sig01.setSzNmStage(stageName);

    rowcsub19sig01.setSzCdEventType(EventHelper.FCE_ELIGIBILITY_EVENT_TYPE);
    rowcsub19sig01.setUlIdEvent((int) idEligibilityEvent);
    rowcsub19sig01.setUlIdStage((int) eligibilitySummaryDB.getIdStage());
    // If the UlIdPerson is 0 use the "Last person updated" so that
    // System will no longer appear on generated Eligibility Summaries
    int localIdPerson = (int) eligibilitySummaryDB.getIdPerson();

    if (localIdPerson == 0) {
      localIdPerson = (int) eligibilitySummaryDB.getIdLastUpdatePerson();
    }
    rowcsub19sig01.setUlIdPerson(localIdPerson);
    rowcsub19sig01.setSzTxtEventDescr(eventDescription);

    //!!! event timestamp - need to save in Databean ???
    rowcsub19sig01.setTsLastUpdate(dtLastUpdate);

    csub19si.setROWCSUB19SIG01(rowcsub19sig01);

    csub19si.setBSysIndPrfrmValidation("Y");
    if (ignoreMessages.contains(new Integer(Messages.MSG_SUB_GAP_EXISTS_1)) ||
        ignoreMessages.contains(new Integer(Messages.MSG_SUB_GAP_EXISTS_2)) ||
        ignoreMessages.contains(new Integer(Messages.MSG_SUB_GAP_EXISTS_3))) {
      //caud18 skips gap checks (VALIDATE 4, VALIDATE 5) if values is N
      //to allow insert
      csub19si.setBSysIndPrfrmValidation("N");
    }

    //csub19 creates a new todo each time a NEW todo is saved (and eligEnd is null)
    csub19si.setSzSysCdWinMode(PageModeConstants.MODIFY);
    if (oldEligibilityDB == null) {
      csub19si.setSzSysCdWinMode(PageModeConstants.NEW);
    }

    //caud18; if Y it checks whether the previous eligibility had court ordered child support
    //does not look at eligibilities with startDate == endDate
    //MSG_SUB_COURT_ORDERED
    //appears that this flag is never set by CAPs window code
    csub19si.setBSysIndGeneric("N");
    
    CSUB19SO csub19so = null;
    trace("csub19si: \n" + csub19si);
    try {
      csub19so = saveEligibility.saveEligibility(csub19si);
      trace("csub19so: \n" + csub19so);
    }
    catch (ServiceException e) {
      throw new EjbValidationException(e.getErrorCode(), e, BasePrsException.WARNING_PRIORITY);
    }
    return csub19so;
  }

  protected void executeDelete(Connection connection, EligibilitySummaryDB eligibilitySummaryDB)
          throws EjbValidationException, NamingException, FinderException, SQLException, RemoteException {
    EligibilitySummaryDB readDB = executeRead(connection, eligibilitySummaryDB.getIdStage(),
                                              eligibilitySummaryDB.getIdCase(),
                                              eligibilitySummaryDB.getIdEligibilityEvent(),
                                              eligibilitySummaryDB.getIdLastUpdatePerson());
    //If summary isn't in NEW status, throw EjbValidationException
    if (readDB.getCdEventStatus().equals(EventHelper.NEW_EVENT) == false) {
      throw new EjbValidationException(Messages.MSG_NO_DEL_ELIG_SUMM, BasePrsException.WARNING_PRIORITY);
    }

    //Call delete helper method.
    EventHelper.deleteFceEligibility(connection, eligibilitySummaryDB.getIdFceEligibility(),
                                     eligibilitySummaryDB.getIdEligibilityEvent());
  }

  //!!! surely this exists elsewhere
  protected boolean notEquals(Object object1, Object object2) {
    return (equals(object1, object2) == false);
  }

  protected boolean equals(Object object1, Object object2) {
    if (object1 == null) {
      return (object2 == null);
    }
    return object1.equals(object2);
  }

  protected Date normalizeEndDate(Date date) {
    if ((date == null) ||
        (date.getTime() == DateHelper.MAX_JAVA_DATE.getTime())) {
      return null;
    }
    return date;
  }

  protected String getStageName(Connection connection, long idCase, long idStage) throws SQLException {
    CfpDao cfpDao = new CfpDao(connection);
    StageDB stageDB = cfpDao.getStageDB((int) idCase, (int) idStage);
    return stageDB.getStageName();
  }

  public void trace(String string) {
    GrndsTrace.msg(TRACE_TAG, 7, string);
  }

}
