package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactStandardsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DiligentSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;
import gov.georgia.dhr.dfcs.sacwis.db.DiligentSearch;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.common.DeleteContactStandards;
import gov.georgia.dhr.dfcs.sacwis.service.common.SaveContactRule;
import gov.georgia.dhr.dfcs.sacwis.service.common.SaveContactStandards;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveContactRuleSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSaveSO;

import java.util.ArrayList;
import java.util.Date;
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
 *   02/21/2010   hjbaptiste               Add business logic for saving a Contact Standards
 *   03/01/2010   bgehlot                  Added duplicate contact rules logic and validations for Diligent Search and Reunification
 *                                         Added method validateContactStandards
 *   03/05/2010   wjcochran                On Update for Contact Standards, pull the original event object and get
 *                                         the 'entered by' person information from that object, rather than
 *                                         overwriting that value by using the passed in value, which is typically
 *                                         pulled from the current user profile and not the originating user's profile.
 *   03/18/2010   hjbaptiste               MR-62: remove an additional Save call in the 'UPDATE' branch. Setting the date last update
 *                                         using the event retrieved from the database         
 *   04/27/2010   bgehlot                  MR-064: Change the validation that checks for a Family Case Plan with a Reunification 
 *                                         Permanency/Concurrent Plan so that it requires a Parent Contact Rule for family 
 *                                         members that are checked as caregivers on the Family Case Plan.                                    
 * </pre>
 * 
 */

public class SaveContactStandardsImpl extends BaseServiceImpl implements SaveContactStandards {

  private static final String ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  private static final String UPDATE = ServiceConstants.REQ_FUNC_CD_UPDATE;
  private static final String DELETE = ServiceConstants.REQ_FUNC_CD_DELETE;

  private ContactStandardsDAO contactStandardsDAO = null; 
  private EventDAO eventDAO = null;
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  private PostEvent postEvent = null;
  private PptDAO pptDAO = null;
  private SaveContactRule saveContactRule = null;
  private DeleteContactStandards deleteContactStandards = null;
  private DiligentSearchDAO diligentSearchDAO = null;
  private PersonDAO personDAO = null;
  private StageDAO stageDAO = null; 
  private StagePersonLinkDAO stagePersonLinkDAO = null; 
  private FCCPFamilyDAO fccpFamilyDAO = null;
  private ContactForDAO contactForDAO = null;


