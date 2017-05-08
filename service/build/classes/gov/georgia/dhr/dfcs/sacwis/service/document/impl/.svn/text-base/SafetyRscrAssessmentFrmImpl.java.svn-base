package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCitizenshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrHouseholdMembersDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Medication;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCitizenship;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmtPerson;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.document.SafetyRscrAssessmentFrm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SAFETYRSCRASSESSMNTFRMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SAFETYRSCRASSESSMNTFRMSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This is SafetyRscrAssessmentFrmImpl.java file
 * 
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/03/11  cwells    CAPTA - For 4.3 Did major rehaul of this form.  Service is now used for Safety resource and 
 *                      Relative Care Assessments. 
 *  01/23/09  schoi     STGAP00010912 - Modified SafetyRscrAssessmentFrmImpl.getSafetyRscrHeadings method 
 *                      in order to retrieve the ID of the case manager regardless of the role as Primary(PR) 
 *                      or Historical Primary(HP) without getting NullPointerException.   
 * 07/09/09   cwells    STGAP00014333 - MR-20 Made several changes to Updated Safety Resource Form to match changes made to parent page.                             
 * 
 * </pre>
 */

public class SafetyRscrAssessmentFrmImpl extends BaseDocumentServiceImpl implements SafetyRscrAssessmentFrm {

  private PersonDAO personDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private UnitEmpLinkDAO unitEmpLinkDAO;

  private PersonIdDAO personIdDAO;

  private SafetyResourceChildDAO safetyResourceChildDAO;

  private RelativeCareAssmtPersonDAO relativeCareAssmtPersonDAO;

  private PersonCitizenshipDAO personCitizenshipDAO;

  private SrHouseholdMembersDAO srHouseholdMembersDAO;

  private StageDAO stageDAO;

  private IncomingDetailDAO incomingDetailDAO;

  private CpsInvstDetailDAO cpsInvstDetailDAO;

