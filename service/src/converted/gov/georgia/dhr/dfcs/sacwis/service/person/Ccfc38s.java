package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD90DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD90DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC38S.src
**
** Service Name:  CCFC38S
**
** Description:   This service will update all columns for an Id Person 
**                from the Person Dtl tables.  It can add or modify a 
**                Person Dtl Row.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/8/95
** 
** Programmer:    C.Negrete 
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   07 May 1999 07:44:04  $
**                      $Modtime:   06 May 1999 15:59:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/06/1999 PAULS    SIR 14462 - Moved Mother Married Field from Conservatorship
**                      Removal window to Person Detail CVS/FA .
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc38s {
    CCFC38SO CCFC38S(CCFC38SI ccfc38si) {
        CCFC38SO ccfc38so = new CCFC38SO();
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
        
        CAUD90DI pCAUD90DInputRec = null;
        CAUD90DO pCAUD90DOutputRec = null;
        
        
        /*
        ** Call CCMN01U
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc38si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD90DInputRec = new CAUD90DI();
        
        pCAUD90DOutputRec = new CAUD90DO();
        pCAUD90DInputRec.setArchInputStruct(ccfc38si.getArchInputStruct());
        pCAUD90DInputRec.getArchInputStruct().setCReqFuncCd(ccfc38si.getArchInputStruct().getCReqFuncCd());
        pCAUD90DInputRec.setSzCdPersonBirthCity(ccfc38si.getSzCdPersonBirthCity());
        pCAUD90DInputRec.setSzCdPersonBirthCountry(ccfc38si.getSzCdPersonBirthCountry());
        pCAUD90DInputRec.setSzCdPersonBirthCounty(ccfc38si.getSzCdPersonBirthCounty());
        pCAUD90DInputRec.setSzCdPersonBirthState(ccfc38si.getSzCdPersonBirthState());
        pCAUD90DInputRec.setSzCdPersonCitizenship(ccfc38si.getSzCdPersonCitizenship());
        pCAUD90DInputRec.setSzCdPersonEyeColor(ccfc38si.getSzCdPersonEyeColor());
        pCAUD90DInputRec.setSzCdPersonFaHomeRole(ccfc38si.getSzCdPersonFaHomeRole());
        pCAUD90DInputRec.setSzCdPersonHairColor(ccfc38si.getSzCdPersonHairColor());
        pCAUD90DInputRec.setSzCdPersonHighestEduc(ccfc38si.getSzCdPersonHighestEduc());
        pCAUD90DInputRec.setSzNmPersonLastEmployer(ccfc38si.getSzNmPersonLastEmployer());
        pCAUD90DInputRec.setSzNmPersonMaidenName(ccfc38si.getSzNmPersonMaidenName());
        pCAUD90DInputRec.setTsLastUpdate(ccfc38si.getTsLastUpdate());
        pCAUD90DInputRec.setUlIdPerson(ccfc38si.getUlIdPerson());
        pCAUD90DInputRec.setLdAmtPersonAnnualIncome(ccfc38si.getLdAmtPersonAnnualIncome());
        pCAUD90DInputRec.setCIndPersonNoUsBrn(ccfc38si.getCIndPersonNoUsBrn());
        pCAUD90DInputRec.setSQtyPersonHeightFeet(ccfc38si.getSQtyPersonHeightFeet());
        pCAUD90DInputRec.setSQtyPersonHeightInches(ccfc38si.getSQtyPersonHeightInches());
        pCAUD90DInputRec.setLQtyPersonWeight(ccfc38si.getLQtyPersonWeight());
        pCAUD90DInputRec.setCCdRemovalMothrMarrd(ccfc38si.getCCdRemovalMothrMarrd());
        
        rc = caud90dAUDdam(sqlca, pCAUD90DInputRec, pCAUD90DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
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
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc38si.getArchInputStruct() , ccfc38so.getArchOutputStruct());
        /*
        ** Closed Case that is either CCL or RCL
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  Check if the Overall Disposition in the
            // LICENSING_INVST_DTL table is "R/O"
            // 
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
        return ccfc38so;
    }

}
