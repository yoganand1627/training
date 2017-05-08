package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC69DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV57DO;
/**************************************************************************
** 
** Module File:   CINV23S.src
**
** Service Name:  CINV23S
**
** Description:   A retrieval service to obtain data from the External
**                Documentation table on the Oracle database
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2/20/95 
** 
** Programmer:    Terry T. Cavallaro
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
** 
**  01/08/96  BRUCKMK SIR 1972: Do not populate pOutputMsg->dtDtCaseOpened 
**            with the date "DT_CASE_OPENED" on the CAPS_CASE table.
**            Instead created and added DAM CLSC69D to retrieve the
**            "DT_INCOMING_CALL" from the INCOMING_DETAIL table for
**            the Intake stage of the given ID_CASE.
**
**  01/24/96  BRUCKMK SIR 2925: If no rows were returned from CLSC69D, this 
**            means that there is no Intake Stage for this Case.  
**            Therefore retrieve the DT_CASE_OPENED for the Case 
**            instead.
**
**  05/04/98  SOHNJJ    SIR #14298 - MHMR Enhancement Item 3: Allow the user
**                      to sort the items listed on the Facility Abuse/
**                      Neglect document and the External Documentation
**                      report.  Added the column, CD_EXT_DOC_SORT to the
**                      EXT_DOCUMENTATION table to store the user's sort
**                      order.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv23s {
    CINV23SO CINV23S(CINV23SI cinv23si) {
        CINV23SO cinv23so = new CINV23SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        
        /* Non-generated variables */
        CINV23SO CINV23SO = null;
        int lUnusedRows = 0;
        rc = ARC_PRFServiceStartTime_TUX(cinv23si.getArchInputStruct());
        rc = CallCINV26D(cinv23si, cinv23so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCLSC69D(cinv23si, cinv23so, pServiceStatus);
        switch (rc) {
            case SUCCESS:
                break;
                
            case Messages.MSG_NO_ROWS_RETURNED:
                rc = CallCINV57D(cinv23si, cinv23so, pServiceStatus);
                
                //  Analyze return code
                switch (rc) 
                {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_NO_ROWS_RETURNED:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        ARC_UTLGetDateAndTime(cinv23so.getDtWCDDtSystemDate() , 0);
        
        /* Load translation map with service name and version */
        
        /* Stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(cinv23si.getArchInputStruct() , cinv23so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) 
            {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv23so;
    }

    static int CallCINV26D(CINV23SI pInputMsg672, CINV23SO pOutputMsg622, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.SQL_SUCCESS;
        int i337 = 0;
        CINV26DI pCINV26DInputRec = null;
        CINV26DO pCINV26DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV26DInputRec = new CINV26DI();
        
        pCINV26DOutputRec = new CINV26DO();
        pCINV26DInputRec.setArchInputStruct(pInputMsg672.getArchInputStruct());
        pCINV26DInputRec.setUlIdCase(pInputMsg672.getUlIdCase());
        rc = cinv26dQUERYdam(sqlca, pCINV26DInputRec, pCINV26DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                // Populate Output Message
                for (i337 = 0;i337 < pCINV26DOutputRec.getArchOutputStruct().getUlRowQty();i337++) {
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).getDtDtExtDocObtained().day = pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getDtDtExtDocObtained().day;
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).getDtDtExtDocObtained().month = pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getDtDtExtDocObtained().month;
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).getDtDtExtDocObtained().year = pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getDtDtExtDocObtained().year;
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).setSzCdExtDocType(pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getSzCdExtDocType());
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).setSzTxtExtDocLocation(pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getSzTxtExtDocLocation());
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).setSzTxtExtDocDetails(pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getSzTxtExtDocDetails());
                    
                    
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).setUlIdExtSitInfo(pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getUlIdExtSitInfo());
                    
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).setTsLastUpdate(pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getTsLastUpdate());
                    pOutputMsg622.getROWCINV23SOG00_ARRAY().getROWCINV23SOG00(i337).setSzCdExtDocSort(pCINV26DOutputRec.getROWCINV26DO_ARRAY().getROWCINV26DO(i337).getSzCdExtDocSort());
                }
                pOutputMsg622.getArchOutputStruct().setUlRowQty(pCINV26DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg622.getArchOutputStruct().setBMoreDataInd(pCINV26DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg622.getArchOutputStruct().setUlRowQty(0);
                
                
                //  Call CAUD01D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCLSC69D(CINV23SI pInputMsg673, CINV23SO pOutputMsg623, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CLSC69DI pCLSC69DInputRec = null;
        CLSC69DO pCLSC69DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC69DInputRec = new CLSC69DI();
        
        pCLSC69DOutputRec = new CLSC69DO();
        pCLSC69DInputRec.setUlIdCase(pInputMsg673.getUlIdCase());
        pCLSC69DInputRec.setArchInputStruct(pInputMsg673.getArchInputStruct());
        
        
        /*
        ** Call CSES68D
        */
        rc = clsc69dQUERYdam(sqlca, pCLSC69DInputRec, pCLSC69DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg623.setDtDtCaseOpened(pCLSC69DOutputRec.getDtDtIncomingCall());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        return rc;
        
    }

    static int CallCINV57D(CINV23SI pInputMsg674, CINV23SO pOutputMsg624, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.SQL_SUCCESS;/* Return code */
        CINV57DI pCINV57DInputRec = null;
        CINV57DO pCINV57DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV57DInputRec = new CINV57DI();
        
        pCINV57DOutputRec = new CINV57DO();
        pCINV57DInputRec.setArchInputStruct(pInputMsg674.getArchInputStruct());
        pCINV57DInputRec.setUlIdCase(pInputMsg674.getUlIdCase());
        rc = cinv57dQUERYdam(sqlca, pCINV57DInputRec, pCINV57DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg624.setDtDtCaseOpened(pCINV57DOutputRec.getDtDtCaseOpened());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
