package gov.georgia.dhr.dfcs.sacwis.core.base;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Abstract base Service EJB implementation.  Now used only for non-Hibernate EJBs.
 *
 * @author Daniel L. Boxwell, December 2001
 */
public abstract class BaseServiceEjb extends BaseSpringStatelessSessionBean {
  private static final GrndsConfiguration GRNDS_CONFIGURATION_INSTANCE = GrndsConfiguration.getInstance();
  private static final String GLOBAL_EXCEPTION_LOGGER_NAME =
          GRNDS_CONFIGURATION_INSTANCE == null ? null :
          GRNDS_CONFIGURATION_INSTANCE.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "exception.globalLogger");
  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER =
          GrndsLogger.getLogger(GLOBAL_EXCEPTION_LOGGER_NAME != null ? GLOBAL_EXCEPTION_LOGGER_NAME : "exceptions");

  /**
   * Per-EJB cache of references; we still need a thread-safe map because stateless beans must be thread-safe.
   */
  private final ConcurrentMap<String, WeakReference<Object>> BEAN_CACHE =
          new ConcurrentHashMap<String, WeakReference<Object>>();

  /**
   * By default, do nothing.  Existing EJBs that require Hibernate services need to override this if they need access to
   * the Spring services.
   *
   * @throws CreateException
   */
  protected void onEjbCreate() throws CreateException {
  }

  /**
   * <em>DO NOT USE THIS METHOD IN AN EJB INITIALIZATION METHOD.  (e.g. {@link #onEjbCreate()})</em>
   * <p/>
   * This method is designed to provide a very fast way to lookup stateless session EJBs.
   *
   * @param clazz
   * @return
   */
  @SuppressWarnings({"unchecked"})
  protected <T extends Object> T lookupEjb(Class<T> clazz) {
    String className = clazz.getSimpleName();
    WeakReference<Object> beanRef = BEAN_CACHE.get(className);
    T bean;
    if (beanRef == null || (bean = (T) beanRef.get()) == null) {
      bean = lookupEjb(clazz, className);
      beanRef = new WeakReference<Object>(bean);
      BEAN_CACHE.put(className, beanRef);
    }
    return bean;
  }

  @SuppressWarnings({"unchecked", "EjbWarningInspection"})
  private <T extends Object> T lookupEjb(Class<T> clazz, String className) {
    String beanName = className + "Bean";
    Context ctx = null;
    try {
      Class homeClass = Class.forName(clazz.getPackage().getName() + "." + className + "Home");
      java.lang.reflect.Method createMethod = homeClass.getMethod("create");
      ctx = new InitialContext();
      T bean = (T) createMethod.invoke(ctx.lookup("java:comp/env/ejb/sacwis/" + beanName));
      ProxyFactory proxyFactory = new ProxyFactory(bean);
      // Only add the JAMON interceptor if the bean is not an SlsbFacade
      if (!(bean instanceof SlsbFacade)) {
        proxyFactory.addAdvice((Advice) getBeanFactory().getBean("jamonInterceptor"));
      }
      proxyFactory.addAdvice((Advice) getBeanFactory().getBean("ejbThrowsAdvice"));
      // Monitor the requested interface.
      return (T) proxyFactory.getProxy();
    } catch (Exception e) {
      throw new RuntimeException("Failed to lookup bean: " + className, e);
    } finally {
      if (ctx != null) {
        try {
          ctx.close();
        } catch (NamingException e) {
          // Ignore this
        }
      }
    }
  }

  protected void cleanup(ResultSet rs, Statement stmt, Connection connection) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (Exception se) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing result set.", se);
    } finally {
      cleanup(stmt, connection);
    }
  }

  protected void cleanup(ResultSet rs, Statement stmt) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (Exception se) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing result set.", se);
    } finally {
      cleanup(stmt);
    }
  }

  protected void cleanup(Statement stmt) {
    try {
      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception se) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing prepared statement.", se);
    }
  }

  protected void cleanup(Statement stmt, Connection connection) {
    try {
      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception se) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing prepared statement.", se);
    } finally {
      cleanup(connection);
    }
  }

  protected void cleanup(Connection connection) {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (Exception se) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing connection.", se);
    }
  }
}
