package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.util.List;

public class SaveStageVerifiedListSI {
  
  private List<Integer> verifiedStageIds;
  private List<String> verifiedStageInds;
  
  
  public List<Integer> getVerifiedStageIds() {
    return verifiedStageIds;
  }
  public void setVerifiedStageIds(List<Integer> verifiedStageIds) {
    this.verifiedStageIds = verifiedStageIds;
  }
  public List<String> getVerifiedStageInds() {
    return verifiedStageInds;
  }
  public void setVerifiedStageInds(List<String> verifiedStageInds) {
    this.verifiedStageInds = verifiedStageInds;
  }
  
  
}
