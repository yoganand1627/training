
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * 
 * * <pre>
 *  Change History:
 *  Date        User        Description
 *  --------   --------     --------------------------------------------------
 *  10/10/2008  arege       STGAP00010425 Added method countIdToDoFromToDoByIdToEvent()
 *                          to find rows in the ToDo table given idToDoEvent 
 *                       
 *  12/11/2008  mxpatel     STGAP00010716 Added IF statements to truncate the todo if it is longer than the specified length.
 *        
 *  03/26/2009  bgehlot     STGAP00012833 Added the method findIdToDoFromToDoByIdPersonIdEvent, findIdToDoFromToDoByIdEvent  
 *  07/23/2009  bgehlot     STGAP00014341: Added method deleteTodoByIdTodoStageCdTask
 *  08/02/2009  hjbaptiste  STGAP00014928: Added method deleteTodoByIdTodoCaseIdStageAndDescrExclusion()
 *  08/03/2009  bgehlot     STGAP00014963: Added method deleteTodoByIdTodoCaseAndTask
 *  04/21/2010  hnguyen     SMS#42782: Modified methods so not to delete case review tasks as these must remain on assigned 
 *                          reviewer's workload to be completed even after stage or case closure.
 *  09/20/2010  hjbaptiste  SMS#69962: Fixed todo long description being truncated to 277 chars when it should have been set 
 *                          to 297 chars since the field holds 300 characters    
 *  10/31/2011  arege       STGAP00016924: Added new method deleteTodoByIdCaseManagerIdStageCdTypeAndDescr()                  
 * </pre>
 */

public class TodoDAOImpl extends BaseDAOImpl implements TodoDAO {
  
  public Todo findTodoByIdTodo(int idTodo) {
    Session session = getSession();
    Query query = session.createQuery(" from Todo t " +
                                      "where t.idTodo = :idTodo");
    query.setInteger("idTodo", idTodo);
    return (Todo) firstResult(query);
  }

