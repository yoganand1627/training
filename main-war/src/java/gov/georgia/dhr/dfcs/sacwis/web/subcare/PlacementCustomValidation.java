package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cplcmtac;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FadHomeRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
* This class provides custom validation for the Placement Information conversation
 * 
 * Change History:
 *   Date        User            Description
 *   ----------  --------------  --------------------------------------------------
 *   12/10/2008  alwilliams      STGAP00010671: Added custom validation for Boarding County 
 *   01/09/2009  mxpatel         STGAP00010685: Added custom validations for conditional fields in "placement Checklist" section.
 *   02/11/2009  mxpatel         STGAP00012392: Added custom validations for new placement type - "Other Adoptive Home"
 *   04/22/09    cwells          STGAP00009847: Removing references to AFCAR widgits.  Since those sections
 *                               Are being removed from the page.  
 *   11/25/2009  bgehlot         SMS#41275 MR-057 - Added validation that date agreement signed for APPLA is required when Placement is LTFC and that date cannot be
 *                               prior to the placement start date.   
 *   01/22/2009  hjbaptiste      SMS#44090 MR-057 - Added validation that date agreement signed for APPLA is not a future date
 *   12/13/2010  schoi           SMS #81140: MR-074 Added validation for AFCARS Conversion from Group Home to CCI
 *   12/19/2010  schoi           SMS #81140: MR-074 Added separated conditions both for ADO and PAD when rbIndPlcmtChPlacedFr is set
 *   12/19/2010  schoi           SMS #81140: MR-074 Added comment for existing conditions where end-dated Group Home is included
 *   03/21/2011  hnguyen         SMS#97850: MR-075 Added new validation for placement hold and home record check verification
 *                               and removed unused imports.
 *   03/22/2011  hnguyen         SMS#97850: MR-075 Updated new validation criteria
 *   09/22/2011  charden         STGAP00017058 - adding new validations
 */
public class PlacementCustomValidation extends FormValidation {
  public static final String CONCURRENT = CodesTables.CTMPLTYP_COR;

  public static final String RESPITE_DAY = CodesTables.CTMPLTYP_RED;

  public static final String RESPITE_NIGHT = CodesTables.CTMPLTYP_REN;

  public static final String ADOPTIVE_HOME = CodesTables.CPLMNTYP_ADH;

  public static final String ICPC_Adoptive = CodesTables.CPLMNTYP_ICA;

  public static final String PARENT = CodesTables.CPLMNTYP_PRN;
  
  public static final String TRACE_TAG = "PlacementCustomValidation";

  public static final String TYPE_PARENT = CodesTables.CPLMNTYP_PRN;

  public static final String TYPE_RELATIVE_PAID = CodesTables.CPLMNTYP_REP;

  public static final String TYPE_NON_RELATIVE_PAID = CodesTables.CPLMNTYP_NRP;

  public static final String TYPE_RELATIVE_UNPAID = CodesTables.CPLMNTYP_REU;

  public static final String TYPE_RELATIVE_FOSTER_HOME = CodesTables.CPLMNTYP_RFH;

  public static final String TYPE_DFCS_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_DFH;

  public static final String TYPE_CPA_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_CFH;

  public static final String TYPE_CCI_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_IFH;

  public static final String TYPE_ADOPTIVE_HOME = CodesTables.CPLMNTYP_ADH;

  public static final String TYPE_EMERGENCY_SHELTER = CodesTables.CPLMNTYP_EMS;

  public static final String TYPE_GROUP_HOME = CodesTables.CPLMNTYP_GRH;

  public static final String TYPE_CHILD_CARE_INSTITUTION = CodesTables.CPLMNTYP_CCI;

  public static final String TYPE_SPECIALIZED_FOSTER_HOME = CodesTables.CPLMNTYP_SFH;

  public static final String TYPE_ILP_AFTERCARE = CodesTables.CPLMNTYP_LAF;

  public static final String TYPE_ICPC_FOSTER = CodesTables.CPLMNTYP_ICF;

  public static final String TYPE_ICPC_ADOPTIVE = CodesTables.CPLMNTYP_ICA;

  public static final String TYPE_ICPC_RELATIVE = CodesTables.CPLMNTYP_ICR;

  public static final String TYPE_HOSPITAL = CodesTables.CPLMNTYP_HOS;

  public static final String TYPE_RUNAWAY = CodesTables.CPLMNTYP_RNA;

  public static final String TYPE_YDC = CodesTables.CPLMNTYP_YDC;

  public static final String TYPE_OTHER_ADOPTIVE_HOME = CodesTables.CPLMNTYP_OTA;//mxpatel 12392
  
  public static final String TYPE_OTHER_RESOURCE = CodesTables.CPLMNTYP_OTR;

  public static final String TYPE_OTHER_PERSON = CodesTables.CPLMNTYP_OTP;

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    GrndsExchangeContext context = getGrndsExchangeContext();
    
    // STGAP00017058 - bypass validation when placement log link is clicked
    String hdnHrefValidationBypass = ContextHelper.getStringSafe(request, "hdnHrefValidationBypass");
    if(ArchitectureConstants.Y.equals(hdnHrefValidationBypass)){
      return true;
    }
    // End STGAP00017058
    
