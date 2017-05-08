package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FaHomeIntEthnicDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FaHomeIntEthnic;
import gov.georgia.dhr.dfcs.sacwis.db.FaHomeIntEthnicId;

import java.util.List;

import org.hibernate.Query;

public class FaHomeIntEthnicDAOImpl extends BaseDAOImpl implements FaHomeIntEthnicDAO {
  @SuppressWarnings({"unchecked"})
  public List<FaHomeIntEthnic> findFaHomeIntEthnicByIdResource(int idResource) {
    Query query = getSession().createQuery(" from FaHomeIntEthnic f" +
                                           " where f.id.idResource = :idResource");
    query.setInteger("idResource", idResource);
    return (List<FaHomeIntEthnic>) query.list();
  }

  public void saveFaHomeIntEthnic(FaHomeIntEthnic faHomeIntEthnic) {
    getSession().saveOrUpdate(faHomeIntEthnic);
  }

 /* public void deleteFaHomeIntEthnic(FaHomeIntEthnic faHomeIntEthnic) {
    getSession().delete(faHomeIntEthnic);
  }*/
  
  
  public int deleteFaHomeIntEthnic(FaHomeIntEthnicId faHomeIntEthnicId) {
    Query query = getSession().createQuery(" delete from FaHomeIntEthnic f" +
                                           " where f.id.idResource = :idResource " +
                                           " and f.id.cdFaHomeIntEthnicity = :cdFaHomeIntEthnicity");
    query.setInteger("idResource", faHomeIntEthnicId.getIdResource()); 
    query.setString("cdFaHomeIntEthnicity", faHomeIntEthnicId.getCdFaHomeIntEthnicity());
    return query.executeUpdate();
  }
}
