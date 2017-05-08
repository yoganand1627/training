package gov.georgia.dhr.dfcs.sacwis.dao.financials;

import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtnt;

import java.util.List;
import java.util.Map;

public interface UASEntCodeMtntDAO {
  /**
   * 
   * @param idUasProgramCodeMtnt
   * @return
   */
  public List<UasEntCodeMtnt> findEntCodeMtntsByIdProgram(int idUasProgramCodeMtnt);
  /**
   * 
   * @param idUasEntCodeMtnt
   * @return
   */
  public UasEntCodeMtnt findEntCodeMtntsByIdEnt(int idUasEntCodeMtnt);
  /**
   * 
   * @param idUasProgramCodeMtnt
   * @return
   */
  public List<String> findCdEntListByIdProgram(int idUasProgramCodeMtnt);
  /**
   * 
   * @param idEntProgramCodeMtnt
   * @return
   */
  @SuppressWarnings("rawtypes")
  public Map findEntDetailByIdEnt(int idUasEntCodeMtnt);
  /**
   * 
   * @param cdEntHeader
   * @return
   */
  public List<String> findCdUasByCdEntCodeHeader(String cdEntHeader);
  /**
   * 
   * @param uasEntCodeMtnt
   */
  public void saveUasEntCodeMtnt(UasEntCodeMtnt uasEntCodeMtnt);
  /**
   * 
   * @param idUasProgramCodeMtnt
   * @return
   */
  public List<Map<String, Object>> findCdSvcCodeByIdProgram(int idUasProgramCodeMtnt);
  /**
   * Find the header row case budget limit
   * @param header
   * @return
   */
  public Double findCaseBudgetLimitByHeader(String header);

}
