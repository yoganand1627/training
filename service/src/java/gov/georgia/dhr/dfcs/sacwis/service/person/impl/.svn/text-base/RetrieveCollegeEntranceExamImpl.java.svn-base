package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.CollegeExamDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CollegeExam;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveCollegeEntranceExam;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CollegeEntranceExamRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CollegeEntranceExamRetrieveSO;

public class RetrieveCollegeEntranceExamImpl extends BaseServiceImpl implements RetrieveCollegeEntranceExam {

  CollegeExamDAO collegeExamDAO = null;

  public void setCollegeExamDAO(CollegeExamDAO collegeExamDAO) throws ServiceException {
    this.collegeExamDAO = collegeExamDAO;
  }

  public CollegeEntranceExamRetrieveSO retrieveCollegeEntranceExamDetail(CollegeEntranceExamRetrieveSI retrieveCE) {
    CollegeEntranceExamRetrieveSO returnCollegeExam = new CollegeEntranceExamRetrieveSO();

    CollegeExam collegeExam = collegeExamDAO.findCollegeExamByIdCollegeExam(retrieveCE.getIdCollegeExam());
    if (collegeExam != null) {
      returnCollegeExam.setIdCollegeExam(collegeExam.getIdCollegeExam());
      returnCollegeExam.setCdExamType(collegeExam.getCdExamTyp());
      returnCollegeExam.setDtTestTaken(collegeExam.getDtExam());
      returnCollegeExam.setIdPerson(collegeExam.getPerson().getIdPerson());
      returnCollegeExam.setNbrEnglishScore(collegeExam.getNbrEnglish());
      returnCollegeExam.setNbrMathScore(collegeExam.getNbrMath());
      returnCollegeExam.setNbrReadingScore(collegeExam.getNbrReading());
      returnCollegeExam.setNbrScienceScore(collegeExam.getNbrScience());
      returnCollegeExam.setNbrTotalScore(collegeExam.getNbrTotal());
      returnCollegeExam.setNbrVerbalScore(collegeExam.getNbrVerbal());
      returnCollegeExam.setNbrWritingScore(collegeExam.getNbrWriting());
    }

    return returnCollegeExam;
  }
}
