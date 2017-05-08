package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.PersonLoc;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
/**
 * This is the DAO that conatins the sqls to save and retrieve Payment Of care records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   03/25/08  vdevarak  STGAP00006420: Modified sqls to eliminate Payment of care records that start and end the same 
 *                       day. Modified Sqls to eliminate retrieving the payment of care records that end on the same 
 *                       day as the placement starts .           
 *   11/6/2008 mchillman STGAP00010854: Added method to pull poc by stage 
 *   10/14/09  mxpatel   STGAP00013655: added findPaymentOfCareByIdPersonIdStage method to find any active POC for a given stage and person
 * </pre>
 */

public class PaymentOfCareDAOImpl extends BaseDAOImpl implements PaymentOfCareDAO {
  
  @SuppressWarnings( { "unchecked" })
  public Object[] findPaymentOfCareApprovedByIdPersonByindConcurrentForPerDiem(int idPerson) {
    
    String cdEventStatusAPRV = CodesTables.CEVTSTAT_APRV;
    SQLQuery query = getSession().createSQLQuery("select poc.cd_poc_type, poc.CD_RBWO_PROGRAM " 
                                            + "from Payment_Of_Care poc, Event_Person_Link epl, Event e " 
                                            + "where " 
                                            + "poc.id_poc_event = e.id_Event and " 
                                            + "e.id_Event = epl.id_Event and "
                                            + "epl.id_event = poc.id_poc_event and "
                                            + "poc.dt_Start <= sysdate and "
                                            + "(poc.dt_End >= sysdate or " 
                                            + "poc.dt_End is NULL) and " 
                                            + "(poc.dt_Terminate >= sysdate or " 
                                            + "poc.dt_Terminate is null) and " 
                                            + "e.cd_Event_Status = :cdEventStatusAPRV and " 
                                            + "epl.id_Person = :idPerson and " 
                                            + "poc.ind_Concurrent= 'N'");
    query.setInteger("idPerson", idPerson); 
    query.setString("cdEventStatusAPRV", cdEventStatusAPRV);
    
    return (Object[]) firstResult( query );
  }
  
  @SuppressWarnings( { "unchecked" })
  public Date findPaymentOfCareDateApprovedByIdPersonByindConcurrentForPerDiem(int idPerson) {
    
    String cdEventStatusAPRV = CodesTables.CEVTSTAT_APRV;
    SQLQuery query = getSession().createSQLQuery("select poc.dt_start " 
                                            + "from Payment_Of_Care poc, Event_Person_Link epl, Event e " 
                                            + "where " 
                                            + "poc.id_poc_event = e.id_Event and " 
                                            + "e.id_Event = epl.id_Event and "
                                            + "epl.id_event = poc.id_poc_event and "
                                            + "poc.dt_Start <= sysdate and "
                                            + "(poc.dt_End >= sysdate or " 
                                            + "poc.dt_End is NULL) and " 
                                            + "(poc.dt_Terminate >= sysdate or " 
                                            + "poc.dt_Terminate is null) and " 
                                            + "e.cd_Event_Status = :cdEventStatusAPRV and " 
                                            + "epl.id_Person = :idPerson and " 
                                            + "poc.ind_Concurrent= 'N'");
    query.setInteger("idPerson", idPerson); 
    query.setString("cdEventStatusAPRV", cdEventStatusAPRV);
    
    return (Date) firstResult( query );
  }
  
  /**
   * Retrieve a PAYMENT_OF_CARE row by idEvent
   * 
   * @param idEvent
   * @return PaymentOfCare
   */
  @SuppressWarnings( { "unchecked" })
  public PaymentOfCare findPOC(int idPocEvent) {
    Query query = getSession().createQuery(" from  PaymentOfCare p " + " where p.idPocEvent = :idPocEvent ");

    query.setInteger("idPocEvent", idPocEvent);
    return (PaymentOfCare) firstResult(query);
  }

