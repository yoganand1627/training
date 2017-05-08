/**
 * Created on Mar 25, 2006 at 3:11:51 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.PersonMerge;

public interface PersonMergeDAO {
  /**
   * Retrieves all the rows from PersonMerge given indPersMergeInvalid and idPersMergeForward
   *
   * @param indPersMergeInvalid
   * @param idPersMergeForward
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<PersonMerge> findPersonMergeFromMergeInvalidAndMergeForward(String indPersMergeInvalid,
                                                                   int idPersMergeForward);

  /**
   * Retrieves all the Person Merge Forward IDs from PersonMerge given idPrimaryClient
   *
   * @param idPrimaryClient
   * @return
   */
  @SuppressWarnings({"unchecked"})
//  PaginatedHibernateList<Integer> findPersonMerge(int idPrimaryClient, int PageNbr, int pageSize);
  List<Integer> findPersonMerge(int idPrimaryClient);

  /**
   * Retrieve a could of PersonMerge rows where specified person is either merged forward or closed
   *
   * @param idPerson
   * @return Integerf
   */
  long countPersonMergeForwardOrClosedByIdPerson(int idPerson);
  
  List<Integer> findPersonMergeForwardOrClosedByPersonList(Collection<Integer> idPersons);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonMerge} object to the database.
   *
   * @param personMerge A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PersonMerge} object.
   */
  void savePersonMerge(PersonMerge personMerge);

  /**
   * Partial update of PersonMerge table using the supplied parameters(column values).
   *
   * @param idPersonMerge
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idPersMergeWrkr
   * @param idPersMergeSplitWrkr
   * @param indPersMergeInvalid
   * @param dtPersMergeSplit
   * @param lastUpdate
   */
  int updatePersonMerge(int idPersonMerge, int idPersMergeForward, int idPersMergeClosed,
                        int idPersMergeWrkr, int idPersMergeSplitWrkr, String indPersMergeInvalid,
                        Date dtPersMergeSplit, Date lastUpdate);
  
  /**
   * Partial update of PersonMerge table using the supplied parameters(column values).
   *
   * @param idPersonMerge
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idPersMergeWrkr  
   * @param indPersMergeInvalid
   * @param dtPersMergeSplit
   * @param lastUpdate
   */
  
  int updatePersonMerge(int idPersonMerge, int idPersMergeForward, int idPersMergeClosed, int idPersMergeWrkr,
                        String indPersMergeInvalid, Date dtPersMergeSplit,
                        Date lastUpdate);

  /**
   * Selects rows from Person, Employee and PersonMerge tables based on IdPersMergeForward
   *
   * @param idPerson
   * @return
   */
  public PaginatedHibernateList<Object[]> findPersonMergeByIdPersMergeForward(int idPerson, int PageNbr, int pageSize);
}
