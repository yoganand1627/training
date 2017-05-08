/**
 * Created on Mar 25, 2006 at 2:49:14 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation;

import java.sql.Blob;
import java.util.Map;

public interface ExtDocumentationDAO {

  /**
   * Retrieves rows from ExtDocumentation table for the given idCase
   *
   * @param idCase
   * @return List of ExtDocumentation objects
   */
  @SuppressWarnings({"unchecked"})
  PaginatedHibernateList<Map> findExtDocumentationByIdCase(int idCase, int pageNbr, int pageSize);

  /**
   * Save or Updates row into ExtDocumentation table for the given idCase
   *
   * @param extDocumentation A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation} object.
   * @return void.
   */
  public void saveExtDocumentation(ExtDocumentation extDocumentation);
  /**
   * Save or Updates row into ExtDocumentation table for the given idCase
   *
   * @param extDocumentation A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation} object.
   * @return int The number of entities effected by the 'update' operation.
   */
  public int saveNewExtDocumentation(ExtDocumentation extDocumentation);
  /**
   * Returns the Blob data for given idExtDocument id
   *
   * @param idExtDocument id
   * @return Blob
   */
  public Blob findExtDoc(int idExtDocument);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation} object.
   *
   * @param extDocumentation
   */
  void deleteExtDocumentation(ExtDocumentation extDocumentation);

  /**
   * Returns the Blob data for given idExtDocument id
   *
   * @param idExtDocument id
   * @return ExtDocumentation
   */
  public ExtDocumentation findExtDocByIdExtDoc(int idExtDocument);

}
