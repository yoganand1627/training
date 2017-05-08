package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC02S.src
**
** Service Name:  CCFC02S - PAL ISL ASSMT SAVE
**
** Description:   This service will update all columns for an Id Stage from 
**                the PAL table.  It will also update all the columns for an 
**                Id Event form the EVENT table.  It can add or modify a PAL 
**                row.  It can add or modify the Event row.  It will also 
**                create a link between the event and the primary child for 
**                the PAL stage.  It will call DAMs CAUD49D - PAL AUD  and  
**                CINV51D - RTRV PRIMARY EMPL.  It also calls common function 
**                CCMN01U - POST EVENT.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 12, 1996
** 
** Programmer:    James J. O'Mara 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:34:26  $
**                      $Modtime:   29 Mar 1996 23:53:16  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  03/01/96  OMARAJJ   SIR#3513 - Added the TODO AUD Dam, CINV43D, to the
**                      save service so that whenever the data for PAL ILS
**                      Assessment is saved, the associated TODO, if any, will
**                      be taken off the Staff TODO List.  This is necessary
**                      because in the PAL Dialog when a TODO is completed for 
**                      the ILS or RUT windows the event status remains PROC
**                      until the stage is completed through the PAL Summary
**                      window.  Thus, simply completing a TODO would not have
**                      removed it from the TODO List.  The CINV43D dam updates
**                      the date TODO completed and removes the TODO from the
**                      TODO list whenever the window data is saved.
** 
** 03/12/96  OMARAJJ    SIR#3838 - Added an SQL_NOT_FOUND case within the 
**                      SQL_SUCCESS case so that in situations when no TODO
**                      exists the call to the TODO Update DAM, CINV43D, will
**                      not fail due an SQL NOT FOUND error.
**  01/29/03   Srini D  Added rc = FND_SUCCESS for the SQL_NOT_FOUND case but 
**                                              returning success values.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc02s {
    static final String PRIMARY_CHILD1 = "PC";
    static final String ILS_ASSESSMENT_RESULTS = "Recording ILS Assessment Results";
    static final String INDEPENDENT_LIVING_SKILLS = "ILS";
    static final String STATUS_NEW2 = "NEW";
    static final String STATUS_PROCESS1 = "PROC";
    static final String STATUS_COMPLETE1 = "COMP";
    CCFC02SO CCFC02S(CCFC02SI ccfc02si) {
        CCFC02SO ccfc02so = new CCFC02SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        public public public public public public int usRow = 0;
        int usInputRow = 0;
        int ulIdPerson1 = 0;
        
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        CAUD49DI pCAUD49DInputRec = null;/* pointer to DAM input record  */
        CAUD49DO pCAUD49DOutputRec = null;/* pointer to DAM output record  */
        CCMN01UI pCCMN01UInputRec = null;/* Post Event common function          */
        
        CCMN01UO pCCMN01UOutputRec = null;
        CINV43DI pCINV43DInputRec = null;/* ToDo Complete AUD dam: update only  */
        
        CINV43DO pCINV43DOutputRec = null;
        
        
        /*
        ** Used below to signal early return (MDM 02/24/2003)
        ** It's needed to make sure common freeing of memory still happens
        */
        boolean bGotoEnd = false;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc02si.getArchInputStruct());
        
        /*
        ** Initialize Service Status Fields 
        */
        
        /*
        **  Perform Main Processing
        */
        
        
        /**********************************************************************
        **(BEGIN): CINV51D -- RTRV PRIMARY EMPL DAM
        ***********************************************************************/
        
        /* Call CINV51D -- RTRV PRIMARY EMPL DAM if the SaveDetailWindow common 
        ** function passes an IdEvent, (IdEvent != NULL). 
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINV51DInputRec = new CINV51DI();
        
        pCINV51DOutputRec = new CINV51DO();
        pCINV51DInputRec.setUlIdStage(ccfc02si.getROWCCMN01UIG00().getUlIdStage());
        pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD1);
        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ulIdPerson1 = pCINV51DOutputRec.getUlIdTodoPersAssigned();
                
                // CCMN01U -- POST EVENT
                
                // 
                // (BEGIN): Common Function: CCMN01U   Post Event common function
                // 
                
                //  Allocate memory for Common Function Input and Output Structures
                pCCMN01UInputRec = new CCMN01UI();
                
                pCCMN01UOutputRec = new CCMN01UO();
                if (0 == ccfc02si.getROWCCMN01UIG00().getUlIdEvent()) {
                    
                    //  SIR 15512
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                
                else {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                }
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(ccfc02si.getROWCCMN01UIG00().getUlIdPerson());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(STATUS_PROCESS1);
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(INDEPENDENT_LIVING_SKILLS);
                //  If no row was found on the CASE_MERGE table ZZZ is not
                // an acceptable choice.  Return MSG_INV_DISP_INVALID
                rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(ccfc02si.getROWCCMN01UIG00().getUlIdEvent());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccfc02si.getROWCCMN01UIG00().getUlIdStage());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(ccfc02si.getROWCCMN01UIG00().getSzCdTask());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(ILS_ASSESSMENT_RESULTS);
                
                // Insert new records into Contract_County
                if (0 != ccfc02si.getROWCCMN01UIG00().getUlIdEvent()) {
                    
                    pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(ccfc02si.getTsSysTsLastUpdate2());
                }
                if (WINDOW_MODE_NEW == ccfc02si.getSzSysCdWinMode()) {
                    pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(ulIdPerson1);
                    pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        // 
                        // (BEGIN): CAUD49D
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUD49DInputRec = new CAUD49DI();
                        
                        pCAUD49DOutputRec = new CAUD49DO();
                        pCAUD49DInputRec.getArchInputStruct().setCReqFuncCd(ccfc02si.getArchInputStruct().getCReqFuncCd());
                        pCAUD49DInputRec.setSzCdPalCloseLivArr(ccfc02si.getSzCdPalCloseLivArr());
                        pCAUD49DInputRec.setSzTxtPalIlNoIlsRsn(ccfc02si.getSzTxtPalIlNoIlsRsn());
                        pCAUD49DInputRec.setDtDtPalPostasmtDate(ccfc02si.getDtDtPalPostasmtDate());
                        pCAUD49DInputRec.setDtDtPalPreasmtDate(ccfc02si.getDtDtPalPreasmtDate());
                        pCAUD49DInputRec.setTsLastUpdate(ccfc02si.getTsLastUpdate());
                        pCAUD49DInputRec.setUlIdStage(ccfc02si.getROWCCMN01UIG00().getUlIdStage());
                        pCAUD49DInputRec.setCIndPalIlNoIlsAssmt(ccfc02si.getCIndPalIlNoIlsAssmt());
                        pCAUD49DInputRec.setCIndPalIlNoPoasmt_Scre(ccfc02si.getCIndPalIlNoPoasmt_Scre());
                        pCAUD49DInputRec.setCIndPalIlNoPrasmtScre(ccfc02si.getCIndPalIlNoPrasmtScre());
                        pCAUD49DInputRec.setLNbrPalPostasmtScore(ccfc02si.getLNbrPalPostasmtScore());
                        pCAUD49DInputRec.setLNbrPalPreasmtScore(ccfc02si.getLNbrPalPreasmtScore());
                        rc = caud49dAUDdam(sqlca, pCAUD49DInputRec, pCAUD49DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                bGotoEnd = true;
                                
                                break;
                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                bGotoEnd = true;
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                bGotoEnd = true;
                                
                                break;
                        }
                        
                        
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        bGotoEnd = true;
                        
                        break;
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        bGotoEnd = true;
                        
                        // 
                        // END CAUD15D
                        // 
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        bGotoEnd = true;
                        
                        
                        break;
                }
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                bGotoEnd = true;
                break;
                
            default :
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                bGotoEnd = true;
                break;
        }
        if (!(bGotoEnd)) {
            
            
            //  SIR#3513 - Added the TODO AUD Dam, CINV43D, to the
            // save service so that whenever the data for PAL ILS
            // Assessment is saved, the associated TODO, if any, will
            // be taken off the Staff TODO List.  This is necessary
            // because in the PAL Dialog when a TODO is completed for 
            // the ILS or RUT windows the event status remains PROC
            // until the stage is completed through the PAL Summary
            // window.  Thus, simply completing a TODO would not have
            // removed it from the TODO List.  The CINV43D dam updates
            // the date TODO completed and removes the TODO from the
            // TODO list whenever the window data is saved.
            //  Allocate memory for DAM Input and Output Structures
            pCINV43DInputRec = new CINV43DI();
            
            pCINV43DOutputRec = new CINV43DO();
            
            pCINV43DInputRec.setArchInputStruct(ccfc02si.getArchInputStruct());
            pCINV43DInputRec.getArchInputStruct().setCReqFuncCd(ccfc02si.getArchInputStruct().getCReqFuncCd());
            pCINV43DInputRec.setUlIdEvent(ccfc02si.getROWCCMN01UIG00().getUlIdEvent());
            
            //  Call DAM
            rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            
            
            //  Load Translation Map
            
            //  Stop Performance Timer
            ARC_PRFServiceStopTime_TUX(ccfc02si.getArchInputStruct() , ccfc02so.getArchOutputStruct());
        }
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
                //  If no row was found on the CASE_MERGE table ZZZ is not
                // an acceptable choice.  Return MSG_INV_DISP_INVALID
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        
        return ccfc02so;
    }

}
