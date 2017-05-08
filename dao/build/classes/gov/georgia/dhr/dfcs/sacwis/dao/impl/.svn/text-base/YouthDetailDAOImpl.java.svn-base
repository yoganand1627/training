/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.YouthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.YouthDetail;

/**
 * @author hong.van.t.vo
 *
 */
public class YouthDetailDAOImpl extends BaseDAOImpl implements YouthDetailDAO {

  
  public YouthDetail findYouthDetail(int idPerson) {
    Query query = getSession().createQuery(" from YouthDetail y where y.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (YouthDetail)query.uniqueResult();
  }
  
  /* (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.dao.YouthDetailDAO#saveYouthDetail(gov.georgia.dhr.dfcs.sacwis.db.YouthDetail)
   */
  public int saveYouthDetail(YouthDetail youthDetail) {
    getSession().saveOrUpdate(youthDetail);
    return youthDetail.getIdPerson();
  }

}
