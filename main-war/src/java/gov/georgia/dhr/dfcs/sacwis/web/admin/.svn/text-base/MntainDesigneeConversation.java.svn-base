/*
 * CHANGE HISTORY
 * 
 *      04/08/2008      amroberts       STGAP00006800-StaffDesigneeMnt.jsp now allows updates to records from add page.
 */

package gov.georgia.dhr.dfcs.sacwis.web.admin;

// -- Castor Classes --

import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * MntainDesigneeConversation class
 *
 * @author Eric Dickman
 * @version 1.0
 * @created December 11, 2002
 */

public class MntainDesigneeConversation extends BaseHiddenFieldStateConversation {
  /**
   * displayStaffDesigneeMnt Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests an initial display or the user returns back
   * from the Mnt Designee pullback section.  The display service is CARC16S.
   *
   * @param context Context for the request
   */

  private Admin admin;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void displayStaffDesigneeMnt_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffDesigneeMnt_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      //Populating CARC14SI (Retrieve service)
      CARC16SI carc16si = populateCARC16SI_Retrieve(context);
      //String s = WtcHelper.callService("CARC16S", carc16si);
      //StringReader reader = new StringReader(s);
      //CARC16SO carc16so = CARC16SO.unmarshal(reader);
      CARC16SO carc16so = admin.retrieveDesigneeAssignments(carc16si);

      //Setting CARC16SO to state
      state.setAttribute(DESIGNEE_INFO, carc16so, request);
      UserProfile userProfile = UserProfileHelper.getUserProfile(context);

      //Sets page mode
      String pageMode = PageModeConstants.VIEW;
      if (userProfile.hasRight(UserProfile.SEC_MNTN_SEC)) {
        pageMode = PageModeConstants.EDIT;
      }

      //Setting setPageMode to state
      PageMode.setPageMode(pageMode, request);

      //Checks if the user is accessing the page from the Staff_Search.jsp
      String previousURL = ContextHelper.getPreviousUrl(context);
      if (previousURL.equals(STAFF_SEARCH)) {
        Sets.setPageSet(Sets.A, request);
      }
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * saveMntainDesignee Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests a attempts to save.  This methods saves the
   * individual listed in the under employee name.
   *
   * @param context Context for the request
   */

  public void saveMntainDesignee_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveMntainDesignee_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    StaffSearchInput io = new StaffSearchInput();

    //Opens the Staff_Search Page
    io.setSourcePage(SOURCE_PAGE);
    io.setDestinationUrl(DISPLAY_STAFF_DESIGNEE_MNT);
    request.setAttribute("StaffSearchInput", io);

    try {
      //Populating CARC18SI (Add/Update and Delete service)
      CARC17SI carc17si = populateCARC17SI_AUD(context);
      admin.saveDesigneeAssignments(carc17si);

      request.setAttribute("grnds.request.qname", null);
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
          request.setAttribute("frmStaffDesigneeMnt", new FormValidation());
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          setErrorMessage(errorMessage, DISPLAY_STAFF_DESIGNEE_MNT, request);
          break;

        case Messages.MSG_DUPLICATE_RECORD:
          request.setAttribute("frmStaffDesigneeMnt", new FormValidation());
          String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
          setErrorMessage(errorMessage1, DISPLAY_STAFF_DESIGNEE_MNT, request);
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    //ecd    displayStaffDesigneeMnt_xa( context );
  }

  /**
   * addDesigneeOf Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests to add a individual to the Mnt Designee jsp.
   * The Add method will forward the to the Staff Search jsp.  This method uses Service CARC16S.
   *
   * @param context Context for the request
   */

  public void addDesigneeOf_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addDesigneeOf_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    StaffSearchInput io = new StaffSearchInput();

    // Creates the input object needed by StaffSearch.jsp and puts the object in request
    io.setSourcePage(SOURCE_PAGE);
    io.setDestinationUrl(DISPLAY_STAFF_DESIGNEE_MNT);
    request.setAttribute("StaffSearchInput", io);

