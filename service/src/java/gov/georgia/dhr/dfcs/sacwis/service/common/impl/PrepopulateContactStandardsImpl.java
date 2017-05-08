package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Relationship;
import gov.georgia.dhr.dfcs.sacwis.service.common.PrepopulateContactStandards;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   04/27/2010   bgehlot                  MR-064: Changed the method name and query to pre-populate children under the age of 18 
 *                                         that are members of the primary caretaker's household. for FPR.
                 
 *   
 * </pre>
 * 
 */

public class PrepopulateContactStandardsImpl extends BaseServiceImpl implements PrepopulateContactStandards {
  private PersonDAO personDAO = null;

  private RelationshipDAO relationshipDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;  

  private FCCPFamilyDAO fccpFamilyDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }  

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }
  
  public ContactStandardsRetrieveSO prepopulateContactStandards(ContactStandardsRetrieveSI contactStandardsRetrieveSI)
  throws ServiceException {

    ContactStandardsRetrieveSO contactStandardsRetrieveSO = new ContactStandardsRetrieveSO();
    int idEvent = contactStandardsRetrieveSI.getUlIdEvent();
    int idCase = contactStandardsRetrieveSI.getUlIdCase();
    int idStage = contactStandardsRetrieveSI.getUlIdStage();
    String cdStage = contactStandardsRetrieveSI.getCdStage();
    contactStandardsRetrieveSO.setUlIdStage(idStage);
    contactStandardsRetrieveSO.setCdTask(contactStandardsRetrieveSI.getCdTask());
    contactStandardsRetrieveSO.setUlIdEvent(idEvent);
    contactStandardsRetrieveSO.setUlIdUser(contactStandardsRetrieveSI.getUserId());

    // Based on the stage type, Retrieve the list of children that we need to create Contact
    // Rules and Parental Contact Rules for. These will also be the list of children displayed
    // in the Contact For section of the Parental Contact Rules
    List<Integer> childrenList = new ArrayList<Integer>();
    if(CodesTables.CSTAGES_FSU.equals(cdStage)){
      childrenList = stagePersonLinkDAO.findAllChildrenFCCStagesByIdCase(idCase);
    }else if(CodesTables.CSTAGES_FPR.equals(cdStage)){
      //MR-064 Changed the method name and query to pre-populate children under the age of 18 
      //that are members of the primary caretaker's household for FPR.
      childrenList = stagePersonLinkDAO.findAllChildrenFPRStagesByIdStage(idStage);
    }
    
    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    contactStandardsRetrieveSO.setCdReqAction(actionCode);
    // Set the event status to the New
    contactStandardsRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_NEW);
    createParentContactRule(contactStandardsRetrieveSO, childrenList, cdStage, idCase);
    createChildContactRule(contactStandardsRetrieveSO, childrenList);  

    return contactStandardsRetrieveSO;
  }

  /**
   * This Saves the related to persons in CONTACT_RULE table
   * @param relatedToPersonList
   * @param parentContactRule
   */
  public ContactStandardsRetrieveSO createParentContactRule(ContactStandardsRetrieveSO contactStandardsRetrieveSO,
                                                            List<Integer> childrenList, String cdStage, int idCase){

    List<ContactRuleBean> parentContactRuleBeanList = new ArrayList<ContactRuleBean>();
    List<String> putativeFatherRel = new ArrayList<String>();
    putativeFatherRel.add(CodesTables.CRELVICT_PF);
    int idStage = contactStandardsRetrieveSO.getUlIdStage();
    if(childrenList != null && !childrenList.isEmpty()){
      
      List<Integer> relatedToPersonWithContactRuleList = new ArrayList<Integer>();

      Map<Integer, List<ContactForBean>>  relatedContactForMap = new HashMap<Integer, List<ContactForBean>>();
      
      //This map is required to set the contact not required to the Contact Rule bean which has already been added to the 
      //parent contact rule bean list
      Map<Integer, ContactRuleBean>  relatedContactRuleMap = new HashMap<Integer,ContactRuleBean>();
      
      Iterator<Integer> iter = childrenList.iterator();      
      boolean firstContactRuleCreated = false;
      
      // Loop through each of the identified children and do the following:
      //   1.) Identify parental relationships via Person Detail
      //   2.) Identify extra putative father relationships in FCC stages for FC cases
      //   3.) Create the Contact Rule for the Parent
      //   4.) Add Contact For records
      while (iter.hasNext()) {
        Integer idChildPerson = (Integer) iter.next();
        List<Relationship> relatedToPersonForEachChildList = relationshipDAO.findRelationshipByIdChildPerson(idChildPerson);
        List<Integer> relatedToPersonIdsForEachChildList = new ArrayList<Integer>();
        
        // Get the parental relationships from Person Detail
        if(relatedToPersonForEachChildList != null && !relatedToPersonForEachChildList.isEmpty()){
          Iterator<Relationship> iter1 = relatedToPersonForEachChildList.iterator();
          while (iter1.hasNext()) {
            Relationship relationship = (Relationship) iter1.next();
            relatedToPersonIdsForEachChildList.add(relationship.getPersonByIdRelatedPerson().getIdPerson());
          }
        }
        
        // If a Foster Care case, identify additional putative fathers from the FCC stage.
        if(CodesTables.CSTAGES_FSU.equals(cdStage)){
          int idChildSUBStage = stagePersonLinkDAO.findIdOpenFccStageByIdPersonIdCase(idChildPerson, idCase);
          List<Integer> additionalPutativeFathers = stagePersonLinkDAO.findIdPersonFromStagePersonLinkByIdStageCdStagePersTypeAndRelationships(
                                                                                                                                               idChildSUBStage, CodesTables.CPRSNTYP_PRN, putativeFatherRel);
          if(additionalPutativeFathers != null && !additionalPutativeFathers.isEmpty()){
            Iterator<Integer> additionalPutativeFathers_it = additionalPutativeFathers.iterator();
            while (additionalPutativeFathers_it.hasNext()) {
              Integer additionalPutativeFatherInt = additionalPutativeFathers_it.next();
              
              // Only add the identified putative fathers if they weren't already identified via Person Detail
              if(relatedToPersonIdsForEachChildList != null && !relatedToPersonIdsForEachChildList.isEmpty() && !relatedToPersonIdsForEachChildList.contains(additionalPutativeFatherInt)){
                Relationship putativeFatherRelationship = new Relationship();
                Person personRelated = new Person();
                personRelated.setIdPerson(additionalPutativeFatherInt);
                Person personChild = new Person();
                personChild.setIdPerson(idChildPerson);
                putativeFatherRelationship.setPersonByIdPerson(personChild);
                putativeFatherRelationship.setPersonByIdRelatedPerson(personRelated);
                putativeFatherRelationship.setCdPersonRelationship(CodesTables.CRPTRINT_PF);
                relatedToPersonForEachChildList.add(putativeFatherRelationship);
              }
            }
          }
        }
        
        if(relatedToPersonForEachChildList != null && !relatedToPersonForEachChildList.isEmpty()){
          Iterator<Relationship> iter1 = relatedToPersonForEachChildList.iterator();
          
          // For each identified relationship for the child start creating a parent contact rule
          while (iter1.hasNext()) {
            Relationship relationship = (Relationship) iter1.next();
            ContactRuleBean contactRuleBean = new ContactRuleBean();
            int idRelatedToPerson = relationship.getPersonByIdRelatedPerson().getIdPerson();
            
            //Default contact Not Required to Non- Reunification if the Case Plan of the child is Non - Reunification
            boolean isNonReunification = false;
            if(CodesTables.CSTAGES_FSU.equals(cdStage)){
              isNonReunification = defaultContactNotRequiredToNonReunification(idChildPerson, idStage, idRelatedToPerson);
              if(isNonReunification){
                contactRuleBean.setCdContactNotRequired(CodesTables.CCONNREQ_NRU);
                contactRuleBean.setNbrContactsPerMonth(0);
              }
            }
            
            if(((relatedToPersonWithContactRuleList != null && !relatedToPersonWithContactRuleList.isEmpty()) && 
                            !relatedToPersonWithContactRuleList.contains(idRelatedToPerson)) ||
                            !firstContactRuleCreated){
              contactRuleBean.setUlIdPerson(idRelatedToPerson);
              Person relatedToPerson  = personDAO.findPersonByIdPerson(idRelatedToPerson);
              String nmPersonFull = relatedToPerson.getNmPersonFull();
              contactRuleBean.setNmPersonFull(nmPersonFull);
              String cdPersonRole = "";
              if(CodesTables.CRPTRINT_BM.equals(relationship.getCdPersonRelationship()) ||
                              CodesTables.CRPTRINT_LM.equals(relationship.getCdPersonRelationship())){
                cdPersonRole = CodesTables.CPARROLE_MOT;
              }else if(CodesTables.CRPTRINT_BF.equals(relationship.getCdPersonRelationship()) ||
                              CodesTables.CRPTRINT_LF.equals(relationship.getCdPersonRelationship()) ||
                              CodesTables.CRPTRINT_PF.equals(relationship.getCdPersonRelationship())){
                cdPersonRole = CodesTables.CPARROLE_FAT;
              }else if(CodesTables.CRPTRINT_SC.equals(relationship.getCdPersonRelationship())){
                cdPersonRole = CodesTables.CPARROLE_CTK;
              }
              contactRuleBean.setCdPersonRole(cdPersonRole);
              contactRuleBean.setIndPrepopulated(ArchitectureConstants.Y);
              contactRuleBean.setCdReqAction(ServiceConstants.REQ_FUNC_CD_ADD);
              
              
              
              if(relatedToPerson.getDtPersonDeath() != null){
                contactRuleBean.setCdContactNotRequired(CodesTables.CCONNREQ_DEC);
                contactRuleBean.setNbrContactsPerMonth(0);
              }
              
              List<ContactForBean> contactForBeanList = new ArrayList<ContactForBean>();
              ContactForBean contactForBean = new ContactForBean();
              contactForBean.setIndContactFor(ArchitectureConstants.Y);
              contactForBean.setUlIdChild(idChildPerson);
              String nmPersonFullChild = personDAO.findNmFullByIdPerson(idChildPerson);
              contactForBean.setNmPersonFull(nmPersonFullChild);
              contactForBeanList.add(contactForBean);
              contactRuleBean.setChildContactForBeanList(contactForBeanList);
              relatedContactForMap.put(idRelatedToPerson, contactForBeanList);

              relatedContactRuleMap.put(idRelatedToPerson, contactRuleBean);
              firstContactRuleCreated = true;
              relatedToPersonWithContactRuleList.add(idRelatedToPerson);
              parentContactRuleBeanList.add(contactRuleBean);
            }else if(relatedToPersonWithContactRuleList.contains(idRelatedToPerson)){
              
            //Default contact Not Required to Non- Reunification if the Case Plan of the child is Non - Reunification
              
              if(CodesTables.CSTAGES_FSU.equals(cdStage)){
                contactRuleBean = relatedContactRuleMap.get(idRelatedToPerson);
                if(isNonReunification){
                  contactRuleBean.setCdContactNotRequired(CodesTables.CCONNREQ_NRU);
                  contactRuleBean.setNbrContactsPerMonth(0);
                }
              }
              
              // Only enter this branch if there is an existing parent rule
              ContactForBean contactForBean = new ContactForBean();
              List<ContactForBean> contactForBeanList = relatedContactForMap.get(idRelatedToPerson);
                  
              contactForBean.setIndContactFor(ArchitectureConstants.Y);
              contactForBean.setUlIdChild(idChildPerson);
              String nmPersonFullChild = personDAO.findNmFullByIdPerson(idChildPerson);
              contactForBean.setNmPersonFull(nmPersonFullChild);
              
              //Before adding the contact for record, test to see if the object exists.  If it exists
              //it is a duplicate so ignore it.
              Iterator<ContactForBean> forIter = contactForBeanList.iterator();
              boolean found = false;
              while (forIter.hasNext()) {
                ContactForBean existingBean = forIter.next();
                if (existingBean.getUlIdChild() == contactForBean.getUlIdChild()){
                  found = true;
                }
              }
              if (!found){
                contactForBeanList.add(contactForBean); 
              }
            }         
          }   
        }
      }

      if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
        Iterator<ContactRuleBean> iterExisting = parentContactRuleBeanList.iterator();
        while (iterExisting.hasNext()) {
          ContactRuleBean contactRuleBeanExisting = (ContactRuleBean) iterExisting.next();
          List<ContactForBean> contactForBeanExistingList = contactRuleBeanExisting.getChildContactForBeanList();
          List<Integer> contactForBeanExistingIDList = new ArrayList<Integer>();
          if(contactForBeanExistingList != null && !contactForBeanExistingList.isEmpty()){
            Iterator<ContactForBean> iterIdContactForChild = contactForBeanExistingList.iterator();
            while (iterIdContactForChild.hasNext()) {
              ContactForBean contactForBeanExisting = (ContactForBean) iterIdContactForChild.next();
              contactForBeanExistingIDList.add(contactForBeanExisting.getUlIdChild());
            }
          }
          
          Iterator<Integer> iterRemaining = childrenList.iterator();  
          while (iterRemaining.hasNext()) {
            Integer idChildPerson = (Integer) iterRemaining.next();
            if(!contactForBeanExistingIDList.contains(idChildPerson)){
              ContactForBean contactForBean = new ContactForBean();
              contactForBean.setIndContactFor(ArchitectureConstants.N);
              contactForBean.setUlIdChild(idChildPerson);
              String nmPersonFullChild = personDAO.findNmFullByIdPerson(idChildPerson);
              contactForBean.setNmPersonFull(nmPersonFullChild);
              contactForBeanExistingList.add(contactForBean);              
            }
          }
          contactRuleBeanExisting.setChildContactForBeanList(contactForBeanExistingList);
        }

      }
    }

    contactStandardsRetrieveSO.setParentContactRuleBeanList(parentContactRuleBeanList);
    return contactStandardsRetrieveSO;
  }

  /**
   * Creates the children in CONTACT_RULE table
   * @param childrenList
   * @param childContactRule
   */
  public ContactStandardsRetrieveSO createChildContactRule(ContactStandardsRetrieveSO contactStandardsRetrieveSO,List<Integer> childrenList){
    List<ContactRuleBean> childContactRuleBeanList = new ArrayList<ContactRuleBean>();
    if(childrenList != null && !childrenList.isEmpty()){
      Iterator<Integer> iter = childrenList.iterator();
      while (iter.hasNext()) {
        Integer idChildPerson = (Integer) iter.next();
        ContactRuleBean contactRuleBean = new ContactRuleBean();
        contactRuleBean.setUlIdPerson(idChildPerson);
        String nmPersonFull = personDAO.findNmFullByIdPerson(contactRuleBean.getUlIdPerson());
        contactRuleBean.setNmPersonFull(nmPersonFull);
        contactRuleBean.setCdPersonRole(CodesTables.CPARROLE_CHL);
        contactRuleBean.setIndByFaceToFace(ArchitectureConstants.Y);
        contactRuleBean.setIndByEmailCorrspndnce(ArchitectureConstants.N);
        contactRuleBean.setIndByTelephone(ArchitectureConstants.N);
        childContactRuleBeanList.add(contactRuleBean);
      }
    }
    contactStandardsRetrieveSO.setChildContactRuleBeanList(childContactRuleBeanList);
    return contactStandardsRetrieveSO;
  }
  
  /**
   * This method Default contact Not Required to Non- Reunification if the Case Plan of the child is Non - Reunification
   * @param idChildPerson
   * @param idStage
   * @param idRelatedToPerson
   * @return
   */
  private boolean defaultContactNotRequiredToNonReunification(int idChildPerson, int idStage, int idRelatedToPerson){
    boolean isNonReunification = false;

    //Default Contact Not Required to Non-Reunification 
    int idFccpEvent = 0 ;
    List<String> cdEventStatuses = new ArrayList<String>();
    
    //Get the most recent approved Case Plan
    cdEventStatuses.add(CodesTables.CEVTSTAT_APRV);
    List<FccpFamily> fccpFamilyPlnList = fccpFamilyDAO.findFCCPFamilyByIdPersonByEventStatusByIdStage(
                                                                                                      idChildPerson,
                                                                                                      idStage,
                                                                                                      CodesTables.CEVNTTYP_PLN,
                                                                                                      cdEventStatuses);

    if (fccpFamilyPlnList != null && fccpFamilyPlnList.size() > 0) {
      for (Iterator<FccpFamily> it = fccpFamilyPlnList.iterator(); it.hasNext();) {
        FccpFamily fccpFamily = it.next();
        if ((fccpFamily != null) && !CodesTables.CCTPLNTY_AFC.equals(fccpFamily.getCdPlanType()) && 
                        !CodesTables.CPERMPLN_RUI.equals(fccpFamily.getCdPrimPermPlan())) {                      
          idFccpEvent = fccpFamily.getIdEvent();
        }
        break;
      }
    }
    
    //If the Case plan is of Type Non- Reunification then find the principals on the case plan
    if(idFccpEvent != 0){
      List<Integer> peronsOnReuPlanList = new ArrayList<Integer>();
      List<Integer> peronsOnReuPlanToCheckList = new ArrayList<Integer>();

      //Get the principals on the Case Plan.
      List<EventPersonLink> eventPersonLinkList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idFccpEvent);
      if(eventPersonLinkList != null && !eventPersonLinkList.isEmpty()){
        Iterator<EventPersonLink> iterEventPerson = eventPersonLinkList.iterator();
        while (iterEventPerson.hasNext()) {
          EventPersonLink eventPersonLink = (EventPersonLink) iterEventPerson.next();
          peronsOnReuPlanList.add(eventPersonLink.getPerson().getIdPerson());
          peronsOnReuPlanToCheckList.add(eventPersonLink.getPerson().getIdPerson());
        }
      }
      
      //Check to see if the the Contact Rule to be added is in the Case Plan Principals List. If it is then set it to non-reunification
      if(peronsOnReuPlanList.contains(idRelatedToPerson)){
        isNonReunification = true;
      }
    }
               
  
    return isNonReunification;
  }

}
