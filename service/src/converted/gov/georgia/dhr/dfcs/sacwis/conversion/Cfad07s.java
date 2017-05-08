package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS67DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES08DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFAD07S.src
**
** Service Name:  CFAD07S
**
** Description:   Home Demographics Retrieve
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/19/95
**
** Programmer:    Ari Purcell
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   03 Oct 1996 13:13:00  $
**                      $Modtime:   03 Oct 1996 11:18:18  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  2/12/96   WANGSS    Customized Detail Deleted message.
**  2/19/96   PURCELA   SIR #3221 - Removed Retrieval of CdTask from the Event
**                      Table (don't copy it from CCMN45D Output as
**                      the most recent event may have a CdTask that was
**                      created by another window.  This is because the
**                      record retrieved from the Caps_Resource table
**                      will hold the value of the event created most recently
**                      only.
**  4/8/96    PURCELA   SIR #20223 - If the Historical Record is being
**                      retrieved, then pass the Resource Table's stage out
**                      to the Event Group.  This is needed to create the
**                      Report.
**  5/3/96    HELMKEST  SIR 20848 - Correct tempdate2 to subtract 2 days
**                      instead of adding 100 years.
**
**  5/6/96    CRYSTAEP  SIR 20874 - Corrected logic to determine if contract
**                      version has changed less than two days after original
**                      contract.
**
**  5/8/96    CRYSTAEP  SIR 20948 - After the call to DAM CSES80D, set
**                      explan code to FND_SUCCESS instead of
**                      MSG_NO_ROWS_RETURNED. In cases in which
**                      dt_cnper_closure date on the CONTRACT_PERIOD table
**                      is not > than sys date, DAM CSES80D will fail.
**                      This is OK because logic will handle this
**                      situation appropriately.
**                      Due to conversion,the dt_cnper_closure was not being
**                      recorded appropriately. It should have been
**                      set to the date the home closed, and in some cases
**                      it was being set to DtContractCreated + 100 years.
**                      Also corrected logic to
**                      compare dtDtCnperTerm and dtTempDate appropriately.
**  6/25/96   PURCELA   SIR #21680 - Added call to CRES08D to get the school
**                      district decode to pass to the Resource Address
**                      window to be held in the listbox.  This will only
**                      happen if the Address Type is Primary and the
**                      School District code is not NULL.
** 10/03/96   ZABIHIN   SIR 22149 - Event list was populated with the wrong
**                      date. Added code to get the current date after 2 days
**                      is subtracted from it to compare to an old date for
**                      contracts ( new contracts are not supposed to be
**                      created if the county changes whithin 2 days of the
**                      creation of a FAD home) .
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
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**   04/24/2003 DWW     Added the following SQL_NOT_FOUND case. SQL_NOT_FOUND
**                      just means that the resource does not have a phone
**                      number, but this should not halt other data from
**                      coming back to the client
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**						to PROCESS_TUX_RC_ERROR_NOFREE after the
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**						input and output objects before they are allocated
**  09/04/03  A.Corley	SIR 19613 LOC Reduction -- Service Codes 60A-E are now
**                      being reduced to Service Codes 63A - D, updated code to compare and
**                      save with new codes.
**
**  03/28/05  Hadjimh   SIR#23327. Add a new field to the Home Information page. This new
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






public class Cfad07s {
    CFAD07SO CFAD07S(CFAD07SI cfad07si) {
        CFAD07SO cfad07so = new CFAD07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CFAD07S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i207 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        
        
        /*
        ** Declare local variables
        */
        
        //##  long              rc = 0;
        int RetVal = 0;
        //Added rowQty's for ROWCFAD07SOG01, ROWCFAD07SOG02, ROWCFAD07SOG03
        int rowQty1 = 0;
        int rowQty2 = 0;
        int rowQty3 = 0;
        char bIndFosterContractExists = 0;/* Indicates if that the foster
        contract exists SIR #20083 */
        char bIndAdoptContractExists = 0;/* Indicates if that the foster
        contract exists SIR #20083 */
        char bIndUpdateFosterContract = 0;/* Indicates if that the foster
        contract exists SIR #20083 */
        char bIndUpdateAdoptContract = 0;/* Indicates if that the foster
        contract exists SIR #20083 */
        FndInt3date dtTempDate = null;/* Temporary date used for system date
        SIR #20083 */
        FndInt3date dtCurrentDate = null;/* Temporary date used for system date
        SIR #20083 */
        int ulContractQty = 0;/* Counter for contracts returned from
        database SIR #20083 */
        int j = 0;/* Interger used for a looping logic
        SIR #20083 */
        int usCreateContract = 0;/* Indicates the type of contract to
        be created.  SIR #20083 */
        FndInt3date/* Temporary date to subtract 2
        days from sysdate SIR 20083 */
        dtTempDate2 = new FndInt3date( - 2, 0, 0);
        int ulTempIdRsrcAddress = 0;/* Temporary variable to hold the
        ** primary resource address id
        ** SIR 20083
        */
        int ulIdTempContract = 0;/* Holds the contract ID created in
        in the contract AUD SIR 20083 */
        int usCountyRow = 0;/* Holds contract county row index
        SIR 20083 */
        int usUpdateContract = 0;/* Indicates if the contract being
        updated is foster or adoptive
        SIR 20083 */
        boolean testBool = false;/* Boolean indicator used to compare
        dates SIR 20083 */
        int tmpSvcRowQty1 = 0;/* SIR# 15787 */
        
        
        
        
        
        CSES02DI pCSES02DInputRec = null;
        CSES02DO pCSES02DOutputRec = null;
        CLSS48DI pCLSS48DInputRec = null;
        CLSS48DO pCLSS48DOutputRec = null;
        CLSS04DI pCLSS04DInputRec = null;
        CLSS04DO pCLSS04DOutputRec = null;
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        CRES13DI pCRES13DInputRec = null;
        CRES13DO pCRES13DOutputRec = null;
        CRES14DI pCRES14DInputRec = null;
        CRES14DO pCRES14DOutputRec = null;
        CSES41DI pCSES41DInputRec = null;
        CSES41DO pCSES41DOutputRec = null;
        CLSS67DI pCLSS67DInputRec = null;/* SIR #20083 */
        CLSS67DO pCLSS67DOutputRec = null;/* SIR #20083 */
        CSES80DI pCSES80DInputRec = null;/* SIR #20083 */
        CSES80DO pCSES80DOutputRec = null;/* SIR #20083 */
        CSES81DI pCSES81DInputRec = null;/* SIR #20083 */
        CSES81DO pCSES81DOutputRec = null;/* SIR #20083 */
        CLSS13DI pCLSS13DInputRec = null;/* Contract Service retrieval */
        
        /****************************SIR 20083**********************************/
        
        
        
        
        
        CLSS13DO pCLSS13DOutputRec = null;
        CRES08DI pCRES08DInputRec = null;/* SIR #21680 */
        
        CRES08DO pCRES08DOutputRec = null;
        Cfad01a pCFAD01DInputRec = null;/* Working copybook used by the
        ** service for FAD/Contracts
        */
        rc = ARC_PRFServiceStartTime_TUX(cfad07si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cfad07so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (RETRIEVE_RESOURCE == cfad07si.getArchInputStruct().getCReqFuncCd()) {
            
            if (SUCCESS == RetVal) {
                //  Allocate memory for DAM Input and Output Structures
                pCSES41DInputRec = new CSES41DI();
                
                pCSES41DOutputRec = new CSES41DO();
                pCSES41DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
                pCSES41DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
                pCSES41DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                pCSES41DInputRec.setUlIdRsrcFaHomeStage(cfad07si.getUlIdStage());
                
                //  Call DAM
                rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set Return Value to FND_SUCCESS
                        RetVal = SUCCESS;
                        cfad07so.setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsCategory(pCSES41DOutputRec.getSzCdRsrcCategory());
                        
                        //  Exit from service
                        //##          return (FND_SUCCESS);
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsClosureRsn(pCSES41DOutputRec.getSzCdRsrcClosureRsn());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsEthnicity(pCSES41DOutputRec.getSzCdRsrcEthnicity());
                        
                        //  Exit from service
                        //##          return (FND_SUCCESS);
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsFaHomeStatus(pCSES41DOutputRec.getSzCdRsrcFaHomeStatus());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsLanguage(pCSES41DOutputRec.getSzCdRsrcLanguage());
                        cfad07so.getROWCFAD07SOG04().setSzNbrRshsVid(pCSES41DOutputRec.getSzNbrRsrcVid());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsMaritalStatus(pCSES41DOutputRec.getSzCdRsrcMaritalStatus());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsRegion(pCSES41DOutputRec.getSzCdRsrcRegion());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsReligion(pCSES41DOutputRec.getSzCdRsrcReligion());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsRespite(pCSES41DOutputRec.getSzCdRsrcRespite());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsSourceInquiry(pCSES41DOutputRec.getSzCdRsrcSourceInquiry());
                        
                        //##      return (FND_SUCCESS);
                        cfad07so.getROWCFAD07SOG04().setSzNmRshsResource(pCSES41DOutputRec.getSzNmResource());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsState(pCSES41DOutputRec.getSzCdRsrcState());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsCnty(pCSES41DOutputRec.getSzCdRsrcCnty());
                        cfad07so.getROWCFAD07SOG04().setTsLastUpdate(pCSES41DOutputRec.getTsLastUpdate());
                        cfad07so.getROWCFAD07SOG04().setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                        cfad07so.getROWCFAD07SOG04().setDtDtRshsMarriage(pCSES41DOutputRec.getDtDtRsrcMarriage());
                        cfad07so.getROWCFAD07SOG04().setCIndRshsCareProv(pCSES41DOutputRec.getCIndRsrcCareProv());
                        cfad07so.getROWCFAD07SOG04().setCIndRshsIndivStudy(pCSES41DOutputRec.getBIndRsrcIndivStudy());
                        
                        
                        //##    return (FND_SUCCESS);
                        cfad07so.getROWCFAD07SOG04().setCIndRshsNonPrs(pCSES41DOutputRec.getBIndRsrcNonPrs());
                        cfad07so.getROWCFAD07SOG04().setSzCdCertifyEntity(pCSES41DOutputRec.getSzCdCertifyEntity());
                        cfad07so.getROWCFAD07SOG04().setDNbrRshsAnnualIncome(pCSES41DOutputRec.getDNbrRsrcAnnualIncome());
                        cfad07so.getROWCFAD07SOG04().setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntChildren(pCSES41DOutputRec.getUNbrRsrcIntChildren());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntFeAgeMax(pCSES41DOutputRec.getUNbrRsrcIntFeAgeMax());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntFeAgeMin(pCSES41DOutputRec.getUNbrRsrcIntFeAgeMin());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntMaAgeMax(pCSES41DOutputRec.getUNbrRsrcIntMaAgeMax());
                        
                        //##    return (FND_SUCCESS);
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntMaAgeMin(pCSES41DOutputRec.getUNbrRsrcIntMaAgeMin());
                        cfad07so.getROWCFAD07SOG05().setCIndRsrcEmergPlace(pCSES41DOutputRec.getCIndRsrcEmergPlace());
                        cfad07so.getROWCFAD07SOG05().setCIndRsrcTransport(pCSES41DOutputRec.getCIndRsrcTransport());
                        
                        //##    return (FND_SUCCESS);
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcFMAgeMax(pCSES41DOutputRec.getUNbrRsrcFMAgeMax());
                        
                        
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcFMAgeMin(pCSES41DOutputRec.getUNbrRsrcFMAgeMin());
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcMlAgeMax(pCSES41DOutputRec.getUNbrRsrcMlAgeMax());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcMlAgeMin(pCSES41DOutputRec.getUNbrRsrcMlAgeMin());
                        cfad07so.getROWCFAD07SOG05().setSzTxtRsrcComments(pCSES41DOutputRec.getSzTxtRsrcComments());
                        
                        // 
                        // (BEGIN):  Retrieve Event Record
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN45DInputRec = new CCMN45DI();
                        
                        pCCMN45DOutputRec = new CCMN45DO();
                        pCCMN45DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
                        pCCMN45DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
                        pCCMN45DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                        pCCMN45DInputRec.setUlIdEvent(pCSES41DOutputRec.getUlIdRsrcFaHomeEvent());
                        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set Return Value to FND_SUCCESS
                                
                                RetVal = SUCCESS;
                                cfad07so.getROWCFAD07SOG06().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                                cfad07so.getROWCFAD07SOG06().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                                cfad07so.getROWCFAD07SOG06().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                                cfad07so.getROWCFAD07SOG06().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                                cfad07so.getROWCFAD07SOG06().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                                cfad07so.getROWCFAD07SOG06().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                                cfad07so.getROWCFAD07SOG06().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                                
                                cfad07so.getROWCFAD07SOG06().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                                break;
                                
                            default :
                                pServiceStatus.explan_code = FND_ERROR;
                                
                                //  Set Return Value to FND_ERROR
                                
                                RetVal = FND_ERROR;
                                
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        break;
                        
                        
                    default :
                        pServiceStatus.explan_code = FND_ERROR;
                        
                        //  Set Return Value to FND_ERROR
                        RetVal = FND_ERROR;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
        }
        if (RETRIEVE_HISTORY == cfad07si.getArchInputStruct().getCReqFuncCd()) {
            if (SUCCESS == RetVal) {
                //  Allocate memory for DAM Input and Output Structures
                pCSES02DInputRec = new CSES02DI();
                
                pCSES02DOutputRec = new CSES02DO();
                pCSES02DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
                pCSES02DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
                pCSES02DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                pCSES02DInputRec.setUlIdEvent(cfad07si.getUlIdEvent());
                rc = cses02dQUERYdam(sqlca, pCSES02DInputRec, pCSES02DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set Return Value to FND_SUCCESS
                        RetVal = SUCCESS;
                        cfad07so.setUlIdResource(pCSES02DOutputRec.getUlIdResource());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsClosureRsn(pCSES02DOutputRec.getSzCdRshsClosureRsn());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsEthnicity(pCSES02DOutputRec.getSzCdRshsEthnicity());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsLanguage(pCSES02DOutputRec.getSzCdRshsLanguage());
                        
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsMaritalStatus(pCSES02DOutputRec.getSzCdRshsMaritalStatus());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsRegion(pCSES02DOutputRec.getSzCdRshsRegion());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsReligion(pCSES02DOutputRec.getSzCdRshsReligion());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsRespite(pCSES02DOutputRec.getSzCdRshsRespite());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsSourceInquiry(pCSES02DOutputRec.getSzCdRshsSourceInquiry());
                        cfad07so.getROWCFAD07SOG04().setSzNmRshsResource(pCSES02DOutputRec.getSzNmRshsResource());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsState(pCSES02DOutputRec.getSzCdRshsState());
                        cfad07so.getROWCFAD07SOG04().setSzCdRshsCnty(pCSES02DOutputRec.getSzCdRshsCnty());
                        cfad07so.getROWCFAD07SOG04().setUlIdResource(pCSES02DOutputRec.getUlIdResource());
                        cfad07so.getROWCFAD07SOG04().setDtDtRshsMarriage(pCSES02DOutputRec.getDtDtRshsMarriage());
                        cfad07so.getROWCFAD07SOG04().setCIndRshsCareProv(pCSES02DOutputRec.getCIndRshsCareProv());
                        cfad07so.getROWCFAD07SOG04().setCIndRshsIndivStudy(pCSES02DOutputRec.getCIndRshsIndivStudy());
                        cfad07so.getROWCFAD07SOG04().setCIndRshsNonPrs(pCSES02DOutputRec.getCIndRshsNonPrs());
                        cfad07so.getROWCFAD07SOG04().setSzCdCertifyEntity(pCSES02DOutputRec.getSzCdCertifyEntity());
                        cfad07so.getROWCFAD07SOG04().setDNbrRshsAnnualIncome(pCSES02DOutputRec.getDNbrRshsAnnualIncome());
                        
                        cfad07so.getROWCFAD07SOG06().setUlIdStage(pCSES02DOutputRec.getUlIdStage());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntChildren(pCSES02DOutputRec.getUNbrRshsIntChildren());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntFeAgeMax(pCSES02DOutputRec.getUNbrRshsIntFeAgeMax());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntFeAgeMin(pCSES02DOutputRec.getUNbrRshsIntFeAgeMin());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntMaAgeMax(pCSES02DOutputRec.getUNbrRshsIntMaAgeMax());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcIntMaAgeMin(pCSES02DOutputRec.getUNbrRshsIntMaAgeMin());
                        cfad07so.getROWCFAD07SOG05().setCIndRsrcEmergPlace(pCSES02DOutputRec.getCIndRshsEmergPlace());
                        cfad07so.getROWCFAD07SOG05().setCIndRsrcTransport(pCSES02DOutputRec.getCIndRshsTransport());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcFMAgeMax(pCSES02DOutputRec.getUNbrRshsFMAgeMax());
                        
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcFMAgeMin(pCSES02DOutputRec.getUNbrRshsFMAgeMin());
                        
                        //## BEGIN TUX/XML: Declare XML variables
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcMlAgeMax(pCSES02DOutputRec.getUNbrRshsMaAgeMax());
                        cfad07so.getROWCFAD07SOG05().setUNbrRsrcMlAgeMin(pCSES02DOutputRec.getUNbrRshsMaAgeMin());
                        cfad07so.getROWCFAD07SOG05().setSzTxtRsrcComments(pCSES02DOutputRec.getSzTxtRshsComments());
                        break;
                        // It is OK if no rows are found, but the client needs
                        // to know in this situation so it can display a
                        // message saying no characteristics were known on the
                        // date entered.
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = Messages.MSG_FAD_HISTORY_DELETED;
                        
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        pServiceStatus.explan_code = FND_ERROR;
                        
                        //  Set Return Value to FND_ERROR
                        RetVal = FND_ERROR;
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
        }
        /********************************************************************
        ** END CAUD20D
        *********************************************************************/
        
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCLSS48DInputRec = new CLSS48DI();
            
            pCLSS48DOutputRec = new CLSS48DO();
            pCLSS48DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
            pCLSS48DInputRec.setUlIdResource(cfad07so.getUlIdResource());
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            pCLSS48DInputRec.getArchInputStruct().setUlPageSizeNbr(CFAD07SO._CFAD07SO__ROWCFAD07SOG02_SIZE);
            pCLSS48DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            
            //  Call DAM
            rc = clss48dQUERYdam(sqlca, pCLSS48DInputRec, pCLSS48DOutputRec);
            
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set Return Value to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    //  Populate Output Message
                    
                    //  Set fields in CFAD07SOG02 to fields in CLSS48DO
                    //set the rowQty - Srini
                    rowQty2 = pCLSS48DOutputRec.getArchOutputStruct().getUlRowQty();
                    for (i207 = 0;i207 < pCLSS48DOutputRec.getArchOutputStruct().getUlRowQty();i207++) {
                        cfad07so.getROWCFAD07SOG02_ARRAY().getROWCFAD07SOG02(i207).setSzCdRsrcCharChrctr(pCLSS48DOutputRec.getROWCLSS48DO_ARRAY().getROWCLSS48DO(i207).getSzCdRsrcCharChrctr());
                        cfad07so.getROWCFAD07SOG02_ARRAY().getROWCFAD07SOG02(i207).setDtDtRsrcCharDateAdded(pCLSS48DOutputRec.getROWCLSS48DO_ARRAY().getROWCLSS48DO(i207).getDtDtRsrcCharDateAdded());
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set Return Value to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    pServiceStatus.explan_code = FND_ERROR;
                    
                    //  Set Return Value to FND_ERROR
                    RetVal = FND_ERROR;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCLSS04DInputRec = new CLSS04DI();
            
            pCLSS04DOutputRec = new CLSS04DO();
            pCLSS04DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
            pCLSS04DInputRec.getArchInputStruct().setUlPageSizeNbr(CFAD07SO._CFAD07SO__ROWCFAD07SOG03_SIZE);
            pCLSS04DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            pCLSS04DInputRec.setUlIdResource(cfad07so.getUlIdResource());
            rc = clss04dQUERYdam(sqlca, pCLSS04DInputRec, pCLSS04DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set Return Value to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    //  Populate Output Message
                    
                    //  Set fields in CFAD07SOG03 to fields in CLSS04DO
                    //set the rowQty - Srini
                    rowQty3 = pCLSS04DOutputRec.getArchOutputStruct().getUlRowQty();
                    for (i207 = 0;i207 < pCLSS04DOutputRec.getArchOutputStruct().getUlRowQty();i207++) {
                        cfad07so.getROWCFAD07SOG03_ARRAY().getROWCFAD07SOG03(i207).setSzCdFaHomeIntEthnicity(pCLSS04DOutputRec.getROWCLSS04DO_ARRAY().getROWCLSS04DO(i207).getSzCdFaHomeIntEthnicity());
                        cfad07so.getROWCFAD07SOG03_ARRAY().getROWCFAD07SOG03(i207).setTsLastUpdate(pCLSS04DOutputRec.getROWCLSS04DO_ARRAY().getROWCLSS04DO(i207).getTsLastUpdate());
                        rc = ARC_UTLHostToDateAndTime(cfad07so.getROWCFAD07SOG03_ARRAY().getROWCFAD07SOG03(i207).getDtScrDtFaHomeEthnicAdd() , 0, pCLSS04DOutputRec.getROWCLSS04DO_ARRAY().getROWCLSS04DO(i207).getTsLastUpdate() , 0);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set Return Value to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    pServiceStatus.explan_code = FND_ERROR;
                    
                    //  Set Return Value to FND_ERROR
                    RetVal = FND_ERROR;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCRES13DInputRec = new CRES13DI();
            
            pCRES13DOutputRec = new CRES13DO();
            // Process utility function failure
            pCRES13DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
            pCRES13DInputRec.getArchInputStruct().setUlPageSizeNbr(CFAD07SO._CFAD07SO__ROWCFAD07SOG01_SIZE);
            pCRES13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            pCRES13DInputRec.setUlIdResource(cfad07so.getUlIdResource());
            
            //  Call DAM
            rc = cres13dQUERYdam(sqlca, pCRES13DInputRec, pCRES13DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set Return Value to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    //  Populate Output Message
                    
                    //  Set fields in CFAD07SOG01 to fields in CRES13DO
                    //set the rowQty -Srini
                    rowQty1 = pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();
                    for (i207 = 0;i207 < pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();i207++) {
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzAddrRsrcAddrAttn(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzAddrRsrcAddrAttn());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzAddrRsrcAddrCity(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzAddrRsrcAddrCity());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzAddrRsrcAddrStLn1(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzAddrRsrcAddrStLn1());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzAddrRsrcAddrStLn2(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzAddrRsrcAddrStLn2());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzAddrRsrcAddrZip(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzAddrRsrcAddrZip());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzCdFacilityCounty(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzCdFacilityCounty());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzCdRsrcAddrSchDist(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzCdRsrcAddrSchDist());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzCdFacilityState(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzCdFacilityState());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzCdRsrcAddrType(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzCdRsrcAddrType());
                        
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzNbrRsrcAddrVid(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzNbrRsrcAddrVid());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setSzTxtRsrcAddrComments(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getSzTxtRsrcAddrComments());
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setTsLastUpdate(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getTsLastUpdate());
                        // 
                        // Function Prototypes
                        // 
                        
                        cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).setUlIdRsrcAddress(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(i207).getUlIdRsrcAddress());
                        
                        // 
                        // END CAUD17D
                        // 
                        
                        if (0 == RSRC_BUIS_PRIMARY.compareTo(cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).getSzCdRsrcAddrType()) && null != cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).getSzCdRsrcAddrSchDist()[0]) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCRES08DInputRec = new CRES08DI();
                            
                            pCRES08DOutputRec = new CRES08DO();
                            pCRES08DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
                            pCRES08DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
                            pCRES08DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                            pCRES08DInputRec.setSzCdSchDist(cfad07so.getROWCFAD07SOG01_ARRAY().getROWCFAD07SOG01(i207).getSzCdRsrcAddrSchDist());
                            rc = cres08dQUERYdam(sqlca, pCRES08DInputRec, pCRES08DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set Return Value to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    cfad07so.setSzTxtSchDistName(pCRES08DOutputRec.getSzTxtSchDistName());
                                    break;
                                    
                                default :
                                    pServiceStatus.explan_code = FND_ERROR;
                                    
                                    //  Set Return Value to FND_ERROR
                                    RetVal = FND_ERROR;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                    }
                    break;
                    
                default :
                    pServiceStatus.explan_code = FND_ERROR;
                    
                    //  Set Return Value to FND_ERROR
                    RetVal = FND_ERROR;
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCRES14DInputRec = new CRES14DI();
            
            pCRES14DOutputRec = new CRES14DO();
            pCRES14DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
            pCRES14DInputRec.getArchInputStruct().setUlPageSizeNbr(CFAD07SO._CFAD07SO__ROWCFAD07SOG00_SIZE);
            pCRES14DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            pCRES14DInputRec.setUlIdResource(cfad07so.getUlIdResource());
            rc = cres14dQUERYdam(sqlca, pCRES14DInputRec, pCRES14DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pCRES14DOutputRec.getArchOutputStruct().setUlRowQty(0);
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set Return Value to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    rc = 0;
                    break;
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set Return Value to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    //  Populate Output Message
                    
                    //  Set fields in CFAD07SOG00 to fields in CRES14DO
                    
                    for (i207 = 0;i207 < pCRES14DOutputRec.getArchOutputStruct().getUlRowQty();i207++) {
                        cfad07so.getROWCFAD07SOG00_ARRAY().getROWCFAD07SOG00(i207).setSzCdFacilPhoneType(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i207).getSzCdFacilPhoneType());
                        cfad07so.getROWCFAD07SOG00_ARRAY().getROWCFAD07SOG00(i207).setLNbrFacilPhoneNumber(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i207).getLNbrFacilPhoneNumber());
                        cfad07so.getROWCFAD07SOG00_ARRAY().getROWCFAD07SOG00(i207).setLNbrFacilPhoneExtension(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i207).getLNbrFacilPhoneExtension());
                        cfad07so.getROWCFAD07SOG00_ARRAY().getROWCFAD07SOG00(i207).setSzTxtRsrcPhoneComments(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i207).getSzTxtRsrcPhoneComments());
                        cfad07so.getROWCFAD07SOG00_ARRAY().getROWCFAD07SOG00(i207).setTsLastUpdate(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i207).getTsLastUpdate());
                        cfad07so.getROWCFAD07SOG00_ARRAY().getROWCFAD07SOG00(i207).setUlIdRsrcPhone(pCRES14DOutputRec.getROWCRES14DO_ARRAY().getROWCRES14DO(i207).getUlIdRsrcPhone());
                    }
                    cfad07so.getArchOutputStruct().setUlRowQty(i207);
                    
                    break;
                    
                default :
                    pServiceStatus.explan_code = FND_ERROR;
                    
                    //  Set Return Value to FND_ERROR
                    RetVal = FND_ERROR;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        
        /************************************************************************
        ** (END): Retrieve Resource Phone
        ************************************************************************/
        
        /*
        ** SIR 20083:
        ** Begin contract creation/modification process if the save service is
        ** successful up to this point
        */
        /*
        ** Allocate memory for auxilary save service memory Structure
        */
        pCFAD01DInputRec = new Cfad01a();
        if (SUCCESS == RetVal) {
            
            
            // 
            // (BEGIN): CLSS67D - List retrieval of Contract rows for and id resource.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            
            pCLSS67DInputRec = new CLSS67DI();
            
            pCLSS67DOutputRec = new CLSS67DO();
            pCLSS67DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
            pCLSS67DInputRec.setUlIdResource(cfad07so.getUlIdResource());
            pCLSS67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS67DO._CLSS67DO__ROWCLSS67DO_SIZE);
            pCLSS67DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            rc = clss67dQUERYdam(sqlca, pCLSS67DInputRec, pCLSS67DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Populate Output Message
                    
                    //  Set fields in CFAD08SO to fields in CLSS67DO
                    
                    ulContractQty = pCLSS67DOutputRec.getArchOutputStruct().getUlRowQty();
                    
                    
                    //  Loop through all contract rows returned from the previous DAM
                    for (i207 = 0;i207 < ulContractQty;i207++) {
                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulIdContract = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i207).getUlIdContract();
                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulIdCntrctManager = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i207).getUlIdCntrctManager();
                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulIdRsrcAddress = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i207).getUlIdRsrcAddress();
                        
                        // 
                        // (BEGIN) CSES80D: Retrieve Contract Period table information
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES80DInputRec = new CSES80DI();
                        
                        pCSES80DOutputRec = new CSES80DO();
                        pCSES80DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
                        pCSES80DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulIdContract);
                        rc = cses80dQUERYdam(sqlca, pCSES80DInputRec, pCSES80DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm = pCSES80DOutputRec.getDtDtCnperTerm();
                                pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperClosure = pCSES80DOutputRec.getDtDtCnperClosure();
                                pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulNbrCnperPeriod = pCSES80DOutputRec.getUlNbrCnperPeriod();
                                pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCnperStatus = pCSES80DOutputRec.getSzCdCnperStatus();
                                rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                if (pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.year > dtTempDate.year) {
                                    testBool = true;
                                }
                                //  If years are equal and month is greater
                                else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.month > dtTempDate.month)) {
                                    testBool = true;
                                }
                                //  If years and months are equal and day is greater
                                else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.day > dtTempDate.day)) {
                                    testBool = true;
                                }
                                //  If year, month and day are equal
                                else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnperTerm.day == dtTempDate.day)) {
                                    testBool = true;
                                }
                                else {
                                    testBool = false;
                                }
                                if (testBool) {
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i207].cSysIndContractCurrent = 1;
                                }
                                else {
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i207].cSysIndContractCurrent = 0;
                                }
                                
                                RetVal = SUCCESS;
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Call DAM
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                
                                break;
                                
                            default :
                                //  Set RetVal to FND_SUCCESS
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                break;
                        }
                    }
                    
                    // 
                    // (END) CSES80D: Retrieve Contract Period table information
                    // 
                    
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        
        /**************************************************************
        ** END CAUD17D
        ***************************************************************/
        
        /* Beg SIR #15787: Lines 6465 to 6707 is placed instead of
        ** Portion B at the end of this program
        */
        if (SUCCESS == RetVal) {
            
            //  Loop through all contract rows returned from the previous DAMs
            for (i207 = 0;i207 < ulContractQty;i207++) {
                if (pCFAD01DInputRec.ROWCFAD08SIG07[i207].cSysIndContractCurrent) {
                    
                    // 
                    // (BEGIN): CSES81D - Contract Version retrieve for an idContract
                    // , contract period number, and version end date that is greater
                    // than the current date.
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES81DInputRec = new CSES81DI();
                    
                    pCSES81DOutputRec = new CSES81DO();
                    
                    pCSES81DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
                    pCSES81DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulIdContract);
                    pCSES81DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulNbrCnperPeriod);
                    pCSES81DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
                    pCSES81DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                    rc = cses81dQUERYdam(sqlca, pCSES81DInputRec, pCSES81DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulIdCnver = pCSES81DOutputRec.getUlIdCnver();
                            pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulNbrCnverVersion = pCSES81DOutputRec.getUlNbrCnverVersion();
                            pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnverCreate = pCSES81DOutputRec.getDtDtCnverCreate();
                            pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnverEffective = pCSES81DOutputRec.getDtDtCnverEffective();
                            pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnverEnd = pCSES81DOutputRec.getDtDtCnverEnd();
                            
                            // 
                            // (BEGIN): CLSS13D - Retrieve contract service codes for
                            // the contract, period, and version passed to the DAM.
                            // 
                            pCLSS13DInputRec = new CLSS13DI();
                            
                            pCLSS13DOutputRec = new CLSS13DO();
                            pCLSS13DInputRec.setArchInputStruct(cfad07si.getArchInputStruct());
                            pCLSS13DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulIdContract);
                            pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
                            pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                            
                            rc = clss13dQUERYdam(sqlca, pCLSS13DInputRec, pCLSS13DOutputRec);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    tmpSvcRowQty1 = pCLSS13DOutputRec.getArchOutputStruct().getUlRowQty();
                                    for (j = 0;j < pCLSS13DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].tsSysTsLastUpdate5[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getTsLastUpdate();
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulNbrCnsvcVersion[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcVersion();
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulIdCnsvc[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlIdCnsvc();
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulNbrCnsvcLineItem[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcLineItem();
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulNbrCnsvcUnitRate[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcUnitRate();
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].ulAmtCnsvcUnitRateUsed[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlAmtCnsvcUnitRateUsed();
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].szNbrCnsvcUnitType[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getSzNbrCnsvcUnitType();
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCnsvcService[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getSzCdCnsvcService();
                                        if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCncntyService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i207].szCdCncntyService[j]))) {
                                            rc = ARC_UTLGetDateAndTime(cfad07so.getDtSysDtGenericSysdate() , 0);
                                            
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            
                                            dtCurrentDate = dtTempDate;
                                            rc = ARC_UTLAddToDate((FndInt3date) & cfad07so.getDtSysDtGenericSysdate() , (FndInt3date) & dtTempDate2);
                                            
                                            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            
                                            if ((pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnverEffective.year == cfad07so.getDtSysDtGenericSysdate().year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnverEffective.month == cfad07so.getDtSysDtGenericSysdate().month) && (pCFAD01DInputRec.ROWCFAD08SIG07[i207].dtDtCnverEffective.day > cfad07so.getDtSysDtGenericSysdate().day)) {
                                                cfad07so.setBIndEndDateMod(1);
                                            }
                                        }
                                        
                                        
                                        RetVal = SUCCESS;
                                    }
                                    rc = ARC_UTLGetDateAndTime(cfad07so.getDtSysDtGenericSysdate() , 0);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    
                                    
                                    break;
                                    
                                default :
                                    
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    break;
                            }
                            
                            
                            // 
                            // (END): CLSS13D - Retrieve contract service codes for
                            // the contract, period, and version passed to the DAM.
                            // 
                            
                            // Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            break;
                        case NO_DATA_FOUND:
                            
                            break;
                            
                        default :
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            break;
                    }
                }
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfad07si.getArchInputStruct() , cfad07so.getArchOutputStruct());
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        
        return cfad07so;
    }

}
