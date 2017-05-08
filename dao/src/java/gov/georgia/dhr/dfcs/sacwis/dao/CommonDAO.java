/**
 * Created on Mar 25, 2006 at 2:10:35 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public interface CommonDAO {
  /**
   * Selects the number of rows in a table with a particular idEvent.  Note that, in order to preserve table names in
   * existing code, and because this particular query is useful for VIEWS that have no corresponding Hibernate objects,
   * this is a SQL query, not a HQL query.
   *
   * @param idEvent
   * @param tableName
   * @return The number of rows for the given idEvent.
   */
  long countRowsByIdEvent(long idEvent, String tableName);

  /**
   * Retreives the dtLastUpdate for a table given the table name and an idEvent.
   *
   * @param tableName The name of the table.
   * @param idEvent   The idEvent value.
   * @return The {@link java.util.Date} object containing the dtLastUpdate value.
   */
  Date findDtLastUpdate(String tableName, int idEvent);

  /**
   * Deletes record for a given event.
   *
   * @param tableName The name of the table.
   * @param idEvent   The idEvent value.
   * @return The {@link java.util.Date} object containing the dtLastUpdate value.
   */  
  int deleteRecordByEvent(String tableName, int idEvent, Date timestamp);
  
  /**
   * This is a convenience method to select the next value from a sequence.
   *
   * @param sequenceName
   * @return The next value from a sequence.
   */
  int getNextval(String sequenceName);

  /**
   * A generic means of loading an object by its id.
   *
   * @param clazz
   * @param id
   */
  public <T extends Object> T getPersistentObject(Class<T> clazz, Serializable id);
}
