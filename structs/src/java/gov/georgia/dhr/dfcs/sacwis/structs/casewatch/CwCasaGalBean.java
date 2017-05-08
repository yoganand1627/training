/**
 * Created on November 23, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CwCasaGalBean implements Serializable {

  private String nmPersonFull;
  private String relCd;
  
  public String getNmPersonFull(){
    return nmPersonFull;
  }
  public String getRelCd(){
    return relCd;
  }
  
  public void setNmPersonFull(String nmPersonFull){
    this.nmPersonFull = nmPersonFull;
  }
  
  public void setRelCd(String relCd){
     this.relCd = relCd;
  }
    
}