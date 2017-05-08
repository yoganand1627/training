package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES35DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES37DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:   CFAD01U.SRC
**
** Service Name:  CFAD01U
**
** Description:   This common fuction will be used to maintain the Resource
**                Service and Resource Characteristics Tables for Foster
**                Adoptive Homes.  It can be called by the F/A Demographics
**                Save Service as well as the F/A Licence Save Service.
**                Note that in order for this fuction to execuate properly,
**                it must be called AFTER all updates to the caps_resource
**                table have been made.
**
**                The four change indicator flags should be set to TRUE or
**                FALSE.  If Characteristics have been added or deleted on
**                the interest window, all characteristics which are checked
**                should be passed along with the DtAdded.  If characteristics
**                were neither checked nor unchecked, nothing should be
**                passed in this group. The four approved ages should always
**                be passed.
**
**                If only ages have changed, the function will update the
**                Resource Characteristcs table with the new approved ages.
**
**                If the address for a resource has changed, the function
**                will update the Resource Service table with the new
**                county/region/state.
**
**                If F/A Home Types have been added or deleted or if the
**                Category of the Home has changed, the following Resource
**                Service Processing will be performed:
**
**                   - Determine what resource services currently exist
**                   - Determine what resource services need to exist
**                   - Set a flag if the two differ (bServiceChangeRequired)
**
**                If a service change is required or if characteristics
**                where added/deleted:
**
**                   - All characteristics rows are deleted.
**
**                If a service change is required:
**
**                   - Resource Service rows are added/deleted as necessary
**                   - The contract tables are added/maintained as necessary
**                     (**note:  logic to add/maintain the contract tables
**                      is a SIR and is not yet included**)
**
**                If characteristics have been added or deleted or if
**                Resource Service changes were made:
**                   - Characteristics for each resource service are re-built
**
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/28/95
**
** Programmer:    Barton H. McCleskey
**                Andersen Consulting
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   18 Jul 2000 08:40:12  $
**                      $Modtime:   12 Jun 2000 13:36:16  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/28/96  VISHNUR   SIR 3297 - Added CD_SERV_ADP_HME condition to check
**                      if the service is an Adoptive Home, to apply the
**                      category change for Resource_service.
**  3/5/96    PURCELA   SIR #3428 - In reference to SIR 3297, added condition
**                      that the Service Category should be set to Adoptive
**                      if the Service Type is Non Prs F/A Home.  If the
**                      PRS status of the home changed, then this needs to
**                      be trigerred as well as the Service itself being
**                      triggered to change from PRS F/A Home to Non PRS F/A
**                      Home.
**  03/12/96  VISHNUR   SIR #3775 - Added code to search for Non_recurring
**                      Subsidy adoptive home, if not found ADD it. Also
**                      added this condition that the Service category
**                      should be sent to Adoptive if the service type is
**                      Non_recurring Subsidy. This should happen if the home
**                      is originally Adoptive or category changed to
**                      Adoptive.
**  3/14/96   PURCELA   SIR #3865 - PURCELA - Added a condition to the if
**                      statement surrounding the Charactersitics rebuild
**                      section so that the logic will also be performed
**                      is a Service Change is required.  Otherwise, in this
**                      scenario, characteristics would be deleted and then
**                      not rebuilt.
**  05/20/96  OMARAJJ   SIR#21251 - Replaced the COPYSZ with MEMCPY for
**                      timestamp variables.
**  10/30/96  ZABIHIN   SIR 22232 - moved the address change section to the
**                      very end, otherwise the time stamp gets changed by
**                      CAUD9A, and creates a data access error for deleting
**                      an address.
**
** 9/10/2001    Hadjimh SIR #15787 & 13380: A change is requested to the
**                      Foster Care Rate Structure.  The revised structure will add the
**                      element of age to the determination of service code,
**                      The new rate structure will take effect September 1,
**                      2001, for services delivered after August 31, 2001.
**                      Regardless of whether the associated contract can serve LOC 1
**                      or LOC 1 and 2 clients, CONTRACT_SERVICE rows are currently set up
**                      for both level 1 (service code 95L) and level 2 (service code 95M).
**                      CONTRACT_COUNTY rows are linked to both. Because the contract is
**                      set up for both level 1 and level 2, the home may be incorrectly
**                      reimbursed at the level 2 rate.
**  09/09/03  A.Corley  SIR 19613 LOC Reduction -- Service Codes 60A-E are now
**                      being reduced to Service Codes 63A & B, updated the save
**                      to resource service to compare and save 63A & B (Basic and Moderate)
**  11/17/03  A.Corley  SIR 22390 LOC Reduction -- Add Specialized to save since it
**                      is now used for Prim Med, Ther, and Habil homes.
**  12/16/03  A.Corley  SIR 22485 LOC Reduction -- Add Intense to save since it
**                      is now used for Prim Med, Ther, and Habil homes.
**  12/16/03  A.Corley  SIR 22686 -- If the home is a group home, Intense should
**                      not be saved
**  05/21/04  gerryc    SIR 15891 - added Legal Risk and ICPC to category types
**                      that should have a Resource_Service for 96D
**                      (CD_SERV_ADP_SUB) and  96J(CD_SERV_ADP_NON_REC_SUB) made.
**                      Deleted the bFound condition from the for loop that looks
**                      to see which services can be deleted.  Increased the
**                      service array to 25 from 10, because when a foster home
**                      with all the possible levels was switched to a foster
**                      adoptive type, it ended up with more than 10 services
**                      at one point, which then caused 96J not to be added.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/**************************************************************************
** Service Macro Definitions
***************************************************************************/
public class Cfad01u {
    public static final String NULL_STRING = "";
    static int CFAD01U(CFAD01UI pInputMsg378, CFAD01UO pOutputMsg348, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        FndInt3date dtDtSystemDate = null;
        ushort Ccmn34s.i;
        ushort j;
        String szLocalCdRsrcState = new String();
        String szLocalCdRsrcCnty = new String();
        String szLocalCdRsrcCategory = new String();
        String szLocalCdRsrcRegion = new String();
        char cLocalCdRsrcFaHomeType1 = '\u0000';
        char cLocalCdRsrcFaHomeType2 = '\u0000';
        char cLocalCdRsrcFaHomeType3 = '\u0000';
        char cLocalCdRsrcFaHomeType4 = '\u0000';
        char cLocalCdRsrcFaHomeType5 = '\u0000';
        char cLocalCdRsrcFaHomeType6 = '\u0000';
        char cLocalCdRsrcFaHomeType7 = '\u0000';
        int[] ulLocalIdResourceService = new int[25];
        String[] tsLocalLastUpdate = new char[25][7];
        String[] szLocalCdRsrcSvcService = new char[25][4];
        String cLocalScrDataAction = new String();
        boolean bServiceChangeRequired = false;
        boolean bFound = false;
        
        /* SIR 22686 */
        boolean bGroupHome = false;
        char cLocalIndNonPrs = '\u0000';/* SIR #3428 */
        
        
        /*
        ** DAM Declarations
        */
        CAUDA6DI pCAUDA6DInputRec = null;
        CAUDA6DO pCAUDA6DOutputRec = null;
        CRES22DI pCRES22DInputRec = null;
        CRES22DO pCRES22DOutputRec = null;
        CAUDA8DI pCAUDA8DInputRec = null;
        CAUDA8DO pCAUDA8DOutputRec = null;
        CAUDA9DI pCAUDA9DInputRec = null;
        CAUDA9DO pCAUDA9DOutputRec = null;
        CLSS48DI pCLSS48DInputRec = null;
        CLSS48DO pCLSS48DOutputRec = null;
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        CRES35DI pCRES35DInputRec = null;
        CRES35DO pCRES35DOutputRec = null;
        CRES21DI pCRES21DInputRec = null;
        CRES21DO pCRES21DOutputRec = null;
        CRES37DI pCRES37DInputRec = null;
        CRES37DO pCRES37DOutputRec = null;
        pServiceStatus.severity = FND_SEVERITY_OK;
        pServiceStatus.explan_code = SUCCESS;
        szLocalCdRsrcState = NULL_STRING;
        szLocalCdRsrcCnty = NULL_STRING;
        szLocalCdRsrcCategory = NULL_STRING;
        szLocalCdRsrcRegion = NULL_STRING;
        cLocalCdRsrcFaHomeType1 = null;
        cLocalCdRsrcFaHomeType2 = null;
        cLocalCdRsrcFaHomeType3 = null;
        cLocalCdRsrcFaHomeType4 = null;
        cLocalCdRsrcFaHomeType5 = null;
        cLocalCdRsrcFaHomeType6 = null;
        cLocalCdRsrcFaHomeType7 = null;
        
        for (Ccmn34s.i = 0;Ccmn34s.i < 25;Ccmn34s.i++) {
            ulLocalIdResourceService[Ccmn34s.i] = 0;
            cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, null);
            tsLocalLastUpdate[Ccmn34s.i] = NULL_STRING;
            szLocalCdRsrcSvcService[Ccmn34s.i] = NULL_STRING;
        }
        
