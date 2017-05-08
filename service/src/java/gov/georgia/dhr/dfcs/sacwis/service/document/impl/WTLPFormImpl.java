package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WtlpPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;
import gov.georgia.dhr.dfcs.sacwis.db.PlanParticipant;
import gov.georgia.dhr.dfcs.sacwis.db.PlanStep;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;
import gov.georgia.dhr.dfcs.sacwis.db.YouthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.document.WTLPForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.WTLPFORMSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   07/29/2008   Vishala Devarakonda   Initial creation of WTLP form template  
 *   10/28/2009   Courtney Wells        37324-Showing Graduation Credit information regardless of 
 *                                      Emancipation Discussion Date.              
 * </pre>
 * 
 */
public class WTLPFormImpl extends BaseDocumentServiceImpl implements WTLPForm {

  private PersonDAO personDAO;

  private PersonRaceDAO personRaceDAO;

  private PersonEthnicityDAO personEthnicityDAO;

  private LegalStatusDAO legalStatusDAO;

  private PersonPhoneDAO personPhoneDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private PlanGoalDAO planGoalDAO;

  private PlacementDAO placementDAO;

  private WtlpPlanDAO wtlpPlanDAO;

  private YouthDetailDAO youthDetailDAO;

  private EligibilityDAO eligibilityDAO;
  
  private PlanParticipantDAO planParticipantDAO;
  
