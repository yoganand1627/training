/**
 * Created on Mar 25, 2006 at 2:21:48 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.CostReimDtl;

public interface CostReimDtlDAO {
  /**
   * This does a full retrieval from CostReimDtl given idInvoice.
   *
   * @param idInvoice
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<CostReimDtl> findCostReimDtl(int idInvoice);

  /**
   * Partial update of CostReimDtl table using the supplied parameters(column values).
   *
   * @param idCostReim
   * @param idInvoInvoice
   * @param amtCostReimAdminAll
   * @param amtCostReimEquip
   * @param amtCostReimFrgBenft
   * @param amtCostReimOffItem
   * @param amtCostReimDtlOther
   * @param amtCostReimSalary
   * @param amtCostReimSupply
   * @param amtCostReimTravel
   * @param cdCostReimInvoDisptn
   * @param cdCostReimService
   * @param cdCostReimLiType
   * @param indCostReimRejItm
   * @param nbrCostReimCsli
   * @param nbrCostReimUnitQty
   * @param lastUpdate
   */
  int updateCostReimDtl(int idCostReim, int idInvoInvoice, double amtCostReimAdminAll, double amtCostReimEquip,
                        double amtCostReimFrgBenft, double amtCostReimOffItem, double amtCostReimDtlOther,
                        double amtCostReimSalary, double amtCostReimSupply, double amtCostReimTravel,
                        String cdCostReimInvoDisptn, String cdCostReimService, String cdCostReimLiType,
                        String indCostReimRejItm, int nbrCostReimCsli, int nbrCostReimUnitQty, Date lastUpdate);

  /**
   * Partial insert of CostReimDtl table using the supplied parameters(column values). (Note that the insert is done
   * using straight SQL)
   *
   * @param lastUpdate
   * @param idInvoInvoice
   * @param amtCostReimAdminAll
   * @param amtCostReimEquip
   * @param amtCostReimFrgBenft
   * @param amtCostReimOffItem
   * @param amtCostReimDtlOther
   * @param amtCostReimSalary
   * @param amtCostReimSupply
   * @param amtCostReimTravel
   * @param cdCostReimInvoDisptn
   * @param cdCostReimService
   * @param cdCostReimLiType
   * @param indCostReimRejItm
   * @param nbrCostReimCsli
   * @param nbrCostReimUnitQty
   */
  int insertCostReimDtl(Date lastUpdate, int idInvoInvoice, double amtCostReimAdminAll, double amtCostReimEquip,
                        double amtCostReimFrgBenft, double amtCostReimOffItem, double amtCostReimDtlOther,
                        double amtCostReimSalary, double amtCostReimSupply, double amtCostReimTravel,
                        String cdCostReimInvoDisptn, String cdCostReimService, String cdCostReimLiType,
                        String indCostReimRejItm, int nbrCostReimCsli, int nbrCostReimUnitQty);

}
