package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SafetyPlanRetrieveSO implements Serializable {

  private int ulIdEvent;

  private int ulIdCase;

  private List<SafetyFactorSO> safetyFactorList;

  private Date dtDiscWithCrtkr;

  private String indCrtkrAgreesSp;
  
  private ROWCCMN45DO rowccmn45do = null;

  private Date dtLastUpdate;

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public int getUlIdCase() {
    return ulIdCase;
  }

  public void setUlIdCase(int ulIdCase) {
    this.ulIdCase = ulIdCase;
  }

  private List<RowCasePersonResponsible> casePersonResponsibleMap;

  public Date getDtDiscWithCrtkr() {
    return dtDiscWithCrtkr;
  }

  public void setDtDiscWithCrtkr(Date dtDiscWithCrtkr) {
    this.dtDiscWithCrtkr = dtDiscWithCrtkr;

  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public String getIndCrtkrAgreesSp() {
    return indCrtkrAgreesSp;
  }

  public void setIndCrtkrAgreesSp(String indCrtkrAgreesSp) {
    this.indCrtkrAgreesSp = indCrtkrAgreesSp;
  }

  public List<SafetyFactorSO> getSafetyFactorList() {
    return safetyFactorList;
  }

  public void setSafetyFactorList(List<SafetyFactorSO> safetyFactorList) {
    this.safetyFactorList = safetyFactorList;
  }

  public List<RowCasePersonResponsible> getCasePersonResponsibleList() {
    return casePersonResponsibleMap;
  }

  public void setCasePersonResponsibleList(List<RowCasePersonResponsible> casePersonResponsibleMap) {
    this.casePersonResponsibleMap = casePersonResponsibleMap;
  }

  public class RowCasePersonResponsible implements Serializable {
    private int idPerson;

    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getIdPerson() {
      return idPerson;
    }

    public void setIdPerson(int idPerson) {
      this.idPerson = idPerson;
    }
  }

  public ROWCCMN45DO getRowccmn45do() {
    return rowccmn45do;
  }

  public void setRowccmn45do(ROWCCMN45DO rowccmn45do) {
    this.rowccmn45do = rowccmn45do;
  }

}
