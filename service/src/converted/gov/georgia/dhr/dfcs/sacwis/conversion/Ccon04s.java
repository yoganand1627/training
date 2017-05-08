package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON04S.src
**
** Service Name:  CCON04S
**
** Description:   This service will retrieve Nm Resource, Id Rsrc
**                Address, Nbr Rsrc Addr VID, and Addr Rsrc Addr St Ln
**                1 based upon the given Id Resource.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  09/19/95 
** 
** Programmer:    GLOORJW
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:02:52  $
**                      $Modtime:   28 Mar 1996 22:27:54  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12/11/95    KRD     Modified header to match Release 2 service shell.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon04s {
    CCON04SO CCON04S(CCON04SI ccon04si) {
        CCON04SO ccon04so = new CCON04SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i190 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSC06DI pCLSC06DInputRec = null;
        CLSC06DO pCLSC06DOutputRec = null;
        
        
        /*
        ** Start Performance Timer
        */
        rc = ARC_PRFServiceStartTime_TUX(ccon04si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC06DInputRec = new CLSC06DI();
        
        pCLSC06DOutputRec = new CLSC06DO();
        pCLSC06DInputRec.setArchInputStruct(ccon04si.getArchInputStruct());
        pCLSC06DInputRec.setUlIdResource(ccon04si.getUlIdResource());
        pCLSC06DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon04si.getArchInputStruct().getUlPageSizeNbr());
        rc = clsc06dQUERYdam(sqlca, pCLSC06DInputRec, pCLSC06DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                ccon04so.setSzNmResource(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(0).getSzNmResource());
                ccon04so.getArchOutputStruct().setUlRowQty(pCLSC06DOutputRec.getArchOutputStruct().getUlRowQty());
                
                //  The folowing logic will set the Person Creator and calculate
                // the Task Due date. It will do this only if the Todo Info Type
                // is "T" for Task. Otherwise it will set the Person Creator to
                // the one passed in and the Task Due date to NULL
                if (pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(0).getSzNbrRsrcAddrVid()[0] == null) {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_CON_NO_VID_EXISTS;
                    ccon04so.getArchOutputStruct().setUlRowQty(0);
                    rc = Messages.MSG_CON_NO_VID_EXISTS;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                }
                
                //  else at least one VID exists
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CCON02SO to fields in CLSC06DO
                    for (i190 = 0;i190 < pCLSC06DOutputRec.getArchOutputStruct().getUlRowQty();i190++) {
                        // Sir 13720
                        if (pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i190).getSzNbrRsrcAddrVid()[0] != null) {
                            ccon04so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i190).setUlIdRsrcAddress(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i190).getUlIdRsrcAddress());
                            ccon04so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i190).setSzNbrRsrcAddrVid(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i190).getSzNbrRsrcAddrVid());
                            ccon04so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i190).setSzAddrRsrcAddrStLn1(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i190).getSzAddrRsrcAddrStLn1());
                        }
                        else {
                            ccon04so.getArchOutputStruct().setUlRowQty(i190);
                            // 
                            // (END): Retrieve DAM: clsc71d    Full row retrieval from Event table
                            // 
                            break;
                        }
                    }
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = Messages.MSG_CON_RESOURCE_INVALID;
                
                
                //  Call CCMN44D to retrieve Person Name
                rc = Messages.MSG_CON_RESOURCE_INVALID;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;// end of ARC_SUCCESS for CINT21D
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon04si.getArchInputStruct() , ccon04so.getArchOutputStruct());
        
        /* Check for Person Assigned */
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
                
                
                //  Set rc to ARC_SUCCESS
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccon04so;
    }

}
