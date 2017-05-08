/**
 * Created on May 3, 2006 at 1:33:54 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;

public interface DynamicTodoDAO {
  public static final String STAFF_SORT_BY_CASE = "1";
  public static final String STAFF_SORT_BY_DATE = "2";
  public static final String STAFF_SORT_BY_CREATOR = "3";
  public static final String STAFF_SORT_BY_DESCRIPTION = "4";
  public static final String CASE_SORT_BY_ASSIGNED = "1";
  public static final String CASE_SORT_BY_DATE = "2";
  public static final String CASE_SORT_BY_CREATOR = "3";

  /**
   * This DAO will retrieve full rows from todo, including all stage information, based on dynamic criteria.  The
   * idTodoPersAssigned and sortOrder parameters must be populated; dtTodoDueFrom, dtTodoDueEnd may be null.
   * <p/>
   * Note that the nmTodoCreatorInit field in the Todo's returned will have NULL values instead of "System" for
   * system-generated todos. The calling service will need to handle this case.
   *
   * @param idTodoPersAssigned
   * @param sortOrder
   * @param dtTodoDueFrom
   * @param dtTodoDueEnd
   * @return {@link gov.georgia.dhr.dfcs.sacwis.db.Todo} objects, including all stage information.
   */
  //Comment for pagination
  public PaginatedHibernateList<Todo> findStaffTodos(int idTodoPersAssigned, String sortOrder, Date dtTodoDueFrom,
                                                     Date dtTodoDueEnd, int pageNbr, int pageSize);

  /**
   * The purpose of this dam (ccmn42dQUERYdam) is to retrieve records for display in the ListBox of the 'Case To Do
   * List' window (ccmn31w.win).  The full person record is retrieved from the PERSON table for ID_TODO_PERS_ASSIGNED.
   * <p/>
   * Note that the scrTodoAssgnedTo field is not populated by this method. The calling service will need to handle this
   * field itself by assigning initials if nmPersonFull is non-null and "System" if it is null.
   * <p/>
   * These columns are retrieved from records: <ol> <li>associated with a particular case (ID_TODO_CASE),</li <li>and
   * with a DT_TODO_DUE that falls between the dates passed into this DAM (From Date: pInputDataRec->dtDtTodoDue[0], and
   * TO Date: pInputDataRec->dtDtTodoDue[1]).</li> <li>and with ( (T.CD_TODO_TYPE  = 'A') OR (T.DT_TODO_COMPLETED IS
   * NULL) ).</li></ol> The retrieved records are ORDERed BY ASSIGNED, DATE, or CREATOR, based on the
   * pInputDataRec->ArchInputStruct.cReqFuncCd value.
   *
   * @param idCase
   * @param sortOrder
   * @param dtTodoDueFrom
   * @param dtTodoDueEnd
   * @return {@link gov.georgia.dhr.dfcs.sacwis.db.Todo} objects, including all stage information.
   */
  PaginatedHibernateList<Todo> findCaseTodos(int idCase, String sortOrder, Date dtTodoDueFrom, Date dtTodoDueEnd,
                                             int pageNbr, int pageSize);
}
