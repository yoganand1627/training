package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV54SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSESA2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSESA2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS15DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
/**************************************************************************
**
** Module File:    CINV54S.src
**
** Service Name:   CINV54S
**
** Description:   This service calls DAMS CLSS81D.pc and CSESA2D.pc
**                to retrieve all the information needed to poplulate
**        the Services and Referrals Checklist window.  This
**        service will retrive an entire row from the
**        CPS_CHECKLIST table, and one or more rows from
**        the CPS_CHECKLIST_ITEM table.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V4.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/05/2001
**
** Programmer:    Stephen Corley
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   01 Feb 2002 10:18:06  $
**                      $Modtime:   01 Feb 2002 08:25:46  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/05/01  hafelela  Initial Shell
**
**  10/19/01  casdorjm  Added call to DAM cinv95d to retrieve the Date Last
**                      update.
**  11/7/01   CORLEYSL  Added call to DAM
**  02/01/02  cawthocw  SIR 15978 - Set the flag so that the user cannot navigate
**                      to the Services and Referral Checklist window from the
**                      ToDo window without having created an initial contact.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  07/07/04  RIOSJA    SIR 16114 - "Initial contact" edit is not required
**                      unless stage is INV. Need to pass stage code to the
**                      service so this check can be made.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv54s {
    /* SARE2001 JMC NEW CODE END */
    
    
    /* RIOSJA, SIR 16114 */
    public static final String INV_STAGE = "INV";
    CINV54SO CINV54S(CINV54SI cinv54si) {
        CINV54SO cinv54so = new CINV54SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/* Return value for service  */
        int i382 = 0;
        rc = ARC_PRFServiceStartTime_TUX(cinv54si.getArchInputStruct());
        
        /*
        ** Initialize Service Status Fields
        */
        
        /* Perform Main Processing */
        
        /**************************************************************************
        ** Call DAMs to retrieve data
        **************************************************************************/
        
        /*
        ** Set RetVal = success to assume the function will
        ** complte successfully
        */
        RetVal = SUCCESS;
        rc = CallCSESA2D(cinv54si, cinv54so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                // Function was successful
                RetVal = SUCCESS;
                break;
            case NO_DATA_FOUND:
                //  Function was still successful
                // because the window has never
                // been entered if no rows found.
                RetVal = SUCCESS;
                break;
            default :
                // Function failed; Break out of service
                RetVal = Csub50s.FND_FAIL;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        
        if (SUCCESS == RetVal) {
            
            // 
            // Call DAMs to retrieve data
            // 
            //  Call PostEvent
            // 
            rc = CallCLSS81D(cinv54si, cinv54so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    // Function was successful
                    RetVal = SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    //  Function was still successful
                    // because the window has never
                    // been entered if no rows found.
                    RetVal = SUCCESS;
                    break;
                default :
                    // Function failed; Break out of service
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                    
                    // COPYSZ(pOutputMsg->ROWCINV24SOG[i].tsLastUpdate,
                    // pCINV28DOutputRec->ROWCINV28DO[i].tsLastUpdate);
            }
        }
        
        if (SUCCESS == RetVal && 0 == cinv54si.getSzCdStage().compareTo(INV_STAGE)) {
            rc = Cinv14s.CallCSYS15D(cinv54si, cinv54so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    // Function was successful
                    RetVal = SUCCESS;
                    break;
                case Messages.MSG_INV_NOT_BEGUN:
                    RetVal = Csub50s.FND_FAIL;
                    break;
                default :
                    // Function failed; Break out of service
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
            }
        }
        
        if ((SUCCESS == RetVal) && (cinv54si.getUlIdEvent() != 0)) {
            rc = Ccmn01u.CallCCMN45D(cinv54si, cinv54so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    // Function was successful
                    RetVal = SUCCESS;
                    break;
                case NO_DATA_FOUND:
                default :
                    // Function failed; Break out of service
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    //  Do nothing, the output message just returns success or
                    // failure.
                    break;
            }
        }
        
        /*
        ** Load Translation Map with service name and version
        */
        
        /*
        ** Stop Performance Timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv54si.getArchInputStruct() , cinv54so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            // 
            // Call DAMs to retrieve data
            // 
            //  Call PostEvent
            // 
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            // if the facility type is 70 or 71 (FAD Home), then update the
            // number of open slots
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
        return cinv54so;
    }

    static int CallCSESA2D(CINV54SI pInputMsg761, CINV54SO pOutputMsg709, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSESA2DI pCSESA2DInputRec = null;
        CSESA2DO pCSESA2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSESA2DInputRec = new CSESA2DI();
        
        pCSESA2DOutputRec = new CSESA2DO();
        pCSESA2DInputRec.setArchInputStruct(pInputMsg761.getArchInputStruct());
        pCSESA2DInputRec.setUlIdEvent(pInputMsg761.getUlIdEvent());
        rc = csesa2dQUERYdam(sqlca, pCSESA2DInputRec, pCSESA2DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg709.getROWCINV54SOG00().setUlIdCpsChecklist(pCSESA2DOutputRec.getUlIdCpsChecklist());
                pOutputMsg709.getROWCINV54SOG00().setUlIdEvent(pCSESA2DOutputRec.getUlIdEvent());
                pOutputMsg709.getROWCINV54SOG00().setUlIdCase(pCSESA2DOutputRec.getUlIdCase());
                pOutputMsg709.getROWCINV54SOG00().setTsLastUpdate(pCSESA2DOutputRec.getTsLastUpdate());
                pOutputMsg709.getROWCINV54SOG00().setDtDtFirstReferral(pCSESA2DOutputRec.getDtDtFirstReferral());
                pOutputMsg709.getROWCINV54SOG00().setCIndSvcRefChklstNoRef(pCSESA2DOutputRec.getCIndSvcRefChklstNoRef());
                pOutputMsg709.getROWCINV54SOG00().setSzCdFamilyResponse(pCSESA2DOutputRec.getSzCdFamilyResponse());
                pOutputMsg709.getROWCINV54SOG00().setSzTxtChklstComments(pCSESA2DOutputRec.getSzTxtChklstComments());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSS81D(CINV54SI pInputMsg762, CINV54SO pOutputMsg710, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i383 = 0;
        
        /*
        ** Declare local variables
        */
        CLSS81DI pCLSS81DInputRec = null;
        CLSS81DO pCLSS81DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS81DInputRec = new CLSS81DI();
        
        pCLSS81DOutputRec = new CLSS81DO();
        pCLSS81DInputRec.setArchInputStruct(pInputMsg762.getArchInputStruct());
        pCLSS81DInputRec.setUlIdEvent(pInputMsg762.getUlIdEvent());
        rc = clss81dQUERYdam(sqlca, pCLSS81DInputRec, pCLSS81DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) 
        {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Populate Output Message
                for (i383 = 0;i383 < pCLSS81DOutputRec.getArchOutputStruct().getUlRowQty();++i383) {
                    pOutputMsg710.getROWCINV54SOG01_ARRAY().getROWCINV54SOG01(i383).setUlIdChklstItem(pCLSS81DOutputRec.getROWCLSS81DO_ARRAY().getROWCLSS81DO(i383).getUlIdChklstItem());
                    pOutputMsg710.getROWCINV54SOG01_ARRAY().getROWCINV54SOG01(i383).setUlIdCpsChecklist(pCLSS81DOutputRec.getROWCLSS81DO_ARRAY().getROWCLSS81DO(i383).getUlIdCpsChecklist());
                    pOutputMsg710.getROWCINV54SOG01_ARRAY().getROWCINV54SOG01(i383).setSzCdSvcReferred(pCLSS81DOutputRec.getROWCLSS81DO_ARRAY().getROWCLSS81DO(i383).getSzCdSvcReferred());
                    pOutputMsg710.getROWCINV54SOG01_ARRAY().getROWCINV54SOG01(i383).setTsLastUpdate(pCLSS81DOutputRec.getROWCLSS81DO_ARRAY().getROWCLSS81DO(i383).getTsLastUpdate());
                }
                pOutputMsg710.getArchOutputStruct().setUlRowQty(pCLSS81DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg710.getArchOutputStruct().setBMoreDataInd(pCLSS81DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Call CCMN29D
                rc = NO_DATA_FOUND;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    
    static int CallCSYS15D(CINV54SI pInputMsg763, CINV54SO pOutputMsg711, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i384 = 0;
        
        /*
        ** Declare local variables
        */
        CSYS15DI pCSYS15DInputRec = null;
        CSYS15DO pCSYS15DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS15DInputRec = new CSYS15DI();
        pCSYS15DOutputRec = new CSYS15DO();
        pCSYS15DInputRec.setArchInputStruct(pInputMsg763.getArchInputStruct());
        pCSYS15DInputRec.setUlIdStage(pInputMsg763.getUlIdStage());
        rc = csys15dQUERYdam(sqlca, pCSYS15DInputRec, pCSYS15DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                pCSYS15DOutputRec.getArchOutputStruct().setUlRowQty(1);
                
                if (DateHelper.NULL_DATE != pCSYS15DOutputRec.getDtDTContactOccurred().year) {
                    pOutputMsg711.getROWCINV54SOG00().setDtDtCPSInvstDtlBegun(pCSYS15DOutputRec.getDtDTContactOccurred());
                    ;
                }
                rc = SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_INV_NOT_BEGUN;
                    
                    //  Call CSUB40U
                    rc = Messages.MSG_INV_NOT_BEGUN;
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        
    }

    
    static int CallCCMN45D(CINV54SI pInputMsg764, CINV54SO pOutputMsg712, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
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
        pCCMN45DInputRec.setArchInputStruct(pInputMsg764.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg764.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg712.setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                
                
                //  Populate Input Structure for DAM
                
                // Get system Date and time
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Call DAM
                rc = NO_DATA_FOUND;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
