package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * 
 * 
 * <pre>
 *    Change History:
 *    Date      User      Description
 *    --------  --------  --------------------------------------------------
 *   04/09/2009 bgehlot   STGAP00013273: Added the method findSvcAuthDtlByIdInvoice
 *                        
 * </pre>
 */

public class DelvrdSvcDtlDAOImpl extends BaseDAOImpl implements DelvrdSvcDtlDAO {
  
  public DelvrdSvcDtl findDelvrdSvcDtlByPrimaryKey(int idSvcDtl) {
    Query query = getSession().createQuery("from DelvrdSvcDtl dsd where dsd.idSvcDtl = :idSvcDtl");
    query.setInteger("idSvcDtl", idSvcDtl);
    return (DelvrdSvcDtl) query.uniqueResult();
  }
  
  public DelvrdSvcDtl findDelvrdSvcDtl(int idInvoice) {
    Query query = getSession().createQuery(" from DelvrdSvcDtl d " +
                                           "where d.invoice.idInvoice = :idInvoice " +
                                           "  and d.delvrdSvcDtl.idSvcDtl is not null " +
                                           "  and (d.nbrSvcDtlUnitQty = '0' " +
                                           "       or (d.nbrSvcDtlFromDay = '0' or d.nbrSvcDtlFromDay is null) " +
                                           "      and (d.nbrSvcDtlToDay = '0' or d.nbrSvcDtlToDay is null ))");
    query.setInteger("idInvoice", idInvoice);
    return (DelvrdSvcDtl) firstResult(query);
  }

