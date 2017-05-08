package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;

/**
 *@author Bhavna Gehlot February 18, 2010
 */
@SuppressWarnings("serial")
public class ContactRuleBean implements Serializable {

  private int ulIdEvent;

  private int ulIdPerson;
  
  private int ulIdContactRule;
  
  private int nbrContactsPerMonth;
  
  private String indByFaceToFace;
  
  private String indByTelephone;
  
  private String indByEmailCorrspndnce;
  
  private String cdContactNotRequired;
  
  private String txtJustification;
  
  private String indPrepopulated;
  
  private String cdPersonRole;
  
  private String nmPersonFull;
  
  private String cdUnknownParent;
  
  private String cdReqAction;
  
  private List<ContactForBean> childContactForBeanList;

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public int getUlIdPerson() {
    return ulIdPerson;
  }

  public void setUlIdPerson(int ulIdPerson) {
    this.ulIdPerson = ulIdPerson;
  }
  
  public int getUlIdContactRule() {
    return ulIdContactRule;
  }

  public void setUlIdContactRule(int ulIdContactRule) {
    this.ulIdContactRule = ulIdContactRule;
  }
  
  public int getNbrContactsPerMonth() {
    return nbrContactsPerMonth;
  }

  public void setNbrContactsPerMonth(int nbrContactsPerMonth) {
    this.nbrContactsPerMonth = nbrContactsPerMonth;
  }
  
  public String getIndByFaceToFace() {
    return indByFaceToFace;
  }

  public void setIndByFaceToFace(String indByFaceToFace) {
    this.indByFaceToFace = indByFaceToFace;
  }
  
  public String getIndByTelephone() {
    return indByTelephone;
  }

  public void setIndByTelephone(String indByTelephone) {
    this.indByTelephone = indByTelephone;
  }
  
  public String getIndByEmailCorrspndnce() {
    return indByEmailCorrspndnce;
  }

  public void setIndByEmailCorrspndnce(String indByEmailCorrspndnce) {
    this.indByEmailCorrspndnce = indByEmailCorrspndnce;
  }
  
  public String getCdContactNotRequired() {
    return cdContactNotRequired;
  }

  public void setCdContactNotRequired(String cdContactNotRequired) {
    this.cdContactNotRequired = cdContactNotRequired;
  }
  
  public String getTxtJustification() {
    return txtJustification;
  }

  public void setTxtJustification(String txtJustification) {
    this.txtJustification = txtJustification;
  }
  
  public String getIndPrepopulated() {
    return indPrepopulated;
  }

  public void setIndPrepopulated(String indPrepopulated) {
    this.indPrepopulated = indPrepopulated;
  }
  
  public String getCdPersonRole() {
    return cdPersonRole;
  }

  public void setCdPersonRole(String cdPersonRole) {
    this.cdPersonRole = cdPersonRole;
  }
  
  public String getNmPersonFull() {
    return nmPersonFull;
  }

  public void setNmPersonFull(String nmPersonFull) {
    this.nmPersonFull = nmPersonFull;
  }

  public String getCdUnknownParent() {
    return cdUnknownParent;
  }

  public void setCdUnknownParent(String cdUnknownParent) {
    this.cdUnknownParent = cdUnknownParent;
  }

  public String getCdReqAction() {
    return cdReqAction;
  }

  public void setCdReqAction(String cdReqAction) {
    this.cdReqAction = cdReqAction;
  }

  public List<ContactForBean> getChildContactForBeanList() {
    return childContactForBeanList;
  }

  public void setChildContactForBeanList(List<ContactForBean> childContactForBeanList) {
    this.childContactForBeanList = childContactForBeanList;
  }
}
