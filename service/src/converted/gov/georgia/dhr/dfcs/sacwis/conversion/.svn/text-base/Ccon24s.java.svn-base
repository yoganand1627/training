package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC13DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS13DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CCON24S.src
**
** Service Name:  CCON24S
**
** Description:   This is the retrieval service for the Service Authorization
**                APS Detail window.  This service will call four dams
**                CSES23D - SVC AUTH RTRV, CLSS25D - APS INHOME TASK RTRV,
**                CLSC14D - PHYSICIAN NAME RTRV, and CSEC13D - LIVING ARRANGE
**                RTRV.  Each of these dams will only be called upon the
**                successful return of the previous one and the case of
**                no rows returned will be treated as a successful return.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/05/95
**
** Programmer:    Timothy "Forms Guy" Overend
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:08:08  $
**                      $Modtime:   28 Mar 1996 22:30:36  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12/01/95  MCRAEBS   Added SVC AUTH table timestamp retrieved in the
**                      header window to the input message of this service.
**                      Coded the comparison of that timestamp with the
**                      same table's timestamp retrieve within this service.
**                      If they don't match, the service will error out and
**                      let the user know that another user has already
**                      modified the SVC AUTH.
**  02/21/03  Srini D   IMPACT: Initialized the rowQty =0
**  04/17/05  CORLEYAN  SIR 23538 - Added retrieval of Estimated Value Information
**  5/5/2005  gerryc    SIR 23538 - corrected memory error found in purify
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon24s {
    CCON24SO CCON24S(CCON24SI ccon24si) {
        CCON24SO ccon24so = new CCON24SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //Added the rowQty to send row info to marshal function
        //Srini D   02/21/03  IMPACT: Initialized the rowQty =0
        int rowQty = 0;
        int i204 = 0;
        
        CSES23DI pCSES23DInputRec = null;
        CSES23DO pCSES23DOutputRec = null;
        CLSS25DI pCLSS25DInputRec = null;
        CLSS25DO pCLSS25DOutputRec = null;
        CLSC14DI pCLSC14DInputRec = null;
        CLSC14DO pCLSC14DOutputRec = null;
        CSEC13DI pCSEC13DInputRec = null;
        CSEC13DO pCSEC13DOutputRec = null;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccon24si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        
        /*
        ** Check Output Buffer Size
        */
        /*
        ** Process error message and return to client
        */
        //##    */
        ARC_PRFServiceStopTime_TUX(ccon24si.getArchInputStruct() , ccon24so.getArchOutputStruct());
        
        rc = ARC_UTLGetDateAndTime(ccon24so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /**************************************************************************
        ** Call Dam CSES23D - SVC AUTH RTRV
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES23DInputRec = new CSES23DI();
        
        pCSES23DOutputRec = new CSES23DO();
        pCSES23DInputRec.setArchInputStruct(ccon24si.getArchInputStruct());
        pCSES23DInputRec.setUlIdSvcAuth(ccon24si.getUlIdSvcAuth());
        rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                if (memcmp(pCSES23DOutputRec.getTsLastUpdate() , ccon24si.getTsLastUpdate() , CSYS13DO.TSLASTUPDATE_LEN) != 0) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SVC_AUTH_TSTAMP;
                }
                ccon24so.setSzCdSvcAuthAbilToRespond(pCSES23DOutputRec.getSzCdSvcAuthAbilToRespond());
                ccon24so.setSzTxtDirectToHome(pCSES23DOutputRec.getSzTxtDirectToHome());
                ccon24so.setSzTxtHomeEnviron(pCSES23DOutputRec.getSzTxtHomeEnviron());
                ccon24so.setSzTxtMedicalConditions(pCSES23DOutputRec.getSzTxtMedicalConditions());
                ccon24so.setTsLastUpdate(pCSES23DOutputRec.getTsLastUpdate());
                ccon24so.setDtDtSvcAuthVerbalReferl(pCSES23DOutputRec.getDtDtSvcAuthVerbalReferl());
                ccon24so.setUlIdPerson(pCSES23DOutputRec.getUlIdPerson());
                ccon24so.setLAmtEstValue(pCSES23DOutputRec.getLAmtEstValue());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            //  Allocate memory for DAM Input and Output Structures
            pCLSS25DInputRec = new CLSS25DI();
            
            pCLSS25DOutputRec = new CLSS25DO();
            pCLSS25DInputRec.setArchInputStruct(ccon24si.getArchInputStruct());
            pCLSS25DInputRec.setUlIdApsInhomeSvcAuth(ccon24si.getUlIdSvcAuth());
            rc = clss25dQUERYdam(sqlca, pCLSS25DInputRec, pCLSS25DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccon24so.getArchOutputStruct().setUlRowQty(pCLSS25DOutputRec.getArchOutputStruct().getUlRowQty());
                    
                    //  Set fields in CCON24SO to fields in CLSS25DO
                    for (i204 = 0;i204 < pCLSS25DOutputRec.getArchOutputStruct().getUlRowQty();i204++) {
                        ccon24so.getROWCCON24SOG00_ARRAY().getROWCCON24SOG00(i204).setSzCdAPSInHomeTask(pCLSS25DOutputRec.getROWCLSS25DO_ARRAY().getROWCLSS25DO(i204).getSzCdAPSInHomeTask());
                        ccon24so.getROWCCON24SOG00_ARRAY().getROWCCON24SOG00(i204).setTsLastUpdate(pCLSS25DOutputRec.getROWCLSS25DO_ARRAY().getROWCLSS25DO(i204).getTsLastUpdate());
                        ccon24so.getROWCCON24SOG00_ARRAY().getROWCCON24SOG00(i204).setUlIdSvcAuth(pCLSS25DOutputRec.getROWCLSS25DO_ARRAY().getROWCLSS25DO(i204).getUlIdApsInhomeSvcAuth());
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            //  Allocate memory for DAM Input and Output Structures
            pCLSC14DInputRec = new CLSC14DI();
            
            pCLSC14DOutputRec = new CLSC14DO();
            pCLSC14DInputRec.setArchInputStruct(ccon24si.getArchInputStruct());
            pCLSC14DInputRec.setUlIdStage(ccon24si.getUlIdStage());
            
            //  Call DAM
            rc = clsc14dQUERYdam(sqlca, pCLSC14DInputRec, pCLSC14DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                    
                    // ERR #1625: Following error condition has been added.
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Populate Output Message
                    
                    //  Set fields in CCON24SO to fields in CLSC14DO
                    
                    for (i204 = 0;i204 < pCLSC14DOutputRec.getArchOutputStruct().getUlRowQty();i204++) {
                        ccon24so.getROWCCON24SOG01_ARRAY().getROWCCON24SOG01(i204).setSzNmPersonFull(pCLSC14DOutputRec.getROWCLSC14DO_ARRAY().getROWCLSC14DO(i204).getSzNmPersonFull());
                        ccon24so.getROWCCON24SOG01_ARRAY().getROWCCON24SOG01(i204).setUlIdPerson(pCLSC14DOutputRec.getROWCLSC14DO_ARRAY().getROWCLSC14DO(i204).getUlIdPerson());
                    }
                    
                    //Start of change - Srini
                    //Added Row Qty to send it to the marshalling function
                    rowQty = pCLSC14DOutputRec.getArchOutputStruct().getUlRowQty();
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            //  Allocate memory for DAM Input and Output Structures
            pCSEC13DInputRec = new CSEC13DI();
            
            pCSEC13DOutputRec = new CSEC13DO();
            
            pCSEC13DInputRec.setArchInputStruct(ccon24si.getArchInputStruct());
            pCSEC13DInputRec.setUlIdStage(ccon24si.getUlIdStage());
            rc = csec13dQUERYdam(sqlca, pCSEC13DInputRec, pCSEC13DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccon24so.setSzCdPersonLivArr(pCSEC13DOutputRec.getSzCdPersonLivArr());
                    //  pCINV44DOutputRec will be returned to the calling service
                    // and will be freed there.
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        /*
        ** Load Translation Map
        */
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon24si.getArchInputStruct() , ccon24so.getArchOutputStruct());
        
        /*
        ** Set fields in CCFC03SO to fields in CSES42DO
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccon24so;
    }

}
