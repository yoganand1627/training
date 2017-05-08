/**
 * Created on Mar 25, 2006 at 2:22:08 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ContractVersion;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - added new lastUpdatedBy property to both updateContractVersion() methods
 *
 */

public interface ContractVersionDAO {
  /**
   * Updates a contract version
   * @param idContract
   * @param nbrCnverPeriod
   * @param nbrCnverVersion
   * @param dtLastUpdate
   * @param dtCnverEnd
   * @param lastUpdatedBy
   * @return
   */
  public int updateContractVersion(int idContract, int nbrCnverPeriod, int nbrCnverVersion, Date dtLastUpdate,
                                   Date dtCnverEnd, String lastUpdatedBy);
  /**
   * This selects the previous Contract Version for a particular id_contract and nbr_cnper_period.
   * <p/>
   * From: Ses01.pc
   *
   * @param idContract
   * @param nbrCnperPeriod
   * @return
   */
  public ContractVersion findPreviousContractVersion(int idContract, int nbrCnperPeriod);
  /**
   * This selects the latest Contract Version for a particular id_contract and nbr_cnper_period.
   * <p/>
   * From: Ses01.pc
   *
   * @param idContract
   * @param nbrCnperPeriod
   * @return
   */
  ContractVersion findLatestContractVersion(int idContract, int nbrCnperPeriod);

  /**
   * This selects the current Contract Version for a specific id_contract and nbr_cnper_period.
   * <p/>
   *
   * @param idContract
   * @param nbrCnperPeriod
   * @return ContractVersion for specific contract and period
   */
  ContractVersion findCurrentContractVersion(int idContract, int nbrCnperPeriod);

  /**
   * Retrieve list of ContractVersions by idContract and nbrCnverPeriod
   *
   * @param idContract
   * @param nbrCnverPeriod
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<ContractVersion> findContractVersionByIdContractAndNbrCnperPeriod(int idContract, int nbrCnverPeriod);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractVersion} object to the database.
   *
   * @param contractVersionok A populated {@link contractVersionok} object.
   */
  void saveContractVersion(ContractVersion contractVersion);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractVersion} object to the database.
   *
   * @param idContract
   * @param nbrCnverPeriod
   * @param nbrCnverVersion
   * @param dtLastUpdate
   * @param idCnver
   * @param idCntrctWkr
   * @param nbrCnverNoShowPct
   * @param indCnverVerLock
   * @param txtCnverComment
   * @param dtCnverCreate
   * @param dtCnverEnd
   * @param dtCnverEffective
   * @return Integer
   */
  int updateContractVersion(int idContract, int nbrCnverPeriod, int nbrCnverVersion, Date dtLastUpdate,
                            int idCnver, int idCntrctWkr, int nbrCnverNoShowPct, String indCnverVerLock,
                            String txtCnverComment, Date dtCnverCreate, Date dtCnverEnd, Date dtCnverEffective, String lastUpdatedBy);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.ContractVersion} object to the database.
   *
   * @param idCntrctWkr
   * @param dtCnverEffective
   * @param dtCnverEnd
   * @param indCnverVerLock
   * @param idContract
   * @param nbrCnverPeriod
   * @param nbrCnverVersion
   * @return Integer
   */
  int updateContractVersion(int idCntrctWkr, Date dtCnverEffective, Date dtCnverEnd,
                            String indCnverVerLock, int idContract, int nbrCnverPeriod, int nbrCnverVersion, String lastUpdatedBy);

  /**
   * Delete rows from ContractVersion based on idContract, nbrCnverPeriod, nbrCnverVersion, and dtLastUpdate.
   *
   * @param idContract
   * @param nbrCnverPeriod
   * @param nbrCnverVersion
   * @param dtLastUpdate
   */
  int deleteContractVersion(int idContract, int nbrCnverPeriod, int nbrCnverVersion, Date dtLastUpdate);

}
