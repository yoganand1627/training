package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccfc23s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC67DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT72DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT72DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29DO;
/**************************************************************************
**
** Module File:   cint09s.src
**
** Service Name:  Person Search Rtrv
**
** Description:   Retrieves persons matching search criteria
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/16/95
**
** Programmer:    Brian Gugliemetti
**
** Modifications:
** Date    User      Description
** 2/23/95 GUGLIEBS  SIR #11: Added logic to reduce the number of rows
**                   retrieved for a person to one--the primary name or
**                   the newest name (determined by end date).
** 8/07/95 DMV       SIR # : Added call to the second DAM.  This DAM will
**                   sends a flag to the client to display the full person
**                   based on a Category of Former employee and the
**                   Stage_Person_Type.
** 11/2/95 SOOLEYAG  SIR #2037: Changed the SSA search level from 1 to 0.
**
** 2/21/96  JRH      SIR 3152 -- Added case to switch on if the name is too
**                   common and more than MaxNames are returned in the search
**
** 2/22/96 DMV       SIR 2085: Added a second DAM call to Retrieve the
**                   Person Information if the Person returned out of the
**                   Dynamic Dam has a status of M(erge). Copy the row that
**                   was returned to the Service output message instead of
**                   the original row.
**
** 3/14/96 ZIMMERNE  SIR #3885 - Added the Employee Flag Retrieval Dam -
**                   CINV29D.  This will be used to determine when to enable
**                   or disable the Records Check menu item on the window.
**
** 3/15/96 ELLIOTSL  SIR #3885 - Changed loop variables from i to
**                   sPersonIndex and sCatIndex so that they would be
**                   distinct.
**
** 14Apr96 sladewmf  SIR #5181: Initialized rc to 0 in CallCINT72D function.
**
** 7/17/96  DYARGR   SIR 21817: Free memory in CallCINV29D callback.
**
** 5/20/97 hendercr  SIR 21286:  Added call to dam CMSC49D, which will
**                   retrieve a count from the Person Merge table.  If the
**                   dam returns a count > 0, the Merge Indicator flag is
**                   set to true, else the Merge Indicator flag is set to
**                   false.  Added a Merge Indicator check box column to
**                   the Person Search Listbox; which will indicate if the
**                   person was merged.
**
**10/22/97 hendercr  SIR 13547 - Added code to display a message for
**                   doing a Partial Name Search on the first three
**                   letters of the first name and the first three letters
**                   of the last name, if the Phonetic checkbox is not
**                   checked and the users have entered a first and
**                   last name.  Added sql code to dam to perform
**                   a search on the first three letters of the first
**                   name and the first three letters of the last name,
**                   if the users select "Yes" to perform a Partial Name
**                   Search.  If the users select "No" to perform a
**                   Partial Name Search, it will perform a search using
**                   the entire first and last name, and also the entire
**                   middle name if it is entered.
**07/27/99 blahapp   SIR 15145 - (1) Added a month and day to the dates used
**           in the search range for a person search DOB so that
**           these dates will pass the test for a valid date (Oracle
**           does not accept dates with month, day or year equal to
**           zero.)
**               (2) Changed search algorithm for DOB and
**           age. Previously, a DOB entered for person search was not
**           actually searched on, but used to calculate a 10-year
**           range for adults (3-year for children) for searching.
**           If age was also entered, the age was used to calculate
**           this 10-year range and DOB was not actually used for
**           anything. Now if DOB is entered, this exact information
**           is used in the person search (and if an age is entered,
**           the age will be ignored).  Only if DOB is left blank will
**           the value for age be used to  calculate a range of birth
**           dates (as before) for the person search.
**
**
**
**10/31/00   UPGRADE 2000 PCG Upgrade SSANAME3 software from Version 1.7 to
**           Version 1.8. These changes address the software upgrade,
**           user identified problems, and several SIRS. Modifications will be
**           denoted with "UPGRADE 2000 ITEM X" in the programming notes.
**           The major modifications are as follows:
**
**                 ITEM 1 -  Add switch statement which indicates if two
**                           search ranges are available.  If two search
**                           ranges have been created by SSA-NAME3 CreateKeys,
**                           the query in cint08d.pc uses the first set of
**                           phonetic keys. If the query brings back more than
**                           the maximum number of rows, the while loop
**                           initiates the search again using a narrower set
**                           of phonetic keys (narrower range).
**                           A narrower range is only available if the full
**                           first and last Names are entered.  If the first
**                           initial and last name are entered only one
**                           phonetic range can be created.
**
**                 ITEM 2 -  Add variables to pass gender to the query
**                           DAM (cint08d.pc).  If 'M' or 'F' is entered, the
**                           query will bring back the gender entered and, 'U'
**                           for unknown, that match the name entered.
**
**                 ITEM 3 -  Modified the handling of DOB in search.  Because
**                           DOB will be used for scoring, a DOB range will be
**                           determined for both exact and phonetic searches.
**                           The DOB range will remain the same.  If Age is
**                           entered an approximate DOB is determined to pass
**                           into SSA-NAME3's MATCH service.
**                           If the age of the returned match is less than
**                           one year old, age will be populated with a "0".
**                           This will distinguish matches who are under the
**                           age of 1 and matches which do not have
**                           birthdates.
**
**                 ITEM 4 -  SCORE is now a column in the Person Search Detail
**                           List Box. SCORE is the last column to the right.
**                           Cint09s.src needs to pass the score back
**                           to the client.
**
**                 ITEM 5 -  If the name returned from the query is an AKA
**                           match a new column, called MATCH NAME, will be
**                           populated with the AKA name.  The NAME column is
**                           moved to the second column from the right and
**                           renamed PRIMARY NAME. The primary name associated
**                           with the AKA match will be populated in the
**                           PRIMARY NAME column.  If the name match is not an
**                           AKA match, the primary name will populate the
**                           MATCH NAME column.  An AKA name will be
**                           identified by "AKA" in the MATCH column.
**                           "IND_NAME_PRIMARY" is added to the output
**                           copybooks so that the information can be passed
**                           back to the services (cint09s.src and
**                           cint05s.src), to return to window (cint09w.win).
**                           The window will use this indicator to populate the
**                           Person Search List Box.
**
**                 ITEM 6 -  Removed Ethnicity field from Person Search Detail
**                           Window (cint09w.win). Inputs into DAMs for
**                           ethnicity have been removed.  Ethnicity will
**                           still be displayed in Person Search List Box when
**                           search results are returned.
**
**                 ITEM 7 -  This service will call one of two DAMs depending
**                           on information entered by user for search input
**                           criteria.  If the user does a phonetic search
**                           without the additional parameters (SSN, Person
**                           ID, or Phone) the service will call SSA-NAME3 to
**                           determine at least one, and when applicable, two
**                           phonetic ranges.  Then this service will call DAM
**                           CINT08D to perform query of the PHONETIC_NAME
**                           table to find matches.
**                           If the user does enter Additional Parameters and
**                           checks the Additional Parameters checkbox, the
**                           service will call SSA-NAME3 to find one or two
**                           phonetic ranges, then call DAM CINT23D to query
**                           the database. Exact match functionality has
**                           not been modified.
**
**                           A new flag is added to indicate which DAM should
**                           be called. If the flag bCallOtherDAM is TRUE the
**                           service calls Cint08d.pc.  Otherwise, the service
**                           calls Cint23d.pc.
**
**                           As part of this modification the call to
**                           cint08d.pc has been added.  Any duplicate code
**                           for the calls to both DAMs has been removed.
**
**                 ITEM 8 -  Increased the size of the List Box from 50 to 65.
**
**  01/09/2001  KRD     Both CINT08D and CINT23D can return errors other than
**                      just the standard SQL errors.  We were not trapping
**                      for these errors leading to the server unexplicably
**                      dying.  Required changes to CallCINT23D().
**
**  01/25/2001  KRD     The "More Data Indicator" was not being set after
**                      calling CINT08D.  Required changes to CallCINT23D().
**
**  02/07/2001  KRD     Even though the date range was being calculated for
**                      the call to CINT23D, it was being overwritten with
**                      the original date passed into the service.  Required
**                      changes to CallCINT23D().
**
**  02/28/2001  KRD     A bad array subscript value caused the wrong Phonetic
**                      Key range to be used in "phonetic + parameter"
**                      searches.  Required a change to CallCINT23D().
**
**  03/01/2001  KRD     The Match column isn't being set correctly when
**                      a match is made on an AKA Name.
**                      1) If a person is merged, we call another DAM
**                         to retrieve the "merge forward" person's info.
**                         Need to ensure that the "merge forward"'s
**                         full name is passed back as the "Match Name".
**                      2) Set the "aka name found" flag based on a
**                         comparison of the two names that are returned
**                         (NM_PERSON_FULL from the PERSON table and a
**                         NM_PERSON_FULL built on the first/middle/last
**                         names from the NAME table).
**                      Required changes to CallCINT23D().
**
**  03/09/2001  KRD     Searches that involve a date range should use the
**                      ARC_UTLAddToDate() API rather than increasing the
**                      year manually to avoid potential Date Invalid
**                      issues.  Required changes to CallCINT23D().
**
**  03/12/2001  KRD     Added "Person Search Failsafe" as a contingency
**                      for possible timeouts in Production.
**
**  01/21/2003  JEH     Changed bUNKNOWNDOBSEARCH comparisons from TRUE and
**                      FALSE to INDICATOR_YES and INDICATOR_NO
**
**	04/15/2003  Srini   IMPACT: Added the code to set the page no to 1 in
**						CallCINV29D Dam.
**
**  04/15/2003  Srini	IMPACT:  Commented the return statements inside the 
**						malloc failures and also cleaned up the PERF_TIMER_END 
**						calls.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint09s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int ADULT_AGE_RANGE_START = 18;
    public static final int ADULT_AGE_RANGE_VALUE = 10;
    public static final int CHILD_AGE_RANGE_VALUE = 3;
    public static final char CD_STATUS_MERGED = 'M';
    public static final String EMPLOYEE_CATEGORY = "EMP";
    public static final int FULL_NAME_LEN = 26;
    public static final int ARC_UTL_ERR_INPUT_TOO_SMALL = 13006;
    
    /* UPGRADE ITEM 1 These values tell the service if there is one or two phonetic
    ranges available for phonetic search */
    
    public static final int WW_RANGE_RETURNED = 5;
    public static final int WI_RANGE_RETURNED = 4;
    public static final int W_RANGE_RETURNED = 3;
    
    public static final char OPTION_CHECKED = 'Y';
    CINT09SO CINT09S(CINT09SI cint09si) {
        CINT09SO cint09so = new CINT09SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        
        /*
        ** Call CINV81D
        */
        rc = ARC_PRFServiceStartTime_TUX(cint09si.ArchInputStruct);
        
        /*
        ** Set rc to SSM_FIN_INVALID_PRSN_ID
        */
        rc = CallCINT23D(cint09si, cint09so, pServiceStatus);
        if (rc == WtcHelperConstants.SQL_SUCCESS) {
            
            
            //  Set rc to SSM_FIN_NO_SVC_AUTH_DTL
            rc = Cint05s.CallCMSC49D(cint09si, cint09so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            if (rc == WtcHelperConstants.SQL_SUCCESS) {
                rc = CallCINT72D(cint09si, cint09so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
            if (rc == WtcHelperConstants.SQL_SUCCESS) {
                rc = Ccfc23s.CallCINV29D(cint09si, cint09so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        else if (NO_DATA_FOUND == rc) {
            
            
            //  Call CINV81D
            rc = SUCCESS;
            pServiceStatus.explan_code = SUCCESS;
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint09si.ArchInputStruct, cint09so.ArchOutputStruct);
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
                
                //  SIR 3987 - Set rc to SSM_FIN_INVALID_PRSN_ID
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint09so;
    }

    static int CallCINT23D(CINT09SI pInputMsg419, CINT09SO pOutputMsg385, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i251 = 0;
        /*
        ** Declare local variables
        */
        /* UPGRADE 2000 ITEM 7 Declare Cint08d.pc Input and Output  */
        CINT23DI pCINT23DInputRec = null;
        CINT23DO pCINT23DOutputRec = null;
        CSEC67DI pCSEC67DInputRec = null;
        CSEC67DO pCSEC67DOutputRec = null;
        CINT08DI pCINT08DInputRec = null;
        CINT08DO pCINT08DOutputRec = null;
        
        /* UPGRADE 2000 ITEM 7 Define boolean flag which indicates if Cint08d.pc should be called
        to perform the search */
        boolean bCallOtherDAM = false;
        _SSANAMESTRUCT SSANameStruct;
        FndInt3date dtCurrentDate = new FndInt3date( - 1, /* Current date */
         - 1, - 1);
        FndInt3date dtDateToAdd = new FndInt3date(0, 0, 0);
        if ((OPTION_CHECKED == pInputMsg419.PrsnSearchInRec.getBScrPhoneticChk()[0]) && (OPTION_CHECKED != pInputMsg419.PrsnSearchInRec.getBScrAddressChk()[0]) && (OPTION_CHECKED != pInputMsg419.PrsnSearchInRec.getBScrAdditParametersChk()[0])) {
            bCallOtherDAM = true;
        }
        /* Routing Search to CINT08D if Additional Parameters is checked and no additional
        parameters were actually entered. Check for entry in 'Ethnic Group' field has been
        removed because this field has been removed from the Person Search Window */
        
        else if ((OPTION_CHECKED == pInputMsg419.PrsnSearchInRec.getBScrPhoneticChk()[0]) && (OPTION_CHECKED != pInputMsg419.PrsnSearchInRec.getBScrAddressChk()[0]) && (OPTION_CHECKED == pInputMsg419.PrsnSearchInRec.getBScrAdditParametersChk()[0]) && (0 == pInputMsg419.PrsnSearchInRec.getSzNbrPersonIdSsn().length()) && (0 == pInputMsg419.PrsnSearchInRec.getLNbrPhone().length()) && (0 == pInputMsg419.PrsnSearchInRec.getUlIdPerson())) {
            bCallOtherDAM = true;
        }
        else {
            bCallOtherDAM = false;
        }
        if (bCallOtherDAM) {
            
            // Allocate memory for Input and Output Structures for Cint08d.pc
            
            pCINT08DInputRec = new CINT08DI();
            
            pCINT08DOutputRec = new CINT08DO();
            
            
            
            // Allocate memory for DAM Input and Output Structures
            
            pCSEC67DInputRec = new CSEC67DI();
            
            pCSEC67DOutputRec = new CSEC67DO();
            pCINT08DInputRec.setArchInputStruct(pInputMsg419.ArchInputStruct);
            pCINT08DInputRec.setSzNmNameFirst(pInputMsg419.PrsnSearchInRec.getSzNmNameFirst());
            pCINT08DInputRec.setSzNmNameLast(pInputMsg419.PrsnSearchInRec.getSzNmNameLast());
            pCINT08DInputRec.setSzNmNameMiddle(pInputMsg419.PrsnSearchInRec.getSzNmNameMiddle());
            if (pInputMsg419.PrsnSearchInRec.getSzNmNameFirst().length() != 0) {
                SSANameStruct.szNmNameFirst = pInputMsg419.PrsnSearchInRec.getSzNmNameFirst();
            }
            else {
            }
            if (pInputMsg419.PrsnSearchInRec.getSzNmNameLast().length() != 0) {
                SSANameStruct.szNmNameLast = pInputMsg419.PrsnSearchInRec.getSzNmNameLast();
            }
            else {
            }
            if (pInputMsg419.PrsnSearchInRec.getSzNmNameMiddle().length() != 0) {
                SSANameStruct.szNmNameMiddle = pInputMsg419.PrsnSearchInRec.getSzNmNameMiddle();
            }
            else {
            }
            //  If no row was found on the CASE_MERGE table ZZZ is not
            // an acceptable choice.  Return MSG_INV_DISP_INVALID
            rc = ARC_SSACreateKeys(SSANameStruct);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            //  Analyze return code
            switch (SSANameStruct.usSysNbrSSANamePhkKeys) {
                case WW_RANGE_RETURNED:
                    pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(0, SSANameStruct.szSysNmSSARngFrmPhk[1]);
                    pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(1, SSANameStruct.szSysNmSSARngToPhk[1]);
                    pCINT08DInputRec.getSzNmPhkNameNarr_ARRAY().setSzNmPhkNameNarr(0, SSANameStruct.szSysNmSSARngFrmPhk[0]);
                    pCINT08DInputRec.getSzNmPhkNameNarr_ARRAY().setSzNmPhkNameNarr(1, SSANameStruct.szSysNmSSARngToPhk[0]);
                    
                    break;
                case WI_RANGE_RETURNED:
                case W_RANGE_RETURNED:
                    
                    pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(0, SSANameStruct.szSysNmSSARngFrmPhk[0]);
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(1, SSANameStruct.szSysNmSSARngToPhk[0]);
                    
                    break;
                    
                default :
                    
                    break;
            }
            pCINT08DInputRec.setCCdPersonSex(pInputMsg419.PrsnSearchInRec.getCCdPersonSex());
            
            
            ARC_UTLGetDateAndTime(dtCurrentDate, 0);
            if (pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth().year <= 0 && pInputMsg419.PrsnSearchInRec.getLNbrPersonAge() > 0) {
                pInputMsg419.PrsnSearchInRec.setDtDtPersonBirth(dtCurrentDate);
                
                dtDateToAdd.year = 0 - pInputMsg419.PrsnSearchInRec.getLNbrPersonAge();
                rc = ARC_UTLAddToDate((FndInt3date) & pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth() , (FndInt3date) & dtDateToAdd);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth().year > 0) {
                pCINT08DInputRec.setDtDtPersonBirth(pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth());
                
                pCINT08DInputRec.setDtDtPersonBirth2(pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth());
                if ((dtCurrentDate.year - pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth().year) >= ADULT_AGE_RANGE_START) {
                    dtDateToAdd.year = 0 - ADULT_AGE_RANGE_VALUE;
                    rc = ARC_UTLAddToDate((FndInt3date) & pCINT08DInputRec.getDtDtPersonBirth() , (FndInt3date) & dtDateToAdd);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    dtDateToAdd.year = ADULT_AGE_RANGE_VALUE;
                    rc = ARC_UTLAddToDate((FndInt3date) & pCINT08DInputRec.getDtDtPersonBirth2() , (FndInt3date) & dtDateToAdd);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                else // Age is under 18 years old
                {
                    dtDateToAdd.year = 0 - CHILD_AGE_RANGE_VALUE;
                    rc = ARC_UTLAddToDate((FndInt3date) & pCINT08DInputRec.getDtDtPersonBirth() , (FndInt3date) & dtDateToAdd);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    dtDateToAdd.year = CHILD_AGE_RANGE_VALUE;
                    rc = ARC_UTLAddToDate((FndInt3date) & pCINT08DInputRec.getDtDtPersonBirth2() , (FndInt3date) & dtDateToAdd);
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            rc = cint08dQUERYdam(sqlca, pCINT08DInputRec, pCINT08DOutputRec);
            if (rc != 0) {
                
                //  Analyze error code
                switch (rc) {
                    case NO_DATA_FOUND:
                    case ARC_SSA_ERROR:
                        
                        break;
                    case Messages.MSG_INT_INTERNAL_SQL_ERROR:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    case Messages.MSG_NAME_TOO_COMMON:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = Messages.MSG_NAME_TOO_COMMON;
                        break;
                        
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
            else {
                
                // Populate Output Message
                
                for (i251 = 0;i251 < pCINT08DOutputRec.getArchOutputStruct().getUlRowQty() && rc == 0;++i251) {
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameFirst(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzNmNameFirst());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameMiddle(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzNmNameMiddle());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameLast(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzNmNameLast());
                    rc = Cint05s.ARC_UTLProduceFullName(pOutputMsg385.PrsnSearchOutRec[i251].getSzNmPersonFull() , FULL_NAME_LEN, pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzNmNameFirst() , pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzNmNameMiddle() , pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzNmNameLast());
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNmIncmgPersFull(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzNmIncmgPersFull());
                    // if current date is only 2 days different from Eff date, then
                    // don't update contract_version and contract-county tables
                    if ((pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonBirth().year <= 0) && (pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonDeath().year <= 0)) {
                        pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge(0);
                    }
                    else if (pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonDeath().year > 0) {
                        if ((pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonBirth().month > pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonDeath().month) || (pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonBirth().day > pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonDeath().day) && (pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonBirth().month == pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonDeath().month)) {
                            pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge((pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonDeath().year - pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonBirth().year) - 1);
                        }
                        else {
                            //  Anything but success us unacceptable
                            pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge((pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonDeath().year - pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonBirth().year));
                        }
                    }
                    else {
                        ARC_UTLCalcAgeFromDate(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonBirth() , pOutputMsg385.PrsnSearchOutRec[i251].getLNbrPersonAge());
                    }
                    
                    pOutputMsg385.PrsnSearchOutRec[i251].setDtDtPersonDeath(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonDeath());
                    pOutputMsg385.PrsnSearchOutRec[i251].setDtDtPersonBirth(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtPersonBirth());
                    pOutputMsg385.PrsnSearchOutRec[i251].setDtDtNameEndDate(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getDtDtNameEndDate());
                    pOutputMsg385.PrsnSearchOutRec[i251].setBIndPersonDobApprox(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getBIndPersonDobApprox());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzAddrPersAddrStLn1(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzAddrPersAddrStLn1());
                    pOutputMsg385.PrsnSearchOutRec[i251].setCCdPersonSex(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getCCdPersonSex());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzAddrCity(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzAddrCity());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzCdPersonEthnicGroup(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzCdPersonEthnicGroup());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzCdCounty(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzCdAddrCounty());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNbrPersonIdSsn(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getSzNbrPersonIdSsn());
                    //  Anything but success us unacceptable
                    pOutputMsg385.PrsnSearchOutRec[i251].setUlIdPerson(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getUlIdPerson());
                    
                    if (0 == pOutputMsg385.PrsnSearchOutRec[i251].getSzNmIncmgPersFull().compareTo(pOutputMsg385.PrsnSearchOutRec[i251].getSzNmPersonFull())) {
                        
                        pOutputMsg385.PrsnSearchOutRec[i251].getSzScrCdPersonSearchHit()[0] = Cint14s.INDICATOR_NO;
                    }
                    else {
                        pOutputMsg385.PrsnSearchOutRec[i251].getSzScrCdPersonSearchHit()[0] = INDICATOR_YES;
                    }
                    pOutputMsg385.PrsnSearchOutRec[i251].setUsScrIndScore(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getUsScrIndScore());
                    
                    if ((0 == rc) && (CD_STATUS_MERGED == pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i251).getCdPersonStatus()[0])) {
                        pCSEC67DInputRec.setArchInputStruct(pInputMsg419.ArchInputStruct);
                        pCSEC67DInputRec.setUlIdPerson(pOutputMsg385.PrsnSearchOutRec[i251].getUlIdPerson());
                        rc = csec67dQUERYdam(sqlca, pCSEC67DInputRec, pCSEC67DOutputRec);
                        
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Start performance timer for service. All performance functions always
                                // return success so there is no need to check status.
                                rc = Cint05s.ARC_UTLProduceFullName(pOutputMsg385.PrsnSearchOutRec[i251].getSzNmIncmgPersFull() , FULL_NAME_LEN, pCSEC67DOutputRec.getSzNmNameFirst() , pCSEC67DOutputRec.getSzNmNameMiddle() , pCSEC67DOutputRec.getSzNmNameLast());
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                pOutputMsg385.PrsnSearchOutRec[i251].getSzNmPersonFull()[0] = null;
                                pOutputMsg385.PrsnSearchOutRec[i251].getSzScrCdPersonSearchHit()[0] = Cint14s.INDICATOR_NO;
                                
                                // 22485 Find out the levels of care of the resource. There is one
                                // service codes for Baisic and two service codes for Habil, Ther, and
                                // Prim med
                                if ((pCSEC67DOutputRec.getDtDtPersonBirth().year > 0) && (pCSEC67DOutputRec.getDtDtPersonDeath().year <= 0)) {
                                    ARC_UTLCalcAgeFromDate(pCSEC67DOutputRec.getDtDtPersonBirth() , pOutputMsg385.PrsnSearchOutRec[i251].getLNbrPersonAge());
                                }
                                else if (pCSEC67DOutputRec.getDtDtPersonDeath().year > 0) {
                                    if ((pCSEC67DOutputRec.getDtDtPersonBirth().month > pCSEC67DOutputRec.getDtDtPersonDeath().month) || (pCSEC67DOutputRec.getDtDtPersonBirth().day > pCSEC67DOutputRec.getDtDtPersonDeath().day) && (pCSEC67DOutputRec.getDtDtPersonBirth().month == pCSEC67DOutputRec.getDtDtPersonDeath().month)) {
                                        pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge((pCSEC67DOutputRec.getDtDtPersonDeath().year - pCSEC67DOutputRec.getDtDtPersonBirth().year) - 1);
                                    }
                                    else {
                                        pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge((pCSEC67DOutputRec.getDtDtPersonDeath().year - pCSEC67DOutputRec.getDtDtPersonBirth().year));
                                    }
                                }
                                //  Anything but success us unacceptable
                                pOutputMsg385.PrsnSearchOutRec[i251].setCCdPersonSex(pCSEC67DOutputRec.getCCdPersonSex());
                                
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzCdPersonEthnicGroup(pCSEC67DOutputRec.getSzCdPersonEthnicGroup());
                                pOutputMsg385.PrsnSearchOutRec[i251].setUlIdPerson(pCSEC67DOutputRec.getUlIdPerson());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzAddrCity(pCSEC67DOutputRec.getSzAddrCity());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzCdCounty(pCSEC67DOutputRec.getSzCdAddrCounty());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzAddrPersAddrStLn1(pCSEC67DOutputRec.getSzAddrPersAddrStLn1());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzNbrPersonIdSsn(pCSEC67DOutputRec.getSzNbrPersonIdSsn());
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                }
            }
            pOutputMsg385.ArchOutputStruct.setUlRowQty(pCINT08DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg385.ArchOutputStruct.setBMoreDataInd(pCINT08DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        
        
        else 
        {
            
            
            //  Allocate memory for Input and Output Structures
            pCINT23DInputRec = new CINT23DI();
            pCINT23DOutputRec = new CINT23DO();
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC67DInputRec = new CSEC67DI();
            
            pCSEC67DOutputRec = new CSEC67DO();
            pCINT23DInputRec.setArchInputStruct(pInputMsg419.ArchInputStruct);
            //  Anything but success us unacceptable
            pCINT23DInputRec.setSzNmNameFirst(pInputMsg419.PrsnSearchInRec.getSzNmNameFirst());
            
            pCINT23DInputRec.setSzNmNameLast(pInputMsg419.PrsnSearchInRec.getSzNmNameLast());
            pCINT23DInputRec.setSzNmNameMiddle(pInputMsg419.PrsnSearchInRec.getSzNmNameMiddle());
            if (OPTION_CHECKED == pInputMsg419.PrsnSearchInRec.getBScrPhoneticChk()[0]) {
                if (pInputMsg419.PrsnSearchInRec.getSzNmNameFirst().length() != 0) {
                    SSANameStruct.szNmNameFirst = pInputMsg419.PrsnSearchInRec.getSzNmNameFirst();
                }
                else {
                }
                if (pInputMsg419.PrsnSearchInRec.getSzNmNameLast().length() != 0) {
                    SSANameStruct.szNmNameLast = pInputMsg419.PrsnSearchInRec.getSzNmNameLast();
                }
                else {
                }
                // SIR 22686 if group home is false, save 63A-D else save 63A-C
                if (pInputMsg419.PrsnSearchInRec.getSzNmNameMiddle().length() != 0) {
                    SSANameStruct.szNmNameMiddle = pInputMsg419.PrsnSearchInRec.getSzNmNameMiddle();
                }
                else {
                }
                rc = ARC_SSACreateKeys(SSANameStruct);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                switch (SSANameStruct.usSysNbrSSANamePhkKeys) {
                    case WW_RANGE_RETURNED:
                        pCINT23DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(0, SSANameStruct.szSysNmSSARngFrmPhk[1]);
                        pCINT23DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(1, SSANameStruct.szSysNmSSARngToPhk[1]);
                        pCINT23DInputRec.getSzNmPhkNameNarr_ARRAY().setSzNmPhkNameNarr(0, SSANameStruct.szSysNmSSARngFrmPhk[0]);
                        pCINT23DInputRec.getSzNmPhkNameNarr_ARRAY().setSzNmPhkNameNarr(1, SSANameStruct.szSysNmSSARngToPhk[0]);
                        break;
                    case WI_RANGE_RETURNED:
                    case W_RANGE_RETURNED:
                        //  Anything but success us unacceptable
                        pCINT23DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(0, SSANameStruct.szSysNmSSARngFrmPhk[0]);
                        
                        pCINT23DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(1, SSANameStruct.szSysNmSSARngToPhk[0]);
                        break;
                        
                    default :
                        break;
                }
                pCINT23DInputRec.getSzCdPhkNameType_ARRAY().setSzCdPhkNameType(0, ARC_SSA_NAME);
            }
            else // Exact Name Search
            {
                pCINT23DInputRec.setSzNmNameFirst(pInputMsg419.PrsnSearchInRec.getSzNmNameFirst());
                pCINT23DInputRec.setSzNmNameLast(pInputMsg419.PrsnSearchInRec.getSzNmNameLast());
                pCINT23DInputRec.setSzNmNameMiddle(pInputMsg419.PrsnSearchInRec.getSzNmNameMiddle());
                pCINT23DInputRec.setScrPartlNameChk(pInputMsg419.PrsnSearchInRec.getScrPartlNameChk());
                pCINT23DInputRec.setBUNKNOWNDOBSEARCH(pInputMsg419.PrsnSearchInRec.getBUNKNOWNDOBSEARCH());
            }
            pCINT23DInputRec.setCCdPersonSex(pInputMsg419.PrsnSearchInRec.getCCdPersonSex());
            rc = ARC_UTLGetDateAndTime(dtCurrentDate, 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            if (pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth().year <= 0 && pInputMsg419.PrsnSearchInRec.getLNbrPersonAge() > 0) {
                pInputMsg419.PrsnSearchInRec.setDtDtPersonBirth(dtCurrentDate);
                
                dtDateToAdd.year = 0 - pInputMsg419.PrsnSearchInRec.getLNbrPersonAge();
                
                //  Call CheckStageEventStatus
                rc = ARC_UTLAddToDate((FndInt3date) & pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth() , (FndInt3date) & dtDateToAdd);
                //  Anything but success us unacceptable
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            
            // Update the selected records from previous DAM
            if (pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth().year > 0) {
                if (pInputMsg419.PrsnSearchInRec.getBUNKNOWNDOBSEARCH() == Cint14s.INDICATOR_NO) {
                    
                    pCINT23DInputRec.setDtDtPersonBirth(pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth());
                    pCINT23DInputRec.setDtDtPersonBirth2(pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth());
                    
                    // Insert new records into Contract_County
                    if ((dtCurrentDate.year - pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth().year) >= ADULT_AGE_RANGE_START) {
                        dtDateToAdd.year = 0 - ADULT_AGE_RANGE_VALUE;
                        // DAM CINV34D is always called. This DAM handles edits for Victim
                        // DOB, Person Search, and Person Characteristics. At least one of
                        // these edits is always required.
                        rc = ARC_UTLAddToDate((FndInt3date) & pCINT23DInputRec.getDtDtPersonBirth() , (FndInt3date) & dtDateToAdd);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        dtDateToAdd.year = ADULT_AGE_RANGE_VALUE;
                        
                        //  SIR 14996 - Added Dams to return principles and reason of death.
                        // and do an Edit check that principle with a reason of death is
                        // a victim in an allegation with a disposition of RTB
                        rc = ARC_UTLAddToDate((FndInt3date) & pCINT23DInputRec.getDtDtPersonBirth2() , (FndInt3date) & dtDateToAdd);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    else // Age is under 18 years old
                    {
                        dtDateToAdd.year = 0 - CHILD_AGE_RANGE_VALUE;
                        rc = ARC_UTLAddToDate((FndInt3date) & pCINT23DInputRec.getDtDtPersonBirth() , (FndInt3date) & dtDateToAdd);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        dtDateToAdd.year = CHILD_AGE_RANGE_VALUE;
                        //  Set all TODOs associated with event to COMPLETED
                        rc = ARC_UTLAddToDate((FndInt3date) & pCINT23DInputRec.getDtDtPersonBirth2() , (FndInt3date) & dtDateToAdd);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                else // UNKNOWNDOBSEARCH Flag = True  - copy in exact DOB as entered
                {
                    pCINT23DInputRec.setDtDtPersonBirth(pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth());
                    pCINT23DInputRec.setDtDtPersonBirth2(pInputMsg419.PrsnSearchInRec.getDtDtPersonBirth());
                }
            }
            if (OPTION_CHECKED == pInputMsg419.PrsnSearchInRec.getBScrAddressChk()[0]) {
                pCINT23DInputRec.setSzAddrPersAddrStLn1(pInputMsg419.PrsnSearchInRec.getSzAddrPersAddrStLn1());
                pCINT23DInputRec.setSzAddrPersAddrStLn2(pInputMsg419.PrsnSearchInRec.getSzAddrPersAddrStLn2());
                pCINT23DInputRec.setSzAddrCity(pInputMsg419.PrsnSearchInRec.getSzAddrCity());
                pCINT23DInputRec.setSzCdAddrState(pInputMsg419.PrsnSearchInRec.getSzCdAddrState());
                pCINT23DInputRec.setLAddrZip(pInputMsg419.PrsnSearchInRec.getLAddrZip());
                pCINT23DInputRec.setSzCdAddrCounty(pInputMsg419.PrsnSearchInRec.getSzCdAddrCounty());
            }
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
            if (OPTION_CHECKED == pInputMsg419.PrsnSearchInRec.getBScrAdditParametersChk()[0]) {
                pCINT23DInputRec.setSzNbrPersonIdSsn(pInputMsg419.PrsnSearchInRec.getSzNbrPersonIdSsn());
                pCINT23DInputRec.setLNbrPhone(pInputMsg419.PrsnSearchInRec.getLNbrPhone());
                pCINT23DInputRec.setUlIdPerson(pInputMsg419.PrsnSearchInRec.getUlIdPerson());
                
                // UPGRADE 2000 ITEM 3 If age is entered calculate birthdate. This is done because
                // age and birthdate are mutually exclusive.  If age is entered, determine
                // an approximate DOB to pass into the new MATCH service of SSA-NAME3 for
                // scoring. After DOB is determined or when DOB is entered on window,
                // then determine DOB range to be used in finding matches and scoring
                
                //  (KRD 03/09/2001) Modified all of the date logic below to use the
                // ARC_UTLAddToDate() API rather than increasing the date manually to
                // avoid "Invalid Date" issues when adding/subtracting years from
                // Leap Day (February 29th).
                
                ARC_UTLGetDateAndTime(dtCurrentDate, 0);
            }
            pCINT23DInputRec.setCCdPersonSex(pInputMsg419.PrsnSearchInRec.getCCdPersonSex());
            pCINT23DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg419.ArchInputStruct.getUsPageNbr());
            pCINT23DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg419.ArchInputStruct.getUlPageSizeNbr());
            
            //  Retrieve all the events associated with the Investigation
            rc = cint23dQUERYdam(sqlca, pCINT23DInputRec, pCINT23DOutputRec);
            if (rc != 0) {
                
                
                
                //  Analyze return code
                switch (rc) {
                        
                    case NO_DATA_FOUND:
                        
                    case ARC_SSA_ERROR:
                        break;
                    case Messages.MSG_NAME_TOO_COMMON:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = Messages.MSG_NAME_TOO_COMMON;
                        break;
                    case Messages.MSG_INT_INTERNAL_SQL_ERROR:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                        
                    default :
                        
                        //## BEGIN TUX/XML: Declare XML variables 
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            else {
                //  Populate Output Message
                //  SIR 2085: && rc = 0 to for statment
                for (i251 = 0;i251 < pCINT23DOutputRec.getArchOutputStruct().getUlRowQty() && rc == 0;++i251) {
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameFirst(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzNmNameFirst());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameMiddle(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzNmNameMiddle());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameLast(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzNmNameLast());
                    rc = Cint05s.ARC_UTLProduceFullName(pOutputMsg385.PrsnSearchOutRec[i251].getSzNmPersonFull() , FULL_NAME_LEN, pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzNmNameFirst() , pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzNmNameMiddle() , pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzNmNameLast());
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNmIncmgPersFull(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzNmIncmgPersFull());
                    if (0 == pOutputMsg385.PrsnSearchOutRec[i251].getSzNmIncmgPersFull().compareTo(pOutputMsg385.PrsnSearchOutRec[i251].getSzNmPersonFull())) {
                        pOutputMsg385.PrsnSearchOutRec[i251].getSzScrCdPersonSearchHit()[0] = Cint14s.INDICATOR_NO;
                    }
                    else {
                        pOutputMsg385.PrsnSearchOutRec[i251].getSzScrCdPersonSearchHit()[0] = INDICATOR_YES;
                    }
                    // 
                    // (END): Common Function: ccmn06u   Check Stage/Event common function
                    // 
                    
                    
                    if ((pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonBirth().year <= 0) && (pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonDeath().year <= 0)) {
                        pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge(0);
                    }
                    else if (pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonDeath().year > 0) {
                        if ((pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonBirth().month > pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonDeath().month) || (pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonBirth().day > pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonDeath().day) && (pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonBirth().month == pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonDeath().month)) {
                            pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge((pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonDeath().year - pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonBirth().year) - 1);
                        }
                        else {
                            pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge((pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonDeath().year - pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonBirth().year));
                        }
                    }
                    else {
                        ARC_UTLCalcAgeFromDate(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonBirth() , pOutputMsg385.PrsnSearchOutRec[i251].getLNbrPersonAge());
                    }
                    pOutputMsg385.PrsnSearchOutRec[i251].setDtDtPersonDeath(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonDeath());
                    pOutputMsg385.PrsnSearchOutRec[i251].setDtDtPersonBirth(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtPersonBirth());
                    pOutputMsg385.PrsnSearchOutRec[i251].setDtDtNameEndDate(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getDtDtNameEndDate());
                    pOutputMsg385.PrsnSearchOutRec[i251].setCCdPersonSex(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getCCdPersonSex());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzCdPersonEthnicGroup(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzCdPersonEthnicGroup());
                    pOutputMsg385.PrsnSearchOutRec[i251].setUlIdPerson(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getUlIdPerson());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzAddrCity(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzAddrCity());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzCdCounty(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzCdAddrCounty());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzAddrPersAddrStLn1(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzAddrPersAddrStLn1());
                    pOutputMsg385.PrsnSearchOutRec[i251].setSzNbrPersonIdSsn(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getSzNbrPersonIdSsn());
                    pOutputMsg385.PrsnSearchOutRec[i251].setUsScrIndScore(pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getUsScrIndScore());
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                    // 01/22/2003 DWW: Added for error handling
                    if ((0 == rc) && (CD_STATUS_MERGED == pCINT23DOutputRec.getROWCINT23DO_ARRAY().getROWCINT23DO(i251).getCdPersonStatus()[0])) {
                        pCSEC67DInputRec.setArchInputStruct(pInputMsg419.ArchInputStruct);
                        pCSEC67DInputRec.setUlIdPerson(pOutputMsg385.PrsnSearchOutRec[i251].getUlIdPerson());
                        rc = csec67dQUERYdam(sqlca, pCSEC67DInputRec, pCSEC67DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameFirst(pCSEC67DOutputRec.getSzNmNameFirst());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameMiddle(pCSEC67DOutputRec.getSzNmNameMiddle());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzNmNameLast(pCSEC67DOutputRec.getSzNmNameLast());
                                rc = Cint05s.ARC_UTLProduceFullName(pOutputMsg385.PrsnSearchOutRec[i251].getSzNmIncmgPersFull() , FULL_NAME_LEN, pCSEC67DOutputRec.getSzNmNameFirst() , pCSEC67DOutputRec.getSzNmNameMiddle() , pCSEC67DOutputRec.getSzNmNameLast());
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                pOutputMsg385.PrsnSearchOutRec[i251].getSzNmPersonFull()[0] = null;
                                pOutputMsg385.PrsnSearchOutRec[i251].getSzScrCdPersonSearchHit()[0] = Cint14s.INDICATOR_NO;
                                
                                if ((pCSEC67DOutputRec.getDtDtPersonBirth().year > 0) && (pCSEC67DOutputRec.getDtDtPersonDeath().year <= 0)) {
                                    ARC_UTLCalcAgeFromDate(pCSEC67DOutputRec.getDtDtPersonBirth() , pOutputMsg385.PrsnSearchOutRec[i251].getLNbrPersonAge());
                                }
                                else if (pCSEC67DOutputRec.getDtDtPersonDeath().year > 0) {
                                    
                                    if ((pCSEC67DOutputRec.getDtDtPersonBirth().month > pCSEC67DOutputRec.getDtDtPersonDeath().month) || (pCSEC67DOutputRec.getDtDtPersonBirth().day > pCSEC67DOutputRec.getDtDtPersonDeath().day) && (pCSEC67DOutputRec.getDtDtPersonBirth().month == pCSEC67DOutputRec.getDtDtPersonDeath().month)) {
                                        pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge((pCSEC67DOutputRec.getDtDtPersonDeath().year - pCSEC67DOutputRec.getDtDtPersonBirth().year) - 1);
                                    }
                                    else {
                                        pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge((pCSEC67DOutputRec.getDtDtPersonDeath().year - pCSEC67DOutputRec.getDtDtPersonBirth().year));
                                    }
                                }
                                
                                if (pOutputMsg385.PrsnSearchOutRec[i251].getLNbrPersonAge() < 1) {
                                    pOutputMsg385.PrsnSearchOutRec[i251].setLNbrPersonAge(0);
                                }
                                pOutputMsg385.PrsnSearchOutRec[i251].setCCdPersonSex(pCSEC67DOutputRec.getCCdPersonSex());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzCdPersonEthnicGroup(pCSEC67DOutputRec.getSzCdPersonEthnicGroup());
                                pOutputMsg385.PrsnSearchOutRec[i251].setUlIdPerson(pCSEC67DOutputRec.getUlIdPerson());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzAddrCity(pCSEC67DOutputRec.getSzAddrCity());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzCdCounty(pCSEC67DOutputRec.getSzCdAddrCounty());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzAddrPersAddrStLn1(pCSEC67DOutputRec.getSzAddrPersAddrStLn1());
                                pOutputMsg385.PrsnSearchOutRec[i251].setSzNbrPersonIdSsn(pCSEC67DOutputRec.getSzNbrPersonIdSsn());
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                break;
                        }
                    }
                };
                pOutputMsg385.ArchOutputStruct.setUlRowQty(pCINT23DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg385.ArchOutputStruct.setBMoreDataInd(pCINT23DOutputRec.getArchOutputStruct().getBMoreDataInd());
            }
        }
        
        
        return rc;
    }

    
    static int CallCMSC49D(CINT09SI pInputMsg420, CINT09SO pOutputMsg386, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        
        /*
        ** Declare local variables
        */
        CMSC49DI pCMSC49DInputRec = null;
        CMSC49DO pCMSC49DOutputRec = null;
        int i252 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCMSC49DInputRec = new CMSC49DI();
        
        pCMSC49DOutputRec = new CMSC49DO();
        
        
        for (i252 = 0;i252 < pOutputMsg386.ArchOutputStruct.getUlRowQty();++i252) {
            pCMSC49DInputRec.setArchInputStruct(pInputMsg420.ArchInputStruct);
            pCMSC49DInputRec.setUlIdPerson(pOutputMsg386.PrsnSearchOutRec[i252].getUlIdPerson());
            rc = cmsc49dQUERYdam(sqlca, pCMSC49DInputRec, pCMSC49DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    if (pCMSC49DOutputRec.getUlSysNbrGenericCntr() > 0) {
                        pOutputMsg386.PrsnSearchOutRec[i252].setCWcdIndMerge(true);
                    }
                    else {
                        pOutputMsg386.PrsnSearchOutRec[i252].setCWcdIndMerge(false);
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCINT72D(CINT09SI pInputMsg421, CINT09SO pOutputMsg387, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        
        /*
        ** Declare local variables
        **
        ** SIR 5181: Prior to this fix, the declaration of the 'rc' variable
        **           below looked like this: long rc;    * Return code *
        **           For this fix, I initialized rc to zero when it is declared.
        **           When pOutputMsg->ArchOutputStruct.ulRowQty = 0 and a phonetic
        **           search is chosen (on the window), the 'rc' variable always
        **           has a garbage number in it, and this garbage number is
        **           returned from this function, causing an Internal Error message.
        **           By initializing rc to zero, we avoid having any 'left-over'
        **           values stored in 'rc'.
        */
        CINT72DI pCINT72DInputRec = null;
        CINT72DO pCINT72DOutputRec = null;
        int i253 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT72DInputRec = new CINT72DI();
        
        pCINT72DOutputRec = new CINT72DO();
        
        
        /*
        ** Populate Input Structure for DAM
        */
        for (i253 = 0;i253 < pOutputMsg387.ArchOutputStruct.getUlRowQty();++i253) {
            pCINT72DInputRec.setUlIdPerson(pOutputMsg387.PrsnSearchOutRec[i253].getUlIdPerson());
            pCINT72DInputRec.setArchInputStruct(pInputMsg421.ArchInputStruct);
            
            
            //  Call CSES87D
            rc = cint72dQUERYdam(sqlca, pCINT72DInputRec, pCINT72DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pOutputMsg387.PrsnSearchOutRec[i253].setBSysIndViewPersonInfo(pCINT72DOutputRec.getBSysIndViewPersonInfo());
                    break;
                case NO_DATA_FOUND:
                    pOutputMsg387.PrsnSearchOutRec[i253].setBSysIndViewPersonInfo(pCINT72DOutputRec.getBSysIndViewPersonInfo());
                    rc = 0;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    i253 = pOutputMsg387.ArchOutputStruct.getUlRowQty();
            }
        }
        return rc;
    }

    static int CallCINV29D(CINT09SI pInputMsg422, CINT09SO pOutputMsg388, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV29DI pCINV29DInputRec = null;
        CINV29DO pCINV29DOutputRec = null;
        
        int sPersonIndex = 0;
        int sCatIndex = 0;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINV29DInputRec = new CINV29DI();
        
        pCINV29DOutputRec = new CINV29DO();
        pCINV29DInputRec.setArchInputStruct(pInputMsg422.ArchInputStruct);
        pCINV29DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        
        
        /*
        ** Populate Input Structure for DAM
        */
        for (sPersonIndex = 0;sPersonIndex < pOutputMsg388.ArchOutputStruct.getUlRowQty();++sPersonIndex) {
            pCINV29DInputRec.setUlIdPerson(pOutputMsg388.PrsnSearchOutRec[sPersonIndex].getUlIdPerson());
            rc = cinv29dQUERYdam(sqlca, pCINV29DInputRec, pCINV29DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set the employee indicator to true if the
                    // one of the rows returned has a category
                    // of employee
                    for (sCatIndex = 0;(sCatIndex < pCINV29DOutputRec.getArchOutputStruct().getUlRowQty());sCatIndex++) {
                        
                        if (pCINV29DOutputRec.getROWCINV29DO_ARRAY().getROWCINV29DO(sCatIndex).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY)) {
                            pOutputMsg388.PrsnSearchOutRec[sPersonIndex].setBIndActiveStatus(true);
                        }
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    pOutputMsg388.PrsnSearchOutRec[sPersonIndex].setBIndActiveStatus(false);
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        return 0;
    }

    int UTLAddDates(FndInt3date Date1, FndInt3date Date2) {
        int rc = 0;/* Return code */
        FndInt3date WorkDate = null;/* Work area for calculations */
        int iDaysInCurrentMonth = 0;
        int[] iDaysInMonth = new int[]{
            
            // 
            // Prepare output message to be returned and return
            // 
            
            //  Calculate the output message size
            31,
             28,
             
            
            
            // 
            // Prepare output message to be returned and return
            // 
            
            //  Calculate the output message size
            31,
             30,
             
            31,
             30,
             31,
             
            
            //  Calculate Output Message Size
            31,
             30,
             31,
             
            30,
             31};
        WorkDate = Date1;
        
        /* Add years first */
        WorkDate.year += Date2.year;
        
        /* Add months */
        WorkDate.month += Date2.month;
        
        /*
        ** Call CSEC12D if NbrCnperPeriod <> 1 (NUM_PERIOD)
        */
        if (WorkDate.month < 1) {
            WorkDate.month += 12;
            WorkDate.year--;
        }
        else if (WorkDate.month > 12) {
            WorkDate.month -= 12;
            WorkDate.year++;
        }
        
        /* Add days */
        WorkDate.day += Date2.day;
        if (WorkDate.month > 0) {
            iDaysInCurrentMonth = iDaysInMonth[(WorkDate.month) - 1];
        }
        else {
            iDaysInCurrentMonth = iDaysInMonth[12 + ((WorkDate.month) - 1) ];
        }
        if (WorkDate.day > iDaysInCurrentMonth) {
            WorkDate.day -= iDaysInCurrentMonth;
            WorkDate.month++;
        }
        else if (WorkDate.day < 1) {
            if (WorkDate.month > 1) {
                iDaysInCurrentMonth = iDaysInMonth[(WorkDate.month) - 2];
            }
            else {
                iDaysInCurrentMonth = iDaysInMonth[12 + ((WorkDate.month) - 2) ];
            }
            
            WorkDate.day += iDaysInCurrentMonth;
            WorkDate.month--;
        }
        
        if (WorkDate.month < 1) {
            WorkDate.month += 12;
            WorkDate.year--;
            
        }
        else if (WorkDate.month > 12) {
            WorkDate.month -= 12;
            WorkDate.year++;
        }
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Retrieve CAPS RESOURCE row for a given Id Stage if
        ** LIC_MODIFY
        */
        if ((WorkDate.month < 0 || WorkDate.month > 12) || (WorkDate.day < 0) || (WorkDate.year < 0)) {
            return - 1;
        }
        else {
            Date1 = WorkDate;
        }
        return 0;
        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        
        
        
    }

    
    static int ARC_UTLProduceFullName(String szFullName, int iFullNameSize, String szFirstName, String szMiddleName, String szLastName) {
        if (iFullNameSize < 26) {
            return ARC_UTL_ERR_INPUT_TOO_SMALL;
        }
        Arrays.fill(szFullName, 0, iFullNameSize, 0);
        
        if (szLastName != null) {
            szFullName = szLastName;
        }
        szFullName += ",";
        
        if (szFirstName != null) {
            strncat(szFullName, szFirstName, 8);
        }
        
        if ((szMiddleName != null) && (szMiddleName.length != 0)) {
            szFullName += " ";
            strncat(szFullName, szMiddleName, 1);
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

}
