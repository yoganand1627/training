package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN27DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN28DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN30DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN79DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN79DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC84DO;
/***************************************************************************
**
** Module File:   ccmn80s.src
**
** Service Name:  ccmn80s
**
** Description:   This service will retrieve information needed in order
**                to assign an employee to a stage
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12 Jan 95
**
** Original Programmer:   Bart McCleskey/Andersen Consulting
**
** Current  Programmer:   Mary Sladewski
**
** Archive Information: $Revision:   1.7  $
**                      $Date:   15 Dec 1999 09:31:34  $
**                      $Modtime:   02 Nov 1999 10:03:28  $
**                      $Author:   pvcs  $
**
** Change History:
** Date     Programmer  Description
** -------- ----------  -------------------------------------------------
** __Mar95  mcclesbh    Initial check-in.
** 04Apr95  pitmangs    SIR 463 - Removed time manipulation from GetRC
**                      function; Added logic to only call GetRC if
**                      it is not normal business hours; Added Macros.
** 13Apr95  sladewmf    SIR #437: Modified CallCCMN79D Callback to set
**                      pServiceStatus->severity    = FND_WARNING; and
**                      pServiceStatus->explan_code = MSG_CMN_ASSIGN_ON_CALL;
**                      when the DAM returns SQL_NOT_FOUND.
** 20Apr95  sladewmf    Implemented new error handling changes as outlined
**                      in the Apr19 18:35 1995 version of svcshell.src
** 10May95  sladewmf    Implemented new error handling changes as outlined
**                      in the May05 08:23 1995 version of svcshell.src
**                      (removed references to PrepServiceExit),
**                      and adjusted function CallCCMN27D
**                      (removed references to CdUnitMemberRole).
** 13May95  sladewmf    Removed references to CallCCMN31D function
**                      (ccmn31d.pc is now called from service ccmn48s.src).
** 31May95  sladewmf    Made tech review changes.
** 13Jun95  sladewmf    Corrected iHour and t.tm_min lines ( added "- '0'").
**  08/17/95    KRD     SIR 1218 - added code to CallCCMN28DA to copy ID
**                      UNIT to the output message.
** 11/03/95 ELLIOTSL    ERR #2029: Modified CallCCMN27D to set
**                      pServiceStatus->severity    = FND_WARNING; and
**                      pServiceStatus->explan_code =
**                          MSG_CMN_NO_STAFF_IN_UNIT;
**                      when the DAM returns SQL_NOT_FOUND.
**
** 01/24/96 BRUCKMK     SIR 2226: Added DAM CINT40D to retrieve a stage's
**                      ID_UNIT, so that we now know what the PRIMARY
**                      worker's assigned unit was at the time of the
**                      SAVE on the Assign window.
** 5/7/96   MAXHAMKJ    SIR 5245: Populate array-fetch-related
**                      archinputstruct elements.
**                      Changed time manipulation so that two RCs aren't
**                      returned when on-call schedule brought up
**                      between 12:00 PM and 12:59 PM.
**  26Jun96   sladewmf  SIR #10240: Added an if statement after the 2 calls to
**                      mktime to adjust t.tm_hour (if daylight savings time).
** 12/11/96 durang      SIR 11432: Modified CCMN80S.       This was
**                      preventing ON CALL VIEW to retrieve the routing
**                      coordinator for the next day at or after 5 p.m.
**                      Instead, the RC would be retrieved only after
**                      6 p.m.
** 02/25/97  YANTISTK   SIR 11870 - Added a DAM to retrieve a row from the
**                      Workload table based on the Id_Stage(s) passed in.
**                      This is to prevent a rare data access error from
**                      occurring when an I&R has been closed by one worker
**                      and then another worker tries to assign it without
**                      refreshing their workload.
** 03/19/97  ODONNERJ   SIR# 11870 - Added a if condition to never check for
**                      more than NUMARRLBASSIGNMENTSROWS. This prevents
**                      checking the if condition outside the bounds of the
**                      ulIdStage array.
** 03/25/07  ODONNERJ   SIR# 11870 - Added ulRowQty to ccmn80si.h and si.xlt
**                      in order to provide an exact count of rows to the
**                      Assign service.  This prevents a data access error
**                      whenever the Assign window is called twice in a row
**                      and the user assigns less rows the second time then
**                      the first time.
** 01/10/03  SRINI D    IMPACT - Changed the function CallCCMN29D to pass
**                      ulPageSizeNbr = 10 always to fix the pagination problem
**                      on the client. Modified as per Byron Jacob.
**
** 07/28/05  wadesa     SIR 23802 - Added the StageType to the marshalling to
**                      return this parameter from the ccmn29d DAM.
** 8/8/2005 gerryc      SIR 22556 - allow users to do primary and secondary
**                      block assignments
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn80s {
    
    /**************************************************************************
    ** Constants
    ***************************************************************************/
    public static final char ON_CALL_VIEW = 'O';
    public static final char FULL_UNITS_VIEW = 'F';
    public static final char PHONE = 'P';
    public static final int SUNDAY = 0;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    public static final int FIVE_PM = 17;
    public static final int EIGHT_AM = 8;
    public static final String EIGHT_AM_SPELLED_OUT = "08:00 AM";
    public static final String ROUTER = "RC";
    
    /* ERR #2029: To make it work until the message is defined.
    */
    public static final int MSG_CMN_NO_STAFF_IN_UNIT = 2100;
    CCMN80SO CCMN80S(CCMN80SI ccmn80si) {
        boolean goto_END = false;
        CCMN80SO ccmn80so = new CCMN80SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        char bFirstTime = 1;
        
        int iHour = 0;
        int I = 0;
        Pint tempulIdOnCall = new Pint();
        String tempTime = new String();
        Tm t;
        FndInt3date tempDate = null;
        int n = 0;/*SIR 11870 loop counter*/
        
        rc = ARC_PRFServiceStartTime_TUX(ccmn80si.getArchInputStruct());
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        
        /*
        ** SIR 11870 - Add for loop and Dam CSEC84D
        ** Part 2: PROD CHANGE -Change i to n since xdb can't debug I and i and
        ** Added a check to ensure that we never check our if condition
        ** on unnallocated arrays. n<_CCMN80SI__ULIDSTAGE_SIZE.
        ** Part 3: Change for loop to use pInputMsg->ulRowQty
        */
        
        /*   for(n=0;
        **       ( (pInputMsg->ulIdStage[n] > 0)
        **       &&(n < _CCMN80SI__ULIDSTAGE_SIZE ));
        **       n ++)
        */
        for (n = 0;n < ccmn80si.getUlRowQty();n++) {
            rc = CallCSEC84D(ccmn80si, ccmn80so, n, pServiceStatus);
            switch (rc) {
                    
                case Messages.MSG_CMN_NOT_ON_WKLD:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (SUCCESS != rc) {
                // stop performance timer for service
                ARC_PRFServiceStopTime_TUX(ccmn80si.getArchInputStruct() , ccmn80so.getArchOutputStruct());
                rc = SUCCESS;
                goto_END = true;
                
            }
            
            if (goto_END) {
                break;
            }
        }
        
        if (!(goto_END)) {
            
            //  Analyze return code
            switch (ccmn80si.getArchInputStruct().getCReqFuncCd()) {
                case FULL_UNITS_VIEW:
                    rc = CallCCMN27D(ccmn80si, ccmn80so, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case MSG_CMN_NO_STAFF_IN_UNIT:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    break;
                case ON_CALL_VIEW:
                    
                    //  Call DAM
                    rc = ARC_UTLGetDateAndTime(tempDate, tempTime);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    rc = CallCCMN79D(ccmn80si, ccmn80so, tempulIdOnCall, tempTime, tempDate, bFirstTime, pServiceStatus);
                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                    
                    
                    
                    if (rc != WtcHelperConstants.ARC_SUCCESS) {
                        
                        //  Analyze error code
                        switch (rc) {
                            case Messages.MSG_CMN_ASSIGN_ON_CALL:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                    }
                    else // rc == ARC_SUCCESS  (CallCCMN79D)
                    {
                        rc = CallCCMN28D(ccmn80si, ccmn80so, tempulIdOnCall.value, pServiceStatus);
                        
                        if (rc != WtcHelperConstants.ARC_SUCCESS) {
                            switch (rc) {
                                    
                                case Messages.MSG_CMN_ASSIGN_ON_CALL_EMPTY:
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                        }
                        else // rc == ARC_SUCCESS  (CallCCMN28D)
                        {
                            t.getDate() = tempDate.day;
                            t.getMonth() = tempDate.month - 1;
                            t.getYear() = tempDate.year - 1900;
                            
                            //  normalize the time returned from the ARC_UTL function
                            // to allow it to be placed in the time structure t.
                            iHour = ((10 * ((int) tempTime.charAt(0) - '0')) + (1 * (tempTime[1]) - '0'));
                            if ((tempTime.charAt(6) == 'A') || (tempTime.charAt(6) == 'P' && iHour == 12)) {
                                t.getHours() = iHour;
                            }
                            else if (tempTime.charAt(6) == 'P') {
                                t.getHours() = iHour + 12;
                            }
                            t.getMinutes() = ((10 * ((int) tempTime.charAt(3) - '0')) + (1 * (tempTime[4]) - '0'));
                            t.getTime();
                            if (t.tm_isdst > 0) {
                                t.getHours()--;
                            }
                            
                            //  If Date CaseClosed is Null the CaseCld Indicator is set to No,
                            // which means the case is not closed.
                            // If there is a Date CaseClosed the CaseCld Indicator is set to Yes,
                            // which means the case is closed
                            if (((t.getHours() < EIGHT_AM) || (t.getHours() >= FIVE_PM)) || ((t.getDay() == SATURDAY) || (t.getDay() == SUNDAY))) {
                                
                                if (t.getHours() > FIVE_PM) {
                                    switch (t.getDay()) {
                                        case FRIDAY:
                                            t.getDate() += 3;
                                            
                                            
                                            
                                            break;
                                            
                                        case SATURDAY:
                                            t.getDate() += 2;
                                            
                                            break;
                                            
                                        default :
                                            t.getDate()++;
                                            
                                            break;
                                    }
                                }
                                if (t.getHours() < EIGHT_AM) {
                                    
                                    //  Analyze return code
                                    switch (t.getDay()) {
                                        case SATURDAY:
                                            t.getDate() += 2;
                                            
                                            break;
                                        case SUNDAY:
                                            t.getDate()++;
                                            
                                            break;
                                            
                                        default :
                                            
                                            break;
                                    }
                                }
                                t.getTime();
                                if (t.tm_isdst > 0) {
                                    t.getHours()--;
                                }
                                
                                //  Convert the returned date into the FND_INT3DATE
                                // tempDate structure
                                tempDate.day = t.getDate();
                                tempDate.month = t.getMonth() + 1;
                                tempDate.year = t.getYear() + 1900;
                                tempTime = EIGHT_AM_SPELLED_OUT;
                                
                                //  set bFirstTime to FALSE
                                // so that the information in the ROWCCMN79DO
                                // structure (which was copied into the OutputMsg
                                // the first time 79d was called, when bFirstTime
                                // was equal to TRUE) is not over-written.
                                bFirstTime = 0;
                                
                                //  Call DAM
                                rc = CallCCMN79D(ccmn80si, ccmn80so, tempulIdOnCall, tempTime, tempDate, bFirstTime, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        rc = CallCCMN28DA(ccmn80si, ccmn80so, tempulIdOnCall.value, pServiceStatus);
                                        
                                        break;
                                    case Messages.MSG_CMN_ASSIGN_ON_CALL:
                                        pServiceStatus.severity = SUCCESS;
                                        pServiceStatus.explan_code = SUCCESS;
                                        rc = SUCCESS;
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                            }
                        }
                    }
                    
                    break;
                    
                default :
                    
                    break;
            }
            
            //  determine if Assign Processing is required
            // (indicated by 1 or more IdStage(s) being passed)
            Pint totalAssignmentsCtr = new Pint();
            totalAssignmentsCtr.value = 0;
            if (ccmn80si.getUlIdStage_ARRAY().getUlIdStage(0) > 0) {
                //  determine Assign Mode ( if only one stage id - regular,
                // more than 1 stage id - block transfer)
                
                for (I = 0;I < ccmn80si.getUlRowQty();I++) {
                    rc = CallCCMN29D(ccmn80si, ccmn80so, I, totalAssignmentsCtr, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                //  Call DAM
                rc = Ccmn85s.CallCINT40D(ccmn80si, ccmn80so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                ccmn80so.setUlRowQty2(totalAssignmentsCtr.value);
                ccmn80so.setBMoreDataInd2(0);
            }
            
            
            ARC_PRFServiceStopTime_TUX(ccmn80si.getArchInputStruct() , ccmn80so.getArchOutputStruct());
        }
        /* check if MergeFrom & MergeTo cases match previous record */
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
        return ccmn80so;
    }

    static int CallCCMN27D(CCMN80SI pInputMsg347, CCMN80SO pOutputMsg317, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i171 = 0;
        /* declare local variables */
        CCMN27DI pCCMN27DInputRec = null;
        CCMN27DO pCCMN27DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN27DInputRec = new CCMN27DI();
        
        pCCMN27DOutputRec = new CCMN27DO();
        pCCMN27DInputRec.setArchInputStruct(pInputMsg347.getArchInputStruct());
        pCCMN27DInputRec.setUlIdUnit(pInputMsg347.getUlIdUnit());
        rc = ccmn27dQUERYdam(sqlca, pCCMN27DInputRec, pCCMN27DOutputRec);
        
        
        
        /*
        ** Analyze return code for CAUD97
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                // populate Output Message
                for (i171 = 0;i171 < pCCMN27DOutputRec.getArchOutputStruct().getUlRowQty();i171++) {
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setSzNbrUnit(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getSzNbrUnit());
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setUlIdPerson(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getUlIdPerson());
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setUlIdUnit(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getUlIdUnit());
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setSzNmPersonFull(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getSzNmPersonFull());
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setSzBjnJob(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getSzBjnJob());
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setDtDtEmpLastAssigned(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getDtDtEmpLastAssigned());
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setTmScrTmEmpLastAssigned(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getTmScrTmEmpLastAssigned());
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setLNbrPhone(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getLNbrPhone());
                    
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setLNbrPhoneExtension(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getLNbrPhoneExtension());
                    pOutputMsg317.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i171).setSzNmOfficeName(pCCMN27DOutputRec.getROWCCMN27DO_ARRAY().getROWCCMN27DO(i171).getSzNmOfficeName());
                }
                pOutputMsg317.getArchOutputStruct().setUlRowQty(pCCMN27DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg317.getArchOutputStruct().setBMoreDataInd(pCCMN27DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = MSG_CMN_NO_STAFF_IN_UNIT;
                rc = MSG_CMN_NO_STAFF_IN_UNIT;
                break;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN28D(CCMN80SI pInputMsg348, CCMN80SO pOutputMsg318, int tempulIdOnCall, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i172 = 0;
        /* declare local variables */
        CCMN28DI pCCMN28DInputRec = null;
        CCMN28DO pCCMN28DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN28DInputRec = new CCMN28DI();
        
        pCCMN28DOutputRec = new CCMN28DO();
        pCCMN28DInputRec.setArchInputStruct(pInputMsg348.getArchInputStruct());
        pCCMN28DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN28DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN28DO._CCMN28DO__ROWCCMN28DO_SIZE);
        pCCMN28DInputRec.setUlIdOnCall(tempulIdOnCall);
        
        rc = ccmn28dQUERYdam(sqlca, pCCMN28DInputRec, pCCMN28DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CMN_ASSIGN_ON_CALL_EMPTY;
                    rc = Messages.MSG_CMN_ASSIGN_ON_CALL_EMPTY;
                    break;
                    
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            rc = WtcHelperConstants.ARC_SUCCESS;
            
            // populate Output Message
            for (i172 = 0;i172 < pCCMN28DOutputRec.getArchOutputStruct().getUlRowQty();++i172) {
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setSzNmPersonFull(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getSzNmPersonFull());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setSzBjnJob(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getSzBjnJob());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setDtDtEmpLastAssigned(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getDtDtEmpLastAssigned());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setTmScrTmEmpLastAssigned(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getTmScrTmEmpLastAssigned());
                
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setLNbrPhone(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getLNbrPhone());
                
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setLNbrPhoneExtension(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getLNbrPhoneExtension());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setSzNbrEmpOnCallPhone1(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getSzNbrEmpOnCallPhone1());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setLNbrEmpOnCallExt1(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getLNbrEmpOnCallExt1());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setSzCdEmpOnCallDesig(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getSzCdEmpOnCallDesig());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setSzNmOfficeName(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getSzNmOfficeName());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setUlIdPerson(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getUlIdPerson());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setUlIdUnit(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getUlIdUnit());
                pOutputMsg318.getAvailStaffGroup_ARRAY().getAvailStaffGroup(i172).setUsNbrEmpOnCallCntctOrd(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i172).getUsNbrEmpOnCallCntctOrd());
            }
            pOutputMsg318.getArchOutputStruct().setUlRowQty(pCCMN28DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg318.getArchOutputStruct().setBMoreDataInd(pCCMN28DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCCMN28DA(CCMN80SI pInputMsg349, CCMN80SO pOutputMsg319, int tempulIdOnCall, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i173 = 0;
        /* declare local variables */
        int n = 0;
        CCMN28DI pCCMN28DInputRec = null;
        CCMN28DO pCCMN28DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN28DInputRec = new CCMN28DI();
        
        pCCMN28DOutputRec = new CCMN28DO();
        pCCMN28DInputRec.setArchInputStruct(pInputMsg349.getArchInputStruct());
        pCCMN28DInputRec.setUlIdOnCall(tempulIdOnCall);
        rc = ccmn28dQUERYdam(sqlca, pCCMN28DInputRec, pCCMN28DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    //  Declare FOUNDATION variables
                    
                    //  Declare local variables
                    
                    //  Start performance timer for service
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            
            // SIR 21891 - missing versioning
            //  Run-time Versioning
            
            //  Check buffer size
            
            //  Process error message and return to client
            
            //  Initialize output message and length
            
            //  Initialize service status fields
            
            // 
            // Call DAMs to retrieve data
            // 
            
            rc = WtcHelperConstants.ARC_SUCCESS;
            //  When the first RC is hit, move the fields, and break out of the loop.
            // If out of data before an RC is hit, break out of the loop.
            // If n > 1 less than the list box can hold, max row count was hit,
            // so break out of the loop.
            // 
            n = pOutputMsg319.getArchOutputStruct().getUlRowQty();
            if (n <= pInputMsg349.getArchInputStruct().getUlPageSizeNbr() - 1) {
                for (i173 = 0;i173 < pCCMN28DOutputRec.getArchOutputStruct().getUlRowQty();i173++) {
                    if (pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getSzCdEmpOnCallDesig().equals(ROUTER)) {
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setSzNmPersonFull(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getSzNmPersonFull());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setSzBjnJob(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getSzBjnJob());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setDtDtEmpLastAssigned(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getDtDtEmpLastAssigned());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setTmScrTmEmpLastAssigned(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getTmScrTmEmpLastAssigned());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setLNbrPhone(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getLNbrPhone());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setLNbrPhoneExtension(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getLNbrPhoneExtension());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setSzNbrEmpOnCallPhone1(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getSzNbrEmpOnCallPhone1());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setLNbrEmpOnCallExt1(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getLNbrEmpOnCallExt1());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setSzCdEmpOnCallDesig(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getSzCdEmpOnCallDesig());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setSzNmOfficeName(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getSzNmOfficeName());
                        
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setUlIdPerson(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getUlIdPerson());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setUlIdUnit(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getUlIdUnit());
                        pOutputMsg319.getAvailStaffGroup_ARRAY().getAvailStaffGroup(n).setUsNbrEmpOnCallCntctOrd(pCCMN28DOutputRec.getROWCCMN28DO_ARRAY().getROWCCMN28DO(i173).getUsNbrEmpOnCallCntctOrd());
                        pOutputMsg319.getArchOutputStruct().getUlRowQty()++;
                        n++;
                        //  Populate Output Message
                        // pCINVA5DOutputRec will be returned to the service, so there
                        // is no need to copy the DAM output to the service output.
                        // Same goes for the DAM output architecture header.
                        break;
                    }
                }
            }
        }
        return rc;
    }

    static int CallCCMN29D(CCMN80SI pInputMsg350, CCMN80SO pOutputMsg320, int I, Pint ttlAssgnmntsCtr, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i174 = 0;
        /* declare local variables */
        CCMN29DI pCCMN29DInputRec = null;
        CCMN29DO pCCMN29DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN29DInputRec = new CCMN29DI();
        
        pCCMN29DOutputRec = new CCMN29DO();
        pCCMN29DInputRec.setArchInputStruct(pInputMsg350.getArchInputStruct());
        pCCMN29DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN29DInputRec.getArchInputStruct().setUlPageSizeNbr(10);
        pCCMN29DInputRec.setUlIdStage(pInputMsg350.getUlIdStage_ARRAY().getUlIdStage(I));
        rc = ccmn29dQUERYdam(sqlca, pCCMN29DInputRec, pCCMN29DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            rc = WtcHelperConstants.ARC_SUCCESS;
            
            // Return the return code to the calling routine
            pOutputMsg320.setSzNmCase(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(0).getSzNmCase());
            
            
            
            for (i174 = 0;i174 < pCCMN29DOutputRec.getArchOutputStruct().getUlRowQty();++i174) {
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setSzNmStage(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getSzNmStage());
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setSzNmPersonFull(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getSzNmPersonFull());
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setSzCdStagePersRole(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getSzCdStagePersRole());
                
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setUlIdStage(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getUlIdStage());
                
                // 
                // Function Prototypes
                // 
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setUlIdPerson(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getUlIdPerson());
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setUlIdStagePerson(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getUlIdStagePerson());
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setUlIdCase(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getUlIdCase());
                
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setSzCdStage(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getSzCdStage());
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setSzCdStageProgram(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getSzCdStageProgram());
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setSzCdStageType(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getSzCdStageType());
                
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setSzCdStageCnty(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getSzCdStageCnty());
                pOutputMsg320.getAssignmentGroup_ARRAY().getAssignmentGroup(ttlAssgnmntsCtr.value).setTsLastUpdate(pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i174).getTsLastUpdate());
                ++(ttlAssgnmntsCtr.value);
            }
            pOutputMsg320.setUlRowQty2(pCCMN29DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg320.setBMoreDataInd2(pCCMN29DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCCMN30D(CCMN80SI pInputMsg351, CCMN80SO pOutputMsg321, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /* declare local variables */
        CCMN30DI pCCMN30DInputRec = null;
        CCMN30DO pCCMN30DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN30DInputRec = new CCMN30DI();
        
        pCCMN30DOutputRec = new CCMN30DO();
        pCCMN30DInputRec.setArchInputStruct(pInputMsg351.getArchInputStruct());
        pCCMN30DInputRec.setUlIdStage(pInputMsg351.getUlIdStage_ARRAY().getUlIdStage(I));
        rc = ccmn30dQUERYdam(sqlca, pCCMN30DInputRec, pCCMN30DOutputRec);
        
        /*
        ** SIR 14517 - If the person is in no other open stages, change
        ** the person's status to Inactive, otherwise leave Active.
        */
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            rc = WtcHelperConstants.ARC_SUCCESS;
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setSzNmStage(pCCMN30DOutputRec.getSzNmStage());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setSzNmPersonFull(pCCMN30DOutputRec.getSzNmPersonFull());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setSzCdStagePersRole(pCCMN30DOutputRec.getSzCdStagePersRole());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setUlIdStage(pCCMN30DOutputRec.getUlIdStage());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setUlIdPerson(pCCMN30DOutputRec.getUlIdPerson());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setUlIdStagePerson(pCCMN30DOutputRec.getUlIdStagePerson());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setUlIdCase(pCCMN30DOutputRec.getUlIdCase());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setSzCdStage(pCCMN30DOutputRec.getSzCdStage());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setSzCdStageProgram(pCCMN30DOutputRec.getSzCdStageProgram());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setSzCdStageCnty(pCCMN30DOutputRec.getSzCdStageCnty());
            pOutputMsg321.getAssignmentGroup_ARRAY().getAssignmentGroup(I).setTsLastUpdate(pCCMN30DOutputRec.getTsLastUpdate());
        }
        return rc;
    }

    static int CallCCMN79D(CCMN80SI pInputMsg352, CCMN80SO pOutputMsg322, Pint tempulIdOnCall, String tempTime, FndInt3date tempDate, char bFirstTime, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /* declare local variables */
        CCMN79DI pCCMN79DInputRec = null;
        CCMN79DO pCCMN79DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN79DInputRec = new CCMN79DI();
        
        pCCMN79DOutputRec = new CCMN79DO();
        pCCMN79DInputRec.setArchInputStruct(pInputMsg352.getArchInputStruct());
        pCCMN79DInputRec.setSzCdOnCallCounty(pInputMsg352.getSzCdOnCallCounty());
        pCCMN79DInputRec.setSzCdOnCallProgram(pInputMsg352.getSzCdOnCallProgram());
        pCCMN79DInputRec.setDtDtOnCallStart(tempDate);
        pCCMN79DInputRec.setTmOnCallStart(tempTime);
        /*
        ** Retrieves person information for list box row
        */
        rc = ccmn79dQUERYdam(sqlca, pCCMN79DInputRec, pCCMN79DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CMN_ASSIGN_ON_CALL;
                    //  Update PERSON_ALLEG_LINK changing the ID_PERSON to the
                    // ID_RELATED_PERSON
                    rc = Messages.MSG_CMN_ASSIGN_ON_CALL;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else /* rc == SQL_SUCCESS */
        {
            //  call the DELETE_INCOMING_PERSON complex delete procedure
            rc = WtcHelperConstants.ARC_SUCCESS;
            tempulIdOnCall.value = pCCMN79DOutputRec.getROWCCMN79DO().getUlIdOnCall();
            
            if (bFirstTime) {
                pOutputMsg322.getROWCCMN79DO().setUlIdOnCall(pCCMN79DOutputRec.getROWCCMN79DO().getUlIdOnCall());
                pOutputMsg322.getROWCCMN79DO().setSzCdOnCallCounty(pCCMN79DOutputRec.getROWCCMN79DO().getSzCdOnCallCounty());
                pOutputMsg322.getROWCCMN79DO().setSzCdOnCallProgram(pCCMN79DOutputRec.getROWCCMN79DO().getSzCdOnCallProgram());
                pOutputMsg322.getROWCCMN79DO().setSzCdOnCallType(pCCMN79DOutputRec.getROWCCMN79DO().getSzCdOnCallType());
                
                //  When retrieving records from the STAGE table, if an error
                // occurs, excluding SQL_NOT_FOUND, the function calls
                // returns a general error to the calling Service. The function
                // aborts processing and all changes to the database are rolled
                // back. A general error message is displayed upon returning to
                // the client.
                pOutputMsg322.getROWCCMN79DO().setDtDtOnCallStart(pCCMN79DOutputRec.getROWCCMN79DO().getDtDtOnCallStart());
                pOutputMsg322.getROWCCMN79DO().setTmOnCallStart(pCCMN79DOutputRec.getROWCCMN79DO().getTmOnCallStart());
                pOutputMsg322.getROWCCMN79DO().setDtDtOnCallEnd(pCCMN79DOutputRec.getROWCCMN79DO().getDtDtOnCallEnd());
                pOutputMsg322.getROWCCMN79DO().setTmOnCallEnd(pCCMN79DOutputRec.getROWCCMN79DO().getTmOnCallEnd());
            }
        }
        
        return rc;
    }

    static int CallCINT40D(CCMN80SI pInputMsg353, CCMN80SO pOutputMsg323, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINT40DInputRec.setUlIdStage(pInputMsg353.getUlIdStage_ARRAY().getUlIdStage(0));
        
        /*
        ** Call CSUB40U
        */
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        
        /****************************************************************
        ** (END): CSES81D - Contract Version retrieve for an idContract
        ** , contract period number, and version end date that is greater
        ** than the current date.
        ****************************************************************/
        
        
        
        /************************************************************************
        ** (END): Contracts existance determination.  Is there an open foster
        **          and adoptive contract for the home? SIR 20083
        ************************************************************************/
        
        /************************************************************************
        ** (BEGIN): Contract creation process if the contract does not already
        **          exist. SIR 20083
        ************************************************************************/
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            pOutputMsg323.setUlIdUnit(pCINT40DOutputRec.getUlIdUnit());
        }
        return rc;
    }

    static int CallCSEC84D(CCMN80SI pInputMsg354, CCMN80SO * pOutputMsg324, int i175, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* declare local variables */
        CSEC84DI pCSEC84DInputRec = null;
        CSEC84DO pCSEC84DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCSEC84DInputRec = new CSEC84DI();
        
        pCSEC84DOutputRec = new CSEC84DO();
        pCSEC84DInputRec.setArchInputStruct(pInputMsg354.getArchInputStruct());
        pCSEC84DInputRec.setUlIdStage(pInputMsg354.getUlIdStage_ARRAY().getUlIdStage(i175));
        
        /*
        ** Call CCMN39D
        */
        rc = csec84dQUERYdam(sqlca, pCSEC84DInputRec, pCSEC84DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_NOT_ON_WKLD;
                rc = Messages.MSG_CMN_NOT_ON_WKLD;
                break;
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
