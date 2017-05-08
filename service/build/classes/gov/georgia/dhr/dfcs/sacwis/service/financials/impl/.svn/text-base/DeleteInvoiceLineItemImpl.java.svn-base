package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Collection;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.service.financials.DeleteInvoiceLineItem;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

/**
 * This is the Service that deletes the line items on the Invoice page. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   05/15/08  vdevarak  STGAP00007737: Added this service as part of enhancement
 *                       MR-012.
 *                       
 * </pre>
 */

public class DeleteInvoiceLineItemImpl extends BaseServiceImpl implements DeleteInvoiceLineItem {
  
 
  private DelvrdSvcDtlDAO delvrdSvcDtlDAO = null;
  
  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  
  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }
  
  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }
  
  public void deleteInvoiceLineItem(int idLineItem, String cdLineItemType) throws ServiceException {
    
      DelvrdSvcDtl delvrdSvcDtl = null;
      delvrdSvcDtl = delvrdSvcDtlDAO.findDelvrdSvcDtlByPrimaryKey(idLineItem);
      if(delvrdSvcDtl == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      if(delvrdSvcDtl.getSvcAuthDetail()!=null){
        String cdSvcDtlService = delvrdSvcDtl.getCdSvcDtlService()== null ? "": delvrdSvcDtl.getCdSvcDtlService();
        Collection<String> mileageServices = null;
        try {
          mileageServices = Lookup.getCategoryCodesCollection(CodesTables.CMILEAGE);
        } catch (LookupException le) {
          throw new IllegalStateException("Lookup data not initialized for DeliveredServiceValidation service", le);
        }
        int idSvcAuth = delvrdSvcDtl.getSvcAuthDetail().getIdSvcAuthDtl() == null ? 0:delvrdSvcDtl.getSvcAuthDetail().getIdSvcAuthDtl();
        if(!CodesTables.CINVTYPE_EDS.equals(cdLineItemType) && mileageServices.contains(cdSvcDtlService)){
          List<DelvrdSvcDtl> dlvrdSvcDtlList = delvrdSvcDtlDAO.findDlvrdDtlByIdSvcAuth(idSvcAuth);
          if(dlvrdSvcDtlList==null || dlvrdSvcDtlList.size()==0){
            svcAuthDetailDAO.deleteSvcAuthDetail(delvrdSvcDtl.getSvcAuthDetail());
          }
        }
        }
      delvrdSvcDtlDAO.deleteDelvrdSvcDtl(delvrdSvcDtl);
   }
  
}