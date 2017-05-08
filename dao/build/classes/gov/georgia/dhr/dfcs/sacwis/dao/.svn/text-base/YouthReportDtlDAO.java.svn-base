package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.YouthReportDtl;

import java.util.Date;
import java.util.List;

public interface YouthReportDtlDAO {
  YouthReportDtl findYouthReportDtlById(int idYouthReportDtl);

  YouthReportDtl findYouthReportDtl(int idPerson, Date dtRptPeriodEnd);

  /**
   * find report for all period for a person
   * 
   * @param idPerson
   * @return
   */
  public List<YouthReportDtl> findAllYouthReportDtl(int idPerson);

  void saveYouthReportDtl(YouthReportDtl youthReportDtl);
}
