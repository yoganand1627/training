package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES54DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    csub25s.src
**                                       
** Service Name:   csub25s
**
** Description:   This is the retrieval service 
**                for the Placement Detail window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  21Oct95
** 
** Programmer:    Mary Sladewski
**
** Archive Information: $Revision:   1.7  $
**                      $Date:   30 Oct 1997 13:28:14  $
**                      $Modtime:   30 Oct 1997 10:40:04  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   30Nov95  sladewmf  Initial check-in.
**
**   2/19/96  DYARGR    SIR 3225 - Service never retrieves the workers for
**                      the stage in anything other than NEW or NULL event
**                      status.  Added the call to this dam to happen 
**                      before returning to the client if the bSysIndGeneric
**                      is false. 
**
**  03/18/96  DYARGR    SIR 3910 - We need to return the correct IdPlcmtChild
**                      when in new using mode.    
**
**  07/29/96  ZABIHIN   SIR 21424 - the number of rows in the list box needed
**                      to be 9 rows, but there was only 7, two more rows were
**                      added.            
**  12/17/96  ZABIHIN   SIR 21130 - needed to retrieve the id_event & status
**                      of the stage closure event so that the save
**                      service will invalidate the pendig approval for the 
**                      closure event if Placement info is changed after the 
**                      stage has been submitted for approval.
**                      added ccmn87d to retrieve the id_event
**                      and status of the closure event.
**                      Look at the comments in csub18w, and csub26s   
**    
** 01/19/97   SISSONM   SIR 20371b - added 2 data elements from dam output 
**                      to service output message d.o ->s.o. (category and
**                      emergency placement) 
** 05/29/97     KRD     Removed printf() statements.
** 
** 08/27/97   saravigm  SIR#14169- added Placement Permanent Date field to the
**                      output message of dam cses37d.pc  Look for the comments-
**                      search on SIR#14169.
** 10/30/97   PAULS     SIR 14163 - Added 8 rows to the Placement info LB.
**                      This is in connection with the out of state adoptions
**                      that has to be reflected on the AFCARS report. 
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**
** 04/29/03   Srini     SIR 17076: IMPACT- Added PERF_TIMER_END & return statements 
**						in the 	functions.
**
**  04/30/03  Srini		SIR 17091: Added the error handling to take care of full 
**						table scans for ccmn87dQUERYdam.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
** 06/24/03   Srini     SIR 18501 - Since the error handling is different in IMPACT 
**						than CAPS, in order to have IMPACT function the same as CAPS, 
**						we need to trap for the case where no rows are found.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub25s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PLCMT_ISSUES_NARR = "PLCMT_ISSUES_NARR";
    public static final String PLCMT_DISCHARGE_NARR = "PLCMT_DISCHG_NARR";
    
    /*Symbolic Constrants*/
    
    public static final String PRIMARY_CHILD = "PC";
    public static final String AUTHORIZED = "ALOC";
    
    public static final String STATUS_NEW = "NEW";
    public static final int ISSUES = 0;
    public static final int DISCHARGE = 1;
    public static final String NULL_STRING = "";
    public static final String FOST_ADOPT = "020";
    public static final int INITIAL_PAGE = 1;
    
    /* SIR 21130 - define */
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String CLOSURE_EVENT_TYPE = "CCL";
    CSUB25SO CSUB25S(CSUB25SI csub25si) {
        CSUB25SO csub25so = new CSUB25SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        
        /*
        ** Call CLSS64D
        */
        rc = ARC_UTLCheckServiceBatchBlock("CSUB25S", pServiceStatus);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i423 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        int RetVal = SUCCESS;
        CINT40DI pCINT40DInputRec = null;/* Stage table simple retrieve */
        
        CINT40DO pCINT40DOutputRec = null;
        CCMN45DI pCCMN45DInputRec = null;/* Event simple retrieve */
        
        CCMN45DO pCCMN45DOutputRec = null;
        CSES37DI pCSES37DInputRec = null;/* Placement simple retrieve */
        
        CSES37DO pCSES37DOutputRec = null;
        CSYS06DI pCSYS06DInputRec = null;/* Narrative checks -- retrieve */
        
        CSYS06DO pCSYS06DOutputRec = null;
        CINV51DI pCINV51DInputRec = null;/* Get IdPerson given IdStage & Role   */
        
        CINV51DO pCINV51DOutputRec = null;
        CSEC33DI pCSEC33DInputRec = null;/* Person_loc simple retrieve */
        
        CSEC33DO pCSEC33DOutputRec = null;
        CCMN29DI pCCMN29DInputRec = null;/* Retrieve STF from StagePersonLink */
        
        CCMN29DO pCCMN29DOutputRec = null;
        CRES04DI pCRES04DInputRec = null;/* Caps_resource simple retrieve */
        
        CRES04DO pCRES04DOutputRec = null;
        CRES54DI pCRES54DInputRec = null;/* 13172 -resource_history simple retrieve */
        
        CRES54DO pCRES54DOutputRec = null;
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_PRFServiceStartTime_TUX(csub25si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(csub25so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Ccmn02u.CallCCMN87D(csub25si, csub25so, pServiceStatus);
        
        /*end SIR 21130*/
        
        
        /**************************************************************************
        ** (BEGIN): Retrieve DAM: cint40d     ** Stage table simple retrieve
        **************************************************************************/
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        pCINT40DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(csub25si.getUlIdStage());
        
        
        /*
        ** Call CRES13D - Retreive resource address row(s)
        */
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                csub25so.setUlIdCase(pCINT40DOutputRec.getUlIdCase());
                break;
                
            default :
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        if ((0 < csub25si.getUlIdEvent()) && (SUCCESS == RetVal)) {
            // 
            // (BEGIN): Retrieve DAM: ccmn45d      Event simple retrieve
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCCMN45DInputRec = new CCMN45DI();
            
            pCCMN45DOutputRec = new CCMN45DO();
            pCCMN45DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
            pCCMN45DInputRec.setUlIdEvent(csub25si.getUlIdEvent());
            rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub25so.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                    csub25so.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                    csub25so.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                    csub25so.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                    csub25so.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                    csub25so.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                    csub25so.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                    csub25so.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                    csub25so.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                    
                    if (STATUS_NEW.compareTo(csub25so.getROWCCMN01UIG00().getSzCdEventStatus()) != 0) {
                        // 
                        // (BEGIN): Retrieve DAM: cses37d      Placement simple retrieve
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES37DInputRec = new CSES37DI();
                        
                        pCSES37DOutputRec = new CSES37DO();
                        pCSES37DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
                        pCSES37DInputRec.setUlIdPlcmtEvent(csub25si.getUlIdEvent());
                        
                        rc = cses37dQUERYdam(sqlca, pCSES37DInputRec, pCSES37DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub25so.getCSUB25SOG00().setTsLastUpdate(pCSES37DOutputRec.getTsLastUpdate());
                                csub25so.getCSUB25SOG00().setUlIdPlcmtAdult(pCSES37DOutputRec.getUlIdPlcmtAdult());
                                csub25so.getCSUB25SOG00().setUlIdPlcmtChild(pCSES37DOutputRec.getUlIdPlcmtChild());
                                csub25so.getCSUB25SOG00().setUlIdContract(pCSES37DOutputRec.getUlIdContract());
                                csub25so.getCSUB25SOG00().setUlIdRsrcAgency(pCSES37DOutputRec.getUlIdRsrcAgency());
                                csub25so.getCSUB25SOG00().setUlIdRsrcFacil(pCSES37DOutputRec.getUlIdRsrcFacil());
                                csub25so.getCSUB25SOG00().setSzAddrPlcmtCity(pCSES37DOutputRec.getSzAddrPlcmtCity());
                                csub25so.getCSUB25SOG00().setSzAddrPlcmtCnty(pCSES37DOutputRec.getSzAddrPlcmtCnty());
                                csub25so.getCSUB25SOG00().setSzAddrPlcmtLn1(pCSES37DOutputRec.getSzAddrPlcmtLn1());
                                csub25so.getCSUB25SOG00().setSzAddrPlcmtLn2(pCSES37DOutputRec.getSzAddrPlcmtLn2());
                                
                                csub25so.getCSUB25SOG00().setSzAddrPlcmtSt(pCSES37DOutputRec.getSzAddrPlcmtSt());
                                csub25so.getCSUB25SOG00().setSzAddrPlcmtZip(pCSES37DOutputRec.getSzAddrPlcmtZip());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(0, pCSES37DOutputRec.getSzCdPlcmtInfo1());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(1, pCSES37DOutputRec.getSzCdPlcmtInfo2());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(2, pCSES37DOutputRec.getSzCdPlcmtInfo3());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(3, pCSES37DOutputRec.getSzCdPlcmtInfo4());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(4, pCSES37DOutputRec.getSzCdPlcmtInfo5());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(5, pCSES37DOutputRec.getSzCdPlcmtInfo6());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(6, pCSES37DOutputRec.getSzCdPlcmtInfo7());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(7, pCSES37DOutputRec.getSzCdPlcmtInfo8());
                                
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(8, pCSES37DOutputRec.getSzCdPlcmtInfo9());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(9, pCSES37DOutputRec.getSzCdPlcmtInfo10());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(10, pCSES37DOutputRec.getSzCdPlcmtInfo11());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(11, pCSES37DOutputRec.getSzCdPlcmtInfo12());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(12, pCSES37DOutputRec.getSzCdPlcmtInfo13());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(13, pCSES37DOutputRec.getSzCdPlcmtInfo14());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(14, pCSES37DOutputRec.getSzCdPlcmtInfo15());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(15, pCSES37DOutputRec.getSzCdPlcmtInfo16());
                                csub25so.getCSUB25SOG01().getSzCdPlcmtInfo_ARRAY().setSzCdPlcmtInfo(16, pCSES37DOutputRec.getSzCdPlcmtInfo17());
                                csub25so.getCSUB25SOG00().setSzCdPlcmtLivArr(pCSES37DOutputRec.getSzCdPlcmtLivArr());
                                csub25so.getCSUB25SOG00().setSzCdPlcmtRemovalRsn(pCSES37DOutputRec.getSzCdPlcmtRemovalRsn());
                                csub25so.getCSUB25SOG00().setSzCdPlcmtActPlanned(pCSES37DOutputRec.getSzCdPlcmtActPlanned());
                                csub25so.getCSUB25SOG00().setSzCdPlcmtType(pCSES37DOutputRec.getSzCdPlcmtType());
                                csub25so.getCSUB25SOG00().setSzCdPlcmtService(pCSES37DOutputRec.getSzCdPlcmtService());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtCaregvrDiscuss(pCSES37DOutputRec.getDtDtPlcmtCaregvrDiscuss());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtChildDiscuss(pCSES37DOutputRec.getDtDtPlcmtChildDiscuss());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtChildPlan(pCSES37DOutputRec.getDtDtPlcmtChildPlan());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtEducLog(pCSES37DOutputRec.getDtDtPlcmtEducLog());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtEnd(pCSES37DOutputRec.getDtDtPlcmtEnd());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtMeddevHistory(pCSES37DOutputRec.getDtDtPlcmtMeddevHistory());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtParentsNotif(pCSES37DOutputRec.getDtDtPlcmtParentsNotif());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtPreplaceVisit(pCSES37DOutputRec.getDtDtPlcmtPreplaceVisit());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtSchoolRecords(pCSES37DOutputRec.getDtDtPlcmtSchoolRecords());
                                csub25so.getCSUB25SOG00().setDtDtPlcmtStart(pCSES37DOutputRec.getDtDtPlcmtStart());
                                csub25so.setDtDtPlcmtPermEff(pCSES37DOutputRec.getDtDtPlcmtPermEff());
                                csub25so.getCSUB25SOG00().setCIndPlcmtContCntct(pCSES37DOutputRec.getCIndPlcmtContCntct());
                                csub25so.getCSUB25SOG00().setCIndPlcmtEducLog(pCSES37DOutputRec.getCIndPlcmtEducLog());
                                csub25so.getCSUB25SOG00().setCIndPlcmetEmerg(pCSES37DOutputRec.getCIndPlcmetEmerg());
                                csub25so.getCSUB25SOG00().setCIndPlcmtNoneApply(pCSES37DOutputRec.getCIndPlcmtNotApplic());
                                csub25so.getCSUB25SOG00().setCIndPlcmtSchoolDoc(pCSES37DOutputRec.getCIndPlcmtSchoolDoc());
                                csub25so.getCSUB25SOG00().setCIndPlcmtWriteHistory(pCSES37DOutputRec.getCIndPlcmtWriteHistory());
                                csub25so.getCSUB25SOG00().setSzNbrPlcmtPhoneExt(pCSES37DOutputRec.getSzNbrPlcmtPhoneExt());
                                
                                csub25so.getCSUB25SOG00().setSzNbrPlcmtTelephone(pCSES37DOutputRec.getSzNbrPlcmtTelephone());
                                csub25so.getCSUB25SOG00().setSzNmPlcmtAgency(pCSES37DOutputRec.getSzNmPlcmtAgency());
                                csub25so.getCSUB25SOG00().setSzNmPlcmtContact(pCSES37DOutputRec.getSzNmPlcmtContact());
                                csub25so.getCSUB25SOG00().setSzNmPlcmtFacil(pCSES37DOutputRec.getSzNmPlcmtFacil());
                                csub25so.getCSUB25SOG00().setSzNmPlcmtPersonFull(pCSES37DOutputRec.getSzNmPlcmtPersonFull());
                                csub25so.getCSUB25SOG00().setSzTxtPlcmtAddrComment(pCSES37DOutputRec.getSzTxtPlcmtAddrComment());
                                csub25so.getCSUB25SOG00().setSzTxtPlcmtDiscussion(pCSES37DOutputRec.getSzTxtPlcmtDiscussion());
                                csub25so.getCSUB25SOG00().setSzTxtPlcmtDocuments(pCSES37DOutputRec.getSzTxtPlcmtDocuments());
                                csub25so.getCSUB25SOG00().setSzTxtPlcmtRemovalRsn(pCSES37DOutputRec.getSzTxtPlcmtRemovalRsn());
                                
                                // 
                                // (BEGIN): Retrieve DAM: csys06d      ISSUES Narrative check
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCSYS06DInputRec = new CSYS06DI();
                                
                                pCSYS06DOutputRec = new CSYS06DO();
                                pCSYS06DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
                                pCSYS06DInputRec.setUlIdEvent(csub25si.getUlIdEvent());
                                pCSYS06DInputRec.setSzSysTxtTablename(PLCMT_ISSUES_NARR);
                                
                                
                                //  Call CSES02D
                                rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub25so.getBIndBLOBExistsInDatabase()[ISSUES] = true;
                                        
                                        
                                        
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub25so.getBIndBLOBExistsInDatabase()[ISSUES] = false;
                                        break;
                                        
                                    default :
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                pCSYS06DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
                                pCSYS06DInputRec.setUlIdEvent(csub25si.getUlIdEvent());
                                pCSYS06DInputRec.setSzSysTxtTablename(PLCMT_DISCHARGE_NARR);
                                rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub25so.getBIndBLOBExistsInDatabase()[DISCHARGE] = true;
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub25so.getBIndBLOBExistsInDatabase()[DISCHARGE] = false;
                                        break;
                                        
                                    default :
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                break;
                                
                            default :
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if ((SUCCESS == RetVal) && (0 != FOST_ADOPT.compareTo(csub25so.getCSUB25SOG00().getSzCdPlcmtType())) && ((0 != csub25so.getCSUB25SOG00().getUlIdRsrcFacil()) || (0 != csub25so.getCSUB25SOG00().getUlIdRsrcAgency()))) {
            // 
            // (BEGIN): Retrieve DAM: cres04d      Caps_resource simple retrieve
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCRES04DInputRec = new CRES04DI();
            
            pCRES04DOutputRec = new CRES04DO();
            pCRES04DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
            if (0 != csub25so.getCSUB25SOG00().getUlIdRsrcAgency()) {
                pCRES04DInputRec.setUlIdResource(csub25so.getCSUB25SOG00().getUlIdRsrcAgency());
            }
            else // Otherwise, use the Facility's IdResource
            {
                pCRES04DInputRec.setUlIdResource(csub25so.getCSUB25SOG00().getUlIdRsrcFacil());
            }
            
            rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        else /*begin SIR 13172*/
        if ((SUCCESS == RetVal) && (0 == FOST_ADOPT.compareTo(csub25so.getCSUB25SOG00().getSzCdPlcmtType())) && ((0 != csub25so.getCSUB25SOG00().getUlIdRsrcFacil()) || (0 != csub25so.getCSUB25SOG00().getUlIdRsrcAgency()))) {
            // 
            // (BEGIN): Retrieve DAM: cres54d      resource_history simple retrieve
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCRES54DInputRec = new CRES54DI();
            
            pCRES54DOutputRec = new CRES54DO();
            pCRES54DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
            if (0 != csub25so.getCSUB25SOG00().getUlIdRsrcAgency()) {
                pCRES54DInputRec.setUlIdResource(csub25so.getCSUB25SOG00().getUlIdRsrcAgency());
            }
            else // Otherwise, use the Facility's IdResource
            {
                pCRES54DInputRec.setUlIdResource(csub25so.getCSUB25SOG00().getUlIdRsrcFacil());
            }
            pCRES54DInputRec.setDtDtPlcmtStart(csub25so.getCSUB25SOG00().getDtDtPlcmtStart());
            
            
            //  Call CSYS06D
            rc = cres54dQUERYdam(sqlca, pCRES54DInputRec, pCRES54DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub25so.setCCdRsrcFaHomeType1(pCRES54DOutputRec.getCCdRshsFaHomeType1());
                    
                    csub25so.setCCdRsrcFaHomeType2(pCRES54DOutputRec.getCCdRshsFaHomeType2());
                    csub25so.setCCdRsrcFaHomeType3(pCRES54DOutputRec.getCCdRshsFaHomeType3());
                    csub25so.setCCdRsrcFaHomeType4(pCRES54DOutputRec.getCCdRshsFaHomeType4());
                    csub25so.setCCdRsrcFaHomeType5(pCRES54DOutputRec.getCCdRshsFaHomeType5());
                    csub25so.setCCdRsrcFaHomeType6(pCRES54DOutputRec.getCCdRshsFaHomeType6());
                    csub25so.setCCdRsrcFaHomeType7(pCRES54DOutputRec.getCCdRshsFaHomeType7());
                    csub25so.setSzCdRsrcCategory(pCRES54DOutputRec.getSzCdRshsCategory());
                    csub25so.setCIndRsrcEmergPlace(pCRES54DOutputRec.getCIndRshsEmergPlace());
                    break;
                case NO_DATA_FOUND:
                    RetVal = Csub50s.FND_FAIL;
                    
                    
                    //  Set rc to ARC_SUCCESS
                    rc = SUCCESS;
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        /*************************
        ** Populate Output Message
        **************************/
        /*
        ** MHMR Phase III Item 6.1 (RIOSJA) - The Initial Face-to-Face
        ** Date and Time can now be changed until the stage is closed or
        ** until a Request for Review is generated. It is changed by
        ** changing the date and time of the earliest Face-to-Face
        ** Assessment Contact.
        */
        if ((!(STATUS_NEW.compareTo(csub25so.getROWCCMN01UIG00().getSzCdEventStatus()) != 0) ||!(NULL_STRING.compareTo(csub25so.getROWCCMN01UIG00().getSzCdEventStatus()) != 0) || 0 != csub25so.getROWCCMN01UIG00().getUlIdStage() && csub25so.getROWCCMN01UIG00().getUlIdStage() != csub25si.getUlIdStage()) && SUCCESS == RetVal) {
            // 
            // (BEGIN): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCINV51DInputRec = new CINV51DI();
            
            pCINV51DOutputRec = new CINV51DO();
            pCINV51DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
            pCINV51DInputRec.setUlIdStage(csub25si.getUlIdStage());
            pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub25so.getCSUB25SOG00().setUlIdPlcmtChild(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                    
                    // 
                    // (BEGIN): Retrieve DAM: csec33d      Person_loc simple retrieve 
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCSEC33DInputRec = new CSEC33DI();
                    
                    pCSEC33DOutputRec = new CSEC33DO();
                    pCSEC33DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
                    pCSEC33DInputRec.setUlIdPerson(csub25so.getCSUB25SOG00().getUlIdPlcmtChild());
                    pCSEC33DInputRec.setSzCdPlocType(AUTHORIZED);
                    pCSEC33DInputRec.setDtScrDtCurrentDate(csub25so.getDtWCDDtSystemDate());
                    rc = csec33dQUERYdam(sqlca, pCSEC33DInputRec, pCSEC33DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            csub25so.setSzCdPlocChild(pCSEC33DOutputRec.getSzCdPlocChild());
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                            
                        default :
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    //  Compare the dates.
                    if (0 < csub25si.getUlIdPerson()) {
                        // 
                        // (BEGIN): Retrieve DAM: ccmn29d      Retrieve STF from StagePersonLink 
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN29DInputRec = new CCMN29DI();
                        
                        pCCMN29DOutputRec = new CCMN29DO();
                        pCCMN29DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
                        pCCMN29DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                        pCCMN29DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN29DO._CCMN29DO__ROWCCMN29DO_SIZE);
                        pCCMN29DInputRec.setUlIdStage(csub25si.getUlIdStage());
                        
                        //  Call DAM
                        rc = ccmn29dQUERYdam(sqlca, pCCMN29DInputRec, pCCMN29DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub25so.setBSysIndGeneric(false);
                                
                                for (i423 = 0;(i423 < pCCMN29DOutputRec.getArchOutputStruct().getUlRowQty()) && (!csub25so.getBSysIndGeneric());i423++) {
                                    //  MHMR Phase III Item 6.1 (RIOSJA) - If the Initial Face-to-Face
                                    // Assessment Contact has been deleted and the date and time of
                                    // the contact was already saved to the database (so that it
                                    // appears on the Investigation Conclusion window), set the data
                                    // change flag to TRUE to alert the window to set the window change
                                    // indicator to TRUE. (This will allow the Initial Face-to-Face
                                    // Date and Time fields on the Investigation Conclusion window
                                    // to be cleared out.) Set the date and time variables to NULL.
                                    if (pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i423).getUlIdPerson() == csub25si.getUlIdPerson()) {
                                        csub25so.setBSysIndGeneric(true);
                                    }
                                }
                                break;
                                
                            default :
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        
        if ((csub25so.getBSysIndGeneric() == false) && (0 < csub25si.getUlIdPerson())) {
            // 
            // (BEGIN): Retrieve DAM: ccmn29d      Retrieve STF from StagePersonLink 
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCCMN29DInputRec = new CCMN29DI();
            
            pCCMN29DOutputRec = new CCMN29DO();
            pCCMN29DInputRec.setArchInputStruct(csub25si.getArchInputStruct());
            pCCMN29DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pCCMN29DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN29DO._CCMN29DO__ROWCCMN29DO_SIZE);
            pCCMN29DInputRec.setUlIdStage(csub25si.getUlIdStage());
            
            rc = ccmn29dQUERYdam(sqlca, pCCMN29DInputRec, pCCMN29DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub25so.setBSysIndGeneric(false);
                    
                    for (i423 = 0;(i423 < pCCMN29DOutputRec.getArchOutputStruct().getUlRowQty()) && (!csub25so.getBSysIndGeneric());i423++) {
                        
                        
                        //  If situation type is specified on input, but the situation ID has
                        // not yet been retrieved (id situation is 0 on input), get the situation
                        // id from cint21d.
                        if (pCCMN29DOutputRec.getROWCCMN29DO_ARRAY().getROWCCMN29DO(i423).getUlIdPerson() == csub25si.getUlIdPerson()) {
                            csub25so.setBSysIndGeneric(true);
                        }
                    }
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub25si.getArchInputStruct() , csub25so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            
            //  Set rc to ARC_SUCCESS
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            // 
            //  If stage specified on input, copy the stage id from the input message
            // to the output message.
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
        return csub25so;
    }

    
    static int CallCCMN87D(CSUB25SI pInputMsg835, CSUB25SO pOutputMsg782, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        
        int rc = 0;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        
        pCCMN87DInputRec.setArchInputStruct(pInputMsg835.getArchInputStruct());
        
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        pCCMN87DInputRec.setUlIdStage(pInputMsg835.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CLOSURE_EVENT_TYPE);
        
        
        /*
        ** Call CLSS03D
        */
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg782.setSzCdEventStatus(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus());
                pOutputMsg782.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pOutputMsg782.setSzCdEventStatus(EVENT_STATUS_NEW);
                
                
                //  Call CMSC58D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

}
