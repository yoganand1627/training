package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactFor;
import gov.georgia.dhr.dfcs.sacwis.db.ContactForId;
import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.common.PrepopulateContactStandards;
import gov.georgia.dhr.dfcs.sacwis.service.common.SaveContactRule;
import gov.georgia.dhr.dfcs.sacwis.service.common.SyncContactRule;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveContactRuleSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Herve Jean-Baptiste
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   02/13/2010   hjbaptiste               Initial Creation
 *   02/18/2010   bgehlot                  Added initial business logic for doing the sync.
 *   
 * </pre>
 * 
 */

public class SyncContactRuleImpl extends BaseServiceImpl implements SyncContactRule {
  private final String INSERT = "INSERT";

  private ContactRuleDAO contactRuleDAO = null;

  private ContactForDAO contactForDAO = null;

  private EventDAO eventDAO = null;

  private SaveContactRule saveContactRule = null;
  
  private PrepopulateContactStandards prepopulateContactStandards = null;


  public void setContactForDAO(ContactForDAO contactForDAO){
    this.contactForDAO = contactForDAO;
  }

  public void setContactRuleDAO(ContactRuleDAO contactRuleDAO){
    this.contactRuleDAO = contactRuleDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setSaveContactRule(SaveContactRule saveContactRule) {
    this.saveContactRule = saveContactRule;
  }


  public void setPrepopulateContactStandards(PrepopulateContactStandards prepopulateContactStandards) {
    this.prepopulateContactStandards = prepopulateContactStandards;
  }

  public int syncContactRule(ContactStandardsRetrieveSI contactStandardsRetrieveSI) {
    ContactStandardsRetrieveSO contactStandardsRetrieveSO = new ContactStandardsRetrieveSO();
    int idEvent = contactStandardsRetrieveSI.getUlIdEvent();
    int idStage = contactStandardsRetrieveSI.getUlIdStage();
    contactStandardsRetrieveSO = prepopulateContactStandards.prepopulateContactStandards(contactStandardsRetrieveSI);
    contactStandardsRetrieveSO.setUlIdStage(idStage);
    contactStandardsRetrieveSO.setCdTask(contactStandardsRetrieveSI.getCdTask());
    contactStandardsRetrieveSO.setUlIdEvent(idEvent);
    contactStandardsRetrieveSO.setUlIdUser(contactStandardsRetrieveSI.getUserId());
    
    Event event = new Event();
    // Let's find the event
    event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    } 
    // Sync is not necessary for Pending and Approved events. Therefore, just return.
    if(CodesTables.CEVTSTAT_PEND.equals(event.getCdEventStatus()) || CodesTables.CEVTSTAT_APRV.equals(event.getCdEventStatus())){
      return idEvent;
    }
    
    SaveContactRuleSI saveContactRuleSI = new SaveContactRuleSI();
    // Create the list of Contact Rules by performing the sync
    List<ContactRuleBean> childContactRuleBeanList = syncChildContactRules(contactStandardsRetrieveSO);
    List<ContactRuleBean> parentContactRuleBeanList = syncParentContactRules(contactStandardsRetrieveSO); 
    // Combine the two lists of Contact Rules to make one list prior to calling the save service.
    List<ContactRuleBean> allContactRuleBeanList = new ArrayList<ContactRuleBean>();
    allContactRuleBeanList.addAll(childContactRuleBeanList);
    allContactRuleBeanList.addAll(parentContactRuleBeanList);
    saveContactRuleSI.setIdEvent(idEvent);
    saveContactRuleSI.setContactRuleBeanList(allContactRuleBeanList);
    
    saveContactRule.saveContactRule(saveContactRuleSI);

    return idEvent;
  }

  /**
   * This is a helper method that retrieves the list of Child Contact Rules from the database.
   * 
   * @param contactStandardsRetrieveSO
   * @return List of {@link ContactRuleBean}
   */
  private  List<ContactRuleBean>  syncChildContactRules(ContactStandardsRetrieveSO contactStandardsRetrieveSO){

    int idEvent = contactStandardsRetrieveSO.getUlIdEvent();
    List<String> roles = new ArrayList<String>();
    roles.add(CodesTables.CPARROLE_CHL);
    // Find all Child Contact Rules in the database for this particular event
    List<ContactRule> childContactRuleList = contactRuleDAO.findContactRulesByIdEventCdPersonRole(idEvent, roles);
    List<ContactRuleBean> childContactRuleBeanListPrepopulated = contactStandardsRetrieveSO.getChildContactRuleBeanList();
    // Call the main sync method to do the sync
    List<ContactRuleBean> childContactRuleBeanList = syncContactRules(childContactRuleList, childContactRuleBeanListPrepopulated);
    return childContactRuleBeanList;
  }
  
