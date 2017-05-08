package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.Todo;

public interface ComplexTodoDAO {
  /**
   * Inserts a row into Todo table.
   *
   * @param todo The Todo object populated with row/column values.
   * @return int The idTodo of the new row inserted by this operation.
   */
  int insertTodo(Todo todo);

  /**
   * Updates a row of Todo table.
   *
   * @param todo The Todo object populated with row/column values.
   * @return int The idTodo of the row updated by this operation.
   */
  int updateTodo(Todo todo);

  /**
   * Deletes a row from Todo table.
   *
   * @param todo The Todo object that represents the row to be deleted.
   * @return int The idTodo of the row deleted by this operation.
   */
  int deleteTodo(Todo todo);
  
  List<Integer> saveTodo(List<Todo> todoList);
}
