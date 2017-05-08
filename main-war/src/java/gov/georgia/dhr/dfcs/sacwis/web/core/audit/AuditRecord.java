/**
 * Created on Sep 25, 2006 at 3:59:02 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.audit;

import java.sql.Timestamp;

public class AuditRecord {
  private int idPerson;
  private String ipAddress;
  private int idCommand;
  private Integer nbrMessage;
  private int idCase;
  private int idStage;
  private int idEvent;
  private int idUser;
  private int idResource;
  private int idParentRsrc;
  private Timestamp dtUserAction;

  public AuditRecord(int idPerson, String ipAddress, int idCommand, Integer nbrMessage,
                     int idCase, int idStage, int idEvent, int idUser, int idResource, int idParentRsrc) {
    this.idPerson = idPerson;
    this.ipAddress = ipAddress;
    this.idCommand = idCommand;
    this.nbrMessage = nbrMessage;
    this.idCase = idCase;
    this.idStage = idStage;
    this.idEvent = idEvent;
    this.idUser = idUser;
    this.idResource = idResource;
    this.idParentRsrc = idParentRsrc;
    this.dtUserAction = new Timestamp(System.currentTimeMillis());
  }

  public int getIdPerson() {

    return idPerson;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public int getIdCommand() {
    return idCommand;
  }

  public Integer getNbrMessage() {
    return nbrMessage;
  }

  public int getIdCase() {
    return idCase;
  }

  public int getIdStage() {
    return idStage;
  }

  public int getIdEvent() {
    return idEvent;
  }

  public Timestamp getDtUserAction() {
    return dtUserAction;
  }

  public int getIdUser() {
    return idUser;
  }

  public int getIdResource() {
    return idResource;
  }

  public int getIdParentRsrc() {
    return idParentRsrc;
  }
  
}