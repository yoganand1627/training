package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CostReimDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCostReimbursementDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN14SO;

public class SaveCostReimbursementDetailImpl extends BaseServiceImpl implements SaveCostReimbursementDetail {

  private DelvrdSvcDtlDAO delvrdSvcDtlDAO = null;

  private CostReimDtlDAO costReimDtlDAO = null;

  private InvoiceDAO invoiceDAO = null;

  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public void setCostReimDtlDAO(CostReimDtlDAO costReimDtlDAO) {
    this.costReimDtlDAO = costReimDtlDAO;
  }

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public CFIN14SO saveCostReimbursementDetail(CFIN14SI cfin14si) throws ServiceException {
    /*
     * * Declare local variables
     */
    CFIN14SO cfin14so = new CFIN14SO();
    String action = null;

    Enumeration inputList = cfin14si.getROWCFIN14SIG_ARRAY().enumerateROWCFIN14SIG();
    if (inputList != null) {
      while (inputList.hasMoreElements()) {
        ROWCFIN14SIG rowcfin14sg = (ROWCFIN14SIG) inputList.nextElement();
        action = rowcfin14sg.getSzCdScrDataAction();

        // convert caud53dAUDdam() to either costReimDtlDAO.insertCostReimDtl() or costReimDtlDAO.updateCostReimDtl()
        int resultCnt = 0;
        if (action.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
          resultCnt = costReimDtlDAO.insertCostReimDtl(rowcfin14sg.getTsLastUpdate(), cfin14si.getUlIdInvoInvoice(),
                                                       rowcfin14sg.getDAmtCostReimAdminAll(),
                                                       rowcfin14sg.getDAmtCostReimEquip(),
                                                       rowcfin14sg.getDAmtCostReimFrgBenft(),
                                                       rowcfin14sg.getDAmtCostReimOffItem(),
                                                       rowcfin14sg.getDAmtCostReimDtlOther(),
                                                       rowcfin14sg.getDAmtCostReimSalary(),
                                                       rowcfin14sg.getDAmtCostReimSupply(),
                                                       rowcfin14sg.getDAmtCostReimTravel(),
                                                       rowcfin14sg.getSzCdCostReimInvoDisptn(),
                                                       rowcfin14sg.getSzCdCostReimService(),
                                                       rowcfin14sg.getSzCdCostReimLiType(),
                                                       rowcfin14sg.getCIndCostReimRejItm(),
                                                       rowcfin14sg.getUsNbrCostReimCsli(),
                                                       (int) rowcfin14sg.getUNbrCostReimUnitQty());
        } else if (action.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
          resultCnt = costReimDtlDAO.updateCostReimDtl(rowcfin14sg.getUlIdCostReim(), cfin14si.getUlIdInvoInvoice(),
                                                       rowcfin14sg.getDAmtCostReimAdminAll(),
                                                       rowcfin14sg.getDAmtCostReimEquip(),
                                                       rowcfin14sg.getDAmtCostReimFrgBenft(),
                                                       rowcfin14sg.getDAmtCostReimOffItem(),
                                                       rowcfin14sg.getDAmtCostReimDtlOther(),
                                                       rowcfin14sg.getDAmtCostReimSalary(),
                                                       rowcfin14sg.getDAmtCostReimSupply(),
                                                       rowcfin14sg.getDAmtCostReimTravel(),
                                                       rowcfin14sg.getSzCdCostReimInvoDisptn(),
                                                       rowcfin14sg.getSzCdCostReimService(),
                                                       rowcfin14sg.getSzCdCostReimLiType(),
                                                       rowcfin14sg.getCIndCostReimRejItm(),
                                                       rowcfin14sg.getUsNbrCostReimCsli(),
                                                       (int) rowcfin14sg.getUNbrCostReimUnitQty(),
                                                       rowcfin14sg.getTsLastUpdate());
        } // end if/else action.equals either request is add/update

        if (resultCnt == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }

        if (action.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
          /*
           * * Call CMSC21D to update DELVRD SVC DTL
           */
          // convert cmsc21dAUDdam() to delvrdSvcDtlDAO.updateDelvrdSvcDtlamtSvcDtlUnitRate()
          /*
           * * SIR 3771 - Changed .005 to .0005 to avoid rounding errors in * small dollar fee calculations. BSM
           */
          int updateCnt = delvrdSvcDtlDAO
                  .updateDelvrdSvcDtlamtSvcDtlUnitRate(
                          rowcfin14sg.getDScrAmtCostReimCmpUrt() + .0005,
                          cfin14si.getUlIdInvoInvoice(),
                          rowcfin14sg.getUsNbrCostReimCsli(),
                          rowcfin14sg.getSzCdCostReimLiType(),
                          cfin14si.getTsSysTsLastUpdate2());
          if (updateCnt == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          } // end if (updateCnt == 0)
        } // end if update
      } // end while (inputList.hasMoreElements())

      /*
       * * If CFIN14SI szCdInvoPhase != FIN_CD_INVO_PHASE_PEND and * above code is successful, set Invoice back to
       * pending
       */
      if ((FIN_CD_INVO_PHASE_PEND1 != cfin14si.getSzCdInvoPhase())) {
        int invoiceId = cfin14si.getUlIdInvoInvoice();
        String invoPhase = FIN_CD_INVO_PHASE_PEND1;
        Date invEntryCompletedDate = invoiceDAO.findInvoiceDtInvoEntryCompletedByIdInvoice(invoiceId);
        int updateCnt2 = 0;

        if (action != null && action.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
          /*
           ** Call CAUD44D to update the status of an invoice
           */
          // convert caud44dAUDdam() to either invoiceDAO.updateInvoice() or
          // invoiceDAO.updateInvoiceSetIdInvoiceAndCdInvoPhase()
          if (invEntryCompletedDate != null) {
            updateCnt2 = invoiceDAO.updateInvoice(invoiceId, invoPhase, cfin14si.getTsSysTsLastUpdate2());
          } else {
            updateCnt2 = invoiceDAO.updateInvoiceSetIdInvoiceAndCdInvoPhase(invoiceId, invoPhase,
                                                                            cfin14si.getTsSysTsLastUpdate2());
          } // end if/else (invEntryCompletedDate != null)
          // update the output with the new update time stamp
          cfin14so.setTsLastUpdate(invoiceDAO.findInvoiceDtLastUpdate(invoiceId));
        } // end if action.equals(REQ_FUNC_CD_UPDATE)

        if (updateCnt2 == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } // end if ((FIN_CD_INVO_PHASE_PEND1 != cfin14si.getSzCdInvoPhase())
    } // end if (inputList != null)

    return cfin14so;
  } // end saveCostReimbursementDetail

}
