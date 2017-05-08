/**
 * Created on Mar 25, 2006 at 3:19:14 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;

/**Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
04/22/09     cwells            STGAP00009847: Removing references to AFCARS widgets.  Since those sections
                               Are being removed from the page.  
09/01/2009   arege             STGAP00014993: Added new method findOpenOrClosedPlacementLatestApprovedByIdPerson
09/04/2009   arege             STGAP00014993: Modified findOpenOrClosedPlacementLatestApprovedByIdPerson method as per code review.
09/11/2009   cwells            STGAP00014567: Added method to find the latest actual,approved adoptive placement for the given stage and child 
10/13/2009   pcoogan           STGAP00015531: Updated method signatures for methods used by Placement Log to account for ECEM updates and
                               created new methods restricting placement log to placements ended less than 30 days ago for SHINES portal use
11/11/2009   pcoogan           SMS 38894: Added new methods to count the number of children in placement for the Facility Placement Log
                               directly instead of via inaccurate application code which was only operating off of the paginated
                               result set.  Also corrected code to ensure that data on finalized adoptions is not factored into any agency
                               reporting and is never displayed through Portal. 
11/25/2009  bgehlot            41275 MR-057 Added new fields for APPLA in insertPlacementRunaway, 
                               insertPlacementNoIdContractAgencyFacilNoWaiver,
                               insertPlacementNoIdContractAgencyFacil,insertPlacementNoIdContractAgencyNoWaiver, 
                               insertPlacementNoIdContractAgency, insertPlacementNoIdContractNoWaiver, 
                               insertPlacementNoIdContract,insertPlacement
                               Added new method findMostRecentPlcmtByIdPersonByIdCase    
09/10/2010  hnguyen            SMS#66384 MR-067 Added new method countActualPlacementsByIdPersonByPlacementTypesDuringStartDateEndDate
12/11/2010  htvo               SMS#81140 MR-074 AFCARS Added findMostRecentPlcmtOpenOrClosedByIdPersonByIdCase to find the most recent
                               real placement; can be any approval status, active or ended.
05/24/2011  hjbaptiste         SMS#XXXX CAPTA-4.3 Added new method findCompAprvPlacementsByIdResource                               
06/09/2011  schoi              SMS #109403: MR-082 Added new method findLatestApprovedPlacementByIdPersonOrderByDtPlcmtStart 
06/14/2011  hnguyen            SMS #109407: MR-087 Added new method findMostRecentPlcmtByIdPersonByIdCaseByCdStages 
09/12/2011  charden            STGAP00017058 - created method findActivePlacementByIdPersonsDatePlcmntType() to find active placements on facility and modified
                               insert methods used in addComplex() of complexPlacementDAO and created new method updateDtLastPlcmtLogView()
10/24/2011  hnguyen            STGAP00017349: MR-092 Added findLastPlcmtByIdPersonByIdStage.
02/03/2012  schoi              STGAP00017831: MR-102 Added new method findLatestApprovedPlacementByIdPersonBySvcAuthDetail
*/
public interface PlacementDAO {
  /**
   * This method updates the case manager certification data
   * @param idPlcmtEvent - the placement event
   * @param indCertSigned - new indicator value
   * @param dtCertSigned - new date value
   * @param idUserCert - new user id
   * @return
   */
  public int updateCaseMngrCert(int idPlcmtEvent, String indCertSigned, Date dtCertSigned, String nmCaseMngrRsrc);
  /**
   * This method updates the supervisor certification data
   * @param idPlcmtEvent - the placement event
   * @param indCertSigned - new indicator value
   * @param dtCertSigned - new date value
   * @param idUserCert - new user id
   * @return
   */
  public int updateSupCert(int idPlcmtEvent, String indCertSigned, Date dtCertSigned, String nmSupRsrc);
  /**
   * This method updates the DtLastPlcmtLogView field of the placement
   * @param dtLastPlcmtLogView - date to be updated
   * @return
   */
  public int updateDtLastPlcmtLogView(Date dtLastPlcmtLogView, int idPlcmtEvent);
  /**
   * Find all active placements for persons
   * @param idPersons - list of persons
   * @param maxDate - date to compare with end date
   * @param cdPlacementType - type of placement
   * @return
   */
  public List<Placement> findActivePlacementByIdPersonsDatePlcmntType(List<Integer> idPersons, Date maxDate, String cdPlacementType);
  /**
   * Retrieves the placement type, id and placement contract for a child to calculate per diem
   * 
   * @param idPerson
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findPlcmtTypeByChildStatusForPerDiem(int idPerson);
  
  /**
   * Retrieves the placement type, id and placement contract for a child to calculate per month
   * 
   * @param idPerson
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findPlcmtTypeByChildStatusForPerMonth(int idPerson);
  
  /**
   * Retrieves a count of all children placed in a F/A home for a given date that are 1)foster placement or
   * 2)unconsummated adoptive placements.
   * 
   * @param dtSysDtGenericSysdate
   * @param ulIdRsrcFacil
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findPersonByIdPlcmtChildByCapsResourceByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil);
  
  /**
   * Retrieves a count of all children placed in a F/A home for a given date that are 1)foster placement or
   * 2)unconsummated adoptive placements.
   * 
   * @param dtSysDtGenericSysdate
   * @param ulIdRsrcFacil
   * @param cdstatus
   * @param cdPlcmtActPlanned
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findIdStageByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil, String cdStatusString,String cdPlcmtActPlanned);
  
  /**
   * Retrieves a list of the ids of all the children placed in a F/A home 
   * @param dtSysDtGenericSysdate
   * @param ulIdRsrcFacil
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findPersonByIdPlcmtChildByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil); 
  
  /**
   * Retrieves list of the case and stage ids  
   * @param dtSysDtGenericSysdate
   * @param ulIdRsrcFacil
   * @param status
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findIdCaseIdstage(Date dtSysDtGenericSysdate, int ulIdRsrcFacil,
                              String status);

  /**
   * Retrieves a count of all children placed in a F/A home for a given date that are 1)foster placement or
   * 2)unconsummated adoptive placements.
   * 
   * @param dtSysDtGenericSysdate
   * @param ulIdRsrcFacil
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findAprvPlacementsByCapsResourceByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil);

  /**
   * Retrieve all COMP and APRV Placements for a Resource 
   * 
   * @param dtSysDtGenericSysdate
   * @param idRsrcFacil
   * @return 
   */
  public List<Placement> findCompAprvPlacementsByIdResource(Date dtSysDtGenericSysdate, int idRsrcFacil);
  
  /**
   * Retrieves a count of all children placed in a F/A home for a given date that are actual approved placments
   * that do not include the current placement being approved. 
   * 
   * @param dtSysDtGenericSysdate
   * @param ulIdRsrcFacil
   * @param status
   * @param idPlcmtChild
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findAprvPlacementsByCapsResourceByIdRsrcFacilByIdPlcmtChild(Date dtSysDtGenericSysdate, int ulIdRsrcFacil, String status, int idPlcmtChild);

  
  
  /**
   * Retrieves IdPlcmtEvent by DtPlcmtStart and DtPlcmtEnd
   * 
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @param dtPlcmtStart
   * @param dtPlcmtEnd
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findIdPlcmtEventByDtPlcmtStartAndDtPlcmtEnd(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                            Date dtPlcmtStart, Date dtPlcmtEnd);

  /**
   * Retrieve idPlcmtEvent by dtPlcmtStart
   * 
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @param dtPlcmtStart
   * @param dtPlcmtEnd
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findIdPlcmtEventByDtPlcmtStart(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                               Date dtPlcmtStart, Date dtPlcmtEnd);

  /**
   * Retrieves count Placement by max date and idPlcmtEvent
   * 
   * @param idPlcmtEvent
   * @return
   */
  long countPlacementByMaxDate(int idPlcmtEvent);

  /**
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @param dtPlcmtStart
   * @param dtPlcmtEnd
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findIdPlcmtEventByDtPlcmtEnd(int idCase, int idPlcmtChild, String cdPlcmtActPlanned, Date dtPlcmtStart,
                                             Date dtPlcmtEnd);

  /**
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findIdPlcmtEventByPersonByIdPlcmtChild(int idCase, int idPlcmtChild, String cdPlcmtActPlanned);

  /**
   * @param idCase
   * @param idPlcmtChild
   * @return
   */
  long countPersonByIdPlcmtChildByIdCase(int idCase, int idPlcmtChild);
  
