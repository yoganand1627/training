package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChildPlanParticipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FaIndivTrainingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonHomeRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.PersonMergeValidation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC23SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr_ARRAY;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;

/* Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
 02/11/2010  wjcochran         SMS #37406: Modified private methods CallCompareServiceAuth and
                               CompareServiceAuth to take in the variable for idPersMergeForward
                               for use in determining if the Forward & Closed IDs are part of
                               one service authorization.
                               
 03/05/2010  swroberts         Added validation for MR-062 Contact Standards to make sure there are not
                               two people in the same standard.  If this condition happened a merge would
                               not be possible. 
                                
*/
public class PersonMergeValidationImpl extends BaseServiceImpl implements PersonMergeValidation {

  public static final char CD_ACTIVE = 'A';

  public static final String CLOSED = "0";

  public static final String UNKNOWN_NAME = "Unknown";

  public static final char CD_MERGED = 'M';

  public static final int AGE_MAX_DIFF = 10;

  public static final String EMPLOYEE_CATEGORY = "EMP";

  public static final String EMPLOYEE_CATEGORY_FORMER = "FEM";

  public static final String PREP_ADULT_LIVING = "PAL";

  public static final String POST_ADOPT = "PAD";

  public static final String INTAKE_STAGE = "INT";

  private static class LocalVariables {

    private int EditCounter = 0;

    private int Year1 = 0;

    private int Year2 = 0;

    private int Month1 = 0;

    private int Month2 = 0;

    private int Day1 = 0;

    private int Day2 = 0;

    private boolean bIndOpenPCStage = false;

    private boolean bIndPalPad = false;

    private int bIndBothActive = 0;

    private int bIndPersClosedActive = 0;

    private char bStageFound = (char) 0;

    private String bPersonClosedIsEmp = ArchitectureConstants.FALSE;

    private String bMatchFound = ArchitectureConstants.FALSE;

    public int getBIndBothActive() {
      return bIndBothActive;
    }

    public void setBIndBothActive(int indBothActive) {
      bIndBothActive = indBothActive;
    }

    public boolean isBIndOpenPCStage() {
      return bIndOpenPCStage;
    }

    public void setBIndOpenPCStage(boolean indOpenPCStage) {
      bIndOpenPCStage = indOpenPCStage;
    }

    public boolean isBIndPalPad() {
      return bIndPalPad;
    }

    public void setBIndPalPad(boolean indPalPad) {
      bIndPalPad = indPalPad;
    }

    public int getBIndPersClosedActive() {
      return bIndPersClosedActive;
    }

    public void setBIndPersClosedActive(int indPersClosedActive) {
      bIndPersClosedActive = indPersClosedActive;
    }

    public char getBStageFound() {
      return bStageFound;
    }

    public void setBStageFound(char stageFound) {
      bStageFound = stageFound;
    }

    public int getDay1() {
      return Day1;
    }

    public void setDay1(int day1) {
      Day1 = day1;
    }

    public int getDay2() {
      return Day2;
    }

    public void setDay2(int day2) {
      Day2 = day2;
    }

    public int getEditCounter() {
      return EditCounter;
    }

    public void setEditCounter(int editCounter) {
      EditCounter = editCounter;
    }

    public void incEditCounter() {
      EditCounter++;
    }

    public int getMonth1() {
      return Month1;
    }

    public void setMonth1(int month1) {
      Month1 = month1;
    }

    public int getMonth2() {
      return Month2;
    }

    public void setMonth2(int month2) {
      Month2 = month2;
    }

    public int getYear1() {
      return Year1;
    }

    public void setYear1(int year1) {
      Year1 = year1;
    }

    public int getYear2() {
      return Year2;
    }

    public void setYear2(int year2) {
      Year2 = year2;
    }

    public String getBPersonClosedIsEmp() {
      return bPersonClosedIsEmp;
    }

    public void setBPersonClosedIsEmp(String personClosedIsEmp) {
      bPersonClosedIsEmp = personClosedIsEmp;
    }

    public String getBMatchFound() {
      return bMatchFound;
    }

    public void setBMatchFound(String matchFound) {
      bMatchFound = matchFound;
    }
  }

  private PersonDAO personDAO = null;

  private ComplexPersonIdDAO complexPersonIdDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private PptParticipantDAO pptParticipantDAO = null;

  private ChildPlanParticipDAO childPlanParticipDAO = null;