  public void setPlanParticipantDAO(PlanParticipantDAO planParticipantDAO) throws ServiceException {
    this.planParticipantDAO = planParticipantDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setYouthDetailDAO(YouthDetailDAO youthDetailDAO) {
    this.youthDetailDAO = youthDetailDAO;
  }

  public void setWtlpPlanDAO(WtlpPlanDAO wtlpPlanDAO) {
    this.wtlpPlanDAO = wtlpPlanDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPlanGoalDAO(PlanGoalDAO planGoalDAO) {
    this.planGoalDAO = planGoalDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public WTLPFORMSO retrieveWtlpForm(WTLPFORMSI WTLPFORMSI) {
    WTLPFORMSO wtlpFormso = new WTLPFORMSO();

    int idStage = WTLPFORMSI.getUlIdStage();
    int idChildPrimary = WTLPFORMSI.getUlIdPerson();
    int idEvent = WTLPFORMSI.getUlIdEvent();

    // ******************************** Build the Objects used in the form *****************//

    // get primary child data
    Person primaryChild = retrievePersonData(idChildPrimary);
    // Placement
    Placement currentPlacement = getCurrentPlacement(idChildPrimary);
    // WTLP detail
    YouthDetail youthDetail = null;
    WtlpPlan wtlpPlan = null;
    Person ydpCoordinator = null;
    Placement wtlpPlcmt = null;
    List<PlanGoal> wtlpPlanGoals = null;
    List<PlanParticipant> planParticipants = null;
    Eligibility eligibility14 = null;
    LegalStatus chld14LegalStatus = null;
    Person caseMngr = null;
    // get LEGAL STATUS
    LegalStatus legalStatus = retrieveLegalStatusData(idChildPrimary);
      wtlpPlan = wtlpPlanDAO.findWtlpPlanLatestByIdStageByIdPerson(idEvent);
      if (wtlpPlan != null) {
        ydpCoordinator = wtlpPlan.getPersonByIdYdpCoord();
        youthDetail = youthDetailDAO.findYouthDetail(idChildPrimary);
        caseMngr = getCaseManagerInfo(idStage);
        wtlpPlcmt = currentPlacement;
        eligibility14 = getEligibility(idStage, idChildPrimary);
        chld14LegalStatus = legalStatus;
        wtlpPlanGoals = getPlanedGoalsByIdEventByCdGoalType(wtlpPlan.getIdEvent().intValue(), GOAL_TYPE);
        planParticipants = getPlanParticipantsByIdEvent(wtlpPlan.getIdEvent().intValue());
    }
    // ******************************** Build the form *****************//

    // Start building the page
    PreFillData preFillData = new PreFillData();

    // WTLP
    retrieveWtlp(preFillData, primaryChild, ydpCoordinator, wtlpPlcmt, eligibility14, youthDetail, chld14LegalStatus,
                 caseMngr, wtlpPlan, wtlpPlanGoals, planParticipants);

    wtlpFormso.setPreFillData(preFillData);

    return wtlpFormso;
  }

  private Eligibility getEligibility(int idStage, int idPerson) {
    Eligibility eligibility = eligibilityDAO.findEligibilityLatestApprovedByIdStageByIdPerson(idStage, idPerson);

    return eligibility;
  }

  // get the case manager for the FCCP Family stage
  private Person getCaseManagerInfo(int idStage) {
    // Checking for current case manager as well as historical case manager
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
    Person caseMngr = stagePersonLink.getPerson();
    return caseMngr;
  } // end getCaseManagerInfo()

  private String retrievePersonRaceData(int idPerson) {
    List<PersonRace> personRaceList = personRaceDAO.findPersonRaceByIdPerson(idPerson);
    StringBuffer raceList = new StringBuffer();
    if (personRaceList != null && !personRaceList.isEmpty()) {
      for (Iterator<PersonRace> it = personRaceList.iterator(); it.hasNext();) {
        PersonRace personRace = it.next();
        raceList.append(Lookup.simpleDecodeSafe(CodesTables.CRACE, personRace.getCdRace()));
      }
    }

    return raceList.toString();
  }

  private PersonEthnicity retrievePersonEthnicityData(int idPerson) {
    PersonEthnicity personEthnicity = personEthnicityDAO.findLatestPersonEthnicityByIdPerson(idPerson);

    return personEthnicity;
  }

  private List<PlanGoal> getPlanedGoalsByIdEventByCdGoalType(int idEvent, String cdGoalType) {

    List<PlanGoal> planGoalList = planGoalDAO.findFCGSByIdEventByCdGoalType(idEvent, cdGoalType);

    return planGoalList;
  }
  
  private List<PlanParticipant> getPlanParticipantsByIdEvent(int idEvent) {

    List<PlanParticipant> planParticipantList = planParticipantDAO.findPlanParticipantByIdEvent(idEvent);

    return planParticipantList;
  }
  
  private Person retrievePersonData(int idPerson) {
    Person person = personDAO.findPersonByIdPerson(idPerson);

    return person;
  }

  // if a person has a primary active & valid business office phone, select it, otherwise get the next active & valid
  // business phone available
  private String getPersonOfficePhone(int idPerson) {
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
    phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
    phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

    return getPersonOfficePhoneNbr(idPerson, phoneTypes);
  }

  private String getPersonOfficePhoneNbr(int idPerson, List<String> phoneTypes) {
    StringBuffer primPersonPhone = new StringBuffer();
    String indPersonPhoneInValid = "N";
    String indPersonPhonePrimary = "Y";

    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    List<PersonPhone> personPhones = personPhoneDAO
                                                   .findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(
                                                                                                             idPerson,
                                                                                                             maxDate,
                                                                                                             indPersonPhoneInValid,
                                                                                                             phoneTypes);

    for (Iterator<PersonPhone> it = personPhones.iterator(); it.hasNext();) {

      PersonPhone personPhone = it.next();
      if (personPhone != null) {
        if (indPersonPhonePrimary.equals(personPhone.getIndPersonPhonePrimary())) {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          }
        } else {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          } // inner else
        } // end outer if indPersonPhonePrimary
      } // end if personPhone
    } // end for loop
    return primPersonPhone.toString();

  }

  private LegalStatus retrieveLegalStatusData(int idPerson) {
    LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPerson);

    return legalStatus;
  }

  private String getFullName(Person person) {
    StringBuffer fullName = new StringBuffer();
    if (person != null) {
      fullName.append(person.getNmPersonLast());
      if (person.getNmPersonFirst() != null) {
        fullName.append(", " + person.getNmPersonFirst());
      }
      if (person.getNmPersonMiddle() != null) {
        fullName.append(" " + person.getNmPersonMiddle());
      }
      if (person.getCdPersonSuffix() != null) {
        fullName.append(" " + person.getCdPersonSuffix());
      }
    }
    return fullName.toString();
  }

  // Start Current Placement
  private Placement getCurrentPlacement(int idPrimaryChild) {
    return placementDAO.findPlacementLatestApprovedByIdPerson(idPrimaryChild, DateHelper.MAX_JAVA_DATE);
  }

