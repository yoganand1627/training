package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS00DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC07SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS00DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA2DO;
/**************************************************************************
**
** Module File:   carc07s.src
**
** Service Name:  CARC07S - ON-DEMAND RPT LAUNCH
**
** Description:   This service will launch an on-demand report.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  08/23/95
**
** Programmer:    Andrew Sooley
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   24 Mar 1997 14:32:44  $
**                      $Modtime:   21 Mar 1997 13:58:00  $
**                      $Author:   impact  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  08/23/95  sooleyag  Initial version.
**
**  10/9/95   sooleyag  SIR #1653 - Date validation section was checking
**                      for a different date structure so login updated
**                      to validate correctly.
**
**  10/17/95  sooleyag  SIR #1826
**  11/21/95  wallacbe  Modified to accept '' (2 single quotes) as a valid
**                      date
**  11/27/95  wallacbe  Modified to free all dynamically allocated memory
**                      before exit and modified CallCLSS00D function to
**                      properly check for input parameters that are too
**                      large, taking into consideration the single quotes
**                      surrounding character string inputs.
**  01/18/96  wallacbe  Modified malloc of email string to be strlen + 1
**                      rather than strlen to allow for null terminator.
**  01/25/96  vencilja  Removed call to CSES00D to retrieve email address,
**                      removed unneeded fields from the output message,
**                      and added DAM calls for the new report architecture
**  02/23/96  vencilja  Added "Pend" status to report_list table
**  03/14/96  vencilja  Changed to use launchd
**  03/19/96  vencilja  Cleaned up carc07s exit handling and removed the
**                      array of pointers for report args no longer used
**  05/08/03  websted   SIR # 17168 Added the single quote (') to the list 
**                      of valid characters for the NUMBER and INTEGER 
**                      types of report parameter, so that we could allow 
**                      the report to accept blank parameters of these
**                      types in the format ' '. 
**  06/04/03 mcclaim    Updated to handle dates surrounded by single quotes 
**
**	06/30/03  Srini		SIR 18602 - Modified to fix error handling for 
**						transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**						PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to 
**						PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**
**  08/01/03  Srini     SIR 19314 - Changed the error handling for ARC_RPTLaunchAsyncReport 
**						so that the rc value is set correctly.
**
**  08/21/03  Srini     Commented the usRc statement as we will be ok even if it doesn't write
**						to the pipe as long as the tempfile is written and database has record 
**						with pending status. This fixes the problem when the service writes the
**						RPT* file and doesn't write to the pipe as the .LINK is missing but 
**						doesn't write to the DB.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/







/*************************************
** Service function prototypes 
***************************************/
public class Carc07s {
    
    public static final int ARC_UTL_NO_SERVER = 3;
    public static final int ARC_UTL_CREATE_FAIL = 4;
    public static final int ARC_UTL_WRITE_FAIL = 6;
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /*
    ** Set the max number of parameter arguments the max # of rows that the
    ** DAM can be returned.
    */
    public static final UNKNOWN_TYPE MAX_RPT_PARM_ARGS = CLSS00DO._CLSS00DO__ROWCLSS00DO_SIZE;
    public static final UNKNOWN_TYPE MAX_RPT_PARM_LIST_LEN = CARC07SI.TXT_RPT_PARM_LIST_LEN;
    void handle_sigcld() {
        int pid = 0;
        Pint status = new Pint();
        
        while ((pid = wait3(status, WNOHANG, (Rusage) 0)) > 0);
    }

