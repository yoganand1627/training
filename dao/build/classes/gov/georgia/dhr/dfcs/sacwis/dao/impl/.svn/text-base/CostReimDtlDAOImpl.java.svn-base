package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.CostReimDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CostReimDtl;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class CostReimDtlDAOImpl extends BaseDAOImpl implements CostReimDtlDAO {
  @SuppressWarnings({"unchecked"})
  public List<CostReimDtl> findCostReimDtl(int idInvoice) {
    Query query = getSession().createQuery(" from CostReimDtl c " +
                                           "where c.invoice.idInvoice = :idInvoice ");
    query.setInteger("idInvoice", idInvoice);
    return (List<CostReimDtl>) query.list();
  }

  public int updateCostReimDtl(int idCostReim, int idInvoInvoice, double amtCostReimAdminAll, double amtCostReimEquip,
                               double amtCostReimFrgBenft, double amtCostReimOffItem, double amtCostReimDtlOther,
                               double amtCostReimSalary, double amtCostReimSupply, double amtCostReimTravel,
                               String cdCostReimInvoDisptn, String cdCostReimService, String cdCostReimLiType,
                               String indCostReimRejItm, int nbrCostReimCsli, int nbrCostReimUnitQty, Date lastUpdate) {
    Query query = getSession().createQuery(" update CostReimDtl " +
                                           "    set idCostReim =:idCostReim, " +
                                           "        invoice.idInvoice =:idInvoInvoice, " +
                                           "        amtCostReimAdminAll =:amtCostReimAdminAll, " +
                                           "        amtCostReimEquip =:amtCostReimEquip, " +
                                           "        amtCostReimFrgBenft =:amtCostReimFrgBenft, " +
                                           "        amtCostReimOffItem =:amtCostReimOffItem, " +
                                           "        amtCostReimOther =:amtCostReimDtlOther, " +
                                           "        amtCostReimSalary =:amtCostReimSalary, " +
                                           "        amtCostReimSupply =:amtCostReimSupply, " +
                                           "        amtCostReimTravel =:amtCostReimTravel, " +
                                           "        cdCostReimInvoDisptn =:cdCostReimInvoDisptn, " +
                                           "        cdCostReimService =:cdCostReimService, " +
                                           "        cdCostReimLiType =:cdCostReimLiType, " +
                                           "        indCostReimRejItm =:indCostReimRejItm, " +
                                           "        nbrCostReimCsli =:nbrCostReimCsli, " +
                                           "        nbrCostReimUnitQty =:nbrCostReimUnitQty " +
                                           "  where dtLastUpdate =:lastUpdate " +
                                           "    and idCostReim = :idCostReim ");
    query.setInteger("idCostReim", idCostReim);
    query.setInteger("idInvoInvoice", idInvoInvoice);
    query.setDouble("amtCostReimAdminAll", amtCostReimAdminAll);
    query.setDouble("amtCostReimEquip", amtCostReimEquip);
    query.setDouble("amtCostReimFrgBenft", amtCostReimFrgBenft);
    query.setDouble("amtCostReimOffItem", amtCostReimOffItem);
    query.setDouble("amtCostReimDtlOther", amtCostReimDtlOther);
    query.setDouble("amtCostReimSalary", amtCostReimSalary);
    query.setDouble("amtCostReimSupply", amtCostReimSupply);
    query.setDouble("amtCostReimTravel", amtCostReimTravel);
    query.setString("cdCostReimInvoDisptn", cdCostReimInvoDisptn);
    query.setString("cdCostReimService", cdCostReimService);
    query.setString("cdCostReimLiType", cdCostReimLiType);
    query.setString("indCostReimRejItm", indCostReimRejItm);
    query.setInteger("nbrCostReimCsli", nbrCostReimCsli);
    query.setInteger("nbrCostReimUnitQty", nbrCostReimUnitQty);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  public int insertCostReimDtl(Date lastUpdate, int idInvoInvoice, double amtCostReimAdminAll, double amtCostReimEquip,
                               double amtCostReimFrgBenft, double amtCostReimOffItem, double amtCostReimDtlOther,
                               double amtCostReimSalary, double amtCostReimSupply, double amtCostReimTravel,
                               String cdCostReimInvoDisptn, String cdCostReimService, String cdCostReimLiType,
                               String indCostReimRejItm, int nbrCostReimCsli, int nbrCostReimUnitQty) {
    SQLQuery query = getSession().createSQLQuery(" INSERT INTO COST_REIM_DTL (ID_COST_REIM, " +
                                                 "                            DT_LAST_UPDATE, " +
                                                 "                            ID_INVOICE, " +
                                                 "                            AMT_COST_REIM_ADMIN_ALL, " +
                                                 "                            AMT_COST_REIM_EQUIP, " +
                                                 "                            AMT_COST_REIM_FRG_BENFT, " +
                                                 "                            AMT_COST_REIM_OFF_ITEM, " +
                                                 "                            AMT_COST_REIM_OTHER, " +
                                                 "                            AMT_COST_REIM_SALARY, " +
                                                 "                            AMT_COST_REIM_SUPPLY, " +
                                                 "                            AMT_COST_REIM_TRAVEL, " +
                                                 "                            CD_COST_REIM_INVO_DISPTN, " +
                                                 "                            CD_COST_REIM_SERVICE, " +
                                                 "                            CD_COST_REIM_LI_TYPE, " +
                                                 "                            IND_COST_REIM_REJ_ITM, " +
                                                 "                            NBR_COST_REIM_CSLI, " +
                                                 "                            NBR_COST_REIM_UNIT_QTY )  " +
                                                 "      VALUES(SEQ_COST_REIM_DTL.NEXTVAL, " +
                                                 "             :lastUpdate, " +
                                                 "             :idInvoInvoice, " +
                                                 "             :amtCostReimAdminAll, " +
                                                 "             :amtCostReimEquip, " +
                                                 "             :amtCostReimFrgBenft, " +
                                                 "             :amtCostReimOffItem, " +
                                                 "             :amtCostReimDtlOther, " +
                                                 "             :amtCostReimSalary, " +
                                                 "             :amtCostReimSupply, " +
                                                 "             :amtCostReimTravel, " +
                                                 "             :cdCostReimInvoDisptn, " +
                                                 "             :cdCostReimService, " +
                                                 "             :cdCostReimLiType, " +
                                                 "             :indCostReimRejItm, " +
                                                 "             :nbrCostReimCsli, " +
                                                 "             :nbrCostReimUnitQty) ");
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setInteger("idInvoInvoice", idInvoInvoice);
    query.setDouble("amtCostReimAdminAll", amtCostReimAdminAll);
    query.setDouble("amtCostReimEquip", amtCostReimEquip);
    query.setDouble("amtCostReimFrgBenft", amtCostReimFrgBenft);
    query.setDouble("amtCostReimOffItem", amtCostReimOffItem);
    query.setDouble("amtCostReimDtlOther", amtCostReimDtlOther);
    query.setDouble("amtCostReimSalary", amtCostReimSalary);
    query.setDouble("amtCostReimSupply", amtCostReimSupply);
    query.setDouble("amtCostReimTravel", amtCostReimTravel);
    query.setString("cdCostReimInvoDisptn", cdCostReimInvoDisptn);
    query.setString("cdCostReimService", cdCostReimService);
    query.setString("cdCostReimLiType", cdCostReimLiType);
    query.setString("indCostReimRejItm", indCostReimRejItm);
    query.setInteger("nbrCostReimCsli", nbrCostReimCsli);
    query.setInteger("nbrCostReimUnitQty", nbrCostReimUnitQty);
    return query.executeUpdate();
  }

}