  private RiskFactorsDAO riskFactorsDAO = null;

  private PersonHomeRemovalDAO personHomeRemovalDAO = null;

  private FaIndivTrainingDAO faIndivTrainingDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private AllegationDAO allegationDAO = null;

  private NameDAO nameDAO = null;

  private PersonEligibilityDAO personEligibilityDAO = null;
  
  private ContactRuleDAO contactRuleDAO = null;
  
  private ContactForDAO contactForDAO = null;

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setFaIndivTrainingDAO(FaIndivTrainingDAO faIndivTrainingDAO) {
    this.faIndivTrainingDAO = faIndivTrainingDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setComplexPersonIdDAO(ComplexPersonIdDAO complexPersonIdDAO) {
    this.complexPersonIdDAO = complexPersonIdDAO;
  }

  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setRiskFactorsDAO(RiskFactorsDAO riskFactorsDAO) {
    this.riskFactorsDAO = riskFactorsDAO;
  }

  public void setPersonHomeRemovalDAO(PersonHomeRemovalDAO personHomeRemovalDAO) {
    this.personHomeRemovalDAO = personHomeRemovalDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setPptParticipantDAO(PptParticipantDAO pptParticipantDAO) {
    this.pptParticipantDAO = pptParticipantDAO;
  }

  public void setChildPlanParticipDAO(ChildPlanParticipDAO childPlanParticipDAO) {
    this.childPlanParticipDAO = childPlanParticipDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setPersonEligibilityDAO(PersonEligibilityDAO personEligibilityDAO) {
    this.personEligibilityDAO = personEligibilityDAO;
  }

  public void setContactRuleDAO(ContactRuleDAO contactRuleDAO) {
    this.contactRuleDAO = contactRuleDAO;
  }  

  public void setContactForDAO(ContactForDAO contactForDAO) {
    this.contactForDAO = contactForDAO;
  } 
  
  public CCFC23SO personMergeValidation(CCFC23SI ccfc23si) throws ServiceException {
    CCFC23SO ccfc23so = new CCFC23SO();
    ArchInputStruct archInputStruct = ccfc23si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    LocalVariables localVariables = new LocalVariables();
    boolean bContinue = true;

    processPersonDAO(ccfc23si.getUlIdPersMergeForward(), ccfc23si.getUlIdPersMergeClosed(),
                     ccfc23si.getCWcdPersonPassedIn(), ccfc23so, localVariables);

    SzCdUerrorMsgNbr_ARRAY ccfc23so_szCdUerrorMsgNbr_ARRAY = ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY();

    if (ccfc23so_szCdUerrorMsgNbr_ARRAY != null && ccfc23so_szCdUerrorMsgNbr_ARRAY.getSzCdUerrorMsgNbrCount() > 0
        && ccfc23so_szCdUerrorMsgNbr_ARRAY.getSzCdUerrorMsgNbr(0) == Messages.MSG_MERGE_ID_TO) {
      bContinue = false;
    }
    if (bContinue) {

      processComplexPersonIdDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(), ccfc23so,
                                localVariables);
      processPersonPhoneDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(), ccfc23so,
                            localVariables);
      processIncomeAndResourceDAO(ccfc23si.getUlIdPersMergeForward(), ccfc23si.getUlIdPersMergeClosed(), ccfc23so,
                                  localVariables);
      processEligibilityDAO(ccfc23si.getUlIdPersMergeForward(), ccfc23si.getUlIdPersMergeClosed(), ccfc23so,
                            localVariables);
      callCheckBothPersonId(ccfc23si.getUlIdPersMergeForward(), ccfc23si.getUlIdPersMergeClosed(), ccfc23so,
                            localVariables, pageNbr, pageSize);
      processStageDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(), ccfc23so, localVariables,
                      pageNbr, pageSize);
      if (localVariables.getBIndPersClosedActive() != 0) {
        processPersonLinkDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23so, localVariables, pageNbr, pageSize);
      }
      if (localVariables.getBIndBothActive() != 0) {
        processPersonLinkDAOCountByIdPerson(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(),
                                            ccfc23so, localVariables);
      }
      
      // MR-062 Added call to validate against contact standards
      processContactStandardsDAOCountByIdPerson(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(),
                                                ccfc23so, localVariables);
      
      processPptParticipantDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(), ccfc23so,
                               localVariables);
      processChildPlanParticipDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(), ccfc23so,
                                  localVariables);
      processRiskFactorsDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(), ccfc23so,
                            localVariables);
      processPersonHomeRemovalDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(), ccfc23so,
                                  localVariables);
      processFaIndivTrainingDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(), ccfc23so,
                                localVariables);
      CallCompareServiceAuth(ccfc23si.getUlIdPersMergeClosed(), ccfc23si.getUlIdPersMergeForward(),
                             ccfc23so, localVariables, pageNbr, pageSize);
      processAllegationDAO(ccfc23si.getUlIdPersMergeForward(), ccfc23si.getUlIdPersMergeClosed(), ccfc23so,
                           localVariables);

      // if (ccfc23so_szCdUerrorMsgNbr_ARRAY.getSzCdUerrorMsgNbr(0) != Messages.MSG_MERGE_ID_TO) {
      processNameDAO(ccfc23si.getUlIdPersMergeForward(), ccfc23so);
      // }
      // if (ccfc23so_szCdUerrorMsgNbr_ARRAY.getSzCdUerrorMsgNbr(0) != Messages.MSG_MERGE_ID_TO) {
      processNameDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23so);
      // }

      processStageDAOCountOpenStages(ccfc23si.getUlIdPersMergeClosed(), ccfc23so, localVariables);
      processPersonEligibilityDAO(ccfc23si.getUlIdPersMergeClosed(), ccfc23so, localVariables);
      processStagePersonLinkDAO(ccfc23si.getUlIdPersMergeForward(), ccfc23si.getUlIdPersMergeClosed(), ccfc23so,
                                localVariables, pageNbr, pageSize);
    }
    return ccfc23so;
  }

  private void processStagePersonLinkDAO(int idPersMergeForward, int idPersMergeClosed, CCFC23SO ccfc23so,
                                         LocalVariables localVariables, int pageNbr, int pageSize) {

    PaginatedHibernateList<Integer> integerList = stagePersonLinkDAO.findIdStageByIdPerson(idPersMergeForward,
                                                                                           idPersMergeClosed, pageNbr,
                                                                                           pageSize);

    if (integerList != null && !integerList.isEmpty()) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_CANT_MERGE_TO_WORKER);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
  }

  private void processPersonEligibilityDAO(int idPersMergeClosed, CCFC23SO ccfc23so, LocalVariables localVariables) {
    long count = personEligibilityDAO.countPersonEligibilityByIdPersEligPersonAndSysDate(idPersMergeClosed);
    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_PERS_CLD_OPN_ELIG);
      localVariables.incEditCounter();
    }

  }

  private void processStageDAOCountOpenStages(int idPersMergeClosed, CCFC23SO ccfc23so, LocalVariables localVariables) {
    long count = stageDAO.countOpenStagesByIdPersonAndIdStages(idPersMergeClosed);
    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_PERS_CLD_OPN_STAGE);
      localVariables.incEditCounter();
    }
  }

  private void processNameDAO(int idPerson, CCFC23SO ccfc23so) {

    Map map = nameDAO.findNameFromNameAndPhoneticNameByIdPerson(idPerson);

    ccfc23so.setSzNmNameFirst((String) map.get("nmNameFirst"));
    ccfc23so.setSzNmNameMiddle((String) map.get("nmNameMiddle"));
    ccfc23so.setSzNmNameLast((String) map.get("nmNameLast"));

  }

  private void processAllegationDAO(int idPersMergeForward, int idPersMergeClosed, CCFC23SO ccfc23so,
                                    LocalVariables localVariables) {

    long count = allegationDAO.countCasesOfVictimPrepetratorMerge(idPersMergeForward, idPersMergeClosed);

    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_PERS_VC_ALLEGED);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
  }

  private void CallCompareServiceAuth(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so, 
                                      LocalVariables localVariables, int pageNbr, int pageSize) {
    // CompareServiceAuth(idPersMergeClosed, ccfc23so, localVariables);
    CompareServiceAuth(idPersMergeClosed, idPersMergeForward, localVariables, pageNbr, pageSize);

    if (localVariables != null && (ArchitectureConstants.TRUE).equals(localVariables.getBMatchFound())) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_SERV_AUTH);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void CompareServiceAuth(int idPersMergeClosed, int idPersMergeForward, LocalVariables localVariables, int pageNbr, int pageSize) {
    // Calling clscb8
    PaginatedHibernateList<Map> mapList = svcAuthDetailDAO.findSvcAuthDetailByIdPerson(idPersMergeClosed, pageNbr,
                                                                                       pageSize);

    if (mapList != null && mapList.size() > 0) {

      for (Iterator<Map> it = mapList.iterator(); it.hasNext();) {
        Map map = it.next();
        
        /*
         * SMS #37406 - Changed the DAO Method call. Also, rather than use the idPersMergeClosed, use the
         * idPersMergeForward. This is to ensure that two people IDs are not a part of the same service
         * authorization detail.
         */
        SvcAuthDetail svAuthDetail = svcAuthDetailDAO.findSvcAuthDtlByIdPersonIdSvcAuthDtl((Integer) map.get("idSvcAuthDtl"),
                                                                                  (Integer) map.get("idResource"),
                                                                                  (String) map.get("cdSvcAuthDtlSvc"),
                                                                                  idPersMergeForward,
                                                                                  (Date) map.get("dtSvcAuthDtlTerm"),
                                                                                  (Date) map.get("dtSvcAuthDtlBegin"));

        if (svAuthDetail != null) {
          localVariables.setBMatchFound(ArchitectureConstants.TRUE);
        }
      }
    }
  }

  private void processFaIndivTrainingDAO(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                         LocalVariables localVariables) {
    long count = faIndivTrainingDAO.countFaIndivTrainingByIdPerson(idPersMergeClosed, idPersMergeForward);

    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_TRAIN);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }

  }

  private void processPersonHomeRemovalDAO(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                           LocalVariables localVariables) {
    long count = personHomeRemovalDAO.countPersonHomeRemovalByIdPersMerge(idPersMergeForward, idPersMergeClosed);
    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_PERS_HOME);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
  }

  private void processRiskFactorsDAO(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                     LocalVariables localVariables) {

    long count = riskFactorsDAO.countRiskFactorsByIdPerson(idPersMergeClosed, idPersMergeForward);

    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_RISK_ASSMT);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
  }

  private void processChildPlanParticipDAO(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                           LocalVariables localVariables) {
    long count = childPlanParticipDAO.countChildPlanParticipEvents(idPersMergeForward, idPersMergeClosed);

    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_CP_PART);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }

  }

  private void processPptParticipantDAO(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                        LocalVariables localVariables) {
    long count = pptParticipantDAO.countPptParticipant(idPersMergeClosed, idPersMergeForward);

    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_PPT);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
  }

  private void processPersonLinkDAOCountByIdPerson(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                                   LocalVariables localVariables) {

    long count = eventPersonLinkDAO.countByIdPersonIdNewPerson(idPersMergeClosed, idPersMergeForward);
    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_DUP_EVENT);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();

    }

  }

  
  private void processContactStandardsDAOCountByIdPerson(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                                   LocalVariables localVariables) {

    long ruleCount = contactRuleDAO.countByIdPersonIdNewPerson(idPersMergeClosed, idPersMergeForward);
    long forCount = contactForDAO.countByIdPersonIdNewPerson(idPersMergeClosed, idPersMergeForward);
    if (ruleCount != 0 || forCount != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_CONTACT_STANDARD);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();

    }

  }  
  
  
  private void processPersonLinkDAO(int idPersMergeClosed, CCFC23SO ccfc23so, LocalVariables localVariables,
                                    int pageNbr, int pageSize) {

    PaginatedHibernateList<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO
                                                                                    .findStagePersonLinkByIdPersonAndCdStage(
                                                                                                                             idPersMergeClosed,
                                                                                                                             INTAKE_STAGE,
                                                                                                                             pageNbr,
                                                                                                                             pageSize);

    if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_INTAKE);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
  }

  private void processStageDAO(int idPerMergeClosed, int idPerMergeForward, CCFC23SO ccfc23so,
                               LocalVariables localVariables, int pageNbr, int pageSize) {

    PaginatedHibernateList<Stage> stageList = stageDAO.findStageByIdPerson(idPerMergeClosed, pageNbr, pageSize);
    PaginatedHibernateList<Stage> stageListForward = stageDAO.findStageByIdPerson(idPerMergeForward, pageNbr, pageSize);
    boolean bMergePC = false;
    for (Iterator<Stage> it = stageList.iterator(); it.hasNext();) {
      Stage stage = it.next();
      // bMergePC = false;
      if (DateHelper.isNull(stage.getDtStageClose()) && !bMergePC) {
        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                     Messages.MSG_MERGE_PC);
        ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
        localVariables.incEditCounter();
        localVariables.setBIndOpenPCStage(true);
        bMergePC = true;
      }

      if (stage.getCdStage().equals(POST_ADOPT)) {
        localVariables.setBIndPalPad(true);
      }
    }
    
    //only check to see about merging if your closed person is in a PAD stage
    if (localVariables.isBIndPalPad()) {
      boolean sameStageType = false;
      //look through all forward stages for a PAD stage
      for (Iterator<Stage> itForward = stageListForward.iterator(); itForward.hasNext();) {
        Stage stageForward = itForward.next();
        sameStageType = false;
        for (Iterator<Stage> it = stageList.iterator(); it.hasNext();) {
          Stage stage = it.next();
          if (stageForward.getCdStage().equals(stage.getCdStage())) {
            sameStageType = true;
            break;
          }
        }
      }
      //if there is not a PAD stage for your forward person, give message: 
      //"Person Forward must have been a Primary Child in the same type of stage as the Person Closed."
      if (!sameStageType) {
        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                     Messages.MSG_MERGE_BOTH_PC);
        ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
        localVariables.incEditCounter();
      }
    }
  }

  private void callCheckBothPersonId(int idPersMergeForward, int idPersMergeClosed, CCFC23SO ccfc23so,
                                     LocalVariables localVariables, int pageNbr, int pageSize) {
    CheckBothPersonIds(idPersMergeForward, idPersMergeClosed, localVariables, pageNbr, pageSize);

    if (localVariables != null && (ArchitectureConstants.TRUE).equals(localVariables.getBPersonClosedIsEmp())) {

      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_EMP);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
  }

  private void CheckBothPersonIds(int idPersMergeForward, int idPersMergeClosed, LocalVariables localVariables,
                                  int pageNbr, int pageSize) {
    // int i49 = 0;
    boolean bLocalPersonForwardIsEmp = false;
    boolean bLocalPersonClosedIsEmp = false;

    ROWCINV29DO_ARRAY closedCategory_array = findPersonCategory(idPersMergeClosed, pageNbr, pageSize);
    for (Enumeration enumCat = closedCategory_array.enumerateROWCINV29DO(); enumCat.hasMoreElements();) {
      ROWCINV29DO row = (ROWCINV29DO) enumCat.nextElement();
      if (EMPLOYEE_CATEGORY.equals(row.getSzCdCategoryCategory())
          || EMPLOYEE_CATEGORY_FORMER.equals(row.getSzCdCategoryCategory())) {
        bLocalPersonClosedIsEmp = true;
        break;
      }
    }
    if (bLocalPersonClosedIsEmp) {
      ROWCINV29DO_ARRAY forwardCategory_array = findPersonCategory(idPersMergeForward, pageNbr, pageSize);
      for (Enumeration enumCat = forwardCategory_array.enumerateROWCINV29DO(); enumCat.hasMoreElements();) {
        ROWCINV29DO row = (ROWCINV29DO) enumCat.nextElement();
        if (EMPLOYEE_CATEGORY.equals(row.getSzCdCategoryCategory())
            || EMPLOYEE_CATEGORY_FORMER.equals(row.getSzCdCategoryCategory())) {
          bLocalPersonForwardIsEmp = true;
          break;
        }
      }
    }
    /*
     * CINV29DI pPersonInput = null; CINV29DO pPersonOutput = null;
     * 
     * CallCINV29D(idPersMergeClosed, pPersonOutput);
     * 
     * for (i49 = 0; (i49 < pPersonOutput.getArchOutputStruct().getUlRowQty()); i49++) { if
     * ((pPersonOutput.getROWCINV29DO_ARRAY().getROWCINV29DO(i49).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY)) ||
     * (pPersonOutput.getROWCINV29DO_ARRAY().getROWCINV29DO(i49).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY_FORMER))) {
     * bLocalPersonClosedIsEmp = true;
     * 
     * break; } } if (bLocalPersonClosedIsEmp) { //CallCINV29D(idPersMergeForward, pPersonOutput);
     * 
     * for (i49 = 0; (i49 < pPersonOutput.getArchOutputStruct().getUlRowQty()); i49++) { if
     * ((pPersonOutput.getROWCINV29DO_ARRAY().getROWCINV29DO(i49).getSzCdCategoryCategory() .equals(EMPLOYEE_CATEGORY)) ||
     * (pPersonOutput.getROWCINV29DO_ARRAY().getROWCINV29DO(i49).getSzCdCategoryCategory()
     * .equals(EMPLOYEE_CATEGORY_FORMER))) { bLocalPersonForwardIsEmp = true;
     * 
     * break; } } }
     */

    if (bLocalPersonClosedIsEmp == true && bLocalPersonForwardIsEmp == false) {
      localVariables.setBPersonClosedIsEmp(ArchitectureConstants.TRUE);
    }
  }

  private ROWCINV29DO_ARRAY findPersonCategory(int idPerson, int pageNbr, int pageSize) {
    ROWCINV29DO_ARRAY rowcinv29do_array = new ROWCINV29DO_ARRAY();
    // Calling cinv29d
    PaginatedHibernateList<PersonCategory> personCategoryList = personCategoryDAO
                                                                                 .findPersonCategoryByIdPerson(
                                                                                                               idPerson,
                                                                                                               pageNbr,
                                                                                                               pageSize);
    if (personCategoryList != null && !personCategoryList.isEmpty() && personCategoryList.size() > 0) {
      for (Iterator<PersonCategory> it = personCategoryList.iterator(); it.hasNext();) {
        PersonCategory personCategory = it.next();
        ROWCINV29DO row = new ROWCINV29DO();
        row.setSzCdCategoryCategory(personCategory.getCdPersonCategory());
        rowcinv29do_array.addROWCINV29DO(row);
      }
    }
    return rowcinv29do_array;
  }

  private void processEligibilityDAO(int idPersMergeForward, int idPersMergeClosed, CCFC23SO ccfc23so,
                                     LocalVariables localVariables) {

    long count = eligibilityDAO.countEligibility(idPersMergeForward, idPersMergeClosed);

    if (count != 0) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_ELIG);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);

      localVariables.incEditCounter();
    }
  }

  private void processIncomeAndResourceDAO(int idPersMergeForward, int idPersMergeClosed, CCFC23SO ccfc23so,
                                           LocalVariables localVariables) {

    long count1 = incomeAndResourcesDAO.countIncomeAndResourceForToday(idPersMergeForward);
    long count2 = incomeAndResourcesDAO.countIncomeAndResourceForToday(idPersMergeClosed);
    long count3 = incomeAndResourcesDAO.countIncomeAndResourceMergeFwdClsdToday(idPersMergeForward, idPersMergeClosed);
    if (((count1 != 0) && (count2 != 0)) && ((count3 == 0) || ((count1 != count2) && (count1 != count3)))) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_INC_RSC);
      localVariables.incEditCounter();
    }
  }

  private void processPersonPhoneDAO(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                     LocalVariables localVariables) {
    // Calling csec61d
    Map mapClosed = personPhoneDAO.findPersonPhoneByIndPersAddrLinkPrimary(idPersMergeClosed);

    Map mapForward = personPhoneDAO.findPersonPhoneByIndPersAddrLinkPrimary(idPersMergeForward);

    if (localVariables != null && localVariables.getBIndBothActive() != 0
        && (mapClosed != null && !mapClosed.isEmpty()) && (mapForward != null && !mapForward.isEmpty())) {

      if (!StringHelper.checkForEquality((String) mapForward.get("addrPersAddrStLn1"),
                                         (String) mapClosed.get("addrPersAddrStLn1"))
          || !StringHelper.checkForEquality((String) mapForward.get("addrPersAddrStLn1"),
                                            (String) mapClosed.get("addrPersAddrStLn1"))
          || !StringHelper.checkForEquality((String) mapForward.get("addrPersonAddrCity"),
                                            (String) mapClosed.get("addrPersonAddrCity"))
          || !StringHelper.checkForEquality((String) mapForward.get("cdPersonAddrCounty"),
                                            (String) mapClosed.get("cdPersonAddrCounty"))
          || !StringHelper.checkForEquality((String) mapForward.get("addrPersonAddrZip"),
                                            (String) mapClosed.get("addrPersonAddrZip"))) {
        ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                     Messages.MSG_MERGE_ADDRESS);
        localVariables.incEditCounter();
      }

      /*
       * if (!mapForward.get("addrPersAddrStLn1").equals(mapClosed.get("addrPersAddrStLn1")) ||
       * !mapForward.get("addrPersonAddrCity").equals(mapClosed.get("addrPersonAddrCity")) ||
       * !mapForward.get("cdPersonAddrCounty").equals(mapClosed.get("cdPersonAddrCounty")) ||
       * !mapForward.get("addrPersonAddrZip").equals(mapClosed.get("addrPersonAddrZip"))) {
       * ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
       * Messages.MSG_MERGE_ADDRESS); localVariables.incEditCounter(); }
       */
    }
  }

  private void processComplexPersonIdDAO(int idPersMergeClosed, int idPersMergeForward, CCFC23SO ccfc23so,
                                         LocalVariables localVariables) {
    boolean[] results = new boolean[2];
    complexPersonIdDAO.findPersonIdByIdPerson(results, idPersMergeClosed, idPersMergeForward);
    if (false == results[0]) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_SSN);
      localVariables.incEditCounter();
    }
    if (false == results[1]) {
      ccfc23so.getROWCCFC23SOG00().getSzCdUerrorMsgNbr_ARRAY().addSzCdUerrorMsgNbr(localVariables.getEditCounter(),
                                                                                   Messages.MSG_MERGE_MEDICAID);
      localVariables.incEditCounter();
    }
  }

  private void processPersonDAO(int idPersMergeForward, int idPersMergeClosed, String cWcdPersonPassedIn,
                                CCFC23SO ccfc23so, LocalVariables localVariables) {

    ROWCCFC23SOG00 rowccfc23sog00 = new ROWCCFC23SOG00();
    SzCdUerrorMsgNbr_ARRAY errorMsgNbr_ARRAY = new SzCdUerrorMsgNbr_ARRAY();

    Person person = personDAO.findPersonByIdPerson(idPersMergeForward);

    if (person != null) {
      Person person2 = personDAO.findPersonByIdPerson(idPersMergeClosed);
      if (person2 != null) {
        if ((person.getCdPersonStatus() == null || person.getCdPersonStatus().codePointAt(0) == CD_ACTIVE)
            && (person2.getCdPersonStatus() == null || person2.getCdPersonStatus().charAt(0) == CD_ACTIVE)) {
          localVariables.setBIndBothActive(1);
        }

        if (person2.getCdPersonStatus() == null || person2.getCdPersonStatus().charAt(0) == CD_ACTIVE) {
          localVariables.setBIndPersClosedActive(1);
        }
        if (CLOSED.equals(cWcdPersonPassedIn)) {
          ccfc23so.setSzNmPersonFull(person.getNmPersonFull());
        } else {
          ccfc23so.setSzNmPersonFull(person2.getNmPersonFull());
        }

        if (person.getNmPersonFull() != null) {
          // No call to a dam is needed because you get the first and last name
          // from the dam in the last name
          // strstr() will find a sub-string within a string.
          int index = person.getNmPersonFull().indexOf(UNKNOWN_NAME);

          if (index != -1) {
            errorMsgNbr_ARRAY.addSzCdUerrorMsgNbr(localVariables.getEditCounter(), Messages.MSG_NO_MERGE_UNKNOWN_NAME);
            ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
            localVariables.incEditCounter();
          }
        }
        if ((!DateHelper.isNull(person.getDtPersonDeath())) && (!DateHelper.isNull(person2.getDtPersonDeath()))) {
          Calendar calendar1 = new GregorianCalendar();
          calendar1.setTime(person.getDtPersonDeath());
          Calendar calendar2 = new GregorianCalendar();
          calendar2.setTime(person2.getDtPersonDeath());

          if ((calendar1.get(Calendar.YEAR) != calendar2.get(Calendar.YEAR))
              || (calendar1.get(Calendar.MONTH) != calendar2.get(Calendar.MONTH))
              || (calendar1.get(Calendar.DAY_OF_MONTH) != calendar2.get(Calendar.DAY_OF_MONTH))) {
            errorMsgNbr_ARRAY.addSzCdUerrorMsgNbr(localVariables.getEditCounter(), Messages.MSG_MERGE_DOD);
            localVariables.incEditCounter();
          }
        }
        if ((person.getCdPersonSex() != null) && (person2.getCdPersonSex() != null)
            && (!person.getCdPersonSex().equals(person2.getCdPersonSex()))) {
          errorMsgNbr_ARRAY.addSzCdUerrorMsgNbr(localVariables.getEditCounter(), Messages.MSG_CMN_MERGE_SEX);
          localVariables.incEditCounter();
        }
        // cdPersonEthnicGroup is comprised of race and ethnicity values since one can't be without another
        if ((person.getCdPersonEthnicGroup() != null) && (person2.getCdPersonEthnicGroup() != null)
            && (!person.getCdPersonEthnicGroup().equals(person2.getCdPersonEthnicGroup()))) {
          errorMsgNbr_ARRAY.addSzCdUerrorMsgNbr(localVariables.getEditCounter(), Messages.MSG_CFC_RACE_MISMATCH);
          localVariables.incEditCounter();
        }

        String status = person.getCdPersonStatus();
        String status2 = person2.getCdPersonStatus();

        if ((StringHelper.isValid(status) && status.charAt(0) == CD_MERGED)
            || (StringHelper.isValid(status2) && status2.charAt(0) == CD_MERGED)) {
          errorMsgNbr_ARRAY.addSzCdUerrorMsgNbr(localVariables.getEditCounter(), Messages.MSG_MERGE_TO_MERGE);
          ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
          localVariables.incEditCounter();
        }

        if ((!DateHelper.isNull(person.getDtPersonBirth())) && (!DateHelper.isNull(person2.getDtPersonBirth()))) {

          Calendar calendar3 = new GregorianCalendar();
          // calendar1.setTime(person.getDtPersonBirth());
          calendar3.setTime(person.getDtPersonBirth());
          Calendar calendar4 = new GregorianCalendar();
          // calendar2.setTime(person2.getDtPersonBirth());
          calendar4.setTime(person2.getDtPersonBirth());
          if (calendar3.get(Calendar.YEAR) > calendar4.get(Calendar.YEAR)) {
            localVariables.setYear1(calendar3.get(Calendar.YEAR));
            localVariables.setMonth1(calendar3.get(Calendar.MONTH));
            localVariables.setDay1(calendar3.get(Calendar.DAY_OF_MONTH));
            localVariables.setYear2(calendar4.get(Calendar.YEAR));
            localVariables.setMonth2(calendar4.get(Calendar.MONTH));
            localVariables.setDay2(calendar4.get(Calendar.DAY_OF_MONTH));
          } else {
            localVariables.setYear2(calendar3.get(Calendar.YEAR));
            localVariables.setMonth2(calendar3.get(Calendar.MONTH));
            localVariables.setDay2(calendar3.get(Calendar.DAY_OF_MONTH));
            localVariables.setYear1(calendar4.get(Calendar.YEAR));
            localVariables.setMonth1(calendar4.get(Calendar.MONTH));
            localVariables.setDay1(calendar4.get(Calendar.DAY_OF_MONTH));
          }

          if (((localVariables.getYear1() - localVariables.getYear2()) > AGE_MAX_DIFF)
              || (((localVariables.getYear1() - localVariables.getYear2()) == AGE_MAX_DIFF) && (localVariables
                                                                                                              .getMonth1() > localVariables
                                                                                                                                           .getMonth2()))
              || (((localVariables.getYear1() - localVariables.getYear2()) == AGE_MAX_DIFF)
                  && (localVariables.getMonth1() == localVariables.getMonth2()) && (localVariables.getDay1() > localVariables
                                                                                                                             .getDay2()))) {
            errorMsgNbr_ARRAY.addSzCdUerrorMsgNbr(localVariables.getEditCounter(), Messages.MSG_MERGE_AGE);
            ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
            localVariables.incEditCounter();
          }

        }
      } else {
        errorMsgNbr_ARRAY.addSzCdUerrorMsgNbr(localVariables.getEditCounter(), Messages.MSG_MERGE_ID_TO);
        ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
        localVariables.incEditCounter();

      }
    } else {
      errorMsgNbr_ARRAY.addSzCdUerrorMsgNbr(localVariables.getEditCounter(), Messages.MSG_MERGE_ID_TO);
      ccfc23so.setCSysIndError(ArchitectureConstants.TRUE);
      localVariables.incEditCounter();
    }
    rowccfc23sog00.setSzCdUerrorMsgNbr_ARRAY(errorMsgNbr_ARRAY);
    ccfc23so.setROWCCFC23SOG00(rowccfc23sog00);
  }

}
