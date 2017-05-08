package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC71DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   ccmn06u.src
**
** Service Name:  CheckStageEventStatus
**
** Description:   This is a Common Function (not a service) which is 
**                called by services which update functional tables.  
**                It is packaged in the libappd.a archive library.
**                This function receives the following inputs:
**                cReqFuncCd, ulIdStage, and szCdTask.
**
**                It returns ARC_SUCCESS or one of three MSG's:
**                MSG_SYS_STAGE_CLOSED, MSG_SYS_MULT_INST, 
**                MSG_SYS_EVENT_STS_MSMTCH.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3Oct95
** 
** Programmer:    Mary Sladewski
**
** Archive Information: $Revision:   1.5  $
**                      $Date:   05 Dec 1997 07:41:50  $
**                      $Modtime:   04 Dec 1997 14:35:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   05Oct95  sladewmf  Initial check-in.
**   10Oct95  sladewmf  Removed PROCESS_TUX_SQL_ERROR_NOFREE references (3 of them).
**   11Jan96  guarricr  SIR 2441: Freed all memory reserved for DAM calls 
**                      before every exit from function.
**   12Jan96  guarricr  SIR 2542: Replaced CLSC21D with CLSC71D. Event status
**                      should be checked against events with same task code,
**                      not event type.
**   13Jan96  guarricr  SIR 2576: Corrected comparison to
**                      bIndMultipleInstance to be for characters, not
**                      numbers.
**  06/19/96    KRD     SIR 10085 - Performing a SQL SELECT on NULL requires
**                      a full table scan which severly impacts performance.
**                      As a result, the call to CCMN82D will only be
**                      performed if the CD_TASK value is not NULL.
**  06/11/97  CYSKD     SVC AUTH ENH -- In order to allow Service Auth's. to
**                      be entered in a closed stage, the edit for Invalid
**                      Task must be avoided.  If a stage is closed, and the
**                      CdTask matches one of the service auth tasks, the 
**                      Service Auth. dialogue will be accessed. If the CdTask
**                      matches a Service Auth. approval task, an approval
**                      will be allowed.
**  11/18/97 	klm	SIR# 14234 - Make change similar to SVC AUTH ENH, 
**			allowing Legal Statuses to be entered in a closed
**			stage.
**  12/4/97	klm	SIR# 14234 - Fix typo for task ID 8560 on legal 
**			status.
**
***************************************************************************/

/**************************************************************************
** Common Function Include Files
***************************************************************************/


/**************************************************************************
** Common Function Macro Definitions
***************************************************************************/
public class Ccmn06u {
    public static final int MAX_NUMBER_OF_EVENTS = 100;
    public static final int NEW_NBR_EVENT_STAT = 0;
    public static final int PROC_NBR_EVENT_STAT = 1;
    public static final int COMP_NBR_EVENT_STAT = 2;
    public static final int PEND_NBR_EVENT_STAT = 3;
    public static final int APRV_NBR_EVENT_STAT = 4;
    public static final String NEW_EVENT_STATUS = "NEW";
    public static final String PROCESS_EVENT_STATUS = "PROC";
    public static final String COMPLETE_EVENT_STATUS = "COMP";
    public static final String PENDING_EVENT_STATUS = "PEND";
    public static final String APPROVE_EVENT_STATUS = "APRV";
    public static final String NULL_STRING = "";
    public static final int INITIAL_PAGE = 1;
    
