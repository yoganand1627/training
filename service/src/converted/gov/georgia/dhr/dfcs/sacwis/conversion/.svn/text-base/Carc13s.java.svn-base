package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD19DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CARC13S.src
**
** Service Name:  CARC13S
**
** Description:   Security Class AUD saves, updates, and/or deletes data
**                added or changed to a Security Class row on the database.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  26-OCT-95
**
** Programmer:    adkinsmc
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:25:16  $
**                      $Modtime:   28 Mar 1996 22:10:36  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/10/96    KRD     SIR 2570 - In order to modify the
**                      CD_SECURITY_CLASS_NAME column of the SECURITY_CLASS
**                      table, it is necessary to pass the original name
**                      into the DAM.  As a result, it was necessary to add
**                      a data element to the service input message and the
**                      input copybook for CAUD19D.  The Populate DAM
**                      Structure section was modified to accomodate the new
**                      data elements.
**
**  04/18/01    RJC     SECURITY UPGRADE - Added IND_RESTRICT to the
**                      SECURITY_CLASS table.   IND_RESTRICT is an indicator
**                      for those profiles that can only be assigned by IT
**                      Security personnel.  Added to the call to CAUD19D
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Carc13s {
    CARC13SO CARC13S(CARC13SI carc13si) {
        CARC13SO carc13so = new CARC13SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  short rc = FND_SUCCESS;
        
        CAUD19DI pCAUD19DInputRec = null;
        CAUD19DO pCAUD19DOutputRec = null;
        
        int usRow = 0;
        int usInputRow = 0;
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_PRFServiceStartTime_TUX(carc13si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        /**************************************************************************
        ** OPTIONAL CODE NOTE (BEGIN): Generic List AUD
        **************************************************************************/
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD19DInputRec = new CAUD19DI();
        
        pCAUD19DOutputRec = new CAUD19DO();
        rc = WtcHelperConstants.SQL_SUCCESS;
        
        /*
        ** While more rows are left to process and rc is zero,
        ** continue loop.
        */
        while ((usRow < carc13si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
            pCAUD19DInputRec.setArchInputStruct(carc13si.getArchInputStruct());
            pCAUD19DInputRec.getArchInputStruct().setCReqFuncCd(carc13si.getROWCARC13SIG00_ARRAY().getROWCARC13SIG00(usRow).getSzCdSysDataActionOutcome());
            pCAUD19DInputRec.setSzTxtSecurityClassProfil(carc13si.getROWCARC13SIG00_ARRAY().getROWCARC13SIG00(usRow).getSzTxtSecurityClassProfil());
            pCAUD19DInputRec.setTsLastUpdate(carc13si.getROWCARC13SIG00_ARRAY().getROWCARC13SIG00(usRow).getTsLastUpdate());
            pCAUD19DInputRec.setCIndRestrict(carc13si.getROWCARC13SIG00_ARRAY().getROWCARC13SIG00(usRow).getCIndRestrict());
            
            pCAUD19DInputRec.setSzNmSecurityClass(carc13si.getROWCARC13SIG00_ARRAY().getROWCARC13SIG00(usRow).getSzNmSecurityClass());
            pCAUD19DInputRec.setSzCdEmpSecurityClassNm(carc13si.getROWCARC13SIG00_ARRAY().getROWCARC13SIG00(usRow).getSzCdEmpSecurityClassNm());
            rc = caud19dAUDdam(sqlca, pCAUD19DInputRec, pCAUD19DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_CHILD_REF_INTEGRITY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_ARC_CLASS_IN_USE;
                    // 
                    // (END): CLSS68D - Retrieve contract service codes for
                    // the contract, period, and version passed to the DAM.
                    // 
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
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
        ARC_PRFServiceStopTime_TUX(carc13si.getArchInputStruct() , carc13so.getArchOutputStruct());
        
        
        
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
                
                //  Call CINV29D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
            //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            
        }
        return carc13so;
    }

}
