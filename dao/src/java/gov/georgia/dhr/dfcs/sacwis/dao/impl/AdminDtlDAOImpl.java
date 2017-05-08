package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdminDtl;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class AdminDtlDAOImpl extends BaseDAOImpl implements AdminDtlDAO {
  
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<AdminDtl> findAdminDtlByIdInvoResource(int idInvoResource, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("     from AdminDtl a" +
                                           "    where a.invoice.idInvoice = :idInvoInvoice" +
                                           " order by a.cdAdminDtlService," +
                                           "          a.nbrAdminDtlCsli");

    query.setInteger("idInvoInvoice", idInvoResource);
    return (PaginatedHibernateList<AdminDtl>) paginatedList(pageNbr, pageSize, query);
  }

  public long countAdminDtlIdAdminDtl(int idInvoice, String cdAdminDtlLiType) {
    Query query = getSession().createQuery(" select count(a.idAdminDtl) " +
                                           "   from AdminDtl a " +
                                           "  where a.invoice.idInvoice = :idInvoice " +
                                           "    and a.cdAdminDtlLiType = :cdAdminDtlLiType ");
    query.setInteger("idInvoice", idInvoice);
    query.setString("cdAdminDtlLiType", cdAdminDtlLiType);
    return (Long) query.uniqueResult();
  }
  
  public int updateAdminDtlAsPaid(int idAdminDtl, int nbrCheck, double amtSmilePaid, Date dtPaid) {
    Query query = getSession().createQuery("update AdminDtl ad " +
                                           "   set ad.nbrCheck = :nbrCheck, " +
                                           "       ad.amtSmilePaid = :amtSmilePaid, " +
                                           "       ad.dtPaid = :dtPaid " +
                                           " where ad.idAdminDtl = :idAdminDtl");
    query.setInteger("nbrCheck", nbrCheck);
    query.setDouble("amtSmilePaid", amtSmilePaid);
    query.setDate("dtPaid", dtPaid);
    query.setInteger("idAdminDtl", idAdminDtl);
    return query.executeUpdate();
  }

  public int updateAdminDtl(int idAdminDtl, int idInvoInvoice, double amtAdminDtlAdminAlloc,
                            double amtAdminDtlEquipment,
                            double amtAdminDtlFrgBenft, double amtAdminDtlOffsetItem, double amtAdminDtlOther,
                            double amtAdminDtlSalaries, double amtAdminDtlSupplies, double amtAdminDtlTravel,
                            String cdAdminDtlService, String cdAdminDtlInvoDisptn, String cdAdminDtlLiType,
                            String indAdminDtlRejItm, int moAdminDtlSvcMonth, int nbrAdminDtlCsli,
                            int yrAdminDtlSvcYear, Date lastUpdate, String cdCounty, double amtPromotional,
                            String txtComments) {
    Query query = getSession().createQuery(" update AdminDtl " +
                                           "    set idAdminDtl = :idAdminDtl, " +
                                           "        invoice.idInvoice = :idInvoInvoice, " +
                                           "        amtAdminDtlAdminAlloc =:amtAdminDtlAdminAlloc, " +
                                           "        amtAdminDtlEquipment =:amtAdminDtlEquipment, " +
                                           "        amtAdminDtlFrgBenft = :amtAdminDtlFrgBenft, " +
                                           "        amtAdminDtlOffsetItem = :amtAdminDtlOffsetItem, " +
                                           "        amtAdminDtlOther = :amtAdminDtlOther, " +
                                           "        amtAdminDtlSalaries = :amtAdminDtlSalaries, " +
                                           "        amtAdminDtlSupplies = :amtAdminDtlSupplies, " +
                                           "        amtAdminDtlTravel = :amtAdminDtlTravel, " +
                                           "        cdAdminDtlService = :cdAdminDtlService, " +
                                           "        cdAdminDtlInvoDisptn = :cdAdminDtlInvoDisptn, " +
                                           "        cdAdminDtlLiType = :cdAdminDtlLiType, " +
                                           "        indAdminDtlRejItm = :indAdminDtlRejItm, " +
                                           "        moAdminDtlSvcMonth = :moAdminDtlSvcMonth, " +
                                           "        nbrAdminDtlCsli = :nbrAdminDtlCsli, " +
                                           "        yrAdminDtlSvcYear = :yrAdminDtlSvcYear, " +
                                           "        cdCounty          = :cdCounty," +
                                           "        amtAdminDtlPromotional =  :amtPromotional ," +
                                           "        txtComments = :txtComments" +
                                           "  where dtLastUpdate = :lastUpdate " +
                                           "    and idAdminDtl = :idAdminDtl ");
    query.setInteger("idAdminDtl", idAdminDtl);
    query.setInteger("idInvoInvoice", idInvoInvoice);
    query.setDouble("amtAdminDtlAdminAlloc", amtAdminDtlAdminAlloc);
    query.setDouble("amtAdminDtlEquipment", amtAdminDtlEquipment);
    query.setDouble("amtAdminDtlFrgBenft", amtAdminDtlFrgBenft);
    query.setDouble("amtAdminDtlOffsetItem", amtAdminDtlOffsetItem);
    query.setDouble("amtAdminDtlOther", amtAdminDtlOther);
    query.setDouble("amtAdminDtlSalaries", amtAdminDtlSalaries);
    query.setDouble("amtAdminDtlSupplies", amtAdminDtlSupplies);
    query.setDouble("amtAdminDtlTravel", amtAdminDtlTravel);
    query.setString("cdAdminDtlService", cdAdminDtlService);
    query.setString("cdAdminDtlInvoDisptn", cdAdminDtlInvoDisptn);
    query.setString("cdAdminDtlLiType", cdAdminDtlLiType);
    query.setString("indAdminDtlRejItm", indAdminDtlRejItm);
    query.setInteger("moAdminDtlSvcMonth", moAdminDtlSvcMonth);
    query.setInteger("nbrAdminDtlCsli", nbrAdminDtlCsli);
    query.setInteger("yrAdminDtlSvcYear", yrAdminDtlSvcYear);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setString("cdCounty", cdCounty);
    query.setDouble("amtPromotional", amtPromotional);
    query.setString("txtComments", txtComments);
    return query.executeUpdate();
  }

  public int insertAdminDtl(int idAdminDtl, Date lastUpdate, int idInvoInvoice, double amtAdminDtlAdminAlloc,
                            double amtAdminDtlEquipment, double amtAdminDtlFrgBenft, double amtAdminDtlOffsetItem,
                            double amtAdminDtlOther, double amtAdminDtlSalaries, double amtAdminDtlSupplies,
                            double amtAdminDtlTravel, String cdAdminDtlService, String cdAdminDtlInvoDisptn,
                            String cdAdminDtlLiType, String indAdminDtlRejItm, int moAdminDtlSvcMonth,
                            int nbrAdminDtlCsli, int yrAdminDtlSvcYear, String cdCounty, double amtAdminDtlPromotional,
                            String txtComments) {
    SQLQuery query = getSession().createSQLQuery(" INSERT INTO ADMIN_DTL (ID_ADMIN_DTL, " +
                                                 "                        DT_LAST_UPDATE, " +
                                                 "                        ID_INVOICE, " +
                                                 "                        AMT_ADMIN_DTL_ADMIN_ALLOC, " +
                                                 "                        AMT_ADMIN_DTL_EQUIPMENT, " +
                                                 "                        AMT_ADMIN_DTL_FRG_BENFT, " +
                                                 "                        AMT_ADMIN_DTL_OFFSET_ITEM, " +
                                                 "                        AMT_ADMIN_DTL_OTHER, " +
                                                 "                        AMT_ADMIN_DTL_SALARIES, " +
                                                 "                        AMT_ADMIN_DTL_SUPPLIES, " +
                                                 "                        AMT_ADMIN_DTL_TRAVEL, " +
                                                 "                        CD_ADMIN_DTL_SERVICE, " +
                                                 "                        CD_ADMIN_DTL_INVO_DISPTN, " +
                                                 "                        CD_ADMIN_DTL_LI_TYPE, " +
                                                 "                        IND_ADMIN_DTL_REJ_ITM, " +
                                                 "                        MO_ADMIN_DTL_SVC_MONTH, " +
                                                 "                        NBR_ADMIN_DTL_CSLI, " +
                                                 "                        YR_ADMIN_DTL_SVC_YEAR," +
                                                 "                        CD_ON_CALL_COUNTY," +
                                                 "                        AMT_ADMIN_DTL_PROMOTIONAL," +
                                                 "                        TXT_COMMENTS )  " +
                                                 "      VALUES(:idAdminDtl, " +
                                                 "             :lastUpdate, " +
                                                 "             :idInvoInvoice, " +
                                                 "             :amtAdminDtlAdminAlloc, " +
                                                 "             :amtAdminDtlEquipment, " +
                                                 "             :amtAdminDtlFrgBenft, " +
                                                 "             :amtAdminDtlOffsetItem, " +
                                                 "             :amtAdminDtlOther, " +
                                                 "             :amtAdminDtlSalaries, " +
                                                 "             :amtAdminDtlSupplies, " +
                                                 "             :amtAdminDtlTravel, " +
                                                 "             :cdAdminDtlService, " +
                                                 "             :cdAdminDtlInvoDisptn, " +
                                                 "             :cdAdminDtlLiType, " +
                                                 "             :indAdminDtlRejItm, " +
                                                 "             :moAdminDtlSvcMonth, " +
                                                 "             :nbrAdminDtlCsli, " +
                                                 "             :yrAdminDtlSvcYear," +
                                                 "             :cdCounty," +
                                                 "             :amtAdmDtlPromotional," +
                                                 "             :txtComments )");
    query.setInteger("idAdminDtl", idAdminDtl);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setInteger("idInvoInvoice", idInvoInvoice);
    query.setDouble("amtAdminDtlAdminAlloc", amtAdminDtlAdminAlloc);
    query.setDouble("amtAdminDtlEquipment", amtAdminDtlEquipment);
    query.setDouble("amtAdminDtlFrgBenft", amtAdminDtlFrgBenft);
    query.setDouble("amtAdminDtlOffsetItem", amtAdminDtlOffsetItem);
    query.setDouble("amtAdminDtlOther", amtAdminDtlOther);
    query.setDouble("amtAdminDtlSalaries", amtAdminDtlSalaries);
    query.setDouble("amtAdminDtlSupplies", amtAdminDtlSupplies);
    query.setDouble("amtAdminDtlTravel", amtAdminDtlTravel);
    query.setString("cdAdminDtlService", cdAdminDtlService);
    query.setString("cdAdminDtlInvoDisptn", cdAdminDtlInvoDisptn);
    query.setString("cdAdminDtlLiType", cdAdminDtlLiType);
    query.setString("indAdminDtlRejItm", indAdminDtlRejItm);
    query.setInteger("moAdminDtlSvcMonth", moAdminDtlSvcMonth);
    query.setInteger("nbrAdminDtlCsli", nbrAdminDtlCsli);
    query.setInteger("yrAdminDtlSvcYear", yrAdminDtlSvcYear);
    query.setString("cdCounty", cdCounty);
    query.setDouble("amtAdmDtlPromotional", amtAdminDtlPromotional);
    query.setString("txtComments", txtComments);
    return query.executeUpdate();
  }

  public AdminDtl findAdminDtlByInvoiceIdnIdAdminDtl(int idAdminDtl, int idInvoice) {
    Query query = getSession().createQuery(" from AdminDtl adl " +
                                           "where adl.idAdminDtl = :idAdminDtl " +
                                           "  and adl.invoice.idInvoice = :idInvoice ");
    query.setInteger("idAdminDtl", idAdminDtl);
    query.setInteger("idInvoice", idInvoice);
    return (AdminDtl) firstResult(query);
  }

  public void saveAdminDtl(AdminDtl adminDtl) {
    getSession().saveOrUpdate(adminDtl);
  }

}