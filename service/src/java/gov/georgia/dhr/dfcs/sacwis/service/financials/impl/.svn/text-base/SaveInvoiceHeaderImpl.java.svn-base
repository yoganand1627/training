package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveInvoiceHeader;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN03SO;

import java.util.Date;

/**
* 
* <pre>
*    Change History:
*    Date      User      Description
*    --------  --------  --------------------------------------------------
*   04/10/2009 bgehlot   STGAP00013273: Added the code to save the Provider Invoice number
*                        
* </pre>
*/

public class SaveInvoiceHeaderImpl extends BaseServiceImpl implements SaveInvoiceHeader {

  private InvoiceDAO invoiceDAO = null;
  
  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public CFIN03SO saveInvoiceHeaderInformation(CFIN03SI cfin03si) throws ServiceException {
    String cReqFuncCd = cfin03si.getArchInputStruct().getCReqFuncCd();
    int idInvoice;
    Date dtLastUpdate;
    Invoice invoice;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      int ulIdContract = cfin03si.getUlIdContract();
      if(ulIdContract <= 0){
        //-- throw error
        throw new RuntimeWrappedException(new PopulationException("The SaveInvoiceHeader service was passed a Contract ID of 0; insert will fail."));
      }
      
      double dAmtInvoClaimedAmount = cfin03si.getDAmtInvoClaimedAmount();
      String szCdInvoAdjustmentRb = cfin03si.getSzCdInvoAdjustmentRb();
      String szCdInvoPhase = cfin03si.getSzCdInvoPhase();
      String szCdInvoType = cfin03si.getSzCdInvoType();
      Date dtDtInvoReceivedDate = DateHelper.toJavaDate(cfin03si.getDtDtInvoReceivedDate());
      String cIndInvoReadyForValid = cfin03si.getCIndInvoReadyForValid();
      int uMoInvoMonth = cfin03si.getUMoInvoMonth();
      int uYrInvoYear = cfin03si.getUYrInvoYear();
      Date dtDtInvoEntryStarted = DateHelper.toJavaDate(cfin03si.getDtDtInvoEntryStarted());
      Date dtDtInvoEntryCompleted = DateHelper.toJavaDate(cfin03si.getDtDtInvoEntryCompleted());
      String szNbrInvoVid = cfin03si.getSzNbrInvoVid();
      
      
      //STGAP00013273: Get the Provider invoice number from the input object
      String szNbrInvProvider = cfin03si.getSzNbrInvProvider();
      
      invoice = new Invoice();
      invoice.setIdInvoice(0);
      invoice.setAmtInvoClaimedAmount(dAmtInvoClaimedAmount);
      invoice.setCdInvoAdjustmentRb(szCdInvoAdjustmentRb);
      invoice.setCdInvoPhase(szCdInvoPhase);
      invoice.setCdInvoType(szCdInvoType);
      if(!DateHelper.isNull(dtDtInvoReceivedDate)){
        invoice.setDtInvoReceivedDate(dtDtInvoReceivedDate);
      }
      Contract contract = this.getPersistentObject(Contract.class, ulIdContract);
      invoice.setContract(contract);
      invoice.setIndInvoReadyForValid(cIndInvoReadyForValid);
      invoice.setMoInvoMonth(uMoInvoMonth);
      invoice.setYrInvoYear(uYrInvoYear);
      if(!DateHelper.isNull(dtDtInvoEntryStarted)){
        invoice.setDtInvoEntryStarted(dtDtInvoEntryStarted);
      }
      if(!DateHelper.isNull(dtDtInvoEntryCompleted)){
        invoice.setDtInvoEntryCompleted(dtDtInvoEntryCompleted);
      }
      invoice.setNbrInvoVid(szNbrInvoVid);
      invoice.setCdInvoGeneration(CodesTables.CINVOGEN_U);
      invoice.setDtInvoCreateDate(new Date());
      invoice.setCdInvoCounty(cfin03si.getSzCdCounty());
      invoice.setCdInvoRegion(cfin03si.getSzCdRegion());
      
      if(cfin03si.getBIndEmergencyPayment()) {
        setEmergencyPaymentFields(invoice, cfin03si);
      }
      
      invoice.setNbrInvProvider(szNbrInvProvider);
      
      invoiceDAO.saveOrUpdate(invoice);
      idInvoice = invoice.getIdInvoice();
      dtLastUpdate = invoice.getDtLastUpdate();
      
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      idInvoice = cfin03si.getUlIdInvoInvoice();
      if(idInvoice <= 0){
        //-- throw error
        throw new RuntimeWrappedException(new PopulationException("The SaveInvoiceHeader service was passed an Invoice ID of 0; update will fail."));
      }
      double dAmtInvoClaimedAmount = cfin03si.getDAmtInvoClaimedAmount();
      String szCdInvoPhase = cfin03si.getSzCdInvoPhase();
      Date dtDtInvoReceivedDate = DateHelper.toJavaDate(cfin03si.getDtDtInvoReceivedDate());
      String cIndInvoReadyForValid = cfin03si.getCIndInvoReadyForValid();
      int uMoInvoMonth = cfin03si.getUMoInvoMonth();
      int uYrInvoYear = cfin03si.getUYrInvoYear();
      Date dtDtInvoEntryStarted = DateHelper.toJavaDate(cfin03si.getDtDtInvoEntryStarted());
      Date dtDtInvoEntryCompleted = DateHelper.toJavaDate(cfin03si.getDtDtInvoEntryCompleted());
      //STGAP00013273: Get the Provider invoice number from the input object
      String szNbrInvProvider = cfin03si.getSzNbrInvProvider();
      
      invoice = this.getPersistentObject(Invoice.class, idInvoice);
      invoice.setAmtInvoClaimedAmount(dAmtInvoClaimedAmount);
      invoice.setCdInvoPhase(szCdInvoPhase);
      if(!DateHelper.isNull(dtDtInvoReceivedDate)){
        invoice.setDtInvoReceivedDate(dtDtInvoReceivedDate);
      }
      invoice.setIndInvoReadyForValid(cIndInvoReadyForValid);
      invoice.setMoInvoMonth(uMoInvoMonth);
      invoice.setYrInvoYear(uYrInvoYear);
      if(!DateHelper.isNull(dtDtInvoEntryStarted)){
        invoice.setDtInvoEntryStarted(dtDtInvoEntryStarted);
      }
      if(!DateHelper.isNull(dtDtInvoEntryCompleted)){
        invoice.setDtInvoEntryCompleted(dtDtInvoEntryCompleted);
      }
      invoice.setCdInvoCounty(cfin03si.getSzCdCounty());
      
      if(cfin03si.getBIndEmergencyPayment()) {
        setEmergencyPaymentFields(invoice, cfin03si);
      }
      
      invoice.setNbrInvProvider(szNbrInvProvider);
      
      invoiceDAO.saveOrUpdate(invoice);
      dtLastUpdate = invoice.getDtLastUpdate();
      
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      dtLastUpdate = cfin03si.getTsLastUpdate();
      idInvoice = cfin03si.getUlIdInvoInvoice();
      if(idInvoice <= 0){
        //-- throw error
        throw new RuntimeWrappedException(new PopulationException("The SaveInvoiceHeader service was passed an Invoice ID of 0; delete will fail."));
      }
      invoice = this.getPersistentObject(Invoice.class, idInvoice);
      invoiceDAO.deleteInvoice(invoice);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    if (dtLastUpdate == null) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    CFIN03SO cfin03so = new CFIN03SO();
    cfin03so.setUlIdInvoInvoice(idInvoice);
    cfin03so.setTsLastUpdate(dtLastUpdate);
    return cfin03so;
  }
  
  private void setEmergencyPaymentFields(Invoice invoice, CFIN03SI cfin03si) {
    invoice.setDtInvoSubmitDate(DateHelper.toJavaDate(cfin03si.getDtDtInvoSubmitDate()));
    invoice.setDtInvoWarrantDate(DateHelper.toJavaDate(cfin03si.getDtDtInvoWarrantDate()));
    invoice.setNbrInvoWarrant(cfin03si.getSzNbrInvoWarrant());
    invoice.setTxtInvoContact(cfin03si.getSzTxtInvoContact());
    invoice.setAmtInvoValidAmount(cfin03si.getDAmtInvoValidAmount());
    invoice.setAmtInvoWarrant(cfin03si.getDAmtInvoWarrant());
    invoice.setCdInvoApproved(cfin03si.getSzCdInvoApproved());
    invoice.setPerson(getPersistentObject(Person.class, cfin03si.getUlIdPerson()));
    
    if(!DateHelper.isNull(cfin03si.getDtDtInvoApprovalDate())) {
      invoice.setDtInvoApprovalDate(DateHelper.toJavaDate(cfin03si.getDtDtInvoApprovalDate()));
    }
  }
}

