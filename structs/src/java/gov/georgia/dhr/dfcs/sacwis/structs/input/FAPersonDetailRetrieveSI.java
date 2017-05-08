package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/**
 * This is the input object passed to the RetrieveFAPersonDetail service which basically holds a person id.  The
 * ArchInputStruct is currently not being used but is there for future use if ever needed (e.g. if pagination needs to
 * be implemented).
 *
 * @author Lata Lokhande
 */
public class FAPersonDetailRetrieveSI implements Serializable {
  private ArchInputStruct archInputStruct = null;
  private Integer idPerson;

  public FAPersonDetailRetrieveSI() {

  }

  public FAPersonDetailRetrieveSI(int idPerson) {
    this.idPerson = idPerson;
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
}