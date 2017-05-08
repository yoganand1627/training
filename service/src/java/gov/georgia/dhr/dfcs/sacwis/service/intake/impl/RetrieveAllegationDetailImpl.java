package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegEvidenceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveAllegationDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveAllegationDetailImpl extends BaseServiceImpl implements RetrieveAllegationDetail {

  private AllegationDAO allegationDAO = null;

  private AllegEvidenceDAO allegEvidenceDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  private EventDAO eventDAO = null;
  
  private EmployeeDAO employeeDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private static final String SPECIAL_INVESTIGATION_TASK = "2270";
  
  private static final String PRU_STAFF_SECURITY_CLASS_NAME = "STATE_CONC";
  
  public static final String DEPUTY_DIRECTOR_SEC_CLASS = "DEPUTY_DIRECTOR";

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setAllegEvidenceDAO(AllegEvidenceDAO allegEvidenceDAO) {
    this.allegEvidenceDAO = allegEvidenceDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public CINV46SO retrieveAllegationDetail(CINV46SI cinv46si) {
    CINV46SO cinv46so = new CINV46SO();

    String isUnderReview = ArchitectureConstants.N;
    String hasOpenSpecialInvestigation = getHasOpenSpecialInvestigation(cinv46si.getUlIdStage());
           
    Integer idUser = Integer.parseInt(cinv46si.getArchInputStruct().getSzUserId());
    Boolean isDeputyPolicyDirector = false;
    Boolean hasStageAccess = CaseUtility.hasStageAccess(idUser, cinv46si.getUlIdStage());
    
    
    if(hasSecurityClass(idUser, DEPUTY_DIRECTOR_SEC_CLASS) || hasSecurityClass(idUser, PRU_STAFF_SECURITY_CLASS_NAME)){
      isDeputyPolicyDirector = true;
    }

    // CAPTA 4.3 Policy Unit members and Deputy Directors will be able to view and update existing Allegation Details
    if (ArchitectureConstants.Y.equals(hasOpenSpecialInvestigation) && (hasStageAccess || isDeputyPolicyDirector)) {
      isUnderReview = ArchitectureConstants.Y;
    }

    // The call to allegationDAO.findAllegationByIdAllegation() only applies if there is a non-zero idAllegation.
    if (0 != cinv46si.getUlIdAllegation()) {
      // cinv06d
      Allegation allegation = allegationDAO.findAllegationByIdAllegation(cinv46si.getUlIdAllegation());
      if (allegation != null) {
        cinv46so.setCdAllegDisposition(allegation.getCdAllegDisposition());
        cinv46so.setSzCdAllegIncidentStage(allegation.getCdAllegIncidentStage());
        cinv46so.setSzCdAllegSeverity(allegation.getCdAllegSeverity());
        cinv46so.setIndCrimChrgsFiled(allegation.getIndCrimChrgsFiled());
        cinv46so.setSzCdAllegType(allegation.getCdAllegType());
        cinv46so.setSzTxtAllegDuration(allegation.getTxtAllegDuration());
        cinv46so.setTsLastUpdate(allegation.getDtLastUpdate());
        cinv46so.setSzTxtEvidenceSummary(allegation.getTxtEvidenceSummary());
        cinv46so.setDtDtAllegedIncident(DateHelper.toCastorDate(allegation.getDtAllegedIncident()));
        cinv46so.setSzCdAllegedMalLocation(allegation.getCdAllegedMalLocation());
        cinv46so.setSzCdMaltreatorRel(allegation.getCdMaltreatorRel());
        cinv46so.setCIndMaltreatInCare(allegation.getIndMaltreatInCare());
        cinv46so.setCIndUnsubMIC(allegation.getIndUnSubMaltreatInCare());
        // CAPTA Changes Added
        cinv46so.setDtPriorNearFatalMaltrtmnt(DateHelper.toCastorDate(allegation.getDtPriorNearFatalMaltrtmnt()));
        cinv46so.setIndChildDeathSeverity(allegation.getIndChildDeathSeverity());
        cinv46so.setAllegEvidence_ARRAY(retrieveAllegEvidence(allegation.getIdAllegation()));
        cinv46so.setCIndCpsPolicyViolation(isUnderReview);
      }
    }
    // cinv69d
    cinv46so.setCINV46SOG1_ARRAY(getStagePersonLinkInfo(cinv46si.getUlIdStage()));
    cinv46so.setDtDtTodaysDate(DateHelper.getTodayCastorDate());
    return cinv46so;
  }

  private int getIdCase(int ulIdStage) {
    int idCase = 0;
    Stage stage = getPersistentObject(Stage.class, ulIdStage);
    if(stage != null){
      idCase = stage.getCapsCase().getIdCase();
    } 
    return idCase;
  }

  /*
   * CAPTA 4.3 The Allegation Detail has functionality that allows modify access to support MIC and Policy Violation
   * Special Investigations. After the investigation is approved, if either of the “Is this Maltreatment in Care?” or
   * “Is this a Policy Violation?” questions have a response of ‘Yes’, then this page can be accessed in Modify mode
   * until the Special Investigation event (accessed from the Special Investigation Page) has been approved by the
   * Policy Unit
   * 
   */
  private String getHasOpenSpecialInvestigation(int idStage) {
    String violationStatus = ArchitectureConstants.N;
    gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.Event specialInvEvent = CaseUtility.getEvent(idStage, SPECIAL_INVESTIGATION_TASK);
    if (specialInvEvent != null) {
     Stage stage = getPersistentObject(Stage.class, idStage);
      // CAPTA 4.3 Since Special Investigation will not occur without the maltreatment or policy violation I removed the check for them. 
      if (ArchitectureConstants.Y.equals(stage.getIndStageClose())
          && !CodesTables.CEVTSTAT_APRV.equals(specialInvEvent.getCdEventStatus())) {
        violationStatus = ArchitectureConstants.Y;
      }
    }

    return violationStatus;
  }


  
  /**
   * This method checks if the logged in person has assigned the Security Class
   * @param idPerson
   * @param securityClassName
   * @return
   */
  private boolean hasSecurityClass(int idPerson, String securityClassName) {
    boolean hasSecClass = false;
    List<Integer> empList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(securityClassName);
    if (empList != null && !empList.isEmpty()) {
      for (Iterator <Integer> it = empList.iterator(); it.hasNext();) {
        if(idPerson == it.next().intValue() ) {
          hasSecClass = true;
          break;
        }
      }
    }
    return hasSecClass;
 }
  


  private CINV46SOG1_ARRAY getStagePersonLinkInfo(int idStage) {
    // Calling cinv69d
    List<Map> stagePersonList = stagePersonLinkDAO
                                                  .findPersonAndStagePersonLinkByIdPersonIdStageAndCdStagePersType(idStage);
    CINV46SOG1_ARRAY cinv4sog1_array = new CINV46SOG1_ARRAY();
    if (stagePersonList != null && !stagePersonList.isEmpty()) {
      for (Iterator<Map> it = stagePersonList.iterator(); it.hasNext();) {
        Map map = it.next();
        CINV46SOG1 row = new CINV46SOG1();
        row.setUlIdPerson((Integer) map.get("idPerson") != null ? (Integer) map.get("idPerson") : 0);
        row.setSzNmPersonFull((String) map.get("nmPersonFull"));
        row.setSzCdPersonMaritalStatus((String) map.get("cdPersonMaritalStatus"));
        row.setDtDtPersonBirth(DateHelper.toCastorDate((Date) map.get("dtPersonBirth")));
        row.setSzCdStagePersRole((String) map.get("cdStagePersRole"));
        row.setTsLastUpdate((Date) map.get("dtLastUpdate"));
        cinv4sog1_array.addCINV46SOG1(row);
      }
    }
    return cinv4sog1_array;
  }

  private AllegEvidence_ARRAY retrieveAllegEvidence(int idAllegation) {

    int rowQty = 0;
    List<AllegEvidence> allegEvidenceList = allegEvidenceDAO.findAllegEvidenceByIdAllegation(idAllegation);
    AllegEvidence_ARRAY allegEvidence_Array = new AllegEvidence_ARRAY();
    if (allegEvidenceList != null || !allegEvidenceList.isEmpty() || allegEvidenceList.size() != 0) {
      for (Iterator<AllegEvidence> it = allegEvidenceList.iterator(); it.hasNext();) {
        AllegEvidence allegEvidence = it.next();
        AllegationEvidence cinv46soAllegEvidence = new AllegationEvidence();
        cinv46soAllegEvidence.setUlIdAllegEvidence(allegEvidence.getIdAllegEvidence().intValue());
        cinv46soAllegEvidence.setUlIdAllegation(allegEvidence.getAllegation().getIdAllegation());
        cinv46soAllegEvidence.setSzCdEvidenceCode(allegEvidence.getCdEvidenceCode());
        cinv46soAllegEvidence.setTsLastUpdate(allegEvidence.getDtLastUpdate());
        allegEvidence_Array.addAllegationEvidence(cinv46soAllegEvidence);
        rowQty++;
      }
      allegEvidence_Array.setUlRowQty(rowQty);
    }
    return allegEvidence_Array;
  }
}
