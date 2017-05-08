package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES10SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES19DO;
/**************************************************************************
**
** Module File:   CRES10S.src
**
** Service Name:  CRES10S
**
** Description:   Updates all enterable fields from Facility Detail Window
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  5/24/95
**
** Programmer:    Mark Cinque
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   16 Aug 1996 09:36:06  $
**                      $Modtime:   15 Aug 1996 17:28:00  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                      I added the lines.
**
**  08/15/96  VANDERM   SIR 21968 - Database needs to be returned to its
**                      original state when errors are encountered.
**                      Error handling changed from FND_SEVERITY to
**                      FND_SEVERITY_ERROR.
**  02/16/05  reedlg    SIR 18351 - update caps_resource.nm_rsrc_last_update
**                      to populate name of last person to update data.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cres10s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String CRES17D_DAM_NAME = "CRES17D";
    public static final String CRES18D_DAM_NAME = "CRES18D";
    public static final String CRES19D_DAM_NAME = "CRES19D";
    CRES10SO CRES10S(CRES10SI cres10si) {
        CRES10SO cres10so = new CRES10SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i413 = 0;
        rc = ARC_PRFServiceStartTime_TUX(cres10si.getArchInputStruct());
        rc = CallCRES17D(cres10si, cres10so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            case Messages.MSG_CMN_UPDATE_FAILED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        rc = CallCRES18D(cres10si, cres10so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            case Messages.MSG_CMN_UPDATE_FAILED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = CallCRES19D(cres10si, cres10so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            case Messages.MSG_CMN_UPDATE_FAILED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cres10si.getArchInputStruct() , cres10so.getArchOutputStruct());
        /*
        ** RIOSJA, SIR 16123 - APRV'D Former
        ** CPS Day Care service auths can remain
        ** open whether or not an eligible stage
        ** exists to which we can progress them.
        ** Do not set the bSvcAuthsToProgress
        ** flag to TRUE for Former CPS Day Care
        ** service auths.
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //  When this is not the last stage in the case, we don't
            // want any SvcAuths that are above COMPlete to have a term
            // date greater than today (unless the Service Code is 40M)
            // Otherwise, the SvcAuths are NEW or PROC and we don't
            // give edit checks on these
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
        return cres10so;
    }

    static int CallCRES17D(CRES10SI pInputMsg821, CRES10SO * pOutputMsg768, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES17DI pCRES17DInputRec = null;
        CRES17DO pCRES17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES17DInputRec = new CRES17DI();
        
        pCRES17DOutputRec = new CRES17DO();
        pCRES17DInputRec.setUlIdResource(pInputMsg821.getUlIdResource());
        pCRES17DInputRec.setSzCdRsrcCertBy(pInputMsg821.getSzCdRsrcCertBy());
        pCRES17DInputRec.setSzCdRsrcOperBy(pInputMsg821.getSzCdRsrcOperBy());
        pCRES17DInputRec.setSzCdRsrcSetting(pInputMsg821.getSzCdRsrcSetting());
        pCRES17DInputRec.setSzCdRsrcPayment(pInputMsg821.getSzCdRsrcPayment());
        pCRES17DInputRec.setDtDtRsrcCert(pInputMsg821.getDtDtRsrcCert());
        pCRES17DInputRec.setDtDtRsrcClose(pInputMsg821.getDtDtRsrcClose());
        pCRES17DInputRec.setUNbrRsrcFacilCapacity(pInputMsg821.getUNbrRsrcFacilCapacity());
        pCRES17DInputRec.setTsLastUpdate(pInputMsg821.getTsLastUpdate());
        pCRES17DInputRec.setSzNmRsrcLastUpdate(pInputMsg821.getSzNmRsrcLastUpdate());
        pCRES17DInputRec.setArchInputStruct(pInputMsg821.getArchInputStruct());
        rc = cres17dAUDdam(sqlca, pCRES17DInputRec, pCRES17DOutputRec);
        switch (rc) /* cses01d */
        {
                
                // Do not free(pCSEC33DInputRec) NOW.  It is freed BELOW.
                
                // 
                // End Contract Validate for REQUESTED. BLOC DtEnd = DtPlcmtStart 
                // 
                
                
            case WtcHelperConstants.SQL_SUCCESS:
                // SIR #5057: Code that sets the search criteria has
                // been moved inside CreateNEWContacts
                //  SIR 14291 - set the third parameter, sFaceToFaceExists, to false.
                // this will allow the to dos to key from the date the contact occurred,
                // not the system date.
                
                // SIR 23918 - add the condition here to check if empty the contact shell
                // is already created if yes : do not create the new contact,else create new one.
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                // SIR #5057: Code that sets the search criteria has
                // been moved inside CreateNEWContacts
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES18D(CRES10SI pInputMsg822, CRES10SO * pOutputMsg769, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rownum = 0;
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        CRES18DI pCRES18DInputRec = null;
        CRES18DO pCRES18DOutputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCRES18DInputRec = new CRES18DI();
        
        /*
        ** Allocate memory for Output Structure
        */
        pCRES18DOutputRec = new CRES18DO();
        
        /*
        ** Call DAM for every row
        */
        for (rownum = 0;rownum < pInputMsg822.getUlRowQty();rownum++) {
            pCRES18DInputRec.setArchInputStruct(pInputMsg822.getArchInputStruct());
            pCRES18DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg822.getCRES10SIG00_ARRAY().getCRES10SIG00(rownum).getSzCdScrDataAction());
            pCRES18DInputRec.setUlIdSpecSvc(pInputMsg822.getCRES10SIG00_ARRAY().getCRES10SIG00(rownum).getUlIdSpecSvc());
            pCRES18DInputRec.setUlIdSpecSvcRsrc(pInputMsg822.getCRES10SIG00_ARRAY().getCRES10SIG00(rownum).getUlIdSpecSvcRsrc());
            pCRES18DInputRec.setSzCdSpecSvcs(pInputMsg822.getCRES10SIG00_ARRAY().getCRES10SIG00(rownum).getSzCdSpecSvcs());
            pCRES18DInputRec.setTsLastUpdate(pInputMsg822.getCRES10SIG00_ARRAY().getCRES10SIG00(rownum).getTsLastUpdate());
            //  Populate output message
            // for ( i=0; i<pCLSC63DOutputRec->ArchOutputStruct.ulRowQty; ++i )
            // {
            // pOutputMsg->ROWCLSS58DO[i].ulIdIncRsrc =
            // pCLSC63DOutputRec->ROWCLSC63DO[i].ulIdIncRsrc;
            // }  end for loop
            
            
            rc = cres18dAUDdam(sqlca, pCRES18DInputRec, pCRES18DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                    
                    // case SQL_NOT_FOUND:
                    // pServiceStatus->severity = FND_SEVERITY_ERROR;
                    // pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                    // RetVal = FND_SUCCESS;
                    // rc = MSG_CMN_TMSTAMP_MISMATCH;
                    // break;
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    // pOutputMsg->ArchOutputStruct.ulRowQty = 0;
                    // pOutputMsg->ArchOutputStruct.bMoreDataInd =
                    // pCLSC63DOutputRec->ArchOutputStruct.bMoreDataInd;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCRES19D(CRES10SI pInputMsg823, CRES10SO * pOutputMsg770, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rownum = 0;
        int rc = WtcHelperConstants.ARC_SUCCESS;
        CRES19DI pCRES19DInputRec = null;
        CRES19DO pCRES19DOutputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCRES19DInputRec = new CRES19DI();
        
        /*
        ** Allocate memory for Output Structure
        */
        pCRES19DOutputRec = new CRES19DO();
        
        /*
        ** Call DAM for every row
        */
        for (rownum = 0;rownum < pInputMsg823.getUlRowQty2();rownum++) {
            pCRES19DInputRec.setArchInputStruct(pInputMsg823.getArchInputStruct());
            pCRES19DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getSzCdScrDataAction());
            pCRES19DInputRec.setUlIdFloc(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getUlIdFloc());
            pCRES19DInputRec.setDtDtFlocEffect(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getDtDtFlocEffect());
            pCRES19DInputRec.setDtDtFlocEnd(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getDtDtFlocEnd());
            pCRES19DInputRec.setUlIdResource(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getUlIdResource());
            pCRES19DInputRec.setTsLastUpdate(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getTsLastUpdate());
            pCRES19DInputRec.setSNbrFlocLevelsOfCare(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getSNbrFlocLevelsOfCare());
            pCRES19DInputRec.setCCdFlocStatus1(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus1());
            pCRES19DInputRec.setCCdFlocStatus2(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus2());
            pCRES19DInputRec.setCCdFlocStatus3(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus3());
            pCRES19DInputRec.setCCdFlocStatus4(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus4());
            pCRES19DInputRec.setCCdFlocStatus5(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus5());
            pCRES19DInputRec.setCCdFlocStatus6(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus6());
            pCRES19DInputRec.setCCdFlocStatus7(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus7());
            pCRES19DInputRec.setCCdFlocStatus8(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus8());
            pCRES19DInputRec.setCCdFlocStatus9(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus9());
            pCRES19DInputRec.setCCdFlocStatus10(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus10());
            pCRES19DInputRec.setCCdFlocStatus11(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus11());
            pCRES19DInputRec.setCCdFlocStatus12(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus12());
            
            pCRES19DInputRec.setCCdFlocStatus13(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus13());
            pCRES19DInputRec.setCCdFlocStatus14(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus14());
            pCRES19DInputRec.setCCdFlocStatus15(pInputMsg823.getCRES10SIG01_ARRAY().getCRES10SIG01(rownum).getCCdFlocStatus15());
            
            //  Call DAM 82 to get TASK decode
            rc = cres19dAUDdam(sqlca, pCRES19DInputRec, pCRES19DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    
                    //  SIR 2217: Added DAM CINT21D to retrieve szCdStage, since I&R 
                    // intakes do not have a stage name, 
                    // which kills ccmn19d.
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    //  Call DAM 19 to get NM STAGE and primary worker
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

}
