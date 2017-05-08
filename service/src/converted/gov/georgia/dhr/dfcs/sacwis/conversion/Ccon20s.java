package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC10DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC10DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC12DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CCON20S.src
**
** Service Name:   CCON20S - Contract Validation
**
** Description:   This service serves to determine whether a contract for a 
**                particular resource is valid, and if so, to retrieve 
**                certain information for that contract.
**
**                The CONTRACT_COUNTY table is accessed using the County,
**                Service, and Resource Id as a key.  The current date must 
**                also be between the effective dates of the contract.  
**                Based on the ID CONTRACT retrieved from the CONTRACT_COUNTY
**                table, the CONTRACT_PERIOD and CONTRACT tables are 
**                accessed. The Status of the contract must be either 
**                'Active' or 'Pay/Hold' (the DAM will perform this validation).
**                Contract information is returned to the window.
**
**                If the Period number is not 1 then the CONTRACT_PERIOD 
**                table must be accessed again to get the start date of the
**                first period.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  24 October 1995 
** 
** Programmer:    Brian McRae
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   12 Sep 1996 10:42:34  $
**                      $Modtime:   12 Sep 1996 08:45:00  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/29/95  FOGARTIS  Added set of CSEC10D input record date to null so
**                      that the dam uses current date for validation.
**
**  12/12/95  MCRAEBS   Added ClosureDate, StartDate, and IdContract to 
**                      CSEC11D Output.  CCON13W.WIN nulls theses fields 
**                      on a data change of Resource search criteria.
**
**  01/03/96  MCRAEBS   SIR 2447 - Copy IndCntrctBudgLimit from 
**                      CSEC11DO to OuputMsg. Will be used by CCON15
**                      for MsgBox validation.  BSM
**  
**  04/11/96  WILSONET  SVC-FIX: Remove all references to CSEC11D and 
**                      replace with CSEC72D.  The only difference between
**                      the two DAMs is that SEC72 will search for contracts
**                      of any status other than 'PENDING'.
**
**  08/18/96  ODONNERJ  SIR# 20906: Removed the SVC-FIX - add CSEC11D back
**                      wherever it was removed from.
**
**  09/12/96  MCRAEBS   Addition to SIR 22267 - Services cannot be Authorized
**                      against Contracts that are Pending, Svc Hold, or 
**                      Pay/Svc Hold.
**
**  03/17/03  Srini     Modified to return the error message instead of success 
**			by  setting the rc to MSG_CON_NO_ACTIVE_CONTRACT.
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






public class Ccon20s {
    
    /*
    ** Declare FOUNDATION variables 
    */
    
    /*
    ** Declare local variables 
    */
    
