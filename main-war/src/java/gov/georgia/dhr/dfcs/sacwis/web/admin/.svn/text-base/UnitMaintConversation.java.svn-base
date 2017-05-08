//*  Created by:   Paul Lang
//*  Date Created: 11/01/02
/*
 Change History:
 Date      User              Description
 --------  ----------------  ----------------------------------------------
 06/26/03  Todd Reser        SIR 18465 - Added pagination.
 08/14/03  GRIMSHAN          SIR 19469 - The user id and designees of the user
 MUST be passed into the service for the page mode
 to be returned correctly.
 03/15/04  CORLEYAN          SIR 22647 - in search unit set ulpagesizenbr to
 250 so all units can be displayed
 08/30/04  Todd Reser        SIR 22933 - If user has Unit Summary Access, view
 mode only.
 10/26/04  Todd Reser        Changed if statement for 22933 to if not
 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 */

package gov.georgia.dhr.dfcs.sacwis.web.admin;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveInitialUnitBeforeBecomingOwnParentSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN47SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.TempAssignment;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class allows users with unit maintenance responsibility to search for and select a unit in order to
 * view or maintain unit and member information on the Unit Detail page.
 * 
 * @author Paul Lang, November 01, 2002
 */

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  ------------------------------------------------------------------------
 **  07/30/08    charden           STGAP00009615 - added case to catch new Message MSG_CHILD_NO_PARENT in SaveUnitDetail_xa 
 *                                 
 *
 */


