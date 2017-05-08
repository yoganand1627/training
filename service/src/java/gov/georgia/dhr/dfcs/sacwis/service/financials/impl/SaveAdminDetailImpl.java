package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveAdminDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN16SO;

public class SaveAdminDetailImpl extends BaseServiceImpl implements SaveAdminDetail {

  private InvoiceDAO invoiceDAO = null;

  private AdminDtlDAO adminDtlDAO = null;

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public void setAdminDtlDAO(AdminDtlDAO adminDtlDAO) {
    this.adminDtlDAO = adminDtlDAO;
  }

  public CFIN16SO saveAdminDetail(CFIN16SI cfin16si) throws ServiceException {
    CFIN16SO cfin16so = new CFIN16SO();
    // Declare local variables
    int usRow = 0;
    int usInputRow;
    // request function code is by default set to ServiceConstants.REQ_FUNC_CD_UPDATE
    if (0 != cfin16si.getSzCdInvoPhase().compareTo(FIN_CD_INVO_PHASE_PEND)) {
      cfin16si.setSzCdInvoPhase(FIN_CD_INVO_PHASE_PEND);
    }

    int inputInvoiceId = cfin16si.getUlIdInvoInvoice();
    // caud44dAUDdam() converted to invoiceDAO.findInvoiceDtInvoEntryCompletedByIdInvoice();
    Date invoiceCompletionDate = invoiceDAO.findInvoiceDtInvoEntryCompletedByIdInvoice(inputInvoiceId);
    String reqFuncCDUpdate = ServiceConstants.REQ_FUNC_CD_UPDATE;
    int updateInvPhaseCnt = 0;
    if(!ArchitectureConstants.Y.equals(cfin16si.getCIndCopiedInv())){
    // following if statement is unecessary now but will permit multiple conditions in the future
    if (reqFuncCDUpdate.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
      if (invoiceCompletionDate != null) {
        updateInvPhaseCnt = invoiceDAO.updateInvoice(inputInvoiceId, cfin16si.getSzCdInvoPhase(),
                                                     cfin16si.getTsSysTsLastUpdate2());
      } else {
        updateInvPhaseCnt = invoiceDAO.updateInvoiceSetIdInvoiceAndCdInvoPhase(inputInvoiceId,
                                                                               cfin16si.getSzCdInvoPhase(),
                                                                               cfin16si.getTsSysTsLastUpdate2());
      }
    }

    if (updateInvPhaseCnt == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    // get the new update timestamp
    cfin16so.setTsLastUpdate(invoiceDAO.findInvoiceDtLastUpdate(inputInvoiceId));
    }
    // Only call CMSC13D if the previous DAM was successful. This service is called
    // two times to check the number of reversals and adjustments
    // This does a count by idInvoice all items of a particular CD SVC DTL LI TYPE.
    // cmsc13dQUERYdam() converted to adminDtlDAO.countAdminDtlIdAdminDtl();
    // find the number of reversals for that invoice
    String adminDtlLiType = REVERSAL_LI;
    int revAdjInvoiceId = cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usRow).getUlIdInvoInvoice();
    long iRevCounter = adminDtlDAO.countAdminDtlIdAdminDtl(revAdjInvoiceId, adminDtlLiType);
    // call DAM
    // rc = cmsc13dQUERYdam(sqlca, pCMSC13DInputRec, pCMSC13DOutputRec);
    // find the number of adustments for the same invoice
    adminDtlLiType = ADJUSTMENT_LI;
    long iAdjCounter = adminDtlDAO.countAdminDtlIdAdminDtl(revAdjInvoiceId, adminDtlLiType);

    int pageSizeNbr = cfin16si.getArchInputStruct().getUlPageSizeNbr();
    for (usInputRow = 0; (usInputRow < pageSizeNbr); usInputRow++) {
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow)
                                                          .getSzCdScrDataAction())) {
        if (!(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdAdminDtlLiType()
                      .compareTo(REVERSAL_LI) != 0)) {
          iRevCounter++;
        }

        // SVC AUTH ENH -- modified if condition below to consider
        // MODIFY mode due to enhancement.
        if (!(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdAdminDtlLiType()
                      .compareTo(ADJUSTMENT_LI) != 0)) {
          iAdjCounter++;
        }
      }
    } // end for loop

    for (usInputRow = 0; usInputRow < pageSizeNbr; usInputRow++) {

      ROWCFIN16SIG00 rowcfin16sig00 = cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow);

      // adminDtlDAO.updateAdminDtl() replaces caud48dAUDdam(sqlca, pCAUD48DInputRec, pCAUD48DOutputRec);
      // because the request function is an udpate (see above) == REQ_FUNC_CD_UPDATE
      if (rowcfin16sig00.getUlIdAdminDtl() != 0) {
        int updateDtlCnt = adminDtlDAO.updateAdminDtl(rowcfin16sig00.getUlIdAdminDtl(),
                                                      rowcfin16sig00.getUlIdInvoInvoice(),
                                                      rowcfin16sig00.getDAmtAdminDtlAdminAlloc(),
                                                      rowcfin16sig00.getDAmtAdminDtlEquipment(),
                                                      rowcfin16sig00.getDAmtAdminDtlFrgBenft(),
                                                      rowcfin16sig00.getDAmtAdminDtlOffsetItem(),
                                                      rowcfin16sig00.getDAmtAdminDtlOther(),
                                                      rowcfin16sig00.getDAmtAdminDtlSalaries(),
                                                      rowcfin16sig00.getDAmtAdminDtlSupplies(),
                                                      rowcfin16sig00.getDAmtAdminDtlTravel(),
                                                      rowcfin16sig00.getSzCdAdminDtlService(),
                                                      rowcfin16sig00.getSzCdAdminDtlInvoDisptn(),
                                                      rowcfin16sig00.getSzCdAdminDtlLiType(),
                                                      rowcfin16sig00.getCIndAdminDtlRejItm(),
                                                      rowcfin16sig00.getUMoAdminDtlSvcMonth(),
                                                      rowcfin16sig00.getUsNbrAdminDtlCsli(),
                                                      rowcfin16sig00.getUYrAdminDtlSvcYear(),
                                                      rowcfin16sig00.getTsLastUpdate(),
                                                      rowcfin16sig00.getSzCdCounty(),
                                                      rowcfin16sig00.getDAmtAdminDtlPromotional(),
                                                      rowcfin16sig00.getSzAdmDtlComments());
        if (updateDtlCnt == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else {
        // do an insert
        adminDtlDAO.insertAdminDtl(0, rowcfin16sig00.getTsLastUpdate(),rowcfin16sig00.getUlIdInvoInvoice(), rowcfin16sig00.getDAmtAdminDtlAdminAlloc(),
                                   rowcfin16sig00.getDAmtAdminDtlEquipment(),rowcfin16sig00.getDAmtAdminDtlFrgBenft(),rowcfin16sig00.getDAmtAdminDtlOffsetItem(),
                                   rowcfin16sig00.getDAmtAdminDtlOther(),rowcfin16sig00.getDAmtAdminDtlSalaries(),rowcfin16sig00.getDAmtAdminDtlSupplies(),
                                   rowcfin16sig00.getDAmtAdminDtlTravel(),rowcfin16sig00.getSzCdAdminDtlService(),rowcfin16sig00.getSzCdAdminDtlInvoDisptn(),
                                   rowcfin16sig00.getSzCdAdminDtlLiType(), rowcfin16sig00.getCIndAdminDtlRejItm(), rowcfin16sig00.getUMoAdminDtlSvcMonth(),
                                   rowcfin16sig00.getUsNbrAdminDtlCsli(), rowcfin16sig00.getUYrAdminDtlSvcYear(),rowcfin16sig00.getSzCdCounty(),rowcfin16sig00.getDAmtAdminDtlPromotional(),rowcfin16sig00.getSzAdmDtlComments());
      }
    } // end 2nd for loop
    return cfin16so;
  }

}