    static final int NUM_PERIOD = 1;
    CCON20SO CCON20S(CCON20SI ccon20si) {
        CCON20SO ccon20so = new CCON20SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CCON20S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i201 = 0;
        
        /*
        ** declare CSEC10D - Contract County SEC
        */
        public CSEC10DI pCSEC10DInputRec = null;
        CSEC10DO pCSEC10DOutputRec = null;
        
        /*
        ** declare CSEC72D - Contract/Period Validate SEC
        ** SVC-FIX: Instead of CSEC11D, use CSEC72D.  CSEC72 permits
        ** all stati other than PENDING to be returned successfully.
        */
        CSEC11DI pCSEC11DInputRec = null;
        CSEC11DO pCSEC11DOutputRec = null;
        
        /*
        ** declare CSEC12D - Contract by Period 1 SEC
        */
        CSEC12DI pCSEC12DInputRec = null;
        CSEC12DO pCSEC12DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccon20si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /*********************** BEGIN PERFORM MAIN PROCESSING ********************/
        
        /*
        ** Call CSEC10D - performs current date check
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSEC10DInputRec = new CSEC10DI();
        
        pCSEC10DOutputRec = new CSEC10DO();
        pCSEC10DInputRec.setArchInputStruct(ccon20si.getArchInputStruct());
        pCSEC10DInputRec.setUlIdResource(ccon20si.getUlIdResource());
        pCSEC10DInputRec.setSzCdCncntyCounty(ccon20si.getSzCdSvcAuthCounty());
        pCSEC10DInputRec.setSzCdCncntyService(ccon20si.getSzCdSvcAuthService());
        pCSEC10DInputRec.getDtScrDtCurrentDate().month = ccon20si.getDtDtSvcAuthEff().month;
        pCSEC10DInputRec.getDtScrDtCurrentDate().day = ccon20si.getDtDtSvcAuthEff().day;
        pCSEC10DInputRec.getDtScrDtCurrentDate().year = ccon20si.getDtDtSvcAuthEff().year;
        rc = csec10dQUERYdam(sqlca, pCSEC10DInputRec, pCSEC10DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccon20so.setUlIdContract(pCSEC10DOutputRec.getUlIdContract());
                ccon20so.setUlNbrCncntyPeriod(pCSEC10DOutputRec.getUlNbrCncntyPeriod());
                ccon20so.setUlNbrCncntyVersion(pCSEC10DOutputRec.getUlNbrCncntyVersion());
                
                //  Allocate memory for DAM Input and Output Structures
                pCSEC11DInputRec = new CSEC11DI();
                
                pCSEC11DOutputRec = new CSEC11DO();
                pCSEC11DInputRec.setArchInputStruct(ccon20si.getArchInputStruct());
                pCSEC11DInputRec.setUlIdContract(ccon20so.getUlIdContract());
                pCSEC11DInputRec.setUlNbrCnperPeriod(ccon20so.getUlNbrCncntyPeriod());
                
                //  Call DAM
                rc = csec11dQUERYdam(sqlca, pCSEC11DInputRec, pCSEC11DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ccon20so.setUlIdCntrctManager(pCSEC11DOutputRec.getUlIdCntrctManager());
                        ccon20so.setUlIdContract(pCSEC11DOutputRec.getUlIdContract());
                        ccon20so.setCIndCnperRenewal(pCSEC11DOutputRec.getCIndCnperRenewal());
                        ccon20so.setDtDtCnperStart(pCSEC11DOutputRec.getDtDtCnperStart());
                        ccon20so.setDtDtCnperClosure(pCSEC11DOutputRec.getDtDtCnperClosure());
                        ccon20so.setSzCdCntrctRegion(pCSEC11DOutputRec.getSzCdCntrctRegion());
                        ccon20so.setSzCdCnperStatus(pCSEC11DOutputRec.getSzCdCnperStatus());
                        ccon20so.setCIndCntrctBudgLimit(pCSEC11DOutputRec.getCIndCntrctBudgLimit());
                        if (NUM_PERIOD != pCSEC11DOutputRec.getUlNbrCnperPeriod()) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCSEC12DInputRec = new CSEC12DI();
                            
                            pCSEC12DOutputRec = new CSEC12DO();
                            pCSEC12DInputRec.setArchInputStruct(ccon20si.getArchInputStruct());
                            pCSEC12DInputRec.setUlIdContract(ccon20so.getUlIdContract());
                            pCSEC12DInputRec.setUlNbrCnperPeriod(NUM_PERIOD);
                            rc = csec12dQUERYdam(sqlca, pCSEC12DInputRec, pCSEC12DOutputRec);
                            
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    ccon20so.setDtDtCnperStart(pCSEC12DOutputRec.getDtDtCnperStart());
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                    
                                    //  Declare FOUNDATION variables
                                    
                                    //  Declare local variables
                                    
                                    //  Start performance timer for service. All performance functions always
                                    // return success so there is no need to check status.
                                    
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
                        pServiceStatus.explan_code = Messages.MSG_CON_NO_ACTIVE_CONTRACT;
                        
                        // SIR 21891 - missing versioning
                        //  Run-time Versioning
                        
                        //  Check buffer size
                        
                        //  Process error message and return to client
                        
                        //  Initialize output message and length
                        
                        //  Initialize service status fields
                        
                        // 
                        // Get System Date and Time for return to Client
                        // 
                        
                        rc = Messages.MSG_CON_NO_ACTIVE_CONTRACT;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CON_NO_ACTIVE_CONTRACT;
                rc = Messages.MSG_CON_NO_ACTIVE_CONTRACT;
                
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
        ARC_PRFServiceStopTime_TUX(ccon20si.getArchInputStruct() , ccon20so.getArchOutputStruct());
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
                //  InputMsg is other than IdStages, retrieve staff list via DAM 50
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccon20so;
    }

}
