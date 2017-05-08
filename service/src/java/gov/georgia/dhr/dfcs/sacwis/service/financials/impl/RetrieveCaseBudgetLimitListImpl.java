package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveCaseBudgetLimitList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseBudgetLimitRetrieveSO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** @author vishala devarakonda */

public class RetrieveCaseBudgetLimitListImpl extends BaseServiceImpl implements RetrieveCaseBudgetLimitList {

  private CaseBudgetLimitDAO caseBudgetLimitDAO = null;

  public void setCaseBudgetLimitDAO(CaseBudgetLimitDAO caseBudgetLimitDAO) {
    this.caseBudgetLimitDAO = caseBudgetLimitDAO;
  }

  @SuppressWarnings("unchecked")
  public CaseBudgetLimitRetrieveSO retrieveCaseBudgetLimitList(CaseBudgetLimitRetrieveSI caseBudgetLimitRetrieveSI) {
    CaseBudgetLimitRetrieveSO caseBudgetLimitRetrieveSO = new CaseBudgetLimitRetrieveSO();
    List<CaseBudgetLimit> caseBudgetLimitList = new ArrayList<CaseBudgetLimit>();
    int idCase = caseBudgetLimitRetrieveSI.getUlIdCase();
    if (idCase != 0) {

      caseBudgetLimitList = caseBudgetLimitDAO.findCaseBudgetLimitListByIdCase(idCase);
    }
    // It is possible for a case to not have any
    // rows in the case budget limit list table.
    // Therefore we will not handle SQL_NOT_FOUND.
    List<CaseBudgetLimitBean> caseBudgetLimitBeanList = new ArrayList<CaseBudgetLimitBean>();
    if (caseBudgetLimitList != null && !caseBudgetLimitList.isEmpty()) {
      for (Iterator it = caseBudgetLimitList.iterator(); it.hasNext();) {
        CaseBudgetLimit caseBudgetLimit = (CaseBudgetLimit) it.next();
        CaseBudgetLimitBean caseBudgetLimitRow = new CaseBudgetLimitBean();
        caseBudgetLimitRow.setAmtBalance(caseBudgetLimit.getAmtBalance());
        caseBudgetLimitRow.setAmtBudgt(caseBudgetLimit.getAmtBudgt());
        caseBudgetLimitRow.setAmtRemain(caseBudgetLimit.getAmtRemain());
        caseBudgetLimitRow.setAmtSpent(caseBudgetLimit.getAmtSpent());
        caseBudgetLimitRow.setCdSvcCode(caseBudgetLimit.getId().getCdSvcCode());
        caseBudgetLimitRow.setAmtPendAuth(caseBudgetLimit.getAmtPendAuth());
        caseBudgetLimitRow.setAmtWaiver(caseBudgetLimit.getAmtWaiver());
        caseBudgetLimitRow.setIdCase(caseBudgetLimit.getId().getIdCase());
        caseBudgetLimitBeanList.add(caseBudgetLimitRow);
      }

    }
    caseBudgetLimitRetrieveSO.setCaseBudgetLimitList(caseBudgetLimitBeanList);
    return caseBudgetLimitRetrieveSO;
  }
}
