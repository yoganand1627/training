/**
 * Created on April 12, 2007 by Vishala Devarakonda
 * 
 * 
 *   Change History: 
 *   Date        User         Description
 *   ---------   -----------  -----------------------------------------------------------------
 *   07/08/2008  Cwells       STGAP00008188 - Added logic to take the Policy Waiver amount in 
 *                            consideration for the Case Budget Limit amount.  
 *   10/03/2008  alwilliams   STGAP00010049 - Updated the updateCaseBudgetLimitOnApproval method to
 *                            insert a new case budget limit record if one does not exist for
 *                            this case.
 *  
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseBudgetLimitWaiverDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PolicyWaiverDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimitWaiver;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimitId;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComplexCaseBudgetLimitDAOImpl extends BaseDAOImpl implements ComplexCaseBudgetLimitDAO {

  private CaseBudgetLimitDAO caseBudgetLimitDAO = null;

  private PolicyWaiverDAO policyWaiverDAO = null;

  private EventDAO eventDAO = null;

  private CaseBudgetLimitWaiverDAO caseBudgetLimitWaiverDAO = null;

  public void setCaseBudgetLimitDAO(CaseBudgetLimitDAO caseBudgetLimitDAO) {
    this.caseBudgetLimitDAO = caseBudgetLimitDAO;
  }

  public void setPolicyWaiverDAO(PolicyWaiverDAO policyWaiverDAO) {
    this.policyWaiverDAO = policyWaiverDAO;
  }

  public void setCaseBudgetLimitWaiverDAO(CaseBudgetLimitWaiverDAO caseBudgetLimitWaiverDAO) {
    this.caseBudgetLimitWaiverDAO = caseBudgetLimitWaiverDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  // This method is called to insert a new row or update an existing row in CaseBudgetLimit table
  public void updateCaseBudgetLimit(int idCase, int waiverId, Map<String, List> svcAmtReqLmt) {
    if (!svcAmtReqLmt.isEmpty()) {
      Set codesSet = svcAmtReqLmt.keySet();
      for (Iterator it = codesSet.iterator(); it.hasNext();) {
        String cdSvcAuthCode = (String) it.next();
        CaseBudgetLimit csBLmt = new CaseBudgetLimit();
        CaseBudgetLimitId cCaseBId = new CaseBudgetLimitId();
        CapsCase cCase = new CapsCase();
        double amtWaived = 0.0;
        List amtReqList = svcAmtReqLmt.get(cdSvcAuthCode);
        double amtPend = (Double) amtReqList.get(0);
        double amtBudgeted = (Double) amtReqList.get(1);
        boolean policyWaiver = false;
        String waiverType = "";
        cCase = (CapsCase) getSession().load(CapsCase.class, idCase);
        csBLmt = caseBudgetLimitDAO.findByIdCaseBySvcCode(idCase, cdSvcAuthCode);
        Event waiverEvent = eventDAO.findEventByIdEvent(waiverId);
        if (waiverEvent != null) {
          waiverType = waiverEvent.getCdEventType();
        }
        if (CodesTables.CEVNTTYP_WVR.equals(waiverType)) {
          policyWaiver = true;
        }
        if (policyWaiver) {
          // Only doing waiver amount when Policy waiver is being sent for approval.
          amtWaived = updateBudgetLimitWaiverAmt(waiverId, cdSvcAuthCode);
        }
        if (waiverId != 0 && amtWaived != 0.0) {
          CaseBudgetLimitWaiver bdgtLmtWaiver = new CaseBudgetLimitWaiver();
          bdgtLmtWaiver.setCapsCase(cCase);
          bdgtLmtWaiver.setCdSvcCode(cdSvcAuthCode);
          bdgtLmtWaiver.setIdWaiver(waiverId);
          // bdgtLmtWaiver.setDtLastUpdate(sysDate);
          caseBudgetLimitWaiverDAO.saveCaseBudgetLimitWaiver(bdgtLmtWaiver);
        } else {
          amtWaived = getWaiverAmount(waiverId, cdSvcAuthCode);
        }
        cCaseBId.setIdCase(idCase);
        cCaseBId.setCdSvcCode(cdSvcAuthCode);
        if (csBLmt != null) {
          if (amtPend > csBLmt.getAmtBalance()) {
            throw new ServiceException(Messages.MSG_BUDGET_EXCEEDED);
          }
          double csbAmtWaived = getWaiverAmount(waiverId, cdSvcAuthCode);
          double amtBalance;
          if (policyWaiver) {
            amtBalance = csBLmt.getAmtBalance() + csbAmtWaived - amtPend;
          } else {
            amtBalance = csBLmt.getAmtBalance() - amtPend;
          }
          double amtPendAuth = csBLmt.getAmtPendAuth() + amtPend;
          if (policyWaiver) {
            double amtWaiver = csBLmt.getAmtWaiver() + csbAmtWaived;
            csBLmt.setAmtWaiver(amtWaiver);
          }
          csBLmt.setAmtBalance(amtBalance);
          csBLmt.setAmtPendAuth(amtPendAuth);

        } else {
          csBLmt = new CaseBudgetLimit();
          if (amtPend > amtBudgeted) {
            throw new ServiceException(Messages.MSG_BUDGET_EXCEEDED);
          }
          csBLmt.setId(cCaseBId);
          csBLmt.setAmtBalance(amtBudgeted + amtWaived - amtPend);
          csBLmt.setAmtBudgt(amtBudgeted);
          csBLmt.setAmtRemain(0.0);
          csBLmt.setAmtSpent(0.0);
          csBLmt.setAmtWaiver(amtWaived);
          csBLmt.setAmtPendAuth(amtPend);
        }
        csBLmt.setCapsCase(cCase);
        caseBudgetLimitDAO.saveCaseBudgetLimit(csBLmt);
      }

    }
  }

  // This method updates the Corresponding rows in CaseBudgetLimit when the service Auth is approved, rejected or
  // invalidated.
  public void updateCaseBudgetLimitOnApproval(int idCase, Map<String, List> svcCodeAmtReqHashmap, String indicator,
                                              int idWaiver) {
    CapsCase cCase = new CapsCase();
    cCase = (CapsCase) getSession().load(CapsCase.class, idCase);
    Set codesSet = svcCodeAmtReqHashmap.keySet();
    for (Iterator it = codesSet.iterator(); it.hasNext();) {
      String svcCode = (String) it.next();
      List amtReqList = svcCodeAmtReqHashmap.get(svcCode);
      double amtReq = (Double) amtReqList.get(0);
      CaseBudgetLimitId cCaseBId = new CaseBudgetLimitId();
      cCaseBId.setIdCase(idCase);
      cCaseBId.setCdSvcCode(svcCode);
      CaseBudgetLimit csBdgtLmt = (CaseBudgetLimit) getSession().load(CaseBudgetLimit.class, cCaseBId);

      // STGAP00010049 - Insert a new case budget limit entry if one does not exist for this case and 
      // service code
      CaseBudgetLimit csBdgtLmtRec = caseBudgetLimitDAO.findByIdCaseBySvcCode(idCase, svcCode);      
      if (csBdgtLmtRec != null) {
        csBdgtLmt.setAmtPendAuth(csBdgtLmtRec.getAmtPendAuth() - amtReq);
        if (CodesTables.CAPPDESG_REJT.equals(indicator) || CodesTables.CAPPDESG_INVD.equals(indicator)) {
          double amtWaived = getWaiverAmount(idWaiver, svcCode);
          boolean policyWaiver = false;
          Event waiverEvent = eventDAO.findEventByIdEvent(idWaiver);
          String WaiverEventType = waiverEvent != null ? waiverEvent.getCdEventType() : "";
          if (CodesTables.CEVNTTYP_WVR.equals(WaiverEventType)) {
            policyWaiver = true;
          }
          if (policyWaiver) {
            csBdgtLmt.setAmtWaiver(csBdgtLmtRec.getAmtWaiver() - amtWaived);
            csBdgtLmt.setAmtBalance(csBdgtLmtRec.getAmtBalance() + amtReq - amtWaived);
          }
          csBdgtLmt.setAmtBalance(csBdgtLmtRec.getAmtBalance() + amtReq);
        } else {
          csBdgtLmt.setAmtRemain(csBdgtLmt.getAmtRemain() + amtReq);
        }
      } else {
        csBdgtLmt = new CaseBudgetLimit();
        double amtWaived = 0.0;
        double amtPend = (Double) amtReqList.get(0);
        double amtBudgeted = (Double) amtReqList.get(1); 
        if (amtPend > amtBudgeted) {
          throw new ServiceException(Messages.MSG_BUDGET_EXCEEDED);
        }        
        csBdgtLmt.setId(cCaseBId);
        csBdgtLmt.setAmtBalance(amtBudgeted + amtWaived - amtPend);
        csBdgtLmt.setAmtBudgt(amtBudgeted);
        csBdgtLmt.setAmtRemain(0.0);
        csBdgtLmt.setAmtSpent(0.0);
        csBdgtLmt.setAmtWaiver(amtWaived);
        csBdgtLmt.setAmtPendAuth(amtPend);        
      }        
      csBdgtLmt.setCapsCase(cCase);
      caseBudgetLimitDAO.saveCaseBudgetLimit(csBdgtLmt);
    }

  }

  // This method updates the corresponding row in CaseBudgetLimit when the service auth is terminated or
  // rejected by the service provider
  public void updateCaseBudgetLimitOnTerm(int idCase, Map<String, List> svcAmtReqLmtMap, String indRefReject,
                                          double amtUsed) {
    if (!svcAmtReqLmtMap.isEmpty()) {
      Set codesSet = svcAmtReqLmtMap.keySet();
      for (Iterator it = codesSet.iterator(); it.hasNext();) {
        String cdSvcAuthCode = (String) it.next();
        CaseBudgetLimit csBLmt = new CaseBudgetLimit();
        CaseBudgetLimitId cCaseBId = new CaseBudgetLimitId();
        CapsCase cCase = new CapsCase();
        List amtReqList = svcAmtReqLmtMap.get(cdSvcAuthCode);
        double amtReq = (Double) amtReqList.get(0);
        cCase = (CapsCase) getSession().load(CapsCase.class, idCase);
        csBLmt = caseBudgetLimitDAO.findByIdCaseBySvcCode(idCase, cdSvcAuthCode);
        cCaseBId.setIdCase(idCase);
        cCaseBId.setCdSvcCode(cdSvcAuthCode);
        if (ArchitectureConstants.Y.equals(indRefReject) && amtUsed == 0.00) {
          csBLmt.setAmtBalance(csBLmt.getAmtBalance() + amtReq);
          csBLmt.setAmtRemain(csBLmt.getAmtRemain() - (amtReq - amtUsed));
        } else {
          // STGAP00005178
          csBLmt.setAmtBalance(csBLmt.getAmtBalance() + (amtReq - amtUsed));
          csBLmt.setAmtRemain(csBLmt.getAmtRemain() - (amtReq - amtUsed));
        }
        csBLmt.setCapsCase(cCase);
        caseBudgetLimitDAO.saveCaseBudgetLimit(csBLmt);
      }
    }
  }

  private double getWaiverAmount(int idWaiver, String cdSvcAuthCode) {
    double amtWaived = 0.0;
    String progEntCode = "";
    String svcCode = "";
    if (idWaiver != 0) {
      PolicyWaiver plcWaiver = policyWaiverDAO.findPolicyWaiverByIdEvent(idWaiver);
      progEntCode = plcWaiver.getCdWvrUasCd() + plcWaiver.getCdWvrEntCd();
      svcCode = plcWaiver.getCdWvrSvcDesc();
      if (cdSvcAuthCode.equals(svcCode) || cdSvcAuthCode.equals(progEntCode)) {
        amtWaived = plcWaiver.getAmtWvr() != null ? plcWaiver.getAmtWvr() : 0.0;

      }

    }
    return amtWaived;
  }

  private double updateBudgetLimitWaiverAmt(int idWaiver, String cdSvcAuthCode) {
    double amtWaived = 0.0;
    String progEntCode = "";
    String svcCode = "";
    if (idWaiver != 0) {
      CaseBudgetLimitWaiver bdgtLmtWaiver = caseBudgetLimitWaiverDAO.findPolicyWaiverEntry(idWaiver);
      if (bdgtLmtWaiver == null) {

        PolicyWaiver plcWaiver = policyWaiverDAO.findPolicyWaiverByIdEvent(idWaiver);
        progEntCode = plcWaiver.getCdWvrUasCd() + plcWaiver.getCdWvrEntCd();
        svcCode = plcWaiver.getCdWvrSvcDesc();
        if (cdSvcAuthCode.equals(svcCode) || cdSvcAuthCode.equals(progEntCode)) {
          amtWaived = plcWaiver.getAmtWvr() != null ? plcWaiver.getAmtWvr() : 0.0;
        }

      }

    }
    return amtWaived;
  }
}
