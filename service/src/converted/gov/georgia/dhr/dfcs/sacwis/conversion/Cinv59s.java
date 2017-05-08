package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV59SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV59SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES97DI;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV99DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV99DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES97DO;
/**************************************************************************
**
** Module File:   cinv59s.src
**
** Service Name:  CINV59S
**
** Description:   Performs validation for the Facility Investigaton window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  5/2/95
**
** Programmer:    Sameer Rao
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   14 Mar 2002 12:13:30  $
**                      $Modtime:   13 Mar 2002 17:24:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/03/85    KRD     SIR 1595 - Modified CallCSYS04D() to insure that the
**                      Architecture Input structure has the correct value.
**  10/03/95  WEALANBC  SIR 1590 - Modified CallCINV34D() to insure that
**                      only PRNs are checked for characteristics.
**  10/03/95  WEALANBC  ERR#1596 Change to edits after CINV34D.
**  10/04/95  HUSTONMJ  ERR#1502 Change to Main Service function
**  10/10/95  HUSTONMJ  ERR#1675 Change to CallCCMN87D
**  10/13/95  VISHNUR   SIR 1765 Change to CallCCMN34D
**  10/14/95  HUSTONMJ  ERR#1674 Change to CallCCMN87D
**  11/13/95  HELMKEST  SIR 1710: Included CheckStageEventStatus common
**                      function. (CCMN06U)
**
**  03/29/96  DYARGR    SIR 5165 Allow Change Case Name event status to
**                      be NEW and still close the stage
**  05/17/96  YANTISTK  SIR 21168 - Made SQL_NOT_FOUND ok in DAM call to
**                      update the TODO table. This is because of CASE MERGE,
**                      if an INV stage is closed to merge the todo
**                      is deleted and not recreated if the stage is
**                      subsequently split.
**
**  01/06/97  RIOSJA    SIR 11222 - Before an investigation can be closed,
**                      all allegations must have information in the
**                      "seriousness of injury" and "location of incident"
**                      fields. These fields will now be checked.
**
** 04/15/97   RIOSJA    SIR 13618 - MHMR Enhancement for "APS Rapid
**                      Closure". CallCCMN87D retrieves all events associated
**                      with the investigation,it checks the event
**                      status of each event, and assigns the necessary edits.
**                      These edits are not necessary for Rapid Closure.
**                      Inserted a conditional statement in CallCCMN87D to
**                      keep edits from being assigned for Rapid Closure.
**
**  04/23/97  GONZALCE  SIR 13801/MHMR Enhancement: For Rapid Closure,
**                      there should not be any edits when selecting a reason
**                      other than Normal Closure. Therefore, CLSC16D should
**                      not be called if the case is Rapid Closure.
**  12/07/98  LEIHMA    SIR14996 - Upon conclusion of a LIC Investigation
**                      (Save and Submit), an edit is added so that if the
**                      reason for death is A/N, then that person must be a
**                      victim in an allegation where the disposition is VAL
**                      or CON.
**  05/13/99  SHARMAS   SIR 15208 - Before the user can "Save and Submit" an
**                      AFC investigation conclusion an edit is added to ensure
**                      that if there is a date of death entered during intake there
**                      must be a reason for death in the person detail window.
**	04/10/01  GRIMSHAN	SIR 13532 - Code modificatioins will be made in the AFC
**						investigation conclustion validation service to prevent
**						the person characteristics, date of birth and person search
**						edits from appearing while trying to close an investigation
**						when the name is a valid unknown name.
**
**
**3/01/2002 ochumd     Sir 15712 - Made code modifications in the AFC
**                      investigation conclusion validation service to prevent
**                      person search edits from appearing while trying to close
**                      an investigation when the person type is collateral.
**
**    12/10/2002 DWW    Added this change to rc, so that the service will return successfully
**                      but will still launch the error list. This was required because
**                      impact always checks return codes before it does a tpreturn
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**
**  04/30/03   Srini	SIR 17091: Added the error handling to take care of full 
**						table scans for ccmn87dQUERYdam.
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
**	09/17/03   Srini    SIR 19822 - IMPACT: Changed the pagesizenbr to the cinv34d dam 
**						from 100 to 50 as the output dam struct can accomodate 50 rows at
**						a time. Setting 100 was dumping core. 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/
/*
** Extern for version control table.
*/






