package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV90DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV90DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV91DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV91DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC59DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC59DO;
/**************************************************************************
** 
** Module File:   CINV44S.src
**
** Service Name:  CINV44S
**
** Description:   This service retrieves allegations to fill
**                the Investigation Allegation List listbox.  It also 
**                retrieves the stage's overall disposition.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  March 21, 1995 
** 
** Programmer:    Belinda Muse
** 
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 18:23:18  $
**                      $Modtime:   30 Mar 1996 00:18:00  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/12/96  MUSEBL    R1R2 Impact #29: Add Admin Review functionality;
**                      replace program macros with those in caps.h. 
**
**  02/05/96  BRUCKMK   SIR 1847: Added DAM CLSC59D to retrieve the ID_STAGE 
**						of the Investigation Stage for the Case.  This 
**						Investigation ID_STAGE should be passed to the DAM 
**						which retrieves Overall Disposition based on program.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv44s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String INTAKE = "INT";
    
    /************************************************************************
    **  SIR 2428: Add the CD_STAGE for INVESTIGATION
    ************************************************************************/
    public static final String INVESTIGATION = "INV";
    public static final String SVC_DELIVERY = "SVC";
    public static final String ADMIN_REVIEW = "ARI";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final int INITIAL_PAGE = 1;
    CINV44SO CINV44S(CINV44SI cinv44si) {
        CINV44SO cinv44so = new CINV44SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(cinv44si.getArchInputStruct());
        
        if (!(cinv44si.getSzCdAllegIncidentStage().compareTo(INVESTIGATION) != 0) ||!(cinv44si.getSzCdAllegIncidentStage().compareTo(ADMIN_REVIEW) != 0)) {
            
            
            //  END VARIABLE DECLARATION 
            
            //  Start Performance Timer
            rc = CallCINV68D(cinv44si, cinv44so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                case Messages.MSG_INV_NO_ALLEGS:
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        else if /* Stage is Service Delivery */
        (!(cinv44si.getSzCdAllegIncidentStage().compareTo(SVC_DELIVERY) != 0)) {
            rc = Cinv08s.CallCINV90D(cinv44si, cinv44so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_INV_NO_ALLEGS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            rc = Ccfc40s.CallCLSC59D(cinv44si, cinv44so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        else if /* Stage is Intake */
        (!(cinv44si.getSzCdAllegIncidentStage().compareTo(INTAKE) != 0)) {
            
            //  Call CheckStageEventStatus
            rc = CallCINV91D(cinv44si, cinv44so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_INV_NO_ALLEGS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            rc = Ccfc40s.CallCLSC59D(cinv44si, cinv44so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (!(cinv44si.getSzCdStageProgram().compareTo(CAPS_PROG_APS) != 0)) {
            rc = Cinv19s.CallCINV44D(cinv44si, cinv44so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (!(cinv44si.getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS) != 0)) {
            
            
            //  Call CLSC59D
            rc = Ccmn02u.CallCINV95D(cinv44si, cinv44so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (!(cinv44si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC) != 0)) {
            
            rc = Cinv17s.CallCINV17D(cinv44si, cinv44so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (!(cinv44si.getSzCdStageProgram().compareTo(CAPS_PROG_CCL) != 0) ||!(cinv44si.getSzCdStageProgram().compareTo(CAPS_PROG_RCL) != 0)) {
            rc = Cinv56s.CallCINV74D(cinv44si, cinv44so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (cinv44so.getUlIdEvent() != 0) {
            
            
            //  Call CLSC18D
            rc = Ccmn01u.CallCCMN45D(cinv44si, cinv44so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cinv44si.getArchInputStruct() , cinv44so.getArchOutputStruct());
        
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
                
                
                //  Call CLSC18D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv44so;
    }

    static int CallCINV68D(CINV44SI pInputMsg718, CINV44SO pOutputMsg668, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i357 = 0;
        
        /*
        ** Declare local variables
        */
        CINV68DI pCINV68DInputRec = null;
        CINV68DO pCINV68DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV68DInputRec = new CINV68DI();
        
        pCINV68DOutputRec = new CINV68DO();
        pCINV68DInputRec.setUlIdStage(pInputMsg718.getUlIdStage());
        
        /*
        ** SIR 1847
        */
        pCINV68DInputRec.setArchInputStruct(pInputMsg718.getArchInputStruct());
        rc = cinv68dQUERYdam(sqlca, pCINV68DInputRec, pCINV68DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                //  Populate Output Message
                for (i357 = 0;i357 < pCINV68DOutputRec.getArchOutputStruct().getUlRowQty();++i357) {
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setSzScrPersVictim(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getSzScrPersVictim());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setUlIdVictim(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getUlIdVictim());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setSzCdAllegType(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getSzCdAllegType());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setSzScrAllegPerp(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getSzScrAllegPerp());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setUlIdAllegedPerpetrator(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getUlIdAllegedPerpetrator());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setCdAllegDisposition(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getCdAllegDisposition());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setSzCdAllegIncidentStage(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getSzCdAllegIncidentStage());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setUlIdAllegation(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getUlIdAllegation());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setTsLastUpdate(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getTsLastUpdate());
                    pOutputMsg668.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i357).setTsSysTsLastUpdate2(pCINV68DOutputRec.getROWCINV68DO_ARRAY().getROWCINV68DO(i357).getTsSysTsLastUpdate2());
                }
                pOutputMsg668.getArchOutputStruct().setUlRowQty(pCINV68DOutputRec.getArchOutputStruct().getUlRowQty());
                
                pOutputMsg668.getArchOutputStruct().setBMoreDataInd(pCINV68DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = Messages.MSG_INV_NO_ALLEGS;
                rc = Messages.MSG_INV_NO_ALLEGS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV90D(CINV44SI pInputMsg719, CINV44SO pOutputMsg669, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i358 = 0;
        
        /*
        ** Declare local variables
        */
        CINV90DI pCINV90DInputRec = null;
        CINV90DO pCINV90DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV90DInputRec = new CINV90DI();
        
        pCINV90DOutputRec = new CINV90DO();
        pCINV90DInputRec.setUlIdStage(pInputMsg719.getUlIdStage());
        pCINV90DInputRec.setArchInputStruct(pInputMsg719.getArchInputStruct());
        rc = cinv90dQUERYdam(sqlca, pCINV90DInputRec, pCINV90DOutputRec);
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_INV_NO_ALLEGS;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            //  Populate Output Message
            for (i358 = 0;i358 < pCINV90DOutputRec.getArchOutputStruct().getUlRowQty();++i358) {
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setSzScrPersVictim(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getSzScrPersVictim());
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setUlIdVictim(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getUlIdVictim());
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setSzCdAllegType(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getSzCdAllegType());
                
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setSzScrAllegPerp(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getSzScrAllegPerp());
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setUlIdAllegedPerpetrator(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getUlIdAllegedPerpetrator());
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setCdAllegDisposition(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getCdAllegDisposition());
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setSzCdAllegIncidentStage(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getSzCdAllegIncidentStage());
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setUlIdAllegation(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getUlIdAllegation());
                pOutputMsg669.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i358).setTsLastUpdate(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i358).getTsLastUpdate());
            }
            pOutputMsg669.getArchOutputStruct().setUlRowQty(pCINV90DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg669.getArchOutputStruct().setBMoreDataInd(pCINV90DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCINV91D(CINV44SI pInputMsg720, CINV44SO pOutputMsg670, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i359 = 0;
        
        /*
        ** Declare local variables
        */
        CINV91DI pCINV91DInputRec = null;
        CINV91DO pCINV91DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV91DInputRec = new CINV91DI();
        
        pCINV91DOutputRec = new CINV91DO();
        pCINV91DInputRec.setArchInputStruct(pInputMsg720.getArchInputStruct());
        pCINV91DInputRec.setUlIdStage(pInputMsg720.getUlIdStage());
        /*
        ** Description:  This DAM will receives Id Person  and returns n rows
        **               from  SVC_AUTH_DETAIL , SERVICE_AUTHORIZATION
        */
        rc = cinv91dQUERYdam(sqlca, pCINV91DInputRec, pCINV91DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_INV_NO_ALLEGS;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            for (i359 = 0;i359 < pCINV91DOutputRec.getArchOutputStruct().getUlRowQty();++i359) {
                pOutputMsg670.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i359).setSzScrPersVictim(pCINV91DOutputRec.getROWCINV91DO_ARRAY().getROWCINV91DO(i359).getSzScrPersVictim());
                pOutputMsg670.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i359).setUlIdVictim(pCINV91DOutputRec.getROWCINV91DO_ARRAY().getROWCINV91DO(i359).getUlIdVictim());
                
                //## BEGIN TUX/XML: Declare XML variables
                pOutputMsg670.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i359).setSzCdAllegType(pCINV91DOutputRec.getROWCINV91DO_ARRAY().getROWCINV91DO(i359).getSzCdIntakeAllegType());
                pOutputMsg670.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i359).setSzScrAllegPerp(pCINV91DOutputRec.getROWCINV91DO_ARRAY().getROWCINV91DO(i359).getSzScrAllegPerp());
                pOutputMsg670.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i359).setUlIdAllegedPerpetrator(pCINV91DOutputRec.getROWCINV91DO_ARRAY().getROWCINV91DO(i359).getUlIdAllegedPerpetrator());
                pOutputMsg670.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i359).setSzCdAllegIncidentStage(pCINV91DOutputRec.getROWCINV91DO_ARRAY().getROWCINV91DO(i359).getSzCdStage());
                pOutputMsg670.getROWCINV44SOG_ARRAY().getROWCINV44SOG(i359).setUlIdAllegation(pCINV91DOutputRec.getROWCINV91DO_ARRAY().getROWCINV91DO(i359).getUlIdAllegation());
            }
            pOutputMsg670.getArchOutputStruct().setUlRowQty(pCINV91DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg670.getArchOutputStruct().setBMoreDataInd(pCINV91DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        
        return rc;
    }

    static int CallCINV17D(CINV44SI pInputMsg721, CINV44SO pOutputMsg671, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i360 = 0;
        
        /*
        ** Declare local variables
        */
        CINV17DI pCINV17DInputRec = null;
        CINV17DO pCINV17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV17DInputRec = new CINV17DI();
        
        pCINV17DOutputRec = new CINV17DO();
        pCINV17DInputRec.setArchInputStruct(pInputMsg721.getArchInputStruct());
        pCINV17DInputRec.setUlIdStage(pInputMsg721.getUlIdStage());
        
        rc = cinv17dQUERYdam(sqlca, pCINV17DInputRec, pCINV17DOutputRec);
        /**************************************************************************
        ** (END): Retrieve DAM: csec24d     ** Resource simple retrieve
        **************************************************************************/
        /* SIR#3582: PRS F/A Home was substituted for NON_PAID */
        /* SIR 14938:  Added PACE to the if statment below.    */
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg671.setCdAllegDisposition(pCINV17DOutputRec.getSzCdFacilInvstOvrallDis());
            pOutputMsg671.setUlIdEvent(pCINV17DOutputRec.getUlIdEvent());
            
        }
        return rc;
    }

    static int CallCINV44D(CINV44SI pInputMsg722, CINV44SO pOutputMsg672, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    {
        int rc = 0;
        int i361 = 0;
        
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
        
        pCINV44DInputRec.setArchInputStruct(pInputMsg722.getArchInputStruct());
        pCINV44DInputRec.setUlIdStage(pInputMsg722.getUlIdStage());
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        rc = cinv44dQUERYdam(sqlca, pCINV44DInputRec, pCINV44DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg672.setCdAllegDisposition(pCINV44DOutputRec.getROWCINV44DO().getSzcdApsInvstOvrallDisp());
                pOutputMsg672.setUlIdEvent(pCINV44DOutputRec.getROWCINV44DO().getUlIdEvent());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV74D(CINV44SI pInputMsg723, CINV44SO pOutputMsg673, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables 
        */
        int rc = 0;
        int i362 = 0;
        
        /*
        ** Declare local variables
        */
        CINV74DI pCINV74DInputRec = null;
        CINV74DO pCINV74DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV74DInputRec = new CINV74DI();
        
        pCINV74DOutputRec = new CINV74DO();
        pCINV74DInputRec.setArchInputStruct(pInputMsg723.getArchInputStruct());
        pCINV74DInputRec.setUlIdStage(pInputMsg723.getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = cinv74dQUERYdam(sqlca, pCINV74DInputRec, pCINV74DOutputRec);
        
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg673.setCdAllegDisposition(pCINV74DOutputRec.getSzCdLicngInvstOvrallDisp());
            pOutputMsg673.setUlIdEvent(pCINV74DOutputRec.getUlIdEvent());
        }
        return rc;
    }

    
    static int CallCINV95D(CINV44SI pInputMsg724, CINV44SO pOutputMsg674, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i363 = 0;
        
        /*
        ** Declare local variables
        */
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV95DInputRec = new CINV95DI();
        
        pCINV95DOutputRec = new CINV95DO();
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCINV95DInputRec.setArchInputStruct(pInputMsg724.getArchInputStruct());
        pCINV95DInputRec.setUlIdStage(pInputMsg724.getUlIdStage());
        
        /*
        ** Call CSES06D
        */
        rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg674.setCdAllegDisposition(pCINV95DOutputRec.getCdCpsOverallDisptn());
                pOutputMsg674.setUlIdEvent(pCINV95DOutputRec.getUlIdEvent());
                
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                  sprintf(pReturnPB->appl_status.explan_data,
                //##                          "%u",
                //##                          usRow);
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    
    static int CallCCMN45D(CINV44SI * pInputMsg725, CINV44SO pOutputMsg675, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        
        int rc = 0;
        int i364 = 0;
        
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
        pCCMN45DInputRec.setUlIdEvent(pOutputMsg675.getUlIdEvent());
        
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                if (pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus().compareTo(EVENT_STATUS_PENDING) != 0) {
                    pOutputMsg675.setUlIdEvent(0);
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCLSC59D(CINV44SI pInputMsg726, CINV44SO * pOutputMsg676, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        int i365 = 0;
        int bIndFoundSub = 0;
        CLSC59DI pCLSC59DInputRec = null;
        CLSC59DO pCLSC59DOutputRec = null;
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC59DInputRec = new CLSC59DI();
        
        pCLSC59DOutputRec = new CLSC59DO();
        pCLSC59DInputRec.setArchInputStruct(pInputMsg726.getArchInputStruct());
        pCLSC59DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC59DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC59DO._CLSC59DO__ROWCLSC59DO_SIZE);
        pCLSC59DInputRec.setUlIdCase(pInputMsg726.getUlIdCase());
        
        
        
        
        /*
        ** Start Performance Timer
        */
        rc = clsc59dQUERYdam(sqlca, pCLSC59DInputRec, pCLSC59DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Loop through all the rows returned by the dam and
                // see if there have been any SUBcare or Family SUbcare
                // stages opened
                for (i365 = 0;i365 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();i365++) {
                    if (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i365).getSzCdStage().compareTo(INVESTIGATION)) {
                        pInputMsg726.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i365).getUlIdStage());
                        
                        break;
                    }
                }
                
                // 
                // End Call to Primary Staff Simple Dam - CAUD75D
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
                
        }
        return rc;
    }

}
