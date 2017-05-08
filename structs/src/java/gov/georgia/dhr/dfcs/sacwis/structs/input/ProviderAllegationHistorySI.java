package gov.georgia.dhr.dfcs.sacwis.structs.input;

public class ProviderAllegationHistorySI {

  private int idStage;
  private int idResource;
  private String cdStage;
  
  public int getIdStage() {
    return idStage;
  }
  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }
  public int getIdResource() {
    return idResource;
  }
  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }
  public String getCdStage() {
    return cdStage;
  }
  public void setCdStage(String cdStage) {
    this.cdStage = cdStage;
  }
}
