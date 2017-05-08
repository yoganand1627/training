package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB48SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB48SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC10DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC10DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS08DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CSUB48S.src
**
** Service Name:   CSUB48S
**
** Description:   This service retrieves all persons associated with an 
**                event from STAGE_PERSON_LINK and a subset of all persons
**                at home during removal from PERSON_HOME_RMVL table. If 
**                the person is found in both tables, an attribute is set
**                to true, so that the person will be 'checked' when 
**                displayed to the window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2 October 1995 
** 
** Programmer:    Greg Dyar
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:18:58  $
**                      $Modtime:   28 Mar 1996 23:24:38  $
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






public class Csub48s {
    static final String PERSON_TYPE1 = "PRN";
    static final int LT_check = 1;
    static final int LT_nocheck = 0;
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PRINCIPALS_ONLY = "PRN";
    CSUB48SO CSUB48S(CSUB48SI csub48si) {
        CSUB48SO csub48so = new CSUB48SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        public public public int i433 = 0;
        int iRowCtr = 0;
        boolean bMatchFound = false;/* flag for loop */
        
        
        CLSC10DI pCLSC10DInputRec = null;
        CLSC10DO pCLSC10DOutputRec = null;
        CLSS08DI pCLSS08DInputRec = null;
        CLSS08DO pCLSS08DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub48si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC10DInputRec = new CLSC10DI();
        
        pCLSC10DOutputRec = new CLSC10DO();
        pCLSC10DInputRec.setArchInputStruct(csub48si.getArchInputStruct());
        pCLSC10DInputRec.setUlIdStage(csub48si.getUlIdStage());
        pCLSC10DInputRec.setSzCdStagePersType(PRINCIPALS_ONLY);
        pCLSC10DInputRec.getArchInputStruct().setUsPageNbr(csub48si.getArchInputStruct().getUsPageNbr());
        pCLSC10DInputRec.setSzCdStagePersType(PERSON_TYPE1);
        pCLSC10DInputRec.getArchInputStruct().setUlPageSizeNbr(csub48si.getArchInputStruct().getUlPageSizeNbr());
        rc = clsc10dQUERYdam(sqlca, pCLSC10DInputRec, pCLSC10DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CSUB48SO to fields in CLSC10DO
                for (i433 = 0;i433 < pCLSC10DOutputRec.getArchOutputStruct().getUlRowQty();i433++) {//  If event is Risk Assessment (has Task = 2290) and
                    // COMP or PEND return Id Event
                    csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).setTsLastUpdate(pCLSC10DOutputRec.getROWCLSC10DO_ARRAY().getROWCLSC10DO(i433).getTsLastUpdate());
                    csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).setUlIdPerson(pCLSC10DOutputRec.getROWCLSC10DO_ARRAY().getROWCLSC10DO(i433).getUlIdPerson());
                    csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).setSzNmPersonFull(pCLSC10DOutputRec.getROWCLSC10DO_ARRAY().getROWCLSC10DO(i433).getSzNmPersonFull());
                    csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).setSzCdPersonRelationship(pCLSC10DOutputRec.getROWCLSC10DO_ARRAY().getROWCLSC10DO(i433).getSzCdStagePersRelInt());
                    csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).setDtDtPersonBirth(pCLSC10DOutputRec.getROWCLSC10DO_ARRAY().getROWCLSC10DO(i433).getDtDtPersonBirth());
                    
                    csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).setCCdPersonSex(pCLSC10DOutputRec.getROWCLSC10DO_ARRAY().getROWCLSC10DO(i433).getCCdPersonSex());
                }
                
                //  Increment the service row counter
                csub48so.getArchOutputStruct().setBMoreDataInd(pCLSC10DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                csub48so.getArchOutputStruct().setUlRowQty(pCLSC10DOutputRec.getArchOutputStruct().getUlRowQty());
                
                
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSS08DInputRec = new CLSS08DI();
                
                pCLSS08DOutputRec = new CLSS08DO();
                
                pCLSS08DInputRec.setArchInputStruct(csub48si.getArchInputStruct());
                pCLSS08DInputRec.setUlIdEvent(csub48si.getUlIdEvent());
                pCLSS08DInputRec.getArchInputStruct().setUsPageNbr(csub48si.getArchInputStruct().getUsPageNbr());
                pCLSS08DInputRec.getArchInputStruct().setUlPageSizeNbr(csub48si.getArchInputStruct().getUlPageSizeNbr());
                
                
                //  Call CAUD15D.  This will AUD the version information just passed
                // from the contract version list window.
                rc = clss08dQUERYdam(sqlca, pCLSS08DInputRec, pCLSS08DOutputRec);
                
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        
                        
                        //  Process all rows in CLSS08DO
                        for (i433 = 0;i433 < pCLSC10DOutputRec.getArchOutputStruct().getUlRowQty();i433++) {
                            for (iRowCtr = 0;((!bMatchFound) && (iRowCtr < pCLSS08DOutputRec.getArchOutputStruct().getUlRowQty()));iRowCtr++) {
                                if (pCLSS08DOutputRec.getROWCLSS08DO_ARRAY().getROWCLSS08DO(iRowCtr).getUlIdPersHmRemoval() == csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).getUlIdPerson()) {
                                    csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).setCScrIndRefChildMatch(LT_check);
                                    csub48so.getROWCSUB48SOG00_ARRAY().getROWCSUB48SOG00(i433).setTsLastUpdate(pCLSS08DOutputRec.getROWCLSS08DO_ARRAY().getROWCLSS08DO(iRowCtr).getTsLastUpdate());
                                    
                                    // Change the flag 
                                    // 
                                    bMatchFound = true;
                                }
                            }
                            
                            
                            
                            bMatchFound = false;
                        }
                        pServiceStatus.explan_code = SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        // commented out for SIR 13172-SIR#3582: Verify FA_HOME_TYPE for PRS F/A Homes 
                        // pOutputMsg->cCdRsrcFaHomeType1 = pCRES04DOutputRec->cCdRsrcFaHomeType1;
                        // pOutputMsg->cCdRsrcFaHomeType2 = pCRES04DOutputRec->cCdRsrcFaHomeType2;
                        // pOutputMsg->cCdRsrcFaHomeType3 = pCRES04DOutputRec->cCdRsrcFaHomeType3;
                        // pOutputMsg->cCdRsrcFaHomeType4 = pCRES04DOutputRec->cCdRsrcFaHomeType4;
                        // pOutputMsg->cCdRsrcFaHomeType5 = pCRES04DOutputRec->cCdRsrcFaHomeType5;
                        // pOutputMsg->cCdRsrcFaHomeType6 = pCRES04DOutputRec->cCdRsrcFaHomeType6;
                        // pOutputMsg->cCdRsrcFaHomeType7 = pCRES04DOutputRec->cCdRsrcFaHomeType7;     
                        // 20371b - added 2 data elements from dam output to service output 
                        // message d.o ->s.o 
                        // COPYSZ(pOutputMsg->szCdRsrcCategory,pCRES04DOutputRec->szCdRsrcCategory);
                        // pOutputMsg->cIndRsrcEmergPlace = pCRES04DOutputRec->cIndRsrcEmergPlace;
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                
                
                break;
                
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = WtcHelperConstants.ARC_SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(csub48si.getArchInputStruct() , csub48so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  If the pointer has a value, free it.
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
        return csub48so;
    }

}
