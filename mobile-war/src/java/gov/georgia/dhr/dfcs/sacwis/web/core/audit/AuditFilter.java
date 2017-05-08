/**
 * Created on Sep 27, 2006 at 2:11:37 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.audit;

import org.grnds.structural.web.GrndsExchangeContext;

public interface AuditFilter {
  enum AuditFilterCodes {
    DO_LOG, CONTINUE, DO_NOT_LOG
  }

  /**
   * This method is executed every time a Grnds Exchange is completed (during {@link
   * gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation#doEndResponse(org.grnds.structural.web.GrndsExchangeContext)}.
   * Consequently, all implementations should run extremely quickly.  In particular, database lookups should not be
   * preformed.
   * <p/>
   * There are 3 possible results:<ul><li>{@link AuditFilterCodes#DO_LOG} will log immediately.</li><li>{@link
   * AuditFilterCodes#DO_NOT_LOG} will prevent logging and stop further filter evaluation.</li><li>{@link
   * AuditFilterCodes#CONTINUE} will allow the filters to continue executing; by default, logging is done.</li></ul>
   *
   * @param record
   * @param context
   * @return
   * @see gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation#doEndResponse(org.grnds.structural.web.GrndsExchangeContext)
   */
  AuditFilterCodes filter(AuditRecord record, GrndsExchangeContext context);
}
