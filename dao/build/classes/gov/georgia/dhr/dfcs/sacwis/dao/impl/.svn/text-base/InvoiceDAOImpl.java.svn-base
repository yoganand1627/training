package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdminDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;

import java.util.Date;

import org.hibernate.Query;

public class InvoiceDAOImpl extends BaseDAOImpl implements InvoiceDAO {
  public Invoice findInvoiceContractResourceIdInvoice(int idInvoice) {
    Query query = getSession().createQuery("      from Invoice i " +
                                           "join fetch i.contract " +
                                           "join fetch i.contract.capsResource " +
                                           "     where i.idInvoice =  :idInvoice");
    query.setInteger("idInvoice", idInvoice);
    return (Invoice) firstResult(query);
  }
  
  public Invoice findInvoiceByInvoiceId(int idInvoice){
    Query query = getSession().createQuery( " from Invoice inv " +
                                            " where inv.idInvoice = :idInvoice ");
    query.setInteger("idInvoice", idInvoice);
    return (Invoice)firstResult(query);
  }
  
  public String findCdInvoTypeByInvoiceId(int idInvoice){
    Query query = getSession().createQuery( " select inv.cdInvoType from Invoice inv " +
                                            " where inv.idInvoice = :idInvoice ");
    query.setInteger("idInvoice", idInvoice);
    return (String)firstResult(query);
  }
  
  

  public Date findInvoiceDtInvoEntryCompletedByIdInvoice(int idInvoice) {
    Query query = getSession().createQuery("select dtInvoEntryCompleted " +
                                           "  from Invoice " +
                                           " where idInvoice = :idInvoice");
    query.setInteger("idInvoice", idInvoice);
    return (Date) firstResult(query);
  }

  public Date findInvoiceDtLastUpdate(int idInvoice) {
    Query query = getSession().createQuery("select dtLastUpdate " +
                                           "   from Invoice " +
                                           "  where idInvoice = :idInvoice");
    query.setInteger("idInvoice", idInvoice);
    return (Date) firstResult(query);
  }
  
  public Long countPaidInvoicesByIdPerson(int idChild) {
    Query query = getSession().createQuery("select count(*) from Invoice i,DelvrdSvcDtl dsd " +
                                           " where i.idInvoice = dsd.invoice.idInvoice " +
                                           " and dsd.person.idPerson = :idChild " +
                                           " and i.cdInvoPhase in ('PAD', 'SBT') " +
                                           " and i.cdInvoType = 'FSC' " +
                                           " and substr(dsd.cdSvcDtlService,4,2) in ('01', '60', 'W1', 'W2') " +
                                           " and substr(dsd.cdSvcDtlService,1,3) <>'460' " +
                                           " and (dsd.cdSvcDtlInvoDisptn is null or dsd.cdSvcDtlInvoDisptn <> 'RV')");
    query.setInteger("idChild", idChild);
    return (Long) query.uniqueResult();
  }

  public int updateInvoice(int idInvoInvoice, String cdInvoPhase, Date lastUpdate) {
    Query query = getSession().createQuery(" update Invoice " +
                                           "    set idInvoice = :idInvoInvoice, " +
                                           "        cdInvoPhase = :cdInvoPhase, " +
                                           "        indInvoReadyForValid = '" + CodesTables.CINVACAN_Y + "' " +
                                           "  where dtLastUpdate = :lastUpdate " +
                                           "    and idInvoice = :idInvoInvoice ");
    query.setInteger("idInvoInvoice", idInvoInvoice);
    query.setString("cdInvoPhase", cdInvoPhase);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  public int updateInvoiceSetIdInvoiceAndCdInvoPhase(int idInvoInvoice, String cdInvoPhase, Date lastUpdate) {
    Query query = getSession().createQuery(" update Invoice " +
                                           "    set idInvoice = :idInvoInvoice, " +
                                           "        cdInvoPhase = :cdInvoPhase " +
                                           "  where dtLastUpdate = :lastUpdate " +
                                           "    and idInvoice = :idInvoInvoice ");
    query.setInteger("idInvoInvoice", idInvoInvoice);
    query.setString("cdInvoPhase", cdInvoPhase);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  public int updateInvoiceNbrInvoVid(String nbrRsrcAddrVid, int idRsrcAddress) {
    Query query = getSession().createQuery("update Invoice inv " +
                                           "   set inv.nbrInvoVid = :nbrRsrcAddrVid " +
                                           " where inv.cdInvoPhase in ('prb', 'vlp', 'vwo', 'vwi') " +
                                           "   and inv.contract.idContract in " +
                                           "       (select con.idContract " +
                                           "          from Contract con " +
                                           "         where con.resourceAddress.idRsrcAddress = :idRsrcAddress)");
    query.setString("nbrRsrcAddrVid", nbrRsrcAddrVid);
    query.setInteger("idRsrcAddress", idRsrcAddress);
    return query.executeUpdate();
  }

  public void saveOrUpdate(Invoice invoice){
    getSession().saveOrUpdate(invoice);
  }

  public void deleteInvoice(Invoice invoice) {
    getSession().delete(invoice);
  }
}
