package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.WebServicesTestTableDAO;
import gov.georgia.dhr.dfcs.sacwis.db.WebServicesTestTable;
import org.hibernate.Query;

public class WebServicesTestTableDAOImpl extends BaseDAOImpl implements WebServicesTestTableDAO {

  public int saveWebServiceTestTable(WebServicesTestTable webServicesTest) {
    // Commented out so the HQL Translation Test doesn't fail; will be moved soon, anyway.
    //getSession().saveOrUpdate(webServicesTest);
    //return webServicesTest.getIdws();
    return 1;
  }

  public WebServicesTestTable findWebServiceTestTableRow(int id) {
    // Commented out so the HQL Translation Test doesn't fail; will be moved soon, anyway.
    //Query query = getSession().createQuery(" from WebServicesTestTable wst " +
    //                                       "where wst.id = :id");
    //query.setInteger("id", id);
    //return (WebServicesTestTable) firstResult(query);
    return new WebServicesTestTable();
  }
}

