/**
 * Created on Mar 25, 2006 at 3:32:52 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.math.BigDecimal;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

/**
 * This is the DAO class for STAGE_PERSON_LINK
 * 
 * 
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  03/04/2009  bgehlot        STGAP00012734: Added the method findIdStageByIdPersonCdStagePersRelInt().
 *  
 *  03/24/2009  bgehlot        STGAP00012833: Added method findIdCaseWorkerByIdStageAndCdStagePersRole()
 *  
 *  06/01/2009  cwells         STGAP00014023: Added the method countStageAssignedHistory() 
 *  06/12/2009  mxpatel        STGAP00012669: added the method findIdAdoStageByIdEventIdCase()
 *  06/22/2009  bgehlot        STGAP00014329: Added method findMemberPKHouseHoldFromStagePersonLinkAndPersonDtl,
 *                                            findPersonSafetyResCheckedFromStagePersonLink
 *  06/29/2009  bgehlot        STGAP00014336: Added method findIdPersonParentByIdStage
 *  07/23/2009  bgehlot        STGAP00014341: Added method findIdPersonByIdStageCdStagePersRole, deleteStagePersonLinkByIdPersonIdStage
 *  08/13/2009  eudofiah       STGAP00015065: Added method findStagePersonLinkAndPersonByidCase
 *  09/01/2009  ssubram	       STGAP00015065: Added method to implement sealed security attribute
 *  09/14/2009  bgehlot        STGAP00014598: Added method findIdCaseWorkerByIdStageAndCdStagePersRole
 *  09/17/2009  mxpatel        STGAP00014707: added method findIdOpenFccStageByIdPerson
 *  09/23/2009  mxpatel        STGAP00013963: added method findIdPersonrByIdStageAndCdStagePersRole
 *  09/27/2009  arege          STGAP00013356: Added method findPersonsByIdCaseByIdPersonsByCdPersonRoleByCdStagePersTypeByCdADOStage to find if there is an open ADO stage for the
 *                             list of persons passed to the method.
 *  09/30/2009 bgehlot         STGAP00015485: MR-056 Added two new methods findFathersMothersByIdStageByCdPersonSex,
 *                             findSecondaryCaregiverByIdStage. added cdPKHouseholdMember in insertStagePersonLink and 
 *                             updateStagePersonLink , insertStagePersonLinkWihoutIndNmStage, updateStagePersonLinkWithoutIndNmStage methods
 *  10/02/2009 hjbaptiste      STGAP00015485: Added new method findAllPrincipalsForStageInPKHshld() to retrieve the principals that are members of the
 *                             primary caretaker's household                           
 *  10/02/2009 hjbaptiste      STGAP00015485: Added new method findUnknownMbrPkHshldIdPersonByIdStageAndCdStagePersType() to retrieve any principals who are unknown
 *                             if they are members of the primary caretaker's household  
 *  10/06/2009 bgehlot         STGAP00015485: Added method updateStagePersonLinkCdPKHouseholdMember
 *  11/30/2009 bgehlot         41275 MR-057 Added method findIdPersonAndNmPersonFullFosterParentsFromStagePersonLinkAndPerson
 *  12/09/2009 ssubram         findStagePersonLinkWithAssignedIPL has been added for Case Watch.
 *  12/15/2009 cwells          38677- copying side of family infromation when creating a new stage. 
 *  02/10/2010 wjcochran       SMS $44832 - Added method findAllPrincipalsForStageInPKHshldNull for retrieving
 *                             all principals without a value stored for "Member of Primary Caretaker's Household"  
 *  03/18/2010 bgehlot         SMS#45718 Changed the method names and queries to return results for stage rather than case for FPR.
 *  04/19/2010 mxpatel         SMS#42493:  Added method deleteStagePersonLinkFromStage
 *  04/27/2010 bgehlot         MR-064: Changed the method name and query to pre-populate children under the age of 18 
 *                                     that are members of the primary caretaker's household. for FPR.
 *  09/28/2010 hnguyen         SMS#73860 Added countStagePersonLinkForOpenStagesByIdPerson method
 *  10/01/2010 wjcochran       SMS#65873: Added method getStagePersonLinkForAPersonAndIdCaseAndCdStage
 *  11/19/2010 schoi           SMS #81140: MR-074 Added method findIdPersonByIdStageAndCdStagePersRelInt(int, List<String>)
 *  11/24/2010 arege           SMS#82989/65873: Added method findLatestStagePersonLinkByIdCaseByIdPersosByCdStage to find latest 
 *                             stagepersonlink record for given cdStage , person id and caseid
 *  12/01/2010 schoi           SMS #81140: MR-074 Updated name of the method from findIdPersonByIdStageAndCdStagePersRelInt(int, List<String>)  
 *                             to findStagePersonLinkByIdStageAndCdStagePersRelInt (int, List<String>) and added @SuppressWarnings("unchecked")
 *                             to suppress warning
 *  02/18/2011 htvo            SMS#97845 MR-074-2: added countStagePersonLinkByIdStageCdStagePersRelInt       
 *  06/03/2011 hnguyen         SMS#109407: MR-087 Added findStagePersonLinkByIdStageAndCdStagePersRole. 
 *  06/10/2011 hjbaptiste      SMS#109631: CAPTA 4.3: Special Investigation - Added findSUBCaseManagerByIdChild     
 *  06/06/2011 Corey Harden    SMS#109636  Added method findStagePersonLinkByidPersons(List<Integer> idPersonList)                                        
 *  09/07/2011 schoi           STGAP00017013: MR-095 Added new method insertStagePersonLinkAddedFromAddPersonToActiveStages
 *  09/12/2011 hnguyen         STGAP00017011: MR-092 Added new method findPriorAdoptionIdStage and findPriorAdoptionIdPerson
 *  09/13/2011 hnguyen         STGAP00017011: MR-092 Added new method findPrincipalChildrenOpenAdoStagePersonLinkInAnotherCaseByPcIdAdoStageByPcIdPerson
 *  09/13/2011 schoi           STGAP00017013: MR-095 Added new method findPersonByIdStageByCdStagePersRelInt
 *  09/20/2011 schoi           STGAP00017013: MR-095 Added new method findStagePersonLinkExcludingIdPerson
 *  09/23/2011 hnguyen         STGAP00017011: MR-092 Removed findPriorAdoptionIdPersonIdAdoStage and findPriorAdoptionIdPerson method.
 *                             Added new method findPriorAdoptionIdPersonIdAdoStage.
 *  09/29/2011 schoi           STGAP00017013: MR-095 Added new methods countStagePersonLinkByIdStageCdStagePersTypeCdStagePersRelInt
 *                             and findStagePersonLinkByIdStageCdStagePersTypeCdStagePersRelInt                           
 *  10/01/2011 schoi           STGAP00017013: MR-095 Added new methods findPersonByIdStageByNmPersonFull,
 *                             findStagePersonLinkByIdStageByCdStagePersRelInt and findPersonByIdStageByCdStagePersRelIntGender 
 *  10/02/2011 schoi           STGAP00017013: MR-095 Added new method countStagePersonLinkByIdStageCdStagePersTypeCdPersonSex 
 *  10/04/2011 schoi           STGAP00017013: MR-095 Added new method findAllChildrenFCCStagesByIdCaseByStage
 *  10/17/2011 hjbaptiste      STGAP00017246: MR-092 Added new method findPADStageByPriorAdoptionIdPersonIdAdoStage to find current
 *                             PAD Stage and current PAD Person ID of child based on prior ADO Person ID
 *  01/23/2012 arege           STGAP00017827: MR-085 Added new method findPRNIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson
 *  02/08/2012 htvo            STGAP00017831: MR-102 Added methods
 *                             - findOtherIdCaseByIdCaseIdPersonCdStagePersType
 *                             - countStagePersonLinkByIdCaseIdPersonCdStageCdPersTypeDtCaseOpened
 *                             - countStagePersonLinkByIdCaseIdPersonCdPersTypeDtPersAdded
 *                             - countStagePersonLinkByIdPersonCdPersTypeCdStageDtStageStart
 * </pre>
 */

public interface StagePersonLinkDAO {
  
  /**
   * This method retrieves stage person link records for a list of persons
   * @param idPersonList - list of persons to retrieve stagePersonLinks for
   * @return - returns a list of stage person link records
   */
  public List<StagePersonLink> findStagePersonLinkByidPersons(List<Integer> idPersonList);
  
  /**
   * This method retrieves stagePersonLink records for all household members within a stage
   * @param idStage - the id of the stage
   * @return - returns a list of stage person link records
   */
  public List<StagePersonLink> findStagePersonLinkByIdStageRoleHousehold(int idStage);
  
  /**
   * This method finds all stagePersonLink records related to the passed-in stage
   * @param idStage - the id of the stage
   * @return - returns a list of stage person link records
   */
  public List<StagePersonLink> findStagePersonLinkByIdStage(int idStage);

  /*
   * This method is used for updating the CSUP_PARENT_OUTBOUND table for 
   * calculating the per diem info for a child. This query returns all the
   * stages the person id is in
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findIdStageByIdPersonParentForPerDiem(int idPerson);
  
  /**
   * Using the stage id get all the Non Custodial Parents for the child
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<StagePersonLink> findNcpsForFccChild(int idStage);
  
  /**
   * Using the stage id get all the Non Custodial Parents for the child
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<StagePersonLink> findNcpsForChild(int idStage);
  
  /*
   * This method is used for updating the INCOME_AND_RESOURCES table for 
   * Receive Child Support Payment Info Service. This query returns all the
   * stages the person id is in
   */
  @SuppressWarnings("unchecked")
  List<Integer> findIdStageByIdPersonParent(int idPerson, String cdCounty);
  
  
  /**
   * This method is used for checking to see if the idPerson was ever assigned
   * to a particular stage it also checks to see if the idPerson is in the unit hierarchy. 
   * @param idPerson
   * @param idCase
   * @param idStage
   * @return long
   */
  public BigDecimal countStageAssignedHistory(int idPerson, int idCase, int idStage);
  
