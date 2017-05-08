package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC67DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccfc23s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC49DO;
/**************************************************************************
**
** Module File:   cint05s.src
**
** Service Name:  cint05s
**
** Description:   Asynchronous Hierarchical Background Search
**                Based on the information sent to this service from the
**                Call Person Detail window, the following searches are
**                performed:
**
**                On Social Security Number
**                On Phonetic First Name and Street Line 1, City, County
**                On Phonetic Full Name and Street Line 1, City, County
**                On Phonetic Full Name and Age
**                On Phonetic Full Name
**                On Phone Number
**
**                If SSN exists, that search is performed.  If data is
**                returned from the SSN search, the service ends and that
**                data is returned to the client.  If no data is returned,
**                the next search for which all data inputs exist is
**                performed. The service continues to launch searches for
**                which all inputs are present until either a search has been
**                successful or no search options are left.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/1/95
**
** Programmer:    MJH
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/01/95  ELLIOTSL  ERR #1995: Input/Output records for CINT08D are
**                      now being memset to NULL before the DAM is called.
**
**  05/17/96  ZIMMERNE  SIR #21223 - Changed the output msg size calc.
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
**  10/15/96    KRD     General code cleanup for readability/maintenance
**                      purposes.
**  05/14/97  hendercr  SIRs #12311 and 13703 - Removed call to dam
**                      CSEC67D, this was causing duplicate rows to be
**                      returned from the person search.  Modified code
**                      to always populate the age on the Person Search
**                      window.
**
** 5/20/97 hendercr  SIR 21286:  Added call to dam CMSC49D, which will
**                   retrieve a count from the Person Merge table.  If the
**                   dam returns a count > 0, the Merge Indicator flag is
**                   set to true, else the Merge Indicator flag is set to
**                   false.  Added a Merge Indicator check box column to
**                   the Person Search Listbox; which will indicate if the
**                   person was merged.
**
**  04/26/99 sniderdl   MIGFCP32 - changed _HIERSRCHOUTREC_PRSNSRCHLISTPINIT_
**          to _HIERSRCHOUTREC_PRSNSRCHLISTPINI_SIZE.  FND 3.2
**          generates entire names where FND 2.4 did not.
**
**  10/30/00 UPGRADE 2000 PCG Upgrade SSANAME3 software from Version 1.7 to
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
**                           of phonetic keys (narrower range).  A narrower
**                           range is only available if the full first and
**                           last Names are entered.  If the first initial
**                           and last name are entered only one phonetic
**                           range can be created.
**
**                 ITEM 2 -  Add variables to pass gender to the query
**                           DAM (cint08d.pc).  If 'M' or 'F' is entered, the
**                           query will bring back the gender entered and 'U'
**                           for unknown that match the name entered.
**
**                 ITEM 3 -  Modified the handling of DOB in search.  Because
**                           DOB will be used for scoring, a DOB range will be
**                           determined for both exact and phonetic searches.
**                           The DOB range will remain the same.  If Age is
**                           entered an approximate DOB is determined to pass
**                           into SSA-NAME3' MATCH service. If the age of the
**                           returned match is less than one year old age will
**                           be populated with a "0". This distinguish matches
**                           who are under the age of 1 and matches which do
**                           not have birthdates.
**
**                 ITEM 4 -  SCORE is now a column in the Person Search Detail
**                           List Box. SCORE is the last column to the right.
**                           Cint05s.src needs to pass the score back
**                           to client.
**
**                 ITEM 5 -  If the name returned from the query is an AKA
**                           match a new column called MATCH NAME will be
**                           populated with the AKA name.  The NAME column is
**                           moved to the second column from the right and
**                           renamed PRIMARY NAME. The primary name associated
**                           with the AKA match will be populated in the
**                           PRIMARY NAME column.  If the name match is not an
**                           AKA match, the primary name will populate the
**                           MATCH NAME column.  An AKA name will be identified
**                           by "AKA" in the MATCH column.  "IND_NAME_PRIMARY"
**                           is added to the output copybooks so that the
**                           information can be passed back to the services
**                           (cint09s.src and cint05s.src)to return indicator
**                           to window (cint09w.win). The window will use this
**                           indicator to populate the Person Search List Box.
**
**  01/09/2001  KRD     CINT08D can return errors other than just the standard
**                      SQL errors.  We were not trapping these errors leading
**                      to the server unexplicably dying.  Required changes to
**                      CallCINT08D().
**
**  03/01/2001  KRD     The Match column isn't being set correctly when
**                      a match is made on an AKA Name. The "aka name found"
**                      flag should be set based on a comparison of the two
**                      names that are returned (NM_PERSON_FULL from the
**                      PERSON table and a NM_PERSON_FULL built on the
**                      first/middle/last names from the NAME table).
**                      Required changes to CallCINT08D().
**
**  03/09/2001  KRD     Searches that involve a date range should use the
**                      ARC_UTLAddToDate() API rather than increasing the
**                      year manually to avoid potential Date Invalid
**                      issues.  Required changes to CallCINT08D().
**
**  03/12/2001  KRD     Added "Person Search Failsafe" as a contingency
**                      for possible timeouts in Production.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/





public class Cint05s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int FULL_NAME_LEN = 26;
    public static final char CD_STATUS_MERGED = 'M';
    public static final String EMPLOYEE_CATEGORY = "EMP";
    public static final int ARC_UTL_ERR_INPUT_TOO_SMALL = 13006;
    
    /* UPGRADE 2000 ITEM 1 These values tell the service if there is one or two phonetic
    ranges available for phonetic search */
    
    public static final int WW_RANGE_RETURNED = 5;
    public static final int WI_RANGE_RETURNED = 4;
    public static final int W_RANGE_RETURNED = 3;
    
    /* UPGRADE 2000 ITEM 3 Use DOB range in asynchronous search */
    
    public static final int ADULT_AGE_RANGE_START = 18;
    public static final int ADULT_AGE_RANGE_VALUE = 10;
    public static final int CHILD_AGE_RANGE_VALUE = 3;
    CINT05SO CINT05S(CINT05SI cint05si) {
        CINT05SO cint05so = new CINT05SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(cint05si.ArchInputStruct);
        rc = CallCINT08D(cint05si, cint05so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (cint05so.ArchOutputStruct.getUlRowQty() > 0) {
            rc = Cint09s.CallCMSC49D(cint05si, cint05so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** end FND 3.2 Migration change
        */
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint05si.ArchInputStruct, cint05so.ArchOutputStruct);
        
        /*
        ** LICENSING
        **
        ** Disposition & Corresponding Role:
        **  Reason to Believe = DV
        **  Unable To Determine = UD
        **  Ruled Out = NO
        */
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
        return cint05so;
    }

    static int CallCINT08D(CINT05SI pInputMsg400, CINT05SO pOutputMsg366, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT08DI pCINT08DInputRec = null;
        CINT08DO pCINT08DOutputRec = null;
        CSEC67DI pCSEC67DInputRec = null;
        CSEC67DO pCSEC67DOutputRec = null;
        _SSANAMESTRUCT SSANameStruct;
        int i244 = 0;
        int j = 0;/* SIRs 12311 and 13703 */
        FndInt3date dtCurrentDate = new FndInt3date( - 1, /* Current date */
         - 1, - 1);
        FndInt3date dtDateToAdd = new FndInt3date(0, 0, 0);
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT08DInputRec = new CINT08DI();
        
        pCINT08DOutputRec = new CINT08DO();
        
        pCSEC67DInputRec = new CSEC67DI();
        
        pCSEC67DOutputRec = new CSEC67DO();
        pCINT08DInputRec.setArchInputStruct(pInputMsg400.ArchInputStruct);
        pCINT08DInputRec.setSzAddrPersAddrStLn1(pInputMsg400.HierPersSrchRec.getSzAddrPersAddrStLn1());
        pCINT08DInputRec.setSzAddrPersAddrStLn2(pInputMsg400.HierPersSrchRec.getSzAddrPersAddrStLn2());
        pCINT08DInputRec.setSzAddrCity(pInputMsg400.HierPersSrchRec.getSzAddrCity());
        pCINT08DInputRec.setSzCdAddrState(pInputMsg400.HierPersSrchRec.getSzCdAddrState());
        pCINT08DInputRec.setLAddrZip(pInputMsg400.HierPersSrchRec.getLAddrZip());
        pCINT08DInputRec.setSzCdAddrCounty(pInputMsg400.HierPersSrchRec.getSzCdAddrCounty());
        pCINT08DInputRec.setSzNbrPersonIdSsn(pInputMsg400.HierPersSrchRec.getSzNbrPersonIdSsn());
        pCINT08DInputRec.setLSysNbrUniqueLBKey(pInputMsg400.HierPersSrchRec.getLSysNbrUniqueLBKey());
        pCINT08DInputRec.setCCdPersonSex(pInputMsg400.HierPersSrchRec.getCCdPersonSex());
        pCINT08DInputRec.setBASearchFlag(1);
        
        /*
        ** retrieve the current system date
        */
        ARC_UTLGetDateAndTime(dtCurrentDate, 0);
        if (pInputMsg400.HierPersSrchRec.getDtDtPersonBirth().year <= 0 && pInputMsg400.HierPersSrchRec.getLNbrPersonAge() > 0) {
            
            pInputMsg400.HierPersSrchRec.setDtDtPersonBirth(dtCurrentDate);
            
            dtDateToAdd.year = 0 - pInputMsg400.HierPersSrchRec.getLNbrPersonAge();
            rc = ARC_UTLAddToDate((FndInt3date) & pInputMsg400.HierPersSrchRec.getDtDtPersonBirth() , (FndInt3date) & dtDateToAdd);
            
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (pInputMsg400.HierPersSrchRec.getDtDtPersonBirth().year > 0) {
            
            
            pCINT08DInputRec.setDtDtPersonBirth(pInputMsg400.HierPersSrchRec.getDtDtPersonBirth());
            pCINT08DInputRec.setDtDtPersonBirth2(pInputMsg400.HierPersSrchRec.getDtDtPersonBirth());
            
            //  Analyze error code
            if ((dtCurrentDate.year - pInputMsg400.HierPersSrchRec.getDtDtPersonBirth().year) >= ADULT_AGE_RANGE_START) {
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
                //  Call CLSS68D:
                // SELECT * FROM CONTRACT_COUNTY C WHERE C.ID_CONTRACT =
                // AND C.NBR_CNCNTY_PERIOD  =        AND C.NBR_CNCNTY_VERSION =
                rc = ARC_UTLAddToDate((FndInt3date) & pCINT08DInputRec.getDtDtPersonBirth2() , (FndInt3date) & dtDateToAdd);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        if (pInputMsg400.HierPersSrchRec.getSzNmNameFirst().length() != 0) {
            SSANameStruct.szNmNameFirst = pInputMsg400.HierPersSrchRec.getSzNmNameFirst();
        }
        else {
        }
        if (pInputMsg400.HierPersSrchRec.getSzNmNameLast().length() != 0) {
            SSANameStruct.szNmNameLast = pInputMsg400.HierPersSrchRec.getSzNmNameLast();
        }
        else {
        }
        
        /*
        ** Analyze error code
        */
        if (pInputMsg400.HierPersSrchRec.getSzNmNameMiddle().length() != 0) {
            SSANameStruct.szNmNameMiddle = pInputMsg400.HierPersSrchRec.getSzNmNameMiddle();
        }
        else {
        }
        rc = ARC_SSACreateKeys(SSANameStruct);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Analyze error code
        */
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
                pCINT08DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(1, SSANameStruct.szSysNmSSARngToPhk[0]);
                break;
                
            default :
                break;
        }
        pCINT08DInputRec.setSzNmNameFirst(pInputMsg400.HierPersSrchRec.getSzNmNameFirst());
        pCINT08DInputRec.setSzNmNameLast(pInputMsg400.HierPersSrchRec.getSzNmNameLast());
        pCINT08DInputRec.setSzNmNameMiddle(pInputMsg400.HierPersSrchRec.getSzNmNameMiddle());
        rc = cint08dQUERYdam(sqlca, pCINT08DInputRec, pCINT08DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case Messages.MSG_NAME_TOO_COMMON:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = Messages.MSG_NAME_TOO_COMMON;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Copy all rows returned by search into output message
                
                for (i244 = 0;i244 < pCINT08DOutputRec.getArchOutputStruct().getUlRowQty();++i244) {
                    if ((0 == rc) && (CD_STATUS_MERGED != pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getCdPersonStatus()[0])) {
                        pOutputMsg366.PrsnSrchListpInit[j].setSzNmNameFirst(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzNmNameFirst());
                        pOutputMsg366.PrsnSrchListpInit[j].setSzNmNameMiddle(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzNmNameMiddle());
                        pOutputMsg366.PrsnSrchListpInit[j].setSzNmNameLast(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzNmNameLast());
                        rc = Cint09s.ARC_UTLProduceFullName(pOutputMsg366.PrsnSrchListpInit[j].getSzNmPersonFull() , FULL_NAME_LEN, pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzNmNameFirst() , pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzNmNameMiddle() , pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzNmNameLast());
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        pOutputMsg366.PrsnSrchListpInit[j].setSzNmIncmgPersFull(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzNmIncmgPersFull());
                        if ((pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonBirth().year <= 0) && (pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonDeath().year <= 0)) {
                            pOutputMsg366.PrsnSrchListpInit[j].setLNbrPersonAge(0);
                        }
                        else if (pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonDeath().year > 0) {
                            
                            //  Analyze error code
                            if ((pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonBirth().month > pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonDeath().month) || (pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonBirth().day > pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonDeath().day) && (pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonBirth().month == pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonDeath().month)) {
                                pOutputMsg366.PrsnSrchListpInit[j].setLNbrPersonAge((pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonDeath().year - pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonBirth().year) - 1);
                            }
                            else {
                                pOutputMsg366.PrsnSrchListpInit[j].setLNbrPersonAge((pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonDeath().year - pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonBirth().year));
                                
                            }
                        }
                        else {
                            ARC_UTLCalcAgeFromDate(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonBirth() , pOutputMsg366.PrsnSrchListpInit[j].getLNbrPersonAge());
                        }
                        pOutputMsg366.PrsnSrchListpInit[j].setDtDtPersonDeath(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonDeath());
                        pOutputMsg366.PrsnSrchListpInit[j].setDtDtPersonBirth(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtPersonBirth());
                        pOutputMsg366.PrsnSrchListpInit[j].setDtDtNameEndDate(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getDtDtNameEndDate());
                        pOutputMsg366.PrsnSrchListpInit[j].setBIndPersonDobApprox(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getBIndPersonDobApprox());
                        pOutputMsg366.PrsnSrchListpInit[j].setSzAddrPersAddrStLn1(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzAddrPersAddrStLn1());
                        pOutputMsg366.PrsnSrchListpInit[j].setCCdPersonSex(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getCCdPersonSex());
                        pOutputMsg366.PrsnSrchListpInit[j].setSzAddrCity(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzAddrCity());
                        pOutputMsg366.PrsnSrchListpInit[j].setSzCdPersonEthnicGroup(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzCdPersonEthnicGroup());
                        pOutputMsg366.PrsnSrchListpInit[j].setSzCdCounty(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzCdAddrCounty());
                        pOutputMsg366.PrsnSrchListpInit[j].setSzNbrPersonIdSsn(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getSzNbrPersonIdSsn());
                        pOutputMsg366.PrsnSrchListpInit[j].setUlIdPerson(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getUlIdPerson());
                        if (0 == pOutputMsg366.PrsnSrchListpInit[j].getSzNmIncmgPersFull().compareTo(pOutputMsg366.PrsnSrchListpInit[j].getSzNmPersonFull())) {
                            pOutputMsg366.PrsnSrchListpInit[j].getSzScrCdPersonSearchHit()[0] = Cint14s.INDICATOR_NO;
                        }
                        else {
                            pOutputMsg366.PrsnSrchListpInit[j].getSzScrCdPersonSearchHit()[0] = INDICATOR_YES;
                        }
                        pOutputMsg366.PrsnSrchListpInit[j].setUsScrIndScore(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getUsScrIndScore());
                        pOutputMsg366.PrsnSrchListpInit[i244].setBASearchFlag(pCINT08DOutputRec.getROWCINT08DO_ARRAY().getROWCINT08DO(i244).getBASearchFlag());
                        j++;
                    }
                }
                pOutputMsg366.ArchOutputStruct.setUlRowQty(pCINT08DOutputRec.getArchOutputStruct().getUlRowQty());
                
                pOutputMsg366.ArchOutputStruct.setBMoreDataInd(pCINT08DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  If MergeFrom Invalidate indicator is found to be TRUE than display
                // an error message and exit the service.
                //if (TRUE == bMergeFromInv)
                //{
                //  Set severity and explan_code to SUCCESS
                // Removed SIR 16903
                // pServiceStatus->severity = FND_SEVERITY_ERROR;
                // pServiceStatus->explan_code = MSG_CFC_FROM_ID_INV;
                // RetVal = MSG_CFC_FROM_ID_INV;
                //  Set rc to RetVal so TUX_CHECK_APPL_STATUS will work
                // Removed SIR 16903
                // rc = RetVal;
                //}
                break;
                
            case NO_DATA_FOUND:
            case ARC_SSA_ERROR:
                
                
                //  Call CINT20D
                rc = WtcHelperConstants.ARC_SUCCESS;
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                break;
            case Messages.MSG_INT_INTERNAL_SQL_ERROR:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        pOutputMsg366.lSysNbrUniqueLBKey = pInputMsg400.HierPersSrchRec.getLSysNbrUniqueLBKey();
        if (rc == WtcHelperConstants.SQL_SUCCESS) {
            rc = Ccfc23s.CallCINV29D(pInputMsg400, pOutputMsg366, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        return rc;
    }

    
    static int CallCINV29D(CINT05SI pInputMsg401, CINT05SO pOutputMsg367, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINV29DInputRec.setArchInputStruct(pInputMsg401.ArchInputStruct);
        
        
        /*
        ** Populate Input Structure for DAM
        */
        for (sPersonIndex = 0;sPersonIndex < pOutputMsg367.ArchOutputStruct.getUlRowQty();++sPersonIndex) {
            pCINV29DInputRec.setUlIdPerson(pOutputMsg367.PrsnSrchListpInit[sPersonIndex].getUlIdPerson());
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
                            
                            pOutputMsg367.PrsnSrchListpInit[sPersonIndex].setBIndActiveStatus(true);
                        }
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    pOutputMsg367.PrsnSrchListpInit[sPersonIndex].setBIndActiveStatus(false);
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        return 0;
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

    static int CallCMSC49D(CINT05SI pInputMsg402, CINT05SO pOutputMsg368, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CMSC49DI pCMSC49DInputRec = null;
        CMSC49DO pCMSC49DOutputRec = null;
        int i245 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCMSC49DInputRec = new CMSC49DI();
        
        pCMSC49DOutputRec = new CMSC49DO();
        
        
        for (i245 = 0;i245 < pOutputMsg368.ArchOutputStruct.getUlRowQty();++i245) {
            
            pCMSC49DInputRec.setArchInputStruct(pInputMsg402.ArchInputStruct);
            
            pCMSC49DInputRec.setUlIdPerson(pOutputMsg368.PrsnSrchListpInit[i245].getUlIdPerson());
            rc = cmsc49dQUERYdam(sqlca, pCMSC49DInputRec, pCMSC49DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    //  Populate DAM input structure
                    //  SIR#4274: There are two cases within the DAM to UPDATE
                    // the PLACEMENT table.  Updates from ACTUAL to ACTUAL
                    // use Case Update.  And Updates from PLANNED to ACTUAL
                    // use Case Indicator Yes.
                    // See SIR Description in DAM and in header.
                    if (pCMSC49DOutputRec.getUlSysNbrGenericCntr() > 0) {
                        pOutputMsg368.PrsnSrchListpInit[i245].setCWcdIndMerge(true);
                    }
                    else {
                        pOutputMsg368.PrsnSrchListpInit[i245].setCWcdIndMerge(false);
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    return rc;
            }
        }
        return rc;
    }

}
