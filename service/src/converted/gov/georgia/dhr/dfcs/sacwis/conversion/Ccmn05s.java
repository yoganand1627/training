package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Cinv05s;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
import gov.georgia.dhr.dfcs.sacwis.service.person.Cinv26s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN71DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN70DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN70DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN73DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN78DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN78DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN98DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN98DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNI1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNI1DO;
/**************************************************************************
**
** Module File:   CCMN05S.src
**
** Service Name:  CCMN05S - EMPLOYEE DETAIL SAVE
**
** Description:   Save the Employee information
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  02/18/95
**
** Programmer:    Karl R. Dalley / Ramani Vishnubhotla
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   28 Nov 2000 14:41:40  $
**                      $Modtime:   28 Nov 2000 10:42:58  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/01/95    KRD     Rewrote much of the service to properly ADD and
**                      MODIFY.
**  06/21/95    KRD     Corrections due to Technical Code Review.
**  07/12/95    DMV     SIR 733 Added code to call DAMs to delete TODO's
**                      workload and on-call status when the  FTE is
**                      zero or a term date has been entered.
**  07/13/95    DMV     SIR 766 - Fix a Database error occuring when
**                      and employee has been added to the system
**                      and then terminated.
**  07/27/95    KRD     SIR 919 - Ensure that the both person category
**                      values are passed to DAM CCMNC2D in Update mode.
**                      Required change to CallCCMNC2D().
**  08/03/95    KRD     SIR 1058 - Until the tables for the Complex Delete
**                      can be re-examined for completeness, the only
**                      delete that will be called will be DELETE_EMPLOYEE.
**  08/10/95    KRD     SIR 1096 - To properly handle modications to unit
**                      approvers, created references to DAMs CCMNG5D and
**                      CCMNG6D and removed reference to CCMNF4D.
**                      <see comments in code>
**  10/10/95    KRD     SIR 1265 - Modified the code which handles updates
**                      to employee information to be consistent with the
**                      HRMIS-interface's handling of employees which have
**                      Termination Dates set.  Added function IsDateNull().
**  01/29/96    JRH     Ethnicity and DOB fields are added to the window
**                      and made enetrable when new until they are
**                      validated by HRMIS at which time they will be
**                      non-modifiable. SIR 2091
**  03/14/96  ELLIOTSL  SIR 1058 - This SIR has been reopened to undo it.
**                      Deleting a staff person involves the following
**                      steps
**                          1) Changing 'EMP' -> 'FEM'
**                          2) Unconditionally deleting the employee info.
**                          3) Deleting person information if possible.
**                             if it fails, because of foriegn key
**                             constraints, the person will remain as
**                             a 'FEM'.
**   26Mar96  sladewmf  SIR 4244: Added function CallCCMND5D.
**  05/17/96    KRD     SIR 2593 - When an employee's name changes, it is
**                      necessary to update the case name of any open APS
**                      case in which the employee is a victim or client.
**                      Required the addition of two new dams, CCMNH4D and
**                      CCMNH5D.
**  08/07/96    KRD     SIR 10496 - If the most recent Job History record
**                      was deleted and a new one created, a bogus
**                      ID_EMP_JOB_HISTORY was being passed from DAM
**                      CCMN78D to CCMN70D.  The if-statement in CCMN78D
**                      has been corrected.  Other modifications made to
**                      clean up code.  Error handling improved to ensure
**                      that database changes are rolled back when an
**                      error occurs.
**
**  10/17/2000 CCM      SIR 15512 - Added two new DAMs that would add and update
**                      a row from the Person Race and Person Ethnicity Table.
**
**  04/18/2001  SLC     SECURITY UPGRADE--Deleted references to
**                      szCdEmpSecurityClassNm since the field,
**                      CD_EMP_SECURITY_CLASS will be null on the EMPLOYEE
**                      Table.  Security profiles will now be held on the
**                      EMP_SEC_CLASS_LINK Table.
**
**  06/11/2001  APT     SECURITY UPGRADE-Add call to CAUDE2D.PC for deleting
**                      all records from EMP_SEC_CLASS_LINK for a terminated
**                      employee.
**
**  03/17/2004  CSD     SIR 22542- FTE % is not always correct and users are
**                      getting 'Employee has outstanding to-dos' when
**                      updating unit. This message should only apply when
**                      employees are terminated, not when ActivePct = 0.
**  05/11/2004  CSD     SIR 14339 - Should not be able to terminate an
**                      employee with secondary assignments.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn05s
{
    
    /***************************************************************************
    ** Constants
    ***************************************************************************/
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String UNIT_MEMBER_IN_ASSIGNED = "IN";
    public static final String UNIT_MEMBER_OUT_ASSIGNED = "OUT";
    
    public static final String PERSON_CATEGORY_EMPLOYEE = "EMP";
    public static final String PERSON_CATEGORY_FORMER_EMPLOYEE = "FEM";
    
    //SIR 14339 add define for secondary assignment
    public static final String SEC_ROLE_STAGE_OPEN = "SE";
    /*
    ** SIR #1058: This was the sqlca.code observed in xdb when an a foreign key
    ** constraint was violated.
    */
    public static final int ORACLE_INTEGRITY_CONSTRAINT = - 2292;
    
    /*
    ** SIR 2593 - macros needed for " et al" processing
    */
    public static final String CASE_NM_ET_AL = " et al";
    public static final int CASE_NM_ET_AL_LEN = 6;
    CCMN05SO CCMN05S(CCMN05SI ccmn05si) {
        CCMN05SO ccmn05so = new CCMN05SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        int bSSNUnique = 1;
        
        /*
        ** SIR 2593 - Need a temporary string to copy into
        */
        String szTempName = new String();
        String szCdStagePersRole1 = new String();
        rc = ARC_PRFServiceStartTime_TUX(ccmn05si.getArchInputStruct());
        
        
        /*
        ** Analyze return code
        */
        switch (ccmn05si.getArchInputStruct().getCReqFuncCd()) {
            case WtcHelperConstants.REQ_FUNC_CD_DELETE:
                rc = CallCCMNG6D(ccmn05si, ccmn05so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_STF_APPRVR_DEL:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = CallCCMNE6D(ccmn05si, ccmn05so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_ONCALL_OUTSTANDING:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                //  Declare FOUNDATION variables
                
                //  Declare local variables
                
                //  Start performance timer for service
                rc = CallCCMNE7D(ccmn05si, ccmn05so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TODO_OUTSTANDING:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                szCdStagePersRole1 = PRIMARY_ROLE_STAGE_OPEN;
                
                // SIR 21891 - missing versioning
                //  Run-time Versioning
                
                //  Check buffer size
                
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                //  Initialize service status fields
                
                // 
                // Call DAMs to retrieve data
                // 
                
                //  Retrieve the Conclusion Event ID for the stage
                rc = CallCCMNE8D(ccmn05si, ccmn05so, pServiceStatus, szCdStagePersRole1);
                
                
                //  Analyze return code for CSEC58D
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_STAGES_OUTSTANDING:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                szCdStagePersRole1 = SEC_ROLE_STAGE_OPEN;
                rc = CallCCMNE8D(ccmn05si, ccmn05so, pServiceStatus, szCdStagePersRole1);
                
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_STAGES_OUTSTANDING:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                rc = CallCCMNF5D(ccmn05si, ccmn05so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                rc = CallCCMNF7D(ccmn05si, ccmn05so, pServiceStatus);
                
                //## BEGIN TUX/XML: Declare XML variables 
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
            case WtcHelperConstants.REQ_FUNC_CD_ADD:
                
                rc = CallCCMND6D(ccmn05si, ccmn05so, pServiceStatus);
                
                //  Analyze error code
                
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    case Messages.MSG_CMN_SSN_NOT_UNIQUE:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = CallCCMNI1D(ccmn05si, ccmn05so, pServiceStatus);
                
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                    case Messages.MSG_CMN_MORE_THAN_50_MEMBERS:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = CallCCMN71D(ccmn05si, ccmn05so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                //  Call DAM
                rc = CallCCMN78D(ccmn05si, ccmn05so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                        
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                rc = CallCCMN70D(ccmn05si, ccmn05so, pServiceStatus);
                
                switch (rc) {
                        // 
                        // OPTIONAL CODE NOTE (END): Generic List AUD
                        // 
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                rc = CallCCMN73D(ccmn05si, ccmn05so, pServiceStatus);
                
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = Ccmn22s.CallCCMN49D(ccmn05si, ccmn05so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                
                
                //  Start Performance Timer
                rc = CallCCMN98D(ccmn05si, ccmn05so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = Cint02s.CallCAUDD5D(ccmn05si, ccmn05so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = Cint02s.CallCAUDD4D(ccmn05si, ccmn05so, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        break;
                }
                
                if (ccmn05si.getROWCCMN05SIG01().getSzCdScrDataAction() != null) {
                    
                    //  Call CheckStageEventStatus
                    rc = CallCCMNA0D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        case Messages.MSG_CMN_UPDATE_FAILED:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            break;
                            
                        default :
                            
                            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            break;
                    }
                }
                rc = Cinv05s.CallCCMNC2D(ccmn05si, ccmn05so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                break;
            case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                
                if (false == IsDateNull(ccmn05si.getROWCCMN05SIG00().getDtDtEmpTermination())) {
                    rc = CallCCMNG6D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_STF_APPRVR_DEL:
                            pServiceStatus.explan_code = Messages.MSG_CMN_STF_APPRVR_MOD;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
                
                if (0 == ccmn05si.getROWCCMN05SIG04().getUlIdUnitEmpLink()) {
                    
                    // This is the id-event of the closure event
                    rc = Ccmn22s.CallCCMNG5D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_STF_APPRVR_MOD:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
                
                if (false == IsDateNull(ccmn05si.getROWCCMN05SIG00().getDtDtEmpTermination())) {
                    //  IMPACT END
                    rc = CallCCMNE6D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_ONCALL_OUTSTANDING:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                    rc = CallCCMNE7D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_TODO_OUTSTANDING:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                    szCdStagePersRole1 = PRIMARY_ROLE_STAGE_OPEN;
                    rc = CallCCMNE8D(ccmn05si, ccmn05so, pServiceStatus, szCdStagePersRole1);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_STAGES_OUTSTANDING:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                    szCdStagePersRole1 = SEC_ROLE_STAGE_OPEN;
                    
                    // This is the id-event of the Placement event
                    rc = CallCCMNE8D(ccmn05si, ccmn05so, pServiceStatus, szCdStagePersRole1);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_STAGES_OUTSTANDING:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
                //  IMPACT END
                
                rc = CallCCMN71D(ccmn05si, ccmn05so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = CallCCMN78D(ccmn05si, ccmn05so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        break;
                        
                    default :
                        
                        // 
                        // Function Prototypes
                        // 
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        
                        //  Set explan_data to usRow
                        // Note: Use sprintf
                        //##          sprintf(pReturnPB->appl_status.explan_data,
                        //##                  "%u",
                        //##                  usRow);
                        
                        break;
                }
                rc = CallCCMN70D(ccmn05si, ccmn05so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                if (0 == ccmn05si.getROWCCMN05SIG04().getUlIdUnitEmpLink()) {
                    
                    
                    //  Commented Out for SIR 14502
                    // pCCMN01UInputRec->ROWCCMN01UIG00.dtDtEventOccurred
                    // = pInputMsg->ROWCCMN01UIG00.dtDtEventOccurred;
                    
                    
                    //  Get Current Date for SIR 14502
                    rc = CallCCMNE0D_IN(ccmn05si, ccmn05so, pServiceStatus);
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    //  Call PostEvent
                    rc = Ccmn04u.CallCCMND5D(ccmn05si, ccmn05so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                if (true == IsDateNull(ccmn05si.getROWCCMN05SIG00().getDtDtEmpTermination())) {
                    rc = Ccmn22s.CallCCMN49D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        case Messages.MSG_CMN_UPDATE_FAILED:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
                rc = CallCCMN98D(ccmn05si, ccmn05so, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                //  Call CINV43D
                rc = Cint02s.CallCAUDD5D(ccmn05si, ccmn05so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                //  Set rc to ARC_SUCCESS
                rc = Cint02s.CallCAUDD4D(ccmn05si, ccmn05so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                if (ccmn05si.getROWCCMN05SIG01().getSzCdScrDataAction() != null) {
                    rc = CallCCMNA0D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        case Messages.MSG_CMN_UPDATE_FAILED:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                    rc = Cinv26s.CallCCMNH4D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    
                    
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    //  Call CAUD45D
                    rc = Cinv26s.CallCCMNH5D(ccmn05si, ccmn05so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    if (ccmn05si.getSzNmPersonFull().length() <= (Ccmn85s.NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN - 1)) {
                        ccmn05si.getSzNmPersonFull() += CASE_NM_ET_AL;
                    }
                    
                    else {
                        szTempName = CStringUtils.setCharAt(szTempName, 0, null);
                        szTempName = ccmn05si.getSzNmPersonFull();
                        szTempName += CASE_NM_ET_AL;
                        
                        ccmn05si.setSzNmPersonFull(szTempName);
                    }
                    if (ccmn05si.getROWCCMN05SIG06().getSzNmPersonFull().length() <= (Ccmn85s.NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN - 1)) {
                        ccmn05si.getROWCCMN05SIG06().getSzNmPersonFull() += CASE_NM_ET_AL;
                    }
                    
                    else {
                        szTempName = CStringUtils.setCharAt(szTempName, 0, null);
                        szTempName = ccmn05si.getROWCCMN05SIG06().getSzNmPersonFull();
                        szTempName += CASE_NM_ET_AL;
                        ccmn05si.getROWCCMN05SIG06().setSzNmPersonFull(szTempName);
                    }
                    rc = Cinv26s.CallCCMNH4D(ccmn05si, ccmn05so, pServiceStatus);
                    
                    //  SIR 4244: Added function CallCCMND5D.
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    rc = Cinv26s.CallCCMNH5D(ccmn05si, ccmn05so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                rc = Cinv05s.CallCCMNC2D(ccmn05si, ccmn05so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                if (false == IsDateNull(ccmn05si.getROWCCMN05SIG00().getDtDtEmpTermination())) {
                    
                    //  Call CSES37D
                    rc = CallCCMNE0D_OUT(ccmn05si, ccmn05so, pServiceStatus);
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    rc = CallCCMNH2D(ccmn05si, ccmn05so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    rc = CallCAUDE2D(ccmn05si, ccmn05so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                break;
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn05si.getArchInputStruct() , ccmn05so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                
                //  SIR 1265 - split the prototype of CallCCMNE0D() into two -
                // CallCCMNE0D_IN() and CallCCMNE0D_OUT()
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call CAUD99D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn05so;
    }

    static int CallCCMNE6D(CCMN05SI pInputMsg182, CCMN05SO * pOutputMsg163, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i111 = 0;
        int rc = 0;
        
        CCMNE6DI pCCMNE6DInputRec = null;
        CCMNE6DO pCCMNE6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE6DInputRec = new CCMNE6DI();
        
        pCCMNE6DOutputRec = new CCMNE6DO();
        pCCMNE6DInputRec.setArchInputStruct(pInputMsg182.getArchInputStruct());
        pCCMNE6DInputRec.setUlIdPerson(pInputMsg182.getUlIdPerson());
        
        rc = ARC_UTLGetDateAndTime(pCCMNE6DInputRec.getDtDtOnCallEnd() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        
        rc = ccmne6dQUERYdam(sqlca, pCCMNE6DInputRec, pCCMNE6DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_ONCALL_OUTSTANDING;
                
                rc = Messages.MSG_CMN_ONCALL_OUTSTANDING;
                break;
            case NO_DATA_FOUND:
                // In order to subtract one day, two days are subtracted, and one day is added.
                // Otherwise the function does not work
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNE7D(CCMN05SI pInputMsg183, CCMN05SO * pOutputMsg164, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    /*
    ** CASE2:
    */
    {
        int i112 = 0;
        int rc = 0;/* Return code */
        CCMNE7DI pCCMNE7DInputRec = null;
        CCMNE7DO pCCMNE7DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE7DInputRec = new CCMNE7DI();
        pCCMNE7DOutputRec = new CCMNE7DO();
        pCCMNE7DInputRec.setArchInputStruct(pInputMsg183.getArchInputStruct());
        pCCMNE7DInputRec.setUlIdPerson(pInputMsg183.getUlIdPerson());
        rc = ccmne7dQUERYdam(sqlca, pCCMNE7DInputRec, pCCMNE7DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_TODO_OUTSTANDING;
                rc = Messages.MSG_CMN_TODO_OUTSTANDING;
                
                //  Set explain data to usPptPartRow
                
                break;
            case NO_DATA_FOUND:// Not all events have an associated ToDo
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                //  Set explain data to usPptPartRow
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMNE8D(CCMN05SI pInputMsg184, CCMN05SO * pOutputMsg165, Arcxmlerrors.TUX_DECL_STATUSPARMS, String szCdStagePersRole2) {
        int i113 = 0;
        int rc = 0;
        CCMNE8DI pCCMNE8DInputRec = null;
        CCMNE8DO pCCMNE8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE8DInputRec = new CCMNE8DI();
        
        pCCMNE8DOutputRec = new CCMNE8DO();
        pCCMNE8DInputRec.setArchInputStruct(pInputMsg184.getArchInputStruct());
        pCCMNE8DInputRec.setUlIdPerson(pInputMsg184.getUlIdPerson());
        pCCMNE8DInputRec.setSzCdStagePersRole(szCdStagePersRole2);
        rc = ccmne8dQUERYdam(sqlca, pCCMNE8DInputRec, pCCMNE8DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_STAGES_OUTSTANDING;
                rc = Messages.MSG_CMN_STAGES_OUTSTANDING;
                break;// break for SQL_NOT_FOUND for CINV51D(VC)
                // /*
                // default for CINV51D(VC)
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMND6D(CCMN05SI pInputMsg185, CCMN05SO * pOutputMsg166, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i114 = 0;
        int rc = 0;/* Return code */
        CCMND6DI pCCMND6DInputRec = null;
        CCMND6DO pCCMND6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND6DInputRec = new CCMND6DI();
        pCCMND6DOutputRec = new CCMND6DO();
        pCCMND6DInputRec.setArchInputStruct(pInputMsg185.getArchInputStruct());
        pCCMND6DInputRec.setSzNbrPersonIdNumber(pInputMsg185.getROWCCMN05SIG05().getSzNbrPersonIdNumber());
        pCCMND6DInputRec.setSzCdPersonIdType(pInputMsg185.getROWCCMN05SIG05().getSzCdPersonIdType());
        rc = ccmnd6dQUERYdam(sqlca, pCCMND6DInputRec, pCCMND6DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_SSN_NOT_UNIQUE;
                rc = Messages.MSG_CMN_SSN_NOT_UNIQUE;
                
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
                
        }
        return rc;
    }

    static int CallCCMN71D(CCMN05SI pInputMsg186, CCMN05SO pOutputMsg167, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN71DI pCCMN71DInputRec = null;
        CCMN71DO pCCMN71DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN71DInputRec = new CCMN71DI();
        pCCMN71DOutputRec = new CCMN71DO();
        
        if (pInputMsg186.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
            pCCMN71DInputRec.setUlIdPerson(0);
        }
        else {
            
            pCCMN71DInputRec.setUlIdPerson(pInputMsg186.getUlIdPerson());
            pCCMN71DInputRec.setTsLastUpdate(pInputMsg186.getROWCCMN05SIG06().getTsLastUpdate());
            
        }
        pCCMN71DInputRec.setCCdPersonSex(pInputMsg186.getROWCCMN05SIG06().getCCdPersonSex());
        pCCMN71DInputRec.setSzNmPersonFull(pInputMsg186.getROWCCMN05SIG06().getSzNmPersonFull());
        pCCMN71DInputRec.setSzCdPersonEthnicGroup(pInputMsg186.getROWCCMN05SIG06().getSzCdPersonEthnicGroup());
        pCCMN71DInputRec.setDtDtPersonBirth(pInputMsg186.getROWCCMN05SIG06().getDtDtPersonBirth());
        pCCMN71DInputRec.setArchInputStruct(pInputMsg186.getArchInputStruct());
        
        /*
        ** Create event for the New Using. Attach it to the idstage
        ** of the new call.
        */
        rc = ccmn71dAUDdam(sqlca, pCCMN71DInputRec, pCCMN71DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg167.setUlIdPerson(pCCMN71DOutputRec.getUlIdPerson());
                //  Place the new intake onto the workload of the worker.
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;// Break for success of cinv51d (CL)
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;// break for SQL_NOT_FOUND for CINV51D(VP)
        }
        
        
        return rc;
    }

    static int CallCAUDD5D(CCMN05SI pInputMsg187, CCMN05SO pOutputMsg168, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i115 = 0;
        int rc = 0;/* Return code */
        CAUDD5DI pCAUDD5DInputRec = null;
        CAUDD5DO pCAUDD5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD5DInputRec = new CAUDD5DI();
        pCAUDD5DOutputRec = new CAUDD5DO();
        pCAUDD5DInputRec.setArchInputStruct(pInputMsg187.getArchInputStruct());
        if (pInputMsg187.getUlIdPerson() == 0) {
            pCAUDD5DInputRec.setUlIdPerson(pOutputMsg168.getUlIdPerson());
        }
        else {
            pCAUDD5DInputRec.setUlIdPerson(pInputMsg187.getUlIdPerson());
        }
        
        
        for (i115 = 0;((i115 < pInputMsg187.getUlRowQty_ARRAY().getUlRowQty(2)) && (rc == 0));i115++) {
            pCAUDD5DInputRec.setSzCdPersonRace(pInputMsg187.getROWCCMN05SIG08_ARRAY().getROWCCMN05SIG08(i115).getSzCdPersonRace());
            (pCAUDD5DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg187.getROWCCMN05SIG08_ARRAY().getROWCCMN05SIG08(i115).getSzCdScrDataAction()));
            
            if (pCAUDD5DInputRec.getArchInputStruct().getCReqFuncCd() != null) {
                
                //  Call DAM
                rc = caudd5dAUDdam(sqlca, pCAUDD5DInputRec, pCAUDD5DOutputRec);
            }
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                    // SIR#3054 Added NoRowsReturned
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        return rc;
    }

    static int CallCAUDD4D(CCMN05SI pInputMsg188, CCMN05SO pOutputMsg169, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i116 = 0;
        int rc = 0;
        CAUDD4DI pCAUDD4DInputRec = null;
        CAUDD4DO pCAUDD4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD4DInputRec = new CAUDD4DI();
        pCAUDD4DOutputRec = new CAUDD4DO();
        pCAUDD4DInputRec.setArchInputStruct(pInputMsg188.getArchInputStruct());
        if (pInputMsg188.getUlIdPerson() == 0) {
            pCAUDD4DInputRec.setUlIdPerson(pOutputMsg169.getUlIdPerson());
        }
        else {
            pCAUDD4DInputRec.setUlIdPerson(pInputMsg188.getUlIdPerson());
        }
        
        for (i116 = 0;((i116 < pInputMsg188.getUlRowQty_ARRAY().getUlRowQty(3)) && (rc == 0));i116++) {
            pCAUDD4DInputRec.setSzCdPersonEthnicity(pInputMsg188.getROWCCMN05SIG09_ARRAY().getROWCCMN05SIG09(i116).getSzCdPersonEthnicity());
            (pCAUDD4DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg188.getROWCCMN05SIG09_ARRAY().getROWCCMN05SIG09(i116).getSzCdScrDataAction()));
            if (pCAUDD4DInputRec.getSzCdPersonEthnicity()[0] != null) {
                // Capture Supervisor's ID into locally declared 2nd parameter
                rc = caudd4dAUDdam(sqlca, pCAUDD4DInputRec, pCAUDD4DOutputRec);
            }
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                case NO_DATA_FOUND:
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    
                    //  Set explan_data to usRow
                    // Note: Use sprintf
                    
                    break;
            }
        }
        return rc;
    }

    static int CallCCMN70D(CCMN05SI pInputMsg189, CCMN05SO pOutputMsg170, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN70DI pCCMN70DInputRec = null;
        CCMN70DO pCCMN70DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN70DInputRec = new CCMN70DI();
        pCCMN70DOutputRec = new CCMN70DO();
        pCCMN70DInputRec.setUlIdPerson(pOutputMsg170.getUlIdPerson());
        pCCMN70DInputRec.setTsLastUpdate(pInputMsg189.getROWCCMN05SIG00().getTsLastUpdate());
        pCCMN70DInputRec.setUlIdEmpJobHistory(pInputMsg189.getROWCCMN05SIG00().getUlIdEmpJobHistory());
        pCCMN70DInputRec.setSzCdEmpProgram(pInputMsg189.getROWCCMN05SIG00().getSzCdEmpProgram());
        pCCMN70DInputRec.setSzCdEmployeeClass(pInputMsg189.getROWCCMN05SIG00().getSzCdEmployeeClass());
        pCCMN70DInputRec.setSzIdEmployeeLogon(pInputMsg189.getROWCCMN05SIG00().getSzIdEmployeeLogon());
        pCCMN70DInputRec.setDtDtEmpHire(pInputMsg189.getROWCCMN05SIG00().getDtDtEmpHire());
        pCCMN70DInputRec.setDtDtEmpLastAssigned(pInputMsg189.getROWCCMN05SIG00().getDtDtEmpLastAssigned());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        pCCMN70DInputRec.setDtDtEmpTermination(pInputMsg189.getROWCCMN05SIG00().getDtDtEmpTermination());
        pCCMN70DInputRec.setUlIdOffice(pInputMsg189.getROWCCMN05SIG00().getUlIdOffice());
        pCCMN70DInputRec.setBIndActiveStatus(pInputMsg189.getROWCCMN05SIG00().getBIndActiveStatus());
        pCCMN70DInputRec.setBIndEmpConfirmedHrmis(pInputMsg189.getROWCCMN05SIG00().getBIndEmpConfirmedHrmis());
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCCMN70DInputRec.setBIndEmpPendingHrmis(pInputMsg189.getROWCCMN05SIG00().getBIndEmpPendingHrmis());
        pCCMN70DInputRec.setLNbrEmpActivePct(pInputMsg189.getROWCCMN05SIG00().getLNbrEmpActivePct());
        pCCMN70DInputRec.setArchInputStruct(pInputMsg189.getArchInputStruct());
        /*
        ** If an event exists, then we need some information (timestamp,
        ** event status) from the EVENT table for processing by the
        ** InvalidateAprvl() and PostEvent() functions.
        */
        rc = ccmn70dAUDdam(sqlca, pCCMN70DInputRec, pCCMN70DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call the Invalidate Approval common function
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                //  Call Post Event to either:
                // 1) INSERT: it's a new checklist, therefore new event
                // 2) UPDATE: event exists, we modified it
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                //  Update the CPS_CHKLST table
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN73D(CCMN05SI pInputMsg190, CCMN05SO pOutputMsg171, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN73DI pCCMN73DInputRec = null;
        CCMN73DO pCCMN73DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN73DInputRec = new CCMN73DI();
        pCCMN73DOutputRec = new CCMN73DO();
        
        pCCMN73DInputRec.setUlIdPerson(pOutputMsg171.getUlIdPerson());
        pCCMN73DInputRec.setSzCdPersonIdType(pInputMsg190.getROWCCMN05SIG05().getSzCdPersonIdType());
        pCCMN73DInputRec.setUlIdPersonId(pInputMsg190.getROWCCMN05SIG05().getUlIdPersonId());
        pCCMN73DInputRec.setSzNbrPersonIdNumber(pInputMsg190.getROWCCMN05SIG05().getSzNbrPersonIdNumber());
        pCCMN73DInputRec.setSzDescPersonID(pInputMsg190.getROWCCMN05SIG05().getSzDescPersonID());
        pCCMN73DInputRec.setBIndPersonIDInvalid(pInputMsg190.getROWCCMN05SIG05().getBIndPersonIDInvalid());
        pCCMN73DInputRec.getDtPersonIDEnd().day = DateHelper.NULL_DATE;
        pCCMN73DInputRec.getDtPersonIDEnd().month = DateHelper.NULL_DATE;
        pCCMN73DInputRec.getDtPersonIDEnd().year = DateHelper.NULL_DATE;
        
        /*
        ** Call DAM
        */
        rc = ARC_UTLGetDateAndTime(pCCMN73DInputRec.getDtPersonIDStart() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        pCCMN73DInputRec.setArchInputStruct(pInputMsg190.getArchInputStruct());
        rc = ccmn73dAUDdam(sqlca, pCCMN73DInputRec, pCCMN73DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Call DAM
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                // Start end of switch # 2 logic
                
                break;
        }
        return rc;
    }

    static int CallCCMNA0D(CCMN05SI pInputMsg191, CCMN05SO pOutputMsg172, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNA0DI pCCMNA0DInputRec = null;
        CCMNA0DO pCCMNA0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNA0DInputRec = new CCMNA0DI();
        pCCMNA0DOutputRec = new CCMNA0DO();
        pCCMNA0DInputRec.setArchInputStruct(pInputMsg191.getArchInputStruct());
        
        pCCMNA0DInputRec.setUlIdPerson(pOutputMsg172.getUlIdPerson());
        if (pInputMsg191.getROWCCMN05SIG01().getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
            pCCMNA0DInputRec.setUlIdName(pInputMsg191.getROWCCMN05SIG01().getUlIdName());
            rc = ARC_UTLGetDateAndTime(pCCMNA0DInputRec.getDtDtNameEndDate() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            pCCMNA0DInputRec.setTsLastUpdate(pInputMsg191.getROWCCMN05SIG01().getTsLastUpdate());
            
            //  Start Performance Timer
            rc = ccmna0dAUDdam(sqlca, pCCMNA0DInputRec, pCCMNA0DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    
                    //  Call CCMNC0D
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            
            if (rc != WtcHelperConstants.ARC_SUCCESS) {
                return rc;
            }
            pCCMNA0DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        rc = ARC_UTLGetDateAndTime(pCCMNA0DInputRec.getDtDtNameStartDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        pCCMNA0DInputRec.getDtDtNameEndDate().day = DateHelper.NULL_DATE;
        pCCMNA0DInputRec.getDtDtNameEndDate().month = DateHelper.NULL_DATE;
        pCCMNA0DInputRec.getDtDtNameEndDate().year = DateHelper.NULL_DATE;
        pCCMNA0DInputRec.setBIndNameInvalid(pInputMsg191.getROWCCMN05SIG01().getBIndNameInvalid());
        pCCMNA0DInputRec.setBIndNamePrimary(pInputMsg191.getROWCCMN05SIG01().getBIndNamePrimary());
        pCCMNA0DInputRec.setSzNmNameFirst(pInputMsg191.getROWCCMN05SIG01().getSzNmNameFirst());
        pCCMNA0DInputRec.setSzNmNameLast(pInputMsg191.getROWCCMN05SIG01().getSzNmNameLast());
        pCCMNA0DInputRec.setSzNmNameMiddle(pInputMsg191.getROWCCMN05SIG01().getSzNmNameMiddle());
        pCCMNA0DInputRec.setSzCdNameSuffix(pInputMsg191.getROWCCMN05SIG01().getSzCdNameSuffix());
        rc = ccmna0dAUDdam(sqlca, pCCMNA0DInputRec, pCCMNA0DOutputRec);
        
        /*
        ** Stop DAM Performance Timer
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CCMNA5D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN78D(CCMN05SI pInputMsg192, CCMN05SO pOutputMsg173, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i117 = 0;
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        CCMN78DI pCCMN78DInputRec = null;
        CCMN78DO pCCMN78DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN78DInputRec = new CCMN78DI();
        pCCMN78DOutputRec = new CCMN78DO();
        pCCMN78DInputRec.setArchInputStruct(pInputMsg192.getArchInputStruct());
        pCCMN78DInputRec.setUlIdPerson(pOutputMsg173.getUlIdPerson());
        
        for (i117 = 0;((i117 < pInputMsg192.getUlRowQty_ARRAY().getUlRowQty(0)) && (rc == WtcHelperConstants.ARC_SUCCESS));i117++) {
            pCCMN78DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getSzCdScrDataAction());
            
            if ((pCCMN78DInputRec.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) || (pCCMN78DInputRec.getArchInputStruct().getCReqFuncCd() == ServiceConstants.REQ_FUNC_CD_DELETE)) {
                pCCMN78DInputRec.setUlIdEmpJobHistory(pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getUlIdEmpJobHistory());
                pCCMN78DInputRec.setTsLastUpdate(pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getTsLastUpdate());
            }
            pCCMN78DInputRec.setSzBjnJob(pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getSzBjnJob());
            pCCMN78DInputRec.setSzCdJobClass(pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getSzCdJobClass());
            pCCMN78DInputRec.setSzCdJobFunction(pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getSzCdJobFunction());
            pCCMN78DInputRec.getDtDtJobEnd().day = pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getDtDtJobEnd().day;
            pCCMN78DInputRec.getDtDtJobEnd().month = pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getDtDtJobEnd().month;
            pCCMN78DInputRec.getDtDtJobEnd().year = pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getDtDtJobEnd().year;
            pCCMN78DInputRec.getDtDtJobStart().day = pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getDtDtJobStart().day;
            pCCMN78DInputRec.getDtDtJobStart().month = pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getDtDtJobStart().month;
            pCCMN78DInputRec.getDtDtJobStart().year = pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getDtDtJobStart().year;
            pCCMN78DInputRec.setUlIdJobPersSupv(pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getUlIdJobPersSupv());
            pCCMN78DInputRec.setBIndJobAssignable(pInputMsg192.getROWCCMN05SIG02_ARRAY().getROWCCMN05SIG02(i117).getBIndJobAssignable());
            
            rc = ccmn78dAUDdam(sqlca, pCCMN78DInputRec, pCCMN78DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    if ((0 == pInputMsg192.getROWCCMN05SIG00().getUlIdEmpJobHistory()) && (WtcHelperConstants.REQ_FUNC_CD_ADD == pCCMN78DInputRec.getArchInputStruct().getCReqFuncCd())) {
                        pInputMsg192.getROWCCMN05SIG00().setUlIdEmpJobHistory(pCCMN78DOutputRec.getUlIdEmpJobHistory());
                    }
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    // Everything okay
                    
                    break;
            }
        }
        return rc;
    }

    static int CallCCMN98D(CCMN05SI pInputMsg193, CCMN05SO pOutputMsg174, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i118 = 0;
        int rc = 0;/* Return code */
        CCMN98DI pCCMN98DInputRec = null;
        CCMN98DO pCCMN98DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN98DInputRec = new CCMN98DI();
        pCCMN98DOutputRec = new CCMN98DO();
        pCCMN98DInputRec.setArchInputStruct(pInputMsg193.getArchInputStruct());
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        /*
        ** person
        */
        pCCMN98DInputRec.setUlIdPerson(pOutputMsg174.getUlIdPerson());
        
        for (i118 = 0;((i118 < pInputMsg193.getUlRowQty_ARRAY().getUlRowQty(1)) && (rc == 0));i118++) {
            pCCMN98DInputRec.setSzCdEmpSkill(pInputMsg193.getROWCCMN05SIG03_ARRAY().getROWCCMN05SIG03(i118).getSzCdEmpSkill());
            pCCMN98DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg193.getROWCCMN05SIG03_ARRAY().getROWCCMN05SIG03(i118).getSzCdScrDataAction());
            
            if (pCCMN98DInputRec.getArchInputStruct().getCReqFuncCd() != null) {
                rc = ccmn98dAUDdam(sqlca, pCCMN98DInputRec, pCCMN98DOutputRec);
            }
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    //  Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    //  If no row was found on the CASE_MERGE table ZZZ is not
                    // an acceptable choice.  Return MSG_INV_DISP_INVALID
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    break;
                    
                default :
                    
                    // ochumd Begin SIR 23427
                    //  Intake Allegation
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        
        return rc;
    }

    static int CallCCMN49D(CCMN05SI pInputMsg194, CCMN05SO pOutputMsg175, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN49DI pCCMN49DInputRec = null;
        CCMN49DO pCCMN49DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN49DInputRec = new CCMN49DI();
        pCCMN49DOutputRec = new CCMN49DO();
        pCCMN49DInputRec.setArchInputStruct(pInputMsg194.getArchInputStruct());
        pCCMN49DInputRec.setUlIdPerson(pOutputMsg175.getUlIdPerson());
        pCCMN49DInputRec.setSzCdUnitMemberInOut(pInputMsg194.getROWCCMN05SIG04().getSzCdUnitMemberInOut());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCCMN49DInputRec.setSzCdUnitMemberRole(pInputMsg194.getROWCCMN05SIG04().getSzCdUnitMemberRole());
        pCCMN49DInputRec.setUlIdUnit(pInputMsg194.getROWCCMN05SIG04().getUlIdUnit());
        if (pInputMsg194.getROWCCMN05SIG04().getUlIdUnitEmpLink() == 0) {
            pCCMN49DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        else {
            pCCMN49DInputRec.setUlIdUnitEmpLink(pInputMsg194.getROWCCMN05SIG04().getUlIdUnitEmpLink());
            pCCMN49DInputRec.setTsLastUpdate(pInputMsg194.getROWCCMN05SIG04().getTsLastUpdate());
            pCCMN49DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        rc = ccmn49dAUDdam(sqlca, pCCMN49DInputRec, pCCMN49DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CLSC20D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                
                //  Set rc to ARC_SUCCESS
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNC2D(CCMN05SI pInputMsg195, CCMN05SO pOutputMsg176, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMNC2DI pCCMNC2DInputRec = null;
        CCMNC2DO pCCMNC2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC2DInputRec = new CCMNC2DI();
        pCCMNC2DOutputRec = new CCMNC2DO();
        pCCMNC2DInputRec.setArchInputStruct(pInputMsg195.getArchInputStruct());
        
        switch (pInputMsg195.getArchInputStruct().getCReqFuncCd()) {
            case WtcHelperConstants.REQ_FUNC_CD_DELETE:
                pCCMNC2DInputRec.setSzWcdCdPersonCategory2(PERSON_CATEGORY_FORMER_EMPLOYEE);
                pCCMNC2DInputRec.setSzCdCategoryCategory(PERSON_CATEGORY_EMPLOYEE);
                pCCMNC2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                
                break;
            case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                if (true == IsDateNull(pInputMsg195.getROWCCMN05SIG00().getDtDtEmpTermination())) {
                    pCCMNC2DInputRec.setSzWcdCdPersonCategory2(PERSON_CATEGORY_EMPLOYEE);
                    pCCMNC2DInputRec.setSzCdCategoryCategory(PERSON_CATEGORY_FORMER_EMPLOYEE);
                }
                else {
                    pCCMNC2DInputRec.setSzWcdCdPersonCategory2(PERSON_CATEGORY_FORMER_EMPLOYEE);
                    pCCMNC2DInputRec.setSzCdCategoryCategory(PERSON_CATEGORY_EMPLOYEE);
                }
                
                //  END - SEND TO DO TO PRIMARY WORKER FOR
                // INQUIRY - CSUB40U
                
                
                break;
            case WtcHelperConstants.REQ_FUNC_CD_ADD:
                //  This indicates that a Law Enforcement Notification ToDo for
                // the stage has been found.  So, now we must determine if the
                // ToDo is complete or not
                if (false == IsDateNull(pInputMsg195.getROWCCMN05SIG00().getDtDtEmpTermination())) {
                    pCCMNC2DInputRec.setSzCdCategoryCategory(PERSON_CATEGORY_FORMER_EMPLOYEE);
                }
                else {
                    pCCMNC2DInputRec.setSzCdCategoryCategory(PERSON_CATEGORY_EMPLOYEE);
                }
                
                break;
        }
        pCCMNC2DInputRec.setUlIdPerson(pOutputMsg176.getUlIdPerson());
        rc = ccmnc2dAUDdam(sqlca, pCCMNC2DInputRec, pCCMNC2DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CLSS11D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                // END - CREATE STAGE - CINT12D
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                // END - CREATE A SITUATION - CINT13D
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMNE0D_IN(CCMN05SI pInputMsg196, CCMN05SO pOutputMsg177, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMNE0DI pCCMNE0DInputRec = null;
        CCMNE0DO pCCMNE0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE0DInputRec = new CCMNE0DI();
        pCCMNE0DOutputRec = new CCMNE0DO();
        pCCMNE0DInputRec.setUlIdPerson(pOutputMsg177.getUlIdPerson());
        pCCMNE0DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_IN_ASSIGNED);
        pCCMNE0DInputRec.setArchInputStruct(pInputMsg196.getArchInputStruct());
        pCCMNE0DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        
        
        /*
        ** Call CSES21D
        */
        rc = ccmne0dAUDdam(sqlca, pCCMNE0DInputRec, pCCMNE0DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  RetVal not sufficient for Impact error handling.
                // Set rc to error code and call PROCESS_TUX_RC_ERROR
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        
        return rc;
    }

    static int CallCCMNF5D(CCMN05SI pInputMsg197, CCMN05SO * pOutputMsg178, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNF5DI pCCMNF5DInputRec = null;
        CCMNF5DO pCCMNF5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF5DInputRec = new CCMNF5DI();
        pCCMNF5DOutputRec = new CCMNF5DO();
        pCCMNF5DInputRec.setUlIdPerson(pInputMsg197.getUlIdPerson());
        pCCMNF5DInputRec.setArchInputStruct(pInputMsg197.getArchInputStruct());
        pCCMNF5DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        
        /*
        ** Call CSES38D
        */
        rc = ccmnf5dSPdam(sqlca, pCCMNF5DInputRec, pCCMNF5DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                EXEC SQL COMMIT;
                
                //  Get CurrentDate
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNF7D(CCMN05SI pInputMsg198, CCMN05SO * pOutputMsg179, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMNF7DI pCCMNF7DInputRec = null;
        CCMNF7DO pCCMNF7DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF7DInputRec = new CCMNF7DI();
        pCCMNF7DOutputRec = new CCMNF7DO();
        pCCMNF7DInputRec.setUlIdPerson(pInputMsg198.getUlIdPerson());
        pCCMNF7DInputRec.setArchInputStruct(pInputMsg198.getArchInputStruct());
        pCCMNF7DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        
        /*
        ** Call DAM
        */
        rc = ccmnf7dSPdam(sqlca, pCCMNF7DInputRec, pCCMNF7DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case ORACLE_INTEGRITY_CONSTRAINT:
                EXEC SQL ROLLBACK;
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNG5D(CCMN05SI pInputMsg199, CCMN05SO * pOutputMsg180, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMNG5DI pCCMNG5DInputRec = null;
        CCMNG5DO pCCMNG5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG5DInputRec = new CCMNG5DI();
        
        pCCMNG5DOutputRec = new CCMNG5DO();
        pCCMNG5DInputRec.setUlIdPerson(pInputMsg199.getUlIdPerson());
        pCCMNG5DInputRec.setArchInputStruct(pInputMsg199.getArchInputStruct());
        
        
        /*
        ** Call CSES41D
        */
        rc = ccmng5dQUERYdam(sqlca, pCCMNG5DInputRec, pCCMNG5DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_STF_APPRVR_MOD;
                rc = Messages.MSG_CMN_STF_APPRVR_MOD;
                
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;// for SQL_SUCCESS CSEC04D
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNG6D(CCMN05SI pInputMsg200, CCMN05SO * pOutputMsg181, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMNG6DI pCCMNG6DInputRec = null;
        CCMNG6DO pCCMNG6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG6DInputRec = new CCMNG6DI();
        
        pCCMNG6DOutputRec = new CCMNG6DO();
        pCCMNG6DInputRec.setUlIdPerson(pInputMsg200.getUlIdPerson());
        pCCMNG6DInputRec.setArchInputStruct(pInputMsg200.getArchInputStruct());
        
        rc = ccmng6dQUERYdam(sqlca, pCCMNG6DInputRec, pCCMNG6DOutputRec);
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_STF_APPRVR_DEL;
                
                // Calculate the date the todo should be displayed.
                rc = Messages.MSG_CMN_STF_APPRVR_DEL;
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                          sprintf(pReturnPB->appl_status.explan_data,
                //##                                  "%u",
                //##                                  usVersionRow);
                
                break;
            case NO_DATA_FOUND:
                
                // Call Arc function for calulation
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                          sprintf(pReturnPB->appl_status.explan_data,
                //##                                  "%u",
                //##                                  usVersionRow);
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static char IsDateNull(FndInt3date dtDate) {
        
        if ((dtDate.day == DateHelper.NULL_DATE) && (dtDate.month == DateHelper.NULL_DATE) && (dtDate.year == DateHelper.NULL_DATE)) {
            
            
            return true;
        }
        else {
            return false;
        }
    }

    static int CallCCMNE0D_OUT(CCMN05SI pInputMsg201, CCMN05SO pOutputMsg182, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNE0DI pCCMNE0DInputRec = null;
        CCMNE0DO pCCMNE0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE0DInputRec = new CCMNE0DI();
        pCCMNE0DOutputRec = new CCMNE0DO();
        pCCMNE0DInputRec.setUlIdPerson(pOutputMsg182.getUlIdPerson());
        pCCMNE0DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_OUT_ASSIGNED);
        pCCMNE0DInputRec.setArchInputStruct(pInputMsg201.getArchInputStruct());
        pCCMNE0DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        rc = ccmne0dAUDdam(sqlca, pCCMNE0DInputRec, pCCMNE0DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNH2D(CCMN05SI pInputMsg202, CCMN05SO pOutputMsg183, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNH2DI pCCMNH2DInputRec = null;
        CCMNH2DO pCCMNH2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNH2DInputRec = new CCMNH2DI();
        pCCMNH2DOutputRec = new CCMNH2DO();
        pCCMNH2DInputRec.setUlIdPerson(pOutputMsg183.getUlIdPerson());
        pCCMNH2DInputRec.setArchInputStruct(pInputMsg202.getArchInputStruct());
        pCCMNH2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        /* pOutputMsg->ArchOutputStruct.bMoreDataInd =
        pCRES57DOutputRec->ArchOutputStruct.bMoreDataInd;*/
        
        rc = ccmnh2dAUDdam(sqlca, pCCMNH2DInputRec, pCCMNH2DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCAUDE2D(CCMN05SI pInputMsg203, CCMN05SO pOutputMsg184, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CAUDE2DI pCAUDE2DInputRec = null;
        CAUDE2DO pCAUDE2DOutputRec = null;
        
        /* Allocate memory for DAM Input and Output Structures          */
        
        pCAUDE2DInputRec = new CAUDE2DI();
        
        pCAUDE2DOutputRec = new CAUDE2DO();
        pCAUDE2DInputRec.setArchInputStruct(pInputMsg203.getArchInputStruct());
        pCAUDE2DInputRec.setUlIdPerson(pOutputMsg184.getUlIdPerson());
        pCAUDE2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        
        
        /********** Start performance timer for Data Access Module ****************/
        rc = caude2dAUDdam(sqlca, pCAUDE2DInputRec, pCAUDE2DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                // 
                // Call DAM
                // 
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        return rc;
    }

    static int CallCCMND5D(CCMN05SI pInputMsg204, CCMN05SO * pOutputMsg185, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables for both ccmnd5d and ccmn49d
        */
        CCMND5DI pCCMND5DInputRec = null;
        CCMND5DO pCCMND5DOutputRec = null;
        
        CCMN49DI pCCMN49DInputRec = null;
        CCMN49DO pCCMN49DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        ** for both ccmnd5d and ccmn49d
        */
        pCCMND5DInputRec = new CCMND5DI();
        
        pCCMND5DOutputRec = new CCMND5DO();
        
        pCCMN49DInputRec = new CCMN49DI();
        
        /*
        ** Allocate memory for Output Structure
        */
        pCCMN49DOutputRec = new CCMN49DO();
        pCCMND5DInputRec.setUlIdPerson(pInputMsg204.getUlIdPerson());
        
        pCCMND5DInputRec.setUlIdUnit(pInputMsg204.getROWCCMN05SIG04().getUlIdUnit());
        pCCMND5DInputRec.setArchInputStruct(pInputMsg204.getArchInputStruct());
        
        rc = ccmnd5dQUERYdam(sqlca, pCCMND5DInputRec, pCCMND5DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pCCMN49DInputRec.setArchInputStruct(pInputMsg204.getArchInputStruct());
                pCCMN49DInputRec.setUlIdUnitEmpLink(pCCMND5DOutputRec.getUlIdUnitEmpLink());
                pCCMN49DInputRec.setTsLastUpdate(pCCMND5DOutputRec.getTsLastUpdate());
                
                pCCMN49DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                
                
                //  Call CCMN05U
                rc = ccmn49dAUDdam(sqlca, pCCMN49DInputRec, pCCMN49DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                        
                        //  On an UPDATE or DELETE statement, SQL_NOT_FOUND will be returned
                        // if there are no records meeting the WHERE clause criteria.  In
                        // most cases this will be caused by a timestamp mismatch.
                        // pServiceStatus->explan_code should be set to the appropriate
                        // message by the programmer.
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                        //  On an INSERT or UPDATE statement, SQL_DUPLICATE_KEY is returned
                        // if there is an attempt to store a duplicate primary key value.
                        // pServiceStatus->explan_code should be set to the appropriate
                        // message by the programmer.
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        
                        
                        //  Call CCMN01U
                        rc = Messages.MSG_CMN_UPDATE_FAILED;
                        break;
                        
                    default :
                        
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNH4D(CCMN05SI pInputMsg205, CCMN05SO * pOutputMsg186, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMNH4DI pCCMNH4DInputRec = null;
        CCMNH4DO pCCMNH4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNH4DInputRec = new CCMNH4DI();
        pCCMNH4DOutputRec = new CCMNH4DO();
        pCCMNH4DInputRec.setUlIdPerson(pInputMsg205.getUlIdPerson());
        pCCMNH4DInputRec.setSzNmCase(pInputMsg205.getROWCCMN05SIG06().getSzNmPersonFull());
        pCCMNH4DInputRec.setSzNmPersonFull(pInputMsg205.getSzNmPersonFull());
        pCCMNH4DInputRec.setArchInputStruct(pInputMsg205.getArchInputStruct());
        pCCMNH4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmnh4dAUDdam(sqlca, pCCMNH4DInputRec, pCCMNH4DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNH5D(CCMN05SI pInputMsg206, CCMN05SO * pOutputMsg187, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNH5DI pCCMNH5DInputRec = null;
        CCMNH5DO pCCMNH5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNH5DInputRec = new CCMNH5DI();
        pCCMNH5DOutputRec = new CCMNH5DO();
        
        pCCMNH5DInputRec.setUlIdPerson(pInputMsg206.getUlIdPerson());
        pCCMNH5DInputRec.setSzNmStage(pInputMsg206.getROWCCMN05SIG06().getSzNmPersonFull());
        pCCMNH5DInputRec.setSzNmPersonFull(pInputMsg206.getSzNmPersonFull());
        pCCMNH5DInputRec.setArchInputStruct(pInputMsg206.getArchInputStruct());
        pCCMNH5DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmnh5dAUDdam(sqlca, pCCMNH5DInputRec, pCCMNH5DOutputRec);
        switch (rc) {
                
                // It is possible for a person to be entered into the system with
                // no rows on the name table
            case WtcHelperConstants.SQL_SUCCESS:
                
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMNI1D(CCMN05SI pInputMsg207, CCMN05SO * pOutputMsg188, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMNI1DI pCCMNI1DInputRec = null;
        CCMNI1DO pCCMNI1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNI1DInputRec = new CCMNI1DI();
        pCCMNI1DOutputRec = new CCMNI1DO();
        pCCMNI1DInputRec.setUlIdUnit(pInputMsg207.getROWCCMN05SIG04().getUlIdUnit());
        pCCMNI1DInputRec.setArchInputStruct(pInputMsg207.getArchInputStruct());
        
        rc = ccmni1dQUERYdam(sqlca, pCCMNI1DInputRec, pCCMNI1DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) 
        {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pCCMNI1DOutputRec.getUlSysNbrGenericCntr() >= 50) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CMN_MORE_THAN_50_MEMBERS;
                    rc = Messages.MSG_CMN_MORE_THAN_50_MEMBERS;
                }
                else {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                
                
                
                //  SIR 2977 - Added missing break statements to the
                // nested switches.  Missing statements were causing the
                // logic to fall into the default case and failing the
                // service.     BSM
                break;
        }
        
        return rc;
    }

}
