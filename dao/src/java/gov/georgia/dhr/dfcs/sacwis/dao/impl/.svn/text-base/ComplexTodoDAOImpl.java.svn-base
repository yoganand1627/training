package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComplexTodoDAOImpl extends BaseDAOImpl implements ComplexTodoDAO {
  private TodoDAO todoDAO = null;

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public int insertTodo(Todo todo) {
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }

  public int updateTodo(Todo todo) {
    int idTodo = todo.getIdTodo();
    todoDAO.saveTodo(todo);
    return idTodo;
  }

  public int deleteTodo(Todo todo) {
    int idTodo = todo.getIdTodo();
    todoDAO.deleteTodo(todo);
    return idTodo;
  }
  
  public List<Integer> saveTodo(List<Todo> todoList) {
    List<Integer> idTodoList;
    if (todoList != null && todoList.size() != 0) {
      idTodoList = new ArrayList<Integer>();
      for (Iterator<Todo> todoListItr = todoList.iterator(); todoListItr.hasNext();) {
        Todo todo = (Todo) todoListItr.next();
        todoDAO.saveTodo(todo);
        idTodoList.add(todo.getIdTodo());
      }
      return idTodoList;
    } else {
      return null;
    }
  }
}
