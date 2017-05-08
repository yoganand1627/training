package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD76DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA5DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC22S.src
**
** Service Name:  CCFC22S
**
** Description:   This service will save all columns for an IdCase to the
**                CASE FILE MANAGEMENT table.  There will be one row for a
**                specified IdCase.  Furthermore, it will check to see if 
**                the MailCode/Region/Program specified exists as well
**                as the Unit/Region/Program exists.  Additionally, it will
**                retrieve a full row from the CAPS CASE table to get the 
**                closure date for the Case.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 3, 1996
** 
** Programmer:    Elizabeth P. Crystal 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:38:44  $
**                      $Modtime:   29 Mar 1996 23:57:30  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**		
**  08/04/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc22s {
    
    /*
    ** Declare local variables 
    */
    static final char PRS = 'P';
    static int transactionflag = - 1;
    CCFC22SO CCFC22S(CCFC22SI ccfc22si) {
        CCFC22SO ccfc22so = new CCFC22SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CCFC22S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            //  Call DAM
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCFC22S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCFC22S \n");
            bTransactionStarted = true;
        }
        public int ulIdOffice2 = 0;
        int ulIdUnit3 = 0;
        
        //##  short rc = FND_SUCCESS;
        
        
        /*
        **  This DAM will add/update/delete a full row from the Case File 
        **  Management table.
        */
        CAUD76DI pCAUD76DInputRec = null;
        CAUD76DO pCAUD76DOutputRec = null;
        
        /*
        ** This DAM retrieves a full row from the UNIT table given
        ** CD UNIT PROGRAM, CD UNIT REGION, NBR UNIT.
        */
        CCMNC0DI pCCMNC0DInputRec = null;
        CCMNC0DO pCCMNC0DOutputRec = null;
        
        
        /*
        ** This DAM returns ID OFFICE and NM OFFICE NAME from the
        ** OFFICE table when passed CD OFFICE PROGRAM and 
        ** CD OFFICE MAIL.  
        */
        CCMNA5DI pCCMNA5DInputRec = null;
        CCMNA5DO pCCMNA5DOutputRec = null;
        
        rc = ARC_PRFServiceStartTime_TUX(ccfc22si.getArchInputStruct());
        if (PRS == ccfc22si.getSzCdCaseFileOfficeType()) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMNC0DInputRec = new CCMNC0DI();
            
            pCCMNC0DOutputRec = new CCMNC0DO();
            pCCMNC0DInputRec.setArchInputStruct(ccfc22si.getArchInputStruct());
            pCCMNC0DInputRec.setSzCdUnitRegion(ccfc22si.getSzCdOfficeRegion());
            pCCMNC0DInputRec.setSzNbrUnit(ccfc22si.getSzNbrUnit());
            pCCMNC0DInputRec.setSzCdUnitProgram(ccfc22si.getSzCdCaseProgram());
            rc = ccmnc0dQUERYdam(sqlca, pCCMNC0DInputRec, pCCMNC0DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ulIdUnit3 = pCCMNC0DOutputRec.getUlIdUnit();
                    
                    
                    //  CCMNA5D- Office Name Smp
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMNA5DInputRec = new CCMNA5DI();
                    
                    pCCMNA5DOutputRec = new CCMNA5DO();
                    pCCMNA5DInputRec.setArchInputStruct(ccfc22si.getArchInputStruct());
                    pCCMNA5DInputRec.setSzCdOfficeRegion(ccfc22si.getSzCdOfficeRegion());
                    pCCMNA5DInputRec.setSzAddrMailCode(ccfc22si.getSzAddrMailCode());
                    pCCMNA5DInputRec.setSzCdOfficeProgram(ccfc22si.getSzCdCaseProgram());
                    rc = ccmna5dQUERYdam(sqlca, pCCMNA5DInputRec, pCCMNA5DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ulIdOffice2 = pCCMNA5DOutputRec.getUlIdOffice();
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_INVALID_OFFICE;
                            
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            
                            
                            break;
                    }
                    
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_INVALID_UNIT;
                    
                    
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    
                    break;
            }
        }
        
        if (rc == WtcHelperConstants.SQL_SUCCESS) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUD76DInputRec = new CAUD76DI();
            
            pCAUD76DOutputRec = new CAUD76DO();
            pCAUD76DInputRec.setArchInputStruct(ccfc22si.getArchInputStruct());
            pCAUD76DInputRec.getArchInputStruct().setCReqFuncCd(ccfc22si.getArchInputStruct().getCReqFuncCd());
            pCAUD76DInputRec.setUlIdCase(ccfc22si.getUlIdCase());
            
            if (PRS == ccfc22si.getSzCdCaseFileOfficeType()) {
                pCAUD76DInputRec.setUlIdOffice(ulIdOffice2);
                
                pCAUD76DInputRec.setUlIdUnit(ulIdUnit3);
            }
            pCAUD76DInputRec.setSzAddrCaseFileCity(ccfc22si.getSzAddrCaseFileCity());
            pCAUD76DInputRec.setSzAddrCaseFileStLn1(ccfc22si.getSzAddrCaseFileStLn1());
            pCAUD76DInputRec.setSzAddrCaseFileStLn2(ccfc22si.getSzAddrCaseFileStLn2());
            pCAUD76DInputRec.setSzCdCaseFileOfficeType(ccfc22si.getSzCdCaseFileOfficeType());
            pCAUD76DInputRec.setDtDtCaseFileArchCompl(ccfc22si.getDtDtCaseFileArchCompl());
            pCAUD76DInputRec.setDtDtCaseFileArchElig(ccfc22si.getDtDtCaseFileArchElig());
            pCAUD76DInputRec.setSzNmCaseFileOffice(ccfc22si.getSzNmCaseFileOffice());
            pCAUD76DInputRec.setSztxtCaseFileLocateInfo(ccfc22si.getSztxtCaseFileLocateInfo());
            pCAUD76DInputRec.setTsLastUpdate(ccfc22si.getTsLastUpdate());
            rc = caud76dAUDdam(sqlca, pCAUD76DInputRec, pCAUD76DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    
                    break;
                    
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    
                    
                    break;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc22si.getArchInputStruct() , ccfc22so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCFC22S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCFC22S \n");
        }
        return ccfc22so;
    }

}
