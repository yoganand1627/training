package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT65DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT66DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT63DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC52DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.service.person.Cinv05s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT65DI;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT66DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT63DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC52DI;
/**************************************************************************
** 
** Module File:   cint40s.src
**
** Service Name:  CINT40S - APS INTAKE REPROT
**
** Description:   This service produces the data required for the APS 
**                Intake report.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  6/27/1995
** 
** Programmer:    Brenda Wallace
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   04 Nov 1996 18:45:46  $
**                      $Modtime:   04 Nov 1996 18:15:26  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/04/96  FOISTHJ   SIR #2403 - Changed Dam CLSC52D's Input Structure 
**                                  and in accordance its inputs in the 
**                                  Form's service code
**
**  11/04/96  VANDERM   SIR 12120 - All memory for the DAM output records
**                      will be allocated and initialized at the beginning
**                      of the service and freed at the end of the service.
**                      This prevents the freeing of unallocated memory
**                      resulting in server kills.
**
**  04/10/03  Srini D   Modified the error handling to set rc to explan_code 
** 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint40s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    
    public static final int MAX_DAMS = 99;
    
    public static final String APPROVED_CODE = "APP";
    public static final String APPROVED = "APRV";
    CINT40SO CINT40S(CINT40SI cint40si) {
        CINT40SO cint40so = new CINT40SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int iNumDAMs = 0;/* Total number of DAMs called */
        void[MAX_DAMS] pDAMPtrs = null;/* Array of pointers to DAM output */
        Pint uFormDataSize = new Pint();/* Total size of service output buffer
        after ARC_FRMProduceFormData */
        int ulIdEvent12 = 0;
        
        /*
        ** Declare a DAM output pointer for each DAM output.  Repeat the 
        ** following statement for each DAM to be called.
        */
        
        CINT65DO pCINT65DOutputRec = null;
        CINT66DO pCINT66DOutputRec1 = null;
        CINT66DO pCINT66DOutputRec2 = null;
        CINT66DO pCINT66DOutputRec3 = null;
        CINT66DO pCINT66DOutputRec4 = null;
        CINT66DO pCINT66DOutputRec5 = null;
        CINT62DO pCINT62DOutputRec = null;
        CINT63DO pCINT63DOutputRec = null;
        CINT19DO pCINT19DOutputRec = null;
        CINT15DO pCINT15DOutputRec = null;
        CINT64DO pCINT64DOutputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;/*SIR#2142*/
        CLSC52DO pCLSC52DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cint40si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Check buffer size 
        */
        
        /*
        ** Process error message and return to client 
        */
        
        /*
        ** Initialize output message and length 
        */
        
        /*
        ** Initialize service status fields            
        */
        
        /*********************************************************************
        *  Allocate memory for DAM output structures
        **********************************************************************/
        /*
        **
        ** Insert any business logic necessary for determining which DAMs to 
        ** call, etc. Contrary to a generic service function, a form service
        ** requires that before calling a DAM, memory for the DAM output record
        ** must be allocated and the pointer to the memory passed to the CallDAM
        ** function. This is required so that the output from all DAMs called can
        ** be processed simultaneously by ARC_FRMProduceFormData.
        ** An example call to the function you defined which 
        ** will perform the logic necessary to call a DAM follows.  Repeat 
        ** the following 2 statements (malloc and CallDAM) for each DAM that 
        ** will be executed.  If an unexpected technical error is returned, 
        ** log the error with PROCESS_TUX_RC_ERROR. 
        ** Remember, a call to PROCESS_TUX_RC_ERROR will result in a fatal severity
        ** returned to the client and the server will be shutdown.
        **
        */
        
        /* SIR 12120
        ** All memory for the DAM output records will be allocated and initialized
        ** at the beginning of the service and freed at the end of the service.
        ** This prevents the freeing of unallocated memory resulting in server
        ** kills.
        */
        
        pCINT65DOutputRec = new CINT65DO();
        
        pCINT66DOutputRec1 = new CINT66DO();
        
        pCINT66DOutputRec2 = new CINT66DO();
        
        pCINT66DOutputRec3 = new CINT66DO();
        
        pCINT66DOutputRec4 = new CINT66DO();
        
        pCINT66DOutputRec5 = new CINT66DO();
        
        pCINT62DOutputRec = new CINT62DO();
        
        pCINT63DOutputRec = new CINT63DO();
        
        pCINT19DOutputRec = new CINT19DO();
        
        pCINT15DOutputRec = new CINT15DO();
        
        pCINT64DOutputRec = new CINT64DO();
        
        pCCMN45DOutputRec = new CCMN45DO();
        
        pCLSC52DOutputRec = new CLSC52DO();
        rc = CallCINT65D(cint40si, cint40so, pCINT65DOutputRec, pServiceStatus);
        /*
        ** SIR 13618 - Determine howmany request for review contacts
        ** exist before calling csys07d to up/add/delete contacts
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            ulIdEvent12 = pCINT65DOutputRec.getUlIdEvent();
            rc = CallCINT66D(cint40si, cint40so, pCINT66DOutputRec1, VICTIM_TYPE, pServiceStatus);
        }
        
        
        /*
        ** Handle special Contact Types. These types may have System Generated
        ** To-Dos and may require additonal System Generated To-Dos.
        **
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = CallCINT66D(cint40si, cint40so, pCINT66DOutputRec2, PERPETRATOR_TYPE, pServiceStatus);
        }
        
        /*
        ** At this point, we either have an ID EVENT and the function
        ** is UPDATE, or we have no ID EVENT and the function is ADD.
        **
        ** In addition, we may have an ID EVENT and a function of DELETE.
        */
        
        /*
        ** If the client was given an ID EVENT that wasn't NEW, we are
        ** Updating an existing Event. If the Event status is PENDing
        ** then we will Invalidate the Approval associated with the
        ** Pending Contact.
        **
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = CallCINT66D(cint40si, cint40so, pCINT66DOutputRec3, OTHER_PRN_TYPE, pServiceStatus);
        }
        /*
        ** IMPACT BEGIN - Don't demote events when in "Approver mode"
        **
        **  Original code:
        **  if (0 == strcmp(pInputMsg->ROWCCMN01UIG00.szCdEventStatus,
        **                  SVC_CD_EVENT_STATUS_PENDING))
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = CallCINT66D(cint40si, cint40so, pCINT66DOutputRec4, REPORTER_TYPE, pServiceStatus);
        }
        
        /*
        ** If we executed any code which set the ulInvalidateIdEvent, then
        ** we need to call InvalidateAprvl().
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = CallCINT66D(cint40si, cint40so, pCINT66DOutputRec5, COLLATERAL_TYPE, pServiceStatus);
        }
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            
            //  Call DAM
            rc = CallCINT62D(cint40si, cint40so, pCINT62DOutputRec, pServiceStatus);
        }
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = CallCINT63D(cint40si, cint40so, pCINT63DOutputRec, pServiceStatus);
        }
        
        
        /*
        ** Two additional tables have to be DELETEd from if the user
        ** has requested a DELETE. TODO and APPROVAL_EVENT_LINK. Below
        ** we call two timestamp blind DAMS to DELETE from these tables
        ** using ID EVENT.
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = CallCINT19D(cint40si, cint40so, pCINT19DOutputRec, pServiceStatus);
        }
        /*
        ** SUCCESS and NOT_FOUND are O.K. Everything else is Fatal.
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = CallCINT15D(cint40si, cint40so, pCINT15DOutputRec, pServiceStatus);
        }
        /*
        ** SUCCESS and NOT_FOUND are O.K. Everything else is Fatal.
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = CallCINT64D(cint40si, cint40so, pCINT64DOutputRec, pServiceStatus);
        }
        
        /************************************************************************
        **   Begin SIR 1316: Create ToDo and Contact Shell for first Face to Face
        **   Contact that is created for a stage.
        ************************************************************************/
        
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            rc = Cinv05s.CallCCMN45D(cint40si, cint40so, ulIdEvent12, pCCMN45DOutputRec, pServiceStatus);
        }
        /************************************************************************
        **    SIR 1482: Create ToDo and Contact Shell for first Face to
        **    Face Contact only if the Stage Classification is APS Community.
        ************************************************************************/
        /*
        ** SIR 2986
        ** We don't want to create the Todo and Contact shell for the first
        ** face to face if the stage is AOC.  This will be created when
        ** the Guardianship is filed and letters received.
        */
        //SIR 17882 Added the strcmp for ADMIN_REVIEW.
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            
            // 
            // End SIR 1316: Create ToDo and Contact Shell for first Face to Face
            // Contact that is created for a stage.
            // 
            
            // 
            // SIR 5185:  If the ReqFuncCd is DELETE, we first need to call
            // CSVC32D to delete all rows from the Event_person_link table
            // before trying to delete from the Event table.
            // 
            if (!(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus().compareTo(APPROVED) != 0)) {
                
                // Call DAM
                rc = CallCLSC52D(cint40si, cint40so, ulIdEvent12, pCLSC52DOutputRec, APPROVED_CODE, pServiceStatus);
            }
        }
        
        /*
        ** Deal with User Generated To-Dos ... SIR #1067
        **
        ** If the client requests a DELETE, and it's a user gen'd TODO,
        ** then we don't need to call the CONTACT AUD; the record does not
        ** exist. If the client requests an UPDATE, we need to save the
        ** function code and ADD the record.
        **
        ** Note that ulPageSizeNbr is being used as an indicator for User
        ** Generated To-Dos.
        */
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            iNumDAMs = 0;
            
            // Repeat the following 2 statements for each DAM called.  
            // (DO NOT leave out the 2nd iNumDAMs increment when populating 
            // pDAMPtrs with your last DAM output pointer.) 
            // Remember that the order in which the DAM pointers
            // is added to the array must exactly match the sequence number specified
            // for each DAM when the form was registered in the database.
            
            pDAMPtrs[iNumDAMs] = pCINT15DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT19DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT62DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT63DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT64DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT65DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT66DOutputRec1;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT66DOutputRec2;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT66DOutputRec3;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT66DOutputRec4;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCINT66DOutputRec5;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCLSC52DOutputRec;
            iNumDAMs++;
            uFormDataSize.value = 0;
            rc = ARC_FRMProduceFormData(APS_INTAKE_REPORT, iNumDAMs, (char * * ) & pDAMPtrs, (char) cint40so, sizeof () , uFormDataSize);
            if (rc != WtcHelperConstants.ARC_SUCCESS) {
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = rc;
                rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint40si.getArchInputStruct() , cint40so.getArchOutputStruct());
        rc = pServiceStatus.explan_code;
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  SIR #1067. Restore the saved req function code.
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Start performance timer for service
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint40so;
    }

    static int CallCINT65D(CINT40SI pInputMsg483, CINT40SO * pOutputMsg441, CINT65DO pCINT65DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT65DI pCINT65DInputRec = new CINT65DI();
        pCINT65DInputRec.setArchInputStruct(pInputMsg483.getArchInputStruct());
        pCINT65DInputRec.setUlIdStage(pInputMsg483.getUlIdStage());
        rc = cint65dQUERYdam(sqlca, pCINT65DInputRec, pCINT65DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
                // person may be in system but not in an active case
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT66D(CINT40SI pInputMsg484, CINT40SO * pOutputMsg442, CINT66DO pCINT66DOutputRec, int iQueryType, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i269 = 0;
        
        /*
        ** Declare local variables
        */
        CINT66DI pCINT66DInputRec = new CINT66DI();
        pCINT66DInputRec.setUlIdStage(pInputMsg484.getUlIdStage());
        pCINT66DInputRec.setArchInputStruct(pInputMsg484.getArchInputStruct());
        pCINT66DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINT66DInputRec.getArchInputStruct().setUlPageSizeNbr(CINT66DO._CINT66DO__ROWCINT66DO_SIZE);
        rc = cint66dQUERYdam(sqlca, pCINT66DInputRec, pCINT66DOutputRec, iQueryType);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT62D(CINT40SI pInputMsg485, CINT40SO * pOutputMsg443, CINT62DO pCINT62DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i270 = 0;
        
        /*
        ** Declare local variables
        */
        CINT62DI pCINT62DInputRec = new CINT62DI();
        pCINT62DInputRec.setUlIdStage(pInputMsg485.getUlIdStage());
        pCINT62DInputRec.setArchInputStruct(pInputMsg485.getArchInputStruct());
        pCINT62DInputRec.getArchInputStruct().setUsPageNbr(1);
        
        pCINT62DInputRec.getArchInputStruct().setUlPageSizeNbr(CINT62DO._CINT62DO__ROWCINT62DO_SIZE);
        rc = cint62dQUERYdam(sqlca, pCINT62DInputRec, pCINT62DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT63D(CINT40SI pInputMsg486, CINT40SO * pOutputMsg444, CINT63DO pCINT63DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i271 = 0;
        
        /*
        ** Declare local variables
        */
        CINT63DI pCINT63DInputRec = new CINT63DI();
        pCINT63DInputRec.setUlIdStage(pInputMsg486.getUlIdStage());
        pCINT63DInputRec.setArchInputStruct(pInputMsg486.getArchInputStruct());
        pCINT63DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINT63DInputRec.getArchInputStruct().setUlPageSizeNbr(CINT63DO._CINT63DO__ROWCINT63DO_SIZE);
        rc = cint63dQUERYdam(sqlca, pCINT63DInputRec, pCINT63DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                //  Call CSES80D:
                // SELECT * FROM    CONTRACT_PERIOD CP
                // WHERE   CP.ID_CONTRACT = hi_con AND CP.DT_CNPER_CLOSURE >= SYSDATE;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCINT19D(CINT40SI pInputMsg487, CINT40SO * pOutputMsg445, CINT19DO pCINT19DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i272 = 0;
        
        /*
        ** Declare local variables
        */
        CINT19DI pCINT19DInputRec = new CINT19DI();
        pCINT19DInputRec.setUlIdStage(pInputMsg487.getUlIdStage());
        pCINT19DInputRec.setArchInputStruct(pInputMsg487.getArchInputStruct());
        pCINT19DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINT19DInputRec.getArchInputStruct().setUlPageSizeNbr(CINT19DO._CINT19DO__ROWCINT19DO_SIZE);
        
        /*
        ** Call DAM
        */
        rc = cint19dQUERYdam(sqlca, pCINT19DInputRec, pCINT19DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCINT15D(CINT40SI pInputMsg488, CINT40SO * pOutputMsg446, CINT15DO pCINT15DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i273 = 0;
        
        /*
        ** Declare local variables
        */
        CINT15DI pCINT15DInputRec = new CINT15DI();
        pCINT15DInputRec.setUlIdStage(pInputMsg488.getUlIdStage());
        pCINT15DInputRec.setArchInputStruct(pInputMsg488.getArchInputStruct());
        pCINT15DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINT15DInputRec.getArchInputStruct().setUlPageSizeNbr(CINT15DO._CINT15DO__ROWCINT15DO_SIZE);
        /*
        ** Call Retrieve DAM
        */
        rc = cint15dQUERYdam(sqlca, pCINT15DInputRec, pCINT15DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT64D(CINT40SI pInputMsg489, CINT40SO * pOutputMsg447, CINT64DO pCINT64DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i274 = 0;
        
        /*
        ** Declare local variables
        */
        CINT64DI pCINT64DInputRec = new CINT64DI();
        pCINT64DInputRec.setUlIdStage(pInputMsg489.getUlIdStage());
        
        pCINT64DInputRec.setArchInputStruct(pInputMsg489.getArchInputStruct());
        pCINT64DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINT64DInputRec.getArchInputStruct().setUlPageSizeNbr(CINT64DO._CINT64DO__ROWCINT64DO_SIZE);
        
        
        /*
        ** Call CSES68D
        */
        rc = cint64dQUERYdam(sqlca, pCINT64DInputRec, pCINT64DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCCMN45D(CINT40SI pInputMsg490, CINT40SO * pOutputMsg448, int ulIdEvent13, CCMN45DO pCCMN45DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i275 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = new CCMN45DI();
        pCCMN45DInputRec.setUlIdEvent(ulIdEvent13);
        pCCMN45DInputRec.setArchInputStruct(pInputMsg490.getArchInputStruct());
        pCCMN45DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN45DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCLSC52D(CINT40SI pInputMsg491, CINT40SO * pOutputMsg449, int ulIdEvent14, CLSC52DO pCLSC52DOutputRec, String szCdEventType1, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        int rc = 0;
        int i276 = 0;
        
        /*
        ** Declare local variables
        */
        CLSC52DI pCLSC52DInputRec = new CLSC52DI();
        pCLSC52DInputRec.setUlIdEvent(ulIdEvent14);
        pCLSC52DInputRec.setArchInputStruct(pInputMsg491.getArchInputStruct());
        pCLSC52DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSC52DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC52DO._CLSC52DO__ROWCLSC52DO_SIZE);
        rc = clsc52dQUERYdam(sqlca, pCLSC52DInputRec, pCLSC52DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
