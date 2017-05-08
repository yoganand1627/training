/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.financials;

import gov.georgia.dhr.dfcs.sacwis.db.UasProgramCodeMtnt;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UASProgramCodeMtntDAO {
  
  public List<UasProgramCodeMtnt> findUasProgramCodeMtnts();
  public List<UasProgramCodeMtnt> findActiveUasProgramCodeMtnts();
  public UasProgramCodeMtnt findUasProgramCodeMtnt(int idUasProgramCodeMtnt);
  public UasProgramCodeMtnt findUasProgramCodeMtntByCdUas(String cdUasProgramCode);
  public List<Map> findActiveUasProgramCodes();
  public int updateUasProgramCodeMtnt(int idUasProgramCodeMtnt, 
                                      String cdProgramType,
                                      String txtProgramDesc,
                                      Date dtEffective,
                                      String indCCI,
                                      String indCPA,
                                      String indSvcAuth,
                                      String indPSSF,
                                      String indInvAddOn,
                                      int idPersonLastUpdate);
  public int saveUasProgramCodeMtnt( UasProgramCodeMtnt uasProgramCodeMtnt);
  public Integer findIdUasProgramCodeMtntByCdUas(String cdUasProgramCode);
}
