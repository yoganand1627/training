package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC35DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:    CCFC26S.src
**
** Service Name:   CCFC26S
**
** Description:   This service will retrieve all rows from the Records 
**                Check Table for a given IdRecCheckPerson(maximum page 
**                size retrieved is 11 rows).  
**
**                The service will scan retreived records for 
**                rows with a CdRecCheckType of "10" 
**                (DPS Criminal History) where the DtRecCheckCompleted
**                field is "12/31/4712"(max date) for the given IdPerson.
**                If a row matching these criteria is found, a flag will be
**                populated indicating that an incomplete DPS Criminal 
**                History Check exists for that IdPerson.  
**
**                The service will also retrieve the CdPersonEthnicGroup,
**                DtPersonBirth, IndPersonDobApprox, CdPersonSex, and 
**                NmPersonPersonFull from the Person Table for the 
**                IdRecCheckPerson, as well as the NmPersonFull for all
**                returned IdRecCheckRequestors and the logged on user
**                IdRecCheckRequestor.  
**
**                Lastly, this service will retrieve the NmNameFirst and 
**                NmNameLast from the Name Table for the IdRecCheckPerson. 
**                
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/11/96 
** 
** Programmer:    CIN
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   21 Jul 1997 13:25:42  $
**                      $Modtime:   18 Jul 1997 16:01:28  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date        User      Description
**  ----------  --------  --------------------------------------------------
**  07/18/1997  WILLIAJT  SIR 13855 - Allow subsequent DPS criminal history
**                        checks for DPS record status O, E, and R.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc26s {
    
    /*
    ** Define constant
    */
    public static final String DPS_CODE = "10";
    /*  SIR 13855 */
    public static final String DPS_STAT_OVERDUE = "O";
    public static final String DPS_STAT_DPS_REJECT = "E";
    public static final String DPS_STAT_PRS_REJECT = "R";
    CCFC26SO CCFC26S(CCFC26SI ccfc26si) {
        CCFC26SO ccfc26so = new CCFC26SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CCFC26S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i51 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSC53DI pCLSC53DInputRec = null;
        CLSC53DO pCLSC53DOutputRec = null;
        
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        
        CSEC35DI pCSEC35DInputRec = null;
        CSEC35DO pCSEC35DOutputRec = null;
        ccfc26so.setCIndRecCheckDpsIncomplete(Cint14s.INDICATOR_NO);
        rc = ARC_PRFServiceStartTime_TUX(ccfc26si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccfc26so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        
        /**************************************************************************
        ** Retrieve full rows from the Records Check Table. DAM CLSC53D
        ** This DAM will retrieve all rows from the RECORDS CHECK table 
        ** by ID_REC_CHECK_PERSON.
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC53DInputRec = new CLSC53DI();
        
        pCLSC53DOutputRec = new CLSC53DO();
        
        pCLSC53DInputRec.setArchInputStruct(ccfc26si.getArchInputStruct());
        pCLSC53DInputRec.setUlIdRecCheckPerson(ccfc26si.getUlIdRecCheckPerson());
        pCLSC53DInputRec.getArchInputStruct().setUsPageNbr(ccfc26si.getArchInputStruct().getUsPageNbr());
        pCLSC53DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc26si.getArchInputStruct().getUlPageSizeNbr());
        rc = clsc53dQUERYdam(sqlca, pCLSC53DInputRec, pCLSC53DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCFC26SO to fields in CLSC53DO
                
                for (i51 = 0;i51 < pCLSC53DOutputRec.getArchOutputStruct().getUlRowQty();i51++) {
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setSzCdRecCheckCheckType(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getSzCdRecCheckCheckType());
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setSzCdRecCheckEmpType(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getSzCdRecCheckEmpType());
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setSzCdRecCheckStatus(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getSzCdRecCheckStatus());
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setSzTxtRecCheckComments(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getSzTxtRecCheckComments());
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setSzScrNmRequestedBy(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getSzNmPersonFull());
                    //  Anything but success us unacceptable
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setTsLastUpdate(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getTsLastUpdate());
                    
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setDtDtRecCheckRequest(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getDtDtRecCheckRequest());
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setDtDtRecCheckCompleted(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getDtDtRecCheckCompleted());
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setUlIdRecCheck(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getUlIdRecCheck());
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setUlIdRecCheckRequestor(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getUlIdRecCheckRequestor());
                    ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).setUlIdStage(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i51).getUlIdStage());
                    if (!(DPS_CODE.compareTo(ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).getSzCdRecCheckCheckType()) != 0) && DateHelper.NULL_DATE == ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).getDtDtRecCheckCompleted().day && DateHelper.NULL_DATE == ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).getDtDtRecCheckCompleted().month && DateHelper.NULL_DATE == ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).getDtDtRecCheckCompleted().year && DPS_STAT_OVERDUE.compareTo(ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).getSzCdRecCheckStatus()) != 0 && DPS_STAT_DPS_REJECT.compareTo(ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).getSzCdRecCheckStatus()) != 0 && DPS_STAT_PRS_REJECT.compareTo(ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00(i51).getSzCdRecCheckStatus()) != 0 && ccfc26so.getCIndRecCheckDpsIncomplete() != INDICATOR_YES) {
                        ccfc26so.setCIndRecCheckDpsIncomplete(INDICATOR_YES);
                    }
                }
                ccfc26so.getArchOutputStruct().setBMoreDataInd(pCLSC53DOutputRec.getArchOutputStruct().getBMoreDataInd());
                ccfc26so.getArchOutputStruct().setUlRowQty(pCLSC53DOutputRec.getArchOutputStruct().getUlRowQty());
                
                // 
                // Retrieve full row from the Person Table DAM CCMN44D
                // This DAM will get the entire row from the PERSON table based 
                // on the ID PERSON.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCCMN44DInputRec = new CCMN44DI();
                
                pCCMN44DOutputRec = new CCMN44DO();
                pCCMN44DInputRec.setArchInputStruct(ccfc26si.getArchInputStruct());
                //  Anything but success us unacceptable
                pCCMN44DInputRec.setUlIdPerson(ccfc26si.getUlIdRecCheckPerson());
                rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        ccfc26so.setSzCdPersonEthnicGroup(pCCMN44DOutputRec.getSzCdPersonEthnicGroup());
                        ccfc26so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                        ccfc26so.setDtDtPersonBirth(pCCMN44DOutputRec.getDtDtPersonBirth());
                        ccfc26so.setBIndPersonDobApprox(pCCMN44DOutputRec.getBIndPersonDobApprox());
                        ccfc26so.setCCdPersonSex(pCCMN44DOutputRec.getCCdPersonSex());
                        pCCMN44DInputRec.setArchInputStruct(ccfc26si.getArchInputStruct());
                        pCCMN44DInputRec.setUlIdPerson(ccfc26si.getUlIdRecCheckRequestor());
                        
                        // Call DAM
                        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                ccfc26so.setSzScrNmRequestedBy(pCCMN44DOutputRec.getSzNmPersonFull());
                                
                                
                                // 
                                // Retrieve Name: DAM CSEC35D
                                // Given ID PERSON this dam will retrieve NM NAME FIRST, 
                                // NM NAME LAST, and NM NAME MIDDLE from NAME table. 
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCSEC35DInputRec = new CSEC35DI();
                                
                                pCSEC35DOutputRec = new CSEC35DO();
                                pCSEC35DInputRec.setArchInputStruct(ccfc26si.getArchInputStruct());
                                //  Anything but success us unacceptable
                                pCSEC35DInputRec.setUlIdPerson(ccfc26si.getUlIdRecCheckPerson());
                                rc = csec35dQUERYdam(sqlca, pCSEC35DInputRec, pCSEC35DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        ccfc26so.setSzNmNameFirst(pCSEC35DOutputRec.getSzNmNameFirst());
                                        ccfc26so.setSzNmNameLast(pCSEC35DOutputRec.getSzNmNameLast());
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
        ARC_PRFServiceStopTime_TUX(ccfc26si.getArchInputStruct() , ccfc26so.getArchOutputStruct());
        /*
        ** SIR 20840 - Changed to buisness from primary and added VID
        ** validation
        */
        /*
        ** Copy idResourceAddress if the address type if "buisness"
        ** and has a valid VID. (There can be more than one business
        ** address but only one with a VID.)
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            
            // 
            // (END): Retrieve Resource Address
            // 
            
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
        return ccfc26so;
    }

}
