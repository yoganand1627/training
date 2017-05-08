package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN85SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN86SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT99SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdStageCnty_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmCase_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT99SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Conversation class that changes the county and the stage/case name. It combines the old ccmn62w.win and
 * ccmn74w.win. Allows an authorized user to change the name of the case and and/or its stages. Whenever the name of the
 * case is changed, all stages of service within that case will also be changed (except any SUB, PFC, ADO, PAL, and PAD
 * stages). If the selected stage of service is in the list above and the Change Name window is called, only that stage
 * will be changed. The Change County window allows the user to change the county of a stage.  It also changes the
 * county on the CAPS_CASE table.
 *
 * @author Merle A Demo, Jan 10,2003 
 * 
 * <pre>
 *  Change History:
 *  Date      User              Description 
 *  --------  ----------------  -------------------------------------------------- 
 *  05/16/03  DEMOMA (mad)      Sir 17520 truncated the facility name because it was too long to be used as a Stage/Case name. 
 *  09/12/03  DOUGLACS          Sir 19785 - add null checking for stage county
 *  04/08/04  ochumd            Sir 22646 - Management Information Focus Team and the technical leads for IMPACT
 *                              Intranet Reports have determined that they need the ID of the PERSON that has been selected
 *                              as the NM_STAGE. NM_STAGE is stored on the STAGE table.  An indicator  has  been added to the
 *                              STAGE_PERSON_LINK table indicating the selected nmstage.
 *  10/06/08  alwilliams        STGAP00010363 - Updated the displayCaseMnt_xa method to include the PFC stage when checking for
 *                              child specific stages.                    
 *         
 *         
 * </pre>
 * 
 *         
 */
public class CaseMntConversation extends BaseHiddenFieldStateConversation {
  /**
   * method to get information to fill Case Maintenance Screen calls ccmn85s. Also call cint99 just to get county
   * information.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayCaseMnt_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaseMnt_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    state.removeAllAttributes(request);

    try {
      //cdStageCnty set to XXX for none per
      String cdStageCnty = "";
      String cdStage = "";
      String txtLabelName = "Change Case Name";

      CINT99SI cint99si = populateCINT99SI_Retrieve(context);
      //String outputXmlcint99 = WtcHelper.callService("CINT99S", cint99si);
      CINT99SO cint99so = intake.retrieveIntakePriorityClosure(cint99si);
      cdStageCnty = cint99so.getStageRow().getSzCdStageCnty();

      cdStage = cint99so.getStageRow().getSzCdStage();
      
      // STGAP00010363 - Include PFC when checking for child specific stages
      if ("SUB".equals(cdStage) ||
          "PFC".equals(cdStage) ||            
          "PAL".equals(cdStage) ||
          "ADO".equals(cdStage) ||
          "PAD".equals(cdStage)) {
        txtLabelName = "Change Stage Name";
      }

      SzNmPersonFull_ARRAY stageNamesArray = null;
      /* ochumd sir 22646 */
      UlIdNmPerson_ARRAY personIdsArray = null;
      // Load fields need for service CCMN85S
      CCMN85SI ccmn85si = populateCCMN85SI_Retrieve(context);

      // String outputXml = WtcHelper.callService("CCMN85S", ccmn85si);
      CCMN85SO ccmn85so = admin.findAllPrinciplesAndFacility(ccmn85si);
      request.setAttribute("txtLabelName", txtLabelName);
      /* ochumd sir 22646  begin */
      String name = null;
      stageNamesArray = ccmn85so.getSzNmPersonFull_ARRAY();
      personIdsArray = ccmn85so.getUlIdNmPerson_ARRAY();
      for (int i = 0; i < stageNamesArray.getUlRowQty(); i++) {
        name = stageNamesArray.getSzNmPersonFull(i) + "|";
        if (personIdsArray != null && personIdsArray.getUlRowQty() > i) {
          name = name + personIdsArray.getUlIdNmPerson(i);
        }
        stageNamesArray.setSzNmPersonFull(i, name);
      }
      /* ochumd sir 22646  End */
      if (!"".equals(ccmn85so.getSzNmFacilInvstFacility())) {
        //Sir 17520 Facility name are too long to be case/stage name truncated to fit
        String facilityName = "";
        if (ccmn85so.getSzNmFacilInvstFacility().length() > 25) {
          facilityName = ccmn85so.getSzNmFacilInvstFacility().substring(0, 25);
        } else {
          facilityName = ccmn85so.getSzNmFacilInvstFacility();
        }
        //OCHUMD - sir 22646 Add seperator to name here
        stageNamesArray.addSzNmPersonFull(facilityName + "|");
      }
      ccmn85so.setSzNmPersonFull_ARRAY(stageNamesArray);
      String personNameRow = "";
      Map personNameMap = new TreeMap();
      Enumeration personNameEnumeration = stageNamesArray.enumerateSzNmPersonFull();
      while (personNameEnumeration.hasMoreElements()) {
        personNameRow = (String) personNameEnumeration.nextElement();
        Option personOption = new Option(personNameRow, personNameRow.substring(0, personNameRow.indexOf("|")));
        personNameMap.put(personNameRow, personOption);
      }

