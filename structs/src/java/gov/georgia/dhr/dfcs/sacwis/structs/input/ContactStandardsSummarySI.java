package gov.georgia.dhr.dfcs.sacwis.structs.input;

import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;

import java.io.Serializable;
import java.util.List;

/**
 *@author Herve Jean-Baptiste March 01, 2010
 */
@SuppressWarnings("serial")
public class ContactStandardsSummarySI implements Serializable {

  private int ulIdEvent;

  private String cdStage;
  
  private String cdTask;
  
  private List<ContactRuleBean> childContactRuleBeanList;
  

  public String getCdStage() {
    return cdStage;
  }

  public void setCdStage(String cdStage) {
    this.cdStage = cdStage;
  }

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public String getCdTask() {
    return cdTask;
  }

  public void setCdTask(String cdTask) {
    this.cdTask = cdTask;
  }

  public List<ContactRuleBean> getChildContactRuleBeanList() {
    return childContactRuleBeanList;
  }

  public void setChildContactRuleBeanList(List<ContactRuleBean> childContactRuleBeanList) {
    this.childContactRuleBeanList = childContactRuleBeanList;
  }
}
