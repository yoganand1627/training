package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC03DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC03DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON02S.src
**
** Service Name:  CCON02S
**
** Description:   This service will retrieve Function Type, Procurement
**                Type, Program Type, Contract Manager Name, Region, 
**                Budget Limit Indicator, Resource Name, Resource VID,
**                Id Rsrc Addr, Addr Rsrc Addr St Ln 1 for an Id Contract,
**                Id Resource and Id Cntrct Manager combination.
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
**                      $Date:   27 May 1996 17:02:24  $
**                      $Modtime:   28 Mar 1996 22:27:30  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon02s {
    CCON02SO CCON02S(CCON02SI ccon02si) {
        CCON02SO ccon02so = new CCON02SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i188 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //## long            rc = 0;
        
        CSEC03DI pCSEC03DInputRec = null;
        CSEC03DO pCSEC03DOutputRec = null;
        CLSC06DI pCLSC06DInputRec = null;
        CLSC06DO pCLSC06DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccon02si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSEC03DInputRec = new CSEC03DI();
        
        pCSEC03DOutputRec = new CSEC03DO();
        
        pCSEC03DInputRec.setArchInputStruct(ccon02si.getArchInputStruct());
        pCSEC03DInputRec.setUlIdContract(ccon02si.getUlIdContract());
        rc = csec03dQUERYdam(sqlca, pCSEC03DInputRec, pCSEC03DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccon02so.setTsLastUpdate(pCSEC03DOutputRec.getTsLastUpdate());
                
                ccon02so.setSzCdCntrctFuncType(pCSEC03DOutputRec.getSzCdCntrctFuncType());
                ccon02so.setSzCdCntrctProcureType(pCSEC03DOutputRec.getSzCdCntrctProcureType());
                ccon02so.setSzCdCntrctProgramType(pCSEC03DOutputRec.getSzCdCntrctProgramType());
                
                ccon02so.setSzCdCntrctRegion(pCSEC03DOutputRec.getSzCdCntrctRegion());
                ccon02so.setCIndCntrctBudgLimit(pCSEC03DOutputRec.getCIndCntrctBudgLimit());
                ccon02so.setUlIdCntrctManager(pCSEC03DOutputRec.getUlIdCntrctManager());
                ccon02so.setUlIdResource(pCSEC03DOutputRec.getUlIdResource());
                ccon02so.setSzNmResource(pCSEC03DOutputRec.getSzNmResource());
                ccon02so.setUlIdRsrcAddress(pCSEC03DOutputRec.getUlIdRsrcAddress());
                ccon02so.setSzNmPersonFull(pCSEC03DOutputRec.getSzNmPersonFull());
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSC06DInputRec = new CLSC06DI();
                
                pCLSC06DOutputRec = new CLSC06DO();
                pCLSC06DInputRec.setArchInputStruct(ccon02si.getArchInputStruct());
                pCLSC06DInputRec.setUlIdResource(pCSEC03DOutputRec.getUlIdResource());
                pCLSC06DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon02si.getArchInputStruct().getUlPageSizeNbr());
                
                
                //  Call CSES80D
                rc = clsc06dQUERYdam(sqlca, pCLSC06DInputRec, pCLSC06DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        ccon02so.getArchOutputStruct().setUlRowQty(pCLSC06DOutputRec.getArchOutputStruct().getUlRowQty());
                        if (pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(0).getSzNbrRsrcAddrVid()[0] == null) {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = Messages.MSG_CON_NO_VID_EXISTS;
                            ccon02so.getArchOutputStruct().setUlRowQty(0);
                        }
                        //  else at least one VID exists
                        else {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            
                            //  Populate Output Message
                            
                            //  Set fields in CCON02SO to fields in CLSC06DO
                            for (i188 = 0;i188 < pCLSC06DOutputRec.getArchOutputStruct().getUlRowQty();i188++) {
                                
                                
                                
                                
                                //  If IdEvent = 0 set reqfunccd to ADD else set it to update
                                if (pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i188).getSzNbrRsrcAddrVid()[0] != null) {
                                    ccon02so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i188).setUlIdRsrcAddress(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i188).getUlIdRsrcAddress());
                                    ccon02so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i188).setSzNbrRsrcAddrVid(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i188).getSzNbrRsrcAddrVid());
                                    ccon02so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i188).setSzAddrRsrcAddrStLn1(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i188).getSzAddrRsrcAddrStLn1());
                                }
                                else {
                                    ccon02so.getArchOutputStruct().setUlRowQty(i188);
                                    break;
                                }
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = Messages.MSG_CON_RESOURCE_INVALID;
                        
                        //  Call architecture function to retreive the current date.
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
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
        ARC_PRFServiceStopTime_TUX(ccon02si.getArchInputStruct() , ccon02so.getArchOutputStruct());
        
        
        /*
        ** if IdEvent != 0, use the IdEvent that was passed in
        ** from the input message,
        ** else use the one that was created in Post Event. It was
        ** stored in "ulPostEventIdEvent".
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            // 01/22/2003 DWW: Added for error handling
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
        
        return ccon02so;
    }

}
