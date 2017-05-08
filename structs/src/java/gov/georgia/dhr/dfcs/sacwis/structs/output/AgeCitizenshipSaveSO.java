package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

public class AgeCitizenshipSaveSO implements Serializable {
  private boolean updateSuccessful;

  public boolean isUpdateSuccessful() {
    return updateSuccessful;
  }

  public void setUpdateSuccessful(boolean updateSuccessful) {
    this.updateSuccessful = updateSuccessful;
  }
}
