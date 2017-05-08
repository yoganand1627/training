package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class FCCPFamilyDetailSaveSO implements Serializable {
  private int idEvent;
  private  List<Map<String,Object>> childQuestionList = null;

  public int getIdEvent() {
    return idEvent;
  }

  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }
  
  public List<Map<String,Object>> getChildQuestionList() {
    return childQuestionList;
  }

  public void setChildQuestionList(List<Map<String,Object>> childQuestionList) {
    this.childQuestionList = childQuestionList;
  }
}
