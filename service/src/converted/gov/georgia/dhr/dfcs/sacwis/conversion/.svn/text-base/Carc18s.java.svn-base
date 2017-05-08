package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE1DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CARC18S.src
**
** Service Name:  CARC18S
**
** Description:   This service adds, updates, and deletes staff security
**                information and staff temporary assignments.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  09-OCT-95
**
** Programmer:    adkinsmc
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:25:46  $
**                      $Modtime:   28 Mar 1996 22:10:50  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12/12/95  WANGSS    All Email Address references removed due to STARC
**                      sign-off
**  04/03/01  APT       SECURITY UPGRADE - Deleted reference to CAUD23D.PC
**                      that updates security information on the EMPLOYEE
**                      table, as the field, CD_EMP_SECURITY_CLASS_NM will
**                      no longer be used.  Added a call to the new DAM,
**                      CAUDE1D.PC that wil add or delete rows on the
**                      EMP_SEC_CLASS_LINK table for a selected user and
**                      a Security Profile.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Carc18s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String ERR_SAVE_EMP_SEC_INFO = "ERX";
    CARC18SO CARC18S(CARC18SI carc18si) {
        CARC18SO carc18so = new CARC18SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Call CheckStageEventStatus
        */
        rc = ARC_UTLCheckServiceBatchBlock("CARC18S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //## short rc = FND_SUCCESS;
        
        /*********************************************************************
        **  APT 04/04/2001 BEGIN SECURITY UPGRADE
        **        Declare variables for a call to the new DAM, CAUDE1D.PC.
        *********************************************************************/
        CAUD22DI pCAUD22DInputRec = null;
        CAUD22DO pCAUD22DOutputRec = null;
        CAUD23DI pCAUD23DInputRec = null;
        CAUD23DO pCAUD23DOutputRec = null;
        CAUDE1DI pCAUDE1DInputRec = null;
        CAUDE1DO pCAUDE1DOutputRec = null;
        
        int usFunctionsRow = 0;
        int y = 0;
        /*********************************************************************
        **  APT 04/04/2001 END SECURITY UPGRADE
        *********************************************************************/
        
        int usRow = 0;
        int usInputRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(carc18si.getArchInputStruct());
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** OPTIONAL CODE NOTE (BEGIN): Generic AUD
        **************************************************************************/
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD23DInputRec = new CAUD23DI();
        
        pCAUD23DOutputRec = new CAUD23DO();
        
        pCAUD23DInputRec.setArchInputStruct(carc18si.getArchInputStruct());
        pCAUD23DInputRec.getArchInputStruct().setCReqFuncCd(carc18si.getArchInputStruct().getCReqFuncCd());
        pCAUD23DInputRec.setSzIdEmployeeLogon(carc18si.getSzIdEmployeeLogon());
        pCAUD23DInputRec.setTsLastUpdate(carc18si.getTsLastUpdate());
        
        pCAUD23DInputRec.setUlIdPerson(carc18si.getUlIdPerson());
        rc = caud23dAUDdam(sqlca, pCAUD23DInputRec, pCAUD23DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                // 
                // OPTIONAL CODE NOTE (BEGIN): Generic List AUD
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCAUD22DInputRec = new CAUD22DI();
                
                pCAUD22DOutputRec = new CAUD22DO();
                
                
                while ((usRow < carc18si.getArchInputStruct().getUlPageSizeNbr()) && (pServiceStatus.explan_code == SUCCESS)) {
                    pCAUD22DInputRec.setArchInputStruct(carc18si.getArchInputStruct());
                    pCAUD22DInputRec.getArchInputStruct().setCReqFuncCd(carc18si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getSzCdSysDataActionOutcome());
                    pCAUD22DInputRec.setUlIdEmpTempAssign(carc18si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getUlIdEmpTempAssign());
                    pCAUD22DInputRec.setTsLastUpdate(carc18si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getTsLastUpdate());
                    pCAUD22DInputRec.setDtDtAssignExpiration(carc18si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getDtDtAssignExpiration());
                    pCAUD22DInputRec.setUlIdPersonEmp(carc18si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getUlIdPerson());
                    pCAUD22DInputRec.setUlIdPersonDesignee(carc18si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getUlIdPersonDesignee());
                    
                    
                    //  Call CINV51D
                    rc = caud22dAUDdam(sqlca, pCAUD22DInputRec, pCAUD22DOutputRec);
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            break;
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                            break;
                            
                        default :
                            
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    usRow++;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                pServiceStatus.explan_data = ERR_SAVE_EMP_SEC_INFO;
                
                
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                pServiceStatus.explan_data = ERR_SAVE_EMP_SEC_INFO;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        if (pServiceStatus.severity == FND_SEVERITY_OK) {
            
            // Allocate memory for DAM Input and Output Structures
            
            pCAUDE1DInputRec = new CAUDE1DI();
            
            pCAUDE1DOutputRec = new CAUDE1DO();
            pCAUDE1DInputRec.setArchInputStruct(carc18si.getArchInputStruct());
            
            // 
            // APT 05/09/2001 SECURITY UPGRADE
            // Add loop through all of profiles in Security Profiles
            // Listbox and populate CAUDE1 DAM Input values for each.
            // 
            while ((y < pCAUDE1DInputRec.getArchInputStruct().getUlSysNbrReserved2()) && (pServiceStatus.explan_code == SUCCESS)) {
                
                pCAUDE1DInputRec.getArchInputStruct().setCReqFuncCd(carc18si.getROWCARC18SIG01_ARRAY().getROWCARC18SIG01(y).getSzCdSysDataActionOutcome());
                pCAUDE1DInputRec.setUlIdEmpSecLink(carc18si.getROWCARC18SIG01_ARRAY().getROWCARC18SIG01(y).getUlIdEmpSecLink());
                pCAUDE1DInputRec.setUlIdPerson(carc18si.getUlIdPerson());
                pCAUDE1DInputRec.setSzNmSecurityClass(carc18si.getROWCARC18SIG01_ARRAY().getROWCARC18SIG01(y).getSzNmSecurityClass());
                pCAUDE1DInputRec.setTsLastUpdate(carc18si.getROWCARC18SIG01_ARRAY().getROWCARC18SIG01(y).getTsLastUpdate());
                if (null != pCAUDE1DInputRec.getArchInputStruct().getCReqFuncCd()) {
                    
                    //  Call CINV51D
                    rc = caude1dAUDdam(sqlca, pCAUDE1DInputRec, pCAUDE1DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            break;
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                            break;
                            
                        default :
                            
                            //## BEGIN TUX/XML: Declare XML variables 
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                            
                    }
                }
                y++;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(carc18si.getArchInputStruct() , carc18so.getArchOutputStruct());
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
                
                //  Call CINV51D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return carc18so;
    }

}
