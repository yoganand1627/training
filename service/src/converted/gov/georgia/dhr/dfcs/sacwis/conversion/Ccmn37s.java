package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND9DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN15DO;
/**************************************************************************
**
** Module File:   CCMN37S.src
**
** Service Name:  Retrieve Case Summary
**
** Description:   This service is designed to retrieve case information
**                as well as a list of stages associated with that case.
**                It receives ID CASE.  It returns data from the CASE,
**                PERSON, PERSON PHONE, STAGE, STAGE PERSON LINK tables.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  13 March 1995
**
** Programmer:    KRD
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   8/10/95  RUSSELRM  PWO #1141 - Retrieve the phone number of historical
**                      primary workers linked to closed stages - removed
**                      ccmnf1d
**
**   2/23/96  CRYSTAEP  SIR #2141 - Added CD_STAGE_REASON_CLOSED to
**                      CCMN15DO Output Record in order to determine if
**                      a stage was closed by Case Merge and is not a
**                      complete stage. If CD_STAGE_REASON_CLOSED == 97 on
**                      STAGE table, then populate output message indicator
**                      (ScrIndStageMerged) so that a checkmark will be
**                      placed in the first column of the Case Summary Window.
**
**	04/11/03	Srini   Removed the PERF_TIMER_END and commented the return statements
**						in  the middle of the service on the allocation failure cases.
**  04/27/04  corleyan  SIR 22638 Added CdCpsOverallDisptn to retrieval so it can be displayed
**                      on CPS INV Conclusion
**
**  08/30/05  Hadjimh   SIR#23617. Overall Disposition does not display for Licensing cases.
**                      changed the ccmn15d.pc DAM to dynamic DAM because Overall
**                      Disposition exists not only in CPS_INVST_DETAIL table but also in
**                      APS_INVST_DETAIL, LICENSING_INVST_DTL and FACILITY_INVST_DTL tables.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn37s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String BUSINESS_PERSON_PHONE = "BS";
    public static final char PRIMARY_PHONE = 'Y';
    public static final char STAGE_MERGED = 'Y';
    public static final char STAGE_NOT_MERGED = 'N';
    public static final String CLOSED_TO_MERGE = "97";
    CCMN37SO CCMN37S(CCMN37SI ccmn37si) {
        CCMN37SO ccmn37so = new CCMN37SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int uCount = 0;/* loop variable */
        CCMNF0DI pDamInMsg = null;
        CCMNF0DO pDamOutMsg = null;
        rc = ARC_PRFServiceStartTime_TUX(ccmn37si.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = Ccmn03u.CallCCMND9D(ccmn37si, ccmn37so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        rc = CallCCMN15D(ccmn37si, ccmn37so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** For each stage, obtain either the primary worker's name and business
        ** phone number
        */
        for (uCount = 0;uCount < ccmn37so.getArchOutputStruct().getUlRowQty();uCount++) {
            pDamInMsg.setUlIdPerson(ccmn37so.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(uCount).getUlIdPerson());
            
            //## BEGIN TUX/XML: Declare XML variables 
            pDamInMsg.setBIndPersonPhonePrimary(PRIMARY_PHONE);
            pDamInMsg.setSzCdPhoneType(BUSINESS_PERSON_PHONE);
            rc = CallCCMNF0D(pDamInMsg, pDamOutMsg, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            ccmn37so.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(uCount).setLNbrPhone(pDamOutMsg.getLNbrPhone());
            ccmn37so.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(uCount).setSzNmPersonFull(pDamOutMsg.getSzNmPersonFull());
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn37si.getArchInputStruct() , ccmn37so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Declare FOUNDATION variables
                
                //  Declare local variables
                
                // printf ("Start 81S\n");
                //  Start performance timer for service
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn37so;
    }

    static int CallCCMND9D(CCMN37SI pInputMsg334, CCMN37SO pOutputMsg304, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMND9DI pCCMND9DInputRec = null;
        CCMND9DO pCCMND9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND9DInputRec = new CCMND9DI();
        pCCMND9DOutputRec = new CCMND9DO();
        
        //## BEGIN TUX/XML: Declare XML variables
        pCCMND9DInputRec.setUlIdCase(pInputMsg334.getUlIdCase());
        pCCMND9DInputRec.setArchInputStruct(pInputMsg334.getArchInputStruct());
        
        
        /**************************************************************************
        ** Call DAM
        ***************************************************************************/
        rc = ccmnd9dQUERYdam(sqlca, pCCMND9DInputRec, pCCMND9DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg304.getROWCCMN37SOG01().setSzCdCaseRegion(pCCMND9DOutputRec.getSzCdCaseRegion());
                pOutputMsg304.getROWCCMN37SOG01().setSzCdCaseSpeclHndlg(pCCMND9DOutputRec.getSzCdCaseSpeclHndlg());
                pOutputMsg304.getROWCCMN37SOG01().setSzNmCase(pCCMND9DOutputRec.getSzNmCase());
                pOutputMsg304.getROWCCMN37SOG01().setDtDtCaseClosed(pCCMND9DOutputRec.getDtDtCaseClosed());
                pOutputMsg304.getROWCCMN37SOG01().setDtDtCaseOpened(pCCMND9DOutputRec.getDtDtCaseOpened());
                pOutputMsg304.getROWCCMN37SOG01().setBIndCaseSensitive(pCCMND9DOutputRec.getBIndCaseSensitive());
                pOutputMsg304.getROWCCMN37SOG01().setBIndCaseWorkerSafety(pCCMND9DOutputRec.getBIndCaseWorkerSafety());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN15D(CCMN37SI pInputMsg335, CCMN37SO pOutputMsg305, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i164 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN15DI pCCMN15DInputRec = null;
        CCMN15DO pCCMN15DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN15DInputRec = new CCMN15DI();
        pCCMN15DOutputRec = new CCMN15DO();
        pCCMN15DInputRec.setUlIdCase(pInputMsg335.getUlIdCase());
        pCCMN15DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
        pCCMN15DInputRec.setSzScrCdStagePersRole(PRIMARY_ROLE_STAGE_CLOSED);
        pCCMN15DInputRec.setSzCdStageProgram(pInputMsg335.getSzCdStageProgram());
        pCCMN15DInputRec.setArchInputStruct(pInputMsg335.getArchInputStruct());
        pCCMN15DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg335.getArchInputStruct().getUsPageNbr());
        pCCMN15DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg335.getArchInputStruct().getUlPageSizeNbr());
        rc = ccmn15dQUERYdam(sqlca, pCCMN15DInputRec, pCCMN15DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i164 = 0;i164 < pCCMN15DOutputRec.getArchOutputStruct().getUlRowQty();i164++) {
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setSzNmStage(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getSzNmStage());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setSzCdStage(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getSzCdStage());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setSzCdStageType(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getSzCdStageType());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setSzCdStageRegion(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getSzCdStageRegion());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setSzCdStageProgram(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getSzCdStageProgram());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setDtDtStageStart(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getDtDtStageStart());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setDtDtStageClose(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getDtDtStageClose());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setUlIdSituation(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getUlIdSituation());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setUlIdStage(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getUlIdStage());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setUlIdPerson(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getUlIdPerson());
                    pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setCdCpsOverallDisptn(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getCdCpsOverallDisptn());
                    if (!(CLOSED_TO_MERGE.compareTo(pCCMN15DOutputRec.getROWCCMN15DO_ARRAY().getROWCCMN15DO(i164).getSzCdStageReasonClosed()) != 0)) {
                        
                        pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setCScrIndStageMerged(STAGE_MERGED);
                    }
                    else {
                        pOutputMsg305.getROWCCMN37SOG02_ARRAY().getROWCCMN37SOG02(i164).setCScrIndStageMerged(STAGE_NOT_MERGED);
                    }
                }
                pOutputMsg305.getArchOutputStruct().setUlRowQty(pCCMN15DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg305.getArchOutputStruct().setBMoreDataInd(pCCMN15DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNF0D(CCMNF0DI pInputMsg336, CCMNF0DO pOutputMsg306, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNF0DI pCCMNF0DInputRec = null;
        CCMNF0DO pCCMNF0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF0DInputRec = new CCMNF0DI();
        pCCMNF0DOutputRec = new CCMNF0DO();
        pCCMNF0DInputRec.setUlIdPerson(pInputMsg336.getUlIdPerson());
        pCCMNF0DInputRec.setBIndPersonPhonePrimary(pInputMsg336.getBIndPersonPhonePrimary());
        pCCMNF0DInputRec.setSzCdPhoneType(pInputMsg336.getSzCdPhoneType());
        pCCMNF0DInputRec.setArchInputStruct(pInputMsg336.getArchInputStruct());
        
        rc = ccmnf0dQUERYdam(sqlca, pCCMNF0DInputRec, pCCMNF0DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg306.setLNbrPhone(pCCMNF0DOutputRec.getLNbrPhone());
                pOutputMsg306.setSzNmPersonFull(pCCMNF0DOutputRec.getSzNmPersonFull());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
