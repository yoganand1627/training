package gov.georgia.dhr.dfcs.sacwis.web.admin;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.PageSizeNbr;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * StaffSecurityMntConversation class
 * <p/>
 * <p/>
 * The Staff Sec Mnt Conversation class is used for the Staff Sec Mnt jsp.
 *
 * @author Eric Dickman
 * @version 1.0.1; 
 * 
 * Change History: 
 *   Date        User              Description 
 *   ----------  ----------------  -------------------------------------------------- 
 *   07/24/08    alwilliams        STGAP00008071 - Moved updates from the saveTempDesigneeOf_xa  
 *                                 method to the addDesigneeOf_xa method. 
 *                                    
 *   07/24/08    alwilliams        STGAP00008071 - Updated method saveTempDesigneeOf_xa to issue an error
 *                                 message when trying to add more than 10 designators to an employee. 
 *                                 The maximum number of designators is 10.
 *                                 
 *   08/25/03    Eric Dickman      19620 -- If the form name is equal to null then remove all attributes from
 *                                 Staff_Pull_BACK. 
 *    
 *   07/30/03    Merle Demo        Sir 19133 updated setUlPageSizeNbr for CARC14S.SRC  
 *                                 to match what is in carc14s.h CARC14SO_ROWCARC14SOG00_SIZE = 5.  
 *                                 Added new class PageSizeNbr contains only static variable for 
 *                                 the number of rows to be returned to be returned.
 *          
 *   07/24/2005  werlem            SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail
 *                                 to MPS.
 *   07/26/2011  cwells            SMS #116335: ECEM 5.0 Updated size of the MAX_NUM_ATTRIBUTES from 100(hardcoded) 
 *                                 to ArchitectureConstants.MAX_NUM_ATTRIBUTES (200) to accommodate database field update 
 *                                 and to respond better for future size increase                               
 *                                 
 */
public class StaffSecurityMntConversation extends BaseHiddenFieldStateConversation {

  /**
   * saveStaffSecurityMaint Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests a attempts to save.  This methods saves the
   * Security Profiles and the IT Restricted Security Profiles.
   *
   * @param context Context for the request
   */
  public void saveStaffSecurityMaint_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveStaffSecurityMaint_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      CARC18SI carc18si = populateCARC18SI_AUD(context);

      CARC18SO carc18so = admin.saveStaffSecurityInformation(carc18si);

      //The Staff_pull_back actually gets stored in both as different values
      BaseSessionStateManager state = getSessionStateManager(context);
      state.removeAttribute(StaffSearchInput.STAFF_PULL_BACK, request);
      request.removeAttribute(StaffSearchInput.STAFF_PULL_BACK);

      state.removeAttribute("CARC14SO", request);
    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
          request.setAttribute("frmStaffSecurityMaint", new FormValidation());
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          setErrorMessage(errorMessage, DISPLAY_STAFF_SECURITY_MAINT, request);
          this.setPresentationBranch("error", context);
          break;

        case Messages.MSG_DUPLICATE_RECORD:
          request.setAttribute("frmStaffSecurityMaint", new FormValidation());
          String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
          setErrorMessage(errorMessage1, DISPLAY_STAFF_SECURITY_MAINT, request);
          this.setPresentationBranch("error", context);
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * displayStaffSecuritySearch Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests an initial display or the user returns back
   * from the Staff Security pullback section.  The display service is CARC14S.
   *
   * @param context Context for the request
   */
  public void displayStaffSecuritySearch_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    StaffSearchInput io = new StaffSearchInput();
    io.setSourcePage(SOURCE_PAGE);
    io.setDestinationUrl(DISPLAY_STAFF_SECURITY_MAINT);
    io.setSecMntFlag(true);
    request.setAttribute("StaffSearchInput", io);
    state.setAttribute(SEC_MNT_FLAG, Boolean.TRUE, request);

    //19620 -- If the form name is equal to null then remove all attributes from
    //Staff_Pull_BACK
    if (request.getParameter("formName") == null) {
      state.removeAttribute(StaffSearchInput.STAFF_PULL_BACK, request);
    }

