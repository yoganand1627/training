package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/**
 * This is the input object passed to the RetrieveProtectiveServiceAlert service which basically holds a stage id.  The
 * ArchInputStruct is currently not being used but is there for future use if ever needed (e.g. if pagination needs to
 * be implemented).
 *
 * @author A. B. Goode, 11-3-06
 */
@SuppressWarnings("serial")
public class ProtectiveServiceAlertRetrieveSI implements Serializable {
  private ArchInputStruct archInputStruct = null;
  private int idStage;
  private int idPerson;

  public ProtectiveServiceAlertRetrieveSI() {
    this.idStage = 0;
  }

  public ProtectiveServiceAlertRetrieveSI(int idStage, int idPerson) {
    this.idStage = idStage;
    this.idPerson = idPerson;
  }

  public ArchInputStruct getArchInputStruct() {
    return this.archInputStruct;
  }

  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
  }

  //public boolean hasIdStage() {
  //  return this.idStage > 0;
  //}

  public int getIdStage() {
    return this.idStage;
  }

  //public Integer getIdStageWrapped() {
  //  return this.idStage;
  //}

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

  //public boolean hasIdPerson() {
  //  return this.idPerson > 0;
  //}

  public int getIdPerson() {
    return this.idPerson;
  }

  //public Integer getIdPersonWrapped() {
  //  return this.idPerson;
  //}

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }
}