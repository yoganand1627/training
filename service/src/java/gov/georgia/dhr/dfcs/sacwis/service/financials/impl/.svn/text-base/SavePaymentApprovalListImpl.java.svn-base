package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SavePaymentApprovalList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN20SO;

import java.util.Date;
import java.util.Enumeration;

public class SavePaymentApprovalListImpl extends BaseServiceImpl implements SavePaymentApprovalList {

  private InvoiceDAO invoiceDAO = null;

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public CFIN20SO savePaymentApprovalList(CFIN20SI cfin20si) throws ServiceException {
    CFIN20SO output = new CFIN20SO();
    for (Enumeration rowcfin20sigEnum = cfin20si.getROWCFIN20SIG_ARRAY().enumerateROWCFIN20SIG(); rowcfin20sigEnum
            .hasMoreElements();) {
      ROWCFIN20SIG rowCFIN20SIG = (ROWCFIN20SIG) rowcfin20sigEnum.nextElement();
      int idInvoInvoice = rowCFIN20SIG.getUlIdInvoInvoice();
      Date dtLastUpdate = rowCFIN20SIG.getTsLastUpdate();
      int idPerson = rowCFIN20SIG.getUlIdPerson();
      String cdInvoApproved = rowCFIN20SIG.getSzCdInvoApproved();
      Date dtInvoApprovalDate = DateHelper.toJavaDate(rowCFIN20SIG.getDtDtInvoApprovalDate());
      
      Invoice invoice = this.getPersistentObject(Invoice.class, idInvoInvoice);
      if(!invoice.getDtLastUpdate().equals(dtLastUpdate)){
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      
      Person person = null;
      if(idPerson > 0){
        person = this.getPersistentObject(Person.class, idPerson);
      }
      invoice.setPerson(person);
      invoice.setCdInvoApproved(cdInvoApproved);
      invoice.setDtInvoApprovalDate(dtInvoApprovalDate);
      
      invoiceDAO.saveOrUpdate(invoice);
      
      /*
      int idPerson = rowCFIN20SIG.getUlIdPerson();
      String cdInvoApproved = rowCFIN20SIG.getSzCdInvoApproved();
      Date dtInvoApprovalDate = DateHelper.toJavaDate(rowCFIN20SIG.getDtDtInvoApprovalDate());
      Date dtLastUpdate = rowCFIN20SIG.getTsLastUpdate();
      // caud02dAUDdam
      int rowsUpdated = invoiceDAO.updateInvoiceIdPersonCdInvoApprovedDtInvoApprovalDate(idPerson, cdInvoApproved,
                                                                                         dtInvoApprovalDate,
                                                                                         idInvoInvoice, dtLastUpdate);
      if (rowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      */
    }

    return output;

  }

}
