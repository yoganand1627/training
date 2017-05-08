package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

public class HomeApplicantSaveSO implements Serializable {

  private int idHomeApplicant;
  private int idResource;

  public int getIdHomeApplicant() {
    return idHomeApplicant;
  }

  public void setIdHomeApplicant(int idHomeApplicant) {
    this.idHomeApplicant = idHomeApplicant;
  }

  public int getIdResource() {
    return idResource;
  }

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }

}
