package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;

import java.util.Date;
import java.util.List;

public interface DynamicTCMClaimDAO {

  /**
   * Fetches TCM Claims records from the database based on inputs from TCM Claims page
   * 
   * @param idStaff
   * @param dtService
   * @param status
   * @return
   */
  List<TcmClaim> findTCMClaims(int idStaff, int idPerson, Date dtStart, Date dtEnd, String status, String county, String unit);

}
