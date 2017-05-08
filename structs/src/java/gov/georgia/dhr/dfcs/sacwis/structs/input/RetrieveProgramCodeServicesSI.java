package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class RetrieveProgramCodeServicesSI implements Serializable {

  private int idResource = 0;

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }

  public int getIdResource() {
    return idResource;
  }
}
