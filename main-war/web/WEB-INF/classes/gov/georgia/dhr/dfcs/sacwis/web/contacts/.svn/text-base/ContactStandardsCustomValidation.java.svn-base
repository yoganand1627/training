package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * ParentContactStandards.jsp Custom validation class
 * 
 * @author Herve Jean-Baptiste February 13, 2010
 * @version 1.0
 * 
 * <pre>
 * Change History:
 * Date           User                Description
 * ----------     ---------------     ------------------------------------------------------
 * 02/18/2010     bgehlot             Adding business logic for pre-population of Parent Contact Rules from the Person Detail,
 *                                    and logic for all the other buttons on the Page.
 * 
 * </pre>
 */
@SuppressWarnings("serial")
public class ContactStandardsCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "ContactStandardsCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    BaseSessionStateManager state = getState();
    boolean result = true;

    ContactStandardsRetrieveSO contactStandardsRetrieveSO = 
      (ContactStandardsRetrieveSO) state.getAttribute("contactStandardsRetrieveSO", request);
    List<ContactRuleBean> parentContactRuleBeanList = contactStandardsRetrieveSO.getParentContactRuleBeanList();

    if (super.isButtonPressed("btnSaveAndSubmit") || super.isButtonPressed("btnSave") || (GlobalData.isApprovalMode(request) && super.isButtonPressed("btnApprovalStatusFinal"))){
      boolean contactForNotSelected = false;
      boolean prepopulated = true;
      if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
        int i=0;
        Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
        while (iterParent.hasNext()) {
          ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
          if(!ArchitectureConstants.Y.equals(contactRuleBean.getIndPrepopulated())){
            List<ContactForBean> contactForBeanList = contactRuleBean.getChildContactForBeanList();
            prepopulated = false;
            if(contactForBeanList != null && !contactForBeanList.isEmpty()){
              int j=0;
              Iterator<ContactForBean> iterContactFor = contactForBeanList.iterator();
              while (iterContactFor.hasNext()) {
                ContactForBean contactForBean = (ContactForBean) iterContactFor.next();
                String indContactFor = CheckboxHelper.getCheckboxValue(request, "cbxIndContactFor" + i + "_" + j);
                if(ArchitectureConstants.Y.equals(indContactFor)){
                  contactForNotSelected = false;
                  break;
                }else{
                  contactForNotSelected = true;
                }
                j++;
              }
            }
          }
          if(contactForNotSelected){
            break;
          }
          i++;
        }
        if(contactForNotSelected && !prepopulated){
          setErrorMessage(Messages.MSG_CS_CONTACT_FOR_REQ);
          result = false;
        }
      }
    }

    if (super.isButtonPressed("btnSaveAndSubmit") || super.isButtonPressed("btnSave") || (GlobalData.isApprovalMode(request) && super.isButtonPressed("btnApprovalStatusFinal"))){

      //User enters zero in the # of Contacts per Month in Parent Contact Rules Section and has not selected 
      //Contact Not Required and clicks on Save or Save And Submit button
      String persons = "";
      boolean zeroContactPerMonths = false;
      if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
        int i=0;
        Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
        while (iterParent.hasNext()) {
          ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
          
          //Get the name of the Person
          String nmPersonValue = getPersonName(contactRuleBean,i);
          
          int nbrContactsPerMonth = ContextHelper.getIntSafe(request, "nbrParentContactsPerMonth" + i);
          String cdContactNotRequired = ContextHelper.getStringSafe(request, "cdContactNotRequired" + i);
          if(nbrContactsPerMonth == 0 && "".equals(cdContactNotRequired)){
            persons = persons + nmPersonValue + "- ";
            zeroContactPerMonths = true;
          }
          i++;
        }
        if(zeroContactPerMonths){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_CONTACT_ZERO), persons));
          result = false;
        }
      }

      //User selects one of the 'Contact Not Required options':
      //Unable to locate,
      //Not Interested,
      //Deceased,
      //Other
      //and do not enter comments in the Justification textbox and clicks on Save or Save and Submit button.
      persons = "";
      boolean justificationEntered = false;
      if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
        int i=0;
        Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
        while (iterParent.hasNext()) {
          ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
          
          //Get the name of the Person
          String nmPersonValue = getPersonName(contactRuleBean,i);
          
          String txtJustification = ContextHelper.getStringSafe(request, "txtJustification" + i);
          String cdContactNotRequired = ContextHelper.getStringSafe(request, "cdContactNotRequired" + i);
          if((cdContactNotRequired != null && !"".equals(cdContactNotRequired) )&& !CodesTables.CCONNREQ_NRU.equals(cdContactNotRequired) 
                          && (txtJustification == null || "".equals(txtJustification))){
            persons = persons + nmPersonValue + "- ";
            justificationEntered = true;
          }
          i++;
        }
        if(justificationEntered){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_CNR_JUST_REQ), persons));
          result = false;
        }
      }
      
      //User enters some value in the # of Contacts per Month in Parent Contact Rules Section and has not selected 
      //Contact Methods and clicks on Save or Save And Submit button
      persons = "";
      zeroContactPerMonths = false;
      if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
        int i=0;
        Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
        while (iterParent.hasNext()) {
          ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
          
          //Get the name of the Person
          String nmPersonValue = getPersonName(contactRuleBean,i);
          
          int nbrContactsPerMonth = ContextHelper.getIntSafe(request, "nbrParentContactsPerMonth" + i);
          String indByFaceToFace = CheckboxHelper.getCheckboxValue(request, "indByFaceToFace_" + i);
          String indByTelephone = CheckboxHelper.getCheckboxValue(request, "indByTelephone_" + i);
          String indByEmailCorrspndnce = CheckboxHelper.getCheckboxValue(request, "indByEmailCorrspndnce_" + i);
          if(nbrContactsPerMonth > 0 && ((indByFaceToFace == null || "".equals(indByFaceToFace) || ArchitectureConstants.N.equals(indByFaceToFace)) && 
                                         (indByTelephone == null || "".equals(indByTelephone) || ArchitectureConstants.N.equals(indByTelephone)) &&
                                         (indByEmailCorrspndnce == null || "".equals(indByEmailCorrspndnce) || ArchitectureConstants.N.equals(indByEmailCorrspndnce)))){
            persons = persons + nmPersonValue + "- ";
            zeroContactPerMonths = true;
          }
          i++;
        }
        if(zeroContactPerMonths){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_CONTACT_METHODS_REQ), persons));
          result = false;
        }
      }
    }

      if (super.isButtonPressed("btnSaveAndSubmit")) {
      // User does not enter a Reason for Change in Contact Standards and clicks on Save and Submit button.
      String txtReasonForChange = ContextHelper.getStringSafe(request, "txtReasonForChange");
      String indCmAcknowledge = CheckboxHelper.getCheckboxValue(request, "indCmAcknowledge");
      if (txtReasonForChange == null || "".equals(txtReasonForChange)) {
        setErrorMessage(Messages.MSG_CS_REASON_CONTACT_STD_CHANGE);
        result = false;
      }

      if (indCmAcknowledge == null || "".equals(indCmAcknowledge) || ArchitectureConstants.N.equals(indCmAcknowledge)) {
        setErrorMessage(Messages.MSG_CS_CM_ACKNOWLEDGE);
        result = false;
      }
    }

    if(super.isButtonPressed("btnDelete")){
      //User has not selected any row in the Parent Contact Rules and clicks on Delete button.
      boolean delCheckboxSelected = false;
      if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
        int i=0;
        Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
        while (iterParent.hasNext()) {
          ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
          String delCheckBox = CheckboxHelper.getCheckboxValue(request, "delCheckBox_" + i);
          if (ArchitectureConstants.Y.equals(delCheckBox)) {
            delCheckboxSelected = true;
            break;
          }
          i++;
        }
        if(delCheckboxSelected == false){
          setErrorMessage(Messages.MSG_CS_SELECT_ROW_DELETE);
          result = false;
        }
      }

      //User attempts to delete the pre-populated Parent Contact Rule.

      String parent = "";
      String children = "";
      if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
        int i=0;
        Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
        while (iterParent.hasNext()) {
          ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
          String delCheckBox = CheckboxHelper.getCheckboxValue(request, "delCheckBox_" + i);
          if (ArchitectureConstants.Y.equals(delCheckBox) && ArchitectureConstants.Y.equals(contactRuleBean.getIndPrepopulated())) {
            parent = parent + contactRuleBean.getNmPersonFull() + "- ";
            List<ContactForBean> contactForBeanList = contactRuleBean.getChildContactForBeanList();
            if(contactForBeanList != null && !contactForBeanList.isEmpty()){
              Iterator<ContactForBean> iterContactFor = contactForBeanList.iterator();
              while (iterContactFor.hasNext()) {
                ContactForBean contactForBean = (ContactForBean) iterContactFor.next();
                if(ArchitectureConstants.Y.equals(contactForBean.getIndContactFor())){
                  children = children + contactForBean.getNmPersonFull() + "- ";
                }
              }
            }
          }
          i++;
        }
        if(!"".equals(parent)){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_DELETE_PRE_POPULATED_RULE), children));
          result = false;
        }
      }
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }
  
  /**
   * Get the name of the person to be displayed in the error message
   * @param contactRuleBean
   * @param i
   * @return
   */
  @SuppressWarnings("unchecked")
  private String getPersonName(ContactRuleBean contactRuleBean, int i){
    HttpServletRequest request = getRequest();
    BaseSessionStateManager state = getState();
    
    List<Option> personNameList = (List<Option>) state.getAttribute("personNameList", request);
    // Not all Parent Contact Rules are for person with an id_person. If the id_person is set to zero,
    // 'Unknown Mother' or 'Unknown Father' needs to be displayed base on the user's selection 
    String nmPersonValue = "";
    String nmPersonId = ContextHelper.getStringSafe(request, "nmPerson" + i);
    if(!ArchitectureConstants.Y.equals(contactRuleBean.getIndPrepopulated())){
      //Get the name of the person from the Options List which has Name and Person Id in it.
      if(personNameList != null && !personNameList.isEmpty()){
        Iterator<Option> iterNmPerson = personNameList.iterator();
        while (iterNmPerson.hasNext()) {
          Option option = (Option) iterNmPerson.next();
          if(nmPersonId.equals(option.getKey())){
            nmPersonValue = option.getValue();
            break;
          }
        }
      }
    }else{
      nmPersonValue = ContextHelper.getStringSafe(request, "nmPerson" + i);
    }
    return nmPersonValue;
  }
}