  /**
   * This is a helper method that retrieves the list of Parental Contact Rules from the database.
   * 
   * @param contactStandardsRetrieveSO
   * @return List of {@link ContactRuleBean}
   */
  private List<ContactRuleBean> syncParentContactRules(ContactStandardsRetrieveSO contactStandardsRetrieveSO) {
    int idEvent = contactStandardsRetrieveSO.getUlIdEvent();
    // Create a list of Parental Roles
    List<String> roles = new ArrayList<String>();
    roles.add(CodesTables.CPARROLE_MOT);
    roles.add(CodesTables.CPARROLE_FAT);
    roles.add(CodesTables.CPARROLE_CTK);
    
    List<ContactRule> parentContactRuleList = contactRuleDAO.findContactRulesByIdEventRolesIndPrepopulate(idEvent, roles, ServiceConstants.FND_YES);
    List<ContactRuleBean> parentContactRuleBeanListPrepopulated = contactStandardsRetrieveSO.getParentContactRuleBeanList();
    // Call the main sync method to do the sync
    List<ContactRuleBean> parentContactRuleBeanList = syncContactRules(parentContactRuleList, parentContactRuleBeanListPrepopulated);
    return parentContactRuleBeanList;
  }
  
  /**
   * This is the main helper method where the sync is actually being done.
   * 
   * @param contactRuleList
   * @param contactRuleBeanListPrepopulated
   * @return List {@link ContactRuleBean}
   */
  private List<ContactRuleBean> syncContactRules(List<ContactRule> contactRuleList, List<ContactRuleBean> contactRuleBeanListPrepopulated) {
    // Put the list of pre-populated contacts standards into an array list which
    // will be used for searching against with existing rules
    List<Integer> contactRuleBeanPrepopulatedIdPersonList = new ArrayList<Integer>();
    if(contactRuleBeanListPrepopulated != null && !contactRuleBeanListPrepopulated.isEmpty()){
      Iterator<ContactRuleBean> iterChildPrepopulated = contactRuleBeanListPrepopulated.iterator();
      while (iterChildPrepopulated.hasNext()) {
        ContactRuleBean contactRuleBeanPrePopulated = (ContactRuleBean) iterChildPrepopulated.next();
        contactRuleBeanPrepopulatedIdPersonList.add(contactRuleBeanPrePopulated.getUlIdPerson());
      }
    }
    // Loop through the list of existing contact rules and see if they are in the
    // prepopulated contact rule list.  If they are not then delete them.  This code
    // also sets-up the insert code later by removing items from the prepopulated list
    // that already exist within the contact rules.
    List<ContactRuleBean> contactRuleBeanList = new ArrayList<ContactRuleBean>();
    if(contactRuleList != null && !contactRuleList.isEmpty()){ 
      Iterator<ContactRule> iterChild = contactRuleList.iterator();
      while (iterChild.hasNext()) {
        ContactRule contactRule = (ContactRule) iterChild.next();
        int idPerson = contactRule.getPerson().getIdPerson();
          if(contactRuleBeanPrepopulatedIdPersonList.contains(idPerson)){
            int index = contactRuleBeanPrepopulatedIdPersonList.indexOf(idPerson);
            //Now that we have confirmed that the rule exists, we now need to check
            //that the Contact For values are the same.
            syncContactFor(contactRule, contactRuleBeanListPrepopulated.get(index));

            // Must remove from both lists so that the indexes remain consistent
            // since we use the arraylist of person ids to remove from the contact rule list.
            contactRuleBeanPrepopulatedIdPersonList.remove(index);
            contactRuleBeanListPrepopulated.remove(index);
          }
          // This Contact Rule needs to be marked for deletion since it exists in the database
          // but doesn't exist in the list of prepopulated Contact Rules.
          else{          
            ContactRuleBean contactRuleBean = new ContactRuleBean();
            contactRuleBean.setUlIdContactRule(contactRule.getIdContactRule());
            contactRuleBean.setCdReqAction(ServiceConstants.REQ_FUNC_CD_DELETE);
            contactRuleBeanList.add(contactRuleBean);
          }
      }
    } 
    
    //  Add the remaining contact rules in the prepopulated list that were not removed in the earlier
    //  delete logic.
    if(contactRuleBeanListPrepopulated != null && !contactRuleBeanListPrepopulated.isEmpty()){
      Iterator<ContactRuleBean> iterChildPrepopulated = contactRuleBeanListPrepopulated.iterator();
      while (iterChildPrepopulated.hasNext()) {
        ContactRuleBean contactRuleBeanPrePopulated = (ContactRuleBean) iterChildPrepopulated.next();
        ContactRuleBean contactRuleBean = new ContactRuleBean();
        // Marking the Contact Rule for Insert since it is being newly created
        contactRuleBean.setCdReqAction(INSERT);
        contactRuleBean.setNbrContactsPerMonth(contactRuleBeanPrePopulated.getNbrContactsPerMonth());
        contactRuleBean.setCdContactNotRequired(contactRuleBeanPrePopulated.getCdContactNotRequired());
        contactRuleBean.setCdPersonRole(contactRuleBeanPrePopulated.getCdPersonRole());
        contactRuleBean.setIndByFaceToFace(contactRuleBeanPrePopulated.getIndByFaceToFace());
        contactRuleBean.setIndByTelephone(contactRuleBeanPrePopulated.getIndByTelephone());
        contactRuleBean.setIndByEmailCorrspndnce(contactRuleBeanPrePopulated.getIndByEmailCorrspndnce());
        contactRuleBean.setUlIdPerson(contactRuleBeanPrePopulated.getUlIdPerson());
        contactRuleBean.setIndPrepopulated(contactRuleBeanPrePopulated.getIndPrepopulated());
        contactRuleBean.setTxtJustification(contactRuleBeanPrePopulated.getTxtJustification());
        contactRuleBean.setChildContactForBeanList(contactRuleBeanPrePopulated.getChildContactForBeanList());
        contactRuleBeanList.add(contactRuleBean);
      }
    }

    return contactRuleBeanList;
  }
  
