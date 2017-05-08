package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.math.BigDecimal;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

/**
 * This is the DAO class for STAGE_PERSON_LINK
 * 
 * 
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  06/08/08    SWR            STGAP00006446 - Added findHomeMembersDetailLinkedToStage() method to support
 *                             Policy Violation Report.
 * 
 *                      
 *  06/24/08    Charden        STGAP00006217 - Added findCdStageByIdStage() method                   
 * 
 *  06/17/08    PJC            STGAP00008568: Added findPrincipalsAndCollateralsFromStagePersonLinkAndPerson,
 *                             findIdPersonAndNmPersonFullUnder18FromStagePersonLinkAndPerson, 
 *                             findIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson to support Safety Resource 
 *  
 *  07/08/08    arege          STGAP00008896 Added updateStagePersonLinkClearIdCaseByIdStage method to resolve constraint
 *                             violation while deleting capsCase record. (This method is not used anymore since another
 *                             fix was found for STGAP008896)
 *                                                   
 *  09/16/2008  arege          STGAP00010091 Modified findStagePersonLinkByIdCaseByIdPersonsByCdStagesByCdPersonRole() so that 
 *                             the query returns data for both open and closed FCC stages.
 *                      
 *  09/26/2008  mxpatel        STGAP00009851 - Created findPersonRoleByIdPerson(int idPerson, int idStage method to retrieve
 *                             the CD_PERSON_ROLE of the person from stagePersonLink table.
 *                      
 *  01/31/2009  wjcochran      STGAP00012065 - modified insertNewStagePersonLink to mark the entry as a new assignment
 *  
 *  02/03/2009  hjbaptiste     STGAP00012311: modified findAllPrimaryChildIdsForAdoStagesByIdCase().
 *                             Added check for child in FCC stage to support creating  an alert when a child is placed in FC 
 *                             and a sibling has been adopted
 *                             
 *  03/04/2009  bgehlot        STGAP00012734: Added the method findIdStageByIdPersonCdStagePersRelInt().
 *  
 *  03/24/2009  bgehlot        STGAP00012833: Added method findIdCaseWorkerByIdStageAndCdStagePersRole()
 *  
 *  06/01/2009  cwells         STGAP00014023: Added the method countStageAssignedHistory()
 *  06/12/2009  mxpatel        STGAP00012669: added findIdAdoStageByIdEventIdCase method to find find all ado stage for the children
 *                             selected on the FCCP Family plan.
 *  06/12/2009  mxpatel        STGAP00013356: removed changed that were made fore defect #10091
 *  06/22/2009  bgehlot        STGAP00014329: Added method findMemberPKHouseHoldFromStagePersonLinkAndPersonDtl,
 *                                            findPersonSafetyResCheckedFromStagePersonLink
 *  06/29/2009  bgehlot        STGAP00014336: Added method findIdPersonParentByIdStage
 *  07/23/2009  bgehlot        STGAP00014341: Added method findIdPersonByIdStageCdStagePersRole, deleteStagePersonLinkByIdPersonIdStage
 *  08/13/2009  eudofiah       STGAP00015065: Added method findStagePersonLinkAndPersonByidCase
 *  09/14/2009  bgehlot        STGAP00014598: Added method findIdCaseWorkerByIdStageAndCdStagePersRole
 *  09/17/2009  mxpatel        STGAP00014707: added findIdOpenFccStageByIdPerson(int idPerson) method to find the most recent, OPEN FCC stage for the child
 *  09/23/2009  mxpatel        STGAP00013963: added method findIdPersonrByIdStageAndCdStagePersRole
 *  09/24/2009  bgehlot        STGAP00015351: Removed the stage condition from the method findIdPersonParentByIdStage
 *  09/27/2009  arege          STGAP00013356: Added method findPersonsByIdCaseByIdPersonsByCdPersonRoleByCdStagePersTypeByCdADOStage to find if there is an open ADO stage for the
 *                             list of persons passed to the method.
 *  09/30/2009 bgehlot         STGAP00015485: MR-056 Added two new methods findFathersMothersByIdStageByCdPersonSex,
 *                             findSecondaryCaregiverByIdStage. added cdPKHouseholdMember in insertStagePersonLink and 
 *                             updateStagePersonLink, insertStagePersonLinkWihoutIndNmStage, updateStagePersonLinkWithoutIndNmStage methods
 *  10/02/2009 hjbaptiste      STGAP00015485: Added new method findAllPrincipalsForStageInPKHshld() to retrieve the principals that are members of the
 *                             primary caretaker's household  
 *  10/02/2009 hjbaptiste      STGAP00015485: Added new method findUnknownMbrPkHshldIdPersonByIdStageAndCdStagePersType() to retrieve any principals who are unknown
 *                             if they are members of the primary caretaker's household  
 *  10/06/2009 bgehlot         STGAP00015485: Added method updateStagePersonLinkCdPKHouseholdMember
 *  11/10/2008 mxpatel         37257: added method findIdFccStageByIdPerson. Modified findPrincipalAdultsByStage method to retrieve both PRN and COL adults.
 *  11/30/2009 bgehlot         41275 MR-057 Added method findIdPersonAndNmPersonFullFosterParentsFromStagePersonLinkAndPerson
 *  12/15/2009 cwells          38677- copying side of family infromation when creating a new stage. 
 *  01/14/2010 bgehlot         SMS#43632- Changed queries to exclude 'PC' from the findIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson and
 *                             findIdPersonAndNmPersonFullFosterParentsFromStagePersonLinkAndPerson
 *  02/08/2010 mxpatel         CAPTA: Added countStagePersonLinkByIdEventAndIdPerson method to find any persons with CS or GX relationships in the stage
 *  02/10/2010 wjcochran       SMS $44832 - Added method findAllPrincipalsForStageInPKHshldNull for retrieving
 *                             all principals without a value stored for "Member of Primary Caretaker's Household" 
 *  02/19/2010 bgehlot         SMS#45718 Added methods findIdPersonFromStagePersonLinkAndPersonByDesignatedVictim and  
 *                             findAllChildrenFCCStagesByIdCase, findAllPersonFCCByIdCase, findAllPersonFPRByIdCase                         
 *  02/22/2010 wjcochran       MR-062 - Removed >= 18 year old condition from methods findFathersMothersByIdStageByCdPersonSex
 *                             and findSecondaryCaregiverByIdStage
 *  03/03/2010 cwells          Per Capta added method findListOfOpenStagesByCdStageType()
 *  03/05/2010 mxpatel         Per Capta: Modified the method - countStagePersonLinkByIdEventAndIdPerson to make sure assigned date is 
 *                             equal or prior to the court action date and the unassigned date is after or equal to the court action date
 *  03/16/2010 bgehlot         MR-62 Changed the query for findIdPersonFromStagePersonLinkAndPersonByDesignatedVictim
 *  03/18/2010 wjcochran       SMS #37458: Added method findIdStageIdCaseManagerByIdPersonCdStage                           
 *  03/18/2010 bgehlot         SMS#45718 Changed the method names and queries to return results for stage rather than case for FPR.
 *  04/19/2010 mxpatel         SMS#42493:  Added method deleteStagePersonLinkFromStage to make sure stagePersonLink of staff is not deleted.
 *  04/27/2010 bgehlot         MR-064: Changed the method name and query to pre-populate children under the age of 18 
 *                                     that are members of the primary caretaker's household. for FPR.
 *  05/21/2010 mxpatel         SMS #49518: Modified the code so that when retrieving stage_person_link records, we do not 
 *                             retrieve records for "Information and Referral" intakes which have no stage associated with them 
 *                             since they were "save and closed" from the intake information page.  
 *  05/27/2010 bgehlot         SMS#51977 MR-066 Changes                         
 *  08/06/2010 bgehlot         SMS #65398 Added method findIdPersonForChildByIdADOStage
 *  08/18/2010  bgehlot        SMS 66380 MR-072 Changes
 *  09/28/2010  hnguyen        SMS#73860 Added countStagePersonLinkForOpenStagesByIdPerson method
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
 *  06/09/2011 Corey Harden    created method findStagePersonLinkByidPersons(List<Integer> idPersonList)
 *  07/10/2011 hjbaptiste      SMS#114045: CAPTA 4.3: Special Investigation - Modified findSUBCaseManagerByIdChild by capitalizing 'PC' and 'PR'     
 *  07/11/2011 arege           SMS#109422: Modified method findPersonsPRNOrMemberPKHshldByIdStageOver17 to take into account persons with no DOB entered                                              
 *  09/07/2011 schoi           STGAP00017013: MR-095 Added new method insertStagePersonLinkAddedFromAddPersonToActiveStages
 *  09/12/2011 hnguyen         STGAP00017011: MR-092 Added new method findPriorAdoptionIdPersonIdAdoStage and findPriorAdoptionIdPerson
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
 *  10/25/2011 hnguyen         STGAP00017246: MR-092 Corrected query for findPADStageByPriorAdoptionIdPersonIdAdoStage.
 *  01/23/2012 arege           STGAP00017827: MR-085 Added new method findPRNIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson
 *  02/08/2012 htvo            STGAP00017831: MR-102 Added methods
 *                             - findOtherIdCaseByIdCaseIdPersonCdStagePersType
 *                             - countStagePersonLinkByIdCaseIdPersonCdStageCdPersTypeDtCaseOpened
 *                             - countStagePersonLinkByIdCaseIdPersonCdPersTypeDtPersAdded
 *                             - countStagePersonLinkByIdPersonCdPersTypeCdStageDtStageStart
 * </pre>
 */

public class StagePersonLinkDAOImpl extends BaseDAOImpl implements StagePersonLinkDAO {
  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findStagePersonLinkByidPersons(List<Integer> idPersonList) {
    Query query = getSession().createQuery("from StagePersonLink spl "
                                                           + "where spl.person.idPerson in (:idPersonList) ");
    query.setParameterList("idPersonList", idPersonList);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findStagePersonLinkByIdStageRoleHousehold(int idStage) {
    Query query = getSession().createQuery("from StagePersonLink spl " + " left join fetch spl.person "
                                                           + " left join fetch spl.stage "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and (spl.cdPKHshdMember = :cdPKHshdMember "
                                                           + " or spl.cdStagePersType = 'PRN') ");
    query.setInteger("idStage", idStage);
    query.setString("cdPKHshdMember", ArchitectureConstants.Y);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findStagePersonLinkByIdStage(int idStage) {
    Query query = getSession().createQuery("from StagePersonLink spl " + " left join fetch spl.stage "
                                                           + " left join fetch spl.capsCase "
                                                           + " where spl.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (List<StagePersonLink>) query.list();
  }

  /*
   * This method is used for updating the CSUP_PARENT_OUTBOUND table for calculating the per diem info for each child.
   * This query returns all the stages the person id is in
   */
  @SuppressWarnings("unchecked")
  public List<Integer> findIdStageByIdPersonParentForPerDiem(int idPerson) {
    Query query = getSession().createQuery("select spl.stage.idStage "
                                                           + "from StagePersonLink spl "
                                                           + "where spl.person.idPerson = :idPerson "
                                                           + "and spl.cdStagePersRelInt in ('PA', 'AB', 'BF', 'BM', 'LM', 'LF', 'MP', 'PF', 'AP', 'PK') "
                                                           + "and spl.stage.indStageClose = 'N' "
                                                           + "and spl.stage.cdStage = :cdStageSUB");

    query.setInteger("idPerson", idPerson);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);

    return (List<Integer>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findNcpsForFccChild(int idStage) {
    Query query = getSession().createQuery("select spl "
                                                           + " from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage"
                                                           + " and spl.stage.indStageClose = 'N'"
                                                           + " and spl.stage.cdStage = :cdStageSUB"
                                                           + " and spl.cdStagePersType = 'PRN'"
                                                           + " and spl.cdStagePersRelInt in ('PK', 'PA', 'AB', 'BF', 'BM', 'LM', 'LF', 'MP', 'PF', 'AP')");
    query.setInteger("idStage", idStage);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);

    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findNcpsForChild(int idStage) {
    Query query = getSession().createQuery("select spl "
                                                           + " from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage"
                                                           + " and spl.stage.indStageClose = 'N'"
                                                           + " and spl.cdStagePersType = 'PRN'"
                                                           + " and spl.cdStagePersRelInt in ('BF', 'LF', 'PF', 'BM', 'LM', 'MP', 'PK', 'PA', 'AB', 'AP')");
    query.setInteger("idStage", idStage);

    return (List<StagePersonLink>) query.list();
  }

  public Integer findIdPersonByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "  from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersRole = :cdStagePersRole");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (Integer) firstResult(query);
  }

  // mxpatel STGAP00014707 - added this method to find the most recent, OPEN FCC stage for the child
  public Integer findIdOpenFccStageByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select spl.stage.idStage "
                                                           + " from StagePersonLink spl, Stage s "
                                                           + " where spl.stage.idStage = s.idStage "
                                                           + " and spl.person.idPerson = :idPerson "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and s.cdStage = :cdStageSUB "
                                                           + " and (s.dtStageClose is null or s.dtStageClose = '' or s.dtStageClose = :maxDate)");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStagePersRole", CodesTables.CROLES_PC);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Integer) firstResult(query);
  }

  public Integer findIdOpenFccStageByIdPersonIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery("select spl.stage.idStage "
                                                           + " from StagePersonLink spl, Stage s "
                                                           + " where spl.stage.idStage = s.idStage "
                                                           + " and spl.capsCase.idCase = :idCase "
                                                           + " and spl.person.idPerson = :idPerson "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and s.cdStage = :cdStageSUB "
                                                           + " and (s.dtStageClose is null or s.dtStageClose = '' or s.dtStageClose = :maxDate)");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStagePersRole", CodesTables.CROLES_PC);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Integer) firstResult(query);
  }

  // STGAP00017013: MR-095
  public long countStagePersonLinkOpenFccStageByIdPersonIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery("select count(spl.stage.idStage) "
                                           + " from StagePersonLink spl, Stage s "
                                           + " where spl.stage.idStage = s.idStage "
                                                           + " and spl.capsCase.idCase = :idCase "
                                                           + " and spl.person.idPerson = :idPerson "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and s.cdStage = :cdStageSUB "
                                                           + " and (s.dtStageClose is null or s.dtStageClose = '' or s.dtStageClose = :maxDate)");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStagePersRole", CodesTables.CROLES_PC);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }
  
