package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;

import org.hibernate.Query;

public class CountyBudgetLimitDAOImpl  extends BaseDAOImpl implements CountyBudgetLimitDAO{
  
  public CountyBudgetLimit findCountyBudgetLimitById(int idCountyBudgetLimit){
    Query query = getSession().createQuery(" from CountyBudgetLimit c " +
                                           " where c.idCountyBudgetLimit= :idCountyBudgetLimit ");
    query.setInteger("idCountyBudgetLimit", idCountyBudgetLimit);
    return (CountyBudgetLimit) query.uniqueResult();
  }
  
  public CountyBudgetLimit findCountyBudgetLimitByProgramAndFiscalYear(String county, String program, int year){
    Query query = getSession().createQuery(" from CountyBudgetLimit c " +
                                           "where c.cdProgram = :program " +
                                           "  and c.nbrFiscalYear = :year " +
                                           "  and c.cdCounty = :county");
    query.setString("program", program);
    query.setInteger("year", year);
    query.setString("county", county);
    return (CountyBudgetLimit) firstResult(query);
  }
  
  public int saveOrUpdateCountyBudgetLimit(CountyBudgetLimit cntyBdgtLmt){
    getSession().saveOrUpdate(cntyBdgtLmt);
    return cntyBdgtLmt.getIdCountyBudgetLimit();
  }

}
