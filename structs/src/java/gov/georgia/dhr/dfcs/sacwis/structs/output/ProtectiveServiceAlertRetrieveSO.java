package gov.georgia.dhr.dfcs.sacwis.structs.output;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonProtectiveServiceAlertList;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * This the output object returned by the RetrieveProtectiveServiceAlert service which holds all the detailed data
 * necessary for business logic and page display of the Protective Service Alert page, including the list of persons
 * associated to the particular stage, absconded and not.
 *
 * @author A. B. Goode
 */
@SuppressWarnings("serial")
public class ProtectiveServiceAlertRetrieveSO implements Serializable {
  //-- for logic
  private ArchOutputStruct archOutputStruct = null;
  private int idStage;
  private int idUserCreatedBy;
  private String cdTitle;
  private int idPSA;

  //-- display only
  private String cdStage;
  private String nmUserCreatedBy;
  private String titleDecode;
  private String nmStage;
  private int idCase;

  //-- inputs
  private Date date;
  private String time;
  private Date dateAbsconded;
  private String cdReasonForAlert;
  private String indAllPersonsLocated;
  private String comments;

  //-- list of persons for the Persons Absconded section
  private List<PersonProtectiveServiceAlertList> persons;

  public ProtectiveServiceAlertRetrieveSO() {
    this.idStage = 0;
    this.idUserCreatedBy = 0;
  }

  public ProtectiveServiceAlertRetrieveSO(String cdStage, int idUserCreatedBy, String cdTitle) {
    this.idStage = 0;
    this.cdStage = cdStage;
    this.idUserCreatedBy = idUserCreatedBy;
    this.cdTitle = cdTitle;
  }

  public ArchOutputStruct getArchOutputStruct() {
    return this.archOutputStruct;
  }

  public void setArchOutputStruct(ArchOutputStruct archOutputStruct) {
    this.archOutputStruct = archOutputStruct;
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

  public String getCdStage() {
    return this.cdStage;
  }

  public void setCdStage(String cdStage) {
    this.cdStage = cdStage;
  }

  public String getNmUserCreatedBy() {
    return this.nmUserCreatedBy;
  }

  public void setNmUserCreatedBy(String nmUserCreatedBy) {
    this.nmUserCreatedBy = nmUserCreatedBy;
  }

  public String getNmStage() {
    return this.nmStage;
  }

  public void setNmStage(String nmStage) {
    this.nmStage = nmStage;
  }

  public String getTitleDecode() {
    return this.titleDecode;
  }

  public void setTitleDecode(String titleDecode) {
    this.titleDecode = titleDecode;
  }

  //public boolean hasIdUserCreatedBy() {
  //  return this.idUserCreatedBy > 0;
  //}

  public int getIdUserCreatedBy() {
    return this.idUserCreatedBy;
  }

  //public Integer getIdUserCreatedByWrapped() {
  //  return this.idUserCreatedBy;
  //}

  public void setIdUserCreatedBy(int idUserCreatedBy) {
    this.idUserCreatedBy = idUserCreatedBy;
  }

  public String getCdTitle() {
    return this.cdTitle;
  }

  public void setCdTitle(String cdTitle) {
    this.cdTitle = cdTitle;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  //public void setDateAndTime(Date date) {
  //  this.date = date;
  //  String dateAndTime = DateHelper.DATE_TIME_FORMAT.format(this.date);
  //  this.time = dateAndTime.substring(11, 19);
  //}
  
  /*
  public String getFormattedDateAndTimeAsString() {
    String dateStr;
    if (this.date != null) {
      dateStr = DateHelper.SLASH_FORMAT.format(this.date);
    } else {
      dateStr = DateHelper.SLASH_FORMAT.format(new Date());
    }

    String timeStr;
    if (this.time != null) {
      timeStr = this.time;
    } else {
      timeStr = DateHelper.DATE_TIME_FORMAT.format(new Date());
      timeStr = timeStr.substring(11, 19);
    }

    return dateStr + " " + timeStr;
  }
  */
  
  /*
  public String getFormattedDateAsString() {
    if (this.date != null) {
      return DateHelper.SLASH_FORMAT.format(this.date);
    } else {
      return "";
    }
  }

  public String getFormattedDateAbscondedAsString() {
    if (this.dateAbsconded != null) {
      return DateHelper.SLASH_FORMAT.format(this.dateAbsconded);
    } else {
      return "";
    }
  }
  */

  public Date getDateAbsconded() {
    return this.dateAbsconded;
  }

  public void setDateAbsconded(Date date) {
    this.dateAbsconded = date;
  }

  public String getCdReasonForAlert() {
    return this.cdReasonForAlert;
  }

  public void setCdReasonForAlert(String cdReasonForAlert) {
    this.cdReasonForAlert = cdReasonForAlert;
  }

  public String getIndAllPersonsLocated() {
    return this.indAllPersonsLocated;
  }

  public void setIndAllPersonsLocated(String indAllPersonsLocated) {
    this.indAllPersonsLocated = indAllPersonsLocated;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public List<PersonProtectiveServiceAlertList> getPersons() {
    return this.persons;
  }

  public void setPersons(List<PersonProtectiveServiceAlertList> persons) {
    this.persons = persons;
  }

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

  public int getIdCase() {
    return idCase;
  }

  //public int getIdCasePrimitive() {
  //  return idCase != null ? idCase : -1;
  //}

  public void setIdCase(int idCase) {
    this.idCase = idCase;
  }

  //public boolean hasIdCase() {
  //  return idCase != null && idCase > 0;
  //}
}