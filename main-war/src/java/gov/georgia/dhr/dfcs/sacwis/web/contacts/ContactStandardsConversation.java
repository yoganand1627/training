package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.Event;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsSummarySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveContactRuleSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSummarySO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.PPTConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <p>Title: ContactStandardsConversation</p> <p>Description: This is the Conversation class used to add, delete
 * save and submit parent contact standards rules and child contact standards rules for a particular case</p> 
 * <p>Copyright: Copyright (c) 2010</p> <p>Company: GADHR</p>
 * <p/>
 * <p/>
 * <pre>
 * Change History:
 * Date      User               Description
 * --------  ---------------    ----------------------------------------------
 * 02/13/10  hjbaptiste         Initial creation
 * 02/18/10  bgehlot            Adding business logic for pre-population of Parent Contact Rules from the Person Detail
 * 03/01/10  wjcochran          MR-62: Added logic to add Contact Standards from FTM.
 * 03/08/10  bgehlot            Added the Copy Logic.
 * 03/11/10  hjbaptiste         MR-62: Force Validation when the approver clicks the Approval Status button. Calculate the 
 *                              Summary section after save and submit. If all parent contact rules are not complete, after
 *                              clicking save and submit, demote the event status from PEND back to PROC.
 * 03/17/10  bgehlot            Set the event status to PROC if the error messagedisplays when Save and Submit is clicked
 * 03/18/10  hjbaptiste         MR-62: In the display method, only creating the summary if the hyperlink was clicked. This 
 *                              is because creating the summary section is now being everywhere a form of 'Save' is being
 *                              done. For example when Save or Save and Submit or Approval Status button is clicked in approval
 *                              mode. Also when Add or Delete buttons are clicked since technically we're doing a save for
 *                              those two buttons.
 * 05/07/10  mxpatel            SMS #50286: added code so that a blank contact standard (with no pre-populated children)
 *                              can not be saved.
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, Februrary 13, 2010
 */

