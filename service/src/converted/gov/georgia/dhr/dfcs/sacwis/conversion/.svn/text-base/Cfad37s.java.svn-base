package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC18DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFAD37S.src
**
** Service Name:  Home License Retrieve
**
** Description:   This service will retrieve Home License Information.
**                It will either retrieve information from CAPS_RESOURCE
**                (the current event) or from RESOURCE_HISTORY (historical
**                record).  It will also check for a BLOB.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 21, 1995
**
** Programmer:    Sandra Wang
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   18 Mar 1999 15:11:42  $
**                      $Modtime:   17 Mar 1999 13:20:16  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  2/12/96   WANGSS    Customized Detail Deleted message.
**  3/29/96   PURCELA   SIR #4357 - The DAM cmsc39d was not functioning
**                      correctly. A new DAM, clss64d, was created to take
**                      some of the logic which could not be properly executed
**                      by cmsc39d.  Additional code has been inserted into
**                      the code to handle values which must be passed
**                      between the two and also to handle the counting of
**                      Non Adoption Consumated placements in the home.
**  4/2/96    PURCELA   SIR #20075 - Because of the change made to cmsc39d
**                      an SQL_NOT_FOUND case became necessary.  It was added
**
**
**  4/12/96   CRYSTAEP  SIR #20358 - Populate output message with NbrRsrcVid
**                      to determine whether user can save and submit on Home
**                      License window.  If NbrRsrcVid is NULL, user cannot
**                      Save and Submit.
**  5/6/96    DENTONRA  SIR #20840 - Changed code to pass VID of a business
**                      address instead of primary.  Required adding of
**                      a dam call (cres13d). (See more detail in comments
**                      below.)
**  3/23/98   DOUGLACS  SIR #14225 Add dam CLSC18D to check for caretakers
**                      assigned to the home.
**  3/15/99   DOUGLACS  SIR #14113 open slots sirs - fix display of open slots
**                      and number of placements for non-PRS homes.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                      input and output objects before they are allocated
**  08/08/03  Srini     SIR 19398- Made the service transaction aware.
**  05/25/04  gerryc    SIR 16052 - added output variables to store if there
**                      is a foster parent, adoptive parent, male, and/or
**                      female principals for custom validation edits.
**  04/14/05  gerryc    SIR 23535 - added variables for the new role of
**                      adopt/foster parent
**  03/18/05  Hadjimh   SIR#23327. Add a new field to the Home Information page. This new
**                      field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
**                      Adoptive Home checkbox is checked, staff will have to select a
**                      'Certifying Entity'. to indicate the certifying agency
**                      2) This will be a required field when the Non-FPS Adoptive Home
**                      checkbox is checked for a new home. 3) If a user is modifying an
**                      existing Non-FPS Adoptive Home, this new field will be required,
**                      unless the home status is also being changed to 'Pending Closure'
**                      or 'Closed'.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad37s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PERSON_TYPE_PRN = "PRN";
    public static final String PERSON_ROLE_APARENT = "AP";
    public static final String PERSON_ROLE_FPARENT = "FP";
    public static final String PERSON_ROLE_AFPARENT = "AF";
    public static final char FEMALE = 'F';
    public static final char MALE = 'M';
    static int transactionflag = - 1;
    CFAD37SO CFAD37S(CFAD37SI cfad37si) {
        CFAD37SO cfad37so = new CFAD37SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        /*
        ** Retrieve Home Phone number
        */
        rc = ARC_UTLCheckServiceBatchBlock("CFAD37S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CFAD37S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            //  Retrieve Work Phone number
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        /*************************************************
        ** (END): Determine if Adoption Consumated
        *************************************************/
        
        
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CFAD37S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CFAD37S\n");
            bTransactionStarted = true;
        }
        int i218 = 0;
        int x = 0;/* Loop counter */
        int iPlcmtCtr = 0;/* Loop Ctr - SIR #4357 */
        int ulIdEvent10 = 0;
        int bPrincipalsAP = 0;/* SIR 16052 */
        boolean bPrincipalsAPMale = false;/* SIR 16052 */
        boolean bPrincipalsAPFemale = false;/* SIR 16052 */
        int bPrincipalsFP = 0;/* SIR 16052 */
        boolean bPrincipalsFPMale = false;/* SIR 16052 */
        boolean bPrincipalsFPFemale = false;/* SIR 16052 */
        boolean bPrincipalsMale = false;/* SIR 16052 */
        boolean bPrincipalsFemale = false;/* SIR 16052 */
        int bPrincipalsAF = 0;/* SIR 16052 */
        int RetVal = SUCCESS;/* Return Value to continue */
        CSES02DI pCSES02DInputRec = null;/* Home Demographics Retrieve */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        
        
        //##  long            rc = 0;
        
        
        
        
        
        CSES02DO pCSES02DOutputRec = null;
        CSES41DI pCSES41DInputRec = null;/* Resource By Stage Retrieve */
        
        CSES41DO pCSES41DOutputRec = null;
        CRES13DI pCRES13DInputRec = null;/* SIR 20840 - Resource address */
        
        CRES13DO pCRES13DOutputRec = null;
        CMSC39DI pCMSC39DInputRec = null;/* Children in the Home Retrieve */
        
        CMSC39DO pCMSC39DOutputRec = null;
        CCMN45DI pCCMN45DInputRec = null;/* Get Event SMP */
        
        CCMN45DO pCCMN45DOutputRec = null;
        CSYS06DI pCSYS06DInputRec = null;/* BLOB Retrieve */
        
        CSYS06DO pCSYS06DOutputRec = null;
        CLSS64DI pCLSS64DInputRec = null;/* SIR #4357 Is Adpt Consumated */
        
        CLSS64DO pCLSS64DOutputRec = null;
        CLSC18DI pCLSC18DInputRec = null;/* SIR #14225 Edit Principals assoc. with FAD home*/
        
        CLSC18DO pCLSC18DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfad37si.getArchInputStruct());
        if (LIC_MODIFY == cfad37si.getArchInputStruct().getCReqFuncCd()) {
            //  Allocate memory for DAM Input and Output Structures
            pCSES41DInputRec = new CSES41DI();
            
            pCSES41DOutputRec = new CSES41DO();
            pCSES41DInputRec.setArchInputStruct(cfad37si.getArchInputStruct());
            pCSES41DInputRec.setUlIdRsrcFaHomeStage(cfad37si.getUlIdStage());
            rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
            
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    cfad37so.setSzCdRsrcMaritalStatus(pCSES41DOutputRec.getSzCdRsrcMaritalStatus());
                    cfad37so.setSzCdRsrcCategory(pCSES41DOutputRec.getSzCdRsrcCategory());
                    cfad37so.setSzCdRsrcFaHomeStatus(pCSES41DOutputRec.getSzCdRsrcFaHomeStatus());
                    cfad37so.setSzCdRsrcStatus(pCSES41DOutputRec.getSzCdRsrcStatus());
                    cfad37so.setTsLastUpdate(pCSES41DOutputRec.getTsLastUpdate());
                    cfad37so.setDtDtRsrcMarriage(pCSES41DOutputRec.getDtDtRsrcMarriage());
                    cfad37so.setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                    cfad37so.setBIndRsrcNonPrs(pCSES41DOutputRec.getBIndRsrcNonPrs());
                    cfad37so.setSzCdCertifyEntity(pCSES41DOutputRec.getSzCdCertifyEntity());
                    
                    cfad37so.setUNbrRsrcMlAgeMin(pCSES41DOutputRec.getUNbrRsrcMlAgeMin());
                    cfad37so.setUNbrRsrcFMAgeMax(pCSES41DOutputRec.getUNbrRsrcFMAgeMax());
                    cfad37so.setUNbrRsrcFMAgeMin(pCSES41DOutputRec.getUNbrRsrcFMAgeMin());
                    
                    // 
                    // Function Prototypes
                    // 
                    
                    cfad37so.setUNbrRsrcMlAgeMax(pCSES41DOutputRec.getUNbrRsrcMlAgeMax());
                    cfad37so.setUNbrRsrcFacilCapacity(pCSES41DOutputRec.getUNbrRsrcFacilCapacity());
                    cfad37so.setUNbrRsrcIntMaAgeMin(pCSES41DOutputRec.getUNbrRsrcIntMaAgeMin());
                    cfad37so.setUNbrRsrcIntMaAgeMax(pCSES41DOutputRec.getUNbrRsrcIntMaAgeMax());
                    
                    cfad37so.setUNbrRsrcIntFeAgeMin(pCSES41DOutputRec.getUNbrRsrcIntFeAgeMin());
                    cfad37so.setUNbrRsrcIntFeAgeMax(pCSES41DOutputRec.getUNbrRsrcIntFeAgeMax());
                    cfad37so.setSzCdRsrcCnty(pCSES41DOutputRec.getSzCdRsrcCnty());
                    
                    cfad37so.getCCdRsrcFaHomeType1()[0] = pCSES41DOutputRec.getCCdRsrcFaHomeType1();
                    cfad37so.getCCdRsrcFaHomeType1()[1] = pCSES41DOutputRec.getCCdRsrcFaHomeType2();
                    cfad37so.getCCdRsrcFaHomeType1()[2] = pCSES41DOutputRec.getCCdRsrcFaHomeType3();
                    //  SIR 11939: added the next two DAMS, which retrieve either
                    // Total Assignments or Total Primary Assignments for each worker
                    // in the unit, depending on the Search Option chosen on the window.
                    
                    cfad37so.getCCdRsrcFaHomeType1()[3] = pCSES41DOutputRec.getCCdRsrcFaHomeType4();
                    cfad37so.getCCdRsrcFaHomeType1()[4] = pCSES41DOutputRec.getCCdRsrcFaHomeType5();
                    cfad37so.getCCdRsrcFaHomeType1()[5] = pCSES41DOutputRec.getCCdRsrcFaHomeType6();
                    
                    cfad37so.getCCdRsrcFaHomeType1()[6] = pCSES41DOutputRec.getCCdRsrcFaHomeType7();
                    
                    //  SIR 20840 - Removed placing of this VID into the output
                    // structure. This output VID is used for contract creation
                    // and modification.  Design changes have required the code
                    // to validate the existence of a BUSINESS VID and not the
                    // PRIMARY VID.  The deleted code below retreived the
                    // VID from the CAPS_RESOURCE table with only has the PRIMARY
                    // VID.  Below, added a call to cres13d which will pull
                    // all possible addresses from the RESOURCE_ADDRESS table.
                    // There, validation will be performed to determine the existence
                    // of a business VID.
                    // 
                    // REMOVED CODE FOR ABOVE SIR
                    // /*
                    // SIR #20358 - Populate output message with NbrRsrcVid
                    // to determine whether user can save and submit on Home
                    // License window.  If NbrRsrcVid is NULL, user cannot
                    // Save and Submit
                    // COPYSZ(pOutputMsg->szNbrRsrcVid, pCSES41DOutputRec->szNbrRsrcVid);
                    // 
                    //  Get Event associated with current
                    // CAPS_RESOURCE record
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN45DInputRec = new CCMN45DI();
                    
                    pCCMN45DOutputRec = new CCMN45DO();
                    pCCMN45DInputRec.setArchInputStruct(cfad37si.getArchInputStruct());
                    pCCMN45DInputRec.setUlIdEvent(pCSES41DOutputRec.getUlIdRsrcFaHomeEvent());
                    
                    //  Call DAM: Retrieves from the educational_history Table.
                    rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            //  SIR 23689 - Added these four DAMS to retrieve the total assignments
                            // over 30 days (INV) and 60 days (SVC) old, and to retrieve the same
                            // number for primary assignments
                            
                            
                            cfad37so.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                            cfad37so.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                            cfad37so.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                            
                            cfad37so.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                            cfad37so.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                            cfad37so.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                            
                            cfad37so.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                            cfad37so.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                            cfad37so.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                            
                            //  Determine Number of Placemnts
                            
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCMSC39DInputRec = new CMSC39DI();
                            
                            pCMSC39DOutputRec = new CMSC39DO();
                            
                            pCMSC39DInputRec.setArchInputStruct(cfad37si.getArchInputStruct());
                            pCMSC39DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                            pCMSC39DInputRec.getArchInputStruct().setUlPageSizeNbr(50);
                            // No rows found is acceptable.  Not an error
                            rc = ARC_UTLGetDateAndTime(pCMSC39DInputRec.getDtSysDtGenericSysdate() , 0);
                            
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            pCMSC39DInputRec.setUlIdRsrcFacil(pCSES41DOutputRec.getUlIdResource());
                            rc = cmsc39dQUERYdam(sqlca, pCMSC39DInputRec, pCMSC39DOutputRec);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    cfad37so.setUlSysNbrGenericCntr(0);
                                    
                                    for (iPlcmtCtr = 0;iPlcmtCtr < pCMSC39DOutputRec.getArchOutputStruct().getUlRowQty();iPlcmtCtr++) {
                                        
                                        
                                        //  BEGIN - SEND TO DO TO PRIMARY WORKER FOR
                                        // INQUIRY - CSUB40U
                                        //  SIR #3310 - Added if statement to only create alert's for
                                        // PRS Homes's.
                                        if (0 == pCMSC39DOutputRec.getROWCMSC39DO_ARRAY().getROWCMSC39DO(iPlcmtCtr).getSzCdPlcmtLivArr().compareTo(ADOPTIVE_PLCMT_TYPE)) {
                                            
                                            // 
                                            // (BEGIN): Is Placement Adoption Consumated
                                            // 
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCLSS64DInputRec = new CLSS64DI();
                                            
                                            pCLSS64DOutputRec = new CLSS64DO();
                                            pCLSS64DInputRec.setArchInputStruct(cfad37si.getArchInputStruct());
                                            pCLSS64DInputRec.setSzCdLegalStatStatus(LGL_STAT_ADO_CNSM);
                                            pCLSS64DInputRec.setUlIdPerson(pCMSC39DOutputRec.getROWCMSC39DO_ARRAY().getROWCMSC39DO(iPlcmtCtr).getUlIdPlcmtChild());
                                            pCLSS64DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                            pCLSS64DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
                                            rc = clss64dQUERYdam(sqlca, pCLSS64DInputRec, pCLSS64DOutputRec);
                                            
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    cfad37so.getUlSysNbrGenericCntr()++;
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                    break;
                                            }
                                        }
                                        else {
                                            cfad37so.getUlSysNbrGenericCntr()++;
                                        }
                                    }
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    cfad37so.setUlSysNbrGenericCntr(0);
                                    break;
                                default :// CMSC39D
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                            break;
                        default :// CCMN45D
                            
                            
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                    
                    
                    // 
                    // (BEGIN): SIR 20840 Retreive resource address row(s) cres13d
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCRES13DInputRec = new CRES13DI();
                    
                    pCRES13DOutputRec = new CRES13DO();
                    pCRES13DInputRec.setArchInputStruct(cfad37si.getArchInputStruct());
                    pCRES13DInputRec.setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                    pCRES13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                    pCRES13DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES13DO._CRES13DO__ROWCRES13DO_SIZE);
                    rc = cres13dQUERYdam(sqlca, pCRES13DInputRec, pCRES13DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  SIR 20840 - Check VID.  If business address, then
                            // populate output message with NbrRsrcVid
                            // to determine whether user can save and submit on Home
                            // License window.  If NbrRsrcVid is NULL, user cannot
                            // Save and Submit
                            
                            for (x = 0;x < pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();x++) {
                                if (0 == RSRC_BUIS_ADDR.compareTo(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(x).getSzCdRsrcAddrType()) && ((pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(x).getSzNbrRsrcAddrVid() != null) || (pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(x).getSzNbrRsrcAddrVid() != null))) {
                                    cfad37so.setSzNbrRsrcVid(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(x).getSzNbrRsrcAddrVid());
                                    
                                    x = pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();
                                }
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                    break;
                default :// CSES41D
                    
                    
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        if (LIC_HISTORY == cfad37si.getArchInputStruct().getCReqFuncCd()) {
            //  Allocate memory for DAM Input and Output Structures
            pCSES02DInputRec = new CSES02DI();
            
            pCSES02DOutputRec = new CSES02DO();
            pCSES02DInputRec.setArchInputStruct(cfad37si.getArchInputStruct());
            pCSES02DInputRec.setUlIdEvent(cfad37si.getUlIdEvent());
            
            //  Call DAM
            rc = cses02dQUERYdam(sqlca, pCSES02DInputRec, pCSES02DOutputRec);
            
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    cfad37so.setSzCdRsrcMaritalStatus(pCSES02DOutputRec.getSzCdRshsMaritalStatus());
                    cfad37so.setSzCdRsrcCategory(pCSES02DOutputRec.getSzCdRshsCategory());
                    cfad37so.setSzCdRsrcFaHomeStatus(pCSES02DOutputRec.getSzCdRshsFaHomeStatus());
                    cfad37so.setSzCdRsrcStatus(pCSES02DOutputRec.getSzCdRshsStatus());
                    cfad37so.setTsLastUpdate(pCSES02DOutputRec.getTsLastUpdate());
                    
                    cfad37so.setDtDtRsrcMarriage(pCSES02DOutputRec.getDtDtRshsMarriage());
                    cfad37so.setUlIdResource(pCSES02DOutputRec.getUlIdResource());
                    cfad37so.setBIndRsrcNonPrs(pCSES02DOutputRec.getCIndRshsNonPrs());
                    cfad37so.setSzCdCertifyEntity(pCSES02DOutputRec.getSzCdCertifyEntity());
                    cfad37so.setUNbrRsrcMlAgeMin(pCSES02DOutputRec.getUNbrRshsMaAgeMin());
                    cfad37so.setUNbrRsrcFMAgeMax(pCSES02DOutputRec.getUNbrRshsFMAgeMax());
                    cfad37so.setUNbrRsrcFMAgeMin(pCSES02DOutputRec.getUNbrRshsFMAgeMin());
                    cfad37so.setUNbrRsrcMlAgeMax(pCSES02DOutputRec.getUNbrRshsMaAgeMax());
                    cfad37so.setUNbrRsrcFacilCapacity(pCSES02DOutputRec.getUNbrRshsFacilCapacity());
                    cfad37so.setUNbrRsrcIntMaAgeMax(pCSES02DOutputRec.getUNbrRshsIntMaAgeMax());
                    cfad37so.setUNbrRsrcIntMaAgeMin(pCSES02DOutputRec.getUNbrRshsIntMaAgeMin());
                    cfad37so.setUNbrRsrcIntFeAgeMin(pCSES02DOutputRec.getUNbrRshsIntFeAgeMin());
                    cfad37so.setUNbrRsrcIntFeAgeMax(pCSES02DOutputRec.getUNbrRshsIntFeAgeMax());
                    cfad37so.getCCdRsrcFaHomeType1()[0] = pCSES02DOutputRec.getCCdRshsFaHomeType1();
                    cfad37so.getCCdRsrcFaHomeType1()[1] = pCSES02DOutputRec.getCCdRshsFaHomeType2();
                    cfad37so.getCCdRsrcFaHomeType1()[2] = pCSES02DOutputRec.getCCdRshsFaHomeType3();
                    cfad37so.getCCdRsrcFaHomeType1()[3] = pCSES02DOutputRec.getCCdRshsFaHomeType4();
                    cfad37so.getCCdRsrcFaHomeType1()[4] = pCSES02DOutputRec.getCCdRshsFaHomeType5();
                    cfad37so.getCCdRsrcFaHomeType1()[5] = pCSES02DOutputRec.getCCdRshsFaHomeType6();
                    
                    //## BEGIN TUX/XML: Declare XML variables
                    cfad37so.getCCdRsrcFaHomeType1()[6] = pCSES02DOutputRec.getCCdRshsFaHomeType7();
                    ulIdEvent10 = pCSES02DOutputRec.getUlIdEvent();
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_FAD_HISTORY_DELETED;
                    
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
                    
                default :
                    
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            
            //  Check if BLOB exists
            
            
            //  Allocate memory for DAM Input and Output Structures
            pCSYS06DInputRec = new CSYS06DI();
            
            pCSYS06DOutputRec = new CSYS06DO();
            pCSYS06DInputRec.setArchInputStruct(cfad37si.getArchInputStruct());
            pCSYS06DInputRec.setUlIdEvent(cfad37si.getUlIdStage());
            pCSYS06DInputRec.setSzSysTxtTablename(HOME_STUDY_VIEW);
            
            rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    cfad37so.setBIndBLOBExistsInDatabase(true);
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    cfad37so.setBIndBLOBExistsInDatabase(false);
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        /* end if RetVal is success - Check if BLOB exists */
        
        /*
        ** SIR 14225 - Added dam to retrieve person information.
        */
        /**************************************************************************
        **
        ** Function Name:  CallCLSC18D
        **
        ** Description:    This DAM will retrieve a list of principals in the home
        **                 and data about these people using Id Stage from input.
        **
        ***************************************************************************/
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC18DInputRec = new CLSC18DI();
        pCLSC18DOutputRec = new CLSC18DO();
        pCLSC18DInputRec.setArchInputStruct(cfad37si.getArchInputStruct());
        pCLSC18DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        pCLSC18DInputRec.setUlIdStage(cfad37si.getUlIdStage());
        pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC18DO._CLSC18DO__ROWCLSC18DO_SIZE);
        rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Loop through array of principals and set boolean indicators
                
                for (i218 = 0;i218 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty();++i218) {
                    if (0 == PERSON_ROLE_APARENT.compareTo(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getSzCdStagePersRelInt())) {
                        bPrincipalsAP = 1;
                        if (MALE == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getCCdPersonSex()) {
                            bPrincipalsAPMale = true;
                            bPrincipalsMale = true;
                        }
                        else if (FEMALE == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getCCdPersonSex()) {
                            bPrincipalsAPFemale = true;
                            bPrincipalsFemale = true;
                        }
                    }
                    // SIR 23535 added this new role of AF to check
                    else if (0 == PERSON_ROLE_FPARENT.compareTo(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getSzCdStagePersRelInt())) {
                        bPrincipalsFP = 1;
                        if (MALE == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getCCdPersonSex()) {
                            bPrincipalsFPMale = true;
                            bPrincipalsMale = true;
                        }
                        else if (FEMALE == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getCCdPersonSex()) {
                            bPrincipalsFPFemale = true;
                            bPrincipalsFemale = true;
                        }
                    }
                    else if (0 == PERSON_ROLE_AFPARENT.compareTo(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getSzCdStagePersRelInt())) {
                        bPrincipalsAF = 1;
                        if (MALE == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getCCdPersonSex()) {
                            bPrincipalsMale = true;
                        }
                        else if (FEMALE == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i218).getCCdPersonSex()) {
                            bPrincipalsFemale = true;
                        }
                    }
                }
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        cfad37so.setBIndFosterParent(bPrincipalsFP);
        cfad37so.setBIndAdoptiveParent(bPrincipalsAP);
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        cfad37so.setBIndFostAdoptParent(bPrincipalsAF);
        if (bPrincipalsFPMale && bPrincipalsFPFemale) {
            cfad37so.setBIndMarriedFP(1);
        }
        
        /**************************************************************************
        ** (END): Retrieve IdCase from Stage
        **************************************************************************/
        
        
        /************************************************************************
        ** (END): Create a New Home
        ************************************************************************/
        
        /************************************************************************
        ** (BEGIN): Post Event Processing
        ************************************************************************/
        
        if (bPrincipalsAPMale && bPrincipalsAPFemale) {
            cfad37so.setBIndMarriedAP(1);
        }
        if (bPrincipalsMale && bPrincipalsFemale) {
            cfad37so.setBIndMarriedAorF(1);
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfad37si.getArchInputStruct() , cfad37so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            
            // 
            // (END): Post Event Processing
            // 
            
            // 
            // (BEGIN): Assign to Worker
            // 
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CFAD37S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CFAD37S\n");
        }
        return cfad37so;
    }

}
