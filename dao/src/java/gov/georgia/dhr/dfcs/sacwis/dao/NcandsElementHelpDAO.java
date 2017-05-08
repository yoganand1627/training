/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;


import java.util.List;

import org.hibernate.Session;

import gov.georgia.dhr.dfcs.sacwis.db.NcandsElementHelp;


/**
 * @author Patrick Coogan
 *
 */
public interface NcandsElementHelpDAO {
  /**
   * This selects all AFCARS elements from the AFCARS Element Help table
   * in the proper order for displaying the Case Watch page<p/>
   *
   * @param idUser
   * @return
   */
  List<NcandsElementHelp> findNcandsElements();
  
  }
