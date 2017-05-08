/**
 * Created on May 3, 2006 at 1:34:26 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Junction;

public class DynamicTodoDAOImpl extends DynamicBaseDAOImpl implements DynamicTodoDAO {
  private static final String ALERT_TODO_TYPE = "A";

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Todo> findStaffTodos(int idTodoPersAssigned, String sortOrder, Date dtTodoDueFrom,
                                                     Date dtTodoDueEnd, int pageNbr, int pageSize) {
    if (idTodoPersAssigned < 1) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Criteria criteria = getSession().createCriteria(Todo.class, "t");
    criteria.createAlias("t.stage", "s", Criteria.LEFT_JOIN).setFetchMode("t.stage", FetchMode.JOIN);
    criteria.add(Restrictions.eq("t.personByIdTodoPersAssigned.idPerson", idTodoPersAssigned));
    Junction orClause = Restrictions.disjunction().add(Restrictions.eq("t.cdTodoType", ALERT_TODO_TYPE))
            .add(Restrictions.isNull("t.dtTodoCompleted"))
            .add(Restrictions.ge("t.dtTodoCompleted", DateHelper.MAX_JAVA_DATE));
    criteria.add(orClause);
    if (!DateHelper.isNull(dtTodoDueFrom)) {
      criteria.add(Restrictions.ge("t.dtTodoDue", dtTodoDueFrom));
    }
    if (!DateHelper.isNull(dtTodoDueEnd)) {
      criteria.add(Restrictions.le("t.dtTodoDue", dtTodoDueEnd));
    }
    if (STAFF_SORT_BY_CASE.equals(sortOrder)) {
      criteria.addOrder(Order.asc("s.nmStage"));
    } else if (STAFF_SORT_BY_DATE.equals(sortOrder)) {
      criteria.addOrder(Order.asc("t.dtTodoDue"));
      criteria.addOrder(Order.asc("t.idTodo"));
    } else if (STAFF_SORT_BY_CREATOR.equals(sortOrder)) {
      criteria.addOrder(Order.asc("t.nmTodoCreatorInit"));
    } else if (STAFF_SORT_BY_DESCRIPTION.equals(sortOrder)) {
      criteria.addOrder(Order.asc("t.txtTodoDesc"));
    }
    return (PaginatedHibernateList<Todo>) paginatedList(pageNbr, pageSize, criteria);
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Todo> findCaseTodos(int idCase, String sortOrder, Date dtTodoDueFrom, Date dtTodoDueEnd,
                                                    int pageNbr, int pageSize) {
    if (idCase < 1) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Criteria criteria = getSession().createCriteria(Todo.class, "t");
    criteria.createAlias("t.stage", "s", Criteria.LEFT_JOIN).setFetchMode("t.stage", FetchMode.JOIN);
    criteria.createAlias("t.personByIdTodoPersAssigned", "pa", Criteria.INNER_JOIN)
            .setFetchMode("t.personByIdTodoPersAssigned", FetchMode.JOIN);
    criteria.add(Restrictions.eq("t.capsCase.idCase", idCase));
    Junction orClause = Restrictions.disjunction().add(Restrictions.eq("t.cdTodoType", ALERT_TODO_TYPE))
            .add(Restrictions.isNull("t.dtTodoCompleted"))
            .add(Restrictions.ge("t.dtTodoCompleted", DateHelper.MAX_JAVA_DATE));
    criteria.add(orClause);
    if (!DateHelper.isNull(dtTodoDueFrom)) {
      criteria.add(Restrictions.ge("t.dtTodoDue", dtTodoDueFrom));
    }
    if (!DateHelper.isNull(dtTodoDueEnd)) {
      criteria.add(Restrictions.le("t.dtTodoDue", dtTodoDueEnd));
    }
    if (CASE_SORT_BY_ASSIGNED.equals(sortOrder)) {
      criteria.addOrder(Order.asc("pa.nmPersonFull"));
      criteria.addOrder(Order.asc("t.idTodo"));
    } else if (CASE_SORT_BY_DATE.equals(sortOrder)) {
      criteria.addOrder(Order.asc("t.dtTodoDue"));
      criteria.addOrder(Order.asc("t.idTodo"));
    } else if (CASE_SORT_BY_CREATOR.equals(sortOrder)) {
      criteria.addOrder(Order.asc("t.nmTodoCreatorInit"));
      criteria.addOrder(Order.asc("t.idTodo"));
    }
    return (PaginatedHibernateList<Todo>) paginatedList(pageNbr, pageSize, criteria);
  }
}