  /*
   * This method is used for updating the INCOME_AND_RESOURCES table for 
   * Receive Child Support Payment Info Service. This query returns all the
   * Child/personId for the Parent/personId
   */
  @SuppressWarnings("unchecked")
  Integer findIdPersonForChildByIdStage(int idStage);
  
  /*
   * This Method is used to return the id for the Primary Case Manager even 
   * if the Stage is not currently active.  
   */
  Integer findIdPersonForCaseManagerByIdStage(int idStage);
  
  /**
   * Similar to the method findIdPersonForCaseManagerByIdStage,
   * however it orders by the dt_stage_pers_link and uses
   * descending order to return the newest Case Manager ID first.
   * <p/>
   * @param idStage
   * @return
   */
  Integer findIdPersonForCaseManagerByIdStageOrderDesc(int idStage);

  /**
   * Retrieves relationship for the given person id and stage id 
   * <p/>
   * @param idEvent
   * @param idPerson
   * @return
   */
  String findRelIntByIdEventIdPerson(int idEvent, int idPerson); 
  /**
   * Retrieves id_person of the case manager who is a primary worker of the open stage the person is in 
   * <p/>
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * @return
   */
  @SuppressWarnings("unchecked")
  Object[] findIdPersonByIdStagePersRole(int idPerson);
  
  /**
   * Retrieves id_person of the case manager who is a primary worker of the open stage the person is in 
   * <p/>
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * @return
   */
  @SuppressWarnings("unchecked")
  Object[] findCaseIdByChildIdPerson(int idPerson);
  
