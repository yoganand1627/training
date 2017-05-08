/**
 * Created on Mar 25, 2006 at 2:22:40 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ContractService;

/**
 *                                        Change History
 *
 *   Date          User                     Description
 * --------  ----------------  --------------------------------------------------
 * 10/16/11  charden           STGAP00017058: created methods countContractSvcByPrdVersIdContractService() and findMaxCnsvcLineItemByIdContractPeriodVersion()
 *
 *
 *
*/

public interface ContractServiceDAO {
  /**
   * Counts the number of services present for a given contract id, period, version and service
   * @param idContract
   * @param nbrCnsvcVersion
   * @param nbrCnsvcPeriod
   * @param cdCnsvcService
   * @return
   */
  public Long countContractSvcByPrdVersIdContractService(int idContract, int nbrCnsvcVersion, int nbrCnsvcPeriod, String cdCnsvcService);
  
  /**
   * Finds the maximum contract service line item for a given contract's period and version
   * @param idContract
   * @param nbrCnsvcPeriod
   * @param nbrCnsvcVersion
   * @return
   */
  public Integer findMaxCnsvcLineItemByIdContractPeriodVersion(int idContract, int nbrCnsvcPeriod, int nbrCnsvcVersion);
  
  /**
   * Retrieves (a row) base per diem rate from ContractService
   *
   * @param idContract
   * @param cdCnsvcService
   * @return Double
   */
  Double findNbrContractSvcByIdContractAndCdContractSvc(int idContract, String cdCnsvcService);
  
  /**
   * Retrieves (a row) budget amount available for a service from ContractService
   *
   * @param nbrCnsvcPeriod
   * @param nbrCnsvcVersion
   * @param nbrCnsvcLineItem
   * @param idContract
   * @param cdCnsvcService
   * @return ContractService
   */
  ContractService findContractServiceByIdContract(int nbrCnsvcPeriod, int nbrCnsvcVersion, int nbrCnsvcLineItem,
                                                  int idContract, String cdCnsvcService);

  /**
   * This select will retreive all columns up to 100 rows from CONTRACT SERVICE table given idContract, nbrCnsvcPeriod,
   * and nbrCnsvcVersion.
   *
   * @param idContract
   * @param nbrCnsvcPeriod
   * @param nbrCnsvcVersion
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.ContractService} objects.
   */
  @SuppressWarnings({"unchecked"})
  List<ContractService> findContractServiceAll(int nbrCnsvcPeriod, int nbrCnsvcVersion, int idContract);

  /**
   * This returns the max CnsvcLineItem from ContractService based on the contract id.
   *
   * @param idContract
   * @return max nbrCnsvcLineItem
   */
  Integer findMaxCnsvcLineItemByIdContract(int idContract);

  /**
   * This select will retreive all rows from CONTRACT SERVICE table given Contract ID, Contract Service Period Number
   * and Contract Service Version Number.
   *
   * @param idContract
   * @param nbrCnsvcPeriod
   * @param nbrCnsvcVersion
   * @return List ContractService by idContract, nbrCnsvcPeriod and nbrCnsvcVersion
   */
  @SuppressWarnings({"unchecked"})
  List<ContractService> findConSvcByIdConAndNbrCnsvcPeriodAndNbrCnsvcVersion(int nbrCnsvcPeriod, int nbrCnsvcVersion,
                                                                             int idContract);

  /**
   * This select will retreive all rows from CONTRACT SERVICE table given Contract ID, Contract Service Period Number
   * and Contract Service Version Number.
   *
   * @param idContract
   * @return List ContractService by idContract, (MAX)nbrCnsvcPeriod and (MAX)nbrCnsvcVersion
   */
  @SuppressWarnings({"unchecked"})
  List<ContractService> findConSvcByIdConAndNbrCnsvcPeriodMaxAndNbrCnsvcVersionMax(int idContract);

  @SuppressWarnings({"unchecked"})
  List<String> findCdCnsvcServiceByIdContract(int idContract);
 
  /**
   * This returns number of rows from CONTRACT_SERVICE table given Id_Contract and 
   * Contract Service Line Item
   * 
   * @param idContract,nbrCnsvcLineItem,nbrCnsvcVersion,nbrCnsvcPeriod
   * @return  nbrRowsReturned.
   * 
   * Per STGAP00008089 
   */
  // STGAP00017051: Changed method name and added more parameters
  Long countConSvcByIdConAndNbrConSvcLineItemAndNbrConVerAndConPeriod(int idContract,int nbrCnsvcLineItem, int nbrCnsvcVersion, int nbrCnsvcPeriod);
  
  

  /**
   * This selects all the information about a contract by line item number
   *
   * @param szCdCncntyCounty
   * @param idContract
   * @param nbrCnsvcVersion
   * @param nbrCnsvcPeriod
   * @return A list of Object Arrays due to no implicit relationship between line items; the first element is a
   *         ContractService object, and the second is a ContractCounty object.
   */
  @SuppressWarnings({"unchecked"})
  List<Object[]> findServicesContractedInCounty(String szCdCncntyCounty, int idContract, int nbrCnsvcVersion,
                                                int nbrCnsvcPeriod);
  
