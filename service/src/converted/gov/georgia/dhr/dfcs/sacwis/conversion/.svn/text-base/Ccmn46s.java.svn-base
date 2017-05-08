package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB0DO;
/**************************************************************************
** 
** Module File:   CCMN46S.src
**
** Service Name:  CCMN46S - RTRV PHONE LST/DTL
**
** Description:   Retrieves information for the Phone List/Detail window.
**                It consists of only one DAM, CCMNB0D.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/21/95 
** 
** Programmer:    SPR
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   4/11/95  WEALANBC  Made some technical review changes. Implemented 
**                      several new additions to the server shell.
**
**  7/26/96    zabihin  sir 21891 : version control line was missing, I
**                      added the line.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn46s {
    CCMN46SO CCMN46S(CCMN46SI ccmn46si) {
        CCMN46SO ccmn46so = new CCMN46SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn46si.getArchInputStruct());
        rc = CCMNB0D(ccmn46si, ccmn46so, pServiceStatus);
        
        /*
        ** All edits for Code Type ACP are
        ** passed so set variables and
        ** calculate stage retention date
        */
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(ccmn46si.getArchInputStruct() , ccmn46so.getArchOutputStruct());
        
        /*
        ** Set Calculated Retention date to maximum date
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
        return ccmn46so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        
        
        /* Get the system date and put it in the output message */
        ARC_UTLGetDateAndTime(Csys08s.pOutputMsg.getDtWCDDtSystemDate() , 0);
        pOutputMsgTransMap.map_name = "CCMN46SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CCMNB0D(CCMN46SI pInputMsg343, CCMN46SO pOutputMsg313, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i169 = 0;
        CCMNB0DI pCCMNB0DInputRec = null;
        CCMNB0DO pCCMNB0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMNB0DInputRec = new CCMNB0DI();
        
        pCCMNB0DOutputRec = new CCMNB0DO();
        pCCMNB0DInputRec.setArchInputStruct(pInputMsg343.getArchInputStruct());
        pCCMNB0DInputRec.setUlIdPerson(pInputMsg343.getUlIdPerson());
        
        /* ochumd END SIR 23427 */
        
        /*
        ** address
        */
        pCCMNB0DInputRec.setSysIndValidOnly(pInputMsg343.getSysIndValidOnly());
        pCCMNB0DInputRec.setBSysIndIntake(pInputMsg343.getBSysIndIntake());
        pCCMNB0DInputRec.tsSysTsQuery = pInputMsg343.getTsSysTsQuery();
        pCCMNB0DInputRec.setArchInputStruct(pInputMsg343.getArchInputStruct());
        rc = ccmnb0dQUERYdam(sqlca, pCCMNB0DInputRec, pCCMNB0DOutputRec);
        
        
        /* Update the selected records from previous DAM */
        if (rc != 0) {
            
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = SUCCESS;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg313.getArchOutputStruct().setUlRowQty(pCCMNB0DOutputRec.getArchOutputStruct().getUlRowQty());
            
            for (i169 = 0;i169 < pCCMNB0DOutputRec.getArchOutputStruct().getUlRowQty();++i169) {
                //  phone
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setSzCdPhoneType(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getSzCdPhoneType());
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setLNbrPhone(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getLNbrPhone());
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setLNbrPhoneExtension(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getLNbrPhoneExtension());
                // name
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setDtDtPersonPhoneStart(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getDtDtPersonPhoneStart());
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setDtDtPersonPhoneEnd(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getDtDtPersonPhoneEnd());
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setBIndPersonPhonePrimary(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getBIndPersonPhonePrimary());
                //  person ID
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setBIndPersonPhoneInvalid(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getBIndPersonPhoneInvalid());
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setSzTxtPhoneComments(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getSzTxtPhoneComments());
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setUlIdPhone(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getUlIdPhone());
                
                //  SIR 15512
                pOutputMsg313.getROWCCMN46SOG00_ARRAY().getROWCCMN46SOG00(i169).setTsLastUpdate(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i169).getTsLastUpdate());
            }
        }
        
        return rc;
    }

}
