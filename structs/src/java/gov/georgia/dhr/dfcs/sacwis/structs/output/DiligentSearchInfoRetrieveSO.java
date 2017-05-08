package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoList;

/** @author Anand Kundrapu */
public class DiligentSearchInfoRetrieveSO implements Serializable {

  private int ulIdPersonSearch;

  private int ulIdPersonDetail;

  private int ulIdDiligentSearch;

  private int idCase;

  private int idstage;

  protected String personIdForPullback = null;

  protected String personNameForPullback = null;

  private String namePersonSearch;

  private String namePersonDetail;

  private DiligentSearchInfoList dsiBean;

  private List<DiligentSearchInfoList> dsiBeanList;

  public String getPersonIdForPullback() {
    return personIdForPullback;
  }

  public void setPersonIdForPullback(String personIdForPullback) {
    this.personIdForPullback = personIdForPullback;
  }

  public String getPersonNameForPullback() {
    return personNameForPullback;
  }

  public void setPersonNameForPullback(String personNameForPullback) {
    this.personNameForPullback = personNameForPullback;
  }

  public String getNamePersonSearch() {
    return namePersonSearch;
  }

  public void setNamePersonSearch(String namePersonSearch) {
    this.namePersonSearch = namePersonSearch;
  }

  public String getNamePersonDetail() {
    return namePersonDetail;
  }

  public void setNamePersonDetail(String namePersonDetail) {
    this.namePersonDetail = namePersonDetail;
  }

  public int getUlIdPersonSearch() {
    return ulIdPersonSearch;
  }

  public void setUlIdPersonSearch(int ulIdPersonSearch) {
    this.ulIdPersonSearch = ulIdPersonSearch;
  }

  public int getUlIdPersonDetail() {
    return ulIdPersonDetail;
  }

  public void setUlIdPersonDetail(int ulIdPersonDetail) {
    this.ulIdPersonDetail = ulIdPersonDetail;
  }

  public int getUlIdDiligentSearch() {
    return ulIdDiligentSearch;
  }

  public void setUlIdDiligentSearch(int ulIdDiligentSearch) {
    this.ulIdDiligentSearch = ulIdDiligentSearch;
  }

  public int getIdCase() {
    return idCase;
  }

  public void setIdCase(int idCase) {
    this.idCase = idCase;
  }

  public int getIdstage() {
    return idstage;
  }

  public void setIdstage(int idstage) {
    this.idstage = idstage;

  }

  public DiligentSearchInfoList getDsiBean() {
    return dsiBean;
  }

  public void setDsiBean(DiligentSearchInfoList dsiBean) {
    this.dsiBean = dsiBean;
  }

  public List<DiligentSearchInfoList> getDsiBeanList() {
    return dsiBeanList;
  }

  public void setDsiBeanList(List<DiligentSearchInfoList> dsiBeanList) {
    this.dsiBeanList = dsiBeanList;
  }
}