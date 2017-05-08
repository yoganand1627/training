package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA1SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS76DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS76DO;
/**************************************************************************
**
** Module File:   CCMNA1S.SRC
**
** Service Name:  ccmna1s
**
** Description:   This service calls one dam: the DAM called populates the
**                phone number designated for on call for a given person
**                retrieved from the staff window back into the On Call Detail
**                window.
**
** CLSS76D Dam:
**                input:   1 variable:  IdPerson
**               output:  12 variables: IdPerson, Nm Person Full,
**                        Home Phone, Contact Order, OnCallDesig(nation),
**                        Phone1, Ext1, Phone2, Ext2
**                        IdEmpOnCallLink, IdOnCall, tsLastUpdate
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/30/95
**
** Programmer:    Mitchell Zoll
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   01 May 1998 08:54:14  $
**                      $Modtime:   29 Apr 1998 17:28:32  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10Apr95   Zollmf    Initial check-in.
**
**  05/27/04  RIOSJA    SIR 18871 - Retrieve phone extension also.
**
***************************************************************************/

/********** service include files *****************************************/



/*
** Extern for version control table.
*/






public class Ccmna1s {
    //## END TUX/XML: Declare XML variables
    
    
    //## BEGIN TUX/XML: Turn the XML buffer into an input message struct
    /* Allocate the Input message that will be used within the service */
    static CCMNA1SI pInputMsg = null;
    static CCMNA1SO pOutputMsg = null;
    void CCMNA1S(TPSVCINFO * request) {
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        
        
        //## BEGIN TUX/XML: Turn the XML buffer into an input message struct
        /* Allocate the Input message that will be used within the service */
        pInputMsg = new CCMNA1SI();
        
        //The output msg must be initialized or output Fielded Buffer will be filled with gargage
        pOutputMsg = new CCMNA1SO();
        int Count = 0;
        rc = ARC_PRFServiceStartTime_TUX(pInputMsg.getArchInputStruct());
        
        /*
        ** Run-time Versioning
        */
        
        /*
        ** Check buffer size
        ** Process error message and return to client
        */
        /* Initialize output message and length */
        
        /* Initialize service status fields */
        for (Count = 0;Count <= (pInputMsg.getArchInputStruct().getUlPageSizeNbr());Count++) {
            rc = CallCLSS76D(pInputMsg, pOutputMsg, pServiceStatus, Count);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /* load translation map with service name and version */
        
        /* stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(pInputMsg.getArchInputStruct() , pOutputMsg.getArchOutputStruct());
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
                
                //  Start performance timer for service. All performance functions always
                // return success so there is no need to check status.
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
    }

    static int CallCLSS76D(CCMNA1SI pInputMsg376, CCMNA1SO pOutputMsg346, Arcxmlerrors.TUX_DECL_STATUSPARMS, int Count) {
        int rc = 0;/* Return code */
        int i185 = 0;
        /* local variables */
        CLSS76DI pCLSS76DInputRec = null;
        CLSS76DO pCLSS76DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCLSS76DInputRec = new CLSS76DI();
        
        pCLSS76DOutputRec = new CLSS76DO();
        pCLSS76DInputRec.setArchInputStruct(pInputMsg376.getArchInputStruct());
        pCLSS76DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSS76DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS76DO._CLSS76DO__ROWCLSS76DO_SIZE);
        pCLSS76DInputRec.setUlIdPerson(pInputMsg376.getUlIdPerson_ARRAY().getUlIdPerson(Count));
        
        rc = clss76dQUERYdam(sqlca, pCLSS76DInputRec, pCLSS76DOutputRec);
        
        /*
        ** Set Calculated Retention date to maximum date
        */
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    //  Call DAM - UPDATE CAPS_RESOURCE
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            rc = WtcHelperConstants.ARC_SUCCESS;
            pOutputMsg346.getLNbrPhone_ARRAY().setLNbrPhone(Count, pCLSS76DOutputRec.getROWCLSS76DO_ARRAY().getROWCLSS76DO(0).getLNbrPhone());
            pOutputMsg346.getLNbrPhoneExtension_ARRAY().setLNbrPhoneExtension(Count, pCLSS76DOutputRec.getROWCLSS76DO_ARRAY().getROWCLSS76DO(0).getLNbrPhoneExtension());
        }
        return rc;
    }

}
