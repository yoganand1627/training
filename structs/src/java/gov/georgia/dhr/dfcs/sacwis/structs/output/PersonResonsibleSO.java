package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;


public class PersonResonsibleSO implements Serializable{
  private int idSpPersRespnsbl;
  private Date dtLastUpdate;
  private int idPerson;
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }
  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }
  public int getIdPerson() {
    return idPerson;
  }
  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }
  public int getIdSpPersRespnsbl() {
    return idSpPersRespnsbl;
  }
  public void setIdSpPersRespnsbl(int idSpPersRespnsbl) {
    this.idSpPersRespnsbl = idSpPersRespnsbl;
  }


}
