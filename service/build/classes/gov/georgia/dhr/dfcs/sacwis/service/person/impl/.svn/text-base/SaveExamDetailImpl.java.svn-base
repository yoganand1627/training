package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;

import gov.georgia.dhr.dfcs.sacwis.dao.ExamDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExamDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveExamDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExamDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;

/**
 * @author Nandita Hegde
 * 
 */
public class SaveExamDetailImpl extends BaseServiceImpl implements SaveExamDetail {
  private ExamDetailDAO examDAO = null;

  public void setExamDAO(ExamDetailDAO examDAO) {
    this.examDAO = examDAO;
  }

  public ExamDetailSaveSO saveExamDetail(ExamDetailSaveSI examDetailSaveSI) {
    ExamDetailSaveSO examDetailSaveSO = new ExamDetailSaveSO();
    saveExamDetails(examDetailSaveSI);
    return examDetailSaveSO;
  }

  // save examination details to exam_detail table.
  private void saveExamDetails(ExamDetailSaveSI examDetailSaveSI) throws ServiceException {

    ExamDetail examDetail = new ExamDetail();

    int idPerson = examDetailSaveSI.getIdPerson();
    int idExamDetail = examDetailSaveSI.getIdExamDetail();
    if (idExamDetail != 0) {
      examDetail.setIdExamDetail(idExamDetail);
      examDetail.setDtLastUpdate(examDetailSaveSI.getDtDetailsLastUpdate());
    }
    examDetail.setCdExamTyp(examDetailSaveSI.getCdExamType());
    examDetail.setIndFirstAtmpt(examDetailSaveSI.getIndFirstAtmpt());
    examDetail.setIndGed(examDetailSaveSI.getIndGED());
    examDetail.setIndPassed(examDetailSaveSI.getIndPassed());
    examDetail.setNbrScore(examDetailSaveSI.getNbrScore());
    examDetail.setDtExam(examDetailSaveSI.getDtExam());
    Person person = (Person) getPersistentObject(Person.class, idPerson);
    examDetail.setPerson(person);
    examDAO.saveExamDetails(examDetail);
  }

}