  public Integer findIdToDoFromToDoByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select t.idTodo " +
                                           "  from Todo t " +
                                           " where t.personByIdTodoPersAssigned.idPerson =  :idPerson " +
                                           "   and t.dtTodoCompleted is null ");
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }
  
  // STGAP00012833: Gets the idTodo for idPerson and idEvent
  public Integer findIdToDoFromToDoByIdPersonIdEvent(int idPerson, int idEvent) {
    Query query = getSession().createQuery("select t.idTodo " +
                                           "  from Todo t " +
                                           " where t.personByIdTodoPersAssigned.idPerson =  :idPerson " +
                                           " and t.event.idEvent = :idEvent " +
                                           " and t.cdTodoType = :cdTodoType " +
                                           " and t.dtTodoCompleted is null ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    query.setString("cdTodoType", CodesTables.CTODOTYP_T);
    return (Integer) firstResult(query);
  }
  
  
  // STGAP00012833: Gets the idTodo for idEvent
  public Integer findIdToDoFromToDoByIdEvent(int idEvent) {
    Query query = getSession().createQuery("select t.idTodo " +
                                           "  from Todo t " +
                                           " where t.event.idEvent = :idEvent " +
                                           " and t.cdTodoType = :cdTodoType " +
                                           " and t.dtTodoCompleted is null ");
    query.setInteger("idEvent", idEvent);
    query.setString("cdTodoType", CodesTables.CTODOTYP_T);
    return (Integer) firstResult(query);
  }
  
  //Added per STGAP00010425
  public long countIdToDoFromToDoByIdToEvent(int idToDoEvent) {
    Query query = getSession().createQuery("select count(*)" +
                                           " from Todo t " +
                                           " where event.idEvent = :idToDoEvent" );
    query.setInteger("idToDoEvent", idToDoEvent);
    return (Long) query.uniqueResult();
  }
  

  public Todo findTodoByIdStageAndCdTodoTask(int idStage, String cdTodoTask) {
    Query query = getSession().createQuery(" from Todo t " +
                                           "where t.stage.idStage = :idStage " +
                                           "  and cdTodoTask = :cdTodoTask");
    query.setInteger("idStage", idStage);
    query.setString("cdTodoTask", cdTodoTask);
    return (Todo) firstResult(query);
  }

  public int updateToDoDtTodoCompletedByIdStageAndCdTodoTask(int idStage, String cdTodoTask) {
    Query query = getSession().createQuery("update Todo " +
                                           "   set dtTodoCompleted = sysdate " +
                                           " where dtTodoCompleted is null " +
                                           "   and stage.idStage = :idStage " +
                                           "   and cdTodoTask = :cdTodoTask");
    query.setInteger("idStage", idStage);
    query.setString("cdTodoTask", cdTodoTask);
    return query.executeUpdate();
  }

  public void saveTodo(Todo todo) {
   
    //mxpatel added these IF statements for defect #10716
    if(todo.getTxtTodoDesc() != null && todo.getTxtTodoDesc().length() > 80){
    todo.setTxtTodoDesc(todo.getTxtTodoDesc().substring(0, 77) + "...");
   }
   if(todo.getTxtTodoLongDesc() != null && todo.getTxtTodoLongDesc().length() > 300){
     todo.setTxtTodoLongDesc(todo.getTxtTodoLongDesc().substring(0, 297) + "...");
   }
    getSession().saveOrUpdate(todo);
  }

  public int updateTodo(int idPerson, int sysIdPriorPerson, int idStage) {
    Query query = getSession().createQuery("update Todo " +
                                           "   set personByIdTodoPersAssigned.idPerson = :idPerson " +
                                           " where personByIdTodoPersAssigned.idPerson = :sysIdPriorPerson " +
                                           "   and stage.idStage = :idStage " +
                                           "   and dtTodoCompleted is null " +
                                           "   and (cdTodoTask != '1047'" +
                                           "         or cdTodoTask is null )");
    query.setInteger("idPerson", idPerson);
    query.setInteger("sysIdPriorPerson", sysIdPriorPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateTodo(int idTodo, String cdTask, int idStage) {
    Query query = getSession().createQuery("update Todo " +
                                           "   set stage.idStage = :idStage, " +
                                           "       cdTodoTask = :cdTask " +
                                           " where idTodo = :idTodo");
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setInteger("idTodo", idTodo);

    return query.executeUpdate();
  }

  public int updateTodo(int idTodo) {
    Query query = getSession().createQuery("update Todo " +
                                           "   set dtTodoCompleted = sysdate " +
                                           " where idTodo = :idTodo");
    query.setInteger("idTodo", idTodo);
    return query.executeUpdate();
  }

  public int deleteTodoByIdTodoEvent(int idEvent) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public int deleteTodoByIdTodoStage(int idStage) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where stage.idStage = :idStage " +
                                           " and cdTodoTask not in ('9880', '9890','9910','9920','9930','9940') ");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int deleteTodoByIdTodoCase(int idCase) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where capsCase.idCase = :idCase " +
                                           " and cdTodoTask not in ('9880', '9890','9910','9920','9930','9940') ");
    query.setInteger("idCase", idCase);
    return query.executeUpdate();
  }
  
  public int deleteTodoByIdTodoCaseIdStageAndDescrExclusion(int idCase, int idStage, String cdTodoType, String descrExclusion) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where capsCase.idCase = :idCase" +
                                           "   and stage.idStage = :idStage " +
                                           "   and cdTodoType = :cdTodoType "  +
                                           "   and txtTodoDesc not like :descrExclusion");
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setString("cdTodoType", cdTodoType);
    query.setString("descrExclusion", "%" + descrExclusion + "%");
    return query.executeUpdate();
  }
  
  public int deleteTodoByIdCaseManagerIdStageCdTypeAndDescr(int idPersonAssigned, int idStage, String cdTodoTask, String descr) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where personByIdTodoPersAssigned.idPerson =  :idPersonAssigned " +
                                           "   and stage.idStage = :idStage " +
                                           "   and cdTodoTask = :cdTodoTask "  +
                                           "   and txtTodoDesc  like :descr");    
    query.setInteger("idPersonAssigned", idPersonAssigned);
    query.setInteger("idStage", idStage);
    query.setString("cdTodoTask", cdTodoTask);
    query.setString("descr", "%" + descr + "%");
    return query.executeUpdate();
  }
  

  public int deleteTodoByIdTodoAndDtLastUpdate(int idTodo, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where idTodo = :idTodo " +
                                           "   and dtLastUpdate <= :dtLastUpdate");
    query.setInteger("idTodo", idTodo);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int deleteTodoByIdTodoStageAndContactNotExist(int idStage) {
    Query query = getSession().createQuery("delete Todo t " +
                                           " where t.dtTodoCompleted is null " +
                                           "   and t.stage.idStage = :idStage " +
                                           "   and  not  exists (select 1 " +
                                           "                       from Contact c " +
                                           "                      where c.stage.idStage = t.stage.idStage " +
                                           "                        and c.event.idEvent = t.event.idEvent " +
                                           "                        and (c.cdContactType = 'cmst' " +
                                           "                              or c.cdContactType = 'c3mt')) " +
                                           "   and t.cdTodoTask not in ('9880', '9890','9910','9920','9930','9940') ");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateTodoByIdEvent(int idEvent) {
    Query query = getSession().createQuery("update Todo " +
                                           "   set dtTodoCompleted = sysdate " +
                                           " where event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public int deleteTodoByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public void deleteTodo(Todo todo) {
    getSession().delete(todo);
  }
  
  //STGAP00014341: delete To Do for the stage id and the cdTask
  public int deleteTodoByIdTodoStageCdTask(int idStage, String cdTask) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where stage.idStage = :idStage "+
                                           " and cdTodoTask = :cdTask ");
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    return query.executeUpdate();
  }
  
  //STGAP00014963 : Deletes all the to dos other than Case Review ones
  public int deleteTodoByIdTodoCaseAndTask(int idCase) {
    Query query = getSession().createQuery("delete Todo " +
                                           " where capsCase.idCase = :idCase "+
                                           " and cdTodoTask not in ('9880', '9890','9910','9920','9930','9940','2270')");
    query.setInteger("idCase", idCase);
    return query.executeUpdate();
  }
}
