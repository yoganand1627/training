package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   12/12/2010  hjbaptiste        SMS#81144: MR-053 Initial Creation 
 *   12/27/2010  hjbaptiste        SMS#81144: MR-053 Removed the 72hr court order/hearing types                             
 *   08/24/2011  hnguyen           STGAP00017008: Fix Initial and Amended FCEA judicial determination to look at specific primary child legal actions
 *                                 and not look at the legal actions across the AU.
 *   08/31/2011  hnguyen           STGAP00017008: Corrected Reasonable effort issue and custody granted outcome to look from removal date and onward.
 *
 */

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.service.fce.CheckFceJudicialRequirements;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckFceJudicialRequirementsImpl extends BaseServiceImpl implements CheckFceJudicialRequirements {
  
  private LegalActionDAO legalActionDAO = null;

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public Map<String, Date> checkFceJudicialRequirements(int idCase, int idChild, Date removalDate) throws ServiceException {
    Map<String, Date> judicialRequirements = new HashMap<String, Date>();
    // Legal Action
    List<String> cdLegalActActions = new ArrayList<String>();
    cdLegalActActions.add(CodesTables.CLEGCPS_HRG); // Hearing
    cdLegalActActions.add(CodesTables.CLEGCPS_RCO); // Receive Court Order
    // Court Order Language
    String crtOrderLangCWC = CodesTables.CCRTLANG_CWC; // Best Interest/Contrary To The Welfare Of The Child
    String crtOrderLangRPR = CodesTables.CCRTLANG_RPR; // Reasonable Efforts Were Made To Prevent Removal
    String crtOrderLangRNN = CodesTables.CCRTLANG_RNN; // Reasonable Efforts Were Not Required

    List<String> crtOrderLangs = new ArrayList<String>();
    crtOrderLangs.add(crtOrderLangRPR);
    crtOrderLangs.add(crtOrderLangRNN);
    // outcomes
    String cdOutComeTypeCyg = CodesTables.CLEGLOUT_CYG; // Custody Granted
    List<String> cdOutComeTypes = new ArrayList<String>();
    cdOutComeTypes.add(cdOutComeTypeCyg);
    // Contrary to Welfare and Best Interest language
    List<LegalAction> bestInterestLegalActions = legalActionDAO.findFirstBestIntestLegalActionsForCaseForFCE(
                                                                                                             idCase,
                                                                                                             idChild,
                                                                                                             cdLegalActActions,
                                                                                                             crtOrderLangCWC);
    if (bestInterestLegalActions != null && bestInterestLegalActions.size() > 0) {
      LegalAction legalAction = bestInterestLegalActions.get(bestInterestLegalActions.size() - 1);
      Date dtRemovalChildOrdered = legalAction.getDtCrtOrdDate();
      judicialRequirements.put("dtRemovalChildOrdered", dtRemovalChildOrdered);
    }
    // Reasonable Efforts to prevent removal language
    Date within60DaysOfRemoval = DateHelper.addToDate(removalDate, 0, 0, 60);
    List<LegalAction> rEffortsLegalActions = legalActionDAO.findFirstRemovalEffortsLegalActionsForCaseForFCE(
                                                                                                             idCase,
                                                                                                             idChild,
                                                                                                             cdLegalActActions,
                                                                                                             crtOrderLangs,
                                                                                                             removalDate);
    if (rEffortsLegalActions != null && rEffortsLegalActions.size() > 0) {
      LegalAction legalAction = rEffortsLegalActions.get(rEffortsLegalActions.size() - 1);
      Date dtRsnblEffortPreventRem = legalAction.getDtCrtOrdDate();
      judicialRequirements.put("dtRsnblEffortPreventRem", dtRsnblEffortPreventRem);
    }
    // Custody Granted outcome
    List<LegalAction> cusGrantedLegalActions = legalActionDAO.findCustodyGrantedLegalActionForCaseForFCE(idCase,
                                                                                                         idChild,
                                                                                                         cdOutComeTypes,
                                                                                                         removalDate);
    if (cusGrantedLegalActions != null && cusGrantedLegalActions.size() > 0) {
      LegalAction legalAction = cusGrantedLegalActions.get(cusGrantedLegalActions.size() - 1);
      Date crtOrder = legalAction.getDtCrtOrdDate();
      judicialRequirements.put("dtCusGranted", crtOrder);
    }
    return judicialRequirements;
  }

}
