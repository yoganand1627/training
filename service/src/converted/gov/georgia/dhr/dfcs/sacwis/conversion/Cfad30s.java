package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES71DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS64DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CFAD30S.src
**
** Service Name:   CFAD30S
**
** Description:   This service retrieves the information necessary for the 
**                Close/Reopen F/A Home Window.                
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/27/95 
** 
** Programmer:    Stephen Helmke
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:16:14  $
**                      $Modtime:   05 Apr 1996 19:24:02  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  2/12/96   WANGSS    Customized Detail Deleted message.
**
** 3/26/96    ZIMMERNE  Added CdRsrcFacilType to csub30so.h to retrieve the 
**                      resource facility type from CSES41D.
**  3/29/96   PURCELA   SIR #4357 - The DAM cmsc39d was not functioning 
**                      correctly. A new DAM, clss64d, was created to take 
**                      some of the logic which could not be properly executed
**                      by cmsc39d.  Additional code has been inserted into
**                      the code to handle values which must be passed 
**                      between the two and also to handle the counting of
**                      Non Adoption Consumated placements in the home.
**  4/2/96    PURCELA   SIR #20075 - Because of the change made to cmsc39d
**                      an SQL_NOT_FOUND case became necessary.  It was added
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
**  08/11/03  Srini    SIR 19398- Made the service transaction aware.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad30s {
    
    /*
    ** Declare FOUNDATION variables 
    */
    
    
    static final String CLOSING_SUMMARY_DOC = "FAD_CLOS_SUM_NARR";
    static int transactionflag = - 1;
    CFAD30SO CFAD30S(CFAD30SI cfad30si) {
        CFAD30SO cfad30so = new CFAD30SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        rc = ARC_UTLCheckServiceBatchBlock("CFAD30S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CFAD30S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            //  Call DAM: searches  PERSON_ELIGIBILITY table
            
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        /*************************************************
        ** (END): Determine if Adoption Consumated
        *************************************************/
        
        
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CFAD30S\n");
        }
        
        else if (transactionflag == 0) /*
        ** IMPACT END
        */
        {
            userlog("TRANSACTION IS STARTED in CFAD30S\n");
            bTransactionStarted = true;
        }
        public int i212 = 0;
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        int RetVal = 0;
        int iPlcmtCtr = 0;/* SIR #4357 Loop Counter */
        int ulIdEvent9 = 0;
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        CSES71DI pCSES71DInputRec = null;
        CSES71DO pCSES71DOutputRec = null;
        
        CMSC39DI pCMSC39DInputRec = null;
        CMSC39DO pCMSC39DOutputRec = null;
        
        CSES02DI pCSES02DInputRec = null;
        CSES02DO pCSES02DOutputRec = null;
        
        CSES41DI pCSES41DInputRec = null;
        CSES41DO pCSES41DOutputRec = null;
        
        CSYS06DI pCSYS06DInputRec = null;
        CSYS06DO pCSYS06DOutputRec = null;
        CLSS64DI pCLSS64DInputRec = null;/* SIR #4357 Is Adpt Consumated */
        
        CLSS64DO pCLSS64DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfad30si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cfad30so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        if (cfad30si.getUlIdEvent() > 0) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES02DInputRec = new CSES02DI();
            
            pCSES02DOutputRec = new CSES02DO();
            
            pCSES02DInputRec.setArchInputStruct(cfad30si.getArchInputStruct());
            
            pCSES02DInputRec.setUlIdEvent(cfad30si.getUlIdEvent());
            
            //  Call DAM: searches  PERSON_ELIGIBILITY table
            
            rc = cses02dQUERYdam(sqlca, pCSES02DInputRec, pCSES02DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    cfad30so.setSzCdRsrcFaHomeStatus(pCSES02DOutputRec.getSzCdRshsFaHomeStatus());
                    cfad30so.setSzCdRsrcClosureRsn(pCSES02DOutputRec.getSzCdRshsClosureRsn());
                    cfad30so.setSzCdRsrcInvolClosure(pCSES02DOutputRec.getSzCdRshsInvolClosure());
                    cfad30so.setSzCdRsrcRecmndReopen(pCSES02DOutputRec.getSzCdRshsRecmndReopen());
                    cfad30so.setSzCdRsrcStatus(pCSES02DOutputRec.getSzCdRshsStatus());
                    cfad30so.setUlIdResource(pCSES02DOutputRec.getUlIdResource());
                    cfad30so.getTsLastUpdate_ARRAY().setTsLastUpdate((int) RESOURCE, pCSES02DOutputRec.getTsLastUpdate());
                    ulIdEvent9 = pCSES02DOutputRec.getUlIdEvent();
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_FAD_HISTORY_DELETED;
                    
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
                    
                default :
                    
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        
        if (cfad30si.getUlIdEvent() == 0) {
            // 
            // DAM CSES41D call
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES41DInputRec = new CSES41DI();
            
            pCSES41DOutputRec = new CSES41DO();
            
            pCSES41DInputRec.setArchInputStruct(cfad30si.getArchInputStruct());
            
            pCSES41DInputRec.setUlIdRsrcFaHomeStage(cfad30si.getUlIdStage());
            rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    cfad30so.setSzCdRsrcFaHomeStatus(pCSES41DOutputRec.getSzCdRsrcFaHomeStatus());
                    cfad30so.setSzCdRsrcClosureRsn(pCSES41DOutputRec.getSzCdRsrcClosureRsn());
                    cfad30so.setSzCdRsrcInvolClosure(pCSES41DOutputRec.getSzCdRsrcInvolClosure());
                    cfad30so.setSzCdRsrcRecmndReopen(pCSES41DOutputRec.getSzCdRsrcRecmndReopen());
                    cfad30so.setSzCdRsrcStatus(pCSES41DOutputRec.getSzCdRsrcStatus());
                    cfad30so.setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                    cfad30so.setBIndRsrcNonPrs(pCSES41DOutputRec.getBIndRsrcNonPrs());
                    
                    cfad30so.getTsLastUpdate_ARRAY().setTsLastUpdate((int) RESOURCE, pCSES41DOutputRec.getTsLastUpdate());
                    cfad30so.setSzCdRsrcFacilType(pCSES41DOutputRec.getSzCdRsrcFacilType());
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN45DInputRec = new CCMN45DI();
                    
                    pCCMN45DOutputRec = new CCMN45DO();
                    pCCMN45DInputRec.setArchInputStruct(cfad30si.getArchInputStruct());
                    pCCMN45DInputRec.setUlIdEvent(pCSES41DOutputRec.getUlIdRsrcFaHomeEvent());
                    rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            cfad30so.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                            cfad30so.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                            cfad30so.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                            cfad30so.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                            cfad30so.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                            cfad30so.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                            // We must have atleast one character
                            cfad30so.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                            cfad30so.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                            cfad30so.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                            
                            
                            // 
                            // Call DAM CMSC39D - Children in the Home Retrieve
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCMSC39DInputRec = new CMSC39DI();
                            
                            pCMSC39DOutputRec = new CMSC39DO();
                            pCMSC39DInputRec.setArchInputStruct(cfad30si.getArchInputStruct());
                            pCMSC39DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                            pCMSC39DInputRec.getArchInputStruct().setUlPageSizeNbr(50);
                            pCMSC39DInputRec.setDtSysDtGenericSysdate(cfad30so.getDtWCDDtSystemDate());
                            pCMSC39DInputRec.setUlIdRsrcFacil(cfad30so.getUlIdResource());
                            rc = cmsc39dQUERYdam(sqlca, pCMSC39DInputRec, pCMSC39DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    cfad30so.setBSysIndGeneric(false);
                                    
                                    for (iPlcmtCtr = 0;iPlcmtCtr < pCMSC39DOutputRec.getArchOutputStruct().getUlRowQty();iPlcmtCtr++) {
                                        
                                        if (0 == pCMSC39DOutputRec.getROWCMSC39DO_ARRAY().getROWCMSC39DO(iPlcmtCtr).getSzCdPlcmtLivArr().compareTo(ADOPTIVE_PLCMT_TYPE) || 0 == pCMSC39DOutputRec.getROWCMSC39DO_ARRAY().getROWCMSC39DO(iPlcmtCtr).getSzCdPlcmtLivArr().compareTo(RSRC_TYPE_PVT_AGENCY)) 
                                        {
                                            
                                            // 
                                            // (BEGIN): Is Placement Adoption Consumated
                                            // 
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCLSS64DInputRec = new CLSS64DI();
                                            
                                            pCLSS64DOutputRec = new CLSS64DO();
                                            pCLSS64DInputRec.setArchInputStruct(cfad30si.getArchInputStruct());
                                            pCLSS64DInputRec.setSzCdLegalStatStatus(LGL_STAT_ADO_CNSM);
                                            pCLSS64DInputRec.setUlIdPerson(pCMSC39DOutputRec.getROWCMSC39DO_ARRAY().getROWCMSC39DO(iPlcmtCtr).getUlIdPlcmtChild());
                                            pCLSS64DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                            pCLSS64DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
                                            
                                            
                                            //  Start Performance Timer
                                            rc = clss64dQUERYdam(sqlca, pCLSS64DInputRec, pCLSS64DOutputRec);
                                            
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    cfad30so.setBSysIndGeneric(true);
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    break;
                                                    
                                                default :
                                                    
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                    break;
                                            }
                                        }
                                        else {
                                            cfad30so.setBSysIndGeneric(true);
                                        }
                                    }
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    cfad30so.setBSysIndGeneric(false);
                                    
                                    break;
                                    
                                default :
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                            break;
                            
                        default :
                            
                            // Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                    break;
                    
                default :
                    
                    // Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        
        if (SUCCESS == RetVal) {
            // 
            // Call DAM CSES71D - Stage Retrieval
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES71DInputRec = new CSES71DI();
            
            pCSES71DOutputRec = new CSES71DO();
            pCSES71DInputRec.setArchInputStruct(cfad30si.getArchInputStruct());
            pCSES71DInputRec.setUlIdStage(cfad30si.getUlIdStage());
            rc = cses71dQUERYdam(sqlca, pCSES71DInputRec, pCSES71DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    cfad30so.setUlIdCase(pCSES71DOutputRec.getUlIdCase());
                    cfad30so.setUlIdSituation(pCSES71DOutputRec.getUlIdSituation());
                    cfad30so.getTsLastUpdate_ARRAY().setTsLastUpdate((int) STAGE, pCSES71DOutputRec.getTsLastUpdate());
                    
                    // 
                    // Call DAM CSYS06D - Contact Detail Narrative
                    // 
                    
                    //  Allocate memory for DAM Input and Output 
                    // Structures
                    pCSYS06DInputRec = new CSYS06DI();
                    
                    pCSYS06DOutputRec = new CSYS06DO();
                    pCSYS06DInputRec.setArchInputStruct(cfad30si.getArchInputStruct());
                    if (cfad30si.getUlIdEvent() > 0) {
                        pCSYS06DInputRec.setUlIdEvent(ulIdEvent9);
                    }
                    else {
                        pCSYS06DInputRec.setUlIdEvent(cfad30so.getROWCCMN01UIG00().getUlIdEvent());
                    }
                    pCSYS06DInputRec.setSzSysTxtTablename(CLOSING_SUMMARY_DOC);
                    rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            cfad30so.setBIndBLOBExistsInDatabase(true);
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            cfad30so.setBIndBLOBExistsInDatabase(false);
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                    break;
                    
                default :
                    
                    // Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
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
        ARC_PRFServiceStopTime_TUX(cfad30si.getArchInputStruct() , cfad30so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            
            //  Initialize rc for loop
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CFAD30S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Call CAUD92D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CFAD30S\n");
        }
        
        return cfad30so;
    }

}