    // Set the attribute to null so grnds knows to create a new context, get the new
    // context and forward the user.
    try {
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (ServletException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * saveTempDesigneeOf_xa
   * <p/>
   * This method is called by the GRNDS controller when the user requests to save an individual on the pullback section
   * of the Mnt Designee jsp.  This method uses uses Service CARC17S.
   *
   * @param context Context for the request
   */

  public void saveTempDesigneeOf_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveTempDesigneeOf_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

//acr  carc16so = (CARC16SO) state.getAttribute(DESIGNEE_INFO, request);

    //Adds all designees to structure regardless of record expiration
    CARC16SI carc16si = populateCARC16SI_Retrieve(context);
    carc16si.setBIndRetrieveAllDesignees(ArchitectureConstants.Y);
    CARC16SO carc16so = admin.retrieveDesigneeAssignments(carc16si);

    //Verify that ROWCARC14SOG00_ARRAY in not null
    ROWCARC14SOG00_ARRAY rowcarc14sog00Array;
    if (carc16so.getROWCARC14SOG00_ARRAY() == null) {
      rowcarc14sog00Array = new ROWCARC14SOG00_ARRAY();
    } else {
      rowcarc14sog00Array = carc16so.getROWCARC14SOG00_ARRAY();
    }

    Enumeration sog00enum = rowcarc14sog00Array.enumerateROWCARC14SOG00();

    //  Check to see if the user is attempting to add a duplicate row
    boolean duplicateName = false;
    String tempDesigneeId = ContextHelper.getStringSafe(request, "hdnIdPersonDesignee");
    ROWCARC14SOG00 sog00 = new ROWCARC14SOG00();
    //Ensures that the there is not duplicate records for a designee of
    while (sog00enum.hasMoreElements()) {
      sog00 = (ROWCARC14SOG00) sog00enum.nextElement();
      String designeeId = FormattingHelper.formatInt(sog00.getUlIdPersonDesignee());

      if (tempDesigneeId.equals(designeeId)) {
        duplicateName = true;
        break;
      }
    }

//acr    if (duplicateName) {
//      String errorMessage3 = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
//      setErrorMessage(errorMessage3, DISPLAY_STAFF_DESIGNEE_MNT, context.getRequest());
//    } else {
      try {
        CARC17SI carc17si = new CARC17SI();
        if (duplicateName) {
          //Populating CARC17SI
          carc17si = populateCARC17SI_SINGLE_UPDATE(context,sog00);
        
        } else {
          //Populating CARC17SI
          carc17si = populateCARC17SI_SINGLE_ADD(context);
        }
        admin.saveDesigneeAssignments(carc17si);
        request.setAttribute("grnds.request.qname", null);

        //Removed after PMD was installed.  PMD Conflict Avoid UInused variables.  Remove after QA SWEEP UNIT Test
        //CARC17SO carc17so = CARC17SO.unmarshal( new StringReader( outputXml ) );
      } catch (ServiceException e) {
        
        switch (e.getErrorCode()) {
          case Messages.MSG_SEC_TOO_MANY_DESIGNEES:
            String message1 = MessageLookup.getMessageByNumber(Messages.MSG_SEC_TOO_MANY_DESIGNEES);
            setErrorMessage(message1, request);
            break;
          
          case Messages.MSG_SEC_TOO_MANY_DESIGNATORS:
            String message2 = MessageLookup.getMessageByNumber(Messages.MSG_SEC_TOO_MANY_DESIGNATORS);
            setErrorMessage(message2, request);
            break;
          
          default:
            GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + e.getMessage());
            processSevereException(context, e);
            break;
        }    

      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    

    // Set the Page Set for re-display
    Sets.setPageSet(Sets.NONE, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    // ecd displayStaffDesigneeMnt_xa( context );
  }

  /**
   * deleteTempDesigneeOf Method
   * <p/>
   * This method is called by the GRNDS controller when the user requests to delete a individual from the Temporary
   * Pullback section of the Mnt Designee jsp. This methods uses Service CARC18S to delete data from the database.
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

    Sets.setPageSet(Sets.NONE, request);

    // ecd displayStaffDesigneeMnt_xa( context );
    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
  }

  /**
   * deleteDesigneeOf_xa
   * <p/>
   * This method is called by the GRNDS controller when the user requests to delete an individual on the Mnt Designee
   * jsp. This method uses Service CARC17S.
   *
   * @param context Context for the request
   */

  public void deleteDesigneeOf_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteDesigneeOf_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      //Populating CARC18SI (Add, Update and Delete Service)
      CARC17SI carc17si = populateCARC17SI_SINGLE_DELETE(context);
      admin.saveDesigneeAssignments(carc17si);
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (ServiceException e) {
      switch (e.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
          String message = MessageLookup.getMessageByNumber(Messages.SQL_NOT_FOUND);
          setErrorMessage(message, request);
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + e.getMessage());
          processSevereException(context, e);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * populateCARC17SI_SINGLE_ADD Method
   * <p/>
   * Getter method for a check is updated, deleted, or added to the database.
   *
   * @param context Context for the request
   * @return carc18si is returned to the saveStaffSecuirityMaint method
   */
  private CARC17SI populateCARC17SI_SINGLE_ADD(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //Allocate the structures
    ROWCARC18SIG00 rowcarc18sig00 = new ROWCARC18SIG00();
    CARC17SI carc17si = new CARC17SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    ArchInputStruct input = new ArchInputStruct();
    ROWCARC18SIG00_ARRAY_CARC17SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC17SI();
    
    //Allow a check for records that have expired and are not displayed


    // populate main object
    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlPageSizeNbr(1);
    rowcarc18sig00.setUlIdEmpTempAssign(0);

    //Add items from the rowcarc18sig00 array
    rowcarc18sig00.setUlIdPerson(user.getUserID());
    rowcarc18sig00.setUlIdPersonDesignee(ContextHelper.getIntSafe(request, "hdnIdPersonDesignee"));
    rowcarc18sig00.setDtDtAssignExpiration(ContextHelper.getCastorDateSafe(request, "tempDate"));
    rowcarc18sig00.setSzCdSysDataActionOutcome(ACTION_ADD);
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);

    carc17si.setArchInputStruct(input);
    carc17si.setROWCARC18SIG00_ARRAY_CARC17SI(rowcarc18sig00_array);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc17si;
  }

  /**
   * populateCARC17SI_SINGLE_UPDATE Method
   * <p/>
   * Getter method for a check is updated, deleted, or added to the database.
   *
   * @param context Context for the request
   * @param sog00 Structure for duplicate row
   * @return carc18si is returned to the saveStaffSecuirityMaint method
   */
  private CARC17SI populateCARC17SI_SINGLE_UPDATE(GrndsExchangeContext context, ROWCARC14SOG00 sog00 ) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,  ".populateCARC17SI_SINGLE_UPDATE()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    CARC17SI carc17si = new CARC17SI();
    ArchInputStruct input = new ArchInputStruct();

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setSzUserId(user.getUserLogonID());
    ROWCARC18SIG00_ARRAY_CARC17SI designeeArrayIn = copyDesigneeOutToIn(sog00, request);

    // populate archinputstruct
    input.setUlPageSizeNbr(designeeArrayIn.getROWCARC18SIG00Count());

    // populate main object
    carc17si.setArchInputStruct(input);
    carc17si.setROWCARC18SIG00_ARRAY_CARC17SI(designeeArrayIn);
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc17si;
  }
   
  /**
   * populateCARC17SI_AUD
   * <p/>
   * This methods add, updates, or deletes any information on the Staff Designee Mnt.jsp. Uses Service CARC17S
   *
   * @param context Context for the request
   */
  private CARC17SI populateCARC17SI_AUD(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCARC17SI_AUD()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CARC17SI carc17si = new CARC17SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setSzUserId(user.getUserLogonID());

    // populate designee list
    CARC16SO carc16so = (CARC16SO) state.getAttribute(DESIGNEE_INFO, request);

    //Verify that ROWCARC14SOG00_ARRAY in not null
    ROWCARC14SOG00_ARRAY designeeArrayOut;
    if (carc16so.getROWCARC14SOG00_ARRAY() == null) {
      designeeArrayOut = new ROWCARC14SOG00_ARRAY();
    } else {
      designeeArrayOut = carc16so.getROWCARC14SOG00_ARRAY();
    }
    ROWCARC18SIG00_ARRAY_CARC17SI designeeArrayIn = copyDesigneeOutToIn(designeeArrayOut, request);

    // populate archinputstruct
    input.setUlPageSizeNbr(designeeArrayIn.getROWCARC18SIG00Count());

    // populate main object
    carc17si.setArchInputStruct(input);
    carc17si.setROWCARC18SIG00_ARRAY_CARC17SI(designeeArrayIn);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc17si;
  }

  /**
   * populateCARC18SI_SINGLE_DELETE Method
   * <p/>
   * Getter method for deleting a individual from the database.
   *
   * @param context Context for the request
   * @return carc17s is returned to the deleteStaffSecuirityMaint method
   */

  private CARC17SI populateCARC17SI_SINGLE_DELETE(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCARC18SI_SINGLE_DELETE()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //Allocate the structures
    ROWCARC18SIG00 rowcarc18sig00 = new ROWCARC18SIG00();
    CARC17SI carc17si = new CARC17SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    ROWCARC18SIG00_ARRAY_CARC17SI rowcarc18sig00_array = new ROWCARC18SIG00_ARRAY_CARC17SI();

    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlPageSizeNbr(1);

    //Populates rowcarc18sig00
    rowcarc18sig00.setUlIdEmpTempAssign(ContextHelper.getIntSafe(request, "hdnUlIdEmpTempAssign"));
    rowcarc18sig00.setUlIdPerson(user.getUserID());
    rowcarc18sig00.setUlIdPersonDesignee(ContextHelper.getIntSafe(request, "hdnUlIdPersonDesignee"));
    rowcarc18sig00.setDtDtAssignExpiration(ContextHelper.getCastorDateSafe(request, "hdnDtAssignExpiration"));
    rowcarc18sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));
    rowcarc18sig00.setSzCdSysDataActionOutcome(ACTION_DELETE);
    rowcarc18sig00_array.addROWCARC18SIG00(rowcarc18sig00);

