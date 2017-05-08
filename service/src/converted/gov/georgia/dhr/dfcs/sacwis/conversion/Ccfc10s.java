package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CCFC10S.src
**
** Service Name:   CCFC10S
**
** Description:   This service will retrieve the Event Status from the EVENT
**        table given the specified ID_EVENT.  If upon retreieving
**        the Event Status, The status is not "NEW", then a row must
**        must be retrieved from the PAL table as well.  It will 
**        retrieve al columns from the PAL SERVICES table given a 
**        specific ID STAGE. Additionally, it will get a smart date
**        for the PAL stage by retrieving the Stage record from the 
**        STAGE table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12-18-95 
** 
** Programmer:    Jeff Hughes
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:36:04  $
**                      $Modtime:   29 Mar 1996 23:54:56  $
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






public class Ccfc10s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final String EVENT_STATUS_NEW = "NEW";
    CCFC10SO CCFC10S(CCFC10SI ccfc10si) {
        CCFC10SO ccfc10so = new CCFC10SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables
        
        int rc = FND_SUCCESS;
        int i16 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        CLSS44DI pCLSS44DInputRec = null;
        CLSS44DO pCLSS44DOutputRec = null;
        CINT21DI pCINT21DInputRec = null;/* SIR# 20217 */
        
        CINT21DO pCINT21DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccfc10si.getArchInputStruct());
        
        /*
        ** Call DAM if an race is added or deleted
        */
        rc = ARC_UTLGetDateAndTime(ccfc10so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /**************************************************************************
        ** Retrieve CINT21D retrieve begin
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setArchInputStruct(ccfc10si.getArchInputStruct());
        pCINT21DInputRec.setUlIdStage(ccfc10si.getUlIdStage());
        /*
        ** Do nothing, the output message just returns success or
        ** failure
        */
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        
        
        
        /*
        ** Analyze return code for CAUDB2
        */
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccfc10so.setDtDtStageStart(pCINT21DOutputRec.getDtDtStageStart());
                
                if (ccfc10si.getUlIdEvent() != 0) {
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN45DInputRec = new CCMN45DI();
                    
                    pCCMN45DOutputRec = new CCMN45DO();
                    pCCMN45DInputRec.setArchInputStruct(ccfc10si.getArchInputStruct());
                    pCCMN45DInputRec.setUlIdEvent(ccfc10si.getUlIdEvent());
                    rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                    
                    
                    
                    //  Analyze return code for CAUD99D
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ccfc10so.setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                            ccfc10so.setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                            if (ccfc10so.getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0) {
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCLSS44DInputRec = new CLSS44DI();
                                
                                pCLSS44DOutputRec = new CLSS44DO();
                                pCLSS44DInputRec.setArchInputStruct(ccfc10si.getArchInputStruct());
                                pCLSS44DInputRec.setUlIdStage(ccfc10si.getUlIdStage());
                                rc = clss44dQUERYdam(sqlca, pCLSS44DInputRec, pCLSS44DOutputRec);
                                switch (rc) // switch for case FAD's
                                {
                                        
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        
                                        
                                        //  Populate Output Message
                                        
                                        //  Set fields in CCFC10SO to fields in CLSS44DO
                                        
                                        
                                        for (i16 = 0;i16 < pCLSS44DOutputRec.getArchOutputStruct().getUlRowQty();i16++) {
                                            ccfc10so.getROWCCFC10SOG00_ARRAY().getROWCCFC10SOG00(i16).setUlIdPalService(pCLSS44DOutputRec.getROWCLSS44DO_ARRAY().getROWCLSS44DO(i16).getUlIdPalService());
                                            ccfc10so.getROWCCFC10SOG00_ARRAY().getROWCCFC10SOG00(i16).setUlIdStage(pCLSS44DOutputRec.getROWCLSS44DO_ARRAY().getROWCLSS44DO(i16).getUlIdStage());
                                            ccfc10so.getROWCCFC10SOG00_ARRAY().getROWCCFC10SOG00(i16).setSzCdPalServiceCategory(pCLSS44DOutputRec.getROWCLSS44DO_ARRAY().getROWCLSS44DO(i16).getSzCdPalServiceCategory());
                                            ccfc10so.getROWCCFC10SOG00_ARRAY().getROWCCFC10SOG00(i16).setDtDtPalServiceDate(pCLSS44DOutputRec.getROWCLSS44DO_ARRAY().getROWCLSS44DO(i16).getDtDtPalServiceDate());
                                            ccfc10so.getROWCCFC10SOG00_ARRAY().getROWCCFC10SOG00(i16).setSzCdPalServiceType(pCLSS44DOutputRec.getROWCLSS44DO_ARRAY().getROWCLSS44DO(i16).getSzCdPalServiceType());
                                            ccfc10so.getROWCCFC10SOG00_ARRAY().getROWCCFC10SOG00(i16).setLNbrPalServiceUnits(pCLSS44DOutputRec.getROWCLSS44DO_ARRAY().getROWCLSS44DO(i16).getLNbrPalServiceUnits());
                                            ccfc10so.getROWCCFC10SOG00_ARRAY().getROWCCFC10SOG00(i16).setSzSdsPalServiceOther(pCLSS44DOutputRec.getROWCLSS44DO_ARRAY().getROWCLSS44DO(i16).getSzSdsPalServiceOther());
                                            ccfc10so.getROWCCFC10SOG00_ARRAY().getROWCCFC10SOG00(i16).setTsLastUpdate(pCLSS44DOutputRec.getROWCLSS44DO_ARRAY().getROWCLSS44DO(i16).getTsLastUpdate());
                                        }
                                        ccfc10so.getArchOutputStruct().setBMoreDataInd(pCLSS44DOutputRec.getArchOutputStruct().getBMoreDataInd());
                                        ccfc10so.getArchOutputStruct().setUlRowQty(pCLSS44DOutputRec.getArchOutputStruct().getUlRowQty());
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
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                            
                            //  Call DAM if a skill is added or deleted
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                }
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                //  Do nothing, the output message just returns success or
                // failure
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc10si.getArchInputStruct() , ccfc10so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
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
        return ccfc10so;
    }

}
