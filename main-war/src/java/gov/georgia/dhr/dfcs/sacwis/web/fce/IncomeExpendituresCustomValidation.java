package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.IncomeExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * User: mkw Date: Mar 5, 2003 Time: 11:30:17 AM <p/> Change History: Date User Description -------- ----------------
 * ------------------------------------------------- 07/22/05 Todd Reser SIR 23543 - Display an error if there is SSI
 * Family Income, the person is a member of the certified group and does not have the role "Self"
 */

public class IncomeExpendituresCustomValidation extends FormValidation {
  protected static final String TRACE_TAG = "IncomeExpendituresCustomValidation";

  /** all the validation logic */
protected boolean validateForm() {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "validateForm");

    try {
      HttpServletRequest request = getRequest();
      BaseSessionStateManager state = super.getState();
      
      IncomeExpendituresDB incomeExpendituresDB = new IncomeExpendituresDB();
      IncomeExpendituresConversation.populateWithRequest(incomeExpendituresDB, request);
      
      // SIR 23543 - Display an error if there is SSI Family Income
      if ("true".equals(ContextHelper.getStringSafe(request, "indSSI"))) {
        setErrorMessage(Messages.MSG_SSI_APPLICANT);
      }

      if ((incomeExpendituresDB.getIndProofAgeSentEs()) && (incomeExpendituresDB.getDtProofAgeSentEs() == null)) {
        setErrorMessage(Messages.MSG_DT_AGE_DOC_SENT);
      }
      if (incomeExpendituresDB.getDtProofAgeSentEs() != null) {
        validateDateNotInTheFuture(incomeExpendituresDB.getDtProofAgeSentEs(),
                                   IncomeExpendituresDB.DT_PROOF_AGE_SENT_ES_STRING);
      }
      if ((Boolean.FALSE.equals(incomeExpendituresDB.getIndProofAgeSentEsObject()))
          && ("".equals(incomeExpendituresDB.getTxtProofAgeSentEs()))) {
        setErrorMessage(Messages.MSG_TXT_AGE_SENT);
      }
      // User selects yes to the child proof question in documemt checklist
      if ((Boolean.TRUE.equals(incomeExpendituresDB.getIndProofAgeSentEsObject()))
          && ("".equals(incomeExpendituresDB.getTxtProofAgeSentEs()))) {
        setErrorMessage(Messages.MSG_FCE_TXT_AGE_SENT_YES);
      }
      if ((incomeExpendituresDB.getIndProofCitizenshipSentEs())
          && (incomeExpendituresDB.getDtProofCitizenshipSentEs() == null)) {
        setErrorMessage(Messages.MSG_DT_CITZ_DOC_SENT);
      }
      if (incomeExpendituresDB.getDtProofCitizenshipSentEs() != null) {
        validateDateNotInTheFuture(incomeExpendituresDB.getDtProofCitizenshipSentEs(),
                                   IncomeExpendituresDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING);
      }
      if ((Boolean.FALSE.equals(incomeExpendituresDB.getIndProofCitizenshipSentEsObject()))
          && ("".equals(incomeExpendituresDB.getTxtProofCitizenshipSentEs()))) {
        setErrorMessage(Messages.MSG_TXT_CTZN_SENT);
      }
      // User selects yes to the citizenship question in documemt checklist
      if ((Boolean.TRUE.equals(incomeExpendituresDB.getIndProofCitizenshipSentEsObject()))
          && ("".equals(incomeExpendituresDB.getTxtProofCitizenshipSentEs()))) {
        setErrorMessage(Messages.MSG_FCE_TXT_CITZ_DOC_SENT_YES);
      }
      // Validations for Child's Identity in document checklist
      if ((incomeExpendituresDB.getIndProofChildIdSentEs())
          && (incomeExpendituresDB.getDtProofChildIdSentEs() == null)) {
        setErrorMessage(Messages.MSG_FCE_DT_IDEN_DOC_SENT);
      }
      if (incomeExpendituresDB.getDtProofChildIdSentEs() != null) {
        validateDateNotInTheFuture(incomeExpendituresDB.getDtProofChildIdSentEs(),
                                   IncomeExpendituresDB.DT_PROOF_CHILD_ID_SENT_ES_STRING);
      }
      if ((Boolean.FALSE.equals(incomeExpendituresDB.getIndProofChildIdSentEsObject()))
          && ("".equals(incomeExpendituresDB.getTxtProofChildIdSentEs()))) {
        setErrorMessage(Messages.MSG_FCE_TXT_IDEN_DOC_SENT);
      }
      if ((Boolean.TRUE.equals(incomeExpendituresDB.getIndProofChildIdSentEsObject()))
          && ("".equals(incomeExpendituresDB.getTxtProofChildIdSentEs()))) {
        setErrorMessage(Messages.MSG_FCE_TXT_IDEN_DOC_SENT_YES);
      }
      
      if ((incomeExpendituresDB.getIndLegalDocsSentEs())
                      && (incomeExpendituresDB.getDtLegalDocsSentEs() == null)) {
        setErrorMessage(Messages.MSG_FCE_DT_LEGAL_DOC_SENT);
      }
      if (incomeExpendituresDB.getDtLegalDocsSentEs() != null) {
        validateDateNotInTheFuture(incomeExpendituresDB.getDtLegalDocsSentEs(),
                                   IncomeExpendituresDB.DT_LEGAL_DOCS_SENT_ES_STRING);
      }
      if ((Boolean.FALSE.equals(incomeExpendituresDB.getIndLegalDocsSentEsObject()))
          && ("".equals(incomeExpendituresDB.getTxtLegalDocsSentEs()))) {
        setErrorMessage(Messages.MSG_TXT_LEGAL_DOCS_SENT);
      }
      // User selects yes to the legal question in documemt checklist
      if ((Boolean.TRUE.equals(incomeExpendituresDB.getIndLegalDocsSentEsObject()))
                      && ("".equals(incomeExpendituresDB.getTxtLegalDocsSentEs()))) {
        setErrorMessage(Messages.MSG_FCE_TXT_LEGAL_DOCS_SENT_YES);
      }
      
      // Validations for Child's Pregnancy in document checklist
      if ((incomeExpendituresDB.getIndProofPregnancySentEs())
          && (incomeExpendituresDB.getDtProofPregnancySentEs() == null)) {
        setErrorMessage(Messages.MSG_FCE_DT_PREG_SENT_YES);
      }
      if (incomeExpendituresDB.getDtProofPregnancySentEs() != null) {
        validateDateNotInTheFuture(incomeExpendituresDB.getDtProofPregnancySentEs(),
                                   IncomeExpendituresDB.DT_PROOF_PREGNANCY_SENT_ES_STRING);
      }
      if ((Boolean.TRUE.equals(incomeExpendituresDB.getIndProofPregnancySentEsObject()))
          && ("".equals(incomeExpendituresDB.getTxtProofPregnancySentEs()))) {
        setErrorMessage(Messages.MSG_FCE_TXT_PREG_SENT);
      }
      if ((Boolean.FALSE.equals(incomeExpendituresDB.getIndProofPregnancySentEsObject()))
                      && ("".equals(incomeExpendituresDB.getTxtProofPregnancySentEs()))) {
                    setErrorMessage(Messages.MSG_FCE_TXT_PREG_SENT_NO);
      }
            
      if (incomeExpendituresDB.getIndNotifiedDhsWorker()) {
        boolean firstNameSet = StringHelper.isValid(incomeExpendituresDB.getNmNotifiedDhsWrkrFirst());

        boolean middleNameSet = StringHelper.isValid(incomeExpendituresDB.getNmNotifiedDhsWrkrMiddle());

        boolean lastNameSet = StringHelper.isValid(incomeExpendituresDB.getNmNotifiedDhsWrkrLast());

        if (firstNameSet && !lastNameSet) {
          setErrorMessage(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_LAST, Messages.MSG_WRKR_NOTIF_FIRST);
        } else if (!firstNameSet && lastNameSet) {
          setErrorMessage(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_FIRST, Messages.MSG_WRKR_NOTIF_LAST);
        } else if ((middleNameSet) && (!firstNameSet) && (!lastNameSet)) {
          setErrorMessage(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_FIRST, Messages.MSG_WRKR_NOTIF_MIDDLE);
        } else if ((!firstNameSet) || (!lastNameSet) || (incomeExpendituresDB.getDtNotifiedWorker() == null)) {
          // !!! Messages.MSG_DHS_NOTIFIED_REQ
          //setErrorMessage("You indicated that you notified a DHS staff person that the child was removed from the home.  You must complete the Income Assistance or Person Notified Information section.");
          setErrorMessage(Messages.MSG_FCE_FICM_NOT_COMP_SECT);
        } else if (incomeExpendituresDB.getDtNotifiedWorker() != null) {
          validateDateNotInTheFuture(incomeExpendituresDB.getDtNotifiedWorker(),
                                     IncomeExpendituresDB.DT_NOTIFIED_WORKER_STRING);
        }
      }

      return getErrorMessages().isEmpty();
    }catch (Exception e) {

      e.printStackTrace();
      throw new RuntimeWrappedException(e);
    } finally {
      performanceTrace.exitScope();
    }
  }
  // !!! copied from EligibilityDeterminationCustomValidation
  protected void validateDateNotInTheFuture(Date date, String name) {
    Date today = new Date();

    if ((date != null) && (date.after(today))) {
      setErrorMessage(name, Messages.SSM_DATE_BEFORE_SAME_CURR);
    }
  }

}
