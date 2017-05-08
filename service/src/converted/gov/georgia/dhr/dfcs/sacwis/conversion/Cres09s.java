package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES05DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07DO;
/**************************************************************************
** 
** Module File:   CRES09S.src
**
** Service Name:  CRES09S
**
** Description:   Retreives all data necessary to populate
**                Rsrcity Detail Window
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  5/24/95
** 
** Programmer:    Mark Cinque
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:23:28  $
**                      $Modtime:   05 Aug 1996 16:49:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                      added the line.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cres09s {
    public static final int INITIAL_PAGE = 1;
    public static final String CRES05D_DAM_NAME = "CRES05D";
    public static final String CRES06D_DAM_NAME = "CRES06D";
    public static final String CRES07D_DAM_NAME = "CRES07D";
    CRES09SO CRES09S(CRES09SI cres09si) {
        CRES09SO cres09so = new CRES09SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cres09si.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = CallCRES05D(cres09si, cres09so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCRES06D(cres09si, cres09so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCRES07D(cres09si, cres09so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cres09si.getArchInputStruct() , cres09so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  Populate DAM input structure for CCMN43D
            // Begin populating the CCMN43DI by calling CINT40D.
            // This DAM will retrieve the ID CASE for the stage.
            
            //  To-Do Arch Enh BEGIN
            // The To-Do Common Function is being modified to support
            // non-case-related to-dos.  Since the case and worker
            // information doesn't exist for non-case-related to-dos, we
            // shouldn't call the DAMs that retrieve that information.
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
        return cres09so;
    }

    static int CallCRES05D(CRES09SI pInputMsg818, CRES09SO pOutputMsg765, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code     */
        
        /* 
        ** Declare local variables
        */
        CRES05DI pCRES05DInputRec = null;
        CRES05DO pCRES05DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES05DInputRec = new CRES05DI();
        
        
        pCRES05DOutputRec = new CRES05DO();
        pCRES05DInputRec.setArchInputStruct(pInputMsg818.getArchInputStruct());
        pCRES05DInputRec.setUlIdResource(pInputMsg818.getUlIdResource());
        rc = cres05dQUERYdam(sqlca, pCRES05DInputRec, pCRES05DOutputRec);
        switch (rc) {
                // person may not yet have a designated ethnicity
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg765.setSzCdRsrcCertBy(pCRES05DOutputRec.getSzCdRsrcCertBy());
                
                pOutputMsg765.setSzCdRsrcOperBy(pCRES05DOutputRec.getSzCdRsrcOperBy());
                
                // 
                // Service Macro Definitions
                // 
                
                
                // 
                // Function Prototypes
                // 
                
                pOutputMsg765.setSzCdRsrcSetting(pCRES05DOutputRec.getSzCdRsrcSetting());
                pOutputMsg765.setSzCdRsrcPayment(pCRES05DOutputRec.getSzCdRsrcPayment());
                pOutputMsg765.setDtDtRsrcCert(pCRES05DOutputRec.getDtDtRsrcCert());
                
                pOutputMsg765.setDtDtRsrcClose(pCRES05DOutputRec.getDtDtRsrcClose());
                pOutputMsg765.setUNbrRsrcFacilCapacity(pCRES05DOutputRec.getUNbrRsrcFacilCapacity());
                pOutputMsg765.setTsLastUpdate(pCRES05DOutputRec.getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
            default :
                
                
                // 
                // SIR 1972: Do not populate 
                // pOutputMsg->dtDtCaseOpened 
                // with the date "DT_CASE_OPENED" on the 
                // CAPS_CASE table. 
                // Instead created and added DAM CLSC69D to retrieve the 
                // "DT_INCOMING_CALL" from the INCOMING_DETAIL table for
                // the Intake stage of the given ID_CASE.
                // 
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES06D(CRES09SI pInputMsg819, CRES09SO pOutputMsg766, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i411 = 0;
        
        /*
        ** Declare local variables
        */
        CRES06DI pCRES06DInputRec = null;
        CRES06DO pCRES06DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES06DInputRec = new CRES06DI();
        pCRES06DOutputRec = new CRES06DO();
        pCRES06DInputRec.setUlIdSpecSvcRsrc(pInputMsg819.getUlIdResource());
        pCRES06DInputRec.setArchInputStruct(pInputMsg819.getArchInputStruct());
        pCRES06DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        
        pCRES06DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES09SO._CRES09SO__ROWCRES06DO_SIZE);
        
        /*
        ** Call DAM
        */
        rc = cres06dQUERYdam(sqlca, pCRES06DInputRec, pCRES06DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i411 = 0;i411 < pCRES06DOutputRec.getArchOutputStruct().getUlRowQty();++i411) {
                    
                    pOutputMsg766.getROWCRES06DO_ARRAY().setROWCRES06DO(i411, pCRES06DOutputRec.getROWCRES06DO_ARRAY().getROWCRES06DO(i411));
                }
                pOutputMsg766.setUlRowQty(pCRES06DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg766.setUlRowQty(0);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES07D(CRES09SI pInputMsg820, CRES09SO pOutputMsg767, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i412 = 0;
        
        /*
        ** Declare local variables
        */
        CRES07DI pCRES07DInputRec = null;
        CRES07DO pCRES07DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES07DInputRec = new CRES07DI();
        pCRES07DOutputRec = new CRES07DO();
        pCRES07DInputRec.setUlIdResource(pInputMsg820.getUlIdResource());
        pCRES07DInputRec.setArchInputStruct(pInputMsg820.getArchInputStruct());
        pCRES07DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCRES07DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES09SO._CRES09SO__ROWCRES07DO_SIZE);
        rc = cres07dQUERYdam(sqlca, pCRES07DInputRec, pCRES07DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i412 = 0;i412 < pCRES07DOutputRec.getArchOutputStruct().getUlRowQty();++i412) {
                    pOutputMsg767.getROWCRES07DO_ARRAY().setROWCRES07DO(i412, pCRES07DOutputRec.getROWCRES07DO_ARRAY().getROWCRES07DO(i412));
                }
                pOutputMsg767.setUlRowQty2(pCRES07DOutputRec.getArchOutputStruct().getUlRowQty());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg767.setUlRowQty2(0);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
                //   PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

}
