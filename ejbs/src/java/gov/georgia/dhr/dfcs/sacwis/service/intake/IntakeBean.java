/**
 * Created on Jun 28, 2006 at 12:56:56 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegRtrvRecIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT99SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryRtrvIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallListSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilRtrvInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilityDetailInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HierSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntNarrBlobInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnrelatePersonInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegListAUDOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT99SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV45SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryAUDOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListSrchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilityDetailOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HierSrchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IntNarrBlobOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListMUpdOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelatePersonOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UnrelatePersonOutRec;

import javax.ejb.CreateException;

import org.springframework.beans.factory.BeanFactory;

public class IntakeBean extends BaseSpringStatelessSessionBean implements Intake {
  private RetrieveAllegationDetail retrieveAllegationDetail;
  private RetrieveAllegationList retrieveAllegationList;
  private RetrieveAllegations retrieveAllegations;
  private RetrieveCallEntryCallDecision retrieveCallEntryCallDecision;
  private RetrieveCallPersonList retrieveCallPersonList;
  private RetrieveIncomingPersonDetail retrieveIncomingPersonDetail;
  private RetrieveIntakeNarrative retrieveIntakeNarrative;
  private RetrieveIntakePriorityClosure retrieveIntakePriorityClosure;
  private RetrievePersonSearchAsync retrievePersonSearchAsync;
  private RetrieveRaceAndEthnicity retrieveRaceAndEthnicity;
  private SaveAllegationDetail saveAllegationDetail;
  private SaveAllegations saveAllegations;
  private SaveCallDecision saveCallDecision;
  private SaveCallEntry saveCallEntry;
  private SaveCallPersonList saveCallPersonList;
  private SaveIntakePriorityClosure saveIntakePriorityClosure;
  private SaveMultipleAllegationDetail saveMultipleAllegationDetail;
  private SaveOverallRoleandDisposition saveOverallRoleandDisposition;
  private SavePersonList savePersonList;
  private SaveRelatePerson saveRelatePerson;
  private SaveUnrelatePerson saveUnrelatePerson;
  private RetrieveCallLog retrieveCallLog;
  private SaveIncomingFacilityDetail saveIncomingFacilityDetail;
  private RetrieveIncomingFacilityDetail retrieveIncomingFacilityDetail;
  //CAPTA 4.3
  private RetrievePlacementForVictimChild retrievePlacementForVictimChild;

  public CINV46SO retrieveAllegationDetail(CINV46SI cinv46si) {
    return retrieveAllegationDetail.retrieveAllegationDetail(cinv46si);
  }

  public CINV44SO retrieveAllegationList(CINV44SI cinv44si) throws ServiceException {
    return retrieveAllegationList.retrieveAllegationList(cinv44si);
  }

  public AllegRtrvRecOut retrieveAllegations(AllegRtrvRecIn cint30in) throws ServiceException {
    return retrieveAllegations.retrieveAllegations(cint30in);
  }

  public CallEntryRtrvOut retrieveCallEntryCallDecision(CallEntryRtrvIn callEntryRtrvIn) throws ServiceException {
    return retrieveCallEntryCallDecision.retrieveCallEntryCallDecision(callEntryRtrvIn);
  }

  public PersListOutRec retrieveCallPersonList(PersListInRec cint26si) throws ServiceException {
    return retrieveCallPersonList.retrieveCallPersonList(cint26si);
  }

  public CINT34SO retrieveIncomingPersonDetail(CINT34SI cint34si) throws ServiceException {
    return retrieveIncomingPersonDetail.retrieveIncomingPersonDetail(cint34si);
  }

  public IntNarrBlobOutRec findIntakeNarrative(IntNarrBlobInRec intNarrBlobInRec) throws ServiceException {
    return retrieveIntakeNarrative.findIntakeNarrative(intNarrBlobInRec);
  }

  public CINT99SO retrieveIntakePriorityClosure(CINT99SI cint99si) throws ServiceException {
    return retrieveIntakePriorityClosure.retrieveIntakePriorityClosure(cint99si);
  }

  public HierSrchOutRec retrievePersonSearchAsync(HierSrchInRec hierSrchInRec) throws ServiceException {
    return retrievePersonSearchAsync.retrievePersonSearchAsync(hierSrchInRec);
  }

  public CCMN95SO findPersonRaceAndPersonEthnicity(CCMN95SI ccmn96si) throws ServiceException {
    return retrieveRaceAndEthnicity.findPersonRaceAndPersonEthnicity(ccmn96si);
  }

  public CINV47SO saveAllegDtl(CINV47SI cinv47si) throws ServiceException {
    return saveAllegationDetail.saveAllegDtl(cinv47si);
  }

  public AllegListAUDOutRec saveAllegations(AllegListAudInRec allegListAudInRec) throws ServiceException {
    return saveAllegations.saveAllegations(allegListAudInRec);
  }

  public CallDcsnAUOutRec saveCallDecision(CallDcsnAUDIn callDcsnAUDIn) throws ServiceException {
    return saveCallDecision.saveCallDecision(callDcsnAUDIn);
  }

  public CallEntryAUDOutRec saveCallEntry(CallEntryAUDInRec cint12si) throws ServiceException {
    return saveCallEntry.saveCallEntry(cint12si);
  }

  public PersListMUpdOutRec saveCallPersonList(MUpdInRec cint35si) throws ServiceException {
    return saveCallPersonList.saveCallPersonList(cint35si);
  }

  public CINT21SO saveIntakePriorityClosure(CINT21SI cint21si) throws ServiceException {
    return saveIntakePriorityClosure.saveIntakePriorityClosure(cint21si);
  }

  public CINV09SO saveMultipleAllegationDetail(CINV09SI cinv09si) throws ServiceException {
    return saveMultipleAllegationDetail.saveMultipleAllegationDetail(cinv09si);
  }

  public CINV45SO saveRoleDisp(CINV45SI cinv45si) throws ServiceException {
    return saveOverallRoleandDisposition.saveRoleDisp(cinv45si);
  }

  public PersListAudOutRec savePersonList(PersListAudInRec cint02si) throws ServiceException {
    return savePersonList.savePersonList(cint02si);
  }

  public RelatePersonOutRec relatePerson(RelatePersonInRec relatePersonInRec) throws ServiceException {
    return saveRelatePerson.relatePerson(relatePersonInRec);
  }

  public UnrelatePersonOutRec saveUnrelatedPerson(UnrelatePersonInRec unrelatePersonInRec) throws ServiceException {
    return saveUnrelatePerson.saveUnrelatedPerson(unrelatePersonInRec);
  }

  public CallListSrchOutRec retrieveCallLog(CallListSrchInRec callListSrchInRec) throws ServiceException {
    return retrieveCallLog.retrieveCallLog(callListSrchInRec);
  }

  public  FacilityDetailOutRec saveIncomingFacilityDetail(FacilityDetailInRec facilDetail) throws ServiceException {
    return saveIncomingFacilityDetail.saveIncomingFacilityDetail(facilDetail);
  }
  
  public FacilRtrvOutRec retrieveIncomingFacilityDetail(FacilRtrvInRec facilRtrvInRec) throws ServiceException{
    return retrieveIncomingFacilityDetail.retrieveIncomingFacilityDetail(facilRtrvInRec);
  }
  
  public FacilRtrvOutRec retrievePlacementForVictimChild(FacilRtrvInRec facilRtrvInRec) throws ServiceException{
            return retrievePlacementForVictimChild.retrievePlacementForVictimChild(facilRtrvInRec);
          }
  
  protected void onEjbCreate() throws CreateException {
    BeanFactory beanFactory = getBeanFactory();
    retrieveAllegationDetail = getService(RetrieveAllegationDetail.class);
    retrieveAllegationList = getService(RetrieveAllegationList.class);
    retrieveAllegations = getService(RetrieveAllegations.class);
    retrieveCallEntryCallDecision = getService(RetrieveCallEntryCallDecision.class);
    retrieveCallPersonList = getService(RetrieveCallPersonList.class);
    retrieveIncomingPersonDetail = getService(RetrieveIncomingPersonDetail.class);
    retrieveIntakeNarrative = getService(RetrieveIntakeNarrative.class);
    retrieveIntakePriorityClosure = getService(RetrieveIntakePriorityClosure.class);
    retrievePersonSearchAsync = getService(RetrievePersonSearchAsync.class);
    retrieveRaceAndEthnicity = getService(RetrieveRaceAndEthnicity.class);
    saveAllegationDetail = getService(SaveAllegationDetail.class);
    saveAllegations = getService(SaveAllegations.class);
    saveCallDecision = getService(SaveCallDecision.class);
    saveCallEntry = getService(SaveCallEntry.class);
    saveCallPersonList = getService(SaveCallPersonList.class);
    saveIntakePriorityClosure = getService(SaveIntakePriorityClosure.class);
    saveMultipleAllegationDetail = getService(SaveMultipleAllegationDetail.class);
    saveOverallRoleandDisposition = getService(SaveOverallRoleandDisposition.class);
    savePersonList = getService(SavePersonList.class);
    saveRelatePerson = getService(SaveRelatePerson.class);
    saveUnrelatePerson = getService(SaveUnrelatePerson.class);
    retrieveCallLog = getService(RetrieveCallLog.class);
    saveIncomingFacilityDetail=getService(SaveIncomingFacilityDetail.class);
    retrieveIncomingFacilityDetail=getService(RetrieveIncomingFacilityDetail.class);
    retrievePlacementForVictimChild=getService(RetrievePlacementForVictimChild.class);
  }
}
