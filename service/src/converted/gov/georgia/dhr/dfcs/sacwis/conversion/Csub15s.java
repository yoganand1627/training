package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD30DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD31DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD31DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB84DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
**
** Module File:   CSUB15S.src
**
** Service Name:  CSUB15S
**
** Description:   This is the save service for Conservatorship Removal
**                which includes creating a new Conservatorship Removal
**                Detail, Removal Reason record, Child Removal Character
**                istic record & Adult Removal Characteristic record.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  19 October 1995
**
** Programmer:    Greg Dyar
**
** Archive Information: $Revision:   1.0.1.3  $
**                      $Date:   07 May 1999 07:44:08  $
**                      $Modtime:   06 May 1999 16:03:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/29/96  WILSONET  SIR#2820: Hide all listbox rows that are not
**                      populated in Person Characteristics.
**
**  03/25/96  DYARGR    SIR 5043 - Invalidate approval for events if we have
**                      tried to add or modify a CVS Removal after the Investigation
**                      has been submitted for approval.
**
**  09/15/97  PAULS     SIR 14162 - Added a new field on the Conservatorship
**                      Removal Window. This Field records the Marital Status
**                      of the Mother when the child was born.
**
**  05/06/1999 PAULS    SIR 14462 - Moved Mother Married Field from Conservatorship
**                      Removal window to Person Detail CVS/FA .
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
**  08/14/03  JEH       SIR 18571 - InvalidateApprvl should always act on
**                      the outstanding stage closure. CVS Removal events
**                      aren't submitted for approval.
**
**  06/11/04  RIOSJA    SIR 22952 - The start date of the SUB and FSU stages
**                      should be the child's Removal Date, which is being
**                      passed to this service in the "dtDtRemoval" field,
**                      not the "dtDtEventOccurred" field.
**  8/23/2004 gerryc    SIR 22988 - if the removal date is changed to an
**                      earlier date, then update the stage start dates for
**                      the SUB and FSU stages to that new date.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub15s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    
    public static final int FND_FAIL = 1;
    public static final String SUBCARE_STAGE = "SUB";
    public static final String STAGE_PROGRAM = "CPS";
    public static final String FAMILY_SUB_STAGE = "FSU";
    public static final String OLD_STAGE = "INV";
    public static final String REMOVAL = "REM";
    public static final int CURRENT = 0;
    public static final int NEXT = 1;
    
    public static final int LB_REMOVAL = 0;
    public static final int LB_CHILD = 1;
    public static final int LB_CARE = 2;
    
    public static final int SUBCARE = 0;
    public static final int FAMILY = 1;
    
    public static final char YES = 'Y';
    public static final char NO = 'N';
    
    public static final String NULL_STRING = "";
    
    public static final String STAGE_OPEN = "001";
    public static final String STATUS_NEW = "NEW";
    
    public static final String PRIMARY_CHILD = "PC";
    static int transactionflag = - 1;
    
    
    FndInt3date dtDbDtRemoval;
    CSUB15SO CSUB15S(CSUB15SI csub15si) {
        CSUB15SO csub15so = new CSUB15SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        // 01/22/2003 DWW: Added for error handling
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CSUB15S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CSUB15S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CSUB15S \n");
            bTransactionStarted = true;
        }
        CAUD29DI pCAUD29DInputRec = null;// Add/Update DAM for the CNSRVTRSHP_REMOVAL table
        
        //  Declare FOUNDATION variables
        
        //  Declare local variables
        
        CAUD29DO pCAUD29DOutputRec = null;
        CSES20DI pCSES20DInputRec = null;// row retrieval from CNSRVTRSHP_REMOVAL table
        
        CSES20DO pCSES20DOutputRec = null;
        
        CAUD30DI pCAUD30DInputRec = null;
        CAUD30DO pCAUD30DOutputRec = null;
        CAUD31DI pCAUD31DInputRec = null;// DAM modified with SIR#2820
        CAUD31DO pCAUD31DOutputRec = null;// Retrieve from REMOVAL_CHAR_CHILD
        
        
        CAUD32DI pCAUD32DInputRec = null;
        CAUD32DO pCAUD32DOutputRec = null;
        
        CAUD41DI pCAUD41DInputRec = null;
        CAUD41DO pCAUD41DOutputRec = null;
        
        
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        
        CCMN03UI pCCMN03UInputRec = null;
        CCMN03UO pCCMN03UOutputRec = null;
        
        
        // SIR 5043
        CCMN05UI pCCMN05UInputRec = null;
        CCMN05UO pCCMN05UOutputRec = null;
        
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        
        
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;// Check Stage/Event common function
        
        CCMN06UO pCCMN06UOutputRec = null;
        CINVC4DI pCINVC4DInputRec = null;// updates start date in stage table
        
        
        // SIR 22988 added the following 3 dams
        CINVC4DO pCINVC4DOutputRec = null;
        CCMNE1DI pCCMNE1DInputRec = null;// retrieves all stages given id case
        
        CCMNE1DO pCCMNE1DOutputRec = null;
        CSUB84DI pCSUB84DInputRec = null;// retrieves SUB stage given INV stage and person id
        
        CSUB84DO pCSUB84DOutputRec = null;
        int usRow = 0;// Row counter
        
        
        int usInputRow = 0;
        
        
        //  Start DAM Performance Timer
        //##                        ARC_PRFDataAccessStartTime("CSES15D");
        
        
        //  Call CSES15D
        rc = ARC_PRFServiceStartTime_TUX(csub15si.getArchInputStruct());
        
        
        
        //  Initialize Service Status Fields
        
        
        
        //   Perform Main Processing
        
        // 
        // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
        // 
        //  Allocate memory for Common Function Input and Output Structures
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csub15si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(csub15si.getROWCCMN01UIG00().getSzCdTask());
        rc = CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        //  Analyze return code
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
                RetVal = FND_FAIL;
                break;
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAIL
                RetVal = FND_FAIL;
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = FND_FAIL;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                //  Set RetVal to FND_FAIL
                RetVal = FND_FAIL;
                break;
        }
        if (SUCCESS == RetVal) {
            // 
            // (BEGIN): Common Function: ccmn01u
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(csub15si.getArchInputStruct());
            if (0 == csub15si.getROWCCMN01UIG00().getUlIdEvent()) {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
            }
            else {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(csub15si.getROWCCMN01UIG00().getSzCdEventStatus());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub15si.getROWCCMN01UIG00().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub15si.getROWCCMN01UIG00().getTsLastUpdate());
            
            //## BEGIN TUX/XML: Declare XML variables
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub15si.getROWCCMN01UIG00().getSzCdEventType());
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(csub15si.getROWCCMN01UIG00().getDtDtEventOccurred());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub15si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub15si.getROWCCMN01UIG00().getSzTxtEventDescr());
            
            if (0 == csub15si.getROWCCMN01UIG00().getUlIdEvent()) {
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(csub15si.getROWCSUB15SIG00().getUlIdVictim());
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            rc = PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    if (WtcHelperConstants.REQ_FUNC_CD_ADD == csub15si.getArchInputStruct().getCReqFuncCd()) {
                        csub15so.setUlIdEvent(pCCMN01UInputRec.getROWCCMN01UIG00().getUlIdEvent());
                    }
                    else {
                        csub15so.setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
                    }
                    csub15so.getTsLastUpdate_ARRAY().setTsLastUpdate(CURRENT, pCCMN01UInputRec.getROWCCMN01UIG00().getTsLastUpdate());
                    
                    if ((0 < csub15si.getUlIdEvent()) && (false == csub15si.getArchInputStruct().getUlSysNbrReserved1())) {
                        // 
                        // Begin Invalidate Approval
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN05UInputRec = new CCMN05UI();
                        
                        pCCMN05UOutputRec = new CCMN05UO();
                        pCCMN05UInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                        
                        
                        //  If this a new event (for the CVS Removal), invalidate the CCL event
                        // and pass that event into the Invalidate Approval Common function
                        // otherwise, pass in the event for the CVS Removal
                        
                        //  SIR 18571 - Invalidation will always be on the CCL event
                        // Removing code:
                        // if(0 == pInputMsg->ROWCCMN01UIG00.ulIdEvent)
                        // {
                        //  Invalidate the Conclusion event directly
                        // 
                        // Begin CCMN62D Invalidate the Conclusion event
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN62DInputRec = new CCMN62DI();
                        
                        pCCMN62DOutputRec = new CCMN62DO();
                        
                        if (pCCMN05UOutputRec == null) {
                            
                            
                            // Start DAM Performance Timer
                            //##                                    ARC_PRFDataAccessStartTime("CINV43D");
                            
                            
                            // Call To Do Update DAM: CINV43D
                            
                            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        }
                        pCCMN62DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                        pCCMN62DInputRec.setUlIdEvent(csub15si.getUlIdEvent());
                        
                        pCCMN62DInputRec.setSzCdEventStatus(Csub26s.EVENT_STATUS_COMP);
                        
                        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
                        
                        //  Analyze error code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                break;
                                
                            default :
                                
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                
                                RetVal = FND_FAIL;
                                
                                break;
                        }
                        
                        pCCMN05UInputRec.setUlIdEvent(csub15si.getUlIdEvent());
                        rc = InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                
                                RetVal = FND_FAIL;
                                
                                break;
                        }
                    }
                    
                    if (0 < csub15si.getROWCSUB15SIG00().getUlIdEvent()) {
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES20DInputRec = new CSES20DI();
                        
                        pCSES20DOutputRec = new CSES20DO();
                        pCSES20DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                        pCSES20DInputRec.setUlIdEvent(csub15si.getROWCSUB15SIG00().getUlIdEvent());
                        
                        //  Call DAM
                        rc = cses20dQUERYdam(sqlca, pCSES20DInputRec, pCSES20DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                dtDbDtRemoval = pCSES20DOutputRec.getDtDtRemoval();
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                    }
                    
                    
                    
                    //  Processing for Conservatorship Removal Detail Add
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD29DInputRec = new CAUD29DI();
                    
                    pCAUD29DOutputRec = new CAUD29DO();
                    pCAUD29DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                    pCAUD29DInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
                    
                    if (0 == csub15si.getROWCCMN01UIG00().getUlIdEvent()) {
                        pCAUD29DInputRec.setUlIdEvent(csub15so.getUlIdEvent());
                    }
                    else {
                        pCAUD29DInputRec.setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
                    }
                    pCAUD29DInputRec.setTsLastUpdate(csub15si.getROWCSUB15SIG00().getTsLastUpdate());
                    pCAUD29DInputRec.setUlIdVictim(csub15si.getROWCSUB15SIG00().getUlIdVictim());
                    pCAUD29DInputRec.setLNbrRemovalAgeMo(csub15si.getROWCSUB15SIG00().getLNbrRemovalAgeMo());
                    pCAUD29DInputRec.setLNbrRemovalAgeYr(csub15si.getROWCSUB15SIG00().getLNbrRemovalAgeYr());
                    
                    pCAUD29DInputRec.setCIndRemovalNACare(csub15si.getROWCSUB15SIG00().getCIndRemovalNACare());
                    pCAUD29DInputRec.setCIndRemovalNaChild(csub15si.getROWCSUB15SIG00().getCIndRemovalNaChild());
                    pCAUD29DInputRec.setDtDtRemoval(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
                    rc = caud29dAUDdam(sqlca, pCAUD29DInputRec, pCAUD29DOutputRec);
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Call CVS Detail retrieve to get the timestamp for
                            // the detail row
                            //  Allocate memory for DAM Input and Output Structures
                            pCSES20DInputRec = new CSES20DI();
                            
                            pCSES20DOutputRec = new CSES20DO();
                            pCSES20DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                            //## END TUX/XML: Turn the XML buffer into an input message struct 
                            
                            
                            
                            if (0 == csub15si.getROWCCMN01UIG00().getUlIdEvent()) {
                                pCSES20DInputRec.setUlIdEvent(csub15so.getUlIdEvent());
                            }
                            else {
                                pCSES20DInputRec.setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
                            }
                            rc = cses20dQUERYdam(sqlca, pCSES20DInputRec, pCSES20DOutputRec);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    csub15so.getTsLastUpdate_ARRAY().setTsLastUpdate(NEXT, pCSES20DOutputRec.getTsLastUpdate());
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    
                                    break;
                            }
                            if ((usRow < CSUB15SI._CSUB15SI__ROWCSUB15SIG01_SIZE) && (0 != 0.compareTo(csub15si.getROWCSUB15SIG01_ARRAY().getROWCSUB15SIG01(usRow).getSzCdSysDataActionOutcome()))) {
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD30DInputRec = new CAUD30DI();
                                
                                pCAUD30DOutputRec = new CAUD30DO();
                                pCAUD30DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                                
                                //  Declare FOUNDATION variables
                                
                                //  Declare local variables
                                
                                //  Start performance timer for service
                                rc = WtcHelperConstants.SQL_SUCCESS;
                                
                                //  While more rows are left to process and rc is zero,
                                // continue loop.
                                while ((usRow < csub15si.getUlPageSizeNbr_ARRAY().getUlPageSizeNbr(LB_REMOVAL)) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
                                    pCAUD30DInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getROWCSUB15SIG01_ARRAY().getROWCSUB15SIG01(usRow).getSzCdSysDataActionOutcome().value);
                                    if (WtcHelperConstants.REQ_FUNC_CD_ADD == csub15si.getArchInputStruct().getCReqFuncCd()) {
                                        pCAUD30DInputRec.setUlIdEvent(csub15so.getUlIdEvent());
                                    }
                                    else {
                                        pCAUD30DInputRec.setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
                                    }
                                    pCAUD30DInputRec.setTsLastUpdate(csub15si.getROWCSUB15SIG01_ARRAY().getROWCSUB15SIG01(usRow).getTsLastUpdate());
                                    pCAUD30DInputRec.setSzCdRemovalReason(csub15si.getROWCSUB15SIG01_ARRAY().getROWCSUB15SIG01(usRow).getSzCdRemovalReason());
                                    
                                    // SIR 21891 - missing versioning
                                    //  Run-time Versioning
                                    
                                    //  Check buffer size
                                    
                                    //  Process error message and return to client
                                    
                                    //  Initialize output message and length
                                    
                                    //  Initialize service status fields
                                    
                                    // 
                                    // Call DAMs to retrieve data
                                    // 
                                    
                                    rc = caud30dAUDdam(sqlca, pCAUD30DInputRec, pCAUD30DOutputRec);
                                    
                                    
                                    
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
                                            
                                            
                                            
                                            break;
                                            
                                            
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = FND_FAIL;
                                            
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = FND_FAIL;
                                            
                                            break;
                                    }
                                    usRow++;
                                }
                            }
                            
                            
                            
                            //  Reset usRow
                            usRow = 0;
                            
                            // SIR#2820 : Add for loop so that listbox will be updated
                            for (usRow = 0;usRow < CSUB15SI._CSUB15SI__ROWCSUB15SIG02_SIZE;usRow++) {
                                
                                
                                
                                if ((0 != csub15si.getROWCSUB15SIG02_ARRAY().getROWCSUB15SIG02(usRow).getSzCdSysDataActionOutcome()) && (SUCCESS == RetVal)) {
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCAUD31DInputRec = new CAUD31DI();
                                    
                                    pCAUD31DOutputRec = new CAUD31DO();
                                    pCAUD31DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                                    rc = WtcHelperConstants.SQL_SUCCESS;
                                    pCAUD31DInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getROWCSUB15SIG02_ARRAY().getROWCSUB15SIG02(usRow).getSzCdSysDataActionOutcome());
                                    if (WtcHelperConstants.REQ_FUNC_CD_ADD == csub15si.getArchInputStruct().getCReqFuncCd()) {
                                        pCAUD31DInputRec.setUlIdEvent(csub15so.getUlIdEvent());
                                    }
                                    else {
                                        pCAUD31DInputRec.setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
                                    }
                                    pCAUD31DInputRec.setTsLastUpdate(csub15si.getROWCSUB15SIG02_ARRAY().getROWCSUB15SIG02(usRow).getTsLastUpdate());
                                    pCAUD31DInputRec.setSzCdRemovChildChar(csub15si.getROWCSUB15SIG02_ARRAY().getROWCSUB15SIG02(usRow).getSzCdRemovChildChar());
                                    pCAUD31DInputRec.setCIndCharChildCurrent(csub15si.getROWCSUB15SIG02_ARRAY().getROWCSUB15SIG02(usRow).getCIndCharChildCurrent());
                                    
                                    rc = caud31dAUDdam(sqlca, pCAUD31DInputRec, pCAUD31DOutputRec);
                                    
                                    
                                    
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
                                            
                                            
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = FND_FAIL;
                                            
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = FND_FAIL;
                                            
                                            break;
                                    }
                                }
                                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                
                            }
                            
                            
                            //  Reset usRow
                            usRow = 0;
                            if ((usRow < CSUB15SI._CSUB15SI__ROWCSUB15SIG03_SIZE) && (0 != csub15si.getROWCSUB15SIG03_ARRAY().getROWCSUB15SIG03(usRow).getSzCdSysDataActionOutcome()) && (SUCCESS == RetVal)) {
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD32DInputRec = new CAUD32DI();
                                
                                pCAUD32DOutputRec = new CAUD32DO();
                                pCAUD32DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                                // Get system date
                                rc = WtcHelperConstants.SQL_SUCCESS;
                                
                                //  While more rows are left to process and rc is zero,
                                // continue loop.
                                while ((usRow < csub15si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
                                    pCAUD32DInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getROWCSUB15SIG03_ARRAY().getROWCSUB15SIG03(usRow).getSzCdSysDataActionOutcome());
                                    if (WtcHelperConstants.REQ_FUNC_CD_ADD == csub15si.getArchInputStruct().getCReqFuncCd()) {
                                        pCAUD32DInputRec.setUlIdEvent(csub15so.getUlIdEvent());
                                    }
                                    else {
                                        pCAUD32DInputRec.setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
                                    }
                                    pCAUD32DInputRec.setTsLastUpdate(csub15si.getROWCSUB15SIG03_ARRAY().getROWCSUB15SIG03(usRow).getTsLastUpdate());
                                    pCAUD32DInputRec.setSzCdRemovAdultChar(csub15si.getROWCSUB15SIG03_ARRAY().getROWCSUB15SIG03(usRow).getSzCdRemovAdultChar());
                                    rc = caud32dAUDdam(sqlca, pCAUD32DInputRec, pCAUD32DOutputRec);
                                    
                                    
                                    
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
                                            
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = FND_FAIL;
                                            
                                            break;
                                    }
                                    usRow++;
                                }
                            }
                            
                            
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            
                            RetVal = FND_FAIL;
                            
                            break;
                            
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            RetVal = FND_FAIL;
                            
                            break;
                    }
                    
                    
                    
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    RetVal = FND_FAIL;
                    
                    break;
            }
        }
        if ((WINDOW_MODE_NEW_USING == csub15si.getSzSysCdWinMode()) && (false == csub15si.getBWCDIndSearchChange()) && (SUCCESS == RetVal)) {
            //  Allocate memory for DAM Input and Output Structures
            pCAUD41DInputRec = new CAUD41DI();
            
            pCAUD41DOutputRec = new CAUD41DO();
            pCAUD41DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
            pCAUD41DInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
            pCAUD41DInputRec.setUlIdEvent(csub15si.getROWCSUB15SIG00().getUlIdEvent());
            pCAUD41DInputRec.setUlSysIdNewEvent(csub15so.getUlIdEvent());
            rc = caud41dAUDdam(sqlca, pCAUD41DInputRec, pCAUD41DOutputRec);
            
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    RetVal = SUCCESS;
                    
                    
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    RetVal = FND_FAIL;
                    
                    break;
            }
        }
        
        if ((SUCCESS == RetVal) && ((WINDOW_MODE_MODIFY != csub15si.getSzSysCdWinMode()) || (0 == STATUS_NEW.compareTo(csub15si.getSzCdEventStatus())))) {
            //  Perform Stage Progression Retrieval
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN03UInputRec = new CCMN03UI();
            
            pCCMN03UOutputRec = new CCMN03UO();
            pCCMN03UInputRec.setArchInputStruct(csub15si.getArchInputStruct());
            pCCMN03UInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
            pCCMN03UInputRec.setSzCdStage(SUBCARE_STAGE);
            pCCMN03UInputRec.setSzCdStageOpen(SUBCARE_STAGE);
            pCCMN03UInputRec.setSzCdStageReasonClosed(SUBCARE_STAGE);
            pCCMN03UInputRec.setSzCdStageProgram(STAGE_PROGRAM);
            pCCMN03UInputRec.setUlIdStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN03UInputRec.setUlIdPerson(csub15si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN03UInputRec.setSzNmPersonFull(csub15si.getSzNmPersonFull());
            pCCMN03UInputRec.setCSysIndSStgOpenOnly(YES);
            pCCMN03UInputRec.setDtDtStageStart(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
            pCCMN03UInputRec.setUlScrIdPrimChild(csub15si.getROWCSUB15SIG00().getUlIdVictim());
            
            
            
            //  Start Performance Timer
            rc = CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    RetVal = SUCCESS;
                    
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    RetVal = FND_FAIL;
                    
                    break;
            }
        }
        
        if ((SUCCESS == RetVal) && ((WINDOW_MODE_MODIFY != csub15si.getSzSysCdWinMode()) || (0 == STATUS_NEW.compareTo(csub15si.getSzCdEventStatus())))) {
            pCCMN03UInputRec = new CCMN03UI();
            
            pCCMN03UOutputRec = new CCMN03UO();
            pCCMN03UInputRec.setArchInputStruct(csub15si.getArchInputStruct());
            pCCMN03UInputRec.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
            pCCMN03UInputRec.setSzCdStage(SUBCARE_STAGE);
            pCCMN03UInputRec.setSzCdStageOpen(FAMILY_SUB_STAGE);
            pCCMN03UInputRec.setSzCdStageReasonClosed(SUBCARE_STAGE);
            pCCMN03UInputRec.setSzCdStageProgram(STAGE_PROGRAM);
            pCCMN03UInputRec.setUlIdStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN03UInputRec.setUlIdPerson(csub15si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN03UInputRec.setDtDtStageStart(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
            pCCMN03UInputRec.setUlScrIdPrimChild(csub15si.getROWCSUB15SIG00().getUlIdVictim());
            pCCMN03UInputRec.setCSysIndSStgOpenOnly(YES);
            rc = CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    RetVal = SUCCESS;
                    
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    RetVal = FND_FAIL;
                    
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            // take the case id, and get the FSU stage info using CCMNE1D
            
            //  Allocate memory for Input and Output Structures
            pCCMNE1DInputRec = new CCMNE1DI();
            pCCMNE1DOutputRec = new CCMNE1DO();
            pCCMNE1DInputRec.setUlIdCase(csub15si.getROWCSUB15SIG00().getUlIdCase());
            pCCMNE1DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
            pCCMNE1DInputRec.getArchInputStruct().setUsPageNbr(1);
            pCCMNE1DInputRec.getArchInputStruct().setUlPageSizeNbr(600);
            rc = ccmne1dQUERYdam(sqlca, pCCMNE1DInputRec, pCCMNE1DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    RetVal = SUCCESS;
                    
                    // loop through the stages
                    for (int i = 0;(i < pCCMNE1DOutputRec.getArchOutputStruct().getUlRowQty());i++) {
                        
                        // SIR 14235 - If days is greater than 0 then that means the contact
                        // date is earlier than the Investigation Start Date  . So
                        // Change the Investigation start dt to the 24HR Contact date
                        if (0 == pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i).getSzCdStage().compareTo(FAMILY_SUB_STAGE) && (DateHelper.NULL_DATE == pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i).getDtDtStageClose().day || DateHelper.NULL_DATE == pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i).getDtDtStageClose().month || DateHelper.NULL_DATE == pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i).getDtDtStageClose().year)) {
                            
                            // check the stage start date vs. the conservatorship removal date
                            
                            int diff1 = 0;
                            int days1 = 0;
                            
                            // if removal date is prior to start date
                            diff1 = ARC_UTLCompareDateAndTime((FndInt3date) & pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i).getDtDtStageStart() , 0, (FndInt3date) & csub15si.getROWCSUB15SIG00().getDtDtRemoval() , 0);
                            
                            days1 = (diff1 / Arcutls.ARC_UTL_MINUTES_IN_DAY);
                            if (days1 > 0) {
                                
                                
                                // call CINVC4D to update stage start date
                                //  Allocate memory for Input and Output Structures
                                pCINVC4DInputRec = new CINVC4DI();
                                
                                pCINVC4DOutputRec = new CINVC4DO();
                                pCINVC4DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                                pCINVC4DInputRec.setUlIdStage(pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i).getUlIdStage());
                                pCINVC4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                pCINVC4DInputRec.setDtDtStageStart(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
                                
                                //  Call CheckStageEventStatus
                                rc = cinvc4dAUDdam(sqlca, pCINVC4DInputRec, pCINVC4DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        RetVal = SUCCESS;
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        
                                        RetVal = FND_FAIL;
                                }
                            }
                        }
                    }
                    
                    
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    RetVal = FND_FAIL;
            }
        }
        
        if (SUCCESS == RetVal && WINDOW_MODE_MODIFY == csub15si.getSzSysCdWinMode()) {
            int diff = 0;
            int days = 0;
            
            // use the removal date that was retrieved from cses20d before the update
            // if new date is prior to original date
            diff = ARC_UTLCompareDateAndTime((FndInt3date) & dtDbDtRemoval, 0, (FndInt3date) & csub15si.getROWCSUB15SIG00().getDtDtRemoval() , 0);
            
            days = (diff / Arcutls.ARC_UTL_MINUTES_IN_DAY);
            if (days > 0) {
                // use the person id and INV stage id to get the SUB stage id.
                
                //  Allocate memory for Input and Output Structures
                pCSUB84DInputRec = new CSUB84DI();
                pCSUB84DOutputRec = new CSUB84DO();
                pCSUB84DInputRec.setUlIdPriorStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
                pCSUB84DInputRec.setUlIdPerson(csub15si.getROWCSUB15SIG00().getUlIdVictim());
                pCSUB84DInputRec.setSzCdStage(SUBCARE_STAGE);
                pCSUB84DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                pCSUB84DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                rc = csub84dQUERYdam(sqlca, pCSUB84DInputRec, pCSUB84DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                        
                        //  Allocate memory for Input and Output Structures
                        pCINVC4DInputRec = new CINVC4DI();
                        
                        pCINVC4DOutputRec = new CINVC4DO();
                        pCINVC4DInputRec.setArchInputStruct(csub15si.getArchInputStruct());
                        pCINVC4DInputRec.setUlIdStage(pCSUB84DOutputRec.getUlIdStage());
                        pCINVC4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        pCINVC4DInputRec.setDtDtStageStart(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
                        rc = cinvc4dAUDdam(sqlca, pCINVC4DInputRec, pCINVC4DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                RetVal = SUCCESS;
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                
                                RetVal = FND_FAIL;
                        }
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        
                        RetVal = FND_FAIL;
                }
            }
        }
        
        
        //  Load Translation Map
        
        
        //  Stop Performance Timer
        ARC_PRFServiceStopTime_TUX(csub15si.getArchInputStruct() , csub15so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            
            //  Call CCMN01U
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CSUB15S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CSUB15S \n");
        }
        return csub15so;
    }

}