  /**
   * Finding current placements by idCase and idChild where the temp type is not in the exclude list 
   * @param idCase
   * @param idPlcmtChild
   * @param excludeTypes
   * @param dtEvalDate
   * @return Placement
   */
  Placement findPlcmtByIdPlcmtChildByIdCaseNonRes(int idCase, int idPlcmtChild, List<String> excludeTypes, Date dtEvalDate);
  /**
   * @param List<Integer> idRrscFacilList
   * @param List<Integer> idRrscAgencyList
   * @return
   */
  long countFemalesPersonByIdRrscAgencyListByIdRsrcFacil(List<Integer> idRrscFacilList, List<Integer> idRrscAgencyList ); 
  /**
   * @param List<Integer> idRrscFacilList
   * @param List<Integer> idRrscAgencyList
   * @return
   */
  long countChildrenUnder3PersonByIdRrscAgencyListByIdRsrcFacil(List<Integer> idRrscFacilList, List<Integer> idRrscAgencyList ); 
  
  /**
   * @param List<Integer> idRrscFacilList
   * @param List<Integer> idRrscAgencyList
   * @return
   */
  long countChildrenOver16PersonByIdRrscAgencyListByIdRsrcFacil(List<Integer> idRrscFacilList, List<Integer> idRrscAgencyList ); 
  
  /**
   * @param List<Integer> idRrscFacilList
   * @param List<Integer> idRrscAgencyList
   * @return
  */
  long countMalesPersonByIdRrscAgencyListByIdRsrcFacilPortal(List<Integer> idRrscFacilList, List<Integer> idRrscAgencyList );
  
  /**
   * @param List<Integer> idRrscFacilList
   * @param List<Integer> idRrscAgencyList
   * @return
   */
  long countFemalesPersonByIdRrscAgencyListByIdRsrcFacilPortal(List<Integer> idRrscFacilList, List<Integer> idRrscAgencyList ); 
  /**
   * @param List<Integer> idRrscFacilList
   * @param List<Integer> idRrscAgencyList
   * @return
   */
  long countChildrenUnder3PersonByIdRrscAgencyListByIdRsrcFacilPortal(List<Integer> idRrscFacilList, List<Integer> idRrscAgencyList ); 
  
  /**
   * @param List<Integer> idRrscFacilList
   * @param List<Integer> idRrscAgencyList
   * @return
   */
  long countChildrenOver16PersonByIdRrscAgencyListByIdRsrcFacilPortal(List<Integer> idRrscFacilList, List<Integer> idRrscAgencyList ); 
  
  /**
   * @param List<Integer> idRrscFacilList
   * @param List<Integer> idRrscAgencyList
   * @return
  */
  long countMalesPersonByIdRrscAgencyListByIdRsrcFacil(List<Integer> idRrscFacilList, List<Integer> idRrscAgencyList );


  /**
   * This select will retrieve the most recent row from the PLACEMENT table for the idPerson. The following conditions
   * must also be met: cdPlcmtActPlanned = 'A' CD_PLCMT_REMOVAL_RSN must equal any of the codes in the CDISCHRG codes
   * table. <p/>
   * 
   * @param idPlcmtChild
   * @return
   */
  Date findMostRecentPlacementByIdPerson(int idPlcmtChild);

  /**
   * This select will retrieve the most recent row from the PLACEMENT table for the idPerson. The following conditions
   * must also be met: cdPlcmtActPlanned = 'A' CD_PLCMT_REMOVAL_RSN must equal any of the codes in the CDISCHRG codes
   * table. <p/>
   * 
   * @param idPlcmtChild
   * @return
   */
  String findMostRecentPlacementCountyByIdPerson(int idPlcmtChild);

  /**
   * This Dam will check to see if a stage for a given Placement is closed. <p/>
   * 
   * @param idStage
   * @param dtMaxDate
   * @return
   */
  long countPlacementForStageClosed(int idStage);

  /**
   * Retrieves a row from the Placement table for a given placement Event ID. From cses37d.pc
   * 
   * @param idPlcmtEvent
   * @return Placement
   */

  Object[] findPlacementByIdPlcmtEvent(int idPlcmtEvent, String tsLastUpdate);
  
  /**
   * Retrieves a row from the Placement table for a given placement Event ID. From cses37d.pc
   * 
   * @param idPlcmtEvent
   * @return Placement
   */
  Placement findPlacementByIdPlcmtEvent(int idPlcmtEvent);
  
  /**
   * Retrieves a row from the Placement table for a given placement Event ID. From cses37d.pc
   * 
   * @param idPlcmtEvent
   * @return Placement
   */

  Placement findPlacementByIdPlcmtChildDtPlcmtStart(int idPlcmtChild);
  
