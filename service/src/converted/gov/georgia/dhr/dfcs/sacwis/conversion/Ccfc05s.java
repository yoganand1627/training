package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD75DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD76DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES94DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES94DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC05S.src
**
** Service Name:  CCFC05S
**
** Description:   This service will update the close date ofr the Stage, 
**                Situation and Case tables to null.  It will also set the 
**                stage closure reason to null on the STAGE table.  
**                Additionally, the new primary worker will be added t the 
**                stage along with a link to the primary child.  Finally, the
**                ILS Assessment and PAL Services event statuses will be set 
**                back to "PROC".  When the case is reopened, the records 
**                retention recored must be deleted and the case file 
**                management recored must be updated with the appropriate 
**                information.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/08/95
** 
** Programmer:    Timothy R. Overend 
**
** Archive Information: $Revision:   1.0.2.0.1.1  $
**                      $Date:   31 Mar 1997 12:57:18  $
**                      $Modtime:   31 Mar 1997 10:44:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/20/96  OMARAJJ   SIR#3989 - Set the CAUD75DInputRec->tsLastUpdate to 
**                      the tsLastUpdate retreived from the Rec Retention table.  
**                      It should not be set to the CCFC05SI tsLastUpdate 
**                      because the timestamp may differ, resulting in 
**                      timestamp mismatch errors.
** 
**  03/20/96  OMARAJJ   SIR#3991 - Included the case SQL_NOT_FOUND within 
**                      SQL_SUCCESS after the call to CAUD46 because in 
**                      situations when there is no Unpaid Services and 
**                      Training event the switch statement should not skip 
**                      the update to the ILS event.
**  05/09/96  PHILLILH  SIR #21002 - Set bIndStagePersEmpNew to EMP_IS_NEW
**                      so that '1' is returned to Assigned Workload
**                      and the row will be shaded.
**
**  09/09/96  vanderm   SIR#22187 - Multiple historical primary workers
**                      were being added to a PAL stage that was reopened
**                      by a person other than the primary worker who
**                      previously closed the stage.
**
** 03/13/97   MATTESJM  SIR 13445 - Added functionality pass a new message
**                      to the PAL Summary  window to prevent a ReOpen PAL
**                      stage if an open PAL Stage already exists
**                      for the id_person of the PC passed in.  Created 
**                      CSES94D to count the number of stages that the PC is
**                      currently in for the given cd_stage (ex. PAL).  If
**                      the count(*) returned is > 0 and dt_stage_close is
**                      null, display a new message that an Open PAL stage
**                      already exists for this child.  Moved the dam cinv51d
**                      to the top of the service so that the id of the PC
**                      is known at the beginning of the service as opposed 
**                      to the end.  Removed all of the memory free's for 
**                      subsequent dam calls also since the memory is freed
**                      at the top also.
**                           
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc05s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String MEMBER_IN = "IN";
    public static final String PRIMARY_ROLE = "PR";
    public static final String TYPE_STAFF = "STF";
    public static final char IND_YES = '1';
    public static final String PRIMARY_CHILD_ROLE = "PC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_IN_PROCESS = "PROC";
    public static final String EVENT_TYPE_ILS = "ILS";
    public static final String EVENT_TYPE_PRO = "PRO";
    public static final String EVENT_TXT_DESCRIPTION = "PAL Stage has been Re-Opened";
    public static final String EVENT_TYPE_RUT = "RUT";
    public static final int NUMOFROWS = 50;
    
    public static final int INITIAL_PAGE = 1;
    /* SIR #21002 */
    public static final char EMP_IS_NEW = '1';
    
    /* SIR #13445 - added CSES94D */
    public static final char OPEN = 'O';
    public static final String PREP_ADULT = "PAL";
    CCFC05SO CCFC05S(CCFC05SI ccfc05si) {
        CCFC05SO ccfc05so = new CCFC05SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i14 = 0;
        int ulIdSituation1 = 0;
        int ulIdPersonChild = 0;
        int ulIdUnit1 = 0;
        int ulIdStagePersonLink = 0;
        
        String StageSysTsLastUpdate = new String();
        
        FndInt3date dtDtNULL = null;
        FndInt3date dtCurrentDate = null;
        FndInt3date dtDateStageClosed = null;
        
        CAUD47DI pCAUD47DInputRec = null;
        CAUD47DO pCAUD47DOutputRec = null;
        CAUD64DI pCAUD64DInputRec = null;
        CAUD64DO pCAUD64DOutputRec = null;
        CAUD75DI pCAUD75DInputRec = null;
        CAUD75DO pCAUD75DOutputRec = null;
        CAUD76DI pCAUD76DInputRec = null;
        CAUD76DO pCAUD76DOutputRec = null;
        CCMND3DI pCCMND3DInputRec = null;
        CCMND3DO pCCMND3DOutputRec = null;
        CCMN39DI pCCMN39DInputRec = null;
        CCMN39DO pCCMN39DOutputRec = null;
        
        CCMN01UI pCCMN01UInputRec = null;
        
        CCMN01UO pCCMN01UOutputRec = null;
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        CINV51DI pCINV51DInputRec = null;/* Get IdPerson given IdStage & Role */
        
        CINV51DO pCINV51DOutputRec = null;
        CMSC15DI pCMSC15DInputRec = null;
        CMSC15DO pCMSC15DOutputRec = null;
        CMSC17DI pCMSC17DInputRec = null;
        CMSC17DO pCMSC17DOutputRec = null;
        CMSC18DI pCMSC18DInputRec = null;
        CMSC18DO pCMSC18DOutputRec = null;
        CSES56DI pCSES56DInputRec = null;
        CSES56DO pCSES56DOutputRec = null;
        CSES57DI pCSES57DInputRec = null;
        CSES57DO pCSES57DOutputRec = null;
        CAUDA0DI pCAUDA0DInputRec = null;/* SIR 22187 - Added DAM CAUDA0D */
        CAUDA0DO pCAUDA0DOutputRec = null;/* SIR 22187 - Added DAM CAUDA0D */
        CSES94DI pCSES94DInputRec = null;/* SIR 13445 - Added DAM CSES94D */
        CSES94DO pCSES94DOutputRec = null;/* SIR 13445 - Added DAM CSES94D */
        rc = ARC_PRFServiceStartTime_TUX(ccfc05si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Initialize the null date
        */
        dtDtNULL.day = DateHelper.NULL_DATE;
        dtDtNULL.month = DateHelper.NULL_DATE;
        dtDtNULL.year = DateHelper.NULL_DATE;
        
        /*
        ** Initialize the current date
        */
        dtCurrentDate.day = DateHelper.NULL_DATE;
        dtCurrentDate.month = DateHelper.NULL_DATE;
        dtCurrentDate.year = DateHelper.NULL_DATE;
        
        /*
        ** Initialize Service Status Fields 
        */
        
        /*
        **  Perform Main Processing
        */
        
        
        /**************************************************************************
        ** Call the Retrieve Primary Emplyoee Dam - CINV51D
        **                                                                                                                    
        ** Description - This dam will retrieve the ID PERSON for a given role for
        **               a given stage.  It's used to find the primary worker for
        **               a stage.
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINV51DInputRec = new CINV51DI();
        
        pCINV51DOutputRec = new CINV51DO();
        pCINV51DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
        pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD_ROLE);
        pCINV51DInputRec.setUlIdStage(ccfc05si.getUlIdStage());
        
        
        /*
        ** Call CAUD37D
        */
        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                ulIdPersonChild = pCINV51DOutputRec.getUlIdTodoPersAssigned();
                
                
                //  SIR# 13445 
                // We need to determine if the id_person passed in by the
                // functional window is already the primary child in an
                // OPEN PAL stage. If so, display a message that an Open PAL 
                // stage already exists for this child.
                
                //  Allocate memory for Input and Output Structures
                pCSES94DInputRec = new CSES94DI();
                pCSES94DOutputRec = new CSES94DO();
                pCSES94DInputRec.setUlIdPerson(ulIdPersonChild);
                rc = CallCSES94D(ccfc05si, ccfc05so, pCSES94DInputRec, pCSES94DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        /**************************************************************************
        ** End Call to Retrieve Primary Emplyoee Dam - CINV51D
        **************************************************************************/
        
        
        
        
        
        
        
        
        /**************************************************************************
        ** Call the Stage Retrieval Dam - CINT40D
        **
        ** Description - This DAM will return one row from the stage
        *                table based upon the id_stage passed into it.
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        pCINT40DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(ccfc05si.getUlIdStage());
        
        
        /*
        ** Call CSES07D
        */
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                StageSysTsLastUpdate = pCINT40DOutputRec.getTsLastUpdate();
                ulIdSituation1 = pCINT40DOutputRec.getUlIdSituation();
                
                dtDateStageClosed = pCINT40DOutputRec.getDtDtStageClose();
                
                // 
                // Call the Situation Reopen Dam - CMSC17D
                // Description - This DAM will UPDATE DT_SITUATION_CLOSED on the SITUATION
                // table based on input of ID_SITUATION.
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCMSC17DInputRec = new CMSC17DI();
                
                pCMSC17DOutputRec = new CMSC17DO();
                pCMSC17DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                pCMSC17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                pCMSC17DInputRec.setUlIdSituation(ulIdSituation1);
                pCMSC17DInputRec.setDtDtSituationClosed(dtDtNULL);
                rc = cmsc17dAUDdam(sqlca, pCMSC17DInputRec, pCMSC17DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                        //  No rows found for this stage is OK.  An error message will
                        // display informing the user that no rows were found for this
                        // stage of service.  This error will not be logged to the 
                        // Session Transcript.
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        // 
                        // Call the Case Reopen Dam - CMSC18D
                        // Description - Will update closure date of CAPS CASE table based on input
                        // of ID CASE.
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCMSC18DInputRec = new CMSC18DI();
                        
                        pCMSC18DOutputRec = new CMSC18DO();
                        pCMSC18DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                        pCMSC18DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        pCMSC18DInputRec.setUlIdCase(ccfc05si.getUlIdCase());
                        pCMSC18DInputRec.setDtDtCaseClosed(dtDtNULL);
                        rc = cmsc18dAUDdam(sqlca, pCMSC18DInputRec, pCMSC18DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                // 
                                // Call the Stage Closure Dam - CAUD47D
                                // Description - This DAM updates DT_STAGE_CLOSE, CD_STAGE_REASON_CLOSED,
                                // and TXT_STAGE CLOSURE COMMENTS using ID_STAGE and
                                // DT_LAST_UPDATE as inputs.
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD47DInputRec = new CAUD47DI();
                                
                                pCAUD47DOutputRec = new CAUD47DO();
                                pCAUD47DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                                pCAUD47DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                pCAUD47DInputRec.setUlIdStage(ccfc05si.getUlIdStage());
                                pCAUD47DInputRec.setDtDtStageClose(dtDtNULL);
                                pCAUD47DInputRec.setTsLastUpdate(StageSysTsLastUpdate);
                                
                                //  Populate DAM input structure
                                
                                //  First, get date and time for dtSysDtTodoCfDueFrom
                                rc = caud47dAUDdam(sqlca, pCAUD47DInputRec, pCAUD47DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        
                                        // 
                                        // Call the PAL Closure Liv Arr Dam - CMSC15D
                                        // Description - This dam updates the PAL table's living arrangment based 
                                        // upon id stage.
                                        // 
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCMSC15DInputRec = new CMSC15DI();
                                        
                                        pCMSC15DOutputRec = new CMSC15DO();
                                        pCMSC15DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                                        pCMSC15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        pCMSC15DInputRec.setUlIdStage(ccfc05si.getUlIdStage());
                                        
                                        
                                        //  Call Todo common function
                                        rc = cmsc15dAUDdam(sqlca, pCMSC15DInputRec, pCMSC15DOutputRec);
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                // 
                                                // Call the Staff Unit Simple Dam - CCMN39D
                                                // Description - This DAM receives an ID PERSON and a CD UNIT MEMBER
                                                // ROLE and returns a full row from the UNIT table, a full
                                                // row from the UNIT EMP LINK table and NM PERSON FULL from
                                                // the PERSON table.  The returned information applies to
                                                // the unit to which the ID PERSON is assigned with the given
                                                // CD UNIT MEMBER ROLE.  The NM PERSON FULL is the name of
                                                // the Unit Approver for that unit.
                                                // 
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCCMN39DInputRec = new CCMN39DI();
                                                
                                                pCCMN39DOutputRec = new CCMN39DO();
                                                pCCMN39DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                                                pCCMN39DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                pCCMN39DInputRec.setUlIdPerson(ccfc05si.getROWCCMN01UIG00().getUlIdPerson());
                                                
                                                pCCMN39DInputRec.setSzCdUnitMemberInOut(MEMBER_IN);
                                                rc = ccmn39dQUERYdam(sqlca, pCCMN39DInputRec, pCCMN39DOutputRec);
                                                
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        ulIdUnit1 = pCCMN39DOutputRec.getUlIdUnit();
                                                        
                                                        //  SIR 22187
                                                        // Commented out Call to DAM CLSC18D because it would only return the 
                                                        // historical primary of a closed PAL stage if the person logged in 
                                                        // is the historical primary.
                                                        // Call the Stage Person Link Retrieval Dam - CLSC18D
                                                        // Description - This dam rtrieves all principals linked to stage along
                                                        // with their county, region, name, stage role, & stage relation
                                                        // Allocate memory for DAM Input and Output Structures
                                                        // pCLSC18DInputRec = (_CLSC18DI *) malloc(sizeof(_CLSC18DI));
                                                        // if (pCLSC18DInputRec == NULL)
                                                        // {
                                                        // free(pCINT40DInputRec);
                                                        // free(pCINT40DOutputRec);
                                                        // free(pCMSC17DInputRec);
                                                        // free(pCMSC17DOutputRec);
                                                        // free(pCMSC18DInputRec);
                                                        // free(pCMSC18DOutputRec);
                                                        // free(pCAUD47DInputRec);
                                                        // free(pCAUD47DOutputRec);
                                                        // free(pCMSC15DInputRec);
                                                        // free(pCMSC15DOutputRec);
                                                        // free(pCCMN39DInputRec);
                                                        // free(pCCMN39DOutputRec);
                                                        // rc = ARC_ERR_MALLOC_FAILED;
                                                        // PROCESS_TUX_RC_ERROR;
                                                        // }
                                                        // pCLSC18DOutputRec = (_CLSC18DO *) malloc(sizeof(_CLSC18DO));
                                                        // if (pCLSC18DOutputRec == NULL)
                                                        // {
                                                        // free(pCINT40DInputRec);
                                                        // free(pCINT40DOutputRec);
                                                        // free(pCMSC17DInputRec);
                                                        // free(pCMSC17DOutputRec);
                                                        // free(pCMSC18DInputRec);
                                                        // free(pCMSC18DOutputRec);
                                                        // free(pCAUD47DInputRec);
                                                        // free(pCAUD47DOutputRec);
                                                        // free(pCMSC15DInputRec);
                                                        // free(pCMSC15DOutputRec);
                                                        // free(pCCMN39DInputRec);
                                                        // free(pCCMN39DOutputRec);
                                                        // free(pCLSC18DInputRec);
                                                        // rc = ARC_ERR_MALLOC_FAILED;
                                                        // PROCESS_TUX_RC_ERROR;
                                                        // }
                                                        // Initialize DAM Input and Output Structures
                                                        // memset( pCLSC18DInputRec,NULL,sizeof(_CLSC18DI));
                                                        // memset( pCLSC18DOutputRec,NULL,sizeof(_CLSC18DO));
                                                        // Populate the username in the DAM Input architecture header by copying 
                                                        // the service input header message 
                                                        // architecture header to the DAM Input architecture header.
                                                        // memcpy (&pCLSC18DInputRec->ArchInputStruct, 
                                                        // &pInputMsg->ArchInputStruct, sizeof (_ARCHINPUTSTRUCT)); 
                                                        // Populate DAM input structure
                                                        // Set CLSC18D ReqFuncCode to CCFC05SI ReqFuncCode
                                                        // COPYSZ(pCLSC18DInputRec->szCdStagePersType,TYPE_STAFF);
                                                        // pCLSC18DInputRec->ulIdStage = pInputMsg->ulIdStage;
                                                        // Set the page size to be retrieved
                                                        // pCLSC18DInputRec->ArchInputStruct.usPageNbr = INITIAL_PAGE;
                                                        // pCLSC18DInputRec->ArchInputStruct.ulPageSizeNbr = NUMOFROWS;
                                                        // Start DAM Performance Timer
                                                        // ARC_PRFDataAccessStartTime("CLSC18D");
                                                        // Call CLSC18D
                                                        // rc = clsc18dQUERYdam((void *)&sqlca, 
                                                        // pCLSC18DInputRec, 
                                                        // pCLSC18DOutputRec);
                                                        // Stop DAM Performance Timer
                                                        // ARC_PRFDataAccessStopTime();
                                                        // Analyze return code
                                                        // switch(rc)
                                                        // {
                                                        // case SQL_SUCCESS: 
                                                        // Set severity to SUCCESS
                                                        // pServiceStatus->severity = FND_SEVERITY_OK;
                                                        // pServiceStatus->explan_code = FND_SUCCESS;
                                                        // Loop through the service and check to see if the person
                                                        // opening the stage is a historically primary worker or 
                                                        // not.  Since you can only have one id_person per stage
                                                        // on the stage_person_link, the only occurence will be
                                                        // the hp since the stage is closed.
                                                        // for(i=0;i<pCLSC18DOutputRec->ArchOutputStruct.ulRowQty;i++)
                                                        // {
                                                        // if(pCLSC18DOutputRec->ROWCLSC18DO[i].ulIdPerson ==
                                                        // pInputMsg->ROWCCMN01UIG00.ulIdPerson)
                                                        // {
                                                        // ulIdStagePersonLink = 
                                                        // pCLSC18DOutputRec->ROWCLSC18DO[i].ulIdStagePerson;
                                                        // }   end if   
                                                        // }  end for 
                                                        // 
                                                        
                                                        // 
                                                        // SIR 22187
                                                        // Call the Stage Person Link Retrieval Dam - CAUDA0D
                                                        // Description - This dam rtrieves the historical primary linked to stage.
                                                        // If a historical primary is found the DAM returns the 
                                                        // Stage Person Link ID.  If no historical primary record is
                                                        // found no rows will be returned.
                                                        // 
                                                        
                                                        //  Allocate memory for DAM Input and Output 
                                                        // Structures
                                                        
                                                        pCAUDA0DInputRec = new CAUDA0DI();
                                                        
                                                        pCAUDA0DOutputRec = new CAUDA0DO();
                                                        pCAUDA0DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                                                        pCAUDA0DInputRec.setUlIdStage(ccfc05si.getUlIdStage());
                                                        rc = cauda0dQUERYdam(sqlca, pCAUDA0DInputRec, pCAUDA0DOutputRec);
                                                        
                                                        
                                                        //  Analyze return code
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                
                                                                ulIdStagePersonLink = pCAUDA0DOutputRec.getUlIdStagePerson();
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                
                                                                
                                                                // 
                                                                // Call the Stage Person Link AUD Dam - CCMND3D
                                                                // Description - If the required function is ADD: This DAM will perform a full
                                                                // row add in the STAGE_PERSON_LINK table.
                                                                // If the required function is UPDATE: This DAM will perform a
                                                                // full row update in the STAGE_PERSON_LINK table. The record
                                                                // updated is the one where the ID STAGE, ID PERSON, CD STAGE
                                                                // PERS TYPE, DT STAGE PERS LINK, and DT LAST UPDATE match the
                                                                // values passed in the DAM's Input Message.
                                                                // If the required function is DELETE: This DAM will delete
                                                                // all the rows in the STAGE_PERSON_LINK table where the value
                                                                // of ID STAGE equals the value passed in the Input Message and
                                                                // CD STAGE PERS ROLE is "PR" or "SE"
                                                                // 
                                                                //  Allocate memory for DAM Input and Output Structures
                                                                pCCMND3DInputRec = new CCMND3DI();
                                                                
                                                                pCCMND3DOutputRec = new CCMND3DO();
                                                                pCCMND3DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                                                                if (0 != ulIdStagePersonLink) {
                                                                    pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                                    pCCMND3DInputRec.setUlIdStagePerson(ulIdStagePersonLink);
                                                                }
                                                                
                                                                else {
                                                                    pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                                }
                                                                pCCMND3DInputRec.setSzCdStagePersRole(PRIMARY_ROLE);
                                                                pCCMND3DInputRec.setSzCdStagePersType(TYPE_STAFF);
                                                                pCCMND3DInputRec.setBIndStagePersEmpNew(EMP_IS_NEW);
                                                                pCCMND3DInputRec.setUlIdStage(ccfc05si.getUlIdStage());
                                                                pCCMND3DInputRec.setUlIdPerson(ccfc05si.getROWCCMN01UIG00().getUlIdPerson());
                                                                
                                                                //  Call DAM
                                                                rc = ARC_UTLGetDateAndTime(dtCurrentDate, 0);
                                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                pCCMND3DInputRec.setDtDtStagePersLink(dtCurrentDate);
                                                                
                                                                rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
                                                                
                                                                
                                                                //  Analyze return code
                                                                switch (rc) {
                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        
                                                                        
                                                                        // 
                                                                        // Call the Post Event Common Function - CCMN01U
                                                                        // Description - This dam will create a new event.
                                                                        // 
                                                                        //  Allocate memory for DAM Input and Output Structures
                                                                        pCCMN01UInputRec = new CCMN01UI();
                                                                        
                                                                        pCCMN01UOutputRec = new CCMN01UO();
                                                                        pCCMN01UInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                                                                        pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(ulIdPersonChild);
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(ccfc05si.getROWCCMN01UIG00().getSzCdTask());
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENT_TYPE_PRO);
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(EVENT_TXT_DESCRIPTION);
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(ccfc05si.getROWCCMN01UIG00().getUlIdPerson());
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccfc05si.getUlIdStage());
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(ccfc05si.getROWCCMN01UIG00().getUlIdEvent());
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(dtCurrentDate);
                                                                        rc = ARC_UTLGetDateAndTime(dtCurrentDate, 0);
                                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                        pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(dtCurrentDate);
                                                                        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                                                                        
                                                                        
                                                                        //  Analyze return code
                                                                        switch (rc) {
                                                                                
                                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                
                                                                                // 
                                                                                // Call the EVENT STATUS AUD Dam - CAUD64D
                                                                                // Description - This DAM will update the CD EVENT STATUS for a row in the
                                                                                // EVENT table given CD EVENT TYPE and the ID STAGE.  This
                                                                                // DAM will change all events for the stage with the CD EVENT
                                                                                // TYPE specified.  It will change the CD EVENT STATUS to the
                                                                                // status specified in the input. 
                                                                                // (re-open PAL Training/Serivces event)
                                                                                // 
                                                                                
                                                                                //  Allocate memory for DAM Input and Output Structures
                                                                                pCAUD64DInputRec = new CAUD64DI();
                                                                                
                                                                                pCAUD64DOutputRec = new CAUD64DO();
                                                                                pCAUD64DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                                                                                
                                                                                pCAUD64DInputRec.setSzCdEventType(EVENT_TYPE_RUT);
                                                                                pCAUD64DInputRec.setSzCdEventStatus(EVENT_STATUS_IN_PROCESS);
                                                                                pCAUD64DInputRec.setUlIdStage(ccfc05si.getUlIdStage());
                                                                                rc = caud64dAUDdam(sqlca, pCAUD64DInputRec, pCAUD64DOutputRec);
                                                                                
                                                                                
                                                                                //  Analyze return code
                                                                                switch (rc) {
                                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                                        
                                                                                    case NO_DATA_FOUND:
                                                                                        rc = WtcHelperConstants.SQL_SUCCESS;
                                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                                        pCAUD64DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                                                                                        pCAUD64DInputRec.setSzCdEventType(EVENT_TYPE_ILS);
                                                                                        pCAUD64DInputRec.setSzCdEventStatus(EVENT_STATUS_IN_PROCESS);
                                                                                        pCAUD64DInputRec.setUlIdStage(ccfc05si.getUlIdStage());
                                                                                        rc = caud64dAUDdam(sqlca, pCAUD64DInputRec, pCAUD64DOutputRec);
                                                                                        
                                                                                        
                                                                                        //  Analyze return code
                                                                                        switch (rc) {
                                                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                                break;
                                                                                                
                                                                                            case NO_DATA_FOUND:
                                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                                break;
                                                                                                
                                                                                            default :
                                                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                                                break;
                                                                                        }
                                                                                        break;
                                                                                        
                                                                                    default :
                                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                                        break;
                                                                                }
                                                                                break;
                                                                            case NO_DATA_FOUND:
                                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                                                                
                                                                                break;
                                                                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                                                
                                                                                break;
                                                                                
                                                                            default :
                                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                                break;
                                                                        }
                                                                        break;
                                                                        //  DWW: 04/24/2003
                                                                        // Added the following SQL_NOT_FOUND case.
                                                                        // SQL_NOT_FOUND just means that the resource does not have a phone number,
                                                                        // but this should not halt other data from coming back to the client
                                                                    case NO_DATA_FOUND:
                                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                        pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                                                                        break;
                                                                        
                                                                    default :
                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                        
                                                                        break;
                                                                }
                                                                break;
                                                                
                                                                // 
                                                                // End Call to Stage Person Link AUD Dam - CCMND3D
                                                                // 
                                                                
                                                                //  SIR 22187 removed DAM CLSC18D
                                                                // case SQL_NOT_FOUND:
                                                                // Set severity to ERROR
                                                                // pServiceStatus->severity = FND_SEVERITY_ERROR;
                                                                // pServiceStatus->explan_code = MSG_DATABASE_SAVE_FAIL;
                                                                // break;
                                                                // default:
                                                                // PROCESS_TUX_SQL_ERROR;         
                                                                // break;
                                                                // }  end switch 
                                                                // Free memory for DAM Input and Output structures
                                                                // free(pCLSC18DInputRec);
                                                                // free(pCLSC18DOutputRec);
                                                                // End Call to Stage Person Link Retrieval Dam - CLSC18D
                                                                // break;
                                                                
                                                                //  SIR 22187 - Added DAM CAUDA0D
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                break;
                                                        }
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                                                        break;
                                                        
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                        
                                                        break;
                                                }
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                break;
                                        }
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                
                                break;
                                
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        break;
                        
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        break;
                }
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            // 
            // Call the REC RETN RTRV Dam - CSES56D
            // Description - This DAM will retrieve a full row from RECORDS RETENTION 
            // table and will take as input ID_CASE
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES56DInputRec = new CSES56DI();
            
            pCSES56DOutputRec = new CSES56DO();
            pCSES56DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
            pCSES56DInputRec.setUlIdCase(ccfc05si.getUlIdCase());
            
            //  Call DAM
            rc = cses56dQUERYdam(sqlca, pCSES56DInputRec, pCSES56DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    // 
                    // Call the Primary Staff Simple Dam - CAUD75D
                    // Description - This DAM will add/update/delete a full row from the
                    // RECORDS RETENTION table.
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD75DInputRec = new CAUD75DI();
                    
                    pCAUD75DOutputRec = new CAUD75DO();
                    pCAUD75DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                    pCAUD75DInputRec.setTsLastUpdate(pCSES56DOutputRec.getTsLastUpdate());
                    pCAUD75DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                    pCAUD75DInputRec.setUlIdCase(ccfc05si.getUlIdCase());
                    // PWO 1037: svcshell.src: added setting rc = ARC_SUCCESS
                    rc = caud75dAUDdam(sqlca, pCAUD75DInputRec, pCAUD75DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  End SIR 12062, 01/10/97
                            // 
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    //  This employee does not have any other "IN" assignments
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            // 
            // Call the Case File mgmt Rtrv Dam - CSES57D
            // Description - This dam will retrieve a full row from the Case File 
            // Management table.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES57DInputRec = new CSES57DI();
            
            pCSES57DOutputRec = new CSES57DO();
            pCSES57DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
            pCSES57DInputRec.setUlIdCase(ccfc05si.getUlIdCase());
            rc = cses57dQUERYdam(sqlca, pCSES57DInputRec, pCSES57DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    // 
                    // Call the Case File Mgmt AUD Dam - CAUD76D
                    // Description - This DAM add/update/delete a full row from Case File 
                    // Management.
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD76DInputRec = new CAUD76DI();
                    
                    pCAUD76DOutputRec = new CAUD76DO();
                    pCAUD76DInputRec.setArchInputStruct(ccfc05si.getArchInputStruct());
                    pCAUD76DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCAUD76DInputRec.setSzNmCaseFileOffice(pCSES57DOutputRec.getSzNmCaseFileOffice());
                    pCAUD76DInputRec.setSzAddrCaseFileStLn1(pCSES57DOutputRec.getSzAddrCaseFileStLn1());
                    
                    pCAUD76DInputRec.setSzAddrCaseFileStLn2(pCSES57DOutputRec.getSzAddrCaseFileStLn2());
                    pCAUD76DInputRec.setSzNmCaseFileOffice(pCSES57DOutputRec.getSzNmCaseFileOffice());
                    pCAUD76DInputRec.setSztxtCaseFileLocateInfo(pCSES57DOutputRec.getSztxtCaseFileLocateInfo());
                    pCAUD76DInputRec.setTsLastUpdate(pCSES57DOutputRec.getTsLastUpdate());
                    pCAUD76DInputRec.setUlIdCase(pCSES57DOutputRec.getUlIdCase());
                    pCAUD76DInputRec.setSzCdCaseFileOfficeType(pCSES57DOutputRec.getSzCdCaseFileOfficeType());
                    pCAUD76DInputRec.setDtDtCaseFileArchCompl(pCSES57DOutputRec.getDtDtCaseFileArchCompl());
                    pCAUD76DInputRec.setDtDtCaseFileArchElig(pCSES57DOutputRec.getDtDtCaseFileArchElig());
                    pCAUD76DInputRec.setUlIdOffice(pCSES57DOutputRec.getUlIdOffice());
                    pCAUD76DInputRec.setUlIdUnit(ulIdUnit1);
                    rc = caud76dAUDdam(sqlca, pCAUD76DInputRec, pCAUD76DOutputRec);
                    
                    
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
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc05si.getArchInputStruct() , ccfc05so.getArchOutputStruct());
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
        return ccfc05so;
    }

    static int CallCSES94D(CCFC05SI pInputMsg7, CCFC05SO * pOutputMsg10, CSES94DI pCSES94DInputRec, CSES94DO pCSES94DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        pCSES94DInputRec.setSzCdStage(PREP_ADULT);
        pCSES94DInputRec.setSzCdStagePersRole(PRIMARY_CHILD_ROLE);
        
        pCSES94DInputRec.setArchInputStruct(pInputMsg7.getArchInputStruct());
        
        pCSES94DInputRec.getArchInputStruct().setCReqFuncCd(OPEN);
        rc = cses94dQUERYdam(sqlca, pCSES94DInputRec, pCSES94DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (pCSES94DOutputRec.getUlSysNbrUlongKey() > 0) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_OPEN_PAL_STAGE_EXISTS;
                    rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Get the current date and store it in dtCurrDate
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
