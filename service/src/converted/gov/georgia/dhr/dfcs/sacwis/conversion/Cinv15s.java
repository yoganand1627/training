package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES97DI;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSESA3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSESA3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS30DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES97DO;
/**************************************************************************
**
** Module File:   cinv15s.src
**
** Service Name:  CINV15S - CPS INV CONCL VAL
**
** Description:   This service performs server side validation for the CPS
**                Investigation Conclusion window. The edits performed by
**                the service depend on the decode string in DCD_EDIT_PROCESS.
**                Once all required edits are passed, the service will set
**                all the to-dos associated with the input ID_EVENT to
**                "COMPLETE" and return a list of all the ID_EVENTs
**                associated with the input ID_STAGE.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  04/27/95
**
** Programmer:    Alex Ramirez
**
** Archive Information: $Revision:   1.5  $
**                      $Date:   14 Mar 2002 12:13:28  $
**                      $Modtime:   13 Mar 2002 17:21:50  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  09/29/95  VISHNUR   SIR 1575 Changed 'bIndCpsInvstEaConcl != YES' to
**                      'bIndCpsInvstEaConcl == NULL' as we just needed to
**                      whether the window was completed.
**
**  10/03/95  HUSTONMJ  ERR#1613 Check for Pending on Investigation Actions edit
**  10/03/95  WEALANBC  SIR 1590 - Modified CallCINV34D() to insure that
**                      only PRNs are checked for characteristics.
**  10/03/95  WEALANBC  ERR#1596 Change to edits after CINV34D
**  10/13/95  VISHNUR   SIR 1765 Change to CallCCMN34D
**  10/27/95  WILSONET  SIR 1983 Modify validate service in order to
**                      return an error message that is based on whether
**                      there is an open Subcare stage.  User should not
**                      be allowed to Save and Submit when a Subcare
**                      Stage has not been created. Include DAM CLSS30D.
**  11/06/95  HELMKEST  SIR 1710: Include CCMN06U - Check Stage Event
**                      Status function to the service.
**  11/30/95  YANTISTK  SIR 1886 - Added Service Authorization edit check.
**  01/08/96  GUARRICR  SIR 2515 - Set up page size variables in Call
**                      to CCMN87D function for Service Authorization
**
**  01/23/96  RAOSP     SIR #2827 - Added the pagenbr and pagesizenbr to
**                      the input to CLSS24D
**
**  01/29/96  MCRAEBS   SIR 2977 - Added missing break statements to
**                      to SA Detail check switches.  Missing breaks were
**                      causing logic to fall into the default case and
**                      failing the service.
**  01/31/96    KRD     SIR 3048 - Service Authorization events are approved
**                      separately from all other events in a stage.  So,
**                      when retrieving the events to be submitted for
**                      approval, we should ignore those events and not pass
**                      them back to the client.  Required a chenge to
**                      CallCCMN87D().
**  02/07/96  DYARGR    SIR 3104 - If any service authorizations are
**                      not approved, we should send a message back to the
**                      client to be displayed.
**
**  04/09/96  DYARGR    SIR 20084 - Change order for Service Authorizations.
**                      Do not allow stage closure if any of the Service Auth's
**                      are not APRoved or if they are not approved they must
**                      be terminated for today or earlier. Do not allow stage/case
**                      closure if any of the Service Auth's are open (term date greater
**                      than today's date). Removed everything used for SIR 3104
**                      as this new logic replaces it. Also gutted all changes
**                      made for 1886 in the common functions to make it easier
**                      to understand and maintain.
**
**  04/23/96  BRUCKMK   SIR 20257: Added Events with Event Status of NEW
**                      to the "if" statement which adds rows to the
**                      structure for events that need to be submitted for
**                      approval.  If the Event has a status of NEW, it will
**                      not be included in the structure and will thus not
**                      be updated to a status of PENDing, remaining NEW.
**
05/02/96  PHILLILH  SIR #20884 - Populated the Input Message Stage Closed
**                      with szCdRiskAssmtRecomActnData so that the
**                      Investigation Stage can be closed.  Stage Closed is
**                      used to determine if another stage will be open when
**                      the Investigation Conclusion is approved.
**
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
**
**  08/08/06  ADKINSMC  SIR 10787 - Added another edit within the CINV34D dam
**                      to verify that only one principal is the Oldest Victim.
**
**  08/16/96  ODONNERJ  SIR 21916 - · Upon conclusion of a CPS Investigation
**                      (Save and Submit), a  ?consistency check? needs to be
**                      performed for the responses from the Risk Assessment
**                      window, Safety Evaluation window, and EA Eligibility
**                      window.
**
** 10/10/96   SISSONM   SIR 11788 - Added logic to enable CPS Investigation
**                      closure with open service authorizations, provided
**                      that services are for daycare.
**
** 01/14/97   RIOSJA    SIR 12586 - This SIR is a modification to SIR 1983
**                      shown above. Before the user can Save and Submit a
**                      CPS Investigation Conclusion with recommendation
**                      "Removal/Subcare", a Subcare stage must exist that
**                      meets one of the following criteria:  1) is currently
**                      open, or  2) has been closed within the timespan of
**                      the investigation.
**
** 02/07/97   RIOSJA    SIR 13057 - When conclusions are submitted for
**                      approval, the status of existing approval events
**                      should not be changed to PENDING.
**
** 02/05/98   PAULS     SIR 13761 - Marital Status And Ethnicity Edit.
**                      Moved the DAM CLSC18D from CINV14S.SRC to this Service.
**
** 11/13/98   LEIHMA    SIR 14996 - Upon conclusion of a CPS Investigation
**                      (Save and Submit), an edit is added so that if the
**                      reason for death is A/N, then that person must be a
**                      victim in an allegation where the disposition is RTB.
**
** 05/03/99  SHARMAS    SIR 15208 - Before the user can "Save and Submit" a
**                      CPS investigation conclusion an edit is added to ensure
**                      that if there is a date of death entered there must
**                      be a reason for death in the person detail window.
**
** 12/27/99  BLAHAPP    SIR 15028
**                      Before the user can "Save and Submit" a
**                      CPS investigation conclusion, an edit is added to
**                      ensure that
**
**                      a) if there is a death code entered that
**                      is one of the three abuse and neglect (A/N) death
**                      codes, there must also be at least one allegation
**                      with severity = "fatal" for that person as victim.
**                      (N.B., In order for the severity field
**                      to be enabled to give it a value of "fatal",
**                      disposition must be RTB, so the condition of
**                      Sir # 14996 [see that SIR above] is also filled
**                      when this condition is filled.)
**
**                      b) the reverse:  if there is an allegation with
**                      severity = fatal for the victim, there must also
**                      be a death code whose value is one of the three
**                      A/N codes.
**
** 3/13/00  BLAHAPP     SIR 15465  The consistency check between death code and
**                      allegation severity did not check for a null death
**                      code.  A condition for entering the code that does the
**                      consistency check was that there WAS a death code
**                      at all.  This SIR removes that restriction.
**                      In the case where a severity of fatal is found,
**                      the previous logic gave an error if a death code of A/N
**                      was not also found. That same logic will now apply in the
**                      case of a null death code and cause the same error message
**                      to display to the user.
**
** 3/27/01  MERRELGS    SIR 13532. Made code modifications in the CPS
**                      investigation conclusion validation service to prevent
**                      the 1)person characteristics, 2)marital/ethnicity,
**                      3)date of birth, and 4)person search edits from appearing
**                      while trying to close an investigation when the
**                      name is unknown.
**
**10/10/01  CASDORJM    Modifications were made to this service to validate two
**                      things; 1) if the abbreviated checkbox is checked, the
**                      case is a valid abbreviated investigation; and 2) a
**                      new edit was added to require workers to complete the
**                      Services and Referrals Checklist window.
**
**
**03/01/2002 ochumd     Sir 15712 - Made code modifications in the CPS
**                      investigation conclusion validation service to prevent
**                      person search edits from appearing while trying to close
**                      an investigation when the person type is collateral.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  04/30/03   Srini    SIR 17091: Added the error handling to take care of full
**                      table scans for ccmn87dQUERYdam.
**
**  06/02/2003 mcclaim  SAFETY_EVAL_WARNING & MSG_INV_SVC_RFRL_CHKLST_WARNING
**                      now allow for the event to be in (PEND & approvalMode == 'Y')
**                      as well as COMP
**                      ulSysNbrReserved1: is now used to signal approvalMode
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free
**                      the input and output objects before they are allocated
**
**  03/22/04  RIOSJA    SIR 16298 - Added "Moderate Family Pres" and
**                      "Contracted Moderate Family Pres" to the list of
**                      Recommended Actions for which APRV'd service auths
**                      will be progressed if Term Date is in the future.
**
**  04/27/05 MALPANS    SIR# 23409 - Added "RISK_NA" to check if the risk assessment is N/A and Safety Plan
**                      checkbox is unchecked,then EA Eligibility is N/A
**
**  09/06/05 DUNAWAKL   SIR 23416 - Removed other types of Day Care from edit check which will then
**                      set off open SVC AUTH edit check for those types of day care.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv15s {
    public static final int INITIAL_PAGE = 1;
    public static final char YES = 'Y';
    public static final String SUBCARE = "SUB";
    
    /* Parameter for Edit Process String */
    public static final char EDIT_YES = 'Y';
    
    /* Positions within Edit Process String */
    public static final int VICTIM_DOB_EDIT = 0;
    public static final int PERS_SEARCH_EDIT = 1;
    public static final int PERS_CHARACTER_EDIT = 2;
    public static final int EA_QUESTIONS_EDIT = 3;
    /*  SARE2001 NEW CODE BEGIN
    **
    ** The Investigation Action is no longer required since IRA rolled
    ** out.  Therefore, this edit will now be used for the Services
    ** and Referrals Checklist edit.
    */
    /* #define INVESTIGATION_ACTION_EDIT   4 */
    public static final int SVC_REF_CHKLST_EDIT = 4;
    
    /* SARE2001 NEW CODE END */
    
    public static final int SAFETY_EVAL_EDIT = 5;
    
    public static final int OPEN_SUBCARE_STAGE = 6;
    public static final int SVC_AUTH_EDIT = 7;
    public static final int SVC_AUTH_EDIT2 = 8;
    public static final int RSN_DTH_EDIT = 9;
    public static final int DATE_RSN_DTH_EDIT = 10;
    
    /* Person roles, types, searches, etc. */
    public static final int PERSON_CHAR_NULL = 0;
    public static final char PERSON_CHAR_NONE = '0';
    public static final String PERSON_ROLE_BOTH = "DB";
    public static final String PERSON_ROLE_VICTIM = "DV";
    public static final char PERSON_SEARCH_R = 'R';
    public static final char PERSON_SEARCH_V = 'V';
    public static final String PERSON_STAFF = "STF";
    public static final String PERSON_TYPE_PRN = "PRN";
    public static final String PERSON_OLDEST_VICTIM = "OV";
    /*******************************/
    public static final String PERSON_TYPE_COL = "COL";
    /*******************************/
    /* Task codes and event related constants */
    
    /* SARE2001 NEW CODE BEGIN */
    public static final String SVC_REF_CKLST_TASK = "2309";
    public static final String CHCKLST_EVENT_TYPE = "CHK";
    /* SARE2001 NEW CODE END */
    public static final String INVESTIGATION_ACTION_TASK = "2210";
    public static final String SAFETY_EVAL_TASK = "2300";
    public static final String COMPLETE = "COMP";
    public static final String PENDING = "PEND";
    public static final String NO_EVENT_TYPE = "";
    public static final String NO_TASK = "";
    public static final String INV_ACTION_EVENT_TYPE = "STG";
    public static final String SAFETY_EVAL_EVENT_TYPE = "ASM";
    
    /* SIR 1886: Added new event type */
    public static final String SVC_AUTH_EVENT_TYPE = "AUT";
    
    /* SIR 13057: Added new event type */
    public static final String APPROVAL_EVENT_TYPE = "APP";
    
    /* SIR 20257: Added new event type and event status */
    public static final String EVENT_STATUS_NEW = "NEW";
    
    
    /* Validation Edit Warning Codes */
    public static final int PERS_CHARACTER_WARNING = 4054;
    public static final int VICTIM_DOB_WARNING = 4055;
    public static final int PERS_SEARCH_WARNING = 4056;
    public static final int INV_ACT_QUESTIONS_WARNING = 4062;
    public static final int SAFETY_EVAL_WARNING = 4063;
    public static final int EA_QUESTIONS_WARNING = 4068;
    public static final int MARITAL_ETHNICITY_WARNING = 4126;
    /* SARE2001 JMC NEW CODE BEGIN */
    public static final int MSG_INV_SVC_RFRL_CHKLST_WARNING = 4133;
    /* SARE2001 JMC NEW CODE END  */
    
    /* Needs to be deleted when message is included as error message */
    public static final int MSG_OPEN_SUBCARE_STAGE = 8226;
    
    public static final int MSG_INT_ONE_PRINCIPAL_OV = 3048;
    
    /* SIR 3104 */
    
    public static final String APPROVED = "APRV";
    public static final String SVC_AUTH_CD_TASK = "2310";
    
    /* SIR 20084*/
    public static final String GENERAL_PROT_CARE = "40W";
    
    /* SIR 11788*/
    public static final String DAY_CARE = "99R";
    public static final String FORMER_DAY_CARE = "40M";
    public static final String IVE_FC_DAY_CARE = "40A";
    public static final String REGISTERED_FAMILY_HM = "99Q";
    public static final String STATE_PAID_FC_DAY_CARE = "40B";
    
    /* SIR #20884, SIR 16298 */
    public static final String FAM_PRES_CODE = "64";
    public static final String MOD_FAM_PRES_CODE = "65";
    public static final String INTNSV_FAM_PRES_CODE = "66";
    public static final String CNTRCTED_FAM_PRES_CODE = "68";
    public static final String CNTRCTED_MOD_FAM_PRES_CODE = "69";
    public static final String CNTRCTED_INTNSV_FAM_PRES_CODE = "70";
    
    /* SIR# 21916 */
    public static final String EA_ELIGIBILITY_TASK = "2325";
    public static final String CD_EA_QUESTION_IS_ARC = "ARC";
    public static final int MSG_EA_NOT_RISK_SAFETY = 4123;
    public static final String RISK_INDICATED = "01";
    /* SIR# 23409 */
    public static final String RISK_NA = "04";
    
    /* SIR# 14996 */
    public static final int MSG_INV_RSN_DTH_EDIT = 4127;
    public static final String AN_IN_OPEN_CASE = "ABN";
    public static final String AN_IN_PRIOR_CASE = "ABO";
    public static final String AN_NO_PRIOR_CASE = "ABP";
    
    /* SIR# 15028 */
    public static final String NOT_AN_RELATED = "NAB";
    
    /* SIR# 15208 */
    public static final int MSG_INV_DATE_RSN_DTH_EDIT = 4132;
    CINV15SO CINV15S(CINV15SI cinv15si) {
        CINV15SO cinv15so = new CINV15SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CINV15S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i313 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        int RetVal = SUCCESS;
        Pchar bRsnDthEdit = new Pchar();
        bRsnDthEdit.value = 0;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        
        /* SIR 14996  Declare and initialize dam function input/output variables */
        
        CLSC18DO CLSC18DO = null;
        CSES97DI CSES97DI = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv15si.getArchInputStruct());
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
        */
        
        /*
        ** Check buffer size
        */
        
        /*
        ** Process error message and return to client
        */
        
        /*
        ** Initialize output message and length
        */
        
        /*
        ** Initialize service status fields
        */
        
        /*
        ** SIR 1710:  Include common function CCMN06U - Check Stage Event
        **            Status
        */
        
        /*
        ** Allocate memory for common function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv15si.getArchInputStruct());
        pCCMN06UInputRec.setSzCdTask(cinv15si.getSzCdTask());
        pCCMN06UInputRec.setUlIdStage(cinv15si.getUlIdStage());
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS;
                RetVal = SUCCESS;
                
                break;
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                //  Set RetVal to FND_FAIL;
                RetVal = Csub50s.FND_FAIL;
                
                break;
                
                
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAIL;
                RetVal = Csub50s.FND_FAIL;
                
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL;
                RetVal = Csub50s.FND_FAIL;
                
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL;
                RetVal = Csub50s.FND_FAIL;
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                                  sprintf(pReturnPB->appl_status.explan_data,
                //##                                          "%u",
                //##                                          usVersionRow);
                
                break;
        }
        
        if (SUCCESS == RetVal) {
            
            //  Call DAM
            rc = Cinv01s.CallCINV34D(cinv15si, cinv15so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    //  Set explan_data to usRow
                    // Note: Use sprintf
                    //##                                  sprintf(pReturnPB->appl_status.explan_data,
                    //##                                          "%u",
                    //##                                          usVersionRow);
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            //  Check for NULL pointers, return fatal error if found.
            if (cinv15si.getSzDcdEditProcess()[SVC_REF_CHKLST_EDIT] == EDIT_YES) {
                
                
                
                rc = CallCSESA3D(cinv15si, cinv15si.getUlIdStage() , cinv15so, pServiceStatus);
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                    case NO_DATA_FOUND:
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            //  Blindly return rc code to allow calling function to determine 
            // proper course of action
            if (cinv15si.getSzDcdEditProcess()[SAFETY_EVAL_EDIT] == EDIT_YES) {
                rc = Cinv20s.CallCCMN87D(cinv15si, SAFETY_EVAL_TASK, SAFETY_EVAL_EVENT_TYPE, cinv15so, pServiceStatus);
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        //  Set explan_data to usRow
                        // Note: Use sprintf
                        //##                                sprintf(pReturnPB->appl_status.explan_data,
                        //##                                        "%u",
                        //##                                        usVersionRow);
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            if (cinv15si.getSzDcdEditProcess()[EA_QUESTIONS_EDIT] == EDIT_YES) {
                if ((cinv15si.getBIndCpsInvstEaConcl() == 0) && (0 != RISK_NA.compareTo(cinv15si.getSzCdRiskAssmtRiskFind()))) {
                    cinv15so.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(cinv15so.getCINV59SOG01().ulRowQty, EA_QUESTIONS_WARNING);
                    cinv15so.getCINV59SOG01().ulRowQty++;
                }
            }
            if (cinv15si.getSzDcdEditProcess()[OPEN_SUBCARE_STAGE] == EDIT_YES) {
                rc = Ccmn02u.CallCLSS30D(cinv15si, cinv15so, pServiceStatus);
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        //  Set explan_data to usRow
                        // Note: Use sprintf
                        //##                                sprintf(pReturnPB->appl_status.explan_data,
                        //##                                        "%u",
                        //##                                        usVersionRow);
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            if (EDIT_YES == cinv15si.getSzDcdEditProcess()[SVC_AUTH_EDIT]) {
                rc = Cinv20s.CallServiceAuth(cinv15si, cinv15so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            //  Perform Main Processing
            
            //  Set dtDtSystemDate to current date
            rc = CallConsistencyCheck(cinv15si, cinv15so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = Cinv59s.CallCLSC18D(cinv15si, cinv15so, CLSC18DO, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    //  Blindly return rc code to allow user to determine
                    // proper course of action
                    
                    // 
                    // Prepare output message to be returned and return
                    // 
                    if (cinv15si.getSzDcdEditProcess()[RSN_DTH_EDIT] == EDIT_YES) {
                        for (i313 = 0;(i313 < CLSC18DO.getArchOutputStruct().getUlRowQty() || bRsnDthEdit.value == true);++i313) {
                            cinv15si.setSzCdPersonDeath(CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i313).getSzCdPersonDeath());
                            CSES97DI.setUlIdPerson(CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i313).getUlIdPerson());
                            rc = Cinv59s.CallCSES97D(cinv15si, CSES97DI, bRsnDthEdit, cinv15so, pServiceStatus);
                        }
                    }
                    
                    break;
                    // end for SIR 14996
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (!cinv15so.getCINV15SOG01().getUlRowQty()) {
                
                
                //  Call CSES08D
                rc = Cinv12s.CallCINV43D(cinv15si, cinv15so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                rc = Cinv20s.CallCCMN87D(cinv15si, NO_TASK, NO_EVENT_TYPE, cinv15so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        //  Set explan_data to usRow
                        // Note: Use sprintf
                        //##                        sprintf(pReturnPB->appl_status.explan_data,
                        //##                                "%u",
                        //##                                usVersionRow);
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv15si.getArchInputStruct() , cinv15so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        /*
        ** Blindly return rc code to allow user to determine
        ** proper course of action
        */
        
        /*********************************************************************
        *  Prepare output message to be returned and return
        **********************************************************************/
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
        return cinv15so;
    }

    static int CallCSESA3D(CINV15SI pInputMsg596, int ulIdStage5, CINV15SO pOutputMsg549, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare Local Variables
        */
        
        boolean bSvcRefChklst = false;
        
        CSESA3DI pCSESA3DInputRec = null;
        CSESA3DO pCSESA3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSESA3DInputRec = new CSESA3DI();
        
        
        pCSESA3DOutputRec = new CSESA3DO();
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        pCSESA3DInputRec.setUlIdStage(pInputMsg596.getUlIdStage());
        pCSESA3DInputRec.setSzCdEventType(CHCKLST_EVENT_TYPE);
        pCSESA3DInputRec.setSzCdTask(SVC_REF_CKLST_TASK);
        
        pCSESA3DInputRec.setArchInputStruct(pInputMsg596.getArchInputStruct());
        rc = csesa3dQUERYdam(sqlca, pCSESA3DInputRec, pCSESA3DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                // Determine if the event status is COMP
                
                // Initialize bSvcRefChklst to FALSE
                bSvcRefChklst = false;
                // 
                // SIR 16037: Add call to update when user logs into CAPS Toolbar  CWC
                // 
                if ((0 == strncmp(pCSESA3DOutputRec.getSzCdEventStatus() , COMPLETE, COMPLETE.length())) || ((pInputMsg596.getArchInputStruct().getUlSysNbrReserved1() == true) && (0 == strncmp(pCSESA3DOutputRec.getSzCdEventStatus() , PENDING, PENDING.length())))) {
                    bSvcRefChklst = true;
                }
                if (!bSvcRefChklst) {
                    pOutputMsg549.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg549.getCINV59SOG01().ulRowQty, MSG_INV_SVC_RFRL_CHKLST_WARNING);
                    pOutputMsg549.getCINV59SOG01().ulRowQty++;
                }
                break;
            case NO_DATA_FOUND:
                
                pOutputMsg549.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg549.getCINV59SOG01().ulRowQty, MSG_INV_SVC_RFRL_CHKLST_WARNING);
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg549.getCINV59SOG01().ulRowQty++;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV34D(CINV15SI pInputMsg597, CINV15SO pOutputMsg550, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        int i314 = 0;
        int countov = 0;/* SIR 10787 - Loop counter for RelInt-OV */
        
        /*
        ** Declare local variables
        */
        
        CINV34DI pCINV34DInputRec = null;
        
        
        
        
        /*
        ** MHMR Phase III Issue 1 (RIOSJA) - The data stored in this DAM
        ** output structure by one DAM will be used by a second DAM in a
        ** different DAM call, so the structure must be defined globally.
        */
        CINV34DO pCINV34DOutputRec = null;
        
        /*
        **  SIR 13532:  Removed bLivingArrange because it is not used in this
        **              function or service and also added UnknownName variable.
        **
        **  unsigned short bLivingArrange = FALSE;
        */
        int bUnknownName = 0;
        /* END SIR 13532 */
        
        int bPersCharacter = 0;
        int bVictimDob = 0;
        int bPersSearch = 0;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV34DInputRec = new CINV34DI();
        
        pCINV34DOutputRec = new CINV34DO();
        /* 
        **  PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
        **  SQL error returned from the DAM.
        */
        pCINV34DInputRec.setArchInputStruct(pInputMsg597.getArchInputStruct());
        
        pCINV34DInputRec.setUlIdStage(pInputMsg597.getUlIdStage());
        pCINV34DInputRec.setSzCdStagePersType(PERSON_STAFF);
        pCINV34DInputRec.getArchInputStruct().setUsPageNbr(0);
        pCINV34DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV34DO._CINV34DO__ROWCINV34DO_SIZE);
        pCINV34DOutputRec.getArchOutputStruct().setBMoreDataInd(1);
        
        /*
        ** Set loop to retrieve all the persons associated with the case
        */
        while (pCINV34DOutputRec.getArchOutputStruct().getBMoreDataInd() != 0) {
            pCINV34DInputRec.getArchInputStruct().getUsPageNbr()++;
            rc = cinv34dQUERYdam(sqlca, pCINV34DInputRec, pCINV34DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    for (i314 = 0;i314 < pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();++i314) {
                        bUnknownName = 0;// SIR 13532: Reset bUnknownName
                        // for each person in the loop
                        
                        //  End SIR# 5366
                        
                        //  SIR# 10174
                        // If i == 0 then rc = SQL_NOT_FOUND
                        if ((null == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getSzNmPersonFirst()[0]) && (null == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getSzNmPersonLast()[0])) {
                            bUnknownName = 1;
                        }
                        if ((EDIT_YES == pInputMsg597.getSzDcdEditProcess()[PERS_SEARCH_EDIT]) && (PERSON_SEARCH_R != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getSzCdStagePersSearchInd()) && (PERSON_SEARCH_V != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getSzCdStagePersSearchInd()) && (0 != PERSON_TYPE_COL.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getSzCdStagePersType())) && (!bUnknownName) && (!bPersSearch)) {
                            bPersSearch = 1;
                        }
                        if ((EDIT_YES == pInputMsg597.getSzDcdEditProcess()[PERS_CHARACTER_EDIT]) && ((PERSON_CHAR_NONE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getBCdPersonChar()) || (PERSON_CHAR_NULL == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getBCdPersonChar())) && (0 == PERSON_TYPE_PRN.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getSzCdStagePersType())) && (!bUnknownName) && (!bPersCharacter)) {
                            bPersCharacter = 1;
                        }
                        
                        //  Analyze error code
                        if (EDIT_YES == pInputMsg597.getSzDcdEditProcess()[VICTIM_DOB_EDIT] &&!(strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getSzCdStagePersType() , PERSON_TYPE_PRN, PERSON_TYPE_PRN.length()) != 0) && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getDtDtPersonBirth().day && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getDtDtPersonBirth().month && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getDtDtPersonBirth().year && true != bUnknownName && bVictimDob != true) {
                            bVictimDob = 1;
                        }
                        //  Populate Output Message
                        if (!(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i314).getSzCdStagePersRelInt().compareTo(PERSON_OLDEST_VICTIM) != 0)) {
                            countov++;
                            if (countov < 1) {
                                break;
                            }
                        }
                        if (bPersCharacter != 0 && bVictimDob != 0 && bPersSearch != 0) {
                            pCINV34DOutputRec.getArchOutputStruct().setBMoreDataInd(0);
                            i314 = pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();
                            
                            
                            break;
                        }
                    }
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        /*
        ** SIR #20941 - Loop through the output of ccmn87d to determine if
        ** any of the Client Assesment events for this stage are in status
        ** PROC.  If so, the service returns a message that the user must
        ** close the window before saving can procees. Only one Client
        ** Assessment of Event Status PROC can exist at a time.
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            if (bPersCharacter != 0) {
                pOutputMsg550.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg550.getCINV59SOG01().ulRowQty, PERS_CHARACTER_WARNING);
                pOutputMsg550.getCINV59SOG01().ulRowQty++;
            }
            if (bVictimDob != 0) {
                pOutputMsg550.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg550.getCINV59SOG01().ulRowQty, VICTIM_DOB_WARNING);
                pOutputMsg550.getCINV59SOG01().ulRowQty++;
            }
            
            // 
            // SIR 1829: Need to pop up Pending Event Message for New Contacts and 
            // Med/Mental Assessments for a stage that has been submitted for 
            // closure.  The closure event for Service Delivery has a type of 
            // SVC_CD_EVENT_TYPE_CLOSE as opposed to SVC_CD_EVENT_TYPE_CONCL for 
            // Investigation. 
            // For Med/Mental: Also added DAM CINT21D for stage retrieval to get 
            // CD_STAGE.  Added temporary szCdStage variable to store the retrieved 
            // stage information throughout the service.
            // 
            if (bPersSearch != 0) {
                pOutputMsg550.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg550.getCINV59SOG01().ulRowQty, PERS_SEARCH_WARNING);
                pOutputMsg550.getCINV59SOG01().ulRowQty++;
            }
            //  Populate Output Message
            if (countov > 1) {
                pOutputMsg550.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg550.getCINV59SOG01().ulRowQty, MSG_INT_ONE_PRINCIPAL_OV);
                pOutputMsg550.getCINV59SOG01().ulRowQty++;
            }
        }
        
        
        return rc;
    }

    static int CallCCMN87D(CINV15SI pInputMsg598, String szCdTask1, String szCdEventType2, CINV15SO pOutputMsg551, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int /* Loop counter */
        usEventCtr = 0;
        int uCounter = 0;
        
        /*
        ** Declare local variables
        */
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg598.getArchInputStruct());
        
        pCCMN87DInputRec.setUlIdStage(pInputMsg598.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(szCdEventType2);
        pCCMN87DInputRec.setSzCdTask(szCdTask1);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        if (0 == szCdEventType2.compareTo(NO_EVENT_TYPE)) {
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV15SO._CINV15SO__ROWCINV15SOG00_SIZE);
        }
        else {
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        }
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call DAM
        */
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (!(szCdEventType2.compareTo(NO_EVENT_TYPE) != 0)) {
                    pOutputMsg551.getArchOutputStruct().setUlRowQty(pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty());
                    usEventCtr = 0;
                    
                    for (uCounter = 0;usEventCtr < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();usEventCtr++) {
                        
                        //  Populate DAM Input Structure
                        
                        //  SIR 2621 - Populate CdTask based on CdStage passed from
                        // CCON13     BSM
                        if ((0 != SVC_AUTH_EVENT_TYPE.compareTo(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType())) && (0 != EVENT_STATUS_NEW.compareTo(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus())) && (0 != APPROVAL_EVENT_TYPE.compareTo(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType()))) {
                            pOutputMsg551.getROWCINV15SOG00_ARRAY().getROWCINV15SOG00(uCounter).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getUlIdEvent());
                            uCounter++;
                        }
                    }
                }
                
                
                
                
                //  ERR#1613 - Also check for Pending on Investigation Actions.
                else if ((0 == szCdTask1.compareTo(INVESTIGATION_ACTION_TASK)) && (0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus().compareTo(COMPLETE)) && (0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus().compareTo(PENDING))) {
                    
                    pOutputMsg551.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg551.getCINV59SOG01().ulRowQty, INV_ACT_QUESTIONS_WARNING);
                    pOutputMsg551.getCINV59SOG01().ulRowQty++;
                }
                else if ((0 == szCdTask1.compareTo(SAFETY_EVAL_TASK)) && ((0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus().compareTo(COMPLETE)) || ((pInputMsg598.getArchInputStruct().getUlSysNbrReserved1() == true) && (0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus().compareTo(PENDING))))) {
                    pOutputMsg551.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg551.getCINV59SOG01().ulRowQty, SAFETY_EVAL_WARNING);
                    pOutputMsg551.getCINV59SOG01().ulRowQty++;
                    
                }
                rc = WtcHelperConstants.ARC_SUCCESS;// SIR 21168 this line was commented out &
                // should not have been
                
                break;
            case NO_DATA_FOUND:
                
                
                //   Get IdSvcAuth from link table
                if (0 == szCdTask1.compareTo(INVESTIGATION_ACTION_TASK)) {
                    pOutputMsg551.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg551.getCINV59SOG01().ulRowQty, INV_ACT_QUESTIONS_WARNING);
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    pOutputMsg551.getCINV59SOG01().ulRowQty++;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else if (0 == szCdTask1.compareTo(SAFETY_EVAL_TASK)) {
                    pOutputMsg551.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg551.getCINV59SOG01().ulRowQty, SAFETY_EVAL_WARNING);
                    
                    //  Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    pOutputMsg551.getCINV59SOG01().ulRowQty++;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else if (!(szCdEventType2.compareTo(NO_EVENT_TYPE) != 0)) {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
                
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV43D(CINV15SI pInputMsg599, CINV15SO * pOutputMsg552, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV43DInputRec = new CINV43DI();
        pCINV43DOutputRec = new CINV43DO();
        pCINV43DInputRec.setUlIdEvent(pInputMsg599.getUlIdEvent());
        pCINV43DInputRec.setArchInputStruct(pInputMsg599.getArchInputStruct());
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSS30D(CINV15SI pInputMsg600, CINV15SO pOutputMsg553, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int usCaseCtr = 0;/* Loop counter */
        boolean bSubStageFound = false;/* Boolean flags to determine widget state */
        /*
        ** Declare local variables
        */
        
        
        CLSS30DI pCLSS30DInputRec = null;
        CLSS30DO pCLSS30DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS30DInputRec = new CLSS30DI();
        
        pCLSS30DOutputRec = new CLSS30DO();
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCLSS30DInputRec.setUlIdCase(pInputMsg600.getUlIdCase());
        pCLSS30DInputRec.setArchInputStruct(pInputMsg600.getArchInputStruct());
        pCLSS30DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSS30DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS30DO._CLSS30DO__ROWCLSS30DO_SIZE);
        
        /*
        ** Call DAM
        */
        rc = clss30dQUERYdam(sqlca, pCLSS30DInputRec, pCLSS30DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg553.getArchOutputStruct().setUlRowQty(pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty());
                
                //  Check for a Subcare stage that meets one of the following
                // criteria:  1) is currently open, or  2) has been closed
                // within the timespan of the investigation.
                for (usCaseCtr = 0;((usCaseCtr < pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty()) && (!bSubStageFound));usCaseCtr++) {
                    if ((0 == SUBCARE.compareTo(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(usCaseCtr).getSzCdStage())) && ((DateHelper.NULL_DATE == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(usCaseCtr).getDtDtStageClose().year) || (0 <= ARC_UTLCompareDateAndTime((FndInt3date) & pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(usCaseCtr).getDtDtStageClose() , (char) 0, (FndInt3date) & pInputMsg600.getDtDtCPSInvstDtlBegun() , (char) 0)))) {
                        bSubStageFound = true;
                    }
                }
                if (!bSubStageFound) {
                    pOutputMsg553.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg553.getCINV59SOG01().ulRowQty, MSG_OPEN_SUBCARE_STAGE);
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    pOutputMsg553.getCINV59SOG01().ulRowQty++;
                }
                //  No processing needed.
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallServiceAuth(CINV15SI pInputMsg601, CINV15SO pOutputMsg554, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i315 = 0;
        int j = 0;
        int rc = 0;/* Return code */
        
        /*
        ** SIR 20084
        ** Declare and initialize all locally used dam i/o's
        */
        CSES23DI CSES23DI = null;
        CSES23DO CSES23DO = null;
        CSES24DI CSES24DI = null;
        CSES24DO CSES24DO = null;
        CLSS24DI CLSS24DI = null;
        CLSS24DO CLSS24DO = null;
        CCMN87DI CCMN87DI = null;
        CCMN87DO CCMN87DO = null;
        CCMNF6DI CCMNF6DI = null;
        CCMNF6DO CCMNF6DO = null;
        
        
        /*
        ** SIR 20084
        ** Removed the following as they are no longer referrenced
        **
        **  unsigned long ulRowQtyEvent;
        **  unsigned long   ulRowQtySvcAuthDetail;
        **  unsigned long ulIdEvent[_CCMN87DO__ROWCCMN87DO_SIZE];
        **  unsigned long ulIdSvcAuth;
        **
        **
        **  FND_INT3DATE  dtSvcAuthDtlTermDate[_CLSS24DO__ROWCLSS24DO_SIZE];
        **
        */
        
        FndInt3date dtCurrentDate = null;
        
        
        char bSvcAuthFlag = 1;
        char bLastStage = 0;
        
        
        /* populate CurrentDate variable with current date */
        ARC_UTLGetDateAndTime(dtCurrentDate, 0);
        CCMNF6DI.setArchInputStruct(pInputMsg601.getArchInputStruct());
        CCMNF6DI.setUlIdCase(pInputMsg601.getUlIdCase());
        
        rc = Ccmn02u.CallCCMNF6D(CCMNF6DI, CCMNF6DO, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        /*
        ** END "extendo" compare date processing
        */
        
        if (1 == CCMNF6DO.getArchOutputStruct().getUlRowQty()) {
            bLastStage = 1;
        }
        CCMN87DI.setArchInputStruct(pInputMsg601.getArchInputStruct());
        CCMN87DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        CCMN87DI.setUlIdStage(pInputMsg601.getUlIdStage());
        CCMN87DI.setSzCdTask(SVC_AUTH_CD_TASK);
        rc = CallCCMN87DA(CCMN87DI, CCMN87DO, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                if ((!bLastStage) || (0 == pInputMsg601.getSzCdStageReasonClosed().compareTo(FAM_PRES_CODE)) || (0 == pInputMsg601.getSzCdStageReasonClosed().compareTo(MOD_FAM_PRES_CODE)) || (0 == pInputMsg601.getSzCdStageReasonClosed().compareTo(INTNSV_FAM_PRES_CODE)) || (0 == pInputMsg601.getSzCdStageReasonClosed().compareTo(CNTRCTED_FAM_PRES_CODE)) || (0 == pInputMsg601.getSzCdStageReasonClosed().compareTo(CNTRCTED_MOD_FAM_PRES_CODE)) || (0 == pInputMsg601.getSzCdStageReasonClosed().compareTo(CNTRCTED_INTNSV_FAM_PRES_CODE))) {
                    
                    for (i315 = 0;i315 < CCMN87DO.getArchOutputStruct().getUlRowQty() && bSvcAuthFlag == true;i315++) {
                        
                        // 
                        // (END): CLSS67D - List retrieval of Contract rows for and id resource.
                        // 
                        
                        if ((0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(COMPLETE)) || (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(PENDING))) {
                            CSES24DI.setArchInputStruct(pInputMsg601.getArchInputStruct());
                            CSES24DI.setUlIdSvcAuthEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getUlIdEvent());
                            
                            
                            //  Call CINV43D
                            rc = Ccmn02u.CallCSES24D(CSES24DI, CSES24DO, pServiceStatus);
                            
                            //  Analyze error code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    CLSS24DI.setArchInputStruct(pInputMsg601.getArchInputStruct());
                                    CLSS24DI.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                    CLSS24DI.getArchInputStruct().setUlPageSizeNbr(CLSS24DO.get_CLSS24DO__ROWCLSS24DO_SIZE());
                                    CLSS24DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                                    
                                    //  SIR 2775 - Set rc to SQL_SUCCESS so
                                    // SA Event Link DAM will run
                                    // BSM
                                    rc = Ccmn02u.CallCLSS24D(CLSS24DI, CLSS24DO, pServiceStatus);
                                    
                                    //  Analyze error code
                                    switch (rc) {
                                            
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            
                                            //  For each Term date returned from the DAM, check it
                                            // to make sure it isn't greater than the current date.
                                            // If it is set the SvcAuthFlag to false.
                                            for (j = 0;j < CLSS24DO.getArchOutputStruct().getUlRowQty();j++) {
                                                if ((ARC_UTLCompareDateAndTime((FndInt3date) & dtCurrentDate, 0, (FndInt3date) & CLSS24DO.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getDtDtSvcAuthDtlTerm() , 0)) < 0) {
                                                    
                                                    
                                                    
                                                    bSvcAuthFlag = 0;
                                                    break;
                                                }
                                            }
                                            break;
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            break;
                                    }
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    
                                    break;
                            }
                        }
                        if (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(APPROVED)) {
                            CSES24DI.setArchInputStruct(pInputMsg601.getArchInputStruct());
                            CSES24DI.setUlIdSvcAuthEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getUlIdEvent());
                            
                            rc = Ccmn02u.CallCSES24D(CSES24DI, CSES24DO, pServiceStatus);
                            
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    CLSS24DI.setArchInputStruct(pInputMsg601.getArchInputStruct());
                                    CLSS24DI.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                    CLSS24DI.getArchInputStruct().setUlPageSizeNbr(CLSS24DO.get_CLSS24DO__ROWCLSS24DO_SIZE());
                                    
                                    CLSS24DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                                    rc = Ccmn02u.CallCLSS24D(CLSS24DI, CLSS24DO, pServiceStatus);
                                    switch (rc) 
                                    {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            
                                            for (j = 0;j < CLSS24DO.getArchOutputStruct().getUlRowQty();j++) {
                                                if ((ARC_UTLCompareDateAndTime((FndInt3date) & dtCurrentDate, 0, (FndInt3date) & CLSS24DO.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getDtDtSvcAuthDtlTerm() , 0)) < 0) {
                                                    if (0 == CLSS24DO.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getSzCdSvcAuthDtlSvc().compareTo(FORMER_DAY_CARE)) {
                                                        
                                                        bSvcAuthFlag = 0;
                                                        
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                            
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            break;
                                    }
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    break;
                            }
                        }
                    }
                    break;
                }
                
                
                
                
                else {
                    for (i315 = 0;i315 < CCMN87DO.getArchOutputStruct().getUlRowQty() && bSvcAuthFlag == true;i315++) {
                        if ((0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(COMPLETE)) || (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(PENDING)) || (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(APPROVED))) {
                            CSES24DI.setArchInputStruct(pInputMsg601.getArchInputStruct());
                            CSES24DI.setUlIdSvcAuthEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getUlIdEvent());
                            
                            
                            //  Call CAUD34D
                            rc = Ccmn02u.CallCSES24D(CSES24DI, CSES24DO, pServiceStatus);
                            
                            
                            //  Analyze error code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    CLSS24DI.setArchInputStruct(pInputMsg601.getArchInputStruct());
                                    CLSS24DI.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                    CLSS24DI.getArchInputStruct().setUlPageSizeNbr(CLSS24DO.get_CLSS24DO__ROWCLSS24DO_SIZE());
                                    CLSS24DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                                    
                                    rc = Ccmn02u.CallCLSS24D(CLSS24DI, CLSS24DO, pServiceStatus);
                                    switch (rc) {
                                            
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            //  For each Term date returned from the DAM, check it
                                            // to make sure it isn't greater than the current date.
                                            // If it is set the SvcAuthFlag to false.
                                            //  11788 - added types of daycare to if condition
                                            for (j = 0;j < CLSS24DO.getArchOutputStruct().getUlRowQty();j++) {
                                                
                                                // SIR 19613 Change comparison of service returned
                                                // from 60A-E to 63A-D
                                                if (((ARC_UTLCompareDateAndTime((FndInt3date) & dtCurrentDate, 0, (FndInt3date) & CLSS24DO.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getDtDtSvcAuthDtlTerm() , 0)) < 0) || (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(PENDING)) || (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(COMPLETE))) {
                                                    
                                                    
                                                    if ((0 != CLSS24DO.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getSzCdSvcAuthDtlSvc().compareTo(FORMER_DAY_CARE)) || (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(PENDING)) || (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i315).getSzCdEventStatus().compareTo(COMPLETE))) {
                                                        bSvcAuthFlag = 0;
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            break;
                                    }
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    break;
                            }
                        }
                    }
                    break;
                }
            case NO_DATA_FOUND:
                return WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        
        /*********************************************************
        ** (BEGIN): CLSS68D - Retrieve contract service codes for
        ** the CONTRACT COUNTY table.
        *********************************************************/
        
        if (!bSvcAuthFlag) {
            pOutputMsg554.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg554.getCINV59SOG01().ulRowQty, Messages.MSG_SVA_OPN_AUTHS);
            pOutputMsg554.getCINV59SOG01().ulRowQty++;
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCCMN87DA(CCMN87DI pInputMsg602, CCMN87DO pOutputMsg555, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i316 = 0;
        int rc = 0;/* Return code */
        
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg602.getArchInputStruct());
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
        pCCMN87DInputRec.setUlIdStage(pInputMsg602.getUlIdStage());
        pCCMN87DInputRec.setSzCdTask(pInputMsg602.getSzCdTask());
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                for (i316 = 0;i316 < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();++i316) {
                    pOutputMsg555.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).getUlIdEvent());
                    pOutputMsg555.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).setSzCdEventType(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).getSzCdEventType());
                    pOutputMsg555.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).setSzCdTask(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).getSzCdTask());
                    pOutputMsg555.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).setSzTxtEventDescr(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).getSzTxtEventDescr());
                    pOutputMsg555.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).setDtDtEventOccurred(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).getDtDtEventOccurred());
                    pOutputMsg555.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).setSzCdEventStatus(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i316).getSzCdEventStatus());
                }
                pOutputMsg555.getArchOutputStruct().setUlRowQty(pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg555.getArchOutputStruct().setBMoreDataInd(pCCMN87DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pOutputMsg555.getArchOutputStruct().setUlRowQty(0);
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSES24D(CSES24DI pInputMsg603, CSES24DO pOutputMsg556, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSES24DI pCSES24DInputRec = null;
        CSES24DO pCSES24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES24DInputRec = new CSES24DI();
        
        pCSES24DOutputRec = new CSES24DO();
        pCSES24DInputRec.setArchInputStruct(pInputMsg603.getArchInputStruct());
        pCSES24DInputRec.setUlIdSvcAuthEvent(pInputMsg603.getUlIdSvcAuthEvent());
        
        /*
        ** Get the current date and store it in dtCurrentDate
        */
        rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg556.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSS24D(CLSS24DI pInputMsg604, CLSS24DO pOutputMsg557, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i317 = 0;
        /*
        ** Declare local variables
        */
        CLSS24DI pCLSS24DInputRec = null;
        CLSS24DO pCLSS24DOutputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCLSS24DInputRec = new CLSS24DI();
        
        pCLSS24DOutputRec = new CLSS24DO();
        
        pCLSS24DInputRec.setArchInputStruct(pInputMsg604.getArchInputStruct());
        pCLSS24DInputRec.setUlIdSvcAuth(pInputMsg604.getUlIdSvcAuth());
        
        /*
        ** When creating a new contract, dtCnverEnd should
        ** be curr date plus 100 years
        */
        rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg557.getArchOutputStruct().setUlRowQty(pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i317 = 0;i317 < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();++i317) {
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    pOutputMsg557.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i317).setDtDtSvcAuthDtlTerm(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i317).getDtDtSvcAuthDtlTerm());
                    pOutputMsg557.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i317).setSzCdSvcAuthDtlSvc(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i317).getSzCdSvcAuthDtlSvc());
                }
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNF6D(CCMNF6DI pInputMsg605, CCMNF6DO pOutputMsg558, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i318 = 0;
        int rc = 0;/* Return code  */
        
        CCMNF6DI pCCMNF6DInputRec = null;
        CCMNF6DO pCCMNF6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF6DInputRec = new CCMNF6DI();
        
        pCCMNF6DOutputRec = new CCMNF6DO();
        pCCMNF6DInputRec.setArchInputStruct(pInputMsg605.getArchInputStruct());
        pCCMNF6DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNF6DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNF6DO._CCMNF6DO__ROWCCMNF6DO_SIZE);
        pCCMNF6DInputRec.setUlIdCase(pInputMsg605.getUlIdCase());
        rc = ccmnf6dQUERYdam(sqlca, pCCMNF6DInputRec, pCCMNF6DOutputRec);
        
        /*
        ** Analyze return code
        */
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i318 = 0;i318 < pCCMNF6DOutputRec.getArchOutputStruct().getUlRowQty();++i318) {
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    pOutputMsg558.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i318).setUlIdStage(pCCMNF6DOutputRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i318).getUlIdStage());
                    pOutputMsg558.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i318).setSzCdStage(pCCMNF6DOutputRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i318).getSzCdStage());
                }
                pOutputMsg558.getArchOutputStruct().setUlRowQty(pCCMNF6DOutputRec.getArchOutputStruct().getUlRowQty());
                
                //  SIR # 21658 Initialized rc variable to ARC_SUCCESS.
                // This needs to be done because if we are progressing
                // to a PAL stage, the value of rc may be reseted from
                // ARC_SUCCESS to something else, and the next switch
                // on rc won't work properly.
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                // 
                // (END): CAUD35D
                // 
                break;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallConsistencyCheck(CINV15SI pInputMsg606, CINV15SO pOutputMsg559, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i319 = 0;
        int j = 0;
        int rc = 0;
        boolean bConsistencyCheckFail = false;/* Boolean flags to determine widget state */
        
        
        /*
        ** Declare and initialize all locally used dam i/o's
        */
        CINV15DI CINV15DI = null;
        CINV15DO CINV15DO = null;
        CINV95DI CINV95DI = null;
        CINV95DO CINV95DO = null;
        CCMNB4DI CCMNB4DI = null;
        CCMNB4DO CCMNB4DO = null;
        
        CCMNB4DI.setArchInputStruct(pInputMsg606.getArchInputStruct());
        CCMNB4DI.setUlIdStage(pInputMsg606.getUlIdStage());
        
        
        /*
        ** SIR#2085 For each row returned from the DAM call CLSC49D to check
        ** for Person Merge data, if the DAM returns a count >0
        ** Merge Indicator flag to true else set the Merge Indicator flag to
        ** false.
        */
        
        rc = Ccmn50s.CallCCMNB4D(CCMNB4DI, CCMNB4DO, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        CINV15DI.setUlIdEvent(CCMNB4DO.getUlIdEvent());
        
        /*
        ** SIR #3885 - Added the Employee Flag Retrieval Dam
        ** CINV29D.  This will be used to determine when to
        ** enable/disable the Records Check menu item on
        ** the window.
        */
        rc = Cinv11s.CallCINV15D(CINV15DI, CINV15DO, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        CINV95DI.setUlIdStage(pInputMsg606.getUlIdStage());
        rc = Ccmn02u.CallCINV95D(CINV95DI, CINV95DO, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Step Four: Interpret Results of Step One, Two, and Three
        **            If EA is NO and Risk Finding is Risk Indicated or
        **            Safety Plan is Checked --> Set off edit message.
        **            OR if EA is YES and Risk Finding is NOT Risk Indicated
        **            AND Safety Plan is NOT checked --> Set off edit message
        */
        for (i319 = 0;i319 < CINV15DO.getArchOutputStruct().getUlRowQty();i319++) {
            
            
            //  Additions made to code by SLE to add functionality to retrieve
            // worker info for a new call.
            
            //  CINT47D will only be called if the previous DAM call completed .  
            // Also the DAM will only be called if this serive is in ADD mode,
            // meaning that the phone button has just been clicked.
            if ((('Y' == CINV15DO.getROWCINV15DO_ARRAY().getROWCINV15DO(i319).getBIndEaResponse()) && (0 != RISK_INDICATED.compareTo(pInputMsg606.getSzCdRiskAssmtRiskFind())) && ('N' == CINV95DO.getBIndCpsInvstSafetyPln())) || (('N' == CINV15DO.getROWCINV15DO_ARRAY().getROWCINV15DO(i319).getBIndEaResponse()) && ((0 == RISK_INDICATED.compareTo(pInputMsg606.getSzCdRiskAssmtRiskFind())) || ('Y' == CINV95DO.getBIndCpsInvstSafetyPln())))) {
                bConsistencyCheckFail = true;
            }
            
            if (('N' == CINV15DO.getROWCINV15DO_ARRAY().getROWCINV15DO(i319).getBIndEaResponse()) && (0 == RISK_NA.compareTo(pInputMsg606.getSzCdRiskAssmtRiskFind())) && ('N' == CINV95DO.getBIndCpsInvstSafetyPln()) || ('Y' == CINV95DO.getBIndCpsInvstSafetyPln())) {
                bConsistencyCheckFail = false;
            }
        }
        
        if (bConsistencyCheckFail) {
            pOutputMsg559.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg559.getCINV59SOG01().ulRowQty, MSG_EA_NOT_RISK_SAFETY);
            pOutputMsg559.getCINV59SOG01().ulRowQty++;
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCINV15D(CINV15DI pInputMsg607, CINV15DO pOutputMsg560, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i320 = 0;
        int j = 0;
        int rc = 0;/* Return code */
        
        CINV15DI pCINV15DInputRec = null;
        CINV15DO pCINV15DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV15DInputRec = new CINV15DI();
        
        pCINV15DOutputRec = new CINV15DO();
        pCINV15DInputRec.setArchInputStruct(pInputMsg607.getArchInputStruct());
        pCINV15DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCINV15DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV15DO._CINV15DO__ROWCINV15DO_SIZE);
        pCINV15DInputRec.setUlIdEvent(pInputMsg607.getUlIdEvent());
        
        //set rc value to FND_FAIL
        rc = cinv15dQUERYdam(sqlca, pCINV15DInputRec, pCINV15DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                j = 0;
                for (i320 = 0;i320 < pCINV15DOutputRec.getArchOutputStruct().getUlRowQty();++i320) {
                    
                    //  Set explan_data to usRow
                    // Note: Use sprintf
                    //##                              sprintf(pReturnPB->appl_status.explan_data,
                    //##                                      "%u",
                    //##                                      usVersionRow);
                    
                    
                    // Fringe Benefits
                    if (0 == pCINV15DOutputRec.getROWCINV15DO_ARRAY().getROWCINV15DO(i320).getSzCdEaQuestion().compareTo(CD_EA_QUESTION_IS_ARC)) {
                        pOutputMsg560.getROWCINV15DO_ARRAY().getROWCINV15DO(j).setBIndEaResponse(pCINV15DOutputRec.getROWCINV15DO_ARRAY().getROWCINV15DO(i320).getBIndEaResponse());
                        j++;
                    }
                }
                pOutputMsg560.getArchOutputStruct().setUlRowQty(j);
                
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                
                //set rc value to FND_FAIL
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCCMNB4D(CCMNB4DI pInputMsg608, CCMNB4DO pOutputMsg561, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMNB4DI pCCMNB4DInputRec = null;
        CCMNB4DO pCCMNB4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB4DInputRec = new CCMNB4DI();
        
        pCCMNB4DOutputRec = new CCMNB4DO();
        
        pCCMNB4DInputRec.setArchInputStruct(pInputMsg608.getArchInputStruct());
        
        //## BEGIN TUX/XML: Declare XML variables
        pCCMNB4DInputRec.setUlIdStage(pInputMsg608.getUlIdStage());
        pCCMNB4DInputRec.setSzCdTask(EA_ELIGIBILITY_TASK);
        rc = ccmnb4dQUERYdam(sqlca, pCCMNB4DInputRec, pCCMNB4DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg561.setUlIdEvent(pCCMNB4DOutputRec.getUlIdEvent());
                
                //  Call CINV29D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCINV95D(CINV95DI pInputMsg609, CINV95DO pOutputMsg562, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        /*
        ** Declare local variables
        */
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV95DInputRec = new CINV95DI();
        
        pCINV95DOutputRec = new CINV95DO();
        pCINV95DInputRec.setArchInputStruct(pInputMsg609.getArchInputStruct());
        pCINV95DInputRec.setUlIdStage(pInputMsg609.getUlIdStage());
        rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg562.setBIndCpsInvstSafetyPln(pCINV95DOutputRec.getBIndCpsInvstSafetyPln());
                
                //  Call CCMN44D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSC18D(CINV15SI pInputMsg610, CINV15SO pOutputMsg563, CLSC18DO pRsnDthOut, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i321 = 0;
        
        /*
        ** Declare local variables
        */
        CLSC18DI pCLSC18DInputRec = null;
        CLSC18DO pCLSC18DOutputRec = null;
        int bMaritalEthnicity = 0;/* SIR 13761 */
        int bDateRsnDth = 0;/* SIR 15208 */
        int bUnknownName = 0;/* SIR 13532 */
        
        
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC18DInputRec = new CLSC18DI();
        pCLSC18DOutputRec = new CLSC18DO();
        pCLSC18DInputRec.setArchInputStruct(pInputMsg610.getArchInputStruct());
        /*
        ** If a anything other than 0 is returned, the error is severe.
        */
        pCLSC18DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        pCLSC18DInputRec.setUlIdStage(pInputMsg610.getUlIdStage());
        pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC18DO._CLSC18DO__ROWCLSC18DO_SIZE);
        rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                
                for (i321 = 0;(i321 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty() && true != bMaritalEthnicity);++i321) {
                    bUnknownName = 0;// SIR 13532: Reset bUnknownName
                    // for each person in the loop
                    
                    
                    //  SIR 16206 - If Client Assessment Event Type (ASSMT_EVENT_TYPE)
                    // is passed to this function, check to see if the Client
                    // Assessment Event is complete. If it is not complete, give
                    // error message. (Only give message if 'ulIdOutcomeMatrixEvent'
                    // is null. If 'ulIdOutcomeMatrixEvent' is present, this DAM is
                    // being called only to retrieve the Outcome Matrix event, not
                    // to process any edits.)
                    // SIR 23530 - only check CARE assessment event
                    if ((null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).getSzNmPersonFirst()[0]) && (null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).getSzNmPersonLast()[0])) {
                        bUnknownName = 1;
                    }
                    if ((null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).getSzCdPersonMaritalStatus()[0] || null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).getSzCdPersonEthnicGroup()[0]) && (!bUnknownName)) {
                        bMaritalEthnicity = 1;
                    }
                }
                if (pInputMsg610.getSzDcdEditProcess()[DATE_RSN_DTH_EDIT] == EDIT_YES) {
                    for (i321 = 0;(i321 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty() && true != bDateRsnDth);++i321) {
                        
                        //  Analyze error code
                        if (DateHelper.NULL_DATE != pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).getDtDtPersonDeath().month && null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).getSzCdPersonDeath()[0]) {
                            bDateRsnDth = 1;
                        }
                    }
                    
                }
                pRsnDthOut.getArchOutputStruct().setUlRowQty(pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i321 = 0;(i321 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());++i321) {
                    pRsnDthOut.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).setUlIdPerson(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).getUlIdPerson());
                    pRsnDthOut.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).setSzCdPersonDeath(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i321).getSzCdPersonDeath());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                //##                PrepServiceExit(SVCPARMS);
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        if (bMaritalEthnicity != 0) {
            pOutputMsg563.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg563.getCINV59SOG01().ulRowQty, MARITAL_ETHNICITY_WARNING);
            //  If a anything other than 0 is returned, the error is severe.
            pOutputMsg563.getCINV59SOG01().ulRowQty++;
        }
        if (bDateRsnDth != 0) {
            pOutputMsg563.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg563.getCINV59SOG01().ulRowQty, MSG_INV_DATE_RSN_DTH_EDIT);
            pOutputMsg563.getCINV59SOG01().ulRowQty++;
        }
        return rc;
    }

    static int CallCSES97D(CINV15SI pInputMsg611, CSES97DI pRsnDthIn, String bRsnDthEdit, CINV15SO pOutputMsg564, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int usCaseCtr = 0;/* Loop counter */
        /*
        ** Declare local variables
        */
        
        
        CSES97DI pCSES97DInputRec = null;
        CSES97DO pCSES97DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES97DInputRec = new CSES97DI();
        
        pCSES97DOutputRec = new CSES97DO();
        pCSES97DInputRec.setUlIdStage(pInputMsg611.getUlIdStage());
        pCSES97DInputRec.setUlIdPerson(pRsnDthIn.getUlIdPerson());
        
        pCSES97DInputRec.setArchInputStruct(pInputMsg611.getArchInputStruct());
        
        rc = cses97dQUERYdam(sqlca, pCSES97DInputRec, pCSES97DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case NO_DATA_FOUND:
                {
                    
                    if ((0 == pInputMsg611.getSzCdPersonDeath().compareTo(AN_IN_OPEN_CASE)) || (0 == pInputMsg611.getSzCdPersonDeath().compareTo(AN_IN_PRIOR_CASE)) || (0 == pInputMsg611.getSzCdPersonDeath().compareTo(AN_NO_PRIOR_CASE))) {
                        bRsnDthEdit = true;
                        pOutputMsg564.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg564.getCINV59SOG01().ulRowQty, MSG_INV_RSN_DTH_EDIT);
                        
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        pOutputMsg564.getCINV59SOG01().ulRowQty++;
                    }
                    else {
                        // add/update RECORDS_CHECK table
                        rc = WtcHelperConstants.ARC_SUCCESS;
                    }
                    //  Populate Output Message
                    // pCINVA0DOutputRec will be returned to the service, so there
                    // is no need to copy the DAM output to the service output.
                    // Same goes for the DAM output architecture header.
                    break;
                }
            case WtcHelperConstants.SQL_SUCCESS:
                {
                    
                    if ((0 == pInputMsg611.getSzCdPersonDeath().compareTo(AN_IN_OPEN_CASE)) || (0 == pInputMsg611.getSzCdPersonDeath().compareTo(AN_IN_PRIOR_CASE)) || (0 == pInputMsg611.getSzCdPersonDeath().compareTo(AN_NO_PRIOR_CASE))) {
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                    }
                    else {
                        bRsnDthEdit = true;
                        
                        pOutputMsg564.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg564.getCINV59SOG01().ulRowQty, MSG_INV_RSN_DTH_EDIT);
                        pOutputMsg564.getCINV59SOG01().ulRowQty++;
                        
                        break;
                    }
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
