package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV27DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV27DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV28DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
/**************************************************************************
** 
** Module File:   CINV24S.src
**
** Service Name:  CINV24S
**
** Description:   This service routine houses two different DAM service
**                calls. One for Predisplay processing "Return Latest &
**                Greatest", and another for Search functionality which
**                will query the database by the entered effective date.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 20, 1995 
** 
** Programmer:    Terry T. Cavallaro
**
** DAMS called:   CINV27D
**                CINV28D
**                CCMN44D
**
**
** Change History:
**
**  Date     User               SIR  Description
**  -------  ------------------ ---  --------------------------------------
**  05/20/96  OMARAJJ   SIR#21251 - Replace COPYSZ with MEMCPY for timestamp
**                      variables.
**
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
****************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv24s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final char CHAR_CHECKED = '1';
    public static final int DT_CHAR_END_MONTH = 12;
    public static final int DT_CHAR_END_DAY = 31;
    public static final int DT_CHAR_END_YEAR = 4712;
    CINV24SO CINV24S(CINV24SI cinv24si) {
        CINV24SO cinv24so = new CINV24SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i338 = 0;
        rc = ARC_PRFServiceStartTime_TUX(cinv24si.getArchInputStruct());
        if (DateHelper.NULL_DATE == cinv24si.getDtScrDtCharEffDate().day) {
            
            //  Call DAM
            rc = Ccmn03u.CallCCMN44D(cinv24si, cinv24so, pServiceStatus);
            
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            // 
            // END  SIR 3447 -Common Function: ccmn06u   Check Stage/Event common function
            // 
            
            
            
            
            
            // 
            // (BEGIN): CINV51D -- RTRV PRIMARY EMPL DAM
            // 
            
            // Call CINV51D -- RTRV PRIMARY EMPL DAM if the SaveDetailWindow common 
            // function passes an IdEvent, (IdEvent != NULL).
            
            if (CHAR_CHECKED == cinv24so.getBCdPersonChar()) {
                rc = CallCINV27D(cinv24si, cinv24so, pServiceStatus);
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        else {
            rc = CallCINV28D(cinv24si, cinv24so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_NO_ROWS_RETURNED:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv24si.getArchInputStruct() , cinv24so.getArchOutputStruct());
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
        return cinv24so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = "CINV24SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCINV27D(CINV24SI pInputMsg675, CINV24SO pOutputMsg625, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i339 = 0;
        int rc = 0;
        CINV27DI pCINV27DInputRec = null;
        CINV27DO pCINV27DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV27DInputRec = new CINV27DI();
        
        pCINV27DOutputRec = new CINV27DO();
        pCINV27DInputRec.setUlIdPerson(pInputMsg675.getUlIdPerson());
        pCINV27DInputRec.getDtScrDtCharEffDate().day = pInputMsg675.getDtScrDtCharEffDate().day;
        pCINV27DInputRec.getDtScrDtCharEffDate().month = pInputMsg675.getDtScrDtCharEffDate().month;
        pCINV27DInputRec.getDtScrDtCharEffDate().year = pInputMsg675.getDtScrDtCharEffDate().year;
        pCINV27DInputRec.getDtDtCharEnd().day = DT_CHAR_END_DAY;
        pCINV27DInputRec.getDtDtCharEnd().month = DT_CHAR_END_MONTH;
        pCINV27DInputRec.getDtDtCharEnd().year = DT_CHAR_END_YEAR;
        pCINV27DInputRec.setArchInputStruct(pInputMsg675.getArchInputStruct());
        rc = cinv27dQUERYdam(sqlca, pCINV27DInputRec, pCINV27DOutputRec);
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = SUCCESS;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg625.setUlIdPerson(pCINV27DOutputRec.getUlIdPerson());
            pOutputMsg625.getArchOutputStruct().setUlRowQty(pCINV27DOutputRec.getArchOutputStruct().getUlRowQty());
            
            // Populate characteristics structure
            
            for (i339 = 0;i339 < pCINV27DOutputRec.getArchOutputStruct().getUlRowQty();i339++) {
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).setUlIdCharacteristics(pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getUlIdCharacteristics());
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).setSzCdCharCategory(pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getSzCdCharCategory());
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).setCdCharacteristic(pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getCdCharacteristic());
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).getDtDtCharStart().day = pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getDtDtCharStart().day;
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).getDtDtCharStart().month = pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getDtDtCharStart().month;
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).getDtDtCharStart().year = pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getDtDtCharStart().year;
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).getDtDtCharEnd().day = pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getDtDtCharEnd().day;
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).getDtDtCharEnd().month = pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getDtDtCharEnd().month;
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).getDtDtCharEnd().year = pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getDtDtCharEnd().year;
                pOutputMsg625.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i339).setTsLastUpdate(pCINV27DOutputRec.getROWCINV27DO_ARRAY().getROWCINV27DO(i339).getTsLastUpdate());
            }
        }
        return rc;
    }

    static int CallCINV28D(CINV24SI pInputMsg676, CINV24SO pOutputMsg626, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i340 = 0;
        int rc = 0;/* Return code */
        CINV28DI pCINV28DInputRec = null;
        CINV28DO pCINV28DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV28DInputRec = new CINV28DI();
        
        
        pCINV28DOutputRec = new CINV28DO();
        pCINV28DInputRec.setUlIdPerson(pInputMsg676.getUlIdPerson());
        pCINV28DInputRec.getDtScrDtCharEffDate().day = pInputMsg676.getDtScrDtCharEffDate().day;
        pCINV28DInputRec.getDtScrDtCharEffDate().month = pInputMsg676.getDtScrDtCharEffDate().month;
        
        pCINV28DInputRec.getDtScrDtCharEffDate().year = pInputMsg676.getDtScrDtCharEffDate().year;
        pCINV28DInputRec.setArchInputStruct(pInputMsg676.getArchInputStruct());
        
        
        /*
        ** Call architecture function to retreive the current date.
        */
        rc = cinv28dQUERYdam(sqlca, pCINV28DInputRec, pCINV28DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    
                    //  Set rc to ARC_SUCCESS
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                    
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg626.setUlIdPerson(pCINV28DOutputRec.getUlIdPerson());
            pOutputMsg626.getArchOutputStruct().setUlRowQty(pCINV28DOutputRec.getArchOutputStruct().getUlRowQty());
            
            
            
            
            // Populate characteristics structure
            
            for (i340 = 0;i340 < pCINV28DOutputRec.getArchOutputStruct().getUlRowQty();i340++) {
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).setUlIdCharacteristics(pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getUlIdCharacteristics());
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).setSzCdCharCategory(pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getSzCdCharCategory());
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).setCdCharacteristic(pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getCdCharacteristic());
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).getDtDtCharStart().day = pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getDtDtCharStart().day;
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).getDtDtCharStart().month = pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getDtDtCharStart().month;
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).getDtDtCharStart().year = pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getDtDtCharStart().year;
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).getDtDtCharEnd().day = pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getDtDtCharEnd().day;
                
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).getDtDtCharEnd().month = pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getDtDtCharEnd().month;
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).getDtDtCharEnd().year = pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getDtDtCharEnd().year;
                pOutputMsg626.getROWCINV24SOG_ARRAY().getROWCINV24SOG(i340).setTsLastUpdate(pCINV28DOutputRec.getROWCINV28DO_ARRAY().getROWCINV28DO(i340).getTsLastUpdate());
            }
        }
        return rc;
    }

    
    static int CallCCMN44D(CINV24SI pInputMsg677, CINV24SO pOutputMsg627, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
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
        pCCMN44DInputRec.setUlIdPerson(pInputMsg677.getUlIdPerson());
        pCCMN44DInputRec.setArchInputStruct(pInputMsg677.getArchInputStruct());
        
        /*
        ** Call CLSS70D
        */
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        
        else {
            pOutputMsg627.setBIndPersonDobApprox(pCCMN44DOutputRec.getBIndPersonDobApprox());
            pOutputMsg627.setSzCdPersonLivArr(pCCMN44DOutputRec.getSzCdPersonLivArr());
            pOutputMsg627.setSzCdPersonDeath(pCCMN44DOutputRec.getSzCdPersonDeath());
            pOutputMsg627.setSzCdPersonEthnicGroup(pCCMN44DOutputRec.getSzCdPersonEthnicGroup());
            pOutputMsg627.setSzCdPersonLanguage(pCCMN44DOutputRec.getSzCdPersonLanguage());
            pOutputMsg627.setSzCdPersonMaritalStatus(pCCMN44DOutputRec.getSzCdPersonMaritalStatus());
            
            // 
            // Function Prototypes
            // 
            
            //  SIR 21919: Risk Assessment Enhancement: Added the following DAM to 
            // the Retrieve Service to obtain a count of any AP's that
            // are Active PRS Foster/Adoptive Parents for the stage.
            pOutputMsg627.setSzCdPersonReligion(pCCMN44DOutputRec.getSzCdPersonReligion());
            pOutputMsg627.setCCdPersonSex(pCCMN44DOutputRec.getCCdPersonSex());
            pOutputMsg627.setCdPersonStatus(pCCMN44DOutputRec.getCdPersonStatus());
            
            pOutputMsg627.setDtDtPersonBirth(pCCMN44DOutputRec.getDtDtPersonBirth());
            pOutputMsg627.setDtDtPersonDeath(pCCMN44DOutputRec.getDtDtPersonDeath());
            pOutputMsg627.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
            
            pOutputMsg627.setSzTxtOccupation(pCCMN44DOutputRec.getSzTxtOccupation());
            pOutputMsg627.setTsLastUpdate(pCCMN44DOutputRec.getTsLastUpdate());
            pOutputMsg627.setBCdPersonChar(pCCMN44DOutputRec.getBCdPersonChar());
        }
        return rc;
    }

}
