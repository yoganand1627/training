package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The input object used for saving detailed data associated to a Protective Service Alert, including all of the persons
 * marked as absconded/runaway.  This object is passed to the SaveProtectiveServiceAlert service.
 *
 * @author A. B. Goode, 11/3/06
 */
@SuppressWarnings("serial")
public class ProtectiveServiceAlertSaveSI implements Serializable {
  private ArchInputStruct archInputStruct;

  //-- from retrieve output object
  private List<PersonProtectiveServiceAlertList> persons;
  private int idStage;
  private String cdStage;
  private int idUserCreatedBy;
  private int idPSA;

  //-- from page form
  private Date dateAndTime;
  private Date dateAbsconded;
  private String cdReasonForAlert;
  private String indAllPersonsLocated;
  private String comments;

  public ArchInputStruct getArchInputStruct() {
    return archInputStruct;
  }

  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
  }

  public String getCdReasonForAlert() {
    return cdReasonForAlert;
  }

  public void setCdReasonForAlert(String cdReasonForAlert) {
    this.cdReasonForAlert = cdReasonForAlert;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Date getDateAbsconded() {
    return dateAbsconded;
  }

  public void setDateAbsconded(Date dateAbsconded) {
    this.dateAbsconded = dateAbsconded;
  }

  //public boolean hasValidDateAbsconded() {
  //  return dateAbsconded != null && !DateHelper.NULL_JAVA_DATE.equals(dateAbsconded);
  //}

  public Date getDateAndTime() {
    return dateAndTime;
  }

  public void setDateAndTime(Date dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  //public void setDateAndTime(Date date, String time) {
  //  this.dateAndTime = DateHelper.toJavaDateSafe(date, time);
  //}

  //public boolean hasValidDateAndTime() {
  //  return dateAndTime != null && !DateHelper.NULL_JAVA_DATE.equals(dateAndTime);
  //}

  public String getIndAllPersonsLocated() {
    return indAllPersonsLocated;
  }

  public void setIndAllPersonsLocated(String indAllPersonsLocated) {
    this.indAllPersonsLocated = indAllPersonsLocated;
  }

  public List<PersonProtectiveServiceAlertList> getPersons() {
    return persons;
  }

  public void setPersons(List<PersonProtectiveServiceAlertList> persons) {
    this.persons = persons;
  }

  public String getCdStage() {
    return cdStage;
  }

  public void setCdStage(String cdStage) {
    this.cdStage = cdStage;
  }

  public int getIdStage() {
    return idStage;
  }

  //public int getIdStagePrimitive() {
  //  return idStage != null ? idStage : -1;
  //}

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

  //public boolean hasIdStage() {
  //  return idStage != null && idStage > 0;
  //}

  public int getIdUserCreatedBy() {
    return idUserCreatedBy;
  }

  //public int getIdUserCreatedByPrimitive() {
  //  return idUserCreatedBy != null ? idUserCreatedBy : -1;
  //}

  public void setIdUserCreatedBy(int idUserCreatedBy) {
    this.idUserCreatedBy = idUserCreatedBy;
  }

  //public boolean hasIdUserCreatedBy() {
  //  return idUserCreatedBy != null && idUserCreatedBy > 0;
  //}

  public int getIdPSA() {
    return idPSA;
  }

  //public int getIdPSAPrimitive() {
  //  return idPSA != null ? idPSA : -1;
  //}

  public void setIdPSA(int idPSA) {
    this.idPSA = idPSA;
  }

  //public boolean hasIdPSA() {
  //  return idPSA != null && idPSA > 0;
  //}
}