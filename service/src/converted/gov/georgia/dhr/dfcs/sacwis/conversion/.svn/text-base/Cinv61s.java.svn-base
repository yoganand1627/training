package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV61SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV61SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES97DI;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES97DO;
/**************************************************************************
**
** Module File:   cinv61s.src
**
** Service Name:  CINV61S - LIC INV CONCL VAL
**
** Description:   This service performs server side validation for the Licensing
**                Investigation Conclusion window. The edits performed by
**                the service depend on the decode string in DCD_EDIT_PROCESS.
**                Once all required edits are passed, the service will 1) set
**                all the to-dos associated with the input ID_EVENT to
**                "COMPLETE", 2) return a list of all the ID_EVENTs
**                associated with the input ID_STAGE, 3) Close the stage and
**                the case if "Save and Close" was selected in the client.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  06/11/95
**
** Programmer:    Alex Ramirez
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   14 Mar 2002 12:13:30  $
**                      $Modtime:   13 Mar 2002 17:25:54  $
**                      $Author:   pvcs  $
**
** Change History:
** Date      User      Description
** --------  --------  --------------------------------------------------
**  10/03/95  WEALANBC  SIR 1590 - Modified CallCINV34D() to insure that
**                      only PRNs are checked for characteristics.
**  10/03/95  WEALANBC  ERR#1596 Change to edits after CINV34D.
**  10/13/95  VISHNUR   SIR 1765 Change to CallCCMN34D.
**  10/14/95  HUSTONMJ  ERR#1674 Change to CallCCMN87D.
**  11/13/95  HELMKEST  SIR 1710: Include CCMN06U common function.
**
**  01/10/97  RIOSJA    SIR 12062 - Data Access error was occurring during
**                      CloseStage() function. CCMN87D would retrieve all
**                      id_events for the case, but would pass only certain
**                      ones to CCMN62D. CCMN87D would also pass a "number
**                      of rows" variable telling CCMN62D how many id_events
**                      to expect. But CCMN87D was always telling CCMN62D to
**                      expect the total number of id_events for the case
**                      when it should be telling it to expect only the
**                      number of id_events being passed (which could be less
**                      than the total). Now CCMN87D will count the number of
**                      id_events being passed to CCMN62D and will pass that
**                      number in the "number of rows" variable.
**  12/07/98  LEIHMA    SIR14996 - Upon conclusion of a LIC Investigation
**                      (Save and Submit), an edit is added so that if the
**                      reason for death is A/N, then that person must be a
**                      victim in an allegation where the disposition is RTB.
** 05/13/99  SHARMAS    SIR 15208 - Before the user can "Save and Submit" a
**                      LIC investigation conclusion an edit is added to ensure
**                      that if there is a date of death entered there must
**                      be a reason for death in the person detail window.
**
** 12/27/99  BLAHAPP    SIR 15028
**          Before the user can "Save and Submit" a
**          LIC investigation conclusion, an edit is added to
**          ensure that
**
**          a) if there is a death code entered that
**          is one of the three abuse and neglect (A/N) death
**          codes, there must also be at least one allegation
**          with severity = "fatal" for that person as victim.
**          (N.B., In order for the severity field
**          to be enabled to give it a value of "fatal",
**          disposition must be RTB, so the condition of
**          Sir # 14996 [see that SIR above] is also filled
**          when this condition is filled.)
**
**          b) the reverse:  if there is an allegation with
**          severity = fatal for the victim, there must also
**          be a death code whose value is one of the three
**          A/N codes.
** 3/13/00  BLAHAPP    SIR 15465  The consistency check between death code and
**          allegation severity did not check for a null death
**          code.  A condition for entering the code that does the
**          consistency check was that there WAS a death code
**          at all.  This SIR removes that restriction.
**          In the case where a severity of fatal is found,
**          the previous logic gave an error if a death code of A/N
**          was not also found. That same logic will now apply in the
**          case of a null death code and cause the same error message
**          to display to the user.
** 3/29/01  GRIMSHAN    SIR 13532   Code modifications will be made in the
**          Licensing investigation conclusion validation service to prevent
**          the person characteristiecs, date of birth, and person search edits
**          from appearing while trying to close an investigation, when the
**          name is a valid unknown.
**
**3/01/2002 ochumd     Sir 15712 - Made code modifications in the Licensing
**                      investigation conclusion validation service to prevent
**                      person search edits from appearing while trying to close
**                      an investigation when the person type is collateral.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**
**  04/30/03   Srini	SIR 17091: Added the error handling to take care of full 
**						table scans for ccmn87dQUERYdam.
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
****************************************************************************/


