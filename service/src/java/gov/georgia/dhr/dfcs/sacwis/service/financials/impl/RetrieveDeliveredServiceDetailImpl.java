package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicDelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveDeliveredServiceDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class implements the retrieves delivered service detail interface.
 * 
 * Change History:
 *  Date        User              Description
 *  ----------  ----------------  --------------------------------------------------
 *  08/13/2008  alwilliams        STGAP00006009 - Updated method findDeliveredServiceDetail 
 *                                to trim the service code coming from the Delivered Service
 *                                Detail table (DELVRD_SVC_DTL). The service code is returned
 *                                in a map from the database by the DynamicDelvrdSvcDtlDAO class.
 *
 */
public class RetrieveDeliveredServiceDetailImpl extends BaseServiceImpl implements RetrieveDeliveredServiceDetail {

  public static final String REQ_FUNC_CD_FIRST_TIME = "F";
  
  private ContractCountyDAO contractCountyDAO;
  //private ContractServiceDAO contractServiceDAO = null;
  private DynamicDelvrdSvcDtlDAO dynamicDelvrdSvcDtlDAO;
  
  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  //public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
  //  this.contractServiceDAO = contractServiceDAO;
  //}

  public void setDynamicDelvrdSvcDtlDAO(DynamicDelvrdSvcDtlDAO dynamicDelvrdSvcDtlDAO) {
    this.dynamicDelvrdSvcDtlDAO = dynamicDelvrdSvcDtlDAO;
  }
  
  public CFIN06SO findDeliveredServiceDetail(CFIN06SI cfin06si) throws ServiceException {
    CFIN06SO cfin06so = new CFIN06SO();
    
    //-- there are 2 paths for this service:
    //-- (A) Retrieve list of detail line items and service codes array (if line items exist)
    //-- (B) Retrieve only the service codes array
    
    //-- path A
    if (REQ_FUNC_CD_FIRST_TIME.equals(cfin06si.getArchInputStruct().getCReqFuncCd())) {
      ArchOutputStruct aos = new ArchOutputStruct();
      ROWCFIN06SOG_ARRAY rowcfin06sog_array = new ROWCFIN06SOG_ARRAY();
      SzCdSvcDtlService_ARRAY sdsvc_array = new SzCdSvcDtlService_ARRAY();
      int rowQty = 0;
      
      int idInvoice = cfin06si.getUlIdInvoInvoice();
      int idContract = cfin06si.getUlIdContract();
      int pageNbr = cfin06si.getArchInputStruct().getUsPageNbr();
      int pageSize = cfin06si.getArchInputStruct().getUlPageSizeNbr();
      String orderBy = cfin06si.getSzOrderBy();
      String sortDir = cfin06si.getSzSortDir();
      
      // cdyn11d
      PaginatedHibernateList<Map> listdsd = dynamicDelvrdSvcDtlDAO.findDelvrdSvcDtlByIdInvoiceAndIdContract(idInvoice, idContract,
                                                                                                            orderBy, sortDir,
                                                                                                            pageNbr, pageSize);
      if (listdsd != null) {
        rowQty = listdsd.size();
        aos.setBMoreDataInd(listdsd.getBMoreDataInd());
        for (Iterator<Map> it = listdsd.iterator(); it.hasNext();) {
          Map map = it.next();
          ROWCFIN06SOG rowcfin06sog = new ROWCFIN06SOG();
  
          rowcfin06sog.setSzCdSvcDtlLiType((String) map.get("cdSvcDtlLiType"));
          
          //STGAP0000609 : Trim service code coming from the database
          rowcfin06sog.setSzCdSvcDtlService(((String) map.get("cdSvcDtlService")).trim());
          
          rowcfin06sog.setSzCdSvcDtlUnitType((String) map.get("cdSvcDtlUnitType"));
          rowcfin06sog.setSzCdSvcDtlCounty((String) map.get("cdSvcDtlCounty"));
          rowcfin06sog.setSzScrNmGenericFullName((String) map.get("nmPersonFull"));
  
          rowcfin06sog.setSzCdCnsvcPaymentType((String) map.get("cdCnsvcPaymentType"));
          rowcfin06sog.setTsLastUpdate((Date) map.get("dtLastUpdate"));
          rowcfin06sog.setDAmtSvcDtlFeePaid(getDoubleSafe((Double) map.get("amtSvcDtlFeePaid")));
  
          rowcfin06sog.setDAmtSvcDtlUnitRate(getDoubleSafe((Double) map.get("amtSvcDtlUnitRate")));
          rowcfin06sog.setUlIdPerson(getIntSafe((Integer) map.get("idPerson")));
          rowcfin06sog.setUlIdSvcDtl(getIntSafe((Integer) map.get("idSvcDtl")));
          rowcfin06sog.setUlIdSvcAuthDtl(getIntSafe((Integer) map.get("idSvcAuthDtl")));
          rowcfin06sog.setUMoSvcDtlSvcMonth(getIntSafe((Integer) map.get("moSvcDtlSvcMonth")));
          rowcfin06sog.setUYrSvcDtlServiceYear(getIntSafe((Integer) map.get("yrSvcDtlSvcYear")));
  
          rowcfin06sog.setUsNbrSvcDtlCsli(getIntSafe((Integer) map.get("nbrSvcDtlCsli")));
          rowcfin06sog.setSNbrSvcDtlUnitQty(getDoubleSafe((Double) map.get("nbrSvcDtlUnitQty")));
          rowcfin06sog.setCIndSvcDtlRejItem((String) map.get("indSvcDtlRejItem"));
  
          rowcfin06sog_array.addROWCFIN06SOG(rowcfin06sog);
        }
        
        sdsvc_array = createServiceCodesArray(cfin06si);
      }
      aos.setUlRowQty(rowQty);
      rowcfin06sog_array.setUlRowQty(rowQty);
      cfin06so.setROWCFIN06SOG_ARRAY(rowcfin06sog_array);
      cfin06so.setSzCdSvcDtlService_ARRAY(sdsvc_array);
      cfin06so.setArchOutputStruct(aos);
    }
    //-- path B
    else {
      cfin06so.setSzCdSvcDtlService_ARRAY(createServiceCodesArray(cfin06si));
    }
    return cfin06so;
  }
  
  private SzCdSvcDtlService_ARRAY createServiceCodesArray(CFIN06SI cfin06si) {
    SzCdSvcDtlService_ARRAY serviceArray = new SzCdSvcDtlService_ARRAY();
    
    List<String> cdCnsvcServices = contractCountyDAO.findServicesByIdContractAndCounty(cfin06si.getUlIdContract(), cfin06si.getSzCdCounty());
    if(cdCnsvcServices != null && !cdCnsvcServices.isEmpty()) {
      for(String cdSvcDtlService : cdCnsvcServices) {
        if(StringHelper.isValid(cdSvcDtlService)) {
          serviceArray.addSzCdSvcDtlService(cdSvcDtlService);
        }
      }
      serviceArray.setUlRowQty(cdCnsvcServices.size());
    }
    
    return serviceArray;
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