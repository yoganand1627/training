package gov.georgia.dhr.dfcs.sacwis.structs.input;

import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SaveContactRuleSI implements Serializable {
  
  private int idEvent;
  private List<ContactRuleBean> contactRuleBeanList; 
  
  
  public int getIdEvent() {
    return idEvent;
  }
  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }
  public List<ContactRuleBean> getContactRuleBeanList() {
    return contactRuleBeanList;
  }
  public void setContactRuleBeanList(List<ContactRuleBean> contactRuleBeanList) {
    this.contactRuleBeanList = contactRuleBeanList;
  }
}
