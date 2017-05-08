package gov.georgia.dhr.dfcs.sacwis.web.intake;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveTaskList;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

/**
 * <p/> Title: Intake Utils </p> <p/> Description: The IntakeUtils class holds methods used on both the Call Information
 * and Intake Actions conversations. Methods range from simple helper methods that compare what was retrieved with what
 * is now entered on the page to methods that copy data from output structs into input structs. </p> <p/> <p/>
 * Copyright: Copyright (c) 2002 </p>
 *
 * @author Jenn Casdorph
 * @version 1.0
 * 10/21/2008 arege   STGAP00010527    Changed if(county == "") to if(county.equals("") to resolve 
 *                                     StringTooShortException 
 * 01/09/2009 arege   STGAP00012406    Added Null check to resolve Null Pointer Error.
 * 06/18/2010 bgehlot   SMS# 57787 Changed the duplicate message.
 * 06/21/2010 bgehlot   SMS# 57650: Set the stateSSN to requestSSN if the action is update so that the Duplicate person 
 *                      message does not come up when page is saved.
 * 08/11/2010 wjcochran SMS# 50402: Added a check for the variable 'hdnIsSetIsDirtyCalled' which will be set to 'Y'
 *                      when a person is added to the intake page or other items are changed on the page
 */
public class IntakeUtils {
  public static final String TRACE_TAG = "IntakeUtils";

  /**
   * This is a 'screen scrape' (fancy tech-boy word) to see if there is any data entered in the facility. If no data is
   * entered, we do not want to call the save service.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public static boolean hasFacilityDetailChanged(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".facilityDetailHasData()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(context);

    FacilRtrvOutRec facilRtrvOutRec = (FacilRtrvOutRec) state.getAttribute("FacilRtrvOutRec", request);
    if (facilRtrvOutRec == null) {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }
    gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct retrievedData = facilRtrvOutRec
            .getFacDetailEntStruct();
    if (retrievedData == null) {
      retrievedData = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
    }

    boolean hasFacilityChanged = false;

    String currentFacil = ContextHelper.getStringSafe(request, "txtNmIncmgFacilName");
    String currentAffil = ContextHelper.getStringSafe(request, "txtSzNmIncmgFacilAffiliated");
    String currentOperBy = ContextHelper.getStringSafe(request, "selSzCdIncFacilOperBy");
    String currentType = ContextHelper.getStringSafe(request, "selSzCdIncmgFacilType");
    String currentSuper = ContextHelper.getStringSafe(request, "txtSzNmIncmgFacilSuprtdant");
    String currentPhone = ContextHelper.getPhoneSafe(request, "txtSzNbrIncmgFacilPhone");
    String currentExt = ContextHelper.getStringSafe(request, "txtSzNbrIncmgFacilPhoneExt");
    String currentGrnds = ContextHelper.getStringSafe(request, "cbxBIndIncmgOnGrnds");
    String currentUnsuper = ContextHelper.getStringSafe(request, "cbxBIndIncmgFacilAbSupv");
    String currentUnit = ContextHelper.getStringSafe(request, "txtSzNmUnitWard");
    String currentCmnts = ContextHelper.getStringSafe(request, "txtSzTxtFacilCmnts");

    if ((!currentFacil.equals(FormattingHelper.formatString(retrievedData.getNmIncmgFacilName())))
        || (!currentAffil.equals(FormattingHelper.formatString(retrievedData.getSzNmIncmgFacilAffiliated())))
        || (!currentOperBy.equals(FormattingHelper.formatString(retrievedData.getSzCdIncFacilOperBy())))
        || (!currentType.equals(FormattingHelper.formatString(retrievedData.getSzCdIncmgFacilType())))
        || (!currentSuper.equals(FormattingHelper.formatString(retrievedData.getSzNmIncmgFacilSuprtdant())))
        || (!currentPhone.equals(FormattingHelper.formatString(retrievedData.getSzNbrIncmgFacilPhone())))
        || (!currentExt.equals(FormattingHelper.formatString(retrievedData.getSzNbrIncmgFacilPhoneExt())))
        || (!currentGrnds.equals(FormattingHelper.formatString(retrievedData.getBIndIncmgOnGrnds())))
        || (!currentUnsuper.equals(FormattingHelper.formatString(retrievedData.getBIndIncmgFacilAbSupvd())))
        || (!currentUnit.equals(FormattingHelper.formatString(retrievedData.getSzNmUnitWard())))
        || (!currentCmnts.equals(FormattingHelper.formatString(retrievedData.getSzTxtFacilCmnts())))) {
      hasFacilityChanged = true;
    }

    performanceTrace.exitScope();
    return hasFacilityChanged;
  }

  /**
   * This is a 'screen scrape' (fancy tech-boy word) to see if there is any data entered in the facility. If no data is
   * entered, we do not want to call the save service.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public static boolean hasCallEntryChanged(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".hasCallEntryChanged()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(context);
    boolean hasCallEntryChanged = false;

    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);

    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }
    CallEntrySvcStruct callEntry = callEntryRtrvOut.getCallEntrySvcStruct();
    if (callEntry == null) {
      callEntry = new CallEntrySvcStruct();
    }

    String callType = ContextHelper.getStringSafe(request, "callType");
    org.exolab.castor.types.Date incomingDate = ContextHelper.getCastorDateSafe(request, "dtDtIncomingCall");
    String incomingTime = ContextHelper.getStringSafe(request, "txtTmTmIncmgCall");

    String nonIncReqType = ContextHelper.getStringSafe(request, "selSzCdNonIncReqType");
    String splInvest = ContextHelper.getStringSafe(request, "selSzCdSplInvest");
    String splCircum = (ContextHelper.getString(request, "selSzCdSplCircum"));

    String first = ContextHelper.getStringSafe(request, "txtNmIncomingCallerFirst");
    String middle = ContextHelper.getStringSafe(request, "txtNmIncomingCallerMiddle");
    String last = ContextHelper.getStringSafe(request, "txtNmIncomingCallerLast");
    String suffix = ContextHelper.getStringSafe(request, "selCdIncomingCallerSuffix");
    String gender = ContextHelper.getStringSafe(request, "selszCdIncmgSex");
    String relInt = ContextHelper.getStringSafe(request, "selszCdIncmgCallerInt");
    String inReFirst = ContextHelper.getStringSafe(request, "txtSzNmIncmgRegardingFirst");
    String inReLast = ContextHelper.getStringSafe(request, "txtSzNmIncmgRegardingLast");
    AddressBean aapBean = AddressBean.getFromRequest("callEntryAddress", request);
    if (aapBean == null) {
      aapBean = new AddressBean();
    }
    String street1 = FormattingHelper.formatString(aapBean.getAddress1());
    String street2 = FormattingHelper.formatString(aapBean.getAddress2());
    String city = FormattingHelper.formatString(aapBean.getCity());
    String state1 = FormattingHelper.formatString(aapBean.getState());
    String county = FormattingHelper.formatString(aapBean.getCounty());
    String zip = FormattingHelper.formatString(aapBean.getZipAndSuff());
    String addressType = ContextHelper.getStringSafe(request, "selSzCdIncmgAddrType");
    String phone = ContextHelper.getStringSafe(request, "txtSzNbrIncomingCallerPhone");
    String ext = ContextHelper.getStringSafe(request, "txtSzNbrIncmgCallerExt");
    String phoneType = ContextHelper.getStringSafe(request, "selSzCdIncmgPhoneType");
    /* SMS #50402 - added a variable to retrieve a hidden variable from the Call Information
     * page that is set to Y when the javascript method setIsDirtyCalled is called from
     * the page. This method is called whenever a person is added or other items are changed
     * on the page.
     */
    String hdnIsSetDirtyCalled = ContextHelper.getStringSafe(request, "hdnIsSetIsDirtyCalled");

