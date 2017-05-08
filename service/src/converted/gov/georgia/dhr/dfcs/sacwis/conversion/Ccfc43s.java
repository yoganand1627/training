package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC43SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES65DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES65DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES69DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CCFC43S.src
**
** Service Name:   CCFC43S
**
** Description:   If an ID_EVENT is passed into the service: This service 
**                  will retrieve an entire row from the EVENT table given 
**                  an ID  EVENT(SSMN45D), retrieve an entire row from the 
**                  ADMIN REVIEW table given ID EVENT(CSES65D) and check for
**                  the presence of the Administrative Review and Appeal 
**                  Narrative given ID EVENT (CSYS06D).  The service will 
**                  also retrieve the Admin Rview Program (CINT21D) and if 
**                  an ID PERSON REQUESTOR exists for the Admin Review 
**                  record, that person's NmPersonFull will be retrieved
**                  (CINV81D).
**
**                If no ID EVENT is passed into the service but an ID STAGE 
**                  is passed in: This service will retrieve an entire row 
**                  from the ADMIN REVIEW table given ID STAGE (CSES69D), 
**                  it will retrieve an entire row from the EVENT table 
**                  given an ID EVENT (CCMN45D), and check for the presence 
**                  of the Administrative Review and Appeal Narrative given 
**                  ID EVENT (CSYS06D).  the service will also retrieve the 
**                  Admin Review Program (CINT21D) and if an ID PERSON 
**                  REQUESTOR exists for the Admin Review record, that 
**                  person's NmPersonFull will be retrieved (CINV81D). 
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/10/1996 
** 
** Programmer:    ODONNERJ
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   12 May 1997 10:25:12  $
**                      $Modtime:   28 Apr 1997 09:44:48  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  4/14/97  DURANG     SIR# 13618 - MHMR Enhancement. Added the 
**                      retrieval of both Review requested by and 
**                      Requester name from CSES65D and CSES69D.  
**                      These dams retrieve  information from the 
**                      Admin Review table.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc43s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final String ADMIN_REVIEW_NARRATIVE = "admin_review_narr";
    CCFC43SO CCFC43S(CCFC43SI ccfc43si) {
        CCFC43SO ccfc43so = new CCFC43SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i65 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /*
        ** CINT21D - STAGE RTRV -- WHAT IT DOES, WHEN IT IS CALLED, ETC.
        */
        
        CINV81DI pCINV81DInputRec = null;
        CINV81DO pCINV81DOutputRec = null;
        
        /*
        ** CINV81D - RTRV PERSON INFO -- WHAT IT DOES, WHEN IT IS CALLED, ETC.
        */
        
        CSES65DI pCSES65DInputRec = null;
        CSES65DO pCSES65DOutputRec = null;
        
        /*
        ** CSES65D - ADMIN REV BY EVENT -- WHAT IT DOES, WHEN IT IS CALLED, ETC.
        */
        
        CSES69DI pCSES69DInputRec = null;
        CSES69DO pCSES69DOutputRec = null;
        
        /*
        ** CSES69D - ADMIN REV BY STAGE -- WHAT IT DOES, WHEN IT IS CALLED, ETC.
        */
        
        CSYS06DI pCSYS06DInputRec = null;
        CSYS06DO pCSYS06DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccfc43si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccfc43so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (0 != ccfc43si.getUlIdEvent()) {
            //  Call CCMN45D
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN45DInputRec = new CCMN45DI();
            
            pCCMN45DOutputRec = new CCMN45DO();
            pCCMN45DInputRec.setArchInputStruct(ccfc43si.getArchInputStruct());
            pCCMN45DInputRec.setUlIdEvent(ccfc43si.getUlIdEvent());
            
            //  Call DAM
            rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccfc43so.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                    ccfc43so.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                    ccfc43so.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                    ccfc43so.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                    ccfc43so.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                    ccfc43so.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                    ccfc43so.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                    ccfc43so.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                    ccfc43so.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                    
                    
                    
                    //  Call CSES65D
                    
                    // 
                    // Call CSES65D
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES65DInputRec = new CSES65DI();
                    
                    pCSES65DOutputRec = new CSES65DO();
                    pCSES65DInputRec.setArchInputStruct(ccfc43si.getArchInputStruct());
                    pCSES65DInputRec.setUlIdEvent(ccfc43si.getUlIdEvent());
                    rc = cses65dQUERYdam(sqlca, pCSES65DInputRec, pCSES65DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ccfc43so.getCCFC43SOG00().setSzCdAdminRvReqBy(pCSES65DOutputRec.getSzCdAdminRvReqBy());
                            ccfc43so.getCCFC43SOG00().setSzScrNmReviewReqBy(pCSES65DOutputRec.getSzScrNmReviewReqBy());
                            ccfc43so.getCCFC43SOG00().setSzCdAdminRvAppealResult(pCSES65DOutputRec.getSzCdAdminRvAppealResult());
                            ccfc43so.getCCFC43SOG00().setSzCdAdminRvAppealType(pCSES65DOutputRec.getSzCdAdminRvAppealType());
                            ccfc43so.getCCFC43SOG00().setSzCdAdminRvAuth(pCSES65DOutputRec.getSzCdAdminRvAuth());
                            ccfc43so.getCCFC43SOG00().setSzCdAdminRvStatus(pCSES65DOutputRec.getSzCdAdminRvStatus());
                            ccfc43so.getCCFC43SOG00().setTsLastUpdate(pCSES65DOutputRec.getTsLastUpdate());
                            ccfc43so.getCCFC43SOG00().setDtDtAdminRvAppealNotif(pCSES65DOutputRec.getDtDtAdminRvAppealNotif());
                            ccfc43so.getCCFC43SOG00().setDtDtAdminRvAppealReview(pCSES65DOutputRec.getDtDtAdminRvAppealReview());
                            ccfc43so.getCCFC43SOG00().setDtDtAdminRvDue(pCSES65DOutputRec.getDtDtAdminRvDue());
                            ccfc43so.getCCFC43SOG00().setDtDtAdminRvEmgcyRel(pCSES65DOutputRec.getDtDtAdminRvEmgcyRel());
                            ccfc43so.getCCFC43SOG00().setDtDtAdminRvHearing(pCSES65DOutputRec.getDtDtAdminRvHearing());
                            ccfc43so.getCCFC43SOG00().setDtDtAdminRvReqAppeal(pCSES65DOutputRec.getDtDtAdminRvReqAppeal());
                            ccfc43so.getCCFC43SOG00().setUlIdEvent(pCSES65DOutputRec.getUlIdEvent());
                            ccfc43so.getCCFC43SOG00().setUlIdPersonRequestor(pCSES65DOutputRec.getUlIdPersonRequestor());
                            ccfc43so.getCCFC43SOG00().setUlIdStage(pCSES65DOutputRec.getUlIdStage());
                            ccfc43so.getCCFC43SOG00().setUlIdStageRelated(pCSES65DOutputRec.getUlIdStageRelated());
                            ccfc43so.getCCFC43SOG00().setCIndAdminRvEmgcyRel(pCSES65DOutputRec.getCIndAdminRvEmgcyRel());
                            
                            
                            //  Call CSYS06D
                            
                            // 
                            // Call CSYS06D
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCSYS06DInputRec = new CSYS06DI();
                            
                            pCSYS06DOutputRec = new CSYS06DO();
                            pCSYS06DInputRec.setArchInputStruct(ccfc43si.getArchInputStruct());
                            pCSYS06DInputRec.setUlIdEvent(ccfc43si.getUlIdEvent());
                            pCSYS06DInputRec.setSzSysTxtTablename(ADMIN_REVIEW_NARRATIVE);
                            rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    ccfc43so.setBIndBLOBExistsInDatabase(true);
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    ccfc43so.setBIndBLOBExistsInDatabase(false);
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Call DAM to add or update row in CPS INVST DETAIL TABLE for a given
                            // event and last update timestamp
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
        }
        
        /**************************************************************************
        **  (END): CCMN45D
        **************************************************************************/
        
        
        
        
        
        else {
            //  Call CSES69D
            
            // 
            // CSES69D
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES69DInputRec = new CSES69DI();
            
            pCSES69DOutputRec = new CSES69DO();
            
            pCSES69DInputRec.setArchInputStruct(ccfc43si.getArchInputStruct());
            pCSES69DInputRec.setUlIdStage(ccfc43si.getUlIdStage());
            rc = cses69dQUERYdam(sqlca, pCSES69DInputRec, pCSES69DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccfc43so.getCCFC43SOG00().setSzCdAdminRvReqBy(pCSES69DOutputRec.getSzCdAdminRvReqBy());
                    
                    ccfc43so.getCCFC43SOG00().setSzScrNmReviewReqBy(pCSES69DOutputRec.getSzScrNmReviewReqBy());
                    ccfc43so.getCCFC43SOG00().setSzCdAdminRvAppealResult(pCSES69DOutputRec.getSzCdAdminRvAppealResult());
                    ccfc43so.getCCFC43SOG00().setSzCdAdminRvAppealType(pCSES69DOutputRec.getSzCdAdminRvAppealType());
                    ccfc43so.getCCFC43SOG00().setSzCdAdminRvAuth(pCSES69DOutputRec.getSzCdAdminRvAuth());
                    ccfc43so.getCCFC43SOG00().setSzCdAdminRvStatus(pCSES69DOutputRec.getSzCdAdminRvStatus());
                    ccfc43so.getCCFC43SOG00().setDtDtAdminRvAppealNotif(pCSES69DOutputRec.getDtDtAdminRvAppealNotif());
                    ccfc43so.getCCFC43SOG00().setDtDtAdminRvAppealReview(pCSES69DOutputRec.getDtDtAdminRvAppealReview());
                    ccfc43so.getCCFC43SOG00().setDtDtAdminRvDue(pCSES69DOutputRec.getDtDtAdminRvDue());
                    ccfc43so.getCCFC43SOG00().setDtDtAdminRvEmgcyRel(pCSES69DOutputRec.getDtDtAdminRvEmgcyRel());
                    ccfc43so.getCCFC43SOG00().setDtDtAdminRvHearing(pCSES69DOutputRec.getDtDtAdminRvHearing());
                    ccfc43so.getCCFC43SOG00().setDtDtAdminRvReqAppeal(pCSES69DOutputRec.getDtDtAdminRvReqAppeal());
                    ccfc43so.getCCFC43SOG00().setTsLastUpdate(pCSES69DOutputRec.getTsLastUpdate());
                    
                    ccfc43so.getCCFC43SOG00().setUlIdEvent(pCSES69DOutputRec.getUlIdEvent());
                    ccfc43so.getCCFC43SOG00().setUlIdPersonRequestor(pCSES69DOutputRec.getUlIdPersonRequestor());
                    ccfc43so.getCCFC43SOG00().setUlIdStage(pCSES69DOutputRec.getUlIdStage());
                    ccfc43so.getCCFC43SOG00().setUlIdStageRelated(pCSES69DOutputRec.getUlIdStageRelated());
                    ccfc43so.getCCFC43SOG00().setCIndAdminRvEmgcyRel(pCSES69DOutputRec.getCIndAdminRvEmgcyRel());
                    
                    
                    //  Call CCMN45D
                    // 
                    // CCMN45D
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN45DInputRec = new CCMN45DI();
                    
                    pCCMN45DOutputRec = new CCMN45DO();
                    pCCMN45DInputRec.setArchInputStruct(ccfc43si.getArchInputStruct());
                    pCCMN45DInputRec.setUlIdEvent(pCSES69DOutputRec.getUlIdEvent());
                    rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ccfc43so.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                            ccfc43so.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                            ccfc43so.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                            ccfc43so.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                            ccfc43so.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                            ccfc43so.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                            ccfc43so.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                            
                            ccfc43so.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                            ccfc43so.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                            
                            
                            //  Call CSYS06D
                            
                            // 
                            // Call CSYS06D
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCSYS06DInputRec = new CSYS06DI();
                            
                            pCSYS06DOutputRec = new CSYS06DO();
                            pCSYS06DInputRec.setArchInputStruct(ccfc43si.getArchInputStruct());
                            pCSYS06DInputRec.setUlIdEvent(pCSES69DOutputRec.getUlIdEvent());
                            pCSYS06DInputRec.setSzSysTxtTablename(ADMIN_REVIEW_NARRATIVE);
                            rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    ccfc43so.setBIndBLOBExistsInDatabase(true);
                                    
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    ccfc43so.setBIndBLOBExistsInDatabase(false);
                                    
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
                            
                            // 
                            // Service Macro Definitions
                            // 
                            
                            
                            // 
                            // Function Prototypes
                            // 
                            
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    
                    // 
                    // (END): DAM: cinv43d   To Do Completed
                    // Processing
                    // 
                    
                    
                    break;
            }
        }
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            //  Call CINT21D
            
            // 
            // CINT21D
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCINT21DInputRec = new CINT21DI();
            
            pCINT21DOutputRec = new CINT21DO();
            pCINT21DInputRec.setArchInputStruct(ccfc43si.getArchInputStruct());
            pCINT21DInputRec.setUlIdStage(ccfc43si.getUlIdStage());
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccfc43so.setSzCdStageProgram(pCINT21DOutputRec.getSzCdStageProgram());
                    if (ccfc43so.getCCFC43SOG00().getUlIdPersonRequestor() > 0) {
                        //  Call CINV81D - RTRV PERSON INFO
                        // 
                        // Call CINV81D
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCINV81DInputRec = new CINV81DI();
                        
                        pCINV81DOutputRec = new CINV81DO();
                        pCINV81DInputRec.setArchInputStruct(ccfc43si.getArchInputStruct());
                        pCINV81DInputRec.setUlIdPerson(ccfc43so.getCCFC43SOG00().getUlIdPersonRequestor());
                        rc = cinv81dQUERYdam(sqlca, pCINV81DInputRec, pCINV81DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                ccfc43so.setSzNmPersonFull(pCINV81DOutputRec.getSzNmPersonFull());
                                
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
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    
                    
                    
                    // 
                    // OPTIONAL CODE NOTE (END): Generic AUD
                    // 
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        /**************************************************************************
        ** OPTIONAL CODE NOTE (END): Calculate Output Message Size for either
        ** a single row retrieval or a Simple retrieval
        **************************************************************************/
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc43si.getArchInputStruct() , ccfc43so.getArchOutputStruct());
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
                //  PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        
        return ccfc43so;
    }

}