  public void setContactStandardsDAO(ContactStandardsDAO contactStandardsDAO) {
    this.contactStandardsDAO = contactStandardsDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setPptDAO(PptDAO pptDAO) {
    this.pptDAO = pptDAO;
  }

  public void setDeleteContactStandards(DeleteContactStandards deleteContactStandards) {
    this.deleteContactStandards = deleteContactStandards;
  }

  public void setSaveContactRule(SaveContactRule saveContactRule) {
    this.saveContactRule = saveContactRule;
  }

  public void setDiligentSearchDAO(DiligentSearchDAO diligentSearchDAO) {
    this.diligentSearchDAO = diligentSearchDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO){
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }

  public void setContactForDAO(ContactForDAO contactForDAO) {
    this.contactForDAO = contactForDAO;
  }

  public ContactStandardsSaveSO saveContactStandards (ContactStandardsRetrieveSO contactStandardsRetrieveSO) {
    ContactStandardsSaveSO contactStandardsSaveSO = new ContactStandardsSaveSO();
    String cdReqAction = contactStandardsRetrieveSO.getCdReqAction();
    int idStage = contactStandardsRetrieveSO.getUlIdStage();
    int idCase = contactStandardsRetrieveSO.getUlIdCase();
    String cdTask = contactStandardsRetrieveSO.getCdTask();
    String cdEventStatus = contactStandardsRetrieveSO.getCdEventStatus();
    int idUser = contactStandardsRetrieveSO.getUlIdUser();
    int idEvent = contactStandardsRetrieveSO.getUlIdEvent();
    Integer idPptEvent = contactStandardsRetrieveSO.getUlIdPptEvent();
    boolean isApprover  = contactStandardsRetrieveSO.isApprover();

    List<EventPersonLink> eventPersonLinkList = null;
    SaveContactRuleSI saveContactRuleSI = new SaveContactRuleSI();
    
    //Checking for duplicate contact rules
    List<ContactRuleBean> parentContactRuleBeanList1 = contactStandardsRetrieveSO.getParentContactRuleBeanList();
    List<Integer> contactRuleBeandIdPersonList = new ArrayList<Integer>();
    List<String> contactRuleUnknownMotherList = new ArrayList<String>();
    if(parentContactRuleBeanList1 != null && !parentContactRuleBeanList1.isEmpty()){
      Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList1.iterator();
      String nmPersons = "";
      while (iterParent.hasNext()) {
        ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
        if(contactRuleBean.getUlIdPerson() != 0){
          String nmDuplicateContactRule = personDAO.findNmFullByIdPerson(contactRuleBean.getUlIdPerson());
          if(!contactRuleBeandIdPersonList.contains(contactRuleBean.getUlIdPerson())){
            contactRuleBeandIdPersonList.add(contactRuleBean.getUlIdPerson());
          }else{            
            nmPersons = nmPersons + nmDuplicateContactRule + "- ";
          }
        }else{ //Check to see if it's Unknown Mother and add the role to the empty list if that role does not exists in the list
          if(CodesTables.CUNPRENT_UM.equals(contactRuleBean.getCdUnknownParent()) &&
                          !contactRuleUnknownMotherList.contains(CodesTables.CUNPRENT_UM)){
            contactRuleUnknownMotherList.add(CodesTables.CUNPRENT_UM);
          }else if(CodesTables.CUNPRENT_UM.equals(contactRuleBean.getCdUnknownParent()) &&
                          contactRuleUnknownMotherList.contains(CodesTables.CUNPRENT_UM)){//If the role exists in the list it's duplicate
            nmPersons = nmPersons + Lookup.simpleDecodeSafe(CodesTables.CUNPRENT, CodesTables.CUNPRENT_UM) + "- ";
          }

          if(CodesTables.CUNPRENT_UF.equals(contactRuleBean.getCdUnknownParent()) &&
                          !contactRuleUnknownMotherList.contains(CodesTables.CUNPRENT_UF)){//Check to see if it's Unknown Father and add the role to the empty list if that role does not exists in the list
            contactRuleUnknownMotherList.add(CodesTables.CUNPRENT_UF);
          }else if(CodesTables.CUNPRENT_UF.equals(contactRuleBean.getCdUnknownParent()) &&
                          contactRuleUnknownMotherList.contains(CodesTables.CUNPRENT_UF)){//If the role exists in the list it's duplicate
            nmPersons = nmPersons + Lookup.simpleDecodeSafe(CodesTables.CUNPRENT, CodesTables.CUNPRENT_UF) + "- ";
          }
        }
      }
      if(!"".equals(nmPersons)){
        contactStandardsSaveSO.setDuplicateContactRule(true);
        contactStandardsSaveSO.setNmDuplicateContactRule(nmPersons);
      }
    }
    
    // In the ONG stage, if primary caretaker doesn't have a contact rule and prevent the 
    // user from save and submit
    boolean pkHasContactRule = true;
    if (contactStandardsRetrieveSO.isSaveAndSubmit()){
      Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
      String cdStage = stage.getCdStage();
      if(CodesTables.CSTAGES_FPR.equals(cdStage)){
        // Get the Primary Caretaker if one exists
        Person primaryCaretaker = stagePersonLinkDAO.findStagePersonLinkPrimaryCaretaker(contactStandardsRetrieveSO.getUlIdStage());
        if (primaryCaretaker != null) {
          String nmPrimaryCaretaker = "";
          pkHasContactRule = false;
          nmPrimaryCaretaker = primaryCaretaker.getNmPersonFull();
          int idPrimaryCaretaker = primaryCaretaker.getIdPerson();
          List<ContactRuleBean> parentContactRuleBeanList = contactStandardsRetrieveSO.getParentContactRuleBeanList();
          if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
            Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
            while (iterParent.hasNext()) {
              ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
              if(contactRuleBean.getUlIdPerson() != 0){
                // If we have a Contact Rule for the Primary Caretaker, then break since we 
                // don't need to show the message.
                if (idPrimaryCaretaker == contactRuleBean.getUlIdPerson()) {
                  pkHasContactRule = true;
                  break;
                }
              }
            }
          }
          if (!pkHasContactRule) {
            // Did not find a Contact Rule for the Primary Caretaker, display the message.
            contactStandardsSaveSO.setIndPrimaryCaretaker(ArchitectureConstants.Y);
            contactStandardsSaveSO.setNmPrimaryCaretaker(nmPrimaryCaretaker);
          }
        }
      }
    }
    
    // If we find a duplicate rule, there's no need to do a Save, just return to the caller.
    boolean validate = false;
    //Call validate only when save and submit is clicked
    if (contactStandardsRetrieveSO.isSaveAndSubmit()){
      validate = validateContactStandards(contactStandardsRetrieveSO, contactStandardsSaveSO);
    }
    
    
    // If Duplicate contact rule exists OR if the validations for Diligent search and 
    // Reunification is true and PK has no rule, return without saving
    if (contactStandardsSaveSO.isDuplicateContactRule() || !pkHasContactRule || validate){
      return contactStandardsSaveSO;
    }
    
    // Determine if we need to Add, Update or Delete a Contact Standards. Add is done when the user initially 
    // creates a Contact Standards by clicking the Add button on the List page. Subsequent saves are done
    // thru the Update. Delete is done when the user clicks the Delete button on the Contact Standards List page.
    if (ADD.equals(cdReqAction)) {
      ContactStandardsSaveSI contactStandardsSaveSI = new ContactStandardsSaveSI();
      contactStandardsSaveSI.setIdStage(idStage);
      contactStandardsSaveSI.setCdtask(cdTask);
      contactStandardsSaveSI.setCdEventStatus(cdEventStatus);
      contactStandardsSaveSI.setIdPerson(idUser);
      contactStandardsSaveSI.setCdReqAction(ADD);
      contactStandardsSaveSI.setApprover(isApprover);
      CCMN01UO ccmn01uo = new CCMN01UO();
      ccmn01uo = callPostEvent(contactStandardsSaveSI, eventPersonLinkList);
      Event contactStandardsEvent = (Event) getPersistentObject(Event.class, ccmn01uo.getUlIdEvent());
      ContactStandards contactStandards = new ContactStandards();
      contactStandards.setEvent(contactStandardsEvent);
      contactStandards.setTxtReasonForChange(contactStandardsRetrieveSO.getTxtReasonForChange());
      contactStandards.setIndCmAcknowledge(contactStandardsRetrieveSO.getIndCmAcknowledge());
      contactStandards.setIndSuperApproval(contactStandardsRetrieveSO.getIndSuperApproval());
      contactStandardsDAO.saveContactStandards(contactStandards);
      saveContactRuleSI.setIdEvent(ccmn01uo.getUlIdEvent());
      // Set the idEvent in the SO object in order to create the Summary section with the newly saved data
      contactStandardsRetrieveSO.setUlIdEvent(ccmn01uo.getUlIdEvent());
      idEvent = ccmn01uo.getUlIdEvent();
      if (idPptEvent != null && idPptEvent > 0){
        Ppt ppt = pptDAO.findPpt(idPptEvent);
        ppt.setContactStandards(contactStandards);
        pptDAO.savePpt(ppt);
      }
    }
    else if (UPDATE.equals(cdReqAction)) {
      idEvent = contactStandardsRetrieveSO.getUlIdEvent();
      Event contactStandardsEvent = (Event) getPersistentObject(Event.class, idEvent);
      ContactStandards contactStandards  = (ContactStandards) getPersistentObject(ContactStandards.class, idEvent);
      Person person = contactStandardsEvent.getPerson();
      if (person != null) {
        idUser = person.getIdPerson();
      }
      contactStandards.setEvent(contactStandardsEvent);
      contactStandards.setTxtReasonForChange(contactStandardsRetrieveSO.getTxtReasonForChange());
      contactStandards.setIndCmAcknowledge(contactStandardsRetrieveSO.getIndCmAcknowledge());
      contactStandards.setIndSuperApproval(contactStandardsRetrieveSO.getIndSuperApproval());
      
      ContactStandardsSaveSI contactStandardsSaveSI = new ContactStandardsSaveSI();
      contactStandardsSaveSI.setIdStage(idStage);
      contactStandardsSaveSI.setCdtask(cdTask);
      contactStandardsSaveSI.setIdEvent(idEvent);
      contactStandardsSaveSI.setCdEventStatus(cdEventStatus);
      contactStandardsSaveSI.setIdPerson(idUser);
      contactStandardsSaveSI.setCdReqAction(UPDATE);
      contactStandardsSaveSI.setApprover(isApprover);

      CCMN01UO ccmn01uo = callPostEvent(contactStandardsSaveSI, eventPersonLinkList);
      if (ccmn01uo != null) {
        idEvent = ccmn01uo.getUlIdEvent();
        contactStandardsEvent = (Event) getPersistentObject(Event.class, idEvent);
        contactStandardsRetrieveSO.setDtEventLastUpdate(ccmn01uo.getTsLastUpdate());
      }
      contactStandards.setEvent(contactStandardsEvent);
      contactStandards.setIdContactStdsEvent(idEvent);
      contactStandardsDAO.saveContactStandards(contactStandards);
      // Set the IdEvent for the Contact Rules
      saveContactRuleSI.setIdEvent(idEvent);
    }
    else if (DELETE.equals(cdReqAction)) {
      idEvent = contactStandardsRetrieveSO.getUlIdEvent();
      ContactStandardsSaveSI contactStandardsSaveSI = new ContactStandardsSaveSI();
      contactStandardsSaveSI.setIdCase(idCase);
      contactStandardsSaveSI.setIdStage(idStage);
      contactStandardsSaveSI.setCdtask(cdTask);
      contactStandardsSaveSI.setIdEvent(idEvent);
      contactStandardsSaveSI.setCdEventStatus(cdEventStatus);
      contactStandardsSaveSI.setIdPerson(idUser);
      contactStandardsSaveSI.setCdReqAction(DELETE);
      contactStandardsSaveSI.setApprover(isApprover);
      //This will automatically call PostEvent 
      deleteContactStandards.deleteContactStandards(contactStandardsSaveSI);
    }

    // Combine the list of Parent Contact Rules with the list of Child Contact Rules prior to calling
    // the Save service
    List<ContactRuleBean> allContactRuleBeanList = new ArrayList<ContactRuleBean>();
    List<ContactRuleBean> parentContactRuleBeanList = contactStandardsRetrieveSO.getParentContactRuleBeanList();
    allContactRuleBeanList.addAll(parentContactRuleBeanList);
    List<ContactRuleBean> childContactRuleBeanList = contactStandardsRetrieveSO.getChildContactRuleBeanList();
    allContactRuleBeanList.addAll(childContactRuleBeanList);

    saveContactRuleSI.setContactRuleBeanList(allContactRuleBeanList);
    saveContactRuleSI.setIdEvent(idEvent);
    saveContactRule.saveContactRule(saveContactRuleSI);

   contactStandardsSaveSO.setUlIdEvent(idEvent);
    return contactStandardsSaveSO;
  }