  /**
   *  Retrieves children ids for active approved placements
   * @param dtSysDtGenericSysdate
   * @param ulIdRsrcFacil
   * @return List<Integer>
   */
  public List<Integer> findApprovedCompIdPlcmtChildByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil);
  
  /**
   * Retrieves a row from the Placement table for a given placement Event ID. From cses37d.pc
   * 
   * @param idPlcmtEvent
   * @return Placement
   */

  Placement findPlacementByIdPlcmtChildAndPlcmtAcctPlanned(int personByIdPlcmtChild, Date dtScrDtLastUpdate);
  
  /**
   * Retrieves a row from the Placement table for a given placement Event ID. From cses37d.pc
   * 
   * @param idPlcmtEvent
   * @return Placement
   */
  
  Placement findPlacementByIdPlcmtChildAndPlcmtAcctPlannedAndCase(int personByIdPlcmtChild, Date dtScrDtLastUpdate, int idCase);
  
  /**
   * Retrieves a row from the Placement table for a given id_plcmt_child, date and id_plcmt_case
   * 
   * @param personByIdPlcmtChild
   * @param dtScrDtLastUpdate
   * @param idCase
   * @return Placement
   */
  
  Placement findPlacementByIdPlcmtChildAndPlcmtAcctPlannedAndStage(int personByIdPlcmtChild, Date dtScrDtLastUpdate, int idStage);

  /**
   * Retrieves a row from the Placement table for a given idPlcmtChild and ServAuthEffectiveDt <p/>
   * 
   * @param idPlcmtChild
   * @param dtServAuthEffectiveDt
   * @return Placement
   */
  Placement findPlacementByIdPlcmtChildAndServAuthEffDt(int idPlcmtChild, Date dtServAuthEffectiveDt);

  /**
   * This count Placement given idEvent.
   * 
   * @param idEvent
   * @return Integer
   */
  long countPlacementByIdEvent(int idEvent);

  /**
   * Retrieve idPlcmtEvent by dtPlcmtStart
   * 
   * @param idCase
   * @param idPlcmtChild
   * @param cdPlcmtActPlanned
   * @param dtPlcmtStart
   * @param dtPlcmtEnd
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findIdPlacmtEventByIdPlcmtChildNoOverlap(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                         Date dtPlcmtStart, Date dtPlcmtEnd);

  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil and idRsrcAgency and the rows are ordered by
   * dtPlcmtEnd and dtPlcmtStart.  Method used by SHINES Placement Log.
   * 
   * @param idRsrcFacilList
   * @param idRsrcAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndAndDtPlcmtStart(List<Integer> idRrscFacilList,
                                                                                                 List<Integer> idRrscAgencyList,
                                                                                                 int pageNbr,
                                                                                                 int pageSize);
  

  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil or idRsrcAgency and the rows are ordered by
   * dtPlcmtEnd and dtPlcmtStart.  Method used by Portal Child List.
   * 
   * @param idRsrcFacilList
   * @param idRsrcAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndAndDtPlcmtStartPortal(List<Integer> idRrscFacilList,
                                                                                                 List<Integer> idRrscAgencyList,
                                                                                                 int pageNbr,
                                                                                                 int pageSize);


  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil or idRsrcAgency and the rows are ordered by
   * dtPlcmtStart.  Method used by Portal Child List.
   * 
   * @param idRsrcFacilList
   * @param idRsrcAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtStartPortal(List<Integer> idRrscFacilList,
                                                                                    List<Integer> idRrscAgencyList,
                                                                                    int pageNbr, int pageSize);
  

  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given list of idRsrcFacil and idRsrcAgency and the rows are ordered by
   * dtPlcmtStart.  Method used by SHINES Placement Log.
   * 
   * @param idRsrcFacilList
   * @param idRsrcAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtStart(List<Integer> idRrscFacilList,
                                                                                    List<Integer> idRrscAgencyList,
                                                                                    int pageNbr, int pageSize);


  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil and idRsrcAgency and the rows are ordered by
   * dtPlcmtEnd.  Method used by SHINES Placement Log.
   * 
   * @param idRsrcFacilList
   * @param idRsrcAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtEnd(List<Integer> idRrscFacilList,
                                                                                  List<Integer> idRrscAgencyList,
                                                                                  int pageNbr, int pageSize);

  

  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil and idRsrcAgency and the rows are ordered by
   * dtPlcmtEnd.  Method used by Portal Child List.
   * 
   * @param idRsrcFacilList
   * @param idRsrcAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndPortal(List<Integer> idRrscFacilList,
                                                                                  List<Integer> idRrscAgencyList,
                                                                                  int pageNbr, int pageSize);

  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil and idRsrcAgency and the rows are ordered by
   * nmPersonfull.  Method used by SHINES Placement Log.
   * 
   * @param idRrscFacilList
   * @param idRrscAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByNmPersonFull(List<Integer> idRrscFacilList,
                                                                                    List<Integer> idRrscAgencyList,
                                                                                    int pageNbr,int pageSize);

  
  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil and idRsrcAgency and the rows are ordered by
   * nmPersonfull.  Method used by Portal Child List.
   * 
   * @param idRrscFacilList
   * @param idRrscAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByNmPersonFullPortal(List<Integer> idRrscFacilList,
                                                                                    List<Integer> idRrscAgencyList,
                                                                                    int pageNbr,int pageSize);

  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil and idRsrcAgency and the rows are ordered by
   * cdPlcmtRemovalRsn.  Method used by SHINES Placement Log.
   * 
   * @param idRsrcFacilList
   * @param idRsrcAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByCdPlcmtRemovalRsn(List<Integer> idRrscFacilList,
                                                                                         List<Integer> idRrscAgencyList,
                                                                                         int pageNbr, int pageSize);
 
  
  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given lists of idRsrcFacil and idRsrcAgency and the rows are ordered by
   * cdPlcmtRemovalRsn.  Method used by Portal Child List.
   * 
   * @param idRsrcFacilList
   * @param idRsrcAgencyList
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByCdPlcmtRemovalRsnPortal(List<Integer> idRrscFacilList,
                                                                                         List<Integer> idRrscAgencyList,
                                                                                         int pageNbr, int pageSize);
 
  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given idRsrcFacil where
   * End date in the future or null
   * 
   * @param idRsrcFacil
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  List findPlacementByIdRsrcFacilForHomeInChildren(int idRsrcFacil);
  /**
   * Inserts a Placement row
   * 
   * @param idCase
   * @param dtPlcmtPermEff
   * @param idPlcmtEvent
   * @param idPlcmtAdult
   * @param idPlcmtChild
   * @param idContract
   * @param idRsrcAgency
   * @param idRsrcFacil
   * @param cdAddrPlcmtCity
   * @param cdAddrPlcmtCnty
   * @param cdAddrPlcmtLn1
   * @param cdAddrPlcmtLn2
   * @param cdAddrPlcmtSt
   * @param cdAddrPlcmtZip
   * @param cdCdPlcmtInfo1
   * @param cdCdPlcmtInfo2
   * @param cdCdPlcmtInfo3
   * @param cdCdPlcmtInfo4
   * @param cdCdPlcmtInfo5
   * @param cdCdPlcmtInfo6
   * @param cdCdPlcmtInfo7
   * @param cdCdPlcmtInfo8
   * @param cdCdPlcmtInfo9
   * @param cdCdPlcmtInfo10
   * @param cdCdPlcmtInfo11
   * @param cdCdPlcmtInfo12
   * @param cdCdPlcmtInfo13
   * @param cdCdPlcmtInfo14
   * @param cdCdPlcmtInfo15
   * @param cdCdPlcmtInfo16
   * @param cdCdPlcmtInfo17
   * @param cdPlcmtLivArr
   * @param cdPlcmtRemovalRsn
   * @param cdPlcmtActPlanned
   * @param cdPlcmtType
   * @param cdPlcmtService
   * @param dtPlcmtCaregvrDiscuss
   * @param dtPlcmtChildDiscuss
   * @param dtPlcmtChildPlan
   * @param dtPlcmtEducLog
   * @param dtPlcmtEnd
   * @param dtPlcmtMeddevHistory
   * @param dtPlcmtParentsNotif
   * @param dtPlcmtPreplaceVisit
   * @param dtPlcmtSchoolRecords
   * @param dtPlcmtStart
   * @param indPlcmtContCntct
   * @param indPlcmtEducLog
   * @param indPlcmetEmerg
   * @param indPlcmtNotApplic
   * @param indPlcmtSchoolDoc
   * @param cdNbrPlcmtPhoneExt
   * @param cdNbrPlcmtTelephone
   * @param cdNmPlcmtAgency
   * @param cdNmPlcmtContact
   * @param cdNmPlcmtFacil
   * @param cdNmPlcmtPersonFull
   * @param indPlcmtWriteHistory
   * @param cdTxtPlcmtAddrComment
   * @param cdTxtPlcmtDiscussion
   * @param txtaSzTxtPlcmtDocuments
   * @param cdTxtPlcmtRemovalRsn
   * @return
   */
  // New Added 4
  int insertPlacementNoWaiver(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult, int idPlcmtChild,
                              int idContract, int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCity,
                              String cdAddrPlcmtCnty, String cdAddrPlcmtLn1, String cdAddrPlcmtLn2,
                              String cdAddrPlcmtSt, String cdAddrPlcmtZip, String cdCdPlcmtInfo1,
                              String cdCdPlcmtInfo2, String cdCdPlcmtInfo3, String cdCdPlcmtInfo4,
                              String cdCdPlcmtInfo5, String cdCdPlcmtInfo6, String cdCdPlcmtInfo7,
                              String cdCdPlcmtInfo8, String cdCdPlcmtInfo9, String cdCdPlcmtInfo10,
                              String cdCdPlcmtInfo11, String cdCdPlcmtInfo12, String cdCdPlcmtInfo13,
                              String cdCdPlcmtInfo14, String cdCdPlcmtInfo15, String cdCdPlcmtInfo16,
                              String cdCdPlcmtInfo17, String cdPlcmtLivArr, String cdPlcmtRemovalRsn,
                              String cdPlcmtActPlanned, String cdPlcmtType, String cdPlcmtService,
                              Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan,
                              Date dtPlcmtEducLog, Date dtPlcmtEnd, Date dtPlcmtMeddevHistory,
                              Date dtPlcmtParentsNotif, Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords,
                              Date dtPlcmtStart, String indPlcmtContCntct, String indPlcmtEducLog,
                              String indPlcmetEmerg, String indPlcmtNotApplic, String indPlcmtSchoolDoc,
                              String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone, String cdNmPlcmtAgency,
                              String cdNmPlcmtContact, String cdNmPlcmtFacil, String cdNmPlcmtPersonFull,
                              String indPlcmtWriteHistory, String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                              String cdTxtPlcmtRemovalRsn, String szCdActAtt,
                              int ulContactedById, String selSzCdMethod, String cbxIndTempReplacement,
                              String szCdTempPlcmtType, String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                              String rbIndCaseHome, Date dtDateLastDischarged, String ulMatch,
                              Date dtPermReportDueDate, String cbxBoardingCounty, String cbxIndTrialHomeVisit,
                              Date dtCrtBeginDate, Date dtCrtEndDate, String rbIndPlcmtChPlacedFr,
                              String rbIndPlcmtChPlacedBy, String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
                              String rbIndPlcmtLeastRestrict, String rbIndPlcmtFamilyLike,
                              String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar,
                              String rbIndPlcmtCloseProxSchool, String rbIndConsistent, String szTxtNoExplainCheckList,
                              String rbIndExpTrauma, String szTxtYesExpTrauma, String rbIndStaySiblings,
                              int nbrSibinCare, int nbrSibPlaced, String szCdSibRsn, String szCdCCFARsn,
                              String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA,
                              String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                              String szCdSuppSupervisionCmnts, Date txtDtPsychInfo, String txtSzNmPsychinfo,
                              Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo, Date txtDtMedInfo,
                              String txtSzNmMedinfo, Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo,
                              Date txtDtEduInfo, String txtSzNmEduinfo, String cbxIndNAEduInfo, Date txtDtCaseEduInfo,
                              String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo, String txtaSzTxtPlcmtDocuments,
                              String txtaSzTxtPlcmtCmntsDocuments);
