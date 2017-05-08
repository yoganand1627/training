package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class AlertMesWorkerIfSESI implements Serializable{
  private int idCase; 
  private int idStage; 
  private int idUser; 
  private int idMesProgAssist;
  private String[] securityAttributesMESWorker;
  
  
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
  public int getIdUser() {
    return idUser;
  }
  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }
  public int getIdMesProgAssist() {
    return idMesProgAssist;
  }
  public void setIdMesProgAssist(int idMesProgAssist) {
    this.idMesProgAssist = idMesProgAssist;
  }
  public String[] getSecurityAttributesMESWorker() {
    return securityAttributesMESWorker;
  }
  public void setSecurityAttributesMESWorker(String[] securityAttributesMESWorker) {
    this.securityAttributesMESWorker = securityAttributesMESWorker;
  }
}
