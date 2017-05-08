package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC45DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CARC17S.src
**
** Service Name:  CARC17D
**
** Description:   This service performs a full row update of the 
**                EMP TEMP ASSIGN table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  9/23/95
** 
** Programmer:    Belinda Muse
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:25:42  $
**                      $Modtime:   28 Mar 1996 22:10:48  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/11/96    KRD     SIR 2494 - A person may have an infinite number of
**                      designees, but a person may only have 5 assignees
**                      (i.e., be the designee of 5 people).  To ensure this
**                      restriction, it is necessary to check the number of
**                      assignees a person has before they can be added as a 
**                      designee.  This required the addition of a new DAM,
**                      CMSC45D, and a minor rewrite of the service code.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
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






public class Carc17s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int MAX_ASSIGNEES = 5;
    CARC17SO CARC17S(CARC17SI carc17si) {
        CARC17SO carc17so = new CARC17SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CARC17S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc     = FND_SUCCESS,
        int RetVal = SUCCESS;
        
        CAUD22DI pCAUD22DInputRec = null;
        CAUD22DO pCAUD22DOutputRec = null;
        
        /*
        ** SIR 2494 - Declare input/output records for DAM CMSC45D
        */
        CMSC45DI pCMSC45DInputRec = null;
        CMSC45DO pCMSC45DOutputRec = null;
        
        int usRow = 0;
        int usInputRow = 0;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(carc17si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** SIR 2494 - The following code has been rewritten to add a call to DAM
        ** CMSC45D for ADDs and UPDATEs.
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD22DInputRec = new CAUD22DI();
        
        pCAUD22DOutputRec = new CAUD22DO();
        
        pCMSC45DInputRec = new CMSC45DI();
        
        pCMSC45DOutputRec = new CMSC45DO();
        
        while ((usRow < carc17si.getArchInputStruct().getUlPageSizeNbr()) && (FND_SEVERITY_OK == pServiceStatus.severity) && (SUCCESS == RetVal)) {
            
            if ((WtcHelperConstants.REQ_FUNC_CD_UPDATE == carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getSzCdSysDataActionOutcome()) || (ServiceConstants.REQ_FUNC_CD_ADD == carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getSzCdSysDataActionOutcome())) {
                
                //  Call DAM
                pCMSC45DInputRec.setArchInputStruct(carc17si.getArchInputStruct());
                pCMSC45DInputRec.setUlIdPerson(carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getUlIdPerson());
                pCMSC45DInputRec.setUlIdPersonDesignee(carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getUlIdPersonDesignee());
                
                //  No need to populate the Output Message since it was used
                // as the DAM output
                
                rc = cmsc45dQUERYdam(sqlca, pCMSC45DInputRec, pCMSC45DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        if (MAX_ASSIGNEES > pCMSC45DOutputRec.getUlSysNbrGenericCntr()) {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            RetVal = SUCCESS;
                        }
                        
                        
                        else {
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_SEC_TOO_MANY_ASSIGNEES;
                            RetVal = Csub50s.FND_FAIL;
                        }
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            if (SUCCESS == RetVal) {
                
                pCAUD22DInputRec.setArchInputStruct(carc17si.getArchInputStruct());
                pCAUD22DInputRec.getArchInputStruct().setCReqFuncCd(carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getSzCdSysDataActionOutcome());
                pCAUD22DInputRec.setUlIdEmpTempAssign(carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getUlIdEmpTempAssign());
                pCAUD22DInputRec.setUlIdPersonEmp(carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getUlIdPerson());
                pCAUD22DInputRec.setUlIdPersonDesignee(carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getUlIdPersonDesignee());
                pCAUD22DInputRec.setDtDtAssignExpiration(carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getDtDtAssignExpiration());
                pCAUD22DInputRec.setTsLastUpdate(carc17si.getROWCARC18SIG00_ARRAY().getROWCARC18SIG00(usRow).getTsLastUpdate());
                rc = caud22dAUDdam(sqlca, pCAUD22DInputRec, pCAUD22DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        //  Set explan_data to usRow using sprintf
                        //##                sprintf(pReturnPB->appl_status.explan_data, "%u", usRow);
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:// caud28d
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                        
                        //  Set explan_data to usRow using sprintf
                        //##                sprintf(pReturnPB->appl_status.explan_data, "%u", usRow);
                        
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
            usRow++;
        }
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(carc17si.getArchInputStruct() , carc17so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
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
                
                //  Call dam to query event.
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return carc17so;
    }

}