//MR-057 Added new fields for APPLA
  int insertPlacement(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult, int idPlcmtChild, int idContract,
                      int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCity, String cdAddrPlcmtCnty,
                      String cdAddrPlcmtLn1, String cdAddrPlcmtLn2, String cdAddrPlcmtSt, String cdAddrPlcmtZip,
                      String cdCdPlcmtInfo1, String cdCdPlcmtInfo2, String cdCdPlcmtInfo3, String cdCdPlcmtInfo4,
                      String cdCdPlcmtInfo5, String cdCdPlcmtInfo6, String cdCdPlcmtInfo7, String cdCdPlcmtInfo8,
                      String cdCdPlcmtInfo9, String cdCdPlcmtInfo10, String cdCdPlcmtInfo11, String cdCdPlcmtInfo12,
                      String cdCdPlcmtInfo13, String cdCdPlcmtInfo14, String cdCdPlcmtInfo15, String cdCdPlcmtInfo16,
                      String cdCdPlcmtInfo17, String cdPlcmtLivArr, String cdPlcmtRemovalRsn, String cdPlcmtActPlanned,
                      String cdPlcmtType, String cdPlcmtService, Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss,
                      Date dtPlcmtChildPlan, Date dtPlcmtEducLog, Date dtPlcmtEnd, Date dtPlcmtMeddevHistory,
                      Date dtPlcmtParentsNotif, Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords,
                      Date dtPlcmtStart, String indPlcmtContCntct, String indPlcmtEducLog, String indPlcmetEmerg,
                      String indPlcmtNotApplic, String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt,
                      String cdNbrPlcmtTelephone, String cdNmPlcmtAgency, String cdNmPlcmtContact,
                      String cdNmPlcmtFacil, String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                      String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion, 
                      String cdTxtPlcmtRemovalRsn, String szCdActAtt, int ulContactedById, String selSzCdMethod,
                      String cbxIndTempReplacement, String szCdTempPlcmtType, String szTxtTempPlcmtCmnts,
                      String cbxIndWaiverRequired, String rbIndCaseHome, int dspUlWaiverId, Date dtDateLastDischarged,
                      String ulMatch, Date dtPermReportDueDate, String cbxBoardingCounty, String cbxIndTrialHomeVisit,
                      Date dtCrtBeginDate, Date dtCrtEndDate, String rbIndPlcmtChPlacedFr, String rbIndPlcmtChPlacedBy,
                      String szCdChildTransitionCmnts, String rbIndPlcmtSafe, String rbIndPlcmtLeastRestrict,
                      String rbIndPlcmtFamilyLike, String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar,
                      String rbIndPlcmtCloseProxSchool, String rbIndConsistent, String szTxtNoExplainCheckList,
                      String rbIndExpTrauma, String szTxtYesExpTrauma, String rbIndStaySiblings, int nbrSibinCare,
                      int nbrSibPlaced, String szCdSibRsn, String szCdCCFARsn, String szCdNoReasonCmnts,
                      String rbIndPlcmtMatchCCFA, String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                      String szCdSuppSupervisionCmnts, Date txtDtPsychInfo, String txtSzNmPsychinfo,
                      Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo, Date txtDtMedInfo, String txtSzNmMedinfo,
                      Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo, Date txtDtEduInfo, String txtSzNmEduinfo,
                      String cbxIndNAEduInfo, Date txtDtCaseEduInfo, String txtSzNmCaseEduinfo,
                      String cbxIndNACaseEduInfo, String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments, 
                      String indLTFCPlacement, Date dtAgreementSigned, String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog );

  // New Added 3
//MR-057 Added new fields for APPLA
  int insertPlacementNoIdContractNoWaiver(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult, int idPlcmtChild,
                                          int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCity,
                                          String cdAddrPlcmtCnty, String cdAddrPlcmtLn1, String cdAddrPlcmtLn2,
                                          String cdAddrPlcmtSt, String cdAddrPlcmtZip, String cdCdPlcmtInfo1,
                                          String cdCdPlcmtInfo2, String cdCdPlcmtInfo3, String cdCdPlcmtInfo4,
                                          String cdCdPlcmtInfo5, String cdCdPlcmtInfo6, String cdCdPlcmtInfo7,
                                          String cdCdPlcmtInfo8, String cdCdPlcmtInfo9, String cdCdPlcmtInfo10,
                                          String cdCdPlcmtInfo11, String cdCdPlcmtInfo12, String cdCdPlcmtInfo13,
                                          String cdCdPlcmtInfo14, String cdCdPlcmtInfo15, String cdCdPlcmtInfo16,
                                          String cdCdPlcmtInfo17, String cdPlcmtLivArr, String cdPlcmtRemovalRsn,
                                          String cdPlcmtActPlanned, String cdPlcmtType, String cdPlcmtService,
                                          Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan,
                                          Date dtPlcmtEducLog, Date dtPlcmtEnd, Date dtPlcmtMeddevHistory,
                                          Date dtPlcmtParentsNotif, Date dtPlcmtPreplaceVisit,
                                          Date dtPlcmtSchoolRecords, Date dtPlcmtStart, String indPlcmtContCntct,
                                          String indPlcmtEducLog, String indPlcmetEmerg, String indPlcmtNotApplic,
                                          String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt,
                                          String cdNbrPlcmtTelephone, String cdNmPlcmtAgency, String cdNmPlcmtContact,
                                          String cdNmPlcmtFacil, String cdNmPlcmtPersonFull,
                                          String indPlcmtWriteHistory, String cdTxtPlcmtAddrComment,
                                          String cdTxtPlcmtDiscussion, 
                                          String cdTxtPlcmtRemovalRsn, String szCdActAtt, int ulContactedById,
                                          String selSzCdMethod, String cbxIndTempReplacement, String szCdTempPlcmtType,
                                          String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                                          String rbIndCaseHome, Date dtDateLastDischarged, String ulMatch,
                                          Date dtPermReportDueDate, String cbxBoardingCounty,
                                          String cbxIndTrialHomeVisit, Date dtCrtBeginDate, Date dtCrtEndDate,
                                          String rbIndPlcmtChPlacedFr, String rbIndPlcmtChPlacedBy,
                                          String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
                                          String rbIndPlcmtLeastRestrict, String rbIndPlcmtFamilyLike,
                                          String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar,
                                          String rbIndPlcmtCloseProxSchool, String rbIndConsistent,
                                          String szTxtNoExplainCheckList, String rbIndExpTrauma,
                                          String szTxtYesExpTrauma, String rbIndStaySiblings, int nbrSibinCare,
                                          int nbrSibPlaced, String szCdSibRsn, String szCdCCFARsn,
                                          String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA,
                                          String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                                          String szCdSuppSupervisionCmnts, Date txtDtPsychInfo,
                                          String txtSzNmPsychinfo, Date txtDtCasePsychInfo,
                                          String txtSzNmCasePsychinfo, Date txtDtMedInfo, String txtSzNmMedinfo,
                                          Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                                          String txtSzNmEduinfo, String cbxIndNAEduInfo, Date txtDtCaseEduInfo,
                                          String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo,
                                          String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments, 
                                          String indLTFCPlacement, Date dtAgreementSigned, 
                                          String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog );
