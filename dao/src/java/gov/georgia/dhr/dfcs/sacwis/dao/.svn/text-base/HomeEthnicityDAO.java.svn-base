package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.HomeEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.HomeEthnicityId;

import java.util.List;

public interface HomeEthnicityDAO {
  /**
   * This selects all ethnicities preferences linked to a home (resource).
   * <p/>
   * 
   * @param idResource
   * @param List<HomeEthnicity>
   */
  
  List<HomeEthnicity> findHomeEthnicitiesByResourceId(int idResource);

  /**
   * This selects the given ethnicity preferences linked to a home (resource).
   * <p/>
   * 
   * @param idResource
   * @param cdEthnicity
   * @param HomeEthnicity
   */
  
   HomeEthnicity findHomeEthnicitiesByResourceIdAndCdEthnicity(int idResource, String cdEthnicity);
    
  /**
   * This will save the home ethnicity record.
   * @param homeEthnicity
   */
  public void saveHomeEthnicity(HomeEthnicity homeEthnicity);

  /**
   * This will delete the home ethnicity record.
   * @param homeEthnicity
   */
  public int deleteHomeEthnicity(HomeEthnicityId homeEthnicityId);
}