@SuppressWarnings("serial")
public class ContactStandardsConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "ContactStandardsConversation";

  private static final String INSERT = "INSERT";
  private static final String ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  private static final String UPDATE = ServiceConstants.REQ_FUNC_CD_UPDATE;
  private static final String DELETE = ServiceConstants.REQ_FUNC_CD_DELETE;
  public static final String SAVE_SUBMIT_BUTTON = "btnSaveSubmit";
  public static final String SAVE_BUTTON = "btnSave";
  public static final String SUBMIT_APPROVAL_BUTTON = "btnApprovalStatusFinal";
  public static final String CONTACT_STANDARDS_FSU = "6545";
  public static final String CONTACT_STANDARDS_FPR = "7026";
  public static final String CONVERSATION_URL = "/workload/EventSearch/";
  public static final String EVENT_LIST = getUrl("displayEventList");
  
  public static final String GENERALFAILURE = "General Failure:";
  
  
  private Admin admin;
  private Common common;
  
  public void setCommon(Common common) {
    this.common = common;
  }
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
  
  /**
   * This method retrieves the data needed to display the Contact Standards page and calls handleError methods.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayContactStandards_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayContactStandards_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    try {
      int idEvent = GlobalData.getUlIdEvent(request);
      int idStage = GlobalData.getUlIdStage(request);
      int idCase = GlobalData.getUlIdCase(request);
      String cdStage = GlobalData.getSzCdStage(request);
      String cdTask = GlobalData.getSzCdTask(request);
      int idUser = user.getUserID();
      String cdTaskFromPPT = (String) state.getAttribute(PPTConversation.PPT_CONTACT_STDS_TASK_PULLBACK, request);
      ContactStandardsRetrieveSO contactStandardsRetrieveSO = new ContactStandardsRetrieveSO();
      ContactStandardsRetrieveSI contactStandardsRetrieveSI = new ContactStandardsRetrieveSI();
      contactStandardsRetrieveSI.setUlIdEvent(idEvent);
      contactStandardsRetrieveSI.setUlIdStage(idStage);
      contactStandardsRetrieveSI.setUlIdCase(idCase);
      contactStandardsRetrieveSI.setCdStage(cdStage);
      contactStandardsRetrieveSI.setUserId(idUser);
      contactStandardsRetrieveSI.setCdTask(cdTask);

      boolean btnNewUsing = ContextHelper.getIntSafe(request, "NewUsing.x") != 0;
      
      // btAdd is for the Event List Add button
      boolean btnAdd = ContextHelper.getIntSafe(request, "Add.x") != 0;

      /* If we are coming from the PPT Page (for FTM),
       * then we need to set btnAdd to true to trigger prepopulation
       */
      if (cdTaskFromPPT != null && !("".equals(cdTaskFromPPT))) {
        btnAdd = true;
      }      
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      contactStandardsRetrieveSI.setAddButtonPressed(btnAdd);
      // If the Add button was clicked on the Contact Standards List page, we want to do a Prepopulate.
      // It will create a rule for all people listed in the 'Caregiver/Parental Relationship 
      // Information for Child' section. In the FCF stage, it will also create a rule for additional
      // Putative Fathers in corresponding FCC stages
      if(btnAdd){
        contactStandardsRetrieveSO = common.prepopulateContactStandards(contactStandardsRetrieveSI);
      }
      
      boolean hyperLinkClicked = false;
      // Get the previous url. Perform a Sync with the children's Person Detail page and the Contact Rules
      // that have been already saved if the following conditions exist
      // 1) If we are coming from the Contact Standards List page
      // 2) The Copy button was not clicked
      // 3) The Add button was not clicked
      // 4) The event is neither Pending and and Approved status 
      // In other words, If the hyperlink was clicked on the Contact Standards List page.
      String url = ContextHelper.getString(request, "FormValidationPrevUrl");
      if((EVENT_LIST.equals(url) && !btnNewUsing && !btnAdd) && 
                      (!CodesTables.CEVTSTAT_APRV.equals(contactStandardsRetrieveSO.getCdEventStatus()) &&
                                      !CodesTables.CEVTSTAT_PEND.equals(contactStandardsRetrieveSO.getCdEventStatus()))){
        syncContactRules(contactStandardsRetrieveSI, context);
        hyperLinkClicked = true;
      }
      // Retrieve the Contact Standards from the database if the Add button was clicked from the Contact Standards List page
      if(!btnAdd){
        contactStandardsRetrieveSO = common.retrieveContactStandards(contactStandardsRetrieveSI);
      }

      // New Using - Copy Button
      if (btnNewUsing) {
        pageMode = PageModeConstants.NEW_USING;
        contactStandardsRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_NEW);
      } else if (btnAdd) {
        pageMode = PageModeConstants.NEW;
      } else if(!PageModeConstants.VIEW.equals(pageMode)){
        pageMode = PageModeConstants.MODIFY;
      }
      
      state.setAttribute("BTN_COPY_CLICKED", btnNewUsing, request);
      //SMS#50286
      if(contactStandardsRetrieveSO.getChildContactRuleBeanList() == null || contactStandardsRetrieveSO.getChildContactRuleBeanList().isEmpty()){
        pageMode = PageModeConstants.VIEW;
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_CON_STDS_NO_CHILDREN), request);
     
      }
      PageMode.setPageMode(pageMode, request);
      
      // Set whether the user is the current approver. This will be used as a condition to disable the
      // supervisor approval checkbox in the event the approver goes to the approval status page  to do 
      // the approval but for some reason, such as not having the checkbox checked and receiving the 
      // error message, decides to navigate away from the page. Since the page is in PEND status. if the 
      // case manager enters the page, the supervisor approval checkbox will be displayed in edit mode.
      // We will use this boolean to disable the checkbox.
      boolean isCurrentApprover = isCurrentActiveApprover(context);
      contactStandardsRetrieveSO.setIsCurrentApprover(isCurrentApprover);
      
      state.setAttribute("contactStandardsRetrieveSO", contactStandardsRetrieveSO, request);
       // If the event is not in New status, and we've clicked the hyperlink on the Contact Standards List
      // page or we're coming in approval mode, create the Contact Standards Summary section
      //TODO Think about this condition, it will only be hit on copy.  Reconsider showing the
      //     summary section.
      if (hyperLinkClicked || GlobalData.isApprovalMode(request)) {
        ContactStandardsSummarySO contactStandardsSummarySO = new ContactStandardsSummarySO();
        ContactStandardsSummarySI contactStandardsSummarySI = new ContactStandardsSummarySI();
        contactStandardsSummarySI.setUlIdEvent(idEvent);
        contactStandardsSummarySI.setCdTask(cdTask);
        contactStandardsSummarySI.setChildContactRuleBeanList(contactStandardsRetrieveSO.getChildContactRuleBeanList()); 
        contactStandardsSummarySO = common.createContactStandardsSummary(contactStandardsSummarySI);
        state.setAttribute("contactStandardsSummarySO", contactStandardsSummarySO, request);
      }
      
      // If the Contact Standards event is pending approval and the user did not access the page 
      // in approval mode, warn them that the pending closure will be invalidated if they save any changes.
      if (contactStandardsRetrieveSO != null) {
        if (CodesTables.CEVTSTAT_PEND.equals(contactStandardsRetrieveSO.getCdEventStatus()) && !GlobalData.isApprovalMode(request)
            && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
      }
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  
  /**
   * This method is the main call for Adding a Contact Rule. The Contact Rules displayed on the page prior
   * to clicking the Add button, will be saved/updated first. After that, the new Contact Rule will be created.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void addContactRule_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addContactRule_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    try {
      ContactStandardsRetrieveSO contactStandardsRetrieveSO = (ContactStandardsRetrieveSO) state.getAttribute("contactStandardsRetrieveSO",request);
      populateContactStandardsRetrieveSO(context, contactStandardsRetrieveSO);
      // Create a list of the existed Contact Rules.
      List<ContactRuleBean> existingContactRuleBean = contactStandardsRetrieveSO.getParentContactRuleBeanList();
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      SaveContactRuleSI saveContactRuleSI = new SaveContactRuleSI();
      // populateContactRuleAD() returns a List of ContactRuleBean. When we are adding a new rule, the returned list will
      // only contain one rule. Add the rule to the list of pre-existed Contact Rules and save.
      List<ContactRuleBean> addContactRuleList = populateContactRuleAD(context, ServiceConstants.REQ_FUNC_CD_ADD);
      existingContactRuleBean.add(addContactRuleList.get(0));
      saveContactRuleSI.setContactRuleBeanList(existingContactRuleBean);
      saveContactRuleSI.setIdEvent(GlobalData.getUlIdEvent(request));
      common.saveContactRule(saveContactRuleSI);
      // Regenerate the Parent Rule Summary section since we're doing a save on the rules
      ContactStandardsSummarySO contactStandardsSummarySO = new ContactStandardsSummarySO();
      ContactStandardsSummarySI contactStandardsSummarySI = new ContactStandardsSummarySI();
      contactStandardsSummarySI.setUlIdEvent(GlobalData.getUlIdEvent(request));
      contactStandardsSummarySI.setCdTask(GlobalData.getSzCdTask(request));
      contactStandardsSummarySI.setChildContactRuleBeanList(contactStandardsRetrieveSO.getChildContactRuleBeanList()); 
      contactStandardsSummarySO = common.createContactStandardsSummary(contactStandardsSummarySI);
      state.setAttribute("contactStandardsSummarySO", contactStandardsSummarySO, request);
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  
  /**
   * This method is the main call for deleting a Contact Rule. One or more Conact Rules can be deleted
   * at a time
   *
   * @param context The GrndsExchangeContext object.
   */
  public void deleteContactRules_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteContactRules_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    try {
      ContactStandardsRetrieveSO contactStandardsRetrieveSO = (ContactStandardsRetrieveSO) state.getAttribute("contactStandardsRetrieveSO",request);
      SaveContactRuleSI saveContactRuleSI = new SaveContactRuleSI();
      List<ContactRuleBean> deleteContacRuleRows = populateContactRuleAD(context, ServiceConstants.REQ_FUNC_CD_DELETE);
      saveContactRuleSI.setContactRuleBeanList(deleteContacRuleRows);
      common.saveContactRule(saveContactRuleSI);
      // Regenerate the Parent Rule Summary section since we're doing a save on the rules
      ContactStandardsSummarySO contactStandardsSummarySO = new ContactStandardsSummarySO();
      ContactStandardsSummarySI contactStandardsSummarySI = new ContactStandardsSummarySI();
      contactStandardsSummarySI.setUlIdEvent(GlobalData.getUlIdEvent(request));
      contactStandardsSummarySI.setCdTask(GlobalData.getSzCdTask(request));
      contactStandardsSummarySI.setChildContactRuleBeanList(contactStandardsRetrieveSO.getChildContactRuleBeanList()); 
      contactStandardsSummarySO = common.createContactStandardsSummary(contactStandardsSummarySI);
      state.setAttribute("contactStandardsSummarySO", contactStandardsSummarySO, request);
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  
  /**
   * This method is the main call for save and submitting.  It will call the saveDetail helper method and then populate
   * the ToDoDetailDB bean for display on the To Do Detail page.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveSubmit_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveSubmit_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {

      ContactStandardsSaveSO contactStandardsSaveSO = saveDetail(context, SAVE_SUBMIT_BUTTON);
      if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndDiligentSearch())){
        setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_DILLIGENT_REQ),
                                                          FormattingHelper.formatString(contactStandardsSaveSO.getPersonsForErrorMessage())), request);  
      }
      
      if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndInterested())){
        setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_DIL_SEARCH_INT),
                                                          FormattingHelper.formatString(contactStandardsSaveSO.getPersonsInterestedForErrorMessage())), request);   
      }
      
      if(contactStandardsSaveSO.isDuplicateContactRule()){
        setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_DUP_CONTACT_RULES),
                                                          FormattingHelper.formatString(contactStandardsSaveSO.getNmDuplicateContactRule())), request);   

      }
      
      if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndReunification())){
        setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_FCF_REU_NO_CONTACTS),
                                                          FormattingHelper.formatString(contactStandardsSaveSO.getChildrenNames())), FormattingHelper.formatString(contactStandardsSaveSO.getPersonsReunification())), request);   
      }
      
      if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndPrimaryCaretaker())){
        setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_ADD_CONTACT_RULE_PK),
                                                          FormattingHelper.formatString(contactStandardsSaveSO.getNmPrimaryCaretaker())), request);
      }
      
      if(!ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndContactStandardsComplete())){
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CS_STDS_NOT_MET), request);   
      }
      
      if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndInterested())  ||
                      ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndPrimaryCaretaker())||
                      ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndDiligentSearch()) ||
                      contactStandardsSaveSO.isDuplicateContactRule() ||
                      ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndReunification()) ||
                      !ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndContactStandardsComplete())){
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        return;
      }
      
      // Create the ToDoDetailDB object and place it in the request with the appropriate task code to forward
      // user to the ToDo Detail page
      String taskCode = StringHelper.EMPTY_STRING;
      if (CodesTables.CSTAGES_FSU.equals(GlobalData.getSzCdStage(request))) {
        taskCode = CONTACT_STANDARDS_FSU;
      } else if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) {
        taskCode = CONTACT_STANDARDS_FPR;
      }

      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                   GlobalData.getUlIdStage(request), taskCode);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
    }
    catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  
  /**
   * This helper method is called by the Save and Save and Submit activity methods. It will save the Contact Standards.
   *
   * @param context GrndsExchangeContext
   * @return ContactStandardsSaveSO (used for save and submits)
   * @throws ServiceException
   * @throws CheckboxHelperException
   */
  private ContactStandardsSaveSO saveDetail(GrndsExchangeContext context, String action) throws ServiceException, CheckboxHelperException {
   
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    // Invalidating approval should set event status to PROC. Get the event Status for Invalidate Approval
    ContactStandardsRetrieveSO contactStandardsRetrieveSO = (ContactStandardsRetrieveSO) state.getAttribute("contactStandardsRetrieveSO",request);
    ContactStandardsSaveSO contactStandardsSaveSO = new ContactStandardsSaveSO();
    String eventStatus = contactStandardsRetrieveSO.getCdEventStatus();
    boolean invalidatePendingApproval = false;
    try {
      //Set the invalidate boolean to true
      if (contactStandardsRetrieveSO.getUlIdEvent() != 0 && CodesTables.CEVTSTAT_PEND.equals(eventStatus)
                      && !GlobalData.isApprovalMode(request) && hasStageAccessRights(context)) {
        invalidatePendingApproval = true;
      }
      
      populateContactStandardsRetrieveSO(context, contactStandardsRetrieveSO);

      if (SAVE_SUBMIT_BUTTON.equals(action) || SUBMIT_APPROVAL_BUTTON.equals(action)) {
        contactStandardsRetrieveSO.setSaveAndSubmit(true);
      }
      
      if (SAVE_BUTTON.equals(action)) {
        contactStandardsRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
      }
      
      contactStandardsRetrieveSO.setApprover(GlobalData.isApprovalMode(request));
      contactStandardsSaveSO = (ContactStandardsSaveSO) common.saveContactStandards(contactStandardsRetrieveSO);
      // If save and submit or approval status button is clicked, create the contact standards summary
      // with the information that has been saved. 
      if (SAVE_BUTTON.equals(action) || SAVE_SUBMIT_BUTTON.equals(action)  || SUBMIT_APPROVAL_BUTTON.equals(action)){
        // All Contact Rules are not completed for all children
        ContactStandardsSummarySO contactStandardsSummarySO = new ContactStandardsSummarySO();
        ContactStandardsSummarySI contactStandardsSummarySI = new ContactStandardsSummarySI();
        contactStandardsSummarySI.setUlIdEvent(contactStandardsRetrieveSO.getUlIdEvent());
        contactStandardsSummarySI.setCdTask(contactStandardsRetrieveSO.getCdTask());
        contactStandardsSummarySI.setChildContactRuleBeanList(contactStandardsRetrieveSO.getChildContactRuleBeanList()); 
        contactStandardsSummarySO = common.createContactStandardsSummary(contactStandardsSummarySI);
        contactStandardsSaveSO.setIndContactStandardsComplete(contactStandardsSummarySO.getIndContactStandardsComplete());
        state.setAttribute("contactStandardsSummarySO", contactStandardsSummarySO, request);
        // If All rules have been completed for all children, then set the event status to PEND.
        // If not it will just remain in PROC if the Save and Submit button was clicked
        if (SAVE_SUBMIT_BUTTON.equals(action) && ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndContactStandardsComplete())) {
          int idEvent = contactStandardsRetrieveSO.getUlIdEvent();
          Event event = CaseUtility.getEvent(idEvent);
          UserProfile user = UserProfileHelper.getUserProfile(context);
          String desc = "Contact Standards has been submitted for Approval.";
          ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
          rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PEND);
          rowccmn01uig00.setSzTxtEventDescr(desc);
          rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_CSS);
          rowccmn01uig00.setSzCdTask(contactStandardsRetrieveSO.getCdTask());
          rowccmn01uig00.setUlIdPerson(user.getUserID());
          rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));
          rowccmn01uig00.setUlIdEvent(idEvent);
          rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
          if(idEvent != 0){
            rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
          }
          CCMN01UI ccmn01ui = new CCMN01UI();
          ArchInputStruct archInputStruct = new ArchInputStruct();
          archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
          ccmn01ui.setArchInputStruct(archInputStruct);
          ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
          admin.postEvent(ccmn01ui);
        }
      }
      if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndInterested()) || 
                      ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndPrimaryCaretaker())||
                      ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndDiligentSearch()) ||
                      contactStandardsSaveSO.isDuplicateContactRule() || 
                      ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndReunification()) ||
                      ((SAVE_SUBMIT_BUTTON.equals(action) || SUBMIT_APPROVAL_BUTTON.equals(action)) && !ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndContactStandardsComplete()))){
        return contactStandardsSaveSO;
      }
      
      if (contactStandardsRetrieveSO != null) {
        eventStatus = contactStandardsRetrieveSO.getCdEventStatus();
      }
      // Invalidate the approval if the Event is in Pending status and the user is not the Approver
      if (invalidatePendingApproval) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setUlIdEvent(contactStandardsSaveSO.getUlIdEvent());
        ArchInputStruct ais = new ArchInputStruct();
        ais.setUlSysNbrReserved1(ArchitectureConstants.N);
        ccmn05ui.setArchInputStruct(ais);
        try {
         admin.invalidateApproval(ccmn05ui);
        } catch (ServiceException se) {
          int errorCode = se.getErrorCode();
          switch (errorCode) {
          case Messages.SQL_NOT_FOUND:
            //if there is not an Approval to invalidate just keep on going
            break;
          default:
            GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
            processSevereException(context, se);
            break;
          }
        }
      }
      GlobalData.setUlIdEvent(contactStandardsSaveSO.getUlIdEvent(), request);
      // Clear out the object from state
      state.removeAttribute("contactStandardsRetrieveSO", request);      
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    return contactStandardsSaveSO;
  }
  
  /**
   * This method is the main call for saving a Contact Standards. It will make a call to the private
   * helper method passing it the appropriate action of Save
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveContactStandards_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveContactStandards_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    try {
      Integer idPptEvent = (Integer) state.getAttribute(PPTConversation.PPT_ID_PPT_EVENT, request);
      ContactStandardsSaveSO contactStandardsSaveSO = saveDetail(context, SAVE_BUTTON);    
      if(contactStandardsSaveSO.isDuplicateContactRule()){
        setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_DUP_CONTACT_RULES),
                                                          FormattingHelper.formatString(contactStandardsSaveSO.getNmDuplicateContactRule())), request);   
      
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        return;
      }

      /* If we came from PPT (for FTM) then we need to go back to the
       * original FTM once the Contact Standards has been saved.
       */
      if (idPptEvent != null && idPptEvent > 0) {
        state.setAttribute(PPTConversation.PPT_ID_PPT_EVENT, idPptEvent, request);
        forward(PPTConversation.PPT_INFORMATION_PAGE, request, context.getResponse());
      }

    }
    catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  
  /**
   * This method is called when the user clicks the Approval Status button on the Contact Standards page in
   * approval mode. This method cals the save function, and then we are forwarded to the Approval Status page.
   * 
   * @param context -
   *                the GrndsExchangeContext object
   * @return void
   */
  public void submitApproval_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".submitApproval_xa()");

    HttpServletRequest request = context.getRequest();
        
    try {
      // If approver is approving the contact standard and clicks the Approval Status button, we want to make sure
      // that the validation that are done during save and submit takes place
      if(GlobalData.isApprovalMode(request)) {
        ContactStandardsSaveSO contactStandardsSaveSO = saveDetail(context, SUBMIT_APPROVAL_BUTTON);
        if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndDiligentSearch())){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_DILLIGENT_REQ),
                                                            FormattingHelper.formatString(contactStandardsSaveSO.getPersonsForErrorMessage())), request);  
        }

        if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndInterested())){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_DIL_SEARCH_INT),
                                                            FormattingHelper.formatString(contactStandardsSaveSO.getPersonsInterestedForErrorMessage())), request);   
        }

        if(contactStandardsSaveSO.isDuplicateContactRule()){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_DUP_CONTACT_RULES),
                                                            FormattingHelper.formatString(contactStandardsSaveSO.getNmDuplicateContactRule())), request);   

        }

        if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndReunification())){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CS_FCF_REU_NO_CONTACTS),
                                                                                              FormattingHelper.formatString(contactStandardsSaveSO.getChildrenNames())), FormattingHelper.formatString(contactStandardsSaveSO.getPersonsReunification())), request);   
        }

        if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndPrimaryCaretaker())){
          setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_ADD_CONTACT_RULE_PK),
                                                            FormattingHelper.formatString(contactStandardsSaveSO.getNmPrimaryCaretaker())), request);   

        }
        
        if(!ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndContactStandardsComplete())){
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CS_STDS_NOT_MET), request);   
        }

        if(ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndInterested())  ||
                        ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndPrimaryCaretaker())||
                        ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndDiligentSearch()) ||
                        contactStandardsSaveSO.isDuplicateContactRule() ||
                        ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndReunification()) ||
                        !ArchitectureConstants.Y.equals(contactStandardsSaveSO.getIndContactStandardsComplete())){
          setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          return;
        }
      } else {
        saveDetail(context, SAVE_BUTTON);
      }

    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();

  }
  
  /**
   * This is a helper methode used to Add and Delete Contact Rules.
   * 
   * @param context
   * @param cdReqAction
   * @return
   * @throws ServiceException
   * @throws ParseException
   */
  private List<ContactRuleBean> populateContactRuleAD(GrndsExchangeContext context, String cdReqAction) throws ServiceException, ParseException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateContactRuleAD");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    int idEvent = GlobalData.getUlIdEvent(request);
    List<ContactRuleBean> contactRuleBeanListAD = new ArrayList<ContactRuleBean>();
    try {
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdReqAction)) {
        ContactRuleBean contactRuleBean = new ContactRuleBean();
        contactRuleBean.setUlIdEvent(idEvent);
        contactRuleBean.setIndPrepopulated(ArchitectureConstants.N);
        contactRuleBean.setCdReqAction(ServiceConstants.REQ_FUNC_CD_ADD);
        contactRuleBeanListAD.add(contactRuleBean);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdReqAction)) {
        // Get the list of Contact Rules from the state
        ContactStandardsRetrieveSO contactStandardsRetrieveSO = (ContactStandardsRetrieveSO) state.getAttribute("contactStandardsRetrieveSO",request);
        List<ContactRuleBean> retrieveContactRuleBeanList = contactStandardsRetrieveSO.getParentContactRuleBeanList();
        List<Integer> indexCheckedForDelete = new ArrayList<Integer>();
        // Loop thru the list of widgets on the form
        for (int i = 0; ; i++) {
          String deleteCheckbox = "delCheckBox_" + i + "_changed";
          // Break when we can't find the next input.
          if (!request.getParameterMap().containsKey(deleteCheckbox)) {
            break;
          }
          // If the Delete Checkbox was clicked get it's indexed name and add it to the list of Contact Rules
          // to delete
          if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "delCheckBox_" + i))){
            indexCheckedForDelete.add(i);
          }
        }
        // Loop thru the list of Contact Rules and mark the ones checked for delete
        for (int i = 0; i < retrieveContactRuleBeanList.size(); i++) {
          if (indexCheckedForDelete.contains(i)) {
            ContactRuleBean contactRuleBean = retrieveContactRuleBeanList.get(i);
            contactRuleBean.setCdReqAction(ServiceConstants.REQ_FUNC_CD_DELETE);
            contactRuleBeanListAD.add(contactRuleBean);
          }
        }
      }
    }
    catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    
    return contactRuleBeanListAD;
  }
  
  
  /**
   * This helper method is called by the saveContactStandards to populate the output object that
   * was populated from the retrieve method for the Contact Standards Save service.
   * 
   * @param context GrndeExchangeContext
   * @return void
   * @throws ParseException, ServiceException
   */
  private void populateContactStandardsRetrieveSO (GrndsExchangeContext context, ContactStandardsRetrieveSO contactStandardsRetrieveSO) throws ServiceException,
                                                                                      ParseException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateContactStandardsRetrieveSO()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    int idEvent = GlobalData.getUlIdEvent(request);
    String cdEventStatus = contactStandardsRetrieveSO.getCdEventStatus();
    boolean btnNewUsing = (Object)state.getAttribute("BTN_COPY_CLICKED", request) == null ? false : (Boolean)state.getAttribute("BTN_COPY_CLICKED", request);
    try {
      if (idEvent > 0) {
        // if approver modifies the page, page remains PEND
        if (GlobalData.isApprovalMode(request) && isCurrentActiveApprover(context)) {
          contactStandardsRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_PEND);
        } else { // demote event
          contactStandardsRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
        }
        //If the Copy button is clicked to copy the Approved Contact standards
        if(btnNewUsing){
          cdEventStatus = CodesTables.CEVTSTAT_NEW;
          contactStandardsRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_NEW);
          contactStandardsRetrieveSO.setCdTask(GlobalData.getSzCdTask(request));
          contactStandardsRetrieveSO.setDtEventOccurred(new Date());
          contactStandardsRetrieveSO.setDtEventLastUpdate(new Date());
          contactStandardsRetrieveSO.setUlIdEvent(0);   
          GlobalData.setUlIdEvent(0,request);
        }
      }
      List<ContactRuleBean> parentContactRuleBeanList = contactStandardsRetrieveSO.getParentContactRuleBeanList();
      for (int i = 0; i < parentContactRuleBeanList.size(); i++) {
        ContactRuleBean parentContactRuleBean = parentContactRuleBeanList.get(i);
        parentContactRuleBean.setNbrContactsPerMonth(ContextHelper.getIntSafe(request, "nbrParentContactsPerMonth" + i));
        parentContactRuleBean.setIndByFaceToFace(CheckboxHelper.getCheckboxValue(request, "indByFaceToFace_" + i));
        parentContactRuleBean.setIndByTelephone(CheckboxHelper.getCheckboxValue(request, "indByTelephone_" + i));
        parentContactRuleBean.setIndByEmailCorrspndnce(CheckboxHelper.getCheckboxValue(request, "indByEmailCorrspndnce_" + i));
        parentContactRuleBean.setCdContactNotRequired(ContextHelper.getStringSafe(request, "cdContactNotRequired" + i));
        parentContactRuleBean.setTxtJustification(ContextHelper.getStringSafe(request, "txtJustification" + i));
        // The manually added Contact Rule can either have a Person's name in the dropdown with associated PersonID.
        // Unknown Mother or Unknown Mother may instead be selected. If a person's name had been previously selected
        // and one of the Unknown's now have been selected instead, we need to clear out the ID_PERSON. Vice Versa,
        // if one of Unknown's had been previously selected and now the user has chosen an actual Person, we need to
        // set the ID_PERSON and clear out the CD_UNKNOWN_PARENT
        if (!ArchitectureConstants.Y.equals(parentContactRuleBean.getIndPrepopulated())){
          int nmPersonSaved = new Integer(parentContactRuleBean.getUlIdPerson());
          String cdUnknownParentSaved = parentContactRuleBean.getCdUnknownParent();
          String nmPerson = ContextHelper.getStringSafe(request, "nmPerson" + i);
          if ((nmPersonSaved != 0 && (!CodesTables.CUNPRENT_UM.equals(nmPerson) && !CodesTables.CUNPRENT_UF.equals(nmPerson))) ||
            (nmPersonSaved == 0 && (!CodesTables.CUNPRENT_UM.equals(nmPerson) && !CodesTables.CUNPRENT_UF.equals(nmPerson)))) {
            parentContactRuleBean.setUlIdPerson(Integer.parseInt(nmPerson)); 
            parentContactRuleBean.setCdPersonRole(CodesTables.CPARROLE_CTK);
            parentContactRuleBean.setCdUnknownParent(null);

          } else if ((CodesTables.CUNPRENT_UM.equals(cdUnknownParentSaved) || CodesTables.CUNPRENT_UF.equals(cdUnknownParentSaved)) &&
                     (!CodesTables.CUNPRENT_UM.equals(nmPerson) && !CodesTables.CUNPRENT_UF.equals(nmPerson))){
            parentContactRuleBean.setUlIdPerson(Integer.parseInt(nmPerson));
            parentContactRuleBean.setCdPersonRole(CodesTables.CPARROLE_CTK);
            parentContactRuleBean.setCdUnknownParent(null);
          } else if ((nmPersonSaved > 0 || nmPersonSaved == 0) && (CodesTables.CUNPRENT_UM.equals(nmPerson) || CodesTables.CUNPRENT_UF.equals(nmPerson))) {
            if (CodesTables.CUNPRENT_UF.equals(nmPerson)) {
              parentContactRuleBean.setCdUnknownParent(CodesTables.CUNPRENT_UF);
              parentContactRuleBean.setCdPersonRole(CodesTables.CPARROLE_FAT);
              parentContactRuleBean.setUlIdPerson(0);
            } else if (CodesTables.CUNPRENT_UM.equals(nmPerson)){
              parentContactRuleBean.setCdUnknownParent(CodesTables.CUNPRENT_UM);
              parentContactRuleBean.setCdPersonRole(CodesTables.CPARROLE_MOT);
              parentContactRuleBean.setUlIdPerson(0);
            }
          }

          List<ContactForBean> contactForBeanList = parentContactRuleBean.getChildContactForBeanList();
          if (contactForBeanList != null) {
            for (int j = 0; j < contactForBeanList.size(); j++) {
              ContactForBean contactForBean = contactForBeanList.get(j);
              contactForBean
                            .setIndContactFor(CheckboxHelper
                                                            .getCheckboxValue(request, "cbxIndContactFor" + i + "_" + j));
            }
          }
        }
        if (CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
          parentContactRuleBean.setCdReqAction(INSERT);
        } else {
          parentContactRuleBean.setCdReqAction(UPDATE);
          parentContactRuleBean.setUlIdEvent(GlobalData.getUlIdEvent(request));
        }
      }
      // If this is the first time we're accessing the Contact Standards page, mark the Contact Rules 
      // for INSERT else set them for UPDATE
      List<ContactRuleBean> childContactRuleBeanList = contactStandardsRetrieveSO.getChildContactRuleBeanList();
      for (int i = 0; i < childContactRuleBeanList.size(); i++) {
        ContactRuleBean childContactRuleBean = childContactRuleBeanList.get(i);
        childContactRuleBean.setNbrContactsPerMonth(ContextHelper.getInt(request, "nbrChildContactsPerMonth" + i));
        if (CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
          childContactRuleBean.setCdReqAction(INSERT);
        } else {
        childContactRuleBean.setCdReqAction(UPDATE);
        }
      }
      contactStandardsRetrieveSO.setTxtReasonForChange(ContextHelper.getStringSafe(request, "txtReasonForChange"));
      contactStandardsRetrieveSO.setIndCmAcknowledge(CheckboxHelper.getCheckboxValue(request, "indCmAcknowledge"));
      contactStandardsRetrieveSO.setIndSuperApproval(CheckboxHelper.getCheckboxValue(request, "indSuperApproval"));
      contactStandardsRetrieveSO.setIndContactStandardsComplete(ContextHelper.getStringSafe(request, "indContactStandardsComplete"));
      // If this is the first time we're accessing the Contact Standards page, mark the the page 
      // for ADD else set it for UPDATE
      if (CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
        contactStandardsRetrieveSO.setCdReqAction(ADD);
      } else {
        contactStandardsRetrieveSO.setCdReqAction(UPDATE);
      }
      contactStandardsRetrieveSO.setDtEventLastUpdate(ContextHelper.getJavaDateSafe(request, "evtsLastUpdate"));
      contactStandardsRetrieveSO.setUlIdUser(user.getUserID());
      contactStandardsRetrieveSO.setCdTask(GlobalData.getSzCdTask(request));
      
      /*
       * The following section is for when we're coming from the FTM page.
       * We will need to save the Contact Standards to this corresponding FTM.
       */
      Integer idPptEvent = (Integer) state.getAttribute(PPTConversation.PPT_ID_PPT_EVENT, request);
      
      if (idPptEvent != null && idPptEvent > 0) {
        contactStandardsRetrieveSO.setUlIdPptEvent(idPptEvent);
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }
  
  /**
   * Appends pageName to CONVERSATION_URL
   *
   * @param pageName String
   * @return CONVERSATION_URL + pagename
   */
  protected static String getUrl(String pageName) {
    return CONVERSATION_URL + pageName;
  }
  
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }
  
  private boolean isCurrentActiveApprover(GrndsExchangeContext context) {
    boolean result = false;
    HttpServletRequest request = context.getRequest();
    int eventId = GlobalData.getUlIdEvent(request);
    if (eventId != 0) {
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      int loggedInUserId = userProfile.getUserID();
      int approverId = -1;
      ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, eventId);
      ApproversRetrieveSO so = common.retrieveApprovers(si);
      if (so.hasCurrentActiveApprover()) {
        approverId = so.getCurrentActiveApprover().getIdPerson();
      }
      // -- return true if user is approver
      if (loggedInUserId == approverId) {
        result = true;
      }
    }
    return result;
  }
  
  /**
   * This helper method is called by the display methods to synchronize the parent contact rules with the Rlationship section
   * on the Person Detail page
   *
   * @param context GrndsExchangeContext
   * @return int
   * @throws ServiceException
   */
  private int syncContactRules(ContactStandardsRetrieveSI contactStandardsRetrieveSI, GrndsExchangeContext context) throws ServiceException{
   int idEvent = 0;
    
    try {
      idEvent = common.syncContactRule(contactStandardsRetrieveSI);

    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    return idEvent;
  }
  
  private void handleError(ServiceException we, GrndsExchangeContext context) {

    int errorCode = we.getErrorCode();
    
    if (Messages.MSG_CMN_TMSTAMP_MISMATCH == errorCode || Messages.MSG_SYS_EVENT_STS_MSMTCH == errorCode ||
                    Messages.MSG_SYS_STAGE_CLOSED == errorCode || Messages.MSG_DATABASE_SAVE_FAIL == errorCode){
      setErrorMessage(errorCode, context.getRequest());
    } else {
      processSevereException(context, we);
    }          
  }
  
  
}