//MR-057 Added new fields for APPLA
  int insertPlacementNoIdContract(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult, int idPlcmtChild,
                                  int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCity, String cdAddrPlcmtCnty,
                                  String cdAddrPlcmtLn1, String cdAddrPlcmtLn2, String cdAddrPlcmtSt,
                                  String cdAddrPlcmtZip, String cdCdPlcmtInfo1, String cdCdPlcmtInfo2,
                                  String cdCdPlcmtInfo3, String cdCdPlcmtInfo4, String cdCdPlcmtInfo5,
                                  String cdCdPlcmtInfo6, String cdCdPlcmtInfo7, String cdCdPlcmtInfo8,
                                  String cdCdPlcmtInfo9, String cdCdPlcmtInfo10, String cdCdPlcmtInfo11,
                                  String cdCdPlcmtInfo12, String cdCdPlcmtInfo13, String cdCdPlcmtInfo14,
                                  String cdCdPlcmtInfo15, String cdCdPlcmtInfo16, String cdCdPlcmtInfo17,
                                  String cdPlcmtLivArr, String cdPlcmtRemovalRsn, String cdPlcmtActPlanned,
                                  String cdPlcmtType, String cdPlcmtService, Date dtPlcmtCaregvrDiscuss,
                                  Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan, Date dtPlcmtEducLog,
                                  Date dtPlcmtEnd, Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif,
                                  Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords, Date dtPlcmtStart,
                                  String indPlcmtContCntct, String indPlcmtEducLog, String indPlcmetEmerg,
                                  String indPlcmtNotApplic, String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt,
                                  String cdNbrPlcmtTelephone, String cdNmPlcmtAgency, String cdNmPlcmtContact,
                                  String cdNmPlcmtFacil, String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                                  String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                                  String cdTxtPlcmtRemovalRsn, String szCdActAtt,
                                  int ulContactedById, String selSzCdMethod, String cbxIndTempReplacement,
                                  String szCdTempPlcmtType, String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                                  String rbIndCaseHome, int dspUlWaiverId, Date dtDateLastDischarged, String ulMatch,
                                  Date dtPermReportDueDate, String cbxBoardingCounty, String cbxIndTrialHomeVisit,
                                  Date dtCrtBeginDate, Date dtCrtEndDate, String rbIndPlcmtChPlacedFr,
                                  String rbIndPlcmtChPlacedBy, String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
                                  String rbIndPlcmtLeastRestrict, String rbIndPlcmtFamilyLike,
                                  String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar,
                                  String rbIndPlcmtCloseProxSchool, String rbIndConsistent,
                                  String szTxtNoExplainCheckList, String rbIndExpTrauma, String szTxtYesExpTrauma,
                                  String rbIndStaySiblings, int nbrSibinCare, int nbrSibPlaced, String szCdSibRsn,
                                  String szCdCCFARsn, String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA,
                                  String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                                  String szCdSuppSupervisionCmnts, Date txtDtPsychInfo, String txtSzNmPsychinfo,
                                  Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo, Date txtDtMedInfo,
                                  String txtSzNmMedinfo, Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo,
                                  Date txtDtEduInfo, String txtSzNmEduinfo, String cbxIndNAEduInfo,
                                  Date txtDtCaseEduInfo, String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo,
                                  String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments, 
                                  String indLTFCPlacement, Date dtAgreementSigned, 
                                  String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog );

  // New Added 2
//MR-057 Added new fields for APPLA
  int insertPlacementNoIdContractAgencyNoWaiver(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult,
                                                int idPlcmtChild, int idRsrcFacil, String cdAddrPlcmtCity,
                                                String cdAddrPlcmtCnty, String cdAddrPlcmtLn1, String cdAddrPlcmtLn2,
                                                String cdAddrPlcmtSt, String cdAddrPlcmtZip, String cdCdPlcmtInfo1,
                                                String cdCdPlcmtInfo2, String cdCdPlcmtInfo3, String cdCdPlcmtInfo4,
                                                String cdCdPlcmtInfo5, String cdCdPlcmtInfo6, String cdCdPlcmtInfo7,
                                                String cdCdPlcmtInfo8, String cdCdPlcmtInfo9, String cdCdPlcmtInfo10,
                                                String cdCdPlcmtInfo11, String cdCdPlcmtInfo12, String cdCdPlcmtInfo13,
                                                String cdCdPlcmtInfo14, String cdCdPlcmtInfo15, String cdCdPlcmtInfo16,
                                                String cdCdPlcmtInfo17, String cdPlcmtLivArr, String cdPlcmtRemovalRsn,
                                                String cdPlcmtActPlanned, String cdPlcmtType, String cdPlcmtService,
                                                Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss,
                                                Date dtPlcmtChildPlan, Date dtPlcmtEducLog, Date dtPlcmtEnd,
                                                Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif,
                                                Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords,
                                                Date dtPlcmtStart, String indPlcmtContCntct, String indPlcmtEducLog,
                                                String indPlcmetEmerg, String indPlcmtNotApplic,
                                                String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt,
                                                String cdNbrPlcmtTelephone, String cdNmPlcmtAgency,
                                                String cdNmPlcmtContact, String cdNmPlcmtFacil,
                                                String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                                                String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                                                String cdTxtPlcmtRemovalRsn,
                                                String szCdActAtt, int ulContactedById, String selSzCdMethod,
                                                String cbxIndTempReplacement, String szCdTempPlcmtType,
                                                String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                                                String rbIndCaseHome, Date dtDateLastDischarged, String ulMatch,
                                                Date dtPermReportDueDate, String cbxBoardingCounty,
                                                String cbxIndTrialHomeVisit, Date dtCrtBeginDate, Date dtCrtEndDate,
                                                String rbIndPlcmtChPlacedFr, String rbIndPlcmtChPlacedBy,
                                                String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
                                                String rbIndPlcmtLeastRestrict, String rbIndPlcmtFamilyLike,
                                                String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar,
                                                String rbIndPlcmtCloseProxSchool, String rbIndConsistent,
                                                String szTxtNoExplainCheckList, String rbIndExpTrauma,
                                                String szTxtYesExpTrauma, String rbIndStaySiblings, int nbrSibinCare,
                                                int nbrSibPlaced, String szCdSibRsn, String szCdCCFARsn,
                                                String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA,
                                                String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                                                String szCdSuppSupervisionCmnts, Date txtDtPsychInfo,
                                                String txtSzNmPsychinfo, Date txtDtCasePsychInfo,
                                                String txtSzNmCasePsychinfo, Date txtDtMedInfo, String txtSzNmMedinfo,
                                                Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                                                String txtSzNmEduinfo, String cbxIndNAEduInfo, Date txtDtCaseEduInfo,
                                                String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo,
                                                String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments, 
                                                String indLTFCPlacement, 
                                                Date dtAgreementSigned,String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog );
