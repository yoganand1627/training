/**
 * This class declares the interface for the ContractPeriodDAO and holds the simple
 * methods for accessing the CONTRACT_PERIOD table in the CAPS schema.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 03/25/06  Michael Werle     Created file.
 * 01/19/09  Patrick Coogan    STGAP00011971: Added method findListOfContractPeriodByIdResource
 *                             as a part of MR-027 to find when a resource has at least one
 *                             active contract period
 * 09/12/11  charden           STGAP00017058 - added txtLastUpdatedBy to updateContractPeriod() methods
 * </pre>
 */

package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;

public interface ContractPeriodDAO {
  /**
   * Gets the termination date from the contract period table that has the maximum period number.
   * 
   * @param idContract
   * @return Date
   */
  Date findDtCnperTermByMaxNbrCnperPeriod(int idContract);

  /**
   * This will select a full row from the contract & contract period table.
   * 
   * @param idContract
   * @param nbrCnperPeriod
   * @return ContractPeriod
   */
  ContractPeriod findContractPeriodByIdContractAndNbrCnperPeriod(int idContract, int nbrCnperPeriod);

  /**
   * This will select all rows from the ContractPeriod table given the Contract ID
   * 
   * @param idContract
   * @return List of ContractPeriod by an idContract
   */
  @SuppressWarnings( { "unchecked" })
  List<ContractPeriod> findListOfContractPeriodByIdContract(int idContract);

  /**
   * This selects a row from Contract and ContractPeriod given idContract and nbrCnperPeriod.
   * 
   * @param idContract
   * @param nbrCnperPeriod
   * @return ContractPeriod
   */
  ContractPeriod findContractPeriodAndContract(int idContract, int nbrCnperPeriod);

  /**
   * This selects a row from ContractPeriod given idContract and nbrCnperPeriod.
   * 
   * @param idContract
   * @param nbrCnperPeriod
   * @return ContractPeriod
   */
  ContractPeriod findContractPeriodWithIdContractAndNbrCnperPeriod(int idContract, int nbrCnperPeriod);

  /**
   * Retrieves a row from the Contract & Contract Period tables. ( not look for PENDING contracts)
   * 
   * @param idContract
   * @param nbrCnperPeriod
   * @return ContractPeriod
   */
  ContractPeriod findContractPeriodFromContractAndContractPeriod(int idContract, int nbrCnperPeriod);

  /**
   * This will select a full row from the contract period table by contract Id and closed date in the future.
   * 
   * @param idContract
   * @return ContractPeriod
   */
  ContractPeriod findContractPeriodByIdContract(int idContract);

  /**
   * Deletes a full row from the contract period table by contract Id and nbrCnperPeriod and dtLastUpdate.
   * 
   * @param idContract
   * @param nbrCnperPeriod
   * @param dtLastUpdate
   * @return int representing the number of rows deleted
   */
  public int deleteContractPeriod(int idContract, int nbrCnperPeriod, Date dtLastUpdate);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod} object to the database.
   * 
   * @param idCntrctWkr
   * @param cdCnperStatus
   * @param dtCnperStart
   * @param dtCnperTerm
   * @param dtCnperClosure
   * @param indCnperRenewal
   * @param indCnperSigned
   * @param nbrLegalIdentifier
   * @param dtLastUpdate
   * @param idContract
   * @param nbrCnperPeriod
   * @param txtTermComm
   * @return Integer
   */
  int updateContractPeriod(int idCntrctWkr, String cdCnperStatus, Date dtCnperStart, Date dtCnperTerm,
                           Date dtCnperClosure, String indCnperRenewal, String indCnperSigned, int nbrLegalIdentifier,
                           Date dtLastUpdate, int idContract, int nbrCnperPeriod, String txtTermComm, String lastUpdatedBy);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod} object to the database.
   * 
   * @param idCntrctWkr
   * @param cdCnperStatus
   * @param dtCnperStart
   * @param dtCnperTerm
   * @param dtCnperClosure
   * @param indCnperRenewal
   * @param indCnperSigned
   * @param nbrLegalIdentifier
   * @param dtLastUpdate
   * @param idContract
   * @param nbrCnperPeriod
   * @return Integer
   */
  int updateContractPeriod(int idCntrctWkr, String cdCnperStatus, Date dtCnperStart, Date dtCnperTerm,
                           Date dtCnperClosure, String indCnperRenewal, String indCnperSigned, int nbrLegalIdentifier,
                           Date dtLastUpdate, int idContract, int nbrCnperPeriod, String lastUpdatedBy);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod} object to the database.
   * 
   * @param contractPeriod
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod} object.
   */
  void saveContractPeriod(ContractPeriod contractPeriod);
  
  
  /**
   * This will select all active rows from the ContractPeriod table given the Resource ID
   * 
   * @param idResource
   * @return List of open, active contract periods for a resource ID based on sysdate
   */
  @SuppressWarnings( { "unchecked" })
  List<ContractPeriod> findListOfContractPeriodByIdResource(int idResource);

}
