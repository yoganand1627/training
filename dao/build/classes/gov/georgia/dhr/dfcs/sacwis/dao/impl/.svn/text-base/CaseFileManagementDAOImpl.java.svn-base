package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CaseFileManagementDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseFileManagement;
import org.hibernate.Query;

public class CaseFileManagementDAOImpl extends BaseDAOImpl implements CaseFileManagementDAO {
  public CaseFileManagement findCaseFileManagement(int idCase) {

    Query query = getSession().createQuery(" from  CaseFileManagement c " +
                                           " where c.idCaseFileCase = :idCase ");

    query.setInteger("idCase", idCase);

    return (CaseFileManagement) firstResult(query);
  }

  public void saveCaseFileManagement(CaseFileManagement caseFileManagement) {
    getSession().saveOrUpdate(caseFileManagement);
  }

  public void deleteCaseFileManagement(CaseFileManagement caseFileManagement) {
    getSession().delete(caseFileManagement);
  }
}