  /**
   * This method does the validations for the Diligent search and the Reunification 
   * @param contactStandardsRetrieveSO
   * @param contactStandardsSaveSO
   * @return
   */
  private boolean validateContactStandards(ContactStandardsRetrieveSO contactStandardsRetrieveSO, ContactStandardsSaveSO contactStandardsSaveSO) {
    List<ContactRuleBean> parentContactRuleBeanList = contactStandardsRetrieveSO.getParentContactRuleBeanList();
    int idCase = contactStandardsRetrieveSO.getUlIdCase();
    boolean validate = false;
    //User has selected Contact not Required option: Unable to Locate when no Diligent search 
    //documentation is available and clicks Save and Submit button.
    String persons = "";
    String personsInterested = "";
    boolean interested = false;
    if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
      Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
      while (iterParent.hasNext()) {
        ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
        // Get the list of ContactFor children for this Contact Rule
        List<Integer> contactForIdChildList = contactForDAO.findCheckedContactForByIdContactRuleIdChild(contactRuleBean.getUlIdContactRule());
        //Only do Diligent search validation for persons other than unknown Mother and Father.
        if(contactRuleBean.getUlIdPerson() != 0){
          String nmPersonFull = personDAO.findNmFullByIdPerson(contactRuleBean.getUlIdPerson());
          if(contactForIdChildList != null && !contactForIdChildList.isEmpty()){
            List<DiligentSearch> diligentSearchList = diligentSearchDAO.findDiligentSearchInfoByCaseIdByIdpersonSeachByIdPersonDtl(idCase, contactForIdChildList, contactRuleBean.getUlIdPerson());
            if(diligentSearchList == null || diligentSearchList.isEmpty()){
              // If a Diligent Search was not found in the child's stage for the contact rule parental person,
              // append their name to the list to be added to the error message
              if(CodesTables.CCONNREQ_UTL.equals(contactRuleBean.getCdContactNotRequired())){
                persons = persons + nmPersonFull + "- ";
              }
            }else{ //User enters zero for # of Contacts per Month in Parent Contact Rules Section 
              //but the 'Current Outcome of Contact' of the Diligent Search is either Interested 
              //or Possible Future Interest, the contact not required is neither NonReunion and
              // Deceased and user clicks on Save and Submit button
              Iterator<DiligentSearch> iterDili = diligentSearchList.iterator();
              while (iterDili.hasNext()) {
                DiligentSearch diligentSearch = (DiligentSearch) iterDili.next();
                String outcome = diligentSearch.getCdCurrOutcome();
                if((CodesTables.CDSICONT_PFI.equals(outcome) || CodesTables.CDSICONT_INT.equals(outcome)) 
                                && contactRuleBean.getNbrContactsPerMonth() == 0 
                                && !CodesTables.CCONNREQ_NRU.equals(contactRuleBean.getCdContactNotRequired())
                                && !CodesTables.CCONNREQ_DEC.equals(contactRuleBean.getCdContactNotRequired())
                                && !CodesTables.CCONNREQ_OTH.equals(contactRuleBean.getCdContactNotRequired())){
                  interested = true;
                  break;
                }
              }
              if(interested){
                personsInterested = personsInterested + nmPersonFull + "- ";
              }
            }
          }
        }
      }
    }
    
