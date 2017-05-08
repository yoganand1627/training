package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CSUB29S.src
**
** Service Name:   CSUB29S
**
** Description:   This service will receive Id Event.  This element will be
**                used as input to call several DAMs which will perform
**                appropriate retrieves from the Event, PPT, and PPT Narra-
**                tive tables.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 11, 1995 
** 
** Programmer:    Jennifer Matteson
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:16:34  $
**                      $Modtime:   28 Mar 1996 23:22:48  $
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






public class Csub29s {
    public static final String NEW = "NEW";
    public static final String PPT_NARR = "PPT_NARR";
    CSUB29SO CSUB29S(CSUB29SI csub29si) {
        CSUB29SO csub29so = new CSUB29SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables 
        
        int rc = FND_SUCCESS;
        int i427 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        CSES14DI pCSES14DInputRec = null;
        CSES14DO pCSES14DOutputRec = null;
        
        CSYS06DI pCSYS06DInputRec = null;
        CSYS06DO pCSYS06DOutputRec = null;
        
        /*
        ** 12/101/2002 DWW
        ** Added rc=ARC_SUCCESS so that these pages would successfully call errorlist
        */
        rc = ARC_PRFServiceStartTime_TUX(csub29si.getArchInputStruct());
        
        rc = ARC_UTLGetDateAndTime(csub29so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        
        pCCMN45DInputRec.setArchInputStruct(csub29si.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(csub29si.getUlIdEvent());
        
        /*
        ** 12/101/2002 DWW
        ** Added rc=ARC_SUCCESS so that these pages would successfully call errorlist
        */
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.explan_code = SUCCESS;
                pServiceStatus.severity = FND_SEVERITY_OK;
                
                csub29so.getROWCSUB29SOG01().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                csub29so.getROWCSUB29SOG01().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                csub29so.getROWCSUB29SOG01().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                csub29so.getROWCSUB29SOG01().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                csub29so.getROWCSUB29SOG01().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                csub29so.getROWCSUB29SOG01().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                csub29so.getROWCSUB29SOG01().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                csub29so.getROWCSUB29SOG01().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                csub29so.getROWCSUB29SOG01().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                
                if (0 != NEW.compareTo(csub29so.getROWCSUB29SOG01().getSzCdEventStatus())) {
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES14DInputRec = new CSES14DI();
                    
                    pCSES14DOutputRec = new CSES14DO();
                    pCSES14DInputRec.setArchInputStruct(csub29si.getArchInputStruct());
                    
                    pCSES14DInputRec.setUlIdPptEvent(csub29si.getUlIdEvent());
                    
                    rc = cses14dQUERYdam(sqlca, pCSES14DInputRec, pCSES14DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.explan_code = SUCCESS;
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            csub29so.getCSUB29SOG00().setSzAddrPptCity(pCSES14DOutputRec.getSzAddrPptCity());
                            csub29so.getCSUB29SOG00().setSzAddrPptCnty(pCSES14DOutputRec.getSzAddrPptCnty());
                            csub29so.getCSUB29SOG00().setSzAddrPptStLn1(pCSES14DOutputRec.getSzAddrPptStLn1());
                            csub29so.getCSUB29SOG00().setSzAddrPptStLn2(pCSES14DOutputRec.getSzAddrPptStLn2());
                            csub29so.getCSUB29SOG00().setSzAddrPptState(pCSES14DOutputRec.getSzAddrPptState());
                            csub29so.getCSUB29SOG00().setSzAddrPptZip(pCSES14DOutputRec.getSzAddrPptZip());
                            csub29so.getCSUB29SOG00().setSzNbrPptPhone(pCSES14DOutputRec.getSzNbrPptPhone());
                            csub29so.getCSUB29SOG00().setSzTxtPptAddrCmnt(pCSES14DOutputRec.getSzTxtPptAddrCmnt());
                            
                            csub29so.getCSUB29SOG00().setUlIdPptEvent(pCSES14DOutputRec.getUlIdPptEvent());
                            csub29so.getCSUB29SOG00().setDtDtPptDate(pCSES14DOutputRec.getDtDtPptDate());
                            csub29so.getCSUB29SOG00().setDtDtPptDocComp(pCSES14DOutputRec.getDtDtPptDocComp());
                            csub29so// SIR 3048 - Counter for "number of events passed
                            .getCSUB29SOG00().setLNbrPptPhoneExt(pCSES14DOutputRec.getLNbrPptPhoneExt());
                            csub29so.getCSUB29SOG00().setTsLastUpdate(pCSES14DOutputRec.getTsLastUpdate());
                            csub29so.getCSUB29SOG00().setTmScrTmPptTime(pCSES14DOutputRec.getTmScrTmGeneric1());
                            
                            
                            //  Check if Document Exists
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCSYS06DInputRec = new CSYS06DI();
                            
                            pCSYS06DOutputRec = new CSYS06DO();
                            pCSYS06DInputRec.setArchInputStruct(csub29si.getArchInputStruct());
                            pCSYS06DInputRec.setUlIdEvent(csub29si.getUlIdEvent());
                            pCSYS06DInputRec.setSzSysTxtTablename(PPT_NARR);
                            rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
                            
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.explan_code = SUCCESS;
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    csub29so.setBIndBLOBExistsInDatabase(true);
                                    break;
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = SUCCESS;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Call DAM
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    csub29so.setBIndBLOBExistsInDatabase(false);
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    break;
                            }
                            
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
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub29si.getArchInputStruct() , csub29so.getArchOutputStruct());
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
        return csub29so;
    }

}
