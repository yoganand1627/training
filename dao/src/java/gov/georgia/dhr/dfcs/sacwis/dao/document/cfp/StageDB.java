package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.io.Serializable;

/** Value Object representing a stage */
public class StageDB implements Serializable {
  protected String caseName = null;
  protected String programName = null;
  protected String stageName = null;
  protected String stageCode = null;
  protected String stageType = null;
  protected int caseId = 0;
  protected int stageId = 0;

  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }

  public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public String getStageName() {
    return stageName;
  }

  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  public String getStageCode() {
    return stageCode;
  }

  public void setStageCode(String stageCode) {
    this.stageCode = stageCode;
  }

  public String getStageType() {
    return stageType;
  }

  public void setStageType(String stageType) {
    this.stageType = stageType;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }
}


