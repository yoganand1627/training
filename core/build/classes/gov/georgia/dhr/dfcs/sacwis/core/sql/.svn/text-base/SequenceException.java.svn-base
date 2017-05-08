/**
 * Created on Sep 22, 2005 at 10:05:00 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.sql;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

/**
 * This exception indicates that there are no more sequences available for a given table; it is a runtime exception
 * becuase this case cannot be recovered from and should force a message page.
 */
public class SequenceException extends RuntimeException {
  private String tableName;

  /**
   * Constructs a new runtime exception indicating that the database is out of sequence numbers. The cause is not
   * initialized, and may subsequently be initialized by a call to {@link #initCause}.
   *
   * @param tableName the detail message. The table name .
   */
  protected SequenceException(String tableName) {
    // The message lookup must be done at runtime because the message is not guaranteed to be availalbe before initial sync.
    super(MessageLookup.getMessageByNumber(Messages.MSG_ARC_POOL_EMPTY));
    this.tableName = tableName;
  }

  /**
   * Used to get the name of the table for which we are out of keys -- primarily useful for debugging.
   *
   * @return The name of the table for which the sequence was not available.
   */
  public String getTableName() {
    return tableName;
  }
}
