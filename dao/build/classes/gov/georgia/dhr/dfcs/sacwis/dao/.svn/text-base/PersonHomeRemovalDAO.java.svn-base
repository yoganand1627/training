/**
 * Created on Mar 25, 2006 at 3:12:45 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PersonHomeRemoval;

public interface PersonHomeRemovalDAO {
  /**
   * Retrieves a row from PersonHomeRemoval table for the given Person ID and Case ID
   *
   * @param idPerson, IdCase
   * @return PersonHomeRemoval
   * @author r.k.pisharody
   */
  PersonHomeRemoval findPersonHmRemovByIdPersonIdCase(int idPerson, int idCase);

  /**
   * This will select all rows from the PersonHomeRemoval table given an Event ID
   *
   * @param idEvent
   * @return List of PersonHomeRemoval by idEvent
   */
  @SuppressWarnings({"unchecked"})
  List<PersonHomeRemoval> findPersonHomeRemovalByIdEvent(int idEvent);

  /**
   * Retrieves the count by querying PersonHomeRemoval, Event and Stage tables for the given two Person
   * Ids,idPersMergeForward and idPersMergeClosed. ( ie. count of the PersonHomeRemoval of the same type )
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return Integer
   */
  long countPersonHomeRemovalByIdPersMerge(int idPersMergeForward, int idPersMergeClosed);

  /**
   * Inserts/updates an entire row of PersonHomeRemoval table.
   *
   * @param personHomeRemoval
   */
  void savePersonHomeRemoval(PersonHomeRemoval personHomeRemoval);

  /**
   * Partial insert of PersonHomeRemoval table. (Note that the insert is done using straight SQL)
   *
   * @param sysIdNewEvent
   * @param idEvent
   */
  void insertPersonHomeRemoval(int sysIdNewEvent, int idEvent);

  /**
   * Partial update of PersonHomeRemoval table using the supplied parameters(column values).
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   */
  int updatePersonHomeRemoval(int idPersMergeForward, int idPersMergeClosed, int idEvent);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonHomeRemoval} object.
   *
   * @param PersonHomeRemoval
   */
  //void deletePersonHomeRemoval(PersonHomeRemoval personHomeRemoval);////mxpatel commented this out for defect #9009
  public void deletePersonHomeRemoval(int idRemovalEvent, int idPersonHmRemoval);//mxpatel added this for defect #9009
}
