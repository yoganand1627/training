package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCitizenshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonAddHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageRepLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TribalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCitizenship;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.StageRepLink;
import gov.georgia.dhr.dfcs.sacwis.db.Tribal;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**Change History:
*    Date        User              Description
*    --------    ----------------  --------------------------------------------------
*   06/24/2009   bgehlot           STGAP00014329: Added indPKHouseholdMember parameter in method insertPersonStagePersonLinkAndPersonCategory
*                                   and updatePersonAndStagePersonLink and updateWindowModeLower
*   09/30/2009   bgehlot           STGAP00015485: Added Legal mother, and biological mother parameters in method insertPersonStagePersonLinkAndPersonCategory
*                                  and updatePersonAndStagePersonLink and updateWindowModeLower,  Added cdPKHouseholdMember in insertPerson and updatePerson method
*   02/08/2010   mxpatel           CAPTA: Added code to add and/or update to stage_rep_link table if the relationship is CASA/GAL or Atty/Gua Ad Litem   
*   05/25/2010   mxpatel           SMS#50561: added code to delete from Relationship table when a person is deleted 
*   06/04/2010   mxpatel           MR-066.1:  added code to capture and store SSN number when adding a new person.
*   08/18/2010   bgehlot           SMS 66380 MR-072 Changes
*   08/29/2010   htvo			   MR-067: added new field email to insertPersonStagePersonLinkAndPersonCategory, updatePersonAndStagePersonLink,
*   							   updateWindowModeLower                           
*   09/07/2011   schoi             STGAP00017013: MR-095 Added insertPersonAddedFromAddPersonToActiveStages method to insert stage person link record 
*                                  to the database when the person record is added via the Add Person to Active Stages section on the Person Detail page
*                                                                        
*/

public class ComplexPersonDAOImpl extends BaseDAOImpl implements ComplexPersonDAO {
  private CommonDAO commonDAO = null;

  private PersonCitizenshipDAO personCitizenshipDAO = null;

  private PersonDAO personDAO = null;
  
  private PersonIdDAO personIdDAO = null;
  
  private PersonDtlDAO personDtlDAO = null;

  private IncomingPersonDAO incomingPersonDAO = null;
  
  private StagePersonAddHistoryDAO stagePersonAddHistoryDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private EmployeeDAO employeeDAO = null;

  private PersonMergeDAO personMergeDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private RelationshipDAO relationshipDAO = null;
  
  private StageRepLinkDAO stageRepLinkDAO = null;

  private TribalDAO tribalDAO = null;

  private static final String LT_PRINCIPLE = "PRN";

  private static final String LT_UNKNOWN = "Unknown";

  private static final String SECONDARY_CAREGIVER = "SC";

  private static final String PUTATIVE_FATHER = "PF";

  private static final String LEGAL_FATHER = "LF";

  private static final String BIOLOGICAL_FATHER = "BF";
  
  private static final String LEGAL_MOTHER = "LM";

  private static final String BIOLOGICAL_MOTHER = "BM";
  
  // STGAP00017013: MR-095
  private static final String NO_ROLE = "NO";
  // End STGAP00017013: MR-095
  
  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public void setPersonCitizenshipDAO(PersonCitizenshipDAO personCitizenshipDAO) {
    this.personCitizenshipDAO = personCitizenshipDAO;
  }