  /**
   * This DAM will retrieve the ID PERSON for a given role, for a given stage. It's used to find the primary worker for
   * a given stage.
   * 
   * @param idStage
   * @param cdStagePersRole
   */
  Integer findIdPersonByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole);

  long countStagePersonLinkByIdStageAndIdPerson(int idStage);

  /**
   * Retrieves all principals in a stage
   * 
   * @param idStage
   * @param cdStagePersType
   */
  @SuppressWarnings( { "unchecked" })
  List<Map<String, Object>> findStagePersonLinkByIdStageAndCdStagePersType(int idStage, String cdStagePersType);

  /**
   * Retrieve StagePersonLink objects by IdPerson and CdStage
   * 
   * @param idPerson
   * @param cdStage
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<StagePersonLink> findStagePersonLinkByIdPersonAndCdStage(int idPerson, String cdStage,
                                                                                  int pageNbr, int pageSize);

  /**
   * Retrieves a Map of Resource and StagePersonLink objects by IdPerson
   * 
   * @param idPerson
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findResourceandStagePersonLinkByidPersonAndCdPlcmtActPlanned(int idPerson);

  /**
   * Retrieves a list of idStages based on idPersMergeForward and idPersMergeClosed
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Integer> findIdStageByIdPerson(int idPersMergeForward, int idPersMergeClosed, int pageNbr,
                                                        int pageSize);

  /**
   * Retrieves idPerson of dtPrimaryChild, idCase, and and dtPersonBirth using idPerson and cdPrimaryChild <p/>
   * 
   * @param idStage
   * @param cdPrimaryChild
   */
  @SuppressWarnings( { "unchecked" })
  Map findStagePersonLinkByIdPerson(int idStage, String cdPrimaryChild);

  /**
   * This will retrieve rows from the StagePersonLink table based on idPerson passed into the method. It will retrieve
   * the row of the primary worker in the subcare, adoption, or post-adoption stage, where the stage is open, associated
   * with the primary child from input. <p/>
   * 
   * @param idPerson
   */
  @SuppressWarnings( { "unchecked" })
  List<StagePersonLink> findStagePersonLinkByIdPerson(int idPerson);
  
  /**
   * Retrieves the id of the Primary worker of the SUB stage associated witht he primary
   * child passed in
   * 
   * @param idPerson
   * @return
   */
  Integer findSUBCaseManagerByIdChild(int idPerson);

  /**
   * This returns the number of Person and Stage associations in the StagePersonLink table for a given Person ID and
   * Stage ID.
   * 
   * @param idStage
   * @param idPersMergeForward
   */
  long countStagePersonLinkByIdStageAndIdPerson(int idStage, int idPersMergeForward);

  /**
   * Retrieves a row as StagePersonLink object, from StagePErsonLink and Stage tables. for the given Stage, Person,
   * StagePersRole and Case IDs. <p/>
   * 
   * @param cdStage
   * @param idPerson
   * @param cdStagePersRole
   * @param idCase
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkByCdStageIdPersonCdRoleIdcase(String cdStage, int idPerson,
                                                                   String cdStagePersRole, int idCase);

  /**
   * This selects all principals linked to stage along with their county, region, name, stage role, & stage relation.
   * <p/>
   * 
   * @param idStage
   * @param cdStagePersType
   */
  List<StagePersonLink> findAllPrincipalsLinkedToStage(int idStage, String cdStagePersType);
  
  /**
   * This allows the code to decide what want person types to pull Principal, Collaterals, Staff or All good for 
   * selecting Principals and Collaterals.  
   * @param idStage
   * @param personType
   * @return List<StagePersonLink>
   */
  @SuppressWarnings( { "unchecked" })
  public List<StagePersonLink> findAnyTypeLinkedToStage(int idStage, Collection personType);

  /**
   * Finds all Open Stages given the Person Id, the Stage Person Type and the Stage code
   * 
   * @param idPerson
   * @param cdStagePersType
   * @param cdStage
   * @return int
   */
  public List<StagePersonLink> findAllOpenStagesByIdPersonPersTypeAndCdStage(int idPerson, String cdStagePersType, String cdStage);
  
  /**
   * Finds all Open Stages given the Person Id, the Stage Person Type and the Stage code
   * 
   * @param idPerson
   * @param cdStagePersType
   * @param Collection
   * @return long
   */
  @SuppressWarnings( { "unchecked" })
  List<StagePersonLink> findAllOpenStagesByIdPersonPersTypeAndCdStage(int idPerson, String cdStagePersType, Collection stageTypeList);
  
  /**
   * 
   * @param idStage
   * @param cdStagePersRole
   * @return List<Integer>
   */
  public List<Integer> findIdCaseWorkersByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole);
  
  /**
   * This selects all principals linked to a stage that are directly living in the house and returns them as a list  <p/>
   * 
   * @param idStage
   * @return StagePersonLink
   */
  List<StagePersonLink> findHouseMembersLinkedToStage(int idStage);

  /**
   * This selects all people linked to a stage that are directly living in the house and returns them as a list.  Additional
   * information is pulled from the person table  <p/>
   * 
   * @param idStage
   * @return StagePersonLink
   */  
  @SuppressWarnings( { "unchecked" })
  List<Map> findHomeMembersDetailLinkedToStage (int idStage);  
  
  
  /**
   * Retrieves a different idStage for a particular idPerson
   * 
   * @param idCase
   * @param idStage
   * @param cdStage
   * @param cdStagePersRole
   * @return A map with keys stage, and person
   */
  
  @SuppressWarnings( { "unchecked" })
  Map findIdPersonByIdCaseAndIdStage(int idCase, int idStage, String cdStage, String cdStagePersRole);

  /**
   * Retrieves victim child id for a particular idStage.
   * CAPTA 4.3
   * @param idStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  public Integer findAllegedVictimChildByIdStage(int idStage);
  
  /**
   * Retrieves child in SUB and ADO stage
   * @param idPerson
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  public Integer findChildWithSubAndAdoStageByIdPerson(int idPerson);
   
  /**
   * countStagesByIdPersonAndIdStage CSES94D.PC
   * 
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStage
   * @return long
   */
  long countStagesByIdPersonAndIdStage(int idPerson, String cdStagePersRole, String cdStage);
  
  /**
   * Finds all Open Stages given the Person Id, the Stage Person Type and the Stage code
   * 
   * @param idPerson
   * @param cdStagePersType
   * @param Collection
   * @return long
   */
  
  @SuppressWarnings( { "unchecked" })
  long countOpenStagesByIdPersonAndIdStageqAndPersType(int idPerson, String cdStagePersType, Collection stageTypeList);

  /**
   * countOpenStagesByIdPersonAndIdStage CSES94D.PC
   * 
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStage
   * @return int
   */
  long countOpenStagesByIdPersonAndIdStage(int idPerson, String cdStagePersRole, String cdStage);

  /**
   * countOpenStages given the Person Id, the Stage Person Type and the Stage code
   * 
   * @param idPerson
   * @param cdStagePersType
   * @param cdStage
   * @return int
   */
  public long countOpenStagesByIdPersonAndIdStageqAndPersType(int idPerson, String cdStagePersType, String cdStage);
  
  /**
   * This receives idStage from the service and returns one or more rows from the STAGE_PERSON_LINK table.
   * 
   * @param idStage
   */
  @SuppressWarnings( { "unchecked" })
  List<StagePersonLink> findStagePersonLinkRowsByIdStage(int idStage);

  /**
   * This will receive idStage from the service and return the associated record from the STAGE_PERSON_LINK table where
   * the staff person's role is "Primary" (PR).
   * 
   * @param idStage
   */
  @SuppressWarnings( { "unchecked" })
  StagePersonLink findStagePersonLinkByIdStageCdStagePersRole(int idStage);
  
  /**
   * This will receive idStage from the service and return the associated record from the STAGE_PERSON_LINK table where
   * the staff person's role is "Primary" (PR) or "Historical" (HP).
   * @param idStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  StagePersonLink findStagePersonLinkByIdStageCdStagePersRoleAll(int idStage);

  /**
   * Retrieves all the person with Legal Statuses in a given Case.
   * 
   * @param idCase
   * @param cdEventType
   * @return A map with keys idPerson, and cdStagePersType
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findStagePersonLinkByIdCaseCdEventType(int idCase, String cdEventType);

  /**
   * Retrieve StagePersonLink by idStage and order by cdStagePersrole
   * 
   * @param idStage
   */
  @SuppressWarnings( { "unchecked" })
  List<StagePersonLink> findStagePersonLinkByIdStageOrderByCdStagePersrole(int idStage);

  /**
   * Retrieves the names for the change name window, by querying Stage, StagePersonLink and Person tables using the
   * given idStage
   * 
   * @param idStage
   * @return List of Map objects
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findNamesFromStageAndStagePersonLinkAndPersonByIdStage(int idStage);

  /**
   * Retrieves a list of person id's and their full names from StagePersonLink and person tables for the given idStage
   * and cdStagePersType = 'PRN'.(Retrieves names of the Principals in the stage)
   * 
   * @param idStage
   * @return List of Map objects
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findIdPersonAndNmPersonFullFromStagePersonLinkAndPerson(int idStage);

  /*
   * Retrieves idStagePersonLink from StagePersonLink table for the given idPerson and cdStagePersRole.
   * 
   * @param idPerson
   * @param cdStagePersRole
   * @return Integer
   */
  Integer findIdStagePersonLinkByIdPersonAndCdStagePersRole(int idPerson, String cdStagePersRole);

  /**
   * Select a unique row from the StagePersonLink table by person type, role, IdPerson, and IdStage. <p/>
   * 
   * @param idStage
   * @param cdStagePersRole
   * @param cdStagePersType
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(int idStage, String cdStagePersRole,
                                                                        String cdStagePersType);

  /**
   * Retrieve ID Person from Stage Person Link by idStage and cdStagePersType
   * 
   * @param idStage
   * @param cdStagePersType
   * @return List of Integers containing Person IDs
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findIdPersonFromStagePersonLinkByIdStageAndCdStagePersType(int idStage, String cdStagePersType);
  
  /**
   * Retrieve ID Person for Members of the Primary Caretaker's Household from Stage Person Link by idStage and cdStagePersType
   * 
   * @param idStage
   * @param cdStagePersType
   * @return List of Integers containing Person IDs
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findMbrPkHshldIdPersonFromStagePersonLinkByIdStageAndCdStagePersType(int idStage, String cdStagePersType);
  
  /**
   * Retrieve ID Person for any principals that are unknown if they are Members of the Primary Caretaker's Household from Stage Person Link
   * 
   * @param idStage
   * @param cdStagePersType
   * @return List of Integers containing Person IDs
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findUnknownMbrPkHshldIdPersonByIdStageAndCdStagePersType(int idStage, String cdStagePersType);
  
  /**
   * Retrieve a list of person from the stage person link based on their person type and relationships on that stage
   * @param idStage
   * @param cdStagePersType
   * @param relationships
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findIdPersonFromStagePersonLinkByIdStageCdStagePersTypeAndRelationships(int idStage, String cdStagePersType, Collection<String> relationships);

  /**
   * Retrieves idStage, idPerson and idCase from StagePersonLink and Stage tables by querying these tables and Person
   * table for the given idPerson and applying the following logic: 1- It searches the StagePersonLink table and
   * retrieves all those stages where idPerson = the given idPerson. 2- For each idStage retrieved in Step 1, it
   * searches the Stage table and verifies that the dtStageClose = NULL and retrieves the idCase associated with
   * idStage, if any. 3- It searches the Person table to verify that cdPersonStatus = 'A' (active) 4- For every stage
   * retrieved in Step 1, it searches the StagePersonLink table and retrieves the idPerson whetre cdStagePersRole = "PR"
   * (primary).
   * 
   * @param idPerson
   * @param idCase
   * @return List of Map objects
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findIdStageIdPersonIdCaseFromStageAndStagePersonLink(int idPerson, int idCase);

  /**
   * Retrieves a Map of Stage and StagePersonLink objects by IdPerson
   * 
   * @param idPerson
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Map> findStageAndStagePersonLinkByIdPerson(int idPerson, int pageNbr, int pageSize);

  /**
   * Retrieves a Map of idPerson, cdStagePersRole, dtLastUpdate, nmPersonFull, cdPersonMaritalStatus, and dtPersonBirth
   * from Person and StagePersonLink by joining these tables and using Stage table compare idStage with the given
   * idStage.
   * 
   * @param idStage
   * @return List of Map with keys
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findPersonAndStagePersonLinkByIdPersonIdStageAndCdStagePersType(int idStage);

  /**
   * Returns a StagePersonLink set rows for the specified idStage that does not match the specified cdStagePersType
   * 
   * @param idStage
   * @param cdStagePersType
   * @return List<StagePersonLink>
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<StagePersonLink> findStagePersonLinkAndPersonByidStageAndCdStagePersType(
                                                                                                  int idStage,
                                                                                                  String cdStagePersType,
                                                                                                  int pageNbr,
                                                                                                  int pageSize);
  /**
   * Returns a StagePersonLink set rows for the specified idCase that does not match the specified cdStagePersType
   * 
   * @param idCase
   * @return List<StagePersonLink>
   */
  @SuppressWarnings( { "unchecked" })
  List<Object[]> findStagePersonLinkAndPersonByidCase(int idCase);

  /**
   * Returns a StagePersonLink set rows for the specified idCase that does not match the specified cdStagePersType
   * for Sealed cases where Adopted Indicator <> 'Y'
   * @param idCase
   * @return List<StagePersonLink>
   */
  List<Object[]> findStagePersonLinkAndPersonByidCaseForSealedCase(int idCase);

  /**
   * Returns a StagePersonLink set rows for the specified idCase that does not match the specified cdStagePersType
   * for Sealed cases where Sealed Attribute Indicator <> 'N'
   * @param idCase
   * @return List<StagePersonLink>
   */
  List<Integer> findSealedIdPersonListByidCase(int idCase);
  /**
   * Retrieve a StagePersonLink row based on idStage, idPerson, and maxDate. <p/> <p/>
   * 
   * @param idStage
   * @param idPerson
   * @param maxDate
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkByIdStageIdPersonAndMaxDate(int idStage, int idPerson, Date maxDate);

  /**
   * Retrieves all distinct workers of a given role for a stage with a given date.
   * 
   * @param idCase
   * @param cdStagePersRole
   * @param dtStageClose
   * @return List<StagePersonLink>
   */
  @SuppressWarnings( { "unchecked" })
  List<StagePersonLink> findStagePersonLinkByIdCaseCdStagePersTypeDtStageClose(int idCase, String cdStagePersRole,
                                                                               Date dtStageClose);

  /**
   * Retrieves the count from StagePersonLink table for the given idStage, cdStagePersType and cdStagePersRole.
   * 
   * @param cdStagePersType
   * @param cdStagePersRole
   * @param idStage
   * @return Integer
   */
  long countStagePersonLinkByIdStageCdStagePersTypeAndCdStagePersRole(int idStage, String cdStagePersType,
                                                                      String cdStagePersRole);

  /**
   * Returns a count of StagePersonLinks where idStage is not zero for an idPerson
   * 
   * @param idPerson
   */
  long countStagePersonLinksNonZeroIdStageByIdPerson(int idPerson);

  /**
   * Returns the idPerson and IdStage Selected from StagePersonLink
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idPerson
   * @return A list of map objects.
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findIdPersonIdStageFromStagePersonLink(int idPersMergeForward, int idPersMergeClosed, int idPerson);

  /**
   * This joins the STAGE, STAGE PERSON LINK and the PERSON table to retrieve information for all of the people for an
   * associated ID CASE who are NOT Staffed.
   * 
   * @param idCase
   * @param cdStagePersType
   * @return List of Maps keys: nmPersonFull, cdPersonSuffix, nbrPersonAge, cdPersonSex, idPerson indPersonDobApprox,
   *         cdPersonChar, dtPersonBirth, dtPersonDeath, cdStagePersSearchInd, cdStagePersType, cdStagePersRelInt,
   *         cdStagePersRole, cdStagePersRole
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findUnstaffedStagePersonLinkByIdCaseAndCdStagePersType(int idCase, String cdStagePersType);
  
  /**
   * List of Maps that pulls back stages of a given type that have a stage open date prior to a given date and a end date after 
   * the given date. 
   * @param idPerson
   * @param cdStageType
   * @param dtReportDate
   * @return List<Map>
   */
  public List<Map> findListOfOpenStagesByCdStageType(int idPerson, String cdStageType, Calendar dtReportDate);

  /**
   * List of Maps that pulls back stages of a given type that have a stage open date prior to a given date and a end date after 
   * the given date. 
   * @param idPersons
   * @param cdStageType
   * @param dtReportDate
   * @return
   */
  public List<Map> findListOfOpenStagesByCdStageTypeIdPersons(List<Integer> idPersons, String cdStageType, Calendar dtReportDate);
  
  /**
   * Retrieves a Map of Person objects by idStage and cdStagePersType0, cdStagePersType1, cdStagePersType2,
   * cdStagePersType3, cdStagePersType4, cdStagePersType5, cdStagePersType6
   * 
   * @param idStage
   * @param cdStagePersType0
   * @param cdStagePersType1
   * @param cdStagePersType2
   * @param cdStagePersType3
   * @param cdStagePersType4
   * @param cdStagePersType5
   * @param cdStagePersType6
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findPersonByIdStageIdPersonCdStagePersType(int idStage, String cdStagePersType0, String cdStagePersType1,
                                                       String cdStagePersType2, String cdStagePersType3,
                                                       String cdStagePersType4, String cdStagePersType5,
                                                       String cdStagePersType6, String cdStagePersType7);

  /**
   * This is findAllPrincipalInfoForStage function with smaller scope. It does not join Person_DTL table
   * @param szCdStagePersType
   * @param idStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findAllPrincipalsForStage(String szCdStagePersType, int idStage);
  
  /**
   * This is findAllPrincipalInfoForStage function with smaller scope. It does not join Person_DTL table.
   * It will only bring back those who are a member of the primary caretaker's household
   * @param szCdStagePersType
   * @param idStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findAllPrincipalsForStageInPKHshld(String szCdStagePersType, int idStage);
  
  /**
   * This will find all principals for a stage without a value for "Member in Primary
   * Caretaker's Household".
   * @param szCdStagePersType
   * @param idStage
   * @return a List<Map> containing ids of the principals
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findAllPrincipalsForStageInPKHshldNull(String szCdStagePersType, int idStage);

  /**
   * This is findAllPrincipalInfoForStage function with smaller scope. It does not join Person_DTL table
   * @param szCdStagePersType
   * @param idStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })  
  List<Map> findAllPrincipalsForHouse(int idStage);

  /**
   * This will list the Stages where the idPerson and all person merged with them are on the Stage Person LInk table.
   * 
   * @param idPerson
   * @return keys idStage, dtLastUpdate, cdStageType, idUnit, idCase, idSituation, dtStageClose, cdStageClassification,
   *         cdStageCurrPriority, cdStageInitialPriority, cdStageRsnPriorityChgd, cdStageReasonClosed, indStageClose,
   *         cdStageCnty, nmStage, cdStageRegion, dtStageStart, cdStageProgram, cdStage, txtStagePriorityCmnts,
   *         txtStageClosureCmnts, idStagePersonLink, dtLastUpdate, idPerson, cdStagePersRole, indStagePersInLaw,
   *         cdStagePersType, cdStagePersSearchInd, txtStagePersNotes, dtStagePersLink, cdStagePersRelInt,
   *         indStagePersReporter, indStagePersEmpNew
   */
  @SuppressWarnings( { "unchecked" })
  List<StagePersonLink> findStagePersonLinkByIdPersonPersonMerge(int idPerson);

  /**
   * retreives all open stages and events a person is associated with
   * 
   * @param idPerson
   * @return a list of StagePersonLink and Event Objects containing all open stages and events
   */

  @SuppressWarnings( { "unchecked" })
  List<Object[]> findOpenStagesAndEventsPerPerson(int idPerson);

  /**
   * Return full StagePersonLink row for an idPerson and idStage
   * 
   * @param idPerson
   * @param idStage
   */
  StagePersonLink findStagePersonLinkByIdPersonAndIdStage(int idPerson, int idStage);

  /**
   * This returns the number of unrelated employees given Person ID.
   * 
   * @param idPerson
   */
  long countStagePersonLinksNonStfCdStagePersTypeNonZeroIdStageByIdPerson(int idPerson);

  /**
   * This returns the number of rows in the StagePersonLink table associated with the given Person ID.
   * 
   * @param idPerson
   */
  long countStagePersonLinksByIdPerson(int idPerson);

  /**
   * This retrieves idStagePersonLink from StagePersonLink given idStage where the role is 'HP'
   * 
   * @param idStage
   * @return A map of information about the requested idStagePersonLink.
   */
  @SuppressWarnings( { "unchecked" })
  Map findStagePersonLinkByIdStageAndRole(int idStage);

  /**
   * Find combined SPL, Person and PersonID data for incomingStatus screen
   * 
   * @param idStage
   * @param dtSysTsQuery
   * @return List<Object[]>
   */
  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findSPLPersonPersonIDIncmgStatus(int idStage, Date dtSysTsQuery);

  /**
   * Find combined SPL, Person and PersonID data from history
   * 
   * @param idStage
   * @param dtSysTsQuery
   * @return List<Object[]>
   */
  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findSPLPersonPersonID(int idStage, Date dtSysTsQuery);

  /**
   * Retrieves related Person, Name, and StagePersonLink data given idStage, cdStagePersType, and dtMaxDate
   * 
   * @param idStage
   * @param cdStagePersType
   * @param dtMaxDate
   * @return List<Map>
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findStagePersonLink(int idStage, String cdStagePersType, Date dtMaxDate);

  // STGAP00017013: MR-095
  /**
   * Retrieves related Person, Name, and StagePersonLink data given idStage, cdStagePersType, and dtMaxDate
   * excluding the given idPerson
   * 
   * @param idStage
   * @param cdStagePersType
   * @param dtMaxDate
   * @param idPerson
   * @return List<Map>
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findStagePersonLinkExcludingIdPerson(int idStage, String cdStagePersType, Date dtMaxDate, int idPerson);
  
  /**
   * Retrieves the 'CaseMergeTo' data for cases that have been closed in a case merge and selects the idCase for the
   * single case that has a corresponding idCase on the StagePersonLink table (i.e. the most recent case forward). (Note
   * that the select query is done using straight SQL
   * 
   * @param idCase
   * @return Integer The distinct idCase returned by the query.
   */
  Integer findDistinctIdCaseFromStagePersonLinkByIdCase(int idCase);

  /**
   * Retrieves =StagePersonLink data given idCase
   * 
   * @param idCase
   * @return List<Map>
   */
  @SuppressWarnings( { "unchecked" })
  public List<Map> findStagePersonLink(int idCase);

  /**
   * This returns the number of SUBCARE stages currently open for a childCount number of SUBCARE stages currently open
   * for a child given idPerson, and szCdStagePersRole. <p/> From: Cses21d.pc
   * 
   * @param idPerson
   * @param cdStagePersRole
   * @return The number of open subcare stages.
   */
  long countOpenSubCareStages(int idPerson, String cdStagePersRole);

  /**
   * Partial update of StagePersonLink table.
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   */
  int updateStagePersonLinkIdPerson(int idPersMergeForward, int idPersMergeClosed);

  /**
   * Updates table StagePersonLink, field idCase given idStage <p/>
   * 
   * @param idCase
   * @param idStage
   */
  int updateStagePersonLinkIdCaseByIdStage(int idCase, int idStage);

  /**
   * Updates table StagePersonLink, fields idPersMergeForward and cdStagePersType given idStagePerson and dtLastUpdate
   * <p/>
   * 
   * @param idPersMergeForward
   * @param idStagePerson
   * @param cdStagePersType
   * @param tsLastUpdate
   */
  int updateIdPersonCdStagePersTypeByIdStagePersonLink(int idPersMergeForward, int idStagePerson,
                                                       String cdStagePersType, Date tsLastUpdate);

  /**
   * Updates table StagePersonLink field indNmStage given idStage and idPerson <p/>
   * 
   * @param idStage
   * @param idPerson
   */
  int updateStagePersonLinkIndNmStage(int idStage, int idPerson);

  /**
   * Updates table StagePersonLink field indStagePersEmpNew given idStage and idPerson <p/>
   * 
   * @param idStage
   * @param idPerson
   */
  int updateStagePersonLinkIndStagePersEmpNew(int idStage, int idPerson);

  /**
   * Inserts a new row into the StagePersonLink table.<p/> Note that, this is done in straight sql.
   * 
   * @param idStage
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param txtStagePersNotes
   * @param dtStagePersLink
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param indStagePersEmpNew
   * @param cdPKHouseholdMember
   * @param cdPersonSideOfFamily
   * @return Integer
   */
  int insertStagePersonLinkWihoutIndNmStage(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                                            String cdStagePersSearchInd, String txtStagePersNotes,
                                            Date dtStagePersLink, String cdStagePersRelInt,
                                            String indStagePersReporter, String indStagePersInLaw,
                                            String indStagePersEmpNew, String cdPKHouseholdMember, String cdPersonSideOfFamily);
  

  /**
   * Updates table StagePersonLink with the specified fields <p/>
   * 
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param txtStagePersNotes
   * @param dtStagePersLink
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param indStagePersEmpNew
   * @param idStagePerson
   * @param cdPKHouseholdMember
   */
  int updateStagePersonLinkWithoutIndNmStage(int idPerson, String cdStagePersRole, String cdStagePersType,
                                             String cdStagePersSearchInd, String txtStagePersNotes,
                                             Date dtStagePersLink, String cdStagePersRelInt,
                                             String indStagePersReporter, String indStagePersInLaw,
                                             String indStagePersEmpNew, int idStagePerson, String cdPKHouseholdMember, String cdPersonSideOfFamily);

  /**
   * Updates a Role for a specified stage and previous role and type
   * 
   * @param idStage
   * @param cdStagePersRoleNew
   * @param cdStagePersRoleOld
   * @param cdStagePersType
   * @return number of rows updated
   */
  int updateStagePersonLinkRole(int idStage, String cdStagePersRoleNew, String cdStagePersRoleOld,
                                String cdStagePersType);

  /**
   * Sets indNMStage to null for all rows with specified idStage
   * 
   * @param idStage
   * @return number of rows updated
   */
  int updateStagePersonLinkClearIndNMStageByIdStage(int idStage);
  
  /**
   * 
   * Sets idCase field to null for all rows with specified idStage
   * @param idStage
   * @return
   */
  int updateStagePersonLinkClearIdCaseByIdStage(int idStage);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink} object to the database.
   * 
   * @param indStagePersInLaw
   * @param idPerson
   * @param idStage
   * @return Integer
   */
  int updateStagePersonLinkIndStagePersInLaw(String indStagePersInLaw, int idPerson, int idStage);

  /**
   * Updates table StagePersonLink, fields idPerson and cdStagePersSearchInd given idRelatedPerson,
   * cdStagePersSearchInd, idPerson and idStage.<p/>
   * 
   * @param idRelatedPerson
   * @param cdStagePersSearchInd
   * @param idPerson
   * @param idStage
   */
  int updateStagePersonLinkIdPersonCdStagePersSearchInd(int idRelatedPerson, String cdStagePersSearchInd, int idPerson,
                                                        int idStage);

  /**
   * Updates table StagePersonLink field cdStagePersSearchInd given idPerson and idStage <p/>
   * 
   * @param cdStagePersSearchInd
   * @param idPerson
   * @param idStage
   */
  int updateStagePersonLinkCdStagePersSearchInd(String cdStagePersSearchInd, int idPerson, int idStage);

  /**
   * Updates table StagePersonLink field cdStagePersRole given idPerson, idStage, and dtLastUpdate <p/>
   * 
   * @param cdStagePersRole
   * @param idPerson
   * @param idStage
   * @param dtLastUpdate
   */
  int updateStagePersonLinkCdStagePersRole(String cdStagePersRole, int idPerson, int idStage, Date dtLastUpdate);

  /**
   * Updates table StagePersonLink field cdStagePersRelInt given idPerson and idStage <p/>
   * 
   * @param cdStagePersRelInt
   * @param idPerson
   * @param idStage
   */
  int updateStagePersonLinkCdStagePersRelInt(String cdStagePersRelInt, int idPerson, int idStage);

  /**
   * Updates table StagePersonLink field cdStagePersRole given idPerson and idStage <p/>
   * 
   * @param cdStagePersRole
   * @param idPerson
   * @param idStage
   */
  int updateStagePersonLinkCdStagePersRole(String cdStagePersRole, int idPerson, int idStage);

  /**
   * Updates table StagePersonLink field cdStagePersType given idPerson and idStage <p/>
   * 
   * @param cdStagePersType
   * @param idPerson
   * @param idStage
   */
  int updateStagePersonLinkcdStagePersType(String cdStagePersType, int idPerson, int idStage);

  /**
   * Insert stagePersonLink
   * 
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param txtStagePersNotes
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param idStage
   * @param idPerson
   * @param indStagePersInLaw
   * @param cdStagePersLstSort
   * String cdPKHouseholdMember
   */
  int insertStagePersonLink(String cdStagePersRole, String cdStagePersType, String cdStagePersSearchInd,
                            String txtStagePersNotes, String cdStagePersRelInt, String indStagePersReporter,
                            int idStage, int idPerson, String indStagePersInLaw, String cdStagePersLstSort,
                            String cdPKHouseholdMember);

  // STGAP00017013: MR-095
  /**
   * Insert stagePersonLink
   * 
   * @param idStage
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersRelInt
   * @param cdStagePersSearchInd
   * 
   */
  int insertStagePersonLinkAddedFromAddPersonToActiveStages(int idStage, int idPerson, String cdStagePersRole,
                                                            String cdStagePersType, String cdStagePersRelInt,
                                                            String cdStagePersSearchInd);
  
  /**
   * Insert stagePersonLink
   * 
   * @param idStage
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param txtStagePersNotes
   * @param dtStagePersLink
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param indStagePersEmpNew
   */
  int insertStagePersonLink(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                            String cdStagePersSearchInd, String txtStagePersNotes, Date dtStagePersLink,
                            String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                            String indStagePersEmpNew);

  /**
   * Delete rows from StagePersonLink based on ID_STAGE and CD_STAGE_PERS_ROLE
   * 
   * @param idStage
   * @return Integer
   */
  int deleteStagePersonLinkByIdStageCdStagePersRole(int idStage);

  /**
   * Delete rows from StagePersonLink based on idStage and idPerson
   * 
   * @param idStage
   * @param idPerson
   */
  int deleteStagePersonLink(int idStage, int idPerson);

  /**
   * /** Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink} object.
   * 
   * @param stagePersonLink
   */
  void deleteStagePersonLink(StagePersonLink stagePersonLink);

  /**
   * Delete rows from StagePersonLink based on ID_STAGE and CD_STAGE_PERS_ROLE.
   * 
   * @param idStage
   * @param cdPersonRole
   */
  int deleteStagePersonLinkByIdStage(int idStage, String cdPersonRole);

  /**
   * Partial insert of StagePersonLink table using the supplied parameters(column values). (Note that the insert is done
   * using straight SQL)
   * 
   * @param idStage
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param indSafetyRsrc
   * @param dtStagePersLink
   * @param sideOfFamily
   * @param cdPKHouseholdMember
   * @return int The number of entities effected by the 'insert' operation.
   */
  //Added cdPKHouseholdMember
  public int insertStagePersonLink(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                                   String cdStagePersSearchInd, String cdStagePersRelInt, String indStagePersReporter,
                                   String indStagePersInLaw, String indSafetyRsrc, Date dtStagePersLink, String sideOfFamily,
                                   String cdPKHouseholdMember, Date dtPersonAddedOrRelated);

  /**
   * Partial update of StagePersonLink table using the supplied parameters(column values).
   * 
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param idStagePersonLink
   * @param indSafetyRsrc
   * @param cdPersonSideOfFamily
   * @param cdPKHouseholdMember
   * @param lastUpdate
   * @return int The number of entities effected by the 'update' operation.
   */
  public int updateStagePersonLink(String cdStagePersRole, String cdStagePersType, String cdStagePersSearchInd,
                                   String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                                   int idStagePersonLink, String indSafetyRsrc, Date lastUpdate, String cdPersonSideOfFamily,
                                   String cdPKHouseholdMember);

  /**
   * update of StagePersonLink table using the supplied parameters(column values).
   * 
   * @param idStage
   * @param idPerson
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param txtStagePersNotes
   * @param dtStagePersLink
   * @param cdStagePersRelInt
   * @param indStagePersReporter
   * @param indStagePersInLaw
   * @param indStagePersEmpNew
   * @param idStagePerson
   * @param lastUpdate
   * @return int The number of entities effected by the 'update' operation.
   */
  public int updateStagePersonLink(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                                   String cdStagePersSearchInd, String txtStagePersNotes, Date dtStagePersLink,
                                   String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                                   String indStagePersEmpNew, int idStagePerson, Date lastUpdate);

  /**
   * Selects rows from Person, Placement and StagePersonLink tables using IdResource
   * 
   * @param idRsrcFacil
   * @param dtRshsEnd
   * @param dtRshsEffective
   * @param cdPlcmtActPlanned
   */
  @SuppressWarnings( { "unchecked" })
  public List<Map> findStagePersonLinkByIdResource(int idRsrcFacil, Date dtRshsEnd, Date dtRshsEffective,
                                                   String cdPlcmtActPlanned);

  /**
   * Update StagePersonLinkDAO
   * 
   * @param txtStagePersNotes
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param cdStagePersSearchInd
   * @param cdStagePersRelInt
   * @param indStagePersInLaw
   * @param cdStagePersLstSort
   * @param idStage
   * @param idPerson
   * @param cdPKHouseholdMember
   */
  public int updateStagePersonLink(String txtStagePersNotes, String cdStagePersRole, String cdStagePersType,
                                   String cdStagePersSearchInd, String cdStagePersRelInt, String indStagePersReporter,
                                   String indStagePersInLaw, String cdStagePersLstSort, int idStage, int idPerson,
                                   String cdPKHouseholdMember);

  /**
   * Selects rows from stage person link and person in the same stage where person age > 18 and in the same stage.
   * 
   * @param idStage
   */
  @SuppressWarnings( { "unchecked" })
  public List<Map> findRelationshipByIdStage(int idStage);

  /**
   * Simple save or update on a Stage Person Link
   * 
   * @param spl
   */
  void saveStagePersonLink(StagePersonLink spl);

  /**
   * A simplified version of the <code>findPersonsForAttendeesArray</code> method. Returns all persons associated to a
   * specific stage of a case (represented by idStage) from the STAGE_PERSON_LINK table.
   * 
   * @param idStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonsForAttendeesArrayByIdStage(int idStage);

  /**
   * Retrieves PrimaryCaretaker
   * 
   * @param idStage
   * @return
   */
  public Person findStagePersonLinkPrimaryCaretaker(int idStage);

  /**
   * Retrieves Person by idStage and cdStagePersRelInt
   * 
   * @param idStage
   * @param cdStagePersRelInt
   * @return
   */
  public Person findPersonByIdStageByCdStagePersRelInt(int idStage, String cdStagePersRelInt);

  /**
   * Retrieves Person by idStage and cdStagePersRelInt
   * 
   * @param idStage
   * @param nmPersonFull
   * @return
   */
  public Person findPersonByIdStageByNmPersonFull(int idStage, String nmPersonFull);
  
  /**
   * Selects a list of idStages from stage person link where each idPerson is in a list of idPersons.
   * 
   * @param idPersons
   */
  public List<Integer> findIdStageByIdPerson(Collection<Integer> idPersons);

  /**
   * Selects a list of idStages from stage person link by cdStagePersType and where each idPerson is in a list of
   * idPersons.
   * 
   * @param idPersons
   * @param cdStagePersType
   */
  public List<Integer> findIdStageByIdPersonStagePersType(Collection<Integer> idPersons, String cdStagePersType);

  /**
   * This method retrieves all the data needed for each person that has NOT been issued a protective service alert based
   * on what is displayed in the Persons Absconded section of the Protective Service Alert page.
   * 
   * @param idStage
   * @return List of Maps, each containing idPerson, nmPersonFull, dtPersonBirth, nbrPersonIdNumber (ssn),
   *         cdPersonEthnicGroup (race), cdEthnicity (ethnicity), cdPersonSex, and cdPersonStatus (legal status)
   */
  public List<Object[]> findPersonsNotAbsconded(int idStage);

  /**
   * Retrieves a list of person id's and their full names from StagePersonLink and person tables for the given idStage
   * and cdStagePersRole = 'VC'.(Retrieves Alleged Victim in the stage)
   * 
   * @param idStage
   * @return List of Map objects
   */
  public List<Map> findIdPersonAndNmPersonFullFromStagePersonLinkAndPersonByAllegedVictim(int idStage);

  /**
   * Selects a list of idStages from stage person link by cdStagePersRole and where each idPerson is in a list of
   * idPersons.
   * 
   * @param idPersons
   * @param cdStagePersRole
   */
  public List<Integer> findIdStageByIdPersonStagePersRole(Collection<Integer> idPersons, String cdStagePersRole);

  /**
   * Selects a list of idStages from stage person link by Employee and where each idPerson is in a list of idPersons.
   * 
   * @param idPersons
   * 
   */

  public List<Integer> findIdStageByIdPersonByEmployee(Collection<Integer> idPersons);
  
  /**
   * 
   * @param idPersons
   * @return
   */
  List<Integer> findIdPersonsByPersonAdopted(Collection<Integer> idPersons);

  /**
   * Select StagePersonLink based on a idCase, idPerson, and cdStage
   * @param idCase
   * @param idPerson
   * @param cdStage
   * @return StagePersonLink
   */
  public StagePersonLink findStagePersonLinkByIdCaseByIdPersosByCdStage(int idCase, int idPerson, String cdStage);
  
  /**
   * Select StagePersonLink based on a idCase, idPerson, and cdStage and
   * order, in descending order, by idStage
   * @param idCase
   * @param idPerson
   * @param cdStage
   * @return
   */
  public StagePersonLink findStgPersLnkClosedByIdCaseByIdPersByCdStgOrdByIdStg(int idCase, int idPerson, String cdStage);
  
  /**
   * Select StagePersonLink based on a idCase, idPerson, and cdStage, and stage person role
   * @param idCase
   * @param idPerson
   * @param cdStage
   * @param cdStagePersRole
   * @return StagePersonLink
   */
  public StagePersonLink findStagePersonLinkByIdCaseByIdPersosByCdStage(int idCase, int idPerson, 
                                                                 String cdStage, String cdStagePersRole);
  /**
   * Select closed StagePersonLink based on a idCase, idPerson, and stage type
   * @param idCase
   * @param idPerson
   * @param cdType
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkClosedByIdCaseByIdPersosByCdStage(int idCase, int idPerson, String cdStage); 
  
  /**
   * Select StagePersonLink based on a idStage, cdStagePersRole as 'SE'
   * @param idStage
   * @return List<Integer>
   */
  public List<Integer> findIdPersonByIdStageAndCdStagePersRoleAsSE(int idStage); 

  /**
   * Finds a list of Independent Living Coordinator(ILC) for a given Stage. An ILC would be a secondary worker
   * assigned to the stage. However, there are cases where they would be the primary worker on a stage
   * 
   * @param idStage
   * @return
   */
  List<Integer> findILCByIdStage(int idStage);
  
  /**
   *  find the primary children and consider the child as a candidate if for that child a:
   *        a)  SUB (also known as FCC) stage is open with no ADO (adoption) stage for the same idCase. 
   *        b)  SUB stage is open and ADO stage is open for the same idCase . 
   *             Return only one person for those 2 scenario not 2. 
   *        c)  SUB stage is open and ADO stage is closed for the same idCase.  
   *             Return only one person for those 2 scenario not 2. 
   * @param idCase
   * @param cdStagePersRole
   * @param cdStagePersType
   * @param idPersons
   * @return List<Person>
   */
  List<Person> findStagePersonLinkByIdCaseByIdPersonsByCdStagesByCdPersonRole( int idCase, 
                                                                               Collection<Integer> idPersons,
                                                                         String cdStagePersRole, 
                                                                         String cdStagePersType );
  /**
   * Select a list of persons that have a specific closed stage, a specific role and 
   *   person type for a certain idCase
   * @param idCase
   * @param cdStage
   * @param cdStagePersRole
   * @param cdStagePersType
   * @return List<Person>
   */
  List<Person> findStagePersonLinkByIdCaseByCdStageByCdPersonRole (int idCase, String cdStage,
                                                                   String cdStagePersRole, String cdStagePersType);
  
  /**
   * Select a list of persons that have a specific closed stage, a specific 
   *   person type for a certain idCase but are not included in another closed or open stage 
   *   with the same person type and case
   *   or case
   * @param idCase
   * @param cdStage
   * @param cdStage1
   * @param cdStagePersRole
   * @param cdStagePersType
   * @return List<Person>
   */
  List<Person> findStagePersonLinkClosedByIdCaseByCdPersonRoleByDiffCdStages (int idCase, String cdStage,
                                                                       String cdStage1, 
                                                                       String cdStagePersRole,
                                                                       String cdStagePersType);
  
  /**
   * Select a stagepersonlink based on an idStage, person relation to victim and stage person type
   *   or case
   * @param idStage
   * @param cdStagePersRelInt
   * @param cdStagePersType
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkByIdStageByCdStagePersRelInt( int idStage, String cdStagePersRelInt,
                                                                   String cdStagePersType);
  
  /**
   * Select a stagepersonlink based on an idStage, person relation to victim 
   * @param idStage
   * @param cdStagePersRelInt
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkByIdStageByCdStagePersRelIntOnly(int idStage, String cdStagePersRelInt);

  /**
   * Select a stagepersonlink based on an idStage, person relation to victim 
   * @param idStage
   * @param cdStagePersRelInt
   * @return Person
   */
  Person findStagePersonLinkByIdStageByCdStagePersRelInt(int idStage, String cdStagePersRelInt);
  
  /**
   * Select the SUB stagepersonlink for person given a idStage other than sub stage and dtStageOpen representing
   * the date used to consider a stage still open. 
   * @param idStage // stage other than SUB stage
   * @param dtStageOpen
   * @param idPerson
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkByIdStageByCdStageByIdPerson (String cdStagePersRole, Date dtStageOpen, 
                                                                   int idPerson);
  
  /**
   * Select the idPErson for a given stage and person and cdStagePersRole
   * @param idStage 
   * @param idPerson
   * @return cdStagePersRole
   */
  public Integer findIdPersonByIdStageIdPersonAndCdStagePersRole(int idStage, int idPerson, String cdStagePersRole);
  
  /**
   * Select the close SUB stagepersonlink for person given a idStage other than sub stage  
   * @param idStage // stage other than SUB stage
   * @param idPerson
   * @return StagePersonLink
   */
  StagePersonLink findClosedSUBStagePersonLinkByIdStageByCdStageByIdPerson (String cdStagePersRole, int idPerson);
  
  /**
   * Select the stagepersonlink for person given a idStage  
   * @param idStage 
   * @param idPerson
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkByIdStageByIdPerson (int idStage, int idPerson);

  /**
   * Select the stagepersonlink for person given a idStage  
   * @param idCase 
   * @param idPerson
   * @return StagePersonLink
   */
  StagePersonLink findStagePersonLinkByIdCaseByIdPerson (int idCase, int idPerson);
  
  /**
   * Use this method to verify that an open stage of type cdStage exists for the given idCase
   * where the idPerson has a role of cdStagePersRole.
   * 
   * @param idCase
   * @param cdStage
   * @param idPerson
   * @param cdStagePersRole
   * @return
   */
  Integer findIdStageForVerification(int idCase, String cdStage, int idPerson, String cdStagePersRole);
  
  /**
   * Use this method to return the list of open SUB and ADO stage from an FSU stage
   * 
   * @param idStage
   * @return List<Stage>
   */
  List<Stage> findOpenSUBorADOStagesByFSUidStage( int idStage );
  
  /**
   * Use this method to return the list of principals in a case under 18
   * 
   * @param idStage
   * @return List<Map>
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findIdPersonAndNmPersonFullUnder18FromStagePersonLinkAndPerson(int idStage);
  
  /**
   * Use this method to return the list of principals in a case 18 and over
   * 
   * @param idStage
   * @return List<Map>
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson(int idStage);
  
  /**
   *  Use this method to return the list of principals in a case 18 and over
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findPRNIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson(int idStage);
  
  /**
   * Use this method to return SPL data on a list of principals and collaterals in a stage
   * 
   * @param idStage
   * @return List<Map>
   */
  @SuppressWarnings({"unchecked"})
  public List<Map> findPrincipalsAndCollateralsFromStagePersonLinkAndPerson(int idStage);
  
  /**
   * Use this method to return SPL data on a list of principals and collaterals in a stage
   * 
   * @param idStage
   * @return List<Map>
   */
  public List<Map> findCdStageByIdStage(int idStage);
  
  /**
   * Use this method to return SPL data for the given stage and with relationship of Adoptive/Foster Parent or Precond. Adop. Par
   * 
   * @param idStage
   * @return List<Map>
   */
  public List<StagePersonLink> findStagePersonLinkByIdStageByCdStagePersRelInts(int idStage, Collection cdStagePersRelInts);
  
  
  /**
   * Use this method to return the primary children SPL data for the given stage
   * 
   * @param idCase
   * @param idStage
   * @return List<Map>
   */
  public List<StagePersonLink> findPrimaryChildrenByIdStage(int idStage);
  
  
  /**
   * Use this method to return SPL data for the given stage and with role of primary child
   * 
   * @param idStage
   * @param cdStagePersRole
   * @return StagePersonLink
   */
  public StagePersonLink findStagePersonLinkByIdStageByCdStagePersRole(int idStage, String cdStagePersRole);
  
  /**
   * Select a stagepersonlink based on an idStage, person relation, stage person type and gender
   *   or case
   * @param idStage
   * @param cdStagePersRelInt
   * @param cdStagePersType
   * @param gender
   * @return StagePersonLink
   */
  public Person findPersonByIdStageByCdStagePersRelIntGender(int idStage, String cdStagePersRelInt,
                                                             String cdStagePersType);
  
  /**
   * Select a stagepersonlink based on an idStage, person relation, stage person type and gender or case
   * 
   * @param idStage
   * @param cdStagePersRelInt
   * @param cdStagePersType
   * @param gender
   * @return StagePersonLink
   */
  public StagePersonLink findStagePersonLinkByIdStageByCdStagePersRelIntGender(int idStage, List<String> cdStagePersRelInt,
                                                                               String cdStagePersType, String gender);
  /**
   * Use this method to return the first person id returned for the the given stage Id and the relationship
   * 
   * @param idStage
   * @param cdStagePersRelInt
   * @return Integer
   */
  public Integer findIdPersonByIdStageAndCdStagePersRelInt(int idStage, String cdStagePersRelInt);

  /**
   * Use this method to return SPL data for the given stage and the relationship
   * 
   * @param idStage
   * @param cdStagePersRelInt
   * @return StagePersonLink
   */
  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findStagePersonLinkByIdStageAndCdStagePersRelInt(int idStage, List<String> cdStagePersRelInt);
  
  /**
   * Retrieve the PAD stage id, if there is any PAD stage in the system with 
   * the child as the primary child
   * 
   * @param idChild
   * @return Integer
   */
  public Integer findIdStageByIdPersonCdStage(int idChild);
  
  /**
   * Retrieve the Id Stage of the primary child for the case and the code stage 
   * @param idChild
   * @param idCase
   * @param cdStage
   * @return
   */
  Integer findIdStageByIdPersonCdStageIdCase(int idChild, int idCase, String cdStage);
  
  /**
   * Retrieve the count of SUB stages, if there is any SUB stage in the system with 
   * the child as the primary child
   * 
   * @param idChild
   * @return long
   */
  public long countSubStageByIdPersonCdStage(int idChild);
  
  /**
   * Retrieves the person object for a given stage and role
   * 
   * @param idStage
   * @return String
   */
  public Person findNmPersonByIdStageByCdStagePersRole(int idStage, String cdStagePersRole);
  
  /**
   * Gets the person id list of all the adults marked as Principal in the
   * given stage
   * @param idStage
   * @return
   */
  List<Object> findPrincipalAdultsByStage(int idStage, Collection<String> relationship);
  
  /**
   * 
   * @param idStage
   * @param cdStagePersRelInt
   * @return List<String> Genders of Adoptive Parents
   */
  List<StagePersonLink> findCdPersonSexByCdStagePersRelInt(int idStage, String cdStagePersRelInt);
  
  String findPersonRoleByIdPerson(int idPerson, int idStage);//mxpatel added this for defect #9851
  
  /**
   * Find fcc stages with the specified case id
   * 
   * @param idCase 
   * @return List<Integer>
   */
   List<Integer> findFccIdPersonByIdCase(int idCase);
  
   /**
    * Inserts a new stage person link record
    * @param idStage
    * @param idPerson
    * @param idCase
    * @param cdStagePersRole
    * @param cdStagePersType
    * @param dtStagePersLink
    * @return
    */
   int insertNewStagePersonLink(int idStage, int idPerson, int idCase, String cdStagePersRole,
                                String cdStagePersType, Date dtStagePersLink);

   
	/**
	 * Find all (open or closed) ado stage primary child ids with the specified case id
	 * 
	 * @param idCase 
	 * @return List<Integer>
	 */
	@SuppressWarnings( { "unchecked" })
	List<Integer> findAllPrimaryChildIdsForAdoStagesByIdCase(int idCase); 

   /**
    * return a list of peoples marital statuses based on StagePersRelInt
    * @param idStage
    * @param cdStagePersRelInt
    * @return long
    *  */
   List<String> listMaritalStatusByCdStagePersRelInt(int idStage, String cdStagePersRelInt);
	
   /**
    * Gets the id of the primary child and age in months
    * @param idStage
    * @return
    */
   @SuppressWarnings( { "unchecked" })
   Map findIdChildNmStageByIdStage(int idStage);
   
   /**
    * Gets the List of open stages for the person as primary caretaker
    * @param idPerson
    * @return
    */
   List<Integer> findIdStageByIdPersonCdStagePersRelInt(int idPerson);
   
   /** STGAP00012833:
    * Gets the last primary case manager assigned to the case for that stage
    * @param idStage
    * @return Integer
    */
   Integer findIdCaseWorkerByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole);
   List<Integer> findIdAdoStageByIdEventIdCase(int idEvent, int idCase, String cdStage, String cdPersonRole);
   
   /** 
    * STGAP00014329: This method returns the member of the Primary Caretakers house hold who are under the age of 18
    * @param idStage
    * @return
    */
   @SuppressWarnings( { "unchecked" })
   List<Map> findMemberPKHouseHoldFromStagePersonLinkAndPersonDtl(int idStage);
   
   /** 
    * STGAP00014329: This method returns the list of persons who has the safety resource checkbox checked on the person detail page.
    * @param idStage
    * @return
    */
   @SuppressWarnings( { "unchecked" })
   List<Map> findPersonSafetyResCheckedFromStagePersonLink(int idStage);
   
   /**STGAP00014336: Get the father or mother of the child in ADO stage
    *   
    * @param idStage
    * @param Collection<String>
    * @return
    */
   List<Integer> findIdPersonParentByIdStage(int idStage, Collection<String> relationType, String gender); 
   
   /** 
    * //STGAP00014341: Return the person for idStage and HP role
    * @param idStage
    * @return
    */
   StagePersonLink findIdPersonByIdStageCdStagePersRole(int idStage);
   
   /** 
    * //STGAP00014341: delete stage person link for id staff person and id stage
    * @param idPerson
    * @param idStage
    * @return
    */
   int deleteStagePersonLinkByIdPersonIdStage(int idPerson, int idStage);
   
   /** 
    * STGAP00014598 : Gets the latest primary case manager or Historical Case Manager assigned to the stage
    * @param idStage
    * @return
    */
   Integer findIdCaseWorkerByIdStageAndCdStagePersRole(int idStage);
   
   Integer findIdOpenFccStageByIdPerson(int idPerson);
   
   /**
    * Retrieves the SUB stage for a person in a particular case
    * 
    * @param idPerson
    * @param idCase
    * @return
    */
   Integer findIdOpenFccStageByIdPersonIdCase(int idPerson, int idCase);
   
   // STGAP00017013: MR-095
   /**
    * Retrieves the SUB stage for a person in a particular case
    * 
    * @param idPerson
    * @param idCase
    * @return
    */
   long countStagePersonLinkOpenFccStageByIdPersonIdCase(int idPerson, int idCase);
   
   /**
    * 
    * @param idCase
    * @param idPersons
    * @param cdStagePersRole
    * @param cdStagePersType
    * @return List of Persons
    */
   List<Person> findPersonsByIdCaseByIdPersonsByCdPersonRoleByCdStagePersTypeByCdADOStage(int idCase,
                                                                              Collection<Integer> idPersons,
                                                                              String cdStagePersRole,
                                                                              String cdStagePersType);
   
   /**
    * This method finds the fathers and mothers of the child.
    * @param idStage
    * @param cdPersonSex
    * @return
    */
   List<Map<String, Object>> findFathersMothersByIdStageByCdPersonSex(int idStage, String cdPersonSex);
   
   /**
    * This method finds the secondary care givers of the child.
    * @param idStage
    * @return
    */
   List<Map<String, Object>> findSecondaryCaregiverByIdStage(int idStage);
   
   /**
    * STGAP00015485 Added this method to update cdPKHouseholdMember when mulitple persons are selected on
    * Intake info and Detail button is pushed
    * @param cdPKHouseholdMember
    * @param idPerson
    * @param idStage
    * @return
    */
   int updateStagePersonLinkCdPKHouseholdMember(String cdPKHouseholdMember, int idPerson, int idStage);
   Integer findIdFccStageByIdPerson(int idPerson);
   
   /** 
    * MR-057 This method returns the Foster Parents for the FAD stage
    * @param idStage
    * @return  List<Map>
    */
   @SuppressWarnings( { "unchecked" })
   List<Map> findIdPersonAndNmPersonFullFosterParentsFromStagePersonLinkAndPerson(int idStage);
   /**
    * Find the Person object for the given stage where the type needs to staff
    * and the employee code needs to be one of the ILP's ('G1007','14203ILP', '14201ILP' - ILP Codes)
    * @param idStage
    * @return
    */
   Person findStagePersonLinkWithAssignedIPL(int idStage);
   long countStagePersonLinkByIdEventAndIdPerson(int idStage, Collection<String> relationships, Date dtCrtActionDate);
   /**
    * SMS#45718 This method gets all the children for ONG
    * @param idStage
    * @return
    */
   List<Integer> findAllChildrenFPRStagesByIdStage(int idStage);
   
   /**
    * SMS#45718 This method gets all the children for FCF
    * @param idCase
    * @return
    */
   List<Integer> findAllChildrenFCCStagesByIdCase(int idCase);

   /**
    * STGAP00017013: MR-095 This method gets all the children for FCC
    * @param idCase
    * @param idStage
    * @return
    */
   List<StagePersonLink> findAllChildrenFCCStagesByIdCaseByStage(int idCase, int idStage);
   
   /** 
    * MR-62 This method returns the All the persons for the stage other than children in ADO FCC stages
    * @param idCase
    * @return  List<Map>
    */
    List<Integer> findAllPersonFCCByIdCase(int idCase);
   
   /** 
    * MR-62 This method returns the All the persons for the stage other than children in FPR
    * @param idStage
    * @return  List<Map>
    */
    List<Integer> findAllPersonFPRByIdStage(int idStage); 
    /**
     * Adding for CPS Investigation Conclusion CAPTA Changes
     * @param idStage
     * @return
     */
    List<Integer> findPrincipalPersonsUnderThreeByIdStage(int idStage);
    
    /**
     * This will return an idStage and idCaseManager for stages
     * involving idPerson with cdStages
     * @param idPerson
     * @param cdStages
     * @return
     */
    List<Object[]> findIdStageIdCaseManagerByIdPersonCdStage(int idPerson, Set<String> cdStages);
    int deleteStagePersonLinkFromStage(int idStage, int idPerson);
    
    /**
     * MR-066 Get the case managers of the children placed in a Resource
     * @param idRsrcFacil
     * @return
     */
   List<Integer> findStagePersonLinkByIdResource(int idRsrcFacil);
   
   /**
    * SMS#
    * @param idStage
    * @return
    */
   public List<BigDecimal> findPrincipalByStageIdWithDODAndAgeLT18(int idStage);
   
   /**
    * MR-041 Get the Primary child for ADO stage
    * @param idStage
    * @return
    */
   Integer findIdPersonForChildByIdADOStage(int idStage);
   
   /**
    * MR-072 Gets the persons who are PRN or Member of PK household who are under the age of 17
    * @param idStage
    * @return
    */
   List<Integer> findPersonsPRNOrMemberPKHshldByIdStageUnder17(int idStage);
   
   /**
    * MR-072 Gets the persons who are PRN or Member of PK household who are over the age of 17
    * @param idStage
    * @return
    */
   List<Integer> findPersonsPRNOrMemberPKHshldByIdStageOver17(int idStage);
   
   /**
    * MR-072 Find how many hours it's been since the person is added or related to the stage
    * @param idPerson
    * @return
    */
   Double findHoursBetweenDtPersonAddedAndTodaysDate(int idPerson);

   /**
    * MR-072 Find how many hours it's been since the person is stage progressed
    * @param idPerson
    * @return
    */
   Double findHoursBetweenPersonDtStageProgressedAndTodaysDate(int idPerson);
   
   /**
    * MR-067 Find number stage person link for open stages that exist for person
    * @param idPerson
    * @param cdStagePersRoles
    * @param cdStageTypeList
    * @return long
    */
   public long countOpenStagesByIdPersonAndPersRolesAndCdStages(int idPerson, Collection cdStagePersRoles,
                                                               Collection cdStageTypeList);

   /**
    * MR-067 Find number of stage person links for open stages that exists for person
    * @param idPerson
    * @return long
    */
   public long countStagePersonLinkForOpenStagesByIdPerson(int idPerson);
   
   /**
    * 
    * @param idCase
    * @param idPerson
    * @param cdStage
    * @return
    */
   public StagePersonLink findLatestStagePersonLinkByIdCaseByIdPersosByCdStage(int idCase, int idPerson, String cdStage);
   
   /**
    * 
    */
   public long countStagePersonLinkByIdStageCdStagePersRelInt(
			int idStage, String cdStagePersRelInt);
   
   /**
    * Get the List<StagePersonLink> of the stage person link records by idStage, cdStagePersType and cdStagePersRelInt
    * @param idStage
    * @param cdStagePersType
    * @param cdStagePersRelInt
    * @return List<StagePersonLink>
    * 
    */
   List<StagePersonLink> findStagePersonLinkByIdStageCdStagePersTypeCdStagePersRelInt(int idStage,
                                                                                     String cdStagePersType,
                                                                                     String cdStagePersRelInt);

   /**
    * Get the count of the stage person link records by idStage, cdStagePersType and cdStagePersRelInt
    * @param idStage
    * @param cdStagePersType
    * @param cdStagePersRelInt
    * @param cdPersonSex
    * @return long
    * 
    */
   long countStagePersonLinkByIdStageCdStagePersTypeCdStagePersRelIntCdPersonSex(int idStage, String cdStagePersType,
                                                                     String cdStagePersRelInt, String cdPersonSex);

   /**
    * Get the count of the stage person link records by idStage, cdStagePersType and cdStagePersRelInt
    * @param idStage
    * @param cdStagePersType
    * @param cdPersonSex
    * @return long
    * 
    */
   long countStagePersonLinkByIdStageCdStagePersTypeCdPersonSex(int idStage, String cdStagePersType, String cdPersonSex);
   
   /**
     * Get list of stage person link records by idStage and cdStagePersRole
     * 
     * @param idPerson
     * @param cdStagePersRole
     * @return List<StagePersonLink>
     */
   List<StagePersonLink> findStagePersonLinkByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole);

   /**
    * Get prior foster care history ADO stage by current child person id.
    * @param idPerson - Child current person id
    * @return Integer - Prior foster care ADO person id and stage id map. If No history found then no result will return.
    */
   Map<String, Integer> findPriorAdoptionIdPersonIdAdoStage(int idPerson);

   /**
    * This is an inverse of findPriorAdoptionIdPersonIdAdoStage(int idChild). It retrieves the child's current
    * PAD stage by using the prior ADO stage that is linked to it
    * 
    * @param idChild - Prior foster care ADO person id
    * @return Map - Containing Current PAD person id and Stage id map. If current PAD is found then no result will return.
    */
   Map<String, Integer> findPADStageByPriorAdoptionIdPersonIdAdoStage(int idChild);
   /**
    * Get principal children in primary child ADO stage who DOES NOT have an open ADO stage
    * in the current case, but the children does have an open ADO stage in another case.
    * @param idAdoStage - ADO stage id of primary child.
    * @param idPerson - Primary Child id person.
    * @return List<StagePersonLink> - List of principal children open ADO stage person link for another case.
    */
   List<StagePersonLink> findPrincipalChildrenOpenAdoStagePersonLinkInAnotherCaseByPcIdAdoStageByPcIdPerson(int idAdoStage, int idPrimaryChild);
   
   /**
    * Find other cases that a person are part of, specified by type, other than the current case
    * @param thisCase
    * @param idPerson
    * @param cdStagePersTypeSet
    * @return id cases
    */
   List<Integer> findOtherIdCaseByIdCaseIdPersonCdStagePersType(Integer thisCase, Integer idPerson, 
                                                                      Collection<String> cdStagePersTypeSet);
   
  /**
   * Count open and incomplete intake (case id not exists) that a person is a principal of 
   * and where the intake is opened prior to a date 
   * @param idPerson
   * @param cdStagePersTypeSet
   * @param cdStages
   * @param aDate
   * @return
   */
   long countStagePersonLinkByIdPersonCdPersTypeCdStageDtStageStart(Integer idPerson,
                                                                   Collection<String> cdStagePersTypeSet,
                                                                   Collection<String> cdStages, Date aDate);
   
   /**
    * Count stage person link rows where a person is added/related as a certain type to a stage before a certain date
    * @param idCaseSet
    * @param idPerson
    * @param dtPersAdded
    * @return
    */
   long countStagePersonLinkByIdCaseIdPersonCdPersTypeDtPersAdded(Collection<Integer> idCaseSet, Integer idPerson,
                                                                  Collection<String> cdStagePersTypeSet, Date dtPersAdded);
   
   /**
    * Find id cases for a person of certain person type in certain stages of certain cases where the case started before a certain date
    * @param idCaseSet
    * @param idPerson
    * @param cdStageSet
    * @param cdStagePersTypeSet
    * @return
    */
   long countStagePersonLinkByIdCaseIdPersonCdStageCdPersTypeDtCaseOpened(Collection<Integer> idCaseSet, int idPerson, Collection<String> cdStageSet,
                                                                                     Collection<String> cdStagePersTypeSet, Date aDate);

}
