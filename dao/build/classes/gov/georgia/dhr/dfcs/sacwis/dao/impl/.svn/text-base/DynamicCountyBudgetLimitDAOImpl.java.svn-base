package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DynamicCountyBudgetLimitDAOImpl extends DynamicBaseDAOImpl implements DynamicCountyBudgetLimitDAO {

  @SuppressWarnings({"unchecked"})
  public List<Object[]> findCountyBudgetLimit(String county, String program, int fiscalYear) {
    if(allNullArgs(county, program)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(CountyBudgetLimit.class, "co");
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("co.idCountyBudgetLimit"));
    projectionList.add(Projections.property("co.cdProgram"));
    projectionList.add(Projections.property("co.cdCounty"));
    projectionList.add(Projections.property("co.amtBudgetLimit"));
    projectionList.add(Projections.property("co.amtSpent"));
    projectionList.add(Projections.property("co.amtObg"));
    projectionList.add(Projections.property("co.amtBalance"));
    criteria.setProjection(Projections.distinct(projectionList));
    if (StringHelper.isValid(county)) {
      criteria.add(Restrictions.eq("co.cdCounty", county));
    }
    if (StringHelper.isValid(program)) {
      criteria.add(Restrictions.eq("co.cdProgram", program));
    }
    if (fiscalYear != 0) {
      criteria.add(Restrictions.eq("co.nbrFiscalYear", fiscalYear));
    }
    criteria.addOrder(Order.asc("co.cdProgram"));
    return (List<Object[]>) criteria.list();
  }
  
  public int updateCountyBudgetLimitAmounts(String county, String program, int fiscalYear, double amount, int decrementColumn) {
    StringBuffer sb = new StringBuffer();
    sb.append("update CountyBudgetLimit cbl ");
    sb.append("set cbl.amtSpent = nvl(cbl.amtSpent, 0) + :amount ");
    
    switch(decrementColumn) {
    case AMT_OBG:
      sb.append(", cbl.amtObg = nvl(cbl.amtObg,  0) - :amount ");
      break;
    case AMT_BALANCE:
      sb.append(", cbl.amtBalance = nvl(cbl.amtBalance, 0) - :amount ");
      break;
    }
    
    sb.append("where cbl.cdCounty = :cdCounty ");
    sb.append("and cbl.cdProgram = :cdProgram ");
    sb.append("and cbl.nbrFiscalYear = :nbrFiscalYear");
    
    Query query = getSession().createQuery(sb.toString());
    query.setDouble("amount", amount);
    query.setString("cdCounty", county);
    query.setString("cdProgram", program);
    query.setInteger("nbrFiscalYear", fiscalYear);
    return query.executeUpdate();
  }

}