public class Cinv59s {
    public static final String NULL_STRING = "";
    
    public static final int PERSON_LIST_SIZE = 100;
    
    public static final String EVENT_STATUS_APPROVED = "APRV";
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String EVENT_STATUS_COMP = "COMP";
    
    /* Function codes for Close or Submit or Edits action */
    public static final char ACTION_CODE_CLOSE = 'C';
    public static final char ACTION_CODE_EDITS = 'E';
    
    /* Parameter for Edit Process String */
    public static final char EDIT_YES = 'Y';
    
    /* Positions within Edit Process String */
    public static final int SUPR_APRVL_EDIT = 0;
    public static final int CONTACTS_EDIT = 1;
    public static final int EXT_DOC_EDIT = 2;
    public static final int PERS_CHARACTER_EDIT = 3;
    public static final int VICTIM_DOB_EDIT = 4;
    public static final int PERS_SEARCH_EDIT = 5;
    public static final int RSN_DTH_EDIT = 6;
    public static final int DATE_RSN_DTH_EDIT = 7;
    
    /* Person Role,types, searches etc. */
    /*
    ** SIR 13618, 04/15/97 - MHMR Enhancement for "APS Rapid Closure".
    */
    /* SIR 14996 added one more "N" TO LIST  */
    /* SIR 15208 added one more "N" TO LIST  */
    public static final String DECODE_NO_EDITS = "NNNNNNNN";
    
    public static final int PERSON_CHAR_NULL = 0;
    public static final char PERSON_CHAR_NONE = '0';
    public static final String PERSON_TYPE_PRN = "PRN";
    public static final String PERSON_ROLE_BOTH = "DB";
    public static final String PERSON_ROLE_VICTIM = "DV";
    public static final char PERSON_SEARCH_R = 'R';
    public static final char PERSON_SEARCH_V = 'V';
    
    /*******************************/
    public static final String PERSON_TYPE_COL = "COL";
    /*******************************/
    
    /* Validation Edit Warning Codes */
    public static final int PERS_CHARACTER_WARNING = 4054;
    public static final int VICTIM_DOB_WARNING = 4055;
    public static final int PERS_SEARCH_WARNING = 4056;
    public static final int EXT_DOC_WARNING = 4066;
    public static final int CONTACTS_WARNING = 4067;
    public static final int EVENT_STATUS_WARNING = 4079;
    public static final int NULL_FIELD_WARNING = 4125;
    
    public static final int INITIAL_PAGE = 1;
    public static final String STAFF_PERSON = "STF";
    
    /* check that all events are COMP before closing stage */
    public static final String EVENT_TYPE_NONE = "";
    public static final String EVENT_TYPE_PRIORITY_CHANGE = "PRT";
    public static final String EVENT_TYPE_CONTACT = "CON";
    public static final String EVENT_TYPE_MED_MENTAL_ASSESS = "MED";
    
    /* SIR 5165 */
    public static final String EVENT_TYPE_CHANGE_CASE = "CAS";
    
    /*SIR 14996 */
    public static final int MSG_INV_RSN_DTH_EDIT = 4127;
    public static final String AN_IN_OPEN_CASE = "ABN";
    public static final String AN_IN_PRIOR_CASE = "ABO";
    public static final String AN_NO_PRIOR_CASE = "ABP";
    
    /* SIR# 15208 */
    public static final int MSG_INV_DATE_RSN_DTH_EDIT = 4132;
    static int transactionflag = - 1;
    CINV59SO CINV59S(CINV59SI cinv59si) {
        CINV59SO cinv59so = new CINV59SO();
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
            userlog("ERROR: tpgetlev failed in CINV59S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV59S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV59S \n");
            bTransactionStarted = true;
        }
        int i389 = 0;
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
        CCMN06UI pCCMN06UInputRec = null;/*SIR#1710*/
        CCMN06UO pCCMN06UOutputRec = null;/*SIR#1710*/
        
