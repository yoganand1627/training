/**
 * Created on May 27, 2006 at 10:59:31 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.classic.Session;
import org.hibernate.engine.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

public class SpringServiceConfigurationTest extends TestCase {
  protected static final String[] MOCK_SESSION_FACTORY_CONFIG_LOCATIONS =
          new String[] {"service-context.xml", "test-spring-service-context.xml"};

  private static final String EXCEPTION_MESSAGE =
          "This method should not be called; it is just for a Spring configuration test.";

  public SpringServiceConfigurationTest(String string) {
    super(string);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SpringServiceConfigurationTest("testSpringServiceConfigration"));
    return suite;
  }

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testSpringServiceConfigration() {
    //noinspection ResultOfObjectAllocationIgnored
    new ClassPathXmlApplicationContext(MOCK_SESSION_FACTORY_CONFIG_LOCATIONS);
  }

  public static class MockTxManager implements PlatformTransactionManager {

    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
      throw new IllegalStateException(EXCEPTION_MESSAGE);
    }

    public void commit(TransactionStatus status) throws TransactionException {
      throw new IllegalStateException(EXCEPTION_MESSAGE);
    }

    public void rollback(TransactionStatus status) throws TransactionException {
      throw new IllegalStateException(EXCEPTION_MESSAGE);
    }
  }

  public static class MockSessionFactory implements SessionFactory {

    public Session openSession(Connection connection) {
      return null;
    }

    public Session openSession(Interceptor interceptor) throws HibernateException {
      return null;
    }

    public Session openSession(Connection connection, Interceptor interceptor) {
      return null;
    }

    public Session openSession() throws HibernateException {
      return null;
    }

    public Session getCurrentSession() throws HibernateException {
      return null;
    }

    public ClassMetadata getClassMetadata(Class persistentClass) throws HibernateException {
      return null;
    }

    public ClassMetadata getClassMetadata(String entityName) throws HibernateException {
      return null;
    }

    public CollectionMetadata getCollectionMetadata(String roleName) throws HibernateException {
      return null;
    }

    public Map getAllClassMetadata() throws HibernateException {
      return null;
    }

    public Map getAllCollectionMetadata() throws HibernateException {
      return null;
    }

    public Statistics getStatistics() {
      return null;
    }

    public void close() throws HibernateException {

    }

    public boolean isClosed() {
      return false;
    }

    public void evict(Class persistentClass) throws HibernateException {

    }

    public void evict(Class persistentClass, Serializable id) throws HibernateException {

    }

    public void evictEntity(String entityName) throws HibernateException {

    }

    public void evictEntity(String entityName, Serializable id) throws HibernateException {

    }

    public void evictCollection(String roleName) throws HibernateException {

    }

    public void evictCollection(String roleName, Serializable id) throws HibernateException {

    }

    public void evictQueries() throws HibernateException {

    }

    public void evictQueries(String cacheRegion) throws HibernateException {

    }

    public StatelessSession openStatelessSession() {
      return null;
    }

    public StatelessSession openStatelessSession(Connection connection) {
      return null;
    }

    public Set getDefinedFilterNames() {
      return null;
    }

    public FilterDefinition getFilterDefinition(String filterName) throws HibernateException {
      return null;
    }

    public Reference getReference() throws NamingException {
      return null;
    }
  }
}
