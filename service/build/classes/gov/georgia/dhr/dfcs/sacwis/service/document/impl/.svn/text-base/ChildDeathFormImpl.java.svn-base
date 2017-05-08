package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChldDthCauseCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChldDthNrFltySeriInjDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChldDthNrFltySeriInj;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.ChildDeathForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CHILDDEATHSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CHILDDEATHSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*Change History:
Date        User              Description
--------    ----------------  ----------------------------------------------------------------------------------------------------
03/03/2010  cwells            CAPTA: Initial Document creation. 
                                                     

*/

public class ChildDeathFormImpl extends BaseDocumentServiceImpl implements ChildDeathForm {
  private RelationshipDAO relationshipDAO;

  private StageDAO stageDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private PersonDAO personDAO;
  
  private PersonEthnicityDAO personEthnicityDAO;

  private IncomingDetailDAO incomingDetailDAO;

  private AllegationDAO allegationDAO;

  private StageLinkDAO stageLinkDAO;

  private CpsInvstDetailDAO cpsInvstDetailDAO;
  
  private ChldDthNrFltySeriInjDAO chldDthNrFltySeriInjDAO;
  
  private ChldDthCauseCbxDAO chldDthCauseCbxDAO;

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
  public void setChldDthNrFltySeriInjDAO(ChldDthNrFltySeriInjDAO chldDthNrFltySeriInjDAO) {
    this.chldDthNrFltySeriInjDAO = chldDthNrFltySeriInjDAO;
  }
  public void setChldDthCauseCbxDAO(ChldDthCauseCbxDAO chldDthCauseCbxDAO) {
    this.chldDthCauseCbxDAO = chldDthCauseCbxDAO;
  }

  public CHILDDEATHSO retrieveChildDeath(CHILDDEATHSI childDeathsi) {
    CHILDDEATHSO chidlDeathso = new CHILDDEATHSO();
    PreFillData preFillData = new PreFillData();
    int idStage = childDeathsi.getUlIdStage();
    int idUser = childDeathsi.getUlIdPerson();
    int idEvent = childDeathsi.getUlIdEvent();
    ChldDthNrFltySeriInj cldDthRec = chldDthNrFltySeriInjDAO.findChldDthNrFltySeriInjByIdEvent(idEvent);
    int idChild = cldDthRec.getIdChild();
    
    Person caseManager = (Person) getPersistentObject(Person.class, idUser);

    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    int idCase = stage.getCapsCase().getIdCase();
    Person child = (Person) getPersistentObject(Person.class, idChild);
    Date dtIncomingCall = incomingDetailDAO.findEarliestIncomingDetailDtByIdCase(stage.getCapsCase().getIdCase());

    populateSectionI(stage, child, preFillData);
    populateSectionII( cldDthRec,preFillData, dtIncomingCall, idEvent);
    populateSectionIII(preFillData, idChild, dtIncomingCall, idCase, stage);
    populateCmSection(preFillData, caseManager);

    preFillData.addBookmark(createBookmark(COUNTY_NAME, Lookup.simpleDecodeSafe(CodesTables.CCOUNT, stage.getCdStageCnty())));
    Date childDod = child.getDtPersonDeath();
    if (childDod != null) {
      preFillData.addBookmark(createBookmark(DOD, FormattingHelper.formatDate(childDod)));
    }

    chidlDeathso.setPreFillData(preFillData);
    return chidlDeathso;
  }     

  private void populateCmSection(PreFillData preFillData, Person caseManager) {
    preFillData.addBookmark(createBookmark(CASE_MANAGER, caseManager.getNmPersonFull()));
    preFillData.addBookmark(createBookmark(COMP_DATE, FormattingHelper.formatDate(new Date())));
  }

