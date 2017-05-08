package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES55DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES58DO;
/**************************************************************************
**
** Module File:   cres18s.src
**
** Service Name:  cres18s
**
** Description:   This service calls one dam:
**
** CRES18D Dam:
**                input:  one variable required:
**                        ID_RESOURCE
**
**               output:  Data for CARE TAKER window
**
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  8/31/98
**
** Programmer:    Habib Hadjimani
**
** Archive Information: $Revision:   1.0
**                      $Date:   04 Feb 2000 13:43:38
**                      $Modtime:   28 Jan 2000 11:09:00
**                      $Author:   pvcs
**
** Change History:
**  3/7/2002    Hadjimh SIR#15840. Added the Cd_Home_Marital_Status to the
**                      output of the CRES55D dam.
**  09/24/05    Reedlg  SIR 23777 - Split RACE from ETHNICITY in CRES55D, CRES56D.
**
***************************************************************************/

/********** service include files *****************************************/



/*
** Extern for version control table.
*/






public class Cres18s {
    CRES18SO CRES18S(CRES18SI cres18si) {
        CRES18SO cres18so = new CRES18SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cres18si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cres18so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Analyze return code
        */
        switch (cres18si.getArchInputStruct().getCReqFuncCd()) {
                
            case 'C':
                rc = CallCRES55D(cres18si, cres18so, pServiceStatus);
                break;
                
            case 'S':
                
                //  Call CLSC14D
                rc = CallCRES57D(cres18si, cres18so, pServiceStatus);
                break;
                
            case WtcHelperConstants.REQ_FUNC_CD_ADD:
            case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                
            case WtcHelperConstants.REQ_FUNC_CD_DELETE:
                
                // Analyze error code
                if (cres18si.getCIndCaretakerUpd() == '1') {
                    rc = CallCRES58D(cres18si, cres18so, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                        case Messages.MSG_NO_ROWS_RETURNED:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
                rc = CallCRES56D(cres18si, cres18so, pServiceStatus);
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        
        /* load translation map with service name and version */
        
        /* stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(cres18si.getArchInputStruct() , cres18so.getArchOutputStruct());
        
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
        return cres18so;
    }

    static int CallCRES55D(CRES18SI pInputMsg825, CRES18SO pOutputMsg772, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i415 = 0;
        /* local variables */
        String sztemp = new String();
        CRES55DI pCRES55DInputRec = null;
        CRES55DO pCRES55DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCRES55DInputRec = new CRES55DI();
        
        pCRES55DOutputRec = new CRES55DO();
        pCRES55DInputRec.setArchInputStruct(pInputMsg825.getArchInputStruct());
        pCRES55DInputRec.setUlIdResource(pInputMsg825.getUlIdResource());
        rc = cres55dQUERYdam(sqlca, pCRES55DInputRec, pCRES55DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i415 = 0;i415 < pCRES55DOutputRec.getArchOutputStruct().getUlRowQty();++i415) {
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setIdCaretaker(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getIdCaretaker());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setSzNmCaretkrFname(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getSzNmCaretkrFname());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setSzNmCaretkrLname(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getSzNmCaretkrLname());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setSzNmCaretkrMname(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getSzNmCaretkrMname());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setCdCaretkrEthnic(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getCdCaretkrEthnic());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setCdCaretkrRace(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getCdCaretkrRace());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setCdCaretkrSex(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getCdCaretkrSex());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setDtCaretkrBirth(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getDtCaretkrBirth());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setNbrCaretkr(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getNbrCaretkr());
                    pOutputMsg772.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).setCd_Home_Marital_Status(pCRES55DOutputRec.getROWCRES55DO_ARRAY().getROWCRES55DO(i415).getCd_Home_Marital_Status());
                }
                pOutputMsg772.getArchOutputStruct().setUlRowQty(pCRES55DOutputRec.getArchOutputStruct().getUlRowQty());
                
                //  Start performance timer for service
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                // SIR 21891 - missing versioning
                //  Run-time Versioning
                
                //  Check buffer size
                
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                // get the system date
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCRES57D(CRES18SI pInputMsg826, CRES18SO pOutputMsg773, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i416 = 0;
        /* local variables */
        CRES57DI pCRES57DInputRec = null;
        CRES57DO pCRES57DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCRES57DInputRec = new CRES57DI();
        
        pCRES57DOutputRec = new CRES57DO();
        pCRES57DInputRec.setArchInputStruct(pInputMsg826.getArchInputStruct());
        pCRES57DInputRec.setUlIdResource(pInputMsg826.getUlIdResource());
        rc = cres57dQUERYdam(sqlca, pCRES57DInputRec, pCRES57DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg773.setUlIdResource(pCRES57DOutputRec.getUlIdResource());
                pOutputMsg773.setUlHmResourceId(pCRES57DOutputRec.getUlHmResourceId());
                pOutputMsg773.setSzCpaName(pCRES57DOutputRec.getSzCpaName());
                pOutputMsg773.setSzNmResource(pCRES57DOutputRec.getSzNmResource());
                
                pOutputMsg773.setCd_Home_Marital_Status(pCRES57DOutputRec.getCd_Home_Marital_Status());
                
                // 
                // Function Prototypes
                // 
                pOutputMsg773.getArchOutputStruct().setUlRowQty(pCRES57DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                //  Call DAM
                rc = Messages.MSG_NO_ROWS_RETURNED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCRES56D(CRES18SI pInputMsg827, CRES18SO * pOutputMsg774, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i417 = 0;
        /* local variables */
        CRES56DI pCRES56DInputRec = null;
        CRES56DO pCRES56DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCRES56DInputRec = new CRES56DI();
        
        pCRES56DOutputRec = new CRES56DO();
        pCRES56DInputRec.setArchInputStruct(pInputMsg827.getArchInputStruct());
        pCRES56DInputRec.setIdCaretaker(pInputMsg827.getIdCaretaker());
        pCRES56DInputRec.setUlIdResource(pInputMsg827.getUlIdResource());
        pCRES56DInputRec.setSzNmCaretkrFname(pInputMsg827.getSzNmCaretkrFname());
        pCRES56DInputRec.setSzNmCaretkrLname(pInputMsg827.getSzNmCaretkrLname());
        pCRES56DInputRec.setSzNmCaretkrMname(pInputMsg827.getSzNmCaretkrMname());
        pCRES56DInputRec.setCdCaretkrEthnic(pInputMsg827.getCdCaretkrEthnic());
        pCRES56DInputRec.setCdCaretkrRace(pInputMsg827.getCdCaretkrRace());
        
        pCRES56DInputRec.setCdCaretkrSex(pInputMsg827.getCdCaretkrSex());
        pCRES56DInputRec.setDtCaretkrBirth(pInputMsg827.getDtCaretkrBirth());
        rc = cres56dAUDdam(sqlca, pCRES56DInputRec, pCRES56DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES58D(CRES18SI pInputMsg828, CRES18SO * pOutputMsg775, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i418 = 0;
        /* local variables */
        CRES58DI pCRES58DInputRec = null;
        CRES58DO pCRES58DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCRES58DInputRec = new CRES58DI();
        
        pCRES58DOutputRec = new CRES58DO();
        pCRES58DInputRec.setArchInputStruct(pInputMsg828.getArchInputStruct());
        pCRES58DInputRec.setUlIdResource(pInputMsg828.getUlIdResource());
        pCRES58DInputRec.setCd_Home_Marital_Status(pInputMsg828.getCd_Home_Marital_Status());
        
        
        /*
        ** Call CINV51D
        */
        rc = cres58dAUDdam(sqlca, pCRES58DInputRec, pCRES58DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
