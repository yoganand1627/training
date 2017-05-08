package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.ExtDocumentationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation;

import java.sql.Blob;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;


/**
 *  
 * Change History:
 *   Date        User       Description
 *   ----------  ---------- --------------------------------------------------
 *   08/05/2008  alwilliams STGAP00009424: Updated the query in method findExtDocumentationByIdCase
 *                          to trim the external documentation location (txtExtDocLocation) value
 *                          returned from database.  
 *
 */
public class ExtDocumentationDAOImpl extends BaseDAOImpl implements ExtDocumentationDAO {

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Map> findExtDocumentationByIdCase(int idCase, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("  select new map(e.idExtDocumentation as idExtDocumentation, " +
                                           "                 e.dtLastUpdate as dtLastUpdate, " +
                                           "                 e.capsCase as capsCase, " +
                                           "                 e.dtExtDocObtained as dtExtDocObtained, " +
                                           "                 e.txtExtDocDetails as txtExtDocDetails, " +
                                           "                 e.cdExtDocType as cdExtDocType, " +                                           
                                           "                 trim(e.txtExtDocLocation) as txtExtDocLocation, " +
                                           "                 e.cdExtDocSort as cdExtDocSort, " +
                                           "                 e.indExtDocSigned as indExtDocSigned, " +
                                           "                 e.dtExtDocUploaded as dtExtDocUploaded, " +
                                           "                 e.txtFileName as txtFileName, " +
                                           "                 e.txtFormatType  as txtFormatType, " +
                                           "                 e.cdDocClass as cdDocClass, " +
                                           "                 e.dtExtDocAdded as dtExtDocAdded, " +
                                           "                 e.indNaChecked as indNaChecked) " +
                                           "    from ExtDocumentation e " +
                                           "   where e.capsCase.idCase = :idCase " +
                                           "order by e.cdExtDocSort, " +
                                           "         e.dtExtDocObtained desc ");
    query.setInteger("idCase", idCase);
    // Added pagination to display certain number of records on the Ext Documentation page
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  public void saveExtDocumentation(ExtDocumentation extDocumentation) {
    getSession().saveOrUpdate(extDocumentation);
  }
  
  public int saveNewExtDocumentation(ExtDocumentation extDocumentation) {
	    getSession().saveOrUpdate(extDocumentation);
	    return extDocumentation.getIdExtDocumentation();
  }
  public Blob findExtDoc(int idExtDocument) {
    Session session = getSession();
    SQLQuery query = session.createSQLQuery("SELECT BL_EXT_DOC " +
                                            "  FROM EXT_DOCUMENTATION " +
                                            " WHERE ID_EXT_DOCUMENTATION = :idExtDocumentation");
    query.setInteger("idExtDocumentation", idExtDocument);
    query.addScalar("BL_EXT_DOC", Hibernate.BLOB);
    return (Blob) query.uniqueResult();
  }


  public void deleteExtDocumentation(ExtDocumentation extDocumentation) {
    getSession().delete(extDocumentation);
  }
  
  public ExtDocumentation findExtDocByIdExtDoc(int idExtDocument){
	    Session session = getSession();
	    Query query = session.createQuery("from ExtDocumentation ext " + "where ext.idExtDocumentation = :idExtDocument ");
	    query.setInteger("idExtDocument", idExtDocument);
	    return (ExtDocumentation) firstResult(query);	  
  }

}
