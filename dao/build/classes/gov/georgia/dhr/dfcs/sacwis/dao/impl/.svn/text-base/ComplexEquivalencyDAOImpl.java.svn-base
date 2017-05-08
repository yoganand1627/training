/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEquivalencyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EquivalencyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Equivalency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author hong-van.t.vo
 *
 */
public class ComplexEquivalencyDAOImpl extends BaseDAOImpl implements ComplexEquivalencyDAO {
  private EquivalencyDAO equivalencyDAO = null;

  public EquivalencyDAO getEquivalencyDAO() {
    return equivalencyDAO;
  }

  public void setEquivalencyDAO(EquivalencyDAO equivalencyDAO) {
    this.equivalencyDAO = equivalencyDAO;
  }

  public HashMap<String,Integer> saveEquivalencyList(Collection<Equivalency> eqList) {
    HashMap<String,Integer> idEquivSvcCodeMap = null;
    if (eqList != null && eqList.size() > 0) {
      idEquivSvcCodeMap = new HashMap<String,Integer>();
      for (Equivalency eq : eqList) {
        equivalencyDAO.saveEquivalency(eq);
        idEquivSvcCodeMap.put(eq.getCdEquivSvcDtlService(),eq.getIdEquiv());
      }
    }
    return idEquivSvcCodeMap;
  }

}
