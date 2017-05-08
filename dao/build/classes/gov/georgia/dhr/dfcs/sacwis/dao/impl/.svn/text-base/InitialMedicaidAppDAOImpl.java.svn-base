package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.InitialMedicaidAppDAO;
import gov.georgia.dhr.dfcs.sacwis.db.InitialMedParent;
import gov.georgia.dhr.dfcs.sacwis.db.InitialMedicaidApp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

public class InitialMedicaidAppDAOImpl extends BaseDAOImpl implements InitialMedicaidAppDAO {
  
  public int saveInitialMedicaidApp(InitialMedicaidApp initialMedicaidApp) {
    getSession().saveOrUpdate(initialMedicaidApp);
    return initialMedicaidApp.getIdEvent();
  }
  
  public Map findInitialMedicaid(int idEvent) {
    
    Query query = getSession().createQuery(" select distinct new map( i.event.idEvent as idEvent, " +
                                           "                          i.dtLastUpdate as dtLastUpdate, " +
                                           "                          i.indChildPregnancy as indChildPregnancy, " +
                                           "                          i.indChildSupportOrder as indChildSupportOrder, " +
                                           "                          i.indMedicalAsstChild as indMedicalAsstChild, " +
                                           "                          i.dtEstDeliveryDate as dtEstDeliveryDate, " +
                                           "                          i.txtMonths as txtMonths, " +
                                           "                          i.indCaseManagerApply as indCaseManagerApply, " +
                                           "                          i.dtProcessed as dtProcessed, " +
                                           "                          i.txtComments as txtComments, " +
                                           "                          i.indHealthInsuranceCard as indHealthInsuranceCard, " +
                                           "                          i.indParent as indParent, " +
                                           "                          i.indChildCoverage as indChildCoverage, " +
                                           "                          i.nmCompany as nmCompany, " +
                                           "                          i.cdType as cdType, " +
                                           "                          i.nbrPolicy as nbrPolicy, " +
                                           "                          i.nbrGroup as nbrGroup, " +
                                           "                          i.addrStreetLn1 as addrStreetLn1, " +
                                           "                          i.addrStreetLn2 as addrStreetLn2, " +
                                           "                          i.addrCity as addrCity, " +
                                           "                          i.addrState as addrState, " +
                                           "                          i.addrZip as addrZip, " +
                                           "                          i.nbrPhone as nbrPhone, " +
                                           "                          i.nmPolicyHolder as nmPolicyHolder, " +
                                           "                          i.dtBegin as dtBegin, " +
                                           "                          i.dtEnd as dtEnd, " +
                                           "                          i.nmEmployer as nmEmployer, " +
                                           "                          i.nmEmployeeName as nmEmployeeName, " +
                                           "                          i.person.idPerson as idCaseManager, " +
                                           "                          i.dtCmSigned as dtCmSigned, " +
                                           "                          i.indIcamaIcpc as indIcamaIcpc, " +
                                           "                          i.cdIcamaAssistanceType as cdIcamaAsstType, " +
                                           "                          i.cdAdoptionType as cdAdoptionType, " +
                                           "                          i.cdIcamaState as cdIcamaState, " +
                                           "                          i.txtIcamaComments as txtIcamaComments)" +
                                           "   from InitialMedicaidApp i " +
    "  where idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (Map) firstResult(query);
  }
  
  
  public Map findSuccessMedAssistanceByCaseAndStage (long idCase, long idStage, String eventType){
    Query query = getSession().createQuery("  select new map(ini.cdSuccessClassAssistance as cdSuccessClassAssistance, " +
                                           "                 ini.dtSuccClassAssistance as dtSuccClassAssistance) " +
                                           "     from InitialMedicaidApp ini join ini.event e " +
                                           "    where e.capsCase.idCase = :idCase " +
                                           "      and e.stage.idStage = :idStage " +
                                           "      and e.cdEventType = :eventType" +
                                           "      order by ini.dtLastUpdate desc"); 
    query.setLong("idCase", idCase);
    query.setLong("idStage", idStage);
    query.setString("eventType", eventType);
    return (Map) firstResult(query);
  }
  
  
  
  public Integer updateMedicaidCoa(int idEvent, String cdSuccessClassAssistance, Date dtSuccClassAssistance) {
    
    Query query = getSession().createQuery(
                                           "update InitialMedicaidApp" 
                                           + " set cdSuccessClassAssistance = :cdSuccessClassAssistance," 
                                           + " dtSuccClassAssistance = :dtSuccClassAssistance"
                                           + " where idEvent = :idEvent");
    query.setString("cdSuccessClassAssistance", cdSuccessClassAssistance);
    query.setDate("dtSuccClassAssistance", dtSuccClassAssistance);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public Date findDtSuccClassAssiastanceByIdEvent(int idEvent){
    
    Query query = getSession().createQuery( "select ima.dtSuccClassAssistance from InitialMedicaidApp ima " +
    "where ima.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (Date) firstResult(query);
    
  }
  
  public InitialMedicaidApp findInitialMedicaidByIdEvent(int idEvent) {
    
    Query query = getSession().createQuery("from InitialMedicaidApp i " + "where idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (InitialMedicaidApp) firstResult(query);
  }
  
  public void saveInitialMedParent(InitialMedParent initialMedParent){
    getSession().saveOrUpdate(initialMedParent);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> findIndParent(int idStage, int idCase, int idEvent){
    Query query = getSession().createQuery( "select new map(pi.person.idPerson as idPerson, pi.indParent as indParent) "
                                          + "   from StagePersonLink spl, " 
                                          + "        InitialMedParent pi "
                                          + "   where spl.person.idPerson = pi.person.idPerson " 
                                          + "   and spl.stage.idStage = :idStage " 
                                          + "   and spl.capsCase.idCase = :idCase"
                                          + "   and pi.initialMedicaidApp.idEvent = :idEvent");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    query.setInteger("idEvent", idEvent);
    return (List<Map>) query.list();
  }
  
  public Integer updateInitialMedParent(int idPerson , String indParent){
    Query query = getSession().createQuery(
                                           "update InitialMedParent a" 
                                           + " set a.indParent = :indParent "
                                           + " where a.person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    query.setString("indParent", indParent);
    return query.executeUpdate();
    
  }
}