//MR-057 Added new fields for APPLA
  int insertPlacementNoIdContractAgency(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult, int idPlcmtChild,
                                        int idRsrcFacil, String cdAddrPlcmtCity, String cdAddrPlcmtCnty,
                                        String cdAddrPlcmtLn1, String cdAddrPlcmtLn2, String cdAddrPlcmtSt,
                                        String cdAddrPlcmtZip, String cdCdPlcmtInfo1, String cdCdPlcmtInfo2,
                                        String cdCdPlcmtInfo3, String cdCdPlcmtInfo4, String cdCdPlcmtInfo5,
                                        String cdCdPlcmtInfo6, String cdCdPlcmtInfo7, String cdCdPlcmtInfo8,
                                        String cdCdPlcmtInfo9, String cdCdPlcmtInfo10, String cdCdPlcmtInfo11,
                                        String cdCdPlcmtInfo12, String cdCdPlcmtInfo13, String cdCdPlcmtInfo14,
                                        String cdCdPlcmtInfo15, String cdCdPlcmtInfo16, String cdCdPlcmtInfo17,
                                        String cdPlcmtLivArr, String cdPlcmtRemovalRsn, String cdPlcmtActPlanned,
                                        String cdPlcmtType, String cdPlcmtService, Date dtPlcmtCaregvrDiscuss,
                                        Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan, Date dtPlcmtEducLog,
                                        Date dtPlcmtEnd, Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif,
                                        Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords, Date dtPlcmtStart,
                                        String indPlcmtContCntct, String indPlcmtEducLog, String indPlcmetEmerg,
                                        String indPlcmtNotApplic, String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt,
                                        String cdNbrPlcmtTelephone, String cdNmPlcmtAgency, String cdNmPlcmtContact,
                                        String cdNmPlcmtFacil, String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                                        String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                                        String cdTxtPlcmtRemovalRsn, String szCdActAtt,
                                        int ulContactedById, String selSzCdMethod, String cbxIndTempReplacement,
                                        String szCdTempPlcmtType, String szTxtTempPlcmtCmnts,
                                        String cbxIndWaiverRequired, String rbIndCaseHome, int dspUlWaiverId,
                                        Date dtDateLastDischarged, String ulMatch, Date dtPermReportDueDate,
                                        String cbxBoardingCounty, String cbxIndTrialHomeVisit, Date dtCrtBeginDate,
                                        Date dtCrtEndDate, String rbIndPlcmtChPlacedFr, String rbIndPlcmtChPlacedBy,
                                        String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
                                        String rbIndPlcmtLeastRestrict, String rbIndPlcmtFamilyLike,
                                        String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar,
                                        String rbIndPlcmtCloseProxSchool, String rbIndConsistent,
                                        String szTxtNoExplainCheckList, String rbIndExpTrauma,
                                        String szTxtYesExpTrauma, String rbIndStaySiblings, int nbrSibinCare,
                                        int nbrSibPlaced, String szCdSibRsn, String szCdCCFARsn,
                                        String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA,
                                        String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                                        String szCdSuppSupervisionCmnts, Date txtDtPsychInfo, String txtSzNmPsychinfo,
                                        Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo, Date txtDtMedInfo,
                                        String txtSzNmMedinfo, Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo,
                                        Date txtDtEduInfo, String txtSzNmEduinfo, String cbxIndNAEduInfo,
                                        Date txtDtCaseEduInfo, String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo,
                                        String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments, 
                                        String indLTFCPlacement, 
                                        Date dtAgreementSigned,String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog );

  // New Added 1
//MR-057 Added new fields for APPLA
  int insertPlacementNoIdContractAgencyFacilNoWaiver(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult,
                                                     int idPlcmtChild, String cdAddrPlcmtCity, String cdAddrPlcmtCnty,
                                                     String cdAddrPlcmtLn1, String cdAddrPlcmtLn2,
                                                     String cdAddrPlcmtSt, String cdAddrPlcmtZip,
                                                     String cdCdPlcmtInfo1, String cdCdPlcmtInfo2,
                                                     String cdCdPlcmtInfo3, String cdCdPlcmtInfo4,
                                                     String cdCdPlcmtInfo5, String cdCdPlcmtInfo6,
                                                     String cdCdPlcmtInfo7, String cdCdPlcmtInfo8,
                                                     String cdCdPlcmtInfo9, String cdCdPlcmtInfo10,
                                                     String cdCdPlcmtInfo11, String cdCdPlcmtInfo12,
                                                     String cdCdPlcmtInfo13, String cdCdPlcmtInfo14,
                                                     String cdCdPlcmtInfo15, String cdCdPlcmtInfo16,
                                                     String cdCdPlcmtInfo17, String cdPlcmtLivArr,
                                                     String cdPlcmtRemovalRsn, String cdPlcmtActPlanned,
                                                     String cdPlcmtType, String cdPlcmtService,
                                                     Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss,
                                                     Date dtPlcmtChildPlan, Date dtPlcmtEducLog, Date dtPlcmtEnd,
                                                     Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif,
                                                     Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords,
                                                     Date dtPlcmtStart, String indPlcmtContCntct,
                                                     String indPlcmtEducLog, String indPlcmetEmerg,
                                                     String indPlcmtNotApplic, String indPlcmtSchoolDoc,
                                                     String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone,
                                                     String cdNmPlcmtAgency, String cdNmPlcmtContact,
                                                     String cdNmPlcmtFacil, String cdNmPlcmtPersonFull,
                                                     String indPlcmtWriteHistory, String cdTxtPlcmtAddrComment,
                                                     String cdTxtPlcmtDiscussion, 
                                                     String cdTxtPlcmtRemovalRsn, String szCdActAtt,
                                                     int ulContactedById, String selSzCdMethod,
                                                     String cbxIndTempReplacement, String szCdTempPlcmtType,
                                                     String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                                                     String rbIndCaseHome, Date dtDateLastDischarged, String ulMatch,
                                                     Date dtPermReportDueDate, String cbxBoardingCounty,
                                                     String cbxIndTrialHomeVisit, Date dtCrtBeginDate,
                                                     Date dtCrtEndDate, String rbIndPlcmtChPlacedFr,
                                                     String rbIndPlcmtChPlacedBy, String szCdChildTransitionCmnts,
                                                     String rbIndPlcmtSafe, String rbIndPlcmtLeastRestrict,
                                                     String rbIndPlcmtFamilyLike, String rbIndPlcmtAppropriate,
                                                     String rbIndPlcmtCloseProxPar, String rbIndPlcmtCloseProxSchool,
                                                     String rbIndConsistent, String szTxtNoExplainCheckList,
                                                     String rbIndExpTrauma, String szTxtYesExpTrauma,
                                                     String rbIndStaySiblings, int nbrSibinCare, int nbrSibPlaced,
                                                     String szCdSibRsn, String szCdCCFARsn, String szCdNoReasonCmnts,
                                                     String rbIndPlcmtMatchCCFA, String szCdPlcmtMatchCCFAReasonCmnts,
                                                     String rbIndSuppSupervision, String szCdSuppSupervisionCmnts,
                                                     Date txtDtPsychInfo, String txtSzNmPsychinfo,
                                                     Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo,
                                                     Date txtDtMedInfo, String txtSzNmMedinfo, Date txtDtCaseMedInfo,
                                                     String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                                                     String txtSzNmEduinfo, String cbxIndNAEduInfo,
                                                     Date txtDtCaseEduInfo, String txtSzNmCaseEduinfo,
                                                     String cbxIndNACaseEduInfo, String txtaSzTxtPlcmtDocuments,
                                                     String txtaSzTxtPlcmtCmntsDocuments, String indLTFCPlacement, 
                                                     Date dtAgreementSigned, String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog );
//MR-057 Added new fields for APPLA
  int insertPlacementNoIdContractAgencyFacil(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult, int idPlcmtChild,
                                             String cdAddrPlcmtCity, String cdAddrPlcmtCnty, String cdAddrPlcmtLn1,
                                             String cdAddrPlcmtLn2, String cdAddrPlcmtSt, String cdAddrPlcmtZip,
                                             String cdCdPlcmtInfo1, String cdCdPlcmtInfo2, String cdCdPlcmtInfo3,
                                             String cdCdPlcmtInfo4, String cdCdPlcmtInfo5, String cdCdPlcmtInfo6,
                                             String cdCdPlcmtInfo7, String cdCdPlcmtInfo8, String cdCdPlcmtInfo9,
                                             String cdCdPlcmtInfo10, String cdCdPlcmtInfo11, String cdCdPlcmtInfo12,
                                             String cdCdPlcmtInfo13, String cdCdPlcmtInfo14, String cdCdPlcmtInfo15,
                                             String cdCdPlcmtInfo16, String cdCdPlcmtInfo17, String cdPlcmtLivArr,
                                             String cdPlcmtRemovalRsn, String cdPlcmtActPlanned, String cdPlcmtType,
                                             String cdPlcmtService, Date dtPlcmtCaregvrDiscuss,
                                             Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan, Date dtPlcmtEducLog,
                                             Date dtPlcmtEnd, Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif,
                                             Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords, Date dtPlcmtStart,
                                             String indPlcmtContCntct, String indPlcmtEducLog, String indPlcmetEmerg,
                                             String indPlcmtNotApplic, String indPlcmtSchoolDoc,
                                             String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone,
                                             String cdNmPlcmtAgency, String cdNmPlcmtContact, String cdNmPlcmtFacil,
                                             String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                                             String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                                             String cdTxtPlcmtRemovalRsn,
                                             String szCdActAtt, int ulContactedById, String selSzCdMethod,
                                             String cbxIndTempReplacement, String szCdTempPlcmtType,
                                             String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                                             String rbIndCaseHome, int dspUlWaiverId, Date dtDateLastDischarged,
                                             String ulMatch, Date dtPermReportDueDate, String cbxBoardingCounty,
                                             String cbxIndTrialHomeVisit, Date dtCrtBeginDate, Date dtCrtEndDate,
                                             String rbIndPlcmtChPlacedFr, String rbIndPlcmtChPlacedBy,
                                             String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
                                             String rbIndPlcmtLeastRestrict, String rbIndPlcmtFamilyLike,
                                             String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar,
                                             String rbIndPlcmtCloseProxSchool, String rbIndConsistent,
                                             String szTxtNoExplainCheckList, String rbIndExpTrauma,
                                             String szTxtYesExpTrauma, String rbIndStaySiblings, int nbrSibinCare,
                                             int nbrSibPlaced, String szCdSibRsn, String szCdCCFARsn,
                                             String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA,
                                             String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                                             String szCdSuppSupervisionCmnts, Date txtDtPsychInfo,
                                             String txtSzNmPsychinfo, Date txtDtCasePsychInfo,
                                             String txtSzNmCasePsychinfo, Date txtDtMedInfo, String txtSzNmMedinfo,
                                             Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                                             String txtSzNmEduinfo, String cbxIndNAEduInfo, Date txtDtCaseEduInfo,
                                             String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo,
                                             String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments, 
                                             String indLTFCPlacement, Date dtAgreementSigned, String indConnectedAdult, 
                                             Integer idPersonConnected, Date dtLastViewPlcmtLog );