    //Set the Indicator and name to the SO object which will be checked in the Conversation to throw the message
    if(!"".equals(persons)){
      contactStandardsSaveSO.setIndDiligentSearch(ArchitectureConstants.Y);
      contactStandardsSaveSO.setPersonsForErrorMessage(persons);
      validate = true;
    }

    //Set the Indicator and name to the SO object which will be checked in the Conversation to throw the message
    if(!"".equals(personsInterested)){
      contactStandardsSaveSO.setIndInterested(ArchitectureConstants.Y);
      contactStandardsSaveSO.setPersonsInterestedForErrorMessage(personsInterested);
      validate = true;
    }    
    
    //For the foster care cases if the plan is re unification check to see if all the persons on re unification plan 
    // has parent contact rule.
    String cdStage = stageDAO.findCdStageByIdStage(contactStandardsRetrieveSO.getUlIdStage());
    
    if(CodesTables.CSTAGES_FSU.equals(cdStage)){
      String personNames = "";
      String childrenNames = "";
      List<ContactRuleBean> childContactRuleBeanList = contactStandardsRetrieveSO.getChildContactRuleBeanList();
      /*
       * Loop through the Children List and find most recent Approved Re unification Case Plan
       * 1. If one exists, then find all the principals on that case plan
       * 2. Remove the Children from the list from step 1.
       * 3. Loop through the above list from step 2 and find if those persons exists in the ParentContactRulesBeans List
       * 4. If the persons in the List from step 2 do not have parent contact rule then throw the message.
       */
      if(childContactRuleBeanList != null && !childContactRuleBeanList.isEmpty()){
        List<Integer> peronsOnReuPlanDupList = new ArrayList<Integer>();
        Iterator<ContactRuleBean> iterChild = childContactRuleBeanList.iterator();
        while (iterChild.hasNext()) {
          ContactRuleBean contactRuleBean = (ContactRuleBean) iterChild.next();
          int idChildPerson = contactRuleBean.getUlIdPerson();
          
          boolean reunificationPlanExists = false;
          int idFccpEvent = 0 ;
          List<String> cdEventStatuses = new ArrayList<String>();
          cdEventStatuses.add(CodesTables.CEVTSTAT_APRV);
          //Get the most recent approved Case Plan
          List<FccpFamily> fccpFamilyPlnList = fccpFamilyDAO.findFCCPFamilyByIdPersonByEventStatusByIdStage(
                                                                                                            idChildPerson,
                                                                                                            contactStandardsRetrieveSO.getUlIdStage(),
                                                                                                            CodesTables.CEVNTTYP_PLN,
                                                                                                            cdEventStatuses);

          if (fccpFamilyPlnList != null && fccpFamilyPlnList.size() > 0) {
            for (Iterator<FccpFamily> it = fccpFamilyPlnList.iterator(); it.hasNext();) {
              FccpFamily fccpFamily = it.next();
              //Is the Case Plan Reunification
              if ((fccpFamily != null) && !CodesTables.CCTPLNTY_AFC.equals(fccpFamily.getCdPlanType()) && 
                              CodesTables.CPERMPLN_RUI.equals(fccpFamily.getCdPrimPermPlan())) {
                reunificationPlanExists = true;
                idFccpEvent = fccpFamily.getIdEvent();
                break;
              }
              
            }
          }

          if(reunificationPlanExists){
            //Get the name of the children
            String nmChildFull = personDAO.findNmFullByIdPerson(idChildPerson);
            childrenNames = childrenNames + nmChildFull + "- ";
            List<Integer> peronsOnReuPlanList = new ArrayList<Integer>();
            List<Integer> peronsOnReuPlanToCheckList = new ArrayList<Integer>();
            
            //Get the principals on the Case Plan.
            List<EventPersonLink> eventPersonLinkList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idFccpEvent);
            if(eventPersonLinkList != null && !eventPersonLinkList.isEmpty()){
              Iterator<EventPersonLink> iter = eventPersonLinkList.iterator();
              while (iter.hasNext()) {
                EventPersonLink eventPersonLink = (EventPersonLink) iter.next();
                //MR-064: Added the condition to check for caregiver
                if(ArchitectureConstants.Y.equals(eventPersonLink.getIndCaregiver())){
                  peronsOnReuPlanList.add(eventPersonLink.getPerson().getIdPerson());
                  peronsOnReuPlanToCheckList.add(eventPersonLink.getPerson().getIdPerson());
                }
              }
            }

            //Remove the Child from the List of principals on the Case Plan
            List<ContactRuleBean> childContactRuleBeanList1 = contactStandardsRetrieveSO.getChildContactRuleBeanList();
            if(childContactRuleBeanList1 != null && !childContactRuleBeanList1.isEmpty()){
              Iterator<ContactRuleBean> iterChild1 = childContactRuleBeanList1.iterator();
              while (iterChild1.hasNext()) {
                ContactRuleBean contactRuleBean1 = (ContactRuleBean) iterChild1.next();
                int idChildPerson1 = contactRuleBean1.getUlIdPerson();
                //MR-64 Added null check and not empty list checks
                if(peronsOnReuPlanToCheckList != null && !peronsOnReuPlanToCheckList.isEmpty() &&
                   peronsOnReuPlanList != null && !peronsOnReuPlanList.isEmpty() && 
                   peronsOnReuPlanToCheckList.contains(idChildPerson1)){
                  int index = peronsOnReuPlanList.indexOf(idChildPerson1);
                  peronsOnReuPlanList.remove(index);
                }
              }
            }
          
            //Create a List which contains only the idPersons from the ParentContactRuleBeanList
          List<Integer> parentIdContactRuleBeanList = new ArrayList<Integer>();  
          if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
            Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
            while (iterParent.hasNext()) {
              ContactRuleBean contactParentRuleBean = (ContactRuleBean) iterParent.next();
              int idRelatedPerson = contactParentRuleBean.getUlIdPerson();   
              parentIdContactRuleBeanList.add(idRelatedPerson);
              }
            }
          
          //Loop thru the list of principals on the case plan and check to see if they exists in the ParentContactRuleBeanList
          //if not then add the person's name to the String, also checking to see that the idPerson is not duplicated 
          //(peronsOnReuPlanDupList)in the error message
          if(peronsOnReuPlanList != null && !peronsOnReuPlanList.isEmpty()){
            Iterator<Integer> iterIdParent = peronsOnReuPlanList.iterator();
            while (iterIdParent.hasNext()) {
              Integer idPerson = (Integer) iterIdParent.next();
              if(!parentIdContactRuleBeanList.contains(idPerson) && !peronsOnReuPlanDupList.contains(idPerson)){
                String nmPersonFull = personDAO.findNmFullByIdPerson(idPerson);
                personNames = personNames + nmPersonFull + "- ";
                peronsOnReuPlanDupList.add(idPerson);
              }
            }
          }
          }
        }
      }
      
      //Set the Indicator and name to the SO object which will be checked in the Conversation to throw the message
      if(!"".equals(personNames)){
        contactStandardsSaveSO.setIndReunification(ArchitectureConstants.Y);
        contactStandardsSaveSO.setPersonsReunification(personNames);
        contactStandardsSaveSO.setChildrenNames(childrenNames);
        validate = true;
      }
    }
    
    return validate;
  }

  /**
   * Updates or inserts the event for Contact Standards
   * 
   * @param 
   * @param actionCode
   * @return Post Event Output Bean
   */
  private CCMN01UO callPostEvent(ContactStandardsSaveSI contactStandardsSaveSI , List<EventPersonLink> eventPersonLinkList) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String cdReqAction = contactStandardsSaveSI.getCdReqAction();
    String eventStatus = contactStandardsSaveSI.getCdEventStatus();
    String desc = StringHelper.EMPTY_STRING;
    if (ADD.equals(cdReqAction) || UPDATE.equals(cdReqAction)) {
      if (CodesTables.CEVTSTAT_NEW.equals(eventStatus) || CodesTables.CEVTSTAT_PROC.equals(eventStatus) ) {
        eventStatus = CodesTables.CEVTSTAT_PROC;
        desc = "Contact Standards has been saved but has not been submitted for Approval.";
        if((CodesTables.CEVTSTAT_PEND.equals(eventStatus) || CodesTables.CEVTSTAT_PROC.equals(eventStatus)) && contactStandardsSaveSI.isApprover()){
          eventStatus = CodesTables.CEVTSTAT_PEND;
        }
      }
      if (CodesTables.CEVTSTAT_PEND.equals(eventStatus)){
        desc = "Contact Standards has been submitted for Approval.";
      }
    }

    int idEvent = contactStandardsSaveSI.getIdEvent();
    Date dtEventOccurred = null;
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_CSS);
    rowccmn01uig00.setSzCdTask(contactStandardsSaveSI.getCdTask());
    rowccmn01uig00.setUlIdPerson(contactStandardsSaveSI.getIdPerson());
    rowccmn01uig00.setUlIdStage(contactStandardsSaveSI.getIdStage());
    rowccmn01uig00.setUlIdEvent(contactStandardsSaveSI.getIdEvent());

    if(idEvent != 0){
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if(event != null){
        // Set the date last update from what is in the DB or else we can get a time stamp mismatch message
        Date dtEventLastUpdated = event.getDtLastUpdate();
        rowccmn01uig00.setTsLastUpdate(dtEventLastUpdated);
        dtEventOccurred = event.getDtEventOccurred();
        if (eventPersonLinkList != null && !eventPersonLinkList.isEmpty()) {
          Iterator<EventPersonLink> eventPersonLinkList_it = eventPersonLinkList.iterator();
          while (eventPersonLinkList_it.hasNext()) {
            EventPersonLink deleteEventPersonLink = eventPersonLinkList_it.next();
            Person person = deleteEventPersonLink.getPerson();
            ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
            rowccmn01uig01.setUlIdPerson(person.getIdPerson()); 
            rowccmn01uig01.setSzCdScrDataAction(cdReqAction);
            rowccmn01uig01.setTsLastUpdate(dtEventLastUpdated);
            rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          }
        }
      }
    }
    if (!DateHelper.isNull(dtEventOccurred) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    }

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(contactStandardsSaveSI.getCdReqAction());
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);

  }

}
