package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactFor;
import gov.georgia.dhr.dfcs.sacwis.db.ContactForId;
import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.common.SaveContactRule;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveContactRuleSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/20/10  hjbaptiste               Initial creation
 * 03/17/10  bgehlot                  In INSERT action added the set method to set the cdUnknownParent and also not to set the Person
 *                                    as the idPerson is zero for unknown parents
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste Februrary 20, 2010
 */

public class SaveContactRuleImpl extends BaseServiceImpl implements SaveContactRule {

  private final String INSERT = "INSERT";

  ContactRuleDAO contactRuleDAO = null;
  ContactForDAO contactForDAO = null;
  PersonDAO personDAO = null;

  public void setContactRuleDAO(ContactRuleDAO contactRuleDAO) {
    this.contactRuleDAO = contactRuleDAO;
  }

  public void setContactForDAO(ContactForDAO contactForDAO) {
    this.contactForDAO = contactForDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public int saveContactRule(SaveContactRuleSI saveContactRuleSI) throws ServiceException {
    List<ContactRuleBean> contactRuleBeanAUD = saveContactRuleSI.getContactRuleBeanList();
    int returnNumber = 0;
    // Loop thru the list of Contact Rules and determine if we need to Insert, Add, Update or Delete a 
    // Contact Rule. Inserts are done when the user initially clicks the Add button on the Contact Standards List
    // page. Add is called when the user clicks on the Add button on the Contact Standards Detail page. Update is called
    // when user clicks the Save or Save and Submit on the Contact Standards Detail page. Delete is done when the 
    // user clicks the Delete button on the Contact Standards page.
    if(contactRuleBeanAUD != null){
      for (int i = 0; i < contactRuleBeanAUD.size(); i++) {
        ContactRuleBean contactRuleBean = contactRuleBeanAUD.get(i);
        String cdReqAction = contactRuleBean.getCdReqAction();
        if (INSERT.equals(cdReqAction)) {
          Event contactStandardsEvent = (Event) getPersistentObject(Event.class, saveContactRuleSI.getIdEvent());
          ContactRule insertContactRule = new ContactRule();
          insertContactRule.setEvent(contactStandardsEvent);
          // When doing a Copy the Contact Rules for an 'Unknown' person will not have an ID_PERSON associated with them. We do not need
          // to make any references to the Person table for them.
          Person person = new Person ();
          if (contactRuleBean.getUlIdPerson() != 0) {
            person = personDAO.findPersonByIdPerson(contactRuleBean.getUlIdPerson());
            insertContactRule.setPerson(person);
          }else  {
            insertContactRule.setPerson(null);
          }
          
          insertContactRule.setNbrContactsPerMonth(contactRuleBean.getNbrContactsPerMonth());
          insertContactRule.setIndByFaceToFace(contactRuleBean.getIndByFaceToFace());
          insertContactRule.setIndByTelephone(contactRuleBean.getIndByTelephone());
          insertContactRule.setIndByEmailCorrspndnce(contactRuleBean.getIndByEmailCorrspndnce());
          insertContactRule.setCdContactNotRequired(contactRuleBean.getCdContactNotRequired());
          insertContactRule.setCdPersonRole(contactRuleBean.getCdPersonRole());
          insertContactRule.setTxtJustification(contactRuleBean.getTxtJustification());
          insertContactRule.setIndPrepopulated(contactRuleBean.getIndPrepopulated());
          //For Copy Set the cdUnknownParent too.
          insertContactRule.setCdUnknownParent(contactRuleBean.getCdUnknownParent());
          int idContactRule = contactRuleDAO.saveContactRule(insertContactRule);
          // After saving the Contact Rule, save all of the children that the Contact is for. Child Contact
          // Rules do not have a list of Contact For
          List<ContactForBean> contactForBeanList = contactRuleBean.getChildContactForBeanList();
          if (contactForBeanList != null && !contactForBeanList.isEmpty()) {
            Iterator<ContactForBean> contactForBeanList_it = contactForBeanList.iterator();
            while (contactForBeanList_it.hasNext()) {
              ContactForBean contactForBean = contactForBeanList_it.next();
              ContactFor contactFor = new ContactFor();
              Person personChild = (Person) getPersistentObject(Person.class, contactForBean.getUlIdChild());
              ContactForId id = new ContactForId(personChild.getIdPerson(),idContactRule);
              contactFor.setId(id);
              contactFor.setIndContactFor(contactForBean.getIndContactFor());
              contactForDAO.saveContactFor(contactFor);
            }
          }
        }
        else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdReqAction)) {
          Event contactStandardsEvent = (Event) getPersistentObject(Event.class, contactRuleBeanAUD.get(0).getUlIdEvent());
          ContactRule addContactRule = new ContactRule();
          addContactRule.setEvent(contactStandardsEvent);
          addContactRule.setIndPrepopulated(contactRuleBean.getIndPrepopulated());
          int idContactRule = contactRuleDAO.saveContactRule(addContactRule);
          // When adding a new Contact Rule, we need to create and save a list of Contact For for the newly created
          // Contact Rule. We do this by Retrieving all of the Children Contact Rules to determine the Children whom
          // the Contact For can potentially be for. This list will be displayed in the 'Contact For' section of the
          // newly created rule.
          List<String> roles = new ArrayList<String>();
          roles.add(CodesTables.CPARROLE_CHL);
          List<ContactRule> childContactRuleList = contactRuleDAO.findContactRulesByIdEventCdPersonRole(contactStandardsEvent.getIdEvent(), roles);
          for(int j = 0; j < childContactRuleList.size(); j++) {
            ContactRule childContactRule = childContactRuleList.get(j);
            ContactFor contactFor = new ContactFor();
            Person personChild = (Person) getPersistentObject(Person.class, childContactRule.getPerson().getIdPerson());
            ContactForId id = new ContactForId(personChild.getIdPerson(),addContactRule.getIdContactRule());
            contactFor.setId(id);
            contactForDAO.saveContactFor(contactFor);
          }

        }
        else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdReqAction)) {
          if (contactRuleBeanAUD != null && !contactRuleBeanAUD.isEmpty()) {
            Event contactStandardsEvent = (Event) getPersistentObject(Event.class, saveContactRuleSI.getIdEvent());
            ContactRule updateContactRule = (ContactRule) getPersistentObject(ContactRule.class, contactRuleBean.getUlIdContactRule());
            updateContactRule.setEvent(contactStandardsEvent);
            // The Contact Rules for an 'Unknown' person will not have an ID_PERSON associated with them. We do not need
            // to make any references to the Person table for them.
            Person person = new Person();
            if (contactRuleBean.getUlIdPerson() != 0) {
              person = (Person) getPersistentObject(Person.class, contactRuleBean.getUlIdPerson());
              updateContactRule.setPerson(person);
            } else  {
              updateContactRule.setPerson(null);
            }
            updateContactRule.setCdPersonRole(contactRuleBean.getCdPersonRole());
            updateContactRule.setNbrContactsPerMonth(new Integer(contactRuleBean.getNbrContactsPerMonth()));
            updateContactRule.setIndByFaceToFace(contactRuleBean.getIndByFaceToFace());
            updateContactRule.setIndByTelephone(contactRuleBean.getIndByTelephone());
            updateContactRule.setIndByEmailCorrspndnce(contactRuleBean.getIndByEmailCorrspndnce());
            updateContactRule.setCdContactNotRequired(contactRuleBean.getCdContactNotRequired());
            updateContactRule.setTxtJustification(contactRuleBean.getTxtJustification());
            updateContactRule.setIndPrepopulated(contactRuleBean.getIndPrepopulated());
            updateContactRule.setCdUnknownParent(contactRuleBean.getCdUnknownParent());
            contactRuleDAO.saveContactRule(updateContactRule);
            // Update the list of Contact For for the Parent Contact Rules. Child Contact
            // Rules do not have a list of Contact For
            List<ContactForBean> contactForBeanList = contactRuleBean.getChildContactForBeanList();
            if (contactForBeanList != null && !contactForBeanList.isEmpty()) {
              Iterator<ContactForBean> contactForBeanList_it = contactForBeanList.iterator();
              while (contactForBeanList_it.hasNext()) {
                ContactForBean contactForBean = contactForBeanList_it.next();
                ContactFor contactFor = (contactForDAO.findContactForByIdContactRuleIdChild(contactRuleBean.getUlIdContactRule(), contactForBean.getUlIdChild()));
                contactFor.setIndContactFor(contactForBean.getIndContactFor());
                contactForDAO.saveContactFor(contactFor);
              }
            }
          }
        }
        else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdReqAction)) {
          int idContactRule = contactRuleBean.getUlIdContactRule();
          int numOfDelete = contactForDAO.deleteAllContactForsByIdContactRule(idContactRule);
          ContactRule deleteContactRule = (ContactRule)getPersistentObject(ContactRule.class, idContactRule);
          contactRuleDAO.deleteContactRule(deleteContactRule);
        }
      }
    }
    return returnNumber;
  }

}
