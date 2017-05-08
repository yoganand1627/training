package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
@SuppressWarnings("serial")
public class ClientSI implements Serializable{
  private int idTrans;
  private int idPerson;
  private int nbrCRSId;
  private String nbrPersonId;
  private String nmPersonLast;
  private String nmPersonFirst;
  private String nmPersonMiddle;
  private String cdReturnStatus;
  /**
   * @return the cdReturnStatus
   */
  public String getCdReturnStatus() {
    return cdReturnStatus;
  }
  /**
   * @param cdReturnStatus the cdReturnStatus to set
   */
  public void setCdReturnStatus(String cdReturnStatus) {
    this.cdReturnStatus = cdReturnStatus;
  }
  /**
   * @return the idPerson
   */
  public int getIdPerson() {
    return idPerson;
  }
  /**
   * @param idPerson the idPerson to set
   */
  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }
  /**
   * @return the nbrCRSId
   */
  public int getNbrCRSId() {
    return nbrCRSId;
  }
  /**
   * @param nbrCRSId the nbrCRSId to set
   */
  public void setNbrCRSId(int nbrCRSId) {
    this.nbrCRSId = nbrCRSId;
  }
  /**
   * @return the nbrPersonId
   */
  public String getNbrPersonId() {
    return nbrPersonId;
  }
  /**
   * @param nbrPersonId the nbrPersonId to set
   */
  public void setNbrPersonId(String nbrPersonId) {
    this.nbrPersonId = nbrPersonId;
  }
  /**
   * @return the nmPersonFirst
   */
  public String getNmPersonFirst() {
    return nmPersonFirst;
  }
  /**
   * @param nmPersonFirst the nmPersonFirst to set
   */
  public void setNmPersonFirst(String nmPersonFirst) {
    this.nmPersonFirst = nmPersonFirst;
  }
  /**
   * @return the nmPersonLast
   */
  public String getNmPersonLast() {
    return nmPersonLast;
  }
  /**
   * @param nmPersonLast the nmPersonLast to set
   */
  public void setNmPersonLast(String nmPersonLast) {
    this.nmPersonLast = nmPersonLast;
  }
  /**
   * @return the nmPersonMiddle
   */
  public String getNmPersonMiddle() {
    return nmPersonMiddle;
  }
  /**
   * @param nmPersonMiddle the nmPersonMiddle to set
   */
  public void setNmPersonMiddle(String nmPersonMiddle) {
    this.nmPersonMiddle = nmPersonMiddle;
  }
  /**
   * @return the idTrans
   */
  public int getIdTrans() {
    return idTrans;
  }
  /**
   * @param idTrans the idTrans to set
   */
  public void setIdTrans(int idTrans) {
    this.idTrans = idTrans;
  }
}
