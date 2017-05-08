package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdminDtl;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveAdminDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG01_ARRAY;

import java.util.Iterator;
import java.util.List;

public class RetrieveAdminDetailImpl extends BaseServiceImpl implements RetrieveAdminDetail {

  /**
   * ****************************************************************************************************************** *
   * Service Macro Definitions
   * ******************************************************************************************************************
   */

  private AdminDtlDAO adminDtlDAO = null;
  //private ContractCountyDAO contractCountyDAO = null;
  private ContractServiceDAO contractServiceDAO = null;

  public void setAdminDtlDAO(AdminDtlDAO adminDtlDAO) {
    this.adminDtlDAO = adminDtlDAO;
  }

  //public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
  //  this.contractCountyDAO = contractCountyDAO;
  //}

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public CFIN15SO retrieveAdminDetail(CFIN15SI cfin15si) throws ServiceException {
    CFIN15SO cfin15so = new CFIN15SO();
    ArchOutputStruct aos = new ArchOutputStruct();
    int rowQty = 0;
    //cfin15so.setArchOutputStruct(arch);
    
    int pageNbr = cfin15si.getArchInputStruct().getUsPageNbr();
    int pageSize = cfin15si.getArchInputStruct().getUlPageSizeNbr();

    // convert clss36dQUERYdam() to adminDtlDAO.findAdminDtlByIdInvoResource();
    ROWCFIN15SOG00_ARRAY rowdfin15sog00_array = new ROWCFIN15SOG00_ARRAY();
    PaginatedHibernateList<AdminDtl> adminDtl = adminDtlDAO.findAdminDtlByIdInvoResource(cfin15si.getUlIdInvoInvoice(), pageNbr, pageSize);
    if (adminDtl != null) { // there is at least one item in the list
      rowQty = adminDtl.size();
      aos.setBMoreDataInd(adminDtl.getBMoreDataInd());
      for (Iterator<AdminDtl> it = adminDtl.iterator(); it.hasNext();) {
        AdminDtl row = it.next();
        ROWCFIN15SOG00 rowdfin15sog00 = new ROWCFIN15SOG00();

        rowdfin15sog00.setSzCdAdminDtlInvoDisptn(row.getCdAdminDtlInvoDisptn());
        rowdfin15sog00.setSzCdAdminDtlLiType(row.getCdAdminDtlLiType());
        rowdfin15sog00.setSzCdAdminDtlService(row.getCdAdminDtlService());
        rowdfin15sog00.setTsLastUpdate(row.getDtLastUpdate());
        rowdfin15sog00.setCIndAdminDtlRejItm(row.getIndAdminDtlRejItm());
        rowdfin15sog00.setUsNbrAdminDtlCsli(row.getNbrAdminDtlCsli() != null ? row.getNbrAdminDtlCsli() : 0);
        rowdfin15sog00.setUMoAdminDtlSvcMonth(row.getMoAdminDtlSvcMonth() != null ? row.getMoAdminDtlSvcMonth() : 0);
        rowdfin15sog00.setUYrAdminDtlSvcYear(row.getYrAdminDtlSvcYear() != null ? row.getYrAdminDtlSvcYear() : 0);
        rowdfin15sog00.setUlIdInvoInvoice(row.getInvoice().getIdInvoice() != null ? row.getInvoice().getIdInvoice() : 0);
        rowdfin15sog00.setUlIdAdminDtl(row.getIdAdminDtl() != null ? row.getIdAdminDtl() : 0);
        //rowdfin15sog00.setDAmtAdminDtlTravel(row.getAmtAdminDtlTravel());
        //rowdfin15sog00.setDAmtAdminDtlSupplies(row.getAmtAdminDtlSupplies());
        //rowdfin15sog00.setDAmtAdminDtlSalaries(row.getAmtAdminDtlSalaries());
        rowdfin15sog00.setDAmtAdminDtlOther(row.getAmtAdminDtlOther() != null ? row.getAmtAdminDtlOther() : 0);
        //rowdfin15sog00.setDAmtAdminDtlOffsetItem(row.getAmtAdminDtlOffsetItem());
        //rowdfin15sog00.setDAmtAdminDtlFrgBenft(row.getAmtAdminDtlFrgBenft());
        //rowdfin15sog00.setDAmtAdminDtlEquipment(row.getAmtAdminDtlEquipment());
        rowdfin15sog00.setDAmtAdminDtlAdminAlloc(row.getAmtAdminDtlAdminAlloc() != null ? row.getAmtAdminDtlAdminAlloc() : 0);
        rowdfin15sog00.setDAmtAdminDtlPromotional(row.getAmtAdminDtlPromotional() != null ? row.getAmtAdminDtlPromotional() : 0);
        rowdfin15sog00.setSzCdCounty(row.getCdCounty());
        rowdfin15sog00.setSzTxtAdminDtlComments(row.getTxtComments());
        
        rowdfin15sog00_array.addROWCFIN15SOG00(rowdfin15sog00);
      }
    }
    
    aos.setUlRowQty(rowQty);
    rowdfin15sog00_array.setUlRowQty(rowQty);
    cfin15so.setROWCFIN15SOG00_ARRAY(rowdfin15sog00_array);

    if ((REQ_FUNC_CD_DTLS_CDS == cfin15si.getArchInputStruct().getCReqFuncCd().charAt(0))) {
      // converted clss75dQUERYdam() to contractServiceDAO.findCdCnsvcServiceByIdContract()
      List<String> contractSvcsList = contractServiceDAO.findCdCnsvcServiceByIdContract(cfin15si.getUlIdContract());
      //List<String> contractSvcsList = contractCountyDAO.findServicesByIdContractAndCounty(cfin15si.getUlIdContract(), cfin15si.getSzCdCounty());

      if (contractSvcsList == null || contractSvcsList.isEmpty()) {
        throw new ServiceException(Messages.MSG_CON_NO_SVC_CODE);
      }
      
      ROWCFIN15SOG01_ARRAY rowdfin15sog01_array = new ROWCFIN15SOG01_ARRAY();
      if(contractSvcsList != null && !contractSvcsList.isEmpty()) {
        for (Iterator<String> it = contractSvcsList.iterator(); it.hasNext();) {
          String serviceCode = it.next();
          ROWCFIN15SOG01 rowdfin15sog01 = new ROWCFIN15SOG01();
          rowdfin15sog01.setSzCdCnsvcService(serviceCode);
          rowdfin15sog01_array.addROWCFIN15SOG01(rowdfin15sog01);
        }
        cfin15so.setUlRowQty(contractSvcsList.size());
      }
      cfin15so.setROWCFIN15SOG01_ARRAY(rowdfin15sog01_array);
    }
    
    cfin15so.setArchOutputStruct(aos);
    return cfin15so;
  }
}
