package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;
//import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

/**
 * This is the output object return from the RetrieveFAPersonDetail service.
 *
 * @author Lata Lokhande
 */
public class FAPersonDetailRetrieveSO implements Serializable {
  private ArchOutputStruct archOutputStruct = null;
  private Integer idPerson;
  private String annualMedFormRequired;
  private Date medCheckDueDt;
  private Date criminalRecCheckDueDt;
  private Date dtLastUpdate;
  private Date dtLastMedRecCheck;
  private Date dtLastGcicRecCheck;
  private Date dtGcicRecCheckDue;
  private Date dtLastNcicRecCheck;
  private Date dtNcicRecCheckDue;

  public FAPersonDetailRetrieveSO() {

  }

  public FAPersonDetailRetrieveSO(int idPerson, String annualMedFormRequired,
                                  Date medCheckDueDt, Date criminalRecCheckDueDt) {
    this.idPerson = idPerson;
    this.annualMedFormRequired = annualMedFormRequired;
    this.medCheckDueDt = medCheckDueDt;
    this.criminalRecCheckDueDt = criminalRecCheckDueDt;
  }

  public ArchOutputStruct getArchOutputStruct() {
    return this.archOutputStruct;
  }

  public void setArchOutputStruct(ArchOutputStruct archOutputStruct) {
    this.archOutputStruct = archOutputStruct;
  }

  public boolean hasIdPerson() {
    return this.idPerson > 0;
  }

  public int getIdPersonPrimitive() {
    return this.idPerson;
  }

  public Integer getIdPersonWrapped() {
    return this.idPerson;
  }

  public Integer getIdPerson() {
    return this.idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public void setAnnualMedFormRequired(String annualMedFormRequired) {
    this.annualMedFormRequired = annualMedFormRequired;
  }

  public String getAnnualMedFormRequired() {
    return this.annualMedFormRequired;
  }

  public void setMedCheckDueDt(Date medCheckDueDt) {
    this.medCheckDueDt = medCheckDueDt;
  }

  public Date getMedCheckDueDt() {
    return this.medCheckDueDt;
  }

  public void setCriminalRecCheckDueDt(Date criminalRecCheckDueDt) {
    this.criminalRecCheckDueDt = criminalRecCheckDueDt;
  }

  public Date getCriminalRecCheckDueDt() {
    return this.criminalRecCheckDueDt;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public Date getDtLastUpdate() {
    return this.dtLastUpdate;
  }

  public void setDtLastMedRecCheck(Date dtLastMedRecCheck) {
    this.dtLastMedRecCheck = dtLastMedRecCheck;
  }

  public Date getDtLastMedRecCheck() {
    return this.dtLastMedRecCheck;
  }

  public Date getDtLastGcicRecCheck() {
    return dtLastGcicRecCheck;
  }

  public void setDtLastGcicRecCheck(Date dtLastGcicRecCheck) {
    this.dtLastGcicRecCheck = dtLastGcicRecCheck;
  }

  public Date getDtGcicRecCheckDue() {
    return dtGcicRecCheckDue;
  }

  public void setDtGcicRecCheckDue(Date dtGcicRecCheckDue) {
    this.dtGcicRecCheckDue = dtGcicRecCheckDue;
  }

  public Date getDtLastNcicRecCheck() {
    return dtLastNcicRecCheck;
  }

  public void setDtLastNcicRecCheck(Date dtLastNcicRecCheck) {
    this.dtLastNcicRecCheck = dtLastNcicRecCheck;
  }

  public Date getDtNcicRecCheckDue() {
    return dtNcicRecCheckDue;
  }

  public void setDtNcicRecCheckDue(Date dtNcicRecCheckDue) {
    this.dtNcicRecCheckDue = dtNcicRecCheckDue;
  }

}