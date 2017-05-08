package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

/**
 *@author Herve Jean-Baptiste February 13, 2010
 */
@SuppressWarnings("serial")
public class ContactStandardsSaveSI implements Serializable {

  private Date dtEventLastUpdate;

  private String cdEventStatus;

  private String cdTask;
  
  private String cdReqAction;

  private Date dtEventOccurred;

  private int idCase;

  private int idStage;

  private int idUser;
  
  private int idEvent;

  private String nmStage;

  private int idPerson;

  private String txtEventDesc;
  
  private boolean approver;


  public String getCdEventStatus() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.cdEventStatus = cdEventStatus;
  }

  public String getCdTask() {
    return cdTask;
  }

  public void setCdtask(String cdTask) {
    this.cdTask = cdTask;
  }

  public String getCdReqAction() {
    return cdReqAction;
  }

  public void setCdReqAction(String cdReqAction) {
    this.cdReqAction = cdReqAction;
  }

  public Date getDtEventLastUpdate() {
    return dtEventLastUpdate;
  }

  public void setDtEventLastUpdate(Date dtEventLastUpdate) {
    this.dtEventLastUpdate = dtEventLastUpdate;
  }

  public Date getDtEventOccurred() {
    return dtEventOccurred;
  }

  public void setDtEventOccurred(Date dtEventOccurred) {
    this.dtEventOccurred = dtEventOccurred;
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

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public int getIdEvent() {
    return idEvent;
  }

  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }

  public String getNmStage() {
    return nmStage;
  }

  public void setNmStage(String nmStage) {
    this.nmStage = nmStage;
  }

  public int getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public String getTxtEventDesc() {
    return txtEventDesc;
  }

  public void setTxtEventDesc(String txtEventDesc) {
    this.txtEventDesc = txtEventDesc;
  }

  public boolean isApprover() {
    return approver;
  }

  public void setApprover(boolean approver) {
    this.approver = approver;
  }
}
