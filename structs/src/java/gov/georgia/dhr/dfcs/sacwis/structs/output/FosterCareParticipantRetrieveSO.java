package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean;

public class FosterCareParticipantRetrieveSO implements Serializable {
  int ulIdEvent;

  List<FosterCarePartBean> fosterCarePartList;

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public List<FosterCarePartBean> getFosterCarePartList() {
    return fosterCarePartList;
  }

  public void setFosterCarePartList(List<FosterCarePartBean> fosterCarePartList) {
    this.fosterCarePartList = fosterCarePartList;
  }
}