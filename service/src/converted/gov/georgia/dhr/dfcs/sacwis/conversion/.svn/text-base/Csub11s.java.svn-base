package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC08DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    csub11s.src
**
** Service Name:   CSUB11S             
**
** Description:   This service performs a retrieval for the Guardianship
**                Detail window. It recieves Id Event and Id Stage. It 
**                calls CSEC09D, CCMN45D, and CSEC08D.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/27/95 
** 
** Programmer:    Sameer Rao
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:23:38  $
**                      $Modtime:   05 Aug 1996 16:49:24  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/14/96  DYARGR    SIR 3780 - AOC should be compared to CdStage, not
**                      CdStageRsnClose.
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                       added the lines
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub11s {
    
    /* SIR 2986 */
    public static final String AGING_OUT = "AOC";
    public static final String NEW = "NEW";
    CSUB11SO CSUB11S(CSUB11SI csub11si) {
        CSUB11SO csub11so = new CSUB11SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i419 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        int RetVal = 0;
        
        CCMN45DI pCCMN45DInputRec = null;
        
        CCMN45DO pCCMN45DOutputRec = null;
        
        CSEC09DI pCSEC09DInputRec = null;
        CSEC09DO pCSEC09DOutputRec = null;
        
        CSEC08DI pCSEC08DInputRec = null;
        CSEC08DO pCSEC08DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub11si.getArchInputStruct());
        
        /*
        ** Call CINV51D
        */
        rc = ARC_UTLGetDateAndTime(csub11so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (csub11si.getUlIdEvent() > 0) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMN45DInputRec = new CCMN45DI();
            
            pCCMN45DOutputRec = new CCMN45DO();
            pCCMN45DInputRec.setArchInputStruct(csub11si.getArchInputStruct());
            pCCMN45DInputRec.setUlIdEvent(csub11si.getUlIdEvent());
            rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set the RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    csub11so.getROWCSUB11SOG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                    csub11so.getROWCSUB11SOG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                    csub11so.getROWCSUB11SOG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                    csub11so.getROWCSUB11SOG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                    csub11so.getROWCSUB11SOG00().setUlIdEventPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                    
                    csub11so.getROWCSUB11SOG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                    csub11so.getROWCSUB11SOG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                    csub11so.getROWCSUB11SOG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                    
                    if (0 != NEW.compareTo(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus())) {
                        //  Allocate memory for DAM Input and Output Structures
                        pCSEC09DInputRec = new CSEC09DI();
                        
                        pCSEC09DOutputRec = new CSEC09DO();
                        pCSEC09DInputRec.setArchInputStruct(csub11si.getArchInputStruct());
                        pCSEC09DInputRec.setUlIdGuardEvent(csub11si.getUlIdEvent());
                        rc = csec09dQUERYdam(sqlca, pCSEC09DInputRec, pCSEC09DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                
                                if (pCSEC09DOutputRec.getUlIdGuardPers() > 0) {
                                    csub11so.getROWCSUB11SOG01().setSzSdsGuardName(pCSEC09DOutputRec.getSzNmPersonFull());
                                }
                                
                                else if (pCSEC09DOutputRec.getUlIdGuardRsrc() > 0) {
                                    csub11so.getROWCSUB11SOG01().setSzSdsGuardName(pCSEC09DOutputRec.getSzNmResource());
                                }
                                
                                else {
                                    csub11so.getROWCSUB11SOG01().setSzSdsGuardName(pCSEC09DOutputRec.getSzSdsGuardName());
                                }
                                csub11so.getROWCSUB11SOG01().setUlIdGuardPers(pCSEC09DOutputRec.getUlIdGuardPers());
                                
                                csub11so.getROWCSUB11SOG01().setUlIdGuardRsrc(pCSEC09DOutputRec.getUlIdGuardRsrc());
                                csub11so.getROWCSUB11SOG01().setTsLastUpdate(pCSEC09DOutputRec.getTsLastUpdate());
                                csub11so.getROWCSUB11SOG01().setSzAddrGuardCity(pCSEC09DOutputRec.getSzAddrGuardCity());
                                csub11so.getROWCSUB11SOG01().setSzAddrGuardCnty(pCSEC09DOutputRec.getSzAddrGuardCnty());
                                csub11so.getROWCSUB11SOG01().setSzAddrGuardLn1(pCSEC09DOutputRec.getSzAddrGuardLn1());
                                csub11so.getROWCSUB11SOG01().setSzAddrGuardLn2(pCSEC09DOutputRec.getSzAddrGuardLn2());
                                csub11so.getROWCSUB11SOG01().setSzAddrGuardSt(pCSEC09DOutputRec.getSzAddrGuardSt());
                                csub11so.getROWCSUB11SOG01().setSzAddrGuardZip(pCSEC09DOutputRec.getSzAddrGuardZip());
                                csub11so.getROWCSUB11SOG01().setSzCdGuardCloseReason(pCSEC09DOutputRec.getSzCdGuardCloseReason());
                                csub11so.getROWCSUB11SOG01().setSzCdGuardGuardianType(pCSEC09DOutputRec.getSzCdGuardGuardianType());
                                csub11so.getROWCSUB11SOG01().setSzCdGuardType(pCSEC09DOutputRec.getSzCdGuardType());
                                csub11so.getROWCSUB11SOG01().setDtDtGuardCloseDate(pCSEC09DOutputRec.getDtDtGuardCloseDate());
                                csub11so.getROWCSUB11SOG01().setDtDtGuardLetterIssued(pCSEC09DOutputRec.getDtDtGuardLetterIssued());
                                csub11so.getROWCSUB11SOG01().setDtDtGuardOrdered(pCSEC09DOutputRec.getDtDtGuardOrdered());
                                csub11so.getROWCSUB11SOG01().setCIndGuardAgedOut(pCSEC09DOutputRec.getCIndGuardAgedOut());
                                csub11so.getROWCSUB11SOG01().setSzCdGuardType(pCSEC09DOutputRec.getSzCdGuardType());
                                csub11so.getROWCSUB11SOG01().setSzNbrGuardPhone(pCSEC09DOutputRec.getSzNbrGuardPhone());
                                csub11so.getROWCSUB11SOG01().setSzNbrGuardPhoneExt(pCSEC09DOutputRec.getSzNbrGuardPhoneExt());
                                csub11so.getROWCSUB11SOG01().setSzTxtGuardAddrComment(pCSEC09DOutputRec.getSzTxtGuardAddrComment());
                                csub11so.getROWCSUB11SOG01().setSzTxtGuardComments(pCSEC09DOutputRec.getSzTxtGuardComments());
                                break;
                                
                            default :
                                
                                //  Set the RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    break;
                    
                default :
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if ((0 == csub11si.getUlIdEvent()) || ((0 == NEW.compareTo(csub11so.getROWCSUB11SOG00().getSzCdEventStatus())) && (SUCCESS == RetVal))) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC08DInputRec = new CSEC08DI();
            
            pCSEC08DOutputRec = new CSEC08DO();
            pCSEC08DInputRec.setArchInputStruct(csub11si.getArchInputStruct());
            
            pCSEC08DInputRec.setUlIdStage(csub11si.getUlIdStage());
            
            //  Call CSEC37D
            rc = csec08dQUERYdam(sqlca, pCSEC08DInputRec, pCSEC08DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    if (0 == AGING_OUT.compareTo(pCSEC08DOutputRec.getSzCdStage())) {
                        
                        csub11so.getROWCSUB11SOG01().setCIndGuardAgedOut(INDICATOR_YES);
                    }
                    
                    else {
                        csub11so.getROWCSUB11SOG01().setCIndGuardAgedOut(Cint14s.INDICATOR_NO);
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub11so.getROWCSUB11SOG01().setCIndGuardAgedOut(Cint14s.INDICATOR_NO);
                    
                    // SIR 23223 - this populates the szCdRsrcFacilType variable
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
        ARC_PRFServiceStopTime_TUX(csub11si.getArchInputStruct() , csub11so.getArchOutputStruct());
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (RetVal == SUCCESS) {
            
            // Update NBR_RSRC_OPEN_SLOTS - subtracts one from the open slots
            rc = SUCCESS;
        }
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
                
                // SIR 23223 - this populates the szCdRsrcFacilType variable
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csub11so;
    }

}
