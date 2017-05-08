package gov.georgia.dhr.dfcs.sacwis.web.intake;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveAllegations;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveCallEntryCallDecision;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveCallPersonList;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveIncomingFacilityDetail;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveIntakeNarrative;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveCallEntry;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegRtrvRecIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryRtrvIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilRtrvInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilRtrvStruc;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntNarrBlobInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntNarrBlobRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryAUDOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CreateCallOutStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

/**
 * <p/>
 * Title: populateDataBean </p>
 * <p/>
 * Description: This class is used to populate the IntakeDataBean that is passed to the CreateErrorList class, which
 * basically validates an Intake when a user attempts to save and submit, save and assign, or save and close. </p>
 * <p/>
 * Copyright: Copyright (c) 2002 </p>
 *
 * @author Jenn Casdorph
 * 
 * <p/> Change History: 
 *      Date       User          Description 
 *      ---------  ------------  ----------------------------------------------
 *      06/29/10   hnguyen       SMS#59958: Populate facility data
 */
public class PopulateDataBean extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "populateDataBean";

  private PopulateDataBean() {
  }

  public static IntakeDataBean populate(GrndsExchangeContext context, Intake intakeEjb) throws ServiceException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateDataBean()");
    IntakeDataBean intake = new IntakeDataBean();

    try {

      // Retrieve Call Decision/Call Entry

      CallEntryRtrvOut callEntryRtrvOut = callCINT25S(context, intakeEjb);

      CallEntrySvcStruct callEntryData = callEntryRtrvOut.getCallEntrySvcStruct();

      // Retrieve for Person List
      String incomingStatus = FormattingHelper.formatString(callEntryData.getCdIncmgStatus());
      Date callDisposedDt = callEntryData.getTsIncmgCallDisp();

      PersListRtrvStruct_ARRAY personListArray = new PersListRtrvStruct_ARRAY();
      try {
        PersListOutRec persListOutRec = callCINT26S(context, incomingStatus, callDisposedDt, intakeEjb);

        personListArray = persListOutRec.getPersListRtrvStruct_ARRAY();
      } catch (ServiceException e) {
        switch (e.getErrorCode()) {
          case Messages.SQL_NOT_FOUND:
          case Messages.MSG_NO_ROWS_RETURNED:
            break;
          default:
            //noinspection ThrowCaughtLocally
            throw e;
        }
      }

      // Retrieve for Facility
      //FacilRtrvInRec facilRtrvInRec = populateFacilRtrvInRec_Retrieve(context);
      
      FacilRtrvOutRec facilRtrvOutRec = new FacilRtrvOutRec();
      try {
        facilRtrvOutRec = callCINT27S(context, intakeEjb);
      // facilRtrvOutRec = (FacilRtrvOutRec) WtcHelper.callService("CINT27S", facilRtrvInRec, FacilRtrvOutRec.class);
      } catch (ServiceException me) {
        switch (me.getErrorCode()) {
          case Messages.SQL_NOT_FOUND:
          case Messages.MSG_NO_ROWS_RETURNED:
            break;
          default:
            throw me;
        }
      }
      // Allegation List Retrive
      ROWCINT76DO_ARRAY allegListArray = new ROWCINT76DO_ARRAY();
      try {
        AllegRtrvRecOut allegRtrvRecOut = callCINT30S(context, intakeEjb);
        allegListArray = allegRtrvRecOut.getROWCINT76DO_ARRAY();
        // If there are allegations, set the indicator to indicate if any of the allegation's victim
        // were/are in a 'Trial Home Visit' placement
        if (allegRtrvRecOut != null) {
          callEntryRtrvOut.setCIndTrialHomeVisit(allegRtrvRecOut.getCIndTrialHomeVisit());
        }
      } catch (ServiceException e) {
        switch (e.getErrorCode()) {
          case Messages.SQL_NOT_FOUND:
          case Messages.MSG_NO_ROWS_RETURNED:
            break;
          default:
            //noinspection ThrowCaughtLocally
            throw e;
        }
      }

      
      // INTAKE NARRATIVE RETRIEVE
      boolean hasCallNarr = (PopulateDataBean.hasNarrative(context, intakeEjb));

      intake.setHasCallNarr(hasCallNarr);
      intake.setCallEntryDecision(callEntryRtrvOut);
      intake.setPersonlistarray(personListArray);
      intake.setFacility(facilRtrvOutRec);
      intake.setAllegListArray(allegListArray);
    } catch (ServiceException e) {
      throw e;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
    return intake;
  }

  /**
   * This is a populate submethod for the Intake Narrative Retrieve Service.
   *
   * @param context
   * @return
   */
  public static IntNarrBlobInRec populateIntNarrBlobInRec_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateIntNarrBlobInRec_Retrieve()");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
    IntNarrBlobInRec narrInRec = new IntNarrBlobInRec();
    narrInRec.setArchInputStruct(archInputStruct);
    IntNarrBlobRtrvStruct intNarrBlobRtrvStruct = new IntNarrBlobRtrvStruct();
    intNarrBlobRtrvStruct.setUlIdStage(GlobalData.getUlIdStage(context.getRequest()));
    narrInRec.setIntNarrBlobRtrvStruct(intNarrBlobRtrvStruct);
    performanceTrace.exitScope();
    return narrInRec;
  }

  /**
   * <p/>
   * This submethod populates the Call Entry Retrieve Input Object. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public static CallEntryRtrvIn populateCallEntryRtrvIn_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG,
                                                                    ".populateCallEntryRtrvIn_RetrieveCallEntry()");

    HttpServletRequest request = context.getRequest();

    ArchInputStruct archInputStruct = new ArchInputStruct();

    CallEntryRtrvIn callentryrtrvin = new CallEntryRtrvIn();
    callentryrtrvin.setArchInputStruct(archInputStruct);
    callentryrtrvin.setUlIdStage(GlobalData.getUlIdStage(request));
    callentryrtrvin.setUlIdPerson(0);

    performanceTrace.exitScope();
    return callentryrtrvin;
  }

  /**
   * This submethod is used to populate the Person List Retrieve Input Object.
   *
   * @param context
   * @param incomingStatus
   * @param callDisposedDt
   * @return
   */
  public static PersListInRec populatePersListInRec_Retrieve(GrndsExchangeContext context, String incomingStatus,
                                                             Date callDisposedDt) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populatePersListInRec_Retrieve()");

    HttpServletRequest request = context.getRequest();

    PersListInRec persListInRec = new PersListInRec();
    ArchInputStruct input = new ArchInputStruct();

    input.setUlPageSizeNbr(30);
    input.setUsPageNbr(1);
    input.setCReqFuncCd("");

    if (incomingStatus.equals(CodesTables.CINCMGST_CLD)) {
      persListInRec.setTsIncmgCallDisp(callDisposedDt);
    }
    persListInRec.setUlIdStage(GlobalData.getUlIdStage(request));
    persListInRec.setCdIncmgStatus(incomingStatus);
    persListInRec.setArchInputStruct(input);

    performanceTrace.exitScope();
    return persListInRec;
  }

  public static FacilRtrvInRec populateFacilRtrvInRec_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateFacilRtrvInRec_Retrieve()");

    HttpServletRequest request = context.getRequest();

    FacilRtrvStruc facilRtrvStruct = new FacilRtrvStruc();
    facilRtrvStruct.setUlIdStage(GlobalData.getUlIdStage(request));

    FacilRtrvInRec facilRtrvInRec = new FacilRtrvInRec();
    facilRtrvInRec.setFacilRtrvStruc(facilRtrvStruct);

    performanceTrace.exitScope();
    return facilRtrvInRec;
  }

  /**
   * This submethod populates the Allegation List Retreive Input Object.
   *
   * @param context
   * @return
   */
  public static AllegRtrvRecIn populateAllegRtrvRecIn_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateAllegRtrvRecIn_Retrieve()");

    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd("");
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(50);

    AllegRtrvRecIn allegrtrvrecin = new AllegRtrvRecIn();
    allegrtrvrecin.setArchInputStruct(input);
    allegrtrvrecin.setUlIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.exitScope();
    return allegrtrvrecin;
  }

  /** Wraps call to CINT25S Ensures CallEntrySvcStruct is not null */
  public static CallEntryRtrvOut callCINT25S(GrndsExchangeContext context,
                                             RetrieveCallEntryCallDecision retrieveCallEntryCallDecision)
          throws ServiceException, MarshalException, ValidationException {
    CallEntryRtrvIn callEntryRtrvIn = populateCallEntryRtrvIn_Retrieve(context);

    CallEntryRtrvOut callEntryRtrvOut = retrieveCallEntryCallDecision.retrieveCallEntryCallDecision(callEntryRtrvIn);

    gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct callEntryData =
            callEntryRtrvOut.getCallEntrySvcStruct();

    if (callEntryData == null) {
      callEntryData = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct();
      callEntryRtrvOut.setCallEntrySvcStruct(callEntryData);
    }
    return callEntryRtrvOut;
  }

  /** Wraps call to CINT26S Ensures PersListRtrvStruct_ARRAY is not null */
  public static PersListOutRec callCINT26S(GrndsExchangeContext context, String incomingStatus, Date callDisposedDt,
                                           RetrieveCallPersonList retrieveCallPersonList)
          throws ServiceException, MarshalException, ValidationException {
    PersListInRec persListInRec = populatePersListInRec_Retrieve(context, incomingStatus, callDisposedDt);
    PersListOutRec persListOutRec = retrieveCallPersonList.retrieveCallPersonList(persListInRec);

    if (persListOutRec == null) {
      persListOutRec = new PersListOutRec();
    }

    PersListRtrvStruct_ARRAY personListArray = persListOutRec.getPersListRtrvStruct_ARRAY();

    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
      persListOutRec.setPersListRtrvStruct_ARRAY(personListArray);
    }
    return persListOutRec;
  }

  /** Wraps call to CINT30S Ensures ROWCINT76DO_ARRAY is not null */
  public static AllegRtrvRecOut callCINT30S(GrndsExchangeContext context, RetrieveAllegations retrieveAllegations)
          throws ServiceException, MarshalException, ValidationException {
    AllegRtrvRecIn allegrtrvrecin = populateAllegRtrvRecIn_Retrieve(context);
    AllegRtrvRecOut allegRtrvRecOut = retrieveAllegations.retrieveAllegations(allegrtrvrecin);

    ROWCINT76DO_ARRAY allegListArray = allegRtrvRecOut.getROWCINT76DO_ARRAY();
    if (allegListArray == null) {
      allegListArray = new ROWCINT76DO_ARRAY();
      allegRtrvRecOut.setROWCINT76DO_ARRAY(allegListArray);
    }
    return allegRtrvRecOut;
  }

  /** Wraps call to CINT22S Returns true as long as there are no exceptions */
  public static boolean hasNarrative(GrndsExchangeContext context, RetrieveIntakeNarrative retrieveIntakeNarrative) {
    try {
      IntNarrBlobInRec narrInRec = populateIntNarrBlobInRec_Retrieve(context);
      retrieveIntakeNarrative.findIntakeNarrative(narrInRec);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  // !!! this is a save not a display; so maybe this should go somewhere else

  /** Wraps call to CINT12S Ensures CreateCallOutStruct is not null */
  public static CallEntryAUDOutRec callCINT12S(CallEntryAUDInRec callEntryAUDInRec, SaveCallEntry saveCallEntry)
          throws ServiceException, MarshalException, ValidationException {
    CallEntryAUDOutRec callEntryAUDOutRec = saveCallEntry.saveCallEntry(callEntryAUDInRec);
    CreateCallOutStruct out = callEntryAUDOutRec.getCreateCallOutStruct();
    if (out == null) {
      out = new CreateCallOutStruct();
      callEntryAUDOutRec.setCreateCallOutStruct(out);
    }
    return callEntryAUDOutRec;
  }

  /** Wraps call to CINT27S Ensures FacDetailEntStruct is not null */
  public static FacilRtrvOutRec callCINT27S(GrndsExchangeContext context, RetrieveIncomingFacilityDetail retrieveIncomingFacilityDetail)
          throws ServiceException, MarshalException, ValidationException {
    FacilRtrvInRec facilRtrvInRec = populateFacilRtrvInRec_Retrieve(context);
    FacilRtrvOutRec facilRtrvOutRec = retrieveIncomingFacilityDetail.retrieveIncomingFacilityDetail(facilRtrvInRec);

    if( facilRtrvOutRec == null )
    {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }
    
    FacDetailEntStruct facDetailEntStruct = facilRtrvOutRec.getFacDetailEntStruct();
    
    if (facDetailEntStruct == null) {
      facDetailEntStruct = new FacDetailEntStruct();
      facilRtrvOutRec.setFacDetailEntStruct(facDetailEntStruct);
    }
    return facilRtrvOutRec;
  }
}