    /*
    ** SIR 2576
    ** Different pound define for Multiple Instance Indicator
    */
    public static final char IND_MULTIPLE_INST_TRUE = '1';
    static int CheckStageEventStatus(CCMN06UI pInputMsg216, CCMN06UO * pOutputMsg197, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i121 = 0;
        int rc = 0;/* Return code */
        int sLowestStatus = APRV_NBR_EVENT_STAT;
        int sTempStatus = APRV_NBR_EVENT_STAT;
        
        
        
        
        
        
        /*
        ** SIR# 14234
        */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        CCMN82DI pCCMN82DInputRec = null;/* Full row retrieval from Task table  */
        
        CCMN82DO pCCMN82DOutputRec = null;
        CLSC71DI pCLSC71DInputRec = null;/* Full row retrieval from Event table */
        
        /*
        ** SIR 2542
        ** remove references to CLSC21D and replace them with references to CLSC71D
        */
        CLSC71DO pCLSC71DOutputRec = null;
        
        /**************************************************************************
        ** (BEGIN): Retrieve DAM: cint21d   ** Full row retrieval from Stage table
        **************************************************************************/
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setArchInputStruct(pInputMsg216.getArchInputStruct());
        pCINT21DInputRec.setUlIdStage(pInputMsg216.getUlIdStage());
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  If the number of rows returned exactly equals the page size, set the more
                // data indicator
                if (DateHelper.NULL_DATE != pCINT21DOutputRec.getDtDtStageClose().year) {
                    if ((0 == pInputMsg216.getSzCdTask().compareTo("3020")) || (0 == pInputMsg216.getSzCdTask().compareTo("9020")) || (0 == pInputMsg216.getSzCdTask().compareTo("3520")) || (0 == pInputMsg216.getSzCdTask().compareTo("5040")) || (0 == pInputMsg216.getSzCdTask().compareTo("2100")) || (0 == pInputMsg216.getSzCdTask().compareTo("2310")) || (0 == pInputMsg216.getSzCdTask().compareTo("8530")) || (0 == pInputMsg216.getSzCdTask().compareTo("7100")) || (0 == pInputMsg216.getSzCdTask().compareTo("5640")) || (0 == pInputMsg216.getSzCdTask().compareTo("6075")) || (0 == pInputMsg216.getSzCdTask().compareTo("4190")) || (0 == pInputMsg216.getSzCdTask().compareTo("3290")) || (0 == pInputMsg216.getSzCdTask().compareTo("3310")) || (0 == pInputMsg216.getSzCdTask().compareTo("3510")) || (0 == pInputMsg216.getSzCdTask().compareTo("4370")) || (0 == pInputMsg216.getSzCdTask().compareTo("5870")) || (0 == pInputMsg216.getSzCdTask().compareTo("7230")) || (0 == pInputMsg216.getSzCdTask().compareTo("2375")) || (0 == pInputMsg216.getSzCdTask().compareTo("3050")) || (0 == pInputMsg216.getSzCdTask().compareTo("8560")) || (0 == pInputMsg216.getSzCdTask().compareTo("2385")) || (0 == pInputMsg216.getSzCdTask().compareTo("3060")) || (0 == pInputMsg216.getSzCdTask().compareTo("9060")) || (0 == pInputMsg216.getSzCdTask().compareTo("8570")) || (0 == pInputMsg216.getSzCdTask().compareTo("7240")) || (0 == pInputMsg216.getSzCdTask().compareTo("5880")) || (0 == pInputMsg216.getSzCdTask().compareTo("4380")) || (0 == pInputMsg216.getSzCdTask().compareTo("9050"))) {
                        return WtcHelperConstants.SQL_SUCCESS;
                        
                    }
                    else {
                        return Messages.MSG_SYS_STAGE_CLOSED;
                        
                    }
                    
                }
                if (null != pInputMsg216.getSzCdTask()[0]) {
                    
                    // 
                    // (BEGIN): Retrieve DAM: ccmn82d    Full row retrieval from Task table
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN82DInputRec = new CCMN82DI();
                    
                    pCCMN82DOutputRec = new CCMN82DO();
                    pCCMN82DInputRec.setArchInputStruct(pInputMsg216.getArchInputStruct());
                    pCCMN82DInputRec.setSzCdTask(pInputMsg216.getSzCdTask());
                    
                    rc = ccmn82dQUERYdam(sqlca, pCCMN82DInputRec, pCCMN82DOutputRec);
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg216.getArchInputStruct().getCReqFuncCd()) {
                                // 
                                // SIR 2542
                                // Replace all references to CLSC21D with references to CLSC71D and
                                // set up input message for CLSC71D
                                // (BEGIN): Retrieve DAM: clsc71d    Full row retrieval from Event table
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCLSC71DInputRec = new CLSC71DI();
                                
                                pCLSC71DOutputRec = new CLSC71DO();
                                pCLSC71DInputRec.setArchInputStruct(pInputMsg216.getArchInputStruct());
                                pCLSC71DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                pCLSC71DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_NUMBER_OF_EVENTS);
                                pCLSC71DInputRec.setUlIdStage(pInputMsg216.getUlIdStage());
                                pCLSC71DInputRec.setSzCdTask(pInputMsg216.getSzCdTask());
                                rc = clsc71dQUERYdam(sqlca, pCLSC71DInputRec, pCLSC71DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                        if (IND_MULTIPLE_INST_TRUE != pCCMN82DOutputRec.getBIndTaskMultInstance()) {
                                            return Messages.MSG_SYS_MULT_INST;
                                            
                                        }
                                        
                                        //  Analyze error code
                                        if (NULL_STRING != pCCMN82DOutputRec.getSzCdEventStatus()) {
                                            for (i121 = 0;i121 < pCLSC71DOutputRec.getArchOutputStruct().getUlRowQty();i121++) {
                                                
                                                //  Analyze error code
                                                if (!(pCLSC71DOutputRec.getROWCLSC71DO_ARRAY().getROWCLSC71DO(i121).getSzCdEventStatus().compareTo(NEW_EVENT_STATUS) != 0)) {
                                                    sTempStatus = NEW_NBR_EVENT_STAT;
                                                    
                                                }
                                                else if (!(pCLSC71DOutputRec.getROWCLSC71DO_ARRAY().getROWCLSC71DO(i121).getSzCdEventStatus().compareTo(PROCESS_EVENT_STATUS) != 0)) {
                                                    sTempStatus = PROC_NBR_EVENT_STAT;
                                                    
                                                }
                                                else if (!(pCLSC71DOutputRec.getROWCLSC71DO_ARRAY().getROWCLSC71DO(i121).getSzCdEventStatus().compareTo(COMPLETE_EVENT_STATUS) != 0)) {
                                                    sTempStatus = COMP_NBR_EVENT_STAT;
                                                }
                                                else if (!(pCLSC71DOutputRec.getROWCLSC71DO_ARRAY().getROWCLSC71DO(i121).getSzCdEventStatus().compareTo(PENDING_EVENT_STATUS) != 0)) {
                                                    sTempStatus = PEND_NBR_EVENT_STAT;
                                                }
                                                else if (!(pCLSC71DOutputRec.getROWCLSC71DO_ARRAY().getROWCLSC71DO(i121).getSzCdEventStatus().compareTo(APPROVE_EVENT_STATUS) != 0)) {
                                                    sTempStatus = APRV_NBR_EVENT_STAT;
                                                    
                                                }
                                                if (NEW_NBR_EVENT_STAT == sTempStatus) {
                                                    i121 = pCLSC71DOutputRec.getArchOutputStruct().getUlRowQty();
                                                    
                                                }
                                            }
                                            if (sTempStatus < sLowestStatus) {
                                                sLowestStatus = sTempStatus;
                                                
                                            }
                                            
                                            //  Re-set sTempStatus to zero.
                                            sTempStatus = NEW_NBR_EVENT_STAT;
                                            if (!(pCCMN82DOutputRec.getSzCdEventStatus().compareTo(NEW_EVENT_STATUS) != 0)) {
                                                sTempStatus = NEW_NBR_EVENT_STAT;
                                                
                                            }
                                            else if (!(pCCMN82DOutputRec.getSzCdEventStatus().compareTo(PROCESS_EVENT_STATUS) != 0)) {
                                                sTempStatus = PROC_NBR_EVENT_STAT;
                                            }
                                            else if (!(pCCMN82DOutputRec.getSzCdEventStatus().compareTo(COMPLETE_EVENT_STATUS) != 0)) {
                                                sTempStatus = COMP_NBR_EVENT_STAT;
                                            }
                                            else if (!(pCCMN82DOutputRec.getSzCdEventStatus().compareTo(PENDING_EVENT_STATUS) != 0)) {
                                                sTempStatus = PEND_NBR_EVENT_STAT;
                                            }
                                            else if (!(pCCMN82DOutputRec.getSzCdEventStatus().compareTo(APPROVE_EVENT_STATUS) != 0)) {
                                                sTempStatus = APRV_NBR_EVENT_STAT;
                                            }
                                            if (sLowestStatus < sTempStatus) {
                                                return Messages.MSG_SYS_EVENT_STS_MSMTCH;
                                            }
                                        }
                                        
                                        break;
                                    case NO_DATA_FOUND:
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                        
                                        
                                        break;
                                        
                                    default :
                                        
                                        break;
                                }
                            }
                            
                            
                            break;
                            
                        default :
                            
                            
                            break;
                    }
                }
                
                break;
                // 
                // (END): Retrieve DAM: ccmn82d    Full row retrieval from Task table
                // 
                
                
                
            default :
                
                
                break;
        }
        return rc;
    }

}
