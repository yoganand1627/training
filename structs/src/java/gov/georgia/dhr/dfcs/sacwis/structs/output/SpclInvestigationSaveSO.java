package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

public class SpclInvestigationSaveSO implements Serializable {

  private int idEvent;

  private int idCase;
  
  private int idStage;

  public int getIdEvent() {
    return idEvent;
  }

  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }

  public int getIdCase() {
    return idCase;
  }

  public void setIdCase(int idCase) {
    this.idCase = idCase;
  }

  public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }
}
