package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 10/02/11  hnguyen                  STGAP00017011: MR-092 Added new method findLatestValidatedAAFundingByIdChild.
 * 11/09/11  hnguyen                  STGAP00017622: MR-092 Updated findLatestValidatedAAFundingByIdChildByIdStage query 
 * 03/12/12  arege                    STGAP00018020: Added method to find latest AAFundingSummary of type IVE or PST
 * </pre>
 *
 * @author Herve Jean-Baptiste, September 02, 2011
 */

public interface AaFundingDAO {
  
  /**
   * Retrieves the Adoption Assistance Funding from the db for the given idEvent. <p/>
   * 
   * @param idAaFundingEvent
   * @return
   */
  AaFunding findAAfundingByIdEvent (int idAaFundingEvent);
  
  /**
   * Retrieves the latest validated Adoption Assistance Funding from the db for the given IdChild and idStage. <p/>
   * 
   * @param idChild
   * @param idStage
   * @return
   */
  AaFunding findLatestValidatedAAFundingByIdChildByIdStage(int idChild, int idStage);
  
  /**
   * Retrieves the latest validated Adoption Assistance Funding of type IVE or PST for the given child and stage
   * @param idChild
   * @param idStage
   * @return
   */
  AaFunding findLatestValidatedIVEOrPSTAAFundingByIdChildByIdStage(int idChild, int idStage);
  
  /**
   * Updates AA Funding table.
   * 
   * @param aaFunding
   * 
   * @return
   */
  void saveAaFunding(AaFunding aaFunding);
  
  /**
   * Simple delete of a Adoption Assistance Funding
   * 
   * @param aaFunding
   * @return Integer
   */
  void deleteAaFunding(AaFunding aaFunding);

}
