package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.ComplexUASEntCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASEntCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtnt;

import java.util.ArrayList;
import java.util.Collection;
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
public class ComplexUASEntCodeMtntDAOImpl extends BaseDAOImpl implements ComplexUASEntCodeMtntDAO {
  
  private UASEntCodeMtntDAO uasEntCodeMtntDAO = null;

  public void setUasEntCodeMtntDAO(UASEntCodeMtntDAO uasEntCodeMtntDAO) {
    this.uasEntCodeMtntDAO = uasEntCodeMtntDAO;
  }

  public List<Integer> saveUasEntCodeMtntList(Collection<UasEntCodeMtnt> entCodeMtntList) {
    List<Integer> idEntRowList;
    if (entCodeMtntList != null && entCodeMtntList.size() != 0) {
      idEntRowList = new ArrayList<Integer>();
      for (UasEntCodeMtnt uasEntCodeMtnt : entCodeMtntList) {
        uasEntCodeMtntDAO.saveUasEntCodeMtnt(uasEntCodeMtnt);
        idEntRowList.add(uasEntCodeMtnt.getIdUasEntCodeMtnt());
      }
      return idEntRowList;
    } else {
      return null;
    }
  }

}
