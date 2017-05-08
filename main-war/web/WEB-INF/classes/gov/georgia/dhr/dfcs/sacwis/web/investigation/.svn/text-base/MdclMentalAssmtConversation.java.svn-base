/**
 * This is the Conversation class used to display, save and save and submit the Medical Mental Assesment Conclusion
 * page.
 * 
 * @author Mike Ochu, October 05, 2002
 * 
 * <pre>
 *                               
 *                                 Change History:
 *                                  Date        User      Description
 *                                  ----------  --------  --------------------------------------------------
 *                                  05/10/2003    KRD     SIR 17233 - Code changes applied to support
 *                                                        &quot;Approver Mode&quot; providing supervisors the ability
 *                                                        to modify data without invalidating the pending
 *                                                        approval.  Required changes to
 *                                                        populateCINV31SI_AUD().
 *                                  06/06/03  GRIMSHAN    SIR 16979 - Retrieve page mode from event search conversation
 *                                                        if the page mode does not need to be changed, it will not be
 *                                  07/23/2003  DEMOMA    SIR19133 Change PAGE_SIZE to match Service
 *                                  01/12/2004  RIOSJA    SIR 22494 - retrieveAddressPhoneInfo_xa needs to put
 *                                                        an indicator into the request to let the JSP know that
 *                                                        it should retrieve the original form values from the
 *                                                        request because the data will not be re-retrieved in
 *                                                        the method.
 *                                  05/09/2005  NALLAVS   SIR-23263 For SUB, ADO, and PAD stages, when we Add a
 *                                                        Medical/Mental Assessment,Medical/Mental Assessment will be linked
 *                                                        automatically to the Primary Child instead of presenting with person list
 *                                                        for selection,as each of these stages has single child (Primary Child)
 *                                  02/23/2011  hnguyen   SMS#97850: MR-075 Updated event description to include Visit Date.
 *                                  04/08/2011  hnguyen   SMS#104891: MR-075 Updated event description to display date as double digits.
 * 
 */

// Declare your class pacakge
package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.Investigation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <p>
 * This method displays the Medical Mental Assessment page.
 * </p>
 * <p>
 * The following service is used: <blockquote>
 * <ul>
 * <li>CINV29S - Retrieves Med Mental Assessment Info</li>
 * </ul>
 * </blockquote>
 * </p>
 * <p/>
 * <p>
 * The cinv29so output object is set into state so that it can be passed to the other activity methods in this class.
 * </p>
 * 
 * @param context
 *          The <code>GrndeExchangeContext<code> object.
 */

@SuppressWarnings("serial")
public class MdclMentalAssmtConversation extends BaseHiddenFieldStateConversation {

  /**
   * ***************************************************************************** * Declare any static constants.
   * ******************************************************************************
   */
  public static final int PAGE_SIZE = 50;

  public static final int ROWCINV29SOG01_PAGE_SIZE = 20;

  public static final String ASSMT_EVENT_TYPE = CodesTables.CEVNTTYP_MED;

  public static final String CASE_SUMMARY_PAGE = "CaseSummary";

  public static final String CASE_TODO_PAGE = "caseToDo";

  public static final String DISPLAY_PAGE = "/investigation/MdclMentalAssmt/displayMdclMentalAssmt";

  public static final String EVENT_LIST_PAGE = "EventList";

  public static final String EVENT_SEARCH_PAGE = "EventSearch";

  public static final String EVENT_STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  public static final String STAFF_TODO_PAGE = "staffToDo";

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String MED_REASON_OTHER = CodesTables.CARSAPPT_XXX;

  public static final String PROF_ASSMT_NARR_TABLE_NAME = "PROF_ASSMT_NARR";

  public static final String TRACE_TAG = "MdclMentalAssmtConversation";

  public static final String WINDOW_MODE_NEW_APPRV = "X";

  public static final String WINDOW_MODE_MODIFY = PageModeConstants.MODIFY;

