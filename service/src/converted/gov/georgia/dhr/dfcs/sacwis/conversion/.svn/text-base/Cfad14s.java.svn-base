package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD77DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD77DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFAD14S.src
**
** Service Name:  CFAD14S
**
** Description:   This service will first create a non-navigational
**                "Home history altered" event. It will then call a DAM
**                to add/update/delete a resource_history row.
**
**                If the facility LOC for home has changed (was previously
**                a basic group and now contain atleast one of the following:
**                habitative, therapeutic, or medical needs - or - previously
**                contained one of the three aforementioned types and is now
**                only a basic or group), all facility loc rows will be
**                deleted for this resource and the LOC history will be
**                rebuilt.
**
**                If any foster home type has been added or deleted, the
**                primary (or historical, if the child stage has been closed)
**                worker for each child placed in the home during this
**                period will receive a ToDo alerting them of the change.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/03/96
**
** Programmer:    Ramani Vishnubhotla
**
** Archive Information: $Revision:   1.4  $
**                      $Date:   10 Mar 1999 07:27:28  $
**                      $Modtime:   06 Jan 1999 16:13:38  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/19/96  VISHNUR   SIR 3911 - To preserve the Date & Time for the History
**                      rows that are created on the same day and to preserve the
**                      current row to be on the TOP always, saved the effective
**                      and end dates times in Generic1 and 5. If efffective
**                      date is changed, the time for it is set to 12:00 AM.
**                      If the End date is changed it's time is set. If any
**                      other field are changed the retrieved time will be
**                      saved.
**  3/22/96   PURCELA   SIR #4164 - Pass the Worker of the Stage as well
**                      as who the ToDo will be assigned to into the ToDo
**                      Common Function.  The Worker must be passed in
**                      they could be a Historical Primary, in which case
**                      CINV51D should not be executed within CSUB40U.
**  03/27/96  HELMKEST  SIR 4197 - Update the previous LOC History record when
**                      the current Home History record's Home Status is
**                      Inquiry, Recruit, Applicant, or Closed.
**  05/30/96  DENTONRA  SIR 5371 - To do correct date validation inside
**                      caud77d dtRshsEnd needs to be set to max date if it
**                      is null from the window. The table (RESOURCE_HISTORY)
**                      defaults this field to max date but the DAM needs
**                      it to be max date before that time.
**
**  10/14/96  VANDERM   Removed code with set the id of the person worker
**                      to NULL since it was resetting a field which was
**                      populated by SIR 4164.
**  01/06/99  DOUGLACS  SIR#14113 Change NbrRshsOpenSlot to a signed int
**                      so that it negative open slots can be displayed
**                      and user will not get a data access error.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**   7/02/03   JEH	    SIR #18678 - The clss53d query was not incrementing the
**			            page in the while loop, so it was looping infinitely.
**  11/17/03  A.Corley	SIR 22390 LOC Change -- Save LOC 5 to the facility_loc
**                      If the facility is prim med, ther, or habil.
**  12/16/03  A.Corley	SIR 22485 LOC Change -- Save LOC 6 to the facility_loc
**                      If the facility is prim med, ther, or habil.
**  12/16/03  A.Corley	SIR 22686 Only save LOC 5 to the facility_loc
**                      If the facility is prim med, ther, or habil and the home
**                      is group.
**  03/18/05  Hadjimh   SIR#23327. Add a new field to the Home Information page. This new
**                      field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
**                      Adoptive Home checkbox is checked, staff will have to select a
**                      'Certifying Entity'. to indicate the certifying agency
**                      2) This will be a required field when the Non-FPS Adoptive Home
**                      checkbox is checked for a new home. 3) If a user is modifying an
**                      existing Non-FPS Adoptive Home, this new field will be required,
**                      unless the home status is also being changed to 'Pending Closure'
**                      or 'Closed'.
**  09/19/05  yeehp     SIR 23890 - changed level of care to service level
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad14s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int FIRST_RECORD = 0;
    CFAD14SO CFAD14S(CFAD14SI cfad14si) {
        CFAD14SO cfad14so = new CFAD14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  short   rc     = FND_SUCCESS;
        int RetVal = SUCCESS;
        int NbrHistPage = 0;
        char IndMoreHistRows = '\u0000';
        
        char CdPrevLocStatus1 = '\u0000';
        char CdPrevLocStatus2 = '\u0000';
        char CdPrevLocStatus3 = '\u0000';
        char CdPrevLocStatus4 = '\u0000';
        char CdPrevLocStatus5 = '\u0000';
        char CdPrevLocStatus6 = '\u0000';
        
        char CdCurrLocStatus1 = '\u0000';
        char CdCurrLocStatus2 = '\u0000';
        char CdCurrLocStatus3 = '\u0000';
        char CdCurrLocStatus4 = '\u0000';
        char CdCurrLocStatus5 = '\u0000';
        char CdCurrLocStatus6 = '\u0000';
        String szDate = new String();
        
        /* SIR 22686 */
        boolean bGroupHome = false;
        int i211 = 0;
        int j = 0;
        CCMN01UI pCCMN01UInputRec = null;/*SIR#2142*/
        CCMN01UO pCCMN01UOutputRec = null;/* pointer to DAM output record  */
        CAUD77DI pCAUD77DInputRec = null;/* Resource History AUD */
        
        CAUD77DO pCAUD77DOutputRec = null;
        CLSS53DI pCLSS53DInputRec = null;/* Resource History list */
        
        CLSS53DO pCLSS53DOutputRec = null;
        CAUD80DI pCAUD80DInputRec = null;/* Facility LOC AUD */
        
        CAUD80DO pCAUD80DOutputRec = null;
        CAUDB4DI pCAUDB4DInputRec = null;/* Facility LOC AUD - Closed */
        
        CAUDB4DO pCAUDB4DOutputRec = null;
        CLSC51DI pCLSC51DInputRec = null;/* Get the names of the children */
        CLSC51DO pCLSC51DOutputRec = null;/* and the Primary worker        */
        CSUB40UI pTodoCommonInput = null;/* ToDo common function */
        
        
        CSUB40UO pTodoCommonOutput = null;
        
        /*
        ** Confirm that the INV stage is marked as EA
        ** eligible.
        */
        rc = ARC_PRFServiceStartTime_TUX(cfad14si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN01UInputRec = new CCMN01UI();
        
        pCCMN01UOutputRec = new CCMN01UO();
        pCCMN01UInputRec.setArchInputStruct(cfad14si.getArchInputStruct());
        pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(cfad14si.getROWCCMN01UIG00().getSzCdTask());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(cfad14si.getROWCCMN01UIG00().getSzCdEventStatus());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(cfad14si.getROWCCMN01UIG00().getSzCdEventType());
        
        /* SIR 15189 */
        rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(cfad14si.getROWCCMN01UIG00().getUlIdEvent());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(cfad14si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(cfad14si.getROWCCMN01UIG00().getUlIdPerson());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(cfad14si.getROWCCMN01UIG00().getSzTxtEventDescr());
        
        /* Retrieve all principals for the INV stage. */
        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                
                //  Add/Update/Delete resource History
                
                //  Allocate memory for DAM Input and Output Structures
                pCAUD77DInputRec = new CAUD77DI();
                
                pCAUD77DOutputRec = new CAUD77DO();
                pCAUD77DInputRec.setArchInputStruct(cfad14si.getArchInputStruct());
                pCAUD77DInputRec.getArchInputStruct().setCReqFuncCd(cfad14si.getArchInputStruct().getCReqFuncCd());
                pCAUD77DInputRec.setCCdRshsFaHomeType1(cfad14si.getCFAD14SIG00().getCCdRshsFaHomeType1()[0]);
                pCAUD77DInputRec.setCCdRshsFaHomeType2(cfad14si.getCFAD14SIG00().getCCdRshsFaHomeType1()[1]);
                pCAUD77DInputRec.setCCdRshsFaHomeType3(cfad14si.getCFAD14SIG00().getCCdRshsFaHomeType1()[2]);
                pCAUD77DInputRec.setCCdRshsFaHomeType4(cfad14si.getCFAD14SIG00().getCCdRshsFaHomeType1()[3]);
                pCAUD77DInputRec.setCCdRshsFaHomeType5(cfad14si.getCFAD14SIG00().getCCdRshsFaHomeType1()[4]);
                pCAUD77DInputRec.setCCdRshsFaHomeType6(cfad14si.getCFAD14SIG00().getCCdRshsFaHomeType1()[5]);
                pCAUD77DInputRec.setCCdRshsFaHomeType7(cfad14si.getCFAD14SIG00().getCCdRshsFaHomeType1()[6]);
                pCAUD77DInputRec.setDtDtRshsEffective(cfad14si.getCFAD14SIG00().getDtDtRshsEffective());
                
                // SIR#3573: Modify ARC_FRMGetDecode
                // FRMGetDecode is called to retrieve the
                // PLCMT_CODES_TABLE that is linked to the LocAndType.
                // ARC_FRMGetDecode has been changed to
                // ServerSide ARC_UTLGetDecode.
                // Parameters: Decode,Code,CodeLength,CodeTableName
                // SIR#15787. If date of service is after 9/1/2001
                if ((DateHelper.NULL_DATE == cfad14si.getCFAD14SIG00().getDtDtRshsEnd().day) || (DateHelper.NULL_DATE == cfad14si.getCFAD14SIG00().getDtDtRshsEnd().month) || (DateHelper.NULL_DATE == cfad14si.getCFAD14SIG00().getDtDtRshsEnd().month)) {
                    pCAUD77DInputRec.getDtDtRshsEnd().day = DateHelper.ARC_MAX_DAY;
                    pCAUD77DInputRec.getDtDtRshsEnd().month = DateHelper.ARC_MAX_MONTH;
                    pCAUD77DInputRec.getDtDtRshsEnd().year = DateHelper.ARC_MAX_YEAR;
                }
                
                else {
                    pCAUD77DInputRec.setDtDtRshsEnd(cfad14si.getCFAD14SIG00().getDtDtRshsEnd());
                }
                pCAUD77DInputRec.setTmScrTmGeneric1(cfad14si.getCFAD14SIG00().getTmScrTmGeneric1());
                pCAUD77DInputRec.setTmScrTmGeneric5(cfad14si.getCFAD14SIG00().getTmScrTmGeneric5());
                pCAUD77DInputRec.setSzCdRshsCategory(cfad14si.getCFAD14SIG00().getSzCdRshsCategory());
                pCAUD77DInputRec.setSzCdRshsFaHomeStatus(cfad14si.getCFAD14SIG00().getSzCdRshsFaHomeStatus());
                
                pCAUD77DInputRec.setUNbrRshsFacilCapacity(cfad14si.getCFAD14SIG00().getUNbrRshsFacilCapacity());
                pCAUD77DInputRec.setUNbrRshsMaAgeMin(cfad14si.getCFAD14SIG00().getUNbrRshsMaAgeMin());
                
                pCAUD77DInputRec.setUNbrRshsMaAgeMax(cfad14si.getCFAD14SIG00().getUNbrRshsMaAgeMax());
                pCAUD77DInputRec.setUNbrRshsFMAgeMin(cfad14si.getCFAD14SIG00().getUNbrRshsFMAgeMin());
                pCAUD77DInputRec.setUNbrRshsFMAgeMax(cfad14si.getCFAD14SIG00().getUNbrRshsFMAgeMax());
                
                pCAUD77DInputRec.setSzCdRshsClosureRsn(cfad14si.getCFAD14SIG00().getSzCdRshsClosureRsn());
                pCAUD77DInputRec.setSzCdRshsRecmndReopen(cfad14si.getCFAD14SIG00().getSzCdRshsRecmndReopen());
                
                pCAUD77DInputRec.setSzCdRshsInvolClosure(cfad14si.getCFAD14SIG00().getSzCdRshsInvolClosure());
                pCAUD77DInputRec.setSzAddrRshsAttn(cfad14si.getCFAD14SIG00().getSzAddrRshsAttn());
                
                pCAUD77DInputRec.setSzAddrRshsCity(cfad14si.getCFAD14SIG00().getSzAddrRshsCity());
                pCAUD77DInputRec.setSzAddrRshsStLn1(cfad14si.getCFAD14SIG00().getSzAddrRshsStLn1());
                pCAUD77DInputRec.setSzAddrRshsStLn2(cfad14si.getCFAD14SIG00().getSzAddrRshsStLn2());
                
                pCAUD77DInputRec.setLAddrRshsZip(cfad14si.getCFAD14SIG00().getLAddrRshsZip());
                pCAUD77DInputRec.setSzCdRshsCampusType(cfad14si.getCFAD14SIG00().getSzCdRshsCampusType());
                
                pCAUD77DInputRec.setSzCdRshsCertBy(cfad14si.getCFAD14SIG00().getSzCdRshsCertBy());
                pCAUD77DInputRec.setSzCdRshsCnty(cfad14si.getCFAD14SIG00().getSzCdRshsCnty());
                pCAUD77DInputRec.setSzCdRshsEthnicity(cfad14si.getCFAD14SIG00().getSzCdRshsEthnicity());
                pCAUD77DInputRec.setSzCdRshsFacilType(cfad14si.getCFAD14SIG00().getSzCdRshsFacilType());
                pCAUD77DInputRec.setSzCdRshsHub(cfad14si.getCFAD14SIG00().getSzCdRshsHub());
                pCAUD77DInputRec.setSzCdRshsLanguage(cfad14si.getCFAD14SIG00().getSzCdRshsLanguage());
                pCAUD77DInputRec.setSzCdRshsMaintainer(cfad14si.getCFAD14SIG00().getSzCdRshsMaintainer());
                pCAUD77DInputRec.setSzCdRshsMaritalStatus(cfad14si.getCFAD14SIG00().getSzCdRshsMaritalStatus());
                pCAUD77DInputRec.setSzCdRshsOperBy(cfad14si.getCFAD14SIG00().getSzCdRshsOperBy());
                pCAUD77DInputRec.setSzCdRshsOwnership(cfad14si.getCFAD14SIG00().getSzCdRshsOwnership());
                pCAUD77DInputRec.setSzCdRshsPayment(cfad14si.getCFAD14SIG00().getSzCdRshsPayment());
                pCAUD77DInputRec.setSzCdRshsRegion(cfad14si.getCFAD14SIG00().getSzCdRshsRegion());
                pCAUD77DInputRec.setSzCdRshsReligion(cfad14si.getCFAD14SIG00().getSzCdRshsReligion());
                pCAUD77DInputRec.setSzCdRshsRespite(cfad14si.getCFAD14SIG00().getSzCdRshsRespite());
                pCAUD77DInputRec.setSzCdRshsSchDist(cfad14si.getCFAD14SIG00().getSzCdRshsSchDist());
                pCAUD77DInputRec.setSzCdRshsSetting(cfad14si.getCFAD14SIG00().getSzCdRshsSetting());
                pCAUD77DInputRec.setSzCdRshsSourceInquiry(cfad14si.getCFAD14SIG00().getSzCdRshsSourceInquiry());
                pCAUD77DInputRec.setSzCdRshsState(cfad14si.getCFAD14SIG00().getSzCdRshsState());
                pCAUD77DInputRec.setSzCdRshsStatus(cfad14si.getCFAD14SIG00().getSzCdRshsStatus());
                pCAUD77DInputRec.setSzCdRshsType(cfad14si.getCFAD14SIG00().getSzCdRshsType());
                pCAUD77DInputRec.setDtDtRshsCert(cfad14si.getCFAD14SIG00().getDtDtRshsCert());
                pCAUD77DInputRec.setDtDtRshsClose(cfad14si.getCFAD14SIG00().getDtDtRshsClose());
                pCAUD77DInputRec.setDtDtRshsMarriage(cfad14si.getCFAD14SIG00().getDtDtRshsMarriage());
                pCAUD77DInputRec.setUlIdResourceHistory(cfad14si.getCFAD14SIG00().getUlIdResourceHistory());
                pCAUD77DInputRec.setUlIdResource(cfad14si.getCFAD14SIG00().getUlIdResource());
                pCAUD77DInputRec.setUlIdEvent(cfad14si.getCFAD14SIG00().getUlIdEvent());
                pCAUD77DInputRec.setUlIdStage(cfad14si.getCFAD14SIG00().getUlIdStage());
                pCAUD77DInputRec.setCIndRshsCareProv(cfad14si.getCFAD14SIG00().getCIndRshsCareProv());
                pCAUD77DInputRec.setCIndRshsEmergPlace(cfad14si.getCFAD14SIG00().getCIndRshsEmergPlace());
                pCAUD77DInputRec.setCIndRshsInactive(cfad14si.getCFAD14SIG00().getCIndRshsInactive());
                pCAUD77DInputRec.setCIndRshsIndivStudy(cfad14si.getCFAD14SIG00().getCIndRshsIndivStudy());
                pCAUD77DInputRec.setCIndRshsNonPrs(cfad14si.getCFAD14SIG00().getCIndRshsNonPrs());
                pCAUD77DInputRec.setSzCdCertifyEntity(cfad14si.getCFAD14SIG00().getSzCdCertifyEntity());
                pCAUD77DInputRec.setCIndRshsTransport(cfad14si.getCFAD14SIG00().getCIndRshsTransport());
                pCAUD77DInputRec.setDNbrRshsAnnualIncome(cfad14si.getCFAD14SIG00().getDNbrRshsAnnualIncome());
                pCAUD77DInputRec.setLNbrRshsCampusNbr(cfad14si.getCFAD14SIG00().getLNbrRshsCampusNbr());
                pCAUD77DInputRec.setLNbrRshsFacilAcclaim(cfad14si.getCFAD14SIG00().getLNbrRshsFacilAcclaim());
                pCAUD77DInputRec.setUNbrRshsIntChildren(cfad14si.getCFAD14SIG00().getUNbrRshsIntChildren());
                pCAUD77DInputRec.setUNbrRshsIntFeAgeMax(cfad14si.getCFAD14SIG00().getUNbrRshsIntFeAgeMax());
                pCAUD77DInputRec.setUNbrRshsIntFeAgeMin(cfad14si.getCFAD14SIG00().getUNbrRshsIntFeAgeMin());
                pCAUD77DInputRec.setUNbrRshsIntMaAgeMax(cfad14si.getCFAD14SIG00().getUNbrRshsIntMaAgeMax());
                pCAUD77DInputRec.setSNbrRshsOpenSlots(cfad14si.getCFAD14SIG00().getSNbrRshsOpenSlots());
                pCAUD77DInputRec.setSzNbrRshsPhn(cfad14si.getCFAD14SIG00().getSzNbrRshsPhn());
                pCAUD77DInputRec.setLNbrRshsPhoneExtension(cfad14si.getCFAD14SIG00().getLNbrRshsPhoneExtension());
                pCAUD77DInputRec.setSzNbrRshsVid(cfad14si.getCFAD14SIG00().getSzNbrRshsVid());
                pCAUD77DInputRec.setSzNmRshsContact(cfad14si.getCFAD14SIG00().getSzNmRshsContact());
                pCAUD77DInputRec.setSzNmRshsLastUpdate(cfad14si.getCFAD14SIG00().getSzNmRshsLastUpdate());
                pCAUD77DInputRec.setSzNmRshsResource(cfad14si.getCFAD14SIG00().getSzNmRshsResource());
                pCAUD77DInputRec.setSzTxtRshsAddrCmnts(cfad14si.getCFAD14SIG00().getSzTxtRshsAddrCmnts());
                pCAUD77DInputRec.setSzTxtRshsComments(cfad14si.getCFAD14SIG00().getSzTxtRshsComments());
                pCAUD77DInputRec.setCIndRshsWriteHist(cfad14si.getCFAD14SIG00().getCIndRshsWriteHist());
                pCAUD77DInputRec.setTsLastUpdate(cfad14si.getCFAD14SIG00().getTsLastUpdate());
                
                //  Retrieve the most recent 'EA' PERSON_ELIGIBILITY
                // record for the principal, if one exists.
                rc = caud77dAUDdam(sqlca, pCAUD77DInputRec, pCAUD77DOutputRec);
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        if (pCAUD77DOutputRec.getUlSysNbrValidationMsg() == 0) {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                        }
                        
                        else {
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = pCAUD77DOutputRec.getUlSysNbrValidationMsg();
                            
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            //  Populate Output Message
                            // pCINVA9DOutputRec will be returned to the service, so there
                            // is no need to copy the DAM output to the service output.
                            // Same goes for the DAM output architecture header.
                            break;
                        }
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                        
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        if (SUCCESS == RetVal && INDICATOR_YES == cfad14si.getCSysIndLocChange()) {
            //  Because of the difficulty associated in properly maintaining effective
            // dating on the LOC table when Resource History record is changed,
            // the entire LOC history will be deleted and then rebuilt by the three
            // DAMs being called here.
            // Dam CAUD80D first deletes the existing FLOC. Then retrieves the
            // history rows by calling CLSS53D. Loops thru the list to add the
            // FLOC record (if the Home status is not Inquiry or applicant
            // or Recruit), by calling CAUD80D again.
            //  Allocate memory for DAM Input and Output Structures
            pCAUD80DInputRec = new CAUD80DI();
            
            pCAUD80DOutputRec = new CAUD80DO();
            pCAUD80DInputRec.setArchInputStruct(cfad14si.getArchInputStruct());
            pCAUD80DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            pCAUD80DInputRec.setUlIdResource(cfad14si.getCFAD14SIG00().getUlIdResource());
            
            rc = caud80dAUDdam(sqlca, pCAUD80DInputRec, pCAUD80DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                default :// CCMN01U
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
            // SIR#3582: if fost_adopt, check Living Arrangement
            if (RetVal == SUCCESS) {
                
                // Set the previous status to NULL
                
                CdPrevLocStatus1 = (char) (0);
                CdPrevLocStatus2 = (char) (0);
                CdPrevLocStatus3 = (char) (0);
                CdPrevLocStatus4 = (char) (0);
                // SIR 22390
                CdPrevLocStatus5 = (char) (0);
                // SIR 22485
                CdPrevLocStatus6 = (char) (0);
                
                cfad14si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                cfad14si.getArchInputStruct().setUlPageSizeNbr(CLSS53DO._CLSS53DO__ROWCLSS53DO_SIZE);
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSS53DInputRec = new CLSS53DI();
                
                pCLSS53DOutputRec = new CLSS53DO();
                
                
                rc = WtcHelperConstants.SQL_SUCCESS;
                RetVal = WtcHelperConstants.SQL_SUCCESS;
                IndMoreHistRows = 1;
                
                
                //  While more rows are left to process and RetVal is zero,
                // continue loop.
                
                while (IndMoreHistRows == true && (RetVal == WtcHelperConstants.SQL_SUCCESS)) {
                    pCLSS53DInputRec.setArchInputStruct(cfad14si.getArchInputStruct());
                    
                    pCLSS53DInputRec.setUlIdStage(cfad14si.getCFAD14SIG00().getUlIdStage());
                    
                    pCLSS53DInputRec.getArchInputStruct().setUsPageNbr(cfad14si.getArchInputStruct().getUsPageNbr());
                    pCLSS53DInputRec.getArchInputStruct().setUlPageSizeNbr(cfad14si.getArchInputStruct().getUlPageSizeNbr());
                    
                    //  Query the date that will be used as the Start Date
                    // for the new 'EA' PERSON_ELIGIBILITY record for this
                    // principal. We will use the earliest of the following
                    // dates: 1.) Earliest service auth from the INV stage,
                    // 2.) Date of conservatorship removal, or 3.) Date of
                    // stage closure of this INV stage.
                    rc = clss53dQUERYdam(sqlca, pCLSS53DInputRec, pCLSS53DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            IndMoreHistRows = (char) (pCLSS53DOutputRec.getArchOutputStruct().getBMoreDataInd());
                            
                            // Loop thru rows processing
                            
                            for (i211 = 0;i211 < pCLSS53DOutputRec.getArchOutputStruct().getUlRowQty() && SUCCESS == RetVal;i211++) {
                                if (0 == HOME_STATUS_PENDING_APPROVAL.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || 0 == HOME_STATUS_APVD_ACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || 0 == HOME_STATUS_APVD_INACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || 0 == HOME_STATUS_PENDING_CLOSURE.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus())) {
                                    
                                    CdCurrLocStatus1 = (char) (0);
                                    CdCurrLocStatus2 = (char) (0);
                                    CdCurrLocStatus3 = (char) (0);
                                    CdCurrLocStatus4 = (char) (0);
                                    // 22390
                                    CdCurrLocStatus5 = (char) (0);
                                    // 22485
                                    CdCurrLocStatus6 = (char) (0);
                                    // SIR#15787: Added if statement
                                    if (0 == HOME_STATUS_APVD_ACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || CdPrevLocStatus1 == FLOC_ACTIVE) {
                                        CdCurrLocStatus1 = FLOC_ACTIVE;
                                    }
                                    else {
                                        CdCurrLocStatus1 = FLOC_HOLD;
                                    }
                                    //  SIR#23112: if the date is greater than or equal to 09/01/04 use
                                    // New code, otherwise use old codes
                                    if (0 == HOME_STATUS_APVD_ACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || CdPrevLocStatus2 == FLOC_ACTIVE) {
                                        CdCurrLocStatus2 = FLOC_ACTIVE;
                                    }
                                    else {
                                        CdCurrLocStatus2 = FLOC_HOLD;
                                    }
                                    if (pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType1() == FOST_TYPE_GROUP || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType2() == FOST_TYPE_GROUP || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType3() == FOST_TYPE_GROUP || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType4() == FOST_TYPE_GROUP || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType5() == FOST_TYPE_GROUP || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType6() == FOST_TYPE_GROUP || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType7() == FOST_TYPE_GROUP) {
                                        bGroupHome = true;
                                    }
                                    
                                    if (pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType1() == FOST_TYPE_HABIL || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType1() == FOST_TYPE_THER || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType1() == FOST_TYPE_PRIM_MED || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType2() == FOST_TYPE_HABIL || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType2() == FOST_TYPE_THER || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType2() == FOST_TYPE_PRIM_MED || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType3() == FOST_TYPE_HABIL || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType3() == FOST_TYPE_THER || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType3() == FOST_TYPE_PRIM_MED || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType4() == FOST_TYPE_HABIL || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType4() == FOST_TYPE_THER || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType4() == FOST_TYPE_PRIM_MED || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType5() == FOST_TYPE_HABIL || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType5() == FOST_TYPE_THER || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType5() == FOST_TYPE_PRIM_MED || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType6() == FOST_TYPE_HABIL || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType6() == FOST_TYPE_THER || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType6() == FOST_TYPE_PRIM_MED || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType7() == FOST_TYPE_HABIL || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType7() == FOST_TYPE_THER || pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getCCdRshsFaHomeType7() == FOST_TYPE_PRIM_MED) {
                                        if (0 == HOME_STATUS_APVD_ACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || CdPrevLocStatus3 == FLOC_ACTIVE) {
                                            CdCurrLocStatus3 = FLOC_ACTIVE;
                                        }
                                        else {
                                            CdCurrLocStatus3 = FLOC_HOLD;
                                        }
                                        //  SIR#23112: if the date is greater than or equal to 09/01/04 use
                                        // New code, otherwise use old codes
                                        if (0 == HOME_STATUS_APVD_ACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || CdPrevLocStatus4 == FLOC_ACTIVE) {
                                            CdCurrLocStatus4 = FLOC_ACTIVE;
                                        }
                                        else {
                                            CdCurrLocStatus4 = FLOC_HOLD;
                                        }
                                        
                                        
                                        if (0 == HOME_STATUS_APVD_ACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || CdPrevLocStatus5 == FLOC_ACTIVE) {
                                            CdCurrLocStatus5 = FLOC_ACTIVE;
                                        }
                                        else {
                                            CdCurrLocStatus5 = FLOC_HOLD;
                                        }
                                        
                                        if (!bGroupHome) {
                                            
                                            //  Free Memory for DAM Input and Output Structures
                                            
                                            if (0 == HOME_STATUS_APVD_ACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()) || CdPrevLocStatus6 == FLOC_ACTIVE) {
                                                CdCurrLocStatus6 = FLOC_ACTIVE;
                                            }
                                            else {
                                                CdCurrLocStatus6 = FLOC_HOLD;
                                            }
                                        }
                                    }
                                    //  end SIR 13172
                                    
                                    
                                    //  The previous if statement determined if pOutputMsg->szCdPlcmtService
                                    // was not equal to zero.  However, it was a NULL_CHAR that was being
                                    // passed. Need to perform processing if any PlcmtTypes are the following.
                                    // SIR 14938:  Added PACE to the criteria below.
                                    if (CdPrevLocStatus1 != CdCurrLocStatus1 || CdPrevLocStatus2 != CdCurrLocStatus2 || CdPrevLocStatus3 != CdCurrLocStatus3 || CdPrevLocStatus4 != CdCurrLocStatus4 || CdPrevLocStatus5 != CdCurrLocStatus5 || CdPrevLocStatus6 != CdCurrLocStatus6) {
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCAUD80DInputRec = new CAUD80DI();
                                        
                                        pCAUD80DOutputRec = new CAUD80DO();
                                        pCAUD80DInputRec.setArchInputStruct(cfad14si.getArchInputStruct());
                                        pCAUD80DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        
                                        pCAUD80DInputRec.setCCdFlocStatus1(CdCurrLocStatus1);
                                        pCAUD80DInputRec.setCCdFlocStatus2(CdCurrLocStatus2);
                                        pCAUD80DInputRec.setCCdFlocStatus3(CdCurrLocStatus3);
                                        pCAUD80DInputRec.setCCdFlocStatus4(CdCurrLocStatus4);
                                        pCAUD80DInputRec.setCCdFlocStatus5(CdCurrLocStatus5);
                                        pCAUD80DInputRec.setCCdFlocStatus6(CdCurrLocStatus6);
                                        pCAUD80DInputRec.setCCdFlocStatus7(null);
                                        pCAUD80DInputRec.setCCdFlocStatus8(null);
                                        pCAUD80DInputRec.setCCdFlocStatus9(null);
                                        
                                        
                                        pCAUD80DInputRec.setCCdFlocStatus10(null);
                                        pCAUD80DInputRec.setCCdFlocStatus11(null);
                                        pCAUD80DInputRec.setCCdFlocStatus12(null);
                                        pCAUD80DInputRec.setCCdFlocStatus13(null);
                                        pCAUD80DInputRec.setCCdFlocStatus14(null);
                                        pCAUD80DInputRec.setCCdFlocStatus15(null);
                                        pCAUD80DInputRec.setDtDtFlocEffect(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getDtDtRshsEffective());
                                        pCAUD80DInputRec.getDtDtFlocEnd().month = 12;
                                        pCAUD80DInputRec.getDtDtFlocEnd().day = 31;
                                        pCAUD80DInputRec.getDtDtFlocEnd().year = 4712;
                                        pCAUD80DInputRec.setUlIdResource(cfad14si.getCFAD14SIG00().getUlIdResource());
                                        pCAUD80DInputRec.setCIndFlocCancelAudit(INDICATOR_YES);
                                        
                                        // begin SIR#15983. also FosterCareRateChange is used to see if placement start date
                                        // is before or after 9/1/2001 (refer to sir#15787 )
                                        if (bGroupHome) {
                                            pCAUD80DInputRec.setSNbrFlocLevelsOfCare(5);
                                        }
                                        else if (CdCurrLocStatus6 != 0) {
                                            
                                            pCAUD80DInputRec.setSNbrFlocLevelsOfCare(6);
                                        }
                                        else {
                                            pCAUD80DInputRec.setSNbrFlocLevelsOfCare(2);
                                            //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                            
                                            
                                            
                                        }
                                        
                                        rc = caud80dAUDdam(sqlca, pCAUD80DInputRec, pCAUD80DOutputRec);
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Set RetVal to FND_SUCCESS
                                                RetVal = SUCCESS;
                                                
                                                
                                                break;
                                            default :// CAUD80D
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                //  Set RetVal to FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                
                                                break;
                                        }
                                        
                                        
                                        CdPrevLocStatus1 = CdCurrLocStatus1;
                                        CdPrevLocStatus2 = CdCurrLocStatus2;
                                        CdPrevLocStatus3 = CdCurrLocStatus3;
                                        CdPrevLocStatus4 = CdCurrLocStatus4;
                                        // 22390
                                        CdPrevLocStatus5 = CdCurrLocStatus5;
                                        // 22485
                                        CdPrevLocStatus6 = CdCurrLocStatus6;
                                    }
                                }
                                if (FIRST_RECORD != i211) {
                                    if (((0 == HOME_STATUS_CLOSED.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus())) || (0 == HOME_STATUS_INQUIRY.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus())) || (0 == HOME_STATUS_RECRUIT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus())) || (0 == HOME_STATUS_APPLICANT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getSzCdRshsFaHomeStatus()))) && ((0 == HOME_STATUS_APVD_ACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211 - 1).getSzCdRshsFaHomeStatus())) || (0 == HOME_STATUS_APVD_INACT.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211 - 1).getSzCdRshsFaHomeStatus())) || (0 == HOME_STATUS_PENDING_APPROVAL.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211 - 1).getSzCdRshsFaHomeStatus())) || (0 == HOME_STATUS_PENDING_CLOSURE.compareTo(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211 - 1).getSzCdRshsFaHomeStatus())))) {
                                        //  If the status is closed CAUDB4D will be called
                                        // which end dated the latest floc row without inserting
                                        // any rows.
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        
                                        pCAUDB4DInputRec = new CAUDB4DI();
                                        
                                        pCAUDB4DOutputRec = new CAUDB4DO();
                                        pCAUDB4DInputRec.setArchInputStruct(cfad14si.getArchInputStruct());
                                        pCAUDB4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        pCAUDB4DInputRec.setUlIdResource(cfad14si.getCFAD14SIG00().getUlIdResource());
                                        pCAUDB4DInputRec.setDtDtFlocEnd(pCLSS53DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(i211).getDtDtRshsEffective());
                                        rc = caudb4dAUDdam(sqlca, pCAUDB4DInputRec, pCAUDB4DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Set RetVal to FND_SUCCESS
                                                RetVal = SUCCESS;
                                                break;// end SQL_SUCCESS of CLSS58D
                                                
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                //  Set RetVal to FND_SUCCESS
                                                RetVal = SUCCESS;
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                //  Set RetVal to FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                
                                                break;
                                        }
                                        
                                        
                                        CdPrevLocStatus1 = (char) (0);
                                        CdPrevLocStatus2 = (char) (0);
                                        CdPrevLocStatus3 = (char) (0);
                                        CdPrevLocStatus4 = (char) (0);
                                        CdPrevLocStatus5 = (char) (0);
                                        // 22485
                                        CdPrevLocStatus6 = (char) (0);
                                    }
                                }
                            }
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                    cfad14si.getArchInputStruct().getUsPageNbr()++;
                }
            }
        }
        /*
        ** SIR#23112: if the date is greater than or equal to 09/01/04 use
        ** New code, otherwise use old codes
        */
        if (SUCCESS == RetVal && INDICATOR_YES == cfad14si.getCSysIndFosterTypeChange()) {
            cfad14si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            cfad14si.getArchInputStruct().setUlPageSizeNbr(CLSC51DO._CLSC51DO__ROWCLSC51DO_SIZE);
            
            //  Allocate memory for DAM Input and Output Structures
            pCLSC51DInputRec = new CLSC51DI();
            
            pCLSC51DOutputRec = new CLSC51DO();
            
            pCLSC51DInputRec.setArchInputStruct(cfad14si.getArchInputStruct());
            pCLSC51DInputRec.setUlIdRsrcFacil(cfad14si.getCFAD14SIG00().getUlIdResource());
            pCLSC51DInputRec.setSzCdPlcmtActPlanned(PLCMT_ACTUAL);
            pCLSC51DInputRec.setDtDtRshsEffective(cfad14si.getCFAD14SIG00().getDtDtRshsEffective());
            pCLSC51DInputRec.setDtDtRshsEnd(cfad14si.getCFAD14SIG00().getDtDtRshsEnd());
            pCLSC51DInputRec.getArchInputStruct().setUsPageNbr(cfad14si.getArchInputStruct().getUsPageNbr());
            pCLSC51DInputRec.getArchInputStruct().setUlPageSizeNbr(cfad14si.getArchInputStruct().getUlPageSizeNbr());
            rc = clsc51dQUERYdam(sqlca, pCLSC51DInputRec, pCLSC51DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    
                    //  Send ToDo Alert to each worker
                    
                    
                    for (i211 = 0;i211 < pCLSC51DOutputRec.getArchOutputStruct().getUlRowQty() && SUCCESS == RetVal;i211++) {
                        //  Allocate memory for DAM Input and Output Structures
                        
                        pTodoCommonInput = new CSUB40UI();
                        
                        pTodoCommonOutput = new CSUB40UO();
                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD027");
                        ARC_UTLGetDateAndTime(pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i211).getUlIdPerson());
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i211).getUlIdPerson());
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(cfad14si.getROWCCMN01UIG00().getUlIdPerson());
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i211).getUlIdStage());
                        pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfDesc(pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i211).getSzNmPersonFull());
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfDesc() , "'s foster home has had foster types added or deleted.", CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfLongDesc("Foster Home Types were added or deleted for the ");
                        
                        //  Concatenate "'s foster home
                        // has had foster types added or deleted."
                        // to TxtTodoCfDesc
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , cfad14si.getCFAD14SIG00().getSzNmRshsResource() , CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , " home from ", CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        szDate = cfad14si.getCFAD14SIG00().getDtDtRshsEffective().month + "/" + cfad14si.getCFAD14SIG00().getDtDtRshsEffective().day + "/" + cfad14si.getCFAD14SIG00().getDtDtRshsEffective().year;
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , szDate, CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , " to ", CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        szDate = cfad14si.getCFAD14SIG00().getDtDtRshsEnd().month + "/" + cfad14si.getCFAD14SIG00().getDtDtRshsEnd().day + "/" + cfad14si.getCFAD14SIG00().getDtDtRshsEnd().year;
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , szDate, CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , ".  ", CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i211).getSzNmPersonFull() , CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , " was placed in this home during this time.  This may ", CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , "affect the child's billing service level and/or placement.  ", CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        
                        strncat(pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() , "Contact the child's eligibility worker if appropriate.", CSUB40UI.SYS_TXT_TODO_CF_LONG_DESC_LEN);
                        
                        //  Call The CloseStageCase Function
                        rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                default :// CSUB40U
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfad14si.getArchInputStruct() , cfad14so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //  SIR#23112: if the date is greater than or equal to 09/01/04 use
            // New code, otherwise use old codes
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
        return cfad14so;
    }

}