  private void populateSectionI(Stage stage, Person person, PreFillData preFillData) {
    preFillData.addBookmark(createBookmark(CHILD_NAME_LAST, person.getNmPersonLast()));
    preFillData.addBookmark(createBookmark(CHILD_NAME_FIRST, person.getNmPersonFirst()));
    if (person.getNmPersonMiddle() != null) {
      preFillData.addBookmark(createBookmark(CHILD_NAME_MIDDLE, person.getNmPersonMiddle().charAt(0)));
    }
    preFillData.addBookmark(createBookmark(CHILD_DOB, FormattingHelper.formatDate(person.getDtPersonBirth())));

    List<PersonEthnicity> personEthnicities = personEthnicityDAO.findPersonEthnicityByIdPerson(person.getIdPerson());
    if(personEthnicities != null || person.getCdPersonSex() != null){
     FormDataGroup group = createFormDataGroup(TMPLAT_CHILD_SEX, "CHILD_DEATH");
    
     if(personEthnicities != null && !personEthnicities.isEmpty()){
       Iterator<PersonEthnicity> it = personEthnicities.iterator();
     PersonEthnicity personEthnicity = it.next();
      String cdEthnicity = personEthnicity.getCdEthnicity();
     
     group.addBookmark(createBookmark(CHILD_ETHNICITY, Lookup.simpleDecodeSafe(CodesTables.CINDETHN, cdEthnicity)));
     }
     group.addBookmark(createBookmark(CHILD_SEX,
                                           Lookup.simpleDecodeSafe(CodesTables.CSEX, person.getCdPersonSex())));
     preFillData.addFormDataGroup(group);
   }
    populateRace(person, preFillData);
    preFillData.addBookmark(createBookmark(COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                           person.getCdPersonCounty())));
    preFillData.addBookmark(createBookmark(ZIP, person.getAddrPersonZip()));
    preFillData.addBookmark(createBookmark(CHILD_AGE, DateHelper.getAge(person.getDtPersonBirth())));
    if (!CodesTables.CSTAGES_INT.equals(stage.getCdStage())) {
      int idMother = determineParent(stage, MOTHER, person);
      if (idMother > 0) {
        Person mother = getPerson(idMother);
        preFillData.addBookmark(createBookmark(MOTHER_NAME, mother.getNmPersonFull()));
        preFillData.addBookmark(createBookmark(MOTHER_DOB, FormattingHelper.formatDate(mother.getDtPersonBirth())));
      }
      int idFather = determineParent(stage, FATHER, person);
      if (idFather > 0) {
        Person father = getPerson(idFather);
        preFillData.addBookmark(createBookmark(FATHER_NAME, father.getNmPersonFull()));
        preFillData.addBookmark(createBookmark(FATHER_DOB, FormattingHelper.formatDate(father.getDtPersonBirth())));
      }
    }
    if(CodesTables.CSTAGES_SUB.equals(stage.getCdStage()) || CodesTables.CSTAGES_ADO.equals(stage.getCdStage())){
    preFillData.addBookmark(createBookmark(LEGAL_CUST, "DFCS"));
    }
  }

  private void populateSectionII(ChldDthNrFltySeriInj cldDthRec, PreFillData preFillData, Date dtIncomingCall, int idEvent) {
    String sub24hour = null;
    if (dtIncomingCall != null) {
      preFillData.addBookmark(createBookmark(DT_REPORTED, FormattingHelper.formatDate(dtIncomingCall)));
    }
    if (cldDthRec.getReportSubmittedWithin24hrs() != null) {
      sub24hour = (ArchitectureConstants.Y.equals(cldDthRec.getReportSubmittedWithin24hrs())) ? "Yes" : "No";
    }

    preFillData.addBookmark(createBookmark(TWENTY_FOUR, sub24hour));
    preFillData.addBookmark(createBookmark(TWENTY_FOUR_COMMENT, cldDthRec.getCommentsReportSubmitted()));
    populateCauseOfDeath(preFillData, idEvent);
    preFillData.addBookmark(createBookmark(CAUSE_COMMENTS, cldDthRec.getCommentsCauseDeath()));
    preFillData.addBookmark(createBookmark(DEATH_COUNTY, Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                 cldDthRec.getCountyOfDeath())));
    preFillData.addBookmark(createBookmark(AUTO_COMP, Lookup.simpleDecodeSafe(CodesTables.CAUTCOMP,
                                                                              cldDthRec.getAutopsyCompleted())));
    preFillData.addBookmark(createBookmark(AUTO_COMMENTS, cldDthRec.getCommentsAutopsy()));
    preFillData.addBookmark(createBookmark(PREVENTABLE, Lookup.simpleDecodeSafe(CodesTables.CDEAPREV,
                                                                                cldDthRec.getDeathPreventable())));
    preFillData.addBookmark(createBookmark(PREVENTABLE_COMMENTS, cldDthRec.getCommentsDeathPreventable()));
    
  }

  private void populateCauseOfDeath(PreFillData preFillData, int idEvent) {
   List<String> causesOfDeath = chldDthCauseCbxDAO.findSavedCausesByIdEvent(idEvent);
    if (causesOfDeath != null && !causesOfDeath.isEmpty()) {
      for (Iterator<String> it = causesOfDeath.iterator(); it.hasNext();) {
        String cause = (String) it.next();
        if(CodesTables.CDCAUDEA_CDCOD01.equals(cause)){
          preFillData.addBookmark(createBookmark(INADEQUATE, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD11.equals(cause)){
          preFillData.addBookmark(createBookmark(FIREARM, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD07.equals(cause)){
          preFillData.addBookmark(createBookmark(SID, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD10.equals(cause)){
          preFillData.addBookmark(createBookmark(SUID, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD12.equals(cause)){
          preFillData.addBookmark(createBookmark(OTHER_EXP, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD04.equals(cause)){
          preFillData.addBookmark(createBookmark(CHILD_ABUSE, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD14.equals(cause)){
          preFillData.addBookmark(createBookmark(CHOKE, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD13.equals(cause)){
          preFillData.addBookmark(createBookmark(NATURAL, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD02.equals(cause)){
          preFillData.addBookmark(createBookmark(MOTOR_VECH, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD08.equals(cause)){
          preFillData.addBookmark(createBookmark(DROWNING, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD03.equals(cause)){
          preFillData.addBookmark(createBookmark(POSION, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD06.equals(cause)){
          preFillData.addBookmark(createBookmark(FIRE, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD05.equals(cause)){
          preFillData.addBookmark(createBookmark(SUICIDE, CHECKED)); 
        }else if(CodesTables.CDCAUDEA_CDCOD09.equals(cause)){
          preFillData.addBookmark(createBookmark(FALL, CHECKED)); 
        }
      }
    }
    
  }

  @SuppressWarnings("unchecked")
  private void populateSectionIII(PreFillData preFillData, int idChild, Date dtIncomingCall, int idCase, Stage currentStage) {
    List<Map> openDiversionStages = findOpenedBeforeStages(CodesTables.CSTAGES_DIV, dtIncomingCall, idChild);
    populateOpenStages(openDiversionStages, preFillData, TMPLAT_DIV, DIVERSION);

    List<Map> openInvestigationStages = findOpenedBeforeStages(CodesTables.CSTAGES_INV, dtIncomingCall, idChild);
    populateOpenStages(openInvestigationStages, preFillData, TMPLAT_INV, INVESTIGATION);

    List<Map> openOngoingStages = findOpenedBeforeStages(CodesTables.CSTAGES_FPR, dtIncomingCall, idChild);
    populateOpenStages(openOngoingStages, preFillData, TMPLAT_ONG, ONGOING);

    // Placement list consists of FCC, FCF, and ADO stages
    List<Map> openPlacementStages = new ArrayList<Map>();
    List<Map> openFCCStages = findOpenedBeforeStages(CodesTables.CSTAGES_SUB, dtIncomingCall, idChild);
    List<Map> openFCFStages = findOpenedBeforeStages(CodesTables.CSTAGES_FSU, dtIncomingCall, idChild);
    List<Map> openADOStages = findOpenedBeforeStages(CodesTables.CSTAGES_ADO, dtIncomingCall, idChild);

    if (openFCCStages != null && !openFCCStages.isEmpty()) {
      openPlacementStages.addAll(openFCCStages);
    }
    if (openFCFStages != null && !openFCFStages.isEmpty()) {
      openPlacementStages.addAll(openFCFStages);
    }
    if (openADOStages != null && !openADOStages.isEmpty()) {
      openPlacementStages.addAll(openADOStages);
    }
    populateOpenStages(openPlacementStages, preFillData, TMPLAT_PLA, PLACEMENT);
     String cdStage = currentStage.getCdStage();
    List<Map> openBecauseInvStages = findOpenedBecauseStages(CodesTables.CSTAGES_INV, idChild, idCase, cdStage);
    
    
    populateOpenBecauseStages(openBecauseInvStages, preFillData, TMPLAT_INV_BC, INVESTIGATION);

    List<Map> openBecauseOngStages = findOpenedBecauseStages(CodesTables.CSTAGES_FPR, openBecauseInvStages);
    populateOpenBecauseStages(openBecauseOngStages, preFillData, TMPLAT_ONG_BC, ONGOING);

    List<Map> openBecauseFccAdoStages = findOpenedBecauseStages(PLACEMENT, openBecauseInvStages, idChild, idCase);
    boolean hasOpenFcc = checkForFccStage(idCase, idChild);
    // If the child has an Open FCC from the list of
    // INV caused by CD/NF/SI Then display the FCF stage as well
    if (hasOpenFcc) {
      List<Map> fcfStages = createFcfStages(idCase);
      //48322 IF the child does not have a FCC stage where they are the primary child then don't display the FCF.
      if (fcfStages != null && !fcfStages.isEmpty() && openBecauseFccAdoStages != null && !openBecauseFccAdoStages.isEmpty()) {
        openBecauseFccAdoStages.addAll(fcfStages);
      }
    }

    populateOpenBecauseStages(openBecauseFccAdoStages, preFillData, TMPLAT_PLA_BC, PLACEMENT);

    List<Map> otherOpenServiceStages = findOtherOpenedStages(idChild, idCase, dtIncomingCall);
    populateOpenBecauseStages(otherOpenServiceStages, preFillData, TMPLAT_OTH_BC, OTHERS);

    List<IncomingDetail> screenedOutInts = findScreenedOutInt(dtIncomingCall, idChild);
    populateScreenedOutInt(screenedOutInts, preFillData);

    List<Stage> closedDivStages = findClosedStages(idChild, dtIncomingCall, CodesTables.CSTAGES_DIV);
    populateClosedStages(closedDivStages, preFillData, TMPLAT_CL_DIV, DIVERSION, idChild);

    List<Stage> closedInvStages = findClosedStages(idChild, dtIncomingCall, CodesTables.CSTAGES_INV);
    populateClosedStages(closedInvStages, preFillData, TMPLAT_CL_INV, INVESTIGATION, idChild);

    List<Stage> closedOngStages = findClosedStages(idChild, dtIncomingCall, CodesTables.CSTAGES_FPR);
    populateClosedStages(closedOngStages, preFillData, TMPLAT_CL_ONG, ONGOING, idChild);

    List<Stage> closedPlacementStages = findClosedStages(idChild, dtIncomingCall, CodesTables.CSTAGES_SUB);
    List<Stage> closedFcfStages = findClosedStages(idChild, dtIncomingCall, CodesTables.CSTAGES_FSU);
    if (closedFcfStages != null && !closedFcfStages.isEmpty()) {
      closedPlacementStages.addAll(closedFcfStages);
    }
    populateClosedStages(closedPlacementStages, preFillData, TMPLAT_CL_PLA, PLACEMENT, idChild);

    // Other stages consist of PAD and PFC stages
    List<Stage> closedOtherStages = findClosedStages(idChild, dtIncomingCall, CodesTables.CSTAGES_PFC);
    List<Stage> closedPADStages = findClosedStages(idChild, dtIncomingCall, CodesTables.CSTAGES_PAD);
    if (closedPADStages != null && !closedPADStages.isEmpty()) {
      closedOtherStages.addAll(closedPADStages);
    }
    populateClosedStages(closedOtherStages, preFillData, TMPLAT_CL_OTH, OTHERS, idChild);

  }

  private List<Stage> findClosedStages(int idChild, Date dtIncomingCall, String cdType) {
    return stageDAO.findClosedStageByIdPersonCdStageDtStart(idChild, cdType, dtIncomingCall);
  }

  private List<IncomingDetail> findScreenedOutInt(Date dtIncomingCall, int idChild) {
    return incomingDetailDAO.findPriorScreenedOutIncomingDtlsByidPerson(idChild, dtIncomingCall);
  }

  @SuppressWarnings("unchecked")
  private List<Map> findOtherOpenedStages(int idChild, int idCase, Date dtIncomingCall) {
    List<String> cdStageTypes = new ArrayList<String>();
    cdStageTypes.add(CodesTables.CSTAGES_PFC);
    cdStageTypes.add(CodesTables.CSTAGES_PAD);
    List<Map> otherOpenStages = stageDAO.findOpenStagesByIdCaseCdStagesIdPrimary(cdStageTypes, idChild,
                                                                                 dtIncomingCall);
    return otherOpenStages;
  }

  @SuppressWarnings("unchecked")
  private List<Map> createFcfStages(int idCase) {
    List<Stage> fcfStages = stageDAO.findStageByIdCaseAndCdStage(idCase, CodesTables.CSTAGES_FSU);
    List<Map> fcfStagesMaps = new ArrayList();
    if (fcfStages != null && !fcfStages.isEmpty()) {
      for (Iterator<Stage> it = fcfStages.iterator(); it.hasNext();) {
        Stage stage = it.next();
        Map fcfMap = new HashMap();
        fcfMap.put("idCase", (Integer) stage.getCapsCase().getIdCase());
        fcfMap.put("cdStage", "FCF");
        fcfMap.put("idStage", stage.getIdStage());
        fcfMap.put("nmStage", stage.getNmStage());
        fcfMap.put("dtStageStart", stage.getDtStageStart());
        fcfStagesMaps.add(fcfMap);
      }
    }
    return fcfStagesMaps;
  }

  @SuppressWarnings("unchecked")
  private boolean checkForFccStage(int idCase, int idChild) {
    boolean hasFcc = false;
    Collection<String> fcfMap = new ArrayList<String>();
    fcfMap.add(CodesTables.CSTAGES_SUB);
    // Checking to see if child has a FCC stage before adding the FCF stage
    List<Map> fccStages = stageDAO.findStagesByIdCaseCdStagesIdPrimary(idCase, fcfMap, idChild);
    if (fccStages.size() > 0) {
      hasFcc = true;
    }
    return hasFcc;
  }

  @SuppressWarnings("unchecked")
  /**
   * This Method is for FCC and ADO stages.  We want to make sure that the FCC stage the child is linked to 
   * that the child is the Primary Child and not just a sibling or other relative.  
   */
  private void populateOpenStages(List<Map> openStages, PreFillData preFillData, String groupBookMark, String stageType) {
    if (openStages != null && !openStages.isEmpty()) {
      for (Iterator<Map> it = openStages.iterator(); it.hasNext();) {
        Map openStage = (Map) it.next();
        boolean skipDisplay = false;
        if (CodesTables.CSTAGES_SUB.equals(openStage.get("cdStage"))
            || CodesTables.CSTAGES_ADO.equals(openStage.get("cdStage"))) {
          Map map = stagePersonLinkDAO.findIdChildNmStageByIdStage((Integer) openStage.get("idStage"));
         
        if (map != null && !map.isEmpty()) {
            Integer idPrimaryChild = (Integer) map.get("idPerson");
            Integer idOpenStage = (Integer) openStage.get("idPerson");
            if (idPrimaryChild.compareTo(idOpenStage) != 0) {
              // Child is not the Primary child on the stage so skip the display
              skipDisplay = true;
            }
          }else{// Did not find a primary child relationship on stage 
            skipDisplay = true;
          }
        }
        if (!skipDisplay) {
          preFillData.addFormDataGroup(DisplayOpenBeforeStages(groupBookMark, stageType, openStage));
        }
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void populateOpenBecauseStages(List<Map> openBecauseStages, PreFillData preFillData, String groupBookMark,
                                         String stageType) {
    if (openBecauseStages != null && !openBecauseStages.isEmpty()) {
      for (Iterator<Map> it = openBecauseStages.iterator(); it.hasNext();) {
        Map map = it.next();
        preFillData.addFormDataGroup(DisplayOpenBecauseStages(groupBookMark, stageType, map));
      }
    }
  }


  private void populateClosedStages(List<Stage> closedStages, PreFillData preFillData, String groupBookMark,
                                    String stageType, int idChild) {
    if (closedStages != null && !closedStages.isEmpty()) {
      for (Iterator<Stage> it = closedStages.iterator(); it.hasNext();) {
        Stage closedStage = (Stage) it.next();
        boolean skipDisplay = false;
        // If its a FCC, PAD, or PFC then make sure child id the PC before displaying.
        if (CodesTables.CSTAGES_SUB.equals(closedStage.getCdStage())
            || CodesTables.CSTAGES_PAD.equals(closedStage.getCdStage())
            || CodesTables.CSTAGES_PFC.equals(closedStage.getCdStage())) {
          // method pulls back the primary child entry on the stage person link
          Map map = stagePersonLinkDAO.findIdChildNmStageByIdStage(closedStage.getIdStage());
          if (idChild != (Integer) map.get("idPerson")) {
            skipDisplay = true;
          }
        }
        if (!skipDisplay) {
          preFillData.addFormDataGroup(DisplayClosedStages(groupBookMark, stageType, closedStage));
        }
      }
    }
  }

  private void populateScreenedOutInt(List<IncomingDetail> screenedOutInts, PreFillData preFillData) {
    if (screenedOutInts != null && !screenedOutInts.isEmpty()) {
      for (Iterator<IncomingDetail> it = screenedOutInts.iterator(); it.hasNext();) {
        IncomingDetail incomingDetail = (IncomingDetail) it.next();
        preFillData.addFormDataGroup(DisplayScreenedOutInts(incomingDetail));
      }
    }
  }

  private FormDataGroup DisplayClosedStages(String groupBookMark, String stageType, Stage closedStage) {
    FormDataGroup group = createFormDataGroup(groupBookMark, "CHILD_DEATH");
    group.addBookmark(createBookmark(stageType + "_CL_CASE_ID", closedStage.getCapsCase().getIdCase()));
    String cdStageType = determineStageType(closedStage.getCdStage());
    group.addBookmark(createBookmark(stageType + "_CL_STAGE_TYPE", cdStageType));
    group.addBookmark(createBookmark(stageType + "_CL_STAGE_ID", closedStage.getIdStage()));
    group.addBookmark(createBookmark(stageType + "_CL_STAGE_NAME", closedStage.getNmStage()));
    group.addBookmark(createBookmark(stageType + "_CL_DT_OPEN",
                                     FormattingHelper.formatDate((Date) closedStage.getDtStageStart())));
    group.addBookmark(createBookmark(stageType + "_CL_DT_CLOSED",
                                     FormattingHelper.formatDate((Date) closedStage.getDtStageClose())));
    if (stageType.equals(INVESTIGATION)) {
      String disposition = cpsInvstDetailDAO.findFinalDispositionByIdStage(closedStage.getIdStage());
      group.addBookmark(createBookmark(INV_CL_DISPO, Lookup.simpleDecodeSafe(CodesTables.CDISPSTN, (disposition))));
    }
    return group;
  }

  private FormDataGroup DisplayScreenedOutInts(IncomingDetail incomingDetail) {
    FormDataGroup group = createFormDataGroup(TMPLAT_SCREEN_OUT, "CHILD_DEATH");
    group.addBookmark(createBookmark(SO_INTAKE_ID, incomingDetail.getIdStage()));
    group.addBookmark(createBookmark(SO_INTAKE_NM, incomingDetail.getStage().getNmStage()));
    group.addBookmark(createBookmark(SO_DT_REC, FormattingHelper.formatDate(incomingDetail.getDtIncomingCall())));
    group.addBookmark(createBookmark(DT_SO, FormattingHelper.formatDate(incomingDetail.getDtIncomingCallDisposed())));
    return group;
  }

  @SuppressWarnings("unchecked")
  private FormDataGroup DisplayOpenBeforeStages(String groupBookMark, String stageType, Map map) {
    FormDataGroup group = createFormDataGroup(groupBookMark, "CHILD_DEATH");
    group.addBookmark(createBookmark(stageType + "_CASE_ID", map.get("idCase")));
    String cdStageType = determineStageType((String) map.get("cdStage"));
    group.addBookmark(createBookmark(stageType + "_STAGE_TYPE", cdStageType));
    group.addBookmark(createBookmark(stageType + "_STAGE_ID", map.get("idStage")));
    group.addBookmark(createBookmark(stageType + "_STAGE_NAME", map.get("nmStage")));
    group.addBookmark(createBookmark(stageType + "_DT_OPEN",
                                     FormattingHelper.formatDate((Date) map.get("dtStageStart"))));
    return group;
  }

  @SuppressWarnings("unchecked")
  private FormDataGroup DisplayOpenBecauseStages(String groupBookMark, String stageType, Map map) {
    FormDataGroup group = createFormDataGroup(groupBookMark, "CHILD_DEATH");
    group.addBookmark(createBookmark(stageType + "_BC_CASE_ID", map.get("idCase")));
    String cdStageType = determineStageType((String) map.get("cdStage"));
    group.addBookmark(createBookmark(stageType + "_BC_STAGE_TYPE", cdStageType));
    group.addBookmark(createBookmark(stageType + "_BC_STAGE_ID", map.get("idStage")));
    group.addBookmark(createBookmark(stageType + "_BC_STAGE_NAME", map.get("nmStage")));
    group.addBookmark(createBookmark(stageType + "_BC_DT_OPEN",
                                     FormattingHelper.formatDate((Date) map.get("dtStageStart"))));
    return group;
  }

  @SuppressWarnings("unchecked")
  private List<Map> findOpenedBeforeStages(String cdStageType, Date dtIncomingCall, int idChild) {
    // 47650 If the time the Intake call is received is the same date of the stage closure 
    // then the date should be displayed
    Calendar compareDtIncoming = new GregorianCalendar();
    compareDtIncoming.setTime(dtIncomingCall);
    compareDtIncoming.set(Calendar.HOUR, 0);
    compareDtIncoming.set(Calendar.MINUTE, 0);
    compareDtIncoming.set(Calendar.SECOND, 0);
    compareDtIncoming.set(Calendar.MILLISECOND, 0);
    compareDtIncoming.set(Calendar.HOUR_OF_DAY, 0);
    
    List<Map> openBeforeStages = stagePersonLinkDAO.findListOfOpenStagesByCdStageType(idChild, cdStageType,
                                                                                      compareDtIncoming);
    return openBeforeStages;
  }

  @SuppressWarnings("unchecked")
  private List<Map> findOpenedBecauseStages(String cdStageType, List<Map> previousStage, int idChild, int idCase) {
    List<Map> progressedStages = new ArrayList<Map>();
    if (previousStage != null && !previousStage.isEmpty()) {
      List<String> cdStageTypes = new ArrayList<String>();
      cdStageTypes.add(CodesTables.CSTAGES_SUB);
      cdStageTypes.add(CodesTables.CSTAGES_ADO);
      List<Map> listAdoFccStages = stageDAO.findStagesByIdCaseCdStagesIdPrimary(idCase, cdStageTypes, idChild);
      if (listAdoFccStages != null && !listAdoFccStages.isEmpty()) {
        progressedStages.addAll(listAdoFccStages);
      }
    }
    return progressedStages;
  }

  @SuppressWarnings("unchecked")
  private List<Map> findOpenedBecauseStages(String cdStageType, List<Map> previousStage) {
    List<Map> progressedStages = new ArrayList<Map>();
    if (previousStage != null && !previousStage.isEmpty()) {
      for (Iterator<Map> it = previousStage.iterator(); it.hasNext();) {
        Map map = it.next();
        int idPrevStage = (Integer) map.get("idStage");
        List<Map> nextStages = stageLinkDAO.findAllProgressedToStagesByIdStageIdStageType(idPrevStage, cdStageType);
        progressedStages.addAll(nextStages);
      }
    }
    return progressedStages;
  }

  @SuppressWarnings("unchecked")
  private List<Map> findOpenedBecauseStages(String cdStageType, int idChild, int idCase, String cdStage) {
    List<Map> openBecauseStages = new ArrayList<Map>();
    Collection<Integer> idInvStages = stageDAO.findStageIdsByIdCaseAndCdStage(idCase, INVESTIGATION);
    if(idInvStages != null && !idInvStages.isEmpty()){ 
     
      openBecauseStages = allegationDAO.findListOfCDNFSIAllgByIdPersonIdCaseCdStageTypeByCdStageType(idChild ,idInvStages);
    }
    return openBecauseStages;
  }

  private Person getPerson(int idPerson) {
    Person person = personDAO.findPersonByIdPerson(idPerson);
    return person;
  }

  /*
   * Method to Determines the proper parent. When launched from the Investigation, Ongoing or FCF stage Then information
   * should be pulled from child's Person Detail page. If launched from the FCC, Adoption, or Post Foster Care then then
   * information comes from stage person link. Legal parent has precedence over biological parents. 
   */
  private int determineParent(Stage stage, String parentType, Person child) {
    int idParent = 0;
    String stageType = stage.getCdStage();
    int idChild = child.getIdPerson();
    int idStage = stage.getIdStage();

    HashMap<String, String> personRelationMap = new HashMap<String, String>();
    personRelationMap.put("INV", CodesTables.CSTAGES_INV);
    personRelationMap.put("FPR", CodesTables.CSTAGES_FPR); // CPS Ongoing

    if (personRelationMap.containsKey(stageType)) {
      if (MOTHER.equals(parentType)) {
        // Legal Mother get precedence over Biological Mother
        Integer momInteger = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, LEGAL_MOTHER);
        if (momInteger == null) {
          momInteger = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, BIOLOGICAL_MOTHER);
        }
        idParent = (momInteger != null) ? momInteger.intValue() : 0;

      } else if (FATHER.equals(parentType)) {
        Integer dadInteger = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, LEGAL_FATHER);
        if (dadInteger == null) {
          dadInteger = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idChild, BIOLOGICAL_FATHER);
        }
        idParent = (dadInteger != null) ? dadInteger.intValue() : 0;
      }
    } else { // if stage is FCC, ADO, or PFC(current other stages)
      if (MOTHER.equals(parentType)) {
        StagePersonLink bioMotherStagePersonLink = stagePersonLinkDAO
                                                                     .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(
                                                                                                                          idStage,
                                                                                                                          LEGAL_MOTHER);
        if (bioMotherStagePersonLink != null) {
          idParent = bioMotherStagePersonLink.getPerson().getIdPerson();
        } else {
          bioMotherStagePersonLink = stagePersonLinkDAO
                                                       .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(idStage,
                                                                                                            BIOLOGICAL_MOTHER);
          
          if(bioMotherStagePersonLink != null){
          idParent = bioMotherStagePersonLink.getPerson().getIdPerson();
          }
        }
      } else if (FATHER.equals(parentType)) {
        // Legal Father get precedence over Biological Father
       StagePersonLink bioLegFatherStagePersonLink = stagePersonLinkDAO
                                                     .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(idStage,
                                                                                                          BIOLEGAL_FATHER);
        if (bioLegFatherStagePersonLink != null) {
          idParent = bioLegFatherStagePersonLink.getPerson().getIdPerson();
        } else {
          StagePersonLink legFatherStagePersonLink = stagePersonLinkDAO
                                                          .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(idStage,
                                                                                                               LEGAL_FATHER);
          if (legFatherStagePersonLink != null) {
            idParent = legFatherStagePersonLink.getPerson().getIdPerson();
          } 
          
          if (idParent < 1){
            StagePersonLink bioFatherStagePersonLink = stagePersonLinkDAO
                                                            .findStagePersonLinkByIdStageByCdStagePersRelIntOnly(
                                                                                                                 idStage,
                                                                                                                 BIOLOGICAL_FATHER);
            if (bioFatherStagePersonLink != null) {
              idParent = bioFatherStagePersonLink.getPerson().getIdPerson();
            }
          }
        }
      }
    }
    return idParent;
  }

  private void populateRace(Person child, PreFillData preFillData) {
    Collection<PersonRace> races = child.getPersonRaces();

    if (races != null && !races.isEmpty()) {

      if (races.size() < 2) {
        for (Iterator<PersonRace> it = races.iterator(); it.hasNext();) {
          PersonRace race = it.next();
          String cdRace = race.getCdRace();
          if (AMERICAN_INDIAN.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_INDIAN, CHECKED));
          } else if (ASIAN.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_ASIAN, CHECKED));
          }else if (BLACK.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_BLACK, CHECKED));
          } else if (HAWAIIAN.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_HAWAIIAN, CHECKED));
          } else if (WHITE.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_WHITE, CHECKED));
          } else if (UNKNOWN.equals(cdRace)) {
            preFillData.addBookmark(createBookmark(RACE_UNKNOWN, CHECKED));
          }

        }
      } else {
        preFillData.addBookmark(createBookmark(RACE_MULTI, CHECKED));
      }
    }
  }

  private String determineStageType(String cdStage) {
    if (cdStage.equals(CodesTables.CSTAGES_FPR)) {
      cdStage = ONGOING;
    } else if (cdStage.equals(CodesTables.CSTAGES_FSU)) {
      cdStage = FCF;
    } else if (cdStage.equals(CodesTables.CSTAGES_SUB)) {
      cdStage = FCC;
    }
    return cdStage;
  }

}