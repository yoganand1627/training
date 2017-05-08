package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES42DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES42DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   ccfc03s.src
**
** Service Name:  CCFC03S
**
** Description:   This service will retrieve the Event Status from the EVENT
**                table given the specified ID EVENT.  A row must be 
**                retrieved from the PAL and STAGE tables as well.  It will 
**                retrieve all the columns from the PAL table given the 
**                specified ID STAGE.  If no row exists then an indicator will
**                be set telling the winodw that an ILS Assessment recored has
**                not been completed.  It will also retrieve all the columns 
**                from the STAGE table given ID STAGE.  There will only be 
**                one event retrieved from the CCMN45D DAM, one record 
**                retrieved from the PLA table and one stage retrieved from 
**                the CINT21D DAM.  Additionally it will check if the person
**                entering the window is the Primary Worker and will set an 
**                indicator accordingly.  The service will also check to see
**                if the yout is over 18 years of age.  If he is then a flag
**                will be set and sent back to the window.  A check will also
**                be done to see if the primary child has been discharged from
**                subcare.  If they have a flag will be set and sent back to
**                the window.  Finally the service will check to see if the 
**                worker is a PAL Coordinator.  It will set a flag and sent 
**                it back to the window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/07/95 
** 
** Programmer:    Timothy R. Overend
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   30 Sep 1996 15:50:50  $
**                      $Modtime:   30 Sep 1996 15:27:26  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/13/96  TRO       SIR #20086 - Added three dams, ccmn87d, cses24d, 
**                      and clss24d tocheck to see if there are any open 
**                      service authorizations for the id_stage that is 
**                      passed in.  If there are, set the flag to let the 
**                      window know notto allow the user to save and close 
**                      the PAL stage.
**  08/30/96    KRD     A loop counter was being inadvertantly reset due to
**                      an interior loop using the same loop counter variable.
**
**  09/12/96  vanderm   SIR 22196 - Allowed to close PAL stage with pending
**                      approval of Service Auth in it. Conditional added to
**                      check if the PAL Service Authorization is
**                      pending.  If it is the PAL stage is not allowed to
**                      close.
**  01/29/03   Srini   Added rc = FND_SUCCESS for the SQL_NOT_FOUND case but 
**                                              returning success values.
**
**  04/30/03   Srini   SIR 17091: Added the error handling to take care of full 
**					   table scans for ccmn87dQUERYdam.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc03s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PAL_UNIT_SPECIALIZATION = "PAL";
    public static final String PRIMARY_CHILD_ROLE = "PC";
    public static final char MERGED_STATUS = 'M';
    public static final int PAL_RETRIEVAL = 0;
    public static final int EVENT_RETRIEVAL = 1;
    public static final int PAGE_NUM_ONE = 1;
    public static final int AGE_EIGHTEEN = 9466560;
    public static final String SERVICE_AUTH_TASK_CODE = "3520";
    public static final String SERVICE_AUTH_EVENT_TYPE_CODE = "AUT";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_APPROVED = "APRV";
    public static final String EVENT_STATUS_PEND = "PEND";
    CCFC03SO CCFC03S(CCFC03SI ccfc03si) {
        CCFC03SO ccfc03so = new CCFC03SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i13 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        /*
        ** 0830 KRD - loop counter needed
        */
        int j = 0;
        int ulIdPerson2 = 0;
        int Age = 0;
        String tmTmSystemTime = new String();
        
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;/* Rtrv person given role of PC */
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        CCMNG2DI pCCMNG2DInputRec = null;
        CCMNG2DO pCCMNG2DOutputRec = null;
        CSES42DI pCSES42DInputRec = null;
        CSES42DO pCSES42DOutputRec = null;
        CSES45DI pCSES45DInputRec = null;
        CSES45DO pCSES45DOutputRec = null;
        CSEC51DI pCSEC51DInputRec = null;
        CSEC51DO pCSEC51DOutputRec = null;
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        CSES24DI pCSES24DInputRec = null;/* SIR 20086 */
        CSES24DO pCSES24DOutputRec = null;/* SIR 20086 */
        CLSS24DI pCLSS24DInputRec = null;/* SIR 20086 */
        CLSS24DO pCLSS24DOutputRec = null;/* SIR 20086 */
        CCMN87DI pCCMN87DInputRec = null;/* SIR 20086 */
        CCMN87DO pCCMN87DOutputRec = null;/* SIR 20086 */
        rc = ARC_PRFServiceStartTime_TUX(ccfc03si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime((FndInt3date) & ccfc03so.getDtWCDDtSystemDate() , (char) & tmTmSystemTime);
        /*
        ** Increment edit warning counter.
        */
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /**************************************************************************
        ** Call the PAL Retrival Dam - CSES42D
        **
        ** Description - This dam will do a full row retrieval form the PAL table.
        **               It will take as input ID_STAGE and return only one row.
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES42DInputRec = new CSES42DI();
        
        pCSES42DOutputRec = new CSES42DO();
        pCSES42DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
        
        pCSES42DInputRec.setUlIdStage(ccfc03si.getUlIdStage());
        
        
        /*
        ** Call CCMN45D
        */
        rc = cses42dQUERYdam(sqlca, pCSES42DInputRec, pCSES42DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                if (NO_DATA_FOUND == rc) {
                    ccfc03so.setCSysIndPalIlsAssmt(false);
                }
                else {
                    ccfc03so.setCSysIndPalIlsAssmt(true);
                }
                ccfc03so.setSzCdPalCloseLivArr(pCSES42DOutputRec.getSzCdPalCloseLivArr());
                ccfc03so.getTsLastUpdate_ARRAY().setTsLastUpdate(PAL_RETRIEVAL, pCSES42DOutputRec.getTsLastUpdate());
                
                rc = WtcHelperConstants.SQL_SUCCESS;
                
                // 
                // Call the Primary Staff Simple Dam - CCMNG2D
                // Description - This dam will receive ID_STAGE from the service and
                // return the associated record from STAGE PERSON LINK
                // table where the staff person's role is primary (PR).
                // This dam will only return one row.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCCMNG2DInputRec = new CCMNG2DI();
                
                pCCMNG2DOutputRec = new CCMNG2DO();
                pCCMNG2DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                pCCMNG2DInputRec.setUlIdStage(ccfc03si.getUlIdStage());
                rc = ccmng2dQUERYdam(sqlca, pCCMNG2DInputRec, pCCMNG2DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if (pCCMNG2DOutputRec.getUlIdPerson() == ccfc03si.getUlIdPerson()) {
                            ccfc03so.setCSysIndPrimaryWorker(true);
                        }
                        else {
                            ccfc03so.setCSysIndPrimaryWorker(false);
                        }
                        
                        
                        //  Call CCMN87D
                        rc = WtcHelperConstants.SQL_SUCCESS;
                        
                        
                        // 
                        // Call the Check for Unit Approval Dam - CSES45D
                        // Description - This DAM will retrieve a full row from the UNIT table
                        // and will take as input ID_PERSON and CD UNIT
                        // SPECIALIZATION.  It will return one row.
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES45DInputRec = new CSES45DI();
                        
                        pCSES45DOutputRec = new CSES45DO();
                        pCSES45DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                        pCSES45DInputRec.setSzCdUnitSpecialization(PAL_UNIT_SPECIALIZATION);
                        pCSES45DInputRec.setUlIdPerson(ccfc03si.getUlIdPerson());
                        rc = cses45dQUERYdam(sqlca, pCSES45DInputRec, pCSES45DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                                    ccfc03so.setCSysIndPalLeadCoord(true);
                                }
                                else {
                                    
                                    
                                    ccfc03so.setCSysIndPalLeadCoord(false);
                                }
                                rc = WtcHelperConstants.SQL_SUCCESS;
                                
                                // 
                                // Call the Stage Person Link Dam - CINV51D
                                // Description - This DAM will retrieve either the primary worker
                                // or the historically primary worker and name stage
                                // based upon the ID_STAGE that is passes in.
                                // Retrieves one row.
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCINV51DInputRec = new CINV51DI();
                                
                                pCINV51DOutputRec = new CINV51DO();
                                pCINV51DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                                pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD_ROLE);
                                pCINV51DInputRec.setUlIdStage(ccfc03si.getUlIdStage());
                                
                                rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        ulIdPerson2 = pCINV51DOutputRec.getUlIdTodoPersAssigned();
                                        
                                        
                                        
                                        // 
                                        // Call the Stage Person Link Dam - CCMN44D
                                        // Description - This DAM will return a single row from the 
                                        // person table based upon the ID_PERSON passed
                                        // in.
                                        // 
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCCMN44DInputRec = new CCMN44DI();
                                        
                                        pCCMN44DOutputRec = new CCMN44DO();
                                        pCCMN44DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                                        pCCMN44DInputRec.setUlIdPerson(ulIdPerson2);
                                        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                                                    
                                                    Age = ARC_UTLCompareDateAndTime((FndInt3date) & ccfc03so.getDtWCDDtSystemDate() , 0, (FndInt3date) & pCCMN44DOutputRec.getDtDtPersonBirth() , 0);
                                                    
                                                    if (Age >= AGE_EIGHTEEN) {
                                                        ccfc03so.setCSysIndPalOverEighteen(true);
                                                    }
                                                    else {
                                                        ccfc03so.setCSysIndPalOverEighteen(false);
                                                    }
                                                    
                                                    if (MERGED_STATUS == pCCMN44DOutputRec.getCdPersonStatus()[0]) {
                                                        ccfc03so.setCSysIndPalStageMerged(true);
                                                    }
                                                    else {
                                                        ccfc03so.setCSysIndPalStageMerged(false);
                                                    }
                                                }
                                                else {
                                                    ccfc03so.setCSysIndPalOverEighteen(false);
                                                    ccfc03so.setCSysIndPalStageMerged(false);
                                                }
                                                
                                                
                                                //  Call CSES24D
                                                rc = WtcHelperConstants.SQL_SUCCESS;
                                                
                                                // 
                                                // Call the Most Recent Acutal Discharge Dam - CSEC51D
                                                // Description - This DAM will return the most recent row
                                                // off of the placement table for the id
                                                // person passed in.  Also cd_plcmt_act_
                                                // planned = A and cd_plcmt_removal_rsn must
                                                // exist in cdischrg codes table.
                                                // 
                                                
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCSEC51DInputRec = new CSEC51DI();
                                                
                                                pCSEC51DOutputRec = new CSEC51DO();
                                                pCSEC51DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                                                pCSEC51DInputRec.setUlIdPlcmtChild(ulIdPerson2);
                                                
                                                rc = csec51dQUERYdam(sqlca, pCSEC51DInputRec, pCSEC51DOutputRec);
                                                
                                                //  Analyze error code
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        
                                                        if (WtcHelperConstants.SQL_SUCCESS == rc) {
                                                            ccfc03so.setCSysIndDischargeDate(true);
                                                        }
                                                        else {
                                                            ccfc03so.setCSysIndDischargeDate(false);
                                                        }
                                                        rc = WtcHelperConstants.SQL_SUCCESS;
                                                        
                                                        if (0 != ccfc03si.getUlIdEvent()) {
                                                            // 
                                                            // Call the Get Event Simple Dam - CCMN45D
                                                            // Description - This DAM will return one row from the event
                                                            // table based upon the id_event passed into it.
                                                            // 
                                                            
                                                            //  Allocate memory for DAM Input and Output Structures
                                                            pCCMN45DInputRec = new CCMN45DI();
                                                            
                                                            pCCMN45DOutputRec = new CCMN45DO();
                                                            pCCMN45DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                                                            pCCMN45DInputRec.setUlIdEvent(ccfc03si.getUlIdEvent());
                                                            
                                                            
                                                            //  Call CSES23D
                                                            rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                                                            
                                                            //  Analyze return code
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    ccfc03so.setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                                                                    ccfc03so.getTsLastUpdate_ARRAY().setTsLastUpdate(EVENT_RETRIEVAL, pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                                                                    ccfc03so.setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                                                                    break;
                                                                case NO_DATA_FOUND:
                                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                    pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                                                                    break;
                                                                    
                                                                default :
                                                                    
                                                                    //## BEGIN TUX/XML: Declare XML variables
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                    break;
                                                            }
                                                        }
                                                        if (WtcHelperConstants.SQL_SUCCESS == rc) {
                                                            // 
                                                            // Call the Stage Retrieval Dam - CINT21D
                                                            // Description - This DAM will return one row from the stage
                                                            // table based upon the id_stage passed into it.
                                                            // 
                                                            
                                                            //  Allocate memory for DAM Input and Output Structures
                                                            pCINT21DInputRec = new CINT21DI();
                                                            
                                                            pCINT21DOutputRec = new CINT21DO();
                                                            pCINT21DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                                                            pCINT21DInputRec.setUlIdStage(ccfc03si.getUlIdStage());
                                                            
                                                            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
                                                            
                                                            //  Analyze error code
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    ccfc03so.setSzCdStageReasonClosed(pCINT21DOutputRec.getSzCdStageReasonClosed());
                                                                    ccfc03so.setDtDtStageClose(pCINT21DOutputRec.getDtDtStageClose());
                                                                    break;
                                                                case NO_DATA_FOUND:
                                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                    pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                                                                    break;
                                                                    
                                                                default :
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                    break;
                                                            }
                                                        }
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
                                        pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
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
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        /**************************************************************************
        ** End Call to PAL Retrival Dam - CSES42D
        **************************************************************************/
        
        
        /*
        ** Start of SIR #20086 
        */
        
        /**************************************************************************
        ** Call the Stage Retrieval Dam - CCMN87D
        **
        ** Description - Dynamically builds Select statement and retrieves all
        **               events that satisfy the criteria. Pass in an id stage,
        **               the event type, and the task code to retrieve all possible
        **               service auth event for the given stage.
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures for all three dams
        ** since the two middle dams are within loop the ccmn87d output loop.
        */
        pCCMN87DInputRec = new CCMN87DI();
        pCCMN87DOutputRec = new CCMN87DO();
        pCSES24DInputRec = new CSES24DI();
        pCSES24DOutputRec = new CSES24DO();
        pCLSS24DInputRec = new CLSS24DI();
        pCLSS24DOutputRec = new CLSS24DO();
        
        if ((pCCMN87DInputRec == null) || (pCCMN87DOutputRec == null) || (pCSES24DInputRec == null) || (pCSES24DOutputRec == null) || (pCLSS24DInputRec == null) || (pCLSS24DOutputRec == null)) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCCMN87DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
        pCCMN87DInputRec.setSzCdTask(SERVICE_AUTH_TASK_CODE);
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SERVICE_AUTH_EVENT_TYPE_CODE);
        pCCMN87DInputRec.setUlIdStage(ccfc03si.getUlIdStage());
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
        
        
        
        /*
        ** Call DAM to get list of Forward Person ID's.
        ** If no rows returned, the person has not been merged.
        */
        
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccfc03so.setCSysIndPalSvcAuth(false);
                
                //  Set error/warning messages based upon what is returned
                // fromthe dam.
                for (i13 = 0;((i13 < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty()) && (!ccfc03so.getCSysIndPalSvcAuth()));i13++) {
                    
                    if ((pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i13).getSzCdEventStatus().equals(EVENT_STATUS_COMPLETE)) || (pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i13).getSzCdEventStatus().equals(EVENT_STATUS_APPROVED)) || (pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i13).getSzCdEventStatus().equals(EVENT_STATUS_PEND))) {
                        pCSES24DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                        pCSES24DInputRec.setUlIdSvcAuthEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i13).getUlIdEvent());
                        
                        rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                pCLSS24DInputRec.setArchInputStruct(ccfc03si.getArchInputStruct());
                                pCLSS24DInputRec.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                                pCLSS24DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                                pCLSS24DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS24DO._CLSS24DO__ROWCLSS24DO_SIZE);
                                rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Set error/warning messages based upon what is returned
                                        // fromthe dam.
                                        // 0830 KRD - loop counter renamed from i to j
                                        for (j = 0;j < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                            
                                            
                                            //  Call CSES86D to see if an IdPersonForward is linked to the
                                            // current IdStage.  If so, replace the CSES23D IdPrimaryPerson.
                                            rc = ARC_UTLCompareDateAndTime((FndInt3date) & pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getDtDtSvcAuthDtlTerm() , (char) & pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getTmScrTmGeneric4() , (FndInt3date) & ccfc03so.getDtWCDDtSystemDate() , (char) & tmTmSystemTime);
                                            
                                            if (rc > 0) {
                                                ccfc03so.setCSysIndPalSvcAuth(true);
                                                
                                                j = pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();
                                            }
                                            
                                            rc = WtcHelperConstants.SQL_SUCCESS;
                                        }
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        rc = SUCCESS;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                //  Call CLSS24D
                                rc = SUCCESS;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                rc = WtcHelperConstants.SQL_SUCCESS;
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc03si.getArchInputStruct() , ccfc03so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //## END TUX/XML: Turn the XML buffer into an input message struct 
            
            
            
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
        return ccfc03so;
    }

}