//MR-057 Added new fields for APPLA 
int insertPlacementRunaway(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtChild, String cdAddrPlcmtCity,
                                    String cdAddrPlcmtCnty, String cdAddrPlcmtLn1,
                                    String cdAddrPlcmtLn2, String cdAddrPlcmtSt,
                                    String cdAddrPlcmtZip, String cdCdPlcmtInfo1,
                                    String cdCdPlcmtInfo2, String cdCdPlcmtInfo3,
                                    String cdCdPlcmtInfo4, String cdCdPlcmtInfo5,
                                    String cdCdPlcmtInfo6, String cdCdPlcmtInfo7,
                                    String cdCdPlcmtInfo8, String cdCdPlcmtInfo9,
                                    String cdCdPlcmtInfo10, String cdCdPlcmtInfo11,
                                    String cdCdPlcmtInfo12, String cdCdPlcmtInfo13,
                                    String cdCdPlcmtInfo14, String cdCdPlcmtInfo15,
                                    String cdCdPlcmtInfo16, String cdCdPlcmtInfo17,
                                    String cdPlcmtLivArr, String cdPlcmtRemovalRsn,
                                    String cdPlcmtActPlanned, String cdPlcmtType,
                                    String cdPlcmtService, Date dtPlcmtCaregvrDiscuss,
                                    Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan,
                                    Date dtPlcmtEducLog, Date dtPlcmtEnd,
                                    Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif,
                                    Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords,
                                    Date dtPlcmtStart, String indPlcmtContCntct,
                                    String indPlcmtEducLog, String indPlcmetEmerg,
                                    String indPlcmtNotApplic, String indPlcmtSchoolDoc,
                                    String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone,
                                    String cdNmPlcmtAgency, String cdNmPlcmtContact,
                                    String cdNmPlcmtFacil, String cdNmPlcmtPersonFull,
                                    String indPlcmtWriteHistory, String cdTxtPlcmtAddrComment,
                                    String cdTxtPlcmtDiscussion, String cdTxtPlcmtRemovalRsn,
                                    String szCdActAtt, int ulContactedById,
                                    String selSzCdMethod, String cbxIndTempReplacement,
                                    String szCdTempPlcmtType, String szTxtTempPlcmtCmnts,
                                    String cbxIndWaiverRequired, String rbIndCaseHome,
                                    Date dtDateLastDischarged, String ulMatch,
                                    Date dtPermReportDueDate, String cbxBoardingCounty,
                                    String cbxIndTrialHomeVisit, Date dtCrtBeginDate,
                                    Date dtCrtEndDate, String rbIndPlcmtChPlacedFr,
                                    String rbIndPlcmtChPlacedBy,
                                    String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
                                    String rbIndPlcmtLeastRestrict,
                                    String rbIndPlcmtFamilyLike, String rbIndPlcmtAppropriate,
                                    String rbIndPlcmtCloseProxPar,
                                    String rbIndPlcmtCloseProxSchool, String rbIndConsistent,
                                    String szTxtNoExplainCheckList, String rbIndExpTrauma,
                                    String szTxtYesExpTrauma, String rbIndStaySiblings,
                                    int nbrSibinCare, int nbrSibPlaced, String szCdSibRsn,
                                    String szCdCCFARsn, String szCdNoReasonCmnts,
                                    String rbIndPlcmtMatchCCFA,
                                    String szCdPlcmtMatchCCFAReasonCmnts,
                                    String rbIndSuppSupervision,
                                    String szCdSuppSupervisionCmnts, Date txtDtPsychInfo,
                                    String txtSzNmPsychinfo, Date txtDtCasePsychInfo,
                                    String txtSzNmCasePsychinfo, Date txtDtMedInfo,
                                    String txtSzNmMedinfo, Date txtDtCaseMedInfo,
                                    String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                                    String txtSzNmEduinfo, String cbxIndNAEduInfo,
                                    Date txtDtCaseEduInfo, String txtSzNmCaseEduinfo,
                                    String cbxIndNACaseEduInfo, String txtaSzTxtPlcmtDocuments,
                                    String txtaSzTxtPlcmtCmntsDocuments, String indLTFCPlacement, 
                                    Date dtAgreementSigned, String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog ); 

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.Placement} object to the database.
   * 
   * @param placement
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.Placement} object.
   */
  void savePlacement(Placement placement);

  /**
   * Update Placement by idPlcmtEvent
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idPlcmtEvent
   * @return
   */
  int updatePlacementByIdPlcmtEvent(int idPersMergeForward, int idPersMergeClosed, int idPlcmtEvent);
  
  //Added for STGAP00013099
  /**
   * Updates the Placement Records with idPersonForward 
   *  
   */
  int updatePlacementWithForwardPerson(int idPersonForward, int idPersonClosed);
  
  //Added for STGAP00013099 
  /**
   * Find placements for given idplacement child.
   * 
   * 
   * @param idPersonClosed
   * @return List of placements 
   */
  List<Placement> findPlacementByIdPlcmtChild(int idPersonClosed);

  /**
   * Find Placement by IdPlcmtEvent
   * 
   * @param dtDtPlcmtStart
   * @param dtDtPlcmtEnd
   * @param tsLastUpdate
   * @param idPlcmtEvent
   * @return
   */
  Object[] findPlacementByIdPlcmtEvent(Date dtDtPlcmtStart, Date dtDtPlcmtEnd, Date tsLastUpdate, int idPlcmtEvent);

  /**
   * get information displayed for the exchange page by Resource id
   * 
   * @param idResource
   */
  public List<Map> findExchangeHomeInfoByCapsResourceById(int idResource);
  
  /**
   * get Case Manager of Foster Care Child by Resource id
   * 
   * @param idResource
   */
  List<Map> findCaseManagerofFosterCareChildByResourceId(int idResource);
  
  /**
   * get Distinct Case Manager of Foster Care Child by Resource id
   * 
   * @param idResource
   */
  List findDistinctCaseManagerofFosterCareChildByResourceId(int idResource);

  /**
   * Retrieves a list of all children, with their names, placement start date, placed in a specific F/A home where 1)The
   * placement is Actual 2)The placement is still active as of today
   * 
   * @param dtSysDtGenericSysdate
   * @param ulIdRsrcFacil
   * @param cdPlcmtActPlanned
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findPersonsByIdPlcmtChildByCapsResourceByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil,
                                                                 String cdPlcmtActPlanned);

  /**
   * Retrieves the latest approved placement for a child than has not been ended
   * 
   * @param idPerson
   * @param maxDate
   * @return Placement
   */
  Placement findPlacementLatestApprovedByIdPerson(int idPerson, Date maxDate);
  
  /**
   * Find approved placement for a child that is active by a certain date
   * @param idPerson
   * @param maxDate
   * @return
   */
  Placement findActivePlacementByIdPersonByDateByPlcmntType(int idPerson, Date maxDate, String cdPlacementType);

  /**
   * Retrieves the placement history of a child within a case not including the current one
   * 
   * @param idPerson
   * @param idCase
   * @param maxDate
   * @return List<Placement>
   */
  List<Placement> findPlacementHistoryByIdPersonByIdCase(int idCase, int idPerson, Date maxDate);
  
  /**
   * Retrieves the list of actual, approved placements for the given child Id, case Id where the 
   * Placement start date is after the recent removal date of the child and the placement is not
   * Respite Day, Respite Night or Concurrent type. 
   * 
   * @param idPerson
   * @param idCase
   * @return List<Placement>
   */
  List<Placement> findPlacementListByIdCaseByIdPerson(int idCase, int idPerson); 
  
  /**
   * Find approved placement of any type that belongs to CCI Program for a child that is active by a certain date
   * @param idPerson
   * @param maxDate
   * @param List<String>
   * @return
   */
  Placement findActivePlacementByIdPersonByDateByPlcmntTypes(int idPerson, Date maxDate, List<String> cdPlacementTypes);
  
  /**
   * Find an approved placement record with max end date and the end date is one or more days less than the current placement start date.
   * @param idPlcmtChild
   * @param idCase
   * @param dtPlcmtStart
   * @param Object[]
   * @return
   */ 
  Object[] findIdPlcmtEventDtPlcmtEndByMaxDtPlcmtEnd(int idPlcmtChild, int idCase, String dtPlcmtStart);
  
  /**
   * Find an approved placement record with min start date and the start date is one or more days greater than the current placement end date.
   * @param idPlcmtChild
   * @param idCase
   * @param dtPlcmtEnd
   * @param Object[]
   * @return
   */ 
  Object[] findIdPlcmtEventDtPlcmtEndByMinDtPlcmtStart(int idPlcmtChild, int idCase, String dtDtPlcmtEnd);
  
  /**
   * Find an approved placement record with max end date and the end date is one or more days less than the current placement start date.
   * @param idPlcmtChild
   * @param idCase
   * @param dtPlcmtStart
   * @param currPlcmtStart
   * @param Object[]
   * @return
   */ 
  Object[] findPlcmtByDtPlcmtStartIdPersonIdCaseAndCurrPlcmtStart(String dtPlcmtStart, int idPlcmtChild, int idCase,
                                                                   String currPlcmtStart);
  
  /**
   * Find an approved placement record with min start date and the start date is one or more days greater than the current placement end date.
   * @param idPlcmtChild
   * @param idCase
   * @param dtPlcmtEnd
   * @param dtCurrPlcmtEnd
   * @param Object[]
   * @return
   */ 
  Object[] findPlcmtByDtPlcmtEndIdPersonIdCaseDtCurrPlcmtEnd(String dtPlcmtEnd, int idPlcmtChild, int idCase,
                                                             String dtCurrPlcmtEnd);
  
  /**
   * Gets the placement information of the most recent actual,approved adoptive placement for the given stage 
   * and child
   * @param idChild
   * @param idStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  Map findRsrcInfoByIdchildByIdStage(int idChild, int idStage);
  
  /**
   * Gets the placement end date of the earliest actual,approved adoptive placement for the given stage 
   * and child
   * @param idChild
   * @param idStage
   * @return
   */
  Date findPlcmtEndDateByIdChildByStageType(int idChild, String cdStage);
  
  /**
   * Gets the placement end date of the earliest actual,approved adoptive placement with a removal reason 
   * Adoption disruption for the given stage 
   * and child
   * @param idChild
   * @param idStage
   * @return
   */
  Date findAdoDisrPlcmtEndDateByIdChildByStageType(int idChild, String cdStage);
  
  /**
   * Gets the ended placement of the earliest actual,approved adoptive placement for the given stage 
   * and child
   * @param idChild
   * @param idStage
   * @return
   */  
  Placement findEndedPlcmtByIdChildByStageType(int idChild, String cdStage);
  
  
  
  /**
   * Gets the ended placement of the latest actual,approved adoptive placement for the given stage 
   * and child
   * @param idChild
   * @param idStage
   * @return
   */ 
  public Placement findLatestEndedPlcmtByIdChildByStageType(int idChild, String cdStage);
  
  /**
   * Gets the current actual non-concurrent approved placement for the given case and person 
   * and child
   * @param idChild
   * @param idCase
   * @return
   */ 
  @SuppressWarnings( { "unchecked" })
  Placement findLatestApprovedPlacementByIdPersonByIdCase(int idPerson, int idCase, Date maxDate);
  
  /**
   * Gets the current actual non-concurrent approved placement for the given child
   * @param idChild
   * @param maxDate
   * @return
   */ 
  Placement findLatestApprovedPlacementByIdPersonOrderByDtPlcmtStart(int idPerson, Date maxDate);

  // STGAP00017831: MR-102
  // Gets the the most recent, current, actual and approved placement record for the given child
  // who is the Primary Child(PC) of a stage and the Placement Start Date is earlier or equal 
  // to the Begin Date of the earliest Service Authorization Detail for the person receiving services 
  // AND the Placement End Date must be later than the Begin Date of the earliest Service Authorization Detail 
  // for the person receiving services
  /**
   * Gets the current actual non-concurrent approved placement for the given child
   * @param idChild
   * @param maxDate
   * @return
   */ 
  @SuppressWarnings( { "unchecked" })
  Placement findLatestApprovedPlacementByIdPersonBySvcAuthDetail(int idPerson, Date dtSvcAuthDtlBegin);  
  
  /**
   * Gets the current Adoptive placement for the given person and stage
   * @param idPerson
   * @param idStage
   * @return
   */
  Placement findCurrentAdoPlcmtByIdPersonByIdStage(int idPerson, int idStage);
  
  /**
   * Gets the last approved placement for the given person and stage
   * @param idPerson
   * @param idStage
   * @return
   */
  Placement findLastPlcmtByIdPersonByIdStage(int idPerson, int idStage);
  
  /**
   * 
   * Gets latest open or closed approved placement for given idPerson
   * @param idPerson
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  Placement findOpenOrClosedPlacementLatestApprovedByIdPerson(int idPerson );
  
  /** 
   * 41275 : Gets the the most recent actual,approved placement record for the given case and child.
   * @param idPerson
   * @param idCase
   * @return
   */
 Placement findMostRecentPlcmtByIdPersonByIdCase(int idPerson, int idCase);
 
