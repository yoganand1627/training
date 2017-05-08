package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
/**
 * @author ade.odutayo
 *
 */
public class DiversionCnclsnRetrieveSI implements Serializable {  
  
  /**
   * <p>fields required for retrieval</p>
   */
  private int idDiversionCnclsn;   
  private int idIncomingDetail;
  private int idStage; 
  private int idEvent;
  private ArchInputStruct archInputStruct;
  

  public int getIdDiversionCnclsn() {
    return idDiversionCnclsn;
  }
  public void setIdDiversionCnclsn(int idDiversionCnclsn) {
    this.idDiversionCnclsn = idDiversionCnclsn;
  }
  public int getIdIncomingDetail() {
    return idIncomingDetail;
  }
  public void setIdIncomingDetail(int idIncomingDetail) {
    this.idIncomingDetail = idIncomingDetail;
  }
  public int getIdStage() {
    return idStage;
  }
  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }
  public int getIdEvent() {
    return idEvent;
  }
  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }  
  public ArchInputStruct getArchInputStruct() {
    return archInputStruct;
  }
  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
  }
  
  
}
