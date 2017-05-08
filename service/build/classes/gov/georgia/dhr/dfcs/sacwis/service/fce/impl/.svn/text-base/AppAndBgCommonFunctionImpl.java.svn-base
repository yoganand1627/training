package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.fce.AppAndBgCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import java.util.List;
import java.util.ArrayList;

public class AppAndBgCommonFunctionImpl extends BaseServiceImpl implements AppAndBgCommonFunction {
  
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  private EventDAO eventDAO = null;
  
  private FceApplicationDAO fceApplicationDAO = null;

  private FcePersonDAO fcePersonDAO = null;
  
  private FceEligibilityDAO fceEligibilityDAO = null;
  
  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }

  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }
  
  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }

  public FceApplicationDB findApplicationByApplicationEvent(long idApplicationEvent) {
    FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdApplicationEvent(idApplicationEvent);
    if (fceApplication == null) {
      return null;
    }
    return PopulateFceUtility.populateFceApplicationDB(fceApplication);
  }
  
  public void updateFceApplicationIndEvalConclusion(long idFceApplication, String indEvaluationConclusion) {
    FceApplication fceApplication = getPersistentObject(FceApplication.class, (int) idFceApplication);
    fceApplication.setIndEvaluationConclusion(indEvaluationConclusion);
    fceApplicationDAO.saveFceApplication(fceApplication);
    // fceApplicationDAO.updateFceApplicationByIndEvalConclusion(idFceApplication, indEvaluationConclusion);
  }
  
  public void updateFceApplicationPersonAddress(FceApplicationDB fceApplicationDB) {
    FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                        (int) fceApplicationDB.getIdFceApplication());
    //FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdFceApplication(fceApplicationDB.getIdFceApplication());
    fceApplication.setAddrRemovalAddrZip(fceApplicationDB.getAddrRemovalAddrZip());
    fceApplication.setAddrRemovalCity(fceApplicationDB.getAddrRemovalCity());
    fceApplication.setAddrRemovalStLn1(fceApplicationDB.getAddrRemovalStLn1());
    fceApplication.setAddrRemovalStLn2(fceApplicationDB.getAddrRemovalStLn2());
    fceApplication.setCdRemovalAddrCounty(fceApplicationDB.getCdRemovalAddrCounty());
    fceApplication.setCdRemovalAddrState(fceApplicationDB.getCdRemovalAddrState());
    fceApplication.setCdState(fceApplicationDB.getCdState());
    // fceApplicationDAO.updateFceApplicationRemovalAddress(fceApplicationDB.getIdFceApplication(), fceApplicationDB.getAddrRemovalStLn1(), fceApplicationDB.getAddrRemovalStLn2(), fceApplicationDB.getAddrRemovalCity(), 
    //                                                     fceApplicationDB.getCdRemovalAddrState(), fceApplicationDB.getAddrRemovalAddrZip(), fceApplicationDB.getCdRemovalAddrCounty());
    fceApplicationDAO.saveFceApplication(fceApplication);
  }

  public void updateFceApplicationCdApplication(FceApplicationDB fceApplicationDB) {
    FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                        (int) fceApplicationDB.getIdFceApplication());
    // Following to set amended indicator when other approved application exists
    List<String> eventTypes = new ArrayList<String>();
    List<String> eventStatuses = new ArrayList<String>();
    
    eventTypes.add(CodesTables.CEVNTTYP_FCA);
    eventStatuses.add(CodesTables.CEVTSTAT_APRV);
    
    List<Event> fceaList = eventDAO.findEventByIdStageCdEventStatusCdEventTypes((int)fceApplicationDB.getIdStage(), eventTypes, eventStatuses);
    
    long nbrAppExists = fceaList.size();
    if (nbrAppExists > 0 && CodesTables.CFCEAPRE_A.equals(fceApplicationDB.getCdApplication())) {
      fceApplicationDB.setIndAmendedApp("Y");
    }
    
    fceApplication.setCdApplication(fceApplicationDB.getCdApplication());
    fceApplication.setIndAmendedApp(toCharIndicator(fceApplicationDB.getIndAmendedAppObject()));
    fceApplicationDAO.saveFceApplication(fceApplication);
  }
  
  public void updateCdRelIntandLegalCustodian(long idFcePerson, String cdRelInt, boolean indLegalCustodian) {
    String isLegalCustodian = toCharIndicator(indLegalCustodian);
    fcePersonDAO.updateByCdRelIntandLegalCustodian(idFcePerson, cdRelInt, isLegalCustodian);
  }
  
  public int updateNbrLivingAtHome(long idFceApplication, long nbrLivingAtHome) {
    return fceApplicationDAO.updateFceAppliationByNbrLivingAtHome(idFceApplication, nbrLivingAtHome);
  }
  
  public int updateIndMeetsDpOrNotEs(long idFceApplication, String indMeetsDpOrNotEs) {
    return fceEligibilityDAO.updateFceEligibilityByIndMeetsDpOrNotEs(idFceApplication, indMeetsDpOrNotEs);
  }
  
  public int updateNbrCertifiedGroup(long idFceApplication, long nbrCertifiedGroup) {
    return fceEligibilityDAO.updateFceEligibilityByNbrCertifiedGroup(idFceApplication, nbrCertifiedGroup);
  }

  public void updateFcePerson(FcePersonDB fcePersonDB) {
    String indThirdPartyIns = toCharIndicator(fcePersonDB.getIndThirdPartyInsuranceObject());
    fcePersonDAO.updateFcePersonIndThirdPartyIns(fcePersonDB.getIdPerson(), indThirdPartyIns);
  }
  
  public void updateFceEligibilityByIndMeetsDpOrNotSystem(long idFceEligibility, String indMeetsDpOrNotSystem) {
     fceEligibilityDAO.updateFceEligibilityByIndMeetsDpOrNotSystem(idFceEligibility, indMeetsDpOrNotSystem);
  }
  
  public void updateRemovalDate(int idFceApplication) {
    FceApplication fceApplication = getPersistentObject(FceApplication.class, idFceApplication);
    if (fceApplication == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    java.util.Date dtRemoval = cnsrvtrshpRemovalDAO.findLatestCnsrvtrshpRemovalDatetByIdCase(fceApplication.getCapsCase().getIdCase(), fceApplication.getPersonByIdPerson().getIdPerson());
    fceApplication.setDtRemovalDate(dtRemoval);
    fceApplicationDAO.saveFceApplication(fceApplication);
  }
  
  public FceApplicationDB retrieveFceApplication(long idFceApplication) throws ServiceException {
    FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdFceApplication(idFceApplication);
    if (fceApplication == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceApplicationDB(fceApplication);
  }
  
  private static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value.booleanValue()) {
      return "Y";
    }
    return "N";
  }
}
