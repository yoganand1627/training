package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * This is the DAO that contains the SQL to save and retrieve placement records to and from the Database. <p/> <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   03/19/08  vdevarak  STGAP00007334: Added this method to retrieve an 
 *                       approved Placement of any placement Type that comes 
 *                       under the CCI Program 
 *                       
 *  03/25/08   vdevarak  STGAP00006420: Added new SQL to retrieve placement  
 *                       records to check gaps between placements. 
 *  06/19/08   ssubram   STGAP00006446: Added new SQL to retrieve distinct
 *                       case managers for the FCC stage  
 *  12/17/08   charden   STGAP00010273: created new method called
 *                       findAprvPlacementsByCapsResourceByIdRsrcFacilByIdPlcmtChild()
 *  01/31/09   wjcochran STGAP00012008: modified findMostRecentPlacementCountyByIdPerson
 *                       to look for the latest APPROVED placement, not just the
 *                       latest placement entry
 *  02/06/09   wjcochran STGAP00011742: modified 
 *                       findPersonsByIdPlcmtChildByCapsResourceByIdRsrcFacil
 *                       to return an idStage that can be used to find PAD stages
 *                       for the Foster Home Re-Evaluation form. Items were added
 *                       to the query but nothing was removed.  
 *  02/25/09   bgehlot   STGAP00012534: Modified findRsrcInfoByIdchildByIdStage to
 *                       return county of the resource also.   
 *  04/20/2009 mxpatel   STGAP00013144: in findExchangeHomeInfoByCapsResourceById method added code to retrieve
 *                       cdPlcmtRemovalRsn field.
 * 
 *  04/22/09   cwells    STGAP00009847: Removing references to AFCARS widgets.  Since those sections
 *                       Are being removed from the page.  
 *  09/01/09   arege     STGAP00014993 Added findOpenOrClosedPlacementLatestApprovedByIdPerson method to get 
 *                       latest open or closed approved placement for a given person.     
 *  09/04/2009 arege     STGAP00014993: Modified findOpenOrClosedPlacementLatestApprovedByIdPerson method as per code review.                 
 *    
 *  09/11/2009 cwells    STGAP00014567: Added method to find the latest actual,approved adoptive placement for the given stage and child   
 *  10/13/2009 pcoogan   STGAP00015531: Updated methods used by Placement Log for ECEM updates and added methods for use by SHINES Portal
 *  11/11/2009 pcoogan   SMS 38894: Updated methods used by Placement Log and SHINES child list to ensure that adopted children are not
 *                       shown for agencies (since placements are open and agency ID remains on placement for converted homes) and never
 *                       shown through the Portal for any PAD stage placement (i.e. finalized adoption).   
 *  11/25/2009  bgehlot  41275 MR-057 Added new fields for APPLA in addComplex, insertPlacementRunaway, 
 *                       insertPlacementNoIdContractAgencyFacilNoWaiver,
 *                       insertPlacementNoIdContractAgencyFacil,insertPlacementNoIdContractAgencyNoWaiver, 
 *                       insertPlacementNoIdContractAgency, insertPlacementNoIdContractNoWaiver, 
 *                       insertPlacementNoIdContract,insertPlacement.
 *                       Added new method findMostRecentPlcmtByIdPersonByIdCase
 *  12/16/2009 wjcochran SMS 37401: Added new method findPlacementByIdRsrcFacilAndOrderByParam. This method
 *                       takes the common logic from findPlacementByIdRsrcFacilAndOrderByDtStart, 
 *                       findPlacementByIdRsrcFacilAndOrderByDtEnd, findPlacementByIdRsrcFacilAndOrderByNmPersonFull,
 *                       findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndAndDtPlcmtStart, and 
 *                       findPlacementByIdRsrcFacilAndOrderByCdPlcmtRemovalRsn. These other methods call the private
 *                       method, passing in the SQL String required for the ORDER BY clause. Also, updated this
 *                       query to pull back Placements that are in PEND status with an end date to ensure
 *                       all previously (and currently) approved placements appear in the placement log.
 *  03/05/2010  mxpatel  SMS #46942: Modified the method - findPlacementByIdPlcmtChildAndPlcmtAcctPlanned to make sure it 
 *                       checks for APROVED ADOPTIVE placement.
 *  03/30/2010 wjcochran SMS #37401: Backed out change to query made on 12/16/2009 due to SMS Problem not being 
 *                       a part of Release 3.5.
 *  05/25/2010  bgehlot  SMS#51977 MR-066 changes
 *  09/09/2010  hnguyen  SMS#66384 Add new method to count active actual placement within a specified period and type
 *  09/15/2010  hnguyen  SMS#71348 MR-067 Modified countActualPlacementsByIdPersonByPlacementTypesDuringStartDateEndDate
 *                       to also account for youth legal status of In DFCS Custody
 *  12/11/2010  htvo     SMS#81140 MR-074 AFCARS Added findMostRecentPlcmtOpenOrClosedByIdPersonByIdCase to find the most recent
 *                       real placement; can be any approval status, active or ended.   
 *  05/24/2011  hjbaptiste SMS#XXXX CAPTA-4.3 Added new method findCompAprvPlacementsByIdResource
 *  06/09/2011  schoi    SMS #109403: MR-082 Added new method findLatestApprovedPlacementByIdPersonOrderByDtPlcmtStart
 *  06/14/2011  hnguyen  SMS #111766: Added new method findMostRecentPlcmtByIdPersonByIdCaseByCdStages 
 *  09/12/2011  charden            STGAP00017058 - created method findActivePlacementByIdPersonsDatePlcmntType() to find active placements on facility
 *  10/24/2011  hnguyen  STGAP00017349: MR-092 Added findLastPlcmtByIdPersonByIdStage.
 *  02/03/2012  schoi    STGAP00017831: MR-102 Added new method findLatestApprovedPlacementByIdPersonBySvcAuthDetail
 *  
 * </pre>
 */
public class PlacementDAOImpl extends BaseDAOImpl implements PlacementDAO {

  public int updateCaseMngrCert(int idPlcmtEvent, String indCertSigned, Date dtCertSigned, String nmCaseMngrRsrc){
    Query query = getSession().createQuery(
                                           "update Placement p "
                                                + " set p.indCaseMngrCert = :indCertSigned, "
                                                + " p.dtCaseMngrCert = :dtCertSigned, "
                                                + " p.nmCaseMngrRsrc = :nmCaseMngrRsrc, "
                                                + " p.idCaseMngrCert = null, "
                                                + " p.idCaseMngrRsrc = null "
                                                + " where p.idPlcmtEvent = :idPlcmtEvent");
    query.setDate("dtCertSigned", dtCertSigned);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    query.setString("indCertSigned", indCertSigned);
    query.setString("nmCaseMngrRsrc", nmCaseMngrRsrc);
    return query.executeUpdate();
  }
  
  public int updateSupCert(int idPlcmtEvent, String indCertSigned, Date dtCertSigned, String nmSupRsrc){
    Query query = getSession().createQuery(
                                           "update Placement p "
                                                + " set p.indSupCert = :indCertSigned, "
                                                + " p.dtSupCert = :dtCertSigned, "
                                                + " p.nmSupRsrc = :nmSupRsrc, "
                                                + " p.idSupCert = null, "
                                                + " p.idSupRsrc = null "
                                                + " where p.idPlcmtEvent = :idPlcmtEvent");
    query.setDate("dtCertSigned", dtCertSigned);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    query.setString("indCertSigned", indCertSigned);
    query.setString("nmSupRsrc", nmSupRsrc);
    return query.executeUpdate();
  }
  
