package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegListAUDOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14DO;
/**************************************************************************
** 
** Module File:   CINT06S.src
**
** Service Name:  CINT06S
**
** Description:   AUD service for the Allegation Dialogue.
**                This service calls DAM CINT14D for the Add/Update/Delete
**                functions of the Allegation windows.  This DAM writes to
**                the INTAKE_ALLEGATION table.  It is called from the Intake
**                Toolbar when an interwindow message to partial save is 
**                received.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/15/95 
** 
** Programmer:    Paul Bordelon/Andersen Consulting                 
**
** Archive Information: $Revision:   1.5  $
**                      $Date:   17 Jul 1999 14:43:06  $
**                      $Modtime:   19 May 1999 13:22:18  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  SIR 21891 - version control code was missing.  I 
**                      added the lines.
**  09/18/96    KRD     SIR 10881 - If the Allegation partial save is
**                      executed when the Person partial save has failed or
**                      not completed, there is a possibility that the victim
**                      and/or alleged perpetrator will not have been
**                      saved/created on the PERSON table.  This causes a
**                      foreign key constraint.  CallCINT14D() and the main
**                      service function have been modified to handle this
**                      situation gracefully.
** 05/19/99	SOHNJJ	SIR #FND32 - FOUNDATION 3.2 Migraton Change
**      		Changed variable
**              	FROM: _ALLEGLISTAUDINREC__ROWCINT14DI_SIZ
**              	TO:   _ALLEGLISTAUDINREC__ROWCINT14DI_SIZE
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
**  07/12/04   ochumd   Sir #22934 - Modified cint14d.pc and this service to
**                      handle two new cols created (NmVictim and NmPerpetrator)
**                      in Intake_allegation table
**
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint06s {
    static int transactionflag = - 1;
    CINT06SO CINT06S(CINT06SI cint06si) {
        CINT06SO cint06so = new CINT06SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINT06S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINT06S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINT06S \n");
            bTransactionStarted = true;
        }
        rc = ARC_PRFServiceStartTime_TUX(cint06si.ArchInputStruct);
        
        
        /*
        ** Call CCMN45D
        */
        rc = CallCINT14D(cint06si, cint06so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
            case WtcHelperConstants.SQL_PARENT_REF_INTEGRITY:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                break;
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint06si.ArchInputStruct, cint06so.ArchOutputStruct);
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINT06S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINT06S \n");
        }
        return cint06so;
    }

    static int CallCINT14D(CINT06SI pInputMsg403, AllegListAUDOutRec pOutputMsg369, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT14DI pCINT14DInputRec = null;
        CINT14DO pCINT14DOutputRec = null;
        int i246 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT14DInputRec = new CINT14DI();
        pCINT14DOutputRec = new CINT14DO();
        
        /*
        ** Call DAM
        */
        rc = SUCCESS;
        
        /*
        ** While more rows are left to process and rc is zero,
        ** continue loop.
        */
        
        while ((i246 < CINT06SI._ALLEGLISTAUDINREC__ROWCINT14DI_SIZE) && (SUCCESS == rc)) {
            if (null != pInputMsg403.ROWCINT14DI[i246].getSzCdScrDataAction()) {
                pCINT14DInputRec.setArchInputStruct(pInputMsg403.ArchInputStruct);
                
                pCINT14DInputRec.setUlIdAllegation(pInputMsg403.ROWCINT14DI[i246].getUlIdAllegation());
                pCINT14DInputRec.setUlIdStage(pInputMsg403.ROWCINT14DI[i246].getUlIdStage());
                pCINT14DInputRec.setSzCdAllegType(pInputMsg403.ROWCINT14DI[i246].getSzCdAllegType());
                pCINT14DInputRec.setSzTxtAllegDuration(pInputMsg403.ROWCINT14DI[i246].getSzTxtAllegDuration());
                pCINT14DInputRec.setUlIdVictim(pInputMsg403.ROWCINT14DI[i246].getUlIdVictim());
                
                
                // 
                // Function Prototypes
                // 
                
                pCINT14DInputRec.setUlIdAllegedPerpetrator(pInputMsg403.ROWCINT14DI[i246].getUlIdAllegedPerpetrator());
                pCINT14DInputRec.setSzCdScrDataAction(pInputMsg403.ROWCINT14DI[i246].getSzCdScrDataAction());
                pCINT14DInputRec.setSzNmVictim(pInputMsg403.ROWCINT14DI[i246].getSzNmVictim());
                
                pCINT14DInputRec.setSzNmPerpetrator(pInputMsg403.ROWCINT14DI[i246].getSzNmPerpetrator());
                //  Do nothing, the output message just returns success or
                // failure.
                // When SQL_NOT_FOUND is returned, there were no case names
                // to update.
                rc = cint14dAUDdam(sqlca, pCINT14DInputRec, pCINT14DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg403.ROWCINT14DI[i246].getSzCdScrDataAction()) {
                            pOutputMsg369.getAllegLstOutStruct_ARRAY().getAllegLstOutStruct(i246).setUlIdAllegation(pCINT14DOutputRec.getUlIdAllegation());
                            pOutputMsg369.getAllegLstOutStruct_ARRAY().getAllegLstOutStruct(i246).setLSysNbrUniqueLBKey(i246);
                        }
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        break;
                    case WtcHelperConstants.SQL_PARENT_REF_INTEGRITY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = WtcHelperConstants.SQL_PARENT_REF_INTEGRITY;
                        rc = WtcHelperConstants.SQL_PARENT_REF_INTEGRITY;
                        break;
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
            }
            i246++;
        }
        return rc;
    }

}
