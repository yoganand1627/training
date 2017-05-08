package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicDelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveFosterCareDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01_ARRAY;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveFosterCareDetailImpl extends BaseServiceImpl implements RetrieveFosterCareDetail {

  private ContractCountyDAO contractCountyDAO = null;
  private DynamicDelvrdSvcDtlDAO dynamicDelvrdSvcDtlDAO = null;

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setDynamicDelvrdSvcDtlDAO(DynamicDelvrdSvcDtlDAO dynamicDelvrdSvcDtlDAO) {
    this.dynamicDelvrdSvcDtlDAO = dynamicDelvrdSvcDtlDAO;
  }

  /**
   * ******************************************************************************************************************
   * * Service Macro Definitions ******************************************************************************************************************
   */
  public CFIN10SO retrieveFosterCareDetail(CFIN10SI cfin10si) throws ServiceException {
    int idInvoice = cfin10si.getUlIdInvoInvoice();
    if(idInvoice < 1) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    CFIN10SO cfin10so = new CFIN10SO();
    ArchOutputStruct aos = new ArchOutputStruct();
    //cfin10so.setArchOutputStruct(arch);
    //int i227 = 0;

    /*
     * * Call CDYN02D to retrieve line items from the DELVRD_SVC_DTL table
     */
    // convert cdyn02dQUERYdam() to delvrdSvcDtlDAO.findDelvrdSvcDtlByIdInvoiceOrderByIdResource()
    String orderBy = cfin10si.getSzOrderBy();
    String sortDir = cfin10si.getSzSortDir();
    int pageNbr = cfin10si.getArchInputStruct().getUsPageNbr();
    int pageSize = cfin10si.getArchInputStruct().getUlPageSizeNbr();
    PaginatedHibernateList<DelvrdSvcDtl> delvrdSvcDtlList = dynamicDelvrdSvcDtlDAO.findDelvrdSvcDtlByIdInvoice(idInvoice, orderBy, sortDir,
                                                                                                               pageNbr, pageSize);

    // Set fields in CFIN10SO to fields in CDYN02DO
    ROWCFIN10SOG00_ARRAY rowcfin10s0g00_array = new ROWCFIN10SOG00_ARRAY();
    /*
     * * Populate Output Message
     */
    for (Iterator<DelvrdSvcDtl> it = delvrdSvcDtlList.iterator(); it.hasNext();) {
      DelvrdSvcDtl delvrdSvcDtl = it.next();
      ROWCFIN10SOG00 rowcfin10s0g00 = new ROWCFIN10SOG00();
      rowcfin10s0g00.setSzCdSvcDtlLiType(delvrdSvcDtl.getCdSvcDtlLiType());
      rowcfin10s0g00.setSzNmPersonFull(delvrdSvcDtl.getPerson().getNmPersonFull());
      rowcfin10s0g00.setSzCdSvcDtlService(delvrdSvcDtl.getCdSvcDtlService());
      rowcfin10s0g00.setTsLastUpdate(delvrdSvcDtl.getDtLastUpdate());
      rowcfin10s0g00.setUYrSvcDtlServiceYear(getIntSafe(delvrdSvcDtl.getYrSvcDtlSvcYear()));
      rowcfin10s0g00.setSNbrSvcDtlUnitQty(getDoubleSafe(delvrdSvcDtl.getNbrSvcDtlUnitQty()));
      rowcfin10s0g00.setSNbrSvcDtlToDay(getIntSafe(delvrdSvcDtl.getNbrSvcDtlToDay()));
      rowcfin10s0g00.setSNbrSvcDtlFromDay(getIntSafe(delvrdSvcDtl.getNbrSvcDtlFromDay()));
      
      CapsResource resource = delvrdSvcDtl.getCapsResource() != null ? delvrdSvcDtl.getCapsResource() : new CapsResource();
      rowcfin10s0g00.setLNbrRsrcFacilAcclaim(getIntSafe(resource.getNbrRsrcFacilAcclaim()));
      rowcfin10s0g00.setUMoSvcDtlSvcMonth(getIntSafe(delvrdSvcDtl.getMoSvcDtlSvcMonth()));
      rowcfin10s0g00.setCIndSvcDtlRejItem(delvrdSvcDtl.getIndSvcDtlRejItem());
      rowcfin10s0g00.setUlIdResource(getIntSafe(resource.getIdResource()));
      rowcfin10s0g00.setUlIdSvcDtl(getIntSafe(delvrdSvcDtl.getIdSvcDtl()));
      rowcfin10s0g00.setUlIdPerson(delvrdSvcDtl.getPerson() != null ? delvrdSvcDtl.getPerson().getIdPerson() : 0);
      rowcfin10s0g00.setDAmtSvcDtlUnitRate(getDoubleSafe(delvrdSvcDtl.getAmtSvcDtlUnitRate()));
      rowcfin10s0g00.setSzCdSvcDtlUnitType(delvrdSvcDtl.getCdSvcDtlUnitType());
      //-- income no longer displayed on the page
      rowcfin10s0g00.setDAmtSvcDtlIncome(getDoubleSafe(delvrdSvcDtl.getAmtSvcDtlIncome()));
      rowcfin10s0g00_array.addROWCFIN10SOG00(rowcfin10s0g00);
    } // end for (Iterator<DelvrdSvcDtl> it....)
    
    rowcfin10s0g00_array.setUlRowQty(delvrdSvcDtlList.size());
    cfin10so.setROWCFIN10SOG00_ARRAY(rowcfin10s0g00_array);
    
    aos.setBMoreDataInd(delvrdSvcDtlList.getBMoreDataInd());
    cfin10so.setArchOutputStruct(aos);

    if (REQ_FUNC_CD_DTLS_CDS.equals(cfin10si.getArchInputStruct().getCReqFuncCd())) {
      // convert clss75dQUERYdam() to contractServiceDAO.findCdCnsvcServiceByIdContract()
      Invoice invoice = getPersistentObject(Invoice.class, idInvoice);
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, invoice.getYrInvoYear());
      cal.set(Calendar.MONTH, invoice.getMoInvoMonth()-1); //-- zero-indexed
      
      cal.set(Calendar.DATE, 1);
      Date dtRangeStart = cal.getTime();
      
      cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
      Date dtRangeEnd = cal.getTime();
    
      //List<String> contractSvcsList = contractServiceDAO.findCdCnsvcServiceByIdContract(cfin10si.getUlIdContract());
      //List<String> contractSvcsList = contractCountyDAO.findServicesByIdContractAndCounty(cfin10si.getUlIdContract(), cfin10si.getSzCdCounty());
      List<Map> contractSvcsList = contractCountyDAO.findServicesWithUnitType(cfin10si.getUlIdContract(),
                                                                              dtRangeStart, dtRangeEnd);
      
      ROWCFIN10SOG01_ARRAY array = new ROWCFIN10SOG01_ARRAY();
      int ulRowQty = 0;
      
      if(contractSvcsList != null && !contractSvcsList.isEmpty()){
        ulRowQty = contractSvcsList.size();
        for (Iterator<Map> it = contractSvcsList.iterator(); it.hasNext();) {
          Map contractSvcAndUnitType = it.next();
          ROWCFIN10SOG01 row = new ROWCFIN10SOG01();
          row.setSzCdCnsvcService((String) contractSvcAndUnitType.get("cdService"));
          row.setSzCdCnsvcUnitType((String) contractSvcAndUnitType.get("cdUnitType"));
          array.addROWCFIN10SOG01(row);
        }
      }
      
      cfin10so.setROWCFIN10SOG01_ARRAY(array);
      cfin10so.setUlRowQty(ulRowQty);
    } // end if ((REQ_FUNC_CD_DTLS_CDS == ...)

    return cfin10so;
  }
  
  private int getIntSafe(Integer i) {
    if(i == null) {
      return 0;
    }
    return i;
  }
  
  private double getDoubleSafe(Double d) {
    if(d == null) {
      return 0.0;
    }
    return d;
  }

}