/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv61s {
    public static final int INITIAL_PAGE = 1;
    public static final char YES = 'Y';
    
    /* Parameter for Edit Process String */
    public static final char EDIT_YES = 'Y';
    
    /* Positions within Edit Process String */
    public static final int VICTIM_DOB_EDIT = 0;
    public static final int PERS_SEARCH_EDIT = 1;
    public static final int PERS_CHARACTER_EDIT = 2;
    
    /*  SIR 14996
    ** The  codes table already
    ** had entries for 4th thru 6th position.  The 4th thru 6th
    ** positions do not appear to be used, however to be safe this
    ** edit will use "6" which is the 7th position.
    */
    public static final int RSN_DTH_EDIT = 6;
    public static final int DATE_RSN_DTH_EDIT = 7;
    
    /* Person roles, types, searches, etc. */
    public static final int PERSON_CHAR_NULL = 0;
    public static final char PERSON_CHAR_NONE = '0';
    public static final String PERSON_ROLE_BOTH = "DB";
    public static final String PERSON_ROLE_VICTIM = "DV";
    public static final char PERSON_SEARCH_R = 'R';
    public static final char PERSON_SEARCH_V = 'V';
    public static final String PERSON_STAFF = "STF";
    public static final String PERSON_TYPE_PRN = "PRN";
    
    /*******************************/
    public static final String PERSON_TYPE_COL = "COL";
    /*******************************/
    
    /* Task codes and event related constants */
    public static final String COMPLETE = "COMP";
    public static final String NO_EVENT_TYPE = "";
    public static final String NO_TASK = "";
    public static final String EVENT_STATUS_APPROVED = "APRV";
    public static final String EVENT_TYPE_PRIORITY_CHANGE = "PRT";
    public static final String EVENT_TYPE_CONTACT = "CON";
    public static final String EVENT_TYPE_MED_MENTAL_ASSESS = "MED";
    public static final String EVENT_STATUS_NEW = "NEW";
    
    /* Validation Edit Warning Codes */
    public static final int PERS_CHARACTER_WARNING = 4054;
    public static final int VICTIM_DOB_WARNING = 4055;
    public static final int PERS_SEARCH_WARNING = 4056;
    public static final int EVENT_STATUS_WARNING = 4079;
    
    /* Function code for the Close action */
    public static final char ACTION_CODE_CLOSE = 'C';
    public static final String EVENT_STATUS_COMP = "COMP";
    
    /*SIR 14996 */
    public static final int MSG_INV_RSN_DTH_EDIT = 4127;
    public static final String AN_IN_OPEN_CASE = "ABN";
    public static final String AN_IN_PRIOR_CASE = "ABO";
    public static final String AN_NO_PRIOR_CASE = "ABP";
    
    /* SIR# 15028 */
    public static final String NOT_AN_RELATED = "NAB";
    
    /* SIR# 15208 */
    public static final int MSG_INV_DATE_RSN_DTH_EDIT = 4132;
    static int transactionflag = - 1;
    CINV61SO CINV61S(CINV61SI cinv61si) {
        CINV61SO cinv61so = new CINV61SO();
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
            userlog("ERROR: tpgetlev failed in CINV61S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV61S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV61S \n");
            bTransactionStarted = true;
        }
        int i393 = 0;
        Pchar bRsnDthEdit = new Pchar();
        bRsnDthEdit.value = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        
        /* SIR 1710: Variables used in CheckStageEventStatus common function */
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/* SIR#2426 */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#2426 */
        
        /* SIR 14996  Declare and initialize dam function input/output variables */
        
        CLSC18DO CLSC18DO = null;
        CSES97DI CSES97DI = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv61si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
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
        
        /**************************************************************************
        ** SIR 1710:
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv61si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv61si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv61si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv61si.getSzCdTask());
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                break;
                
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
                
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                
                break;
        }
        
        if (SUCCESS == RetVal) {
            rc = Cinv01s.CallCINV34D(cinv61si, cinv61so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //  ID UNIT was passed in, so call DAM CCMNA1D
            rc = Cinv15s.CallCLSC18D(cinv61si, cinv61so, CLSC18DO, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
                case WtcHelperConstants.ARC_SUCCESS:
                    //## END TUX/XML: Turn the XML buffer into an input message struct
                    
                    
                    
                    if (cinv61si.getSzDcdEditProcess()[RSN_DTH_EDIT] == EDIT_YES) {
                        for (i393 = 0;(i393 < CLSC18DO.getArchOutputStruct().getUlRowQty() || bRsnDthEdit.value == true);++i393) {
                            cinv61si.setSzCdPersonDeath(CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i393).getSzCdPersonDeath());
                            CSES97DI.setUlIdPerson(CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i393).getUlIdPerson());
                            //  CD UNIT PROGRAM, CD UNIT REGION, NBR UNIT were passed in, so
                            // call DAM CCMNC0D
                            rc = Cinv15s.CallCSES97D(cinv61si, CSES97DI, bRsnDthEdit, cinv61so, pServiceStatus);
                        }
                    }
                    
                    break;
                    // end for SIR 14996
                    
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            
            
            //  Initialize Service Status Fields
            
            
            
            //   Perform Main Processing
            
            //  SIR #20830 - 5/6/96 - PURCELA - Only perform CCMN06U if a CdTask is
            // passed into the function.  If this value is not being passed, then
            // we are creating a Non Navigational Event that should not Check
            // Stage/Event Status.
            
            if (!cinv61so.getCINV15SOG01().getUlRowQty()) {
                //  Determine Approver's Unit Member Role
                rc = Cinv12s.CallCINV43D(cinv61si, cinv61so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                
                rc = Cinv15s.CallCCMN87D(cinv61si, NO_TASK, NO_EVENT_TYPE, cinv61so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                if ((cinv61si.getArchInputStruct().getCReqFuncCd() == ACTION_CODE_CLOSE) && (cinv61so.getCINV59SOG01().ulRowQty == null)) {
                    rc = Cinv20s.CloseStage(cinv61si, cinv61so, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                }
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv61si.getArchInputStruct() , cinv61so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        /*
        ** SIR #3710 - 3/11/96 - PURCELA - If there is no IdEvent and the
        ** indicator of a Dummy Event is True, then pass a
        ** ReqFuncCd of Add.  Compensates for Dummy Events
        */
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            // 
            // End  CCMN06U Check Stage Event Status
            // 
            
            
            //  Call Post Event if retval = success
            // 
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV61S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV61S \n");
        }
        return cinv61so;
    }

    static int CallCINV34D(CINV61SI pInputMsg793, CINV61SO pOutputMsg738, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i394 = 0;
        
        /*
        ** Declare local variables
        */
        /*
        ** SIR 13532 - Commented the living arrangement flag
        **             since it is not used in this
        **             function.  Add unknown name flag
        */
        CINV34DI pCINV34DInputRec = null;
        CINV34DO pCINV34DOutputRec = null;
        int bPersCharacter = 0;
        int bVictimDob = 0;
        int bPersSearch = 0;
        int bUnknownName = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV34DInputRec = new CINV34DI();
        
        
        pCINV34DOutputRec = new CINV34DO();
        pCINV34DInputRec.setArchInputStruct(pInputMsg793.getArchInputStruct());
        pCINV34DInputRec.setUlIdStage(pInputMsg793.getUlIdStage());
        pCINV34DInputRec.setSzCdStagePersType(PERSON_STAFF);
        pCINV34DInputRec.getArchInputStruct().setUsPageNbr(0);
        pCINV34DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV34DO._CINV34DO__ROWCINV34DO_SIZE);
        pCINV34DOutputRec.getArchOutputStruct().setBMoreDataInd(1);/* Add logic for row not found (It's no problem) */
        
        /*
        ** Set loop to retrieve all the persons associated with the case
        */
        while (pCINV34DOutputRec.getArchOutputStruct().getBMoreDataInd() != 0) {
            pCINV34DInputRec.getArchInputStruct().getUsPageNbr()++;
            rc = cinv34dQUERYdam(sqlca, pCINV34DInputRec, pCINV34DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    for (i394 = 0;i394 < pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();++i394) {
                        bUnknownName = 0;
                        
                        if ((null == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getSzNmPersonFirst()[0]) && (null == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getSzNmPersonLast()[0])) {
                            // SIR 13532
                            // Reset bUnknownName for each person in the loop
                            
                            bUnknownName = 1;
                        }
                        
                        if (EDIT_YES == pInputMsg793.getSzDcdEditProcess()[PERS_SEARCH_EDIT] && (PERSON_SEARCH_R != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getSzCdStagePersSearchInd()) && (PERSON_SEARCH_V != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getSzCdStagePersSearchInd()) && (0 != PERSON_TYPE_COL.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getSzCdStagePersType())) && (!bPersSearch) && (!bUnknownName)) {
                            bPersSearch = 1;
                        }
                        
                        
                        if ((EDIT_YES == pInputMsg793.getSzDcdEditProcess()[PERS_CHARACTER_EDIT]) && ((PERSON_CHAR_NONE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getBCdPersonChar()) || (PERSON_CHAR_NULL == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getBCdPersonChar())) && (0 == PERSON_TYPE_PRN.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getSzCdStagePersType())) && (!bPersCharacter) && (!bUnknownName)) {
                            bPersCharacter = 1;
                        }
                        if (EDIT_YES == pInputMsg793.getSzDcdEditProcess()[VICTIM_DOB_EDIT] &&!(strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getSzCdStagePersType() , PERSON_TYPE_PRN, PERSON_TYPE_PRN.length()) != 0) && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getDtDtPersonBirth().day && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getDtDtPersonBirth().month && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i394).getDtDtPersonBirth().year && bVictimDob != true && true != bUnknownName) {
                            bVictimDob = 1;
                        }
                        if (bPersCharacter != 0 && bVictimDob != 0 && bPersSearch != 0) {
                            pCINV34DOutputRec.getArchOutputStruct().setBMoreDataInd(0);
                            i394 = pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();
                            
                            break;
                        }
                    }
                    
                    //  Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            if (bPersCharacter != 0) {
                pOutputMsg738.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg738.getCINV59SOG01().ulRowQty, PERS_CHARACTER_WARNING);
                pOutputMsg738.getCINV59SOG01().ulRowQty++;
            }
            // if no rows found for person_forward, it means there is no Income for person_forward
            // therefore we want to insert the income
            if (bVictimDob != 0) {
                pOutputMsg738.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg738.getCINV59SOG01().ulRowQty, VICTIM_DOB_WARNING);
                pOutputMsg738.getCINV59SOG01().ulRowQty++;
            }
            
            if (bPersSearch != 0) 
            {
                
                pOutputMsg738.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg738.getCINV59SOG01().ulRowQty, PERS_SEARCH_WARNING);
                
                //## BEGIN TUX/XML: Declare XML variables 
                pOutputMsg738.getCINV59SOG01().ulRowQty++;
            }
        }
        
        return rc;
    }

    static int CallCCMN87D(CINV61SI pInputMsg794, String szCdTask2, String szCdEventType6, CINV61SO pOutputMsg739, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int usEventCtr = 0;/* Loop counter */
        
        /*
        ** Declare local variables
        */
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg794.getArchInputStruct());
        pCCMN87DInputRec.setUlIdStage(pInputMsg794.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(szCdEventType6);
        
        pCCMN87DInputRec.setSzCdTask(szCdTask2);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        if (0 == szCdEventType6.compareTo(NO_EVENT_TYPE)) {
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV61SO._CINV61SO__ROWCINV15SOG00_SIZE);
        }
        else {
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        }
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg739.getArchOutputStruct().setUlRowQty(0);
                
                for (usEventCtr = 0;usEventCtr < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();usEventCtr++) {
                    if (pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_COMP) != 0) {
                        if (!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_CONTACT) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0)) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_PRIORITY_CHANGE) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0)) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_MED_MENTAL_ASSESS) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0))) {
                            pOutputMsg739.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg739.getCINV59SOG01().ulRowQty, EVENT_STATUS_WARNING);
                            pOutputMsg739.getCINV59SOG01().ulRowQty++;
                            break;
                        }
                    }
                    
                    pOutputMsg739.getROWCINV15SOG00_ARRAY().getROWCINV15SOG00(usEventCtr).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getUlIdEvent());
                    
                    pOutputMsg739.getArchOutputStruct().getUlRowQty()++;
                }
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCINV43D(CINV61SI pInputMsg795, CINV61SO * pOutputMsg740, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV43DInputRec = new CINV43DI();
        pCINV43DOutputRec = new CINV43DO();
        pCINV43DInputRec.setUlIdEvent(pInputMsg795.getUlIdEvent());
        pCINV43DInputRec.setArchInputStruct(pInputMsg795.getArchInputStruct());
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        return rc;
    }

    static int CloseStage(CINV61SI pInputMsg796, CINV61SO pOutputMsg741, Arcxmlerrors.TUX_DECL_STATUSPARMS) {/* if service code is a foster code */
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN02UI pCCMN02UInputRec = null;
        CCMN02UO pCCMN02UOutputRec = null;
        
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = Ccmn05u.CallCCMN62D(pInputMsg796, pOutputMsg741, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /*************************************************************************
        ** Close the Investigation Stage and the Case
        **************************************************************************/
        /*
        ** Allocate memory for CloseStageCase Input
        ** and Output Structures
        */
        pCCMN02UInputRec = new CCMN02UI();
        
        pCCMN02UOutputRec = new CCMN02UO();
        pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(pInputMsg796.getUlIdStage());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(pInputMsg796.getSzCdStage());
        
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(pInputMsg796.getSzCdStageProgram());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(pInputMsg796.getSzCdStageReasonClosed());
        rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        return rc;
    }

    static int CallCCMN62D(CINV61SI * pInputMsg797, CINV61SO pOutputMsg742, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        int usEventCtr = 0;
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        
        /*
        ** Loop through Investigation Events, changing status to Approved
        */
        for (usEventCtr = 0;usEventCtr < pOutputMsg742.getArchOutputStruct().getUlRowQty();usEventCtr++) {
            pCCMN62DInputRec.setUlIdEvent(pOutputMsg742.getROWCINV15SOG00_ARRAY().getROWCINV15SOG00(usEventCtr).getUlIdEvent());
            pCCMN62DInputRec.setSzCdEventStatus(EVENT_STATUS_APPROVED);
            pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            //  SIR 13172 need to enter an if statement about if FA Home than call new dam
            // else call cres04d
            
            //  Call CRES04D
            rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        return rc;
    }

    static int CallCLSC18D(CINV61SI pInputMsg798, CINV61SO pOutputMsg743, CLSC18DO pRsnDthOut, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i395 = 0;
        
        /*
        ** Declare local variables
        */
        CLSC18DI pCLSC18DInputRec = null;
        CLSC18DO pCLSC18DOutputRec = null;
        int bDateRsnDth = 0;/* SIR 15208 */
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC18DInputRec = new CLSC18DI();
        pCLSC18DOutputRec = new CLSC18DO();
        pCLSC18DInputRec.setArchInputStruct(pInputMsg798.getArchInputStruct());
        pCLSC18DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        pCLSC18DInputRec.setUlIdStage(pInputMsg798.getUlIdStage());
        pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC18DO._CLSC18DO__ROWCLSC18DO_SIZE);
        
        /*
        ** Start Performance Timer for service
        */
        rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pInputMsg798.getSzDcdEditProcess()[DATE_RSN_DTH_EDIT] == EDIT_YES) {
                    for (i395 = 0;(i395 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty() && true != bDateRsnDth);++i395) {
                        
                        if (DateHelper.NULL_DATE != pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i395).getDtDtPersonDeath().month && null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i395).getSzCdPersonDeath()[0]) {
                            bDateRsnDth = 1;
                        }
                    }
                }
                
                
                //  Populate Output Message
                
                for (i395 = 0;(i395 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());++i395) {
                    pRsnDthOut.getArchOutputStruct().setUlRowQty(pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());
                    pRsnDthOut.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i395).setUlIdPerson(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i395).getUlIdPerson());
                    pRsnDthOut.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i395).setSzCdPersonDeath(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i395).getSzCdPersonDeath());
                }
                
                // 
                // Call DAMs to retrieve data
                // 
                
                //  Call the CheckStageEventStatus() common function
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        if (bDateRsnDth != 0) {
            pOutputMsg743.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg743.getCINV59SOG01().ulRowQty, MSG_INV_DATE_RSN_DTH_EDIT);
            pOutputMsg743.getCINV59SOG01().ulRowQty++;
        }
        return rc;
    }

    static int CallCSES97D(CINV61SI pInputMsg799, CSES97DI pRsnDthIn, String bRsnDthEdit, CINV61SO pOutputMsg744, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int usCaseCtr = 0;/* Loop counter */
        /*
        ** Declare local variables
        */
        
        
        CSES97DI pCSES97DInputRec = null;
        CSES97DO pCSES97DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES97DInputRec = new CSES97DI();
        
        pCSES97DOutputRec = new CSES97DO();
        pCSES97DInputRec.setUlIdStage(pInputMsg799.getUlIdStage());
        pCSES97DInputRec.setUlIdPerson(pRsnDthIn.getUlIdPerson());
        pCSES97DInputRec.setArchInputStruct(pInputMsg799.getArchInputStruct());
        
        
        /*
        ** If no Monthly Summaries are found with a status of Approved,
        ** display an error message notifying user that at least one
        ** must be approved to save and submit
        */
        /********************************************************************
        **   SIR 1582:  An approved Family Plan & Monthly Summary is no
        **   longer necessary for Family Preservation Closure.  Remove
        **   Edit checking for Family Plan's and Monthly Summary's
        **   existence.
        **
        **   if (0==strcmp(szCdContactType,
        **          SVC_CD_CONTACT_TYPE_FPR_MNTH))
        **{
        **    pOutputMsg->CINV20SOG01.
        **        usSysNbrMessageCode[EditWarningRowCtr]
        **        = MSG_SVC_MONTH_SUMM_APRV;
        **
        **    EditWarningRowCtr++;
        **
        **}
        ********************************************************************/
        
        rc = cses97dQUERYdam(sqlca, pCSES97DInputRec, pCSES97DOutputRec);
        switch (rc) {
            case NO_DATA_FOUND:
                {
                    if ((0 == pInputMsg799.getSzCdPersonDeath().compareTo(AN_IN_OPEN_CASE)) || (0 == pInputMsg799.getSzCdPersonDeath().compareTo(AN_IN_PRIOR_CASE)) || (0 == pInputMsg799.getSzCdPersonDeath().compareTo(AN_NO_PRIOR_CASE))) {
                        bRsnDthEdit = true;
                        
                        pOutputMsg744.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg744.getCINV59SOG01().ulRowQty, MSG_INV_RSN_DTH_EDIT);
                        pOutputMsg744.getCINV59SOG01().ulRowQty++;
                        break;
                    }
                    else {
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                    }
                }
            case WtcHelperConstants.SQL_SUCCESS:
                {
                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                    
                    
                    
                    if ((0 == pInputMsg799.getSzCdPersonDeath().compareTo(AN_IN_OPEN_CASE)) || (0 == pInputMsg799.getSzCdPersonDeath().compareTo(AN_IN_PRIOR_CASE)) || (0 == pInputMsg799.getSzCdPersonDeath().compareTo(AN_NO_PRIOR_CASE))) {
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                    }
                    else {
                        bRsnDthEdit = true;
                        
                        pOutputMsg744.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg744.getCINV59SOG01().ulRowQty, MSG_INV_RSN_DTH_EDIT);
                        pOutputMsg744.getCINV59SOG01().ulRowQty++;
                        break;
                    }
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

}
