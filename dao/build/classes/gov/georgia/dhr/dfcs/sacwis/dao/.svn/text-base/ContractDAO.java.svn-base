/**
 * Created on Mar 25, 2006 at 2:23:29 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Contract;

public interface ContractDAO {
  /**
   * Retrieves count by resourceAddress.idResourceAddress
   *
   * @param idRsrcAddress
   * @return The count of rows for a particular address.
   */
  long countContractByIdRsrcAddress(int idRsrcAddress);

  /**
   * Retrieves a list of Contracts based on id Resource
   *
   * @param idResource
   * @return A list of contracts for a particular resource.
   */
  @SuppressWarnings({"unchecked"})
  List<Contract> findContractByIdResource(int idResource);

  /**
   * Retrieves Cd Cntrct Func Type, Cd Cntrct Procure Type, Cd Cntrct Program Type, Cd Cntrct Region, Ind Cntrct Budg
   * Limit, Nm Resource nd Nm Person Full fo an Id Contract, Id Resource and Id Cntrct Manager combination given
   * idContract.
   *
   * @param idContract
   * @return A full row from the contract table based on its primary key.
   */
  Contract findContractTypes(int idContract);

  /**
   * This will select rows from the Contract, Caps Resource, & Resource Address tables. One must pass in a zero for
   * either the IdInvoice or IdContract Id Contract will override IdInvoice unless IdInvoice is > 0 and IdContract ==
   * 0.
   *
   * @param idContract
   * @return A full row from the contract table with its Contract and CapsResource records already populated.
   */
  Contract findContractIdContract(int idContract);

  /**
   * Retrieve Contract data along with capsCase idResource and full name
   *
   * @param idContract
   * @return
   */
  public Map findContractAndMore(int idContract);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.Contract} object to the database.
   *
   * @param contract A populated {@link gov.georgia.dhr.dfcs.sacwis.db.Contract} object.
   */
  void saveContract(Contract contract);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.Contract} object.
   *
   * @param contract
   */
  void deleteContract(Contract contract);
}
