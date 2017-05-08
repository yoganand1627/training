package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ExamDetailRetrieveSO implements Serializable {

  private String indFirstAtmpt;

  private String cdExamType;

  private String indPassed;

  private String indExamType;

  private Date dtExam;

  private Date dtDetailsLastUpdate;

  private int idExamDetail;

  private int nbrScore;

  private String indGed;

  private int idPerson;

  public int getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public int getIdExamDetail() {
    return idExamDetail;
  }

  public void setIdExamDetail(int idExamDetail) {
    this.idExamDetail = idExamDetail;
  }

  public String getIndFirstAtmpt() {
    return indFirstAtmpt;
  }

  public void setIndFirstAtmpt(String indFirstAtmpt) {
    this.indFirstAtmpt = indFirstAtmpt;
  }

  public String getIndPassed() {
    return indPassed;
  }

  public void setIndPassed(String indPassed) {
    this.indPassed = indPassed;
  }

  public String getIndExamType() {
    return indExamType;
  }

  public void setIndExamType(String indExamType) {
    this.indExamType = indExamType;
  }

  public String getCdExamType() {
    return cdExamType;
  }

  public void setCdExamType(String cdExamType) {
    this.cdExamType = cdExamType;
  }

  public int getNbrScore() {
    return nbrScore;
  }

  public void setNbrScore(int nbrScore) {
    this.nbrScore = nbrScore;
  }

  public Date getDtDetailsLastUpdate() {
    return this.dtDetailsLastUpdate;
  }

  public void setDtDetailsLastUpdate(Date dt) {
    this.dtDetailsLastUpdate = dt;
  }

  public Date getDtExam() {
    return this.dtExam;
  }

  public void setDtExam(Date dt) {
    this.dtExam = dt;
  }

  public String getIndGed() {
    return indGed;
  }

  public void setIndGed(String indGed) {
    this.indGed = indGed;
  }

}
