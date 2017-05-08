package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

public class CheckIfRemovalPriorToAllegIncidentSI implements Serializable {

  private int idVictim;
  private Date dtRemoval;
  
  
  public int getIdVictim() {
    return idVictim;
  }
  public void setIdVictim(int idVictim) {
    this.idVictim = idVictim;
  }
  public Date getDtRemoval() {
    return dtRemoval;
  }
  public void setDtRemoval(Date dtRemoval) {
    this.dtRemoval = dtRemoval;
  }
}
