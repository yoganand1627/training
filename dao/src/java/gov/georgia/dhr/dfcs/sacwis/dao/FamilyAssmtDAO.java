/**
 * Created on Mar 25, 2006 at 2:46:47 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FamilyAssmt;

public interface FamilyAssmtDAO {
  /**
   * This is an  update/insert for family assessment info.
   *
   * @param familyAssmt
   */
  void saveFamilyAssmt(FamilyAssmt familyAssmt);
}
