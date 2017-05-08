package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

/**
 * This is the output object returns form the RetrievePlacementReferralLog service.
 * This object holds the placement referral log list, to display on JSP page.
 *
 * @author Lata Lokhande 02/12/2007
 */
public class PlacementReferralLogRetrieveSO implements Serializable {
  private ArchOutputStruct archOutputStruct = null;
  private List<PlacementReferralLogList> placementReferralLogList;
  private int idResource;
    
  
  public PlacementReferralLogRetrieveSO(){
    this.archOutputStruct = null;
    this.placementReferralLogList = null;
 
  }
  
  private PlacementReferralLogRetrieveSO(ArchOutputStruct ArchOutputStruct,
                                         List<PlacementReferralLogList> placementReferralLogList) {
    this.archOutputStruct = archOutputStruct;
    this.placementReferralLogList = placementReferralLogList;
  }
  
  public ArchOutputStruct getArchOutputStruct() {
    return this.archOutputStruct;
  }

  public void setArchOutputStruct(ArchOutputStruct archOutputStruct) {
    this.archOutputStruct = archOutputStruct;
  }
  
  public List<PlacementReferralLogList> getPlacementReferralLogList(){
    return this.placementReferralLogList;
  }
  
  public void setPlacementReferralLogList(List<PlacementReferralLogList> placementReferralLogList) {
    this.placementReferralLogList = placementReferralLogList;
  }
  
  public Integer getIdResource() {
    return this.idResource;
  }

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }
  
}