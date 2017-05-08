package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN88SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT58DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
/**************************************************************************
** 
** Module File:   CCMN88S.src
**
** Service Name:  CCMN88S
**
** Description:   This service calls the Stage Progression function 
**                CloseOpenStage 
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2-14-95 
** 
** Programmer:    Alex Ramirez
**
** Date      Programmer   Description
** --------  -----------  ------------------------------------------------
** 07/18/95  RAMIREAP     Updated file with the latest service shell changes.
**
** 10/16/95  SOOLEYAG   SIR 1767 - The event description for a closed stage
**                        should contain the decode of the Reason Closed:
**                        field rather than the code plus comments.
**
** 01/10/96  BRUCKMK    SIR 2573: The selected Person Name and ID from the 
**              Person List during stage progression need to be 
**              populated in the InputRec for CCMN03U.
**              Also the flag whether to open or open and close a 
**              stage needs to be passed.
** 1/21/96    DYARGR    SIR 2757 - Added switch for CloseOpenStage to handle
**                      new message for no on-call worker
**
** 03/07/96  DYARGR   SIR 3204 - Volume Test Sir - Call to cint58d
**                    should only be called when closing the Intake stage
**
** 04/16/96  ODONNERJ   SIR 20217 - Added new message to handle the error of 
**          trying to stageprogress froma regionother than the 
**          normal
**                      01-08 (515 - Statewide Intake for example) to PAL
**                      stage.  Please insert message that alerts user that 
**                      no PAL Coordinator exists and that they should assign 
**                      the appropriate region. 
**                      (MsgBox 8370 MSG_NO_PAL_COORD_EXISTS_REASSIGN)
** 
** 06/13/96 BRUCKMK PARAGON Stage Progression fix.  We need to have a 
**          way to bypass the LE Notification requirement for
**          converted PARAGON Intakes ( 5999999 < ID_STAGE <
**          7000000).  Added logic when calling CINT58D to see
**          if the ID_STAGE is in the above range.  If it is,
**          the LE Notification requirement will be bypassed.  
** 6/15/96 RAMIREAP SIR 21658 - Added rc = ARC_SUCCESS before call to
**                      check for the LE Notification bypass.
**                      The CCMN03U input and output records were being
**                      freed in the wrong place.  Se comments for this 
**                      SIR.     
**  7/26/96    zabihin  sir 21891 : version control code was missing,I 
**                      added the lines.
**
**  8/16/96    vanderm  SIR 21940: Updated the Stage Progression
**                      fix.  LE Notification requirement bypassed for
**                      converted Intakes (15000000 <= ID_STAGE <
**                      23000000).  Added #defines for upper and lower
**                      limits and updated the if statement.   
**
**  09/13/96   GLOORJW  SIR 21940 modified signs in order to check
**                      for LE notification for non-paragon/non-converted
**                      cases
**
**  09/26/96   vanderm  SIR 21770 user's person id wasn't being passed to
**                      CloseOpenStage.  Populated ccmn03u input message 
**                      with the user's id.
**
**  10/4/96    vanderm  SIR 11449 pal stages were not being created for
**                      regions 9, 10, and 11.  Added these regions to
**                      the conditional which creates PAL stages.
**
**  1/23/02    douglacs SIR 15151 - Getting MSG_NO_PAL_COORD_EXISTS_REASSIGN
**                      when stage progressing a stage that is in region 99.
**
** 04/09/2003  Srini	IMPACT - Added the case of MSG_NO_PAL_COORD_EXISTS when 
**						MSG_NO_ROWS_RETURNED is returned for the CloseOpenStage 
**						call
**
** 04/11/2003	Srini   IMPACT - Added pServiceStatus error check when MSG_NO_ROWS_RETURNED
**						is returned for the CloseOpenStage call
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/






public class Ccmn88s {
    
    
    /*
    ** SIR 1767 - macro for the task value of the Law Enforcement Notification
    ** ToDo
    */
    public static final String TODO_LE_NOTIF_TASK = "1047";
    public static final int INITIAL_PAGE = 1;
    
    /* SIR 3204 */
    public static final String INTAKE_STAGE = "INT";
    /* SIR 19811 */
    public static final String PAL = "PAL";
    public static final String REGION_ONE = "01";
    public static final String REGION_TWO = "02";
    public static final String REGION_THREE = "03";
    public static final String REGION_FOUR = "04";
    public static final String REGION_FIVE = "05";
    public static final String REGION_SIX = "06";
    public static final String REGION_SEVEN = "07";
    public static final String REGION_EIGHT = "08";
    public static final String REGION_NINE = "09";
    public static final String REGION_TEN = "10";
    public static final String REGION_ELEVEN = "11";
    public static final String REGION_SO = "99";
    
    /*******************************************************************
    ** BRUCKMK: 
    ** PARAGON Stage Progression fix.  We need to have a 
    ** way to bypass the LE Notification requirement for
    ** converted PARAGON Intakes ( 5999999 < ID_STAGE <
    ** 7000000).  Added logic when calling CINT58D to see
    ** if the ID_STAGE is in the above range.  If it is,
    ** the LE Notification requirement will be bypassed. 
    *******************************************************************/
    /*
    ** vanderm SIR 21940: Updated the Stage Progression fix.
    **         Changed #define UPPER_PARAGON_STAGE_ID to 26000000.
    */
    
    public static final int LOWER_PARAGON_STAGE_ID = 5999999;
    public static final int UPPER_PARAGON_STAGE_ID = 7000000;
    public static final int LOWER_CONVERT_STAGE_ID = 15000000;
    public static final int UPPER_CONVERT_STAGE_ID = 23000000;
    CCMN88SO CCMN88S(CCMN88SI ccmn88si) {
        CCMN88SO ccmn88so = new CCMN88SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return Code for DAM calls */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        CCMN03UI pCCMN03UInputRec = null;
        CCMN03UO pCCMN03UOutputRec = null;
        
        /*
        **  Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn88si.getArchInputStruct());
        
        /*
        ** If the current stage started after the stage being submitted
        ** for closure, and the stage is not PAL, ARI, SUB, INV or ADO,
        ** then it is eligible to receive the Service Auths.
        */
        if (0 == PAL.compareTo(ccmn88si.getSzCdStageOpen())) {
            //   If no rows were found, return FND_SUCCESS
            // because the casee id entered was not a closed case
            rc = Ccmn02u.CallCINT21D(ccmn88si, ccmn88so, pServiceStatus);
        }
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            //  Allocate memory for Input and Output Structures
            pCCMN03UInputRec = new CCMN03UI();
            
            pCCMN03UOutputRec = new CCMN03UO();
            rc = WtcHelperConstants.ARC_SUCCESS;
            pCCMN03UInputRec.setUlIdStage(ccmn88si.getUlIdStage());
            pCCMN03UInputRec.setSzCdStage(ccmn88si.getSzCdStage());
            pCCMN03UInputRec.setSzCdStageProgram(ccmn88si.getSzCdStageProgram());
            pCCMN03UInputRec.setSzCdStageOpen(ccmn88si.getSzCdStageOpen());
            pCCMN03UInputRec.setSzCdStageReasonClosed(ccmn88si.getSzCdStageReasonClosed());
            pCCMN03UInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            
            pCCMN03UInputRec.setUlIdPerson(ccmn88si.getUlIdPerson());
            pCCMN03UInputRec.setSzNmPersonFull(ccmn88si.getSzNmPersonFull());
            pCCMN03UInputRec.setUlScrIdPrimChild(ccmn88si.getUlScrIdPrimChild());
            pCCMN03UInputRec.setCSysIndSStgOpenOnly(ccmn88si.getCSysIndSStgOpenOnly());
            //  We are trying to determine which stage we should use for
            // SvcAuths and this will be used later. We store the idStage for each
            // stage type we find that is open and will base which stage
            // to progress the Service Auths to later based on which temp
            // variable in the hierarchy has an idStage in it
            // SIR 21288
            // Removed ADO stage
            if (!(((ccmn88si.getUlIdStage() > LOWER_PARAGON_STAGE_ID) && (ccmn88si.getUlIdStage() < UPPER_PARAGON_STAGE_ID)) || ((ccmn88si.getUlIdStage() >= LOWER_CONVERT_STAGE_ID) && (ccmn88si.getUlIdStage() < UPPER_CONVERT_STAGE_ID)))) {
                
                //  If a stage suitable for receiving the open service auths is not
                // found, set bPassedSvcAuthEdit to FALSE so that an error message
                // informing the user that "Open services auths were found" so they
                // can close them first.
                if (0 == ccmn88si.getSzCdStage().compareTo(INTAKE_STAGE)) {
                    rc = Cint12s.CallCINT58D(ccmn88si, ccmn88so, pServiceStatus);
                }
            }
            
            
            //  Analyze return code for CCMN01U
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    //  Call DAM
                    rc = Ccmn03u.CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
                    
                    
                    
                    //  Analyze return code for CINV43D
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_ASSIGN_ON_CALL_EMPTY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_ASSIGN_ON_CALL_EMPTY;
                            break;
                        case Messages.MSG_NO_ROWS_RETURNED:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_NO_PAL_COORD_EXISTS_REASSIGN;
                            rc = Messages.MSG_NO_PAL_COORD_EXISTS_REASSIGN;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                case Messages.MSG_INT_LE_NOTIF_REQUIRED:
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            // end if(bPassedSvcAuthEdit && bSvcAuthsToProgress)
            //  end SIR 19973
            // 
            
            //  SIR 20911
            // Changed message passed back to error list array to be consistent
            // with other Conclusion edits
            // SIR 23821 -- Added check for CRSR stage types and perform display
            // of error page hyperlink accordingly
            
            if (rc != Messages.MSG_INT_LE_NOTIF_REQUIRED) {
                ccmn88so.setUlIdStage(pCCMN03UOutputRec.getUlIdStage());
                ccmn88so.setSzCdStageType(pCCMN03UOutputRec.getSzCdStageType());
                ccmn88so.setTsLastUpdate(pCCMN03UOutputRec.getTsLastUpdate());
                ccmn88so.setTsSysTsLastUpdate2(pCCMN03UOutputRec.getTsSysTsLastUpdate2());
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn88si.getArchInputStruct() , ccmn88so.getArchOutputStruct());
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
        return ccmn88so;
    }

    static int CallCINT58D(CCMN88SI pInputMsg372, CCMN88SO * pOutputMsg342, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CINT58DI pCINT58DInputRec = null;
        CINT58DO pCINT58DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT58DInputRec = new CINT58DI();
        
        pCINT58DOutputRec = new CINT58DO();
        pCINT58DInputRec.setArchInputStruct(pInputMsg372.getArchInputStruct());
        pCINT58DInputRec.setUlIdStage(pInputMsg372.getUlIdStage());
        pCINT58DInputRec.setSzCdTodoTask(TODO_LE_NOTIF_TASK);
        rc = cint58dQUERYdam(sqlca, pCINT58DInputRec, pCINT58DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                if (DateHelper.NULL_DATE == pCINT58DOutputRec.getDtDtTodoCompleted().year) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_INT_LE_NOTIF_REQUIRED;
                    
                    
                    //  Call CAUD70D
                    rc = Messages.MSG_INT_LE_NOTIF_REQUIRED;
                }
                
                else {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCINT21D(CCMN88SI pInputMsg373, CCMN88SO * pOutputMsg343, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setArchInputStruct(pInputMsg373.getArchInputStruct());
        pCINT21DInputRec.setUlIdStage(pInputMsg373.getUlIdStage());
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if ((0 != REGION_ONE.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_TWO.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_THREE.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_FOUR.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_FIVE.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_SIX.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_SEVEN.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_EIGHT.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_NINE.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_TEN.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_ELEVEN.compareTo(pCINT21DOutputRec.getSzCdStageRegion())) && (0 != REGION_SO.compareTo(pCINT21DOutputRec.getSzCdStageRegion()))) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_NO_PAL_COORD_EXISTS_REASSIGN;
                    rc = Messages.MSG_NO_PAL_COORD_EXISTS_REASSIGN;
                    break;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = SUCCESS;
                    break;
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