    boolean isValid = true;
    String cdStage = GlobalData.getSzCdStage(request);
    String eventStatus = ContextHelper.getStringSafe(request, "hdnEventStatus");
    String szCdActAtt = ContextHelper.getStringSafe(request, "selSzCdActAtt");
    String selSzCdPlcmtType = ContextHelper.getStringSafe(request, "selSzCdPlcmtType");
    String szCdTempPlcmtType = ContextHelper.getStringSafe(request, "szCdTempPlcmtType");
    String cbxIndTempReplacement = ContextHelper.getStringSafe(request, "cbxIndTempReplacement");
    String szTxtTempPlcmtCmnts = ContextHelper.getStringSafe(request, "szTxtTempPlcmtCmnts");
    String cbxIndWaiverRequired = ContextHelper.getStringSafe(request, "cbxIndWaiverRequired");
    String rbIndPlcmtSafe = ContextHelper.getStringSafe(request, "rbIndPlcmtSafe");
    String rbIndPlcmtLeastRestrict = ContextHelper.getStringSafe(request, "rbIndPlcmtLeastRestrict");
    String rbIndPlcmtFamilyLike = ContextHelper.getStringSafe(request, "rbIndPlcmtFamilyLike");
    String rbIndPlcmtAppropriate = ContextHelper.getStringSafe(request, "rbIndPlcmtAppropriate");
    String rbIndPlcmtCloseProxPar = ContextHelper.getStringSafe(request, "rbIndPlcmtCloseProxPar");
    String rbIndPlcmtCloseProxSchool = ContextHelper.getStringSafe(request, "rbIndPlcmtCloseProxSchool");
    String rbIndConsistent = ContextHelper.getStringSafe(request, "rbIndConsistent");
    String szTxtNoExplainCheckList = ContextHelper.getStringSafe(request, "szTxtNoExplainCheckList");
    String szCdChildTransitionCmnts = ContextHelper.getStringSafe(request, "szCdChildTransitionCmnts");
    int dspUlWaiverId = ContextHelper.getIntSafe(request, "dspUlWaiverId");
    String cbxIndTrialHomeVisit = ContextHelper.getStringSafe(request, "cbxIndTrialHomeVisit");
    String rbIndCaseHome = ContextHelper.getStringSafe(request, "rbIndCaseHome");
    String rbIndExpTrauma = ContextHelper.getStringSafe(request, "rbIndExpTrauma");
    String szTxtYesExpTrauma = ContextHelper.getStringSafe(request, "szTxtYesExpTrauma");
    String rbIndStaySiblings = ContextHelper.getStringSafe(request, "rbIndStaySiblings");
    int nbrSibinCare = ContextHelper.getIntSafe(request, "nbrSibinCare");
    int nbrSibPlaced = ContextHelper.getIntSafe(request, "nbrSibPlaced");
    String szCdSibRsn = ContextHelper.getStringSafe(request, "selSzCdSibRsn");
    String szCdNoReasonCmnts = ContextHelper.getStringSafe(request, "szCdNoReasonCmnts");
    String rbIndPlcmtMatchCCFA = ContextHelper.getStringSafe(request, "rbIndPlcmtMatchCCFA");
    String szCdCCFARsn = ContextHelper.getStringSafe(request, "selSzCdCCFARsn");
    String szCdPlcmtMatchCCFAReasonCmnts = ContextHelper.getStringSafe(request, "szCdPlcmtMatchCCFAReasonCmnts");
    String selSzCdPlcmtRemovalRsn = ContextHelper.getStringSafe(request, "selSzCdPlcmtRemovalRsn");
    int idFacility = ContextHelper.getIntSafe(request, "dspUlIdRsrcAgencyPaid");
    int idResource = ContextHelper.getIntSafe(request, "dspUlIdRsrcFacilPaid");
    String nmFacility = ContextHelper.getStringSafe(request, "txtSzNmPlcmtFacilPaid");
    String personName = ContextHelper.getStringSafe(request, "dspSzNmPlcmtPersonFull");
    org.exolab.castor.types.Date dtPlaceStart = ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtStart");
    org.exolab.castor.types.Date dtDateLastDischarged = ContextHelper
                                                                     .getCastorDateSafe(request, "dtDateLastDischarged");
    org.exolab.castor.types.Date dtPermReportDueDate = ContextHelper.getCastorDateSafe(request, "dtPermReportDueDate");
    org.exolab.castor.types.Date dtCrtBeginDate = ContextHelper.getCastorDateSafe(request, "dtCrtBeginDate");
    org.exolab.castor.types.Date dtCrtEndDate = ContextHelper.getCastorDateSafe(request, "dtCrtEndDate");
    org.exolab.castor.types.Date txtDtPsychInfo = ContextHelper.getCastorDateSafe(request, "txtDtPsychInfo");
    org.exolab.castor.types.Date txtDtCasePsychInfo = ContextHelper.getCastorDateSafe(request, "txtDtCasePsychInfo");
    org.exolab.castor.types.Date txtDtMedInfo = ContextHelper.getCastorDateSafe(request, "txtDtMedInfo");
    org.exolab.castor.types.Date txtDtCaseMedInfo = ContextHelper.getCastorDateSafe(request, "txtDtCaseMedInfo");
    org.exolab.castor.types.Date txtDtEduInfo = ContextHelper.getCastorDateSafe(request, "txtDtEduInfo");
    org.exolab.castor.types.Date txtDtCaseEduInfo = ContextHelper.getCastorDateSafe(request, "txtDtCaseEduInfo");
    org.exolab.castor.types.Date txtDtDtPlcmtPreplaceVisit = ContextHelper
                                                                          .getCastorDateSafe(request,
                                                                                             "txtDtDtPlcmtPreplaceVisit");
    org.exolab.castor.types.Date txtDtDtPlcmtParentsNotif = ContextHelper.getCastorDateSafe(request,
                                                                                            "txtDtDtPlcmtParentsNotif");
    org.exolab.castor.types.Date txtDtDtPlcmtChildDiscuss = ContextHelper.getCastorDateSafe(request,
                                                                                            "txtDtDtPlcmtChildDiscuss");
    org.exolab.castor.types.Date txtDtDtPlcmtCaregvrDiscuss = ContextHelper
                                                                           .getCastorDateSafe(request,
                                                                                              "txtDtDtPlcmtCaregvrDiscuss");
    org.exolab.castor.types.Date dtPlaceEnd = ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtEnd");
    String tmPlcmtStart = ContextHelper.getTimeSafe(request, "txtDtTmPlcmtStart");
    String tmPlcmtEnd = ContextHelper.getTimeSafe(request, "txtDtTmPlcmtEnd");
    Date dtPlaceStart1 = ContextHelper.getJavaDateSafe(request, "txtDtDtPlcmtStart");
    Date dtPlaceEnd1 = ContextHelper.getJavaDateSafe(request, "txtDtDtPlcmtEnd");
    String txtaSzTxtPlcmtDiscussion = ContextHelper.getStringSafe(request, "txtaSzTxtPlcmtDiscussion");
    String txtSzTxtPlcmtDocuments = ContextHelper.getStringSafe(request, "txtSzTxtPlcmtDocuments");
    String cbxAdoPlaceInfo1 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo1");
    String cbxAdoPlaceInfo2 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo2");
    String cbxAdoPlaceInfo3 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo3");
    String cbxAdoPlaceInfo4 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo4");

