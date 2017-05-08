package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/***************************************************************************
** Module File:   csub38s.src
**
** Service Name:  csub38s
**
** Description:   This is the retrieval service for 
**                the Legal Action/Outcome window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12Oct95
** 
** Programmer:    Mary Sladewski
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:17:16  $
**                      $Modtime:   30 Mar 1996 00:27:02  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   18Oct95  sladewmf  Initial check-in.
**  12/07/95  WILSONET  SIR#2163 - Inserted a new call to CINV51 in order
**                      to get the IdPerson given the Stage and the Role of
**                      'CLIENT' (CL).  Switch should check for VICTIM (VC)
**                      then VICTIM PERPETRATOR (VP) and then CL.  In APS 
**                      Service Delivery the role is always CL.
**  12/14/95  WILSONET  SIR#2171, 2175, 2178, 2185 - (Search on SIR#2171)
**                      The Retrieve Service was modified to correspond to 
**                      the new window code and to meet standards 
**
**  02/20/96  DYARGR    SIR 3272 - Need to have the CdStageProgram returned
**                      to the client, in case the calling window does not
**                      pass it in.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/
/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub38s {
    public static final String VICTIM = "VC";
    public static final String VICTIM_PERPETRATOR = "VP";
    
    /*
    ** Declare FOUNDATION variables
    */
    public static final String CLIENT = "CL";
    public static final String PRIMARY_CHILD = "PC";
    
    public static final String SUB_CARE = "SUB";
    public static final String ADOPTION = "ADO";
    public static final String FAM_REUNIFICATION = "FRE";
    public static final String FAM_SUBCARE = "FSU";
    public static final String FAM_PRESERVATION = "FPR";
    /* SIR 5043 */
    public static final String INVESTIGATION = "INV";
    
    /* RIOSJA, SIR 19973, SIR 16227 */
    public static final String POST_ADOPT = "PAD";
    public static final String CAPS_PROG_CPS = "CPS";
    public static final String STATUS_NEW = "NEW";
    CSUB38SO CSUB38S(CSUB38SI csub38si) {
        CSUB38SO csub38so = new CSUB38SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i430 = 0;
        int RetVal = SUCCESS;/* SIR#2163 - RetVal added */
        CSES06DI pCSES06DInputRec = null;/* Legal Action simple retrieve */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CSES06DO pCSES06DOutputRec = null;
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        CCMN45DI pCCMN45DInputRec = null;/* Event simple retrieve */
        CCMN45DO pCCMN45DOutputRec = null;
        CCMN44DI pCCMN44DInputRec = null;/* Get NmPersonFull given IdPerson */
        
        CCMN44DO pCCMN44DOutputRec = null;
        CINT21DI pCINT21DInputRec = null;/* Full row retrieval from Stage table */
        
        CINT21DO pCINT21DOutputRec = null;
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_PRFServiceStartTime_TUX(csub38si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(csub38so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*************************************************************************
        ** Call CINT21D to retireve CdStageProgram
        *************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
        pCINT21DInputRec.setUlIdStage(csub38si.getUlIdStage());
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  SIR#2163 - Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                csub38so.setSzCdStageProgram(pCINT21DOutputRec.getSzCdStageProgram());
                if (0 == csub38si.getUlIdEvent()) {
                    if ((0 == INVESTIGATION.compareTo(csub38si.getSzCdStage()) && (0 == CAPS_PROG_CPS.compareTo(pCINT21DOutputRec.getSzCdStageProgram()))) || (0 == FAM_SUBCARE.compareTo(csub38si.getSzCdStage())) || (0 == FAM_REUNIFICATION.compareTo(csub38si.getSzCdStage())) || (0 == FAM_PRESERVATION.compareTo(csub38si.getSzCdStage()))) {
                        break;
                    }
                    
                    else if ((0 == SUB_CARE.compareTo(csub38si.getSzCdStage())) || (0 == ADOPTION.compareTo(csub38si.getSzCdStage())) || (0 == POST_ADOPT.compareTo(csub38si.getSzCdStage()))) {
                        // 
                        // (END): Retrieve DAM: cinv51d     
                        // Get IdPerson given IdStage & Role
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCINV51DInputRec = new CINV51DI();
                        
                        pCINV51DOutputRec = new CINV51DO();
                        pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                        pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                        pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                        
                        
                        //  Call CLSS11D to retrieve the previous version's services.
                        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                // 
                                // (BEGIN): Retrieve DAM: ccmn44d 
                                // Get NmPersonFull given IdPerson
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCCMN44DInputRec = new CCMN44DI();
                                
                                pCCMN44DOutputRec = new CCMN44DO();
                                pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                // GMS -- FINANCIAL ENHANCEMENT
                                switch (rc) {
                                        //   Success Case for Dam CCMND9D
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    // 
                    // (END): Retrieve DAM: cinv51d     
                    // Get IdPerson given IdStage & Role
                    // 
                    
                    //  else CdStageProgram is APS
                    else {
                        // 
                        // (BEGIN): Retrieve DAM: cinv51d(VC)     
                        // Get IdPerson given IdStage & Role
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCINV51DInputRec = new CINV51DI();
                        
                        pCINV51DOutputRec = new CINV51DO();
                        pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                        pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                        pCINV51DInputRec.setSzCdStagePersRole(VICTIM);
                        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                                //  Success Case for Dam CLSC59D
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                
                                // 
                                // (BEGIN): Retrieve DAM: ccmn44d 
                                // Get NmPersonFull given IdPerson
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCCMN44DInputRec = new CCMN44DI();
                                
                                pCCMN44DOutputRec = new CCMN44DO();
                                pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                
                                
                                //  Call CAUD17D.  Update the services for the current
                                // version.
                                rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                        //  Success Case for Dam CINV95D (CIU)
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                break;
                                
                                //  Success Case for Dam CSES66D (CIU)
                            case NO_DATA_FOUND:
                                pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                                pCINV51DInputRec.setSzCdStagePersRole(VICTIM_PERPETRATOR);
                                rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                switch (rc) {
                                        
                                        //  Success Case for Dam CSES68D (CIU)
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                        csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                        
                                        // 
                                        // (BEGIN): Retrieve DAM: ccmn44d 
                                        // Get NmPersonFull given IdPerson
                                        // 
                                        //  Allocate memory for DAM Input and Output
                                        // Structures
                                        pCCMN44DInputRec = new CCMN44DI();
                                        
                                        pCCMN44DOutputRec = new CCMN44DO();
                                        pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                        pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                        switch (rc) {
                                                
                                                
                                                //  SQL Not Found Case for Dam CSES68D (CIU)
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                break;
                                        }
                                        break;
                                        
                                        //  Success Case for Dam CSES66D (CIU)
                                    case NO_DATA_FOUND:
                                        pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                        pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                                        pCINV51DInputRec.setSzCdStagePersRole(CLIENT);
                                        
                                        
                                        //  Call CLSS37D to retrieve the previous versions
                                        // counties.
                                        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                        
                                        // Analyze error code
                                        switch (rc) {
                                                
                                                //  Success Case for Dam CSES68D (CIU)
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                                
                                                csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                                
                                                // 
                                                // (BEGIN): Retrieve DAM: ccmn44d 
                                                // Get NmPersonFull given IdPerson
                                                // 
                                                //  Allocate memory for DAM Input and 
                                                // Output Structures
                                                pCCMN44DInputRec = new CCMN44DI();
                                                
                                                pCCMN44DOutputRec = new CCMN44DO();
                                                
                                                
                                                pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                                
                                                pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                                rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                        
                                                        
                                                        //  SQL Not Found Case for Dam CSES68D (CIU)
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        //  In this case SQL_NOT_FOUND, a data base access
                                                        // error has really occured, since a previously
                                                        // locked version must have services before is can be
                                                        // saved as locked and the services of a locked
                                                        // version may not be deleted.
                                                        // Thus, if this case occurs, the database
                                                        // couldn't find the rows and should be processed
                                                        // as a save failed.
                                                        
                                                        csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                                        // 
                                                        // (END): Retrieve DAM: ccmn44d      Get NmPersonFull given IdPerson
                                                        // 
                                                        
                                                        break;
                                                        
                                                    default :
                                                        
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                        break;
                                                }
                                                
                                                break;
                                                
                                            default :
                                                
                                                
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR() break;
                                        }
                                        
                                        break;
                                        // 
                                        // (END): Retrieve DAM: ccmn44d     
                                        // Get NmPersonFull given IdPerson
                                        // 
                                        
                                        
                                        // default for call to CINV51D(CL)
                                    default :
                                        
                                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                }
                                
                                break;
                                
                                
                                //  default for CINV51D(VP)
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        }
                    }
                }
                
                
                //  else -> IdEvent != 0
                else {
                    
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN45DInputRec = new CCMN45DI();
                    
                    pCCMN45DOutputRec = new CCMN45DO();
                    pCCMN45DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                    pCCMN45DInputRec.setUlIdEvent(csub38si.getUlIdEvent());
                    rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                    switch (rc) {
                            
                            //  Success Case for Dam CSES66D (CIU)
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  SIR#2163 - Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            csub38so.getROWCSUB38SOG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                            csub38so.getROWCSUB38SOG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                            csub38so.getROWCSUB38SOG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                            csub38so.getROWCSUB38SOG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                            csub38so.getROWCSUB38SOG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                            csub38so.getROWCSUB38SOG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                            csub38so.getROWCSUB38SOG00().setUlIdEventPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                            csub38so.getROWCSUB38SOG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                            csub38so.getROWCSUB38SOG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                            break;
                            
                            //  Success Case for Dam CSES68D (CIU)
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                            
                            // Set RetVal to FAIL if SQL_NOT_FOUND
                            RetVal = Csub50s.FND_FAIL;
                            
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            // Set RetVal to FAIL if SQL_NOT_FOUND
                            RetVal = Csub50s.FND_FAIL;
                            // 
                            // (END): Retrieve DAM: ccmn44d      Get NmPersonFull given IdPerson
                            // 
                            
                            break;
                            
                    }
                    if ((0 == STATUS_NEW.compareTo(csub38so.getROWCSUB38SOG00().getSzCdEventStatus())) && (RetVal == SUCCESS)) {
                        if ((0 == INVESTIGATION.compareTo(csub38si.getSzCdStage()) && (0 == CAPS_PROG_CPS.compareTo(pCINT21DOutputRec.getSzCdStageProgram()))) || (0 == FAM_SUBCARE.compareTo(csub38si.getSzCdStage())) || (0 == FAM_REUNIFICATION.compareTo(csub38si.getSzCdStage())) || (0 == FAM_PRESERVATION.compareTo(csub38si.getSzCdStage()))) {
                            
                            break;
                        }
                        
                        else if ((0 == SUB_CARE.compareTo(csub38si.getSzCdStage())) || (0 == ADOPTION.compareTo(csub38si.getSzCdStage())) || (0 == POST_ADOPT.compareTo(csub38si.getSzCdStage()))) {
                            // 
                            // (END): Retrieve DAM: cinv51d     
                            // Get IdPerson given IdStage & Role
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCINV51DInputRec = new CINV51DI();
                            
                            pCINV51DOutputRec = new CINV51DO();
                            pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                            pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                            pCINV51DInputRec// SIR 2497
                            .setSzCdStagePersRole(PRIMARY_CHILD);
                            
                            
                            //  Call CAUD08D to add the previous
                            // version's counties to the new
                            // version
                            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                            
                            switch (rc) {
                                    
                                    
                                    //  SQL Not Found Case for Dam CSES68D (CIU)
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    csub38so// SIR 2497
                                    .setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                    csub38so// SIR 2974 (not a typo)
                                    .getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                    // 
                                    // (BEGIN): Retrieve DAM: ccmn44d 
                                    // Get NmPersonFull given IdPerson
                                    // 
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCCMN44DInputRec = new CCMN44DI();
                                    
                                    pCCMN44DOutputRec = new CCMN44DO();
                                    pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                    pCCMN44DInputRec// 2090
                                    .setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                    
                                    
                                    //  Set rc to ARC_SUCCESS
                                    rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                    
                                    switch (rc) {
                                            
                                            //  SQL Not Found Case for DAM CSES66D (CIU)
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            csub38so// 2080
                                            .setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                            break;
                                            
                                        default :
                                            Arcxmlerrors// 2030
                                            .PROCESS_TUX_SQL_ERROR();
                                            
                                            break;
                                    }
                                    // 
                                    // (END): Retrieve DAM: ccmn44d      Get NmPersonFull given IdPerson
                                    // 
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    break;
                            }
                        }
                        
                        //  END else if((SUB_CARE == pInputMsg->szCdStage) || 
                        // (ADOPTION == pInputMsg->szCdStage)  ||
                        // (POST_ADOPT == pInputMsg->szCdStage))
                        
                        
                        //  else CdStageProgram is APS
                        else {
                            // 
                            // (BEGIN): Retrieve DAM: cinv51d(VC)     
                            // Get IdPerson given IdStage & Role
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCINV51DInputRec = new CINV51DI();
                            
                            pCINV51DOutputRec = new CINV51DO();
                            pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                            pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                            
                            pCINV51DInputRec.setSzCdStagePersRole(VICTIM);
                            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                            switch (rc) {
                                    
                                    //  SQL Not Found Case for DAM CINV95D (CIU)
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    csub38so// 2090
                                    .setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                    csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                    
                                    // 
                                    // (BEGIN): Retrieve DAM: ccmn44d 
                                    // Get NmPersonFull given IdPerson
                                    // 
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCCMN44DInputRec = new CCMN44DI();
                                    
                                    pCCMN44DOutputRec = new CCMN44DO();
                                    pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                    pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                    rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                    switch (rc) {
                                            
                                            //  Success Case for DAM CINV95D (CIR)
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            csub38so// 2030
                                            .setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                            // 
                                            // (END): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
                                            // 
                                            
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            
                                            break;
                                    }
                                    break;
                                    
                                    //  Success Case for DAM CSES66D Call (CIR)
                                case NO_DATA_FOUND:
                                    pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                    pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                                    pCINV51DInputRec.setSzCdStagePersRole(VICTIM_PERPETRATOR);
                                    rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                            
                                            //  Success Case for DAM CSES68D (CIR)
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                            csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                            
                                            // 
                                            // (BEGIN): Retrieve DAM: ccmn44d 
                                            // Get NmPersonFull given IdPerson
                                            // 
                                            //  Allocate memory for DAM Input and Output
                                            // Structures
                                            pCCMN44DInputRec = new CCMN44DI();
                                            
                                            pCCMN44DOutputRec = new CCMN44DO();
                                            pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                            pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                            
                                            //  Call DAM
                                            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                            
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                    
                                                    //  SQL Not Found Case for DAM CSES68D (CIR)
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                                    
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                            
                                            break;
                                            
                                            //  SQL Not Found Case for DAM CSES66D Call (CIR)
                                        case NO_DATA_FOUND:
                                            pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                            pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                                            pCINV51DInputRec.setSzCdStagePersRole(CLIENT);
                                            
                                            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                            
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                    
                                                    //  SQL Not Found Case for DAM CINV95D (CIR)
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                                    //   PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
                                                    // SQL error returned from the DAM.
                                                    csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                                    
                                                    
                                                    // 
                                                    // (BEGIN): Retrieve DAM: ccmn44d 
                                                    // Get NmPersonFull given IdPerson
                                                    // 
                                                    //  Allocate memory for DAM Input and 
                                                    // Output Structures
                                                    pCCMN44DInputRec = new CCMN44DI();
                                                    
                                                    pCCMN44DOutputRec = new CCMN44DO();
                                                    
                                                    pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                                    pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                                    rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                                    
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                            //  Success Case for Dam CINV95D (CIO)
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                                            // 
                                                            // (END): Retrieve DAM: ccmn44d      Get NmPersonFull given IdPerson
                                                            // 
                                                            
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            
                                                            break;
                                                    }
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    RetVal = Csub50s.FND_FAIL;
                                                    break;
                                            }
                                            break;
                                            // 
                                            // (END): Retrieve DAM: ccmn44d     
                                            // Get NmPersonFull given IdPerson
                                            // 
                                            
                                            
                                            // default for call to CINV51D(CL)
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    }
                                    break;
                                    
                                    
                                    //  default for CINV51D(VP)
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            }
                        }
                    }
                    
                    
                    //  else if Window Mode is New Using
                    else if (WINDOW_MODE_NEW_USING == csub38si.getCSysIndDamCalled()) {
                        // 
                        // (BEGIN): Retrieve DAM: cses06d     
                        // Legal Action simple retrieve
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES06DInputRec = new CSES06DI();
                        
                        pCSES06DOutputRec = new CSES06DO();
                        pCSES06DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                        pCSES06DInputRec.setUlIdLegalActEvent(csub38si.getUlIdEvent());
                        rc = cses06dQUERYdam(sqlca, pCSES06DInputRec, pCSES06DOutputRec);
                        switch (rc) {
                                
                                //  Success Case for Dam CSES68D (CIO)
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  SIR#2163 - Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                csub38so.getROWCSUB38SOG01().setUlIdLegalActEvent(pCSES06DOutputRec.getUlIdLegalActEvent());
                                csub38so.getROWCSUB38SOG01().setTsLastUpdate(pCSES06DOutputRec.getTsLastUpdate());
                                
                                csub38so.getROWCSUB38SOG01().setUlIdPerson(pCSES06DOutputRec.getUlIdPerson());
                                //  unsigned short  rc=0;
                                
                                csub38so.getROWCSUB38SOG01().setDtDtLegalActDateFiled(pCSES06DOutputRec.getDtDtLegalActDateFiled());
                                csub38so.getROWCSUB38SOG01().setDtDtLegalActOutcomeDt(pCSES06DOutputRec.getDtDtLegalActOutcomeDt());
                                csub38so.getROWCSUB38SOG01().setCIndLegalActDocsNCase(pCSES06DOutputRec.getCIndLegalActDocsNCase());
                                csub38so.getROWCSUB38SOG01().setSzCdLegalActAction(pCSES06DOutputRec.getSzCdLegalActAction());
                                csub38so.getROWCSUB38SOG01().setSzCdLegalActActnSubtype(pCSES06DOutputRec.getSzCdLegalActActnSubtype());
                                csub38so.getROWCSUB38SOG01().setSzCdLegalActOutcome(pCSES06DOutputRec.getSzCdLegalActOutcome());
                                csub38so.getROWCSUB38SOG01().setSzTxtLegalActComment(pCSES06DOutputRec.getSzTxtLegalActComment());
                                
                                // 
                                // End Call to CSES69D
                                // 
                                
                                
                                
                                
                                else if ((0 == SUB_CARE.compareTo(csub38si.getSzCdStage())) || (0 == ADOPTION.compareTo(csub38si.getSzCdStage())) || (0 == POST_ADOPT.compareTo(csub38si.getSzCdStage()))) {
                                    // 
                                    // (END): Retrieve DAM: cinv51d     
                                    // Get IdPerson given IdStage & Role
                                    // 
                                    
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCINV51DInputRec = new CINV51DI();
                                    
                                    pCINV51DOutputRec = new CINV51DO();
                                    pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                    pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                                    pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                                    rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                    switch (rc) {
                                            
                                            //  Success Case for Dam CSEC63D (CIO)
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                            csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                            // 
                                            // (BEGIN): Retrieve DAM: ccmn44d 
                                            // Get NmPersonFull given IdPerson
                                            // 
                                            //  Allocate memory for DAM Input and Output 
                                            // Structures
                                            pCCMN44DInputRec = new CCMN44DI();
                                            
                                            pCCMN44DOutputRec = new CCMN44DO();
                                            pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                            pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                            
                                            // Call DAM
                                            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                    
                                                    //  SQL Not Found Case for Dam CSEC63D (CIO)
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                                    break;
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            break;
                                    }
                                }
                                // 
                                // (END): Retrieve DAM: cinv51d     
                                // Get IdPerson given IdStage & Role
                                // 
                                
                                //  else CdStageProgram is APS
                                else {
                                    // 
                                    // (BEGIN): Retrieve DAM: cinv51d(VC)     
                                    // Get IdPerson given IdStage & Role
                                    // 
                                    
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCINV51DInputRec = new CINV51DI();
                                    
                                    pCINV51DOutputRec = new CINV51DO();
                                    pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                    pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                                    pCINV51DInputRec.setSzCdStagePersRole(VICTIM);
                                    
                                    rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                    switch (rc) {
                                            
                                            //  SQL Not Found Case for Dam CSES68D (CIO)
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                            csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                            
                                            // 
                                            // (BEGIN): Retrieve DAM: ccmn44d 
                                            // Get NmPersonFull given IdPerson
                                            // 
                                            //  Allocate memory for DAM Input and Output 
                                            // Structures
                                            pCCMN44DInputRec = new CCMN44DI();
                                            
                                            pCCMN44DOutputRec = new CCMN44DO();
                                            pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                            
                                            pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                            switch (rc) {
                                                    
                                                    //  SQL Not Found Case for Dam CINV95D (CIO)
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                            break;
                                            
                                            //  Success Case for Dam CSES67D (ACP)
                                        case NO_DATA_FOUND:
                                            pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                            pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                                            pCINV51DInputRec.setSzCdStagePersRole(VICTIM_PERPETRATOR);
                                            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                            
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                    
                                                    //  Success Case for Dam CSES68D (ACP)
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                                    csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                                    
                                                    // 
                                                    // (BEGIN): Retrieve DAM: ccmn44d 
                                                    // Get NmPersonFull given IdPerson
                                                    // 
                                                    //  Allocate memory for DAM Input and Output
                                                    // Structures
                                                    pCCMN44DInputRec = new CCMN44DI();
                                                    
                                                    pCCMN44DOutputRec = new CCMN44DO();
                                                    pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                                    pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                                    rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                                    
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                            
                                                            //  SQL Not Found Case for Dam CSES68D (ACP)
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            break;
                                                    }
                                                    break;
                                                    
                                                    //  SQL Not Found Case for Dam CSES67D (ACP)
                                                case NO_DATA_FOUND:
                                                    pCINV51DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                                    pCINV51DInputRec.setUlIdStage(csub38si.getUlIdStage());
                                                    
                                                    pCINV51DInputRec.setSzCdStagePersRole(CLIENT);
                                                    rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                                    
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                            
                                                            //  Success Case for Dam CSES67D (APR)
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            csub38so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                                            csub38so.getROWCSUB38SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                                            
                                                            // 
                                                            // (BEGIN): Retrieve DAM: ccmn44d 
                                                            // Get NmPersonFull given IdPerson
                                                            // 
                                                            //  Allocate memory for DAM Input and 
                                                            // Output Structures
                                                            pCCMN44DInputRec = new CCMN44DI();
                                                            
                                                            pCCMN44DOutputRec = new CCMN44DO();
                                                            pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                                            pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                                            
                                                            //  Call DAM if an Ethnicity is added or deleted
                                                            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                                            
                                                            //  Analyze return code
                                                            switch (rc) {
                                                                    
                                                                    //  Success Case for Dam CSES68D (APR)
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                                                    break;
                                                                    
                                                                default :
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                    break;
                                                            }
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                    break;
                                                    // 
                                                    // (END): Retrieve DAM: ccmn44d     
                                                    // Get NmPersonFull given IdPerson
                                                    // 
                                                    
                                                    
                                                    // default for call to CINV51D(CL)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            }
                                            break;
                                            
                                            
                                            //  default for CINV51D(VP)
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    }
                                }
                                break;
                            default :
                                
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  SIR#2163 - Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                    // 
                    // (END): Retrieve DAM: cses06d     
                    // Legal Action simple retrieve
                    // 
                    
                    //  Else -> window mode is anything but New Using and RetVal = Succ.
                    else if (RetVal == SUCCESS) {
                        // 
                        // (BEGIN): Retrieve DAM: cses06d     
                        // Legal Action simple retrieve
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES06DInputRec = new CSES06DI();
                        
                        pCSES06DOutputRec = new CSES06DO();
                        pCSES06DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                        pCSES06DInputRec.setUlIdLegalActEvent(csub38si.getUlIdEvent());
                        //  Do nothing, the output message just returns success or
                        // failure
                        rc = cses06dQUERYdam(sqlca, pCSES06DInputRec, pCSES06DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                                
                                //  SQL Not Found Case for Dam CSES68D (ACP)
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  SIR#2163 - Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                csub38so.getROWCSUB38SOG01().setUlIdLegalActEvent(pCSES06DOutputRec.getUlIdLegalActEvent());
                                csub38so.getROWCSUB38SOG01().setTsLastUpdate(pCSES06DOutputRec.getTsLastUpdate());
                                csub38so.getROWCSUB38SOG01().setUlIdPerson(pCSES06DOutputRec.getUlIdPerson());
                                csub38so.getROWCSUB38SOG01().setDtDtLegalActDateFiled(pCSES06DOutputRec.getDtDtLegalActDateFiled());
                                csub38so.getROWCSUB38SOG01().setDtDtLegalActOutcomeDt(pCSES06DOutputRec.getDtDtLegalActOutcomeDt());
                                csub38so.getROWCSUB38SOG01().setCIndLegalActDocsNCase(pCSES06DOutputRec.getCIndLegalActDocsNCase());
                                csub38so.getROWCSUB38SOG01().setSzCdLegalActAction(pCSES06DOutputRec.getSzCdLegalActAction());
                                csub38so.getROWCSUB38SOG01().setSzCdLegalActActnSubtype(pCSES06DOutputRec.getSzCdLegalActActnSubtype());
                                csub38so.getROWCSUB38SOG01().setSzCdLegalActOutcome(pCSES06DOutputRec.getSzCdLegalActOutcome());
                                csub38so.getROWCSUB38SOG01().setSzTxtLegalActComment(pCSES06DOutputRec.getSzTxtLegalActComment());
                                
                                // 
                                // (BEGIN): Retrieve DAM: ccmn44d 
                                // Get NmPersonFull given IdPerson
                                // 
                                //  Allocate memory for DAM Input and 
                                // Output Structures
                                pCCMN44DInputRec = new CCMN44DI();
                                
                                pCCMN44DOutputRec = new CCMN44DO();
                                pCCMN44DInputRec.setArchInputStruct(csub38si.getArchInputStruct());
                                pCCMN44DInputRec.setUlIdPerson(csub38so.getROWCSUB38SOG01().getUlIdPerson());
                                
                                rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                
                                
                                //  Analyze return code for CMSC43D
                                switch (rc) {
                                        
                                        //  SQL Not Found Case for Dam CSES67D (ACP)
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub38so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                        break;
                                    default :// default for CSES06D
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  SIR#2163 - Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                    
                }
                break;
            default :// default for CSES06D
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub38si.getArchInputStruct() , csub38so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            if (tpcommit(0) == - 1) {// if they are the same type but one starts on or after the other ends,
                // it's still ok to insert. it's not overlapping
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csub38so;
    }

}
