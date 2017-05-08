package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersRelMapCustodyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Relationship;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveFosterCarePrincipalList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00_ARRAY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Seung-eun (Caroline) Choi
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   09/20/2011   schoi                    Initial Creation for STGAP00017013: MR-095
 *   10/01/2011   schoi                    STGAP00017013: MR-095 Added retrieving logic based on the relationship
 *                                         between Primary Caretaker and removal child in removal stage
 *   10/11/2011   schoi                    STGAP00017169: MR-095 Updated the condition to retrieve Foster Care Principal List for FCC Stage section
 *                                         for copying existing Custody event in addition to adding new Custody event                                      
 *   10/13/2011   schoi                    STGAP00017187: MR-095 Added condition to set the relationship of Spouse as 'Other Non-related person' 
 *                                         when single Spouse exists but the Spouse has the same Gender as PK                                    
 *   10/14/2011   schoi                    STGAP00017194: MR-095 Expanded condition to compare stage name and person name                                       
 *   11/15/2011   schoi                    STGAP00017663: MR-095 Added First Cousin Once Removed (CRELVICT_FC) 
 *                                         to the category of Cousin
 *   
 * </pre>
 * 
 */

public class RetrieveFosterCarePrincipalListImpl extends BaseServiceImpl implements RetrieveFosterCarePrincipalList {

  private static final String PUTATIVE_FATHER = "PF";  
  private static final String LEGAL_FATHER = "LF";
  private static final String BIOLOGICAL_FATHER = "BF";
  private static final String LEGAL_MOTHER = "LM";
  private static final String BIOLOGICAL_MOTHER = "BM";
  
  private static final String WINDOW_MODE_NEW = "1";
  private static final String WINDOW_MODE_NEW_USING = "2";
  
  private static final String PARENT = "Parent";
  private static final String GRANDPARENT = "Grandparent";
  private static final String AUNT_UNCLE = "Aunt/Uncle";
  private static final String COUSIN = "Cousin";
  private static final String SIBLING = "Sibling";
  private static final String NON_RELATED = "Non Related";
  
  private static final String MALE = "M";
  private static final String FEMALE = "F";
  private static final String UNKNOWN = "U";
  
  private static final String OTHER_NON_RELATED_PERSON = "OP";
  
  private StageDAO stageDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private RelationshipDAO relationshipDAO = null;
  
  private PersonDAO personDAO = null;
  
  private StagePersRelMapCustodyDAO stagePersRelMapCustodyDAO = null;
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setStagePersRelMapCustodyDAO(StagePersRelMapCustodyDAO stagePersRelMapCustodyDAO) {
    this.stagePersRelMapCustodyDAO = stagePersRelMapCustodyDAO;
  }
  
