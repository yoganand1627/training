package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This is the DAO class is used for the Contract_County table
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  04/08/2009  arege    STGAP00010887 Added method findContractCountyWithinDateRangeSvAuthByidContract 
 *  11/22/2010  arege    SMS#79227: Added method findContractServices to find if there exists services for 
 *                       the given resource in the new county
 *  09/26/2011  arege    STGAP00017053 : Added method updateContractCounty
 * </pre>
 */
public interface ContractCountyDAO {
  /**
   * Retrieves a list of ContractCounty objects by idContract,ContractVersion and ContractPeriod.
   *
   * @param idContract
   * @param nbrCncntyPeriod
   * @param nbrCncntyVersion
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} object for the given idContract,
   *         nbrCncntyPeriod, and nbrCnctyVersion.
   */
  @SuppressWarnings({"unchecked"})
  List<ContractCounty> findContractCountyByIdContactVersionAndPeriod(int idContract, int nbrCncntyPeriod,
                                                                     int nbrCncntyVersion);

  /**
   * This selects all cdCncntyCounty, idCncnty, and dtLastUpdate from ContractCounty in which a resource can provide a
   * service, which may also be contracted within the effective dates given idContract, idResource, cdCncntyService,
   * nbrCncntyPeriod, nbrCncntyVersion, nbrCncntyLineItem, dtCncntyEffective, dtCncntyEnd.
   *
   * @param idContract
   * @param idResource
   * @param cdCncntyService
   * @param nbrCncntyPeriod
   * @param nbrCncntyVersion
   * @param nbrCncntyLineItem
   * @param dtCncntyEffective
   * @param dtCncntyEnd
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} objects for the given criteria.
   */
  @SuppressWarnings({"unchecked"})
  List<ContractCounty> findContractCountyIdCountyLastUpdate(int idContract, int idResource,
                                                            String cdCncntyService, int nbrCncntyPeriod,
                                                            int nbrCncntyVersion, int nbrCncntyLineItem,
                                                            Date dtCncntyEffective, Date dtCncntyEnd);

  /**
   * This selects all cdCncntyCounty from ContractCounty in which a resource can provide a service, which may also be
   * contracted within the effective dates given idResource, cdCncntyService, dtCncntyEffective, dtCncntyEnd.
   *
   * @param idResource
   * @param cdCncntyService
   * @param dtCncntyEffective
   * @param dtCncntyEnd
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} objects for the given criteria.
   */
  @SuppressWarnings({"unchecked"})
  List<String> findContractCountyCncntyCounty(int idResource, String cdCncntyService, Date dtCncntyEffective,
                                              Date dtCncntyEnd);
  /**
   * 
   * @param capsResource
   * @param cdCncntyCounty
   * @param cdCncntyService
   * @return
   */
  ContractCounty findContractCountyNoDateRangeSvAuth(int capsResource, String cdCncntyCounty,
                                                         String cdCncntyService);
  

  /**
   * This selects a row from ContractCounty given idContract and nbrCnperPeriod.
   *
   * @param capsResource
   * @param cdCncntyCounty
   * @param cdCncntyService
   * @param dtCncntyEffective
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} objects for the given criteria.
   */
 ContractCounty findContractCountyWithinDateRangeSvAuth(int capsResource, String cdCncntyCounty,
                                                   String cdCncntyService, Date dtCncntyEffective);
 
//Per STGAP00010887 Added method 
 /**
  * This selects a row from ContractCounty given idContract and nbrCnperPeriod.
  *
  * @param capsResource
  * @param cdCncntyCounty
  * @param idContract
  * @param cdCncntyService
  * @param dtCncntyEffective
  * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} objects for the given criteria.
  */
ContractCounty findContractCountyWithinDateRangeSvAuthByidContract(int capsResource, String cdCncntyCounty, int idContract,
                                                  String cdCncntyService, Date dtCncntyEffective);

  
  /**
   * Retrieves the first result from ContractCounty for the given resource and county where the contract
   * period is in effect for the given dtEffectiveForPeriod and the service defined for the contract is one
   * of the adoption services passed in the Collection.  This query is specific for the RetrieveAdoptionSubsidy
   * service. 
   *
   * @param idResource
   * @param cdCncntyCounty
   * @param dtEffectiveForPeriod
   * @return First {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} object found for the given criteria.
   */
  ContractCounty findContractCountyForAdoptionSubsidy(int idResource, String cdCncntyCounty, Date dtEffectiveForPeriod,
                                                      Collection<String> adoptionServices);
  
  /**
   * This retrieves the contractid from ContractCounty for a given service, county, and idResource 
   * 
   * @param service
   * @param county
   * @param idResource
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} objects for the given criteria.
   */
  int findIdContractByService(String service, String plcmtCnty, int idResource);
  
  /**
   * This retrieves the contractid from ContractCounty for a given service, county, and idResource 
   * 
   * @param service
   * @param county
   * @param idResource
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} objects for the given criteria.
   */
  int findIdResourceByServiceAndCounty(String service, String plcmtCnty);
  
  /**
   * This retrieves all columns from ContractCounty given idContract, nbrCncntyPeriod and nbrCncntyVersion.
   *
   * @param idContract
   * @param nbrCncntyPeriod
   * @param nbrCncntyVersion
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} objects for the given criteria.
   */
  @SuppressWarnings({"unchecked"})
  List<ContractCounty> findContractCounty(int idContract, int nbrCncntyPeriod, int nbrCncntyVersion);

