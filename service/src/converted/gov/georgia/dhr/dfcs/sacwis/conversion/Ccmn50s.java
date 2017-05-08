package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB5DO;
/**************************************************************************
** 
** Module File:   ccmn50s.src
**
** Service Name:  TASK LIST EVENT RTRV
**
** Description:   This service calls two DAMs used in determining
**                the enablement of pushbuttons on the Task List
**                window for a selected task.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  06/28/96 
** 
** Programmer:    Kymberly Maxham
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   29 Jul 1997 13:58:12  $
**                      $Modtime:   29 Jul 1997 08:46:48  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/01/97  GONZLACE  SIR 14100 - MHMR Enhancement/Request for Review
**                      Added CINT21D to retrieve a full row from the 
**                      stage table. 
**  07/28/97  GONZALCE  SIR 14176 - Removed Call to CINT21D.  This dam is
**                      being called by the other task list service, 
**                      cinv45s.src.
** 18 Feb 2003 DWW      Changed RC = 0 if RC = 1403, so that the service will 
**                      not return an error in IMPACT
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn50s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char IND_YES = '1';
    public static final char IND_NO = '0';
    
    /* Used by GetNumericalStatus when a status is passed that is not valid.
    */
    public static final int ERROR_INVALID_STATUS = - 1;
    /* 
    ** Event Information Variables
    */
    public static final String STATUS_NEW = "NEW";
    public static final String STATUS_PROC = "PROC";
    public static final String STATUS_COMP = "COMP";
    public static final String STATUS_PEND = "PEND";
    public static final String STATUS_APRV = "APRV";
    CCMN50SO CCMN50S(CCMN50SI ccmn50si) {
        CCMN50SO ccmn50so = new CCMN50SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(ccmn50si.getArchInputStruct());
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (IND_YES == ccmn50si.getCIndTaskRtrvPriorStage()) {
            
            //  Call Retrieve DAM
            rc = Ccmn85s.CallCCMNB5D(ccmn50si, ccmn50so, pServiceStatus);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            ccmn50so.setCSysIndTaskDetailList(IND_YES);
            ccmn50so.setCSysIndTaskNew(IND_NO);
        }
        
        
        /*
        ** If the PriorStage indicator is NO or NULL, proceed with calling
        ** CCMNB4D. Check first to see what the MultInst indicator is set to.
        ** PB enable logic varies according to whether multiple instances
        ** of a task are allowed.
        */
        
        else if (IND_YES == ccmn50si.getBIndTaskMultInstance()) {
            //  Call Retrieve DAM
            rc = Cinv15s.CallCCMNB4D(ccmn50si, ccmn50so, pServiceStatus);
            
            if (rc != NO_DATA_FOUND) {
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            else if (rc == NO_DATA_FOUND) {
                rc = 0;
            }
            
            if (!(ccmn50si.getSzCdEventStatus().compareTo("") != 0) ||!(ccmn50so.getSzCdEventStatus().compareTo("") != 0)) {
                ccmn50so.setCSysIndTaskNew(IND_YES);
                if (rc != NO_DATA_FOUND) {
                    ccmn50so.setCSysIndTaskDetailList(IND_YES);
                }
                
                
                else {
                    
                    ccmn50so.setCSysIndTaskDetailList(IND_NO);
                }
            }
            
            
            
            else {
                if (GetNumericalStatus(ccmn50so.getSzCdEventStatus()) >= GetNumericalStatus(ccmn50si.getSzCdEventStatus())) {
                    ccmn50so.setCSysIndTaskNew(IND_YES);
                }
                
                else {
                    ccmn50so.setCSysIndTaskNew(IND_NO);
                }
                
                ccmn50so.setCSysIndTaskDetailList(IND_YES);
            }
        }
        
        
        
        else {
            
            
            //  Start Performance Timer
            rc = Cinv15s.CallCCMNB4D(ccmn50si, ccmn50so, pServiceStatus);
            
            if (rc != NO_DATA_FOUND) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                ccmn50so.setCSysIndTaskDetailList(IND_YES);
                
                ccmn50so.setCSysIndTaskNew(IND_NO);
            }
            else {
                ccmn50so.setCSysIndTaskDetailList(IND_NO);
                ccmn50so.setCSysIndTaskNew(IND_YES);
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn50si.getArchInputStruct() , ccmn50so.getArchOutputStruct());
        
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
                
                
                //  Initialize Service Status Fields
                
                //  Perform Main Processing
                
                //  Set CCFC03SO WCD DtSystemDate to current date
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn50so;
    }

    static int CallCCMNB4D(CCMN50SI pInputMsg345, CCMN50SO pOutputMsg315, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMNB4DInputRec.setUlIdStage(pInputMsg345.getUlIdStage());
        pCCMNB4DInputRec.setSzCdTask(pInputMsg345.getSzCdTask());
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = ccmnb4dQUERYdam(sqlca, pCCMNB4DInputRec, pCCMNB4DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    // WE PROBABLY DONT NEED THIS CASE
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg315.setUlIdEvent(pCCMNB4DOutputRec.getUlIdEvent());
            pOutputMsg315.setSzCdEventStatus(pCCMNB4DOutputRec.getSzCdEventStatus());
        }
        return rc;
    }

    static int CallCCMNB5D(CCMN50SI pInputMsg346, CCMN50SO pOutputMsg316, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMNB5DI pCCMNB5DInputRec = null;
        CCMNB5DO pCCMNB5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB5DInputRec = new CCMNB5DI();
        
        pCCMNB5DOutputRec = new CCMNB5DO();
        pCCMNB5DInputRec.setUlIdStage(pInputMsg346.getUlIdStage());
        
        
        /*
        ** Call CMSC37D
        */
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = ccmnb5dQUERYdam(sqlca, pCCMNB5DInputRec, pCCMNB5DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg316.setUlIdPriorStage(pCCMNB5DOutputRec.getUlIdPriorStage());
        }
        return rc;
    }

    int GetNumericalStatus(String CdStatus) {
        int usCounter = 0;
        /* If it is later decided that performance concerns are a greater 
        ** priority that memory concerns then the following may be declared 
        ** "static".
        */
        
        /* The following decleration is an array (static pointer) of strings.  
        */
        String pszStatusList = "";
        
        /* The second expresion in the following for loop depends on the 
        ** last entry in pszStatusList being NULL.
        */
        for (usCounter = 0;usCounter != 0;usCounter++) {
            
            if (!(pszStatusList[usCounter].compareTo(CdStatus) != 0)) {
                return usCounter;
            }
        }
        return ERROR_INVALID_STATUS;
    }

}
