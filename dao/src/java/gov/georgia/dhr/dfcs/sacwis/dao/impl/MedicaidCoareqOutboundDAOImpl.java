package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidCoareqOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.MedicaidCoareqOutbound;


public class MedicaidCoareqOutboundDAOImpl extends BaseDAOImpl implements MedicaidCoareqOutboundDAO{
  
  
  public int saveMedicaidCoareqOutbound(MedicaidCoareqOutbound medicaidCoareqOutbound){
  
      getSession().saveOrUpdate(medicaidCoareqOutbound);
      return medicaidCoareqOutbound.getIdMedicaidCoareqOutbound();
    }
  
   public Integer findIdEventByIdMedicaidCoareqOutbound(int idMedicaidCoareqOutbound) {
    Query query = getSession().createQuery(" select mco.idEvent" +
                                           "   from MedicaidCoareqOutbound mco  " +
                                           "  where mco.idMedicaidCoareqOutbound = :idMedicaidCoareqOutbound ");
    
    query.setInteger("idMedicaidCoareqOutbound", idMedicaidCoareqOutbound);
    return (Integer) firstResult(query);
  }
  
  
  
  
  
  
  
  
   
}
