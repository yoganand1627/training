/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.YouthDetail;

/**
 * @author hong.van.t.vo
 *
 */
public interface YouthDetailDAO {
  public YouthDetail findYouthDetail(int idPerson);
  public int saveYouthDetail(YouthDetail youthDetail);

}
