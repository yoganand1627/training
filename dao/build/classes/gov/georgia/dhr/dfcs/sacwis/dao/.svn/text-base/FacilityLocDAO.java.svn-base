/**
 * Created on Mar 25, 2006 at 2:47:36 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.FacilityLoc;

public interface FacilityLocDAO {

  /**
   * Retrieves rows from the Facility LOC table
   *
   * @param idResource
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<FacilityLoc> findFacilityLocByIdResource(int idResource);

  /**
   * Used to end date a facility loc row
   *
   * @param dtFlocEnd
   * @param idResource
   * @return
   */
  int updateFacilityLoc(Date dtFlocEnd, int idResource);

  /**
   * Updates table FacilityLoc field dtFlocEnd given dtMaxDate and idResource
   * <p/>
   *
   * @param dtFlocEffect
   * @param dtMaxDate
   * @param idResource
   */
  int updateFacilityLocDtFlocEnd(Date dtFlocEffect, Date dtMaxDate, int idResource);

  /**
   * Insert FacilityLoc
   *
   * @param idResource
   * @param dtFlocEffect
   * @param dtFlocEnd
   * @param nbrFlocLevelsOfCare
   * @param cdFlocStatus1
   * @param cdFlocStatus2
   * @param cdFlocStatus3
   * @param cdFlocStatus4
   * @param cdFlocStatus5
   * @param cdFlocStatus6
   * @param cdFlocStatus7
   * @param cdFlocStatus8
   * @param cdFlocStatus9
   * @param cdFlocStatus10
   * @param cdFlocStatus11
   * @param cdFlocStatus12
   * @param cdFlocStatus13
   * @param cdFlocStatus14
   * @param cdFlocStatus15
   * @return
   */
  int insertFacilityLoc(int idResource, Date dtFlocEffect, Date dtFlocEnd,
                        int nbrFlocLevelsOfCare, String cdFlocStatus1, String cdFlocStatus2,
                        String cdFlocStatus3, String cdFlocStatus4, String cdFlocStatus5,
                        String cdFlocStatus6, String cdFlocStatus7, String cdFlocStatus8,
                        String cdFlocStatus9, String cdFlocStatus10, String cdFlocStatus11,
                        String cdFlocStatus12, String cdFlocStatus13, String cdFlocStatus14,
                        String cdFlocStatus15

  );

  /**
   * Update Facility Loc
   *
   * @param dtFlocEnd
   * @param cdFlocStatus1
   * @param cdFlocStatus2
   * @param cdFlocStatus3
   * @param cdFlocStatus4
   * @param cdFlocStatus5
   * @param cdFlocStatus6
   * @param cdFlocStatus7
   * @param cdFlocStatus8
   * @param cdFlocStatus9
   * @param cdFlocStatus10
   * @param cdFlocStatus11
   * @param cdFlocStatus12
   * @param cdFlocStatus13
   * @param cdFlocStatus14
   * @param cdFlocStatus15
   * @param idFloc
   * @param tsLastUpdate
   * @return
   */
  int updateFacilityLoc(
          Date dtFlocEnd, String cdFlocStatus1, String cdFlocStatus2,
          String cdFlocStatus3, String cdFlocStatus4, String cdFlocStatus5,
          String cdFlocStatus6, String cdFlocStatus7, String cdFlocStatus8,
          String cdFlocStatus9, String cdFlocStatus10, String cdFlocStatus11,
          String cdFlocStatus12, String cdFlocStatus13, String cdFlocStatus14,
          String cdFlocStatus15, int idFloc, Date tsLastUpdate
  );

  /**
   * Deletes rows from FacilityLoc based on idResource.
   *
   * @param idResource
   * @return Integer
   */
  int deleteFacilityLoc(int idResource);
}
