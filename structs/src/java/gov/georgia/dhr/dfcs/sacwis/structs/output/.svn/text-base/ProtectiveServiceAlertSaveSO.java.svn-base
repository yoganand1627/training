package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonProtectiveServiceAlertList;
/** @todo add javadocs for methods */

/**
 * ProtectiveServiceAlertDB value bean that contains the details of a Protective Service Alert.
 *
 * @author Lokhande, Lata, Sept 25, 2006
 */
public class ProtectiveServiceAlertSaveSO implements Serializable {
  //protected String ArchInputStruct = null;
  //protected String szIdEmployeeLogon = null;

  protected PersonProtectiveServiceAlertList personPSAList = null;
  // FIXME: Parameterize this Map inside the list -- e.g. List<Map<Foo,Bar>>
  protected List<Map> personList = null;
  // FIXME: This should almost certainly be a parameterized List.
  protected ArrayList personPSAarrayList = null;

  protected int stageId = 0;
  protected int caseId = 0;
  protected int personId = 0;
  protected int managerId = 0;

  //display only fields
  protected String stage = null; //stage (3 charachters)
  protected String stageName = null;
  protected String caseManager = null;
  protected String managerTitle = null;

  //input fields
  protected Date psaDate = null;
  protected String psaTime = null;
  protected Date dateAbsconded = null;
  protected String resonForAlert = null;
  protected String allPersonLocated = null;
  protected String psaComment = null;
  protected String psaPersonAbsconded = null;

  /* protected String ulStage = null;
  protected Date dtTime = null;
  protected Date dtDtPSADate = null;
  protected String ulPSACaseManager = null;
  protected Date dtDtPSAAbsconded = null;
  protected String idCdPSAResonAlert = null;
  
  protected String idTxtPSAComment = null;
  
  */
  public List<Map> getPersonList() {
    return this.personList;
  }

  public void setPersonList(List<Map> personList) {
    this.personList = personList;
  }

  public ArrayList getPersonPSAarrayList() {
    return this.personPSAarrayList;
  }

  public void setPersonPSAarrayList(ArrayList personPSAarrayList) {
    this.personPSAarrayList = personPSAarrayList;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public int getManagerId() {
    return managerId;
  }

  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }

  public String getStageName() {
    return stageName;
  }

  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  public String getCaseManager() {
    return caseManager;
  }

  public void setCaseManager(String caseManager) {
    this.caseManager = caseManager;
  }

  public void setManagerTitle(String managerTitle) {
    this.managerTitle = managerTitle;
  }

  public String getManagerTitle() {
    return managerTitle;
  }

  public String getPsaTime() {
    return psaTime;
  }

  public void setPsaTime(String psaTime) {
    this.psaTime = psaTime;
  }

  public Date getPsaDate() {
    return psaDate;
  }

  public void setPsaDate(Date psaDate) {
    this.psaDate = psaDate;
  }

  public String getResonForAlert() {
    return resonForAlert;
  }

  public void setResonForAlert(String resonForAlert) {
    this.resonForAlert = resonForAlert;
  }

  public Date getDateAbsconded() {
    return dateAbsconded;
  }

  public void setDateAbsconded(Date dateAbsconded) {
    this.dateAbsconded = dateAbsconded;
  }

  public String geAllPersonLocated() {
    return allPersonLocated;
  }

  public void setAllPersonLocated(String allPersonLocated) {
    this.allPersonLocated = allPersonLocated;
  }

  public String getPsaComment() {
    return psaComment;
  }

  public void setPsaComment(String psaComment) {
    this.psaComment = psaComment;
  }

  public String getPsaPersonAbsconded() {
    return psaPersonAbsconded;
  }

  public void setPsaPersonAbsconded(String psaPersonAbsconded) {
    this.psaPersonAbsconded = psaPersonAbsconded;
  }

}