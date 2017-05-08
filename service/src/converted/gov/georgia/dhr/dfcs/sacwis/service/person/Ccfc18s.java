package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD78DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD78DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC18S.src
**
** Service Name:  CCFC18S
**
** Description:   This service will add/update/delete all changed or added 
**                rows to the EDUCATIONAL HISTORY table for a given ID_EDHIST.
**                A new ID_EDHIST will be triggered if a new row is added.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1-16-96
** 
** Programmer:    Tyler Chessman 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:37:48  $
**                      $Modtime:   29 Mar 1996 23:56:38  $
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






public class Ccfc18s {
    
    public static final char IN_STATE = 'I';
    CCFC18SO CCFC18S(CCFC18SI ccfc18si) {
        CCFC18SO ccfc18so = new CCFC18SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables 
        
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        
        CAUD78DI pCAUD78DInputRec = null;
        CAUD78DO pCAUD78DOutputRec = null;
        
        
        int usRow = 0;
        int usInputRow = 0;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc18si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD78DInputRec = new CAUD78DI();
        
        pCAUD78DOutputRec = new CAUD78DO();
        
        /* SIR 15346
        ** pOutputMsg->dtDtSvcAuthDtlEnd =
        **            pCSECA3DOutputRec->dtDtSvcAuthDtlEnd;
        */
        
        rc = WtcHelperConstants.SQL_SUCCESS;
        
        /*
        ** While more rows are left to process and rc is zero,
        ** continue loop.
        */
        while ((usRow < ccfc18si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
            pCAUD78DInputRec.setArchInputStruct(ccfc18si.getArchInputStruct());
            pCAUD78DInputRec.getArchInputStruct().setCReqFuncCd(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdScrDataAction());
            pCAUD78DInputRec.setTsLastUpdate(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getTsLastUpdate());
            pCAUD78DInputRec.setDtDtEdhistEnrollDate(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getDtDtEdhistEnrollDate());
            pCAUD78DInputRec.setDtDtEdhistWithdrawnDate(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getDtDtEdhistWithdrawnDate());
            pCAUD78DInputRec.setCIndEdhistTeaSchool(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getCIndEdhistTeaSchool());
            
            if (IN_STATE != ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getCIndEdhistTeaSchool()) {
                pCAUD78DInputRec.setSzAddrEdhistCity(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzAddrEdhistCity());
                pCAUD78DInputRec.setSzAddrEdhistCnty(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzAddrEdhistCnty());
                pCAUD78DInputRec.setSzAddrEdhistState(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzAddrEdhistState());
                pCAUD78DInputRec.setSzAddrEdhistStreetLn1(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzAddrEdhistStreetLn1());
                pCAUD78DInputRec.setSzAddrEdhistStreetLn2(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzAddrEdhistStreetLn2());
                pCAUD78DInputRec.setSzAddrEdhistZip(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzAddrEdhistZip());
                
                pCAUD78DInputRec.setSzNbrEdhistPhone(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzNbrEdhistPhone());
                pCAUD78DInputRec.setSzNbrEdhistPhoneExt(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzNbrEdhistPhoneExt());
            }
            pCAUD78DInputRec.setSzTxtEdhistAddrCmnt(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzTxtEdhistAddrCmnt());
            pCAUD78DInputRec.setSzCdEdhistEnrollGrade(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistEnrollGrade());
            pCAUD78DInputRec.setSzCdEdhistWithdrawnGrade(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistWithdrawnGrade());
            pCAUD78DInputRec.setSzCdEdhistNeeds1(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistNeeds1());
            pCAUD78DInputRec.setSzCdEdhistNeeds2(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistNeeds2());
            pCAUD78DInputRec.setSzCdEdhistNeeds3(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistNeeds3());
            pCAUD78DInputRec.setSzCdEdhistNeeds4(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistNeeds4());
            pCAUD78DInputRec.setSzCdEdhistNeeds5(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistNeeds5());
            pCAUD78DInputRec.setSzCdEdhistNeeds6(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistNeeds6());
            pCAUD78DInputRec.setSzCdEdhistNeeds7(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistNeeds7());
            pCAUD78DInputRec.setSzCdEdhistNeeds8(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzCdEdhistNeeds8());
            pCAUD78DInputRec.setSzNmEdhistSchool(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzNmEdhistSchool());
            pCAUD78DInputRec.setSzNmEdhistSchDist(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getSzNmEdhistSchDist());
            pCAUD78DInputRec.setUlIdEdhist(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getUlIdEdhist());
            pCAUD78DInputRec.setUlIdResource(ccfc18si.getROWCCFC18SIG00_ARRAY().getROWCCFC18SIG00(usRow).getUlIdResource());
            pCAUD78DInputRec.setUlIdPerson(ccfc18si.getUlIdPerson());
            
            rc = caud78dAUDdam(sqlca, pCAUD78DInputRec, pCAUD78DOutputRec);
            
            //  Added SQL_NOT_FOUND in the case
            // that the employee has no skills
            //  Analyze return code for CLSCB4D
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            usRow++;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc18si.getArchInputStruct() , ccfc18so.getArchOutputStruct());
        
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
        return ccfc18so;
    }

}
