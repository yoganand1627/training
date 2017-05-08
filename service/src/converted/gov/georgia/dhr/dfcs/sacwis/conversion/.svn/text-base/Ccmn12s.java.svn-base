package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN12SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN42DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:   CCMN12S.src
**
** Service Name:  CCMN12S
**
** Description:   Retrieve all the Todos for a certain case and a time 
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
** Archive Information: $Revision:   1.3  $
**                      $Date:   09 Sep 1996 10:12:38  $
**                      $Modtime:   09 Sep 1996 09:19:44  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/18/95  FOGARTIS  SIR#59 SIR#146 - Handling of rows not found added
**  03/01/95  FOGARTIS  SIR#59 - Handling of rows not found modified
**  26Jun95   sladewmf  Update according to new standards.
**  7/26/96    zabihin  SIR 21891 : version control code was missing, I 
**                      added the line.
**  09/09/96    KRD     SIR 22250 - PROCESS_TUX_SQL_ERROR should only be called
**                      when there is an unexpected SQL return code from a
**                      DAM.  The error handling for CallCCMN42D() has been
**                      corrected.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/



/*
** Extern for version control table.
*/






public class Ccmn12s {
    CCMN12SO CCMN12S(CCMN12SI ccmn12si) {
        CCMN12SO ccmn12so = new CCMN12SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(ccmn12si.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = CallCCMN42D(ccmn12si, ccmn12so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        ARC_UTLGetDateAndTime(ccmn12so.getDtWCDDtSystemDate() , 0);
        
        /* load translation map with service name and version */
        
        /* stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(ccmn12si.getArchInputStruct() , ccmn12so.getArchOutputStruct());
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
        return ccmn12so;
    }

    static int CallCCMN42D(CCMN12SI pInputMsg229, CCMN12SO pOutputMsg210, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i133 = 0;
        /* declare local variables */
        CCMN42DI pCCMN42DInputRec = null;
        CCMN42DO pCCMN42DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN42DInputRec = new CCMN42DI();
        
        pCCMN42DOutputRec = new CCMN42DO();
        pCCMN42DInputRec.setArchInputStruct(pInputMsg229.getArchInputStruct());
        if ((pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).day == DateHelper.NULL_DATE || pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).month == DateHelper.NULL_DATE || pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).year == DateHelper.NULL_DATE) && (pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(0).day == DateHelper.NULL_DATE || pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(0).month == DateHelper.NULL_DATE || pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(0).year == DateHelper.NULL_DATE)) {
            FndInt3date tempDate = null;
            
            Tm t;
            
            
            // UPGRADE 2000 ITEM 3 If age is entered calculate birthdate.If age is entered,
            // determine an approximate DOB to pass into the new MATCH service of SSA-NAME3 for
            // scoring. After DOB is determined or when DOB is entered on window,
            // then determine DOB range to be used in finding matches and scoring
            
            //  (KRD 03/09/2001) Modified all of the date logic below to use the
            // ARC_UTLAddToDate() API rather than increasing the date manually to
            // avoid "Invalid Date" issues when adding/subtracting years from
            // Leap Day (February 29th).
            
            ARC_UTLGetDateAndTime(tempDate, 0);
            t.getDate() = tempDate.day;
            t.getMonth() = tempDate.month - 1;
            t.getYear() = tempDate.year - 1900;
            t.getDate() += 7;
            t.getTime();
            pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).day = t.getDate();
            pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).month = t.getMonth() + 1;
            
            pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1).year = t.getYear() + 1900;
        }
        pCCMN42DInputRec.setUlIdCase(pInputMsg229.getUlIdCase());
        pCCMN42DInputRec.getDtDtTodoDue_ARRAY().setDtDtTodoDue(0, pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(0));
        pCCMN42DInputRec.getDtDtTodoDue_ARRAY().setDtDtTodoDue(1, pInputMsg229.getDtDtTodoDue_ARRAY().getDtDtTodoDue(1));
        
        /*
        ** Call DAM
        */
        rc = ccmn42dQUERYdam(sqlca, pCCMN42DInputRec, pCCMN42DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i133 = 0;i133 < pCCMN42DOutputRec.getArchOutputStruct().getUlRowQty();++i133) {
                    pOutputMsg210.getROWCCMN42DO_ARRAY().setROWCCMN42DO(i133, pCCMN42DOutputRec.getROWCCMN42DO_ARRAY().getROWCCMN42DO(i133));
                }
                pOutputMsg210.getArchOutputStruct().setUlRowQty(pCCMN42DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg210.getArchOutputStruct().setBMoreDataInd(pCCMN42DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                //  Reset return code if no determination factors or
                // descriptors were found.
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
                //  PWO 1111: Removed case statement.
                // case MSG_CMN_TMSTAMP_MISMATCH:
                // return (FND_SUCCESS);
                // break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
