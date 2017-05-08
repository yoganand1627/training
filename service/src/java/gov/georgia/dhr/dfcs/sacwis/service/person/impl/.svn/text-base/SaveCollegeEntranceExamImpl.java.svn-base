package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.CollegeExamDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CollegeExam;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCollegeEntranceExam;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CollegeEntranceExamSaveSI;

public class SaveCollegeEntranceExamImpl extends BaseServiceImpl implements SaveCollegeEntranceExam {
  
  CollegeExamDAO collegeExamDAO = null;
  
  PersonDAO personDAO = null;
  
  public void setPersonDAO(PersonDAO personDAO) throws ServiceException {
    this.personDAO = personDAO;
  }
  
  public void setCollegeExamDAO(CollegeExamDAO collegeExamDAO) throws ServiceException {
    this.collegeExamDAO = collegeExamDAO;
  }
  
  public CollegeEntranceExamSaveSI saveCollegeEntranceExam (CollegeEntranceExamSaveSI saveCE){
    CollegeExam collegeExam = new CollegeExam();
    int idExam = saveCE.getIdCollegeExam();
    if (idExam != 0){
      collegeExam = (CollegeExam) getPersistentObject(CollegeExam.class, idExam);
    }
    
    Person person = personDAO.findPersonByIdPerson(saveCE.getIdPerson());
    collegeExam.setPerson(person);
    collegeExam.setCdExamTyp(saveCE.getCdExamType());
    collegeExam.setDtExam(saveCE.getDtTestTaken());
    collegeExam.setNbrEnglish(saveCE.getNbrEnglishScore());
    collegeExam.setNbrMath(saveCE.getNbrMathScore());
    collegeExam.setNbrReading(saveCE.getNbrReadingScore());
    collegeExam.setNbrScience(saveCE.getNbrScienceScore());
    collegeExam.setNbrWriting(saveCE.getNbrWritingScore());
    collegeExam.setNbrTotal(saveCE.getNbrTotalScore());
    collegeExam.setNbrVerbal(saveCE.getNbrVerbalScore());
    
    collegeExamDAO.saveCollegeExam(collegeExam);
    
    return saveCE;
  }
}