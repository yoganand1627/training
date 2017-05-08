package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH7SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH7DO;
/**************************************************************************
** 
** Module File:   ccmnh7s.src
**
** Service Name:  ccmnh7s
**
** Description:   This service calls one dam:
**
** CCMNH7D Dam: 
**                input:  two variables required:
**                        Region and IDOnCall
**                        
**               output:  Data for On Call List window's County ListBox:
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
**                      $Date:   10 Dec 1998 14:44:18  
**                      $Modtime:   19 Oct 1998 10:31:04  
**                      $Author:   pvcs  
**
** Change History:
**  Date      User      Description
**
***************************************************************************/

/********** service include files *****************************************/



/*
** Extern for version control table.
*/






public class Ccmnh7s
/* parameter list string */

/*
** If all of the SQR parameters passed validation then set the
** rc appropriately before exiting DAM.
*/
{
    
    
    /**************************************************************************
    ** Service Function
    ***************************************************************************/
    
    /**************************************************************************
    **
    ** Function Name:  CARC06S
    **
    ** Description:    Main Service Function
    **
    ***************************************************************************/
    
    
    static CCMNH7SI pInputMsg = null;
    static CCMNH7SO pOutputMsg = null;
    void CCMNH7S(TPSVCINFO * request) {
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        
        
        //## BEGIN TUX/XML: Turn the XML buffer into an input message struct
        /* Allocate the Input message that will be used within the service */
        pInputMsg = new CCMNH7SI();
        
        //The output msg must be initialized or output Fielded Buffer will be filled with gargage
        pOutputMsg = new CCMNH7SO();
        
        /*
        ** Call PostEvent
        */
        rc = ARC_PRFServiceStartTime_TUX(pInputMsg.getArchInputStruct());
        rc = CallCCMNH7D(pInputMsg, pOutputMsg, pServiceStatus);
        
        /*
        ** Analyze error code
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
        ARC_PRFServiceStopTime_TUX(pInputMsg.getArchInputStruct() , pOutputMsg.getArchOutputStruct());
        
        /*
        ** SIR 20360:
        ** Begin contract creation/modification process if the save service is
        ** successful up to this point
        */
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
    }

    static int CallCCMNH7D(CCMNH7SI pInputMsg377, CCMNH7SO pOutputMsg347, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i186 = 0;
        /* local variables */
        CCMNH7DI pCCMNH7DInputRec = null;
        CCMNH7DO pCCMNH7DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMNH7DInputRec = new CCMNH7DI();
        
        pCCMNH7DOutputRec = new CCMNH7DO();
        pCCMNH7DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg377.getUsPageNbr_ARRAY().getUsPageNbr(0));
        pCCMNH7DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg377.getUlPageSizeNbr_ARRAY().getUlPageSizeNbr(0));
        pCCMNH7DInputRec.setSzCdRegion(pInputMsg377.getSzCdRegion());
        pCCMNH7DInputRec.setCdIdOnCall(pInputMsg377.getCdIdOnCall());
        rc = ccmnh7dQUERYdam(sqlca, pCCMNH7DInputRec, pCCMNH7DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i186 = 0;i186 < pCCMNH7DOutputRec.getArchOutputStruct().getUlRowQty();++i186) {
                    pOutputMsg347.getROWCCMNH7DO_ARRAY().getROWCCMNH7DO(i186).setSzCdOnCallCounty(pCCMNH7DOutputRec.getROWCCMNH7DO_ARRAY().getROWCCMNH7DO(i186).getSzCdOnCallCounty());
                }
                pOutputMsg347.getArchOutputStruct().setUlRowQty(pCCMNH7DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
        
    }

}
