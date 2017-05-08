package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;

import gov.georgia.dhr.dfcs.sacwis.db.FceAfdcIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.db.FceIveIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;

import org.hibernate.Query;

public class FceIncomeDAOImpl extends BaseDAOImpl implements FceIncomeDAO {
  public int updateFceIncomeIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage, long idFcePesonMergeForward) {

    Query query = getSession().createQuery(" update FceIncome" +
                                           " set person.idPerson = :idPersMergeForward," +
                                           " fcePerson.idFcePerson = :idFcePesonMergeForward" +
                                           " where person.idPerson = :idPersMergeClosed" +
                                           " and fceEligibility.idFceEligibility in (select idFceEligibility" +
                                           "                                             from FceEligibility" +
                                           "                                             where stage.idStage = :idStage)");

    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setLong("idFcePesonMergeForward", idFcePesonMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
  
  public void saveFceIncome (FceIncome fceIncome){
     getSession().saveOrUpdate(fceIncome);
  }
  
  public FceIncome findFceIncomeByIdFceIncome(long idFceIncome) {

    Query query = getSession().createQuery(" from FceIncome" +
                                           " where idFceIncome = :idFceIncome");
    query.setLong("idFceIncome", idFceIncome);
    return (FceIncome)query.uniqueResult();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<FceIncome> findFceIncomeByIdFceEligAndIdPerson(long idFceEligibility, long idPerson) {

    Query query = getSession().createQuery(" from FceIncome" +
                                           " where fceEligibility.idFceEligibility = :idFceEligibility" +
                                           " and person.idPerson = :idPerson");
    query.setLong("idFceEligibility", idFceEligibility);
    query.setLong("idPerson", idPerson);
    return (List<FceIncome>)query.list();
  }
  
  public FceAfdcIncomeLimit findAFDCIncomeLimitByNbrCertifiedGroup(long nbrCertifiedGroup) {

    Query query = getSession().createQuery(" from FceAfdcIncomeLimit" +
                                           " where nbrCrtfdGrp = :nbrCrtfdGrp");
    query.setLong("nbrCrtfdGrp", nbrCertifiedGroup);
    return (FceAfdcIncomeLimit)query.uniqueResult();
  }
  
  public FceIveIncomeLimit findIVEIncomeLimitByNbrAge(long nbrAge) {

    Query query = getSession().createQuery(" from FceIveIncomeLimit" +
                                           " where nbrAge = :nbrAge");
    query.setLong("nbrAge", nbrAge);
    return (FceIveIncomeLimit)query.uniqueResult();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<FceIncome> findIncomeForChild (long idFceEligibility) {
    Query query = getSession().createQuery("select fcei " +
                                           "  from FceIncome fcei, " +
                                           "  FcePerson fcep, " + 
                                           "  Person p " +
                                           "  where fcei.fcePerson.idFcePerson = fcep.idFcePerson  " + 
                                           "  and fcei.person.idPerson = p.idPerson   " +
                                           "  and fcei.person.idPerson = p.idPerson  " + 
                                           "  and fcei.fceEligibility.idFceEligibility = :idFceEligibility  " + 
                                           "  and fcep.fceEligibility.idFceEligibility = :idFceEligibility " +
                                           "  and fcei.indIncomeSource = 'Y'  " +   
                                           "  and fcei.indChild = 'Y'");
    
    query.setLong("idFceEligibility", idFceEligibility);
    return (List<FceIncome>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<FceIncome> findResourceForChild (long idFceEligibility) {
    Query query = getSession().createQuery("select fcei " +
                                           "  from FceIncome fcei, " +
                                           "  FcePerson fcep, " + 
                                           "  Person p " +
                                           "  where fcei.fcePerson.idFcePerson = fcep.idFcePerson  " + 
                                           "  and fcei.person.idPerson = p.idPerson   " +
                                           "  and fcei.person.idPerson = p.idPerson  " + 
                                           "  and fcei.fceEligibility.idFceEligibility = :idFceEligibility  " + 
                                           "  and fcep.fceEligibility.idFceEligibility = :idFceEligibility " +
                                           "  and fcei.indResourceSource = 'Y'  " +   
                                           "  and fcei.indChild = 'Y'");
    
    query.setLong("idFceEligibility", idFceEligibility);
    return (List<FceIncome>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<FceIncome> findIncomeForFamily (long idFceEligibility) {
    Query query = getSession().createQuery("select fcei " +
                                           "  from FceIncome fcei, " +
                                           "  FcePerson fcep, " + 
                                           "  Person p " +
                                           "  where fcei.fcePerson.idFcePerson = fcep.idFcePerson  " + 
                                           "  and fcei.person.idPerson = p.idPerson   " +
                                           "  and fcei.person.idPerson = p.idPerson  " + 
                                           "  and fcei.fceEligibility.idFceEligibility = :idFceEligibility  " + 
                                           "  and fcep.fceEligibility.idFceEligibility = :idFceEligibility " +
                                           "  and fcei.indIncomeSource = 'Y'  " +   
                                           "  and fcei.indFamily = 'Y'");
    
    query.setLong("idFceEligibility", idFceEligibility);
    return (List<FceIncome>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<FceIncome> findResourceForFamily (long idFceEligibility) {
    Query query = getSession().createQuery("select fcei " +
                                           "  from FceIncome fcei, " +
                                           "  FcePerson fcep, " + 
                                           "  Person p " +
                                           "  where fcei.fcePerson.idFcePerson = fcep.idFcePerson  " + 
                                           "  and fcei.person.idPerson = p.idPerson   " +
                                           "  and fcei.person.idPerson = p.idPerson  " + 
                                           "  and fcei.fceEligibility.idFceEligibility = :idFceEligibility  " + 
                                           "  and fcep.fceEligibility.idFceEligibility = :idFceEligibility " +
                                           "  and fcei.indResourceSource = 'Y'  " +   
                                           "  and fcei.indFamily = 'Y'");
    
    query.setLong("idFceEligibility", idFceEligibility);
    return (List<FceIncome>) query.list();
  }
}