      state.setAttribute("peopleNames", personNameMap, request);
      state.setAttribute("CCMN85SO", ccmn85so, request);

      //Sir 19785 - null checking needed on County
      String countyDecode = "";
      if (cdStageCnty != null &&
          !"".equals(cdStageCnty) &&
          !cdStageCnty.equals(CodesTables.CCOUNT_XXX)) {
        countyDecode = Lookup.simpleDecodeSafe(CodesTables.CCOUNT, cdStageCnty);
      }

      state.setAttribute("txtDecodeStageCnty", countyDecode, request);
      state.setAttribute(IDCASE, GlobalData.getUlIdCaseAsString(request), request);
      state.setAttribute("IDSTAGE", GlobalData.getUlIdStageAsString(request), request);
    }
    catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Save method update only CCMN86S the person name field OR CCMN27S the county name field.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveCaseMnt_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".save_xa()");
    performanceTrace.enterScope();

    try {
      CCMN86SI ccmn86si = populateCCMN86SI_Update(context);
      CCMN27SI ccmn27si = populateCCMN27SI_Update(context);

      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      // SIR 17827 make the service calls transactional
      /*  WtcTransactionHandle wth = null;
            try {
              //wth = WtcHelper.getTransactionTuxedoConnection();
      */
      // Do not call the service if the name to be changed is NULL
      if (!"".equals(ContextHelper.getStringSafe(request, "selNmPersonHistFull"))) {
        admin.saveCaseNameInformation(ccmn86si);
        //WtcHelper.callService("CCMN86S", ccmn86si.toString(), wth.getTuxedoConnection());
        // update the stage name in globadata because it has changed
        GlobalData.setSzNmStage(ContextHelper.getStringSafe(request, "selNmPersonHistFull").toString(), request);
      }

      // Do not call the service if the county to be changed is NULL
      if (!"".equals(ContextHelper.getStringSafe(request, "selCdStageCnty"))) {
        admin.updateStageCountyCaseCounty(ccmn27si);
        //WtcHelper.callService("CCMN27S", ccmn27si.toString(), wth.getTuxedoConnection());
      }

      //the user will be taken to Case_Summary from here.
      GlobalData.setUlIdCase(Integer.parseInt(state.getAttribute(IDCASE, request).toString()), request);
      /*  }
      finally {
       ;
      }*/
    }
    catch (ServiceException we) {
      handleError86(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    //Add Business Logic HERE (see exampleServiceCall_xa below for example code)
    performanceTrace.exitScope();
  }

  public void setIntake(Intake intake) {
    this.intake = intake;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * Populate CINT99SI object from context, It return the name of the case and people in a case. It was added to
   * Case/Stage Maintenance to replace input variable cdstagecnty
   *
   * @param context Contains the session, state, and request objects
   * @return CINT99SI object
   */
  private CINT99SI populateCINT99SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINT99SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CINT99SI cint99si = new CINT99SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(" ");
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);
    input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());
    cint99si.setArchInputStruct(input);

    cint99si.setUlIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.exitScope();

    return cint99si;
  }

  /**
   * Populate CCMN85SI object from context, It return the name of the case and people in a case.
   *
   * @param context Contains the session, state, and request objects
   * @return CCMN85SI object
   */
  private CCMN85SI populateCCMN85SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN85SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CCMN85SI ccmn85si = new CCMN85SI();
    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(" ");
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);
    input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());
    ccmn85si.setArchInputStruct(input);

    ccmn85si.setSzCdStage(GlobalData.getSzCdStage(request));
    ccmn85si.setUlIdStage(GlobalData.getUlIdStage(request));
    ccmn85si.setUlIdCase(GlobalData.getUlIdCase(request));

    performanceTrace.exitScope();

    return ccmn85si;
  }

  /**
   * Populate CCMN27SI object from context, It updates the county in the Stage table.
   *
   * @param context Contains the session, state, and request objects
   * @return ccmn27si
   * @throws IndexOutOfBoundsException 
   * @throws LookupException 
   */
  private CCMN27SI populateCCMN27SI_Update(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN85SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ArchInputStruct input = new ArchInputStruct();
    CCMN27SI ccmn27si = new CCMN27SI();
    SzCdStageCnty_ARRAY szCdStageCntyArray = new SzCdStageCnty_ARRAY();
    
    //get the selected stage county
    String selectedStageCnty = ContextHelper.getStringSafe(request, "selCdStageCnty");
    if (StringHelper.isValid( selectedStageCnty ) ){
        szCdStageCntyArray.addSzCdStageCnty( selectedStageCnty );
    }
    
    //add old stage county
    szCdStageCntyArray.addSzCdStageCnty( request.getParameter("txtDecodeStageCnty") );

    input.setCReqFuncCd(cReqFuncCd);
    input.setBPerfInd(yes);
    input.setBDataAcsInd(yes);
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    input.setSzUserId(user.getUserLogonID());

    ccmn27si.setArchInputStruct(input);
    ccmn27si.setUlIdStage(Integer.parseInt(state.getAttribute("IDSTAGE", request).toString()));
    ccmn27si.setUlIdCase(Integer.parseInt(state.getAttribute(IDCASE, request).toString()));
    ccmn27si.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    //ccmn27si.setSzCdStageCnty(ContextHelper.getStringSafe(request, "selCdStageCnty"));
    //add counties to input object
    ccmn27si.setSzCdStageCnty_ARRAY( szCdStageCntyArray );

    performanceTrace.exitScope();
    return ccmn27si;
  }

  /**
   * Populate CCMN86SI object from context, It updates the name of the case/stage in a case. The server handles the
   * logic for updating the case/stage names or just a stage name.
   *
   * @param context Contains the session, state, and request objects
   * @return ccmn86si
   */
  private CCMN86SI populateCCMN86SI_Update(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN86SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    UserProfile user = UserProfileHelper.getUserProfile(context);

    SzNmCase_ARRAY nameArray = new SzNmCase_ARRAY();
    // ochumd sir 22646 New name for case/stage
    String nameAndId = ContextHelper.getStringSafe(request, "selNmPersonHistFull");

    int id = 0;
    if (StringHelper.isValid(nameAndId)) {
      String name = nameAndId.substring(0, nameAndId.indexOf("|"));
      nameArray.addSzNmCase(name);
      //update case name in globalData so it will be correct when returned to Case Summary
      GlobalData.setSzNmCase(name, request);
      String tempId = nameAndId.substring(nameAndId.indexOf("|") + 1, nameAndId.length());
      if (tempId.length() > 0) {
        id = Integer.parseInt(tempId);
      }
    }

    //Old name of of case/stage
    nameArray.addSzNmCase(request.getParameter("txtNmPersonHistFull"));

    CCMN86SI ccmn86si = new CCMN86SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());

    input.setCReqFuncCd(cReqFuncCd);
    input.setBPerfInd(yes);
    input.setBDataAcsInd(yes);
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);

    ccmn86si.setArchInputStruct(input);
    ccmn86si.setUlIdCase(Integer.parseInt(state.getAttribute(IDCASE, request).toString()));
    ccmn86si.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    ccmn86si.setUlIdStage(Integer.parseInt(state.getAttribute("IDSTAGE", request).toString()));
    ccmn86si.setSzCdStage(GlobalData.getSzCdStage(request));
    ccmn86si.setSzNmCase_ARRAY(nameArray);
    ccmn86si.setUlIdNmPerson(id);

    performanceTrace.exitScope();
    return ccmn86si;
  }

  /**
   * The handler for ServiceException for CCMN86S error, this writes to the data base
   *
   * @param we      returned errors from server
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private void handleError86(ServiceException we,
                             GrndsExchangeContext context) {
    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.SQL_NOT_FOUND:
        this.setPresentationBranch(ERROR, context);
        setErrorMessage(errorCode, Case_Mnt_Page, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }

  public static final String Case_Mnt_Page = "/workload/CaseMnt/displayCaseMnt";
  public static final String ERROR = "error";
  public static final String IDCASE = "txtUlIdCase";
  public static final String IDSTAGE = "IDSTAGE";
  public static final String TRACE_TAG = "CaseMntConversation";
  public static final String cReqFuncCd = "U";
  public static final String yes = "Y";
  public static final int ulPageSizeNbr = 26;
  public static final int usPageNbr = 1;

  private Intake intake;
  private Admin admin;
}
