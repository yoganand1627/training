package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SiblingExternalLink;

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

public interface SiblingExternalLinkDAO {

  /**
   * Retrieves the Sibling External Link List from the db for the given idStage. <p/>
   * 
   * @param idSpclInvEvent
   * @return
   */
  List<SiblingExternalLink> findSiblingExternalLinksByIdStage(int idStage);
  
  /**
   * Retrieves the Sibling External Link List from the db for the given idSiblingGroup. <p/>
   * 
   * @param idSiblingGroup
   * @return
   */
  List<SiblingExternalLink> findSiblingExternalLinksByIdSiblingGroup(int idSiblingGroup);
  
  /**
   * Saves in SIBLING_EXTERNAL_LINK table
   */
  void saveSiblingExternalLink(SiblingExternalLink siblingExternalLink);
  
  /**
   * Deletes all Sibling External Link records for the passed in idSpclInvEvent 
   *  
   * @param idSiblingGroup
   * @return Integer
   */
  int deleteAllSiblingExternalLinkByIdSiblingGroup(int idSiblingGroup);
  
  /**
   * Deletes all Sibling External Link records for the passed in idStage
   * 
   * @param idStage
   * @return Integer
   */
  public int deleteAllSiblingExternalLinkByIdStage(int idStage);
  
  /**
   * Deletes a Sibling External Link record from the db
   * 
   * @param siblingExternalLink
   */
  void deleteSiblingExternalLink(SiblingExternalLink siblingExternalLink);
  
  /**
   * Updates the person ids for all the Sibling External Links for a person closed with a the person forward.
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return long
   */  
  int updateSiblingExternalLinkWithPersonForward(int idPersMergeForward, int idPersMergeClosed);
}
