package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC63DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC63DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD88DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD88DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**  
** Module File:   ccfc30s.src
**
** Service Name:  CCFC30S
**
** Description:   This service will Add, Update and Delete records to the 
**                INCOME AND RESOURCES table. (CAUD88D)
**                After this AUD, the service will use CLSC63D to check
**                the table to see if there exists a record that has the 
**                same CD INC RSRC TYPE as the current record in the Output
**                record of CCFC30s, and has overlapping effective dates and
**                whose ID INC RSRC does equal the one passed into the DAM.
**                If successful, this DAM will return a same type message 
**                and prevent the committing of data to the databse 
**                changed by CAUD88d.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11 December 1995
**
** Programmer:    Richard Denton
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:39:42  $
**                      $Modtime:   29 Mar 1996 23:58:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/08/96  dentonra  Added CD_INC_RSRC_INCOME to input record of clsc63d
**                      to prevent
**                      DAM from returning a row because OTHER(code:'XXX')
**                      exists for both Income and Resource.  Thus a check
**                      must be made to see from which table the other is
**                      coming.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc30s {
    public static final int INITIAL_PAGE = 1;
    CCFC30SO CCFC30S(CCFC30SI ccfc30si) {
        CCFC30SO ccfc30so = new CCFC30SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        
        CLSC63DI pCLSC63DInputRec = null;
        CLSC63DO pCLSC63DOutputRec = null;
        CAUD88DI pCAUD88DInputRec = null;
        CAUD88DO pCAUD88DOutputRec = null;
        
        int usRow = 0;
        int usInputRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccfc30si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Call to CAUD88d, which adds, updates or deletes rows from database
        ** based on listbox changes.  Will only be committed to database if
        ** call to CLSC63d (below) returns row not found.
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD88DInputRec = new CAUD88DI();
        
        pCAUD88DOutputRec = new CAUD88DO();
        rc = WtcHelperConstants.SQL_SUCCESS;
        
        /*
        ** While more rows are left to process and rc is zero,
        ** continue loop.
        */
        while ((usInputRow < ccfc30si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
            pCAUD88DInputRec.setArchInputStruct(ccfc30si.getArchInputStruct());
            
            pCAUD88DInputRec.getArchInputStruct().setCReqFuncCd(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getSzCdScrDataAction());
            pCAUD88DInputRec.setLAmtIncRsrc(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getLAmtIncRsrc());
            pCAUD88DInputRec.setSzCdIncRsrcIncome(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getSzCdIncRsrcIncome());
            pCAUD88DInputRec.setSzCdIncRsrcType(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getSzCdIncRsrcType());
            pCAUD88DInputRec.setDtDtIncRsrcFrom(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getDtDtIncRsrcFrom());
            pCAUD88DInputRec.setDtDtIncRsrcTo(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getDtDtIncRsrcTo());
            
            pCAUD88DInputRec.setUlIdPerson(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getUlIdPerson());
            pCAUD88DInputRec.setUlIdIncRsrcWorker(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getUlIdIncRsrcWorker());
            
            pCAUD88DInputRec.setUlIdIncRsrc(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getUlIdIncRsrc());
            pCAUD88DInputRec.setCIndIncRsrcNotAccess(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getCIndIncRsrcNotAccess());
            pCAUD88DInputRec.setSzSdsIncRrcsSource(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getSzSdsIncRrcsSource());
            pCAUD88DInputRec.setSzSdsIncRsrcVerfMethod(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getSzSdsIncRsrcVerfMethod());
            
            pCAUD88DInputRec.setTsLastUpdate(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getTsLastUpdate());
            pCAUD88DInputRec.setSzTxtIncRsrcDesc(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).getSzTxtIncRsrcDesc());
            rc = caud88dAUDdam(sqlca, pCAUD88DInputRec, pCAUD88DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usInputRow).setUlIdIncRsrc(pCAUD88DOutputRec.getUlIdIncRsrc());
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    // 
                    // END ADMIN REVIEW RTRV WITH CSES63D Return ro RC ANALYSIS
                    // FOR CCMN03U
                    // 
                    break;
            }
            usInputRow++;
        }
        
        /*
        ** SVC AUTH ENH -- If service auth is in a closed stage, pass
        **                 in the ID of the historical primary worker.
        */
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            //  Call to CLSC63D which checks for records of 
            // the same type as the one currently selected.  If successful
            // service returns error and the above CAUD88d will NOT be 
            // committed to the database.  If no row found, service returns
            // SUCCESS and above CAUD88d WILL BE committed to the database.
            
            //  Allocate memory for DAM Input and Output Structures
            pCLSC63DInputRec = new CLSC63DI();
            
            pCLSC63DOutputRec = new CLSC63DO();
            
            while (usRow < ccfc30si.getArchInputStruct().getUlPageSizeNbr() && rc == WtcHelperConstants.ARC_SUCCESS) {
                if (WtcHelperConstants.REQ_FUNC_CD_DELETE != ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usRow).getSzCdScrDataAction()) {
                    pCLSC63DInputRec.setArchInputStruct(ccfc30si.getArchInputStruct());
                    pCLSC63DInputRec.setSzCdIncRsrcType(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usRow).getSzCdIncRsrcType());
                    pCLSC63DInputRec.setDtDtIncRsrcFrom(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usRow).getDtDtIncRsrcFrom());
                    pCLSC63DInputRec.setDtDtIncRsrcTo(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usRow).getDtDtIncRsrcTo());
                    pCLSC63DInputRec.setUlIdIncRsrc(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usRow).getUlIdIncRsrc());
                    pCLSC63DInputRec.setUlIdPerson(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usRow).getUlIdPerson());
                    pCLSC63DInputRec.setSzCdIncRsrcIncome(ccfc30si.getROWCCFC30SIG00_ARRAY().getROWCCFC30SIG00(usRow).getSzCdIncRsrcIncome());
                    pCLSC63DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                    pCLSC63DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC63DO._CLSC63DO__ROWCLSC63DO_SIZE);
                    rc = clsc63dQUERYdam(sqlca, pCLSC63DInputRec, pCLSC63DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CFC_SAME_TYPE_INC;
                            rc = Messages.MSG_CFC_SAME_TYPE_INC;
                            
                            break;
                            
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Call DAM if an Ethnicity is added or deleted
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            
                            break;
                    }
                    
                    
                    //  Check if the Overall Disposition in the
                    // LICENSING_INVST_DTL table is LRB (RTB)
                    // 
                }
                usRow++;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc30si.getArchInputStruct() , ccfc30so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else // SIR 22983 End
        {
            
            
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                //  Do nothing, the output message just returns success or
                // failure
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
            
        }
        return ccfc30so;
    }

}