  double findContractedRateByIdResourceByDateByService(int idResoucre, Date dtEffDate, String service);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractService} object to the database.
   *
   * @param contractService A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ContractService} object.
   */
  void saveContractService(ContractService contractService);

  /**
   * Retrieves a row from ContractService and ContractVersion tables (searches Contract Service for the Amt
   * CnsvcUnitRate)
   *
   * @param idContract
   * @param moSvcDtlSvcMonth
   * @param yrSvcDtlServiceYear
   * @param cdCncntyCounty
   * @param cdCnsvcService
   * @return The results of the select in an object array.
   */
  Object[] findContractServiceAndContractVersion(int idContract, int moSvcDtlSvcMonth, int yrSvcDtlServiceYear,
                                                 String cdCncntyCounty, String cdCnsvcService);

  /**
   * Partial update of ContractService table using the supplied parameters(column values).
   *
   * @param idCntrctWkr
   * @param amtCnsvcEquip
   * @param amtCnsvcFrgBenft
   * @param amtCnsvcOther
   * @param amtCnsvcSalary
   * @param amtCnsvcSupply
   * @param amtCnsvcTravel
   * @param amtCnsvcUnitRate
   * @param idCnsvc
   * @param dtLastupdate
   */
  int updateContractService(int idCntrctWkr, double amtCnsvcEquip, double amtCnsvcFrgBenft, double amtCnsvcOther,
                            double amtCnsvcSalary, double amtCnsvcSupply, double amtCnsvcTravel,
                            double amtCnsvcUnitRate, int idCnsvc, Date dtLastupdate);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractService} object to the database.
   *
   * @param idContract
   * @param idCntrctWkr
   * @param nbrCnsvcPeriod
   * @param nbrCnsvcVersion
   * @param nbrCnsvcLineItem
   * @param cdCnsvcService
   * @param cdCnsvcPaymentType
   * @param indCnsvcNewRow
   * @param cdCnsvcUnitType
   * @param nbrCnsvcFedMatch
   * @param nbrCnsvcLocalMatch
   * @param nbrCnsvcUnitRate
   * @param amtCnsvcAdminAllUsed
   * @param amtCnsvcEquip
   * @param amtCnsvcEquipUsed
   * @param amtCnsvcFrgBenft
   * @param amtCnsvcFrgBenftUsed
   * @param amtCnsvcOffItemUsed
   * @param amtCnsvcOther
   * @param amtCnsvcOtherUsed
   * @param amtCnsvcSalary
   * @param amtCnsvcSalaryUsed
   * @param amtCnsvcSupply
   * @param amtCnsvcSupplyUsed
   * @param amtCnsvcTravel
   * @param amtCnsvcTravelUsed
   * @param amtCnsvcUnitRate
   * @param amtCnsvcUnitRateUsed
   * @param dtLastUpdate
   * @param idCnsvc
   * @return The number of rows updated.
   */
  int updateContractService(int idContract, int idCntrctWkr, int nbrCnsvcPeriod, int nbrCnsvcVersion,
                            int nbrCnsvcLineItem, String cdCnsvcService, String cdCnsvcPaymentType,
                            String indCnsvcNewRow, String cdCnsvcUnitType, int nbrCnsvcFedMatch, int nbrCnsvcLocalMatch,
                            double nbrCnsvcUnitRate, double amtCnsvcAdminAllUsed, double amtCnsvcEquip,
                            double amtCnsvcEquipUsed, double amtCnsvcFrgBenft, double amtCnsvcFrgBenftUsed,
                            double amtCnsvcOffItemUsed, double amtCnsvcOther, double amtCnsvcOtherUsed,
                            double amtCnsvcSalary, double amtCnsvcSalaryUsed, double amtCnsvcSupply,
                            double amtCnsvcSupplyUsed, double amtCnsvcTravel, double amtCnsvcTravelUsed,
                            double amtCnsvcUnitRate, double amtCnsvcUnitRateUsed, Date dtLastUpdate, int idCnsvc);
  
  /**
   * This method imitates batch logic to increment the amtCnsvcUnitRateUsed amount of one specific
   * ContractService record with the addUnitRateUsed amount given.  The record to update must match
   * the given idContract, cdService, and be on the latest version of the latest period with
   * (a) a period status of one of the given statuses according to allPayableStatuses and 
   * (b) a period that falls within the date range between dtRangeStart (i.e. beginning of month)
   *     and dtRangeEnd (i.e. end of month).
   * 
   * @param addUnitRateUsed
   * @param idContract
   * @param cdService
   * @param dtRangeStart
   * @param dtRangeEnd
   * @param allPayableStatuses
   * @return
   */
  int updateContractServiceForContractBudgetLimit(double addUnitRateUsed, int idContract, String cdService,
                                                  Date dtRangeStart, Date dtRangeEnd, Collection<String> allPayableStatuses);

  /**
   * Delete rows from ContractService based on idContract, nbrCnverPeriod, and nbrCnverVersion.
   *
   * @param idContract
   * @param nbrCnverPeriod
   * @param nbrCnverVersion
   */
  int deleteContractService(int idContract, int nbrCnverPeriod, int nbrCnverVersion);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractService} object.
   *
   * @param contractService
   */
  void deleteContractService(ContractService contractService);

  /**
   * Delete rows from ContractService based on idContract and nbrCnperPeriod.
   *
   * @param idContract
   * @param nbrCnperPeriod
   */
  int deleteContractService(int idContract, int nbrCnperPeriod);
  
  /**
   * Return count
   *
   * @param cdCnsvcService
   * @param idResource
   * @return
   */
  Long countHomeCntrctSvc(String cdCnsvcService, int idResource);
  
  /**
   * Return count
   *
   * @param cdCnsvcService
   * @param idResource
   * @return
   */
  Long countRbwoCntrctSvc(String cdCnsvcService, int idResource);
}
