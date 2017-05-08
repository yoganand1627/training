package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**Change History:
*    Date        User              Description
*    --------    ----------------  --------------------------------------------------
*   06/24/2009   bgehlot           STGAP00014329: Added indPKHouseholdMember parameter in method insertPersonStagePersonLinkAndPersonCategory
*                                  and updatePersonAndStagePersonLink and updateWindowModeLower
*   09/30/2009   bgehlot           STGAP00015485: Added Legal mother, and biological mother parameters in method insertPersonStagePersonLinkAndPersonCategory
*                                  and updatePersonAndStagePersonLink and updateWindowModeLower.
*                                  Added cdPKHouseholdMember in insertPerson and updatePerson method
*   08/29/2010   htvo			   MR-067: added new field email to insertPersonStagePersonLinkAndPersonCategory, updatePersonAndStagePersonLink,
*                                  updateWindowModeLower                                   
*   09/07/2011   schoi             STGAP00017013: MR-095 Added new method insertPersonAddedFromAddPersonToActiveStages                               
*                                  
*/

public interface ComplexPersonDAO {
  /**
   * Partial insert of Person table. Copies entries from the IncomingPerson table into the Person table for a specific
   * person id. (ie. copies all the entries from the IncomingPerson table for the related person id into the Person
   * table using the person id) It is used for the unrelate service.
   * 
   * @param idRelatedPerson
   * @param idStage
   * @return Map The idPerson(as "idPerson") of the new person added to person table and the idIncmgPerson (as
   *         "idIncmgPerson") retrieved from IncomingPerson table during this 'insert' operation.
   */
  Map<String, Integer> insertPersonFromIncomingPerson(int idRelatedPerson, int idStage);

  /**
   * The person is deleted from various tables, based on the lgic.This method takes a single parameter,idPerson, and
   * determines if a person is involved in any stages besides the given stage or if the person is involved in any
   * events. If the person is not linked to any other events/stages, a true flag is returned. Otherwise, if a person is
   * involved in other stages and/or events, a false flag is returned. This flag represents whether or not a person can
   * be deleted from the database. If the flag is set to true, a stored procedure is invoked that deletes the person
   * from the appropriate tables.
   * 
   * @param idPerson
   *          The person id that determines which person is to be deleted
   * @param indDelPerson
   *          An indicator used to determine the service that invokes this method.
   * @return boolean The status, whether or not the delete can be performed.
   */
  boolean deletePerson(int idPerson, String indDelPerson);

  /**
   * Called by the Incoming Person partial save functionality to add, update and delete people, categories, and links to
   * stages. The delete functionality will remove the above information only if the person is not related to other
   * stages.
   * 
   * @param nbrPersonAge
   * @param dtPersonBirth
   * @param dtPersonDeath
   * @param personStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdDisasterRlf
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param indPersonDobApprox
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param txtStagePersNotes
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param idStage
   * @param indStagePersInLaw
   * @param cdStagePersLstSort
   * @param cdCategoryCategory
   * @param cdPersonTitle
   * @param cdMatchType
   * @param cdPersonProofCitizenship
   * @param indPersonUsCitizen
   * @param cdPersonImmigrationStatus
   * @param cdPersonCountryOrigin
   * @param txtPersonOtherRelationships
   * @param idScndryCareGiver
   * cdPKHouseholdMember
   *          TODO
   */
  int insertPerson(int nbrPersonAge, Date dtPersonBirth, Date dtPersonDeath, String personStatus, String cdPersonDeath,
                   String cdPersonMaritalStatus, String cdPersonLanguage, String cdDisasterRlf, String cdPersonSex,
                   String nmPersonFull, String cdPersonEthnicGroup, String indPersonDobApprox, String cdStagePersRole,
                   String cdStagePersType, String cdStagePersSearchInd, String txtStagePersNotes,
                   String cdStagePersRelInt, String indStagePersReporter, int idStage, String indStagePersInLaw,
                   String cdStagePersLstSort, String cdCategoryCategory, String cdPersonTitle, String cdMatchType,
                   String cdPersonProofCitizenship, String indPersonUsCitizen, String cdPersonImmigrationStatus,
                   String cdPersonCountryOrigin, String txtPersonOtherRelationships, int idScndryCareGiver,
                   String cdPKHouseholdMember);

