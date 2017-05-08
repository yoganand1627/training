package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS65DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS65DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS66DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS66DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSESA0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSESA0DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
**
** Module File:   CFAD31S.SRC
**
** Service Name:  CFAD31S
**
** Description:   If an Id Resource is not passed into the service, the
**                service will call a DM using IdStage to retrieve the
**                IdResource.  IdResource will then be usd to call another
**                DAM to retreive the data to be displayed on the Facility
**                Placement Log window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 12, 1995
**
** Programmer:    Stephen Parks
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   21 Mar 1997 12:58:46  $
**                      $Modtime:   20 Mar 1997 15:47:50  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/03/96  PHILLILH  SIR #20004 - Added DAMs CLSS65D and CLSS66D to
**                      retrieve the Full Name from the PERSON_HISTORY
**                      table so that the Name is retrieved for the
**                      minimum effective placement start date.  This
**                      eliminates retrieving rows that do not have a name
**                      because the placement was made before the name of the
**                      child was entered in the system.
**
**  01/06/97  SISSONM   SIR 11335 - Changed the error handling from FND_FAIL
**                      to MSG_NO_ROWS_RETURNED in the SQL_NOT_FOUND case
**                      after the call to DAM CLSS66D.
**  03/12/97  ODONNERJ  SIR# 11125 - Changed the Placement Log retrieval
**                      to work properly. Previously the log retrieved
**                      one row for every BLOC in person_loc for every child
**                      placed into a FAD home.  This meant some children
**                      were listed 10 times because they had been placed
**                      in the same home twice and had had their BLOC on
**                      the person_loc table changed 5 times. Now, two dams
**                      are used to get the information from placement table
**                      first (CDYN17D - modified) and then from the
**                      person_loc table (CSESA0D). CDYN17D still handles
**                      the dynamic sort, and all we do is add the person_loc
**                      to the output message for each row returned from
**                      CDYN17D.  This is all done within the for loop added
**                      by SIR# 20004 to get the Effective Name for the
**                      placements.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  06/23/04  gerryc    SIR 19651 - check the most recent legal status and if
**                      there is a placement end date.  If there is no placement
**                      end date and the most recent status is adoption consummated
**                      set an indicator for adoption consummated on the
**                      Placement Log page.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad31s {
    public static final String NULL_STRING = "";
    CFAD31SO CFAD31S(CFAD31SI cfad31si) {
        CFAD31SO cfad31so = new CFAD31SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i213 = 0;
        
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  long            rc = 0;
        int RetVal = 0;
        String tsDtPlcmtEnd = new String();
        int tsDtPlcmtEnd_i = 0;
        String szTempNmPersonFull = new String();
        String szTempNmPersonLast = new String();
        String szTempNmPersonFirst = new String();
        String szTempNmPersonMiddle = new String();
        
        
        CSES41DI pCSES41DInputRec = null;
        CSES41DO pCSES41DOutputRec = null;
        
        CDYN17DI pCDYN17DInputRec = null;
        CDYN17DO pCDYN17DOutputRec = null;
        CLSS65DI pCLSS65DInputRec = null;/* SIR #20004 */
        CLSS65DO pCLSS65DOutputRec = null;/* SIR #20004 */
        CLSS66DI pCLSS66DInputRec = null;/* SIR #20004 */
        CLSS66DO pCLSS66DOutputRec = null;/* SIR #20004 */
        
        
        
        CSESA0DI pCSESA0DInputRec = null;
        CSESA0DO pCSESA0DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfad31si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        RetVal = SUCCESS;
        if (cfad31si.getUlIdResource() == 0) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES41DInputRec = new CSES41DI();
            
            pCSES41DOutputRec = new CSES41DO();
            pCSES41DInputRec.setArchInputStruct(cfad31si.getArchInputStruct());
            pCSES41DInputRec.setUlIdRsrcFaHomeStage(cfad31si.getUlIdStage());
            pCSES41DInputRec.getArchInputStruct().setUsPageNbr(1);
            pCSES41DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
            
            //  Call DAM
            rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:// clss73d
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    cfad31so.setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                    break;
                    
                default :
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        else {
            cfad31so.setUlIdResource(cfad31si.getUlIdResource());
        }
        if (SUCCESS == RetVal) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCDYN17DInputRec = new CDYN17DI();
            
            pCDYN17DOutputRec = new CDYN17DO();
            
            pCDYN17DInputRec.setArchInputStruct(cfad31si.getArchInputStruct());
            pCDYN17DInputRec.setUlIdRsrcFacil(cfad31so.getUlIdResource());
            pCDYN17DInputRec.setBWcdCdSortBy(cfad31si.getBWcdCdSortBy());
            pCDYN17DInputRec.setSzCdPlocType(Csub31s.BILLING);
            rc = cdyn17dQUERYdam(sqlca, pCDYN17DInputRec, pCDYN17DOutputRec);
            switch (rc) {
                    //  SIR 2763  If a period does not have existing services          
                    // saved (case SQL_NOT_FOUND), it cannot be signed and 
                    // saved.  If user tries to save a signed period with 
                    // no services a message will be displayed.
                    // SIR 3013 Only check if period is the first
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CFAD31SO.G00 to fields in ROWCDYN17DO
                    
                    
                    for (i213 = 0;i213 < pCDYN17DOutputRec.getArchOutputStruct().getUlRowQty();i213++) {
                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setSzNmPersonFull(pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getSzNmPersonFull());
                        
                        //  Call DAM
                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setDtDtPersonBirth(pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getDtDtPersonBirth());
                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setDtDtPlcmtStart(pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getDtDtPlcmtStart());
                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setDtDtPlcmtEnd(pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getDtDtPlcmtEnd());
                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setUlIdPerson(pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getUlIdPerson());
                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setSzCdPlcmtRemovalRsn(pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getSzCdPlcmtRemovalRsn());
                        
                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setSzCdPlocChild(NULL_STRING);
                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setSzCdPlcmtLivArr(pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getSzCdPlcmtLivArr());
                        
                        if (0 == LGL_STAT_ADO_CNSM.compareTo(pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getSzCdLegalStatStatus()) && DateHelper.NULL_DATE == pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getDtDtPlcmtEnd().year && DateHelper.NULL_DATE == pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getDtDtPlcmtEnd().day && DateHelper.NULL_DATE == pCDYN17DOutputRec.getROWCDYN17DO_ARRAY().getROWCDYN17DO(i213).getDtDtPlcmtEnd().month) {
                            cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setCScrIndAdptnCnsmmtd(INDICATOR_YES);
                        }
                        else {
                            cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setCScrIndAdptnCnsmmtd(Cint14s.INDICATOR_NO);
                        }
                    }
                    cfad31so.getArchOutputStruct().setBMoreDataInd(pCDYN17DOutputRec.getArchOutputStruct().getBMoreDataInd());
                    cfad31so.getArchOutputStruct().setUlRowQty(pCDYN17DOutputRec.getArchOutputStruct().getUlRowQty());
                    
                    
                    //  SIR #20004 - Added DAMs CLSS65D and CLSS66D to
                    // retrieve the Full Name from the PERSON_HISTORY
                    // table so that the Name is retrieved for the
                    // minimum effective placement start date.
                    
                    
                    // 11335 - Added (ARC_SUCCESS == RetVal) in the for loop
                    for (i213 = 0;((i213 < pCDYN17DOutputRec.getArchOutputStruct().getUlRowQty()) && (WtcHelperConstants.ARC_SUCCESS == RetVal));i213++) {
                        //  Allocate memory for DAM Input and Output Structures
                        pCLSS65DInputRec = new CLSS65DI();
                        
                        pCLSS65DOutputRec = new CLSS65DO();
                        pCLSS65DInputRec.setArchInputStruct(cfad31si.getArchInputStruct());
                        pCLSS65DInputRec.setUlIdPerson(cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).getUlIdPerson());
                        pCLSS65DInputRec.setDtDtPlcmtStart(cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).getDtDtPlcmtStart());
                        rc = clss65dQUERYdam(sqlca, pCLSS65DInputRec, pCLSS65DOutputRec);
                        
                        //  Run-time versioning
                        
                        //  Check buffer size
                        
                        //  Process error message and return to client
                        
                        //  Initialize output message and length
                        
                        //  Initialize service status fields
                        
                        // 
                        // Call DAMs
                        // 
                        
                        //  SIR 1096 - Due to requirements from other windows, a unit approver must
                        // exist for all units.  As a result, they cannot 1) be deleted, 2) have a
                        // Term Date set, or 3) change "IN" units from the unit for which they are
                        // the approver.  To ensure system integrity, if any of those three
                        // modifications are intended to be made, check whether the user is a
                        // unit approver.  If so, return a message to the window to indicate that
                        // the unit approver cannot be modified.
                        // The check to be made involves 2 DAMs - CCMNG5D and CCMNG6D.  CCMNG6D is
                        // used for modifications 1 & 2 and checks all "IN" and "OUT" unit
                        // assignments.  CCMNG5D is used for #3 and checks only "IN" assignments.
                        // Prior to this SIR, when any of the three modifications were made, the
                        // ID PERSON on the UNIT table was set to NULL via either of the Delete
                        // SPAMs or CCMNF4D.  So, the reference to CCMNF4D will be commented out in
                        // case a future version might need the code.
                        
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setSzNmPersonFull(pCLSS65DOutputRec.getNmPersonHistFull());
                                break;
                                
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                
                                
                                //  Call CLSS66D to get the full name if the previous
                                // call did not return a full name
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCLSS66DInputRec = new CLSS66DI();
                                
                                pCLSS66DOutputRec = new CLSS66DO();
                                pCLSS66DInputRec.setArchInputStruct(cfad31si.getArchInputStruct());
                                pCLSS66DInputRec.setUlIdPerson(cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).getUlIdPerson());
                                rc = clss66dQUERYdam(sqlca, pCLSS66DInputRec, pCLSS66DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setSzNmPersonFull(pCLSS66DOutputRec.getNmPersonHistFull());
                                        break;
                                        
                                    default :
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                break;
                                
                                // case SQL_NOT_FOUND:
                                // Set severity to FND_SEVERITY_ERROR
                                // pServiceStatus->severity = FND_SEVERITY_ERROR;
                                // SIR 11335 - set explan_code and RetVal to MSG_NO_ROWS_RETURNED
                                // it used to be FND_FAIL
                                // pServiceStatus->explan_code = MSG_NO_ROWS_RETURNED;
                                // RetVal = MSG_NO_ROWS_RETURNED;
                                // break; 11335--now when person
                                // _history data isn't found, a data access error will occur with
                                // the correlated line number in the code
                                
                            default :
                                
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        
                        
                        
                        // 
                        // SIR# 11125 - Get the CD_PLOC_CHILD from a seperate call
                        // to the CSESA0D and update the output message
                        // 
                        
                        
                        pCSESA0DInputRec = new CSESA0DI();
                        
                        pCSESA0DOutputRec = new CSESA0DO();
                        pCSESA0DInputRec.setArchInputStruct(cfad31si.getArchInputStruct());
                        pCSESA0DInputRec.setUlIdPerson(cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).getUlIdPerson());
                        pCSESA0DInputRec.getDtDtPlocEnd().year = DateHelper.NULL_DATE;
                        
                        if (pCSESA0DInputRec.getDtDtPlocEnd().year != 0 && (pCSESA0DInputRec.getDtDtPlocEnd().day = DateHelper.NULL_DATE) != 0 && (pCSESA0DInputRec.getDtDtPlocEnd().month = DateHelper.NULL_DATE) != 0) {
                            
                            pCSESA0DInputRec.getDtDtPlocEnd().day = Arcutls.ARC_UTL_MAX_DAY;
                            pCSESA0DInputRec.getDtDtPlocEnd().month = Arcutls.ARC_UTL_MAX_MONTH;
                            pCSESA0DInputRec.getDtDtPlocEnd().year = Arcutls.ARC_UTL_MAX_YEAR;
                        }
                        else {
                            pCSESA0DInputRec.setDtDtPlocEnd(cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).getDtDtPlcmtEnd());
                        }
                        pCSESA0DInputRec.setSzCdPlocType(Csub31s.BILLING);
                        
                        //  Call DAM
                        
                        rc = csesa0dQUERYdam(sqlca, pCSESA0DInputRec, pCSESA0DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setSzCdPlocChild(pCSESA0DOutputRec.getSzCdPlocChild());
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00(i213).setSzCdPlocChild(NULL_STRING);
                                break;
                                
                            default :
                                
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                    
                default :
                    
                    RetVal = Csub50s.FND_FAIL;
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
        ARC_PRFServiceStopTime_TUX(cfad31si.getArchInputStruct() , cfad31so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            //  Call DAM
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfad31so;
    }

}
