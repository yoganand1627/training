package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES71DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS12DO;
/**************************************************************************
** 
** Module File:   CSYS04S.src
**
** Service Name:  Contact List
**
** Description:   Uses a variable number of parameters to search for a
**                contact information.  
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/15/94
** 
** Programmer:    Wendy Purtle
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                        added the lines.
**  10/21/96   odonnerj SIR# 21833 - If the Case Search Check Box is checked
**                      then the id_case will be greater than 0.  Otherwise 
**                      it is 0.  The service/dam switches on id_case to 
**                      decide which type of search to do (stage or case).
**  12/10/96   ODONNERJ SIR# 21833 - Add CD_STAGE to the ListBox on contact
**			search. This required addition of CSES71D and cd_stage
**			to the output message and map.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csys04s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int MAX_NAMES = 5;
    CSYS04SO CSYS04S(CSYS04SI csys04si) {
        CSYS04SO csys04so = new CSYS04SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(csys04si.getArchInputStruct());
        rc = Cinv59s.CallCSYS04D(csys04si, csys04so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(csys04si.getArchInputStruct() , csys04so.getArchOutputStruct());
        
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
        return csys04so;
    }

    static int CallCSYS04D(CSYS04SI pInputMsg875, CSYS04SO pOutputMsg816, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int DamCtr = 0;/* Loop counter */
        int ulIdEvent37 = 0;
        int pRowCtr = 0;
        CSYS04DI pCSYS04DInputRec = null;
        CSYS04DO pCSYS04DOutputRec = null;
        CSES71DI pCSES71DInputRec = null;
        CSES71DO pCSES71DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS04DInputRec = new CSYS04DI();
        pCSYS04DOutputRec = new CSYS04DO();
        pCSYS04DInputRec.setSzCdContactLocation(pInputMsg875.getSzCdContactLocation());
        pCSYS04DInputRec.setSzCdContactMethod(pInputMsg875.getSzCdContactMethod());
        pCSYS04DInputRec.setSzCdContactOthers(pInputMsg875.getSzCdContactOthers());
        pCSYS04DInputRec.setSzCdContactPurpose(pInputMsg875.getSzCdContactPurpose());
        pCSYS04DInputRec.setSzCdContactType(pInputMsg875.getSzCdContactType());
        pCSYS04DInputRec.setUlIdStage(pInputMsg875.getUlIdStage());
        pCSYS04DInputRec.setUlIdEvent(pInputMsg875.getUlIdEvent());
        pCSYS04DInputRec.setUlIdCase(pInputMsg875.getUlIdCase());
        pCSYS04DInputRec.setDtScrSearchDateFrom(pInputMsg875.getDtScrSearchDateFrom());
        pCSYS04DInputRec.setDtScrSearchDateTo(pInputMsg875.getDtScrSearchDateTo());
        pCSYS04DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg875.getArchInputStruct().getUsPageNbr());
        pCSYS04DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg875.getArchInputStruct().getUlPageSizeNbr());
        rc = csys04dQUERYdam(sqlca, pCSYS04DInputRec, pCSYS04DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Populate Output Message
                for (pRowCtr = 0;((pRowCtr < pCSYS04DOutputRec.getArchOutputStruct().getUlRowQty()) && (DamCtr < pCSYS04DOutputRec.getArchOutputStruct().getUlRowQty()));++pRowCtr) {
                    pOutputMsg816.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzCdContactType(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(DamCtr).getSzCdContactType());
                    pOutputMsg816.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzCdContactPurpose(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(DamCtr).getSzCdContactPurpose());
                    pOutputMsg816.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzCdContactMethod(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(DamCtr).getSzCdContactMethod());
                    pOutputMsg816.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setDtDTContactOccurred(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(DamCtr).getDtDTContactOccurred());
                    pOutputMsg816.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setBIndContactAttempted(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(DamCtr).getBIndContactAttempted());
                    pOutputMsg816.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setUlIdEvent(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(DamCtr).getUlIdEvent());
                    ulIdEvent37 = pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(DamCtr).getUlIdEvent();
                    rc = CallCSYS12D(pInputMsg875, pOutputMsg816, ulIdEvent37, pRowCtr, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_NO_ROWS_RETURNED:
                            
                            
                            //  If the todo indicator for the cSysIndAgreeRtn is false
                            // process todo.
                            if (pInputMsg875.getUlRowQty() > 0) {
                                pRowCtr--;
                            }
                            // 
                            // (END): Delete DAM: caud07d      Stored Procedure: Complex Delete
                            // 
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    
                    // 
                    // SIR# 21833 - Retrieve CD_STAGE to populate in the List Box.
                    // 
                    //  Allocate memory for Input and Output Structures
                    pCSES71DInputRec = new CSES71DI();
                    pCSES71DOutputRec = new CSES71DO();
                    pCSES71DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg875.getArchInputStruct().getUlPageSizeNbr());
                    pCSES71DInputRec.setUlIdStage(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(DamCtr).getUlIdContactStage());
                    
                    //  Call CCMN45D
                    rc = cses71dQUERYdam(sqlca, pCSES71DInputRec, pCSES71DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pOutputMsg816.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzCdStage(pCSES71DOutputRec.getSzCdStage());
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                            rc = Messages.MSG_NO_ROWS_RETURNED;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    }
                    DamCtr++;
                }
                pOutputMsg816.getArchOutputStruct().setUlRowQty(pRowCtr);
                
                pOutputMsg816.getArchOutputStruct().setBMoreDataInd(pCSYS04DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //  If CFAD40SI CFAD40SIGOO dtDtAdptSubAgreeRetn is not NULL_DATE and
                // CFAD40SI CFAD40SIGOO szCdAdptSubDeterm is not Null,
                // set ToDoFlag[FAD041] to true.
                
                //  SIR#3628 - Removed the following line so that TODOs will be
                // created base only on whether or not the Agreement Returned Date
                // is present.
                // && (NULL_CHARACTER != pInputMsg->CFAD40SIG00.szCdAdptSubDeterm[0])
                
                if (0 < pOutputMsg816.getArchOutputStruct().getUlRowQty()) {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    
                    
                    //  Call CSES02D
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                }
                break;
                // Handle specific functional errors
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSYS12D(CSYS04SI pInputMsg876, CSYS04SO pOutputMsg817, int ulIdEvent38, int pRowCtr, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int k = 0;/* Loop counter */
        int i453 = 0;
        int NoMatchCtr = 0;/* counter for persons that do not match search criteria */
        int PersonCtr = 0;/* Person Ctr from event-person DAM */
        int MatchCtr = 0;/* Counter for persons that match search criteria */
        int pCtr = 0;/* Loop counter */
        boolean match = false;/* flag to mark the matches */
        ROWCSYS12DO[] tempPersonRow = new ROWCSYS12DO[5];
        
        /* Only use the first 5 names */
        for (int tempPersonRow1 = 0;tempPersonRow1 < tempPersonRow.length;tempPersonRow1++) {
            tempPersonRow[tempPersonRow1] = new ROWCSYS12DO();
        }
        CSYS12DI pCSYS12DInputRec = null;
        CSYS12DO pCSYS12DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS12DInputRec = new CSYS12DI();
        pCSYS12DOutputRec = new CSYS12DO();
        tempPersonRow = new ROWCSYS12DO[]();
        for (int tempPersonRow1 = 0;tempPersonRow1 < tempPersonRow.length;tempPersonRow1++) {
            tempPersonRow[tempPersonRow1] = new ROWCSYS12DO();
        }
        pCSYS12DInputRec.setUlIdEvent(ulIdEvent38);
        pCSYS12DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg876.getArchInputStruct().getUsPageNbr());
        pCSYS12DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg876.getArchInputStruct().getUlPageSizeNbr());
        rc = csys12dQUERYdam(sqlca, pCSYS12DInputRec, pCSYS12DOutputRec);
        switch (rc) /* caud17d */
        {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                // We now have 0-20 names based on the ulIdEvent
                PersonCtr = pCSYS12DOutputRec.getArchOutputStruct().getUlRowQty() - 1;
                i453 = pCSYS12DOutputRec.getArchOutputStruct().getUlRowQty();
                NoMatchCtr = 0;
                MatchCtr = 0;
                match = true;
                for (pCtr = 0;pCtr < MAX_NAMES;pCtr++) {
                }
                
                if (pInputMsg876.getUlRowQty() > 0) {
                    for (k = 0;k < pInputMsg876.getUlRowQty();k++) {
                        
                        if (match) {
                            //  if NO id persons from DAM match the 
                            // person/persons from the search criteria,
                            // do not use the record and exit function
                            NoMatchCtr = 0;
                            while ((pInputMsg876.getROWCSYS04SI_ARRAY().getROWCSYS04SI(k).getUlIdPerson() != pCSYS12DOutputRec.getROWCSYS12DO_ARRAY().getROWCSYS12DO(NoMatchCtr).getUlIdPerson()) && NoMatchCtr <= i453) {
                                
                                NoMatchCtr++;
                            }
                            if (NoMatchCtr < i453) {
                                tempPersonRow[MatchCtr] = pCSYS12DOutputRec.getROWCSYS12DO_ARRAY().getROWCSYS12DO(NoMatchCtr);
                                
                                //  Increment the service row counter
                                MatchCtr++;
                                pCSYS12DOutputRec.getROWCSYS12DO_ARRAY().setROWCSYS12DO(NoMatchCtr, pCSYS12DOutputRec.getROWCSYS12DO_ARRAY().getROWCSYS12DO(PersonCtr));
                                PersonCtr--;
                            }
                            
                            
                            // else if no matches found return no rows
                            else {
                                match = false;
                            }
                        }
                    }
                }
                
                if (match) {
                    while (MatchCtr < MAX_NAMES && PersonCtr >= 0) {
                        
                        tempPersonRow[MatchCtr] = pCSYS12DOutputRec.getROWCSYS12DO_ARRAY().getROWCSYS12DO(PersonCtr);
                        MatchCtr++;
                        PersonCtr--;
                    }
                    pOutputMsg817.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzScrNmContact1(tempPersonRow[0].getSzNmPersonFull());
                    pOutputMsg817.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzScrNmContact2(tempPersonRow[1].getSzNmPersonFull());
                    pOutputMsg817.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzScrNmContact3(tempPersonRow[2].getSzNmPersonFull());
                    pOutputMsg817.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzScrNmContact4(tempPersonRow[3].getSzNmPersonFull());
                    pOutputMsg817.getROWCSYS04SO_ARRAY().getROWCSYS04SO(pRowCtr).setSzScrNmContact5(tempPersonRow[4].getSzNmPersonFull());
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                
                // do not use the record if no matches
                else {
                    
                    
                    //  Call CSEC28D
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                }
                break;
                
                // 
                // (END): CSEC72D - Full row retrieval to verify contract is not PENDING.
                // 
                
                
                
            case NO_DATA_FOUND:
                
                
                //  Set rc to SSM_FIN_NO_UNIT_RATE
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
