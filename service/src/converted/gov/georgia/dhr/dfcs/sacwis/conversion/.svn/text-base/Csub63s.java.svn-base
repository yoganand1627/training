package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB63SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CSUB63s.src
**
** Service Name:   CHG STG TYPE RTRV
**
** Description:   This service will receive Id Event and Id Stage.
**                  these two elements will be used as inputs to call a
**                  DAM which will perform a full row from STAGE table.  
**                  The message will only return CD STAGE TYPE.  It will 
**                  also call a DAM to retrieve information from the 
**                  Event Table.
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/6/95 
** 
** Programmer:    Brian Walker
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:20:04  $
**                      $Modtime:   28 Mar 1996 23:25:20  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub63s {
    static final String STATUS_NEW4 = "NEW";
    CSUB63SO CSUB63S(CSUB63SI csub63si) {
        CSUB63SO csub63so = new CSUB63SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        public int i435 = 0;
        
        /*
        ** Declare local variables 
        */
        
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        CCMN45DI pCCMN45DInputRec = null;/* Event simple retrieve */
        CCMN45DO pCCMN45DOutputRec = null;/* pointer to DAM output record */
        rc = ARC_PRFServiceStartTime_TUX(csub63si.getArchInputStruct());
        csub63so.getCSUB63SOG01().setSzCdEventStatus(STATUS_NEW4);
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        pCINT40DInputRec.setUlIdStage(csub63si.getUlIdStage());
        
        
        /*
        ** Call CCMND9D
        */
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.explan_code = SUCCESS;
                pServiceStatus.severity = FND_SEVERITY_OK;
                
                //  Set rc
                rc = WtcHelperConstants.ARC_SUCCESS;
                csub63so.getCSUB63SOG00().setTsLastUpdate(pCINT40DOutputRec.getTsLastUpdate());
                csub63so.getCSUB63SOG00().setSzCdStageType(pCINT40DOutputRec.getSzCdStageType());
                csub63so.getCSUB63SOG00().setSzCdStage(pCINT40DOutputRec.getSzCdStage());
                
                //  An ID EVENT has been passed in, implying the status is PEND
                // ERR#1797 if duplicates were found on ADD or UPDATE skip this code
                // 11/14/2002 - DWW: replaced this line:
                // if ((0 != pInputMsg->ulIdEvent) && (bOKDuplicates))
                // with the following line to make this service function like other
                // services, in that it returns an error when a duplicate occurs
                if (0 != csub63si.getUlIdEvent()) {
                    
                    //  Initialize Service Status Fields
                    
                    //  Perform Main Processing
                    
                    // 
                    // (BEGIN): CCMN45D -- GET EVENT SMP
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN45DInputRec = new CCMN45DI();
                    
                    pCCMN45DOutputRec = new CCMN45DO();
                    pCCMN45DInputRec.setUlIdEvent(csub63si.getUlIdEvent());
                    
                    rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            csub63so.getCSUB63SOG01().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                            csub63so.getCSUB63SOG01().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                            
                            csub63so.getCSUB63SOG01().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                            
                            csub63so.getCSUB63SOG01().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                            csub63so.getCSUB63SOG01().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                            csub63so.getCSUB63SOG01().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                            csub63so.getCSUB63SOG01().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                            csub63so.getCSUB63SOG01().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                            csub63so.getCSUB63SOG01().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    }
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub63si.getArchInputStruct() , csub63so.getArchOutputStruct());
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
        return csub63so;
    }

}
