package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
/**************************************************************************
** 
** Module File:   CINV29S.src
**
** Service Name:  CINV29S
**
** Description:   call Prof Assmt table, Narr table, Person table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2/28/95 
** 
** Programmer:    ALIAM
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   18 Oct 1996 15:13:20  $
**                      $Modtime:   18 Oct 1996 10:59:44  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  09/21/95  SOOLEYAG  SIR #1425 - Changed from 'DOC','MFS','PSY' and 'THP'
**                      to 'DR', 'MF', 'PY' and 'TP' in CINV47D DAM input
**                      message so as to retrieve desired info.
**  10/02/95    KRD     SIR 1476 - Corrected error handling after DAM call
**                      in CallCCMN87D such that SQL_NOT_FOUND is not a fatal
**                      error.  Made other superficial changes to match the
**                      Release 1.x service shell.   
**  10/12/95    KJM     SIR 1736 - made the StagePersonType array larger--
**                      increased to 10 (also in DAM input rec).  Also
**                      defined three new #defines to populate members
**                      4-6 of the array.  Made size 10, though, in case
**                      later on more codes need to be passed in to the
**                      DAM. 
**
** 10/18/95  bruckmk  SIR 1829: Need to pop up Pending Event Message for New
**                    Contacts and Med/Mental Assessments for a stage that 
**                    has been submitted for closure.  The closure event for 
**                    Service Delivery has a type of SVC_CD_EVENT_TYPE_CLOSE 
**                    as opposed to SVC_CD_EVENT_TYPE_CONCL for 
**                    Investigation.  For Med/Mental: Also added DAM CINT21D 
**                    for stage retrieval to get CD_STAGE.  Added temporary 
**                    szCdStage variable to store the retrieved stage 
**                    information throughout the service.
**  07/26/96   zabihin  sir 21891 : version control code was missing,I
**                       added the lines.
**  10/16/96   vanderm  SIR 22103 - removed code which populated the system
**                      date returning from cinv96d DAM.  The system date
**                      is not populated in this DAM.  It is instead populated
**                      at the end of the service.
**
**  04/30/03   Srini	SIR 17091: Added the error handling to take care of full 
**						table scans for ccmn87dQUERYdam.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv29s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String TXT_NARR_TABLENAME = "PROF_ASSMT_NARR";
    public static final String TXT_NARR_EXISTS = "NARRATIVE";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String CONCL_EVENT_TYPE = "CCL";
    
    /****************SIR 1829***********************************************/
    public static final String CLOSE_EVENT_TYPE = "STG";
    public static final String SERVICE_DELIVERY = "SVC";
    public static final String FAMILY_PLAN = "FPR";
    
    /* Macro's for cinv47d */
    public static final String DR = "DR";
    public static final String MF = "MF";
    public static final String PY = "PY";
    public static final String TP = "TP";
    
    /* SIR 1736: added more string constants */
    
    public static final String EM = "EM";
    public static final String MH = "MH";
    public static final String NR = "NR";
    CINV29SO CINV29S(CINV29SI cinv29si) {
        CINV29SO cinv29so = new CINV29SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        String szCdStage3 = new String();
        
        rc = ARC_PRFServiceStartTime_TUX(cinv29si.getArchInputStruct());
        
        
        /*
        ** Call CCMN01U
        */
        rc = Ccmn13s.CallCINT21D(cinv29si, cinv29so, pServiceStatus, szCdStage3);
        if (WINDOW_MODE_INQUIRE == cinv29si.getSzSysCdWinMode()) {
            if (cinv29si.getUlIdEvent() != 0) {
                
                rc = Ccmn01u.CallCCMN45D(cinv29si, cinv29so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            rc = CallCINV45D(cinv29si, cinv29so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            
            //  Call CAUD98D
            rc = Cinv27s.CallCSYS13D(cinv29si, cinv29so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        else if ((WINDOW_MODE_MODIFY == cinv29si.getSzSysCdWinMode()) && (cinv29si.getUlIdEvent() != 0)) {
            rc = Ccmn01u.CallCCMN45D(cinv29si, cinv29so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = CallCINV45D(cinv29si, cinv29so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = CallCCMN87D(cinv29si, cinv29so, szCdStage3, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            
            //  Call CLSS67D
            rc = CallCINV47D(cinv29si, cinv29so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = Cinv27s.CallCSYS13D(cinv29si, cinv29so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        else {
            rc = CallCINV47D(cinv29si, cinv29so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            
            //  Call CSES80D
            rc = CallCCMN87D(cinv29si, cinv29so, szCdStage3, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Run-time versioning
        */
        
        
        /* Check buffer size */
        /* Process error message and return to client */
        /* Initialize output message and length */
        
        /* Initialize service status fields */
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        
        /* Get the system date and put it in the output message */
        ARC_UTLGetDateAndTime(cinv29so.getDtWCDDtSystemDate() , 0);
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cinv29si.getArchInputStruct() , cinv29so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
            //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            
            
            //  Exit the service function
        }
        else {
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Call architecture function to retreive the current date.
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv29so;
    }

    static int CallCCMN45D(CINV29SI pInputMsg696, CINV29SO pOutputMsg646, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setUlIdEvent(pInputMsg696.getUlIdEvent());
        pCCMN45DInputRec.setArchInputStruct(pInputMsg696.getArchInputStruct());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg646.getROWCCMN45DO().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pOutputMsg646.getROWCCMN45DO().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                pOutputMsg646.getROWCCMN45DO().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                // Process utility function failure
                pOutputMsg646.getROWCCMN45DO().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                pOutputMsg646.getROWCCMN45DO().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg646.getROWCCMN45DO().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                pOutputMsg646.getROWCCMN45DO().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pOutputMsg646.getROWCCMN45DO().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pOutputMsg646.getROWCCMN45DO().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN87D(CINV29SI pInputMsg697, CINV29SO pOutputMsg647, String szCdStage4, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setUlIdStage(pInputMsg697.getUlIdStage());
        if (!(szCdStage4.compareTo(SERVICE_DELIVERY) != 0) ||!(szCdStage4.compareTo(FAMILY_PLAN) != 0)) {
            pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CLOSE_EVENT_TYPE);
        }
        else {
            pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CONCL_EVENT_TYPE);
        }
        pCCMN87DInputRec.setArchInputStruct(pInputMsg697.getArchInputStruct());
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
                    pOutputMsg647.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                }
                else {
                    pOutputMsg647.setUlIdEvent(0);
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pOutputMsg647.setUlIdEvent(0);
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINV45D(CINV29SI pInputMsg698, CINV29SO pOutputMsg648, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINV45DI pCINV45DInputRec = null;
        CINV45DO pCINV45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV45DInputRec = new CINV45DI();
        
        pCINV45DOutputRec = new CINV45DO();
        pCINV45DInputRec.setUlIdEvent(pInputMsg698.getUlIdEvent());
        pCINV45DInputRec.setArchInputStruct(pInputMsg698.getArchInputStruct());
        rc = cinv45dQUERYdam(sqlca, pCINV45DInputRec, pCINV45DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg648.setUlIdPersonPrincipal(pCINV45DOutputRec.getUlIdPersonPrincipal());
                pOutputMsg648.setUlIdPersonProfessional(pCINV45DOutputRec.getUlIdPersonProfessional());
                pOutputMsg648.setDtProfAssmtAppt(pCINV45DOutputRec.getDtProfAssmtAppt());
                pOutputMsg648.setSzNmProfAssmtName(pCINV45DOutputRec.getSzNmProfAssmtName());
                pOutputMsg648.setSzNmProfAssmtPrincipal(pCINV45DOutputRec.getSzNmProfAssmtPrincipal());
                pOutputMsg648.setSzTxtProfAssmtOther(pCINV45DOutputRec.getSzTxtProfAssmtOther());
                pOutputMsg648.setCdProfAssmtApptRsn(pCINV45DOutputRec.getCdProfAssmtApptRsn());
                pOutputMsg648.setTsLastUpdate(pCINV45DOutputRec.getTsLastUpdate());
                pOutputMsg648.setSzTxtProfAssmtFindings(pCINV45DOutputRec.getSzTxtProfAssmtFindings());
                pOutputMsg648.setSzAddrProfAssmtCity(pCINV45DOutputRec.getSzAddrProfAssmtCity());
                pOutputMsg648.setSzAddrProfAssmtStLn1(pCINV45DOutputRec.getSzAddrProfAssmtStLn1());
                pOutputMsg648.setSzAddrProfAssmtStLn2(pCINV45DOutputRec.getSzAddrProfAssmtStLn2());
                pOutputMsg648.setSzAddrProfAssmtZip(pCINV45DOutputRec.getSzAddrProfAssmtZip());
                pOutputMsg648.setSzCdProfAssmtCounty(pCINV45DOutputRec.getSzCdProfAssmtCounty());
                pOutputMsg648.setSzAddrProfAssmtState(pCINV45DOutputRec.getSzAddrProfAssmtState());
                pOutputMsg648.setLNbrProfAssmtPhone(pCINV45DOutputRec.getLNbrProfAssmtPhone());
                pOutputMsg648.setLNbrPhoneExtension(pCINV45DOutputRec.getLNbrPhoneExtension());
                pOutputMsg648.setSzTxtProfAssmtCmnts(pCINV45DOutputRec.getSzTxtProfAssmtCmnts());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                
                //  Call CRES13D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        
        
        
    }

    static int CallCINV47D(CINV29SI pInputMsg699, CINV29SO pOutputMsg649, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i346 = 0;
        
        /*
        ** Declare local variables
        */
        CINV47DI pCINV47DInputRec = null;
        CINV47DO pCINV47DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV47DInputRec = new CINV47DI();
        
        pCINV47DOutputRec = new CINV47DO();
        pCINV47DInputRec.setUlIdStage(pInputMsg699.getUlIdStage());
        pCINV47DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(0, DR);
        pCINV47DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(1, MF);
        pCINV47DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(2, PY);
        pCINV47DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(3, TP);
        
        pCINV47DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(4, EM);
        
        pCINV47DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(5, MH);
        
        pCINV47DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(6, NR);
        pCINV47DInputRec.setArchInputStruct(pInputMsg699.getArchInputStruct());
        
        /*
        ** Call CAUD55D
        */
        rc = cinv47dQUERYdam(sqlca, pCINV47DInputRec, pCINV47DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i346 = 0;i346 < pCINV47DOutputRec.getArchOutputStruct().getUlRowQty();++i346) {
                    pOutputMsg649.getROWCINV29SOG01_ARRAY().getROWCINV29SOG01(i346).setSzScrNmGenericFullName(pCINV47DOutputRec.getROWCINV47DO_ARRAY().getROWCINV47DO(i346).getSzNmPersonFull());
                    pOutputMsg649.getROWCINV29SOG01_ARRAY().getROWCINV29SOG01(i346).setUlIdPerson(pCINV47DOutputRec.getROWCINV47DO_ARRAY().getROWCINV47DO(i346).getUlIdPerson());
                }
                pOutputMsg649.getArchOutputStruct().setUlRowQty(pCINV47DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg649.getArchOutputStruct().setBMoreDataInd(pCINV47DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                
                // 
                // End Second call to CLSC18D
                // 
                
                
                break;
        }
        return rc;
    }

    static int CallCSYS13D(CINV29SI pInputMsg700, CINV29SO pOutputMsg650, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CSYS13DI pCSYS13DInputRec = null;
        CSYS13DO pCSYS13DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS13DInputRec = new CSYS13DI();
        
        pCSYS13DOutputRec = new CSYS13DO();
        pCSYS13DInputRec.setUlIdEvent(pInputMsg700.getUlIdEvent());
        pCSYS13DInputRec.setSzSysTxtTablename(TXT_NARR_TABLENAME);
        pCSYS13DInputRec.setArchInputStruct(pInputMsg700.getArchInputStruct());
        rc = csys13dQUERYdam(sqlca, pCSYS13DInputRec, pCSYS13DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                pOutputMsg650.setSzScrTxtNarrStatus(TXT_NARR_EXISTS);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg650.setSzScrTxtNarrStatus("");
                
                
                //  Call CSEC51D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                // 
                // END OF NESTED DAM CCMN45D for CINT21D  CASE SUCCESS
                // 
                
                
                break;
        }
        return rc;
    }

    static int CallCINT21D(CINV29SI pInputMsg701, CINV29SO * pOutputMsg651, Arcxmlerrors.TUX_DECL_STATUSPARMS, String szCdStage5) {
        int rc = 0;
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setUlIdStage(pInputMsg701.getUlIdStage());
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        
        if (0 == rc) {
            szCdStage5 = pCINT21DOutputRec.getSzCdStage();
        }
        else {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