    // SMS #81140: MR-074 If ADO, use hidden variables for enabling automation on the Placement page
    String rbIndPlcmtChPlacedFr = "";
    String rbIndPlcmtChPlacedBy = "";
    
    if (PlacementConversation.POST_ADOPT.equals(cdStage)) {
      rbIndPlcmtChPlacedFr = ContextHelper.getStringSafe(request, "rbIndPlcmtChPlacedFr");
      rbIndPlcmtChPlacedBy = ContextHelper.getStringSafe(request, "rbIndPlcmtChPlacedBy");
    } else if (PlacementConversation.ADOPT.equals(cdStage)) {
      rbIndPlcmtChPlacedFr = ContextHelper.getStringSafe(request, "hdnRbIndPlcmtChPlacedFr");
      rbIndPlcmtChPlacedBy = ContextHelper.getStringSafe(request, "hdnRbIndPlcmtChPlacedBy");
    }
    
    String rbIndSuppSupervision = ContextHelper.getStringSafe(request, "rbIndSuppSupervision");
    String szCdSuppSupervisionCmnts = ContextHelper.getStringSafe(request, "szCdSuppSupervisionCmnts");
    String dspSzNmPlcmtAgency = ContextHelper.getStringSafe(request, "dspSzNmPlcmtAgency");
    int dspUlIdRsrcAgency = ContextHelper.getIntSafe(request, "dspUlIdRsrcAgency");
    //MR-057 APPLA Changes
    Date dtAgreementSigned = ContextHelper.getJavaDateSafe(request, "dtAgreementSigned");
    String rbIndLTFCPlacement = ContextHelper.getStringSafe(request, "rbIndLTFCPlacement");
    
    // STGAP00010671 - Get the selected boarding county
    String cbxBoardingCounty = ContextHelper.getStringSafe(request, "cbxBoardingCounty");
  
    UserProfile user = UserProfileHelper.getUserProfile(request);
    if (dtPlaceStart != null && !(DateHelper.MIN_CASTOR_DATE).equals(dtPlaceStart)
        && !(DateHelper.MAX_CASTOR_DATE).equals(dtPlaceStart)) {
      if (!DateHelper.isNull(dtPlaceStart) && !(StringHelper.EMPTY_STRING).equals(tmPlcmtStart)) {

        dtPlaceStart1 = DateHelper.toJavaDateSafe(dtPlaceStart, tmPlcmtStart);
      }
    }
    if (dtPlaceEnd != null && !(DateHelper.MIN_CASTOR_DATE).equals(dtPlaceEnd)
        && !(DateHelper.MAX_CASTOR_DATE).equals(dtPlaceEnd)) {
      if (!DateHelper.isNull(dtPlaceEnd) && !(StringHelper.EMPTY_STRING).equals(tmPlcmtEnd)) {

        dtPlaceEnd1 = DateHelper.toJavaDateSafe(dtPlaceEnd, tmPlcmtEnd);
      }
    }

