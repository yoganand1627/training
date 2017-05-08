/**
 * Created on March 13 2009 by Bhavna Gehlot
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCaseReviewDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComplexCaseReviewDAOImpl extends BaseDAOImpl implements ComplexCaseReviewDAO {
  private CaseReviewDAO caseReviewDAO = null;

  public void setCaseReviewDAO(CaseReviewDAO caseReviewDAO) {
    this.caseReviewDAO = caseReviewDAO;
  }

  public List<Map<String, Object>> findCaseReviewQuestions(String cdStage, int maxVersion) {
    List<Map<String, Object>> questionsList = new ArrayList<Map<String, Object>>();
    if (CodesTables.CSTAGES_INT.equals(cdStage)) {
      questionsList = caseReviewDAO.findCaseReviewQuestions(CodesTables.CSURSTG_INT, CodesTables.CSURTYP_CSURSTG, CodesTables.CSURQTP_YNA, maxVersion);
    } else if(CodesTables.CSTAGES_INV.equals(cdStage)){
      questionsList = caseReviewDAO.findCaseReviewQuestions(CodesTables.CSURSTG_INV, CodesTables.CSURTYP_CSURSTG, CodesTables.CSURQTP_YNA, maxVersion);
    }else if(CodesTables.CSTAGES_SUB.equals(cdStage)){
      questionsList = caseReviewDAO.findCaseReviewQuestions(CodesTables.CSURSTG_SUB, CodesTables.CSURTYP_CSURSTG, CodesTables.CSURQTP_YNA, maxVersion);
    }else if(CodesTables.CSTAGES_ADO.equals(cdStage)){
      questionsList = caseReviewDAO.findCaseReviewQuestions(CodesTables.CSURSTG_ADO, CodesTables.CSURTYP_CSURSTG, CodesTables.CSURQTP_YNA, maxVersion);
    }else if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      questionsList = caseReviewDAO.findCaseReviewQuestions(CodesTables.CSURSTG_DIV, CodesTables.CSURTYP_CSURSTG, CodesTables.CSURQTP_YNA, maxVersion);
    }else if(CodesTables.CSTAGES_FPR.equals(cdStage)){
      questionsList = caseReviewDAO.findCaseReviewQuestions(CodesTables.CSURSTG_FPR, CodesTables.CSURTYP_CSURSTG, CodesTables.CSURQTP_YNA, maxVersion);
    }
    return questionsList;
  }
}