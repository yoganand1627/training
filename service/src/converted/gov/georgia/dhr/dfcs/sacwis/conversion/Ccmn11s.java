package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN17DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCMN11S.src
**
** Service Name:  CCMN11S
**
** Description:   Retrieve all the Todos for a certain person and a time
**                period.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/14/94 
** 
** Programmer:    Limin Zhang 
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/16/95  FOGARTIS  SIR#59 SIR#146 - Handling of rows not found added
**  03/01/95  FOGARTIS  SIR#59 - Handling of rows not found modified
**  06/09/95  RUSSELRM  Final clean up for unit test.
**  7/26/96    zabihin  sir 21891 : version control code was missing,I
**                       added the line.
** 01/13/03  Srini D    Modified to strcpy for copying cReqFuncCd to support 
**			unicode characters.
** 01/17/03  Srini D    Rolled back the previous change done on 01/13/03. 
**			Modified the ccmn17d.pc file to take char literals 
**			for the case statement.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn11s {
    CCMN11SO CCMN11S(CCMN11SI ccmn11si) {
        CCMN11SO ccmn11so = new CCMN11SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(ccmn11si.getArchInputStruct());
        rc = CallCCMN17D(ccmn11si, ccmn11so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /* 
        ** Put current date into Output
        */
        ARC_UTLGetDateAndTime(ccmn11so.getDtWCDDtSystemDate() , 0);
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn11si.getArchInputStruct() , ccmn11so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                //Do not commit as it will be committed in the called service.
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn11so;
    }

    static int CallCCMN17D(CCMN11SI pInputMsg228, CCMN11SO pOutputMsg209, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i132 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN17DI pCCMN17DInputRec = null;
        CCMN17DO pCCMN17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN17DInputRec = new CCMN17DI();
        
        
        pCCMN17DOutputRec = new CCMN17DO();
        
        if ((pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).day == DateHelper.NULL_DATE || pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).month == DateHelper.NULL_DATE || pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).year == DateHelper.NULL_DATE) && (pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(0).day == DateHelper.NULL_DATE || pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(0).month == DateHelper.NULL_DATE || pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(0).year == DateHelper.NULL_DATE)) {
            FndInt3date tempDate = null;
            Tm t;
            //  END SIR 1972 
            
            // 
            // Prepare output message to be returned and return
            // 
            
            // Get the system date and put it in the output message
            ARC_UTLGetDateAndTime(tempDate, 0);
            t.getDate() = tempDate.day;
            t.getMonth() = tempDate.month - 1;
            t.getYear() = tempDate.year - 1900;
            t.getDate() += 7;
            t.getTime();
            pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).day = t.getDate();
            pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).month = t.getMonth() + 1;
            pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).year = t.getYear() + 1900;
        }
        pCCMN17DInputRec.setUlIdTodoPersAssigned(pInputMsg228.getUlIdTodoPersAssigned());
        pCCMN17DInputRec.getDtDtTodoDue_ARRAY().setDtDtTodoDue(0, pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(0));
        pCCMN17DInputRec.getDtDtTodoDue_ARRAY().setDtDtTodoDue(1, pInputMsg228.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1));
        pCCMN17DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg228.getArchInputStruct().getUsPageNbr());
        
        pCCMN17DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg228.getArchInputStruct().getUlPageSizeNbr());
        pCCMN17DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg228.getArchInputStruct().getCReqFuncCd());
        
        
        /*
        ** Call CSES67D
        */
        rc = ccmn17dQUERYdam(sqlca, pCCMN17DInputRec, pCCMN17DOutputRec);
        
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i132 = 0;i132 < pCCMN17DOutputRec.getArchOutputStruct().getUlRowQty();i132++) {
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setSzCdTodoType(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getSzCdTodoType());
                    
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setDtDtTodoDue(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getDtDtTodoDue());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setSzNmStage(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getSzNmStage());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setSzScrTodoCreated(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getSzScrTodoCreated());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setSzTxtTodoDesc(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getSzTxtTodoDesc());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setSzCdTask(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getSzCdTask());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setSzCdStage(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getSzCdStage());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setSzCdStageProgram(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getSzCdStageProgram());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setLdIdTodo(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getLdIdTodo());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setUlIdCase(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getUlIdCase());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setUlIdStage(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getUlIdStage());
                    pOutputMsg209.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).setUlIdEvent(pCCMN17DOutputRec.getROWCCMN17DO_ARRAY().getROWCCMN17DO(i132).getUlIdEvent());
                }
                pOutputMsg209.getArchOutputStruct().setUlRowQty(pCCMN17DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg209.getArchOutputStruct().setBMoreDataInd(pCCMN17DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                
                //  Call CSES68D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
