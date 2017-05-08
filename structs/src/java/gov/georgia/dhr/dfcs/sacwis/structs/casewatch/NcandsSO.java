/**
 * Created on November 23, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsElementBean;

@SuppressWarnings("serial")
public class NcandsSO implements Serializable {

  
  
  private Date dtLastUpdate;
  private int idCustodyEvent;
  private int idCustodyEventStage;
  
  
  private List<NcandsElementBean> elements;
  
   
    
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public List<NcandsElementBean> getElements(){
    return elements;
  }

  public void setElements(List<NcandsElementBean> elements) {
    
    this.elements = elements;
    
  }
  
  public int getIdCustodyEvent() {
    return idCustodyEvent;
  }

  public void setIdCustodyEvent(int idCustodyEvent) {
    this.idCustodyEvent = idCustodyEvent;
  }
  
  public int getIdCustodyEventStage(){
    return idCustodyEventStage;
  }
  
  public void setIdCustodyEventStage(int idCustodyEventStage){
    this.idCustodyEventStage = idCustodyEventStage;
  }

}