    if (dtPlaceStart != null && DateHelper.isAfterToday(dtPlaceStart)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (!DateHelper.isNull(dtPlaceStart1) && !DateHelper.isNull(dtPlaceEnd1)) {

      if (DateHelper.isBefore(dtPlaceEnd1, dtPlaceStart1)) {
        setErrorMessage(Messages.SSM_START_BEFORE_SAME_END);
        isValid = false;
      }
    }

    if (dtCrtBeginDate != null && DateHelper.isAfterToday(dtCrtBeginDate)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (txtDtPsychInfo != null && DateHelper.isAfterToday(txtDtPsychInfo)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (txtDtCasePsychInfo != null && DateHelper.isAfterToday(txtDtCasePsychInfo)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (txtDtMedInfo != null && DateHelper.isAfterToday(txtDtMedInfo)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (txtDtCaseMedInfo != null && DateHelper.isAfterToday(txtDtCaseMedInfo)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (txtDtEduInfo != null && DateHelper.isAfterToday(txtDtEduInfo)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }
    if (txtDtCaseEduInfo != null && DateHelper.isAfterToday(txtDtCaseEduInfo)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }
    if (txtDtDtPlcmtPreplaceVisit != null && DateHelper.isAfterToday(txtDtDtPlcmtPreplaceVisit)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (txtDtDtPlcmtParentsNotif != null && DateHelper.isAfterToday(txtDtDtPlcmtParentsNotif)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (txtDtDtPlcmtChildDiscuss != null && DateHelper.isAfterToday(txtDtDtPlcmtChildDiscuss)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (txtDtDtPlcmtCaregvrDiscuss != null && DateHelper.isAfterToday(txtDtDtPlcmtCaregvrDiscuss)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }

    if (!CONCURRENT.equals(szCdTempPlcmtType) && !RESPITE_DAY.equals(szCdTempPlcmtType)
        && !RESPITE_NIGHT.equals(szCdTempPlcmtType) && dtPlaceEnd != null && DateHelper.isAfterToday(dtPlaceEnd)) {
      setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
      isValid = false;
    }
    if (PlacementConversation.SUBCARE.equals(GlobalData.getSzCdStage(request))) {
      if ((ADOPTIVE_HOME.equals(selSzCdPlcmtType) || ICPC_Adoptive.equals(selSzCdPlcmtType))
          && DateHelper.isNull(dtPlaceEnd1)) {
        setErrorMessage(Messages.SSM_SUB_ADOPT_LIV_ARRG);
        isValid = false;
      }

    }
    if (PlacementConversation.ADOPT.equals(GlobalData.getSzCdStage(request))) {
      if (!ADOPTIVE_HOME.equals(selSzCdPlcmtType)) {
        if (!ICPC_Adoptive.equals(selSzCdPlcmtType)) {
          setErrorMessage(Messages.SSM_SUB_SUBCARE_LIV_ARRG);
          isValid = false;
        }
      }

    }
    if (ArchitectureConstants.Y.equals(cbxIndTempReplacement) && (StringHelper.EMPTY_STRING).equals(szCdTempPlcmtType)) {
      setErrorMessage(Messages.MSG_PLCMT_TEMP_TYPE_REQ);
      isValid = false;
    }
    //STGAP00007457: need to populate the temporary type indicator field if the temporary type
    //is selected and hence added the validation below
    if (!(StringHelper.EMPTY_STRING).equals(szCdTempPlcmtType) && !ArchitectureConstants.Y.equals(cbxIndTempReplacement)) {
      setErrorMessage("cbxIndTempReplacement",Messages.MSG_PLCMT_IND_TEMP_REQ);
      isValid = false;
    }
    //STGAP00006533: Modified code to eliminate code type CATTEMP
    if (CodesTables.CPLCMTAC_P.equals(szCdActAtt) && (StringHelper.EMPTY_STRING).equals(selSzCdPlcmtRemovalRsn)) {
      setErrorMessage(Messages.MSG_PLCMT_REFUS_REASON_REQ);
      isValid = false;
    }
    if ((TYPE_HOSPITAL.equals(selSzCdPlcmtType) || TYPE_YDC.equals(selSzCdPlcmtType)
         || TYPE_OTHER_RESOURCE.equals(selSzCdPlcmtType) || TYPE_OTHER_ADOPTIVE_HOME.equals(selSzCdPlcmtType))//mxpatel 12392
        && (StringHelper.EMPTY_STRING).equals(nmFacility)) {
      setErrorMessage(Messages.MSG_NO_ACT_FLOC_STATUS);
      isValid = false;
    }
    if ((TYPE_PARENT.equals(selSzCdPlcmtType) || TYPE_RELATIVE_UNPAID.equals(selSzCdPlcmtType)
         || TYPE_ICPC_RELATIVE.equals(selSzCdPlcmtType) || TYPE_ILP_AFTERCARE.equals(selSzCdPlcmtType) || 
         TYPE_OTHER_PERSON.equals(selSzCdPlcmtType))
        && (personName == null || (StringHelper.EMPTY_STRING).equals(personName))) {
      setErrorMessage(Messages.MSG_NO_ACT_FLOC_STATUS);
      isValid = false;
    }
    // SMS #81140: MR-074
    // Group Home (TYPE_GROUP_HOME condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
    // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
    // However, it is no harm to keep Group Home in the code below because it will not break the logic.
    // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value.
    if ((TYPE_DFCS_FAMILY_FOSTER_HOME.equals(selSzCdPlcmtType) || TYPE_RELATIVE_FOSTER_HOME.equals(selSzCdPlcmtType)
         || TYPE_ADOPTIVE_HOME.equals(selSzCdPlcmtType) || TYPE_ICPC_FOSTER.equals(selSzCdPlcmtType)
         || TYPE_ICPC_ADOPTIVE.equals(selSzCdPlcmtType) || TYPE_CPA_FAMILY_FOSTER_HOME.equals(selSzCdPlcmtType)
         || TYPE_CCI_FAMILY_FOSTER_HOME.equals(selSzCdPlcmtType) || TYPE_EMERGENCY_SHELTER.equals(selSzCdPlcmtType)
         || TYPE_GROUP_HOME.equals(selSzCdPlcmtType) || TYPE_CHILD_CARE_INSTITUTION.equals(selSzCdPlcmtType)
         || TYPE_SPECIALIZED_FOSTER_HOME.equals(selSzCdPlcmtType) || TYPE_RELATIVE_PAID.equals(selSzCdPlcmtType) || 
         TYPE_NON_RELATIVE_PAID.equals(selSzCdPlcmtType))
        && (idResource == 0 || (StringHelper.EMPTY_STRING).equals(nmFacility) || nmFacility == null)) {
      setErrorMessage(Messages.MSG_NO_ACT_FLOC_STATUS);
      isValid = false;
    }

    if (CONCURRENT.equals(szCdTempPlcmtType) || RESPITE_DAY.equals(szCdTempPlcmtType)
        || RESPITE_NIGHT.equals(szCdTempPlcmtType)) {

      if (dtPlaceEnd == null) {
        setErrorMessage(Messages.MSG_PLCMT_TEMP_END_DATE_REQ);
        isValid = false;
      }
    }
    org.exolab.castor.types.Date tempStartDate1 = DateHelper.addToDate(dtPlaceStart, 0, 0, 14);
    if (CONCURRENT.equals(szCdTempPlcmtType)) {
      if (dtPlaceEnd != null && DateHelper.isAfter(dtPlaceEnd, tempStartDate1)) {
        setErrorMessage(Messages.MSG_PLCMT_CONCURR_LENGTH);
        isValid = false;
      }
    }
    org.exolab.castor.types.Date tempStartDate2 = DateHelper.addToDate(dtPlaceStart, 0, 0, 5);
    if (RESPITE_DAY.equals(szCdTempPlcmtType) || RESPITE_NIGHT.equals(szCdTempPlcmtType)) {
      if (dtPlaceEnd != null && DateHelper.isAfter(dtPlaceEnd, tempStartDate2)) {
        setErrorMessage(Messages.MSG_PLCMT_RESP_LENGTH);
        isValid = false;
      }
    }
    
    //MR-057 Validaton for APPLA: Date Agreement Signed is required when placement is LTFC
    if(ArchitectureConstants.Y.equals(rbIndLTFCPlacement) && dtAgreementSigned == null){
      setErrorMessage("dtAgreementSigned", Messages.MSG_PLCMT_DT_AGRMNT_SIGNED_REQ);
      isValid = false;
    }
    
    
    if (!DateHelper.isNull(dtAgreementSigned)) {
      //MR-057 Validation for APPLA: Date Agreement Signed cannot be before start date of the placement
      if (!DateHelper.isNull(dtPlaceStart1) && DateHelper.isBefore(dtAgreementSigned, dtPlaceStart1)) {
        setErrorMessage("dtAgreementSigned",Messages.MSG_PLCMT_DTAGRMNTSIGNED_CANT_BEFORE_DTPLCMTSTART);
        isValid = false;
      }
      //MR-057 Validation for APPLA: Date Agreement Signed cannot be a future date
      if (DateHelper.isAfterToday(dtAgreementSigned)) {
        setErrorMessage("dtAgreementSigned",Messages.MSG_PLCMT_DTAGRMNTSIGNED_CAN_NOT_BE_IN_FUTURE);
        isValid = false;
      }
    }
 
    // SMS #81140: MR-074 AFCARS Conversion from Group Home to CCI
    if (TYPE_GROUP_HOME.equals(selSzCdPlcmtType)
        && (super.isButtonPressed(PlacementConversation.SAVE_SUBMIT_PLACEMENT_BUTTON) || super
                                                                                              .isButtonPressed(PlacementConversation.SAVE_PLACEMENT_BUTTON))) {
      setErrorMessage(Messages.MSG_PLCMT_GROUP_HOME_ERR);
      isValid = false;
    }
                                              
                                              
    if (super.isButtonPressed(PlacementConversation.SAVE_SUBMIT_PLACEMENT_BUTTON)
        || (super.isButtonPressed(PlacementConversation.SAVE_PLACEMENT_BUTTON) && GlobalData.isApprovalMode(request))) {

      if(!TYPE_OTHER_ADOPTIVE_HOME.equals(selSzCdPlcmtType)){//mxpatel 12392
      
      // All validations requiring data entry for the Placement checklist section
      // should only trigger if the stage is FCC or ADO, the placement is actual,
      // and the placement is not temporary.
      //STGAP00006533: Modified code to eliminate code type CATTEMP
      if ((PlacementConversation.ADOPT.equals(cdStage) || PlacementConversation.SUBCARE.equals(cdStage))
          && CodesTables.CPLCMTAC_A.equals(szCdActAtt) && (StringHelper.EMPTY_STRING).equals(szCdTempPlcmtType)) {
        if ((ArchitectureConstants.N.equals(rbIndPlcmtSafe) 
             || ArchitectureConstants.N.equals(rbIndPlcmtLeastRestrict)
             || ArchitectureConstants.N.equals(rbIndPlcmtFamilyLike)
             || ArchitectureConstants.N.equals(rbIndPlcmtAppropriate)
             || ArchitectureConstants.N.equals(rbIndPlcmtCloseProxPar)
            // || ArchitectureConstants.Y.equals(rbIndPlcmtCloseProxSchool) //mxpatel commneted this out for defect #10685
             || ArchitectureConstants.N.equals(rbIndConsistent))
            && ((StringHelper.EMPTY_STRING).equals(szTxtNoExplainCheckList))) {

          setErrorMessage(Messages.MSG_PLCMT_CHECK_NO_COM_REQ);
          isValid = false;
        }
        
        //mxpatel added this for defect #10685
        if((ArchitectureConstants.Y.equals(rbIndPlcmtCloseProxSchool)) && ((StringHelper.EMPTY_STRING).equals(szTxtNoExplainCheckList))){
          String errorMessage = "If Yes to school change please enter comments";
          setErrorMessage(errorMessage);
           isValid = false;
        }
        
        if (!DateHelper.isNull(txtDtDtPlcmtChildDiscuss) && (StringHelper.EMPTY_STRING).equals(txtaSzTxtPlcmtDiscussion)) {
          setErrorMessage("txtaSzTxtPlcmtDiscussion", Messages.MSG_PLCMT_DISC_DOC);
          isValid = false;
        }
        if ((DateHelper.isNull(txtDtPsychInfo) && DateHelper.isNull(txtDtCasePsychInfo)
             && DateHelper.isNull(txtDtMedInfo) && DateHelper.isNull(txtDtCaseMedInfo)
             && DateHelper.isNull(txtDtCaseEduInfo) && DateHelper.isNull(txtDtEduInfo))
            && (StringHelper.EMPTY_STRING).equals(txtSzTxtPlcmtDocuments)) {
          setErrorMessage("txtSzTxtPlcmtDocuments", Messages.MSG_PLCMT_DATE_RECS_EXP);
          isValid = false;
        }
        
        //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndPlcmtSafe)){
           String errorMessage = "Is placement in a safe setting? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
          
        //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndPlcmtLeastRestrict)){
           String errorMessage = "Is placement least restrictive available? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
          
        //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndPlcmtFamilyLike)){
           String errorMessage = "Is placement most family-like available? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
          
        //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndPlcmtAppropriate)){
           String errorMessage = "Is placement appropriate? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
          
          //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndPlcmtCloseProxPar)){
           String errorMessage = "Is placement in close proximity to parents? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
          
        //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndPlcmtCloseProxSchool)){
           String errorMessage = "Did the child have to change school districts due to change in placement? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
          
          //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndConsistent)){
           String errorMessage = "Is placement consistent with child's best interest...? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
          
        //mxpatel added this IF statement for defect #10685
        if((StringHelper.EMPTY_STRING).equals(rbIndExpTrauma)){
          String errorMessage = "Did the child experience trauma during the placement move? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
          setErrorMessage(errorMessage);
           isValid = false;
        }
        
        if (ArchitectureConstants.Y.equals(rbIndExpTrauma) && (StringHelper.EMPTY_STRING).equals(szTxtYesExpTrauma)) {
          setErrorMessage(Messages.MSG_PLCMT_TRAUMA_COM_REQ);
          isValid = false;
        }

        if ((StringHelper.EMPTY_STRING).equals(rbIndStaySiblings)) {
          setErrorMessage(Messages.MSG_PLCMT_IND_SIB);
          isValid = false;
        }
        if ((ArchitectureConstants.Y.equals(rbIndStaySiblings)) && nbrSibinCare == 0) {
          setErrorMessage(Messages.MSG_PLCMT_SIB_CARE_REQ);
          isValid = false;
        }
        if (ArchitectureConstants.Y.equals(rbIndStaySiblings) && nbrSibPlaced == 0) {
          setErrorMessage(Messages.MSG_PLCMT_SIB_REQ);
          isValid = false;
        }
        if (ArchitectureConstants.N.equals(rbIndStaySiblings) && (StringHelper.EMPTY_STRING).equals(szCdSibRsn)) {
          setErrorMessage(Messages.MSG_PLCMT_SIB_NO_REAS_REQ);
          isValid = false;
        }
        if (ArchitectureConstants.N.equals(rbIndStaySiblings) && (StringHelper.EMPTY_STRING).equals(szCdNoReasonCmnts)) {
          setErrorMessage(Messages.MSG_PLCMT_SB_NO_COMM_REQ);
          isValid = false;
        }
        
        //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndPlcmtMatchCCFA)){
           String errorMessage = "Does Placement match CCFA recommendations? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
        
        if (ArchitectureConstants.N.equals(rbIndPlcmtMatchCCFA) && (StringHelper.EMPTY_STRING).equals(szCdCCFARsn)) {
          setErrorMessage(Messages.MSG_PLCMT_CCFA_NO_REAS_REQ);
          isValid = false;
        }
        if (ArchitectureConstants.N.equals(rbIndPlcmtMatchCCFA) && (StringHelper.EMPTY_STRING).equals(szCdPlcmtMatchCCFAReasonCmnts)) {
          setErrorMessage(Messages.MSG_PLCMT_CCFA_NO_COMM_REQ);
          isValid = false;
        }
        
        //mxpatel added this IF statement for defect #10685
          if((StringHelper.EMPTY_STRING).equals(rbIndSuppSupervision)){
           String errorMessage = "Has Supplemental supervision been provided? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
           setErrorMessage(errorMessage);
            isValid = false;
          }
          
        if (ArchitectureConstants.Y.equals(rbIndSuppSupervision) && (StringHelper.EMPTY_STRING).equals(szCdSuppSupervisionCmnts)) {
          setErrorMessage(Messages.MSG_PLCMT_SUPP_SPV_EXP);
          isValid = false;
        }
      }
      boolean indCbxAdo = !(ArchitectureConstants.Y.equals(cbxAdoPlaceInfo1)
                            || ArchitectureConstants.Y.equals(cbxAdoPlaceInfo2)
                            || ArchitectureConstants.Y.equals(cbxAdoPlaceInfo3) || ArchitectureConstants.Y
                                                                                                          .equals(cbxAdoPlaceInfo4));
      boolean indRbPlChFr = !(rbIndPlcmtChPlacedFr.equals("1") || rbIndPlcmtChPlacedFr.equals("2") || rbIndPlcmtChPlacedFr
                                                                                                                          .equals("3"));
      boolean indRbPlChBy = !(rbIndPlcmtChPlacedBy.equals("1") || rbIndPlcmtChPlacedBy.equals("2")
                              || rbIndPlcmtChPlacedBy.equals("3") || rbIndPlcmtChPlacedBy.equals("4") || rbIndPlcmtChPlacedBy
                                                                                                                             .equals("5"));
      if ((TYPE_ADOPTIVE_HOME.equals(selSzCdPlcmtType) || TYPE_ICPC_ADOPTIVE.equals(selSzCdPlcmtType))
          && (indCbxAdo || indRbPlChFr || indRbPlChBy) && DateHelper.isNull(dtPlaceEnd1)) {
        setErrorMessage(Messages.MSG_PLCMT_ADO_TYPE_REQ);
        isValid = false;
      }
      if (PlacementConversation.ADOPT.equals(cdStage) && (StringHelper.EMPTY_STRING).equals(szCdChildTransitionCmnts)) {
        setErrorMessage(Messages.MSG_PLCMT_ADO_TRANS_REQ);
        isValid = false;
      }
      String[] placementInfoCbx = CheckboxHelper.getCheckedValues(request, "cbxPlaceInfo");
      
      // STGAP00010671 - Initialize checked Intended Permanent check box search
      String permIntended = CodesTables.CPLCMTIN_020;
      Boolean indPermIntended = false;
      
      // STGAP00010671 - Initialize checked Boarding County check box search
      String szCdBoardingCounty = CodesTables.CPLCMTIN_070;
      Boolean indBoardingCounty = false;
      
      // Search for checked boxes
      for (int i = 0; i < placementInfoCbx.length; i++) {
        
        // STGAP00010671 - Determine if Intended Permanent is checked
        if (permIntended.equals(placementInfoCbx[i])) {
          indPermIntended = true;
        }
        
        // STGAP00010671 - Determine if Boarding County is checked?
        if (!indBoardingCounty && szCdBoardingCounty.equals(placementInfoCbx[i])) {
          indBoardingCounty = true;
        }
      }
      
      if (!indPermIntended && DateHelper.isNull(dtPermReportDueDate)) {
        setErrorMessage(Messages.MSG_PLCMT_PERM_REP_REQ);
        isValid = false;
      }
      
      // STGAP00010671 - Validate Boarding County
      if (indBoardingCounty && ((cbxBoardingCounty == null) || (StringHelper.EMPTY_STRING).equals(cbxBoardingCounty)) ) {
        setErrorMessage(Messages.MSG_PLCMT_BOARDING_COUNTY_REQ);
        isValid = false;
      }     
      
      if (!(StringHelper.EMPTY_STRING).equals(szCdTempPlcmtType) && (StringHelper.EMPTY_STRING).equals(szTxtTempPlcmtCmnts)) {
        setErrorMessage(Messages.MSG_PLCMT_TEMP_COM_REQ);
        isValid = false;
      }
      if (ArchitectureConstants.Y.equals(cbxIndWaiverRequired) && dspUlWaiverId == 0) {
        setErrorMessage(Messages.MSG_PLCMT_WAIVER_REQ);
        isValid = false;
      }

      if (!PARENT.equals(selSzCdPlcmtType) && ArchitectureConstants.Y.equals(cbxIndTrialHomeVisit)) {

        setErrorMessage(Messages.MSG_PLCMT_TRIAL_HOME_PARENT);
        isValid = false;
      }

      if (ArchitectureConstants.Y.equals(cbxIndTrialHomeVisit) && dtCrtBeginDate == null) {
        setErrorMessage(Messages.MSG_PLCMT_TRIAL_HOME_PLCMT_BEGIN_REQ);
        isValid = false;
      }
      if (ArchitectureConstants.Y.equals(cbxIndTrialHomeVisit) && dtCrtEndDate == null) {
        setErrorMessage(Messages.MSG_PLCMT_TRIAL_HOME_END_REQ);
        isValid = false;
      }

      if (dtPlaceEnd != null && !(DateHelper.MIN_CASTOR_DATE).equals(dtPlaceEnd)
          && !(DateHelper.MAX_CASTOR_DATE).equals(dtPlaceEnd)) {
        if ((StringHelper.EMPTY_STRING).equals(selSzCdPlcmtRemovalRsn)) {
          setErrorMessage(Messages.MSG_PLCMT_REMOV_REASON_REQ);
          isValid = false;
        }
      }
      // STGAP00005989: If the Placement type is CPA Home and the agency name and id fields are not populated
      // then throw this error message.
      if (TYPE_CPA_FAMILY_FOSTER_HOME.equals(selSzCdPlcmtType)
          && ((StringHelper.EMPTY_STRING).equals(dspSzNmPlcmtAgency) || dspUlIdRsrcAgency == 0)) {
        setErrorMessage(Messages.MSG_CPA_REQ);
        isValid = false;
      }
    }//mxpatel 12392
    }
    //STGAP00006420: Added a check on the user profile to see if the user has the 
    //special attribute to end date an approved placement so that the user will be
    //able to save and end date with out clicking save and submit. 
    if (super.isButtonPressed(PlacementConversation.SAVE_PLACEMENT_BUTTON)
        && !user.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT) && CodesTables.CEVTSTAT_APRV.equals(eventStatus) && !DateHelper.isNull(dtPlaceEnd1)) {
      setErrorMessage(Messages.MSG_PLCMT_SAVE_AND_SUBMIT_END_DATE);
      isValid = false;
    }

    if (super.isButtonPressed(PlacementConversation.SAVE_SUBMIT_PLACEMENT_BUTTON)
                    && !user.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT) 
                    && !CodesTables.CEVTSTAT_APRV.equals(eventStatus) 
                    && DateHelper.isNull(dtPlaceEnd1)
                    && idResource != 0) {
      
      CaseMgmt caseMgmt = this.getEjb(CaseMgmt.class);
      FadHomeRetrieveSO fadHomeSO = caseMgmt.retrieveFadHome(idResource);
      
      List<String> onHoldStatuses = new ArrayList<String>();
      onHoldStatuses.add(CodesTables.CFAHMSTA_AFA); // Approved (Full) - Active
      onHoldStatuses.add(CodesTables.CFAHMSTA_ASA); // Approved (Special) - Active
      onHoldStatuses.add(CodesTables.CFAHMSTA_ATA); // Approved (Temp) - Active

      if(fadHomeSO != null
                      // Home status is approved
                      && onHoldStatuses.contains(fadHomeSO.getSzCdRsrcFaHomeStatus())
                      // Resource status is inactive
                      && CodesTables.CRSCSTAT_02.equals(fadHomeSO.getSzCdRsrcStatus())){
        setErrorMessage(Messages.MSG_PLCMT_HOLD);
        isValid = false;
      }

      List<String> recCheckVerifStatuses = new ArrayList<String>();
      recCheckVerifStatuses.add(CodesTables.CFAHMSTA_FLG); // Full Approval 30 Day Grace
      recCheckVerifStatuses.add(CodesTables.CFAHMSTA_FSG); // Special Approval 30 Day Grace
      recCheckVerifStatuses.add(CodesTables.CFAHMSTA_PUN); // Pending Unapproved
      recCheckVerifStatuses.add(CodesTables.CFAHMSTA_AUN); // Unapproved

      if(fadHomeSO != null
                      && recCheckVerifStatuses.contains(fadHomeSO.getSzCdRsrcFaHomeStatus())){
        setErrorMessage(Messages.MSG_PLCMT_GRACE_PER_UNAPRV);
        isValid = false;
      }
    }
    
    // STGAP00017058
    String plcmtType = ContextHelper.getStringSafe(request, "selSzCdPlcmtType");
    boolean isCertDisplayed = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnPlacementCertification")) ? true : false;
    boolean isActual = Cplcmtac.CPLCMTAC_A.equals(ContextHelper.getStringSafe(request, "selSzCdActAtt")) ? true : false; 
    boolean saveAndSubmitBtnPressed = super.isButtonPressed("btnSaveAndSubmit");
    boolean approvalStatusBtnPressed = super.isButtonPressed("btnApprovalStatusFinal");
    Boolean isCertificationFrozen = getState().getAttribute("isCertificationFrozen", request) != null ? (Boolean) getState().getAttribute("isCertificationFrozen", request) : false;
    int ulIdCaseMngrCert = ContextHelper.getIntSafe(request, "hdnDspCaseManagerId");
    int ulIdSupCert = ContextHelper.getIntSafe(request, "hdnDspSupId");
    org.exolab.castor.types.Date hdnLastViewPlcmtLogDate = null;
    org.exolab.castor.types.Date dtCaseMngrCert = null; 
    org.exolab.castor.types.Date dtSupCert = null;

    try{
      hdnLastViewPlcmtLogDate = DateHelper.isValidDate(request.getParameter("hdnLastViewPlcmtLogDate")) ? ContextHelper.getCastorDate(request, "hdnLastViewPlcmtLogDate") : null;
    }catch(ParseException p){
      hdnLastViewPlcmtLogDate = null;
    }
    try{
      dtCaseMngrCert = DateHelper.isValidDate(request.getParameter("hdnDtCaseMngrCert")) ? ContextHelper.getCastorDate(request, "hdnDtCaseMngrCert") : null;
    }catch(ParseException p){
      dtCaseMngrCert = null;
    }
    try{
      dtSupCert = DateHelper.isValidDate(request.getParameter("hdnDtSupCert")) ? ContextHelper.getCastorDate(request, "hdnDtSupCert") : null;
    }catch(ParseException p){
      dtSupCert = null;
    }
    
    if (!isCertificationFrozen) {
      if (saveAndSubmitBtnPressed && isActual && !CodesTables.CEVTSTAT_APRV.equals(eventStatus)
          && (idResource != 0 || idFacility != 0)) {
        if (!"YDC".equals(plcmtType)
            && (hdnLastViewPlcmtLogDate == null || !DateHelper.isToday(hdnLastViewPlcmtLogDate))) {
          setErrorMessage(Messages.MSG_CONFIRM_PLCMT_SS_ERR);
          isValid = false;
        } else if (isCertDisplayed && (ulIdCaseMngrCert == 0 || dtCaseMngrCert == null)) {
          setErrorMessage(Messages.MSG_CONFIRM_PLCMT_SS_ERR);
          isValid = false;
        }
      }
      if (approvalStatusBtnPressed && isActual && !CodesTables.CEVTSTAT_APRV.equals(eventStatus)
          && !CodesTables.CEVTSTAT_COMP.equals(eventStatus) && (idResource != 0 || idFacility != 0)) {
        if (!"YDC".equals(plcmtType)
            && (hdnLastViewPlcmtLogDate == null || !DateHelper.isToday(hdnLastViewPlcmtLogDate))) {
          setErrorMessage(Messages.MSG_CONFIRM_PLCMT_APPR_APRV_ERR);
          isValid = false;
        } else if (isCertDisplayed && (ulIdSupCert == 0 || dtSupCert == null)) {
          setErrorMessage(Messages.MSG_CONFIRM_PLCMT_APPR_APRV_ERR);
          isValid = false;
        }
      }
    }
    if(!isValid){
      CSUB25SO csub25so = (CSUB25SO) getState().getAttribute("CSUB25SO", request);
      if (csub25so == null) {
        csub25so = new CSUB25SO();
      }
      CSUB25SOG00 placementDetail = csub25so.getCSUB25SOG00();
      if (placementDetail == null) {
        placementDetail = new CSUB25SOG00();
      }
      placementDetail.setDtCaseMngrCert(dtCaseMngrCert);
      placementDetail.setDtSupCert(dtSupCert);
      placementDetail.setUlIdCaseMngrCert(ulIdCaseMngrCert);
      placementDetail.setUlIdSupCert(ulIdSupCert);
    }
    
    getState().setAttribute("hdnClearingPlaceInfo", ContextHelper.getStringSafe(context, "hdnClearingPlaceInfo"), request);
    // End STGAP00017058

    performanceTrace.exitScope();
    return isValid;
  }
}
