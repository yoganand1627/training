package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class CollegeEntranceExamRetrieveSI implements Serializable {
  protected int idCollegeExam;

  public int getIdCollegeExam() {
    return idCollegeExam;
  }

  public void setIdCollegeExam(int idCollegeExam) {
    this.idCollegeExam = idCollegeExam;
  }
}