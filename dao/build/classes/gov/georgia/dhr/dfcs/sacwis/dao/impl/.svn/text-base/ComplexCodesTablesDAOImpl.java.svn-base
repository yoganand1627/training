package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesId;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthUasEntCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

public class ComplexCodesTablesDAOImpl extends BaseDAOImpl implements ComplexCodesTablesDAO {
  private CodesTablesDAO codesTablesDAO = null;
  public void setCodesTablesDAO(CodesTablesDAO codesTablesDAO) {
    this.codesTablesDAO = codesTablesDAO;
  }
  
  @SuppressWarnings("unchecked")
  public List<CodesTables> findCodesTablesByIdList(List<CodesTablesId> ids) {
    List<CodesTables> ctList;
    if (ids != null && ids.size() > 0) {
      ctList = new ArrayList<CodesTables>();
      for (CodesTablesId id : ids) {
        CodesTables ct = codesTablesDAO.findCodesTablesById(id);
        if (ct != null) {
          ctList.add(ct);
        }
      }
      return ctList;
    } else {
      return null;
    }
  }
  
  public List<CodesTablesId> saveCodesTablesList(Collection<CodesTables> ctList) {
    List<CodesTablesId> ctIdList;
    if (ctList != null && ctList.size() > 0) {
      ctIdList = new ArrayList<CodesTablesId>();
      for (CodesTables codesTables : ctList) {
        codesTablesDAO.saveCodeDetail(codesTables);
        ctIdList.add(codesTables.getId());
      }
      return ctIdList;
    } else {
      return null;
    }
  }
  
  public int deleteCodesTablesList(Collection<CodesTables> ctList) {
    int nRowsDeleted = 0;
    if (ctList != null && ctList.size() > 0) {
      for (CodesTables codesTables : ctList) {
        String codeType = codesTables.getId().getCodeType();
        String code = codesTables.getId().getCode();
        nRowsDeleted = nRowsDeleted + codesTablesDAO.deleteCodeDetailByCodeTypeCode(codeType, code);
      }
    } 
    return nRowsDeleted;
  }
  
  public int updateCodesTablesList(Collection<CodesTables> ctList) {
    int nRowsUpdated = 0;
    if (ctList != null && ctList.size() > 0) {
      for (CodesTables codesTables : ctList) {
        String codeType = codesTables.getId().getCodeType();
        String code = codesTables.getId().getCode();
        nRowsUpdated = nRowsUpdated + codesTablesDAO.updateCodeDetailDtEnd(codeType, code, new Date());
      }
    } 
    return nRowsUpdated;
  }
}
