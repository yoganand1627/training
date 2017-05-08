package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.ComplexSvcAuthUasEntCodeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.SvcAuthUasEntCodeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthUasEntCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ComplexSvcAuthUasEntCodeDAOImpl extends BaseDAOImpl implements ComplexSvcAuthUasEntCodeDAO {
  private SvcAuthUasEntCodeDAO svcAuthUasEntCodeDAO = null;

  public void setSvcAuthUasEntCodeDAO(SvcAuthUasEntCodeDAO svcAuthUasEntCodeDAO) {
    this.svcAuthUasEntCodeDAO = svcAuthUasEntCodeDAO;
  }
  
  public List<Integer> saveSvcAuthUasEntCodeList(Collection<SvcAuthUasEntCode> saHeaderList) {
    List<Integer> saIdList;
    if (saHeaderList != null && saHeaderList.size() > 0) {
      saIdList = new ArrayList<Integer>();
      for (SvcAuthUasEntCode saHeader : saHeaderList) {
        svcAuthUasEntCodeDAO.saveSvcAuthUasEntCode(saHeader);
        saIdList.add(saHeader.getIdSvcAuthUasEntCode());
      }
      return saIdList;
    } else {
      return null;
    }
  }
  
  public int deleteSvcAuthUasEntCodeList(Collection<SvcAuthUasEntCode> saHeaderList) {
    int nRowsDeleted = 0;
    if (saHeaderList != null && saHeaderList.size() > 0) {
      for (SvcAuthUasEntCode saHeader : saHeaderList) {
        String cdUas = saHeader.getCdUas();
        String cdEnt = saHeader.getCdEnt();
        nRowsDeleted = nRowsDeleted + svcAuthUasEntCodeDAO.deleteSvcAuthUasEntCodeByCdUasCdEnt(cdUas, cdEnt);
      }
    } 
    return nRowsDeleted;
  }

}
