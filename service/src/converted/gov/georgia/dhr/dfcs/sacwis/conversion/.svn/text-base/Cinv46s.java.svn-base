package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV69DO;
/**************************************************************************
** 
** Module File:   CINV46S.src
**
** Service Name:  CINV46S
**
** Description:   Retrieves the record for the Allegation Detail window.
**                Uses CINV06D and CINV69D
**                
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  27 MAR 95
** 
** Programmer:    WHW
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 18:23:28  $
**                      $Modtime:   30 Mar 1996 00:18:04  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/06/95    KRD     SIR 1610 - Modified CallCINV69D() to return
**                      szNmPersonFull to the window rather than
**                      szNmNameFirst, szNmNameMiddle, and szNmNameLast.
**                      Superficial changes to match the Release 1.x
**                      service shell.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv46s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int NO_ALLEGATIONS = 0;
    CINV46SO CINV46S(CINV46SI cinv46si) {
        CINV46SO cinv46so = new CINV46SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cinv46si.getArchInputStruct());
        if (NO_ALLEGATIONS != cinv46si.getUlIdAllegation()) {
            rc = CallCINV06D(cinv46si, cinv46so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_NO_ROWS_RETURNED:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        rc = Cinv07s.CallCINV69D(cinv46si, cinv46so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Call DAM
        */
        rc = ARC_UTLGetDateAndTime(cinv46so.getDtDtTodaysDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cinv46si.getArchInputStruct() , cinv46so.getArchOutputStruct());
        
        
        /*
        ** Create ToDo Processing
        */
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
        return cinv46so;
    }

    static int CallCINV06D(CINV46SI pInputMsg743, CINV46SO pOutputMsg693, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINV06DI pCINV06DInputRec = null;
        CINV06DO pCINV06DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV06DInputRec = new CINV06DI();
        
        pCINV06DOutputRec = new CINV06DO();
        pCINV06DInputRec.setArchInputStruct(pInputMsg743.getArchInputStruct());
        pCINV06DInputRec.setUlIdAllegation(pInputMsg743.getUlIdAllegation());
        rc = cinv06dQUERYdam(sqlca, pCINV06DInputRec, pCINV06DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  SQL Not Found Case for Dam CSES68D (CAA)
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg693.setCdAllegDisposition(pCINV06DOutputRec.getCdAllegDisposition());
                pOutputMsg693.setSzCdAllegIncidentStage(pCINV06DOutputRec.getSzCdAllegIncidentStage());
                pOutputMsg693.setSzCdAllegSeverity(pCINV06DOutputRec.getSzCdAllegSeverity());
                
                pOutputMsg693.setSzCdAllegType(pCINV06DOutputRec.getSzCdAllegType());
                pOutputMsg693.setSzTxtAllegDuration(pCINV06DOutputRec.getSzTxtAllegDuration());
                pOutputMsg693.setTsLastUpdate(pCINV06DOutputRec.getTsLastUpdate());
                break;
                
                //  Success Case for Dam CSES68D (OPS)
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                //  Call DAM
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV69D(CINV46SI pInputMsg744, CINV46SO pOutputMsg694, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i376 = 0;
        
        /*
        ** Declare local variables
        */
        CINV69DI pCINV69DInputRec = null;
        CINV69DO pCINV69DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV69DInputRec = new CINV69DI();
        
        pCINV69DOutputRec = new CINV69DO();
        pCINV69DInputRec.setArchInputStruct(pInputMsg744.getArchInputStruct());
        pCINV69DInputRec.setUlIdStage(pInputMsg744.getUlIdStage());
        rc = cinv69dQUERYdam(sqlca, pCINV69DInputRec, pCINV69DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                //  Populate Output Message
                for (i376 = 0;i376 < pCINV69DOutputRec.getArchOutputStruct().getUlRowQty();++i376) {
                    
                    pOutputMsg694.getCINV46SOG1_ARRAY().getCINV46SOG1(i376).setUlIdPerson(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i376).getUlIdPerson());
                    pOutputMsg694.getCINV46SOG1_ARRAY().getCINV46SOG1(i376).setSzNmPersonFull(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i376).getSzNmPersonFull());
                    pOutputMsg694.getCINV46SOG1_ARRAY().getCINV46SOG1(i376).setSzCdPersonMaritalStatus(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i376).getSzCdPersonMaritalStatus());
                    pOutputMsg694.getCINV46SOG1_ARRAY().getCINV46SOG1(i376).setDtDtPersonBirth(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i376).getDtDtPersonBirth());
                    pOutputMsg694.getCINV46SOG1_ARRAY().getCINV46SOG1(i376).setSzCdStagePersRole(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i376).getSzCdStagePersRole());
                    pOutputMsg694.getCINV46SOG1_ARRAY().getCINV46SOG1(i376).setTsLastUpdate(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i376).getTsLastUpdate());
                };
                pOutputMsg694.getArchOutputStruct().setUlRowQty(pCINV69DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg694.getArchOutputStruct().setBMoreDataInd(pCINV69DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                
                //  Call CAUD08D The Contract County AUD performs a full row insert,
                // update or delete to the Contract County table.
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
