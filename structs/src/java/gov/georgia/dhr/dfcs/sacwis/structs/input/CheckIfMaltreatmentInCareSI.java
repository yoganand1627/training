package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

public class CheckIfMaltreatmentInCareSI implements Serializable {

  private int idVictim;
  private int idCase;
  private int idStage;
  private Date dtAllegedIncident;
  private String cdMaltreatorRel;
  private String cdStageType;
  private String allegDisposition;
  
  public int getIdVictim() {
    return idVictim;
  }
  public void setIdVictim(int idVictim) {
    this.idVictim = idVictim;
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
  public Date getDtAllegedIncident() {
    return dtAllegedIncident;
  }
  
  public void setDtAllegedIncident(Date dtAllegedIncident) {
    this.dtAllegedIncident = dtAllegedIncident;
  }  
  public String getCdMaltreatorRel() {
    return cdMaltreatorRel;
  }
  
  public void setCdMaltreatorRel (String cdMaltreatorRel) {
    this.cdMaltreatorRel = cdMaltreatorRel;
  }  
  public String getCdStageType() {
    return cdStageType;
  }
  public void setCdStageType (String cdStageType) {
    this.cdStageType = cdStageType;
  } 
  public String getAllegDisposition() {
    return allegDisposition;
  }
  public void setAllegDisposition (String allegDisposition) {
    this.allegDisposition = allegDisposition;
  }
  
}