  public int updateDtLastPlcmtLogView(Date dtLastPlcmtLogView, int idPlcmtEvent) {
    Query query = getSession().createQuery(
                                           "update Placement p "
                                                + " set p.dtLastPlcmtLogView = :dtLastPlcmtLogView "
                                                + " where p.idPlcmtEvent = :idPlcmtEvent");
    query.setDate("dtLastPlcmtLogView", dtLastPlcmtLogView);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    return query.executeUpdate();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> findPlcmtTypeByChildStatusForPerDiem(int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.cdPlcmtType as cdPlcmtType, p.indPlcmtEmerg as indPlcmtEmerg, p.contract.idContract as idPlcmtContract, p.dtPlcmtStart as dtPlcmtStart) "
                                                           + "from Placement p "
                                                           + "where p.personByIdPlcmtChild = :idPerson and "
                                                           + "p.cdPlcmtActPlanned = 'A' and "
                                                           + "p.dtPlcmtStart <= sysdate and "
                                                           + "p.dtPlcmtEnd > sysdate and "
                                                           + "(p.indPlcmtEmerg = 'N' or "
                                                           + "(p.cdTempType = 'EMG' or p.cdTempType = 'VOL')) and "
                                                           + "p.event.cdEventStatus = 'APRV'");
    query.setInteger("idPerson", idPerson);

    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPlcmtTypeByChildStatusForPerMonth(int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.cdPlcmtType as cdPlcmtType, p.indPlcmtEmerg as indPlcmtEmerg, p.contract.idContract as idPlcmtContract, p.dtPlcmtStart as dtPlcmtStart) "
                                                           + "from Placement p "
                                                           + "where p.personByIdPlcmtChild = :idPerson and "
                                                           + "p.cdPlcmtActPlanned = 'A' and "
                                                           + "p.dtPlcmtStart <= sysdate and "
                                                           + "p.dtPlcmtEnd > sysdate and "
                                                           + "p.indPlcmtEmerg = 'N' and "
                                                           + "p.event.cdEventStatus = 'APRV'");
    query.setInteger("idPerson", idPerson);

    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonByIdPlcmtChildByCapsResourceByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.personByIdPlcmtChild.idPerson as personByIdPlcmtChild, "
                                                           + "               p.cdPlcmtLivArr as cdPlcmtLivArr) "
                                                           + "  from Placement p "
                                                           + " where p.dtPlcmtStart <= :dtSysDtGenericSysdate "
                                                           + "   and p.capsResourceByIdRsrcFacil.idResource = :ulIdRsrcFacil "
                                                           + "   and p.dtPlcmtEnd > :dtSysDtGenericSysdate");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("ulIdRsrcFacil", ulIdRsrcFacil);

    return (List<Map>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdStageByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil, String cdStatus,
                                                String cdPlcmtActPlanned) {
    Query query = getSession()
                              .createQuery(
                                           "select e.stage.idStage FROM Placement p join p.event e "
                                                           + " WHERE p.capsResourceByIdRsrcFacil.idResource = :ulIdRsrcFacil "
                                                           + " AND p.dtPlcmtEnd > :dtSysDtGenericSysdate "
                                                           + " AND p.cdPlcmtActPlanned = :cdPlcmtActPlanned"
                                                           + " AND e.cdEventStatus = :cdStatus");
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setString("cdStatus", cdStatus);
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("ulIdRsrcFacil", ulIdRsrcFacil);

    return (List<Integer>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findPersonByIdPlcmtChildByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil) {
    Query query = getSession()
                              .createQuery(
                                           "select p.personByIdPlcmtChild.idPerson  "
                                                           + "  from Placement p "
                                                           + " where p.dtPlcmtStart <= :dtSysDtGenericSysdate "
                                                           + "   and p.capsResourceByIdRsrcFacil.idResource = :ulIdRsrcFacil "
                                                           + "   and p.dtPlcmtEnd > :dtSysDtGenericSysdate");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("ulIdRsrcFacil", ulIdRsrcFacil);

    return (List<Integer>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findApprovedCompIdPlcmtChildByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil) {
    Query query = getSession()
                              .createQuery(
                                           "select p.personByIdPlcmtChild.idPerson  "
                                                           + "  from Placement p join p.event e"
                                                           + "  where p.dtPlcmtStart <= :dtSysDtGenericSysdate "
                                                           + "  and p.capsResourceByIdRsrcFacil.idResource = :ulIdRsrcFacil "
                                                           + "  and p.cdPlcmtActPlanned = 'A' "
                                                           + "  and e.cdEventStatus in ('APRV', 'COMP') "
                                                           + "  and p.dtPlcmtEnd > :dtSysDtGenericSysdate");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("ulIdRsrcFacil", ulIdRsrcFacil);

    return (List<Integer>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  // STGAP00008761: Getting placement event id to check and see if that is the current placement record.
  public List<Map> findAprvPlacementsByCapsResourceByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.personByIdPlcmtChild.idPerson as personByIdPlcmtChild, "
                                                           + "    p.idPlcmtEvent as idPlcmtEvent, "
                                                           + "    p.cdPlcmtType as cdPlcmtType, "
                                                           + "    p.cdPlcmtLivArr as cdPlcmtLivArr) "
                                                           + "  from Placement p "
                                                           + " where p.dtPlcmtStart <= :dtSysDtGenericSysdate "
                                                           + "   and p.capsResourceByIdRsrcFacil.idResource = :ulIdRsrcFacil "
                                                           + "   and p.cdPlcmtActPlanned = 'A' "
                                                           + "   and p.dtPlcmtEnd > :dtSysDtGenericSysdate");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("ulIdRsrcFacil", ulIdRsrcFacil);

    return (List<Map>) query.list();

  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Placement> findCompAprvPlacementsByIdResource(Date dtSysDtGenericSysdate, int idRsrcFacil) {
    Query query = getSession()
                              .createQuery(
                                           "from Placement p"
                                                           + " where p.dtPlcmtStart <= :dtSysDtGenericSysdate "
                                                           + "   and (p.capsResourceByIdRsrcFacil.idResource = :idRsrcFacil "
                                                           + " or p.capsResourceByIdRsrcAgency.idResource = :idRsrcFacil) "
                                                           + " AND p.event.cdEventStatus in (:compStatus, :aprvStatus, :pendStatus) "
                                                           + "   and p.cdPlcmtActPlanned = 'A' "
                                                           + "   and p.dtPlcmtEnd > :dtSysDtGenericSysdate");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("aprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);

    return (List<Placement>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findAprvPlacementsByCapsResourceByIdRsrcFacilByIdPlcmtChild(Date dtSysDtGenericSysdate,
                                                                               int ulIdRsrcFacil, String status,
                                                                               int idPlcmtChild) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.personByIdPlcmtChild.idPerson as personByIdPlcmtChild, "
                                                           + "   p.idPlcmtEvent as idPlcmtEvent, "
                                                           + "   p.cdPlcmtType as cdPlcmtType, "
                                                           + "   p.cdPlcmtLivArr as cdPlcmtLivArr) "
                                                           + "   from Placement p "
                                                           + "   where p.dtPlcmtStart <= :dtSysDtGenericSysdate "
                                                           + "   and p.capsResourceByIdRsrcFacil.idResource = :ulIdRsrcFacil "
                                                           + "   and p.event.cdEventStatus = :status "
                                                           + "   and p.cdPlcmtActPlanned = 'A' "
                                                           + "   and p.dtPlcmtEnd > :dtSysDtGenericSysdate "
                                                           + "   and p.personByIdPlcmtChild.idPerson <> :idPlcmtChild ");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setString("status", status);
    query.setInteger("ulIdRsrcFacil", ulIdRsrcFacil);
    query.setInteger("idPlcmtChild", idPlcmtChild);

    return (List<Map>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findIdCaseIdstage(Date dtSysDtGenericSysdate, int ulIdRsrcFacil, String status) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.capsCase.idCase as idCase, e.stage.idStage as idStage) "
                                                           + " from Placement p, Event e "
                                                           + " WHERE p.dtPlcmtStart <= :dtSysDtGenericSysdate "
                                                           + " AND p.dtPlcmtEnd > :dtSysDtGenericSysdate "
                                                           + " AND p.cdPlcmtActPlanned = 'A' "
                                                           + " AND p.capsResourceByIdRsrcFacil.idResource = :ulIdRsrcFacil "
                                                           + " AND p.event.cdEventStatus = :status "
                                                           + " AND p.idPlcmtEvent = e.idEvent "
                                                           + " AND p.cdTempType IS NULL ");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setString("status", status);
    query.setInteger("ulIdRsrcFacil", ulIdRsrcFacil);

    return (List<Map>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdPlcmtEventByDtPlcmtStartAndDtPlcmtEnd(int idCase, int idPlcmtChild,
                                                                   String cdPlcmtActPlanned, Date dtPlcmtStart,
                                                                   Date dtPlcmtEnd) {
    Query query = getSession()
                              .createQuery(
                                           "select p.idPlcmtEvent "
                                                           + "  from Placement p "
                                                           + "  join p.event e "
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and e.idEvent = p.idPlcmtEvent "
                                                           + "   and p.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and trunc(p.dtPlcmtStart) <= trunc(:dtPlcmtStart) "
                                                           + "   and trunc(p.dtPlcmtEnd) >= trunc(:dtPlcmtEnd) "
                                                           + "   and not (:dtPlcmtStart = :dtPlcmtEnd "
                                                           + "            and (trunc(p.dtPlcmtStart) = trunc(:dtPlcmtStart) "
                                                           + "                 or trunc(p.dtPlcmtEnd) = trunc(:dtPlcmtEnd)))");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setDate("dtPlcmtStart", dtPlcmtStart);
    query.setDate("dtPlcmtEnd", dtPlcmtEnd);

    return (List<Integer>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdPlcmtEventByDtPlcmtStart(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                      Date dtPlcmtStart, Date dtPlcmtEnd) {
    Query query = getSession().createQuery(
                                           "select p.idPlcmtEvent " + "  from Placement p " + "  join p.event e "
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and p.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and trunc(p.dtPlcmtStart) > trunc(:dtPlcmtStart) "
                                                           + "   and trunc(p.dtPlcmtStart) < trunc(:dtPlcmtEnd)");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setDate("dtPlcmtStart", dtPlcmtStart);
    query.setDate("dtPlcmtEnd", dtPlcmtEnd);

    return (List<Integer>) query.list();

  }

  public long countPlacementByMaxDate(int idPlcmtEvent) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from Placement p "
                                                           + " where p.idPlcmtEvent = :idPlcmtEvent "
                                                           + "   and (p.dtPlcmtEnd IS NULL "
                                                           + "   OR p.dtPlcmtEnd = '12/31/4712')");
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    return (Long) query.uniqueResult();
  }

  public long countFemalesPersonByIdRrscAgencyListByIdRsrcFacil(List<Integer> idRrscFacilList,
                                                                List<Integer> idRrscAgencyList) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, Person b"
                                                           + "   join p.event e"
                                                           + "   join e.stage s "
                                                           + "   where ((p.capsResourceByIdRsrcFacil.idResource in (:idRrscFacilList))"
                                                           + "   or ((p.capsResourceByIdRsrcAgency.idResource  in (:idRrscAgencyList)) and (s.cdStage <> :PAD)))"
                                                           + "   AND b.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "   AND b.cdPersonSex = :gender"
                                                           + "   AND (e.cdEventStatus = :apprvStatus or e.cdEventStatus = :compStatus or e.cdEventStatus = :pendStatus)"
                                                           + "   AND p.dtPlcmtEnd > sysdate) ");

    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.setString("gender", CodesTables.CSEX_F);
    query.setString("apprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);
    query.setString("PAD", CodesTables.CSTAGES_PAD);
    return (Long) query.uniqueResult();

  }

  public long countMalesPersonByIdRrscAgencyListByIdRsrcFacil(List<Integer> idRrscFacilList,
                                                              List<Integer> idRrscAgencyList) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, Person b"
                                                           + "   join p.event e"
                                                           + "   join e.stage s "
                                                           + "   where ((p.capsResourceByIdRsrcFacil.idResource in (:idRrscFacilList))"
                                                           + "   or ((p.capsResourceByIdRsrcAgency.idResource  in (:idRrscAgencyList)) and (s.cdStage <> :PAD)))"
                                                           + "   AND b.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "   AND b.cdPersonSex = :gender"
                                                           + "   AND (e.cdEventStatus = :apprvStatus or e.cdEventStatus = :compStatus or e.cdEventStatus = :pendStatus)"
                                                           + "   AND p.dtPlcmtEnd > sysdate) ");

    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.setString("gender", CodesTables.CSEX_M);
    query.setString("apprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);
    query.setString("PAD", CodesTables.CSTAGES_PAD);
    return (Long) query.uniqueResult();

  }

  public long countChildrenUnder3PersonByIdRrscAgencyListByIdRsrcFacil(List<Integer> idRrscFacilList,
                                                                       List<Integer> idRrscAgencyList) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, Person b"
                                                           + "   join p.event e "
                                                           + "   join e.stage s "
                                                           + "   where ((p.capsResourceByIdRsrcFacil.idResource in (:idRrscFacilList))"
                                                           + "   or ((p.capsResourceByIdRsrcAgency.idResource  in (:idRrscAgencyList)) and (s.cdStage <> :PAD)))"
                                                           + "   AND b.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "   AND months_between(sysdate, b.dtPersonBirth)< :age3 "
                                                           + "   AND (e.cdEventStatus = :apprvStatus or e.cdEventStatus = :compStatus or e.cdEventStatus = :pendStatus)"
                                                           + "   AND p.dtPlcmtEnd > sysdate) ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.setString("apprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);
    query.setString("PAD", CodesTables.CSTAGES_PAD);
    query.setInteger("age3", 36);
    return (Long) query.uniqueResult();

  }

  public long countChildrenOver16PersonByIdRrscAgencyListByIdRsrcFacil(List<Integer> idRrscFacilList,
                                                                       List<Integer> idRrscAgencyList) {

    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, Person b"
                                                           + "   join p.event e "
                                                           + "   join e.stage s "
                                                           + "   where ((p.capsResourceByIdRsrcFacil.idResource in (:idRrscFacilList))"
                                                           + "   or ((p.capsResourceByIdRsrcAgency.idResource  in (:idRrscAgencyList)) and (s.cdStage <> :PAD)))"
                                                           + "   AND b.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "   AND months_between(sysdate, b.dtPersonBirth)>= :age16 "
                                                           + "   AND (e.cdEventStatus = :apprvStatus or e.cdEventStatus = :compStatus or e.cdEventStatus = :pendStatus)"
                                                           + "   AND p.dtPlcmtEnd > sysdate) ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.setString("apprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);
    query.setString("PAD", CodesTables.CSTAGES_PAD);
    query.setInteger("age16", 204);
    return (Long) query.uniqueResult();

  }

  public long countFemalesPersonByIdRrscAgencyListByIdRsrcFacilPortal(List<Integer> idRrscFacilList,
                                                                      List<Integer> idRrscAgencyList) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, Person b"
                                                           + "   join p.event e"
                                                           + "   join e.stage s "
                                                           + "   where ((p.capsResourceByIdRsrcFacil.idResource in (:idRrscFacilList)) or (p.capsResourceByIdRsrcAgency.idResource  in (:idRrscAgencyList))) "
                                                           + "   and s.cdStage <> :PAD "
                                                           + "   AND b.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "   AND b.cdPersonSex = :gender"
                                                           + "   AND (e.cdEventStatus = :apprvStatus or e.cdEventStatus = :compStatus or e.cdEventStatus = :pendStatus)"
                                                           + "   AND p.dtPlcmtEnd > sysdate) ");

    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.setString("gender", CodesTables.CSEX_F);
    query.setString("apprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);
    query.setString("PAD", CodesTables.CSTAGES_PAD);
    return (Long) query.uniqueResult();

  }

  public long countMalesPersonByIdRrscAgencyListByIdRsrcFacilPortal(List<Integer> idRrscFacilList,
                                                                    List<Integer> idRrscAgencyList) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, Person b"
                                                           + "   join p.event e"
                                                           + "   join e.stage s "
                                                           + "   where ((p.capsResourceByIdRsrcFacil.idResource in (:idRrscFacilList)) or (p.capsResourceByIdRsrcAgency.idResource  in (:idRrscAgencyList))) "
                                                           + "   and s.cdStage <> :PAD "
                                                           + "   AND b.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "   AND b.cdPersonSex = :gender"
                                                           + "   AND (e.cdEventStatus = :apprvStatus or e.cdEventStatus = :compStatus or e.cdEventStatus = :pendStatus)"
                                                           + "   AND p.dtPlcmtEnd > sysdate) ");

    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.setString("gender", CodesTables.CSEX_M);
    query.setString("apprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);
    query.setString("PAD", CodesTables.CSTAGES_PAD);
    return (Long) query.uniqueResult();

  }

  public long countChildrenUnder3PersonByIdRrscAgencyListByIdRsrcFacilPortal(List<Integer> idRrscFacilList,
                                                                             List<Integer> idRrscAgencyList) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, Person b"
                                                           + "   join p.event e "
                                                           + "   join e.stage s "
                                                           + "   where ((p.capsResourceByIdRsrcFacil.idResource in (:idRrscFacilList)) or (p.capsResourceByIdRsrcAgency.idResource  in (:idRrscAgencyList))) "
                                                           + "   and s.cdStage <> :PAD "
                                                           + "   AND b.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "   AND months_between(sysdate, b.dtPersonBirth)< :age3 "
                                                           + "   AND (e.cdEventStatus = :apprvStatus or e.cdEventStatus = :compStatus or e.cdEventStatus = :pendStatus)"
                                                           + "   AND p.dtPlcmtEnd > sysdate) ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.setString("apprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);
    query.setString("PAD", CodesTables.CSTAGES_PAD);
    query.setInteger("age3", 36);
    return (Long) query.uniqueResult();

  }

  public long countChildrenOver16PersonByIdRrscAgencyListByIdRsrcFacilPortal(List<Integer> idRrscFacilList,
                                                                             List<Integer> idRrscAgencyList) {

    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, Person b"
                                                           + "   join p.event e "
                                                           + "   join e.stage s "
                                                           + "   where ((p.capsResourceByIdRsrcFacil.idResource in (:idRrscFacilList)) or (p.capsResourceByIdRsrcAgency.idResource  in (:idRrscAgencyList))) "
                                                           + "   and s.cdStage <> :PAD "
                                                           + "   AND b.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "   AND months_between(sysdate, b.dtPersonBirth)>= :age16 "
                                                           + "   AND (e.cdEventStatus = :apprvStatus or e.cdEventStatus = :compStatus or e.cdEventStatus = :pendStatus)"
                                                           + "   AND p.dtPlcmtEnd > sysdate) ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.setString("apprvStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("pendStatus", CodesTables.CEVTSTAT_PEND);
    query.setString("PAD", CodesTables.CSTAGES_PAD);
    query.setInteger("age16", 204);
    return (Long) query.uniqueResult();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdPlcmtEventByDtPlcmtEnd(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                    Date dtPlcmtStart, Date dtPlcmtEnd) {
    Query query = getSession().createQuery(
                                           "select p.idPlcmtEvent " + "  from Placement p " + "  join p.event e "
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and p.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and trunc(p.dtPlcmtEnd) > trunc(:dtPlcmtStart) "
                                                           + "   and trunc(p.dtPlcmtEnd) < trunc(:dtPlcmtEnd)");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setDate("dtPlcmtStart", dtPlcmtStart);
    query.setDate("dtPlcmtEnd", dtPlcmtEnd);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdPlcmtEventByPersonByIdPlcmtChild(int idCase, int idPlcmtChild, String cdPlcmtActPlanned) {
    Query query = getSession().createQuery(
                                           "select p.idPlcmtEvent " + "  from Placement p " + "  join p.event e "
                                                           + " where  p.capsCase.idCase = :idCase "
                                                           + " and p.capsCase.idCase = e.capsCase.idCase "
                                                           + " and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + " and p.cdPlcmtActPlanned = :cdPlcmtActPlanned");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    return (List<Integer>) query.list();
  }

  public long countPersonByIdPlcmtChildByIdCase(int idCase, int idPlcmtChild) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from Placement p " + "  join p.event e "
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    return (Long) query.uniqueResult();

  }
  
  
  public Placement findPlcmtByIdPlcmtChildByIdCaseNonRes(int idCase, int idPlcmtChild, List<String> excludeTypes, Date dtEvalDate) {
    Query query = getSession().createQuery(
                                           "  From Placement p " 
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and (p.cdTempType not in ( :excludeTypes) "
                                                           + "   or p.cdTempType is null) "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and p.dtPlcmtEnd > :dtEvalDate "
                                                           + "   and p.dtPlcmtStart < :dtEvalDate "
                                                           + "   order by p.dtLastUpdate");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setTimestamp("dtEvalDate", dtEvalDate);
    query.setParameterList("excludeTypes", excludeTypes);
    return (Placement) firstResult(query);

  }

  public Date findMostRecentPlacementByIdPerson(int idPlcmtChild) {
    Query query = getSession()
                              .createQuery(
                                           "select p.dtPlcmtEnd "
                                                           + "   from Placement p "
                                                           + "  where p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "    and p.dtPlcmtEnd = (select max(p2.dtPlcmtEnd) "
                                                           + "                          from Placement p2 "
                                                           + "                         where p2.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "                           and p2.cdPlcmtActPlanned = 'A' "
                                                           + "                           and p2.cdPlcmtRemovalRsn in (select ct1.id.code "
                                                           + "                                                          from CodesTables ct1 "
                                                           + "                                                         where ct1.id.codeType = '"
                                                           + CodesTables.CDISCHRG
                                                           + "')) "
                                                           + "    and p.cdPlcmtActPlanned = 'A' "
                                                           + "    and p.cdPlcmtRemovalRsn in (select ct2.id.code "
                                                           + "                                  from CodesTables ct2 "
                                                           + "                                 where ct2.id.codeType = '"
                                                           + CodesTables.CDISCHRG + "') ");

    query.setInteger("idPlcmtChild", idPlcmtChild);
    return (Date) firstResult(query);
  }

  public String findMostRecentPlacementCountyByIdPerson(int idPlcmtChild) {
    Query query = getSession()
                              .createQuery(
                                           "select p.cdBoardingCnty "
                                                           + "   from Placement p "
                                                           + "join p.event e"
                                                           + "  where p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "    and p.dtPlcmtEnd = (select max(p2.dtPlcmtEnd) "
                                                           + "                          from Placement p2 "
                                                           + "                         where p2.personByIdPlcmtChild.idPerson = :idPlcmtChild) "
                                                           + "    and p.idPlcmtEvent = e.idEvent "
                                                           + "    and e.cdEventStatus = '" + CodesTables.CEVTSTAT_APRV
                                                           + "'");

    query.setInteger("idPlcmtChild", idPlcmtChild);
    return (String) firstResult(query);
  }

  public long countPlacementForStageClosed(int idStage) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from Placement p, "
                                                           + "       CapsResource c "
                                                           + " where c.stage.idStage = :idStage "
                                                           + "   and c.idResource = p.capsResourceByIdRsrcFacil.idResource "
                                                           + "   and p.dtPlcmtEnd = :dtMaxDate ");

    query.setInteger("idStage", idStage);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);

    return (Long) query.uniqueResult();
  }

  public Placement findPlacementByIdPlcmtEvent(int idPlcmtEvent) {
    Query query = getSession().createQuery("FROM Placement p WHERE p.idPlcmtEvent = :idPlcmtEvent");
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    return (Placement) firstResult(query);
  }

  // STGAP00006420:Added Sql as part of Overlap clean up.
  public Object[] findPlacementByIdPlcmtEvent(int idPlcmtEvent, String tsLastUpdate) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT P.DT_PLCMT_START AS dtPlcmtStart, "
                                                                 + " P.DT_PLCMT_END AS dtPlcmtEnd "
                                                                 + " FROM PLACEMENT P "
                                                                 + " WHERE P.ID_PLCMT_EVENT = :idPlcmtEvent "
                                                                 + " AND P.DT_LAST_UPDATE = TO_DATE(:tsLastUpdate, 'MM/dd/yyyy hh24:mi:ss') ");
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    query.setString("tsLastUpdate", tsLastUpdate);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Placement findPlacementByIdPlcmtChildDtPlcmtStart(int idPlcmtChild) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + "where p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "  and p.dtPlcmtStart = (select max(p2.dtPlcmtStart) "
                                                           + "                         from Placement p2 "
                                                           + "                         where p2.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "                           and p2.cdPlcmtActPlanned = 'A' "
                                                           + "                           and p.dtPlcmtEnd = (select max(p3.dtPlcmtStart) "
                                                           + "                                                 from Placement p3 "
                                                           + "                                                where p3.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "                                                  and p3.cdPlcmtActPlanned = 'A') "
                                                           + "                           and p.cdPlcmtActPlanned = 'A') ");
    query.setInteger("idPlcmtChild", idPlcmtChild);
    return (Placement) firstResult(query);
  }

  public Placement findPlacementByIdPlcmtChildAndPlcmtAcctPlanned(int personByIdPlcmtChild, Date dtScrDtLastUpdate) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String cdEventType = CodesTables.CPLMNTYP_ADH;
    Query query = getSession().createQuery(
                                           " select p " + "  from Placement p, Event e "
                                                           + "  where  p.event.idEvent = e.idEvent "
                                                           + "  and p.personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "  and p.dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "  and p.dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "  and p.dtPlcmtStart <> p.dtPlcmtEnd "
                                                           + "  and p.cdPlcmtType = :cdEventType "
                                                           + "  and p.cdPlcmtActPlanned = 'A' "
                                                           + "  and e.cdEventStatus = :cdEventStatus "
                                                           + "  and p.idPlcmtEvent = (select max(p1.idPlcmtEvent) "
                                                           + "  from Placement p1, Event e1 "
                                                           + "  where  p1.event.idEvent = e1.idEvent "
                                                           + "  and p1.personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "  and p1.dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "  and p1.dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "  and p1.dtPlcmtStart <> p1.dtPlcmtEnd "
                                                           + "  and p1.cdPlcmtType = :cdEventType "
                                                           + "  and p1.cdPlcmtActPlanned = 'A' "
                                                           + "  and e1.cdEventStatus = :cdEventStatus "
                                                           + "  and p1.dtPlcmtStart = (select max(p2.dtPlcmtStart) "
                                                           + "  from Placement p2, Event e2 "
                                                           + "  where  p2.event.idEvent = e2.idEvent "
                                                           + "  and p2.personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "  and p2.dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "  and p2.dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "  and p2.dtPlcmtStart <> p2.dtPlcmtEnd "
                                                           + "  and p2.cdPlcmtType = :cdEventType "
                                                           + "  and e2.cdEventStatus = :cdEventStatus "
                                                           + "  and p2.cdPlcmtActPlanned = 'A'))");
    query.setInteger("personByIdPlcmtChild", personByIdPlcmtChild);
    query.setTimestamp("dtScrDtLastUpdate", dtScrDtLastUpdate);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    return (Placement) firstResult(query);
  }

  public Placement findPlacementByIdPlcmtChildAndPlcmtAcctPlannedAndCase(int personByIdPlcmtChild,
                                                                         Date dtScrDtLastUpdate, int idCase) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement "
                                                           + "where personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "  and dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "  and dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "  and dtPlcmtStart <> dtPlcmtEnd "
                                                           + "  and cdPlcmtActPlanned = 'A' "
                                                           + "  and idPlcmtEvent = (select max(idPlcmtEvent) "
                                                           + "                        from Placement "
                                                           + "                       where personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "                         and dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "                         and dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "                         and dtPlcmtStart <> dtPlcmtEnd "
                                                           + "                         and cdPlcmtActPlanned = 'A' "
                                                           + "                         and capsCase.idCase = :idCase "
                                                           + "                         and dtPlcmtStart = (select max(dtPlcmtStart) "
                                                           + "                                               from Placement "
                                                           + "                                              where personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "                                                and dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "                                                and dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "                                                and dtPlcmtStart <> dtPlcmtEnd "
                                                           + "                                                and cdPlcmtActPlanned = 'A'))");
    query.setInteger("personByIdPlcmtChild", personByIdPlcmtChild);
    query.setInteger("idCase", idCase);
    query.setTimestamp("dtScrDtLastUpdate", dtScrDtLastUpdate);
    return (Placement) firstResult(query);
  }

  public Placement findPlacementByIdPlcmtChildAndPlcmtAcctPlannedAndStage(int personByIdPlcmtChild,
                                                                          Date dtScrDtLastUpdate, int idStage) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p1 "
                                                           + "where p1.personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "  and p1.dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "  and p1.dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "  and p1.dtPlcmtStart <> p1.dtPlcmtEnd "
                                                           + "  and p1.cdPlcmtActPlanned = 'A' "
                                                           + "  and p1.idPlcmtEvent = (select max(p2.idPlcmtEvent) "
                                                           + "                         from Placement p2, Event e2 "
                                                           + "                         where p2.personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "                         and p2.idPlcmtEvent = e2.idEvent "
                                                           + "                         and e2.stage.idStage = :idStage "
                                                           + "                         and p2.dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "                         and p2.dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "                         and p2.dtPlcmtStart <> p2.dtPlcmtEnd "
                                                           + "                         and p2.cdPlcmtActPlanned = 'A' "
                                                           + "                         and p2.dtPlcmtStart = (select max(p3.dtPlcmtStart) "
                                                           + "                                               from Placement p3, Event e3 "
                                                           + "                                                where p3.personByIdPlcmtChild = :personByIdPlcmtChild "
                                                           + "                                                and p3.idPlcmtEvent = e3.idEvent "
                                                           + "                                                and e3.stage.idStage = :idStage "
                                                           + "                                                and p3.dtPlcmtStart <= :dtScrDtLastUpdate "
                                                           + "                                                and p3.dtPlcmtEnd >= :dtScrDtLastUpdate "
                                                           + "                                                and p3.dtPlcmtStart <> p3.dtPlcmtEnd "
                                                           + "                                                and p3.cdPlcmtActPlanned = 'A'))");
    query.setInteger("personByIdPlcmtChild", personByIdPlcmtChild);
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtScrDtLastUpdate", dtScrDtLastUpdate);
    return (Placement) firstResult(query);
  }

  public Placement findPlacementByIdPlcmtChildAndServAuthEffDt(int idPlcmtChild, Date dtServAuthEffectiveDt) {
    Query query = getSession()
                              .createQuery(
                                           "  from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and p.cdPlcmtLivArr = 'DD' "
                                                           + "   and p.dtPlcmtStart <= :dtServAuthEffectiveDt "
                                                           + "   and p.dtPlcmtStart <> p.dtPlcmtEnd "
                                                           + "   and p.cdPlcmtActPlanned = 'A' "
                                                           + "   and p.idPlcmtEvent = (select max(p1.personByIdPlcmtChild) "
                                                           + "                           from Placement p1 "
                                                           + "                          where p1.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "                            and p1.dtPlcmtStart <= :dtServAuthEffectiveDt "
                                                           + "                            and p1.dtPlcmtStart <> p1.dtPlcmtEnd "
                                                           + "                            and p1.cdPlcmtLivArr = 'DD' "
                                                           + "                            and p1.cdPlcmtActPlanned = 'A' "
                                                           + "                            and p.dtPlcmtStart = (select max(p1.dtPlcmtStart) "
                                                           + "                                                    from Placement p1 "
                                                           + "                                                   where p1.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "                                                     and p1.dtPlcmtStart <= :dtServAuthEffectiveDt "
                                                           + "                                                     and p1.dtPlcmtStart <> p1.dtPlcmtEnd "
                                                           + "                                                     and p1.cdPlcmtLivArr = 'DD' "
                                                           + "                                                     and p1.cdPlcmtActPlanned = 'A'))");
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setTimestamp("dtServAuthEffectiveDt", dtServAuthEffectiveDt);
    return (Placement) firstResult(query);
  }

  public long countPlacementByIdEvent(int idEvent) {

    Query query = getSession().createQuery(
                                           "select count(*) " + "  from Placement p "
                                                           + " where p.idPlcmtEvent = :idEvent "
                                                           + "   and (p.dtPlcmtEnd IS NULL "
                                                           + "   OR p.dtPlcmtEnd = '12/31/4712')");

    query.setInteger("idEvent", idEvent);
    return (Long) query.uniqueResult();
  }

  // STGAP00006420:Modified the signature of the sql and added code as part of the overlap messages clean up.
  // The return list will now return a map instead of an integer. The map contains placement evnet Id and the temporary
  // type.
  @SuppressWarnings( { "unchecked" })
  public List<Map> findIdPlacmtEventByIdPlcmtChildNoOverlap(int idCase, int idPlcmtChild, String cdPlcmtActPlanned,
                                                            Date dtPlcmtStart, Date dtPlcmtEnd) {
    Query query = getSession().createQuery(
                                           "select new map(p.idPlcmtEvent as idPlcmtEvent, p.cdTempType as cdTempType) "
                                                           + "  from Placement p " + "  join p.event e "
                                                           + " where p.capsCase.idCase = :idCase "
                                                           + "   and p.capsCase.idCase = e.capsCase.idCase "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idPlcmtChild "
                                                           + "   and e.idEvent = p.idPlcmtEvent "
                                                           + "   and p.cdPlcmtActPlanned = :cdPlcmtActPlanned "
                                                           + "   and trunc(p.dtPlcmtEnd) > trunc(:dtPlcmtStart) "
                                                           + "   and trunc(p.dtPlcmtEnd) <= trunc(:dtPlcmtEnd) "
                                                           + "   and trunc(p.dtPlcmtStart) <> trunc(p.dtPlcmtEnd)");
    query.setInteger("idCase", idCase);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);

    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndAndDtPlcmtStart(
                                                                                                        List<Integer> idRrscFacilList,
                                                                                                        List<Integer> idRrscAgencyList,
                                                                                                        int pageNbr,
                                                                                                        int pageSize) {
    final String ORDER_BY_DT_END_AND_DT_START = " A.DT_PLCMT_END DESC, " + "          A.DT_PLCMT_START DESC ";

    return findPlacementByIdRsrcFacilAndOrderByParam(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize,
                                                     ORDER_BY_DT_END_AND_DT_START);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtStart(
                                                                                           List<Integer> idRrscFacilList,
                                                                                           List<Integer> idRrscAgencyList,
                                                                                           int pageNbr, int pageSize) {
    final String ORDER_BY_DT_START = " A.DT_PLCMT_START DESC ";

    return findPlacementByIdRsrcFacilAndOrderByParam(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize,
                                                     ORDER_BY_DT_START);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtEnd(
                                                                                         List<Integer> idRrscFacilList,
                                                                                         List<Integer> idRrscAgencyList,
                                                                                         int pageNbr, int pageSize) {
    final String ORDER_BY_DT_END = " A.DT_PLCMT_END DESC ";

    return findPlacementByIdRsrcFacilAndOrderByParam(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize,
                                                     ORDER_BY_DT_END);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByNmPersonFull(
                                                                                           List<Integer> idRrscFacilList,
                                                                                           List<Integer> idRrscAgencyList,
                                                                                           int pageNbr, int pageSize) {
    final String ORDER_BY_NM_PERSON_FULL = " B.NM_PERSON_FULL ";

    return findPlacementByIdRsrcFacilAndOrderByParam(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize,
                                                     ORDER_BY_NM_PERSON_FULL);

  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByCdPlcmtRemovalRsn(
                                                                                                List<Integer> idRrscFacilList,
                                                                                                List<Integer> idRrscAgencyList,
                                                                                                int pageNbr,
                                                                                                int pageSize) {
    final String ORDER_BY_REMOVAL_RSN = " A.CD_PLCMT_REMOVAL_RSN ";

    return findPlacementByIdRsrcFacilAndOrderByParam(idRrscFacilList, idRrscAgencyList, pageNbr, pageSize,
                                                     ORDER_BY_REMOVAL_RSN);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndAndDtPlcmtStartPortal(
                                                                                                              List<Integer> idRrscFacilList,
                                                                                                              List<Integer> idRrscAgencyList,
                                                                                                              int pageNbr,
                                                                                                              int pageSize) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "   SELECT A.DT_PLCMT_START as dtPlcmtStart, "
                                                                 + "          A.DT_PLCMT_END as dtPlcmtEnd, "
                                                                 + "          A.CD_PLCMT_REMOVAL_RSN as cdPlcmtRemovalRsn, "
                                                                 + "          B.ID_PERSON as idPerson, "
                                                                 + "          B.NM_PERSON_FULL as nmPersonFull, "
                                                                 + "          B.DT_PERSON_BIRTH as dtPersonBirth, "
                                                                 + "          L.CD_LEGAL_STAT_STATUS as cdLegalStatStatus, "
                                                                 + "          A.ID_CASE as idCase, "
                                                                 + "          B.CD_PERSON_SEX as cdPersonSex, "
                                                                 + "          B.NBR_PERSON_AGE as nbrPersonAge, "
                                                                 + "          A.CD_PLCMT_TYPE as cdPlcmtType, "
                                                                 + "          L.CD_LEGAL_STAT_CNTY as cdLegalStatCnty, "
                                                                 + "          A.CD_PLCMT_SIBLING as cdPlcmtSibling, "
                                                                 + "          S.ID_STAGE as idStage, "
                                                                 + "          S.IND_STAGE_SEALED as indStageSealed, "
                                                                 + "          A.ID_RSRC_FACIL as idRsrcFacil, "
                                                                 + "          A.ID_RSRC_AGENCY as idRsrcAgency, "
                                                                 + "          A.NM_PLCMT_FACIL as nmPlcmtFacil, "
                                                                 + "          A.CD_TEMP_TYPE as cdTempType, "
                                                                 + "          A.ID_PLCMT_EVENT as idPlcmtEvent"
                                                                 + "     FROM PLACEMENT A, "
                                                                 + "          PERSON B, "
                                                                 + "          Event E, "
                                                                 + "          Stage S,"
                                                                 + "          LEGAL_STATUS L, "
                                                                 + "          (   SELECT MAX (L2.DT_LEGAL_STAT_STATUS_DT) as legal_status_date, "
                                                                 + "                     B2.ID_PERSON as id_person "
                                                                 + "                FROM LEGAL_STATUS L2, PERSON B2, PLACEMENT A2 "
                                                                 + "               WHERE (A2.ID_RSRC_FACIL IN (:idRrscFacilList)  OR A2.ID_RSRC_AGENCY IN (:idRrscAgencyList)) "
                                                                 + "                 AND A2.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                 AND B2.ID_PERSON = A2.ID_PLCMT_CHILD "
                                                                 + "                 AND B2.ID_PERSON = L2.ID_PERSON "
                                                                 + "            GROUP BY B2.ID_PERSON  ) max_legal_status "
                                                                 + "    WHERE (A.ID_RSRC_FACIL IN (:idRrscFacilList)  OR A.ID_RSRC_AGENCY IN (:idRrscAgencyList)) "
                                                                 + "      AND A.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "      AND B.ID_PERSON = A.ID_PLCMT_CHILD "
                                                                 + "      AND E.ID_EVENT = A.ID_PLCMT_EVENT "
                                                                 + "      AND (E.CD_EVENT_STATUS = 'APRV' or E.CD_EVENT_STATUS = 'COMP' or E.CD_EVENT_STATUS = 'PEND') "
                                                                 + "      AND S.CD_STAGE <> 'PAD' "
                                                                 + "      AND E.ID_EVENT_STAGE = S.ID_STAGE "
                                                                 + "      AND B.ID_PERSON = L.ID_PERSON(+) "
                                                                 + "      AND NVL(L.DT_LEGAL_STAT_STATUS_DT,sysdate+1) = NVL(max_legal_status.legal_status_date,sysdate+1) "
                                                                 + "      AND B.ID_PERSON = max_legal_status.id_person(+) "
                                                                 + "      AND ((SYSDATE - A.DT_PLCMT_END) <= 30) "
                                                                 + " ORDER BY A.DT_PLCMT_END DESC, "
                                                                 + "          A.DT_PLCMT_START DESC ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    query.addScalar("cdPlcmtRemovalRsn", Hibernate.STRING);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("dtPersonBirth", Hibernate.DATE);
    query.addScalar("cdLegalStatStatus", Hibernate.STRING);
    query.addScalar("idCase", Hibernate.INTEGER);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("nbrPersonAge", Hibernate.INTEGER);
    query.addScalar("cdPlcmtType", Hibernate.STRING);
    query.addScalar("cdLegalStatCnty", Hibernate.STRING);
    query.addScalar("cdPlcmtSibling", Hibernate.STRING);
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("indStageSealed", Hibernate.STRING);
    query.addScalar("idRsrcFacil", Hibernate.INTEGER);
    query.addScalar("idRsrcAgency", Hibernate.INTEGER);
    query.addScalar("nmPlcmtFacil", Hibernate.STRING);
    query.addScalar("cdTempType", Hibernate.STRING);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtStartPortal(
                                                                                                 List<Integer> idRrscFacilList,
                                                                                                 List<Integer> idRrscAgencyList,
                                                                                                 int pageNbr,
                                                                                                 int pageSize) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "  SELECT A.DT_PLCMT_START as dtPlcmtStart, "
                                                                 + "         A.DT_PLCMT_END as dtPlcmtEnd, "
                                                                 + "         A.CD_PLCMT_REMOVAL_RSN as cdPlcmtRemovalRsn, "
                                                                 + "         B.ID_PERSON as idPerson, "
                                                                 + "         B.NM_PERSON_FULL as nmPersonFull, "
                                                                 + "         B.DT_PERSON_BIRTH as dtPersonBirth, "
                                                                 + "         L.CD_LEGAL_STAT_STATUS as cdLegalStatStatus, "
                                                                 + "         A.ID_CASE as idCase, "
                                                                 + "         B.CD_PERSON_SEX as cdPersonSex, "
                                                                 + "         B.NBR_PERSON_AGE as nbrPersonAge, "
                                                                 + "         A.CD_PLCMT_TYPE as cdPlcmtType, "
                                                                 + "         L.CD_LEGAL_STAT_CNTY as cdLegalStatCnty, "
                                                                 + "         A.CD_PLCMT_SIBLING as cdPlcmtSibling, "
                                                                 + "         S.ID_STAGE as idStage, "
                                                                 + "         S.IND_STAGE_SEALED as indStageSealed, "
                                                                 + "         A.ID_RSRC_FACIL as idRsrcFacil, "
                                                                 + "         A.ID_RSRC_AGENCY as idRsrcAgency, "
                                                                 + "         A.NM_PLCMT_FACIL as nmPlcmtFacil, "
                                                                 + "         A.CD_TEMP_TYPE as cdTempType, "
                                                                 + "         A.ID_PLCMT_EVENT as idPlcmtEvent"
                                                                 + "    FROM PLACEMENT A, "
                                                                 + "         PERSON B, "
                                                                 + "          Event E, "
                                                                 + "          Stage S,"
                                                                 + "         LEGAL_STATUS L, "
                                                                 + "         (   SELECT MAX (L2.DT_LEGAL_STAT_STATUS_DT) as legal_status_date, "
                                                                 + "                    B2.ID_PERSON as id_person "
                                                                 + "               FROM LEGAL_STATUS L2, PERSON B2, PLACEMENT A2 "
                                                                 + "              WHERE (A2.ID_RSRC_FACIL IN (:idRrscFacilList)  OR A2.ID_RSRC_AGENCY IN (:idRrscAgencyList)) "
                                                                 + "                AND A2.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                AND B2.ID_PERSON = A2.ID_PLCMT_CHILD "
                                                                 + "                AND B2.ID_PERSON = L2.ID_PERSON "
                                                                 + "           GROUP BY B2.ID_PERSON  ) max_legal_status "
                                                                 + "   WHERE (A.ID_RSRC_FACIL IN (:idRrscFacilList)  OR A.ID_RSRC_AGENCY IN (:idRrscAgencyList))"
                                                                 + "     AND A.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "     AND B.ID_PERSON = A.ID_PLCMT_CHILD "
                                                                 + "      AND E.ID_EVENT = A.ID_PLCMT_EVENT "
                                                                 + "      AND (E.CD_EVENT_STATUS = 'APRV' or E.CD_EVENT_STATUS = 'COMP' or E.CD_EVENT_STATUS = 'PEND') "
                                                                 + "      AND S.CD_STAGE <> 'PAD' "
                                                                 + "      AND E.ID_EVENT_STAGE = S.ID_STAGE "
                                                                 + "     AND B.ID_PERSON = L.ID_PERSON(+) "
                                                                 + "     AND NVL(L.DT_LEGAL_STAT_STATUS_DT,sysdate+1) = NVL(max_legal_status.legal_status_date,sysdate+1) "
                                                                 + "     AND B.ID_PERSON = max_legal_status.id_person(+) "
                                                                 + "      AND ((SYSDATE - A.DT_PLCMT_END) <= 30) "
                                                                 + "ORDER BY A.DT_PLCMT_START DESC ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    query.addScalar("cdPlcmtRemovalRsn", Hibernate.STRING);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("dtPersonBirth", Hibernate.DATE);
    query.addScalar("cdLegalStatStatus", Hibernate.STRING);
    query.addScalar("idCase", Hibernate.INTEGER);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("nbrPersonAge", Hibernate.INTEGER);
    query.addScalar("cdPlcmtType", Hibernate.STRING);
    query.addScalar("cdLegalStatCnty", Hibernate.STRING);
    query.addScalar("cdPlcmtSibling", Hibernate.STRING);
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("indStageSealed", Hibernate.STRING);
    query.addScalar("idRsrcFacil", Hibernate.INTEGER);
    query.addScalar("idRsrcAgency", Hibernate.INTEGER);
    query.addScalar("nmPlcmtFacil", Hibernate.STRING);
    query.addScalar("cdTempType", Hibernate.STRING);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByDtPlcmtEndPortal(
                                                                                               List<Integer> idRrscFacilList,
                                                                                               List<Integer> idRrscAgencyList,
                                                                                               int pageNbr, int pageSize) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "   SELECT A.DT_PLCMT_START as dtPlcmtStart, "
                                                                 + "          A.DT_PLCMT_END as dtPlcmtEnd, "
                                                                 + "          A.CD_PLCMT_REMOVAL_RSN as cdPlcmtRemovalRsn, "
                                                                 + "          B.ID_PERSON as idPerson, "
                                                                 + "          B.NM_PERSON_FULL as nmPersonFull, "
                                                                 + "          B.DT_PERSON_BIRTH as dtPersonBirth, "
                                                                 + "          L.CD_LEGAL_STAT_STATUS as cdLegalStatStatus, "
                                                                 + "          A.ID_CASE as idCase, "
                                                                 + "          B.CD_PERSON_SEX as cdPersonSex, "
                                                                 + "          B.NBR_PERSON_AGE as nbrPersonAge, "
                                                                 + "          A.CD_PLCMT_TYPE as cdPlcmtType, "
                                                                 + "          L.CD_LEGAL_STAT_CNTY as cdLegalStatCnty, "
                                                                 + "          A.CD_PLCMT_SIBLING as cdPlcmtSibling, "
                                                                 + "          S.ID_STAGE as idStage, "
                                                                 + "          S.IND_STAGE_SEALED as indStageSealed, "
                                                                 + "          A.ID_RSRC_FACIL as idRsrcFacil, "
                                                                 + "          A.ID_RSRC_AGENCY as idRsrcAgency, "
                                                                 + "          A.NM_PLCMT_FACIL as nmPlcmtFacil, "
                                                                 + "          A.CD_TEMP_TYPE as cdTempType,"
                                                                 + "          A.ID_PLCMT_EVENT as idPlcmtEvent"
                                                                 + "     FROM PLACEMENT A, "
                                                                 + "          PERSON B, "
                                                                 + "          Event E, "
                                                                 + "          Stage S,"
                                                                 + "          LEGAL_STATUS L, "
                                                                 + "          (   SELECT MAX (L2.DT_LEGAL_STAT_STATUS_DT) as legal_status_date, "
                                                                 + "                     B2.ID_PERSON as id_person "
                                                                 + "                FROM LEGAL_STATUS L2, PERSON B2, PLACEMENT A2 "
                                                                 + "    WHERE (A2.ID_RSRC_FACIL IN (:idRrscFacilList) OR A2.ID_RSRC_AGENCY IN (:idRrscAgencyList)) "
                                                                 + "                 AND A2.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                 AND B2.ID_PERSON = A2.ID_PLCMT_CHILD "
                                                                 + "                 AND B2.ID_PERSON = L2.ID_PERSON "
                                                                 + "            GROUP BY B2.ID_PERSON  ) max_legal_status "
                                                                 + "    WHERE (A.ID_RSRC_FACIL IN (:idRrscFacilList) OR A.ID_RSRC_AGENCY IN (:idRrscAgencyList)) "
                                                                 + "      AND A.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "      AND B.ID_PERSON = A.ID_PLCMT_CHILD "
                                                                 + "      AND E.ID_EVENT = A.ID_PLCMT_EVENT "
                                                                 + "      AND (E.CD_EVENT_STATUS = 'APRV' or E.CD_EVENT_STATUS = 'COMP' or E.CD_EVENT_STATUS = 'PEND') "
                                                                 + "      AND S.CD_STAGE <> 'PAD' "
                                                                 + "      AND E.ID_EVENT_STAGE = S.ID_STAGE "
                                                                 + "      AND B.ID_PERSON = L.ID_PERSON(+) "
                                                                 + "      AND NVL(L.DT_LEGAL_STAT_STATUS_DT,sysdate+1) = NVL(max_legal_status.legal_status_date,sysdate+1) "
                                                                 + "      AND B.ID_PERSON = max_legal_status.id_person(+) "
                                                                 + "      AND ((SYSDATE - A.DT_PLCMT_END) <= 30) "
                                                                 + " ORDER BY A.DT_PLCMT_END DESC ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    query.addScalar("cdPlcmtRemovalRsn", Hibernate.STRING);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("dtPersonBirth", Hibernate.DATE);
    query.addScalar("cdLegalStatStatus", Hibernate.STRING);
    query.addScalar("idCase", Hibernate.INTEGER);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("nbrPersonAge", Hibernate.INTEGER);
    query.addScalar("cdPlcmtType", Hibernate.STRING);
    query.addScalar("cdLegalStatCnty", Hibernate.STRING);
    query.addScalar("cdPlcmtSibling", Hibernate.STRING);
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("indStageSealed", Hibernate.STRING);
    query.addScalar("idRsrcFacil", Hibernate.INTEGER);
    query.addScalar("idRsrcAgency", Hibernate.INTEGER);
    query.addScalar("nmPlcmtFacil", Hibernate.STRING);
    query.addScalar("cdTempType", Hibernate.STRING);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByNmPersonFullPortal(
                                                                                                 List<Integer> idRrscFacilList,
                                                                                                 List<Integer> idRrscAgencyList,
                                                                                                 int pageNbr,
                                                                                                 int pageSize) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "   SELECT A.DT_PLCMT_START as dtPlcmtStart, "
                                                                 + "          A.DT_PLCMT_END as dtPlcmtEnd, "
                                                                 + "          A.CD_PLCMT_REMOVAL_RSN as cdPlcmtRemovalRsn, "
                                                                 + "          B.ID_PERSON as idPerson, "
                                                                 + "          B.NM_PERSON_FULL as nmPersonFull, "
                                                                 + "          B.DT_PERSON_BIRTH as dtPersonBirth, "
                                                                 + "          L.CD_LEGAL_STAT_STATUS as cdLegalStatStatus, "
                                                                 + "          A.ID_CASE as idCase, "
                                                                 + "          B.CD_PERSON_SEX as cdPersonSex, "
                                                                 + "          B.NBR_PERSON_AGE as nbrPersonAge, "
                                                                 + "          A.CD_PLCMT_TYPE as cdPlcmtType, "
                                                                 + "          L.CD_LEGAL_STAT_CNTY as cdLegalStatCnty, "
                                                                 + "          A.CD_PLCMT_SIBLING as cdPlcmtSibling, "
                                                                 + "          S.ID_STAGE as idStage, "
                                                                 + "          S.IND_STAGE_SEALED as indStageSealed, "
                                                                 + "          A.ID_RSRC_FACIL as idRsrcFacil, "
                                                                 + "          A.ID_RSRC_AGENCY as idRsrcAgency, "
                                                                 + "          A.NM_PLCMT_FACIL as nmPlcmtFacil, "
                                                                 + "          A.CD_TEMP_TYPE as cdTempType, "
                                                                 + "          A.ID_PLCMT_EVENT as idPlcmtEvent"
                                                                 + "     FROM PLACEMENT A, "
                                                                 + "          PERSON B, "
                                                                 + "          Event E, "
                                                                 + "          Stage S,"
                                                                 + "          LEGAL_STATUS L, "
                                                                 + "          (   SELECT MAX (L2.DT_LEGAL_STAT_STATUS_DT) as legal_status_date, "
                                                                 + "                     B2.ID_PERSON as id_person "
                                                                 + "               FROM LEGAL_STATUS L2, PERSON B2, PLACEMENT A2 "
                                                                 + "               WHERE (A2.ID_RSRC_FACIL IN (:idRrscFacilList)"
                                                                 + "               OR A2.ID_RSRC_AGENCY IN (:idRrscAgencyList))"
                                                                 + "                 AND A2.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                 AND B2.ID_PERSON = A2.ID_PLCMT_CHILD "
                                                                 + "                 AND B2.ID_PERSON = L2.ID_PERSON "
                                                                 + "            GROUP BY B2.ID_PERSON  ) max_legal_status "
                                                                 + "      WHERE (A.ID_RSRC_FACIL IN (:idRrscFacilList) OR A.ID_RSRC_AGENCY IN (:idRrscAgencyList)) "
                                                                 + "      AND A.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "      AND B.ID_PERSON = A.ID_PLCMT_CHILD "
                                                                 + "      AND E.ID_EVENT = A.ID_PLCMT_EVENT "
                                                                 + "      AND (E.CD_EVENT_STATUS = 'APRV' or E.CD_EVENT_STATUS = 'COMP' or E.CD_EVENT_STATUS = 'PEND') "
                                                                 + "      AND S.CD_STAGE <> 'PAD' "
                                                                 + "      AND E.ID_EVENT_STAGE = S.ID_STAGE "
                                                                 + "      AND B.ID_PERSON = L.ID_PERSON(+) "
                                                                 + "      AND NVL(L.DT_LEGAL_STAT_STATUS_DT,sysdate+1) = NVL(max_legal_status.legal_status_date,sysdate+1) "
                                                                 + "      AND B.ID_PERSON = max_legal_status.id_person(+) "
                                                                 + "      AND ((SYSDATE - A.DT_PLCMT_END) <= 30) "
                                                                 + " ORDER BY B.NM_PERSON_FULL ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    query.addScalar("cdPlcmtRemovalRsn", Hibernate.STRING);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("dtPersonBirth", Hibernate.DATE);
    query.addScalar("cdLegalStatStatus", Hibernate.STRING);
    query.addScalar("idCase", Hibernate.INTEGER);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("nbrPersonAge", Hibernate.INTEGER);
    query.addScalar("cdPlcmtType", Hibernate.STRING);
    query.addScalar("cdLegalStatCnty", Hibernate.STRING);
    query.addScalar("cdPlcmtSibling", Hibernate.STRING);
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("indStageSealed", Hibernate.STRING);
    query.addScalar("idRsrcFacil", Hibernate.INTEGER);
    query.addScalar("idRsrcAgency", Hibernate.INTEGER);
    query.addScalar("nmPlcmtFacil", Hibernate.STRING);
    query.addScalar("cdTempType", Hibernate.STRING);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByCdPlcmtRemovalRsnPortal(
                                                                                                      List<Integer> idRrscFacilList,
                                                                                                      List<Integer> idRrscAgencyList,
                                                                                                      int pageNbr,
                                                                                                      int pageSize) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "   SELECT A.DT_PLCMT_START as dtPlcmtStart, "
                                                                 + "          A.DT_PLCMT_END as dtPlcmtEnd, "
                                                                 + "          A.CD_PLCMT_REMOVAL_RSN as cdPlcmtRemovalRsn, "
                                                                 + "          B.ID_PERSON as idPerson, "
                                                                 + "          B.NM_PERSON_FULL as nmPersonFull, "
                                                                 + "          B.DT_PERSON_BIRTH as dtPersonBirth, "
                                                                 + "          L.CD_LEGAL_STAT_STATUS as cdLegalStatStatus, "
                                                                 + "          A.ID_CASE as idCase, "
                                                                 + "          B.CD_PERSON_SEX as cdPersonSex, "
                                                                 + "          B.NBR_PERSON_AGE as nbrPersonAge, "
                                                                 + "          A.CD_PLCMT_TYPE as cdPlcmtType, "
                                                                 + "          L.CD_LEGAL_STAT_CNTY as cdLegalStatCnty, "
                                                                 + "          A.CD_PLCMT_SIBLING as cdPlcmtSibling, "
                                                                 + "          S.ID_STAGE as idStage, "
                                                                 + "          S.IND_STAGE_SEALED as indStageSealed, "
                                                                 + "          A.ID_RSRC_FACIL as idRsrcFacil, "
                                                                 + "          A.ID_RSRC_AGENCY as idRsrcAgency, "
                                                                 + "          A.NM_PLCMT_FACIL as nmPlcmtFacil, "
                                                                 + "          A.CD_TEMP_TYPE as cdTempType, "
                                                                 + "           A.ID_PLCMT_EVENT as idPlcmtEvent"
                                                                 + "     FROM PLACEMENT A, "
                                                                 + "          PERSON B, "
                                                                 + "          Event E, "
                                                                 + "          Stage S,"
                                                                 + "          LEGAL_STATUS L, "
                                                                 + "          (   SELECT MAX (L2.DT_LEGAL_STAT_STATUS_DT) as legal_status_date, "
                                                                 + "                     B2.ID_PERSON as id_person "
                                                                 + "                FROM LEGAL_STATUS L2, PERSON B2, PLACEMENT A2 "
                                                                 + "               WHERE (A2.ID_RSRC_FACIL IN (:idRrscFacilList)"
                                                                 + "               OR A2.ID_RSRC_AGENCY IN (:idRrscAgencyList))"
                                                                 + "                 AND A2.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                 AND B2.ID_PERSON = A2.ID_PLCMT_CHILD "
                                                                 + "                 AND B2.ID_PERSON = L2.ID_PERSON "
                                                                 + "            GROUP BY B2.ID_PERSON  ) max_legal_status "
                                                                 + "    WHERE (A.ID_RSRC_FACIL IN (:idRrscFacilList) OR A.ID_RSRC_AGENCY IN (:idRrscAgencyList)) "
                                                                 + "      AND A.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "      AND B.ID_PERSON = A.ID_PLCMT_CHILD "
                                                                 + "      AND E.ID_EVENT = A.ID_PLCMT_EVENT "
                                                                 + "      AND (E.CD_EVENT_STATUS = 'APRV' or E.CD_EVENT_STATUS = 'COMP' or E.CD_EVENT_STATUS = 'PEND') "
                                                                 + "      AND S.CD_STAGE <> 'PAD' "
                                                                 + "      AND E.ID_EVENT_STAGE = S.ID_STAGE "
                                                                 + "      AND B.ID_PERSON = L.ID_PERSON(+) "
                                                                 + "      AND NVL(L.DT_LEGAL_STAT_STATUS_DT,sysdate+1) = NVL(max_legal_status.legal_status_date,sysdate+1) "
                                                                 + "      AND B.ID_PERSON = max_legal_status.id_person(+) "
                                                                 + "      AND ((SYSDATE - A.DT_PLCMT_END) <= 30) "
                                                                 + " ORDER BY A.CD_PLCMT_REMOVAL_RSN ");
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    query.addScalar("cdPlcmtRemovalRsn", Hibernate.STRING);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("dtPersonBirth", Hibernate.DATE);
    query.addScalar("cdLegalStatStatus", Hibernate.STRING);
    query.addScalar("idCase", Hibernate.INTEGER);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("nbrPersonAge", Hibernate.INTEGER);
    query.addScalar("cdPlcmtType", Hibernate.STRING);
    query.addScalar("cdLegalStatCnty", Hibernate.STRING);
    query.addScalar("cdPlcmtSibling", Hibernate.STRING);
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("indStageSealed", Hibernate.STRING);
    query.addScalar("idRsrcFacil", Hibernate.INTEGER);
    query.addScalar("idRsrcAgency", Hibernate.INTEGER);
    query.addScalar("nmPlcmtFacil", Hibernate.STRING);
    query.addScalar("cdTempType", Hibernate.STRING);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }

  /**
   * Retrieves rows from Placement, Person and LegalStatus tables for the given idRsrcFacil where End date in the future
   * or null. DO NOT alter the order of the select list. This will affect
   * 
   * @RetrieveChildrenInHomeImpl class.
   * @param idRsrcFacil
   * @return Object array containing the rows of selected columns.
   */
  @SuppressWarnings( { "unchecked" })
  public List findPlacementByIdRsrcFacilForHomeInChildren(int idRsrcFacil) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "   SELECT A.DT_PLCMT_START as dtPlcmtStart, "
                                                                 + "          A.DT_PLCMT_END as dtPlcmtEnd, "
                                                                 + "          A.CD_PLCMT_REMOVAL_RSN as cdPlcmtRemovalRsn, "
                                                                 + "          B.ID_PERSON as idPerson, "
                                                                 + "          B.NM_PERSON_FULL as nmPersonFull, "
                                                                 + "          B.DT_PERSON_BIRTH as dtPersonBirth, "
                                                                 + "          L.CD_LEGAL_STAT_STATUS as cdLegalStatStatus, "
                                                                 + "          A.ID_CASE as idCase, "
                                                                 + "          B.CD_PERSON_SEX as cdPersonSex, "
                                                                 + "          B.NBR_PERSON_AGE as nbrPersonAge, "
                                                                 + "          A.CD_PLCMT_TYPE as cdPlcmtType, "
                                                                 + "          L.CD_LEGAL_STAT_CNTY as cdLegalStatCnty, "
                                                                 + "          A.CD_PLCMT_SIBLING as cdPlcmtSibling "
                                                                 + "     FROM PLACEMENT A, "
                                                                 + "          PERSON B, "
                                                                 + "          Event E, "
                                                                 + "          LEGAL_STATUS L, "
                                                                 + "          (   SELECT MAX (L2.DT_LEGAL_STAT_STATUS_DT) as legal_status_date, "
                                                                 + "                     B2.ID_PERSON as id_person "
                                                                 + "                FROM LEGAL_STATUS L2, PERSON B2, PLACEMENT A2 "
                                                                 + "               WHERE A2.ID_RSRC_FACIL = :idRsrcFacil "
                                                                 + "                 AND A2.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                 AND B2.ID_PERSON = A2.ID_PLCMT_CHILD "
                                                                 + "                 AND B2.ID_PERSON = L2.ID_PERSON "
                                                                 + "            GROUP BY B2.ID_PERSON  ) max_legal_status "
                                                                 + "    WHERE A.ID_RSRC_FACIL = :idRsrcFacil "
                                                                 + "      AND A.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "      AND A.DT_PLCMT_END >= sysdate "
                                                                 + "      AND B.ID_PERSON = A.ID_PLCMT_CHILD "
                                                                 + "      AND E.ID_EVENT = A.ID_PLCMT_EVENT "
                                                                 + "      AND E.CD_EVENT_STATUS = 'APRV' "
                                                                 + "      AND B.ID_PERSON = L.ID_PERSON(+) "
                                                                 + "      AND NVL(L.DT_LEGAL_STAT_STATUS_DT,sysdate+1) = NVL(max_legal_status.legal_status_date,sysdate+1) "
                                                                 + "      AND B.ID_PERSON = max_legal_status.id_person(+) "
                                                                 + " ORDER BY A.DT_PLCMT_END DESC, "
                                                                 + "          A.DT_PLCMT_START DESC ");
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    query.addScalar("cdPlcmtRemovalRsn", Hibernate.STRING);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("dtPersonBirth", Hibernate.DATE);
    query.addScalar("cdLegalStatStatus", Hibernate.STRING);
    query.addScalar("idCase", Hibernate.INTEGER);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("nbrPersonAge", Hibernate.INTEGER);
    query.addScalar("cdPlcmtType", Hibernate.STRING);
    query.addScalar("cdLegalStatCnty", Hibernate.STRING);
    query.addScalar("cdPlcmtSibling", Hibernate.STRING);
    List list = query.list();
    return list;
  }

  // New Added 4
  public int insertPlacementNoWaiver(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult,
                                     int idPlcmtChild, int idContract, int idRsrcAgency, int idRsrcFacil,
                                     String cdAddrPlcmtCity, String cdAddrPlcmtCnty, String cdAddrPlcmtLn1,
                                     String cdAddrPlcmtLn2, String cdAddrPlcmtSt, String cdAddrPlcmtZip,
                                     String cdCdPlcmtInfo1, String cdCdPlcmtInfo2, String cdCdPlcmtInfo3,
                                     String cdCdPlcmtInfo4, String cdCdPlcmtInfo5, String cdCdPlcmtInfo6,
                                     String cdCdPlcmtInfo7, String cdCdPlcmtInfo8, String cdCdPlcmtInfo9,
                                     String cdCdPlcmtInfo10, String cdCdPlcmtInfo11, String cdCdPlcmtInfo12,
                                     String cdCdPlcmtInfo13, String cdCdPlcmtInfo14, String cdCdPlcmtInfo15,
                                     String cdCdPlcmtInfo16, String cdCdPlcmtInfo17, String cdPlcmtLivArr,
                                     String cdPlcmtRemovalRsn, String cdPlcmtActPlanned, String cdPlcmtType,
                                     String cdPlcmtService, Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss,
                                     Date dtPlcmtChildPlan, Date dtPlcmtEducLog, Date dtPlcmtEnd,
                                     Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif, Date dtPlcmtPreplaceVisit,
                                     Date dtPlcmtSchoolRecords, Date dtPlcmtStart, String indPlcmtContCntct,
                                     String indPlcmtEducLog, String indPlcmetEmerg, String indPlcmtNotApplic,
                                     String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone,
                                     String cdNmPlcmtAgency, String cdNmPlcmtContact, String cdNmPlcmtFacil,
                                     String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                                     String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                                     String cdTxtPlcmtRemovalRsn, String szCdActAtt, int ulContactedById,
                                     String selSzCdMethod, String cbxIndTempReplacement, String szCdTempPlcmtType,
                                     String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired, String rbIndCaseHome,
                                     Date dtDateLastDischarged, String ulMatch, Date dtPermReportDueDate,
                                     String cbxBoardingCounty, String cbxIndTrialHomeVisit, Date dtCrtBeginDate,
                                     Date dtCrtEndDate, String rbIndPlcmtChPlacedFr, String rbIndPlcmtChPlacedBy,
                                     String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
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
                                     String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 // + " ID_PLCMT_ADULT, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ID_PLCMT_CONTRACT, "
                                                                 + "                       ID_RSRC_AGENCY, "
                                                                 + "                       ID_RSRC_FACIL, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, "
                                                                 + "                       TXT_DOC_CMNTS) "
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, "
                                                                 + "          null, "
                                                                 // + " :idPlcmtAdult, "
                                                                 + "          :idPlcmtChild, "
                                                                 + "          :idContract, "
                                                                 + "          :idRsrcAgency, "
                                                                 + "          :idRsrcFacil, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :cdPlcmtActPlanned, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn,"
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments) ");

    query.setInteger("idCase", idCase);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    // query.setInteger("idPlcmtAdult", idPlcmtAdult);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idContract", idContract);
    query.setInteger("idRsrcAgency", idRsrcAgency);
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("cdPlcmtActPlanned", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    // change
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    return query.executeUpdate();

  }

  // MR-057 Added new fields for APPLA
  public int insertPlacement(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult, int idPlcmtChild,
                             int idContract, int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCity,
                             String cdAddrPlcmtCnty, String cdAddrPlcmtLn1, String cdAddrPlcmtLn2,
                             String cdAddrPlcmtSt, String cdAddrPlcmtZip, String cdCdPlcmtInfo1, String cdCdPlcmtInfo2,
                             String cdCdPlcmtInfo3, String cdCdPlcmtInfo4, String cdCdPlcmtInfo5,
                             String cdCdPlcmtInfo6, String cdCdPlcmtInfo7, String cdCdPlcmtInfo8,
                             String cdCdPlcmtInfo9, String cdCdPlcmtInfo10, String cdCdPlcmtInfo11,
                             String cdCdPlcmtInfo12, String cdCdPlcmtInfo13, String cdCdPlcmtInfo14,
                             String cdCdPlcmtInfo15, String cdCdPlcmtInfo16, String cdCdPlcmtInfo17,
                             String cdPlcmtLivArr, String cdPlcmtRemovalRsn, String cdPlcmtActPlanned,
                             String cdPlcmtType, String cdPlcmtService, Date dtPlcmtCaregvrDiscuss,
                             Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan, Date dtPlcmtEducLog, Date dtPlcmtEnd,
                             Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif, Date dtPlcmtPreplaceVisit,
                             Date dtPlcmtSchoolRecords, Date dtPlcmtStart, String indPlcmtContCntct,
                             String indPlcmtEducLog, String indPlcmetEmerg, String indPlcmtNotApplic,
                             String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone,
                             String cdNmPlcmtAgency, String cdNmPlcmtContact, String cdNmPlcmtFacil,
                             String cdNmPlcmtPersonFull, String indPlcmtWriteHistory, String cdTxtPlcmtAddrComment,
                             String cdTxtPlcmtDiscussion, String cdTxtPlcmtRemovalRsn, String szCdActAtt,
                             int ulContactedById, String selSzCdMethod, String cbxIndTempReplacement,
                             String szCdTempPlcmtType, String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                             String rbIndCaseHome, int dspUlWaiverId, Date dtDateLastDischarged, String ulMatch,
                             Date dtPermReportDueDate, String cbxBoardingCounty, String cbxIndTrialHomeVisit,
                             Date dtCrtBeginDate, Date dtCrtEndDate, String rbIndPlcmtChPlacedFr,
                             String rbIndPlcmtChPlacedBy, String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
                             String rbIndPlcmtLeastRestrict, String rbIndPlcmtFamilyLike, String rbIndPlcmtAppropriate,
                             String rbIndPlcmtCloseProxPar, String rbIndPlcmtCloseProxSchool, String rbIndConsistent,
                             String szTxtNoExplainCheckList, String rbIndExpTrauma, String szTxtYesExpTrauma,
                             String rbIndStaySiblings, int nbrSibinCare, int nbrSibPlaced, String szCdSibRsn,
                             String szCdCCFARsn, String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA,
                             String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                             String szCdSuppSupervisionCmnts, Date txtDtPsychInfo, String txtSzNmPsychinfo,
                             Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo, Date txtDtMedInfo,
                             String txtSzNmMedinfo, Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo,
                             Date txtDtEduInfo, String txtSzNmEduinfo, String cbxIndNAEduInfo, Date txtDtCaseEduInfo,
                             String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo, String txtaSzTxtPlcmtDocuments,
                             String txtaSzTxtPlcmtCmntsDocuments, String indLTFCPlacement, Date dtAgreementSigned,
                             String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog) {

    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 // + " ID_PLCMT_ADULT, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ID_PLCMT_CONTRACT, "
                                                                 + "                       ID_RSRC_AGENCY, "
                                                                 + "                       ID_RSRC_FACIL, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 + "                       ID_WAIVER, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, "
                                                                 + "                       TXT_DOC_CMNTS, "
                                                                 + "                       IND_LTFC_PLACEMENT,  "
                                                                 + "                       DT_LTFC_AGREEMENT_SIGNED,  "
                                                                 + "                       IND_CHILD_CONNECT_ADULT,  "
                                                                 + "                       ID_PERSON_CONNECTED_ADULT, "
                                                                 + "                       DT_LAST_PLCMT_LOG_VIEW )"
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, "
                                                                 + "          null, "
                                                                 // + " :idPlcmtAdult, "
                                                                 + "          :idPlcmtChild, "
                                                                 + "          :idContract, "
                                                                 + "          :idRsrcAgency, "
                                                                 + "          :idRsrcFacil, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :cdPlcmtActPlanned, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn,"
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 + "          :dspUlWaiverId, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments, "
                                                                 + "          :indLTFCPlacement, "
                                                                 + "          :dtAgreementSigned, "
                                                                 + "          :indConnectedAdult, "
                                                                 + "          :idPersonConnected, " 
                                                                 + "          :dtLastViewPlcmtLog )");
    query.setInteger("idCase", idCase);
    query.setDate("dtLastViewPlcmtLog", dtLastViewPlcmtLog);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    // query.setInteger("idPlcmtAdult", idPlcmtAdult);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idContract", idContract);
    query.setInteger("idRsrcAgency", idRsrcAgency);
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("cdPlcmtActPlanned", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    query.setInteger("dspUlWaiverId", dspUlWaiverId);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    // change
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    query.setString("indLTFCPlacement", indLTFCPlacement);
    query.setDate("dtAgreementSigned", dtAgreementSigned);
    query.setString("indConnectedAdult", indConnectedAdult);
    query.setParameter("idPersonConnected", idPersonConnected, Hibernate.INTEGER);
    return query.executeUpdate();
  }

  // Ne Added 3
  // MR-057 Added new fields for APPLA
  public int insertPlacementNoIdContractNoWaiver(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult,
                                                 int idPlcmtChild, int idRsrcAgency, int idRsrcFacil,
                                                 String cdAddrPlcmtCity, String cdAddrPlcmtCnty, String cdAddrPlcmtLn1,
                                                 String cdAddrPlcmtLn2, String cdAddrPlcmtSt, String cdAddrPlcmtZip,
                                                 String cdCdPlcmtInfo1, String cdCdPlcmtInfo2, String cdCdPlcmtInfo3,
                                                 String cdCdPlcmtInfo4, String cdCdPlcmtInfo5, String cdCdPlcmtInfo6,
                                                 String cdCdPlcmtInfo7, String cdCdPlcmtInfo8, String cdCdPlcmtInfo9,
                                                 String cdCdPlcmtInfo10, String cdCdPlcmtInfo11,
                                                 String cdCdPlcmtInfo12, String cdCdPlcmtInfo13,
                                                 String cdCdPlcmtInfo14, String cdCdPlcmtInfo15,
                                                 String cdCdPlcmtInfo16, String cdCdPlcmtInfo17, String cdPlcmtLivArr,
                                                 String cdPlcmtRemovalRsn, String cdPlcmtActPlanned,
                                                 String cdPlcmtType, String cdPlcmtService, Date dtPlcmtCaregvrDiscuss,
                                                 Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan, Date dtPlcmtEducLog,
                                                 Date dtPlcmtEnd, Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif,
                                                 Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords,
                                                 Date dtPlcmtStart, String indPlcmtContCntct, String indPlcmtEducLog,
                                                 String indPlcmetEmerg, String indPlcmtNotApplic,
                                                 String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt,
                                                 String cdNbrPlcmtTelephone, String cdNmPlcmtAgency,
                                                 String cdNmPlcmtContact, String cdNmPlcmtFacil,
                                                 String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                                                 String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                                                 String cdTxtPlcmtRemovalRsn, String szCdActAtt, int ulContactedById,
                                                 String selSzCdMethod, String cbxIndTempReplacement,
                                                 String szCdTempPlcmtType, String szTxtTempPlcmtCmnts,
                                                 String cbxIndWaiverRequired, String rbIndCaseHome,
                                                 Date dtDateLastDischarged, String ulMatch, Date dtPermReportDueDate,
                                                 String cbxBoardingCounty, String cbxIndTrialHomeVisit,
                                                 Date dtCrtBeginDate, Date dtCrtEndDate, String rbIndPlcmtChPlacedFr,
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
                                                 Date txtDtPsychInfo, String txtSzNmPsychinfo, Date txtDtCasePsychInfo,
                                                 String txtSzNmCasePsychinfo, Date txtDtMedInfo, String txtSzNmMedinfo,
                                                 Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                                                 String txtSzNmEduinfo, String cbxIndNAEduInfo, Date txtDtCaseEduInfo,
                                                 String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo,
                                                 String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments,
                                                 String indLTFCPlacement, Date dtAgreementSigned,
                                                 String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 // + " ID_PLCMT_ADULT, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ID_RSRC_AGENCY, "
                                                                 + "                       ID_RSRC_FACIL, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 // + " ID_WAIVER, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, "
                                                                 + "                       TXT_DOC_CMNTS, "
                                                                 + "                       IND_LTFC_PLACEMENT,  "
                                                                 + "                       DT_LTFC_AGREEMENT_SIGNED,  "
                                                                 + "                       IND_CHILD_CONNECT_ADULT,  "
                                                                 + "                       ID_PERSON_CONNECTED_ADULT, "
                                                                 + "                       DT_LAST_PLCMT_LOG_VIEW )"
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, "
                                                                 + "          null, "
                                                                 // + " :idPlcmtAdult, "
                                                                 + "          :idPlcmtChild, "
                                                                 + "          :idRsrcAgency, "
                                                                 + "          :idRsrcFacil, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :cdPlcmtActPlanned, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn, "
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 // + " :dspUlWaiverId, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments, "
                                                                 + "          :indLTFCPlacement, "
                                                                 + "          :dtAgreementSigned, "
                                                                 + "          :indConnectedAdult, "
                                                                 + "          :idPersonConnected, " 
                                                                 + "          :dtLastViewPlcmtLog )");
    query.setInteger("idCase", idCase);
    query.setDate("dtLastViewPlcmtLog", dtLastViewPlcmtLog);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    // query.setInteger("idPlcmtAdult", idPlcmtAdult);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idRsrcAgency", idRsrcAgency);
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("cdPlcmtActPlanned", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    // query.setInteger("dspUlWaiverId", dspUlWaiverId);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    // change
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    query.setString("indLTFCPlacement", indLTFCPlacement);
    query.setDate("dtAgreementSigned", dtAgreementSigned);
    query.setString("indConnectedAdult", indConnectedAdult);
    query.setParameter("idPersonConnected", idPersonConnected, Hibernate.INTEGER);
    return query.executeUpdate();

  }

  // MR-057 Added new fields for APPLA
  public int insertPlacementNoIdContract(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult,
                                         int idPlcmtChild, int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCity,
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
                                         String cdTxtPlcmtDiscussion, String cdTxtPlcmtRemovalRsn, String szCdActAtt,
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
                                         String indLTFCPlacement, Date dtAgreementSigned, String indConnectedAdult,
                                         Integer idPersonConnected, Date dtLastViewPlcmtLog) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 // + " ID_PLCMT_ADULT, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ID_RSRC_AGENCY, "
                                                                 + "                       ID_RSRC_FACIL, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 + "                       ID_WAIVER, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, "
                                                                 + "                       TXT_DOC_CMNTS, "
                                                                 + "                       IND_LTFC_PLACEMENT,  "
                                                                 + "                       DT_LTFC_AGREEMENT_SIGNED,  "
                                                                 + "                       IND_CHILD_CONNECT_ADULT,  "
                                                                 + "                       ID_PERSON_CONNECTED_ADULT, "
                                                                 + "                       DT_LAST_PLCMT_LOG_VIEW )"
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, "
                                                                 + "          null, "
                                                                 // + " :idPlcmtAdult, "
                                                                 + "          :idPlcmtChild, "
                                                                 + "          :idRsrcAgency, "
                                                                 + "          :idRsrcFacil, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :cdPlcmtActPlanned, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn, "
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 + "          :dspUlWaiverId, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments, "
                                                                 + "          :indLTFCPlacement, "
                                                                 + "          :dtAgreementSigned, "
                                                                 + "          :indConnectedAdult, "
                                                                 + "          :idPersonConnected, " 
                                                                 + "          :dtLastViewPlcmtLog )");
    query.setInteger("idCase", idCase);
    query.setDate("dtLastViewPlcmtLog", dtLastViewPlcmtLog);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    // query.setInteger("idPlcmtAdult", idPlcmtAdult);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idRsrcAgency", idRsrcAgency);
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("cdPlcmtActPlanned", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    query.setInteger("dspUlWaiverId", dspUlWaiverId);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    // change
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    query.setString("indLTFCPlacement", indLTFCPlacement);
    query.setDate("dtAgreementSigned", dtAgreementSigned);
    query.setString("indConnectedAdult", indConnectedAdult);
    query.setParameter("idPersonConnected", idPersonConnected, Hibernate.INTEGER);
    return query.executeUpdate();
  }

  // New Added 2
  // MR-057 Added new fields for APPLA
  public int insertPlacementNoIdContractAgencyNoWaiver(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent,
                                                       int idPlcmtAdult, int idPlcmtChild, int idRsrcFacil,
                                                       String cdAddrPlcmtCity, String cdAddrPlcmtCnty,
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
                                                       String cdTxtPlcmtDiscussion, String cdTxtPlcmtRemovalRsn,
                                                       String szCdActAtt, int ulContactedById, String selSzCdMethod,
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
                                                       String rbIndPlcmtMatchCCFA,
                                                       String szCdPlcmtMatchCCFAReasonCmnts,
                                                       String rbIndSuppSupervision, String szCdSuppSupervisionCmnts,
                                                       Date txtDtPsychInfo, String txtSzNmPsychinfo,
                                                       Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo,
                                                       Date txtDtMedInfo, String txtSzNmMedinfo, Date txtDtCaseMedInfo,
                                                       String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                                                       String txtSzNmEduinfo, String cbxIndNAEduInfo,
                                                       Date txtDtCaseEduInfo, String txtSzNmCaseEduinfo,
                                                       String cbxIndNACaseEduInfo, String txtaSzTxtPlcmtDocuments,
                                                       String txtaSzTxtPlcmtCmntsDocuments, String indLTFCPlacement,
                                                       Date dtAgreementSigned, String indConnectedAdult,
                                                       Integer idPersonConnected, Date dtLastViewPlcmtLog) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 // + " ID_PLCMT_ADULT, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ID_RSRC_FACIL, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 // + " ID_WAIVER, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, "
                                                                 + "                       TXT_DOC_CMNTS, "
                                                                 + "                       IND_LTFC_PLACEMENT,  "
                                                                 + "                       DT_LTFC_AGREEMENT_SIGNED,  "
                                                                 + "                       IND_CHILD_CONNECT_ADULT,  "
                                                                 + "                       ID_PERSON_CONNECTED_ADULT, "
                                                                 + "                       DT_LAST_PLCMT_LOG_VIEW )"
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, "
                                                                 + "          NULL, "
                                                                 // + " :idPlcmtAdult, "
                                                                 + "          :idPlcmtChild, "
                                                                 + "          :idRsrcFacil, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :cdPlcmtActPlanned, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn, "
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 // + " :dspUlWaiverId, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments, "
                                                                 + "          :indLTFCPlacement, "
                                                                 + "          :dtAgreementSigned, "
                                                                 + "          :indConnectedAdult, "
                                                                 + "          :idPersonConnected, " 
                                                                 + "          :dtLastViewPlcmtLog )");
    query.setInteger("idCase", idCase);
    query.setDate("dtLastViewPlcmtLog", dtLastViewPlcmtLog);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    // query.setInteger("idPlcmtAdult", idPlcmtAdult);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("cdPlcmtActPlanned", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    // query.setInteger("dspUlWaiverId", dspUlWaiverId);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    // change
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    query.setString("indLTFCPlacement", indLTFCPlacement);
    query.setDate("dtAgreementSigned", dtAgreementSigned);
    query.setString("indConnectedAdult", indConnectedAdult);
    query.setParameter("idPersonConnected", idPersonConnected, Hibernate.INTEGER);
    return query.executeUpdate();

  }

  // MR-057 Added new fields for APPLA
  public int insertPlacementNoIdContractAgency(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult,
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
                                               Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords, Date dtPlcmtStart,
                                               String indPlcmtContCntct, String indPlcmtEducLog, String indPlcmetEmerg,
                                               String indPlcmtNotApplic, String indPlcmtSchoolDoc,
                                               String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone,
                                               String cdNmPlcmtAgency, String cdNmPlcmtContact, String cdNmPlcmtFacil,
                                               String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                                               String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                                               String cdTxtPlcmtRemovalRsn, String szCdActAtt, int ulContactedById,
                                               String selSzCdMethod, String cbxIndTempReplacement,
                                               String szCdTempPlcmtType, String szTxtTempPlcmtCmnts,
                                               String cbxIndWaiverRequired, String rbIndCaseHome, int dspUlWaiverId,
                                               Date dtDateLastDischarged, String ulMatch, Date dtPermReportDueDate,
                                               String cbxBoardingCounty, String cbxIndTrialHomeVisit,
                                               Date dtCrtBeginDate, Date dtCrtEndDate, String rbIndPlcmtChPlacedFr,
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
                                               Date txtDtPsychInfo, String txtSzNmPsychinfo, Date txtDtCasePsychInfo,
                                               String txtSzNmCasePsychinfo, Date txtDtMedInfo, String txtSzNmMedinfo,
                                               Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                                               String txtSzNmEduinfo, String cbxIndNAEduInfo, Date txtDtCaseEduInfo,
                                               String txtSzNmCaseEduinfo, String cbxIndNACaseEduInfo,
                                               String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments,
                                               String indLTFCPlacement, Date dtAgreementSigned,
                                               String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 // + " ID_PLCMT_ADULT, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ID_RSRC_FACIL, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 + "                       ID_WAIVER, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, TXT_DOC_CMNTS, "
                                                                 + "                       IND_LTFC_PLACEMENT,  "
                                                                 + "                       DT_LTFC_AGREEMENT_SIGNED,  "
                                                                 + "                       IND_CHILD_CONNECT_ADULT,  "+ "                       ID_PERSON_CONNECTED_ADULT, "
                                                                 + "                       DT_LAST_PLCMT_LOG_VIEW )"+ "                       ID_PERSON_CONNECTED_ADULT )"
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, "
                                                                 + "          NULL, "
                                                                 // + " :idPlcmtAdult, "
                                                                 + "          :idPlcmtChild, "
                                                                 + "          :idRsrcFacil, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :cdPlcmtActPlanned, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn, "
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 + "          :dspUlWaiverId, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments, "
                                                                 + "          :indLTFCPlacement, "
                                                                 + "          :dtAgreementSigned, "
                                                                 + "          :indConnectedAdult, "
                                                                 + "          :idPersonConnected, " 
                                                                 + "          :dtLastViewPlcmtLog )");
    query.setInteger("idCase", idCase);
    query.setDate("dtLastViewPlcmtLog", dtLastViewPlcmtLog);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    // query.setInteger("idPlcmtAdult", idPlcmtAdult);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idRsrcFacil", idRsrcFacil);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("cdPlcmtActPlanned", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    query.setInteger("dspUlWaiverId", dspUlWaiverId);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    // change
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    query.setString("indLTFCPlacement", indLTFCPlacement);
    query.setDate("dtAgreementSigned", dtAgreementSigned);
    query.setString("indConnectedAdult", indConnectedAdult);
    query.setParameter("idPersonConnected", idPersonConnected, Hibernate.INTEGER);
    return query.executeUpdate();
  }

  // MR-057 Added new fields for APPLA
  public int insertPlacementNoIdContractAgencyFacilNoWaiver(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent,
                                                            int idPlcmtAdult, int idPlcmtChild, String cdAddrPlcmtCity,
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
                                                            String txtaSzTxtPlcmtCmntsDocuments,
                                                            String indLTFCPlacement, Date dtAgreementSigned,
                                                            String indConnectedAdult, Integer idPersonConnected, Date dtLastViewPlcmtLog) {

    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 + " ID_PLCMT_ADULT, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 // + " ID_WAIVER, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, "
                                                                 + "                       TXT_DOC_CMNTS, "
                                                                 + "                       IND_LTFC_PLACEMENT,  "
                                                                 + "                       DT_LTFC_AGREEMENT_SIGNED,  "
                                                                 + "                       IND_CHILD_CONNECT_ADULT,  "
                                                                 + "                       ID_PERSON_CONNECTED_ADULT, "
                                                                 + "                       DT_LAST_PLCMT_LOG_VIEW )"
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, "
                                                                 + "          null, "
                                                                 + " :idPlcmtAdult, "
                                                                 + "          :idPlcmtChild, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :szCdActAtt, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn, "
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 // + " :dspUlWaiverId, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments, "
                                                                 + "          :indLTFCPlacement, "
                                                                 + "          :dtAgreementSigned, "
                                                                 + "          :indConnectedAdult, "
                                                                 + "          :idPersonConnected, " 
                                                                 + "          :dtLastViewPlcmtLog )");
    query.setInteger("idCase", idCase);
    query.setDate("dtLastViewPlcmtLog", dtLastViewPlcmtLog);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    query.setInteger("idPlcmtAdult", idPlcmtAdult);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("szCdActAtt", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    // query.setInteger("dspUlWaiverId", dspUlWaiverId);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    // change
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    query.setString("indLTFCPlacement", indLTFCPlacement);
    query.setDate("dtAgreementSigned", dtAgreementSigned);
    query.setString("indConnectedAdult", indConnectedAdult);
    query.setParameter("idPersonConnected", idPersonConnected, Hibernate.INTEGER);
    return query.executeUpdate();
  }

  // MR-057 Added new fields for APPLA
  public int insertPlacementNoIdContractAgencyFacil(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent,
                                                    int idPlcmtAdult, int idPlcmtChild, String cdAddrPlcmtCity,
                                                    String cdAddrPlcmtCnty, String cdAddrPlcmtLn1,
                                                    String cdAddrPlcmtLn2, String cdAddrPlcmtSt, String cdAddrPlcmtZip,
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
                                                    String cdTxtPlcmtDiscussion, String cdTxtPlcmtRemovalRsn,
                                                    String szCdActAtt, int ulContactedById, String selSzCdMethod,
                                                    String cbxIndTempReplacement, String szCdTempPlcmtType,
                                                    String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                                                    String rbIndCaseHome, int dspUlWaiverId, Date dtDateLastDischarged,
                                                    String ulMatch, Date dtPermReportDueDate, String cbxBoardingCounty,
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
                                                    Date dtAgreementSigned, String indConnectedAdult,
                                                    Integer idPersonConnected, Date dtLastViewPlcmtLog) {

    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 + " ID_PLCMT_ADULT, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 + "                       ID_WAIVER, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, "
                                                                 + "                       TXT_DOC_CMNTS, "
                                                                 + "                       IND_LTFC_PLACEMENT,  "
                                                                 + "                       DT_LTFC_AGREEMENT_SIGNED,  "
                                                                 + "                       IND_CHILD_CONNECT_ADULT,  "
                                                                 + "                       ID_PERSON_CONNECTED_ADULT, "
                                                                 + "                       DT_LAST_PLCMT_LOG_VIEW )"
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, " + "          null, "
                                                                 + " :idPlcmtAdult, " + "          :idPlcmtChild, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :szCdActAtt, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn, "
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 + "          :dspUlWaiverId, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments, "
                                                                 + "          :indLTFCPlacement, "
                                                                 + "          :dtAgreementSigned, "
                                                                 + "          :indConnectedAdult, "
                                                                 + "          :idPersonConnected, " 
                                                                 + "          :dtLastViewPlcmtLog )");
    query.setInteger("idCase", idCase);
    query.setDate("dtLastViewPlcmtLog", dtLastViewPlcmtLog);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    query.setInteger("idPlcmtAdult", idPlcmtAdult);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("szCdActAtt", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    query.setInteger("dspUlWaiverId", dspUlWaiverId);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    // change
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    query.setString("indLTFCPlacement", indLTFCPlacement);
    query.setDate("dtAgreementSigned", dtAgreementSigned);
    query.setString("indConnectedAdult", indConnectedAdult);
    query.setParameter("idPersonConnected", idPersonConnected, Hibernate.INTEGER);
    return query.executeUpdate();
  }

  // STGAP00006531: This SQL is defined to save a runaway Placement
  // MR-057 Added new fields for APPLA
  public int insertPlacementRunaway(int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtChild,
                                    String cdAddrPlcmtCity, String cdAddrPlcmtCnty, String cdAddrPlcmtLn1,
                                    String cdAddrPlcmtLn2, String cdAddrPlcmtSt, String cdAddrPlcmtZip,
                                    String cdCdPlcmtInfo1, String cdCdPlcmtInfo2, String cdCdPlcmtInfo3,
                                    String cdCdPlcmtInfo4, String cdCdPlcmtInfo5, String cdCdPlcmtInfo6,
                                    String cdCdPlcmtInfo7, String cdCdPlcmtInfo8, String cdCdPlcmtInfo9,
                                    String cdCdPlcmtInfo10, String cdCdPlcmtInfo11, String cdCdPlcmtInfo12,
                                    String cdCdPlcmtInfo13, String cdCdPlcmtInfo14, String cdCdPlcmtInfo15,
                                    String cdCdPlcmtInfo16, String cdCdPlcmtInfo17, String cdPlcmtLivArr,
                                    String cdPlcmtRemovalRsn, String cdPlcmtActPlanned, String cdPlcmtType,
                                    String cdPlcmtService, Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss,
                                    Date dtPlcmtChildPlan, Date dtPlcmtEducLog, Date dtPlcmtEnd,
                                    Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif, Date dtPlcmtPreplaceVisit,
                                    Date dtPlcmtSchoolRecords, Date dtPlcmtStart, String indPlcmtContCntct,
                                    String indPlcmtEducLog, String indPlcmetEmerg, String indPlcmtNotApplic,
                                    String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone,
                                    String cdNmPlcmtAgency, String cdNmPlcmtContact, String cdNmPlcmtFacil,
                                    String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                                    String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                                    String cdTxtPlcmtRemovalRsn, String szCdActAtt, int ulContactedById,
                                    String selSzCdMethod, String cbxIndTempReplacement, String szCdTempPlcmtType,
                                    String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired, String rbIndCaseHome,
                                    Date dtDateLastDischarged, String ulMatch, Date dtPermReportDueDate,
                                    String cbxBoardingCounty, String cbxIndTrialHomeVisit, Date dtCrtBeginDate,
                                    Date dtCrtEndDate, String rbIndPlcmtChPlacedFr, String rbIndPlcmtChPlacedBy,
                                    String szCdChildTransitionCmnts, String rbIndPlcmtSafe,
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
                                    String indLTFCPlacement, Date dtAgreementSigned, String indConnectedAdult,
                                    Integer idPersonConnected, Date dtLastViewPlcmtLog) {

    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PLACEMENT (ID_CASE, "
                                                                 + "                       DT_PLCMT_PERM_EFF, "
                                                                 + "                       ID_PLCMT_EVENT, "
                                                                 + "                       DT_LAST_UPDATE, "
                                                                 + "                       ID_PLCMT_CHILD, "
                                                                 + "                       ADDR_PLCMT_CITY, "
                                                                 + "                       ADDR_PLCMT_CNTY, "
                                                                 + "                       ADDR_PLCMT_LN1, "
                                                                 + "                       ADDR_PLCMT_LN2, "
                                                                 + "                       ADDR_PLCMT_ST, "
                                                                 + "                       ADDR_PLCMT_ZIP, "
                                                                 + "                       CD_PLCMT_INFO_1, "
                                                                 + "                       CD_PLCMT_INFO_2, "
                                                                 + "                       CD_PLCMT_INFO_3, "
                                                                 + "                       CD_PLCMT_INFO_4, "
                                                                 + "                       CD_PLCMT_INFO_5, "
                                                                 + "                       CD_PLCMT_INFO_6, "
                                                                 + "                       CD_PLCMT_INFO_7, "
                                                                 + "                       CD_PLCMT_INFO_8, "
                                                                 + "                       CD_PLCMT_INFO_9, "
                                                                 + "                       CD_PLCMT_INFO_10, "
                                                                 + "                       CD_PLCMT_INFO_11, "
                                                                 + "                       CD_PLCMT_INFO_12, "
                                                                 + "                       CD_PLCMT_INFO_13, "
                                                                 + "                       CD_PLCMT_INFO_14, "
                                                                 + "                       CD_PLCMT_INFO_15, "
                                                                 + "                       CD_PLCMT_INFO_16, "
                                                                 + "                       CD_PLCMT_INFO_17, "
                                                                 + "                       CD_PLCMT_LIV_ARR, "
                                                                 + "                       CD_PLCMT_REMOVAL_RSN, "
                                                                 + "                       CD_PLCMT_ACT_PLANNED, "
                                                                 + "                       CD_PLCMT_TYPE, "
                                                                 + "                       CD_PLCMT_SERVICE, "
                                                                 + "                       DT_PLCMT_CAREGVR_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_DISCUSS, "
                                                                 + "                       DT_PLCMT_CHILD_PLAN, "
                                                                 + "                       DT_PLCMT_EDUC_LOG, "
                                                                 + "                       DT_PLCMT_END, "
                                                                 + "                       DT_PLCMT_MEDDEV_HISTORY, "
                                                                 + "                       DT_PLCMT_PARENTS_NOTIF, "
                                                                 + "                       DT_PLCMT_PREPLACE_VISIT, "
                                                                 + "                       DT_PLCMT_SCHOOL_RECORDS, "
                                                                 + "                       DT_PLCMT_START, "
                                                                 + "                       IND_PLCMT_CONT_CNTCT, "
                                                                 + "                       IND_PLCMT_EDUC_LOG, "
                                                                 + "                       IND_PLCMT_EMERG, "
                                                                 + "                       IND_PLCMT_NOT_APPLIC, "
                                                                 + "                       IND_PLCMT_SCHOOL_DOC, "
                                                                 + "                       IND_PLCMT_FAM, "
                                                                 + "                       NBR_PLCMT_PHONE_EXT, "
                                                                 + "                       NBR_PLCMT_TELEPHONE, "
                                                                 + "                       NM_PLCMT_AGENCY, "
                                                                 + "                       NM_PLCMT_CONTACT, "
                                                                 + "                       NM_PLCMT_FACIL, "
                                                                 + "                       NM_PLCMT_PERSON_FULL, "
                                                                 + "                       IND_PLCMT_WRITE_HISTORY, "
                                                                 + "                       TXT_PLCMT_ADDR_COMMENT, "
                                                                 + "                       TXT_PLCMT_DISCUSSION, "
                                                                 + "                       TXT_PLCMT_DOCUMENTS, "
                                                                 + "                       TXT_PLCMT_REMOVAL_RSN, "
                                                                 + "                       ID_CONTACT_WRKR, "
                                                                 + "                       CD_CONTACT_METHOD, "
                                                                 + "                       CD_TEMP_TYPE, "
                                                                 + "                       TXT_TEMP_CMNTS, "
                                                                 + "                       IND_WAIVER_REQD, "
                                                                 + "                       CD_WAIVER_TYPE, "
                                                                 + "                       TXT_MATCH, "
                                                                 + "                       CD_BOARDING_CNTY, "
                                                                 + "                       IND_TRIAL_HOME, "
                                                                 + "                       DT_TRIAL_CO_START, "
                                                                 + "                       DT_TRIAL_CO_END, "
                                                                 + "                       CD_ADO_TYPE, "
                                                                 + "                       CD_PLCMT_ADPT_BY, "
                                                                 + "                       TXT_ADO_CMNTS, "
                                                                 + "                       IND_PLCMT_SAFE, "
                                                                 + "                       IND_PLCMT_RESTR, "
                                                                 + "                       IND_PLCMT_APPR, "
                                                                 + "                       IND_PLCMT_PROX, "
                                                                 + "                       IND_PLCMT_SCH_DIST, "
                                                                 + "                       IND_PLCMT_CASE_PLAN, "
                                                                 + "                       TXT_PLCMT_CHECKLIST, "
                                                                 + "                       IND_PLCMT_TRAUMA, "
                                                                 + "                       TXT_PLCMT_TRAUMA, "
                                                                 + "                       IND_PLCMT_SIBLING, "
                                                                 + "                       NBR_PLCMT_SIB_CARE, "
                                                                 + "                       NBR_PLCMT_SIB_CHILD, "
                                                                 + "                       CD_PLCMT_SIBLING, "
                                                                 + "                       CD_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_SIBLING, "
                                                                 + "                       IND_PLCMT_CCFA, "
                                                                 + "                       TXT_PLCMT_CCFA, "
                                                                 + "                       IND_SPVSN, "
                                                                 + "                       TXT_SPVSN, "
                                                                 + "                       DT_PSY_INFO, "
                                                                 + "                       TXT_PSY_INFO_CONTACT, "
                                                                 + "                       DT_PSY_CP, "
                                                                 + "                       TXT_PSY_CP_CONTACT, "
                                                                 + "                       TXT_MED_INFO_CONTACT, "
                                                                 + "                       DT_MED_CP, "
                                                                 + "                       TXT_MED_CP_CONTACT, "
                                                                 + "                       TXT_EDU_INFO_CONTACT, "
                                                                 + "                       TXT_EDU_CP_CONTACT, "
                                                                 + "                       TXT_DOC_CMNTS,  "
                                                                 + "                       IND_LTFC_PLACEMENT,  "
                                                                 + "                       DT_LTFC_AGREEMENT_SIGNED,  "
                                                                 + "                       IND_CHILD_CONNECT_ADULT,  "
                                                                 + "                       ID_PERSON_CONNECTED_ADULT, "
                                                                 + "                       DT_LAST_PLCMT_LOG_VIEW )"
                                                                 + "  VALUES (:idCase, "
                                                                 + "          :dtPlcmtPermEff, "
                                                                 + "          :idPlcmtEvent, " + "          null, "
                                                                 + "          :idPlcmtChild, "
                                                                 + "          :cdAddrPlcmtCity, "
                                                                 + "          :cdAddrPlcmtCnty, "
                                                                 + "          :cdAddrPlcmtLn1, "
                                                                 + "          :cdAddrPlcmtLn2, "
                                                                 + "          :cdAddrPlcmtSt, "
                                                                 + "          :cdAddrPlcmtZip, "
                                                                 + "          :cdCdPlcmtInfo1, "
                                                                 + "          :cdCdPlcmtInfo2, "
                                                                 + "          :cdCdPlcmtInfo3, "
                                                                 + "          :cdCdPlcmtInfo4, "
                                                                 + "          :cdCdPlcmtInfo5, "
                                                                 + "          :cdCdPlcmtInfo6, "
                                                                 + "          :cdCdPlcmtInfo7, "
                                                                 + "          :cdCdPlcmtInfo8, "
                                                                 + "          :cdCdPlcmtInfo9, "
                                                                 + "          :cdCdPlcmtInfo10, "
                                                                 + "          :cdCdPlcmtInfo11, "
                                                                 + "          :cdCdPlcmtInfo12, "
                                                                 + "          :cdCdPlcmtInfo13, "
                                                                 + "          :cdCdPlcmtInfo14, "
                                                                 + "          :cdCdPlcmtInfo15, "
                                                                 + "          :cdCdPlcmtInfo16, "
                                                                 + "          :cdCdPlcmtInfo17, "
                                                                 + "          :cdPlcmtLivArr, "
                                                                 + "          :cdPlcmtRemovalRsn, "
                                                                 + "          :szCdActAtt, "
                                                                 + "          :cdPlcmtType, "
                                                                 + "          :cdPlcmtService, "
                                                                 + "          :dtPlcmtCaregvrDiscuss, "
                                                                 + "          :dtPlcmtChildDiscuss, "
                                                                 + "          :dtPlcmtChildPlan, "
                                                                 + "          :dtPlcmtEducLog, "
                                                                 + "          :dtPlcmtEnd, "
                                                                 + "          :dtPlcmtMeddevHistory, "
                                                                 + "          :dtPlcmtParentsNotif, "
                                                                 + "          :dtPlcmtPreplaceVisit, "
                                                                 + "          :dtPlcmtSchoolRecords, "
                                                                 + "          :dtPlcmtStart, "
                                                                 + "          :indPlcmtContCntct, "
                                                                 + "          :indPlcmtEducLog, "
                                                                 + "          :indPlcmetEmerg, "
                                                                 + "          :indPlcmtNotApplic, "
                                                                 + "          :indPlcmtSchoolDoc, "
                                                                 + "          :indPlcmtFam, "
                                                                 + "          :cdNbrPlcmtPhoneExt, "
                                                                 + "          :cdNbrPlcmtTelephone, "
                                                                 + "          :cdNmPlcmtAgency, "
                                                                 + "          :cdNmPlcmtContact, "
                                                                 + "          :cdNmPlcmtFacil, "
                                                                 + "          :cdNmPlcmtPersonFull, "
                                                                 + "          :indPlcmtWriteHistory, "
                                                                 + "          :cdTxtPlcmtAddrComment, "
                                                                 + "          :cdTxtPlcmtDiscussion, "
                                                                 + "          :txtaSzTxtPlcmtDocuments, "
                                                                 + "          :cdTxtPlcmtRemovalRsn, "
                                                                 + "          :ulContactedById, "
                                                                 + "          :selSzCdMethod, "
                                                                 + "          :szCdTempPlcmtType, "
                                                                 + "          :szTxtTempPlcmtCmnts, "
                                                                 + "          :cbxIndWaiverRequired, "
                                                                 + "          :rbIndCaseHome, "
                                                                 + "          :ulMatch, "
                                                                 + "          :cbxBoardingCounty, "
                                                                 + "          :cbxIndTrialHomeVisit, "
                                                                 + "          :dtCrtBeginDate, "
                                                                 + "          :dtCrtEndDate, "
                                                                 + "          :rbIndPlcmtChPlacedFr, "
                                                                 + "          :rbIndPlcmtChPlacedBy, "
                                                                 + "          :szCdChildTransitionCmnts, "
                                                                 + "          :rbIndPlcmtSafe, "
                                                                 + "          :rbIndPlcmtLeastRestrict, "
                                                                 + "          :rbIndPlcmtAppropriate, "
                                                                 + "          :rbIndPlcmtCloseProxPar, "
                                                                 + "          :rbIndPlcmtCloseProxSchool, "
                                                                 + "          :rbIndConsistent, "
                                                                 + "          :szTxtNoExplainCheckList, "
                                                                 + "          :rbIndExpTrauma, "
                                                                 + "          :szTxtYesExpTrauma, "
                                                                 + "          :rbIndStaySiblings, "
                                                                 + "          :nbrSibinCare, "
                                                                 + "          :nbrSibPlaced, "
                                                                 + "          :szCdSibRsn, "
                                                                 + "          :szCdCCFARsn, "
                                                                 + "          :szCdNoReasonCmnts, "
                                                                 + "          :rbIndPlcmtMatchCCFA, "
                                                                 + "          :szCdPlcmtMatchCCFAReasonCmnts, "
                                                                 + "          :rbIndSuppSupervision, "
                                                                 + "          :szCdSuppSupervisionCmnts, "
                                                                 + "          :txtDtPsychInfo, "
                                                                 + "          :txtSzNmPsychinfo, "
                                                                 + "          :txtDtCasePsychInfo, "
                                                                 + "          :txtSzNmCasePsychinfo, "
                                                                 + "          :txtSzNmMedinfo, "
                                                                 + "          :txtDtCaseMedInfo, "
                                                                 + "          :txtSzNmCaseMedinfo, "
                                                                 + "          :txtSzNmEduinfo, "
                                                                 + "          :txtSzNmCaseEduinfo, "
                                                                 + "          :txtaSzTxtPlcmtCmntsDocuments, "
                                                                 + "          :indLTFCPlacement, "
                                                                 + "          :dtAgreementSigned, "
                                                                 + "          :indConnectedAdult, "
                                                                 + "          :idPersonConnected, " 
                                                                 + "          :dtLastViewPlcmtLog )");
    query.setInteger("idCase", idCase);
    query.setDate("dtLastViewPlcmtLog", dtLastViewPlcmtLog);
    query.setDate("dtPlcmtPermEff", dtPlcmtPermEff);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setString("cdAddrPlcmtCity", cdAddrPlcmtCity);
    query.setString("cdAddrPlcmtCnty", cdAddrPlcmtCnty);
    query.setString("cdAddrPlcmtLn1", cdAddrPlcmtLn1);
    query.setString("cdAddrPlcmtLn2", cdAddrPlcmtLn2);
    query.setString("cdAddrPlcmtSt", cdAddrPlcmtSt);
    query.setString("cdAddrPlcmtZip", cdAddrPlcmtZip);
    query.setString("cdCdPlcmtInfo1", cdCdPlcmtInfo1);
    query.setString("cdCdPlcmtInfo2", cdCdPlcmtInfo2);
    query.setString("cdCdPlcmtInfo3", cdCdPlcmtInfo3);
    query.setString("cdCdPlcmtInfo4", cdCdPlcmtInfo4);
    query.setString("cdCdPlcmtInfo5", cdCdPlcmtInfo5);
    query.setString("cdCdPlcmtInfo6", cdCdPlcmtInfo6);
    query.setString("cdCdPlcmtInfo7", cdCdPlcmtInfo7);
    query.setString("cdCdPlcmtInfo8", cdCdPlcmtInfo8);
    query.setString("cdCdPlcmtInfo9", cdCdPlcmtInfo9);
    query.setString("cdCdPlcmtInfo10", cdCdPlcmtInfo10);
    query.setString("cdCdPlcmtInfo11", cdCdPlcmtInfo11);
    query.setString("cdCdPlcmtInfo12", cdCdPlcmtInfo12);
    query.setString("cdCdPlcmtInfo13", cdCdPlcmtInfo13);
    query.setString("cdCdPlcmtInfo14", cdCdPlcmtInfo14);
    query.setString("cdCdPlcmtInfo15", cdCdPlcmtInfo15);
    query.setString("cdCdPlcmtInfo16", cdCdPlcmtInfo16);
    query.setString("cdCdPlcmtInfo17", cdCdPlcmtInfo17);
    query.setString("cdPlcmtLivArr", cdPlcmtLivArr);
    query.setString("cdPlcmtRemovalRsn", cdPlcmtRemovalRsn);
    query.setString("szCdActAtt", szCdActAtt);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdPlcmtService", cdPlcmtService);
    query.setDate("dtPlcmtCaregvrDiscuss", dtPlcmtCaregvrDiscuss);
    query.setDate("dtPlcmtChildDiscuss", dtPlcmtChildDiscuss);
    query.setDate("dtPlcmtChildPlan", dtPlcmtChildPlan);
    query.setDate("dtPlcmtEducLog", txtDtEduInfo);
    query.setTimestamp("dtPlcmtEnd", dtPlcmtEnd);
    query.setDate("dtPlcmtMeddevHistory", txtDtMedInfo);
    query.setDate("dtPlcmtParentsNotif", dtPlcmtParentsNotif);
    query.setDate("dtPlcmtPreplaceVisit", dtPlcmtPreplaceVisit);
    query.setDate("dtPlcmtSchoolRecords", txtDtCaseEduInfo);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("indPlcmtContCntct", indPlcmtContCntct);
    query.setString("indPlcmtEducLog", cbxIndNAEduInfo);
    query.setString("indPlcmetEmerg", indPlcmetEmerg);
    query.setString("indPlcmtNotApplic", indPlcmtNotApplic);
    query.setString("indPlcmtSchoolDoc", cbxIndNACaseEduInfo);
    query.setString("indPlcmtFam", rbIndPlcmtFamilyLike);
    query.setString("cdNbrPlcmtPhoneExt", cdNbrPlcmtPhoneExt);
    query.setString("cdNbrPlcmtTelephone", cdNbrPlcmtTelephone);
    query.setString("cdNmPlcmtAgency", cdNmPlcmtAgency);
    query.setString("cdNmPlcmtContact", cdNmPlcmtContact);
    query.setString("cdNmPlcmtFacil", cdNmPlcmtFacil);
    query.setString("cdNmPlcmtPersonFull", cdNmPlcmtPersonFull);
    query.setString("indPlcmtWriteHistory", indPlcmtWriteHistory);
    query.setString("cdTxtPlcmtAddrComment", cdTxtPlcmtAddrComment);
    query.setString("cdTxtPlcmtDiscussion", cdTxtPlcmtDiscussion);
    query.setString("txtaSzTxtPlcmtDocuments", txtaSzTxtPlcmtDocuments);
    query.setString("cdTxtPlcmtRemovalRsn", cdTxtPlcmtRemovalRsn);
    query.setInteger("ulContactedById", ulContactedById);
    query.setString("selSzCdMethod", selSzCdMethod);
    query.setString("szCdTempPlcmtType", szCdTempPlcmtType);
    query.setString("szTxtTempPlcmtCmnts", szTxtTempPlcmtCmnts);
    query.setString("cbxIndWaiverRequired", cbxIndWaiverRequired);
    query.setString("rbIndCaseHome", rbIndCaseHome);
    query.setString("ulMatch", ulMatch);
    query.setString("cbxBoardingCounty", cbxBoardingCounty);
    query.setString("cbxIndTrialHomeVisit", cbxIndTrialHomeVisit);
    query.setDate("dtCrtBeginDate", dtCrtBeginDate);
    query.setDate("dtCrtEndDate", dtCrtEndDate);
    query.setString("rbIndPlcmtChPlacedFr", rbIndPlcmtChPlacedFr);
    query.setString("rbIndPlcmtChPlacedBy", rbIndPlcmtChPlacedBy);
    query.setString("szCdChildTransitionCmnts", szCdChildTransitionCmnts);
    query.setString("rbIndPlcmtSafe", rbIndPlcmtSafe);
    query.setString("rbIndPlcmtLeastRestrict", rbIndPlcmtLeastRestrict);
    query.setString("rbIndPlcmtAppropriate", rbIndPlcmtAppropriate);
    query.setString("rbIndPlcmtCloseProxPar", rbIndPlcmtCloseProxPar);
    query.setString("rbIndPlcmtCloseProxSchool", rbIndPlcmtCloseProxSchool);
    query.setString("rbIndConsistent", rbIndConsistent);
    query.setString("szTxtNoExplainCheckList", szTxtNoExplainCheckList);
    query.setString("rbIndExpTrauma", rbIndExpTrauma);
    query.setString("szTxtYesExpTrauma", szTxtYesExpTrauma);
    query.setString("rbIndStaySiblings", rbIndStaySiblings);
    query.setInteger("nbrSibinCare", nbrSibinCare);
    query.setInteger("nbrSibPlaced", nbrSibPlaced);
    query.setString("szCdSibRsn", szCdSibRsn);
    query.setString("szCdCCFARsn", szCdCCFARsn);
    query.setString("szCdNoReasonCmnts", szCdNoReasonCmnts);
    query.setString("rbIndPlcmtMatchCCFA", rbIndPlcmtMatchCCFA);
    query.setString("szCdPlcmtMatchCCFAReasonCmnts", szCdPlcmtMatchCCFAReasonCmnts);
    query.setString("rbIndSuppSupervision", rbIndSuppSupervision);
    query.setString("szCdSuppSupervisionCmnts", szCdSuppSupervisionCmnts);
    query.setDate("txtDtPsychInfo", txtDtPsychInfo);
    query.setString("txtSzNmPsychinfo", txtSzNmPsychinfo);
    query.setDate("txtDtCasePsychInfo", txtDtCasePsychInfo);
    query.setString("txtSzNmCasePsychinfo", txtSzNmCasePsychinfo);
    query.setString("txtSzNmMedinfo", txtSzNmMedinfo);
    query.setDate("txtDtCaseMedInfo", txtDtCaseMedInfo);
    query.setString("txtSzNmCaseMedinfo", txtSzNmCaseMedinfo);
    query.setString("txtSzNmEduinfo", txtSzNmEduinfo);
    query.setString("txtSzNmCaseEduinfo", txtSzNmCaseEduinfo);
    query.setString("txtaSzTxtPlcmtCmntsDocuments", txtaSzTxtPlcmtCmntsDocuments);
    query.setString("indLTFCPlacement", indLTFCPlacement);
    query.setDate("dtAgreementSigned", dtAgreementSigned);
    query.setString("indConnectedAdult", indConnectedAdult);
    query.setParameter("idPersonConnected", idPersonConnected, Hibernate.INTEGER);
    return query.executeUpdate();
  }

  public void savePlacement(Placement placement) {
    getSession().saveOrUpdate(placement);
  }

  public int updatePlacementByIdPlcmtEvent(int idPersMergeForward, int idPersMergeClosed, int idPlcmtEvent) {
    Query query = getSession()
                              .createQuery(
                                           "update Placement p "
                                                           + "   set p.personByIdPlcmtAdult.idPerson = :idPersMergeForward "
                                                           + " where p.personByIdPlcmtAdult.idPerson = :idPersMergeClosed "
                                                           + "   and p.idPlcmtEvent = :idPlcmtEvent");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idPlcmtEvent", idPlcmtEvent);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  // Added for STGAP00013099
  public int updatePlacementWithForwardPerson(int idPersonForward, int idPersonClosed) {
    Query query = getSession().createQuery(
                                           "update Placement p "
                                                           + "set p.personByIdPlcmtChild.idPerson = :idPersonForward "
                                                           + "where p.personByIdPlcmtChild.idPerson = :idPersonClosed");
    query.setInteger("idPersonForward", idPersonForward);
    query.setInteger("idPersonClosed", idPersonClosed);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  // Added for STGAP00013099
  public List<Placement> findPlacementByIdPlcmtChild(int idPersonClosed) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPersonClosed ");
    query.setInteger("idPersonClosed", idPersonClosed);
    return (List<Placement>) query.list();

  }

  public Object[] findPlacementByIdPlcmtEvent(Date dtDtPlcmtStart, Date dtDtPlcmtEnd, Date tsLastUpdate,
                                              int idPlcmtEvent) {
    /*
     * SQLQuery query = getSession().createSQLQuery( "SELECT ID_PLCMT_EVENT, " + " trunc(DT_PLCMT_START), " + "
     * trunc(DT_PLCMT_END), " + " trunc(:dtDtPlcmtStart), " + " trunc(:dtDtPlcmtEnd) " + " FROM PLACEMENT " + " WHERE
     * ID_PLCMT_EVENT = :idPlcmtEvent " + " AND DT_LAST_UPDATE = :tsLastUpdate"); query.setTimestamp("dtDtPlcmtStart",
     * dtDtPlcmtStart); query.setTimestamp("dtDtPlcmtEnd", dtDtPlcmtEnd); query.setInteger("idPlcmtEvent",
     * idPlcmtEvent); query.setTimestamp("tsLastUpdate", tsLastUpdate); query.addScalar("idPlcmtEvent",
     * Hibernate.INTEGER); query.addScalar("tStart", Hibernate.DATE); query.addScalar("tEnd", Hibernate.DATE);
     * query.addScalar("dStart", Hibernate.DATE); query.addScalar("dEnd", Hibernate.DATE);
     */

    Query query = getSession().createQuery(
                                           "select p.idPlcmtEvent, trunc(p.dtPlcmtStart), trunc(p.dtPlcmtStart) "
                                                           + " from Placement p "
                                                           + " where p.idPlcmtEvent = :idPlcmtEvent "
                                                           + " and p.dtLastUpdate = :tsLastUpdate ");
    /*
     * query.setTimestamp("dtDtPlcmtStart", dtDtPlcmtStart); query.setTimestamp("dtDtPlcmtEnd", dtDtPlcmtEnd);
     */query.setInteger("idPlcmtEvent", idPlcmtEvent);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findCaseManagerofFosterCareChildByResourceId(int idResource) {
    Query query = getSession()
                              .createQuery(
                                           "select new map( sp2.person.idPerson as idPerson , s.idStage as idStage )"
                                                           + " from  StagePersonLink sp1, StagePersonLink sp2,  Stage s, Placement pl "
                                                           + "  where pl.capsResourceByIdRsrcFacil.idResource= :idResource  "
                                                           + "  and pl.personByIdPlcmtChild.idPerson = sp1.person.idPerson "
                                                           + "  and sp1.stage.idStage=sp2.stage.idStage   "
                                                           + "  and s.idStage=sp2.stage.idStage   "
                                                           + "  and s.cdStage='SUB'  "
                                                           + "  and sp2.cdStagePersRole='PR'");

    query.setInteger("idResource", idResource);

    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List findDistinctCaseManagerofFosterCareChildByResourceId(int idResource) {
    Query query = getSession()
                              .createQuery(
                                           "select distinct sp2.person.idPerson as idPerson , s.idStage as idStage "
                                                           + " from  StagePersonLink sp1, StagePersonLink sp2,  Stage s, Placement pl "
                                                           + "  where pl.capsResourceByIdRsrcFacil.idResource= :idResource  "
                                                           + "  and pl.personByIdPlcmtChild.idPerson = sp1.person.idPerson "
                                                           + "  and sp1.stage.idStage=sp2.stage.idStage   "
                                                           + "  and s.idStage=sp2.stage.idStage   "
                                                           + "  and s.cdStage='SUB'  "
                                                           + "  and sp2.cdStagePersRole='PR'");

    query.setInteger("idResource", idResource);

    return (List) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonsByIdPlcmtChildByCapsResourceByIdRsrcFacil(Date dtSysDtGenericSysdate, int ulIdRsrcFacil,
                                                                        String cdPlcmtActPlanned) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.personByIdPlcmtChild.idPerson as personByIdPlcmtChild, "
                                                           + " p.personByIdPlcmtChild.nmPersonFirst as personFirstName,"
                                                           + " p.personByIdPlcmtChild.nmPersonMiddle as personMiddleName,"
                                                           + " p.personByIdPlcmtChild.nmPersonLast as personLastName,"
                                                           + " p.personByIdPlcmtChild.cdPersonSuffix as personSuffix,"
                                                           + " p.personByIdPlcmtChild.dtPersonBirth as personDtOfBirth,"
                                                           + " p.cdPlcmtType as cdPlcmtType,"
                                                           + " p.dtPlcmtStart as dtPlcmtStart,"
                                                           + " s.idStage as idStage)"
                                                           + " from Placement p,"
                                                           + " Event e,"
                                                           + " Stage s"
                                                           + " where p.capsResourceByIdRsrcFacil.idResource = :ulIdRsrcFacil"
                                                           + " and p.dtPlcmtStart <= :dtSysDtGenericSysdate"
                                                           + " and p.dtPlcmtEnd > :dtSysDtGenericSysdate"
                                                           + " and p.cdPlcmtActPlanned = :cdPlcmtActPlanned"
                                                           + " and e.idEvent= p.idPlcmtEvent"
                                                           + " and e.stage.idStage = s.idStage");

    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("ulIdRsrcFacil", ulIdRsrcFacil);
    query.setString("cdPlcmtActPlanned", cdPlcmtActPlanned);

    return (List<Map>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findExchangeHomeInfoByCapsResourceById(int idResource) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.personByIdPlcmtChild.idPerson as personByIdPlcmtChild, "
                                                           + " p.personByIdPlcmtChild.nmPersonFull as nmPersonFull,"
                                                           + " p.dtPlcmtStart as dtPlcmtStart, "
                                                           + " p.dtPlcmtEnd as dtPlcmtEnd, "
                                                           + " p.cdPlcmtRemovalRsn as cdPlcmtRemovalRsn, "
                                                           + " p.personByIdPlcmtChild.dtDissolution as dtDissolution, "
                                                           + " p.personByIdPlcmtChild.idPerson as idChild "
                                                           + " )"
                                                           + " from Placement p, Stage s"
                                                           + " where p.capsResourceByIdRsrcFacil.idResource = :idResource"
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.event.stage.idStage = s.idStage "
                                                           + " and s.cdStage = 'ADO'");

    query.setInteger("idResource", idResource);
    return (List<Map>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public Placement findPlacementLatestApprovedByIdPerson(int idPerson, Date maxDate) {
    Query query = getSession().createQuery(
                                           " from Placement p " + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.dtPlcmtEnd = :maxDate "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtEnd desc");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (Placement) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public Placement findActivePlacementByIdPersonByDateByPlcmntType(int idPerson, Date maxDate, String cdPlacementType) {
    Query query = getSession().createQuery(
                                           " from Placement p " + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.cdPlcmtType = :cdPlacementType "
                                                           + " and (p.dtPlcmtEnd is null or p.dtPlcmtEnd >= :maxDate) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtEnd desc");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlacementType", cdPlacementType);
    query.setTimestamp("maxDate", maxDate);
    return (Placement) firstResult(query);
  }
  

  //STGAP00017058
  @SuppressWarnings( { "unchecked" })
  public List<Placement> findActivePlacementByIdPersonsDatePlcmntType(List<Integer> idPersons, Date maxDate, String cdPlacementType) {
    Query query = getSession().createQuery(
                                           " from Placement p " + " where p.personByIdPlcmtChild.idPerson in (:idPersons) "
                                                           + " and p.cdPlcmtType = :cdPlacementType "
                                                           + " and p.dtPlcmtEnd is not null and p.dtPlcmtEnd < :maxDate "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and (p.event.cdEventStatus = 'APRV' or p.event.cdEventStatus = 'COMP' or p.event.cdEventStatus = 'PEND') "
                                                           + " order by p.dtPlcmtEnd desc");
    query.setParameterList("idPersons", idPersons);
    query.setString("cdPlacementType", cdPlacementType);
    query.setTimestamp("maxDate", maxDate);
    return (List<Placement>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Placement> findPlacementHistoryByIdPersonByIdCase(int idCase, int idPerson, Date maxDate) {

    Query query = getSession().createQuery(
                                           " from Placement pa " + " where pa.capsCase.idCase = :idCase "
                                                           + " and pa.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and pa.cdPlcmtActPlanned = 'A' "
                                                           + " and pa.dtPlcmtEnd < :maxDate "
                                                           + " order by pa.dtPlcmtEnd desc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);

    return (List<Placement>) query.list();
  }

  // STGAP00006138: This Sql is defined for the AFCARS updates
  @SuppressWarnings( { "unchecked" })
  public List<Placement> findPlacementListByIdCaseByIdPerson(int idCase, int idPerson) {

    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.capsCase.idCase = :idCase  "
                                                           + " and p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.dtPlcmtStart>= (select max(cr.dtRemoval) "
                                                           + " from CnsrvtrshpRemoval cr "
                                                           + " where cr.person.idPerson = :idPerson "
                                                           + " and cr.capsCase.idCase = :idCase "
                                                           + " and (cr.dtRemoval is not null and cr.dtRemoval <> :maxDate)) "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtStart desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Placement>) query.list();
  }

  // STGAP00007334:Added this method to retrieve an approved Placement of any placement Type that comes under the CCI
  // Program
  @SuppressWarnings( { "unchecked" })
  public Placement findActivePlacementByIdPersonByDateByPlcmntTypes(int idPerson, Date maxDate,
                                                                    List<String> cdPlacementTypes) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.cdPlcmtType in (:cdPlacementTypes) "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and (p.dtPlcmtEnd is null or p.dtPlcmtEnd >= :maxDate) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtEnd desc");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdPlacementTypes", cdPlacementTypes);
    query.setTimestamp("maxDate", maxDate);
    return (Placement) firstResult(query);
  }

  // STGAP00006420 Added new sqls to check gaps between palcements and display appropriate messages.
  // STGAP00008741: Added acheck in all the sqls to avoid pulling back concurrent and respite placements.
  public Object[] findIdPlcmtEventDtPlcmtEndByMaxDtPlcmtEnd(int idPlcmtChild, int idCase, String dtDtPlcmtStart) {

    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT P.ID_PLCMT_EVENT as idPlcmtEvent, "
                                                                 + "       P.DT_PLCMT_END as dtPlcmtEnd "
                                                                 + "  FROM PLACEMENT P, "
                                                                 + "       EVENT E "
                                                                 + " WHERE P.ID_PLCMT_CHILD = :idPlcmtChild "
                                                                 + "   AND P.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "   AND P.ID_PLCMT_EVENT = E.ID_EVENT "
                                                                 + "   AND E.ID_CASE = :idCase "
                                                                 + "   AND (TO_DATE(:dtDtPlcmtStart,'MM/dd/yyyy hh24:mi:ss') - P.DT_PLCMT_END) >= 1.0 "
                                                                 + "   AND P.DT_PLCMT_END = (SELECT max(P.DT_PLCMT_END) "
                                                                 + "                          FROM PLACEMENT P, "
                                                                 + "                               EVENT E "
                                                                 + "                         WHERE P.ID_PLCMT_CHILD = :idPlcmtChild "
                                                                 + "                           AND P.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                           AND P.ID_PLCMT_EVENT = E.ID_EVENT "
                                                                 + "                           AND (P.CD_TEMP_TYPE is null "
                                                                 + "                           or P.CD_TEMP_TYPE NOT IN ('COR','RED','REN')) "
                                                                 + "                           AND E.ID_CASE = :idCase "
                                                                 + "                           AND P.DT_PLCMT_END <= TO_DATE(:dtDtPlcmtStart, 'MM/dd/yyyy hh24:mi:ss') "
                                                                 + "                           AND trunc(P.DT_PLCMT_START) <> trunc(P.DT_PLCMT_END))");
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idCase", idCase);
    query.setString("dtDtPlcmtStart", dtDtPlcmtStart);
    query.addScalar("idPlcmtEvent", Hibernate.STRING);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Object[] findIdPlcmtEventDtPlcmtEndByMinDtPlcmtStart(int idPlcmtChild, int idCase, String dtDtPlcmtEnd) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT P.ID_PLCMT_EVENT as idPlcmtEvent, "
                                                                 + "       P.DT_PLCMT_START as dtPlcmtStart "
                                                                 + "  FROM PLACEMENT P, "
                                                                 + "       EVENT E "
                                                                 + " WHERE P.ID_PLCMT_CHILD = :idPlcmtChild "
                                                                 + "   AND P.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "   AND P.ID_PLCMT_EVENT = E.ID_EVENT "
                                                                 + "   AND E.ID_CASE = :idCase "
                                                                 + "   AND (P.DT_PLCMT_START - TO_DATE(:dtDtPlcmtEnd,'MM/dd/yyyy hh24:mi:ss')) >= 1.0 "
                                                                 + "   AND P.DT_PLCMT_START = (SELECT min(P.DT_PLCMT_START) "
                                                                 + "                            FROM PLACEMENT P, "
                                                                 + "                                 EVENT E "
                                                                 + "                           WHERE P.ID_PLCMT_CHILD = :idPlcmtChild "
                                                                 + "                             AND P.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                             AND P.ID_PLCMT_EVENT = E.ID_EVENT "
                                                                 + "                           AND (P.CD_TEMP_TYPE is null "
                                                                 + "                           or P.CD_TEMP_TYPE NOT IN ('COR','RED','REN')) "
                                                                 + "                             AND E.ID_CASE = :idCase "
                                                                 + "                             AND P.DT_PLCMT_START >= TO_DATE(:dtDtPlcmtEnd, 'MM/dd/yyyy hh24:mi:ss') "
                                                                 + "                             AND trunc(P.DT_PLCMT_START) <> trunc(P.DT_PLCMT_END))");
    query.setString("dtDtPlcmtEnd", dtDtPlcmtEnd);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idCase", idCase);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Object[] findPlcmtByDtPlcmtStartIdPersonIdCaseAndCurrPlcmtStart(String dtPlcmtStart, int idPlcmtChild,
                                                                         int idCase, String currPlcmtStart) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT P.ID_PLCMT_EVENT as idPlcmtEvent, "
                                                                 + "       P.DT_PLCMT_END as dtPlcmtEnd "
                                                                 + "  FROM PLACEMENT P, EVENT E "
                                                                 + " WHERE P.ID_PLCMT_CHILD = :idPlcmtChild "
                                                                 + "   AND P.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "   AND P.ID_PLCMT_EVENT = E.ID_EVENT "
                                                                 + "   AND E.ID_CASE = :idCase "
                                                                 + "   AND (TO_DATE(:dtPlcmtStart,'MM/dd/yyyy hh24:mi:ss') - P.DT_PLCMT_END) >= 1.0 "
                                                                 + "   AND P.DT_PLCMT_END = (SELECT max(P.DT_PLCMT_END) "
                                                                 + "                          FROM PLACEMENT P, EVENT E "
                                                                 + "                         WHERE P.ID_PLCMT_CHILD = :idPlcmtChild "
                                                                 + "                           AND P.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                           AND P.ID_PLCMT_EVENT = E.ID_EVENT "
                                                                 + "                           AND (P.CD_TEMP_TYPE is null "
                                                                 + "                           or P.CD_TEMP_TYPE NOT IN ('COR','RED','REN')) "
                                                                 + "                           AND E.ID_CASE = :idCase "
                                                                 + "                           AND P.DT_PLCMT_END <= TO_DATE(:currPlcmtStart,'MM/dd/yyyy hh24:mi:ss'))");
    query.setString("dtPlcmtStart", dtPlcmtStart);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idCase", idCase);
    query.setString("currPlcmtStart", currPlcmtStart);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Object[] findPlcmtByDtPlcmtEndIdPersonIdCaseDtCurrPlcmtEnd(String dtPlcmtEnd, int idPlcmtChild, int idCase,
                                                                    String dtCurrPlcmtEnd) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "SELECT P.ID_PLCMT_EVENT as idPlcmtEvent, "
                                                                 + "       P.DT_PLCMT_START as dtPlcmtStart "
                                                                 + "  FROM PLACEMENT P, EVENT E "
                                                                 + " WHERE P.ID_PLCMT_CHILD = :idPlcmtChild "
                                                                 + "   AND P.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "   AND P.ID_PLCMT_EVENT = E.ID_EVENT "
                                                                 + "   AND E.ID_CASE = :idCase "
                                                                 + "   AND (P.DT_PLCMT_START - TO_DATE(:dtPlcmtEnd, 'MM/dd/yyyy hh24:mi:ss')) >= 1.0 "
                                                                 + "   AND P.DT_PLCMT_START = (SELECT min(P.DT_PLCMT_START) "
                                                                 + "                            FROM PLACEMENT P, EVENT E "
                                                                 + "                           WHERE P.ID_PLCMT_CHILD = :idPlcmtChild "
                                                                 + "                             AND P.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                             AND P.ID_PLCMT_EVENT = E.ID_EVENT "
                                                                 + "                           AND (P.CD_TEMP_TYPE is null "
                                                                 + "                           or P.CD_TEMP_TYPE NOT IN ('COR','RED','REN')) "
                                                                 + "                             AND E.ID_CASE = :idCase "
                                                                 + "                             AND P.DT_PLCMT_START >= TO_DATE(:dtCurrPlcmtEnd,'MM/dd/yyyy hh24:mi:ss'))");
    query.setString("dtPlcmtEnd", dtPlcmtEnd);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    query.setInteger("idCase", idCase);
    query.setString("dtCurrPlcmtEnd", dtCurrPlcmtEnd);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  // STGAP00010006 : Gets the placement information of the most recent actual,approved adoptive placement for the given
  // stage and child
  // STGAP00012534 : Changed the query to get county field (addrPlcmtCnty) also.
  @SuppressWarnings( { "unchecked" })
  public Map findRsrcInfoByIdchildByIdStage(int idChild, int idStage) {
    Query query = getSession()
                              .createQuery(
                                           " select new map(p.capsResourceByIdRsrcFacil.nmResource as nmResource , "
                                                           + " p.capsResourceByIdRsrcFacil.ndfcsCertEntity as nmAgency, "
                                                           + "  p.addrPlcmtCnty as addrPlcmtCnty)"
                                                           + " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idChild "
                                                           + " and (p.dtPlcmtEnd is null or p.dtPlcmtEnd >= :maxDate) "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.event.stage.idStage = :idStage "
                                                           + " order by p.dtPlcmtStart desc");
    query.setInteger("idChild", idChild);
    query.setInteger("idStage", idStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);

    return (Map) firstResult(query);
  }

  // STGAP00010006 : Gets the placement end date of the earliest actual,approved placement for the given
  // stage and child
  public Date findPlcmtEndDateByIdChildByStageType(int idChild, String cdStage) {
    Query query = getSession()
                              .createQuery(
                                           " select p.dtPlcmtEnd "
                                                           + " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idChild "
                                                           + " and (p.dtPlcmtEnd is not null and p.dtPlcmtEnd <> :maxDate) "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.event.stage.cdStage = :cdStage "
                                                           + " order by p.dtPlcmtStart asc");
    query.setInteger("idChild", idChild);
    query.setString("cdStage", cdStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);

    return (Date) firstResult(query);
  }

  public Date findAdoDisrPlcmtEndDateByIdChildByStageType(int idChild, String cdStage) {
    Query query = getSession()
                              .createQuery(
                                           " select p.dtPlcmtEnd "
                                                           + " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idChild "
                                                           + " and (p.dtPlcmtEnd is not null and p.dtPlcmtEnd <> :maxDate) "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.event.stage.cdStage = :cdStage "
                                                           + " and p.cdPlcmtRemovalRsn = '" + CodesTables.CRMRSNAC_ADI
                                                           + "'" + " order by p.dtPlcmtStart asc");
    query.setInteger("idChild", idChild);
    query.setString("cdStage", cdStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);

    return (Date) firstResult(query);
  }

  /**
   * Gets the ended placement of the earliest actual,approved adoptive placement for the given stage and child
   * 
   * @param idChild
   * @param idStage
   * @return
   */
  public Placement findEndedPlcmtByIdChildByStageType(int idChild, String cdStage) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idChild "
                                                           + " and (p.dtPlcmtEnd is not null and p.dtPlcmtEnd <> :maxDate) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.event.stage.cdStage = :cdStage "
                                                           + " order by p.dtPlcmtStart asc");

    query.setInteger("idChild", idChild);
    query.setString("cdStage", cdStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);

    return (Placement) firstResult(query);
  }

  /**
   * Gets the ended placement of the latest actual,approved adoptive placement for the given stage and child
   * 
   * @param idChild
   * @param idStage
   * @return
   */
  public Placement findLatestEndedPlcmtByIdChildByStageType(int idChild, String cdStage) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idChild "
                                                           + " and (p.dtPlcmtEnd is not null and p.dtPlcmtEnd <> :maxDate) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.event.stage.cdStage = :cdStage "
                                                           + " order by p.dtPlcmtStart DESC");

    query.setInteger("idChild", idChild);
    query.setString("cdStage", cdStage);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);

    return (Placement) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  // STGAP00010006 : Gets the placement information of the most recent actual,approved placement for the given
  // case and child
  public Placement findLatestApprovedPlacementByIdPersonByIdCase(int idPerson, int idCase, Date maxDate) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.capsCase.idCase = :idCase "
                                                           + " and p.dtPlcmtEnd = :maxDate "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtEnd desc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setTimestamp("maxDate", maxDate);
    return (Placement) firstResult(query);
  }

  // SMS #109403: MR-082
  // Gets the the most recent actual and approved placement record for the given child
  @SuppressWarnings( { "unchecked" })
  public Placement findLatestApprovedPlacementByIdPersonOrderByDtPlcmtStart(int idPerson, Date maxDate) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.dtPlcmtEnd = :maxDate "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtStart desc");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (Placement) firstResult(query);
  }

  // STGAP00017831: MR-102
  // Gets the the most recent, current, actual and approved placement record for the given child
  // who is the Primary Child(PC) of a stage and the Placement Start Date is earlier or equal 
  // to the Begin Date of the earliest Service Authorization Detail for the person receiving services 
  // AND the Placement End Date must be later than the Begin Date of the earliest Service Authorization Detail 
  // for the person receiving services
  // STGAP00018012: MR-102
  // When the Placement Start and End Date are compared with the Service Authorization Detail Begin Date
  // the timestamp will be truncated so that the comparison should occur per date not per exact timestamp
  @SuppressWarnings( { "unchecked" })
  public Placement findLatestApprovedPlacementByIdPersonBySvcAuthDetail(int idPerson, Date dtSvcAuthDtlBegin) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and trunc(p.dtPlcmtStart) <> trunc(p.dtPlcmtEnd) "
                                                           + " and trunc(p.dtPlcmtStart) <= trunc(:dtSvcAuthDtlBegin) "
                                                           + " and trunc(p.dtPlcmtEnd) > trunc(:dtSvcAuthDtlBegin) "
                                                           + " order by p.dtPlcmtStart desc ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSvcAuthDtlBegin", dtSvcAuthDtlBegin);
    return (Placement) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  // STGAP00010749: Gets the the most recent actual,approved placement record for the given
  // stage and child.
  public Placement findCurrentAdoPlcmtByIdPersonByIdStage(int idPerson, int idStage) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p join fetch p.capsResourceByIdRsrcFacil "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.event.stage.idStage = :idStage "
                                                           + " and p.dtPlcmtEnd = :maxDate "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtEnd desc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Placement) firstResult(query);
  }

  // MR-092 Find last placement in stage
  public Placement findLastPlcmtByIdPersonByIdStage(int idPerson, int idStage) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p join fetch p.capsResourceByIdRsrcFacil "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.event.stage.idStage = :idStage "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtEnd desc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (Placement) firstResult(query);
  }

  // STGAP00014993 Added findOpenOrClosedPlacementLatestApprovedByIdPerson method to get
  // latest open or closed approved placement for a given person.
  @SuppressWarnings( { "unchecked" })
  public Placement findOpenOrClosedPlacementLatestApprovedByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           " from Placement p " + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " order by p.dtPlcmtEnd desc");
    query.setInteger("idPerson", idPerson);
    return (Placement) firstResult(query);
  }

  // 41275 : Gets the the most recent actual,approved FCC placement record for the given
  // case and child.
  public Placement findMostRecentPlcmtByIdPersonByIdCase(int idPerson, int idCase) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.event.capsCase.idCase = :idCase "
                                                           + " and p.dtPlcmtEnd = :maxDate "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.event.stage.cdStage = 'SUB' "
                                                           + " and p.dtPlcmtStart =  "
                                                           + "     (select "
                                                           + "      max(p2.dtPlcmtStart) "
                                                           + "      from Placement p2 "
                                                           + "      where p2.personByIdPlcmtChild.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "      and p2.event.capsCase.idCase = p.event.capsCase.idCase "
                                                           + "      and p2.event.cdEventStatus = 'APRV' "
                                                           + "      and p2.cdPlcmtActPlanned = 'A' "
                                                           + "      and (p2.cdTempType is null or p2.cdTempType not in ('RED','REN','COR')) "
                                                           + "      and p2.dtPlcmtEnd = :maxDate " + "      ) ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Placement) firstResult(query);
  }

  /**
   * This method takes the functionality of all findPlacementByIdRsrcFacilAndOrderBy(DT_START,DT_END, etc.) methods and
   * takes in a parameter that is a string describing the ORDER BY parameter.
   * 
   * @param idRrscFacilList
   * @param idRrscAgencyList
   * @param pageNbr
   * @param pageSize
   * @param strOrderBy
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  private PaginatedHibernateList<Object[]> findPlacementByIdRsrcFacilAndOrderByParam(List<Integer> idRrscFacilList,
                                                                                     List<Integer> idRrscAgencyList,
                                                                                     int pageNbr, int pageSize,
                                                                                     String strOrderBy) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "   SELECT A.DT_PLCMT_START as dtPlcmtStart, "
                                                                 + "          A.DT_PLCMT_END as dtPlcmtEnd, "
                                                                 + "          A.CD_PLCMT_REMOVAL_RSN as cdPlcmtRemovalRsn, "
                                                                 + "          B.ID_PERSON as idPerson, "
                                                                 + "          B.NM_PERSON_FULL as nmPersonFull, "
                                                                 + "          B.DT_PERSON_BIRTH as dtPersonBirth, "
                                                                 + "          L.CD_LEGAL_STAT_STATUS as cdLegalStatStatus, "
                                                                 + "          A.ID_CASE as idCase, "
                                                                 + "          B.CD_PERSON_SEX as cdPersonSex, "
                                                                 + "          B.NBR_PERSON_AGE as nbrPersonAge, "
                                                                 + "          A.CD_PLCMT_TYPE as cdPlcmtType, "
                                                                 + "          L.CD_LEGAL_STAT_CNTY as cdLegalStatCnty, "
                                                                 + "          A.CD_PLCMT_SIBLING as cdPlcmtSibling, "
                                                                 + "          S.ID_STAGE as idStage, "
                                                                 + "          S.IND_STAGE_SEALED as indStageSealed, "
                                                                 + "          A.ID_RSRC_FACIL as idRsrcFacil, "
                                                                 + "          A.ID_RSRC_AGENCY as idRsrcAgency, "
                                                                 + "          A.NM_PLCMT_FACIL as nmPlcmtFacil, "
                                                                 + "          A.CD_TEMP_TYPE as cdTempType, "
                                                                 + "          A.ID_PLCMT_EVENT as idPlcmtEvent"
                                                                 + "     FROM PLACEMENT A, "
                                                                 + "          PERSON B, "
                                                                 + "          Event E, "
                                                                 + "          Stage S,"
                                                                 + "          LEGAL_STATUS L, "
                                                                 + "          (   SELECT MAX (L2.DT_LEGAL_STAT_STATUS_DT) as legal_status_date, "
                                                                 + "                     B2.ID_PERSON as id_person "
                                                                 + "                FROM LEGAL_STATUS L2, PERSON B2, PLACEMENT A2 "
                                                                 + "      WHERE (A2.ID_RSRC_FACIL IN (:idRrscFacilList) OR A2.ID_RSRC_AGENCY IN (:idRrscAgencyList)) "
                                                                 + "                 AND A2.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "                 AND B2.ID_PERSON = A2.ID_PLCMT_CHILD "
                                                                 + "                 AND B2.ID_PERSON = L2.ID_PERSON "
                                                                 + "            GROUP BY B2.ID_PERSON  ) max_legal_status "
                                                                 + "      WHERE ((A.ID_RSRC_FACIL IN (:idRrscFacilList))"
                                                                 + "      OR ((A.ID_RSRC_AGENCY IN (:idRrscAgencyList)) AND (S.CD_STAGE <> 'PAD'))) "
                                                                 + "      AND A.CD_PLCMT_ACT_PLANNED = 'A' "
                                                                 + "      AND B.ID_PERSON = A.ID_PLCMT_CHILD "
                                                                 + "      AND E.ID_EVENT = A.ID_PLCMT_EVENT "
                                                                 + "      AND (E.CD_EVENT_STATUS = 'APRV' or E.CD_EVENT_STATUS = 'COMP' or E.CD_EVENT_STATUS = 'PEND')"
                                                                 + "      AND E.ID_EVENT_STAGE = S.ID_STAGE "
                                                                 + "      AND B.ID_PERSON = L.ID_PERSON(+) "
                                                                 + "      AND NVL(L.DT_LEGAL_STAT_STATUS_DT,sysdate+1) = NVL(max_legal_status.legal_status_date,sysdate+1) "
                                                                 + "      AND B.ID_PERSON = max_legal_status.id_person(+) "
                                                                 + "ORDER BY " + strOrderBy);
    query.setParameterList("idRrscFacilList", idRrscFacilList);
    query.setParameterList("idRrscAgencyList", idRrscAgencyList);
    query.addScalar("dtPlcmtStart", Hibernate.DATE);
    query.addScalar("dtPlcmtEnd", Hibernate.DATE);
    query.addScalar("cdPlcmtRemovalRsn", Hibernate.STRING);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("dtPersonBirth", Hibernate.DATE);
    query.addScalar("cdLegalStatStatus", Hibernate.STRING);
    query.addScalar("idCase", Hibernate.INTEGER);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("nbrPersonAge", Hibernate.INTEGER);
    query.addScalar("cdPlcmtType", Hibernate.STRING);
    query.addScalar("cdLegalStatCnty", Hibernate.STRING);
    query.addScalar("cdPlcmtSibling", Hibernate.STRING);
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("indStageSealed", Hibernate.STRING);
    query.addScalar("idRsrcFacil", Hibernate.INTEGER);
    query.addScalar("idRsrcAgency", Hibernate.INTEGER);
    query.addScalar("nmPlcmtFacil", Hibernate.STRING);
    query.addScalar("cdTempType", Hibernate.STRING);
    query.addScalar("idPlcmtEvent", Hibernate.INTEGER);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }

  /**
   * SMS#51977 : This method returns the placement if there is not trial home visit and child was alleged while in placement
   *
   */

  public Placement findTrialHomeVisitPlacementByIdPersonDtAllegIncident(int idPerson, Date dtAllegedIncident) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and (p.dtPlcmtEnd = :maxDate or p.dtPlcmtEnd >= :dtAllegedIncident) "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.indTrialHome = 'Y' "
                                                           + " and p.dtPlcmtStart <= :dtAllegedIncident ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setDate("dtAllegedIncident", dtAllegedIncident);
    return (Placement) firstResult(query);
  }
  
  /**
   * This method returns a count of placements and In DFCS Custody legal status permutation for specified child
   * where approved actual placement of specified type(s) was active 
   * during the specified start and end date
   * excluding temporary placement types (Respite Day, Respite Night, Concurrent)
   * 
   * 
   * @param - idPerson Child SHINES person ID
   * @param - placementTypes List of placement types
   * @param - dtStart Date range start date
   * @param - dtEnd Date range end date
   * @return - Long Count of placements and In DFCS Custody legal status permutation that meet criteria
   */
  public Long countActualPlacementsByIdPersonByPlacementTypesDuringStartDateEndDate(int idPerson, List<String> placementTypes, Date dtStart, Date dtEnd){
    SQLQuery query = getSession()
                              .createSQLQuery(
                                           "select count(*) as result "
                                                           + "  from placement p, event ev, stage s, stage_person_link spl, legal_status_view lsv "
                                                           + "   where p.cd_plcmt_type in ( :placementTypes ) "
                                                           + "   AND p.cd_plcmt_act_planned = 'A' "
                                                           + "   AND (p.cd_temp_type is null OR p.cd_temp_type NOT IN ('RED','REN','COR')) "
                                                           + "   AND p.id_plcmt_child = :idPerson "
                                                           + "   AND (p.dt_plcmt_end is null "
                                                           + "     OR p.dt_plcmt_end >= :dtStart) "
                                                           + "   AND p.dt_plcmt_start <= :dtEnd "
                                                           + "   AND p.id_plcmt_event = ev.id_event"
                                                           + "   AND ev.cd_event_status = 'APRV' "
                                                           + "   AND ev.id_event_stage = s.id_stage "
                                                           + "   AND s.cd_stage IN ('SUB', 'ADO') "
                                                           + "   AND s.id_stage = spl.id_stage "
                                                           + "   AND spl.id_person = p.id_plcmt_child "
                                                           + "   AND spl.cd_stage_pers_role = 'PC' "
                                                           + "   AND lsv.id_person = p.id_plcmt_child "
                                                           + "   and lsv.in_dfcs_custody = 'Y' "
                                                           + "   AND (lsv.dt_legal_stat_end is null "
                                                           + "     OR lsv.dt_legal_stat_end >= :dtStart) "
                                                           + "   AND lsv.dt_legal_stat_status_dt <= :dtEnd "
                                                           + "   AND lsv.dt_legal_stat_status_dt <= LEAST(NVL(p.dt_plcmt_end, :maxDate), :dtEnd) "
                                                           + "   AND NVL(lsv.dt_legal_stat_end, :maxDate) >= GREATEST(p.dt_plcmt_start, :dtStart) ");
    
    query.setInteger("idPerson", idPerson);
    query.setParameterList("placementTypes", placementTypes);
    query.setDate("dtStart", dtStart);
    query.setDate("dtEnd", dtEnd);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.addScalar("result", Hibernate.LONG);
    return (Long) query.uniqueResult();
  }
  
  public Placement findMostRecentPlcmtOpenOrClosedByIdPersonByIdCase(int idPerson, int idCase) {
	    Query query = getSession()
	                              .createQuery(
	                                           " from Placement p "
	                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
	                                                           + " and p.event.capsCase.idCase = :idCase "
	                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
	                                                           + " and p.cdPlcmtActPlanned = 'A' "
	                                                           + " and p.dtPlcmtStart =  "
	                                                           + "     (select "
	                                                           + "      max(p2.dtPlcmtStart) "
	                                                           + "      from Placement p2 "
	                                                           + "      where p2.personByIdPlcmtChild.idPerson = p.personByIdPlcmtChild.idPerson "
	                                                           + "      and p2.event.capsCase.idCase = p.event.capsCase.idCase "
	                                                           + "      and p2.cdPlcmtActPlanned = 'A' "
	                                                           + "      and (p2.cdTempType is null or p2.cdTempType not in ('RED','REN','COR'))) ");
	    query.setInteger("idPerson", idPerson);
	    query.setInteger("idCase", idCase);
	    return (Placement) firstResult(query);
	  }

  /**
   * CAPTA 4.3 retrieve the placement for the child. Placement info is in COMP or APPRV status.
   */
  @SuppressWarnings( { "unchecked" })
  public Placement findCompAprvPlacementsByIdPerson(Date dtSysDtGenericSysdate, int idVictimChild) {
    Query query = getSession()
                              .createQuery(
                                           "from Placement p"
                                                           + " where p.dtPlcmtStart <= :dtSysDtGenericSysdate "
                                                           + "   and p.personByIdPlcmtChild.idPerson = :idVictimChild "
                                                           + " AND p.event.cdEventStatus in (:compStatus, :aprvStatus) "
                                                           + "   and p.cdPlcmtActPlanned = 'A' "
                                                           + "   and p.dtPlcmtEnd > :dtSysDtGenericSysdate");
    query.setTimestamp("dtSysDtGenericSysdate", dtSysDtGenericSysdate);
    query.setInteger("idVictimChild", idVictimChild);
    query.setString("compStatus", CodesTables.CEVTSTAT_COMP);
    query.setString("aprvStatus", CodesTables.CEVTSTAT_APRV);

    return (Placement) firstResult(query);
  }

  // MR-087 get latest open approved placement for idPerson in idCase
  public Placement findMostRecentPlcmtByIdPersonByIdCaseByCdStages(int idPerson, int idCase, List<String> cdStages) {
    Query query = getSession()
                              .createQuery(
                                           " from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson = :idPerson "
                                                           + " and p.event.capsCase.idCase = :idCase "
                                                           + " and p.dtPlcmtEnd = :maxDate "
                                                           + " and (p.cdTempType is null or p.cdTempType not in ('RED','REN','COR')) "
                                                           + " and p.cdPlcmtActPlanned = 'A' "
                                                           + " and p.event.cdEventStatus = 'APRV' "
                                                           + " and p.event.stage.cdStage IN ( :cdStages ) "
                                                           + " and p.dtPlcmtStart =  "
                                                           + "     (select "
                                                           + "      max(p2.dtPlcmtStart) "
                                                           + "      from Placement p2 "
                                                           + "      where p2.personByIdPlcmtChild.idPerson = p.personByIdPlcmtChild.idPerson "
                                                           + "      and p2.event.capsCase.idCase = p.event.capsCase.idCase "
                                                           + "      and p2.event.cdEventStatus = 'APRV' "
                                                           + "      and p2.cdPlcmtActPlanned = 'A' "
                                                           + "      and p2.event.stage.cdStage IN ( :cdStages ) "
                                                           + "      and (p2.cdTempType is null or p2.cdTempType not in ('RED','REN','COR')) "
                                                           + "      and p2.dtPlcmtEnd = :maxDate ) ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setParameterList("cdStages", cdStages);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Placement) firstResult(query);
  }

}
