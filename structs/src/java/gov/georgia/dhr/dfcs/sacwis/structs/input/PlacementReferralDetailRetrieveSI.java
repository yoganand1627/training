package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/**
 * This is the input object passed to the RetrievePlacementReferralDetail service.
 * This object holds PlacementReferral Id.  
 *
 * @author Lata Lokhande 02/15/2007
 */
public class PlacementReferralDetailRetrieveSI implements Serializable {
  private ArchInputStruct archInputStruct = null;
  private Integer idPlacementReferral;
  private Integer idResource;
  
  public PlacementReferralDetailRetrieveSI(){
    
  }
  
  public ArchInputStruct getArchInputStruct() {
    return this.archInputStruct;
  }

  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
  }
  
  public Integer getIdPlacementReferral() {
    return this.idPlacementReferral;
  }

  public void setIdPlacementReferral(int idPlacementReferral) {
    this.idPlacementReferral = idPlacementReferral;
  }
  
  public Integer getIdResource() {
    return this.idResource;
  }

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }
  
}