    // UNUSED CODE REMOVED
    
    if (!callType.equals(callEntry.getSzCdIncomingCallType()) || !incomingDate.equals(callEntry.getDtDtIncomingCall())
        || !nonIncReqType.equals(callEntry.getSzCdNonRsdntReqType())
        || !splInvest.equals(callEntry.getSzCdSpclInvstgtn()) || !incomingTime.equals(callEntry.getTmTmIncmgCall())
        || !first.equals(callEntry.getNmIncomingCallerFirst()) || !middle.equals(callEntry.getNmIncomingCallerMiddle())
        || !last.equals(callEntry.getNmIncomingCallerLast()) || !suffix.equals(callEntry.getCdIncomingCallerSuffix())
        || !gender.equals(callEntry.getSzCdIncmgSex()) || !relInt.equals(callEntry.getSzCdIncmgCallerInt())
        || !inReFirst.equals(callEntry.getSzNmIncmgRegardingFirst())
        || !inReLast.equals(callEntry.getSzNmIncmgRegardingLast())
        || !street1.equals(callEntry.getSzAddrIncmgStreetLn1()) || !street2.equals(callEntry.getSzAddrIncmgStreetLn2())
        || !city.equals(callEntry.getSzAddrIncomingCallerCity())
        || !state1.equals(callEntry.getSzCdIncomingCallerState())
        || !county.equals(callEntry.getSzCdIncomingCallerCounty()) || !zip.equals(callEntry.getSzAddrIncmgZip())
        || !addressType.equals(callEntry.getSzCdIncmgAddrType())
        || !phone.equals(callEntry.getSzNbrIncomingCallerPhone()) || !ext.equals(callEntry.getSzNbrIncmgCallerExt())
        || !phoneType.equals(callEntry.getSzCdIncmgPhoneType())
        || !splCircum.equals(callEntry.getSzCdSpclCircumstances())
        || hdnIsSetDirtyCalled.equals(ArchitectureConstants.Y)) {
      hasCallEntryChanged = true;
    }

    performanceTrace.exitScope();