  public void setTribalDAO(TribalDAO tribalDAO) {
    this.tribalDAO = tribalDAO;
  }

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }
  
  public void setStagePersonAddHistoryDAO(StagePersonAddHistoryDAO stagePersonAddHistoryDAO) {
    this.stagePersonAddHistoryDAO = stagePersonAddHistoryDAO;
  }  
  
  public void setStageRepLinkDAO(StageRepLinkDAO stageRepLinkDAO) {
    this.stageRepLinkDAO = stageRepLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
 /* 
  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }
*/
  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setIncomingPersonDAO(IncomingPersonDAO incomingPersonDAO) {
    this.incomingPersonDAO = incomingPersonDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setPersonMergeDAO(PersonMergeDAO personMergeDAO) {
    this.personMergeDAO = personMergeDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public Map<String, Integer> insertPersonFromIncomingPerson(int idRelatedPerson, int idStage) {
    int idIncmgPerson = incomingPersonDAO.findIncomingPersonIdIncmgPerson(idRelatedPerson, idStage);
    int idPerson = commonDAO.getNextval("SEQ_PERSON");
    int rowsUpdated = personDAO.insertPerson(idPerson, idRelatedPerson, idStage);
    
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("idPerson", idPerson);
    map.put("idIncmgPerson", idIncmgPerson);
    if (rowsUpdated == 0) {
      return null;
    }
    
    
    return map;
  }
  
  

  public boolean deletePerson(int idPerson, String indDelPerson) {
    long stagePersLinkCount = stagePersonLinkDAO.countStagePersonLinksByIdPerson(idPerson);
    long eventPersLinkCount = eventPersonLinkDAO.countEventPersonLinksByIdPerson(idPerson);
    long employeeCount = employeeDAO.countEmployeesByIdPerson(idPerson);
    long persMergeCount = personMergeDAO.countPersonMergeForwardOrClosedByIdPerson(idPerson);

    // If a count was returned, add up all the four counts above to determine if the person is involved in any other
    // stages (besides intake) and events or is an employee. (If the link count is 0, then we know the person is not
    // involved in anything else.
    // Otherwise, the person has been linked to something else and cannot be deleted from the database).
    long linkCount = stagePersLinkCount + eventPersLinkCount + employeeCount + persMergeCount;

    // Set the deleteStatus flag to yes or no depending on the count.
    // Only if the count is 0, the person can be deleted; otherwise should not be deleted.
    // The deleteStatus indicator is a true/false indicator that shows
    // whether the delete operation is enabled(true) or disabled(false).
    boolean deleteStatus;
    if (linkCount > 0) {
      deleteStatus = false;
    } else if (ArchitectureConstants.Y.equals(indDelPerson)) {
      // If this method call is initiated from Person Detail (service CINV05S), the parameter indDelPerson
      // will be set to 'Y'
      deleteStatus = true;
      relationshipDAO.deleteRelationshipByIdPerson(idPerson);
      personDAO.deletePerson(idPerson);
    } else {
      deleteStatus = true;
      relationshipDAO.deleteRelationshipByIdPerson(idPerson);
      personDAO.deleteIntakePerson(idPerson);
    }
    return deleteStatus;
  }

  public int insertPerson(int nbrPersonAge, Date dtPersonBirth, Date dtPersonDeath, String personStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdDisasterRlf, String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String indPersonDobApprox, String cdStagePersRole, String cdStagePersType,
                          String cdStagePersSearchInd, String txtStagePersNotes, String cdStagePersRelInt,
                          String indStagePersReporter, int idStage, String indStagePersInLaw,
                          String cdStagePersLstSort, String cdCategoryCategory, String cdPersonTitle,
                          String cdMatchType, String cdPersonProofCitizenship, String indPersonUsCitizen,
                          String cdPersonImmigrationStatus, String cdPersonCountryOrigin,
                          String txtPersonOtherRelationships, int idSecondaryCareGiver, String cdPKHouseholdMember) {
    int idPerson = 0;//added citizenship info to method call for STGAP00002945
    idPerson = personDAO.insertPerson(nbrPersonAge, dtPersonBirth, dtPersonDeath, personStatus, cdPersonDeath,
                                      cdPersonMaritalStatus, cdPersonLanguage, cdDisasterRlf, cdPersonSex,
                                      nmPersonFull, cdPersonEthnicGroup, indPersonDobApprox, idPerson, cdPersonTitle,
                                      cdMatchType, cdPersonProofCitizenship, txtPersonOtherRelationships);
    
    if (idPerson == 0) {
      return idPerson;
    }
    
    personDtlDAO.insertPersonDtl(idPerson, cdPersonImmigrationStatus, indPersonUsCitizen, cdPersonCountryOrigin);
    
    
    if (StringHelper.isValid(cdPersonProofCitizenship)) {
      String cdCbx = "";                                                                                               

                                                                                                                       

                                    
      if (CodesTables.CPRFCTN_BRC.equals(cdPersonProofCitizenship)) {
          cdCbx = CodesTables.CCERTVER_CBC;// US Birth Certificate
      } else if (CodesTables.CPRFCTN_NTC.equals(cdPersonProofCitizenship)) {
          cdCbx = CodesTables.CCERTVER_NCF;// Naturalization
      } else if (CodesTables.CPRFCTN_USP.equals(cdPersonProofCitizenship)) {
          cdCbx = CodesTables.CPRFCTN_USP;// US Passport
      }                                                                                                                

                              

      Person person = (Person)getSession().load(Person.class, idPerson);
      
      PersonCitizenship personCitizenship = new PersonCitizenship();
      
      personCitizenship.setPerson(person);
      personCitizenship.setCdCbx(cdCbx);
      personCitizenship.setCdCbxCodeType(CodesTables.CCERTVER);
      personCitizenshipDAO.savePersonCitizenship(personCitizenship); 
  }
    
    int idStagePersonLink = stagePersonLinkDAO.insertStagePersonLink(cdStagePersRole, cdStagePersType,
                                                                     cdStagePersSearchInd, txtStagePersNotes,
                                                                     cdStagePersRelInt, indStagePersReporter, idStage,
                                                                     idPerson, indStagePersInLaw, cdStagePersLstSort,
                                                                     cdPKHouseholdMember);
    if (idStagePersonLink == 0) {
      return idStagePersonLink;
    }
    if (cdCategoryCategory != null && cdCategoryCategory.trim().length() != 0) {
      PersonCategory personCategory = new PersonCategory();
      personCategory.setCdPersonCategory(cdCategoryCategory);
      Person person = (Person) getSession().load(Person.class, idPerson);
      personCategory.setPerson(person);
      personCategoryDAO.savePersonCategory(personCategory);
    }
    // secondary caregiver
    int ulIdRelationshipSecondaryCaregiver = (Integer) relationshipDAO
                                                                      .findRelationshipIdRelationship(idPerson,
                                                                                                      SECONDARY_CAREGIVER) != null ? (Integer) relationshipDAO
                                                                                                                                                              .findRelationshipIdRelationship(
                                                                                                                                                                                              idPerson,
                                                                                                                                                                                              SECONDARY_CAREGIVER)
                                                                                                                                  : 0;
    if (idSecondaryCareGiver > 0) // add a secondary care giver relationship only if there is a second care give
    // selected
    {
      if (0 == relationshipDAO.saveRelationship(ulIdRelationshipSecondaryCaregiver, idPerson, idSecondaryCareGiver,
                                                SECONDARY_CAREGIVER)) {

      }
    }
    return idPerson;
  }

  public void updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonDeath,
                           String cdPersonMaritalStatus, String cdPersonLanguage, String cdDisasterRlf,
                           String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                           String indPersonDobApprox, String indPersCancelHist, int idPerson, String cdStagePersRole,
                           String cdStagePersType, String cdStagePersSearchInd, String cdStagePersRelInt,
                           String indStagePersReporter, String indStagePersInLaw, int idStagePersonLink,
                           String txtStagePersNotes, String cdStagePersLstSort, int idStage, String cdPersonTitle,
                           String cdMatchType, String cdPersonProofCitizenship, String indPersonUsCitizen,
                           String cdPersonImmigrationStatus, String cdPersonBirthCountry,
                           String txtPersonOtherRelationships, int idSecondaryCareGiver, String cdPKHouseholdMember) {
    int rows = 0;
    rows = personDAO.updatePerson(nbrPersonAge, dtPersonDeath, dtPersonBirth, cdPersonDeath, cdPersonMaritalStatus,
                                  cdPersonLanguage, cdDisasterRlf, cdPersonSex, nmPersonFull, cdPersonEthnicGroup,
                                  indPersonDobApprox, indPersCancelHist, idPerson, cdPersonTitle, cdMatchType,
                                  cdPersonProofCitizenship, txtPersonOtherRelationships);
    if (rows == 0) {
      return;
    }
 
    Person person = personDAO.findPersonByIdPerson(idPerson);

    int personDtlExist = (Integer) personDtlDAO.findIdPersonDtlByIdPerson(idPerson) != null ? personDtlDAO
                                                                                                          .findIdPersonDtlByIdPerson(idPerson)
                                                                                           : 0;
    if (personDtlExist != 0) {
      personDtlDAO.updatePersonDtl(idPerson, cdPersonImmigrationStatus, indPersonUsCitizen, cdPersonBirthCountry);
    } else {
      personDtlDAO.insertPersonDtl(idPerson, cdPersonImmigrationStatus, indPersonUsCitizen, cdPersonBirthCountry);
    }

    //PersonCitizenship personCitizenship = new PersonCitizenship();
    int personCitizenshipExist = (Integer) personCitizenshipDAO.findPersonCitizenshipIdentityByIdPerson(idPerson) != null ? personCitizenshipDAO
                                                                                                                                                .findPersonCitizenshipIdentityByIdPerson(idPerson)
                                                                                                                         : 0;
//    if (personCitizenshipExist != 0) {
//      personCitizenship = (PersonCitizenship) (PersonCitizenship) getSession().load(PersonCitizenship.class, idPerson);
//    } else {
//      personCitizenship.setPerson(person);
//    }
//
//    if (CodesTables.CPRFCTN_BRC.equals(cdPersonProofCitizenship)) {
//      personCitizenship.setCdCbx(CodesTables.CCERTVER_CBC);// US Birth Certificate
//    } else if (CodesTables.CPRFCTN_NTC.equals(cdPersonProofCitizenship)) {
//      personCitizenship.setCdCbx(CodesTables.CCERTVER_NCF);// Naturalization
//    } else if (CodesTables.CPRFCTN_USP.equals(cdPersonProofCitizenship)) {
//      personCitizenship.setCdCbx(CodesTables.CPRFCTN_USP);// US Passport
//    }
//
//    personCitizenship.setCdCbxCodeType(CodesTables.CCERTVER);// Method of Citizenship Verification
//    personCitizenshipDAO.savePersonCitizenship(personCitizenship);

    
    
    String cdCbx = "";                                                                                                                                                                                                                                                              
    if (CodesTables.CPRFCTN_BRC.equals(cdPersonProofCitizenship)) {
         cdCbx = CodesTables.CCERTVER_CBC;// US Birth Certificate
    } else if (CodesTables.CPRFCTN_NTC.equals(cdPersonProofCitizenship)) {
      cdCbx = CodesTables.CCERTVER_NCF;// Naturalization
    } else if (CodesTables.CPRFCTN_USP.equals(cdPersonProofCitizenship)) {
      cdCbx = CodesTables.CPRFCTN_USP;// US Passport
    }                                                                                                                                                
                                                                                                                                                
    if (personCitizenshipExist != 0) {
      // personCitizenship = (PersonCitizenship) (PersonCitizenship) getSession().load(PersonCitizenship.class,
      // idPerson);
      // update
      personCitizenshipDAO.updatePersonCitizenship(idPerson, cdCbx, CodesTables.CCERTVER);
    } else {
      // personCitizenship.setPerson(person);
      // insert
      personCitizenshipDAO.insertPersonCitizenship(idPerson, cdCbx, CodesTables.CCERTVER);
    }    

    // personCitizenship.setCdCbxCodeType(CodesTables.CCERTVER);// Method of Citizenship Verification
    // personCitizenshipDAO.savePersonCitizenship(personCitizenship);
    
    
    stagePersonLinkDAO.updateStagePersonLink(txtStagePersNotes, cdStagePersRole, cdStagePersType, cdStagePersSearchInd,
                                             cdStagePersRelInt, indStagePersReporter, indStagePersInLaw,
                                             cdStagePersLstSort, idStage, idPerson, cdPKHouseholdMember);

    // secondary caregiver
    Integer ulIdRelationshipSecondaryCaregiver = relationshipDAO.findRelationshipIdRelationship(idPerson,
                                                                                                SECONDARY_CAREGIVER);
    int idRelationshipSecondaryCaregiver = (Integer) ulIdRelationshipSecondaryCaregiver != null ? ulIdRelationshipSecondaryCaregiver
                                                                                               : 0;

    // if a relationship already existed and the secondarycaregiver is a different the same one of different one
    // then update the relationship. If the secondarycaregive is being removed than delete the relationship.
    if ((idRelationshipSecondaryCaregiver == 0 || idRelationshipSecondaryCaregiver > 0) && idSecondaryCareGiver > 0) {
      // an
      // existing
      // or
      // adding
      // a
      // new
      // secondary
      // care
      // giver
      // relationship
      relationshipDAO.saveRelationship(idRelationshipSecondaryCaregiver, idPerson, idSecondaryCareGiver,
                                       SECONDARY_CAREGIVER);
    } else if (idRelationshipSecondaryCaregiver > 0 && idSecondaryCareGiver == 0) { // removal of existing secondary
      // caregiver relationship
      relationshipDAO.deleteRelationship(idRelationshipSecondaryCaregiver);
    }
  } //

  public int insertPersonStagePersonLinkAndPersonCategory(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth,
                                                          String cdPersonStatus, String cdPersonDeath,
                                                          String cdPersonMaritalStatus, String cdPersonLanguage,
                                                          String cdPersonSex, String nmPersonFull,
                                                          String cdPersonEthnicGroup, String cdPersonReligion,
                                                          String cdPersonChar, String indPersonDobApprox,
                                                          String cdPersonLivArr, String txtPersonOccupation,
                                                          String cdDisasterRlf, int idStage, int idPerson,
                                                          String cdStagePersRole, String cdStagePersType,
                                                          String cdStagePersSearchInd, String cdStagePersRelInt,
                                                          String indStagePersReporter, String indStagePersInLaw,
                                                          Date dtStagePersLink, String cdCategoryCategory,
                                                          int ulIdPersonRelatePutativeFather,
                                                          int ulIdPersonRelateLegalFather,
                                                          int ulIdPersonRelateBioFather, String indRegisteredWithTribe,
                                                          String indTribalMember, String szTxtPercentHeritage,
                                                          String szTxtTribalName, String szCdTitle,
                                                          String szTxtMaidenName, String indLegalCust,
                                                          String indSafetyRsrc, String indRsrcHouseholdMember,
                                                          String indPaternityEst, String indVerified, String txtAddlCmnts,
                                                          String cdPKHouseholdMember,
                                                          int ulIdPersonRelateLegalMother,
                                                          int ulIdPersonRelateBioMother, Date dtAssigned, Date dtUnassigned, String personSsn, Date dtPersonAddedOrRelated, String szTxtEmail) {

    if (LT_UNKNOWN.equals(nmPersonFull) && LT_PRINCIPLE.equals(cdStagePersType)) {
      idPerson = commonDAO.getNextval("SEQ_PERSON");
      nmPersonFull = LT_UNKNOWN + " " + idPerson;
      personDAO.insertPerson(idPerson, nbrPersonAge, dtPersonDeath, dtPersonBirth, cdPersonStatus, cdPersonDeath,
                             cdPersonMaritalStatus, cdPersonLanguage, cdPersonSex, nmPersonFull, cdPersonEthnicGroup,
                             cdPersonReligion, cdPersonChar, indPersonDobApprox, cdPersonLivArr, txtPersonOccupation,
                             cdDisasterRlf, szCdTitle, txtAddlCmnts, personSsn);
    } else {

      idPerson = personDAO.insertPerson(nbrPersonAge, dtPersonDeath, dtPersonBirth, cdPersonStatus, cdPersonDeath,
                                        cdPersonMaritalStatus, cdPersonLanguage, cdPersonSex, nmPersonFull,
                                        cdPersonEthnicGroup, cdPersonReligion, cdPersonChar, indPersonDobApprox,
                                        cdPersonLivArr, txtPersonOccupation, cdDisasterRlf, szCdTitle, txtAddlCmnts, personSsn);
    }

    // findIdPersonDtlByIdPerson
    int idPersonDtl = (Integer) personDtlDAO.findIdPersonDtlByIdPerson(idPerson) != null ? (Integer) personDtlDAO
                                                                                                                 .findIdPersonDtlByIdPerson(idPerson)

                                                                                        : 0;

    if (0 == personDtlDAO.savePersonDtl(idPersonDtl, idPerson, szTxtMaidenName, 0, 0, 0, StringHelper.EMPTY_STRING,
                                        StringHelper.EMPTY_STRING, StringHelper.EMPTY_STRING, indVerified,
                                        indRsrcHouseholdMember, indPaternityEst, StringHelper.EMPTY_STRING,
                                        indLegalCust, szTxtEmail)) {
      return 0;
    }

    stagePersonLinkDAO.insertStagePersonLink(idStage, idPerson, cdStagePersRole, cdStagePersType, cdStagePersSearchInd,
                                             cdStagePersRelInt, indStagePersReporter, indStagePersInLaw, indSafetyRsrc,
                                             dtStagePersLink, StringHelper.EMPTY_STRING, cdPKHouseholdMember, dtPersonAddedOrRelated);
    
    if (CodesTables.CSRCRPTR_CS.equals(cdStagePersRelInt) || CodesTables.CSRCRPTR_GX.equals(cdStagePersRelInt)
        || CodesTables.CSRCRPTR_GY.equals(cdStagePersRelInt)) {
      StageRepLink stageRepLink = stageRepLinkDAO.findStageRepLinkByIdPersonIdStage(idPerson, idStage);
      if (stageRepLink != null) {
        stageRepLink.setDtRepStart(dtAssigned);
        stageRepLink.setDtRepEnd(dtUnassigned);
        stageRepLinkDAO.saveStageRepLink(stageRepLink);
      } else {
        StageRepLink stageRepLinkNew = new StageRepLink();
        stageRepLinkNew.setDtRepEnd(dtUnassigned);
        stageRepLinkNew.setDtRepStart(dtAssigned);
        Person person = (Person) getSession().load(Person.class, idPerson);
        stageRepLinkNew.setPerson(person);
        Stage stage = (Stage) getSession().load(Stage.class, idStage);
        stageRepLinkNew.setStage(stage);
        stageRepLinkDAO.saveStageRepLink(stageRepLinkNew);
      }
    }
    
    

    if (cdCategoryCategory != null && cdCategoryCategory.trim().length() != 0) {
      PersonCategory personCategory = new PersonCategory();
      personCategory.setCdPersonCategory(cdCategoryCategory);
      Person person = (Person) getSession().load(Person.class, idPerson);
      personCategory.setPerson(person);
      personCategoryDAO.savePersonCategory(personCategory);
    }
    return idPerson;
  }

  // STGAP00017013: MR-095
  // Insert stage person link record to the database when the person record is added
  // via the Add Person to Active Stages section on the Person Detail page
  public void insertPersonAddedFromAddPersonToActiveStages(int idPerson, int idStage, int idCase,
                                                           List<Map> stagesToAddMap, Date dtAssigned,
                                                           Date dtUnassigned, String personSearchParameter) {
    if (stagesToAddMap != null && !stagesToAddMap.isEmpty()) {
      for (Iterator<Map> it = stagesToAddMap.iterator(); it.hasNext();) {
        Map map = it.next();
        int idStageToAdd = (Integer) map.get("idStageTo");
        String cdStagePersTypeToAdd = (String) map.get("cdStagePersType");
        String cdStagePersRelIntToAdd = (String) map.get("cdStagePersRelInt");
        Date dtAdded = (Date) map.get("dtAdded");

        // Insert the records added via the person detail page to the stage person link table
        // Role is pre-populated as 'NO(No Role)' and the Search Indicator in the Person List 
        // is pre-populated as 'V(Viewed)' if the person is added to the system for the first time
        // and is pre-populated as 'R(Related)' if the (existing) person is related to the stage
        stagePersonLinkDAO.insertStagePersonLinkAddedFromAddPersonToActiveStages(idStageToAdd, idPerson, NO_ROLE,
                                                                                 cdStagePersTypeToAdd,
                                                                                 cdStagePersRelIntToAdd,
                                                                                 personSearchParameter);

        // Insert the records added via the person detail page to the stage person add history table
        stagePersonAddHistoryDAO.insertStagePersonAddHistoryAddedFromAddPersonToActiveStages(idStage, idStageToAdd,
                                                                                             idCase, idPerson,
                                                                                             cdStagePersTypeToAdd,
                                                                                             cdStagePersRelIntToAdd,
                                                                                             dtAdded);

        // This is mimicking the current logic to update the stage rep link table 
        // if any of the following three Relationships is selected for the person
        if (CodesTables.CSRCRPTR_CS.equals(cdStagePersRelIntToAdd)
            || CodesTables.CSRCRPTR_GX.equals(cdStagePersRelIntToAdd)
            || CodesTables.CSRCRPTR_GY.equals(cdStagePersRelIntToAdd)) {
          StageRepLink stageRepLink = stageRepLinkDAO.findStageRepLinkByIdPersonIdStage(idPerson, idStageToAdd);
          if (stageRepLink != null) {
            stageRepLink.setDtRepStart(dtAssigned);
            stageRepLink.setDtRepEnd(dtUnassigned);
            stageRepLinkDAO.saveStageRepLink(stageRepLink);
          } else {
            StageRepLink stageRepLinkNew = new StageRepLink();
            stageRepLinkNew.setDtRepEnd(dtUnassigned);
            stageRepLinkNew.setDtRepStart(dtAssigned);
            Person person = (Person) getSession().load(Person.class, idPerson);
            stageRepLinkNew.setPerson(person);
            Stage stage = (Stage) getSession().load(Stage.class, idStageToAdd);
            stageRepLinkNew.setStage(stage);
            stageRepLinkDAO.saveStageRepLink(stageRepLinkNew);
          }
        }
      }
    }
  }  

  public int updatePersonAndStagePersonLink(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth,
                                            String cdPersonStatus, String cdPersonDeath, String cdPersonMaritalStatus,
                                            String cdPersonLanguage, String cdPersonSex, String nmPersonFull,
                                            String cdPersonEthnicGroup, String txtPersonOccupation,
                                            String cdPersonLivArr, String indPersonDobApprox, String cdPersonReligion,
                                            String cdDisasterRlf, int idPerson, Date dtLastUpdate,
                                            String cdStagePersRole, String cdStagePersType,
                                            String cdStagePersSearchInd, String cdStagePersRelInt,
                                            String indStagePersReporter, String indStagePersInLaw,
                                            int idStagePersonLink, Date lastUpdate,
                                            String szTxtOtherRelationshipsCmnts,
                                            int ulIdPersonRelateSecondaryCaregiver, int ulIdPersonRelatePutativeFather,
                                            int ulIdPersonRelateLegalFather, int ulIdPersonRelateBioFather,
                                            String indRegisteredWithTribe, String indTribalMember,
                                            String szTxtPercentHeritage, String szTxtTribalName,
                                            String szCdPersonTitle, String szTxtTribalRegistryNumber,
                                            String szTxtMaidenName, String indLegalCust, String indSafetyRsrc,
                                            String indRsrcHouseholdMember, String indPaternityEst, String indVerified,
                                            int lQtyPersonWeight, int sQtyPersonHeightFeet, int sQtyPersonHeightInches,
                                            String szCdPersonEyeColor, String szCdPersonHairColor,
                                            String szCdPersonHighestEduc, String sideOfFamily, String txtAddlCmnts, 
                                            String cdPKHouseholdMember, int ulIdPersonRelateLegalMother,
                                            int ulIdPersonRelateBioMother, Date dtAssigned, int idStage, Date dtUnassigned, String szTxtEmail) {

    if (0 == personDAO.updatePerson(nbrPersonAge, dtPersonDeath, dtPersonBirth, cdPersonStatus, cdPersonDeath,
                                    cdPersonMaritalStatus, cdPersonLanguage, cdPersonSex, nmPersonFull,
                                    cdPersonEthnicGroup, txtPersonOccupation, cdPersonLivArr, indPersonDobApprox,
                                    szCdPersonTitle, szTxtOtherRelationshipsCmnts, cdPersonReligion, cdDisasterRlf,
                                    idPerson, lastUpdate, txtAddlCmnts)) {

      return 0;
    }

    // secondary caregiver
    int ulIdRelationshipSecondaryCaregiver = (Integer) relationshipDAO
                                                                      .findRelationshipIdRelationship(idPerson,
                                                                                                      SECONDARY_CAREGIVER) != null ? (Integer) relationshipDAO
                                                                                                                                                              .findRelationshipIdRelationship(
                                                                                                                                                                                              idPerson,
                                                                                                                                                                                              SECONDARY_CAREGIVER)
                                                                                                                                  : 0;

    if (0 == relationshipDAO.saveRelationship(ulIdRelationshipSecondaryCaregiver, idPerson,
                                              ulIdPersonRelateSecondaryCaregiver, SECONDARY_CAREGIVER)) {
      return 0;
    }

    // putative father
    int ulIdRelationshipPutativeFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson,
                                                                                                  PUTATIVE_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                      .findRelationshipIdRelationship(
                                                                                                                                                                                      idPerson,
                                                                                                                                                                                      PUTATIVE_FATHER)
                                                                                                                          : 0;

    if (0 == relationshipDAO.saveRelationship(ulIdRelationshipPutativeFather, idPerson, ulIdPersonRelatePutativeFather,
                                              PUTATIVE_FATHER)) {
      return 0;
    }

    // legal father
    int ulIdRelationshipLegalFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson, LEGAL_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                          .findRelationshipIdRelationship(
                                                                                                                                                                                          idPerson,
                                                                                                                                                                                          LEGAL_FATHER)
                                                                                                                              : 0;

    if (0 == relationshipDAO.saveRelationship(ulIdRelationshipLegalFather, idPerson, ulIdPersonRelateLegalFather,
                                              LEGAL_FATHER)) {
      return 0;
    }

    // biological father
    int ulIdRelationshipBiologicalFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson,
                                                                                                    BIOLOGICAL_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                          .findRelationshipIdRelationship(
                                                                                                                                                                                          idPerson,
                                                                                                                                                                                          BIOLOGICAL_FATHER)
                                                                                                                              : 0;

    if (0 == relationshipDAO.saveRelationship(ulIdRelationshipBiologicalFather, idPerson, ulIdPersonRelateBioFather,
                                              BIOLOGICAL_FATHER)) {
      return 0;
    }
    
 // STGAP00015485: legal Mother
    int ulIdRelationshipLegalMother = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson, LEGAL_MOTHER) != null ? (Integer) relationshipDAO
                                                                                                                                                          .findRelationshipIdRelationship(
                                                                                                                                                                                          idPerson,
                                                                                                                                                                                          LEGAL_MOTHER)
                                                                                                                              : 0;

    if (0 == relationshipDAO.saveRelationship(ulIdRelationshipLegalMother, idPerson, ulIdPersonRelateLegalMother,
                                              LEGAL_MOTHER)) {
      return 0;
    }

    // STGAP00015485: biological Mother
    int ulIdRelationshipBiologicalMother = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson,
                                                                                                    BIOLOGICAL_MOTHER) != null ? (Integer) relationshipDAO
                                                                                                                                                          .findRelationshipIdRelationship(
                                                                                                                                                                                          idPerson,
                                                                                                                                                                                          BIOLOGICAL_MOTHER)
                                                                                                                              : 0;

    if (0 == relationshipDAO.saveRelationship(ulIdRelationshipBiologicalMother, idPerson, ulIdPersonRelateBioMother,
                                              BIOLOGICAL_MOTHER)) {
      return 0;
    }


    // get (idTribal) passing (idPerson)
    if (0 == saveTribal(idPerson, indRegisteredWithTribe, indTribalMember, szTxtPercentHeritage, szTxtTribalName,
                        szTxtTribalRegistryNumber)) {
      return 0;
    }

    // findIdPersonDtlByIdPerson
    int idPersonDtl = (Integer) personDtlDAO.findIdPersonDtlByIdPerson(idPerson) != null ? (Integer) personDtlDAO
                                                                                                                 .findIdPersonDtlByIdPerson(idPerson)

                                                                                        : 0;

    if (0 == personDtlDAO.savePersonDtl(idPersonDtl, idPerson, szTxtMaidenName, lQtyPersonWeight, sQtyPersonHeightFeet,
                                        sQtyPersonHeightInches, szCdPersonEyeColor, szCdPersonHairColor,
                                        szCdPersonHighestEduc, indVerified, indRsrcHouseholdMember, indPaternityEst,
                                        sideOfFamily, indLegalCust, szTxtEmail)) {
      return 0;
    }
    
    if (CodesTables.CSRCRPTR_CS.equals(cdStagePersRelInt) || CodesTables.CSRCRPTR_GX.equals(cdStagePersRelInt)
        || CodesTables.CSRCRPTR_GY.equals(cdStagePersRelInt)) {
      StageRepLink stageRepLink = stageRepLinkDAO.findStageRepLinkByIdPersonIdStage(idPerson, idStage);
      if (stageRepLink != null) {
        stageRepLink.setDtRepStart(dtAssigned);
        stageRepLink.setDtRepEnd(dtUnassigned);
        stageRepLinkDAO.saveStageRepLink(stageRepLink);
      } else {
        StageRepLink stageRepLinkNew = new StageRepLink();
        stageRepLinkNew.setDtRepEnd(dtUnassigned);
        stageRepLinkNew.setDtRepStart(dtAssigned);
        Person person = (Person) getSession().load(Person.class, idPerson);
        stageRepLinkNew.setPerson(person);
        Stage stage = (Stage) getSession().load(Stage.class, idStage);
        stageRepLinkNew.setStage(stage);
        stageRepLinkDAO.saveStageRepLink(stageRepLinkNew);
      }
    }

    return stagePersonLinkDAO.updateStagePersonLink(cdStagePersRole, cdStagePersType, cdStagePersSearchInd,
                                                    cdStagePersRelInt, indStagePersReporter, indStagePersInLaw,
                                                    idStagePersonLink, indSafetyRsrc, dtLastUpdate, sideOfFamily,
                                                    cdPKHouseholdMember);
  }

  public void deletePersonAndStagePersonLink(int idPerson, int idStagePersonLink, Date dtLastUpdate) {
    personDAO.deletePerson(idPerson);
    StagePersonLink stagePersonLink = (StagePersonLink) getSession().load(StagePersonLink.class, idStagePersonLink);
    int idStage = stagePersonLink.getStage().getIdStage();
    stagePersonLinkDAO.deleteStagePersonLink(idStage, idPerson);
  }

  public void updateWindowModeLower(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                                    String cdStagePersSearchInd, String cdStagePersRelInt, String indStagePersReporter,
                                    String indStagePersInLaw, Date dtStagePersLink, int nbrPersonAge,
                                    Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                                    String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                                    String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                                    String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                                    String cdPersonReligion, String cdDisasterRlf, Date dtLastUpdate,
                                    String cdCategoryCategory, String szCdPersonTitle,
                                    String szTxtOtherRelationshipsCmnts, String szTxtMaidenName, String indLegalCust,
                                    String indSafetyRsrc, String indRsrcHouseholdMember, String indPaternityEst,
                                    String indVerified, int lQtyPersonWeight, int sQtyPersonHeightFeet,
                                    int sQtyPersonHeightInches, String szCdPersonEyeColor, String szCdPersonHairColor,
                                    String szCdPersonHighestEduc, String sideOfFamily,
                                    int ulIdPersonRelateSecondaryCaregiver, int ulIdPersonRelatePutativeFather,
                                    int ulIdPersonRelateLegalFather, int ulIdPersonRelateBioFather,
                                    String indRegisteredWithTribe, String indTribalMember, String szTxtPercentHeritage,
                                    String szTxtTribalName, String szTxtTribalRegistryNumber, String txtAddlCmnts,
                                    String cdPKHouseholdMember, int ulIdPersonRelateLegalMother,
                                    int ulIdPersonRelateBioMother, Date dtAssigned, Date dtUnassigned, Date dtPersonAddedOrRelated, String szTxtEmail) {

    // secondary caregiver
    int ulIdRelationshipSecondaryCaregiver = (Integer) relationshipDAO
                                                                      .findRelationshipIdRelationship(idPerson,
                                                                                                      SECONDARY_CAREGIVER) != null ? (Integer) relationshipDAO
                                                                                                                                                              .findRelationshipIdRelationship(
                                                                                                                                                                                              idPerson,
                                                                                                                                                                                              SECONDARY_CAREGIVER)
                                                                                                                                  : 0;

    int saveRelationshipSecondaryCaregiverResult = relationshipDAO.saveRelationship(ulIdRelationshipSecondaryCaregiver,
                                                                                    idPerson,
                                                                                    ulIdPersonRelateSecondaryCaregiver,
                                                                                    SECONDARY_CAREGIVER);

    // putative father
    int ulIdRelationshipPutativeFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson,
                                                                                                  PUTATIVE_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                      .findRelationshipIdRelationship(
                                                                                                                                                                                      idPerson,
                                                                                                                                                                                      PUTATIVE_FATHER)
                                                                                                                          : 0;

    int saveRelationshipPutativeFatherResult = relationshipDAO.saveRelationship(ulIdRelationshipPutativeFather,
                                                                                idPerson,
                                                                                ulIdPersonRelatePutativeFather,
                                                                                PUTATIVE_FATHER);

    // legal father
    int ulIdRelationshipLegalFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson, LEGAL_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                          .findRelationshipIdRelationship(
                                                                                                                                                                                          idPerson,
                                                                                                                                                                                          LEGAL_FATHER)
                                                                                                                              : 0;

    int saveRelationshipLegalFatherResult = relationshipDAO.saveRelationship(ulIdRelationshipLegalFather, idPerson,
                                                                             ulIdPersonRelateLegalFather, LEGAL_FATHER);

    // biological father
    int ulIdRelationshipBiologicalFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson,
                                                                                                    BIOLOGICAL_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                          .findRelationshipIdRelationship(
                                                                                                                                                                                          idPerson,
                                                                                                                                                                                          BIOLOGICAL_FATHER)
                                                                                                                              : 0;

    int saveRelationshipBioFatherResult = relationshipDAO
                                                         .saveRelationship(ulIdRelationshipBiologicalFather, idPerson,
                                                                           ulIdPersonRelateBioFather, BIOLOGICAL_FATHER);
    
    // STGAP00015485: legal Mother
    int ulIdRelationshipLegalMother = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson, LEGAL_MOTHER) != null ? (Integer) relationshipDAO
                                                                                                                                                          .findRelationshipIdRelationship(
                                                                                                                                                                                          idPerson,
                                                                                                                                                                                          LEGAL_MOTHER)
                                                                                                                              : 0;
   int saveRelationshipLegalMotherResult = relationshipDAO.saveRelationship(ulIdRelationshipLegalMother, idPerson, 
                                                                          ulIdPersonRelateLegalMother, LEGAL_MOTHER);

    // STGAP00015485: biological Mother
    int ulIdRelationshipBiologicalMother = (Integer) relationshipDAO.findRelationshipIdRelationship(idPerson,
                                                                                                    BIOLOGICAL_MOTHER) != null ? (Integer) relationshipDAO
                                                                                                                                                          .findRelationshipIdRelationship(
                                                                                                                                                                                          idPerson,
                                                                                                                                                                                          BIOLOGICAL_MOTHER)
                                                                                                                              : 0;
    int saveRelationshipBioMotherResult = relationshipDAO.saveRelationship(ulIdRelationshipBiologicalMother, idPerson, 
                                                                           ulIdPersonRelateBioMother, BIOLOGICAL_MOTHER);
    

    int saveTribalResult = saveTribal(idPerson, indRegisteredWithTribe, indTribalMember, szTxtPercentHeritage,
                                      szTxtTribalName, szTxtTribalRegistryNumber);

    // findIdPersonDtlByIdPerson
    int idPersonDtl = (Integer) personDtlDAO.findIdPersonDtlByIdPerson(idPerson) != null ? (Integer) personDtlDAO
                                                                                                                 .findIdPersonDtlByIdPerson(idPerson)

                                                                                        : 0;

    int personDtlUpdateResult = personDtlDAO.savePersonDtl(idPersonDtl, idPerson, szTxtMaidenName, lQtyPersonWeight,
                                                           sQtyPersonHeightFeet, sQtyPersonHeightInches,
                                                           szCdPersonEyeColor, szCdPersonHairColor,
                                                           szCdPersonHighestEduc, indVerified, indRsrcHouseholdMember,
                                                           indPaternityEst, sideOfFamily, indLegalCust, szTxtEmail);

    int saveStagePersonLinkResult = stagePersonLinkDAO.insertStagePersonLink(idStage, idPerson, cdStagePersRole,
                                                                             cdStagePersType, cdStagePersSearchInd,
                                                                             cdStagePersRelInt, indStagePersReporter,
                                                                             indStagePersInLaw, indSafetyRsrc,
                                                                             dtStagePersLink, sideOfFamily, cdPKHouseholdMember, dtPersonAddedOrRelated);

    int savePersonResult = personDAO.updatePerson(nbrPersonAge, dtPersonDeath, dtPersonBirth, cdPersonStatus,
                                                  cdPersonDeath, cdPersonMaritalStatus, cdPersonLanguage, cdPersonSex,
                                                  nmPersonFull, cdPersonEthnicGroup, txtPersonOccupation,
                                                  cdPersonLivArr, indPersonDobApprox, szCdPersonTitle,
                                                  szTxtOtherRelationshipsCmnts, cdPersonReligion, cdDisasterRlf,
                                                  idPerson, dtLastUpdate, txtAddlCmnts);

    if (personDtlUpdateResult <= 0 || saveStagePersonLinkResult <= 0 || savePersonResult <= 0
        || saveRelationshipSecondaryCaregiverResult <= 0 || saveRelationshipPutativeFatherResult <= 0
        || saveRelationshipLegalFatherResult <= 0 || saveRelationshipBioFatherResult <= 0 || saveTribalResult <= 0
        || saveRelationshipLegalMotherResult <= 0 || saveRelationshipBioMotherResult <= 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }

    if (cdCategoryCategory != null && cdCategoryCategory.trim().length() != 0) {
      long count = personCategoryDAO.countPersonCategoryByIdPersonAndCdPersonCategory(idPerson, cdCategoryCategory);
      if (count == 0) {
        PersonCategory personCategory = new PersonCategory();
        personCategory.setCdPersonCategory(cdCategoryCategory);
        Person person = (Person) getSession().load(Person.class, idPerson);
        personCategory.setPerson(person);
        personCategoryDAO.savePersonCategory(personCategory);
      }
    }
    
    if (CodesTables.CSRCRPTR_CS.equals(cdStagePersRelInt) || CodesTables.CSRCRPTR_GX.equals(cdStagePersRelInt)
        || CodesTables.CSRCRPTR_GY.equals(cdStagePersRelInt)) {
      StageRepLink stageRepLink = stageRepLinkDAO.findStageRepLinkByIdPersonIdStage(idPerson, idStage);
      if (stageRepLink != null) {
        stageRepLink.setDtRepStart(dtAssigned);
        stageRepLink.setDtRepEnd(dtUnassigned);
        stageRepLinkDAO.saveStageRepLink(stageRepLink);
      } else {
        StageRepLink stageRepLinkNew = new StageRepLink();
        stageRepLinkNew.setDtRepEnd(dtUnassigned);
        stageRepLinkNew.setDtRepStart(dtAssigned);
        Person person = (Person) getSession().load(Person.class, idPerson);
        stageRepLinkNew.setPerson(person);
        Stage stage = (Stage) getSession().load(Stage.class, idStage);
        stageRepLinkNew.setStage(stage);
        stageRepLinkDAO.saveStageRepLink(stageRepLinkNew);
      }
    }
  }

  private int saveTribal(int idPerson, String indRegisteredWithTribe, String indTribalMember,
                         String szTxtPercentHeritage, String szTxtTribalName, String szTxtTribalRegistryNumber) {

    // call tribal dao
    Integer idTribal = tribalDAO.findIdTribalByIdPerson(idPerson);
    int ulIdTribal = idTribal != null ? idTribal : 0;

    // get (idTribal) passing (idPerson)
    return saveTribal(ulIdTribal, idPerson, indRegisteredWithTribe, indTribalMember, szTxtPercentHeritage,
                      szTxtTribalName, szTxtTribalRegistryNumber);
  }

  private int saveTribal(int idTribal, int idPerson, String indRegisteredWithTribe, String indTribalMember,
                         String szTxtPercentHeritage, String szTxtTribalName, String szTxtTribalRegistryNumber) {
    Tribal tribal = new Tribal();

    if (idTribal > 0) {
      tribal = (Tribal) getSession().load(Tribal.class, idTribal);
    }

    Person personByIdPerson = (Person) getSession().load(Person.class, idPerson);
    tribal.setPerson(personByIdPerson);
    tribal.setIndTrblRegistered(indRegisteredWithTribe);
    tribal.setIndTrblMember(indTribalMember);

    if (!"".equals(szTxtPercentHeritage) && !"null".equals(szTxtPercentHeritage)) {
      int percentHeritage = 0;
      try {
        percentHeritage = Integer.parseInt(szTxtPercentHeritage);
      } catch (NumberFormatException nfe) {
      }
      tribal.setNbrTrblPercentHeritage(percentHeritage);
    }

    if (StringHelper.isValid(szTxtTribalRegistryNumber)) {
      tribal.setNbrTribalRegistry(szTxtTribalRegistryNumber);
    }

    tribal.setTxtTribalName(szTxtTribalName);
    getSession().saveOrUpdate(tribal);

    return tribal.getIdTribal();
  }

}