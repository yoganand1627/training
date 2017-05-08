package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDF0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDF0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDF1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDF1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT03DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT03DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB2DO;
/**************************************************************************
**
** Module File:   cint14s.src
**
** Service Name:  CINT14S - CALL DECISION AUD
**
** Description:   This service makes database changes for the information
**                held on the Call Decision window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/18/94
**
** Programmer:    Mark Dunnagan, Andersen Consulting
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/22/95  ELLIOTSL  Logic has been added to update the CASE table if
**                      only if a case has been created (if ID CASE is not
**                      NULL).  The CASE table is updated by doing a full
**                      row retrieve (CCMNB1D) and then doing a full
**                      row update (CCMNB2D).  The full row update is done
**                      using those columns that are brought in the input
**                      message.  For those columns that are not in the input
**                      message the values returned from the full row retrieve
**                      are used.
**
**  07/14/95  GUGLIEBS  Removed check for determining if data exists for
**                      factors and/or descriptors.  This check prevented
**                      all factors/descriptors from being deleted.
**
**  10/19/95  ELLIOTSL  ERR #1818: ID_EVENT was not getting copied from
**                      CINT07D to CINT02D.  This caused ID_EVENT to get
**                      deleted from the INCOMING_DETAIL table.  Because
**                      CINT12S uses this col to determine whether or
**                      not a record call event already exist CINT12S
**                      would write another record call event.
**
**  01/24/96  ELLIOTSL  ERR #2909: When a new STAGE record is being created
**                      The date and time need to be taken from the
**                      INCOMING_DETAIL table instead of using the system
**                      date.
**
**  03/19/96  OMARAJJ   SIR# 2145 - Added Id Resource to the Incoming Detail
**                      Table, so that the Notification L.E. form/facsimile
**                      could be created. It is included here so that it is
**                      Updated to the table.
**
**  03/04/2003  KRD     IMPACT - With the combination of the multiple Intake
**                      windows into two web pages, some of the services
**                      are not called in the same manner as before.  In this
**                      case, we need to ensure that szNmJurisdiction is
**                      saved here (on Intake Actions) as well as on
**                      Call Information.  Required changes to
**                      UpdateIncmgDetInformation().
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**  10/17/03   JMC      SIR 22315 Added in line to copy retrieved call type
**                       to the cint02d input object 
**
**
**  03/29/04   Ochumd   SIR 22646 - IMPACT: To satisfy the requirments set out
**                      in the sir, two new dams have been added to this service.
**                      (CAUDF0D and CAUDF1D) CAUDF0D is designed to search through
**                      the stage_person_link table for a stage name indicator given
**                      a stage id.  If one is found/or not, set it to null and call 
**                      CAUDF1D to set a new indicator for the person id selected.
**
**  06/02/04   dejuanr  SIR 22592 - The sex was not getting copied from cint07 to cint02
**
**  10/05/04   ochumd   SIR 23035 - Users will not get out of bounds errors if more 
**                      than 50 Determination Factor or Descriptors are checked.
**                      Size increased from 50 to 70. 
**
**  07/20/05   ochumd   Sir 23720 - A check box and a comments box were added to the
**                      Special Handling Section on the Intake Actions page to track
**                      Methamphetamine cases.  As a result, two new columns were added
**                      to the Incoming_detail and caps_case tables.  Those new fields 
**                      were populated here for insert and update.
** 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint14s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String STAGE_TYPE_CD_INTAKE = "INT";
    public static final char INDICATOR_NO = 'N';
    
    
    /********************************************************************
    **
    ** Function Name:  CCFC08S -- PAL FOLLOWUP SAVE
    **
    ** Description:    Main Service Function
    **
    *********************************************************************/
    static CINT14SI pInputMsg = null;
    static _CINT14SO pOutputMsg = null;
    static int transactionflag = - 1;
    CINT14SO CINT14S(CINT14SI cint14si) {/* beginning of switch #1*/
        CINT14SO cint14so = new CINT14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        
        
        
        /*
        ** SIR #2144 - Insert logic for special requests into a separate "if" statement.
        ** Calculate Retention date for a SPECIAL_REQUEST_STAGE_TYPE stage
        ** SIR 3938 - Check that CdStageType equals SPECIAL_REQUEST_STAGE_TYPE
        */
        if (transactionflag == - 1) /* 
        ** This means the Service exists on the Non_Equivalency
        ** table and is therefore exempt from the new equivalency edits
        */
        {
            userlog("ERROR: tpgetlev failed in CINT14S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINT14S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINT14S \n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        /* ERR #2909: The date and time from the INCOMING_DETAIL table.  The
        ** suffix "Stack" has been used to indicate that these variables are
        ** one the stack a supposed to elsewhere.
        */
        FndInt3date dtDtIncomingCallStack = new FndInt3date( - 1, - 1, - 1);
        String tmTmIncmgCallStack = "";
        
        /*
        ** 11/03/2000 - ochumd Added two new dams per sir# 15605.
        */
        
        CAUDF0DI pCAUDF0DInputRec = null;
        CAUDF0DO pCAUDF0DOutputRec = null;
        
        CAUDF1DI pCAUDF1DInputRec = null;
        CAUDF1DO pCAUDF1DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cint14si.ArchInputStruct);
        
        /*
        ** Set Calculated Retention date to maximum date
        */
        if (0 != cint14si.SpecHD.getUlIdCase()) 
        {
            
            //  Call CSUB40U
            rc = UpdateCaseInformation(cint14si, cint14so, pServiceStatus);
        }
        rc = SaveFactorsAndDescriptors(cint14si, cint14so, pServiceStatus);
        
        if (!(rc != 0)) {
            rc = UpdateIncmgDetInformation(cint14si, cint14so, pServiceStatus, dtDtIncomingCallStack, tmTmIncmgCallStack);
        }
        
        
        
        /*
        ** Added on 4/4/96 to account for Intake - Not
        ** Assigned for Investigation
        */
        if (!(rc != 0)) {
            rc = UpdateStageInformation(cint14si, cint14so, pServiceStatus, dtDtIncomingCallStack, tmTmIncmgCallStack);
        }
        
        
        /*  
        **    ochumd - sir 22646 only call these dams if ulIdPerson is not null.
        */
        
        /* if (NULL != pInputMsg->CallDcsnAUD.ulIdPerson) { */
        /******************************************************************
        BEGIN: CAUDF0D - To delete any existing indicator for a given **
        stageID.
        ******************************************************************/
        
        /* ** Allocate memory for DAM Input and Output Structures */
        
        pCAUDF0DInputRec = new CAUDF0DI();
        
        pCAUDF0DOutputRec = new CAUDF0DO();
        pCAUDF0DInputRec.setArchInputStruct(cint14si.ArchInputStruct);
        pCAUDF0DInputRec.setUlIdStage(cint14si.CallDcsnAUD.getUlIdStage());
        
        
        
        /*
        ** Calculate Output Message Size 
        */
        ;
        rc = caudf0dAUDdam(sqlca, pCAUDF0DInputRec, pCAUDF0DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set Calculated Retention date to maximum date
                if (cint14si.CallDcsnAUD.getUlIdPerson() != null) {
                    //  Allocate memory for DAM Input and Output Structures 
                    pCAUDF1DInputRec = new CAUDF1DI();
                    
                    pCAUDF1DOutputRec = new CAUDF1DO();
                    pCAUDF1DInputRec.setArchInputStruct(cint14si.ArchInputStruct);
                    pCAUDF1DInputRec.setUlIdStage(cint14si.CallDcsnAUD.getUlIdStage());
                    pCAUDF1DInputRec.setUlIdPerson(cint14si.CallDcsnAUD.getUlIdPerson());
                    rc = caudf1dAUDdam(sqlca, pCAUDF1DInputRec, pCAUDF1DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            rc = SUCCESS;
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
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint14si.ArchInputStruct, cint14so.ArchOutputStruct);
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            
            //  Perform processing for DAM CAUD75D - Records Retention Save
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINT14S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINT14S \n");
        }
        return cint14so;
    }

    static int SaveFactorsAndDescriptors(CINT14SI pInputMsg454, _CINT14SO pOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i256 = 0;
        int rc = 0;
        CINT03DI pCINT03DInputRec = null;
        CINT03DO pCINT03DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT03DInputRec = new CINT03DI();
        pCINT03DOutputRec = new CINT03DO();
        
        /*
        ** If an approver exists for the unit, determine whether the user has
        ** access to the unit by first checking to see if anyone in the set of
        ** (user + designees) is the approver.  if no-one is the approver, check
        ** the members' unit member role versus that of the approver.  if a
        ** member is above the approver in the unit heirarchy, then access is
        ** allowed, else it is denied.
        **
        ** If an approver does not exist, the unit must be a newly-created unit,
        ** so access is (automatically) granted.
        */
        
        if ((pCINT03DInputRec == null) || (pCINT03DOutputRec == null)) {
            Cint12s.FreePointers(2, new Object[]{
                new Object[]{pCINT03DInputRec, pCINT03DOutputRec}}
            );
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCINT03DInputRec.setUlIdStage(pInputMsg454.CallDcsnAUD.getUlIdStage());
        
        pCINT03DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        rc = cint03dAUDdam(sqlca, pCINT03DInputRec, pCINT03DOutputRec);
        
        /*
        ** Analyze return code for CINV51D(CL)
        */
        switch (rc) {
            case SUCCESS:
            case NO_DATA_FOUND:
                rc = 0;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                
                Cint12s.FreePointers(2, new Object[]{
                    new Object[]{pCINT03DInputRec, pCINT03DOutputRec}}
                );
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                Cint12s.FreePointers(2, new Object[]{
                    new Object[]{pCINT03DInputRec, pCINT03DOutputRec}
                }
                );
                return rc;
        }
        if (!(rc != 0)) {
            pCINT03DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            
            for (i256 = 0;(i256 < pInputMsg454.ArchInputStruct.getUlPageSizeNbr());i256++) {
                pCINT03DInputRec.setCdIncmgDeterm(pInputMsg454.DetermListAUD.getCdIncmgDeterm_ARRAY().getCdIncmgDeterm(i256));
                pCINT03DInputRec.setSzCdIncmgDetermType(pInputMsg454.DetermListAUD.getSzCdIncmgDetermType_ARRAY().getSzCdIncmgDetermType(i256));
                rc = cint03dAUDdam(sqlca, pCINT03DInputRec, pCINT03DOutputRec);
            }
            
            //  Analyze return code
            switch (rc) {
                case SUCCESS:
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint12s.FreePointers(2, new Object[]{
                        new Object[]{pCINT03DInputRec, pCINT03DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
            
        }
        Cint12s.FreePointers(2, new Object[]{
            new Object[]{pCINT03DInputRec, pCINT03DOutputRec}}
        );
        return rc;
    }

    static int UpdateStageInformation(CINT14SI pInputMsg455, _CINT14SO pOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS, FndInt3date pdtDtIncomingCallStack, String tmTmIncmgCallStack) {
        int rc = 0;
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        CINT12DI pCINT12DInputRec = null;
        CINT12DO pCINT12DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        pCINT21DOutputRec = new CINT21DO();
        pCINT12DInputRec = new CINT12DI();
        pCINT12DOutputRec = new CINT12DO();
        if ((pCINT21DInputRec == null) || (pCINT21DOutputRec == null) || (pCINT12DInputRec == null) || (pCINT12DOutputRec == null)) {
            Cint12s.FreePointers(4, new Object[]{
                new Object[]{pCINT21DInputRec, pCINT21DOutputRec, pCINT12DInputRec, pCINT12DOutputRec}}
            );
            
            
            //  Call CAUD08D
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCINT21DInputRec.setUlIdStage(pInputMsg455.CallDcsnAUD.getUlIdStage());
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = PopulateStageInput(pInputMsg455, pCINT12DInputRec, pCINT21DOutputRec, pServiceStatus, WtcHelperConstants.REQ_FUNC_CD_UPDATE, (FndInt3date) 0, (char) 0);
                if (rc != 0) {
                    Cint12s.FreePointers(4, new Object[]{
                        new Object[]{pCINT21DInputRec, pCINT21DOutputRec, pCINT12DInputRec, pCINT12DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                // 
                // End Call to Case File Mgmt AUD Dam - CAUD76D
                // 
                
                break;
            case NO_DATA_FOUND:
                pCINT12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
                
                //  Call CLSC72D
                rc = PopulateStageInput(pInputMsg455, pCINT12DInputRec, pCINT21DOutputRec, pServiceStatus, WtcHelperConstants.REQ_FUNC_CD_ADD, pdtDtIncomingCallStack, tmTmIncmgCallStack);
                if (rc != 0) {
                    Cint12s.FreePointers(4, new Object[]{
                        new Object[]{pCINT21DInputRec, pCINT21DOutputRec, pCINT12DInputRec, pCINT12DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Cint12s.FreePointers(4, new Object[]{
                    new Object[]{pCINT21DInputRec, pCINT21DOutputRec, pCINT12DInputRec, pCINT12DOutputRec}}
                );
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        if (!(rc != 0)) {
            pCINT12DInputRec.setUlIdStage(pInputMsg455.CallDcsnAUD.getUlIdStage());
            pCINT12DInputRec.setSzCdStage(STAGE_TYPE_CD_INTAKE);
            rc = cint12dAUDdam(sqlca, pCINT12DInputRec, pCINT12DOutputRec);
            
            switch (rc) {
                    
                case SUCCESS:
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint12s.FreePointers(4, new Object[]{
                        new Object[]{pCINT21DInputRec, pCINT21DOutputRec, pCINT12DInputRec, pCINT12DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        Cint12s.FreePointers(4, new Object[]{
            new Object[]
            {
                pCINT21DInputRec, pCINT21DOutputRec, pCINT12DInputRec, pCINT12DOutputRec}}
        );
        return rc;
    }

    static int PopulateStageInput(CINT14SI pInputMsg456, CINT12DI pCINT12DInputRec, CINT21DO pCINT21DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS, int sFunctionCd, FndInt3date pdtDtIncomingCallStack, String tmTmIncmgCallStack) {
        int rc = 0;/* Return code */
        
        /*
        ** Analyze error code
        */
        switch (sFunctionCd) {
            case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                pCINT12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                pCINT12DInputRec.setSzCdStageClassification(pInputMsg456.CallDcsnAUD.getSzCdStageClassification());
                pCINT12DInputRec.setSzCdStageCnty(pCINT21DOutputRec.getSzCdStageCnty());
                pCINT12DInputRec.setSzCdStageCurrPriority(pInputMsg456.CallDcsnAUD.getSzCdStageCurrPriority());
                pCINT12DInputRec.setSzCdStageInitialPriority(pInputMsg456.CallDcsnAUD.getSzCdStageInitialPriority());
                pCINT12DInputRec.setSzCdStageRegion(pCINT21DOutputRec.getSzCdStageRegion());
                pCINT12DInputRec.setSzCdStageRsnPriorityChgd(pInputMsg456.CallDcsnAUD.getSzCdStageRsnPriorityChgd());
                pCINT12DInputRec.setSzCdStageType(pCINT21DOutputRec.getSzCdStageType());
                
                pCINT12DInputRec.setDtDtStageClose(pCINT21DOutputRec.getDtDtStageClose());
                pCINT12DInputRec.setDtDtStageStart(pCINT21DOutputRec.getDtDtStageStart());
                pCINT12DInputRec.setUlIdCase(pCINT21DOutputRec.getUlIdCase());
                pCINT12DInputRec.setUlIdUnit(pCINT21DOutputRec.getUlIdUnit());
                pCINT12DInputRec.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                
                //## BEGIN TUX/XML: Declare XML variables 
                pCINT12DInputRec.setSzNmStage(pInputMsg456.CallDcsnAUD.getSzNmStage());
                pCINT12DInputRec.setSzTxtStagePriorityCmnts(pInputMsg456.CallDcsnAUD.getSzTxtStagePriorityCmnts());
                pCINT12DInputRec.setSzTxtStageClosureCmnts(pCINT21DOutputRec.getSzTxtStageClosureCmnts());
                pCINT12DInputRec.setBIndStageClose(pCINT21DOutputRec.getBIndStageClose());
                pCINT12DInputRec.setTmSysTmStageStart(pCINT21DOutputRec.getTmSysTmStageStart());
                pCINT12DInputRec.setDtDtStageStart(pCINT21DOutputRec.getDtDtStageStart());
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pCINT12DInputRec.setTsLastUpdate(pCINT21DOutputRec.getTsLastUpdate());
                
                
                break;
            case WtcHelperConstants.REQ_FUNC_CD_ADD:
                pCINT12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
                //## BEGIN TUX/XML: Declare XML variables 
                pCINT12DInputRec.setSzCdStage(STAGE_TYPE_CD_INTAKE);
                pCINT12DInputRec.setSzCdStageClassification(pInputMsg456.CallDcsnAUD.getSzCdStageClassification());
                pCINT12DInputRec.setSzCdStageCurrPriority(pInputMsg456.CallDcsnAUD.getSzCdStageCurrPriority());
                pCINT12DInputRec.setSzCdStageInitialPriority(pInputMsg456.CallDcsnAUD.getSzCdStageInitialPriority());
                pCINT12DInputRec.setSzCdStageRsnPriorityChgd(pInputMsg456.CallDcsnAUD.getSzCdStageRsnPriorityChgd());
                pCINT12DInputRec.setSzNmStage(pInputMsg456.CallDcsnAUD.getSzNmStage());
                pCINT12DInputRec.setSzTxtStagePriorityCmnts(pInputMsg456.CallDcsnAUD.getSzTxtStagePriorityCmnts());
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pCINT12DInputRec.setUlIdUnit(pInputMsg456.CallDcsnAUD.getUlIdUnit());
                pCINT12DInputRec.setBIndStageClose(INDICATOR_NO);
                pCINT12DInputRec.setDtDtStageStart(pdtDtIncomingCallStack);
                pCINT12DInputRec.setTmSysTmStageStart(tmTmIncmgCallStack);
                
                break;
        }
        pCINT12DInputRec.setSzCdStageReasonClosed(pInputMsg456.CallDcsnAUD.getSzCdStageReasonClosed());
        pCINT12DInputRec.getDtDtStageClose().year = - 1;
        pCINT12DInputRec.getDtDtStageClose().month = - 1;
        pCINT12DInputRec.getDtDtStageClose().day = - 1;
        pCINT12DInputRec.setUlIdStage(pInputMsg456.CallDcsnAUD.getUlIdStage());
        return 0;
    }

    static int UpdateIncmgDetInformation(CINT14SI pInputMsg457, _CINT14SO pOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS, FndInt3date pdtDtIncomingCallStack, String tmTmIncmgCallStack) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CINT07DI pCINT07DInputRec = null;
        CINT07DO pCINT07DOutputRec = null;
        CINT02DI pCINT02DInputRec = null;
        CINT02DO pCINT02DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT07DInputRec = new CINT07DI();
        pCINT07DOutputRec = new CINT07DO();
        pCINT02DInputRec = new CINT02DI();
        pCINT02DOutputRec = new CINT02DO();
        
        if ((pCINT07DInputRec == null) || (pCINT07DOutputRec == null) || (pCINT02DInputRec == null) || (pCINT02DOutputRec == null)) {
            Cint12s.FreePointers(4, new Object[]{
                //   Anything but success is unacceptable
                new Object[]{pCINT07DInputRec, pCINT07DOutputRec, pCINT02DInputRec, pCINT02DOutputRec}}
            );
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCINT07DInputRec.setUlIdStage(pInputMsg457.CallDcsnAUD.getUlIdStage());
        rc = cint07dQUERYdam(sqlca, pCINT07DInputRec, pCINT07DOutputRec);
        
        switch (rc) {
            case SUCCESS:
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Cint12s.FreePointers(4, new Object[]{
                    new Object[]{pCINT07DInputRec, pCINT07DOutputRec, pCINT02DInputRec, pCINT02DOutputRec}}
                );
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        
        if (!(rc != 0)) {
            pCINT02DInputRec.setUlIdPerson(pCINT07DOutputRec.getUlIdPerson());
            pCINT02DInputRec.setUlIdStage(pInputMsg457.CallDcsnAUD.getUlIdStage());
            pCINT02DInputRec.setSzCdIncmgAllegType(pInputMsg457.CallDcsnAUD.getSzCdIncmgAllegType());
            pCINT02DInputRec.setSzCdIncmgSex(pCINT07DOutputRec.getSzCdIncmgSex());
            pCINT02DInputRec.setCdIncomingProgramType(pCINT07DOutputRec.getCdIncomingProgramType());
            pCINT02DInputRec.setDtIncomingCallDisposed(pCINT07DOutputRec.getDtIncomingCallDisposed());
            pCINT02DInputRec.setTmSysTmCallDisp(pCINT07DOutputRec.getTmSysTmCallDisp());
            pCINT02DInputRec.setSzNbrIncmgCallerExt(pCINT07DOutputRec.getSzNbrIncmgCallerExt());
            pCINT02DInputRec.setSzNmJurisdiction(pInputMsg457.CallDcsnAUD.getSzNmJurisdiction());
            pCINT02DInputRec.setUlIdResource(pCINT07DOutputRec.getUlIdResource());
            pCINT02DInputRec.setDtDtIncomingCall(pCINT07DOutputRec.getDtDtIncomingCall());
            pCINT02DInputRec.setTmTmIncmgCall(pCINT07DOutputRec.getTmTmIncmgCall());
            pdtDtIncomingCallStack = pCINT07DOutputRec.getDtDtIncomingCall();
            tmTmIncmgCallStack = pCINT07DOutputRec.getTmTmIncmgCall();
            
            pCINT02DInputRec.setNmIncomingCallerFirst(pCINT07DOutputRec.getNmIncomingCallerFirst());
            pCINT02DInputRec.setSzCdIncomingCallType(pCINT07DOutputRec.getSzCdIncomingCallType());
            pCINT02DInputRec.setNmIncomingCallerMiddle(pCINT07DOutputRec.getNmIncomingCallerMiddle());
            pCINT02DInputRec.setNmIncomingCallerLast(pCINT07DOutputRec.getNmIncomingCallerLast());
            pCINT02DInputRec.setCdIncomingCallerSuffix(pCINT07DOutputRec.getCdIncomingCallerSuffix());
            pCINT02DInputRec.setSzNbrIncomingCallerPhone(pCINT07DOutputRec.getSzNbrIncomingCallerPhone());
            pCINT02DInputRec.setSzCdIncmgPhoneType(pCINT07DOutputRec.getSzCdIncmgPhoneType());
            pCINT02DInputRec.setSzCdIncmgAddrType(pCINT07DOutputRec.getSzCdIncmgAddrType());
            pCINT02DInputRec.setSzAddrIncmgStreetLn1(pCINT07DOutputRec.getSzAddrIncmgStreetLn1());
            pCINT02DInputRec.setSzAddrIncmgStreetLn2(pCINT07DOutputRec.getSzAddrIncmgStreetLn2());
            pCINT02DInputRec.setSzAddrIncomingCallerCity(pCINT07DOutputRec.getSzAddrIncomingCallerCity());
            pCINT02DInputRec.setSzCdIncomingCallerCounty(pCINT07DOutputRec.getSzCdIncomingCallerCounty());
            pCINT02DInputRec.setSzCdIncomingCallerState(pCINT07DOutputRec.getSzCdIncomingCallerState());
            pCINT02DInputRec.setSzAddrIncmgZip(pCINT07DOutputRec.getSzAddrIncmgZip());
            pCINT02DInputRec.setSzNmIncmgRegardingFirst(pCINT07DOutputRec.getSzNmIncmgRegardingFirst());
            
            pCINT02DInputRec.setSzNmIncmgRegardingLast(pCINT07DOutputRec.getSzNmIncmgRegardingLast());
            pCINT02DInputRec.setSzCdIncomingDisposition(pCINT07DOutputRec.getSzCdIncomingDisposition());
            pCINT02DInputRec.setSzCdIncmgCallerInt(pCINT07DOutputRec.getSzCdIncmgCallerInt());
            pCINT02DInputRec.setSzAddrIncWkrCity(pCINT07DOutputRec.getSzAddrIncWkrCity());
            pCINT02DInputRec.setLNbrIncWkrPhone(pCINT07DOutputRec.getLNbrIncWkrPhone());
            pCINT02DInputRec.setLNbrIncWkrExt(pCINT07DOutputRec.getLNbrIncWkrExt());
            pCINT02DInputRec.setSzNmIncWkrName(pCINT07DOutputRec.getSzNmIncWkrName());
            pCINT02DInputRec.setSzCdIncmgSpecHandling(pInputMsg457.SpecHD.getSzCdCaseSpeclHndlg());
            pCINT02DInputRec.setTxtIncmgWorkerSafety(pInputMsg457.SpecHD.getSzTxtCaseWorkerSafety());
            pCINT02DInputRec.setTxtIncomgSensitive(pInputMsg457.SpecHD.getSzTxtCaseSensitiveCmnts());
            pCINT02DInputRec.setTxtIncomgSuspMeth(pInputMsg457.SpecHD.getSzTxtCaseSuspMeth());
            
            pCINT02DInputRec.setCdIncmgStatus(pCINT07DOutputRec.getCdIncmgStatus());
            pCINT02DInputRec.setSzCdIncmgRegion(pCINT07DOutputRec.getSzCdIncmgRegion());
            pCINT02DInputRec.setSzNbrIncmgUnit(pCINT07DOutputRec.getSzNbrIncmgUnit());
            pCINT02DInputRec.setUlIdEvent(pCINT07DOutputRec.getUlIdEvent());
            pCINT02DInputRec.setBIndIncmgSensitive(pInputMsg457.SpecHD.getBIndCaseSensitive());
            pCINT02DInputRec.setBIndIncmgSuspMeth(pInputMsg457.SpecHD.getBIndCaseSuspMeth());
            pCINT02DInputRec.setBIndIncmgWorkerSafety(pInputMsg457.SpecHD.getBIndCaseWorkerSafety());
            pCINT02DInputRec.setBIndIncmgNoFactor(pInputMsg457.CallDcsnAUD.getBIndIncmgNoFactor());
            pCINT02DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            
            //  Call DAM
            rc = cint02dAUDdam(sqlca, pCINT02DInputRec, pCINT02DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case SUCCESS:
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint12s.FreePointers(4, new Object[]{
                        new Object[]{pCINT07DInputRec, pCINT07DOutputRec, pCINT02DInputRec, pCINT02DOutputRec}}
                    
                    );
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        Cint12s.FreePointers(4, new Object[]{
            new Object[]{pCINT07DInputRec, pCINT07DOutputRec, pCINT02DInputRec, pCINT02DOutputRec}}
        
        );
        
        return rc;
    }

    
    static void FreePointers(ushort usNbrPointers, Object[] argument) {
        int varargsIndex = 0;
        Object pPointerToFree = null;
        ushort usIndex = null;
        
        for (usIndex = null;usIndex < usNbrPointers;usIndex++) {
            pPointerToFree = argument[varargsIndex++];
        }
        return;
    }

    static int UpdateCaseInformation(CINT14SI pInputMsg458, _CINT14SO pOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        /*
        ** Declare local variables
        */
        CCMNB1DI pCCMNB1DInputRec = null;
        CCMNB1DO pCCMNB1DOutputRec = null;
        CCMNB2DI pCCMNB2DInputRec = null;
        CCMNB2DO pCCMNB2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB1DInputRec = new CCMNB1DI();
        pCCMNB1DOutputRec = new CCMNB1DO();
        pCCMNB2DInputRec = new CCMNB2DI();
        pCCMNB2DOutputRec = new CCMNB2DO();
        
        /**************************************************************************
        ** END CMSC17D
        **************************************************************************/
        
        
        /*
        ** if home is non-prs or home is prs and home status is approved-active
        ** or approved-inactive, determine if contracts exist and create them if
        ** they don't exist
        */
        
        if ((pCCMNB1DInputRec == null) || (pCCMNB1DOutputRec == null) || (pCCMNB2DInputRec == null) || (pCCMNB2DOutputRec == null)) {
            Cint12s.FreePointers(4, new Object[]{
                new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec}}
            );
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCCMNB1DInputRec.setUlIdCase(pInputMsg458.SpecHD.getUlIdCase());
        rc = ccmnb1dQUERYdam(sqlca, pCCMNB1DInputRec, pCCMNB1DOutputRec);
        if (!(rc != 0)) {
            pCCMNB2DInputRec.setSzNmCase(pInputMsg458.CallDcsnAUD.getSzNmStage());
            pCCMNB2DInputRec.setSzCdCaseSpeclHndlg(pInputMsg458.SpecHD.getSzCdCaseSpeclHndlg());
            pCCMNB2DInputRec.setSzTxtCaseWorkerSafety(pInputMsg458.SpecHD.getSzTxtCaseWorkerSafety());
            pCCMNB2DInputRec.setSzTxtCaseSensitiveCmnts(pInputMsg458.SpecHD.getSzTxtCaseSensitiveCmnts());
            pCCMNB2DInputRec.setSzTxtCaseSuspMeth(pInputMsg458.SpecHD.getSzTxtCaseSuspMeth());
            pCCMNB2DInputRec.setBIndCaseWorkerSafety(pInputMsg458.SpecHD.getBIndCaseWorkerSafety());
            pCCMNB2DInputRec.setBIndCaseSensitive(pInputMsg458.SpecHD.getBIndCaseSensitive());
            pCCMNB2DInputRec.setBIndCaseSuspMeth(pInputMsg458.SpecHD.getBIndCaseSuspMeth());
            pCCMNB2DInputRec.setSzCdCaseProgram(pCCMNB1DOutputRec.getSzCdCaseProgram());
            pCCMNB2DInputRec.setSzCdCaseRegion(pCCMNB1DOutputRec.getSzCdCaseRegion());
            pCCMNB2DInputRec.setDtDtCaseClosed(pCCMNB1DOutputRec.getDtDtCaseClosed());
            pCCMNB2DInputRec.setTmSysTmCaseClosed(pCCMNB1DOutputRec.getTmSysTmCaseClosed());
            pCCMNB2DInputRec.setBIndCaseArchived(pCCMNB1DOutputRec.getBIndCaseArchived());
            pCCMNB2DInputRec.setSzCdCaseCounty(pCCMNB1DOutputRec.getSzCdCaseCounty());
            pCCMNB2DInputRec.setTsSysTsLastUpdate2(pCCMNB1DOutputRec.getTsSysTsLastUpdate2());
            pCCMNB2DInputRec.setDtDtCaseOpened(pCCMNB1DOutputRec.getDtDtCaseOpened());
            pCCMNB2DInputRec.setTmSysTmCaseOpened(pCCMNB1DOutputRec.getTmSysTmCaseOpened());
            pCCMNB2DInputRec.setUlIdCase(pInputMsg458.SpecHD.getUlIdCase());
            pCCMNB2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            
            //  Call CheckStageEventStatus
            rc = ccmnb2dAUDdam(sqlca, pCCMNB2DInputRec, pCCMNB2DOutputRec);
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        else {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        Cint12s.FreePointers(4, new Object[]{
            new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec}}
        );
        return rc;
    }

}
