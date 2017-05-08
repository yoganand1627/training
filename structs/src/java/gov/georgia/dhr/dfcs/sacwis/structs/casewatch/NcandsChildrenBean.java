/**
 * Created on November 23, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class NcandsChildrenBean implements Serializable {

  private int idPerson;
  private String nmPersonFull;
  
  public int getIdPerson(){
    return idPerson;
  }
  public String getNmPersonFull(){
    return nmPersonFull;
  }
  
  public void setIdPerson(int idPerson){
    this.idPerson = idPerson;
  }
  public void setNmPersonFull(String nmPersonFull){
    this.nmPersonFull = nmPersonFull;
  }
   
}