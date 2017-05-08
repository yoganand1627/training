package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsRuntimeException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cinvphse;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Crjctrsn;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Crjidtyp;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RejectionReasonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RestrictedFundsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdminDtl;
import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;
import gov.georgia.dhr.dfcs.sacwis.db.InvoiceInbound;
import gov.georgia.dhr.dfcs.sacwis.db.InvoiceOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.Medication;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RejectionReason;
import gov.georgia.dhr.dfcs.sacwis.db.RestrictedFunds;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveSmileInvoice;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SmileInvoiceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SmileInvoiceSO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * The SaveSmileInvoiceImpl is the service executed by the Smile Invoice Web service(SmileInvoiceWS) in order
 * to perform operations on the shines application.
 * 
 * @author Ronnie Phelps, January 8, 2009
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 1/08/2008	rphelps		         Added logic to handle voided and canceled invoices
 * 
 * 07/16/2009   cwells                   STGAP00010117: Only adding new entry in the Restricted funds table 
 *                                      when we have a positive amount for Checking amount or Saving amount
 * 
 * </PRE>
 */
public class SaveSmileInvoiceImpl extends BaseServiceImpl implements SaveSmileInvoice {

  public static final String RS_CREATED = "CREATED";
  
  public static final String RS_NO_CLIENT = "NO CLIENT";
  
  public static final String RS_NO_VENDOR = "NO VENDOR";
  
  public static final String RS_DUPL_INVCE = "DUPL INVCE";
  
  public static final String RS_INVPRGMEC  = "INVPRGMEC";  
  
  public static final String RS_REJECTED = "REJECTED";
  
   
  public static final String RS_VOID  = "VOID";  
  
  public static final String RS_CANCEL = "CANCEL";

  public static final String ADMINDTL_TYPE = "ADM";

  public static final String INVO_PHASE = "PAD";

  public static final String INVO_VOID = "VOD";

  public static final String INVO_CANCELLED= "CAN";

  private AdminDtlDAO adminDtlDAO = null;

  private CaseBudgetLimitDAO caseBudgetLimitDAO = null;

  private CountyBudgetLimitDAO countyBudgetLimitDAO = null;

  private DelvrdSvcDtlDAO delvrdSvcDtlDAO = null;

  private InvoiceDAO invoiceDAO = null;

  private InvoiceInboundDAO invoiceInboundDAO = null;

  private RestrictedFundsDAO restrictedFundsDAO = null;
  
  private SvcAuthDetailDAO svcAuthDetailDAO = null;
  
  private RejectionReasonDAO rejectionReasonDAO = null;

  public void setAdminDtlDAO(AdminDtlDAO adminDtlDAO) {
    this.adminDtlDAO = adminDtlDAO;
  }

  public void setCaseBudgetLimitDAO(CaseBudgetLimitDAO caseBudgetLimitDAO) {
    this.caseBudgetLimitDAO = caseBudgetLimitDAO;
  }

  public void setCountyBudgetLimitDAO(CountyBudgetLimitDAO countyBudgetLimitDAO) {
    this.countyBudgetLimitDAO = countyBudgetLimitDAO;
  }

  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public void setInvoiceInboundDAO(InvoiceInboundDAO invoiceInboundDAO) {
    this.invoiceInboundDAO = invoiceInboundDAO;
  }

