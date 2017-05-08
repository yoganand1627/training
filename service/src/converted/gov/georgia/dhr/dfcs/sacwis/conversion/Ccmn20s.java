package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20SO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC68DO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSCB7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSCB7DO;
/**************************************************************************
**
** Module File:   CCMN20S.src
**
** Service Name:  CCMN20S - RETRIEVE CASE LIST
**
** Description:   Retrieves all the cases for CCMN71W - Case List
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/1/95
**
** Programmer:    RMR
** Archive Information: $Revision:   1.2  $
**                      $Date:   03 Jul 1998 11:15:32  $
**                      $Modtime:   02 Jul 1998 16:27:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  08/31/95    KRD     Modified due to data element name change of
**                      szAddrOfficeCity to szAddrMailCodeCity.  Required
**                      change to CallCCMN13D().
**
**  02/20/96  CRYSTAEP  SIR #2141: The Case List window now contains a column
**                      which indicates whether or not a case has been
**                      merged.  This requires the use of DAM
**                      CLSC68D to retrieve a full row using ID CASE
**                      MERGE.  If ID CASE exists in the ID CASE MERGE TO
**                      column on the Case Merge Table, a checkmark will
**                      will be placed in the second column of the listbox
**                      on the Case List window.
**
**  04/18/96  YANTISTK  SIR 20359: The Merge column will only be checked
**                      if any of the rows returned from the Case Merge
**                      table for the case are not pending a merge or split
**                      and the DateCaseSplit is NULL
**
**   20Apr96  sladewmf  SIR 20159:  Added an if around the call to UnitAccess
**
**  10/15/96  overentr  SIR 22296 - Added a true statement to a for loop
**                      to help stop processing when a condition is met.
**
**  05/28/98  BRADLEA   SIR #11995 - MHMR Phase III Item 12.1 - This service
**                      will be modified to create a new local variable to
**                      hold the case name with the "et al" extension.It will
**                      be added to the DAM function call (CallCCMN13D) that
**                      calls the dynamic search for cases. This variable
**                      will only be populated when the program is 'AFC' or
**                      the program is blank. The same logic that is used to
**                      save a case name with the "et al" extension in the
**                      Change Case Name window will be used in the DAM func-
**                      tion call to populate the new local variable.
**  04/24/01  GRIMSHAN  SIR 15047 - Code modifications will be made to the
**                      retrieve case list service to allow a user to search
**                      on a case id closed in a case merge.  A new DAM is being
**                      added to determine this.  If the case id was closed
**                      in a case merge, then the DAM will populate the input
**                      message case id with the merged case id.  This means
**                      the service will retrieve the merged case information
**                      to populate the case list window directly
** 01/13/2003 DWW       Changed INDICATOR_NO to FALSE on line 926,
**                      changed TRUE to INDICATOR_YES on line 936 and changed FALSE
**                      to INDICATOR_NO on line 947
**
**  07/07/2003  KRD     SIR 18300 - Need to handle message
**                      MSG_TOO_MANY_ROWS_RETURNED.  Required a change to
**                      CallCCMN13D() and the main service function.
** 09/22/2004 dejuanr   SIR 23096 - Added dam to search for stages with Overall
**                      Dispositions of UTC or MOV.
**
** 08/08/2005 casdorjm  SIR 22559 - Added sort capabilities to ccmn13d
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn20s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PERSON_TYPE_WORKER = "STF";
    public static final int NM_PERSON_FULL_LEN = 26;
    public static final String CASE_NM_ET_AL = " et al";
    public static final int CASE_NM_ET_AL_LEN = 6;
    public static final String CLASSIFICATION_APS_FAC = "AFC";
    public static final String AFC_PROGRAM = "AFC";
    static int AppendEtAlToName(String szNameToAppend) {
        int sNullPosition = 0;
        String szTempString = new String();
        
        /*
        ** Loop until a NULL is found, indicating the end of the name.
        */
        for (sNullPosition = 0;((sNullPosition < NM_PERSON_FULL_LEN - 1) && (0 != (int) szNameToAppend.charAt(sNullPosition)));sNullPosition++) {
            ;
        }
        if (szNameToAppend.length() < NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN) {
            szNameToAppend += CASE_NM_ET_AL;
        }
        /*
        ** If there is not enough room, truncate the case name to 19 characters
        ** (including the comma). Then append the "et al".
        */
        else {
            szTempString = szNameToAppend;
            szTempString = CStringUtils.setCharAt(szTempString, NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN - 1, null);
            szTempString += CASE_NM_ET_AL;
            szNameToAppend = (char) szTempString;
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static CCMN20SI pInputMsg252 = null;
    CCMN20SO CCMN20S(CCMN20SI ccmn20si) {
        CCMN20SO ccmn20so = new CCMN20SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(ccmn20si.getArchInputStruct());
        if (0 != ccmn20si.getUlIdCase().value) {
            
            //  Call DAM
            rc = CallCMSC56D(ccmn20si, ccmn20so, ccmn20si.getUlIdCase() , pServiceStatus);
        }
        
        
        rc = CallCCMN13D(ccmn20si, ccmn20so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                rc = CallCLSCB7D(ccmn20si, ccmn20so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_NO_ROWS_RETURNED:
                        break;
                    case Messages.MSG_TOO_MANY_ROWS_RETURNED:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
            case Messages.MSG_TOO_MANY_ROWS_RETURNED:
                
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
        ARC_PRFServiceStopTime_TUX(ccmn20si.getArchInputStruct() , ccmn20so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            //  Populate DAM Input Structure
            // Set CCMN01UI cReqFuncCd to CFAD40SI cReqFuncCd
            // Set fields in CCMN01UI CCMN01UIGOO to CFAD40SI CCMN01UIGOO
            
            //  If IdEvent = 0 set reqfunccd to ADD else set it to update
            
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
        
        
        return ccmn20so;
    }

    static int CallCCMN13D(CCMN20SI pInputMsg252, CCMN20SO pOutputMsg233, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i144 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN13DI pCCMN13DInputRec = null;
        CCMN13DO pCCMN13DOutputRec = null;
        CCMN04UI pInput = null;
        CCMN04UO pOutput = null;
        CLSC68DI CLSC68DInputMsg = null;/* SIR #2141 Send info to CASE_MERGE  */
        CLSC68DO CLSC68DOutputMsg = null;/* SIR #2141 Get info from CASE_MERGE */
        int uCntSvc = 0;/* loop counter */
        int uCntFnc = 0;/* loop counter */
        Pchar cScrIndStageMerged1 = new Pchar();
        
        
        /*
        ** MHMR Phase III Item 12.1 (BRADLEA)
        */
        String szTempCaseName = new String();
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN13DInputRec = new CCMN13DI();
        pCCMN13DOutputRec = new CCMN13DO();
        
        /*
        ** Allocate memory for Unit Access Input and Output Structures
        */
        pInput = new CCMN04UI();
        pOutput = new CCMN04UO();
        pCCMN13DInputRec.setUlIdCase(pInputMsg252.getUlIdCase().value);
        pCCMN13DInputRec.setUlIdPerson(pInputMsg252.getUlIdPerson_ARRAY().getUlIdPerson(0));
        pCCMN13DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
        pCCMN13DInputRec.setSzScrCdStagePersRole(PRIMARY_ROLE_STAGE_CLOSED);
        pCCMN13DInputRec.setSzCdStagePersType(PERSON_TYPE_WORKER);
        pCCMN13DInputRec.setSzCdCaseCounty(pInputMsg252.getSzCdCaseCounty());
        pCCMN13DInputRec.setSzCdCaseProgram(pInputMsg252.getSzCdCaseProgram());
        pCCMN13DInputRec.setSzCdCaseRegion(pInputMsg252.getSzCdCaseRegion());
        pCCMN13DInputRec.setSzNmCase(pInputMsg252.getSzNmCase());
        pCCMN13DInputRec.setSzAddrMailCodeCity(pInputMsg252.getSzAddrMailCodeCity());
        
        pCCMN13DInputRec.setBWcdCdSortBy(pInputMsg252.getBWcdCdSortBy());
        
        if ((0 != pCCMN13DInputRec.getSzNmCase().compareTo(0)) && ((pCCMN13DInputRec.getSzCdCaseProgram()[0] == null) || (0 == AFC_PROGRAM.compareTo(pCCMN13DInputRec.getSzCdCaseProgram())))) {
            szTempCaseName = pCCMN13DInputRec.getSzNmCase();
            rc = Ccmn85s.AppendEtAlToName(szTempCaseName);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            pCCMN13DInputRec.setSzNmCaseAppend(szTempCaseName);
        }
        pCCMN13DInputRec.setArchInputStruct(pInputMsg252.getArchInputStruct());
        rc = ccmn13dQUERYdam(sqlca, pCCMN13DInputRec, pCCMN13DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i144 = 0;i144 < pCCMN13DOutputRec.getArchOutputStruct().getUlRowQty();++i144) {
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setUlIdCase(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getUlIdCase());
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setUlIdPerson(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getUlIdPerson());
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setBIndCaseSensitive(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getBIndCaseSensitive());
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setUlIdSituation(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getUlIdSituation());
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setDtDtCaseClosed(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getDtDtCaseClosed());
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setSzCdCaseProgram(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getSzCdCaseProgram());
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setSzNmCase(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getSzNmCase());
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setSzScrWorkerPrim(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getSzScrWorkerPrim());
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setSzCdStage(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getSzCdStage());
                    pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setSzCdCaseCounty(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getSzCdCaseCounty());
                    
                    if (0 != pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getUlIdUnit()) {
                        //  Populate service input message with ID PERSON for the user,
                        // ID PERSON for the user's designees,
                        // The input message contains an array of 7 ID PERSONs
                        // ID PERSON[0] = id for person passed in from pinit for search.
                        // ID PERSON[1] = id for user
                        // ID PERSON[2] - ID PERSON[6] = id for designees 1 - 5
                        
                        //  Check the unit hierarchy for this case
                        uCntSvc = 1;
                        uCntFnc = 0;
                        while ((uCntSvc < CCMN20SI._CCMN20SI__ULIDPERSON_SIZE) && (pInputMsg252.getUlIdPerson_ARRAY().getUlIdPerson(uCntSvc) != 0)) {
                            pInput.getUlIdPerson_ARRAY().setUlIdPerson(uCntFnc, pInputMsg252.getUlIdPerson_ARRAY().getUlIdPerson(uCntSvc));
                            uCntSvc++;
                            uCntFnc++;
                        }
                        pInput.setUlIdUnit(pCCMN13DOutputRec.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getUlIdUnit());
                        
                        //  Call CCMN44D
                        rc = Ccmn04u.UnitAccess(pInput, pOutput, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        // sir# 23617. added szCdStageProgram_STRING condition.
                        if (true == pOutput.getBSysIndGeneric()) {
                            pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setBScrIndEmpStageAssign(INDICATOR_YES);
                        }
                        else {
                            pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setBScrIndEmpStageAssign(Cint14s.INDICATOR_NO);
                        }
                    }
                    else {
                        pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setBScrIndEmpStageAssign(Cint14s.INDICATOR_NO);
                    }
                    CLSC68DInputMsg.setUlIdCaseMergeTo(pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).getUlIdCase());
                    
                    //  Call CINV51D
                    rc = CallCLSC68D(pInputMsg252, CLSC68DInputMsg.getUlIdCaseMergeTo() , CLSC68DOutputMsg, cScrIndStageMerged1, pServiceStatus);
                    //  IMPACT BEGIN
                    //  IMPACT END
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            pOutputMsg233.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i144).setCScrIndStageMerged(cScrIndStageMerged1.value);
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                
                if (WtcHelperConstants.ARC_SUCCESS == rc) {
                    pOutputMsg233.getArchOutputStruct().setUlRowQty(pCCMN13DOutputRec.getArchOutputStruct().getUlRowQty());
                    pOutputMsg233.getArchOutputStruct().setBMoreDataInd(pCCMN13DOutputRec.getArchOutputStruct().getBMoreDataInd());
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            case Messages.MSG_TOO_MANY_ROWS_RETURNED:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_TOO_MANY_ROWS_RETURNED;
                
                //  Call CCMN44D
                rc = Messages.MSG_TOO_MANY_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSC68D(CCMN20SI pInputMsg252, int ulIdCaseMergeTo1, CLSC68DO * pCLSC68DOutputMsg, String pcScrIndStageMerged, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usRowCtr = 0;/* Row Counter   */
        int rc = WtcHelperConstants.ARC_SUCCESS;
        int i145 = 0;
        CLSC68DI pCLSC68DInputRec = null;/* input record  */
        CLSC68DO pCLSC68DOutputRec = null;/* output record */
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC68DInputRec = new CLSC68DI();
        
        
        pCLSC68DOutputRec = new CLSC68DO();
        pCLSC68DInputRec.setArchInputStruct(pInputMsg252.getArchInputStruct());
        pCLSC68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSC68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC68DO._CLSC68DO__ROWCLSC68DO_SIZE);
        pCLSC68DInputRec.setUlIdCaseMergeTo(ulIdCaseMergeTo1);
        rc = clsc68dQUERYdam(sqlca, pCLSC68DInputRec, pCLSC68DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                // SIR 20503
                
                //  Added the true statment to the where clause of the for loop
                //  DWW 01/13/2003 - Changed INDICATOR_NO to FALSE on line 926
                // changed TRUE to INDICATOR_YES on line 936 and changed FALSE
                // to INDICATOR_NO on line 947
                for (i145 = 0;((i145 <= pCLSC68DOutputRec.getArchOutputStruct().getUlRowQty()) && (pcScrIndStageMerged.charAt(0) != INDICATOR_YES));i145++) {
                    
                    if ((pCLSC68DOutputRec.getROWCLSC68DO_ARRAY().getROWCLSC68DO(i145).getCIndCaseMergePending() == false) && (pCLSC68DOutputRec.getROWCLSC68DO_ARRAY().getROWCLSC68DO(i145).getDtCaseMergeSplit().day == DateHelper.NULL_DATE && pCLSC68DOutputRec.getROWCLSC68DO_ARRAY().getROWCLSC68DO(i145).getDtCaseMergeSplit().month == DateHelper.NULL_DATE && pCLSC68DOutputRec.getROWCLSC68DO_ARRAY().getROWCLSC68DO(i145).getDtCaseMergeSplit().year == DateHelper.NULL_DATE)) {
                        pcScrIndStageMerged = CStringUtils.setCharAt(pcScrIndStageMerged, 0, INDICATOR_YES);
                    }
                }
                
                break;
            case NO_DATA_FOUND:
                pcScrIndStageMerged = CStringUtils.setCharAt(pcScrIndStageMerged, 0, Cint14s.INDICATOR_NO);
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCMSC56D(CCMN20SI pInputMsg252, CCMN20SO * pOutputMsg234, Pint ulIdCase1, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        **  Declare local variables
        */
        CMSC56DI pCMSC56DInputRec = null;
        CMSC56DO pCMSC56DOutputRec = null;
        
        /*
        **  Allocate memory for Input and Output Structures
        */
        pCMSC56DInputRec = new CMSC56DI();
        
        pCMSC56DOutputRec = new CMSC56DO();
        pCMSC56DInputRec.setArchInputStruct(pInputMsg252.getArchInputStruct());
        pCMSC56DInputRec.setUlIdCase(ulIdCase1.value);
        
        rc = cmsc56dQUERYdam(sqlca, pCMSC56DInputRec, pCMSC56DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg252.getUlIdCase().value = pCMSC56DOutputRec.getUlIdCase();
                break;
                
            case NO_DATA_FOUND:
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSCB7D(CCMN20SI pInputMsg252, CCMN20SO pOutputMsg235, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i146 = 0;
        int j = 0;
        
        /*
        ** Declare local variables
        */
        CLSCB7DI pCLSCB7DInputRec = null;
        CLSCB7DO pCLSCB7DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSCB7DInputRec = new CLSCB7DI();
        pCLSCB7DOutputRec = new CLSCB7DO();
        
        for (i146 = 0;i146 < pOutputMsg235.getArchOutputStruct().getUlRowQty();i146++) {
            pCLSCB7DInputRec.getUlIdCase_ARRAY().setUlIdCase(i146, pOutputMsg235.getROWCCMN13DO_ARRAY().getROWCCMN13DO(i146).getUlIdCase());
            pCLSCB7DOutputRec.getUlIdCase_ARRAY().setUlIdCase(i146, 0);
        }
        pCLSCB7DInputRec.getArchInputStruct().setUlPageSizeNbr(pOutputMsg235.getArchOutputStruct().getUlRowQty());
        pCLSCB7DInputRec.setArchInputStruct(pInputMsg252.getArchInputStruct());
        /*
        ** Retrieve the INITDATA given Event record.
        */
        rc = clscb7dQUERYdam(sqlca, pCLSCB7DInputRec, pCLSCB7DOutputRec);
        
        
        /*
        ** Stop DAM Performance Timer
        */
        //##                    ARC_PRFDataAccessStopTime();
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (j = 0;j < pOutputMsg235.getArchOutputStruct().getUlRowQty();j++) {
                    for (i146 = 0;i146 < pCLSCB7DOutputRec.getArchOutputStruct().getUlRowQty();++i146) {
                        pOutputMsg235.getROWCCMN13DO_ARRAY().getROWCCMN13DO(j).setCScrIndCaseUTC('N');
                        
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                        // 01/22/2003 DWW: Added for error handling
                        if ((pOutputMsg235.getROWCCMN13DO_ARRAY().getROWCCMN13DO(j).getUlIdCase() == pCLSCB7DOutputRec.getUlIdCase_ARRAY().getUlIdCase(i146)) && (pOutputMsg235.getROWCCMN13DO_ARRAY().getROWCCMN13DO(j).getCScrIndCaseUTC() != 'Y')) {
                            pOutputMsg235.getROWCCMN13DO_ARRAY().getROWCCMN13DO(j).setCScrIndCaseUTC('Y');
                            break;
                        }
                    }
                }
                break;
                
            case NO_DATA_FOUND:
                break;
            case Messages.MSG_TOO_MANY_ROWS_RETURNED:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        
        return rc;
    }

}
