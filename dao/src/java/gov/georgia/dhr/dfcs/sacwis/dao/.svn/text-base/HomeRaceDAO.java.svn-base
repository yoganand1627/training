package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.HomeRace;
import gov.georgia.dhr.dfcs.sacwis.db.HomeRaceId;

import java.util.List;

public interface HomeRaceDAO {
  
  /**
   * This selects all races preferences linked to a home (resource).
   * <p/>
   * 
   * @param idResource
   * @param List<HomeRace>
   */
  List<HomeRace> findHomeRacesByResourceId(int idResource);
  
  /**
   * This selects the given ethnicity preferences linked to a home (resource).
   * <p/>
   * 
   * @param idResource
   * @param cdRace
   * @param HomeRace
   */
  
   HomeRace findHomeRacesByResourceIdAndCdRace(int idResource, String cdRace);
    
  /**
   * This will save the home ethnicity record.
   * @param homeRace
   */
  void saveHomeRace(HomeRace homeRace);

  /**
   * This will delete the home ethnicity record.
   * @param homeRace
   */
   int deleteHomeRace(HomeRaceId homeRaceId);

}
