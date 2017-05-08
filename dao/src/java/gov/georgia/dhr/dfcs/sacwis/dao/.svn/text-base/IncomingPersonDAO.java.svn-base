/**
 * Created on Mar 25, 2006 at 2:57:51 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.IncomingPerson;

public interface IncomingPersonDAO {

  /**
   * Retrieves a row from IncomingPerson table for the given idPerson and idStage
   *
   * @param idPerson
   * @param idStage
   * @return IncomingPerson object
   */
  List<IncomingPerson> findIncomingPersonByIdStage(int idStage);
  
 /**
  * Retrieves a list from IncomingPerson table for the given idStage
  * @param idPerson
  * @param idStage
  * @return
  */
  IncomingPerson findIncomingPersonByIdPersonAndIdStage(int idPerson, int idStage);
  

  /**
   * Retrieves idIncmgPerson from IncomingPerson table for the given idPerson and idStage
   *
   * @param idPerson
   * @param idStage
   * @return Integer
   */
  Integer findIncomingPersonIdIncmgPerson(int idPerson, int idStage);

  /**
   * Inserts all collumns into the IncomingPerson table excluding the indInfoSwap collumn using the given idIncmgPerson
   * and idRelatedPerson. It use the given idPerson along with idStage from the StagePersonLink and Person tables.<p/>
   * <p/>
   * Note that, this is done in straight sql.
   *
   * @param idIncomingPerson
   * @param idRelatedPerson
   * @param idPerson
   * @param idStage
   * @return Integer
   */
  int insertIncomingPersonWithoutIndInfoSwap(int idIncomingPerson, int idRelatedPerson, int idPerson, int idStage);

  /**
   * Calls COMPLEX_DELETE.DELETE_INCOMING_PERSON() in oder to delete an incoming person record.
   *
   * @param idPerson
   * @param idStage
   */
  int deleteIncomingPerson(int idPerson, int idStage);
}
