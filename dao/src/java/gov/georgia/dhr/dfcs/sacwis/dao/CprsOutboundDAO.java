package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CprsOutbound;

import java.util.Date;
import java.util.List;


public interface CprsOutboundDAO {

  public List<Integer> findCasesForCountyAndDate(String county, Date searchDate);
  
  public List<CprsOutbound> findCprsOutboundCasesForCountyAndDate(String county, Date searchDate);
  
  public CprsOutbound findCprsOutboundByCaseId(int idCase);
  
  public int updateProcessedCase(Integer idCase, String error);
  
  public int updateProcessedCases(List<Integer> idCases, String error);
}
