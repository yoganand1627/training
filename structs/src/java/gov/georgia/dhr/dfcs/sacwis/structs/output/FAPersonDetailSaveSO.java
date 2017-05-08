package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;
//import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

/**
 * This is the input object passed to the RetrieveFAPersonDetail service which basically holds a person id.  The
 * ArchOutputStruct is currently not being used but is there for future use if ever needed (e.g. if pagination needs to
 * be implemented).
 *
 * @author Lata Lokhande Feb 2007
 */
public class FAPersonDetailSaveSO implements Serializable {
  private ArchOutputStruct archOutputStruct = null;
  private Integer idPerson;
  private String annualMedFormRequired;
  private Date medCheckDueDt;
  private Date criminalRecCheckDueDt;
  private Date dtLastUpdate;
  private Date dtLastMedRecCheck;

  public FAPersonDetailSaveSO() {

  }

  public FAPersonDetailSaveSO(int idPerson, String annualMedFormRequired,
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

}