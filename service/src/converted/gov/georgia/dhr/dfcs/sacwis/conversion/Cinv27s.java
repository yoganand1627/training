package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV35DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV42DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV42DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS13DO;
/**************************************************************************
** 
** Module File:   CINV27S.src
**
** Service Name:  CINV27S - RTRV CLIENT FACTORS
**
** Description:   Retrieves information for the APS Client Assessment window
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2/8/95 
** 
** Programmer:    CRG
**
** Date     Initials        Description
** ------   ---------       ------------------------------------------------ 
**
**  04/30/03   Srini		SIR 17091: Added the error handling to take care of full 
**							table scans for ccmn87dQUERYdam.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv27s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String FACTOR_ANSWER_YES = "Y";
    public static final char OUTCOME_IND_NONE = ' ';
    public static final char OUTCOME_IND_ACTION = 'A';
    public static final char OUTCOME_IND_RESULT = 'R';
    public static final String TXT_NARR_TABLENAME = "APS_CLIENT_ASSMT_NARR";
    public static final String TXT_NARR_EXISTS = "NARRATIVE";
    public static final String CONCL_EVENT_TYPE = "CCL";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String INVESTIGATION = "INV";
    CINV27SO CINV27S(CINV27SI cinv27si) {
        CINV27SO cinv27so = new CINV27SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        CINV27SO CINV27SO = null;
        
        
        
        /*
        ** SIR 13618 This dam select facility investigaiton information
        ** into specific variables in the facility_invst_dtl table.
        */
        rc = ARC_PRFServiceStartTime_TUX(cinv27si.getArchInputStruct());
        if (0 == cinv27si.getSzCdStage().compareTo(INVESTIGATION)) {
            
            // Call DAM to Delete Prior Allegations
            rc = Cinv19s.CallCINV44D(cinv27si, cinv27so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            // Call DAM to NULL out FAcility INVST DTL
            rc = Ccmn02u.CallCCMN87D(cinv27si, cinv27so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (cinv27si.getUlIdEvent() != 0) {
            rc = Ccmn01u.CallCCMN45D(cinv27si, cinv27so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = CallCINV35D(cinv27si, cinv27so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            //  Check # of PAL training elements
            
            rc = Cinv29s.CallCSYS13D(cinv27si, cinv27so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        
        /*********************************************************************
        *  Prepare output message to be returned and return
        **********************************************************************/
        
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cinv27si.getArchInputStruct() , cinv27so.getArchOutputStruct());
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
                //  Retrieve the Pal worker assigned to the Pal Stage
                
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv27so;
    }

    static int CallCCMN45D(CINV27SI pInputMsg683, CINV27SO pOutputMsg633, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setUlIdEvent(pInputMsg683.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg633.getROWCCMN45DO().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
            pOutputMsg633.getROWCCMN45DO().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
            pOutputMsg633.getROWCCMN45DO().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
            pOutputMsg633.getROWCCMN45DO().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
            pOutputMsg633.getROWCCMN45DO().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
            pOutputMsg633.getROWCCMN45DO().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
            pOutputMsg633.getROWCCMN45DO().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
            pOutputMsg633.getROWCCMN45DO().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
            pOutputMsg633.getROWCCMN45DO().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
        }
        return rc;
    }

    
    static int CallCCMN87D(CINV27SI pInputMsg684, CINV27SO pOutputMsg634, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCCMN87DInputRec.setArchInputStruct(pInputMsg684.getArchInputStruct());
        pCCMN87DInputRec.setUlIdStage(pInputMsg684.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CONCL_EVENT_TYPE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);/* so return zero                         */
        if (rc != 0) {
            
            
            
            //  Analyze return code
            switch (rc) {
                case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        else if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
            pOutputMsg634.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
        }
        else {
            pOutputMsg634.setUlIdEvent(0);
        }
        return rc;
    }

    static int CallCINV44D(CINV27SI pInputMsg685, CINV27SO pOutputMsg635, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CINV44DI pCINV44DInputRec = null;
        CINV44DO pCINV44DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV44DInputRec = new CINV44DI();
        
        pCINV44DOutputRec = new CINV44DO();
        pCINV44DInputRec.setArchInputStruct(pInputMsg685.getArchInputStruct());
        pCINV44DInputRec.setUlIdStage(pInputMsg685.getUlIdStage());
        
        
        /*
        ** Declare local variables 
        */
        
        /*
        ** Start performance timer for service. All performance functions always
        ** return success so there is no need to check status.
        */
        
        rc = cinv44dQUERYdam(sqlca, pCINV44DInputRec, pCINV44DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            //  Analyze error code
            switch (rc) {
                    // RIOSJA, SIR 18871
                case NO_DATA_FOUND:
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg635.getROWCINV27SOG02().setUlIdEvent(pCINV44DOutputRec.getROWCINV44DO().getUlIdEvent());
            pOutputMsg635.getROWCINV27SOG02().setUlIdStage(pCINV44DOutputRec.getROWCINV44DO().getUlIdStage());
            pOutputMsg635.getROWCINV27SOG02().setSzCdApsInvstFinalPrty(pCINV44DOutputRec.getROWCINV44DO().getSzCdApsInvstFinalPrty());
            pOutputMsg635.getROWCINV27SOG02().setSzcdApsInvstOvrallDisp(pCINV44DOutputRec.getROWCINV44DO().getSzcdApsInvstOvrallDisp());
            //  Increment counter by 1
            pOutputMsg635.getROWCINV27SOG02().setDtDtApsInvstBegun(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstBegun());
            pOutputMsg635.getROWCINV27SOG02().setDtDtApsInvstCltAssmt(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstCltAssmt());
            
            //  Increment counter by 1
            pOutputMsg635.getROWCINV27SOG02().setDtDtApsInvstCmplt(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstCmplt());
            pOutputMsg635.getROWCINV27SOG02().setTsLastUpdate(pCINV44DOutputRec.getROWCINV44DO().getTsLastUpdate());
        }
        return rc;
    }

    static int CallCINV35D(CINV27SI pInputMsg686, CINV27SO pOutputMsg636, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i343 = 0;
        
        /*
        ** Declare local variables
        */
        CINV35DI pCINV35DInputRec = null;
        CINV35DO pCINV35DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV35DInputRec = new CINV35DI();
        
        pCINV35DOutputRec = new CINV35DO();
        pCINV35DInputRec.setArchInputStruct(pInputMsg686.getArchInputStruct());
        pCINV35DInputRec.setUlIdEvent(pInputMsg686.getUlIdEvent());
        pCINV35DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg686.getArchInputStruct().getUsPageNbr());
        pCINV35DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg686.getArchInputStruct().getUlPageSizeNbr());
        
        
        /*
        ** Call CAUD33D
        */
        rc = cinv35dQUERYdam(sqlca, pCINV35DInputRec, pCINV35DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    rc = 0;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        
        else {
            
            //  Populate Output Message
            for (i343 = 0;i343 < pCINV35DOutputRec.getArchOutputStruct().getUlRowQty();++i343) {
                pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setUlIdApsCltFactor(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i343).getUlIdApsCltFactor());
                
                pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setUlIdEvent(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i343).getUlIdEvent());
                pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setUlIdSituation(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i343).getUlIdSituation());
                pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setSzCdApsClientFactor(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i343).getSzCdApsClientFactor());
                pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setSzCdApsCltFactorAns(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i343).getSzCdApsCltFactorAns());
                pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setCCdApsClientFactor(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i343).getCCdApsClientFactor());
                pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setSzTxtApsCltFactorCmnts(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i343).getSzTxtApsCltFactorCmnts());
                
                //  SIR 21003 - Changed "extendo" date
                // processing to have == instead of =
                //  Potential for difference in dates being too
                // large prevented using compare date and time.
                // Instead, "extendo" compare date processing
                // is being used
                //  If year is greater
                if (!(strncmp(pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).getSzCdApsCltFactorAns() , FACTOR_ANSWER_YES, FACTOR_ANSWER_YES.length()) != 0)) {
                    rc = CallCINV42D(pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).getUlIdApsCltFactor() , pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).getBSysIndOutcome() , pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case SUCCESS:
                            break;
                            
                        case NO_DATA_FOUND:
                            
                            
                            //  Call CSES23D
                            rc = 0;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                else {
                    pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setBSysIndOutcome(OUTCOME_IND_NONE);
                }
                pOutputMsg636.getROWCINV27SOG01_ARRAY().getROWCINV27SOG01(i343).setTsLastUpdate(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i343).getTsLastUpdate());
            };
            pOutputMsg636.getArchOutputStruct().setUlRowQty(pCINV35DOutputRec.getArchOutputStruct().getUlRowQty());
        }
        return rc;
    }

    static int CallCINV42D(int ulIdFactor, String bIndOutcome, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i344 = 0;
        
        /*
        ** Declare local variables
        */
        CINV42DI pCINV42DInputRec = null;
        CINV42DO pCINV42DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV42DInputRec = new CINV42DI();
        
        pCINV42DOutputRec = new CINV42DO();
        pCINV42DInputRec.setUlIdApsCltFactor(ulIdFactor);
        pCINV42DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINV42DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV42DO._CINV42DO__ROWCINV42DO_SIZE);
        /*
        **     bCMSC20Dfail = TRUE;
        **
        ** IMPACT END
        */
        
        
        /*
        ** Start Performance Timer
        */
        rc = cinv42dQUERYdam(sqlca, pCINV42DInputRec, pCINV42DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    bIndOutcome = CStringUtils.setCharAt(bIndOutcome, 0, OUTCOME_IND_NONE);
                    rc = 0;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            bIndOutcome = CStringUtils.setCharAt(bIndOutcome, 0, OUTCOME_IND_NONE);
            for (i344 = 0;i344 < pCINV42DOutputRec.getArchOutputStruct().getUlRowQty();++i344) {
                if (pCINV42DOutputRec.getROWCINV42DO_ARRAY().getROWCINV42DO(i344).getSzCdApsOutcomeAction().compareTo("") != 0) {
                    bIndOutcome = CStringUtils.setCharAt(bIndOutcome, 0, OUTCOME_IND_ACTION);
                }
                //  This indicates that a Law Enforcement Notification ToDo for
                // the stage has been found.  So, now we must determine if the
                // ToDo is complete or not
                if (pCINV42DOutputRec.getROWCINV42DO_ARRAY().getROWCINV42DO(i344).getSzCdApsOutcomeResult().compareTo("") != 0) {
                    bIndOutcome = CStringUtils.setCharAt(bIndOutcome, 0, OUTCOME_IND_RESULT);
                    
                    // 
                    // (END): Update Region and County on Stage Table
                    // 
                    
                    
                    break;
                }
            };
        }
        return rc;
    }

    static int CallCSYS13D(CINV27SI pInputMsg687, CINV27SO pOutputMsg637, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CSYS13DI pCSYS13DInputRec = null;
        CSYS13DO pCSYS13DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS13DInputRec = new CSYS13DI();
        
        pCSYS13DOutputRec = new CSYS13DO();
        pCSYS13DInputRec.setArchInputStruct(pInputMsg687.getArchInputStruct());
        pCSYS13DInputRec.setUlIdEvent(pInputMsg687.getUlIdEvent());
        pCSYS13DInputRec.setSzSysTxtTablename(TXT_NARR_TABLENAME);
        
        
        /*
        ** Call CCMN44D
        */
        rc = csys13dQUERYdam(sqlca, pCSYS13DInputRec, pCSYS13DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg637.setSzScrTxtNarrStatus("");
                    rc = 0;
                    
                    // 
                    // END OF NESTED PORITION FOR CASE SUCCESS IN CCMN45D
                    // 
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg637.setSzScrTxtNarrStatus(TXT_NARR_EXISTS);
        }
        return rc;
    }

}
