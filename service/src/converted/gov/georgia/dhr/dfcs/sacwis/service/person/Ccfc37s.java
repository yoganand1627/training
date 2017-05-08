package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES31DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES31DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC58DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CCFC37S.src
**
** Service Name:   CCFC37S
**
** Description:   This service will retrieve all columns for an IdPerson 
**                from the Person Dtl table.  It will call DAM 
**                CSES31D - Person Dtl Retrieve
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/12/95 
** 
** Programmer:    CIN
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   02 May 2000 15:03:24  $
**                      $Modtime:   01 May 2000 14:20:38  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/06/1999 PAULS    SIR 14462 - Moved Mother Married Field from Conservatorship
**                      Removal window to Person Detail CVS/FA .
**  04/28/2000 PERIL    SIR 14902 - Added a new dam CSEC58D.PC which checks
**                      for 'Mother Married Field Info'. check under comment
**                      14902.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/






public class Ccfc37s {
    CCFC37SO CCFC37S(CCFC37SI ccfc37si) {
        CCFC37SO ccfc37so = new CCFC37SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code   */
        int i59 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        int RetVal = SUCCESS;
        
        CSES31DI pCSES31DInputRec = null;
        CSES31DO pCSES31DOutputRec = null;
        
        /*
        ** Sir 14902
        */
        CSEC58DI pCSEC58DInputRec = null;
        CSEC58DO pCSEC58DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccfc37si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSEC58DInputRec = new CSEC58DI();
        
        pCSEC58DOutputRec = new CSEC58DO();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES31DInputRec = new CSES31DI();
        
        pCSES31DOutputRec = new CSES31DO();
        pCSES31DInputRec.setArchInputStruct(ccfc37si.getArchInputStruct());
        
        /*********************************************************************
        *  Call DAM to check for any outstanding Law Enforcement Notification
        *  ToDos prior to saving.
        **********************************************************************/
        
        /*******************************************************************
        ** BRUCKMK: 
        ** PARAGON Stage Progression fix.  We need to have a 
        ** way to bypass the LE Notification requirement for
        ** converted PARAGON Intakes ( 5999999 < ID_STAGE <
        ** 7000000).  Added logic when calling CINT58D to see
        ** if the ID_STAGE is in the above range.  If it is,
        ** the LE Notification requirement will be bypassed. 
        *******************************************************************/
        /*
        ** SIR 21940
        ** Stage progression fix.  Added if conditions to stage progress
        ** converted intakes without LE notification generation.
        ** SIR 21940 GLOORJW added () after the ! so it would
        ** include both statements
        ** What the statement below really says is
        ** if the ID_STAGE is within the PARAGON limits OR within
        ** the converted case limits...DO NOT check for the LE
        ** Notification and progress the stage as if it existed.
        */
        
        if (0 != ccfc37si.getUlIdStage()) {
            pCSEC58DInputRec.setUlIdStage(ccfc37si.getUlIdStage());
            rc = csec58dQUERYdam(sqlca, pCSEC58DInputRec, pCSEC58DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    pCSES31DInputRec.setUlIdPerson(pCSEC58DOutputRec.getUlIdPerson());
                    break;
                    
                    
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        
        
        
        
        else {
            pCSES31DInputRec.setUlIdPerson(ccfc37si.getUlIdPerson());
        }
        
        /*
        ** Call DAM
        */
        rc = cses31dQUERYdam(sqlca, pCSES31DInputRec, pCSES31DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                ccfc37so.setSzCdPersonBirthCity(pCSES31DOutputRec.getSzCdPersonBirthCity());
                ccfc37so.setSzCdPersonBirthCountry(pCSES31DOutputRec.getSzCdPersonBirthCountry());
                ccfc37so.setSzCdPersonBirthCounty(pCSES31DOutputRec.getSzCdPersonBirthCounty());
                ccfc37so.setSzCdPersonBirthState(pCSES31DOutputRec.getSzCdPersonBirthState());
                ccfc37so.setSzCdPersonCitizenship(pCSES31DOutputRec.getSzCdPersonCitizenship());
                ccfc37so.setSzCdPersonEyeColor(pCSES31DOutputRec.getSzCdPersonEyeColor());
                ccfc37so.setSzCdPersonFaHomeRole(pCSES31DOutputRec.getSzCdPersonFaHomeRole());
                ccfc37so.setSzCdPersonHairColor(pCSES31DOutputRec.getSzCdPersonHairColor());
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                ccfc37so.setSzCdPersonHighestEduc(pCSES31DOutputRec.getSzCdPersonHighestEduc());
                
                ccfc37so.setSzNmPersonLastEmployer(pCSES31DOutputRec.getSzNmPersonLastEmployer());
                ccfc37so.setSzNmPersonMaidenName(pCSES31DOutputRec.getSzNmPersonMaidenName());
                ccfc37so.setTsLastUpdate(pCSES31DOutputRec.getTsLastUpdate());
                ccfc37so.setUlIdPerson(pCSES31DOutputRec.getUlIdPerson());
                ccfc37so.setLdAmtPersonAnnualIncome(pCSES31DOutputRec.getLdAmtPersonAnnualIncome());
                ccfc37so.setCIndPersonNoUsBrn(pCSES31DOutputRec.getCIndPersonNoUsBrn());
                ccfc37so.setSQtyPersonHeightFeet(pCSES31DOutputRec.getSQtyPersonHeightFeet());
                ccfc37so.setSQtyPersonHeightInches(pCSES31DOutputRec.getSQtyPersonHeightInches());
                ccfc37so.setLQtyPersonWeight(pCSES31DOutputRec.getLQtyPersonWeight());
                
                ccfc37so.setCCdRemovalMothrMarrd(pCSES31DOutputRec.getCCdRemovalMothrMarrd());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
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
        ARC_PRFServiceStopTime_TUX(ccfc37si.getArchInputStruct() , ccfc37so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        /*********************************************************************
        *  Prepare output message to be returned and return
        **********************************************************************/
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
        return ccfc37so;
    }

}
