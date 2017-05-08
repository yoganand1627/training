package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB59SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CSUB59S.src
**
** Service Name:   OUTPUT LAUNCH RETRIEVAL 
**
** Description:   This service will receive Id Event and invoke 
**                perform a full-row retrieval of the Event Table.Using
**                CdEventType retrieved from the query, service will query 
**                one of the Document/Narrative tables to retrieve a 
**                timestamp. 
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  9 October 1995
** 
** Programmer:    Erik T. Wilson
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:19:54  $
**                      $Modtime:   28 Mar 1996 23:25:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**
**  05/14/03  Srini     SIR #16754- IMPACT Change. Added code to make it transaction aware.
**
**	06/30/03  Srini		SIR 18602 - Modified to fix error handling for 
**						transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**						PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to 
**						PROCESS_TUX_SQL_ERROR_TRANSACT calls.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub59s {
    
    /*
    ** Subcare.h is not #included - CEVNTTBL 
    ** is defined this way in subcare.h 
    */
    public static final String SUB_OL_EVNT_NARR_CTB = "CEVNTTBL";
    static int transactionflag = - 1;
    CSUB59SO CSUB59S(CSUB59SI csub59si) {
        CSUB59SO csub59so = new CSUB59SO();
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
            userlog("ERROR: tpgetlev failed in CSUB59S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        
        /**************************************************************************
        ** (END): Retrieve DAM: ccmn45d     ** Event simple retrieve
        **************************************************************************/
        
        /**************************************************************************
        ** (BEGIN): Retrieve DAM: CCMN82D     ** Task simple retrieve
        **************************************************************************/
        
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CSUB59S\n");
            
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CSUB59S\n");
            bTransactionStarted = true;
            
        }
        int i434 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        int RetVal = SUCCESS;
        CCMN45DI pCCMN45DInputRec = null;/*  Event Table */
        CCMN45DO pCCMN45DOutputRec = null;
        CSYS06DI pCSYS06DInputRec = null;/*  Blob Table  */
        
        CSYS06DO pCSYS06DOutputRec = null;
        CINT40DI pCINT40DInputRec = null;/*  Stage Table */
        
        CINT40DO pCINT40DOutputRec = null;
        CCMN82DI pCCMN82DInputRec = null;/*  Task Table  */
        
        CCMN82DO pCCMN82DOutputRec = null;
        
        rc = ARC_PRFServiceStartTime_TUX(csub59si.getArchInputStruct());
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /*
        ** Perform Main Processing
        */
        
        /**************************************************************************
        ** (BEGIN): Retrieve DAM: CINT40D     ** Retrieve Stage Row
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        pCINT40DInputRec.setArchInputStruct(csub59si.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(csub59si.getUlIdStage());
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                csub59so.setUlIdCase(pCINT40DOutputRec.getUlIdCase());
                break;
                
            default :
                
                RetVal = Csub50s.FND_FAIL;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        /**************************************************************************
        ** (END): Add/Update AUD DAM: caud45d     ** Placement Generic AUD dam
        **************************************************************************/
        
        
        
        
        if ((0 != csub59si.getUlIdEvent()) && (RetVal == SUCCESS)) {
            // end SIR #4258
            
            // 
            // CCMN45D DAM call.         
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN45DInputRec = new CCMN45DI();
            
            pCCMN45DOutputRec = new CCMN45DO();
            
            pCCMN45DInputRec.setArchInputStruct(csub59si.getArchInputStruct());
            pCCMN45DInputRec.setUlIdEvent(csub59si.getUlIdEvent());
            rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub59so.getROWCSUB59SOG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                    csub59so.getROWCSUB59SOG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                    csub59so.getROWCSUB59SOG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                    csub59so.getROWCSUB59SOG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                    csub59so.getROWCSUB59SOG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                    csub59so.getROWCSUB59SOG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                    csub59so.getROWCSUB59SOG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                    csub59so.getROWCSUB59SOG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                    csub59so.getROWCSUB59SOG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                    
                    // 
                    // (BEGIN): Retrieve DAM: csys06d   BLOB Narr Get CB Tmstmp Rtrv         
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSYS06DInputRec = new CSYS06DI();
                    
                    pCSYS06DOutputRec = new CSYS06DO();
                    pCSYS06DInputRec.setArchInputStruct(csub59si.getArchInputStruct());
                    pCSYS06DInputRec.setUlIdEvent(csub59si.getUlIdEvent());
                    
                    //  Call DAM
                    rc = ARC_FRMGetDecode((char) pCSYS06DInputRec.getSzSysTxtTablename() , (char) csub59so.getROWCSUB59SOG00().getSzCdEventType() , sizeof () , (char) SUB_OL_EVNT_NARR_CTB);
                    
                    rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            csub59so.setTsLastUpdate(pCSYS06DOutputRec.getTsLastUpdate());
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            csub59so.setTsLastUpdate(null);
                            pServiceStatus.explan_code = SUCCESS;
                            rc = SUCCESS;
                            break;
                            
                        default :
                            
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            break;
                    }
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    break;
            }
        }
        else if (RetVal == SUCCESS) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMN82DInputRec = new CCMN82DI();
            
            pCCMN82DOutputRec = new CCMN82DO();
            
            pCCMN82DInputRec.setArchInputStruct(csub59si.getArchInputStruct());
            pCCMN82DInputRec.setSzCdTask(csub59si.getSzCdTask());
            
            //  Declare FOUNDATION variables
            
            //  Declare local variables
            //##    long            rc = 0;
            
            
            
            
            //  The DAM CCMN45D retrieves the Event Status  
            // information from the EVENT table given the specified  
            // ID EVENT from the PAL FollowUp window.
            
            //  Start Performance Timer
            rc = ccmn82dQUERYdam(sqlca, pCCMN82DInputRec, pCCMN82DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub59so.getROWCSUB59SOG00().setSzCdEventType(pCCMN82DOutputRec.getSzCdEventType());
                    
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
        ARC_PRFServiceStopTime_TUX(csub59si.getArchInputStruct() , csub59so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in CSUB59S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CSUB59S\n");
        }
        return csub59so;
    }

}