    static CARC07SI pInputMsg4 = null;
    static int transactionflag1 = - 1;
    CARC07SO CARC07S(CARC07SI carc07si) {
        CARC07SO carc07so = new CARC07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;// Return code
        transactionflag1 = - 1;
        boolean bTransactionStarted = false;
        transactionflag1 = tpgetlev();
        
        if (transactionflag1 == - 1) {
            userlog("ERROR: tpgetlev failed in CARC07S(%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            
            //  Call CAUD56D
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag1 == 1) {
            // This is the case of transaction in progress.
            //So we should not start a new one
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CARC07S \n");
        }
        else if (transactionflag1 == 0) {
            bTransactionStarted = true;
        }
        
        
        //  Declare FOUNDATION variables
        
        //  Declare local variables
        int usRc = WtcHelperConstants.ARC_SUCCESS;
        Pchar cEmailOption = new Pchar();
        Pchar cRptOrientation = new Pchar();
        String szRptFullName = new String();
        String szRptTemplateName = new String();
        Pint ulRptMaxAge = new Pint();
        rc = CallCLSS00D(carc07si, carc07so, pServiceStatus);
        
        switch (rc) {
                
                //  Success Case for Dam CSES75D
            case WtcHelperConstants.ARC_SUCCESS:
                
                break;
                
                //  Success Case for Dam CSEC70D
            case Messages.MSG_REPORT_PARM_INVALID:
                
                break;
                
                //  Success Case for Dam CSES68D
            case Messages.MSG_NO_ROWS_RETURNED:
                
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (pServiceStatus.explan_code == SUCCESS) {
            rc = CallCSES12D(carc07si, carc07so, cEmailOption, cRptOrientation, szRptFullName, szRptTemplateName, ulRptMaxAge, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                    //  SQL Not Found Case for Dam CSES68D
                case WtcHelperConstants.ARC_SUCCESS:
                    //  Call Arch. API to launch the specified report asynchronously.
                    // If a non-zero value is returned then the report launch failed
                    // for one or more reasons, so the appropriate explan code is
                    // returned by the service.
                    // note that user_id and user_pw are not null terminated. nulls
                    // are added in ARC_RPTLaunchAsyncReport
                    usRc = ARC_RPTLaunchAsyncReport(carc07si, carc07so, szRptFullName, szRptTemplateName, cRptOrientation.value, cEmailOption.value, ulRptMaxAge.value, carc07si.getSzUsername() , carc07si.getSzPassword());
                    
                    
                    //  Analyze return code
                    switch (usRc) {
                            
                            //  SQL Not Found Case for Dam CSEC70D
                        case WtcHelperConstants.ARC_SUCCESS:
                            pServiceStatus.explan_code = Messages.MSG_REPORT_LAUNCHED;
                            
                            
                            //  Initialize rc for loop
                            rc = SUCCESS;
                            
                            break;
                            
                            //  Success Case for Dam CSES68D
                        case Arccbt.ARC_CBT_NO_SERVER:
                            pServiceStatus.severity = FND_SEVERITY_WARNING;
                            pServiceStatus.explan_code = Arccbt.ARC_CBT_NO_SERVER;
                            
                            
                            //  Call CAUD57D
                            rc = Arccbt.ARC_CBT_NO_SERVER;
                            
                            break;
                            
                            //   PROCESS_TUX_RC_ERROR_TRANSACT is called only when there is an unexpected
                            // error returned from the callDAM function.
                        default :
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_REPORT_LAUNCH_FAILED;
                            rc = Messages.MSG_REPORT_LAUNCH_FAILED;
                    }
                    
                    // Set explan_data to ERR_SAVE_EMP_SEC_INFO
                    
                    break;
                    
                    //  SQL Not Found Case for Dam CSES68D
                case Messages.MSG_NO_REPORT_INFO_FOUND:
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag1);
            //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            
            
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in SERVICE CARC07S(%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CARC07S\n");
        }
        
        return carc07so;
    }

    static int CallCSES12D(CARC07SI pInputMsg4, CARC07SO * pOutputMsg4, String cEmailOption, String cRptOrientation, String szRptFullName, String szRptTemplateName, Pint ulMaxAge, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        //  Declare local variables
        CSES12DI pCSES12DInputRec = null;
        CSES12DO pCSES12DOutputRec = null;
        String szErrLogMsg = new String();
        
        //  Allocate memory for Input and Output Structures
        pCSES12DInputRec = new CSES12DI();
        pCSES12DOutputRec = new CSES12DO();
        pCSES12DInputRec.setSzNmRptSqrName(pInputMsg4.getSzNmRptSqrName());
        pCSES12DInputRec.setSzNmRptSqrVer(pInputMsg4.getSzNmRptSqrVer());
        pCSES12DInputRec.setArchInputStruct(pInputMsg4.getArchInputStruct());
        
        //  Call DAM
        rc = cses12dQUERYdam(sqlca, pCSES12DInputRec, pCSES12DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                szRptFullName = pCSES12DOutputRec.getSzTxtRptFullName();
                szRptTemplateName = pCSES12DOutputRec.getSzNmRptTemplateName();
                cRptOrientation = CStringUtils.setCharAt(cRptOrientation, 0, pCSES12DOutputRec.getSzNmRptOrientation()[0]);
                cEmailOption = CStringUtils.setCharAt(cEmailOption, 0, pCSES12DOutputRec.getSzTxtRptEmailOption()[0]);
                ulMaxAge.value = pCSES12DOutputRec.getUlNbrRptRetainage();
                //  If no rows were found, return FND_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_REPORT_INFO_FOUND;
                szErrLogMsg = pInputMsg4.getSzNmRptSqrName() + " " + pInputMsg4.getSzNmRptSqrVer() + " - no report info";
                rc = Messages.MSG_NO_REPORT_INFO_FOUND;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        
        return rc;
        //##             return ARC_ERR_MALLOC_FAILED;
    }

    static int CallCLSS00D(CARC07SI pInputMsg4, CARC07SO pOutputMsg5, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;// Return code
        int i4 = 0;
        //  Declare local variables
        CLSS00DI pCLSS00DInputRec = null;
        CLSS00DO pCLSS00DOutputRec = null;
        String pszSqrCmdToken = null;
        String pszTxtRptParmList = null;
        boolean bInvalidSqrParm = false;
        int iSqrParmVal = 0;
        float fSqrParmVal = 0.0f;
        String szCurrDate = new String();// MM-DD-YYYY
        
        // * mcclaim, 6/4/2003, allow for single quotes around date
        String szDay = new String();
        String szMon = new String();
        String szYear = new String();
        int iDateLen = 0;
        int iChar = 0;
        int sDay = 0;
        int sMon = 0;
        int sYear = 0;
        int sDateIndex = 0;
        int sDatePart = 1;
        int ulTokenSize = 0;
        int iCounter = 0;
        String szErrLogMsg = new String();
        
        //  Allocate memory for Input and Output Structures
        pCLSS00DInputRec = new CLSS00DI();
        pCLSS00DOutputRec = new CLSS00DO();
        pCLSS00DInputRec.setSzNmRptSqrName(pInputMsg4.getSzNmRptSqrName());
        pCLSS00DInputRec.setSzNmRptSqrVer(pInputMsg4.getSzNmRptSqrVer());
        pCLSS00DInputRec.setArchInputStruct(pInputMsg4.getArchInputStruct());
        pCLSS00DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSS00DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_RPT_PARM_ARGS);
        rc = clss00dQUERYdam(sqlca, pCLSS00DInputRec, pCLSS00DOutputRec);
        
        //  Analyze return code
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Copy the input message TxtRptParmList struct member to local
                // copy for string manipulation.
                pszTxtRptParmList = new String();
                pszTxtRptParmList = pInputMsg4.getTxtRptParmList();
                pszSqrCmdToken = strtok(pszTxtRptParmList, "^");
                
                //  Loop through each report parmeter in TxtRptParmList and verify
                // against expected values from DB.
                for (i4 = 0;i4 < pCLSS00DOutputRec.getArchOutputStruct().getUlRowQty();++i4) {
                    //  Validate that the SQR parameter length is not greater than
                    // the maximum specified in DB. Set bInvalidSqrParm boolean
                    // variable appropriately.
                    ulTokenSize = pszSqrCmdToken.length();
                    if ((pszSqrCmdToken.charAt(0) == '\'') && (pszSqrCmdToken.charAt(ulTokenSize - 1) == '\'')) {
                        ulTokenSize -= 2;
                    }
                    
                    if (ulTokenSize > pCLSS00DOutputRec.getROWCLSS00DO_ARRAY().getROWCLSS00DO(i4).getUlNbrRptParmLength()) {
                        bInvalidSqrParm = true;
                    }
                    
                    //  Validate that the SQR parameter type is of correct type as
                    // specified in DB. Set bInvalidSqrParm boolean var
                    // appropriately.
                    
                    //   05/08/03  websted   SIR # 17168 Added the single quote (') to the list 
                    // of valid characters for the NUMBER and INTEGER 
                    // types of report parameter, so that we could allow 
                    // the report to accept blank parameters of these
                    // types in the format ' '.
                    
                    else if (pCLSS00DOutputRec.getROWCLSS00DO_ARRAY().getROWCLSS00DO(i4).getSzTxtRptParmType().equals("INTEGER")) {
                        // Make sure each character is a digit(0-9) or - or + or
                        // . or , or space
                        for (iCounter = 0;iCounter < pszSqrCmdToken.length();iCounter++) {
                            
                            // 
                            // (BEGIN): CCMN06U - Check Stage/Event Status Common Function
                            // 
                            
                            if ((!(Character.isDigit(pszSqrCmdToken.charAt(iCounter)))) && (pszSqrCmdToken.charAt(iCounter) != '-') && (pszSqrCmdToken.charAt(iCounter) != '+') && (pszSqrCmdToken.charAt(iCounter) != '.') && (pszSqrCmdToken.charAt(iCounter) != ' ') && (pszSqrCmdToken.charAt(iCounter) != '\'') && (pszSqrCmdToken.charAt(iCounter) != ',')) {
                                bInvalidSqrParm = true;
                            }
                        }
                    }
                    // Number float
                    else if (pCLSS00DOutputRec.getROWCLSS00DO_ARRAY().getROWCLSS00DO(i4).getSzTxtRptParmType().equals("NUMBER")) {
                        // Make sure each character is a digit(0-9) or - or + or
                        // . or , or space
                        for (iCounter = 0;iCounter < pszSqrCmdToken.length();iCounter++) {
                            if ((!(Character.isDigit(pszSqrCmdToken.charAt(iCounter)))) && (pszSqrCmdToken.charAt(iCounter) != '-') && (pszSqrCmdToken.charAt(iCounter) != '+') && (pszSqrCmdToken.charAt(iCounter) != '.') && (pszSqrCmdToken.charAt(iCounter) != ' ') && (pszSqrCmdToken.charAt(iCounter) != '\'') && (pszSqrCmdToken.charAt(iCounter) != ',')) {
                                bInvalidSqrParm = true;
                            }
                        }
                    }
                    
                    // Character string
                    else 
                    // Date MM-DD-YYYY
                    else if (pCLSS00DOutputRec.getROWCLSS00DO_ARRAY().getROWCLSS00DO(i4).getSzTxtRptParmType().equals("DATE")) {
                        if ((pszSqrCmdToken.charAt(0) == '\'') && (pszSqrCmdToken.charAt(1) == '\'')) {
                            bInvalidSqrParm = false;
                        }
                        
                        else {
                            szCurrDate = pszSqrCmdToken;
                            iDateLen = szCurrDate.length();
                            
                            
                            // 
                            // (END): CCMN06U - Check Stage/Event Status Common Function
                            // 
                            
                            // 
                            // (BEGIN): Retrieve Id Unit in order to populate on Stage
                            // 
                            
                            if ((szCurrDate.charAt(0) == '\'') && (szCurrDate.charAt(iDateLen - 1) == '\'')) {
                                iDateLen -= 2;
                                szCurrDate = pszSqrCmdToken.charAt(1);
                                
                                szCurrDate[iDateLen] = "";
                            }
                            sDateIndex = 0;
                            sDatePart = 1;
                            
                            
                            //  Loop through the current date string extracting
                            // the month, day and year.
                            for (iChar = 0;iChar < iDateLen;iChar++) 
                            {
                                if (szCurrDate.charAt(iChar) == '/') {
                                    
                                    //  Analyze return code
                                    switch (sDatePart) {
                                        case 1:
                                            szMon = szCurrDate.charAt(sDateIndex);
                                            szMon[iChar - sDateIndex] = "";
                                            sMon = atoi(szMon);
                                            sDatePart++;
                                            sDateIndex = iChar + 1;// Used to index into date string
                                            break;
                                        case 2:
                                            szDay = szCurrDate.charAt(sDateIndex);
                                            szDay[iChar - sDateIndex] = "";
                                            sDay = atoi(szDay);
                                            sDatePart++;
                                            sDateIndex = iChar + 1;
                                            
                                            break;
                                            
                                        default :
                                            
                                            break;
                                    }
                                }
                            }
                            szYear = szCurrDate.charAt(sDateIndex);
                            szYear[4] = "";
                            sYear = atoi(szYear);
                            if ((sDay < 1 || sDay > 31) || (sYear < 0)) {
                                bInvalidSqrParm = true;
                            }
                            else // NOT A VALID TYPE
                            {
                                bInvalidSqrParm = false;
                            }
                        }
                    }
                    
                    
                    // 
                    // (END): Retrieve Id Unit in order to populate on Stage
                    // 
                    
                    // 
                    // (BEGIN): Create a New Home
                    // 
                    
                    if (bInvalidSqrParm) {
                        pServiceStatus.severity = FND_SEVERITY_WARNING;
                        pServiceStatus.explan_code = Messages.MSG_REPORT_PARM_INVALID;
                        szErrLogMsg = pInputMsg4.getSzNmRptSqrName() + " " + pInputMsg4.getSzNmRptSqrVer() + " " + pInputMsg4.getUlIdPerson() + " - invalid parameter #" + (i4 + 1);
                        
                        // 
                        // Get System Date and Time
                        // 
                        
                        rc = Messages.MSG_REPORT_PARM_INVALID;
                        break;
                    }
                    pszSqrCmdToken = strtok(0, "^");// Get next param report
                }
                if (!bInvalidSqrParm) {
                    
                    
                    //  Call CCMN01U
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                pOutputMsg5.getArchOutputStruct().setUlRowQty(pCLSS00DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg5.getArchOutputStruct().setBMoreDataInd(pCLSS00DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                szErrLogMsg = pInputMsg4.getSzNmRptSqrName() + " " + pInputMsg4.getSzNmRptSqrVer() + " - no parm info";
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    int ARC_RPTLaunchAsyncReport(CARC07SI pInputMsg4, CARC07SO * pOutputMsg6, String pszMailSubject, String pszRptTemplate, char cRptOrientation, char cEmailAttachOption, int ulRptMaxAge, String szDbUser, String szDbPassword) {
        CARC07SI pAsyncInputMsg = null;
        CARC07SO pAsyncOutputMsg = null;
        pid_t lpid;
        int rc = 0;// Return code
        int usRc = ARC_RPT_SUCCESS;// return code
        int usSqrRc = ARC_RPT_SUCCESS;// SQR return code
        String szOutputFileName = new String();// Gen SQR report filename
        String szSqrUncPath = new String();// SQR Unc dir  path
        String szSqrDirPath = new String();// SQR dir path
        String szMessage = new String();// Log message
        String pcNullTerm = null;
        int i5 = 0;
        Pint ulRowId = new Pint();
        ulRowId.value = 0;
        DataObjectOutputStream TempFile = null;
        String szAuditFileLoc = new String();
        String szFileName = null;
        CpipeT AuditMsg = null;
        int iWritten = 0;
        int iTotal = 0;
        int iPipe = 0;
        ARC_CBTTraceMessage(Arccbt.CBT_TRC_RPT, "AsyncProc: START OF APPLICATION");
        szMessage = ENV_VAR_CBT_SCRIPT_NAME + "=" + "carc07s";
        putenv(szMessage);
        // Read parameters from configuration file
        usRc = ARC_CBTReadConfigFile();
        
        if (usRc != Arccbt.ARC_CBT_SUCCESS) {
            ARC_CBTTraceMessage(Arccbt.CBT_TRC_RPT, "AsyncProc: Failed reading config file. rc=%d", usRc);
            
            userlog("ERROR: Failed in reading the config file rc=%d", usRc);
            return usRc;
        }
        ARC_CBTTraceMessage(Arccbt.CBT_TRC_RPT, "AsyncProc: Call LogStartup...");
        do // dummy loop to make exit processing nicer
        {
            ARC_CBTTraceMessage(Arccbt.CBT_TRC_RPT, "AsyncProc: Read Report Path");
            usRc = RPTReadReportPath(szSqrUncPath, szSqrDirPath);
            
            if (usRc != ARC_RPT_SUCCESS) {
                ARC_CBTTraceMessage(Arccbt.CBT_TRC_RPT, "AsyncProc: Failed reading config file. rc=%d", usRc);
                userlog("ERROR: AsyncProc: Failed reading config file. rc=%d", usRc);
                ARC_CBTTraceMessage(Arccbt.CBT_TRC_RPT, "AsyncProc: Shutdown logging facility");
                userlog("ERROR: AsyncProc: Shutdown logging facility\n");
                break;
            }
            
            userlog("INFO: RPTReadReportPath call was successful %d\n", usRc);
            pAsyncInputMsg = new CARC07SI();
            pAsyncInputMsg = pInputMsg4;
            pAsyncOutputMsg = new CARC07SO();
            pAsyncInputMsg.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            usRc = CallCAUDA2D(pAsyncInputMsg, pAsyncOutputMsg, ulRowId, "Pend", null, ulRptMaxAge);
            
            if (usRc != WtcHelperConstants.ARC_SUCCESS) {
                userlog("ERROR: CallCAUDA2D: cannot insert row into report list table. %d\n", usRc);
                break;
            }
            userlog("INFO: CallCAUDA2D call was successful %d\n", usRc);
            
            
            //  Call csec13d
            rc = ARC_UTLGetConfigEntry(szAuditFileLoc, CONFIG_REPORTING_DAEMON_QUEUE);
            if ((rc != Arcutls.ARC_UTL_SUCCESS) || (szAuditFileLoc.length() == 0)) {
                usRc = Arcutls.ARC_UTL_AUDIT_ERR;
                // ARC_CBTLogMessage(CBT_ARCH, CBT_SEVERITY_ERROR, usRc,
                // "cannot insert row into report list table");
                userlog("ERROR: ARC_UTL_AUDIT_ERR %d\n", usRc);
                break;
            }
            szFileName = tempnam(szAuditFileLoc, "RPT");
            
            // SIR 18351 - add szNmRsrcLastUpdate to dam input structure
            if (szFileName == null) {
                usRc = ARC_UTL_CREATE_FAIL;
                
                userlog("ERROR: Temporary file RPT creation failed.\n");
                break;
            }
            try {
                try {
                    TempFile = new DataObjectOutputStream(new FileOutputStream(szFileName));
                }
                catch (FileNotFoundException e) {
                    System.err.println("FileNotFoundException:" + e);
                }
            }
            catch (Exception e) {
                usRc = ARC_UTL_CREATE_FAIL;
                userlog("ERROR: Temporary file open failed.\n");
                break;
            }
            if (TempFile.println(pInputMsg4.getSzNmRptSqrName() + "\n" + pInputMsg4.getSzNmRptSqrVer() + "\n" + pInputMsg4.getSzTxtEmailMessage() + "\n" + pInputMsg4.getUlIdPerson() + "\n" + pInputMsg4.getUlRptLstCfpStamp() + "\n" + ulRowId.value + "\n" + szDbUser + "\n" + szDbPassword + "\n" + pInputMsg4.getTxtRptParmList());usRc = ARC_UTL_WRITE_FAIL;userlog("ERROR: Writing to the file failed.\n");break;}
        try {
            TempFile.close();userlog("INFO: RPT temp file created %s\n", szFileName);AuditMsg.fname = szFileName;AuditMsg.cmd = Arccbt.CMDMSG;szAuditFileLoc += "/" + Arccbt.PIPEFILE;iPipe = LowLevelIO.open(szAuditFileLoc, LowLevelIO.O_WRONLY | LowLevelIO.O_NDELAY | LowLevelIO.O_APPEND);if (iPipe < 0) {
                userlog("ERROR: ARC_UTL_NO_SERVER returned from open of the pipe.\n");break;}
            
            iTotal = 0;while (((iWritten = LowLevelIO.write(iPipe, (char) & AuditMsg + iTotal, sizeof () - iTotal)) > 0) || ((iWritten < 0) && (errno == EINTR))) {
                iTotal += iWritten;}
            
            close(iPipe);}
        catch (IOException e) {
            System.err.println("IO Exception:" + e);}
        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        
        //## END: TUX Service Change 
        //##    return(rc);
        //## END: TUX Service Change 
    }

    while (false);return usRc;}
static int CallCAUDA2D(CARC07SI pInputMsg4, CARC07SO pOutputMsg7, Pint ulRowId, String szStatus, String szFileName, int ulRptMaxAge) {
    int rc = 0;/* Return code  */
    int i6 = 0;CAUDA2DI pCAUDA2DInputRec = null;CAUDA2DO pCAUDA2DOutputRec = null;FndInt3date dtRptExpire = null;FndInt3date dtRptMaxAge = null;pCAUDA2DInputRec = new CAUDA2DI();pCAUDA2DOutputRec = new CAUDA2DO();pCAUDA2DInputRec.setUlIdRptList(ulRowId.value);pCAUDA2DInputRec.setSzNmRptSqrName(pInputMsg4.getSzNmRptSqrName());pCAUDA2DInputRec.setSzNmRptSqrVer(pInputMsg4.getSzNmRptSqrVer());ARC_UTLGetDateAndTime(pCAUDA2DInputRec.getDtDtRptLstGeneration() , pCAUDA2DInputRec.getTmScrTmGeneric1());pCAUDA2DInputRec.setUlIdPerson(pInputMsg4.getUlIdPerson());pCAUDA2DInputRec.setUlRptLstCfpStamp(pInputMsg4.getUlRptLstCfpStamp());if (szFileName == null) {
        pCAUDA2DInputRec.getSzTxtRptGenName()[0] == '\0';}

    else {
        pCAUDA2DInputRec.setSzTxtRptGenName(szFileName);}

    pCAUDA2DInputRec.setSzRptLstParmlist(pInputMsg4.getTxtRptParmList());pCAUDA2DInputRec.setSzTxtRptLstRuntimeName(pInputMsg4.getSzTxtEmailMessage());pCAUDA2DInputRec.setSzTxtRptLstStatus(szStatus);pCAUDA2DOutputRec.getArchOutputStruct().setUlRowQty(0);dtRptExpire = pCAUDA2DInputRec.getDtDtRptLstGeneration();dtRptMaxAge.day = ulRptMaxAge;dtRptMaxAge.month = 0;dtRptMaxAge.year = 0;if ((ulRptMaxAge == 0) || ((rc = ARC_UTLAddToDate(dtRptExpire, dtRptMaxAge)) == WtcHelperConstants.ARC_SUCCESS)) {
        pCAUDA2DInputRec.setDtDtRptLstRetainage(dtRptExpire);pCAUDA2DInputRec.setTmScrTmGeneric3(pCAUDA2DInputRec.getTmScrTmGeneric1());pCAUDA2DInputRec.setArchInputStruct(pInputMsg4.getArchInputStruct());rc = cauda2dAUDdam(sqlca, pCAUDA2DInputRec, pCAUDA2DOutputRec);switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                ulRowId.value = pCAUDA2DOutputRec.getUlIdRptList();pOutputMsg7.getArchOutputStruct().setUlRowQty(pCAUDA2DOutputRec.getArchOutputStruct().getUlRowQty());pOutputMsg7.getArchOutputStruct().setBMoreDataInd(pCAUDA2DOutputRec.getArchOutputStruct().getBMoreDataInd());rc = WtcHelperConstants.ARC_SUCCESS;break;default :
                ;}
    }

    return rc;
}
}