package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/** @author ade.odutayo */
public class HomeApplicantRetrieveSI implements Serializable {

  /** <p>fields required for retrieval</p> */
  private int idHomeApplicant;
  private int idResource;
  private ArchInputStruct archInputStruct;

  public ArchInputStruct getArchInputStruct() {
    return archInputStruct;
  }

  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
  }

  public int getIdHomeApplicant() {
    return idHomeApplicant;
  }

  public void setIdHomeApplicant(int idHomeApplicant) {
    this.idHomeApplicant = idHomeApplicant;
  }

  public int getIdResource() {
    return idResource;
  }

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }
}