  /**
   * Called by the Incoming Person partial save functionality to add, update to stages. The delete functionality will
   * remove the above information only if the person is not related to other stages.
   * 
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdDisasterRlf
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param indPersonDobApprox
   * @param indPersCancelHist
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param idStagePersonLink
   * @param txtStagePersNotes
   * @param cdStagePersLstSort
   * @param idStage
   * @param cdPersonTitle
   * @param cdMatchType
   * @param cdPersonProofCitizenship
   * @param indPersonUsCitizen
   * @param cdPersonImmigrationStatus
   * @param cdPersonCountryOrigin
   * @param txtPersonOtherRelationships
   * @param idSecondaryCareGiver
   * cdPKHouseholdMember
   */
  void updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonDeath,
                    String cdPersonMaritalStatus, String cdPersonLanguage, String cdDisasterRlf, String cdPersonSex,
                    String nmPersonFull, String cdPersonEthnicGroup, String indPersonDobApprox,
                    String indPersCancelHist, int idPerson, String cdStagePersRole, String cdStagePersType,
                    String cdStagePersSearchInd, String cdStagePersRelInt, String indStagePersReporter,
                    String indStagePersInLaw, int idStagePersonLink, String txtStagePersNotes,
                    String cdStagePersLstSort, int idStage, String cdPersonTitle, String cdMatchType,
                    String cdPersonProofCitizenship, String indPersonUsCitizen, String cdPersonImmigrationStatus,
                    String cdPersonCountryOrigin, String txtPersonOtherRelationships, int idSecondaryCareGiver,
                    String cdPKHouseholdMember);

  /**
   * Inserts records into Person,StagePersonLink and PersonCategory tables.
   * 
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param cdPersonReligion
   * @param cdPersonChar
   * @param indPersonDobApprox
   * @param cdPersonLivArr
   * @param txtPersonOccupation
   * @param cdDisasterRlf
   * @param idStage
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param dtStagePersLink
   * @param cdCategoryCategory
   * @param ulIdPersonRelatePutativeFather
   * @param ulIdPersonRelateLegalFather
   * @param ulIdPersonRelateBioFather
   * @param indRegisteredWithTribe
   * @param indTribalMember
   * @param szTxtPercentHeritage
   * @param szTxtTribalName
   * @param szCdTitle
   * @param szTxtMaidenName
   * @param indLegalCust
   * @param indSafetyRsrc
   * @param indRsrcHouseholdMember
   * @param indPaternityEst
   * @param indVerified
   * @param cdPKHouseholdMember
   * @param ulIdPersonRelateLegalMother
   * @param ulIdPersonRelateBioMother
   * @return
   */
  int insertPersonStagePersonLinkAndPersonCategory(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth,
                                                   String cdPersonStatus, String cdPersonDeath,
                                                   String cdPersonMaritalStatus, String cdPersonLanguage,
                                                   String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                                                   String cdPersonReligion, String cdPersonChar,
                                                   String indPersonDobApprox, String cdPersonLivArr,
                                                   String txtPersonOccupation, String cdDisasterRlf, int idStage,
                                                   int idPerson, String cdStagePersRole, String cdStagePersType,
                                                   String cdStagePersSearchInd, String cdStagePersRelInt,
                                                   String indStagePersReporter, String indStagePersInLaw,
                                                   Date dtStagePersLink, String cdCategoryCategory,
                                                   int ulIdPersonRelatePutativeFather, int ulIdPersonRelateLegalFather,
                                                   int ulIdPersonRelateBioFather, String indRegisteredWithTribe,
                                                   String indTribalMember, String szTxtPercentHeritage,
                                                   String szTxtTribalName, String szCdTitle, String szTxtMaidenName,
                                                   String indLegalCust, String indSafetyRsrc,
                                                   String indRsrcHouseholdMember, String indPaternityEst,
                                                   String indVerified, String txtAddlCmnts, String cdPKHouseholdMember,
                                                   int ulIdPersonRelateLegalMother,
                                                   int ulIdPersonRelateBioMother, Date dtAssigned, Date dtUnassigned,String personSsn, Date dtPersonAddedOrRelated, String szTxtEmail);

  // STGAP00017013: MR-095
  /**
   * Inserts records into Person, StagePersonLink and PersonCategory tables
   * 
   * @param idStage
   * @param idPerson
   * @param idCase
   * @param stagesToAddMap
   * @param dtAssigned
   * @param dtUnassigned
   * @param personSearchParameter
   * @return
   */
  void insertPersonAddedFromAddPersonToActiveStages(int idPerson, int idStage, int idCase, List<Map> stagesToAddMap,
                                                    Date dtAssigned, Date dtUnassigned, String personSearchParameter);
  
  /**
   * Updates Person and StagePersonLink tables.
   * 
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param txtPersonOccupation
   * @param cdPersonLivArr
   * @param indPersonDobApprox
   * @param cdPersonReligion
   * @param cdDisasterRlf
   * @param idPerson
   * @param dtLastUpdate
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param idStagePersonLink
   * @param lastUpdate
   * @param szTxtOtherRelationshipsCmnts
   * @param ulIdPersonRelateSecondaryCaregiver
   * @param ulIdPersonRelatePutativeFather
   * @param ulIdPersonRelateLegalFather
   * @param ulIdPersonRelateBioFather
   * @param indRegisteredWithTribe
   * @param indTribalMember
   * @param szTxtPercentHeritage
   * @param szTxtTribalName
   * @param szCdPersonTitle
   * @param szTxtTribalRegistryNumber
   * @param szTxtMaidenName
   * @param indLegalCust
   * @param indSafetyRsrc
   * @param indRsrcHouseholdMember
   * @param indPaternityEst
   * @param indVerified
   * @param lQtyPersonWeight
   * @param sQtyPersonHeightFeet
   * @param sQtyPersonHeightInches
   * @param szCdPersonEyeColor
   * @param szCdPersonHairColor
   * @param szCdPersonHighestEduc
   * @param sideOfFamily
   * @param cdPKHouseholdMember
   * @param ulIdPersonRelateLegalMother,
   * @param ulIdPersonRelateBioMother
   * @return int
   */
  int updatePersonAndStagePersonLink(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                                     String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                                     String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                                     String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                                     String cdPersonReligion, String cdDisasterRlf, int idPerson, Date dtLastUpdate,
                                     String cdStagePersRole, String cdStagePersType, String cdStagePersSearchInd,
                                     String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                                     int idStagePersonLink, Date lastUpdate, String szTxtOtherRelationshipsCmnts,
                                     int ulIdPersonRelateSecondaryCaregiver, int ulIdPersonRelatePutativeFather,
                                     int ulIdPersonRelateLegalFather, int ulIdPersonRelateBioFather,
                                     String indRegisteredWithTribe, String indTribalMember,
                                     String szTxtPercentHeritage, String szTxtTribalName, String szCdPersonTitle,
                                     String szTxtTribalRegistryNumber, String szTxtMaidenName, String indLegalCust,
                                     String indSafetyRsrc, String indRsrcHouseholdMember, String indPaternityEst,
                                     String indVerified, int lQtyPersonWeight, int sQtyPersonHeightFeet,
                                     int sQtyPersonHeightInches, String szCdPersonEyeColor, String szCdPersonHairColor,
                                     String szCdPersonHighestEduc, String sideOfFamily, String txtAddlCmnts, String cdPKHouseholdMember,
                                     int ulIdPersonRelateLegalMother,
                                     int ulIdPersonRelateBioMother, Date dtAssigned,int idStage, Date dtUnassigned, String szTxtEmail);

  /**
   * Deletes records from Person and StagePersonLink tables
   * 
   * @param idPerson
   * @param idStagePersonLink
   * @param dtLastUpdate
   */
  void deletePersonAndStagePersonLink(int idPerson, int idStagePersonLink, Date dtLastUpdate);

  /**
   * Inserts records into StagePersonLink and PersonCategory tables. Update Person table
   * 
   * @param idStage
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param dtStagePersLink
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param txtPersonOccupation
   * @param cdPersonLivArr
   * @param indPersonDobApprox
   * @param cdPersonReligion
   * @param cdDisasterRlf
   * @param dtLastUpdate
   * @param cdCategoryCategory
   * @param szCdPersonTitle
   * @param szTxtOtherRelationshipsCmnts
   * @param szTxtMaidenName
   * @param indLegalCust
   * @param indSafetyRsrc
   * @param indRsrcHouseholdMember
   * @param indPaternityEst
   * @param indVerified
   * @param lQtyPersonWeight
   * @param sQtyPersonHeightFeet
   * @param sQtyPersonHeightInches
   * @param szCdPersonEyeColor
   * @param szCdPersonHairColor
   * @param szCdPersonHighestEduc
   * @param sideOfFamily
   * @param ulIdPersonRelateSecondaryCaregiver
   * @param ulIdPersonRelatePutativeFather
   * @param ulIdPersonRelateLegalFather
   * @param ulIdPersonRelateBioFather
   * @param indRegisteredWithTribe
   * @param indTribalMember
   * @param szTxtPercentHeritage
   * @param szTxtTribalName
   * @param szTxtTribalRegistryNumber
   * @param cdPKHouseholdMember
   * @param ulIdPersonRelateLegalMother,
   * @param ulIdPersonRelateBioMother
   */
  void updateWindowModeLower(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                             String cdStagePersSearchInd, String cdStagePersRelInt, String indStagePersReporter,
                             String indStagePersInLaw, Date dtStagePersLink, int nbrPersonAge, Date dtPersonDeath,
                             Date dtPersonBirth, String cdPersonStatus, String cdPersonDeath,
                             String cdPersonMaritalStatus, String cdPersonLanguage, String cdPersonSex,
                             String nmPersonFull, String cdPersonEthnicGroup, String txtPersonOccupation,
                             String cdPersonLivArr, String indPersonDobApprox, String cdPersonReligion,
                             String cdDisasterRlf, Date dtLastUpdate, String cdCategoryCategory,
                             String szCdPersonTitle, String szTxtOtherRelationshipsCmnts, String szTxtMaidenName,
                             String indLegalCust, String indSafetyRsrc, String indRsrcHouseholdMember,
                             String indPaternityEst, String indVerified, int lQtyPersonWeight,
                             int sQtyPersonHeightFeet, int sQtyPersonHeightInches, String szCdPersonEyeColor,
                             String szCdPersonHairColor, String szCdPersonHighestEduc, String sideOfFamily,
                             int ulIdPersonRelateSecondaryCaregiver, int ulIdPersonRelatePutativeFather,
                             int ulIdPersonRelateLegalFather, int ulIdPersonRelateBioFather,
                             String indRegisteredWithTribe, String indTribalMember, String szTxtPercentHeritage,
                             String szTxtTribalName, String szTxtTribalRegistryNumber, String txtAddlCmnts, 
                             String cdPKHouseholdMember, int ulIdPersonRelateLegalMother,
                             int ulIdPersonRelateBioMother, Date dtAssigned, Date dtUnassigned, Date dtPersonAddedOrRelated, String szTxtEmail);
}