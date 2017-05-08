package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV81DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON22S.src
**
** Service Name:  CCON22S - SVC AUTH DTL RTRV
**
** Description:   Depending on Window Mode, this retrieval service will
**                either populate the Service combo box, Persons Listbox
**                and/or Svc Auth Dtl Listbox.  If the Window Mode is 
**                Inquire, then a single row for Svc Auth Dtl Listbox will
**                be retrieved; if the Window Mode is Modify, then a single
**                row for Svc Auth Dtl Listbox will be retrieved, and a list
**                of Services will also be retrieved; if the Window Mode is 
**                New and no detail record exists, then a list of Services 
**                will be retrieved, a list of Persons will be retrieved and 
**                the Dt Situation Opened will be retrieved.  However, if the
**                window mode is New and a detail record does exist, then
**                a single row for Svc Auth Dtl Listbox, a list os Service
**                and Dt Situation Opened will be retrieved.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 30, 1995 
** 
** Programmer:    Sandra Wang
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   17 Jun 1997 16:46:06  $
**                      $Modtime:   17 Jun 1997 15:08:42  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/10/97  CYSKD     SVC AUTH ENH -- Added DAM CINT21D to service so
**                      Stage info. retrieved could be passed to Svc. Auth
**                      Detail window in its Pre-Display.
**
**  06/16/97  SARAVIG  Service Authorization Detail Enhancement.
**                     Window when the save pushbutton is clicked.In this
**                     service we are graving the start date of the stage and
**                     passing it on to ccon15w.win in order to be later
**                     passed to ccon23s.src.  In ccon23s.src a new edit was added
**                     during the SAVE service that will check and see is the service
**                     code exists in the Equivalency table for the given time period 
**                     and open stages for the client.  SIR#13575 
**
**  06/17/97  CYSKD    SVC AUTH ENH -- DAM Call to CINT21D was not neccessary.
**                     Removed it and modified code around CSES26D to pass 
**                     Stage Close date to output message.
**
**  06/26/03  Srini    SIR 18549 - Changed the marshaling of ulNbrCnsvcUnitRate
**						from Unsigned long to double.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon22s {
    public static final int INITIAL_PAGE = 1;
    CCON22SO CCON22S(CCON22SI ccon22si) {
        CCON22SO ccon22so = new CCON22SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i203 = 0;
        CSES25DI pCSES25DInputRec = null;/* This DAM is a simple full row */
        CSES25DO pCSES25DOutputRec = null;/* select based upon Id Svc Auth Dtl */
        CLSC19DI pCLSC19DInputRec = null;/* This DAM retrieves all services */
        CLSC19DO pCLSC19DOutputRec = null;/* based upon Cd County, Id Contract */
        CLSC18DI pCLSC18DInputRec = null;/* This DAM retrieves all Person Ids */
        CLSC18DO pCLSC18DOutputRec = null;/* for the principles base upon */
        CSES26DI pCSES26DInputRec = null;/* This DAM retrieves Dt Situation */
        CSES26DO pCSES26DOutputRec = null;/* Opened */
        CINV81DI pCINV81DInputRec = null;/* This DAM retrieves Nm Person Full */
        CINV81DO pCINV81DOutputRec = null;/* based upon Id Person */
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_PRFServiceStartTime_TUX(ccon22si.getArchInputStruct());
        
        rc = ARC_UTLGetDateAndTime(ccon22so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (WINDOW_MODE_MODIFY == ccon22si.getSzSysCdWinMode() || WINDOW_MODE_INQUIRE == ccon22si.getSzSysCdWinMode() || (WINDOW_MODE_NEW == ccon22si.getSzSysCdWinMode() && 0 != ccon22si.getUlIdSvcAuthDtl())) {
            //  Allocate memory for DAM Input and Output Structures 
            // for CSES25D
            pCSES25DInputRec = new CSES25DI();
            
            pCSES25DOutputRec = new CSES25DO();
            pCSES25DInputRec.setArchInputStruct(ccon22si.getArchInputStruct());
            pCSES25DInputRec.setUlIdSvcAuthDtl(ccon22si.getUlIdSvcAuthDtl());
            
            //  Call DAM
            rc = cses25dQUERYdam(sqlca, pCSES25DInputRec, pCSES25DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccon22so.getROWCCON22SOG01().setSzCdSvcAuthDtlAuthType(pCSES25DOutputRec.getSzCdSvcAuthDtlAuthType());
                    ccon22so.getROWCCON22SOG01().setSzCdSvcAuthDtlPeriod(pCSES25DOutputRec.getSzCdSvcAuthDtlPeriod());
                    ccon22so.getROWCCON22SOG01().setSzCdSvcAuthDtlSvc(pCSES25DOutputRec.getSzCdSvcAuthDtlSvc());
                    ccon22so.getROWCCON22SOG01().setSzCdSvcAuthDtlUnitType(pCSES25DOutputRec.getSzCdSvcAuthDtlUnitType());
                    ccon22so.getROWCCON22SOG01().setDtDtSvcAuthDtl(pCSES25DOutputRec.getDtDtSvcAuthDtl());
                    ccon22so.getROWCCON22SOG01().setDtDtSvcAuthDtlBegin(pCSES25DOutputRec.getDtDtSvcAuthDtlBegin());
                    ccon22so.getROWCCON22SOG01().setDtDtSvcAuthDtlEnd(pCSES25DOutputRec.getDtDtSvcAuthDtlEnd());
                    ccon22so.getROWCCON22SOG01().setDtDtSvcAuthDtlTerm(pCSES25DOutputRec.getDtDtSvcAuthDtlTerm());
                    ccon22so.getROWCCON22SOG01().setDtSvcAuthDtlShow(pCSES25DOutputRec.getDtSvcAuthDtlShow());
                    
                    ccon22so.getROWCCON22SOG01().setTsLastUpdate(pCSES25DOutputRec.getTsLastUpdate());
                    ccon22so.getROWCCON22SOG01().setUlIdPerson(pCSES25DOutputRec.getUlIdPerson());
                    ccon22so.getROWCCON22SOG01().setUlIdSvcAuthDtl(pCSES25DOutputRec.getUlIdSvcAuthDtl());
                    ccon22so.getROWCCON22SOG01().setLAmtSvcAuthDtlAmtReq(pCSES25DOutputRec.getLAmtSvcAuthDtlAmtReq());
                    ccon22so.getROWCCON22SOG01().setLAmtSvcAuthDtlAmtUsed(pCSES25DOutputRec.getLAmtSvcAuthDtlAmtUsed());
                    ccon22so.getROWCCON22SOG01().setUNbrSvcAuthDtlFreq(pCSES25DOutputRec.getUNbrSvcAuthDtlFreq());
                    ccon22so.getROWCCON22SOG01().setUlNbrSvcAuthDtlLineItm(pCSES25DOutputRec.getUlNbrSvcAuthDtlLineItm());
                    ccon22so.getROWCCON22SOG01().setLNbrSvcAuthDtlSugUnit(pCSES25DOutputRec.getLNbrSvcAuthDtlSugUnit());
                    ccon22so.getROWCCON22SOG01().setLNbrSvcAuthDtlUnitRate(pCSES25DOutputRec.getLNbrSvcAuthDtlUnitRate());
                    ccon22so.getROWCCON22SOG01().setLNbrSvcAuthDtlUnitUsed(pCSES25DOutputRec.getLNbrSvcAuthDtlUnitUsed());
                    ccon22so.getROWCCON22SOG01().setLNbrSvcAuthDtlUnitReq(pCSES25DOutputRec.getLNbrSvcAuthDtlUnitReq());
                    
                    
                    //  Allocate memory for DAM Input and Output Structures
                    // for CINV81D
                    pCINV81DInputRec = new CINV81DI();
                    
                    pCINV81DOutputRec = new CINV81DO();
                    pCINV81DInputRec.setArchInputStruct(ccon22si.getArchInputStruct());
                    pCINV81DInputRec.setUlIdPerson(pCSES25DOutputRec.getUlIdPerson());
                    
                    rc = cinv81dQUERYdam(sqlca, pCINV81DInputRec, pCINV81DOutputRec);
                    
                    // 19613
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ccon22so.getROWCCON22SOG01().setSzNmPersonFull(pCINV81DOutputRec.getSzNmPersonFull());
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
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
        if ((WINDOW_MODE_NEW == ccon22si.getSzSysCdWinMode() || WINDOW_MODE_MODIFY == ccon22si.getSzSysCdWinMode()) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
            //  Allocate memory for DAM Input and Output Structures 
            // for CLSC19D
            pCLSC19DInputRec = new CLSC19DI();
            
            pCLSC19DOutputRec = new CLSC19DO();
            pCLSC19DInputRec.setArchInputStruct(ccon22si.getArchInputStruct());
            pCLSC19DInputRec.setSzCdCncntyCounty(ccon22si.getSzCdSvcAuthCounty());
            pCLSC19DInputRec.setUlIdContract(ccon22si.getUlIdContract());
            pCLSC19DInputRec.setUlNbrCnsvcPeriod(ccon22si.getUlNbrCnperPeriod());
            pCLSC19DInputRec.setUlNbrCnsvcVersion(ccon22si.getUlNbrCnverVersion());
            pCLSC19DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pCLSC19DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon22si.getUlPageSizeNbr());
            rc = clsc19dQUERYdam(sqlca, pCLSC19DInputRec, pCLSC19DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CCON22SO to fields in CLSC19DO
                    for (i203 = 0;i203 < pCLSC19DOutputRec.getArchOutputStruct().getUlRowQty();i203++) {
                        ccon22so.getROWCCON22SOG02_ARRAY().getROWCCON22SOG02(i203).setSzCdCnsvcPaymentType(pCLSC19DOutputRec.getROWCLSC19DO_ARRAY().getROWCLSC19DO(i203).getSzCdCnsvcPaymentType());
                        ccon22so.getROWCCON22SOG02_ARRAY().getROWCCON22SOG02(i203).setSzCdCnsvcService(pCLSC19DOutputRec.getROWCLSC19DO_ARRAY().getROWCLSC19DO(i203).getSzCdCnsvcService());
                        ccon22so.getROWCCON22SOG02_ARRAY().getROWCCON22SOG02(i203).setSzNbrCnsvcUnitType(pCLSC19DOutputRec.getROWCLSC19DO_ARRAY().getROWCLSC19DO(i203).getSzNbrCnsvcUnitType());
                        ccon22so.getROWCCON22SOG02_ARRAY().getROWCCON22SOG02(i203).setUlNbrCnsvcLineItem(pCLSC19DOutputRec.getROWCLSC19DO_ARRAY().getROWCLSC19DO(i203).getUlNbrCnsvcLineItem());
                        ccon22so.getROWCCON22SOG02_ARRAY().getROWCCON22SOG02(i203).setUlNbrCnsvcUnitRate(pCLSC19DOutputRec.getROWCLSC19DO_ARRAY().getROWCLSC19DO(i203).getUlNbrCnsvcUnitRate());
                    }
                    ccon22so.setUlRowQty(pCLSC19DOutputRec.getArchOutputStruct().getUlRowQty());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CON_CONTRACT_SVC;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if ((WINDOW_MODE_NEW == ccon22si.getSzSysCdWinMode() || WINDOW_MODE_MODIFY == ccon22si.getSzSysCdWinMode()) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
            //  Allocate memory for DAM Input and Output Structures
            // for CSES26D
            pCSES26DInputRec = new CSES26DI();
            
            pCSES26DOutputRec = new CSES26DO();
            pCSES26DInputRec.setArchInputStruct(ccon22si.getArchInputStruct());
            pCSES26DInputRec.setUlIdStage(ccon22si.getUlIdStage());
            
            
            
            //  Start Performance Timer
            rc = cses26dQUERYdam(sqlca, pCSES26DInputRec, pCSES26DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccon22so.setDtDtSituationOpened(pCSES26DOutputRec.getDtDtSituationOpened());
                    ccon22so.setDtDtStageClose(pCSES26DOutputRec.getDtDtStageClose());
                    
                    ccon22so.setDtDtStageStart(pCSES26DOutputRec.getDtDtStageStart());
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        /*
        ** If no closing summary contacts are found with a status of
        ** Complete, Pend, or Aprv, display an error message notifying the
        ** user that a Closing Summary must be completed before saving
        ** and submitting
        */
        
        /**SIR 23716 Dunawakl Added logic to ensure exclusion of C-REG and C-GUA from message*/
        
        if (WINDOW_MODE_NEW == ccon22si.getSzSysCdWinMode() && 0 == ccon22si.getUlIdSvcAuthDtl() && WtcHelperConstants.SQL_SUCCESS == rc) {
            //  Allocate memory for DAM Input and Output Structures
            // for CLSC18D
            pCLSC18DInputRec = new CLSC18DI();
            
            pCLSC18DOutputRec = new CLSC18DO();
            pCLSC18DInputRec.setArchInputStruct(ccon22si.getArchInputStruct());
            pCLSC18DInputRec.setSzCdStagePersType(ccon22si.getSzCdStagePersType());
            pCLSC18DInputRec.setUlIdStage(ccon22si.getUlIdStage());
            pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon22si.getArchInputStruct().getUlPageSizeNbr());
            
            
            
            //  Initialize Service Status Fields
            
            
            
            //  Perform Main Processing
            
            
            //  Set CARC16SO WCD DtSystemDate to current date
            rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
            
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CCON22SO to fields in CLSC18DO
                    for (i203 = 0;i203 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty();i203++) {
                        ccon22so.getROWCCON22SOG00_ARRAY().getROWCCON22SOG00(i203).setSzCdStagePersRelInt(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i203).getSzCdStagePersRelInt());
                        ccon22so.getROWCCON22SOG00_ARRAY().getROWCCON22SOG00(i203).setSzCdStagePersRole(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i203).getSzCdStagePersRole());
                        ccon22so.getROWCCON22SOG00_ARRAY().getROWCCON22SOG00(i203).setSzNmPersonFull(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i203).getSzNmPersonFull());
                        
                        ccon22so.getROWCCON22SOG00_ARRAY().getROWCCON22SOG00(i203).setUlIdPerson(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i203).getUlIdPerson());
                    }
                    ccon22so.getArchOutputStruct().setUlRowQty(pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_CON_PRINCIPLE;
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
        ARC_PRFServiceStopTime_TUX(ccon22si.getArchInputStruct() , ccon22so.getArchOutputStruct());
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
        return ccon22so;
    }

}