  private PersonAddress getPrimaryPersonAddress(Person person) {
    PersonAddress personAddress = null;
    if (person != null) {
      Collection<AddressPersonLink> personAddresses = person.getAddressPersonLinks();
      if (personAddresses != null && !personAddresses.isEmpty()) {
        for (Iterator<AddressPersonLink> it = personAddresses.iterator(); it.hasNext();) {
          AddressPersonLink addressPersonLink = it.next();
          if (addressPersonLink.getIndPersAddrLinkPrimary().equals("Y")
              && DateHelper.isNull(addressPersonLink.getDtPersAddrLinkEnd())) {
            personAddress = addressPersonLink.getPersonAddress();
            break;
          }
        } // end for loop
      } // end personAddress
    } // end person
    return personAddress;
  }

  private void retrieveWtlp(PreFillData preFillData, Person primaryChild, Person ydpCoordinator, Placement wtlpPlcmt,
                            Eligibility eligibility, YouthDetail youthDetail, LegalStatus chld14LegalStatus,
                            Person caseMngr, WtlpPlan wtlpPlan, List<PlanGoal> wtlpPlanGoals, List<PlanParticipant> planParticipants) {

    PersonAddress primaryChildAddress = getPrimaryPersonAddress(primaryChild);
    //PlanParticipant planParticipant = getPlanParticipant
    buildWtlpInfo(preFillData, primaryChild, ydpCoordinator, wtlpPlcmt, eligibility, youthDetail, chld14LegalStatus,
                  wtlpPlan, caseMngr, primaryChildAddress, wtlpPlanGoals, planParticipants);
  }

