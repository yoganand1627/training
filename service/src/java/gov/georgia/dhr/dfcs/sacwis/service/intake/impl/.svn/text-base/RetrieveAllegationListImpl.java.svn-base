package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegEvidenceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LicensingInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FacilityInvstDtl;
import gov.georgia.dhr.dfcs.sacwis.db.LicensingInvstDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveAllegationList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveAllegationListImpl extends BaseServiceImpl implements RetrieveAllegationList {

  public static final String ADMIN_REVIEW = CodesTables.CSTAGES_ARI;
  public static final String INTAKE = CodesTables.CSTAGES_INT;
  public static final String INVESTIGATION = CodesTables.CSTAGES_INV;
  public static final String SVC_DELIVERY = CodesTables.CSTAGES_SVC;

  public static final String EVENT_STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  public static final String CAPS_PROG_APS = CodesTables.CPGRMS_APS;
  public static final String CAPS_PROG_AFC = CodesTables.CPGRMS_AFC;
  public static final String CAPS_PROG_CPS = CodesTables.CPGRMS_CPS;
  public static final String CAPS_PROG_CCL = CodesTables.CPGRMS_CCL;
  public static final String CAPS_PROG_RCL = CodesTables.CPGRMS_RCL;

  private AllegationDAO allegationDAO = null;
  private AllegEvidenceDAO allegEvidenceDAO = null;
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  private EventDAO eventDAO = null;
  private FacilityInvstDtlDAO facilityInvstDtlDAO = null;
  private IntakeAllegationDAO intakeAllegationDAO = null;
  private LicensingInvstDtlDAO licensingInvstDtlDAO = null;
  private StageDAO stageDAO = null;

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setFacilityInvstDtlDAO(FacilityInvstDtlDAO facilityInvstDtlDAO) {
    this.facilityInvstDtlDAO = facilityInvstDtlDAO;
  }

  public void setIntakeAllegationDAO(IntakeAllegationDAO intakeAllegationDAO) {
    this.intakeAllegationDAO = intakeAllegationDAO;
  }

  public void setLicensingInvstDtlDAO(LicensingInvstDtlDAO licensingInvstDtlDAO) {
    this.licensingInvstDtlDAO = licensingInvstDtlDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setAllegEvidenceDAO(AllegEvidenceDAO allegEvidenceDAO) {
    this.allegEvidenceDAO = allegEvidenceDAO;
  }

  public CINV44SO retrieveAllegationList(CINV44SI cinv44si) throws ServiceException {
    CINV44SO cinv44so = new CINV44SO();

    int idStage = cinv44si.getUlIdStage();
    int idCase = cinv44si.getUlIdCase();

    ArchInputStruct archInputStruct = cinv44si.getArchInputStruct();

    ArchOutputStruct archOutputStruct = new ArchOutputStruct();

    if (INVESTIGATION.equals(cinv44si.getSzCdAllegIncidentStage()) ||
        ADMIN_REVIEW.equals(cinv44si.getSzCdAllegIncidentStage())) {
      // Stage is Investigation or Admin Review
      // cinv68d
      //ROWCINV44SOG_ARRAY 
      ROWCINV44SOG_ARRAY rowcinv44sog_array = retrieveInvestigationAdminReviewAllegations(idStage,
                                                                                          archInputStruct.getUsPageNbr(),
                                                                                          archInputStruct.getUlPageSizeNbr());
      cinv44so.setROWCINV44SOG_ARRAY(rowcinv44sog_array);
      
      if (null != cinv44so.getROWCINV44SOG_ARRAY()) {
        retrieveAllegEvidence(cinv44so.getROWCINV44SOG_ARRAY());
      }
                                     
      archOutputStruct.setBMoreDataInd(rowcinv44sog_array.getBMoreDataInd());
      cinv44so.setArchOutputStruct(archOutputStruct);
    } else if (SVC_DELIVERY.equals(cinv44si.getSzCdAllegIncidentStage())) {
      // Stage is Service Delivery
      // cinv90d
      cinv44so.setROWCINV44SOG_ARRAY(retrieveSvcDeliveryAllegations(idStage));
      // Retrieve the ID_STAGE of the Investigation Stage for the Case.  This Investigation ID_STAGE should be passed
      //   to the DAM which retrieves Overall Disposition based on program.
      // clsc59d
      idStage = retrieveIdStageForInvestigation(idCase, idStage);
      // Update the input object to match the service.
      cinv44si.setUlIdStage(idStage);
    } else if (INTAKE.equals(cinv44si.getSzCdAllegIncidentStage())) {
      // Stage is Intake
      // cinv91d
      cinv44so.setROWCINV44SOG_ARRAY(processIntakeAllegationDAO(idStage));
      // Retrieve the ID_STAGE of the Investigation Stage for the Case.  This Investigation ID_STAGE should be passed
      //   to the DAM which retrieves Overall Disposition based on program.
      // clsc59d
      idStage = retrieveIdStageForInvestigation(idCase, idStage);
      // Update the input object to match the service.
      cinv44si.setUlIdStage(idStage);
    }

    String szCdStageProgram = cinv44si.getSzCdStageProgram();
    if (CAPS_PROG_CPS.equals(szCdStageProgram)) {
      retrieveCPSInvstDetailCdAllegDispositionAndIdEvent(idStage, cinv44so);
    } else if (CAPS_PROG_AFC.equals(szCdStageProgram)) {
      retrieveFacilityInvstDtlCdAllegDispositionAndIdEvent(idStage, cinv44so);
    } else if (CAPS_PROG_CCL.equals(szCdStageProgram) || (CAPS_PROG_RCL.equals(szCdStageProgram))) {
      retrieveLicensingInvstDtlCdAllegDispositionAndIdEvent(idStage, cinv44so);
    }

    // Using on the ID EVENT from the overall disposition determine the status of the event.  If the status is pending
    //   (PEND), return the ID EVENT to the client Else, return null.
    if (cinv44so.getUlIdEvent() != 0) {
      updateEventBasedOnStatus(cinv44so);
    }

    return cinv44so;
  }

  private ROWCINV44SOG_ARRAY retrieveInvestigationAdminReviewAllegations(int idStage, int pageNbr, int pageSize) {
    int rowQty = 0;
    // cinv68d
    PaginatedHibernateList<Map> mapList = this.allegationDAO.findAllegationFacilAllegFullVictimFullAllegPerpetrator(idStage, pageNbr,
                                                                                                  pageSize);
    ROWCINV44SOG_ARRAY rowcinv44sog_array = new ROWCINV44SOG_ARRAY();
    if (mapList != null && !mapList.isEmpty()) {
      for (Iterator<Map> it = mapList.iterator(); it.hasNext();) {
        Map map = it.next();
        ROWCINV44SOG rowcinv44sog = new ROWCINV44SOG();
        rowcinv44sog.setSzScrPersVictim((String) map.get("victimNmPersonFull"));
        rowcinv44sog.setUlIdVictim((Integer) map.get("idVictim") != null ? (Integer) map.get("idVictim") : 0);
        rowcinv44sog.setSzCdAllegType((String) map.get("cdAllegType"));
        rowcinv44sog.setSzScrAllegPerp((String) map.get("perpetratorNmPersonFull") != null ? (String) map.get(
                "perpetratorNmPersonFull") : "");
        rowcinv44sog.setUlIdAllegedPerpetrator((Integer) map.get("idAllegedPerpetrator") != null ? (Integer) map.get(
                "idAllegedPerpetrator") : 0);
        rowcinv44sog.setCdAllegDisposition((String) map.get("cdAllegDisposition") != null ? (String) map.get(
                "cdAllegDisposition") : "");
        rowcinv44sog.setSzCdMaltreatorRel((String) map.get("cdMaltreatorRel") != null ? (String) map.get(
        "cdMaltreatorRel") : "");
        rowcinv44sog.setSzCdAllegIncidentStage((String) map.get("cdAllegIncidentStage"));
        rowcinv44sog.setUlIdAllegation((Integer) map.get("idAllegation") != null ? (Integer) map.get("idAllegation") :
                                       0);
        rowcinv44sog.setTsLastUpdate((Date) map.get("allegationDtLastUpdate"));
        rowcinv44sog.setTsSysTsLastUpdate2((Date) map.get("facilAllegDtLastUpdate"));
        rowcinv44sog.setSzTxtEvidenceSummary((String) map.get("txtEvidenceSummary"));
        rowcinv44sog.setSzCdAllegSeverity((String) map.get("cdAllegSeverity"));
        rowcinv44sog.setIndChildDeathSeverity((String) map.get("indChildDeathSeverity"));
        rowcinv44sog_array.addROWCINV44SOG(rowcinv44sog);
        rowQty++;
      }
      rowcinv44sog_array.setUlRowQty(rowQty);
      rowcinv44sog_array.setMoreDataAvailable(mapList.isMoreDataAvailable());
    }
    return rowcinv44sog_array;
  }

  private void retrieveAllegEvidence(ROWCINV44SOG_ARRAY rowcinv44sog_array) {

    for (int index = 0; index < rowcinv44sog_array.getUlRowQty(); index++) {
      ROWCINV44SOG rowcinv44sog = rowcinv44sog_array.getROWCINV44SOG(index);
      int idAllegation = rowcinv44sog.getUlIdAllegation();
      int rowQty = 0;
      List<AllegEvidence> allegEvidenceList = allegEvidenceDAO.findAllegEvidenceByIdAllegation(idAllegation);
      AllegEvidence_ARRAY allegEvidence_Array = new AllegEvidence_ARRAY();

      if (allegEvidenceList != null || !allegEvidenceList.isEmpty() || allegEvidenceList.size() != 0) {
        for (Iterator<AllegEvidence> it = allegEvidenceList.iterator(); it.hasNext();) {
          AllegEvidence allegEvidence = it.next();
          AllegationEvidence rowcinv44sogAllegEvidence = new AllegationEvidence();
          rowcinv44sogAllegEvidence.setUlIdAllegEvidence(allegEvidence.getIdAllegEvidence().intValue());
          rowcinv44sogAllegEvidence.setUlIdAllegation(allegEvidence.getAllegation().getIdAllegation());
          rowcinv44sogAllegEvidence.setSzCdEvidenceCode(allegEvidence.getCdEvidenceCode());
          rowcinv44sogAllegEvidence.setTsLastUpdate(allegEvidence.getDtLastUpdate());
          allegEvidence_Array.addAllegationEvidence(rowcinv44sogAllegEvidence);
          rowQty++;
        }
        allegEvidence_Array.setUlRowQty(rowQty);
      }
      rowcinv44sog.setAllegEvidence_ARRAY(allegEvidence_Array);
    }
  }

  private ROWCINV44SOG_ARRAY retrieveSvcDeliveryAllegations(int idStage) throws ServiceException {
    // cinv90d
    List<Map> mapList = allegationDAO.findAllegationsByIdStageAndIdSituation(idStage);
    ROWCINV44SOG_ARRAY rowcinv44sog_array = new ROWCINV44SOG_ARRAY();
    if (mapList == null || mapList.isEmpty()) {
      throw new ServiceException(Messages.MSG_INV_NO_ALLEGS);
    } else {
      for (Iterator<Map> it = mapList.iterator(); it.hasNext();) {
        Map map = it.next();
        ROWCINV44SOG rowcinv44sog = new ROWCINV44SOG();
        rowcinv44sog.setSzScrPersVictim((String) map.get("nmPersonFull"));
        rowcinv44sog.setUlIdVictim((Integer) map.get("personByIdVictim") != null ? (Integer) map.get(
                "personByIdVictim") : 0);
        rowcinv44sog.setSzCdAllegType((String) map.get("cdAllegType"));
        rowcinv44sog.setSzScrAllegPerp((String) map.get("nmPersVictim"));
        rowcinv44sog.setUlIdAllegedPerpetrator((Integer) map.get("personByIdAllegedPerpetrator") != null ?
                                               (Integer) map.get("personByIdAllegedPerpetrator") : 0);
        rowcinv44sog.setCdAllegDisposition((String) map.get("cdAllegDisposition"));
        rowcinv44sog.setSzCdAllegIncidentStage((String) map.get("cdAllegIncidentStage"));
        rowcinv44sog.setUlIdAllegation((Integer) map.get("idAllegation") != null ? (Integer) map.get("idAllegation") :
                                       0);
        rowcinv44sog.setTsLastUpdate((Date) map.get("dtLastUpdate"));
        rowcinv44sog_array.addROWCINV44SOG(rowcinv44sog);
      }
    }
    return rowcinv44sog_array;
  }

  private int retrieveIdStageForInvestigation(int idCase, int idStage) throws ServiceException {
    // clsc59d
    List<Stage> stageList = stageDAO.findStageByIdCase(idCase);
    if (stageList == null || stageList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    for (Iterator<Stage> it = stageList.iterator(); it.hasNext();) {
      Stage stage = it.next();
      if (INVESTIGATION.equals(stage.getCdStage())) {
        return stage.getIdStage();
      }
    }
    // Return the existing stage if we get here.
    return idStage;
  }

  private ROWCINV44SOG_ARRAY processIntakeAllegationDAO(int idStage) throws ServiceException {
    // cinv91d
    List<Map> mapList = intakeAllegationDAO.findIntakeAllegationByPersonByIdVictimAndIdStage(idStage);
    if (mapList == null || mapList.isEmpty()) {
      throw new ServiceException(Messages.MSG_INV_NO_ALLEGS);
    }
    ROWCINV44SOG_ARRAY rowcinv44sog_array = new ROWCINV44SOG_ARRAY();
    for (Iterator<Map> it = mapList.iterator(); it.hasNext();) {
      Map map = it.next();
      ROWCINV44SOG row = new ROWCINV44SOG();
      row.setSzScrPersVictim((String) map.get("bnmPersonFull"));
      row.setUlIdVictim((Integer) map.get("personByIdVictim") != null ? (Integer) map.get("personByIdVictim") : 0);
      row.setSzCdAllegType((String) map.get("cdIntakeAllegType"));
      row.setSzScrAllegPerp((String) map.get("nmPersonFull"));
      row.setUlIdAllegedPerpetrator((Integer) map.get("idPerson") != null ? (Integer) map.get("idPerson") : 0);
      row.setSzCdAllegIncidentStage((String) map.get("cdStage"));
      row.setUlIdAllegation((Integer) map.get("idAllegation") != null ? (Integer) map.get("idAllegation") : 0);
      rowcinv44sog_array.addROWCINV44SOG(row);
    }
    return rowcinv44sog_array;
  }

  private void retrieveCPSInvstDetailCdAllegDispositionAndIdEvent(int idStage, CINV44SO cinv44so)
          throws ServiceException {
    // cinv95d
    CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
    if (cpsInvstDetail == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    cinv44so.setCdAllegDisposition(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn());
    cinv44so.setUlIdEvent(cpsInvstDetail.getIdEvent() != null ? cpsInvstDetail.getIdEvent() : 0);
  }

  private void retrieveFacilityInvstDtlCdAllegDispositionAndIdEvent(int idStage, CINV44SO cinv44so)
          throws ServiceException {
    // cinv17d
    FacilityInvstDtl facilityInvstDtl = facilityInvstDtlDAO.findFacilityInvstDtlByIdStage(idStage);
    if (facilityInvstDtl == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    cinv44so.setCdAllegDisposition(facilityInvstDtl.getCdFacilInvstOvrallDis());
    cinv44so.setUlIdEvent(facilityInvstDtl.getIdEvent() != null ? facilityInvstDtl.getIdEvent() : 0);
  }

  private void retrieveLicensingInvstDtlCdAllegDispositionAndIdEvent(int idStage, CINV44SO cinv44so)
          throws ServiceException {
    // cinv74d
    LicensingInvstDtl licensingInvstDtl = licensingInvstDtlDAO.findLicensingInvstDtlByIdStageOnly(idStage);
    if (licensingInvstDtl == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    cinv44so.setCdAllegDisposition(licensingInvstDtl.getCdLicngInvstOvrallDisp());
    cinv44so.setUlIdEvent(licensingInvstDtl.getIdEvent() != null ? licensingInvstDtl.getIdEvent() : 0);
  }

  private void updateEventBasedOnStatus(CINV44SO cinv44so) throws ServiceException {
    // Using on the ID EVENT from the overall disposition determine the status of the event.  If the status is pending
    //   (PEND), return the ID EVENT to the client Else, return null.
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(cinv44so.getUlIdEvent());
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    if (!EVENT_STATUS_PENDING.equals(event.getCdEventStatus())) {
      cinv44so.setUlIdEvent(0);
    }
  }
}
 