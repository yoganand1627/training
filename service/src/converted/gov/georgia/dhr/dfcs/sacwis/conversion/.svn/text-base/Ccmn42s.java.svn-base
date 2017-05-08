package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccfc14s;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN96DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN96DO;
/**************************************************************************
** 
** Module File:   CCMN42S
**
** Service Name:  Person Address List   
**
** Description:   This service is designed to retrieve Address information
** from the database. It is sent the ID PERSON and retrieves the details
** from a join on the ADDRESS PERSON LINK and PERSON ADDRESS tables.
** SPECIAL CONSIDERATIONS: 
** Make sure to set the page size in the input architecture record group
** element SYS CARC PAGE SIZE NBR. Also, set the input record field SYS
** IND VALID ONLY to TRUE if you want to retrieve only valid addresses,
** and FALSE otherwise.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/21/95          
** 
** Programmer:    John Blanton 
**
**
** Change History:
**  Date      User      Description
**  --------  --------  -------------------------------------------------- 
**  4/11/95   WEALANBC  Made some changes for technical review.  Implemented
**                      some new additions to the service shell.
**  7/26/96    zabihin  sir 21891 : version control code was missing, I 
**                      added the lines.
** 
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn42s {
    CCMN42SO CCMN42S(CCMN42SI ccmn42si) {
        CCMN42SO ccmn42so = new CCMN42SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        rc = ARC_PRFServiceStartTime_TUX(ccmn42si.getArchInputStruct());
        rc = Ccfc14s.CallCCMN96D(ccmn42si, ccmn42so, pServiceStatus);
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(ccmn42si.getArchInputStruct() , ccmn42so.getArchOutputStruct());
        /* SIR 22686 if group home is false, save 63A-D else save 63A-C*/
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                //Do not commit as it will be committed in the called service.
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn42so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        
        
        /* Get the system date and put it in the output message */
        ARC_UTLGetDateAndTime(Csys08s.pOutputMsg.getDtWCDDtSystemDate() , 0);
        pOutputMsgTransMap.map_name = "CCMN42SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return WtcHelperConstants.ARC_SUCCESS;
    }

    
    static int CallCCMN96D(CCMN42SI pInputMsg339, CCMN42SO pOutputMsg309, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i166 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN96DI pCCMN96DInputRec = null;
        CCMN96DO pCCMN96DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        
        
        pCCMN96DInputRec = new CCMN96DI();
        
        pCCMN96DOutputRec = new CCMN96DO();
        pCCMN96DInputRec.setUlIdPerson(pInputMsg339.getUlIdPerson());
        pCCMN96DInputRec.setBSysIndIntake(pInputMsg339.getBSysIndIntake());
        pCCMN96DInputRec.tsSysTsQuery = pInputMsg339.getTsSysTsQuery();
        pCCMN96DInputRec.setArchInputStruct(pInputMsg339.getArchInputStruct());
        
        
        /*
        ** Call CAUD01D
        */
        rc = ccmn96dQUERYdam(sqlca, pCCMN96DInputRec, pCCMN96DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    rc = SUCCESS;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;// break for CASE SUCCESS in CSEC58D switch
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            for (i166 = 0;i166 < pCCMN96DOutputRec.getArchOutputStruct().getUlRowQty();++i166) {
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setBIndPersAddrLinkPrimary(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getBIndPersAddrLinkPrimary());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setBIndPersAddrLinkInvalid(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getBIndPersAddrLinkInvalid());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzCdPersAddrLinkType(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getSzCdPersAddrLinkType());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzAddrPersAddrStLn1(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getSzAddrPersAddrStLn1());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzAddrPersAddrStLn2(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getSzAddrPersAddrStLn2());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzAddrPersAddrAttn(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getSzAddrPersAddrAttn());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzAddrCity(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getSzAddrCity());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setLAddrZip(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getLAddrZip());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzCdAddrCounty(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getSzCdAddrCounty());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzCdAddrState(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getSzCdAddrState());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzTxtPersAddrCmnts(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getSzTxtPersAddrCmnts());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setTsSysTsLastUpdate2(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getTsSysTsLastUpdate2());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setTsLastUpdate(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getTsLastUpdate());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setDtDtPersAddrLinkStart(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getDtDtPersAddrLinkStart());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setDtDtPersAddrLinkEnd(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getDtDtPersAddrLinkEnd());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setLdIdAddress(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getLdIdAddress());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setUlIdAddrPersonLink(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i166).getUlIdAddrPersonLink());
                pOutputMsg309.getROWCCMN42SOG00_ARRAY().getROWCCMN42SOG00(i166).setSzCdScrDataAction(' ');
            };
            pOutputMsg309.getArchOutputStruct().setUlRowQty(pCCMN96DOutputRec.getArchOutputStruct().getUlRowQty());
        }
        return rc;
    }

}
