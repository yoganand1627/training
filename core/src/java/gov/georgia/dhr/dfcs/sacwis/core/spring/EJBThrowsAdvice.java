/**
 * Created on Jun 26, 2007 at 2:09:11 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import javax.ejb.EJBException;

public class EJBThrowsAdvice extends HibernateThrowsAdvice {
  @SuppressWarnings({"ProhibitedExceptionDeclared"})
  public void afterThrowing(EJBException e) throws Throwable {
    Throwable cause = e.getCause();
    if (cause != null) {
      translateException(cause);
    } else if (null != (cause = e.getCausedByException())) {
      translateException(cause);
    }
    throw e;
  }
}
