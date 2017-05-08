package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonHomeRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ReferralPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrHouseholdMembersDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonAddHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageRepLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TribalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonHomeRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.ReferralPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonAddHistory;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.StageRepLink;
import gov.georgia.dhr.dfcs.sacwis.db.Tribal;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_FATHER_RELATIONSHIP_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_MOTHER_RELATIONSHIP;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_MOTHER_RELATIONSHIP_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_OTHER_RELATIONSHIP;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_OTHER_RELATIONSHIP_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
* <pre>
* Change History:
* Date      User              Description
* --------  ----------------  --------------------------------------------------
* 06/24/2009  bgehlot         STGAP00014329: MR-20 updates, New checkbox 'Primary Caretaker Household Member' added to the person detail page
* 09/30/2009  bgehlot         STGAP00015485: MR-56 Get the mothers, fathers and secondary care givers.
* 12/01/2009  cwells          38666: Checking to see if event type, event status, and event stage combination does not already 
*                             exists this will cut down on the excessive entries added in the cinv04sg02_array 
* 02/08/2010  mxpatel         CAPTA: Added validations for CAPTA changes.
* 03/05/2010  swroberts       Updated to correctly show 'Other Relationships' correctly regardless of the context
*                             the page is viewed in.                          
* 08/18/2010  bgehlot          SMS 66380 MR-072 Changes
* 08/29/2010 htvo	          MR-067: new field person email to Person Detail page - updated all relevant DAOs signature 
* 09/07/2010 bgehlot          SMS 66380 Removed MR-072 Changes
* 08/24/2011 schoi            STGAP00017013: MR-095 Added code for displaying a new section 'Add Person to Active Stages'
* 09/02/2011 hnguyen          STGAP00017011: MR-092 Added population for new SSI related questions
* </pre>
*/

public class RetrievePersonDetailImpl extends BaseServiceImpl implements RetrievePersonDetail {

  private static final String WINDOW_MODE_RELATE = PageModeConstants.PersonDetail.WINDOW_MODE_RELATE;

  private static final String WINDOW_MODE_MNTN_PERSON = PageModeConstants.PersonDetail.WINDOW_MODE_MNTN_PERSON;

  private static final String INITIAL_DEATH_TABLE = "INIT_CHLD_DTH_NARR_VIEW";

  private static final String COMMITTEE_DEATH_TABLE = "CHLD_DTH_COMM_NARR_VIEW";

  private static final int INITIAL_DOC_INDEX = 0;

  private static final int COMMITTEE_DOC_INDEX = 1;

  private static final String SECONDARY_CAREGIVER = "SC";

  private static final String PUTATIVE_FATHER = "PF";

  private static final String LEGAL_FATHER = "LF";

  private static final String BIOLOGICAL_FATHER = "BF";
  
  //STGAP00015485:  
  private static final String LEGAL_MOTHER = "LM";

  private static final String BIOLOGICAL_MOTHER = "BM";

  private static final String EMPTY_STRING = "";

  private static final String UNKNOWN = "U";

  private static final int PAGE_NBR = 1;

  private static final int PAGE_SIZE = 10;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private FcePersonDAO fcePersonDAO = null;

  private StageDAO stageDAO = null;
  
  private StagePersonAddHistoryDAO stagePersonAddHistoryDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private StageRepLinkDAO stageRepLinkDAO = null;
 
  private PersonDAO personDAO = null;

  private PersonDtlDAO personDtlDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private NameDAO nameDAO = null;

  private PersonHomeRemovalDAO personHomeRemovalDAO = null;

  private AllegationDAO allegationDAO = null;

  private ReferralPersonLinkDAO referralPersonLinkDAO = null;

  private TribalDAO tribalDAO = null;

  private RelationshipDAO relationshipDAO = null;
  
  private SafetyResourceDAO safetyResourceDAO = null;
  
  private SafetyResourceChildDAO safetyResourceChildDAO = null;
  
  private SrHouseholdMembersDAO srHouseholdMembersDAO = null;
  
  private CapsCaseDAO capsCaseDAO = null;


  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setStageRepLinkDAO(StageRepLinkDAO stageRepLinkDAO) {
    this.stageRepLinkDAO = stageRepLinkDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonAddHistoryDAO(StagePersonAddHistoryDAO stagePersonAddHistoryDAO) {
    this.stagePersonAddHistoryDAO = stagePersonAddHistoryDAO;
  }  
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setPersonHomeRemovalDAO(PersonHomeRemovalDAO personHomeRemovalDAO) {
    this.personHomeRemovalDAO = personHomeRemovalDAO;
  }

  // remove - not used anymore
  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }

  public void setReferralPersonLinkDAO(ReferralPersonLinkDAO referralPersonLinkDAO) {
    this.referralPersonLinkDAO = referralPersonLinkDAO;
  }

