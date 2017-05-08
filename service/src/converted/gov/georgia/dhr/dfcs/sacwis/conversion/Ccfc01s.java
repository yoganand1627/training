package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES42DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES42DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CCFC01S.src
**
** Service Name:   CCFC01S - PAL ILS ASSESSMENT RETRIEVE
**
** Description:   This service will retrieve the Event Status from the EVENT 
**                table given the specified ID EVENT.  If upon retrieving 
**                the Event Status, the Status is not "NEW" then a row must 
**                be retrieved from the PAL table as well.  It will retrieve 
**                all columns from the PAL table given the specified ID 
**                STAGE.  There will only be one event retrieved from the 
**                CCMN45D DAM and one record retrieved from the PAL table. 
**                The service will call DAMs CCMN45D - GET EVENT SMP and 
**                CSES42D - PAL RTRV.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 12, 1995 
** 
** Programmer:    James J. O'Mara
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:34:10  $
**                      $Modtime:   29 Mar 1996 23:52:58  $
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






public class Ccfc01s {
    static final String STATUS_NEW1 = "NEW";
    CCFC01SO CCFC01S(CCFC01SI ccfc01si) {
        CCFC01SO ccfc01so = new CCFC01SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        public int i12 = 0;
        CCMN45DI pCCMN45DInputRec = null;/* pointer to DAM input record   */
        
        CCMN45DO pCCMN45DOutputRec = null;
        CSES42DI pCSES42DInputRec = null;/* pointer to DAM input record   */
        CSES42DO pCSES42DOutputRec = null;/* pointer to DAM output record   */
        rc = ARC_PRFServiceStartTime_TUX(ccfc01si.getArchInputStruct());
        /***********************************************************************
        ** (BEGIN): Retrieve DAM: ccmn45d     
        ** Event simple retrieve
        ***********************************************************************/
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setUlIdEvent(ccfc01si.getUlIdEvent());
        
        /*
        ** Call CMSC38D
        */
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccfc01so.setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                ccfc01so.setTsSysTsLastUpdate2(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                // 01/22/2003 DWW: Added for error handling
                if (STATUS_NEW1.compareTo(ccfc01so.getSzCdEventStatus()) != 0) {
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES42DInputRec = new CSES42DI();
                    
                    pCSES42DOutputRec = new CSES42DO();
                    pCSES42DInputRec.setUlIdStage(ccfc01si.getUlIdStage());
                    
                    rc = cses42dQUERYdam(sqlca, pCSES42DInputRec, pCSES42DOutputRec);
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ccfc01so.setSzCdPalCloseLivArr(pCSES42DOutputRec.getSzCdPalCloseLivArr());
                            ccfc01so.setSzTxtPalIlNoIlsRsn(pCSES42DOutputRec.getSzTxtPalIlNoIlsRsn());
                            ccfc01so.setDtDtPalPostasmtDate(pCSES42DOutputRec.getDtDtPalPostasmtDate());
                            ccfc01so.setDtDtPalPreasmtDate(pCSES42DOutputRec.getDtDtPalPreasmtDate());
                            ccfc01so.setTsLastUpdate(pCSES42DOutputRec.getTsLastUpdate());
                            ccfc01so.setCIndPalIlNoIlsAssmt(pCSES42DOutputRec.getCIndPalIlNoIlsAssmt());
                            ccfc01so.setCIndPalIlNoPoasmt_Scre(pCSES42DOutputRec.getCIndPalIlNoPoasmt_Scre());
                            ccfc01so.setCIndPalIlNoPrasmtScre(pCSES42DOutputRec.getCIndPalIlNoPrasmtScre());
                            ccfc01so.setLNbrPalPostasmtScore(pCSES42DOutputRec.getLNbrPalPostasmtScore());
                            ccfc01so.setLNbrPalPreasmtScore(pCSES42DOutputRec.getLNbrPalPreasmtScore());
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
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
        ARC_PRFServiceStopTime_TUX(ccfc01si.getArchInputStruct() , ccfc01so.getArchOutputStruct());
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
        return ccfc01so;
    }

}
