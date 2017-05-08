package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS38DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:    CFAD12S.src
**
** Service Name:   CFAD12S
**
** Description:   The Service displays the effective dated history for
**                a given F/A Home.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/07/95
**
** Programmer:    Ramani Vishnubhotla
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:14:54  $
**                      $Modtime:   30 Mar 1996 00:07:46  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/18/05  Hadjimh   SIR#23327. Add a new field to the Home Information page. This new
**                      field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
**                      Adoptive Home checkbox is checked, staff will have to select a
**                      'Certifying Entity'. to indicate the certifying agency
**                      2) This will be a required field when the Non-FPS Adoptive Home
**                      checkbox is checked for a new home. 3) If a user is modifying an
**                      existing Non-FPS Adoptive Home, this new field will be required,
**                      unless the home status is also being changed to 'Pending Closure'
**                      or 'Closed'.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad12s {
    CFAD12SO CFAD12S(CFAD12SI cfad12si) {
        CFAD12SO cfad12so = new CFAD12SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i209 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  long            rc = 0;
        
        CLSS38DI pCLSS38DInputRec = null;
        CLSS38DO pCLSS38DOutputRec = null;
        
        /* Call DAM 89 to get the user's supervisor */
        rc = ARC_PRFServiceStartTime_TUX(cfad12si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing - Retrieve the History
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS38DInputRec = new CLSS38DI();
        
        pCLSS38DOutputRec = new CLSS38DO();
        pCLSS38DInputRec.setArchInputStruct(cfad12si.getArchInputStruct());
        pCLSS38DInputRec.setUlIdStage(cfad12si.getUlIdStage());
        pCLSS38DInputRec.getArchInputStruct().setUsPageNbr(cfad12si.getArchInputStruct().getUsPageNbr());
        pCLSS38DInputRec.getArchInputStruct().setUlPageSizeNbr(cfad12si.getArchInputStruct().getUlPageSizeNbr());
        
        /* Call DAM 82 to get TASK decode */
        rc = clss38dQUERYdam(sqlca, pCLSS38DInputRec, pCLSS38DOutputRec);
        
        /*
        ** Analyze return code for CINT21D
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CFAD12SO to fields in CLSS38DO
                
                for (i209 = 0;i209 < pCLSS38DOutputRec.getArchOutputStruct().getUlRowQty();i209++) //  The following DAMs should only be called if DAM CINV51 is successful.
                {
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setDtDtRshsEffective(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getDtDtRshsEffective());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setDtDtRshsEnd(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getDtDtRshsEnd());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsCategory(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsCategory());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsFaHomeStatus(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsFaHomeStatus());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setUNbrRshsFacilCapacity(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getUNbrRshsFacilCapacity());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setUNbrRshsAFeAgeMax(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getUNbrRshsFMAgeMax());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setUNbrRshsAFeAgeMin(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getUNbrRshsFMAgeMin());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setUNbrRshsAMaAgeMax(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getUNbrRshsMaAgeMax());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setUNbrRshsAMaAgeMin(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getUNbrRshsMaAgeMin());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsClosureRsn(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsClosureRsn());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsRecmndReopen(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsRecmndReopen());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsInvolClosure(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsInvolClosure());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsEthnicity(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsEthnicity());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsLanguage(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsLanguage());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsReligion(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsReligion());
                    
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setDNbrRshsAnnualIncome(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getDNbrRshsAnnualIncome());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsMaritalStatus(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsMaritalStatus());
                    
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setDtDtRshsMarriage(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getDtDtRshsMarriage());
                    
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsSourceInquiry(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsSourceInquiry());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdRshsRespite(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdRshsRespite());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCIndRshsNonPrs(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCIndRshsNonPrs());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setSzCdCertifyEntity(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getSzCdCertifyEntity());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCIndRshsIndivStudy(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCIndRshsIndivStudy());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCIndRshsCareProv(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCIndRshsCareProv());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setUlIdResourceHistory(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getUlIdResourceHistory());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCCdRshsFaHomeType1(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCCdRshsFaHomeType1());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCCdRshsFaHomeType2(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCCdRshsFaHomeType2());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCCdRshsFaHomeType3(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCCdRshsFaHomeType3());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCCdRshsFaHomeType4(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCCdRshsFaHomeType4());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCCdRshsFaHomeType5(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCCdRshsFaHomeType5());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCCdRshsFaHomeType6(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCCdRshsFaHomeType6());
                    cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00(i209).setCCdRshsFaHomeType7(pCLSS38DOutputRec.getROWCLSS38DO_ARRAY().getROWCLSS38DO(i209).getCCdRshsFaHomeType7());
                }
                cfad12so.getArchOutputStruct().setBMoreDataInd(pCLSS38DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfad12so.getArchOutputStruct().setUlRowQty(pCLSS38DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  SIR 2427: Added DAM CINT21D to retrieve szCdStage, since I&R 
                // and SPC intakes do not have a stage name, 
                // which kills ccmn19d.
                
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
        ARC_PRFServiceStopTime_TUX(cfad12si.getArchInputStruct() , cfad12so.getArchOutputStruct());
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
        return cfad12so;
    }

}
