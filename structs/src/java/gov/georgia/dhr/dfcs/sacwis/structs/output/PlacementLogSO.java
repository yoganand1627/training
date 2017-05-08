package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
9/20/11     charden             Created file                              
*/
public class PlacementLogSO {

  private int numChildrenInHome;
  private int numChildrenDelinquent;
  private List<String> characteristicGroupList = new ArrayList<String>();
  private Map<String, Map<String, Integer>> characteristicsGroupMap = new HashMap<String, Map<String, Integer>>();
  private CFAD31SO cfad31so;
  
  public int getNumChildrenInHome() {
    return numChildrenInHome;
  }
  public void setNumChildrenInHome(int numChildrenInHome) {
    this.numChildrenInHome = numChildrenInHome;
  }
  public int getNumChildrenDelinquent() {
    return numChildrenDelinquent;
  }
  public void setNumChildrenDelinquent(int numChildrenDelinquent) {
    this.numChildrenDelinquent = numChildrenDelinquent;
  }
  public List<String> getCharacteristicGroupList() {
    return characteristicGroupList;
  }
  public void setCharacteristicGroupList(List<String> characteristicGroupList) {
    this.characteristicGroupList = characteristicGroupList;
  }
  public Map<String, Map<String, Integer>> getCharacteristicsGroupMap() {
    return characteristicsGroupMap;
  }
  public void setCharacteristicsGroupMap(Map<String, Map<String, Integer>> characteristicsGroupMap) {
    this.characteristicsGroupMap = characteristicsGroupMap;
  }
  public CFAD31SO getCfad31so() {
    return cfad31so;
  }
  public void setCfad31so(CFAD31SO cfad31so) {
    this.cfad31so = cfad31so;
  }
}