  /**
   * Inserts/updates an entire row of PAYMENT_OF_CARE table.
   * 
   * @param poc
   */
  public void savePOC(PaymentOfCare poc) {
    getSession().saveOrUpdate(poc);
  }

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare} object.
   * 
   * @param poc
   */
  public int deletePOC(int idPocEvent) {
    Query query = getSession().createQuery(
                                           "delete from PaymentOfCare poc"
                                                           + "       where poc.idPocEvent = :idPocEvent");
    query.setInteger("idPocEvent", idPocEvent);
    return query.executeUpdate();
  }

  public String findPlcmtPOCByIdStageandStartDate(int idStage, Date dtPlcmtStart){
    /*Query query = getSession().createQuery("select p.cdPocType " +
                                           "  from PaymentOfCare p " +
                                           "  join p.event e " +
                                           " where p.idPocEvent = :idStage " +
                                           "   and e.cdEventStatus = 'APRV' " +
                                           "   and trunc(p.dtStart) <= trunc(:dtPlcmtStart) " +
                                           "   and (trunc(p.dtEnd) >= trunc(:dtPlcmtStart) " +
                                           "   or trunc(p.dtTerminate) >= trunc(:dtPlcmtStart))");*/
    String eventStatus = CodesTables.CEVTSTAT_APRV;
    Query query = getSession().createQuery("select p.cdPocType " +
                                              "  from PaymentOfCare p " +
                                              " where p.event.stage.idStage = :idStage " +
                                              "   and p.event.cdEventStatus = :eventStatus " +
                                              "   and trunc(p.dtStart) <= trunc(:dtPlcmtStart)");
                                            //  "   and trunc(p.dtStart) <= trunc(:dtPlcmtStart) " +
                                        //      "   and (trunc(p.dtEnd) >= trunc(:dtPlcmtStart) " +
                                          //    "   or trunc(p.dtTerminate) >= trunc(:dtPlcmtStart))");


    query.setInteger("idStage", idStage);
    query.setTimestamp("dtPlcmtStart", dtPlcmtStart);
    query.setString("eventStatus", eventStatus);
    return (String) firstResult(query);

  }

  
  /**
   * Finds an existing end and terminate dates on the PAYMENT_OF_CARE table for the person
   * 
   * @param idPerson
   * @return Map
   */
  @SuppressWarnings( { "unchecked" })
  public List<Map> findEndAndTerminateDateByIdPerson(int idPerson, String indConcurrent, int idCurrentPoc) {
    Query query = getSession().createQuery(
                                           "select new map( poc.idPocEvent as idPoc, " +
                                           " poc.dtEnd as dtEnd, "
                                                           + "          poc.dtTerminate as dtTerminate,  "
                                                           + "          poc.dtStart as dtStart)"
                                                           + "   from PaymentOfCare poc, EventPersonLink epl "
                                                           + "   where poc.idPocEvent = epl.event.idEvent "
                                                           + "     and epl.person.idPerson = :idPerson "
                                                           + "     and poc.indConcurrent = :indConcurrent " +
                                                                        " and poc.idPocEvent <> :idCurrentPoc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCurrentPoc", idCurrentPoc);
    query.setString("indConcurrent", indConcurrent);
    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public PaymentOfCare findPaymentOfCareApprovedByIdPersonByCdPocTypes( int idPerson, 
                                                                             Collection<String> cdPocTypes,
                                                                             Date todayDate) {
    String cdEventStatusAPRV = CodesTables.CEVTSTAT_APRV;
   
    Query query = getSession().createQuery( " select poc " +
                                            " from PaymentOfCare poc,  EventPersonLink epl " +
                                            " where poc.event.idEvent = epl.event.idEvent " +
                                            " and poc.event.cdEventStatus = :cdEventStatusAPRV " + 
                                            " and poc.dtEnd > :todayDate " +
                                            " and poc.dtTerminate is null " +
                                            " and epl.person.idPerson = :idPerson " +
                                            " and poc.cdPocType in (:cdPocTypes) ");
    query.setInteger("idPerson", idPerson); 
    query.setString("cdEventStatusAPRV", cdEventStatusAPRV);
    query.setTimestamp("todayDate", todayDate);
    query.setParameterList("cdPocTypes", cdPocTypes);
    
    return (PaymentOfCare) firstResult( query );
  }
  
  
  public PaymentOfCare findMostRecentApprovedPOCInFCC( int idPerson, Collection<String> cdPocTypes) {
    String cdEventStatusAPRV = CodesTables.CEVTSTAT_APRV;
    
    Query query = getSession().createQuery( " select poc " +
                                            " from PaymentOfCare poc,  EventPersonLink epl " +
                                            " where poc.event.idEvent = epl.event.idEvent " +
                                            " and poc.event.stage.cdStage = 'SUB' " +
                                            " and poc.event.cdEventStatus = :cdEventStatusAPRV " + 
                                            " and epl.person.idPerson = :idPerson " +
                                            " and poc.cdPocType in (:cdPocTypes) " + 
                                            " order by poc.dtEnd ");
    query.setInteger("idPerson", idPerson); 
    query.setString("cdEventStatusAPRV", cdEventStatusAPRV);
    query.setParameterList("cdPocTypes", cdPocTypes);
    
    return (PaymentOfCare) firstResult( query );    
  }

  //STGAP00013655: added this method to find any active POC in the PFC stage for a given person.
  public PaymentOfCare findPaymentOfCareByIdPersonIdStage( int idPerson, int idStage) {
    
    Query query = getSession().createQuery( " select poc " +
                                            " from PaymentOfCare poc, EventPersonLink epl, Event e " +
                                            " where poc.idPocEvent = epl.event.idEvent " +
                                            " and  epl.event.idEvent =  e.idEvent " +
                                            " and poc.idPocEvent = e.idEvent " +
                                            " and e.stage.idStage = :idStage " +  
                                            " and epl.person.idPerson = :idPerson " +
                                            " and (poc.dtEnd >= sysdate or poc.dtEnd is null ) " +
                                            " and ( poc.dtTerminate is null)");
    query.setInteger("idPerson", idPerson); 
    query.setInteger("idStage", idStage);
        
    return (PaymentOfCare) firstResult( query );    
  }

  
  
  public PaymentOfCare findPaymentOfCareApprovedByIdPersonByCdPocTypesByStage( int idPerson, 
                                                                        Collection<String> cdPocTypes,
                                                                        Date todayDate, 
                                                                        int idStage) {
    String cdEventStatusAPRV = CodesTables.CEVTSTAT_APRV;
    
    Query query = getSession().createQuery( " select poc " +
                                           " from PaymentOfCare poc,  EventPersonLink epl " +
                                           " where poc.event.idEvent = epl.event.idEvent " +
                                           " and poc.event.cdEventStatus = :cdEventStatusAPRV " + 
                                           " and poc.event.stage.idStage = :idStage " + 
                                           " and (poc.dtEnd > :todayDate or poc.dtEnd is NULL)" +
                                           " and poc.dtTerminate is null " +
                                           " and epl.person.idPerson = :idPerson " +
                                           " and poc.cdPocType in (:cdPocTypes) ");
    query.setInteger("idPerson", idPerson); 
    query.setString("cdEventStatusAPRV", cdEventStatusAPRV);
    query.setTimestamp("todayDate", todayDate);
    query.setParameterList("cdPocTypes", cdPocTypes);
    query.setInteger("idStage", idStage); 
    
    return (PaymentOfCare) firstResult( query );
  }
  
  @SuppressWarnings( { "unchecked" })
  public PaymentOfCare findPaymentOfCareApprovedByIdPersonByindConcurrent( int idPerson, 
                                                                           String indConcurrent,Date plcmtStartDate, int idStage) {
    String cdEventStatusAPRV = CodesTables.CEVTSTAT_APRV;
   
    Query query = getSession().createQuery( " select poc " +
                                            " from PaymentOfCare poc,  EventPersonLink epl, Event e " +
                                            " where poc.dtStart<=:plcmtStartDate " +
                                            " and (poc.dtEnd>=:plcmtStartDate " +
                                            " or   poc.dtEnd is NULL) " +
                                            " and (poc.dtTerminate >=:plcmtStartDate " +
                                            " or   poc.dtTerminate is null) " +
                                            " and poc.event.idEvent = epl.event.idEvent " +
                                            " and poc.event.idEvent = e.idEvent " +
                                            " and poc.event.cdEventStatus = :cdEventStatusAPRV " + 
                                            " and poc.event.stage.idStage = :idStage " + 
                                            " and epl.person.idPerson = :idPerson " +
                                            " and poc.indConcurrent=:indConcurrent ");
    query.setInteger("idStage", idStage); 
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatusAPRV", cdEventStatusAPRV);
    query.setTimestamp("plcmtStartDate", plcmtStartDate);
    query.setString("indConcurrent", indConcurrent);
    
    return (PaymentOfCare) firstResult( query );
  }
  
  public PaymentOfCare findMostRecentPaymentOfCareByIdPerson(int idPerson, Date todayDate) {
    Query query = getSession().createQuery(" select poc " +
                " from PaymentOfCare poc, EventPersonLink epl, Event e " +
                                           " where epl.person.idPerson = :idPerson " +
                                           " and poc.event.idEvent = epl.event.idEvent " +
                                           " and poc.event.idEvent = e.idEvent " +
                                           " and ( poc.dtEnd is null or poc.dtEnd > :todayDate ) " +
                                           " and ( poc.dtTerminate is null or poc.dtTerminate > :todayDate )" );
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("todayDate", todayDate);
    return (PaymentOfCare) firstResult(query);
  }
  
  public PaymentOfCare findMostRecentPaymentOfCareByIdPersonAndStage(int idPerson, Date todayDate, int idStage) {
    Query query = getSession().createQuery(" select poc " +
                " from PaymentOfCare poc, EventPersonLink epl, Event e " +
                                           " where epl.person.idPerson = :idPerson " +
                                           " and poc.event.idEvent = epl.event.idEvent " +
                                           " and poc.event.idEvent = e.idEvent " +
                                           " and e.stage.idStage = :idStage " +
                                           " and ( poc.dtEnd is null or poc.dtEnd > :todayDate ) " +
                                           " and ( poc.dtTerminate is null or poc.dtTerminate > :todayDate )" );
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("todayDate", todayDate);
    query.setInteger("idStage", idStage);
    return (PaymentOfCare) firstResult(query);
  }

  
  //STGAP00005989: Added SQLs to give more specific messages on Placement page.
  //Begin
  public Long countFcPaymentOfcare(String indConcurrent, int idStage, int idPlcmtChild){
    Query query = getSession().createQuery("select count(*) " + 
                "  from PaymentOfCare c, Event e, EventPersonLink epl " +
                                          " where c.event.idEvent = e.idEvent " +
                                          " and c.event.idEvent = epl.event.idEvent " +
                                          " and epl.person.idPerson = :idPlcmtChild " +
                                          " and e.cdEventStatus = :status " +
                                          " and (c.dtEnd is null " +
                                          " or c.dtStart<>c.dtEnd) " +
                                          " and (c.dtTerminate is null " +
                                          " or c.dtStart<>c.dtTerminate) " +
                                          " and c.indConcurrent = :indConcurrent " +
                                          " and c.cdPocType in ('RFD','SFD','EFD') " +
                                          " and e.stage.idStage = :idStage ");
    query.setString("status", "APRV");
    query.setString("indConcurrent", indConcurrent);
    query.setInteger("idStage", idStage);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    return (Long) query.uniqueResult();
  }
  
  public Long countRbwoPaymentOfcare(String indConcurrent, int idStage, int idPlcmtChild){
    Query query = getSession().createQuery("select count(*) " + 
                "  from PaymentOfCare c, Event e, EventPersonLink epl " +
                                          " where c.event.idEvent = e.idEvent " +
                                          " and c.event.idEvent = epl.event.idEvent " +
                                          " and epl.person.idPerson = :idPlcmtChild " +
                                          " and e.cdEventStatus = :status " +
                                          " and (c.dtEnd is null " +
                                          " or c.dtStart<>c.dtEnd) " +
                                          " and (c.dtTerminate is null " +
                                          " or c.dtStart<>c.dtTerminate) " +
                                          " and c.indConcurrent = :indConcurrent " +
                                          " and c.cdPocType in ('LOC','RWW') " +
                                          " and e.stage.idStage = :idStage ");
    query.setString("status", "APRV");
    query.setString("indConcurrent", indConcurrent);
    query.setInteger("idStage", idStage);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    return (Long) query.uniqueResult();
  } 
  
  public Long countSubPaymentOfcare(String indConcurrent, int idStage, int idPlcmtChild){
    Query query = getSession().createQuery("select count(*) " + 
                "  from PaymentOfCare c, Event e, EventPersonLink epl " +
                                          " where c.event.idEvent = e.idEvent " +
                                          " and c.event.idEvent = epl.event.idEvent " +
                                          " and epl.person.idPerson = :idPlcmtChild " +
                                          " and e.cdEventStatus = :status " +
                                          " and (c.dtEnd is null " +
                                          " or c.dtStart<>c.dtEnd) " +
                                          " and (c.dtTerminate is null " +
                                          " or c.dtStart<>c.dtTerminate) " +
                                          " and c.indConcurrent = :indConcurrent " +
                                          " and c.cdPocType in ('ERR', 'RCS', 'ERS', 'ESG', 'SUG') " +
                                          " and e.stage.idStage = :idStage ");
    query.setString("status", "APRV");
    query.setString("indConcurrent", indConcurrent);
    query.setInteger("idStage", idStage);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    return (Long) query.uniqueResult();
  }
  
  public Long countNrpSubPaymentOfcare(String indConcurrent, int idStage, int idPlcmtChild){
    Query query = getSession().createQuery("select count(*) " + 
                "  from PaymentOfCare c, Event e, EventPersonLink epl " +
                                          " where c.event.idEvent = e.idEvent " +
                                          " and c.event.idEvent = epl.event.idEvent " +
                                          " and epl.person.idPerson = :idPlcmtChild " +
                                          " and e.cdEventStatus = :status " +
                                          " and (c.dtEnd is null " +
                                          " or c.dtStart<>c.dtEnd) " +
                                          " and (c.dtTerminate is null " +
                                          " or c.dtStart<>c.dtTerminate) " +
                                          " and c.indConcurrent = :indConcurrent " +
                                          " and c.cdPocType in ('NSG', 'NEG') " +
                                          " and e.stage.idStage = :idStage ");
    query.setString("status", "APRV");
    query.setString("indConcurrent", indConcurrent);
    query.setInteger("idStage", idStage);
    query.setInteger("idPlcmtChild", idPlcmtChild);
    return (Long) query.uniqueResult();
  }

  
  @SuppressWarnings( { "unchecked" })
  public PaymentOfCare findPaymentOfCareApprovedByIdPersonByNonConcurrent( int idPerson, Date plcmtStartDate, int idStage) {
    Query query = getSession().createQuery( " select poc " +
                                            " from PaymentOfCare poc,  EventPersonLink epl, Event e " +
                                            " where poc.dtStart<=:plcmtStartDate " +
                                            " and (poc.dtEnd>=:plcmtStartDate " +
                                            " or   poc.dtEnd is NULL) " +
                                            " and (poc.dtTerminate >=:plcmtStartDate " +
                                            " or   poc.dtTerminate is null) " +
                                            " and poc.event.idEvent = epl.event.idEvent " +
                                            " and poc.event.idEvent = e.idEvent " +
                                            " and poc.event.cdEventStatus = :cdEventStatusAPRV " + 
                                            " and poc.event.stage.idStage = :idStage " + 
                                            " and epl.person.idPerson = :idPerson " +
                                            " and (poc.indConcurrent = :indConcurrent " +
                                            " or   poc.indConcurrent is NULL) ");
    query.setInteger("idStage", idStage); 
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatusAPRV", CodesTables.CEVTSTAT_APRV);
    query.setTimestamp("plcmtStartDate", plcmtStartDate);
    query.setString("indConcurrent", "N");
    
    return (PaymentOfCare) firstResult( query );
  }
  
  @SuppressWarnings( { "unchecked" })
  public PaymentOfCare findFcPaymentOfCareApprovedByIdPersonByindConcurrent( int idPerson, 
                                                                           String indConcurrent,Date plcmtStartDate, int idStage) {
  
    Query query = getSession().createQuery( " select poc " +
                                            " from PaymentOfCare poc,  EventPersonLink epl, Event e " +
                                            " where poc.dtStart<=:plcmtStartDate " +
                                            " and (poc.dtEnd is NULL " +
                                            " or poc.dtEnd>:plcmtStartDate) " +
                                            " and (poc.dtTerminate is null " +
                                            " or   poc.dtTerminate >:plcmtStartDate) " +
                                            " and (poc.dtEnd is NULL " +
                                            " or poc.dtStart<>poc.dtEnd) " +
                                            " and (poc.dtTerminate is NULL " +
                                            " or poc.dtStart<>poc.dtTerminate) " +
                                            " and poc.event.idEvent = epl.event.idEvent " +
                                            " and poc.event.idEvent = e.idEvent " +
                                            " and poc.event.cdEventStatus = :cdEventStatusAPRV " + 
                                            " and poc.event.stage.idStage = :idStage " + 
                                            " and epl.person.idPerson = :idPerson " +
                                            " and poc.cdPocType in ('RFD','SFD','EFD') " +
                                            " and poc.indConcurrent=:indConcurrent ");
    query.setInteger("idStage", idStage); 
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatusAPRV", CodesTables.CEVTSTAT_APRV);
    query.setTimestamp("plcmtStartDate", plcmtStartDate);
    query.setString("indConcurrent", indConcurrent);
    
    return (PaymentOfCare) firstResult( query );
  }
  
  @SuppressWarnings( { "unchecked" })
  public PaymentOfCare findRbwoPaymentOfCareApprovedByIdPersonByindConcurrent( int idPerson, 
                                                                           String indConcurrent,Date plcmtStartDate, int idStage) {
  
    Query query = getSession().createQuery( " select poc " +
                                            " from PaymentOfCare poc,  EventPersonLink epl, Event e " +
                                            " where poc.dtStart<=:plcmtStartDate " +
                                            " and (poc.dtEnd is NULL " +
                                            " or poc.dtEnd>:plcmtStartDate) " +
                                            " and (poc.dtTerminate is null " +
                                            " or   poc.dtTerminate >:plcmtStartDate) " +
                                            " and (poc.dtEnd is NULL " +
                                            " or poc.dtStart<>poc.dtEnd) " +
                                            " and (poc.dtTerminate is NULL " +
                                            " or poc.dtStart<>poc.dtTerminate) " +
                                            " and poc.event.idEvent = epl.event.idEvent " +
                                            " and poc.event.idEvent = e.idEvent " +
                                            " and poc.event.cdEventStatus = :cdEventStatusAPRV " + 
                                            " and poc.event.stage.idStage = :idStage " + 
                                            " and epl.person.idPerson = :idPerson " +
                                            " and poc.cdPocType in ('LOC','RWW') " +
                                            " and poc.indConcurrent=:indConcurrent ");
    query.setInteger("idStage", idStage); 
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatusAPRV", CodesTables.CEVTSTAT_APRV);
    query.setTimestamp("plcmtStartDate", plcmtStartDate);
    query.setString("indConcurrent", indConcurrent);
    
    return (PaymentOfCare) firstResult( query );
  }
  
  @SuppressWarnings( { "unchecked" })
  public PaymentOfCare findSubPaymentOfCareApprovedByIdPersonByindConcurrent( int idPerson, 
                                                                           String indConcurrent,Date plcmtStartDate, int idStage) {
  
    Query query = getSession().createQuery( " select poc " +
                                            " from PaymentOfCare poc,  EventPersonLink epl, Event e " +
                                            " where poc.dtStart<=:plcmtStartDate " +
                                            " and (poc.dtEnd is NULL " +
                                            " or poc.dtEnd>:plcmtStartDate) " +
                                            " and (poc.dtTerminate is null " +
                                            " or   poc.dtTerminate >:plcmtStartDate) " +
                                            " and (poc.dtEnd is NULL " +
                                            " or poc.dtStart<>poc.dtEnd) " +
                                            " and (poc.dtTerminate is NULL " +
                                            " or poc.dtStart<>poc.dtTerminate) " +
                                            " and poc.event.idEvent = epl.event.idEvent " +
                                            " and poc.event.idEvent = e.idEvent " +
                                            " and poc.event.cdEventStatus = :cdEventStatusAPRV " + 
                                            " and poc.event.stage.idStage = :idStage " + 
                                            " and epl.person.idPerson = :idPerson " +
                                            " and poc.cdPocType in ('ERR', 'RCS', 'ERS', 'ESG', 'SUG', 'NSG', 'NEG') " +
                                            " and poc.indConcurrent=:indConcurrent ");
    query.setInteger("idStage", idStage); 
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatusAPRV", CodesTables.CEVTSTAT_APRV);
    query.setTimestamp("plcmtStartDate", plcmtStartDate);
    query.setString("indConcurrent", indConcurrent);
    
    return (PaymentOfCare) firstResult( query );
  }
  //End
  //STGAP00006420:This method is defined to find start and existing end and terminate 
  //dates on the PAYMENT_OF_CARE table for the person.
  //STGAP00008743: Added aditional check to eliminate concurrent POCs from Gap Check validation.
  @SuppressWarnings( { "unchecked" })
  public List<Map> findEndAndTerminateDateByIdPerson(int idPerson, int idCurrentPoc) {
    Query query = getSession().createQuery(
                                           "select new map( poc.idPocEvent as idPoc, " +
                                           " poc.dtEnd as dtEnd, "
                                                           + "          poc.dtTerminate as dtTerminate,  "
                                                           + "          poc.dtStart as dtStart)"
                                                           + "   from PaymentOfCare poc, EventPersonLink epl "
                                                           + "   where poc.idPocEvent = epl.event.idEvent "
                                                           + "     and epl.person.idPerson = :idPerson "
                                                           + "     and (poc.indConcurrent is null  "
                                                           + "     or poc.indConcurrent = 'N') "
                                                           + "     and poc.idPocEvent <> :idCurrentPoc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCurrentPoc", idCurrentPoc);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public PaymentOfCare findPaymentOfCareByIdPersonByIdStage(int idPerson, int idStage, Date plcmtEnd, 
                                                                  String indCCI, String szPlcmtTempType ) {
    
   
   Query query = getSession().createQuery("select poc " +
                                          "from PaymentOfCare poc, Event  e, EventPersonLink  epl " +
                                          "where poc.event.idEvent = e.idEvent " +
                                          "and poc.event.idEvent =  epl.event.idEvent " +
                                          "and poc.event.stage.idStage = :idStage " +
                                          "and poc.event.cdEventStatus = :cdEventStatusAPRV " +
                                          "and poc.cdPocType in ('LOC','RWW') " +
                                          "and epl.person.idPerson = :idPerson " +
                                          "and poc.indConcurrent = :szPlcmtTempType " +
                                          "and poc.indCCI = :indCCI " +
                                          "and ((poc.dtEnd is NULL) or (poc.dtEnd  >= :plcmtEnd)) " + 
                                          "and ((poc.dtTerminate is NULL) or (poc.dtTerminate >= :plcmtEnd)) " + 
                                          "and poc.dtStart < :plcmtEnd " +
                                          "order by poc.dtStart desc "); 

    query.setInteger("idStage", idStage); 
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("plcmtEnd", plcmtEnd);
    query.setString("szPlcmtTempType", szPlcmtTempType);
    query.setString("indCCI", indCCI);
    query.setString("cdEventStatusAPRV", CodesTables.CEVTSTAT_APRV);
    
    return (PaymentOfCare) firstResult( query );
  }
  
}
