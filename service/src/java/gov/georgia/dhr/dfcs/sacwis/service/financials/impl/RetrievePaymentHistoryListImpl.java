package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicDelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicInvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrievePaymentHistoryList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00_ARRAY;

import java.util.Date;
import java.util.Iterator;

public class RetrievePaymentHistoryListImpl extends BaseServiceImpl implements RetrievePaymentHistoryList {

  private CapsResourceDAO capsResourceDAO = null;
  private ContractDAO contractDAO = null;
  private DynamicDelvrdSvcDtlDAO dynamicDelvrdSvcDtlDAO = null;
  private DynamicInvoiceDAO dynamicInvoiceDAO = null;
  private PersonDAO personDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setDynamicDelvrdSvcDtlDAO(DynamicDelvrdSvcDtlDAO dynamicDelvrdSvcDtlDAO) {
    this.dynamicDelvrdSvcDtlDAO = dynamicDelvrdSvcDtlDAO;
  }
  
  public void setDynamicInvoiceDAO(DynamicInvoiceDAO dynamicInvoiceDAO) {
    this.dynamicInvoiceDAO = dynamicInvoiceDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public CFIN21SO retrievePaymentHistoryList(CFIN21SI cfin21si) throws ServiceException {

    CFIN21SO cfin21so = new CFIN21SO();
    ArchOutputStruct aos = new ArchOutputStruct();
    int ulScrFinPayhistId = cfin21si.getUlScrFinPayhistId();
    Date dtPayhistFrom = DateHelper.toJavaDate(cfin21si.getDtScrNbrFinPayhistFrom());
    Date dtPayhistTo = DateHelper.toJavaDate(cfin21si.getDtScrDtFinPayhistTo());
    String region = cfin21si.getSzCdRegion();
    String county = cfin21si.getSzCdCounty();
    
    int pageNbr = cfin21si.getArchInputStruct().getUsPageNbr();
    int pageSize = cfin21si.getArchInputStruct().getUlPageSizeNbr();
    
    double grandTotal = 0.00;
    String bMoreDataInd = "N";
    if (ZERO.equals(cfin21si.getSzScrFinPayhistSearch())) {
      // ccmn44d
      Person person = personDAO.findPersonByIdPerson(ulScrFinPayhistId);

      if (person == null) {
        throw new ServiceException(Messages.MSG_FIN_INVALID_PRSN_ID);
      }
      cfin21so.setSzNmPersonFull(person.getNmPersonFull());
      
      // Retrieve CLIENT's Payment History
      // clss34d
      PaginatedHibernateList<DelvrdSvcDtl> list = dynamicDelvrdSvcDtlDAO.findDelvrdSvcDtlByIdPerson(ulScrFinPayhistId, dtPayhistFrom,
                                                                          dtPayhistTo, region, county, pageNbr, pageSize);
      ROWCFIN21SOG00_ARRAY rowcfin21sog00_array = new ROWCFIN21SOG00_ARRAY();
      int ulRowQty = 0;
      if (list != null) {
        // Set fields in CFIN21SO to fields in CLSS34DO
        for (Iterator<DelvrdSvcDtl> it = list.iterator(); it.hasNext();) {
          DelvrdSvcDtl dsd = it.next();
          ROWCFIN21SOG00 rowcfin21sog00 = new ROWCFIN21SOG00();
          
          Invoice invoice = dsd.getInvoice();
          rowcfin21sog00.setUlIdInvoInvoice(getIntSafe(invoice.getIdInvoice()));
          rowcfin21sog00.setDtDtInvoWarrantDate(DateHelper.toCastorDate(invoice.getDtInvoWarrantDate()));
          rowcfin21sog00.setSzNmResource(dsd.getCapsResource() != null ? dsd.getCapsResource().getNmResource() : "");
          rowcfin21sog00.setSzCdSvcDtlService(dsd.getCdSvcDtlService());
          rowcfin21sog00.setSzCdSvcDtlUnitType(dsd.getCdSvcDtlUnitType());
          rowcfin21sog00.setSNbrSvcDtlFromDay(getIntSafe(dsd.getNbrSvcDtlFromDay()));
          rowcfin21sog00.setSNbrSvcDtlToDay(getIntSafe(dsd.getNbrSvcDtlToDay()));
          rowcfin21sog00.setSzNbrInvoWarrant(invoice.getNbrInvoWarrant());
          rowcfin21sog00.setSzCdCounty(dsd.getCdSvcDtlCounty());
          
          //-- TODO: Use proper value for DLV (delivery type) field
          rowcfin21sog00.setSzCdPaymentDelivery("");
          
          double amtSvcDtlUnitRate = getDoubleSafe(dsd.getAmtSvcDtlUnitRate());
          rowcfin21sog00.setDAmtSvcDtlUnitRate(amtSvcDtlUnitRate);
          
          double nbrSvcDtlUnitQty = getDoubleSafe(dsd.getNbrSvcDtlUnitQty());
          rowcfin21sog00.setSNbrSvcDtlUnitQty(nbrSvcDtlUnitQty);
          
          //-- still use income and fee paid?
          double total = amtSvcDtlUnitRate * nbrSvcDtlUnitQty;
          rowcfin21sog00.setDAmtInvoValidAmount(total);
          rowcfin21sog00_array.addROWCFIN21SOG00(rowcfin21sog00);
          ulRowQty++;
        }
        //-- a separate query is needed for Total Payments since other query is paginated
        Double sum = dynamicDelvrdSvcDtlDAO.sumDelvrdSvcDtlPayments(ulScrFinPayhistId, dtPayhistFrom,
                                                                    dtPayhistTo, region, county);
        grandTotal = sum != null ? sum : grandTotal;
        bMoreDataInd = list.getBMoreDataInd();
      }
      rowcfin21sog00_array.setUlRowQty(ulRowQty);
      cfin21so.setROWCFIN21SOG00_ARRAY(rowcfin21sog00_array);
    } else {
      // Check for the existance of the resource or contract.
      boolean searchByResource = RESOURCE.equals(cfin21si.getSzScrFinPayhistSearch());
      if (searchByResource) {
        if (capsResourceDAO.findCapsResourceByIdResourceOnly(ulScrFinPayhistId) == null) {
          throw new ServiceException(Messages.MSG_FIN_INVALID_RSRC_ID);
        }
      } else {
        if (contractDAO.findContractTypes(ulScrFinPayhistId) == null) {
          throw new ServiceException(Messages.MSG_FIN_INVLD_CNTRCT_ID);
        }
      }
      int type = searchByResource ? DynamicInvoiceDAO.RESOURCE : DynamicInvoiceDAO.CONTRACT;
      PaginatedHibernateList<Invoice> invoiceList = dynamicInvoiceDAO.findInvoicesBySearchId(type, ulScrFinPayhistId, dtPayhistFrom,
                                                                                             dtPayhistTo, region, county, pageNbr, pageSize);
      // clss33d      
      ROWCFIN21SOG00_ARRAY rowcfin21sog00_array = new ROWCFIN21SOG00_ARRAY();
      int ulRowQty = 0;
      if (invoiceList != null) {
        for (Invoice invoice : invoiceList) {
          ROWCFIN21SOG00 rowcfin21sog00 = new ROWCFIN21SOG00();
          rowcfin21sog00.setUlIdInvoInvoice(invoice.getIdInvoice() != null ? invoice.getIdInvoice() : 0);
          rowcfin21sog00.setDtDtInvoWarrantDate(DateHelper.toCastorDate(invoice.getDtInvoWarrantDate()));
          rowcfin21sog00.setSzNbrInvoWarrant(invoice.getNbrInvoWarrant());
          //-- a contract must have a resource, but the resource does not have to have a name
          String nmResource = invoice.getContract().getCapsResource().getNmResource();
          rowcfin21sog00.setSzNmResource(nmResource != null ? nmResource : "");
          rowcfin21sog00.setDAmtInvoValidAmount(getDoubleSafe(invoice.getAmtInvoValidAmount()));
          rowcfin21sog00.setSzCdCounty(invoice.getCdInvoCounty());
          
          //-- TODO: Use proper value for DLV (delivery type) field 
          rowcfin21sog00.setSzCdPaymentDelivery("");
          
          rowcfin21sog00_array.addROWCFIN21SOG00(rowcfin21sog00);
          ulRowQty++;
        }
        Double sum = dynamicInvoiceDAO.sumValidAmountBySearchId(type, ulScrFinPayhistId, dtPayhistFrom, dtPayhistTo,
                                                                region, county);
        grandTotal = sum != null ? sum : grandTotal;
        bMoreDataInd = invoiceList.getBMoreDataInd();
      }
      rowcfin21sog00_array.setUlRowQty(ulRowQty);
      cfin21so.setROWCFIN21SOG00_ARRAY(rowcfin21sog00_array);
    }
    cfin21so.setDScrAmtFinPayhistTotpy(grandTotal);
    aos.setBMoreDataInd(bMoreDataInd);
    cfin21so.setArchOutputStruct(aos);
    return cfin21so;
  }
  
  private int getIntSafe(Integer i){
    if(i == null){
      return Integer.valueOf(0);
    }
    return i;
  }
  
  private double getDoubleSafe(Double d){
    if(d == null){
      return Double.valueOf(0.00);
    }
    return d;
  }
}
