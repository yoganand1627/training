/**
 * Created on Mar 25, 2006 at 3:31:12 PM by Michael K. Werle
 * * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------   --------  --------------------------------------------------
 *  10/9/2008  arege        STGAP00010425 Added method countIdToDoFromToDoByIdToEvent()
 *                          to find rows in the Todo table given idToDoEvent 
 * 10/10/2008  arege        STGAP00010425: Added method countIdToDoFromToDoByIdToEvent()
 *                          to find rows in the ToDo table given idToDoEvent 
 *  03/26/2009  bgehlot     STGAP00012833: Added the method findIdToDoFromToDoByIdPersonIdEvent, findIdToDoFromToDoByIdEvent
 *  07/23/2009  bgehlot     STGAP00014341: Added method deleteTodoByIdTodoStageCdTask
 *  08/02/2009  hjbaptiste  STGAP00014928: Added method deleteTodoByIdTodoCaseIdStageAndDescrExclusion() 
 *  08/03/2009  bgehlot     STGAP00014963: Added method deleteTodoByIdTodoCaseAndTask
 *  10/31/2011  arege       STGAP00016924: Added new method deleteTodoByIdCaseManagerIdStageCdTypeAndDescr()                  
 * </pre>  
 *                       
 * </pre>
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.Todo;


public interface TodoDAO {
  /**
   * Retrieves a full row from the ToDo Table by idTodo
   * <p/>
   *
   * @param idTodo
   * @return Todo object for the retrieved single row.
   */
  Todo findTodoByIdTodo(int idTodo);

  /**
   * Retrieves idTodo from the ToDo table, for the given idPerson. i.e Checks the ToDo table for any outstanding (not
   * closed) 'ToDo's, for the given idPerson
   *
   * @param idPerson
   * @return Integer
   */
  Integer findIdToDoFromToDoByIdPerson(int idPerson);
  
  /**
   * Counts the rows in the Todo table for given idToDoEvent.
   * 
   * @param idToDoEvent
   * @return Long
   */
  public long countIdToDoFromToDoByIdToEvent(int idToDoEvent);

  /**
   * Retrieve a Todo row by idStage and todo task
   *
   * @param idStage
   * @param cdTodoTask
   * @return
   */
  Todo findTodoByIdStageAndCdTodoTask(int idStage, String cdTodoTask);

  /**
   * Updates table Todo, field dtTodoCompleted given idStage and cdTodoTask
   * <p/>
   *
   * @param idStage
   * @param cdTodoTask
   */
  int updateToDoDtTodoCompletedByIdStageAndCdTodoTask(int idStage, String cdTodoTask);

  /**
   * This is an  update/insert for Todo info.
   *
   * @param todo
   */
  void saveTodo(Todo todo);

  /**
   * Updates Todo
   *
   * @param idPerson
   * @param sysIdPriorPerson
   * @param idStage
   * @return
   */
  int updateTodo(int idPerson, int sysIdPriorPerson, int idStage);

  /**
   * Update Todo
   *
   * @param idTodo
   * @param cdTask
   * @param idStage
   * @return
   */
  int updateTodo(int idTodo, String cdTask, int idStage);

  /**
   * Update Todo
   *
   * @param idTodo
   * @return
   */
  int updateTodo(int idTodo);

  /**
   * Delete rows from Todo based on ID_TODO_EVENT
   *
   * @param idEvent
   * @return
   */
  int deleteTodoByIdTodoEvent(int idEvent);

  /**
   * Delete rows from Todo based on ID_TODO_STAGE
   *
   * @param idStage
   * @return Integer
   */
  int deleteTodoByIdTodoStage(int idStage);

  /**
   * Delete rows from Todo based on ID_TODO_CASE
   *
   * @param idCase
   * @return Integer
   */
  int deleteTodoByIdTodoCase(int idCase);
  
  /**
   * Delete a Todo for a given stage in a given case excluding all Todos where the description is like a given description
   * 
   * @param idCase
   * @param idStage
   * @param cdTodoType
   * @param descrExclusion
   * @return
   */
  int deleteTodoByIdTodoCaseIdStageAndDescrExclusion(int idCase, int idStage, String cdTodoType, String descrExclusion);
  
  /**
   * Deletes a Todo for given personassigned 
   */
  int deleteTodoByIdCaseManagerIdStageCdTypeAndDescr(int idUser, int idStage, String cdTodoTask, String descr);  

  /**
   * Delete a todo row for a given ID with a dtLastupdate less than or equal to the specified value..
   *
   * @param idTodo       The PK of the todo to be deleted.
   * @param dtLastUpdate The max date for the todo row to be deleted.
   * @return The number of rows deleted (should never be more than 1).
   */
  int deleteTodoByIdTodoAndDtLastUpdate(int idTodo, Date dtLastUpdate);

  /**
   * Delete rows from Todo based on ID_TODO_STAGE
   *
   * @param idStage
   * @return Integer
   */
  int deleteTodoByIdTodoStageAndContactNotExist(int idStage);

  /**
   * Partial update of Todo table using the supplied parameters(column values).
   *
   * @param idEvent;
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateTodoByIdEvent(int idEvent);

  /**
   * Delete rows from Todo based on ID_TODO_EVENT
   *
   * @param idEvent
   * @return Integer
   */
  int deleteTodoByIdEvent(int idEvent);

  /**
   * Deletes a row(based on the Todo object passed in) from Todo table.
   *
   * @param todo
   */
  void deleteTodo(Todo todo);
  
  /**
   * STGAP00012833: Gets the idTodo for idPerson and idEvent
   * @param idPerson
   * @param idEvent
   * @return
   */
  Integer findIdToDoFromToDoByIdPersonIdEvent(int idPerson, int idEvent);
  
  /**
   *  STGAP00012833: Gets the idTodo for idEvent
   * @param idEvent
   * @return Integer
   */
  Integer findIdToDoFromToDoByIdEvent(int idEvent);
  
  /** 
   * //STGAP00014341: delete To Do for the stage id and the cdTask
   * @param idStage
   * @param cdTask
   * @return
   */
  int deleteTodoByIdTodoStageCdTask(int idStage, String cdTask);
  
  /** 
   * //STGAP00014963 : Deletes all the to dos other than Case Review ones
   * @param idCase
   * @return
   */
  int deleteTodoByIdTodoCaseAndTask(int idCase);
}
