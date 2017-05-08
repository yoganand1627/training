package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN32SO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN86DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN86DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA2DO;
/**************************************************************************
** 
** Service Name:  CCMN32S.src
**
** Description:   This service calls two dams: 
**
**                CCMN86D: input:  ID_CASE
**                         output: all ID_STAGE's for that ID_CASE
**                                 from the STAGE table
**
**                CCMNA2D: input:  ID_PERSON
**                         output: all ID_STAGE's for that ID_PERSON
**                                 from the STAGE PERSON LINK table
**        
**            This Service returns all ID_STAGES given a case or a person.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/18/95 
** 
** Programmer:    Gwin S. Pitman 
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  7/26/96    zabihin  sir 21891 : version control code was missing,I
**                      added the lines.
**
***************************************************************************/


/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn32s {
    CCMN32SO CCMN32S(CCMN32SI ccmn32si) {
        CCMN32SO ccmn32so = new CCMN32SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
        */
        
        /*
        ** Check buffer size 
        */
        
        /*
        ** Process error message and return to client 
        */
        
        /*
        ** Initialize output message and length 
        */
        
        /*
        ** Initialize service status fields 
        */
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        rc = ARC_PRFServiceStartTime_TUX(ccmn32si.getArchInputStruct());
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (ccmn32si.getUlIdCase() != 0) {
            
            // Create the APS OUTCOME MATRIX Event record.
            rc = CallCCMN86D(ccmn32si, ccmn32so, pServiceStatus);
            switch (rc) {
                case SUCCESS:
                    break;
                case Messages.MSG_CMN_SEARCH_NOT_FOUND:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        else if (ccmn32si.getUlIdPerson() != 0) {
            
            // *  Call DAM that selects APS CLIENT FACTORS into the APS OUTCOME MATRIX
            // table. The new ID EVENT is included in the APS OUTCOME MATRIX ADDs.
            
            //  SIR 1751 - Removed code which modified the function code of pInputMsg
            
            rc = CallCCMNA2D(ccmn32si, ccmn32so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case SUCCESS:
                    break;
                case Messages.MSG_CMN_SEARCH_NOT_FOUND:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        else {
            pServiceStatus.severity = FND_WARNING;
            pServiceStatus.explan_code = Messages.MSG_ERR_BAD_FUNC_CD;
        }
        
        
        /**************************************************************************
        ** Load translation map with service name and version 
        ***************************************************************************/
        
        
        /********** Stop performance timer for service ****************************/
        ARC_PRFServiceStopTime_TUX(ccmn32si.getArchInputStruct() , ccmn32so.getArchOutputStruct());
        
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
                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                
                
                
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn32so;
    }

    static int CallCCMN86D(CCMN32SI pInputMsg287, CCMN32SO pOutputMsg270, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i153 = 0;
        /********** local variables **********************************************/
        CCMN86DI pCCMN86DInputRec = null;
        CCMN86DO pCCMN86DOutputRec = null;
        
        
        /**************************************************************************
        ** Allocate memory for Input and Output Structures
        ***************************************************************************/
        pCCMN86DInputRec = new CCMN86DI();
        
        pCCMN86DOutputRec = new CCMN86DO();
        pCCMN86DInputRec.setUlIdCase(pInputMsg287.getUlIdCase());
        
        /*
        ** SIR 21809
        */
        pCCMN86DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg287.getArchInputStruct().getUsPageNbr());
        pCCMN86DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg287.getArchInputStruct().getUlPageSizeNbr());
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        rc = ccmn86dQUERYdam(sqlca, pCCMN86DInputRec, pCCMN86DOutputRec);
        if (rc != SUCCESS) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_SEARCH_NOT_FOUND;
                    
                    rc = Messages.MSG_CMN_SEARCH_NOT_FOUND;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            // 
            // Populate Output Message
            // 
            for (i153 = 0;i153 < pCCMN86DOutputRec.getArchOutputStruct().getUlRowQty();++i153) {
                
                pOutputMsg270.getROWCCMN32SO_ARRAY().getROWCCMN32SO(i153).setUlIdStage(pCCMN86DOutputRec.getROWCCMN86DO_ARRAY().getROWCCMN86DO(i153).getUlIdStage());
            }
            pOutputMsg270.getArchOutputStruct().setUlRowQty(pCCMN86DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg270.getArchOutputStruct().setBMoreDataInd(pCCMN86DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCCMNA2D(CCMN32SI pInputMsg288, CCMN32SO pOutputMsg271, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i154 = 0;
        /********** local variables **********************************************/
        CCMNA2DI pCCMNA2DInputRec = null;
        CCMNA2DO pCCMNA2DOutputRec = null;
        
        
        /**************************************************************************
        ** Allocate memory for Input and Output Structures
        ***************************************************************************/
        pCCMNA2DInputRec = new CCMNA2DI();
        
        pCCMNA2DOutputRec = new CCMNA2DO();
        pCCMNA2DInputRec.setUlIdPerson(pInputMsg288.getUlIdPerson());
        pCCMNA2DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg288.getArchInputStruct().getUsPageNbr());
        pCCMNA2DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg288.getArchInputStruct().getUlPageSizeNbr());
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Call CSES82D
        */
        rc = ccmna2dQUERYdam(sqlca, pCCMNA2DInputRec, pCCMNA2DOutputRec);
        if (rc != SUCCESS) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_SEARCH_NOT_FOUND;
                    rc = Messages.MSG_CMN_SEARCH_NOT_FOUND;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            // 
            // Populate Output Message
            // 
            for (i154 = 0;i154 < pCCMNA2DOutputRec.getArchOutputStruct().getUlRowQty();++i154) {
                pOutputMsg271.getROWCCMN32SO_ARRAY().getROWCCMN32SO(i154).setUlIdStage(pCCMNA2DOutputRec.getROWCCMNA2DO_ARRAY().getROWCCMNA2DO(i154).getUlIdStage());
            }
            pOutputMsg271.getArchOutputStruct().setUlRowQty(pCCMNA2DOutputRec.getArchOutputStruct().getUlRowQty());
            
            pOutputMsg271.getArchOutputStruct().setBMoreDataInd(pCCMNA2DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

}
