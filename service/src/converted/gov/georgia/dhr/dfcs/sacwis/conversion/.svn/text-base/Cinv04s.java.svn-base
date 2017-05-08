package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccfc23s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV39DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS79DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS79DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV79DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV79DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV52DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN25DO;
/*************************************************************************
**
** Module File:   CINV04C.src
**
** Service Name:  Retrieve Person Detail
**
** Description:   This Service Retrieves all the information for the
**                person detail window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/15/95
**
** Programmer:    Diane M Verso
**
** DAMS called:   CINV39D
**                CCMN44D
**                CINV29D
**                CINV33D
**                CCMN40D
**                CINV79D
**                CINV52D
**                CSES46D
**                CSES47D
**                CSYS13D
**                CLSS79D
**                CLSS80D
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
** 03/27/95  WEALANBC   Added '=' to two statements to properly populate the
**                      Output Message.  (CINV33D)
**
** 03/30/95  WEALANBC   Added a check to see if return code is SQL_NOT_FOUND
**                      when in BROWSE mode from Search window.  This will
**                      allow for proper error handling. (CINV39D)
**
** 10/26/95  HELMKEST   SIR #1955: Call DAM's CSES46D and CSES47D to
**                      determine if the person is on these tables.
**
** 11/07/95  OVERENTR   SIR 1969 - Added new document architecture.  Needed to add
**                      a call to the CSYS13D dam in order to set the indicator for any
**                      BLOBs found on the database.
**
** 01/17/96  ELLIOTSL   SIR 2727 - szCdEventStatus has been removed
**                      from CINV79DI.
**
** 02/28/96  ELLIOTSL   SIR 5037: ID STAGE is now being passed to CINVB5D
**                      so that allegations will only be checked for the
**                      current stage.
**
** 7/8/96    DYARGR     SIR 21631 - Performance. Replace CSYS13D with CDYN25D
**                      so that BLOB retrieval would be faster.
**
** 7/16/96   DYARGR     SIR 21631 - Change the index name for the comm. report
**
** 10/11/00  GRIERDH    SIR 15012 - Get information for the new person race
**                                  window.  Get information from two different DAMS.
**
** 06/15/01	 ANG		Security upgrade - added code so that when a person with
** 						the SEC_MNTN_PERSON attribute coming from Person Search
**						accesses person Detail, the service will understand
**						WINDOW_MODE_MNTN_PERSON.  This code will be added
** 						in the Call CINV39D Function
**
** 12/12/02  Srini D    Replaced all occurences of WINDOW_MODE_BROWSE with
**			            WINDOW_MODE_INQUIRE
**
**  04/29/04  corleyan  SIR 14516 Add ulIdCase as an input to cses46 so that
**                      the "in home" rows
**                      will only be selected if they are not in the case
**                      we are currently in.
**
** 01/13/05   Hadjimh   SIR# 22914: Clicking on hyperlink of name to get to
**                      person detail causes error
**
** 09/26/05  Malpans    SIR 24002 -Disaster Relief Indicator added on
**	           		    Person Detail Page.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv04s {
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char WINDOW_MODE_LOWER = 'L';
    public static final char WINDOW_MODE_MNTN_PERSON = 'M';
    public static final String CD_EVENT_APPROVED = "APRV";
    public static final String INITIAL_DEATH_TABLE = "INIT_CHLD_DTH_NARR_VIEW";
    public static final String COMMITTEE_DEATH_TABLE = "CHLD_DTH_COMM_NARR_VIEW";
    public static final int INITIAL_DOC_INDEX = 0;
    public static final int COMMITTEE_DOC_INDEX = 1;
    CINV04SO CINV04S(CINV04SI cinv04si) {
        CINV04SO cinv04so = new CINV04SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(cinv04si.getArchInputStruct());
        rc = CallCINV79D(cinv04si, cinv04so, pServiceStatus);
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            
        }
        
        rc = CallCINV39D(cinv04si, cinv04so, pServiceStatus);
        
        
        
        /*
        ** Retrieve Home History Row given Id Event
        */
        if (rc != SUCCESS) {
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        rc = Ccmn03u.CallCCMN44D(cinv04si, cinv04so, pServiceStatus);
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccmn04s.CallCLSS79D(cinv04si, cinv04so, pServiceStatus);
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccmn04s.CallCLSS80D(cinv04si, cinv04so, pServiceStatus);
        
        
        
        
        if (rc != SUCCESS) {
            //  SIR# 3899 - Add the following DAMS to Re-retrieve tsLastUpdate for
            // Facil_alleg and allegation
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccfc23s.CallCINV29D(cinv04si, cinv04so, pServiceStatus);
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        rc = Ccmn02u.CallCINV33D(cinv04si, cinv04so, pServiceStatus);
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        rc = CallCINV52D(cinv04si, cinv04so, pServiceStatus);
        if (rc != SUCCESS) {
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccmn04s.CallCCMN40D(cinv04si, cinv04so, pServiceStatus);
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = CallCSES46D(cinv04si, cinv04so, pServiceStatus);
        
        /* check to see if there are any principals that are parents */
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = CallCSES47D(cinv04si, cinv04so, pServiceStatus);
        /* check the gender of the adoptive parent principals */
        if (rc != SUCCESS) {
            
            // Function prototypes
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        rc = CallCDYN25D(cinv04si, cinv04so, pServiceStatus);
        /* check the gender of the foster parent principals */
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        rc = ARC_UTLGetDateAndTime(cinv04so.getDtWCDDtSystemDate() , 0);
        /* check the gender of the adoptive/foster parent principals */
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = CallCINVB5D(cinv04si, cinv04so, pServiceStatus);
        
        if (rc != SUCCESS) {
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv04si.getArchInputStruct() , cinv04so.getArchOutputStruct());
        
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
        return cinv04so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV04SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCINV39D(CINV04SI pInputMsg510, CINV04SO pOutputMsg468, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV39DI pCINV39DInputRec = null;
        CINV39DO pCINV39DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV39DInputRec = new CINV39DI();
        
        pCINV39DOutputRec = new CINV39DO();
        pCINV39DInputRec.setArchInputStruct(pInputMsg510.getArchInputStruct());
        
        pCINV39DInputRec.setUlIdStage(pInputMsg510.getUlIdStage());
        pCINV39DInputRec.setUlIdPerson(pInputMsg510.getUlIdPerson());
        
        /*
        ** Set rc to RetVal so TUX_CHECK_APPL_STATUS will work
        */
        rc = cinv39dQUERYdam(sqlca, pCINV39DInputRec, pCINV39DOutputRec);
        
        /* SIR 21130b - if the closure event is pending then do not call post
        ** event invalidate the approval.
        */
        if (rc != 0 && ((WINDOW_MODE_LOWER != pInputMsg510.getSzSysCdWinMode()) && (WINDOW_MODE_INQUIRE != pInputMsg510.getSzSysCdWinMode()) && (WINDOW_MODE_MNTN_PERSON != pInputMsg510.getSzSysCdWinMode()))) {
            
            
            //  Analyze return code
            switch (rc) {
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            if ((WINDOW_MODE_LOWER == pInputMsg510.getSzSysCdWinMode()) || (WINDOW_MODE_INQUIRE == pInputMsg510.getSzSysCdWinMode()) || (WINDOW_MODE_MNTN_PERSON == pInputMsg510.getSzSysCdWinMode())) {
                
                
                //  Analyze return code
                switch (rc) {
                    case NO_DATA_FOUND:
                        pOutputMsg468.setBSysIndInStage(false);
                        rc = 0;
                        break;
                    case WtcHelperConstants.SQL_SUCCESS:
                        pOutputMsg468.setBSysIndInStage(true);
                        break;
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
            pOutputMsg468.setSzCdStagePersType(pCINV39DOutputRec.getSzCdStagePersType());
            
            pOutputMsg468.setSzCdStagePersRole(pCINV39DOutputRec.getSzCdStagePersRole());
            pOutputMsg468.setBIndStagePersReporter(pCINV39DOutputRec.getBIndStagePersReporter());
            
            pOutputMsg468.setBIndStagePersInLaw(pCINV39DOutputRec.getBIndStagePersInLaw());
            pOutputMsg468.setSzCdStagePersRelInt(pCINV39DOutputRec.getSzCdStagePersRelInt());
            
            pOutputMsg468.setUlIdStagePerson(pCINV39DOutputRec.getUlIdStagePerson());
            pOutputMsg468.setTsLastUpdate(pCINV39DOutputRec.getTsLastUpdate());
            pOutputMsg468.setSzCdStagePersSearchInd(pCINV39DOutputRec.getSzCdStagePersSearchInd());
        }
        return rc;
    }

    static int CallCCMN44D(CINV04SI pInputMsg511, CINV04SO pOutputMsg469, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN44DInputRec = new CCMN44DI();
        
        pCCMN44DOutputRec = new CCMN44DO();
        
        pCCMN44DInputRec.setArchInputStruct(pInputMsg511.getArchInputStruct());
        pCCMN44DInputRec.setUlIdPerson(pInputMsg511.getUlIdPerson());
        
        /* Set rc to ARC_SUCCESS */
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        if (rc != 0) {
            switch (rc) {
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            
            // 
            // Function Prototypes
            // 
            pOutputMsg469.setBIndPersonDobApprox(pCCMN44DOutputRec.getBIndPersonDobApprox());
            pOutputMsg469.setSzCdPersonLivArr(pCCMN44DOutputRec.getSzCdPersonLivArr());
            pOutputMsg469.setSzCdPersGuardCnsrv(pCCMN44DOutputRec.getSzCdPersGuardCnsrv());
            
            pOutputMsg469.setSzCdPersonDeath(pCCMN44DOutputRec.getSzCdPersonDeath());
            pOutputMsg469.setSzCdPersonEthnicGroup(pCCMN44DOutputRec.getSzCdPersonEthnicGroup());
            pOutputMsg469.setSzCdPersonLanguage(pCCMN44DOutputRec.getSzCdPersonLanguage());
            
            pOutputMsg469.setSzCdPersonMaritalStatus(pCCMN44DOutputRec.getSzCdPersonMaritalStatus());
            pOutputMsg469.setSzCdPersonReligion(pCCMN44DOutputRec.getSzCdPersonReligion());
            pOutputMsg469.setCCdPersonSex(pCCMN44DOutputRec.getCCdPersonSex());
            
            // SIR 1972: Comment Out No Longer needed Function Prototype
            // 
            // static long CallCINV86D(_CINV56SI *,
            // _CINV56SO *,
            // TUX_DECL_STATUSPARMS);
            // 
            
            pOutputMsg469.setSzCdDisasterRlf(pCCMN44DOutputRec.getSzCdDisasterRlf());
            pOutputMsg469.setCdPersonStatus(pCCMN44DOutputRec.getCdPersonStatus());
            pOutputMsg469.setDtDtPersonBirth(pCCMN44DOutputRec.getDtDtPersonBirth());
            
            // 
            // SIR 1972: Do not populate
            // pOutputMsg->ROWCINV56SOG02.dtDtLicngInvstIntake
            // with the date "DT_LICNG_INVST_INTAKE" on the
            // LICENSING_INVST_DTL table.
            // Instead created and added DAM CLSC69D to retrieve the
            // "DT_INCOMING_CALL" from the INCOMING_DETAIL table for
            // the Intake stage of the given ID_CASE.
            // 
            pOutputMsg469.setDtDtPersonDeath(pCCMN44DOutputRec.getDtDtPersonDeath());
            pOutputMsg469.setLNbrPersonAge(pCCMN44DOutputRec.getLNbrPersonAge());
            pOutputMsg469.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
            
            // SIR 22756 - add new functions for retrieving data from incoming_facility
            
            pOutputMsg469.setSzTxtOccupation(pCCMN44DOutputRec.getSzTxtOccupation());
            pOutputMsg469.setTsSysTsLastUpdate2(pCCMN44DOutputRec.getTsLastUpdate());
            pOutputMsg469.setBCdPersonChar(pCCMN44DOutputRec.getBCdPersonChar());
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCLSS79D(CINV04SI pInputMsg512, CINV04SO pOutputMsg470, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i284 = 0;
        
        CLSS79DI pCLSS79DInputRec = null;
        CLSS79DO pCLSS79DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS79DInputRec = new CLSS79DI();
        
        pCLSS79DOutputRec = new CLSS79DO();
        pCLSS79DInputRec.setArchInputStruct(pInputMsg512.getArchInputStruct());
        pCLSS79DInputRec.setUlIdPerson(pInputMsg512.getUlIdPerson());
        rc = clss79dQUERYdam(sqlca, pCLSS79DInputRec, pCLSS79DOutputRec);
        
        if (rc != 0) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg470.getArchOutputStruct().setUlRowQty(0);
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            
            for (i284 = 0;i284 < pCLSS79DOutputRec.getArchOutputStruct().getUlRowQty();++i284) {
                pOutputMsg470.getCINV04SOG03_ARRAY().getCINV04SOG03(i284).setSzCdPersonRace(pCLSS79DOutputRec.getROWCLSS79DO_ARRAY().getROWCLSS79DO(i284).getSzCdPersonRace());
            }
            pOutputMsg470.getArchOutputStruct().setUlRowQty(pCLSS79DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg470.getArchOutputStruct().setBMoreDataInd(pCLSS79DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCLSS80D(CINV04SI pInputMsg513, CINV04SO pOutputMsg471, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i285 = 0;
        
        CLSS80DI pCLSS80DInputRec = null;
        CLSS80DO pCLSS80DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS80DInputRec = new CLSS80DI();
        
        pCLSS80DOutputRec = new CLSS80DO();
        pCLSS80DInputRec.setArchInputStruct(pInputMsg513.getArchInputStruct());
        pCLSS80DInputRec.setUlIdPerson(pInputMsg513.getUlIdPerson());
        rc = clss80dQUERYdam(sqlca, pCLSS80DInputRec, pCLSS80DOutputRec);
        
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg471.getArchOutputStruct().setUlRowQty(0);
                    
                    
                    //  Call CRES04D
                    rc = 0;
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
            }
        }
        
        else {
            
            //  Populate Output Message
            
            for (i285 = 0;i285 < pCLSS80DOutputRec.getArchOutputStruct().getUlRowQty();++i285) {
                pOutputMsg471.getCINV04SOG04_ARRAY().getCINV04SOG04(i285).setSzCdPersonEthnicity(pCLSS80DOutputRec.getROWCLSS80DO_ARRAY().getROWCLSS80DO(i285).getSzCdPersonEthnicity());
            }
            pOutputMsg471.getArchOutputStruct().setUlRowQty(pCLSS80DOutputRec.getArchOutputStruct().getUlRowQty());
            
            pOutputMsg471.getArchOutputStruct().setBMoreDataInd(pCLSS80DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCINV29D(CINV04SI pInputMsg514, CINV04SO pOutputMsg472, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i286 = 0;
        
        /*
        ** Declare local variables
        */
        CINV29DI pCINV29DInputRec = null;
        CINV29DO pCINV29DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV29DInputRec = new CINV29DI();
        
        pCINV29DOutputRec = new CINV29DO();
        pCINV29DInputRec.setUlIdPerson(pInputMsg514.getUlIdPerson());
        pInputMsg514.getArchInputStruct().setUsPageNbr(1);
        
        pInputMsg514.getArchInputStruct().setUlPageSizeNbr(CINV04SO._CINV04SO__CINV04SOGOO_SIZE);
        
        pCINV29DInputRec.setArchInputStruct(pInputMsg514.getArchInputStruct());
        rc = cinv29dQUERYdam(sqlca, pCINV29DInputRec, pCINV29DOutputRec);
        if (rc != 0) {
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pOutputMsg472.getArchOutputStruct().setUlRowQty(0);
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            
            //  Populate Output Message
            for (i286 = 0;i286 < pCINV29DOutputRec.getArchOutputStruct().getUlRowQty();++i286) {
                pOutputMsg472.getCINV04SOGOO_ARRAY().getCINV04SOGOO(i286).setSzCdCategoryCategory(pCINV29DOutputRec.getROWCINV29DO_ARRAY().getROWCINV29DO(i286).getSzCdCategoryCategory());
            }
            
            pOutputMsg472.getArchOutputStruct().setUlRowQty(pCINV29DOutputRec.getArchOutputStruct().getUlRowQty());
            
            pOutputMsg472.getArchOutputStruct().setBMoreDataInd(pCINV29DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCINV33D(CINV04SI pInputMsg515, CINV04SO pOutputMsg473, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i287 = 0;
        
        /*
        ** Declare local variables
        */
        CINV33DI pCINV33DInputRec = null;
        CINV33DO pCINV33DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV33DInputRec = new CINV33DI();
        
        pCINV33DOutputRec = new CINV33DO();
        pCINV33DInputRec.setUlIdPerson(pInputMsg515.getUlIdPerson());
        pCINV33DInputRec.setSzCdStageProgram(pInputMsg515.getSzCdStageProgram());
        pInputMsg515.getArchInputStruct().setUsPageNbr(1);
        pInputMsg515.getArchInputStruct().setUlPageSizeNbr(CINV04SO._CINV04SO__CINV04SG01_SIZE);
        pCINV33DInputRec.setArchInputStruct(pInputMsg515.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        
        rc = cinv33dQUERYdam(sqlca, pCINV33DInputRec, pCINV33DOutputRec);
        
        /**************************************************************************
        ** End Call to Stage Person Link Dam - CCMN44D
        **************************************************************************/
        
        
        
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg473.getArchOutputStruct().setUlRowQty(0);
                    rc = 0;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            for (i287 = 0;i287 < pCINV33DOutputRec.getArchOutputStruct().getUlRowQty();++i287) {
                pOutputMsg473.getCINV04SG01_ARRAY().getCINV04SG01(i287).setUlIdCase(pCINV33DOutputRec.getROWCINV33DO_ARRAY().getROWCINV33DO(i287).getUlIdCase());
                pOutputMsg473.getCINV04SG01_ARRAY().getCINV04SG01(i287).setUlIdStage(pCINV33DOutputRec.getROWCINV33DO_ARRAY().getROWCINV33DO(i287).getUlIdStage());
                pOutputMsg473.getCINV04SG01_ARRAY().getCINV04SG01(i287).setSzCdStageProgram(pCINV33DOutputRec.getROWCINV33DO_ARRAY().getROWCINV33DO(i287).getSzCdStageProgram());
            };
            pOutputMsg473.getArchOutputStruct().setUlRowQty(pCINV33DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg473.getArchOutputStruct().setBMoreDataInd(pCINV33DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCCMN40D(CINV04SI pInputMsg516, CINV04SO pOutputMsg474, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        
        CCMN40DI pCCMN40DInputRec = null;
        CCMN40DO pCCMN40DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN40DInputRec = new CCMN40DI();
        
        pCCMN40DOutputRec = new CCMN40DO();
        pCCMN40DInputRec.setArchInputStruct(pInputMsg516.getArchInputStruct());
        pCCMN40DInputRec.setUlIdPerson(pInputMsg516.getUlIdPerson());
        /* SIR 21286 */
        rc = ccmn40dQUERYdam(sqlca, pCCMN40DInputRec, pCCMN40DOutputRec);
        
        if (rc != 0) {
            switch (rc) {
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                case NO_DATA_FOUND:
                    rc = 0;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg474.setSzNmNameFirst(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameFirst());
            pOutputMsg474.setSzNmNameLast(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameLast());
            pOutputMsg474.setSzNmNameMiddle(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameMiddle());
            pOutputMsg474.setSzCdNameSuffix(pCCMN40DOutputRec.getROWCCMN40DO().getSzCdNameSuffix());
        }
        return rc;
    }

    static int CallCSES46D(CINV04SI pInputMsg517, CINV04SO pOutputMsg475, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        
        CSES46DI pCSES46DInputRec = null;
        CSES46DO pCSES46DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES46DInputRec = new CSES46DI();
        
        pCSES46DOutputRec = new CSES46DO();
        pCSES46DInputRec.setArchInputStruct(pInputMsg517.getArchInputStruct());
        pCSES46DInputRec.setUlIdPersHmRemoval(pInputMsg517.getUlIdPerson());
        pCSES46DInputRec.setUlIdCase(pInputMsg517.getUlIdCase());
        rc = cses46dQUERYdam(sqlca, pCSES46DInputRec, pCSES46DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case NO_DATA_FOUND:
                {
                    pOutputMsg475.setCSysIndHomeRemovePers(false);
                    break;
                }
            case WtcHelperConstants.SQL_SUCCESS:
                {
                    pOutputMsg475.setCSysIndHomeRemovePers(true);
                    break;
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCSES47D(CINV04SI pInputMsg518, CINV04SO pOutputMsg476, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        
        CSES47DI pCSES47DInputRec = null;
        CSES47DO pCSES47DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES47DInputRec = new CSES47DI();
        
        pCSES47DOutputRec = new CSES47DO();
        pCSES47DInputRec.setArchInputStruct(pInputMsg518.getArchInputStruct());
        pCSES47DInputRec.setUlIdPerson(pInputMsg518.getUlIdPerson());
        rc = cses47dQUERYdam(sqlca, pCSES47DInputRec, pCSES47DOutputRec);
        switch (rc) {
            case NO_DATA_FOUND:
                {
                    pOutputMsg476.setCSysIndPersReferPresent(false);
                    
                    break;
                }
            case WtcHelperConstants.SQL_SUCCESS:
                {
                    pOutputMsg476.setCSysIndPersReferPresent(true);
                    
                    break;
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCINV79D(CINV04SI pInputMsg519, CINV04SO pOutputMsg477, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        
        CINV79DI pCINV79DInputRec = null;
        CINV79DO pCINV79DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV79DInputRec = new CINV79DI();
        
        pCINV79DOutputRec = new CINV79DO();
        pCINV79DInputRec.setArchInputStruct(pInputMsg519.getArchInputStruct());
        pCINV79DInputRec.setUlIdPerson(pInputMsg519.getUlIdPerson());
        rc = cinv79dQUERYdam(sqlca, pCINV79DInputRec, pCINV79DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg477.setBIndActiveEvent(false);
                    
                    //  Check buffer size
                    //  Process error message and return to client
                    
                    //  Initialize output message and length
                    
                    //  Initialize service status fields
                    
                    // 
                    // Call DAMs to retrieve data
                    // 
                    
                    //  Determine Unit Validity
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else if (pCINV79DOutputRec.getUsSysNbrNumberOfRows() > 0) {
            pOutputMsg477.setBIndActiveEvent(true);
        }
        else {
            pOutputMsg477.setBIndActiveEvent(false);
        }
        return rc;
    }

    static int CallCINV52D(CINV04SI pInputMsg520, CINV04SO pOutputMsg478, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i288 = 0;
        
        /*
        ** Declare local variables
        */
        CINV52DI pCINV52DInputRec = null;
        CINV52DO pCINV52DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV52DInputRec = new CINV52DI();
        
        pCINV52DOutputRec = new CINV52DO();
        pCINV52DInputRec.setUlIdPerson(pInputMsg520.getUlIdPerson());
        pInputMsg520.getArchInputStruct().setUsPageNbr(1);
        pInputMsg520.getArchInputStruct().setUlPageSizeNbr(CINV04SO._CINV04SO__CINV04SG02_SIZE);
        pCINV52DInputRec.setArchInputStruct(pInputMsg520.getArchInputStruct());
        rc = cinv52dQUERYdam(sqlca, pCINV52DInputRec, pCINV52DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    //  Call DAM
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            for (i288 = 0;i288 < pCINV52DOutputRec.getArchOutputStruct().getUlRowQty();++i288) {
                pOutputMsg478.getCINV04SG02_ARRAY().getCINV04SG02(i288).setSzCdEventType(pCINV52DOutputRec.getROWCINV52DO_ARRAY().getROWCINV52DO(i288).getSzCdEventType());
                pOutputMsg478.getCINV04SG02_ARRAY().getCINV04SG02(i288).setSzCdEventStatus(pCINV52DOutputRec.getROWCINV52DO_ARRAY().getROWCINV52DO(i288).getSzCdEventStatus());
                
                pOutputMsg478.getCINV04SG02_ARRAY().getCINV04SG02(i288).setUlIdStage(pCINV52DOutputRec.getROWCINV52DO_ARRAY().getROWCINV52DO(i288).getUlIdStage());
            }
            pOutputMsg478.setUlRowQty(pCINV52DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg478.getArchOutputStruct().setBMoreDataInd(pCINV52DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCINVB5D(CINV04SI pInputMsg521, CINV04SO pOutputMsg479, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        
        CINVB5DI pCINVB5DInputRec = null;
        CINVB5DO pCINVB5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB5DInputRec = new CINVB5DI();
        
        pCINVB5DOutputRec = new CINVB5DO();
        pCINVB5DInputRec.setArchInputStruct(pInputMsg521.getArchInputStruct());
        pCINVB5DInputRec.setUlIdPerson(pInputMsg521.getUlIdPerson());
        pCINVB5DInputRec.setUlIdStage(pInputMsg521.getUlIdStage());
        rc = cinvb5dQUERYdam(sqlca, pCINVB5DInputRec, pCINVB5DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case 0:
            case NO_DATA_FOUND:
                pOutputMsg479.setCScrIndDupAlleg(pCINVB5DOutputRec.getCScrIndDupAlleg());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCDYN25D(CINV04SI pInputMsg522, CINV04SO pOutputMsg480, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CDYN25DI pCDYN25DInputRec = null;
        CDYN25DO pCDYN25DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures for DAM 08
        */
        pCDYN25DInputRec = new CDYN25DI();
        
        pCDYN25DOutputRec = new CDYN25DO();
        pCDYN25DInputRec.setArchInputStruct(pInputMsg522.getArchInputStruct());
        pCDYN25DInputRec.setUlIdEvent(pInputMsg522.getUlIdPerson());
        pCDYN25DInputRec.setSzSysTxtTablename(INITIAL_DEATH_TABLE);
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
        */
        
        /*
        ** Check buffer size 
        */
        
        /*
        ** Process error message and return to client 
        */
        
        /*
        ** Initialize output message and length 
        */
        
        /*
        ** Initialize service status fields 
        */
        
        /*********************************************************************
        *  Call DAMs to AUD data
        **********************************************************************/
        rc = cdyn25dQUERYdam(sqlca, pCDYN25DInputRec, pCDYN25DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (pCDYN25DOutputRec.getUlSysNbrUlongKey() > 0) {
                    pOutputMsg480.getBIndBLOBExistsInDatabase()[INITIAL_DOC_INDEX] = true;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else {
                    pOutputMsg480.getBIndBLOBExistsInDatabase()[INITIAL_DOC_INDEX] = false;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        pCDYN25DInputRec.setArchInputStruct(pInputMsg522.getArchInputStruct());
        pCDYN25DInputRec.setUlIdEvent(pInputMsg522.getUlIdPerson());
        pCDYN25DInputRec.setSzSysTxtTablename(COMMITTEE_DEATH_TABLE);
        rc = cdyn25dQUERYdam(sqlca, pCDYN25DInputRec, pCDYN25DOutputRec);
        
        /*
        ** Analyze error code
        */
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                if (pCDYN25DOutputRec.getUlSysNbrUlongKey() > 0) {
                    pOutputMsg480.getBIndBLOBExistsInDatabase()[COMMITTEE_DOC_INDEX] = true;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else {
                    pOutputMsg480.getBIndBLOBExistsInDatabase()[COMMITTEE_DOC_INDEX] = false;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                break;
                
            default :
                //   PROCESS_TUX_SQL_ERROR_NOFREE is called only when there is an unexpected
                // SQL error returned from the DAM.
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
}