        /*
        ** Analyze error code
        */
        if (pInputMsg378.getCSysIndCategoryChange() == INDICATOR_YES || pInputMsg378.getBSysIndAddressChange() == INDICATOR_YES || pInputMsg378.getCSysIndFosterTypeChange() == INDICATOR_YES || pInputMsg378.getCSysIndRsrcPrsChg() == INDICATOR_YES) {
            
            pCRES04DInputRec = new CRES04DI();
            
            pCRES04DOutputRec = new CRES04DO();
            pCRES04DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
            pCRES04DInputRec.setUlIdResource(pInputMsg378.getUlIdResource());
            rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    szLocalCdRsrcState = pCRES04DOutputRec.getSzCdRsrcState();
                    szLocalCdRsrcCnty = pCRES04DOutputRec.getSzCdRsrcCnty();
                    szLocalCdRsrcCategory = pCRES04DOutputRec.getSzCdRsrcCategory();
                    szLocalCdRsrcRegion = pCRES04DOutputRec.getSzCdRsrcRegion();
                    
                    cLocalCdRsrcFaHomeType1 = pCRES04DOutputRec.getCCdRsrcFaHomeType1();
                    
                    cLocalCdRsrcFaHomeType2 = pCRES04DOutputRec.getCCdRsrcFaHomeType2();
                    
                    cLocalCdRsrcFaHomeType3 = pCRES04DOutputRec.getCCdRsrcFaHomeType3();
                    
                    cLocalCdRsrcFaHomeType4 = pCRES04DOutputRec.getCCdRsrcFaHomeType4();
                    
                    cLocalCdRsrcFaHomeType5 = pCRES04DOutputRec.getCCdRsrcFaHomeType5();
                    
                    cLocalCdRsrcFaHomeType6 = pCRES04DOutputRec.getCCdRsrcFaHomeType6();
                    
                    cLocalCdRsrcFaHomeType7 = pCRES04DOutputRec.getCCdRsrcFaHomeType7();
                    
                    //  SIR #3428 - 3/5/96 - PURCELA - Copy out the NonPrs Indicator
                    // because it will be used to determine Resource Services
                    // later
                    
                    cLocalIndNonPrs = pCRES04DOutputRec.getBIndRsrcNonPrs();
                    break;
                    
                default :
                    return rc;
                    break;
            }
            
        }
        
        /*
        ** Analyze error code
        */
        if (pInputMsg378.getCSysIndCategoryChange() == INDICATOR_YES || pInputMsg378.getCSysIndFosterTypeChange() == INDICATOR_YES || pInputMsg378.getCSysIndRsrcCharChg() == INDICATOR_YES || pInputMsg378.getCSysIndRsrcPrsChg() == INDICATOR_YES) {
            
            //  Determine resource service(s) which currently exist (note: it is
            // o.k. if none currently exist)
            
            //  Allocate memory for DAM Input and Output Structures
            pCRES37DInputRec = new CRES37DI();
            
            pCRES37DOutputRec = new CRES37DO();
            
            pCRES37DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
            pCRES37DInputRec.setUlIdResource(pInputMsg378.getUlIdResource());
            pCRES37DInputRec.getArchInputStruct().setUsPageNbr(1);
            pCRES37DInputRec.getArchInputStruct().setUlPageSizeNbr(25);
            rc = cres37dQUERYdam(sqlca, pCRES37DInputRec, pCRES37DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    
                    for (Ccmn34s.i = 0;Ccmn34s.i < pCRES37DOutputRec.getArchOutputStruct().getUlRowQty();Ccmn34s.i++) {
                        szLocalCdRsrcSvcService[Ccmn34s.i] = pCRES37DOutputRec.getROWCRES37DO_ARRAY().getROWCRES37DO(Ccmn34s.i).getSzCdRsrcSvcService();
                        ulLocalIdResourceService[Ccmn34s.i] = pCRES37DOutputRec.getROWCRES37DO_ARRAY().getROWCRES37DO(Ccmn34s.i).getUlIdResourceService();
                        tsLocalLastUpdate[Ccmn34s.i] = pCRES37DOutputRec.getROWCRES37DO_ARRAY().getROWCRES37DO(Ccmn34s.i).getTsLastUpdate();
                    }
                    break;
                case NO_DATA_FOUND:
                    
                    //  Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    return rc;
                    break;
            }
        }
        if (pInputMsg378.getBSysIndAgeChange() == INDICATOR_YES && pInputMsg378.getCSysIndCategoryChange() == Cint14s.INDICATOR_NO && pInputMsg378.getCSysIndFosterTypeChange() == Cint14s.INDICATOR_NO && pInputMsg378.getCSysIndRsrcCharChg() != INDICATOR_YES && pInputMsg378.getCSysIndRsrcPrsChg() == Cint14s.INDICATOR_NO) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUDA8DInputRec = new CAUDA8DI();
            
            pCAUDA8DOutputRec = new CAUDA8DO();
            pCAUDA8DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
            pCAUDA8DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCAUDA8DInputRec.setUlIdResource(pInputMsg378.getUlIdResource());
            pCAUDA8DInputRec.setUNbrRsrcCharMinMAge(pInputMsg378.getUNbrRsrcMlAgeMin());
            pCAUDA8DInputRec.setUNbrRsrcCharMaxMAge(pInputMsg378.getUNbrRsrcMlAgeMax());
            pCAUDA8DInputRec.setUNbrRsrcCharMinFAge(pInputMsg378.getUNbrRsrcFMAgeMin());
            pCAUDA8DInputRec.setUNbrRsrcCharMaxFAge(pInputMsg378.getUNbrRsrcFMAgeMax());
            if (pInputMsg378.getUNbrRsrcMlAgeMin() > 0 && pInputMsg378.getUNbrRsrcFMAgeMin() == 0) {
                pCAUDA8DInputRec.setCCdRsrcCharSex(RSRC_CHAR_SEX_MALE);
            }
            
            else if (pInputMsg378.getUNbrRsrcMlAgeMin() == 0 && pInputMsg378.getUNbrRsrcFMAgeMin() > 0) //  Populate Output Message
            {
                pCAUDA8DInputRec.setCCdRsrcCharSex(RSRC_CHAR_SEX_FEMALE);
            }
            
            else if (pInputMsg378.getUNbrRsrcMlAgeMin() > 0 && pInputMsg378.getUNbrRsrcFMAgeMin() > 0) {
                pCAUDA8DInputRec.setCCdRsrcCharSex(RSRC_CHAR_SEX_BOTH);
            }
            
            
            rc = cauda8dAUDdam(sqlca, pCAUDA8DInputRec, pCAUDA8DOutputRec);
            switch (rc) {
                    
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                case NO_DATA_FOUND:
                    break;
                    
                default :
                    return rc;
                    break;
                    
            }
        }
        
        /*
        ** Analyze error code
        */
        if (pInputMsg378.getCSysIndCategoryChange() == INDICATOR_YES || pInputMsg378.getCSysIndFosterTypeChange() == INDICATOR_YES || pInputMsg378.getCSysIndRsrcPrsChg() == INDICATOR_YES) {
            
            
            //  Initialize bFound
            bFound = false;
            
            if ((0 == szLocalCdRsrcCategory.compareTo(FA_CATG_ADOPT)) || (0 == szLocalCdRsrcCategory.compareTo(FA_CATG_FOST_ADOPT)) || (0 == szLocalCdRsrcCategory.compareTo(FA_CATG_KIN_FA)) || (0 == szLocalCdRsrcCategory.compareTo(FA_CATG_LEG_RISK)) || (0 == szLocalCdRsrcCategory.compareTo(FA_CATG_ICPC))) {
                //  An Adoption Assistance Service Code (96D) should exist
                // - try to find it.
                
                for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                    
                    if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_ADP_SUB)) {
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                        bFound = true;
                    }
                    if (null == szLocalCdRsrcSvcService[Ccmn34s.i][0]) {
                        szLocalCdRsrcSvcService[Ccmn34s.i] = CD_SERV_ADP_SUB;
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_ADD);
                        bFound = true;
                        bServiceChangeRequired = true;
                    }
                }
                
                
                
                //  SIR 3775 - Added code to search for Non-Recurring Subsidy
                // and add it if not found.
                
                //  Initialize bFound
                bFound = false;
                
                //  An Adoption Assistance - Non Recurring Service Code (96J)
                // should exist - - try to find it.
                
                for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                    if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_ADP_NON_REC_SUB)) {
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                        bFound = true;
                    }
                    
                    if (null == szLocalCdRsrcSvcService[Ccmn34s.i][0]) {
                        szLocalCdRsrcSvcService[Ccmn34s.i] = CD_SERV_ADP_NON_REC_SUB;
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_ADD);
                        bFound = true;
                        bServiceChangeRequired = true;
                    }
                }
                
                
                // end SIR 3775
                
                
                //  Initialize bFound
                bFound = false;
                
                if (0 != szLocalCdRsrcCategory.compareTo(FA_CATG_LEG_RISK) && 0 != szLocalCdRsrcCategory.compareTo(FA_CATG_ICPC)) {
                    
                    for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                        if (Cint14s.INDICATOR_NO == cLocalIndNonPrs) {
                            
                            if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_ADP_HME)) {
                                cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                                bFound = true;
                            }
                            
                            if (null == szLocalCdRsrcSvcService[Ccmn34s.i][0]) {
                                szLocalCdRsrcSvcService[Ccmn34s.i] = CD_SERV_ADP_HME;
                                cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_ADD);
                                bFound = true;
                                bServiceChangeRequired = true;
                            }
                        }
                        
                        else {
                            
                            if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_ADP_NPRS_HME)) {
                                cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                                bFound = true;
                            }
                            
                            if (null == szLocalCdRsrcSvcService[Ccmn34s.i][0]) {
                                szLocalCdRsrcSvcService[Ccmn34s.i] = CD_SERV_ADP_NPRS_HME;
                                cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_ADD);
                                bFound = true;
                                bServiceChangeRequired = true;
                            }
                        }
                    }
                }
            }
            
            
            
            
            //  Initialize bFound
            bFound = false;
            if (0 != szLocalCdRsrcCategory.compareTo(FA_CATG_ADOPT)) {
                // SIR #15787. Commented out because CD_SERV_FOST_L1 does not exist
                // any more. It's changed to CD_SERV_FOST_LEV_A & CD_SERV_FOST_LEV_B
                // A Foster Level1 Service Code should exist - - try to find it.
                
                // SIR 19613 Changed CD_SERV_FOST_LEV_A to CD_SERV_FOST_LEV_BASIC, removed
                // CD_SERV_FOST_LEV_B since A, B, and C are now combined into basic.
                
                for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                    if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_FOST_L1)) {
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                        bFound = true;
                    }
                }
                
                
                // if (NULL_CHARACTER == szLocalCdRsrcSvcService[i][0])
                // {
                // COPYSZ(szLocalCdRsrcSvcService[i], CD_SERV_FOST_L1);
                // cLocalScrDataAction[i]     = REQ_FUNC_CD_ADD;
                // bFound                     = TRUE;
                // bServiceChangeRequired     = TRUE;
                // }
                
                
                bFound = false;
                
                for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                    
                    if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_FOST_LEV_BASIC)) {
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                        bFound = true;
                    }
                    if (null == szLocalCdRsrcSvcService[Ccmn34s.i][0]) {
                        szLocalCdRsrcSvcService[Ccmn34s.i] = CD_SERV_FOST_LEV_BASIC;
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_ADD);
                        bFound = true;
                        bServiceChangeRequired = true;
                    }
                }
                
                
                bFound = false;
            }
            
            if (cLocalCdRsrcFaHomeType1 == FOST_TYPE_GROUP || cLocalCdRsrcFaHomeType2 == FOST_TYPE_GROUP || cLocalCdRsrcFaHomeType3 == FOST_TYPE_GROUP || cLocalCdRsrcFaHomeType4 == FOST_TYPE_GROUP || cLocalCdRsrcFaHomeType5 == FOST_TYPE_GROUP || cLocalCdRsrcFaHomeType6 == FOST_TYPE_GROUP || cLocalCdRsrcFaHomeType7 == FOST_TYPE_GROUP) {
                bGroupHome = true;
            }
            
            // Initialize bFound
            bFound = false;
            
            if (cLocalCdRsrcFaHomeType1 == FOST_TYPE_HABIL || cLocalCdRsrcFaHomeType1 == FOST_TYPE_THER || cLocalCdRsrcFaHomeType1 == FOST_TYPE_PRIM_MED || cLocalCdRsrcFaHomeType2 == FOST_TYPE_HABIL || cLocalCdRsrcFaHomeType2 == FOST_TYPE_THER || cLocalCdRsrcFaHomeType2 == FOST_TYPE_PRIM_MED || cLocalCdRsrcFaHomeType3 == FOST_TYPE_HABIL || cLocalCdRsrcFaHomeType3 == FOST_TYPE_THER || cLocalCdRsrcFaHomeType3 == FOST_TYPE_PRIM_MED || cLocalCdRsrcFaHomeType4 == FOST_TYPE_HABIL || cLocalCdRsrcFaHomeType4 == FOST_TYPE_THER || cLocalCdRsrcFaHomeType4 == FOST_TYPE_PRIM_MED || cLocalCdRsrcFaHomeType5 == FOST_TYPE_HABIL || cLocalCdRsrcFaHomeType5 == FOST_TYPE_THER || cLocalCdRsrcFaHomeType5 == FOST_TYPE_PRIM_MED || cLocalCdRsrcFaHomeType6 == FOST_TYPE_HABIL || cLocalCdRsrcFaHomeType6 == FOST_TYPE_THER || cLocalCdRsrcFaHomeType6 == FOST_TYPE_PRIM_MED || cLocalCdRsrcFaHomeType7 == FOST_TYPE_HABIL || cLocalCdRsrcFaHomeType7 == FOST_TYPE_THER || cLocalCdRsrcFaHomeType7 == FOST_TYPE_PRIM_MED) {
                //  A Foster Level2 Service Code should exist - - try to find it.
                
                
                // SIR 19613 Changed CD_SERV_FOST_LEV_C to CD_SERV_FOST_LEV_MOD, removed
                // CD_SERV_FOST_LEV_D, CD_SERV_FOST_LEV_E since D and E are now combined into moderate.
                // SIR 22390 Added CD_SERV_FOST_LEV_SPEC to be saved if the type is
                // Ther, Prim Med, or Habil
                // SIR 22485 Added CD_SERV_FOST_LEV_INT to be saved if the type is
                // Ther, Prim Med, or Habil
                for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                    
                    if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_FOST_L2)) {
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                        bFound = true;
                    }
                }
                
                //  If NULL, the service codes being searched for did not
                // exist, so indicate that it needs to be added
                // if (NULL_CHARACTER == szLocalCdRsrcSvcService[i][0])
                // {
                // COPYSZ(szLocalCdRsrcSvcService[i], CD_SERV_FOST_L2);
                // cLocalScrDataAction[i]     = REQ_FUNC_CD_ADD;
                // bFound                     = TRUE;
                // bServiceChangeRequired     = TRUE;
                // }
                
                
                bFound = false;
                
                for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                    
                    if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_FOST_LEV_MOD)) {
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                        bFound = true;
                    }
                    if (null == szLocalCdRsrcSvcService[Ccmn34s.i][0]) {
                        szLocalCdRsrcSvcService[Ccmn34s.i] = CD_SERV_FOST_LEV_MOD;
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_ADD);
                        bFound = true;
                        bServiceChangeRequired = true;
                    }
                }
                
                
                bFound = false;
                
                
                
                // SIR 22390
                for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                    
                    if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_FOST_LEV_SPEC)) {
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                        bFound = true;
                    }
                    //## END TUX/XML: Turn the XML buffer into an input message struct
                    
                    
                    
                    if (null == szLocalCdRsrcSvcService[Ccmn34s.i][0]) {
                        szLocalCdRsrcSvcService[Ccmn34s.i] = CD_SERV_FOST_LEV_SPEC;
                        cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_ADD);
                        bFound = true;
                        bServiceChangeRequired = true;
                    }
                }
                
                
                bFound = false;
                if (!bGroupHome) {
                    // SIR 22485
                    for (Ccmn34s.i = 0;Ccmn34s.i < 25 && bFound == false;Ccmn34s.i++) {
                        if (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_FOST_LEV_INT)) {
                            cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
                            bFound = true;
                        }
                        // 
                        // End SIR 1710
                        // (END): Common Function: ccmn06u   Check Stage/Event common function
                        // 
                        
                        // 
                        // Call DAMs to retrieve data
                        // 
                        
                        if (null == szLocalCdRsrcSvcService[Ccmn34s.i][0]) {
                            szLocalCdRsrcSvcService[Ccmn34s.i] = CD_SERV_FOST_LEV_INT;
                            cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_ADD);
                            bFound = true;
                            bServiceChangeRequired = true;
                        }
                    }
                }
            }
            
            
            
            
            //  Determine if any previously existing types need to be deleted
            // The procesing above results in the following 4 conitions:
            // 1) CdService != Null & DataAction == Add (CdService to Add)
            // 2) CdService != Null & DataAction == Keep (CdService to keep)
            // 3) Cdservice != Null & DataAction == Null (CdService not needed)
            // 4) CdService == Null & DataAction == Null (blank row, no processing)
            // If condition 3 exists, we need to set the data action to delete.
            
            
            //  SIR 15891 - need to loop through all, regardless of bFound
            // for (i=0; i<25 && bFound == FALSE; i++)
            for (Ccmn34s.i = 0;Ccmn34s.i < 25;Ccmn34s.i++) {
                
                
                
                if (null != szLocalCdRsrcSvcService[Ccmn34s.i][0] && null == cLocalScrDataAction.charAt(Ccmn34s.i)) {
                    cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, WtcHelperConstants.REQ_FUNC_CD_DELETE);
                    bServiceChangeRequired = true;
                }
            }
        }
        
        
        
        else {
            for (Ccmn34s.i = 0;Ccmn34s.i < 25 && null != szLocalCdRsrcSvcService[Ccmn34s.i][0];Ccmn34s.i++) {
                cLocalScrDataAction = CStringUtils.setCharAt(cLocalScrDataAction, Ccmn34s.i, REQ_FUNC_CD_KEEP);
            }
            
        }
        
        if (bServiceChangeRequired == true || pInputMsg378.getCSysIndRsrcCharChg() == INDICATOR_YES) {
            
            //  IMPACT BEGIN - Don't demote events when in "Approver mode"
            if (bServiceChangeRequired == true && pInputMsg378.getCSysIndRsrcCharChg() != INDICATOR_YES) {
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSS48DInputRec = new CLSS48DI();
                
                pCLSS48DOutputRec = new CLSS48DO();
                pCLSS48DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
                pCLSS48DInputRec.setUlIdResource(pInputMsg378.getUlIdResource());
                pCLSS48DInputRec.getArchInputStruct().setUsPageNbr(1);
                pCLSS48DInputRec.getArchInputStruct().setUlPageSizeNbr(CFAD01UI._CFAD01UI__CFAD01UIG00_SIZE);
                rc = clss48dQUERYdam(sqlca, pCLSS48DInputRec, pCLSS48DOutputRec);
                switch (rc) 
                {
                    case WtcHelperConstants.SQL_SUCCESS:
                    case NO_DATA_FOUND:
                        
                        
                        for (Ccmn34s.i = 0;Ccmn34s.i < pCLSS48DOutputRec.getArchOutputStruct().getUlRowQty();Ccmn34s.i++) {
                            pInputMsg378.getCFAD01UIG00_ARRAY().getCFAD01UIG00(Ccmn34s.i).setSzCdRsrcCharChrctr(pCLSS48DOutputRec.getROWCLSS48DO_ARRAY().getROWCLSS48DO(Ccmn34s.i).getSzCdRsrcCharChrctr());
                            pInputMsg378.getCFAD01UIG00_ARRAY().getCFAD01UIG00(Ccmn34s.i).setDtDtRsrcCharDateAdded(pCLSS48DOutputRec.getROWCLSS48DO_ARRAY().getROWCLSS48DO(Ccmn34s.i).getDtDtRsrcCharDateAdded());
                        }
                        break;
                        
                    default :
                        return rc;
                        break;
                }
            }
            
            
            
            
            //  Delete All Characteristics for this resource
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUDA6DInputRec = new CAUDA6DI();
            
            pCAUDA6DOutputRec = new CAUDA6DO();
            pCAUDA6DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
            pCAUDA6DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            pCAUDA6DInputRec.setUlIdResource(pInputMsg378.getUlIdResource());
            rc = cauda6dAUDdam(sqlca, pCAUDA6DInputRec, pCAUDA6DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:
                    break;
                    
                    
                default :
                    return rc;
                    break;
            }
        }
        /*
        ** IMPACT END
        */
        
        /*
        ** If Event ID for Conclusion window is passed in, the event status is
        ** pending, so demote event status for Conclusion and all other related
        ** windows in Investigation
        */
        if (bServiceChangeRequired) {
            
            for (Ccmn34s.i = 0;Ccmn34s.i < 25 && null != szLocalCdRsrcSvcService[Ccmn34s.i][0];Ccmn34s.i++) {
                if (WtcHelperConstants.REQ_FUNC_CD_ADD == cLocalScrDataAction.charAt(Ccmn34s.i)) {
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCRES35DInputRec = new CRES35DI();
                    
                    pCRES35DOutputRec = new CRES35DO();
                    pCRES35DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
                    pCRES35DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCRES35DInputRec.setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCRES35DInputRec.setCIndRsrcSvcShowRow(FND_YES);
                    
                    // In the following line two there are assumtions if a non SQL
                    // error is returned from the DAM.
                    // 1 - Memory allocated in this shared library is owned by the
                    // calling server.
                    // 2 - The calling server will shut down when it recieves a
                    // serverity of FATAL.
                    // These assumtions are made for every PROCESS_TUX_SQL_ERROR_NOFREE
                    // used in this library.
                    pCRES35DInputRec.setSzScrRsrcSvcCntyCode(szLocalCdRsrcCnty);
                    pCRES35DInputRec.setSzCdRsrcSvcProgram(RSRC_PROGRAM);
                    pCRES35DInputRec.setSzCdRsrcSvcRegion(szLocalCdRsrcRegion);
                    if ((0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_ADP_SUB)) || (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_ADP_HME)) || (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_ADP_NON_REC_SUB)) || (0 == szLocalCdRsrcSvcService[Ccmn34s.i].compareTo(CD_SERV_ADP_NPRS_HME))) {
                        pCRES35DInputRec.setSzCdRsrcSvcCategRsrc(CD_SERV_CAT_ADP_SVC);
                    }
                    else {
                        pCRES35DInputRec.setSzCdRsrcSvcCategRsrc(CD_SERV_CAT_FOST_CARE);
                    }
                    pCRES35DInputRec.setSzCdRsrcSvcService(szLocalCdRsrcSvcService[Ccmn34s.i]);
                    pCRES35DInputRec.setSzCdRsrcSvcState(szLocalCdRsrcState);
                    pCRES35DInputRec.setUlIdResource(pInputMsg378.getUlIdResource());
                    pCRES35DInputRec.setBIndRsrcSvcCntyPartial(FND_NO);
                    pCRES35DInputRec.setCIndRsrcSvcIncomeBsed(FND_NO);
                    
                    
                    //  Call DAM
                    rc = cres35dAUDdam(sqlca, pCRES35DInputRec, pCRES35DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            ulLocalIdResourceService[Ccmn34s.i] = pCRES35DOutputRec.getUlIdResourceService();
                            break;
                            
                            
                        default :
                            return rc;
                            break;
                    }
                }
                
                
                else if (WtcHelperConstants.REQ_FUNC_CD_DELETE == cLocalScrDataAction.charAt(Ccmn34s.i)) {
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCRES22DInputRec = new CRES22DI();
                    
                    pCRES22DOutputRec = new CRES22DO();
                    pCRES22DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
                    pCRES22DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                    pCRES22DInputRec.setTsLastUpdate(tsLocalLastUpdate[Ccmn34s.i]);
                    pCRES22DInputRec.setUlIdResource(pInputMsg378.getUlIdResource());
                    pCRES22DInputRec.setUlIdResourceService(ulLocalIdResourceService[Ccmn34s.i]);
                    
                    rc = cres22dAUDdam(sqlca, pCRES22DInputRec, pCRES22DOutputRec);
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                            
                            
                        default :
                            return rc;
                            break;
                    }
                }
            }
        }
        
        /* todo's date update*/
        if (pInputMsg378.getCSysIndRsrcCharChg() == INDICATOR_YES || bServiceChangeRequired == true) {
            
            //  Loop through each Resource Service
            for (Ccmn34s.i = 0;Ccmn34s.i < 25 && null != szLocalCdRsrcSvcService[Ccmn34s.i][0];Ccmn34s.i++) {
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                // 01/22/2003 DWW: Added for error handling
                if (REQ_FUNC_CD_KEEP == cLocalScrDataAction.charAt(Ccmn34s.i) || WtcHelperConstants.REQ_FUNC_CD_ADD == cLocalScrDataAction.charAt(Ccmn34s.i)) {
                    
                    //  Get Ready to Insert Characteristics
                    
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCRES21DInputRec = new CRES21DI();
                    
                    pCRES21DOutputRec = new CRES21DO();
                    
                    //  Loop through each characteristic and insert it for the
                    // resource service being processed
                    for (j = null;j < CFAD01UI._CFAD01UI__CFAD01UIG00_SIZE && null != pInputMsg378.getCFAD01UIG00_ARRAY().getCFAD01UIG00((int) j).getSzCdRsrcCharChrctr()[0];j++) {
                        pCRES21DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
                        pCRES21DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCRES21DInputRec.setUlIdResourceService(ulLocalIdResourceService[Ccmn34s.i]);
                        
                        pCRES21DInputRec.setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCRES21DInputRec.setSzCdRsrcCharChrctr(pInputMsg378.getCFAD01UIG00_ARRAY().getCFAD01UIG00((int) j).getSzCdRsrcCharChrctr());
                        pCRES21DInputRec.setDtDtRsrcCharDateAdded(pInputMsg378.getCFAD01UIG00_ARRAY().getCFAD01UIG00((int) j).getDtDtRsrcCharDateAdded());
                        
                        if (pInputMsg378.getUNbrRsrcMlAgeMin() > 0 && pInputMsg378.getUNbrRsrcFMAgeMin() == 0) {
                            pCRES21DInputRec.setCCdRsrcCharSex(RSRC_CHAR_SEX_MALE);
                        }
                        
                        else if (pInputMsg378.getUNbrRsrcMlAgeMin() == 0 && pInputMsg378.getUNbrRsrcFMAgeMin() > 0) {
                            pCRES21DInputRec.setCCdRsrcCharSex(RSRC_CHAR_SEX_FEMALE);
                        }
                        
                        else if (pInputMsg378.getUNbrRsrcMlAgeMin() > 0 && pInputMsg378.getUNbrRsrcFMAgeMin() > 0) {
                            pCRES21DInputRec.setCCdRsrcCharSex(RSRC_CHAR_SEX_BOTH);
                        }
                        pCRES21DInputRec.setUNbrRsrcCharMaxFAge(pInputMsg378.getUNbrRsrcFMAgeMax());
                        
                        pCRES21DInputRec.setUNbrRsrcCharMaxMAge(pInputMsg378.getUNbrRsrcMlAgeMax());
                        pCRES21DInputRec.setUNbrRsrcCharMinFAge(pInputMsg378.getUNbrRsrcFMAgeMin());
                        pCRES21DInputRec.setUNbrRsrcCharMinMAge(pInputMsg378.getUNbrRsrcMlAgeMin());
                        rc = cres21dAUDdam(sqlca, pCRES21DInputRec, pCRES21DOutputRec);
                        
                        
                        //  Analyze return code
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                
                                break;
                                
                            default :
                                return rc;
                                
                                break;
                        }
                    }
                }
            }
        }
        
        if (pInputMsg378.getBSysIndAddressChange() == INDICATOR_YES) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUDA9DInputRec = new CAUDA9DI();
            
            pCAUDA9DOutputRec = new CAUDA9DO();
            pCAUDA9DInputRec.setArchInputStruct(pInputMsg378.getArchInputStruct());
            pCAUDA9DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCAUDA9DInputRec.setUlIdResource(pInputMsg378.getUlIdResource());
            pCAUDA9DInputRec.setSzCdRsrcSvcCnty(szLocalCdRsrcCnty);
            pCAUDA9DInputRec.setSzCdRsrcSvcRegion(szLocalCdRsrcRegion);
            
            pCAUDA9DInputRec.setSzCdRsrcSvcState(szLocalCdRsrcState);
            rc = cauda9dAUDdam(sqlca, pCAUDA9DInputRec, pCAUDA9DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:// clss11d
                    break;
                    
                default :
                    return rc;
            }
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

}
