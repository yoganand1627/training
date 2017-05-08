package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD01DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC03DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC03DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON03S.src
**
** Service Name:  CCON03S
**
** Description:   This service will update Contract ID, Function
**                Type, Region, Budget Limit Indicator, Resource ID,
**                Resource Address ID and Contract Manager ID from 
**                the Contract table and will return Contract ID. 
**                The service can add or modify a Contract row.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  09/19/95
** 
** Programmer:    GLOORJW
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:02:38  $
**                      $Modtime:   28 Mar 1996 22:27:42  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/03/95  FOGARTIS  Removed references to Contract Inactive date since
**                      it has been removed from the CONTRACT table.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon03s/* 
** SIR 2421 end ---If stage is closed, do not allow save.
** If the stage is open, then proceed with the save service
*/
{
    CCON03SO CCON03S(CCON03SI ccon03si) {
        CCON03SO ccon03so = new CCON03SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i189 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        
        CAUD01DI pCAUD01DInputRec = null;
        CAUD01DO pCAUD01DOutputRec = null;
        CSEC03DI pCSEC03DInputRec = null;
        CSEC03DO pCSEC03DOutputRec = null;
        CLSC06DI pCLSC06DInputRec = null;
        CLSC06DO pCLSC06DOutputRec = null;
        
        
        /*
        ** Call CAUD17D.  Update the services for the
        ** version.
        */
        rc = ARC_PRFServiceStartTime_TUX(ccon03si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD01DInputRec = new CAUD01DI();
        
        pCAUD01DOutputRec = new CAUD01DO();
        pCAUD01DInputRec.setArchInputStruct(ccon03si.getArchInputStruct());
        pCAUD01DInputRec.getArchInputStruct().setCReqFuncCd(ccon03si.getArchInputStruct().getCReqFuncCd());
        pCAUD01DInputRec.setUlIdContract(ccon03si.getUlIdContract());
        pCAUD01DInputRec.setUlIdResource(ccon03si.getUlIdResource());
        pCAUD01DInputRec.setSzCdCntrctFuncType(ccon03si.getSzCdCntrctFuncType());
        pCAUD01DInputRec.setSzCdCntrctProgramType(ccon03si.getSzCdCntrctProgramType());
        pCAUD01DInputRec.setSzCdCntrctProcureType(ccon03si.getSzCdCntrctProcureType());
        pCAUD01DInputRec.setSzCdCntrctRegion(ccon03si.getSzCdCntrctRegion());
        pCAUD01DInputRec.setCIndCntrctBudgLimit(ccon03si.getCIndCntrctBudgLimit());
        pCAUD01DInputRec.setUlIdRsrcAddress(ccon03si.getUlIdRsrcAddress());
        pCAUD01DInputRec.setUlIdCntrctManager(ccon03si.getUlIdCntrctManager());
        pCAUD01DInputRec.setTsLastUpdate(ccon03si.getTsLastUpdate());
        pCAUD01DInputRec.setUlIdCntrctWkr(ccon03si.getUlIdCntrctWkr());
        rc = caud01dAUDdam(sqlca, pCAUD01DInputRec, pCAUD01DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccon03so.setUlIdContract(pCAUD01DOutputRec.getUlIdContract());
                
                //  Allocate memory for DAM Input and Output Structures
                pCSEC03DInputRec = new CSEC03DI();
                
                pCSEC03DOutputRec = new CSEC03DO();
                pCSEC03DInputRec.setArchInputStruct(ccon03si.getArchInputStruct());
                pCSEC03DInputRec.setUlIdContract(pCAUD01DOutputRec.getUlIdContract());
                rc = csec03dQUERYdam(sqlca, pCSEC03DInputRec, pCSEC03DOutputRec);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ccon03so.setTsLastUpdate(pCSEC03DOutputRec.getTsLastUpdate());
                        ccon03so.setSzCdCntrctFuncType(pCSEC03DOutputRec.getSzCdCntrctFuncType());
                        ccon03so.setSzCdCntrctProcureType(pCSEC03DOutputRec.getSzCdCntrctProcureType());
                        ccon03so.setSzCdCntrctProgramType(pCSEC03DOutputRec.getSzCdCntrctProgramType());
                        ccon03so.setSzCdCntrctRegion(pCSEC03DOutputRec.getSzCdCntrctRegion());
                        ccon03so.setCIndCntrctBudgLimit(pCSEC03DOutputRec.getCIndCntrctBudgLimit());
                        ccon03so.setUlIdCntrctManager(pCSEC03DOutputRec.getUlIdCntrctManager());
                        ccon03so.setUlIdResource(pCSEC03DOutputRec.getUlIdResource());
                        ccon03so.setSzNmResource(pCSEC03DOutputRec.getSzNmResource());
                        ccon03so.setUlIdRsrcAddress(pCSEC03DOutputRec.getUlIdRsrcAddress());
                        ccon03so.setSzNmPersonFull(pCSEC03DOutputRec.getSzNmPersonFull());
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCLSC06DInputRec = new CLSC06DI();
                        
                        pCLSC06DOutputRec = new CLSC06DO();
                        pCLSC06DInputRec.setArchInputStruct(ccon03si.getArchInputStruct());
                        pCLSC06DInputRec.setUlIdResource(pCSEC03DOutputRec.getUlIdResource());
                        pCLSC06DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon03si.getArchInputStruct().getUlPageSizeNbr());
                        
                        
                        //  Call CLSS37D in order to retrieve county information
                        // for the previous version.
                        rc = clsc06dQUERYdam(sqlca, pCLSC06DInputRec, pCLSC06DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                ccon03so.getArchOutputStruct().setUlRowQty(pCLSC06DOutputRec.getArchOutputStruct().getUlRowQty());
                                if (pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(0).getSzNbrRsrcAddrVid()[0] == null) {
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = Messages.MSG_CON_NO_VID_EXISTS;
                                    ccon03so.getArchOutputStruct().setUlRowQty(0);
                                }
                                
                                
                                //  else at least one VID exists
                                else {
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Populate Output Message
                                    
                                    //  Set fields in CCON02SO to fields in CLSC06DO
                                    for (i189 = 0;i189 < pCLSC06DOutputRec.getArchOutputStruct().getUlRowQty();i189++) {
                                        if (pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i189).getSzNbrRsrcAddrVid()[0] != null) {
                                            ccon03so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i189).setUlIdRsrcAddress(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i189).getUlIdRsrcAddress());
                                            ccon03so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i189).setSzNbrRsrcAddrVid(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i189).getSzNbrRsrcAddrVid());
                                            ccon03so.getROWCCON02SOG00_ARRAY().getROWCCON02SOG00(i189).setSzAddrRsrcAddrStLn1(pCLSC06DOutputRec.getROWCLSC06DO_ARRAY().getROWCLSC06DO(i189).getSzAddrRsrcAddrStLn1());
                                        }
                                        else {
                                            ccon03so.getArchOutputStruct().setUlRowQty(i189);
                                            break;
                                        }
                                    }
                                    
                                }
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = Messages.MSG_CON_RESOURCE_INVALID;
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
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
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
        ARC_PRFServiceStopTime_TUX(ccon03si.getArchInputStruct() , ccon03so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                
                
                //  Increment the service row counter
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Call CAUD08D to add the counties to the new version
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccon03so;
    }

}
