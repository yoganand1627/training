package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

/**
 * @author Nandita Hegde
 * 
 */
@SuppressWarnings("serial")
public class ExamDetailSaveSO implements Serializable {
  int idPerson;

  public int getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }
}