  // 37257: added this method to find idStage of the FCC stage for a child
  public Integer findIdFccStageByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select spl.stage.idStage " + " from StagePersonLink spl, Stage s "
                                                           + " where spl.stage.idStage = s.idStage "
                                                           + " and spl.person.idPerson = :idPerson "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and s.cdStage = :cdStageSUB ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStagePersRole", CodesTables.CROLES_PC);
    return (Integer) firstResult(query);
  }

  public Integer findIdPersonForCaseManagerByIdStage(int idStage) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "  from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersRole in ('"
                                                           + CodesTables.CROLEALL_PR + "' , '"
                                                           + CodesTables.CROLEALL_HP + "') order by spl.dtLastUpdate ");
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  public Integer findIdPersonForCaseManagerByIdStageOrderDesc(int idStage) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "  from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersRole in ('"
                                                           + CodesTables.CROLEALL_PR
                                                           + "') order by spl.dtStagePersLink desc ");
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  /*
   * This method is used for updating the INCOME_AND_RESOURCES table for Receive Child Support Payment Info Service.
   * This query returns all the Child/personId for the Parent/personId for the stages
   */
  @SuppressWarnings("unchecked")
  public Integer findIdPersonForChildByIdStage(int idStage) {
    Query query = getSession().createQuery("select distinct spl.person.idPerson " + "from " + "StagePersonLink spl "
                                                           + "where " + "spl.stage.idStage = :idStage AND "
                                                           + "spl.cdStagePersRole = 'PC'");
    query.setInteger("idStage", idStage);

    return (Integer) firstResult(query);
  }

  public String findRelIntByIdEventIdPerson(int idEvent, int idPerson) {
    Query query = getSession().createQuery("select spl.cdStagePersRelInt "
                                                           + "from StagePersonLink spl "
                                                           + "where spl.person.idPerson = :idPerson "
                                                           + "AND spl.stage.idStage = (select e.stage.idStage from Event e "
                                                           + "where e.idEvent = :idEvent)");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    return (String) query.uniqueResult();
  }

  /*
   * This method is used for updating the INCOME_AND_RESOURCES table for Receive Child Support Payment Info Service.
   * This query returns all the stages the person id is in
   */
  @SuppressWarnings("unchecked")
  public List<Integer> findIdStageByIdPersonParent(int idPerson, String cdCounty) {
    Query query = getSession().createQuery("select spl.stage.idStage "
                                                           + "from StagePersonLink spl "
                                                           + "where spl.person.idPerson = :idPerson "
                                                           + "and spl.cdStagePersRelInt in ('PK', 'PA', 'AB', 'BF', 'BM', 'LM', 'LF', 'MP', 'PF', 'AP') "
                                                           + "and spl.stage.indStageClose = 'N' "
                                                           + "and spl.stage.cdStageCnty = :cdCounty "
                                                           + "and spl.stage.cdStage = :cdStageSUB");

    query.setInteger("idPerson", idPerson);
    query.setString("cdCounty", cdCounty);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);

    return (List<Integer>) query.list();
  }

  // STGAP00012669: find all the ado stages for the children selected on the FCCP family plan detail.
  @SuppressWarnings("unchecked")
  public List<Integer> findIdAdoStageByIdEventIdCase(int idEvent, int idCase, String cdStage, String cdPersonRole) {
    Query query = getSession().createQuery(" select spl.stage.idStage "
                                                           + " from StagePersonLink spl, EventPersonLink epl, Stage s "
                                                           + " where spl.stage.idStage = s.idStage "
                                                           + " and spl.person.idPerson = epl.person.idPerson "
                                                           + " and epl.event.idEvent = :idEvent "
                                                           + " and s.cdStage = :cdStage "
                                                           + " and s.capsCase.idCase = :idCase "
                                                           + " and spl.cdStagePersRole = :cdPersonRole "
                                                           + " and (s.dtStageClose is null "
                                                           + "         or s.dtStageClose = :maxDate) ");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    query.setString("cdPersonRole", cdPersonRole);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();
  }

  /**
   * This method is used for checking to see if the idPerson was ever assigned to a particular stage it also checks to
   * see if the idPerson is in the unit hierarchy.
   */
  public BigDecimal countStageAssignedHistory(int idPerson, int idCase, int idStage) {
    @SuppressWarnings("unchecked")
    SQLQuery query = getSession().createSQLQuery(" SELECT COUNT(*) "
                                                                 + " FROM stage_person_link spl, stage_assign_history sah "
                                                                 + "WHERE " + "sah.id_stage = spl.id_stage AND "
                                                                 + "sah.id_person = spl.id_person AND "
                                                                 + "sah.id_case = spl.id_case AND "
                                                                 + "sah.id_case = :idCase AND "
                                                                 + "sah.id_person = :idPerson AND "
                                                                 + "sah.id_stage = :idStage");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    return (BigDecimal) query.uniqueResult();
  }

  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  @SuppressWarnings("unchecked")
  public Object[] findIdPersonByIdStagePersRole(int idPerson) {
    SQLQuery query = getSession().createSQLQuery(" SELECT spl.id_person, spl.id_stage "
                                                                 + "FROM "
                                                                 + "STAGE_PERSON_LINK spl "
                                                                 + "WHERE "
                                                                 + "spl.id_stage IN "
                                                                 + "(SELECT s.id_stage "
                                                                 + "FROM STAGE s "
                                                                 + "WHERE s.id_stage IN "
                                                                 + "(SELECT spl2.id_stage "
                                                                 + "FROM STAGE_PERSON_LINK spl2 "
                                                                 + "WHERE spl2.id_person = :idPerson) "
                                                                 + "AND (s.dt_stage_close IS NULL OR s.dt_stage_close = '12/31/4712')) "
                                                                 + "AND spl.cd_stage_pers_role = 'PR'");
    query.setInteger("idPerson", idPerson);
    return (Object[]) firstResult(query);
  }

  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  @SuppressWarnings("unchecked")
  public Object[] findCaseIdByChildIdPerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery(" SELECT s.id_case, spl.id_stage "
                                                                 + "FROM "
                                                                 + "STAGE_PERSON_LINK spl, STAGE s "
                                                                 + "WHERE "
                                                                 + "s.id_stage = spl.id_stage AND "
                                                                 + "spl.id_person = :idPerson AND "
                                                                 + "spl.cd_stage_pers_role = 'PC' AND "
                                                                 + "s.ind_Stage_Close = 'N' AND "
                                                                 + "(s.dt_stage_close IS NULL OR s.dt_stage_close = '12/31/4712') AND "
                                                                 + "s.cd_stage = 'SUB'");
    query.setInteger("idPerson", idPerson);
    return (Object[]) firstResult(query);
  }

  public long countStagePersonLinkByIdStageAndIdPerson(int idStage) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink a, " + "       Person b "
                                                           + " where a.stage.idStage = :idStage "
                                                           + "   and a.person.idPerson = b.idPerson "
                                                           + "   and b.dtPersonDeath is null "
                                                           + "   and a.cdStagePersRole = :stagePersRole");
    query.setInteger("idStage", idStage);
    query.setString("stagePersRole", "DV");
    return (Long) query.uniqueResult();
  }

  // CAPTA changes
  public long countStagePersonLinkByIdEventAndIdPerson(int idStage, Collection<String> relationships,
                                                       Date dtCrtActionDate) {
    String cdEventType = CodesTables.CEVNTTYP_LEG;
    Query query = getSession().createQuery(" select count (*) "
                                                           + "from StageRepLink srl, StagePersonLink spl "
                                                           + "where spl.stage.idStage = srl.stage.idStage "
                                                           + "and srl.stage.idStage = :idStage "
                                                           + "and spl.cdStagePersRelInt in (:relationships) "
                                                           + "and srl.dtRepStart <= :dtCrtActionDate "
                                                           + "and (srl.dtRepEnd >= :dtCrtActionDate or srl.dtRepEnd is null)");
    query.setInteger("idStage", idStage);
    query.setParameterList("relationships", relationships);
    query.setTimestamp("dtCrtActionDate", dtCrtActionDate);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map<String, Object>> findStagePersonLinkByIdStageAndCdStagePersType(int idStage, String cdStagePersType) {
    Query query = getSession().createQuery("select new map (person.idPerson as idPerson, "
                                                           + "                dtLastUpdate as dtLastUpdate) "
                                                           + "  from StagePersonLink "
                                                           + " where stage.idStage = :idStage "
                                                           + "   and cdStagePersType = :cdStagePersType");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    return (List<Map<String, Object>>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public PaginatedHibernateList<StagePersonLink> findStagePersonLinkByIdPersonAndCdStage(int idPerson, String cdStage,
                                                                                         int pageNbr, int pageSize) {
    Query query = getSession().createQuery("         select spl "
                                                           + "           from StagePersonLink spl, "
                                                           + "                IncomingDetail id "
                                                           + "left join fetch spl.stage s "
                                                           + "          where spl.person.idPerson = :idPerson "
                                                           + "            and (s.cdStage = :cdStage or s.cdStage is null) "
                                                           + "            and (spl.stage.dtStageClose is null "
                                                           + "                 or spl.stage.dtStageClose = :maxDate) "
                                                           + "            and id.idStage = spl.stage.idStage "
                                                           + " and (id.cdNonRsdntReqType is null or id.cdNonRsdntReqType <> 'IR')");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (PaginatedHibernateList<StagePersonLink>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findResourceandStagePersonLinkByidPersonAndCdPlcmtActPlanned(int idPerson) {
    Query query = getSession().createQuery("select distinct new map(c.idResource as idResource, "
                                                           + "                        c.dtLastUpdate as dtLastUpdate, "
                                                           + "                        c.stage.idStage as idStage, "
                                                           + "                        c.nmResource as nmResource, "
                                                           + "                        c.nmRsrcContact as nmRsrcContact, "
                                                           + "                        l.idStagePersonLink as idStagePersonLink, "
                                                           + "                        l.stage.idStage as idStage, "
                                                           + "                        l.person.idPerson as idPerson, "
                                                           + "                        l.capsCase.idCase as idCase, "
                                                           + "                        l.cdStagePersRole as cdStagePersRole, "
                                                           + "                        l.indStagePersInLaw as indStagePersInLaw, "
                                                           + "                        l.cdStagePersType as cdStagePersType, "
                                                           + "                        l.cdStagePersSearchInd as cdStagePersSearchInd, "
                                                           + "                        l.txtStagePersNotes as txtStagePersNotes, "
                                                           + "                        l.dtStagePersLink as dtStagePersLink, "
                                                           + "                        l.cdStagePersRelInt as cdStagePersRelInt, "
                                                           + "                        l.indStagePersReporter as indStagePersReporter, "
                                                           + "                        l.indStagePersEmpNew as indStagePersEmpNew, "
                                                           + "                        l.cdPKHshdMember as cdPKHouseholdMember, "
                                                           + "                        l.cdPersonSideOfFamily as cdPersonSideOfFamily ) "
                                                           + "  from CapsResource c, "
                                                           + "       StagePersonLink l, "
                                                           + "       Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + "   and p.dtPlcmtEnd = (select max(p2.dtPlcmtEnd) "
                                                           + "                         from Placement p2 "
                                                           + "                        where p2.personByIdPlcmtChild.idPerson = :idPerson) "
                                                           + "   and p.cdPlcmtActPlanned = '"
                                                           + CodesTables.CPLCMTAC_A
                                                           + "' "
                                                           + "   and c.idResource = p.capsResourceByIdRsrcFacil.idResource "
                                                           + "   and l.stage.idStage = c.stage.idStage");
    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public PaginatedHibernateList<Integer> findIdStageByIdPerson(int idPersMergeForward, int idPersMergeClosed,
                                                               int pageNbr, int pageSize) {
    Query query = getSession().createQuery("select distinct a.stage.idStage " + "   from StagePersonLink a, "
                                                           + "        StagePersonLink b "
                                                           + "  where a.person.idPerson = :idPersMergeForward "
                                                           + "    and b.person.idPerson = :idPersMergeClosed "
                                                           + "    and a.stage.idStage = b.stage.idStage "
                                                           + "    and a.cdStagePersRole = 'PR'");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return (PaginatedHibernateList<Integer>) paginatedList(pageNbr, pageSize, query);
  }

  public Map findStagePersonLinkByIdPerson(int idStage, String cdPrimaryChild) {
    Query query = getSession().createQuery("select new Map(p.idPerson as idPerson, "
                                                           + "       p.dtPersonBirth as dtPersonBirth, "
                                                           + "       spl.stage.nmStage as nmStage, "
                                                           + "       s.capsCase.idCase as idCase) "
                                                           + "  from StagePersonLink spl, Stage s, Person p "
                                                           + " where s.idStage = :idStage "
                                                           + " and spl.stage.idStage = s.idStage "
                                                           + "   and spl.cdStagePersRole = :cdPrimaryChild "
                                                           + " and spl.person.idPerson = p.idPerson ");
    query.setInteger("idStage", idStage);
    query.setString("cdPrimaryChild", cdPrimaryChild);
    return (Map) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findStagePersonLinkByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select spl2.person.idPerson, " + "       spl2.stage.idStage, "
                                                           + "       spl2.stage.cdStage "
                                                           + "  from StagePersonLink spl2, "
                                                           + "       StagePersonLink spl1 "
                                                           + " where spl1.person.idPerson = :idPerson "
                                                           + "   and spl1.cdStagePersRole = 'PC' "
                                                           + "   and spl2.cdStagePersRole = 'PR' "
                                                           + "   and spl2.stage.idStage = spl1.stage.idStage "
                                                           + "   and spl1.stage.idStage = spl2.stage.idStage "
                                                           + "   and (spl2.stage.dtStageClose is null "
                                                           + " or spl2.stage.dtStageClose = :maxDate) "
                                                           + "   and (spl2.stage.cdStage = 'sub' "
                                                           + "       or spl2.stage.cdStage = 'ado' "
                                                           + "       or spl2.stage.cdStage = 'pad') ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<StagePersonLink>) query.list();
  }

  public Integer findSUBCaseManagerByIdChild(int idPerson) {
    Query query = getSession().createQuery("select spl2.person.idPerson " + "  from StagePersonLink spl2, "
                                                           + "       StagePersonLink spl1 "
                                                           + " where spl1.person.idPerson = :idPerson "
                                                           + "   and spl1.cdStagePersRole = 'PC' "
                                                           + "   and spl2.cdStagePersRole = 'PR' "
                                                           + "   and spl2.stage.idStage = spl1.stage.idStage "
                                                           + "   and spl1.stage.idStage = spl2.stage.idStage "
                                                           + "   and (spl2.stage.dtStageClose is null "
                                                           + " or spl2.stage.dtStageClose = :maxDate) "
                                                           + "   and spl2.stage.cdStage = 'SUB' ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Integer) query.uniqueResult();
  }

  public long countStagePersonLinkByIdStageAndIdPerson(int idStage, int idPersMergeForward) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink s "
                                                           + " where stage.idStage = :idStage "
                                                           + "   and person.idPerson = :idPersMergeForward");
    query.setInteger("idStage", idStage);
    query.setInteger("idPersMergeForward", idPersMergeForward);
    return (Long) query.uniqueResult();
  }

  public StagePersonLink findStagePersonLinkByCdStageIdPersonCdRoleIdcase(String cdStage, int idPerson,
                                                                          String cdStagePersRole, int idCase) {
    Query query = getSession().createQuery("      from StagePersonLink s " + "join fetch s.stage "
                                                           + "     where s.person.idPerson = :idPerson "
                                                           + "       and s.cdStagePersRole = :cdStagePersRole "
                                                           + "       and s.stage.capsCase.idCase = :idCase "
                                                           + "       and s.stage.cdStage = :cdStage "
                                                           + "       and (s.stage.dtStageClose IS NULL "
                                                           + " or s.stage.dtStageClose = :maxDate) ");
    query.setString("cdStage", cdStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setInteger("idCase", idCase);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (StagePersonLink) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findAllPrincipalsLinkedToStage(int idStage, String cdStagePersType) {
    Query query = getSession().createQuery("      from StagePersonLink l " + "join fetch l.person "
                                                           + "     where l.stage.idStage = :idStage "
                                                           + "       and l.cdStagePersType = :cdStagePersType "
                                                           + "  order by l.person.nmPersonFull ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findAnyTypeLinkedToStage(int idStage, Collection personType) {
    Query query = getSession().createQuery("      from StagePersonLink l " + "join fetch l.person "
                                                           + "     where l.stage.idStage = :idStage "
                                                           + "       and l.cdStagePersType in (:personType) "
                                                           + "  order by l.person.nmPersonFull ");
    query.setInteger("idStage", idStage);
    query.setParameterList("personType", personType);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findAllOpenStagesByIdPersonPersTypeAndCdStage(int idPerson, String cdStagePersType,
                                                                             String cdStage) {
    Query query = getSession().createQuery("from StagePersonLink L " + "   join fetch L.stage S "
                                                           + " where L.person.idPerson = :idPerson "
                                                           + "   and L.cdStagePersType = :cdStagePersType "
                                                           + "   and (S.dtStageClose is null "
                                                           + " or S.dtStageClose = :maxDate) "
                                                           + "   and S.cdStage = :cdStage");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStage", cdStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<StagePersonLink>) query.list();
  }

  // STGAP00007159: Added the sql to look for both ONG and FCC stages.
  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findAllOpenStagesByIdPersonPersTypeAndCdStage(int idPerson, String cdStagePersType,
                                                                             Collection stageTypeList) {
    Query query = getSession().createQuery("from StagePersonLink L " + "   join fetch L.stage S "
                                                           + " where L.person.idPerson = :idPerson "
                                                           + "   and L.cdStagePersType = :cdStagePersType "
                                                           + "   and (S.dtStageClose is null "
                                                           + " or S.dtStageClose = :maxDate) "
                                                           + "   and S.cdStage in (:stageTypeList) ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersType", cdStagePersType);
    query.setParameterList("stageTypeList", stageTypeList);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<StagePersonLink>) query.list();
  }

  public Map findIdPersonByIdCaseAndIdStage(int idCase, int idStage, String cdStage, String cdStagePersRole) {
    Query query = getSession().createQuery("select new map (a.stage.idStage as stage, "
                                                           + "                a.person.idPerson as person) "
                                                           + "  from StagePersonLink a "
                                                           + " where a.capsCase.idCase = :idCase "
                                                           + "   and a.stage.cdStage = :cdStage "
                                                           + "   and (a.stage.dtStageClose is null "
                                                           + " or a.stage.dtStageClose = :maxDate) "
                                                           + "   and a.cdStagePersRole = :cdStagePersRole "
                                                           + "   and a.person.idPerson in (select c.person.idPerson "
                                                           + "                               from StagePersonLink c "
                                                           + "                              where c.stage.idStage = :idStage "
                                                           + "                                and c.cdStagePersRole = :cdStagePersRole)");
    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setInteger("idStage", idStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Map) firstResult(query);
  }

  /**
   * CAPTA 4.3 - retrieve the Alleged Victim child whose role is VC (victim), whose type is PRN (Principle) and who is
   * related to intake
   * 
   */
  public Integer findAllegedVictimChildByIdStage(int idStage) {
    Query query = getSession().createQuery("select spl.person.idPerson " + " from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage  "
                                                           + " and spl.cdStagePersRole = :cdStagePersRoleVC "
                                                           + " and spl.cdStagePersType = :cdStagePersTypePRN "
                                                           + " and spl.cdStagePersSearchInd = 'R'");

    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRoleVC", CodesTables.CROLES_VC);
    query.setString("cdStagePersTypePRN", CodesTables.CPRSNTYP_PRN);
    return (Integer) firstResult(query);
  }

  /**
   * CAPTA 4.3 - retrieve the Alleged Victim child whose stage should be either SUB or ADO and role is primary.
   * 
   */
  public Integer findChildWithSubAndAdoStageByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select spl.person.idPerson " + " from StagePersonLink spl, Stage s "
                                                           + " where spl.person.idPerson = :idPerson  "
                                                           + " and spl.stage.idStage = s.idStage "
                                                           + " and spl.cdStagePersRole = :cdStagePersRolePC "
                                                           + " and spl.cdStagePersType = :cdStagePersTypePRN "
                                                           + " and s.cdStage in ( :cdStageSUB , :cdStageADO ) ");

    query.setInteger("idPerson", idPerson);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStageADO", CodesTables.CSTAGES_ADO);
    query.setString("cdStagePersRolePC", CodesTables.CROLES_PC);
    query.setString("cdStagePersTypePRN", CodesTables.CPRSNTYP_PRN);
    return (Integer) firstResult(query);
  }

  public long countStagesByIdPersonAndIdStage(int idPerson, String cdStagePersRole, String cdStage) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink L, " + "       Stage S "
                                                           + " where L.person.idPerson = :idPerson "
                                                           + "   and L.cdStagePersRole = :cdStagePersRole "
                                                           + "   and S.idStage = L.stage.idStage "
                                                           + "   and S.cdStage = :cdStage");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStage", cdStage);
    return (Long) query.uniqueResult();
  }

  public long countOpenStagesByIdPersonAndIdStage(int idPerson, String cdStagePersRole, String cdStage) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink L, " + "       Stage S "
                                                           + " where L.person.idPerson = :idPerson "
                                                           + "   and L.cdStagePersRole = :cdStagePersRole "
                                                           + "   and S.idStage = L.stage.idStage "
                                                           + "   and (S.dtStageClose is null "
                                                           + " or S.dtStageClose = :maxDate) "
                                                           + "   and S.cdStage = :cdStage");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStage", cdStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  public long countOpenStagesByIdPersonAndIdStageqAndPersType(int idPerson, String cdStagePersType, String cdStage) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink L, " + "       Stage S "
                                                           + " where L.person.idPerson = :idPerson "
                                                           + "   and L.cdStagePersType = :cdStagePersType "
                                                           + "   and S.idStage = L.stage.idStage "
                                                           + "   and (S.dtStageClose is null "
                                                           + " or S.dtStageClose = :maxDate) "
                                                           + "   and S.cdStage = :cdStage");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStage", cdStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  // STGAP00007159: Added the sql to look for both ONG and FCC stages.
  public long countOpenStagesByIdPersonAndIdStageqAndPersType(int idPerson, String cdStagePersType,
                                                              Collection stageTypeList) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink L, " + "       Stage S "
                                                           + " where L.person.idPerson = :idPerson "
                                                           + "   and L.cdStagePersType = :cdStagePersType "
                                                           + "   and S.idStage = L.stage.idStage "
                                                           + "   and (S.dtStageClose is null "
                                                           + " or S.dtStageClose = :maxDate) "
                                                           + "   and S.cdStage in (:stageTypeList) ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersType", cdStagePersType);
    query.setParameterList("stageTypeList", stageTypeList);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findStagePersonLinkRowsByIdStage(int idStage) {
    Query query = getSession().createQuery(" from StagePersonLink spl " + "where spl.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public StagePersonLink findStagePersonLinkByIdStageCdStagePersRole(int idStage) {
    Query query = getSession().createQuery(" from StagePersonLink s " + "where s.stage.idStage = :idStage "
                                                           + "  and s.cdStagePersRole = 'PR' ");
    query.setInteger("idStage", idStage);
    return (StagePersonLink) firstResult(query);
  }

  public StagePersonLink findStagePersonLinkByIdStageCdStagePersRoleAll(int idStage) {
    Query query = getSession().createQuery(" from StagePersonLink s " + "where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersRole in ('" + CodesTables.CROLEALL_PR
                                                           + "' , '" + CodesTables.CROLEALL_HP + "')");
    query.setInteger("idStage", idStage);
    return (StagePersonLink) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findStagePersonLinkByIdCaseCdEventType(int idCase, String cdEventType) {
    Query query = getSession().createQuery("select new map(c.person.idPerson as idPerson, "
                                                           + "               c.cdStagePersType as cdStagePersType) "
                                                           + "  from StagePersonLink c "
                                                           + " where (c.person.idPerson, c.stage.idStage) in "
                                                           + "       (select a.person.idPerson, "
                                                           + "               b.stage.idStage "
                                                           + "          from EventPersonLink a, "
                                                           + "               Event b "
                                                           + "         where b.cdEventType = :cdEventType "
                                                           + "           and a.capsCase.idCase = :idCase "
                                                           + "           and b.idEvent = a.event.idEvent) ");
    query.setInteger("idCase", idCase);
    query.setString("cdEventType", cdEventType);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findStagePersonLinkByIdStageOrderByCdStagePersrole(int idStage) {
    Query query = getSession().createQuery("    from StagePersonLink "
                                                           + "   where stage.idStage = :idStage "
                                                           + "order by decode(cdStagePersRole, 'PC', 1, 'SP', 2, 'DB', 3, 'DP', 4, "
                                                           + "                                 'DV', 5, 'VP', 6, 'VC', 7, 'CL', 8, "
                                                           + "                                 'AP', 9, 'AV', 10, 'UD', 11, 'UC', 12, "
                                                           + "                                 'UM', 13, 'UK', 14, 'NO', 15)");
    query.setInteger("idStage", idStage);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findNamesFromStageAndStagePersonLinkAndPersonByIdStage(int idStage) {
    Query query = getSession().createQuery("select new map(l.person.nmPersonFull as nmPersonFull , "
                                                           + "               l.stage.cdStageProgram as cdStageProgram , "
                                                           + "               l.cdStagePersRole as cdStagePersRole, "
                                                           + "               l.person.idPerson as idPerson) "
                                                           + "  from StagePersonLink l "
                                                           + " where l.stage.idStage  = :idStage "
                                                           + "   and l.cdStagePersType = '" + CodesTables.CPRSNTYP_PRN
                                                           + "'");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findIdPersonAndNmPersonFullFromStagePersonLinkAndPerson(int idStage) {
    Query query = getSession().createQuery("select new map(a.person.idPerson as idPerson , "
                                                           + "               a.person.nmPersonFull as nmPersonFull) "
                                                           + "  from StagePersonLink a "
                                                           + " where a.stage.idStage = :idStage "
                                                           + "   and a.cdStagePersType = 'PRN' ");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findIdPersonAndNmPersonFullUnder18FromStagePersonLinkAndPerson(int idStage) {
    Query query = getSession().createQuery("select new map(a.person.idPerson as idPerson , "
                                                           + "               a.person.nmPersonFull as nmPersonFull) "
                                                           + "  from StagePersonLink a "
                                                           + " where a.stage.idStage = :idStage "
                                                           + "   and a.cdStagePersType = 'PRN' "
                                                           + "   and months_between(sysdate,nvl(a.person.dtPersonBirth,sysdate)) < 216");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson(int idStage) {
    Query query = getSession().createQuery("select new map(a.person.idPerson as idPerson , "
                                                           + "               a.person.nmPersonFull as nmPersonFull) "
                                                           + "  from StagePersonLink a "
                                                           + " where a.stage.idStage = :idStage "
                                                           + "   and a.cdStagePersType in ('PRN','COL') "
                                                           + "   and a.cdStagePersRole != 'PC' "
                                                           + "   and months_between(sysdate,nvl(a.person.dtPersonBirth,sysdate)) >= 216");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }
  
  //STGAP00017827- Added for MR-085
  @SuppressWarnings({ "unchecked" })
  public List<Map> findPRNIdPersonAndNmPersonFullOver18FromStagePersonLinkAndPerson(int idStage) {
    Query query = getSession().createQuery("select new map(a.person.idPerson as idPerson , "
                                                           + "               a.person.nmPersonFull as nmPersonFull, "
                                                           + "                a.cdStagePersRelInt as cdStagePersRelInt  ) "
                                                           + "  from StagePersonLink a "
                                                           + " where a.stage.idStage = :idStage "
                                                           + "   and a.cdStagePersType in ('PRN') "
                                                           + "   and a.cdStagePersRole != 'PC' "
                                                           + "   and months_between(sysdate,nvl(a.person.dtPersonBirth,sysdate)) >= 216 "
                                                           + "   order by a.person.nmPersonFull " );
    query.setInteger("idStage", idStage); 
    return (List<Map>) query.list();
  }

  public Integer findIdStagePersonLinkByIdPersonAndCdStagePersRole(int idPerson, String cdStagePersRole) {
    Query query = getSession().createQuery(" select s.idStagePersonLink " + "   from StagePersonLink s "
                                                           + "  where s.person.idPerson = :idPerson "
                                                           + "    and s.cdStagePersRole = :cdStagePersRole ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (Integer) firstResult(query);
  }

  public StagePersonLink findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(int idStage, String cdStagePersRole,
                                                                               String cdStagePersType) {
    Query query = getSession().createQuery(" from StagePersonLink " + "where stage.idStage = :idStage "
                                                           + "  and cdStagePersRole = :cdStagePersRole "
                                                           + "  and cdStagePersType = :cdStagePersType");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    return (StagePersonLink) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findMbrPkHshldIdPersonFromStagePersonLinkByIdStageAndCdStagePersType(int idStage,
                                                                                            String cdStagePersType) {
    Query query = getSession().createQuery("select s.person.idPerson " + "  from StagePersonLink s "
                                                           + " where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersType = :cdStagePersType "
                                                           + "   and (s.cdPKHshdMember is null "
                                                           + "        or s.cdPKHshdMember = :cdPKHshdMember)");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdPKHshdMember", CodesTables.CMBRPCHH_Y);

    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findIdPersonFromStagePersonLinkByIdStageAndCdStagePersType(int idStage, String cdStagePersType) {
    Query query = getSession().createQuery("select s.person.idPerson " + "  from StagePersonLink s "
                                                           + " where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersType = :cdStagePersType");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findUnknownMbrPkHshldIdPersonByIdStageAndCdStagePersType(int idStage, String cdStagePersType) {
    Query query = getSession().createQuery("select new map (s.person.idPerson as idPerson, "
                                                           + " s.cdStagePersRole as cdStagePersRole, "
                                                           + " s.cdStagePersRelInt as cdStagePersRelInt, "
                                                           + " p.nmPersonFull as nmPersonFull) "
                                                           + "  from StagePersonLink s join s.person p "
                                                           + " where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersType = :cdStagePersType "
                                                           + "   and s.cdPKHshdMember = :cdPKHshdMember");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdPKHshdMember", CodesTables.CMBRPCHH_U);

    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findIdPersonFromStagePersonLinkByIdStageCdStagePersTypeAndRelationships(int idStage,
                                                                                               String cdStagePersType,
                                                                                               Collection<String> relationships) {
    Query query = getSession().createQuery("select s.person.idPerson " + "  from StagePersonLink s "
                                                           + " where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersType = :cdStagePersType"
                                                           + "   and s.cdStagePersRelInt in (:relationships)"
                                                           + " and s.stage.dtStageClose is null ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    query.setParameterList("relationships", relationships);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findIdStageIdPersonIdCaseFromStageAndStagePersonLink(int idPerson, int idCase) {
    Query query = getSession().createQuery("select new map (c.stage.idStage as idStage , "
                                                           + "                c.person.idPerson as idPerson , "
                                                           + "                c.stage.capsCase.idCase as idCase) "
                                                           + "  from StagePersonLink a , " + "       Person b , "
                                                           + "       StagePersonLink c  "
                                                           + " where a.person.idPerson =  :idPerson "
                                                           + "   and a.cdStagePersType = '" + CodesTables.CPRSNTYP_PRN
                                                           + "'" + "   and b.cdPersonStatus = '"
                                                           + CodesTables.CACTSTAT_A + "'"
                                                           + "   and c.cdStagePersRole = '" + CodesTables.CROLEALL_PR
                                                           + "'" + "   and b.idPerson = a.person.idPerson "
                                                           + "   and c.stage.idStage = a.stage.idStage "
                                                           + "   and (c.stage.capsCase.idCase <> :idCase "
                                                           + "         or c.stage.capsCase.idCase  is null) "
                                                           + "   and c.stage.dtStageClose is null ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public PaginatedHibernateList<Map> findStageAndStagePersonLinkByIdPerson(int idPerson, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("select new map(a.capsCase.idCase as idCase, "
                                                           + "               a.cdStageProgram as cdStageProgram, "
                                                           + "               b.stage.idStage as idStage) "
                                                           + "  from Stage a, " + "       StagePersonLink b, "
                                                           + "       PersonMergeView v "
                                                           + " where v.id.idPersonInput = :idPerson "
                                                           + "   and b.person.idPerson = v.id.idPersonOutput "
                                                           + "   and a.idStage = b.stage.idStage "
                                                           + "   and (a.dtStageClose is null "
                                                           + " or a.dtStageClose = :maxDate) ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findPersonAndStagePersonLinkByIdPersonIdStageAndCdStagePersType(int idStage) {
    Query query = getSession().createQuery("select new map(s.person.idPerson as idPerson, "
                                                           + "               s.cdStagePersRole as cdStagePersRole, "
                                                           + "               s.dtLastUpdate as dtLastUpdate, "
                                                           + "               p.nmPersonFull as nmPersonFull, "
                                                           + "               p.cdPersonMaritalStatus as cdPersonMaritalStatus, "
                                                           + "               p.dtPersonBirth as dtPersonBirth) "
                                                           + "  from StagePersonLink s join s.person p "
                                                           + " where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersType = :principal");
    query.setInteger("idStage", idStage);
    query.setString("principal", "PRN");
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public PaginatedHibernateList<StagePersonLink> findStagePersonLinkAndPersonByidStageAndCdStagePersType(int idStage,
                                                                                                         String cdStagePersType,
                                                                                                         int pageNbr,
                                                                                                         int pageSize) {
    Query query = getSession().createQuery("      from StagePersonLink a " + "join fetch a.person b "
                                                           + "     where a.person.idPerson = b.idPerson "
                                                           + "       and a.stage.idStage = :idStage "
                                                           + "       and a.cdStagePersType !=:cdStagePersType "
                                                           + "  order by a.cdStagePersType desc, "
                                                           + "           b.nbrPersonAge asc");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    return (PaginatedHibernateList<StagePersonLink>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Object[]> findStagePersonLinkAndPersonByidCase(int idCase) {
    // DO NOT Change the order of the columns in the SQL below which will affect the service.
    SQLQuery query = getSession().createSQLQuery(" select distinct a.id_Person as idPerson, "
                                                                 + " b.nm_Person_Full as nmPersonFull "
                                                                 + " from  Stage_Person_Link a, Person b "
                                                                 + " where a.id_Person = b.id_Person "
                                                                 + " and a.id_Case = :idCase "
                                                                 + " and a.cd_Stage_Pers_Type !='STF' ");

    query.setInteger("idCase", idCase);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Object[]> findStagePersonLinkAndPersonByidCaseForSealedCase(int idCase) {
    // DO NOT Change the order of the columns in the SQL below which will affect the service.
    SQLQuery query = getSession().createSQLQuery(" select distinct a.id_Person as idPerson, "
                                                                 + " b.nm_Person_Full as nmPersonFull "
                                                                 + " from  Stage_Person_Link a, Person b "
                                                                 + " where a.id_Person = b.id_Person "
                                                                 + " and a.id_Case = :idCase "
                                                                 + " and ( b.ind_adopted is null or b.ind_adopted = 'N' ) "
                                                                 + " and a.cd_Stage_Pers_Type !='STF' ");

    query.setInteger("idCase", idCase);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findSealedIdPersonListByidCase(int idCase) {

    Query query = getSession().createQuery("select distinct spl.person.idPerson " + "from "
                                                           + "StagePersonLink spl, Person b "
                                                           + "where spl.person.idPerson = b.idPerson "
                                                           + " and spl.capsCase.idCase = :idCase "
                                                           + " and b.indAdopted = 'Y' ");

    query.setInteger("idCase", idCase);
    return (List<Integer>) query.list();
  }

  public StagePersonLink findStagePersonLinkByIdStageIdPersonAndMaxDate(int idStage, int idPerson, Date maxDate) {
    Query query = getSession().createQuery("           from StagePersonLink a "
                                                           + "     join fetch a.person c "
                                                           + "left join fetch c.personIds d "
                                                           + "          where a.stage.idStage = :idStage "
                                                           + "            and a.person.idPerson = :idPerson "
                                                           + "            and (d.dtPersonIdEnd = :maxDate or d.dtPersonIdEnd is null) "
                                                           + "            and (d.cdPersonIdType = 'ssn' or d.dtPersonIdEnd is null)");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (StagePersonLink) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findStagePersonLinkByIdCaseCdStagePersTypeDtStageClose(int idCase,
                                                                                      String cdStagePersRole,
                                                                                      Date dtStageClose) {
    Query query = getSession().createQuery("select distinct l.person.idPerson " + "  from StagePersonLink l "
                                                           + " where l.stage.dtStageClose = :dtStageClose "
                                                           + "   and l.cdStagePersRole = :cdStagePersRole "
                                                           + "   and l.stage.capsCase.idCase = :idCase ");
    query.setTimestamp("dtStageClose", dtStageClose);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setInteger("idCase", idCase);
    return (List<StagePersonLink>) query.list();
  }

  public long countStagePersonLinkByIdStageCdStagePersTypeAndCdStagePersRole(int idStage, String cdStagePersType,
                                                                             String cdStagePersRole) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink s "
                                                           + " where s.cdStagePersType = :cdStagePersType "
                                                           + "   and s.cdStagePersRole = :cdStagePersRole "
                                                           + "   and s.stage.idStage = :idStage ");
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  public long countStagePersonLinksNonZeroIdStageByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select count(s.idStagePersonLink) " + "  from StagePersonLink s "
                                                           + " where s.person.idPerson = :idPerson "
                                                           + "   and s.stage.idStage > 0");
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findIdPersonIdStageFromStagePersonLink(int idPersMergeForward, int idPersMergeClosed, int idPerson) {
    Query query = getSession().createQuery("select new map(spl1.person.idPerson as idPerson, "
                                                           + "               spl1.stage.idStage as idStage) "
                                                           + "  from StagePersonLink spl1, "
                                                           + "       StagePersonLink spl2 "
                                                           + " where ((spl2.person.idPerson = :idPersMergeForward "
                                                           + "         or spl2.person.idPerson = :idPersMergeClosed) "
                                                           + "        and spl2.cdStagePersType != 'STF') "
                                                           + "   and spl1.stage.idStage = spl2.stage.idStage "
                                                           + "   and spl1.person.idPerson != :idPerson "
                                                           + "   and (spl1.cdStagePersRole = 'PR' or spl1.cdStagePersRole = 'SE') ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findUnstaffedStagePersonLinkByIdCaseAndCdStagePersType(int idCase, String cdStagePersType) {
    Query query = getSession().createQuery("  select new map(p.nmPersonFull as nmPersonFull, "
                                                           + "                 p.cdPersonSuffix as cdPersonSuffix, "
                                                           + "                 p.nbrPersonAge as nbrPersonAge, "
                                                           + "                 p.cdPersonSex as cdPersonSex, "
                                                           + "                 p.idPerson as idPerson, "
                                                           + "                 p.indPersonDobApprox as indPersonDobApprox, "
                                                           + "                 p.cdPersonChar as cdPersonChar, "
                                                           + "                 p.dtPersonBirth as dtPersonBirth, "
                                                           + "                 p.dtPersonDeath as dtPersonDeath, "
                                                           + "                 spl.cdStagePersSearchInd as cdStagePersSearchInd, "
                                                           + "                 spl.cdStagePersType as cdStagePersType, "
                                                           + "                 spl.cdStagePersRelInt as cdStagePersRelInt, "
                                                           + "                 spl.cdStagePersRole as cdStagePersRole, "
                                                           + "                 spl.indStagePersReporter as indStagePersReporter) "
                                                           + "    from StagePersonLink spl "
                                                           + "         join spl.person p "
                                                           + "         join spl.stage s "
                                                           + "   where s.capsCase.idCase = :idCase "
                                                           + "     and spl.cdStagePersType != :cdStagePersType "
                                                           + "order by spl.cdStagePersType desc, "
                                                           + "         p.nbrPersonAge asc");
    query.setString("cdStagePersType", cdStagePersType);
    query.setInteger("idCase", idCase);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findListOfOpenStagesByCdStageType(int idPerson, String cdStageType, Calendar dtReportDate) {
    Query query = getSession().createQuery("  select new map(s.capsCase.idCase as idCase, "
                                                           + "                 s.cdStage as cdStage, "
                                                           + "                 s.idStage as idStage, "
                                                           + "                 spl.person.idPerson as idPerson, "
                                                           + "                 s.nmStage as nmStage, "
                                                           + "                 s.dtStageStart as dtStageStart) "
                                                           + "    from StagePersonLink spl "
                                                           + "         join spl.stage s "
                                                           + "   where spl.person.idPerson = :idPerson "
                                                           + "     and s.cdStage = :cdStageType "
                                                           + "     and spl.cdStagePersType != 'STF'  "
                                                           + "     and s.dtStageStart < :dtReportDate "
                                                           + " and (s.dtStageClose is null or s.dtStageClose = '' or "
                                                           + " s.dtStageClose  = :maxDate or s.dtStageClose >= :dtReportDate) "
                                                           + "order by s.idStage desc ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStageType", cdStageType);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setCalendar("dtReportDate", dtReportDate);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findListOfOpenStagesByCdStageTypeIdPersons(List<Integer> idPersons, String cdStageType,
                                                              Calendar dtReportDate) {
    Query query = getSession().createQuery("  select distinct new map(s.capsCase.idCase as idCase, "
                                                           + "                 s.cdStage as cdStage, "
                                                           + "                 s.idStage as idStage, "
                                                           + "                 spl.person.idPerson as idPerson, "
                                                           + "                 s.nmStage as nmStage, "
                                                           + "                 s.dtStageStart as dtStageStart) "
                                                           + "    from StagePersonLink spl "
                                                           + "         join spl.stage s "
                                                           + "   where spl.person.idPerson in (:idPersons) "
                                                           + "     and s.cdStage = :cdStageType "
                                                           + "     and spl.cdStagePersType != 'STF'  "
                                                           + "     and s.dtStageStart < :dtReportDate "
                                                           + " and (s.dtStageClose is null or s.dtStageClose = '' or "
                                                           + " s.dtStageClose  = :maxDate or s.dtStageClose >= :dtReportDate) "
                                                           + "order by s.idStage desc ");
    query.setParameterList("idPersons", idPersons);
    query.setString("cdStageType", cdStageType);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setCalendar("dtReportDate", dtReportDate);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findPersonByIdStageIdPersonCdStagePersType(int idStage, String cdStagePersType0,
                                                              String cdStagePersType1, String cdStagePersType2,
                                                              String cdStagePersType3, String cdStagePersType4,
                                                              String cdStagePersType5, String cdStagePersType6,
                                                              String cdStagePersType7) {
    Query query = getSession().createQuery(" select new map (p.nmPersonFull as nmPersonFull, "
                                                           + "                 p.idPerson as idPerson) "
                                                           + "   from StagePersonLink s, "
                                                           + "        Person p "
                                                           + "  where s.stage.idStage = :idStage "
                                                           + "    and s.person.idPerson = p.idPerson "
                                                           + "    and s.cdStagePersRelInt in (:cdStagePersType0, :cdStagePersType1, "
                                                           + "                                :cdStagePersType2, :cdStagePersType3, "
                                                           + "                                :cdStagePersType4, :cdStagePersType5, "
                                                           + "                                :cdStagePersType6, :cdStagePersType7)");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType0", cdStagePersType0);
    query.setString("cdStagePersType1", cdStagePersType1);
    query.setString("cdStagePersType2", cdStagePersType2);
    query.setString("cdStagePersType3", cdStagePersType3);
    query.setString("cdStagePersType4", cdStagePersType4);
    query.setString("cdStagePersType5", cdStagePersType5);
    query.setString("cdStagePersType6", cdStagePersType6);
    query.setString("cdStagePersType7", cdStagePersType7);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findHouseMembersLinkedToStage(int idStage) {
    Query query = getSession().createQuery("           from StagePersonLink spl "
                                                           + "          where spl.stage.idStage = :idStage "
                                                           + "            and spl.person.personDtl.indPersonRsrcHshdMember = 'Y'");
    query.setInteger("idStage", idStage);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findHomeMembersDetailLinkedToStage(int idStage) {
    Query query = getSession().createQuery(" select new map (p.nmPersonFull as nmPersonFull, "
                                                           + "p.dtPersonBirth as dtPersonBirth, "
                                                           + "p.cdPersonSex as cdPersonSex, "
                                                           + "spl.cdStagePersRelInt as cdStagePersRelInt, "
                                                           + "spl.cdStagePersType as cdStagePersType) "
                                                           + "from StagePersonLink spl " + "   join spl.person p "
                                                           + "where spl.stage.idStage = :idStage "
                                                           + "and spl.person.personDtl.indPersonRsrcHshdMember = 'Y' ");

    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findAllPrincipalsForStage(String szCdStagePersType, int idStage) {
    Query query = getSession().createQuery(" select new map (d.nmNameFirst as NM_FIRST, "
                                                           + " d.nmNameLast as NM_LAST, "
                                                           + " d.nmNameMiddle as NM_MIDDLE, "
                                                           + " a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " a.nbrPersonAge as NBR_PERSON_AGE, "
                                                           + " a.dtPersonBirth as DT_PERSON_BIRTH, "
                                                           + " c.cdPKHshdMember as CD_PK_HSHD_MEMBER, "
                                                           + " c.cdPersonSideOfFamily as CD_PERSON_SIDE_OF_FAMILY, "
                                                           + " c.cdStagePersType as CD_STAGE_PERS_TYPE, "
                                                           + " c.cdStagePersRelInt as CD_REL_INT) "
                                                           + " from StagePersonLink c "
                                                           + "     join c.person a "
                                                           + "left join a.names d "
                                                           + "          where c.cdStagePersType = :szCdStagePersType "
                                                           + "            and c.stage.idStage = :idStage "
                                                           + "            and (d.dtNameEndDate = :maxDate or d.dtNameEndDate is null) "
                                                           + "            and (d.indNamePrimary = 'Y' or d.indNamePrimary is null) "
                                                           + "            and (d.indNameInvalid = 'N' or d.indNameInvalid is null) "
                                                           + "       order by d.nmNameLast, "
                                                           + "                d.nmNameFirst, "
                                                           + "                d.nmNameMiddle");
    query.setString("szCdStagePersType", szCdStagePersType);
    query.setInteger("idStage", idStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findAllPrincipalsForStageInPKHshld(String szCdStagePersType, int idStage) {
    Query query = getSession().createQuery(" select new map (d.nmNameFirst as NM_FIRST, "
                                                           + " d.nmNameLast as NM_LAST, "
                                                           + " d.nmNameMiddle as NM_MIDDLE, "
                                                           + " a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " a.nbrPersonAge as NBR_PERSON_AGE, "
                                                           + " a.dtPersonBirth as DT_PERSON_BIRTH, "
                                                           + " c.cdPersonSideOfFamily as CD_PERSON_SIDE_OF_FAMILY, "
                                                           + " c.cdStagePersType as CD_STAGE_PERS_TYPE, "
                                                           + " c.cdStagePersRelInt as CD_REL_INT) "
                                                           + " from StagePersonLink c "
                                                           + "     join c.person a "
                                                           + "left join a.names d "
                                                           + "          where c.cdStagePersType = :szCdStagePersType "
                                                           + "            and c.stage.idStage = :idStage "
                                                           + "            and (c.cdPKHshdMember is null "
                                                           + "                 or c.cdPKHshdMember = :cdPKHshdMember) "
                                                           + "            and (d.dtNameEndDate = :maxDate or d.dtNameEndDate is null) "
                                                           + "            and (d.indNamePrimary = 'Y' or d.indNamePrimary is null) "
                                                           + "            and (d.indNameInvalid = 'N' or d.indNameInvalid is null) "
                                                           + "       order by d.nmNameLast, "
                                                           + "                d.nmNameFirst, "
                                                           + "                d.nmNameMiddle");
    query.setString("szCdStagePersType", szCdStagePersType);
    query.setString("cdPKHshdMember", CodesTables.CMBRPCHH_Y);
    query.setInteger("idStage", idStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findAllPrincipalsForStageInPKHshldNull(String szCdStagePersType, int idStage) {
    Query query = getSession().createQuery(" select new map (d.nmNameFirst as NM_FIRST, "
                                                           + " d.nmNameLast as NM_LAST, "
                                                           + " d.nmNameMiddle as NM_MIDDLE, "
                                                           + " a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " a.nbrPersonAge as NBR_PERSON_AGE, "
                                                           + " a.dtPersonBirth as DT_PERSON_BIRTH, "
                                                           + " c.cdPersonSideOfFamily as CD_PERSON_SIDE_OF_FAMILY, "
                                                           + " c.cdStagePersType as CD_STAGE_PERS_TYPE, "
                                                           + " c.cdStagePersRelInt as CD_REL_INT) "
                                                           + " from StagePersonLink c "
                                                           + "     join c.person a "
                                                           + "left join a.names d "
                                                           + "          where c.cdStagePersType = :szCdStagePersType "
                                                           + "            and c.stage.idStage = :idStage "
                                                           + "            and c.cdPKHshdMember is null "
                                                           + "            and (d.dtNameEndDate = :maxDate or d.dtNameEndDate is null) "
                                                           + "            and (d.indNamePrimary = 'Y' or d.indNamePrimary is null) "
                                                           + "            and (d.indNameInvalid = 'N' or d.indNameInvalid is null) "
                                                           + "       order by d.nmNameLast, "
                                                           + "                d.nmNameFirst, "
                                                           + "                d.nmNameMiddle");
    query.setString("szCdStagePersType", szCdStagePersType);
    query.setInteger("idStage", idStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findPrincipalsAndCollateralsFromStagePersonLinkAndPerson(int idStage) {
    Query query = getSession().createQuery(" select new map (a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " c.cdStagePersType as CD_STAGE_PERS_TYPE, "
                                                           + " c.cdStagePersRelInt as CD_STAGE_PERS_REL_INT, "
                                                           + " c.cdStagePersRole as CD_STAGE_PERS_ROLE) "
                                                           + " from StagePersonLink c, Person a "
                                                           + " where c.person.idPerson = a.idPerson"
                                                           + "     and c.stage.idStage = :idStage "
                                                           + "           and c.cdStagePersType in ('PRN','COL')");

    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findAllPrincipalsForHouse(int idStage) {
    Query query = getSession().createQuery(" select new map (d.nmNameFirst as NM_FIRST, "
                                                           + " d.nmNameLast as NM_LAST, "
                                                           + " d.nmNameMiddle as NM_MIDDLE, "
                                                           + " a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " a.nbrPersonAge as NBR_PERSON_AGE, "
                                                           + " a.dtPersonBirth as DT_PERSON_BIRTH, "
                                                           + " c.cdPersonSideOfFamily as CD_PERSON_SIDE_OF_FAMILY, "
                                                           + " c.cdStagePersType as CD_STAGE_PERS_TYPE, "
                                                           + " c.cdStagePersRole as CD_ROLE ,    "
                                                           + " c.cdStagePersRelInt as CD_REL_INT) "
                                                           + " from StagePersonLink c "
                                                           + "     join c.person a "
                                                           + "left join a.names d "
                                                           + "          where (c.cdStagePersType = 'PRN' or c.cdStagePersType = 'COL') "
                                                           + "            and c.stage.idStage = :idStage "
                                                           + "            and (d.dtNameEndDate = :maxDate or d.dtNameEndDate is null) "
                                                           + "            and (d.indNamePrimary = 'Y' or d.indNamePrimary is null) "
                                                           + "            and (d.indNameInvalid = 'N' or d.indNameInvalid is null) "
                                                           + "       order by d.nmNameLast, "
                                                           + "                d.nmNameFirst, "
                                                           + "                d.nmNameMiddle");

    query.setInteger("idStage", idStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findStagePersonLinkByIdPersonPersonMerge(int idPerson) {
    Query query = getSession().createQuery(" select l " + "  from PersonMergeView p, " + "       StagePersonLink l "
                                                           + "   join fetch l.stage "
                                                           + " where p.id.idPersonInput = :idPerson "
                                                           + "   and p.id.idPersonOutput = l.person.idPerson "
                                                           + "   and l.cdStagePersType != 'STF' ");
    query.setInteger("idPerson", idPerson);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Object[]> findOpenStagesAndEventsPerPerson(int idPerson) {
    Query query = getSession().createQuery("      from StagePersonLink spl, Event e "
                                                           + "join fetch spl.stage s "
                                                           + "     where e.stage.idStage = s.idStage "
                                                           + "       and spl.person.idPerson = :idPerson "
                                                           + "       and s.dtStageClose is null "
                                                           + "       and (e.cdEventType <> 'AUT' or e.cdEventType is null)");
    query.setInteger("idPerson", idPerson);
    return query.list();
  }

  public StagePersonLink findStagePersonLinkByIdPersonAndIdStage(int idPerson, int idStage) {
    Query query = getSession().createQuery(" from StagePersonLink " + "where person.idPerson = :idPerson "
                                                           + "  and stage.idStage = :idStage");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (StagePersonLink) firstResult(query);
  }

  public long countStagePersonLinksNonStfCdStagePersTypeNonZeroIdStageByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select count(s.idStagePersonLink) " + "  from StagePersonLink s "
                                                           + " where s.person.idPerson = :idPerson "
                                                           + "   and s.cdStagePersType != 'STF'"
                                                           + "   and s.stage.idStage > 0");
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public long countStagePersonLinksByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink s "
                                                           + " where s.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public Map findStagePersonLinkByIdStageAndRole(int idStage) {
    Query query = getSession().createQuery("select new map (s.idStagePersonLink as idStagePersonLink, "
                                                           + "                s.person.idPerson as idPerson, "
                                                           + "                e.dtEmpTermination as dtEmpTermination) "
                                                           + "  from StagePersonLink s, " + "       Employee e "
                                                           + " where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersRole = 'HP'"
                                                           + "   and e.person.idPerson = s.person.idPerson");
    query.setInteger("idStage", idStage);
    return (Map) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Object[]> findSPLPersonPersonIDIncmgStatus(int idStage, Date dtSysTsQuery) {
    SQLQuery query = getSession().createSQLQuery("SELECT A.CD_STAGE_PERS_TYPE, " + "       A.CD_STAGE_PERS_ROLE, "
                                                                 + "       C.NM_PERSON_FULL, "
                                                                 + "       C.DT_PERSON_BIRTH, "
                                                                 + "       C.NBR_PERSON_AGE, "
                                                                 + "       C.CD_PERSON_SEX, "
                                                                 + "       A.CD_STAGE_PERS_REL_INT, "
                                                                 + "       A.IND_STAGE_PERS_REPORTER, "
                                                                 + "       A.CD_STAGE_PERS_SEARCH_IND, "
                                                                 + "       C.DT_PERSON_DEATH, "
                                                                 + "       C.CD_PERSON_DEATH, "
                                                                 + "       C.CD_PERSON_MARITAL_STATUS, "
                                                                 + "       C.CD_PERSON_LANGUAGE, "
                                                                 + "       C.CD_DISASTER_RLF, "
                                                                 + "       C.CD_PERSON_ETHNIC_GROUP, "
                                                                 + "       A.TXT_STAGE_PERS_NOTES, "
                                                                 + "       A.ID_STAGE, " + "       A.ID_PERSON, "
                                                                 + "       D.NBR_PERSON_ID_NUMBER, "
                                                                 + "       D.ID_PERSON_ID, "
                                                                 + "       D.IND_PERSON_ID_INVALID, "
                                                                 + "       D.DT_PERSON_ID_START, "
                                                                 + "       D.DT_PERSON_ID_END, "
                                                                 + "       D.DESC_PERSON_ID, "
                                                                 + "       C.IND_PERSON_DOB_APPROX, "
                                                                 + "       A.IND_STAGE_PERS_IN_LAW, "
                                                                 + "       A.CD_STAGE_PERS_LST_SORT, "
                                                                 + "       C.CD_PERSON_SUFFIX, "
                                                                 + "       C.CD_PERSON_TITLE, "
                                                                 + "       C.IND_PERSON_US_CITIZEN, "
                                                                 + "       C.CD_PERSON_IMMIGRATION_STATUS, "
                                                                 + "       C.CD_PERSON_COUNTRY_ORIGIN, "
                                                                 + "       C.CD_PERSON_PROOF_CITIZENSHIP, "
                                                                 + "       C.CD_MATCH_TYPE, "
                                                                 + "       C.TXT_PERSON_OTHER_RELATIONSHIPS, "
                                                                 + "       A.CD_PK_HSHD_MEMBER "
                                                                 + "  FROM STAGE_PERSON_LINK A, " + "       PERSON C, "
                                                                 + "       PERSON_ID D "
                                                                 + " WHERE A.ID_STAGE = :idStage "
                                                                 + "   AND A.CD_STAGE_PERS_TYPE != 'STF' "
                                                                 + "   AND A.ID_PERSON = C.ID_PERSON "
                                                                 + "   AND D.ID_PERSON (+) = C.ID_PERSON "
                                                                 + "   AND D.DT_PERSON_ID_START (+) <= :dtSysTsQuery "
                                                                 + "   AND D.DT_PERSON_ID_END (+) >= :dtSysTsQuery "
                                                                 + "   AND D.CD_PERSON_ID_TYPE (+) = 'SSN'");
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);
    query.addScalar("CD_STAGE_PERS_TYPE", Hibernate.STRING);
    query.addScalar("CD_STAGE_PERS_ROLE", Hibernate.STRING);
    query.addScalar("NM_PERSON_FULL", Hibernate.STRING);
    query.addScalar("DT_PERSON_BIRTH", Hibernate.DATE);
    query.addScalar("NBR_PERSON_AGE", Hibernate.INTEGER);
    query.addScalar("CD_PERSON_SEX", Hibernate.STRING);
    query.addScalar("CD_STAGE_PERS_REL_INT", Hibernate.STRING);
    query.addScalar("IND_STAGE_PERS_REPORTER", Hibernate.STRING);
    query.addScalar("CD_STAGE_PERS_SEARCH_IND", Hibernate.STRING);
    query.addScalar("DT_PERSON_DEATH", Hibernate.DATE);
    query.addScalar("CD_PERSON_DEATH", Hibernate.STRING);
    query.addScalar("CD_PERSON_MARITAL_STATUS", Hibernate.STRING);
    query.addScalar("CD_PERSON_LANGUAGE", Hibernate.STRING);
    query.addScalar("CD_DISASTER_RLF", Hibernate.STRING);
    query.addScalar("CD_PERSON_ETHNIC_GROUP", Hibernate.STRING);
    query.addScalar("TXT_STAGE_PERS_NOTES", Hibernate.STRING);
    query.addScalar("ID_STAGE", Hibernate.INTEGER);
    query.addScalar("ID_PERSON", Hibernate.INTEGER);
    query.addScalar("NBR_PERSON_ID_NUMBER", Hibernate.STRING);
    query.addScalar("ID_PERSON_ID", Hibernate.INTEGER);
    query.addScalar("IND_PERSON_ID_INVALID", Hibernate.STRING);
    query.addScalar("DT_PERSON_ID_START", Hibernate.DATE);
    query.addScalar("DT_PERSON_ID_END", Hibernate.DATE);
    query.addScalar("DESC_PERSON_ID", Hibernate.STRING);
    query.addScalar("IND_PERSON_DOB_APPROX", Hibernate.STRING);
    query.addScalar("IND_STAGE_PERS_IN_LAW", Hibernate.STRING);
    query.addScalar("CD_STAGE_PERS_LST_SORT", Hibernate.STRING);
    query.addScalar("CD_PERSON_SUFFIX", Hibernate.STRING);
    query.addScalar("CD_PERSON_TITLE", Hibernate.STRING);
    query.addScalar("IND_PERSON_US_CITIZEN", Hibernate.STRING);
    query.addScalar("CD_PERSON_IMMIGRATION_STATUS", Hibernate.STRING);
    query.addScalar("CD_PERSON_COUNTRY_ORIGIN", Hibernate.STRING);
    query.addScalar("CD_PERSON_PROOF_CITIZENSHIP", Hibernate.STRING);
    query.addScalar("CD_MATCH_TYPE", Hibernate.STRING);
    query.addScalar("TXT_PERSON_OTHER_RELATIONSHIPS", Hibernate.STRING);
    query.addScalar("CD_PK_HSHD_MEMBER", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Object[]> findSPLPersonPersonID(int idStage, Date dtSysTsQuery) {
    SQLQuery query = getSession().createSQLQuery("SELECT A.CD_STAGE_PERS_TYPE, " + "       A.CD_STAGE_PERS_ROLE, "
                                                                 + "       C.NM_PERS_HIST_FULL, "
                                                                 + "       C.DT_PERS_HIST_BIRTH, "
                                                                 + "       C.NBR_PERS_HIST_AGE, "
                                                                 + "       C.CD_PERS_HIST_SEX, "
                                                                 + "       A.CD_STAGE_PERS_REL_INT, "
                                                                 + "       A.IND_STAGE_PERS_REPORTER, "
                                                                 + "       A.CD_STAGE_PERS_SEARCH_IND, "
                                                                 + "       C.DT_PERS_HIST_DEATH, "
                                                                 + "       C.CD_PERS_HIST_DEATH, "
                                                                 + "       C.CD_PERS_HIST_MARITAL_STAT, "
                                                                 + "       C.CD_PERS_HIST_LANGUAGE, "
                                                                 + "       C.CD_DISASTER_RLF, "
                                                                 + "       C.CD_PERS_HIST_ETHNIC, "
                                                                 + "       A.TXT_STAGE_PERS_NOTES, "
                                                                 + "       A.ID_STAGE, " + "       A.ID_PERSON, "
                                                                 + "       D.NBR_PERSON_ID_NUMBER, "
                                                                 + "       D.ID_PERSON_ID, "
                                                                 + "       D.IND_PERSON_ID_INVALID, "
                                                                 + "       D.DT_PERSON_ID_START, "
                                                                 + "       D.DT_PERSON_ID_END, "
                                                                 + "       D.DESC_PERSON_ID, "
                                                                 + "       C.IND_PERS_HIST_DOB_APPROX, "
                                                                 + "       A.IND_STAGE_PERS_IN_LAW, "
                                                                 + "       A.CD_STAGE_PERS_LST_SORT, "
                                                                 + "       C.CD_PERS_HIST_SUFFIX, "
                                                                 + "       C.CD_PERS_HIST_TITLE, "
                                                                 + "       C.IND_PERS_HIST_US_CITIZEN, "
                                                                 + "       C.CD_PERS_HIST_IMMG_STATUS, "
                                                                 + "       C.CD_PERS_HIST_COUNTRY_ORIGIN, "
                                                                 + "       C.CD_PERS_HIST_PROOF_CITIZEN, "
                                                                 + "       C.CD_PERS_HIST_MATCH_TYPE, "
                                                                 + "       C.TXT_PERS_HIST_OTHER_RELATIONS, "
                                                                 + "       A.CD_PK_HSHD_MEMBER "
                                                                 + "  FROM STAGE_PERSON_LINK A, "
                                                                 + "       PERSON_HISTORY C, " + "       PERSON_ID D "
                                                                 + " WHERE A.ID_STAGE = :idStage "
                                                                 + "   AND A.CD_STAGE_PERS_TYPE != 'STF' "
                                                                 + "   AND C.DT_PERS_HIST_EFFECT <= :dtSysTsQuery "
                                                                 + "   AND C.DT_PERS_HIST_END >= :dtSysTsQuery "
                                                                 + "   AND A.ID_PERSON = C.ID_PERS_HIST_PERSON "
                                                                 + "   AND D.ID_PERSON (+) = C.ID_PERS_HIST_PERSON "
                                                                 + "   AND D.DT_PERSON_ID_START (+) <= :dtSysTsQuery "
                                                                 + "   AND D.DT_PERSON_ID_END (+) >= :dtSysTsQuery "
                                                                 + "   AND D.Cd_Person_Id_Type (+) = 'SSN'");
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);
    query.addScalar("CD_STAGE_PERS_TYPE", Hibernate.STRING);
    query.addScalar("CD_STAGE_PERS_ROLE", Hibernate.STRING);
    query.addScalar("NM_PERS_HIST_FULL", Hibernate.STRING);
    query.addScalar("DT_PERS_HIST_BIRTH", Hibernate.DATE);
    query.addScalar("NBR_PERS_HIST_AGE", Hibernate.INTEGER);
    query.addScalar("CD_PERS_HIST_SEX", Hibernate.STRING);
    query.addScalar("CD_STAGE_PERS_REL_INT", Hibernate.STRING);
    query.addScalar("IND_STAGE_PERS_REPORTER", Hibernate.STRING);
    query.addScalar("CD_STAGE_PERS_SEARCH_IND", Hibernate.STRING);
    query.addScalar("DT_PERS_HIST_DEATH", Hibernate.DATE);
    query.addScalar("CD_PERS_HIST_DEATH", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_MARITAL_STAT", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_LANGUAGE", Hibernate.STRING);
    query.addScalar("CD_DISASTER_RLF", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_ETHNIC", Hibernate.STRING);
    query.addScalar("TXT_STAGE_PERS_NOTES", Hibernate.STRING);
    query.addScalar("ID_STAGE", Hibernate.INTEGER);
    query.addScalar("ID_PERSON", Hibernate.INTEGER);
    query.addScalar("NBR_PERSON_ID_NUMBER", Hibernate.STRING);
    query.addScalar("ID_PERSON_ID", Hibernate.STRING);
    query.addScalar("IND_PERSON_ID_INVALID", Hibernate.STRING);
    query.addScalar("DT_PERSON_ID_START", Hibernate.DATE);
    query.addScalar("DT_PERSON_ID_END", Hibernate.DATE);
    query.addScalar("DESC_PERSON_ID", Hibernate.STRING);
    query.addScalar("IND_PERS_HIST_DOB_APPROX", Hibernate.STRING);
    query.addScalar("IND_STAGE_PERS_IN_LAW", Hibernate.STRING);
    query.addScalar("CD_STAGE_PERS_LST_SORT", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_SUFFIX", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_TITLE", Hibernate.STRING);
    query.addScalar("IND_PERS_HIST_US_CITIZEN", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_IMMG_STATUS", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_COUNTRY_ORIGIN", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_PROOF_CITIZEN", Hibernate.STRING);
    query.addScalar("CD_PERS_HIST_MATCH_TYPE", Hibernate.STRING);
    query.addScalar("TXT_PERS_HIST_OTHER_RELATIONS", Hibernate.STRING);
    query.addScalar("CD_PK_HSHD_MEMBER", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findStagePersonLink(int idStage, String cdStagePersType, Date dtMaxDate) {
    Query query = getSession().createQuery("  select new map(n.idName as idName, "
                                                           + "                 n.indNameInvalid as indNameInvalid, "
                                                           + "                 n.nmNameFirst as nmNameFirst, "
                                                           + "                 n.nmNameMiddle as nmNameMiddle, "
                                                           + "                 n.nmNameLast as nmNameLast, "
                                                           + "                 n.indNamePrimary as indNamePrimary, "
                                                           + "                 n.cdNameSuffix as cdNameSuffix, "
                                                           + "                 n.dtNameStartDate as dtNameStartDate, "
                                                           + "                 n.dtNameEndDate as dtNameEndDate, "
                                                           + "                 s.dtLastUpdate as dtLastUpdate, "
                                                           + "                 s.person.idPerson as idPerson, "
                                                           + "                 s.idStagePersonLink as idStagePersonLink, "
                                                           + "                 s.stage.idStage as idStage, "
                                                           + "                 s.cdStagePersRole as cdStagePersRole, "
                                                           + "                 s.indStagePersInLaw as indStagePersInLaw, "
                                                           + "                 s.cdStagePersType as cdStagePersType, "
                                                           + "                 s.cdStagePersSearchInd as cdStagePersSearchInd, "
                                                           + "                 s.txtStagePersNotes as txtStagePersNotes, "
                                                           + "                 s.dtStagePersLink as dtStagePersLink, "
                                                           + "                 s.cdStagePersRelInt as cdStagePersRelInt, "
                                                           + "                 s.indStagePersReporter as indStagePersReporter, "
                                                           + "                 s.indStagePersEmpNew as indStagePersEmpNew, "
                                                           + "                 p.cdPersonSex as cdPersonSex, "
                                                           + "                 p.nmPersonFull as nmPersonFull, "
                                                           + "                 p.nbrPersonAge as nbrPersonAge, "
                                                           + "                 p.dtPersonDeath as dtPersonDeath, "
                                                           + "                 p.dtPersonBirth as dtPersonBirth, "
                                                           + "                 p.cdPersonReligion as cdPersonReligion, "
                                                           + "                 p.cdPersonChar as cdPersonChar, "
                                                           + "                 p.indPersonDobApprox as indPersonDobApprox, "
                                                           + "                 p.cdPersonLivArr as cdPersonLivArr, "
                                                           + "                 p.cdPersGuardCnsrv as cdPersGuardCnsrv, "
                                                           + "                 p.cdPersonStatus as cdPersonStatus, "
                                                           + "                 p.cdPersonDeath as cdPersonDeath, "
                                                           + "                 p.cdPersonMaritalStatus as cdPersonMaritalStatus, "
                                                           + "                 p.txtPersonOccupation as txtPersonOccupation, "
                                                           + "                 p.cdPersonLanguage as cdPersonLanguage, "
                                                           + "                 p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "                 p.indPersCancelHist as indPersCancelHist) "
                                                           + "    from StagePersonLink s "
                                                           + "    left join s.person p "
                                                           + "    left join s.person.names n "
                                                           + "    where s.stage.idStage = :idStage "
                                                           + "     and s.cdStagePersType = :cdStagePersType "
                                                           + "     and n.indNamePrimary = 'Y' "
                                                           + "     and n.indNameInvalid = 'N' "
                                                           + "     and n.dtNameEndDate = :dtMaxDate "
                                                           + "     order by s.indStagePersReporter");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    query.setTimestamp("dtMaxDate", dtMaxDate);
    return (List<Map>) query.list();
  }

  // STGAP00017013: MR-095
  // This DAO is for the Foster Care principal List for FCC Stage on the Custody page
  // The sort logic of 'order by spl.indStagePersReporter' is used in here 
  // because the DAO for the neighboring Person Living In Home at Removal section on the Custody page has the same order
  @SuppressWarnings({ "unchecked" })
  public List<Map> findStagePersonLinkExcludingIdPerson(int idStage, String cdStagePersType, Date dtMaxDate,
                                                        int idPerson) {
    Query query = getSession().createQuery("  select new map(n.idName as idName, "
                                                           + "                 s.person.idPerson as idPersonPrincipal, "
                                                           + "                 s.idStagePersonLink as idStagePersonLink, "
                                                           + "                 s.stage.idStage as idStage, "
                                                           + "                 s.cdStagePersRole as cdStagePersRole, "
                                                           + "                 s.cdStagePersType as cdStagePersType, "
                                                           + "                 s.cdStagePersRelInt as cdStagePersRelInt, "
                                                           + "                 p.cdPersonSex as cdPersonSex, "
                                                           + "                 p.nmPersonFull as nmPersonFull) "
                                                           + "    from StagePersonLink s "
                                                           + "    left join s.person p "
                                                           + "    left join s.person.names n "
                                                           + "    where s.stage.idStage = :idStage "
                                                           + "     and s.cdStagePersType = :cdStagePersType "
                                                           + "     and n.indNamePrimary = 'Y' "
                                                           + "     and n.indNameInvalid = 'N' "
                                                           + "     and n.dtNameEndDate = :dtMaxDate "
                                                           + "     and s.person.idPerson <> :idPerson "
                                                           + "     order by s.indStagePersReporter");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersType", cdStagePersType);
    query.setTimestamp("dtMaxDate", dtMaxDate);
    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }

  public Integer findDistinctIdCaseFromStagePersonLinkByIdCase(int idCase) {
    SQLQuery query = getSession().createSQLQuery("SELECT DISTINCT ID_CASE "
                                                                 + "  FROM STAGE_PERSON_LINK "
                                                                 + " WHERE ID_CASE IN (SELECT DISTINCT ID_CASE_MERGE_TO "
                                                                 + "                     FROM CASE_MERGE "
                                                                 + "                    WHERE DT_CASE_MERGE_SPLIT IS NULL "
                                                                 + "                      AND IND_CASE_MERGE_PENDING IS NULL "
                                                                 + "               START WITH ID_CASE_MERGE_FROM = :idCase "
                                                                 + "         CONNECT BY PRIOR ID_CASE_MERGE_TO = ID_CASE_MERGE_FROM) ");
    query.setInteger("idCase", idCase);
    query.addScalar("ID_CASE", Hibernate.INTEGER);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findStagePersonLink(int idCase) {
    SQLQuery query = getSession().createSQLQuery("SELECT NVL(P.ID_PERS_MERGE_FORWARD, L.ID_PERSON) AS idPersMergeForward, "
                                                                 + "       L.ID_STAGE AS idStage, "
                                                                 + "       L.CD_STAGE_PERS_ROLE AS cdStagePersRole, "
                                                                 + "       L.CD_STAGE_PERS_TYPE AS cdStagePersType "
                                                                 + "  FROM PERSON_MERGE P, "
                                                                 + "       STAGE_PERSON_LINK L, "
                                                                 + "       STAGE S "
                                                                 + " WHERE S.ID_CASE = :idCase "
                                                                 + "   AND L.ID_STAGE = S.ID_STAGE "
                                                                 + "   AND L.CD_STAGE_PERS_TYPE = 'PRN' "
                                                                 + "   AND  L.CD_STAGE_PERS_ROLE != 'HP' "
                                                                 + "   AND L.CD_STAGE_PERS_ROLE != 'PR' "
                                                                 + "   AND L.CD_STAGE_PERS_ROLE != 'SE' "
                                                                 + "   AND P.ID_PERS_MERGE_CLOSED(+)   = L.ID_PERSON "
                                                                 + "   AND P.IND_PERS_MERGE_INVALID(+)     = 'N'");
    query.setInteger("idCase", idCase);
    query.addScalar("idPersMergeForward", Hibernate.INTEGER);
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("cdStagePersRole", Hibernate.STRING);
    query.addScalar("cdStagePersType", Hibernate.STRING);
    query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    return (List<Map>) query.list();
  }

  public long countOpenSubCareStages(int idPerson, String cdStagePersRole) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink spl , Stage s "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.cdStagePersRole = :cdStagePersRole "
                                                           + "   and s.idStage = spl.stage.idStage "
                                                           + "   and (s.dtStageClose is null "
                                                           + " or s.dtStageClose = :maxDate) " + "   and s.cdStage = '"
                                                           + CodesTables.CSTAGES_SUB + "' ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  public int updateStagePersonLinkIdPerson(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.person.idPerson = :idPersMergeForward "
                                                           + " where spl.idStagePersonLink in "
                                                           + "       (select spl2.idStagePersonLink "
                                                           + "          from Stage s, "
                                                           + "               StagePersonLink spl2 "
                                                           + "         where (s.dtStageClose is null "
                                                           + "       or s.dtStageClose = :maxDate) "
                                                           + "           and s.idStage = spl2.stage.idStage "
                                                           + "           and spl2.person.idPerson = :idPersMergeClosed) ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkIdCaseByIdStage(int idCase, int idStage) {
    Query query = getSession().createQuery("update StagePersonLink " + "   set capsCase.idCase = :idCase "
                                                           + " where stage.idStage = :idStage");
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateIdPersonCdStagePersTypeByIdStagePersonLink(int idPersMergeForward, int idStagePerson,
                                                              String cdStagePersType, Date tsLastUpdate) {
    Query query = getSession().createQuery("update StagePersonLink " + "   set person.idPerson = :idPersMergeForward, "
                                                           + "       cdStagePersType = :cdStagePersType "
                                                           + " where idStagePersonLink = :idStagePerson "
                                                           + "   and dtLastUpdate = :tsLastUpdate");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idStagePerson", idStagePerson);
    query.setString("cdStagePersType", cdStagePersType);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkIndNmStage(int idStage, int idPerson) {
    Query query = getSession().createQuery("update StagePersonLink spl " + "   set spl.indNmStage = 1 "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.person.idPerson = :idPerson ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkIndStagePersEmpNew(int idStage, int idPerson) {
    Query query = getSession().createQuery("update StagePersonLink spl " + "   set spl.indStagePersEmpNew = '0' "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.person.idPerson = :idPerson");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int insertStagePersonLinkWihoutIndNmStage(int idStage, int idPerson, String cdStagePersRole,
                                                   String cdStagePersType, String cdStagePersSearchInd,
                                                   String txtStagePersNotes, Date dtStagePersLink,
                                                   String cdStagePersRelInt, String indStagePersReporter,
                                                   String indStagePersInLaw, String indStagePersEmpNew,
                                                   String cdPKHouseholdMember, String cdPersonSideOfFamily) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO STAGE_PERSON_LINK (ID_STAGE_PERSON_LINK, "
                                                                 + "                               ID_STAGE, "
                                                                 + "                               ID_PERSON, "
                                                                 + "                               CD_STAGE_PERS_ROLE, "
                                                                 + "                               CD_STAGE_PERS_TYPE, "
                                                                 + "                               CD_STAGE_PERS_SEARCH_IND, "
                                                                 + "                               TXT_STAGE_PERS_NOTES, "
                                                                 + "                               DT_STAGE_PERS_LINK, "
                                                                 + "                               CD_STAGE_PERS_REL_INT, "
                                                                 + "                               IND_STAGE_PERS_REPORTER, "
                                                                 + "                               IND_STAGE_PERS_IN_LAW, "
                                                                 + "                               IND_STAGE_PERS_EMP_NEW, "
                                                                 + "                               CD_PK_HSHD_MEMBER, "
                                                                 + "                               CD_PERSON_SIDE_OF_FAMILY ) "
                                                                 + "     VALUES (SEQ_STAGE_PERSON_LINK.NEXTVAL, "
                                                                 + "             :idStage, "
                                                                 + "             :idPerson, "
                                                                 + "             :cdStagePersRole, "
                                                                 + "             :cdStagePersType, "
                                                                 + "             :cdStagePersSearchInd, "
                                                                 + "             :txtStagePersNotes, "
                                                                 + "             :dtStagePersLink, "
                                                                 + "             :cdStagePersRelInt, "
                                                                 + "             :indStagePersReporter, "
                                                                 + "             :indStagePersInLaw, "
                                                                 + "             :indStagePersEmpNew, "
                                                                 + "             :cdPKHouseholdMember, "
                                                                 + "             :cdPersonSideOfFamily) ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setString("txtStagePersNotes", txtStagePersNotes);
    query.setTimestamp("dtStagePersLink", dtStagePersLink);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("indStagePersReporter", indStagePersReporter);
    query.setString("indStagePersInLaw", indStagePersInLaw);
    query.setString("indStagePersEmpNew", indStagePersEmpNew);
    query.setString("cdPKHouseholdMember", cdPKHouseholdMember);
    query.setString("cdPersonSideOfFamily", cdPersonSideOfFamily);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkWithoutIndNmStage(int idPerson, String cdStagePersRole, String cdStagePersType,
                                                    String cdStagePersSearchInd, String txtStagePersNotes,
                                                    Date dtStagePersLink, String cdStagePersRelInt,
                                                    String indStagePersReporter, String indStagePersInLaw,
                                                    String indStagePersEmpNew, int idStagePerson,
                                                    String cdPKHouseholdMember, String cdPersonSideOfFamily) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.person.idPerson = :idPerson, "
                                                           + "       spl.cdStagePersType = :cdStagePersType, "
                                                           + "       spl.cdStagePersSearchInd = :cdStagePersSearchInd, "
                                                           + "       spl.txtStagePersNotes = :txtStagePersNotes, "
                                                           + "       spl.dtStagePersLink = :dtStagePersLink, "
                                                           + "       spl.cdStagePersRelInt = :cdStagePersRelInt, "
                                                           + "       spl.indStagePersReporter = :indStagePersReporter, "
                                                           + "       spl.indStagePersEmpNew = :indStagePersEmpNew, "
                                                           + "       spl.indStagePersInLaw = :indStagePersInLaw, "
                                                           + "       spl.cdStagePersRole = :cdStagePersRole, "
                                                           + "       spl.cdPKHshdMember = :cdPKHouseholdMember,  "
                                                           + "       spl.cdPersonSideOfFamily = :cdPersonSideOfFamily "
                                                           + " where spl.idStagePersonLink = :idStagePerson");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setString("txtStagePersNotes", txtStagePersNotes);
    query.setTimestamp("dtStagePersLink", dtStagePersLink);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("indStagePersReporter", indStagePersReporter);
    query.setString("indStagePersInLaw", indStagePersInLaw);
    query.setString("indStagePersEmpNew", indStagePersEmpNew);
    query.setInteger("idStagePerson", idStagePerson);
    query.setString("cdPKHouseholdMember", cdPKHouseholdMember);
    query.setString("cdPersonSideOfFamily", cdPersonSideOfFamily);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkRole(int idStage, String cdStagePersRoleNew, String cdStagePersRoleOld,
                                       String cdStagePersType) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdStagePersRole = :cdStagePersRoleNew "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersRole = :cdStagePersRoleOld "
                                                           + "   and spl.cdStagePersType = :cdStagePersType");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRoleNew", cdStagePersRoleNew);
    query.setString("cdStagePersRoleOld", cdStagePersRoleOld);
    query.setString("cdStagePersType", cdStagePersType);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkClearIndNMStageByIdStage(int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl " + "   set spl.indNmStage = null "
                                                           + " where spl.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkClearIdCaseByIdStage(int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl " + "   set spl.capsCase.idCase = null "
                                                           + " where spl.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkIndStagePersInLaw(String indStagePersInLaw, int idPerson, int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.indStagePersInLaw = :indStagePersInLaw "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.stage.idStage = :idStage");
    query.setString("indStagePersInLaw", indStagePersInLaw);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkIdPersonCdStagePersSearchInd(int idRelatedPerson, String cdStagePersSearchInd,
                                                               int idPerson, int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.person.idPerson = :idRelatedPerson, "
                                                           + "       spl.cdStagePersSearchInd = :cdStagePersSearchInd "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.stage.idStage = :idStage");
    query.setInteger("idRelatedPerson", idRelatedPerson);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkCdStagePersSearchInd(String cdStagePersSearchInd, int idPerson, int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdStagePersSearchInd = :cdStagePersSearchInd "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.stage.idStage = :idStage");
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkCdStagePersRole(String cdStagePersRole, int idPerson, int idStage, Date dtLastUpdate) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdStagePersRole = :cdStagePersRole "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.stage.idStage = :idStage "
                                                           + "   and spl.dtLastUpdate = :dtLastUpdate");
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkCdStagePersRelInt(String cdStagePersRelInt, int idPerson, int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdStagePersRelInt = :cdStagePersRelInt "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.stage.idStage = :idStage");
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkCdStagePersRole(String cdStagePersRole, int idPerson, int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdStagePersRole = :cdStagePersRole "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.stage.idStage = :idStage");
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStagePersonLinkcdStagePersType(String cdStagePersType, int idPerson, int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdStagePersType = :cdStagePersType "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.stage.idStage = :idStage");
    query.setString("cdStagePersType", cdStagePersType);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  // MR-056 added cdPKHouseholdMember
  public int insertStagePersonLink(String cdStagePersRole, String cdStagePersType, String cdStagePersSearchInd,
                                   String txtStagePersNotes, String cdStagePersRelInt, String indStagePersReporter,
                                   int idStage, int idPerson, String indStagePersInLaw, String cdStagePersLstSort,
                                   String cdPKHouseholdMember) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO STAGE_PERSON_LINK (CD_STAGE_PERS_ROLE, "
                                                                 + "                               CD_STAGE_PERS_TYPE, "
                                                                 + "                               CD_STAGE_PERS_SEARCH_IND, "
                                                                 + "                               TXT_STAGE_PERS_NOTES, "
                                                                 + "                               CD_STAGE_PERS_REL_INT, "
                                                                 + "                               IND_STAGE_PERS_REPORTER, "
                                                                 + "                               ID_STAGE,ID_PERSON, "
                                                                 + "                               ID_STAGE_PERSON_LINK, "
                                                                 + "                               IND_STAGE_PERS_IN_LAW, "
                                                                 + "                               CD_STAGE_PERS_LST_SORT, "
                                                                 + "                               CD_PK_HSHD_MEMBER ) "
                                                                 + "                        VALUES(:cdStagePersRole, "
                                                                 + "                               :cdStagePersType, "
                                                                 + "                               :cdStagePersSearchInd, "
                                                                 + "                               :txtStagePersNotes, "
                                                                 + "                               :cdStagePersRelInt, "
                                                                 + "                               :indStagePersReporter, "
                                                                 + "                               :idStage, "
                                                                 + "                               :idPerson, "
                                                                 + "                               SEQ_STAGE_PERSON_LINK.NEXTVAL, "
                                                                 + "                               :indStagePersInLaw, "
                                                                 + "                               :cdStagePersLstSort, "
                                                                 + "                               :cdPKHouseholdMember )");
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setString("txtStagePersNotes", txtStagePersNotes);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("indStagePersReporter", indStagePersReporter);
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setString("indStagePersInLaw", indStagePersInLaw);
    query.setString("cdStagePersLstSort", cdStagePersLstSort);
    query.setString("cdPKHouseholdMember", cdPKHouseholdMember);
    return query.executeUpdate();
  }

  // STGAP00017013: MR-095
  public int insertStagePersonLinkAddedFromAddPersonToActiveStages(int idStage, int idPerson, String cdStagePersRole,
                                                                   String cdStagePersType, String cdStagePersRelInt,
                                                                   String cdStagePersSearchInd) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO STAGE_PERSON_LINK (CD_STAGE_PERS_ROLE, "
                                                                 + "                               CD_STAGE_PERS_TYPE, "
                                                                 + "                               CD_STAGE_PERS_SEARCH_IND, "
                                                                 + "                               CD_STAGE_PERS_REL_INT, "
                                                                 + "                               ID_STAGE, "
                                                                 + "                               ID_PERSON, "
                                                                 + "                               ID_STAGE_PERSON_LINK ) "
                                                                 + "                        VALUES(:cdStagePersRole, "
                                                                 + "                               :cdStagePersType, "
                                                                 + "                               :cdStagePersSearchInd, "
                                                                 + "                               :cdStagePersRelInt, "
                                                                 + "                               :idStage, "
                                                                 + "                               :idPerson, "
                                                                 + "                               SEQ_STAGE_PERSON_LINK.NEXTVAL )");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    return query.executeUpdate();
  }

  public int deleteStagePersonLinkByIdStageCdStagePersRole(int idStage) {
    Query query = getSession().createQuery("delete StagePersonLink spl " + " where spl.stage.idStage = :idStage "
                                                           + "   and (spl.cdStagePersRole = 'PR' "
                                                           + "         or spl.cdStagePersRole = 'SE')");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int deleteStagePersonLink(int idStage, int idPerson) {
    Query query = getSession().createQuery("delete StagePersonLink s " + " where s.stage.idStage = :idStage "
                                                           + "   and s.person.idPerson = :idPerson ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int deleteStagePersonLinkFromStage(int idStage, int idPerson) {
    Query query = getSession().createQuery("delete StagePersonLink s " + " where s.stage.idStage = :idStage "
                                                           + "   and s.person.idPerson = :idPerson "
                                                           + " and s.cdStagePersType <> 'STF'");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public void deleteStagePersonLink(StagePersonLink stagePersonLink) {
    getSession().delete(stagePersonLink);
  }

  public int deleteStagePersonLinkByIdStage(int idStage, String cdPersonRole) {
    Query query = getSession().createQuery("delete StagePersonLink spl " + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersRole = :cdPersonRole");
    query.setInteger("idStage", idStage);
    query.setString("cdPersonRole", cdPersonRole);
    return query.executeUpdate();
  }

  public int insertStagePersonLink(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                                   String cdStagePersSearchInd, String cdStagePersRelInt, String indStagePersReporter,
                                   String indStagePersInLaw, String indSafetyRsrc, Date dtStagePersLink,
                                   String sideOfFamily, String cdPKHouseholdMember, Date dtPersonAddedOrRelated) {
    StagePersonLink stagePersonLink = new StagePersonLink();
    stagePersonLink.setIdStagePersonLink(0);
    Stage stage = (Stage) getSession().load(Stage.class, idStage);
    stagePersonLink.setStage(stage);
    Person person = (Person) getSession().load(Person.class, idPerson);
    stagePersonLink.setPerson(person);
    stagePersonLink.setCdStagePersRole(cdStagePersRole);
    stagePersonLink.setCdStagePersType(cdStagePersType);
    stagePersonLink.setCdStagePersSearchInd(cdStagePersSearchInd);
    stagePersonLink.setCdStagePersRelInt(cdStagePersRelInt);
    stagePersonLink.setIndStagePersReporter(indStagePersReporter);
    stagePersonLink.setIndStagePersInLaw(indStagePersInLaw);
    stagePersonLink.setIndStagePersSftyResource(indSafetyRsrc);
    stagePersonLink.setDtStagePersLink(dtStagePersLink);
    stagePersonLink.setCdPersonSideOfFamily(sideOfFamily);
    stagePersonLink.setCdPKHshdMember(cdPKHouseholdMember);
    stagePersonLink.setDtPersonAddedOrRelated(dtPersonAddedOrRelated);
    getSession().saveOrUpdate(stagePersonLink);
    return stagePersonLink.getIdStagePersonLink();
  }

  public int insertStagePersonLink(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                                   String cdStagePersSearchInd, String txtStagePersNotes, Date dtStagePersLink,
                                   String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                                   String indStagePersEmpNew) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO STAGE_PERSON_LINK (ID_STAGE_PERSON_LINK, "
                                                                 + "                               ID_STAGE, "
                                                                 + "                               ID_PERSON, "
                                                                 + "                               CD_STAGE_PERS_ROLE, "
                                                                 + "                               CD_STAGE_PERS_TYPE, "
                                                                 + "                               CD_STAGE_PERS_SEARCH_IND, "
                                                                 + "                               TXT_STAGE_PERS_NOTES, "
                                                                 + "                               DT_STAGE_PERS_LINK, "
                                                                 + "                               CD_STAGE_PERS_REL_INT, "
                                                                 + "                               IND_STAGE_PERS_REPORTER, "
                                                                 + "                               IND_STAGE_PERS_IN_LAW, "
                                                                 + "                               IND_STAGE_PERS_EMP_NEW) "
                                                                 + "      VALUES(SEQ_STAGE_PERSON_LINK.NEXTVAL, "
                                                                 + "             :idStage, "
                                                                 + "             :idPerson, "
                                                                 + "             :cdStagePersRole, "
                                                                 + "             :cdStagePersType, "
                                                                 + "             :cdStagePersSearchInd, "
                                                                 + "             :txtStagePersNotes, "
                                                                 + "             :dtStagePersLink, "
                                                                 + "             :cdStagePersRelInt, "
                                                                 + "             :indStagePersReporter, "
                                                                 + "             :indStagePersInLaw, "
                                                                 + "             :indStagePersEmpNew) ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setString("txtStagePersNotes", txtStagePersNotes);
    query.setTimestamp("dtStagePersLink", dtStagePersLink);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("indStagePersReporter", indStagePersReporter);
    query.setString("indStagePersInLaw", indStagePersInLaw);
    query.setString("indStagePersEmpNew", indStagePersEmpNew);
    return query.executeUpdate();
  }

  // Added cdPKHouseholdMember
  public int updateStagePersonLink(String cdStagePersRole, String cdStagePersType, String cdStagePersSearchInd,
                                   String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                                   int idStagePersonLink, String indStagePersSftyResource, Date lastUpdate,
                                   String cdPersonSideOfFamily, String cdPKHouseholdMember) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdStagePersRole = :cdStagePersRole, "
                                                           + "       spl.cdStagePersType = :cdStagePersType, "
                                                           + "       spl.cdStagePersSearchInd = :cdStagePersSearchInd, "
                                                           + "       spl.cdStagePersRelInt = :cdStagePersRelInt, "
                                                           + "       spl.indStagePersReporter = :indStagePersReporter, "
                                                           + "       spl.indStagePersInLaw = :indStagePersInLaw, "
                                                           + "       spl.indStagePersSftyResource = :indStagePersSftyResource, "
                                                           + "       spl.cdPersonSideOfFamily = :cdPersonSideOfFamily, "
                                                           + "       spl.cdPKHshdMember = :cdPKHouseholdMember "
                                                           + " where spl.idStagePersonLink  =  :idStagePersonLink "
                                                           + "  and  spl.dtLastUpdate = :lastUpdate ");
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("indStagePersReporter", indStagePersReporter);
    query.setString("indStagePersInLaw", indStagePersInLaw);
    query.setInteger("idStagePersonLink", idStagePersonLink);
    query.setString("indStagePersSftyResource", indStagePersSftyResource);
    query.setString("cdPersonSideOfFamily", cdPersonSideOfFamily);
    query.setString("cdPKHouseholdMember", cdPKHouseholdMember);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  public int updateStagePersonLink(int idStage, int idPerson, String cdStagePersRole, String cdStagePersType,
                                   String cdStagePersSearchInd, String txtStagePersNotes, Date dtStagePersLink,
                                   String cdStagePersRelInt, String indStagePersReporter, String indStagePersInLaw,
                                   String indStagePersEmpNew, int idStagePerson, Date lastUpdate) {
    Query query = getSession().createQuery("update StagePersonLink spl " + "  set spl.person.idPerson = :idPerson, "
                                                           + "      spl.cdStagePersType = :cdStagePersType, "
                                                           + "      spl.cdStagePersSearchInd = :cdStagePersSearchInd, "
                                                           + "      spl.txtStagePersNotes = :txtStagePersNotes, "
                                                           + "      spl.dtStagePersLink = :dtStagePersLink, "
                                                           + "      spl.cdStagePersRelInt = :cdStagePersRelInt, "
                                                           + "      spl.indStagePersReporter = :indStagePersReporter, "
                                                           + "      spl.indStagePersInLaw = :indStagePersInLaw, "
                                                           + "      spl.indStagePersEmpNew = :indStagePersEmpNew, "
                                                           + "      spl.cdStagePersRole = :cdStagePersRole "
                                                           + "where spl.idStagePersonLink  =  :idStagePerson "
                                                           + " and  spl.dtLastUpdate = :lastUpdate ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setString("txtStagePersNotes", txtStagePersNotes);
    query.setTimestamp("dtStagePersLink", dtStagePersLink);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("indStagePersReporter", indStagePersReporter);
    query.setString("indStagePersInLaw", indStagePersInLaw);
    query.setString("indStagePersEmpNew", indStagePersEmpNew);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setInteger("idStagePerson", idStagePerson);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  // MR-056 Added cdPKHouseholdMember
  public int updateStagePersonLink(String txtStagePersNotes, String cdStagePersRole, String cdStagePersType,
                                   String cdStagePersSearchInd, String cdStagePersRelInt, String indStagePersReporter,
                                   String indStagePersInLaw, String cdStagePersLstSort, int idStage, int idPerson,
                                   String cdPKHouseholdMember) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdStagePersRole = :cdStagePersRole, "
                                                           + "       spl.cdStagePersType = :cdStagePersType, "
                                                           + "       spl.cdStagePersSearchInd = :cdStagePersSearchInd, "
                                                           + "       spl.txtStagePersNotes = :txtStagePersNotes, "
                                                           + "       spl.cdStagePersRelInt = :cdStagePersRelInt, "
                                                           + "       spl.indStagePersReporter = :indStagePersReporter, "
                                                           + "       spl.indStagePersInLaw = :indStagePersInLaw, "
                                                           + "       spl.cdStagePersLstSort = :cdStagePersLstSort, "
                                                           + "       spl.cdPKHshdMember = :cdPKHouseholdMember "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.person.idPerson = :idPerson");
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersSearchInd", cdStagePersSearchInd);
    query.setString("txtStagePersNotes", txtStagePersNotes);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("indStagePersReporter", indStagePersReporter);
    query.setString("indStagePersInLaw", indStagePersInLaw);
    query.setString("cdStagePersLstSort", cdStagePersLstSort);
    query.setString("cdPKHouseholdMember", cdPKHouseholdMember);
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findStagePersonLinkByIdResource(int idRsrcFacil, Date dtRshsEnd, Date dtRshsEffective,
                                                   String cdPlcmtActPlanned) {
    Query query = getSession().createQuery("select a.personByIdPlcmtChild.idPerson as idPlcmtChild, "
                                                           + "       b.nmPersonFull as nmPersonFull, "
                                                           + "       c.stage.idStage as idStage, "
                                                           + "       c.person.idPerson as idPerson "
                                                           + "  from Placement a, "
                                                           + "       Person b, "
                                                           + "       Event e, "
                                                           + "       StagePersonLink c "
                                                           + " where a.capsResourceByIdRsrcFacil.idResource = :idRsrcFacil "
                                                           + "   and trunc(a.dtPlcmtStart) <= :dtRshsEnd "
                                                           + "   and trunc(a.dtPlcmtEnd) >= :dtRshsEffective "
                                                           + "   and a.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and b.idPerson = a.personByIdPlcmtChild.idPerson "
                                                           + "   and e.idEvent = a.idPlcmtEvent "
                                                           + "   and e.stage.idStage = c.stage.idStage "
                                                           + "   and (c.cdStagePersRole = :persRolePR "
                                                           + "         or c.cdStagePersRole = :persRoleHP) ");
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setString("persRolePR", CodesTables.CROLEALL_PR);
    query.setString("persRoleHP", CodesTables.CROLEALL_HP);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findRelationshipByIdStage(int idStage) {
    Query query = getSession().createQuery("select new map(spl.person.idPerson as idPerson, "
                                                           + "               p.nmPersonFull as nmPersonFull) "
                                                           + "  from StagePersonLink spl, " + "       Person p "
                                                           + " where spl.person.idPerson = p.idPerson "
                                                           + "   and spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersType = '"
                                                           + CodesTables.CPRSNTYP_PRN + "'");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  public void saveStagePersonLink(StagePersonLink spl) {
    getSession().saveOrUpdate(spl);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findPersonsForAttendeesArrayByIdStage(int idStage) {
    Query query = getSession().createQuery("    select distinct new map(p.idPerson as idPerson, "
                                                           + "                            p.nmPersonFull as nmPersonFull, "
                                                           + "                            spl.cdStagePersType as cdStagePersType, "
                                                           + "                            spl.cdStagePersRole as cdStagePersRole, "
                                                           + "                            spl.cdStagePersRelInt as cdStagePersRelInt) "
                                                           + "      from StagePersonLink spl "
                                                           + "inner join spl.person p "
                                                           + "     where spl.stage.idStage = :idStage "
                                                           + "       and spl.cdStagePersType != :staffType");
    query.setInteger("idStage", idStage);
    query.setString("staffType", CodesTables.CPRSNALL_STF);
    return (List<Map>) query.list();
  }

  public Person findStagePersonLinkPrimaryCaretaker(int idStage) {
    Query query = getSession().createQuery("select s.person " + "  from StagePersonLink s  "
                                                           + " where s.stage.idStage = :idStage  "
                                                           + "   and s.cdStagePersRelInt = '" + CodesTables.CRELVICT_PK
                                                           + "' ");
    query.setInteger("idStage", idStage);
    return (Person) firstResult(query);
  }

  // STGAP00017013: MR-095
  // Find Person by idStage and cdStagePersRelInt
  public Person findPersonByIdStageByCdStagePersRelInt(int idStage, String cdStagePersRelInt) {
    Query query = getSession().createQuery("select s.person " + "  from StagePersonLink s  "
                                                           + " where s.stage.idStage = :idStage  "
                                                           + "   and s.cdStagePersRelInt = :cdStagePersRelInt ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    return (Person) firstResult(query);
  }

  // STGAP00017013: MR-095
  // Find the first Person related to the stage by idStage and nmPersonFull
  public Person findPersonByIdStageByNmPersonFull(int idStage, String nmPersonFull) {
    Query query = getSession().createQuery("select s.person " + "  from StagePersonLink s  "
                                                           + " where s.stage.idStage = :idStage  "
                                                           + "   and s.person.nmPersonFull = :nmPersonFull "
                                                           + "  order by s.idStagePersonLink asc ");
    query.setInteger("idStage", idStage);
    query.setString("nmPersonFull", nmPersonFull);
    return (Person) firstResult(query);
  }
  
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findIdPersonsByPersonAdopted(Collection<Integer> idPersons) {
    Query query = getSession().createQuery("select distinct spl.person.idPerson "
                                                           + "           from StagePersonLink spl "
                                                           + "          where spl.person.idPerson in (:idPersons) "
                                                           + "            and spl.stage.cdStage = :cdStage "
                                                           + "            and spl.stage.indStageClose = :indStageClose "
                                                           + "            and (spl.stage.cdStageReasonClosed = :cdStageReasonClosed1 "
                                                           + "                 or spl.stage.cdStageReasonClosed = :cdStageReasonClosed2) "
                                                           + "            and spl.cdStagePersRole = :cdStagePersRole ");
    query.setString("cdStage", CodesTables.CSTAGES_ADO);
    query.setString("indStageClose", ArchitectureConstants.Y);
    query.setString("cdStageReasonClosed1", CodesTables.CCLOSADO_ADF);
    query.setString("cdStageReasonClosed2", CodesTables.CCLOSADO_010);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    query.setParameterList("idPersons", idPersons);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findIdStageByIdPerson(Collection<Integer> idPersons) {
    Query query = getSession().createQuery("select distinct spl.stage.idStage " + "  from StagePersonLink spl, "
                                                           + "       Stage s "
                                                           + " where spl.person.idPerson in (:idPersons) "
                                                           + "   and spl.stage.idStage = s.idStage "
                                                           + "   and s.cdStage = '" + CodesTables.CSTAGES_INT + "' ");
    query.setParameterList("idPersons", idPersons);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findIdStageByIdPersonStagePersType(Collection<Integer> idPersons, String cdStagePersType) {
    Query query = getSession().createQuery("select distinct spl.stage.idStage " + "  from StagePersonLink spl, "
                                                           + "       Stage s "
                                                           + " where spl.person.idPerson in (:idPersons) "
                                                           + "   and spl.stage.idStage = s.idStage "
                                                           + "   and s.cdStage = '" + CodesTables.CSTAGES_INT + "' "
                                                           + "   and spl.cdStagePersType = :cdStagePersType");
    query.setParameterList("idPersons", idPersons);
    query.setString("cdStagePersType", cdStagePersType);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Object[]> findPersonsNotAbsconded(int idStage) {
    SQLQuery query = getSession().createSQLQuery("SELECT spl.ID_PERSON, "
                                                                 + "       p.NM_PERSON_FULL, "
                                                                 + "       p.DT_PERSON_BIRTH, "
                                                                 + "       p.NBR_PERSON_ID_NUMBER, "
                                                                 + "       p.CD_PERSON_ETHNIC_GROUP, "
                                                                 + "       eth.CD_ETHNICITY, "
                                                                 + "       p.CD_PERSON_SEX, "
                                                                 + "       p.CD_PERSON_STATUS "
                                                                 + "  FROM STAGE_PERSON_LINK spl "
                                                                 + "    inner join PERSON p "
                                                                 + "      ON p.id_person=spl.ID_PERSON "
                                                                 + "    left join PERSON_ETHNICITY eth "
                                                                 + "      ON (eth.ID_PERSON=spl.ID_PERSON "
                                                                 + "          OR eth.id_person IS NULL) "
                                                                 + " WHERE spl.ID_STAGE=:idStage "
                                                                 + "   AND spl.CD_STAGE_PERS_TYPE<>:stagePersRole "
                                                                 + "   AND spl.ID_PERSON<>ALL (SELECT ppl.ID_PERSON "
                                                                 + "                             FROM PSA_PERSON_LINK ppl, "
                                                                 + "                                  PROTECTIVE_SERVICE_ALERT psa "
                                                                 + "                            WHERE ppl.ID_PROTECTIVE_SERVICE_ALERT=psa.ID_PROTECTIVE_SERVICE_ALERT "
                                                                 + "                              AND psa.ID_STAGE=:idStage "
                                                                 + "                              AND (ppl.DT_DEACTIVATED IS NULL "
                                                                 + "                                   OR ppl.DT_DEACTIVATED='')) "
                                                                 + "   AND (eth.ID_PERSON_ETHNICITY=(SELECT e.id_person_ethnicity "
                                                                 + "                                   FROM PERSON_ETHNICITY e "
                                                                 + "                                  WHERE e.id_person=spl.id_person "
                                                                 + "                                    AND e.dt_last_update=(SELECT MAX(pe.dt_last_update) "
                                                                 + "                                                            FROM PERSON_ETHNICITY pe "
                                                                 + "                                                           WHERE pe.id_person=spl.id_person)) "
                                                                 + "        OR eth.ID_PERSON_ETHNICITY IS NULL)");
    query.setInteger("idStage", idStage);
    query.setString("stagePersRole", CodesTables.CPRSNALL_STF);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findIdPersonAndNmPersonFullFromStagePersonLinkAndPersonByAllegedVictim(int idStage) {
    Query query = getSession().createQuery("select new map(a.person.idPerson as idPerson , "
                                                           + "               a.person.nmPersonFull as nmPersonFull) "
                                                           + "  from StagePersonLink a "
                                                           + " where a.stage.idStage = :idStage "
                                                           + " and a.cdStagePersRole = '" + CodesTables.CROLEALL_VC
                                                           + "' ");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findIdStageByIdPersonStagePersRole(Collection<Integer> idPersons, String cdStagePersRole) {
    Query query = getSession().createQuery("select distinct spl.stage.idStage " + "  from StagePersonLink spl, "
                                                           + "       Stage s "
                                                           + " where spl.person.idPerson in (:idPersons) "
                                                           + "   and spl.stage.idStage = s.idStage "
                                                           + "   and s.cdStage = '" + CodesTables.CSTAGES_INT + "' "
                                                           + "   and spl.cdStagePersRole = :cdStagePersRole");
    query.setParameterList("idPersons", idPersons);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findIdStageByIdPersonByEmployee(Collection<Integer> idPersons) {
    Query query = getSession().createQuery("select distinct spl.stage.idStage " + "  from StagePersonLink spl, "
                                                           + "       Stage s, Employee e "
                                                           + " where spl.person.idPerson in (:idPersons) "
                                                           + "   and spl.stage.idStage = s.idStage "
                                                           + "   and s.cdStage = '" + CodesTables.CSTAGES_INT + "' "
                                                           + "   and e.person.idPerson = spl.person.idPerson ");
    query.setParameterList("idPersons", idPersons);
    // query.setString("indStagePersReporter", "Y");
    return (List<Integer>) query.list();
  }

  public StagePersonLink findStagePersonLinkByIdCaseByIdPersosByCdStage(int idCase, int idPerson, String cdStage) {
    Query query = getSession().createQuery(" from StagePersonLink spl " + "where spl.stage.cdStage = :cdStage "
                                                           + "  and spl.stage.dtStageClose is null "
                                                           + "  and spl.capsCase.idCase = :idCase "
                                                           + "  and spl.person.idPerson = :idPerson ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    return (StagePersonLink) firstResult(query);
  }

  public StagePersonLink findLatestStagePersonLinkByIdCaseByIdPersosByCdStage(int idCase, int idPerson, String cdStage) {
    Query query = getSession().createQuery(" from StagePersonLink spl " + "where spl.stage.cdStage = :cdStage "
                                                           + "  and spl.stage.dtStageClose is null "
                                                           + "  and spl.capsCase.idCase = :idCase "
                                                           + "  and spl.person.idPerson = :idPerson "
                                                           + " order by spl.stage.idStage desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    return (StagePersonLink) firstResult(query);
  }

  public StagePersonLink findStagePersonLinkByIdCaseByIdPersosByCdStage(int idCase, int idPerson, String cdStage,
                                                                        String cdStagePersRole) {
    Query query = getSession().createQuery(" from StagePersonLink spl " + "where spl.stage.cdStage = :cdStage "
                                                           + "  and spl.stage.dtStageClose is null "
                                                           + "  and spl.capsCase.idCase = :idCase "
                                                           + "  and spl.cdStagePersRole = :cdStagePersRole "
                                                           + "  and spl.person.idPerson = :idPerson ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (StagePersonLink) firstResult(query);
  }

  public StagePersonLink findStagePersonLinkClosedByIdCaseByIdPersosByCdStage(int idCase, int idPerson, String cdStage) {
    Query query = getSession().createQuery(" from StagePersonLink spl " + "where spl.stage.cdStage = :cdStage "
                                                           + "  and ( spl.stage.dtStageClose is not null "
                                                           + "        and spl.stage.dtStageClose != :maxDate) "
                                                           + "  and spl.capsCase.idCase = :idCase "
                                                           + "  and spl.cdStagePersRole = :cdStagePersRole "
                                                           + "  and spl.person.idPerson = :idPerson ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (StagePersonLink) firstResult(query);
  }

  public StagePersonLink findStgPersLnkClosedByIdCaseByIdPersByCdStgOrdByIdStg(int idCase, int idPerson, String cdStage) {
    Query query = getSession().createQuery(" from StagePersonLink spl " + "where spl.stage.cdStage = :cdStage "
                                                           + "  and ( spl.stage.dtStageClose is not null "
                                                           + "        and spl.stage.dtStageClose != :maxDate) "
                                                           + "  and spl.capsCase.idCase = :idCase "
                                                           + "  and spl.cdStagePersRole = :cdStagePersRole "
                                                           + "  and spl.person.idPerson = :idPerson "
                                                           + "  order by spl.stage.idStage desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (StagePersonLink) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Person> findStagePersonLinkByIdCaseByIdPersonsByCdStagesByCdPersonRole(int idCase,
                                                                                     Collection<Integer> idPersons,
                                                                                     String cdStagePersRole,
                                                                                     String cdStagePersType) {
    Query query = getSession().createQuery(" select spl.person "
                                                           + " from StagePersonLink spl "
                                                           + " where spl.person.idPerson in (:idPersons) "
                                                           + " and spl.capsCase.idCase = :idCase "
                                                           + " and spl.stage.cdStage = :cdStageSUB "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and spl.cdStagePersType = :cdStagePersType "
                                                           + " and spl.stage.dtStageClose is null "
                                                           + " and ( not exists (select spl1.stage.idStage "
                                                           + "                   from StagePersonLink spl1 "
                                                           + "                   where spl1.stage.cdStage = :cdStageADO "
                                                           + "                   and spl1.capsCase.idCase = spl.capsCase.idCase "
                                                           + "                   and spl1.person.idPerson = spl.person.idPerson) "
                                                           + "      or exists ( select spl1.stage.idStage "
                                                           + "                   from StagePersonLink spl1 "
                                                           + "                   where spl1.stage.cdStage = :cdStageADO "
                                                           + "                   and spl1.capsCase.idCase = spl.capsCase.idCase "
                                                           + "                   and spl1.person.idPerson = spl.person.idPerson)) "
                                                           + " order by spl.person.nmPersonLast, spl.person.nmPersonFirst ");

    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setParameterList("idPersons", idPersons, Hibernate.INTEGER);
    query.setString("cdStageSUB", "SUB");
    query.setString("cdStageADO", "ADO");
    return (List<Person>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Person> findStagePersonLinkByIdCaseByCdStageByCdPersonRole(int idCase, String cdStage,
                                                                         String cdStagePersRole, String cdStagePersType) {

    Query query = getSession().createQuery(" select spl.person " + " from StagePersonLink spl "
                                                           + " where spl.capsCase.idCase = :idCase "
                                                           + " and spl.stage.cdStage = :cdStage "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and spl.cdStagePersType = :cdStagePersType "
                                                           + " and spl.stage.dtStageClose is not null ");
    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    return (List<Person>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findIdPersonByIdStageAndCdStagePersRoleAsSE(int idStage) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "  from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersRole = 'SE'");
    query.setInteger("idStage", idStage);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findILCByIdStage(int idStage) {
    Query query = getSession().createQuery("select spl.person.idPerson "
                                                           + "  from StagePersonLink spl, employee e, empJobHistory ejh "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersRole in ('PR', 'SE')"
                                                           + " and spl.person.idPerson = e.person.idPerson"
                                                           + " and e.empJobHistory.idEmpJobHistory = ejh.idEmpJobHistory"
                                                           + " and ejh.cdJobTitle = 'G1007'"
                                                           + " and ejh.dtJobEnd = :maxJavaDate");
    query.setInteger("idStage", idStage);
    query.setDate("maxJavaDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Person> findStagePersonLinkClosedByIdCaseByCdPersonRoleByDiffCdStages(int idCase, String cdStage,
                                                                                    String cdStage1,
                                                                                    String cdStagePersRole,
                                                                                    String cdStagePersType) {

    Query query = getSession().createQuery(" select spl.person "
                                                           + " from StagePersonLink spl "
                                                           + " where spl.capsCase.idCase = :idCase "
                                                           + " and spl.stage.cdStage = :cdStage "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and spl.cdStagePersType = :cdStagePersType "
                                                           + " and spl.stage.dtStageClose is not null "
                                                           + " and spl.person.idPerson not in (select spl1.person.idPerson "
                                                           + "                from StagePersonLink spl1 "
                                                           + "                where spl1.capsCase.idCase = spl.capsCase.idCase "
                                                           + "                and spl1.stage.cdStage = :cdStage1 "
                                                           + "                and spl1.cdStagePersType = spl.cdStagePersType )");
    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    query.setString("cdStage1", cdStage1);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    return (List<Person>) query.list();
  }

  public StagePersonLink findStagePersonLinkByIdStageByCdStagePersRelInt(int idStage, String cdStagePersRelInt,
                                                                         String cdStagePersType) {
    Query query = getSession().createQuery(" from StagePersonLink " + "where stage.idStage = :idStage "
                                                           + "  and cdStagePersRelInt = :cdStagePersRelInt "
                                                           + "  and cdStagePersType = :cdStagePersType");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("cdStagePersType", cdStagePersType);
    return (StagePersonLink) firstResult(query);
  }

  public StagePersonLink findStagePersonLinkByIdStageByCdStagePersRelIntOnly(int idStage, String cdStagePersRelInt) {
    Query query = getSession().createQuery(" from StagePersonLink " + "where stage.idStage = :idStage "
                                                           + "  and cdStagePersRelInt = :cdStagePersRelInt ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    return (StagePersonLink) firstResult(query);
  }

  // STGAP00017013: MR-095
  public Person findStagePersonLinkByIdStageByCdStagePersRelInt(int idStage, String cdStagePersRelInt) {
    Query query = getSession().createQuery("select p " + " from StagePersonLink spl " + " inner join spl.person as p"
                                           + " where spl.stage.idStage = :idStage "
                                                           + "  and spl.cdStagePersRelInt = :cdStagePersRelInt ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    return (Person) firstResult(query);
  }
  
  public StagePersonLink findStagePersonLinkByIdStageByCdStageByIdPerson(String cdStagePersRole, Date dtStageOpen,
                                                                         int idPerson) {
    String cdStageSUB = CodesTables.CSTAGES_SUB;

    Query query = getSession().createQuery(" select spl " + " from StagePersonLink spl, Stage s2 "
                                                           + " where spl.capsCase.idCase = s2.capsCase.idCase "
                                                           + " and spl.stage.cdStage = :cdStageSUB "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and (spl.stage.dtStageClose = :dtStageOpen "
                                                           + "      or spl.stage.dtStageClose is null) "
                                                           + " and spl.person.idPerson = :idPerson ");
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStageSUB", cdStageSUB);
    query.setTimestamp("dtStageOpen", dtStageOpen);
    query.setInteger("idPerson", idPerson);

    return (StagePersonLink) firstResult(query);
  }

  public Integer findIdPersonByIdStageIdPersonAndCdStagePersRole(int idStage, int idPerson, String cdStagePersRole) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "  from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.person.idPerson = :idPerson "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (Integer) firstResult(query);
  }

  public StagePersonLink findStagePersonLinkByIdCaseByIdPerson(int idCase, int idPerson) {
    Query query = getSession().createQuery(" select spl " + " from StagePersonLink spl  "
                                                           + " where spl.capsCase.idCase = :idCase"
                                                           + " and spl.person.idPerson = :idPerson ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);

    return (StagePersonLink) firstResult(query);
  }

  public StagePersonLink findStagePersonLinkByIdStageByIdPerson(int idStage, int idPerson) {
    Query query = getSession().createQuery(" select spl " + " from StagePersonLink spl  "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.person.idPerson = :idPerson ");

    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);

    return (StagePersonLink) firstResult(query);
  }

  public StagePersonLink findClosedSUBStagePersonLinkByIdStageByCdStageByIdPerson(String cdStagePersRole, int idPerson) {
    Query query = getSession().createQuery(" select spl " + " from StagePersonLink spl, Stage s2 "
                                                           + " where spl.capsCase.idCase = s2.capsCase.idCase "
                                                           + " and spl.stage.cdStage = :cdStageSUB "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and (spl.stage.dtStageClose != :maxDate "
                                                           + "      and spl.stage.dtStageClose is not null) "
                                                           + " and spl.person.idPerson = :idPerson ");
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setInteger("idPerson", idPerson);

    return (StagePersonLink) firstResult(query);
  }

  public Integer findIdStageForVerification(int idCase, String cdStage, int idPerson, String cdStagePersRole) {
    Query query = getSession().createQuery("select spl.stage.idStage " + "  from StagePersonLink spl "
                                                           + " where spl.capsCase.idCase = :idCase "
                                                           + "   and spl.stage.cdStage = :cdStage "
                                                           + "   and spl.person.idPerson = :idPerson "
                                                           + "   and spl.cdStagePersRole = :cdStagePersRole "
                                                           + "   and (   spl.stage.dtStageClose is null "
                                                           + "        or spl.stage.dtStageClose = :maxDate)");
    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Stage> findOpenSUBorADOStagesByFSUidStage(int idStage) {
    String adoStageType = CodesTables.CSTAGES_ADO;
    String subStageType = CodesTables.CSTAGES_SUB;

    Query query = getSession().createQuery(" select distinct s2 " + " from StagePersonLink spl, Stage s2 "
                                                           + " where spl.stage.cdStage = 'FSU' "
                                                           + " and spl.stage.idStage = :idStage "
                                                           + " and spl.capsCase.idCase = s2.capsCase.idCase "
                                                           + " and s2.cdStage in (:adoStageType, :subStageType) "
                                                           + " and s2.dtStageClose is null ");

    query.setString("adoStageType", adoStageType);
    query.setString("subStageType", subStageType);
    query.setInteger("idStage", idStage);

    return (List<Stage>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Map> findCdStageByIdStage(int idStage) {
    Query query = getSession().createQuery("select new map(a.cdStage as cdStage) " + "from " + "StagePersonLink spl "
                                                           + " join spl.stage a " + "where "
                                                           + "spl.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);

    return (List<Map>) query.list();
  }

  // STGAP00010002: Added the next 2 sqls to retrieve data for Special Services Adoption Assistance
  // Agreement form
  public StagePersonLink findStagePersonLinkByIdStageByCdStagePersRole(int idStage, String cdStagePersRole) {
    Query query = getSession().createQuery(" from StagePersonLink " + "where stage.idStage = :idStage "
                                                           + "  and cdStagePersRole = :cdStagePersRole ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (StagePersonLink) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findStagePersonLinkByIdStageByCdStagePersRelInts(int idStage,
                                                                                Collection cdStagePersRelInts) {
    Query query = getSession().createQuery(" from StagePersonLink " + "where stage.idStage = :idStage "
                                                           + "  and cdStagePersRelInt in (:cdStagePersRelInts) ");
    query.setInteger("idStage", idStage);
    query.setParameterList("cdStagePersRelInts", cdStagePersRelInts);
    return (List<StagePersonLink>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findPrimaryChildrenByIdStage(int idStage) {
    Query query = getSession().createQuery("select spl from StagePersonLink spl "
                                                           + " where spl.cdStagePersRole = :cdRole "
                                                           + " and spl.stage.idStage = :idStage");
    query.setString("cdRole", CodesTables.CROLES_PC);
    query.setInteger("idStage", idStage);
    return (List<StagePersonLink>) query.list();
  }

  public StagePersonLink findStagePersonLinkByIdStageByCdStagePersRelIntGender(int idStage,
                                                                               List<String> cdStagePersRelInt,
                                                                               String cdStagePersType, String gender) {
    Query query = getSession().createQuery(" select spl from StagePersonLink spl, Person p "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRelInt in (:cdStagePersRelInt) "
                                                           + " and spl.cdStagePersType = :cdStagePersType "
                                                           + " and p.idPerson = spl.person.idPerson "
                                                           + " and p.cdPersonSex = :gender");
    query.setInteger("idStage", idStage);
    query.setParameterList("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("gender", gender);
    return (StagePersonLink) firstResult(query);
  }

  // STGAP00017013: MR-095
  public Person findPersonByIdStageByCdStagePersRelIntGender(int idStage, String cdStagePersRelInt,
                                                             String cdStagePersType) {
    Query query = getSession().createQuery(
                                           " select p from StagePersonLink spl " + " inner join spl.person as p"
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRelInt = :cdStagePersRelInt "
                                                           + " and spl.cdStagePersType = :cdStagePersType ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("cdStagePersType", cdStagePersType);
    return (Person) firstResult(query);
  }
  
  // STGAP00010006: Gets the person Id of the Biological mother/father or Legal father
  public Integer findIdPersonByIdStageAndCdStagePersRelInt(int idStage, String cdStagePersRelInt) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "  from StagePersonLink spl "
                                                           + " where stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersRelInt = :cdStagePersRelInt");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    return (Integer) firstResult(query);
  }

  // SMS #81140: MR-074 Find the Stage Person Link records under the stage relationship specified
  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findStagePersonLinkByIdStageAndCdStagePersRelInt(int idStage,
                                                                                List<String> cdStagePersRelInt) {
    Query query = getSession().createQuery(" select spl from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRelInt in (:cdStagePersRelInt) ");
    query.setInteger("idStage", idStage);
    query.setParameterList("cdStagePersRelInt", cdStagePersRelInt);
    return (List<StagePersonLink>) query.list();
  }

  public Integer findIdStageByIdPersonCdStage(int idChild) {
    Query query = getSession().createQuery("select stage.idStage " + " from StagePersonLink spl "
                                                           + " where spl.person.idPerson = :idChild "
                                                           + " and spl.cdStagePersRole = :cdRole "
                                                           + " and spl.stage.cdStage = :cdStage "
                                                           + " order by stage.idStage desc");
    query.setInteger("idChild", idChild);
    query.setString("cdRole", CodesTables.CROLES_PC);
    query.setString("cdStage", CodesTables.CSTAGES_PAD);
    return (Integer) firstResult(query);
  }

  public Integer findIdStageByIdPersonCdStageIdCase(int idChild, int idCase, String cdStage) {
    Query query = getSession().createQuery("select spl.stage.idStage " + " from StagePersonLink spl "
                                                           + " where spl.person.idPerson = :idChild "
                                                           + " and spl.cdStagePersRole = :cdRole "
                                                           + " and spl.stage.cdStage = :cdStage "
                                                           + " and spl.capsCase.idCase = :idCase "
                                                           + " order by spl.stage.idStage desc");
    query.setInteger("idChild", idChild);
    query.setString("cdRole", CodesTables.CROLES_PC);
    query.setString("cdStage", cdStage);
    query.setInteger("idCase", idCase);
    return (Integer) firstResult(query);
  }

  public long countSubStageByIdPersonCdStage(int idChild) {
    Query query = getSession().createQuery("select count(*) " + " from StagePersonLink spl "
                                                           + " where spl.person.idPerson = :idChild "
                                                           + " and spl.cdStagePersRole = :cdRole "
                                                           + " and spl.stage.cdStage = :cdStage "
                                                           + " order by stage.idStage desc");
    query.setInteger("idChild", idChild);
    query.setString("cdRole", CodesTables.CROLES_PC);
    query.setString("cdStage", CodesTables.CSTAGES_SUB);
    return (Long) query.uniqueResult();
  }

  // STGAP00010006: Gets the full name of the primary child
  public Person findNmPersonByIdStageByCdStagePersRole(int idStage, String cdStagePersRole) {

    Query query = getSession().createQuery("select p " + " from StagePersonLink spl" + " inner join spl.person as p"
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (Person) firstResult(query);
  }

  // mxpatel wrote this method for defect #9851
  public String findPersonRoleByIdPerson(int idPerson, int idStage) {

    Query query = getSession().createSQLQuery("select distinct spl.CD_STAGE_PERS_ROLE "
                                                              + " from Stage_Person_Link spl, Event e "
                                                              + " where spl.id_stage = e.id_event_stage "
                                                              + " and spl.id_Person = :idPerson "
                                                              + " and spl.id_stage = :idStage");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (String) query.uniqueResult();
  }

  // STGAP00010006: Gets the person id list of all the adults marked as Principal in the given stage
  @SuppressWarnings({ "unchecked" })
  public List<Object> findPrincipalAdultsByStage(int idStage, Collection<String> relationship) {
    Query query = getSession().createQuery("select spl.person.idPerson "
                                                           + " from StagePersonLink spl, Person p "
                                                           + " where spl.person.idPerson = p.idPerson "
                                                           + " and spl.stage.idStage = :idStage  "
                                                           + " and spl.cdStagePersRelInt in (:relationship) "
                                                           + " and (months_between (sysdate, p.dtPersonBirth)/12) >= 18 ");
    query.setInteger("idStage", idStage);
    query.setParameterList("relationship", relationship);
    return (List<Object>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findCdPersonSexByCdStagePersRelInt(int idStage, String cdStagePersRelInt) {
    Query query = getSession().createQuery("select spl " + " from StagePersonLink spl " + " join fetch spl.person "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRelInt = :cdStagePersRelInt");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    return (List<StagePersonLink>) query.list();
  }

  /**
   * Find fcc stages with the specified case id
   * 
   * @param idCase
   * @return List<Integer>
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findFccIdPersonByIdCase(int idCase) {
    Query query = getSession().createQuery(" select spl.person.idPerson " + "	from Stage s, StagePersonLink spl where "
                                                           + "s.capsCase.idCase = :idCase and "
                                                           + "spl.stage.idStage = s.idStage and "
                                                           + "spl.cdStagePersRole = :cdStagePersRole and "
                                                           + "s.cdStage = :cdStage and " + "s.dtStageClose is null"

    );
    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", CodesTables.CROLES_PC);
    query.setString("cdStage", CodesTables.CTXGASTG_SUB);

    return (List<Integer>) query.list();
  }

  /**
   * Find all (open or closed) ado and fcc stage primary child ids with the specified case id
   * 
   * @param idCase
   * @return List<Integer>
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findAllPrimaryChildIdsForAdoStagesByIdCase(int idCase) {
    Query query = getSession().createQuery(" select distinct (spl.person.idPerson) "
                                                           + "	from Stage s, StagePersonLink spl where "
                                                           + "s.capsCase.idCase = :idCase and "
                                                           + "spl.stage.idStage = s.idStage and "
                                                           + "spl.cdStagePersRole = :cdStagePersRole "
                                                           + "and s.cdStage = :cdStage");
    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", CodesTables.CROLES_PC);
    query.setString("cdStage", CodesTables.CTXGASTG_ADO);

    return (List<Integer>) query.list();
  }

  // STGAP00010749:Inserts a new stage person link record
  // STGAP00012065:Marks the IND_STAGE_PERS_EMP_NEW as new so the new
  // assignment will show up as a new assignment
  public int insertNewStagePersonLink(int idStage, int idPerson, int idCase, String cdStagePersRole,
                                      String cdStagePersType, Date dtStagePersLink) {
    getSession().flush();
    SQLQuery query = getSession().createSQLQuery("INSERT INTO STAGE_PERSON_LINK (ID_STAGE, "
                                                                 + "                               ID_PERSON, "
                                                                 + "                               ID_CASE, "
                                                                 + "                               ID_STAGE_PERSON_LINK, "
                                                                 + "                               CD_STAGE_PERS_ROLE, "
                                                                 + "                               DT_STAGE_PERS_LINK, "
                                                                 + "                               CD_STAGE_PERS_TYPE,"
                                                                 + "                               IND_STAGE_PERS_EMP_NEW) "
                                                                 + "                        VALUES(:idStage, "
                                                                 + "                               :idPerson, "
                                                                 + "                               :idCase, "
                                                                 + "                               SEQ_STAGE_PERSON_LINK.NEXTVAL, "
                                                                 + "                               :cdStagePersRole, "
                                                                 + "                               :dtStagePersLink, "
                                                                 + "                               :cdStagePersType, "
                                                                 + "                               :indStagePersEmpNew)");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setDate("dtStagePersLink", dtStagePersLink);
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("indStagePersEmpNew", "1");
    return query.executeUpdate();
  }

  @SuppressWarnings({ "unchecked" })
  public List<String> listMaritalStatusByCdStagePersRelInt(int idStage, String cdStagePersRelInt) {
    Query query = getSession().createQuery("select p.cdPersonMaritalStatus from StagePersonLink spl join spl.person p"
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRelInt = :cdStagePersRelInt "
                                                           + " and spl.cdStagePersType = '" + CodesTables.CPRSNTYP_PRN
                                                           + "'");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    return (List<String>) query.list();
  }

  // Gets the id of the primary child and age in months
  @SuppressWarnings("unchecked")
  public Map findIdChildNmStageByIdStage(int idStage) {
    Query query = getSession().createQuery("select new map(spl.person.idPerson as idPerson, "
                                                           + " spl.stage.nmStage as nmStage, "
                                                           + " spl.person.nmPersonFull as nmPersonFull, "
                                                           + " MONTHS_BETWEEN(SYSDATE, spl.person.dtPersonBirth) as ageInMonths) "
                                                           + " from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRole = :cdRole ");
    query.setInteger("idStage", idStage);
    query.setString("cdRole", CodesTables.CROLES_PC);
    return (Map) firstResult(query);
  }

  // STGAP00012734: Gets the List of open stages for the person as primary caretaker
  @SuppressWarnings("unchecked")
  public List<Integer> findIdStageByIdPersonCdStagePersRelInt(int idPerson) {
    Query query = getSession().createQuery("select spl.stage.idStage " + "from StagePersonLink spl "
                                                           + "where spl.person.idPerson = :idPerson "
                                                           + "and spl.cdStagePersRelInt in ('PK') "
                                                           + "and spl.stage.indStageClose = 'N' ");

    query.setInteger("idPerson", idPerson);
    return (List<Integer>) query.list();
  }

  // STGAP00012833: Gets the last primary case manager assigned to the case for that stage
  public Integer findIdCaseWorkerByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "  from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " order by spl.dtLastUpdate desc");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings("unchecked")
  public List<Integer> findIdCaseWorkersByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "  from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " order by spl.dtLastUpdate desc");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (List<Integer>) query.list();
  }

  // STGAP00014329: This method returns the member of the Primary Caretakers house hold who are under the age of 18
  @SuppressWarnings({ "unchecked" })
  public List<Map> findMemberPKHouseHoldFromStagePersonLinkAndPersonDtl(int idStage) {
    Query query = getSession().createQuery(" select new map (a.nmPersonFull as NM_PERSON_FULL, "
                                                           + " a.idPerson as ID_PERSON, "
                                                           + " c.cdStagePersType as CD_STAGE_PERS_TYPE, "
                                                           + " c.cdStagePersRelInt as CD_STAGE_PERS_REL_INT, "
                                                           + " c.cdStagePersRole as CD_STAGE_PERS_ROLE) "
                                                           + " from StagePersonLink c, Person a "
                                                           + " where c.person.idPerson = a.idPerson"
                                                           + "     and c.stage.idStage = :idStage "
                                                           + "     and months_between(sysdate,a.dtPersonBirth) < 216 "
                                                           + "     and c.cdPKHshdMember = :cdPKHshdMember");

    query.setInteger("idStage", idStage);
    query.setString("cdPKHshdMember", ArchitectureConstants.Y);
    return (List<Map>) query.list();
  }

  // STGAP00014329: This method returns the list of persons who has the safety resource checkbox checked on the person
  // detail page.
  @SuppressWarnings({ "unchecked" })
  public List<Map> findPersonSafetyResCheckedFromStagePersonLink(int idStage) {
    Query query = getSession().createQuery("select new map(a.person.idPerson as idPerson , "
                                                           + "               a.person.nmPersonFull as nmPersonFull) "
                                                           + " from StagePersonLink a "
                                                           + " where a.stage.idStage = :idStage "
                                                           + "     and a.indStagePersSftyResource = :indStagePersSftyResource");

    query.setInteger("idStage", idStage);
    query.setString("indStagePersSftyResource", ArchitectureConstants.Y);
    return (List<Map>) query.list();
  }

  /**
   * STGAP00014336: Get the father or mother of the child in ADO stage STGAP00015351: Removed the stage condition
   * 
   * @param idStage
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Integer> findIdPersonParentByIdStage(int idStage, Collection<String> relationType, String gender) {
    Query query = getSession().createQuery("select spl.person.idPerson " + "from StagePersonLink spl "
                                                           + "where spl.stage.idStage = :idStage "
                                                           + "and spl.cdStagePersRelInt in (:relationType) "
                                                           + "and spl.person.cdPersonSex  = :gender "
                                                           + "and spl.stage.indStageClose = 'N' ");

    query.setInteger("idStage", idStage);
    query.setParameterList("relationType", relationType);
    query.setString("gender", gender);
    return (List<Integer>) query.list();
  }

  // STGAP00014341: Return the person for idStage and HP role
  public StagePersonLink findIdPersonByIdStageCdStagePersRole(int idStage) {
    Query query = getSession().createQuery(" from StagePersonLink s " + "where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersRole =  '" + CodesTables.CROLEALL_HP
                                                           + "'");
    query.setInteger("idStage", idStage);
    return (StagePersonLink) firstResult(query);
  }

  // STGAP00014341: delete stage person link for id staff person and id stage
  public int deleteStagePersonLinkByIdPersonIdStage(int idPerson, int idStage) {
    Query query = getSession().createQuery("delete from StagePersonLink spl " + " where spl.cdStagePersType = 'STF' "
                                                           + " and spl.person.idPerson = :idPerson "
                                                           + " and spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_HP);
    return query.executeUpdate();
  }

  // STGAP00014598 : Gets the latest primary case manager or Historical Case Manager assigned to the stage
  public Integer findIdCaseWorkerByIdStageAndCdStagePersRole(int idStage) {
    Query query = getSession().createQuery("select max(spl.person.idPerson) " + " from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRole in ('PR','HP') ");
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings({ "unchecked" })
  public List<Person> findPersonsByIdCaseByIdPersonsByCdPersonRoleByCdStagePersTypeByCdADOStage(int idCase,
                                                                                                Collection<Integer> idPersons,
                                                                                                String cdStagePersRole,
                                                                                                String cdStagePersType) {
    Query query = getSession().createQuery(" select spl.person "
                                                           + " from StagePersonLink spl "
                                                           + " where spl.person.idPerson in (:idPersons) "
                                                           + " and spl.capsCase.idCase = :idCase "
                                                           + " and spl.stage.cdStage = :cdStageADO "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and spl.cdStagePersType = :cdStagePersType "
                                                           + " and spl.stage.dtStageClose is null "
                                                           + " order by spl.person.nmPersonLast, spl.person.nmPersonFirst ");

    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("cdStagePersType", cdStagePersType);
    query.setParameterList("idPersons", idPersons, Hibernate.INTEGER);
    query.setString("cdStageADO", "ADO");
    return (List<Person>) query.list();
  }

  /**
   * STGAP00015485: This method finds the fathers and mothers of the child.
   * 
   * @param idStage
   * @param cdPersonSex
   * @return
   */
  @SuppressWarnings({ "unchecked" })
  public List<Map<String, Object>> findFathersMothersByIdStageByCdPersonSex(int idStage, String cdPersonSex) {
    Query query = getSession().createQuery("select new map(spl.person.idPerson as idPerson, "
                                                           + "               p.nmPersonFull as nmPersonFull, "
                                                           + "               spl.cdStagePersRelInt as cdStagePersRelInt) "
                                                           + "  from StagePersonLink spl, " + "       Person p "
                                                           + " where spl.person.idPerson = p.idPerson "
                                                           + "   and spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersType = '"
                                                           + CodesTables.CPRSNTYP_PRN + "'"
                                                           + "  and p.cdPersonSex = :cdPersonSex ");
    query.setInteger("idStage", idStage);
    query.setString("cdPersonSex", cdPersonSex);
    return (List<Map<String, Object>>) query.list();
  }

  /**
   * STGAP00015485: This method finds the secondary care givers of the child.
   * 
   * @param idStage
   * @return
   */
  @SuppressWarnings({ "unchecked" })
  public List<Map<String, Object>> findSecondaryCaregiverByIdStage(int idStage) {
    Query query = getSession().createQuery("select new map(spl.person.idPerson as idPerson, "
                                                           + "               p.nmPersonFull as nmPersonFull, "
                                                           + "                   spl.cdStagePersRelInt as  cdStagePersRelInt) "
                                                           + "  from StagePersonLink spl, " + "       Person p "
                                                           + " where spl.person.idPerson = p.idPerson "
                                                           + "   and spl.stage.idStage = :idStage "
                                                           + "   and spl.cdStagePersType = '"
                                                           + CodesTables.CPRSNTYP_PRN + "'");
    query.setInteger("idStage", idStage);
    return (List<Map<String, Object>>) query.list();
  }

  /**
   * STGAP00015485 Added this method to update cdPKHouseholdMember when mulitple persons are selected on Intake info and
   * Detail button is pushed
   * 
   * @param cdPKHouseholdMember
   * @param idPerson
   * @param idStage
   * @return
   */
  public int updateStagePersonLinkCdPKHouseholdMember(String cdPKHouseholdMember, int idPerson, int idStage) {
    Query query = getSession().createQuery("update StagePersonLink spl "
                                                           + "   set spl.cdPKHshdMember = :cdPKHouseholdMember "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + "   and spl.stage.idStage = :idStage");
    query.setString("cdPKHouseholdMember", cdPKHouseholdMember);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  /**
   * MR-057 This method returns the Foster Parents for the FAD stage
   * 
   * @param idStage
   * @return List<Map>
   */
  @SuppressWarnings({ "unchecked" })
  public List<Map> findIdPersonAndNmPersonFullFosterParentsFromStagePersonLinkAndPerson(int idStage) {
    Query query = getSession().createQuery("select new map(a.person.idPerson as idPerson , "
                                                           + "               a.person.nmPersonFull as nmPersonFull) "
                                                           + "  from StagePersonLink a "
                                                           + " where a.stage.idStage = :idStage "
                                                           + "   and a.cdStagePersRelInt in ('FP','AF','FA') "
                                                           + "   and a.cdStagePersRole != 'PC' "
                                                           + "   and months_between(sysdate,nvl(a.person.dtPersonBirth,sysdate)) >= 216");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  public Person findStagePersonLinkWithAssignedIPL(int idStage) {
    // 'G1007','14203ILP', '14201ILP' - ILP Codes
    Query query = getSession().createQuery(" select p from StagePersonLink spl, Employee e, Person p "
                                                           + " where spl.person.idPerson = e.person.idPerson "
                                                           + " and e.person.idPerson = p.idPerson "
                                                           + " and spl.cdStagePersType = 'STF' "
                                                           + " and e.cdEmployeeClass in ('G1007','14203ILP', '14201ILP') "
                                                           + " and spl.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (Person) firstResult(query);
  }

  /**
   * SMS#45718 This method gets all the children for ONG MR-064 Changed the method name and query to pre-populate
   * children under the age of 18 that are members of the primary caretaker's household. for FPR.
   * 
   * @param idStage
   * @return
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findAllChildrenFPRStagesByIdStage(int idStage) {
    Query query = getSession().createQuery("select spl.person.idPerson as idPerson  "
                                                           + "  from StagePersonLink spl, "
                                                           + "  Person p "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.stage.cdStage in (:cdStageFPR) "
                                                           + " and spl.person.idPerson = p.idPerson "
                                                           + " and add_months(p.dtPersonBirth, 216) >= add_months(to_date(to_char(sysdate, 'MM/YYYY'),'MM/YYYY'),2) "
                                                           + " and spl.cdStagePersType = '"
                                                           + CodesTables.CPRSNTYP_PRN
                                                           + "'"
                                                           + " and spl.cdPKHshdMember = :cdPKHshdMember "
                                                           + " and (p.dtPersonDeath is null or p.dtPersonDeath = :maxDate) ");
    query.setInteger("idStage", idStage);
    query.setString("cdStageFPR", CodesTables.CSTAGES_FPR);
    query.setString("cdPKHshdMember", ArchitectureConstants.Y);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();
  }

  /**
   * SMS#45718 This method gets all the children for FCF
   * 
   * @param idCase
   * @return
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findAllChildrenFCCStagesByIdCase(int idCase) {
    Query query = getSession().createQuery("select distinct spl.person.idPerson as idPerson  "
                                                           + "  from StagePersonLink spl, "
                                                           + "  Person p "
                                                           + " where spl.capsCase.idCase = :idCase "
                                                           + " and spl.stage.cdStage in (:cdStageSUB) "
                                                           + " and spl.person.idPerson = p.idPerson "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and spl.stage.dtStageClose is null "
                                                           + " and (p.dtPersonDeath is null or p.dtPersonDeath = :maxDate) ");
    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();
  }

  /**
   * STGAP00017013: MR-095 This method gets all the children for FCC
   * 
   * @param idCase
   * @return
   */
  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findAllChildrenFCCStagesByIdCaseByStage(int idCase, int idStage) {
    Query query = getSession().createQuery("select spl2  "
                                                           + "  from StagePersonLink spl, "
                                                           + "  StagePersonLink spl2, "
                                                           + "  Person p "
                                                           + " where spl.capsCase.idCase = :idCase "
                                                           + " and spl.stage.cdStage = :cdStageSUB "
                                                           + " and spl.person.idPerson = p.idPerson "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole "
                                                           + " and spl.stage.dtStageClose is null "
                                                           + " and spl2.capsCase.idCase = :idCase "
                                                           + " and spl2.stage.idStage = :idStage "
                                                           + " and spl2.person.idPerson = spl.person.idPerson "
                                                           + " and (p.dtPersonDeath is null or p.dtPersonDeath = :maxDate) ");
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<StagePersonLink>) query.list();
  }
  
  /**
   * SMS#45718 MR-62 This method returns the All the persons for the stage other than children in FCC stages
   * 
   * @param idCase
   * @return List<Map>
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findAllPersonFCCByIdCase(int idCase) {
    Query query = getSession().createQuery("select distinct spl.person.idPerson as idPerson  "
                                                           + "  from StagePersonLink spl "
                                                           + " where spl.capsCase.idCase = :idCase "
                                                           + " and spl.stage.cdStage in (:cdStageSUB) "
                                                           + " and spl.stage.dtStageClose is null "
                                                           + " and spl.cdStagePersType = '" + CodesTables.CPRSNTYP_PRN
                                                           + "'");
    query.setInteger("idCase", idCase);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    return (List<Integer>) query.list();
  }

  /**
   * SMS#45718 MR-62 This method returns the All the persons for the stage other than children in FPR
   * 
   * @param idStage
   * @return List<Map>
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findAllPersonFPRByIdStage(int idStage) {
    Query query = getSession().createQuery("select distinct spl.person.idPerson as idPerson  "
                                                           + "  from StagePersonLink spl "
                                                           + " where spl.stage.idStage = :idStage "
                                                           + " and spl.stage.cdStage in (:cdStageFPR) "
                                                           + " and spl.cdStagePersType = '" + CodesTables.CPRSNTYP_PRN
                                                           + "'");
    query.setInteger("idStage", idStage);
    query.setString("cdStageFPR", CodesTables.CSTAGES_FPR);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Integer> findPrincipalPersonsUnderThreeByIdStage(int idStage) {
    Query query = getSession().createQuery("select distinct s.person.idPerson as idPerson "
                                                           + "  from StagePersonLink s join s.person p "
                                                           + " where s.stage.idStage = :idStage "
                                                           + "   and s.cdStagePersType = :principal "
                                                           + " and months_between(sysdate,p.dtPersonBirth) < 36 "
                                                           + " and (p.dtPersonDeath is null or p.dtPersonDeath = :dtMaxDate) ");
    query.setInteger("idStage", idStage);
    query.setString("principal", "PRN");
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<Object[]> findIdStageIdCaseManagerByIdPersonCdStage(int idPerson, Set<String> cdStages) {
    SQLQuery query = getSession().createSQLQuery("select spl.id_stage as idStage, "
                                                                 + " spl.id_person as idCaseManager"
                                                                 + " from stage_person_link spl, stage s"
                                                                 + " where spl.id_stage = s.id_stage"
                                                                 + " and spl.cd_stage_pers_role in ( 'PR', 'HP')"
                                                                 + " and s.cd_stage in (:cdStages)"
                                                                 + " and spl.id_stage in ("
                                                                 + "                      select spl2.id_stage"
                                                                 + "                      from stage_person_link spl2"
                                                                 + "                      where spl2.id_person = :idPerson)");
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("idCaseManager", Hibernate.INTEGER);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdStages", cdStages);
    return (List<Object[]>) query.list();
  }

  /**
   * MR-066 Get the case managers of the children placed in a Resource
   * 
   * @param idRsrcFacil
   * @return
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findStagePersonLinkByIdResource(int idRsrcFacil) {
    Query query = getSession().createQuery("select  c.person.idPerson "
                                                           + "  from Placement a, "
                                                           + "       Person b, "
                                                           + "       Event e, "
                                                           + "       StagePersonLink c "
                                                           + " where a.capsResourceByIdRsrcFacil.idResource = :idRsrcFacil "
                                                           + "   and trunc(a.dtPlcmtStart) <= :dtRshsEnd "
                                                           + "   and trunc(a.dtPlcmtEnd) >= :dtRshsEffective "
                                                           + "   and a.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and b.idPerson = a.personByIdPlcmtChild.idPerson "
                                                           + "   and e.idEvent = a.idPlcmtEvent "
                                                           + "   and e.stage.idStage = c.stage.idStage "
                                                           + "   and (c.cdStagePersRole = :persRolePR "
                                                           + "         or c.cdStagePersRole = :persRoleHP) ");
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setTimestamp("dtRshsEnd", DateHelper.MAX_JAVA_DATE);
    query.setTimestamp("dtRshsEffective", DateHelper.MAX_JAVA_DATE);
    query.setString("cdPlcmtActPlanned", "A");
    query.setString("persRolePR", CodesTables.CROLEALL_PR);
    query.setString("persRoleHP", CodesTables.CROLEALL_HP);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({ "unchecked" })
  public List<BigDecimal> findPrincipalByStageIdWithDODAndAgeLT18(int idStage) {
    SQLQuery query = getSession().createSQLQuery("SELECT p.ID_PERSON "
                                                                 + "  FROM PERSON_ENC p "
                                                                 + "  WHERE p.ID_PERSON IN "
                                                                 + "  (SELECT spl.ID_PERSON FROM STAGE_PERSON_LINK spl"
                                                                 + "                     WHERE spl.ID_STAGE = :idStage AND spl.CD_STAGE_PERS_TYPE = '"
                                                                 + CodesTables.CPRSNTYP_PRN
                                                                 + "' )"
                                                                 + " AND p.NBR_PERSON_AGE < 18 AND p.DT_PERSON_DEATH IS NOT NULL");
    query.setInteger("idStage", idStage);
    return (List<BigDecimal>) query.list();
  }

  /**
   * MR-041 Get the Primary child for ADO stage
   * 
   * @param idStage
   * @return
   */
  public Integer findIdPersonForChildByIdADOStage(int idStage) {
    Query query = getSession().createQuery("select distinct spl.person.idPerson " + "from " + "StagePersonLink spl "
                                                           + "where " + "spl.stage.idStage = :idStage AND "
                                                           + "spl.cdStagePersRole = 'PC'"
                                                           + " and spl.stage.cdStage = 'ADO' ");
    query.setInteger("idStage", idStage);

    return (Integer) firstResult(query);
  }

  /**
   * MR-072 Gets the persons who are PRN or Member of PK household who are under the age of 17
   * 
   * @param idStage
   * @return
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findPersonsPRNOrMemberPKHshldByIdStageUnder17(int idStage) {
    Query query = getSession().createQuery(" select a.idPerson " + " from StagePersonLink c, Person a "
                                                           + " where c.person.idPerson = a.idPerson"
                                                           + "     and c.stage.idStage = :idStage "
                                                           + "     and months_between(sysdate,a.dtPersonBirth) < 204 "
                                                           + "     and (c.cdStagePersType = '"
                                                           + CodesTables.CPRSNTYP_PRN + "' "
                                                           + "     or c.cdPKHshdMember = :cdPKHshdMember )");

    query.setInteger("idStage", idStage);
    query.setString("cdPKHshdMember", ArchitectureConstants.Y);
    return (List<Integer>) query.list();
  }

  /**
   * MR-072 Gets the persons who are PRN or Member of PK household who are over the age of 17
   * 
   * @param idStage
   * @return
   */
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findPersonsPRNOrMemberPKHshldByIdStageOver17(int idStage) {
    Query query = getSession().createQuery(" select a.idPerson "
                                                           + " from StagePersonLink c, Person a "
                                                           + " where c.person.idPerson = a.idPerson"
                                                           + "     and c.stage.idStage = :idStage "
                                                           + "     and (months_between(sysdate,a.dtPersonBirth) >= 204 or a.dtPersonBirth is null )"
                                                           + "     and (c.cdStagePersType = '"
                                                           + CodesTables.CPRSNTYP_PRN + "' "
                                                           + "     or c.cdPKHshdMember = :cdPKHshdMember )");

    query.setInteger("idStage", idStage);
    query.setString("cdPKHshdMember", ArchitectureConstants.Y);
    return (List<Integer>) query.list();
  }

  /**
   * MR-072 Find how many hours it's been since the person is added or related to the stage
   * 
   * @param idPerson
   * @return
   */
  public Double findHoursBetweenDtPersonAddedAndTodaysDate(int idPerson) {
    Query query = getSession().createQuery(" select floor(((sysdate-c.dtPersonAddedOrRelated)*24*60*60)/3600) "
                                                           + " from StagePersonLink c "
                                                           + " where c.person.idPerson = :idPerson "
                                                           + " and floor(((sysdate-c.dtPersonAddedOrRelated)*24*60*60)/3600) is not null ");
    query.setInteger("idPerson", idPerson);
    return (Double) firstResult(query);
  }

  /**
   * MR-072 Find how many hours it's been since the person is stage progressed
   * 
   * @param idPerson
   * @return
   */
  public Double findHoursBetweenPersonDtStageProgressedAndTodaysDate(int idPerson) {
    Query query = getSession().createQuery(" select floor(((sysdate-c.dtStagePersLink)*24*60*60)/3600) "
                                                           + " from StagePersonLink c "
                                                           + " where c.person.idPerson = :idPerson "
                                                           + " and floor(((sysdate-c.dtStagePersLink)*24*60*60)/3600) is not null");
    query.setInteger("idPerson", idPerson);
    return (Double) firstResult(query);
  }

  /*
   * MR-067 Find number stage person link for open stages that exist for person
   * 
   * @param idPerson
   * 
   * @param cdStagePersRoles
   * 
   * @param cdStageTypeList
   * 
   * @return long
   */
  public long countOpenStagesByIdPersonAndPersRolesAndCdStages(int idPerson, Collection cdStagePersRoles,
                                                               Collection cdStageTypeList) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink L, " + "       Stage S "
                                                           + " where L.person.idPerson = :idPerson "
                                                           + "   and L.cdStagePersRole IN ( :cdStagePersRoles ) "
                                                           + "   and S.idStage = L.stage.idStage "
                                                           + "   and (S.dtStageClose is null "
                                                           + " or S.dtStageClose = :maxDate) "
                                                           + "   and S.cdStage in (:cdStageTypeList) ");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdStagePersRoles", cdStagePersRoles);
    query.setParameterList("cdStageTypeList", cdStageTypeList);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  /*
   * MR-067 Find number of stage person links for open stages that exists for person
   * 
   * @param idPerson
   * 
   * @return long
   */
  public long countStagePersonLinkForOpenStagesByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink L, Stage S "
                                                           + " where L.person.idPerson = :idPerson "
                                                           + "   and S.idStage = L.stage.idStage "
                                                           + "   and (S.dtStageClose is null "
                                                           + " or S.dtStageClose = :maxDate) ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  public long countStagePersonLinkByIdStageCdStagePersRelInt(int idStage, String cdStagePersRelInt) {
    Query query = getSession().createQuery("select count(*) " + "  from StagePersonLink s "
                                                           + " where s.cdStagePersRelInt = :cdStagePersRelInt "
                                                           + "   and s.stage.idStage = :idStage ");
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  // STGAP00017013: MR-095
  @SuppressWarnings({ "unchecked" })
  public long countStagePersonLinkByIdStageCdStagePersTypeCdStagePersRelIntCdPersonSex(int idStage,
                                                                                       String cdStagePersType,
                                                                                       String cdStagePersRelInt,
                                                                                       String cdPersonSex) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from StagePersonLink s "
                                                           + " where s.cdStagePersType = :cdStagePersType "
                                                           + " and s.cdStagePersRelInt = :cdStagePersRelInt "
                                                           + " and s.person.cdPersonSex = :cdPersonSex "
                                                           + "   and s.stage.idStage = :idStage ");
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setString("cdPersonSex", cdPersonSex);
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  // STGAP00017013: MR-095
  @SuppressWarnings( { "unchecked" })
  public long countStagePersonLinkByIdStageCdStagePersTypeCdPersonSex(int idStage, String cdStagePersType,
                                                                      String cdPersonSex) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from StagePersonLink s "
                                                           + " where s.cdStagePersType = :cdStagePersType "
                                                           + " and s.person.cdPersonSex = :cdPersonSex "
                                                           + "   and s.stage.idStage = :idStage ");
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdPersonSex", cdPersonSex);
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }
  
  // STGAP00017013: MR-095
  @SuppressWarnings({ "unchecked" })
  public List<StagePersonLink> findStagePersonLinkByIdStageCdStagePersTypeCdStagePersRelInt(int idStage,
                                                                                       String cdStagePersType,
                                                                                       String cdStagePersRelInt) {
    Query query = getSession().createQuery(
                                           "select spl from StagePersonLink spl "
                                                           + " where spl.cdStagePersType = :cdStagePersType "
                                                           + " and spl.cdStagePersRelInt = :cdStagePersRelInt "
                                                           + "   and spl.stage.idStage = :idStage ");
    query.setString("cdStagePersType", cdStagePersType);
    query.setString("cdStagePersRelInt", cdStagePersRelInt);
    query.setInteger("idStage", idStage);
    return (List<StagePersonLink>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findStagePersonLinkByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole) {
    Query query = getSession().createQuery(" from StagePersonLink spl " + " where spl.stage.idStage = :idStage "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (List<StagePersonLink>) query.list();
  }

  /*
   * This query the database for a child previous id person and ADO stage prior to an adoption, if any.
   */
  @SuppressWarnings("unchecked")
  public Map<String, Integer> findPriorAdoptionIdPersonIdAdoStage(int idChild) {
    Query query = getSession().createQuery("select new map(priorAdoSpl.person.idPerson as idPerson, priorAdoSpl.stage.idStage as idStage) "
                                                           + " from StagePersonLink currentPADSpl, "
                                                           + "   StageLink sl, "
                                                           + "	StagePersonLink priorAdoSpl "
                                                           + " where currentPADSpl.person.idPerson = :idChild "
                                                           + " and currentPADSpl.cdStagePersRole = 'PC' "
                                                           + " and currentPADSpl.stage.idStage = sl.stageByIdStage.idStage "
                                                           + " and sl.stageByIdStage.cdStage = 'PAD' "
                                                           + " and priorAdoSpl.stage.idStage = sl.stageByIdPriorStage.idStage "
                                                           + " and sl.stageByIdPriorStage.cdStage = 'ADO' "
                                                           + " and priorAdoSpl.cdStagePersRole = 'PC' ");

    query.setInteger("idChild", idChild);
    return (Map<String, Integer>) query.uniqueResult();
  }
  
  // This is an inverse of findPriorAdoptionIdPersonIdAdoStage(int idChild). It retrieves the child's current
  // PAD stage by using the prior ADO stage that is linked to it
  @SuppressWarnings("unchecked")
  public Map<String, Integer> findPADStageByPriorAdoptionIdPersonIdAdoStage(int idChild) {
    Query query = getSession().createQuery("select new map(currentPADSpl.person.idPerson as idPerson, currentPADSpl.stage.idStage as idStage) "
                                                           + " from StagePersonLink currentPADSpl, "
                                                           + "   StageLink sl, "
                                                           + "  StagePersonLink priorAdoSpl "
                                                           + " where priorAdoSpl.person.idPerson = :idChild "
                                                           + " and priorAdoSpl.cdStagePersRole = 'PC' "
                                                           + " and priorAdoSpl.stage.idStage = sl.stageByIdPriorStage.idStage "
                                                           + " and sl.stageByIdPriorStage.cdStage = 'ADO' "
                                                           + " and currentPADSpl.stage.idStage = sl.stageByIdStage.idStage "
                                                           + " and sl.stageByIdStage.cdStage = 'PAD' "
                                                           + " and currentPADSpl.cdStagePersRole = 'PC' ");

    query.setInteger("idChild", idChild);
    return (Map<String, Integer>) query.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<StagePersonLink> findPrincipalChildrenOpenAdoStagePersonLinkInAnotherCaseByPcIdAdoStageByPcIdPerson(int idAdoStage,
                                                                                                                  int idPrimaryChild) {
    Query query = getSession().createQuery("SELECT siblingOtherCaseAdoSpl "
                                                           + " FROM StagePersonLink primaryChildSpl, "
                                                           + "	StagePersonLink currentAdoSiblingSpl, "
                                                           + "	StagePersonLink siblingOtherCaseAdoSpl "
                                                           +
                                                           // Get primary child SPL
                                                           " WHERE primaryChildSpl.person.idPerson = :idPrimaryChild "
                                                           + " AND primaryChildSpl.cdStagePersRole = 'PC' "
                                                           + " AND primaryChildSpl.stage.idStage = :idAdoStage "
                                                           + " AND (primaryChildSpl.stage.dtStageClose is null "
                                                           + "   OR primaryChildSpl.stage.dtStageClose = :maxDate) "
                                                           +
                                                           // Get principal siblings under 18 in primary child ADO stage
                                                           " AND currentAdoSiblingSpl.stage.idStage = primaryChildSpl.stage.idStage "
                                                           + " AND currentAdoSiblingSpl.person.idPerson <> primaryChildSpl.person.idPerson "
                                                           + " AND currentAdoSiblingSpl.cdStagePersType = 'PRN' "
                                                           + " AND months_between(SYSDATE, currentAdoSiblingSpl.person.dtPersonBirth) < 216 "
                                                           +
                                                           // principal sibling should NOT have an open FCC or ADO stage
                                                           // in the current case
                                                           " AND currentAdoSiblingSpl.person.idPerson NOT IN ( "
                                                           + "   SELECT currentCaseSiblingFccAdoSpl.person.idPerson "
                                                           + "	FROM StagePersonLink currentCaseSiblingFccAdoSpl "
                                                           + "   WHERE currentCaseSiblingFccAdoSpl.cdStagePersRole = 'PC' "
                                                           + "   AND currentCaseSiblingFccAdoSpl.capsCase.idCase = currentAdoSiblingSpl.capsCase.idCase "
                                                           + "   AND currentCaseSiblingFccAdoSpl.stage.cdStage IN ('FCC', 'ADO') "
                                                           + "   AND (currentCaseSiblingFccAdoSpl.stage.dtStageClose IS NULL "
                                                           + "     OR currentCaseSiblingFccAdoSpl.stage.dtStageClose = :maxDate) "
                                                           + "   ) "
                                                           +
                                                           // Get sibling open ADO SPL in another case
                                                           " AND currentAdoSiblingSpl.person.idPerson = siblingOtherCaseAdoSpl.person.idPerson "
                                                           + " AND siblingOtherCaseAdoSpl.stage.cdStage = 'ADO' "
                                                           + " AND siblingOtherCaseAdoSpl.capsCase.idCase <> currentAdoSiblingSpl.capsCase.idCase "
                                                           + " AND (siblingOtherCaseAdoSpl.stage.dtStageClose IS NULL "
                                                           + "   OR siblingOtherCaseAdoSpl.stage.dtStageClose = :maxDate) "
                                                           + " AND siblingOtherCaseAdoSpl.cdStagePersRole = 'PC' ");

    query.setInteger("idAdoStage", idAdoStage);
    query.setInteger("idPrimaryChild", idPrimaryChild);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<StagePersonLink>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findOtherIdCaseByIdCaseIdPersonCdStagePersType(Integer thisCase, Integer idPerson, Collection<String> cdStagePersTypeSet) {
    Query query = getSession().createQuery(" select spl.capsCase.idCase from StagePersonLink spl " 
                                                           + " where spl.capsCase.idCase <> :idCase "
                                                           + " and spl.cdStagePersType in (:cdStagePersTypeSet) "
                                                           + " and spl.person.idPerson = :idPerson ");
    query.setInteger("idCase", thisCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdStagePersTypeSet", cdStagePersTypeSet);
    return (List<Integer>) query.list();
  }

  public long countStagePersonLinkByIdPersonCdPersTypeCdStageDtStageStart(Integer idPerson, Collection<String> cdStagePersTypeSet, Collection<String> cdStages, Date aDate) {
    Query query = getSession().createQuery(" select count (*) from StagePersonLink spl "
                                                           + "where spl.capsCase.idCase is null "
                                                           + "and spl.stage.cdStage in (:cdStages) "
                                                           + "and spl.person.idPerson = :idPerson "
                                                           + "and spl.cdStagePersType in (:cdStagePersTypeSet) "
                                                           + " and trunc(spl.stage.dtStageStart) < trunc(:aDate)  ");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdStagePersTypeSet", cdStagePersTypeSet);
    query.setParameterList("cdStages", cdStages);
    query.setTimestamp("aDate", aDate);
    return (Long) query.uniqueResult();
  }
  
  public long countStagePersonLinkByIdCaseIdPersonCdPersTypeDtPersAdded(Collection<Integer> idCaseSet, Integer idPerson,
                                                              Collection<String> cdStagePersTypeSet, Date aDate) {
    Query query = getSession().createQuery(" select count (*) "
                                                           + "from StagePersonLink spl "
                                                           + "where spl.capsCase.idCase in (:idCaseSet) "
                                                           + "and spl.person.idPerson = :idPerson "
                                                           + "and spl.cdStagePersType in (:cdStagePersTypeSet) "
                                                           + "and trunc(nvl(spl.dtPersonAddedOrRelated,spl.stage.dtStageStart)) < trunc(:aDate) ");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("idCaseSet", idCaseSet);
    query.setParameterList("cdStagePersTypeSet", cdStagePersTypeSet);
    query.setTimestamp("aDate", aDate);
    return (Long) query.uniqueResult();
  }
  
  public long countStagePersonLinkByIdCaseIdPersonCdStageCdPersTypeDtCaseOpened(Collection<Integer> idCaseSet, int idPerson, Collection<String> cdStageSet,
                                                                         Collection<String> cdStagePersTypeSet, Date dtCurrCaseOpened) {

    Query query = getSession().createQuery(" select count (*) " + " from StagePersonLink spl "
                                                           + " where spl.capsCase.idCase in (:idCaseSet) "
                                                           + " and spl.person.idPerson = :idPerson "
                                                           + " and spl.stage.cdStage in (:cdStageSet) "
                                                           + " and spl.cdStagePersType in (:cdStagePersTypeSet) "
                                                           + " and trunc(spl.capsCase.dtCaseOpened) < trunc(:dtCurrCaseOpened) ");

                                                           
    query.setParameterList("idCaseSet", idCaseSet);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdStageSet", cdStageSet);
    query.setParameterList("cdStagePersTypeSet", cdStagePersTypeSet);
    query.setTimestamp("dtCurrCaseOpened", dtCurrCaseOpened);
    return (Long) query.uniqueResult();
  }

}