package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.ComplexUASEntCodeMtntAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASEntCodeMtntAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtntAudit;

import java.util.ArrayList;
import java.util.List;

/**
 * Complex DAO to save collection of records. <p/>
 * 
 * <pre>
 *    Change History:
 *    Date          User              Description
 *    ----------    ------------      --------------------------------------------------
 *    10/02/2011    htvo              Initial class creation           
 * </pre>
 */
public class ComplexUASEntCodeMtntAuditDAOImpl extends BaseDAOImpl implements ComplexUASEntCodeMtntAuditDAO {

  private UASEntCodeMtntAuditDAO uasEntCodeMtntAuditDAO = null;

  public void setUasEntCodeMtntAuditDAO(UASEntCodeMtntAuditDAO uasEntCodeMtntAuditDAO) {
    this.uasEntCodeMtntAuditDAO = uasEntCodeMtntAuditDAO;
  }

  public List<Integer> saveUasEntCodeMtntAuditList(List<UasEntCodeMtntAudit> entAuditList) {
    List<Integer> idEntRowList;
    if (entAuditList != null && entAuditList.size() != 0) {
      idEntRowList = new ArrayList<Integer>();
      for (UasEntCodeMtntAudit uasEntCodeMtntAudit : entAuditList) {
        uasEntCodeMtntAuditDAO.saveUasEntCodeMtntAudit(uasEntCodeMtntAudit);
        idEntRowList.add(uasEntCodeMtntAudit.getIdUasEntCodeMtntAudit());
      }
      return idEntRowList;
    } else {
      return null;
    }
  }

}