  /**
   * Retrieves a list of rows from CONTRACT COUNTY table by Resource ID, Contract County County CD, Contract County
   * Effective Date and Contract County End Date.
   *
   * @param idResource
   * @param cdCncntyCounty
   * @param dtPlcmtStart
   * @return ContractCounty by idResource, cdCncntyCounty, dtCncntyEffective and dtCncntyEnd
   */
  List<ContractCounty> findContractCountyByIdRsrcAndCdCncntyAndDtCncntyEffective(int idResource,
                                                                                 String cdCncntyCounty,
                                                                                 Date dtPlcmtStart);

  /**
   * This selects all idCncnty from ContractCounty for a given resource where the Contract != the Contract passed in
   * (for a given date range) where the County # and Svc code matches a record from the Contract County Record for the
   * Contract, Period, and Version Passed in, given idContract, dtCncntyEnd, dtCncntyEffective, nbrCncntyPeriod,
   * nbrCncntyVersion.
   *
   * @param idContract
   * @param dtCncntyEnd
   * @param dtCncntyEffective
   * @param nbrCncntyPeriod
   * @param nbrCncntyVersion
   * @return A list of idCncnty's for the given criteria.
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findContractCountyIdCncnty(int idContract, Date dtCncntyEnd, Date dtCncntyEffective,
                                           byte nbrCncntyPeriod, byte nbrCncntyVersion);
  
  /**
   * Retrieves all distinct county-service code values (from CONTRACT_COUNTY)
   * listed for the given contract. If a county value has more than one associated
   * service code, it will be in the results more than once.
   * 
   * @param idContract
   * @return
   */
  List<Object[]> findDistinctCountyServiceByIdContract(int idContract);
  
  /**
   * Retrieves the same results as its brother findDistinctCountyServiceByIdContract, only filtered
   * according to the date provided.
   * 
   * @param idContract
   * @param date
   * @return
   */
  List<Object[]> findEffectiveCountyServiceByIdContract(int idContract, Date date);
  
  /**
   * Retrieves all distinct county values that are considered effective for the given date and idContract.
   * Effective by date translates to counties where DT_CNCNTY_EFFECTIVE <= date <= DT_CNCNTY_END.
   * 
   * @param idContract
   * @param date
   * @return
   */
  List<String> findEffectiveCountiesByIdContract(int idContract, Date date);
  
  /**
   * Finds all cdCncntyService values (service codes) that are listed for the given contract in the
   * given county.
   * 
   * @param idContract
   * @param cdCncntyCounty
   * @return
   */
  List<String> findServicesByIdContractAndCounty(int idContract, String cdCncntyCounty);
  
  /**
   * Retrieves all services and their respective unit type listed on the latest
   * locked contract version for the contract period specified by idContract and the date range between
   * dtRangeStart and dtRangeEnd.
   * 
   * @param idContract
   * @param cdCounty
   * @param dtRangeStart
   * @param dtRangeEnd
   * @return
   */
  List<Map> findServicesWithUnitType(int idContract, Date dtRangeStart, Date dtRangeEnd);
  
  /**
   * 
   * @param idResource
   * @param cdNewCounty
   * @return
   */
   List<Object[]> findContractServices(int idResource, String cdNewCounty);

  /**
   * This checks for any rows on the contract_county table
   *
   * @param idResource
   * @return
   */
  long countContractCountyByIdResource(int idResource);

  /**
   * Inserts/updates an entire row of ContractCounty table.
   *
   * @param contractCounty
   */
  void saveContractCounty(ContractCounty contractCounty);

  /**
   * Retrieves a list maps of ContractCounty objects by idResource,cdRsrcSvcService and cdRsrcSvcCnty.
   *
   * @param idResource
   * @param cdRsrcSvcService
   * @param cdRsrcSvcCnty
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} object for the given idContract,
   *         nbrCncntyPeriod, and nbrCnctyVersion.
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findContractCountyByIdResourceCdRsrcSvcServiceAndcdRsrcSvcCnty(int idResource,
                                                                           String cdRsrcSvcService,
                                                                           String cdRsrcSvcCnty);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractCounty} object.
   *
   * @param contractCounty
   */
  void deleteContractCounty(ContractCounty contractCounty);

  /**
   * Delete rows from ContractCounty based on idContract, nbrCnverPeriod, and nbrCnverVersion.
   *
   * @param idContract
   * @param nbrCnverPeriod
   * @param nbrCnverVersion
   */
  public int deleteContractCounty(int idContract, int nbrCnverPeriod, int nbrCnverVersion);

  /**
   * Delete rows from ContractCounty given idCnsvc and dtLastUpdate.
   *
   * @param idCnsvc
   * @param dtLastUpdate
   */
  public int deleteContractCounty(Date dtLastUpdate, int idCnsvc);

  /**
   * Delete rows from ContractCounty given idContract and nbrCnperPeriod.
   *
   * @param idContract
   * @param nbrCnperPeriod
   */
  public int deleteContractCounty(int idContract, int nbrCnperPeriod);
  /**
   * Select rows from ContractCounty given idContract
   *
   * @param idContract
   * 
   */  
  
  public String findContractCounties(int idContract);
  
  /**
   * 
   * @param idCntrctWkr
   * @param dtCncntyEffective
   * @param dtCncntyEnd
   * @param idContract
   * @param nbrCncntyPeriod
   * @param nbrCncntyVersion
   * @return
   */
  //STGAP  Added new method
  public int updateContractCounty(int idCntrctWkr, Date dtCncntyEffective, Date dtCncntyEnd,
          int idContract, int nbrCncntyPeriod, int nbrCncntyVersion);
}