  public CSUB80SO retrieveFosterCarePrincipalList(CSUB80SI csub80si) throws ServiceException {

    CSUB80SO csub80so = new CSUB80SO();
    int idRemovalStage = csub80si.getUlIdStage();
    int idChild = csub80si.getUlIdPerson();
    Stage removalStage = stageDAO.findStageAndCapsCase(idRemovalStage);
    int idCase = removalStage.getCapsCase().getIdCase();
    // Relationship of the Primary Caretaker to the removal child 
    // and this will be applied for all Principals in the stage
    String cdStagePersRelPKForPrincipals = "";
    
    // Map that holds the relationships from the removal stage; 
    // it starts from empty then builds as the relationship is defined
    Map<Integer, String> stagePersonLinkInfoDynamicOldRel = new HashMap<Integer, String>();

    // Find all Principals belong to the stage with the exception of the removal child
    // Removal child will be set to the Role as PC (Primary Child) and Relationship as Self
    // in the FCC and/or FCF stage(s) when the child gets saved
    List<Map> stagePersonLinkInfo = stagePersonLinkDAO.findStagePersonLinkExcludingIdPerson(idRemovalStage,
                                                                                            CodesTables.CPRSNTYP_PRN,
                                                                                            DateHelper.MAX_JAVA_DATE,
                                                                                            idChild);
    
    // This Map is used for sorting purpose at the end only
    List<Map> stagePersonLinkInfoForSort = stagePersonLinkDAO.findStagePersonLinkExcludingIdPerson(idRemovalStage,
                                                                                            CodesTables.CPRSNTYP_PRN,
                                                                                            DateHelper.MAX_JAVA_DATE,
                                                                                            idChild);
    
    if (stagePersonLinkInfo == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    String szSysCdWinMode = csub80si.getSzSysCdWinMode();
    if (WINDOW_MODE_NEW.equals(szSysCdWinMode) || WINDOW_MODE_NEW_USING.equals(szSysCdWinMode)) {
      // Start of the Relationship Mapping logic

      // There are two stage progression patterns that this code handles
      // 1. Stage progression from INV or ONG -> FCC and/or FCF
      // 2. Stage progression from FCF -> FCC

      // 1. Stage progression from INV or ONG -> FCC and/or FCF
      // Set Primary Caretaker(PK) value
      String cdStage = stageDAO.findCdStageByIdStage(idRemovalStage);
      if ((CodesTables.CSTAGES_INV.equals(cdStage) || CodesTables.CSTAGES_FPR.equals(cdStage)) && idChild != 0) {
        Map<Integer, String> principaListMap = new HashMap<Integer, String>();

        // Find the count of PK in the removal stage
        int idPrimaryCaretaker = 0;
        long cntPrimaryCaretaker = stagePersonLinkDAO
                                                     .countStagePersonLinkByIdStageCdStagePersRelInt(
                                                                                                     idRemovalStage,
                                                                                                     CodesTables.CRELVICT_PK);
        boolean noPrimaryCaretaker = cntPrimaryCaretaker < 1 ? true : false;
        boolean multiPrimaryCaretaker = cntPrimaryCaretaker > 1 ? true : false;

        // If no PK found, set the person with the stage name as PK
        // If multiple PK found, set the person with the stage name as the PK
        // and set the relationship of the additional PK(s) as 'Other' (by sending to the relationship mapping)
        if (noPrimaryCaretaker || multiPrimaryCaretaker) {
          String stageName = stageDAO.findNmStageByIdStage(idRemovalStage);

          // This is query for the exact match between the stage name and person name
          Person personWithStageName = stagePersonLinkDAO.findPersonByIdStageByNmPersonFull(idRemovalStage, stageName);
          if (personWithStageName != null) {
            idPrimaryCaretaker = personWithStageName.getIdPerson();
          } 
          // There are stages that have stage name not in sync with the person name of the PK
          // If no exact match found between stage name and person name 
          // then look for the person having the same last and first name as in the stage name
          // For instance, if there is no PK exists in the stage and the stage name is 'Mciver,Ronald'
          // then look for person with the same last and first name with the stage name
          // Therefore, person name as 'Mciver,Ronald A' can be considered as a match 
          // even if the person has extra initials
          //
          // Note: There are some variations in entering person name
          // Some names have Jr., Sr., or Third as its Suffix column 
          // and some names have Jr., Sr., or Third inside of its first name or last name
          // Therefore, the following code will catch as many variations as possible
          // Here are some example of stage name Vs. person name that the code will catch:
          // Stage name Haynes Iii,Joshua with person name Haynes,Joshua 
          // Stage name Mcgath, Jr.,Thomas with person name Mcgath,Thomas L 
          // Stage name Johnson Jr.,Joseph with person name Johnson,Joseph D 
          
          else { 
            // Compare the entire string of the stage name and person name
            Iterator<Map> itSPL = stagePersonLinkInfo.iterator();
            while (itSPL.hasNext()) {
              Map stagePersonLinkMap = itSPL.next();
              String lastName = (String) stagePersonLinkMap.get("nmPersonLast");
              String firstName = (String) stagePersonLinkMap.get("nmPersonFirst");
              
              if (StringHelper.getSafeString((String) stagePersonLinkMap.get("nmPersonFull")).startsWith(stageName)) {
                idPrimaryCaretaker = (Integer) stagePersonLinkMap.get("idPersonPrincipal");
              } else if (stageName
                                  .startsWith(StringHelper
                                                          .getSafeString((String) stagePersonLinkMap
                                                                                                    .get("nmPersonFull")))) {
                idPrimaryCaretaker = (Integer) stagePersonLinkMap.get("idPersonPrincipal");
              }
              
            }
            
            // If PK is still not found check for more variations
            if (idPrimaryCaretaker == 0) {
              // There are two different patterns in the last name in the stage name
              // 1. Space before the first comma
              // 2. First comma, Jr., Sr., etc., then second comma, then last name
              String lastNmFrStgNm = "";
              String firstNmFrStgNm = "";
              if (StringHelper.isValid(stageName) && stageName.indexOf(',') > 0) {
                // Check for the space before the first comma
                int idLocSpaceBeforeComma = -1;
                if (stageName.indexOf(' ') > 0) {
                  idLocSpaceBeforeComma = stageName.indexOf(' ');
                }
                // Check for the existence of second comma
                String nmAfterFirstComma = stageName.substring(stageName.indexOf(',') + 1);
                int checkSecondComma = nmAfterFirstComma.indexOf(',');
                if (checkSecondComma > 0 && idLocSpaceBeforeComma < 0) {
                  // Last name will be anything before the first comma
                  lastNmFrStgNm = stageName.substring(0, stageName.indexOf(','));
                  // First name will be anything after the second comma
                  firstNmFrStgNm = nmAfterFirstComma.substring(checkSecondComma + 1);
                } else if (checkSecondComma > 0 && idLocSpaceBeforeComma > 0) {
                  // Last name will be anything before the first comma
                  lastNmFrStgNm = stageName.substring(0, stageName.indexOf(','));
                  // First name will be anything after the second comma
                  firstNmFrStgNm = nmAfterFirstComma.substring(checkSecondComma + 1);
                } else if (idLocSpaceBeforeComma > 0) {
                  // Compare the location of the space and comma
                  if (idLocSpaceBeforeComma < stageName.indexOf(',')) {
                    lastNmFrStgNm = stageName.substring(0, idLocSpaceBeforeComma);
                    firstNmFrStgNm = stageName.substring(stageName.indexOf(',') + 1);
                  }
                } else {
                  // This is condition for the comparison between normal stage name with first and last name only
                  // and person name with some variations (i.e. having middle initial, space, suffix, etc.)
                  lastNmFrStgNm = stageName.substring(0, stageName.indexOf(','));
                  firstNmFrStgNm = stageName.substring(stageName.indexOf(',') + 1);
                }
              }
              
              // Find the person with the same last name and first name as in the stage name
              Person personWithSimilarStgNm = personDAO.findPersonByFirstNameLastName(firstNmFrStgNm, lastNmFrStgNm);
              if (personWithSimilarStgNm != null) {
                idPrimaryCaretaker = personWithSimilarStgNm.getIdPerson();
              }                        
            }
          }
        }

        // Set PK in the returning map if single PK exists
        if (!noPrimaryCaretaker && !multiPrimaryCaretaker) {
          // Set the Relationship that is used for mapping through STAGE_PERS_REL_MAP_CUSTODY table
          // The Relationship is based on the relationship of the removal child to the Primary Caretaker
          Person personPK = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRelInt(idRemovalStage,
                                                                                               CodesTables.CRELVICT_PK);
          if (personPK != null) {
            idPrimaryCaretaker = personPK.getIdPerson();
          }
        }

        if (idPrimaryCaretaker > 0) {
          // Single PK has been set
          // Do the rest of the mapping
          // Find the relationship for the overall mapping
          cdStagePersRelPKForPrincipals = checkCdStagePersRelPK(idRemovalStage, idChild);

          // Check for the Spouse if single Spouse exists
          // Get the Gender of the PK to determine the opposite Gender for the Spouse
          // Only Male and Female will be validated for Gender because Unknown Gender will not be included
          // in the Principals list because of the new message MSG_UNKNOWN_GENDER_WARN
          StagePersonLink singlePK = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(idPrimaryCaretaker,
                                                                                                idRemovalStage);

          // Find Gender of Spouse based on the Gender of PK
          String genderSpouse = MALE.equals(singlePK.getPerson().getCdPersonSex()) ? FEMALE : MALE;

          // Find all Spouses in the stage regardless of Gender
          // Check for the Type as Principal only; Spouse can be either Principal or Collateral
          // but only Principal is used for this relationship mapping
          List<StagePersonLink> stagePersonLinkListSpouse = stagePersonLinkDAO
                                                                              .findStagePersonLinkByIdStageCdStagePersTypeCdStagePersRelInt(
                                                                                                                                            idRemovalStage,
                                                                                                                                            CodesTables.CPRSNTYP_PRN,
                                                                                                                                            CodesTables.CRELVICT_SP);

          // If multiple Spouses exist, loop through to validate the relationship of each person
          if (stagePersonLinkListSpouse != null) {
            if (stagePersonLinkListSpouse.size() == 1) {
              // One Spouse exists in the stage
              String relationshipInCpSection = "";
              Person personSpouse = stagePersonLinkListSpouse.get(0).getPerson();
              if (genderSpouse.equals(personSpouse.getCdPersonSex())) {
                // Check for the C/P section first
                relationshipInCpSection = checkIfCpSectionExists(idRemovalStage, personSpouse.getIdPerson(), idChild);
                if (relationshipInCpSection != null && !"".equals(relationshipInCpSection)) {
                  // Set the relationship of Spouse as in the C/P section
                  principaListMap.put(personSpouse.getIdPerson(), relationshipInCpSection);
                  // Put the relationship to a Map that holds the current stage's relationship
                  stagePersonLinkInfoDynamicOldRel.put(personSpouse.getIdPerson(),
                                                       stagePersonLinkListSpouse.get(0).getCdStagePersRelInt());
                } else {
                  // Send the correct Spouse to the mapping table to get the relationship based on the
                  // cdStagePersRelPKForPrincipals

                  // In the relationship mapping table, there are only three conditions
                  // that Gender of the person determined the relationship:
                  // 1. cdStagePersRelPKForPrincipals = PARENT and cdStagePersRelInt = Spouse
                  // 2. cdStagePersRelPKForPrincipals = SIBLING and cdStagePersRelInt = Absent Parent
                  // 3. cdStagePersRelPKForPrincipals = SIBLING and cdStagePersRelInt = Parent
                  // So check the condition 1 for Spouse first
                  String cdRelFromMapping = "";
                  if (PARENT.equals(cdStagePersRelPKForPrincipals)) {
                    // Find the relationship mapping based on Gender
                    cdRelFromMapping = stagePersRelMapCustodyDAO
                                                                .findRelationshipByCdStagePersRelPkCdStagePersRelCurrStageCdPersonGender(
                                                                                                                                         cdStagePersRelPKForPrincipals,
                                                                                                                                         stagePersonLinkListSpouse
                                                                                                                                                                  .get(
                                                                                                                                                                       0)
                                                                                                                                                                  .getCdStagePersRelInt(),
                                                                                                                                         personSpouse
                                                                                                                                                     .getCdPersonSex());
                  } else {
                    // Find the relationship mapping without Gender involved
                    cdRelFromMapping = stagePersRelMapCustodyDAO
                                                                .findRelationshipByCdStagePersRelPkCdStagePersRelCurrStage(
                                                                                                                           cdStagePersRelPKForPrincipals,
                                                                                                                           stagePersonLinkListSpouse
                                                                                                                                                    .get(
                                                                                                                                                         0)
                                                                                                                                                    .getCdStagePersRelInt());
                  }

                  // Put the correct Spouse to the returning map
                  principaListMap.put(personSpouse.getIdPerson(), cdRelFromMapping);
                  // Put the relationship to a Map that holds the current stage's relationship
                  stagePersonLinkInfoDynamicOldRel.put(personSpouse.getIdPerson(),
                                                       stagePersonLinkListSpouse.get(0).getCdStagePersRelInt());
                }
              } 
              // STGAP00017187: MR-095
              // This is the condition when single Spouse exists but the Spouse has the same Gender as PK
              // so the relationship for the Spouse needs to be set as 'Other Non-related person'
              else {
                // Check for the C/P section first
                relationshipInCpSection = checkIfCpSectionExists(idRemovalStage, personSpouse.getIdPerson(),
                                                                 idChild);
                if (relationshipInCpSection != null && !"".equals(relationshipInCpSection)) {
                  // Set the relationship of Spouse as in the C/P section
                  principaListMap.put(personSpouse.getIdPerson(), relationshipInCpSection);
                  // Put the relationship to a Map that holds the current stage's relationship
                  stagePersonLinkInfoDynamicOldRel.put(personSpouse.getIdPerson(),
                                                       stagePersonLinkListSpouse.get(0).getCdStagePersRelInt());
                } else {
                  // Put the additional Spouse(s) to the returning map with Relationship of "Other Non-related person"
                  principaListMap.put(personSpouse.getIdPerson(), OTHER_NON_RELATED_PERSON);
                  // Put the relationship to a Map that holds the current stage's relationship
                  stagePersonLinkInfoDynamicOldRel.put(personSpouse.getIdPerson(),
                                                       stagePersonLinkListSpouse.get(0).getCdStagePersRelInt());
                }                
              }
              // End STGAP00017187: MR-095 
            } else if (stagePersonLinkListSpouse.size() > 1) {
              // Multiple Spouses exist
              // Set the relationship as 'Other Non-related person' for multiple Spouses
              // without checking each person has correct Gender for Spouse or not
              Iterator<StagePersonLink> it = stagePersonLinkListSpouse.iterator();
              while (it.hasNext()) {
                StagePersonLink stagePersonLink = it.next();
                String relationshipInCpSection = "";
                Person personEachSpouse = stagePersonLink.getPerson();

                // Check for the C/P section first
                relationshipInCpSection = checkIfCpSectionExists(idRemovalStage, personEachSpouse.getIdPerson(),
                                                                 idChild);
                if (relationshipInCpSection != null && !"".equals(relationshipInCpSection)) {
                  // Set the relationship of Spouse as in the C/P section
                  principaListMap.put(personEachSpouse.getIdPerson(), relationshipInCpSection);
                  // Put the relationship to a Map that holds the current stage's relationship
                  stagePersonLinkInfoDynamicOldRel.put(personEachSpouse.getIdPerson(),
                                                       stagePersonLink.getCdStagePersRelInt());
                } else {
                  // Put the additional Spouse(s) to the returning map with Relationship of "Other Non-related person"
                  principaListMap.put(personEachSpouse.getIdPerson(), OTHER_NON_RELATED_PERSON);
                  // Put the relationship to a Map that holds the current stage's relationship
                  stagePersonLinkInfoDynamicOldRel.put(personEachSpouse.getIdPerson(),
                                                       stagePersonLink.getCdStagePersRelInt());
                }
              }
            }
          }

          // Check whether PK has relationship set up in the C/P section
          // Otherwise, set PK in the returning map based on the
          // Check for the C/P section first
          String relationshipInCpSection = "";
          relationshipInCpSection = checkIfCpSectionExists(idRemovalStage, singlePK.getPerson().getIdPerson(), idChild);
          if (relationshipInCpSection != null && !"".equals(relationshipInCpSection)) {
            // Set the relationship of PK as in the C/P section
            principaListMap.put(singlePK.getPerson().getIdPerson(), relationshipInCpSection);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(singlePK.getPerson().getIdPerson(), singlePK.getCdStagePersRelInt());
          } else {
            // Set PK in the returning map with Relationship based on cdStagePersRelPKForPrincipals
            // PK relationship needs to set explicitly in here; mapping table contains
            // mapping for multiple PK values only
            String relationshipPK = "";
            if (PARENT.equals(cdStagePersRelPKForPrincipals)) {
              if (FEMALE.equals(singlePK.getPerson().getCdPersonSex())) {
                relationshipPK = CodesTables.CRELVICT_BM;
              } else if (MALE.equals(singlePK.getPerson().getCdPersonSex())) {
                relationshipPK = CodesTables.CRELVICT_BF;
              }
            } else if (GRANDPARENT.equals(cdStagePersRelPKForPrincipals)) {
              relationshipPK = CodesTables.CRELVICT_GP;
            } else if (AUNT_UNCLE.equals(cdStagePersRelPKForPrincipals)) {
              relationshipPK = CodesTables.CRELVICT_AU;
            } else if (COUSIN.equals(cdStagePersRelPKForPrincipals)) {
              relationshipPK = CodesTables.CRELVICT_CO;
            } else if (SIBLING.equals(cdStagePersRelPKForPrincipals)) {
              relationshipPK = CodesTables.CRELVICT_SB;
            } else if (NON_RELATED.equals(cdStagePersRelPKForPrincipals)) {
              // If the relationship of PK to removal child cannot be determined,
              // PK's relationship is 'Other'
              relationshipPK = CodesTables.CRELVICT_XX;
            }

            principaListMap.put(singlePK.getPerson().getIdPerson(), relationshipPK);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(singlePK.getPerson().getIdPerson(), singlePK.getCdStagePersRelInt());
          }

          // Remove all people from stagePersonLinkInfo whose relationship is set via this section
          // Loop through principaListMap
          Iterator<Map> itSPL = stagePersonLinkInfo.iterator();
          while (itSPL.hasNext()) {
            Map stagePersonLinkMap = itSPL.next();
            if (principaListMap.containsKey(stagePersonLinkMap.get("idPersonPrincipal"))) {
              itSPL.remove();
              stagePersonLinkInfo.remove(stagePersonLinkMap);
            }
          }
        } else if (idPrimaryCaretaker == 0) {
          // If no PK and no person with the stage name found, set cdStagePersRelPKForPrincipals as Non-Related
          // and send all persons in the removal stage to the C/P section check then the relationship mapping
          cdStagePersRelPKForPrincipals = NON_RELATED;
        }

        // Look up the Caregiver/Parental Relationship Information for Child section
        // Identify and populate the ‘most likely’ relationship using the section
        // on the removal child’s Person Detail page
        Map<Integer, String> splListFromCPSectionCheck = caregiverParentalSectionCheck(
                                                                                       stagePersonLinkInfo,
                                                                                       stagePersonLinkInfoDynamicOldRel,
                                                                                       idRemovalStage, idChild);

        // Set the relationship for all remaining people using the mapping table
        // and remove all remaining people from stagePersonLinkInfo
        Map<Integer, String> splListFromRelMapping = relationshipMapping(stagePersonLinkInfo,
                                                                         stagePersonLinkInfoDynamicOldRel,
                                                                         idRemovalStage, idChild,
                                                                         cdStagePersRelPKForPrincipals);

        // Get map with final relationship set for new stage by adding all the maps returned from methods
        Iterator itFinal1 = splListFromCPSectionCheck.entrySet().iterator();
        while (itFinal1.hasNext()) {
          Map.Entry entry = (Map.Entry) itFinal1.next();
          int idPrn = (Integer) entry.getKey();
          String cdRel = (String) entry.getValue();
          principaListMap.put(idPrn, cdRel);
        }

        Iterator itFinal2 = splListFromRelMapping.entrySet().iterator();
        while (itFinal2.hasNext()) {
          Map.Entry entry = (Map.Entry) itFinal2.next();
          int idPrn = (Integer) entry.getKey();
          String cdRel = (String) entry.getValue();
          principaListMap.put(idPrn, cdRel);
        }

        // Set up ROWCSUB80SOG00_ARRAY
        // For displaying the same sort in 'Foster Care Principals List for FCC Stage' section
        // as in 'Persons Living In Home at Removal' section on the Custody
        // stagePersonLinkInfoForSort is used here
        ROWCSUB80SOG00_ARRAY rowcsub80sog00_array = new ROWCSUB80SOG00_ARRAY();
        int size = principaListMap.size();
        rowcsub80sog00_array.setUlRowQty(size);
        Iterator<Map> itSPLSort = stagePersonLinkInfoForSort.iterator();
        while (itSPLSort.hasNext()) {
          Map stagePersonLinkMap = itSPLSort.next();
          for (Iterator it = principaListMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            int idPersonPrincipal = (Integer) entry.getKey();

            if (idPersonPrincipal == (Integer) stagePersonLinkMap.get("idPersonPrincipal")) {
              ROWCSUB80SOG00 rowcsub80sog00 = new ROWCSUB80SOG00();
              rowcsub80sog00.setUlIdPersonPrincipal((Integer) entry.getKey() != null ? (Integer) entry.getKey() : 0);

              Person person = personDAO.findPersonByIdPerson(idPersonPrincipal);
              if (person == null) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
              rowcsub80sog00.setSzNmPersonFull(person.getNmPersonFull());

              rowcsub80sog00.setSzCdStagePersRelInt((String) entry.getValue());
              rowcsub80sog00_array.addROWCSUB80SOG00(rowcsub80sog00);
            }
          }
          csub80so.setROWCSUB80SOG00_ARRAY(rowcsub80sog00_array);
        }
      }

      // 2. Stage progression from FCF -> FCC
      // Relationship mapping will not make determinations in this scenario
      // Persons listed in the FCF Person List will carry over in the new FCC stage Person List
      // except Self in the FCF stage and any person(s) selected in the C/P section on the Person Detail
      else if (CodesTables.CSTAGES_FSU.equals(cdStage) && idChild != 0) {
        Map<Integer, String> principaListMap = new HashMap<Integer, String>();

        // Swap relationship of removal children identified as Self in the FCF
        // For instance, if the removal child is listed as Cousin in the FCF stage,
        // prior to removal, children identified as Self in the FCF stage
        // will become Cousin in the new FCC stage
        List<StagePersonLink> splFccChildren = stagePersonLinkDAO
                                                                 .findAllChildrenFCCStagesByIdCaseByStage(idCase,
                                                                                                          idRemovalStage);

        if (splFccChildren != null && splFccChildren.size() > 0) {
          StagePersonLink splRemovalChild = stagePersonLinkDAO.findStagePersonLinkByIdStageByIdPerson(idRemovalStage,
                                                                                                      idChild);
          String cdRelRemovalChild = splRemovalChild.getCdStagePersRelInt();
          Iterator<StagePersonLink> it = splFccChildren.iterator();
          while (it.hasNext()) {
            StagePersonLink splFccChild = it.next();
            Person fccChild = splFccChild.getPerson();
            if (CodesTables.CRELVICT_SL.equals(splFccChild.getCdStagePersRelInt())) {
              // Swap relationship of removal children identified as Self in the FCF
              principaListMap.put(fccChild.getIdPerson(), cdRelRemovalChild);
              // Put the relationship to a Map that holds the current stage's relationship
              stagePersonLinkInfoDynamicOldRel.put(fccChild.getIdPerson(), splFccChild.getCdStagePersRelInt());
            } else {
              // Keep the relationship from current stage
              principaListMap.put(fccChild.getIdPerson(), splFccChild.getCdStagePersRelInt());
              // Put the relationship to a Map that holds the current stage's relationship
              stagePersonLinkInfoDynamicOldRel.put(fccChild.getIdPerson(), splFccChild.getCdStagePersRelInt());
            }
          }
        }
        // Remove all people from stagePersonLinkInfo whose relationship is set via this section
        // Loop through principaListMap
        Iterator<Map> itSPL = stagePersonLinkInfo.iterator();
        while (itSPL.hasNext()) {
          Map stagePersonLinkMap = itSPL.next();
          if (principaListMap.containsKey(stagePersonLinkMap.get("idPersonPrincipal"))) {
            itSPL.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        }

        // Set the relationship for Primary Caretaker, Self and Self/Minor Parent
        // by sending them to the relationship mapping
        Map<Integer, String> splListForPkSlSm = setRelForSelfAndSelfMinorParentAndPk(stagePersonLinkInfo,
                                                                                     stagePersonLinkInfoDynamicOldRel);

        // Set the relationship for all remaining people carrying over current relationship
        // and remove all remaining people from stagePersonLinkInfo
        Map<Integer, String> splListCopyCurrRelWithoutMapping = copyCurrRelWithoutRelationshipMapping(
                                                                                                      stagePersonLinkInfo,
                                                                                                      stagePersonLinkInfoDynamicOldRel);

        // Get map with final relationship set for new stage by adding all the maps returned from methods
        Iterator itFinal1 = splListForPkSlSm.entrySet().iterator();
        while (itFinal1.hasNext()) {
          Map.Entry entry = (Map.Entry) itFinal1.next();
          int idPrn = (Integer) entry.getKey();
          String cdRel = (String) entry.getValue();
          principaListMap.put(idPrn, cdRel);
        }

        Iterator itFinal2 = splListCopyCurrRelWithoutMapping.entrySet().iterator();
        while (itFinal2.hasNext()) {
          Map.Entry entry = (Map.Entry) itFinal2.next();
          int idPrn = (Integer) entry.getKey();
          String cdRel = (String) entry.getValue();
          principaListMap.put(idPrn, cdRel);
        }

        // Set up ROWCSUB80SOG00_ARRAY
        // For displaying the same sort in 'Foster Care Principals List for FCC Stage' section
        // as in 'Persons Living In Home at Removal' section on the Custody
        // stagePersonLinkInfoForSort is used here
        ROWCSUB80SOG00_ARRAY rowcsub80sog00_array = new ROWCSUB80SOG00_ARRAY();
        int size = principaListMap.size();
        rowcsub80sog00_array.setUlRowQty(size);
        Iterator<Map> itSPLSort = stagePersonLinkInfoForSort.iterator();
        while (itSPLSort.hasNext()) {
          Map stagePersonLinkMap = itSPLSort.next();
          for (Iterator it = principaListMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            int idPersonPrincipal = (Integer) entry.getKey();

            if (idPersonPrincipal == (Integer) stagePersonLinkMap.get("idPersonPrincipal")) {
              ROWCSUB80SOG00 rowcsub80sog00 = new ROWCSUB80SOG00();
              rowcsub80sog00.setUlIdPersonPrincipal((Integer) entry.getKey() != null ? (Integer) entry.getKey() : 0);

              Person person = personDAO.findPersonByIdPerson(idPersonPrincipal);
              if (person == null) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
              rowcsub80sog00.setSzNmPersonFull(person.getNmPersonFull());

              rowcsub80sog00.setSzCdStagePersRelInt((String) entry.getValue());
              rowcsub80sog00_array.addROWCSUB80SOG00(rowcsub80sog00);
            }
          }
          csub80so.setROWCSUB80SOG00_ARRAY(rowcsub80sog00_array);
        }
      }
    }
    
    return csub80so;
  }
  
  private String checkCdStagePersRelPK(int idRemovalStage, int idChild) {
    String cdStagePersRelPK = "";

    // Find stage person record of child
    StagePersonLink stagePersonLinkChild = stagePersonLinkDAO.findStagePersonLinkByIdStageByIdPerson(idRemovalStage,
                                                                                                     idChild);

    if (stagePersonLinkChild != null) {
      // if removal child is Son or Daughter, cdStagePersRelPK is Parent
      if (stagePersonLinkChild.getCdStagePersRelInt().equals(CodesTables.CRELVICT_SO)
          || stagePersonLinkChild.getCdStagePersRelInt().equals(CodesTables.CRELVICT_DA)) {
        cdStagePersRelPK = PARENT;
      }
      // if removal child is Grandchild, cdStagePersRelPK is Grandparent
      else if (stagePersonLinkChild.getCdStagePersRelInt().equals(CodesTables.CRELVICT_GC)) {
        cdStagePersRelPK = GRANDPARENT;
      }
      // if removal child is Niece/Nephew, cdStagePersRelPK is Aunt/Uncle
      else if (stagePersonLinkChild.getCdStagePersRelInt().equals(CodesTables.CRELVICT_NN)) {
        cdStagePersRelPK = AUNT_UNCLE;
      }
      // if removal child is First Cousin, cdStagePersRelPK is Cousin
      // STGAP00017663 Added First Cousin Once Removed (CRELVICT_FC) to this category also
      else if (stagePersonLinkChild.getCdStagePersRelInt().equals(CodesTables.CRELVICT_CO)
                      || stagePersonLinkChild.getCdStagePersRelInt().equals(CodesTables.CRELVICT_FC)) {
        cdStagePersRelPK = COUSIN;
      }
      // if removal child is Sibling or Biological Sibling, cdStagePersRelPK is Sibling
      else if (stagePersonLinkChild.getCdStagePersRelInt().equals(CodesTables.CRELVICT_SB)
               || stagePersonLinkChild.getCdStagePersRelInt().equals(CodesTables.CRELVICT_BS)) {
        cdStagePersRelPK = SIBLING;
      }
      // if removal child has the other Relationships other than specified above cdStagePersRelPK is Non Related
      else {
        cdStagePersRelPK = NON_RELATED;
      }
    }
    return cdStagePersRelPK;
  }

  private String checkIfCpSectionExists(int idRemovalStage, int idPerson, int idChild) {
    String cpSectionValue = "";
    
    List<String> cdPersonRelationshipMother = new ArrayList<String>();
    cdPersonRelationshipMother.add(BIOLOGICAL_MOTHER);
    cdPersonRelationshipMother.add(LEGAL_MOTHER);

    List<String> cdPersonRelationshipFather = new ArrayList<String>();
    cdPersonRelationshipFather.add(BIOLOGICAL_FATHER);
    cdPersonRelationshipFather.add(LEGAL_FATHER);
    cdPersonRelationshipFather.add(PUTATIVE_FATHER);

    // Find the Mother type from the Caregiver/Parental Relationship Information for Child section
    List<Relationship> relatedPersonListMother = relationshipDAO
                                                                .findRelationshipByIdChildByIdRelatedPersonByCdPersonRelationship(
                                                                                                                                  idChild,
                                                                                                                                  idPerson,
                                                                                                                                  cdPersonRelationshipMother);
    
    if (relatedPersonListMother != null && !relatedPersonListMother.isEmpty()) {
      if (relatedPersonListMother.size() == 1) {
        // Get the dropdown value selected
        cpSectionValue = relatedPersonListMother.get(0).getCdPersonRelationship();
      } else if (relatedPersonListMother.size() > 1) {
        Iterator<Relationship> it = relatedPersonListMother.iterator();
        boolean isBM = false;
        boolean isLM = false;
        while (it.hasNext()) {
          Relationship relationship = it.next();
          // Check for the relationship hierarchy among Mother types
          // If a person is selected in the multiple Mother type dropdown on the C/P section
          // Biological Mother takes precedence over Legal Mother
          if (relationship.getCdPersonRelationship().equals(BIOLOGICAL_MOTHER)) {
            isBM = true;
          } else if (relationship.getCdPersonRelationship().equals(LEGAL_MOTHER)) {
            isLM = true;
          } 
        }
        if (isBM) {
          cpSectionValue = BIOLOGICAL_MOTHER;
        } else if (!isBM && isLM) {
          cpSectionValue = LEGAL_MOTHER;
        }
      }
    }
    
    // Find the Father type from the Caregiver/Parental Relationship Information for Child section
    List<Relationship> relatedPersonListFather = relationshipDAO.findRelationshipByIdChildByIdRelatedPersonByCdPersonRelationship(
                                                                                                                             idChild,
                                                                                                                             idPerson,
                                                                                                                             cdPersonRelationshipFather);

    if (relatedPersonListFather != null && !relatedPersonListFather.isEmpty()) {
      if (relatedPersonListFather.size() == 1) {
        // Get the dropdown value selected
        cpSectionValue = relatedPersonListFather.get(0).getCdPersonRelationship();
      } else if (relatedPersonListFather.size() > 1) {
        Iterator<Relationship> it = relatedPersonListFather.iterator();
        boolean isBF = false;
        boolean isLF = false;
        boolean isPF = false;
        while (it.hasNext()) {
          Relationship relationship = it.next();
          // Check for the relationship hierarchy among Father types
          // If a person is selected in the multiple Father type dropdown on the C/P section
          // Biological Father takes precedence over Legal Father
          // and Legal Father takes precedence over Putative Father
          if (relationship.getCdPersonRelationship().equals(BIOLOGICAL_FATHER)) {
            isBF = true;
          } else if (relationship.getCdPersonRelationship().equals(LEGAL_FATHER)) {
            isLF = true;
          } else if (relationship.getCdPersonRelationship().equals(PUTATIVE_FATHER)) {
            isPF = true;
          }
        }
        if (isBF) {
          cpSectionValue = BIOLOGICAL_FATHER;
        } else if (!isBF && isLF) {
          cpSectionValue = LEGAL_FATHER;
        }
      }
    }
    
    return cpSectionValue;
  }
  
  /**
   * Look up the Caregiver/Parental Relationship Information for Child section This method identifies and populates the
   * ‘most likely’ relationship using the section on the removal child’s Person Detail page and returns to a List of
   * StagePersonLink with the people not listed in the section so that the next check can loop through only people
   * without the relationship defined
   * 
   * @param stagePersonLinkInfo
   * @param stagePersonLinkInfoDynamicOldRel
   * @param idRemovalStage
   * @param idChild
   */
  private Map<Integer, String> caregiverParentalSectionCheck(List<Map> stagePersonLinkInfo,
                                                             Map<Integer, String> stagePersonLinkInfoDynamicOldRel,
                                                             int idRemovalStage, int idChild) {

    Map<Integer, String> principaListMap = new HashMap<Integer, String>();

    List<String> cdPersonRelationshipMother = new ArrayList<String>();
    cdPersonRelationshipMother.add(BIOLOGICAL_MOTHER);
    cdPersonRelationshipMother.add(LEGAL_MOTHER);

    List<String> cdPersonRelationshipFather = new ArrayList<String>();
    cdPersonRelationshipFather.add(BIOLOGICAL_FATHER);
    cdPersonRelationshipFather.add(LEGAL_FATHER);
    cdPersonRelationshipFather.add(PUTATIVE_FATHER);

    // Find the Mother type from the Caregiver/Parental Relationship Information for Child section
    List<Relationship> relatedPersonListMother = relationshipDAO
                                                                .findIdRelatedPersonByIdStageByIdChildByCdPersonRelationship(
                                                                                                                             idRemovalStage,
                                                                                                                             idChild,
                                                                                                                             cdPersonRelationshipMother);

    if (relatedPersonListMother != null && !relatedPersonListMother.isEmpty()) {
      Iterator<Relationship> it = relatedPersonListMother.iterator();
      boolean isBMFound = false;
      boolean isLMFound = false;
      int idBM = 0;
      int idLM = 0;
      while (it.hasNext()) {
        Relationship relationship = it.next();
        // Loop through the SPL to check for multiple relationships are selected for a person
        Iterator<Map> itSPL = stagePersonLinkInfo.iterator();
        while (itSPL.hasNext()) {
          // Check for the relationship hierarchy among Mother types
          // If a person is selected in the multiple Mother type dropdowns on the C/P section
          // Biological Mother takes precedence over Legal Mother
          Map stagePersonLinkMap = itSPL.next();
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(
                                                                 relationship.getPersonByIdRelatedPerson()
                                                                             .getIdPerson())) {
            if (relationship.getCdPersonRelationship().equals(BIOLOGICAL_MOTHER)) {
              isBMFound = true;
              idBM = relationship.getPersonByIdRelatedPerson().getIdPerson();
            } else if (relationship.getCdPersonRelationship().equals(LEGAL_MOTHER)) {
              isLMFound = true;
              idLM = relationship.getPersonByIdRelatedPerson().getIdPerson();
            }
          }
        }
      }

      // Loop through the same map again for setting relationship and removing person from the stagePersonLinkInfo
      Iterator<Map> itSPLForSetRelM = stagePersonLinkInfo.iterator();
      while (itSPLForSetRelM.hasNext()) {
        Map stagePersonLinkMap = itSPLForSetRelM.next();
        if (isBMFound && isLMFound && idBM == idLM) {
          // Single person is selected as both BM and LM; BM needs to be selected per hierarchy
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBM)) {
            principaListMap.put(idBM, BIOLOGICAL_MOTHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBM, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelM.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBMFound && isLMFound && idBM != idLM) {
          // Two person are selected each as BM and LM; Both BM and LM need to be selected for two different Principals
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBM)) {
            principaListMap.put(idBM, BIOLOGICAL_MOTHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBM, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelM.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          } else if (stagePersonLinkMap.get("idPersonPrincipal").equals(idLM)) {
            principaListMap.put(idLM, LEGAL_MOTHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idLM, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelM.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBMFound && !isLMFound) {
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBM)) {
            principaListMap.put(idBM, BIOLOGICAL_MOTHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBM, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelM.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (!isBMFound && isLMFound) {
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idLM)) {
            principaListMap.put(idLM, LEGAL_MOTHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idLM, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelM.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        }
      }
    }
    
    // Find the Father type from the Caregiver/Parental Relationship Information for Child section
    List<Relationship> relatedPersonListFather = relationshipDAO
                                                                .findIdRelatedPersonByIdStageByIdChildByCdPersonRelationship(
                                                                                                                             idRemovalStage,
                                                                                                                             idChild,
                                                                                                                             cdPersonRelationshipFather);

    if (relatedPersonListFather != null && !relatedPersonListFather.isEmpty()) {
      Iterator<Relationship> it = relatedPersonListFather.iterator();
      boolean isBFFound = false;
      boolean isLFFound = false;
      boolean isPFFound = false;
      int idBF = 0;
      int idLF = 0;
      int idPF = 0;
      while (it.hasNext()) {
        Relationship relationship = it.next();
        // Loop through the SPL to check for multiple relationships are selected for a person
        Iterator<Map> itSPL = stagePersonLinkInfo.iterator();
        while (itSPL.hasNext()) {
          // Check for the relationship hierarchy among Father types
          // If a person is selected in the multiple Father type dropdown on the C/P section
          // Biological Father takes precedence over Legal Father
          // and Legal Father takes precedence over Putative Father
          Map stagePersonLinkMap = itSPL.next();
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(
                                                                 relationship.getPersonByIdRelatedPerson()
                                                                             .getIdPerson())) {
            if (relationship.getCdPersonRelationship().equals(BIOLOGICAL_FATHER)) {
              isBFFound = true;
              idBF = relationship.getPersonByIdRelatedPerson().getIdPerson();
            } else if (relationship.getCdPersonRelationship().equals(LEGAL_FATHER)) {
              isLFFound = true;
              idLF = relationship.getPersonByIdRelatedPerson().getIdPerson();
            } else if (relationship.getCdPersonRelationship().equals(PUTATIVE_FATHER)) {
              isPFFound = true;
              idPF = relationship.getPersonByIdRelatedPerson().getIdPerson();
            }
          }
        }
      }
        
        // Loop through the same map again for setting relationship and removing person from the stagePersonLinkInfo
      Iterator<Map> itSPLForSetRelF = stagePersonLinkInfo.iterator();
      while (itSPLForSetRelF.hasNext()) {
        Map stagePersonLinkMap = itSPLForSetRelF.next();
        if (isBFFound && isLFFound && isPFFound && idBF == idLF && idLF == idPF) {
          // Single person is selected for all three Father types, BM, LM and PF;
          // BM needs to be selected per hierarchy
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBFFound && isLFFound && isPFFound && idBF == idLF && idLF != idPF) {
          // One person is selected as both BF and LF and another person is selected as PF;
          // BF needs to be selected for the first person
          // and PF needs to be selected for the second person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          } else if (stagePersonLinkMap.get("idPersonPrincipal").equals(idPF)) {
            principaListMap.put(idPF, PUTATIVE_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idPF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBFFound && isLFFound && isPFFound && idBF != idLF && idLF == idPF) {
          // One person is selected as both LF and PF and another person is selected as BF;
          // LF needs to be selected for the first person
          // and BF needs to be selected for the second person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          } else if (stagePersonLinkMap.get("idPersonPrincipal").equals(idLF)) {
            principaListMap.put(idLF, LEGAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idLF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBFFound && isLFFound && isPFFound && idBF != idLF && idBF == idPF) {
          // One person is selected as both BF and PF and one person is selected as LF;
          // BF needs to be selected for the first person
          // and LF needs to be selected for the second person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          } else if (stagePersonLinkMap.get("idPersonPrincipal").equals(idLF)) {
            principaListMap.put(idLF, LEGAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idLF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBFFound && isLFFound && !isPFFound && idBF == idLF) {
          // One person is selected as both BF and LF;
          // BM needs to be selected per hierarchy
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (!isBFFound && isLFFound && isPFFound && idLF == idPF) {
          // One person is selected as both LF and PF;
          // LF needs to be selected per hierarchy
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idLF)) {
            principaListMap.put(idLF, LEGAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idLF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBFFound && !isLFFound && isPFFound && idBF == idPF) {
          // One person is selected as both BF and PF;
          // BF needs to be selected per hierarchy
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBFFound && isLFFound && !isPFFound && idBF != idLF) {
          // One person is selected as BF and another person is selected as LF;
          // BF needs to be selected for the first person
          // and LF needs to be selected for the second person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          } else if (stagePersonLinkMap.get("idPersonPrincipal").equals(idLF)) {
            principaListMap.put(idLF, LEGAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idLF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (!isBFFound && isLFFound && isPFFound && idLF != idPF) {
          // One person is selected as LF and another person is selected as PF;
          // LF needs to be selected for the first person
          // and PF needs to be selected for the second person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idLF)) {
            principaListMap.put(idLF, LEGAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idLF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          } else if (stagePersonLinkMap.get("idPersonPrincipal").equals(idPF)) {
            principaListMap.put(idPF, PUTATIVE_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idPF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBFFound && !isLFFound && isPFFound && idBF != idPF) {
          // One person is selected as BF and another person is selected as PF;
          // BF needs to be selected for the first person
          // and PF needs to be selected for the second person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          } else if (stagePersonLinkMap.get("idPersonPrincipal").equals(idPF)) {
            principaListMap.put(idPF, PUTATIVE_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idPF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (isBFFound && !isLFFound && !isPFFound) {
          // One person is selected as BF;
          // BF needs to be selected for the person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idBF)) {
            principaListMap.put(idBF, BIOLOGICAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idBF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (!isBFFound && isLFFound && !isPFFound) {
          // One person is selected as LF;
          // LF needs to be selected for the person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idLF)) {
            principaListMap.put(idLF, LEGAL_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idLF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        } else if (!isBFFound && !isLFFound && isPFFound) {
          // One person is selected as PF;
          // PF needs to be selected for the person
          if (stagePersonLinkMap.get("idPersonPrincipal").equals(idPF)) {
            principaListMap.put(idPF, PUTATIVE_FATHER);
            // Put the relationship to a Map that holds the current stage's relationship
            stagePersonLinkInfoDynamicOldRel.put(idPF, (String) stagePersonLinkMap.get("cdStagePersRelInt"));
            // Remove the person from the Map once a relationship is determined
            // so that the population array becomes smaller for less loop
            itSPLForSetRelF.remove();
            stagePersonLinkInfo.remove(stagePersonLinkMap);
          }
        }
      }
    }
    return principaListMap;
  }
  
  private Map<Integer, String> relationshipMapping(List<Map> stagePersonLinkInfo,
                                                   Map<Integer, String> stagePersonLinkInfoDynamicOldRel,
                                                   int idRemovalStage, int idChild, String cdStagePersRelPKForPrincipals) {

    Map<Integer, String> principaListMap = new HashMap<Integer, String>();

    Iterator<Map> itSPL = stagePersonLinkInfo.iterator();
    while (itSPL.hasNext()) {
      Map stagePersonLinkMap = itSPL.next();
      String cdRelFromMapping = "";

      // Send Principal to the relationship mapping
      // In the relationship mapping table, there are only three conditions
      // that Gender of the person determined the relationship:
      // 1. cdStagePersRelPKForPrincipals = PARENT and cdStagePersRelInt = Spouse
      // 2. cdStagePersRelPKForPrincipals = SIBLING and cdStagePersRelInt = Absent Parent
      // 3. cdStagePersRelPKForPrincipals = SIBLING and cdStagePersRelInt = Parent
      // So check the three conditions first; if Gender is Unknown or null pass that person to else condition
      if (stagePersonLinkMap.get("cdPersonSex") != null || !UNKNOWN.equals(stagePersonLinkMap.get("cdPersonSex"))) {
        if ((CodesTables.CRELVICT_SP.equals(stagePersonLinkMap.get("cdStagePersRelInt")) && PARENT
                                                                                                  .equals(cdStagePersRelPKForPrincipals))
            || (CodesTables.CRELVICT_AB.equals(stagePersonLinkMap.get("cdStagePersRelInt")) && SIBLING
                                                                                                      .equals(cdStagePersRelPKForPrincipals))
            || (CodesTables.CRELVICT_PA.equals(stagePersonLinkMap.get("cdStagePersRelInt")) && SIBLING
                                                                                                      .equals(cdStagePersRelPKForPrincipals))) {
          // Find the relationship mapping based on Gender
          cdRelFromMapping = stagePersRelMapCustodyDAO
                                                      .findRelationshipByCdStagePersRelPkCdStagePersRelCurrStageCdPersonGender(
                                                                                                                               cdStagePersRelPKForPrincipals,
                                                                                                                               (String) stagePersonLinkMap
                                                                                                                                                          .get("cdStagePersRelInt"),
                                                                                                                               (String) stagePersonLinkMap
                                                                                                                                                          .get("cdPersonSex"));
        } else {
          // Find the relationship mapping without Gender involved
          cdRelFromMapping = stagePersRelMapCustodyDAO
                                                      .findRelationshipByCdStagePersRelPkCdStagePersRelCurrStage(
                                                                                                                 cdStagePersRelPKForPrincipals,
                                                                                                                 (String) stagePersonLinkMap
                                                                                                                                            .get("cdStagePersRelInt"));
        }
      } else {
        // Find the relationship mapping without Gender involved
        cdRelFromMapping = stagePersRelMapCustodyDAO
                                                    .findRelationshipByCdStagePersRelPkCdStagePersRelCurrStage(
                                                                                                               cdStagePersRelPKForPrincipals,
                                                                                                               (String) stagePersonLinkMap
                                                                                                                                          .get("cdStagePersRelInt"));
      }

      // Put the relationship to a Map that will be used for the new stage
      principaListMap.put((Integer) stagePersonLinkMap.get("idPersonPrincipal"), cdRelFromMapping);
      // Put the relationship to a Map that holds the current stage's relationship
      stagePersonLinkInfoDynamicOldRel.put((Integer) stagePersonLinkMap.get("idPersonPrincipal"),
                                           (String) stagePersonLinkMap.get("cdStagePersRelInt"));
      // Remove the person from the Map once a relationship is determined
      // so that the population array becomes smaller for less loop
      itSPL.remove();
      stagePersonLinkInfo.remove(stagePersonLinkMap);
    }

    return principaListMap;
  }

  // For the Custody creation in FCF stage, all the relationships in the FCF stage
  // will be carried over to the FCC stage with the exception of 
  // Primary Caretaker, Self and Self/Minor Parent
  // For the three relationships mentioned above, relationship mapping 
  // for 'Non-Related' category will be used
  // For instance, Primary Caretaker becomes 'Other', Self becomes 'Other Relative'
  // and Self/Minor Parent becomes 'Other Relative'
  private Map<Integer, String> setRelForSelfAndSelfMinorParentAndPk(
                                                                     List<Map> stagePersonLinkInfo,
                                                                     Map<Integer, String> stagePersonLinkInfoDynamicOldRel) {

    Map<Integer, String> principaListMap = new HashMap<Integer, String>();
    String cdRelFromMapping = "";

    Iterator<Map> itSPL = stagePersonLinkInfo.iterator();
    while (itSPL.hasNext()) {
      Map stagePersonLinkMap = itSPL.next();
      if (CodesTables.CRELVICT_PK.equals(stagePersonLinkMap.get("cdStagePersRelInt"))
          || CodesTables.CRELVICT_SL.equals(stagePersonLinkMap.get("cdStagePersRelInt"))
          || CodesTables.CRELVICT_SM.equals(stagePersonLinkMap.get("cdStagePersRelInt"))) {
        // Find the relationship mapping for 'Non-Related' category
        // and put the relationship to a Map that will be used for the new stage
        cdRelFromMapping = stagePersRelMapCustodyDAO
                                                    .findRelationshipByCdStagePersRelPkCdStagePersRelCurrStage(
                                                                                                               NON_RELATED,
                                                                                                               (String) stagePersonLinkMap
                                                                                                                                          .get("cdStagePersRelInt"));

        principaListMap.put((Integer) stagePersonLinkMap.get("idPersonPrincipal"), cdRelFromMapping);
        // Put the relationship to a Map that holds the current stage's relationship
        stagePersonLinkInfoDynamicOldRel.put((Integer) stagePersonLinkMap.get("idPersonPrincipal"),
                                             (String) stagePersonLinkMap.get("cdStagePersRelInt"));
        // Remove the person from the Map once a relationship is determined
        // so that the population array becomes smaller for less loop
        itSPL.remove();
        stagePersonLinkInfo.remove(stagePersonLinkMap);
      }
    }

    return principaListMap;
  }
  
  private Map<Integer, String> copyCurrRelWithoutRelationshipMapping(
                                                                     List<Map> stagePersonLinkInfo,
                                                                     Map<Integer, String> stagePersonLinkInfoDynamicOldRel) {

    Map<Integer, String> principaListMap = new HashMap<Integer, String>();

    Iterator<Map> itSPL = stagePersonLinkInfo.iterator();
    while (itSPL.hasNext()) {
      Map stagePersonLinkMap = itSPL.next();
      // Put the relationship to a Map that will be used for the new stage
      // as the same relationship from the removal stage
      principaListMap.put((Integer) stagePersonLinkMap.get("idPersonPrincipal"),
                          (String) stagePersonLinkMap.get("cdStagePersRelInt"));
      // Put the relationship to a Map that holds the current stage's relationship
      stagePersonLinkInfoDynamicOldRel.put((Integer) stagePersonLinkMap.get("idPersonPrincipal"),
                                           (String) stagePersonLinkMap.get("cdStagePersRelInt"));
      // Remove the person from the Map once a relationship is determined
      // so that the population array becomes smaller for less loop
      itSPL.remove();
      stagePersonLinkInfo.remove(stagePersonLinkMap);
    }

    return principaListMap;
  }
}