//SMS#51977 : Gets the the most recent actual,approved placement record for the given
 // case and child that is a Trial Home Visit
 Placement findTrialHomeVisitPlacementByIdPersonDtAllegIncident(int idPerson, Date dtAllegedIncident);
  
 /**
  * This method returns a count of placements and In DFCS Custody legal status permutation for specified child
  * where approved actual placement of specified type(s) was active 
  * during the specified start and end date
  * excluding temporary placement types (Respite Day, Respite Night, Concurrent)
  * 
  * @param - idPerson Child SHINES person ID
  * @param - placementTypes List of placement types
  * @param - dtStart Date range start date
  * @param - dtEnd Date range end date
  * @return - Long Count of placements and In DFCS Custody legal status permutation that meet criteria
  */
  Long countActualPlacementsByIdPersonByPlacementTypesDuringStartDateEndDate(int idPerson, List<String> placementTypes, Date dtStart, Date dtEnd);
  
  /**
   * Simple query to find the most recent actual, main placement (not planned, not temporary type of respite day or night, or concurrent)
   * any approval status, closed or open.
   * @param idPerson
   * @param idCase
   * @return Placement
   */
  Placement findMostRecentPlcmtOpenOrClosedByIdPersonByIdCase(int idPerson, int idCase);
  
  /**
   * Retrieve a placement for the victim child.
   * CAPTA 4.3
   * @param dtSysDtGenericSysdate
   * @param idVictimChild
   * @return
   */
  public Placement findCompAprvPlacementsByIdPerson(Date dtSysDtGenericSysdate, int idVictimChild);  
  
  /**
   * Retrieve most recent open placement record for idPerson in the specified case id and stage.
   * @param idPerson
   * @param idCase
   * @param cdStages
   * @return Placement
   */
  Placement findMostRecentPlcmtByIdPersonByIdCaseByCdStages(int idPerson, int idCase, List<String> cdStages);
}