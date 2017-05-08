/**
 * Created on Mar 25, 2006 at 3:00:24 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;
/**
 * This is the DAO class is used for the INCMG_DETERM_FACTORS table
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------    --------  --------------------------------------------------
 *  01/05/2009  arege     STGAP00009957 - Added findExtraIncmgDetermFactorsByIdStage()
 *                        to find if there exists determination factors with no 
 *                        corresponding allegations and deleteExtraIncmgDetermFactorsByIdDetermFactors()
 *                        to delete the determination factors for given id_determination.
 *                      
 * </pre>
 */


public interface IncmgDetermFactorsDAO {
  /**
   * This retrieves all the Incoming Determining Factors by idStage
   * <p/>
   *
   * @param idStage
   * @return keys cdIncmgDeterm, cdIncmgDetermType
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findIncmgDetermFactorsByIdStage(int idStage);
  
  /**
   * This retrieves all the Incoming Determination Factors that do 
   * not have any corresponding allegations.
   * @param idStage
   * @return List of idDetermination
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findExtraIncmgDetermFactorsByIdStage (int idStage);
  
  /**
   * Insert row into IncmgDetermFactors
   *
   * @param incmgDeterm
   * @param cdIncmgDetermType
   * @param idStage
   * @return
   */
  int insertIncmgDetermFactors(String incmgDeterm, String cdIncmgDetermType, int idStage, String txtDetFacCmnts);

  /**
   * Delete rows from IncmgDetermFactors based on idStage.
   *
   * @param idStage
   */
  int deleteIncmgDetermFactors(int idStage);
  
  
  /**
   * Delete rows from IncmgDetermFactors based on idDetermination.
   *
   * @param idDetermFactorsList
   * @return number of rows deleted.
   * 
   */
  @SuppressWarnings({"unchecked"})
  int deleteExtraIncmgDetermFactorsByIdDetermFactors(List<Integer> idDetermFactorsList);
  
}