  private List<Integer> memberList = new ArrayList<Integer>();



  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }


  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }

  public void setSrHouseholdMembersDAO(SrHouseholdMembersDAO srHouseholdMembersDAO) {
    this.srHouseholdMembersDAO = srHouseholdMembersDAO;
  }


  public void setRelativeCareAssmtPersonDAO(RelativeCareAssmtPersonDAO relativeCareAssmtPersonDAO) {
    this.relativeCareAssmtPersonDAO = relativeCareAssmtPersonDAO;
  }

  public void setPersonCitizenshipDAO(PersonCitizenshipDAO personCitizenshipDAO) {
    this.personCitizenshipDAO = personCitizenshipDAO;
  }

  List<Integer> houseHoldMembersList = new ArrayList<Integer>();

  List<Integer> childrenPlacedList = new ArrayList<Integer>();

  List<Integer> careGiverList = new ArrayList<Integer>();

  public SAFETYRSCRASSESSMNTFRMSO retrieveSafetyRscrAssessmentFrm(SAFETYRSCRASSESSMNTFRMSI safetyRscrAssessmntFrmsi) {
    SAFETYRSCRASSESSMNTFRMSO safetyRscrAssessmntFrmso = new SAFETYRSCRASSESSMNTFRMSO();

    int idEvent = safetyRscrAssessmntFrmsi.getUlIdEvent();
    int idStage = safetyRscrAssessmntFrmsi.getUlIdStage();
    int idCase = safetyRscrAssessmntFrmsi.getUlIdCase();
    SafetyResource safetyResource = getPersistentObject(SafetyResource.class, idEvent);
    RelativeCareAssmt relativeCare = getPersistentObject(RelativeCareAssmt.class, idEvent);
    String eventType = getEventType(idEvent);
    PreFillData preFillData = new PreFillData();

    if (CodesTables.CEVNTTYP_SRP.equals(eventType)) {
      populateSafetyResourceAssessment(preFillData, idEvent, safetyResource, idStage, idCase);
    } else if (CodesTables.CEVNTTYP_ASM.equals(eventType)) {
      populateRelativeCareAssessment(preFillData, idEvent, relativeCare, idStage, idCase);
    }

    safetyRscrAssessmntFrmso.setPreFillData(preFillData);

    return safetyRscrAssessmntFrmso;
  }// end of SAFETYRSCRASSESSMNTSO

  private void populateSafetyResourceAssessment(PreFillData preFillData, int idEvent, SafetyResource safetyResource,
                                                int idStage, int idCase) {

    getSafetyRsrcHeaderInformation(idEvent, preFillData, safetyResource);
    getSafetyResourceChildrenInCase(idEvent, preFillData);
    getSafetyResourceCaregivers(idEvent, preFillData);
    getSafetyResourceOtherHouseMembs(idEvent, preFillData);
    List<Integer> nonDuplicateList = getSafetyResourceRecordsChecks(preFillData, idEvent, safetyResource);
    getCharacteristics(preFillData, nonDuplicateList);
    getMedication(preFillData, nonDuplicateList);
    getEducation(preFillData, nonDuplicateList);
    getIncome(preFillData, nonDuplicateList);
    showSafetyResourceRelatedSections(preFillData);

    Stage currentStage = getPersistentObject(Stage.class, idStage);
    java.util.Date dtIncomingCall = incomingDetailDAO.findEarliestIncomingDetailDtByIdCase(idCase);

    populateCommonFields(preFillData, nonDuplicateList, dtIncomingCall, idCase, currentStage, idEvent);
  }

  private void populateRelativeCareAssessment(PreFillData preFillData, int idEvent,
                                              RelativeCareAssmt relativeCareAssmt, int idStage, int idCase) {
    getRelativeCareHeaderInformation(idEvent, preFillData, relativeCareAssmt);
    getRelativeCareChildrenInCase(idEvent, preFillData);
    getRelativeCaregivers(idEvent, preFillData);

    getRelativeCareOtherHouseMembs(idEvent, preFillData);

    List<Integer> nonDuplicateList = getRelativeCareRecordsChecks(preFillData, idEvent);
    getCharacteristics(preFillData, nonDuplicateList);
    getMedication(preFillData, nonDuplicateList);
    getEducation(preFillData, nonDuplicateList);
    getIncome(preFillData, nonDuplicateList);
    showRelativeCareRelatedSections(preFillData);

    Stage currentStage = getPersistentObject(Stage.class, idStage);
    java.util.Date dtIncomingCall = incomingDetailDAO.findEarliestIncomingDetailDtByIdCase(idCase);

    populateCommonFields(preFillData, nonDuplicateList, dtIncomingCall, idCase, currentStage, idEvent);
  }

  @SuppressWarnings("unchecked")
  private void populateCommonFields(PreFillData preFillData, List<Integer> members, Date dtIncomingCall, int idCase,
                                    Stage currentStage, int idEvent) {

    List<Integer> screenedOutInts = findScreenedOutInt(dtIncomingCall, members);
    populateScreenedOutInt(screenedOutInts, preFillData, members);

    List<Stage> closedDivStages = findClosedStages(members, dtIncomingCall, CodesTables.CSTAGES_DIV);
    populateClosedStages(closedDivStages, preFillData, TMPLAT_CL_DIV, DIVERSION, members);

    List<Stage> closedInvStages = findClosedStages(members, dtIncomingCall, CodesTables.CSTAGES_INV);
    populateClosedStages(closedInvStages, preFillData, TMPLAT_CL_INV, INVESTIGATION, members);

    List<Stage> closedOngStages = findClosedStages(members, dtIncomingCall, CodesTables.CSTAGES_FPR);
    populateClosedStages(closedOngStages, preFillData, TMPLAT_CL_ONG, ONGOING, members);

    List<Stage> closedPlacementStages = findClosedStages(members, dtIncomingCall, CodesTables.CSTAGES_SUB);
    List<Stage> closedFcfStages = findClosedStages(members, dtIncomingCall, CodesTables.CSTAGES_FSU);
    if (closedFcfStages != null && !closedFcfStages.isEmpty()) {
      closedPlacementStages.addAll(closedFcfStages);
    }
    populateClosedStages(closedPlacementStages, preFillData, TMPLAT_CL_PLA, PLACEMENT, members);

    // Other stages consist of PAD and PFC stages
    List<Stage> closedOtherStages = findClosedStages(members, dtIncomingCall, CodesTables.CSTAGES_PFC);
    List<Stage> closedPADStages = findClosedStages(members, dtIncomingCall, CodesTables.CSTAGES_PAD);
    if (closedPADStages != null && !closedPADStages.isEmpty()) {
      closedOtherStages.addAll(closedPADStages);
    }
    populateClosedStages(closedOtherStages, preFillData, TMPLAT_CL_OTH, OTHERS, members);
    Integer idCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(currentStage.getIdStage());
    if (idCaseManager != null) {
      Person manager = getPersistentObject(Person.class, idCaseManager);
      preFillData.addBookmark(createBookmark(CASE_MANAGER, formatFullName(manager)));
      preFillData.addBookmark(createBookmark(CELL_PHONE, FormattingHelper.formatPhone(manager.getNbrPersonPhone())));
     Integer unitSupervisorObj = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCaseManager);
     if(unitSupervisorObj > 0){
       Person supervisor = getPersistentObject(Person.class, unitSupervisorObj);
       preFillData.addBookmark(createBookmark(SUPERVISOR, formatFullName(supervisor)));
       preFillData.addBookmark(createBookmark(SUPERVISOR_NUMBER, FormattingHelper.formatPhone(supervisor.getNbrPersonPhone())));
     }
    }
  }

  private List<Stage> findClosedStages(List<Integer> members, Date dtIncomingCall, String cdType) {
    return stageDAO.findClosedStageByPersonListCdStageDtStart(members, cdType, dtIncomingCall);
  }

  private List<Integer> findScreenedOutInt(Date dtIncomingCall, List<Integer> members) {
    return incomingDetailDAO.findPriorScreenedOutIncomingDtlsByidPersons(members, dtIncomingCall);
  }

  private void populateClosedStages(List<Stage> closedStages, PreFillData preFillData, String groupBookMark,
                                    String stageType, List<Integer> members) {
    if (closedStages != null && !closedStages.isEmpty()) {
      List<Integer> stages = new ArrayList<Integer>();
      for (Iterator<Stage> it = closedStages.iterator(); it.hasNext();) {
        Stage closedStage = (Stage) it.next();
        boolean skipDisplay = false;
        // If its a FCC, PAD, or PFC then make sure child id the PC before displaying.
        if (CodesTables.CSTAGES_SUB.equals(closedStage.getCdStage())
            || CodesTables.CSTAGES_PAD.equals(closedStage.getCdStage())
            || CodesTables.CSTAGES_PFC.equals(closedStage.getCdStage())) {
          // method pulls back the primary child entry on the stage person link
          Map map = stagePersonLinkDAO.findIdChildNmStageByIdStage(closedStage.getIdStage());
          if (!members.contains(map.get("idPerson"))) {
            skipDisplay = true;
          }
        }
        if (!skipDisplay && !stages.contains(closedStage.getIdStage())) {
          stages.add(closedStage.getIdStage());
          preFillData.addFormDataGroup(DisplayClosedStages(groupBookMark, stageType, closedStage, members));
        }
      }
    }
  }

  private void populateScreenedOutInt(List<Integer> screenedOutInts, PreFillData preFillData, List<Integer> memberList) {
    if (screenedOutInts != null && !screenedOutInts.isEmpty()) {
      List<Integer> stages = new ArrayList<Integer>();
      for (Iterator<Integer> it = screenedOutInts.iterator(); it.hasNext();) {
        Integer idStage = (Integer) it.next();
        if(!stages.contains(idStage)){
        IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailByIdStage(idStage);
        preFillData.addFormDataGroup(DisplayScreenedOutInts(incomingDetail, memberList));
        stages.add(idStage);
        }
      }
    }
  }

  private String createMemberOfList(List<Integer> memberList, int idStage) {
    StringBuilder memberOfList = new StringBuilder();
    if (memberList != null && !memberList.isEmpty()) {
      for (Iterator<Integer> it = memberList.iterator(); it.hasNext();) {
        Integer idPerson = (Integer) it.next();
        long personCount = stagePersonLinkDAO.countStagePersonLinkByIdStageAndIdPerson(idStage, idPerson);
        if (personCount > 0) {
          Person person = getPersistentObject(Person.class, idPerson);
          memberOfList.append(" " + formatFullName(person) + ",");
        }
      }
    }
    if (memberOfList.length() > 1) {
      memberOfList.deleteCharAt(memberOfList.length() - 1);
    }
    return memberOfList.toString();
  }

  private FormDataGroup DisplayClosedStages(String groupBookMark, String stageType, Stage closedStage,
                                            List<Integer> memberList) {
    String memberOfList = createMemberOfList(memberList, closedStage.getIdStage());
    FormDataGroup group = createFormDataGroup(groupBookMark, "FAS05o00");
    group.addBookmark(createBookmark(stageType + "_CL_CASE_ID", closedStage.getCapsCase().getIdCase()));
    String cdStageType = determineStageType(closedStage.getCdStage());
    group.addBookmark(createBookmark(stageType + "_CL_STAGE_TYPE", cdStageType));
    // 
    if(!CodesTables.CSTAGES_INV.equals(stageType)){
    group.addBookmark(createBookmark(stageType + "_CL_STAGE_ID", closedStage.getIdStage()));
    }
    group.addBookmark(createBookmark(stageType + "_CL_STAGE_NAME", closedStage.getNmStage()));
    group.addBookmark(createBookmark(stageType + "_CL_DT_OPEN",
                                     FormattingHelper.formatDate((Date) closedStage.getDtStageStart())));
    group.addBookmark(createBookmark(stageType + "_CL_DT_CLOSED",
                                     FormattingHelper.formatDate((Date) closedStage.getDtStageClose())));
    if (stageType.equals(INVESTIGATION)) {
      String disposition = cpsInvstDetailDAO.findFinalDispositionByIdStage(closedStage.getIdStage());
      group.addBookmark(createBookmark(INV_CL_DISPO, Lookup.simpleDecodeSafe(CodesTables.CDISPSTN, (disposition))));
    }
    group.addBookmark(createBookmark(stageType + "_CL_MEMEBERS", memberOfList));

    return group;
  }

  private FormDataGroup DisplayScreenedOutInts(IncomingDetail incomingDetail, List<Integer> memberList) {
    String memberOfList = createMemberOfList(memberList, incomingDetail.getStage().getIdStage());
    FormDataGroup group = createFormDataGroup(TMPLAT_SCREEN_OUT, "CHILD_DEATH");
    group.addBookmark(createBookmark(SO_INTAKE_ID, incomingDetail.getIdStage()));
    group.addBookmark(createBookmark(SO_INTAKE_NM, incomingDetail.getStage().getNmStage()));
    group.addBookmark(createBookmark(SO_DT_REC, FormattingHelper.formatDate(incomingDetail.getDtIncomingCall())));
    group.addBookmark(createBookmark(DT_SO, FormattingHelper.formatDate(incomingDetail.getStage().getDtStageClose())));
    group.addBookmark(createBookmark(SO_MEMBERS_INVOLVED, memberOfList));
    return group;
  }

  private void getSafetyRsrcHeaderInformation(int idEvent, PreFillData preFillData, SafetyResource safetyResource) {
    Person primarySRPerson = getPrimaryResource(idEvent);
    String cityState = getPrimaryResourceCityState(primarySRPerson);
    Collection<PersonPhone> phoneNumbers = primarySRPerson.getPersonPhones();
    String primaryPhone = getPrimaryPhone(primarySRPerson, phoneNumbers);
    String cellPhone = getCellPhone(primarySRPerson, phoneNumbers);

    preFillData.addBookmark(createBookmark(TXT_DT_RECEIVED,
                                           FormattingHelper.formatDate(safetyResource.getDtRequestReceived())));
    preFillData.addBookmark(createBookmark(EVAL_REASON, "Safety Resource"));
    preFillData.addBookmark(createBookmark(TYPE, "Safety Resource"));
    preFillData.addBookmark(createBookmark(STREET_ADDR, primarySRPerson.getAddrPersonStLn1()));
    preFillData.addBookmark(createBookmark(CITY_STATE_ADDR, cityState));
    preFillData.addBookmark(createBookmark(PHONE_NUMB_HOME, FormattingHelper.formatPhone(primaryPhone)));
    preFillData.addBookmark(createBookmark(PHONE_NUMB_CELL, FormattingHelper.formatPhone(cellPhone)));
    preFillData.addBookmark(createBookmark(TYPE_TWO, "Safety Resource"));

  }

  private void getRelativeCareHeaderInformation(int idEvent, PreFillData preFillData,
                                                RelativeCareAssmt relativeCareAssmt) {
    // Person primarySRPerson = getPrimaryResource(idEvent);

    List<RelativeCareAssmtPerson> relativeCaregivers = relativeCareAssmtPersonDAO
                                                                                 .findRelativeCareAssmtPersonByIdRcaEventCdPersonType(
                                                                                                                                      idEvent,
                                                                                                                                      CodesTables.CPRNTYP_PRC);
    preFillData.addBookmark(createBookmark(TXT_DT_RECEIVED,
                                           FormattingHelper.formatDate(relativeCareAssmt.getDtReferral())));

    preFillData.addBookmark(createBookmark(EVAL_REASON, "Relative Care Assessment"));
    preFillData.addBookmark(createBookmark(TYPE, "Relative Placement"));

    if (relativeCaregivers != null && !relativeCaregivers.isEmpty()) {

      Iterator<RelativeCareAssmtPerson> it = relativeCaregivers.iterator();
      RelativeCareAssmtPerson relativeCareAssmtPerson = it.next();
      Person relativeCarePerson = relativeCareAssmtPerson.getPersonByIdPerson();

      String cityState = getPrimaryResourceCityState(relativeCarePerson);
      Collection<PersonPhone> phoneNumbers = relativeCarePerson.getPersonPhones();
      String primaryPhone = getPrimaryPhone(relativeCarePerson, phoneNumbers);
      String cellPhone = getCellPhone(relativeCarePerson, phoneNumbers);
      preFillData.addBookmark(createBookmark(TYPE_TWO, "Relative Placement"));

      preFillData.addBookmark(createBookmark(STREET_ADDR, relativeCarePerson.getAddrPersonStLn1()));
      preFillData.addBookmark(createBookmark(CITY_STATE_ADDR, cityState));
      preFillData.addBookmark(createBookmark(PHONE_NUMB_HOME, FormattingHelper.formatPhone(primaryPhone)));
      preFillData.addBookmark(createBookmark(PHONE_NUMB_CELL, FormattingHelper.formatPhone(cellPhone)));

    }
  }

  private void showRelativeCareRelatedSections(PreFillData preFillData) {
    FormDataGroup group = createFormDataGroup(TMPLAT_RELATIVE_CARE_1, FAS05O00);
    preFillData.addFormDataGroup(group);
    FormDataGroup group2 = createFormDataGroup(TMPLAT_RELATIVE_CARE_2, FAS05O00);
    preFillData.addFormDataGroup(group2);
    FormDataGroup group3 = createFormDataGroup(TMPLAT_RELATIVE_CARE_3, FAS05O00);
    preFillData.addFormDataGroup(group3);
    FormDataGroup group4 = createFormDataGroup(TMPLAT_RELATIVE_CARE_4, FAS05O00);
    preFillData.addFormDataGroup(group4);
    FormDataGroup group5 = createFormDataGroup(TMPLAT_RELATIVE_CARE_5, FAS05O00);
    preFillData.addFormDataGroup(group5);
    FormDataGroup group6 = createFormDataGroup(TMPLAT_RELATIVE_CARE_6, FAS05O00);
    preFillData.addFormDataGroup(group6);
    FormDataGroup group7 = createFormDataGroup(TMPLAT_RELATIVE_CARE_7, FAS05O00);
    preFillData.addFormDataGroup(group7);
    preFillData.addBookmark(createBookmark(FORM_TYPE, "Relative Caregiver(s)"));
    preFillData.addBookmark(createBookmark(FORM_TYPE_TWO, "Relative Caregiver(s)"));
  }

  private void showSafetyResourceRelatedSections(PreFillData preFillData) {
    FormDataGroup group = createFormDataGroup(TMPLAT_SAFETY_RSRC_1, FAS05O00);
    preFillData.addFormDataGroup(group);
    FormDataGroup group2 = createFormDataGroup(TMPLAT_SAFETY_RSRC_2, FAS05O00);
    preFillData.addFormDataGroup(group2);
    FormDataGroup group3 = createFormDataGroup(TMPLAT_SAFETY_RSRC_3, FAS05O00);
    preFillData.addFormDataGroup(group3);
    FormDataGroup group4 = createFormDataGroup(TMPLAT_SAFETY_RSRC_4, FAS05O00);
    preFillData.addFormDataGroup(group4);
    FormDataGroup group5 = createFormDataGroup(TMPLAT_SAFETY_RSRC_5, FAS05O00);
    preFillData.addFormDataGroup(group5);
    preFillData.addBookmark(createBookmark(FORM_TYPE, "Safety Resource"));
    preFillData.addBookmark(createBookmark(FORM_TYPE_TWO, "Safety Resource"));
  }

  private void getMedication(PreFillData preFillData, List<Integer> nonDuplicateList) {
    if (nonDuplicateList != null && !nonDuplicateList.isEmpty()) {
      for (Iterator<Integer> it = nonDuplicateList.iterator(); it.hasNext();) {
        Integer idPerson = it.next();
        Person person = getPersistentObject(Person.class, idPerson);
        // for Children placed and household members
        if (houseHoldMembersList.contains(idPerson) || childrenPlacedList.contains(idPerson)) {
          Collection<Medication> medications = person.getMedications();
          if (medications != null && !medications.isEmpty()) {
            for (Iterator<Medication> it2 = medications.iterator(); it2.hasNext();) {
              Medication medication = it2.next();
              preFillData.addFormDataGroup(displaySafetyResourceMedication(medication));
            }

          }
        }
      }
    }
  }

  private void getCharacteristics(PreFillData preFillData, List<Integer> nonDuplicateList) {
    if (nonDuplicateList != null && !nonDuplicateList.isEmpty()) {
      for (Iterator<Integer> it = nonDuplicateList.iterator(); it.hasNext();) {
        Integer idPerson = it.next();
        // for Household members and Children Placed.
        if (houseHoldMembersList.contains(idPerson) || childrenPlacedList.contains(idPerson)) {
          Person person = getPersistentObject(Person.class, idPerson);
          Collection<Characteristics> charas = person.getCharacteristicses();
          if (charas != null && !charas.isEmpty()) {
            for (Iterator<Characteristics> it2 = charas.iterator(); it2.hasNext();) {
              Characteristics characteristic = it2.next();
              preFillData.addFormDataGroup(displayChara(characteristic));
            }

          }
        }
      }
    }
  }

  private void getEducation(PreFillData preFillData, List<Integer> nonDuplicateList) {
    if (nonDuplicateList != null && !nonDuplicateList.isEmpty()) {
      for (Iterator<Integer> it = nonDuplicateList.iterator(); it.hasNext();) {
        Integer idPerson = it.next();
        Person person = getPersistentObject(Person.class, idPerson);
        // only display Children Placed for Education
        if (childrenPlacedList.contains(idPerson)) {
          Collection<EducationalHistory> personEdus = person.getEducationalHistories();
          if (personEdus != null && !personEdus.isEmpty()) {
            for (Iterator<EducationalHistory> it2 = personEdus.iterator(); it2.hasNext();) {
              EducationalHistory educationalHistory = it2.next();
              preFillData.addFormDataGroup(displayEducationHistory(educationalHistory));

            }
          }
        }
      }
    }
  }

  private void getIncome(PreFillData preFillData, List<Integer> nonDuplicateList) {
    if (nonDuplicateList != null && !nonDuplicateList.isEmpty()) {
      for (Iterator<Integer> it = nonDuplicateList.iterator(); it.hasNext();) {
        Integer idPerson = it.next();
        Person person = getPersistentObject(Person.class, idPerson);
        // only display for Caregivers only.
        if (careGiverList.contains(idPerson)) {
          Collection<IncomeAndResources> incomeAndResources = person.getIncomeAndResourcesesForIdPerson();
          if (incomeAndResources != null && !incomeAndResources.isEmpty()) {
            for (Iterator<IncomeAndResources> it2 = incomeAndResources.iterator(); it2.hasNext();) {
              IncomeAndResources incomeAndResource = it2.next();
              preFillData.addFormDataGroup(displayIncomeAndResources(incomeAndResource));
            }
          }
        }
      }
    }
  }

  private List<Integer> getSafetyResourceRecordsChecks(PreFillData preFillData, int idEvent,
                                                       SafetyResource safetyResource) {
    List<Integer> recordChecksPersons = new ArrayList<Integer>();
    List<Integer> hshldMembers = srHouseholdMembersDAO.findSrHouseholdMembersByIdEvent(idEvent);
    List<Integer> nonDuplicateList = new ArrayList<Integer>();

    Person primarySRPerson = getPrimaryResource(idEvent);
    recordChecksPersons.add(primarySRPerson.getIdPerson());
    Person secondarySRPerson = getSecondaryResource(idEvent);
    if (secondarySRPerson.getIdPerson() != null && secondarySRPerson.getIdPerson() != 0) {
      recordChecksPersons.add(secondarySRPerson.getIdPerson());
    }
    recordChecksPersons.addAll(hshldMembers);
    if (recordChecksPersons != null && !recordChecksPersons.isEmpty()) {
      for (Iterator<Integer> it = recordChecksPersons.iterator(); it.hasNext();) {
        Integer idPerson = it.next();
        if (!nonDuplicateList.contains(idPerson)) {
          Person person = getPersistentObject(Person.class, idPerson);
          nonDuplicateList.add(idPerson);
          FormDataGroup houseHoldGroup = createFormDataGroup(TMPLAT_HSLD_MEMB_RC, FAS05O00);
          houseHoldGroup.addBookmark(createBookmark(SAFETY_RESOURCE, formatFullName(person)));
          houseHoldGroup.addFormDataGroup(displayRecordsChecks(person.getRecordsChecksForIdRecCheckPerson(),
                                                               houseHoldGroup));
          preFillData.addFormDataGroup(houseHoldGroup);

        }
      }
    }
    return nonDuplicateList;
  }

  private List<Integer> getRelativeCareRecordsChecks(PreFillData preFillData, int idEvent) {
    List<RelativeCareAssmtPerson> relatives = relativeCareAssmtPersonDAO
                                                                        .findRelativeCareAssmtPersonByIdRcaEvent(idEvent);
    List<Integer> nonDuplicateList = new ArrayList<Integer>();
    if (relatives != null && !relatives.isEmpty()) {
      for (Iterator<RelativeCareAssmtPerson> it = relatives.iterator(); it.hasNext();) {
        RelativeCareAssmtPerson relativeCareAssmtPerson = it.next();
        Integer idPerson = relativeCareAssmtPerson.getPersonByIdPerson().getIdPerson();
        if (!nonDuplicateList.contains(idPerson)) {
          Person person = getPersistentObject(Person.class, idPerson);
          nonDuplicateList.add(idPerson);
          FormDataGroup houseHoldGroup = createFormDataGroup(TMPLAT_HSLD_MEMB_RC, FAS05O00);
          houseHoldGroup.addBookmark(createBookmark(SAFETY_RESOURCE, formatFullName(person)));
          houseHoldGroup.addFormDataGroup(displayRecordsChecks(person.getRecordsChecksForIdRecCheckPerson(),
                                                               houseHoldGroup));
          preFillData.addFormDataGroup(houseHoldGroup);
        }
      }
    }
    return nonDuplicateList;
  }

  private FormDataGroup displayRecordsChecks(Collection<RecordsCheck> recordCheckList, FormDataGroup superGroup) {

    if (recordCheckList != null && !recordCheckList.isEmpty())
      for (Iterator<RecordsCheck> it = recordCheckList.iterator(); it.hasNext();) {
        RecordsCheck recordCheck = it.next();
        superGroup.addFormDataGroup(populateRecords(recordCheck));
      }
    return superGroup;
  }

  private FormDataGroup populateRecords(RecordsCheck recordCheck) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PSR_RECORD, FAS05O00);
    group.addBookmark(createBookmark(PSR_SEARCH_TYPE, Lookup.simpleDecodeSafe(CodesTables.CCHKTYPE,
                                                                              recordCheck.getCdRecCheckCheckType())));
    group.addBookmark(createBookmark(PSR_DT_REQ, FormattingHelper.formatDate(recordCheck.getDtRecCheckRequest())));
    String indHistrory = (recordCheck.getIndReccheckHistory() == null || ArchitectureConstants.N.equals(recordCheck.getIndReccheckHistory()) ? "No"
                                                                                                                   : "Yes");
    group.addBookmark(createBookmark(PSR_HIS, indHistrory));
    group.addBookmark(createBookmark(PSR_DT_COMP, FormattingHelper.formatDate(recordCheck.getDtRecCheckCompleted())));
    group.addBookmark(createBookmark(PSR_COMMENTS, recordCheck.getTxtRecCheckComments()));
    return group;
  }

  private List<Integer> addCollectionToList(List<Integer> returnedList, Collection<SafetyResourceChild> addedList) {
    if (addedList != null && !addedList.isEmpty()) {
      for (Iterator<SafetyResourceChild> it = addedList.iterator(); it.hasNext();) {
        SafetyResourceChild safetyResourceChild = (SafetyResourceChild) it.next();
        returnedList.add(safetyResourceChild.getIdChild());

      }
    }
    return returnedList;
  }

  private String getEventType(int idEvent) {
    String eventType = "";
    if (idEvent > 0) {
      Event event = getPersistentObject(Event.class, idEvent);
      eventType = event.getCdEventType();
    }
    return eventType;
  }

  private void getSafetyResourceCaregivers(int idEvent, PreFillData preFillData) {
    preFillData.addBookmark(createBookmark(TYPE_THREE, "Safety Resource"));
    List<Person> safetyResourcesInfo = new ArrayList<Person>();
    Person primarySRPerson = getPrimaryResource(idEvent);
    safetyResourcesInfo.add(primarySRPerson);
    Person secondarySRPerson = getSecondaryResource(idEvent);
    if (secondarySRPerson.getIdPerson() != null && secondarySRPerson.getIdPerson() != 0) {
      safetyResourcesInfo.add(secondarySRPerson);

    }

    if (safetyResourcesInfo != null && !safetyResourcesInfo.isEmpty()) {
      for (Iterator<Person> it = safetyResourcesInfo.iterator(); it.hasNext();) {
        Person person = it.next();
        careGiverList.add(person.getIdPerson());
        preFillData.addFormDataGroup(displayCaregivers(person, preFillData));
      }
    }
  }

  private void getRelativeCaregivers(int idEvent, PreFillData preFillData) {
    preFillData.addBookmark(createBookmark(TYPE_THREE, "Relative Caregiver(s)"));
    List<RelativeCareAssmtPerson> relativeCaregivers = relativeCareAssmtPersonDAO
                                                                                 .findRelativeCareAssmtPersonByIdRcaEventCdPersonType(
                                                                                                                                      idEvent,
                                                                                                                                      CodesTables.CPRNTYP_PRC);
    if (relativeCaregivers != null && !relativeCaregivers.isEmpty()) {
      for (Iterator<RelativeCareAssmtPerson> it = relativeCaregivers.iterator(); it.hasNext();) {
        RelativeCareAssmtPerson relativeCareAssmtPerson = it.next();
        Person person = relativeCareAssmtPerson.getPersonByIdPerson();
        careGiverList.add(person.getIdPerson());
        preFillData.addFormDataGroup(displayCaregivers(person, preFillData));
      }
    }
  }

  private void getRelativeCareOtherHouseMembs(int idEvent, PreFillData preFillData) {
    List<RelativeCareAssmtPerson> houseMembs = relativeCareAssmtPersonDAO
                                                                         .findRelativeCareAssmtPersonByIdRcaEventCdPersonType(
                                                                                                                              idEvent,
                                                                                                                              CodesTables.CPRNTYP_HOM);
    if (houseMembs != null && !houseMembs.isEmpty()) {
      for (Iterator<RelativeCareAssmtPerson> it = houseMembs.iterator(); it.hasNext();) {
        RelativeCareAssmtPerson relativeCareAssmtPerson = it.next();
        Person person = relativeCareAssmtPerson.getPersonByIdPerson();
        houseHoldMembersList.add(person.getIdPerson());
        preFillData.addFormDataGroup(displayHomeMembs(person, preFillData));
      }
    }
  }

  private void getSafetyResourceOtherHouseMembs(int idEvent, PreFillData preFillData) {
    List<Integer> hshldMembers = srHouseholdMembersDAO.findSrHouseholdMembersByIdEvent(idEvent);
    if (hshldMembers != null && !hshldMembers.isEmpty()) {
      for (Iterator<Integer> it = hshldMembers.iterator(); it.hasNext();) {
        Integer idPerson = it.next();
        Person houseHoldPerson = getPersistentObject(Person.class, idPerson);
        houseHoldMembersList.add(houseHoldPerson.getIdPerson());
        preFillData.addFormDataGroup(displayHomeMembs(houseHoldPerson, preFillData));
      }
    }
  }

  private void getRelativeCareChildrenInCase(int idEvent, PreFillData preFillData) {
    List<RelativeCareAssmtPerson> relativeCarePersonList = relativeCareAssmtPersonDAO
                                                                                     .findRelativeCareAssmtPersonByIdRcaEventCdPersonType(
                                                                                                                                          idEvent,
                                                                                                                                          CodesTables.CPRNTYP_CHP);
    if (relativeCarePersonList != null && !relativeCarePersonList.isEmpty()) {
      for (Iterator<RelativeCareAssmtPerson> it = relativeCarePersonList.iterator(); it.hasNext();) {
        RelativeCareAssmtPerson relativeCareAssmtPerson = it.next();
        String fullName = (String) relativeCareAssmtPerson.getPersonByIdPerson().getNmPersonFull();
        if (relativeCareAssmtPerson.getPersonByIdPerson() != null) {
          childrenPlacedList.add(relativeCareAssmtPerson.getPersonByIdPerson().getIdPerson());
          preFillData.addFormDataGroup(displayChildrenInCase(relativeCareAssmtPerson.getPersonByIdPerson()
                                                                                    .getIdPerson(), fullName));
        }
      }
    }
  }

  // This function gathers and displays the personal information of each child in the home for Safety Resource
  // Assesments.
  @SuppressWarnings("unchecked")
  private void getSafetyResourceChildrenInCase(int idEvent, PreFillData preFillData) {
    List<Map> resoruceChild = safetyResourceChildDAO.findSafetyResourceChildrenForEvent(idEvent);
    for (Iterator<Map> it = resoruceChild.iterator(); it.hasNext();) {
      Map safetyResourceChildMap = it.next();
      SafetyResourceChild safetyResourceChild = (SafetyResourceChild) safetyResourceChildMap.get("safetyResourceChild");

      String fullName = (String) safetyResourceChildMap.get("nmPersonFull");
      int idChild = safetyResourceChild.getIdChild();
      childrenPlacedList.add(idChild);
      preFillData.addFormDataGroup(displayChildrenInCase(idChild, fullName));
    }
  }

  private String getEducationalPrograms(EducationalHistory educationalHistory) {
    StringBuffer programs = new StringBuffer();
    String needs1 = educationalHistory.getCdEdhistNeeds1() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds1())
                                                                  : null;
    if (needs1 != null) {
      programs.append(" " + needs1 + ",");
    }
    String needs2 = educationalHistory.getCdEdhistNeeds2() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds2())
                                                                  : null;
    if (needs2 != null) {
      programs.append(" " + needs2 + ",");
    }
    String needs3 = educationalHistory.getCdEdhistNeeds3() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds3())
                                                                  : null;
    if (needs3 != null) {
      programs.append(" " + needs3 + ",");
    }
    String needs4 = educationalHistory.getCdEdhistNeeds4() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds4())
                                                                  : null;
    if (needs4 != null) {
      programs.append(" " + needs4 + ",");
    }
    String needs5 = educationalHistory.getCdEdhistNeeds5() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds5())
                                                                  : null;
    if (needs5 != null) {
      programs.append(" " + needs5 + ",");
    }
    String needs6 = educationalHistory.getCdEdhistNeeds6() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds6())
                                                                  : null;
    if (needs6 != null) {
      programs.append(" " + needs6 + ",");
    }
    String needs7 = educationalHistory.getCdEdhistNeeds7() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds7())
                                                                  : null;
    if (needs7 != null) {
      programs.append(" " + needs7 + ",");
    }
    String needs8 = educationalHistory.getCdEdhistNeeds8() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds8())
                                                                  : null;
    if (needs8 != null) {
      programs.append(" " + needs8 + ",");
    }
    String needs9 = educationalHistory.getCdEdhistNeeds9() != null ? Lookup
                                                                           .simpleDecodeSafe(
                                                                                             "CEDUCNED",
                                                                                             educationalHistory
                                                                                                               .getCdEdhistNeeds9())
                                                                  : null;
    if (needs9 != null) {
      programs.append(" " + needs9 + ",");
    }
    String needs10 = educationalHistory.getCdEdhistNeeds10() != null ? Lookup
                                                                             .simpleDecodeSafe(
                                                                                               "CEDUCNED",
                                                                                               educationalHistory
                                                                                                                 .getCdEdhistNeeds10())
                                                                    : null;
    if (needs10 != null) {
      programs.append(" " + needs10 + ",");
    }
    // remove last unneeded ,
    if (programs.length() > 1) {
      programs.deleteCharAt(programs.length() - 1);
    }
    return programs.toString();
  }

  // This function is for the repeating group to display the children placed with the Safety Resource
  private FormDataGroup displayChildrenInCase(int idChild, String fullName) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CHILDREN, FAS05O00);
    Person child = personDAO.findPersonByIdPerson(idChild);
    String medicaidNum = personIdDAO.findNonEndDatePersonMedicaid(idChild);

    group.addBookmark(createBookmark(CHILD_NAME, fullName));
    group.addBookmark(createBookmark(CHILD_GENDER, Lookup.simpleDecodeSafe("CSEX", child.getCdPersonSex())));
    group.addBookmark(createBookmark(CHILD_AGE, DateHelper.getAge(child.getDtPersonBirth())));
    group.addBookmark(createBookmark(CHILD_DOB, FormattingHelper.formatDate(child.getDtPersonBirth())));
    group.addBookmark(createBookmark(CHILD_MED_NUM, medicaidNum));

    return group;
  }

  private FormDataGroup displayCaregivers(Person caregiver, PreFillData preFillData) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CAREGIVERS, FAS05O00);
    group.addBookmark(createBookmark(GIVER_NM, caregiver.getNmPersonFull()));
    group.addBookmark(createBookmark(GIVER_GENDER, Lookup.simpleDecodeSafe("CSEX", caregiver.getCdPersonSex())));
    group.addBookmark(createBookmark(GIVER_MARTIAL, Lookup.simpleDecodeSafe("CMARSTAT",
                                                                            caregiver.getCdPersonMaritalStatus())));
    String identityVerified = isIdentityVerified(caregiver);
    group.addBookmark(createBookmark(GIVER_IDEN, identityVerified));
    group.addBookmark(createBookmark(GIVER_DOB, FormattingHelper.formatDate(caregiver.getDtPersonBirth())));
    String ssn = personIdDAO.findNonEndDatePersonSSN(caregiver.getIdPerson());
    group.addBookmark(createBookmark(GIVER_SSN, FormattingHelper.formatSSN(ssn)));

    return group;
  } // end of displayRelativeCaregivers

  private FormDataGroup displayHomeMembs(Person member, PreFillData preFillData) {
    FormDataGroup group = createFormDataGroup(TMPLAT_HOME_MEMB, FAS05O00);
    group.addBookmark(createBookmark(HOME_NM, member.getNmPersonFull()));
    group.addBookmark(createBookmark(HOME_GENDER, Lookup.simpleDecodeSafe("CSEX", member.getCdPersonSex())));
    group.addBookmark(createBookmark(HOME_MARTIAL, Lookup.simpleDecodeSafe("CMARSTAT",
                                                                           member.getCdPersonMaritalStatus())));
    String identityVerified = isIdentityVerified(member);
    group.addBookmark(createBookmark(HOME_IDEN, identityVerified));
    group.addBookmark(createBookmark(HOME_DOB, FormattingHelper.formatDate(member.getDtPersonBirth())));
    return group;
  } // end of displayHomeMembs

  private String isIdentityVerified(Person person) {
    String verified = "";
    // Citizenship Verification
    List<PersonCitizenship> citizenshipVerification = personCitizenshipDAO
                                                                          .findCheckboxByIdPersonCbxCodeType(
                                                                                                             person
                                                                                                                   .getIdPerson(),
                                                                                                             CodesTables.CCERTVER);
    // Identity Verification 16 and Over
    List<PersonCitizenship> identityVerificationAdult = personCitizenshipDAO
                                                                            .findCheckboxByIdPersonCbxCodeType(
                                                                                                               person
                                                                                                                     .getIdPerson(),
                                                                                                               CodesTables.CIDENTAD);
    // Identity Verification under 16
    List<PersonCitizenship> identityVerificationUnder16 = personCitizenshipDAO
                                                                              .findCheckboxByIdPersonCbxCodeType(
                                                                                                                 person
                                                                                                                       .getIdPerson(),
                                                                                                                 CodesTables.CIDENTUN);

    if (citizenshipVerification == null || citizenshipVerification.isEmpty()) {
      verified = "N";
    } else if ((identityVerificationAdult == null || identityVerificationAdult.isEmpty())
               && (identityVerificationUnder16 == null || identityVerificationUnder16.isEmpty())) {
      verified = "N";
    } else {
      verified = "Y";
    }
    return verified;
  }

  // This function gathers and displays all characteristics of the Members
  private FormDataGroup displayChara(Characteristics characteristics) {
    String charaCategory = characteristics.getCdCharCategory();
    FormDataGroup group = createFormDataGroup(TMPLAT_CHARACTERISTICS, FAS05O00);
    group.addBookmark(createBookmark(CHARA_NM, characteristics.getPerson().getNmPersonFull()));
    group.addBookmark(createBookmark(CHARA_CAT,
                                     Lookup.simpleDecodeSafe("CCHRTCAT", characteristics.getCdCharCategory())));
    group.addBookmark(createBookmark(CHARA_CHARA, Lookup.simpleDecodeSafe(charaCategory,
                                                                          characteristics.getCdCharacteristic())));
    return group;
  } // end of displayChildrenPlacedMedication

  // This function gathers and displays all medication of the Children Placed Section
  private FormDataGroup displaySafetyResourceMedication(Medication medication) {
    FormDataGroup group = createFormDataGroup(TMPLAT_MEDS, FAS05O00);
    group.addBookmark(createBookmark(MED_PERSON_NAME, medication.getPerson().getNmPersonFull()));
    group.addBookmark(createBookmark(CP_MED_NAME, medication.getNmMedctn()));
    group.addBookmark(createBookmark(CP_MED_FREQ, Lookup.simpleDecodeSafe("CMDDOSE", medication.getCdMedctnDose())));
    group.addBookmark(createBookmark(CP_ST_DATE, FormattingHelper.formatDate(medication.getDtMedctnPresc())));
    group.addBookmark(createBookmark(CP_ED_DATE, FormattingHelper.formatDate(medication.getDtMedctnEndDate())));
    group.addBookmark(createBookmark(CP_ALL_IND, medication.getIndMedctnAllergies()));
    group.addBookmark(createBookmark(CP_ALL_DES, medication.getTxtMedctnDescrip()));

    return group;
  } // end of displaySafetyResourceMedication

  // This function gathers and displays all educational information
  private FormDataGroup displayEducationHistory(EducationalHistory educationalHistory) {
    String educationPrograms = getEducationalPrograms(educationalHistory);
    FormDataGroup group = createFormDataGroup(TMPLAT_CP_EDUCATION, FAS05O00);
    group.addBookmark(createBookmark(EDU_PERSON_NAME, educationalHistory.getPerson().getNmPersonFull()));
    group.addBookmark(createBookmark(CP_EDU_TYPE, Lookup.simpleDecodeSafe("CEDTYPE",
                                                                          educationalHistory.getCdEdhistType())));
    group.addBookmark(createBookmark(CP_SCH_NAME, educationalHistory.getNmEdhistSchool()));
    group.addBookmark(createBookmark(CP_ATTEN,
                                     Lookup.simpleDecodeSafe("CATNDNCE", educationalHistory.getCdAttendance())));
    group
         .addBookmark(createBookmark(CP_ENR_DT, FormattingHelper.formatDate(educationalHistory.getDtEdhistEnrollDate())));
    group.addBookmark(createBookmark(CP_GRADE_L, Lookup.simpleDecodeSafe("CSCHGRAD",
                                                                         educationalHistory.getCdCurrGrade())));
    group.addBookmark(createBookmark(CP_EDU_PROG, educationPrograms));
    group.addBookmark(createBookmark(CP_EDU_COMM, educationalHistory.getTxtEdhistCmnts()));

    return group;
  } // end of displayEducationHistory

  // This function gathers and displays all educational information
  private FormDataGroup displayIncomeAndResources(IncomeAndResources incomeAndResources) {
    FormDataGroup group = createFormDataGroup(TMPLAT_INCOME, FAS05O00);
    group.addBookmark(createBookmark(INC_NAME, incomeAndResources.getPersonByIdPerson().getNmPersonFull()));
    group.addBookmark(createBookmark(INC_TYPE, Lookup.simpleDecodeSafe("CINCRSRC",
                                                                       incomeAndResources.getCdIncRsrcType())));
    group.addBookmark(createBookmark(INC_AMOUNT, incomeAndResources.getAmtIncRsrc()));
    group.addBookmark(createBookmark(INC_FREQ, Lookup.simpleDecodeSafe("CFREQ",
                                                                       incomeAndResources.getCdIncRsrcFreqType())));
    group.addBookmark(createBookmark(INC_ST_DT, FormattingHelper.formatDate(incomeAndResources.getDtIncRsrcFrom())));

    return group;
  } // end of displayIncomeAndResources

  /**
   * This Private Method gets a persons City, State and zip and concat's them so it can be used in a single bookmark.
   * 
   * @param primaryPerson
   * @return Sting
   */
  private String getPrimaryResourceCityState(Person primaryPerson) {
    String cityState = null;
    String city = primaryPerson.getAddrPersonCity();
    String state = Lookup.simpleDecodeSafe("CSTATE", primaryPerson.getCdPersonState());
    String zip = primaryPerson.getAddrPersonZip() != null ? primaryPerson.getAddrPersonZip() : " ";
    if (city != null) {
      state = state.concat("      " + zip);
      city = city.concat("                ");
      cityState = city.concat(state);
    }
    return cityState;

  }

  /**
   * This private method returns the Person object of the Primary Resource when given an Event id
   * 
   * @param idEvent
   * @return Person
   */
  private Person getPrimaryResource(int idEvent) {

    SafetyResource safetyResource = getPersistentObject(SafetyResource.class, idEvent);
    Person primaryPerson = getPersistentObject(Person.class, safetyResource.getIdPrimary());

    return primaryPerson;
  }

  /**
   * This private method returns the Person object of the Secondary Resource when given an Event id
   * 
   * @param idEvent
   * @return Person
   */
  private Person getSecondaryResource(int idEvent) {
    Person secondaryPerson = new Person();
    SafetyResource safetyResource = getPersistentObject(SafetyResource.class, idEvent);
    if (safetyResource.getIdSecondary() != null && safetyResource.getIdSecondary() != 0) {
      secondaryPerson = getPersistentObject(Person.class, safetyResource.getIdSecondary());
    }

    return secondaryPerson;
  }

  /**
   * This private method gets the primary phone number
   * 
   * @param primaryPerson
   * @return String number
   */
  private String getPrimaryPhone(Person primaryPerson, Collection<PersonPhone> phoneNumbers) {
    String number = new String();
    for (Iterator<PersonPhone> phoneIterator = phoneNumbers.iterator(); phoneIterator.hasNext();) {
      PersonPhone personPhone = phoneIterator.next();
      if (DateHelper.MAX_JAVA_DATE.equals(personPhone.getDtPersonPhoneEnd())
          && !"Y".equals(personPhone.getIndPersonPhoneInvalid())) {
        if ("Y".equals(personPhone.getIndPersonPhonePrimary())) {
          number = personPhone.getNbrPersonPhone();
          break;
        }
      }
    }
    return number;
  }

  /**
   * This private method gets the primary phone number
   * 
   * @param primaryPerson
   * @return String number
   */
  private String getCellPhone(Person secondaryPerson, Collection<PersonPhone> phoneNumbers) {
    String number = new String();
    for (Iterator<PersonPhone> phoneIterator = phoneNumbers.iterator(); phoneIterator.hasNext();) {
      PersonPhone personPhone = phoneIterator.next();
      // STGAP00014714 Displaying the first cell phone number in the list regardless if it is the same as the primary
      // phone.
      if (("RC".equals(personPhone.getCdPersonPhoneType()) || "BC".equals(personPhone.getCdPersonPhoneType()))) {
        if (DateHelper.MAX_JAVA_DATE.equals(personPhone.getDtPersonPhoneEnd())
            && !"Y".equals(personPhone.getIndPersonPhoneInvalid())) {
          number = personPhone.getNbrPersonPhone();
          break;
        }
      }
    }
    return number;
  }

  /**
   * This private method displays name as First Middle Last
   * 
   * @param person
   * @return formatted name
   */
  private String formatFullName(Person person) {
    String firstName = person.getNmPersonFirst();
    String lastName = person.getNmPersonLast();
    String middleName = person.getNmPersonMiddle();
    String formattedName = "";
    if (middleName != null && !"".equals(middleName)) {
      formattedName = firstName + " " + middleName + " " + lastName;
    } else {
      formattedName = firstName + " " + lastName;
    }

    return formattedName;
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

}// end of SafetyRscrAssessmentFrmImpl
