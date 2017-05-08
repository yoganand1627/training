package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV31DO;
/**************************************************************************
** 
** Module File:   CINV25S.src
**
** Service Name:  Retrieve Name List/Detail
**
** Description:   This Service calls one DAM to retrieve Name information
**            about person off the Name Table based on ID PERSON.
**        Make sure to set the page size in the input architecture 
**        record group element SYS CARC PAGE SIZE NBR. Also, set the
**        input record field SYS IND VALID ONLY to FALSE if you want
**        to retrieve only valid names, and TRUE otherwise.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/21/95
** 
** Programmer:    DAVE SNIDER
**
** DAMS called:   CINV31D
**
**
** Change History:
**
**  Date     User               SIR  Description
**  -------  ------------------ ---  --------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv25s {
    CINV25SO CINV25S(CINV25SI cinv25si) {
        CINV25SO cinv25so = new CINV25SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(cinv25si.getArchInputStruct());
        rc = Ccfc14s.CallCINV31D(cinv25si, cinv25so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        ARC_UTLGetDateAndTime(cinv25so.getDtWCDDtSystemDate() , 0);
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv25si.getArchInputStruct() , cinv25so.getArchOutputStruct());
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
                
                //  Call CINV51D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                //##             ARC_PRFServiceStopTime( pfpb, pRTAF );
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv25so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV25SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    
    static int CallCINV31D(CINV25SI pInputMsg678, CINV25SO pOutputMsg628, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i341 = 0;
        
        /* Declare local variables */
        CINV31DI pCINV31DInputRec = null;
        CINV31DO pCINV31DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV31DInputRec = new CINV31DI();
        
        pCINV31DOutputRec = new CINV31DO();
        pCINV31DInputRec.setArchInputStruct(pInputMsg678.getArchInputStruct());
        pCINV31DInputRec.setUlIdPerson(pInputMsg678.getUlIdPerson());
        pCINV31DInputRec.setBSysIndIntake(pInputMsg678.getBSysIndIntake());
        
        /*********************************************************************
        ** Call DAMs to update PERSON tables with ID_RELATED_PERSON
        **********************************************************************/
        
        if (true == pInputMsg678.getBSysIndIntake()) {
            pCINV31DInputRec.setTsSysTsQuery(pInputMsg678.getTsSysTsQuery());
        }
        rc = cinv31dQUERYdam(sqlca, pCINV31DInputRec, pCINV31DOutputRec);
        
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pOutputMsg628.getArchOutputStruct().setUlRowQty(0);
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
            
            // Populate Output Message
            for (i341 = 0;i341 < pCINV31DOutputRec.getArchOutputStruct().getUlRowQty();i341++) {
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setSzCdNameSuffix(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getSzCdNameSuffix());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setDtDtNameEndDate(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getDtDtNameEndDate());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setDtDtNameStartDate(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getDtDtNameStartDate());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setUlIdName(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getUlIdName());
                
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setUlIdPerson(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getUlIdPerson());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setBIndNameInvalid(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getBIndNameInvalid());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setBIndNamePrimary(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getBIndNamePrimary());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setSzNmNameFirst(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getSzNmNameFirst());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setSzNmNameLast(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getSzNmNameLast());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setSzNmNameMiddle(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getSzNmNameMiddle());
                pOutputMsg628.getROWCINV25SOG00_ARRAY().getROWCINV25SOG00(i341).setTsLastUpdate(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i341).getTsLastUpdate());
            }
            pOutputMsg628.getArchOutputStruct().setUlRowQty(pCINV31DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg628.getArchOutputStruct().setBMoreDataInd(pCINV31DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

}