  public void setTribalDAO(TribalDAO tribalDAO) {
    this.tribalDAO = tribalDAO;
  }

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }
  
  public void setSafetyResourceDAO(SafetyResourceDAO safetyResourceDAO) {
    this.safetyResourceDAO = safetyResourceDAO;
  }

  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }

  public void setSrHouseholdMembersDAO(SrHouseholdMembersDAO srHouseholdMembersDAO) {
    this.srHouseholdMembersDAO = srHouseholdMembersDAO;
  }
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }
    
  public CINV04SO retrievePersonDetail(CINV04SI cinv04si) throws ServiceException {

    CINV04SO cinv04so = new CINV04SO();
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    ArchInputStruct archInputStruct = cinv04si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    int idPerson = cinv04si.getUlIdPerson();
    int idStage = cinv04si.getUlIdStage();
    int idCase = cinv04si.getUlIdCase();

    // STGAP00017013: MR-095
    // Retrieve the Add Person to Active Stages section when the person is added to the system for the first time
    // This would be the only retrieve for the new person add; therefore, the remainder of this retrieve service
    // is moved to the else block below

    // Call the method to retrieve the active stages array when the person is added to the system for the first time
    if (idPerson == 0) {
      CINV04SO_ADD_PERSON_TO_STAGES_ARRAY cinv04so_add_person_to_stages_array = new CINV04SO_ADD_PERSON_TO_STAGES_ARRAY();
      cinv04so_add_person_to_stages_array = setStageToCINV04SOAddPersonToStagesArray(idCase, idStage, idPerson);
      cinv04so.setCINV04SO_ADD_PERSON_TO_STAGES_ARRAY(cinv04so_add_person_to_stages_array);
    } else { // End STGAP00017013: MR-095

      // cinv79d
      if (eventPersonLinkDAO.countByIdPerson(idPerson) > 0) {
        cinv04so.setBIndActiveEvent(ArchitectureConstants.Y);
      } else {
        cinv04so.setBIndActiveEvent(ArchitectureConstants.N);
      }

      String sysCdWinMode = cinv04si.getSzSysCdWinMode();
      // cinv39d
      StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(idPerson, idStage);

      if (!WINDOW_MODE_RELATE.equals(sysCdWinMode) && !PageModeConstants.INQUIRE.equals(sysCdWinMode)
          && !WINDOW_MODE_MNTN_PERSON.equals(sysCdWinMode)) {
        cinv04so.setBSysIndInStage(ArchitectureConstants.N);

        if (stagePersonLink != null) {
          cinv04so.setSzCdStagePersType(stagePersonLink.getCdStagePersType());
          cinv04so.setSzCdStagePersRole(stagePersonLink.getCdStagePersRole());
          cinv04so.setBIndStagePersReporter(stagePersonLink.getIndStagePersReporter());
          cinv04so.setBIndStagePersInLaw(stagePersonLink.getIndStagePersInLaw());// remove for GA
          cinv04so.setSzCdStagePersRelInt(stagePersonLink.getCdStagePersRelInt());
          cinv04so
                  .setUlIdStagePerson(stagePersonLink.getIdStagePersonLink() != null ? stagePersonLink
                                                                                                      .getIdStagePersonLink()
                                                                                    : 0);
          cinv04so.setTsLastUpdate(stagePersonLink.getDtLastUpdate());
          cinv04so.setSzCdStagePersSearchInd(stagePersonLink.getCdStagePersSearchInd());
          cinv04so.setBIndSafetyRsrc(stagePersonLink.getIndStagePersSftyResource());
          cinv04so.setSzCdSideOfFamily(stagePersonLink.getCdPersonSideOfFamily());
          cinv04so.setCdPKHouseholdMember(stagePersonLink.getCdPKHshdMember());
        }

      } else {
        if (stagePersonLink == null) {
          cinv04so.setBSysIndInStage(ArchitectureConstants.N);
        } else {
          cinv04so.setBSysIndInStage(ArchitectureConstants.Y);
          cinv04so.setSzCdStagePersType(stagePersonLink.getCdStagePersType());
          cinv04so.setSzCdStagePersRole(stagePersonLink.getCdStagePersRole());
          cinv04so.setBIndStagePersReporter(stagePersonLink.getIndStagePersReporter());
          cinv04so.setBIndStagePersInLaw(stagePersonLink.getIndStagePersInLaw());
          cinv04so.setSzCdStagePersRelInt(stagePersonLink.getCdStagePersRelInt());
          cinv04so
                  .setUlIdStagePerson(stagePersonLink.getIdStagePersonLink() != null ? stagePersonLink
                                                                                                      .getIdStagePersonLink()
                                                                                    : 0);
          cinv04so.setTsLastUpdate(stagePersonLink.getDtLastUpdate());
          cinv04so.setSzCdStagePersSearchInd(stagePersonLink.getCdStagePersSearchInd());
          cinv04so.setBIndSafetyRsrc(stagePersonLink.getIndStagePersSftyResource());
          cinv04so.setSzCdSideOfFamily(stagePersonLink.getCdPersonSideOfFamily());
          cinv04so.setCdPKHouseholdMember(stagePersonLink.getCdPKHshdMember());
        }
      }

      // STGAP00017013: MR-095
      // Get the stage closure date for use in JSP
      Date currentStageDateClosed = null;
      if (stagePersonLink != null) {
        currentStageDateClosed = stagePersonLink.getStage().getDtStageClose();
        cinv04so.setDtDtStageClose(DateHelper.toCastorDate(currentStageDateClosed));
      } else {
        currentStageDateClosed = null;
        cinv04so.setDtDtStageClose(DateHelper.toCastorDate(currentStageDateClosed));
      } 
      // End STGAP00017013: MR-095
      
      StageRepLink stageRepLink = stageRepLinkDAO.findStageRepLinkByIdPersonIdStage(idPerson, idStage);
      if (stageRepLink != null) {
        cinv04so.setDtDtLegRepAssigned(DateHelper.toCastorDate(stageRepLink.getDtRepStart()));
        cinv04so.setDtDtLegRepUnassigned(DateHelper.toCastorDate(stageRepLink.getDtRepEnd()));
      }

      // ccmn44d
      Person person = personDAO.findPersonByIdPerson(idPerson);
      if (person == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      cinv04so.setBIndPersonDobApprox(person.getIndPersonDobApprox());
      cinv04so.setSzCdPersonLivArr(person.getCdPersonLivArr());
      cinv04so.setSzCdPersGuardCnsrv(person.getCdPersGuardCnsrv());
      cinv04so.setSzCdPersonDeath(person.getCdPersonDeath());
      cinv04so.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
      cinv04so.setSzCdPersonLanguage(person.getCdPersonLanguage());
      cinv04so.setSzCdPersonMaritalStatus(person.getCdPersonMaritalStatus());
      cinv04so.setSzCdPersonReligion(person.getCdPersonReligion());
      cinv04so.setCCdPersonSex(person.getCdPersonSex());
      cinv04so.setSzCdDisasterRlf(person.getCdDisasterRlf());
      cinv04so.setCdPersonStatus(person.getCdPersonStatus());
      cinv04so.setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
      cinv04so.setDtDtPersonDeath(DateHelper.toCastorDate(person.getDtPersonDeath()));
      cinv04so.setSzNbrPersonSSN(person.getNbrPersonIdNumber());
      cinv04so.setLNbrPersonAge(person.getNbrPersonAge() != null ? person.getNbrPersonAge() : 0);
      cinv04so.setSzNmPersonFull(person.getNmPersonFull());
      cinv04so.setSzTxtOccupation(person.getTxtPersonOccupation());
      cinv04so.setTsSysTsLastUpdate2(person.getDtLastUpdate());
      cinv04so.setBCdPersonChar(person.getCdPersonChar());
      cinv04so.setSzCdTitle(person.getCdPersonTitle());

      if (person.getTxtPersonOtherRelationships() == null) {
        cinv04so.setSzTxtOtherRelationshipsCmnts(EMPTY_STRING);
      } else {
        cinv04so.setSzTxtOtherRelationshipsCmnts(person.getTxtPersonOtherRelationships());
      }
      if (person.getTxtPersonAddlCmnts() == null) {
        cinv04so.setSzTxtAddlCmnts(EMPTY_STRING);
      } else {
        cinv04so.setSzTxtAddlCmnts(person.getTxtPersonAddlCmnts());
      }

      // PersonDtlDAO - 'Birth Information section'
      PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(idPerson);
      cinv04so.setLQtyPersonWeight(0);
      cinv04so.setSQtyPersonHeightFeet(0);
      cinv04so.setSQtyPersonHeightInches(0);

      if (personDtl == null) {
        cinv04so.setSzTxtMaidenName(EMPTY_STRING);
        cinv04so.setSzCdPersonEyeColor(EMPTY_STRING);
        cinv04so.setSzCdPersonHairColor(EMPTY_STRING);
        cinv04so.setSzCdPersonHighestEduc(EMPTY_STRING);
        cinv04so.setBIndVerified(EMPTY_STRING);
        cinv04so.setBIndRsrcHouseholdMember(EMPTY_STRING);
        cinv04so.setBIndPaternityEst(EMPTY_STRING);
        cinv04so.setBIndLegalCust(EMPTY_STRING);
        cinv04so.setSzTxtEmail(EMPTY_STRING); // MR-067
        // Person Characteristics: SSI related question for child under 18
        cinv04so.setCIndSsiAppSubmitted(EMPTY_STRING);
        cinv04so.setCIndSsiMedDsbltyReqMet(EMPTY_STRING);
        cinv04so.setCIndSsiRecipient(EMPTY_STRING);
        cinv04so.setCIndSsiDfcsPayee(EMPTY_STRING);
      } else {
        cinv04so.setSzTxtMaidenName(personDtl.getNmPersonMaidenName());

        if (personDtl.getQtyPersonWeight() != null) {
          cinv04so.setLQtyPersonWeight(personDtl.getQtyPersonWeight());
        }

        if (personDtl.getQtyPersonHeightFeet() != null) {
          cinv04so.setSQtyPersonHeightFeet(personDtl.getQtyPersonHeightFeet());
        }

        if (personDtl.getQtyPersonHeightInches() != null) {
          cinv04so.setSQtyPersonHeightInches(personDtl.getQtyPersonHeightInches());
        }

        cinv04so.setSzCdPersonEyeColor(personDtl.getCdPersonEyeColor());
        cinv04so.setSzCdPersonHairColor(personDtl.getCdPersonHairColor());
        cinv04so.setSzCdPersonHighestEduc(personDtl.getCdPersonHighestEduc());
        cinv04so.setBIndVerified(personDtl.getIndPersonVerified());
        cinv04so.setBIndRsrcHouseholdMember(personDtl.getIndPersonRsrcHshdMember());
        cinv04so.setBIndPaternityEst(personDtl.getIndPersonPaternityEst());
        cinv04so.setBIndLegalCust(personDtl.getIndLegalCustody());
        cinv04so.setSzTxtEmail(personDtl.getTxtPersonDtlEmail()); // MR-067
        // Person Characteristics: SSI related question for child under 18
        cinv04so.setCIndSsiAppSubmitted(personDtl.getIndSsiAppSubmitted());
        cinv04so.setCIndSsiMedDsbltyReqMet(personDtl.getIndSsiMedDsbltyReqMet());
        cinv04so.setCIndSsiRecipient(personDtl.getIndSsiRecipient());
        cinv04so.setCIndSsiDfcsPayee(personDtl.getIndSsiDfcsPayee());
      }

      Tribal tribal = tribalDAO.findTribalByIdPerson(idPerson);

      if (tribal == null) {
        // default values when no tribal data exists for this person
        cinv04so.setSzTxtPercentHeritage(EMPTY_STRING);
        cinv04so.setSzTxtTribalName(EMPTY_STRING);
        cinv04so.setSzTxtTribalRegistryNumber(EMPTY_STRING);
        cinv04so.setBScrIndTribalMember(UNKNOWN);
        cinv04so.setBScrIndRegisteredWithTribe(UNKNOWN);
      } else {

        if (tribal.getNbrTrblPercentHeritage() == null || tribal.getNbrTrblPercentHeritage() == 0) {
          cinv04so.setSzTxtPercentHeritage(EMPTY_STRING);
        } else {
          cinv04so.setSzTxtPercentHeritage(String.valueOf(tribal.getNbrTrblPercentHeritage()));
        }

        cinv04so.setSzTxtTribalName(tribal.getTxtTribalName());

        if (tribal.getNbrTribalRegistry() == null || tribal.getNbrTribalRegistry() == "") {
          cinv04so.setSzTxtTribalRegistryNumber(EMPTY_STRING);
        } else {
          cinv04so.setSzTxtTribalRegistryNumber(StringHelper.getSafeString(tribal.getNbrTribalRegistry()));
        }

        cinv04so.setBScrIndTribalMember(tribal.getIndTrblMember());
        cinv04so.setBScrIndRegisteredWithTribe(tribal.getIndTrblRegistered());
      }

      // This will contain the one row from the relationship
      // table that has been previously selected as the seconary caregiver.
      // The entry from the relationship table should be highlighted on the page as the current caregiver
      // in the dropdown.

      int idRelatePersonSecondaryCaregiver = (Integer) relationshipDAO
                                                                      .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                 idPerson,
                                                                                                                 SECONDARY_CAREGIVER) != null ? (Integer) relationshipDAO
                                                                                                                                                                         .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                                    idPerson,
                                                                                                                                                                                                                    SECONDARY_CAREGIVER)
                                                                                                                                             : 0;

      cinv04so.setUlIdSecondaryCareGiver(idRelatePersonSecondaryCaregiver);

      int idRelatePersonPutativeFather = (Integer) relationshipDAO
                                                                  .findRelationshipIdRelatedPersonByIdPerson(idPerson,
                                                                                                             PUTATIVE_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                                 .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                            idPerson,
                                                                                                                                                                                                            PUTATIVE_FATHER)
                                                                                                                                     : 0;

      cinv04so.setUlIdPutativeFather(idRelatePersonPutativeFather);

      int idRelatePersonLegalFather = (Integer) relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idPerson,
                                                                                                          LEGAL_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                           .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                      idPerson,
                                                                                                                                                                                                      LEGAL_FATHER)
                                                                                                                               : 0;

      cinv04so.setUlIdLegalFather(idRelatePersonLegalFather);

      int idRelatePersonBiologicalFather = (Integer) relationshipDAO
                                                                    .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                               idPerson,
                                                                                                               BIOLOGICAL_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                                     .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                                idPerson,
                                                                                                                                                                                                                BIOLOGICAL_FATHER)
                                                                                                                                         : 0;

      cinv04so.setUlIdBioFather(idRelatePersonBiologicalFather);

      // STGAP00015485: Get the mothers.

      int idRelatePersonLegalMother = (Integer) relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idPerson,
                                                                                                          LEGAL_MOTHER) != null ? (Integer) relationshipDAO
                                                                                                                                                           .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                      idPerson,
                                                                                                                                                                                                      LEGAL_MOTHER)
                                                                                                                               : 0;

      cinv04so.setUlIdLegalMother(idRelatePersonLegalMother);

      int idRelatePersonBiologicalMother = (Integer) relationshipDAO
                                                                    .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                               idPerson,
                                                                                                               BIOLOGICAL_MOTHER) != null ? (Integer) relationshipDAO
                                                                                                                                                                     .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                                idPerson,
                                                                                                                                                                                                                BIOLOGICAL_MOTHER)
                                                                                                                                         : 0;

      cinv04so.setUlIdBioMother(idRelatePersonBiologicalMother);

      // STGAP00015485: Get the secondary caregivers. All the principals who are 18 or over 18 years of age
      // MR-062 Updated this code block for caregivers to ensure that defined caregivers show up regardless if they
      // are in the stage or not.
      List<Map<String, Object>> relationshipList = stagePersonLinkDAO.findSecondaryCaregiverByIdStage(idStage);
      boolean foundCaregiver = false;
      CINV04SO_OTHER_RELATIONSHIP_ARRAY cinv04soOtherRelationship_array = new CINV04SO_OTHER_RELATIONSHIP_ARRAY();
      if (relationshipList != null && !relationshipList.isEmpty()) {
        if (relationshipList.size() > 50) {
          relationshipList = relationshipList.subList(0, 49);
        }

        for (Iterator<Map<String, Object>> it = relationshipList.iterator(); it.hasNext();) {
          Map<String, Object> row = it.next();
          CINV04SO_OTHER_RELATIONSHIP otherRelationship = new CINV04SO_OTHER_RELATIONSHIP();
          otherRelationship.setUlIdPerson((Integer) row.get("idPerson") != null ? (Integer) row.get("idPerson") : 0);
          otherRelationship.setSzNmPersonFull((String) row.get("nmPersonFull"));
          otherRelationship.setSzCdStagePersRelInt((String) row.get("cdStagePersRelInt"));

          if (idRelatePersonSecondaryCaregiver != 0
              && otherRelationship.getUlIdPerson() == idRelatePersonSecondaryCaregiver) {
            foundCaregiver = true;
          }
          cinv04soOtherRelationship_array.addCINV04SO_OTHER_RELATIONSHIP(otherRelationship);
        }
      }
      // If the caregiver was not found in the query then add the person to the array so
      // they will be displayed regardless of where the Person Detail record is viewed
      // (i.e. in a stage, from a search, etc.)
      if (!foundCaregiver && idRelatePersonSecondaryCaregiver != 0) {
        CINV04SO_OTHER_RELATIONSHIP otherRelationship = new CINV04SO_OTHER_RELATIONSHIP();
        otherRelationship.setUlIdPerson(idRelatePersonSecondaryCaregiver);
        otherRelationship.setSzNmPersonFull(personDAO.findPersonByIdPerson(idRelatePersonSecondaryCaregiver)
                                                     .getNmPersonFull());
        cinv04soOtherRelationship_array.addCINV04SO_OTHER_RELATIONSHIP(otherRelationship);
      }

      cinv04so.setCINV04SO_OTHER_RELATIONSHIP_ARRAY(cinv04soOtherRelationship_array);

      // STGAP00015485: Get the mothers. All the principals who are 18 or over 18 years of age and gender as female
      // MR-062 Updated this code block for mothers to ensure that defined mothers show up regardless if they
      // are in the stage or not.
      List<Map<String, Object>> relationshipMotherList = stagePersonLinkDAO
                                                                           .findFathersMothersByIdStageByCdPersonSex(
                                                                                                                     idStage,
                                                                                                                     CodesTables.CSEX_F);
      boolean foundLegalMother = false;
      boolean foundBioMother = false;
      CINV04SO_MOTHER_RELATIONSHIP_ARRAY cinv04soMotherRelationship_array = new CINV04SO_MOTHER_RELATIONSHIP_ARRAY();
      if (relationshipMotherList != null && !relationshipMotherList.isEmpty()) {
        if (relationshipMotherList.size() > 50) {
          relationshipMotherList = relationshipMotherList.subList(0, 49);
        }
        for (Iterator<Map<String, Object>> it = relationshipMotherList.iterator(); it.hasNext();) {
          Map<String, Object> row = it.next();
          CINV04SO_MOTHER_RELATIONSHIP motherRelationship = new CINV04SO_MOTHER_RELATIONSHIP();
          motherRelationship.setUlIdPerson((Integer) row.get("idPerson") != null ? (Integer) row.get("idPerson") : 0);
          motherRelationship.setSzNmPersonFull((String) row.get("nmPersonFull"));
          motherRelationship.setSzCdStagePersRelInt((String) row.get("cdStagePersRelInt"));

          if (idRelatePersonLegalMother != 0 && motherRelationship.getUlIdPerson() == idRelatePersonLegalMother) {
            foundLegalMother = true;
          }
          if (idRelatePersonBiologicalMother != 0
              && motherRelationship.getUlIdPerson() == idRelatePersonBiologicalMother) {
            foundBioMother = true;
          }
          cinv04soMotherRelationship_array.addCINV04SO_MOTHER_RELATIONSHIP(motherRelationship);
        }
      }

      if (!foundLegalMother && idRelatePersonLegalMother != 0) {
        CINV04SO_MOTHER_RELATIONSHIP motherRelationship = new CINV04SO_MOTHER_RELATIONSHIP();
        motherRelationship.setUlIdPerson(idRelatePersonLegalMother);
        motherRelationship.setSzNmPersonFull(personDAO.findPersonByIdPerson(idRelatePersonLegalMother)
                                                      .getNmPersonFull());
        cinv04soMotherRelationship_array.addCINV04SO_MOTHER_RELATIONSHIP(motherRelationship);
      }

      if (!foundBioMother && idRelatePersonBiologicalMother != 0) {
        CINV04SO_MOTHER_RELATIONSHIP motherRelationship = new CINV04SO_MOTHER_RELATIONSHIP();
        motherRelationship.setUlIdPerson(idRelatePersonBiologicalMother);
        motherRelationship.setSzNmPersonFull(personDAO.findPersonByIdPerson(idRelatePersonBiologicalMother)
                                                      .getNmPersonFull());
        cinv04soMotherRelationship_array.addCINV04SO_MOTHER_RELATIONSHIP(motherRelationship);
      }
      cinv04so.setCINV04SO_MOTHER_RELATIONSHIP_ARRAY(cinv04soMotherRelationship_array);

      // STGAP00015485: Get the fathers. All the principals who are 18 or over 18 years of age and gender as male
      // MR-062 Updated this code block for fathers to ensure that defined fathers show up regardless if they
      // are in the stage or not.
      List<Map<String, Object>> relationshipFatherList = stagePersonLinkDAO
                                                                           .findFathersMothersByIdStageByCdPersonSex(
                                                                                                                     idStage,
                                                                                                                     CodesTables.CSEX_M);
      boolean foundLegalFather = false;
      boolean foundBioFather = false;
      boolean foundPutativeFather = false;
      CINV04SO_FATHER_RELATIONSHIP_ARRAY cinv04soFatherRelationship_array = new CINV04SO_FATHER_RELATIONSHIP_ARRAY();
      if (relationshipFatherList != null && !relationshipFatherList.isEmpty()) {
        if (relationshipFatherList.size() > 50) {
          relationshipFatherList = relationshipFatherList.subList(0, 49);
        }
        for (Iterator<Map<String, Object>> it = relationshipFatherList.iterator(); it.hasNext();) {
          Map<String, Object> row = it.next();
          CINV04SO_FATHER_RELATIONSHIP fatherRelationship = new CINV04SO_FATHER_RELATIONSHIP();
          fatherRelationship.setUlIdPerson((Integer) row.get("idPerson") != null ? (Integer) row.get("idPerson") : 0);
          fatherRelationship.setSzNmPersonFull((String) row.get("nmPersonFull"));
          fatherRelationship.setSzCdStagePersRelInt((String) row.get("cdStagePersRelInt"));

          if (idRelatePersonLegalFather != 0 && fatherRelationship.getUlIdPerson() == idRelatePersonLegalFather) {
            foundLegalFather = true;
          }
          if (idRelatePersonBiologicalFather != 0
              && fatherRelationship.getUlIdPerson() == idRelatePersonBiologicalFather) {
            foundBioFather = true;
          }
          if (idRelatePersonPutativeFather != 0 && fatherRelationship.getUlIdPerson() == idRelatePersonPutativeFather) {
            foundPutativeFather = true;
          }
          cinv04soFatherRelationship_array.addCINV04SO_FATHER_RELATIONSHIP(fatherRelationship);
        }
      }

      if (!foundLegalFather && idRelatePersonLegalFather != 0) {
        CINV04SO_FATHER_RELATIONSHIP fatherRelationship = new CINV04SO_FATHER_RELATIONSHIP();
        fatherRelationship.setUlIdPerson(idRelatePersonLegalFather);
        fatherRelationship.setSzNmPersonFull(personDAO.findPersonByIdPerson(idRelatePersonLegalFather)
                                                      .getNmPersonFull());
        cinv04soFatherRelationship_array.addCINV04SO_FATHER_RELATIONSHIP(fatherRelationship);
      }

      if (!foundBioFather && idRelatePersonBiologicalFather != 0) {
        CINV04SO_FATHER_RELATIONSHIP fatherRelationship = new CINV04SO_FATHER_RELATIONSHIP();
        fatherRelationship.setUlIdPerson(idRelatePersonBiologicalFather);
        fatherRelationship.setSzNmPersonFull(personDAO.findPersonByIdPerson(idRelatePersonBiologicalFather)
                                                      .getNmPersonFull());
        cinv04soFatherRelationship_array.addCINV04SO_FATHER_RELATIONSHIP(fatherRelationship);
      }

      if (!foundPutativeFather && idRelatePersonPutativeFather != 0) {
        CINV04SO_FATHER_RELATIONSHIP fatherRelationship = new CINV04SO_FATHER_RELATIONSHIP();
        fatherRelationship.setUlIdPerson(idRelatePersonPutativeFather);
        fatherRelationship.setSzNmPersonFull(personDAO.findPersonByIdPerson(idRelatePersonPutativeFather)
                                                      .getNmPersonFull());
        cinv04soFatherRelationship_array.addCINV04SO_FATHER_RELATIONSHIP(fatherRelationship);
      }

      cinv04so.setCINV04SO_FATHER_RELATIONSHIP_ARRAY(cinv04soFatherRelationship_array);

      // clss79d
      List<PersonRace> personRaceList = personRaceDAO.findPersonRaceByIdPerson(idPerson);
      CINV04SOG03_ARRAY cinv04sog03_array = new CINV04SOG03_ARRAY();
      if (personRaceList != null && !personRaceList.isEmpty()) {
        for (Iterator<PersonRace> it = personRaceList.iterator(); it.hasNext();) {
          PersonRace row = it.next();
          CINV04SOG03 cinv04sog03 = new CINV04SOG03();
          cinv04sog03.setSzCdPersonRace(row.getCdRace());
          cinv04sog03_array.addCINV04SOG03(cinv04sog03);
        }
      }
      cinv04so.setCINV04SOG03_ARRAY(cinv04sog03_array);

      // clss80d
      List<PersonEthnicity> personEthnicityList = personEthnicityDAO.findPersonEthnicityByIdPerson(idPerson);
      CINV04SOG04_ARRAY cinv04sog04_array = new CINV04SOG04_ARRAY();
      if (personEthnicityList != null && !personEthnicityList.isEmpty()) {
        Iterator<PersonEthnicity> it = personEthnicityList.iterator();
        int personEthnicitySize = 0;
        while (it.hasNext()) {
          personEthnicitySize++;
          PersonEthnicity row = it.next();
          if (personEthnicitySize < 10) {
            if (row != null) {
              CINV04SOG04 cinv04sog04 = new CINV04SOG04();
              cinv04sog04.setSzCdPersonEthnicity(row.getCdEthnicity());
              cinv04sog04_array.addCINV04SOG04(cinv04sog04);
            }
          }
        }
      }
      cinv04so.setCINV04SOG04_ARRAY(cinv04sog04_array);

      // cinv29d
      PaginatedHibernateList<PersonCategory> personCategoryList = personCategoryDAO
                                                                                   .findPersonCategoryByIdPerson(
                                                                                                                 idPerson,
                                                                                                                 pageNbr,
                                                                                                                 pageSize);
      if (personCategoryList != null && !personCategoryList.isEmpty()) {
        CINV04SOGOO_ARRAY cinv04sogoo_array = new CINV04SOGOO_ARRAY();

        for (Iterator<PersonCategory> it = personCategoryList.iterator(); it.hasNext();) {
          PersonCategory row = it.next();
          CINV04SOGOO cinv04sogoo = new CINV04SOGOO();
          cinv04sogoo.setSzCdCategoryCategory(row.getCdPersonCategory());
          cinv04sogoo_array.addCINV04SOGOO(cinv04sogoo);
        }
        cinv04so.setCINV04SOGOO_ARRAY(cinv04sogoo_array);
      } else {
        CINV04SOGOO_ARRAY cinv04sogoo_array = new CINV04SOGOO_ARRAY();
        cinv04so.setCINV04SOGOO_ARRAY(cinv04sogoo_array);
      }

      // STGAP00017013: MR-095
      // Logic for Add Person to Active Stages section
      // The section displays any active INV, DIV, ONG, FCC, FCF, PFC and ADO stages
      // where the person has not been added/related to the stage_person_link
      // within the same case except the current stage
      
      // Array cinv04so_add_person_to_stages_array for displaying active stages should not include any closed stage
      if ((currentStageDateClosed == null) && !DateHelper.MAX_JAVA_DATE.equals(currentStageDateClosed)) {

        CINV04SO_ADD_PERSON_TO_STAGES_ARRAY cinv04so_add_person_to_stages_array = new CINV04SO_ADD_PERSON_TO_STAGES_ARRAY();
        cinv04so_add_person_to_stages_array = setStageToCINV04SOAddPersonToStagesArray(idCase, idStage, idPerson);
        cinv04so.setCINV04SO_ADD_PERSON_TO_STAGES_ARRAY(cinv04so_add_person_to_stages_array);
      }

      // Find Stages in the same Case where the same Person has been added or related 
      // via the Add Person to Active Stages section
      // This means that the record is stored in the stage_person_add_history table
      List<StagePersonAddHistory> histricalStageList = stagePersonAddHistoryDAO
                                                                               .findStagePersonAddHistorybyIdStageIdPerson(
                                                                                                                           idStage,
                                                                                                                           idPerson);

      if (histricalStageList != null && !histricalStageList.isEmpty()) {
        CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY cinv04so_add_person_to_stages_history_array = new CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY();
        Iterator<StagePersonAddHistory> it = histricalStageList.iterator();

        while (it.hasNext()) {
          StagePersonAddHistory rowHistory = it.next();
          CINV04SO_ADD_PERSON_TO_STAGES_HISTORY cinv05so_add_person_to_stages_history = new CINV04SO_ADD_PERSON_TO_STAGES_HISTORY();

          cinv05so_add_person_to_stages_history
                                               .setUlIdStage((Integer) rowHistory.getStageByIdToStage().getIdStage() != null ? (Integer) rowHistory
                                                                                                                                                   .getStageByIdToStage()
                                                                                                                                                   .getIdStage()
                                                                                                                            : 0);
          cinv05so_add_person_to_stages_history.setSzNmStage(rowHistory.getStageByIdToStage().getNmStage());
          cinv05so_add_person_to_stages_history.setSzCdStage(rowHistory.getStageByIdToStage().getCdStage());
          cinv05so_add_person_to_stages_history.setSzCdStagePersType(rowHistory.getCdStagePersType());
          cinv05so_add_person_to_stages_history.setSzCdStagePersRelInt(rowHistory.getCdStagePersRelInt());
          cinv05so_add_person_to_stages_history.setDtDtAdded(DateHelper.toCastorDate(rowHistory.getDtAdded()));
          cinv04so_add_person_to_stages_history_array
                                                     .addCINV04SO_ADD_PERSON_TO_STAGES_HISTORY(cinv05so_add_person_to_stages_history);
        }
        cinv04so.setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY(cinv04so_add_person_to_stages_history_array);
      } else {
        CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY cinv04so_add_person_to_stages_history_array = new CINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY();
        cinv04so.setCINV04SO_ADD_PERSON_TO_STAGES_HISTORY_ARRAY(cinv04so_add_person_to_stages_history_array);
      }
      // End STGAP00017013: MR-095

      // cinv33d
      PaginatedHibernateList<Map> stageAndStagePersonLinkMapList = stagePersonLinkDAO
                                                                                     .findStageAndStagePersonLinkByIdPerson(
                                                                                                                            idPerson,
                                                                                                                            PAGE_NBR,
                                                                                                                            PAGE_SIZE);

      if (stageAndStagePersonLinkMapList != null && !stageAndStagePersonLinkMapList.isEmpty()) {
        CINV04SG01_ARRAY cinv04sg01_array = new CINV04SG01_ARRAY();
        Iterator<Map> it = stageAndStagePersonLinkMapList.iterator();

        while (it.hasNext()) {
          Map row = it.next();
          CINV04SG01 cinv04sg01 = new CINV04SG01();
          cinv04sg01.setUlIdCase((Integer) row.get("idCase") != null ? (Integer) row.get("idCase") : 0);
          cinv04sg01.setUlIdStage((Integer) row.get("idStage") != null ? (Integer) row.get("idStage") : 0);
          cinv04sg01.setSzCdStageProgram((String) row.get("cdStageProgram"));
          cinv04sg01_array.addCINV04SG01(cinv04sg01);
        }
        cinv04so.setCINV04SG01_ARRAY(cinv04sg01_array);
      } else {
        CINV04SG01_ARRAY cinv04sg01_array = new CINV04SG01_ARRAY();
        cinv04so.setCINV04SG01_ARRAY(cinv04sg01_array);
      }

      // cinv52d
      List<Map> eventTypeEventStatusEventStageMapList = eventPersonLinkDAO
                                                                          .findEventTypeEventStatusEventStageByIdPerson(idPerson);
      if (eventTypeEventStatusEventStageMapList != null && !eventTypeEventStatusEventStageMapList.isEmpty()) {

        HashMap<String, String> eventMap = new HashMap<String, String>();

        CINV04SG02_ARRAY cinv04sg02_array = new CINV04SG02_ARRAY();

        for (Iterator<Map> it = eventTypeEventStatusEventStageMapList.iterator(); it.hasNext();) {
          Map row = it.next();
          String eventType = (String) row.get("cdEventType");
          String eventStatus = (String) row.get("cdEventStatus");
          String eventStage = (String) row.get("idEventStage").toString();

          String eventKey = eventType + "|" + eventStatus + "|" + eventStage;

          // 38666 checking to see if event type, event status, and event stage combination does not already
          // exists if it does then do not add it again. also assignment events for case managers are not
          // needed since they do not show up in the case events option
          if (!eventMap.containsKey(eventKey) && !CodesTables.CEVNTTYP_ASG.equals(eventType)) {

            CINV04SG02 cinv04sg02 = new CINV04SG02();
            cinv04sg02.setSzCdEventType(eventType);
            cinv04sg02.setSzCdEventStatus(eventStatus);
            cinv04sg02.setUlIdStage((Integer) row.get("idEventStage") != null ? (Integer) row.get("idEventStage") : 0);
            cinv04sg02_array.addCINV04SG02(cinv04sg02);
            eventMap.put(eventKey, eventKey);
          }
        }
        cinv04so.setCINV04SG02_ARRAY(cinv04sg02_array);
      } else {
        CINV04SG02_ARRAY cinv04sg02_array = new CINV04SG02_ARRAY();
        cinv04so.setCINV04SG02_ARRAY(cinv04sg02_array);
      }

      // ccmn40d
      Map nameAndPhoneticNameMap = nameDAO.findNameFromNameAndPhoneticNameByIdPerson(idPerson);
      if (nameAndPhoneticNameMap != null && !nameAndPhoneticNameMap.isEmpty()) {
        cinv04so.setSzNmNameFirst((String) nameAndPhoneticNameMap.get("nmNameFirst"));
        cinv04so.setSzNmNameLast((String) nameAndPhoneticNameMap.get("nmNameLast"));
        cinv04so.setSzNmNameMiddle((String) nameAndPhoneticNameMap.get("nmNameMiddle"));
        cinv04so.setSzCdNameSuffix((String) nameAndPhoneticNameMap.get("cdNameSuffix"));
      }

      // cses46d
      PersonHomeRemoval personHomeRemoval = personHomeRemovalDAO.findPersonHmRemovByIdPersonIdCase(idPerson, idCase);
      if (personHomeRemoval == null) {
        cinv04so.setCSysIndHomeRemovePers(ArchitectureConstants.N);
      } else {
        cinv04so.setCSysIndHomeRemovePers(ArchitectureConstants.Y);
      }

      // cses47d
      ReferralPersonLink referralPersonLink = referralPersonLinkDAO.findReferralPersonLinkByIdPerson(idPerson);
      if (referralPersonLink == null) {
        cinv04so.setCSysIndPersReferPresent(ArchitectureConstants.N);
      } else {
        cinv04so.setCSysIndPersReferPresent(ArchitectureConstants.Y);
      }

      BIndBLOBExistsInDatabase_ARRAY blob_array = new BIndBLOBExistsInDatabase_ARRAY();
      // cdyn25d
      if (commonDAO.countRowsByIdEvent(idPerson, INITIAL_DEATH_TABLE) > 0) {
        blob_array.addBIndBLOBExistsInDatabase(INITIAL_DOC_INDEX, ArchitectureConstants.Y);
      } else {
        blob_array.addBIndBLOBExistsInDatabase(INITIAL_DOC_INDEX, ArchitectureConstants.N);
      }

      // cdyn25d
      if (commonDAO.countRowsByIdEvent(idPerson, COMMITTEE_DEATH_TABLE) > 0) {
        blob_array.addBIndBLOBExistsInDatabase(COMMITTEE_DOC_INDEX, ArchitectureConstants.Y);
      } else {
        blob_array.addBIndBLOBExistsInDatabase(COMMITTEE_DOC_INDEX, ArchitectureConstants.N);
      }
      cinv04so.setBIndBLOBExistsInDatabase_ARRAY(blob_array);

      int findIdStageByIdVictim = allegationDAO.findIdStageByIdVictim(idStage, idPerson) != null ? allegationDAO
                                                                                                                .findIdStageByIdVictim(
                                                                                                                                       idStage,
                                                                                                                                       idPerson)
                                                                                                : 0;

      // cinvb5d
      if (findIdStageByIdVictim == 0) {
        cinv04so.setCScrIndDupAlleg(ArchitectureConstants.N);
      } else {
        cinv04so.setCScrIndDupAlleg(ArchitectureConstants.Y);
      }

      // check to see if person is a safety resource in this case
      long safetyCnt = 0;
      safetyCnt = srHouseholdMembersDAO.countSafetyHouseholdForCase(idPerson, idCase);
      safetyCnt += safetyResourceChildDAO.countSafetyResourceChildForCase(idPerson, idCase);
      safetyCnt += safetyResourceDAO.countSafetyResourceForCase(idPerson, idCase);
      if (safetyCnt == 0) {
        cinv04so.setBIndSafetyRsrcCase(ArchitectureConstants.N);
      } else {
        cinv04so.setBIndSafetyRsrcCase(ArchitectureConstants.Y);
      }
    }
    
    cinv04so.setArchOutputStruct(archOutputStruct);
    return cinv04so;

  }

  // STGAP00017013: MR-095
  // Set CINV04SO_ADD_PERSON_TO_STAGES_ARRAY object for displaying Add Person to Active Stages section
  private CINV04SO_ADD_PERSON_TO_STAGES_ARRAY setStageToCINV04SOAddPersonToStagesArray(int idCase, int idStage,
                                                                                       int idPerson) {

    // Logic for Add Person to Active Stages section
    // The section displays any active INV, DIV, ONG, FCC, FCF, PFC and ADO stages
    // where the person has not been added/related to the stage_person_link
    // within the same case except the current stage
    List<String> cdStages = new ArrayList<String>();
    cdStages.add(CodesTables.CTXTOGA_INV);
    cdStages.add(CodesTables.CTXTOGA_DIV);
    cdStages.add(CodesTables.CTXTOGA_FPR);
    cdStages.add(CodesTables.CTXTOGA_SUB);
    cdStages.add(CodesTables.CTXTOGA_FSU);
    cdStages.add(CodesTables.CTXTOGA_PFC);
    cdStages.add(CodesTables.CTXTOGA_ADO);

    // Find open Stages in the same Case where the Person is not included the SPL except the idStage
    List<Stage> activeStageList = stageDAO.findOpenStagesByIdCaseByIdPersonNotExistsInSPL(idCase, idStage, idPerson,
                                                                                          cdStages);

    if (activeStageList != null && !activeStageList.isEmpty()) {
      CINV04SO_ADD_PERSON_TO_STAGES_ARRAY cinv04so_add_person_to_stages_array = new CINV04SO_ADD_PERSON_TO_STAGES_ARRAY();
      Iterator<Stage> it = activeStageList.iterator();

      int i = 1;
      while (it.hasNext()) {
        Stage row = it.next();
        CINV04SO_ADD_PERSON_TO_STAGES cinv05so_add_person_to_stages = new CINV04SO_ADD_PERSON_TO_STAGES();

        cinv05so_add_person_to_stages.setUlIdStage((Integer) row.getIdStage() != null ? (Integer) row.getIdStage() : 0);
        cinv05so_add_person_to_stages.setSzNmStage(row.getNmStage());
        cinv05so_add_person_to_stages.setSzCdStage(row.getCdStage());
        cinv04so_add_person_to_stages_array.addCINV04SO_ADD_PERSON_TO_STAGES(cinv05so_add_person_to_stages);
        // Set the size of the array in here for the use in the JSP
        cinv04so_add_person_to_stages_array.setUlRowQty(i);
        i++;
      }
      return cinv04so_add_person_to_stages_array;
    } else {
      CINV04SO_ADD_PERSON_TO_STAGES_ARRAY cinv04so_add_person_to_stages_array = new CINV04SO_ADD_PERSON_TO_STAGES_ARRAY();
      return cinv04so_add_person_to_stages_array;
    }
  }  
}
