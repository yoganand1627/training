/**
 * Created on Mar 25, 2006 at 3:35:30 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.RiskFactors;

public interface RiskFactorsDAO {

  /**
   * This will retrieve all rows from the RISK FACTORS table that match ID Event & Id Person.
   *
   * @param idEvent
   * @param idPerson
   * @return List of RiskFactors by idEvent & idPerson
   */
  @SuppressWarnings({"unchecked"})
  List<RiskFactors> findRiskFactorsByIdEventAndIdPerson(int idEvent, int idPerson);

  /**
   * Returns a count after querying the RiskFactors, Event and Stage tables for the two given 'idPerson'. (It selects a
   * count of the open service authorizations of the same type).
   *
   * @param idPerson
   * @param idNewPerson
   * @return Integer
   */
  long countRiskFactorsByIdPerson(int idPerson, int idNewPerson);

  /**
   * Partial update of RiskFactors table using the supplied parameters(column values).
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idStage
   */
  int updateRiskFactors(int idPersMergeForward, int idPersMergeClosed, int idStage);
  
  /**
   *  Will return a list a risk factor given the Factor codes, idEvent and response
   * @param cdRiskFactors
   * @param idEvent
   * @param cdResponse
   * @return
   */
  List<RiskFactors> findRiskFactorsByIdEventCdFactorCdResponse(Collection <String> cdRiskFactors, int idEvent, String cdResponse);
}