  private void buildWtlpInfo(PreFillData preFillData, Person primaryChild, Person ydpCoordinator, Placement wtlpPlcmt,
                             Eligibility eligibility, YouthDetail youthDetail, LegalStatus chld14LegalStatus,
                             WtlpPlan wtlpPlan, Person caseMngr, PersonAddress primaryChildAddress,
                             List<PlanGoal> wtlpPlanGoals, List<PlanParticipant> planParticipants) {

    Date birthDate = primaryChild.getDtPersonBirth();
    if (wtlpPlan != null) {
      final HashMap<String, String> authPlcmtCodes = new HashMap<String, String>();
      authPlcmtCodes.put("TEM", "Temporary");
      authPlcmtCodes.put("PER", "Permanent");
      authPlcmtCodes.put("VOL", "Voluntary");

      final HashMap<String, String> wtlpCdPlanTypes = new HashMap<String, String>();
      wtlpCdPlanTypes.put("I", "30-Day Case Plan");
      wtlpCdPlanTypes.put("R", "Case Review");

      final HashMap<String, String> wtlpGoalTypes = new HashMap<String, String>();
      wtlpGoalTypes.put(CodesTables.CGOALTYP_EDU, "Education");
      wtlpGoalTypes.put(CodesTables.CGOALTYP_VEP, "Vocational/Employment Prep");
      wtlpGoalTypes.put(CodesTables.CGOALTYP_BDL, "Basic Daily Living");
      wtlpGoalTypes.put(CodesTables.CGOALTYP_HEM, "Health/Education Maintenance");
      wtlpGoalTypes.put(CodesTables.CGOALTYP_PDC, "Personal Development/Counseling");

      if (primaryChild != null) {
        preFillData.addBookmark(createBookmark(WTLP_STEPS_CHLD_FNAME, getFullName(primaryChild)));
        preFillData.addBookmark(createBookmark(WTLP_STEP_CHILD_FULLNAME, getFullName(primaryChild)));

        preFillData.addBookmark(createBookmark(WTLP_CHLD_FULLNAME, getFullName(primaryChild)));
        if (birthDate != null) {
          preFillData.addBookmark(createBookmark(WTLP_DOB, FormattingHelper.formatDate(birthDate)));
        }
        preFillData.addBookmark(createBookmark(WTLP_GENDER, Lookup.simpleDecodeSafe(CodesTables.CSEX,
                                                                                    primaryChild.getCdPersonSex())));
        preFillData.addBookmark(createBookmark(WTLP_MRTL_STAT,
                                               Lookup.simpleDecodeSafe(CodesTables.CMARSTAT,
                                                                       primaryChild.getCdPersonMaritalStatus())));
        int idPerson = primaryChild.getIdPerson().intValue();
        String ethnicity = "";
        if (retrievePersonEthnicityData(idPerson) != null) {
          ethnicity = Lookup.simpleDecodeSafe(CodesTables.CINDETHN,
                                              retrievePersonEthnicityData(idPerson).getCdEthnicity());
        }
        String race = "";
        if (retrievePersonRaceData(idPerson) != null) {
          race = retrievePersonRaceData(idPerson);
        }
        String raceEthnicity = race + "/" + ethnicity;
        preFillData.addBookmark(createBookmark(WTLP_RACE_ETHNCTY, raceEthnicity));
      } // end primaryChild

      if (ydpCoordinator != null) {
        preFillData.addBookmark(createBookmark(WTLP_YDP_FULLNAME, getFullName(ydpCoordinator)));
        preFillData.addBookmark(createBookmark(WTLP_YDP_PH_NBR, getPersonOfficePhone(ydpCoordinator.getIdPerson()
                                                                                                   .intValue())));
      } // end ydpCoordinator

      if (caseMngr != null) {
        preFillData.addBookmark(createBookmark(WTLP_CASE_MNGR_FNAME, getFullName(caseMngr)));
        preFillData.addBookmark(createBookmark(WTLP_CASE_MNGR_PH_NBR, getPersonOfficePhone(caseMngr.getIdPerson()
                                                                                                   .intValue())));
      } // end ydpCoordinator

      if (wtlpPlcmt != null) {
        preFillData.addBookmark(createBookmark(WTLP_CURR_LV_ARR, Lookup.simpleDecodeSafe(CodesTables.CPLMNTYP,
                                                                                         wtlpPlcmt.getCdPlcmtType())));

      } // end wtlpPlcmt

      if (eligibility != null) {
        preFillData
                   .addBookmark(createBookmark(WTLP_ELIGIBILITY, Lookup.simpleDecodeSafe(CodesTables.CELIGIBI,
                                                                                         eligibility.getCdEligActual())));
      } // end eligibility

      if (youthDetail != null) {
        preFillData
                   .addBookmark(createBookmark(WTLP_PARENT_STATUS, Lookup.simpleDecodeSafe(CodesTables.CPARSTAT,
                                                                                           youthDetail.getCdParStat())));
        preFillData.addBookmark(createBookmark(WTLP_EXPTD_GRAD_DT,
                                               FormattingHelper.formatDate(youthDetail.getDtSchGrad())));
        preFillData
                   .addBookmark(createBookmark(WTLP_ACDMY_TRACK, Lookup.simpleDecodeSafe(CodesTables.CATRACK,
                                                                                         youthDetail.getCdAcadTrack())));
        preFillData.addBookmark(createBookmark(WTLP_EDU_CRDT_GRAD_REQ, youthDetail.getNbrSchCreditReqd()));
        preFillData.addBookmark(createBookmark(WTLP_EDU_CRDT_GRAD_ERND, youthDetail.getNbrSchCreditEarned()));
        
        // Showing Graduation Credit information regardless of Emancipation Discussion Date.
        preFillData.addBookmark(createBookmark(WTLP_EMAN_CRDT_GRAD_REQ, youthDetail.getNbrPostReqCred()));
        preFillData.addBookmark(createBookmark(WTLP_EMAN_CRDT_GRAD_ERND, youthDetail.getNbrPostReqEar()));
        Date dtEmancipationDiscussed = youthDetail.getDtEmncDisc();
        if (dtEmancipationDiscussed != null) { // emancipation was discussed
          preFillData.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_Y, CAPX));
          preFillData.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_N, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_DT,
                                                 FormattingHelper.formatDate(dtEmancipationDiscussed)));
          preFillData.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_COMM,
                                                 FormattingHelper.formatString(youthDetail.getTxtEmncDisc())));

        } else {
          preFillData.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_Y, DOUBLEUNDERSCORE));
          preFillData.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_N, CAPX));
        }

      } else {
        // defaulted to no
        preFillData.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_Y, DOUBLEUNDERSCORE));
        preFillData.addBookmark(createBookmark(WTLP_EMNCPTN_DISC_YTH_N, CAPX));
      }

      // end youthDetail

      if (chld14LegalStatus != null) {
        preFillData.addBookmark(createBookmark(WTLP_CUST_STAT,
                                               Lookup.simpleDecodeSafe(CodesTables.CLEGSTAT,
                                                                       chld14LegalStatus.getCdLegalStatStatus())));
      } // end chld14LegalStatus

      if (wtlpPlan != null) {
        String wtlpStrength = FormattingHelper.formatString(wtlpPlan.getTxtStrengths());
        String filteredString = wtlpStrength.replaceAll("\r\n", "<br />");
        preFillData.addBookmark(createBookmark(WTLP_DT, FormattingHelper.formatDate(wtlpPlan.getDtWtlp())));
        preFillData
                   .addBookmark(createBookmark(
                                               WTLP_TYPE,
                                               (String) FormattingHelper
                                                                        .formatString(wtlpCdPlanTypes
                                                                                                     .get(wtlpPlan
                                                                                                                  .getCdPlanType()))));
        preFillData
                   .addBookmark(createBookmark(
                                               WTLP_AUTHRTY_PLCMT,
                                               FormattingHelper
                                                               .formatString(authPlcmtCodes
                                                                                           .get(wtlpPlan
                                                                                                        .getCdPlcmtAuth()))));
        preFillData.addBookmark(createBookmark(WTLP_DRTN_DT_FROM, FormattingHelper.formatDate(wtlpPlan.getDtFrom())));
        preFillData.addBookmark(createBookmark(WTLP_DRNT_DT_TO, FormattingHelper.formatDate(wtlpPlan.getDtTo())));
        preFillData.addBookmark(createBookmark(WTLP_STRENGTH, filteredString));
        preFillData.addBookmark(createBookmark(WTLP_NEEDS, FormattingHelper.formatString(wtlpPlan.getTxtNeeds())));
        if (wtlpPlan.getCdEdu() != null) {
          preFillData.addBookmark(createBookmark(WTLP_CHK_EDU, CAPX));
        }
        if (wtlpPlan.getCdVoc() != null) {
          preFillData.addBookmark(createBookmark(WTLP_CHK_VOC, CAPX));
        }
        if (wtlpPlan.getCdBasic() != null) {
          preFillData.addBookmark(createBookmark(WTLP_CHK_DAY_LVNG, CAPX));
        }
        if (wtlpPlan.getCdHealth() != null) {
          preFillData.addBookmark(createBookmark(WTLP_CHK_HEALTH, CAPX));
        }
        if (wtlpPlan.getCdPers() != null) {
          preFillData.addBookmark(createBookmark(WTLP_CHK_PRSNL, CAPX));
        }
      } // end wtlpPlan

      if (primaryChildAddress != null) {
        preFillData.addBookmark(createBookmark(WTLP_COUNTY,
                                               Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                       primaryChildAddress.getCdPersonAddrCounty())));
      } // end primaryChildAddress

      if (wtlpPlanGoals != null && !wtlpPlanGoals.isEmpty()) {
        buildWtlpGoals(preFillData, wtlpPlanGoals);
      } // end primwtlpPlanGoalsaryChild
      if (planParticipants != null && !planParticipants.isEmpty()) {
        buildPlanParticipants(preFillData, planParticipants);
      } // end PlanParticipants
    }
  } // end buildWtlpInfo

  private void buildWtlpGoals(PreFillData preFillData, List<PlanGoal> planGoals) {

    for (Iterator<PlanGoal> it = planGoals.iterator(); it.hasNext();) {
      PlanGoal planGoal = it.next();
      preFillData.addFormDataGroup(buildWtlpGoalGroup(planGoal));
    }
  } // end buildWtlpGoals
  
  private void buildPlanParticipants(PreFillData preFillData, List<PlanParticipant> planParticipants) {

    for (Iterator<PlanParticipant> it = planParticipants.iterator(); it.hasNext();) {
      PlanParticipant planParticipant = it.next();
      preFillData.addFormDataGroup(buildPlanParticipantGroup(planParticipant));
    }
  } // end buildWtlpGoals

  private FormDataGroup buildWtlpGoalGroup(PlanGoal planGoal) {
    FormDataGroup group = createFormDataGroup(TMPLAT_WTLP_GOAL_TYPES, TMPLAT_WTLP);

    group.addBookmark(createBookmark(WTLP_GOAL_TYPE, "WTLP"));
    group.addBookmark(createBookmark(WTLP_GOAL_RSN, Lookup.simpleDecodeSafe(CodesTables.CWTLPGLS,
                                                                            planGoal.getCdGoalRsn())));
    group.addBookmark(createBookmark(WTLP_GOAL_TXT, FormattingHelper.formatString(planGoal.getTxtGoal())));
    buildWtlpGoalSteps(group, planGoal.getPlanSteps());

    return group;
  } // end buildWtlpGoalGroup
  
  private FormDataGroup buildPlanParticipantGroup(PlanParticipant planParticipant) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PARTICIPANT_LIST, TMPLAT_WTLP);

    group.addBookmark(createBookmark(WTLP_PARTICIPANT_TYPE, Lookup.simpleDecodeSafe(CodesTables.CPARTYPE, planParticipant.getCdPartTyp())));
    group.addBookmark(createBookmark(WTLP_PARTICIPANT_NAME, FormattingHelper.formatString(planParticipant.getNmPart())));
    String relationship = "";
    //STGAP00010259: If the Participant type is person in case then the relationship is pre-populated by the relation ship 
    //code and is decoded. If the Participant type is other or staff then the relationship is a text entered by the user
    //so nop need of decoding
    if(Lookup.isValidCode(CodesTables.CRPTRINT,planParticipant.getCdRel())){
      relationship = Lookup.simpleDecodeSafe(CodesTables.CRPTRINT, planParticipant.getCdRel());
    }else{
      relationship = FormattingHelper.formatString(planParticipant.getCdRel());
    }
    group.addBookmark(createBookmark(WTLP_PARTICIPANT_REL, relationship));
    group.addBookmark(createBookmark(WTLP_DT_RECEIPT_SIGNED, FormattingHelper.formatDate(planParticipant.getDtSign())));
    group.addBookmark(createBookmark(WTLP_DT_PARTICIPATION, FormattingHelper.formatDate(planParticipant.getDtPart())));
    if(ArchitectureConstants.Y.equals(planParticipant.getIndAppv())){
    group.addBookmark(createBookmark(WTLP_PERSON_APPROVES_Y, CAPX));
    group.addBookmark(createBookmark(WTLP_PERSON_APPROVES_N, DOUBLEUNDERSCORE));
    }else if(ArchitectureConstants.N.equals(planParticipant.getIndAppv())){
      group.addBookmark(createBookmark(WTLP_PERSON_APPROVES_Y, DOUBLEUNDERSCORE));
      group.addBookmark(createBookmark(WTLP_PERSON_APPROVES_N, CAPX));
    }else{
      group.addBookmark(createBookmark(WTLP_PERSON_APPROVES_Y, DOUBLEUNDERSCORE));
      group.addBookmark(createBookmark(WTLP_PERSON_APPROVES_N, DOUBLEUNDERSCORE));
    }
    group.addBookmark(createBookmark(WTLP_DT_APPROVED, FormattingHelper.formatDate(planParticipant.getDtAppv()))); 
    group.addBookmark(createBookmark(WTLP_REASON_NOT_APPROVE, FormattingHelper.formatString(planParticipant.getTxtNoAppv())));
    return group;
  } // end buildWtlpGoalGroup

  private void buildWtlpGoalSteps(FormDataGroup goalGroup, Collection<PlanStep> planSteps) {
    int count = 1;
    for (Iterator<PlanStep> it = planSteps.iterator(); it.hasNext();) {
      PlanStep planStep = it.next();
      if ("Y".equals(planStep.getIndSelected())) {
        goalGroup.addFormDataGroup(buildWtlpGoalStepsGroup(planStep, count++));
      }
    }
  } // end buildWtlpGoalSteps

  private FormDataGroup buildWtlpGoalStepsGroup(PlanStep planStep, int stepNbr) {
    FormDataGroup group = createFormDataGroup(TMPLAT_WTLP_GOAL_STEPS, TMPLAT_WTLP);

    group.addBookmark(createBookmark(WTLP_STEP_SEQ, stepNbr));
    group.addBookmark(createBookmark(WTLP_STEP_ACTN, FormattingHelper.formatString(planStep.getTxtStep())));
    group.addBookmark(createBookmark(WTLP_STEP_PRSN, FormattingHelper.formatString(planStep.getTxtRspns())));
    group.addBookmark(createBookmark(WTLP_STEP_PRIORITY, FormattingHelper.formatString(planStep.getTxtPriority())));
    group.addBookmark(createBookmark(WTLP_STEP_CMPLTN_DT, FormattingHelper.formatDate(planStep.getDtAntComp())));
    group.addBookmark(createBookmark(WTLP_STEP_STATUS, Lookup.simpleDecodeSafe(CodesTables.CSTATUS,
                                                                               planStep.getCdStatus())));
    group.addBookmark(createBookmark(WTLP_STEP_COMM, planStep.getTxtStepComm()));

    return group;
  } // end buildWtlpGoalStepsGroup

  // End Wtlp

}
