package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

import java.util.List;

import org.aopalliance.aop.Advice;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.aop.framework.ProxyFactory;

/**
 * This class serves as the base class for all DAO implementations.  Note that it is just a holder for the {@link
 * SessionFactory} with a single method that provides a means for subclasses to get a reference to the session.
 */
public abstract class BaseDAOImpl {
  private SessionFactory sessionFactory;
  private Advice sessionAdvice;

  /**
   * Needed for IoC-style configuration.
   *
   * @param sessionFactory
   */
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void setSessionAdvice(Advice sessionAdvice) {
    this.sessionAdvice = sessionAdvice;
  }

  /**
   * Returns a thread-local version of the {@link org.hibernate.Session} object.
   *
   * @return A thread-local version of the {@link org.hibernate.Session} object.
   */
  protected Session getSession() {
    // Proxy the session to translate exceptions properly.
    ProxyFactory factory = new ProxyFactory(this.sessionFactory.getCurrentSession());
    factory.addAdvice(sessionAdvice);
    return (Session) factory.getProxy();
  }

  @SuppressWarnings({"unchecked"})
  protected PaginatedHibernateList paginatedList(int pageNbr, int pageSize, Query query) {
    query.setFirstResult((pageNbr - 1) * pageSize);
    // Grab the full page at once, plus 1 row to set bMoreDataInd.
    query.setFetchSize(pageSize + 1);
    query.setMaxResults(pageSize + 1);
    // Execute the query.
    return new PaginatedHibernateList(query.list(), pageSize, pageNbr);
  }

  @SuppressWarnings({"unchecked"})
  protected PaginatedHibernateList paginatedList(int pageNbr, int pageSize, Criteria criteria) {
    criteria.setFirstResult((pageNbr - 1) * pageSize);
    // Grab the full page at once, plus 1 row to set bMoreDataInd.
    criteria.setFetchSize(pageSize + 1);
    criteria.setMaxResults(pageSize + 1);
    // Execute the query.
    return new PaginatedHibernateList(criteria.list(), pageSize, pageNbr);
  }

  /**
   * Convenience method to pull the first result out of a list returned by a query.
   *
   * @param query
   * @return The first result from a query or null if it returns no results.
   */
  protected Object firstResult(Query query) {
    query.setMaxResults(1);
    List list = query.list();
    return list.size() > 0 ? list.get(0) : null;
  }

  /**
   * Convenience method to pull the first result out of a list returned by a criteria query.
   *
   * @param criteria
   * @return The first result from a query or null if it returns no results.
   */
  protected Object firstResult(Criteria criteria) {
    criteria.setMaxResults(1);
    List list = criteria.list();
    return list.size() > 0 ? list.get(0) : null;
  }
}