        /* SIR 14996  Declare and initialize dam function input/output variables */
        
        CLSC18DO CLSC18DO = null;
        CSES97DI CSES97DI = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv59si.getArchInputStruct());
        
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
        pCCMN06UInputRec.setArchInputStruct(cinv59si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv59si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv59si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv59si.getSzCdTask());
        
        /* retrieve date and time from the client */
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
            //## END TUX/XML: Turn the XML buffer into an input message struct 
            
            
            
            if (0 != cinv59si.getSzDcdEditProcess().compareTo(DECODE_NO_EDITS)) {
                
                
                //  Call CAUD15D.  The Contract Version AUD DAM receives IdContract, 
                // NbrCnperPeriod, NbrCnverVersion, IdCntrctWkr, DtCnverCreate, 
                // DtCnverEffective, DtCnverEnd, IndCnverVerLock, NbrCnverNoShowPct 
                // and TxtCnverComment. It performs a full row AUD on the Contract 
                // Version table.
                rc = Csys07s.CallCLSC16D(cinv59si, cinv59so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            rc = Cinv01s.CallCINV34D(cinv59si, cinv59so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            
            if (cinv59si.getSzDcdEditProcess()[CONTACTS_EDIT] == EDIT_YES) {
                rc = Csys04s.CallCSYS04D(cinv59si, cinv59so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            if (cinv59si.getSzDcdEditProcess()[EXT_DOC_EDIT] == EDIT_YES) {
                
                
                //  Call CLSS73D. Retrieves all records from Contract County
                // for our given Resource/Service for Contracts other than 
                // our own for the given date parametes.  If any data is 
                // returned, we will stop the save process
                rc = CallCINV99D(cinv59si, cinv59so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            rc = Cinv15s.CallCLSC18D(cinv59si, cinv59so, CLSC18DO, pServiceStatus);
            
            //  Analyze return code
            switch (rc) //  IMPACT END
            {
                case WtcHelperConstants.ARC_SUCCESS:
                    //  IRA2001 - BEGIN
                    // Since you can view old Risk Asmt narratives
                    // from the Inv Concl. window, and you will now
                    // be able to view IRA narratives too, an if
                    // statement was added to check the Intranet
                    // indicator.  If the asmt was created via the
                    // Intranet ('Y'), then we want to query the new
                    // IRA_NARRATIVE table.  Otherwise, it was an old
                    // Risk Asmt and we will query the old
                    // RISK_ASSMT_NARR table.
                    //SIR# 18055   Added to check for 'M' as well for Impact.
                    if (cinv59si.getSzDcdEditProcess()[RSN_DTH_EDIT] == EDIT_YES) {
                        for (i389 = 0;(i389 < CLSC18DO.getArchOutputStruct().getUlRowQty() || bRsnDthEdit.value == true);++i389) {
                            if ((0 == CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i389).getSzCdPersonDeath().compareTo(AN_IN_OPEN_CASE)) || (0 == CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i389).getSzCdPersonDeath().compareTo(AN_IN_PRIOR_CASE)) || (0 == CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i389).getSzCdPersonDeath().compareTo(AN_NO_PRIOR_CASE))) {
                                CSES97DI.setUlIdPerson(CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i389).getUlIdPerson());
                                rc = Cinv15s.CallCSES97D(cinv59si, CSES97DI, bRsnDthEdit, cinv59so, pServiceStatus);
                            }
                        }
                    }
                    break;
            }
            if ((0 == cinv59so.getCINV59SOG01().getUlRowQty()) && (cinv59si.getArchInputStruct().getCReqFuncCd() != ACTION_CODE_EDITS)) 
            {
                
                rc = Cinv12s.CallCINV43D(cinv59si, cinv59so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                rc = Ccmn02u.CallCCMN87D(cinv59si, cinv59so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                //  Analyze error code
                if ((cinv59si.getArchInputStruct().getCReqFuncCd() == ACTION_CODE_CLOSE) && (0 == cinv59so.getCINV59SOG01().getUlRowQty())) {
                    rc = Ccmn05u.CallCCMN62D(cinv59si, cinv59so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    rc = CallCloseStage(cinv59si, cinv59so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                
                
                
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv59si.getArchInputStruct() , cinv59so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV59S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV59S \n");
        }
        return cinv59so;
    }

    static int CallCINV34D(CINV59SI pInputMsg779, CINV59SO pOutputMsg724, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i390 = 0;
        
        /*
        ** Declare local variables
        */
        CINV34DI pCINV34DInputRec = null;
        CINV34DO pCINV34DOutputRec = null;
        
        /* unsigned short bLivingArrange = FALSE;  SIR 13532 */
        boolean bPersCharacter = false;
        boolean bVictimDob = false;
        int bUnknownName = 0;/* SIR 13532 */
        boolean bPersSearch = false;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV34DInputRec = new CINV34DI();
        
        pCINV34DOutputRec = new CINV34DO();
        pCINV34DInputRec.setArchInputStruct(pInputMsg779.getArchInputStruct());
        pCINV34DInputRec.setUlIdStage(pInputMsg779.getUlIdStage());
        pCINV34DInputRec.setSzCdStagePersType(STAFF_PERSON);
        pCINV34DInputRec.getArchInputStruct().setUsPageNbr(0);
        pCINV34DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV34DO._CINV34DO__ROWCINV34DO_SIZE);
        pCINV34DOutputRec.getArchOutputStruct().setBMoreDataInd(1);
        
        /*
        ** Set loop to retrieve all the persons associated with the case
        */
        while (pCINV34DOutputRec.getArchOutputStruct().getBMoreDataInd() != 0) {
            pCINV34DInputRec.getArchInputStruct().getUsPageNbr()++;
            rc = cinv34dQUERYdam(sqlca, pCINV34DInputRec, pCINV34DOutputRec);
            
            //  Populate Input Structure for DAM
            // RIOSJA, SIR 14003 - If searching for CVS Removal
            // events, search the entire case, not just the stage
            // being closed.
            // SIR 23538 - also search entire case for service auth events
            // SIR 23657 - search for APS/SVC service auth events, not CPS/FPR service auth events
            if (rc != WtcHelperConstants.SQL_SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
            else {
                for (i390 = 0;i390 < pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();++i390) {
                    bUnknownName// SIR 13532
                     = 0;
                    if ((null == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getSzNmPersonFirst()[0]) && (null == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getSzNmPersonLast()[0])) {
                        // SIR 13532
                        // Reset bUnknownName for each person in the loop
                        
                        bUnknownName = 1;
                    }
                    if ((EDIT_YES == pInputMsg779.getSzDcdEditProcess()[PERS_SEARCH_EDIT]) && (PERSON_SEARCH_R != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getSzCdStagePersSearchInd()) && (PERSON_SEARCH_V != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getSzCdStagePersSearchInd()) && (0 != PERSON_TYPE_COL.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getSzCdStagePersType())) && (!bUnknownName)) {
                        bPersSearch = true;
                        pOutputMsg724.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg724.getCINV59SOG01().getUlRowQty() , VICTIM_DOB_WARNING);
                    }
                    
                    // 
                    // SIR 1829: Need to pop up Pending Event Message for New Contacts and
                    // Med/Mental Assessments for a stage that has been submitted for
                    // closure.  The closure event for Service Delivery has a type of
                    // SVC_CD_EVENT_TYPE_CLOSE as opposed to SVC_CD_EVENT_TYPE_CONCL for
                    // Investigation.
                    // For Med/Mental: Also added DAM CINT21D for stage retrieval to get
                    // CD_STAGE.  Added temporary szCdStage variable to store the retrieved
                    // stage information throughout the service.
                    // 
                    
                    //  SIR 2041: If statement changed from Service Delivery to Investigation
                    // (INVEST) and the appropriate event types copied to CCMN87D
                    if ((EDIT_YES == pInputMsg779.getSzDcdEditProcess()[PERS_CHARACTER_EDIT]) && ((PERSON_CHAR_NONE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getBCdPersonChar()) || (PERSON_CHAR_NULL == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getBCdPersonChar())) && (0 == PERSON_TYPE_PRN.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getSzCdStagePersType())) && (!bUnknownName)) {
                        bPersCharacter = true;
                    }
                    
                    if (EDIT_YES == pInputMsg779.getSzDcdEditProcess()[VICTIM_DOB_EDIT] &&!(strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getSzCdStagePersType() , PERSON_TYPE_PRN, PERSON_TYPE_PRN.length()) != 0) && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getDtDtPersonBirth().day && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getDtDtPersonBirth().month && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i390).getDtDtPersonBirth().year && bUnknownName != true) {
                        bVictimDob = true;
                    }
                    if (bPersCharacter && bVictimDob && bPersSearch) {
                        
                        
                        
                        break;
                    }
                }
            }
            
            if (bPersCharacter && bVictimDob && bPersSearch) {
                pCINV34DOutputRec.getArchOutputStruct().setBMoreDataInd(0);
            }
        }
        if (bPersCharacter) {
            pOutputMsg724.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg724.getCINV59SOG01().getUlRowQty() , PERS_CHARACTER_WARNING);
            pOutputMsg724.getCINV59SOG01().getUlRowQty()++;
        }
        
        if (bVictimDob) {
            pOutputMsg724.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg724.getCINV59SOG01().getUlRowQty() , VICTIM_DOB_WARNING);
            pOutputMsg724.getCINV59SOG01().getUlRowQty()++;
        }
        
        if (bPersSearch) {
            pOutputMsg724.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg724.getCINV59SOG01().getUlRowQty() , PERS_SEARCH_WARNING);
            pOutputMsg724.getCINV59SOG01().getUlRowQty()++;
        }
        
        return rc;
    }

    static int CallCSYS04D(CINV59SI pInputMsg780, CINV59SO pOutputMsg725, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSYS04DI pCSYS04DInputRec = null;
        CSYS04DO pCSYS04DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS04DInputRec = new CSYS04DI();
        
        pCSYS04DOutputRec = new CSYS04DO();
        pCSYS04DInputRec.setArchInputStruct(pInputMsg780.getArchInputStruct());
        pCSYS04DInputRec.getArchInputStruct().setUlPageSizeNbr(CSYS04DO._CSYS04DO__ROWCSYS04DO_SIZE);
        pCSYS04DInputRec.setUlIdStage(pInputMsg780.getUlIdStage());
        rc = csys04dQUERYdam(sqlca, pCSYS04DInputRec, pCSYS04DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg725.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg725.getCINV59SOG01().getUlRowQty() , CONTACTS_WARNING);
                pOutputMsg725.getCINV59SOG01().getUlRowQty()++;
                
                
                //  Call CSES41D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCINV99D(CINV59SI pInputMsg781, CINV59SO pOutputMsg726, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV99DI pCINV99DInputRec = null;
        CINV99DO pCINV99DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV99DInputRec = new CINV99DI();
        
        
        pCINV99DOutputRec = new CINV99DO();
        pCINV99DInputRec.setArchInputStruct(pInputMsg781.getArchInputStruct());
        pCINV99DInputRec.setUlIdCase(pInputMsg781.getUlIdCase());
        rc = cinv99dQUERYdam(sqlca, pCINV99DInputRec, pCINV99DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            //  Analyze return code
            switch (rc) 
            {
                case NO_DATA_FOUND:
                    pOutputMsg726.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg726.getCINV59SOG01().getUlRowQty() , EXT_DOC_WARNING);
                    pOutputMsg726.getCINV59SOG01().getUlRowQty()++;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
            
        }
        
        return rc;
    }

    static int CallCINV43D(CINV59SI pInputMsg782, CINV59SO * pOutputMsg727, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINV43DInputRec.setUlIdEvent(pInputMsg782.getUlIdEvent());
        pCINV43DInputRec.setArchInputStruct(pInputMsg782.getArchInputStruct());
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        return rc;
    }

    static int CallCCMN87D(CINV59SI pInputMsg783, CINV59SO pOutputMsg728, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usEventCtr = 0;/* Event Counter */
        int rc = 0;/* Return code */
        
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
        pCCMN87DInputRec.setArchInputStruct(pInputMsg783.getArchInputStruct());
        pCCMN87DInputRec.setUlIdStage(pInputMsg783.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(EVENT_TYPE_NONE);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV59SO._CINV59SO__CINV59SOG00_SIZE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg728.getArchOutputStruct().setUlRowQty(pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty());
                
                
                for (usEventCtr = 0;usEventCtr < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();usEventCtr++) {
                    
                    
                    
                    if (0 != pInputMsg783.getSzDcdEditProcess().compareTo(DECODE_NO_EDITS)) {
                        if (pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_COMP) != 0 && pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_APPROVED) != 0) {
                            if (!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_CONTACT) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0)) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_PRIORITY_CHANGE) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0)) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_MED_MENTAL_ASSESS) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0)) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_CHANGE_CASE) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0))) {
                                pOutputMsg728.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg728.getCINV59SOG01().getUlRowQty() , EVENT_STATUS_WARNING);
                                pOutputMsg728.getCINV59SOG01().getUlRowQty()++;
                                break;
                            }
                        }
                    }
                    pOutputMsg728.getCINV59SOG00_ARRAY().getCINV59SOG00(usEventCtr).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getUlIdEvent());
                }
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                //  The DAM retrieves the CD REJ RSN when passed CD REJ RSN REJ ITEM ID
                // and ID REJECTED ITEM.
                
                //  Start Performance Timer
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCCMN62D(CINV59SI pInputMsg784, CINV59SO pOutputMsg729, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        int usEventCtr = 0;
        /*
        ** Declare local variables
        */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setArchInputStruct(pInputMsg784.getArchInputStruct());
        
        /*
        ** Loop through Investigation Events, changing status to Approved
        */
        for (usEventCtr = 0;usEventCtr < pOutputMsg729.getArchOutputStruct().getUlRowQty();usEventCtr++) {
            pCCMN62DInputRec.setUlIdEvent(pOutputMsg729.getCINV59SOG00_ARRAY().getCINV59SOG00(usEventCtr).getUlIdEvent());
            pCCMN62DInputRec.setSzCdEventStatus(EVENT_STATUS_APPROVED);
            pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
            //  END compare date processing
            
            if (rc != WtcHelperConstants.SQL_SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        /* Return the return code to the calling routine */
        return rc;
    }

    static int CallCLSC16D(CINV59SI pInputMsg785, CINV59SO pOutputMsg730, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i391 = 0;
        /*
        ** Declare local variables
        */
        CLSC16DI pCLSC16DInputRec = null;
        CLSC16DO pCLSC16DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC16DInputRec = new CLSC16DI();
        
        pCLSC16DOutputRec = new CLSC16DO();
        
        /*
        ** Free memory before processing any user function error.
        ** By the time the return code is checked,
        ** all clean-up processing has occured.
        */
        pCLSC16DInputRec.setUlIdAllegationStage(pInputMsg785.getUlIdStage());
        
        pCLSC16DInputRec.setArchInputStruct(pInputMsg785.getArchInputStruct());
        pCLSC16DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSC16DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC16DO._CLSC16DO__ROWCLSC16DO_SIZE);
        rc = clsc16dQUERYdam(sqlca, pCLSC16DInputRec, pCLSC16DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  Check if allegation "seriousness of injury" and "location of
                // incident" fields are NULL. If they are NULL, return an error.
                for (i391 = 0;i391 < pCLSC16DOutputRec.getArchOutputStruct().getUlRowQty();i391++) {
                    // SIR 22824
                    if ((0 == pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i391).getSzCdFacilAllegEventLoc().compareTo(NULL_STRING)) || (0 == pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i391).getSzCdFacilAllegInjSer().compareTo(NULL_STRING))) {
                        pOutputMsg730.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg730.getCINV59SOG01().getUlRowQty() , NULL_FIELD_WARNING);
                        pOutputMsg730.getCINV59SOG01().getUlRowQty()++;
                        
                        break;
                    }
                }
                
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        return rc;
    }

    static int CallCloseStage(CINV59SI pInputMsg786, CINV59SO * pOutputMsg731, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN02UI pCCMN02UInputRec = null;
        CCMN02UO pCCMN02UOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN02UInputRec = new CCMN02UI();
        
        
        pCCMN02UOutputRec = new CCMN02UO();
        pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(pInputMsg786.getUlIdStage());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(pInputMsg786.getSzCdStage());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(pInputMsg786.getSzCdStageProgram());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(pInputMsg786.getSzCdStageReasonClosed());
        
        /*
        ** Call CSEC73D
        */
        rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
        
        /*
        ** Return out of the service b/c we do not want to
        ** execute the following steps in the service
        */
        //##                        return (FND_SUCCESS);                       
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        return rc;
    }

    static int CallCLSC18D(CINV59SI pInputMsg787, CINV59SO pOutputMsg732, CLSC18DO pRsnDthOut, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i392 = 0;
        
        /*
        ** Declare local variables
        */
        CLSC18DI pCLSC18DInputRec = null;
        CLSC18DO pCLSC18DOutputRec = null;
        int bDateRsnDth = 0;/* Local Variable SIR 15208 */
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC18DInputRec = new CLSC18DI();
        pCLSC18DOutputRec = new CLSC18DO();
        pCLSC18DInputRec.setArchInputStruct(pInputMsg787.getArchInputStruct());
        pCLSC18DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        pCLSC18DInputRec.setUlIdStage(pInputMsg787.getUlIdStage());
        pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC18DO._CLSC18DO__ROWCLSC18DO_SIZE);
        rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
        /*
        ** IMPACT BEGIN
        */
        /*
        ** IMPACT END
        */
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (pInputMsg787.getSzDcdEditProcess()[DATE_RSN_DTH_EDIT] == EDIT_YES) {
                    for (i392 = 0;(i392 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty() && true != bDateRsnDth);++i392) {
                        
                        if (DateHelper.NULL_DATE != pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i392).getDtDtPersonDeath().month && null == pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i392).getSzCdPersonDeath()[0]) {
                            bDateRsnDth = 1;
                        }
                    }
                }
                
                
                //  Populate Output Message
                
                for (i392 = 0;(i392 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());++i392) {
                    pRsnDthOut.getArchOutputStruct().setUlRowQty(pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());
                    pRsnDthOut.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i392).setUlIdPerson(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i392).getUlIdPerson());
                    pRsnDthOut.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i392).setSzCdPersonDeath(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i392).getSzCdPersonDeath());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        if (bDateRsnDth != 0) {
            pOutputMsg732.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg732.getCINV59SOG01().getUlRowQty() , MSG_INV_DATE_RSN_DTH_EDIT);
            pOutputMsg732.getCINV59SOG01().getUlRowQty()++;
        }
        return rc;
    }

    static int CallCSES97D(CINV59SI pInputMsg788, CSES97DI pRsnDthIn, String bRsnDthEdit, CINV59SO pOutputMsg733, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCSES97DInputRec.setUlIdStage(pInputMsg788.getUlIdStage());
        pCSES97DInputRec.setUlIdPerson(pRsnDthIn.getUlIdPerson());
        pCSES97DInputRec.setArchInputStruct(pInputMsg788.getArchInputStruct());
        rc = cses97dQUERYdam(sqlca, pCSES97DInputRec, pCSES97DOutputRec);
        switch (rc) {
            case NO_DATA_FOUND:
                {
                    bRsnDthEdit = true;
                    pOutputMsg733.getCINV59SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg733.getCINV59SOG01().getUlRowQty() , MSG_INV_RSN_DTH_EDIT);
                    pOutputMsg733.getCINV59SOG01().getUlRowQty()++;
                    
                    //  Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    //  No need to call the Phone DAMs
                    break;
                }
            case WtcHelperConstants.SQL_SUCCESS:
                {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

}