    try {
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
      return;
    }
    catch (Exception o) {
      o.printStackTrace();
    }
  }

  /**
   * displayStaffSecurityMaint Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests an initial display or the user returns back
   * from the Staff Security pullback section.  The display service is CARC14S.
   *
   * @param context Context for the request
   */
  public void displayStaffSecurityMaint_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffSecurityMaint_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Is this is the initial execution of the display xa.  If so
    // clear state and get the staff search object for the desired staff
    // If staff pullback is null both in state and request, this is the initial
    // execution of the display xa.  Clear state.  Even though the pullback is
    // null, we have the person id of the staff member.  Pull it from GlobalData.
    if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) == null &&
        state.getAttribute(StaffSearchInput.STAFF_PULL_BACK, request) == null) {
//      state.removeAllAttributes( request );
      int personID = GlobalData.getUlIdPerson(request);

      StaffSearchInput io = new StaffSearchInput();
      io.setSourcePage(SOURCE_PAGE);
      io.setDestinationUrl(DISPLAY_STAFF_SECURITY_MAINT);
      io.setSecMntFlag(true);
      request.setAttribute("StaffSearchInput", io);
      state.setAttribute(SEC_MNT_FLAG, Boolean.TRUE, request);

      //GlobalData.setUlIdStaff( , request );
      try {
        forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
        return;
      }
      catch (Exception o) {
        o.printStackTrace();
      }
    }
    //ktl else the staff member or designee was returned by a pullback.  Try to retrieve
    //  the information for the staff member or designee.

    // Is this the staff member or a designee?
    if (state.getAttribute(StaffSearchInput.STAFF_PULL_BACK, request) == null) {
      // The first pullback from staff search will be the staff member whose information
      // will be modified.    Further pullbacks from staff search will be designees of
      // the staff member.  Set the attribute in state as a marker to indicate we have
      // the staff member so that these statements are executed only once.

      ROWCCMN50DO_ARRAY staff_array =
              (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

      state.setAttribute(StaffSearchInput.STAFF_PULL_BACK,
                         staff_array,
                         request);

      if (staff_array != null &&
          staff_array.getROWCCMN50DOCount() > 0) {
        ROWCCMN50DO selectedStaff = staff_array.getROWCCMN50DO(0);

        int selectedStaffID = selectedStaff.getUlIdPerson();

        state.setAttribute(SELECTED_STAFF_ID,
                           selectedStaffID,
                           request);

        GlobalData.setUlIdStaff(selectedStaffID, request);
        String nameOfSelectedStaff = selectedStaff.getSzNmPersonFull();
        GlobalData.setSzNmStaff(nameOfSelectedStaff, request);
        Sets.setPageSet(Sets.A, request);
      }

    }

    if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) == null) {
      state.setAttribute(SEC_MNT_FLAG, Boolean.TRUE, request);
    }

    try {
      CARC14SI carc14si = populateCARC14SI_Retrieve(context);

      CARC14SO carc14so = admin.findEmployeeSecurityInformation(carc14si);

      state.setAttribute("CARC14SO", carc14so, request);
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * deleteTempDesigneeOf Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests to delete a individual from the Temporary
   * Pullback section of the Staff Security Mnt jsp. This methods uses Service CARC18S to delete data from the
   * database.
   *
   * @param context Context for the request
   */
  public void deleteTempDesigneeOf_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteTempDesigneeOf_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    //Resets the Page Sets to none
    Sets.setPageSet(Sets.NONE, request);
  }

  /**
   * addDesigneeOf Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests to add a Designee Of to the Staff Security Mnt
   * jsp. The Add method will forward the to the Staff Search jsp.  This method uses Service CARC18S.
   *
   * @param context Context for the request
   */
  public void addDesigneeOf_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addDesigneeOf_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    state.setAttribute(SEC_MNT_FLAG, Boolean.TRUE, request);

    try {
      
      // SIR 18756 -- The Staff Sec Mnt page must call the Retrieve service for the Mnt Designee page.
      // Then the maintainDesigneeRowCounter will verify that Mnt Designee page does not
      // have more than 5 individuals saved.  If there are more than five individuals the
      // MSG_SEC_TOO_MANY_DESIGNEES message is thrown and the pullbacked designee is not
      // added to the database.
      //

      
      // STGAP00008071 - Get the array that contains the list of assignees
      CARC14SO carc14so = (CARC14SO) state.getAttribute("CARC14SO", request);
      ROWCARC14SOG00_ARRAY rowcarc14sog00Array = new ROWCARC14SOG00_ARRAY();
      if (carc14so.getROWCARC14SOG00_ARRAY() != null) {
        rowcarc14sog00Array = carc14so.getROWCARC14SOG00_ARRAY();
      }

      // STGAP00008071 - Verify that the maximum number of assignees is not exceeded when adding the
      // next assignee. The maximum number of assignees was changed to 10. If there are more than 
      // ten assignees assigned then the MSG_SEC_TOO_MANY_DESIGNATORS message is issued 
      // and the pullback is not added to the database.    
      int assigneesCount = rowcarc14sog00Array.getROWCARC14SOG00Count();
      
      if (assigneesCount >= MAX_ASSIGNEES) {
        String errorMessage5 = MessageLookup.getMessageByNumber(Messages.MSG_SEC_TOO_MANY_DESIGNATORS);
        setErrorMessage(errorMessage5, context.getRequest());
        return;
      }      
      
      
      // Creates the input object needed by StaffSearch.jsp and puts the object in request
      StaffSearchInput io = new StaffSearchInput();
      io.setSourcePage(SOURCE_PAGE);
      io.setDestinationUrl(DISPLAY_STAFF_SECURITY_MAINT);
      io.setSecMntFlag(false);
      request.setAttribute("StaffSearchInput", io);

      state.setAttribute(SEC_MNT_FLAG, Boolean.FALSE, request);

      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    }
    catch (Exception o) {
      o.printStackTrace();
      processSevereException(context, o);
    }
    performanceTrace.exitScope();
  }

  /**
   * saveTempDesigneeOf_xa
   * <p/>
   * This method is called by the GRNDS controller when the user requests to save an Designee Of on the pullback section
   * of the Staff Sec Mnt jsp.  This method uses uses Service CARC18S.
   *
   * @param context Context for the request
   */
  public void saveTempDesigneeOf_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveTempDesigneeOf_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    state.setAttribute(SEC_MNT_FLAG, Boolean.TRUE, request);

    // STGAP00008071 - Get the array that contains the list of assignees
    CARC14SO carc14so = (CARC14SO) state.getAttribute("CARC14SO", request);
    ROWCARC14SOG00_ARRAY rowcarc14sog00Array = new ROWCARC14SOG00_ARRAY();
    if (carc14so.getROWCARC14SOG00_ARRAY() != null) {
      rowcarc14sog00Array = carc14so.getROWCARC14SOG00_ARRAY();
    }
    
    //  Check to see if the user is attempting to add a duplicate row
    Enumeration sog00enum = rowcarc14sog00Array.enumerateROWCARC14SOG00();

    boolean duplicateName = false;
    String tempDesigneeId = ContextHelper.getStringSafe(request, "hdnIdPersonDesignee");

    //Ensures that the there is not duplicate records for a designee of
    while (sog00enum.hasMoreElements()) {
      ROWCARC14SOG00 sog00 = (ROWCARC14SOG00) sog00enum.nextElement();
      String designeeId = FormattingHelper.formatInt(sog00.getUlIdPerson());
      if (tempDesigneeId.equals(designeeId)) {
        duplicateName = true;
        break;
      }
    }

    if (duplicateName) {
      setErrorMessage(Messages.MSG_DUPLICATE_RECORD,
                      DISPLAY_STAFF_SECURITY_MAINT,
                      context.getRequest());
    } else {
      try {
        CARC18SI carc18si = populateCARC18SI_SINGLE_ADD(context);
        CARC18SO carc18so = admin.saveStaffSecurityInformation(carc18si);
      }
      catch (ServiceException we) {
        we.printStackTrace();
        processSevereException(context, we);
      }
      catch (Exception o) {
        o.printStackTrace();
        processSevereException(context, o);
      }
    }

    // Set the Page Set for re-display
    Sets.setPageSet(Sets.NONE, request);
    performanceTrace.exitScope();
  }

  /**
   * deleteDesigneeOf_xa
   * <p/>
   * This method is called by the GRNDS controller when the user requests to delete an Designee Of on the Staff Sec Mnt
   * jsp. This method uses Service CARC18S.
   *
   * @param context Context for the request
   */
  public void deleteDesigneeOf_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteDesigneeOf_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    try {
      CARC18SI carc18si = populateCARC18SI_SINGLE_DELETE(context);

      admin.saveStaffSecurityInformation(carc18si);
    }
    catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      switch (errorCode) {
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        case Messages.SQL_NOT_FOUND:
          setErrorMessage(errorCode, request);
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + e.getMessage());
          processSevereException(context, e);
          break;
      }
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * populateCARC18SI_SINGLE_DELETE Method
   * <p/>
   * Getter method for deleting a Designee Of from the database.
   *
   * @param context Context for the request
   * @return carc18si is returned to the deleteStaffSecuirityMaint method
   */
  private CARC18SI populateCARC18SI_SINGLE_DELETE(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCARC18SI_SINGLE_DELETE()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //Allocate the structures
    ROWCARC18SIG00 rowcarc18sig00 = new ROWCARC18SIG00();
    ROWCARC18SIG01 rowcarc18sig01 = new ROWCARC18SIG01();
    CARC18SI carc18si = new CARC18SI();

    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    ROWCARC18SIG00_ARRAY_CARC18SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC18SI();
    ROWCARC18SIG01_ARRAY rowcarc18sig01_array = new ROWCARC18SIG01_ARRAY();

    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlPageSizeNbr(1);

    carc18si.setUlIdEmployee(user.getUserID());

    carc18si.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnLastUpdate"));
    carc18si.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnIdStaffMember"));
    carc18si.setSzIdEmployeeLogon(ContextHelper.getString(context, "szIdEmployeeLogon"));
    rowcarc18sig00.setDtDtAssignExpiration(ContextHelper.getCastorDateSafe(request, "hdnDtAssignExpiration"));
    rowcarc18sig00.setUlIdEmpTempAssign(ContextHelper.getIntSafe(request, "hdnUlIdEmpTempAssign"));
    rowcarc18sig00.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnUlIdPerson2"));
    rowcarc18sig00.setUlIdPersonDesignee(ContextHelper.getIntSafe(request, "hdnUlIdPersonDesignee"));
    rowcarc18sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));

    rowcarc18sig00.setSzCdSysDataActionOutcome(ACTION_DELETE);
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);
    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(rowcarc18sig00_array);

    // SET ROWCAR18SIG01;
    //rowcarc18sig01.setUlIdEmpSecLink(ContextHelper.getIntSafe(request, "ulIdEmpSecLink"));
    //rowcarc18sig01.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));
    //rowcarc18sig01.setSzNmSecurityClass(ContextHelper.getString(context, "cdSecurityClassName"));
    //rowcarc18sig01.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnUlIdPersonDesignee"));


   // rowcarc18sig01.setSzCdSysDataActionOutcome(ACTION_DELETE);
   // rowcarc18sig01_array.addROWCARC18SIG01(rowcarc18sig01);
   // carc18si.setROWCARC18SIG01_ARRAY(rowcarc18sig01_array);

    carc18si.setArchInputStruct(input);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc18si;
  }

  /**
   * populateGlobalData Method
   * <p/>
   * <p/>
   * Getter method for adding a Designee Of to the database.
   *
   * @param context Context for the request
   * @return carc18si is returned to the saveStaffSecuirityMaint method
   */

  private CARC18SI populateCARC18SI_SINGLE_ADD(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCARC18SI_SINGLE_ADD()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //Allocate the structures
    ROWCARC18SIG00 rowcarc18sig00 = new ROWCARC18SIG00();
    CARC18SI carc18si = new CARC18SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    ArchInputStruct input = new ArchInputStruct();
    ROWCARC18SIG00_ARRAY_CARC18SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC18SI();

    // populate main object
    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlPageSizeNbr(1);
    rowcarc18sig00.setUlIdEmpTempAssign(0);

    rowcarc18sig00.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnIdPersonDesignee"));
    rowcarc18sig00.setUlIdPersonDesignee(ContextHelper.getIntSafe(request, "hdnIdStaffMember"));
    rowcarc18sig00.setDtDtAssignExpiration(ContextHelper.getCastorDateSafe(request, "tempDate"));

    rowcarc18sig00.setSzCdSysDataActionOutcome(ACTION_ADD);
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);

    carc18si.setUlIdEmployee(user.getUserID());

    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(rowcarc18sig00_array);
    carc18si.setArchInputStruct(input);

    carc18si.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnLastUpdate"));
    carc18si.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnIdStaffMember"));
    carc18si.setSzIdEmployeeLogon(ContextHelper.getString(context, "szIdEmployeeLogonTemp"));
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc18si;
  }

  /**
   * populateCARC18SI_AUD Method
   * <p/>
   * Getter method for a check is updated, deleted, or added to the database.
   *
   * @param context Context for the request
   * @return carc18si is returned to the saveStaffSecuirityMaint method
   */

  private CARC18SI populateCARC18SI_AUD(GrndsExchangeContext context) throws CheckboxHelperException {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCARC18SI_AUD()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CARC18SI carc18si = new CARC18SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setSzUserId(user.getUserLogonID());
    // populate checkbox list
    Map indicatorHashMap = CheckboxHelper.getCheckedIndicators(request, "cbSecurityProfiles");

    Map itIndicatorHashMap = CheckboxHelper.getCheckedIndicators(request, "cbITSecurityProfiles");
    indicatorHashMap.putAll(itIndicatorHashMap);
    GrndsTrace.msg(TRACE_TAG, 7, "A");

    CARC14SO carc14so = (CARC14SO) state.getAttribute("CARC14SO", request);
    ROWCARC14SOG02_ARRAY outputValues = null;
    if (carc14so.getROWCARC14SOG02_ARRAY() == null) {
      outputValues = new ROWCARC14SOG02_ARRAY();
    } else {
      outputValues = carc14so.getROWCARC14SOG02_ARRAY();
    }

    //Checks if ROWCARC14SOG00_ARRAY is null and creates a new object
    ROWCARC14SOG00_ARRAY designeeArrayOut = null;
    if (carc14so.getROWCARC14SOG00_ARRAY() == null) {
      designeeArrayOut = new ROWCARC14SOG00_ARRAY();
    } else {
      designeeArrayOut = carc14so.getROWCARC14SOG00_ARRAY();
    }

    GrndsTrace.msg(TRACE_TAG, 7, "B");

    Collection changedVector = CheckboxHelper.getChangedValues(request, "cbSecurityProfiles", outputValues,
                                                               ROWCARC14SOG02.class, "szNmSecurityClass");

    GrndsTrace.msg(TRACE_TAG, 7, "C");
    for (Iterator i = changedVector.iterator(); i.hasNext();) {
      CheckboxHelper.ObjectActionCodePair pair = (CheckboxHelper.ObjectActionCodePair) i.next();
      ROWCARC14SOG02 cbRow = (ROWCARC14SOG02) pair.getObject();
      ROWCARC18SIG01 inRow = new ROWCARC18SIG01();
      inRow.setSzNmSecurityClass(cbRow.getSzNmSecurityClass());
      inRow.setTsLastUpdate(cbRow.getTsLastUpdate());
      inRow.setUlIdEmpSecLink(cbRow.getUlIdEmpSecLink());
      inRow.setUlIdPerson(cbRow.getUlIdPerson());
      inRow.setSzCdSysDataActionOutcome(pair.getActionCode());

    }
    ROWCARC18SIG01_ARRAY securityProfilesInput = getChangedValues(indicatorHashMap, outputValues);

    // populate designee list
    ROWCARC18SIG00_ARRAY_CARC18SI designeeArrayIn = copyDesigneeOutToIn(designeeArrayOut, request);

    // populate archinputstruct
    input.setUlSysNbrReserved2(securityProfilesInput.getROWCARC18SIG01Count());
    input.setUlPageSizeNbr(designeeArrayIn.getROWCARC18SIG00Count());

    // populate main object
    carc18si.setArchInputStruct(input);

    carc18si.setUlIdEmployee(user.getUserID());

    carc18si.setSzIdEmployeeLogon(ContextHelper.getStringSafe(context, "szIdEmployeeLogon").toUpperCase());   
    carc18si.setTsLastUpdate(carc14so.getTsLastUpdate());
    carc18si.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnIdStaffMember"));
    carc18si.setROWCARC18SIG00_ARRAY_CARC18SI(designeeArrayIn);
    carc18si.setROWCARC18SIG01_ARRAY(securityProfilesInput);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc18si;
  }

  /**
   * ROWCARC18SIG01_ARRAY
   * <p/>
   * Getter method determining if the checkboxes have been checked or unchecked.
   *
   * @param checkedIndicators returns a map
   * @param outputValues
   * @return nextInputValues
   */

  private static ROWCARC18SIG01_ARRAY getChangedValues(
          //List oldCheckedValues,
          //List newCheckedValues,
          Map checkedIndicators,
          ROWCARC14SOG02_ARRAY outputValues
  ) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getChangedValues()");
    performanceTrace.enterScope();

    ROWCARC18SIG01_ARRAY nextInputValues = new ROWCARC18SIG01_ARRAY();

    // populate deletes only
    Enumeration e = outputValues.enumerateROWCARC14SOG02();
    while (e.hasMoreElements()) {
      ROWCARC14SOG02 prevOutputRow = (ROWCARC14SOG02) e.nextElement();
      String name = prevOutputRow.getSzNmSecurityClass();
      String indicator = (String) checkedIndicators.get(name);
      if ((indicator != null) && indicator.equals(CheckboxHelper.DELETED)) {
        ROWCARC18SIG01 nextInputRow = new ROWCARC18SIG01();
        nextInputRow.setSzCdSysDataActionOutcome(CheckboxHelper.DELETED);
        nextInputRow.setSzNmSecurityClass(prevOutputRow.getSzNmSecurityClass());
        nextInputRow.setTsLastUpdate(prevOutputRow.getTsLastUpdate());
        nextInputRow.setUlIdEmpSecLink(prevOutputRow.getUlIdEmpSecLink());
        nextInputRow.setUlIdPerson(prevOutputRow.getUlIdPerson());
        nextInputValues.addROWCARC18SIG01(nextInputRow);
      }
    }

    // populate adds only
    for (Iterator i = checkedIndicators.keySet().iterator(); i.hasNext();) {
      String name = (String) i.next();
      String indicator = (String) checkedIndicators.get(name);

      if (indicator.equals(CheckboxHelper.ADDED)) {
        ROWCARC18SIG01 nextInputRow = new ROWCARC18SIG01();
        nextInputRow.setSzNmSecurityClass(name);
        nextInputRow.setSzCdSysDataActionOutcome(CheckboxHelper.ADDED);
        nextInputValues.addROWCARC18SIG01(nextInputRow);
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return nextInputValues;
  }

  /**
   * populateCARC14SI_Retrieve
   * <p/>
   * Getter method for displaying the Designee Of(s) and checkboxes.
   *
   * @param context Context for the request
   * @return carc14si is returned to the displayStaffSecuirityMaint method
   */
  private CARC14SI populateCARC14SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCARC14SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CARC14SI carc14si = new CARC14SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(PAGE_NUMBER);
    //Sir19133 updated setUlPageSizeNbr for CARC14S.SRC from 60 to 20
    //input.setUlPageSizeNbr( PAGE_SIZE_NBR );
    input.setUlPageSizeNbr(PageSizeNbr.CARC14SO_ROWCARC14SOG01_SIZE);
    carc14si.setArchInputStruct(input);
    carc14si.setUlIdPerson(GlobalData.getUlIdStaff(request));

    performanceTrace.exitScope();
    return carc14si;
  }

  /**
   * copyDesigneeOutToIn
   * <p/>
   * Getter method for setting the checkboxes that have been changed to the database.
   *
   * @return outputArray
   */
  private ROWCARC18SIG00_ARRAY_CARC18SI copyDesigneeOutToIn(ROWCARC14SOG00_ARRAY inputArray,
                                                            HttpServletRequest request) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".copyDesigneeOutToIn()");
    performanceTrace.enterScope();

    ROWCARC18SIG00_ARRAY_CARC18SI outputArray = new ROWCARC18SIG00_ARRAY_CARC18SI();
    int i = 0;
    for (Enumeration e = inputArray.enumerateROWCARC14SOG00(); e.hasMoreElements();) {
      ROWCARC14SOG00 outRow = (ROWCARC14SOG00) e.nextElement();
      ROWCARC18SIG00 inRow = new ROWCARC18SIG00();
      inRow.setUlIdEmpTempAssign(outRow.getUlIdEmpTempAssign());
      inRow.setUlIdPerson(outRow.getUlIdPerson());
      inRow.setUlIdPersonDesignee(outRow.getUlIdPersonDesignee());
      inRow.setDtDtAssignExpiration(ContextHelper.getCastorDateSafe(request, "txtExpiration" + i++));
      inRow.setTsLastUpdate(outRow.getTsLastUpdate());
      inRow.setSzCdSysDataActionOutcome(ACTION_UPDATE);
      outputArray.addROWCARC18SIG00(inRow);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return outputArray;
  }

  /**
   * handleError
   * <p/>
   * Getter method for handling errors.
   *
   * @param context Context for the request
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".handleError()");
    performanceTrace.enterScope();
    switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        setErrorMessage(errorMessage1, DISPLAY_STAFF_SECURITY_MAINT, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private CARC16SI populateCARC16SI_Retrieve(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCARC16SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //Allocate the structures
    CARC16SI carc16si = new CARC16SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    //set to one
    input.setUsPageNbr(PAGE_NUMBER);
    input.setSzUserId(user.getUserLogonID());
    //set to 60
    input.setUlPageSizeNbr(PAGE_SIZE_NBR);

    //set to 100
    carc16si.setArchInputStruct(input);

    //sets Person Id
    //carc16si.setUlIdPerson(UserProfileHelper.getUserProfile(context).getUserID());
    carc16si.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnIdStaffMember"));

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc16si;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String SEC_MNT_FLAG = "SEC_MNT_FLAG";
  public static final String TRACE_TAG = "StaffSecurityMntConversation";
  public static final String STAFF_SEARCH = "/admin/StaffMnt/staffSearch";
  public static final String INITIAL_STAFF_SEARCH = "/admin/StaffSecurityMnt/displayStaffSecuritySearch";
  public static final int SOURCE_PAGE = StaffSearchInput.OTHER_MAINTAIN_SEARCH;
  public static final String ACTION_ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  public static final String ACTION_DELETE = ServiceConstants.REQ_FUNC_CD_DELETE;
  public static final String ACTION_UPDATE = ServiceConstants.REQ_FUNC_CD_UPDATE;
  public static final String DISPLAY_STAFF_SECURITY_MAINT = "/admin/StaffSecurityMnt/displayStaffSecurityMaint";
  public static final String SELECTED_STAFF_ID = "SELECTED_STAFF_ID";
  // SMS #116335: ECEM 5.0 Updated hardcoded to the constant variable
  public static final int NUMBER_RESERVED = UserProfile.MAX_NUM_ATTRIBUTES;
  public static final int PAGE_SIZE_NBR = 60;
  public static final int PAGE_NUMBER = 1;
  public static final int MAX_ASSIGNEES = 10;
  private Admin admin;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
  

}

