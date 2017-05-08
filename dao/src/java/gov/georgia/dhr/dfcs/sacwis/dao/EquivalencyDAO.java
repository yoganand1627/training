package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Equivalency;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EquivalencyDAO {
  /**
   * Checks and see if the service code exists in the Equivalency table. For greater of svc_auth_dtl/stage start up to
   * svc_auth end.
   *
   * @param cdEquivSvcDtlService
   * @param dtStartDate
   * @param dtEndDate
   * @param idEvent
   * @return Integer representing the count of service code
   */
  public long countExistenceOfServiceCodeForGivenTimeAndStage(String cdEquivSvcDtlService, Date dtStartDate,
                                                              Date dtEndDate, int idEvent);

  /**
   * Checks and see if the service code exists in the Equivalency table. For svc_auth start to lesser of stage start and
   * svc auth end (This is only called when the svc_auth is before the stage start.
   *
   * @param cdEquivSvcDtlService
   * @param dtStartDate
   * @param dtEndDate
   * @param idPerson
   * @return Integer representing the count of service code
   */
  public long countExistenceOfServiceCodeWhenSvAuthBeforeStageStart(String cdEquivSvcDtlService, Date dtStartDate,
                                                                    Date dtEndDate, int idPerson);

  /**
   * Checks and see if the service code is exempt from the Equivalency table by querying the Non_Equivalency table.
   *
   * @param cdEquivSvcDtlService
   * @param dtStartDate
   * @param dtEndDate
   * @return Integer representing the count of service code
   */
  public long countExemptServiceCodeFromNonEquivalency(String cdEquivSvcDtlService, Date dtStartDate,
                                                       Date dtEndDate);

  /**
   * Checks to see if the service code exists in the Equivalency table for the given time period when a user adds new
   * Contract Services to a Contract.
   *
   * @param cdEquivSvcDtlService
   * @param dtStartDate
   * @param dtEndDate
   * @return Integer representing the count of service code
   */
  public long countExistenceOfServiceCodeFromEquivalency(String cdEquivSvcDtlService, Date dtStartDate,
                                                         Date dtEndDate);
  
  /**
   * insert or update
   * @param equivalency
   * @return
   */
  public int saveEquivalency(Equivalency equivalency);
  
  /**
   * Find a service active for the period start and end
   * @param cdSvcCode
   * @param dtStartDate
   * @param dtEndDate
   * @return
   */
  public List<Equivalency> findEquivalencyBySvcCodeDtStartDtEnd(String cdSvcCode, Date dtStartDate, Date dtEndDate);
  
  /**
   * Find a service lookup by the id row
   * @param idEquiv
   * @return
   */
  public Equivalency findEquivalencyByIdEquiv(int idEquiv);
  
  /**
   * 
   * @param eqIdList
   * @return
   */
  public List<Map<String, Object>> findSvcCodeIquivByIds(List<Integer> eqIdList);
}
