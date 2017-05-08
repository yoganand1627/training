package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;
//import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

/**
 * This is the input object passed to the RetrieveFAPersonDetail service which basically holds a person id.  The
 * ArchInputStruct is currently not being used but is there for future use if ever needed (e.g. if pagination needs to
 * be implemented).
 *
 * @author Lata Lokhande Feb 2007
 */
/**
 * 
 * Change History: Date       User          Description
 *                 ---------- ------------- -----------------------------------------------
 *                 02/24/2011 hanguyen      Added Change History.
 *                 02/24/2011 hanguyen      SMS#97850: MR-075 Removed date fields
 *                                          that is now calculated and read-only. No longer
 *                                          need to save these date fields.
*/

public class FAPersonDetailSaveSI implements Serializable {
  private ArchInputStruct archInputStruct = null;
  private Integer idPerson;
  private String annualMedFormRequired;
  private Date dtLastUpdate;

  public FAPersonDetailSaveSI() {

  }

  public FAPersonDetailSaveSI(int idPerson, String annualMedFormRequired) {
    this.idPerson = idPerson;
    this.annualMedFormRequired = annualMedFormRequired;
  }

  public ArchInputStruct getArchInputStruct() {
    return this.archInputStruct;
  }

  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
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

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public Date getDtLastUpdate() {
    return this.dtLastUpdate;
  }

}