  private Admin admin;

  private Common common;

  private Investigation investigation;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setInvestigation(Investigation investigation) {
    this.investigation = investigation;
  }

  public void displayMdclMentalAssmt_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayMdclMentalAssmt_xa ()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    try {
      // SIR 16979 get the page mode from event search conversation if the page mode
      // does not need to be changed, it will not be
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      // retrieves professional_assmt row
      CINV29SI cinv29si = populateCINV29SI_Retrieve(context);
      CINV29SO cinv29so = investigation.retrieveProfessionalAssessment(cinv29si);

      // retrieves Address/Phone Detail Name expandable section
      // if Name is selected on Medical/Mental.jsp
      int idPerson = cinv29so.getUlIdPersonProfessional();

      CINV30SI cinv30si = populateCinv30S(idPerson, context);
      CINV30SO cinv30so = investigation.retrievePersonAddressPersonPhone(cinv30si);

      if (cinv30so.getLNbrPhoneExtension() == null) {
        cinv30so.setLNbrPhoneExtension("");
      }
      if (cinv30so.getSzAddrProfAssmtCity() == null) {
        cinv30so.setSzAddrProfAssmtCity("");
      }
      if (cinv30so.getSzAddrProfAssmtState() == null) {
        cinv30so.setSzAddrProfAssmtState("");
      }
      if (cinv30so.getSzAddrProfAssmtStLn1() == null) {
        cinv30so.setSzAddrProfAssmtStLn1("");
      }
      if (cinv30so.getSzAddrProfAssmtStLn2() == null) {
        cinv30so.setSzAddrProfAssmtStLn2("");
      }
      if (cinv30so.getSzAddrProfAssmtZip() == null) {
        cinv30so.setSzAddrProfAssmtZip("");
      }
      request.setAttribute("CINV30S_medassmtDetail", cinv30so);

      // Set Page mode
      boolean bStageAccess = CaseUtility.hasStageAccess(userProfile.getUserID(), GlobalData.getUlIdStage(request));

      boolean isAdmin = callIsAdmin(userProfile.getUserID());
      // Check if the User has stage access or is an Administrator.
      // If this is true, set the page mode to Modify. Otherwise set the page mode to View     
      if (bStageAccess || isAdmin) {
        if (ArchitectureConstants.N.equals(cinv29so.getBIndStageClose())) {
          //stage not closed
          pageMode = PageModeConstants.MODIFY;
          PageMode.setPageMode(pageMode, request);
        } else if (ArchitectureConstants.Y.equals(cinv29so.getBIndStageClose())) {
          //stage closed          
          pageMode = PageModeConstants.VIEW;
          PageMode.setPageMode(pageMode, request);
        }
      } else {
        pageMode = PageModeConstants.VIEW;
        PageMode.setPageMode(pageMode, request);
      }

      cinv29so.setUlIdPersonPrincipal(GlobalData.getUlIdPerson(request));
      cinv29so.setSzNmProfAssmtPrincipal(GlobalData.getSzNmPersonFull(request));

      // set the output object in the request.
      request.setAttribute("CINV29S_medassmtDetail", cinv29so);

      ROWCCMN45DO rowccmn45do = cinv29so.getROWCCMN45DO();
      String eventStatus = rowccmn45do.getSzCdEventStatus();

      // if the event status is Pending Approval and the page is not in view mode, or approval mode
      // SIR 18571 - If stage closure event is pending (here, indicated by cinv29so.getUlIdEvent
      // being a valid id), warn user of invalidation
      if ((eventStatus.equals(EVENT_STATUS_PENDING) || cinv29so.getUlIdEvent() > 0)
          && (!PageMode.getPageMode(request).equals(PageModeConstants.VIEW)) && !GlobalData.isApprovalMode(request)) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL), DISPLAY_PAGE, request);
        setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL), DISPLAY_PAGE, request);
      }
      if (eventStatus.equals(EVENT_STATUS_NEW) && PageMode.getPageMode(request).equals(PageModeConstants.VIEW)) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_INV_MED_ASSMT_INCMPL), DISPLAY_PAGE,
                                request);
      }

      // Once you have gotten the CINV29SO object back from
      // the service call. The CINV29SO object is named "cinv29so".
      /* populate the submodle other */
      AdminAddressPhoneBean aapBean = new AdminAddressPhoneBean();
      aapBean.setPhone(cinv29so.getLNbrProfAssmtPhone());
      aapBean.setPhoneExt(cinv29so.getLNbrPhoneExtension());
      aapBean.setAddress1(cinv29so.getSzAddrProfAssmtStLn1());
      aapBean.setAddress2(cinv29so.getSzAddrProfAssmtStLn2());
      aapBean.setCity(cinv29so.getSzAddrProfAssmtCity());
      aapBean.setState(cinv29so.getSzAddrProfAssmtState());
      aapBean.setZipAndSuff(cinv29so.getSzAddrProfAssmtZip());
      aapBean.setCounty(cinv29so.getSzCdProfAssmtCounty());
      aapBean.setComments(cinv29so.getSzTxtProfAssmtCmnts());
      aapBean.addToRequest(request);
    } catch (Exception e) {
      e.printStackTrace();
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
    }
    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by the saveMdclMentalAssmt_xa to populate the input object for the cinv31s save
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  protected CINV31SI populateCINV31SI_AUD(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCINV31SI_AUD()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    StringBuffer description = new StringBuffer();

    AdminAddressPhoneBean aapBean = (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest(request);
    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CINV31SI cinv31si = new CINV31SI();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    ROWCCMN46DI rowccmn46di = new ROWCCMN46DI();

    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));
    input.setBDataAcsInd("Y");
    input.setBPerfInd("Y");
    input.setUsPageNbr(0);
    input.setUlPageSizeNbr(PAGE_SIZE);
    input.setSzUserId(userProfile.getUserLogonID());
    cinv31si.setArchInputStruct(input);
    // Check if event exists
    if (!"0".equals(ContextHelper.getStringSafe(context, "ulIdEvent"))) {
      rowccmn46di.setSzCdEventType(ContextHelper.getStringSafe(context, "szCdEventType"));
      rowccmn46di.setDtDtEventOccurred(ContextHelper.getCastorDateSafe(context, "dtDtEventOccurred"));
      rowccmn46di.setUlIdEvent(ContextHelper.getIntSafe(context, "ulIdEvent"));
      rowccmn46di.setUlIdStage(ContextHelper.getIntSafe(context, "ulIdStage"));
      rowccmn46di.setUlIdPerson(ContextHelper.getIntSafe(context, "ulIdPerson"));
      rowccmn46di.setSzTxtEventDescr(ContextHelper.getStringSafe(context, "szTxtEventDescr"));
      rowccmn46di.setSzCdTask(ContextHelper.getStringSafe(context, "szCdTask"));
      rowccmn46di.setSzCdEventStatus(ContextHelper.getStringSafe(context, "szCdEventStatus"));
      rowccmn46di.setTsLastUpdate(ContextHelper.getJavaDateSafe(context, "evtsLastUpdate"));
      // Data for event_person_link
      if (ContextHelper.getStringSafe(context, "szCdEventStatus").equals(EVENT_STATUS_NEW)) {
        rowccmn01uig01.setUlIdPerson(ContextHelper.getIntSafe(context, "ulIdPersonPrincipal"));
        rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      }
    } else // if new event - populate event portion of input
    {
      // Data for event_person_link table
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01.setUlIdPerson(ContextHelper.getIntSafe(context, "ulIdPersonPrincipal"));
      // Data for event table
      rowccmn46di.setUlIdEvent(0);
      rowccmn46di.setSzCdTask(ContextHelper.getStringSafe(context, "szCdTask"));
      rowccmn46di.setSzCdEventStatus(ContextHelper.getStringSafe(context, "szCdEventStatus"));
      rowccmn46di.setUlIdStage(ContextHelper.getIntSafe(context, "ulIdStage"));
      rowccmn46di.setSzCdEventType(ASSMT_EVENT_TYPE);
      rowccmn46di.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    }
    /*
     * * The event description should be in the format, * "Medical/Mental Assessment - [Principal Name] - [Reason for *
     * Appointment] [Visit Date]"
     */
    description.append("Medical/Mental Assessment");
    description.append(" - ");
    description.append(request.getParameter("szNmProfAssmtPrincipal"));
    description.append(" - ");
    description.append(Lookup.simpleDecodeSafe(CodesTables.CARSAPPT, request.getParameter("selReason")));
    description.append(" ");
    //SMS#104891 update to display double digits date format MM/DD/YYYY
    description.append(FormattingHelper.formatDate(ContextHelper.getCastorDateSafe(context, "txtDate")));
    rowccmn46di.setSzTxtEventDescr(description.toString());
    // Get id person from the security heeder
    rowccmn46di.setUlIdPerson(userProfile.getUserID());
    // set function code to ADD if event does not exist
    if (!"0".equals(ContextHelper.getStringSafe(context, "ulIdEvent"))
        && (!ContextHelper.getStringSafe(context, "szCdEventStatus").equals(EVENT_STATUS_NEW))) {
      cinv31si.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      cinv31si.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    // Populate professional Assessment.
    String id;
    if (ContextHelper.getStringSafe(context, "selSzNmProfAssmtName") != null
        && !"".equals(ContextHelper.getStringSafe(context, "selSzNmProfAssmtName"))) {
      String selSzNmProfAssmtName = ContextHelper.getStringSafe(context, "selSzNmProfAssmtName");
      id = selSzNmProfAssmtName.substring(0, selSzNmProfAssmtName.indexOf("|"));
      String name = selSzNmProfAssmtName
                                        .substring(selSzNmProfAssmtName.indexOf("|") + 1, selSzNmProfAssmtName.length());
      cinv31si.setSzNmProfAssmtName(name);
      cinv31si.setUlIdPersonProfessional(Integer.parseInt(id));
    }
    cinv31si.setSzTxtProfAssmtOther(ContextHelper.getStringSafe(context, "txtOther"));
    cinv31si.setCdProfAssmtApptRsn(ContextHelper.getStringSafe(context, "selReason"));
    cinv31si.setSzTxtProfAssmtFindings(ContextHelper.getStringSafe(context, "txtcomments"));
    cinv31si.setDtProfAssmtAppt(ContextHelper.getCastorDateSafe(context, "txtDate"));
    cinv31si.setCIndOutNetworkAuth(CheckboxHelper.getCheckboxValue(request, "cbxOutOfNetworkAuth"));

    /* Below data for sub module */
    String address1 = aapBean.getAddress1();
    if (!"".equals(address1)) {
      cinv31si.setLNbrPhone(aapBean.getPhone());
      cinv31si.setLNbrPhoneExtension(aapBean.getPhoneExt());
      cinv31si.setSzAddrProfAssmtStLn1(aapBean.getAddress1());
      cinv31si.setSzAddrProfAssmtStLn2(aapBean.getAddress2());
      cinv31si.setSzAddrProfAssmtCity(aapBean.getCity());
      cinv31si.setSzAddrProfAssmtState(aapBean.getState());
      cinv31si.setSzAddrProfAssmtZip(aapBean.getZipAndSuff());
      cinv31si.setSzCdProfAssmtCounty(aapBean.getCounty());
      cinv31si.setSzTxtProfAssmtCmnts(aapBean.getComments());
    }
    /* End sub module data */
    cinv31si.setUlIdPersonPrincipal(ContextHelper.getIntSafe(context, "ulIdPersonPrincipal"));
    cinv31si.setSzNmProfAssmtPrincipal(ContextHelper.getStringSafe(context, "szNmProfAssmtPrincipal"));
    if (cinv31si.getSzCdScrDataAction().equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      cinv31si.setTsLastUpdate(new java.util.Date());
    } else {
      cinv31si.setTsLastUpdate(ContextHelper.getJavaDateSafe(context, "tsLastUpdate"));
    }
    input.setCReqFuncCd(rowccmn01uig01.getSzCdScrDataAction());
    if (!"0".equals(ContextHelper.getStringSafe(context, "approverUlIdEvent"))) {
      cinv31si.setUlIdEvent(ContextHelper.getIntSafe(context, "approverUlIdEvent"));
    } else {
      cinv31si.setUlIdEvent(0);
    }
    cinv31si.setUlIdCase(GlobalData.getUlIdCase(request));
    cinv31si.setROWCCMN46DI(rowccmn46di);
    cinv31si.setROWCCMN01UIG01(rowccmn01uig01);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv31si;
  }

  /**
   * <p>
   * This method saves the Medical Mental Assessment page.
   * </p>
   * <p>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINV31S - Saves the Med Mental Assessment Info</li>
   * <li>CINV29SO - Retrieves the Med Mental Assessment Info for reDisplay</li>
   * </ul>
   * </blockquote>
   * </p>
   * <p/>
   * <p>
   * The cinv29so output object is set into state so that it can be passed to the other activity methods in this class.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */

  public void saveMdclMentalAssmt_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".saveMdclMentalAssmt_xa");
    HttpServletRequest request = context.getRequest();
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveMdclMentalAssmt_xa()");
    performanceTrace.enterScope();
    try {
      try {
        // Allocate the structures
        CINV31SI cinv31si = populateCINV31SI_AUD(context);
        CINV31SO cinv31so = investigation.saveProfessionalAssessment(cinv31si);

        // SMS#97850: MR-075 update FA Person Detail data after any health detail
        // add, update, or delete.
        common.syncFaPersonDetailHealthDetail(cinv31si.getUlIdPersonPrincipal());

        // 7/6/2007 SHINES STGAP00003446 - to stay on detail page after save and redisplay the content
        GlobalData.setUlIdEvent(cinv31so.getUlIdEvent(), request);
        String pageMode = PageModeConstants.MODIFY;
        PageMode.setPageMode(pageMode, request);
        
        // 7/6/2007 SHINES STGAP00003446 - to stay on detail page after save
        forward("/investigation/MdclMentalAssmt/displayMdclMentalAssmt", request, context.getResponse());
      } catch (ServiceException we) {
        handleServiceError(we, context);
        forward("/investigation/MdclMentalAssmt/displayMdclMentalAssmt", request, context.getResponse());
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method is called by the displayMdclMentalAssmt_xa to populate the input object for the cinv29s retrieve
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  private CINV29SI populateCINV29SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV29SI_Retrieve()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CINV29SI cinv29si = new CINV29SI();
    // Set the values for the ArchInputStruct
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    input.setUsPageNbr(1);
    // Sir19133 Changing the page size because the service can only return 20 rows
    input.setUlPageSizeNbr(ROWCINV29SOG01_PAGE_SIZE);
    input.setSzUserId(userProfile.getUserLogonID());
    cinv29si.setArchInputStruct(input);
    cinv29si.setSzSysCdWinMode(WINDOW_MODE_MODIFY);
    cinv29si.setUlIdStage(GlobalData.getUlIdStage(request));
    cinv29si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    cinv29si.setUlIdCase(GlobalData.getUlIdCase(request));
    // DEBUG STUFF
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv29si;
  }

  /**
   * This method retrieves the address of a professional whenever a new selection is made. CINV30S retrieve service.
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */

  public void retrieveAddressPhoneInfo_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".retrieveAddressPhoneInfo_xa ()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    CINV30SI cinv30si;

    try {
      String personId;
      int idPerson = 0;
      if (StringHelper.isValid(ContextHelper.getStringSafe(context, "selSzNmProfAssmtName"))) {
        String selSzNmProfAssmtName = ContextHelper.getStringSafe(context, "selSzNmProfAssmtName");
        personId = selSzNmProfAssmtName.substring(0, selSzNmProfAssmtName.indexOf("|"));
        idPerson = (Integer.parseInt(personId));
      }

      // call the Tuxedo service using the WtcHelper object
      cinv30si = populateCinv30S(idPerson, context);

      CINV30SO cinv30so = investigation.retrievePersonAddressPersonPhone(cinv30si);
      request.setAttribute("CINV30S_medassmtDetail", cinv30so);

      // SIR 22494 - Put an indicator into the request to let the JSP know that
      // it should retrieve the original form values from the request because
      // the data will not be re-retrieved in this method.
      request.setAttribute("bGetDataFromRequest", true);
    } catch (ServiceException we) {
      handleServiceError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method is called to populate the input object for the cinv30s retrieve service.
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */

  private CINV30SI populateCinv30S(int idPerson, GrndsExchangeContext context) {
    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CINV30SI cinv30si = new CINV30SI();
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    // Set the values for the ArchInputStruct
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    input.setUsPageNbr(1);
    // SIR19133 changed 50 to Constant PAGE_SIZE
    input.setUlPageSizeNbr(PAGE_SIZE);
    input.setSzUserId(userProfile.getUserLogonID());
    cinv30si.setArchInputStruct(input);
    cinv30si.setUlIdPerson(idPerson);
    return cinv30si;
  }

  /**
   * This helper method is called to checks for the user Type Administrator.
   * 
   * @param idUser
   * 
   */

  private boolean callIsAdmin(int idUser) {

    boolean isAdmin = false;
    CARC14SI carc14si = new CARC14SI();

    carc14si.setUlIdPerson(idUser);
    // Retrieve the employee Security class names
    CARC14SO car14so = admin.findEmployeeSecurityInformation(carc14si);
    ROWCARC14SOG02_ARRAY secClassNameArray = car14so.getROWCARC14SOG02_ARRAY();
    ROWCARC14SOG02 secClassRow = null;
    Enumeration secClEnumeration = null;
    // Loop thru the security class names and check for "Administrator"
    for (secClEnumeration = secClassNameArray.enumerateROWCARC14SOG02(); secClEnumeration.hasMoreElements();) {
      secClassRow = (ROWCARC14SOG02) secClEnumeration.nextElement();
      if ("Administrator".equalsIgnoreCase(secClassRow.getSzNmSecurityClass())) {
        isAdmin = true;
        break;
      }
    }
    return isAdmin;
  }

  /**
   * This helper method handles all the WTC Exceptions thrown by the Save. Called by the following methods:
   * saveMdclMentalAssmt_xa.
   * 
   * @param we
   * @param context
   *          The GrndeExchangeContext object.
   */
  private void handleServiceError(ServiceException we, GrndsExchangeContext context) {
    switch (we.getErrorCode()) {
    case Messages.MSG_SYS_STAGE_CLOSED:
      String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
      setErrorMessage(errorMessage1, DISPLAY_PAGE, context.getRequest());
      break;
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      String errorMessage2 = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
      setErrorMessage(errorMessage2, DISPLAY_PAGE, context.getRequest());
      break;
    case Messages.MSG_DATABASE_SAVE_FAIL:
      String errorMessage3 = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_SAVE_FAIL);
      setErrorMessage(errorMessage3, DISPLAY_PAGE, context.getRequest());
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      String errorMessage4 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage4, DISPLAY_PAGE, context.getRequest());
      break;
    case Messages.MSG_SYS_MULT_INST:
      String errorMessage5 = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
      setErrorMessage(errorMessage5, DISPLAY_PAGE, context.getRequest());
      break;
    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }

  }

}