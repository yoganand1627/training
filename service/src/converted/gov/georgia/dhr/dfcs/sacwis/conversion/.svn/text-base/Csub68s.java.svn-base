package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB68SO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS84DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSESA3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES35DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES38DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES78DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES78DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS30DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSESA3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC28DO;
public class Csub68s {
    static final String POST_ADOPT1 = "PAD";
    static final String PREP_ADULT = "PAL";
    static final String ADOPTION1 = "ADO";
    static final String INVESTIGATION1 = "INV";
    static final String ARI_STAGE = "ARI";
    static final String FPR_PROGRAM = "FPR";
    static final String FRE_PROGRAM = "FRE";
    static final String FSU_PROGRAM = "FSU";
    public static final String ADULT = "APS";
    public static final String PRIMARY_CHILD = "PC";
    public static final String CLIENT = "CL";
    public static final String BILLING_LOC = "BLOC";
    public static final String AUTHORIZED_LOC = "ALOC";
    public static final String PRS_RESP_TERM = "120";
    public static final String NON_SUIT = "010";
    public static final String PMC_TO_OTHER = "020";
    public static final String CVS_NOT_OBTAINED = "150";
    public static final String REAS_CVS_NOT_OBT = "030";
    public static final String CHILD_EMANCIPATED = "100";
    public static final String REAS_EMANCIPATED = "080";
    public static final String OWN_HOME = "DA";
    public static final String RELATIVES_HOME = "DD";
    public static final String REAS_OWN_HOME = "040";
    public static final String REAS_REL_HOME = "050";
    public static final String CHILD_RAN_AWAY = "130";
    public static final String REAS_RAN_AWAY = "070";
    public static final String ADOPTION_CONSUM = "090";
    public static final String REAS_ADOPT_CONSUM = "010";
    public static final String ADO_PMC_TO_OTHER = "030";
    public static final String ADOPTION_DISRUPT = "500";
    public static final String REAS_AGED_OUT = "040";
    public static final String REAS_CHILD_DEATH = "050";
    public static final String SUB_AGED_OUT = "090";
    public static final String SUB_CHILD_DEATH = "100";
    public static final String ADOPT_CHILD_DEATH = "040";
    public static final String PAD_CHILD_DEATH = "080";
    public static final String LONG_TERM_CARE = "ILC";
    public static final String INDEPENDENT_LIVING = "HIL";
    public static final String APS_GUARDIANSHIP = "010";
    public static final String APS_OPEN_GEN_STG = "05";
    public static final String REAS_NO_PLAN_PLACE = "060";
    public static final String REAS_PARENT_DEATH = "050";
    public static final String ADOPT_DISRUPTION = "020";
    public static final String APS_GUARD_GRANTED = "020";
    public static final String PRIV_AGCY_ADPT_HM = "71";
    public static final char SEC_POS_CLOSE_REAS_ONE = '1';
    public static final char SEC_POS_CLOSE_REAS_TWO = '2';
    public static final char SEC_POS_CLOSE_REAS_THREE = '3';
    public static final char SEC_POS_CLOSE_REAS_FOUR = '4';
    public static final char SEC_POS_CLOSE_REAS_FIVE = '5';
    public static final char SEC_POS_CLOSE_REAS_SIX = '6';
    public static final char SEC_POS_CLOSE_REAS_SEVEN = '7';
    public static final char SEC_POS_CLOSE_REAS_EIGHT = '8';
    public static final char SEC_POS_CLOSE_REAS_NINE = '9';
    public static final char SEC_POS_CLOSE_REAS_ZERO = '0';
    public static final char SEC_POS_CD_STAGE_D = 'D';
    public static final char SEC_POS_CD_STAGE_O = 'O';
    public static final char SUBCARE = 'S';
    public static final char ADO_AOC = 'A';
    public static final char POST_ADOPTION = 'P';
    public static final char FAMILY_STAGE = 'F';
    public static final String STAGE_ADOPTION = "ADO";
    public static final String STAGE_POST_ADOPT = "PAD";
    public static final String STAGE_FAM_REUN = "FRE";
    public static final String STAGE_FAM_SUBCARE = "FSU";
    public static final String STAGE_FAM_PRES = "FPR";
    public static final String CASE_REL_SPEC_REQ = "C-";
    public static final int NEXT = 1;
    public static final int CURRENT = 0;
    public static final char TRUE_CHAR = '1';
    public static final char FALSE_CHAR = '0';
    public static final int YEAR_IN_MINS = 525600;
    public static final int INITIAL_PAGE = 1;
    public static final int PAGE_SIZE_NBR = 50;
    public static final char CLOSE_STAGE_CASE = '0';
    public static final char CLOSE_OPEN_STAGE = '1';
    public static final char OPEN_STAGE = '2';
    public static final String CD_TASK_SUB = "3270";
    public static final String CD_TASK_PAD = "9260";
    public static final String CD_TASK_ADO = "8770";
    public static final String CD_TASK_AOC = "5090";
    public static final String CD_TASK_FRE = "5560";
    public static final String CD_TASK_FSU = "4110";
    public static final String STR_CD_TASK_FRE = "5560";
    public static final String STR_CD_TASK_FSU = "4110";
    public static final String STAGE_SUBCARE = "SUB";
    public static final String STAGE_AOC = "AOC";
    public static final String SUB_SVC_AUTH = "3020";
    public static final String AOC_SVC_AUTH = "5040";
    public static final String ADO_SVC_AUTH = "8530";
    public static final String PAD_SVC_AUTH = "9020";
    public static final String FSU_SVC_AUTH = "4190";
    public static final String FRE_SVC_AUTH = "5640";
    public static final String STATUS_APPROVED = "APRV";
    public static final String SERVICE_AUTH_TYPE = "AUT";
    public static final String ADOPT_SUBSIDY_TYPE = "ADP";
    public static final String PAD_ADOPT_SUB = "9100";
    public static final String PLCMT_TYPE_PRS_CON = "030";
    public static final String PLCMT_TYPE_PRS_FAD = "020";
    public static final String PLCMT_TYPE_UNAUTH = "080";
    public static final String LEGAL_STS_TYPE_ONE = "010";
    public static final String LEGAL_STS_TYPE_TWO = "020";
    public static final String LEGAL_STS_TYPE_THREE = "030";
    public static final String LEGAL_STS_TYPE_FOUR = "040";
    public static final String LEGAL_STS_TYPE_FIVE = "050";
    public static final String LEGAL_STS_TYPE_SIX = "060";
    public static final String LEGAL_STS_TYPE_SEVEN = "070";
    public static final String LEGAL_STS_TYPE_EIGHT = "080";
    public static final String LEGAL_STS_TYPE_ONE_THIRTY = "130";
    public static final String LEGAL_STS_TYPE_ONE_FOURTY = "140";
    public static final String STAFF = "STF";
    public static final String PRINCIPAL = "PRN";
    public static final String ADOPTIVE_PLACEMENT = "GT";
    public static final String STATUS_NEW = "NEW";
    public static final String STATUS_PROCESS = "PROC";
    public static final String STATUS_COMPLETE = "COMP";
    public static final String STATUS_PENDING = "PEND";
    public static final String OUT_MATRIX_TASK = "5030";
    public static final String OUT_MATRIX_TYPE = "PLN";
    public static final String FCE_ELIG_TASK = "3120";
    public static final String FCE_ELIG_TYPE = "FCD";
    public static final String DAY_CARE = "99R";
    public static final String FORMER_DAY_CARE = "40M";
    public static final String GENERAL_PROT_CARE = "40W";
    public static final String IVE_FC_DAY_CARE = "40A";
    public static final String REGISTERED_FAMILY_HM = "99Q";
    public static final String STATE_PAID_FC_DAY_CARE = "40B";
    public static final String LEG_STATUS_EVENT = "LES";
    public static final String PLCMT_TYPE_NON_CERT_PERSON = "010";
    public static final String PLCMT_TYPE_NON_FPS_PAID = "040";
    public static final String SVC_REF_CHKLST_FRE_TASK = "2307";
    public static final String SVC_REF_CHKLST_FSU_TASK = "2308";
    public static final String SVC_REF_CHKLST_EVENT_TYPE = "CHK";
    CSUB68SO CSUB68S(CSUB68SI csub68si) {
        CSUB68SO csub68so = new CSUB68SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CSUB68S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int RetVal = SUCCESS;
        String sztempCdStageClosureReason = new String();
        String sztempCdStageOpen = new String();
        FndInt3date dtDtSystemDate = null;
        int lRC = 0;
        int fYears = 0;
        int ulTempIdPerson = 0;
        boolean bIndSvcOpen = false;
        public public public public public public public public boolean bSvcAuthsToProgress = false;
        boolean bEligibleStageFound = false;
        FndInt3date DtTempStageStart = null;
        DtTempStageStart.day = DateHelper.NULL_DATE;
        DtTempStageStart.month = DateHelper.NULL_DATE;
        DtTempStageStart.year = DateHelper.NULL_DATE;
        String szCdPlocType1 = new String();
        boolean bFceEligEventExists = false;
        boolean bAlocEventExists = false;
        boolean bBlocEventExists = false;
        boolean bFPSPaidPlcmtExists = false;
        int i = 0;
        int m = 0;
        boolean bCaseLegalStsFound = false;
        boolean bOtherFamOpen = false;
        boolean bSubStageOpen = false;
        boolean bIndOpenSubAdo = false;
        CLSS84DO CLSS84DOutRec = null;
        CSESA3DO CSESA3DOutRec = null;
        CCMN44DO CCMN44DOutRec = null;
        CCMN87DI CCMN87DInRec = null;
        CCMN87DO CCMN87DOutRec = null;
        CCMNB8DO CCMNB8DOutRec = null;
        CCMNB9DO CCMNB9DOutRec = null;
        CCMNF6DO CCMNF6DOutRec = null;
        CINV39DI CINV39DInRec = null;
        CINV39DO CINV39DOutRec = null;
        CINV51DO CINV51DOutRec = null;
        CLSS24DO CLSS24DOutRec = null;
        CSES23DO CSES23DOutRec = null;
        CSES24DI CSES24DInRec = null;
        CSES24DO CSES24DOutRec = null;
        CSES32DO CSES32DOutRec = null;
        CSES34DO CSES34DOutRec = null;
        CSES35DO CSES35DOutRec = null;
        CSES38DO CSES38DOutRec = null;
        CSES64DI CSES64DInRec = null;
        CSES64DO CSES64DOutRec = null;
        CSES78DI CSES78DInRec = null;
        CSES78DO CSES78DOutRec = null;
        CSES44DO CSES44DOutRec = null;
        CCMNH9DO CCMNH9DOutRec = null;
        CLSS30DI CLSS30DI = null;
        CLSS30DO CLSS30DO = null;
        rc = ARC_PRFServiceStartTime_TUX(csub68si.getArchInputStruct());
        dtDtSystemDate.day = DateHelper.NULL_DATE;
        dtDtSystemDate.month = DateHelper.NULL_DATE;
        dtDtSystemDate.year = DateHelper.NULL_DATE;
        sztempCdStageOpen = CStringUtils.setCharAt(sztempCdStageOpen, 0, null);
        sztempCdStageClosureReason = CStringUtils.setCharAt(sztempCdStageClosureReason, 0, null);
        szCdPlocType1 = CStringUtils.setCharAt(szCdPlocType1, 0, null);
        sztempCdStageClosureReason = csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed();
        rc = ARC_UTLGetDateAndTime(dtDtSystemDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (TRUE_CHAR != csub68si.getBSysIndCase()) {
            if (0 != STAGE_FAM_REUN.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage()) && 0 != STAGE_FAM_SUBCARE.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage()) && (0 != CASE_REL_SPEC_REQ.substring(0, 2).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageType().substring(0, 2)) || 0 == STAGE_POST_ADOPT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage()))) {
                rc = Csys07s.CallCINV51D(csub68si, CINV51DOutRec, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        RetVal = SUCCESS;
                        ulTempIdPerson = CINV51DOutRec.getUlIdTodoPersAssigned();
                        break;
                    default :
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            if (SUCCESS == RetVal) {
                switch (csub68si.getROWCSUB68SIG01().getSzCdStage()[0]) {
                    case (SUBCARE):
                        if (0 != CASE_REL_SPEC_REQ.substring(0, 2).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageType().substring(0, 2))) {
                            rc = CallCSES38D(csub68si, CINV51DOutRec, CSES38DOutRec, dtDtSystemDate, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.ARC_SUCCESS:
                                    bFceEligEventExists = true;
                                    if ((DateHelper.NULL_DATE == CSES38DOutRec.getDtDtEligEnd().day && DateHelper.NULL_DATE == CSES38DOutRec.getDtDtEligEnd().month && DateHelper.NULL_DATE == CSES38DOutRec.getDtDtEligEnd().year) || (DateHelper.ARC_MAX_DAY == CSES38DOutRec.getDtDtEligEnd().day && DateHelper.ARC_MAX_MONTH == CSES38DOutRec.getDtDtEligEnd().month && DateHelper.ARC_MAX_YEAR == CSES38DOutRec.getDtDtEligEnd().year)) {
                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_A);
                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                    }
                                    RetVal = SUCCESS;
                                    break;
                                case NO_DATA_FOUND:
                                    RetVal = SUCCESS;
                                    break;
                                default :
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                            if (!bFceEligEventExists) {
                                CCMN87DInRec.setSzCdTask(FCE_ELIG_TASK);
                                CCMN87DInRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(FCE_ELIG_TYPE);
                                rc = CallCCMN87D(csub68si, CCMN87DInRec, CCMN87DOutRec, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        i = 0;
                                        for (RetVal = SUCCESS;(i < CCMN87DOutRec.getArchOutputStruct().getUlRowQty()) && (RetVal == SUCCESS);i++) {
                                            if (0 == CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus().compareTo(STATUS_COMPLETE)) {
                                                bFceEligEventExists = true;
                                            }
                                            else {
                                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_A);
                                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                            }
                                        }
                                        break;
                                    case NO_DATA_FOUND:
                                        break;
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                            if (SUCCESS == RetVal) {
                                rc = CallCSES34D(csub68si, CINV51DOutRec, CSES34DOutRec, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        if (SEC_POS_CLOSE_REAS_SIX == csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()[1] && DateHelper.NULL_DATE == CSES34DOutRec.getDtDtPlcmtEnd().day && 0 != ADOPTIVE_PLACEMENT.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr()) && 0 != PRIV_AGCY_ADPT_HM.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr())) {
                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_110);
                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                        }
                                        else if (DateHelper.NULL_DATE == CSES34DOutRec.getDtDtPlcmtEnd().day && 0 != ADOPTIVE_PLACEMENT.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr()) && 0 != PRIV_AGCY_ADPT_HM.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr()) && (0 == PLCMT_TYPE_PRS_CON.compareTo(CSES34DOutRec.getSzCdPlcmtType()) || 0 == PLCMT_TYPE_PRS_FAD.compareTo(CSES34DOutRec.getSzCdPlcmtType()) || 0 == PLCMT_TYPE_UNAUTH.compareTo(CSES34DOutRec.getSzCdPlcmtType()))) {
                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_C);
                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                        }
                                        RetVal = SUCCESS;
                                        break;
                                    case NO_DATA_FOUND:
                                        RetVal = SUCCESS;
                                        break;
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                            if (SUCCESS == RetVal) {
                                szCdPlocType1 = AUTHORIZED_LOC;
                                rc = CallCSES35D(csub68si, CINV51DOutRec, CSES35DOutRec, szCdPlocType1, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        bAlocEventExists = true;
                                        RetVal = SUCCESS;
                                        break;
                                    case NO_DATA_FOUND:
                                        bAlocEventExists = false;
                                        RetVal = SUCCESS;
                                        break;
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                            if (SUCCESS == RetVal) {
                                szCdPlocType1 = BILLING_LOC;
                                rc = CallCSES35D(csub68si, CINV51DOutRec, CSES35DOutRec, szCdPlocType1, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        bBlocEventExists = true;
                                        if ((DateHelper.NULL_DATE == CSES35DOutRec.getDtDtPlocEnd().day) && (DateHelper.NULL_DATE == CSES35DOutRec.getDtDtPlocEnd().month) && (DateHelper.NULL_DATE == CSES35DOutRec.getDtDtPlocEnd().year)) {
                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_B);
                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                        }
                                        RetVal = SUCCESS;
                                        break;
                                    case NO_DATA_FOUND:
                                        bBlocEventExists = false;
                                        RetVal = SUCCESS;
                                        break;
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                            if (SUCCESS == RetVal) {
                                rc = CallCLSS84D(csub68si, CLSS84DOutRec, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        bFPSPaidPlcmtExists = false;
                                        i = 0;
                                        for (RetVal = SUCCESS;(i < CLSS84DOutRec.getArchOutputStruct().getUlRowQty()) && (RetVal == SUCCESS);i++) {
                                            if (0 != CLSS84DOutRec.getROWCLSS84DO_ARRAY().getROWCLSS84DO(i).getSzCdPlcmtType().compareTo(PLCMT_TYPE_NON_FPS_PAID) && 0 != CLSS84DOutRec.getROWCLSS84DO_ARRAY().getROWCLSS84DO(i).getSzCdPlcmtType().compareTo(PLCMT_TYPE_NON_CERT_PERSON) && 0 != CLSS84DOutRec.getROWCLSS84DO_ARRAY().getROWCLSS84DO(i).getSzCdPlcmtType().compareTo(PLCMT_TYPE_UNAUTH)) {
                                                bFPSPaidPlcmtExists = true;
                                                break;
                                            }
                                        }
                                        break;
                                    case NO_DATA_FOUND:
                                        bFPSPaidPlcmtExists = false;
                                        break;
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                            if (SUCCESS == RetVal) {
                                if (bFPSPaidPlcmtExists) {
                                    if (!bAlocEventExists) {
                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_ALOC_REQ);
                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                    }
                                    if (!bBlocEventExists) {
                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_BLOC_REQ);
                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                    }
                                    if (!bFceEligEventExists) {
                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_FCE_REQ);
                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                    }
                                }
                            }
                            if (SUCCESS == RetVal) {
                                switch (csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()[1]) {
                                    case (SEC_POS_CLOSE_REAS_ONE):
                                    case (SEC_POS_CLOSE_REAS_TWO):
                                    case (SEC_POS_CLOSE_REAS_THREE):
                                    case (SEC_POS_CLOSE_REAS_EIGHT):
                                        rc = CallCSES32D(csub68si, CINV51DOutRec, CSES32DOutRec, pServiceStatus);
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                if ((0 != PRS_RESP_TERM.compareTo(CSES32DOutRec.getSzCdLegalStatStatus())) && ((0 == NON_SUIT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed())) || (0 == PMC_TO_OTHER.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed())))) {
                                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_020);
                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                }
                                                if ((0 != CVS_NOT_OBTAINED.compareTo(CSES32DOutRec.getSzCdLegalStatStatus())) && (0 == REAS_CVS_NOT_OBT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_030);
                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                }
                                                if ((0 != CHILD_EMANCIPATED.compareTo(CSES32DOutRec.getSzCdLegalStatStatus())) && (0 == REAS_EMANCIPATED.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_080);
                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                }
                                                RetVal = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_LEGAL_STAT_NOT_FOUND);
                                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                                RetVal = SUCCESS;
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                        break;
                                    case (SEC_POS_CLOSE_REAS_FOUR):
                                    case (SEC_POS_CLOSE_REAS_FIVE):
                                    case (SEC_POS_CLOSE_REAS_SEVEN):
                                        if ((0 != OWN_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr())) && (0 == REAS_OWN_HOME.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_040);
                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                        }
                                        if ((0 != RELATIVES_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr())) && ((0 != REAS_OWN_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtInfo1())) || (0 != REAS_OWN_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtInfo2())) || (0 != REAS_OWN_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtInfo3())) || (0 != REAS_OWN_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtInfo4())) || (0 != REAS_OWN_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtInfo5())) || (0 != REAS_OWN_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtInfo6())) || (0 != REAS_OWN_HOME.compareTo(CSES34DOutRec.getSzCdPlcmtInfo7()))) && (0 == REAS_REL_HOME.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_050);
                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                        }
                                        if ((0 != CHILD_RAN_AWAY.compareTo(CSES34DOutRec.getSzCdPlcmtRemovalRsn())) && (0 == REAS_RAN_AWAY.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_070);
                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                        }
                                        RetVal = SUCCESS;
                                        break;
                                    case (SEC_POS_CLOSE_REAS_SIX):
                                        rc = CallCMSC09D(csub68si, pServiceStatus);
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                RetVal = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_060);
                                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                                RetVal = SUCCESS;
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                        if (SUCCESS == RetVal) {
                                            if ((DateHelper.NULL_DATE != CSES34DOutRec.getDtDtPlcmtEnd().day) && (0 != ADOPTIVE_PLACEMENT.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr())) && (0 != PRIV_AGCY_ADPT_HM.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr()))) {
                                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_110);
                                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                            }
                                            RetVal = SUCCESS;
                                        }
                                        break;
                                    case (SEC_POS_CLOSE_REAS_NINE):
                                        rc = Csub31s.CallCCMN44D(csub68si, CINV51DOutRec, CCMN44DOutRec, pServiceStatus);
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                lRC = ARC_UTLCompareDateAndTime((FndInt3date) & dtDtSystemDate, (String) 0, (FndInt3date) & CCMN44DOutRec.getDtDtPersonBirth() , (String) 0);
                                                fYears = (lRC / YEAR_IN_MINS);
                                                if (fYears < 18) {
                                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_ADO_040);
                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                }
                                                RetVal = SUCCESS;
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                        break;
                                    case (SEC_POS_CLOSE_REAS_ZERO):
                                        rc = Csub31s.CallCCMN44D(csub68si, CINV51DOutRec, CCMN44DOutRec, pServiceStatus);
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                if ((DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().day) && (DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().month) && (DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().year)) {
                                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_100);
                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                }
                                                RetVal = SUCCESS;
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                        break;
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                            if (SUCCESS == RetVal && (!(REAS_RAN_AWAY.substring(0, 3).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed().substring(0, 3)) != 0) ||!(SUB_CHILD_DEATH.substring(0, 3).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed().substring(0, 3)) != 0) ||!(SUB_AGED_OUT.substring(0, 3).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed().substring(0, 3)) != 0))) {
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                if (0 == CSES32DOutRec.getUlIdLegalStatEvent()) {
                                    rc = CallCSES32D(csub68si, CINV51DOutRec, CSES32DOutRec, pServiceStatus);
                                }
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        if (PRS_RESP_TERM.compareTo(CSES32DOutRec.getSzCdLegalStatStatus()) != 0) {
                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_020);
                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                        }
                                        RetVal = SUCCESS;
                                        break;
                                    case NO_DATA_FOUND:
                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_LEGAL_STAT_NOT_FOUND);
                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                        RetVal = SUCCESS;
                                        break;
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                        }
                        break;
                    case (ADO_AOC):
                        if ((0 != CASE_REL_SPEC_REQ.substring(0, 2).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageType().substring(0, 2))) && (SUCCESS == RetVal)) {
                            switch (csub68si.getROWCSUB68SIG01().getSzCdStage()[1]) {
                                case (SEC_POS_CD_STAGE_O):
                                    break;
                                case (SEC_POS_CD_STAGE_D):
                                    if (!(REAS_AGED_OUT.substring(0, 3).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed().substring(0, 3)) != 0) ||!(REAS_CHILD_DEATH.substring(0, 3).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed().substring(0, 3)) != 0)) {
                                        rc = CallCSES32D(csub68si, CINV51DOutRec, CSES32DOutRec, pServiceStatus);
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                if (PRS_RESP_TERM.compareTo(CSES32DOutRec.getSzCdLegalStatStatus()) != 0) {
                                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_020);
                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                }
                                                RetVal = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_LEGAL_STAT_NOT_FOUND);
                                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                                RetVal = SUCCESS;
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                    }
                                    if (SUCCESS == RetVal) {
                                        switch (csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()[1]) {
                                            case (SEC_POS_CLOSE_REAS_ONE):
                                            case (SEC_POS_CLOSE_REAS_THREE):
                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                if (0 == CSES32DOutRec.getUlIdLegalStatEvent()) {
                                                    rc = CallCSES32D(csub68si, CINV51DOutRec, CSES32DOutRec, pServiceStatus);
                                                }
                                                switch (rc) {
                                                    case WtcHelperConstants.ARC_SUCCESS:
                                                        if ((0 != PRS_RESP_TERM.compareTo(CSES32DOutRec.getSzCdLegalStatStatus())) && (0 == ADO_PMC_TO_OTHER.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_ADO_030);
                                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                                        }
                                                        if ((0 != ADOPTION_CONSUM.compareTo(CSES32DOutRec.getSzCdLegalStatStatus())) && (0 == REAS_ADOPT_CONSUM.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_ADO_010);
                                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                                        }
                                                        RetVal = SUCCESS;
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_LEGAL_STAT_NOT_FOUND);
                                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                                        RetVal = SUCCESS;
                                                        break;
                                                    default :
                                                        RetVal = Csub50s.FND_FAIL;
                                                        break;
                                                }
                                                if ((0 == REAS_ADOPT_CONSUM.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed())) && (SUCCESS == RetVal)) {
                                                    rc = CallCSES34D(csub68si, CINV51DOutRec, CSES34DOutRec, pServiceStatus);
                                                    switch (rc) {
                                                        case WtcHelperConstants.ARC_SUCCESS:
                                                            if ((0 != ADOPTIVE_PLACEMENT.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr())) && (0 != PRIV_AGCY_ADPT_HM.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr())) || ((Arcutls.ARC_UTL_MAX_YEAR != CSES34DOutRec.getDtDtPlcmtEnd().year) && (DateHelper.NULL_DATE != CSES34DOutRec.getDtDtPlcmtEnd().year))) {
                                                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_ADO_060);
                                                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                                            }
                                                            RetVal = SUCCESS;
                                                            break;
                                                        case NO_DATA_FOUND:
                                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_PLCMT_NOT_FOUND);
                                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                                            RetVal = SUCCESS;
                                                            break;
                                                        default :
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                }
                                                break;
                                            case (SEC_POS_CLOSE_REAS_TWO):
                                                rc = CallCSES44D(csub68si, CINV51DOutRec, CSES44DOutRec, pServiceStatus);
                                                switch (rc) {
                                                    case WtcHelperConstants.ARC_SUCCESS:
                                                        if (0 != ADOPTION_DISRUPT.compareTo(CSES44DOutRec.getSzCdPlcmtRemovalRsn())) {
                                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_ADO_020);
                                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                                        }
                                                        RetVal = SUCCESS;
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_PLCMT_ADOPT_PLCMT_REQ);
                                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                                        RetVal = SUCCESS;

                                                        break;
                                                    default :
                                                        RetVal = Csub50s.FND_FAIL;
                                                        break;
                                                }
                                                if (SUCCESS == RetVal) {
                                                    rc = CallCSES21D(csub68si, CINV51DOutRec, pServiceStatus);
                                                    switch (rc) {
                                                        case WtcHelperConstants.ARC_SUCCESS:
                                                            RetVal = SUCCESS;
                                                            break;
                                                        case NO_DATA_FOUND:
                                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_SUB_NOT_FOUND);
                                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                                            RetVal = SUCCESS;
                                                            break;
                                                        default :
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                }
                                                break;
                                            case (SEC_POS_CLOSE_REAS_FOUR):
                                            case (SEC_POS_CLOSE_REAS_FIVE):
                                                rc = Csub31s.CallCCMN44D(csub68si, CINV51DOutRec, CCMN44DOutRec, pServiceStatus);
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        if ((DateHelper.NULL_DATE != CCMN44DOutRec.getDtDtPersonBirth().day) && (DateHelper.NULL_DATE != CCMN44DOutRec.getDtDtPersonBirth().month) && (DateHelper.NULL_DATE != CCMN44DOutRec.getDtDtPersonBirth().month)) {
                                                            lRC = ARC_UTLCompareDateAndTime((FndInt3date) & dtDtSystemDate, (String) 0, (FndInt3date) & CCMN44DOutRec.getDtDtPersonBirth() , (String) 0);
                                                            fYears = (lRC / YEAR_IN_MINS);
                                                        }
                                                        if ((fYears < 18) && (0 == REAS_AGED_OUT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed())) && (DateHelper.NULL_DATE != CCMN44DOutRec.getDtDtPersonBirth().day) && (DateHelper.NULL_DATE != CCMN44DOutRec.getDtDtPersonBirth().month) && (DateHelper.NULL_DATE != CCMN44DOutRec.getDtDtPersonBirth().month)) {
                                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_ADO_040);
                                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                                        }
                                                        if ((DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().day) && (DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().month) && (DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().year) && (0 == REAS_CHILD_DEATH.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                                                            csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_100);
                                                            csub68so.getArchOutputStruct().getUlRowQty()++;
                                                        }
                                                        RetVal = SUCCESS;
                                                        break;
                                                    default :
                                                        RetVal = Csub50s.FND_FAIL;
                                                        break;
                                                }
                                                break;
                                            case (SEC_POS_CLOSE_REAS_SIX):
                                                rc = CallCSES34D(csub68si, CINV51DOutRec, CSES34DOutRec, pServiceStatus);
                                                switch (rc) {
                                                    case WtcHelperConstants.ARC_SUCCESS:
                                                        if (0 == ADOPTIVE_PLACEMENT.compareTo(CSES34DOutRec.getSzCdPlcmtLivArr())) {
                                                            if (0 != (ARC_UTLCompareDateAndTime((FndInt3date) & CSES34DOutRec.getDtDtPlcmtStart() , 0, (FndInt3date) & CSES34DOutRec.getDtDtPlcmtEnd() , 0))) {
                                                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_ADO_070);
                                                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                                            }
                                                        }
                                                        RetVal = SUCCESS;
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        RetVal = SUCCESS;
                                                        break;
                                                    default :
                                                        RetVal = Csub50s.FND_FAIL;
                                                        break;
                                                }
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                        break;
                                    }
                                    break;
                                default :
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                        }
                        break;
                    case (POST_ADOPTION):
                        if (0 == PAD_CHILD_DEATH.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed())) {
                            rc = Csub31s.CallCCMN44D(csub68si, CINV51DOutRec, CCMN44DOutRec, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.ARC_SUCCESS:
                                    if ((DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().day) && (DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().month) && (DateHelper.NULL_DATE == CCMN44DOutRec.getDtDtPersonDeath().year)) {
                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_100);
                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                    }
                                    RetVal = SUCCESS;
                                    break;
                                default :
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                        }
                        if (0 == STAGE_POST_ADOPT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                            CCMN87DInRec.setSzCdTask(PAD_ADOPT_SUB);
                        }
                        else {
                            CCMN87DInRec.getSzCdTask()[0] = null;
                        }
                        CCMN87DInRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(ADOPT_SUBSIDY_TYPE);
                        rc = CallCCMN87D(csub68si, CCMN87DInRec, CCMN87DOutRec, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                i = 0;
                                for (RetVal = SUCCESS;(i < CCMN87DOutRec.getArchOutputStruct().getUlRowQty()) && (RetVal == SUCCESS);i++) {
                                    CSES64DInRec.setUlIdEvent(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getUlIdEvent());
                                    rc = CallCSES64D(csub68si, CSES64DInRec, CSES64DOutRec, pServiceStatus);
                                    switch (rc) {
                                        case WtcHelperConstants.ARC_SUCCESS:
                                            RetVal = SUCCESS;
                                            if (null == CSES64DOutRec.getSzCdAdptSubCloseRsn()[0]) {
                                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_PAD_A);
                                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                                RetVal = SUCCESS;
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            RetVal = SUCCESS;
                                            break;
                                        default :
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                }
                                break;
                            case NO_DATA_FOUND:
                                RetVal = SUCCESS;
                                break;
                            default :
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                        break;
                    case (FAMILY_STAGE):
                        rc = Csvc16s.CallCSESA3D(csub68si, CSESA3DOutRec, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                if (0 != strncmp(CSESA3DOutRec.getSzCdEventStatus() , STATUS_COMPLETE, STATUS_COMPLETE.length()) && (csub68si.getArchInputStruct().getUlSysNbrReserved1() != true || 0 != strncmp(CSESA3DOutRec.getSzCdEventStatus() , STATUS_PENDING, STATUS_PENDING.length()))) {
                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_INV_SVC_RFRL_CHKLST_WARNING);
                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                }
                                break;
                            case NO_DATA_FOUND:
                                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_INV_SVC_RFRL_CHKLST_WARNING);
                                csub68so.getArchOutputStruct().getUlRowQty()++;
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                break;
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        }
                        rc = Csvc16s.CallCSVC28D(csub68si, "PEND", csub68so, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                break;
                            case NO_DATA_FOUND:
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                break;
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        }
                        rc = Csvc16s.CallCCMNF6D(csub68si, CCMNF6DOutRec, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                i = 0;
                                bOtherFamOpen = false;
                                for (bSubStageOpen = false;((i < CCMNF6DOutRec.getArchOutputStruct().getUlRowQty()) && ((!bOtherFamOpen) || (!bSubStageOpen)));i++) {
                                    if (CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i).getUlIdStage() != csub68si.getROWCSUB68SIG01().getUlIdStage()) {
                                        if ((0 == CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i).getSzCdStage().compareTo(STAGE_FAM_REUN)) || (0 == CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i).getSzCdStage().compareTo(STAGE_FAM_SUBCARE))) {
                                            bOtherFamOpen = true;
                                        }
                                        if (0 == CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i).getSzCdStage().compareTo(STAGE_SUBCARE)) {
                                            bSubStageOpen = true;
                                        }
                                    }
                                }
                                RetVal = SUCCESS;
                                break;
                            case NO_DATA_FOUND:
                                RetVal = Csub50s.FND_FAIL;
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                rc = NO_DATA_FOUND;
                                break;
                            default :
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                        if ((SUCCESS == RetVal) && (!bOtherFamOpen)) {
                            rc = CallCCMNB9D(csub68si, CCMNB9DOutRec, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.ARC_SUCCESS:
                                    for (i = 0;i < CCMNB9DOutRec.getArchOutputStruct().getUlRowQty();++i) {
                                        if (0 == PRINCIPAL.compareTo(CCMNB9DOutRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i).getSzCdStagePersType())) {
                                            CSES78DInRec.setUlIdPerson(CCMNB9DOutRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i).getUlIdPerson());
                                            rc = CallCSES78D(csub68si, CSES78DInRec, CSES78DOutRec, pServiceStatus);
                                            switch (rc) {
                                                case WtcHelperConstants.ARC_SUCCESS:
                                                    if (((0 == LEGAL_STS_TYPE_ONE.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_TWO.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_EIGHT.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_ONE_THIRTY.compareTo(CSES78DOutRec.getSzCdLegalStatStatus()))) && ((0 != csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed().compareTo(REAS_PARENT_DEATH)) || (!bSubStageOpen))) {
                                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_FAM_010);
                                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                                    }
                                                    RetVal = SUCCESS;
                                                    break;
                                                case NO_DATA_FOUND:
                                                    RetVal = SUCCESS;
                                                    break;
                                                default :
                                                    RetVal = Csub50s.FND_FAIL;
                                                    break;
                                            }
                                            m = 0;
                                            for (bIndOpenSubAdo = false;(m < CCMNF6DOutRec.getArchOutputStruct().getUlRowQty()) && (!bIndOpenSubAdo);m++) {
                                                if ((0 == STAGE_ADOPTION.compareTo(CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(m).getSzCdStage())) || (0 == STAGE_SUBCARE.compareTo(CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(m).getSzCdStage()))) {
                                                    CINV39DInRec.setUlIdStage(CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(m).getUlIdStage());
                                                    CINV39DInRec.setUlIdPerson(CCMNB9DOutRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i).getUlIdPerson());
                                                    rc = CallCINV39D(csub68si, CINV39DInRec, CINV39DOutRec, pServiceStatus);
                                                    switch (rc) {
                                                        case WtcHelperConstants.ARC_SUCCESS:
                                                            if (0 == PRIMARY_CHILD.compareTo(CINV39DOutRec.getSzCdStagePersRole())) {
                                                                bIndOpenSubAdo = true;
                                                            }
                                                            RetVal = SUCCESS;
                                                            break;
                                                        default :
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                }
                                            }
                                            if ((0 == LEGAL_STS_TYPE_THREE.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_FOUR.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_FIVE.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_SIX.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_SEVEN.compareTo(CSES78DOutRec.getSzCdLegalStatStatus()))) {
                                                if (!bIndOpenSubAdo) {
                                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_FAM_020);
                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case NO_DATA_FOUND:
                                    RetVal = Csub50s.FND_FAIL;
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                    rc = NO_DATA_FOUND;
                                    break;
                                default :
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                        }
                        break;
                    default :
                        break;
                }
            }
            if ((SUCCESS == RetVal) && (!bOtherFamOpen)) {
                rc = Csvc16s.CallCCMNF6D(csub68si, CCMNF6DOutRec, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        i = 0;
                        for (bOtherFamOpen = false;(i < CCMNF6DOutRec.getArchOutputStruct().getUlRowQty() &&!bOtherFamOpen);++i) {
                            if ((CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i).getUlIdStage() != csub68si.getROWCSUB68SIG01().getUlIdStage()) && ((0 == CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i).getSzCdStage().compareTo(STAGE_FAM_REUN)) || (0 == CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i).getSzCdStage().compareTo(STAGE_FAM_SUBCARE)) || (0 == CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i).getSzCdStage().compareTo(STAGE_FAM_PRES)))) {
                                bOtherFamOpen = true;
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        RetVal = Csub50s.FND_FAIL;
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                        rc = NO_DATA_FOUND;
                        break;
                    default :
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            if (SUCCESS == RetVal) {
                if (0 == STAGE_AOC.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                    CCMN87DInRec.setSzCdTask(AOC_SVC_AUTH);
                }
                else if (0 == STAGE_SUBCARE.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                    CCMN87DInRec.setSzCdTask(SUB_SVC_AUTH);
                }
                else if (0 == STAGE_ADOPTION.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                    CCMN87DInRec.setSzCdTask(ADO_SVC_AUTH);
                }
                else if (0 == STAGE_POST_ADOPT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                    CCMN87DInRec.setSzCdTask(PAD_SVC_AUTH);
                }
                else if (0 == STAGE_FAM_SUBCARE.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                    CCMN87DInRec.setSzCdTask(FSU_SVC_AUTH);
                }
                else if (0 == STAGE_FAM_REUN.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                    CCMN87DInRec.setSzCdTask(FRE_SVC_AUTH);
                }
                else {
                    CCMN87DInRec.getSzCdTask()[0] = null;
                }
                CCMN87DInRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SERVICE_AUTH_TYPE);
                rc = CallCCMN87D(csub68si, CCMN87DInRec, CCMN87DOutRec, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        RetVal = SUCCESS;
                        i = 0;
                        for (bIndSvcOpen = false;i < CCMN87DOutRec.getArchOutputStruct().getUlRowQty() && false == bIndSvcOpen;i++) {
                            if ((0 == CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventType().compareTo(SERVICE_AUTH_TYPE)) && (((0 != CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus().compareTo(STATUS_NEW)) && (0 != CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus().compareTo(STATUS_PROCESS))) || (0 == CAPS_PROG_APS.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageProgram())))) {
                                CSES24DInRec.setUlIdSvcAuthEvent(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getUlIdEvent());
                                rc = Csvc16s.CallCSES24D(csub68si, CSES24DInRec, CSES24DOutRec, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        rc = CallCSES23D(csub68si, CSES24DOutRec, CSES23DOutRec, pServiceStatus);
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                RetVal = SUCCESS;
                                                if (FND_YES == CSES23DOutRec.getCIndSvcAuthComplete()) {
                                                    rc = CallCLSS24D(csub68si, CSES24DOutRec, CLSS24DOutRec, pServiceStatus);
                                                    switch (rc) {
                                                        case WtcHelperConstants.ARC_SUCCESS:
                                                            RetVal = SUCCESS;
                                                            break;
                                                        default :
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                    m = 0;
                                                    for (bIndSvcOpen = false;m < CLSS24DOutRec.getArchOutputStruct().getUlRowQty() && false == bIndSvcOpen && SUCCESS == RetVal;m++) {
                                                        if ((0 > (ARC_UTLCompareDateAndTime((FndInt3date) & dtDtSystemDate, 0, (FndInt3date) & CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getDtDtSvcAuthDtlTerm() , 0))) && ((0 == STATUS_PENDING.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus())) || (0 == STATUS_COMPLETE.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus())) || (0 == STATUS_APPROVED.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus())))) {
                                                            if (0 == STATUS_APPROVED.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus()) && 0 != FORMER_DAY_CARE.compareTo(CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc())) {
                                                                bSvcAuthsToProgress = true;
                                                            }
                                                            switch (csub68si.getROWCSUB68SIG01().getSzCdStage()[0]) {
                                                                case SUBCARE:
                                                                    if (0 != STATUS_APPROVED.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus()) || (false == bOtherFamOpen && 0 != FORMER_DAY_CARE.compareTo(CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc()))) {
                                                                        bIndSvcOpen = true;
                                                                    }
                                                                    break;
                                                                case ADO_AOC:
                                                                    if (0 == STAGE_AOC.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                                                        if (0 != STATUS_APPROVED.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus()) && 0 != STATUS_COMPLETE.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus())) {
                                                                            bIndSvcOpen = true;
                                                                        }
                                                                    }
                                                                    else if (0 == STAGE_ADOPTION.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                                                        if (0 != ADOPT_DISRUPTION.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()) || 0 != STATUS_APPROVED.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus())) {
                                                                            bIndSvcOpen = true;
                                                                        }
                                                                    }
                                                                    break;
                                                                case FAMILY_STAGE:
                                                                    if (0 != STATUS_APPROVED.compareTo(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus()) || (false == bOtherFamOpen && 0 != FORMER_DAY_CARE.compareTo(CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc()))) {
                                                                        bIndSvcOpen = true;
                                                                    }
                                                                    break;
                                                                default :
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                }
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                        break;
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        RetVal = SUCCESS;
                        break;
                    default :
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            if (!bIndSvcOpen && bSvcAuthsToProgress) {
                CLSS30DI.setArchInputStruct(csub68si.getArchInputStruct());
                CLSS30DI.setUlIdCase(csub68si.getROWCSUB68SIG01().getUlIdCase());
                rc = Csvc16s.CallCLSS30D(CLSS30DI, CLSS30DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                for (int j = 0;j < CLSS30DO.getArchOutputStruct().getUlRowQty() && bEligibleStageFound == false;j++) {
                    if (((DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year && DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().day && DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().month) || DateHelper.ARC_MAX_YEAR == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year) && CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getUlIdStage() != csub68si.getROWCSUB68SIG01().getUlIdStage()) {
                        lRC = ARC_UTLCompareDateAndTime((FndInt3date) & DtTempStageStart, (String) 0, (FndInt3date) & CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageStart() , (String) 0);
                        if ((lRC < 0) && ((0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(PREP_ADULT)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ARI_STAGE)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(STAGE_SUBCARE)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(INVESTIGATION1)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ADOPTION1)))) {
                            bEligibleStageFound = true;
                        }
                        else if ((lRC == 0) && ((0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(PREP_ADULT)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ARI_STAGE)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(STAGE_SUBCARE)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ADOPTION1)))) {
                            for (i = 0;i < CLSS30DO.getArchOutputStruct().getUlRowQty();i++) {
                                if (((DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year) && (DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().day) && (DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().month)) || (DateHelper.ARC_MAX_YEAR == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year)) {
                                    if (0 == FPR_PROGRAM.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStage())) {
                                        bEligibleStageFound = true;
                                    }
                                    else if (0 == FSU_PROGRAM.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStage())) {
                                        bEligibleStageFound = true;
                                    }
                                    else if (0 == FRE_PROGRAM.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStage())) {
                                        bEligibleStageFound = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!bEligibleStageFound) {
                    bIndSvcOpen = true;
                }
            }
            if (bIndSvcOpen) {
                csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_SVA_OPN_AUTHS);
                csub68so.getArchOutputStruct().getUlRowQty()++;
                RetVal = SUCCESS;
            }
            if ((SUCCESS == RetVal) && (0 == csub68so.getArchOutputStruct().getUlRowQty())) {
                if ((0 == STAGE_ADOPTION.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) && (0 == REAS_ADOPT_CONSUM.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageReasonClosed()))) {
                    CSES64DInRec.setUlIdEvent(csub68si.getROWCSUB68SIG00().getUlIdEvent());
                    rc = CallCSES64D(csub68si, CSES64DInRec, CSES64DOutRec, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            RetVal = SUCCESS;
                            csub68si.getROWCSUB68SIG01().setSzCdStageReasonClosed(STAGE_POST_ADOPT);
                            break;
                        case NO_DATA_FOUND:
                            RetVal = SUCCESS;
                            break;
                        default :
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
                if (SUCCESS == RetVal) {
                    rc = CallCCMNB8D(csub68si, CCMNB8DOutRec, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            csub68si.setBIndStageClose(CCMNB8DOutRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getBIndStageProgClose());
                            sztempCdStageClosureReason = CCMNB8DOutRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgRsnClosed();
                            sztempCdStageOpen = CCMNB8DOutRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgOpen();
                            RetVal = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            RetVal = Csub50s.FND_FAIL;
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                            rc = NO_DATA_FOUND;
                            break;
                        default :
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                    if ((SUCCESS == RetVal) && (CLOSE_OPEN_STAGE != CCMNB8DOutRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getBIndStageProgClose())) {
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        if (0 == CCMNF6DOutRec.getArchOutputStruct().getUlRowQty()) {
                            rc = Csvc16s.CallCCMNF6D(csub68si, CCMNF6DOutRec, pServiceStatus);
                        }
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                RetVal = SUCCESS;
                                if ((1 == CCMNF6DOutRec.getArchOutputStruct().getUlRowQty()) && (CCMNF6DOutRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(0).getUlIdStage() == csub68si.getROWCSUB68SIG01().getUlIdStage())) {
                                    if (0 == Csub38s.CAPS_PROG_CPS.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageProgram())) {
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                        if (0 != CASE_REL_SPEC_REQ.substring(0, 2).compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageType().substring(0, 2))) {
                                            rc = CallCCMNH9D(csub68si, CCMNH9DOutRec, pServiceStatus);
                                        }
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                RetVal = SUCCESS;
                                                i = 0;
                                                for (bCaseLegalStsFound = false;(i < CCMNH9DOutRec.getArchOutputStruct().getUlRowQty()) && (!bCaseLegalStsFound) && (SUCCESS == RetVal);++i) {
                                                    if (0 != STAFF.compareTo(CCMNH9DOutRec.getROWCCMNH9DO_ARRAY().getROWCCMNH9DO(i).getSzCdStagePersType())) {
                                                        CSES78DInRec.setUlIdPerson(CCMNH9DOutRec.getROWCCMNH9DO_ARRAY().getROWCCMNH9DO(i).getUlIdPerson());
                                                        rc = CallCSES78D(csub68si, CSES78DInRec, CSES78DOutRec, pServiceStatus);
                                                        switch (rc) {
                                                            case WtcHelperConstants.ARC_SUCCESS:
                                                                if ((0 == LEGAL_STS_TYPE_ONE.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_TWO.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_THREE.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_FOUR.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_FIVE.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_SIX.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_SEVEN.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_EIGHT.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_ONE_THIRTY.compareTo(CSES78DOutRec.getSzCdLegalStatStatus())) || (0 == LEGAL_STS_TYPE_ONE_FOURTY.compareTo(CSES78DOutRec.getSzCdLegalStatStatus()))) {
                                                                    if (0 == STAGE_POST_ADOPT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_TERM_LEGAL_STAT_REQ);
                                                                    }
                                                                    else {
                                                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_STG_CLOS_SUB_010);
                                                                    }
                                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                                    bCaseLegalStsFound = true;
                                                                }
                                                                RetVal = SUCCESS;
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                RetVal = SUCCESS;
                                                                break;
                                                            default :
                                                                RetVal = Csub50s.FND_FAIL;
                                                                break;
                                                        }
                                                    }
                                                }
                                                break;
                                            case NO_DATA_FOUND:
                                                if (0 != STAGE_POST_ADOPT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                                    csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_LEGAL_STAT_NOT_FOUND);
                                                    csub68so.getArchOutputStruct().getUlRowQty()++;
                                                }
                                                RetVal = SUCCESS;
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                    }
                                    if (SUCCESS == RetVal) {
                                        if (0 == STAGE_AOC.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                            CCMN87DInRec.setSzCdTask(AOC_SVC_AUTH);
                                        }
                                        else if (0 == STAGE_SUBCARE.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                            CCMN87DInRec.setSzCdTask(SUB_SVC_AUTH);
                                        }
                                        else if (0 == STAGE_ADOPTION.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                            CCMN87DInRec.setSzCdTask(ADO_SVC_AUTH);
                                        }
                                        else if (0 == STAGE_POST_ADOPT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                            CCMN87DInRec.setSzCdTask(PAD_SVC_AUTH);
                                        }
                                        else if (0 == STAGE_FAM_SUBCARE.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                            CCMN87DInRec.setSzCdTask(FSU_SVC_AUTH);
                                        }
                                        else if (0 == STAGE_FAM_REUN.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage())) {
                                            CCMN87DInRec.setSzCdTask(FRE_SVC_AUTH);
                                        }
                                        else {
                                            CCMN87DInRec.getSzCdTask()[0] = null;
                                        }
                                        CCMN87DInRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SERVICE_AUTH_TYPE);
                                        rc = CallCCMN87D(csub68si, CCMN87DInRec, CCMN87DOutRec, pServiceStatus);
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                i = 0;
                                                bIndSvcOpen = false;
                                                for (RetVal = SUCCESS;(i < CCMN87DOutRec.getArchOutputStruct().getUlRowQty()) && (!bIndSvcOpen) && (SUCCESS == RetVal);i++) {
                                                    if ((0 != CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus().compareTo(STATUS_NEW)) && (0 != CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventStatus().compareTo(STATUS_PROCESS)) && (0 == CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getSzCdEventType().compareTo(SERVICE_AUTH_TYPE))) {
                                                        CSES24DInRec.setUlIdSvcAuthEvent(CCMN87DOutRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i).getUlIdEvent());
                                                        rc = Csvc16s.CallCSES24D(csub68si, CSES24DInRec, CSES24DOutRec, pServiceStatus);
                                                        switch (rc) {
                                                            case WtcHelperConstants.ARC_SUCCESS:
                                                                RetVal = SUCCESS;
                                                                rc = CallCSES23D(csub68si, CSES24DOutRec, CSES23DOutRec, pServiceStatus);
                                                                switch (rc) {
                                                                    case WtcHelperConstants.ARC_SUCCESS:
                                                                        RetVal = SUCCESS;
                                                                        if (FND_YES == CSES23DOutRec.getCIndSvcAuthComplete()) {
                                                                            rc = CallCLSS24D(csub68si, CSES24DOutRec, CLSS24DOutRec, pServiceStatus);
                                                                            switch (rc) {
                                                                                case WtcHelperConstants.ARC_SUCCESS:
                                                                                    m = 0;
                                                                                    for (RetVal = SUCCESS;(m < CLSS24DOutRec.getArchOutputStruct().getUlRowQty()) && (!bIndSvcOpen);m++) {
                                                                                        if ((0 > ARC_UTLCompareDateAndTime((FndInt3date) & dtDtSystemDate, 0, (FndInt3date) & CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getDtDtSvcAuthDtlTerm() , 0)) && (0 != CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc().compareTo(DAY_CARE)) && (0 != CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc().compareTo(FORMER_DAY_CARE)) && (0 != CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc().compareTo(GENERAL_PROT_CARE)) && (0 != CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc().compareTo(IVE_FC_DAY_CARE)) && (0 != CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc().compareTo(REGISTERED_FAMILY_HM)) && (0 != CLSS24DOutRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc().compareTo(STATE_PAID_FC_DAY_CARE))) {
                                                                                            bIndSvcOpen = true;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                default :
                                                                                    RetVal = Csub50s.FND_FAIL;
                                                                                    break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    default :
                                                                        RetVal = Csub50s.FND_FAIL;
                                                                        break;
                                                                }
                                                                break;
                                                            default :
                                                                RetVal = Csub50s.FND_FAIL;
                                                                break;
                                                        }
                                                    }
                                                }
                                                break;
                                            case NO_DATA_FOUND:
                                                RetVal = SUCCESS;
                                                break;
                                            default :
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                    }
                                    if (bIndSvcOpen) {
                                        csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(csub68so.getArchOutputStruct().getUlRowQty() , Messages.MSG_SVA_OPN_AUTHS);
                                        csub68so.getArchOutputStruct().getUlRowQty()++;
                                        RetVal = SUCCESS;
                                    }
                                    if (bCaseLegalStsFound) {
                                        RetVal = Csub50s.FND_FAIL;
                                        rc = Csub50s.FND_FAIL;
                                    }
                                    if ((0 == csub68so.getArchOutputStruct().getUlRowQty()) && (SUCCESS == RetVal)) {
                                        pServiceStatus.severity = FND_SEVERITY_WARNING;
                                        pServiceStatus.explan_code = Messages.MSG_SUB_CLOSE_CASE;
                                        RetVal = Csub50s.FND_FAIL;
                                        rc = Csub50s.FND_FAIL;
                                    }
                                }
                                break;
                            default :
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                }
            }
            if (csub68so.getArchOutputStruct().getUlRowQty() > 0) {
                csub68so.getArchOutputStruct().setUlRowQty((int) csub68so.getArchOutputStruct().getUlRowQty());
                RetVal = Csub50s.FND_FAIL;
                rc = WtcHelperConstants.ARC_SUCCESS;
            }
        }
        if ((SUCCESS == RetVal) && (0 == csub68so.getArchOutputStruct().getUlRowQty())) {
            rc = CallCAUD47D(csub68si, sztempCdStageClosureReason, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    RetVal = SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    RetVal = Csub50s.FND_FAIL;
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    rc = NO_DATA_FOUND;
                    break;
                default :
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
            if ((0 < csub68si.getROWCSUB68SIG00().getUlIdEvent()) && (SUCCESS == RetVal)) {
                rc = CallCINV43D(csub68si, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        RetVal = SUCCESS;
                        break;
                    default :
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            if (false == csub68si.getArchInputStruct().getUlSysNbrReserved1()) {
                if ((SUCCESS == RetVal) && (0 == STATUS_PENDING.compareTo(csub68si.getROWCSUB68SIG00().getSzCdEventStatus_ARRAY().getSzCdEventStatus(CURRENT)))) {
                    rc = CallInvalidateAprvl(csub68si, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            RetVal = SUCCESS;
                            break;
                        default :
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
                rc = Csvc14s.CallPostEvent(csub68si, dtDtSystemDate, csub68so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    default :
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            if ((SUCCESS == RetVal) && ((0 == CAPS_PROG_APS.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStageProgram())) || (0 == STAGE_POST_ADOPT.compareTo(csub68si.getROWCSUB68SIG01().getSzCdStage()))) && (DateHelper.NULL_DATE != csub68si.getROWCSUB68SIG01().getDtDtStageClose().day) && (DateHelper.NULL_DATE != csub68si.getROWCSUB68SIG01().getDtDtStageClose().month) && (DateHelper.NULL_DATE != csub68si.getROWCSUB68SIG01().getDtDtStageClose().year)) {
                if ((CLOSE_OPEN_STAGE == csub68si.getBIndStageClose()) || (OPEN_STAGE == csub68si.getBIndStageClose())) {
                    rc = CallCloseOpenStage(csub68si, dtDtSystemDate, sztempCdStageClosureReason, sztempCdStageOpen, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            RetVal = SUCCESS;
                            break;
                        default :
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
                else {
                    rc = CallCloseStageCase(csub68si, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            RetVal = SUCCESS;
                            break;
                        default :
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
            }
        }
        ARC_PRFServiceStopTime_TUX(csub68si.getArchInputStruct() , csub68so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csub68so;
    }

    static int CallCSESA3D(CSUB68SI pInputMsg16, CSESA3DO pOutputMsg14, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSESA3DI pCSESA3DInputRec = null;
        CSESA3DO pCSESA3DOutputRec = null;
        pCSESA3DInputRec = new CSESA3DI();
        pCSESA3DOutputRec = new CSESA3DO();
        pCSESA3DInputRec.setUlIdStage(pInputMsg16.getROWCSUB68SIG01().getUlIdStage());
        pCSESA3DInputRec.setSzCdEventType(SVC_REF_CHKLST_EVENT_TYPE);
        if (0 == STAGE_FAM_REUN.compareTo(pInputMsg16.getROWCSUB68SIG01().getSzCdStage())) {
            pCSESA3DInputRec.setSzCdTask(SVC_REF_CHKLST_FRE_TASK);
        }
        else if (0 == STAGE_FAM_SUBCARE.compareTo(pInputMsg16.getROWCSUB68SIG01().getSzCdStage())) {
            pCSESA3DInputRec.setSzCdTask(SVC_REF_CHKLST_FSU_TASK);
        }
        pCSESA3DInputRec.setArchInputStruct(pInputMsg16.getArchInputStruct());
        rc = csesa3dQUERYdam(sqlca, pCSESA3DInputRec, pCSESA3DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg14 = pCSESA3DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSS84D(CSUB68SI pInputMsg17, CLSS84DO pOutputMsg15, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CLSS84DI pCLSS84DInputRec = null;
        CLSS84DO pCLSS84DOutputRec = null;
        pCLSS84DInputRec = new CLSS84DI();
        pCLSS84DOutputRec = new CLSS84DO();
        pCLSS84DInputRec.setArchInputStruct(pInputMsg17.getArchInputStruct());
        pCLSS84DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSS84DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NBR);
        pCLSS84DInputRec.setUlIdStage(pInputMsg17.getROWCSUB68SIG01().getUlIdStage());
        rc = clss84dQUERYdam(sqlca, pCLSS84DInputRec, pCLSS84DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg15 = pCLSS84DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINV51D(CSUB68SI pInputMsg18, CINV51DO pOutputMsg16, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        pCINV51DInputRec = new CINV51DI();
        pCINV51DOutputRec = new CINV51DO();
        pCINV51DInputRec.setArchInputStruct(pInputMsg18.getArchInputStruct());
        pCINV51DInputRec.setUlIdStage(pInputMsg18.getROWCSUB68SIG01().getUlIdStage());
        if (0 == Csub38s.CAPS_PROG_CPS.compareTo(pInputMsg18.getROWCSUB68SIG01().getSzCdStageProgram())) {
            pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
        }
        else {
            pCINV51DInputRec.setSzCdStagePersRole(CLIENT);
        }
        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg16.setUlIdTodoPersAssigned(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES38D(CSUB68SI pInputMsg19, CINV51DO pDamMsg, CSES38DO pOutputMsg17, FndInt3date dtDtSystemDate, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES38DI pCSES38DInputRec = null;
        CSES38DO pCSES38DOutputRec = null;
        pCSES38DInputRec = new CSES38DI();
        pCSES38DOutputRec = new CSES38DO();
        pCSES38DInputRec.setArchInputStruct(pInputMsg19.getArchInputStruct());
        pCSES38DInputRec.setUlIdPerson(pDamMsg.getUlIdTodoPersAssigned());
        pCSES38DInputRec.setDtScrDtCurrentDate(dtDtSystemDate);
        rc = cses38dQUERYdam(sqlca, pCSES38DInputRec, pCSES38DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg17 = pCSES38DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES34D(CSUB68SI pInputMsg20, CINV51DO pDamMsg, CSES34DO pOutputMsg18, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES34DI pCSES34DInputRec = null;
        CSES34DO pCSES34DOutputRec = null;
        pCSES34DInputRec = new CSES34DI();
        pCSES34DOutputRec = new CSES34DO();
        pCSES34DInputRec.setArchInputStruct(pInputMsg20.getArchInputStruct());
        pCSES34DInputRec.setUlIdPlcmtChild(pDamMsg.getUlIdTodoPersAssigned());
        rc = cses34dQUERYdam(sqlca, pCSES34DInputRec, pCSES34DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg18 = pCSES34DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES35D(CSUB68SI pInputMsg21, CINV51DO pDamMsg, CSES35DO pOutputMsg19, String szCdPlocType2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES35DI pCSES35DInputRec = null;
        CSES35DO pCSES35DOutputRec = null;
        pCSES35DInputRec = new CSES35DI();
        pCSES35DOutputRec = new CSES35DO();
        pCSES35DInputRec.setArchInputStruct(pInputMsg21.getArchInputStruct());
        pCSES35DInputRec.setUlIdPerson(pDamMsg.getUlIdTodoPersAssigned());
        pCSES35DInputRec.setSzCdPlocType(szCdPlocType2);
        rc = cses35dQUERYdam(sqlca, pCSES35DInputRec, pCSES35DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg19 = pCSES35DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES32D(CSUB68SI pInputMsg22, CINV51DO pDamMsg, CSES32DO pOutputMsg20, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES32DI pCSES32DInputRec = null;
        CSES32DO pCSES32DOutputRec = null;
        pCSES32DInputRec = new CSES32DI();
        pCSES32DOutputRec = new CSES32DO();
        pCSES32DInputRec.setArchInputStruct(pInputMsg22.getArchInputStruct());
        pCSES32DInputRec.setUlIdPerson(pDamMsg.getUlIdTodoPersAssigned());
        rc = cses32dQUERYdam(sqlca, pCSES32DInputRec, pCSES32DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg20 = pCSES32DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCMSC09D(CSUB68SI pInputMsg23, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CMSC09DI pCMSC09DInputRec = null;
        CMSC09DO pCMSC09DOutputRec = null;
        pCMSC09DInputRec = new CMSC09DI();
        pCMSC09DOutputRec = new CMSC09DO();
        pCMSC09DInputRec.setArchInputStruct(pInputMsg23.getArchInputStruct());
        pCMSC09DInputRec.setUlIdCase(pInputMsg23.getROWCSUB68SIG01().getUlIdCase());
        pCMSC09DInputRec.setUlIdStage(pInputMsg23.getROWCSUB68SIG01().getUlIdStage());
        pCMSC09DInputRec.setSzCdStage(STAGE_ADOPTION);
        rc = cmsc09dQUERYdam(sqlca, pCMSC09DInputRec, pCMSC09DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                if (0 == pCMSC09DOutputRec.getUlSysNbrGenericCntr()) {
                    rc = NO_DATA_FOUND;
                }
                else {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN44D(CSUB68SI pInputMsg24, CINV51DO pDamMsg, CCMN44DO pOutputMsg21, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        pCCMN44DInputRec = new CCMN44DI();
        pCCMN44DOutputRec = new CCMN44DO();
        pCCMN44DInputRec.setArchInputStruct(pInputMsg24.getArchInputStruct());
        pCCMN44DInputRec.setUlIdPerson(pDamMsg.getUlIdTodoPersAssigned());
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg21 = pCCMN44DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }//##  return RetVal;
    static int CallCSES21D(CSUB68SI pInputMsg25, CINV51DO pDamMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES21DI pCSES21DInputRec = null;
        CSES21DO pCSES21DOutputRec = null;
        pCSES21DInputRec = new CSES21DI();
        pCSES21DOutputRec = new CSES21DO();
        pCSES21DInputRec.setArchInputStruct(pInputMsg25.getArchInputStruct());
        pCSES21DInputRec.setUlIdPerson(pDamMsg.getUlIdTodoPersAssigned());
        pCSES21DInputRec.setUlIdStage(pInputMsg25.getROWCSUB68SIG01().getUlIdStage());
        pCSES21DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
        rc = cses21dQUERYdam(sqlca, pCSES21DInputRec, pCSES21DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                if (0 == pCSES21DOutputRec.getUlSysNbrUlongKey()) {
                    rc = NO_DATA_FOUND;
                }
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN87D(CSUB68SI pInputMsg26, CCMN87DI pDamInMsg, CCMN87DO pOutputMsg22, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        pCCMN87DInputRec = new CCMN87DI();
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg26.getArchInputStruct());
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN87DInputRec.setUlIdStage(pInputMsg26.getROWCSUB68SIG01().getUlIdStage());
        if (null != pDamInMsg.getSzCdTask()[0]) {
            pCCMN87DInputRec.setSzCdTask(pDamInMsg.getSzCdTask());
        }
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(pDamInMsg.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).getSzCdEventType());
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg22 = pCCMN87DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES64D(CSUB68SI pInputMsg27, CSES64DI pDamInMsg, CSES64DO pOutputMsg23, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES64DI pCSES64DInputRec = null;
        CSES64DO pCSES64DOutputRec = null;
        pCSES64DInputRec = new CSES64DI();
        pCSES64DOutputRec = new CSES64DO();
        pCSES64DInputRec.setArchInputStruct(pInputMsg27.getArchInputStruct());
        pCSES64DInputRec.setUlIdEvent(pDamInMsg.getUlIdEvent());
        rc = cses64dQUERYdam(sqlca, pCSES64DInputRec, pCSES64DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg23 = pCSES64DOutputRec;
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNF6D(CSUB68SI pInputMsg28, CCMNF6DO pOutputMsg24, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMNF6DI pCCMNF6DInputRec = null;
        CCMNF6DO pCCMNF6DOutputRec = null;
        pCCMNF6DInputRec = new CCMNF6DI();
        pCCMNF6DOutputRec = new CCMNF6DO();
        pCCMNF6DInputRec.setArchInputStruct(pInputMsg28.getArchInputStruct());
        pCCMNF6DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNF6DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NBR);
        pCCMNF6DInputRec.setUlIdCase(pInputMsg28.getROWCSUB68SIG01().getUlIdCase());
        rc = ccmnf6dQUERYdam(sqlca, pCCMNF6DInputRec, pCCMNF6DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg24 = pCCMNF6DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNB9D(CSUB68SI pInputMsg29, CCMNB9DO pOutputMsg25, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;//## BEGIN TUX/XML: Turn the XML buffer into an input message struct
        CCMNB9DI pCCMNB9DInputRec = null;
        CCMNB9DO pCCMNB9DOutputRec = null;
        pCCMNB9DInputRec = new CCMNB9DI();
        pCCMNB9DOutputRec = new CCMNB9DO();
        pCCMNB9DInputRec.setArchInputStruct(pInputMsg29.getArchInputStruct());
        pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NBR);
        pCCMNB9DInputRec.setUlIdStage(pInputMsg29.getROWCSUB68SIG01().getUlIdStage());
        rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg25 = pCCMNB9DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES78D(CSUB68SI pInputMsg30, CSES78DI pDamMsg, CSES78DO pOutputMsg26, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES78DI pCSES78DInputRec = null;
        CSES78DO pCSES78DOutputRec = null;
        pCSES78DInputRec = new CSES78DI();
        pCSES78DOutputRec = new CSES78DO();
        pCSES78DInputRec.setArchInputStruct(pInputMsg30.getArchInputStruct());
        pCSES78DInputRec.setUlIdPerson(pDamMsg.getUlIdPerson());
        pCSES78DInputRec.setUlIdCase(pInputMsg30.getROWCSUB68SIG01().getUlIdCase());
        rc = cses78dQUERYdam(sqlca, pCSES78DInputRec, pCSES78DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg26 = pCSES78DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINV39D(CSUB68SI pInputMsg31, CINV39DI pDamMsg, CINV39DO pOutputMsg27, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CINV39DI pCINV39DInputRec = null;
        CINV39DO pCINV39DOutputRec = null;
        pCINV39DInputRec = new CINV39DI();
        pCINV39DOutputRec = new CINV39DO();
        pCINV39DInputRec.setArchInputStruct(pInputMsg31.getArchInputStruct());
        pCINV39DInputRec.setUlIdPerson(pDamMsg.getUlIdPerson());
        pCINV39DInputRec.setUlIdStage(pDamMsg.getUlIdStage());
        rc = cinv39dQUERYdam(sqlca, pCINV39DInputRec, pCINV39DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg27 = pCINV39DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES24D(CSUB68SI pInputMsg32, CSES24DI pDamMsg, CSES24DO pOutputMsg28, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES24DI pCSES24DInputRec = null;
        CSES24DO pCSES24DOutputRec = null;
        pCSES24DInputRec = new CSES24DI();
        pCSES24DOutputRec = new CSES24DO();
        pCSES24DInputRec.setArchInputStruct(pInputMsg32.getArchInputStruct());
        pCSES24DInputRec.setUlIdSvcAuthEvent(pDamMsg.getUlIdSvcAuthEvent());
        rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg28 = pCSES24DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES23D(CSUB68SI pInputMsg33, CSES24DO pDamMsg, CSES23DO pOutputMsg29, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;//## BEGIN TUX/XML: Turn the XML buffer into an input message struct 
        CSES23DI pCSES23DInputRec = null;
        CSES23DO pCSES23DOutputRec = null;
        pCSES23DInputRec = new CSES23DI();
        pCSES23DOutputRec = new CSES23DO();
        pCSES23DInputRec.setArchInputStruct(pInputMsg33.getArchInputStruct());
        pCSES23DInputRec.setUlIdSvcAuth(pDamMsg.getUlIdSvcAuth());
        rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg29 = pCSES23DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSS24D(CSUB68SI pInputMsg34, CSES24DO pDamMsg, CLSS24DO pOutputMsg30, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CLSS24DI pCLSS24DInputRec = null;
        CLSS24DO pCLSS24DOutputRec = null;
        pCLSS24DInputRec = new CLSS24DI();
        pCLSS24DOutputRec = new CLSS24DO();
        pCLSS24DInputRec.setArchInputStruct(pInputMsg34.getArchInputStruct());
        pCLSS24DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSS24DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS24DO._CLSS24DO__ROWCLSS24DO_SIZE);
        pCLSS24DInputRec.setUlIdSvcAuth(pDamMsg.getUlIdSvcAuth());
        rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg30 = pCLSS24DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNB8D(CSUB68SI pInputMsg35, CCMNB8DO pOutputMsg31, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMNB8DI pCCMNB8DInputRec = null;
        CCMNB8DO pCCMNB8DOutputRec = null;
        pCCMNB8DInputRec = new CCMNB8DI();
        pCCMNB8DOutputRec = new CCMNB8DO();
        pCCMNB8DInputRec.setArchInputStruct(pInputMsg35.getArchInputStruct());
        pCCMNB8DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNB8DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NBR);
        pCCMNB8DInputRec.setSzCdStageProgram(pInputMsg35.getROWCSUB68SIG01().getSzCdStageProgram());
        pCCMNB8DInputRec.setSzCdStageReasonClosed(pInputMsg35.getROWCSUB68SIG01().getSzCdStageReasonClosed());
        pCCMNB8DInputRec.setSzCdStage(pInputMsg35.getROWCSUB68SIG01().getSzCdStage());
        rc = ccmnb8dQUERYdam(sqlca, pCCMNB8DInputRec, pCCMNB8DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg31 = pCCMNB8DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCAUD47D(CSUB68SI pInputMsg36, String szDAMClosureReason, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CAUD47DI pCAUD47DInputRec = null;
        CAUD47DO pCAUD47DOutputRec = null;
        pCAUD47DInputRec = new CAUD47DI();
        pCAUD47DOutputRec = new CAUD47DO();
        pCAUD47DInputRec.setArchInputStruct(pInputMsg36.getArchInputStruct());
        pCAUD47DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD47DInputRec.setSzTxtStageClosureCmnts(pInputMsg36.getROWCSUB68SIG01().getSzTxtStageClosureCmnts());
        pCAUD47DInputRec.setSzCdStageReasonClosed(szDAMClosureReason);
        pCAUD47DInputRec.setUlIdStage(pInputMsg36.getROWCSUB68SIG01().getUlIdStage());
        pCAUD47DInputRec.setTsLastUpdate(pInputMsg36.getROWCSUB68SIG01().getTsLastUpdate());
        pCAUD47DInputRec.getDtDtStageClose().day = DateHelper.NULL_DATE;
        pCAUD47DInputRec.getDtDtStageClose().month = DateHelper.NULL_DATE;
        pCAUD47DInputRec.getDtDtStageClose().year = DateHelper.NULL_DATE;
        rc = caud47dAUDdam(sqlca, pCAUD47DInputRec, pCAUD47DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }//SIR 18934 - fix error handling
    static int CallCINV43D(CSUB68SI pInputMsg37, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        pCINV43DInputRec = new CINV43DI();
        pCINV43DOutputRec = new CINV43DO();
        pCINV43DInputRec.setArchInputStruct(pInputMsg37.getArchInputStruct());
        pCINV43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINV43DInputRec.setUlIdEvent(pInputMsg37.getROWCSUB68SIG00().getUlIdEvent());
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallInvalidateAprvl(CSUB68SI pInputMsg38, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN05UI pCCMN05UInputRec = null;
        CCMN05UO pCCMN05UOutputRec = null;
        pCCMN05UInputRec = new CCMN05UI();
        pCCMN05UOutputRec = new CCMN05UO();
        pCCMN05UInputRec.setArchInputStruct(pInputMsg38.getArchInputStruct());
        pCCMN05UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN05UInputRec.setUlIdEvent(pInputMsg38.getROWCSUB68SIG00().getUlIdEvent());
        rc = InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallPostEvent(CSUB68SI pInputMsg39, FndInt3date dtSystemDate, CSUB68SO pOutputMsg32, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        pCCMN01UInputRec = new CCMN01UI();
        pCCMN01UOutputRec = new CCMN01UO();
        pCCMN01UInputRec.setArchInputStruct(pInputMsg39.getArchInputStruct());
        if (0 == pInputMsg39.getROWCSUB68SIG00().getUlIdEvent()) {
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        else {
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(pInputMsg39.getROWCSUB68SIG00().getSzCdTask());
        pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(pInputMsg39.getROWCSUB68SIG00().getTsLastUpdate());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(pInputMsg39.getROWCSUB68SIG00().getSzCdEventType());
        if (pInputMsg39.getROWCSUB68SIG00().getUlIdEvent() > 0) {
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(pInputMsg39.getROWCSUB68SIG00().getDtDtEventOccurred());
        }
        else {
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(dtSystemDate);
        }
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(pInputMsg39.getROWCSUB68SIG00().getUlIdEvent());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pInputMsg39.getROWCSUB68SIG00().getUlIdStage());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pInputMsg39.getROWCSUB68SIG00().getUlIdPerson());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(pInputMsg39.getROWCSUB68SIG00().getSzTxtEventDescr());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(pInputMsg39.getROWCSUB68SIG00().getSzCdEventStatus_ARRAY().getSzCdEventStatus(NEXT));
        rc = PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg32.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCloseOpenStage(CSUB68SI pInputMsg40, FndInt3date dtSystemDate, String szCdStageClosureReason, String szCdStageOpen1, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN03UI pCCMN03UInputRec = null;
        CCMN03UO pCCMN03UOutputRec = null;
        pCCMN03UInputRec = new CCMN03UI();
        pCCMN03UOutputRec = new CCMN03UO();
        pCCMN03UInputRec.setArchInputStruct(pInputMsg40.getArchInputStruct());
        pCCMN03UInputRec.setUlIdPerson(pInputMsg40.getROWCSUB68SIG00().getUlIdPerson());
        pCCMN03UInputRec.setDtDtStageStart(dtSystemDate);
        pCCMN03UInputRec.setUlIdStage(pInputMsg40.getROWCSUB68SIG01().getUlIdStage());
        pCCMN03UInputRec.setSzCdStage(pInputMsg40.getROWCSUB68SIG01().getSzCdStage());
        pCCMN03UInputRec.setSzCdStageReasonClosed(szCdStageClosureReason);
        pCCMN03UInputRec.setSzCdStageProgram(pInputMsg40.getROWCSUB68SIG01().getSzCdStageProgram());
        pCCMN03UInputRec.setSzCdStageOpen(szCdStageOpen1);
        pCCMN03UInputRec.setCSysIndSStgOpenOnly(INDICATOR_NO);
        rc = CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCloseStageCase(CSUB68SI pInputMsg41, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN02UI pCCMN02UInputRec = null;
        CCMN02UO pCCMN02UOutputRec = null;
        pCCMN02UInputRec = new CCMN02UI();
        pCCMN02UOutputRec = new CCMN02UO();
        pCCMN02UInputRec.setArchInputStruct(pInputMsg41.getArchInputStruct());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(pInputMsg41.getROWCSUB68SIG01().getSzCdStage());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(pInputMsg41.getROWCSUB68SIG01().getSzCdStageProgram());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(pInputMsg41.getROWCSUB68SIG01().getSzCdStageReasonClosed());
        pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(pInputMsg41.getROWCSUB68SIG01().getUlIdStage());
        pCCMN02UInputRec.getCCMN02UIG00().setSzTxtEventDescr(pInputMsg41.getROWCSUB68SIG00().getSzTxtEventDescr());
        rc = CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSES44D(CSUB68SI pInputMsg42, CINV51DO pDamMsg, CSES44DO pOutputMsg33, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES44DI pCSES44DInputRec = null;
        CSES44DO pCSES44DOutputRec = null;
        pCSES44DInputRec = new CSES44DI();
        pCSES44DOutputRec = new CSES44DO();
        pCSES44DInputRec.setArchInputStruct(pInputMsg42.getArchInputStruct());
        pCSES44DInputRec.setUlIdPlcmtChild(pDamMsg.getUlIdTodoPersAssigned());
        rc = cses44dQUERYdam(sqlca, pCSES44DInputRec, pCSES44DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg33 = pCSES44DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNH9D(CSUB68SI pInputMsg43, CCMNH9DO pOutputMsg34, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMNH9DI pCCMNH9DInputRec = null;
        CCMNH9DO pCCMNH9DOutputRec = null;
        pCCMNH9DInputRec = new CCMNH9DI();
        pCCMNH9DOutputRec = new CCMNH9DO();
        pCCMNH9DInputRec.setArchInputStruct(pInputMsg43.getArchInputStruct());
        pCCMNH9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNH9DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NBR);
        pCCMNH9DInputRec.setUlIdCase(pInputMsg43.getROWCSUB68SIG01().getUlIdCase());
        pCCMNH9DInputRec.setSzCdEventType(LEG_STATUS_EVENT);
        rc = ccmnh9dQUERYdam(sqlca, pCCMNH9DInputRec, pCCMNH9DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg34 = pCCMNH9DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSS30D(CLSS30DI pInputMsg44, CLSS30DO pOutputMsg35, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i = 0;
        CLSS30DI pCLSS30DInputRec = null;
        CLSS30DO pCLSS30DOutputRec = null;
        pCLSS30DInputRec = new CLSS30DI();
        pCLSS30DOutputRec = new CLSS30DO();
        pCLSS30DInputRec.setUlIdCase(pInputMsg44.getUlIdCase());
        pCLSS30DInputRec.setArchInputStruct(pInputMsg44.getArchInputStruct());
        pCLSS30DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSS30DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS30DO._CLSS30DO__ROWCLSS30DO_SIZE);
        rc = clss30dQUERYdam(sqlca, pCLSS30DInputRec, pCLSS30DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i = 0;i < pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty();++i) {
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setUlIdStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getUlIdStage());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzCdStageType(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStageType());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setTsLastUpdate(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getTsLastUpdate());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setUlIdUnit(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getUlIdUnit());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setUlIdCase(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getUlIdCase());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setDtDtStageClose(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getDtDtStageClose());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzCdStageClassification(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStageClassification());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzCdStageCurrPriority(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStageCurrPriority());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzCdStageReasonClosed(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStageReasonClosed());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzCdStageCnty(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStageCnty());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzNmStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzNmStage());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzCdStageRegion(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStageRegion());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setDtDtStageStart(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getDtDtStageStart());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setUlIdSituation(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getUlIdSituation());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzCdStageProgram(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStageProgram());
                    pOutputMsg35.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).setSzCdStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i).getSzCdStage());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                pOutputMsg35.getArchOutputStruct().setUlRowQty(pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg35.getArchOutputStruct().setBMoreDataInd(pCLSS30DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCSVC28D(CSUB68SI pInputMsg45, String szCdEventStatus1, CSUB68SO pOutputMsg36, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int usEventCtr = 0;
        int i = 0;
        CSVC28DI pCSVC28DInputRec = null;
        CSVC28DO pCSVC28DOutputRec = null;
        pCSVC28DInputRec = new CSVC28DI();
        pCSVC28DOutputRec = new CSVC28DO();
        pCSVC28DInputRec.setArchInputStruct(pInputMsg45.getArchInputStruct());
        pCSVC28DInputRec.setUlIdStage(pInputMsg45.getROWCSUB68SIG01().getUlIdStage());
        pCSVC28DInputRec.setSzCdEventStatus(szCdEventStatus1);
        pCSVC28DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCSVC28DInputRec.getArchInputStruct().setUlPageSizeNbr(1500);
        rc = csvc28dQUERYdam(sqlca, pCSVC28DInputRec, pCSVC28DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                for (int i = 0;i < pCSVC28DOutputRec.getArchOutputStruct().getUlRowQty();i++) {
                    if ((0 != pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i).getSzCdTask().compareTo(STR_CD_TASK_FRE)) && (0 != pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i).getSzCdTask().compareTo(STR_CD_TASK_FSU))) {
                        pOutputMsg36.getROWCSUB68SOG00().getSzCdUerrorMsgNbr_ARRAY().setSzCdUerrorMsgNbr(pOutputMsg36.getArchOutputStruct().getUlRowQty() , Messages.MSG_SVC_EVENT_PENDING);
                        pOutputMsg36.getArchOutputStruct().getUlRowQty()++;
                    }
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}

