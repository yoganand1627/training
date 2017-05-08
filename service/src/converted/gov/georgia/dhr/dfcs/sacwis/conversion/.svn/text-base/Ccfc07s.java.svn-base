package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS40DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CCFC07S.src
**
** Service Name:   CCFC07S
**
** Description:   This service will retrieve the Event Status from the 
**                EVENT table given the specified ID EVENT.  If upon 
**                retrieving the Event Status, the Status is not "NEW" 
**                then a row must be retrieved from the PAL table as well.  
**                It will retrieve all columns from the PAL FOLLOWUP table 
**                given the specified ID STAGE.  It will also retrieve all 
**                the rows from the PAL PUBLIC ASSIST table given the 
**                specified ID STAGE.  There will only be one event 
**                retrieved from the CCMN45D DAM, one record retrieved from 
**                the PAL FOLLOWUP table and zero to many records from the 
**                PAL PUBLIC ASSIST table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 12, 1995 
** 
** Programmer:    James J. O'Mara
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:35:26  $
**                      $Modtime:   29 Mar 1996 23:54:20  $
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






public class Ccfc07s {
    
    /*
    ** Declare FOUNDATION variables 
    */
    
    /*
    ** Event Information Variables
    */
    public static final String STATUS_NEW = "NEW";
    CCFC07SO CCFC07S(CCFC07SI ccfc07si) {
        CCFC07SO ccfc07so = new CCFC07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i15 = 0;
        CCMN45DI pCCMN45DInputRec = null;/* pointer to DAM input record  */
        CCMN45DO pCCMN45DOutputRec = null;
        CSES48DI pCSES48DInputRec = null;/* pointer to DAM input record  */
        CSES48DO pCSES48DOutputRec = null;/* pointer to DAM output record */
        CLSS40DI pCLSS40DInputRec = null;/* pointer to DAM input record  */
        CLSS40DO pCLSS40DOutputRec = null;/* pointer to DAM output record */
        /*Send Alert to Pal Worker*/
        
        rc = ARC_PRFServiceStartTime_TUX(ccfc07si.getArchInputStruct());
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(ccfc07si.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(ccfc07si.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        switch (rc) /* caud20d */
        {
                // 
                // (END): Retrieve DAM: csec33d      Person_loc simple retrieve
                // 
                //  SIR 23155 - If SQL_NOT_FOUND is returned and the placement type is
                // FA Home Placement, set the severity to OK, and set the Home History
                // Indicator to "No" this will display a message for the user indicating
                // there is no valid Row on the Home History Table.
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccfc07so.setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                ccfc07so.setTsSysTsLastUpdate2(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                if (STATUS_NEW.compareTo(ccfc07so.getSzCdEventStatus()) != 0) {
                    // 
                    // (BEGIN): 
                    // Call DAM CSES48D -- This DAM will retrieve a full row from the PAL 
                    // FOLLOWUP table.  It will take as input an ID STAGE.                
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    
                    pCSES48DInputRec = new CSES48DI();
                    
                    pCSES48DOutputRec = new CSES48DO();
                    pCSES48DInputRec.setArchInputStruct(ccfc07si.getArchInputStruct());
                    pCSES48DInputRec.setUlIdStage(ccfc07si.getUlIdStage());
                    rc = cses48dQUERYdam(sqlca, pCSES48DInputRec, pCSES48DOutputRec);
                    switch (rc) // cses01d
                    {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ccfc07so.setSzCdPalFollupEducStat(pCSES48DOutputRec.getSzCdPalFollupEducStat());
                            ccfc07so.setSzCdPalFollupEmployed(pCSES48DOutputRec.getSzCdPalFollupEmployed());
                            ccfc07so.setSzCdPalFollupLivArr(pCSES48DOutputRec.getSzCdPalFollupLivArr());
                            ccfc07so.setSzCdPalFollupMarital(pCSES48DOutputRec.getSzCdPalFollupMarital());
                            ccfc07so.setSzCdPalFollupHighestEdu(pCSES48DOutputRec.getSzCdPalFollupHighestEdu());
                            ccfc07so.setUCdPalFollupReunified(pCSES48DOutputRec.getUCdPalFollupReunified());
                            ccfc07so.setDtDtPalFollupDate(pCSES48DOutputRec.getDtDtPalFollupDate());
                            ccfc07so.setCIndPalFollupNoPubAst(pCSES48DOutputRec.getCIndPalFollupNoPubAst());
                            ccfc07so.setCIndPalFollupNotLocate(pCSES48DOutputRec.getCIndPalFollupNotLocate());
                            ccfc07so.setLNbrPalFollupNumChldrn(pCSES48DOutputRec.getLNbrPalFollupNumChldrn());
                            if (Cint14s.INDICATOR_NO == pCSES48DOutputRec.getCIndPalFollupNoPubAst() && Cint14s.INDICATOR_NO == pCSES48DOutputRec.getCIndPalFollupNotLocate()) {
                                //  Allocate memory for DAM Input and Output Structures
                                pCLSS40DInputRec = new CLSS40DI();
                                
                                pCLSS40DOutputRec = new CLSS40DO();
                                pCLSS40DInputRec.setArchInputStruct(ccfc07si.getArchInputStruct());
                                pCLSS40DInputRec.setUlIdStage(ccfc07si.getUlIdStage());
                                rc = clss40dQUERYdam(sqlca, pCLSS40DInputRec, pCLSS40DOutputRec);
                                switch (rc) // caud15d
                                {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Populate Output Message
                                        
                                        //  Set fields in CCFC07SO to fields in CLSS40DO
                                        // Retrieve all applicable Public Assist types from the 
                                        // PAL PUBLIC ASSIST table until there are no more rows
                                        
                                        for (i15 = 0;i15 < pCLSS40DOutputRec.getArchOutputStruct().getUlRowQty();i15++) {
                                            ccfc07so.getROWCCFC07SOG00_ARRAY().getROWCCFC07SOG00(i15).setSzCdPalPublicAssist(pCLSS40DOutputRec.getROWCLSS40DO_ARRAY().getROWCLSS40DO(i15).getSzCdPalPublicAssist());
                                        }
                                        ccfc07so.getArchOutputStruct().setUlRowQty(pCLSS40DOutputRec.getArchOutputStruct().getUlRowQty());
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }//SIR 24002
                }
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
        ARC_PRFServiceStopTime_TUX(ccfc07si.getArchInputStruct() , ccfc07so.getArchOutputStruct());
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
        return ccfc07so;
    }

}
