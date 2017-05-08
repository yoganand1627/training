package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomeResourceOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeResourceOutbound;

import java.util.Map;

import org.hibernate.Query;

public class IncomeResourceOutboundDAOImpl extends BaseDAOImpl implements IncomeResourceOutboundDAO {

  public int saveIncomeResourceOutbound(IncomeResourceOutbound incomeResourceOutbound) {
    getSession().saveOrUpdate(incomeResourceOutbound);
    return incomeResourceOutbound.getIdIncomeResourceOutbound();
  }
  @SuppressWarnings({"unchecked"})
  public Map findIdInitiatorAndIdPerson(int idIncomeResourceOutbound) {
    Query query = getSession().createQuery(" select new Map( io.idPerson as idPerson," +
                                           " io.idInitiator as idInitiator)" +                                           
                                           "   from IncomeResourceOutbound io  " +
                                           "  where io.idIncomeResourceOutbound = :idIncomeResourceOutbound ");
    
    query.setInteger("idIncomeResourceOutbound", idIncomeResourceOutbound);
    return (Map) query.uniqueResult();
  }
}
