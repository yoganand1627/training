/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesId;

import java.util.Collection;
import java.util.List;

public interface ComplexCodesTablesDAO {
  /**
   * 
   * @param ids
   * @return
   */
  public List<CodesTables> findCodesTablesByIdList(List<CodesTablesId> ids);
  /**
   * Save or Update list of Codes Tables records
   * @param ctList
   * @return
   */
  public List<CodesTablesId> saveCodesTablesList(Collection<CodesTables> ctList);
  /**
   * Delete list of Codes Tables records
   * @param ctList
   */
  public int deleteCodesTablesList(Collection<CodesTables> ctList);
  
  /**
   * 
   * @param ctList
   * @return
   */
  public int updateCodesTablesList(Collection<CodesTables> ctList);

}
