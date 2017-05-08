package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV10DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV10DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS15DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC84DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVD3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVD3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC67DO;
/**************************************************************************
**
** Module File:   CINV14S.src
**
** Service Name:  CINV14S
**
** Description: This service is used in the Predisplay callback of window
**              CINV06W - CPS INV CONCLUSION. It retrieves all the values
**              necessary to populate window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/16/95
**
** Programmer:    Alex Ramirez
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/16/95    APR     Changed shell to reflect latest changes/additions to
**                      sample service shell
**
**  10/12/95  ELLITOSL  ERR #1625: Error condition for MSG_NO_ROWS_RETURNED
**                      has been added to CallCINV95D.  This will allow
**                      the client to distinguish between no rows found
**                      and other errors.
**  10/15/95  HUSTONMJ  ERR #1803: Do not return Risk Finding if Risk
**                      Assessment event status is not COMP.
**  01/08/96  BRUCKMK   SIR 1972: Do not populate
**                      pOutputMsg->ROWCINV10DOG00.dtDtCPSInvstDtlIntake
**                      with the date "DT_CPS_INVST_DTL_INTAKE" on the
**                      CPS_INVST_DETAIL table.
**                      Instead created and added DAM CLSC69D to retrieve the
**                      "DT_INCOMING_CALL" from the INCOMING_DETAIL table for
**                      the Intake stage of the given ID_CASE.
**  01/19/96    KRD     SIR 2766 - If an Investigation does not have a
**                      DT_CPS_INVST_DTL_BEGUN, the service should exit and
**                      return MSG_INV_NOT_BEGUN.  Required changes to the
**                      Main function and CallCSYS15D().
**  01/30/96  BRUCKMK   SIR 1947: Always get the Investigation Begun Date from
**                      the Date of First Contact retrieved by DAM CSYS15D.
**                      There is no need for an "if" statement here before
**                      calling CSYS15D, since we always want to call this
**                      DAM.  Also do not populate the Investigation Begun
**                      Date in the Investigation Detail Table retrieve.
**  03/25/96  MCCLESBH  SIR 4201: Converted CPS investigation conclusions
**                      will not have contacts; thus, it is impossible to
**                      determine the DtInvstBegun as indicated in SIR 1947.
**                      If the stage is closed and a "Not Found" condition
**                      exists after calling CSYS15D, the service will
**                      return the DtInvstBegun from CPS_INV_DETAIL.
** 03/27/96  OMARAJJ    SIR#4329 - There are several possible cases when
**                      an SQL_NOT_FOUND case is possible following the call
**                      to CSYS15d and should not fall into the DEFAULT case.
**                      Thus, and SQL_NOT_FOUND case is necessary.
**
** 04/03/96  WILSONET   SIR#20093: The risk assessment records are
**                      linked to risk assessment events with no task.
** 09/03/96  ZABIHIN    SIR 2159 - added a dam (CLSC18D) to retrieve the
**                      marital and ethnic status for each principal.
**                      This inforamtion is required for CPS cases.
**
** 10/16/96  VANDERM    SIR 22103 - removed the tsLastUpdate variable since
**                      it is not populated in the DAM and is not utilized
**                      in the window. THIS IS WRONG and was reversed
**                      2/27/97 by YANTISTK.
**
** 2/19/97   SARAVIGM   SIR#11377-The DAM that is being called by this service
**                      has changed from clsc69d.pc to clsc84d.pc.
**                      This DAM will retrieve the correct intake date for the
**                      Investigation Conclusion windows used in CAPS.
**
** 03/17/97  GONZALCE   SIR 12090 - added ulIdPriorStage to the service output
**                      message.  Populated this field using CLSC84D.
** 02/05/98  PAULS      SIR 13761 - Marital Status And Ethnicity Edit.
**                      Removed CLSC18D Dam from this Service to CINV15S.Src.
** 08/10/99  Millersr   SIR 15049 Added 2 data elements to DAM CINV14D.PC
**                      IND_RISK_ASSMT_INTRANET & CD_RISK_FACTORS_CATEG
**                      to determine which Risk Assessment form should be produced.
**
** 06/25/2001 hafelela  IRA2001 - The IRA Narrative Enhancement brought
**                                the IRA narratives back into the CAPS
**                                database. Code was added to reference
**                                the new IRA narrative table - if the
**                                Risk Assessment was completed via the.
**                                intranet.
**
** 10/11/01 Casdorjm    IRA2001 - Modifications will be needed to the retrieval
**                                service for the Investigation Conclusion window
**                                to ensure that the new indicator gets passed to
**                                the window from the service and dam.
**
**03/01/2002 ochumd     Sir#15712 - Added Dam cint20d.pc to search the stage person
**                      link table for a principal with the role of Uk.
**                      If one is found a 1 is passed as an indicator to
**                      the window.  A zero is passed otherwise.
**
**04/09/2003  Srini     IMPACT -   Added the required error handling for the case
**                      MSG_INV_NOT_BEGUN to return the error and exit the
**                      service for the Dam call CallCSYS15D
**
**04/09/2003  Srini     IMPACT  -  Added a break to the success case for the Dam call
**                      CallCSYS15D
**
**  04/30/03   Srini    SIR 17091: Added the error handling to take care of full
**                      table scans for ccmn87dQUERYdam.
**
**  05/20/03  mcclaim   SIR 17596 - Made Transaction aware
**
**  06/09/03  Srini     SIR#18138 -  Pass the username to the dam to be logged
**                      as part of audit log.
**
**  06/19/03   Srini    SIR 18055  - Added to check for 'M' as well for Impact the
**                      pOutputMsg->ROWCINV14DOG00.cIndRiskAssmtIntranet[0] value.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                      input and output objects before they are allocated
**
**  06/30/03  Srini     SIR 18602 - Modified to fix error handling for
**                      transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**                      PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to
**                      PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**
**  06/10/2004 dejuanr  SIR 22936 - Added data element for CPS and Law
**                      Enforcment Joint contact - IND_CPS_INVST_DTL_CPS_LE_JOINT_CONTACT.
**                      This was added to CINV10D and CINV95D.
**  06/15/04  CORLEYAN  SIR 15956 - Added call to clsc18d in order to retrieve all principals
**                      in the stage.  If any of the principals have unknown genders or
**                      approximate DOBs, set an indicator that will be used to inform
**                      the user of the missing data
**  01/13/2004 dejuanr  SIR 22986 - Add victim taped fields
**
**  04/27/2004 RANAS    SIR 23536 - Check if any allegations associated with stage are
**                      Physical or Sexual Abuse.
**
**  06/28/05  Hadjimh   SIR# 22665 Merged cases have blanked out dispositions on the
**                      allegation list/detail page but the investigation conclusion page
**                      has an overall disposition. Recommended Solution: 1)  If two
**                      cases are being merged and one of the cases has been saved and
**                      submitted for stage closure stop the merge. this pertains to all
**                      case merges.   If the event type is Conclusion and the status is
**                      PEND then the user should get a message telling them the merge
**                      will not occure because of a pending closure.  The message should
**                      say "The merge to (or from) case has been saved and submitted for
**                      closure. Please wait for approval of pending event or invalidate
**                      the approval and resubmit for case merge."
**                      2)  If two cases are pending a merge and one of the cases is saved
**                      and submitted, stop the save and submit by displaying an edit on
**                      the conclusion page.  The message should indicate that the user
**                      should cancel the merge or wait for the merge to process before
**                      saving and submitting. This pertains to CPS INV Conclusion Save
**                      and Submit only.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv14s {
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String RISK_ASSMT_NARR = "RISK_ASSMT_NARR";
    /*
    ** IRA2001 - Added a definition for the new IRA
    **           narrative table
    */
    public static final String IRA_NARRATIVE = "RISK_ASSMT_IRA_NARR";
    public static final String IRA_ASSMT_TASK = "2295";
    /*
    ** IRA2001 END
    */
    public static final String TXT_NARR_EXISTS = "NARRATIVE";
    public static final String ASSESS_EVENT_TYPE = "ASM";
    /*******************************/
    
    /* check that all events are COMP before closing stage */
    public static final String EVENT_STATUS_COMP = "COMP";
    public static final String EVENT_STATUS_PEND = "PEND";
    public static final String EVENT_STATUS_APRV = "APRV";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String NULL_STRING = "";
    public static final String RISK_ASSMNT_TASK = "2290";
    public static final int INITIAL_PAGE = 1;
    public static final char INDICATOR_IMPACT = 'M';
    /* Sir#15712 - ochu */
    public static final String PERSON_STAGE_ROLE_UK = "UK";
    public static final String PERSON_TYPE_PRN = "PRN";
    public static final int NUMBER = 1;
    /* SIR 15956 */
    public static final char PERSON_GENDER_UNK = 'U';
    static int transactionflag = - 1;
    CINV14SO CINV14S(CINV14SI cinv14si) {
        CINV14SO cinv14so = new CINV14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        
        
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CINV14S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        //SIR 17596 - IMPACT: Added code to make Service Transaction aware
        // Need to check if the transaction is already in progress as this service is called
        // from another service.
        //SIR 18602
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINV14S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            // This is the case of transaction in progress.
            //So we should not start a new one
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV14S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV14S\n");
            bTransactionStarted = true;
        }
        
        /* SIR# 22665  */
        Pchar bCasePending = new Pchar();
        bCasePending.value = 0;
        rc = ARC_PRFServiceStartTime_TUX(cinv14si.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = ARC_UTLGetDateAndTime(cinv14so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        if (cinv14si.getUlIdEvent() != 0) {
            rc = CallCINV10D(cinv14si, cinv14so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
        }
        else {
            rc = Ccmn02u.CallCINV95D(cinv14si, cinv14so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_NO_ROWS_RETURNED:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
        }
        if (Messages.MSG_NO_ROWS_RETURNED != rc) {
            if (cinv14si.getUlIdEvent() != 0) {
                rc = Ccmn01u.CallCCMN45D(cinv14si, cinv14so, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
            rc = Cinv54s.CallCSYS15D(cinv14si, cinv14so, pServiceStatus);
            switch (rc) {
                    
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_INV_NOT_BEGUN:
                    
                    //  Start Performance Timer
                    rc = Messages.MSG_INV_NOT_BEGUN;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            if (WtcHelperConstants.ARC_SUCCESS == rc) {
                rc = CallCINV14D(cinv14si, cinv14so, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                if (cinv14so.getROWCINV14DOG00().getUlIdEvent() != 0 && cinv14so.getROWCINV14DOG00().getUlIdEvent() != 0) {
                    rc = CallCSYS13D(cinv14so, cinv14so, cinv14si.getArchInputStruct().getSzUserId() , pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                }
                
                //  Call CheckStageEventStatus
                rc = Ccmn80s.CallCINT40D(cinv14si, cinv14so, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                        
                        
                }
                rc = Ccfc40s.CallCheckCasePending(cinv14so.getROWCINV14SOG00().getUlIdCase() , cinv14so, bCasePending, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                rc = Cinv17s.CallCLSC84D(cinv14si, cinv14so, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                    case SUCCESS:
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
        }
        
        
        /*
        ** Call CAUD10D
        */
        rc = CallCINT20D(cinv14si, cinv14so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        rc = Ccmn03u.CallCLSC18D(cinv14si, cinv14so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                break;
                
            default :
                
                
                // BEGIN TUX/XML: Declare XML variables
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        rc = CallCINVD3D(cinv14si, cinv14so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv14si.getArchInputStruct() , cinv14so.getArchOutputStruct());
        /*
        ** Begin SIR 766
        ** If the person is being added to the system and he/she has a
        ** termination date, add him/her as a Former Employee not Employee.
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV14S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                // Retrieve the Current Date
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV14S\n");
        }
        return cinv14so;
    }

    static int CallCINV10D(CINV14SI pInputMsg585, CINV14SO pOutputMsg537, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables 
        */
        int rc = 0;
        /*
        ** Declare local variables
        */
        CINV10DI pCINV10DInputRec = null;
        CINV10DO pCINV10DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV10DInputRec = new CINV10DI();
        
        pCINV10DOutputRec = new CINV10DO();
        pCINV10DInputRec.setArchInputStruct(pInputMsg585.getArchInputStruct());
        pCINV10DInputRec.setUlIdEvent(pInputMsg585.getUlIdEvent());
        rc = cinv10dQUERYdam(sqlca, pCINV10DInputRec, pCINV10DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg537.getROWCINV10DOG00().setTsLastUpdate(pCINV10DOutputRec.getTsLastUpdate());
                pOutputMsg537.getROWCINV10DOG00().setUlIdEvent(pInputMsg585.getUlIdEvent());
                pOutputMsg537.getROWCINV10DOG00().setDtDtCPSInvstDtlAssigned(pCINV10DOutputRec.getDtDtCPSInvstDtlAssigned());
                
                pOutputMsg537.getROWCINV10DOG00().setDtDtCPSInvstDtlBegun(pCINV10DOutputRec.getDtDtCPSInvstDtlBegun());
                pOutputMsg537.getROWCINV10DOG00().setDtDtCpsInvstDtlComplt(pCINV10DOutputRec.getDtDtCpsInvstDtlComplt());
                pOutputMsg537.getROWCINV10DOG00().setCdCpsOverallDisptn(pCINV10DOutputRec.getCdCpsOverallDisptn());
                pOutputMsg537.getROWCINV10DOG00().setBIndCpsInvstSafetyPln(pCINV10DOutputRec.getBIndCpsInvstSafetyPln());
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pOutputMsg537.getROWCINV10DOG00().setCIndCpsInvstDtlRaNa(pCINV10DOutputRec.getCIndCpsInvstDtlRaNa());
                pOutputMsg537.getROWCINV10DOG00().setSzCdCpsInvstDtlFamIncm(pCINV10DOutputRec.getSzCdCpsInvstDtlFamIncm());
                pOutputMsg537.getROWCINV10DOG00().setBIndCpsInvstEaConcl(pCINV10DOutputRec.getBIndCpsInvstEaConcl());
                pOutputMsg537.getROWCINV10DOG00().setCIndCpsInvstAbbrv(pCINV10DOutputRec.getCIndCpsInvstAbbrv());
                pOutputMsg537.getROWCINV10DOG00().setBIndCpsInvstCpsLeJointContact(pCINV10DOutputRec.getBIndCpsInvstCpsLeJointContact());
                pOutputMsg537.getROWCINV10DOG00().setSzCdCpsInvstCpsLeJointContact(pCINV10DOutputRec.getSzCdCpsInvstCpsLeJointContact());
                pOutputMsg537.getROWCINV10DOG00().setSzTxtCpsInvstCpsLeJointContact(pCINV10DOutputRec.getSzTxtCpsInvstCpsLeJointContact());
                pOutputMsg537.getROWCINV10DOG00().setBIndVictimTaped(pCINV10DOutputRec.getBIndVictimTaped());
                pOutputMsg537.getROWCINV10DOG00().setSzCdVictimTaped(pCINV10DOutputRec.getSzCdVictimTaped());
                pOutputMsg537.getROWCINV10DOG00().setSzTxtVictimTaped(pCINV10DOutputRec.getSzTxtVictimTaped());
                pOutputMsg537.getROWCINV10DOG00().setUlIdStage(pCINV10DOutputRec.getUlIdStage());
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCINV95D(CINV14SI pInputMsg586, CINV14SO pOutputMsg538, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV95DInputRec = new CINV95DI();
        
        pCINV95DOutputRec = new CINV95DO();
        pCINV95DInputRec.setArchInputStruct(pInputMsg586.getArchInputStruct());
        pCINV95DInputRec.setUlIdStage(pInputMsg586.getUlIdStage());
        
        /*
        ** Call CINV51D
        */
        rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
        
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg538.getROWCINV10DOG00().setTsLastUpdate(pCINV95DOutputRec.getTsLastUpdate());
                pOutputMsg538.getROWCINV10DOG00().setUlIdEvent(pCINV95DOutputRec.getUlIdEvent());
                pOutputMsg538.getROWCINV10DOG00().setDtDtCPSInvstDtlIntake(pCINV95DOutputRec.getDtDtCPSInvstDtlIntake());
                pOutputMsg538.getROWCINV10DOG00().setDtDtCPSInvstDtlAssigned(pCINV95DOutputRec.getDtDtCPSInvstDtlAssigned());
                pOutputMsg538.getROWCINV10DOG00().setDtDtCPSInvstDtlBegun(pCINV95DOutputRec.getDtDtCPSInvstDtlBegun());
                pOutputMsg538.getROWCINV10DOG00().setDtDtCpsInvstDtlComplt(pCINV95DOutputRec.getDtDtCpsInvstDtlComplt());
                pOutputMsg538.getROWCINV10DOG00().setCdCpsOverallDisptn(pCINV95DOutputRec.getCdCpsOverallDisptn());
                pOutputMsg538.getROWCINV10DOG00().setBIndCpsInvstSafetyPln(pCINV95DOutputRec.getBIndCpsInvstSafetyPln());
                pOutputMsg538.getROWCINV10DOG00().setCIndCpsInvstDtlRaNa(pCINV95DOutputRec.getCIndCpsInvstDtlRaNa());
                pOutputMsg538.getROWCINV10DOG00().setSzCdCpsInvstDtlFamIncm(pCINV95DOutputRec.getSzCdCpsInvstDtlFamIncm());
                pOutputMsg538.getROWCINV10DOG00().setBIndCpsInvstEaConcl(pCINV95DOutputRec.getBIndCpsInvstEaConcl());
                pOutputMsg538.getROWCINV10DOG00().setBIndCpsInvstCpsLeJointContact(pCINV95DOutputRec.getBIndCpsInvstCpsLeJointContact());
                
                pOutputMsg538.getROWCINV10DOG00().setSzCdCpsInvstCpsLeJointContact(pCINV95DOutputRec.getSzCdCpsInvstCpsLeJointContact());
                
                pOutputMsg538.getROWCINV10DOG00().setSzTxtCpsInvstCpsLeJointContact(pCINV95DOutputRec.getSzTxtCpsInvstCpsLeJointContact());
                pOutputMsg538.getROWCINV10DOG00().setBIndVictimTaped(pCINV95DOutputRec.getBIndVictimTaped());
                pOutputMsg538.getROWCINV10DOG00().setSzCdVictimTaped(pCINV95DOutputRec.getSzCdVictimTaped());
                pOutputMsg538.getROWCINV10DOG00().setSzTxtVictimTaped(pCINV95DOutputRec.getSzTxtVictimTaped());
                
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pOutputMsg538.getROWCINV10DOG00().setUlIdStage(pCINV95DOutputRec.getUlIdStage());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCCMN45D(CINV14SI pInputMsg587, CINV14SO pOutputMsg539, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i307 = 0;
        int rc = 0;/* Return code  */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input Structure
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg587.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg587.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                pOutputMsg539.getROWCCMN45DO().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pOutputMsg539.getROWCCMN45DO().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                pOutputMsg539.getROWCCMN45DO().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                pOutputMsg539.getROWCCMN45DO().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pOutputMsg539.getROWCCMN45DO().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg539.getROWCCMN45DO().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pOutputMsg539.getROWCCMN45DO().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                pOutputMsg539.getROWCCMN45DO().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                pOutputMsg539.getROWCCMN45DO().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCSYS15D(CINV14SI pInputMsg588, CINV14SO pOutputMsg540, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i308 = 0;
        int rc = 0;/* Return code */
        CSYS15DI pCSYS15DInputRec = null;
        CSYS15DO pCSYS15DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCSYS15DInputRec = new CSYS15DI();
        
        pCSYS15DOutputRec = new CSYS15DO();
        pCSYS15DInputRec.setArchInputStruct(pInputMsg588.getArchInputStruct());
        pCSYS15DInputRec.setUlIdStage(pInputMsg588.getUlIdStage());
        rc = csys15dQUERYdam(sqlca, pCSYS15DInputRec, pCSYS15DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                // 
                // END CAUD15D
                // 
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (DateHelper.NULL_DATE == pCSYS15DOutputRec.getDtDTContactOccurred().year && DateHelper.NULL_DATE == pOutputMsg540.getROWCINV10DOG00().getDtDtCPSInvstDtlBegun().year) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_INV_NOT_BEGUN;
                    rc = Messages.MSG_INV_NOT_BEGUN;
                }
                //  CASE 2: A case created using CAPS & a contact was found
                else if (DateHelper.NULL_DATE != pCSYS15DOutputRec.getDtDTContactOccurred().year) {
                    pOutputMsg540.getROWCINV10DOG00().setDtDtCPSInvstDtlBegun(pCSYS15DOutputRec.getDtDTContactOccurred());
                    
                    
                    //  Call CINT13D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                //  CASE 3: A case created from converted data.  DtInvstDtlBegun
                // was populated from CINV10D
                else {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
            case NO_DATA_FOUND:
                
                if (DateHelper.NULL_DATE == pOutputMsg540.getROWCINV10DOG00().getDtDtCPSInvstDtlBegun().year) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_INV_NOT_BEGUN;
                    rc = Messages.MSG_INV_NOT_BEGUN;
                }
                else // (NULL_DATE != pOutputMsg->
                // ROWCINV10DOG00.dtDtCPSInvstDtlBegun.year)
                {
                    
                    
                    //  Call CINT12D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
                //  END SIR# 4329
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCINV14D(CINV14SI pInputMsg589, CINV14SO pOutputMsg541, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i309 = 0;
        int rc = 0;
        
        int counter = 0;
        CINV14DI pCINV14DInputRec = null;
        CINV14DO pCINV14DOutputRec = null;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV14DInputRec = new CINV14DI();
        
        pCINV14DOutputRec = new CINV14DO();
        pCINV14DInputRec.setArchInputStruct(pInputMsg589.getArchInputStruct());
        pCINV14DInputRec.setUlIdStage(pInputMsg589.getUlIdStage());
        
        /*
        ** Call CSUB40U
        */
        rc = cinv14dQUERYdam(sqlca, pCINV14DInputRec, pCINV14DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg541.getROWCINV14DOG00().setUlIdEvent(pCINV14DOutputRec.getUlIdEvent());
                pOutputMsg541.getROWCINV14DOG00().setUlIdStage(pCINV14DOutputRec.getUlIdStage());
                pOutputMsg541.getROWCINV14DOG00().setTsLastUpdate(pCINV14DOutputRec.getTsLastUpdate());
                pOutputMsg541.getROWCINV14DOG00().setCdRiskAssmtPurpose(pCINV14DOutputRec.getCdRiskAssmtPurpose());
                pOutputMsg541.getROWCINV14DOG00().setSzCdRiskAssmtRiskFind(pCINV14DOutputRec.getSzCdRiskAssmtRiskFind());
                pOutputMsg541.getROWCINV14DOG00().setSzCdRiskAssmtApAccess(pCINV14DOutputRec.getSzCdRiskAssmtApAccess());
                pOutputMsg541.getROWCINV14DOG00().setCIndRiskAssmtIntranet(pCINV14DOutputRec.getCIndRiskAssmtIntranet());
                pOutputMsg541.getROWCINV14DOG00().setSzCdRiskFactorCateg(pCINV14DOutputRec.getSzCdRiskFactorCateg());
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        if (pOutputMsg541.getROWCINV14DOG00().getUlIdEvent() != 0) {
            pCCMN87DInputRec = new CCMN87DI();
            pCCMN87DOutputRec = new CCMN87DO();
            
            pCCMN87DInputRec.setUlIdStage(pOutputMsg541.getROWCINV14DOG00().getUlIdStage());
            pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(ASSESS_EVENT_TYPE);
            pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(50);
            pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    for (counter = 0;counter < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();counter++) {
                        
                        if ((!(RISK_ASSMNT_TASK.compareTo(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdTask()) != 0) ||!(IRA_ASSMT_TASK.compareTo(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdTask()) != 0)) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdEventStatus().compareTo(EVENT_STATUS_COMP) != 0) ||!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdEventStatus().compareTo(EVENT_STATUS_PEND) != 0) ||!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdEventStatus().compareTo(EVENT_STATUS_APRV) != 0))) {
                            pOutputMsg541.getROWCINV14DOG00().setSzCdRiskAssmtRiskFind(NULL_STRING);
                            
                            break;
                        }
                    }
                    break;
                    
                case NO_DATA_FOUND:
                    
                    
                    //  Call CCMN01U
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    return rc;
                    
                    //  SIR 22100 - memory freed twice
                    // Free memory for Post Event Input and Output structures
                    // free(pCCMN01UInputRec);
                    // free(pCCMN01UOutputRec);
                    
                    break;
            }
        }
        return rc;
    }

    static int CallCSYS13D(CINV14SO pInputMsg590, CINV14SO pOutputMsg542, String userId, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSYS13DI pCSYS13DInputRec = null;
        CSYS13DO pCSYS13DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS13DInputRec = new CSYS13DI();
        
        pCSYS13DOutputRec = new CSYS13DO();
        pCSYS13DInputRec.setUlIdEvent(pInputMsg590.getROWCINV14DOG00().getUlIdEvent());
        if ((INDICATOR_YES == pOutputMsg542.getROWCINV14DOG00().getCIndRiskAssmtIntranet()[0]) || (INDICATOR_IMPACT == pOutputMsg542.getROWCINV14DOG00().getCIndRiskAssmtIntranet()[0])) {
            pCSYS13DInputRec.setSzSysTxtTablename(IRA_NARRATIVE);
        }
        else {
            pCSYS13DInputRec.setSzSysTxtTablename(RISK_ASSMT_NARR);
        }
        pCSYS13DInputRec.getArchInputStruct().setSzUserId(userId);
        rc = csys13dQUERYdam(sqlca, pCSYS13DInputRec, pCSYS13DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg542.setSzScrTxtNarrStatus(TXT_NARR_EXISTS);
                pOutputMsg542.setTsLastUpdate(pCSYS13DOutputRec.getTsLastUpdate());
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg542.setSzScrTxtNarrStatus("");
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                // Process utility fuction failure
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCINT40D(CINV14SI pInputMsg591, CINV14SO pOutputMsg543, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
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
        pCINT40DInputRec.setArchInputStruct(pInputMsg591.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(pInputMsg591.getUlIdStage());
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg543.getROWCINV14SOG00().setUlIdStage(pCINT40DOutputRec.getUlIdStage());
                pOutputMsg543.getROWCINV14SOG00().setTmSysTmStageClose(pCINT40DOutputRec.getTmSysTmStageClose());
                pOutputMsg543.getROWCINV14SOG00().setTmSysTmStageStart(pCINT40DOutputRec.getTmSysTmStageStart());
                pOutputMsg543.getROWCINV14SOG00().setUlIdUnit(pCINT40DOutputRec.getUlIdUnit());
                pOutputMsg543.getROWCINV14SOG00().setBIndStageClose(pCINT40DOutputRec.getBIndStageClose());
                pOutputMsg543.getROWCINV14SOG00().setSzNmStage(pCINT40DOutputRec.getSzNmStage());
                
                //## BEGIN TUX/XML: Declare XML variables 
                pOutputMsg543.getROWCINV14SOG00().setSzCdStage(pCINT40DOutputRec.getSzCdStage());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageClassification(pCINT40DOutputRec.getSzCdStageClassification());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageCnty(pCINT40DOutputRec.getSzCdStageCnty());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageCurrPriority(pCINT40DOutputRec.getSzCdStageCurrPriority());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageInitialPriority(pCINT40DOutputRec.getSzCdStageInitialPriority());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageProgram(pCINT40DOutputRec.getSzCdStageProgram());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageReasonClosed(pCINT40DOutputRec.getSzCdStageReasonClosed());
                pOutputMsg543.getROWCINV14SOG00().setDtDtStageClose(pCINT40DOutputRec.getDtDtStageClose());
                pOutputMsg543.getROWCINV14SOG00().setDtDtStageStart(pCINT40DOutputRec.getDtDtStageStart());
                pOutputMsg543.getROWCINV14SOG00().setUlIdCase(pCINT40DOutputRec.getUlIdCase());
                pOutputMsg543.getROWCINV14SOG00().setUlIdSituation(pCINT40DOutputRec.getUlIdSituation());
                pOutputMsg543.getROWCINV14SOG00().setSzTxtStageClosureCmnts(pCINT40DOutputRec.getSzTxtStageClosureCmnts());
                pOutputMsg543.getROWCINV14SOG00().setSzTxtStagePriorityCmnts(pCINT40DOutputRec.getSzTxtStagePriorityCmnts());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageRegion(pCINT40DOutputRec.getSzCdStageRegion());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageRsnPriorityChgd(pCINT40DOutputRec.getSzCdStageRsnPriorityChgd());
                pOutputMsg543.getROWCINV14SOG00().setSzCdStageType(pCINT40DOutputRec.getSzCdStageType());
                pOutputMsg543.getROWCINV14SOG00().setTsLastUpdate(pCINT40DOutputRec.getTsLastUpdate());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCLSC84D(CINV14SI pInputMsg592, CINV14SO pOutputMsg544, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        
        pCLSC84DInputRec.setUlIdStage(pOutputMsg544.getROWCINV14SOG00().getUlIdStage());
        pCLSC84DInputRec.setArchInputStruct(pInputMsg592.getArchInputStruct());
        
        rc = clsc84dQUERYdam(sqlca, pCLSC84DInputRec, pCLSC84DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg544.getROWCINV10DOG00().setDtDtCPSInvstDtlIntake(pCLSC84DOutputRec.getDtDtIncomingCall());
                pOutputMsg544.getROWCINV10DOG00().setUlIdPriorStage(pCLSC84DOutputRec.getUlIdPriorStage());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCINVD3D(CINV14SI pInputMsg593, CINV14SO pOutputMsg545, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVD3DI pCINVD3DInputRec = null;
        CINVD3DO pCINVD3DOutputRec = null;
        pOutputMsg545.setBIndPhabSxabAllegExist(Cint14s.INDICATOR_NO);
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVD3DInputRec = new CINVD3DI();
        
        pCINVD3DOutputRec = new CINVD3DO();
        
        pCINVD3DInputRec.setUlIdStage(pInputMsg593.getUlIdStage());
        pCINVD3DInputRec.setArchInputStruct(pInputMsg593.getArchInputStruct());
        rc = cinvd3dQUERYdam(sqlca, pCINVD3DInputRec, pCINVD3DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //## END TUX/XML: Turn the XML buffer into an input message struct 
                
                
                
                if (0 != pCINVD3DOutputRec.getUsSysNbrIdAllgtn()) {
                    pOutputMsg545.setBIndPhabSxabAllegExist(INDICATOR_YES);
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                // 
                // End Call to ToDo AUD Dam - Todo Common function
                // 
                
                
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
                
                
        }
        return rc;
    }

    static int CallCINT20D(CINV14SI pInputMsg594, CINV14SO pOutputMsg546, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT20DI pCINT20DInputRec = null;
        CINT20DO pCINT20DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT20DInputRec = new CINT20DI();
        
        pCINT20DOutputRec = new CINT20DO();
        pCINT20DInputRec.setUlIdStage(pInputMsg594.getUlIdStage());
        pCINT20DInputRec.setSzCdStagePersRole(PERSON_STAGE_ROLE_UK);
        pCINT20DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        pCINT20DInputRec.setArchInputStruct(pInputMsg594.getArchInputStruct());
        
        /*
        ** Call CheckStageEventStatus
        */
        rc = cint20dQUERYdam(sqlca, pCINT20DInputRec, pCINT20DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (0 != pCINT20DOutputRec.getUlIdPerson()) {
                    pOutputMsg546.getArchOutputStruct().setUlRowQty(NUMBER);
                }
                else {
                    pOutputMsg546.getArchOutputStruct().setUlRowQty(0);
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;// break for CASE SUCCESS in CSEC58D switch
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        return rc;
    }

    
    static int CallCLSC18D(CINV14SI pInputMsg595, CINV14SO pOutputMsg547, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i310 = 0;
        
        /*
        ** Declare local variables
        */
        CLSC18DI pCLSC18DInputRec = null;
        CLSC18DO pCLSC18DOutputRec = null;
        pOutputMsg547.setBIndPrnUk(Cint14s.INDICATOR_NO);
        
        int bUnknownName = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC18DInputRec = new CLSC18DI();
        pCLSC18DOutputRec = new CLSC18DO();
        pCLSC18DInputRec.setArchInputStruct(pInputMsg595.getArchInputStruct());
        pCLSC18DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        
        pCLSC18DInputRec.setUlIdStage(pInputMsg595.getUlIdStage());
        
        //## BEGIN TUX/XML: Declare XML variables
        pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC18DO._CLSC18DO__ROWCLSC18DO_SIZE);
        rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                for (i310 = 0;(i310 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());++i310) {
                    bUnknownName = 0;// SIR 13532: Reset bUnknownName
                    // for each person in the loop
                    //  Populate Output Message if event list requested
                    if ((null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i310).getSzNmPersonFirst()[0]) && (null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i310).getSzNmPersonLast()[0])) {
                        bUnknownName = 1;
                    }
                    // 
                    // SIR 2551: The Outcome Matrix Event, Three-Month Review
                    // and Monthly Status Contact Events should not be
                    // passed back to the window if they are either NEW or
                    // IN_PROGRESS, since they would then be passed
                    // on to the ToDo window, which would update their status
                    // to Pending. Only COMPLETE and APPROVED events should
                    // be passed to the ToDo Window to be updated to
                    // PENDING.
                    // 
                    
                    //  SIR 3119
                    // Don't change the Service Authorization statuses either
                    // We want to let stage progression move them forward as
                    // is
                    if ((PERSON_GENDER_UNK == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i310).getCCdPersonSex() || INDICATOR_YES == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i310).getBIndPersonDobApprox()) && true != bUnknownName) {
                        pOutputMsg547.setBIndPrnUk(INDICATOR_YES);
                        break;
                    }
                }
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCheckCasePending(int ulIdCaseMerge1, CINV14SO pOutputMsg548, String pbCasePending, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        Pchar bLocalCasePending = new Pchar();
        bLocalCasePending.value = 0;
        
        CLSC68DI idCaseToInput = null;
        CLSC68DO idCaseToOutput = null;
        
        CLSC67DI idCaseFromInput = null;
        CLSC67DO idCaseFromOutput = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        idCaseToInput = new CLSC68DI();
        idCaseToOutput = new CLSC68DO();
        idCaseFromInput = new CLSC67DI();
        idCaseFromOutput = new CLSC67DO();
        
        /*
        ** Analyze error code
        */
        if ((idCaseFromInput == null) || (idCaseFromOutput == null) || (idCaseToInput == null) || (idCaseToOutput == null)) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        bLocalCasePending.value = pbCasePending.charAt(0);
        idCaseToInput.setUlIdCaseMergeTo(ulIdCaseMerge1);
        
        
        rc = CallCLSC68D(idCaseToInput, bLocalCasePending, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (!bLocalCasePending.value) {
            idCaseFromInput.setUlIdCaseMergeFrom(ulIdCaseMerge1);
            rc = CallCLSC67D(idCaseFromInput, bLocalCasePending, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (bLocalCasePending.value) {
            pOutputMsg548.setCIndCaseMergePending(FND_YES);
        }
        else {
            pOutputMsg548.setCIndCaseMergePending(FND_NO);
        }
        return rc;
    }

    
    static int CallCLSC68D(CLSC68DI pbCLSC68DInputRec, String pbCasePending, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        int i311 = 0;
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
        pCLSC68DInputRec.setArchInputStruct(Csys08s.pInputMsg.getArchInputStruct());
        pCLSC68DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC68DO._CLSC68DO__ROWCLSC68DO_SIZE);
        pCLSC68DInputRec.setUlIdCaseMergeTo(pbCLSC68DInputRec.getUlIdCaseMergeTo());
        
        /*
        ** Call DAM
        */
        rc = clsc68dQUERYdam(sqlca, pCLSC68DInputRec, pCLSC68DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                // RIOSJA, SIR 22970
            case WtcHelperConstants.SQL_SUCCESS:
                for (i311 = 0;i311 <= pCLSC68DOutputRec.getArchOutputStruct().getUlRowQty();i311++) {
                    if (pCLSC68DOutputRec.getROWCLSC68DO_ARRAY().getROWCLSC68DO(i311).getCIndCaseMergePending() == 'M') {
                        pbCasePending = CStringUtils.setCharAt(pbCasePending, 0, true);
                    }
                }
                break;
            case NO_DATA_FOUND:
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCLSC67D(CLSC67DI pbCLSC67DInputRec, String pbCasePending, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        int i312 = 0;
        CLSC67DI pCLSC67DInputRec = null;/* input record  */
        CLSC67DO pCLSC67DOutputRec = null;/* output record */
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC67DInputRec = new CLSC67DI();
        
        
        pCLSC67DOutputRec = new CLSC67DO();
        pCLSC67DInputRec.setArchInputStruct(Csys08s.pInputMsg.getArchInputStruct());
        pCLSC67DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC67DO._CLSC67DO__ROWCLSC67DO_SIZE);
        pCLSC67DInputRec.setUlIdCaseMergeFrom(pbCLSC67DInputRec.getUlIdCaseMergeFrom());
        rc = clsc67dQUERYdam(sqlca, pCLSC67DInputRec, pCLSC67DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i312 = 0;i312 <= pCLSC67DOutputRec.getArchOutputStruct().getUlRowQty();i312++) {
                    if (pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(i312).getCIndCaseMergePending() == 'M') {
                        pbCasePending = CStringUtils.setCharAt(pbCasePending, 0, true);
                    }
                }
                break;
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
