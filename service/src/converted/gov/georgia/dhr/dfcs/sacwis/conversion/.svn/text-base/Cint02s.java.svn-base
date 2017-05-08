package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn44s;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn31s;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.service.person.Cinv05s;
import gov.georgia.dhr.dfcs.sacwis.service.person.Cint23s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD5DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT78DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT78DO;
/**************************************************************************
**
** Module File:   CINT02S.src
**
** Service Name:  CINT02S
**
** Description:   Call Person List AUD from OK click
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/1/95
**
** Programmer:    MJH
**
** Archive Information: $Revision:   1.10  $
**                      $Date:   28 Nov 2000 14:41:44  $
**                      $Modtime:   28 Nov 2000 10:50:44  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/05/95  GUGLIEBS  Added initialization of DAM copybooks-Fixes
**                      garbage insertion/update problem for stage person
**                      link.
**
**  06/21/95  GUGLIEBS  Miscalculated output message size.  Previous
**                      msg size calculation was:
**                      sizeof(ARCHOUTPUTSTRUCT)+sizeof(_PERSLISTAUDOUTREC)
**                      Removed the ARCHOUTPUTSTRUCT since this is
**                      included in PERSLISTAUDOUTREC.
**
**  11/21/95  ELLIOTSL  ERR #2079: A C-name has been changed.  This required
**                      doing a global seach and replace.
**                      PersListAUDKeysStruct -> PLAUDKeys
**
**  11/28/95  ELLIOTSL  ERR #233: bIndPersCancelHist indicator added.
**
**  01/04/95  LASKEYRM  SIR #2212, #2222: "if ( SQL_SUCCESS == 0 )" was
**                      being used in error handling code after an
**                      update DAM was called. This was changed to
**                      "if ( SQL_SUCCESS == rc )."
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
**  03/12/97   KRD      SIR 10348 - To ensure that the timestamps on the
**                      start and end dates for names, addresses and phones
**                      are set properly, we need to process the changes in
**                      reverse order.  Required changes to the loop
**                      processing in CallCINV32D(), CallCCMNA9D() and
**                      CallCCMN95D().
**  07/08/98  SOHNJJ    SIR 14422 (MHMR ITEM #1): This enhancement allows
**                      intake to record multiple reporters.  A new
**                      column, CD_STAGE_PERS_LST_SORT was added to the
**                      STAGE_PERSON_LINK table to store a code that is
**                      used to identify and sort a person in the Person
**                      List window listbox.  A person can be a "CALLER_SORT",
**                      "REPORTER_SORT", or an "OTHER_SORT".  Each intake
**                      has only one caller, but may have multiple people
**                      categorized as reporters or others.  The caller will
**                      always appear shaded in the first row of the listbox.
**                      All reporters will appear below the caller row and
**                      above the other rows.  In the Person Detail window,
**                      the reporter checkbox will always be enabled and
**                      can be selected or deselected except for the person
**                      in the caller row.
**
** 10/17/00 SMITHAL     SIR 15512 Added calls to CAUDD4D to delete a row
**                      from the person_race table and a call to CAUDD4D
**                      to add or update a row from the person_ethnicity
**                      table.
**
** 02/12/03 WEBSTED     got rid of marshalling for PLAUD KEYS, because
**                      they are not used by IMPACT
**
** 05/13/03  Srini      SIR 17476 - Added the LAUNCHED('L') option.
**
**  08/04/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
** 03/03/05  ochumd     SIR 23427 - Added Dam CINT78D.pc to update Intake
**                      Allegation table whenever there is a person name change
**                      in the person list (callInformation Page).
** 09/28/05  dunawakl   SIR 24002 - Added szCdDisasterRlf for disaster relief field on
**                      Call Person Detail page.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/
/*
** Extern for version control table.
*/






public class Cint02s {
    
    /*
    ** SIR 2426 - Define Null String for use in comparison
    */
    public static final String NULL_STRING = "";
    public static final char VIEWED = 'V';
    public static final char RELATED = 'R';
    public static final char UNRELATED = 'U';
    //SIR 17476- Srini 05/13/03. Added the LAUNCHED('L') option
    public static final char LAUNCHED = 'L';
    /* 15512 - Needed constants in order to loop through race and ethnicity
    **         record groups correctly.
    */
    public static final int MAX_RACE_ROWS = 6;
    public static final int MAX_ETHNIC_ROWS = 2;
    /* Need the code len for a stncmp */
    public static final int CODE_LEN = 3;
    static int transactionflag = - 1;
    CINT02SO CINT02S(CINT02SI cint02si) {
        CINT02SO cint02so = new CINT02SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINT02S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINT02S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINT02S \n");
            bTransactionStarted = true;
        }
        
        /* retrieve date and time from the client */
        rc = ARC_PRFServiceStartTime_TUX(cint02si.ArchInputStruct);
        