  /**
   * This method syncs the list of Contact For that currently exist in the databse with the 
   * list of prepopulated Contact For.
   *  
   * @param savedRule
   * @param prepopulatedRule
   */
  private void syncContactFor(ContactRule savedRule, ContactRuleBean prepopulatedRule) {

    // Put the list of pre-populated contacts for records into an array list which
    // will be used for searching against with existing rules
    List<ContactForBean> preContactForList = prepopulatedRule.getChildContactForBeanList();
    List<Integer> contactForIdPersonList = new ArrayList<Integer>();
    if (preContactForList != null) {
      Iterator<ContactForBean> iter1 = preContactForList.iterator();
      while (iter1.hasNext()) {
        ContactForBean contactFor = iter1.next();
        contactForIdPersonList.add(contactFor.getUlIdChild());
      }
    }

    // Get the current Contact For list for the saved parent rule
    List<ContactFor> savedForList = contactForDAO.findContactForByIdContactRule(savedRule.getIdContactRule());
    if (savedForList != null) {
      Iterator<ContactFor> savedIter = savedForList.iterator();
      while (savedIter.hasNext()) {
        ContactFor contactFor = savedIter.next();
        // If the child id isn't found in the array that means the record can be deleted
        if (!contactForIdPersonList.contains(contactFor.getPersonChild().getIdPerson())) {
          contactForDAO.deleteContactFor(contactFor);
        } else {
          // Update the contactFor Record
          int index = contactForIdPersonList.indexOf(contactFor.getPersonChild().getIdPerson());
          ContactForBean contactForBean = preContactForList.get(index);
          contactFor.setIndContactFor(contactForBean.getIndContactFor());
          contactForDAO.saveContactFor(contactFor);
          
          // Must remove from both lists so that the indexes remain consistent
          // since we use the arraylist of person ids to remove from the contact for list.
          contactForIdPersonList.remove(index);
          preContactForList.remove(index);
        }
      }
    }
 
    // Just in case there are any ids that are remaining in Contact For they should
    // be added.
    if (preContactForList != null && !preContactForList.isEmpty()) {
      Iterator<ContactForBean> iterContactFor = preContactForList.iterator();
      while (iterContactFor.hasNext()) {
        ContactForBean contactForBean = iterContactFor.next();
        ContactFor contactFor = new ContactFor();
        Person personChild = (Person) getPersistentObject(Person.class, contactForBean.getUlIdChild());
        ContactForId id = new ContactForId(personChild.getIdPerson(), savedRule.getIdContactRule());
        contactFor.setId(id);
        contactFor.setIndContactFor(contactForBean.getIndContactFor());
        contactForDAO.saveContactFor(contactFor);
      }
    }

  }
  
}