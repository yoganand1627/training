/**
 * Created on May 4, 2007 at 2:12:24 PM by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.AgencyCustodialParents;

public interface AgencyCustodialParentsDAO {
  
    /*
     * This method is used for updating the INCOME_AND_RESOURCES table for 
     * Receive Child Support Payment Info Service. This query returns the
     * County based on the crsId
     */
    String findCountyByCountyCrsId(int countyCrsId);
    
    /**
     * This method is used for updating the INCOME_AND_RESOURCES table for 
     * Receive Child Support Payment Info Service. This query returns the
     * County based on the crsId or a padded(with leading zeros(000)) crsId
     * 
     * @param countyCrsId
     * @param countyCrsIdPadded
     * @return
     */
    public String findCountyByCountyCrsIdPadded(int countyCrsId, int countyCrsIdPadded);
  
    /**
     * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.AgencyCustodialParents} object to the database.
     *
     * @param needsOutcomesDetail
     *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.AgencyCustodialParents} object.
     */
    int saveAgencyCustodialParents(AgencyCustodialParents agencyCustodialParents);

    /**
     * @param id
     * @return
     */
    AgencyCustodialParents findAgencyCustodialParentById(Integer id);
    
}