  public long countDelvrdSvcDtlByIdInvoiceCdSvcDtlLiType(int idInvoice, String cdSvcDtlLiType) {
    Query query = getSession().createQuery(" select count(*) " +
                                           "   from DelvrdSvcDtl d " +
                                           "  where d.invoice.idInvoice = :idInvoice " +
                                           "    and d.cdSvcDtlLiType = :cdSvcDtlLiType ");

    query.setInteger("idInvoice", idInvoice);
    query.setString("cdSvcDtlLiType", cdSvcDtlLiType);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findDelvrdSvcDtlByIdInvoiceCdCnsvcPaymentType(int idInvoice, String cdCnsvcPaymentType) {
    Query query = getSession().createQuery("  select distinct new map(b.nbrSvcDtlCsli as nbrSvcDtlCsli, " +
                                           "                   sum(nvl(b.nbrSvcDtlUnitQty, " +
                                           "                           0)) as nbrSvcDtlUnitQty, " +
                                           "                   b.cdSvcDtlLiType as cdSvcDtlLiType, " +
                                           "                   b.cdSvcDtlService as cdSvcDtlService, " +
                                           "                   sum(nvl(b.amtSvcDtlFeePaid, " +
                                           "                           0)) as amtSvcDtlFeePaid) " +
                                           "     from DelvrdSvcDtl b, " +
                                           "          ContractService c " +
                                           "    where b.invoice.idInvoice = :idInvoice " +
                                           "      and b.invoice.contract.idContract = c.contract.idContract " +
                                           "      and c.nbrCnsvcPeriod = (select max(c3.nbrCnsvcPeriod) " +
                                           "                                from ContractService c3 " +
                                           "                               where c3.contract.idContract = b.invoice.contract.idContract " +

                                           "                                 and c3.nbrCnsvcLineItem = b.nbrSvcDtlCsli) " +
                                           "      and c.nbrCnsvcVersion = (select max(c2.nbrCnsvcVersion) " +
                                           "                                 from ContractService c2 " +
                                           "                                where c2.contract.idContract = b.invoice.contract.idContract " +
                                           "                                  and c2.nbrCnsvcPeriod = c.nbrCnsvcPeriod " +
                                           "                                  and c2.nbrCnsvcLineItem = b.nbrSvcDtlCsli) " +
                                           "      and c.nbrCnsvcLineItem = b.nbrSvcDtlCsli " +
                                           "      and c.cdCnsvcPaymentType = :cdCnsvcPaymentType " +
                                           " group by b.nbrSvcDtlCsli, " +
                                           "          b.cdSvcDtlService, " +
                                           "          b.cdSvcDtlLiType " +
                                           " order by b.nbrSvcDtlCsli, " +
                                           "          b.cdSvcDtlLiType ");

    query.setInteger("idInvoice", idInvoice);
    query.setString("cdCnsvcPaymentType", cdCnsvcPaymentType);

    return (List<Map>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findIdSvcAuthDtl(int idPerson, int moSvcDtlSvcMonth, int yrSvcDtlServiceYear,
                                  String cdSvcDtlCounty, String cdSvcDtlService) {
    Query query = getSession().createQuery("select dsa.svcAuthDetail.idSvcAuthDtl " +
                                           "  from DelvrdSvcDtl dsa, " +
                                           "       Invoice inv " +
                                           " where dsa.person.idPerson = :idPerson " +
                                           "   and dsa.moSvcDtlSvcMonth = :moSvcDtlSvcMonth " +
                                           "   and dsa.yrSvcDtlSvcYear = :yrSvcDtlServiceYear " +
                                           "   and (dsa.indSvcDtlRejItem = 'N' " +
                                           "        or dsa.indSvcDtlRejItem is null) " +
                                           "   and dsa.cdSvcDtlService = :cdSvcDtlService " +
                                           "   and dsa.cdSvcDtlCounty = :cdSvcDtlCounty " +
                                           "   and dsa.nbrSvcDtlUnitQty > 0 " +
                                           "   and inv.cdInvoPhase not in ('NSB', 'PAD', 'SBT') " +
                                           "   and inv.idInvoice = dsa.invoice.idInvoice");
    query.setInteger("idPerson", idPerson);
    query.setInteger("moSvcDtlSvcMonth", moSvcDtlSvcMonth);
    query.setInteger("yrSvcDtlServiceYear", yrSvcDtlServiceYear);
    query.setString("cdSvcDtlCounty", cdSvcDtlCounty);
    query.setString("cdSvcDtlService", cdSvcDtlService);
    return (List<Integer>) query.list();
  }

  // -- This method is for Foster Care invoice line items (no county, no idSvcAuthDtl)
  public int insertDelvrdSvcDtl(Date lastUpdate, int idInvoInvoice, int idPerson, int idResource,
                                double amtSvcDtlFeePaid, double amtSvcDtlIncome, double amtSvcDtlUnitRate,
                                String cdSvcDtlInvoDisptn, String cdSvcDtlLiType, String cdSvcDtlService,
                                String cdSvcDtlUnitType, String indSvcDtlRejItem, int moSvcDtlSvcMonth,
                                int nbrSvcDtlCsli, int nbrSvcDtlFromDay, int nbrSvcDtlToDay, double nbrSvcDtlUnitQty,
                                int yrSvcDtlServiceYear) {
    SQLQuery query = getSession().createSQLQuery(" INSERT INTO DELVRD_SVC_DTL " +
                                                 "            (ID_SVC_DTL, " +
                                                 "             DT_LAST_UPDATE, " +
                                                 "             ID_INVOICE, " +
                                                 "             ID_SVC_DTL_PERSON, " +
                                                 "             ID_RESOURCE, " +
                                                 "             AMT_SVC_DTL_FEE_PAID, " +
                                                 "             AMT_SVC_DTL_INCOME, " +
                                                 "             AMT_SVC_DTL_UNIT_RATE, " +
                                                 "             CD_SVC_DTL_INVO_DISPTN, " +
                                                 "             CD_SVC_DTL_LI_TYPE, " +
                                                 "             CD_SVC_DTL_SERVICE, " +
                                                 "             CD_SVC_DTL_UNIT_TYPE, " +
                                                 "             IND_SVC_DTL_REJ_ITEM, " +
                                                 "             MO_SVC_DTL_SVC_MONTH, " +
                                                 "             NBR_SVC_DTL_CSLI, " +
                                                 "             NBR_SVC_DTL_FROM_DAY, " +
                                                 "             NBR_SVC_DTL_TO_DAY, " +
                                                 "             NBR_SVC_DTL_UNIT_QTY, " +
                                                 "             YR_SVC_DTL_SVC_YEAR)   " +
                                                 "      VALUES(SEQ_DELVRD_SVC_DTL.NEXTVAL, " +
                                                 "             :lastUpdate, " +
                                                 "             :idInvoInvoice, " +
                                                 "             :idPerson, " +
                                                 "             :idResource, " +
                                                 "             :amtSvcDtlFeePaid, " +
                                                 "             :amtSvcDtlIncome, " +
                                                 "             :amtSvcDtlUnitRate, " +
                                                 "             :cdSvcDtlInvoDisptn, " +
                                                 "             :cdSvcDtlLiType, " +
                                                 "             :cdSvcDtlService, " +
                                                 "             :cdSvcDtlUnitType, " +
                                                 "             :indSvcDtlRejItem, " +
                                                 "             :moSvcDtlSvcMonth, " +
                                                 "             :nbrSvcDtlCsli, " +
                                                 "             :nbrSvcDtlFromDay, " +
                                                 "             :nbrSvcDtlToDay, " +
                                                 "             :nbrSvcDtlUnitQty, " +
                                                 "             :yrSvcDtlServiceYear )");
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setInteger("idInvoInvoice", idInvoInvoice);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idResource", idResource);
    query.setDouble("amtSvcDtlFeePaid", amtSvcDtlFeePaid);
    query.setDouble("amtSvcDtlIncome", amtSvcDtlIncome);
    query.setDouble("amtSvcDtlUnitRate", amtSvcDtlUnitRate);
    query.setString("cdSvcDtlInvoDisptn", cdSvcDtlInvoDisptn);
    query.setString("cdSvcDtlLiType", cdSvcDtlLiType);
    query.setString("cdSvcDtlService", cdSvcDtlService);
    query.setString("cdSvcDtlUnitType", cdSvcDtlUnitType);
    query.setString("indSvcDtlRejItem", indSvcDtlRejItem);
    query.setInteger("moSvcDtlSvcMonth", moSvcDtlSvcMonth);
    query.setInteger("nbrSvcDtlCsli", nbrSvcDtlCsli);
    query.setInteger("nbrSvcDtlFromDay", nbrSvcDtlFromDay);
    query.setInteger("nbrSvcDtlToDay", nbrSvcDtlToDay);
    query.setDouble("nbrSvcDtlUnitQty", nbrSvcDtlUnitQty);
    query.setInteger("yrSvcDtlServiceYear", yrSvcDtlServiceYear);
    return query.executeUpdate();
  }

  //-- abgoode 3/2/2007: removed idSvcAuthDtl from query
  public int updateDelvrdSvcDtl(int idSvcDtl, int idInvoInvoice, int idPerson, int idResource, //int idSvcAuthDtl,
                                double amtSvcDtlFeePaid, double amtSvcDtlIncome, double amtSvcDtlUnitRate,
                                String cdSvcDtlInvoDisptn, String cdSvcDtlLiType, String cdSvcDtlService,
                                String cdSvcDtlUnitType, String indSvcDtlRejItem, int moSvcDtlSvcMonth,
                                int nbrSvcDtlCsli, int nbrSvcDtlFromDay, int nbrSvcDtlToDay, double nbrSvcDtlUnitQty,
                                int yrSvcDtlServiceYear, Date dtLastUpdate) {
    Query query = getSession().createQuery(" update DelvrdSvcDtl d " +
                                           "    set d.idSvcDtl = :idSvcDtl, " +
                                           "        d.invoice.idInvoice = :idInvoInvoice, " +
                                           "        d.person.idPerson = :idPerson, " +
                                           "        d.capsResource.idResource = :idResource, " +
                                           //"        d.svcAuthDetail.idSvcAuthDtl = :idSvcAuthDtl, " +
                                           "        d.amtSvcDtlFeePaid = :amtSvcDtlFeePaid, " +
                                           "        d.amtSvcDtlIncome = :amtSvcDtlIncome, " +
                                           "        d.amtSvcDtlUnitRate = :amtSvcDtlUnitRate, " +
                                           "        d.cdSvcDtlInvoDisptn = :cdSvcDtlInvoDisptn, " +
                                           "        d.cdSvcDtlLiType = :cdSvcDtlLiType, " +
                                           "        d.cdSvcDtlService = :cdSvcDtlService, " +
                                           "        d.cdSvcDtlUnitType = :cdSvcDtlUnitType, " +
                                           "        d.indSvcDtlRejItem = :indSvcDtlRejItem, " +
                                           "        d.moSvcDtlSvcMonth = :moSvcDtlSvcMonth, " +
                                           "        d.nbrSvcDtlCsli = :nbrSvcDtlCsli, " +
                                           "        d.nbrSvcDtlFromDay = :nbrSvcDtlFromDay, " +
                                           "        d.nbrSvcDtlToDay = :nbrSvcDtlToDay, " +
                                           "        d.nbrSvcDtlUnitQty = :nbrSvcDtlUnitQty, " +
                                           "        d.yrSvcDtlSvcYear = :yrSvcDtlServiceYear " +
                                           "  where d.dtLastUpdate = :dtLastUpdate " +
                                           "    and d.idSvcDtl = :idSvcDtl ");
    query.setInteger("idSvcDtl", idSvcDtl);
    query.setInteger("idInvoInvoice", idInvoInvoice);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idResource", idResource);
    //query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    query.setDouble("amtSvcDtlFeePaid", amtSvcDtlFeePaid);
    query.setDouble("amtSvcDtlIncome", amtSvcDtlIncome);
    query.setDouble("amtSvcDtlUnitRate", amtSvcDtlUnitRate);
    query.setString("cdSvcDtlInvoDisptn", cdSvcDtlInvoDisptn);
    query.setString("cdSvcDtlLiType", cdSvcDtlLiType);
    query.setString("cdSvcDtlService", cdSvcDtlService);
    query.setString("cdSvcDtlUnitType", cdSvcDtlUnitType);
    query.setString("indSvcDtlRejItem", indSvcDtlRejItem);
    query.setInteger("moSvcDtlSvcMonth", moSvcDtlSvcMonth);
    query.setInteger("nbrSvcDtlCsli", nbrSvcDtlCsli);
    query.setInteger("nbrSvcDtlFromDay", nbrSvcDtlFromDay);
    query.setInteger("nbrSvcDtlToDay", nbrSvcDtlToDay);
    query.setDouble("nbrSvcDtlUnitQty", nbrSvcDtlUnitQty);
    query.setInteger("yrSvcDtlServiceYear", yrSvcDtlServiceYear);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int updateDelvrdSvcDtlCdSvcDtlInvoDisptn(int idSvcDtlRevrsalOrig) {
    Query query = getSession().createQuery(" update DelvrdSvcDtl d " +
                                           "    set d.cdSvcDtlInvoDisptn = null " +
                                           "  where d.idSvcDtl = :idSvcDtlRevrsalOrig");
    query.setInteger("idSvcDtlRevrsalOrig", idSvcDtlRevrsalOrig);
    return query.executeUpdate();
  }

  public int updateDelvrdSvcDtlIdSvcDtlRevrsalOrig(int idSvcDtlRevrsalOrig) {
    Query query = getSession().createQuery("update DelvrdSvcDtl d" +
                                           "   set d.delvrdSvcDtl = null " +
                                           " where d.delvrdSvcDtl.idSvcDtl = :idSvcDtlRevrsalOrig");
    query.setInteger("idSvcDtlRevrsalOrig", idSvcDtlRevrsalOrig);
    return query.executeUpdate();
  }

  public int updateDelvrdSvcDtlamtSvcDtlUnitRate(double amtSvcDtlUnitRate, int idInvoice, int nbrSvcDtlCsli,
                                                 String cdSvcDtlLiType, Date tsLastUpdate) {
    Query query = getSession().createQuery(" update DelvrdSvcDtl d " +
                                           "    set d.amtSvcDtlUnitRate = :amtSvcDtlUnitRate " +
                                           "  where d.invoice.idInvoice = :idInvoice " +
                                           "    and d.nbrSvcDtlCsli = :nbrSvcDtlCsli " +
                                           "    and d.cdSvcDtlLiType = :cdSvcDtlLiType " +
                                           "    and :tsLastUpdate >= (select (b.dtLastUpdate) " +
                                           "                            from Invoice b " +
                                           "                           where b.idInvoice = :idInvoice)");
    query.setDouble("amtSvcDtlUnitRate", amtSvcDtlUnitRate);
    query.setInteger("idInvoice", idInvoice);
    query.setInteger("nbrSvcDtlCsli", nbrSvcDtlCsli);
    query.setString("cdSvcDtlLiType", cdSvcDtlLiType);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);

    return query.executeUpdate();
  }
  
  public int updateDelvrdSvcDtlAsPaid(int idSvcDtl, int nbrCheck, double amtSmilePaid, Date dtPaid) {
    Query query = getSession().createQuery("update DelvrdSvcDtl dsd " +
                                           "   set dsd.nbrCheck = :nbrCheck, " +
                                           "       dsd.amtSmilePaid = :amtSmilePaid, " +
                                           "       dsd.dtPaid = :dtPaid " +
                                           " where dsd.idSvcDtl = :idSvcDtl");
    query.setInteger("nbrCheck", nbrCheck);
    query.setDouble("amtSmilePaid", amtSmilePaid);
    query.setDate("dtPaid", dtPaid);
    query.setInteger("idSvcDtl", idSvcDtl);
    return query.executeUpdate();
  }

  public void deleteDelvrdSvcDtl(DelvrdSvcDtl delvrdSvcDtl) {
    getSession().delete(delvrdSvcDtl);
  }
  
  public void saveDelvrdSvcDtl(DelvrdSvcDtl delvrdSvcDtl) {
    getSession().saveOrUpdate(delvrdSvcDtl);
  }
  
  public DelvrdSvcDtl findDelvrdSvcDtlByInvoiceIdnIdSvcDtl(int idSvcDtl,int idInvoice){
    Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                            " where sdl.idSvcDtl = :idSvcDtl and " + 
                                            " sdl.invoice.idInvoice = :idInvoice ");
      query.setInteger("idSvcDtl", idSvcDtl);
      query.setInteger("idInvoice", idInvoice);
      return (DelvrdSvcDtl)firstResult(query);
}
  //STGAP00006330: CR - 14 
  @SuppressWarnings({"unchecked"})
  public List<DelvrdSvcDtl> findIdSvcAuthDtlByIdInvoice(int idInvoice){
    Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                            " where sdl.invoice.idInvoice = :idInvoice " +
                                            " and sdl.svcAuthDetail.idSvcAuthDtl is not null");
      query.setInteger("idInvoice", idInvoice);
      return (List<DelvrdSvcDtl>) query.list();
  }    
  //STGAP00007737: Added this sql to retrieve any delivered services that are linked
  //to the given SeviceAuthDetail Id.
  @SuppressWarnings({"unchecked"})
  public List<DelvrdSvcDtl> findDlvrdDtlByIdSvcAuth(int idSvcAuthDtl){
   Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                                " where sdl.svcAuthDetail.idSvcAuthDtl = :idSvcAuthDtl");
    query.setInteger("idSvcAuthDtl", idSvcAuthDtl);
    return (List<DelvrdSvcDtl>) query.list();
}
  //STGAP00007737: The next 4 sqls are defined to be used in the validation of
  //the Person Id, Resource Id, To and From date fields on the Invoice line items 
  //and the per-diem services.
  @SuppressWarnings({"unchecked"})
  public List<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoiceAndIdPerson(int idInvoice, int idPerson){
    Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                            " where sdl.invoice.idInvoice = :idInvoice " +
                                            " and sdl.person.idPerson<>:idPerson ");
      query.setInteger("idInvoice", idInvoice);
      query.setInteger("idPerson", idPerson);
      return (List<DelvrdSvcDtl>) query.list();
  } 
  @SuppressWarnings({"unchecked"})
  public List<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoiceAndIdResource(int idInvoice, int idResource){
    Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                            " where sdl.invoice.idInvoice = :idInvoice " +
                                            " and sdl.capsResource.idResource<>:idResource ");
      query.setInteger("idInvoice", idInvoice);
      query.setInteger("idResource", idResource);
      return (List<DelvrdSvcDtl>) query.list();
  } 
  
  @SuppressWarnings({"unchecked"})
  public List<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoiceAndToDay(int idInvoice, int toDay, int fromDay){
    Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                            " where sdl.invoice.idInvoice = :idInvoice " +
                                            " and (sdl.nbrSvcDtlToDay <>:toDay " +
                                            " or sdl.nbrSvcDtlFromDay <>:fromDay ) ");
      query.setInteger("idInvoice", idInvoice);
      query.setInteger("toDay", toDay);
      query.setInteger("fromDay", fromDay);
      return (List<DelvrdSvcDtl>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoiceAndToDayAndCdSvcDtlService(int idInvoice, int toDay, int fromDay, int idSvcDtl){
    Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                            " where sdl.invoice.idInvoice = :idInvoice " +
                                            " and (sdl.nbrSvcDtlToDay <>:toDay " +
                                            " or sdl.nbrSvcDtlFromDay <>:fromDay ) " +
                                            " and sdl.idSvcDtl <> :idSvcDtl " +
                                            " and sdl.cdSvcDtlService in ('25201', '45001', '50101', '50102','50201', '50202', '50301', " +
                                            " '50302', '52901', '56001', '56002', '57401', '57402', '57499', '57501', '57502', '57599', '57701', '57702', " +
                                            " '57799', '60501',  '60501a', '60501b', '60501c', '60501d', '60501e', '60501f', '60501g', '60501h', '60501i'," +
                                            " '60501j', '60501k', '60501l', '60501m', '60501n', '60601', '60601a', '60601b', '60601c', '60601d', " +
                                            " '60601e', '60601f', '60601g', '60601h', '60601i', '60601j', '60601k', '60601l', '60601m', '60601n', " +
                                            " '60701', '60701a', '60701b', '60701c', '60701d', '60701e', '60701f', '60701g', '60701h', '60701i', '60701j', " +
                                            " '60701k', '60701l', '60701m', '60701n', '60801', '60801a', '60801b', '60801c', '60801d', '60801e', '60801f', " +
                                            " '60801g', '60801h', '60801i', '60801j', '60801k', '60801la', '60801m', '60801n', " +
                                            " '60901', '60901a', '60901b', '60901c', '60901d', '60901e', '60901f', '60901g', '60901h', '60901i', '60901j', " +
                                            " '60101', '60101a', '60101b', '60101c', '60101d', '60101e', '60101f', '60101g', '60101h', '60101i', '60101j', " +
                                            " '61001', '61001a', '61001b', '61001c', '61001d', '61001e', '61001f', '61001g', '61001h', '61001i', '61001j', " +
                                            " '61101', '61101a', '61101b', '61101c', '61101d', '61101e', '61101f', '61101g', '61101h', '61101i', '61101j', " +
                                            " '61201', '61201a', '61201b', '61201c', '61201d', '61201e', '61201f', '61201g', '61201h', '61201i', '61201j', " +
                                            " '61201k', '61201l', '61201m', '61201n', '61301', '61301a', '61301b', '61301c', '61301d', '61301e', '61301f', " +
                                            " '61301g', '61301h', '61301i', '61301j', '61401', '61401a', '61401b', '61401c', '61401d', '61401e', '61401f', " +
                                            " '61401g', '61401h', '61401i', '61401j', '61501', '61501a', '61501b', '61501c', '61501d', '61501e', '61501f', " +
                                            " '61501g', '61501h', '61501i', '61501j', '61501k', '61501l', '61501m', '61501n', '61601', '61601a', '61601b', " +
                                            " '61601c', '61601d', '61601e', '61601f', '61601g', '61601h', '61601i', '61601j')");
      query.setInteger("idInvoice", idInvoice);
      query.setInteger("toDay", toDay);
      query.setInteger("fromDay", fromDay);
      query.setInteger("idSvcDtl", idSvcDtl);
      return (List<DelvrdSvcDtl>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<DelvrdSvcDtl> findDlvrdDtlByIdInvoice(int idInvoice, Collection<String> restrictedFundList){
   Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                                " where sdl.invoice.idInvoice = :idInvoice" +
                                                " and sdl.cdSvcDtlService in (:restrictedFundList)" +
                                                " and sdl.nbrSvcDtlUnitQty is not null " +
                                                " and sdl.nbrSvcDtlUnitQty <> 0 " +
                                                " and sdl.amtSvcDtlUnitRate is not null " +
                                                " and sdl.amtSvcDtlUnitRate <> 0 ");
    query.setInteger("idInvoice", idInvoice);
    query.setParameterList("restrictedFundList", restrictedFundList);
    return (List<DelvrdSvcDtl>) query.list();
}
  
  //STGAP00013273: Added this method to retrieve Service
  @SuppressWarnings({"unchecked"})
  public List<DelvrdSvcDtl> findSvcAuthDtlByIdInvoice(int idInvoice){
    Query query = getSession().createQuery( " from DelvrdSvcDtl sdl " +
                                            " where sdl.invoice.idInvoice = :idInvoice " );
      query.setInteger("idInvoice", idInvoice);
      return (List<DelvrdSvcDtl>) query.list();
  } 
  
}
  
