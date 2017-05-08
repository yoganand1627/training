package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.db.ExamDetail;
import gov.georgia.dhr.dfcs.sacwis.dao.ExamDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveExamDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExamDetailRetrieveSO;

/**
 * @author Nandita Hegde
 * 
 */
public class RetrieveExamDetailImpl extends BaseServiceImpl implements RetrieveExamDetail {

  private ExamDetailDAO examDAO = null;

  public void setExamDAO(ExamDetailDAO examDAO) {
    this.examDAO = examDAO;
  }

  @SuppressWarnings("unchecked")
  public ExamDetailRetrieveSO retrieveExamDetail(ExamDetailRetrieveSI examDetailRetrieveSI) {
    ExamDetailRetrieveSO examDetailRetrieveSO = new ExamDetailRetrieveSO();
    int idExam = examDetailRetrieveSI.getIdExamDetail();
    // retrieve existing exam so no need for zero id catch
    ExamDetail examDetail = examDAO.findExamDetailsOnId(idExam);
    if (examDetail != null) {
      examDetailRetrieveSO.setIdExamDetail(examDetail.getIdExamDetail());
      examDetailRetrieveSO.setCdExamType(examDetail.getCdExamTyp());
      examDetailRetrieveSO.setDtDetailsLastUpdate(examDetail.getDtLastUpdate());
      examDetailRetrieveSO.setDtExam(examDetail.getDtExam());
      examDetailRetrieveSO.setIndFirstAtmpt(examDetail.getIndFirstAtmpt());
      examDetailRetrieveSO.setIndPassed(examDetail.getIndPassed());
      examDetailRetrieveSO.setNbrScore(examDetail.getNbrScore());
      examDetailRetrieveSO.setIndGed(examDetail.getIndGed());
      // null check in case of broken data - person removed from system but not completely
      if (examDetail.getPerson() != null) {
        examDetailRetrieveSO.setIdPerson(examDetail.getPerson().getIdPerson());
      } else { // broken data safeguard and also for record keeping purpose
        examDetailRetrieveSO.setIdPerson(examDetailRetrieveSI.getIdPerson());
      }
    } else {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return examDetailRetrieveSO;
  }
}
