package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN31DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN31DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC42DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC42DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES84DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CFAD39S.src
**
** Service Name:  CFAD39S - Adpt Sub Rtrv
**
** Description:   This service will check for the skill of Adoption Subsidy 
**                Subsidy Specialist for the user, check if the stage 
**                child's adoption has been consummated, and retrieve
**                information on the placement, resource, contract,
**                and Adoption Subsidy associated with the given event
**                and determine if the Adoption Subsidy Eligibility
**                Document exists.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/31/1996
** 
** Programmer:    Brian Walker
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/22/96  VISHNUR   SIR 3291 - THIS IS A TEMPORARY FIX.
**                      All the code dealing with VALIDATING contracts,
**                      County and Service Code is being commented out.
**                      NEED TO BE UNCOMMENTED WHEN THE CONTRACTS CODE
**                      IS PROMOTED. The lines are c
**
**  02/26/96  ADKINSMC  SIR 3391 - Added a SQL_NOT_FOUND case for the dam
**                      which retrieves the Employee Skill row.
**
**  03/04/96  ADKINSMC  SIR 3485 - Added SQL_NOT_FOUND case for CCMN31D,
**                      Employee Skills, so an employee with no skills can
**                      retrieve.
**
** 03/04/96   OMARAJJ   SIR#3494--Switched the two IF statements following 
**                      the call to CRES04D. If there is a Resource Address 
**                      should come before If there is a Resource VID 
**                      because when there is no Address there is never a 
**                      VID, but occasionally there may not be a VID and 
**                      there is an Address.  This change is necessary so 
**                      that Address is always verified before VID.
**  3/11/96   PURCELA   SIR #3710 - If a Dummy Event has been created, then
**                      all event information should be retrieved.  Adoption
**                      Subsidy retrieve logic, however, should be skipped.
**                      The scenario to check on is an idEvent not zero
**                      corresponding to an EventStatus of NEW.
**  3/25/96   PURCELA   SIR #4213 - Also retrieve the IndAdptSubProcess
**                      from Adoption Subsidy to be passed through to the
**                      Save Service
**  4/8/96    OMARAJJ   SIR #20098 - Added a lot of new code and rearranged 
**                      this service, as well as CASV01W, in order to allow
**                      the user access to the Adoption Subsidy windows in
**                      the event the associated Placement is removed prior
**                      to the closing of the Adoption Subsidy.  The major 
**                      change involved the separation of the retrieve in to
**                      three sections: one, if the user calls the service by
**                      use of the NEW pushbutton, two, if the user utilizes
**                      the detail button. The third section is called if
**                      if either the first or second second section is a 
**                      success. Search the code (SIR#20098) for detailed 
**                      comments about each change.
**  4/18/96   PURCELA   SIR #20505 - Remove commenting from SIR #3291.  FAD
**                      Contracts now in effect.  Also modified code that was
**                      setting the ASV_NO_PLACEMENT and ASV_NO_RESOURCE
**                      messages to be based on the correct conditionality.
**                      See the comments with the actual code.  Switched the
**                      NO_ASV_CONTRACT and NO_ACT_CONTRACT messages as well.
** 4/30/96    PURCELA   SIR #20505 - If the Detail Click has been selected, 
**                      then Contract Date Validation must still occur,
**                      although differently than in a New click.  The 
**                      contract will still be retrieved from Contract County,
**                      although the key date will be the Subsidy's End Date.
**                      If this is not found, then we will set an indicator 
**                      and pass back NULL_DATE values for the Contract 
**                      Period Dates. The indicator will trigger a message on 
**                      the Client side that the subsidy no longer has a 
**                      valid contract, and Contract date validation will be 
**                      skipped if the Contract Period Dates are NULL_DATES.
**                      In addition, the Client Side will not validate 
**                      Subsidy Start Date at all if the Last Invoice Date
**                      from the Adoption Subsidy Table has any value at all.
**                      Otherwise,Client Side validation will remain the same.
**
**  5/9/96   CRYSTAEP   SIR 21028 - Added a call to newly created DAM CSES84D
**                      to determine if the business address for the resource
**                      has a VID.  If not a message will be displayed 
**                      informing the user that the home needs a VID.
**                       
**  05/16/96 CRYSTAEP   SIR 21173 - Corrected SQL_NOT_FOUND condition of call
**                      to DAM CSES84D to display MSG_FAD_NO_PAYEE_VID.
**                      Also, added conditional around CCMN31D so that this 
**                      DAM will not be called unless CSES84D was successful.
**  11/18/96 PHILLILH   SIR 11795 - Added if condition to accomodate an 
**                      Adoption Subsidy in NEW status.  Previously, a Data
**                      Access Error occurred because the code could not
**                      handle an Event created by an unlinked ToDo which
**                      gives a status of NEW.  It will have an id_event,
**                      but no Adoption Subsidy information.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**                      and changed TRUE to INDICATOR_YES and FALSE 
**                      to INDICATOR_NO for cSysIndContractCurrent
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**                                              to PROCESS_TUX_RC_ERROR_NOFREE after the 
**                                              ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**                                              input and output objects before they are allocated
**
**  06/30/03  mcclaim   SIR 18367 - display error messages
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad39s {
    
    /*
    ** Declare FOUNDATION variables 
    */
    
    static final int TIMEVAR = - 1;
    CFAD39SO CFAD39S(CFAD39SI cfad39si) {
        CFAD39SO cfad39so = new CFAD39SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CFAD39S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        public int i221 = 0;
        int iLoopCounter = 0;
        //##  short           rc = FND_SUCCESS,
        int RetVal = SUCCESS;
        int lRC9 = 0;
        int ulTempIdResource = 0;
        String szTempCounty = new String();/* SIR #20505 */
        
        
        char bSkillNotFound = 0;
        
        
        CCMN31DI pCCMN31DInputRec = null;
        CCMN31DO pCCMN31DOutputRec = null;
        
        CSEC58DI pCSEC58DInputRec = null;
        CSEC58DO pCSEC58DOutputRec = null;
        
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        
        CMSC41DI pCMSC41DInputRec = null;
        CMSC41DO pCMSC41DOutputRec = null;
        
        CSES64DI pCSES64DInputRec = null;
        CSES64DO pCSES64DOutputRec = null;
        
        CSEC60DI pCSEC60DInputRec = null;
        CSEC60DO pCSEC60DOutputRec = null;
        
        CSEC11DI pCSEC11DInputRec = null;
        CSEC11DO pCSEC11DOutputRec = null;
        
        CSEC12DI pCSEC12DInputRec = null;
        CSEC12DO pCSEC12DOutputRec = null;
        
        CSYS06DI pCSYS06DInputRec = null;
        CSYS06DO pCSYS06DOutputRec = null;
        
        CMSC42DI pCMSC42DInputRec = null;
        CMSC42DO pCMSC42DOutputRec = null;
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        CSEC32DI pCSEC32DInputRec = null;
        CSEC32DO pCSEC32DOutputRec = null;
        CSES37DI pCSES37DInputRec = null;/* SIR# 20098: Placement Retrieve */
        CSES37DO pCSES37DOutputRec = null;/* SIR#20098 */
        CSES84DI pCSES84DInputRec = null;/* SIR 21028 */
        CSES84DO pCSES84DOutputRec = null;/* SIR 21028 */
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = ARC_PRFServiceStartTime_TUX(cfad39si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cfad39so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (0 != cfad39si.getUlIdEvent()) {
            
            // 
            // (BEGIN): Event Row Retrieval CCMN45D
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN45DInputRec = new CCMN45DI();
            
            pCCMN45DOutputRec = new CCMN45DO();
            pCCMN45DInputRec.setUlIdEvent(cfad39si.getUlIdEvent());
            rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfad39so.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                    cfad39so.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                    cfad39so.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                    cfad39so.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                    cfad39so.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                    cfad39so.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                    
                    cfad39so.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                    
                    cfad39so.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                    cfad39so.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            // 
            // BEGIN Retrieval for CSEC58D - Prim Child Info Rtrv
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC58DInputRec = new CSEC58DI();
            
            pCSEC58DOutputRec = new CSEC58DO();
            pCSEC58DInputRec.setUlIdStage(cfad39si.getUlIdStage());
            
            rc = csec58dQUERYdam(sqlca, pCSEC58DInputRec, pCSEC58DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfad39so.setUlIdPerson(pCSEC58DOutputRec.getUlIdPerson());
                    cfad39so.setDtDtPersonBirth(pCSEC58DOutputRec.getDtDtPersonBirth());
                    cfad39so.setUlIdCase(pCSEC58DOutputRec.getUlIdCase());
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
            }
        }
        if ((SUCCESS == RetVal) && ((0 == cfad39si.getUlIdEvent()) || (0 == Csub45s.EVENT_STATUS_NEW.compareTo(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())))) {
            // 
            // BEGIN Retrieval for CSEC32D - Act Plcmt for a given Dt
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC32DInputRec = new CSEC32DI();
            
            pCSEC32DOutputRec = new CSEC32DO();
            pCSEC32DInputRec.setUlIdPlcmtChild(cfad39so.getUlIdPerson());
            
            //  Call CAUD08D The Contract County AUD performs a full row insert,
            // update or delete to the Contract County table.
            rc = ARC_UTLGetDateAndTime(pCSEC32DInputRec.getDtScrDtLastUpdate() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = csec32dQUERYdam(sqlca, pCSEC32DInputRec, pCSEC32DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    if (pCSEC32DOutputRec.getDtDtPlcmtEnd().year != DateHelper.NULL_DATE) {
                        lRC9 = ARC_UTLCompareDateAndTime((FndInt3date) & cfad39so.getDtWCDDtSystemDate() , (char) 0, (FndInt3date) & pCSEC32DOutputRec.getDtDtPlcmtEnd() , (char) 0);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    else {
                        lRC9 = TIMEVAR;
                    }
                    cfad39so.setUlIdPlcmtEvent(pCSEC32DOutputRec.getUlIdPlcmtEvent());
                    cfad39so.getCFAD39SOG00().setUlIdAdptSubPayee(pCSEC32DOutputRec.getUlIdRsrcFacil());
                    ulTempIdResource = pCSEC32DOutputRec.getUlIdRsrcFacil();// SIR#20089
                    
                    //  Analyze error code
                    if ((0 != pCSEC32DOutputRec.getUlIdRsrcFacil()) && (lRC9 >= 0 || ((0 != pCSEC32DOutputRec.getSzCdPlcmtLivArr().compareTo(GT)) && (0 != pCSEC32DOutputRec.getSzCdPlcmtLivArr().compareTo(RSRC_TYPE_PVT_AGENCY))))) {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_ASV_NO_PLCMT;
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                    }
                    
                    
                    else if ((0 == pCSEC32DOutputRec.getUlIdRsrcFacil()) && (0 != pCSEC32DOutputRec.getUlIdPlcmtAdult())) {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_ASV_NO_RESOURCE;
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                    }
                    
                    
                    
                    //  Else call CSEC60D - Contract County by Date
                    else {
                        // 
                        // BEGIN Retrieval for CSEC60D - Contract County by Date
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        
                        // SIR 3291 - commented
                        // SIR #20505 - uncommented
                        
                        pCSEC60DInputRec = new CSEC60DI();
                        
                        pCSEC60DOutputRec = new CSEC60DO();
                        pCSEC60DInputRec.setUlIdResource(cfad39so.getCFAD39SOG00().getUlIdAdptSubPayee());
                        pCSEC60DInputRec.setSzCdCncntyCounty(pCSEC32DOutputRec.getSzAddrPlcmtCnty());
                        pCSEC60DInputRec.setSzCdCncntyService(Csub45s.ADOPTION);
                        rc = ARC_UTLGetDateAndTime(pCSEC60DInputRec.getDtSysDtGenericSysdate() , 0);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        //  Call CAUD20D.  The Contract Period ELB DAM receives IdContract and
                        // performs an AUD on the indicated row.
                        // Delete:  a stored procedure is called to perform a cascade delete
                        // for Contract Version, Contract Service and Contract County.
                        // Add:     Performs a full row insert into Contract Period Table
                        // Modify:  Performs a full row update into Contract Period Table.
                        rc = csec60dQUERYdam(sqlca, pCSEC60DInputRec, pCSEC60DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                cfad39so.setUlIdContract(pCSEC60DOutputRec.getUlIdContract());
                                
                                //  Call CSEC11D
                                
                                // 
                                // BEGIN Retrieval for CSEC11D - CONTRACT/PERIOD
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                
                                // SIR 3291 - commented
                                // SIR #20505 - uncommented
                                
                                pCSEC11DInputRec = new CSEC11DI();
                                
                                pCSEC11DOutputRec = new CSEC11DO();
                                pCSEC11DInputRec.setUlIdContract(cfad39so.getUlIdContract());
                                pCSEC11DInputRec.setUlNbrCnperPeriod(pCSEC60DOutputRec.getUlNbrCncntyPeriod());
                                rc = csec11dQUERYdam(sqlca, pCSEC11DInputRec, pCSEC11DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        lRC9 = ARC_UTLCompareDateAndTime((FndInt3date) & pCSEC11DOutputRec.getDtDtCnperTerm() , (char) 0, (FndInt3date) & cfad39so.getDtWCDDtSystemDate() , (char) 0);
                                        
                                        if (lRC9 <= 0) {
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_ASV_NO_CONTRACT;
                                            
                                            //  Set RetVal to FND_FAIL
                                            
                                            // SIR 3291 - commented
                                            // SIR #20505 - uncommented
                                            
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                        }
                                        
                                        //  Else Call CSEC12D Contract by period
                                        
                                        // SIR 3291 - commented
                                        // SIR #20505 - uncommented
                                        
                                        else {
                                            
                                            // 
                                            // BEGIN Retrieval for CSEC12D Contract by period
                                            // 
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            
                                            // SIR 3291 - commented
                                            // SIR #20505 - uncommented
                                            
                                            pCSEC12DInputRec = new CSEC12DI();
                                            
                                            pCSEC12DOutputRec = new CSEC12DO();
                                            
                                            pCSEC12DInputRec.setUlIdContract(cfad39so.getUlIdContract());
                                            pCSEC12DInputRec.setUlNbrCnperPeriod(1);
                                            rc = csec12dQUERYdam(sqlca, pCSEC12DInputRec, pCSEC12DOutputRec);
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    cfad39so.setDtDtCnperStart(pCSEC12DOutputRec.getDtDtCnperStart());
                                                    
                                                    //  Call CMSC42D
                                                    
                                                    // 
                                                    // BEGIN Retrieval for CMSC42D GET MAX PERIOD TERM
                                                    // 
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    
                                                    // SIR 3291 - commented
                                                    // SIR #20505 - uncommented
                                                    
                                                    pCMSC42DInputRec = new CMSC42DI();
                                                    
                                                    pCMSC42DOutputRec = new CMSC42DO();
                                                    pCMSC42DInputRec.setUlIdContract(cfad39so.getUlIdContract());
                                                    rc = cmsc42dQUERYdam(sqlca, pCMSC42DInputRec, pCMSC42DOutputRec);
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            cfad39so.setDtDtCnperTerm(pCMSC42DOutputRec.getDtDtCnperTerm());
                                                            
                                                            break;
                                                            
                                                            
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                    break;
                                                    
                                                    
                                                    // 
                                                    // CONTINUE Retrieval for CMSC42D GET MAX PERIOD TERM
                                                    // 
                                                    
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    
                                                    RetVal = Csub50s.FND_FAIL;
                                                    
                                                    break;
                                            }
                                        }
                                        
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_ASV_NO_ACT_CNRCT;
                                        
                                        //  Set RetVal to FND_FAIL
                                        
                                        // SIR 3291 - commented
                                        // SIR #20505 - uncommented
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        
                                        break;
                                }
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_ASV_NO_ASV_CONTRACT;
                                
                                //  Set RetVal to FND_FAIL
                                
                                // SIR 3291 - commented
                                // SIR #20505 - uncommented
                                
                                RetVal = Csub50s.FND_FAIL;
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_ASV_NO_PLCMT;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
                    
                default :
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
                    //   Insert any manipulation required on the DAM output record
                    // before sending the data to ARC_FRMProduceFormData in the
                    // calling function.  In most cases, this loop will be removed
                    // because there is no processing to be done.
                    // 
            }
        }
        
        /***********************************************************
        **  END Retrieval for CSEC32D - Act Plcmt for a given Dt
        ***********************************************************/
        
        /*
        ** SIR#20098
        **
        */
        
        /* 
        ** SIR#20098 - The following ELSE conditon contains the code that
        ** is executed when the user click the detail button on the TASK LIST
        ** for an Adoption Subsidy stage.  Two DAMs were added to the service to
        ** executed this functionality, CSES64D, which retrieves data from the 
        ** adoption subsidy table given an IdEvent, and CSES37D, a DAM that retrieves
        ** data from the placement table given and Id Placement Event. In the event
        ** that the Placement for the specified Adoption Subsidy is closed the No
        ** Placement message is displayed.  After clicking on the Yes button, the
        ** user is allowed to enter the Adoption Subsidy window in modify mode.  
        ** Thus, after CSES37D retrieves the placement data a check is performed
        ** on the status of the placement.  If closed an indicator flag is set so
        ** that the message is triggered on the client side.  If the placement is
        ** open no action is taken.  In either case data concerning the details of 
        ** the adoption subsidy is retrieved.
        */
        else {
            // 
            // BEGIN Retrieval for CSES64D ADOPTION SUBSIDY RETRIEVE
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES64DInputRec = new CSES64DI();
            
            pCSES64DOutputRec = new CSES64DO();
            pCSES64DInputRec.setUlIdEvent(cfad39si.getUlIdEvent());
            
            //  Call CAUDB7D
            rc = cses64dQUERYdam(sqlca, pCSES64DInputRec, pCSES64DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfad39so.setUlIdPlcmtEvent(pCSES64DOutputRec.getUlIdPlcmtEvent());
                    cfad39so.getCFAD39SOG00().setUlIdAdptSub(pCSES64DOutputRec.getUlIdAdptSub());
                    cfad39so.getCFAD39SOG00().setDtDtAdptSubAgreeRetn(pCSES64DOutputRec.getDtDtAdptSubAgreeRetn());
                    //##          return (FND_SUCCESS);
                    cfad39so.getCFAD39SOG00().setUlIdAdptSubPayee(pCSES64DOutputRec.getUlIdAdptSubPayee());
                    cfad39so.getCFAD39SOG00().setDtDtAdptSubAgreeSent(pCSES64DOutputRec.getDtDtAdptSubAgreeSent());
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    cfad39so.getCFAD39SOG00().setDtDtAdptSubAppReturned(pCSES64DOutputRec.getDtDtAdptSubAppReturned());
                    cfad39so.getCFAD39SOG00().setDtDtAdptSubAppSent(pCSES64DOutputRec.getDtDtAdptSubAppSent());
                    cfad39so.getCFAD39SOG00().setDtDtAdptSubApprvd(pCSES64DOutputRec.getDtDtAdptSubApprvd());
                    cfad39so.getCFAD39SOG00().setDtDtAdptSubEffective(pCSES64DOutputRec.getDtDtAdptSubEffective());
                    cfad39so.getCFAD39SOG00().setDtDtAdptSubEnd(pCSES64DOutputRec.getDtDtAdptSubEnd());
                    cfad39so.getCFAD39SOG00().setSAmtAdptSub(pCSES64DOutputRec.getSAmtAdptSub());
                    cfad39so.getCFAD39SOG00().setSzTxtAdptSubRsn(pCSES64DOutputRec.getSzTxtAdptSubRsn());
                    cfad39so.getCFAD39SOG00().setSzCdAdptSubCloseRsn(pCSES64DOutputRec.getSzCdAdptSubCloseRsn());
                    cfad39so.getCFAD39SOG00().setCIndAdptSubThirdParty(pCSES64DOutputRec.getCIndAdptAudThirdParty());
                    cfad39so.getCFAD39SOG00().setCIndAdptSubProcess(pCSES64DOutputRec.getCIndAdptSubProcess());
                    cfad39so.getCFAD39SOG00().setSzCdAdptSubDeterm(pCSES64DOutputRec.getSzCdAdptSubDeterm());
                    cfad39so.getCFAD39SOG00().setTsLastUpdate(pCSES64DOutputRec.getTsLastUpdate());
                    cfad39so.getCFAD39SOG00().setDtDtAdptSubLastInvc(pCSES64DOutputRec.getDtDtAdptSubLastInvc());
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
            
            if (SUCCESS == RetVal) {
                // 
                // (BEGIN): Retrieve DAM: cses37d      Placement simple retrieve
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCSES37DInputRec = new CSES37DI();
                
                pCSES37DOutputRec = new CSES37DO();
                
                pCSES37DInputRec.setArchInputStruct(cfad39si.getArchInputStruct());
                pCSES37DInputRec.setUlIdPlcmtEvent(pCSES64DOutputRec.getUlIdPlcmtEvent());
                rc = cses37dQUERYdam(sqlca, pCSES37DInputRec, pCSES37DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        if (pCSES37DOutputRec.getDtDtPlcmtEnd().year != DateHelper.NULL_DATE) {
                            lRC9 = ARC_UTLCompareDateAndTime((FndInt3date) & cfad39so.getDtWCDDtSystemDate() , (char) 0, (FndInt3date) & pCSES37DOutputRec.getDtDtPlcmtEnd() , (char) 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            if (lRC9 >= 0) {
                                cfad39so.getCFAD39SOG00().setBSysIndGeneric(1);
                            }
                            
                            else {
                                cfad39so.getCFAD39SOG00().setBSysIndGeneric(0);
                            }
                        }
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        //  SIR#20098 - Copy ulIdRsrcFacil retrieve by CSES32D
                        // to ulIdTempResource, an added temporary variable,
                        // to use in following code in CRES04D.
                        ulTempIdResource = pCSES37DOutputRec.getUlIdRsrcFacil();
                        szTempCounty = pCSES37DOutputRec.getSzAddrPlcmtCnty();
                        break;
                        
                        
                        
                    default :
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            if (SUCCESS == RetVal && true != cfad39so.getCFAD39SOG00().getBSysIndGeneric()) {
                cfad39so.setCSysIndContractCurrent(INDICATOR_YES);
                
                // 
                // BEGIN Retrieval for CSEC60D - Contract County by Date
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                
                pCSEC60DInputRec = new CSEC60DI();
                
                pCSEC60DOutputRec = new CSEC60DO();
                
                pCSEC60DInputRec.setUlIdResource(ulTempIdResource);
                pCSEC60DInputRec.setSzCdCncntyCounty(szTempCounty);
                pCSEC60DInputRec.setSzCdCncntyService(Csub45s.ADOPTION);
                pCSEC60DInputRec.setDtSysDtGenericSysdate(cfad39so.getCFAD39SOG00().getDtDtAdptSubEnd());
                rc = csec60dQUERYdam(sqlca, pCSEC60DInputRec, pCSEC60DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        cfad39so.setUlIdContract(pCSEC60DOutputRec.getUlIdContract());
                        
                        //  Call CSEC11D
                        
                        // 
                        // BEGIN Retrieval for CSEC11D - CONTRACT/PERIOD
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        
                        pCSEC11DInputRec = new CSEC11DI();
                        
                        pCSEC11DOutputRec = new CSEC11DO();
                        pCSEC11DInputRec.setUlIdContract(cfad39so.getUlIdContract());
                        pCSEC11DInputRec.setUlNbrCnperPeriod(pCSEC60DOutputRec.getUlNbrCncntyPeriod());
                        
                        //   Get System Date and Time
                        // To get the latest FLOC row.
                        rc = csec11dQUERYdam(sqlca, pCSEC11DInputRec, pCSEC11DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                // 
                                // BEGIN Retrieval for CSEC12D Contract by period
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                
                                pCSEC12DInputRec = new CSEC12DI();
                                
                                pCSEC12DOutputRec = new CSEC12DO();
                                pCSEC12DInputRec.setUlIdContract(cfad39so.getUlIdContract());
                                pCSEC12DInputRec.setUlNbrCnperPeriod(1);
                                
                                //  Call CSEC25D
                                rc = csec12dQUERYdam(sqlca, pCSEC12DInputRec, pCSEC12DOutputRec);
                                
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        cfad39so.setDtDtCnperStart(pCSEC12DOutputRec.getDtDtCnperStart());
                                        
                                        //  Call CMSC42D
                                        
                                        // 
                                        // BEGIN Retrieval for CMSC42D GET MAX PERIOD TERM
                                        // 
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        
                                        pCMSC42DInputRec = new CMSC42DI();
                                        
                                        pCMSC42DOutputRec = new CMSC42DO();
                                        pCMSC42DInputRec.setUlIdContract(cfad39so.getUlIdContract());
                                        rc = cmsc42dQUERYdam(sqlca, pCMSC42DInputRec, pCMSC42DOutputRec);
                                        
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                cfad39so.setDtDtCnperTerm(pCMSC42DOutputRec.getDtDtCnperTerm());
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                        break;
                                        
                                        
                                        // 
                                        // CONTINUE Retrieval for CMSC42D GET MAX PERIOD TERM
                                        // 
                                        
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                                
                                break;
                            case NO_DATA_FOUND:
                                cfad39so.setCSysIndContractCurrent(Cint14s.INDICATOR_NO);
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_FAIL
                                
                                RetVal = SUCCESS;
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = Csub50s.FND_FAIL;
                                
                                // 
                                // (END): CLSS40D -- PAL PUBLIC ASSIST RETRIEVE
                                // 
                                
                                break;
                        }
                        
                        break;
                    case NO_DATA_FOUND:
                        cfad39so.setCSysIndContractCurrent(Cint14s.INDICATOR_NO);
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set RetVal to FND_FAIL
                        
                        RetVal = SUCCESS;
                        
                        // 
                        // (END): CSES48D -- PAL FOLLOWUP RTRV
                        // 
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                }
            }
        }
        
        if (SUCCESS == RetVal) {
            //  Call CRES04D
            
            // 
            // BEGIN Retrieval for CRES04D CAPS RSRC DET SMP
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCRES04DInputRec = new CRES04DI();
            
            pCRES04DOutputRec = new CRES04DO();
            pCRES04DInputRec.setUlIdResource(ulTempIdResource);
            rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    if (null == pCRES04DOutputRec.getSzAddrRsrcStLn1()[0]) {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_FAD_NO_PAYEE_ADDR;
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                    }
                    cfad39so.getCFAD39SOG01().setSzNmResource(pCRES04DOutputRec.getSzNmResource());
                    cfad39so.getCFAD39SOG01().setSzAddrRsrcAddrStLn1(pCRES04DOutputRec.getSzAddrRsrcStLn1());
                    cfad39so.getCFAD39SOG01().setSzAddrRsrcAddrStLn2(pCRES04DOutputRec.getSzAddrRsrcStLn2());
                    cfad39so.getCFAD39SOG01().setSzAddrRsrcAddrCity(pCRES04DOutputRec.getSzAddrRsrcCity());
                    cfad39so.getCFAD39SOG01().setSzAddrRsrcAddrState(pCRES04DOutputRec.getSzCdRsrcState());
                    cfad39so.getCFAD39SOG01().setSzCdFacilityCounty(pCRES04DOutputRec.getSzCdRsrcCnty());
                    cfad39so.getCFAD39SOG01().setSzAddrRsrcAddrZip(pCRES04DOutputRec.getLAddrRsrcZip());
                    
                    //  SIR 21028- Call CSES84D- This is a new DAM that was created
                    // to determine if the home has a business address with a VID.
                    // Previously, the logic determined if the home had a primary
                    // address with a VID.
                    // 
                    // BEGIN Retrieval for Business Address VID
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES84DInputRec = new CSES84DI();
                    
                    pCSES84DOutputRec = new CSES84DO();
                    pCSES84DInputRec.setUlIdResource(ulTempIdResource);
                    
                    rc = cses84dQUERYdam(sqlca, pCSES84DInputRec, pCSES84DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            cfad39so.getCFAD39SOG01().setSzNbrRsrcVid(pCSES84DOutputRec.getSzNbrRsrcAddrVid());
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_FAD_NO_PAYEE_VID;
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                    
                    if (SUCCESS == RetVal) {
                        
                        //  Call CCMN31D
                        // 
                        // BEGIN Retrieval for CCMN31D EMPLOYEE SKILLS
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN31DInputRec = new CCMN31DI();
                        
                        pCCMN31DOutputRec = new CCMN31DO();
                        pCCMN31DInputRec.setUlIdPerson(cfad39si.getUlIdPerson());
                        
                        //  Call CAUD80D
                        rc = ccmn31dQUERYdam(sqlca, pCCMN31DInputRec, pCCMN31DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                // CHECK THE ULROWQTY AND CDEMPSKILL FIELDS IN THE DAM 
                                // WHEN IT IS CREATED
                                for (iLoopCounter = 0;iLoopCounter < pCCMN31DOutputRec.getArchOutputStruct().getUlRowQty() && false == bSkillNotFound;iLoopCounter++) {
                                    
                                    if (0 == pCCMN31DOutputRec.getSzCdEmpSkill_ARRAY().getSzCdEmpSkill(iLoopCounter).compareTo(Csub26s.ADOPTION_SUBSIDY_SPECIALIST)) {
                                        
                                        bSkillNotFound = 1;
                                        cfad39so.setSzCdEmpSkill(pCCMN31DOutputRec.getSzCdEmpSkill_ARRAY().getSzCdEmpSkill(iLoopCounter));
                                    }
                                }
                                
                                //  Call CMSC41D
                                
                                // 
                                // BEGIN Retrieval for CMSC41D CHECK ADPT CONSUMMATED
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCMSC41DInputRec = new CMSC41DI();
                                
                                pCMSC41DOutputRec = new CMSC41DO();
                                pCMSC41DInputRec.setUlIdPerson(cfad39so.getUlIdPerson());
                                pCMSC41DInputRec.setUlIdStage(cfad39si.getUlIdStage());
                                rc = cmsc41dQUERYdam(sqlca, pCMSC41DInputRec, pCMSC41DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        if (rc == WtcHelperConstants.SQL_SUCCESS) {
                                            cfad39so.setSzCdLegalStatStatus(pCMSC41DOutputRec.getSzCdLegalStatStatus());
                                        }
                                        
                                        if (0 != cfad39si.getUlIdEvent() && 0 != Csub45s.EVENT_STATUS_NEW.compareTo(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())) {
                                            // 
                                            // BEGIN Retrieval for CSES64D ADOPTION SUBSIDY RETRIEVE
                                            // 
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCSES64DInputRec = new CSES64DI();
                                            
                                            pCSES64DOutputRec = new CSES64DO();
                                            pCSES64DInputRec.setUlIdEvent(cfad39si.getUlIdEvent());
                                            
                                            rc = cses64dQUERYdam(sqlca, pCSES64DInputRec, pCSES64DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    cfad39so.getCFAD39SOG00().setUlIdAdptSub(pCSES64DOutputRec.getUlIdAdptSub());
                                                    cfad39so.getCFAD39SOG00().setDtDtAdptSubAgreeRetn(pCSES64DOutputRec.getDtDtAdptSubAgreeRetn());
                                                    cfad39so.getCFAD39SOG00().setUlIdAdptSubPayee(pCSES64DOutputRec.getUlIdAdptSubPayee());
                                                    cfad39so.getCFAD39SOG00().setDtDtAdptSubAgreeSent(pCSES64DOutputRec.getDtDtAdptSubAgreeSent());
                                                    cfad39so.getCFAD39SOG00().setDtDtAdptSubAppReturned(pCSES64DOutputRec.getDtDtAdptSubAppReturned());
                                                    cfad39so.getCFAD39SOG00().setDtDtAdptSubAppSent(pCSES64DOutputRec.getDtDtAdptSubAppSent());
                                                    cfad39so.getCFAD39SOG00().setDtDtAdptSubApprvd(pCSES64DOutputRec.getDtDtAdptSubApprvd());
                                                    cfad39so.getCFAD39SOG00().setDtDtAdptSubEffective(pCSES64DOutputRec.getDtDtAdptSubEffective());
                                                    cfad39so.getCFAD39SOG00().setDtDtAdptSubEnd(pCSES64DOutputRec.getDtDtAdptSubEnd());
                                                    cfad39so.getCFAD39SOG00().setSAmtAdptSub(pCSES64DOutputRec.getSAmtAdptSub());
                                                    cfad39so.getCFAD39SOG00().setSzTxtAdptSubRsn(pCSES64DOutputRec.getSzTxtAdptSubRsn());
                                                    cfad39so.getCFAD39SOG00().setSzCdAdptSubCloseRsn(pCSES64DOutputRec.getSzCdAdptSubCloseRsn());
                                                    cfad39so.getCFAD39SOG00().setCIndAdptSubThirdParty(pCSES64DOutputRec.getCIndAdptAudThirdParty());
                                                    cfad39so.getCFAD39SOG00().setCIndAdptSubProcess(pCSES64DOutputRec.getCIndAdptSubProcess());
                                                    cfad39so.getCFAD39SOG00().setSzCdAdptSubDeterm(pCSES64DOutputRec.getSzCdAdptSubDeterm());
                                                    cfad39so.getCFAD39SOG00().setTsLastUpdate(pCSES64DOutputRec.getTsLastUpdate());
                                                    cfad39so.getCFAD39SOG00().setDtDtAdptSubLastInvc(pCSES64DOutputRec.getDtDtAdptSubLastInvc());
                                                    
                                                    
                                                    //  Call CSYS06
                                                    // 
                                                    // BEGIN Retrieval for CSYS06D CNTCT DTL NARR
                                                    // 
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCSYS06DInputRec = new CSYS06DI();
                                                    
                                                    pCSYS06DOutputRec = new CSYS06DO();
                                                    
                                                    pCSYS06DInputRec.setUlIdEvent(pCSES64DOutputRec.getUlIdAdptSub());
                                                    pCSYS06DInputRec.setSzSysTxtTablename(SUB_ELIG_NARR_VIEW);
                                                    
                                                    //  Call CSUB40U
                                                    rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            cfad39so.setBIndBLOBExistsInDatabase(true);
                                                            break;
                                                        case NO_DATA_FOUND:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            //## BEGIN TUX/XML: Declare XML variables
                                                            cfad39so.setBIndBLOBExistsInDatabase(false);
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    
                                                    RetVal = Csub50s.FND_FAIL;
                                                    break;
                                            }
                                        }
                                        
                                        // 
                                        // END Retrieval for CSES64D ADOPTION 
                                        // SUBSIDY RETRIEVE
                                        // 
                                        
                                        
                                        //  else set all date fields from this table to NULL_DATE
                                        // this allows null date to be copied across to the 
                                        // window code, not a "0" as would be retrieved from 
                                        // the table.
                                        else {
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAgreeRetn().day = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAgreeRetn().month = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAgreeRetn().year = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAgreeSent().day = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAgreeSent().month = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAgreeSent().year = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAppReturned().day = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAppReturned().month = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAppReturned().year = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAppSent().day = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAppSent().month = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubAppSent().year = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubApprvd().day = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubApprvd().month = DateHelper.NULL_DATE;
                                            
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubApprvd().year = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubEffective().day = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubEffective().month = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubEffective().year = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubEnd().day = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubEnd().month = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubEnd().year = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubLastInvc().day = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubLastInvc().month = DateHelper.NULL_DATE;
                                            cfad39so.getCFAD39SOG00().getDtDtAdptSubLastInvc().year = DateHelper.NULL_DATE;
                                        }
                                        break;
                                        
                                        
                                        // 
                                        // END Retrieval for CSYS06D CNTCT DTL NARR
                                        // 
                                        
                                        // 
                                        // CONTINUE Retrieval for CSES64D ADOPTION 
                                        // SUBSIDY RETRIEVE
                                        // 
                                        
                                        
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                                break;
                                
                                
                                // 
                                // CONTINUE Retrieval for CMSC41D CHECK ADPT CONSUMMATED
                                // 
                                
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                    break;
                    
                    // 
                    // END Retrieval for CMSC41D CHECK ADPT CONSUMMATED
                    // 
                    
                    // 
                    // CONTINUE Retrieval for CCMN31D EMPLOYEE SKILLS
                    // 
                    
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        /**pOutputMsgSize = ARC_MESSAGE_SIZE(_CFAD39SO,
        _ROWCFAD39SOG00,
        _CFAD39SO__ROWCFAD39SOG00_SIZE,
        pOutputMsg->ArchOutputStruct.ulRowQty);*/
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfad39si.getArchInputStruct() , cfad39so.getArchOutputStruct());
        
        if ((rc == 0) && (RetVal == Csub50s.FND_FAIL)) {
            rc = pServiceStatus.explan_code;
        }
        
        if (RetVal == SUCCESS) {
            
            rc = SUCCESS;
        }
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
                
                //  Call CLSC51D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfad39so;
    }

}