  public void setRestrictedFundsDAO(RestrictedFundsDAO restrictedFundsDAO) {
    this.restrictedFundsDAO = restrictedFundsDAO;
  }
  
  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }
  
  public void setRejectionReasonDAO(RejectionReasonDAO rejectionReasonDAO) {
    this.rejectionReasonDAO = rejectionReasonDAO;
  }

  public SmileInvoiceSO saveSmileInvoice(SmileInvoiceSI smileInvoiceSI) {
    InvoiceOutbound invoiceOutbound = getPersistentObject(InvoiceOutbound.class, smileInvoiceSI.getUlTransactionId());

    // Build the audit entry, InvoiceInbound
    InvoiceInbound invoiceInbound = processInvoiceInbound(smileInvoiceSI, invoiceOutbound);
    String status = buildNonNullString(smileInvoiceSI.getTxtReturnStatus());

    //check if we can get the actual invoice
    Invoice invoice = null;
    int idInvoice = smileInvoiceSI.getUlInvoiceId();
    if (invoiceOutbound != null) {
      // Find the invoice
      invoice = invoiceDAO.findInvoiceByInvoiceId(idInvoice);
      // if no invoice is found set the status here
      if (invoice == null) {
        invoiceInbound.setErrorStatus("INVNOTFD");
      }
    } else if (invoiceOutbound == null) {
      invoiceInbound.setErrorStatus("OTINVNOTFD");
    }

    invoiceInboundDAO.saveInvoiceInbound(invoiceInbound);

    SmileInvoiceSO smileInvoiceSO = null;
    if (invoice != null) {
      if (RS_CREATED.equalsIgnoreCase(status) == true) {
        smileInvoiceSO = processCreatedInvoice(smileInvoiceSI, invoice, invoiceOutbound, status);
      } else if(RS_VOID.equalsIgnoreCase(status) == true){
    	smileInvoiceSO = processVoidedInvoice(smileInvoiceSI, invoice, invoiceOutbound, status);  
      } else if (RS_CANCEL.equalsIgnoreCase(status)) {
    	smileInvoiceSO = processCancelledInvoice(smileInvoiceSI, invoice, invoiceOutbound, status);  
      } else {
        smileInvoiceSO = processErrorInvoice(smileInvoiceSI, invoice, invoiceOutbound, status);
      }
    } else {
      //if we can not find the actual invoice error out
      throw new BasePrsRuntimeException("Invoice not found: " + Integer.toString(idInvoice),
                                        BasePrsRuntimeException.CRITICAL_PRIORITY);
    }
    return smileInvoiceSO;
  }

  private InvoiceInbound processInvoiceInbound(SmileInvoiceSI smileInvoiceSI, InvoiceOutbound invoiceOutbound) {
    InvoiceInbound invoiceInbound = new InvoiceInbound();
    invoiceInbound.setInvoiceOutbound(invoiceOutbound);
    invoiceInbound.setIdInvoice(smileInvoiceSI.getUlInvoiceId());
    invoiceInbound.setDtPayment(smileInvoiceSI.getDtPayment());
    invoiceInbound.setAmtPayment(smileInvoiceSI.getLdChkAmt());
    invoiceInbound.setAmtRestFundsCheck(smileInvoiceSI.getLdRstrctFundChkBal());
    invoiceInbound.setAmtRestFundsSave(smileInvoiceSI.getLdRstrctFundSavBal());
    invoiceInbound.setNbrCheckNum(smileInvoiceSI.getCheckNumber());
    invoiceInbound.setErrorStatus(buildMax10LengthString(smileInvoiceSI.getTxtReturnStatus()));
    return invoiceInbound;
  }

  private SmileInvoiceSO processCreatedInvoice(SmileInvoiceSI smileInvoiceSI, Invoice invoice,
                                               InvoiceOutbound invoiceOutbound,String status) {
    int idInvoice = smileInvoiceSI.getUlInvoiceId();
    // amount to add the invoice total, maybe the full line amt
    // or an adjusted if there a prev payment
    double amtSmilePaid = 0;

    // since we have inbound created check record, marked the invoice as piad
    invoice.setCdInvoPhase(INVO_PHASE);
    // reset values to si if values in database is prev null
    if (invoice.getNbrInvoWarrant() == null) {
      invoice.setNbrInvoWarrant(String.valueOf(smileInvoiceSI.getCheckNumber()));
    }
    if (invoice.getDtInvoWarrantDate() == null) {
      invoice.setDtInvoWarrantDate(smileInvoiceSI.getDtPayment());
    }

    if (ADMINDTL_TYPE.equalsIgnoreCase(invoice.getCdInvoType())) {
      amtSmilePaid = updateAdminDetail(smileInvoiceSI, idInvoice, invoiceOutbound.getIdLineItem());
    } else {
      String cdSvcDtlService = (invoiceOutbound.getCdSvcDtlService() != null) ? invoiceOutbound.getCdSvcDtlService()
                                                                                               .trim() : "";
      amtSmilePaid = updateDeliveredServiceDetail(smileInvoiceSI, idInvoice, invoiceOutbound.getIdLineItem(),
                                                  cdSvcDtlService, invoice.getCdInvoCounty(),status);
    }

    // reset the invoice amt and save off the invoice
    double invAmt = invoice.getAmtInvoWarrant() != null ? invoice.getAmtInvoWarrant() : 0;
    invoice.setAmtInvoWarrant(invAmt + amtSmilePaid);
    invoiceDAO.saveOrUpdate(invoice);

    SmileInvoiceSO smileInvoiceSO = new SmileInvoiceSO();
    smileInvoiceSO.setTransID(smileInvoiceSI.getUlTransactionId());
    return smileInvoiceSO;
  }

  private double updateAdminDetail(SmileInvoiceSI smileInvoiceSI, int idInvoice, int lineItem) {
    double amtSmilePaid = 0.0;
    AdminDtl adminDtl = adminDtlDAO.findAdminDtlByInvoiceIdnIdAdminDtl(lineItem, idInvoice);
    if (adminDtl != null) {
      double itemAmt = (smileInvoiceSI.getLdChkAmt() != null) ? smileInvoiceSI.getLdChkAmt() : 0.0;
      if (adminDtl.getAmtSmilePaid() != null) {
        amtSmilePaid = itemAmt - adminDtl.getAmtSmilePaid();
      } else {
        amtSmilePaid = itemAmt;
      }
      adminDtl.setAmtSmilePaid(itemAmt);
      adminDtl.setNbrCheck(smileInvoiceSI.getCheckNumber());
      adminDtl.setDtPaid(smileInvoiceSI.getDtPayment());
      adminDtlDAO.saveAdminDtl(adminDtl);
    }
    return amtSmilePaid;
  }

  private double updateDeliveredServiceDetail(SmileInvoiceSI smileInvoiceSI, int idInvoice, int lineItem,
                                              String cdSvcDtlService, String invCounty,String status) {
    double amtSmilePaid = 0.0;

    DelvrdSvcDtl delvrdSvcDtl = delvrdSvcDtlDAO.findDelvrdSvcDtlByInvoiceIdnIdSvcDtl(lineItem, idInvoice);
    if (delvrdSvcDtl != null) {
      String detailCdSvcDtlService = delvrdSvcDtl.getCdSvcDtlService() != null ? delvrdSvcDtl.getCdSvcDtlService()
                                                                                             .trim() : null;
      if (cdSvcDtlService.equalsIgnoreCase(detailCdSvcDtlService)) {
        double itemAmt = (smileInvoiceSI.getLdChkAmt() != null) ? smileInvoiceSI.getLdChkAmt() : 0.0;
        if (delvrdSvcDtl.getAmtSmilePaid() != null) {
          amtSmilePaid = itemAmt - delvrdSvcDtl.getAmtSmilePaid();
        } else {
          amtSmilePaid = itemAmt;
        }
        delvrdSvcDtl.setAmtSmilePaid(itemAmt);
        delvrdSvcDtl.setNbrCheck(smileInvoiceSI.getCheckNumber());
        if(status.equalsIgnoreCase(RS_VOID) == false){
        	delvrdSvcDtl.setDtPaid(smileInvoiceSI.getDtPayment());
        	delvrdSvcDtlDAO.saveDelvrdSvcDtl(delvrdSvcDtl);
        }
        // Update Restricted Funds for the person
        //STGAP00010117: Only adding new entry in the Restricted funds table 
        // when we have a positive amount for Checking amount or Saving amount
        double checkAmount = (smileInvoiceSI.getLdRstrctFundChkBal() != null) ? smileInvoiceSI.getLdRstrctFundChkBal() : 0.0;
        double savingAmount = (smileInvoiceSI.getLdRstrctFundSavBal() != null) ? smileInvoiceSI.getLdRstrctFundSavBal() : 0.0;
        if (checkAmount > 0.0 || savingAmount > 0.0) {
          int idPerson = delvrdSvcDtl.getPerson().getIdPerson();
          RestrictedFunds restrictedFunds = restrictedFundsDAO.findByIdPerson(idPerson);
          if (restrictedFunds != null) {
            if (smileInvoiceSI.getLdRstrctFundChkBal() != null) {
              restrictedFunds.setAmtCheckBal(smileInvoiceSI.getLdRstrctFundChkBal());
            }
            if (smileInvoiceSI.getLdRstrctFundSavBal() != null) {
              restrictedFunds.setAmtSavBal(smileInvoiceSI.getLdRstrctFundSavBal());
            }
            restrictedFundsDAO.save(restrictedFunds);
           
          }
          else{
              RestrictedFunds newRf = new RestrictedFunds();
              populate_newRestrictedFunds(idPerson, newRf, smileInvoiceSI);                  
              restrictedFundsDAO.save(newRf);
            }
        }
        updateCountyBudgetLimit(delvrdSvcDtl, amtSmilePaid, invCounty);
        updateCaseBudgetLimit(delvrdSvcDtl, amtSmilePaid);
        
      }
    }
    return amtSmilePaid;
  }

  private void updateCountyBudgetLimit(DelvrdSvcDtl delvrdSvcDtl, double amtSmilePaid, String invCounty) {
    int fiscalYear = 0;
    String txtCdSvcDtlService = delvrdSvcDtl.getCdSvcDtlService();
    String txtProgram = txtCdSvcDtlService.substring(0, 3);
    int delvrdSvcMonth = delvrdSvcDtl.getMoSvcDtlSvcMonth();
    Date currentYear = new Date();

    if (delvrdSvcMonth != 0 && delvrdSvcMonth <= 6) {
      fiscalYear = DateHelper.getYear(currentYear);
    } else if (delvrdSvcMonth != 0 && delvrdSvcMonth > 6 && delvrdSvcMonth <= 12) {
      fiscalYear = DateHelper.getYear(currentYear) + 1;
    }

    CountyBudgetLimit cntyBdgtlmt = countyBudgetLimitDAO.findCountyBudgetLimitByProgramAndFiscalYear(invCounty,
                                                                                                     txtProgram,
                                                                                                     fiscalYear);
    if (cntyBdgtlmt != null) {
      // Update Amt Spent
      cntyBdgtlmt.setAmtSpent((cntyBdgtlmt.getAmtSpent() != null) ? (cntyBdgtlmt.getAmtSpent() + amtSmilePaid)
                                                                 : amtSmilePaid);
      // Update Amt Obg
      SvcAuthDetail svcAuthDetail = delvrdSvcDtl.getSvcAuthDetail();
      if (svcAuthDetail != null) {
        if (DateHelper.isEqual(svcAuthDetail.getDtSvcAuthDtlTerm(), svcAuthDetail.getDtSvcAuthDtlEnd())) {
          double amtObg = (cntyBdgtlmt.getAmtObg() != null) ? cntyBdgtlmt.getAmtObg() : 0.0;
          cntyBdgtlmt.setAmtObg(amtObg - amtSmilePaid);
        }
      }
      // Update Amt Balance
      if ((svcAuthDetail == null)
          || DateHelper.isBefore(svcAuthDetail.getDtSvcAuthDtlTerm(), svcAuthDetail.getDtSvcAuthDtlEnd())) {
        double amtBalance = (cntyBdgtlmt.getAmtBalance() != null) ? cntyBdgtlmt.getAmtBalance() : 0.0;
        cntyBdgtlmt.setAmtBalance(amtBalance - amtSmilePaid);
      }
      countyBudgetLimitDAO.saveOrUpdateCountyBudgetLimit(cntyBdgtlmt);
    }
  }

  private void updateCaseBudgetLimit(DelvrdSvcDtl delvrdSvcDtl, double amtSmilePaid) {

    SvcAuthDetail svcAuthDetail = delvrdSvcDtl.getSvcAuthDetail();
    if (svcAuthDetail != null) {
      String txtCdSvcDtlService = delvrdSvcDtl.getCdSvcDtlService();
      String txtProgram = txtCdSvcDtlService.substring(0, 3);
      String txtProgram2 = txtCdSvcDtlService.substring(0, 5);

      List<CaseBudgetLimit> caseBudgetLimitList = caseBudgetLimitDAO
                                                                    .findCaseBudgetLimitBySmileInvoiceParams(
                                                                                                             txtProgram,
                                                                                                             txtProgram2,
                                                                                                             txtCdSvcDtlService,
                                                                                                             svcAuthDetail
                                                                                                                          .getIdSvcAuthDtl());
      if (caseBudgetLimitList != null && !caseBudgetLimitList.isEmpty()) {
        for (Iterator it = caseBudgetLimitList.iterator(); it.hasNext();) {
          CaseBudgetLimit caseBudgetLimit = (CaseBudgetLimit) it.next();
          // udpte amt spent
          caseBudgetLimit.setAmtSpent(caseBudgetLimit.getAmtSpent() != null ? caseBudgetLimit.getAmtSpent()
                                                                              + amtSmilePaid : amtSmilePaid);
          // update amt remain
          if (svcAuthDetail != null) {
            if (DateHelper.isEqual(svcAuthDetail.getDtSvcAuthDtlTerm(), svcAuthDetail.getDtSvcAuthDtlEnd())) {
              double amtRemain = (caseBudgetLimit.getAmtRemain() != null) ? caseBudgetLimit.getAmtRemain() : 0.0;
              caseBudgetLimit.setAmtRemain(amtRemain - amtSmilePaid);

            }
          }
          // update amt Balance
          if ((svcAuthDetail == null)
              || DateHelper.isBefore(svcAuthDetail.getDtSvcAuthDtlTerm(), svcAuthDetail.getDtSvcAuthDtlEnd())) {
            double amtBalance = (caseBudgetLimit.getAmtBalance() != null) ? caseBudgetLimit.getAmtBalance() : 0.0;
            caseBudgetLimit.setAmtBalance(amtBalance - amtSmilePaid);
          }
          caseBudgetLimitDAO.saveCaseBudgetLimit(caseBudgetLimit);
        }
      }
    }
  }

  private SmileInvoiceSO processErrorInvoice(SmileInvoiceSI smileInvoiceSI, Invoice invoice,
                                             InvoiceOutbound invoiceOutbound, String status) {
    RejectionReason rejectionReason = new RejectionReason();
    
    if (ADMINDTL_TYPE.equalsIgnoreCase(invoice.getCdInvoType())) {
      rejectionReason.setCdRejRsnRejItemId(Crjidtyp.CRJIDTYP_AD);
      AdminDtl adminDtl = adminDtlDAO.findAdminDtlByInvoiceIdnIdAdminDtl(invoiceOutbound.getIdLineItem(), invoice.getIdInvoice());
      if (adminDtl != null) {
        adminDtl.setIndAdminDtlRejItm("Y");
        adminDtlDAO.saveAdminDtl(adminDtl);
        
      }
    } else {
      rejectionReason.setCdRejRsnRejItemId(Crjidtyp.CRJIDTYP_DS);
      String cdSvcDtlService = buildNonNullString(invoiceOutbound.getCdSvcDtlService());
      DelvrdSvcDtl delvrdSvcDtl = delvrdSvcDtlDAO.findDelvrdSvcDtlByInvoiceIdnIdSvcDtl(invoiceOutbound.getIdLineItem(), invoice.getIdInvoice());
      if (delvrdSvcDtl != null && cdSvcDtlService.equalsIgnoreCase(buildNullString(delvrdSvcDtl.getCdSvcDtlService()))) {
        UpdateErrorSvcAuthDetail(delvrdSvcDtl);
        delvrdSvcDtl.setIndSvcDtlRejItem("Y");
        delvrdSvcDtlDAO.saveDelvrdSvcDtl(delvrdSvcDtl);
      }
    }
    
    //save off the rejection reason
    rejectionReason.setCdRejRsn(returnStatusCode(status));
    rejectionReason.setIdRejectedItemId(invoiceOutbound.getIdLineItem());
    rejectionReason.setInvoice(invoice);
    rejectionReasonDAO.saveUpdateRejectionReason(rejectionReason);
   
    // save off the invoice
    invoice.setCdInvoPhase(Cinvphse.CINVPHSE_REJ);

    invoiceDAO.saveOrUpdate(invoice);
    
    //save off the return
    SmileInvoiceSO smileInvoiceSO = new SmileInvoiceSO();
    smileInvoiceSO.setTransID(smileInvoiceSI.getUlTransactionId());
    return smileInvoiceSO;
  }
  private void populate_newRestrictedFunds(int idPerson, RestrictedFunds newRf, SmileInvoiceSI smileInvoiceSI) {

	  newRf.setAmtCheckBal(smileInvoiceSI.getLdRstrctFundChkBal());
	  newRf.setAmtSavBal(smileInvoiceSI.getLdRstrctFundSavBal());
	  newRf.setIdPerson(idPerson);
	  newRf.setPerson((Person) getPersistentObject(Person.class, idPerson));
  }
  
  private void UpdateErrorSvcAuthDetail(DelvrdSvcDtl delvrdSvcDtl){
    SvcAuthDetail svcAuthDetail = delvrdSvcDtl.getSvcAuthDetail();
    if (svcAuthDetail != null) {
      //roll back amt used
      double amtSvcAuthDtlAmtUsed = buildNonNullDouble(svcAuthDetail.getAmtSvcAuthDtlAmtUsed());
      double amtSvcDtlUnitRate = buildNonNullDouble(delvrdSvcDtl.getAmtSvcDtlUnitRate());
      double nbrSvcDtlUnitQty = buildNonNullDouble(delvrdSvcDtl.getNbrSvcDtlUnitQty());
      svcAuthDetail.setAmtSvcAuthDtlAmtUsed(amtSvcAuthDtlAmtUsed - (amtSvcDtlUnitRate * nbrSvcDtlUnitQty));
      
      //roll back unit used
      double nbrSvcAuthDtlUnitUsed = buildNonNullDouble(svcAuthDetail.getNbrSvcAuthDtlUnitUsed());
      svcAuthDetail.setNbrSvcAuthDtlUnitUsed(nbrSvcAuthDtlUnitUsed - nbrSvcDtlUnitQty);
      
      svcAuthDetailDAO.saveSvcAuthDetail(svcAuthDetail);
    }
  }

  private String buildMax10LengthString(String str) {
    return buildNLengthString(buildNonNullString(str), 10);
  }

  private String buildNLengthString(String str, int len) {
    String rtString = str;
    if (str.length() > len) {
      rtString = str.substring(0, len);
    }
    return rtString;
  }

  private String buildNonNullString(String str) {
    return (str != null ? str.trim() : "");
  }
    
  private String buildNullString(String str) {
    return (str != null ? str.trim() : null);
  }
  
  private double buildNonNullDouble(Double dbl) {
    return (dbl != null ? dbl : 0.0);
  }
  
  private String returnStatusCode(String returnStatus){
    String returnCode = Crjctrsn.CRJCTRSN_UI;
    if(RS_NO_CLIENT.equalsIgnoreCase(returnStatus)) {
      returnCode = Crjctrsn.CRJCTRSN_SC;
    } else if(RS_DUPL_INVCE.equalsIgnoreCase(returnStatus)) {
      returnCode = Crjctrsn.CRJCTRSN_SD;
    } else if(RS_NO_VENDOR.equalsIgnoreCase(returnStatus)) {
      returnCode = Crjctrsn.CRJCTRSN_SV;
    } else if(RS_INVPRGMEC.equalsIgnoreCase(returnStatus)) {
      returnCode = Crjctrsn.CRJCTRSN_SE;
    } 
    return returnCode;
  }
  

  private SmileInvoiceSO processVoidedInvoice(SmileInvoiceSI smileInvoiceSI, Invoice invoice,
                                               InvoiceOutbound invoiceOutbound, String status) {
    int idInvoice = smileInvoiceSI.getUlInvoiceId();
    // amount to add the invoice total, maybe the full line amt
    // or an adjusted if there a prev payment
    double amtSmilePaid = 0;

    // since we have inbound created check record, marked the invoice as void
    invoice.setCdInvoPhase(INVO_VOID);
    // reset values to si if values in database is prev null
    if (invoice.getNbrInvoWarrant() == null) {
      invoice.setNbrInvoWarrant(String.valueOf(smileInvoiceSI.getCheckNumber()));
    }

    String cdSvcDtlService = (invoiceOutbound.getCdSvcDtlService() != null) ? invoiceOutbound.getCdSvcDtlService()
                                                                                               .trim() : "";
    amtSmilePaid = updateDeliveredServiceDetail(smileInvoiceSI, idInvoice, invoiceOutbound.getIdLineItem(),
                                                  cdSvcDtlService, invoice.getCdInvoCounty(),status);
    

    // reset the invoice amt and save off the invoice
    double invAmt = invoice.getAmtInvoWarrant() != null ? invoice.getAmtInvoWarrant() : 0;
    invoice.setAmtInvoWarrant(invAmt + amtSmilePaid);
    invoiceDAO.saveOrUpdate(invoice);

    SmileInvoiceSO smileInvoiceSO = new SmileInvoiceSO();
    smileInvoiceSO.setTransID(smileInvoiceSI.getUlTransactionId());
    return smileInvoiceSO;
  }
  

  private SmileInvoiceSO processCancelledInvoice(SmileInvoiceSI smileInvoiceSI, Invoice invoice,
                                             InvoiceOutbound invoiceOutbound, String status) {
    String cdSvcDtlService = buildNonNullString(invoiceOutbound.getCdSvcDtlService());
    DelvrdSvcDtl delvrdSvcDtl = delvrdSvcDtlDAO.findDelvrdSvcDtlByInvoiceIdnIdSvcDtl(invoiceOutbound.getIdLineItem(), invoice.getIdInvoice());
    if (delvrdSvcDtl != null && cdSvcDtlService.equalsIgnoreCase(buildNullString(delvrdSvcDtl.getCdSvcDtlService()))) {
    	UpdateErrorSvcAuthDetail(delvrdSvcDtl);
    }
       
    // save off the invoice 
    invoice.setCdInvoPhase(Cinvphse.CINVPHSE_CAN);
    
    invoiceDAO.saveOrUpdate(invoice);
    
    //save off the return
    SmileInvoiceSO smileInvoiceSO = new SmileInvoiceSO();
    smileInvoiceSO.setTransID(smileInvoiceSI.getUlTransactionId());
    return smileInvoiceSO;
  }


}
