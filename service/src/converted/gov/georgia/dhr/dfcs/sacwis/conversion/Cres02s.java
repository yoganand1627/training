package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES28DO;
/**************************************************************************
**
** Module File:   CRES02S.src
**
** Service Name:  CRES02S
**
** Description:   Home/Sub List:  Retrieves a list of subcontractors of a
**                resource, or homes into which an agency can place clients.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/18/95
**
** Programmer:    Mark Cinque
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cres02s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String AGENCY_LINK_TYPE = "02";
    CRES02SO CRES02S(CRES02SI cres02si) {
        CRES02SO cres02so = new CRES02SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i396 = 0;
        rc = ARC_PRFServiceStartTime_TUX(cres02si.getArchInputStruct());
        rc = CallCRES02D(cres02si, cres02so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (!(cres02si.getSzCdRsrcLinkType().compareTo(AGENCY_LINK_TYPE) != 0) && cres02so.getArchOutputStruct().getUlRowQty() != 0) {
            rc = CallCRES28D(cres02si, cres02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cres02si.getArchInputStruct() , cres02so.getArchOutputStruct());
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
        return cres02so;
    }

    static int CallCRES02D(CRES02SI pInputMsg802, CRES02SO pOutputMsg747, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i397 = 0;
        
        /*
        ** Declare local variables
        */
        CRES02DI pCRES02DInputRec = null;
        CRES02DO pCRES02DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES02DInputRec = new CRES02DI();
        pCRES02DOutputRec = new CRES02DO();
        pCRES02DInputRec.setUlIdResource(pInputMsg802.getUlIdResource());
        pCRES02DInputRec.setSzCdRsrcLinkType(pInputMsg802.getSzCdRsrcLinkType());
        pCRES02DInputRec.setArchInputStruct(pInputMsg802.getArchInputStruct());
        rc = cres02dQUERYdam(sqlca, pCRES02DInputRec, pCRES02DOutputRec);
        
        /*
        ** Analyze error code
        */
        
        switch (rc) {
                
            case SUCCESS:
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = null;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
                break;
                
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        
        /*
        ** Populate Output Message
        */
        for (i397 = 0;i397 < pCRES02DOutputRec.getArchOutputStruct().getUlRowQty();++i397) {
            pOutputMsg747.getCRES02SOG01_ARRAY().getCRES02SOG01(i397).setSzNmResource(pCRES02DOutputRec.getROWCRES02DO_ARRAY().getROWCRES02DO(i397).getSzNmResource());
            pOutputMsg747.getCRES02SOG01_ARRAY().getCRES02SOG01(i397).setUlIdResource(pCRES02DOutputRec.getROWCRES02DO_ARRAY().getROWCRES02DO(i397).getUlIdResource());
            pOutputMsg747.getCRES02SOG01_ARRAY().getCRES02SOG01(i397).setSzCdRsrcSvcCnty(pCRES02DOutputRec.getROWCRES02DO_ARRAY().getROWCRES02DO(i397).getSzCdRsrcSvcCnty());
            pOutputMsg747.getCRES02SOG01_ARRAY().getCRES02SOG01(i397).setSzCdRsrcFacilType(pCRES02DOutputRec.getROWCRES02DO_ARRAY().getROWCRES02DO(i397).getSzCdRsrcFacilType());
            pOutputMsg747.getCRES02SOG01_ARRAY().getCRES02SOG01(i397).setLNbrRsrcFacilAcclaim(pCRES02DOutputRec.getROWCRES02DO_ARRAY().getROWCRES02DO(i397).getLNbrRsrcFacilAcclaim());
        };
        pOutputMsg747.getArchOutputStruct().setUlRowQty(pCRES02DOutputRec.getArchOutputStruct().getUlRowQty());
        pOutputMsg747.getArchOutputStruct().setBMoreDataInd(pCRES02DOutputRec.getArchOutputStruct().getBMoreDataInd());
        return rc;
    }

    static int CallCRES28D(CRES02SI pInputMsg803, CRES02SO pOutputMsg748, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i398 = 0;
        int j = 0;
        
        /*
        ** Declare local variables
        */
        CRES28DI pCRES28DInputRec = null;
        CRES28DO pCRES28DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES28DInputRec = new CRES28DI();
        pCRES28DInputRec = 0x00;
        
        pCRES28DOutputRec = new CRES28DO();
        pCRES28DOutputRec = 0x00;
        
        /*
        **  Loop through every row in pOutputMsg, retrieve LOCs for that service,
        **  format a string containing all active LOCs, and store that string in
        **  pOutputMsg.
        */
        for (i398 = 0;i398 < pOutputMsg748.getArchOutputStruct().getUlRowQty();i398++) {
            pCRES28DInputRec.setUlIdResource(pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).getUlIdResource());
            pCRES28DInputRec.setArchInputStruct(pInputMsg803.getArchInputStruct());
            
            
            // Set rc to ARC_SUCCESS
            rc = cres28dQUERYdam(sqlca, pCRES28DInputRec, pCRES28DOutputRec);
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setSNbrFlocLevelsOfCare(pCRES28DOutputRec.getSNbrFlocLevelsOfCare());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setDtDtFlocEffect(pCRES28DOutputRec.getDtDtFlocEffect());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus1(pCRES28DOutputRec.getCCdFlocStatus1());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus2(pCRES28DOutputRec.getCCdFlocStatus2());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus3(pCRES28DOutputRec.getCCdFlocStatus3());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus4(pCRES28DOutputRec.getCCdFlocStatus4());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus5(pCRES28DOutputRec.getCCdFlocStatus5());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus6(pCRES28DOutputRec.getCCdFlocStatus6());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus7(pCRES28DOutputRec.getCCdFlocStatus7());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus8(pCRES28DOutputRec.getCCdFlocStatus8());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus9(pCRES28DOutputRec.getCCdFlocStatus9());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus10(pCRES28DOutputRec.getCCdFlocStatus10());
            
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus11(pCRES28DOutputRec.getCCdFlocStatus11());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus12(pCRES28DOutputRec.getCCdFlocStatus12());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus13(pCRES28DOutputRec.getCCdFlocStatus13());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus14(pCRES28DOutputRec.getCCdFlocStatus14());
            pOutputMsg748.getCRES02SOG01_ARRAY().getCRES02SOG01(i398).setCCdFlocStatus15(pCRES28DOutputRec.getCCdFlocStatus15());
        }
        return rc;
    }

}
