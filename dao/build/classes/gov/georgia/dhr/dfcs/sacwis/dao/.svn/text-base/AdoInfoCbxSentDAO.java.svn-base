package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbxSent;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * The AdoInfoCbxSentDAOImpl class is used to perform database operations on the AdoInfoCbxSent table
 * 
 * 
 * @author Ronnie Phelps, October 7, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 
 * </PRE>
 */
public interface AdoInfoCbxSentDAO {
  /**
   * Get AdoInfoCbxSent record by primary key
   * 
   * @param idAdoInfoCbxSent
   * 
   * return AdoInfoCbxSent
   */
  AdoInfoCbxSent findAdoInfoCbxSent(int idAdoInfoCbxSent);

  /**
   * Get a list of AdoInfoCbxSent records for the given idInfoChar and IdEvent
   * 
   * @param idInfoChar
   * @param idEvent
   * 
   * return List<AdoInfoCbxSent>
   */
  List<AdoInfoCbxSent> findAdoInfoCbxSentByIdInfoCharIdEvent(int idInfoChar, int idEvent);

  /**
   * find All dates for the given idInfoChar and event
   * 
   * @param idInfoChar
   * @param idEvent
   * 
   * @return List<Date>
   */
  List<Date> findAdoInfoCbxSentDateByIdInfoCharIdEvent(int idInfoChar, int idEvent);

  /**
   * Save the AdoInfoCbxSent record to the database
   * 
   * @param AdoInfoCbxSent;
   */
  void saveAdoInfoCheckBoxSent(AdoInfoCbxSent adoinfocbxSent);

  /**
   * delete all all AdoInfoCbxSent records in the given collection
   * 
   * @param idInfoCharTypes
   */
  void deleteAllAdoInfoCbxSentForcharTypes(Collection idInfoCharTypes);

  /**
   * delete AdoInfoCbxSent record by primary key
   * 
   * @param idAdoInfoCbxSent
   */
  void deleteAdoInfoCbxSent(int idAdoInfoCbxSent);

}
