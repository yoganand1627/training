package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV56SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV56SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC84DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV86DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV86DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT09DO;
/**************************************************************************
**
** Module File:   CINV56S.SRC
**
** Service Name:  CINV56S
**
** Description: This service is used in the Predisplay callback of window
**              CINV08W - LICENSING INV CONC. It retrieves all the values
**              necessary to populate window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  5/29/95
**
** Programmer:    Alex Ramirez
**
** Change History:
** Date      User      Description
** --------  --------  --------------------------------------------------
**
**  01/08/96  BRUCKMK   SIR 1972: Do not populate
**                      pOutputMsg->ROWCINV56SOG02.dtDtLicngInvstIntake
**                      with the date "DT_LICNG_INVST_INTAKE" on the
**                      LICENSING_INVST_DTL table.
**                      Instead created and added DAM CLSC69D to retrieve the
**                      "DT_INCOMING_CALL" from the INCOMING_DETAIL table for
**                      the Intake stage of the given ID_CASE.
**  01/30/96  BRUCKMK   SIR 1947: Always get the Investigation Begun Date from
**                      the Date of First Contact retrieved by DAM CSYS15D.
**                      There is no need for an "if" statement here before
**                      calling CSYS15D, since we always want to call this
**                      DAM.  Also do not populate the Investigation Begun
**                      Date in the Investigation Detail Table retrieve.
**
** 2/19/97   SARAVIGM   SIR#11377-The DAM that is being called by this service
**                      has changed from clsc69d.pc to clsc84d.pc.
**                      This DAM will retrieve the correct intake date for the
**                      Investigation Conclusion windows used in CAPS.
**
** 03/17/97  GONZALCE   SIR 12090 - added ulIdPriorStage to the service output
**                      message.  Populated this field using CLSC84D.
**
** 03/14/04  DOUGLACS   SIR 22756 - Allow users to select/update facility
**                      information on Licensing Inv Concl page.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv56s {
    public static final int NULL_DATE = - 1;
    CINV56SO CINV56S(CINV56SI cinv56si) {
        CINV56SO cinv56so = new CINV56SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /* Declare FOUNDATION variables  */
        
        
        /*
        ** Declare local variables
        */
        Pint ulPriorStage = new Pint();
        rc = ARC_PRFServiceStartTime_TUX(cinv56si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cinv56so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Cinv44s.CallCINV74D(cinv56si, cinv56so, pServiceStatus);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  Success Case for Dam CSES68D (CVS)
            case WtcHelperConstants.ARC_SUCCESS:
                
                if (cinv56si.getUlIdEvent() != 0) {
                    rc = Ccmn01u.CallCCMN45D(cinv56si, cinv56so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                            //  SQL Not Found Case for Dam CSES68D (CVS)
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    if ((cinv56so.getROWCINV56SOG02().getUlIdResource() == 0) && (cinv56so.getROWCINV56SOG02().getUlIdAffilResource() == 0) && (cinv56so.getROWCINV56SOG02().getLNbrRsrcFacilAcclaim() == 0) && (cinv56so.getROWCINV56SOG02().getLNbrAffilAcclaim() == 0)) {
                        rc = Cinv17s.CallCINV86D(cinv56si, cinv56so, ulPriorStage, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        rc = Cinv17s.CallCINT09D(cinv56si, cinv56so, ulPriorStage.value, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        
        /*
        ** Start Performance Timer
        */
        rc = Cinv14s.CallCSYS15D(cinv56si, cinv56so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  Success Case for Dam CSES68D (ACH)
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Start performance timer for service. All performance functions always
        ** return success so there is no need to check status.
        */
        rc = Ccmn80s.CallCINT40D(cinv56si, cinv56so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  SQL Not Found Case for Dam CSES68D (ACH)
            case WtcHelperConstants.ARC_SUCCESS:
                //  Do nothing, the output message just returns success or
                // failure.
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Cinv14s.CallCLSC84D(cinv56si, cinv56so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  Success Case for Dam CSES41D
            case SUCCESS:
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
        ARC_PRFServiceStopTime_TUX(cinv56si.getArchInputStruct() , cinv56so.getArchOutputStruct());
        
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
        
        return cinv56so;
    }

    static int CallCINV74D(CINV56SI pInputMsg772, CINV56SO pOutputMsg717, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables 
        */
        int rc = 0;
        CINV74DI pCINV74DInputRec = null;
        CINV74DO pCINV74DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV74DInputRec = new CINV74DI();
        
        pCINV74DOutputRec = new CINV74DO();
        pCINV74DInputRec.setArchInputStruct(pInputMsg772.getArchInputStruct());
        pCINV74DInputRec.setUlIdStage(pInputMsg772.getUlIdStage());
        rc = cinv74dQUERYdam(sqlca, pCINV74DInputRec, pCINV74DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg717.getROWCINV56SOG02().setTsLastUpdate(pCINV74DOutputRec.getTsLastUpdate());
                pOutputMsg717.getROWCINV56SOG02().setSzCdLicngInvstCoractn(pCINV74DOutputRec.getSzCdLicngInvstCoractn());
                pOutputMsg717.getROWCINV56SOG02().setSzCdLicngInvstOvrallDisp(pCINV74DOutputRec.getSzCdLicngInvstOvrallDisp());
                pOutputMsg717.getROWCINV56SOG02().setDtDtLicngInvstAssigned(pCINV74DOutputRec.getDtDtLicngInvstAssigned());
                pOutputMsg717.getROWCINV56SOG02().setDtDtLicngInvstComplt(pCINV74DOutputRec.getDtDtLicngInvstComplt());
                pOutputMsg717.getROWCINV56SOG02().setUlIdEvent(pCINV74DOutputRec.getUlIdEvent());
                pOutputMsg717.getROWCINV56SOG02().setTxtLicngInvstNoncomp(pCINV74DOutputRec.getTxtLicngInvstNoncomp());
                pOutputMsg717.getROWCINV56SOG02().setUlIdStage(pCINV74DOutputRec.getUlIdStage());
                pOutputMsg717.getROWCINV56SOG02().setUlIdResource(pCINV74DOutputRec.getUlIdResource());
                pOutputMsg717.getROWCINV56SOG02().setSzNmResource(pCINV74DOutputRec.getSzNmResource());
                pOutputMsg717.getROWCINV56SOG02().setLNbrRsrcFacilAcclaim(pCINV74DOutputRec.getLNbrRsrcFacilAcclaim());
                pOutputMsg717.getROWCINV56SOG02().setSzCdRsrcFacilType(pCINV74DOutputRec.getSzCdRsrcFacilType());
                pOutputMsg717.getROWCINV56SOG02().setSzTxtRsrcComments(pCINV74DOutputRec.getSzTxtRsrcComments());
                pOutputMsg717.getROWCINV56SOG02().setLNbrFacilPhoneNumber(pCINV74DOutputRec.getLNbrFacilPhoneNumber());
                pOutputMsg717.getROWCINV56SOG02().setLNbrFacilPhoneExtension(pCINV74DOutputRec.getLNbrFacilPhoneExtension());
                pOutputMsg717.getROWCINV56SOG02().setSzAddrRsrcAddrAttn(pCINV74DOutputRec.getSzAddrRsrcAddrAttn());
                pOutputMsg717.getROWCINV56SOG02().setSzAddrRsrcAddrStLn1(pCINV74DOutputRec.getSzAddrRsrcAddrStLn1());
                pOutputMsg717.getROWCINV56SOG02().setSzAddrRsrcAddrStLn2(pCINV74DOutputRec.getSzAddrRsrcAddrStLn2());
                pOutputMsg717.getROWCINV56SOG02().setSzAddrRsrcAddrCity(pCINV74DOutputRec.getSzAddrRsrcAddrCity());
                pOutputMsg717.getROWCINV56SOG02().setSzAddrRsrcAddrCounty(pCINV74DOutputRec.getSzAddrRsrcAddrCounty());
                pOutputMsg717.getROWCINV56SOG02().setSzAddrRsrcAddrState(pCINV74DOutputRec.getSzAddrRsrcAddrState());
                
                pOutputMsg717.getROWCINV56SOG02().setSzAddrRsrcAddrZip(pCINV74DOutputRec.getSzAddrRsrcAddrZip());
                pOutputMsg717.getROWCINV56SOG02().setUlIdAffilResource(pCINV74DOutputRec.getUlIdAffilResource());
                pOutputMsg717.getROWCINV56SOG02().setSzNmAffilResource(pCINV74DOutputRec.getSzNmAffilResource());
                pOutputMsg717.getROWCINV56SOG02().setSzTxtAffilComments(pCINV74DOutputRec.getSzTxtAffilComments());
                pOutputMsg717.getROWCINV56SOG02().setLNbrAffilPhoneNumber(pCINV74DOutputRec.getLNbrAffilPhoneNumber());
                pOutputMsg717.getROWCINV56SOG02().setLNbrAffilPhoneExtension(pCINV74DOutputRec.getLNbrAffilPhoneExtension());
                pOutputMsg717.getROWCINV56SOG02().setSzAffilAddrAttn(pCINV74DOutputRec.getSzAffilAddrAttn());
                pOutputMsg717.getROWCINV56SOG02().setSzAffilAddrStLn1(pCINV74DOutputRec.getSzAffilAddrStLn1());
                pOutputMsg717.getROWCINV56SOG02().setSzAffilAddrStLn2(pCINV74DOutputRec.getSzAffilAddrStLn2());
                pOutputMsg717.getROWCINV56SOG02().setSzAffilAddrCity(pCINV74DOutputRec.getSzAffilAddrCity());
                pOutputMsg717.getROWCINV56SOG02().setSzAffilAddrCounty(pCINV74DOutputRec.getSzAffilAddrCounty());
                pOutputMsg717.getROWCINV56SOG02().setSzAffilAddrState(pCINV74DOutputRec.getSzAffilAddrState());
                pOutputMsg717.getROWCINV56SOG02().setSzAffilAddrZip(pCINV74DOutputRec.getSzAffilAddrZip());
                pOutputMsg717.getROWCINV56SOG02().setUlIdClassFclty(pCINV74DOutputRec.getUlIdClassFclty());
                pOutputMsg717.getROWCINV56SOG02().setUlIdClassAffilFclty(pCINV74DOutputRec.getUlIdClassAffilFclty());
                pOutputMsg717.getROWCINV56SOG02().setLNbrAffilAcclaim(pCINV74DOutputRec.getLNbrAffilAcclaim());
                pOutputMsg717.getROWCINV56SOG02().setLNbrAgency(pCINV74DOutputRec.getLNbrAgency());
                pOutputMsg717.getROWCINV56SOG02().setLNbrBranch(pCINV74DOutputRec.getLNbrBranch());
                pOutputMsg717.getROWCINV56SOG02().setLNbrAffilAgency(pCINV74DOutputRec.getLNbrAffilAgency());
                pOutputMsg717.getROWCINV56SOG02().setLNbrAffilBranch(pCINV74DOutputRec.getLNbrAffilBranch());
                pOutputMsg717.getROWCINV56SOG02().setSzCdAffilFacilType(pCINV74DOutputRec.getSzCdAffilFacilType());
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN45D(CINV56SI pInputMsg773, CINV56SO pOutputMsg718, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i387 = 0;
        int rc = 0;
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg773.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg773.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg718.getROWCINV56SOG01().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pOutputMsg718.getROWCINV56SOG01().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                pOutputMsg718.getROWCINV56SOG01().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                
                pOutputMsg718.getROWCINV56SOG01().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pOutputMsg718.getROWCINV56SOG01().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg718.getROWCINV56SOG01().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pOutputMsg718.getROWCINV56SOG01().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                pOutputMsg718.getROWCINV56SOG01().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                pOutputMsg718.getROWCINV56SOG01().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSYS15D(CINV56SI pInputMsg774, CINV56SO pOutputMsg719, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i388 = 0;
        int rc = 0;/* Return code */
        CSYS15DI pCSYS15DInputRec = null;
        CSYS15DO pCSYS15DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCSYS15DInputRec = new CSYS15DI();
        
        pCSYS15DOutputRec = new CSYS15DO();
        pCSYS15DInputRec.setArchInputStruct(pInputMsg774.getArchInputStruct());
        pCSYS15DInputRec.setUlIdStage(pInputMsg774.getUlIdStage());
        rc = csys15dQUERYdam(sqlca, pCSYS15DInputRec, pCSYS15DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg719.getROWCINV56SOG02().setDtDtLicngInvstDtlBegun(pCSYS15DOutputRec.getDtDTContactOccurred());
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT40D(CINV56SI pInputMsg775, CINV56SO pOutputMsg720, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        
        pCINT40DInputRec.setArchInputStruct(pInputMsg775.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(pInputMsg775.getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg720.getROWCINV56SOG03().setUlIdStage(pCINT40DOutputRec.getUlIdStage());
                pOutputMsg720.getROWCINV56SOG03().setUlIdUnit(pCINT40DOutputRec.getUlIdUnit());
                pOutputMsg720.getROWCINV56SOG03().setBIndStageClose(pCINT40DOutputRec.getBIndStageClose());
                pOutputMsg720.getROWCINV56SOG03().setSzNmStage(pCINT40DOutputRec.getSzNmStage());
                pOutputMsg720.getROWCINV56SOG03().setSzCdStage(pCINT40DOutputRec.getSzCdStage());
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageClassification(pCINT40DOutputRec.getSzCdStageClassification());
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageCnty(pCINT40DOutputRec.getSzCdStageCnty());
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageCurrPriority(pCINT40DOutputRec.getSzCdStageCurrPriority());
                
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageInitialPriority(pCINT40DOutputRec.getSzCdStageInitialPriority());
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageProgram(pCINT40DOutputRec.getSzCdStageProgram());
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageReasonClosed(pCINT40DOutputRec.getSzCdStageReasonClosed());
                pOutputMsg720.getROWCINV56SOG03().setDtDtStageClose(pCINT40DOutputRec.getDtDtStageClose());
                pOutputMsg720.getROWCINV56SOG03().setDtDtStageStart(pCINT40DOutputRec.getDtDtStageStart());
                pOutputMsg720.getROWCINV56SOG03().setUlIdCase(pCINT40DOutputRec.getUlIdCase());
                pOutputMsg720.getROWCINV56SOG03().setUlIdSituation(pCINT40DOutputRec.getUlIdSituation());
                pOutputMsg720.getROWCINV56SOG03().setSzTxtStageClosureCmnts(pCINT40DOutputRec.getSzTxtStageClosureCmnts());
                pOutputMsg720.getROWCINV56SOG03().setSzTxtStagePriorityCmnts(pCINT40DOutputRec.getSzTxtStagePriorityCmnts());
                
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageRegion(pCINT40DOutputRec.getSzCdStageRegion());
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageRsnPriorityChgd(pCINT40DOutputRec.getSzCdStageRsnPriorityChgd());
                pOutputMsg720.getROWCINV56SOG03().setSzCdStageType(pCINT40DOutputRec.getSzCdStageType());
                pOutputMsg720.getROWCINV56SOG03().setTmSysTmStageStart(pCINT40DOutputRec.getTmSysTmStageStart());
                pOutputMsg720.getROWCINV56SOG03().setTmSysTmStageClose(pCINT40DOutputRec.getTmSysTmStageClose());
                pOutputMsg720.getROWCINV56SOG03().setTsLastUpdate(pCINT40DOutputRec.getTsLastUpdate());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSC84D(CINV56SI pInputMsg776, CINV56SO pOutputMsg721, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CLSC84DI pCLSC84DInputRec = null;
        CLSC84DO pCLSC84DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC84DInputRec = new CLSC84DI();
        
        pCLSC84DOutputRec = new CLSC84DO();
        pCLSC84DInputRec.setUlIdStage(pOutputMsg721.getROWCINV56SOG03().getUlIdStage());
        pCLSC84DInputRec.setArchInputStruct(pInputMsg776.getArchInputStruct());
        rc = clsc84dQUERYdam(sqlca, pCLSC84DInputRec, pCLSC84DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg721.getROWCINV56SOG02().setDtDtLicngInvstIntake(pCLSC84DOutputRec.getDtDtIncomingCall());
                pOutputMsg721.getROWCINV56SOG02().setUlIdPriorStage(pCLSC84DOutputRec.getUlIdPriorStage());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINV86D(CINV56SI pInputMsg777, CINV56SO * pOutputMsg722, Pint pulPriorStage, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        
        CINV86DI pCINV86DInputRec = null;
        CINV86DO pCINV86DOutputRec = null;
        
        pCINV86DInputRec = new CINV86DI();
        
        pCINV86DOutputRec = new CINV86DO();
        pCINV86DInputRec.setArchInputStruct(pInputMsg777.getArchInputStruct());
        pCINV86DInputRec.setUlIdStage(pInputMsg777.getUlIdStage());
        rc = cinv86dQUERYdam(sqlca, pCINV86DInputRec, pCINV86DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pulPriorStage.value = pCINV86DOutputRec.getUlIdPriorStage();
        }
        return rc;
    }

    static int CallCINT09D(CINV56SI pInputMsg778, CINV56SO pOutputMsg723, int ulPriorStage, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT09DI pCINT09DInputRec = null;
        CINT09DO pCINT09DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT09DInputRec = new CINT09DI();
        
        pCINT09DOutputRec = new CINT09DO();
        pCINT09DInputRec.setArchInputStruct(pInputMsg778.getArchInputStruct());
        pCINT09DInputRec.setUlIdStage(ulPriorStage);
        
        /*
        ** Call CLSS69D
        */
        rc = cint09dQUERYdam(sqlca, pCINT09DInputRec, pCINT09DOutputRec);
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg723.getROWCINV56SOG02().setUlIdResource(pCINT09DOutputRec.getUlIdResource());
            pOutputMsg723.getROWCINV56SOG02().setSzCdRsrcFacilType(pCINT09DOutputRec.getSzCdIncmgFacilType());
            pOutputMsg723.getROWCINV56SOG02().setSzAddrRsrcAddrCity(pCINT09DOutputRec.getSzAddrIncmgFacilCity());
            pOutputMsg723.getROWCINV56SOG02().setSzAddrRsrcAddrStLn1(pCINT09DOutputRec.getSzAddrIncmgFacilStLn1());
            pOutputMsg723.getROWCINV56SOG02().setSzNmResource(pCINT09DOutputRec.getNmIncmgFacilName());
            pOutputMsg723.getROWCINV56SOG02().setSzAddrRsrcAddrStLn2(pCINT09DOutputRec.getSzAddrIncmgFacilStLn2());
            pOutputMsg723.getROWCINV56SOG02().setSzAddrRsrcAddrCounty(pCINT09DOutputRec.getSzCdIncmgFacilCnty());
            pOutputMsg723.getROWCINV56SOG02().setSzAddrRsrcAddrState(pCINT09DOutputRec.getSzCdIncmgFacilState());
            pOutputMsg723.getROWCINV56SOG02().setSzAddrRsrcAddrZip(pCINT09DOutputRec.getSzAddrIncmgFacilZip());
            pOutputMsg723.getROWCINV56SOG02().setLNbrFacilPhoneNumber(pCINT09DOutputRec.getSzNbrIncmgFacilPhone());
            pOutputMsg723.getROWCINV56SOG02().setLNbrFacilPhoneExtension(pCINT09DOutputRec.getSzNbrIncmgFacilPhoneExt());
            pOutputMsg723.getROWCINV56SOG02().setSzNmAffilResource(pCINT09DOutputRec.getSzNmIncmgFacilAffiliated());
        }
        
        return rc;
    }

}