@SuppressWarnings("serial")
public class UnitMaintConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "UnitMaintConversation";

  public static final String SUPERVISOR_TYPE = CodesTables.CUNMBRRL_40;

  public static final String MAINTAINER_TYPE = CodesTables.CUNMBRRL_30;

  public static final String MEMBER_TYPE = CodesTables.CUNMBRRL_60;
  
  private static final String CPS_UNIT_PROGRAM = CodesTables.CUNITPGM_CPS;

  public static final int MAX_STAFF_MEMBERS = 50;
  
  public static final String ENABLE_ADD = "EnableAdd";
  
  private static final String UNIT_DETAIL_URL = "/admin/UnitMaint/displayUnitDetail";

  private Admin admin;

  private Person person;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * This This method is called by the GRNDS controller when the user opens the Unit Search JSP.
   * 
   * @param context
   *          Context for the request
   */
  public void displayUnitSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayUnitSearch_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAllAttributes(context.getRequest());
    performanceTrace.exitScope();
  }

  /**
   * This This method is called by the GRNDS controller when the user clicks the Search button. This method performs a
   * Unit search and returns units based on the entered parameters: County, Region/Division, and Unit number.
   * 
   * @param context
   *          Context for the request
   */
  public void searchUnit_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchUnit_xa()");
    performanceTrace.enterScope();

    //BaseSessionStateManager state = getSessionStateManager(context);

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    ArchInputStruct input = new ArchInputStruct();
    CCMN24SI ccmn24si = new CCMN24SI();
    CCMN24SO ccmn24so = new CCMN24SO();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    input.setBPerfInd("Y");
    input.setUsPageNbr(1);
    // 22647 set ulPageSizeNbr to 250.
    input.setUlPageSizeNbr(250);
    input.setSzUserId(user.getUserLogonID());
    ccmn24si.setArchInputStruct(input);
    // Set this to display the results
    ccmn24si.setSzCdUnitCounty(ContextHelper.getStringSafe(context, "cboSzCdUnitCounty"));
    ccmn24si.setSzCdUnitRegion(ContextHelper.getStringSafe(context, "cboSzCdUnitRegion"));
    ccmn24si.setSzNbrUnit(ContextHelper.getStringSafe(context, "txtSzScrNbrUnitParent").toUpperCase());
    String county = ContextHelper.getStringSafe(context, "cboSzCdUnitCounty");
    String region = ContextHelper.getStringSafe(context, "cboSzCdUnitRegion");

    String enableAdd = ArchitectureConstants.N;

    if ("".equals(county) && "".equals(region)) {
      request.setAttribute("SearchPerformed", "N");
      setErrorMessage(Messages.MSG_UNIT_INPUT_REQ, UNIT_DETAIL_URL, context.getRequest());
    } else {
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(context.getRequest(), true);
      try {
        // This code set an indicator to enable Add button for new units creation.
        // the indicator is set only if the user has Maintain Unit Access.
        if (user.hasRight(UserProfile.SEC_MNTN_UNIT)) {
          enableAdd = ArchitectureConstants.Y;
        }
        request.setAttribute(ENABLE_ADD, enableAdd);

        request.setAttribute("SearchPerformed", "Y");

        ccmn24so = admin.retrieveUnitList(ccmn24si);

        context.getRequest().setAttribute("CCMN24SO", ccmn24so);
      } catch (ServiceException we) {
        switch (we.getErrorCode()) {
        case Messages.MSG_CMN_INVALID_UNIT:
        case Messages.MSG_CMN_UNIT_LIST_INV:
        case Messages.MSG_NO_UNIT_FOUND:
          setErrorMessage(Messages.MSG_NO_UNIT_FOUND, UNIT_DETAIL_URL, context.getRequest());
          break;

        default:
          processSevereException(context, we);
          break;
        }
      } catch (Exception e) {
        processSevereException(context, e);
      }
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user clicks the Hyperlink on the UnitSearch JSP.
   * 
   * @param context
   *          Context for the request
   */
  public void displayUnitDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayUnitDetail_xa()");
    performanceTrace.enterScope();

    UserProfile user = UserProfileHelper.getUserProfile(request);

    int ulIdUnit = ContextHelper.getIntSafe(request, "ulIdUnit");

    state.removeAllAttributes(request);
    state.setAttribute("ulIdUnit", String.valueOf(ulIdUnit), request);

    // If Unit is 0, instanciate a new CCMN23SO object
    //-- user clicked the Add button from Unit Search; go to Unit Detail in Add mode
    if (ulIdUnit == 0) {

      CCMN23SO ccmn23so = new CCMN23SO();
      state.setAttribute("CCMN23SO", ccmn23so, request);

      // Check if the User has Maintain Unit security right and set the page mode to EDIT. If not set the
      // page mode to VIEW.
      if (user.hasRight(UserProfile.SEC_MNTN_UNIT)) {
        PageMode.setPageMode(PageModeConstants.NEW, request);
      }

    } else {
      displayUnitDetail(context, ulIdUnit);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called upon the user entering the DisplayUnit Detail_xa method. It checks to see if the user's role
   * within the displayed unit is Maintainer. If the person is a maintainer in the unit then the isMaintainer variable
   * is set to true. This is then used in determining the page state.
   * 
   * @param user
   *          UserProfile
   * @param ccmn23so
   *          CCMN23SO
   * @return isMaintainer
   */
  private boolean isUserMaintainerOrSupervisorForUnit(UserProfile user, CCMN23SO ccmn23so) {
    boolean isMaintainerOrSupervisor = false;
    int userID = user.getUserID();

    Enumeration rowEnum = ccmn23so.getROWCCMN23SOG01_ARRAY().enumerateROWCCMN23SOG01();
    // search people in array for user
    while (rowEnum.hasMoreElements()) {
      ROWCCMN23SOG01 row = (ROWCCMN23SOG01) rowEnum.nextElement();
      int personID = row.getUlIdPerson();
      // if we find the user in the list, check to see if user is a maintainer
      // and then stop looping through enumeration
      if (personID == userID) {
        if (MAINTAINER_TYPE.equals(row.getSzCdUnitMemberRole()) || SUPERVISOR_TYPE.equals(row.getSzCdUnitMemberRole())) {
          isMaintainerOrSupervisor = true;
        }
        break;
      }
    }
    return isMaintainerOrSupervisor;
  }

  /**
   * This method Deletes employees who are 'Out' assigned, from the unit. A checked row on the UnitDetail JSP will be
   * deleted when this method is called.
   * 
   * @param context
   *          Context for the request
   */
  public void deleteUnitDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveUnitDetail_xa()");
    performanceTrace.enterScope();

    try {
      CCMN47SI ccmn47si = populateCCMN47SI_ValidateUpdate(context);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn47si xml: " + ccmn47si.toString());

      CCMN47SO ccmn47so = admin.retrieveUnitID(ccmn47si);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn47so xml: " + ccmn47so.toString());

      // use page data and output of validate service to populate and call save service
      CCMN22SI ccmn22si = populateCCMN22SI_Delete(context);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn22si xml: " + ccmn22si.toString());

      CCMN22SO ccmn22so = admin.saveUnitInformation(ccmn22si);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn22so xml: " + ccmn22so.toString());
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_NO_UNIT_FOUND:
        setErrorMessage(Messages.MSG_CMN_INVALID_PARENT_UNIT, UNIT_DETAIL_URL, request);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_INVALID_PARENT_UNIT:
      case Messages.MSG_CMN_UNIT_APPROVER:
      case Messages.SQL_NOT_FOUND:
        setErrorMessage(errorCode, UNIT_DETAIL_URL, request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method adds a member to the member list by calling the staff search page
   * 
   * @param context
   *          Context for the request
   */
  public void addUnitDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addUnitDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    //BaseSessionStateManager state = getSessionStateManager(request);

    try {

      // Retrieve the newly entered Unit information and save it into State sothat it can be
      // Retrieved when needed.
      //ROWCCMN22SIG01 newUnit = new ROWCCMN22SIG01();

      //newUnit.setSzCdUnitCounty(request.getParameter("szCdUnitCounty"));
      //newUnit.setSzCdUnitRegion(request.getParameter("szCdUnitRegion"));
      //newUnit.setSzCdUnitSpecialization(request.getParameter("szCdUnitSpecialization"));
      //newUnit.setSzNbrUnit(request.getParameter("szNbrUnit"));
      //newUnit.setSzScrNbrUnitParent(request.getParameter("szScrNbrUnitParent"));

      //state.setAttribute("newUnit", newUnit, request);

      StaffSearchInput io = new StaffSearchInput();

      io.setSourcePage(StaffSearchInput.UNIT_MAINT);
      io.setDestinationUrl("/admin/UnitMaint/addUnitMembers");
      request.setAttribute("StaffSearchInput", io);

      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (Exception e) {
      e.printStackTrace();
    }

    performanceTrace.exitScope();
  }

  /**
   * This method pulls back selected members into the list from the staff search page. This method calls the
   * populateCCMN22SI_Add method which saves the members to be added to the Unit.
   * 
   * @param context
   *          Context for the Context
   */
  public void addUnitMembers_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveUnitDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    //BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // populate from the pullback
      CCMN22SI ccmn22si = populateCCMN22SI_Add(context);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn22si xml: " + ccmn22si.toString());

      // call the update service to add pullback info
      CCMN22SO ccmn22so = admin.saveUnitInformation(ccmn22si);
      displayUnitDetail(context, ccmn22so.getUlIdUnit());
      //state.setAttribute("ulIdUnit", ccmn22so.getUlIdUnit(), request);

      performanceTrace.msg(TRACE_TAG, 7, "ccmn22so xml: " + ccmn22so.toString());
    } catch (PopulationException pe) {
      setErrorMessage(pe.getMessage(), UNIT_DETAIL_URL, request);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_INVALID_PARENT_UNIT:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_UNIT_APPROVER:
      case Messages.SQL_NOT_FOUND:
        setErrorMessage(errorCode, UNIT_DETAIL_URL, request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user clicks the Save push button on the Unit detail JSP.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveUnitDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveUnitDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    
    try {
      int ulIdUnit = ContextHelper.getIntSafe(request, "ulIdUnit");
      //-- validate that the parent unit exists
      CCMN47SI ccmn47si = populateCCMN47SI_ValidateUpdate(context);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn47si xml: " + ccmn47si.toString());

      boolean savingUnitAsParent = false;
      if (ulIdUnit == 0 && (ccmn47si.getSzCdUnitCounty().equals(ContextHelper.getStringSafe(context, "szCdUnitCounty")) &&
                            ccmn47si.getSzCdUnitRegion().equals(ContextHelper.getStringSafe(context, "szCdUnitRegion")) &&
                            ccmn47si.getSzNbrUnit().equals(ContextHelper.getStringSafe(context, "szNbrUnit").toUpperCase()))){
        SaveInitialUnitBeforeBecomingOwnParentSI saveInitialUnitBeforeBecomingOwnParentSI = new SaveInitialUnitBeforeBecomingOwnParentSI();
        saveInitialUnitBeforeBecomingOwnParentSI.setCdParentUnitCounty(ccmn47si.getSzCdUnitCounty());
        saveInitialUnitBeforeBecomingOwnParentSI.setCdParentUnitRegion(ccmn47si.getSzCdUnitRegion());
        saveInitialUnitBeforeBecomingOwnParentSI.setNbrParentUnit(ccmn47si.getSzNbrUnit());
        saveInitialUnitBeforeBecomingOwnParentSI.setCdUnitProgram(CPS_UNIT_PROGRAM);
        ulIdUnit = admin.saveInitialUnitBeforeBecomingOwnParent(saveInitialUnitBeforeBecomingOwnParentSI);
        savingUnitAsParent = true;
      }
      CCMN47SO ccmn47so = admin.retrieveUnitID(ccmn47si);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn47so xml: " + ccmn47so.toString());
      // This code is used for validating the newly entered information for the unit, by searching
      // For existing unit with the newly entered information. If one exist, an error message is
      // displayed.

      // use page data and output of validate service to populate and call save service
      CCMN22SI ccmn22si = populateCCMN22SI_Update(context, ccmn47so, savingUnitAsParent);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn22si xml: " + ccmn22si.toString());

      CCMN22SO ccmn22so = admin.saveUnitInformation(ccmn22si);
      performanceTrace.msg(TRACE_TAG, 7, "ccmn22so xml: " + ccmn22so.toString());
      
      //-- if added new
      if(ArchitectureConstants.ERROR_BRANCH_NAME.equals(getPresentationBranch(context))) {
        displayUnitDetail(context, ccmn22so.getUlIdUnit());
      }
      
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_UNIT_CHILD_NO_PARENT:
        setErrorMessage(Messages.MSG_CMN_UNIT_CHILD_NO_PARENT, UNIT_DETAIL_URL, request);
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        break;
      case Messages.MSG_NO_UNIT_FOUND:
        setErrorMessage(Messages.MSG_CMN_INVALID_PARENT_UNIT, UNIT_DETAIL_URL, request);
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        break;
      case Messages.MSG_CMN_UNIT_EXISTS:
      case Messages.MSG_CMN_INVALID_PARENT_UNIT:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_UNIT_APPROVER:
      case Messages.SQL_NOT_FOUND:
        setErrorMessage(errorCode, UNIT_DETAIL_URL, request);
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  private void displayUnitDetail(GrndsExchangeContext context, int ulIdUnit) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    
    CCMN23SI ccmn23si = new CCMN23SI();
    ArchInputStruct input = new ArchInputStruct();
    
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_NO_ACTION);

    // SIR 18465 - Created objects for Pagination and set Page size & number
    TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, pagination);
    pagination.getResultDetails().setResultsPerPage(50);
    input.setUsPageNbr(pagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(pagination.getResultDetails().getResultsPerPage());

    input.setSzUserId(user.getUserLogonID());
    ccmn23si.setArchInputStruct(input);

    ccmn23si.setUlIdUnit(ulIdUnit);

    // SIR 19469 The ulidperson of the user, and his/her designees must be
    // passed into the service in the ulidperson array so that the service
    // can determine if the page should be in modify mode.
    UlIdPerson_ARRAY_CCMN23SI array = new UlIdPerson_ARRAY_CCMN23SI();

    // The first element of the array will be the userId of the user logged in
    array.addUlIdPerson(user.getUserID());

    // Loop through the users designees and add each ID to the array
    List tempAssign = user.getTempAssignments();
    Iterator iterator = tempAssign.iterator();
    while (iterator.hasNext()) {
      TempAssignment tempAssignment = (TempAssignment) iterator.next();
      array.addUlIdPerson(Integer.parseInt(tempAssignment.getTempDesignatorID()));
    }

    // set the ulRowQty equal to the number of Id's in the array
    array.setUlRowQty(array.getUlIdPersonCount());
    ccmn23si.setUlIdPerson_ARRAY_CCMN23SI(array);

    try {

      CCMN23SO ccmn23so = person.findUnitEmployees(ccmn23si);

      state.setAttribute("CCMN23SO", ccmn23so, request);
      String county = ccmn23so.getROWCCMN23SOG02().getSzCdUnitCounty();
      String region = ccmn23so.getROWCCMN23SOG02().getSzCdUnitRegion();
      String userCounty = user.getUserCounty();
      String userRegion = user.getUserRegion();
        
      try {
        userRegion = FormattingHelper.convertRegionCode(userRegion);
        region = FormattingHelper.convertRegionCode(region);
      } catch(DataFormatException dfe) {}

      if (0 != ccmn23so.getROWCCMN23SOG02().getUlIdPerson()) {

        // SIR 18465 - Got Pagination row count and put it in the request.
        ArchOutputStruct archOutputStruct = new ArchOutputStruct();
        // ArchOutputStruct archOutputStruct = ccmn23so.getArchOutputStruct();
        archOutputStruct.setBMoreDataInd(ccmn23so.getBMoreDataInd());
        ccmn23so.setArchOutputStruct(archOutputStruct);

        pagination.setPaginationInformation(ccmn23so.getArchOutputStruct(), ccmn23so.getROWCCMN23SOG01_ARRAY()
                                                                                    .getROWCCMN23SOG01Count());

        request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, pagination);

        PageMode.setPageMode(ccmn23so.getROWCCMN23SOG02().getSzSysCdWinMode(), request);

        // set page mode to Add if Maintain Unit access.
        if (user.hasRight(UserProfile.SEC_MNTN_UNIT)) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);

        }

        // If county and region match and user has Maintain Unit security, edit mode
        if (user.hasRight(UserProfile.SEC_MNTN_UNIT) && userCounty != null && userCounty.equals(county)
            && userRegion != null && userRegion.equals(region)) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);

        }

        // If user has Maintain Unit and Unit Summary Access rights AND
        // user is a maintainer in this unit, edit mode
        if (user.hasRight(UserProfile.SEC_MNTN_UNIT) && user.hasRight(UserProfile.SEC_UNIT_SUMMARY_ACCESS)
            && isUserMaintainerOrSupervisorForUnit(user, ccmn23so)) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);

        }
      } else {
        //-- default to view to avoid attempts to insert duplicate data
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        
        // If county and region match and user has Maintain Unit security, edit mode
        if (user.hasRight(UserProfile.SEC_MNTN_UNIT) && (county.equals(user.getUserCounty())
            || user.getUserMaintainedRegions().contains(region))) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);
        }
      }

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_NO_DUP_LB_ROW:
        this.setPresentationBranch("duplicateRecord", context);
        setErrorMessage(errorCode, UNIT_DETAIL_URL, context.getRequest());
        break;

      case Messages.MSG_NO_ROWS_RETURNED:
      case Messages.SQL_NOT_FOUND:
        setErrorMessage(errorCode, UNIT_DETAIL_URL, request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }

  /**
   * This method helps return the correct parent Unit number on a display by converting to the correct format.
   * 
   * @param context
   *          Context for the request
   */
  private CCMN47SI populateCCMN47SI_ValidateUpdate(GrndsExchangeContext context) {
    CCMN47SI ccmn47si = new CCMN47SI();
    //this gets the information from the parent unit section
    ccmn47si.setSzCdUnitCounty(ContextHelper.getStringSafe(context, "szCdParentUnitCounty"));
    ccmn47si.setSzCdUnitRegion(ContextHelper.getStringSafe(context, "szCdParentUnitRegion"));
    ccmn47si.setSzNbrUnit(ContextHelper.getStringSafe(context, "szNbrParentUnit").toUpperCase());
  
    return ccmn47si;
  }

  /**
   * This method is called when the user pulls back members to be Added to the page. This method saves the current unit
   * with newley added members before redisplaying the page.
   * 
   * @param context
   *          Context for the request
   * @return ccmn22si
   */
  private CCMN22SI populateCCMN22SI_Add(GrndsExchangeContext context) throws PopulationException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCMN23SO ccmn23so = (CCMN23SO) state.getAttribute("CCMN23SO", request);

    //ROWCCMN22SIG01 newUnit = (ROWCCMN22SIG01) state.getAttribute("newUnit", request);

    ROWCCMN23SOG01_ARRAY personListArrayOut = ccmn23so.getROWCCMN23SOG01_ARRAY();
    ArchInputStruct input = new ArchInputStruct();
    CCMN22SI ccmn22si = new CCMN22SI();
    ROWCCMN22SIG02_ARRAY personListArrayIn = new ROWCCMN22SIG02_ARRAY();
    ROWCCMN22SIG01 unitDetail = new ROWCCMN22SIG01();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    if (personListArrayOut == null) {
      personListArrayOut = new ROWCCMN23SOG01_ARRAY();
    }

    // Loop through added staff members
    ROWCCMN50DO_ARRAY addedStaffMembers = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (addedStaffMembers == null) {
      addedStaffMembers = new ROWCCMN50DO_ARRAY();
    }

    // check to make sure we do not have more than the maximum number of members
    int totalStaffMembersAfterAdd = personListArrayOut.getROWCCMN23SOG01Count()
                                    + addedStaffMembers.getROWCCMN50DOCount();

    if (totalStaffMembersAfterAdd > MAX_STAFF_MEMBERS) {
      throw new PopulationException(MessageLookup.getMessageByNumber(Messages.MSG_TOO_MANY_LB_ROWS));
    }

    Enumeration<ROWCCMN50DO> e = addedStaffMembers.enumerateROWCCMN50DO();

    boolean messageDisplayed = false;
    boolean duplicate = false;
    while (e.hasMoreElements()) {
      boolean duplicateRow = false;
      ROWCCMN50DO outRowPerson = e.nextElement();

      // check for duplicate rows by iterating through the rows gotten from state
      Enumeration<ROWCCMN23SOG01> dupCheckEnum = personListArrayOut.enumerateROWCCMN23SOG01();
      while (dupCheckEnum.hasMoreElements() && !duplicateRow) {
        ROWCCMN23SOG01 oldRowPerson = dupCheckEnum.nextElement();

        if (oldRowPerson.getUlIdPerson() == outRowPerson.getUlIdPerson()) {
          duplicateRow = true;
          if (!messageDisplayed) {
            setErrorMessage(Messages.MSG_CMN_EMPLOYEE_NOT_ADDED, UNIT_DETAIL_URL, request);
            messageDisplayed = true;
          }
          break;
        }
      }

      if (!duplicateRow) {
        ROWCCMN22SIG02 inRowPerson = new ROWCCMN22SIG02();
        inRowPerson.setSzCdUnitMemberInOut(CodesTables.CUMINOUT_OUT);
        inRowPerson.setSzScrCdUnitMemberInOut(CodesTables.CUMINOUT_OUT);
        inRowPerson.setUlIdPerson(outRowPerson.getUlIdPerson());
        inRowPerson.setUlIdUnitEmpLink(0);
        inRowPerson.setSzCdUnitMemberRole(MEMBER_TYPE);
        inRowPerson.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
        personListArrayIn.addROWCCMN22SIG02(inRowPerson);
      }
      duplicate = duplicateRow;
    }

    ccmn22si.setROWCCMN22SIG02_ARRAY(personListArrayIn);
    if (!duplicate) {
      ccmn22si.getROWCCMN22SIG02_ARRAY().setUlRowQty(1);
    }
    ccmn22si.setUlRowQty(personListArrayIn.getROWCCMN22SIG02Count());

    ROWCCMN23SOG02 unitDetailFromState = ccmn23so.getROWCCMN23SOG02();

    if (null != unitDetailFromState) {

      unitDetail.setSzCdUnitCounty(unitDetailFromState.getSzCdUnitCounty());
      unitDetail.setSzCdUnitRegion(unitDetailFromState.getSzCdUnitRegion());
      unitDetail.setSzNbrUnit(unitDetailFromState.getSzNbrUnit());
      unitDetail.setSzCdUnitSpecialization(unitDetailFromState.getSzCdUnitSpecialization());
      unitDetail.setSzScrNbrUnitParent(unitDetailFromState.getSzScrNbrUnitParent());
      unitDetail.setTsLastUpdate(unitDetailFromState.getTsLastUpdate());
      unitDetail.setUlIdPerson(unitDetailFromState.getUlIdPerson());
      unitDetail.setUlIdPerson(unitDetailFromState.getUlIdPerson());
      unitDetail.setUlIdUnitParent(unitDetailFromState.getUlIdUnitParent());
      unitDetail.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

      ccmn22si.setROWCCMN22SIG01(unitDetail);
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      input.setSzUserId(user.getUserLogonID());
      ccmn22si.setArchInputStruct(input);
      ccmn22si.setUlIdUnit(unitDetailFromState.getUlIdUnit());
    } else {
      /*
      unitDetail.setSzCdUnitCounty(newUnit.getSzCdUnitCounty());
      unitDetail.setSzCdUnitRegion(newUnit.getSzCdUnitRegion());
      unitDetail.setSzNbrUnit(newUnit.getSzNbrUnit());
      unitDetail.setSzCdUnitSpecialization(newUnit.getSzCdUnitSpecialization());
      unitDetail.setSzScrNbrUnitParent(newUnit.getSzScrNbrUnitParent());
      unitDetail.setUlIdPerson(newUnit.getUlIdPerson());

      // Retrieve the Id OF the parent Unit and set it in the object.
      CCMN47SI ccmn47si = new CCMN47SI();
      ccmn47si.setSzCdUnitCounty(unitDetail.getSzCdUnitCounty());
      ccmn47si.setSzCdUnitRegion(unitDetail.getSzCdUnitRegion());
      ccmn47si.setSzNbrUnit(unitDetail.getSzScrNbrUnitParent());
      CCMN47SO idParentUnit = admin.retrieveUnitID(ccmn47si);
      if (idParentUnit != null) {
        unitDetail.setUlIdUnitParent(idParentUnit.getUlIdUnit());
      }

      unitDetail.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);

      ccmn22si.setROWCCMN22SIG01(unitDetail);
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      input.setSzUserId(user.getUserLogonID());
      ccmn22si.setArchInputStruct(input);

      ccmn22si.setUlIdUnit(0);
      */
    }

    return ccmn22si;
  }

  /**
   * This method is called by the SaveUnitDetail_xa method when the user clicks the Save button. It saves the
   * information currently on the page and redisplays the page.
   * 
   * @param context
   *          Context for the request
   * @param ccmn47so
   *          CCMN47SO
   * @return ccmn22si
   */
  private CCMN22SI populateCCMN22SI_Update(GrndsExchangeContext context, CCMN47SO ccmn47so, boolean savingUnitAsParent) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCMN23SO ccmn23so = (CCMN23SO) state.getAttribute("CCMN23SO", request);
    ROWCCMN23SOG01_ARRAY personListArrayOut = ccmn23so.getROWCCMN23SOG01_ARRAY();
    ArchInputStruct input = new ArchInputStruct();
    CCMN22SI ccmn22si = new CCMN22SI();
    ROWCCMN22SIG02_ARRAY personListArrayIn = new ROWCCMN22SIG02_ARRAY();
    ROWCCMN22SIG01 unitDetail = new ROWCCMN22SIG01();

    if (personListArrayOut != null) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

      int i = 0;

      // Loop through original Staff members for update
      Enumeration e = personListArrayOut.enumerateROWCCMN23SOG01();
      while (e.hasMoreElements()) {
        ROWCCMN23SOG01 outRowPerson = (ROWCCMN23SOG01) e.nextElement();
        String newUnitMemberRole = ContextHelper.getStringSafe(context, "szCdUnitMemberRole" + i);
        // --Added logic to update unitMemberInOut. when there is a change.
        String inOut = "OUT";
        String inUnit = CheckboxHelper.getCheckboxValue(request, "cbxInUnitIndex_CLEAN" + i);
        if ("Y".equals(inUnit)) {
          inOut = "IN";
        }

        if (newUnitMemberRole.equals(SUPERVISOR_TYPE)) {
          unitDetail.setUlIdPerson(outRowPerson.getUlIdPerson());
        }
        if (!newUnitMemberRole.equals(outRowPerson.getSzCdUnitMemberRole())
            || !inOut.equals(outRowPerson.getSzCdUnitMemberInOut())) {
          ROWCCMN22SIG02 inRowPerson = new ROWCCMN22SIG02();
          inRowPerson.setSzCdUnitMemberInOut(inOut);
          inRowPerson.setSzScrCdUnitMemberInOut(outRowPerson.getSzCdUnitMemberInOut());
          inRowPerson.setTsLastUpdate(outRowPerson.getTsLastUpdate());
          inRowPerson.setUlIdPerson(outRowPerson.getUlIdPerson());
          inRowPerson.setUlIdUnitEmpLink(outRowPerson.getUlIdUnitEmpLink());
          inRowPerson.setSzCdUnitMemberRole(newUnitMemberRole);
          inRowPerson.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
          personListArrayIn.addROWCCMN22SIG02(inRowPerson);
        }
        i++;
      }

      ccmn22si.setROWCCMN22SIG02_ARRAY(personListArrayIn);
      ccmn22si.setUlRowQty(personListArrayIn.getROWCCMN22SIG02Count());

      unitDetail.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      unitDetail.setTsLastUpdate(ccmn23so.getROWCCMN23SOG02().getTsLastUpdate());

    } else {
      if (savingUnitAsParent){
        input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
        unitDetail.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      } else {
        //-- adding a new unit with no associated employees yet
        input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
        unitDetail.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      }
      
      //-- set presentation branch to error so we stay on Unit Maintenance Detail after save
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
    }

    unitDetail.setSzCdUnitCounty(ContextHelper.getStringSafe(context, "szCdUnitCounty"));
    unitDetail.setSzCdUnitRegion(ContextHelper.getStringSafe(context, "szCdUnitRegion"));
    unitDetail.setSzNbrUnit(ContextHelper.getStringSafe(context, "szNbrUnit").toUpperCase());
    unitDetail.setSzCdUnitSpecialization(ContextHelper.getStringSafe(context, "szCdUnitSpecialization"));
    unitDetail.setSzScrNbrUnitParent(ContextHelper.getStringSafe(context, "szScrNbrUnitParent").toUpperCase());

    // populated from validate service
    unitDetail.setUlIdUnitParent(ccmn47so.getUlIdUnit());

    ccmn22si.setROWCCMN22SIG01(unitDetail);

    ccmn22si.setArchInputStruct(input);
    if (savingUnitAsParent){
      ccmn22si.setUlIdUnit(ccmn47so.getUlIdUnit());
    } else {
      ccmn22si.setUlIdUnit(ContextHelper.getIntSafe(context, "ulIdUnit"));
    }

    return ccmn22si;
  }

  /**
   * This method is called by the DeleteUnitDetail_xa method when the user clicks the Delete button. It marks the member
   * to be deleted and Updates the page.
   * 
   * @param context
   *          Context for the request
   * @return ccmn22si
   */
  private CCMN22SI populateCCMN22SI_Delete(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCMN23SO ccmn23so = (CCMN23SO) state.getAttribute("CCMN23SO", request);
    ROWCCMN23SOG01_ARRAY personListArrayOut = ccmn23so.getROWCCMN23SOG01_ARRAY();
    ArchInputStruct input = new ArchInputStruct();
    CCMN22SI ccmn22si = new CCMN22SI();
    ROWCCMN22SIG02_ARRAY personListArrayIn = new ROWCCMN22SIG02_ARRAY();

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPersonIndex_CLEAN");
    Set checkedHash = new HashSet<String>(Arrays.asList(checkedValues));

    int personCount = personListArrayOut.getROWCCMN23SOG01Count();
    for (int i = 0; i < personCount; i++) {
      ROWCCMN23SOG01 outRowPerson = personListArrayOut.getROWCCMN23SOG01(i);
      ROWCCMN22SIG02 inRowPerson = new ROWCCMN22SIG02();

      if (checkedHash.contains("" + i)) {
        inRowPerson.setSzCdUnitMemberInOut(outRowPerson.getSzCdUnitMemberInOut());
        inRowPerson.setSzScrCdUnitMemberInOut(outRowPerson.getSzCdUnitMemberInOut());
        inRowPerson.setTsLastUpdate(outRowPerson.getTsLastUpdate());
        inRowPerson.setUlIdPerson(outRowPerson.getUlIdPerson());
        inRowPerson.setUlIdUnitEmpLink(outRowPerson.getUlIdUnitEmpLink());
        inRowPerson.setSzCdUnitMemberRole(ContextHelper.getStringSafe(context, "szCdUnitMemberRole" + i));
        inRowPerson.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
        personListArrayIn.addROWCCMN22SIG02(inRowPerson);
      }
    }

    ccmn22si.setROWCCMN22SIG02_ARRAY(personListArrayIn);

    ROWCCMN22SIG01 unitDetail = new ROWCCMN22SIG01();
    unitDetail.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_NO_ACTION);

    ccmn22si.setROWCCMN22SIG01(unitDetail);

    ccmn22si.setArchInputStruct(input);
    ccmn22si.setUlIdUnit(ContextHelper.getIntSafe(context, "ulIdUnit"));
    ccmn22si.setUlRowQty(personListArrayIn.getROWCCMN22SIG02Count());

    return ccmn22si;
  }
}
