package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV50DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH5DO;
/**************************************************************************
**
** Module File:   CINV26S.src
**
** Service Name:  AUD Name List/Detail
**
** Description:   This Service calls a DAM to update Name information
**                about a person on the Name Table and a DAM to update
**                NM PERSON FULL on the Person Table.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/22/95
**
** Programmer:    DAVE SNIDER
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   17 Mar 1997 19:29:40  $
**                      $Modtime:   12 Mar 1997 22:08:56  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/27/95  YANTISTK  SIR 1710 - Added CheckStageEventStatus common
**                      function.
**  05/19/96    KRD     SIR 2593 - When an person's primary name changes, it
**                      is necessary to update the case name of any open APS
**                      case in which the employee is a victim or client.
**                      Required the addition of two new dams, CCMNH4D and
**                      CCMNH5D.  Other global changes necessary to match the
**                      Release 1 service shell.
**  03/12/97    KRD     SIR 10348 - To ensure that the timestamps on the
**                      name's start and end dates are set properly, we need
**                      to process the name changes in reverse order.
**                      Required a change to the loop processing in
**                      CallCINV32D().
**
**	05/14/01  GRIMSHAN	Code added so that if a person with the
**						SEC_MNTN_PERSON attribute is allowed to save by
**						not going into the common function if the flag is
**						passed in from the AKA Detail Window (CINV05W.WIN)
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv26s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /*
    ** SIR 2593 - macros needed for " et al" processing
    */
    public static final String CASE_NM_ET_AL = " et al";
    public static final int CASE_NM_ET_AL_LEN = 6;
    CINV26SO CINV26S(CINV26SI cinv26si) {
        CINV26SO cinv26so = new CINV26SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/* SIR#1710 */
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        /*
        ** SIR 2593 - Need a temporary string to copy into
        */
        String szTempName = new String();
        rc = ARC_PRFServiceStartTime_TUX(cinv26si.getArchInputStruct());
        /**************************************************************************
        ** (END): Retrieve DAM: ccmnb8d     ** Stage progression simple retrieve
        **************************************************************************/
        
        
        /*************************************************************************
        ** Start here with logic if there's a new placement being added or
        ** a placement removal being saved.
        **************************************************************************/
        
        if ('N' == cinv26si.getBSysIndGeneric()) {
            // 
            // SIR#1710
            // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
            // 
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cinv26si.getArchInputStruct());
            
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv26si.getArchInputStruct().getCReqFuncCd());
            pCCMN06UInputRec.setUlIdStage(cinv26si.getUlIdStage());
            
            pCCMN06UInputRec.setSzCdTask(cinv26si.getSzCdTask());
            
            // Call DAM to populate names
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                case Messages.MSG_SYS_STAGE_CLOSED:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
                case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
                case Messages.MSG_SYS_MULT_INST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        /***********************************************************************
        ** SIR 23223 - do the logic for updating the slots on the new
        ** facility.  The slots should be decreased for a new placement, and
        ** increased for a removal
        ***********************************************************************/
        
        /*
        ** SIR 14053 - use id resource to get resource facility type.  if the
        ** facility type is 70 or 71, then update the open slots
        */
        
        if (SUCCESS == RetVal) {
            
            rc = Cint02s.CallCINV32D(cinv26si, cinv26so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
            
            // SIR 14053 added the condition to only do this for F/A Homes
            if ('Y' == cinv26si.getBSysIndUpdateFullName()) {
                rc = CallCINV50D(cinv26si, cinv26so, pServiceStatus);
                
                //  Analyze error code
                
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = Ccmn05s.CallCCMNH4D(cinv26si, cinv26so, pServiceStatus);
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                rc = Ccmn05s.CallCCMNH5D(cinv26si, cinv26so, pServiceStatus);
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                if (cinv26si.getSzNmPersonFull_ARRAY().getSzNmPersonFull(0).length() <= (Ccmn85s.NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN - 1)) {
                    cinv26si.getSzNmPersonFull_ARRAY().getSzNmPersonFull(0) += CASE_NM_ET_AL;
                }
                
                else {
                    szTempName = CStringUtils.setCharAt(szTempName, 0, null);
                    szTempName = cinv26si.getSzNmPersonFull_ARRAY().getSzNmPersonFull(0);
                    szTempName += CASE_NM_ET_AL;
                    cinv26si.getSzNmPersonFull_ARRAY().setSzNmPersonFull(0, szTempName);
                }
                if (cinv26si.getSzNmPersonFull_ARRAY().getSzNmPersonFull(1).length() <= (Ccmn85s.NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN - 1)) {
                    cinv26si.getSzNmPersonFull_ARRAY().getSzNmPersonFull(1) += CASE_NM_ET_AL;
                }
                
                else {
                    szTempName = CStringUtils.setCharAt(szTempName, 0, null);
                    szTempName = cinv26si.getSzNmPersonFull_ARRAY().getSzNmPersonFull(1);
                    szTempName += CASE_NM_ET_AL;
                    cinv26si.getSzNmPersonFull_ARRAY().setSzNmPersonFull(1, szTempName);
                }
                rc = Ccmn05s.CallCCMNH4D(cinv26si, cinv26so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                rc = Ccmn05s.CallCCMNH5D(cinv26si, cinv26so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv26si.getArchInputStruct() , cinv26so.getArchOutputStruct());
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv26so;
    }

    static int CallCINV32D(CINV26SI pInputMsg679, CINV26SO * pOutputMsg629, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* Declare local variables */
        CINV32DI pCINV32DInputRec = null;
        CINV32DO pCINV32DOutputRec = null;
        _SSANAMESTRUCT SSANameStruct;
        int i342 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV32DInputRec = new CINV32DI();
        
        
        pCINV32DOutputRec = new CINV32DO();
        pCINV32DInputRec.setArchInputStruct(pInputMsg679.getArchInputStruct());
        
        
        /*
        ** Populate Input Structure for DAM
        **
        ** SIR 10348 - CINV32D keeps track of the timestamps on the Start and End
        ** dates.  The primary names in the input message are sorted in
        ** reverse-modified order (i.e., the most recent primary name added or
        ** modified will be at beginning of the input message).  To ensure that
        ** the names receive the timestamps in the proper order, we need to
        ** process the list in reverse order.  This requires a change to the
        ** for loop from:
        **     for (i=0; i<pInputMsg->ArchInputStruct.ulPageSizeNbr; i++)
        ** to:
        **     for (i=pInputMsg->ArchInputStruct.ulPageSizeNbr - 1; i>=0; i--)
        */
        for (i342 = pInputMsg679.getArchInputStruct().getUlPageSizeNbr() - 1;i342 >= 0;i342--) {
            pCINV32DInputRec.setSzCdNameSuffix(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getSzCdNameSuffix());
            pCINV32DInputRec.setDtDtNameEndDate(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getDtDtNameEndDate());
            pCINV32DInputRec.setDtDtNameStartDate(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getDtDtNameStartDate());
            pCINV32DInputRec.setUlIdName(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getUlIdName());
            pCINV32DInputRec.setUlIdPerson(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getUlIdPerson());
            pCINV32DInputRec.setBIndNameInvalid(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getBIndNameInvalid());
            pCINV32DInputRec.setBIndNamePrimary(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getBIndNamePrimary());
            pCINV32DInputRec.setSzNmNameFirst(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getSzNmNameFirst());
            pCINV32DInputRec.setSzNmNameLast(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getSzNmNameLast());
            pCINV32DInputRec.setSzNmNameMiddle(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getSzNmNameMiddle());
            pCINV32DInputRec.setTsLastUpdate(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getTsLastUpdate());
            pCINV32DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg679.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i342).getSzCdScrDataAction());
            
            // Compare the DtPlcmtStart with Date of Birth
            rc = cinv32dAUDdam(sqlca, pCINV32DInputRec, pCINV32DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;// 1440 min. in one year
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
        }
        return rc;
    }

    static int CallCINV50D(CINV26SI pInputMsg680, CINV26SO * pOutputMsg630, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV50DI pCINV50DInputRec = null;
        CINV50DO pCINV50DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV50DInputRec = new CINV50DI();
        
        pCINV50DOutputRec = new CINV50DO();
        
        pCINV50DInputRec.setSzNmPersonFull(pInputMsg680.getSzNmPersonFull_ARRAY().getSzNmPersonFull(1));
        pCINV50DInputRec.setUlIdPerson(pInputMsg680.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(0).getUlIdPerson());
        pCINV50DInputRec.setArchInputStruct(pInputMsg680.getArchInputStruct());
        pCINV50DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinv50dAUDdam(sqlca, pCINV50DInputRec, pCINV50DOutputRec);
        
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
                
                
                //  Call CRES08D
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

    static int CallCCMNH4D(CINV26SI pInputMsg681, CINV26SO * pOutputMsg631, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMNH4DInputRec.setUlIdPerson(pInputMsg681.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(0).getUlIdPerson());
        pCCMNH4DInputRec.setSzNmCase(pInputMsg681.getSzNmPersonFull_ARRAY().getSzNmPersonFull(1));
        pCCMNH4DInputRec.setSzNmPersonFull(pInputMsg681.getSzNmPersonFull_ARRAY().getSzNmPersonFull(0));
        pCCMNH4DInputRec.setArchInputStruct(pInputMsg681.getArchInputStruct());
        pCCMNH4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmnh4dAUDdam(sqlca, /* DAM name should be in lower case */
        pCCMNH4DInputRec, pCCMNH4DOutputRec);
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

    static int CallCCMNH5D(CINV26SI pInputMsg682, CINV26SO * pOutputMsg632, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
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
        pCCMNH5DInputRec.setUlIdPerson(pInputMsg682.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(0).getUlIdPerson());
        pCCMNH5DInputRec.setSzNmStage(pInputMsg682.getSzNmPersonFull_ARRAY().getSzNmPersonFull(1));
        pCCMNH5DInputRec.setSzNmPersonFull(pInputMsg682.getSzNmPersonFull_ARRAY().getSzNmPersonFull(0));
        pCCMNH5DInputRec.setArchInputStruct(pInputMsg682.getArchInputStruct());
        pCCMNH5DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        rc = ccmnh5dAUDdam(sqlca, pCCMNH5DInputRec, pCCMNH5DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                // It is possible for a person to be entered into the system with
                // no rows on the name table
                
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

}
