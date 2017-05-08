package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC36DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN00DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN00DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA1DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:   CCFC21S.src
**
** Service Name:  CCFC21S
**
** Description:   This service will retrieve all columns for an Id Case from
**                the CASE FILE MANAGEMENT table.  There will be one row for
**                for a specified Id Case. It will retrieve a full row from
**                both the OFFICE and UNIT tables with the ID OFFICE and 
**                ID UNIT respectively.  The service will also retrieve
**                a full row from the CAPS CASE table to get the closure date
**                for the Case.  Finally, it will check to see if the person
**                who entered the window is the primary worker.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 3, 1996 
** 
** Programmer:    Elizabeth P. Crystal
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:38:30  $
**                      $Modtime:   29 Mar 1996 23:57:16  $
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






public class Ccfc21s {
    static final char PRIMARY_WORKER1 = 'Y';
    static final char NOT_PRIMARY_WORKER = 'N';
    
    /*
    ** Declare FOUNDATION variables 
    */
    
    /*
    ** Declare local variables 
    */
    static final char PRS = 'P';
    CCFC21SO CCFC21S(CCFC21SI ccfc21si) {
        CCFC21SO ccfc21so = new CCFC21SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        public public public int i45 = 0;
        int ulIdOffice1 = 0;
        int ulIdUnit2 = 0;
        
        
        //##  long            rc = 0;
        
        
        
        /*
        ** This DAM will receive ID CASE from the service and will
        ** return an entire row from the CAPS_CASE table.
        */
        CCMNC5DI pCCMNC5DInputRec = null;
        CCMNC5DO pCCMNC5DOutputRec = null;
        
        /*
        ** This dam will retrieve a full row from the Case File Management 
        ** table.
        */
        CSES57DI pCSES57DInputRec = null;
        CSES57DO pCSES57DOutputRec = null;
        
        /*
        ** This dam will retrieve the COUNT from the stage table where the 
        ** ID PERSON entered along with the ID CASE match an ID PERSON 
        ** (primary worker) in one of the stages in the case.
        */
        CMSC36DI pCMSC36DInputRec = null;
        CMSC36DO pCMSC36DOutputRec = null;
        
        /*
        ** This dam retrieves a full row off the Office table.
        */
        CCMN00DI pCCMN00DInputRec = null;
        CCMN00DO pCCMN00DOutputRec = null;
        
        /*
        ** This DAM retrieves a full row from the UNIT table given ID UNIT. 
        */
        CCMNA1DI pCCMNA1DInputRec = null;
        CCMNA1DO pCCMNA1DOutputRec = null;
        
        
        /*
        ** Call CSES49D
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc21si.getArchInputStruct());
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_UTLGetDateAndTime(ccfc21so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        
        
        /*
        ** Begin CMSC36D - Primary Staff Smp
        */
        
        /*
        ** Allocate memory for DAM  CMSC36D Input and Output Structures
        */
        pCMSC36DInputRec = new CMSC36DI();
        
        pCMSC36DOutputRec = new CMSC36DO();
        pCMSC36DInputRec/* SIR #2141 Retreive ID_CASE    */
        .setArchInputStruct(ccfc21si.getArchInputStruct());
        pCMSC36DInputRec/* locally defined output of DAM */
        .setUlIdPerson(ccfc21si.getUlIdPerson());
        
        pCMSC36DInputRec.setUlIdCase(ccfc21si.getUlIdCase());
        rc = cmsc36dQUERYdam(sqlca, pCMSC36DInputRec, pCMSC36DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                // SIR 21891 - missing versioning
                //  Run-time Versioning
                
                //  Check buffer size
                
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                //  Initialize service status fields
                
                
                //  SIR 20217 - Check the Region if Progressing to PAL stage
                
                if (pCMSC36DOutputRec.getUlSysNbrGenericCntr() > 0) {
                    ccfc21so// SIR #2141 Retreivs rows for
                    .setCSysIndPrimaryWorker(PRIMARY_WORKER1);
                }
                
                else {
                    ccfc21so// CASE_MERGE for retreived case
                    .setCSysIndPrimaryWorker(NOT_PRIMARY_WORKER);
                }
                
                //  Begin CCMNC5D - Case Smp
                
                //  Allocate memory for DAM  CCMNC5D Input and Output Structures
                pCCMNC5DInputRec = new CCMNC5DI();
                
                pCCMNC5DOutputRec = new CCMNC5DO();
                
                pCCMNC5DInputRec.setArchInputStruct(ccfc21si.getArchInputStruct());
                pCCMNC5DInputRec.setUlIdCase(ccfc21si.getUlIdCase());
                rc = ccmnc5dQUERYdam(sqlca, pCCMNC5DInputRec, pCCMNC5DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        ccfc21so.setSzCdCaseProgram(pCCMNC5DOutputRec.getSzCdCaseProgram());
                        ccfc21so.setDtDtCaseClosed(pCCMNC5DOutputRec.getDtDtCaseClosed());
                        
                        
                        //  Begin CSES57D - Case File Management Rtrv
                        
                        //  Allocate memory for DAM  CSES57D Input and Output
                        // Structures
                        pCSES57DInputRec = new CSES57DI();
                        
                        pCSES57DOutputRec = new CSES57DO();
                        pCSES57DInputRec.setArchInputStruct(ccfc21si.getArchInputStruct());
                        
                        pCSES57DInputRec.setUlIdCase(ccfc21si.getUlIdCase());
                        
                        //  Call DAM
                        rc = cses57dQUERYdam(sqlca, pCSES57DInputRec, pCSES57DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                ulIdOffice1 = pCSES57DOutputRec.getUlIdOffice();
                                ulIdUnit2 = pCSES57DOutputRec.getUlIdUnit();
                                ccfc21so.setSzAddrCaseFileCity(pCSES57DOutputRec.getSzAddrCaseFileCity());
                                ccfc21so.setSzAddrCaseFileStLn1(pCSES57DOutputRec.getSzAddrCaseFileStLn1());
                                
                                ccfc21so.setSzAddrCaseFileStLn2(pCSES57DOutputRec.getSzAddrCaseFileStLn2());
                                ccfc21so.setSzCdCaseFileOfficeType(pCSES57DOutputRec.getSzCdCaseFileOfficeType());
                                ccfc21so.setDtDtCaseFileArchCompl(pCSES57DOutputRec.getDtDtCaseFileArchCompl());
                                
                                ccfc21so.setDtDtCaseFileArchElig(pCSES57DOutputRec.getDtDtCaseFileArchElig());
                                ccfc21so.setSzNmCaseFileOffice(pCSES57DOutputRec.getSzNmCaseFileOffice());
                                ccfc21so.setSztxtCaseFileLocateInfo(pCSES57DOutputRec.getSztxtCaseFileLocateInfo());
                                
                                //## BEGIN TUX/XML: Declare XML variables 
                                ccfc21so.setTsLastUpdate(pCSES57DOutputRec.getTsLastUpdate());
                                
                                //  SIR# 20217 - Skip ccmn03u if call to CINT21D fails
                                if (PRS == ccfc21so.getSzCdCaseFileOfficeType()) {
                                    //  Allocate memory for DAM  CCMN00D Input and Output 
                                    // Structures
                                    pCCMN00DInputRec = new CCMN00DI();
                                    
                                    pCCMN00DOutputRec = new CCMN00DO();
                                    pCCMN00DInputRec.setArchInputStruct(ccfc21si.getArchInputStruct());
                                    pCCMN00DInputRec.setUlIdOffice(ulIdOffice1);
                                    rc = ccmn00dQUERYdam(sqlca, pCCMN00DInputRec, pCCMN00DOutputRec);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            ccfc21so.setSzCdOfficeRegion(pCCMN00DOutputRec.getSzCdOfficeRegion());
                                            ccfc21so.setSzAddrMailCode(pCCMN00DOutputRec.getSzAddrMailCode());
                                            
                                            
                                            //  Begin CCMNA1D - Unit Smp
                                            
                                            //  Allocate memory for DAM CCMNA1D Input
                                            // and Output Structures
                                            pCCMNA1DInputRec = new CCMNA1DI();
                                            
                                            pCCMNA1DOutputRec = new CCMNA1DO();
                                            
                                            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                            pCCMNA1DInputRec.setArchInputStruct(ccfc21si.getArchInputStruct());
                                            pCCMNA1DInputRec.setUlIdUnit(ulIdUnit2);
                                            rc = ccmna1dQUERYdam(sqlca, pCCMNA1DInputRec, pCCMNA1DOutputRec);
                                            switch (rc) {
                                                    
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    ccfc21so.setSzNbrUnit(pCCMNA1DOutputRec.getSzNbrUnit());
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                                                    break;
                                                    
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                            break;
                                            
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                                            break;
                                            
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            break;
                                    }
                                }
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                ccfc21so.getDtDtCaseFileArchElig().day = DateHelper.NULL_DATE;
                                ccfc21so.getDtDtCaseFileArchElig().month = DateHelper.NULL_DATE;
                                ccfc21so.getDtDtCaseFileArchElig().year = DateHelper.NULL_DATE;
                                ccfc21so.getDtDtCaseFileArchCompl().day = DateHelper.NULL_DATE;
                                ccfc21so.getDtDtCaseFileArchCompl().month = DateHelper.NULL_DATE;
                                ccfc21so.getDtDtCaseFileArchCompl().year = DateHelper.NULL_DATE;
                                
                                //  Declare FOUNDATION variables
                                
                                //  Declare local variables
                                
                                //  Start performance timer for service
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                break;
                                
                            default :
                                
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                
                //  End of CCMNC5D - Case Smp
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                
                
                
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc21si.getArchInputStruct() , ccfc21so.getArchOutputStruct());
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
                
                // SIR 21891 - missing versioning
                //  Run-time Versioning
                
                //  Check buffer size
                
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                //  Initialize service status fields
                
                // 
                // Call DAMs to retrieve data
                // 
                
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccfc21so;
    }

}
