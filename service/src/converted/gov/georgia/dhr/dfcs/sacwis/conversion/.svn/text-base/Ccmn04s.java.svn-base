package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN69DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN72DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN72DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN76DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN31DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN31DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS79DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS79DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS80DO;
/***************************************************************************
**
** Module File:   CCMN04S.src
**
** Service Name:  CCMN04S
**
** Description:   Retrieves the Employee information
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/18/95
**
** Programmer:    Karl R. Dalley / Ramani Vishnubhotla
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   06 Nov 2000 11:21:38  $
**                      $Modtime:   24 Oct 2000 12:42:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/25/95    KRD     Corrections prior to Technical Code Review to
**                      clean up code and meet standards
**  06/21/95    KRD     Corrections due to Technical Code Review.
**  10/14/95    KRD     SIR 1265 - Modified CallCCMN69D() due to
**                      szNmEmpEmailAddr not being retrieved and passed
**                      back to the client.  Added an if-statement to the
**                      main service function so that UnitAccess() and DAMs
**                      CCMN39D CCMN41D are not called if the employee is
**                      an inactive employee.
**  01/29/96    JRH     Ethnicity and DOB fields are added to the window
**                      and made enetrable when new until they are
**                      validated by HRMIS at which time they will be
**                      non-modifiable. SIR 2091
**
**
**
**  10/13/2000  CMM     Needed to add calls to new Dams created to retrieve
**                      from the Person_Race adn Person_Ethnicity tables
**
**  04/18/2001  SLC     SECURITY UPGRADE
**                      Modified the call to ccmn69d.pc that retrieves
**                      employee information from the EMPLOYEE table.  This
**                      change is necessary because the value of
**                      CD_EMP_SECURITY_CLASS_NM will be nulified.
**                      Specifically, modified the code that populates the
**                      output message for the DAM.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn04s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String UNIT_MEMBER_IN_ASSIGNED = "IN";
    
    public static final String PERSON_ID_TYPE_SSN = "SSN";
    public static final char PERSON_ID_NOT_INVALID = 'N';
    CCMN04SO CCMN04S(CCMN04SI ccmn04si) {
        CCMN04SO ccmn04so = new CCMN04SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int /* loop variable */
        uCount = 0;
        int uTrueCnt = 0;
        CCMN04UI pInput = null;
        CCMN04UO pOutput = null;
        rc = ARC_PRFServiceStartTime_TUX(ccmn04si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccmn04so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Ccmn02u.CallCCMN69D(ccmn04si, ccmn04so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Cinv04s.CallCCMN40D(ccmn04si, ccmn04so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Ccmn03u.CallCCMN44D(ccmn04si, ccmn04so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Call CINT20D
        */
        rc = CallCCMN72D(ccmn04si, ccmn04so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCCMN76D(ccmn04si, ccmn04so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCCMN31D(ccmn04si, ccmn04so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Call CRES13D
        */
        rc = Ccmn95s.CallCLSS79D(ccmn04si, ccmn04so, pServiceStatus);
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccmn95s.CallCLSS80D(ccmn04si, ccmn04so, pServiceStatus);
        /**************************************************************************
        ** (END): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        /*
        ** Invalidate the current approval event and set the current event
        ** status to COMP if home is closed or pending closure and the current
        ** event timestamp is not NULL
        /*
        ** SIR #3267 - 2/25/96 - PURCELA - Changed the check to be on what the
        ** current event status is.  Enter the if Statement is the Event Status
        ** is PEND.  If the commented out if Statement below were used, PROC
        ** events would be caught.
        ** if(NULL_CHARACTER != pInputMsg->ROWCCMN01UIG00[CURRENT].tsLastUpdate[0])
        */
        
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        ccmn04so.getROWCCMN04SOG04().setSzSysCdWinMode(WINDOW_MODE_INQUIRE);
        if (INDICATOR_YES == ccmn04so.getROWCCMN04SOG00().getBIndActiveStatus()) {
            rc = CallCCMN39D(ccmn04si, ccmn04so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            //  Call CCMN39D
            rc = CallCCMN41D(ccmn04si, ccmn04so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            //  Determine whether or not a user has access to a unit in inquiry
            // or modify mode by calling the UnitAccess() common function
            
            //  Allocate memory for Unit Access Input and Output Structures
            pInput = new CCMN04UI();
            
            pOutput = new CCMN04UO();
            pInput.setUlIdUnit(ccmn04so.getROWCCMN04SOG04().getUlIdUnit());
            
            //  Check for unit access
            uCount = 1;
            while ((uCount < CCMN04SI._CCMN04SI__ULIDPERSON_SIZE) && (ccmn04si.getUlIdPerson_ARRAY().getUlIdPerson(uCount) != 0)) {
                pInput.getUlIdPerson_ARRAY().setUlIdPerson(uTrueCnt, ccmn04si.getUlIdPerson_ARRAY().getUlIdPerson(uCount));
                uCount++;
                uTrueCnt++;
            }
            rc = Ccmn04u.UnitAccess(pInput, pOutput, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (pOutput.getBSysIndGeneric() == true) {
                ccmn04so.getROWCCMN04SOG04().setSzSysCdWinMode(WINDOW_MODE_MODIFY);
            }
        }
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn04si.getArchInputStruct() , ccmn04so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  IMPACT BEGIN - Leave event status in PEND, if in "Approver mode"
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
        return ccmn04so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = "CCMN04SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCCMN69D(CCMN04SI pInputMsg167, CCMN04SO pOutputMsg148, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN69DI pCCMN69DInputRec = null;
        CCMN69DO pCCMN69DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN69DInputRec = new CCMN69DI();
        
        pCCMN69DOutputRec = new CCMN69DO();
        pCCMN69DInputRec.setUlIdPerson(pInputMsg167.getUlIdPerson_ARRAY().getUlIdPerson(0));
        pCCMN69DInputRec.setArchInputStruct(pInputMsg167.getArchInputStruct());
        
        rc = ccmn69dQUERYdam(sqlca, pCCMN69DInputRec, pCCMN69DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg148.getROWCCMN04SOG00().setUlIdPerson(pCCMN69DOutputRec.getUlIdPerson());
                pOutputMsg148.getROWCCMN04SOG00().setSzCdEmpProgram(pCCMN69DOutputRec.getSzCdEmpProgram());
                pOutputMsg148.getROWCCMN04SOG00().setSzIdEmployeeLogon(pCCMN69DOutputRec.getSzIdEmployeeLogon());
                pOutputMsg148.getROWCCMN04SOG00().setDtDtEmpHire(pCCMN69DOutputRec.getDtDtEmpHire());
                pOutputMsg148.getROWCCMN04SOG00().setDtDtEmpLastAssigned(pCCMN69DOutputRec.getDtDtEmpLastAssigned());
                pOutputMsg148.getROWCCMN04SOG00().setDtDtEmpTermination(pCCMN69DOutputRec.getDtDtEmpTermination());
                pOutputMsg148.getROWCCMN04SOG00().setUlIdOffice(pCCMN69DOutputRec.getUlIdOffice());
                pOutputMsg148.getROWCCMN04SOG00().setUlIdEmpJobHistory(pCCMN69DOutputRec.getUlIdEmpJobHistory());
                pOutputMsg148.getROWCCMN04SOG00().setBIndActiveStatus(pCCMN69DOutputRec.getBIndActiveStatus());
                pOutputMsg148.getROWCCMN04SOG00().setBIndEmpConfirmedHrmis(pCCMN69DOutputRec.getBIndEmpConfirmedHrmis());
                pOutputMsg148.getROWCCMN04SOG00().setBIndEmpPendingHrmis(pCCMN69DOutputRec.getBIndEmpPendingHrmis());
                pOutputMsg148.getROWCCMN04SOG00().setLNbrEmpActivePct(pCCMN69DOutputRec.getLNbrEmpActivePct());
                pOutputMsg148.getROWCCMN04SOG00().setTsLastUpdate(pCCMN69DOutputRec.getTsLastUpdate());
                pOutputMsg148.getROWCCMN04SOG00().setSzCdEmployeeClass(pCCMN69DOutputRec.getSzCdEmployeeClass());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                
                break;
        }
        return rc;
    }

    static int CallCCMN39D(CCMN04SI pInputMsg168, CCMN04SO pOutputMsg149, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN39DI pCCMN39DInputRec = null;
        CCMN39DO pCCMN39DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN39DInputRec = new CCMN39DI();
        
        pCCMN39DOutputRec = new CCMN39DO();
        pCCMN39DInputRec.setUlIdPerson(pInputMsg168.getUlIdPerson_ARRAY().getUlIdPerson(0));
        pCCMN39DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_IN_ASSIGNED);
        pCCMN39DInputRec.setArchInputStruct(pInputMsg168.getArchInputStruct());
        rc = ccmn39dQUERYdam(sqlca, pCCMN39DInputRec, pCCMN39DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg149.getROWCCMN04SOG04().setSzCdUnitMemberInOut(pCCMN39DOutputRec.getSzCdUnitMemberInOut());
                pOutputMsg149.getROWCCMN04SOG04().setSzCdUnitMemberRole(pCCMN39DOutputRec.getSzCdUnitMemberRole());
                pOutputMsg149.getROWCCMN04SOG04().setSzCdUnitProgram(pCCMN39DOutputRec.getSzCdUnitProgram());
                pOutputMsg149.getROWCCMN04SOG04().setSzCdUnitRegion(pCCMN39DOutputRec.getSzCdUnitRegion());
                pOutputMsg149.getROWCCMN04SOG04().setUlIdUnit(pCCMN39DOutputRec.getUlIdUnit());
                pOutputMsg149.getROWCCMN04SOG04().setUlIdUnitEmpLink(pCCMN39DOutputRec.getUlIdUnitEmpLink());
                pOutputMsg149.getROWCCMN04SOG04().setSzNbrUnit(pCCMN39DOutputRec.getSzNbrUnit());
                pOutputMsg149.getROWCCMN04SOG04().setUlIdPerson(pCCMN39DOutputRec.getUlIdPerson());
                pOutputMsg149.getROWCCMN04SOG04().setSzNmPersonFull(pCCMN39DOutputRec.getSzNmPersonFull());
                pOutputMsg149.getROWCCMN04SOG04().setTsLastUpdate(pCCMN39DOutputRec.getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN40D(CCMN04SI pInputMsg169, CCMN04SO pOutputMsg150, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN40DI pCCMN40DInputRec = null;
        CCMN40DO pCCMN40DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN40DInputRec = new CCMN40DI();
        
        pCCMN40DOutputRec = new CCMN40DO();
        pCCMN40DInputRec.setUlIdPerson(pInputMsg169.getUlIdPerson_ARRAY().getUlIdPerson(0));
        pCCMN40DInputRec.setArchInputStruct(pInputMsg169.getArchInputStruct());
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Start performance timer for service
        */
        rc = ccmn40dQUERYdam(sqlca, pCCMN40DInputRec, pCCMN40DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg150.getROWCCMN04SOG01().setUlIdPerson(pCCMN40DOutputRec.getROWCCMN40DO().getUlIdPerson());
                pOutputMsg150.getROWCCMN04SOG01().setSzCdNameSuffix(pCCMN40DOutputRec.getROWCCMN40DO().getSzCdNameSuffix());
                pOutputMsg150.getROWCCMN04SOG01().setDtDtNameEndDate(pCCMN40DOutputRec.getROWCCMN40DO().getDtDtNameEndDate());
                pOutputMsg150.getROWCCMN04SOG01().setDtDtNameStartDate(pCCMN40DOutputRec.getROWCCMN40DO().getDtDtNameStartDate());
                pOutputMsg150.getROWCCMN04SOG01().setUlIdName(pCCMN40DOutputRec.getROWCCMN40DO().getUlIdName());
                pOutputMsg150.getROWCCMN04SOG01().setBIndNameInvalid(pCCMN40DOutputRec.getROWCCMN40DO().getBIndNameInvalid());
                pOutputMsg150.getROWCCMN04SOG01().setBIndNamePrimary(pCCMN40DOutputRec.getROWCCMN40DO().getBIndNamePrimary());
                pOutputMsg150.getROWCCMN04SOG01().setSzNmNameFirst(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameFirst());
                pOutputMsg150.getROWCCMN04SOG01().setSzNmNameLast(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameLast());
                pOutputMsg150.getROWCCMN04SOG01().setSzNmNameMiddle(pCCMN40DOutputRec.getROWCCMN40DO().getSzNmNameMiddle());
                
                pOutputMsg150.getROWCCMN04SOG01().setTsLastUpdate(pCCMN40DOutputRec.getROWCCMN40DO().getTsLastUpdate());
                
                //  Run-time versioning
                
                //  Check buffer size
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                //  Initialize service status fields
                
                // 
                // Call DAMs to retrieve data
                // 
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                // There are no acceptible errors for this service.
                // This switch statement, which does nothing but "default",
                // will be left so that it will be easy to add additional
                // error handling later.
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN41D(CCMN04SI pInputMsg170, CCMN04SO pOutputMsg151, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        * Declare local variables
        */
        CCMN41DI pCCMN41DInputRec = null;
        CCMN41DO pCCMN41DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN41DInputRec = new CCMN41DI();
        
        pCCMN41DOutputRec = new CCMN41DO();
        pCCMN41DInputRec.setUlIdOffice(pOutputMsg151.getROWCCMN04SOG00().getUlIdOffice());
        pCCMN41DInputRec.setArchInputStruct(pInputMsg170.getArchInputStruct());
        rc = ccmn41dQUERYdam(sqlca, pCCMN41DInputRec, pCCMN41DOutputRec);
        switch (rc) {
                
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg151.setSzAddrMailCode(pCCMN41DOutputRec.getSzAddrMailCode());
                pOutputMsg151.setSzNmOfficeName(pCCMN41DOutputRec.getSzNmOfficeName());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        
        return rc;
    }

    static int CallCCMN44D(CCMN04SI pInputMsg171, CCMN04SO pOutputMsg152, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN44DInputRec = new CCMN44DI();
        
        pCCMN44DOutputRec = new CCMN44DO();
        pCCMN44DInputRec.setUlIdPerson(pInputMsg171.getUlIdPerson_ARRAY().getUlIdPerson(0));
        pCCMN44DInputRec.setArchInputStruct(pInputMsg171.getArchInputStruct());
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg152.getROWCCMN04SOG06().setCCdPersonSex(pCCMN44DOutputRec.getCCdPersonSex());
                pOutputMsg152.getROWCCMN04SOG06().setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                pOutputMsg152.getROWCCMN04SOG06().setTsLastUpdate(pCCMN44DOutputRec.getTsLastUpdate());
                pOutputMsg152.getROWCCMN04SOG06().setSzCdPersonEthnicGroup(pCCMN44DOutputRec.getSzCdPersonEthnicGroup());
                pOutputMsg152.getROWCCMN04SOG06().setDtDtPersonBirth(pCCMN44DOutputRec.getDtDtPersonBirth());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMN72D(CCMN04SI pInputMsg172, CCMN04SO pOutputMsg153, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN72DI pCCMN72DInputRec = null;
        CCMN72DO pCCMN72DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN72DInputRec = new CCMN72DI();
        
        pCCMN72DOutputRec = new CCMN72DO();
        pCCMN72DInputRec.setUlIdPerson(pInputMsg172.getUlIdPerson_ARRAY().getUlIdPerson(0));
        pCCMN72DInputRec.setSzCdPersonIdType(PERSON_ID_TYPE_SSN);
        pCCMN72DInputRec.setBIndPersonIDInvalid(PERSON_ID_NOT_INVALID);
        pCCMN72DInputRec.getTsTsGenericDate_ARRAY().setTsTsGenericDate(0, 147);
        ;
        pCCMN72DInputRec.setArchInputStruct(pInputMsg172.getArchInputStruct());
        rc = ccmn72dQUERYdam(sqlca, pCCMN72DInputRec, pCCMN72DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg153.getROWCCMN04SOG05().setUlIdPerson(pCCMN72DOutputRec.getUlIdPerson());
                pOutputMsg153.getROWCCMN04SOG05().setSzCdPersonIdType(pCCMN72DOutputRec.getSzCdPersonIdType());
                pOutputMsg153.getROWCCMN04SOG05().setUlIdPersonId(pCCMN72DOutputRec.getUlIdPersonId());
                pOutputMsg153.getROWCCMN04SOG05().setSzNbrPersonIdNumber(pCCMN72DOutputRec.getSzNbrPersonIdNumber());
                pOutputMsg153.getROWCCMN04SOG05().setTsLastUpdate(pCCMN72DOutputRec.getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN76D(CCMN04SI pInputMsg173, CCMN04SO pOutputMsg154, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i107 = 0;
        
        
        /*
        ** Declare local variables
        */
        CCMN76DI pCCMN76DInputRec = null;
        CCMN76DO pCCMN76DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN76DInputRec = new CCMN76DI();
        
        pCCMN76DOutputRec = new CCMN76DO();
        pCCMN76DInputRec.setUlIdPerson(pInputMsg173.getUlIdPerson_ARRAY().getUlIdPerson(0));
        
        pCCMN76DInputRec.setArchInputStruct(pInputMsg173.getArchInputStruct());
        rc = ccmn76dQUERYdam(sqlca, pCCMN76DInputRec, pCCMN76DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i107 = 0;i107 < pCCMN76DOutputRec.getArchOutputStruct().getUlRowQty();++i107) {
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setUlIdPerson(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getUlIdPerson());
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setSzBjnJob(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getSzBjnJob());
                    
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setSzCdJobClass(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getSzCdJobClass());
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setSzCdJobFunction(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getSzCdJobFunction());
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setDtDtJobEnd(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getDtDtJobEnd());
                    
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setDtDtJobStart(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getDtDtJobStart());
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setUlIdEmpJobHistory(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getUlIdEmpJobHistory());
                    
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setUlIdJobPersSupv(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getUlIdJobPersSupv());
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setSzNmPersonFull(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getSzNmPersonFull());
                    
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setBIndJobAssignable(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getBIndJobAssignable());
                    pOutputMsg154.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(i107).setTsLastUpdate(pCCMN76DOutputRec.getROWCCMN76DO_ARRAY().getROWCCMN76DO(i107).getTsLastUpdate());
                }
                
                pOutputMsg154.getUlRowQty_ARRAY().setUlRowQty(2, pCCMN76DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN31D(CCMN04SI pInputMsg174, CCMN04SO pOutputMsg155, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i108 = 0;
        
        
        /*
        ** Declare local variables
        */
        CCMN31DI pCCMN31DInputRec = null;
        CCMN31DO pCCMN31DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN31DInputRec = new CCMN31DI();
        
        pCCMN31DOutputRec = new CCMN31DO();
        pCCMN31DInputRec.setUlIdPerson(pInputMsg174.getUlIdPerson_ARRAY().getUlIdPerson(0));
        pCCMN31DInputRec.setArchInputStruct(pInputMsg174.getArchInputStruct());
        rc = ccmn31dQUERYdam(sqlca, pCCMN31DInputRec, pCCMN31DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i108 = 0;i108 < pCCMN31DOutputRec.getArchOutputStruct().getUlRowQty();++i108) {
                    pOutputMsg155.getROWCCMN04SOG03_ARRAY().getROWCCMN04SOG03(i108).setSzCdEmpSkill(pCCMN31DOutputRec.getSzCdEmpSkill_ARRAY().getSzCdEmpSkill(i108));
                }
                pOutputMsg155.getUlRowQty_ARRAY().setUlRowQty(3, pCCMN31DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCLSS79D(CCMN04SI pInputMsg175, CCMN04SO pOutputMsg156, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i109 = 0;
        
        CLSS79DI pCLSS79DInputRec = null;
        CLSS79DO pCLSS79DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS79DInputRec = new CLSS79DI();
        
        pCLSS79DOutputRec = new CLSS79DO();
        pCLSS79DInputRec.setArchInputStruct(pInputMsg175.getArchInputStruct());
        
        pCLSS79DInputRec.setUlIdPerson(pInputMsg175.getUlIdPerson_ARRAY().getUlIdPerson(0));
        
        /*
        ** Call CAUD20D.  The Contract Period ELB DAM receives IdContract and 
        ** performs an AUD on the indicated row.
        ** Delete:  a stored procedure is called to perform a cascade delete
        **          for Contract Version, Contract Service and Contract County.
        ** Add:     Performs a full row insert into Contract Period Table
        ** Modify:  Performs a full row update into Contract Period Table.  
        */
        rc = clss79dQUERYdam(sqlca, pCLSS79DInputRec, pCLSS79DOutputRec);
        
        if (rc != 0) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg156.getArchOutputStruct().setUlRowQty(0);
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            
            for (i109 = 0;i109 < pCLSS79DOutputRec.getArchOutputStruct().getUlRowQty();++i109) {
                pOutputMsg156.getCCMN04SOG07_ARRAY().getCCMN04SOG07(i109).setSzCdPersonRace(pCLSS79DOutputRec.getROWCLSS79DO_ARRAY().getROWCLSS79DO(i109).getSzCdPersonRace());
            }
            pOutputMsg156.getUlRowQty_ARRAY().setUlRowQty(0, pCLSS79DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg156.getArchOutputStruct().setBMoreDataInd(pCLSS79DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCLSS80D(CCMN04SI pInputMsg176, CCMN04SO pOutputMsg157, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i110 = 0;
        
        CLSS80DI pCLSS80DInputRec = null;
        CLSS80DO pCLSS80DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS80DInputRec = new CLSS80DI();
        
        pCLSS80DOutputRec = new CLSS80DO();
        pCLSS80DInputRec.setArchInputStruct(pInputMsg176.getArchInputStruct());
        pCLSS80DInputRec.setUlIdPerson(pInputMsg176.getUlIdPerson_ARRAY().getUlIdPerson(0));
        rc = clss80dQUERYdam(sqlca, pCLSS80DInputRec, pCLSS80DOutputRec);
        
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg157.getArchOutputStruct().setUlRowQty(0);
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            
            for (i110 = 0;i110 < pCLSS80DOutputRec.getArchOutputStruct().getUlRowQty();++i110) {
                pOutputMsg157.getCCMN04SOG08_ARRAY().getCCMN04SOG08(i110).setSzCdPersonEthnicity(pCLSS80DOutputRec.getROWCLSS80DO_ARRAY().getROWCLSS80DO(i110).getSzCdPersonEthnicity());
            }
            pOutputMsg157.getUlRowQty_ARRAY().setUlRowQty(1, pCLSS80DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg157.getArchOutputStruct().setBMoreDataInd(pCLSS80DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

}