    return hasCallEntryChanged;
  }

  /**
   * hasNameChanged will return true in the following instances: 1. If previousFirstName != currentFirstName 2. If
   * previousMiddleName != currentMiddleName 3. If firstNameCurrent != currentLastName 4. If a first, middle, or last
   * name is entered and the suffix has changed. (If there is no other name info entered, we do not want to save the
   * suffix even if it changed)
   *
   * @param context
   * @param personListRow
   * @return
   */
  public static boolean hasNameChanged(GrndsExchangeContext context, PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".hasNameChanged()");

    HttpServletRequest request = context.getRequest();

    boolean hasNameChanged = false;

    String previousFirstName = FormattingHelper.formatString(personListRow.getSzNmNameFirst());
    String previousMiddleName = FormattingHelper.formatString(personListRow.getSzNmNameMiddle());
    String previousLastName = FormattingHelper.formatString(personListRow.getSzNmNameLast());
    String previousSuffix = FormattingHelper.formatString(personListRow.getSzCdNameSuffix());
    String currentFirstName = ContextHelper.getStringSafe(request, "txtSzNmNameFirst");
    String currentMiddleName = ContextHelper.getStringSafe(request, "txtSzNmNameMiddle");
    String currentLastName = ContextHelper.getStringSafe(request, "txtSzNmNameLast");
    String currentSuffix = ContextHelper.getStringSafe(request, "selSzCdNameSuffix");

    boolean saveSuffix = false;

    if ((!"".equals(currentFirstName) || !"".equals(currentMiddleName) || !"".equals(currentLastName))
        && !previousSuffix.equals(currentSuffix)) {
      saveSuffix = true;
    }
    if (!(previousFirstName.equals(currentFirstName)) || !(previousMiddleName.equals(currentMiddleName))
        || !(previousLastName.equals(currentLastName)) || (saveSuffix)) {
      hasNameChanged = true;
    }

    performanceTrace.exitScope();
    return hasNameChanged;
  }

  /**
   * hasRaceEthnicityChanged will return true if any of the fields have changed. We check the count of the raceArray and
   * ethnicityArray. They will only contain values if the Race or Ethnicity has been changed.
   *
   * @param raceArray
   * @param ethArray
   * @return
   */
  public static boolean hasRaceEthnicityChanged(ROWCINT02SIG00_ARRAY raceArray, ROWCINT02SIG01_ARRAY ethArray) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".hasNameChanged()");

    boolean hasRaceEthnicityChanged = false;

    if ((raceArray.getROWCINT02SIG00Count() != 0) || (ethArray.getROWCINT02SIG01Count() != 0)) {
      hasRaceEthnicityChanged = true;
    }

    performanceTrace.exitScope();
    return hasRaceEthnicityChanged;
  }

  /**
   * hasSSNchanged will return true if the retrieved Social Security Number is different from the Social Security Number
   * currently entered on the Call Person Detail page.
   *
   * @param context
   * @param personListRow
   * @return
   */
  public static boolean hasSSNchanged(GrndsExchangeContext context, PersListRtrvStruct personListRow, String cReqFuncCd) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".hasSSNchanged()");

    HttpServletRequest request = context.getRequest();

    String stateSSN = FormattingHelper.formatSSN(personListRow.getSzNbrPersonIdNumber());
    String requestSSN = ContextHelper.getSSNSafe(request, "txtSzNbrPersonIdNumber");
    
    //57650: Set the stateSSN to requestSSN if the action is update so that the Duplicate person message does not come up
    // when page is saved.
    if(ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)){
      requestSSN = stateSSN;
    }

    boolean hasSSNchanged = (stateSSN.equals(requestSSN) == false);

    performanceTrace.exitScope();
    return hasSSNchanged;
  }

  /**
   * hasAddressChanged will return true if any of the address fields have been modified. <p/> OnLoad of the Call Person
   * Detail page, State and County default to a value. Since personListRow.getCounty() and personListRow.getState() will
   * be null for new persons, even if the user did not enter any address information when previousAddressInfo and
   * currentAddressInfo are compared they will appear different. Checking to see if the user entered an AddressType
   * ensures us that the user actually entered an address to be saved since if any Street, City, or Zip information is
   * entered an AddressType is required by the Custom Validation.
   *
   * @param context
   * @param personListRow
   * @return
   */
  public static boolean hasAddressChanged(GrndsExchangeContext context, PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".hasAddressChanged()");

    HttpServletRequest request = context.getRequest();
    AddressBean aapBean = AddressBean.getFromRequest(request);
    if (aapBean == null) {
      aapBean = new AddressBean();
    }

    boolean hasAddressChanged = false;
    // Use FormatthingHelper as a null catcher
    String previousAddress1 = FormattingHelper.formatString(personListRow.getSzAddrPersAddrStLn1());
    String previousAddress2 = FormattingHelper.formatString(personListRow.getSzAddrPersAddrStLn2());
    String previousCity = FormattingHelper.formatString(personListRow.getSzAddrCity());
    String previousState = FormattingHelper.formatString(personListRow.getSzCdAddrState());
    String previousZip = FormattingHelper.formatString(personListRow.getLAddrZip());
    String previousCounty = FormattingHelper.formatString(personListRow.getSzCdAddrCounty());
    String previousType = FormattingHelper.formatString(personListRow.getSzCdPersAddrLinkType());
    String currentType = ContextHelper.getStringSafe(request, "selSzCdPersAddrLinkType");

    if (!("".equals(currentType))
        && (!(previousAddress1.equals(aapBean.getAddress1())) || !(previousAddress2.equals(aapBean.getAddress2()))
            || !(previousCity.equals(aapBean.getCity())) || !(previousState.equals(aapBean.getState()))
            || !(previousZip.equals(aapBean.getZipAndSuff())) || !(previousCounty.equals(aapBean.getCounty())) || !(""
            .equals(previousType)))) {
      hasAddressChanged = true;
    }

    performanceTrace.exitScope();

    return hasAddressChanged;
  }

  /**
   * hasPhoneChanged will return true in the following instances: 1. if previousPhone != currentPhone 2. If previousExt
   * != currentExt 3. If previousPhoneType != currentPhoneType
   *
   * @param context
   * @param personListRow
   * @return
   */
  public static boolean hasPhoneChanged(GrndsExchangeContext context, PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".hasPhoneChanged()");

    HttpServletRequest request = context.getRequest();

    boolean hasPhoneChanged = false;

    String previousPhone = FormattingHelper.formatString(personListRow.getLNbrPhone());
    String previousExt = FormattingHelper.formatString(personListRow.getLNbrPhoneExtension());
    String previousPhoneType = FormattingHelper.formatString(personListRow.getSzCdPhoneType());
    String currentPhone = ContextHelper.getPhoneSafe(request, "txtLBNbrPhone");
    String currentExt = ContextHelper.getStringSafe(request, "txtLNbrPhoneExtension");
    String currentPhoneType = ContextHelper.getPhoneSafe(request, "selSzCdPhoneType");

    if (!(previousPhone.equals(currentPhone)) || !(previousExt.equals(currentExt))
        || !(previousPhoneType.equals(currentPhoneType))) {
      hasPhoneChanged = true;
    }

    performanceTrace.exitScope();
    return hasPhoneChanged;
  }

  /**
   * This helper method copies the CallEntrySvcStruct output object of the retrieve service to the CallEntrySvcStruct
   * input object for the save.
   *
   * @param oldRow CallEntrySvcStruct
   * @throws MarshalException
   * @throws ValidationException
   */
  public static gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct copyCallEntrySvcStructOutToIn(
          gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct oldRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "copyCallEntrySvcStructOutToIn()");

    gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct newRow =
            new gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct();

    newRow.setCdIncmgStatus(oldRow.getCdIncmgStatus());
    newRow.setCdIncomingCallerSuffix(oldRow.getCdIncomingCallerSuffix());
    newRow.setCdIncomingProgramType(oldRow.getCdIncomingProgramType());
    newRow.setDtDtIncomingCall(oldRow.getDtDtIncomingCall());
    newRow.setDtIncomingCallDisposed(oldRow.getDtIncomingCallDisposed());
    newRow.setLNbrIncWkrExt(oldRow.getLNbrIncWkrExt());
    newRow.setLNbrIncWkrPhone(oldRow.getLNbrIncWkrPhone());
    newRow.setNmIncomingCallerFirst(oldRow.getNmIncomingCallerFirst());
    newRow.setNmIncomingCallerLast(oldRow.getNmIncomingCallerLast());
    newRow.setNmIncomingCallerMiddle(oldRow.getNmIncomingCallerMiddle());
    newRow.setSzAddrIncWkrCity(oldRow.getSzAddrIncWkrCity());
    newRow.setSzAddrIncmgStreetLn1(oldRow.getSzAddrIncmgStreetLn1());
    newRow.setSzAddrIncmgStreetLn2(oldRow.getSzAddrIncmgStreetLn2());
    newRow.setSzAddrIncmgZip(oldRow.getSzAddrIncmgZip());
    newRow.setSzAddrIncomingCallerCity(oldRow.getSzAddrIncomingCallerCity());
    newRow.setSzCdIncmgAddrType(oldRow.getSzCdIncmgAddrType());
    newRow.setSzCdIncmgAllegType(oldRow.getSzCdIncmgAllegType());
    newRow.setSzCdIncmgCallerInt(oldRow.getSzCdIncmgCallerInt());
    newRow.setSzCdIncmgPhoneType(oldRow.getSzCdIncmgPhoneType());
    newRow.setSzCdIncmgRegion(oldRow.getSzCdIncmgRegion());
    newRow.setSzCdIncmgSex(oldRow.getSzCdIncmgSex());
    newRow.setSzCdIncomingCallType(oldRow.getSzCdIncomingCallType());
    newRow.setSzCdIncomingCallerCounty(oldRow.getSzCdIncomingCallerCounty());
    newRow.setSzCdIncomingCallerState(oldRow.getSzCdIncomingCallerState());
    newRow.setSzCdIncomingDisposition(oldRow.getSzCdIncomingDisposition());
    newRow.setSzCdInfoAndRefrl(oldRow.getSzCdInfoAndRefrl());
    newRow.setSzCdSpclReq(oldRow.getSzCdSpclReq());
    newRow.setSzCdStage(oldRow.getSzCdStage());
    newRow.setSzCdStageCnty(oldRow.getSzCdStageCnty());
    newRow.setSzCdStageProgram(oldRow.getSzCdStageProgram());
    newRow.setSzCdStageReasonClosed(oldRow.getSzCdStageReasonClosed());
    newRow.setSzCdStageRegion(oldRow.getSzCdStageRegion());
    newRow.setSzCdStageType(oldRow.getSzCdStageType());
    newRow.setSzNbrIncmgCallerExt(oldRow.getSzNbrIncmgCallerExt());
    newRow.setSzNbrIncmgUnit(oldRow.getSzNbrIncmgUnit());
    newRow.setSzNbrIncomingCallerPhone(oldRow.getSzNbrIncomingCallerPhone());
    newRow.setSzNmIncWkrName(oldRow.getSzNmIncWkrName());
    newRow.setSzCdIncomingWorkerCounty(oldRow.getSzCdIncomingWorkerCounty());
    newRow.setSzCdIncmgWorkerRegion(oldRow.getSzCdIncmgWorkerRegion());
    newRow.setSzNmIncmgRegardingFirst(oldRow.getSzNmIncmgRegardingFirst());
    newRow.setSzNmIncmgRegardingLast(oldRow.getSzNmIncmgRegardingLast());
    newRow.setSzNmJurisdiction(oldRow.getSzNmJurisdiction());
    newRow.setSzNmStage(oldRow.getSzNmStage());
    newRow.setSzSysCdWinMode(oldRow.getSzSysCdWinMode()); // TODO?
    newRow.setTmSysTmCallDisp(oldRow.getTmSysTmCallDisp());
    newRow.setTmTmIncmgCall(oldRow.getTmTmIncmgCall());
    newRow.setTsIncmgCallDisp(oldRow.getTsIncmgCallDisp());
    newRow.setSzCdNonRsdntReqType(oldRow.getSzCdNonRsdntReqType());
    newRow.setSzCdSpclInvstgtn(oldRow.getSzCdSpclInvstgtn());
    newRow.setCIndCnfidntltyExplnd(oldRow.getCIndCnfidntltyExplnd());
    newRow.setDtCnfidntltyExplntn(oldRow.getDtCnfidntltyExplntn());
    newRow.setUlIdAllegation(oldRow.getUlIdAllegation());
    newRow.setUlIdCase(oldRow.getUlIdCase());
    newRow.setUlIdEvent(oldRow.getUlIdEvent());
    newRow.setUlIdPerson(oldRow.getUlIdPerson());
    newRow.setUlIdResource(oldRow.getUlIdResource());
    newRow.setUlIdSituation(oldRow.getUlIdSituation());
    newRow.setUlIdStage(oldRow.getUlIdStage());
    newRow.setUlIdUnit(oldRow.getUlIdUnit());
    newRow.setSzCdSpclCircumstances(oldRow.getSzCdSpclCircumstances());
    newRow.setSzCdStageClassification(oldRow.getSzCdStageClassification());

    performanceTrace.exitScope();
    return newRow;
  }

  /**
   * This helper method copies the FacDetailEntStruct output object of the retrieve service to the FacDetailEntStruct
   * input object for the save.
   *
   * @param oldRow FacDetailEntStruct
   * @throws MarshalException
   * @throws ValidationException
   */
  public static gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct copyFacDetailEntStructOutToIn(
          gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct oldRow)
          throws MarshalException, ValidationException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "copyFacDetailEntStructOutToIn()");

    gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct newRow =
            new gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct();

    newRow.setBIndIncmgFacilAbSupvd(oldRow.getBIndIncmgFacilAbSupvd());
    newRow.setBIndIncmgFacilSearch(oldRow.getBIndIncmgFacilSearch());
    newRow.setBIndIncmgOnGrnds(oldRow.getBIndIncmgOnGrnds());
    newRow.setNmIncmgFacilName(oldRow.getNmIncmgFacilName());
    newRow.setSzAddrIncmgFacilCity(oldRow.getSzAddrIncmgFacilCity());
    newRow.setSzAddrIncmgFacilStLn1(oldRow.getSzAddrIncmgFacilStLn1());
    newRow.setSzAddrIncmgFacilStLn2(oldRow.getSzAddrIncmgFacilStLn2());
    newRow.setSzAddrIncmgFacilZip(oldRow.getSzAddrIncmgFacilZip());
    newRow.setSzCdIncFacilOperBy(oldRow.getSzCdIncFacilOperBy());
    newRow.setSzCdIncmgFacilCnty(oldRow.getSzCdIncmgFacilCnty());
    newRow.setSzCdIncmgFacilState(oldRow.getSzCdIncmgFacilState());
    newRow.setSzCdIncmgFacilState(oldRow.getSzCdIncmgFacilState());
    newRow.setSzNbrIncmgFacilPhone(oldRow.getSzNbrIncmgFacilPhone());
    newRow.setSzNbrIncmgFacilPhoneExt(oldRow.getSzNbrIncmgFacilPhoneExt());
    newRow.setSzNmIncmgFacilAffiliated(oldRow.getSzNmIncmgFacilAffiliated());
    newRow.setSzNmIncmgFacilSuprtdant(oldRow.getSzNmIncmgFacilSuprtdant());
    newRow.setSzNmUnitWard(oldRow.getSzNmUnitWard());
    newRow.setSzTxtFacilCmnts(oldRow.getSzTxtFacilCmnts());
    newRow.setUlIdResource(oldRow.getUlIdResource());
    newRow.setUlIdStage(oldRow.getUlIdStage());

    performanceTrace.exitScope();
    return newRow;
  }

  /**
   * This submethod determines whether any address information has been entered in the include address submodule.
   *
   * @return boolean
   */
  public static boolean addressDataExists(AddressBean aapBean) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".addressDataExists()");

    boolean addressDataExists = false;

    // Note: Since the state defaults to "Texas" we do not want to check it if that is the only thing
    // entered.
    if ((StringHelper.isValid(aapBean.getAddress1())) || (StringHelper.isValid(aapBean.getAddress2()))
        || (StringHelper.isValid(aapBean.getCity())) || (StringHelper.isValid(aapBean.getCounty()))
        || (StringHelper.isValid(aapBean.getZipAndSuff()))) {
      addressDataExists = true;
    }

    performanceTrace.exitScope();
    return addressDataExists;
  }

  /**
   * <p/> This submethod will choose the country that gets posted to the STAGE and CASE tables. This is the county that
   * will be passsed to the Assignment dialog. </p>
   *
   * @param context              The <code>GrndeExchangeContext<code> object.
   * @param classification
   * @param disposition
   * @param facilityCounty
   * @param incomingCallerCounty
   * @param personListArray
   * @return
   */
  public static String chooseCountyForAssignment(GrndsExchangeContext context, String classification,
                                                 String disposition, String facilityCounty,
                                                 String incomingCallerCounty,
                                                 PersListRtrvStruct_ARRAY personListArray) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".chooseCountyForAssignment()");

    classification = FormattingHelper.formatString(classification);
    disposition = FormattingHelper.formatString(disposition);
    facilityCounty = FormattingHelper.formatString(facilityCounty);
    incomingCallerCounty = FormattingHelper.formatString(incomingCallerCounty);

    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }

    String county = "";
    String specialReq = "";
    String infoRefrl = "";

    Enumeration<PersListRtrvStruct> enumeration;
    boolean personFound = false;
    if (!"".equals(disposition)
        && (disposition.startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX) || disposition
            .startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX))) {
      specialReq = disposition;
    } else if (!"".equals(disposition)) {
      infoRefrl = disposition;
    }
    // For a classification of CPS or if an intake is a case related special request
    // the county for assignment will default to the county of the primary caretaker.
    if (classification.startsWith(IntakeConstants.CCLASS_PREFIX_CPS)
        || specialReq.startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX)
        || classification.startsWith(IntakeConstants.CCLASS_PREFIX_ADO)
        || classification.startsWith(IntakeConstants.CCLASS_PREFIX_PAD)
        || classification.startsWith(IntakeConstants.CCLASS_PREFIX_FSC)
        || classification.startsWith(IntakeConstants.CCLASS_PREFIX_RDV)) {
      enumeration = personListArray.enumeratePersListRtrvStruct();
      PersListRtrvStruct personRow = new PersListRtrvStruct();
      while (enumeration.hasMoreElements()) {
        personRow = (PersListRtrvStruct) enumeration.nextElement();
        if (CodesTables.CRELVICT_PK.equals(personRow.getSzCdStagePersRelInt())) {
          personFound = true;
          break;
        }
      }
      if (personFound) {
        county = personRow.getSzCdAddrCounty();
      }
    }

    // For a classification of APS FAC and licensing the county will default to
    // that of the Facility.
    else if (classification.equals(CodesTables.CCLASS_AFC) || classification.equals(CodesTables.CCLASS_LCC)
             || classification.equals(CodesTables.CCLASS_LRC)) {
      county = facilityCounty;
    }
    // For I&R and non-case related special request the county will default
    // to that of the reporter.
    else if ((StringHelper.isValid(specialReq) && !specialReq.startsWith(IntakeConstants.CCLASS_PREFIX_CPS))
             || (StringHelper.isValid(infoRefrl))) {
      county = incomingCallerCounty;
    }
    //SIR STGAP00003044 
    // This is a catch-all. If for some reason the intake slips through the above logic,
    // we will send XXX for the county not found.
    else {
      county = CodesTables.CCNTYREG_XXX;
    }
    // SIR STGAP00003049 If No PK has been found yet we send XXX for County not found
    // STGAP00010527 Changed if(county == "") to if(county.equals("")
    // STGAP00012406 Added county == null check to resolve NPE.
    if (county == null || StringHelper.EMPTY_STRING.equals(county)) {
      county = CodesTables.CCNTYREG_XXX;
    }
    performanceTrace.exitScope();
    return county;
  }

  /**
   * This method should be called when any "Save and ..." methods are called, as well as when a new intake has been
   * created. It will clear any asyn person search out of the session.
   *
   * @param context
   */
  public static void clearAsynchInfoFromSession(GrndsExchangeContext context) {
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(context);
    Iterator<String> attributeNameIt = state.getContextParameterNames(context.getRequest());

    while (attributeNameIt.hasNext()) {
      String attributeName = attributeNameIt.next();
      if (attributeName.startsWith(IntakeConstants.SEARCH_CRITERIA)
          || attributeName.startsWith(IntakeConstants.SEARCH_RESULTS)
          || attributeName.startsWith(IntakeConstants.SEARCH_PERFORMED)
          || attributeName.startsWith(IntakeConstants.GENDER_SPECIFIED_BY_USER)) {
        attributeNameIt.remove();
      }
    }
  }

  /**
   * This submethod is used by both the IntakeActions and CallInformation conversations. It is used to update the
   * Workload and Approval Status when background saves are performed. <p/> It will first retrieve all the data from the
   * database necessary to populate the CINT12S Input Object. Since the cint12s service updates the workload and also
   * updates the INCOMING_DETAIL table, it is sometimes necessary to call the service when we are not actually saving
   * any new information. <p/> This submethod is called from the Call Information conversation when the user enters an
   * Intake that has been submitted for approval and modifies the Call Person List. Upon Save/Delete of the Call Person
   * Detail page, the cint12s service is called to invalidate the pending approval. Note that this submethod is only
   * called if the user is not the approver. <p/> This submethod is called from the Intake Actions conversation when the
   * user enters an Intake that has been submitted for approval and modifies anything. If the user is the approver, this
   * service does not change the approval status, it simply updates the workload with any changes that might have been
   * made to the Call Decision portion of the page. If the user is NOT the approver, it will invalidate the pending
   * approval and also update the workload.
   *
   * @param context
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   * @throws MarshalException
   * @throws ValidationException
   */
  public static void callCINT12SUpdateWorkload(GrndsExchangeContext context, Intake inake1) throws ServiceException,
                                                                                                   MarshalException,
                                                                                                   ValidationException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".callCINT12SUpdateWorkload()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(context);

    CallEntryRtrvOut callEntryRtrvOut = PopulateDataBean.callCINT25S(context, inake1);

    // If we are in approval mode, we have to pass in save and submit to the cint12s
    // service so the pending approval is not invalidated. We have to do this before
    // we call the PopulateCallEntryAUDInRec.populate() method since that method cases
    // on cReqFuncCd.
    String cReqFuncCd = ServiceConstants.REQ_FUNC_CD_SAVE;
    if (GlobalData.isApprovalMode(request)) {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT;
    }
    gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec callEntryAUDInRec =
            PopulateCallEntryAUDInRec.populate(context, callEntryRtrvOut, cReqFuncCd);

    // All this approval mode stuff is a hack. The CAPS services were never meant to
    // work like this. Every single time we save IntakeActions in approval mode,
    // we have to recalculate the county for asssignment. This ensures that the
    // county displays correctly on the Workload.
    if (GlobalData.isApprovalMode(request)) {
      gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct callEntrySvcStruct =
              callEntryAUDInRec.getCallEntrySvcStruct();
      gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD callDcsnAUD = callEntryRtrvOut.getCallDcsnAUD();
      if (callDcsnAUD == null) {
        callDcsnAUD = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD();
      }
      String facilityCounty = (String) state.getAttribute("facilityCounty", request);
      PersListRtrvStruct_ARRAY personListArray = null;
      try {
        Date callDisposedDt = callEntrySvcStruct.getTsIncmgCallDisp();
        String incomingStatus = callEntrySvcStruct.getCdIncmgStatus();

        gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec persListOutRec =
                PopulateDataBean.callCINT26S(context, incomingStatus, callDisposedDt, inake1);

        personListArray = persListOutRec.getPersListRtrvStruct_ARRAY();
      } catch (ServiceException we) {
        switch (we.getErrorCode()) {
          case Messages.SQL_NOT_FOUND:
          case Messages.MSG_NO_ROWS_RETURNED:
            break;
          default:
            throw we;
        }
      }

      String county = IntakeUtils.chooseCountyForAssignment(context, callDcsnAUD.getSzCdStageClassification(),
                                                            callEntrySvcStruct.getSzCdIncomingDisposition(),
                                                            facilityCounty,
                                                            callEntrySvcStruct.getSzCdIncomingCallerCounty(),
                                                            personListArray);

      gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct callEntrySvcStruct2 =
              callEntryAUDInRec.getCallEntrySvcStruct();
      callEntrySvcStruct.setSzCdStageCnty(county);
      try {
        String region = FormattingHelper.convertRegionCode(Lookup.simpleDecodeSafe("CCNTYREG", county));
        callEntrySvcStruct.setSzCdStageRegion(region);
      }catch(DataFormatException we) {
        
      }
      callEntryAUDInRec.setCallEntrySvcStruct(callEntrySvcStruct2);
    }
    // END POPULATE COUNTY
    request.setAttribute("callEntryAUDInRec", callEntryAUDInRec);
    // WtcHelper.callService("CINT12S", callEntryAUDInRec);
    inake1.saveCallEntry(callEntryAUDInRec);
    performanceTrace.exitScope();
  }

  /** This submethod gets the id of the prior stage for a given stage (and ensures it's an INTAKE stage)
   *  if the prior stage is a DIV stage (in the case of progressing from DIV -> INV) it gets the id of 
   *  the DIV's prior stage (and ensures it's an INTAKE stage) */
  public static int getPriorIntakeStageId(GrndsExchangeContext context, Common common)
          throws ServiceException, MarshalException, ValidationException {
    CCMN50SO ccmn50so = callCCMN50S(context, common);
    int priorStageId = ccmn50so.getUlIdPriorStage();

    CaseUtility.Stage stage = CaseUtility.getStage(priorStageId);
    if (stage.getCdStage().equals(CodesTables.CSTAGES_INT)) {
      return priorStageId;
    } else if (CodesTables.CSTAGES_DIV.equals(stage.getCdStage())){
      CaseUtility.Stage priorStage = CaseUtility.getPriorStage(priorStageId);
      if (CodesTables.CSTAGES_INT.equals(priorStage.getCdStage())) {
        return priorStage.getIdStage();
      }
    }
    throw new ServiceException(Messages.MSG_INV_NO_EXISTS);
  }

  /** Find prior Stage Id */
  protected static CCMN50SO callCCMN50S(GrndsExchangeContext context, RetrieveTaskList retrieveTaskList)
          throws ServiceException, MarshalException, ValidationException {
    HttpServletRequest request = context.getRequest();

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setSzUserId((UserProfileHelper.getUserProfile(request).getUserLogonID()));

    CCMN50SI ccmn50si = new CCMN50SI();

    int stageId = (GlobalData.getUlIdStage(request));
    ccmn50si.setUlIdStage(stageId);
    ccmn50si.setCIndTaskRtrvPriorStage("1");

    try {
      return retrieveTaskList.findTaskListEvents(ccmn50si);
    } catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      if ((errorCode == Messages.SQL_NOT_FOUND) || ((errorCode == 0) && (e.getErrorCode() == Messages.SQL_NOT_FOUND))) {
        // mcclaim added 06/19/2003
        throw new ServiceException(Messages.MSG_INV_NO_EXISTS, e);
      }
      throw e;
    }
  }

  /**
   * This helper method will sort the Call Person List and put the reporters FIRST.
   *
   * @param originalPersonList
   * @return
   */
  public static PersListRtrvStruct_ARRAY sortCallPersonList(PersListRtrvStruct_ARRAY originalPersonList) {
    PersListRtrvStruct_ARRAY sortedList = new PersListRtrvStruct_ARRAY();
    PersListRtrvStruct person;
    Enumeration<PersListRtrvStruct> e = originalPersonList.enumeratePersListRtrvStruct();
    while (e.hasMoreElements()) {
      person = (PersListRtrvStruct) e.nextElement();
      if (ArchitectureConstants.Y.equals(person.getBIndStagePersReporter())) {
        sortedList.addPersListRtrvStruct(person);
      }
    }

    e = originalPersonList.enumeratePersListRtrvStruct();
    while (e.hasMoreElements()) {
      person = (PersListRtrvStruct) e.nextElement();
      if (ArchitectureConstants.N.equals(person.getBIndStagePersReporter())) {
        sortedList.addPersListRtrvStruct(person);
      }
    }
    return sortedList;
  }
  
  /**
   * SMS 57787 hasDOBChanged will return true if DOB has changed
   *
   * @param context
   * @param personListRow
   * @return
   */
  public static boolean hasDOBChanged(GrndsExchangeContext context, PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".hasDOBChanged()");

    HttpServletRequest request = context.getRequest();

    boolean hasDOBChanged = false;
    Date previousDob = DateHelper.toJavaDate(personListRow.getDtDtPersonBirth());
    Date currentDob = ContextHelper.getJavaDateSafe(request, "txtDateDtPersonBirth");

    if (!DateHelper.isEqual(previousDob, currentDob)) {
      hasDOBChanged = true;
    }

    performanceTrace.exitScope();
    return hasDOBChanged;
  }

}
