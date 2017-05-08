package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PolicyWaiverDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCaseBudgetLimitList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseBudgetLimitSaveSO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SaveCaseBudgetLimitListImpl extends BaseServiceImpl implements SaveCaseBudgetLimitList {

  private ComplexCaseBudgetLimitDAO complexCaseBudgetLimitDAO = null;

  private PolicyWaiverDAO policyWaiverDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private EventDAO eventDAO = null;

  public void setComplexCaseBudgetLimitDAO(ComplexCaseBudgetLimitDAO complexCaseBudgetLimitDAO) {
    this.complexCaseBudgetLimitDAO = complexCaseBudgetLimitDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPolicyWaiverDAO(PolicyWaiverDAO policyWaiverDAO) {
    this.policyWaiverDAO = policyWaiverDAO;
  }

  @SuppressWarnings("unchecked")
  public CaseBudgetLimitSaveSO saveCaseBudgetLimitList(CaseBudgetLimitSaveSI csBdgtLmtSaveSI) throws ServiceException {
    CaseBudgetLimitSaveSO caseBudgetLimitSaveSO = new CaseBudgetLimitSaveSO();
    Map<String, List> svcCodesMap = new HashMap<String, List>();
    int idEvent = csBdgtLmtSaveSI.getUlIdEvent();
    Event event = eventDAO.findEventByIdEvent(idEvent);
    int idCase = csBdgtLmtSaveSI.getUlIdCase();
    // The modeIndicator value is set to 'COMP' if the service authorization detail is being
    // saved and modified when the corresponding service auth header is in Pending status.
    // The modeIndicator value is set to 'TRM' if the Service auth is in approved status and
    // the terminated date is being changed to an earlier date than the end date.
    // The modeIndicator value is set to 'PEND' when the service Auth is being submitted.
    // The ModeIndicator value is set to 'INVD' when the service Auth is being invalidated.
    // The ModeIndicator is set to 'REJT' when the service Auth is being rejected.
    String indicator = csBdgtLmtSaveSI.getModeIndicator();
    String svcDetailCode = csBdgtLmtSaveSI.getSvcCode();
    int idSvcAuth = csBdgtLmtSaveSI.getUlIdSvcAuth();
    ServiceAuthorization svcAuth = null;
    int idWaiver = 0;
    if (CodesTables.CEVTSTAT_COMP.equals(indicator) || CodesTables.CSVATYPE_TRM.equals(indicator)) {
      Map<String, List> svcDetAmtReqLmtHashmap = new HashMap<String, List>();
      List<Double> amtReqLmt = new ArrayList<Double>();
      String bdgtLmtString = Lookup.simpleDecodeSafe(CodesTables.CSBGTLMT, svcDetailCode);
      if (bdgtLmtString != null && !"".equals(bdgtLmtString)) {
        amtReqLmt.add(0, csBdgtLmtSaveSI.getAmtReq());
        amtReqLmt.add(1, Double.valueOf(bdgtLmtString));
        svcDetAmtReqLmtHashmap.put(svcDetailCode, amtReqLmt);
      }
      String entCode = svcDetailCode.substring(0, 5);
      String bdgtLmtEntCodeString = Lookup.simpleDecodeSafe(CodesTables.CSBGTLMT, entCode);
      if (!entCode.equals(svcDetailCode) && bdgtLmtEntCodeString != null && !"".equals(bdgtLmtEntCodeString)) {
        List<Double> amtReqLmt1 = new ArrayList<Double>();
        amtReqLmt1.add(0, csBdgtLmtSaveSI.getAmtReq());
        amtReqLmt1.add(1, Double.valueOf(bdgtLmtEntCodeString));
        svcDetAmtReqLmtHashmap.put(entCode, amtReqLmt1);
      }
      if (CodesTables.CEVTSTAT_COMP.equals(indicator)) {
        complexCaseBudgetLimitDAO.updateCaseBudgetLimit(idCase, idWaiver, svcDetAmtReqLmtHashmap);
      } else {
        String indRefRejected = csBdgtLmtSaveSI.getIndReferralRejection();
        double amtUsed = csBdgtLmtSaveSI.getAmtSpent();
        complexCaseBudgetLimitDAO.updateCaseBudgetLimitOnTerm(idCase, svcDetAmtReqLmtHashmap, indRefRejected, amtUsed);
      }

    } else {
      if (!CodesTables.CEVNTTYP_WVR.equals(event.getCdEventType())) {

        if (CodesTables.CEVTSTAT_PEND.equals(csBdgtLmtSaveSI.getModeIndicator())) {
          svcAuth = serviceAuthorizationDAO.findServiceAuth(idSvcAuth);

        } else {
          svcAuth = serviceAuthorizationDAO.findServiceAuthEventLink(idEvent);

        }
        if (svcAuth == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        idSvcAuth = svcAuth.getIdSvcAuth();
        String svcCode = svcAuth.getCdSvcAuthCategory() + svcAuth.getCdSvcAuthService();
        svcCodesMap = getSvcCodesList(idWaiver, idSvcAuth, svcCode, indicator);
        // STGAP00008188 there are two different processes that update the Case BudgetLimit... Service Auth and
        // Policy Waiver. If this is a Service Auth then the policy waiver should not be updated.
        if (!svcCodesMap.isEmpty()) {
          if (!CodesTables.CEVTSTAT_PEND.equals(indicator)) {
            complexCaseBudgetLimitDAO.updateCaseBudgetLimitOnApproval(idCase, svcCodesMap, indicator, idWaiver);
          } else {
            complexCaseBudgetLimitDAO.updateCaseBudgetLimit(idCase, idWaiver, svcCodesMap);
          }
        }
      } else {
        PolicyWaiver plcWaiver = policyWaiverDAO.findPolicyWaiverByIdEvent(idEvent);
        if (plcWaiver == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        String svcCode;
        if (plcWaiver.getCdWvrSvcDesc() == null) {
          svcCode = plcWaiver.getCdWvrUasCd() + plcWaiver.getCdWvrEntCd();
        } else {
          svcCode = plcWaiver.getCdWvrSvcDesc();
        }
        svcCodesMap = getSvcCodesList(idEvent, plcWaiver, svcCode, indicator);
        if (!CodesTables.CEVTSTAT_PEND.equals(indicator)) {
          complexCaseBudgetLimitDAO.updateCaseBudgetLimitOnApproval(idCase, svcCodesMap, indicator, idEvent);
        } else {
          complexCaseBudgetLimitDAO.updateCaseBudgetLimit(idCase, idEvent, svcCodesMap);
        }

      }

    }
    return caseBudgetLimitSaveSO;
  }

  private Map<String, List> getSvcCodesList(int idEvent, PolicyWaiver plcWaiver, String svcCode, String indicator) {
    List<String> svcCodeList = new ArrayList<String>();
    Map<String, List> svcCodeAmtReqLmtHashmap = new HashMap<String, List>();
    String groupItem = plcWaiver.getCdWvrUasCd() + plcWaiver.getCdWvrEntCd();
    String lineItem = plcWaiver.getCdWvrSvcDesc();
    svcCodeList.add(groupItem);
    svcCodeList.add(lineItem);
    for (Iterator it = svcCodeList.iterator(); it.hasNext();) {
      String servCode = (String) it.next();
      String bdgtLimit = Lookup.simpleDecodeSafe(CodesTables.CSBGTLMT, servCode);
      //STGAP00012636: Commented this line as amountReq was never used and this was throwing NPE while approving a 
      // Policy Waiver that was created in a FAD stage.
      // double amountReq = plcWaiver.getAmtWvr(); 
      if (!"".equals(bdgtLimit)) {
        List<Double> amtReqLmt = new ArrayList<Double>();
        amtReqLmt.add(0, 0.0);
        amtReqLmt.add(1, Double.valueOf(bdgtLimit));
        svcCodeAmtReqLmtHashmap.put(servCode, amtReqLmt);
      }

    }
    return svcCodeAmtReqLmtHashmap;
  }

  @SuppressWarnings("unchecked")
  private Map<String, List> getSvcCodesList(int idEvent, int idSvcAuth, String svcCode, String indicator) {

    List<String> svcCodeList = new ArrayList<String>();
    Map<String, List> svcCodeAmtReqLmtHashmap = new HashMap<String, List>();
    svcCodeList = svcAuthDetailDAO.findDistinctSvcCodes(idSvcAuth);
    double totalAmtReq = 0.0;
    for (Iterator it = svcCodeList.iterator(); it.hasNext();) {
      String servCode = (String) it.next();
      String bdgtLimit = Lookup.simpleDecodeSafe(CodesTables.CSBGTLMT, servCode);
      List<SvcAuthDetail> svcAuthDtlList = svcAuthDetailDAO.findSvcAuthDetailByIdSvcAuthBySvcCode(idSvcAuth, servCode);
      if (svcAuthDtlList != null) {
        // loop through all the service auth detail records for the current combination of service auth and
        // service code
        // and add the amount requested.
        double amountReq = 0.0;
        for (Iterator itSvc = svcAuthDtlList.iterator(); itSvc.hasNext();) {
          SvcAuthDetail svcAuthDetail = (SvcAuthDetail) itSvc.next();
          amountReq = amountReq + svcAuthDetail.getAmtSvcAuthDtlAmtReq();
        }
        totalAmtReq = totalAmtReq + amountReq;
        if (!"".equals(bdgtLimit)) {
          List<Double> amtReqLmt = new ArrayList<Double>();
          amtReqLmt.add(0, amountReq);
          amtReqLmt.add(1, Double.valueOf(bdgtLimit));
          svcCodeAmtReqLmtHashmap.put(servCode, amtReqLmt);
        }
      }
    }
    if (svcCodeAmtReqLmtHashmap.containsKey(svcCode)) {

      List<Double> amtReqLmt = new ArrayList<Double>();
      amtReqLmt = svcCodeAmtReqLmtHashmap.get(svcCode);
      amtReqLmt.set(0, totalAmtReq);
      svcCodeAmtReqLmtHashmap.remove(svcCode);
      svcCodeAmtReqLmtHashmap.put(svcCode, amtReqLmt);
    } else {
      String budgetLimit = Lookup.simpleDecodeSafe(CodesTables.CSBGTLMT, svcCode);
      if (!"".equals(budgetLimit)) {
        List<Double> totalAmtReqLmt = new ArrayList<Double>();
        totalAmtReqLmt.add(0, totalAmtReq);
        totalAmtReqLmt.add(1, Double.valueOf(budgetLimit));
        svcCodeAmtReqLmtHashmap.put(svcCode, totalAmtReqLmt);
      }
    }
    return svcCodeAmtReqLmtHashmap;
  }
}