        /*
        ** Add 100 years to todays date
        */
        rc = CallCINT06D(cint02si, cint02so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /*
        ** Set CCMN01UI ReqFuncCode
        */
        
        /*
        ** SIR #3267 - 2/25/96 - PURCELA - If the current event status is
        ** PROC, then make the ReqFuncCode an update, not an add, and copy
        ** timestamp and idevent into the next event group.
        */
        
        if (FND_YES == cint02si.PersListAudStruct.getBScrIndAddrDataChange()) {
            
            rc = Ccmn44s.CallCCMNA8D(cint02si, cint02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            rc = Ccmn44s.CallCCMNA9D(cint02si, cint02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (FND_YES == cint02si.PersListAudStruct.getBScrIndPhoneDataChange()) {
            rc = Ccmn31s.CallCCMN95D(cint02si, cint02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if ((FND_YES == cint02si.PersListAudStruct.getBScrIndNameDataChange()) || (WtcHelperConstants.REQ_FUNC_CD_ADD == cint02si.PersListAudStruct.getSzCdScrDataAction())) {
            
            // retrieve date and time from the client
            rc = Cinv05s.CallCINV32D(cint02si, cint02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        
        /*
        ** Call common function CCMN02U if Current F/A Home
        ** Status is Inquiry
        **
        ** SIR #4258 - "OR CdRsrsFacilType is RSRC_TYPE_PVT_
        ** AGENCY" was added to the following if statement.
        ** If the resource facility type is a Non-PRS Home,
        ** then Close Stage Case should be executed because a
        ** Non-PRS Home closure is just saved.  A user can no
        ** no longer Save and Submit a Non-PRS Home.
        */
        if (FND_YES == cint02si.PersListAudStruct.getBScrIndNameDataChange()) {
            
            //  Add 100 years to todays date
            rc = CallCINT78D(cint02si, cint02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (FND_YES == cint02si.PersListAudStruct.getBScrIndIDDataChange()) {
            
            rc = Cint23s.CallCINT18D(cint02si, cint02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (FND_YES == cint02si.PersListAudStruct.getBScrIndRaceDataChange()) {
            rc = Ccmn05s.CallCAUDD5D(cint02si, cint02so, pServiceStatus);
            rc = Ccmn05s.CallCAUDD4D(cint02si, cint02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint02si.ArchInputStruct, cint02so.ArchOutputStruct);
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINT02S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call CAUD17D.  The Contract Service AUD performs a full row
                // insert to the Contract Service table.
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINT02S \n");
        }
        return cint02so;
    }

    static int CallCINT06D(CINT02SI pInputMsg391, CINT02SO pOutputMsg357, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT06DI pCINT06DInputRec = null;
        CINT06DO pCINT06DOutputRec = null;
        int counter = 0;
        int i237 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT06DInputRec = new CINT06DI();
        
        pCINT06DOutputRec = new CINT06DO();
        pCINT06DInputRec.setSzCdStagePersType(pInputMsg391.PersListAudStruct.getSzCdStagePersType());
        pCINT06DInputRec.setSzCdStagePersRole(pInputMsg391.PersListAudStruct.getSzCdStagePersRole());
        pCINT06DInputRec.setSzNmPersonFull(pInputMsg391.PersListAudStruct.getSzNmPersonFull());
        pCINT06DInputRec.setDtDtPersonBirth(pInputMsg391.PersListAudStruct.getDtDtPersonBirth());
        pCINT06DInputRec.setLNbrPersonAge(pInputMsg391.PersListAudStruct.getLNbrPersonAge());
        pCINT06DInputRec.setBIndPersonDobApprox(pInputMsg391.PersListAudStruct.getBIndPersonDobApprox());
        pCINT06DInputRec.setCCdPersonSex(pInputMsg391.PersListAudStruct.getCCdPersonSex());
        pCINT06DInputRec.setSzCdStagePersRelInt(pInputMsg391.PersListAudStruct.getSzCdStagePersRelInt());
        
        pCINT06DInputRec.setBIndStagePersReporter(pInputMsg391.PersListAudStruct.getBIndStagePersReporter());
        
        /*
        ** Check buffer size 
        */
        
        /*
        ** Process error message and return to client 
        */
        
        /*
        ** Initialize output message and length 
        */
        
        /*
        ** Initialize service status fields 
        */
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        
        /*
        ** First, check the PriorStage indicator.  If set to YES, then 
        ** call CCMNB5D.  In this case, the Prior Stage ID is returned,
        ** the DetailList indicator is set to YES, and the TaskNew
        ** indicator is set to NO.  No further processing.
        */
        if (((VIEWED == pInputMsg391.PersListAudStruct.getSzCdStagePersSearchInd()) || (RELATED == pInputMsg391.PersListAudStruct.getSzCdStagePersSearchInd())) || (LAUNCHED == pInputMsg391.PersListAudStruct.getSzCdStagePersSearchInd()) || (UNRELATED == pInputMsg391.PersListAudStruct.getSzCdStagePersSearchInd())) {
            
            pCINT06DInputRec.setSzCdStagePersSearchInd(pInputMsg391.PersListAudStruct.getSzCdStagePersSearchInd());
        }
        else {
            
            //## BEGIN TUX/XML: Declare XML variables
            pCINT06DInputRec.setSzCdStagePersSearchInd(null);
        }
        pCINT06DInputRec.setBIndStagePersInLaw(pInputMsg391.PersListAudStruct.getBIndStagePersInLaw());
        pCINT06DInputRec.setSzCdNameSuffix(pInputMsg391.PersListAudStruct.getSzCdNameSuffix());
        pCINT06DInputRec.setDtDtPersonDeath(pInputMsg391.PersListAudStruct.getDtDtPersonDeath());
        pCINT06DInputRec.setSzCdPersonDeath(pInputMsg391.PersListAudStruct.getSzCdPersonDeath());
        pCINT06DInputRec.setSzCdPersonMaritalStatus(pInputMsg391.PersListAudStruct.getSzCdPersonMaritalStatus());
        pCINT06DInputRec.setSzCdPersonLanguage(pInputMsg391.PersListAudStruct.getSzCdPersonLanguage());
        pCINT06DInputRec.setSzCdDisasterRlf(pInputMsg391.PersListAudStruct.getSzCdDisasterRlf());
        pCINT06DInputRec.setSzCdPersonEthnicGroup(pInputMsg391.PersListAudStruct.getSzCdPersonEthnicGroup());
        pCINT06DInputRec.setSzTxtStagePersNotes(pInputMsg391.PersListAudStruct.getSzTxtStagePersNotes());
        pCINT06DInputRec.setUlIdStage(pInputMsg391.PersListAudStruct.getUlIdStage());
        pCINT06DInputRec.setUlIdPerson(pInputMsg391.PersListAudStruct.getUlIdPerson());
        pCINT06DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg391.PersListAudStruct.getSzCdScrDataAction());
        
        if (WtcHelperConstants.REQ_FUNC_CD_ADD == pCINT06DInputRec.getArchInputStruct().getCReqFuncCd()) {
            pCINT06DInputRec.setCdPersonStatus(pInputMsg391.PersListAudStruct.getCdPersonStatus());
            pCINT06DInputRec.setSzCdCategoryCategory(pInputMsg391.PersListAudStruct.getSzCdCategoryCategory());
        }
        pCINT06DInputRec.setBIndPersCancelHist(pInputMsg391.bIndPersCancelHist);
        pCINT06DInputRec.setSzCdStagePersLstSort(pInputMsg391.PersListAudStruct.getSzCdStagePersLstSort());
        
        /*
        ** Call DAM
        */
        rc = cint06dAUDdam(sqlca, pCINT06DInputRec, pCINT06DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                // 18 Feb 2003 DWW
                // Changed RC = 0 if RC = 1403, so that the service will 
                // not return an error in IMPACT
                if (0 != pCINT06DOutputRec.getUlIdPerson()) {
                    pOutputMsg357.ulIdPerson = pCINT06DOutputRec.getUlIdPerson();
                    pOutputMsg357.lSysNbrUniqueLBKey = pInputMsg391.PersListAudStruct.getLSysNbrUniqueLBKey();
                    pOutputMsg357.PLAUDKeys = pInputMsg391.PLAUDKeys;
                    
                    // Populate with ulIdPerson for further AUD
                    //  Name
                    for (counter = 0;counter < CINT02SI._PERSLISTAUDINREC__ROWCINV26SIG00_SIZE;counter++) {
                        
                        //  Check to see if either status field is NULL.
                        
                        if ((null != pInputMsg391.ROWCINV26SIG00[counter].getSzCdScrDataAction()) && (pCINT06DOutputRec.getUlIdPerson() != pInputMsg391.ROWCINV26SIG00[counter].getUlIdPerson())) {
                            pInputMsg391.ROWCINV26SIG00[counter].setUlIdPerson(pCINT06DOutputRec.getUlIdPerson());
                        }
                    }
                    
                    //  IDs
                    for (counter = 0;counter < CINT02SI._PERSLISTAUDINREC__CINT14WLB_SIZE;counter++) {
                        
                        if ((null != pInputMsg391.CINT14WLB[counter].getSzCdScrDataAction()) && (pCINT06DOutputRec.getUlIdPerson() != pInputMsg391.CINT14WLB[counter].getUlIdPerson())) {
                            pInputMsg391.CINT14WLB[counter].setUlIdPerson(pCINT06DOutputRec.getUlIdPerson());
                        }
                    }
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCCMNA8D(CINT02SI pInputMsg392, CINT02SO pOutputMsg358, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int Indicator = 0;
        FndInt3date dtMaxDate = null;
        int i238 = 0;
        int rc = SUCCESS;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNA8DI pCCMNA8DInputRec = null;
        CCMNA8DO pCCMNA8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNA8DInputRec = new CCMNA8DI();
        
        pCCMNA8DOutputRec = new CCMNA8DO();
        
        for (i238 = 0;i238 < CINT02SI._PERSLISTAUDINREC__ROWCCMN44SIG00_SIZE;i238++) {
            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg392.ROWCCMN44SIG00[i238].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_UPDATE == pInputMsg392.ROWCCMN44SIG00[i238].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_DELETE == pInputMsg392.ROWCCMN44SIG00[i238].getSzCdScrDataAction())) {
                pCCMNA8DInputRec.setSzAddrPersAddrStLn1(pInputMsg392.ROWCCMN44SIG00[i238].getSzAddrPersAddrStLn1());
                pCCMNA8DInputRec.setSzAddrPersAddrStLn2(pInputMsg392.ROWCCMN44SIG00[i238].getSzAddrPersAddrStLn2());
                pCCMNA8DInputRec.setSzAddrCity(pInputMsg392.ROWCCMN44SIG00[i238].getSzAddrCity());
                pCCMNA8DInputRec.setLAddrZip(pInputMsg392.ROWCCMN44SIG00[i238].getLAddrZip());
                pCCMNA8DInputRec.setSzCdAddrCounty(pInputMsg392.ROWCCMN44SIG00[i238].getSzCdAddrCounty());
                pCCMNA8DInputRec.setSzAddrPersAddrAttn(pInputMsg392.ROWCCMN44SIG00[i238].getSzAddrPersAddrAttn());
                pCCMNA8DInputRec.setSzCdAddrState(pInputMsg392.ROWCCMN44SIG00[i238].getSzCdAddrState());
                pCCMNA8DInputRec.setLdIdAddress(pInputMsg392.ROWCCMN44SIG00[i238].getLdIdAddress());
                pCCMNA8DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(0, 147);
                ;
                pCCMNA8DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg392.ROWCCMN44SIG00[i238].getSzCdScrDataAction());
                rc = ccmna8dAUDdam(sqlca, pCCMNA8DInputRec, pCCMNA8DOutputRec);
                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                    
                    if (0 != pCCMNA8DOutputRec.getLdIdAddress()) {
                        pOutputMsg358.ldIdAddress[i238] = pCCMNA8DOutputRec.getLdIdAddress();
                        pInputMsg392.ROWCCMN44SIG00[i238].setLdIdAddress(pCCMNA8DOutputRec.getLdIdAddress());
                    }
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else // process error code
                {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
            else {
                i238 = CINT02SI._PERSLISTAUDINREC__ROWCCMN44SIG00_SIZE;
            }
        }
        return rc;
    }

    static int CallCCMNA9D(CINT02SI pInputMsg393, CINT02SO pOutputMsg359, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int Indicator = 0;
        FndInt3date dtMaxDate = null;
        int i239 = 0;
        //## END TUX/XML: Declare XML variables 
        
        int rc = SUCCESS;
        
        /*
        ** Declare local variables
        */
        CCMNA9DI pCCMNA9DInputRec = null;
        CCMNA9DO pCCMNA9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNA9DInputRec = new CCMNA9DI();
        
        pCCMNA9DOutputRec = new CCMNA9DO();
        
        /*
        ** Populate Input Structure for DAM
        **
        ** SIR 10348 - CCMNA9D keeps track of the timestamps on the Start and End
        ** dates.  The primary addresses in the input message are sorted in
        ** reverse-modified order (i.e., the most recent primary name added or
        ** modified will be at beginning of the input message).  To ensure that
        ** the addresses receive the timestamps in the proper order, we need to
        ** process the list in reverse order.  This requires a change to the
        ** for loop from:
        **     for (i = 0; i < _PERSLISTAUDINREC__ROWCCMN44SIG00_SIZE; i++)
        ** to:
        **     for (i = _PERSLISTAUDINREC__ROWCCMN44SIG00_SIZE - 1; i>=0; i--)
        */
        for (i239 = CINT02SI._PERSLISTAUDINREC__ROWCCMN44SIG00_SIZE - 1;i239 >= 0;i239--) {
            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg393.ROWCCMN44SIG00[i239].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_UPDATE == pInputMsg393.ROWCCMN44SIG00[i239].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_DELETE == pInputMsg393.ROWCCMN44SIG00[i239].getSzCdScrDataAction())) {
                pCCMNA9DInputRec.setSzCdPersAddrLinkType(pInputMsg393.ROWCCMN44SIG00[i239].getSzCdPersAddrLinkType());
                pCCMNA9DInputRec.setDtDtPersAddrLinkEnd(pInputMsg393.ROWCCMN44SIG00[i239].getDtDtPersAddrLinkEnd());
                pCCMNA9DInputRec.setDtDtPersAddrLinkStart(pInputMsg393.ROWCCMN44SIG00[i239].getDtDtPersAddrLinkStart());
                pCCMNA9DInputRec.setUlIdPerson(pOutputMsg359.ulIdPerson);
                pCCMNA9DInputRec.setLdIdAddress(pInputMsg393.ROWCCMN44SIG00[i239].getLdIdAddress());
                pCCMNA9DInputRec.setUlIdAddrPersonLink(pInputMsg393.ROWCCMN44SIG00[i239].getUlIdAddrPersonLink());
                pCCMNA9DInputRec.setBIndPersAddrLinkInvalid(pInputMsg393.ROWCCMN44SIG00[i239].getBIndPersAddrLinkInvalid());
                pCCMNA9DInputRec.setBIndPersAddrLinkPrimary(pInputMsg393.ROWCCMN44SIG00[i239].getBIndPersAddrLinkPrimary());
                pCCMNA9DInputRec.setSzTxtPersAddrCmnts(pInputMsg393.ROWCCMN44SIG00[i239].getSzTxtPersAddrCmnts());
                pCCMNA9DInputRec.getTsSysTsLastUpdate2_ARRAY().setTsSysTsLastUpdate2(0, 147);
                ;
                pCCMNA9DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg393.ROWCCMN44SIG00[i239].getSzCdScrDataAction());
                rc = ccmna9dAUDdam(sqlca, pCCMNA9DInputRec, pCCMNA9DOutputRec);
                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                    
                    //  SIR #2141 - Populate Output Message Indicator with TRUE if
                    // CD_STAGE_REASON_CLOSED == CLOSED_TO_MERGE to indicate stage
                    // was closed by Case Merge and is not a complete stage.
                    if (0 != pCCMNA9DOutputRec.getUlIdAddrPersonLink()) {
                        pOutputMsg359.ulIdAddrPersonLink[i239] = pCCMNA9DOutputRec.getUlIdAddrPersonLink();
                    }
                    
                    // 
                    // Call DAMs to retrieve data
                    // 
                    //  Call PostEvent
                    // 
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else // process sql error
                {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
        }
        return rc;
    }

    static int CallCCMN95D(CINT02SI pInputMsg394, CINT02SO pOutputMsg360, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int Indicator = 0;
        FndInt3date dtMaxDate = null;
        int i240 = 0;
        int rc = SUCCESS;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN95DI pCCMN95DInputRec = null;
        CCMN95DO pCCMN95DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN95DInputRec = new CCMN95DI();
        
        pCCMN95DOutputRec = new CCMN95DO();
        
        /*
        ** Populate Input Structure for DAM
        **
        ** SIR 10348 - CCMN95D keeps track of the timestamps on the Start and End
        ** dates.  The primary phones in the input message are sorted in
        ** reverse-modified order (i.e., the most recent primary phone added or
        ** modified will be at beginning of the input message).  To ensure that
        ** the phones receive the timestamps in the proper order, we need to
        ** process the list in reverse order.  This requires a change to the
        ** for loop from:
        **     for (i = 0; i < _PERSLISTAUDINREC__ROWCCMN31SI_SIZE; i++)
        ** to:
        **     for (i = _PERSLISTAUDINREC__ROWCCMN31SI_SIZE - 1; i>=0; i--)
        */
        for (i240 = CINT02SI._PERSLISTAUDINREC__ROWCCMN31SI_SIZE - 1;i240 >= 0;i240--) {
            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg394.ROWCCMN31SI[i240].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_UPDATE == pInputMsg394.ROWCCMN31SI[i240].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_DELETE == pInputMsg394.ROWCCMN31SI[i240].getSzCdScrDataAction())) {
                pCCMN95DInputRec.getROWCCMN95DI().setUlIdPerson(pOutputMsg360.ulIdPerson);
                pCCMN95DInputRec.getROWCCMN95DI().setUlIdPhone(pInputMsg394.ROWCCMN31SI[i240].getUlIdPhone());
                pCCMN95DInputRec.getROWCCMN95DI().setSzCdPhoneType(pInputMsg394.ROWCCMN31SI[i240].getSzCdPhoneType());
                pCCMN95DInputRec.getROWCCMN95DI().setLNbrPhone(pInputMsg394.ROWCCMN31SI[i240].getLNbrPhone());
                pCCMN95DInputRec.getROWCCMN95DI().setLNbrPhoneExtension(pInputMsg394.ROWCCMN31SI[i240].getLNbrPhoneExtension());
                pCCMN95DInputRec.getROWCCMN95DI().setDtDtPersonPhoneStart(pInputMsg394.ROWCCMN31SI[i240].getDtDtPersonPhoneStart());
                pCCMN95DInputRec.getROWCCMN95DI().setDtDtPersonPhoneEnd(pInputMsg394.ROWCCMN31SI[i240].getDtDtPersonPhoneEnd());
                pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhonePrimary(pInputMsg394.ROWCCMN31SI[i240].getBIndPersonPhonePrimary());
                pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhoneInvalid(pInputMsg394.ROWCCMN31SI[i240].getBIndPersonPhoneInvalid());
                pCCMN95DInputRec.getROWCCMN95DI().setSzTxtPhoneComments(pInputMsg394.ROWCCMN31SI[i240].getSzTxtPhoneComments());
                pCCMN95DInputRec.getROWCCMN95DI().getTsLastUpdate()[0] = 147;
                ;
                pCCMN95DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg394.ROWCCMN31SI[i240].getSzCdScrDataAction());
                
                //  Call DAM
                rc = ccmn95dAUDdam(sqlca, pCCMN95DInputRec, pCCMN95DOutputRec);
                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                    
                    
                    // 
                    // (END): Assign to Worker
                    // 
                    
                    
                    //  SIR 20651 - 4/28/96 - PURCELA - Added this condition
                    // to ensure this logic will not be executed when the
                    // previous DAM calls have failed to assign the Stage to
                    // a worker.
                    
                    if (0 != pCCMN95DOutputRec.getUlIdPhone()) {
                        pOutputMsg360.ulIdPhone[i240] = pCCMN95DOutputRec.getUlIdPhone();
                    }
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
        }
        return rc;
    }

    static int CallCINV32D(CINT02SI pInputMsg395, CINT02SO pOutputMsg361, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int Indicator = 0;
        FndInt3date dtMaxDate = null;
        int rc = SUCCESS;/* Return code */
        
        /* Declare local variables */
        CINV32DI pCINV32DInputRec = null;
        CINV32DO pCINV32DOutputRec = null;
        _SSANAMESTRUCT SSANameStruct;
        int i241 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV32DInputRec = new CINV32DI();
        
        pCINV32DOutputRec = new CINV32DO();
        
        /*
        ** Populate Input Structure for DAM
        **
        ** SIR 10348 - CINV32D keeps track of the timestamps on the Start and End
        ** dates.  The primary names in the input message are sorted in
        ** reverse-modified order (i.e., the most recent primary name added or
        ** modified will be at beginning of the input message).  To ensure that
        ** the names receive the timestamps in the proper order, we need to
        ** process the list in reverse order.  This requires a change to the
        ** for loop from:
        **     for (i=0; i<_PERSLISTAUDINREC__ROWCINV26SIG00_SIZE; i++)
        ** to:
        **     for (i=_PERSLISTAUDINREC__ROWCINV26SIG00_SIZE - 1; i>=0; i--)
        */
        for (i241 = CINT02SI._PERSLISTAUDINREC__ROWCINV26SIG00_SIZE - 1;i241 >= 0;i241--) {
            
            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg395.ROWCINV26SIG00[i241].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_UPDATE == pInputMsg395.ROWCINV26SIG00[i241].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_DELETE == pInputMsg395.ROWCINV26SIG00[i241].getSzCdScrDataAction())) {
                pCINV32DInputRec.setSzCdNameSuffix(pInputMsg395.ROWCINV26SIG00[i241].getSzCdNameSuffix());
                pCINV32DInputRec.setDtDtNameEndDate(pInputMsg395.ROWCINV26SIG00[i241].getDtDtNameEndDate());
                pCINV32DInputRec.setDtDtNameStartDate(pInputMsg395.ROWCINV26SIG00[i241].getDtDtNameStartDate());
                pCINV32DInputRec.setUlIdName(pInputMsg395.ROWCINV26SIG00[i241].getUlIdName());
                pCINV32DInputRec.setUlIdPerson(pOutputMsg361.ulIdPerson);
                pCINV32DInputRec.setBIndNameInvalid(pInputMsg395.ROWCINV26SIG00[i241].getBIndNameInvalid());
                pCINV32DInputRec.setBIndNamePrimary(pInputMsg395.ROWCINV26SIG00[i241].getBIndNamePrimary());
                pCINV32DInputRec.setSzNmNameFirst(pInputMsg395.ROWCINV26SIG00[i241].getSzNmNameFirst());
                pCINV32DInputRec.setSzNmNameLast(pInputMsg395.ROWCINV26SIG00[i241].getSzNmNameLast());
                pCINV32DInputRec.setSzNmNameMiddle(pInputMsg395.ROWCINV26SIG00[i241].getSzNmNameMiddle());
                pCINV32DInputRec.getTsLastUpdate()[0] = 147;
                ;
                pCINV32DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg395.ROWCINV26SIG00[i241].getSzCdScrDataAction());
                SSANameStruct.szNmNameFirst = pInputMsg395.ROWCINV26SIG00[i241].getSzNmNameFirst();
                
                //  Call DAM
                rc = ARC_SSACreateKeys(SSANameStruct);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                SSANameStruct.szNmNameFirst = pInputMsg395.ROWCINV26SIG00[i241].getSzNmNameFirst();
                SSANameStruct.szNmNameLast = pInputMsg395.ROWCINV26SIG00[i241].getSzNmNameLast();
                SSANameStruct.szNmNameMiddle = pInputMsg395.ROWCINV26SIG00[i241].getSzNmNameMiddle();
                
                rc = ARC_SSACreateKeys(SSANameStruct);
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                pCINV32DInputRec.setSzNmPhkName( & SSANameStruct.szSysNmSSANamePrimPhk);
                rc = cinv32dAUDdam(sqlca, pCINV32DInputRec, pCINV32DOutputRec);
                
                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                    
                    if (0 != pCINV32DOutputRec.getUlIdName()) 
                    {
                        pOutputMsg361.ulIdName[i241] = pCINV32DOutputRec.getUlIdName();
                    }
                    
                    
                    
                    //  Start Performance Timer
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
        }
        
        return rc;
    }

    static int CallCINT18D(CINT02SI pInputMsg396, CINT02SO pOutputMsg362, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        /*
        ** Declare local variables
        */
        int ulCurrentRow = 0;
        
        CINT18DI pCINT18DInputRec = null;
        CINT18DO pCINT18DOutputRec = null;
        
        int Indicator = 0;
        FndInt3date dtMaxDate = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT18DInputRec = new CINT18DI();
        
        pCINT18DOutputRec = new CINT18DO();
        pCINT18DInputRec.setArchInputStruct(pInputMsg396.ArchInputStruct);
        
        for (ulCurrentRow = 0;ulCurrentRow < CINT02SI._PERSLISTAUDINREC__CINT14WLB_SIZE;ulCurrentRow++) {
            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg396.CINT14WLB[ulCurrentRow].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_UPDATE == pInputMsg396.CINT14WLB[ulCurrentRow].getSzCdScrDataAction()) || (ServiceConstants.REQ_FUNC_CD_DELETE == pInputMsg396.CINT14WLB[ulCurrentRow].getSzCdScrDataAction())) {
                pCINT18DInputRec.setSzCdPersonIdType(pInputMsg396.CINT14WLB[ulCurrentRow].getSzCdPersonIdType());
                pCINT18DInputRec.setBIndPersonIDInvalid(pInputMsg396.CINT14WLB[ulCurrentRow].getBIndPersonIDInvalid());
                pCINT18DInputRec.setSzDescPersonID(pInputMsg396.CINT14WLB[ulCurrentRow].getSzDescPersonID());
                pCINT18DInputRec.setDtPersonIDStart(pInputMsg396.CINT14WLB[ulCurrentRow].getDtPersonIDStart());
                pCINT18DInputRec.setDtPersonIDEnd(pInputMsg396.CINT14WLB[ulCurrentRow].getDtPersonIDEnd());
                pCINT18DInputRec.setSzNbrPersonIdNumber(pInputMsg396.CINT14WLB[ulCurrentRow].getSzNbrPersonIdNumber());
                pCINT18DInputRec.setUlIdPerson(pInputMsg396.CINT14WLB[ulCurrentRow].getUlIdPerson());
                pCINT18DInputRec.setUlIdPersonId(pInputMsg396.CINT14WLB[ulCurrentRow].getUlIdPersonId());
                pCINT18DInputRec.getTsSysTsLastUpdate2()[0] = 147;
                
                ;
                pCINT18DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg396.CINT14WLB[ulCurrentRow].getSzCdScrDataAction());
                rc = cint18dAUDdam(sqlca, pCINT18DInputRec, pCINT18DOutputRec);
                
                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                    if (0 != pCINT18DOutputRec.getUlIdPersonId()) {
                        pOutputMsg362.ulIdPersonId[ulCurrentRow] = pCINT18DOutputRec.getUlIdPersonId();
                    }
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                else {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
            else {
                ulCurrentRow = CINT02SI._PERSLISTAUDINREC__CINT14WLB_SIZE;
            }
        }
        return rc;
    }

    static int CallCAUDD5D(CINT02SI pInputMsg397, CINT02SO pOutputMsg363, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i242 = 0;
        int rc = 0;
        char bMoreRaces = 1;/* Flag for the race loop */
        CAUDD5DI pCAUDD5DInputRec = null;
        CAUDD5DO pCAUDD5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD5DInputRec = new CAUDD5DI();
        pCAUDD5DOutputRec = new CAUDD5DO();
        
        pCAUDD5DInputRec.setArchInputStruct(pInputMsg397.ArchInputStruct);
        
        pCAUDD5DInputRec.setUlIdPerson(pOutputMsg363.ulIdPerson);
        
        /*
        ** Loop through races
        ** As long as i < the max number of races we have, and the return
        ** code was 0, AND there are more races to copy, execute loop
        */
        for (i242 = 0;i242 < MAX_RACE_ROWS && rc == 0 && bMoreRaces != 0;i242++) {
            
            //  Change FuncCode based on flag passed into CallCCMN01U
            // This code is required because above memcpy will change
            // FuncCd to that of calling window which might not
            // be desired.  Flag concept is used to override above memcpy
            // for the cReqFuncCd variable.
            if (null != pInputMsg397.ROWCINT02SIG00[i242].getSzCdPersonRace()[0]) {
                pCAUDD5DInputRec.setSzCdPersonRace(pInputMsg397.ROWCINT02SIG00[i242].getSzCdPersonRace());
                pCAUDD5DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg397.ROWCINT02SIG00[i242].getSzCdScrDataAction());
                
                if (pCAUDD5DInputRec.getArchInputStruct().getCReqFuncCd() != null) {
                    
                    rc = caudd5dAUDdam(sqlca, pCAUDD5DInputRec, pCAUDD5DOutputRec);
                }
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                    case NO_DATA_FOUND:
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        break;
                        
                        // SIR#3054 Added NoRowsReturned
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        
                        // declare FOUNDATION variables
                        
                        // local variables
                        
                        // Start performance timer for service
                        rc = Messages.MSG_CMN_UPDATE_FAILED;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        
                        break;
                }
            }
            
            else {
                bMoreRaces = 0;
            }
        }
        return rc;
    }

    static int CallCAUDD4D(CINT02SI pInputMsg398, CINT02SO pOutputMsg364, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i243 = 0;
        int rc = 0;
        char bMoreEthnics = 1;/* Flag for the ethnicity loop */
        CAUDD4DI pCAUDD4DInputRec = null;
        CAUDD4DO pCAUDD4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD4DInputRec = new CAUDD4DI();
        pCAUDD4DOutputRec = new CAUDD4DO();
        pCAUDD4DInputRec.setArchInputStruct(pInputMsg398.ArchInputStruct);
        pCAUDD4DInputRec.setUlIdPerson(pOutputMsg364.ulIdPerson);
        
        /*
        ** Loop through ethnicities
        ** As long as i < the max number of ethnicities we have, and the
        ** return code was 0, AND there are more ethnicities to copy, execute
        ** loop
        */
        for (i243 = 0;i243 < MAX_ETHNIC_ROWS && rc == 0 && bMoreEthnics != 0;i243++) {
            //  SIR#23112: if the date is greater than or equal to 09/01/04 use
            // New code, otherwise use old codes
            if (null != pInputMsg398.ROWCINT02SIG01[i243].getSzCdPersonEthnicity()[0]) {
                pCAUDD4DInputRec.setSzCdPersonEthnicity(pInputMsg398.ROWCINT02SIG01[i243].getSzCdPersonEthnicity());
                pCAUDD4DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg398.ROWCINT02SIG01[i243].getSzCdScrDataAction());
                rc = caudd4dAUDdam(sqlca, pCAUDD4DInputRec, pCAUDD4DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                    case NO_DATA_FOUND:
                        
                        // Send Notification to Supervisor
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        
                        //  Set explan_data to usRow
                        // Note: Use sprintf
                        
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        rc = Messages.MSG_CMN_UPDATE_FAILED;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
            }
            
            else {
                bMoreEthnics = 0;
            }
        }
        return rc;
    }

    static int CallCINT78D(CINT02SI pInputMsg399, CINT02SO * pOutputMsg365, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT78DI pCINT78DInputRec = null;
        CINT78DO pCINT78DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT78DInputRec = new CINT78DI();
        pCINT78DOutputRec = new CINT78DO();
        pCINT78DInputRec.setUlIdPerson(pInputMsg399.PersListAudStruct.getUlIdPerson());
        pCINT78DInputRec.setUlIdStage(pInputMsg399.PersListAudStruct.getUlIdStage());
        pCINT78DInputRec.setSzNmPersonFull(pInputMsg399.PersListAudStruct.getSzNmPersonFull());
        pCINT78DInputRec.setArchInputStruct(pInputMsg399.ArchInputStruct);
        pCINT78DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cint78dAUDdam(sqlca, pCINT78DInputRec, pCINT78DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

}
