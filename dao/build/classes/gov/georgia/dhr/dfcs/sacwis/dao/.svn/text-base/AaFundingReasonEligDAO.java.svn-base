package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.AaFundingReasonElig;

import java.util.List;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, September 02, 2011
 */

public interface AaFundingReasonEligDAO {

  /**
   * Retrieves the Adoption Assistance Funding Reason Eligible List from the db for the given idAaFundingEvent. <p/>
   * 
   * @param idAaFundingEvent
   * @return
   */
  List<AaFundingReasonElig> findAaFundingReasonElig(int idAaFundingEvent);
  
  /**
   * Retrieves the Adoption Assistance Funding Reason Eligible from the db for the given idAaFundingReasonElig. <p/>
   * 
   * @param idAaFundingReasonElig
   * @return
   */
  AaFundingReasonElig findAaFundingReasonEligByIdAaFundingReasonElig(int idAaFundingReasonElig);
  
  /**
   * Retrieves the Adoption Assistance Funding Reason Eligible from the db for the given idAaFundingEvent. <p/>
   * 
   * @param idAaFundingEvent
   * @return
   */
  AaFundingReasonElig findAaFundingReasonEligByIdEvent(int idAaFundingEvent);
  
  /**
   * Retrieves the column cdAaFundingRsn for a child's Adoption Assistance Funding Summary
   * 
   * @param idAaFundingReasonElig
   * @return
   */
  String findCdAaFundingRsnByIdAaFundingReasonElig(int idAaFundingReasonElig);
  
  /**
   * Saves in AA_FUNDING_REASON_ELIG table
   */
  void saveAaFundingReasonElig(AaFundingReasonElig aaFundingReasonElig);
  
  /**
   * Deletes all AA Funding Reason Eligible records for the passed in idAaFundingReasonElig
   *  
   * @param idAaFundingReasonElig
   * @return Integer
   */
  int deleteAllAaFundingRsnEligByIdAaFundingReasonElig(int idAaFundingReasonElig);
  
  /**
   * Deletes all AA Funding Reason Eligible records for the passed in idAaFundingEvent
   *  
   * @param idAaFundingEvent
   * @return Integer
   */
  int deleteAllAaFundingRsnEligByIdEvent(int idAaFundingEvent);
  
  /**
   * Deletes an AA Funding Reason Eligible record from the db
   * 
   * @param aaFundingReasonElig
   */
  void deleteAaFundingRsnElig(AaFundingReasonElig aaFundingReasonElig);
  
}