    carc17si.setROWCARC18SIG00_ARRAY_CARC17SI(rowcarc18sig00_array);
    carc17si.setArchInputStruct(input);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc17si;
  }

  /**
   * ROWCARC18SIG00_ARRAY_CARC17SI
   * <p/>
   * This methods uses ROWCARC14SOG00 and then saves and changes
   * ROWCARC18SIG00_ARRAY_CARC17SI array. Uses Service CARC17S
   *
   * @param outRow
   * @param request
   * @return carc17s is returned to the deleteStaffSecuirityMaint method
   */
  private ROWCARC18SIG00_ARRAY_CARC17SI copyDesigneeOutToIn(ROWCARC14SOG00 outRow,
                                                            HttpServletRequest request) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".copyDesigneeOutToIn()");
    performanceTrace.enterScope();

    //Instantiate structures
    ROWCARC18SIG00_ARRAY_CARC17SI outputArray = new ROWCARC18SIG00_ARRAY_CARC17SI();
    ROWCARC18SIG00 inRow = new ROWCARC18SIG00();;
    
    //Set information 
    inRow.setUlIdEmpTempAssign(outRow.getUlIdEmpTempAssign());
    inRow.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    inRow.setUlIdPersonDesignee(outRow.getUlIdPersonDesignee());
    inRow.setDtDtAssignExpiration(ContextHelper.getCastorDateSafe(request, "tempDate"));
    inRow.setTsLastUpdate(outRow.getTsLastUpdate());
    inRow.setSzCdSysDataActionOutcome(ACTION_UPDATE);
    outputArray.addROWCARC18SIG00(inRow);
          
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return outputArray;
  }

  /**
   * ROWCARC18SIG00_ARRAY_CARC17SI
   * <p/>
   * This methods Enumeration over ROWCARC18SIG00_ARRAY_CARC17SI array and then saves and changes
   * ROWCARC18SIG00_ARRAY_CARC17SI array. Uses Service CARC17S
   *
   * @param inputArray
   * @param request
   * @return carc17s is returned to the deleteStaffSecuirityMaint method
   */
  private ROWCARC18SIG00_ARRAY_CARC17SI copyDesigneeOutToIn(ROWCARC14SOG00_ARRAY inputArray,
                                                            HttpServletRequest request) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".copyDesigneeOutToIn()");
    performanceTrace.enterScope();

    ROWCARC18SIG00_ARRAY_CARC17SI outputArray = new ROWCARC18SIG00_ARRAY_CARC17SI();
    int i = 0;

    //Enumeration over ROWCARC14SOG00 to populate CARC17SI
    for (Enumeration e = inputArray.enumerateROWCARC14SOG00(); e.hasMoreElements();) {
      ROWCARC14SOG00 outRow = (ROWCARC14SOG00) e.nextElement();
      ROWCARC18SIG00 inRow = new ROWCARC18SIG00();
      inRow.setUlIdEmpTempAssign(outRow.getUlIdEmpTempAssign());
      inRow.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
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
   * populateCARC14SI_Retrieve
   * <p/>
   * Getter method for displaying Mnt Designee jsp.
   *
   * @param context Context for the request
   * @return carc17si is returned to the displayStaffSecuirityMaint method
   */

  private CARC16SI populateCARC16SI_Retrieve(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCARC16SI_Retrieve()");
    performanceTrace.enterScope();

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
    carc16si.setUlIdPerson(UserProfileHelper.getUserProfile(context).getUserID());
    
    //sets the retrieve to only the current designees (haven't expired)
    carc16si.setBIndRetrieveAllDesignees(ArchitectureConstants.N);


    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return carc16si;
  }

  /**
   * handleError
   * <p/>
   * This methods handles Errors.
   */

  private void handleError(ServiceException we, GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".handleError()");
    performanceTrace.enterScope();

    switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        String errorMessage10 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        setErrorMessage(errorMessage10, DISPLAY_STAFF_DESIGNEE_MNT, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "MntainDesigneeConversation";
  public static final String STAFF_SEARCH = "/admin/StaffSearch/displayStaffSearch";
  public static final int PAGE_SIZE_NBR = 60;
  public static final int PAGE_NUMBER = 1;
  public static final int SOURCE_PAGE = StaffSearchInput.OTHER_MAINTAIN_SEARCH;
  public static final String ACTION_ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  public static final String ACTION_DELETE = ServiceConstants.REQ_FUNC_CD_DELETE;
  public static final String ACTION_UPDATE = ServiceConstants.REQ_FUNC_CD_UPDATE;
  public static final String DISPLAY_STAFF_DESIGNEE_MNT = "/admin/MntainDesignee/displayStaffDesigneeMnt";
  public static final String DESIGNEE_INFO = "CARC16SO";

}

