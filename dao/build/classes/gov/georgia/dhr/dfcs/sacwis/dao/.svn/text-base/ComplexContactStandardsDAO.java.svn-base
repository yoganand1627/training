package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;
import gov.georgia.dhr.dfcs.sacwis.db.Event;

import java.util.List;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/18/10  Bhavna Gehlot              Initial creation
 * 
 * </pre>
 *
 * @author Bhavna Gehlot, Februrary 18, 2010
 */

public interface ComplexContactStandardsDAO {
  
  /**
   * Saves the children in CHILD_CONTACT_RULE table
   * @param childrenList
   * @param childContactRule
   */
  void saveChildContactRule(List<Integer> childrenList, Event event);
  
  /**
   * Saves the related to persons in PARENT_CONTACT_RULE table
   * @param relatedToPersonList
   * @param parentContactRule
   */
  void saveParentContactRule(List<Integer> childrenList, Event event);
 
}
