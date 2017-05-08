package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.financials.UpdateBudgets;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BudgetUpdateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.InvoiceLineItem;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BudgetUpdateSO;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class UpdateBudgetsImpl extends BaseServiceImpl implements UpdateBudgets {

  private AdminDtlDAO adminDtlDAO;

  private CaseBudgetLimitDAO caseBudgetLimitDAO;

  private ContractDAO contractDAO;

  private ContractServiceDAO contractServiceDAO;

  private DelvrdSvcDtlDAO delvrdSvcDtlDAO;

  private DynamicCountyBudgetLimitDAO dynamicCountyBudgetLimitDAO;

  private SvcAuthDetailDAO svcAuthDetailDAO;

  public void setAdminDtlDAO(AdminDtlDAO adminDtlDAO) {
    this.adminDtlDAO = adminDtlDAO;
  }

  public void setCaseBudgetLimitDAO(CaseBudgetLimitDAO caseBudgetLimitDAO) {
    this.caseBudgetLimitDAO = caseBudgetLimitDAO;
  }

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public void setDynamicCountyBudgetLimitDAO(DynamicCountyBudgetLimitDAO dynamicCountyBudgetLimitDAO) {
    this.dynamicCountyBudgetLimitDAO = dynamicCountyBudgetLimitDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public BudgetUpdateSO updateBudgets(BudgetUpdateSI si) {
    BudgetUpdateSO so = new BudgetUpdateSO();

    Collection<InvoiceLineItem> lineItems = si.getLineItems();
    if (lineItems != null && !lineItems.isEmpty()) {
      // -- invoice header values (declare once for all line items)
      int invoiceCheckNumber = si.getInvoiceCheckNumber();
      Date invoiceDatePaid = si.getInvoiceDatePaid();
      String invoiceCounty = si.getInvoiceCounty();
      boolean isContractBudgetLimit = false;
      int idContract = si.getIdContract();
      Contract contract = contractDAO.findContractTypes(idContract);
      if (contract != null) {
        isContractBudgetLimit = ArchitectureConstants.Y.equals(contract.getIndCntrctBudgLimit());
        contract = null;
      }

      Collection<String> caseBudgetServiceCodes;
      try {
        caseBudgetServiceCodes = Lookup.getCategoryCodesCollection(CodesTables.CSBGTLMT);
      } catch (LookupException le) {
        throw new IllegalStateException("Lookup data not properly initialized in UpdateBudgetsImpl", le);
      }

      for (InvoiceLineItem lineItem : lineItems) {
        // -- used in all conditions
        double amount = lineItem.getAmount();

        // -- update each line item with invoice payment info
        int id = lineItem.getId();
        if (id > 0) {
          if (lineItem.isAdmin()) {
            adminDtlDAO.updateAdminDtlAsPaid(id, invoiceCheckNumber, amount, invoiceDatePaid);
          } else {
            delvrdSvcDtlDAO.updateDelvrdSvcDtlAsPaid(id, invoiceCheckNumber, amount, invoiceDatePaid);
          }
        }

        // -- if contract has budget limit, update associated ContractService records
        String cdService = lineItem.getServiceCode();
        if (isContractBudgetLimit) {
          // -- determine beginning and end of given month/year
          Calendar cal = Calendar.getInstance();
          int year = lineItem.getYear();
          if (1835 < year && year < 4712) {
            cal.set(Calendar.YEAR, year);
          }
          int month = lineItem.getMonth();
          if (0 < month && month < 13) {
            cal.set(Calendar.MONTH, month - 1); // -- zero-indexed
          }
          cal.set(Calendar.DATE, 1);
          Date dtRangeStart = cal.getTime();
          cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
          Date dtRangeEnd = cal.getTime();

          contractServiceDAO.updateContractServiceForContractBudgetLimit(amount, idContract, cdService, dtRangeStart,
                                                                         dtRangeEnd, PAYABLE_CONTRACT_PERIOD_STATUS);
        }

        // -- if service auth, update SvcAuthDetail and CaseBudgetLimit
        int idSvcAuthDtl = lineItem.getIdSvcAuthDtl();
        boolean hasServiceAuth = idSvcAuthDtl > 0;
        SvcAuthDetail svcAuthDtl = new SvcAuthDetail();
        if (hasServiceAuth) {
          svcAuthDtl = svcAuthDetailDAO.findSvcAuthDetail(idSvcAuthDtl);
          svcAuthDetailDAO.updateSvcAuthDetailAddUsedValues(idSvcAuthDtl, lineItem.getUnits(), amount);
          String entCode = cdService.substring(0,5);
          if (caseBudgetServiceCodes.contains(cdService)) {
            //defect STGAP00005178: Added the if condition to update the amount balance instead
            //of amount Remaining if an invoice is paid against the terminated service authorization 
            if (DateHelper.isBefore(svcAuthDtl.getDtSvcAuthDtlTerm(), svcAuthDtl.getDtSvcAuthDtlEnd())) {
              caseBudgetLimitDAO.updateCaseBudgetLimitByIdSvcAuthDtlForTermDate(idSvcAuthDtl, cdService, amount);
            } else {
              caseBudgetLimitDAO.updateCaseBudgetLimitByIdSvcAuthDtl(idSvcAuthDtl, cdService, amount);
            }
          }
          //defect STGAP00005178:This is to update the entitlement code entry in the case budget limit
          //table when there is a change in the corresponding service code
          if(!entCode.equals(cdService) && caseBudgetServiceCodes.contains(entCode)){
            if (DateHelper.isBefore(svcAuthDtl.getDtSvcAuthDtlTerm(), svcAuthDtl.getDtSvcAuthDtlEnd())) {
              caseBudgetLimitDAO.updateCaseBudgetLimitByIdSvcAuthDtlForTermDate(idSvcAuthDtl, entCode, amount);
            } else {
              caseBudgetLimitDAO.updateCaseBudgetLimitByIdSvcAuthDtl(idSvcAuthDtl, entCode, amount);
            }
          }
        }

        // -- check county budget limit
        if (StringHelper.isValid(invoiceCounty) && cdService != null) {
          int decrementColumn = DynamicCountyBudgetLimitDAO.AMT_BALANCE;
          //defect STGAP00005178: Added the and clause in the if condition to update the amount balance instead
          //of amount Obligated if an invoice is paid against the terminated service authorization
          if (hasServiceAuth && !DateHelper.isBefore(svcAuthDtl.getDtSvcAuthDtlTerm(), svcAuthDtl.getDtSvcAuthDtlEnd())) {
            decrementColumn = DynamicCountyBudgetLimitDAO.AMT_OBG;
          }
          String program = cdService.length() > 3 ? cdService.substring(0, 3) : cdService;
          int fiscalYear = lineItem.getYear();
          if (lineItem.getMonth() > 6) { // -- July+ in next fiscal year
            fiscalYear += 1;
          }
          dynamicCountyBudgetLimitDAO.updateCountyBudgetLimitAmounts(invoiceCounty, program, fiscalYear, amount,
                                                                     decrementColumn);
        }
      }
    }

    return so;
  }
}

