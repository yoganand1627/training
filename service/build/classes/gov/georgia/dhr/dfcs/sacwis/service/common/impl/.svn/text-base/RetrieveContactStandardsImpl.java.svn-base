package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactStandardsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactFor;
import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;
import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveContactStandards;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Herve Jean-Baptiste
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   02/13/2010   hjbaptiste               Initial Creation
 *   02/18/2010   bgehlot                  Adding business logic for retrieving the information from the Contact Standard 
 *                                         and Contact rule and Contact for and setting them to the RetrieveSO object
 *   03/18/2010   bgehlot                  SMS#45718 Changed the method names and queries to return results for stage rather than case for FPR
 *   04/27/2010   bgehlot                  MR-064: Changed the method name and query to pre-populate children under the age of 18 
 *                                         that are members of the primary caretaker's household. for FPR.
                 
 *   
 * </pre>
 * 
 */

public class RetrieveContactStandardsImpl extends BaseServiceImpl implements RetrieveContactStandards {

  private ContactStandardsDAO contactStandardsDAO = null;

  private EventDAO eventDAO = null;

  private ContactRuleDAO contactRuleDAO = null;

  private ContactForDAO contactForDAO = null;

  private PersonDAO personDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;  


  public void setContactStandardsDAO(ContactStandardsDAO contactStandardsDAO) {
    this.contactStandardsDAO = contactStandardsDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setContactRuleDAO(ContactRuleDAO contactRuleDAO){
    this.contactRuleDAO = contactRuleDAO;
  }

  public void setContactForDAO(ContactForDAO contactForDAO){
    this.contactForDAO = contactForDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public ContactStandardsRetrieveSO retrieveContactStandards(ContactStandardsRetrieveSI contactStandardsRetrieveSI) {
    ContactStandardsRetrieveSO contactStandardsRetrieveSO = new ContactStandardsRetrieveSO();
    int idEvent = contactStandardsRetrieveSI.getUlIdEvent();
    int idStage = contactStandardsRetrieveSI.getUlIdStage();
    int idCase = contactStandardsRetrieveSI.getUlIdCase();

    String cdEventStatus = "";
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event != null) {
      cdEventStatus = event.getCdEventStatus(); 
      contactStandardsRetrieveSO.setDtEventLastUpdate(event.getDtLastUpdate());
    }

    String cdStage = contactStandardsRetrieveSI.getCdStage();
    List<Integer> childrenList = new ArrayList<Integer>();

    List<Integer> personsManuallyAddedList = new ArrayList<Integer>();
    if(CodesTables.CSTAGES_FSU.equals(cdStage)){
      //If the stage is FCF then get all the Children from their FCC stages for that case
      childrenList = stagePersonLinkDAO.findAllChildrenFCCStagesByIdCase(idCase);
      //Get all the Principals from each of the child's FCC stage for that case
      personsManuallyAddedList = stagePersonLinkDAO.findAllPersonFCCByIdCase(idCase);
    }else if(CodesTables.CSTAGES_FPR.equals(cdStage)){
      //If the stage is ONG then get all the Children for that stage
      //MR-064 Changed the method name and query to pre-populate children under the age of 18 
      //that are members of the primary caretaker's household for FPR.
      childrenList = stagePersonLinkDAO.findAllChildrenFPRStagesByIdStage(idStage);
      //Get all the Principals from ONG stage for that stage
      personsManuallyAddedList = stagePersonLinkDAO.findAllPersonFPRByIdStage(idStage);
    }

    List<Map<String, Object>> personsManuallyAddedMapList = createPersonNameList(childrenList, personsManuallyAddedList,idEvent);
    contactStandardsRetrieveSO.setPersonsManuallyAddedMapList(personsManuallyAddedMapList); 

    //Find the contact standard for the given event and set the fields to the contactStandardsRetrieveSO object
    ContactStandards contactStandards = contactStandardsDAO.findContactStandardsByIdEvent(idEvent);
    contactStandardsRetrieveSO.setUlIdEvent(idEvent);
    contactStandardsRetrieveSO.setUlIdStage(idStage);
    contactStandardsRetrieveSO.setUlIdCase(idCase);
    contactStandardsRetrieveSO.setCdEventStatus(cdEventStatus);
    if(contactStandards != null){
      contactStandardsRetrieveSO.setDtEffectiveEnd(contactStandards.getDtEffectiveEnd());
      contactStandardsRetrieveSO.setDtEffectiveStart(contactStandards.getDtEffectiveStart());
      contactStandardsRetrieveSO.setIndCmAcknowledge(contactStandards.getIndCmAcknowledge());
      contactStandardsRetrieveSO.setIndSuperApproval(contactStandards.getIndSuperApproval());
      contactStandardsRetrieveSO.setTxtReasonForChange(contactStandards.getTxtReasonForChange());
    }

    
    //Get all the parent Contact Rules for that idEvent and Roles of Parents
    List<String> roles = new ArrayList<String>();
    roles.add(CodesTables.CPARROLE_MOT);
    roles.add(CodesTables.CPARROLE_FAT);
    roles.add(CodesTables.CPARROLE_CTK);

    List<ContactRule> parentContactRuleList = contactRuleDAO.findAllParentContactRulesByIdEventIncludeNew(idEvent, roles);

    List<ContactRuleBean> parentContactRuleBeanList = new ArrayList<ContactRuleBean>();

    //Loop Thru the Parent Contact Rule list and
    //1. Create a new ContactRuleBean for each Parent Contact Rule
    //2. Set all the fields of this bean to the one from the Database
    //3. For each Contact Rule get all the Contact Fors from the Database
    //4. Loop thru the contact for list and create a new contactForBean for each contact for. Put them in list
    //5. Set that list in the ContactRuleBean
    //6.Put all the ContactRuleBean in a list
    //7. Set that list in contactStandardsRetrieveSO object
    
    if(parentContactRuleList != null && !parentContactRuleList.isEmpty()){
      Iterator<ContactRule> iterParent = parentContactRuleList.iterator();
      while (iterParent.hasNext()) {
        ContactRule contactRule = (ContactRule) iterParent.next();
        ContactRuleBean contactRuleBean = new ContactRuleBean();
        contactRuleBean.setCdContactNotRequired(contactRule.getCdContactNotRequired());
        contactRuleBean.setCdPersonRole(contactRule.getCdPersonRole());
        contactRuleBean.setIndByEmailCorrspndnce(contactRule.getIndByEmailCorrspndnce());
        contactRuleBean.setIndByFaceToFace(contactRule.getIndByFaceToFace());
        contactRuleBean.setIndByTelephone(contactRule.getIndByTelephone());
        contactRuleBean.setIndPrepopulated(contactRule.getIndPrepopulated());
        contactRuleBean.setNbrContactsPerMonth(contactRule.getNbrContactsPerMonth() != null ? contactRule.getNbrContactsPerMonth() : 0);
        contactRuleBean.setTxtJustification(contactRule.getTxtJustification());
        contactRuleBean.setCdUnknownParent(contactRule.getCdUnknownParent());
        contactRuleBean.setUlIdContactRule(contactRule.getIdContactRule());
        String nmPersonFull = "";
        if(contactRule.getPerson() != null && contactRule.getPerson().getIdPerson() != 0){
          contactRuleBean.setUlIdPerson(contactRule.getPerson().getIdPerson());
          nmPersonFull = personDAO.findNmFullByIdPerson(contactRule.getPerson().getIdPerson());
        }
        contactRuleBean.setNmPersonFull(nmPersonFull);
        
        //Get all the contact fors for the Contact Rule
        List<ContactFor> contactForList = contactForDAO.findContactForByIdContactRule(contactRule.getIdContactRule());
        
        //Loop thru the contact for list and create a new contactForBean for each contact for. Put them in list
        Iterator<ContactFor> iterContactFor = contactForList.iterator();
        if(contactForList != null && !contactForList.isEmpty()){
          List<ContactForBean> contactForBeanList = new ArrayList<ContactForBean>();
          while (iterContactFor.hasNext()) {
            ContactForBean contactForBean = new ContactForBean();
            ContactFor contactFor = (ContactFor) iterContactFor.next();
            contactForBean.setIndContactFor(contactFor.getIndContactFor());
            contactForBean.setUlIdContactRule(contactFor.getContactRule().getIdContactRule());
            contactForBean.setUlIdChild(contactFor.getPersonChild().getIdPerson());
            String nmPersonFullChild = "";
            nmPersonFullChild = personDAO.findNmFullByIdPerson(contactFor.getPersonChild().getIdPerson());
            contactForBean.setNmPersonFull(nmPersonFullChild);
            contactForBeanList.add(contactForBean);
          }  
          contactRuleBean.setChildContactForBeanList(contactForBeanList);
        }
        parentContactRuleBeanList.add(contactRuleBean);
      }
    }
    contactStandardsRetrieveSO.setParentContactRuleBeanList(parentContactRuleBeanList);


    //Get all the Child Contact Rule
    roles = new ArrayList<String>();
    roles.add(CodesTables.CPARROLE_CHL);

    List<ContactRule> childContactRuleList = contactRuleDAO.findContactRulesByIdEventCdPersonRole(idEvent, roles);
    
    List<ContactRuleBean> childContactRuleBeanList = new ArrayList<ContactRuleBean>();    

    //Loop Thru the Child Contact Rule list and
    //1. Create a new ContactRuleBean for each Child Contact Rule
    //2.Put all the ContactRuleBean in a list
    //3. Set that list in contactStandardsRetrieveSO object
    if(childContactRuleList != null && !childContactRuleList.isEmpty()){ 
      Iterator<ContactRule> iterChild = childContactRuleList.iterator();
      while (iterChild.hasNext()) {
        ContactRule contactRule = (ContactRule) iterChild.next();
        ContactRuleBean contactRuleBean = new ContactRuleBean();
        contactRuleBean.setCdContactNotRequired(contactRule.getCdContactNotRequired());
        contactRuleBean.setCdPersonRole(contactRule.getCdPersonRole());
        contactRuleBean.setIndByEmailCorrspndnce(contactRule.getIndByEmailCorrspndnce());
        contactRuleBean.setIndByFaceToFace(contactRule.getIndByFaceToFace());
        contactRuleBean.setIndByTelephone(contactRule.getIndByTelephone());
        contactRuleBean.setIndPrepopulated(contactRule.getIndPrepopulated());
        contactRuleBean.setNbrContactsPerMonth(contactRule.getNbrContactsPerMonth() != null ? contactRule.getNbrContactsPerMonth() : 0);
        contactRuleBean.setTxtJustification(contactRule.getTxtJustification());
        contactRuleBean.setUlIdContactRule(contactRule.getIdContactRule());
        String nmPersonFull = "";
        if(contactRule.getPerson() != null){
          contactRuleBean.setUlIdPerson(contactRule.getPerson().getIdPerson());
          nmPersonFull = personDAO.findNmFullByIdPerson(contactRule.getPerson().getIdPerson());
          contactRuleBean.setUlIdPerson(contactRule.getPerson().getIdPerson());
        }
        contactRuleBean.setNmPersonFull(nmPersonFull);
        childContactRuleBeanList.add(contactRuleBean);
      }
    }
    contactStandardsRetrieveSO.setChildContactRuleBeanList(childContactRuleBeanList);

    return contactStandardsRetrieveSO;
  }

  /**
   * This method creates a list of persons that will display in the Name drop down of the manually added Contact Rules
   * @param childrenList
   * @param personsManuallyAddedList
   * @param idEvent
   * @return
   */
  List<Map<String, Object>> createPersonNameList(List<Integer> childrenList, List<Integer> personsManuallyAddedList, int idEvent){

    List<Integer> personsManuallyAddedTempList = new ArrayList<Integer>();
    List<Map<String, Object>> personsManuallyAddedMapList = new ArrayList<Map<String, Object>>();

    //Create a Temp List which only contains the idPersons from the personsManuallyAddedList
    if(personsManuallyAddedList != null && !personsManuallyAddedList.isEmpty()){
      Iterator<Integer> iterManual = personsManuallyAddedList.iterator();      
      while (iterManual.hasNext()) {
        Integer idPerson = (Integer) iterManual.next();
        personsManuallyAddedTempList.add(idPerson);
      }
    }
    
    List<String> roles = new ArrayList<String>();
    roles.add(CodesTables.CPARROLE_MOT);
    roles.add(CodesTables.CPARROLE_FAT);
    roles.add(CodesTables.CPARROLE_CTK);

    //Get all the parent Contact Rules for that idEvent and Roles of Parents
    List<ContactRule> parentContactRuleList = contactRuleDAO.findContactRulesByIdEventCdPersonRole(idEvent, roles);
    
    //List of personsa who are populated from person Detail
    List<Integer> relatedToPersonPrepopulatedList = new ArrayList<Integer>();
    
    //List of persons who are manually added
    List<Integer> relatedToPersonManuallyAddedList = new ArrayList<Integer>();

    //Loop thru the parent Contact Rules list and create a list which contains only idPersons of the PrePopulated 
    //Parent Contact Rules
    if(parentContactRuleList != null && !parentContactRuleList.isEmpty()){
      Iterator<ContactRule> iterParent = parentContactRuleList.iterator();
      while (iterParent.hasNext()) {
        ContactRule contactRule = (ContactRule) iterParent.next();
        if(ArchitectureConstants.Y.equals(contactRule.getIndPrepopulated())){
          relatedToPersonPrepopulatedList.add(contactRule.getPerson() != null ? contactRule.getPerson().getIdPerson() : null);
        }else{
          relatedToPersonManuallyAddedList.add(contactRule.getPerson() != null ? contactRule.getPerson().getIdPerson() : null);
        }
      }
    }

    //Remove the pre populated parent contact rules and the children from the list
    if(personsManuallyAddedTempList != null && !personsManuallyAddedTempList.isEmpty()){
      Iterator<Integer> iterManual = personsManuallyAddedTempList.iterator();      
      while (iterManual.hasNext()) {
        Integer idPerson = (Integer) iterManual.next();
        //Exclude the pre populated person only if she was not manually added.
        if(relatedToPersonPrepopulatedList.contains(idPerson) && !relatedToPersonManuallyAddedList.contains(idPerson)){
          personsManuallyAddedList.remove(idPerson);
        }
        if(childrenList.contains(idPerson)){
          personsManuallyAddedList.remove(idPerson);
        }
      }
    }

    //Loop thru the final list we got after removing the pre populated contact rules and the children and 
    //Put the name and idPerson in the map and add it to a new list
    if(personsManuallyAddedList != null && !personsManuallyAddedList.isEmpty()){
      Iterator<Integer> iterManual = personsManuallyAddedList.iterator();      
      while (iterManual.hasNext()) {
        Integer idPerson = (Integer) iterManual.next();
        Person person = personDAO.findPersonByIdPerson(idPerson);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idPerson", idPerson);
        map.put("nmPersonFull", person.getNmPersonFull());
        personsManuallyAddedMapList.add(map);
      }
    }

    return personsManuallyAddedMapList;       
  }
}
