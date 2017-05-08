package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC61DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC61DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:   CCFC50S.src
**
** Service Name:  CCFC50S
**
** Description:   This is the Second AUD ervice for the Person Merge Widnow.  
**                For a Merge this service will compare the Primary Address 
**                and the Primary Phone for the Person Forward and Prerson 
**                closed. If they are different, a new row will be written 
**                to the Address or Phone table.  For both the Merge and 
**                the Split this service will retrieve all primary and 
**                secondary workers for stages where either person is
**                involved and then call the Common Todo Function.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/12/96
** 
** Programmer:    Timothy R. Overend 
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   08 Jul 1996 15:42:32  $
**                      $Modtime:   08 Jul 1996 15:21:58  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/25/96  DMV       SIR 3977: Set end dates of Address and Phone to 
**                      NULL_DATE.
**  03/25/96  DMV       SIR 3978: Updated the if statements used to 
**                      determine if the Address and Phone records are
**                      different.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc50s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /*
    ** Initial Page size definition
    */
    public static final int PAGE_NUM_ONE = 1;
    
    /*
    ** Todo Description # defines
    */
    public static final String SPLIT_SHORT_DESC = " Split From ";
    public static final int SSD_LENGTH = 13;
    public static final String MERGE_SHORT_DESC = " Merged Into ";
    public static final int MSD_LENGTH = 14;
    public static final String SPLIT_LONG_DESC = "has been split from";
    public static final String MERGED_LONG_DESC = "has been merged into";
    public static final String BY_STRING = "by";
    
    /*
    ** ToDo Definitions
    */
    public static final String MERGE_TODO_CD = "CFC017";
    public static final String SPLIT_TODO_CD = "CFC018";
    static int transactionflag = - 1;
    CCFC50SO CCFC50S(CCFC50SI ccfc50si) {
        CCFC50SO ccfc50so = new CCFC50SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        rc = ARC_UTLCheckServiceBatchBlock("CCFC50S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CCFC50S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCFC50S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCFC50S \n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        /*********** start ccfc50s.src transfer ******************/
        /*
        ** CCMNA8D.PC: This does full row adds and updates of the
        **             PERSON_ADDRESS table.
        */
        CCMNA8DI pCCMNA8DInputRec = null;
        CCMNA8DO pCCMNA8DOutputRec = null;
        
        /*
        ** CCMNA9D.PC:  This does full row adds and updates of the
        **              ADDRESS_PERSON_LINK table.  Although UPDATE will not modify
        **              column DT_PERS_ADDR_LINK_START.
        */
        
        CCMNA9DI pCCMNA9DInputRec = null;
        CCMNA9DO pCCMNA9DOutputRec = null;
        CLSC48DI pCLSC48DInputRec = null;
        CLSC48DO pCLSC48DOutputRec = null;
        CSEC61DI pCSEC61DInputRec = null;
        CSEC61DO pCSEC61DOutputRec = null;
        CSEC61DI pCAll2CSEC61DInputRec = null;
        CSEC61DO pCall2CSEC61DOutputRec = null;
        CSUB40UI pCSUB40UInputRec = null;
        CSUB40UO pCSUB40UOutputRec = null;
        
        /*
        ** CCMN95D.PC: This does a full row add and updates of the PERSON_PHONE
        **             table.  UPDATEs do not modify DT_PERSON_PHONE_START.
        */
        CCMN95DI pCCMN95DInputRec = null;
        CCMN95DO pCCMN95DOutputRec = null;
        
        //##  short rc = FND_SUCCESS;     /* Return Code for DAM calls */
        
        int usRow = 0;
        int usInputRow = 0;
        int i66 = 0;
        String TxtToDoDesc = new String();
        String TxtToDoLongDesc = new String();
        
        
        
        /*
        ** Start Performance Timer
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc50si.getArchInputStruct());
        
        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE != ccfc50si.getArchInputStruct().getCReqFuncCd()) {
            //  First retrieve the phone for the person closed
            // 
            // Call the Address Phone Retrieval Dam - CSEC61D
            // Description - Retrieve the Primary address and Phone for a Person. 
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC61DInputRec = new CSEC61DI();
            
            pCSEC61DOutputRec = new CSEC61DO();
            pCSEC61DInputRec.setArchInputStruct(ccfc50si.getArchInputStruct());
            pCSEC61DInputRec.setUlIdPerson(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
            rc = csec61dQUERYdam(sqlca, pCSEC61DInputRec, pCSEC61DOutputRec);
            
            //  Success Processing
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Now retrieve the phone and address of the forward person..
                    
                    // 
                    // Call the Address Phone Retrieval Dam - CSEC61D2
                    // Description - Retrieve the Primary address and Phone for a Person. 
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCAll2CSEC61DInputRec = new CSEC61DI();
                    
                    pCall2CSEC61DOutputRec = new CSEC61DO();
                    pCAll2CSEC61DInputRec.setArchInputStruct(ccfc50si.getArchInputStruct());
                    pCAll2CSEC61DInputRec.setUlIdPerson(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                    rc = csec61dQUERYdam(sqlca, pCAll2CSEC61DInputRec, pCall2CSEC61DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            if (((!pCall2CSEC61DOutputRec.getLNbrPhoneExtension().equals(pCSEC61DOutputRec.getLNbrPhoneExtension())) || (!pCall2CSEC61DOutputRec.getLNbrPhone().equals(pCSEC61DOutputRec.getLNbrPhone())) || (!pCall2CSEC61DOutputRec.getSzCdPhoneType().equals(pCSEC61DOutputRec.getSzCdPhoneType()))) && (pCSEC61DOutputRec.getLNbrPhone() != null)) {
                                //  Call the DAM to Update the Phone
                                
                                // 
                                // Call the Person Phone AUD Dam - CCMN95D
                                // Description - This does a full row add and updates of the
                                // PERSON_PHONE table.
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCCMN95DInputRec = new CCMN95DI();
                                
                                pCCMN95DOutputRec = new CCMN95DO();
                                pCCMN95DInputRec.setArchInputStruct(ccfc50si.getArchInputStruct());
                                
                                //## BEGIN TUX/XML: Declare XML variables 
                                pCCMN95DInputRec.getROWCCMN95DI().setLNbrPhone(pCSEC61DOutputRec.getLNbrPhone());
                                pCCMN95DInputRec.getROWCCMN95DI().setLNbrPhoneExtension(pCSEC61DOutputRec.getLNbrPhoneExtension());
                                pCCMN95DInputRec.getROWCCMN95DI().setSzCdPhoneType(pCSEC61DOutputRec.getSzCdPhoneType());
                                pCCMN95DInputRec.getROWCCMN95DI().setUlIdPerson(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhonePrimary(FND_NO);
                                pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhoneInvalid(FND_NO);
                                pCCMN95DInputRec.getROWCCMN95DI().setDtDtPersonPhoneStart(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMerge());
                                pCCMN95DInputRec.getROWCCMN95DI().getDtDtPersonPhoneEnd().day = DateHelper.NULL_DATE;
                                pCCMN95DInputRec.getROWCCMN95DI().getDtDtPersonPhoneEnd().month = DateHelper.NULL_DATE;
                                pCCMN95DInputRec.getROWCCMN95DI().getDtDtPersonPhoneEnd().year = DateHelper.NULL_DATE;
                                pCCMN95DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                
                                
                                //  Call CDYN01D
                                rc = ccmn95dAUDdam(sqlca, pCCMN95DInputRec, pCCMN95DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        break;
                                }
                            }
                            
                            if (((!pCall2CSEC61DOutputRec.getLAddrZip().equals(pCSEC61DOutputRec.getLAddrZip())) || (!pCall2CSEC61DOutputRec.getSzCdAddrState().equals(pCSEC61DOutputRec.getSzCdAddrState())) || (!pCall2CSEC61DOutputRec.getSzAddrCity().equals(pCSEC61DOutputRec.getSzAddrCity())) || (!pCall2CSEC61DOutputRec.getSzAddrPersAddrStLn1().equals(pCSEC61DOutputRec.getSzAddrPersAddrStLn1())) || (!pCall2CSEC61DOutputRec.getSzAddrPersAddrStLn2().equals(pCSEC61DOutputRec.getSzAddrPersAddrStLn2()))) && (null != pCSEC61DOutputRec.getSzCdAddrCounty()[0]) && (SUCCESS == rc)) {
                                
                                // 
                                // Call the Address AUD Dam - CCMNA8D
                                // Description - This does full row adds and updates of the
                                // PERSON_ADDRESS table.
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCCMNA8DInputRec = new CCMNA8DI();
                                
                                pCCMNA8DOutputRec = new CCMNA8DO();
                                pCCMNA8DInputRec.setArchInputStruct(ccfc50si.getArchInputStruct());
                                pCCMNA8DInputRec.setLAddrZip(pCSEC61DOutputRec.getLAddrZip());
                                pCCMNA8DInputRec.setSzCdAddrState(pCSEC61DOutputRec.getSzCdAddrState());
                                pCCMNA8DInputRec.setSzAddrCity(pCSEC61DOutputRec.getSzAddrCity());
                                pCCMNA8DInputRec.setSzAddrPersAddrStLn1(pCSEC61DOutputRec.getSzAddrPersAddrStLn1());
                                pCCMNA8DInputRec.setSzAddrPersAddrStLn2(pCSEC61DOutputRec.getSzAddrPersAddrStLn2());
                                pCCMNA8DInputRec.setSzCdAddrCounty(pCSEC61DOutputRec.getSzCdAddrCounty());
                                pCCMNA8DInputRec.setSzAddrPersAddrAttn(pCSEC61DOutputRec.getSzAddrPersAddrAttn());
                                pCCMNA8DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                
                                
                                //  Set rc to ARC_SUCCESS
                                rc = ccmna8dAUDdam(sqlca, pCCMNA8DInputRec, pCCMNA8DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        
                                        // 
                                        // Call the Address Person Link AUD Dam - CCMNA9D
                                        // Description - This does full row adds and updates of the
                                        // ADDRESS_PERSON_LINK table.
                                        // 
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCCMNA9DInputRec = new CCMNA9DI();
                                        
                                        pCCMNA9DOutputRec = new CCMNA9DO();
                                        pCCMNA9DInputRec.setArchInputStruct(ccfc50si.getArchInputStruct());
                                        pCCMNA9DInputRec.setSzCdPersAddrLinkType(pCSEC61DOutputRec.getSzCdPersAddrLinkType());
                                        pCCMNA9DInputRec.setSzTxtPersAddrCmnts(pCSEC61DOutputRec.getSzTxtPersAddrCmnts());
                                        pCCMNA9DInputRec.setUlIdPerson(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                        pCCMNA9DInputRec.setLdIdAddress(pCCMNA8DOutputRec.getLdIdAddress());
                                        pCCMNA9DInputRec.setBIndPersAddrLinkInvalid(FND_NO);
                                        pCCMNA9DInputRec.setBIndPersAddrLinkPrimary(FND_NO);
                                        pCCMNA9DInputRec.setDtDtPersAddrLinkStart(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMerge());
                                        pCCMNA9DInputRec.getDtDtPersAddrLinkEnd().day = DateHelper.NULL_DATE;
                                        pCCMNA9DInputRec.getDtDtPersAddrLinkEnd().month = DateHelper.NULL_DATE;
                                        pCCMNA9DInputRec.getDtDtPersAddrLinkEnd().year = DateHelper.NULL_DATE;
                                        
                                        pCCMNA9DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        rc = ccmna9dAUDdam(sqlca, pCCMNA9DInputRec, pCCMNA9DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
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
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            // 
                            // Call DAMs to retrieve data
                            // 
                            //  Retrieve current date for date comparison
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        
        /**************************************************************************
        ** End Call to Person/Address Retrieval Dam - CSEC61D
        **************************************************************************/
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures that is called inside
        ** the for loop.
        */
        
        pCLSC48DInputRec = new CLSC48DI();
        
        pCLSC48DOutputRec = new CLSC48DO();
        
        pCSUB40UInputRec = new CSUB40UI();
        
        pCSUB40UOutputRec = new CSUB40UO();
        
        
        /*
        ** Loop through all of the rows in case there is a multiple split involved.
        */
        for (usRow = 0;((usRow < ccfc50si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.ARC_SUCCESS == rc));usRow++) {
            pCLSC48DInputRec.setArchInputStruct(ccfc50si.getArchInputStruct());
            pCLSC48DInputRec.setUlIdPersMergeForward(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeForward());
            pCLSC48DInputRec.setUlIdPersMergeClosed(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeClosed());
            pCLSC48DInputRec.setUlIdPerson(ccfc50si.getUlIdPersonRequestor());
            pCLSC48DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
            pCLSC48DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC48DO._CLSC48DO__ROWCLSC48DO_SIZE);
            rc = clsc48dQUERYdam(sqlca, pCLSC48DInputRec, pCLSC48DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    TxtToDoDesc = ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeClosed();
                    
                    if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccfc50si.getArchInputStruct().getCReqFuncCd()) {
                        
                        strncat(TxtToDoDesc, SPLIT_SHORT_DESC, SSD_LENGTH);
                        TxtToDoLongDesc = (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeClosed()) + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeClosed()) + " " + SPLIT_LONG_DESC + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeForward()) + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeForward()) + " " + BY_STRING + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMrgSpltWrkr()) + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeSplitWrkr());
                    }
                    else {
                        strncat(TxtToDoDesc, MERGE_SHORT_DESC, MSD_LENGTH);
                        TxtToDoLongDesc = (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeClosed()) + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeClosed()) + " " + MERGED_LONG_DESC + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeForward()) + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeForward()) + " " + BY_STRING + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeWrkr()) + " " + (ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeWrkr());
                    }
                    strncat(TxtToDoDesc, ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeForward() , CCFC50SI.SCR_NM_PERS_MERGE_FORWARD_LEN);
                    
                    //  Loop through all of the workers that were returned form the clsc48d dam
                    // and send each one an alert about the merge.
                    for (i66 = 0;((i66 < pCLSC48DOutputRec.getArchOutputStruct().getUlRowQty()) && (WtcHelperConstants.ARC_SUCCESS == rc));i66++) {
                        pCSUB40UInputRec.setArchInputStruct(ccfc50si.getArchInputStruct());
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TxtToDoDesc);
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfLongDesc(TxtToDoLongDesc);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(pCLSC48DOutputRec.getROWCLSC48DO_ARRAY().getROWCLSC48DO(i66).getUlIdStage());
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCLSC48DOutputRec.getROWCLSC48DO_ARRAY().getROWCLSC48DO(i66).getUlIdPerson());
                        
                        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccfc50si.getArchInputStruct().getCReqFuncCd()) {
                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getDtDtPersMergeSplit());
                            
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeSplitWrkr());
                            
                            
                            
                            
                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(SPLIT_TODO_CD);
                        }
                        else {
                            
                            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getDtDtPersMerge());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ccfc50si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeWrkr());
                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(MERGE_TODO_CD);
                        }
                        pCSUB40UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(ccfc50si.getArchInputStruct() , ccfc50so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCFC50S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //   _CLSC18DI       *pCLSC18DInputRec;      SIR 22187 - Removed DAM CLSC18D
                // _CLSC18DO       *pCLSC18DOutputRec;     SIR 22187 - Removed DAM CLSC18D
                
                
                
                //  Start Performance Timer
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCFC50S \n");
        }
        return ccfc50so;
    }

}
