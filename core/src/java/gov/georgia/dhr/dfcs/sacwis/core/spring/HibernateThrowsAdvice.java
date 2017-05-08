/**
 * Created on Jun 3, 2006 at 11:00:08 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.StaleStateException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.InitializingBean;

/**
 * This class controls the logic used to translate various exceptions to ServiceExceptions.  Make sure to search for
 * usages of the static methods when changing this class, particularly when adding exceptions to be translated, as
 * this class cannot, unfortunately, always be properly used as advice.
 */
public class HibernateThrowsAdvice implements InitializingBean, ThrowsAdvice {
  private static final int ORACLE_PRIVILEGES_ERROR_CODE = 1031;

  private final Map<Class, Method> exceptionHandlerMap = new HashMap<Class, Method>();

  public void afterPropertiesSet() {
    // Search this class to find any method named afterThrowing and build a map between exception classes and methods.
    Method[] methods = getClass().getMethods();
    for (int i = 0; i < methods.length; i++) {
      Method method = methods[i];
      Class<?>[] parameterTypes = method.getParameterTypes();
      if ("afterThrowing".equals(method.getName()) && parameterTypes.length == 1) {
        Class exceptionClass = parameterTypes[0];
        if (Throwable.class.isAssignableFrom(exceptionClass)) {
          exceptionHandlerMap.put(exceptionClass, method);
        }
      }
    }
  }

  public void afterThrowing(ServiceException e) throws ServiceException {
    // Null handler to make ServiceException's slightly faster
    throw e;
  }

  public void afterThrowing(StaleStateException e) throws ServiceException {
    e.fillInStackTrace();
    throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH, e);
  }

  public void afterThrowing(NonUniqueObjectException e) throws ServiceException {
    e.fillInStackTrace();
    throw new ServiceException(Messages.MSG_DUPLICATE_RECORD, e);
  }

  public void afterThrowing(SQLGrammarException e) throws ServiceException, SQLGrammarException {
    if (e.getErrorCode() == ORACLE_PRIVILEGES_ERROR_CODE) {
      e.fillInStackTrace();
      throw new ServiceException(Messages.ARC_BAT_INSUFFICIENT_PRIVILEGES, e);
    } else {
      throw e;
    }
  }

  public void afterThrowing(SQLException e) throws ServiceException, SQLException {
    if (e.getErrorCode() == ORACLE_PRIVILEGES_ERROR_CODE) {
      e.fillInStackTrace();
      throw new ServiceException(Messages.ARC_BAT_INSUFFICIENT_PRIVILEGES, e);
    } else {
      throw e;
    }
  }

  /**
   * This method allows sub-classes to manually find handlers for the exceptions that this class handles; it's needed
   * because the {@link EJBThrowsAdvice} class in particular needs to be able to translate unwrapped exceptions.
   *
   * @param throwable
   * @throws Throwable
   */
  @SuppressWarnings({"ProhibitedExceptionDeclared"})
  protected void translateException(Throwable throwable) throws Throwable {
    // This method is basically copied from:
    //   org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor#getExceptionHandler
    Class exceptionClass = throwable.getClass();
    Method handler = this.exceptionHandlerMap.get(exceptionClass);
    // Search up the exception heirarchy until we hit the root of all exceptions and errors (Throwable).
    while (handler == null && !exceptionClass.equals(Throwable.class)) {
      exceptionClass = exceptionClass.getSuperclass();
      handler = this.exceptionHandlerMap.get(exceptionClass);
    }
    if(handler == null) {
      throw throwable;
    }
    try {
      // Invoke the handler method.
      handler.invoke(this, throwable);
    } catch (InvocationTargetException targetEx) {
      throw targetEx.getTargetException();
    }
  }

}
