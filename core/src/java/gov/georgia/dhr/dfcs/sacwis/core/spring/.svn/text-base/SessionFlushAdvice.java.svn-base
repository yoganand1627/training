/**
 * Created on Jun 5, 2006 at 7:33:47 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import java.lang.reflect.Method;

import org.hibernate.SessionFactory;
import org.springframework.aop.AfterReturningAdvice;

public class SessionFlushAdvice implements AfterReturningAdvice {
  private HibernateThrowsAdvice hibernateThrowsAdvice;
  private SessionFactory sessionFactory;

  public void setHibernateThrowsAdvice(HibernateThrowsAdvice hibernateThrowsAdvice) {
    this.hibernateThrowsAdvice = hibernateThrowsAdvice;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @SuppressWarnings({"ProhibitedExceptionDeclared"})
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target)
          throws Throwable {
    try {
      sessionFactory.getCurrentSession().flush();
    } catch (Exception e) {
      hibernateThrowsAdvice.translateException(e);
    }
  }
}
